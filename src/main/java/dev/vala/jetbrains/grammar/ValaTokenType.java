package dev.vala.jetbrains.grammar;

import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

import dev.vala.jetbrains.language.ValaLanguage;
import com.intellij.psi.tree.IElementType;

/**
 * Token type for Vala tokens produced by Grammar-Kit.
 * <p>
 * Used as the {@code tokenTypeClass} in the Vala BNF. Each instance is an 
 * {@link IElementType} associated with {@link ValaLanguage}.
 *
 * @see <a href="https://plugins.jetbrains.com/docs/intellij/grammar-and-parser.html#define-a-token-type">Define a Token Type</a>
 */
public class ValaTokenType extends IElementType {

    /**
     * Creates a token type with the given debug name for {@link ValaLanguage}.
     *
     * @param debugName name used in PSI trees, lexer diagnostics, and {@link #toString()}
     */
    public ValaTokenType(@NotNull @NonNls String debugName) {
        super(debugName, ValaLanguage.getInstance());
    }

    /**
     * Returns a prefixed debug name so token types are easy to distinguish in PSI trees.
     *
     * @return {@code ValaTokenType.} followed by the debug name
     */
    @Override
    public String toString() {
        return String.format("%sTokenType.%s", ValaLanguage.NAME, super.toString());
    }
}
