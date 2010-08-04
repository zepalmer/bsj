package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.element;

import javax.lang.model.element.Name;

public class NameImpl implements Name
{
	/** The value backing the name. */
	private String name;
	
	public NameImpl(String name)
	{
		super();
		this.name = name;
	}

	@Override
	public boolean contentEquals(CharSequence cs)
	{
		return this.name.contentEquals(cs);
	}

	@Override
	public char charAt(int index)
	{
		return this.name.charAt(index);
	}

	@Override
	public int length()
	{
		return this.name.length();
	}

	@Override
	public CharSequence subSequence(int start, int end)
	{
		return new NameImpl(this.name.substring(start,end));
	}

}
