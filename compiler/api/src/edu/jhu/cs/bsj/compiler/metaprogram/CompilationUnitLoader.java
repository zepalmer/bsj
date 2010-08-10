package edu.jhu.cs.bsj.compiler.metaprogram;

import edu.jhu.cs.bsj.compiler.ast.node.CompilationUnitNode;
import edu.jhu.cs.bsj.compiler.ast.node.PackageNode;

/**
 * Objects meeting this interface allow metaprograms to load compilation units from the underlying file manager and
 * include them in compilation.
 * 
 * @author Zachary Palmer
 */
public interface CompilationUnitLoader
{
	// TODO: indicate how exceptions are raised in the event of a problem.
	/**
	 * Requests that a compilation unit of a specified name be loaded from the indicated package. If this operation is
	 * successful, the compilation unit will have been added to the package node by the time the method call terminates.
	 * Failure may occur due to parse failures or underlying I/O problems.
	 * 
	 * @param packageNode The package from which to load.
	 * @param name The name of the compilation unit to load.
	 * @return The loaded compilation unit, or <code>null</code> if the compilation unit does not exist.
	 */
	public CompilationUnitNode load(PackageNode packageNode, String name);

	// TODO: indicate how exceptions are raised in the event of a problem.
	/**
	 * Requests that all available compilation units be loaded from the indicated package. If this operation is
	 * successful, the compilation unit will have been added to the package node by the time the method call terminates.
	 * Failure may occur due to parse failures or underlying I/O problems.
	 * 
	 * @param packageNode The package from which to load.
	 */
	public void loadAll(PackageNode packageNode);
}
