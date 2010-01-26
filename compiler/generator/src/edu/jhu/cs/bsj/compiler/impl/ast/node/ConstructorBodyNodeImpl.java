package edu.jhu.cs.bsj.compiler.impl.ast.node;

import java.util.List;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeOperation;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.BsjTypedNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.node.BlockStatementNode;
import edu.jhu.cs.bsj.compiler.ast.node.ConstructorBodyNode;
import edu.jhu.cs.bsj.compiler.ast.node.ConstructorInvocationNode;
import edu.jhu.cs.bsj.compiler.ast.node.ListNode;

@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class ConstructorBodyNodeImpl extends NodeImpl implements ConstructorBodyNode
{
    /** The (nullable) constructor invocation. */
    private ConstructorInvocationNode constructorInvocation;

    /** The statements contained in this constructor. */
    private ListNode<BlockStatementNode> statements;

    /** General constructor. */
    public ConstructorBodyNodeImpl(
            ConstructorInvocationNode constructorInvocation,
            ListNode<BlockStatementNode> statements,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        super(startLocation, stopLocation);
        this.constructorInvocation = constructorInvocation;
        this.statements = statements;
    }

    /**
     * Gets the (nullable) constructor invocation.
     * @return The (nullable) constructor invocation.
     */
    public ConstructorInvocationNode getConstructorInvocation()
    {
        return this.constructorInvocation;
    }

    /**
     * Changes the (nullable) constructor invocation.
     * @param constructorInvocation The (nullable) constructor invocation.
     */
    public void setConstructorInvocation(ConstructorInvocationNode constructorInvocation)
    {
        if (this.constructorInvocation instanceof NodeImpl)
        {
            ((NodeImpl)this.constructorInvocation).setParent(null);
        }
        this.constructorInvocation = constructorInvocation;
        if (this.constructorInvocation instanceof NodeImpl)
        {
            ((NodeImpl)this.constructorInvocation).setParent(this);
        }
    }

    /**
     * Gets the statements contained in this constructor.
     * @return The statements contained in this constructor.
     */
    public ListNode<BlockStatementNode> getStatements()
    {
        return this.statements;
    }

    /**
     * Changes the statements contained in this constructor.
     * @param statements The statements contained in this constructor.
     */
    public void setStatements(ListNode<BlockStatementNode> statements)
    {
        if (this.statements instanceof NodeImpl)
        {
            ((NodeImpl)this.statements).setParent(null);
        }
        this.statements = statements;
        if (this.statements instanceof NodeImpl)
        {
            ((NodeImpl)this.statements).setParent(this);
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
        this.constructorInvocation.receive(visitor);
        this.statements.receive(visitor);
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
        this.constructorInvocation.receiveTyped(visitor);
        this.statements.receiveTyped(visitor);
    }

    @Override
    public void receiveTyped(BsjTypedNodeVisitor visitor)
    {
        visitor.visitStartBegin(this);
        visitor.visitConstructorBodyNodeStart(this, true);
        visitor.visitNodeStart(this);
        visitor.visitStartEnd(this);
        receiveTypedToChildren(visitor);
        visitor.visitStopBegin(this);
        visitor.visitNodeStart(this);
        visitor.visitConstructorBodyNodeStart(this, true);
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
        list.add(getConstructorInvocation());
        list.add(getStatements());
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
        sb.append("constructorInvocation=");
        sb.append(this.getConstructorInvocation() == null? "null" : this.getConstructorInvocation().getClass().getSimpleName());
        sb.append(',');
        sb.append("statements=");
        sb.append(this.getStatements() == null? "null" : this.getStatements().getClass().getSimpleName());
        sb.append(',');
        sb.append("startLocation=");
        sb.append(String.valueOf(this.getStartLocation()) + ":" + this.getStartLocation() == null ? this.getStartLocation().getClass().getSimpleName() : "null");
        sb.append(',');
        sb.append("stopLocation=");
        sb.append(String.valueOf(this.getStopLocation()) + ":" + this.getStopLocation() == null ? this.getStopLocation().getClass().getSimpleName() : "null");
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
        return operation.executeConstructorBodyNode(this, p);
    }
}
