/* GEN:headerstart */
/**
 * This implementation of the BSJ node operation implements every method with a call to a default operation method.  The
 * default operation method is left abstract for the overlying implementation.  This serves as a convenient mechanism
 * for handling most nodes with a default case but labeling some with special handling.  For instance, a node operation
 * which only recognizes a small subset of node types might use the default operation to raise a runtime exception.
 *
 * @author Zachary Palmer
 */
/* GEN:headerstop */
public class BsjDefaultNodeOperation<P,R> implements BsjNodeOperation<P,R>
{
/* GEN:start */
	/**
	 * The default operation which all default node operation implementations will call.
	 * @param node The node in question.
	 * @param p The parameter to the execution method.
	 */
	public abstract R executeDefault(Node node, P p);
/* GEN:stop */
}