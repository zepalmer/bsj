package edu.jhu.cs.bsj.compiler.impl.ast.attribute;

import edu.jhu.cs.bsj.compiler.ast.exception.MetaprogramAttributeConflictException;
import edu.jhu.cs.bsj.compiler.impl.ast.node.NodeImpl;

/**
 * Records accesses to compilation unit members of a package.
 * 
 * @author Zachary Palmer
 */
public class PackageCompilationUnitAttribute extends AbstractAttribute<PackageCompilationUnitAttribute.AccessType>
{
	public PackageCompilationUnitAttribute(NodeImpl node)
	{
		super(node);
	}

	@Override
	public void recordAccess(AccessType type) throws MetaprogramAttributeConflictException
	{
		if (super.node.getManager().getCurrentMetaprogramId() == null)
		{
			return;
		}

		// If we record a LOAD, all previous READs get folded into it
		if (type == AccessType.LOAD)
		{
			this.accessRecords.remove(new AccessRecord<AccessType>(AccessType.READ,
					super.node.getManager().getCurrentMetaprogramId()));
		} else if (type == AccessType.READ)
		{
			if (this.accessRecords.contains(new AccessRecord<AccessType>(AccessType.LOAD,
					super.node.getManager().getCurrentMetaprogramId())))
			{
				return;
			}
		}
		super.recordAccess(type);
	}

	public static enum AccessType implements edu.jhu.cs.bsj.compiler.impl.ast.attribute.AccessType<AccessType>
	{
		/** An access type indicating that a read was performed. */
		READ,
		/** An access type indicating that a compilation unit was loaded. */
		LOAD,
		/** An access type indicating that a compilation unit was added. */
		WRITE;

		@Override
		public boolean conflicts(AccessType other)
		{
			switch (this)
			{
				case READ:
					return other != READ;
				case LOAD:
					return other != LOAD;
				case WRITE:
					return true;
			}
			return true;
		}
	}
}
