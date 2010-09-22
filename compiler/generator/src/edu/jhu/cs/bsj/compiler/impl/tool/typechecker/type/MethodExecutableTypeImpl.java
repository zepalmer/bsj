package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import edu.jhu.cs.bsj.compiler.ast.node.MethodDeclarationNode;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.TypecheckerManager;
import edu.jhu.cs.bsj.compiler.lang.type.BsjExecutableType;
import edu.jhu.cs.bsj.compiler.lang.type.BsjType;
import edu.jhu.cs.bsj.compiler.lang.type.BsjTypeArgument;
import edu.jhu.cs.bsj.compiler.lang.type.BsjTypeVariable;

public class MethodExecutableTypeImpl extends AbstractInvokableExecutableTypeImpl<MethodDeclarationNode>
{
	private BsjType returnType;

	public MethodExecutableTypeImpl(TypecheckerManager manager, MethodDeclarationNode backingNode)
	{
		super(manager, backingNode);
		this.returnType = getTypeBuilder().makeType(getBackingNode().getReturnType());
	}

	public MethodExecutableTypeImpl(TypecheckerManager manager, MethodDeclarationNode backingNode,
			Map<BsjTypeVariable, BsjTypeArgument> substitutionMap)
	{
		super(manager, backingNode, substitutionMap);
		this.returnType = getTypeBuilder().makeType(getBackingNode().getReturnType());
		substitute(substitutionMap);
	}

	public MethodExecutableTypeImpl(TypecheckerManager manager, MethodDeclarationNode backingNode,
			List<BsjType> parameterTypes, List<BsjType> thrownTypes, List<BsjTypeVariable> typeVariables,
			BsjType returnType, Map<BsjTypeVariable, BsjTypeArgument> substitutionMap)
	{
		super(manager, backingNode, parameterTypes, thrownTypes, typeVariables, substitutionMap);
		this.returnType = returnType;
		substitute(substitutionMap);
	}

	private void substitute(Map<BsjTypeVariable, BsjTypeArgument> substitutionMap)
	{
		this.returnType = this.returnType.performTypeSubstitution(substitutionMap);
	}

	@Override
	public BsjType getReturnType()
	{
		return this.returnType;
	}

	@Override
	public BsjExecutableType performTypeSubstitution(Map<BsjTypeVariable, BsjTypeArgument> substitutionMap)
	{
		return new MethodExecutableTypeImpl(this.getManager(), this.getBackingNode(), new ArrayList<BsjType>(
				this.getParameterTypes()), new ArrayList<BsjType>(this.getThrownTypes()),
				new ArrayList<BsjTypeVariable>(this.getTypeVariables()), this.returnType, substitutionMap);
	}

	@Override
	public boolean isVarargs()
	{
		return this.getBackingNode().getVarargParameter() != null;
	}
}
