// This is a generated file. Not intended for manual editing.
package dev.vala.jetbrains.parser.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static dev.vala.jetbrains.parser.psi.ValaTypes.*;
import dev.vala.jetbrains.psi.ValaNamedElementImpl;
import dev.vala.jetbrains.parser.psi.*;
import dev.vala.jetbrains.psi.ValaPsiImplUtil;

public class ValaDelegateDeclarationImpl extends ValaNamedElementImpl implements ValaDelegateDeclaration {

  public ValaDelegateDeclarationImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull ValaVisitor visitor) {
    visitor.visitDelegateDeclaration(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof ValaVisitor) accept((ValaVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public ValaParameters getParameters() {
    return findChildByClass(ValaParameters.class);
  }

  @Override
  @NotNull
  public ValaSymbol getSymbol() {
    return findNotNullChildByClass(ValaSymbol.class);
  }

  @Override
  @Nullable
  public ValaThrowsStatement getThrowsStatement() {
    return findChildByClass(ValaThrowsStatement.class);
  }

  @Override
  @Nullable
  public ValaType getType() {
    return findChildByClass(ValaType.class);
  }

  @Override
  @Nullable
  public ValaTypeParameters getTypeParameters() {
    return findChildByClass(ValaTypeParameters.class);
  }

  @Override
  @Nullable
  public ValaTypeWithParenthesis getTypeWithParenthesis() {
    return findChildByClass(ValaTypeWithParenthesis.class);
  }

}
