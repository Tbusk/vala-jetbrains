// This is a generated file. Not intended for manual editing.
package dev.vala.jetbrains.parser.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import dev.vala.jetbrains.psi.ValaNamedElement;

public interface ValaParameter extends ValaNamedElement {

  @Nullable
  ValaAttributes getAttributes();

  @Nullable
  ValaExpression getExpression();

  @Nullable
  ValaIdentifier getIdentifier();

  @Nullable
  ValaInlineArrayType getInlineArrayType();

  @Nullable
  ValaType getType();

  @Nullable
  ValaTypeWeak getTypeWeak();

  @Nullable
  ValaTypeWeakWithParenthesis getTypeWeakWithParenthesis();

  @Nullable
  ValaTypeWithParenthesis getTypeWithParenthesis();

  //WARNING: getName(...) is skipped
  //matching getName(ValaParameter, ...)
  //methods are not found in ValaPsiImplUtil

  //WARNING: setName(...) is skipped
  //matching setName(ValaParameter, ...)
  //methods are not found in ValaPsiImplUtil

  //WARNING: getNameIdentifier(...) is skipped
  //matching getNameIdentifier(ValaParameter, ...)
  //methods are not found in ValaPsiImplUtil

  //WARNING: getPresentation(...) is skipped
  //matching getPresentation(ValaParameter, ...)
  //methods are not found in ValaPsiImplUtil

}
