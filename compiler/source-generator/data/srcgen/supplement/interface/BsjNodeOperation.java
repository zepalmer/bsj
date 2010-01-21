/* GEN:importstart */
/**
 * This interface specifies an operation to be carried out on a node.  The purpose of this
 * mechanism is effectively to allow the addition of operations to the node hierarchy
 * requiring that the hierarchy itself be modified.  Note that while this interface is
 * similar to that of the visitor pattern (see {@link BsjNodeVisitor}), it does not function
 * the same way.  This mechanism does not abstract node traversal; the implementation is
 * required to do that itself if it wishes to walk the tree.
 *
 * @param <P> A parameter type for all methods to accept.  If no return type is desired, use
 * {@link java.lang.Void}.
 * @param <R> A return type for all methods to return.  If no return type is desired, use
 * {@link java.lang.Void}.
 *
 * @author Zachary Palmer
 */
/* GEN:importstop */
public interface BsjNodeOperation<P,R>
{
/* GEN:start */
/* GEN:stop */
}