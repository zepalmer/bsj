package edu.jhu.cs.bsj.compiler.impl.ast.attribute;

/**
 * This interface is implemented by all classes which can be used as an access type for an attribute.
 * 
 * @param <T> The type of {@link AccessType} to which this class can be compared. This is typically the implementing
 *            class.
 * @author Zachary Palmer
 */
public interface AccessType<T extends AccessType<T>>
{
	/**
	 * Determines whether or not the provided access type conflicts with this one.
	 * @param other The other access type.
	 */
	public boolean conflicts(T other);
	
	/**
	 * Requires an appropriate implementation of the {@link Object#equals(Object)} method.
	 */
	public boolean equals(Object o);
	
	/**
	 * Requires an appropriate implementation of the {@link Object#hashCode()} method.
	 */
	public int hashCode();
}
