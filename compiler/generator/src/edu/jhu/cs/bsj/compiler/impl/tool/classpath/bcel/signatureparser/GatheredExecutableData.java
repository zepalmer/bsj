package edu.jhu.cs.bsj.compiler.impl.tool.classpath.bcel.signatureparser;

import org.apache.bcel.classfile.Method;

import edu.jhu.cs.bsj.compiler.ast.node.TypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.VariableNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.TypeParameterListNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.UnparameterizedTypeListNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.VariableListNode;

/**
 * Contains some data obtained from analysis of a BCEL {@link Method} object.
 * 
 * @author Zachary Palmer
 */
public class GatheredExecutableData
{
	private VariableListNode variables;
	private VariableNode vararg;
	private TypeNode returnType;
	private UnparameterizedTypeListNode throwsClause;
	private TypeParameterListNode typeParameters;

	public GatheredExecutableData(VariableListNode variables, VariableNode vararg, TypeNode returnType,
			UnparameterizedTypeListNode throwsClause, TypeParameterListNode typeParameters)
	{
		super();
		this.variables = variables;
		this.vararg = vararg;
		this.returnType = returnType;
		this.throwsClause = throwsClause;
		this.typeParameters = typeParameters;
	}

	public VariableListNode getVariables()
	{
		return variables;
	}

	public VariableNode getVararg()
	{
		return vararg;
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
