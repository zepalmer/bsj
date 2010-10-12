package edu.jhu.cs.bsj.compiler.impl.ast.node.meta;

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
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.list.BlockStatementListNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramPreambleNode;
import edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeManager;
import edu.jhu.cs.bsj.compiler.impl.ast.NormalNodeUnion;
import edu.jhu.cs.bsj.compiler.impl.ast.attribute.ReadWriteAttribute;
import edu.jhu.cs.bsj.compiler.impl.ast.node.NodeImpl;

@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class MetaprogramNodeImpl extends NodeImpl implements MetaprogramNode
{
    /** The preamble for this metaprogram. */
    private NodeUnion<? extends MetaprogramPreambleNode> preamble;
    
    /** The list of statements in the metaprogram's body. */
    private NodeUnion<? extends BlockStatementListNode> body;
    
    private Map<LocalAttribute,ReadWriteAttribute> localAttributes = new EnumMap<LocalAttribute,ReadWriteAttribute>(LocalAttribute.class);
    private ReadWriteAttribute getAttribute(LocalAttribute attributeName)
    {
        ReadWriteAttribute attribute = localAttributes.get(attributeName);
        if (attribute == null)
        {
            attribute = new ReadWriteAttribute(MetaprogramNodeImpl.this);
            localAttributes.put(attributeName, attribute);
        }
        return attribute;
    }
    private static enum LocalAttribute
    {
        /** Attribute identifier for the preamble property. */
        PREAMBLE,
        /** Attribute identifier for the body property. */
        BODY,
    }
    
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
        setUnionForPreamble(preamble, false);
        setUnionForBody(body, false);
    }
    
    /**
     * Gets the preamble for this metaprogram.  This property's value is assumed to be a normal node.
     * @return The preamble for this metaprogram.
     * @throws ClassCastException If this property's value is not a normal node.
     */
    public MetaprogramPreambleNode getPreamble()
    {
        getAttribute(LocalAttribute.PREAMBLE).recordAccess(ReadWriteAttribute.AccessType.READ);
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
        getAttribute(LocalAttribute.PREAMBLE).recordAccess(ReadWriteAttribute.AccessType.READ);
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
            setPreamble(preamble, true);
            getManager().notifyChange(this);
    }
    
    private void setPreamble(MetaprogramPreambleNode preamble, boolean checkPermissions)
    {
        if (checkPermissions)
        {
            getManager().assertMutatable(this);
            getAttribute(LocalAttribute.PREAMBLE).recordAccess(ReadWriteAttribute.AccessType.WRITE);
        }
        
        if (this.preamble != null)
        {
            setAsChild(this.preamble.getNodeValue(), false);
        }
        this.preamble = new NormalNodeUnion<MetaprogramPreambleNode>(preamble);
        setAsChild(preamble, true);
    }
    
    /**
     * Changes the preamble for this metaprogram.
     * @param preamble The preamble for this metaprogram.
     */
    public void setUnionForPreamble(NodeUnion<? extends MetaprogramPreambleNode> preamble)
    {
            setUnionForPreamble(preamble, true);
            getManager().notifyChange(this);
    }
    
    private void setUnionForPreamble(NodeUnion<? extends MetaprogramPreambleNode> preamble, boolean checkPermissions)
    {
        if (checkPermissions)
        {
            getManager().assertMutatable(this);
            getAttribute(LocalAttribute.PREAMBLE).recordAccess(ReadWriteAttribute.AccessType.WRITE);
        }
        
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
        getAttribute(LocalAttribute.BODY).recordAccess(ReadWriteAttribute.AccessType.READ);
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
        getAttribute(LocalAttribute.BODY).recordAccess(ReadWriteAttribute.AccessType.READ);
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
            setBody(body, true);
            getManager().notifyChange(this);
    }
    
    private void setBody(BlockStatementListNode body, boolean checkPermissions)
    {
        if (checkPermissions)
        {
            getManager().assertMutatable(this);
            getAttribute(LocalAttribute.BODY).recordAccess(ReadWriteAttribute.AccessType.WRITE);
        }
        
        if (this.body != null)
        {
            setAsChild(this.body.getNodeValue(), false);
        }
        this.body = new NormalNodeUnion<BlockStatementListNode>(body);
        setAsChild(body, true);
    }
    
    /**
     * Changes the list of statements in the metaprogram's body.
     * @param body The list of statements in the metaprogram's body.
     */
    public void setUnionForBody(NodeUnion<? extends BlockStatementListNode> body)
    {
            setUnionForBody(body, true);
            getManager().notifyChange(this);
    }
    
    private void setUnionForBody(NodeUnion<? extends BlockStatementListNode> body, boolean checkPermissions)
    {
        if (checkPermissions)
        {
            getManager().assertMutatable(this);
            getAttribute(LocalAttribute.BODY).recordAccess(ReadWriteAttribute.AccessType.WRITE);
        }
        
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
        if (this.preamble.getNodeValue() != null)
        {
            this.preamble.getNodeValue().receive(visitor);
        }
        if (this.body.getNodeValue() != null)
        {
            this.body.getNodeValue().receive(visitor);
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
        if (this.preamble.getNodeValue() != null)
        {
            this.preamble.getNodeValue().receiveTyped(visitor);
        }
        if (this.body.getNodeValue() != null)
        {
            this.body.getNodeValue().receiveTyped(visitor);
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
        list.add(getPreamble());
        list.add(getBody());
        return list;
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
    public <P,R> R executeOperation(BsjNodeOperation<P,R> operation, P p)
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
    public <P1,P2,R> R executeOperation(BsjNodeOperation2Arguments<P1,P2,R> operation, P1 p1, P2 p2)
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
