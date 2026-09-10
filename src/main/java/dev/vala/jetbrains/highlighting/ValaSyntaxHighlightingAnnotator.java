package dev.vala.jetbrains.highlighting;

import com.intellij.lang.annotation.AnnotationHolder;
import com.intellij.lang.annotation.Annotator;
import com.intellij.lang.annotation.HighlightSeverity;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiReference;
import com.intellij.psi.util.PsiTreeUtil;
import dev.vala.jetbrains.parser.psi.*;

import java.util.List;

import org.jetbrains.annotations.NotNull;


/**
 * Applies PSI-local syntax highlighting for Vala declarations and a few syntactic usage forms.
 * Highlighters must color the visited element only and must not keep shared state.
 */
public final class ValaSyntaxHighlightingAnnotator implements Annotator {

    /**
     * Highlights the given PSI element using highlighters that match its type.
     *
     * @param psiElement       the element being annotated in the current highlighting pass
     * @param annotationHolder the holder that receives silent highlighting annotations
     */
    @Override
    public void annotate(@NotNull PsiElement psiElement, @NotNull AnnotationHolder annotationHolder) {
        highlightDeclarations(psiElement, annotationHolder);
        highlightMisc(psiElement, annotationHolder);

        if (!(psiElement instanceof ValaSimpleName simpleName)) {
            return;
        }

        PsiReference reference = simpleName.getReference();
        PsiElement resolved = reference == null ? null : reference.resolve();

        if (resolved != null) {
            highlightReferences(simpleName, resolved, annotationHolder);
            return;
        }

        if (isCalled(simpleName)) {
            highlight(simpleName.getIdentifier(), annotationHolder, ValaTextAttributeKey.METHOD_CALL);
            return;
        }

        if (simpleName.getIdentifier().getText().matches("^[A-Z_][A-Z0-9_]*$")) {
            highlight(simpleName.getIdentifier(), annotationHolder, ValaTextAttributeKey.CONSTANT);
        }
    }

    private static boolean isCalled(ValaSimpleName simpleName) {
        PsiElement afterName = PsiTreeUtil.skipWhitespacesAndCommentsForward(simpleName);
        if (afterName instanceof ValaMethodCall) {
            return true;
        }

        PsiElement parent = simpleName.getParent();
        if (parent instanceof ValaMemberAccess) {
            PsiElement afterAccess = PsiTreeUtil.skipWhitespacesAndCommentsForward(parent);
            return afterAccess instanceof ValaMethodCall;
        }

        return false;
    }

