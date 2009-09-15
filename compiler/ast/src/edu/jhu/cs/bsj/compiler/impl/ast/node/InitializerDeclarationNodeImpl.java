package edu.jhu.cs.bsj.compiler.impl.ast.node;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.node.BlockStatementNode;
import edu.jhu.cs.bsj.compiler.ast.node.InitializerDeclarationNode;

public class InitializerDeclarationNodeImpl extends NodeImpl implements InitializerDeclarationNode
{
    /** Whether or not the initializer is static. */
    private boolean staticInitializer;

    /** The body of the initializer. */
    private BlockStatementNode body;

    /** General constructor. */
    public InitializerDeclarationNodeImpl(
            boolean staticInitializer,
            BlockStatementNode body)
    {
        super();
        this.staticInitializer = staticInitializer;
        this.body = body;
    }

    /**
     * Gets whether or not the initializer is static.
     * @return Whether or not the initializer is static.
     */
    public boolean getStaticInitializer()
    {
        return this.staticInitializer;
    }

    /**
     * Changes whether or not the initializer is static.
     * @param staticInitializer Whether or not the initializer is static.
     */
    public void setStaticInitializer(boolean staticInitializer)
    {
        this.staticInitializer = staticInitializer;
    }

    /**
     * Gets the body of the initializer.
     * @return The body of the initializer.
     */
    public BlockStatementNode getBody()
    {
        return this.body;
    }

    /**
     * Changes the body of the initializer.
     * @param body The body of the initializer.
     */
    public void setBody(BlockStatementNode body)
    {
        if (this.body instanceof NodeImpl)
        {
            ((NodeImpl)this.body).setParent(null);
        }
        this.body = body;
        if (this.body instanceof NodeImpl)
        {
            ((NodeImpl)this.body).setParent(this);
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
        this.body.receive(visitor);
    }
}