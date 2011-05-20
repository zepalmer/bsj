package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type;

import java.util.Collections;
import java.util.Map;
import java.util.Set;

import javax.lang.model.type.TypeKind;
import javax.lang.model.type.TypeVisitor;

import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.TypecheckerManager;
import edu.jhu.cs.bsj.compiler.lang.element.BsjDeclaredTypeElement;
import edu.jhu.cs.bsj.compiler.lang.type.BsjExplicitlyDeclaredType;
import edu.jhu.cs.bsj.compiler.lang.type.BsjLazyTypeContainer;
import edu.jhu.cs.bsj.compiler.lang.type.BsjNullType;
import edu.jhu.cs.bsj.compiler.lang.type.BsjReferenceType;
import edu.jhu.cs.bsj.compiler.lang.type.BsjType;
import edu.jhu.cs.bsj.compiler.lang.type.BsjTypeArgument;
import edu.jhu.cs.bsj.compiler.lang.type.BsjTypeVariable;
import edu.jhu.cs.bsj.compiler.lang.type.util.AbortableBsjTypeVisitor;

public class NullTypeImpl extends ReferenceTypeImpl implements BsjNullType
{
	public NullTypeImpl(TypecheckerManager manager)
	{
		super(manager);
	}

	@Override
	public <R, P> R accept(TypeVisitor<R, P> v, P p)
	{
		return v.visitNull(this, p);
	}

	@Override
	public TypeKind getKind()
	{
		return TypeKind.NULL;
	}

	@Override
	public String toString()
	{
		return "null";
	}

	@Override
	public boolean equals(Object obj)
	{
        while (obj instanceof BsjLazyTypeContainer<?>)
            obj = ((BsjLazyTypeContainer<?>)obj).evaluate();
		return obj instanceof BsjNullType;
	}

	@Override
	public int hashCode()
	{
		return 1665993391;
	}

	@Override
	public BsjNullType calculateErasure()
	{
		return this;
	}

	@Override
	public boolean isSubtypeOf(BsjType type)
	{
		return (type instanceof BsjReferenceType);
	}

	@Override
	public BsjTypeArgument performTypeSubstitution(Map<BsjTypeVariable, BsjTypeArgument> substitutionMap)
	{
		return this;
	}

	@Override
	public boolean isReifiable()
	{
		return false;
	}

	@Override
	public boolean isNarrowingReferenceConversionTo(BsjType type)
	{
		if (this.isSupertypeOf(type) && type instanceof BsjReferenceType)
			return true;

		return false;
	}
	
    
    @Override
    public BsjNullType evaluate()
    {
        return this;
    }

    @Override
    public <P, R, X extends Exception> R receive(AbortableBsjTypeVisitor<P, R, X> visitor, P param) throws X
    {
        return visitor.visitBsjNullType(this, param);
    }

    @Override
    public Set<BsjTypeVariable> getInvolvedTypeVariables()
    {
        return Collections.emptySet();
    }

    @Override
    public BsjExplicitlyDeclaredType getSupertypeWithElement(BsjDeclaredTypeElement element)
    {
        // This should never be requested because of the case that A is not null in the type inference engine when
        // it is used.  This interface cannot be met because null has infinitely many supertypes of any parameterized
        // element.  (Possible refactoring necessary if this method is ever used anywhere else.)
        throw new IllegalStateException("Cannot return infinitely many supertypes for null");
    }
}
