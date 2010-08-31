package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.api;

import edu.jhu.cs.bsj.compiler.ast.node.PackageNode;

public interface BsjPackagePseudoType extends BsjNoType
{
	/**
	 * Retrieves the package named by this type.
	 * @return The package named by this type.
	 */
	public PackageNode getPackage();
}
