package edu.jhu.cs.bsj.compiler.impl.utils;

import java.util.Iterator;

/**
 * Represents an iterator which uses a {@link Converter} to change the type it produces.
 * @author Zachary Palmer
 *
 * @param <T> The type that this iterator produces.
 * @param <U> The type that the backing iterator produces.
 */
public class ConversionIterator<T,U> implements Iterator<T>
{
	/** The backing iterator. */
	private Iterator<U> backing;
	/** The converter to use. */
	private Converter<U,T> converter;
	
	/**
	 * Creates a new conversion iterator.
	 * @param backing The backing iterator.
	 * @param converter The converter to apply.
	 */
	public  ConversionIterator(Iterator<U> backing, Converter<U, T> converter)
	{
		super();
		this.backing = backing;
		this.converter = converter;
	}

	@Override
	public boolean hasNext()
	{
		return this.backing.hasNext();
	}

	@Override
	public T next()
	{
		return this.converter.convert(this.backing.next());
	}

	@Override
	public void remove()
	{
		this.backing.remove();
	}
}
