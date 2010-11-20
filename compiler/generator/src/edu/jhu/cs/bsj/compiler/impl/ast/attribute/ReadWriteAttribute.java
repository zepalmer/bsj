package edu.jhu.cs.bsj.compiler.impl.ast.attribute;

import edu.jhu.cs.bsj.compiler.impl.ast.node.NodeImpl;

/**
 * Represents an attribute which uses simple read/write access behavior.
 * @author Zachary Palmer
 */
public class ReadWriteAttribute extends AbstractAttribute<ReadWriteAttribute.AccessType>
{
	public ReadWriteAttribute(NodeImpl node, AttributeName name)
	{
		super(node, name);
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
			return this == WRITE || other == WRITE;
		}
	}
}
