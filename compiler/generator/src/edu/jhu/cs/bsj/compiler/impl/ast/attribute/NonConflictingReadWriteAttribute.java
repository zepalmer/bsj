package edu.jhu.cs.bsj.compiler.impl.ast.attribute;

import edu.jhu.cs.bsj.compiler.impl.ast.node.NodeImpl;

/**
 * Represents an attribute which uses read/write access behavior in which writes do not conflict.
 * @author Zachary Palmer
 */
public class NonConflictingReadWriteAttribute extends AbstractAttribute<NonConflictingReadWriteAttribute.AccessType>
{
	public NonConflictingReadWriteAttribute(NodeImpl node)
	{
		super(node);
	}

	/**
	 * The enumeration used to describe access to this type of attribute.
	 */
	public static enum AccessType implements edu.jhu.cs.bsj.compiler.impl.ast.attribute.AccessType<AccessType>
	{
		READ,
		WRITE;

		@Override
		public boolean conflicts(AccessType other)
		{
			return this != other;
		}
	}
}
