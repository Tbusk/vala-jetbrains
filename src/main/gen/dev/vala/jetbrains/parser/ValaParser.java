// This is a generated file. Not intended for manual editing.
package dev.vala.jetbrains.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static dev.vala.jetbrains.parser.ValaTypes.*;
import static com.intellij.lang.parser.GeneratedParserUtilBase.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class ValaParser implements PsiParser, LightPsiParser {

  public ASTNode parse(IElementType root_, PsiBuilder builder_) {
    parseLight(root_, builder_);
    return builder_.getTreeBuilt();
  }

  public void parseLight(IElementType root_, PsiBuilder builder_) {
    boolean result_;
    builder_ = adapt_builder_(root_, builder_, this, null);
    Marker marker_ = enter_section_(builder_, 0, _COLLAPSE_, null);
    result_ = parse_root_(root_, builder_);
    exit_section_(builder_, 0, marker_, root_, result_, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType root_, PsiBuilder builder_) {
    return parse_root_(root_, builder_, 0);
  }

  static boolean parse_root_(IElementType root_, PsiBuilder builder_, int level_) {
    return file(builder_, level_ + 1);
  }

  /* ********************************************************** */
  // enum IDENTIFIER LBRACE enum_values RBRACE
  public static boolean enum_declaration(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "enum_declaration")) return false;
    if (!nextTokenIs(builder_, ENUM)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeTokens(builder_, 0, ENUM, IDENTIFIER, LBRACE);
    result_ = result_ && enum_values(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, RBRACE);
    exit_section_(builder_, marker_, ENUM_DECLARATION, result_);
    return result_;
  }

  /* ********************************************************** */
  // IDENTIFIER
  public static boolean enum_value(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "enum_value")) return false;
    if (!nextTokenIs(builder_, IDENTIFIER)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, IDENTIFIER);
    exit_section_(builder_, marker_, ENUM_VALUE, result_);
    return result_;
  }

  /* ********************************************************** */
  // enum_value (COMMA enum_value)* SEMICOLON
  public static boolean enum_values(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "enum_values")) return false;
    if (!nextTokenIs(builder_, IDENTIFIER)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = enum_value(builder_, level_ + 1);
    result_ = result_ && enum_values_1(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, SEMICOLON);
    exit_section_(builder_, marker_, ENUM_VALUES, result_);
    return result_;
  }

  // (COMMA enum_value)*
  private static boolean enum_values_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "enum_values_1")) return false;
    while (true) {
      int pos_ = current_position_(builder_);
      if (!enum_values_1_0(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "enum_values_1", pos_)) break;
    }
    return true;
  }

  // COMMA enum_value
  private static boolean enum_values_1_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "enum_values_1_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, COMMA);
    result_ = result_ && enum_value(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // item*
  static boolean file(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "file")) return false;
    while (true) {
      int pos_ = current_position_(builder_);
      if (!item(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "file", pos_)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // (enum_declaration)
  static boolean item(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "item")) return false;
    if (!nextTokenIs(builder_, ENUM)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = enum_declaration(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

}
