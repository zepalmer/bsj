package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.namespace;

import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.VariableElement;

import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.element.DeclaredTypeElementImpl;

/**
 * This class represents a compilation environment in BSJ. An environment corresponds to an AST subtree; each subtree
 * may have its own environment.
 * 
 * @author Zachary Palmer
 */
public class Environment
{
	/** The type namespace in this environment. */
	private NamespaceMap<DeclaredTypeElementImpl<?>> typeNamespaceMap;
	/** The method namespace in this environment.  */
	private NamespaceMap<ExecutableElement> methodNamespaceMap;
	/** The variable namespace in this environment. */
	private NamespaceMap<VariableElement> variableNamespaceMap;

	public Environment(NamespaceMap<DeclaredTypeElementImpl<?>> typeNamespaceMap,
			NamespaceMap<ExecutableElement> methodNamespaceMap, NamespaceMap<VariableElement> variableNamespaceMap)
	{
		super();
		this.typeNamespaceMap = typeNamespaceMap;
		this.methodNamespaceMap = methodNamespaceMap;
		this.variableNamespaceMap = variableNamespaceMap;
	}

	public NamespaceMap<DeclaredTypeElementImpl<?>> getTypeNamespaceMap()
	{
		return typeNamespaceMap;
	}
	
	public NamespaceMap<ExecutableElement> getMethodNamespaceMap()
	{
		return methodNamespaceMap;
	}

	public NamespaceMap<VariableElement> getVariableNamespaceMap()
	{
		return variableNamespaceMap;
	}
}
