package dev.vala.jetbrains.highlighting;

import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighter;
import com.intellij.openapi.options.colors.AttributesDescriptor;
import com.intellij.openapi.options.colors.ColorDescriptor;
import com.intellij.openapi.options.colors.ColorSettingsPage;
import com.intellij.openapi.util.NlsContexts;
import dev.vala.jetbrains.language.ValaIcons;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.util.Map;

/**
 * ValaColorSettingsPage is a class that implements the ColorSettingsPage interface for Vala language support in an IDE.
 * It provides syntax highlighting attributes, demo text, and other settings related to the appearance of Vala code.
 * This class is used to define how Vala code should be highlighted and displayed in the editor in the settings page.
 * <br/><br/>
 * <a href="https://plugins.jetbrains.com/docs/intellij/syntax-highlighter-and-color-settings-page.html#define-a-color-settings-page">view documentation</a>
 */
public class ValaColorSettingsPage implements ColorSettingsPage {

    /**
     * An array of attribute descriptors that define the syntax highlighting attributes for Vala.
     * Each descriptor corresponds to a specific type of syntax element in Vala code.
     * The display name is shown in the color settings UI, and the Highlighter key shows as the source in the
     * settings page.
     */
    private static final AttributesDescriptor[] DESCRIPTORS = new AttributesDescriptor[]{
        new AttributesDescriptor("Keywords", ValaTextAttributeKey.KEYWORD),
        new AttributesDescriptor("Comments//Line comment", ValaTextAttributeKey.LINE_COMMENT),
        new AttributesDescriptor("Comments//Block comment", ValaTextAttributeKey.BLOCK_COMMENT),
        new AttributesDescriptor("Comments//Doc comment", ValaTextAttributeKey.DOC_COMMENT),
        new AttributesDescriptor("Strings", ValaTextAttributeKey.STRING_LITERAL),
        new AttributesDescriptor("Numbers", ValaTextAttributeKey.NUMBER_LITERAL),
        new AttributesDescriptor("Declarations//Constant", ValaTextAttributeKey.CONSTANT),
        new AttributesDescriptor("Declarations//Enum value", ValaTextAttributeKey.ENUM_VALUE),
        new AttributesDescriptor("Declarations//Error code", ValaTextAttributeKey.ERROR_CODE),
        new AttributesDescriptor("Declarations//Parameter", ValaTextAttributeKey.PARAMETER),
        new AttributesDescriptor("Attributes", ValaTextAttributeKey.ATTRIBUTE),
        new AttributesDescriptor("Declarations//Instance field", ValaTextAttributeKey.INSTANCE_VARIABLE),
        new AttributesDescriptor("Declarations//Static field", ValaTextAttributeKey.STATIC_VARIABLE),
        new AttributesDescriptor("Object initializer", ValaTextAttributeKey.OBJECT_INITIALIZER),
        new AttributesDescriptor("Declarations//Local variable", ValaTextAttributeKey.LOCAL_VARIABLE),
        new AttributesDescriptor("Method call", ValaTextAttributeKey.METHOD_CALL),
        new AttributesDescriptor("Semicolons", ValaTextAttributeKey.SEMICOLON),
        new AttributesDescriptor("Brackets", ValaTextAttributeKey.BRACKETS),
        new AttributesDescriptor("Braces", ValaTextAttributeKey.BRACES),
        new AttributesDescriptor("Commas", ValaTextAttributeKey.COMMA),
        new AttributesDescriptor("Dots", ValaTextAttributeKey.DOT),
        new AttributesDescriptor("Parentheses", ValaTextAttributeKey.PARENTHESES),
        new AttributesDescriptor("Declarations//Method", ValaTextAttributeKey.METHOD_DECLARATION),
        new AttributesDescriptor("Declarations//Creation method", ValaTextAttributeKey.CREATION_METHOD),
        new AttributesDescriptor("Declarations//Destructor", ValaTextAttributeKey.DESTRUCTOR),
        new AttributesDescriptor("Declarations//Class", ValaTextAttributeKey.CLASS_NAME),
        new AttributesDescriptor("Declarations//Struct", ValaTextAttributeKey.STRUCT_NAME),
        new AttributesDescriptor("Declarations//Enum", ValaTextAttributeKey.ENUM_NAME),
        new AttributesDescriptor("Declarations//Errordomain", ValaTextAttributeKey.ERRORDOMAIN_NAME),
        new AttributesDescriptor("Declarations//Namespace", ValaTextAttributeKey.NAMESPACE_NAME),
        new AttributesDescriptor("Declarations//Delegate", ValaTextAttributeKey.DELEGATE_NAME),
        new AttributesDescriptor("Declarations//Property", ValaTextAttributeKey.PROPERTY),
        new AttributesDescriptor("Declarations//Signal", ValaTextAttributeKey.SIGNAL),
        new AttributesDescriptor("Declarations//Interface", ValaTextAttributeKey.INTERFACE_NAME),
        new AttributesDescriptor("Types", ValaTextAttributeKey.TYPE_NAME),
        new AttributesDescriptor("Operations", ValaTextAttributeKey.OPERATIONS)
    };

    /**
     * Returns the icon associated with the Vala file type.
     *
     * @return The icon for Vala files.
     */
    @Override
    public @Nullable Icon getIcon() {
        return ValaIcons.FILE;
    }

    /**
     * Returns the highlighter used for syntax highlighting in Vala files.
     *
     * @return An instance of {@link ValaSyntaxHighlighter} for Vala syntax highlighting.
     */
    @Override
    public @NotNull SyntaxHighlighter getHighlighter() {
        return new ValaSyntaxHighlighter();
    }

