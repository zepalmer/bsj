import java.util.List;

public class ListNodeImpl<T extends Node> extends Node implements ListNode<T>
{
	/* GEN:start */
	/** General constructor */
    public ListNodeImpl(List<? extends T> children)
    {
        super();
        this.children = new ArrayList<T>(children);
    }

	// TODO: implement the List<T> interface
	/* GEN:stop */
}