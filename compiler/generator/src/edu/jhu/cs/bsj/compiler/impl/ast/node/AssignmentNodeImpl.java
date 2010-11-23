package edu.jhu.cs.bsj.compiler.impl.ast.node;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.AssignmentOperator;
import edu.jhu.cs.bsj.compiler.ast.BsjAbortableNodeOperation;
import edu.jhu.cs.bsj.compiler.ast.BsjAbortableNodeOperation2Arguments;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.BsjTypedNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.NodeUnion;
import edu.jhu.cs.bsj.compiler.ast.node.AssignmentNode;
import edu.jhu.cs.bsj.compiler.ast.node.ExpressionNode;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeManager;
import edu.jhu.cs.bsj.compiler.impl.ast.NormalNodeUnion;
import edu.jhu.cs.bsj.compiler.impl.ast.attribute.AttributeName;
import edu.jhu.cs.bsj.compiler.impl.ast.attribute.ReadWriteAttribute;

@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class AssignmentNodeImpl extends NodeImpl implements AssignmentNode
{
    /** The variable to which to assign a value. */
    private NodeUnion<? extends ExpressionNode> variable;
    
    /** The assignment operator indicating the operation to perform. */
    private AssignmentOperator operator;
    
    /** The expression to use. */
    private NodeUnion<? extends ExpressionNode> expression;
    
    private Map<LocalAttribute,ReadWriteAttribute> localAttributes = new EnumMap<LocalAttribute,ReadWriteAttribute>(LocalAttribute.class);
    private ReadWriteAttribute getAttribute(LocalAttribute attributeName)
    {
        ReadWriteAttribute attribute = localAttributes.get(attributeName);
        if (attribute == null)
        {
            attribute = new ReadWriteAttribute(AssignmentNodeImpl.this, attributeName);
            localAttributes.put(attributeName, attribute);
        }
        return attribute;
    }
    private static enum LocalAttribute implements AttributeName
    {
        /** Attribute identifier for the variable property. */
        VARIABLE,
        /** Attribute identifier for the operator property. */
        OPERATOR,
        /** Attribute identifier for the expression property. */
        EXPRESSION,
    }
    
    /** General constructor. */
    public AssignmentNodeImpl(
            NodeUnion<? extends ExpressionNode> variable,
            AssignmentOperator operator,
            NodeUnion<? extends ExpressionNode> expression,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation,
            BsjNodeManager manager,
            boolean binary)
    {
        super(startLocation, stopLocation, manager, binary);
        setUnionForVariable(variable, false);
        this.operator = operator;
        setUnionForExpression(expression, false);
    }
    
    /**
     * Gets the variable to which to assign a value.  This property's value is assumed to be a normal node.
     * @return The variable to which to assign a value.
     * @throws ClassCastException If this property's value is not a normal node.
     */
    public ExpressionNode getVariable()
    {
        getAttribute(LocalAttribute.VARIABLE).recordAccess(ReadWriteAttribute.AccessType.READ);
        if (this.variable == null)
        {
            return null;
        } else
        {
            return this.variable.getNormalNode();
        }
    }
    
    /**
     * Gets the variable to which to assign a value.
     * @return The variable to which to assign a value.
     */
    public NodeUnion<? extends ExpressionNode> getUnionForVariable()
    {
        getAttribute(LocalAttribute.VARIABLE).recordAccess(ReadWriteAttribute.AccessType.READ);
        if (this.variable == null)
        {
            this.variable = new NormalNodeUnion<ExpressionNode>(null);
        }
        return this.variable;
    }
    
    /**
     * Changes the variable to which to assign a value.
     * @param variable The variable to which to assign a value.
     */
    public void setVariable(ExpressionNode variable)
    {
            setVariable(variable, true);
            getManager().notifyChange(this);
    }
    
    private void setVariable(ExpressionNode variable, boolean checkPermissions)
    {
        if (checkPermissions)
        {
            getManager().assertMutatable(this);
            getAttribute(LocalAttribute.VARIABLE).recordAccess(ReadWriteAttribute.AccessType.WRITE);
        }
        
        if (this.variable != null)
        {
            setAsChild(this.variable.getNodeValue(), false);
        }
        this.variable = new NormalNodeUnion<ExpressionNode>(variable);
        setAsChild(variable, true);
    }
    
    /**
     * Changes the variable to which to assign a value.
     * @param variable The variable to which to assign a value.
     */
    public void setUnionForVariable(NodeUnion<? extends ExpressionNode> variable)
    {
            setUnionForVariable(variable, true);
            getManager().notifyChange(this);
    }
    
    private void setUnionForVariable(NodeUnion<? extends ExpressionNode> variable, boolean checkPermissions)
    {
        if (checkPermissions)
        {
            getManager().assertMutatable(this);
            getAttribute(LocalAttribute.VARIABLE).recordAccess(ReadWriteAttribute.AccessType.WRITE);
        }
        
        if (variable == null)
        {
            variable = new NormalNodeUnion<ExpressionNode>(null);
        }
        if (this.variable != null)
        {
            setAsChild(this.variable.getNodeValue(), false);
        }
        this.variable = variable;
        setAsChild(variable.getNodeValue(), true);
    }
    
    /**
     * Gets the assignment operator indicating the operation to perform.
     * @return The assignment operator indicating the operation to perform.
     */
    public AssignmentOperator getOperator()
    {
        getAttribute(LocalAttribute.OPERATOR).recordAccess(ReadWriteAttribute.AccessType.READ);
        return this.operator;
    }
    
    /**
     * Changes the assignment operator indicating the operation to perform.
     * @param operator The assignment operator indicating the operation to perform.
     */
    public void setOperator(AssignmentOperator operator)
    {
            setOperator(operator, true);
            getManager().notifyChange(this);
    }
    
    private void setOperator(AssignmentOperator operator, boolean checkPermissions)
    {
        if (checkPermissions)
        {
            getManager().assertMutatable(this);
            getAttribute(LocalAttribute.OPERATOR).recordAccess(ReadWriteAttribute.AccessType.WRITE);
        }
        
        this.operator = operator;
    }
    
    /**
     * Gets the expression to use.  This property's value is assumed to be a normal node.
     * @return The expression to use.
     * @throws ClassCastException If this property's value is not a normal node.
     */
    public ExpressionNode getExpression()
    {
        getAttribute(LocalAttribute.EXPRESSION).recordAccess(ReadWriteAttribute.AccessType.READ);
        if (this.expression == null)
        {
            return null;
        } else
        {
            return this.expression.getNormalNode();
        }
    }
    
    /**
     * Gets the expression to use.
     * @return The expression to use.
     */
    public NodeUnion<? extends ExpressionNode> getUnionForExpression()
    {
        getAttribute(LocalAttribute.EXPRESSION).recordAccess(ReadWriteAttribute.AccessType.READ);
        if (this.expression == null)
        {
            this.expression = new NormalNodeUnion<ExpressionNode>(null);
        }
        return this.expression;
    }
    
    /**
     * Changes the expression to use.
     * @param expression The expression to use.
     */
    public void setExpression(ExpressionNode expression)
    {
            setExpression(expression, true);
            getManager().notifyChange(this);
    }
    
    private void setExpression(ExpressionNode expression, boolean checkPermissions)
    {
        if (checkPermissions)
        {
            getManager().assertMutatable(this);
            getAttribute(LocalAttribute.EXPRESSION).recordAccess(ReadWriteAttribute.AccessType.WRITE);
        }
        
        if (this.expression != null)
        {
            setAsChild(this.expression.getNodeValue(), false);
        }
        this.expression = new NormalNodeUnion<ExpressionNode>(expression);
        setAsChild(expression, true);
    }
    
    /**
     * Changes the expression to use.
     * @param expression The expression to use.
     */
    public void setUnionForExpression(NodeUnion<? extends ExpressionNode> expression)
    {
            setUnionForExpression(expression, true);
            getManager().notifyChange(this);
    }
    
    private void setUnionForExpression(NodeUnion<? extends ExpressionNode> expression, boolean checkPermissions)
    {
        if (checkPermissions)
        {
            getManager().assertMutatable(this);
            getAttribute(LocalAttribute.EXPRESSION).recordAccess(ReadWriteAttribute.AccessType.WRITE);
        }
        
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
        if (this.variable.getNodeValue() != null)
        {
            this.variable.getNodeValue().receive(visitor);
        }
        if (this.expression.getNodeValue() != null)
        {
            this.expression.getNodeValue().receive(visitor);
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
        if (this.variable.getNodeValue() != null)
        {
            this.variable.getNodeValue().receiveTyped(visitor);
        }
        if (this.expression.getNodeValue() != null)
        {
            this.expression.getNodeValue().receiveTyped(visitor);
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
        visitor.visitAssignmentNodeStart(this, true);
        visitor.visitNodeStart(this);
        visitor.visitStatementExpressionNodeStart(this);
        visitor.visitStartEnd(this);
        receiveTypedToChildren(visitor);
        visitor.visitStopBegin(this);
        visitor.visitStatementExpressionNodeStop(this);
        visitor.visitNodeStop(this);
        visitor.visitAssignmentNodeStop(this, true);
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
        list.add(getOperator());
        list.add(getUnionForExpression());
        return list;
    }
    
    /**
     * Returns an iterator over the children of this node.
     * @see Node#getChildIterator()
     */
    @Override
    public Iterable<? extends Node> getChildIterable()
    {
        return Arrays.asList(new Node[]{getUnionForVariable().getNodeValue(), getUnionForExpression().getNodeValue()});
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
        sb.append("variable=");
        sb.append(this.getUnionForVariable().getNodeValue() == null? "null" : this.getUnionForVariable().getNodeValue().getClass().getSimpleName());
        sb.append(',');
        sb.append("operator=");
        sb.append(String.valueOf(this.getOperator()) + ":" + (this.getOperator() != null ? this.getOperator().getClass().getSimpleName() : "null"));
        sb.append(',');
        sb.append("expression=");
        sb.append(this.getUnionForExpression().getNodeValue() == null? "null" : this.getUnionForExpression().getNodeValue().getClass().getSimpleName());
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
        return operation.executeAssignmentNode(this, p);
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
        return operation.executeAssignmentNode(this, p1, p2);
    }
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public AssignmentNode deepCopy(BsjNodeFactory factory)
    {
        NodeUnion<? extends ExpressionNode> variableCopy;
        switch (getUnionForVariable().getType())
        {
            case NORMAL:
                if (getUnionForVariable().getNormalNode() == null)
                {
                    variableCopy = factory.<ExpressionNode>makeNormalNodeUnion(null);
                } else
                {
                    variableCopy = factory.makeNormalNodeUnion(getUnionForVariable().getNormalNode().deepCopy(factory));
                }
                break;
            case SPLICE:
                if (getUnionForVariable().getSpliceNode() == null)
                {
                    variableCopy = factory.<ExpressionNode>makeSpliceNodeUnion(null);
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
        return factory.makeAssignmentNodeWithUnions(
                variableCopy,
                getOperator(),
                expressionCopy,
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
            setVariable((ExpressionNode)after);
            return true;
        }
        if (before.equals(this.getUnionForExpression().getNodeValue()))
        {
            setExpression((ExpressionNode)after);
            return true;
        }
        return false;
    }
    
}
