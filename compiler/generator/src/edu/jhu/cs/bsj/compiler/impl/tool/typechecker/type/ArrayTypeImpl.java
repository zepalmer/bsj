package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type;

import java.util.Map;
import java.util.Set;

import javax.lang.model.type.TypeKind;
import javax.lang.model.type.TypeVisitor;

import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.TypecheckerManager;
import edu.jhu.cs.bsj.compiler.lang.element.BsjDeclaredTypeElement;
import edu.jhu.cs.bsj.compiler.lang.type.BsjArrayType;
import edu.jhu.cs.bsj.compiler.lang.type.BsjExplicitlyDeclaredType;
import edu.jhu.cs.bsj.compiler.lang.type.BsjIntersectionType;
import edu.jhu.cs.bsj.compiler.lang.type.BsjLazyTypeContainer;
import edu.jhu.cs.bsj.compiler.lang.type.BsjReferenceType;
import edu.jhu.cs.bsj.compiler.lang.type.BsjType;
import edu.jhu.cs.bsj.compiler.lang.type.BsjTypeArgument;
import edu.jhu.cs.bsj.compiler.lang.type.BsjTypeVariable;
import edu.jhu.cs.bsj.compiler.lang.type.util.AbortableBsjTypeVisitor;

public class ArrayTypeImpl extends ReferenceTypeImpl implements BsjArrayType
{
	private BsjType componentType;

	public ArrayTypeImpl(TypecheckerManager manager, BsjType componentType)
	{
		super(manager);
		this.componentType = componentType;
	}

	@Override
	public <R, P> R accept(TypeVisitor<R, P> v, P p)
	{
		return v.visitArray(this, p);
	}

	@Override
	public TypeKind getKind()
	{
		return TypeKind.ARRAY;
	}

	@Override
	public String toString()
	{
		return this.componentType.toString() + "[]";
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((componentType == null) ? 0 : componentType.hashCode());
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
		ArrayTypeImpl other = (ArrayTypeImpl) obj;
		if (componentType == null)
		{
			if (other.componentType != null)
				return false;
		} else if (!componentType.equals(other.componentType))
			return false;
		return true;
	}

	@Override
	public BsjType getComponentType()
	{
		return this.componentType;
	}

	@Override
	public BsjArrayType calculateErasure()
	{
		return new ArrayTypeImpl(getManager(), getComponentType().calculateErasure());
	}

	@Override
	public boolean isSubtypeOf(BsjType type)
	{
		if (type instanceof BsjTypeVariable || type instanceof BsjIntersectionType)
		{
			return type.isSupertypeOf(this);
		} else if (type instanceof BsjArrayType)
		{
			return this.getComponentType().isSubtypeOf(((BsjArrayType) type).getComponentType());
		} else if (type.equals(this.getManager().getToolkit().getObjectElement().asType()))
		{
			return true;
		} else if (type.equals(this.getManager().getToolkit().getCloneableElement().asType()))
		{
			return true;
		} else if (type.equals(this.getManager().getToolkit().getSerializableElement()))
		{
			return true;
		} else
		{
			return false;
		}
	}

	@Override
	public BsjTypeArgument performTypeSubstitution(Map<BsjTypeVariable, BsjTypeArgument> substitutionMap)
	{
		return new ArrayTypeImpl(getManager(), this.componentType.performTypeSubstitution(substitutionMap));
	}

	@Override
	public boolean isReifiable()
	{
		return this.componentType.isReifiable();
	}

	@Override
	public boolean isNarrowingReferenceConversionTo(BsjType type)
	{
		if (this.equals(type))
			return false; // this would be an identity conversion, not a narrowing reference conversion

		if (this.isSupertypeOf(type) && type instanceof BsjReferenceType)
			return true;

		if (type instanceof BsjArrayType)
		{
			BsjArrayType arrayType = (BsjArrayType) type;
			if (this.getComponentType() instanceof BsjReferenceType
					&& arrayType.getComponentType() instanceof BsjReferenceType
					&& this.getComponentType().isNarrowingReferenceConversionTo(arrayType.getComponentType()))
				return true;
		}
		
		return false;
	}
    
    @Override
    public BsjArrayType evaluate()
    {
        return this;
    }

    @Override
    public <P, R, X extends Exception> R receive(AbortableBsjTypeVisitor<P, R, X> visitor, P param) throws X
    {
        return visitor.visitBsjArrayType(this, param);
    }

    @Override
    public Set<BsjTypeVariable> getInvolvedTypeVariables()
    {
        return this.getComponentType().getInvolvedTypeVariables();
    }

    @Override
    public BsjExplicitlyDeclaredType getSupertypeWithElement(BsjDeclaredTypeElement element)
    {
        for (BsjDeclaredTypeElement candidate : new BsjDeclaredTypeElement[]{
                this.getManager().getToolkit().getCloneableElement(),
                this.getManager().getToolkit().getSerializableElement(),
                this.getManager().getToolkit().getObjectElement()
        })
        {
            if (element.equals(candidate))
            {
                return candidate.asType();
            }
        }
        return null;
    }
}
