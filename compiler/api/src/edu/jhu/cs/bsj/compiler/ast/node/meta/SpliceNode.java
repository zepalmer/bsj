package edu.jhu.cs.bsj.compiler.ast.node.meta;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
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
     */
    public ExpressionNode getSpliceExpression();
    
    /**
     * Changes the expression which will replace this splice upon lifting.
     * @param spliceExpression The expression which will replace this splice upon lifting.
     */
    public void setSpliceExpression(ExpressionNode spliceExpression);
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public SpliceNode deepCopy(BsjNodeFactory factory);
    
}
