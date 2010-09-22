package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import edu.jhu.cs.bsj.compiler.ast.node.InitializerDeclarationNode;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.TypecheckerManager;
import edu.jhu.cs.bsj.compiler.lang.type.BsjExecutableType;
import edu.jhu.cs.bsj.compiler.lang.type.BsjType;
import edu.jhu.cs.bsj.compiler.lang.type.BsjTypeArgument;
import edu.jhu.cs.bsj.compiler.lang.type.BsjTypeVariable;

public class InitializerExecutableTypeImpl extends AbstractExecutableTypeImpl<InitializerDeclarationNode>
{
	public InitializerExecutableTypeImpl(TypecheckerManager manager, InitializerDeclarationNode backingNode)
	{
		super(manager, backingNode);
	}

	@Override
	public List<? extends BsjType> getParameterTypes()
	{
		return Collections.emptyList();
	}

	@Override
	public BsjType getReturnType()
	{
		return new VoidPseudoTypeImpl(getManager());
	}

	@Override
	public List<? extends BsjType> getThrownTypes()
	{
		return Collections.emptyList();
	}

	@Override
	public List<? extends BsjTypeVariable> getTypeVariables()
	{
		return Collections.emptyList();
	}

	@Override
	public String toString()
	{
		return "<initailizer>";
	}

	@Override
	public BsjExecutableType performTypeSubstitution(Map<BsjTypeVariable, BsjTypeArgument> substitutionMap)
	{
		return this;
	}

	@Override
	public boolean isVarargs()
	{
		return false;
	}
}
