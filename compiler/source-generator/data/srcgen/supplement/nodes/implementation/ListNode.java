import java.util.List;

public class ListNodeImpl<T extends Node> extends Node implements ListNode<T>
{
	/* GEN:start */
	/** General constructor */
    public ListNodeImpl(List<? extends T> children, BsjSourceLocation startLocation, BsjSourceLocation stopLocation)
    {
        super(startLocation, stopLocation);
        this.children = new ArrayList<T>(children);
    }
    
    /**
     * Creates a list of this node's child objects.  Modifying the list has no effect on this node.
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