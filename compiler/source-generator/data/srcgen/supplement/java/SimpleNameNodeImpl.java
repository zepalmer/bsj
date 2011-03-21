import java.util.Collections;

/* GEN:headerstart */
/* GEN:headerstop */

public abstract class SimpleNameNodeImpl
{
	/* GEN:start */
	/**
	 * Retrieves a string representation of this name.
	 * @return The string representation of this name.
	 */
	public String getNameString()
	{
		return getIdentifier().getIdentifier();
	}
	
	public List<String> getNameComponents()
	{
	    return Collections.singletonList(getIdentifier().getIdentifier());
	}

	/* GEN:stop */
}