    private void highlightDeclarations(PsiElement psiElement, AnnotationHolder annotationHolder) {
        switch (psiElement) {
            case ValaFieldDeclaration fieldDeclaration -> {
                ValaMemberDeclarationModifiers modifiers = fieldDeclaration.getMemberDeclarationModifiers();

                List<ValaFieldDeclarationSection> sections = fieldDeclaration.getFieldDeclarationSectionList();

                for (ValaFieldDeclarationSection section : sections) {
                    if (modifiers != null && modifiers.getText().contains("static")) {
                        highlight(section.getIdentifier(), annotationHolder, ValaTextAttributeKey.STATIC_VARIABLE);
                    } else {
                        highlight(section.getIdentifier(), annotationHolder, ValaTextAttributeKey.INSTANCE_VARIABLE);
                    }
                }

            }
            case ValaPropertyDeclaration propertyDeclaration -> {
                highlight(propertyDeclaration.getIdentifier(), annotationHolder, ValaTextAttributeKey.INSTANCE_VARIABLE);
            }
            case ValaParameter parameter -> {
                highlight(parameter.getIdentifier(), annotationHolder, ValaTextAttributeKey.PARAMETER);
            }
            case ValaLambdaExpressionParam lambdaExpressionParam -> {
                highlight(lambdaExpressionParam.getIdentifier(), annotationHolder, ValaTextAttributeKey.PARAMETER);
            }
            case ValaLocalVariable localVariable -> {
                highlight(localVariable.getIdentifier(), annotationHolder, ValaTextAttributeKey.LOCAL_VARIABLE);
            }
            case ValaConstantDeclaration constantDeclaration -> {
                highlight(constantDeclaration.getIdentifier(), annotationHolder, ValaTextAttributeKey.CONSTANT);
            }
            case ValaMethodDeclaration methodDeclaration -> {
                highlight(methodDeclaration.getMember(), annotationHolder, ValaTextAttributeKey.METHOD_DECLARATION);
            }
            case ValaSignalDeclaration signalDeclaration -> {
                highlight(signalDeclaration.getIdentifier(), annotationHolder, ValaTextAttributeKey.METHOD_DECLARATION);
            }
            case ValaCreationMethodDeclaration creationMethodDeclaration -> {
                highlight(creationMethodDeclaration.getMember(), annotationHolder, ValaTextAttributeKey.METHOD_DECLARATION);
            }
            case ValaDestructorDeclaration destructorDeclaration -> {
                highlight(destructorDeclaration.getIdentifier(), annotationHolder, ValaTextAttributeKey.METHOD_DECLARATION);
            }
            case ValaDelegateDeclaration delegateDeclaration -> {
                highlight(delegateDeclaration.getSymbol(), annotationHolder, ValaTextAttributeKey.STRUCTURE_NAMES);
            }
            case ValaNamespaceDeclaration namespaceDeclaration -> {
                highlight(namespaceDeclaration.getSymbol(), annotationHolder, ValaTextAttributeKey.STRUCTURE_NAMES);
            }
            case ValaInterfaceDeclaration interfaceDeclaration -> {
                highlight(interfaceDeclaration.getSymbol(), annotationHolder, ValaTextAttributeKey.INTERFACE_NAME);
            }
            case ValaClassDeclaration classDeclaration -> {
                highlight(classDeclaration.getSymbol(), annotationHolder, ValaTextAttributeKey.STRUCTURE_NAMES);
            }
            case ValaStructDeclaration structDeclaration -> {
                highlight(structDeclaration.getSymbol(), annotationHolder, ValaTextAttributeKey.STRUCTURE_NAMES);
            }
            case ValaEnumDeclaration enumDeclaration -> {
                highlight(enumDeclaration.getSymbol(), annotationHolder, ValaTextAttributeKey.STRUCTURE_NAMES);
            }
            case ValaErrordomainDeclaration errordomainDeclaration -> {
                highlight(errordomainDeclaration.getSymbol(), annotationHolder, ValaTextAttributeKey.STRUCTURE_NAMES);
            }
            case ValaErrorcode errorcode -> {
                highlight(errorcode.getIdentifier(), annotationHolder, ValaTextAttributeKey.CONSTANT);
            }
            case ValaEnumvalue enumvalue -> {
                highlight(enumvalue.getIdentifier(), annotationHolder, ValaTextAttributeKey.CONSTANT);
            }
            case ValaForeachStatement foreachStatement -> {
                highlight(foreachStatement.getIdentifier(), annotationHolder, ValaTextAttributeKey.LOCAL_VARIABLE);
            }
            case ValaCatchClause catchClause -> {
                highlight(catchClause.getIdentifier(), annotationHolder, ValaTextAttributeKey.LOCAL_VARIABLE);
            }
            case ValaLocalTupleDeclaration localTupleDeclaration -> {
                highlight(localTupleDeclaration.getMember(), annotationHolder, ValaTextAttributeKey.LOCAL_VARIABLE);
            }
            case ValaNamedArgument namedArgument -> {
                highlight(namedArgument.getIdentifier(), annotationHolder, ValaTextAttributeKey.PARAMETER);
            }
            case ValaYieldExpression yieldExpression -> {
                highlight(yieldExpression.getMember(), annotationHolder, ValaTextAttributeKey.METHOD_CALL);
            }
            default -> {
                return;
            }
        }
    }

    private void highlightMisc(PsiElement psiElement, AnnotationHolder annotationHolder) {
        switch (psiElement) {
            case ValaType type -> {
                highlight(type.getSymbol(), annotationHolder, ValaTextAttributeKey.STRUCTURE_NAMES);
            }
            case ValaTypeWeak weakType -> {
                highlight(weakType.getSymbol(), annotationHolder, ValaTextAttributeKey.STRUCTURE_NAMES);
            }
            case ValaAttribute attribute -> {
                highlight(attribute.getIdentifier(), annotationHolder, ValaTextAttributeKey.ATTRIBUTE);
            }
            case ValaAttributeArgument attributeArgument -> {
                highlight(attributeArgument.getIdentifier(), annotationHolder, ValaTextAttributeKey.PARAMETER);
            }
            case ValaUsingDirective usingDirective -> {
                highlight(usingDirective.getSymbol(), annotationHolder, ValaTextAttributeKey.STRUCTURE_NAMES);
            }
            case ValaMemberInitializer memberInitializer -> {
                highlight(memberInitializer.getIdentifier(), annotationHolder, ValaTextAttributeKey.OBJECT_INITIALIZER);
            }
            default -> {
                return;
            }
        }
    }

