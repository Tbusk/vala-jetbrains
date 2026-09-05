package dev.vala.jetbrains.highlighting;

import com.intellij.lang.annotation.AnnotationHolder;
import com.intellij.lang.annotation.Annotator;
import com.intellij.psi.PsiElement;
import dev.vala.jetbrains.highlighting.syntax.ValaArgumentHighlighter;
import dev.vala.jetbrains.highlighting.syntax.ValaAttributeArgumentHighlighter;
import dev.vala.jetbrains.highlighting.syntax.ValaAttributeHighlighter;
import dev.vala.jetbrains.highlighting.syntax.ValaCatchHighlighter;
import dev.vala.jetbrains.highlighting.syntax.ValaClassDeclarationHighlighter;
import dev.vala.jetbrains.highlighting.syntax.ValaConstantDeclarationHighlighter;
import dev.vala.jetbrains.highlighting.syntax.ValaCreationMethodDeclarationHighlighter;
import dev.vala.jetbrains.highlighting.syntax.ValaDelegateDeclarationHighlighter;
import dev.vala.jetbrains.highlighting.syntax.ValaDestructorDeclarationHighlighter;
import dev.vala.jetbrains.highlighting.syntax.ValaEnumDeclarationHighlighter;
import dev.vala.jetbrains.highlighting.syntax.ValaEnumValueHighlighter;
import dev.vala.jetbrains.highlighting.syntax.ValaErrorCodeHighlighter;
import dev.vala.jetbrains.highlighting.syntax.ValaErrorDomainDeclarationHighlighter;
import dev.vala.jetbrains.highlighting.syntax.ValaFieldDeclarationHighlighter;
import dev.vala.jetbrains.highlighting.syntax.ValaForEachHighlighter;
import dev.vala.jetbrains.highlighting.syntax.ValaInterfaceDeclarationHighlighter;
import dev.vala.jetbrains.highlighting.syntax.ValaLambdaExpressionHighlighting;
import dev.vala.jetbrains.highlighting.syntax.ValaLocalVariableDeclarationHighlighter;
import dev.vala.jetbrains.highlighting.syntax.ValaMethodDeclarationHighlighter;
import dev.vala.jetbrains.highlighting.syntax.ValaNamespaceDeclarationHighlighter;
import dev.vala.jetbrains.highlighting.syntax.ValaObjectCreationHighlighter;
import dev.vala.jetbrains.highlighting.syntax.ValaObjectOrArrayCreationExpressionHighlighter;
import dev.vala.jetbrains.highlighting.syntax.ValaParameterHighlighter;
import dev.vala.jetbrains.highlighting.syntax.ValaPrimaryExpressionHighlighting;
import dev.vala.jetbrains.highlighting.syntax.ValaPropertyDeclarationHighlighter;
import dev.vala.jetbrains.highlighting.syntax.ValaSignalDeclarationHighlighter;
import dev.vala.jetbrains.highlighting.syntax.ValaStructDeclarationHighlighter;
import dev.vala.jetbrains.highlighting.syntax.ValaTypeHighlighter;
import dev.vala.jetbrains.highlighting.syntax.ValaTypeParameterHighlighter;
import dev.vala.jetbrains.highlighting.syntax.ValaUsingHighlighter;
import dev.vala.jetbrains.highlighting.syntax.ValaYieldExpressionHighlighter;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * Applies PSI-local syntax highlighting for Vala declarations and a few syntactic usage forms.
 * Highlighters must color the visited element only and must not keep shared state.
 */
public final class ValaSyntaxHighlightingAnnotator implements Annotator {

    private static final List<ValaHighlighter> SYNTAX_HIGHLIGHTERS = List.of(
        ValaParameterHighlighter.getInstance(),
        ValaMethodDeclarationHighlighter.getInstance(),
        ValaSignalDeclarationHighlighter.getInstance(),
        ValaInterfaceDeclarationHighlighter.getInstance(),
        ValaLocalVariableDeclarationHighlighter.getInstance(),
        ValaConstantDeclarationHighlighter.getInstance(),
        ValaAttributeHighlighter.getInstance(),
        ValaAttributeArgumentHighlighter.getInstance(),
        ValaTypeHighlighter.getInstance(),
        ValaObjectCreationHighlighter.getInstance(),
        ValaFieldDeclarationHighlighter.getInstance(),
        ValaObjectOrArrayCreationExpressionHighlighter.getInstance(),
        ValaTypeParameterHighlighter.getInstance(),
        ValaArgumentHighlighter.getInstance(),
        ValaErrorCodeHighlighter.getInstance(),
        ValaEnumValueHighlighter.getInstance(),
        ValaClassDeclarationHighlighter.getInstance(),
        ValaEnumDeclarationHighlighter.getInstance(),
        ValaStructDeclarationHighlighter.getInstance(),
        ValaErrorDomainDeclarationHighlighter.getInstance(),
        ValaNamespaceDeclarationHighlighter.getInstance(),
        ValaDelegateDeclarationHighlighter.getInstance(),
        ValaCreationMethodDeclarationHighlighter.getInstance(),
        ValaPropertyDeclarationHighlighter.getInstance(),
        ValaYieldExpressionHighlighter.getInstance(),
        ValaDestructorDeclarationHighlighter.getInstance(),
        ValaForEachHighlighter.getInstance(),
        ValaCatchHighlighter.getInstance(),
        ValaLambdaExpressionHighlighting.getInstance(),
        ValaUsingHighlighter.getInstance(),
        ValaPrimaryExpressionHighlighting.getInstance()
    );

    /**
     * Highlights the given PSI element using highlighters that match its type.
     *
     * @param psiElement       the element being annotated in the current highlighting pass
     * @param annotationHolder the holder that receives silent highlighting annotations
     */
    @Override
    public void annotate(@NotNull PsiElement psiElement, @NotNull AnnotationHolder annotationHolder) {
        for (ValaHighlighter highlighter : SYNTAX_HIGHLIGHTERS) {
            highlighter.highlight(psiElement, annotationHolder);
        }
    }
}
