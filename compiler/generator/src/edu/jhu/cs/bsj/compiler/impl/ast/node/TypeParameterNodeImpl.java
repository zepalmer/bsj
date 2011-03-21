package edu.jhu.cs.bsj.compiler.impl.ast.node;

import java.util.Arrays;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjAbortableNodeOperation;
import edu.jhu.cs.bsj.compiler.ast.BsjAbortableNodeOperation2Arguments;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.BsjTypedNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.NodeUnion;
import edu.jhu.cs.bsj.compiler.ast.node.IdentifierNode;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.TypeParameterNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.DeclaredTypeListNode;
import edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeManager;
import edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactory;
import edu.jhu.cs.bsj.compiler.impl.ast.NormalNodeUnion;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.property.TypeParameterNodeSetBoundsPropertyEditScriptElementImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.property.TypeParameterNodeSetIdentifierPropertyEditScriptElementImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.properties.TypeParameterNodeProperties;

@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class TypeParameterNodeImpl extends NodeImpl implements TypeParameterNode
{
    /** The base type name for the parameter. */
    private NodeUnion<? extends IdentifierNode> identifier;
    
    /** The bounds over the base type. */
    private NodeUnion<? extends DeclaredTypeListNode> bounds;
    
    /**
     * A set of those properties which have been populated from the backing node.
     * This field is <code>null</code> if <tt>backingNode</tt> is <code>null</code>.
     */
    private Set<TypeParameterNodeProperties> populatedProperties;
    
    /** General constructor. */
    public TypeParameterNodeImpl(
            NodeUnion<? extends IdentifierNode> identifier,
            NodeUnion<? extends DeclaredTypeListNode> bounds,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation,
            BsjNodeManager manager,
            boolean binary)
    {
        super(startLocation, stopLocation, manager, binary);
        this.populatedProperties = null;
        doSetIdentifier(identifier);
        doSetBounds(bounds);
    }
    
    /** Proxy constructor. */
    public TypeParameterNodeImpl(BsjNodeManager manager, BsjNodeProxyFactory proxyFactory, TypeParameterNode backingNode)
    {
        super(manager, proxyFactory, backingNode);
        this.populatedProperties = EnumSet.noneOf(TypeParameterNodeProperties.class);
    }
    
    /** Retrieves this node's backing node (if one exists). */
    protected TypeParameterNode getBackingNode()
    {
        return (TypeParameterNode)super.getBackingNode();
    }
    
    /**
     * Ensures that the identifier value has been populated from proxy.
     * If this node is not backed by a proxy or if the value has already been
     * populated, this method does nothing.
     */
    private void checkIdentifierWrapped()
    {
        if (this.populatedProperties == null || this.populatedProperties.contains(
                TypeParameterNodeProperties.IDENTIFIER))
            return;
        this.populatedProperties.add(TypeParameterNodeProperties.IDENTIFIER);
        NodeUnion<? extends IdentifierNode> union = this.getBackingNode().getUnionForIdentifier();
        switch (union.getType())
        {
            case NORMAL:
                union = this.getProxyFactory().makeNormalNodeUnion(
                        this.getProxyFactory().makeIdentifierNode(union.getNormalNode()));
                break;
            case SPLICE:
                union = this.getProxyFactory().makeSpliceNodeUnion(
                        this.getProxyFactory().makeSpliceNode(union.getSpliceNode()));
                break;
            default:
                throw new IllegalStateException("Unrecognized union type: " + union.getType());
        }
        this.identifier = union;
    }
    
    /**
     * Ensures that the bounds value has been populated from proxy.
     * If this node is not backed by a proxy or if the value has already been
     * populated, this method does nothing.
     */
    private void checkBoundsWrapped()
    {
        if (this.populatedProperties == null || this.populatedProperties.contains(
                TypeParameterNodeProperties.BOUNDS))
            return;
        this.populatedProperties.add(TypeParameterNodeProperties.BOUNDS);
        NodeUnion<? extends DeclaredTypeListNode> union = this.getBackingNode().getUnionForBounds();
        switch (union.getType())
        {
            case NORMAL:
                union = this.getProxyFactory().makeNormalNodeUnion(
                        this.getProxyFactory().makeDeclaredTypeListNode(union.getNormalNode()));
                break;
            case SPLICE:
                union = this.getProxyFactory().makeSpliceNodeUnion(
                        this.getProxyFactory().makeSpliceNode(union.getSpliceNode()));
                break;
            default:
                throw new IllegalStateException("Unrecognized union type: " + union.getType());
        }
        this.bounds = union;
    }
    
    /**
     * Gets the base type name for the parameter.  This property's value is assumed to be a normal node.
     * @return The base type name for the parameter.
     * @throws ClassCastException If this property's value is not a normal node.
     */
    public IdentifierNode getIdentifier()
    {
        checkIdentifierWrapped();
        if (this.identifier == null)
        {
            return null;
        } else
        {
            return this.identifier.getNormalNode();
        }
    }
    
    /**
     * Gets the base type name for the parameter.
     * @return The base type name for the parameter.
     */
    public NodeUnion<? extends IdentifierNode> getUnionForIdentifier()
    {
        checkIdentifierWrapped();
        if (this.identifier == null)
        {
            this.identifier = new NormalNodeUnion<IdentifierNode>(null);
        }
        return this.identifier;
    }
    
    /**
     * Changes the base type name for the parameter.
     * @param identifier The base type name for the parameter.
     */
    public void setIdentifier(IdentifierNode identifier)
    {
        checkIdentifierWrapped();
        this.setUnionForIdentifier(new NormalNodeUnion<IdentifierNode>(identifier));
    }
    
    /**
     * Changes the base type name for the parameter.
     * @param identifier The base type name for the parameter.
     */
    public void setUnionForIdentifier(NodeUnion<? extends IdentifierNode> identifier)
    {
        checkIdentifierWrapped();
        this.getManager().assertMutatable(this);
        this.doSetIdentifier(identifier);
        if (this.getManager().isRecordingEdits())
            super.recordEdit(new TypeParameterNodeSetIdentifierPropertyEditScriptElementImpl(this.getManager().getCurrentMetaprogramId(), this.getUid(), identifier.getNodeValue() == null ? null : identifier.getNodeValue().getUid()));
    }
    
    private void doSetIdentifier(NodeUnion<? extends IdentifierNode> identifier)
    {
        if (identifier == null)
        {
            identifier = new NormalNodeUnion<IdentifierNode>(null);
        }
        if (this.identifier != null)
        {
            setAsChild(this.identifier.getNodeValue(), false);
        }
        this.identifier = identifier;
        setAsChild(identifier.getNodeValue(), true);
    }
    
    /**
     * Gets the bounds over the base type.  This property's value is assumed to be a normal node.
     * @return The bounds over the base type.
     * @throws ClassCastException If this property's value is not a normal node.
     */
    public DeclaredTypeListNode getBounds()
    {
        checkBoundsWrapped();
        if (this.bounds == null)
        {
            return null;
        } else
        {
            return this.bounds.getNormalNode();
        }
    }
    
    /**
     * Gets the bounds over the base type.
     * @return The bounds over the base type.
     */
    public NodeUnion<? extends DeclaredTypeListNode> getUnionForBounds()
    {
        checkBoundsWrapped();
        if (this.bounds == null)
        {
            this.bounds = new NormalNodeUnion<DeclaredTypeListNode>(null);
        }
        return this.bounds;
    }
    
    /**
     * Changes the bounds over the base type.
     * @param bounds The bounds over the base type.
     */
    public void setBounds(DeclaredTypeListNode bounds)
    {
        checkBoundsWrapped();
        this.setUnionForBounds(new NormalNodeUnion<DeclaredTypeListNode>(bounds));
    }
    
    /**
     * Changes the bounds over the base type.
     * @param bounds The bounds over the base type.
     */
    public void setUnionForBounds(NodeUnion<? extends DeclaredTypeListNode> bounds)
    {
        checkBoundsWrapped();
        this.getManager().assertMutatable(this);
        this.doSetBounds(bounds);
        if (this.getManager().isRecordingEdits())
            super.recordEdit(new TypeParameterNodeSetBoundsPropertyEditScriptElementImpl(this.getManager().getCurrentMetaprogramId(), this.getUid(), bounds.getNodeValue() == null ? null : bounds.getNodeValue().getUid()));
    }
    
    private void doSetBounds(NodeUnion<? extends DeclaredTypeListNode> bounds)
    {
        if (bounds == null)
        {
            bounds = new NormalNodeUnion<DeclaredTypeListNode>(null);
        }
        if (this.bounds != null)
        {
            setAsChild(this.bounds.getNodeValue(), false);
        }
        this.bounds = bounds;
        setAsChild(bounds.getNodeValue(), true);
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
        if (this.getUnionForIdentifier().getNodeValue() != null)
        {
            this.getUnionForIdentifier().getNodeValue().receive(visitor);
        }
        if (this.getUnionForBounds().getNodeValue() != null)
        {
            this.getUnionForBounds().getNodeValue().receive(visitor);
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
        if (this.getUnionForIdentifier().getNodeValue() != null)
        {
            this.getUnionForIdentifier().getNodeValue().receiveTyped(visitor);
        }
        if (this.getUnionForBounds().getNodeValue() != null)
        {
            this.getUnionForBounds().getNodeValue().receiveTyped(visitor);
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
        visitor.visitTypeParameterNodeStart(this, true);
        visitor.visitNodeStart(this);
        visitor.visitTypeNameBindingNodeStart(this);
        visitor.visitStartEnd(this);
        receiveTypedToChildren(visitor);
        visitor.visitStopBegin(this);
        visitor.visitTypeNameBindingNodeStop(this);
        visitor.visitNodeStop(this);
        visitor.visitTypeParameterNodeStop(this, true);
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
        list.add(getUnionForIdentifier());
        list.add(getUnionForBounds());
        return list;
    }
    
    /**
     * Returns an iterator over the children of this node.
     * @see Node#getChildIterator()
     */
    @Override
    public Iterable<? extends Node> getChildIterable()
    {
        return Arrays.asList(new Node[]{getUnionForIdentifier().getNodeValue(), getUnionForBounds().getNodeValue()});
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
        sb.append("identifier=");
        sb.append(this.getUnionForIdentifier().getNodeValue() == null? "null" : this.getUnionForIdentifier().getNodeValue().getClass().getSimpleName());
        sb.append(',');
        sb.append("bounds=");
        sb.append(this.getUnionForBounds().getNodeValue() == null? "null" : this.getUnionForBounds().getNodeValue().getClass().getSimpleName());
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
        return operation.executeTypeParameterNode(this, p);
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
        return operation.executeTypeParameterNode(this, p1, p2);
    }
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public TypeParameterNode deepCopy(BsjNodeFactory factory)
    {
        NodeUnion<? extends IdentifierNode> identifierCopy;
        switch (getUnionForIdentifier().getType())
        {
            case NORMAL:
                if (getUnionForIdentifier().getNormalNode() == null)
                {
                    identifierCopy = factory.<IdentifierNode>makeNormalNodeUnion(null);
                } else
                {
                    identifierCopy = factory.makeNormalNodeUnion(getUnionForIdentifier().getNormalNode().deepCopy(factory));
                }
                break;
            case SPLICE:
                if (getUnionForIdentifier().getSpliceNode() == null)
                {
                    identifierCopy = factory.<IdentifierNode>makeSpliceNodeUnion(null);
                } else
                {
                    identifierCopy = factory.makeSpliceNodeUnion(getUnionForIdentifier().getSpliceNode().deepCopy(factory));
                }
                break;
            default:
                throw new IllegalStateException("Unrecognized union component type: " + getUnionForIdentifier().getType());
        }
        NodeUnion<? extends DeclaredTypeListNode> boundsCopy;
        switch (getUnionForBounds().getType())
        {
            case NORMAL:
                if (getUnionForBounds().getNormalNode() == null)
                {
                    boundsCopy = factory.<DeclaredTypeListNode>makeNormalNodeUnion(null);
                } else
                {
                    boundsCopy = factory.makeNormalNodeUnion(getUnionForBounds().getNormalNode().deepCopy(factory));
                }
                break;
            case SPLICE:
                if (getUnionForBounds().getSpliceNode() == null)
                {
                    boundsCopy = factory.<DeclaredTypeListNode>makeSpliceNodeUnion(null);
                } else
                {
                    boundsCopy = factory.makeSpliceNodeUnion(getUnionForBounds().getSpliceNode().deepCopy(factory));
                }
                break;
            default:
                throw new IllegalStateException("Unrecognized union component type: " + getUnionForBounds().getType());
        }
        return factory.makeTypeParameterNodeWithUnions(
                identifierCopy,
                boundsCopy,
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
        
        if (before.equals(this.getUnionForIdentifier().getNodeValue()))
        {
            setIdentifier((IdentifierNode)after);
            return true;
        }
        if (before.equals(this.getUnionForBounds().getNodeValue()))
        {
            setBounds((DeclaredTypeListNode)after);
            return true;
        }
        return false;
    }
    
}
