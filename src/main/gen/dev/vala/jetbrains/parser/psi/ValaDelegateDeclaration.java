// This is a generated file. Not intended for manual editing.
package dev.vala.jetbrains.parser.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import dev.vala.jetbrains.psi.ValaNamedElement;

public interface ValaDelegateDeclaration extends ValaNamedElement {

  @Nullable
  ValaParameters getParameters();

  @NotNull
  ValaSymbol getSymbol();

  @Nullable
  ValaThrowsStatement getThrowsStatement();

  @Nullable
  ValaType getType();

  @Nullable
  ValaTypeParameters getTypeParameters();

  @Nullable
  ValaTypeWithParenthesis getTypeWithParenthesis();

  //WARNING: getName(...) is skipped
  //matching getName(ValaDelegateDeclaration, ...)
  //methods are not found in ValaPsiImplUtil

  //WARNING: setName(...) is skipped
  //matching setName(ValaDelegateDeclaration, ...)
  //methods are not found in ValaPsiImplUtil

  //WARNING: getNameIdentifier(...) is skipped
  //matching getNameIdentifier(ValaDelegateDeclaration, ...)
  //methods are not found in ValaPsiImplUtil

  //WARNING: getPresentation(...) is skipped
  //matching getPresentation(ValaDelegateDeclaration, ...)
  //methods are not found in ValaPsiImplUtil

}
