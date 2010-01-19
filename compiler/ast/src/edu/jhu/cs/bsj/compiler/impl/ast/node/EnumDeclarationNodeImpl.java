package edu.jhu.cs.bsj.compiler.impl.ast.node;

import java.util.List;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.BsjTypedNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.node.EnumBodyNode;
import edu.jhu.cs.bsj.compiler.ast.node.EnumDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.EnumModifiersNode;
import edu.jhu.cs.bsj.compiler.ast.node.IdentifierNode;
import edu.jhu.cs.bsj.compiler.ast.node.JavadocNode;
import edu.jhu.cs.bsj.compiler.ast.node.ListNode;
import edu.jhu.cs.bsj.compiler.ast.node.TypeNode;

@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class EnumDeclarationNodeImpl extends NamedTypeDeclarationNodeImpl implements EnumDeclarationNode
{
    /** The modifiers for this type. */
    private EnumModifiersNode modifiers;

    /** The implements clause. */
    private ListNode<TypeNode> implementsClause;

    /** This enum's body. */
    private EnumBodyNode body;

    /** General constructor. */
    public EnumDeclarationNodeImpl(
            EnumModifiersNode modifiers,
            ListNode<TypeNode> implementsClause,
            EnumBodyNode body,
            IdentifierNode identifier,
            JavadocNode javadoc)
    {
        super(identifier, javadoc);
        this.modifiers = modifiers;
        this.implementsClause = implementsClause;
        this.body = body;
    }

    /**
     * Gets the modifiers for this type.
     * @return The modifiers for this type.
     */
    public EnumModifiersNode getModifiers()
    {
        return this.modifiers;
    }

    /**
     * Changes the modifiers for this type.
     * @param modifiers The modifiers for this type.
     */
    public void setModifiers(EnumModifiersNode modifiers)
    {
        if (this.modifiers instanceof NodeImpl)
        {
            ((NodeImpl)this.modifiers).setParent(null);
        }
        this.modifiers = modifiers;
        if (this.modifiers instanceof NodeImpl)
        {
            ((NodeImpl)this.modifiers).setParent(this);
        }
    }

    /**
     * Gets the implements clause.
     * @return The implements clause.
     */
    public ListNode<TypeNode> getImplementsClause()
    {
        return this.implementsClause;
    }

    /**
     * Changes the implements clause.
     * @param implementsClause The implements clause.
     */
    public void setImplementsClause(ListNode<TypeNode> implementsClause)
    {
        if (this.implementsClause instanceof NodeImpl)
        {
            ((NodeImpl)this.implementsClause).setParent(null);
        }
        this.implementsClause = implementsClause;
        if (this.implementsClause instanceof NodeImpl)
        {
            ((NodeImpl)this.implementsClause).setParent(this);
        }
    }

    /**
     * Gets this enum's body.
     * @return This enum's body.
     */
    public EnumBodyNode getBody()
    {
        return this.body;
    }

    /**
     * Changes this enum's body.
     * @param body This enum's body.
     */
    public void setBody(EnumBodyNode body)
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
        this.modifiers.receive(visitor);
        this.implementsClause.receive(visitor);
        this.body.receive(visitor);
    }

    /**
     * Handles the visitation of this node's children for the provided typed visitor.  Each
     * subclass should override this method, having the subclass implementation call this
     * method first and then visit its subclass-specific children.
     *
     * @param visitor The visitor to visit this node's children.
     */
    @Override
    protected void receiveTypedToChildren(BsjTypedNodeVisitor visitor)
    {
        super.receiveTypedToChildren(visitor);
        this.modifiers.receiveTyped(visitor);
        this.implementsClause.receiveTyped(visitor);
        this.body.receiveTyped(visitor);
    }

    @Override
    public void receiveTyped(BsjTypedNodeVisitor visitor)
    {
        visitor.visitStartBegin(this);
        visitor.visitEnumDeclarationNodeStart(this, true);
        visitor.visitNamedTypeDeclarationNodeStart(this);
        visitor.visitNodeStart(this);
        visitor.visitInlineTypeDeclarableNodeStart(this);
        visitor.visitStartEnd(this);
        receiveTypedToChildren(visitor);
        visitor.visitStopBegin(this);
        visitor.visitInlineTypeDeclarableNodeStop(this);
        visitor.visitNodeStart(this);
        visitor.visitNamedTypeDeclarationNodeStart(this);
        visitor.visitEnumDeclarationNodeStart(this, true);
        visitor.visitStopEnd(this);
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
        list.add(getModifiers());
        list.add(getImplementsClause());
        list.add(getBody());
        list.add(getIdentifier());
        list.add(getJavadoc());
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
        sb.append("modifiers=");
        sb.append(this.modifiers == null? "null" : this.modifiers.getClass().getSimpleName());
        sb.append(',');
        sb.append("implementsClause=");
        sb.append(this.implementsClause == null? "null" : this.implementsClause.getClass().getSimpleName());
        sb.append(',');
        sb.append("body=");
        sb.append(this.body == null? "null" : this.body.getClass().getSimpleName());
        sb.append(']');
        return sb.toString();
    }
}
