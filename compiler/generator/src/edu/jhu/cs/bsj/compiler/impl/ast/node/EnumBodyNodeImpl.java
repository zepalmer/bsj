package edu.jhu.cs.bsj.compiler.impl.ast.node;

import java.util.List;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeOperation;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.BsjTypedNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.node.ClassMemberNode;
import edu.jhu.cs.bsj.compiler.ast.node.EnumBodyNode;
import edu.jhu.cs.bsj.compiler.ast.node.EnumConstantDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.ListNode;

@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class EnumBodyNodeImpl extends NodeImpl implements EnumBodyNode
{
    /** The enumeration constants. */
    private ListNode<EnumConstantDeclarationNode> constants;

    /** The members of the class body part. */
    private ListNode<ClassMemberNode> members;

    /** General constructor. */
    public EnumBodyNodeImpl(
            ListNode<EnumConstantDeclarationNode> constants,
            ListNode<ClassMemberNode> members,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        super(startLocation, stopLocation);
        setConstants(constants);
        setMembers(members);
    }

    /**
     * Gets the enumeration constants.
     * @return The enumeration constants.
     */
    public ListNode<EnumConstantDeclarationNode> getConstants()
    {
        return this.constants;
    }

    /**
     * Changes the enumeration constants.
     * @param constants The enumeration constants.
     */
    public void setConstants(ListNode<EnumConstantDeclarationNode> constants)
    {
        if (this.constants instanceof NodeImpl)
        {
            ((NodeImpl)this.constants).setParent(null);
        }
        this.constants = constants;
        if (this.constants instanceof NodeImpl)
        {
            ((NodeImpl)this.constants).setParent(this);
        }
    }

    /**
     * Gets the members of the class body part.
     * @return The members of the class body part.
     */
    public ListNode<ClassMemberNode> getMembers()
    {
        return this.members;
    }

    /**
     * Changes the members of the class body part.
     * @param members The members of the class body part.
     */
    public void setMembers(ListNode<ClassMemberNode> members)
    {
        if (this.members instanceof NodeImpl)
        {
            ((NodeImpl)this.members).setParent(null);
        }
        this.members = members;
        if (this.members instanceof NodeImpl)
        {
            ((NodeImpl)this.members).setParent(this);
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
        if (this.constants != null)
        {
            this.constants.receive(visitor);
        }
        if (this.members != null)
        {
            this.members.receive(visitor);
        }
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
        if (this.constants != null)
        {
            this.constants.receiveTyped(visitor);
        }
        if (this.members != null)
        {
            this.members.receiveTyped(visitor);
        }
    }

    @Override
    public void receiveTyped(BsjTypedNodeVisitor visitor)
    {
        visitor.visitStartBegin(this);
        visitor.visitEnumBodyNodeStart(this, true);
        visitor.visitNodeStart(this);
        visitor.visitStartEnd(this);
        receiveTypedToChildren(visitor);
        visitor.visitStopBegin(this);
        visitor.visitNodeStop(this);
        visitor.visitEnumBodyNodeStop(this, true);
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
        list.add(getConstants());
        list.add(getMembers());
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
        sb.append("constants=");
        sb.append(this.getConstants() == null? "null" : this.getConstants().getClass().getSimpleName());
        sb.append(',');
        sb.append("members=");
        sb.append(this.getMembers() == null? "null" : this.getMembers().getClass().getSimpleName());
        sb.append(',');
        sb.append("startLocation=");
        sb.append(String.valueOf(this.getStartLocation()) + ":" + (this.getStartLocation() != null ? this.getStartLocation().getClass().getSimpleName() : "null"));
        sb.append(',');
        sb.append("stopLocation=");
        sb.append(String.valueOf(this.getStopLocation()) + ":" + (this.getStopLocation() != null ? this.getStopLocation().getClass().getSimpleName() : "null"));
        sb.append(']');
        return sb.toString();
    }

    /**
     * Executes an operation on this node.
     * @param operation The operation to perform.
     * @param p The parameter to pass to the operation.
     * @return The result of the operation.
     */
    @Override
    public <P,R> R executeOperation(BsjNodeOperation<P,R> operation, P p)
    {
        return operation.executeEnumBodyNode(this, p);
    }

    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public EnumBodyNode deepCopy(BsjNodeFactory factory)
    {
        return factory.makeEnumBodyNode(
                getConstants().deepCopy(factory),
                getMembers().deepCopy(factory));
    }
}
