package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type;

import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.TypecheckerManager;
import edu.jhu.cs.bsj.compiler.lang.type.BsjTypeArgument;

public abstract class TypeArgumentImpl extends ActualTypeImpl implements BsjTypeArgument
{

	public TypeArgumentImpl(TypecheckerManager manager)
	{
		super(manager);
	}

	@Override
	public boolean contains(BsjTypeArgument argument)
	{
		// Only wildcard types contain types which are not themselves
		return this.equals(argument);
	}

	@Override
	public BsjTypeArgument boxConvert()
	{
		return this;
	}
}