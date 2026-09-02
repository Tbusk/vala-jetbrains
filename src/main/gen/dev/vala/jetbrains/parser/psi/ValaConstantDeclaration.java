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

  //WARNING: getName(...) is skipped
  //matching getName(ValaConstantDeclaration, ...)
  //methods are not found in ValaPsiImplUtil

  //WARNING: setName(...) is skipped
  //matching setName(ValaConstantDeclaration, ...)
  //methods are not found in ValaPsiImplUtil

  //WARNING: getNameIdentifier(...) is skipped
  //matching getNameIdentifier(ValaConstantDeclaration, ...)
  //methods are not found in ValaPsiImplUtil

  //WARNING: getPresentation(...) is skipped
  //matching getPresentation(ValaConstantDeclaration, ...)
  //methods are not found in ValaPsiImplUtil

}
