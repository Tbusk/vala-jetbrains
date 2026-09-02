// This is a generated file. Not intended for manual editing.
package dev.vala.jetbrains.parser;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import dev.vala.jetbrains.grammar.ValaElementType;
import dev.vala.jetbrains.grammar.ValaTokenType;
import dev.vala.jetbrains.parser.impl.*;

public interface ValaTypes {

  IElementType ENUM_DECLARATION = new ValaElementType("ENUM_DECLARATION");
  IElementType ENUM_VALUE = new ValaElementType("ENUM_VALUE");
  IElementType ENUM_VALUES = new ValaElementType("ENUM_VALUES");

  IElementType COMMA = new ValaTokenType(",");
  IElementType ENUM = new ValaTokenType("enum");
  IElementType IDENTIFIER = new ValaTokenType("IDENTIFIER");
  IElementType LBRACE = new ValaTokenType("{");
  IElementType RBRACE = new ValaTokenType("}");
  IElementType SEMICOLON = new ValaTokenType(";");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == ENUM_DECLARATION) {
        return new ValaEnumDeclarationImpl(node);
      }
      else if (type == ENUM_VALUE) {
        return new ValaEnumValueImpl(node);
      }
      else if (type == ENUM_VALUES) {
        return new ValaEnumValuesImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
