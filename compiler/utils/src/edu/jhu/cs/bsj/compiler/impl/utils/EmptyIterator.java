package edu.jhu.cs.bsj.compiler.impl.utils;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * An empty iterator implementation. Used as a nullary object in cases when an iterator is desired but no results are to
 * be provided. Consumes less memory than attempting to create a list or other data structure to obtain its iterator.
 * 
 * @author Zachary Palmer
 */
public class EmptyIterator<T> implements Iterator<T>
{
	@Override
	public boolean hasNext()
	{
		return false;
	}

	@Override
	public T next()
	{
		throw new NoSuchElementException();
	}

	@Override
	public void remove()
	{
		throw new IllegalStateException();
	}
}
