import java.util.List;

public interface ListNode<T extends Node> extends Node
{
	/* GEN:start */
    /**
     * Gets a filtered list of children by type.  The resulting list is independent; changes to it will not be reflected in
     * this list.
     * @param type The type of children to return.
     * @return The list of children of this node which have the specified type.
     */
    public <U extends T> List<U> filterByType(Class<U> type);
    
	/**
	 * Retrieves the element type of this list.
	 * @return A class representing the element type of this list.
	 */
	public abstract Class<T> getElementType();
	/* GEN:stop */
}