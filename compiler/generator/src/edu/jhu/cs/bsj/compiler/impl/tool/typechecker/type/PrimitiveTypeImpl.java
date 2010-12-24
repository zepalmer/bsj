package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type;

import java.util.Map;

import javax.lang.model.type.TypeKind;
import javax.lang.model.type.TypeVisitor;

import edu.jhu.cs.bsj.compiler.ast.PrimitiveType;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.TypecheckerManager;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.TypecheckerToolkit;
import edu.jhu.cs.bsj.compiler.lang.type.BsjLazyTypeContainer;
import edu.jhu.cs.bsj.compiler.lang.type.BsjPrimitiveType;
import edu.jhu.cs.bsj.compiler.lang.type.BsjReferenceType;
import edu.jhu.cs.bsj.compiler.lang.type.BsjType;
import edu.jhu.cs.bsj.compiler.lang.type.BsjTypeArgument;
import edu.jhu.cs.bsj.compiler.lang.type.BsjTypeVariable;

/**
 * Represents a primitive type in the BSJ type checker.
 * 
 * @author Zachary Palmer
 */
public class PrimitiveTypeImpl extends ActualTypeImpl implements BsjPrimitiveType
{
	private PrimitiveType primitiveType;

	public PrimitiveTypeImpl(TypecheckerManager manager, PrimitiveType primitiveType)
	{
		super(manager);
		this.primitiveType = primitiveType;
	}

	@Override
	public <R, P> R accept(TypeVisitor<R, P> v, P p)
	{
		return v.visitPrimitive(this, p);
	}

