package edu.jhu.cs.bsj.compiler.impl.tool.typechecker;

import edu.jhu.cs.bsj.compiler.ast.node.PackageNode;

/**
 * This class provides common state information for modeling types and elements in the typechecker.
 * @author Zachary Palmer
 */
public class TypecheckerModelManager
{
	/** The root package. */
	private PackageNode rootPackage;

	public TypecheckerModelManager(PackageNode rootPackage)
	{
		super();
		this.rootPackage = rootPackage;
	}

	public PackageNode getRootPackage()
	{
		return rootPackage;
	}
	
	
}
