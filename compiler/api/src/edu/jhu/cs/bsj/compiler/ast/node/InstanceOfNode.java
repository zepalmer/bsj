package edu.jhu.cs.bsj.compiler.ast.node;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;

/**
 * Represents the invocation of the <tt>instanceof</tt> operator, as in:
 * <pre>
 * <i>expression</i> instanceof <i>type</i>
 * </pre>
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface InstanceOfNode extends Node, NonAssignmentExpressionNode
{
    /**
     * Gets the expression being evaluated.
     * @return The expression being evaluated.
     */
    public ExpressionNode getExpression();
    
    /**
     * Changes the expression being evaluated.
     * @param expression The expression being evaluated.
     */
    public void setExpression(ExpressionNode expression);
    
    /**
     * Gets the type being checked.
     * @return The type being checked.
     */
    public TypeNode getType();
    
    /**
     * Changes the type being checked.
     * @param type The type being checked.
     */
    public void setType(TypeNode type);
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public InstanceOfNode deepCopy(BsjNodeFactory factory);
}
