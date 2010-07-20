/* GEN:headerstart */
/* GEN:headerstop */

public abstract class QualifiedNameNodeImpl
{
	/* GEN:start */
	/**
	 * Retrieves a string representation of this name.
	 * @return The string representation of this name.
	 */
	public String getNameString()
	{
		return getBase().getNameString() + "." + getIdentifier().getIdentifier();
	}
	/* GEN:stop */
}