// This is a generated file. Not intended for manual editing.
package dev.vala.jetbrains.parser.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface ValaStructMember extends PsiElement {

  @Nullable
  ValaAttributes getAttributes();

  @Nullable
  ValaConstantDeclarations getConstantDeclarations();

  @Nullable
  ValaCreationMethodDeclaration getCreationMethodDeclaration();

  @Nullable
  ValaFieldDeclaration getFieldDeclaration();

  @Nullable
  ValaMethodDeclaration getMethodDeclaration();

  @Nullable
  ValaPropertyDeclaration getPropertyDeclaration();

}
