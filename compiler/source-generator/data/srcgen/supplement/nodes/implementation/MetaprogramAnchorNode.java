import edu.jhu.cs.bsj.compiler.impl.ast.Attribute;
import edu.jhu.cs.bsj.compiler.impl.ast.node.ClassDeclarationNodeImpl.LocalAttribute;

public interface MetaprogramAnchorNode
{
	/* GEN:start */
	/**
	 * Retrieves the node with which this anchor will be replaced once its metaprogram executes.
	 * @return The replacement node to use.
	 */
	public T getReplacement()
	{
		recordAccess(LocalAttribute.REPLACEMENT, Attribute.AccessType.READ);
		return this.replacement;
	}
	
	/**
	 * Changes the node with which this anchor will be replaced once its metaprogram executes.
	 * @param replacement The replacement node to use.
	 */
	public void setReplacement(T replacement)
	{
		// TODO: some kind of control on this; setReplacement should probably only be called one time?
		recordAccess(LocalAttribute.REPLACEMENT, Attribute.AccessType.WRITE);
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