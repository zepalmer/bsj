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
import edu.jhu.cs.bsj.compiler.ast.node.EnhancedForLoopNode;
import edu.jhu.cs.bsj.compiler.ast.node.ExpressionNode;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.StatementNode;
import edu.jhu.cs.bsj.compiler.ast.node.VariableNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaAnnotationListNode;
import edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeManager;
import edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactory;
import edu.jhu.cs.bsj.compiler.impl.ast.NormalNodeUnion;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.property.EnhancedForLoopNodeSetExpressionPropertyEditScriptElementImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.property.EnhancedForLoopNodeSetMetaAnnotationsPropertyEditScriptElementImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.property.EnhancedForLoopNodeSetStatementPropertyEditScriptElementImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.property.EnhancedForLoopNodeSetVariablePropertyEditScriptElementImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.properties.EnhancedForLoopNodeProperties;

@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class EnhancedForLoopNodeImpl extends NodeImpl implements EnhancedForLoopNode
{
    /** The iterator variable. */
    private NodeUnion<? extends VariableNode> variable;
    
    /** The loop's iterable expression. */
    private NodeUnion<? extends ExpressionNode> expression;
    
    /** The loop's statement. */
    private NodeUnion<? extends StatementNode> statement;
    
    /** The meta-annotations associated with this node. */
    private NodeUnion<? extends MetaAnnotationListNode> metaAnnotations;
    
    /**
     * A set of those properties which have been populated from the backing node.
     * This field is <code>null</code> if <tt>backingNode</tt> is <code>null</code>.
     */
    private Set<EnhancedForLoopNodeProperties> populatedProperties;
    
    /** General constructor. */
    public EnhancedForLoopNodeImpl(
            NodeUnion<? extends VariableNode> variable,
            NodeUnion<? extends ExpressionNode> expression,
            NodeUnion<? extends StatementNode> statement,
            NodeUnion<? extends MetaAnnotationListNode> metaAnnotations,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation,
            BsjNodeManager manager,
            boolean binary)
    {
        super(startLocation, stopLocation, manager, binary);
        this.populatedProperties = null;
        doSetVariable(variable);
        doSetExpression(expression);
        doSetStatement(statement);
        doSetMetaAnnotations(metaAnnotations);
    }
    
    /** Proxy constructor. */
    public EnhancedForLoopNodeImpl(BsjNodeManager manager, BsjNodeProxyFactory proxyFactory, EnhancedForLoopNode backingNode)
    {
        super(manager, proxyFactory, backingNode);
        this.populatedProperties = EnumSet.noneOf(EnhancedForLoopNodeProperties.class);
    }
    
    /** Retrieves this node's backing node (if one exists). */
    protected EnhancedForLoopNode getBackingNode()
    {
        return (EnhancedForLoopNode)super.getBackingNode();
    }
    
    /**
     * Ensures that the variable value has been populated from proxy.
     * If this node is not backed by a proxy or if the value has already been
     * populated, this method does nothing.
     */
    private void checkVariableWrapped()
    {
        if (this.populatedProperties == null || this.populatedProperties.contains(
                EnhancedForLoopNodeProperties.VARIABLE))
            return;
        this.populatedProperties.add(EnhancedForLoopNodeProperties.VARIABLE);
        NodeUnion<? extends VariableNode> union = this.getBackingNode().getUnionForVariable();
        switch (union.getType())
        {
            case NORMAL:
                union = this.getProxyFactory().makeNormalNodeUnion(
                        this.getProxyFactory().makeVariableNode(union.getNormalNode()));
                break;
            case SPLICE:
                union = this.getProxyFactory().makeSpliceNodeUnion(
                        this.getProxyFactory().makeSpliceNode(union.getSpliceNode()));
                break;
            default:
                throw new IllegalStateException("Unrecognized union type: " + union.getType());
        }
        this.variable = union;
    }
    
    /**
     * Ensures that the expression value has been populated from proxy.
     * If this node is not backed by a proxy or if the value has already been
     * populated, this method does nothing.
     */
    private void checkExpressionWrapped()
    {
        if (this.populatedProperties == null || this.populatedProperties.contains(
                EnhancedForLoopNodeProperties.EXPRESSION))
            return;
        this.populatedProperties.add(EnhancedForLoopNodeProperties.EXPRESSION);
        NodeUnion<? extends ExpressionNode> union = this.getBackingNode().getUnionForExpression();
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
        this.expression = union;
    }
    
    /**
     * Ensures that the statement value has been populated from proxy.
     * If this node is not backed by a proxy or if the value has already been
     * populated, this method does nothing.
     */
    private void checkStatementWrapped()
    {
        if (this.populatedProperties == null || this.populatedProperties.contains(
                EnhancedForLoopNodeProperties.STATEMENT))
            return;
        this.populatedProperties.add(EnhancedForLoopNodeProperties.STATEMENT);
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
                EnhancedForLoopNodeProperties.META_ANNOTATIONS))
            return;
        this.populatedProperties.add(EnhancedForLoopNodeProperties.META_ANNOTATIONS);
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
     * Gets the iterator variable.  This property's value is assumed to be a normal node.
     * @return The iterator variable.
     * @throws ClassCastException If this property's value is not a normal node.
     */
    public VariableNode getVariable()
    {
        checkVariableWrapped();
        if (this.variable == null)
        {
            return null;
        } else
        {
            return this.variable.getNormalNode();
        }
    }
    
    /**
     * Gets the iterator variable.
     * @return The iterator variable.
     */
    public NodeUnion<? extends VariableNode> getUnionForVariable()
    {
        checkVariableWrapped();
        if (this.variable == null)
        {
            this.variable = new NormalNodeUnion<VariableNode>(null);
        }
        return this.variable;
    }
    
    /**
     * Changes the iterator variable.
     * @param variable The iterator variable.
     */
    public void setVariable(VariableNode variable)
    {
        checkVariableWrapped();
        this.setUnionForVariable(new NormalNodeUnion<VariableNode>(variable));
    }
    
    /**
     * Changes the iterator variable.
     * @param variable The iterator variable.
     */
    public void setUnionForVariable(NodeUnion<? extends VariableNode> variable)
    {
        checkVariableWrapped();
        this.getManager().assertMutatable(this);
        this.doSetVariable(variable);
        if (this.getManager().isRecordingEdits())
            super.recordEdit(new EnhancedForLoopNodeSetVariablePropertyEditScriptElementImpl(this.getManager().getCurrentMetaprogramId(), this.getUid(), variable.getNodeValue() == null ? null : variable.getNodeValue().getUid()));
    }
    
    private void doSetVariable(NodeUnion<? extends VariableNode> variable)
    {
        if (variable == null)
        {
            variable = new NormalNodeUnion<VariableNode>(null);
        }
        if (this.variable != null)
        {
            setAsChild(this.variable.getNodeValue(), false);
        }
        this.variable = variable;
        setAsChild(variable.getNodeValue(), true);
    }
    
    /**
     * Gets the loop's iterable expression.  This property's value is assumed to be a normal node.
     * @return The loop's iterable expression.
     * @throws ClassCastException If this property's value is not a normal node.
     */
    public ExpressionNode getExpression()
    {
        checkExpressionWrapped();
        if (this.expression == null)
        {
            return null;
        } else
        {
            return this.expression.getNormalNode();
        }
    }
    
    /**
     * Gets the loop's iterable expression.
     * @return The loop's iterable expression.
     */
    public NodeUnion<? extends ExpressionNode> getUnionForExpression()
    {
        checkExpressionWrapped();
        if (this.expression == null)
        {
            this.expression = new NormalNodeUnion<ExpressionNode>(null);
        }
        return this.expression;
    }
    
    /**
     * Changes the loop's iterable expression.
     * @param expression The loop's iterable expression.
     */
    public void setExpression(ExpressionNode expression)
    {
        checkExpressionWrapped();
        this.setUnionForExpression(new NormalNodeUnion<ExpressionNode>(expression));
    }
    
    /**
     * Changes the loop's iterable expression.
     * @param expression The loop's iterable expression.
     */
    public void setUnionForExpression(NodeUnion<? extends ExpressionNode> expression)
    {
        checkExpressionWrapped();
        this.getManager().assertMutatable(this);
        this.doSetExpression(expression);
        if (this.getManager().isRecordingEdits())
            super.recordEdit(new EnhancedForLoopNodeSetExpressionPropertyEditScriptElementImpl(this.getManager().getCurrentMetaprogramId(), this.getUid(), expression.getNodeValue() == null ? null : expression.getNodeValue().getUid()));
    }
    
    private void doSetExpression(NodeUnion<? extends ExpressionNode> expression)
    {
        if (expression == null)
        {
            expression = new NormalNodeUnion<ExpressionNode>(null);
        }
        if (this.expression != null)
        {
            setAsChild(this.expression.getNodeValue(), false);
        }
        this.expression = expression;
        setAsChild(expression.getNodeValue(), true);
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
            super.recordEdit(new EnhancedForLoopNodeSetStatementPropertyEditScriptElementImpl(this.getManager().getCurrentMetaprogramId(), this.getUid(), statement.getNodeValue() == null ? null : statement.getNodeValue().getUid()));
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
            super.recordEdit(new EnhancedForLoopNodeSetMetaAnnotationsPropertyEditScriptElementImpl(this.getManager().getCurrentMetaprogramId(), this.getUid(), metaAnnotations.getNodeValue() == null ? null : metaAnnotations.getNodeValue().getUid()));
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
        if (this.getUnionForVariable().getNodeValue() != null)
        {
            this.getUnionForVariable().getNodeValue().receive(visitor);
        }
        if (this.getUnionForExpression().getNodeValue() != null)
        {
            this.getUnionForExpression().getNodeValue().receive(visitor);
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
        if (this.getUnionForVariable().getNodeValue() != null)
        {
            this.getUnionForVariable().getNodeValue().receiveTyped(visitor);
        }
        if (this.getUnionForExpression().getNodeValue() != null)
        {
            this.getUnionForExpression().getNodeValue().receiveTyped(visitor);
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
        visitor.visitEnhancedForLoopNodeStart(this, true);
        visitor.visitNodeStart(this);
        visitor.visitStatementNodeStart(this);
        visitor.visitStartEnd(this);
        receiveTypedToChildren(visitor);
        visitor.visitStopBegin(this);
        visitor.visitStatementNodeStop(this);
        visitor.visitNodeStop(this);
        visitor.visitEnhancedForLoopNodeStop(this, true);
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
        list.add(getUnionForVariable());
        list.add(getUnionForExpression());
        list.add(getUnionForStatement());
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
        map.put("variable", getUnionForVariable());
        map.put("expression", getUnionForExpression());
        map.put("statement", getUnionForStatement());
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
        return Arrays.asList(new Node[]{getUnionForVariable().getNodeValue(), getUnionForExpression().getNodeValue(), getUnionForStatement().getNodeValue(), getUnionForMetaAnnotations().getNodeValue()});
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
        sb.append("variable=");
        sb.append(this.getUnionForVariable().getNodeValue() == null? "null" : this.getUnionForVariable().getNodeValue().getClass().getSimpleName());
        sb.append(',');
        sb.append("expression=");
        sb.append(this.getUnionForExpression().getNodeValue() == null? "null" : this.getUnionForExpression().getNodeValue().getClass().getSimpleName());
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
        return operation.executeEnhancedForLoopNode(this, p);
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
        return operation.executeEnhancedForLoopNode(this, p1, p2);
    }
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public EnhancedForLoopNode deepCopy(BsjNodeFactory factory)
    {
        NodeUnion<? extends VariableNode> variableCopy;
        switch (getUnionForVariable().getType())
        {
            case NORMAL:
                if (getUnionForVariable().getNormalNode() == null)
                {
                    variableCopy = factory.<VariableNode>makeNormalNodeUnion(null);
                } else
                {
                    variableCopy = factory.makeNormalNodeUnion(getUnionForVariable().getNormalNode().deepCopy(factory));
                }
                break;
            case SPLICE:
                if (getUnionForVariable().getSpliceNode() == null)
                {
                    variableCopy = factory.<VariableNode>makeSpliceNodeUnion(null);
                } else
                {
                    variableCopy = factory.makeSpliceNodeUnion(getUnionForVariable().getSpliceNode().deepCopy(factory));
                }
                break;
            default:
                throw new IllegalStateException("Unrecognized union component type: " + getUnionForVariable().getType());
        }
        NodeUnion<? extends ExpressionNode> expressionCopy;
        switch (getUnionForExpression().getType())
        {
            case NORMAL:
                if (getUnionForExpression().getNormalNode() == null)
                {
                    expressionCopy = factory.<ExpressionNode>makeNormalNodeUnion(null);
                } else
                {
                    expressionCopy = factory.makeNormalNodeUnion(getUnionForExpression().getNormalNode().deepCopy(factory));
                }
                break;
            case SPLICE:
                if (getUnionForExpression().getSpliceNode() == null)
                {
                    expressionCopy = factory.<ExpressionNode>makeSpliceNodeUnion(null);
                } else
                {
                    expressionCopy = factory.makeSpliceNodeUnion(getUnionForExpression().getSpliceNode().deepCopy(factory));
                }
                break;
            default:
                throw new IllegalStateException("Unrecognized union component type: " + getUnionForExpression().getType());
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
        return factory.makeEnhancedForLoopNodeWithUnions(
                variableCopy,
                expressionCopy,
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
        
        if (before.equals(this.getUnionForVariable().getNodeValue()))
        {
            setVariable((VariableNode)after);
            return true;
        }
        if (before.equals(this.getUnionForExpression().getNodeValue()))
        {
            setExpression((ExpressionNode)after);
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
