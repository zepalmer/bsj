package edu.jhu.cs.bsj.compiler.impl.ast.node;

import java.util.List;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeOperation;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.BsjTypedNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.node.AssertStatementNode;
import edu.jhu.cs.bsj.compiler.ast.node.ExpressionNode;
import edu.jhu.cs.bsj.compiler.ast.node.Node;

@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class AssertStatementNodeImpl extends NodeImpl implements AssertStatementNode
{
    /** The assertion's test expression. */
    private ExpressionNode testExpression;

    /** The assertion's message expression. */
    private ExpressionNode messageExpression;

    /** General constructor. */
    public AssertStatementNodeImpl(
            ExpressionNode testExpression,
            ExpressionNode messageExpression,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        super(startLocation, stopLocation);
        setTestExpression(testExpression);
        setMessageExpression(messageExpression);
    }

    /**
     * Gets the assertion's test expression.
     * @return The assertion's test expression.
     */
    public ExpressionNode getTestExpression()
    {
        return this.testExpression;
    }

    /**
     * Changes the assertion's test expression.
     * @param testExpression The assertion's test expression.
     */
    public void setTestExpression(ExpressionNode testExpression)
    {
        if (this.testExpression instanceof NodeImpl)
        {
            ((NodeImpl)this.testExpression).setParent(null);
        }
        this.testExpression = testExpression;
        if (this.testExpression instanceof NodeImpl)
        {
            ((NodeImpl)this.testExpression).setParent(this);
        }
    }

    /**
     * Gets the assertion's message expression.
     * @return The assertion's message expression.
     */
    public ExpressionNode getMessageExpression()
    {
        return this.messageExpression;
    }

    /**
     * Changes the assertion's message expression.
     * @param messageExpression The assertion's message expression.
     */
    public void setMessageExpression(ExpressionNode messageExpression)
    {
        if (this.messageExpression instanceof NodeImpl)
        {
            ((NodeImpl)this.messageExpression).setParent(null);
        }
        this.messageExpression = messageExpression;
        if (this.messageExpression instanceof NodeImpl)
        {
            ((NodeImpl)this.messageExpression).setParent(this);
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
        if (this.testExpression != null)
        {
            this.testExpression.receive(visitor);
        }
        if (this.messageExpression != null)
        {
            this.messageExpression.receive(visitor);
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
        if (this.testExpression != null)
        {
            this.testExpression.receiveTyped(visitor);
        }
        if (this.messageExpression != null)
        {
            this.messageExpression.receiveTyped(visitor);
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
        list.add(getTestExpression());
        list.add(getMessageExpression());
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
        sb.append("testExpression=");
        sb.append(this.getTestExpression() == null? "null" : this.getTestExpression().getClass().getSimpleName());
        sb.append(',');
        sb.append("messageExpression=");
        sb.append(this.getMessageExpression() == null? "null" : this.getMessageExpression().getClass().getSimpleName());
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
        return operation.executeAssertStatementNode(this, p);
    }

    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public AssertStatementNode deepCopy(BsjNodeFactory factory)
    {
        return factory.makeAssertStatementNode(
                getTestExpression().deepCopy(factory),
                getMessageExpression().deepCopy(factory));
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
        
        if (before.equals(this.getTestExpression()) && (after instanceof ExpressionNode))
        {
            setTestExpression((ExpressionNode)after);
            return true;
        }
        if (before.equals(this.getMessageExpression()) && (after instanceof ExpressionNode))
        {
            setMessageExpression((ExpressionNode)after);
            return true;
        }
        return false;
    }
    
}
