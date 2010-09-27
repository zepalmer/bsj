package edu.jhu.cs.bsj.compiler.ast.node;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.NodeUnion;
import edu.jhu.cs.bsj.compiler.ast.node.list.StatementExpressionListNode;

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
     * @throws ClassCastException If the value of this property is a special node.
     */
    public StatementExpressionListNode getExpressions() throws ClassCastException;
    
    /**
     * Gets the union object for the expressions used in this initializer.
     * @return A union object representing The expressions used in this initializer.
     */
    public NodeUnion<? extends StatementExpressionListNode> getUnionForExpressions();
    
    /**
     * Changes the expressions used in this initializer.
     * @param expressions The expressions used in this initializer.
     */
    public void setExpressions(StatementExpressionListNode expressions);
    
    /**
     * Changes the expressions used in this initializer.
     * @param expressions The expressions used in this initializer.
     * @throws NullPointerException If the provided value is <code>null</code>.
     *                              Node union values may have <code>null</code>
     *                              contents but are never <code>null</code>
     *                              themselves.
     */
    public void setUnionForExpressions(NodeUnion<? extends StatementExpressionListNode> expressions) throws NullPointerException;
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public ForInitializerExpressionNode deepCopy(BsjNodeFactory factory);
    
}
