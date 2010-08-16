package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type;

import java.util.Collections;
import java.util.List;

import edu.jhu.cs.bsj.compiler.ast.node.InitializerDeclarationNode;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.TypecheckerModelManager;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.api.BsjType;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.api.BsjTypeVariable;

public class InitializerExecutableTypeImpl extends AbstractExecutableTypeImpl<InitializerDeclarationNode>
{
	public InitializerExecutableTypeImpl(TypecheckerModelManager manager, InitializerDeclarationNode backingNode)
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
		return NoTypeImpl.makeVoid(getManager());
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
}
