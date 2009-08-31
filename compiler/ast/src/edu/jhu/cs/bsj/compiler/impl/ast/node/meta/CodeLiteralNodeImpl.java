package edu.jhu.cs.bsj.compiler.impl.ast.node.meta;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.meta.CodeLiteralNode;
import edu.jhu.cs.bsj.compiler.impl.ast.node.LiteralNodeImpl;

public class CodeLiteralNodeImpl extends LiteralNodeImpl<Node> implements CodeLiteralNode
{
    /** General constructor. */
    public CodeLiteralNodeImpl(
            Node value)
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
