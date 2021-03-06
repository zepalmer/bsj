package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type;

import javax.lang.model.type.TypeKind;
import javax.lang.model.type.TypeVisitor;

import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.TypecheckerManager;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.TypecheckerModelComponentImpl;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.TypecheckerToolkit;
import edu.jhu.cs.bsj.compiler.lang.type.BsjPrimitiveType;
import edu.jhu.cs.bsj.compiler.lang.type.BsjType;
import edu.jhu.cs.bsj.compiler.lang.type.BsjTypeArgument;

public abstract class TypeMirrorImpl extends TypecheckerModelComponentImpl implements BsjType
{
	public TypeMirrorImpl(TypecheckerManager manager)
	{
		super(manager);
	}

	@Override
	public abstract <R, P> R accept(TypeVisitor<R, P> v, P p);

	@Override
	public abstract TypeKind getKind();

	@Override
	public abstract int hashCode();

	@Override
	public abstract boolean equals(Object obj);

	@Override
	public abstract String toString();

	@Override
	public boolean isSupertypeOf(BsjType type)
	{
		return type.isSubtypeOf(this);
	}

	@Override
	public BsjType captureConvert()
	{
		return this;
	}

	@Override
	public BsjType unboxConvert()
	{
		return this;
	}

	@Override
	public boolean isNumericPrimitive()
	{
		return false;
	}

	@Override
	public boolean isIntegralPrimitive()
	{
		return false;
	}

	@Override
	public BsjPrimitiveType numericTypePromotion()
	{
		BsjType unboxedType = this.unboxConvert();
		if (!unboxedType.isNumericPrimitive())
		{
			return null;
		}
		TypecheckerToolkit toolkit = getManager().getToolkit();
		if ((unboxedType.equals(toolkit.getByteType())) || (unboxedType.equals(toolkit.getCharType()))
				|| (unboxedType.equals(toolkit.getShortType())))
		{
			return toolkit.getIntType();
		} else
		{
			return (BsjPrimitiveType) unboxedType;
		}
	}
	
	@Override
	public boolean isAssignmentCompatibleWith(BsjType type)
	{
		if (this.equals(type))
			return true;
		
		if (this.isWideningPrimitiveConversionTo(type))
			return true;
		
		if (this.isWideningReferenceConversionTo(type))
			return true;
		
		BsjTypeArgument boxed = this.boxConvert();
		if (boxed != null && boxed.isWideningReferenceConversionTo(type))
			return true;
		
		if (this.unboxConvert().isWideningPrimitiveConversionTo(type))
			return true;
		
		if (this.isSelectionConversionTo(type))
			return true;
		
		// If a widening conversion would get us from the original type T to a raw type R, we can use an unchecked
		// conversion to be assignment compatible with a parameterized type C with a mandatory warning.  This warning
		// becomes an error if any two parameterized types encountered on the way are not in a subtype relation.
		// TODO
		
		// A narrowing primitive conversion may be used if the type is primitive and the expression is a constant
		// expression which is representable as the narrower primitive type.  For instance, it is legal to write
		// short x = 5; because 5 is representable in the type short.
		// TODO
		
		return false;
	}

	@Override
	public boolean isMethodInvocationCompatibleWith(BsjType type)
	{
		if (this.equals(type))
			return true;
		
		if (this.isWideningPrimitiveConversionTo(type))
			return true;
		
		if (this.isWideningReferenceConversionTo(type))
			return true;
		
		BsjTypeArgument boxed = this.boxConvert();
		if (boxed != null && boxed.isWideningReferenceConversionTo(type))
			return true;

		if (this.unboxConvert().equals(type) || this.unboxConvert().isWideningPrimitiveConversionTo(type))
			return true;
		
		if (this.isSelectionConversionTo(type))
			return true;
		
		// If a widening conversion would get us from the original type T to a raw type R, we can use an unchecked
		// conversion to be assignment compatible with a parameterized type C with a mandatory warning.  This warning
		// becomes an error if any two parameterized types encountered on the way are not in a subtype relation.
		// TODO
		
		// Note that this method is distinct from the isAssignmentCompatibleWith method because method conversion does
		// not allow primitive narrowing of constant expressions.
		
		return false;
	}
	
    @Override
    public BsjType evaluate()
    {
        return this;
    }	
}
