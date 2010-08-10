package edu.jhu.cs.bsj.compiler.tool;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.BsjSourceSerializer;
import edu.jhu.cs.bsj.compiler.metaprogram.CompilationUnitLoader;
import edu.jhu.cs.bsj.compiler.metaprogram.CompilationUnitLoaderFactory;
import edu.jhu.cs.bsj.compiler.tool.filemanager.BsjFileManager;
import edu.jhu.cs.bsj.compiler.tool.parser.BsjParser;

/**
 * This interface represents a collection of BSJ tools which are meant to be used together. As a general rule, a tool in
 * a BSJ toolkit can only work with other tools in its own toolkit. For example, it is required that all ASTs provided
 * to the BSJ compiler are comprised of nodes created exclusively from the BSJ node factory which was obtained from the
 * same toolkit as the compiler. Typical usage involves the creation of a toolkit from a {@link BsjToolkitFactory} and
 * then use of that toolkit throughout the life of the application.
 * 
 * @author Zachary Palmer
 */
public interface BsjToolkit
{
	/**
	 * Retrieves this toolkit's compiler.
	 */
	public BsjCompiler getCompiler();
	
	/**
	 * Retrieves this toolkit's parser.
	 */
	public BsjParser getParser();
	
	/**
	 * Retrieves this toolkit's node factory.
	 */
	public BsjNodeFactory getNodeFactory();
	
	/**
	 * Retrieves this toolkit's file manager.
	 */
	public BsjFileManager getFileManager();
	
	/**
	 * Retrieves this toolkit's source serializer.
	 */
	public BsjSourceSerializer getSerializer();
	
	/**
	 * Retrieves a {@link CompilationUnitLoader} which can be used to read compilation units from the file manager.
	 * @param listener The listener to use to report diagnostics.
	 */
	public CompilationUnitLoaderFactory getCompilationUnitLoaderFactory();
}
