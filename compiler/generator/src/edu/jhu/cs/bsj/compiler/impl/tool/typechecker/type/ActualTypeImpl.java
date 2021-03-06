package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type;

import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.TypecheckerManager;
import edu.jhu.cs.bsj.compiler.lang.type.BsjActualType;
import edu.jhu.cs.bsj.compiler.lang.type.BsjType;
import edu.jhu.cs.bsj.compiler.lang.type.CastCompatibility;

public abstract class ActualTypeImpl extends TypeMirrorImpl implements BsjActualType
{

	public ActualTypeImpl(TypecheckerManager manager)
	{
		super(manager);
	}

	@Override
	public CastCompatibility isCastCompatible(BsjType type)
	{
		if (this.equals(type))
			return CastCompatibility.COMPATIBLE;
		
		if (this.isWideningPrimitiveConversionTo(type))
			return CastCompatibility.COMPATIBLE;
		
		if (this.isNarrowingPrimitiveConversionTo(type))
			return CastCompatibility.COMPATIBLE;
		
		if (this.isWideningAndNarrowingPrimitiveConversionTo(type))
			return CastCompatibility.COMPATIBLE;
		
		if (this.isWideningReferenceConversionTo(type))
			return CastCompatibility.COMPATIBLE;
		
		if (this.isWideningReferenceConversionTo(type.calculateErasure()))
			return CastCompatibility.COMPATIBLE_WITH_WARNING;
		
		if (this.isNarrowingReferenceConversionTo(type))
			return CastCompatibility.COMPATIBLE;
		
		if (this.isNarrowingReferenceConversionTo(type.calculateErasure()))
			return CastCompatibility.COMPATIBLE_WITH_WARNING;
		
		if (this.isSelectionConversionTo(type))
			return CastCompatibility.COMPATIBLE;
		
		if (this.equals(type.boxConvert()))
			return CastCompatibility.COMPATIBLE;
		
		if (this.equals(type.unboxConvert()))
			return CastCompatibility.COMPATIBLE;
		
		return CastCompatibility.INCOMPATIBLE;
	}
    
    @Override
    public BsjActualType evaluate()
    {
        return this;
    }

}