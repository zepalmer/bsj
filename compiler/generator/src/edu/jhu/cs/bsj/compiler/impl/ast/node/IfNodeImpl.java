package edu.jhu.cs.bsj.compiler.impl.ast.node;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

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
import edu.jhu.cs.bsj.compiler.impl.ast.NormalNodeUnion;
import edu.jhu.cs.bsj.compiler.impl.ast.attribute.AttributeName;
import edu.jhu.cs.bsj.compiler.impl.ast.attribute.ReadWriteAttribute;

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
    
    private Map<LocalAttribute,ReadWriteAttribute> localAttributes = new EnumMap<LocalAttribute,ReadWriteAttribute>(LocalAttribute.class);
    private ReadWriteAttribute getAttribute(LocalAttribute attributeName)
    {
        ReadWriteAttribute attribute = localAttributes.get(attributeName);
        if (attribute == null)
        {
            attribute = new ReadWriteAttribute(IfNodeImpl.this, attributeName);
            localAttributes.put(attributeName, attribute);
        }
        return attribute;
    }
    private static enum LocalAttribute implements AttributeName
    {
        /** Attribute identifier for the condition property. */
        CONDITION,
        /** Attribute identifier for the thenStatement property. */
        THEN_STATEMENT,
        /** Attribute identifier for the elseStatement property. */
        ELSE_STATEMENT,
        /** Attribute identifier for the metaAnnotations property. */
        META_ANNOTATIONS,
    }
    
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
        setUnionForCondition(condition, false);
        setUnionForThenStatement(thenStatement, false);
        setUnionForElseStatement(elseStatement, false);
        setUnionForMetaAnnotations(metaAnnotations, false);
    }
    
    /**
     * Gets the condition.  This property's value is assumed to be a normal node.
     * @return The condition.
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
     * Gets the condition.
     * @return The condition.
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
     * Changes the condition.
     * @param condition The condition.
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
     * Changes the condition.
     * @param condition The condition.
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
     * Gets the then branch's statement.  This property's value is assumed to be a normal node.
     * @return The then branch's statement.
     * @throws ClassCastException If this property's value is not a normal node.
     */
    public StatementNode getThenStatement()
    {
        getAttribute(LocalAttribute.THEN_STATEMENT).recordAccess(ReadWriteAttribute.AccessType.READ);
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
        getAttribute(LocalAttribute.THEN_STATEMENT).recordAccess(ReadWriteAttribute.AccessType.READ);
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
            setThenStatement(thenStatement, true);
            getManager().notifyChange(this);
    }
    
    private void setThenStatement(StatementNode thenStatement, boolean checkPermissions)
    {
        if (checkPermissions)
        {
            getManager().assertMutatable(this);
            getAttribute(LocalAttribute.THEN_STATEMENT).recordAccess(ReadWriteAttribute.AccessType.WRITE);
        }
        
        if (this.thenStatement != null)
        {
            setAsChild(this.thenStatement.getNodeValue(), false);
        }
        this.thenStatement = new NormalNodeUnion<StatementNode>(thenStatement);
        setAsChild(thenStatement, true);
    }
    
    /**
     * Changes the then branch's statement.
     * @param thenStatement The then branch's statement.
     */
    public void setUnionForThenStatement(NodeUnion<? extends StatementNode> thenStatement)
    {
            setUnionForThenStatement(thenStatement, true);
            getManager().notifyChange(this);
    }
    
    private void setUnionForThenStatement(NodeUnion<? extends StatementNode> thenStatement, boolean checkPermissions)
    {
        if (checkPermissions)
        {
            getManager().assertMutatable(this);
            getAttribute(LocalAttribute.THEN_STATEMENT).recordAccess(ReadWriteAttribute.AccessType.WRITE);
        }
        
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
        getAttribute(LocalAttribute.ELSE_STATEMENT).recordAccess(ReadWriteAttribute.AccessType.READ);
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
        getAttribute(LocalAttribute.ELSE_STATEMENT).recordAccess(ReadWriteAttribute.AccessType.READ);
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
            setElseStatement(elseStatement, true);
            getManager().notifyChange(this);
    }
    
    private void setElseStatement(StatementNode elseStatement, boolean checkPermissions)
    {
        if (checkPermissions)
        {
            getManager().assertMutatable(this);
            getAttribute(LocalAttribute.ELSE_STATEMENT).recordAccess(ReadWriteAttribute.AccessType.WRITE);
        }
        
        if (this.elseStatement != null)
        {
            setAsChild(this.elseStatement.getNodeValue(), false);
        }
        this.elseStatement = new NormalNodeUnion<StatementNode>(elseStatement);
        setAsChild(elseStatement, true);
    }
    
    /**
     * Changes the else branch's statement.
     * @param elseStatement The else branch's statement.
     */
    public void setUnionForElseStatement(NodeUnion<? extends StatementNode> elseStatement)
    {
            setUnionForElseStatement(elseStatement, true);
            getManager().notifyChange(this);
    }
    
    private void setUnionForElseStatement(NodeUnion<? extends StatementNode> elseStatement, boolean checkPermissions)
    {
        if (checkPermissions)
        {
            getManager().assertMutatable(this);
            getAttribute(LocalAttribute.ELSE_STATEMENT).recordAccess(ReadWriteAttribute.AccessType.WRITE);
        }
        
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
        if (this.condition.getNodeValue() != null)
        {
            this.condition.getNodeValue().receive(visitor);
        }
        if (this.thenStatement.getNodeValue() != null)
        {
            this.thenStatement.getNodeValue().receive(visitor);
        }
        if (this.elseStatement.getNodeValue() != null)
        {
            this.elseStatement.getNodeValue().receive(visitor);
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
        if (this.condition.getNodeValue() != null)
        {
            this.condition.getNodeValue().receiveTyped(visitor);
        }
        if (this.thenStatement.getNodeValue() != null)
        {
            this.thenStatement.getNodeValue().receiveTyped(visitor);
        }
        if (this.elseStatement.getNodeValue() != null)
        {
            this.elseStatement.getNodeValue().receiveTyped(visitor);
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
