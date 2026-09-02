// This is a generated file. Not intended for manual editing.
package dev.vala.jetbrains.parser.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import dev.vala.jetbrains.psi.ValaNamedElement;

public interface ValaLocalVariable extends ValaNamedElement {

  @Nullable
  ValaExpression getExpression();

  @NotNull
  ValaIdentifier getIdentifier();

  @Nullable
  ValaInlineArrayType getInlineArrayType();

  //WARNING: getName(...) is skipped
  //matching getName(ValaLocalVariable, ...)
  //methods are not found in ValaPsiImplUtil

  //WARNING: setName(...) is skipped
  //matching setName(ValaLocalVariable, ...)
  //methods are not found in ValaPsiImplUtil

  //WARNING: getNameIdentifier(...) is skipped
  //matching getNameIdentifier(ValaLocalVariable, ...)
  //methods are not found in ValaPsiImplUtil

  //WARNING: getPresentation(...) is skipped
  //matching getPresentation(ValaLocalVariable, ...)
  //methods are not found in ValaPsiImplUtil

}
