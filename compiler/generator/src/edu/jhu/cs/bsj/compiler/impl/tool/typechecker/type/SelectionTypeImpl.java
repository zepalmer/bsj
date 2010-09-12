package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type;

import java.util.Map;

import javax.lang.model.type.TypeKind;
import javax.lang.model.type.TypeVisitor;

import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.TypecheckerManager;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.api.BsjActualType;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.api.BsjSelectionType;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.api.BsjType;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.api.BsjTypeArgument;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.api.BsjTypeVariable;
import edu.jhu.cs.bsj.compiler.impl.utils.Bag;
import edu.jhu.cs.bsj.compiler.impl.utils.StringUtilities;
import edu.jhu.cs.bsj.compiler.impl.utils.UnmodifiableBag;

/**
 * Implements a selection type for the BSJ typechecker.
 * 
 * @author Zachary Palmer
 */
public class SelectionTypeImpl extends ActualTypeImpl implements BsjSelectionType
{
	// TODO: create a specialized selection type class for the lazy evaluation of code literals

	private Bag<? extends BsjActualType> componentTypes;

	public <T extends BsjActualType> SelectionTypeImpl(TypecheckerManager manager, Bag<T> componentTypes)
	{
		super(manager);
		this.componentTypes = new UnmodifiableBag<T>(componentTypes);
	}

	@Override
	public BsjType calculateErasure()
	{
		return this;
	}

	@Override
	public boolean isSubtypeOf(BsjType type)
	{
		return this.equals(type);
	}

	@Override
	public BsjTypeArgument boxConvert()
	{
		return null;
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
	public <R, P> R accept(TypeVisitor<R, P> v, P p)
	{
		return v.visit(this, p);
	}

	@Override
	public TypeKind getKind()
	{
		return TypeKind.OTHER;
	}

	@Override
	public int hashCode()
	{
		return this.componentTypes.hashCode();
	}

	@Override
	public boolean isSelectionConversionTo(BsjType type)
	{
		int count = 0;
		for (BsjActualType componentType : getComponentTypes())
		{
			if (componentType.isSubtypeOf(type))
			{
				count++;
			}
			if (count > 1)
			{
				break;
			}
		}
		return count == 1;
	}

	@Override
	public Bag<? extends BsjActualType> getComponentTypes()
	{
		return this.componentTypes;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (obj == this)
		{
			return true;
		}
		if (obj instanceof BsjSelectionType)
		{
			BsjSelectionType other = (BsjSelectionType) obj;
			return this.componentTypes.equals(other.getComponentTypes());
		} else
		{
			return false;
		}
	}

	@Override
	public String toString()
	{
		return "{" + StringUtilities.join(componentTypes, ",") + "}";
	}
}
