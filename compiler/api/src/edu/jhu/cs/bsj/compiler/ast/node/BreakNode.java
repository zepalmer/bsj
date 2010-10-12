package edu.jhu.cs.bsj.compiler.ast.node;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.NodeUnion;

/**
 * A node representing break statements, as in:
 * <pre>
 *     break <i>label</i>;
 * </pre>
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface BreakNode extends Node, StatementNode
{
    /**
     * Gets the break label.
     * @return The break label.
     * @throws ClassCastException If the value of this property is a special node.
     */
    public IdentifierNode getLabel()throws ClassCastException;
    
    /**
     * Gets the union object for the break label.
     * @return A union object representing The break label.
     */
    public NodeUnion<? extends IdentifierNode> getUnionForLabel();
    
    /**
     * Changes the break label.
     * @param label The break label.
     */
    public void setLabel(IdentifierNode label);
    
    /**
     * Changes the break label.
     * @param label The break label.
     * @throws NullPointerException If the provided value is <code>null</code>.
     *                              Node union values may have <code>null</code>
     *                              contents but are never <code>null</code>
     *                              themselves.
     */
    public void setUnionForLabel(NodeUnion<? extends IdentifierNode> label) throws NullPointerException;
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public BreakNode deepCopy(BsjNodeFactory factory);
    
}
