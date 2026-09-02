// This is a generated file. Not intended for manual editing.
package dev.vala.jetbrains.parser.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import dev.vala.jetbrains.psi.ValaNamedElement;

public interface ValaErrordomainDeclaration extends ValaNamedElement {

  @NotNull
  List<ValaAttributes> getAttributesList();

  @Nullable
  ValaErrorcodes getErrorcodes();

  @NotNull
  List<ValaMethodDeclaration> getMethodDeclarationList();

  @NotNull
  ValaSymbol getSymbol();

  //WARNING: getName(...) is skipped
  //matching getName(ValaErrordomainDeclaration, ...)
  //methods are not found in ValaPsiImplUtil

  //WARNING: setName(...) is skipped
  //matching setName(ValaErrordomainDeclaration, ...)
  //methods are not found in ValaPsiImplUtil

  //WARNING: getNameIdentifier(...) is skipped
  //matching getNameIdentifier(ValaErrordomainDeclaration, ...)
  //methods are not found in ValaPsiImplUtil

  //WARNING: getPresentation(...) is skipped
  //matching getPresentation(ValaErrordomainDeclaration, ...)
  //methods are not found in ValaPsiImplUtil

}
