public interface MetaprogramAnchorNode
{
	/* GEN:start */
	/**
	 * Changes the node with which this anchor will be replaced once its metaprogram executes.
	 * @param replacement The replacement node to use.
	 */
	public void setReplacement(T replacement)
	{
		if (this.replacement instanceof NodeImpl)
		{
			((NodeImpl)this.replacement).setParent(null);
		}
		this.replacement = replacement;
		if (this.replacement instanceof NodeImpl)
		{
			((NodeImpl)this.replacement).setParent(this);
		}
	}
	/* GEN:stop */
}