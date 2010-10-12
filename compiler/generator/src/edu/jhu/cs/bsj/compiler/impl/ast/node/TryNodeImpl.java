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
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.TryNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.BlockStatementListNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.CatchListNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaAnnotationListNode;
import edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeManager;
import edu.jhu.cs.bsj.compiler.impl.ast.NormalNodeUnion;
import edu.jhu.cs.bsj.compiler.impl.ast.attribute.ReadWriteAttribute;

@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class TryNodeImpl extends NodeImpl implements TryNode
{
    /** The block statements to try. */
    private NodeUnion<? extends BlockStatementListNode> body;
    
    /** The catch conditions. */
    private NodeUnion<? extends CatchListNode> catches;
    
    /** The finally block. */
    private NodeUnion<? extends BlockStatementListNode> finallyBlock;
    
    /** The meta-annotations associated with this node. */
    private NodeUnion<? extends MetaAnnotationListNode> metaAnnotations;
    
    private Map<LocalAttribute,ReadWriteAttribute> localAttributes = new EnumMap<LocalAttribute,ReadWriteAttribute>(LocalAttribute.class);
    private ReadWriteAttribute getAttribute(LocalAttribute attributeName)
    {
        ReadWriteAttribute attribute = localAttributes.get(attributeName);
        if (attribute == null)
        {
            attribute = new ReadWriteAttribute(TryNodeImpl.this);
            localAttributes.put(attributeName, attribute);
        }
        return attribute;
    }
    private static enum LocalAttribute
    {
        /** Attribute identifier for the body property. */
        BODY,
        /** Attribute identifier for the catches property. */
        CATCHES,
        /** Attribute identifier for the finallyBlock property. */
        FINALLY_BLOCK,
        /** Attribute identifier for the metaAnnotations property. */
        META_ANNOTATIONS,
    }
    
    /** General constructor. */
    public TryNodeImpl(
            NodeUnion<? extends BlockStatementListNode> body,
            NodeUnion<? extends CatchListNode> catches,
            NodeUnion<? extends BlockStatementListNode> finallyBlock,
            NodeUnion<? extends MetaAnnotationListNode> metaAnnotations,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation,
            BsjNodeManager manager,
            boolean binary)
    {
        super(startLocation, stopLocation, manager, binary);
        setUnionForBody(body, false);
        setUnionForCatches(catches, false);
        setUnionForFinallyBlock(finallyBlock, false);
        setUnionForMetaAnnotations(metaAnnotations, false);
    }
    
    /**
     * Gets the block statements to try.  This property's value is assumed to be a normal node.
     * @return The block statements to try.
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
     * Gets the block statements to try.
     * @return The block statements to try.
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
     * Changes the block statements to try.
     * @param body The block statements to try.
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
     * Changes the block statements to try.
     * @param body The block statements to try.
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
     * Gets the catch conditions.  This property's value is assumed to be a normal node.
     * @return The catch conditions.
     * @throws ClassCastException If this property's value is not a normal node.
     */
    public CatchListNode getCatches()
    {
        getAttribute(LocalAttribute.CATCHES).recordAccess(ReadWriteAttribute.AccessType.READ);
        if (this.catches == null)
        {
            return null;
        } else
        {
            return this.catches.getNormalNode();
        }
    }
    
    /**
     * Gets the catch conditions.
     * @return The catch conditions.
     */
    public NodeUnion<? extends CatchListNode> getUnionForCatches()
    {
        getAttribute(LocalAttribute.CATCHES).recordAccess(ReadWriteAttribute.AccessType.READ);
        if (this.catches == null)
        {
            this.catches = new NormalNodeUnion<CatchListNode>(null);
        }
        return this.catches;
    }
    
    /**
     * Changes the catch conditions.
     * @param catches The catch conditions.
     */
    public void setCatches(CatchListNode catches)
    {
            setCatches(catches, true);
            getManager().notifyChange(this);
    }
    
    private void setCatches(CatchListNode catches, boolean checkPermissions)
    {
        if (checkPermissions)
        {
            getManager().assertMutatable(this);
            getAttribute(LocalAttribute.CATCHES).recordAccess(ReadWriteAttribute.AccessType.WRITE);
        }
        
        if (this.catches != null)
        {
            setAsChild(this.catches.getNodeValue(), false);
        }
        this.catches = new NormalNodeUnion<CatchListNode>(catches);
        setAsChild(catches, true);
    }
    
    /**
     * Changes the catch conditions.
     * @param catches The catch conditions.
     */
    public void setUnionForCatches(NodeUnion<? extends CatchListNode> catches)
    {
            setUnionForCatches(catches, true);
            getManager().notifyChange(this);
    }
    
    private void setUnionForCatches(NodeUnion<? extends CatchListNode> catches, boolean checkPermissions)
    {
        if (checkPermissions)
        {
            getManager().assertMutatable(this);
            getAttribute(LocalAttribute.CATCHES).recordAccess(ReadWriteAttribute.AccessType.WRITE);
        }
        
        if (catches == null)
        {
            catches = new NormalNodeUnion<CatchListNode>(null);
        }
        if (this.catches != null)
        {
            setAsChild(this.catches.getNodeValue(), false);
        }
        this.catches = catches;
        setAsChild(catches.getNodeValue(), true);
    }
    
    /**
     * Gets the finally block.  This property's value is assumed to be a normal node.
     * @return The finally block.
     * @throws ClassCastException If this property's value is not a normal node.
     */
    public BlockStatementListNode getFinallyBlock()
    {
        getAttribute(LocalAttribute.FINALLY_BLOCK).recordAccess(ReadWriteAttribute.AccessType.READ);
        if (this.finallyBlock == null)
        {
            return null;
        } else
        {
            return this.finallyBlock.getNormalNode();
        }
    }
    
    /**
     * Gets the finally block.
     * @return The finally block.
     */
    public NodeUnion<? extends BlockStatementListNode> getUnionForFinallyBlock()
    {
        getAttribute(LocalAttribute.FINALLY_BLOCK).recordAccess(ReadWriteAttribute.AccessType.READ);
        if (this.finallyBlock == null)
        {
            this.finallyBlock = new NormalNodeUnion<BlockStatementListNode>(null);
        }
        return this.finallyBlock;
    }
    
    /**
     * Changes the finally block.
     * @param finallyBlock The finally block.
     */
    public void setFinallyBlock(BlockStatementListNode finallyBlock)
    {
            setFinallyBlock(finallyBlock, true);
            getManager().notifyChange(this);
    }
    
    private void setFinallyBlock(BlockStatementListNode finallyBlock, boolean checkPermissions)
    {
        if (checkPermissions)
        {
            getManager().assertMutatable(this);
            getAttribute(LocalAttribute.FINALLY_BLOCK).recordAccess(ReadWriteAttribute.AccessType.WRITE);
        }
        
        if (this.finallyBlock != null)
        {
            setAsChild(this.finallyBlock.getNodeValue(), false);
        }
        this.finallyBlock = new NormalNodeUnion<BlockStatementListNode>(finallyBlock);
        setAsChild(finallyBlock, true);
    }
    
    /**
     * Changes the finally block.
     * @param finallyBlock The finally block.
     */
    public void setUnionForFinallyBlock(NodeUnion<? extends BlockStatementListNode> finallyBlock)
    {
            setUnionForFinallyBlock(finallyBlock, true);
            getManager().notifyChange(this);
    }
    
    private void setUnionForFinallyBlock(NodeUnion<? extends BlockStatementListNode> finallyBlock, boolean checkPermissions)
    {
        if (checkPermissions)
        {
            getManager().assertMutatable(this);
            getAttribute(LocalAttribute.FINALLY_BLOCK).recordAccess(ReadWriteAttribute.AccessType.WRITE);
        }
        
        if (finallyBlock == null)
        {
            finallyBlock = new NormalNodeUnion<BlockStatementListNode>(null);
        }
        if (this.finallyBlock != null)
        {
            setAsChild(this.finallyBlock.getNodeValue(), false);
        }
        this.finallyBlock = finallyBlock;
        setAsChild(finallyBlock.getNodeValue(), true);
    }
    
    /**
     * Gets the meta-annotations associated with this node.  This property's value is assumed to be a normal node.
     * @return The meta-annotations associated with this node.
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
     * Gets the meta-annotations associated with this node.
     * @return The meta-annotations associated with this node.
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
     * Changes the meta-annotations associated with this node.
     * @param metaAnnotations The meta-annotations associated with this node.
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
     * Changes the meta-annotations associated with this node.
     * @param metaAnnotations The meta-annotations associated with this node.
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
        if (this.body.getNodeValue() != null)
        {
            this.body.getNodeValue().receive(visitor);
        }
        if (this.catches.getNodeValue() != null)
        {
            this.catches.getNodeValue().receive(visitor);
        }
        if (this.finallyBlock.getNodeValue() != null)
        {
            this.finallyBlock.getNodeValue().receive(visitor);
        }
        if (this.metaAnnotations.getNodeValue() != null)
        {
            this.metaAnnotations.getNodeValue().receive(visitor);
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
        if (this.body.getNodeValue() != null)
        {
            this.body.getNodeValue().receiveTyped(visitor);
        }
        if (this.catches.getNodeValue() != null)
        {
            this.catches.getNodeValue().receiveTyped(visitor);
        }
        if (this.finallyBlock.getNodeValue() != null)
        {
            this.finallyBlock.getNodeValue().receiveTyped(visitor);
        }
        if (this.metaAnnotations.getNodeValue() != null)
        {
            this.metaAnnotations.getNodeValue().receiveTyped(visitor);
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
        visitor.visitTryNodeStart(this, true);
        visitor.visitNodeStart(this);
        visitor.visitStatementNodeStart(this);
        visitor.visitStartEnd(this);
        receiveTypedToChildren(visitor);
        visitor.visitStopBegin(this);
        visitor.visitStatementNodeStop(this);
        visitor.visitNodeStop(this);
        visitor.visitTryNodeStop(this, true);
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
        list.add(getBody());
        list.add(getCatches());
        list.add(getFinallyBlock());
        return list;
    }
    
    /**
     * Returns an iterator over the children of this node.
     * @see Node#getChildIterator()
     */
    @Override
    public Iterable<? extends Node> getChildIterable()
    {
        return Arrays.asList(new Node[]{getUnionForBody().getNodeValue(), getUnionForCatches().getNodeValue(), getUnionForFinallyBlock().getNodeValue(), getUnionForMetaAnnotations().getNodeValue()});
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
        sb.append("body=");
        sb.append(this.getUnionForBody().getNodeValue() == null? "null" : this.getUnionForBody().getNodeValue().getClass().getSimpleName());
        sb.append(',');
        sb.append("catches=");
        sb.append(this.getUnionForCatches().getNodeValue() == null? "null" : this.getUnionForCatches().getNodeValue().getClass().getSimpleName());
        sb.append(',');
        sb.append("finallyBlock=");
        sb.append(this.getUnionForFinallyBlock().getNodeValue() == null? "null" : this.getUnionForFinallyBlock().getNodeValue().getClass().getSimpleName());
        sb.append(',');
        sb.append("metaAnnotations=");
        sb.append(this.getUnionForMetaAnnotations().getNodeValue() == null? "null" : this.getUnionForMetaAnnotations().getNodeValue().getClass().getSimpleName());
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
        return operation.executeTryNode(this, p);
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
        return operation.executeTryNode(this, p1, p2);
    }
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public TryNode deepCopy(BsjNodeFactory factory)
    {
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
        NodeUnion<? extends CatchListNode> catchesCopy;
        switch (getUnionForCatches().getType())
        {
            case NORMAL:
                if (getUnionForCatches().getNormalNode() == null)
                {
                    catchesCopy = factory.<CatchListNode>makeNormalNodeUnion(null);
                } else
                {
                    catchesCopy = factory.makeNormalNodeUnion(getUnionForCatches().getNormalNode().deepCopy(factory));
                }
                break;
            case SPLICE:
                if (getUnionForCatches().getSpliceNode() == null)
                {
                    catchesCopy = factory.<CatchListNode>makeSpliceNodeUnion(null);
                } else
                {
                    catchesCopy = factory.makeSpliceNodeUnion(getUnionForCatches().getSpliceNode().deepCopy(factory));
                }
                break;
            default:
                throw new IllegalStateException("Unrecognized union component type: " + getUnionForCatches().getType());
        }
        NodeUnion<? extends BlockStatementListNode> finallyBlockCopy;
        switch (getUnionForFinallyBlock().getType())
        {
            case NORMAL:
                if (getUnionForFinallyBlock().getNormalNode() == null)
                {
                    finallyBlockCopy = factory.<BlockStatementListNode>makeNormalNodeUnion(null);
                } else
                {
                    finallyBlockCopy = factory.makeNormalNodeUnion(getUnionForFinallyBlock().getNormalNode().deepCopy(factory));
                }
                break;
            case SPLICE:
                if (getUnionForFinallyBlock().getSpliceNode() == null)
                {
                    finallyBlockCopy = factory.<BlockStatementListNode>makeSpliceNodeUnion(null);
                } else
                {
                    finallyBlockCopy = factory.makeSpliceNodeUnion(getUnionForFinallyBlock().getSpliceNode().deepCopy(factory));
                }
                break;
            default:
                throw new IllegalStateException("Unrecognized union component type: " + getUnionForFinallyBlock().getType());
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
        return factory.makeTryNodeWithUnions(
                bodyCopy,
                catchesCopy,
                finallyBlockCopy,
                metaAnnotationsCopy,
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
        
        if (before.equals(this.getUnionForBody().getNodeValue()))
        {
            setBody((BlockStatementListNode)after);
            return true;
        }
        if (before.equals(this.getUnionForCatches().getNodeValue()))
        {
            setCatches((CatchListNode)after);
            return true;
        }
        if (before.equals(this.getUnionForFinallyBlock().getNodeValue()))
        {
            setFinallyBlock((BlockStatementListNode)after);
            return true;
        }
        if (before.equals(this.getUnionForMetaAnnotations().getNodeValue()))
        {
            setMetaAnnotations((MetaAnnotationListNode)after);
            return true;
        }
        return false;
    }
    
}
