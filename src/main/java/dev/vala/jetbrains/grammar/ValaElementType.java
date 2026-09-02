package dev.vala.jetbrains.grammar;

import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

import dev.vala.jetbrains.language.ValaLanguage;
import com.intellij.psi.tree.IElementType;

/**
 * Element type for Vala elements produced by Grammar-Kit.
 * <p>
 * Used as the {@code elementTypeClass} in the Vala BNF. Each instance is an
 * {@link IElementType} associated with {@link ValaLanguage}.
 *
 * @see <a href="https://plugins.jetbrains.com/docs/intellij/grammar-and-parser.html#define-an-element-type">Define an Element Type</a>
 */
public class ValaElementType extends IElementType {

    /**
     * Creates an element type with the given debug name for {@link ValaLanguage}.
     *
     * @param debugName name used in PSI trees and {@link #toString()}
     */
    public ValaElementType(@NotNull @NonNls String debugName) {
        super(debugName, ValaLanguage.getInstance());
    }
}
