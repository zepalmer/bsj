package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type;

import java.util.List;
import java.util.Map;

import javax.lang.model.type.TypeKind;
import javax.lang.model.type.TypeVisitor;

import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.TypecheckerManager;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.element.api.BsjTypeElement;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.api.BsjDeclaredType;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.api.BsjErrorType;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.api.BsjPrimitiveType;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.api.BsjType;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.api.BsjTypeArgument;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.api.BsjTypeVariable;

public class ErrorTypeImpl extends TypeMirrorImpl implements BsjErrorType
{
	public ErrorTypeImpl(TypecheckerManager manager)
	{
		super(manager);
	}
	
	@Override
	public BsjTypeElement asElement()
	{
		throw new IllegalStateException("Accessed error type");
	}

	@Override
	public BsjDeclaredType getEnclosingType()
	{
		throw new IllegalStateException("Accessed error type");
	}

	@Override
	public List<? extends BsjTypeArgument> getTypeArguments()
	{
		throw new IllegalStateException("Accessed error type");
	}

	@Override
	public <R, P> R accept(TypeVisitor<R, P> v, P p)
	{
		return v.visitError(this, p);
	}

	@Override
	public boolean equals(Object obj)
	{
		throw new IllegalStateException("Accessed error type");
	}

	@Override
	public TypeKind getKind()
	{
		return TypeKind.ERROR;
	}

	@Override
	public int hashCode()
	{
		return 2358129;
	}

	@Override
	public String toString()
	{
		return "<error>";
	}

	@Override
	public BsjDeclaredType calculateErasure()
	{
		throw new IllegalStateException("Accessed error type");
	}

	@Override
	public boolean isSubtypeOf(BsjType type)
	{
		throw new IllegalStateException("Accessed error type");
	}

	@Override
	public boolean isSupertypeOf(BsjType type)
	{
		throw new IllegalStateException("Accessed error type");
	}

	@Override
	public BsjType captureConvert()
	{
		throw new IllegalStateException("Accessed error type");
	}

	@Override
	public BsjType unboxConvert()
	{
		throw new IllegalStateException("Accessed error type");
	}

	@Override
	public boolean isNumericPrimitive()
	{
		throw new IllegalStateException("Accessed error type");
	}

	@Override
	public boolean isIntegralPrimitive()
	{
		throw new IllegalStateException("Accessed error type");
	}

	@Override
	public BsjPrimitiveType numericTypePromotion()
	{
		throw new IllegalStateException("Accessed error type");
	}

	@Override
	public boolean isAssignmentCompatibleWith(BsjType type)
	{
		throw new IllegalStateException("Accessed error type");
	}

	@Override
	public boolean contains(BsjTypeArgument argument)
	{
		throw new IllegalStateException("Accessed error type");
	}

	@Override
	public BsjTypeArgument boxConvert()
	{
		throw new IllegalStateException("Accessed error type");
	}

	@Override
	public BsjTypeArgument performTypeSubstitution(Map<BsjTypeVariable, BsjTypeArgument> substitutionMap)
	{
		throw new IllegalStateException("Accessed error type");
	}
}
