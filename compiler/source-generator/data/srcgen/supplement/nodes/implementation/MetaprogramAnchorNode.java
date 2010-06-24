import edu.jhu.cs.bsj.compiler.impl.ast.Attribute;

public class MetaprogramAnchorNodeImpl
{
	/* GEN:start */
	/**
	 * Retrieves the node with which this anchor will be replaced once its metaprogram executes.
	 * @return The replacement node to use.
	 */
	public T getReplacement()
	{
		getAttribute(LocalAttribute.REPLACEMENT).recordAccess(ReadWriteAttribute.AccessType.READ);
		return this.replacement;
	}
	
	/**
	 * Changes the node with which this anchor will be replaced once its metaprogram executes.
	 * @param replacement The replacement node to use.
	 */
	public void setReplacement(T replacement)
	{
		// TODO: some kind of control on this; setReplacement should probably only be called one time?
		getAttribute(LocalAttribute.REPLACEMENT).recordAccess(ReadWriteAttribute.AccessType.WRITE);
		setAsChild(this.replacement, false);
		this.replacement = replacement;
		setAsChild(this.replacement, true);
	}
	/* GEN:stop */
}