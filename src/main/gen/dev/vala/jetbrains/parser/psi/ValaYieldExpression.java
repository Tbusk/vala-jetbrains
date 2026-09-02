// This is a generated file. Not intended for manual editing.
package dev.vala.jetbrains.parser.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import dev.vala.jetbrains.psi.ValaNamedElement;

public interface ValaYieldExpression extends ValaNamedElement {

  @Nullable
  ValaBaseAccess getBaseAccess();

  @NotNull
  ValaMember getMember();

  @NotNull
  List<ValaMemberAccess> getMemberAccessList();

  @NotNull
  List<ValaMethodCall> getMethodCallList();

  //WARNING: getName(...) is skipped
  //matching getName(ValaYieldExpression, ...)
  //methods are not found in ValaPsiImplUtil

  //WARNING: setName(...) is skipped
  //matching setName(ValaYieldExpression, ...)
  //methods are not found in ValaPsiImplUtil

  //WARNING: getNameIdentifier(...) is skipped
  //matching getNameIdentifier(ValaYieldExpression, ...)
  //methods are not found in ValaPsiImplUtil

  //WARNING: getPresentation(...) is skipped
  //matching getPresentation(ValaYieldExpression, ...)
  //methods are not found in ValaPsiImplUtil

}
