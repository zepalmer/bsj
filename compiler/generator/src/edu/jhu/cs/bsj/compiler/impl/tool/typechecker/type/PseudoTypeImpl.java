package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type;

import java.util.Map;

import javax.lang.model.type.TypeKind;
import javax.lang.model.type.TypeVisitor;

import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.TypecheckerManager;
import edu.jhu.cs.bsj.compiler.lang.type.BsjNoType;
import edu.jhu.cs.bsj.compiler.lang.type.BsjType;
import edu.jhu.cs.bsj.compiler.lang.type.BsjTypeArgument;
import edu.jhu.cs.bsj.compiler.lang.type.BsjTypeVariable;
import edu.jhu.cs.bsj.compiler.lang.type.CastCompatibility;

public abstract class PseudoTypeImpl extends TypeMirrorImpl implements BsjNoType
{
	private TypeKind kind;

	public PseudoTypeImpl(TypecheckerManager manager, TypeKind kind)
	{
		super(manager);
		this.kind = kind;
	}

	@Override
	public <R, P> R accept(TypeVisitor<R, P> v, P p)
	{
		return v.visitNoType(this, p);
	}

	@Override
	public TypeKind getKind()
	{
		return kind;
	}

	@Override
	public boolean isSubtypeOf(BsjType type)
	{
		return this.equals(type);
	}

	@Override
	public BsjType calculateErasure()
	{
		return this;
	}

	@Override
	public BsjType performTypeSubstitution(Map<BsjTypeVariable, BsjTypeArgument> substitutionMap)
	{
		return this;
	}

	@Override
	public boolean isReifiable()
	{
		return false;
	}

	@Override
	public CastCompatibility isCastCompatible(BsjType type)
	{
		return CastCompatibility.INCOMPATIBLE;
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
	public boolean isMethodInvocationCompatibleWith(BsjType type)
	{
		return false;
	}

	@Override
	public boolean isSelectionConversionTo(BsjType type)
	{
		return false;
	}
    
    @Override
    public BsjNoType evaluate()
    {
        return this;
    }	
}
