package edu.jhu.cs.bsj.compiler.impl.tool.compiler;

import javax.tools.DiagnosticListener;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.BsjSourceSerializer;
import edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeFactoryImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeManager;
import edu.jhu.cs.bsj.compiler.impl.metaprogram.CompilationUnitLoaderImpl;
import edu.jhu.cs.bsj.compiler.impl.tool.parser.BsjParserImpl;
import edu.jhu.cs.bsj.compiler.impl.tool.serializer.BsjSourceSerializerImpl;
import edu.jhu.cs.bsj.compiler.metaprogram.CompilationUnitLoader;
import edu.jhu.cs.bsj.compiler.tool.BsjCompiler;
import edu.jhu.cs.bsj.compiler.tool.BsjToolkit;
import edu.jhu.cs.bsj.compiler.tool.filemanager.BsjFileManager;
import edu.jhu.cs.bsj.compiler.tool.parser.BsjParser;

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
	
	/** The node manager used to create compilation unit loaders. */
	private BsjNodeManager nodeManager;
	
	public BsjToolkitImpl(BsjFileManager fileManager)
	{
		super();
		this.fileManager = fileManager;
		
		this.nodeManager = new BsjNodeManager(this);
		
		this.factory = new BsjNodeFactoryImpl(nodeManager);
		this.parser = new BsjParserImpl(this.factory);
		this.compiler = new StandardBsjCompiler(this, nodeManager);
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
	
	@Override
	public CompilationUnitLoader getCompilationUnitLoader(DiagnosticListener<BsjSourceLocation> listener)
	{
		return new CompilationUnitLoaderImpl(this.nodeManager.getPackageNodeManager(), listener);
	}
}
