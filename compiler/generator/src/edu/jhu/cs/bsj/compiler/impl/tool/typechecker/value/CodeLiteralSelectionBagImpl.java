package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.value;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.TypecheckerManager;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.SelectionTypeImpl;
import edu.jhu.cs.bsj.compiler.impl.utils.HashBag;
import edu.jhu.cs.bsj.compiler.impl.utils.Pair;
import edu.jhu.cs.bsj.compiler.lang.type.BsjActualType;
import edu.jhu.cs.bsj.compiler.lang.type.BsjSelectionType;
import edu.jhu.cs.bsj.compiler.lang.type.BsjType;
import edu.jhu.cs.bsj.compiler.lang.value.SelectionBag;
import edu.jhu.cs.bsj.compiler.utils.Bag;

/**
 * Implements the {@link SelectionBag} interface using functionality specifically intended to implement the code literal
 * logic rules in the BLS. Specifically, this selection bag implements the type weakening behavior required by the BLS
 * to prevent implementation dependence.
 * 
 * @author Zachary Palmer
 */
public class CodeLiteralSelectionBagImpl<T> implements SelectionBag<T>
{
	/** The typechecking manager to use to build types for comparison. */
	private TypecheckerManager manager;
	/** The backing data structure. */
	private Bag<Pair<T, BsjActualType>> data;
	/** The type of this selection bag. */
	private BsjSelectionType type;

	/**
	 * Creates a new selection bag using the specified values.
	 * 
	 * @param manager The typechecking manager to use to build types for comparison.
	 * @param data The data to use.
	 */
	public CodeLiteralSelectionBagImpl(TypecheckerManager manager, Bag<Pair<T, BsjActualType>> data)
	{
		this.data = new HashBag<Pair<T, BsjActualType>>(data);
		this.manager = manager;
		
		Bag<BsjActualType> typeBag = new HashBag<BsjActualType>();
		for (Pair<T,BsjActualType> element : this.data)
		{
			typeBag.add(element.getSecond());
		}
		this.type = new SelectionTypeImpl(this.manager, typeBag);
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
		for (Pair<T,BsjActualType> element : this.data)
		{
			if (element.getSecond().isSubtypeOf(type))
			{
				result.add(element.getFirst());
			}
		}
		return result;
	}

	@Override
	public BsjSelectionType getType()
	{
		return this.type;
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
		CodeLiteralSelectionBagImpl<?> other = (CodeLiteralSelectionBagImpl<?>) obj;
		if (data == null)
		{
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		return true;
	}
}
