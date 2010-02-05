import java.util.Collections;
import java.util.List;

public class ListNodeImpl<T extends Node> extends Node implements ListNode<T>
{
	/* GEN:start */
	/** General constructor */
	public ListNodeImpl(List<? extends T> children, BsjSourceLocation startLocation, BsjSourceLocation stopLocation)
	{
		super(startLocation, stopLocation);
		// TODO: replace the following implementations with something more efficient than instanceof
		this.children = new ProxyList<T>(new ArrayList<T>(children))
		{
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
		};
	}

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
	
	// TODO: implement the List<T> interface
	/* GEN:stop */
}