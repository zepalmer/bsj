package edu.jhu.cs.bsj.compiler.impl.utils;

import java.util.AbstractList;
import java.util.List;

/**
 * This specialized {@link List} implementation is immutable and holds exactly two elements.
 * 
 * @author Zachary Palmer
 */
public class TwoElementImmutableList<T> extends AbstractList<T>
{
	/** The first element. */
	private T first;
	/** The second element. */
	private T second;

	public TwoElementImmutableList(T first, T second)
	{
		super();
		this.first = first;
		this.second = second;
	}

	@Override
	public T get(int index)
	{
		switch (index)
		{
			case 0: return first;
			case 1: return second;
			default:
				throw new IndexOutOfBoundsException(String.valueOf(index) + " is out of range [0,2)");
		}
	}

	@Override
	public int size()
	{
		return 2;
	}
}
