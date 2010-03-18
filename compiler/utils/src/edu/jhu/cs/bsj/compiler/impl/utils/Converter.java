package edu.jhu.cs.bsj.compiler.impl.utils;

/**
 * This interface is implemented by objects which can convert objects from one type to another.
 * @author Zachary Palmer
 * @param <T> The input type of this converter.
 * @param <U> The output type of this converter.
 */
public interface Converter<T,U>
{
	/**
	 * Converts an object.
	 * @param t The input object.
	 * @return The output object.
	 */
	public U convert(T t);
}
