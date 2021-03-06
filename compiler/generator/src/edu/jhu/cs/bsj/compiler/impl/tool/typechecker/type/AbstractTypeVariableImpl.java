package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type;

import java.util.Collections;
import java.util.Set;

import javax.lang.model.type.TypeKind;
import javax.lang.model.type.TypeVisitor;

import edu.jhu.cs.bsj.compiler.ast.node.NamedTypeDeclarationNode;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.TypecheckerManager;
import edu.jhu.cs.bsj.compiler.lang.element.BsjDeclaredTypeElement;
import edu.jhu.cs.bsj.compiler.lang.type.BsjExplicitlyDeclaredType;
import edu.jhu.cs.bsj.compiler.lang.type.BsjLazyTypeContainer;
import edu.jhu.cs.bsj.compiler.lang.type.BsjReferenceType;
import edu.jhu.cs.bsj.compiler.lang.type.BsjType;
import edu.jhu.cs.bsj.compiler.lang.type.BsjTypeArgument;
import edu.jhu.cs.bsj.compiler.lang.type.BsjTypeVariable;
import edu.jhu.cs.bsj.compiler.lang.type.util.AbortableBsjTypeVisitor;

/**
 * Represents a type variable in the Java type space. A type variable is introduced either by a type parameter node or
 * by the capturing conversion (JLSv3 §5.1.10).
 * 
 * @param <T> An identifying attribute which can be used to tell two type variables apart.
 * @author Zachary Palmer
 */
public abstract class AbstractTypeVariableImpl<T> extends ReferenceTypeImpl implements BsjTypeVariable
{
	/** The object representing the identity of this type variable. */
	private T id;
	/** The lower bound of this type variable, or <code>null</code> if there is no lower bound. */
	private BsjTypeArgument lowerBound;
	/** The upper bound of this type variable, or <code>null</code> if there is no upper bound. */
	private BsjTypeArgument upperBound;

	public AbstractTypeVariableImpl(TypecheckerManager manager, T id, BsjTypeArgument lowerBound, BsjTypeArgument upperBound)
	{
		super(manager);
		this.id = id;
		this.lowerBound = lowerBound;
		this.upperBound = upperBound;
	}

	@Override
	public BsjTypeArgument getLowerBound()
	{
		if (this.lowerBound == null)
		{
			return new NullTypeImpl(getManager());
		} else
		{
			return this.lowerBound;
		}
	}

	@Override
	public BsjTypeArgument getUpperBound()
	{
		if (this.upperBound == null)
		{
			NamedTypeDeclarationNode<?> objectDeclaration = getManager().getToolkit().findTopLevelTypeDeclarationByName(
					"java", "lang", "Object");
			return makeElement(objectDeclaration).asType();
		} else
		{
			return this.upperBound;
		}
	}

	@Override
	public <R, P> R accept(TypeVisitor<R, P> v, P p)
	{
		return v.visitTypeVariable(this, p);
	}

	@Override
	public TypeKind getKind()
	{
		return TypeKind.TYPEVAR;
	}

	protected T getId()
	{
		return this.id;
	}

	@Override
	public int hashCode()
	{
		return this.id.hashCode();
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
		AbstractTypeVariableImpl<?> other = (AbstractTypeVariableImpl<?>) obj;
		return (this.id.equals(other.id));
	}

	@Override
	public BsjTypeArgument calculateErasure()
	{
		return getUpperBound().calculateErasure();
	}

	@Override
	public boolean isSubtypeOf(BsjType type)
	{
		if (this.equals(type))
			return true;
		
		if (getUpperBound().isSubtypeOf(type))
			return true;

		return false;
	}

	/**
	 * Overriding behavior of supertypes to behave correctly with respect to type variables.
	 */
	@Override
	public boolean isSupertypeOf(BsjType type)
	{
		return type.isSubtypeOf(this.lowerBound);
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
    public BsjTypeVariable evaluate()
    {
        return this;
    }
	
    @Override
    public <P, R, X extends Exception> R receive(AbortableBsjTypeVisitor<P, R, X> visitor, P param) throws X
    {
        return visitor.visitBsjTypeVariable(this, param);
    }

    @Override
    public Set<BsjTypeVariable> getInvolvedTypeVariables()
    {
        return Collections.<BsjTypeVariable>singleton(this);
    }

    @Override
    public BsjExplicitlyDeclaredType getSupertypeWithElement(BsjDeclaredTypeElement element)
    {
        return getUpperBound().getSupertypeWithElement(element); 
    }
}
