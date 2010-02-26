package edu.jhu.cs.bsj.compiler.tool;

import edu.jhu.cs.bsj.compiler.BsjServiceRegistry;
import edu.jhu.cs.bsj.compiler.tool.filemanager.BsjFileManager;

/**
 * Serves as a factory for creating BSJ toolkits.  An instance of this class may be obtained through the
 * {@link BsjServiceRegistry}.
 * 
 * @see BsjServiceRegistry
 * @see BsjToolkit  
 * @author Zachary Palmer
 */
public interface BsjToolkitFactory
{
	/**
	 * Specifies the file manager to use when creating the toolkit.
	 * @param manager The file manager to use.
	 */
	public void setFileManager(BsjFileManager manager);
	
	/**
	 * Creates a toolkit using this factory's configuration.
	 * @return The new toolkit.
	 */
	public BsjToolkit newToolkit();
}