    private void highlight(PsiElement name, AnnotationHolder annotationHolder, TextAttributesKey attributeKey) {

        if (name == null) {
            return;
        }

        switch (name) {
            case ValaIdentifier identifier -> {
                if (identifier != null) {
                    annotationHolder.newSilentAnnotation(HighlightSeverity.INFORMATION)
                        .range(identifier)
                        .textAttributes(attributeKey)
                        .create();
                }
            }
            case ValaSymbol symbol -> {
                List<ValaSymbolPart> symbolParts = symbol.getSymbolPartList();

                for (ValaSymbolPart symbolPart : symbolParts) {
                    annotationHolder.newSilentAnnotation(HighlightSeverity.INFORMATION)
                        .range(symbolPart.getIdentifier())
                        .textAttributes(attributeKey)
                        .create();
                }
            }
            case ValaMember member -> {
                List<ValaMemberPart> memberParts = member.getMemberPartList();

                for (ValaMemberPart memberPart : memberParts) {
                    annotationHolder.newSilentAnnotation(HighlightSeverity.INFORMATION)
                        .range(memberPart.getIdentifier())
                        .textAttributes(attributeKey)
                        .create();
                }
            }
            case ValaSimpleName simpleName -> { 
                annotationHolder.newSilentAnnotation(HighlightSeverity.INFORMATION)
                    .range(simpleName.getIdentifier())
                    .textAttributes(attributeKey)
                    .create();
            }
            default -> {
                return;
            }
        }
    }

    private void highlightReferences(ValaSimpleName simpleName, PsiElement resolved, AnnotationHolder annotationHolder) {

        if (PsiTreeUtil.instanceOf(resolved, ValaInterfaceDeclaration.class)) {
            highlight(simpleName, annotationHolder, ValaTextAttributeKey.INTERFACE_NAME);
            return;
        }
        if (PsiTreeUtil.instanceOf(resolved, 
            ValaClassDeclaration.class,
            ValaStructDeclaration.class,
            ValaEnumDeclaration.class,
            ValaErrordomainDeclaration.class,
            ValaNamespaceDeclaration.class,
            ValaDelegateDeclaration.class
        )) {
            highlight(simpleName, annotationHolder, ValaTextAttributeKey.STRUCTURE_NAMES);
            return;
        }

        if (PsiTreeUtil.instanceOf(
            resolved,
            ValaMethodDeclaration.class,
            ValaCreationMethodDeclaration.class,
            ValaDestructorDeclaration.class,
            ValaYieldExpression.class
        )) {
            highlight(simpleName, annotationHolder, ValaTextAttributeKey.METHOD_CALL);
            return;
        }

        if (PsiTreeUtil.instanceOf(
            resolved,
            ValaLocalVariable.class,
            ValaCatchClause.class,
            ValaForeachStatement.class,
            ValaLocalTupleDeclaration.class
        )) {
            highlight(simpleName, annotationHolder, ValaTextAttributeKey.LOCAL_VARIABLE);
            return;
        }

        if (PsiTreeUtil.instanceOf(
            resolved,
            ValaParameter.class,
            ValaLambdaExpressionParam.class,
            ValaNamedArgument.class
        )) {
            highlight(simpleName, annotationHolder, ValaTextAttributeKey.PARAMETER);
            return;
        }

        if (PsiTreeUtil.instanceOf(
            resolved,
            ValaConstantDeclaration.class,
            ValaEnumvalue.class
        )) {
            highlight(simpleName, annotationHolder, ValaTextAttributeKey.CONSTANT);
            return;
        }

        if (PsiTreeUtil.instanceOf(
            resolved,
            ValaFieldDeclarationSection.class,
            ValaPropertyDeclaration.class,
            ValaSignalDeclaration.class
        )) {
            highlight(simpleName, annotationHolder, ValaTextAttributeKey.INSTANCE_VARIABLE);
            return;
        }
    }
}
