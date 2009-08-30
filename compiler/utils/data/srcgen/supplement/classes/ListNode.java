import java.util.List;

public class ListNode<T extends Node> extends Node
{
	/* GEN:start */
	/** General constructor */
    public ListNodeImpl<T extends Node>(List<? extends T> children)
    {
        super();
        this.children = new ArrayList<? extends T>(children);
    }

	// TODO: implement the List<T> interface
	/* GEN:stop */
}