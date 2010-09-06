package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.thunk;

import java.util.Map;

import javax.lang.model.type.TypeKind;
import javax.lang.model.type.TypeVisitor;

import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.api.BsjPrimitiveType;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.api.BsjType;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.api.BsjTypeArgument;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.api.BsjTypeVariable;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.api.CastCompatibility;
import edu.jhu.cs.bsj.compiler.impl.utils.function.Function;

/**
 * A lazily-managed type implementation. This class accepts a function which will produce a {@link BsjTypeArgument}. It
 * then proxies all calls to the type argument, only populating the object after the first call is made.
 * 
 * @author Zachary Palmer
 */
public class BsjTypeArgumentThunk implements BsjTypeArgument
{
	private Function<Void, BsjTypeArgument> thinkFunction;
	private BsjTypeArgument thunkValue;

	public BsjTypeArgumentThunk(Function<Void, BsjTypeArgument> thinkFunction)
	{
		super();
		this.thinkFunction = thinkFunction;
	}

	private BsjTypeArgument think()
	{
		if (thunkValue == null)
		{
			thunkValue = thinkFunction.execute(null);
		}
		return thunkValue;
	}

	@Override
	public BsjType calculateErasure()
	{
		return think().calculateErasure();

	}

	@Override
	public boolean isSubtypeOf(BsjType type)
	{
		return think().isSubtypeOf(type);
	}

	@Override
	public boolean isSupertypeOf(BsjType type)
	{
		return think().isSupertypeOf(type);
	}

	@Override
	public BsjTypeArgument boxConvert()
	{
		return think().boxConvert();
	}

	@Override
	public BsjType unboxConvert()
	{
		return think().unboxConvert();
	}

	@Override
	public BsjType captureConvert()
	{
		return think().captureConvert();
	}

	@Override
	public boolean isNumericPrimitive()
	{
		return think().isNumericPrimitive();
	}

	@Override
	public boolean isIntegralPrimitive()
	{
		return think().isIntegralPrimitive();
	}

	@Override
	public BsjPrimitiveType numericTypePromotion()
	{
		return think().numericTypePromotion();
	}

	@Override
	public boolean isAssignmentCompatibleWith(BsjType type)
	{
		return think().isAssignmentCompatibleWith(type);
	}

	@Override
	public boolean isMethodInvocationCompatibleWith(BsjType type)
	{
		return think().isMethodInvocationCompatibleWith(type);
	}

	@Override
	public boolean isReifiable()
	{
		return think().isReifiable();
	}

	@Override
	public CastCompatibility isCastCompatible(BsjType type)
	{
		return think().isCastCompatible(type);
	}

	@Override
	public boolean isNarrowingPrimitiveConversionTo(BsjType type)
	{
		return think().isNarrowingPrimitiveConversionTo(type);
	}

	@Override
	public boolean isWideningPrimitiveConversionTo(BsjType type)
	{
		return think().isWideningPrimitiveConversionTo(type);
	}

	@Override
	public boolean isWideningAndNarrowingPrimitiveConversionTo(BsjType type)
	{
		return think().isWideningAndNarrowingPrimitiveConversionTo(type);
	}

	@Override
	public boolean isNarrowingReferenceConversionTo(BsjType type)
	{
		return think().isNarrowingReferenceConversionTo(type);
	}

	@Override
	public boolean isWideningReferenceConversionTo(BsjType type)
	{
		return think().isWideningReferenceConversionTo(type);
	}

	@Override
	public TypeKind getKind()
	{
		return think().getKind();
	}

	@Override
	public <R, P> R accept(TypeVisitor<R, P> v, P p)
	{
		return think().accept(v,p);
	}

	@Override
	public boolean contains(BsjTypeArgument argument)
	{
		return think().contains(argument);
	}

	@Override
	public BsjTypeArgument performTypeSubstitution(Map<BsjTypeVariable, BsjTypeArgument> substitutionMap)
	{
		return think().performTypeSubstitution(substitutionMap);
	}
}
