package edu.jhu.cs.bsj.compiler.tool.typechecker;

import javax.tools.DiagnosticListener;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.node.PackageNode;

/**
 * This factory which can produce typecheckers for a given type of AST node.
 * 
 * @author Zachary Palmer
 */
public interface BsjTypecheckerFactory
{
	/**
	 * Creates a new typechecker. This typechecker may perform caching operations and so should not be relied upon if
	 * the underlying AST changes.
	 * 
	 * @param rootPackage A root package to use in creating the typechecker.
	 * @param diagnosticListener The diagnostic listener to use for this typechecker.
	 * @return The new typechecker.
	 */
	public BsjTypechecker makeTypechecker(PackageNode rootPackage,
			DiagnosticListener<BsjSourceLocation> diagnosticListener);
}
