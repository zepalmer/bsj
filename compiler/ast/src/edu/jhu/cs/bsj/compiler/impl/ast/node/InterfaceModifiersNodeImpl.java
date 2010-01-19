package edu.jhu.cs.bsj.compiler.impl.ast.node;

import java.util.List;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.AccessModifier;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeOperation;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.BsjTypedNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.node.AnnotationNode;
import edu.jhu.cs.bsj.compiler.ast.node.InterfaceModifiersNode;
import edu.jhu.cs.bsj.compiler.ast.node.ListNode;

@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class InterfaceModifiersNodeImpl extends ModifiersNodeImpl implements InterfaceModifiersNode
{
    /** The access for the associated interface. */
    private AccessModifier access;

    /** Whether or not the associated interface is static. */
    private boolean staticFlag;

    /** Whether or not the associated interface uses strict floating-point. */
    private boolean strictfpFlag;

    /** General constructor. */
    public InterfaceModifiersNodeImpl(
            AccessModifier access,
            boolean staticFlag,
            boolean strictfpFlag,
            ListNode<AnnotationNode> annotations)
    {
        super(annotations);
        this.access = access;
        this.staticFlag = staticFlag;
        this.strictfpFlag = strictfpFlag;
    }

    /**
     * Gets the access for the associated interface.
     * @return The access for the associated interface.
     */
    public AccessModifier getAccess()
    {
        return this.access;
    }

    /**
     * Changes the access for the associated interface.
     * @param access The access for the associated interface.
     */
    public void setAccess(AccessModifier access)
    {
        this.access = access;
    }

    /**
     * Gets whether or not the associated interface is static.
     * @return Whether or not the associated interface is static.
     */
    public boolean getStaticFlag()
    {
        return this.staticFlag;
    }

    /**
     * Changes whether or not the associated interface is static.
     * @param staticFlag Whether or not the associated interface is static.
     */
    public void setStaticFlag(boolean staticFlag)
    {
        this.staticFlag = staticFlag;
    }

    /**
     * Gets whether or not the associated interface uses strict floating-point.
     * @return Whether or not the associated interface uses strict floating-point.
     */
    public boolean getStrictfpFlag()
    {
        return this.strictfpFlag;
    }

    /**
     * Changes whether or not the associated interface uses strict floating-point.
     * @param strictfpFlag Whether or not the associated interface uses strict floating-point.
     */
    public void setStrictfpFlag(boolean strictfpFlag)
    {
        this.strictfpFlag = strictfpFlag;
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
    }

    @Override
    public void receiveTyped(BsjTypedNodeVisitor visitor)
    {
        visitor.visitStartBegin(this);
        visitor.visitInterfaceModifiersNodeStart(this, true);
        visitor.visitModifiersNodeStart(this);
        visitor.visitNodeStart(this);
        visitor.visitStartEnd(this);
        receiveTypedToChildren(visitor);
        visitor.visitStopBegin(this);
        visitor.visitNodeStart(this);
        visitor.visitModifiersNodeStart(this);
        visitor.visitInterfaceModifiersNodeStart(this, true);
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
        list.add(getAccess());
        list.add(getStaticFlag());
        list.add(getStrictfpFlag());
        list.add(getAnnotations());
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
        sb.append("access=");
        sb.append(String.valueOf(this.access) + ":" + this.access.getClass().getSimpleName());
        sb.append(',');
        sb.append("staticFlag=");
        sb.append(String.valueOf(this.staticFlag) + ":" + "boolean");
        sb.append(',');
        sb.append("strictfpFlag=");
        sb.append(String.valueOf(this.strictfpFlag) + ":" + "boolean");
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
        return operation.executeInterfaceModifiersNode(this, p);
    }
}
