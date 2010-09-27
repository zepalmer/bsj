package edu.jhu.cs.bsj.compiler.ast.node.meta;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.NodeUnion;
import edu.jhu.cs.bsj.compiler.ast.node.BsjSpecificNode;
import edu.jhu.cs.bsj.compiler.ast.node.ExpressionNode;
import edu.jhu.cs.bsj.compiler.ast.node.Node;

/**
 * This AST node interface is meant to tag nodes which represent BSJ AST splices.  Code splices are used
 * within code literals to permit the construction of templated ASTs.
 * <p/>
 * Due to the awkwardness of correctly typing this behavior in Java's type system, the BSJ API specifies
 * that any AST node may actually be a splice node.  If it is, accessing any of its normal getters or
 * setters will result in the raising of a {@link SpliceNodeAccessException}.            
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface SpliceNode extends Node, BsjSpecificNode
{
    /**
     * Gets the expression which will replace this splice upon lifting.
     * @return The expression which will replace this splice upon lifting.
     * @throws ClassCastException If the value of this property is a special node.
     */
    public ExpressionNode getSpliceExpression() throws ClassCastException;
    
    /**
     * Gets the union object for the expression which will replace this splice upon lifting.
     * @return A union object representing The expression which will replace this splice upon lifting.
     */
    public NodeUnion<? extends ExpressionNode> getUnionForSpliceExpression();
    
    /**
     * Changes the expression which will replace this splice upon lifting.
     * @param spliceExpression The expression which will replace this splice upon lifting.
     */
    public void setSpliceExpression(ExpressionNode spliceExpression);
    
    /**
     * Changes the expression which will replace this splice upon lifting.
     * @param spliceExpression The expression which will replace this splice upon lifting.
     * @throws NullPointerException If the provided value is <code>null</code>.
     *                              Node union values may have <code>null</code>
     *                              contents but are never <code>null</code>
     *                              themselves.
     */
    public void setUnionForSpliceExpression(NodeUnion<? extends ExpressionNode> spliceExpression) throws NullPointerException;
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public SpliceNode deepCopy(BsjNodeFactory factory);
    
}
