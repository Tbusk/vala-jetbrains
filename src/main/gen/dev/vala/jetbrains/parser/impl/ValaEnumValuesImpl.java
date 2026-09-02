// This is a generated file. Not intended for manual editing.
package dev.vala.jetbrains.parser.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static dev.vala.jetbrains.parser.ValaTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import dev.vala.jetbrains.parser.psi.*;

public class ValaEnumValuesImpl extends ASTWrapperPsiElement implements ValaEnumValues {

  public ValaEnumValuesImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull ValaVisitor visitor) {
    visitor.visitEnumValues(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof ValaVisitor) accept((ValaVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<ValaEnumValue> getEnumValueList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ValaEnumValue.class);
  }

}
