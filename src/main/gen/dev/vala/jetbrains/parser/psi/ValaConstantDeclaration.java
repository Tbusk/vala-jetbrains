// This is a generated file. Not intended for manual editing.
package dev.vala.jetbrains.parser.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import dev.vala.jetbrains.psi.ValaNamedElement;

public interface ValaConstantDeclaration extends ValaNamedElement {

  @Nullable
  ValaAccessModifier getAccessModifier();

  @NotNull
  List<ValaExpression> getExpressionList();

  @NotNull
  List<ValaIdentifier> getIdentifierList();

  @NotNull
  List<ValaInlineArrayType> getInlineArrayTypeList();

  @Nullable
  ValaMemberDeclarationModifiers getMemberDeclarationModifiers();

  @NotNull
  ValaType getType();

}
