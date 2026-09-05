package dev.vala.jetbrains.highlighting.syntax;

import com.intellij.lang.ASTNode;
import com.intellij.lang.annotation.AnnotationHolder;
import com.intellij.lang.annotation.HighlightSeverity;
import com.intellij.psi.PsiElement;
import dev.vala.jetbrains.highlighting.ValaHighlighter;
import dev.vala.jetbrains.highlighting.ValaTextAttributeKey;
import dev.vala.jetbrains.parser.psi.ValaTypes;
import dev.vala.jetbrains.parser.psi.impl.ValaMemberAccessImpl;
import dev.vala.jetbrains.parser.psi.impl.ValaMethodCallImpl;
import dev.vala.jetbrains.parser.psi.impl.ValaPrimaryExpressionImpl;
import dev.vala.jetbrains.parser.psi.impl.ValaSimpleNameImpl;
import org.jetbrains.annotations.NotNull;

public final class ValaPrimaryExpressionHighlighting implements ValaHighlighter {
    private static volatile ValaPrimaryExpressionHighlighting instance;

    private ValaPrimaryExpressionHighlighting() {
    }

    public static synchronized ValaPrimaryExpressionHighlighting getInstance() {
        if (instance == null) {
            instance = new ValaPrimaryExpressionHighlighting();
        }

        return instance;
    }

    public void highlight(@NotNull PsiElement psiElement, @NotNull AnnotationHolder annotationHolder) {
        if (psiElement instanceof ValaPrimaryExpressionImpl) {

            PsiElement[] children = psiElement.getChildren();

            highlightMethodCallIdentifiers(children, annotationHolder);
        }
    }

    private void highlightMethodCallIdentifiers(PsiElement[] children, AnnotationHolder annotationHolder) {

        for (int i = 0; i < children.length; i++) {

            int currentPos = i;

            if (children[i] instanceof ValaMethodCallImpl) {
                while (i > 0 && !(children[i] instanceof ValaSimpleNameImpl) && !(children[i] instanceof ValaMemberAccessImpl)) {
                    i--;
                }

                if (children[i] instanceof ValaSimpleNameImpl) {
                    ASTNode identifierNode = children[i].getNode().findChildByType(ValaTypes.IDENTIFIER);

                    if (identifierNode != null) {
                        annotationHolder.newSilentAnnotation(HighlightSeverity.INFORMATION)
                            .range(identifierNode.getTextRange())
                            .textAttributes(ValaTextAttributeKey.METHOD_CALL)
                            .create();
                    }
                }

                if (children[i] instanceof ValaMemberAccessImpl) {
                    ASTNode simpleNameNode = children[i].getNode().findChildByType(ValaTypes.SIMPLE_NAME);

                    if (simpleNameNode != null) {
                        ASTNode identifierNode = simpleNameNode.findChildByType(ValaTypes.IDENTIFIER);

                        if (identifierNode != null) {
                            annotationHolder.newSilentAnnotation(HighlightSeverity.INFORMATION)
                                .range(identifierNode.getTextRange())
                                .textAttributes(ValaTextAttributeKey.METHOD_CALL)
                                .create();
                        }
                    }
                }

                i = currentPos;
            }
        }
    }
}
