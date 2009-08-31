package edu.jhu.cs.bsj.compiler.impl.ast.node;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.node.IdentifierNode;
import edu.jhu.cs.bsj.compiler.ast.node.MemberSelectNode;
import edu.jhu.cs.bsj.compiler.ast.node.NameNode;

public class MemberSelectNodeImpl extends NameNodeImpl implements MemberSelectNode
{
    /** The expression from which to select. */
    private NameNode expression;

    /** The identifier to select. */
    private IdentifierNode identifier;

    /** General constructor. */
    public MemberSelectNodeImpl(
            NameNode expression,
            IdentifierNode identifier)
    {
        super();
        this.expression = expression;
        this.identifier = identifier;
    }

    /**
     * Gets the expression from which to select.
     * @return The expression from which to select.
     */
    public NameNode getExpression()
    {
        return this.expression;
    }

    /**
     * Changes the expression from which to select.
     * @param expression The expression from which to select.
     */
    public void setExpression(NameNode expression)
    {
        if (this.expression instanceof NodeImpl)
        {
            ((NodeImpl)this.expression).setParent(null);
        }
        this.expression = expression;
        if (this.expression instanceof NodeImpl)
        {
            ((NodeImpl)this.expression).setParent(this);
        }
    }

    /**
     * Gets the identifier to select.
     * @return The identifier to select.
     */
    public IdentifierNode getIdentifier()
    {
        return this.identifier;
    }

    /**
     * Changes the identifier to select.
     * @param identifier The identifier to select.
     */
    public void setIdentifier(IdentifierNode identifier)
    {
        if (this.identifier instanceof NodeImpl)
        {
            ((NodeImpl)this.identifier).setParent(null);
        }
        this.identifier = identifier;
        if (this.identifier instanceof NodeImpl)
        {
            ((NodeImpl)this.identifier).setParent(this);
        }
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
