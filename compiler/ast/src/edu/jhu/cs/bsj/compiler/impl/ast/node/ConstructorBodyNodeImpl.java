package edu.jhu.cs.bsj.compiler.impl.ast.node;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.node.ConstructorBodyNode;
import edu.jhu.cs.bsj.compiler.ast.node.ConstructorInvocationNode;
import edu.jhu.cs.bsj.compiler.ast.node.ListNode;
import edu.jhu.cs.bsj.compiler.ast.node.StatementNode;

public class ConstructorBodyNodeImpl extends NodeImpl implements ConstructorBodyNode
{
    /** The (nullable) constructor invocation. */
    private ConstructorInvocationNode constructorInvocation;

    /** The statements contained in this constructor. */
    private ListNode<? extends StatementNode> statements;

    /** General constructor. */
    public ConstructorBodyNodeImpl(
            ConstructorInvocationNode constructorInvocation,
            ListNode<? extends StatementNode> statements)
    {
        super();
        this.constructorInvocation = constructorInvocation;
        this.statements = statements;
    }

    /**
     * Gets the (nullable) constructor invocation.
     * @return The (nullable) constructor invocation.
     */
    public ConstructorInvocationNode getConstructorInvocation()
    {
        return this.constructorInvocation;
    }

    /**
     * Changes the (nullable) constructor invocation.
     * @param constructorInvocation The (nullable) constructor invocation.
     */
    public void setConstructorInvocation(ConstructorInvocationNode constructorInvocation)
    {
        if (this.constructorInvocation instanceof NodeImpl)
        {
            ((NodeImpl)this.constructorInvocation).setParent(null);
        }
        this.constructorInvocation = constructorInvocation;
        if (this.constructorInvocation instanceof NodeImpl)
        {
            ((NodeImpl)this.constructorInvocation).setParent(this);
        }
    }

    /**
     * Gets the statements contained in this constructor.
     * @return The statements contained in this constructor.
     */
    public ListNode<? extends StatementNode> getStatements()
    {
        return this.statements;
    }

    /**
     * Changes the statements contained in this constructor.
     * @param statements The statements contained in this constructor.
     */
    public void setStatements(ListNode<? extends StatementNode> statements)
    {
        if (this.statements instanceof NodeImpl)
        {
            ((NodeImpl)this.statements).setParent(null);
        }
        this.statements = statements;
        if (this.statements instanceof NodeImpl)
        {
            ((NodeImpl)this.statements).setParent(this);
        }
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
        this.constructorInvocation.receive(visitor);
        this.statements.receive(visitor);
    }
}
