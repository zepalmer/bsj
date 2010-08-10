package edu.jhu.cs.bsj.compiler.impl.ast;

import javax.tools.DiagnosticListener;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.node.CompilationUnitNode;
import edu.jhu.cs.bsj.compiler.ast.node.PackageNode;

/**
 * A listener which is used to report events pertaining to package nodes. It also acts as an extension of a diagnostic
 * listener and receives diagnostic messages related to parsing compilation units within packages.
 * 
 * @author Zachary Palmer
 */
public interface PackageNodeListener extends DiagnosticListener<BsjSourceLocation>
{
	/**
	 * Invoked when a new compilation unit is added to a package node.
	 * 
	 * @param packageNode The affected {@link PackageNode}.
	 * @param compilationUnitNode The new {@link CompilationUnitNode}.
	 * @param purelyInjected <code>true</code> if this compilation unit was purely injected; <code>false</code> if it
	 *            was loaded.
	 */
	public void compilationUnitAdded(PackageNode packageNode, CompilationUnitNode compilationUnitNode, boolean purelyInjected);

	/**
	 * Invoked when a subpackage is added to a package node. This method is also invoked when a subpackage is created on
	 * demand.
	 * 
	 * @param packageNode The affected {@link PackageNode}.
	 * @param subPackageNode The new {@link PackageNode}.
	 */
	public void subpackageAdded(PackageNode packageNode, PackageNode subPackageNode);

	/**
	 * Invoked when the current metaprogram becomes responsible for injecting all metaprograms in the provided
	 * {@link CompilationUnit} into the AST.
	 */
	public void compilationUnitInjected(CompilationUnitNode compilationUnitNode);
}
