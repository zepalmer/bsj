/* GEN:headerstart */
/**
 * This interface is implemented by those classes which wish to perform visitation operations
 * over a BSJ AST.  Each node visits a method for its own class as well as all of its
 * superclasses in order from most specific type to least specific type (when the visit
 * starts) or from least specific type to most specific type (when the visit ends).  Each
 * method representing a concrete type also accepts a boolean argument from the node
 * indicating whether or not that type is the most specific type for that node.  A method is
 * also called (after or before the previous calls for start and stop, respectively) for each
 * interface the node implements.  Finally, each node's sequence of starting calls begins
 * with a call to <tt>visitStartBegin</tt> and ends with a call to <tt>visitStartEnd</tt>;
 * likewise, each sequence of ending calls begins with a call to <tt>visitStopBegin</tt> and
 * ends with a call to <tt>visitStopEnd</tt>.
 * <p/>
 * For example, imagine a simple type hierarchy in which <tt>C</tt> extends from <tt>B</tt>
 * and <tt>B</tt> extends from <tt>A</tt>.  Assume that <tt>C</tt> and <tt>B</tt> are
 * concrete classes while <tt>A</tt> is not.  In that case, the following sequence of methods
 * would be called if an instance this visitor interface were to visit an instance of node
 * <tt>C</tt>:
 * <ul>
 * <li><tt>visitStartBegin(node)</tt></li>
 * <li><tt>visitCStart(node,true)</tt></li>
 * <li><tt>visitBStart(node,false)</tt></li>
 * <li><tt>visitAStart(node)</tt></li>
 * <li><tt>visitStartEnd(node)</tt></li>
 * <li><tt>visitStopBegin(node)</tt></li>
 * <li><tt>visitAStop(node)</tt></li>
 * <li><tt>visitBStop(node,false)</tt></li>
 * <li><tt>visitCStop(node,true)</tt></li>
 * <li><tt>visitStopEnd(node)</tt></li>
 * </ul>
 * As usual for a tree visitor pattern, each node is visited around their child visits.  If
 * <tt>node</tt> above had a <tt>child</tt> of type <tt>B</tt>, the executed sequence of
 * calls would be extended as shown below.
 * <ul>
 * <li><tt>visitStartBegin(node)</tt></li>
 * <li><tt>visitCStart(node,true)</tt></li>
 * <li><tt>visitBStart(node,false)</tt></li>
 * <li><tt>visitAStart(node)</tt></li>
 * <li><tt>visitStartEnd(node)</tt></li>
 * <li><tt>visitStartBegin(child)</tt></li>
 * <li><tt>visitBStart(child,true)</tt></li>
 * <li><tt>visitAStart(child)</tt></li>
 * <li><tt>visitStartEnd(child)</tt></li>
 * <li><tt>visitStopBegin(child)</tt></li>
 * <li><tt>visitAStop(child)</tt></li>
 * <li><tt>visitBStop(child,true)</tt></li>
 * <li><tt>visitStopEnd(child)</tt></li>
 * <li><tt>visitStopBegin(node)</tt></li>
 * <li><tt>visitAStop(node)</tt></li>
 * <li><tt>visitBStop(node,false)</tt></li>
 * <li><tt>visitCStop(node,true)</tt></li>
 * <li><tt>visitStopEnd(node)</tt></li>
 * </ul>
 * This interface is very efficient at providing for the needs of visitors which regularly
 * need to condition behavior based on node type and have a number of types to service.  If
 * a simpler traversal of the nodes in the tree is desired, {@link BsjNodeVisitor} may be
 * more suitable.
 * <p/>
 * It should be noted that some nodes may have <code>null</code> children; these children are not visited by this
 * visitor in any way.
 *
 * @author Zachary Palmer
 */
/* GEN:headerstop */
public interface BsjTypedNodeVisitor
{
/* GEN:start */
/* GEN:stop */
}
