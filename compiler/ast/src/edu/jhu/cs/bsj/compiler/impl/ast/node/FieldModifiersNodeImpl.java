package edu.jhu.cs.bsj.compiler.impl.ast.node;

import java.util.List;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.AccessModifier;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeOperation;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.BsjTypedNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.node.AnnotationNode;
import edu.jhu.cs.bsj.compiler.ast.node.FieldModifiersNode;
import edu.jhu.cs.bsj.compiler.ast.node.ListNode;

@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class FieldModifiersNodeImpl extends ModifiersNodeImpl implements FieldModifiersNode
{
    /** The access for the associated fields. */
    private AccessModifier access;

    /** Whether or not the associated class is static. */
    private boolean staticFlag;

    /** Whether or not the associated class is final. */
    private boolean finalFlag;

    /** Whether or not the associated class is transient. */
    private boolean transientFlag;

    /** Whether or not the associated class is volatile. */
    private boolean volatileFlag;

    /** General constructor. */
    public FieldModifiersNodeImpl(
            AccessModifier access,
            boolean staticFlag,
            boolean finalFlag,
            boolean transientFlag,
            boolean volatileFlag,
            ListNode<AnnotationNode> annotations)
    {
        super(annotations);
        this.access = access;
        this.staticFlag = staticFlag;
        this.finalFlag = finalFlag;
        this.transientFlag = transientFlag;
        this.volatileFlag = volatileFlag;
    }

    /**
     * Gets the access for the associated fields.
     * @return The access for the associated fields.
     */
    public AccessModifier getAccess()
    {
        return this.access;
    }

    /**
     * Changes the access for the associated fields.
     * @param access The access for the associated fields.
     */
    public void setAccess(AccessModifier access)
    {
        this.access = access;
    }

    /**
     * Gets whether or not the associated class is static.
     * @return Whether or not the associated class is static.
     */
    public boolean getStaticFlag()
    {
        return this.staticFlag;
    }

    /**
     * Changes whether or not the associated class is static.
     * @param staticFlag Whether or not the associated class is static.
     */
    public void setStaticFlag(boolean staticFlag)
    {
        this.staticFlag = staticFlag;
    }

    /**
     * Gets whether or not the associated class is final.
     * @return Whether or not the associated class is final.
     */
    public boolean getFinalFlag()
    {
        return this.finalFlag;
    }

    /**
     * Changes whether or not the associated class is final.
     * @param finalFlag Whether or not the associated class is final.
     */
    public void setFinalFlag(boolean finalFlag)
    {
        this.finalFlag = finalFlag;
    }

    /**
     * Gets whether or not the associated class is transient.
     * @return Whether or not the associated class is transient.
     */
    public boolean getTransientFlag()
    {
        return this.transientFlag;
    }

    /**
     * Changes whether or not the associated class is transient.
     * @param transientFlag Whether or not the associated class is transient.
     */
    public void setTransientFlag(boolean transientFlag)
    {
        this.transientFlag = transientFlag;
    }

    /**
     * Gets whether or not the associated class is volatile.
     * @return Whether or not the associated class is volatile.
     */
    public boolean getVolatileFlag()
    {
        return this.volatileFlag;
    }

    /**
     * Changes whether or not the associated class is volatile.
     * @param volatileFlag Whether or not the associated class is volatile.
     */
    public void setVolatileFlag(boolean volatileFlag)
    {
        this.volatileFlag = volatileFlag;
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
        visitor.visitFieldModifiersNodeStart(this, true);
        visitor.visitModifiersNodeStart(this);
        visitor.visitNodeStart(this);
        visitor.visitStartEnd(this);
        receiveTypedToChildren(visitor);
        visitor.visitStopBegin(this);
        visitor.visitNodeStart(this);
        visitor.visitModifiersNodeStart(this);
        visitor.visitFieldModifiersNodeStart(this, true);
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
        list.add(getFinalFlag());
        list.add(getTransientFlag());
        list.add(getVolatileFlag());
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
        sb.append("finalFlag=");
        sb.append(String.valueOf(this.finalFlag) + ":" + "boolean");
        sb.append(',');
        sb.append("transientFlag=");
        sb.append(String.valueOf(this.transientFlag) + ":" + "boolean");
        sb.append(',');
        sb.append("volatileFlag=");
        sb.append(String.valueOf(this.volatileFlag) + ":" + "boolean");
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
        return operation.executeFieldModifiersNode(this, p);
    }
}