    /**
     * Returns the text that serves as a demo for Vala syntax highlighting.
     * This text is used to showcase the syntax highlighting capabilities in the settings UI and preview what code will
     * look like when color settings are adjusted.
     *
     * @return A sample Vala code snippet for demonstration purposes.
     */
    @Override
    public @NonNls @NotNull String getDemoText() {
        //language=vala
        return """
            // Line comment
            /* Block comment */
            
            using <type>GObject</type>.<type>Introspection</type>;
            
            namespace <namespace>Example</namespace> {
                /**
                 * Doc comment
                 */
                [<attribute>CCode</attribute> (<parameter>cname</parameter> = "example")]
                public virtual class <class>Test</class> : <type>Example</type> {
                    <type>int</type> <instanceField>a</instanceField> = 0;
                    <type>uchar</type> <instanceField>b</instanceField> = 'c';
                    <type>string</type> <instanceField>c</instanceField> = "Hello world";
                    static <type>int</type> <staticField>counter</staticField> = 0;
                    const <type>double</type> <constant>PI</constant> = 3.14;
            
                    public <type>int</type> <property>count</property> { get; set; }
            
                    public signal <type>void</type> <signal>changed</signal> ();
            
                    public <creationMethod>Test</creationMethod> () {
                    }
            
                    ~<destructor>Test</destructor> () {
                    }
            
                    public <type>int</type> <method>get_a</method> () {
                        var <local>myint</local> = <methodCall>get_a</methodCall> ();
                        var <local>test</local> = new <class>Test</class>() { <objectInitializer>count</objectInitializer> = 1 };
                        return <instanceField>a</instanceField>;
                    }
                }
            
                public interface <interface>Drawable</interface> {
                }
            
                public struct <struct>Point</struct> {
                    <type>int</type> <instanceField>x</instanceField>;
                    <type>int</type> <instanceField>y</instanceField>;
                }
            
                public enum <enum>Status</enum> {
                    <enumValue>OK</enumValue>,
                    <enumValue>ERROR</enumValue>
                }
            
                public errordomain <errordomain>TestError</errordomain> {
                    <errorCode>FAILED</errorCode>
                }
            
                public delegate <type>void</type> <delegate>Callback</delegate> (<type>int</type> <parameter>value</parameter>);
            }
            """;
    }

    /**
     * Specifies tag-to-'color key' mapping for regions with presentation containing additional colors from color map.
     * It's used to implement navigation between the list of keys and regions in sample editor.
     */
    @Override
    public @Nullable Map<String, TextAttributesKey> getAdditionalHighlightingTagToDescriptorMap() {
        return Map.ofEntries(
            Map.entry("class", ValaTextAttributeKey.CLASS_NAME),
            Map.entry("struct", ValaTextAttributeKey.STRUCT_NAME),
            Map.entry("enum", ValaTextAttributeKey.ENUM_NAME),
            Map.entry("errordomain", ValaTextAttributeKey.ERRORDOMAIN_NAME),
            Map.entry("namespace", ValaTextAttributeKey.NAMESPACE_NAME),
            Map.entry("delegate", ValaTextAttributeKey.DELEGATE_NAME),
            Map.entry("type", ValaTextAttributeKey.TYPE_NAME),
            Map.entry("property", ValaTextAttributeKey.PROPERTY),
            Map.entry("signal", ValaTextAttributeKey.SIGNAL),
            Map.entry("creationMethod", ValaTextAttributeKey.CREATION_METHOD),
            Map.entry("destructor", ValaTextAttributeKey.DESTRUCTOR),
            Map.entry("enumValue", ValaTextAttributeKey.ENUM_VALUE),
            Map.entry("errorCode", ValaTextAttributeKey.ERROR_CODE),
            Map.entry("instanceField", ValaTextAttributeKey.INSTANCE_VARIABLE),
            Map.entry("staticField", ValaTextAttributeKey.STATIC_VARIABLE),
            Map.entry("objectInitializer", ValaTextAttributeKey.OBJECT_INITIALIZER),
            Map.entry("interface", ValaTextAttributeKey.INTERFACE_NAME),
            Map.entry("method", ValaTextAttributeKey.METHOD_DECLARATION),
            Map.entry("methodCall", ValaTextAttributeKey.METHOD_CALL),
            Map.entry("local", ValaTextAttributeKey.LOCAL_VARIABLE),
            Map.entry("parameter", ValaTextAttributeKey.PARAMETER),
            Map.entry("attribute", ValaTextAttributeKey.ATTRIBUTE),
            Map.entry("constant", ValaTextAttributeKey.CONSTANT)
        );
    }

    /**
     * Returns an array of attribute descriptors that define the syntax highlighting attributes for Vala.
     * These descriptors are used in the color settings UI to allow users to customize the appearance of different
     * syntax elements in Vala code.
     *
     * @return An array of {@link AttributesDescriptor} for Vala syntax highlighting.
     */
    @Override
    public AttributesDescriptor @NotNull [] getAttributeDescriptors() {
        return DESCRIPTORS;
    }


    /**
     * Returns an array of color descriptors that define the colors used in Vala syntax highlighting.
     * This method is typically used to provide additional color options for customization in the settings UI.
     *
     * @return An empty array, as Vala does not define any custom colors beyond the attributes.
     */
    @Override
    public ColorDescriptor @NotNull [] getColorDescriptors() {
        return ColorDescriptor.EMPTY_ARRAY;
    }

    /**
     * Returns the name used in the settings / editor / color scheme section for this color settings page.
     *
     * @return The display name for the Vala color settings page.
     */
    @Override
    public @NotNull @NlsContexts.ConfigurableName String getDisplayName() {
        return "Vala";
    }
}
