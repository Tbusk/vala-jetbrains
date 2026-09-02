// This is a generated file. Not intended for manual editing.
package dev.vala.jetbrains.parser.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import dev.vala.jetbrains.psi.ValaNamedElement;

public interface ValaForeachStatement extends ValaNamedElement {

  @NotNull
  ValaEmbeddedStatement getEmbeddedStatement();

  @NotNull
  ValaExpression getExpression();

  @NotNull
  ValaIdentifier getIdentifier();

  @Nullable
  ValaTypeWeak getTypeWeak();

  @Nullable
  ValaTypeWeakWithParenthesis getTypeWeakWithParenthesis();

  //WARNING: getName(...) is skipped
  //matching getName(ValaForeachStatement, ...)
  //methods are not found in ValaPsiImplUtil

  //WARNING: setName(...) is skipped
  //matching setName(ValaForeachStatement, ...)
  //methods are not found in ValaPsiImplUtil

  //WARNING: getNameIdentifier(...) is skipped
  //matching getNameIdentifier(ValaForeachStatement, ...)
  //methods are not found in ValaPsiImplUtil

  //WARNING: getPresentation(...) is skipped
  //matching getPresentation(ValaForeachStatement, ...)
  //methods are not found in ValaPsiImplUtil

}
