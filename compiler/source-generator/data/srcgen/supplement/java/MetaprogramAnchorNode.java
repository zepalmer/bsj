public interface MetaprogramAnchorNode<T extends Node>
{
	/* GEN:start */
	/**
	 * Creates a node which is suitable as a default replacement for this node.
	 * @param factory The node factory to use.
	 * @return A suitable default replacement for this node.
	 */
	public T getDefaultReplacement(BsjNodeFactory factory);
	/* GEN:stop */
}