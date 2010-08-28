package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type;

import javax.lang.model.type.TypeKind;
import javax.lang.model.type.TypeVisitor;

import edu.jhu.cs.bsj.compiler.ast.node.NamedTypeDeclarationNode;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.TypecheckerManager;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.api.BsjType;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.api.BsjTypeVariable;

/**
 * Represents a type variable in the Java type space. A type variable is introduced either by a type parameter node or
 * by the capturing conversion (JLSv3 §5.1.10).
 * 
 * @param <T> An identifying attribute which can be used to tell two type variables apart.
 * @author Zachary Palmer
 */
public abstract class AbstractTypeVariableImpl<T> extends TypeMirrorImpl implements BsjTypeVariable
{
	/** The object representing the identity of this type variable. */
	private T id;
	/** The lower bound of this type variable, or <code>null</code> if there is no lower bound. */
	private BsjType lowerBound;
	/** The upper bound of this type variable, or <code>null</code> if there is no upper bound. */
	private BsjType upperBound;

	public AbstractTypeVariableImpl(TypecheckerManager manager, T id, BsjType lowerBound, BsjType upperBound)
	{
		super(manager);
		this.id = id;
		this.lowerBound = lowerBound;
		this.upperBound = upperBound;
	}

	@Override
	public BsjType getLowerBound()
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
	public BsjType getUpperBound()
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

	// TODO: this may not be an acceptable definition of equals - there is a notion of identity among type variables
	// just because A <: \alpha <: B and A <: \beta <: B doesn't mean that \alpha = \beta
	// There appear to be two general categories of type variables - those which appear as a result of an explicit type
	// variable or those which appear as the result of capture conversion. If the type variable is the result of an
	// explicit declaration, the identity of that type variable may be the TypeParameterNode which declares it.
	// Otherwise, the type variable must always be fresh and could be identified by a UID.
	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (getClass() != obj.getClass())
			return false;
		AbstractTypeVariableImpl<?> other = (AbstractTypeVariableImpl<?>) obj;
		return (this.id.equals(other.id));
	}

	@Override
	public BsjType calculateErasure()
	{
		return getUpperBound().calculateErasure();
	}
}
