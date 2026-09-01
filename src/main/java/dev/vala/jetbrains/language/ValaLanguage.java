package dev.vala.jetbrains.language;

import com.intellij.lang.Language;

/**
 * IntelliJ Platform definition of the Vala programming language.
 * <p>
 * This class is used to register the Vala file type in conjunction with the 
 * {@link com.intellij.openapi.fileTypes.LanguageFileType} class in {@code plugin.xml} 
 * with {@code language} set to {@link #NAME}.
 * 
 * @see <a href="https://plugins.jetbrains.com/docs/intellij/language-and-filetype.html#define-the-language">Define the Language</a>
 */
public class ValaLanguage extends Language {

    /**
     * Shared language instance used by file type registration and other language support.
     */
    private static volatile ValaLanguage INSTANCE;

    /**
     * Language ID passed to {@link Language#Language(String)} and used as the {@code language} 
     * attribute when registering the file type.
     */
    public static String NAME = "Vala";
    
    /**
     * Registers this language with the platform under {@link #NAME}.
     */
    private ValaLanguage() {
        super(NAME);
    }

    /**
     * Returns the shared {@link ValaLanguage} instance.
     * 
     * @return the singleton language instance
     */
    public static ValaLanguage getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ValaLanguage();
        }

        return INSTANCE;
    }
}