	@Override
	public TypeKind getKind()
	{
		switch (this.primitiveType)
		{
			case BOOLEAN:
				return TypeKind.BOOLEAN;
			case BYTE:
				return TypeKind.BYTE;
			case CHAR:
				return TypeKind.CHAR;
			case DOUBLE:
				return TypeKind.DOUBLE;
			case FLOAT:
				return TypeKind.FLOAT;
			case INT:
				return TypeKind.INT;
			case LONG:
				return TypeKind.LONG;
			case SHORT:
				return TypeKind.SHORT;
		}
		throw new IllegalStateException("Unknown mapping from PrimitiveType " + this.primitiveType + " to TypeKind");
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((primitiveType == null) ? 0 : primitiveType.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
        while (obj instanceof BsjLazyTypeContainer<?>)
            obj = ((BsjLazyTypeContainer<?>)obj).evaluate();
		if (this == obj)
			return true;
		if (getClass() != obj.getClass())
			return false;
		PrimitiveTypeImpl other = (PrimitiveTypeImpl) obj;
		if (primitiveType == null)
		{
			if (other.primitiveType != null)
				return false;
		} else if (!primitiveType.equals(other.primitiveType))
			return false;
		return true;
	}

	@Override
	public String toString()
	{
		return this.primitiveType.toString().toLowerCase();
	}

	@Override
	public BsjType calculateErasure()
	{
		return this;
	}

	public PrimitiveType getPrimitiveType()
	{
		return primitiveType;
	}

	@Override
	public boolean isSubtypeOf(BsjType type)
	{
		if (type instanceof BsjPrimitiveType)
		{
			return this.primitiveType.isSubtypeOf(((BsjPrimitiveType) type).getPrimitiveType());
		} else
		{
			return false;
		}
	}

	@Override
	public BsjReferenceType boxConvert()
	{
		TypecheckerToolkit toolkit = getManager().getToolkit();
		if (this.equals(toolkit.getByteType()))
			return toolkit.getByteWrapperType();
		if (this.equals(toolkit.getCharType()))
			return toolkit.getCharacterWrapperType();
		if (this.equals(toolkit.getIntType()))
			return toolkit.getIntegerWrapperType();
		if (this.equals(toolkit.getLongType()))
			return toolkit.getLongWrapperType();
		if (this.equals(toolkit.getShortType()))
			return toolkit.getShortWrapperType();
		if (this.equals(toolkit.getDoubleType()))
			return toolkit.getDoubleWrapperType();
		if (this.equals(toolkit.getFloatType()))
			return toolkit.getFloatWrapperType();
		if (this.equals(toolkit.getBooleanType()))
			return toolkit.getBooleanWrapperType();
		throw new IllegalArgumentException("Unrecognized primitive type while boxing: " + this.primitiveType);
	}

	@Override
	public boolean isNumericPrimitive()
	{
		TypecheckerToolkit toolkit = getManager().getToolkit();
		return this.isIntegralPrimitive() || (this.equals(toolkit.getDoubleType()))
				|| (this.equals(toolkit.getFloatType()));
	}

	@Override
	public boolean isIntegralPrimitive()
	{
		TypecheckerToolkit toolkit = getManager().getToolkit();
		return (this.equals(toolkit.getByteType())) || (this.equals(toolkit.getCharType()))
				|| (this.equals(toolkit.getIntType())) || (this.equals(toolkit.getLongType()))
				|| (this.equals(toolkit.getShortType())) || (this.equals(toolkit.getDoubleType()))
				|| (this.equals(toolkit.getFloatType()));
	}

	@Override
	public BsjType performTypeSubstitution(Map<BsjTypeVariable, BsjTypeArgument> substitutionMap)
	{
		return this;
	}

	@Override
	public boolean isReifiable()
	{
		return true;
	}

	@Override
	public boolean isNarrowingPrimitiveConversionTo(BsjType type)
	{
		if (type instanceof BsjPrimitiveType)
		{
			BsjPrimitiveType primitiveType = (BsjPrimitiveType) type;
			switch (this.primitiveType)
			{
				case SHORT:
					return primitiveType.getPrimitiveType() == PrimitiveType.BYTE
							|| primitiveType.getPrimitiveType() == PrimitiveType.CHAR;
				case CHAR:
					return primitiveType.getPrimitiveType() == PrimitiveType.BYTE
							|| primitiveType.getPrimitiveType() == PrimitiveType.SHORT;
				case INT:
					return primitiveType.getPrimitiveType() == PrimitiveType.BYTE
							|| primitiveType.getPrimitiveType() == PrimitiveType.SHORT
							|| primitiveType.getPrimitiveType() == PrimitiveType.CHAR;
				case LONG:
					return primitiveType.getPrimitiveType() == PrimitiveType.BYTE
							|| primitiveType.getPrimitiveType() == PrimitiveType.SHORT
							|| primitiveType.getPrimitiveType() == PrimitiveType.CHAR
							|| primitiveType.getPrimitiveType() == PrimitiveType.INT;
				case FLOAT:
					return primitiveType.getPrimitiveType() == PrimitiveType.BYTE
							|| primitiveType.getPrimitiveType() == PrimitiveType.SHORT
							|| primitiveType.getPrimitiveType() == PrimitiveType.CHAR
							|| primitiveType.getPrimitiveType() == PrimitiveType.INT
							|| primitiveType.getPrimitiveType() == PrimitiveType.LONG;
				case DOUBLE:
					return primitiveType.getPrimitiveType() == PrimitiveType.BYTE
							|| primitiveType.getPrimitiveType() == PrimitiveType.SHORT
							|| primitiveType.getPrimitiveType() == PrimitiveType.CHAR
							|| primitiveType.getPrimitiveType() == PrimitiveType.INT
							|| primitiveType.getPrimitiveType() == PrimitiveType.LONG
							|| primitiveType.getPrimitiveType() == PrimitiveType.FLOAT;
			}
		}
		return false;
	}

	@Override
	public boolean isWideningPrimitiveConversionTo(BsjType type)
	{
		if (type instanceof BsjPrimitiveType)
		{
			BsjPrimitiveType primitiveType = (BsjPrimitiveType) type;
			switch (this.primitiveType)
			{
				case BYTE:
					return primitiveType.getPrimitiveType() == PrimitiveType.SHORT
							|| primitiveType.getPrimitiveType() == PrimitiveType.INT
							|| primitiveType.getPrimitiveType() == PrimitiveType.LONG
							|| primitiveType.getPrimitiveType() == PrimitiveType.FLOAT
							|| primitiveType.getPrimitiveType() == PrimitiveType.DOUBLE;
				case SHORT:
					return primitiveType.getPrimitiveType() == PrimitiveType.INT
							|| primitiveType.getPrimitiveType() == PrimitiveType.LONG
							|| primitiveType.getPrimitiveType() == PrimitiveType.FLOAT
							|| primitiveType.getPrimitiveType() == PrimitiveType.DOUBLE;
				case CHAR:
					return primitiveType.getPrimitiveType() == PrimitiveType.INT
							|| primitiveType.getPrimitiveType() == PrimitiveType.LONG
							|| primitiveType.getPrimitiveType() == PrimitiveType.FLOAT
							|| primitiveType.getPrimitiveType() == PrimitiveType.DOUBLE;
				case INT:
					return primitiveType.getPrimitiveType() == PrimitiveType.LONG
							|| primitiveType.getPrimitiveType() == PrimitiveType.FLOAT
							|| primitiveType.getPrimitiveType() == PrimitiveType.DOUBLE;
				case LONG:
					return primitiveType.getPrimitiveType() == PrimitiveType.FLOAT
							|| primitiveType.getPrimitiveType() == PrimitiveType.DOUBLE;
				case FLOAT:
					return primitiveType.getPrimitiveType() == PrimitiveType.DOUBLE;
			}
		}
		return false;
	}

	@Override
	public boolean isWideningAndNarrowingPrimitiveConversionTo(BsjType type)
	{
		if (type instanceof BsjPrimitiveType)
		{
			BsjPrimitiveType primitiveType = (BsjPrimitiveType) type;
			switch (this.primitiveType)
			{
				case BYTE:
					return primitiveType.getPrimitiveType() == PrimitiveType.CHAR;
			}
		}
		return false;
	}

	@Override
	public boolean isNarrowingReferenceConversionTo(BsjType type)
	{
		return false;
	}

	@Override
	public boolean isWideningReferenceConversionTo(BsjType type)
	{
		return false;
	}

	@Override
	public boolean isSelectionConversionTo(BsjType type)
	{
		return false;
	}
	
    @Override
    public BsjPrimitiveType evaluate()
    {
        return this;
    }
}
