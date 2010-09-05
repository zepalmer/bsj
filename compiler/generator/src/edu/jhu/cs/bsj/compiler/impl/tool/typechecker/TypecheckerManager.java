package edu.jhu.cs.bsj.compiler.impl.tool.typechecker;

import javax.tools.DiagnosticListener;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.node.PackageNode;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.namespace.NamespaceBuilder;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.parsemap.ParseMapper;
import edu.jhu.cs.bsj.compiler.metaprogram.CompilationUnitLoader;
import edu.jhu.cs.bsj.compiler.tool.parser.BsjParser;

/**
 * This class represents the set of tools and logic which is necessary to perform BSJ typechecking.  Some operations
 * use caching to significantly improve performance; as a result, users of this object must not rely upon it if the
 * AST changes.
 * @author Zachary Palmer
 */
public class TypecheckerManager
{
	/** The root package. */
	private PackageNode rootPackage;
	/** This manager's toolkit. */
	private TypecheckerToolkit toolkit;
	/** The compilation unit loader to use. */
	private CompilationUnitLoader loader;
	/** The environment manager for this typechecker manager. */
	private NamespaceBuilder namespaceBuilder;
	/** The parse mapping manager for this typechecker manager. */
	private ParseMapper parseMapper;
	/** The type checker for this typechecker manager. */
	private Typechecker typechecker;
	
	/**
	 * Creates a new manager.
	 * @param rootPackage The root package over which type checking will be performed.
	 * @param diagnosticListener The diagnostic listener to which to report errors.
	 */
	public TypecheckerManager(PackageNode rootPackage, BsjParser parser, CompilationUnitLoader loader, DiagnosticListener<BsjSourceLocation> diagnosticListener)
	{
		super();
		this.rootPackage = rootPackage;
		this.loader = loader;
		
		this.toolkit = new TypecheckerToolkit(this, loader);
		this.namespaceBuilder = new NamespaceBuilder(this.rootPackage, diagnosticListener, this.loader, this.toolkit);
		this.parseMapper = new ParseMapper(this, parser);
		this.typechecker = new Typechecker(this);
	}

	public CompilationUnitLoader getLoader()
	{
		return loader;
	}

	public PackageNode getRootPackage()
	{
		return rootPackage;
	}

	public TypecheckerToolkit getToolkit()
	{
		return toolkit;
	}
	
	public NamespaceBuilder getNamespaceBuilder()
	{
		return namespaceBuilder;
	}

	public ParseMapper getParseMapper()
	{
		return parseMapper;
	}

	public Typechecker getTypechecker()
	{
		return typechecker;
	}
}
