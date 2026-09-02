// This is a generated file. Not intended for manual editing.
package dev.vala.jetbrains.parser.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import dev.vala.jetbrains.psi.ValaNamedElement;

public interface ValaCreationMethodDeclaration extends ValaNamedElement {

  @Nullable
  ValaAccessModifier getAccessModifier();

  @Nullable
  ValaBlock getBlock();

  @Nullable
  ValaConstructorDeclarationModifiers getConstructorDeclarationModifiers();

  @Nullable
  ValaEnsuresStatement getEnsuresStatement();

  @NotNull
  ValaMember getMember();

  @Nullable
  ValaParameters getParameters();

  @Nullable
  ValaRequiresStatement getRequiresStatement();

  @Nullable
  ValaThrowsStatement getThrowsStatement();

  //WARNING: getName(...) is skipped
  //matching getName(ValaCreationMethodDeclaration, ...)
  //methods are not found in ValaPsiImplUtil

  //WARNING: setName(...) is skipped
  //matching setName(ValaCreationMethodDeclaration, ...)
  //methods are not found in ValaPsiImplUtil

  //WARNING: getNameIdentifier(...) is skipped
  //matching getNameIdentifier(ValaCreationMethodDeclaration, ...)
  //methods are not found in ValaPsiImplUtil

  //WARNING: getPresentation(...) is skipped
  //matching getPresentation(ValaCreationMethodDeclaration, ...)
  //methods are not found in ValaPsiImplUtil

}
