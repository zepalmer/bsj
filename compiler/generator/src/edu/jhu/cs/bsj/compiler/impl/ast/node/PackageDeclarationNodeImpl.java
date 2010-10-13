package edu.jhu.cs.bsj.compiler.impl.ast.node;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeOperation;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeOperation2Arguments;
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
import edu.jhu.cs.bsj.compiler.impl.ast.NormalNodeUnion;
import edu.jhu.cs.bsj.compiler.impl.ast.attribute.ReadWriteAttribute;

@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class PackageDeclarationNodeImpl extends NodeImpl implements PackageDeclarationNode
{
    /** The name of the package. */
    private NodeUnion<? extends NameNode> name;
    
    /** The meta-annotations on the package declaration. */
    private NodeUnion<? extends MetaAnnotationListNode> metaAnnotations;
    
    /** The annotations on the package declaration. */
    private NodeUnion<? extends AnnotationListNode> annotations;
    
    private Map<LocalAttribute,ReadWriteAttribute> localAttributes = new EnumMap<LocalAttribute,ReadWriteAttribute>(LocalAttribute.class);
    private ReadWriteAttribute getAttribute(LocalAttribute attributeName)
    {
        ReadWriteAttribute attribute = localAttributes.get(attributeName);
        if (attribute == null)
        {
            attribute = new ReadWriteAttribute(PackageDeclarationNodeImpl.this);
            localAttributes.put(attributeName, attribute);
        }
        return attribute;
    }
    private static enum LocalAttribute
    {
        /** Attribute identifier for the name property. */
        NAME,
        /** Attribute identifier for the metaAnnotations property. */
        META_ANNOTATIONS,
        /** Attribute identifier for the annotations property. */
        ANNOTATIONS,
    }
    
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
        setUnionForName(name, false);
        setUnionForMetaAnnotations(metaAnnotations, false);
        setUnionForAnnotations(annotations, false);
    }
    
    /**
     * Gets the name of the package.  This property's value is assumed to be a normal node.
     * @return The name of the package.
     * @throws ClassCastException If this property's value is not a normal node.
     */
    public NameNode getName()
    {
        getAttribute(LocalAttribute.NAME).recordAccess(ReadWriteAttribute.AccessType.READ);
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
        getAttribute(LocalAttribute.NAME).recordAccess(ReadWriteAttribute.AccessType.READ);
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
            setName(name, true);
            getManager().notifyChange(this);
    }
    
    private void setName(NameNode name, boolean checkPermissions)
    {
        if (checkPermissions)
        {
            getManager().assertMutatable(this);
            getAttribute(LocalAttribute.NAME).recordAccess(ReadWriteAttribute.AccessType.WRITE);
        }
        
        if (this.name != null)
        {
            setAsChild(this.name.getNodeValue(), false);
        }
        this.name = new NormalNodeUnion<NameNode>(name);
        setAsChild(name, true);
    }
    
    /**
     * Changes the name of the package.
     * @param name The name of the package.
     */
    public void setUnionForName(NodeUnion<? extends NameNode> name)
    {
            setUnionForName(name, true);
            getManager().notifyChange(this);
    }
    
    private void setUnionForName(NodeUnion<? extends NameNode> name, boolean checkPermissions)
    {
        if (checkPermissions)
        {
            getManager().assertMutatable(this);
            getAttribute(LocalAttribute.NAME).recordAccess(ReadWriteAttribute.AccessType.WRITE);
        }
        
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
        getAttribute(LocalAttribute.META_ANNOTATIONS).recordAccess(ReadWriteAttribute.AccessType.READ);
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
        getAttribute(LocalAttribute.META_ANNOTATIONS).recordAccess(ReadWriteAttribute.AccessType.READ);
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
            setMetaAnnotations(metaAnnotations, true);
            getManager().notifyChange(this);
    }
    
    private void setMetaAnnotations(MetaAnnotationListNode metaAnnotations, boolean checkPermissions)
    {
        if (checkPermissions)
        {
            getManager().assertMutatable(this);
            getAttribute(LocalAttribute.META_ANNOTATIONS).recordAccess(ReadWriteAttribute.AccessType.WRITE);
        }
        
        if (this.metaAnnotations != null)
        {
            setAsChild(this.metaAnnotations.getNodeValue(), false);
        }
        this.metaAnnotations = new NormalNodeUnion<MetaAnnotationListNode>(metaAnnotations);
        setAsChild(metaAnnotations, true);
    }
    
    /**
     * Changes the meta-annotations on the package declaration.
     * @param metaAnnotations The meta-annotations on the package declaration.
     */
    public void setUnionForMetaAnnotations(NodeUnion<? extends MetaAnnotationListNode> metaAnnotations)
    {
            setUnionForMetaAnnotations(metaAnnotations, true);
            getManager().notifyChange(this);
    }
    
    private void setUnionForMetaAnnotations(NodeUnion<? extends MetaAnnotationListNode> metaAnnotations, boolean checkPermissions)
    {
        if (checkPermissions)
        {
            getManager().assertMutatable(this);
            getAttribute(LocalAttribute.META_ANNOTATIONS).recordAccess(ReadWriteAttribute.AccessType.WRITE);
        }
        
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
        getAttribute(LocalAttribute.ANNOTATIONS).recordAccess(ReadWriteAttribute.AccessType.READ);
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
        getAttribute(LocalAttribute.ANNOTATIONS).recordAccess(ReadWriteAttribute.AccessType.READ);
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
            setAnnotations(annotations, true);
            getManager().notifyChange(this);
    }
    
    private void setAnnotations(AnnotationListNode annotations, boolean checkPermissions)
    {
        if (checkPermissions)
        {
            getManager().assertMutatable(this);
            getAttribute(LocalAttribute.ANNOTATIONS).recordAccess(ReadWriteAttribute.AccessType.WRITE);
        }
        
        if (this.annotations != null)
        {
            setAsChild(this.annotations.getNodeValue(), false);
        }
        this.annotations = new NormalNodeUnion<AnnotationListNode>(annotations);
        setAsChild(annotations, true);
    }
    
    /**
     * Changes the annotations on the package declaration.
     * @param annotations The annotations on the package declaration.
     */
    public void setUnionForAnnotations(NodeUnion<? extends AnnotationListNode> annotations)
    {
            setUnionForAnnotations(annotations, true);
            getManager().notifyChange(this);
    }
    
    private void setUnionForAnnotations(NodeUnion<? extends AnnotationListNode> annotations, boolean checkPermissions)
    {
        if (checkPermissions)
        {
            getManager().assertMutatable(this);
            getAttribute(LocalAttribute.ANNOTATIONS).recordAccess(ReadWriteAttribute.AccessType.WRITE);
        }
        
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
        if (this.name.getNodeValue() != null)
        {
            this.name.getNodeValue().receive(visitor);
        }
        if (this.metaAnnotations.getNodeValue() != null)
        {
            this.metaAnnotations.getNodeValue().receive(visitor);
        }
        if (this.annotations.getNodeValue() != null)
        {
            this.annotations.getNodeValue().receive(visitor);
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
        if (this.name.getNodeValue() != null)
        {
            this.name.getNodeValue().receiveTyped(visitor);
        }
        if (this.metaAnnotations.getNodeValue() != null)
        {
            this.metaAnnotations.getNodeValue().receiveTyped(visitor);
        }
        if (this.annotations.getNodeValue() != null)
        {
            this.annotations.getNodeValue().receiveTyped(visitor);
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
    public <P,R> R executeOperation(BsjNodeOperation<P,R> operation, P p)
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
    public <P1,P2,R> R executeOperation(BsjNodeOperation2Arguments<P1,P2,R> operation, P1 p1, P2 p2)
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
