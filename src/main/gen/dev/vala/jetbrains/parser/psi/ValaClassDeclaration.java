// This is a generated file. Not intended for manual editing.
package dev.vala.jetbrains.parser.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import dev.vala.jetbrains.psi.ValaNamedElement;

public interface ValaClassDeclaration extends ValaNamedElement {

  @Nullable
  ValaAccessModifier getAccessModifier();

  @Nullable
  ValaBaseTypes getBaseTypes();

  @NotNull
  List<ValaClassMember> getClassMemberList();

  @NotNull
  ValaSymbol getSymbol();

  @Nullable
  ValaTypeArguments getTypeArguments();

  @Nullable
  ValaTypeDeclarationModifiers getTypeDeclarationModifiers();

  //WARNING: getName(...) is skipped
  //matching getName(ValaClassDeclaration, ...)
  //methods are not found in ValaPsiImplUtil

  //WARNING: setName(...) is skipped
  //matching setName(ValaClassDeclaration, ...)
  //methods are not found in ValaPsiImplUtil

  //WARNING: getNameIdentifier(...) is skipped
  //matching getNameIdentifier(ValaClassDeclaration, ...)
  //methods are not found in ValaPsiImplUtil

  //WARNING: getPresentation(...) is skipped
  //matching getPresentation(ValaClassDeclaration, ...)
  //methods are not found in ValaPsiImplUtil

}
