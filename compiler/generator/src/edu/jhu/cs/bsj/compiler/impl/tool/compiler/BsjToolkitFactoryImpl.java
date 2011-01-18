package edu.jhu.cs.bsj.compiler.impl.tool.compiler;

import edu.jhu.cs.bsj.compiler.BsjServiceRegistry;
import edu.jhu.cs.bsj.compiler.tool.BsjToolkit;
import edu.jhu.cs.bsj.compiler.tool.BsjToolkitFactory;
import edu.jhu.cs.bsj.compiler.tool.filemanager.BsjFileManager;

/**
 * Serves as a standard implementation of the toolkit factory.
 * @author Zachary Palmer
 */
public class BsjToolkitFactoryImpl implements BsjToolkitFactory
{
	/** The file manager to provide to the toolkit on construction. */
	private BsjFileManager fileManager;
	
	public BsjToolkitFactoryImpl()
	{
		this.fileManager = BsjServiceRegistry.getInstance().newFileManagerFactory().newFileManager();
	}

	@Override
	public BsjToolkit newToolkit()
	{
		return new BsjToolkitImpl(this.fileManager);
	}

	@Override
	public void setFileManager(BsjFileManager manager)
	{
		this.fileManager = manager;
	}
}
