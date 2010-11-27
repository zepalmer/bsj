package edu.jhu.cs.bsj.eclipse.preference;

import org.eclipse.core.runtime.preferences.IEclipsePreferences.IPreferenceChangeListener;
import org.eclipse.core.runtime.preferences.IEclipsePreferences.PreferenceChangeEvent;

public class SyntaxColoringPreferenceChangeListener implements
		IPreferenceChangeListener {

	@Override
	public void preferenceChange(PreferenceChangeEvent event) {
		System.out.println("MY PREFERENCE STORE WAS JUST CHANGED");
	}

}
