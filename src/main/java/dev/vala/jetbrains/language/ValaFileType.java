package dev.vala.jetbrains.language;

import com.intellij.openapi.fileTypes.LanguageFileType;

import org.jetbrains.annotations.NotNull;

import javax.swing.*;

/**
 * IntelliJ Platform file type for Vala source files.
 * <p>
 * Registered in {@code plugin.xml} via the {@code com.intellij.fileType} extension
 * point.
 *
 * @see <a href="https://plugins.jetbrains.com/docs/intellij/language-and-filetype.html#define-a-file-type">Define a File Type</a>
 */
public final class ValaFileType extends LanguageFileType {

    /**
     * Shared file type instance used by {@code plugin.xml} registration.
     */
    public static final ValaFileType INSTANCE = new ValaFileType();

    /**
     * Associates this file type with {@link ValaLanguage}.
     */
    private ValaFileType() {
        super(ValaLanguage.getInstance());
    }

    /**
     * Returns the file type name shown in the IDE and used as the {@code name}
     * attribute in {@code plugin.xml}.
     *
     * @return the file type name
     */
    @NotNull
    @Override
    public String getName() {
        return "Vala File";
    }

    /**
     * Returns the user-visible description of this file type.
     *
     * @return a short description of Vala language files
     */
    @NotNull
    @Override
    public String getDescription() {
        return "Vala language file";
    }

    /**
     * Returns the primary file extension for this file type.
     *
     * @return the default extension without a leading dot
     */
    @NotNull
    @Override
    public String getDefaultExtension() {
        return "vala";
    }

    /**
     * Returns the icon shown next to Vala files in the Project tool window and editor tabs.
     *
     * @return the Vala file-type icon
     */
    @Override
    public Icon getIcon() {
        return ValaIcons.FILE;
    }
}