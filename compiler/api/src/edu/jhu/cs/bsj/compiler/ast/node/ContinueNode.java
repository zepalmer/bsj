package edu.jhu.cs.bsj.compiler.ast.node;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.NodeUnion;

/**
 * A node representing continue statements, as in:
 * <pre>
 *     continue <i>label</i>;
 * </pre>
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface ContinueNode extends Node, StatementNode
{
    /**
     * Gets the continue label.
     * @return The continue label.
     * @throws ClassCastException If the value of this property is a special node.
     */
    public IdentifierNode getLabel()throws ClassCastException;
    
    /**
     * Gets the union object for the continue label.
     * @return A union object representing The continue label.
     */
    public NodeUnion<? extends IdentifierNode> getUnionForLabel();
    
    /**
     * Changes the continue label.
     * @param label The continue label.
     */
    public void setLabel(IdentifierNode label);
    
    /**
     * Changes the continue label.
     * @param label The continue label.
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
    public ContinueNode deepCopy(BsjNodeFactory factory);
    
}
