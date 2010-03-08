package edu.jhu.cs.bsj.compiler.ast.node;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;

/**
 * Represents a field access, as in
 * <pre>
 * <i>expr</i>.<i>ident</i>
 * </pre>
 * For example, this node would allow the access of a fieldon the result of a method call using the code
 * <pre>
 * foo().bar
 * </pre>
 * This node is not used for simple expressions such as <tt>x</tt> or <tt>y.z</tt>.  For those forms of field
 * access, see {@link FieldAccessByNameNode}.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface FieldAccessByExpressionNode extends Node, FieldAccessNode
{
    /**
     * Gets the expression from which the field is being selected.
     * @return The expression from which the field is being selected.
     */
    public PrimaryExpressionNode getExpression();
    
    /**
     * Changes the expression from which the field is being selected.
     * @param expression The expression from which the field is being selected.
     */
    public void setExpression(PrimaryExpressionNode expression);
    
    /**
     * Gets the name of the field.
     * @return The name of the field.
     */
    public IdentifierNode getIdentifier();
    
    /**
     * Changes the name of the field.
     * @param identifier The name of the field.
     */
    public void setIdentifier(IdentifierNode identifier);
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public FieldAccessByExpressionNode deepCopy(BsjNodeFactory factory);
}
