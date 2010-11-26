package edu.jhu.cs.bsj.eclipse;


import junk.BSJPartitionConstants;

import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.preferences.IPreferencesService;
import org.eclipse.jdt.ui.text.IJavaColorConstants;

import edu.jhu.cs.bsj.eclipse.preference.BSJPreferenceKeys;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String location = "org.eclipse.jdt.ui";
		
		IPreferencesService service = Platform.getPreferencesService();
		System.out.println(service);
		
		String str = service.getString(
				location, IJavaColorConstants.JAVA_KEYWORD_RETURN, "", null);
		System.out.println(str);
		
		boolean value = service.getBoolean(
				location, 
				BSJPreferenceKeys.getBoldKey(IJavaColorConstants.JAVA_KEYWORD_RETURN),
				true,
				null);
		System.out.println(value);
		
		value = service.getBoolean(
				location, 
				BSJPreferenceKeys.getBoldKey(IJavaColorConstants.JAVA_BRACKET),
				true,
				null);
		System.out.println(value);
		
		value = service.getBoolean(
				location, 
				BSJPreferenceKeys.getBoldKey(IJavaColorConstants.JAVA_KEYWORD),
				true,
				null);
		System.out.println(value);
		
	}

}
