package edu.jhu.cs.bsj.compiler.impl.ast.node;

import java.util.List;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.BsjTypedNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.node.FieldDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.ListNode;
import edu.jhu.cs.bsj.compiler.ast.node.ModifiersNode;
import edu.jhu.cs.bsj.compiler.ast.node.VariableDeclaratorNode;

@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class FieldDeclarationNodeImpl extends NodeImpl implements FieldDeclarationNode
{
    /** The modifiers for this field. */
    private ModifiersNode modifiers;

    /** The variable declarators for this node. */
    private ListNode<VariableDeclaratorNode> declarators;

    /** General constructor. */
    public FieldDeclarationNodeImpl(
            ModifiersNode modifiers,
            ListNode<VariableDeclaratorNode> declarators)
    {
        super();
        this.modifiers = modifiers;
        this.declarators = declarators;
    }

    /**
     * Gets the modifiers for this field.
     * @return The modifiers for this field.
     */
    public ModifiersNode getModifiers()
    {
        return this.modifiers;
    }

    /**
     * Changes the modifiers for this field.
     * @param modifiers The modifiers for this field.
     */
    public void setModifiers(ModifiersNode modifiers)
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
     * Gets the variable declarators for this node.
     * @return The variable declarators for this node.
     */
    public ListNode<VariableDeclaratorNode> getDeclarators()
    {
        return this.declarators;
    }

    /**
     * Changes the variable declarators for this node.
     * @param declarators The variable declarators for this node.
     */
    public void setDeclarators(ListNode<VariableDeclaratorNode> declarators)
    {
        if (this.declarators instanceof NodeImpl)
        {
            ((NodeImpl)this.declarators).setParent(null);
        }
        this.declarators = declarators;
        if (this.declarators instanceof NodeImpl)
        {
            ((NodeImpl)this.declarators).setParent(this);
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
        this.declarators.receive(visitor);
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
        this.declarators.receiveTyped(visitor);
    }

    @Override
    public void receiveTyped(BsjTypedNodeVisitor visitor)
    {
        visitor.visitStartBegin(this);
        visitor.visitFieldDeclarationNodeStart(this, true);
        visitor.visitNodeStart(this);
        visitor.visitClassMemberNodeStart(this);
        visitor.visitInterfaceMemberNodeStart(this);
        visitor.visitAnnotationMemberNodeStart(this);
        visitor.visitAnonymousClassMemberNodeStart(this);
        visitor.visitStartEnd(this);
        receiveTypedToChildren(visitor);
        visitor.visitStopBegin(this);
        visitor.visitClassMemberNodeStop(this);
        visitor.visitInterfaceMemberNodeStop(this);
        visitor.visitAnnotationMemberNodeStop(this);
        visitor.visitAnonymousClassMemberNodeStop(this);
        visitor.visitNodeStart(this);
        visitor.visitFieldDeclarationNodeStart(this, true);
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
        list.add(this.modifiers);
        list.add(this.declarators);
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
        sb.append("declarators=");
        sb.append(this.declarators == null? "null" : this.declarators.getClass().getSimpleName());
        sb.append(']');
        return sb.toString();
    }
}
