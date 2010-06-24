package edu.jhu.cs.bsj.compiler.impl.ast.node;

import java.util.Iterator;
import java.util.List;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeOperation;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.BsjTypedNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.node.ArrayAccessNode;
import edu.jhu.cs.bsj.compiler.ast.node.ExpressionNode;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.RestrictedPrimaryExpressionNode;
import edu.jhu.cs.bsj.compiler.impl.ast.Attribute;
import edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeManager;

@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class ArrayAccessNodeImpl extends NodeImpl implements ArrayAccessNode
{
    /** The expression identifying the array. */
    private RestrictedPrimaryExpressionNode arrayExpression;
    
    /** The index into the array. */
    private ExpressionNode indexExpression;
    
    private static enum LocalAttribute implements edu.jhu.cs.bsj.compiler.impl.ast.Attribute
    {
        /** Attribute for the arrayExpression property. */
        ARRAY_EXPRESSION,
        /** Attribute for the indexExpression property. */
        INDEX_EXPRESSION,
    }
    
    /** General constructor. */
    public ArrayAccessNodeImpl(
            RestrictedPrimaryExpressionNode arrayExpression,
            ExpressionNode indexExpression,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation,
            BsjNodeManager manager,
            boolean binary)
    {
        super(startLocation, stopLocation, manager, binary);
        setArrayExpression(arrayExpression, false);
        setIndexExpression(indexExpression, false);
    }
    
    /**
     * Gets the expression identifying the array.
     * @return The expression identifying the array.
     */
    public RestrictedPrimaryExpressionNode getArrayExpression()
    {
        recordAccess(LocalAttribute.ARRAY_EXPRESSION, Attribute.AccessType.READ);
        return this.arrayExpression;
    }
    
    /**
     * Changes the expression identifying the array.
     * @param arrayExpression The expression identifying the array.
     */
    public void setArrayExpression(RestrictedPrimaryExpressionNode arrayExpression)
    {
            setArrayExpression(arrayExpression, true);
    }
    
    private void setArrayExpression(RestrictedPrimaryExpressionNode arrayExpression, boolean checkPermissions)
    {
        if (checkPermissions)
        {
            getManager().assertMutatable(this);
            recordAccess(LocalAttribute.ARRAY_EXPRESSION, Attribute.AccessType.STRONG_WRITE);
        }
        setAsChild(arrayExpression, false);
        this.arrayExpression = arrayExpression;
        setAsChild(arrayExpression, true);
    }
    
    /**
     * Gets the index into the array.
     * @return The index into the array.
     */
    public ExpressionNode getIndexExpression()
    {
        recordAccess(LocalAttribute.INDEX_EXPRESSION, Attribute.AccessType.READ);
        return this.indexExpression;
    }
    
    /**
     * Changes the index into the array.
     * @param indexExpression The index into the array.
     */
    public void setIndexExpression(ExpressionNode indexExpression)
    {
            setIndexExpression(indexExpression, true);
    }
    
    private void setIndexExpression(ExpressionNode indexExpression, boolean checkPermissions)
    {
        if (checkPermissions)
        {
            getManager().assertMutatable(this);
            recordAccess(LocalAttribute.INDEX_EXPRESSION, Attribute.AccessType.STRONG_WRITE);
        }
        setAsChild(indexExpression, false);
        this.indexExpression = indexExpression;
        setAsChild(indexExpression, true);
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
        if (this.arrayExpression != null)
        {
            this.arrayExpression.receive(visitor);
        }
        if (this.indexExpression != null)
        {
            this.indexExpression.receive(visitor);
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
        if (this.arrayExpression != null)
        {
            this.arrayExpression.receiveTyped(visitor);
        }
        if (this.indexExpression != null)
        {
            this.indexExpression.receiveTyped(visitor);
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
        visitor.visitArrayAccessNodeStart(this, true);
        visitor.visitNodeStart(this);
        visitor.visitRestrictedPrimaryExpressionNodeStart(this);
        visitor.visitStartEnd(this);
        receiveTypedToChildren(visitor);
        visitor.visitStopBegin(this);
        visitor.visitRestrictedPrimaryExpressionNodeStop(this);
        visitor.visitNodeStop(this);
        visitor.visitArrayAccessNodeStop(this, true);
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
        list.add(getArrayExpression());
        list.add(getIndexExpression());
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
        sb.append("arrayExpression=");
        sb.append(this.getArrayExpression() == null? "null" : this.getArrayExpression().getClass().getSimpleName());
        sb.append(',');
        sb.append("indexExpression=");
        sb.append(this.getIndexExpression() == null? "null" : this.getIndexExpression().getClass().getSimpleName());
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
        return operation.executeArrayAccessNode(this, p);
    }
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public ArrayAccessNode deepCopy(BsjNodeFactory factory)
    {
        return factory.makeArrayAccessNode(
                getArrayExpression()==null?null:getArrayExpression().deepCopy(factory),
                getIndexExpression()==null?null:getIndexExpression().deepCopy(factory),
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
        
        if (before.equals(this.getArrayExpression()) && (after instanceof RestrictedPrimaryExpressionNode))
        {
            setArrayExpression((RestrictedPrimaryExpressionNode)after);
            return true;
        }
        if (before.equals(this.getIndexExpression()) && (after instanceof ExpressionNode))
        {
            setIndexExpression((ExpressionNode)after);
            return true;
        }
        return false;
    }
    
}
