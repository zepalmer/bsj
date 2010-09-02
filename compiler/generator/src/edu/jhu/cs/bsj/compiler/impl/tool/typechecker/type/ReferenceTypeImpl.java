package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type;

import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.TypecheckerManager;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.api.BsjReferenceType;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.api.BsjType;

public abstract class ReferenceTypeImpl extends TypeArgumentImpl implements BsjReferenceType
{
	public ReferenceTypeImpl(TypecheckerManager manager)
	{
		super(manager);
	}

	@Override
	public boolean isWideningReferenceConversionTo(BsjType type)
	{
		return this.isSubtypeOf(type);
	}

	@Override
	public boolean isNarrowingPrimitiveConversionTo(BsjType type)
	{
		return false;
	}

	@Override
	public boolean isWideningPrimitiveConversionTo(BsjType type)
	{
		return false;
	}

	@Override
	public boolean isWideningAndNarrowingPrimitiveConversionTo(BsjType type)
	{
		return false;
	}
	
}