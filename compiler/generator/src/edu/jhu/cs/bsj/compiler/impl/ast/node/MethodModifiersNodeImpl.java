package edu.jhu.cs.bsj.compiler.impl.ast.node;

import java.util.Arrays;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
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
import edu.jhu.cs.bsj.compiler.ast.node.MethodModifiersNode;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.list.AnnotationListNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaAnnotationListNode;
import edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeManager;
import edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactory;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.property.MethodModifiersNodeSetAbstractFlagPropertyEditScriptElementImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.property.MethodModifiersNodeSetAccessPropertyEditScriptElementImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.property.MethodModifiersNodeSetFinalFlagPropertyEditScriptElementImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.property.MethodModifiersNodeSetNativeFlagPropertyEditScriptElementImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.property.MethodModifiersNodeSetStaticFlagPropertyEditScriptElementImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.property.MethodModifiersNodeSetStrictfpFlagPropertyEditScriptElementImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.property.MethodModifiersNodeSetSynchronizedFlagPropertyEditScriptElementImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.properties.MethodModifiersNodeProperties;

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
    
    /**
     * A set of those properties which have been populated from the backing node.
     * This field is <code>null</code> if <tt>backingNode</tt> is <code>null</code>.
     */
    private Set<MethodModifiersNodeProperties> populatedProperties;
    
    /** General constructor. */
    public MethodModifiersNodeImpl(
            AccessModifier access,
            boolean abstractFlag,
            boolean staticFlag,
            boolean finalFlag,
            boolean synchronizedFlag,
            boolean nativeFlag,
            boolean strictfpFlag,
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
        doSetAbstractFlag(abstractFlag);
        doSetStaticFlag(staticFlag);
        doSetFinalFlag(finalFlag);
        doSetSynchronizedFlag(synchronizedFlag);
        doSetNativeFlag(nativeFlag);
        doSetStrictfpFlag(strictfpFlag);
    }
    
    /** Proxy constructor. */
    public MethodModifiersNodeImpl(BsjNodeManager manager, BsjNodeProxyFactory proxyFactory, MethodModifiersNode backingNode)
    {
        super(manager, proxyFactory, backingNode);
        this.populatedProperties = EnumSet.noneOf(MethodModifiersNodeProperties.class);
    }
    
    /** Retrieves this node's backing node (if one exists). */
    protected MethodModifiersNode getBackingNode()
    {
        return (MethodModifiersNode)super.getBackingNode();
    }
    
    /**
     * Ensures that the access value has been populated from proxy.
     * If this node is not backed by a proxy or if the value has already been
     * populated, this method does nothing.
     */
    private void checkAccessWrapped()
    {
        if (this.populatedProperties == null || this.populatedProperties.contains(
                MethodModifiersNodeProperties.ACCESS))
            return;
        this.populatedProperties.add(MethodModifiersNodeProperties.ACCESS);
        this.access = this.getBackingNode().getAccess();
    }
    
    /**
     * Ensures that the abstractFlag value has been populated from proxy.
     * If this node is not backed by a proxy or if the value has already been
     * populated, this method does nothing.
     */
    private void checkAbstractFlagWrapped()
    {
        if (this.populatedProperties == null || this.populatedProperties.contains(
                MethodModifiersNodeProperties.ABSTRACT_FLAG))
            return;
        this.populatedProperties.add(MethodModifiersNodeProperties.ABSTRACT_FLAG);
        this.abstractFlag = this.getBackingNode().getAbstractFlag();
    }
    
    /**
     * Ensures that the staticFlag value has been populated from proxy.
     * If this node is not backed by a proxy or if the value has already been
     * populated, this method does nothing.
     */
    private void checkStaticFlagWrapped()
    {
        if (this.populatedProperties == null || this.populatedProperties.contains(
                MethodModifiersNodeProperties.STATIC_FLAG))
            return;
        this.populatedProperties.add(MethodModifiersNodeProperties.STATIC_FLAG);
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
                MethodModifiersNodeProperties.FINAL_FLAG))
            return;
        this.populatedProperties.add(MethodModifiersNodeProperties.FINAL_FLAG);
        this.finalFlag = this.getBackingNode().getFinalFlag();
    }
    
    /**
     * Ensures that the synchronizedFlag value has been populated from proxy.
     * If this node is not backed by a proxy or if the value has already been
     * populated, this method does nothing.
     */
    private void checkSynchronizedFlagWrapped()
    {
        if (this.populatedProperties == null || this.populatedProperties.contains(
                MethodModifiersNodeProperties.SYNCHRONIZED_FLAG))
            return;
        this.populatedProperties.add(MethodModifiersNodeProperties.SYNCHRONIZED_FLAG);
        this.synchronizedFlag = this.getBackingNode().getSynchronizedFlag();
    }
    
    /**
     * Ensures that the nativeFlag value has been populated from proxy.
     * If this node is not backed by a proxy or if the value has already been
     * populated, this method does nothing.
     */
    private void checkNativeFlagWrapped()
    {
        if (this.populatedProperties == null || this.populatedProperties.contains(
                MethodModifiersNodeProperties.NATIVE_FLAG))
            return;
        this.populatedProperties.add(MethodModifiersNodeProperties.NATIVE_FLAG);
        this.nativeFlag = this.getBackingNode().getNativeFlag();
    }
    
    /**
     * Ensures that the strictfpFlag value has been populated from proxy.
     * If this node is not backed by a proxy or if the value has already been
     * populated, this method does nothing.
     */
    private void checkStrictfpFlagWrapped()
    {
        if (this.populatedProperties == null || this.populatedProperties.contains(
                MethodModifiersNodeProperties.STRICTFP_FLAG))
            return;
        this.populatedProperties.add(MethodModifiersNodeProperties.STRICTFP_FLAG);
        this.strictfpFlag = this.getBackingNode().getStrictfpFlag();
    }
    
    /**
     * Gets the access for the associated method.
     * @return The access for the associated method.
     */
    public AccessModifier getAccess()
    {
        checkAccessWrapped();
        return this.access;
    }
    
    /**
     * Changes the access for the associated method.
     * @param access The access for the associated method.
     */
    public void setAccess(AccessModifier access)
    {
        checkAccessWrapped();
        this.getManager().assertMutatable(this);
        this.doSetAccess(access);
        if (this.getManager().isRecordingEdits())
            super.recordEdit(new MethodModifiersNodeSetAccessPropertyEditScriptElementImpl(this.getManager().getCurrentMetaprogramId(), this.getUid(), access));
    }
    
    private void doSetAccess(AccessModifier access)
    {
        this.access = access;
    }
    
    /**
     * Gets whether or not the associated method is abstract.
     * @return Whether or not the associated method is abstract.
     */
    public boolean getAbstractFlag()
    {
        checkAbstractFlagWrapped();
        return this.abstractFlag;
    }
    
    /**
     * Changes whether or not the associated method is abstract.
     * @param abstractFlag Whether or not the associated method is abstract.
     */
    public void setAbstractFlag(boolean abstractFlag)
    {
        checkAbstractFlagWrapped();
        this.getManager().assertMutatable(this);
        this.doSetAbstractFlag(abstractFlag);
        if (this.getManager().isRecordingEdits())
            super.recordEdit(new MethodModifiersNodeSetAbstractFlagPropertyEditScriptElementImpl(this.getManager().getCurrentMetaprogramId(), this.getUid(), abstractFlag));
    }
    
    private void doSetAbstractFlag(boolean abstractFlag)
    {
        this.abstractFlag = abstractFlag;
    }
    
    /**
     * Gets whether or not the associated method is static.
     * @return Whether or not the associated method is static.
     */
    public boolean getStaticFlag()
    {
        checkStaticFlagWrapped();
        return this.staticFlag;
    }
    
    /**
     * Changes whether or not the associated method is static.
     * @param staticFlag Whether or not the associated method is static.
     */
    public void setStaticFlag(boolean staticFlag)
    {
        checkStaticFlagWrapped();
        this.getManager().assertMutatable(this);
        this.doSetStaticFlag(staticFlag);
        if (this.getManager().isRecordingEdits())
            super.recordEdit(new MethodModifiersNodeSetStaticFlagPropertyEditScriptElementImpl(this.getManager().getCurrentMetaprogramId(), this.getUid(), staticFlag));
    }
    
    private void doSetStaticFlag(boolean staticFlag)
    {
        this.staticFlag = staticFlag;
    }
    
    /**
     * Gets whether or not the associated method is final.
     * @return Whether or not the associated method is final.
     */
    public boolean getFinalFlag()
    {
        checkFinalFlagWrapped();
        return this.finalFlag;
    }
    
    /**
     * Changes whether or not the associated method is final.
     * @param finalFlag Whether or not the associated method is final.
     */
    public void setFinalFlag(boolean finalFlag)
    {
        checkFinalFlagWrapped();
        this.getManager().assertMutatable(this);
        this.doSetFinalFlag(finalFlag);
        if (this.getManager().isRecordingEdits())
            super.recordEdit(new MethodModifiersNodeSetFinalFlagPropertyEditScriptElementImpl(this.getManager().getCurrentMetaprogramId(), this.getUid(), finalFlag));
    }
    
    private void doSetFinalFlag(boolean finalFlag)
    {
        this.finalFlag = finalFlag;
    }
    
    /**
     * Gets whether or not the associated method is synchronized.
     * @return Whether or not the associated method is synchronized.
     */
    public boolean getSynchronizedFlag()
    {
        checkSynchronizedFlagWrapped();
        return this.synchronizedFlag;
    }
    
    /**
     * Changes whether or not the associated method is synchronized.
     * @param synchronizedFlag Whether or not the associated method is synchronized.
     */
    public void setSynchronizedFlag(boolean synchronizedFlag)
    {
        checkSynchronizedFlagWrapped();
        this.getManager().assertMutatable(this);
        this.doSetSynchronizedFlag(synchronizedFlag);
        if (this.getManager().isRecordingEdits())
            super.recordEdit(new MethodModifiersNodeSetSynchronizedFlagPropertyEditScriptElementImpl(this.getManager().getCurrentMetaprogramId(), this.getUid(), synchronizedFlag));
    }
    
    private void doSetSynchronizedFlag(boolean synchronizedFlag)
    {
        this.synchronizedFlag = synchronizedFlag;
    }
    
    /**
     * Gets whether or not the associated method is native.
     * @return Whether or not the associated method is native.
     */
    public boolean getNativeFlag()
    {
        checkNativeFlagWrapped();
        return this.nativeFlag;
    }
    
    /**
     * Changes whether or not the associated method is native.
     * @param nativeFlag Whether or not the associated method is native.
     */
    public void setNativeFlag(boolean nativeFlag)
    {
        checkNativeFlagWrapped();
        this.getManager().assertMutatable(this);
        this.doSetNativeFlag(nativeFlag);
        if (this.getManager().isRecordingEdits())
            super.recordEdit(new MethodModifiersNodeSetNativeFlagPropertyEditScriptElementImpl(this.getManager().getCurrentMetaprogramId(), this.getUid(), nativeFlag));
    }
    
    private void doSetNativeFlag(boolean nativeFlag)
    {
        this.nativeFlag = nativeFlag;
    }
    
    /**
     * Gets whether or not the associated method uses strict floating-point.
     * @return Whether or not the associated method uses strict floating-point.
     */
    public boolean getStrictfpFlag()
    {
        checkStrictfpFlagWrapped();
        return this.strictfpFlag;
    }
    
    /**
     * Changes whether or not the associated method uses strict floating-point.
     * @param strictfpFlag Whether or not the associated method uses strict floating-point.
     */
    public void setStrictfpFlag(boolean strictfpFlag)
    {
        checkStrictfpFlagWrapped();
        this.getManager().assertMutatable(this);
        this.doSetStrictfpFlag(strictfpFlag);
        if (this.getManager().isRecordingEdits())
            super.recordEdit(new MethodModifiersNodeSetStrictfpFlagPropertyEditScriptElementImpl(this.getManager().getCurrentMetaprogramId(), this.getUid(), strictfpFlag));
    }
    
    private void doSetStrictfpFlag(boolean strictfpFlag)
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
        sb.append("abstractFlag=");
        sb.append(',');
        sb.append("staticFlag=");
        sb.append(',');
        sb.append("finalFlag=");
        sb.append(',');
        sb.append("synchronizedFlag=");
        sb.append(',');
        sb.append("nativeFlag=");
        sb.append(',');
        sb.append("strictfpFlag=");
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
    public <P1,P2,R,X extends Exception> R executeOperation(BsjAbortableNodeOperation2Arguments<P1,P2,R,X> operation, P1 p1, P2 p2) throws X
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
        return factory.makeMethodModifiersNodeWithUnions(
                getAccess(),
                getAbstractFlag(),
                getStaticFlag(),
                getFinalFlag(),
                getSynchronizedFlag(),
                getNativeFlag(),
                getStrictfpFlag(),
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
