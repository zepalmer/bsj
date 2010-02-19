package edu.jhu.cs.bsj.compiler.impl.ast.node;

import java.util.List;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.AccessModifier;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeOperation;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.BsjTypedNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.node.AnnotationListNode;
import edu.jhu.cs.bsj.compiler.ast.node.FieldModifiersNode;
import edu.jhu.cs.bsj.compiler.ast.node.Node;

@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class FieldModifiersNodeImpl extends ModifiersNodeImpl implements FieldModifiersNode
{
    /** The access for the associated fields. */
    private AccessModifier access;

    /** Whether or not the associated field is static. */
    private boolean staticFlag;

    /** Whether or not the associated field is final. */
    private boolean finalFlag;

    /** Whether or not the associated field is transient. */
    private boolean transientFlag;

    /** Whether or not the associated field is volatile. */
    private boolean volatileFlag;

    /** General constructor. */
    public FieldModifiersNodeImpl(
            AccessModifier access,
            boolean staticFlag,
            boolean finalFlag,
            boolean transientFlag,
            boolean volatileFlag,
            AnnotationListNode annotations,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        super(annotations, startLocation, stopLocation);
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
     * Gets whether or not the associated field is static.
     * @return Whether or not the associated field is static.
     */
    public boolean getStaticFlag()
    {
        return this.staticFlag;
    }

    /**
     * Changes whether or not the associated field is static.
     * @param staticFlag Whether or not the associated field is static.
     */
    public void setStaticFlag(boolean staticFlag)
    {
        this.staticFlag = staticFlag;
    }

    /**
     * Gets whether or not the associated field is final.
     * @return Whether or not the associated field is final.
     */
    public boolean getFinalFlag()
    {
        return this.finalFlag;
    }

    /**
     * Changes whether or not the associated field is final.
     * @param finalFlag Whether or not the associated field is final.
     */
    public void setFinalFlag(boolean finalFlag)
    {
        this.finalFlag = finalFlag;
    }

    /**
     * Gets whether or not the associated field is transient.
     * @return Whether or not the associated field is transient.
     */
    public boolean getTransientFlag()
    {
        return this.transientFlag;
    }

    /**
     * Changes whether or not the associated field is transient.
     * @param transientFlag Whether or not the associated field is transient.
     */
    public void setTransientFlag(boolean transientFlag)
    {
        this.transientFlag = transientFlag;
    }

    /**
     * Gets whether or not the associated field is volatile.
     * @return Whether or not the associated field is volatile.
     */
    public boolean getVolatileFlag()
    {
        return this.volatileFlag;
    }

    /**
     * Changes whether or not the associated field is volatile.
     * @param volatileFlag Whether or not the associated field is volatile.
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
        visitor.visitNodeStop(this);
        visitor.visitModifiersNodeStop(this);
        visitor.visitFieldModifiersNodeStop(this, true);
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
        sb.append(String.valueOf(this.getAccess()) + ":" + (this.getAccess() != null ? this.getAccess().getClass().getSimpleName() : "null"));
        sb.append(',');
        sb.append("staticFlag=");
        sb.append(String.valueOf(this.getStaticFlag()) + ":" + ("boolean"));
        sb.append(',');
        sb.append("finalFlag=");
        sb.append(String.valueOf(this.getFinalFlag()) + ":" + ("boolean"));
        sb.append(',');
        sb.append("transientFlag=");
        sb.append(String.valueOf(this.getTransientFlag()) + ":" + ("boolean"));
        sb.append(',');
        sb.append("volatileFlag=");
        sb.append(String.valueOf(this.getVolatileFlag()) + ":" + ("boolean"));
        sb.append(',');
        sb.append("annotations=");
        sb.append(this.getAnnotations() == null? "null" : this.getAnnotations().getClass().getSimpleName());
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
        return operation.executeFieldModifiersNode(this, p);
    }

    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public FieldModifiersNode deepCopy(BsjNodeFactory factory)
    {
        return factory.makeFieldModifiersNode(
                getAccess(),
                getStaticFlag(),
                getFinalFlag(),
                getTransientFlag(),
                getVolatileFlag(),
                getAnnotations().deepCopy(factory),
                getStartLocation() == null ? null : (BsjSourceLocation)(getStartLocation().clone()),
                getStopLocation() == null ? null : (BsjSourceLocation)(getStopLocation().clone()));
    }
    /**
     * Performs replacement for this node.
     * @param before The node to replace.
     * @param after The node to replace the <tt>before</tt> node.
     * @return <code>true</code> if the replacement was successful; <code>false</code> if the
     *         specified <tt>before</tt> node is not a child of this node.
     */
    public boolean replace(Node before, Node after)
    {
        if (before==null)
            throw new IllegalArgumentException("Cannot replace node with before value of null.");
        
        if (before.equals(this.getAnnotations()) && (after instanceof AnnotationListNode))
        {
            setAnnotations((AnnotationListNode)after);
            return true;
        }
        return false;
    }
    
}
