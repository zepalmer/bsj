package edu.jhu.cs.bsj.compiler.ast.node.list;

import java.util.List;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.NodeList;
import edu.jhu.cs.bsj.compiler.ast.NodeUnion;
import edu.jhu.cs.bsj.compiler.ast.node.Node;

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
 * This is an unsafe cast and would result in an obscure runtime error if the parent is not a list of the
 * correct type.  In order to prevent this problem, this AST library creates an individual list node type
 * for each list element type, allowing the above code to be replaced by
 * <pre>
 * XListNode parent = (XListNode)getParent();
 * </pre>
 * If the parent is not a list of the correct type, an error still occurs at runtime.  However, the error
 * will occur at this line and not later in the code when an attempt is made to retrieve an element from
 * the list.
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
     * Gets the union object for the list of children.
     * @return A union object representing The list of children.
     */
    public List<NodeUnion<? extends T>> getUnionForChildren();
    
    /**
     * Gets whether or not this list's contents are always order-dependent.
     * @return Whether or not this list's contents are always order-dependent.
     */
    public boolean getAlwaysOrdered();
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public ListNode<T> deepCopy(BsjNodeFactory factory);
    
	/**
	 * Retrieves the element type of this list.
	 * @return A class representing the element type of this list.
	 */
	public abstract Class<T> getElementType();
}
