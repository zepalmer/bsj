package edu.jhu.cs.bsj.eclipse;

import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

import edu.jhu.cs.bsj.eclipse.preference.SyntaxColoringPreferenceChangeListener;
import edu.jhu.cs.bsj.eclipse.util.ColorManager;
import edu.jhu.cs.bsj.eclipse.util.IColorManager;

/**
 * The activator class controls the plug-in life cycle
 */
public class BSJPlugin extends AbstractUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "BSJ_Eclipse_Plugin"; //$NON-NLS-1$

	// The shared instance
	private static BSJPlugin plugin;
	
	/**
	 * The constructor
	 */
	public BSJPlugin() {
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
		initColorManager();
		initPreferenceListeners();
		plugin = this;
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
	 */
	@Override
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		disposeColorManager();
		disposePreferenceListeners();
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static BSJPlugin getDefault() {
		return plugin;
	}

	
	private IColorManager colorManager;
	
	/**
	 * @return the color manager shared by the plug-in
	 */
	public IColorManager getColorManager() {
		return colorManager;
	}
	
	private void initColorManager() {
		colorManager = new ColorManager();
	}
	
	private void disposeColorManager() {
		colorManager.dispose();
	}
	
	private SyntaxColoringPreferenceChangeListener syntaxColoringPreferenceChangelistener;
	
	private void initPreferenceListeners() {
		syntaxColoringPreferenceChangelistener = new SyntaxColoringPreferenceChangeListener();
		IEclipsePreferences[] javaNodes = BSJPluginService.getJavaPreferenceNodes();
		for(int i=0; i<javaNodes.length; i++) {
			if(javaNodes[i]!=null)
				javaNodes[i].addPreferenceChangeListener(syntaxColoringPreferenceChangelistener);
		}
		IEclipsePreferences[] bsjNodes = BSJPluginService.getBSJPreferenceNodes();
		for(int i=0; i<bsjNodes.length; i++) {
			if(bsjNodes[i]!=null)
				bsjNodes[i].addPreferenceChangeListener(syntaxColoringPreferenceChangelistener);
		}
	}
	
	private void disposePreferenceListeners() {
		IEclipsePreferences[] javaNodes = BSJPluginService.getJavaPreferenceNodes();
		for(int i=0; i<javaNodes.length; i++) {
			if(javaNodes[i]!=null)
				javaNodes[i].removePreferenceChangeListener(syntaxColoringPreferenceChangelistener);
		}
		IEclipsePreferences[] bsjNodes = BSJPluginService.getBSJPreferenceNodes();
		for(int i=0; i<bsjNodes.length; i++) {
			if(bsjNodes[i]!=null)
				bsjNodes[i].removePreferenceChangeListener(syntaxColoringPreferenceChangelistener);
		}
	}
	
}
