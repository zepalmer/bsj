/* GEN:headerstart */
/**
 * This implementation of the BSJ node operation implements methods which correspond to BSJ-specific node types with a
 * call to a default operation method. The default operation method is left abstract for the overlying implementation.
 * This serves as a convenient mechanism for operating over trees which should be pure Java ASTs; the default method may
 * raise an exception or perform other error reporting operations.
 * 
 * @author Zachary Palmer
 */
/* GEN:headerstop */
public class JavaNodeOperation<P, R> implements BsjNodeOperation<P, R>
{
	/* GEN:start */
	/**
	 * The default operation which all BSJ-specific node operation implementations will call.
	 * 
	 * @param node The node in question.
	 * @param p The parameter to the execution method.
	 */
	public abstract R handleBsjSpecificNode(BsjSpecificNode node, P p);
	/* GEN:stop */
}