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
import edu.jhu.cs.bsj.compiler.ast.node.ForInitializerExpressionNode;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.list.StatementExpressionListNode;
import edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeManager;
import edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactory;
import edu.jhu.cs.bsj.compiler.impl.ast.NormalNodeUnion;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.property.ForInitializerExpressionNodeSetExpressionsPropertyEditScriptElementImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.properties.ForInitializerExpressionNodeProperties;

@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class ForInitializerExpressionNodeImpl extends NodeImpl implements ForInitializerExpressionNode
{
    /** The expressions used in this initializer. */
    private NodeUnion<? extends StatementExpressionListNode> expressions;
    
    /**
     * A set of those properties which have been populated from the backing node.
     * This field is <code>null</code> if <tt>backingNode</tt> is <code>null</code>.
     */
    private Set<ForInitializerExpressionNodeProperties> populatedProperties;
    
    /** General constructor. */
    public ForInitializerExpressionNodeImpl(
            NodeUnion<? extends StatementExpressionListNode> expressions,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation,
            BsjNodeManager manager,
            boolean binary)
    {
        super(startLocation, stopLocation, manager, binary);
        this.populatedProperties = null;
        doSetExpressions(expressions);
    }
    
    /** Proxy constructor. */
    public ForInitializerExpressionNodeImpl(BsjNodeManager manager, BsjNodeProxyFactory proxyFactory, ForInitializerExpressionNode backingNode)
    {
        super(manager, proxyFactory, backingNode);
        this.populatedProperties = EnumSet.noneOf(ForInitializerExpressionNodeProperties.class);
    }
    
    /** Retrieves this node's backing node (if one exists). */
    protected ForInitializerExpressionNode getBackingNode()
    {
        return (ForInitializerExpressionNode)super.getBackingNode();
    }
    
    /**
     * Ensures that the expressions value has been populated from proxy.
     * If this node is not backed by a proxy or if the value has already been
     * populated, this method does nothing.
     */
    private void checkExpressionsWrapped()
    {
        if (this.populatedProperties == null || this.populatedProperties.contains(
                ForInitializerExpressionNodeProperties.EXPRESSIONS))
            return;
        this.populatedProperties.add(ForInitializerExpressionNodeProperties.EXPRESSIONS);
        NodeUnion<? extends StatementExpressionListNode> union = this.getBackingNode().getUnionForExpressions();
        switch (union.getType())
        {
            case NORMAL:
                union = this.getProxyFactory().makeNormalNodeUnion(
                        this.getProxyFactory().makeStatementExpressionListNode(union.getNormalNode()));
                break;
            case SPLICE:
                union = this.getProxyFactory().makeSpliceNodeUnion(
                        this.getProxyFactory().makeSpliceNode(union.getSpliceNode()));
                break;
            default:
                throw new IllegalStateException("Unrecognized union type: " + union.getType());
        }
        this.expressions = union;
    }
    
    /**
     * Gets the expressions used in this initializer.  This property's value is assumed to be a normal node.
     * @return The expressions used in this initializer.
     * @throws ClassCastException If this property's value is not a normal node.
     */
    public StatementExpressionListNode getExpressions()
    {
        checkExpressionsWrapped();
        if (this.expressions == null)
        {
            return null;
        } else
        {
            return this.expressions.getNormalNode();
        }
    }
    
    /**
     * Gets the expressions used in this initializer.
     * @return The expressions used in this initializer.
     */
    public NodeUnion<? extends StatementExpressionListNode> getUnionForExpressions()
    {
        checkExpressionsWrapped();
        if (this.expressions == null)
        {
            this.expressions = new NormalNodeUnion<StatementExpressionListNode>(null);
        }
        return this.expressions;
    }
    
    /**
     * Changes the expressions used in this initializer.
     * @param expressions The expressions used in this initializer.
     */
    public void setExpressions(StatementExpressionListNode expressions)
    {
        checkExpressionsWrapped();
        this.setUnionForExpressions(new NormalNodeUnion<StatementExpressionListNode>(expressions));
    }
    
    /**
     * Changes the expressions used in this initializer.
     * @param expressions The expressions used in this initializer.
     */
    public void setUnionForExpressions(NodeUnion<? extends StatementExpressionListNode> expressions)
    {
        checkExpressionsWrapped();
        this.getManager().assertMutatable(this);
        this.doSetExpressions(expressions);
        if (this.getManager().isRecordingEdits())
            super.recordEdit(new ForInitializerExpressionNodeSetExpressionsPropertyEditScriptElementImpl(this.getManager().getCurrentMetaprogramId(), this.getUid(), expressions.getNodeValue() == null ? null : expressions.getNodeValue().getUid()));
    }
    
    private void doSetExpressions(NodeUnion<? extends StatementExpressionListNode> expressions)
    {
        if (expressions == null)
        {
            expressions = new NormalNodeUnion<StatementExpressionListNode>(null);
        }
        if (this.expressions != null)
        {
            setAsChild(this.expressions.getNodeValue(), false);
        }
        this.expressions = expressions;
        setAsChild(expressions.getNodeValue(), true);
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
        if (this.getUnionForExpressions().getNodeValue() != null)
        {
            this.getUnionForExpressions().getNodeValue().receive(visitor);
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
        if (this.getUnionForExpressions().getNodeValue() != null)
        {
            this.getUnionForExpressions().getNodeValue().receiveTyped(visitor);
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
        visitor.visitForInitializerExpressionNodeStart(this, true);
        visitor.visitNodeStart(this);
        visitor.visitForInitializerNodeStart(this);
        visitor.visitStartEnd(this);
        receiveTypedToChildren(visitor);
        visitor.visitStopBegin(this);
        visitor.visitForInitializerNodeStop(this);
        visitor.visitNodeStop(this);
        visitor.visitForInitializerExpressionNodeStop(this, true);
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
        list.add(getUnionForExpressions());
        return list;
    }
    
    /**
     * Returns an iterator over the children of this node.
     * @see Node#getChildIterator()
     */
    @Override
    public Iterable<? extends Node> getChildIterable()
    {
        return Arrays.asList(new Node[]{getUnionForExpressions().getNodeValue()});
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
        sb.append("expressions=");
        sb.append(this.getUnionForExpressions().getNodeValue() == null? "null" : this.getUnionForExpressions().getNodeValue().getClass().getSimpleName());
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
        return operation.executeForInitializerExpressionNode(this, p);
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
        return operation.executeForInitializerExpressionNode(this, p1, p2);
    }
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public ForInitializerExpressionNode deepCopy(BsjNodeFactory factory)
    {
        NodeUnion<? extends StatementExpressionListNode> expressionsCopy;
        switch (getUnionForExpressions().getType())
        {
            case NORMAL:
                if (getUnionForExpressions().getNormalNode() == null)
                {
                    expressionsCopy = factory.<StatementExpressionListNode>makeNormalNodeUnion(null);
                } else
                {
                    expressionsCopy = factory.makeNormalNodeUnion(getUnionForExpressions().getNormalNode().deepCopy(factory));
                }
                break;
            case SPLICE:
                if (getUnionForExpressions().getSpliceNode() == null)
                {
                    expressionsCopy = factory.<StatementExpressionListNode>makeSpliceNodeUnion(null);
                } else
                {
                    expressionsCopy = factory.makeSpliceNodeUnion(getUnionForExpressions().getSpliceNode().deepCopy(factory));
                }
                break;
            default:
                throw new IllegalStateException("Unrecognized union component type: " + getUnionForExpressions().getType());
        }
        return factory.makeForInitializerExpressionNodeWithUnions(
                expressionsCopy,
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
        
        if (before.equals(this.getUnionForExpressions().getNodeValue()))
        {
            setExpressions((StatementExpressionListNode)after);
            return true;
        }
        return false;
    }
    
}
