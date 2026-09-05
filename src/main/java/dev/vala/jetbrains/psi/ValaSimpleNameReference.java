package dev.vala.jetbrains.psi;

import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiReferenceBase;
import com.intellij.psi.util.PsiTreeUtil;
import dev.vala.jetbrains.parser.psi.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;

public class ValaSimpleNameReference extends PsiReferenceBase<ValaSimpleName> {

    public ValaSimpleNameReference(@NotNull ValaSimpleName element) {
        super(element, element.getIdentifier().getTextRangeInParent());
    }

    @Override
    public @Nullable PsiElement resolve() {
        String name = getElement().getIdentifier().getText();

        PsiElement current = getElement().getParent();

        while (current != null && !(current instanceof PsiFile)) {

            Collection<ValaNamedElement> namedElements = PsiTreeUtil.findChildrenOfType(current, ValaNamedElement.class);

            if (namedElements == null || namedElements.isEmpty()) {
                current = current.getParent();
                continue;
            }

            for (ValaNamedElement namedElement : namedElements) {

                if (!isLocal(namedElement)) {
                    continue;
                }

                if (name.equals(namedElement.getName()) && namedElement.getTextOffset() < getElement().getTextOffset()) {
                    return namedElement;
                }
            }

            for (ValaNamedElement namedElement : namedElements) {

                if (!isField(namedElement)) {
                    continue;
                }

                if (name.equals(namedElement.getName())) {
                    return namedElement;
                }
            }


            current = current.getParent();
        }

        return null;
    }

    private static boolean isLocal(ValaNamedElement namedElement) {
        return PsiTreeUtil.instanceOf(
            namedElement,
            ValaLocalVariable.class,
            ValaConstantDeclaration.class,
            ValaParameter.class,
            ValaForeachStatement.class,
            ValaCatchClause.class,
            ValaLambdaExpressionParam.class
        );
    }

    private static boolean isField(ValaNamedElement namedElement) {
        return namedElement instanceof ValaFieldDeclarationSection;
    }
}
