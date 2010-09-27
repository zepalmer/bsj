package edu.jhu.cs.bsj.compiler.ast.node;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.NodeUnion;

/**
 * A node representing labeled statements, as in:
 * <pre>
 * <i>identifier</i>: <i>statement</i>
 * </pre>
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface LabeledStatementNode extends Node, StatementNode
{
    /**
     * Gets the statement's label.
     * @return The statement's label.
     * @throws ClassCastException If the value of this property is a special node.
     */
    public IdentifierNode getLabel() throws ClassCastException;
    
    /**
     * Gets the union object for the statement's label.
     * @return A union object representing The statement's label.
     */
    public NodeUnion<? extends IdentifierNode> getUnionForLabel();
    
    /**
     * Changes the statement's label.
     * @param label The statement's label.
     */
    public void setLabel(IdentifierNode label);
    
    /**
     * Changes the statement's label.
     * @param label The statement's label.
     * @throws NullPointerException If the provided value is <code>null</code>.
     *                              Node union values may have <code>null</code>
     *                              contents but are never <code>null</code>
     *                              themselves.
     */
    public void setUnionForLabel(NodeUnion<? extends IdentifierNode> label) throws NullPointerException;
    
    /**
     * Gets the statement being labeled.
     * @return The statement being labeled.
     * @throws ClassCastException If the value of this property is a special node.
     */
    public StatementNode getStatement() throws ClassCastException;
    
    /**
     * Gets the union object for the statement being labeled.
     * @return A union object representing The statement being labeled.
     */
    public NodeUnion<? extends StatementNode> getUnionForStatement();
    
    /**
     * Changes the statement being labeled.
     * @param statement The statement being labeled.
     */
    public void setStatement(StatementNode statement);
    
    /**
     * Changes the statement being labeled.
     * @param statement The statement being labeled.
     * @throws NullPointerException If the provided value is <code>null</code>.
     *                              Node union values may have <code>null</code>
     *                              contents but are never <code>null</code>
     *                              themselves.
     */
    public void setUnionForStatement(NodeUnion<? extends StatementNode> statement) throws NullPointerException;
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public LabeledStatementNode deepCopy(BsjNodeFactory factory);
    
}
