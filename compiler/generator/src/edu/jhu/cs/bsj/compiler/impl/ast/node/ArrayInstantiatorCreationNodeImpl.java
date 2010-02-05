package edu.jhu.cs.bsj.compiler.impl.ast.node;

import java.util.List;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeOperation;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.BsjTypedNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.node.ArrayInstantiatorCreationNode;
import edu.jhu.cs.bsj.compiler.ast.node.BaseTypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.ExpressionNode;
import edu.jhu.cs.bsj.compiler.ast.node.ListNode;
import edu.jhu.cs.bsj.compiler.ast.node.Node;

@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class ArrayInstantiatorCreationNodeImpl extends ArrayCreationNodeImpl implements ArrayInstantiatorCreationNode
{
    /** The dimension expressions for this array. */
    private ListNode<ExpressionNode> dimExpressions;

    /** General constructor. */
    public ArrayInstantiatorCreationNodeImpl(
            ListNode<ExpressionNode> dimExpressions,
            BaseTypeNode baseType,
            int arrayLevels,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        super(baseType, arrayLevels, startLocation, stopLocation);
        setDimExpressions(dimExpressions);
    }

    /**
     * Gets the dimension expressions for this array.
     * @return The dimension expressions for this array.
     */
    public ListNode<ExpressionNode> getDimExpressions()
    {
        return this.dimExpressions;
    }

    /**
     * Changes the dimension expressions for this array.
     * @param dimExpressions The dimension expressions for this array.
     */
    public void setDimExpressions(ListNode<ExpressionNode> dimExpressions)
    {
        if (this.dimExpressions instanceof NodeImpl)
        {
            ((NodeImpl)this.dimExpressions).setParent(null);
        }
        this.dimExpressions = dimExpressions;
        if (this.dimExpressions instanceof NodeImpl)
        {
            ((NodeImpl)this.dimExpressions).setParent(this);
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
        if (this.dimExpressions != null)
        {
            this.dimExpressions.receive(visitor);
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
        if (this.dimExpressions != null)
        {
            this.dimExpressions.receiveTyped(visitor);
        }
    }

    @Override
    public void receiveTyped(BsjTypedNodeVisitor visitor)
    {
        visitor.visitStartBegin(this);
        visitor.visitArrayInstantiatorCreationNodeStart(this, true);
        visitor.visitArrayCreationNodeStart(this);
        visitor.visitNodeStart(this);
        visitor.visitStartEnd(this);
        receiveTypedToChildren(visitor);
        visitor.visitStopBegin(this);
        visitor.visitNodeStop(this);
        visitor.visitArrayCreationNodeStop(this);
        visitor.visitArrayInstantiatorCreationNodeStop(this, true);
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
        list.add(getDimExpressions());
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
        sb.append("dimExpressions=");
        sb.append(this.getDimExpressions() == null? "null" : this.getDimExpressions().getClass().getSimpleName());
        sb.append(',');
        sb.append("baseType=");
        sb.append(this.getBaseType() == null? "null" : this.getBaseType().getClass().getSimpleName());
        sb.append(',');
        sb.append("arrayLevels=");
        sb.append(String.valueOf(this.getArrayLevels()) + ":" + ("int"));
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
        return operation.executeArrayInstantiatorCreationNode(this, p);
    }

    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public ArrayInstantiatorCreationNode deepCopy(BsjNodeFactory factory)
    {
        return factory.makeArrayInstantiatorCreationNode(
                getDimExpressions().deepCopy(factory),
                getBaseType().deepCopy(factory),
                getArrayLevels());
    }
    /**
     * Performs replacement for this node.
     * @param before The node to replace.
     * @param after The node to replace the <tt>before</tt> node.
     * @return <code>true</code> if the replacement was successful; <code>false</code> if the
     *         specified <tt>before</tt> node is not a child of this node.
     */
    @SuppressWarnings("unchecked")
    public <N extends Node> boolean replace(N before, N after)
    {
        if (super.replace(before,after))
            return true;

        if (before.equals(this.dimExpressions) && (after instanceof ListNode<?>))
        {
            for (Object listval : ((ListNode<?>)after).getChildren())
            {
                ExpressionNode.class.cast(listval);
            }
            setDimExpressions((ListNode<ExpressionNode>)after);
            return true;
        }
        return false;
    }

}
