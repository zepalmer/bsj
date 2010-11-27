package edu.jhu.cs.bsj.eclipse;

import org.eclipse.core.runtime.preferences.ConfigurationScope;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.core.runtime.preferences.InstanceScope;

public class BSJPluginService {
	
	private BSJPluginService() {
	}
	
	public static final String JavaPreferenceLocation = "org.eclipse.jdt.ui";
	
	public static final String BSJPreferenceLocation = "edu.jhu.cs.bsj.eclipse.plugin";

	private static IEclipsePreferences[] javaPreferenceNodes;
	
	private static IEclipsePreferences[] bsjPreferenceNodes ;
	
	public static final IEclipsePreferences[] getJavaPreferenceNodes() {
		if(javaPreferenceNodes==null) {
			javaPreferenceNodes = new IEclipsePreferences[] {
				new ConfigurationScope().getNode(JavaPreferenceLocation),
				new InstanceScope().getNode(JavaPreferenceLocation)
			};
		}
		return javaPreferenceNodes;
	}
	
	public static final IEclipsePreferences[] getBSJPreferenceNodes() {
		if(bsjPreferenceNodes==null) {
			bsjPreferenceNodes = new IEclipsePreferences[] {
				new ConfigurationScope().getNode(BSJPreferenceLocation),
				new InstanceScope().getNode(BSJPreferenceLocation)
			};
		}
		return bsjPreferenceNodes;
	}
}
