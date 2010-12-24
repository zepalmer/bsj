package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.lang.model.type.TypeKind;
import javax.lang.model.type.TypeVisitor;

import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.TypecheckerManager;
import edu.jhu.cs.bsj.compiler.impl.utils.NotImplementedYetException;
import edu.jhu.cs.bsj.compiler.impl.utils.StringUtilities;
import edu.jhu.cs.bsj.compiler.lang.element.BsjTypeParameterElement;
import edu.jhu.cs.bsj.compiler.lang.type.BsjDeclaredType;
import edu.jhu.cs.bsj.compiler.lang.type.BsjIntersectionType;
import edu.jhu.cs.bsj.compiler.lang.type.BsjLazyTypeContainer;
import edu.jhu.cs.bsj.compiler.lang.type.BsjReferenceType;
import edu.jhu.cs.bsj.compiler.lang.type.BsjType;
import edu.jhu.cs.bsj.compiler.lang.type.BsjTypeArgument;
import edu.jhu.cs.bsj.compiler.lang.type.BsjTypeVariable;

/**
 * This type object represents a Java intersection type. Java intersection types can never be explicitly declared; they
 * arise as a result of the capturing conversion and type inference. They can also be used to model a single type which
 * bounds a type parameter, although restrictions exist as to how those intersection bounds are described. Any type
 * which is a subtype of all of this intersection type's supertypes is considered to be a member of this intersection
 * type.
 * 
 * @author Zachary Palmer
 */
public class IntersectionTypeImpl extends ReferenceTypeImpl implements BsjIntersectionType
{
	/**
	 * The type arguments applied to the underlying type element to form this type.
	 */
	private List<? extends BsjTypeArgument> supertypes;

	public IntersectionTypeImpl(TypecheckerManager manager, List<? extends BsjTypeArgument> supertypes)
	{
		super(manager);
		this.supertypes = Collections.unmodifiableList(supertypes);
	}

	@Override
	public BsjDeclaredType getEnclosingType()
	{
		return null;
	}

	@Override
	public List<? extends BsjTypeArgument> getTypeArguments()
	{
		return Collections.emptyList();
	}

	@Override
	public BsjDeclaredType calculateErasure()
	{
		// TODO: what is the erasure of an intersection type? JLSv3 §4.6 doesn't specify.
		throw new NotImplementedYetException();
	}

	@Override
	public BsjTypeParameterElement asElement()
	{
		return null;
	}

	@Override
	public <R, P> R accept(TypeVisitor<R, P> v, P p)
	{
		return v.visitDeclared(this, p);
	}

	@Override
	public TypeKind getKind()
	{
		return TypeKind.DECLARED;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((supertypes == null) ? 0 : supertypes.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
        while (obj instanceof BsjLazyTypeContainer<?>)
            obj = ((BsjLazyTypeContainer<?>)obj).evaluate();
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		IntersectionTypeImpl other = (IntersectionTypeImpl) obj;
		if (supertypes == null)
		{
			if (other.supertypes != null)
				return false;
		} else if (!supertypes.equals(other.supertypes))
			return false;
		return true;
	}

	@Override
	public String toString()
	{
		return StringUtilities.join(this.supertypes, " & ");
	}

	@Override
	public List<? extends BsjTypeArgument> getSupertypes()
	{
		return this.supertypes;
	}

	@Override
	public boolean isSupertypeOf(BsjType type)
	{
		if (type instanceof BsjTypeVariable)
		{
			return type.isSubtypeOf(this);
		}

		if (this.equals(type))
			return true;

		for (BsjType supertype : this.supertypes)
		{
			if (!supertype.isSupertypeOf(type))
				return false;
		}

		return true;
	}

	@Override
	public boolean isSubtypeOf(BsjType type)
	{
		if (type instanceof BsjTypeVariable)
		{
			return type.isSupertypeOf(this);
		}

		if (this.equals(type))
			return true;

		for (BsjType supertype : this.supertypes)
		{
			if (supertype.isSubtypeOf(type))
				return true;
		}

		return false;
	}

	@Override
	public BsjTypeArgument performTypeSubstitution(Map<BsjTypeVariable, BsjTypeArgument> substitutionMap)
	{
		List<BsjTypeArgument> list = new ArrayList<BsjTypeArgument>();
		for (BsjTypeArgument arg : this.supertypes)
		{
			list.add(arg.performTypeSubstitution(substitutionMap));
		}
		return new IntersectionTypeImpl(getManager(), list);
	}

	@Override
	public boolean isReifiable()
	{
		return false;
	}

	@Override
	public boolean isNarrowingReferenceConversionTo(BsjType type)
	{
		if (this.equals(type))
			return false; // this is the identity conversion, not the narrowing reference conversion

		if (this.isSupertypeOf(type) && type instanceof BsjReferenceType)
			return true;

		return false;
	}
    
    @Override
    public BsjIntersectionType evaluate()
    {
        return this;
    }
}
