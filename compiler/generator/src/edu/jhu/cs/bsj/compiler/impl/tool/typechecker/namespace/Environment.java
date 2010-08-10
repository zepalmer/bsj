package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.namespace;


/**
 * This class represents a compilation environment in BSJ. An environment corresponds to an AST subtree; each subtree
 * may have its own environment.
 * 
 * @author Zachary Palmer
 */
public class Environment
{
	// TODO: environment doesn't currently handle throwable exception types
	// TODO: environment doesn't handle statement labels
	// TODO: environment doesn't handle definite assignment
	// but none of this is necessary for code literal analysis, so they're in the nice-to-have category
	/** The type namespace in this environment. */
	private TypeNamespaceMap typeNamespaceMap;
	/** The method namespace in this environment. */
	private MethodNamespaceMap methodNamespaceMap;
	/** The variable namespace in this environment. */
	private VariableNamespaceMap variableNamespaceMap;

	public Environment(TypeNamespaceMap typeNamespaceMap,
			MethodNamespaceMap methodNamespaceMap, VariableNamespaceMap variableNamespaceMap)
	{
		super();
		this.typeNamespaceMap = typeNamespaceMap;
		this.methodNamespaceMap = methodNamespaceMap;
		this.variableNamespaceMap = variableNamespaceMap;
	}

	public TypeNamespaceMap getTypeNamespaceMap()
	{
		return typeNamespaceMap;
	}

	public MethodNamespaceMap getMethodNamespaceMap()
	{
		return methodNamespaceMap;
	}

	public VariableNamespaceMap getVariableNamespaceMap()
	{
		return variableNamespaceMap;
	}

	/**
	 * Produces an environment which reduces resource consumption. The provided environment should be the base for this
	 * environment; its namespaces should be used as bases for this environment's namespaces. This method will return a
	 * reduced environment which is intended to reduce indirection and memory footprint.
	 * 
	 * @param base The base environment.
	 * @return The environment which should be used instead of this environment.
	 */
	public Environment reduce(Environment base)
	{
		if (this == base)
			return this;
		
		final boolean isTypeNamespaceMapSame = this.getTypeNamespaceMap().definitelyReplacableBy(base.getTypeNamespaceMap());
		final boolean isMethodNamespaceMapSame = this.getMethodNamespaceMap().definitelyReplacableBy(
				base.getMethodNamespaceMap());
		final boolean isVariableNamespaceMapSame = this.getVariableNamespaceMap().definitelyReplacableBy(
				base.getVariableNamespaceMap());
		if (!isTypeNamespaceMapSame || !isMethodNamespaceMapSame || !isVariableNamespaceMapSame)
		{
			return new Environment(
					(isTypeNamespaceMapSame ? base : this).getTypeNamespaceMap(),
					(isMethodNamespaceMapSame ? base : this).getMethodNamespaceMap(),
					(isVariableNamespaceMapSame ? base : this).getVariableNamespaceMap());
		} else
		{
			return this;
		}
	}
	
	/**
	 * Locks this environment, preventing any further changes to its namespace map at penalty of a runtime failure.
	 */
	public void lock()
	{
		this.typeNamespaceMap.lock();
		this.methodNamespaceMap.lock();
		this.variableNamespaceMap.lock();
	}
	
	/**
	 * Creates a string representing this environment.
	 */
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		sb.append("Types:     ");
		sb.append(this.typeNamespaceMap);
		sb.append("\n");
		sb.append("Methods:   ");
		sb.append(this.methodNamespaceMap);
		sb.append("\n");
		sb.append("Variables: ");
		sb.append(this.variableNamespaceMap);
		sb.append("\n");
		return sb.toString();
	}
}
