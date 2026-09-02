// This is a generated file. Not intended for manual editing.
package dev.vala.jetbrains.parser.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import dev.vala.jetbrains.psi.ValaNamedElement;

public interface ValaPropertyDeclaration extends ValaNamedElement {

  @Nullable
  ValaAccessModifier getAccessModifier();

  @NotNull
  ValaIdentifier getIdentifier();

  @Nullable
  ValaPropertyDeclarationModifiers getPropertyDeclarationModifiers();

  @NotNull
  List<ValaPropertyDeclarationPart> getPropertyDeclarationPartList();

  @Nullable
  ValaTypeWeak getTypeWeak();

  @Nullable
  ValaTypeWeakWithParenthesis getTypeWeakWithParenthesis();

  //WARNING: getName(...) is skipped
  //matching getName(ValaPropertyDeclaration, ...)
  //methods are not found in ValaPsiImplUtil

  //WARNING: setName(...) is skipped
  //matching setName(ValaPropertyDeclaration, ...)
  //methods are not found in ValaPsiImplUtil

  //WARNING: getNameIdentifier(...) is skipped
  //matching getNameIdentifier(ValaPropertyDeclaration, ...)
  //methods are not found in ValaPsiImplUtil

  //WARNING: getPresentation(...) is skipped
  //matching getPresentation(ValaPropertyDeclaration, ...)
  //methods are not found in ValaPsiImplUtil

}
