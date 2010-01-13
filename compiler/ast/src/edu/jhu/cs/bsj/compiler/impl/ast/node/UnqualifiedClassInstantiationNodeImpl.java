package edu.jhu.cs.bsj.compiler.impl.ast.node;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.node.AnonymousClassBodyNode;
import edu.jhu.cs.bsj.compiler.ast.node.DeclaredTypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.ExpressionNode;
import edu.jhu.cs.bsj.compiler.ast.node.ListNode;
import edu.jhu.cs.bsj.compiler.ast.node.TypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.UnqualifiedClassInstantiationNode;

public class UnqualifiedClassInstantiationNodeImpl extends ClassInstantiationNodeImpl implements UnqualifiedClassInstantiationNode
{
    /** The type being instantiated. */
    private DeclaredTypeNode type;

    /** General constructor. */
    public UnqualifiedClassInstantiationNodeImpl(
            DeclaredTypeNode type,
            ListNode<TypeNode> constructorTypeArguments,
            ListNode<ExpressionNode> arguments,
            AnonymousClassBodyNode body)
    {
        super(constructorTypeArguments, arguments, body);
        this.type = type;
    }

    /**
     * Gets the type being instantiated.
     * @return The type being instantiated.
     */
    public DeclaredTypeNode getType()
    {
        return this.type;
    }

    /**
     * Changes the type being instantiated.
     * @param type The type being instantiated.
     */
    public void setType(DeclaredTypeNode type)
    {
        if (this.type instanceof NodeImpl)
        {
            ((NodeImpl)this.type).setParent(null);
        }
        this.type = type;
        if (this.type instanceof NodeImpl)
        {
            ((NodeImpl)this.type).setParent(this);
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
        this.type.receive(visitor);
    }
}
