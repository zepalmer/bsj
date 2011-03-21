package edu.jhu.cs.bsj.compiler.impl.ast.node.meta;

import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.BsjTypedNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.NodeUnion;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.meta.ExplicitMetaprogramAnchorNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramNode;
import edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeManager;
import edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactory;
import edu.jhu.cs.bsj.compiler.impl.ast.NormalNodeUnion;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.property.ExplicitMetaprogramAnchorNodeSetMetaprogramPropertyEditScriptElementImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.properties.ExplicitMetaprogramAnchorNodeProperties;

@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public abstract class ExplicitMetaprogramAnchorNodeImpl<T extends Node> extends MetaprogramAnchorNodeImpl<T> implements ExplicitMetaprogramAnchorNode<T>
{
    /** The metaprogram on this node. */
    private NodeUnion<? extends MetaprogramNode> metaprogram;
    
    /**
     * A set of those properties which have been populated from the backing node.
     * This field is <code>null</code> if <tt>backingNode</tt> is <code>null</code>.
     */
    private Set<ExplicitMetaprogramAnchorNodeProperties> populatedProperties;
    
    /** General constructor. */
    protected ExplicitMetaprogramAnchorNodeImpl(
            NodeUnion<? extends MetaprogramNode> metaprogram,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation,
            BsjNodeManager manager,
            boolean binary)
    {
        super(startLocation, stopLocation, manager, binary);
        this.populatedProperties = null;
        doSetMetaprogram(metaprogram);
    }
    
    /** Proxy constructor. */
    protected ExplicitMetaprogramAnchorNodeImpl(BsjNodeManager manager, BsjNodeProxyFactory proxyFactory, ExplicitMetaprogramAnchorNode<T> backingNode)
    {
        super(manager, proxyFactory, backingNode);
        this.populatedProperties = EnumSet.noneOf(ExplicitMetaprogramAnchorNodeProperties.class);
    }
    
    /** Retrieves this node's backing node (if one exists). */
    protected ExplicitMetaprogramAnchorNode<T> getBackingNode()
    {
        return (ExplicitMetaprogramAnchorNode<T>)super.getBackingNode();
    }
    
    /**
     * Ensures that the metaprogram value has been populated from proxy.
     * If this node is not backed by a proxy or if the value has already been
     * populated, this method does nothing.
     */
    private void checkMetaprogramWrapped()
    {
        if (this.populatedProperties == null || this.populatedProperties.contains(
                ExplicitMetaprogramAnchorNodeProperties.METAPROGRAM))
            return;
        this.populatedProperties.add(ExplicitMetaprogramAnchorNodeProperties.METAPROGRAM);
        NodeUnion<? extends MetaprogramNode> union = this.getBackingNode().getUnionForMetaprogram();
        switch (union.getType())
        {
            case NORMAL:
                union = this.getProxyFactory().makeNormalNodeUnion(
                        this.getProxyFactory().makeMetaprogramNode(union.getNormalNode()));
                break;
            case SPLICE:
                union = this.getProxyFactory().makeSpliceNodeUnion(
                        this.getProxyFactory().makeSpliceNode(union.getSpliceNode()));
                break;
            default:
                throw new IllegalStateException("Unrecognized union type: " + union.getType());
        }
        this.metaprogram = union;
    }
    
    /**
     * Gets the metaprogram on this node.  This property's value is assumed to be a normal node.
     * @return The metaprogram on this node.
     * @throws ClassCastException If this property's value is not a normal node.
     */
    public MetaprogramNode getMetaprogram()
    {
        checkMetaprogramWrapped();
        if (this.metaprogram == null)
        {
            return null;
        } else
        {
            return this.metaprogram.getNormalNode();
        }
    }
    
    /**
     * Gets the metaprogram on this node.
     * @return The metaprogram on this node.
     */
    public NodeUnion<? extends MetaprogramNode> getUnionForMetaprogram()
    {
        checkMetaprogramWrapped();
        if (this.metaprogram == null)
        {
            this.metaprogram = new NormalNodeUnion<MetaprogramNode>(null);
        }
        return this.metaprogram;
    }
    
    /**
     * Changes the metaprogram on this node.
     * @param metaprogram The metaprogram on this node.
     */
    public void setMetaprogram(MetaprogramNode metaprogram)
    {
        checkMetaprogramWrapped();
        this.setUnionForMetaprogram(new NormalNodeUnion<MetaprogramNode>(metaprogram));
    }
    
    /**
     * Changes the metaprogram on this node.
     * @param metaprogram The metaprogram on this node.
     */
    public void setUnionForMetaprogram(NodeUnion<? extends MetaprogramNode> metaprogram)
    {
        checkMetaprogramWrapped();
        this.getManager().assertMutatable(this);
        this.doSetMetaprogram(metaprogram);
        if (this.getManager().isRecordingEdits())
            super.recordEdit(new ExplicitMetaprogramAnchorNodeSetMetaprogramPropertyEditScriptElementImpl(this.getManager().getCurrentMetaprogramId(), this.getUid(), metaprogram.getNodeValue() == null ? null : metaprogram.getNodeValue().getUid()));
    }
    
    private void doSetMetaprogram(NodeUnion<? extends MetaprogramNode> metaprogram)
    {
        if (metaprogram == null)
        {
            metaprogram = new NormalNodeUnion<MetaprogramNode>(null);
        }
        if (this.metaprogram != null)
        {
            setAsChild(this.metaprogram.getNodeValue(), false);
        }
        this.metaprogram = metaprogram;
        setAsChild(metaprogram.getNodeValue(), true);
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
        if (this.getUnionForMetaprogram().getNodeValue() != null)
        {
            this.getUnionForMetaprogram().getNodeValue().receive(visitor);
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
        if (this.getUnionForMetaprogram().getNodeValue() != null)
        {
            this.getUnionForMetaprogram().getNodeValue().receiveTyped(visitor);
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
        visitor.visitExplicitMetaprogramAnchorNodeStart(this);
        visitor.visitMetaprogramAnchorNodeStart(this);
        visitor.visitNodeStart(this);
        visitor.visitStartEnd(this);
        receiveTypedToChildren(visitor);
        visitor.visitStopBegin(this);
        visitor.visitNodeStop(this);
        visitor.visitMetaprogramAnchorNodeStop(this);
        visitor.visitExplicitMetaprogramAnchorNodeStop(this);
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
        list.add(getUnionForMetaprogram());
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
        sb.append('#');
        sb.append(this.getUid());
        sb.append('[');
        sb.append("metaprogram=");
        sb.append(this.getUnionForMetaprogram().getNodeValue() == null? "null" : this.getUnionForMetaprogram().getNodeValue().getClass().getSimpleName());
        sb.append(',');
        sb.append("startLocation=");
        sb.append(String.valueOf(this.getStartLocation()) + ":" + (this.getStartLocation() != null ? this.getStartLocation().getClass().getSimpleName() : "null"));
        sb.append(',');
        sb.append("stopLocation=");
        sb.append(String.valueOf(this.getStopLocation()) + ":" + (this.getStopLocation() != null ? this.getStopLocation().getClass().getSimpleName() : "null"));
        sb.append(']');
        return sb.toString();
    }
    
    
    
}
