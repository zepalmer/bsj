package edu.jhu.cs.bsj.compiler.impl.ast.node;

import java.util.Arrays;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjAbortableNodeOperation;
import edu.jhu.cs.bsj.compiler.ast.BsjAbortableNodeOperation2Arguments;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.BsjTypedNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.NodeUnion;
import edu.jhu.cs.bsj.compiler.ast.node.NameNode;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.PackageDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.AnnotationListNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaAnnotationListNode;
import edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeManager;
import edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactory;
import edu.jhu.cs.bsj.compiler.impl.ast.NormalNodeUnion;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.property.PackageDeclarationNodeSetAnnotationsPropertyEditScriptElementImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.property.PackageDeclarationNodeSetMetaAnnotationsPropertyEditScriptElementImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.property.PackageDeclarationNodeSetNamePropertyEditScriptElementImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.properties.PackageDeclarationNodeProperties;

@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class PackageDeclarationNodeImpl extends NodeImpl implements PackageDeclarationNode
{
    /** The name of the package. */
    private NodeUnion<? extends NameNode> name;
    
    /** The meta-annotations on the package declaration. */
    private NodeUnion<? extends MetaAnnotationListNode> metaAnnotations;
    
    /** The annotations on the package declaration. */
    private NodeUnion<? extends AnnotationListNode> annotations;
    
    /**
     * A set of those properties which have been populated from the backing node.
     * This field is <code>null</code> if <tt>backingNode</tt> is <code>null</code>.
     */
    private Set<PackageDeclarationNodeProperties> populatedProperties;
    
    /** General constructor. */
    public PackageDeclarationNodeImpl(
            NodeUnion<? extends NameNode> name,
            NodeUnion<? extends MetaAnnotationListNode> metaAnnotations,
            NodeUnion<? extends AnnotationListNode> annotations,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation,
            BsjNodeManager manager,
            boolean binary)
    {
        super(startLocation, stopLocation, manager, binary);
        this.populatedProperties = null;
        doSetName(name);
        doSetMetaAnnotations(metaAnnotations);
        doSetAnnotations(annotations);
    }
    
    /** Proxy constructor. */
    public PackageDeclarationNodeImpl(BsjNodeManager manager, BsjNodeProxyFactory proxyFactory, PackageDeclarationNode backingNode)
    {
        super(manager, proxyFactory, backingNode);
        this.populatedProperties = EnumSet.noneOf(PackageDeclarationNodeProperties.class);
    }
    
    /** Retrieves this node's backing node (if one exists). */
    protected PackageDeclarationNode getBackingNode()
    {
        return (PackageDeclarationNode)super.getBackingNode();
    }
    
    /**
     * Ensures that the name value has been populated from proxy.
     * If this node is not backed by a proxy or if the value has already been
     * populated, this method does nothing.
     */
    private void checkNameWrapped()
    {
        if (this.populatedProperties == null || this.populatedProperties.contains(
                PackageDeclarationNodeProperties.NAME))
            return;
        this.populatedProperties.add(PackageDeclarationNodeProperties.NAME);
        NodeUnion<? extends NameNode> union = this.getBackingNode().getUnionForName();
        switch (union.getType())
        {
            case NORMAL:
                union = this.getProxyFactory().makeNormalNodeUnion(
                        this.getProxyFactory().makeNameNode(union.getNormalNode()));
                break;
            case SPLICE:
                union = this.getProxyFactory().makeSpliceNodeUnion(
                        this.getProxyFactory().makeSpliceNode(union.getSpliceNode()));
                break;
            default:
                throw new IllegalStateException("Unrecognized union type: " + union.getType());
        }
        this.name = union;
    }
    
    /**
     * Ensures that the metaAnnotations value has been populated from proxy.
     * If this node is not backed by a proxy or if the value has already been
     * populated, this method does nothing.
     */
    private void checkMetaAnnotationsWrapped()
    {
        if (this.populatedProperties == null || this.populatedProperties.contains(
                PackageDeclarationNodeProperties.META_ANNOTATIONS))
            return;
        this.populatedProperties.add(PackageDeclarationNodeProperties.META_ANNOTATIONS);
        NodeUnion<? extends MetaAnnotationListNode> union = this.getBackingNode().getUnionForMetaAnnotations();
        switch (union.getType())
        {
            case NORMAL:
                union = this.getProxyFactory().makeNormalNodeUnion(
                        this.getProxyFactory().makeMetaAnnotationListNode(union.getNormalNode()));
                break;
            case SPLICE:
                union = this.getProxyFactory().makeSpliceNodeUnion(
                        this.getProxyFactory().makeSpliceNode(union.getSpliceNode()));
                break;
            default:
                throw new IllegalStateException("Unrecognized union type: " + union.getType());
        }
        this.metaAnnotations = union;
    }
    
    /**
     * Ensures that the annotations value has been populated from proxy.
     * If this node is not backed by a proxy or if the value has already been
     * populated, this method does nothing.
     */
    private void checkAnnotationsWrapped()
    {
        if (this.populatedProperties == null || this.populatedProperties.contains(
                PackageDeclarationNodeProperties.ANNOTATIONS))
            return;
        this.populatedProperties.add(PackageDeclarationNodeProperties.ANNOTATIONS);
        NodeUnion<? extends AnnotationListNode> union = this.getBackingNode().getUnionForAnnotations();
        switch (union.getType())
        {
            case NORMAL:
                union = this.getProxyFactory().makeNormalNodeUnion(
                        this.getProxyFactory().makeAnnotationListNode(union.getNormalNode()));
                break;
            case SPLICE:
                union = this.getProxyFactory().makeSpliceNodeUnion(
                        this.getProxyFactory().makeSpliceNode(union.getSpliceNode()));
                break;
            default:
                throw new IllegalStateException("Unrecognized union type: " + union.getType());
        }
        this.annotations = union;
    }
    
    /**
     * Gets the name of the package.  This property's value is assumed to be a normal node.
     * @return The name of the package.
     * @throws ClassCastException If this property's value is not a normal node.
     */
    public NameNode getName()
    {
        checkNameWrapped();
        if (this.name == null)
        {
            return null;
        } else
        {
            return this.name.getNormalNode();
        }
    }
    
    /**
     * Gets the name of the package.
     * @return The name of the package.
     */
    public NodeUnion<? extends NameNode> getUnionForName()
    {
        checkNameWrapped();
        if (this.name == null)
        {
            this.name = new NormalNodeUnion<NameNode>(null);
        }
        return this.name;
    }
    
    /**
     * Changes the name of the package.
     * @param name The name of the package.
     */
    public void setName(NameNode name)
    {
        checkNameWrapped();
        this.setUnionForName(new NormalNodeUnion<NameNode>(name));
    }
    
    /**
     * Changes the name of the package.
     * @param name The name of the package.
     */
    public void setUnionForName(NodeUnion<? extends NameNode> name)
    {
        checkNameWrapped();
        this.getManager().assertMutatable(this);
        this.doSetName(name);
        if (this.getManager().isRecordingEdits())
            super.recordEdit(new PackageDeclarationNodeSetNamePropertyEditScriptElementImpl(this.getManager().getCurrentMetaprogramId(), this.getUid(), name.getNodeValue() == null ? null : name.getNodeValue().getUid()));
    }
    
    private void doSetName(NodeUnion<? extends NameNode> name)
    {
        if (name == null)
        {
            name = new NormalNodeUnion<NameNode>(null);
        }
        if (this.name != null)
        {
            setAsChild(this.name.getNodeValue(), false);
        }
        this.name = name;
        setAsChild(name.getNodeValue(), true);
    }
    
    /**
     * Gets the meta-annotations on the package declaration.  This property's value is assumed to be a normal node.
     * @return The meta-annotations on the package declaration.
     * @throws ClassCastException If this property's value is not a normal node.
     */
    public MetaAnnotationListNode getMetaAnnotations()
    {
        checkMetaAnnotationsWrapped();
        if (this.metaAnnotations == null)
        {
            return null;
        } else
        {
            return this.metaAnnotations.getNormalNode();
        }
    }
    
    /**
     * Gets the meta-annotations on the package declaration.
     * @return The meta-annotations on the package declaration.
     */
    public NodeUnion<? extends MetaAnnotationListNode> getUnionForMetaAnnotations()
    {
        checkMetaAnnotationsWrapped();
        if (this.metaAnnotations == null)
        {
            this.metaAnnotations = new NormalNodeUnion<MetaAnnotationListNode>(null);
        }
        return this.metaAnnotations;
    }
    
    /**
     * Changes the meta-annotations on the package declaration.
     * @param metaAnnotations The meta-annotations on the package declaration.
     */
    public void setMetaAnnotations(MetaAnnotationListNode metaAnnotations)
    {
        checkMetaAnnotationsWrapped();
        this.setUnionForMetaAnnotations(new NormalNodeUnion<MetaAnnotationListNode>(metaAnnotations));
    }
    
    /**
     * Changes the meta-annotations on the package declaration.
     * @param metaAnnotations The meta-annotations on the package declaration.
     */
    public void setUnionForMetaAnnotations(NodeUnion<? extends MetaAnnotationListNode> metaAnnotations)
    {
        checkMetaAnnotationsWrapped();
        this.getManager().assertMutatable(this);
        this.doSetMetaAnnotations(metaAnnotations);
        if (this.getManager().isRecordingEdits())
            super.recordEdit(new PackageDeclarationNodeSetMetaAnnotationsPropertyEditScriptElementImpl(this.getManager().getCurrentMetaprogramId(), this.getUid(), metaAnnotations.getNodeValue() == null ? null : metaAnnotations.getNodeValue().getUid()));
    }
    
    private void doSetMetaAnnotations(NodeUnion<? extends MetaAnnotationListNode> metaAnnotations)
    {
        if (metaAnnotations == null)
        {
            metaAnnotations = new NormalNodeUnion<MetaAnnotationListNode>(null);
        }
        if (this.metaAnnotations != null)
        {
            setAsChild(this.metaAnnotations.getNodeValue(), false);
        }
        this.metaAnnotations = metaAnnotations;
        setAsChild(metaAnnotations.getNodeValue(), true);
    }
    
    /**
     * Gets the annotations on the package declaration.  This property's value is assumed to be a normal node.
     * @return The annotations on the package declaration.
     * @throws ClassCastException If this property's value is not a normal node.
     */
    public AnnotationListNode getAnnotations()
    {
        checkAnnotationsWrapped();
        if (this.annotations == null)
        {
            return null;
        } else
        {
            return this.annotations.getNormalNode();
        }
    }
    
    /**
     * Gets the annotations on the package declaration.
     * @return The annotations on the package declaration.
     */
    public NodeUnion<? extends AnnotationListNode> getUnionForAnnotations()
    {
        checkAnnotationsWrapped();
        if (this.annotations == null)
        {
            this.annotations = new NormalNodeUnion<AnnotationListNode>(null);
        }
        return this.annotations;
    }
    
    /**
     * Changes the annotations on the package declaration.
     * @param annotations The annotations on the package declaration.
     */
    public void setAnnotations(AnnotationListNode annotations)
    {
        checkAnnotationsWrapped();
        this.setUnionForAnnotations(new NormalNodeUnion<AnnotationListNode>(annotations));
    }
    
    /**
     * Changes the annotations on the package declaration.
     * @param annotations The annotations on the package declaration.
     */
    public void setUnionForAnnotations(NodeUnion<? extends AnnotationListNode> annotations)
    {
        checkAnnotationsWrapped();
        this.getManager().assertMutatable(this);
        this.doSetAnnotations(annotations);
        if (this.getManager().isRecordingEdits())
            super.recordEdit(new PackageDeclarationNodeSetAnnotationsPropertyEditScriptElementImpl(this.getManager().getCurrentMetaprogramId(), this.getUid(), annotations.getNodeValue() == null ? null : annotations.getNodeValue().getUid()));
    }
    
    private void doSetAnnotations(NodeUnion<? extends AnnotationListNode> annotations)
    {
        if (annotations == null)
        {
            annotations = new NormalNodeUnion<AnnotationListNode>(null);
        }
        if (this.annotations != null)
        {
            setAsChild(this.annotations.getNodeValue(), false);
        }
        this.annotations = annotations;
        setAsChild(annotations.getNodeValue(), true);
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
        if (this.getUnionForName().getNodeValue() != null)
        {
            this.getUnionForName().getNodeValue().receive(visitor);
        }
        if (this.getUnionForMetaAnnotations().getNodeValue() != null)
        {
            this.getUnionForMetaAnnotations().getNodeValue().receive(visitor);
        }
        if (this.getUnionForAnnotations().getNodeValue() != null)
        {
            this.getUnionForAnnotations().getNodeValue().receive(visitor);
        }
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
        if (this.getUnionForName().getNodeValue() != null)
        {
            this.getUnionForName().getNodeValue().receiveTyped(visitor);
        }
        if (this.getUnionForMetaAnnotations().getNodeValue() != null)
        {
            this.getUnionForMetaAnnotations().getNodeValue().receiveTyped(visitor);
        }
        if (this.getUnionForAnnotations().getNodeValue() != null)
        {
            this.getUnionForAnnotations().getNodeValue().receiveTyped(visitor);
        }
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
        visitor.visitPackageDeclarationNodeStart(this, true);
        visitor.visitNodeStart(this);
        visitor.visitMetaAnnotatableNodeStart(this);
        visitor.visitDeclarationNodeStart(this);
        visitor.visitStartEnd(this);
        receiveTypedToChildren(visitor);
        visitor.visitStopBegin(this);
        visitor.visitMetaAnnotatableNodeStop(this);
        visitor.visitDeclarationNodeStop(this);
        visitor.visitNodeStop(this);
        visitor.visitPackageDeclarationNodeStop(this, true);
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
        list.add(getUnionForName());
        list.add(getUnionForAnnotations());
        list.add(getUnionForMetaAnnotations());
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
        map.put("name", getUnionForName());
        map.put("annotations", getUnionForAnnotations());
        map.put("metaAnnotations", getUnionForMetaAnnotations());
        return map;
    }
    
    /**
     * Returns an iterator over the children of this node.
     * @see Node#getChildIterator()
     */
    @Override
    public Iterable<? extends Node> getChildIterable()
    {
        return Arrays.asList(new Node[]{getUnionForName().getNodeValue(), getUnionForMetaAnnotations().getNodeValue(), getUnionForAnnotations().getNodeValue()});
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
        sb.append("name=");
        sb.append(this.getUnionForName().getNodeValue() == null? "null" : this.getUnionForName().getNodeValue().getClass().getSimpleName());
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
        return operation.executePackageDeclarationNode(this, p);
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
        return operation.executePackageDeclarationNode(this, p1, p2);
    }
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public PackageDeclarationNode deepCopy(BsjNodeFactory factory)
    {
        NodeUnion<? extends NameNode> nameCopy;
        switch (getUnionForName().getType())
        {
            case NORMAL:
                if (getUnionForName().getNormalNode() == null)
                {
                    nameCopy = factory.<NameNode>makeNormalNodeUnion(null);
                } else
                {
                    nameCopy = factory.makeNormalNodeUnion(getUnionForName().getNormalNode().deepCopy(factory));
                }
                break;
            case SPLICE:
                if (getUnionForName().getSpliceNode() == null)
                {
                    nameCopy = factory.<NameNode>makeSpliceNodeUnion(null);
                } else
                {
                    nameCopy = factory.makeSpliceNodeUnion(getUnionForName().getSpliceNode().deepCopy(factory));
                }
                break;
            default:
                throw new IllegalStateException("Unrecognized union component type: " + getUnionForName().getType());
        }
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
        return factory.makePackageDeclarationNodeWithUnions(
                nameCopy,
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
        
        if (before.equals(this.getUnionForName().getNodeValue()))
        {
            setName((NameNode)after);
            return true;
        }
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
