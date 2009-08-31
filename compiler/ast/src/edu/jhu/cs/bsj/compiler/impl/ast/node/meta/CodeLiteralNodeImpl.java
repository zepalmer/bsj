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
     * Handles the visitation of this node's children for the provided visitor.  Each
     * subclass should override this method, having the subclass implementation call this
     * method first and then visit its subclass-specific children.
     *
     * @param visitor The visitor to visit this node's children.
     */
    @Override
    protected void receiveToChildren(BsjNodeVisitor visitor)
    {
        super.receiveToChildren(visitor);
    }
}
