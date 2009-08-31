package edu.jhu.cs.bsj.compiler.impl.ast.node;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.node.StringLiteralNode;

public class StringLiteralNodeImpl extends LiteralNodeImpl<String> implements StringLiteralNode
{
    /** General constructor. */
    public StringLiteralNodeImpl(
            String value)
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
