package edu.jhu.cs.bsj.compiler.ast.node;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.NodeUnion;

/**
 * Represents a field access, as in
 * <pre>
 * <i>ident</i>
 * </pre>
 * or
 * <pre>
 * <i>expr</i>.<i>ident</i>
 * </pre>
 * For example, this node would allow the access of a field on the result of a method call using the code
 * <pre>
 * foo().bar
 * </pre>
 * If the expression represents the access of a simple identifier name, the <tt>expression</tt> child node
 * is <tt>null</tt>.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface VariableAccessNode extends Node, RestrictedPrimaryExpressionNode
{
    /**
     * Gets the expression from which the variable is being selected.
     * @return The expression from which the variable is being selected.
     * @throws ClassCastException If the value of this property is a special node.
     */
    public PrimaryExpressionNode getExpression()throws ClassCastException;
    
    /**
     * Gets the union object for the expression from which the variable is being selected.
     * @return A union object representing The expression from which the variable is being selected.
     */
    public NodeUnion<? extends PrimaryExpressionNode> getUnionForExpression();
    
    /**
     * Changes the expression from which the variable is being selected.
     * @param expression The expression from which the variable is being selected.
     */
    public void setExpression(PrimaryExpressionNode expression);
    
    /**
     * Changes the expression from which the variable is being selected.
     * @param expression The expression from which the variable is being selected.
     * @throws NullPointerException If the provided value is <code>null</code>.
     *                              Node union values may have <code>null</code>
     *                              contents but are never <code>null</code>
     *                              themselves.
     */
    public void setUnionForExpression(NodeUnion<? extends PrimaryExpressionNode> expression) throws NullPointerException;
    
    /**
     * Gets the name of the variable.
     * @return The name of the variable.
     * @throws ClassCastException If the value of this property is a special node.
     */
    public IdentifierNode getIdentifier()throws ClassCastException;
    
    /**
     * Gets the union object for the name of the variable.
     * @return A union object representing The name of the variable.
     */
    public NodeUnion<? extends IdentifierNode> getUnionForIdentifier();
    
    /**
     * Changes the name of the variable.
     * @param identifier The name of the variable.
     */
    public void setIdentifier(IdentifierNode identifier);
    
    /**
     * Changes the name of the variable.
     * @param identifier The name of the variable.
     * @throws NullPointerException If the provided value is <code>null</code>.
     *                              Node union values may have <code>null</code>
     *                              contents but are never <code>null</code>
     *                              themselves.
     */
    public void setUnionForIdentifier(NodeUnion<? extends IdentifierNode> identifier) throws NullPointerException;
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public VariableAccessNode deepCopy(BsjNodeFactory factory);
    
}
