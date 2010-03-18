package edu.jhu.cs.bsj.compiler.impl.ast;

/**
 * This interface is implemented by any object which can function as an attribute for BSJ nodes.
 * @author Zachary Palmer
 */
public interface Attribute
{
	public static enum AccessType
	{
		READ, WRITE
	}
}
