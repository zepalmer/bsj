package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type;

import javax.lang.model.type.TypeKind;
import javax.lang.model.type.TypeVisitor;

import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.TypecheckerManager;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.TypecheckerModelComponentImpl;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.TypecheckerToolkit;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.api.BsjPrimitiveType;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.api.BsjType;

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
	public BsjType boxConvert()
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
}
