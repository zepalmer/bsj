package edu.jhu.cs.bsj.compiler.ast;

/**
 * Represents the different levels of permission that a metaprogram may have to a node.
 * @author Zachary Palmer
 */
public enum NodePermission
{
	/** Indicates that the node's properties may be accessed but not modified. */
	READ(false,false),
	/** Indicates that the node's properties may be accessed but not modified.  New properties may be added if the
	 *  node supports such operations (such as in the case of a list node). */
	INSERT(true,false),
	/** Indicates that the node's properties may be accessed and modified freely. */
	MUTATE(true,true);
	
	/** Indicates whether or not insertion is allowed. */
	private boolean insertable;
	/** Indicates whether or not mutation is allowed. */
	private boolean mutatable;
	
	private NodePermission(boolean insertable, boolean mutatable)
	{
		this.insertable = insertable;
		this.mutatable = mutatable;
	}
	
	/**
	 * Determines whether or not this permission allows reading of the node's properties.
	 * @return <code>true</code> if the node is readable; <code>false</code> otherwise.
	 */
	public boolean isReadable()
	{
		return true;
	}

	/**
	 * Determines whether or not this permission allows insertion of new node properties.
	 * @return <code>true</code> if the node is insertable; <code>false</code> otherwise.
	 */
	public boolean isInsertable()
	{
		return insertable;
	}

	/**
	 * Determines whether or not this permission allows arbitrary mutation of the node.
	 * @return <code>true</code> if the node is mutatable; <code>false</code> otherwise.
	 */
	public boolean isMutatable()
	{
		return mutatable;
	}
}
