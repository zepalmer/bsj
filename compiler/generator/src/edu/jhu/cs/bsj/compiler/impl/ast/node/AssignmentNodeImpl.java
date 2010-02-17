package edu.jhu.cs.bsj.compiler.impl.ast.node;

import java.util.List;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.AssignmentOperator;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeOperation;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.BsjTypedNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.node.AssignmentNode;
import edu.jhu.cs.bsj.compiler.ast.node.ExpressionNode;
import edu.jhu.cs.bsj.compiler.ast.node.Node;

@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class AssignmentNodeImpl extends NodeImpl implements AssignmentNode
{
    /** The variable to which to assign a value. */
    private ExpressionNode variable;

    /** The assignment operator indicating the operation to perform. */
    private AssignmentOperator operator;

    /** The expression to use. */
    private ExpressionNode expression;

    /** General constructor. */
    public AssignmentNodeImpl(
            ExpressionNode variable,
            AssignmentOperator operator,
            ExpressionNode expression,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        super(startLocation, stopLocation);
        setVariable(variable);
        this.operator = operator;
        setExpression(expression);
    }

    /**
     * Gets the variable to which to assign a value.
     * @return The variable to which to assign a value.
     */
    public ExpressionNode getVariable()
    {
        return this.variable;
    }

    /**
     * Changes the variable to which to assign a value.
     * @param variable The variable to which to assign a value.
     */
    public void setVariable(ExpressionNode variable)
    {
        if (this.variable instanceof NodeImpl)
        {
            ((NodeImpl)this.variable).setParent(null);
        }
        this.variable = variable;
        if (this.variable instanceof NodeImpl)
        {
            ((NodeImpl)this.variable).setParent(this);
        }
    }

    /**
     * Gets the assignment operator indicating the operation to perform.
     * @return The assignment operator indicating the operation to perform.
     */
    public AssignmentOperator getOperator()
    {
        return this.operator;
    }

    /**
     * Changes the assignment operator indicating the operation to perform.
     * @param operator The assignment operator indicating the operation to perform.
     */
    public void setOperator(AssignmentOperator operator)
    {
        this.operator = operator;
    }

    /**
     * Gets the expression to use.
     * @return The expression to use.
     */
    public ExpressionNode getExpression()
    {
        return this.expression;
    }

    /**
     * Changes the expression to use.
     * @param expression The expression to use.
     */
    public void setExpression(ExpressionNode expression)
    {
        if (this.expression instanceof NodeImpl)
        {
            ((NodeImpl)this.expression).setParent(null);
        }
        this.expression = expression;
        if (this.expression instanceof NodeImpl)
        {
            ((NodeImpl)this.expression).setParent(this);
        }
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
        if (this.variable != null)
        {
            this.variable.receive(visitor);
        }
        if (this.expression != null)
        {
            this.expression.receive(visitor);
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
        if (this.variable != null)
        {
            this.variable.receiveTyped(visitor);
        }
        if (this.expression != null)
        {
            this.expression.receiveTyped(visitor);
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
        list.add(getVariable());
        list.add(getOperator());
        list.add(getExpression());
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
        sb.append("variable=");
        sb.append(this.getVariable() == null? "null" : this.getVariable().getClass().getSimpleName());
        sb.append(',');
        sb.append("operator=");
        sb.append(String.valueOf(this.getOperator()) + ":" + (this.getOperator() != null ? this.getOperator().getClass().getSimpleName() : "null"));
        sb.append(',');
        sb.append("expression=");
        sb.append(this.getExpression() == null? "null" : this.getExpression().getClass().getSimpleName());
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
        return operation.executeAssignmentNode(this, p);
    }

    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public AssignmentNode deepCopy(BsjNodeFactory factory)
    {
        return factory.makeAssignmentNode(
                getVariable().deepCopy(factory),
                getOperator(),
                getExpression().deepCopy(factory),
                (BsjSourceLocation)(getStartLocation().clone()),
                (BsjSourceLocation)(getStopLocation().clone()));
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
        
        if (before.equals(this.getVariable()) && (after instanceof ExpressionNode))
        {
            setVariable((ExpressionNode)after);
            return true;
        }
        if (before.equals(this.getExpression()) && (after instanceof ExpressionNode))
        {
            setExpression((ExpressionNode)after);
            return true;
        }
        return false;
    }
    
}
