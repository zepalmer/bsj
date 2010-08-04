package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.namespace;

/**
 * This class represents a compilation environment in BSJ.  An environment corresponds to an AST subtree; each subtree
 * may have its own environment.
 * @author Zachary Palmer
 */
public class Environment
{
	/** The {@link TypeNamespaceMap} in this environment. */
	private TypeNamespaceMap typeNamespaceMap;
	
	public Environment(TypeNamespaceMap typeNamespaceMap)
	{
		super();
		this.typeNamespaceMap = typeNamespaceMap;
	}

	public TypeNamespaceMap getTypeNamespaceMap()
	{
		return typeNamespaceMap;
	}
}
