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
import edu.jhu.cs.bsj.compiler.ast.node.AssertStatementNode;
import edu.jhu.cs.bsj.compiler.ast.node.ExpressionNode;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaAnnotationListNode;
import edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeManager;
import edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactory;
import edu.jhu.cs.bsj.compiler.impl.ast.NormalNodeUnion;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.property.AssertStatementNodeSetMessageExpressionPropertyEditScriptElementImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.property.AssertStatementNodeSetMetaAnnotationsPropertyEditScriptElementImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.property.AssertStatementNodeSetTestExpressionPropertyEditScriptElementImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.properties.AssertStatementNodeProperties;

@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class AssertStatementNodeImpl extends NodeImpl implements AssertStatementNode
{
    /** The assertion's test expression. */
    private NodeUnion<? extends ExpressionNode> testExpression;
    
    /** The assertion's message expression. */
    private NodeUnion<? extends ExpressionNode> messageExpression;
    
    /** The meta-annotations associated with this node. */
    private NodeUnion<? extends MetaAnnotationListNode> metaAnnotations;
    
    /**
     * A set of those properties which have been populated from the backing node.
     * This field is <code>null</code> if <tt>backingNode</tt> is <code>null</code>.
     */
    private Set<AssertStatementNodeProperties> populatedProperties;
    
    /** General constructor. */
    public AssertStatementNodeImpl(
            NodeUnion<? extends ExpressionNode> testExpression,
            NodeUnion<? extends ExpressionNode> messageExpression,
            NodeUnion<? extends MetaAnnotationListNode> metaAnnotations,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation,
            BsjNodeManager manager,
            boolean binary)
    {
        super(startLocation, stopLocation, manager, binary);
        this.populatedProperties = null;
        doSetTestExpression(testExpression);
        doSetMessageExpression(messageExpression);
        doSetMetaAnnotations(metaAnnotations);
    }
    
    /** Proxy constructor. */
    public AssertStatementNodeImpl(BsjNodeManager manager, BsjNodeProxyFactory proxyFactory, AssertStatementNode backingNode)
    {
        super(manager, proxyFactory, backingNode);
        this.populatedProperties = EnumSet.noneOf(AssertStatementNodeProperties.class);
    }
    
    /** Retrieves this node's backing node (if one exists). */
    protected AssertStatementNode getBackingNode()
    {
        return (AssertStatementNode)super.getBackingNode();
    }
    
    /**
     * Ensures that the testExpression value has been populated from proxy.
     * If this node is not backed by a proxy or if the value has already been
     * populated, this method does nothing.
     */
    private void checkTestExpressionWrapped()
    {
        if (this.populatedProperties == null || this.populatedProperties.contains(
                AssertStatementNodeProperties.TEST_EXPRESSION))
            return;
        this.populatedProperties.add(AssertStatementNodeProperties.TEST_EXPRESSION);
        NodeUnion<? extends ExpressionNode> union = this.getBackingNode().getUnionForTestExpression();
        switch (union.getType())
        {
            case NORMAL:
                union = this.getProxyFactory().makeNormalNodeUnion(
                        this.getProxyFactory().makeExpressionNode(union.getNormalNode()));
                break;
            case SPLICE:
                union = this.getProxyFactory().makeSpliceNodeUnion(
                        this.getProxyFactory().makeSpliceNode(union.getSpliceNode()));
                break;
            default:
                throw new IllegalStateException("Unrecognized union type: " + union.getType());
        }
        this.testExpression = union;
    }
    
    /**
     * Ensures that the messageExpression value has been populated from proxy.
     * If this node is not backed by a proxy or if the value has already been
     * populated, this method does nothing.
     */
    private void checkMessageExpressionWrapped()
    {
        if (this.populatedProperties == null || this.populatedProperties.contains(
                AssertStatementNodeProperties.MESSAGE_EXPRESSION))
            return;
        this.populatedProperties.add(AssertStatementNodeProperties.MESSAGE_EXPRESSION);
        NodeUnion<? extends ExpressionNode> union = this.getBackingNode().getUnionForMessageExpression();
        switch (union.getType())
        {
            case NORMAL:
                union = this.getProxyFactory().makeNormalNodeUnion(
                        this.getProxyFactory().makeExpressionNode(union.getNormalNode()));
                break;
            case SPLICE:
                union = this.getProxyFactory().makeSpliceNodeUnion(
                        this.getProxyFactory().makeSpliceNode(union.getSpliceNode()));
                break;
            default:
                throw new IllegalStateException("Unrecognized union type: " + union.getType());
        }
        this.messageExpression = union;
    }
    
    /**
     * Ensures that the metaAnnotations value has been populated from proxy.
     * If this node is not backed by a proxy or if the value has already been
     * populated, this method does nothing.
     */
    private void checkMetaAnnotationsWrapped()
    {
        if (this.populatedProperties == null || this.populatedProperties.contains(
                AssertStatementNodeProperties.META_ANNOTATIONS))
            return;
        this.populatedProperties.add(AssertStatementNodeProperties.META_ANNOTATIONS);
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
     * Gets the assertion's test expression.  This property's value is assumed to be a normal node.
     * @return The assertion's test expression.
     * @throws ClassCastException If this property's value is not a normal node.
     */
    public ExpressionNode getTestExpression()
    {
        checkTestExpressionWrapped();
        if (this.testExpression == null)
        {
            return null;
        } else
        {
            return this.testExpression.getNormalNode();
        }
    }
    
    /**
     * Gets the assertion's test expression.
     * @return The assertion's test expression.
     */
    public NodeUnion<? extends ExpressionNode> getUnionForTestExpression()
    {
        checkTestExpressionWrapped();
        if (this.testExpression == null)
        {
            this.testExpression = new NormalNodeUnion<ExpressionNode>(null);
        }
        return this.testExpression;
    }
    
    /**
     * Changes the assertion's test expression.
     * @param testExpression The assertion's test expression.
     */
    public void setTestExpression(ExpressionNode testExpression)
    {
        checkTestExpressionWrapped();
        this.setUnionForTestExpression(new NormalNodeUnion<ExpressionNode>(testExpression));
    }
    
    /**
     * Changes the assertion's test expression.
     * @param testExpression The assertion's test expression.
     */
    public void setUnionForTestExpression(NodeUnion<? extends ExpressionNode> testExpression)
    {
        checkTestExpressionWrapped();
        this.getManager().assertMutatable(this);
        this.doSetTestExpression(testExpression);
        if (this.getManager().isRecordingEdits())
            super.recordEdit(new AssertStatementNodeSetTestExpressionPropertyEditScriptElementImpl(this.getManager().getCurrentMetaprogramId(), this.getUid(), testExpression.getNodeValue() == null ? null : testExpression.getNodeValue().getUid()));
    }
    
    private void doSetTestExpression(NodeUnion<? extends ExpressionNode> testExpression)
    {
        if (testExpression == null)
        {
            testExpression = new NormalNodeUnion<ExpressionNode>(null);
        }
        if (this.testExpression != null)
        {
            setAsChild(this.testExpression.getNodeValue(), false);
        }
        this.testExpression = testExpression;
        setAsChild(testExpression.getNodeValue(), true);
    }
    
    /**
     * Gets the assertion's message expression.  This property's value is assumed to be a normal node.
     * @return The assertion's message expression.
     * @throws ClassCastException If this property's value is not a normal node.
     */
    public ExpressionNode getMessageExpression()
    {
        checkMessageExpressionWrapped();
        if (this.messageExpression == null)
        {
            return null;
        } else
        {
            return this.messageExpression.getNormalNode();
        }
    }
    
    /**
     * Gets the assertion's message expression.
     * @return The assertion's message expression.
     */
    public NodeUnion<? extends ExpressionNode> getUnionForMessageExpression()
    {
        checkMessageExpressionWrapped();
        if (this.messageExpression == null)
        {
            this.messageExpression = new NormalNodeUnion<ExpressionNode>(null);
        }
        return this.messageExpression;
    }
    
    /**
     * Changes the assertion's message expression.
     * @param messageExpression The assertion's message expression.
     */
    public void setMessageExpression(ExpressionNode messageExpression)
    {
        checkMessageExpressionWrapped();
        this.setUnionForMessageExpression(new NormalNodeUnion<ExpressionNode>(messageExpression));
    }
    
    /**
     * Changes the assertion's message expression.
     * @param messageExpression The assertion's message expression.
     */
    public void setUnionForMessageExpression(NodeUnion<? extends ExpressionNode> messageExpression)
    {
        checkMessageExpressionWrapped();
        this.getManager().assertMutatable(this);
        this.doSetMessageExpression(messageExpression);
        if (this.getManager().isRecordingEdits())
            super.recordEdit(new AssertStatementNodeSetMessageExpressionPropertyEditScriptElementImpl(this.getManager().getCurrentMetaprogramId(), this.getUid(), messageExpression.getNodeValue() == null ? null : messageExpression.getNodeValue().getUid()));
    }
    
    private void doSetMessageExpression(NodeUnion<? extends ExpressionNode> messageExpression)
    {
        if (messageExpression == null)
        {
            messageExpression = new NormalNodeUnion<ExpressionNode>(null);
        }
        if (this.messageExpression != null)
        {
            setAsChild(this.messageExpression.getNodeValue(), false);
        }
        this.messageExpression = messageExpression;
        setAsChild(messageExpression.getNodeValue(), true);
    }
    
    /**
     * Gets the meta-annotations associated with this node.  This property's value is assumed to be a normal node.
     * @return The meta-annotations associated with this node.
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
     * Gets the meta-annotations associated with this node.
     * @return The meta-annotations associated with this node.
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
     * Changes the meta-annotations associated with this node.
     * @param metaAnnotations The meta-annotations associated with this node.
     */
    public void setMetaAnnotations(MetaAnnotationListNode metaAnnotations)
    {
        checkMetaAnnotationsWrapped();
        this.setUnionForMetaAnnotations(new NormalNodeUnion<MetaAnnotationListNode>(metaAnnotations));
    }
    
    /**
     * Changes the meta-annotations associated with this node.
     * @param metaAnnotations The meta-annotations associated with this node.
     */
    public void setUnionForMetaAnnotations(NodeUnion<? extends MetaAnnotationListNode> metaAnnotations)
    {
        checkMetaAnnotationsWrapped();
        this.getManager().assertMutatable(this);
        this.doSetMetaAnnotations(metaAnnotations);
        if (this.getManager().isRecordingEdits())
            super.recordEdit(new AssertStatementNodeSetMetaAnnotationsPropertyEditScriptElementImpl(this.getManager().getCurrentMetaprogramId(), this.getUid(), metaAnnotations.getNodeValue() == null ? null : metaAnnotations.getNodeValue().getUid()));
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
        if (this.getUnionForTestExpression().getNodeValue() != null)
        {
            this.getUnionForTestExpression().getNodeValue().receive(visitor);
        }
        if (this.getUnionForMessageExpression().getNodeValue() != null)
        {
            this.getUnionForMessageExpression().getNodeValue().receive(visitor);
        }
        if (this.getUnionForMetaAnnotations().getNodeValue() != null)
        {
            this.getUnionForMetaAnnotations().getNodeValue().receive(visitor);
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
        if (this.getUnionForTestExpression().getNodeValue() != null)
        {
            this.getUnionForTestExpression().getNodeValue().receiveTyped(visitor);
        }
        if (this.getUnionForMessageExpression().getNodeValue() != null)
        {
            this.getUnionForMessageExpression().getNodeValue().receiveTyped(visitor);
        }
        if (this.getUnionForMetaAnnotations().getNodeValue() != null)
        {
            this.getUnionForMetaAnnotations().getNodeValue().receiveTyped(visitor);
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
        visitor.visitAssertStatementNodeStart(this, true);
        visitor.visitNodeStart(this);
        visitor.visitStatementNodeStart(this);
        visitor.visitStartEnd(this);
        receiveTypedToChildren(visitor);
        visitor.visitStopBegin(this);
        visitor.visitStatementNodeStop(this);
        visitor.visitNodeStop(this);
        visitor.visitAssertStatementNodeStop(this, true);
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
        list.add(getUnionForTestExpression());
        list.add(getUnionForMessageExpression());
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
        map.put("testExpression", getUnionForTestExpression());
        map.put("messageExpression", getUnionForMessageExpression());
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
        return Arrays.asList(new Node[]{getUnionForTestExpression().getNodeValue(), getUnionForMessageExpression().getNodeValue(), getUnionForMetaAnnotations().getNodeValue()});
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
        sb.append("testExpression=");
        sb.append(this.getUnionForTestExpression().getNodeValue() == null? "null" : this.getUnionForTestExpression().getNodeValue().getClass().getSimpleName());
        sb.append(',');
        sb.append("messageExpression=");
        sb.append(this.getUnionForMessageExpression().getNodeValue() == null? "null" : this.getUnionForMessageExpression().getNodeValue().getClass().getSimpleName());
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
    public <P,R,X extends Exception> R executeOperation(BsjAbortableNodeOperation<P,R,X> operation, P p) throws X
    {
        return operation.executeAssertStatementNode(this, p);
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
        return operation.executeAssertStatementNode(this, p1, p2);
    }
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public AssertStatementNode deepCopy(BsjNodeFactory factory)
    {
        NodeUnion<? extends ExpressionNode> testExpressionCopy;
        switch (getUnionForTestExpression().getType())
        {
            case NORMAL:
                if (getUnionForTestExpression().getNormalNode() == null)
                {
                    testExpressionCopy = factory.<ExpressionNode>makeNormalNodeUnion(null);
                } else
                {
                    testExpressionCopy = factory.makeNormalNodeUnion(getUnionForTestExpression().getNormalNode().deepCopy(factory));
                }
                break;
            case SPLICE:
                if (getUnionForTestExpression().getSpliceNode() == null)
                {
                    testExpressionCopy = factory.<ExpressionNode>makeSpliceNodeUnion(null);
                } else
                {
                    testExpressionCopy = factory.makeSpliceNodeUnion(getUnionForTestExpression().getSpliceNode().deepCopy(factory));
                }
                break;
            default:
                throw new IllegalStateException("Unrecognized union component type: " + getUnionForTestExpression().getType());
        }
        NodeUnion<? extends ExpressionNode> messageExpressionCopy;
        switch (getUnionForMessageExpression().getType())
        {
            case NORMAL:
                if (getUnionForMessageExpression().getNormalNode() == null)
                {
                    messageExpressionCopy = factory.<ExpressionNode>makeNormalNodeUnion(null);
                } else
                {
                    messageExpressionCopy = factory.makeNormalNodeUnion(getUnionForMessageExpression().getNormalNode().deepCopy(factory));
                }
                break;
            case SPLICE:
                if (getUnionForMessageExpression().getSpliceNode() == null)
                {
                    messageExpressionCopy = factory.<ExpressionNode>makeSpliceNodeUnion(null);
                } else
                {
                    messageExpressionCopy = factory.makeSpliceNodeUnion(getUnionForMessageExpression().getSpliceNode().deepCopy(factory));
                }
                break;
            default:
                throw new IllegalStateException("Unrecognized union component type: " + getUnionForMessageExpression().getType());
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
        return factory.makeAssertStatementNodeWithUnions(
                testExpressionCopy,
                messageExpressionCopy,
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
        
        if (before.equals(this.getUnionForTestExpression().getNodeValue()))
        {
            setTestExpression((ExpressionNode)after);
            return true;
        }
        if (before.equals(this.getUnionForMessageExpression().getNodeValue()))
        {
            setMessageExpression((ExpressionNode)after);
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
