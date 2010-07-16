package edu.jhu.cs.bsj.compiler.impl.tool.data;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Stack;

import edu.jhu.cs.bsj.compiler.tool.data.BsjThreadLocalData;

public class BsjThreadLocalDataImpl implements BsjThreadLocalData
{
	/**
	 * A mapping between data elements and corresponding value stacks.
	 */
	private Map<Element<?>, Stack<?>> dataMap;
	
	/**
	 * Creates a new BSJ thread local data registry.
	 */
	public BsjThreadLocalDataImpl()
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

	@Override
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

	@Override
	public <T> boolean has(Element<T> element)
	{
		return getStack(element).size()>0;
	}

	@Override
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

	@Override
	public <T> void push(Element<T> element, T value)
	{
		getStack(element).push(value);
	}
}
