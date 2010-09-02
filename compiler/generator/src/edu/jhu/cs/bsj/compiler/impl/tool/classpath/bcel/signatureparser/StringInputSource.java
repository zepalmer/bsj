package edu.jhu.cs.bsj.compiler.impl.tool.classpath.bcel.signatureparser;

import java.util.LinkedList;
import java.util.List;

/**
 * Represents an input source obtained from a string. The string is expected to contain characters represented in the
 * ASCII character space.
 * 
 * @author Zachary Palmer
 */
public class StringInputSource extends AbstractInputSource
{
	private String data;
	private int index;
	private List<Integer> stateStack;

	public StringInputSource(String data)
	{
		super();
		this.data = data;
		this.index = 0;
		this.stateStack = new LinkedList<Integer>();
	}

	@Override
	public char peek() throws ParseException
	{
		if (this.index < this.data.length())
		{
			return this.data.charAt(index);
		} else
		{
			throw new ParseException("Out of data");
		}
	}

	@Override
	public char consume() throws ParseException
	{
		char ret = peek();
		this.index++;
		return ret;
	}

	@Override
	public boolean isExhausted()
	{
		return this.index == this.data.length();
	}

	@Override
	public void push()
	{
		this.stateStack.add(this.index);
	}

	@Override
	public void pop()
	{
		if (this.stateStack.size() == 0)
		{
			throw new IllegalStateException("No corresponding push!");
		} else
		{
			this.index = this.stateStack.remove(this.stateStack.size()-1);
		}
	}

	@Override
	public void erase()
	{
		if (this.stateStack.size() == 0)
		{
			throw new IllegalStateException("No corresponding push!");
		} else
		{
			this.stateStack.remove(this.stateStack.size()-1);
		}
	}
	
	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		sb.append(this.data);
		sb.append('\n');
		for (int i=0;i<this.index;i++)
			sb.append(' ');
		sb.append('^');
		sb.append(' ');
		sb.append(this.index);
		return sb.toString();
	}
}
