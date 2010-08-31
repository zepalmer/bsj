package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type;

import javax.lang.model.type.TypeKind;

import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.TypecheckerManager;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.api.BsjTypeArgument;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.api.BsjVoidPseudoType;

public class VoidPseudoTypeImpl extends PseudoTypeImpl
{
	public VoidPseudoTypeImpl(TypecheckerManager manager)
	{
		super(manager, TypeKind.VOID);
	}

	@Override
	public BsjTypeArgument boxConvert()
	{
		return getManager().getToolkit().getVoidWrapperType();
	}

	@Override
	public int hashCode()
	{
		return 1681749930;
	}

	@Override
	public boolean equals(Object obj)
	{
		return obj instanceof BsjVoidPseudoType;
	}

	@Override
	public String toString()
	{
		return "void";
	}

}
