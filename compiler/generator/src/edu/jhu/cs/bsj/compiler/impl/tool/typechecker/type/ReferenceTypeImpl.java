package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type;

import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.TypecheckerManager;
import edu.jhu.cs.bsj.compiler.lang.type.BsjReferenceType;
import edu.jhu.cs.bsj.compiler.lang.type.BsjType;

public abstract class ReferenceTypeImpl extends TypeArgumentImpl implements BsjReferenceType
{
	public ReferenceTypeImpl(TypecheckerManager manager)
	{
		super(manager);
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

	@Override
	public boolean isSelectionConversionTo(BsjType type)
	{
		return false;
	}
	
    @Override
    public BsjReferenceType evaluate()
    {
        return this;
    }
}