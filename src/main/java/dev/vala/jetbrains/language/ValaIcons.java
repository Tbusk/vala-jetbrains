package dev.vala.jetbrains.language;

import com.intellij.openapi.util.IconLoader;
import javax.swing.Icon;

/**
 * Icons used by the Vala language.
 * <p>
 * {@link #FILE} is the icon a {@link com.intellij.openapi.fileTypes.LanguageFileType}
 * should return from {@code getIcon()}.
 */
public class ValaIcons {

    /**
     * File-type icon shown next to {@code .vala} and {@code .vapi} files in the Project 
     * tool window and editor tabs.
     */
    public static final Icon FILE = IconLoader.getIcon("images/pluginIconNoBackground.svg", ValaIcons.class);
    
}
