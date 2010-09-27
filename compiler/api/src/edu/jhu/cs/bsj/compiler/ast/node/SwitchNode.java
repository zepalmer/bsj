package edu.jhu.cs.bsj.compiler.ast.node;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.NodeUnion;
import edu.jhu.cs.bsj.compiler.ast.node.list.CaseListNode;

/**
 * A node to represent switch statements, as in:
 * <pre>
 * switch (<i>expr</i>) {
 *     case <i>value</i>:
 *     ...
 * }
 * </pre>
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface SwitchNode extends Node, StatementNode
{
    /**
     * Gets the expression over which to switch.
     * @return The expression over which to switch.
     * @throws ClassCastException If the value of this property is a special node.
     */
    public ExpressionNode getExpression() throws ClassCastException;
    
    /**
     * Gets the union object for the expression over which to switch.
     * @return A union object representing The expression over which to switch.
     */
    public NodeUnion<? extends ExpressionNode> getUnionForExpression();
    
    /**
     * Changes the expression over which to switch.
     * @param expression The expression over which to switch.
     */
    public void setExpression(ExpressionNode expression);
    
    /**
     * Changes the expression over which to switch.
     * @param expression The expression over which to switch.
     * @throws NullPointerException If the provided value is <code>null</code>.
     *                              Node union values may have <code>null</code>
     *                              contents but are never <code>null</code>
     *                              themselves.
     */
    public void setUnionForExpression(NodeUnion<? extends ExpressionNode> expression) throws NullPointerException;
    
    /**
     * Gets the cases in this switch.
     * @return The cases in this switch.
     * @throws ClassCastException If the value of this property is a special node.
     */
    public CaseListNode getCases() throws ClassCastException;
    
    /**
     * Gets the union object for the cases in this switch.
     * @return A union object representing The cases in this switch.
     */
    public NodeUnion<? extends CaseListNode> getUnionForCases();
    
    /**
     * Changes the cases in this switch.
     * @param cases The cases in this switch.
     */
    public void setCases(CaseListNode cases);
    
    /**
     * Changes the cases in this switch.
     * @param cases The cases in this switch.
     * @throws NullPointerException If the provided value is <code>null</code>.
     *                              Node union values may have <code>null</code>
     *                              contents but are never <code>null</code>
     *                              themselves.
     */
    public void setUnionForCases(NodeUnion<? extends CaseListNode> cases) throws NullPointerException;
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public SwitchNode deepCopy(BsjNodeFactory factory);
    
}
