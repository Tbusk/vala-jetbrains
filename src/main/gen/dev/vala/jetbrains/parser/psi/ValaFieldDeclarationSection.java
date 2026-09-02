// This is a generated file. Not intended for manual editing.
package dev.vala.jetbrains.parser.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import dev.vala.jetbrains.psi.ValaNamedElement;

public interface ValaFieldDeclarationSection extends ValaNamedElement {

  @Nullable
  ValaExpression getExpression();

  @NotNull
  ValaIdentifier getIdentifier();

  @NotNull
  List<ValaInlineArrayType> getInlineArrayTypeList();

  //WARNING: getName(...) is skipped
  //matching getName(ValaFieldDeclarationSection, ...)
  //methods are not found in ValaPsiImplUtil

  //WARNING: setName(...) is skipped
  //matching setName(ValaFieldDeclarationSection, ...)
  //methods are not found in ValaPsiImplUtil

  //WARNING: getNameIdentifier(...) is skipped
  //matching getNameIdentifier(ValaFieldDeclarationSection, ...)
  //methods are not found in ValaPsiImplUtil

  //WARNING: getPresentation(...) is skipped
  //matching getPresentation(ValaFieldDeclarationSection, ...)
  //methods are not found in ValaPsiImplUtil

}
