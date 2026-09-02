// This is a generated file. Not intended for manual editing.
package dev.vala.jetbrains.parser.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import dev.vala.jetbrains.psi.ValaNamedElement;

public interface ValaNamespaceDeclaration extends ValaNamedElement {

  @NotNull
  List<ValaNamespaceMember> getNamespaceMemberList();

  @NotNull
  ValaSymbol getSymbol();

  @NotNull
  List<ValaUsingDirective> getUsingDirectiveList();

  //WARNING: getName(...) is skipped
  //matching getName(ValaNamespaceDeclaration, ...)
  //methods are not found in ValaPsiImplUtil

  //WARNING: setName(...) is skipped
  //matching setName(ValaNamespaceDeclaration, ...)
  //methods are not found in ValaPsiImplUtil

  //WARNING: getNameIdentifier(...) is skipped
  //matching getNameIdentifier(ValaNamespaceDeclaration, ...)
  //methods are not found in ValaPsiImplUtil

  //WARNING: getPresentation(...) is skipped
  //matching getPresentation(ValaNamespaceDeclaration, ...)
  //methods are not found in ValaPsiImplUtil

}
