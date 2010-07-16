package edu.jhu.cs.bsj.compiler.tool.data;

import java.util.NoSuchElementException;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;

/**
 * Stores thread local data for the BSJ Compiler API. Each data element is stored in a stack-like fashion; the current
 * value is the most recently pushed value that has not yet been popped. Any caller which pushes an element is
 * responsible for popping it.
 * 
 * @author Zachary Palmer
 */
public interface BsjThreadLocalData
{
	/**
	 * An enumeration of the data elements stored in the {@link BsjThreadLocalData} store.
	 * 
	 * @param <T> The type of data represented by this data element.
	 */
	public static final class Element<T>
	{
		/** The data element which represents the node factory to use when constructing code literals. */
		public static final Element<BsjNodeFactory> NODE_FACTORY = new Element<BsjNodeFactory>("NODE_FACTORY");
		
		/** The description for this element. */
		private String description;

		/**
		 * Prevents external construction of this element type.
		 */
		private Element(String description)
		{
			this.description = description;
		}
		
		/**
		 * Retrieves the description for this element.
		 * @return The description for this element.
		 */
		public String toString()
		{
			return this.description;
		}
	}

	/**
	 * Retrieves the current value for the specified data element.
	 * 
	 * @param element The data element to retrieve.
	 * @return The current value for the specified element.
	 * @throws NoSuchElementException If the specified element does not have any value.
	 */
	public <T> T get(Element<T> element) throws NoSuchElementException;

	/**
	 * Determines whether or not the specified data element has a value.
	 * 
	 * @param element The data element to check.
	 * @return <code>true</code> if the element has a value; <code>false</code> if it does not.
	 */
	public <T> boolean has(Element<T> element);

	/**
	 * Pushes a new value for the specified element. Calls to retrieve this element will return this value until a
	 * corresponding pop call is made.
	 * @param element The data element to push.
	 * @param value The value to push for that element.
	 */
	public <T> void push(Element<T> element, T value);
	
	/**
	 * Pops a value for the specified element.
	 * @param element The data element to pop.
	 * @return The value that was popped.
	 * @throws NoSuchElementException If no element was on the stack to be popped.
	 */
	public <T> T pop(Element<T> element) throws NoSuchElementException;
}
