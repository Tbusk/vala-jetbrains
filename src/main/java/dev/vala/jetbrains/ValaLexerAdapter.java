package dev.vala.jetbrains;

import com.intellij.lexer.FlexAdapter;
import dev.vala.jetbrains.lexer.ValaLexer;


public class ValaLexerAdapter extends FlexAdapter {

    public ValaLexerAdapter() {
        super(new ValaLexer(null));
    }
}
