package edu.jhu.cs.bsj.compiler.ast.node;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;

/**
 * Represents a for loop initializer which contains expressions.  For example, in
 * <pre>for (i=0,j=0;i&lt;n || j&lt;m;i++,j++)</pre>
 * this node represents
 * <pre>i=0,j=0</pre>
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface ForInitializerExpressionNode extends Node, ForInitializerNode
{
    /**
     * Gets the expressions used in this initializer.
     * @return The expressions used in this initializer.
     */
    public StatementExpressionListNode getExpressions();
    
    /**
     * Changes the expressions used in this initializer.
     * @param expressions The expressions used in this initializer.
     */
    public void setExpressions(StatementExpressionListNode expressions);
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public ForInitializerExpressionNode deepCopy(BsjNodeFactory factory);
}
