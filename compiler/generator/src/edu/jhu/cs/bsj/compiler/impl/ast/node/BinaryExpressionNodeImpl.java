package edu.jhu.cs.bsj.compiler.impl.ast.node;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BinaryOperator;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeOperation;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeOperation2Arguments;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.BsjTypedNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.node.BinaryExpressionNode;
import edu.jhu.cs.bsj.compiler.ast.node.ExpressionNode;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeManager;
import edu.jhu.cs.bsj.compiler.impl.ast.attribute.ReadWriteAttribute;

@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class BinaryExpressionNodeImpl extends NodeImpl implements BinaryExpressionNode
{
    /** The left operand of the expression. */
    private ExpressionNode leftOperand;
    
    /** The right operand of the expression. */
    private ExpressionNode rightOperand;
    
    /** The binary operator to apply. */
    private BinaryOperator operator;
    
    private Map<LocalAttribute,ReadWriteAttribute> localAttributes = new EnumMap<LocalAttribute,ReadWriteAttribute>(LocalAttribute.class);
    private ReadWriteAttribute getAttribute(LocalAttribute attributeName)
    {
        ReadWriteAttribute attribute = localAttributes.get(attributeName);
        if (attribute == null)
        {
            attribute = new ReadWriteAttribute(BinaryExpressionNodeImpl.this);
            localAttributes.put(attributeName, attribute);
        }
        return attribute;
    }
    private static enum LocalAttribute
    {
        /** Attribute identifier for the leftOperand property. */
        LEFT_OPERAND,
        /** Attribute identifier for the rightOperand property. */
        RIGHT_OPERAND,
        /** Attribute identifier for the operator property. */
        OPERATOR,
    }
    
    /** General constructor. */
    public BinaryExpressionNodeImpl(
            ExpressionNode leftOperand,
            ExpressionNode rightOperand,
            BinaryOperator operator,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation,
            BsjNodeManager manager,
            boolean binary)
    {
        super(startLocation, stopLocation, manager, binary);
        setLeftOperand(leftOperand, false);
        setRightOperand(rightOperand, false);
        this.operator = operator;
    }
    
    /**
     * Gets the left operand of the expression.
     * @return The left operand of the expression.
     */
    public ExpressionNode getLeftOperand()
    {
        getAttribute(LocalAttribute.LEFT_OPERAND).recordAccess(ReadWriteAttribute.AccessType.READ);
        return this.leftOperand;
    }
    
    /**
     * Changes the left operand of the expression.
     * @param leftOperand The left operand of the expression.
     */
    public void setLeftOperand(ExpressionNode leftOperand)
    {
            setLeftOperand(leftOperand, true);
    }
    
    private void setLeftOperand(ExpressionNode leftOperand, boolean checkPermissions)
    {
        if (checkPermissions)
        {
            getManager().assertMutatable(this);
            getAttribute(LocalAttribute.LEFT_OPERAND).recordAccess(ReadWriteAttribute.AccessType.WRITE);
        }
        setAsChild(leftOperand, false);
        this.leftOperand = leftOperand;
        setAsChild(leftOperand, true);
    }
    
    /**
     * Gets the right operand of the expression.
     * @return The right operand of the expression.
     */
    public ExpressionNode getRightOperand()
    {
        getAttribute(LocalAttribute.RIGHT_OPERAND).recordAccess(ReadWriteAttribute.AccessType.READ);
        return this.rightOperand;
    }
    
    /**
     * Changes the right operand of the expression.
     * @param rightOperand The right operand of the expression.
     */
    public void setRightOperand(ExpressionNode rightOperand)
    {
            setRightOperand(rightOperand, true);
    }
    
    private void setRightOperand(ExpressionNode rightOperand, boolean checkPermissions)
    {
        if (checkPermissions)
        {
            getManager().assertMutatable(this);
            getAttribute(LocalAttribute.RIGHT_OPERAND).recordAccess(ReadWriteAttribute.AccessType.WRITE);
        }
        setAsChild(rightOperand, false);
        this.rightOperand = rightOperand;
        setAsChild(rightOperand, true);
    }
    
    /**
     * Gets the binary operator to apply.
     * @return The binary operator to apply.
     */
    public BinaryOperator getOperator()
    {
        getAttribute(LocalAttribute.OPERATOR).recordAccess(ReadWriteAttribute.AccessType.READ);
        return this.operator;
    }
    
    /**
     * Changes the binary operator to apply.
     * @param operator The binary operator to apply.
     */
    public void setOperator(BinaryOperator operator)
    {
            setOperator(operator, true);
    }
    
    private void setOperator(BinaryOperator operator, boolean checkPermissions)
    {
        if (checkPermissions)
        {
            getManager().assertMutatable(this);
            getAttribute(LocalAttribute.OPERATOR).recordAccess(ReadWriteAttribute.AccessType.WRITE);
        }
        this.operator = operator;
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
        if (this.leftOperand != null)
        {
            this.leftOperand.receive(visitor);
        }
        if (this.rightOperand != null)
        {
            this.rightOperand.receive(visitor);
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
        if (this.leftOperand != null)
        {
            this.leftOperand.receiveTyped(visitor);
        }
        if (this.rightOperand != null)
        {
            this.rightOperand.receiveTyped(visitor);
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
        visitor.visitBinaryExpressionNodeStart(this, true);
        visitor.visitNodeStart(this);
        visitor.visitNonAssignmentExpressionNodeStart(this);
        visitor.visitStartEnd(this);
        receiveTypedToChildren(visitor);
        visitor.visitStopBegin(this);
        visitor.visitNonAssignmentExpressionNodeStop(this);
        visitor.visitNodeStop(this);
        visitor.visitBinaryExpressionNodeStop(this, true);
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
        list.add(getLeftOperand());
        list.add(getRightOperand());
        list.add(getOperator());
        return list;
    }
    
    /**
     * Returns an iterator over the children of this node.
     * @see Node#getChildIterator()
     */
    @Override
    public Iterable<? extends Node> getChildIterable()
    {
        return Arrays.asList(new Node[]{getLeftOperand(), getRightOperand()});
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
        sb.append("leftOperand=");
        sb.append(this.getLeftOperand() == null? "null" : this.getLeftOperand().getClass().getSimpleName());
        sb.append(',');
        sb.append("rightOperand=");
        sb.append(this.getRightOperand() == null? "null" : this.getRightOperand().getClass().getSimpleName());
        sb.append(',');
        sb.append("operator=");
        sb.append(String.valueOf(this.getOperator()) + ":" + (this.getOperator() != null ? this.getOperator().getClass().getSimpleName() : "null"));
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
        return operation.executeBinaryExpressionNode(this, p);
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
        return operation.executeBinaryExpressionNode(this, p1, p2);
    }
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public BinaryExpressionNode deepCopy(BsjNodeFactory factory)
    {
        return factory.makeBinaryExpressionNode(
                getLeftOperand()==null?null:getLeftOperand().deepCopy(factory),
                getRightOperand()==null?null:getRightOperand().deepCopy(factory),
                getOperator(),
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
        
        if (before.equals(this.getLeftOperand()) && (after instanceof ExpressionNode))
        {
            setLeftOperand((ExpressionNode)after);
            return true;
        }
        if (before.equals(this.getRightOperand()) && (after instanceof ExpressionNode))
        {
            setRightOperand((ExpressionNode)after);
            return true;
        }
        return false;
    }
    
}
