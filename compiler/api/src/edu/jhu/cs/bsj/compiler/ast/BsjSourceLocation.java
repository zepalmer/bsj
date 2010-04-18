package edu.jhu.cs.bsj.compiler.ast;

/**
 * This class represents a location in a BSJ or Java source file. Line and column numbers are one-based.
 * 
 * @author Zachary Palmer
 */
public class BsjSourceLocation implements Comparable<BsjSourceLocation>, Cloneable
{
	/**
	 * The value which will be used for line or column when no information is available.
	 */
	public static final int NOPOS = 0;

	/**
	 * The name of the source specified by this location. This should be, for example, the name of the source unit
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

	/**
	 * Creates a new source location.
	 * 
	 * @param resourceName The name of the resource.
	 * @param line The line number of this location.
	 * @param column The column number of this location.
	 */
	public BsjSourceLocation(String resourceName, int line, int column)
	{
		super();
		this.resourceName = resourceName;
		this.line = line;
		this.column = column;
	}

	/**
	 * Copying constructor. Creates a deep copy of the provided object.
	 * 
	 * @param other The other source location.
	 */
	public BsjSourceLocation(BsjSourceLocation other)
	{
		this(other.getResourceName(), other.getLine(), other.getColumn());
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

	@Override
	public String toString()
	{
		return this.resourceName + ":" + this.line + ":" + this.column;
	}

	@Override
	public int compareTo(BsjSourceLocation o)
	{
		int c = this.resourceName.compareTo(o.getResourceName());
		if (c != 0)
			return c;
		if (getLine() < o.getLine())
			return -1;
		if (getLine() > o.getLine())
			return 1;
		if (getColumn() < o.getColumn())
			return -1;
		if (getColumn() > o.getColumn())
			return 1;
		return 0;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + column;
		result = prime * result + line;
		result = prime * result + ((resourceName == null) ? 0 : resourceName.hashCode());
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
		BsjSourceLocation other = (BsjSourceLocation) obj;
		if (column != other.column)
			return false;
		if (line != other.line)
			return false;
		if (resourceName == null)
		{
			if (other.resourceName != null)
				return false;
		} else if (!resourceName.equals(other.resourceName))
			return false;
		return true;
	}

	@Override
	public BsjSourceLocation clone()
	{
		try
		{
			return (BsjSourceLocation) (super.clone());
		} catch (CloneNotSupportedException e)
		{
			throw new IllegalStateException("CloneNotSupportedException thrown by super.clone() on Cloneable class!", e);
		}
	}
}
