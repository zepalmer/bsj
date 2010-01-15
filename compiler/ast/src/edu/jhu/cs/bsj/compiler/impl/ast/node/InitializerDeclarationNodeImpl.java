package edu.jhu.cs.bsj.compiler.impl.ast.node;

import java.util.List;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.node.BlockStatementNode;
import edu.jhu.cs.bsj.compiler.ast.node.InitializerDeclarationNode;

@Generated(value={"edu.jhu.cs.bsj.compiler.utils.SourceGenerator"})
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

    /**
     * Produces a mutable list of this node's children.  Modifying this list will have no
     * effect on this node.
     * @return A list of this node's children.
     */
    @Override
    public List<Object> getChildObjects()
    {
        List<Object> list = super.getChildObjects();
        list.add(this.staticInitializer);
        list.add(this.body);
        return list;
    }

    /**
     * Obtains a human-readable description of this node.
     * @return A human-readable description of this node.
     */
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getClass().getSimpleName());
        sb.append('[');
        sb.append("staticInitializer=");
        sb.append(String.valueOf(this.staticInitializer) + ":" + "boolean");
        sb.append(',');
        sb.append("body=");
        sb.append(this.body == null? "null" : this.body.getClass().getSimpleName());
        sb.append(']');
        return sb.toString();
    }
}
