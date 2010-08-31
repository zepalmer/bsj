package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type;

import javax.lang.model.type.TypeKind;
import javax.lang.model.type.TypeVisitor;

import edu.jhu.cs.bsj.compiler.ast.node.WildcardTypeNode;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.TypecheckerManager;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.api.BsjType;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.api.BsjTypeArgument;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.api.BsjWildcardType;
import edu.jhu.cs.bsj.compiler.impl.utils.NotImplementedYetException;

public class WildcardTypeImpl extends TypeArgumentImpl implements BsjWildcardType
{
	private WildcardTypeNode wildcardTypeNode;

	public WildcardTypeImpl(TypecheckerManager manager, WildcardTypeNode wildcardTypeNode)
	{
		super(manager);
		this.wildcardTypeNode = wildcardTypeNode;
	}

	@Override
	public <R, P> R accept(TypeVisitor<R, P> v, P p)
	{
		return v.visitWildcard(this, p);
	}

	@Override
	public TypeKind getKind()
	{
		return TypeKind.WILDCARD;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((wildcardTypeNode == null) ? 0 : wildcardTypeNode.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (getClass() != obj.getClass())
			return false;
		WildcardTypeImpl other = (WildcardTypeImpl) obj;
		if (this.wildcardTypeNode.getUid() != other.wildcardTypeNode.getUid())
			return false;

		return true;
	}

	@Override
	public String toString()
	{
		return this.wildcardTypeNode.toSourceCode();
	}

	@Override
	public BsjTypeArgument getExtendsBound()
	{
		if (this.wildcardTypeNode.getUpperBound())
		{
			return getTypeBuilder().makeArgumentType(this.wildcardTypeNode.getBound());
		} else
		{
			return null;
		}
	}

	@Override
	public BsjTypeArgument getSuperBound()
	{
		if (this.wildcardTypeNode.getUpperBound())
		{
			return null;
		} else
		{
			return getTypeBuilder().makeArgumentType(this.wildcardTypeNode.getBound());
		}
	}

	@Override
	public BsjType calculateErasure()
	{
		return this;
	}

	@Override
	public boolean isSubtypeOf(BsjType type)
	{
		// Strictly speaking, there is no definition of subtyping amongst wildcard types themselves as they appear
		// in the JLS.
		return false;
	}

	@Override
	public boolean contains(BsjTypeArgument argument)
	{
		if (argument instanceof BsjWildcardType)
		{
			BsjWildcardType other = (BsjWildcardType) argument;
			if (this.getExtendsBound() != null)
			{
				if (other.getExtendsBound() != null)
				{
					return other.getExtendsBound().isSubtypeOf(this.getExtendsBound());
				} else
				{
					return false;
				}
			} else if (this.getSuperBound() != null)
			{
				if (other.getSuperBound() != null)
				{
					return this.getSuperBound().isSubtypeOf(other.getSuperBound());
				} else
				{
					return false;
				}
			} else
			{
				// TODO: It seems that the JLSv3 §4.5.1.1 is unclear on this point. What do we do?
				// Is it the case that (? extends T <= ?) or can we not assume that?
				throw new NotImplementedYetException();
			}
		} else
		{
			if (this.getExtendsBound() != null)
			{
				return this.getExtendsBound().isSupertypeOf(argument);
			} else if (this.getSuperBound() != null)
			{
				return this.getSuperBound().isSubtypeOf(argument);
			} else
			{
				// TODO: It seems that the JLSv3 §4.5.1.1 is unclear on this point. What do we do?
				// Is it the case that (T <= ?) or can we not assume that?
				throw new NotImplementedYetException();
			}
		}
	}
}
