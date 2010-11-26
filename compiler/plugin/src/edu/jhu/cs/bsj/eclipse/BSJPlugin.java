package edu.jhu.cs.bsj.eclipse;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

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
	
	// color manager shared by the plug-in
	private IColorManager colorManager;
	
	/**
	 * The constructor
	 */
	public BSJPlugin() {
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
		colorManager = new ColorManager();
		
		Test.main(null);
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		colorManager.dispose();
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

	/**
	 * @return the color manager shared by the plug-in
	 */
	public IColorManager getColorManager() {
		return colorManager;
	}
	
}
