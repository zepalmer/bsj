package edu.jhu.cs.bsj.compiler.impl.ast.node;

import java.util.List;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BinaryOperator;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeOperation;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.BsjTypedNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.node.BinaryExpressionNode;
import edu.jhu.cs.bsj.compiler.ast.node.ExpressionNode;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeManager;

@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class BinaryExpressionNodeImpl extends NodeImpl implements BinaryExpressionNode
{
    /** The left operand of the expression. */
    private ExpressionNode leftOperand;
    
    /** The right operand of the expression. */
    private ExpressionNode rightOperand;
    
    /** The binary operator to apply. */
    private BinaryOperator operator;
    
    /** General constructor. */
    public BinaryExpressionNodeImpl(
            ExpressionNode leftOperand,
            ExpressionNode rightOperand,
            BinaryOperator operator,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation,
            BsjNodeManager manager)
    {
        super(startLocation, stopLocation, manager);
        setLeftOperand(leftOperand);
        setRightOperand(rightOperand);
        this.operator = operator;
    }
    
    /**
     * Gets the left operand of the expression.
     * @return The left operand of the expression.
     */
    public ExpressionNode getLeftOperand()
    {
        return this.leftOperand;
    }
    
    /**
     * Changes the left operand of the expression.
     * @param leftOperand The left operand of the expression.
     */
    public void setLeftOperand(ExpressionNode leftOperand)
    {
        getManager().assertMutatable(this);
        if (this.leftOperand instanceof NodeImpl)
        {
            ((NodeImpl)this.leftOperand).setParent(null);
        }
        this.leftOperand = leftOperand;
        if (this.leftOperand instanceof NodeImpl)
        {
            ((NodeImpl)this.leftOperand).setParent(this);
        }
    }
    
    /**
     * Gets the right operand of the expression.
     * @return The right operand of the expression.
     */
    public ExpressionNode getRightOperand()
    {
        return this.rightOperand;
    }
    
    /**
     * Changes the right operand of the expression.
     * @param rightOperand The right operand of the expression.
     */
    public void setRightOperand(ExpressionNode rightOperand)
    {
        getManager().assertMutatable(this);
        if (this.rightOperand instanceof NodeImpl)
        {
            ((NodeImpl)this.rightOperand).setParent(null);
        }
        this.rightOperand = rightOperand;
        if (this.rightOperand instanceof NodeImpl)
        {
            ((NodeImpl)this.rightOperand).setParent(this);
        }
    }
    
    /**
     * Gets the binary operator to apply.
     * @return The binary operator to apply.
     */
    public BinaryOperator getOperator()
    {
        return this.operator;
    }
    
    /**
     * Changes the binary operator to apply.
     * @param operator The binary operator to apply.
     */
    public void setOperator(BinaryOperator operator)
    {
        getManager().assertMutatable(this);
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
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public BinaryExpressionNode deepCopy(BsjNodeFactory factory)
    {
        return factory.makeBinaryExpressionNode(
                getLeftOperand().deepCopy(factory),
                getRightOperand().deepCopy(factory),
                getOperator(),
                getStartLocation() == null ? null : (BsjSourceLocation)(getStartLocation().clone()),
                getStopLocation() == null ? null : (BsjSourceLocation)(getStopLocation().clone()));
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
