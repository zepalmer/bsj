package edu.jhu.cs.bsj.compiler.impl.ast.node;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.AccessModifier;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeOperation;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeOperation2Arguments;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.BsjTypedNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.node.FieldModifiersNode;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.list.AnnotationListNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaAnnotationListNode;
import edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeManager;
import edu.jhu.cs.bsj.compiler.impl.ast.attribute.ReadWriteAttribute;

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
    
    private Map<LocalAttribute,ReadWriteAttribute> localAttributes = new EnumMap<LocalAttribute,ReadWriteAttribute>(LocalAttribute.class);
    private ReadWriteAttribute getAttribute(LocalAttribute attributeName)
    {
        ReadWriteAttribute attribute = localAttributes.get(attributeName);
        if (attribute == null)
        {
            attribute = new ReadWriteAttribute(FieldModifiersNodeImpl.this);
            localAttributes.put(attributeName, attribute);
        }
        return attribute;
    }
    private static enum LocalAttribute
    {
        /** Attribute identifier for the access property. */
        ACCESS,
        /** Attribute identifier for the staticFlag property. */
        STATIC_FLAG,
        /** Attribute identifier for the finalFlag property. */
        FINAL_FLAG,
        /** Attribute identifier for the transientFlag property. */
        TRANSIENT_FLAG,
        /** Attribute identifier for the volatileFlag property. */
        VOLATILE_FLAG,
    }
    
    /** General constructor. */
    public FieldModifiersNodeImpl(
            AccessModifier access,
            boolean staticFlag,
            boolean finalFlag,
            boolean transientFlag,
            boolean volatileFlag,
            MetaAnnotationListNode metaAnnotations,
            AnnotationListNode annotations,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation,
            BsjNodeManager manager,
            boolean binary)
    {
        super(metaAnnotations, annotations, startLocation, stopLocation, manager, binary);
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
        getAttribute(LocalAttribute.ACCESS).recordAccess(ReadWriteAttribute.AccessType.READ);
        return this.access;
    }
    
    /**
     * Changes the access for the associated fields.
     * @param access The access for the associated fields.
     */
    public void setAccess(AccessModifier access)
    {
            setAccess(access, true);
    }
    
    private void setAccess(AccessModifier access, boolean checkPermissions)
    {
        if (checkPermissions)
        {
            getManager().assertMutatable(this);
            getAttribute(LocalAttribute.ACCESS).recordAccess(ReadWriteAttribute.AccessType.WRITE);
        }
        this.access = access;
    }
    
    /**
     * Gets whether or not the associated field is static.
     * @return Whether or not the associated field is static.
     */
    public boolean getStaticFlag()
    {
        getAttribute(LocalAttribute.STATIC_FLAG).recordAccess(ReadWriteAttribute.AccessType.READ);
        return this.staticFlag;
    }
    
    /**
     * Changes whether or not the associated field is static.
     * @param staticFlag Whether or not the associated field is static.
     */
    public void setStaticFlag(boolean staticFlag)
    {
            setStaticFlag(staticFlag, true);
    }
    
    private void setStaticFlag(boolean staticFlag, boolean checkPermissions)
    {
        if (checkPermissions)
        {
            getManager().assertMutatable(this);
            getAttribute(LocalAttribute.STATIC_FLAG).recordAccess(ReadWriteAttribute.AccessType.WRITE);
        }
        this.staticFlag = staticFlag;
    }
    
    /**
     * Gets whether or not the associated field is final.
     * @return Whether or not the associated field is final.
     */
    public boolean getFinalFlag()
    {
        getAttribute(LocalAttribute.FINAL_FLAG).recordAccess(ReadWriteAttribute.AccessType.READ);
        return this.finalFlag;
    }
    
    /**
     * Changes whether or not the associated field is final.
     * @param finalFlag Whether or not the associated field is final.
     */
    public void setFinalFlag(boolean finalFlag)
    {
            setFinalFlag(finalFlag, true);
    }
    
    private void setFinalFlag(boolean finalFlag, boolean checkPermissions)
    {
        if (checkPermissions)
        {
            getManager().assertMutatable(this);
            getAttribute(LocalAttribute.FINAL_FLAG).recordAccess(ReadWriteAttribute.AccessType.WRITE);
        }
        this.finalFlag = finalFlag;
    }
    
    /**
     * Gets whether or not the associated field is transient.
     * @return Whether or not the associated field is transient.
     */
    public boolean getTransientFlag()
    {
        getAttribute(LocalAttribute.TRANSIENT_FLAG).recordAccess(ReadWriteAttribute.AccessType.READ);
        return this.transientFlag;
    }
    
    /**
     * Changes whether or not the associated field is transient.
     * @param transientFlag Whether or not the associated field is transient.
     */
    public void setTransientFlag(boolean transientFlag)
    {
            setTransientFlag(transientFlag, true);
    }
    
    private void setTransientFlag(boolean transientFlag, boolean checkPermissions)
    {
        if (checkPermissions)
        {
            getManager().assertMutatable(this);
            getAttribute(LocalAttribute.TRANSIENT_FLAG).recordAccess(ReadWriteAttribute.AccessType.WRITE);
        }
        this.transientFlag = transientFlag;
    }
    
    /**
     * Gets whether or not the associated field is volatile.
     * @return Whether or not the associated field is volatile.
     */
    public boolean getVolatileFlag()
    {
        getAttribute(LocalAttribute.VOLATILE_FLAG).recordAccess(ReadWriteAttribute.AccessType.READ);
        return this.volatileFlag;
    }
    
    /**
     * Changes whether or not the associated field is volatile.
     * @param volatileFlag Whether or not the associated field is volatile.
     */
    public void setVolatileFlag(boolean volatileFlag)
    {
            setVolatileFlag(volatileFlag, true);
    }
    
    private void setVolatileFlag(boolean volatileFlag, boolean checkPermissions)
    {
        if (checkPermissions)
        {
            getManager().assertMutatable(this);
            getAttribute(LocalAttribute.VOLATILE_FLAG).recordAccess(ReadWriteAttribute.AccessType.WRITE);
        }
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
        Iterator<? extends Node> extras = getHiddenVisitorChildren();
        if (extras != null)
        {
            while (extras.hasNext())
            {
                extras.next().receive(visitor);
            }
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
        Iterator<? extends Node> extras = getHiddenVisitorChildren();
        if (extras != null)
        {
            while (extras.hasNext())
            {
                extras.next().receiveTyped(visitor);
            }
        }
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
     * Returns an iterator over the children of this node.
     * @see Node#getChildIterator()
     */
    @Override
    public Iterable<? extends Node> getChildIterable()
    {
        return Arrays.asList(new Node[]{getMetaAnnotations(), getAnnotations()});
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
        sb.append("metaAnnotations=");
        sb.append(this.getMetaAnnotations() == null? "null" : this.getMetaAnnotations().getClass().getSimpleName());
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
     * Executes an operation on this node.
     * @param operation The operation to perform.
     * @param p1 The parameter to pass to the operation.
     * @param p2 The parameter to pass to the operation.
     * @return The result of the operation.
     */
    @Override
    public <P1,P2,R> R executeOperation(BsjNodeOperation2Arguments<P1,P2,R> operation, P1 p1, P2 p2)
    {
        return operation.executeFieldModifiersNode(this, p1, p2);
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
                getMetaAnnotations()==null?null:getMetaAnnotations().deepCopy(factory),
                getAnnotations()==null?null:getAnnotations().deepCopy(factory),
                getStartLocation(),
                getStopLocation());
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
        
        if (before.equals(this.getMetaAnnotations()) && (after instanceof MetaAnnotationListNode))
        {
            setMetaAnnotations((MetaAnnotationListNode)after);
            return true;
        }
        if (before.equals(this.getAnnotations()) && (after instanceof AnnotationListNode))
        {
            setAnnotations((AnnotationListNode)after);
            return true;
        }
        return false;
    }
    
}
