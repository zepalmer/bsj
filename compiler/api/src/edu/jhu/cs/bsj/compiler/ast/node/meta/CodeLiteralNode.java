package edu.jhu.cs.bsj.compiler.ast.node.meta;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.NodeUnion;
import edu.jhu.cs.bsj.compiler.ast.node.BsjSpecificNode;
import edu.jhu.cs.bsj.compiler.ast.node.LiteralNode;
import edu.jhu.cs.bsj.compiler.ast.node.Node;

/**
 * A node representing a processed code literal.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface CodeLiteralNode extends Node, LiteralNode<Node>, BsjSpecificNode
{
    /**
     * Gets the node represented by this code literal.
     * @return The node represented by this code literal.
     * @throws ClassCastException If the value of this property is a special node.
     */
    public Node getValue() throws ClassCastException;
    
    /**
     * Gets the union object for the node represented by this code literal.
     * @return A union object representing The node represented by this code literal.
     */
    public NodeUnion<? extends Node> getUnionForValue();
    
    /**
     * Changes the node represented by this code literal.
     * @param value The node represented by this code literal.
     */
    public void setValue(Node value);
    
    /**
     * Changes the node represented by this code literal.
     * @param value The node represented by this code literal.
     * @throws NullPointerException If the provided value is <code>null</code>.
     *                              Node union values may have <code>null</code>
     *                              contents but are never <code>null</code>
     *                              themselves.
     */
    public void setUnionForValue(NodeUnion<? extends Node> value) throws NullPointerException;
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public CodeLiteralNode deepCopy(BsjNodeFactory factory);
    
}
