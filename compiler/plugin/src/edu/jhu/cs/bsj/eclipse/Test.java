package edu.jhu.cs.bsj.eclipse;


import junk.BSJPartitionConstants;

import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.preferences.ConfigurationScope;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.core.runtime.preferences.IEclipsePreferences.IPreferenceChangeListener;
import org.eclipse.core.runtime.preferences.IPreferencesService;
import org.eclipse.core.runtime.preferences.PreferenceModifyListener;
import org.eclipse.core.runtime.preferences.IEclipsePreferences.PreferenceChangeEvent;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.ui.text.IJavaColorConstants;
import org.eclipse.jface.preference.PreferenceManager;
import org.osgi.service.prefs.Preferences;

import edu.jhu.cs.bsj.eclipse.preference.BSJPreferenceKeys;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		System.out.println(Character.isJavaIdentifierPart('*'));
		
		//System.out.println(JavaCore.COMPILER_TASK_TAGS);
		
		String location = "org.eclipse.jdt.ui";
		IPreferencesService service = Platform.getPreferencesService();
		System.out.println(service);
		
		IEclipsePreferences configurationNode = new ConfigurationScope().getNode("com.example.myplugin");
		Preferences[] nodes = new Preferences[] {configurationNode};
		configurationNode.addPreferenceChangeListener(new IPreferenceChangeListener() {
			@Override
			public void preferenceChange(PreferenceChangeEvent event) {
				// DO SOMETHING
			}
		});
		//stringValue = service.get("MyPreference", "true", nodes);

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
