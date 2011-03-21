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
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.ReferenceTypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.WildcardTypeNode;
import edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeManager;
import edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactory;
import edu.jhu.cs.bsj.compiler.impl.ast.NormalNodeUnion;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.property.WildcardTypeNodeSetBoundPropertyEditScriptElementImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.property.WildcardTypeNodeSetUpperBoundPropertyEditScriptElementImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.properties.WildcardTypeNodeProperties;

@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class WildcardTypeNodeImpl extends NodeImpl implements WildcardTypeNode
{
    /** The wildcard's bound. */
    private NodeUnion<? extends ReferenceTypeNode> bound;
    
    /** Whether or not the wildcard's bound is an upper (<tt>extends</tt>) bound. */
    private boolean upperBound;
    
    /**
     * A set of those properties which have been populated from the backing node.
     * This field is <code>null</code> if <tt>backingNode</tt> is <code>null</code>.
     */
    private Set<WildcardTypeNodeProperties> populatedProperties;
    
    /** General constructor. */
    public WildcardTypeNodeImpl(
            NodeUnion<? extends ReferenceTypeNode> bound,
            boolean upperBound,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation,
            BsjNodeManager manager,
            boolean binary)
    {
        super(startLocation, stopLocation, manager, binary);
        this.populatedProperties = null;
        doSetBound(bound);
        doSetUpperBound(upperBound);
    }
    
    /** Proxy constructor. */
    public WildcardTypeNodeImpl(BsjNodeManager manager, BsjNodeProxyFactory proxyFactory, WildcardTypeNode backingNode)
    {
        super(manager, proxyFactory, backingNode);
        this.populatedProperties = EnumSet.noneOf(WildcardTypeNodeProperties.class);
    }
    
    /** Retrieves this node's backing node (if one exists). */
    protected WildcardTypeNode getBackingNode()
    {
        return (WildcardTypeNode)super.getBackingNode();
    }
    
    /**
     * Ensures that the bound value has been populated from proxy.
     * If this node is not backed by a proxy or if the value has already been
     * populated, this method does nothing.
     */
    private void checkBoundWrapped()
    {
        if (this.populatedProperties == null || this.populatedProperties.contains(
                WildcardTypeNodeProperties.BOUND))
            return;
        this.populatedProperties.add(WildcardTypeNodeProperties.BOUND);
        NodeUnion<? extends ReferenceTypeNode> union = this.getBackingNode().getUnionForBound();
        switch (union.getType())
        {
            case NORMAL:
                union = this.getProxyFactory().makeNormalNodeUnion(
                        this.getProxyFactory().makeReferenceTypeNode(union.getNormalNode()));
                break;
            case SPLICE:
                union = this.getProxyFactory().makeSpliceNodeUnion(
                        this.getProxyFactory().makeSpliceNode(union.getSpliceNode()));
                break;
            default:
                throw new IllegalStateException("Unrecognized union type: " + union.getType());
        }
        this.bound = union;
    }
    
    /**
     * Ensures that the upperBound value has been populated from proxy.
     * If this node is not backed by a proxy or if the value has already been
     * populated, this method does nothing.
     */
    private void checkUpperBoundWrapped()
    {
        if (this.populatedProperties == null || this.populatedProperties.contains(
                WildcardTypeNodeProperties.UPPER_BOUND))
            return;
        this.populatedProperties.add(WildcardTypeNodeProperties.UPPER_BOUND);
        this.upperBound = this.getBackingNode().getUpperBound();
    }
    
    /**
     * Gets the wildcard's bound.  This property's value is assumed to be a normal node.
     * @return The wildcard's bound.
     * @throws ClassCastException If this property's value is not a normal node.
     */
    public ReferenceTypeNode getBound()
    {
        checkBoundWrapped();
        if (this.bound == null)
        {
            return null;
        } else
        {
            return this.bound.getNormalNode();
        }
    }
    
    /**
     * Gets the wildcard's bound.
     * @return The wildcard's bound.
     */
    public NodeUnion<? extends ReferenceTypeNode> getUnionForBound()
    {
        checkBoundWrapped();
        if (this.bound == null)
        {
            this.bound = new NormalNodeUnion<ReferenceTypeNode>(null);
        }
        return this.bound;
    }
    
    /**
     * Changes the wildcard's bound.
     * @param bound The wildcard's bound.
     */
    public void setBound(ReferenceTypeNode bound)
    {
        checkBoundWrapped();
        this.setUnionForBound(new NormalNodeUnion<ReferenceTypeNode>(bound));
    }
    
    /**
     * Changes the wildcard's bound.
     * @param bound The wildcard's bound.
     */
    public void setUnionForBound(NodeUnion<? extends ReferenceTypeNode> bound)
    {
        checkBoundWrapped();
        this.getManager().assertMutatable(this);
        this.doSetBound(bound);
        if (this.getManager().isRecordingEdits())
            super.recordEdit(new WildcardTypeNodeSetBoundPropertyEditScriptElementImpl(this.getManager().getCurrentMetaprogramId(), this.getUid(), bound.getNodeValue() == null ? null : bound.getNodeValue().getUid()));
    }
    
    private void doSetBound(NodeUnion<? extends ReferenceTypeNode> bound)
    {
        if (bound == null)
        {
            bound = new NormalNodeUnion<ReferenceTypeNode>(null);
        }
        if (this.bound != null)
        {
            setAsChild(this.bound.getNodeValue(), false);
        }
        this.bound = bound;
        setAsChild(bound.getNodeValue(), true);
    }
    
    /**
     * Gets whether or not the wildcard's bound is an upper (<tt>extends</tt>) bound.
     * @return Whether or not the wildcard's bound is an upper (<tt>extends</tt>) bound.
     */
    public boolean getUpperBound()
    {
        checkUpperBoundWrapped();
        return this.upperBound;
    }
    
    /**
     * Changes whether or not the wildcard's bound is an upper (<tt>extends</tt>) bound.
     * @param upperBound Whether or not the wildcard's bound is an upper (<tt>extends</tt>) bound.
     */
    public void setUpperBound(boolean upperBound)
    {
        checkUpperBoundWrapped();
        this.getManager().assertMutatable(this);
        this.doSetUpperBound(upperBound);
        if (this.getManager().isRecordingEdits())
            super.recordEdit(new WildcardTypeNodeSetUpperBoundPropertyEditScriptElementImpl(this.getManager().getCurrentMetaprogramId(), this.getUid(), upperBound));
    }
    
    private void doSetUpperBound(boolean upperBound)
    {
        this.upperBound = upperBound;
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
        if (this.getUnionForBound().getNodeValue() != null)
        {
            this.getUnionForBound().getNodeValue().receive(visitor);
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
        if (this.getUnionForBound().getNodeValue() != null)
        {
            this.getUnionForBound().getNodeValue().receiveTyped(visitor);
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
        visitor.visitWildcardTypeNodeStart(this, true);
        visitor.visitNodeStart(this);
        visitor.visitTypeArgumentNodeStart(this);
        visitor.visitStartEnd(this);
        receiveTypedToChildren(visitor);
        visitor.visitStopBegin(this);
        visitor.visitTypeArgumentNodeStop(this);
        visitor.visitNodeStop(this);
        visitor.visitWildcardTypeNodeStop(this, true);
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
        list.add(getUnionForBound());
        list.add(getUpperBound());
        return list;
    }
    
    /**
     * Returns an iterator over the children of this node.
     * @see Node#getChildIterator()
     */
    @Override
    public Iterable<? extends Node> getChildIterable()
    {
        return Arrays.asList(new Node[]{getUnionForBound().getNodeValue()});
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
        sb.append("bound=");
        sb.append(this.getUnionForBound().getNodeValue() == null? "null" : this.getUnionForBound().getNodeValue().getClass().getSimpleName());
        sb.append(',');
        sb.append("upperBound=");
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
        return operation.executeWildcardTypeNode(this, p);
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
        return operation.executeWildcardTypeNode(this, p1, p2);
    }
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public WildcardTypeNode deepCopy(BsjNodeFactory factory)
    {
        NodeUnion<? extends ReferenceTypeNode> boundCopy;
        switch (getUnionForBound().getType())
        {
            case NORMAL:
                if (getUnionForBound().getNormalNode() == null)
                {
                    boundCopy = factory.<ReferenceTypeNode>makeNormalNodeUnion(null);
                } else
                {
                    boundCopy = factory.makeNormalNodeUnion(getUnionForBound().getNormalNode().deepCopy(factory));
                }
                break;
            case SPLICE:
                if (getUnionForBound().getSpliceNode() == null)
                {
                    boundCopy = factory.<ReferenceTypeNode>makeSpliceNodeUnion(null);
                } else
                {
                    boundCopy = factory.makeSpliceNodeUnion(getUnionForBound().getSpliceNode().deepCopy(factory));
                }
                break;
            default:
                throw new IllegalStateException("Unrecognized union component type: " + getUnionForBound().getType());
        }
        return factory.makeWildcardTypeNodeWithUnions(
                boundCopy,
                getUpperBound(),
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
        
        if (before.equals(this.getUnionForBound().getNodeValue()))
        {
            setBound((ReferenceTypeNode)after);
            return true;
        }
        return false;
    }
    
}
