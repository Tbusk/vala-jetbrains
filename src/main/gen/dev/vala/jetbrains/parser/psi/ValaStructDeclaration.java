// This is a generated file. Not intended for manual editing.
package dev.vala.jetbrains.parser.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import dev.vala.jetbrains.psi.ValaNamedElement;

public interface ValaStructDeclaration extends ValaNamedElement {

  @Nullable
  ValaAccessModifier getAccessModifier();

  @Nullable
  ValaBaseTypes getBaseTypes();

  @NotNull
  List<ValaStructMember> getStructMemberList();

  @NotNull
  ValaSymbol getSymbol();

  @Nullable
  ValaTypeArguments getTypeArguments();

  @Nullable
  ValaTypeDeclarationModifiers getTypeDeclarationModifiers();

}
