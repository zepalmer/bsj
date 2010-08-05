package edu.jhu.cs.bsj.compiler.impl.tool.typechecker;

import java.util.Collection;

import javax.tools.DiagnosticListener;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.node.CompilationUnitNode;
import edu.jhu.cs.bsj.compiler.ast.node.PackageNode;
import edu.jhu.cs.bsj.compiler.tool.BsjToolkit;

/**
 * This module performs type checking as per the Java Language Specification v3. It also includes the modifications
 * indicated in the Backstage Java Language Specification, specifically with regard to code literals and parse mapping.
 * 
 * @author Zachary Palmer
 */
public class TypeChecker
{
	/** The toolkit to be used by this type checker. */
	private BsjToolkit toolkit;

	/**
	 * Creates a new type checker.
	 * 
	 * @param toolkit The toolkit to be used by this type checker.
	 */
	public TypeChecker(BsjToolkit toolkit)
	{
		super();
		this.toolkit = toolkit;
	}

	/**
	 * Performs a type checking operation on the provided {@link CompilationUnitNode}s. Type checking failures are
	 * reported to the provided {@link DiagnosticListener}.
	 * 
	 * @param compilationUnitNodes The {@link CompilationUnitNode}s which should be typechecked.
	 * @param diagnosticListener The {@link DiagnosticListener} to which diagnostic information should be reported.
	 * @throws IllegalStateException If any of the provided {@link CompilationUnitNode}s are not connected to a root
	 *             package.
	 */
	public void typecheck(Collection<CompilationUnitNode> compilationUnitNodes,
			DiagnosticListener<BsjSourceLocation> diagnosticListener)
	{
		// Precondition: root package must be available
		for (CompilationUnitNode compilationUnitNode : compilationUnitNodes)
		{
			PackageNode rootPackage = compilationUnitNode.getRootPackage();
			if (rootPackage == null)
			{
				throw new IllegalStateException(
						"Cannot typecheck a compilation unit which is not connected to a package hierarchy.");
			}
		}
		
		// TODO: implement overall typechecking algorithm

	}
}
