package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type;

import javax.lang.model.type.TypeKind;

import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.TypecheckerManager;
import edu.jhu.cs.bsj.compiler.lang.type.BsjNonePseudoType;
import edu.jhu.cs.bsj.compiler.lang.type.BsjTypeArgument;

public class NonePseudoTypeImpl extends PseudoTypeImpl implements BsjNonePseudoType
{

	public NonePseudoTypeImpl(TypecheckerManager manager)
	{
		super(manager, TypeKind.NONE);
	}

	@Override
	public BsjTypeArgument boxConvert()
	{
		return null;
	}

	@Override
	public int hashCode()
	{
		return 1033403275;
	}

	@Override
	public boolean equals(Object obj)
	{
		return obj instanceof BsjNonePseudoType;
	}

	@Override
	public String toString()
	{
		return "(no type)";
	}
}
