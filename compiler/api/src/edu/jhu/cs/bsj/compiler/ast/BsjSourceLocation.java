package edu.jhu.cs.bsj.compiler.ast;

/**
 * This class represents a location in a BSJ or Java source file. Line and column numbers are one-based.
 * 
 * @author Zachary Palmer
 */
// TODO: create an abstraction.  The sibling to this class would be one that indicates "generated from", such as when
// a metaprogram generates code and inserts it into the AST.
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
