package edu.jhu.cs.bsj.compiler.impl.ast.node;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.node.ContinueNode;
import edu.jhu.cs.bsj.compiler.ast.node.IdentifierNode;

public class ContinueNodeImpl extends StatementNodeImpl implements ContinueNode
{
    /** The continue label. */
    private IdentifierNode label;

    /** General constructor. */
    public ContinueNodeImpl(
            IdentifierNode label)
    {
        super();
        this.label = label;
    }

    /**
     * Gets the continue label.
     * @return The continue label.
     */
    public IdentifierNode getLabel()
    {
        return this.label;
    }

    /**
     * Changes the continue label.
     * @param label The continue label.
     */
    public void setLabel(IdentifierNode label)
    {
        this.label = label;
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
