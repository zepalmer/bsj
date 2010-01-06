package edu.jhu.cs.bsj.compiler.impl.ast.node;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.node.AnnotationBodyNode;
import edu.jhu.cs.bsj.compiler.ast.node.AnnotationDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.IdentifierNode;
import edu.jhu.cs.bsj.compiler.ast.node.ModifiersNode;

public class AnnotationDeclarationNodeImpl extends NamedTypeDeclarationNodeImpl implements AnnotationDeclarationNode
{
    /** This annotation's body. */
    private AnnotationBodyNode body;

    /** General constructor. */
    public AnnotationDeclarationNodeImpl(
            AnnotationBodyNode body,
            IdentifierNode simpleName,
            ModifiersNode modifiers)
    {
        super(simpleName, modifiers);
        this.body = body;
    }

    /**
     * Gets this annotation's body.
     * @return This annotation's body.
     */
    public AnnotationBodyNode getBody()
    {
        return this.body;
    }

    /**
     * Changes this annotation's body.
     * @param body This annotation's body.
     */
    public void setBody(AnnotationBodyNode body)
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
