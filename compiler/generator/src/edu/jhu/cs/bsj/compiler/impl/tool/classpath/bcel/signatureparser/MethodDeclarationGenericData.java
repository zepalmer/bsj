package edu.jhu.cs.bsj.compiler.impl.tool.classpath.bcel.signatureparser;

import java.util.List;

import edu.jhu.cs.bsj.compiler.ast.node.TypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.VariableNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.TypeParameterListNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.UnparameterizedTypeListNode;

/**
 * Contains the generic data obtained from a generic signature attached to a method declaration.
 * 
 * @author Zachary Palmer
 */
public class MethodDeclarationGenericData
{
	private List<VariableNode> variables;
	private TypeNode returnType;
	private UnparameterizedTypeListNode throwsClause;
	private TypeParameterListNode typeParameters;

	public MethodDeclarationGenericData(List<VariableNode> variables, TypeNode returnType,
			UnparameterizedTypeListNode throwsClause, TypeParameterListNode typeParameters)
	{
		super();
		this.variables = variables;
		this.returnType = returnType;
		this.throwsClause = throwsClause;
		this.typeParameters = typeParameters;
	}

	public List<VariableNode> getVariables()
	{
		return variables;
	}

	public TypeNode getReturnType()
	{
		return returnType;
	}

	public UnparameterizedTypeListNode getThrowsClause()
	{
		return throwsClause;
	}

	public TypeParameterListNode getTypeParameters()
	{
		return typeParameters;
	}

}
