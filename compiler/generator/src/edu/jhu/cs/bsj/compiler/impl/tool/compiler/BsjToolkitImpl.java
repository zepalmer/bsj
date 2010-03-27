package edu.jhu.cs.bsj.compiler.impl.tool.compiler;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.BsjSourceSerializer;
import edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeFactoryImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeManager;
import edu.jhu.cs.bsj.compiler.impl.ast.PackageNodeCallback;
import edu.jhu.cs.bsj.compiler.impl.tool.serializer.BsjSourceSerializerImpl;
import edu.jhu.cs.bsj.compiler.tool.BsjCompiler;
import edu.jhu.cs.bsj.compiler.tool.BsjToolkit;
import edu.jhu.cs.bsj.compiler.tool.filemanager.BsjFileManager;
import edu.jhu.cs.bsj.compiler.tool.parser.BsjParser;
import edu.jhu.cs.bsj.compiler.tool.parser.BsjParserImpl;

/**
 * A standard implementation of the BSJ toolkit.
 * @author Zachary Palmer
 */
public class BsjToolkitImpl implements BsjToolkit
{
	/** This toolkit's file manager. */
	private BsjFileManager fileManager;
	/** This toolkit's parser. */
	private BsjParser parser;
	/** This toolkit's node factory. */
	private BsjNodeFactory factory;
	/** This toolkit's compiler. */
	private BsjCompiler compiler;
	/** This toolkit's serializer. */
	private BsjSourceSerializer serializer;
	
	public BsjToolkitImpl(BsjFileManager fileManager)
	{
		super();
		this.fileManager = fileManager;
		PackageNodeCallback packageNodeCallback = new PackageNodeCallback();
		packageNodeCallback.setFileManager(fileManager);
		BsjNodeManager manager = new BsjNodeManager();
		this.factory = new BsjNodeFactoryImpl(packageNodeCallback, manager);
		manager.setToolkit(this);
		packageNodeCallback.setFactory(this.factory);
		this.parser = new BsjParserImpl(this.factory);
		this.compiler = new StandardBsjCompiler(this, packageNodeCallback, manager);
		this.serializer = new BsjSourceSerializerImpl();
	}

	@Override
	public BsjCompiler getCompiler()
	{
		return this.compiler;
	}

	@Override
	public BsjFileManager getFileManager()
	{
		return this.fileManager;
	}

	@Override
	public BsjNodeFactory getNodeFactory()
	{
		return this.factory;
	}

	@Override
	public BsjParser getParser()
	{
		return this.parser;
	}

	@Override
	public BsjSourceSerializer getSerializer()
	{
		return this.serializer;
	}
}
