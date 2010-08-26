package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type;

import javax.lang.model.type.TypeKind;
import javax.lang.model.type.TypeVisitor;

import edu.jhu.cs.bsj.compiler.ast.node.NamedTypeDeclarationNode;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.TypecheckerManager;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.element.api.BsjTypeParameterElement;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.api.BsjType;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.api.BsjTypeVariable;

public class TypeVariableImpl extends TypeMirrorImpl implements BsjTypeVariable
{
	private BsjType lowerBound;
	private BsjType upperBound;

	public TypeVariableImpl(TypecheckerManager manager, BsjType lowerBound, BsjType upperBound)
	{
		super(manager);
		this.lowerBound = lowerBound;
		this.upperBound = upperBound;
	}

	// TODO: is this return type correct? aren't wildcards also type variables?
	@Override
	public BsjTypeParameterElement asElement()
	{
		// TODO: possibly have to split into subclasses to remember the source of the type variable?
		// TODO Auto-generated method stub
		return null;
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

	@Override
	public String toString()
	{
		return getLowerBound() + " <: ? <: " + getUpperBound();
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((lowerBound == null) ? 0 : lowerBound.hashCode());
		result = prime * result + ((upperBound == null) ? 0 : upperBound.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (getClass() != obj.getClass())
			return false;
		TypeVariableImpl other = (TypeVariableImpl) obj;
		if (lowerBound == null)
		{
			if (other.lowerBound != null)
				return false;
		} else if (!lowerBound.equals(other.lowerBound))
			return false;
		if (upperBound == null)
		{
			if (other.upperBound != null)
				return false;
		} else if (!upperBound.equals(other.upperBound))
			return false;
		return true;
	}

	@Override
	public BsjType calculateErasure()
	{
		return getUpperBound().calculateErasure();
	}
}
