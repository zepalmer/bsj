package edu.jhu.cs.bsj.compiler.tool.data;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Stack;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.metaprogram.Context;

/**
 * Stores thread local data for the BSJ Compiler API. Each data element is stored in a stack-like fashion; the current
 * value is the most recently pushed value that has not yet been popped. Any caller which pushes an element is
 * responsible for popping it.
 * 
 * @author Zachary Palmer
 */
// TODO: consider replacing this with language built-ins like #factory.  This would allow us to hide the thread local
// data from the API, permitting each compiler implementation to handle this problem in its own way.
public class BsjThreadLocalData
{
    private static final BsjThreadLocalData INSTANCE = new BsjThreadLocalData();
    
	/**
	 * An enumeration of the data elements stored in the {@link BsjThreadLocalData} store.
	 * 
	 * @param <T> The type of data represented by this data element.
	 */
	public static final class Element<T>
	{
		/** The data element which represents the node factory to use when constructing code literals. */
		public static final Element<BsjNodeFactory> NODE_FACTORY = new Element<BsjNodeFactory>("NODE_FACTORY");
		/** The data element which represents the current context to use. */
		public static final Element<Context<?,?>> CONTEXT = new Element<Context<?,?>>("CONTEXT");
		
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
     * A mapping between data elements and corresponding value stacks.
     */
    private Map<Element<?>, Stack<?>> dataMap;
    
    /**
     * Creates a new BSJ thread local data registry.
     */
    private BsjThreadLocalData()
    {
        this.dataMap = new HashMap<Element<?>, Stack<?>>();
    }
    
    /**
     * Retrieves the stack corresponding to the specified data element.
     * @param element The element in question.
     */
    @SuppressWarnings("unchecked") // We are maintaining this invariant manually.
    private <T> Stack<T> getStack(Element<T> element)
    {
        Stack<T> stack = (Stack<T>)this.dataMap.get(element);
        if (stack == null)
        {
            stack = new Stack<T>();
            this.dataMap.put(element, stack);
        }
        return stack;
    }

    /**
     * Retrieves the current value for the specified data element.
     * 
     * @param element The data element to retrieve.
     * @return The current value for the specified element.
     * @throws NoSuchElementException If the specified element does not have any value.
     */
    public <T> T get(Element<T> element) throws NoSuchElementException
    {
        Stack<T> stack = getStack(element);
        if (stack.size()>0)
        {
            return stack.peek();
        } else
        {
            throw new NoSuchElementException("No value for element " + element.toString());
        }
    }

    /**
     * Determines whether or not the specified data element has a value.
     * 
     * @param element The data element to check.
     * @return <code>true</code> if the element has a value; <code>false</code> if it does not.
     */
    public <T> boolean has(Element<T> element)
    {
        return getStack(element).size()>0;
    }

    /**
     * Pops a value for the specified element.
     * @param element The data element to pop.
     * @return The value that was popped.
     * @throws NoSuchElementException If no element was on the stack to be popped.
     */
    public <T> T pop(Element<T> element) throws NoSuchElementException
    {
        Stack<T> stack = getStack(element);
        if (stack.size()>0)
        {
            return stack.pop();
        } else
        {
            throw new NoSuchElementException("No value for element " + element.toString());
        }
    }

    /**
     * Pushes a new value for the specified element. Calls to retrieve this element will return this value until a
     * corresponding pop call is made.
     * @param element The data element to push.
     * @param value The value to push for that element.
     */
    public <T> void push(Element<T> element, T value)
    {
        getStack(element).push(value);
    }
    
    /**
     * Retrieves the globally unique thread local data registry.
     */
    public static BsjThreadLocalData getInstance()
    {
        return INSTANCE;
    }

    @Override
    public String toString()
    {
        return this.dataMap.toString();
    }
}
