package edu.jhu.cs.bsj.compiler.impl.utils;

import java.util.ListIterator;

/**
 * Represents a list iterator wrapper which converts the contents to another type.
 * @author Zachary Palmer
 *
 * @param <T> The type produced by this iterator.
 * @param <U> The type produced by the backing iterator.
 */
public class ConversionListIterator<T,U> implements ListIterator<T>
{
	/** The backing iterator. */
	private ListIterator<U> backing;
	/** The front-to-back converter to use. */
	private Converter<T,U> frontToBackConverter;
	/** The back-to-front converter to use. */
	private Converter<U,T> backToFrontConverter;

	/**
	 * Creates a new conversion list iterator.
	 * @param backing The backing iterator.
	 * @param frontToBackConverter The converter from the view type to the backing type.
	 * @param backToFrontConverter The converter from the backing type to the view type.
	 */
	public ConversionListIterator(ListIterator<U> backing, Converter<T, U> frontToBackConverter,
			Converter<U, T> backToFrontConverter)
	{
		super();
		this.backing = backing;
		this.frontToBackConverter = frontToBackConverter;
		this.backToFrontConverter = backToFrontConverter;
	}

	@Override
	public void add(T e)
	{
		this.backing.add(this.frontToBackConverter.convert(e));
	}

	@Override
	public boolean hasNext()
	{
		return this.backing.hasNext();
	}

	@Override
	public boolean hasPrevious()
	{
		return this.backing.hasPrevious();
	}

	@Override
	public T next()
	{
		return this.backToFrontConverter.convert(this.backing.next());
	}

	@Override
	public int nextIndex()
	{
		return this.backing.nextIndex();
	}

	@Override
	public T previous()
	{
		return this.backToFrontConverter.convert(this.backing.previous());
	}

	@Override
	public int previousIndex()
	{
		return this.backing.previousIndex();
	}

	@Override
	public void remove()
	{
		this.backing.remove();
	}

	@Override
	public void set(T e)
	{
		this.backing.set(this.frontToBackConverter.convert(e));
	}
}
