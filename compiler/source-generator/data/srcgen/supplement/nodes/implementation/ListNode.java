import java.util.Collections;
import java.util.List;

public class ListNodeImpl<T extends Node> extends Node implements ListNode<T>
{
	/* GEN:start */

	/**
	 * Creates a list of this node's child objects. Modifying the list has no effect on this node.
	 * 
	 * @return A mutable list of this node's child objects.
	 */
	public List<Object> getChildObjects()
	{
		List<Object> list = super.getChildObjects();
		list.addAll(this.children);
		return list;
	}
	
	/**
	 * A proxy list used a list node to ensure that children in the list can access the list node as a parent.
	 * @author Zachary Palmer
	 */
	protected class ListNodeProxyList extends ProxyList<T>
	{
		public ListNodeProxyList(List<T> list)
		{
			super(new ArrayList<T>(list));
		}
		protected void elementAdded(int index, T element)
		{
			if (element instanceof NodeImpl)
			{
				((NodeImpl)element).setParent(ListNodeImpl.this);
			}
		}
		protected void elementRemoved(int index, T element)
		{
			if (element instanceof NodeImpl)
			{
				((NodeImpl)element).setParent(null);
			}
		}
	}
	
	// TODO: implement the List<T> interface
	/* GEN:stop */
}