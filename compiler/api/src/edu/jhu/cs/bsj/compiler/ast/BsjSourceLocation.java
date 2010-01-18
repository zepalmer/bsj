package edu.jhu.cs.bsj.compiler.ast;

/**
 * This class represents a location in a BSJ or Java source file.
 * @author Zachary Palmer
 */
public class BsjSourceLocation
{
	/**
	 * The name of the source specified by this location.  This should be, for example, the name of the source unit
	 * containing this location.
	 */
	private String resourceName;
	/**
	 * The line number of this location.
	 */
	private int line;
	/**
	 * The column of this location in its line.
	 */
	private int column;
	
	public BsjSourceLocation(String resourceName, int line, int column)
	{
		super();
		this.resourceName = resourceName;
		this.line = line;
		this.column = column;
	}

	public String getResourceName()
	{
		return resourceName;
	}

	public int getLine()
	{
		return line;
	}

	public int getColumn()
	{
		return column;
	}
}
