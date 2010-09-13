package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.value;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.TypecheckerManager;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.SelectionTypeImpl;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.api.BsjActualType;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.api.BsjSelectionType;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.api.BsjType;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.value.api.SelectionBag;
import edu.jhu.cs.bsj.compiler.impl.utils.Bag;
import edu.jhu.cs.bsj.compiler.impl.utils.HashBag;

/**
 * Implements a selection bag in the BSJ API.
 * @author Zachary Palmer
 */
public class SelectionBagImpl<T> implements SelectionBag<T>
{
	/** The typechecking manager to use to build types for comparison. */
	private TypecheckerManager manager;
	/** The backing data structure. */
	private Bag<T> data;
	
	/**
	 * Creates a new selection bag using the specified values.
	 * @param manager The typechecking manager to use to build types for comparison.
	 * @param data The data to use.
	 */
	public SelectionBagImpl(TypecheckerManager manager, Bag<? extends T> data)
	{
		this.data = new HashBag<T>(data);
		this.manager = manager;
	}

	@Override
	public T select(BsjType type)
	{
		Collection<? extends T> result = selectAll(type);
		if (result.size() == 1)
		{
			return result.iterator().next();
		} else
		{
			return null;
		}
	}

	@Override
	public Collection<? extends T> selectAll(BsjType type)
	{
		List<T> result = new ArrayList<T>();
		for (T o : data)
		{
			BsjType dataType = this.manager.getToolkit().getTypeBuilder().makeMetaprogramClasspathType(o.getClass());
			if (dataType.isSubtypeOf(type))
			{
				result.add(o);
			}
		}
		return result;
	}

	@Override
	public BsjSelectionType getType()
	{
		Bag<BsjActualType> types = new HashBag<BsjActualType>();
		for (Object o : data)
		{
			types.add(this.manager.getToolkit().getTypeBuilder().makeMetaprogramClasspathType(o.getClass()));
		}
		return new SelectionTypeImpl(this.manager, types);
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((data == null) ? 0 : data.hashCode());
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
		SelectionBagImpl<?> other = (SelectionBagImpl<?>) obj;
		if (data == null)
		{
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		return true;
	}
}
