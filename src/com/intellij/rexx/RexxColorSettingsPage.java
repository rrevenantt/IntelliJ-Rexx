package com.intellij.rexx;

import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighter;
import com.intellij.openapi.options.colors.AttributesDescriptor;
import com.intellij.openapi.options.colors.ColorDescriptor;
import com.intellij.openapi.options.colors.ColorSettingsPage;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.util.Map;

public class RexxColorSettingsPage implements ColorSettingsPage {
	private static final AttributesDescriptor[] DESCRIPTORS = new AttributesDescriptor[]{
		new AttributesDescriptor("Identifier", RexxSyntaxHighlighter.VAR_SYMBOL),
		new AttributesDescriptor("Constant", RexxSyntaxHighlighter.CONST),
		new AttributesDescriptor("Number", RexxSyntaxHighlighter.NUMBER),

		new AttributesDescriptor("Keyword", RexxSyntaxHighlighter.KEYWORD),

		new AttributesDescriptor("String", RexxSyntaxHighlighter.STRING),

		new AttributesDescriptor("Comment", RexxSyntaxHighlighter.COMMENT),

		new AttributesDescriptor("Include statement", RexxSyntaxHighlighter.INCLUDE),

		new AttributesDescriptor("Colons and semicolons", RexxSyntaxHighlighter.COLONS),
		new AttributesDescriptor("Comma", RexxSyntaxHighlighter.COMMA),
		new AttributesDescriptor("Operation signs", RexxSyntaxHighlighter.OPERATION_SIGN),
		new AttributesDescriptor("Parentheses statement", RexxSyntaxHighlighter.PARENTHESES),
	};

	@Nullable
	@Override
	public Map<String, TextAttributesKey> getAdditionalHighlightingTagToDescriptorMap() {
		return null;
	}

	@Nullable
	@Override
	public Icon getIcon() {
		return Icons.REXX_ICON;
	}

	@NotNull
	@Override
	public SyntaxHighlighter getHighlighter() {
		return new RexxSyntaxHighlighter();
	}

	@NotNull
	@Override
	public String getDemoText() {
		return
			"/* REXX */\n" +
			"/* some sort of comment */\n" +
			"/* %include somemod */\n" +
			"\n" +
			"mainpgm:\n" +
			"    parse upper arg input, setting ;\n" +
			"    if length(input) > 12 then\n" +
			"        say \"too long: <\" || input || '> is longer that 12 characters!'\n" +
			"    else do\n" +
			"        parse var input i1 i2 i3\n" +
			"        i1 = strip(i1)\n" +
			"        i2 = strip(i2)\n" +
			"        i3 = strip(i3)\n" +
			"        if i3 = '' then\n" +
			"            i3 = .SIGL\n" +
			"        while (i1 > i2) do\n" +
			"            i1 = i1 + length(i3)\n" +
			"            say i1\n" +
			"        end\n" +
			"    end\n" +
			"return 0";
	}

	@NotNull
	@Override
	public AttributesDescriptor[] getAttributeDescriptors() {
		return DESCRIPTORS;
	}

	@NotNull
	@Override
	public ColorDescriptor[] getColorDescriptors() {
		return ColorDescriptor.EMPTY_ARRAY;
	}

	@NotNull
	@Override
	public String getDisplayName() {
		return "Rexx";
	}
}