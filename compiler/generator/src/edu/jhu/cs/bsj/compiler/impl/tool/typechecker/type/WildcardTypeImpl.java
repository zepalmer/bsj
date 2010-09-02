package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type;

import java.util.Map;

import javax.lang.model.type.TypeKind;
import javax.lang.model.type.TypeVisitor;

import edu.jhu.cs.bsj.compiler.ast.node.WildcardTypeNode;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.TypecheckerManager;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.api.BsjType;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.api.BsjTypeArgument;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.api.BsjTypeVariable;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.api.BsjWildcardType;
import edu.jhu.cs.bsj.compiler.impl.utils.NotImplementedYetException;

public class WildcardTypeImpl extends TypeArgumentImpl implements BsjWildcardType
{
	private BsjTypeArgument extendsBound;
	private BsjTypeArgument superBound;

	public WildcardTypeImpl(TypecheckerManager manager, WildcardTypeNode wildcardTypeNode)
	{
		super(manager);
		BsjTypeArgument boundType = wildcardTypeNode.getBound() != null ? getTypeBuilder().makeArgumentType(
				wildcardTypeNode.getBound()) : null;
		this.extendsBound = wildcardTypeNode.getUpperBound() ? boundType : null;
		this.superBound = wildcardTypeNode.getUpperBound() ? null : boundType;
	}

	public WildcardTypeImpl(TypecheckerManager manager, BsjTypeArgument extendsBound, BsjTypeArgument superBound)
	{
		super(manager);
		this.extendsBound = extendsBound;
		this.superBound = superBound;
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
		result = prime * result + ((extendsBound == null) ? 0 : extendsBound.hashCode());
		result = prime * result + ((superBound == null) ? 0 : superBound.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		WildcardTypeImpl other = (WildcardTypeImpl) obj;
		if (extendsBound == null)
		{
			if (other.extendsBound != null)
				return false;
		} else if (!extendsBound.equals(other.extendsBound))
			return false;
		if (superBound == null)
		{
			if (other.superBound != null)
				return false;
		} else if (!superBound.equals(other.superBound))
			return false;
		return true;
	}

	@Override
	public String toString()
	{
		if (this.extendsBound != null)
		{
			return "? extends " + this.extendsBound;
		} else if (this.superBound != null)
		{
			return "? super " + this.superBound;
		} else
		{
			return "?";
		}
	}

	@Override
	public BsjTypeArgument getExtendsBound()
	{
		return this.extendsBound;
	}

	@Override
	public BsjTypeArgument getSuperBound()
	{
		return this.superBound;
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

	@Override
	public BsjTypeArgument performTypeSubstitution(Map<BsjTypeVariable, BsjTypeArgument> substitutionMap)
	{
		BsjTypeArgument extendsBound = this.extendsBound == null ? null
				: this.extendsBound.performTypeSubstitution(substitutionMap);
		BsjTypeArgument superBound = this.superBound == null ? null
				: this.superBound.performTypeSubstitution(substitutionMap);
		return new WildcardTypeImpl(getManager(), extendsBound, superBound);
	}

	@Override
	public boolean isReifiable()
	{
		return false;
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
}
