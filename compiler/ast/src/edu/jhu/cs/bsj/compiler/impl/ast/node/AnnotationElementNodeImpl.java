package edu.jhu.cs.bsj.compiler.impl.ast.node;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.node.AnnotationElementNode;
import edu.jhu.cs.bsj.compiler.ast.node.AnnotationValueNode;
import edu.jhu.cs.bsj.compiler.ast.node.IdentifierNode;

public class AnnotationElementNodeImpl extends NodeImpl implements AnnotationElementNode
{
    /** The identifier. */
    private IdentifierNode identifier;

    /** The element's value. */
    private AnnotationValueNode value;

    /** General constructor. */
    public AnnotationElementNodeImpl(
            IdentifierNode identifier,
            AnnotationValueNode value)
    {
        super();
        this.identifier = identifier;
        this.value = value;
    }

    /**
     * Gets the identifier.
     * @return The identifier.
     */
    public IdentifierNode getIdentifier()
    {
        return this.identifier;
    }

    /**
     * Changes the identifier.
     * @param identifier The identifier.
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
     * Gets the element's value.
     * @return The element's value.
     */
    public AnnotationValueNode getValue()
    {
        return this.value;
    }

    /**
     * Changes the element's value.
     * @param value The element's value.
     */
    public void setValue(AnnotationValueNode value)
    {
        if (this.value instanceof NodeImpl)
        {
            ((NodeImpl)this.value).setParent(null);
        }
        this.value = value;
        if (this.value instanceof NodeImpl)
        {
            ((NodeImpl)this.value).setParent(this);
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
        this.identifier.receive(visitor);
        this.value.receive(visitor);
    }
}
