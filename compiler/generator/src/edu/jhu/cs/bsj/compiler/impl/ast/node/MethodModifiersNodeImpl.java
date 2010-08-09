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
import edu.jhu.cs.bsj.compiler.ast.node.MethodModifiersNode;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.list.AnnotationListNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaAnnotationListNode;
import edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeManager;
import edu.jhu.cs.bsj.compiler.impl.ast.attribute.ReadWriteAttribute;

@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class MethodModifiersNodeImpl extends ModifiersNodeImpl implements MethodModifiersNode
{
    /** The access for the associated method. */
    private AccessModifier access;
    
    /** Whether or not the associated method is abstract. */
    private boolean abstractFlag;
    
    /** Whether or not the associated method is static. */
    private boolean staticFlag;
    
    /** Whether or not the associated method is final. */
    private boolean finalFlag;
    
    /** Whether or not the associated method is synchronized. */
    private boolean synchronizedFlag;
    
    /** Whether or not the associated method is native. */
    private boolean nativeFlag;
    
    /** Whether or not the associated method uses strict floating-point. */
    private boolean strictfpFlag;
    
    private Map<LocalAttribute,ReadWriteAttribute> localAttributes = new EnumMap<LocalAttribute,ReadWriteAttribute>(LocalAttribute.class);
    private ReadWriteAttribute getAttribute(LocalAttribute attributeName)
    {
        ReadWriteAttribute attribute = localAttributes.get(attributeName);
        if (attribute == null)
        {
            attribute = new ReadWriteAttribute(MethodModifiersNodeImpl.this);
            localAttributes.put(attributeName, attribute);
        }
        return attribute;
    }
    private static enum LocalAttribute
    {
        /** Attribute identifier for the access property. */
        ACCESS,
        /** Attribute identifier for the abstractFlag property. */
        ABSTRACT_FLAG,
        /** Attribute identifier for the staticFlag property. */
        STATIC_FLAG,
        /** Attribute identifier for the finalFlag property. */
        FINAL_FLAG,
        /** Attribute identifier for the synchronizedFlag property. */
        SYNCHRONIZED_FLAG,
        /** Attribute identifier for the nativeFlag property. */
        NATIVE_FLAG,
        /** Attribute identifier for the strictfpFlag property. */
        STRICTFP_FLAG,
    }
    
    /** General constructor. */
    public MethodModifiersNodeImpl(
            AccessModifier access,
            boolean abstractFlag,
            boolean staticFlag,
            boolean finalFlag,
            boolean synchronizedFlag,
            boolean nativeFlag,
            boolean strictfpFlag,
            MetaAnnotationListNode metaAnnotations,
            AnnotationListNode annotations,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation,
            BsjNodeManager manager,
            boolean binary)
    {
        super(metaAnnotations, annotations, startLocation, stopLocation, manager, binary);
        this.access = access;
        this.abstractFlag = abstractFlag;
        this.staticFlag = staticFlag;
        this.finalFlag = finalFlag;
        this.synchronizedFlag = synchronizedFlag;
        this.nativeFlag = nativeFlag;
        this.strictfpFlag = strictfpFlag;
    }
    
    /**
     * Gets the access for the associated method.
     * @return The access for the associated method.
     */
    public AccessModifier getAccess()
    {
        getAttribute(LocalAttribute.ACCESS).recordAccess(ReadWriteAttribute.AccessType.READ);
        return this.access;
    }
    
    /**
     * Changes the access for the associated method.
     * @param access The access for the associated method.
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
     * Gets whether or not the associated method is abstract.
     * @return Whether or not the associated method is abstract.
     */
    public boolean getAbstractFlag()
    {
        getAttribute(LocalAttribute.ABSTRACT_FLAG).recordAccess(ReadWriteAttribute.AccessType.READ);
        return this.abstractFlag;
    }
    
    /**
     * Changes whether or not the associated method is abstract.
     * @param abstractFlag Whether or not the associated method is abstract.
     */
    public void setAbstractFlag(boolean abstractFlag)
    {
            setAbstractFlag(abstractFlag, true);
    }
    
    private void setAbstractFlag(boolean abstractFlag, boolean checkPermissions)
    {
        if (checkPermissions)
        {
            getManager().assertMutatable(this);
            getAttribute(LocalAttribute.ABSTRACT_FLAG).recordAccess(ReadWriteAttribute.AccessType.WRITE);
        }
        this.abstractFlag = abstractFlag;
    }
    
    /**
     * Gets whether or not the associated method is static.
     * @return Whether or not the associated method is static.
     */
    public boolean getStaticFlag()
    {
        getAttribute(LocalAttribute.STATIC_FLAG).recordAccess(ReadWriteAttribute.AccessType.READ);
        return this.staticFlag;
    }
    
    /**
     * Changes whether or not the associated method is static.
     * @param staticFlag Whether or not the associated method is static.
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
     * Gets whether or not the associated method is final.
     * @return Whether or not the associated method is final.
     */
    public boolean getFinalFlag()
    {
        getAttribute(LocalAttribute.FINAL_FLAG).recordAccess(ReadWriteAttribute.AccessType.READ);
        return this.finalFlag;
    }
    
    /**
     * Changes whether or not the associated method is final.
     * @param finalFlag Whether or not the associated method is final.
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
     * Gets whether or not the associated method is synchronized.
     * @return Whether or not the associated method is synchronized.
     */
    public boolean getSynchronizedFlag()
    {
        getAttribute(LocalAttribute.SYNCHRONIZED_FLAG).recordAccess(ReadWriteAttribute.AccessType.READ);
        return this.synchronizedFlag;
    }
    
    /**
     * Changes whether or not the associated method is synchronized.
     * @param synchronizedFlag Whether or not the associated method is synchronized.
     */
    public void setSynchronizedFlag(boolean synchronizedFlag)
    {
            setSynchronizedFlag(synchronizedFlag, true);
    }
    
    private void setSynchronizedFlag(boolean synchronizedFlag, boolean checkPermissions)
    {
        if (checkPermissions)
        {
            getManager().assertMutatable(this);
            getAttribute(LocalAttribute.SYNCHRONIZED_FLAG).recordAccess(ReadWriteAttribute.AccessType.WRITE);
        }
        this.synchronizedFlag = synchronizedFlag;
    }
    
    /**
     * Gets whether or not the associated method is native.
     * @return Whether or not the associated method is native.
     */
    public boolean getNativeFlag()
    {
        getAttribute(LocalAttribute.NATIVE_FLAG).recordAccess(ReadWriteAttribute.AccessType.READ);
        return this.nativeFlag;
    }
    
    /**
     * Changes whether or not the associated method is native.
     * @param nativeFlag Whether or not the associated method is native.
     */
    public void setNativeFlag(boolean nativeFlag)
    {
            setNativeFlag(nativeFlag, true);
    }
    
    private void setNativeFlag(boolean nativeFlag, boolean checkPermissions)
    {
        if (checkPermissions)
        {
            getManager().assertMutatable(this);
            getAttribute(LocalAttribute.NATIVE_FLAG).recordAccess(ReadWriteAttribute.AccessType.WRITE);
        }
        this.nativeFlag = nativeFlag;
    }
    
    /**
     * Gets whether or not the associated method uses strict floating-point.
     * @return Whether or not the associated method uses strict floating-point.
     */
    public boolean getStrictfpFlag()
    {
        getAttribute(LocalAttribute.STRICTFP_FLAG).recordAccess(ReadWriteAttribute.AccessType.READ);
        return this.strictfpFlag;
    }
    
    /**
     * Changes whether or not the associated method uses strict floating-point.
     * @param strictfpFlag Whether or not the associated method uses strict floating-point.
     */
    public void setStrictfpFlag(boolean strictfpFlag)
    {
            setStrictfpFlag(strictfpFlag, true);
    }
    
    private void setStrictfpFlag(boolean strictfpFlag, boolean checkPermissions)
    {
        if (checkPermissions)
        {
            getManager().assertMutatable(this);
            getAttribute(LocalAttribute.STRICTFP_FLAG).recordAccess(ReadWriteAttribute.AccessType.WRITE);
        }
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
        visitor.visitMethodModifiersNodeStart(this, true);
        visitor.visitModifiersNodeStart(this);
        visitor.visitNodeStart(this);
        visitor.visitStartEnd(this);
        receiveTypedToChildren(visitor);
        visitor.visitStopBegin(this);
        visitor.visitNodeStop(this);
        visitor.visitModifiersNodeStop(this);
        visitor.visitMethodModifiersNodeStop(this, true);
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
        list.add(getAbstractFlag());
        list.add(getStaticFlag());
        list.add(getFinalFlag());
        list.add(getSynchronizedFlag());
        list.add(getNativeFlag());
        list.add(getStrictfpFlag());
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
        sb.append("abstractFlag=");
        sb.append(String.valueOf(this.getAbstractFlag()) + ":" + ("boolean"));
        sb.append(',');
        sb.append("staticFlag=");
        sb.append(String.valueOf(this.getStaticFlag()) + ":" + ("boolean"));
        sb.append(',');
        sb.append("finalFlag=");
        sb.append(String.valueOf(this.getFinalFlag()) + ":" + ("boolean"));
        sb.append(',');
        sb.append("synchronizedFlag=");
        sb.append(String.valueOf(this.getSynchronizedFlag()) + ":" + ("boolean"));
        sb.append(',');
        sb.append("nativeFlag=");
        sb.append(String.valueOf(this.getNativeFlag()) + ":" + ("boolean"));
        sb.append(',');
        sb.append("strictfpFlag=");
        sb.append(String.valueOf(this.getStrictfpFlag()) + ":" + ("boolean"));
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
        return operation.executeMethodModifiersNode(this, p);
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
        return operation.executeMethodModifiersNode(this, p1, p2);
    }
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public MethodModifiersNode deepCopy(BsjNodeFactory factory)
    {
        return factory.makeMethodModifiersNode(
                getAccess(),
                getAbstractFlag(),
                getStaticFlag(),
                getFinalFlag(),
                getSynchronizedFlag(),
                getNativeFlag(),
                getStrictfpFlag(),
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
