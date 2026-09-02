// This is a generated file. Not intended for manual editing.
package dev.vala.jetbrains.parser.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import dev.vala.jetbrains.psi.ValaNamedElement;

public interface ValaSignalDeclaration extends ValaNamedElement {

  @Nullable
  ValaAccessModifier getAccessModifier();

  @Nullable
  ValaBlock getBlock();

  @NotNull
  ValaIdentifier getIdentifier();

  @Nullable
  ValaParameters getParameters();

  @Nullable
  ValaSignalDeclarationModifiers getSignalDeclarationModifiers();

  @Nullable
  ValaType getType();

  @Nullable
  ValaTypeWithParenthesis getTypeWithParenthesis();

  //WARNING: getName(...) is skipped
  //matching getName(ValaSignalDeclaration, ...)
  //methods are not found in ValaPsiImplUtil

  //WARNING: setName(...) is skipped
  //matching setName(ValaSignalDeclaration, ...)
  //methods are not found in ValaPsiImplUtil

  //WARNING: getNameIdentifier(...) is skipped
  //matching getNameIdentifier(ValaSignalDeclaration, ...)
  //methods are not found in ValaPsiImplUtil

  //WARNING: getPresentation(...) is skipped
  //matching getPresentation(ValaSignalDeclaration, ...)
  //methods are not found in ValaPsiImplUtil

}
