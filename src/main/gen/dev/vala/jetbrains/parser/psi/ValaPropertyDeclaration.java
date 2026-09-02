// This is a generated file. Not intended for manual editing.
package dev.vala.jetbrains.parser.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import dev.vala.jetbrains.psi.ValaNamedElement;

public interface ValaPropertyDeclaration extends ValaNamedElement {

  @Nullable
  ValaAccessModifier getAccessModifier();

  @NotNull
  ValaIdentifier getIdentifier();

  @Nullable
  ValaPropertyDeclarationModifiers getPropertyDeclarationModifiers();

  @NotNull
  List<ValaPropertyDeclarationPart> getPropertyDeclarationPartList();

  @Nullable
  ValaTypeWeak getTypeWeak();

  @Nullable
  ValaTypeWeakWithParenthesis getTypeWeakWithParenthesis();

}
