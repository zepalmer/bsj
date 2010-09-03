package edu.jhu.cs.bsj.compiler.impl.utils;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

/**
 * This list uses {@link Converter}s to populate its elements lazily. Each element is populated at most once from the
 * backing list by use of the converter.
 * 
 * @author Zachary Palmer
 */
public class UnmodifiableLazyList<T, U> extends AbstractList<T>
{
	private List<U> backingList;
	private Converter<U, T> converter;
	private List<T> cache;
	private boolean[] readyFlags;

	public UnmodifiableLazyList(List<U> backingList, Converter<U, T> converter)
	{
		super();
		this.backingList = backingList;
		this.converter = converter;
		this.cache = new ArrayList<T>(this.backingList.size());
		for (int i=0;i<this.backingList.size();i++)
			this.cache.add(null);
		this.readyFlags = new boolean[this.cache.size()];
	}

	@Override
	public T get(int index)
	{
		if (!this.readyFlags[index])
		{
			this.cache.set(index, this.converter.convert(this.backingList.get(index)));
			this.readyFlags[index] = true;
		}
		return this.cache.get(index);
	}

	@Override
	public int size()
	{
		return this.backingList.size();
	}
}
