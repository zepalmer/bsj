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
import edu.jhu.cs.bsj.compiler.ast.node.ExpressionNode;
import edu.jhu.cs.bsj.compiler.ast.node.ForInitializerNode;
import edu.jhu.cs.bsj.compiler.ast.node.ForLoopNode;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.StatementNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.StatementExpressionListNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaAnnotationListNode;
import edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeManager;
import edu.jhu.cs.bsj.compiler.impl.ast.NormalNodeUnion;
import edu.jhu.cs.bsj.compiler.impl.ast.attribute.AttributeName;
import edu.jhu.cs.bsj.compiler.impl.ast.attribute.ReadWriteAttribute;

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
    
    private Map<LocalAttribute,ReadWriteAttribute> localAttributes = new EnumMap<LocalAttribute,ReadWriteAttribute>(LocalAttribute.class);
    private ReadWriteAttribute getAttribute(LocalAttribute attributeName)
    {
        ReadWriteAttribute attribute = localAttributes.get(attributeName);
        if (attribute == null)
        {
            attribute = new ReadWriteAttribute(ForLoopNodeImpl.this, attributeName);
            localAttributes.put(attributeName, attribute);
        }
        return attribute;
    }
    private static enum LocalAttribute implements AttributeName
    {
        /** Attribute identifier for the initializer property. */
        INITIALIZER,
        /** Attribute identifier for the condition property. */
        CONDITION,
        /** Attribute identifier for the update property. */
        UPDATE,
        /** Attribute identifier for the statement property. */
        STATEMENT,
        /** Attribute identifier for the metaAnnotations property. */
        META_ANNOTATIONS,
    }
    
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
        setUnionForInitializer(initializer, false);
        setUnionForCondition(condition, false);
        setUnionForUpdate(update, false);
        setUnionForStatement(statement, false);
        setUnionForMetaAnnotations(metaAnnotations, false);
    }
    
    /**
     * Gets the initializer used for this for loop.  This property's value is assumed to be a normal node.
     * @return The initializer used for this for loop.
     * @throws ClassCastException If this property's value is not a normal node.
     */
    public ForInitializerNode getInitializer()
    {
        getAttribute(LocalAttribute.INITIALIZER).recordAccess(ReadWriteAttribute.AccessType.READ);
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
        getAttribute(LocalAttribute.INITIALIZER).recordAccess(ReadWriteAttribute.AccessType.READ);
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
            setInitializer(initializer, true);
            getManager().notifyChange(this);
    }
    
    private void setInitializer(ForInitializerNode initializer, boolean checkPermissions)
    {
        if (checkPermissions)
        {
            getManager().assertMutatable(this);
            getAttribute(LocalAttribute.INITIALIZER).recordAccess(ReadWriteAttribute.AccessType.WRITE);
        }
        
        if (this.initializer != null)
        {
            setAsChild(this.initializer.getNodeValue(), false);
        }
        this.initializer = new NormalNodeUnion<ForInitializerNode>(initializer);
        setAsChild(initializer, true);
    }
    
    /**
     * Changes the initializer used for this for loop.
     * @param initializer The initializer used for this for loop.
     */
    public void setUnionForInitializer(NodeUnion<? extends ForInitializerNode> initializer)
    {
            setUnionForInitializer(initializer, true);
            getManager().notifyChange(this);
    }
    
    private void setUnionForInitializer(NodeUnion<? extends ForInitializerNode> initializer, boolean checkPermissions)
    {
        if (checkPermissions)
        {
            getManager().assertMutatable(this);
            getAttribute(LocalAttribute.INITIALIZER).recordAccess(ReadWriteAttribute.AccessType.WRITE);
        }
        
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
        getAttribute(LocalAttribute.CONDITION).recordAccess(ReadWriteAttribute.AccessType.READ);
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
        getAttribute(LocalAttribute.CONDITION).recordAccess(ReadWriteAttribute.AccessType.READ);
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
            setCondition(condition, true);
            getManager().notifyChange(this);
    }
    
    private void setCondition(ExpressionNode condition, boolean checkPermissions)
    {
        if (checkPermissions)
        {
            getManager().assertMutatable(this);
            getAttribute(LocalAttribute.CONDITION).recordAccess(ReadWriteAttribute.AccessType.WRITE);
        }
        
        if (this.condition != null)
        {
            setAsChild(this.condition.getNodeValue(), false);
        }
        this.condition = new NormalNodeUnion<ExpressionNode>(condition);
        setAsChild(condition, true);
    }
    
    /**
     * Changes the loop's termination condition.
     * @param condition The loop's termination condition.
     */
    public void setUnionForCondition(NodeUnion<? extends ExpressionNode> condition)
    {
            setUnionForCondition(condition, true);
            getManager().notifyChange(this);
    }
    
    private void setUnionForCondition(NodeUnion<? extends ExpressionNode> condition, boolean checkPermissions)
    {
        if (checkPermissions)
        {
            getManager().assertMutatable(this);
            getAttribute(LocalAttribute.CONDITION).recordAccess(ReadWriteAttribute.AccessType.WRITE);
        }
        
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
        getAttribute(LocalAttribute.UPDATE).recordAccess(ReadWriteAttribute.AccessType.READ);
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
        getAttribute(LocalAttribute.UPDATE).recordAccess(ReadWriteAttribute.AccessType.READ);
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
            setUpdate(update, true);
            getManager().notifyChange(this);
    }
    
    private void setUpdate(StatementExpressionListNode update, boolean checkPermissions)
    {
        if (checkPermissions)
        {
            getManager().assertMutatable(this);
            getAttribute(LocalAttribute.UPDATE).recordAccess(ReadWriteAttribute.AccessType.WRITE);
        }
        
        if (this.update != null)
        {
            setAsChild(this.update.getNodeValue(), false);
        }
        this.update = new NormalNodeUnion<StatementExpressionListNode>(update);
        setAsChild(update, true);
    }
    
    /**
     * Changes the loop's update operation.
     * @param update The loop's update operation.
     */
    public void setUnionForUpdate(NodeUnion<? extends StatementExpressionListNode> update)
    {
            setUnionForUpdate(update, true);
            getManager().notifyChange(this);
    }
    
    private void setUnionForUpdate(NodeUnion<? extends StatementExpressionListNode> update, boolean checkPermissions)
    {
        if (checkPermissions)
        {
            getManager().assertMutatable(this);
            getAttribute(LocalAttribute.UPDATE).recordAccess(ReadWriteAttribute.AccessType.WRITE);
        }
        
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
        getAttribute(LocalAttribute.STATEMENT).recordAccess(ReadWriteAttribute.AccessType.READ);
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
        getAttribute(LocalAttribute.STATEMENT).recordAccess(ReadWriteAttribute.AccessType.READ);
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
            setStatement(statement, true);
            getManager().notifyChange(this);
    }
    
    private void setStatement(StatementNode statement, boolean checkPermissions)
    {
        if (checkPermissions)
        {
            getManager().assertMutatable(this);
            getAttribute(LocalAttribute.STATEMENT).recordAccess(ReadWriteAttribute.AccessType.WRITE);
        }
        
        if (this.statement != null)
        {
            setAsChild(this.statement.getNodeValue(), false);
        }
        this.statement = new NormalNodeUnion<StatementNode>(statement);
        setAsChild(statement, true);
    }
    
    /**
     * Changes the loop's statement.
     * @param statement The loop's statement.
     */
    public void setUnionForStatement(NodeUnion<? extends StatementNode> statement)
    {
            setUnionForStatement(statement, true);
            getManager().notifyChange(this);
    }
    
    private void setUnionForStatement(NodeUnion<? extends StatementNode> statement, boolean checkPermissions)
    {
        if (checkPermissions)
        {
            getManager().assertMutatable(this);
            getAttribute(LocalAttribute.STATEMENT).recordAccess(ReadWriteAttribute.AccessType.WRITE);
        }
        
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
        if (this.initializer.getNodeValue() != null)
        {
            this.initializer.getNodeValue().receive(visitor);
        }
        if (this.condition.getNodeValue() != null)
        {
            this.condition.getNodeValue().receive(visitor);
        }
        if (this.update.getNodeValue() != null)
        {
            this.update.getNodeValue().receive(visitor);
        }
        if (this.statement.getNodeValue() != null)
        {
            this.statement.getNodeValue().receive(visitor);
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
        if (this.initializer.getNodeValue() != null)
        {
            this.initializer.getNodeValue().receiveTyped(visitor);
        }
        if (this.condition.getNodeValue() != null)
        {
            this.condition.getNodeValue().receiveTyped(visitor);
        }
        if (this.update.getNodeValue() != null)
        {
            this.update.getNodeValue().receiveTyped(visitor);
        }
        if (this.statement.getNodeValue() != null)
        {
            this.statement.getNodeValue().receiveTyped(visitor);
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
    public <P,R> R executeOperation(BsjNodeOperation<P,R> operation, P p)
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
    public <P1,P2,R> R executeOperation(BsjNodeOperation2Arguments<P1,P2,R> operation, P1 p1, P2 p2)
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
