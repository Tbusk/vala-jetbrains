// This is a generated file. Not intended for manual editing.
package dev.vala.jetbrains.parser.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import dev.vala.jetbrains.psi.ValaNamedElement;

public interface ValaCatchClause extends ValaNamedElement {

  @NotNull
  ValaBlock getBlock();

  @Nullable
  ValaIdentifier getIdentifier();

  @Nullable
  ValaTypeWeak getTypeWeak();

  @Nullable
  ValaTypeWeakWithParenthesis getTypeWeakWithParenthesis();

  //WARNING: getName(...) is skipped
  //matching getName(ValaCatchClause, ...)
  //methods are not found in ValaPsiImplUtil

  //WARNING: setName(...) is skipped
  //matching setName(ValaCatchClause, ...)
  //methods are not found in ValaPsiImplUtil

  //WARNING: getNameIdentifier(...) is skipped
  //matching getNameIdentifier(ValaCatchClause, ...)
  //methods are not found in ValaPsiImplUtil

  //WARNING: getPresentation(...) is skipped
  //matching getPresentation(ValaCatchClause, ...)
  //methods are not found in ValaPsiImplUtil

}
