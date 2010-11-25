package edu.jhu.cs.bsj.eclipse.preference;

import org.eclipse.jdt.ui.PreferenceConstants;

public class BSJPreferenceKeys {
	
	private BSJPreferenceKeys(){	
	}
	
	public static String getBoldKey(String colorKey) {
		return colorKey + PreferenceConstants.EDITOR_BOLD_SUFFIX;
	}

	public static String getItalicKey(String colorKey) {
		return colorKey + PreferenceConstants.EDITOR_ITALIC_SUFFIX;
	}

	public static String getStrikethroughKey(String colorKey) {
		return colorKey + PreferenceConstants.EDITOR_STRIKETHROUGH_SUFFIX;
	}

	public static String getUnderlineKey(String colorKey) {
		return colorKey + PreferenceConstants.EDITOR_UNDERLINE_SUFFIX;
	}
	
}
