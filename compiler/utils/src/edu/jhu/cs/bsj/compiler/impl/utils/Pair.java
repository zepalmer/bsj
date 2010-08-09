package edu.jhu.cs.bsj.compiler.impl.utils;

/**
 * Represents a pairing between two objects.
 * @author Zachary Palmer
 *
 * @param <T> The type of the first element in the pair.
 * @param <U> The type of the second element in the pair.
 */
public class Pair<T,U>
{
	/** The first value in the pair. */
	private T first;
	/** The second value in the pair. */
	private U second;
	
	public Pair(T first, U second)
	{
		super();
		this.first = first;
		this.second = second;
	}

	public T getFirst()
	{
		return first;
	}

	public U getSecond()
	{
		return second;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((first == null) ? 0 : first.hashCode());
		result = prime * result + ((second == null) ? 0 : second.hashCode());
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
		@SuppressWarnings("rawtypes")
		Pair other = (Pair) obj;
		if (first == null)
		{
			if (other.first != null)
				return false;
		} else if (!first.equals(other.first))
			return false;
		if (second == null)
		{
			if (other.second != null)
				return false;
		} else if (!second.equals(other.second))
			return false;
		return true;
	}
	
	/**
	 * Generates a string describing this pair.
	 * @return The string description of this object.
	 */
	public String toString()
	{
		return "("+this.first+","+this.second+")";
	}
}
