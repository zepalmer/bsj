package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type;

import java.util.Map;

import edu.jhu.cs.bsj.compiler.ast.node.ConstructorDeclarationNode;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.TypecheckerManager;
import edu.jhu.cs.bsj.compiler.lang.type.BsjExecutableType;
import edu.jhu.cs.bsj.compiler.lang.type.BsjType;
import edu.jhu.cs.bsj.compiler.lang.type.BsjTypeArgument;
import edu.jhu.cs.bsj.compiler.lang.type.BsjTypeVariable;

public class ConstructorExecutableTypeImpl extends AbstractInvokableExecutableTypeImpl<ConstructorDeclarationNode>
{
	public ConstructorExecutableTypeImpl(TypecheckerManager manager, ConstructorDeclarationNode backingNode)
	{
		super(manager, backingNode);
	}

	protected ConstructorExecutableTypeImpl(TypecheckerManager manager, ConstructorDeclarationNode backingNode,
			Map<BsjTypeVariable, BsjTypeArgument> replacementMap)
	{
		super(manager, backingNode, replacementMap);
	}

	@Override
	public BsjType getReturnType()
	{
		return new VoidPseudoTypeImpl(getManager());
	}

	@Override
	public BsjExecutableType performTypeSubstitution(Map<BsjTypeVariable, BsjTypeArgument> substitutionMap)
	{
		return new ConstructorExecutableTypeImpl(getManager(), getBackingNode(), substitutionMap);
	}

	@Override
	public boolean isVarargs()
	{
		return this.getBackingNode().getVarargParameter() != null;
	}

}
