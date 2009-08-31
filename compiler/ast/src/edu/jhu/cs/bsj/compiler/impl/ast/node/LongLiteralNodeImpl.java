package edu.jhu.cs.bsj.compiler.impl.ast.node;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.node.LongLiteralNode;

public class LongLiteralNodeImpl extends LiteralNodeImpl<Long> implements LongLiteralNode
{
    /** General constructor. */
    public LongLiteralNodeImpl(
            Long value)
    {
        super(value);
    }

    /**
     * Performs visitation for this node's children.
     * @param visitor The visitor to visit this node's children.
     */
    @Override
    protected void receiveToChildren(BsjNodeVisitor visitor)
    {
        
    }
}
