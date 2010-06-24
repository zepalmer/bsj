package edu.jhu.cs.bsj.compiler.impl.ast;

/**
 * This interface is implemented by any object which can function as an attribute for BSJ nodes.
 * 
 * @author Zachary Palmer
 */
public interface Attribute
{
	public static enum AccessType
	{
		READ,
		WEAK_WRITE,
		STRONG_WRITE;

		/**
		 * Determines whether or not this access type conflicts with the specified access type.
		 * 
		 * @param accessType The other access type.
		 * @return <code>true</code> if there is a potential conflict; <code>false</code> if these access types cannot
		 *         conflict.
		 */
		public boolean canConflict(AccessType accessType)
		{
			switch (this)
			{
				case READ:
					switch (accessType)
					{
						case READ:
							return false;
						case WEAK_WRITE:
						case STRONG_WRITE:
							return true;
					}
					break;
				case WEAK_WRITE:
					switch (accessType)
					{
						case READ:
							return true;
						case WEAK_WRITE:
							return false;
						case STRONG_WRITE:
							return true;
					}
				case STRONG_WRITE:
					switch (accessType)
					{
						case READ:
						case WEAK_WRITE:
						case STRONG_WRITE:
							return true;
					}
					break;
			}
			throw new IllegalArgumentException("Cannot compare " + this + " and " + accessType);
		}
	}
}
