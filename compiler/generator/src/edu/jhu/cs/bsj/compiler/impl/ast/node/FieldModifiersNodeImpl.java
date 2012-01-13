package edu.jhu.cs.bsj.compiler.impl.ast.node;

import java.util.Arrays;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.AccessModifier;
import edu.jhu.cs.bsj.compiler.ast.BsjAbortableNodeOperation;
import edu.jhu.cs.bsj.compiler.ast.BsjAbortableNodeOperation2Arguments;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.BsjTypedNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.NodeUnion;
import edu.jhu.cs.bsj.compiler.ast.node.FieldModifiersNode;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.list.AnnotationListNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaAnnotationListNode;
import edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeManager;
import edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactory;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.property.FieldModifiersNodeSetAccessPropertyEditScriptElementImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.property.FieldModifiersNodeSetFinalFlagPropertyEditScriptElementImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.property.FieldModifiersNodeSetStaticFlagPropertyEditScriptElementImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.property.FieldModifiersNodeSetTransientFlagPropertyEditScriptElementImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.property.FieldModifiersNodeSetVolatileFlagPropertyEditScriptElementImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.properties.FieldModifiersNodeProperties;

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
    
    /**
     * A set of those properties which have been populated from the backing node.
     * This field is <code>null</code> if <tt>backingNode</tt> is <code>null</code>.
     */
    private Set<FieldModifiersNodeProperties> populatedProperties;
    
    /** General constructor. */
    public FieldModifiersNodeImpl(
            AccessModifier access,
            boolean staticFlag,
            boolean finalFlag,
            boolean transientFlag,
            boolean volatileFlag,
            NodeUnion<? extends MetaAnnotationListNode> metaAnnotations,
            NodeUnion<? extends AnnotationListNode> annotations,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation,
            BsjNodeManager manager,
            boolean binary)
    {
        super(metaAnnotations, annotations, startLocation, stopLocation, manager, binary);
        this.populatedProperties = null;
        doSetAccess(access);
        doSetStaticFlag(staticFlag);
        doSetFinalFlag(finalFlag);
        doSetTransientFlag(transientFlag);
        doSetVolatileFlag(volatileFlag);
    }
    
    /** Proxy constructor. */
    public FieldModifiersNodeImpl(BsjNodeManager manager, BsjNodeProxyFactory proxyFactory, FieldModifiersNode backingNode)
    {
        super(manager, proxyFactory, backingNode);
        this.populatedProperties = EnumSet.noneOf(FieldModifiersNodeProperties.class);
    }
    
    /** Retrieves this node's backing node (if one exists). */
    protected FieldModifiersNode getBackingNode()
    {
        return (FieldModifiersNode)super.getBackingNode();
    }
    
    /**
     * Ensures that the access value has been populated from proxy.
     * If this node is not backed by a proxy or if the value has already been
     * populated, this method does nothing.
     */
    private void checkAccessWrapped()
    {
        if (this.populatedProperties == null || this.populatedProperties.contains(
                FieldModifiersNodeProperties.ACCESS))
            return;
        this.populatedProperties.add(FieldModifiersNodeProperties.ACCESS);
        this.access = this.getBackingNode().getAccess();
    }
    
    /**
     * Ensures that the staticFlag value has been populated from proxy.
     * If this node is not backed by a proxy or if the value has already been
     * populated, this method does nothing.
     */
    private void checkStaticFlagWrapped()
    {
        if (this.populatedProperties == null || this.populatedProperties.contains(
                FieldModifiersNodeProperties.STATIC_FLAG))
            return;
        this.populatedProperties.add(FieldModifiersNodeProperties.STATIC_FLAG);
        this.staticFlag = this.getBackingNode().getStaticFlag();
    }
    
    /**
     * Ensures that the finalFlag value has been populated from proxy.
     * If this node is not backed by a proxy or if the value has already been
     * populated, this method does nothing.
     */
    private void checkFinalFlagWrapped()
    {
        if (this.populatedProperties == null || this.populatedProperties.contains(
                FieldModifiersNodeProperties.FINAL_FLAG))
            return;
        this.populatedProperties.add(FieldModifiersNodeProperties.FINAL_FLAG);
        this.finalFlag = this.getBackingNode().getFinalFlag();
    }
    
    /**
     * Ensures that the transientFlag value has been populated from proxy.
     * If this node is not backed by a proxy or if the value has already been
     * populated, this method does nothing.
     */
    private void checkTransientFlagWrapped()
    {
        if (this.populatedProperties == null || this.populatedProperties.contains(
                FieldModifiersNodeProperties.TRANSIENT_FLAG))
            return;
        this.populatedProperties.add(FieldModifiersNodeProperties.TRANSIENT_FLAG);
        this.transientFlag = this.getBackingNode().getTransientFlag();
    }
    
    /**
     * Ensures that the volatileFlag value has been populated from proxy.
     * If this node is not backed by a proxy or if the value has already been
     * populated, this method does nothing.
     */
    private void checkVolatileFlagWrapped()
    {
        if (this.populatedProperties == null || this.populatedProperties.contains(
                FieldModifiersNodeProperties.VOLATILE_FLAG))
            return;
        this.populatedProperties.add(FieldModifiersNodeProperties.VOLATILE_FLAG);
        this.volatileFlag = this.getBackingNode().getVolatileFlag();
    }
    
    /**
     * Gets the access for the associated fields.
     * @return The access for the associated fields.
     */
    public AccessModifier getAccess()
    {
        checkAccessWrapped();
        return this.access;
    }
    
    /**
     * Changes the access for the associated fields.
     * @param access The access for the associated fields.
     */
    public void setAccess(AccessModifier access)
    {
        checkAccessWrapped();
        this.getManager().assertMutatable(this);
        this.doSetAccess(access);
        if (this.getManager().isRecordingEdits())
            super.recordEdit(new FieldModifiersNodeSetAccessPropertyEditScriptElementImpl(this.getManager().getCurrentMetaprogramId(), this.getUid(), access));
    }
    
    private void doSetAccess(AccessModifier access)
    {
        this.access = access;
    }
    
    /**
     * Gets whether or not the associated field is static.
     * @return Whether or not the associated field is static.
     */
    public boolean getStaticFlag()
    {
        checkStaticFlagWrapped();
        return this.staticFlag;
    }
    
    /**
     * Changes whether or not the associated field is static.
     * @param staticFlag Whether or not the associated field is static.
     */
    public void setStaticFlag(boolean staticFlag)
    {
        checkStaticFlagWrapped();
        this.getManager().assertMutatable(this);
        this.doSetStaticFlag(staticFlag);
        if (this.getManager().isRecordingEdits())
            super.recordEdit(new FieldModifiersNodeSetStaticFlagPropertyEditScriptElementImpl(this.getManager().getCurrentMetaprogramId(), this.getUid(), staticFlag));
    }
    
    private void doSetStaticFlag(boolean staticFlag)
    {
        this.staticFlag = staticFlag;
    }
    
    /**
     * Gets whether or not the associated field is final.
     * @return Whether or not the associated field is final.
     */
    public boolean getFinalFlag()
    {
        checkFinalFlagWrapped();
        return this.finalFlag;
    }
    
    /**
     * Changes whether or not the associated field is final.
     * @param finalFlag Whether or not the associated field is final.
     */
    public void setFinalFlag(boolean finalFlag)
    {
        checkFinalFlagWrapped();
        this.getManager().assertMutatable(this);
        this.doSetFinalFlag(finalFlag);
        if (this.getManager().isRecordingEdits())
            super.recordEdit(new FieldModifiersNodeSetFinalFlagPropertyEditScriptElementImpl(this.getManager().getCurrentMetaprogramId(), this.getUid(), finalFlag));
    }
    
    private void doSetFinalFlag(boolean finalFlag)
    {
        this.finalFlag = finalFlag;
    }
    
    /**
     * Gets whether or not the associated field is transient.
     * @return Whether or not the associated field is transient.
     */
    public boolean getTransientFlag()
    {
        checkTransientFlagWrapped();
        return this.transientFlag;
    }
    
    /**
     * Changes whether or not the associated field is transient.
     * @param transientFlag Whether or not the associated field is transient.
     */
    public void setTransientFlag(boolean transientFlag)
    {
        checkTransientFlagWrapped();
        this.getManager().assertMutatable(this);
        this.doSetTransientFlag(transientFlag);
        if (this.getManager().isRecordingEdits())
            super.recordEdit(new FieldModifiersNodeSetTransientFlagPropertyEditScriptElementImpl(this.getManager().getCurrentMetaprogramId(), this.getUid(), transientFlag));
    }
    
    private void doSetTransientFlag(boolean transientFlag)
    {
        this.transientFlag = transientFlag;
    }
    
    /**
     * Gets whether or not the associated field is volatile.
     * @return Whether or not the associated field is volatile.
     */
    public boolean getVolatileFlag()
    {
        checkVolatileFlagWrapped();
        return this.volatileFlag;
    }
    
    /**
     * Changes whether or not the associated field is volatile.
     * @param volatileFlag Whether or not the associated field is volatile.
     */
    public void setVolatileFlag(boolean volatileFlag)
    {
        checkVolatileFlagWrapped();
        this.getManager().assertMutatable(this);
        this.doSetVolatileFlag(volatileFlag);
        if (this.getManager().isRecordingEdits())
            super.recordEdit(new FieldModifiersNodeSetVolatileFlagPropertyEditScriptElementImpl(this.getManager().getCurrentMetaprogramId(), this.getUid(), volatileFlag));
    }
    
    private void doSetVolatileFlag(boolean volatileFlag)
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
     * Produces a mutable map of this node's children.  Modifying this map will have no
     * effect on this node.
     * @return A mapping of the node's children.
     */
    @Override
    public Map<String,Object> getChildMap()
    {
        Map<String,Object> map = super.getChildMap();
        map.put("access", getAccess());
        map.put("staticFlag", getStaticFlag());
        map.put("finalFlag", getFinalFlag());
        map.put("transientFlag", getTransientFlag());
        map.put("volatileFlag", getVolatileFlag());
        return map;
    }
    
    /**
     * Returns an iterator over the children of this node.
     * @see Node#getChildIterator()
     */
    @Override
    public Iterable<? extends Node> getChildIterable()
    {
        return Arrays.asList(new Node[]{getUnionForMetaAnnotations().getNodeValue(), getUnionForAnnotations().getNodeValue()});
    }
    
    /**
     * Obtains a human-readable description of this node.
     * @return A human-readable description of this node.
     */
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getClass().getSimpleName());
        sb.append('#');
        sb.append(this.getUid());
        sb.append('[');
        sb.append("access=");
        sb.append(String.valueOf(this.getAccess()) + ":" + (this.getAccess() != null ? this.getAccess().getClass().getSimpleName() : "null"));
        sb.append(',');
        sb.append("staticFlag=");
        sb.append(',');
        sb.append("finalFlag=");
        sb.append(',');
        sb.append("transientFlag=");
        sb.append(',');
        sb.append("volatileFlag=");
        sb.append(',');
        sb.append("metaAnnotations=");
        sb.append(this.getUnionForMetaAnnotations().getNodeValue() == null? "null" : this.getUnionForMetaAnnotations().getNodeValue().getClass().getSimpleName());
        sb.append(',');
        sb.append("annotations=");
        sb.append(this.getUnionForAnnotations().getNodeValue() == null? "null" : this.getUnionForAnnotations().getNodeValue().getClass().getSimpleName());
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
    public <P,R,X extends Exception> R executeOperation(BsjAbortableNodeOperation<P,R,X> operation, P p) throws X
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
    public <P1,P2,R,X extends Exception> R executeOperation(BsjAbortableNodeOperation2Arguments<P1,P2,R,X> operation, P1 p1, P2 p2) throws X
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
        NodeUnion<? extends MetaAnnotationListNode> metaAnnotationsCopy;
        switch (getUnionForMetaAnnotations().getType())
        {
            case NORMAL:
                if (getUnionForMetaAnnotations().getNormalNode() == null)
                {
                    metaAnnotationsCopy = factory.<MetaAnnotationListNode>makeNormalNodeUnion(null);
                } else
                {
                    metaAnnotationsCopy = factory.makeNormalNodeUnion(getUnionForMetaAnnotations().getNormalNode().deepCopy(factory));
                }
                break;
            case SPLICE:
                if (getUnionForMetaAnnotations().getSpliceNode() == null)
                {
                    metaAnnotationsCopy = factory.<MetaAnnotationListNode>makeSpliceNodeUnion(null);
                } else
                {
                    metaAnnotationsCopy = factory.makeSpliceNodeUnion(getUnionForMetaAnnotations().getSpliceNode().deepCopy(factory));
                }
                break;
            default:
                throw new IllegalStateException("Unrecognized union component type: " + getUnionForMetaAnnotations().getType());
        }
        NodeUnion<? extends AnnotationListNode> annotationsCopy;
        switch (getUnionForAnnotations().getType())
        {
            case NORMAL:
                if (getUnionForAnnotations().getNormalNode() == null)
                {
                    annotationsCopy = factory.<AnnotationListNode>makeNormalNodeUnion(null);
                } else
                {
                    annotationsCopy = factory.makeNormalNodeUnion(getUnionForAnnotations().getNormalNode().deepCopy(factory));
                }
                break;
            case SPLICE:
                if (getUnionForAnnotations().getSpliceNode() == null)
                {
                    annotationsCopy = factory.<AnnotationListNode>makeSpliceNodeUnion(null);
                } else
                {
                    annotationsCopy = factory.makeSpliceNodeUnion(getUnionForAnnotations().getSpliceNode().deepCopy(factory));
                }
                break;
            default:
                throw new IllegalStateException("Unrecognized union component type: " + getUnionForAnnotations().getType());
        }
        return factory.makeFieldModifiersNodeWithUnions(
                getAccess(),
                getStaticFlag(),
                getFinalFlag(),
                getTransientFlag(),
                getVolatileFlag(),
                metaAnnotationsCopy,
                annotationsCopy,
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
        
        if (before.equals(this.getUnionForMetaAnnotations().getNodeValue()))
        {
            setMetaAnnotations((MetaAnnotationListNode)after);
            return true;
        }
        if (before.equals(this.getUnionForAnnotations().getNodeValue()))
        {
            setAnnotations((AnnotationListNode)after);
            return true;
        }
        return false;
    }
    
}
