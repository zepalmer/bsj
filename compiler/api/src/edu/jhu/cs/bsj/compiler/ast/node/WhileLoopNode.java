package edu.jhu.cs.bsj.compiler.ast.node;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;

/**
 * A node for a while loop, as in:
 * <pre>
 * while (<i>condition</i>)
 *     statement
 * </pre>/
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface WhileLoopNode extends Node, StatementNode
{
    /**
     * Gets the loop's condition.
     * @return The loop's condition.
     */
    public ExpressionNode getCondition();
    
    /**
     * Changes the loop's condition.
     * @param condition The loop's condition.
     */
    public void setCondition(ExpressionNode condition);
    
    /**
     * Gets the loop's statement.
     * @return The loop's statement.
     */
    public StatementNode getStatement();
    
    /**
     * Changes the loop's statement.
     * @param statement The loop's statement.
     */
    public void setStatement(StatementNode statement);
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public WhileLoopNode deepCopy(BsjNodeFactory factory);
    
}
