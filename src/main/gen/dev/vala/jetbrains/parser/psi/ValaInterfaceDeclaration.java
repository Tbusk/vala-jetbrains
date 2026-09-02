// This is a generated file. Not intended for manual editing.
package dev.vala.jetbrains.parser.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import dev.vala.jetbrains.psi.ValaNamedElement;

public interface ValaInterfaceDeclaration extends ValaNamedElement {

  @Nullable
  ValaAccessModifier getAccessModifier();

  @Nullable
  ValaBaseTypes getBaseTypes();

  @NotNull
  List<ValaInterfaceMember> getInterfaceMemberList();

  @NotNull
  ValaSymbol getSymbol();

  @Nullable
  ValaTypeParameters getTypeParameters();

  //WARNING: getName(...) is skipped
  //matching getName(ValaInterfaceDeclaration, ...)
  //methods are not found in ValaPsiImplUtil

  //WARNING: setName(...) is skipped
  //matching setName(ValaInterfaceDeclaration, ...)
  //methods are not found in ValaPsiImplUtil

  //WARNING: getNameIdentifier(...) is skipped
  //matching getNameIdentifier(ValaInterfaceDeclaration, ...)
  //methods are not found in ValaPsiImplUtil

  //WARNING: getPresentation(...) is skipped
  //matching getPresentation(ValaInterfaceDeclaration, ...)
  //methods are not found in ValaPsiImplUtil

}
