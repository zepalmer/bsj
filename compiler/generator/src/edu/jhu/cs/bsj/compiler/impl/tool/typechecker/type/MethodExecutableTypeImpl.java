package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type;

import java.util.Map;

import edu.jhu.cs.bsj.compiler.ast.node.MethodDeclarationNode;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.TypecheckerManager;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.api.BsjType;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.api.BsjTypeArgument;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.api.BsjTypeVariable;

public class MethodExecutableTypeImpl extends AbstractInvokableExecutableTypeImpl<MethodDeclarationNode>
{
	public MethodExecutableTypeImpl(TypecheckerManager manager, MethodDeclarationNode backingNode)
	{
		super(manager, backingNode);
	}

	public MethodExecutableTypeImpl(TypecheckerManager manager, MethodDeclarationNode backingNode,
			Map<BsjTypeVariable, BsjTypeArgument> replacementMap)
	{
		super(manager, backingNode, replacementMap);
	}

	@Override
	public BsjType getReturnType()
	{
		return getTypeBuilder().makeType(getBackingNode().getReturnType());
	}

	@Override
	public BsjTypeArgument performTypeSubstitution(Map<BsjTypeVariable, BsjTypeArgument> substitutionMap)
	{
		return new MethodExecutableTypeImpl(getManager(), getBackingNode(), substitutionMap);
	}
}
