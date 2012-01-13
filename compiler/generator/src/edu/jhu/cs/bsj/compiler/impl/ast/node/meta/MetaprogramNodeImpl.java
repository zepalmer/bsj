package edu.jhu.cs.bsj.compiler.impl.ast.node.meta;

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
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.list.BlockStatementListNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramPreambleNode;
import edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeManager;
import edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactory;
import edu.jhu.cs.bsj.compiler.impl.ast.NormalNodeUnion;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.property.MetaprogramNodeSetBodyPropertyEditScriptElementImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.property.MetaprogramNodeSetPreamblePropertyEditScriptElementImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.NodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.properties.MetaprogramNodeProperties;

@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class MetaprogramNodeImpl extends NodeImpl implements MetaprogramNode
{
    /** The preamble for this metaprogram. */
    private NodeUnion<? extends MetaprogramPreambleNode> preamble;
    
    /** The list of statements in the metaprogram's body. */
    private NodeUnion<? extends BlockStatementListNode> body;
    
    /**
     * A set of those properties which have been populated from the backing node.
     * This field is <code>null</code> if <tt>backingNode</tt> is <code>null</code>.
     */
    private Set<MetaprogramNodeProperties> populatedProperties;
    
    /** General constructor. */
    public MetaprogramNodeImpl(
            NodeUnion<? extends MetaprogramPreambleNode> preamble,
            NodeUnion<? extends BlockStatementListNode> body,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation,
            BsjNodeManager manager,
            boolean binary)
    {
        super(startLocation, stopLocation, manager, binary);
        this.populatedProperties = null;
        doSetPreamble(preamble);
        doSetBody(body);
    }
    
    /** Proxy constructor. */
    public MetaprogramNodeImpl(BsjNodeManager manager, BsjNodeProxyFactory proxyFactory, MetaprogramNode backingNode)
    {
        super(manager, proxyFactory, backingNode);
        this.populatedProperties = EnumSet.noneOf(MetaprogramNodeProperties.class);
    }
    
    /** Retrieves this node's backing node (if one exists). */
    protected MetaprogramNode getBackingNode()
    {
        return (MetaprogramNode)super.getBackingNode();
    }
    
    /**
     * Ensures that the preamble value has been populated from proxy.
     * If this node is not backed by a proxy or if the value has already been
     * populated, this method does nothing.
     */
    private void checkPreambleWrapped()
    {
        if (this.populatedProperties == null || this.populatedProperties.contains(
                MetaprogramNodeProperties.PREAMBLE))
            return;
        this.populatedProperties.add(MetaprogramNodeProperties.PREAMBLE);
        NodeUnion<? extends MetaprogramPreambleNode> union = this.getBackingNode().getUnionForPreamble();
        switch (union.getType())
        {
            case NORMAL:
                union = this.getProxyFactory().makeNormalNodeUnion(
                        this.getProxyFactory().makeMetaprogramPreambleNode(union.getNormalNode()));
                break;
            case SPLICE:
                union = this.getProxyFactory().makeSpliceNodeUnion(
                        this.getProxyFactory().makeSpliceNode(union.getSpliceNode()));
                break;
            default:
                throw new IllegalStateException("Unrecognized union type: " + union.getType());
        }
        this.preamble = union;
    }
    
    /**
     * Ensures that the body value has been populated from proxy.
     * If this node is not backed by a proxy or if the value has already been
     * populated, this method does nothing.
     */
    private void checkBodyWrapped()
    {
        if (this.populatedProperties == null || this.populatedProperties.contains(
                MetaprogramNodeProperties.BODY))
            return;
        this.populatedProperties.add(MetaprogramNodeProperties.BODY);
        NodeUnion<? extends BlockStatementListNode> union = this.getBackingNode().getUnionForBody();
        switch (union.getType())
        {
            case NORMAL:
                union = this.getProxyFactory().makeNormalNodeUnion(
                        this.getProxyFactory().makeBlockStatementListNode(union.getNormalNode()));
                break;
            case SPLICE:
                union = this.getProxyFactory().makeSpliceNodeUnion(
                        this.getProxyFactory().makeSpliceNode(union.getSpliceNode()));
                break;
            default:
                throw new IllegalStateException("Unrecognized union type: " + union.getType());
        }
        this.body = union;
    }
    
    /**
     * Gets the preamble for this metaprogram.  This property's value is assumed to be a normal node.
     * @return The preamble for this metaprogram.
     * @throws ClassCastException If this property's value is not a normal node.
     */
    public MetaprogramPreambleNode getPreamble()
    {
        checkPreambleWrapped();
        if (this.preamble == null)
        {
            return null;
        } else
        {
            return this.preamble.getNormalNode();
        }
    }
    
    /**
     * Gets the preamble for this metaprogram.
     * @return The preamble for this metaprogram.
     */
    public NodeUnion<? extends MetaprogramPreambleNode> getUnionForPreamble()
    {
        checkPreambleWrapped();
        if (this.preamble == null)
        {
            this.preamble = new NormalNodeUnion<MetaprogramPreambleNode>(null);
        }
        return this.preamble;
    }
    
    /**
     * Changes the preamble for this metaprogram.
     * @param preamble The preamble for this metaprogram.
     */
    public void setPreamble(MetaprogramPreambleNode preamble)
    {
        checkPreambleWrapped();
        this.setUnionForPreamble(new NormalNodeUnion<MetaprogramPreambleNode>(preamble));
    }
    
    /**
     * Changes the preamble for this metaprogram.
     * @param preamble The preamble for this metaprogram.
     */
    public void setUnionForPreamble(NodeUnion<? extends MetaprogramPreambleNode> preamble)
    {
        checkPreambleWrapped();
        this.getManager().assertMutatable(this);
        this.doSetPreamble(preamble);
        if (this.getManager().isRecordingEdits())
            super.recordEdit(new MetaprogramNodeSetPreamblePropertyEditScriptElementImpl(this.getManager().getCurrentMetaprogramId(), this.getUid(), preamble.getNodeValue() == null ? null : preamble.getNodeValue().getUid()));
    }
    
    private void doSetPreamble(NodeUnion<? extends MetaprogramPreambleNode> preamble)
    {
        if (preamble == null)
        {
            preamble = new NormalNodeUnion<MetaprogramPreambleNode>(null);
        }
        if (this.preamble != null)
        {
            setAsChild(this.preamble.getNodeValue(), false);
        }
        this.preamble = preamble;
        setAsChild(preamble.getNodeValue(), true);
    }
    
    /**
     * Gets the list of statements in the metaprogram's body.  This property's value is assumed to be a normal node.
     * @return The list of statements in the metaprogram's body.
     * @throws ClassCastException If this property's value is not a normal node.
     */
    public BlockStatementListNode getBody()
    {
        checkBodyWrapped();
        if (this.body == null)
        {
            return null;
        } else
        {
            return this.body.getNormalNode();
        }
    }
    
    /**
     * Gets the list of statements in the metaprogram's body.
     * @return The list of statements in the metaprogram's body.
     */
    public NodeUnion<? extends BlockStatementListNode> getUnionForBody()
    {
        checkBodyWrapped();
        if (this.body == null)
        {
            this.body = new NormalNodeUnion<BlockStatementListNode>(null);
        }
        return this.body;
    }
    
    /**
     * Changes the list of statements in the metaprogram's body.
     * @param body The list of statements in the metaprogram's body.
     */
    public void setBody(BlockStatementListNode body)
    {
        checkBodyWrapped();
        this.setUnionForBody(new NormalNodeUnion<BlockStatementListNode>(body));
    }
    
    /**
     * Changes the list of statements in the metaprogram's body.
     * @param body The list of statements in the metaprogram's body.
     */
    public void setUnionForBody(NodeUnion<? extends BlockStatementListNode> body)
    {
        checkBodyWrapped();
        this.getManager().assertMutatable(this);
        this.doSetBody(body);
        if (this.getManager().isRecordingEdits())
            super.recordEdit(new MetaprogramNodeSetBodyPropertyEditScriptElementImpl(this.getManager().getCurrentMetaprogramId(), this.getUid(), body.getNodeValue() == null ? null : body.getNodeValue().getUid()));
    }
    
    private void doSetBody(NodeUnion<? extends BlockStatementListNode> body)
    {
        if (body == null)
        {
            body = new NormalNodeUnion<BlockStatementListNode>(null);
        }
        if (this.body != null)
        {
            setAsChild(this.body.getNodeValue(), false);
        }
        this.body = body;
        setAsChild(body.getNodeValue(), true);
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
        if (this.getUnionForPreamble().getNodeValue() != null)
        {
            this.getUnionForPreamble().getNodeValue().receive(visitor);
        }
        if (this.getUnionForBody().getNodeValue() != null)
        {
            this.getUnionForBody().getNodeValue().receive(visitor);
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
        if (this.getUnionForPreamble().getNodeValue() != null)
        {
            this.getUnionForPreamble().getNodeValue().receiveTyped(visitor);
        }
        if (this.getUnionForBody().getNodeValue() != null)
        {
            this.getUnionForBody().getNodeValue().receiveTyped(visitor);
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
        visitor.visitMetaprogramNodeStart(this, true);
        visitor.visitNodeStart(this);
        visitor.visitStartEnd(this);
        receiveTypedToChildren(visitor);
        visitor.visitStopBegin(this);
        visitor.visitNodeStop(this);
        visitor.visitMetaprogramNodeStop(this, true);
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
        list.add(getUnionForPreamble());
        list.add(getUnionForBody());
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
        map.put("preamble", getUnionForPreamble());
        map.put("body", getUnionForBody());
        return map;
    }
    
    /**
     * Returns an iterator over the children of this node.
     * @see Node#getChildIterator()
     */
    @Override
    public Iterable<? extends Node> getChildIterable()
    {
        return Arrays.asList(new Node[]{getUnionForPreamble().getNodeValue(), getUnionForBody().getNodeValue()});
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
        sb.append("preamble=");
        sb.append(this.getUnionForPreamble().getNodeValue() == null? "null" : this.getUnionForPreamble().getNodeValue().getClass().getSimpleName());
        sb.append(',');
        sb.append("body=");
        sb.append(this.getUnionForBody().getNodeValue() == null? "null" : this.getUnionForBody().getNodeValue().getClass().getSimpleName());
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
        return operation.executeMetaprogramNode(this, p);
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
        return operation.executeMetaprogramNode(this, p1, p2);
    }
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public MetaprogramNode deepCopy(BsjNodeFactory factory)
    {
        NodeUnion<? extends MetaprogramPreambleNode> preambleCopy;
        switch (getUnionForPreamble().getType())
        {
            case NORMAL:
                if (getUnionForPreamble().getNormalNode() == null)
                {
                    preambleCopy = factory.<MetaprogramPreambleNode>makeNormalNodeUnion(null);
                } else
                {
                    preambleCopy = factory.makeNormalNodeUnion(getUnionForPreamble().getNormalNode().deepCopy(factory));
                }
                break;
            case SPLICE:
                if (getUnionForPreamble().getSpliceNode() == null)
                {
                    preambleCopy = factory.<MetaprogramPreambleNode>makeSpliceNodeUnion(null);
                } else
                {
                    preambleCopy = factory.makeSpliceNodeUnion(getUnionForPreamble().getSpliceNode().deepCopy(factory));
                }
                break;
            default:
                throw new IllegalStateException("Unrecognized union component type: " + getUnionForPreamble().getType());
        }
        NodeUnion<? extends BlockStatementListNode> bodyCopy;
        switch (getUnionForBody().getType())
        {
            case NORMAL:
                if (getUnionForBody().getNormalNode() == null)
                {
                    bodyCopy = factory.<BlockStatementListNode>makeNormalNodeUnion(null);
                } else
                {
                    bodyCopy = factory.makeNormalNodeUnion(getUnionForBody().getNormalNode().deepCopy(factory));
                }
                break;
            case SPLICE:
                if (getUnionForBody().getSpliceNode() == null)
                {
                    bodyCopy = factory.<BlockStatementListNode>makeSpliceNodeUnion(null);
                } else
                {
                    bodyCopy = factory.makeSpliceNodeUnion(getUnionForBody().getSpliceNode().deepCopy(factory));
                }
                break;
            default:
                throw new IllegalStateException("Unrecognized union component type: " + getUnionForBody().getType());
        }
        return factory.makeMetaprogramNodeWithUnions(
                preambleCopy,
                bodyCopy,
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
        
        if (before.equals(this.getUnionForPreamble().getNodeValue()))
        {
            setPreamble((MetaprogramPreambleNode)after);
            return true;
        }
        if (before.equals(this.getUnionForBody().getNodeValue()))
        {
            setBody((BlockStatementListNode)after);
            return true;
        }
        return false;
    }
    
}
