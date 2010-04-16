package edu.jhu.cs.bsj.compiler.ast.node;

import java.util.List;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.NodeList;

/**
 * Represents a list of nodes.  Nodes do not simply have lists as properties as the ListNode allows
 * additional information to be tracked as necessary.
 * <p/>
 * This class is abstract and extended once for each type of list node required by the AST.  This is done
 * to avoid unsafe typecasts in metaprograms.  For instance, consider a case in which a node of type
 * <tt>X</tt> exists in a parent whose type is <tt>ListNode&lt;X&gt;</tt>.  Without further information,
 * that node would need to use the following code to fully access its parent:
 * <pre>
 * ListNode&lt;X&gt; parent = (ListNode&lt;X&gt;)getParent();
 * </pre>
 * In order to prevent this problem, this AST library creates an individual list node type for each list
 * element type, allowing the above code to be replaced by
 * <pre>
 * XListNode parent = (XListNode)getParent();
 * </pre>
 * which is guaranteed to be type checked at runtime.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface ListNode<T extends Node> extends Node, List<T>, NodeList<T>
{
    /**
     * Gets the list of children.
     * @return The list of children.
     */
    public List<T> getChildren();
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public ListNode<T> deepCopy(BsjNodeFactory factory);
}
