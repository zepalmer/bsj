package edu.jhu.cs.bsj.eclipse.preference;

import org.eclipse.jdt.ui.PreferenceConstants;

/**
 * Store the keys used to access the preference store.
 */
public class BSJPreferenceKeys {
	
	private BSJPreferenceKeys(){	
	}
	
	public static final String getUseJavaPreferenceKey(String tokenKey) {
		return tokenKey + "_use_java_pref";
	}
	
	public static final String getBoldKey(String tokenKey) {
		return tokenKey + PreferenceConstants.EDITOR_BOLD_SUFFIX;
	}

	public static final String getItalicKey(String tokenKey) {
		return tokenKey + PreferenceConstants.EDITOR_ITALIC_SUFFIX;
	}

	public static final String getStrikethroughKey(String tokenKey) {
		return tokenKey + PreferenceConstants.EDITOR_STRIKETHROUGH_SUFFIX;
	}

	public static final String getUnderlineKey(String tokenKey) {
		return tokenKey + PreferenceConstants.EDITOR_UNDERLINE_SUFFIX;
	}
	
}
