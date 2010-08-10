public interface NameNode
{
	/* GEN:start */
	/**
	 * Retrieves the category for this node's name.
	 * @param loader The compilation unit loader to use if compilation units need to be loaded when determining the
	 * 				 name category.  This may be necessary if, for example, the meaning of the name is determined by
	 * 				 an on-demand import.
	 * @return The category into which this node falls.
	 */
	public NameCategory getCategory(CompilationUnitLoader loader);
	
	/**
	 * Retrieves a qualified string representation of this name.  For simple names, this is merely the text of the name;
	 * for qualified names, this is a dot-separated name sequence.
	 * @return The qualified representation of this name.
	 */
	public String getNameString();
	/* GEN:stop */
}