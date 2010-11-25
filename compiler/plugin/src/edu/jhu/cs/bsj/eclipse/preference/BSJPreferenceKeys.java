package edu.jhu.cs.bsj.eclipse.preference;

import org.eclipse.jdt.ui.PreferenceConstants;

/**
 * Store the keys used to access the preference store.
 */
public class BSJPreferenceKeys {
	
	private BSJPreferenceKeys(){	
	}
	
	public static final String getBoldKey(String colorKey) {
		return colorKey + PreferenceConstants.EDITOR_BOLD_SUFFIX;
	}

	public static final String getItalicKey(String colorKey) {
		return colorKey + PreferenceConstants.EDITOR_ITALIC_SUFFIX;
	}

	public static final String getStrikethroughKey(String colorKey) {
		return colorKey + PreferenceConstants.EDITOR_STRIKETHROUGH_SUFFIX;
	}

	public static final String getUnderlineKey(String colorKey) {
		return colorKey + PreferenceConstants.EDITOR_UNDERLINE_SUFFIX;
	}
	
}
