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
import edu.jhu.cs.bsj.compiler.ast.node.ExpressionNode;
import edu.jhu.cs.bsj.compiler.ast.node.ForInitializerNode;
import edu.jhu.cs.bsj.compiler.ast.node.ForLoopNode;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.StatementNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.StatementExpressionListNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaAnnotationListNode;
import edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeManager;
import edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactory;
import edu.jhu.cs.bsj.compiler.impl.ast.NormalNodeUnion;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.property.ForLoopNodeSetConditionPropertyEditScriptElementImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.property.ForLoopNodeSetInitializerPropertyEditScriptElementImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.property.ForLoopNodeSetMetaAnnotationsPropertyEditScriptElementImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.property.ForLoopNodeSetStatementPropertyEditScriptElementImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.property.ForLoopNodeSetUpdatePropertyEditScriptElementImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.properties.ForLoopNodeProperties;

@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class ForLoopNodeImpl extends NodeImpl implements ForLoopNode
{
    /** The initializer used for this for loop. */
    private NodeUnion<? extends ForInitializerNode> initializer;
    
    /** The loop's termination condition. */
    private NodeUnion<? extends ExpressionNode> condition;
    
    /** The loop's update operation. */
    private NodeUnion<? extends StatementExpressionListNode> update;
    
    /** The loop's statement. */
    private NodeUnion<? extends StatementNode> statement;
    
    /** The meta-annotations associated with this node. */
    private NodeUnion<? extends MetaAnnotationListNode> metaAnnotations;
    
    /**
     * A set of those properties which have been populated from the backing node.
     * This field is <code>null</code> if <tt>backingNode</tt> is <code>null</code>.
     */
    private Set<ForLoopNodeProperties> populatedProperties;
    
    /** General constructor. */
    public ForLoopNodeImpl(
            NodeUnion<? extends ForInitializerNode> initializer,
            NodeUnion<? extends ExpressionNode> condition,
            NodeUnion<? extends StatementExpressionListNode> update,
            NodeUnion<? extends StatementNode> statement,
            NodeUnion<? extends MetaAnnotationListNode> metaAnnotations,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation,
            BsjNodeManager manager,
            boolean binary)
    {
        super(startLocation, stopLocation, manager, binary);
        this.populatedProperties = null;
        doSetInitializer(initializer);
        doSetCondition(condition);
        doSetUpdate(update);
        doSetStatement(statement);
        doSetMetaAnnotations(metaAnnotations);
    }
    
    /** Proxy constructor. */
    public ForLoopNodeImpl(BsjNodeManager manager, BsjNodeProxyFactory proxyFactory, ForLoopNode backingNode)
    {
        super(manager, proxyFactory, backingNode);
        this.populatedProperties = EnumSet.noneOf(ForLoopNodeProperties.class);
    }
    
    /** Retrieves this node's backing node (if one exists). */
    protected ForLoopNode getBackingNode()
    {
        return (ForLoopNode)super.getBackingNode();
    }
    
    /**
     * Ensures that the initializer value has been populated from proxy.
     * If this node is not backed by a proxy or if the value has already been
     * populated, this method does nothing.
     */
    private void checkInitializerWrapped()
    {
        if (this.populatedProperties == null || this.populatedProperties.contains(
                ForLoopNodeProperties.INITIALIZER))
            return;
        this.populatedProperties.add(ForLoopNodeProperties.INITIALIZER);
        NodeUnion<? extends ForInitializerNode> union = this.getBackingNode().getUnionForInitializer();
        switch (union.getType())
        {
            case NORMAL:
                union = this.getProxyFactory().makeNormalNodeUnion(
                        this.getProxyFactory().makeForInitializerNode(union.getNormalNode()));
                break;
            case SPLICE:
                union = this.getProxyFactory().makeSpliceNodeUnion(
                        this.getProxyFactory().makeSpliceNode(union.getSpliceNode()));
                break;
            default:
                throw new IllegalStateException("Unrecognized union type: " + union.getType());
        }
        this.initializer = union;
    }
    
    /**
     * Ensures that the condition value has been populated from proxy.
     * If this node is not backed by a proxy or if the value has already been
     * populated, this method does nothing.
     */
    private void checkConditionWrapped()
    {
        if (this.populatedProperties == null || this.populatedProperties.contains(
                ForLoopNodeProperties.CONDITION))
            return;
        this.populatedProperties.add(ForLoopNodeProperties.CONDITION);
        NodeUnion<? extends ExpressionNode> union = this.getBackingNode().getUnionForCondition();
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
        this.condition = union;
    }
    
    /**
     * Ensures that the update value has been populated from proxy.
     * If this node is not backed by a proxy or if the value has already been
     * populated, this method does nothing.
     */
    private void checkUpdateWrapped()
    {
        if (this.populatedProperties == null || this.populatedProperties.contains(
                ForLoopNodeProperties.UPDATE))
            return;
        this.populatedProperties.add(ForLoopNodeProperties.UPDATE);
        NodeUnion<? extends StatementExpressionListNode> union = this.getBackingNode().getUnionForUpdate();
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
        this.update = union;
    }
    
    /**
     * Ensures that the statement value has been populated from proxy.
     * If this node is not backed by a proxy or if the value has already been
     * populated, this method does nothing.
     */
    private void checkStatementWrapped()
    {
        if (this.populatedProperties == null || this.populatedProperties.contains(
                ForLoopNodeProperties.STATEMENT))
            return;
        this.populatedProperties.add(ForLoopNodeProperties.STATEMENT);
        NodeUnion<? extends StatementNode> union = this.getBackingNode().getUnionForStatement();
        switch (union.getType())
        {
            case NORMAL:
                union = this.getProxyFactory().makeNormalNodeUnion(
                        this.getProxyFactory().makeStatementNode(union.getNormalNode()));
                break;
            case SPLICE:
                union = this.getProxyFactory().makeSpliceNodeUnion(
                        this.getProxyFactory().makeSpliceNode(union.getSpliceNode()));
                break;
            default:
                throw new IllegalStateException("Unrecognized union type: " + union.getType());
        }
        this.statement = union;
    }
    
    /**
     * Ensures that the metaAnnotations value has been populated from proxy.
     * If this node is not backed by a proxy or if the value has already been
     * populated, this method does nothing.
     */
    private void checkMetaAnnotationsWrapped()
    {
        if (this.populatedProperties == null || this.populatedProperties.contains(
                ForLoopNodeProperties.META_ANNOTATIONS))
            return;
        this.populatedProperties.add(ForLoopNodeProperties.META_ANNOTATIONS);
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
     * Gets the initializer used for this for loop.  This property's value is assumed to be a normal node.
     * @return The initializer used for this for loop.
     * @throws ClassCastException If this property's value is not a normal node.
     */
    public ForInitializerNode getInitializer()
    {
        checkInitializerWrapped();
        if (this.initializer == null)
        {
            return null;
        } else
        {
            return this.initializer.getNormalNode();
        }
    }
    
    /**
     * Gets the initializer used for this for loop.
     * @return The initializer used for this for loop.
     */
    public NodeUnion<? extends ForInitializerNode> getUnionForInitializer()
    {
        checkInitializerWrapped();
        if (this.initializer == null)
        {
            this.initializer = new NormalNodeUnion<ForInitializerNode>(null);
        }
        return this.initializer;
    }
    
    /**
     * Changes the initializer used for this for loop.
     * @param initializer The initializer used for this for loop.
     */
    public void setInitializer(ForInitializerNode initializer)
    {
        checkInitializerWrapped();
        this.setUnionForInitializer(new NormalNodeUnion<ForInitializerNode>(initializer));
    }
    
    /**
     * Changes the initializer used for this for loop.
     * @param initializer The initializer used for this for loop.
     */
    public void setUnionForInitializer(NodeUnion<? extends ForInitializerNode> initializer)
    {
        checkInitializerWrapped();
        this.getManager().assertMutatable(this);
        this.doSetInitializer(initializer);
        if (this.getManager().isRecordingEdits())
            super.recordEdit(new ForLoopNodeSetInitializerPropertyEditScriptElementImpl(this.getManager().getCurrentMetaprogramId(), this.getUid(), initializer.getNodeValue() == null ? null : initializer.getNodeValue().getUid()));
    }
    
    private void doSetInitializer(NodeUnion<? extends ForInitializerNode> initializer)
    {
        if (initializer == null)
        {
            initializer = new NormalNodeUnion<ForInitializerNode>(null);
        }
        if (this.initializer != null)
        {
            setAsChild(this.initializer.getNodeValue(), false);
        }
        this.initializer = initializer;
        setAsChild(initializer.getNodeValue(), true);
    }
    
    /**
     * Gets the loop's termination condition.  This property's value is assumed to be a normal node.
     * @return The loop's termination condition.
     * @throws ClassCastException If this property's value is not a normal node.
     */
    public ExpressionNode getCondition()
    {
        checkConditionWrapped();
        if (this.condition == null)
        {
            return null;
        } else
        {
            return this.condition.getNormalNode();
        }
    }
    
    /**
     * Gets the loop's termination condition.
     * @return The loop's termination condition.
     */
    public NodeUnion<? extends ExpressionNode> getUnionForCondition()
    {
        checkConditionWrapped();
        if (this.condition == null)
        {
            this.condition = new NormalNodeUnion<ExpressionNode>(null);
        }
        return this.condition;
    }
    
    /**
     * Changes the loop's termination condition.
     * @param condition The loop's termination condition.
     */
    public void setCondition(ExpressionNode condition)
    {
        checkConditionWrapped();
        this.setUnionForCondition(new NormalNodeUnion<ExpressionNode>(condition));
    }
    
    /**
     * Changes the loop's termination condition.
     * @param condition The loop's termination condition.
     */
    public void setUnionForCondition(NodeUnion<? extends ExpressionNode> condition)
    {
        checkConditionWrapped();
        this.getManager().assertMutatable(this);
        this.doSetCondition(condition);
        if (this.getManager().isRecordingEdits())
            super.recordEdit(new ForLoopNodeSetConditionPropertyEditScriptElementImpl(this.getManager().getCurrentMetaprogramId(), this.getUid(), condition.getNodeValue() == null ? null : condition.getNodeValue().getUid()));
    }
    
    private void doSetCondition(NodeUnion<? extends ExpressionNode> condition)
    {
        if (condition == null)
        {
            condition = new NormalNodeUnion<ExpressionNode>(null);
        }
        if (this.condition != null)
        {
            setAsChild(this.condition.getNodeValue(), false);
        }
        this.condition = condition;
        setAsChild(condition.getNodeValue(), true);
    }
    
    /**
     * Gets the loop's update operation.  This property's value is assumed to be a normal node.
     * @return The loop's update operation.
     * @throws ClassCastException If this property's value is not a normal node.
     */
    public StatementExpressionListNode getUpdate()
    {
        checkUpdateWrapped();
        if (this.update == null)
        {
            return null;
        } else
        {
            return this.update.getNormalNode();
        }
    }
    
    /**
     * Gets the loop's update operation.
     * @return The loop's update operation.
     */
    public NodeUnion<? extends StatementExpressionListNode> getUnionForUpdate()
    {
        checkUpdateWrapped();
        if (this.update == null)
        {
            this.update = new NormalNodeUnion<StatementExpressionListNode>(null);
        }
        return this.update;
    }
    
    /**
     * Changes the loop's update operation.
     * @param update The loop's update operation.
     */
    public void setUpdate(StatementExpressionListNode update)
    {
        checkUpdateWrapped();
        this.setUnionForUpdate(new NormalNodeUnion<StatementExpressionListNode>(update));
    }
    
    /**
     * Changes the loop's update operation.
     * @param update The loop's update operation.
     */
    public void setUnionForUpdate(NodeUnion<? extends StatementExpressionListNode> update)
    {
        checkUpdateWrapped();
        this.getManager().assertMutatable(this);
        this.doSetUpdate(update);
        if (this.getManager().isRecordingEdits())
            super.recordEdit(new ForLoopNodeSetUpdatePropertyEditScriptElementImpl(this.getManager().getCurrentMetaprogramId(), this.getUid(), update.getNodeValue() == null ? null : update.getNodeValue().getUid()));
    }
    
    private void doSetUpdate(NodeUnion<? extends StatementExpressionListNode> update)
    {
        if (update == null)
        {
            update = new NormalNodeUnion<StatementExpressionListNode>(null);
        }
        if (this.update != null)
        {
            setAsChild(this.update.getNodeValue(), false);
        }
        this.update = update;
        setAsChild(update.getNodeValue(), true);
    }
    
    /**
     * Gets the loop's statement.  This property's value is assumed to be a normal node.
     * @return The loop's statement.
     * @throws ClassCastException If this property's value is not a normal node.
     */
    public StatementNode getStatement()
    {
        checkStatementWrapped();
        if (this.statement == null)
        {
            return null;
        } else
        {
            return this.statement.getNormalNode();
        }
    }
    
    /**
     * Gets the loop's statement.
     * @return The loop's statement.
     */
    public NodeUnion<? extends StatementNode> getUnionForStatement()
    {
        checkStatementWrapped();
        if (this.statement == null)
        {
            this.statement = new NormalNodeUnion<StatementNode>(null);
        }
        return this.statement;
    }
    
    /**
     * Changes the loop's statement.
     * @param statement The loop's statement.
     */
    public void setStatement(StatementNode statement)
    {
        checkStatementWrapped();
        this.setUnionForStatement(new NormalNodeUnion<StatementNode>(statement));
    }
    
    /**
     * Changes the loop's statement.
     * @param statement The loop's statement.
     */
    public void setUnionForStatement(NodeUnion<? extends StatementNode> statement)
    {
        checkStatementWrapped();
        this.getManager().assertMutatable(this);
        this.doSetStatement(statement);
        if (this.getManager().isRecordingEdits())
            super.recordEdit(new ForLoopNodeSetStatementPropertyEditScriptElementImpl(this.getManager().getCurrentMetaprogramId(), this.getUid(), statement.getNodeValue() == null ? null : statement.getNodeValue().getUid()));
    }
    
    private void doSetStatement(NodeUnion<? extends StatementNode> statement)
    {
        if (statement == null)
        {
            statement = new NormalNodeUnion<StatementNode>(null);
        }
        if (this.statement != null)
        {
            setAsChild(this.statement.getNodeValue(), false);
        }
        this.statement = statement;
        setAsChild(statement.getNodeValue(), true);
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
            super.recordEdit(new ForLoopNodeSetMetaAnnotationsPropertyEditScriptElementImpl(this.getManager().getCurrentMetaprogramId(), this.getUid(), metaAnnotations.getNodeValue() == null ? null : metaAnnotations.getNodeValue().getUid()));
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
        if (this.getUnionForInitializer().getNodeValue() != null)
        {
            this.getUnionForInitializer().getNodeValue().receive(visitor);
        }
        if (this.getUnionForCondition().getNodeValue() != null)
        {
            this.getUnionForCondition().getNodeValue().receive(visitor);
        }
        if (this.getUnionForUpdate().getNodeValue() != null)
        {
            this.getUnionForUpdate().getNodeValue().receive(visitor);
        }
        if (this.getUnionForStatement().getNodeValue() != null)
        {
            this.getUnionForStatement().getNodeValue().receive(visitor);
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
        if (this.getUnionForInitializer().getNodeValue() != null)
        {
            this.getUnionForInitializer().getNodeValue().receiveTyped(visitor);
        }
        if (this.getUnionForCondition().getNodeValue() != null)
        {
            this.getUnionForCondition().getNodeValue().receiveTyped(visitor);
        }
        if (this.getUnionForUpdate().getNodeValue() != null)
        {
            this.getUnionForUpdate().getNodeValue().receiveTyped(visitor);
        }
        if (this.getUnionForStatement().getNodeValue() != null)
        {
            this.getUnionForStatement().getNodeValue().receiveTyped(visitor);
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
        visitor.visitForLoopNodeStart(this, true);
        visitor.visitNodeStart(this);
        visitor.visitStatementNodeStart(this);
        visitor.visitStartEnd(this);
        receiveTypedToChildren(visitor);
        visitor.visitStopBegin(this);
        visitor.visitStatementNodeStop(this);
        visitor.visitNodeStop(this);
        visitor.visitForLoopNodeStop(this, true);
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
        list.add(getUnionForInitializer());
        list.add(getUnionForCondition());
        list.add(getUnionForUpdate());
        list.add(getUnionForStatement());
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
        return Arrays.asList(new Node[]{getUnionForInitializer().getNodeValue(), getUnionForCondition().getNodeValue(), getUnionForUpdate().getNodeValue(), getUnionForStatement().getNodeValue(), getUnionForMetaAnnotations().getNodeValue()});
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
        sb.append("initializer=");
        sb.append(this.getUnionForInitializer().getNodeValue() == null? "null" : this.getUnionForInitializer().getNodeValue().getClass().getSimpleName());
        sb.append(',');
        sb.append("condition=");
        sb.append(this.getUnionForCondition().getNodeValue() == null? "null" : this.getUnionForCondition().getNodeValue().getClass().getSimpleName());
        sb.append(',');
        sb.append("update=");
        sb.append(this.getUnionForUpdate().getNodeValue() == null? "null" : this.getUnionForUpdate().getNodeValue().getClass().getSimpleName());
        sb.append(',');
        sb.append("statement=");
        sb.append(this.getUnionForStatement().getNodeValue() == null? "null" : this.getUnionForStatement().getNodeValue().getClass().getSimpleName());
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
        return operation.executeForLoopNode(this, p);
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
        return operation.executeForLoopNode(this, p1, p2);
    }
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public ForLoopNode deepCopy(BsjNodeFactory factory)
    {
        NodeUnion<? extends ForInitializerNode> initializerCopy;
        switch (getUnionForInitializer().getType())
        {
            case NORMAL:
                if (getUnionForInitializer().getNormalNode() == null)
                {
                    initializerCopy = factory.<ForInitializerNode>makeNormalNodeUnion(null);
                } else
                {
                    initializerCopy = factory.makeNormalNodeUnion(getUnionForInitializer().getNormalNode().deepCopy(factory));
                }
                break;
            case SPLICE:
                if (getUnionForInitializer().getSpliceNode() == null)
                {
                    initializerCopy = factory.<ForInitializerNode>makeSpliceNodeUnion(null);
                } else
                {
                    initializerCopy = factory.makeSpliceNodeUnion(getUnionForInitializer().getSpliceNode().deepCopy(factory));
                }
                break;
            default:
                throw new IllegalStateException("Unrecognized union component type: " + getUnionForInitializer().getType());
        }
        NodeUnion<? extends ExpressionNode> conditionCopy;
        switch (getUnionForCondition().getType())
        {
            case NORMAL:
                if (getUnionForCondition().getNormalNode() == null)
                {
                    conditionCopy = factory.<ExpressionNode>makeNormalNodeUnion(null);
                } else
                {
                    conditionCopy = factory.makeNormalNodeUnion(getUnionForCondition().getNormalNode().deepCopy(factory));
                }
                break;
            case SPLICE:
                if (getUnionForCondition().getSpliceNode() == null)
                {
                    conditionCopy = factory.<ExpressionNode>makeSpliceNodeUnion(null);
                } else
                {
                    conditionCopy = factory.makeSpliceNodeUnion(getUnionForCondition().getSpliceNode().deepCopy(factory));
                }
                break;
            default:
                throw new IllegalStateException("Unrecognized union component type: " + getUnionForCondition().getType());
        }
        NodeUnion<? extends StatementExpressionListNode> updateCopy;
        switch (getUnionForUpdate().getType())
        {
            case NORMAL:
                if (getUnionForUpdate().getNormalNode() == null)
                {
                    updateCopy = factory.<StatementExpressionListNode>makeNormalNodeUnion(null);
                } else
                {
                    updateCopy = factory.makeNormalNodeUnion(getUnionForUpdate().getNormalNode().deepCopy(factory));
                }
                break;
            case SPLICE:
                if (getUnionForUpdate().getSpliceNode() == null)
                {
                    updateCopy = factory.<StatementExpressionListNode>makeSpliceNodeUnion(null);
                } else
                {
                    updateCopy = factory.makeSpliceNodeUnion(getUnionForUpdate().getSpliceNode().deepCopy(factory));
                }
                break;
            default:
                throw new IllegalStateException("Unrecognized union component type: " + getUnionForUpdate().getType());
        }
        NodeUnion<? extends StatementNode> statementCopy;
        switch (getUnionForStatement().getType())
        {
            case NORMAL:
                if (getUnionForStatement().getNormalNode() == null)
                {
                    statementCopy = factory.<StatementNode>makeNormalNodeUnion(null);
                } else
                {
                    statementCopy = factory.makeNormalNodeUnion(getUnionForStatement().getNormalNode().deepCopy(factory));
                }
                break;
            case SPLICE:
                if (getUnionForStatement().getSpliceNode() == null)
                {
                    statementCopy = factory.<StatementNode>makeSpliceNodeUnion(null);
                } else
                {
                    statementCopy = factory.makeSpliceNodeUnion(getUnionForStatement().getSpliceNode().deepCopy(factory));
                }
                break;
            default:
                throw new IllegalStateException("Unrecognized union component type: " + getUnionForStatement().getType());
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
        return factory.makeForLoopNodeWithUnions(
                initializerCopy,
                conditionCopy,
                updateCopy,
                statementCopy,
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
        
        if (before.equals(this.getUnionForInitializer().getNodeValue()))
        {
            setInitializer((ForInitializerNode)after);
            return true;
        }
        if (before.equals(this.getUnionForCondition().getNodeValue()))
        {
            setCondition((ExpressionNode)after);
            return true;
        }
        if (before.equals(this.getUnionForUpdate().getNodeValue()))
        {
            setUpdate((StatementExpressionListNode)after);
            return true;
        }
        if (before.equals(this.getUnionForStatement().getNodeValue()))
        {
            setStatement((StatementNode)after);
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
