package dev.vala.jetbrains.highlighting.syntax;

import com.intellij.lang.annotation.AnnotationHolder;
import com.intellij.psi.PsiElement;
import dev.vala.jetbrains.highlighting.ValaHighlighter;
import dev.vala.jetbrains.highlighting.ValaHighlighterUtil;
import dev.vala.jetbrains.highlighting.ValaTextAttributeKey;
import dev.vala.jetbrains.parser.psi.ValaLambdaExpressionParam;
import org.jetbrains.annotations.NotNull;

public final class ValaLambdaExpressionHighlighting implements ValaHighlighter {

    private static volatile ValaLambdaExpressionHighlighting instance;

    private ValaLambdaExpressionHighlighting() {
    }

    public static synchronized ValaLambdaExpressionHighlighting getInstance() {
        if (instance == null) {
            instance = new ValaLambdaExpressionHighlighting();
        }

        return instance;
    }

    public void highlight(@NotNull PsiElement psiElement, @NotNull AnnotationHolder annotationHolder) {
        if (psiElement instanceof ValaLambdaExpressionParam) {
            ValaHighlighterUtil.getInstance()
                .highlightIdentifier(psiElement, annotationHolder, ValaTextAttributeKey.PARAMETER);
        }
    }
}
