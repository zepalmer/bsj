package edu.jhu.cs.bsj.eclipse.preference;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;

import edu.jhu.cs.bsj.eclipse.BSJPlugin;

public class SyntaxColoringPreferenceInitializer extends AbstractPreferenceInitializer {

	@Override
	public void initializeDefaultPreferences() {
		IPreferenceStore store = BSJPlugin.getDefault().getPreferenceStore();
		//store.setDefault(BSJPreferenceConstants.P_BOOLEAN, true);
		//store.setDefault(BSJPreferenceConstants.P_CHOICE, "choice2");
		//store.setDefault(BSJPreferenceConstants.P_STRING, "Default value");
	}
}
