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
import edu.jhu.cs.bsj.compiler.ast.node.ExpressionNode;
import edu.jhu.cs.bsj.compiler.ast.node.IfNode;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.StatementNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaAnnotationListNode;
import edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeManager;
import edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactory;
import edu.jhu.cs.bsj.compiler.impl.ast.NormalNodeUnion;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.property.IfNodeSetConditionPropertyEditScriptElementImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.property.IfNodeSetElseStatementPropertyEditScriptElementImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.property.IfNodeSetMetaAnnotationsPropertyEditScriptElementImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.property.IfNodeSetThenStatementPropertyEditScriptElementImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.properties.IfNodeProperties;

@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class IfNodeImpl extends NodeImpl implements IfNode
{
    /** The condition. */
    private NodeUnion<? extends ExpressionNode> condition;
    
    /** The then branch's statement. */
    private NodeUnion<? extends StatementNode> thenStatement;
    
    /** The else branch's statement. */
    private NodeUnion<? extends StatementNode> elseStatement;
    
    /** The meta-annotations associated with this node. */
    private NodeUnion<? extends MetaAnnotationListNode> metaAnnotations;
    
    /**
     * A set of those properties which have been populated from the backing node.
     * This field is <code>null</code> if <tt>backingNode</tt> is <code>null</code>.
     */
    private Set<IfNodeProperties> populatedProperties;
    
    /** General constructor. */
    public IfNodeImpl(
            NodeUnion<? extends ExpressionNode> condition,
            NodeUnion<? extends StatementNode> thenStatement,
            NodeUnion<? extends StatementNode> elseStatement,
            NodeUnion<? extends MetaAnnotationListNode> metaAnnotations,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation,
            BsjNodeManager manager,
            boolean binary)
    {
        super(startLocation, stopLocation, manager, binary);
        this.populatedProperties = null;
        doSetCondition(condition);
        doSetThenStatement(thenStatement);
        doSetElseStatement(elseStatement);
        doSetMetaAnnotations(metaAnnotations);
    }
    
    /** Proxy constructor. */
    public IfNodeImpl(BsjNodeManager manager, BsjNodeProxyFactory proxyFactory, IfNode backingNode)
    {
        super(manager, proxyFactory, backingNode);
        this.populatedProperties = EnumSet.noneOf(IfNodeProperties.class);
    }
    
    /** Retrieves this node's backing node (if one exists). */
    protected IfNode getBackingNode()
    {
        return (IfNode)super.getBackingNode();
    }
    
    /**
     * Ensures that the condition value has been populated from proxy.
     * If this node is not backed by a proxy or if the value has already been
     * populated, this method does nothing.
     */
    private void checkConditionWrapped()
    {
        if (this.populatedProperties == null || this.populatedProperties.contains(
                IfNodeProperties.CONDITION))
            return;
        this.populatedProperties.add(IfNodeProperties.CONDITION);
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
     * Ensures that the thenStatement value has been populated from proxy.
     * If this node is not backed by a proxy or if the value has already been
     * populated, this method does nothing.
     */
    private void checkThenStatementWrapped()
    {
        if (this.populatedProperties == null || this.populatedProperties.contains(
                IfNodeProperties.THEN_STATEMENT))
            return;
        this.populatedProperties.add(IfNodeProperties.THEN_STATEMENT);
        NodeUnion<? extends StatementNode> union = this.getBackingNode().getUnionForThenStatement();
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
        this.thenStatement = union;
    }
    
    /**
     * Ensures that the elseStatement value has been populated from proxy.
     * If this node is not backed by a proxy or if the value has already been
     * populated, this method does nothing.
     */
    private void checkElseStatementWrapped()
    {
        if (this.populatedProperties == null || this.populatedProperties.contains(
                IfNodeProperties.ELSE_STATEMENT))
            return;
        this.populatedProperties.add(IfNodeProperties.ELSE_STATEMENT);
        NodeUnion<? extends StatementNode> union = this.getBackingNode().getUnionForElseStatement();
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
        this.elseStatement = union;
    }
    
    /**
     * Ensures that the metaAnnotations value has been populated from proxy.
     * If this node is not backed by a proxy or if the value has already been
     * populated, this method does nothing.
     */
    private void checkMetaAnnotationsWrapped()
    {
        if (this.populatedProperties == null || this.populatedProperties.contains(
                IfNodeProperties.META_ANNOTATIONS))
            return;
        this.populatedProperties.add(IfNodeProperties.META_ANNOTATIONS);
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
     * Gets the condition.  This property's value is assumed to be a normal node.
     * @return The condition.
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
     * Gets the condition.
     * @return The condition.
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
     * Changes the condition.
     * @param condition The condition.
     */
    public void setCondition(ExpressionNode condition)
    {
        checkConditionWrapped();
        this.setUnionForCondition(new NormalNodeUnion<ExpressionNode>(condition));
    }
    
    /**
     * Changes the condition.
     * @param condition The condition.
     */
    public void setUnionForCondition(NodeUnion<? extends ExpressionNode> condition)
    {
        checkConditionWrapped();
        this.getManager().assertMutatable(this);
        this.doSetCondition(condition);
        if (this.getManager().isRecordingEdits())
            super.recordEdit(new IfNodeSetConditionPropertyEditScriptElementImpl(this.getManager().getCurrentMetaprogramId(), this.getUid(), condition.getNodeValue() == null ? null : condition.getNodeValue().getUid()));
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
     * Gets the then branch's statement.  This property's value is assumed to be a normal node.
     * @return The then branch's statement.
     * @throws ClassCastException If this property's value is not a normal node.
     */
    public StatementNode getThenStatement()
    {
        checkThenStatementWrapped();
        if (this.thenStatement == null)
        {
            return null;
        } else
        {
            return this.thenStatement.getNormalNode();
        }
    }
    
    /**
     * Gets the then branch's statement.
     * @return The then branch's statement.
     */
    public NodeUnion<? extends StatementNode> getUnionForThenStatement()
    {
        checkThenStatementWrapped();
        if (this.thenStatement == null)
        {
            this.thenStatement = new NormalNodeUnion<StatementNode>(null);
        }
        return this.thenStatement;
    }
    
    /**
     * Changes the then branch's statement.
     * @param thenStatement The then branch's statement.
     */
    public void setThenStatement(StatementNode thenStatement)
    {
        checkThenStatementWrapped();
        this.setUnionForThenStatement(new NormalNodeUnion<StatementNode>(thenStatement));
    }
    
    /**
     * Changes the then branch's statement.
     * @param thenStatement The then branch's statement.
     */
    public void setUnionForThenStatement(NodeUnion<? extends StatementNode> thenStatement)
    {
        checkThenStatementWrapped();
        this.getManager().assertMutatable(this);
        this.doSetThenStatement(thenStatement);
        if (this.getManager().isRecordingEdits())
            super.recordEdit(new IfNodeSetThenStatementPropertyEditScriptElementImpl(this.getManager().getCurrentMetaprogramId(), this.getUid(), thenStatement.getNodeValue() == null ? null : thenStatement.getNodeValue().getUid()));
    }
    
    private void doSetThenStatement(NodeUnion<? extends StatementNode> thenStatement)
    {
        if (thenStatement == null)
        {
            thenStatement = new NormalNodeUnion<StatementNode>(null);
        }
        if (this.thenStatement != null)
        {
            setAsChild(this.thenStatement.getNodeValue(), false);
        }
        this.thenStatement = thenStatement;
        setAsChild(thenStatement.getNodeValue(), true);
    }
    
    /**
     * Gets the else branch's statement.  This property's value is assumed to be a normal node.
     * @return The else branch's statement.
     * @throws ClassCastException If this property's value is not a normal node.
     */
    public StatementNode getElseStatement()
    {
        checkElseStatementWrapped();
        if (this.elseStatement == null)
        {
            return null;
        } else
        {
            return this.elseStatement.getNormalNode();
        }
    }
    
    /**
     * Gets the else branch's statement.
     * @return The else branch's statement.
     */
    public NodeUnion<? extends StatementNode> getUnionForElseStatement()
    {
        checkElseStatementWrapped();
        if (this.elseStatement == null)
        {
            this.elseStatement = new NormalNodeUnion<StatementNode>(null);
        }
        return this.elseStatement;
    }
    
    /**
     * Changes the else branch's statement.
     * @param elseStatement The else branch's statement.
     */
    public void setElseStatement(StatementNode elseStatement)
    {
        checkElseStatementWrapped();
        this.setUnionForElseStatement(new NormalNodeUnion<StatementNode>(elseStatement));
    }
    
    /**
     * Changes the else branch's statement.
     * @param elseStatement The else branch's statement.
     */
    public void setUnionForElseStatement(NodeUnion<? extends StatementNode> elseStatement)
    {
        checkElseStatementWrapped();
        this.getManager().assertMutatable(this);
        this.doSetElseStatement(elseStatement);
        if (this.getManager().isRecordingEdits())
            super.recordEdit(new IfNodeSetElseStatementPropertyEditScriptElementImpl(this.getManager().getCurrentMetaprogramId(), this.getUid(), elseStatement.getNodeValue() == null ? null : elseStatement.getNodeValue().getUid()));
    }
    
    private void doSetElseStatement(NodeUnion<? extends StatementNode> elseStatement)
    {
        if (elseStatement == null)
        {
            elseStatement = new NormalNodeUnion<StatementNode>(null);
        }
        if (this.elseStatement != null)
        {
            setAsChild(this.elseStatement.getNodeValue(), false);
        }
        this.elseStatement = elseStatement;
        setAsChild(elseStatement.getNodeValue(), true);
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
            super.recordEdit(new IfNodeSetMetaAnnotationsPropertyEditScriptElementImpl(this.getManager().getCurrentMetaprogramId(), this.getUid(), metaAnnotations.getNodeValue() == null ? null : metaAnnotations.getNodeValue().getUid()));
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
        if (this.getUnionForCondition().getNodeValue() != null)
        {
            this.getUnionForCondition().getNodeValue().receive(visitor);
        }
        if (this.getUnionForThenStatement().getNodeValue() != null)
        {
            this.getUnionForThenStatement().getNodeValue().receive(visitor);
        }
        if (this.getUnionForElseStatement().getNodeValue() != null)
        {
            this.getUnionForElseStatement().getNodeValue().receive(visitor);
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
        if (this.getUnionForCondition().getNodeValue() != null)
        {
            this.getUnionForCondition().getNodeValue().receiveTyped(visitor);
        }
        if (this.getUnionForThenStatement().getNodeValue() != null)
        {
            this.getUnionForThenStatement().getNodeValue().receiveTyped(visitor);
        }
        if (this.getUnionForElseStatement().getNodeValue() != null)
        {
            this.getUnionForElseStatement().getNodeValue().receiveTyped(visitor);
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
        visitor.visitIfNodeStart(this, true);
        visitor.visitNodeStart(this);
        visitor.visitStatementNodeStart(this);
        visitor.visitStartEnd(this);
        receiveTypedToChildren(visitor);
        visitor.visitStopBegin(this);
        visitor.visitStatementNodeStop(this);
        visitor.visitNodeStop(this);
        visitor.visitIfNodeStop(this, true);
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
        list.add(getUnionForCondition());
        list.add(getUnionForThenStatement());
        list.add(getUnionForElseStatement());
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
        map.put("condition", getUnionForCondition());
        map.put("thenStatement", getUnionForThenStatement());
        map.put("elseStatement", getUnionForElseStatement());
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
        return Arrays.asList(new Node[]{getUnionForCondition().getNodeValue(), getUnionForThenStatement().getNodeValue(), getUnionForElseStatement().getNodeValue(), getUnionForMetaAnnotations().getNodeValue()});
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
        sb.append("condition=");
        sb.append(this.getUnionForCondition().getNodeValue() == null? "null" : this.getUnionForCondition().getNodeValue().getClass().getSimpleName());
        sb.append(',');
        sb.append("thenStatement=");
        sb.append(this.getUnionForThenStatement().getNodeValue() == null? "null" : this.getUnionForThenStatement().getNodeValue().getClass().getSimpleName());
        sb.append(',');
        sb.append("elseStatement=");
        sb.append(this.getUnionForElseStatement().getNodeValue() == null? "null" : this.getUnionForElseStatement().getNodeValue().getClass().getSimpleName());
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
        return operation.executeIfNode(this, p);
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
        return operation.executeIfNode(this, p1, p2);
    }
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public IfNode deepCopy(BsjNodeFactory factory)
    {
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
        NodeUnion<? extends StatementNode> thenStatementCopy;
        switch (getUnionForThenStatement().getType())
        {
            case NORMAL:
                if (getUnionForThenStatement().getNormalNode() == null)
                {
                    thenStatementCopy = factory.<StatementNode>makeNormalNodeUnion(null);
                } else
                {
                    thenStatementCopy = factory.makeNormalNodeUnion(getUnionForThenStatement().getNormalNode().deepCopy(factory));
                }
                break;
            case SPLICE:
                if (getUnionForThenStatement().getSpliceNode() == null)
                {
                    thenStatementCopy = factory.<StatementNode>makeSpliceNodeUnion(null);
                } else
                {
                    thenStatementCopy = factory.makeSpliceNodeUnion(getUnionForThenStatement().getSpliceNode().deepCopy(factory));
                }
                break;
            default:
                throw new IllegalStateException("Unrecognized union component type: " + getUnionForThenStatement().getType());
        }
        NodeUnion<? extends StatementNode> elseStatementCopy;
        switch (getUnionForElseStatement().getType())
        {
            case NORMAL:
                if (getUnionForElseStatement().getNormalNode() == null)
                {
                    elseStatementCopy = factory.<StatementNode>makeNormalNodeUnion(null);
                } else
                {
                    elseStatementCopy = factory.makeNormalNodeUnion(getUnionForElseStatement().getNormalNode().deepCopy(factory));
                }
                break;
            case SPLICE:
                if (getUnionForElseStatement().getSpliceNode() == null)
                {
                    elseStatementCopy = factory.<StatementNode>makeSpliceNodeUnion(null);
                } else
                {
                    elseStatementCopy = factory.makeSpliceNodeUnion(getUnionForElseStatement().getSpliceNode().deepCopy(factory));
                }
                break;
            default:
                throw new IllegalStateException("Unrecognized union component type: " + getUnionForElseStatement().getType());
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
        return factory.makeIfNodeWithUnions(
                conditionCopy,
                thenStatementCopy,
                elseStatementCopy,
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
        
        if (before.equals(this.getUnionForCondition().getNodeValue()))
        {
            setCondition((ExpressionNode)after);
            return true;
        }
        if (before.equals(this.getUnionForThenStatement().getNodeValue()))
        {
            setThenStatement((StatementNode)after);
            return true;
        }
        if (before.equals(this.getUnionForElseStatement().getNodeValue()))
        {
            setElseStatement((StatementNode)after);
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
