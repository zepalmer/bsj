public interface NameNode
{
	/* GEN:start */
	/**
	 * Retrieves the category for this node's name.
	 * @return The category into which this node falls.
	 */
	public NameCategory getCategory();
	
	/**
	 * Retrieves a qualified string representation of this name.  For simple names, this is merely the text of the name;
	 * for qualified names, this is a dot-separated name sequence.
	 * @return The qualified representation of this name.
	 */
	public String getNameString();
	/* GEN:stop */
}