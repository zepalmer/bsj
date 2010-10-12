package edu.jhu.cs.bsj.compiler.impl.ast.node;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeOperation;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeOperation2Arguments;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.BsjTypedNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.NodeUnion;
import edu.jhu.cs.bsj.compiler.ast.node.ArrayAccessNode;
import edu.jhu.cs.bsj.compiler.ast.node.ExpressionNode;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.RestrictedPrimaryExpressionNode;
import edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeManager;
import edu.jhu.cs.bsj.compiler.impl.ast.NormalNodeUnion;
import edu.jhu.cs.bsj.compiler.impl.ast.attribute.ReadWriteAttribute;

@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class ArrayAccessNodeImpl extends NodeImpl implements ArrayAccessNode
{
    /** The expression identifying the array. */
    private NodeUnion<? extends RestrictedPrimaryExpressionNode> arrayExpression;
    
    /** The index into the array. */
    private NodeUnion<? extends ExpressionNode> indexExpression;
    
    private Map<LocalAttribute,ReadWriteAttribute> localAttributes = new EnumMap<LocalAttribute,ReadWriteAttribute>(LocalAttribute.class);
    private ReadWriteAttribute getAttribute(LocalAttribute attributeName)
    {
        ReadWriteAttribute attribute = localAttributes.get(attributeName);
        if (attribute == null)
        {
            attribute = new ReadWriteAttribute(ArrayAccessNodeImpl.this);
            localAttributes.put(attributeName, attribute);
        }
        return attribute;
    }
    private static enum LocalAttribute
    {
        /** Attribute identifier for the arrayExpression property. */
        ARRAY_EXPRESSION,
        /** Attribute identifier for the indexExpression property. */
        INDEX_EXPRESSION,
    }
    
    /** General constructor. */
    public ArrayAccessNodeImpl(
            NodeUnion<? extends RestrictedPrimaryExpressionNode> arrayExpression,
            NodeUnion<? extends ExpressionNode> indexExpression,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation,
            BsjNodeManager manager,
            boolean binary)
    {
        super(startLocation, stopLocation, manager, binary);
        setUnionForArrayExpression(arrayExpression, false);
        setUnionForIndexExpression(indexExpression, false);
    }
    
    /**
     * Gets the expression identifying the array.  This property's value is assumed to be a normal node.
     * @return The expression identifying the array.
     * @throws ClassCastException If this property's value is not a normal node.
     */
    public RestrictedPrimaryExpressionNode getArrayExpression()
    {
        getAttribute(LocalAttribute.ARRAY_EXPRESSION).recordAccess(ReadWriteAttribute.AccessType.READ);
        if (this.arrayExpression == null)
        {
            return null;
        } else
        {
            return this.arrayExpression.getNormalNode();
        }
    }
    
    /**
     * Gets the expression identifying the array.
     * @return The expression identifying the array.
     */
    public NodeUnion<? extends RestrictedPrimaryExpressionNode> getUnionForArrayExpression()
    {
        getAttribute(LocalAttribute.ARRAY_EXPRESSION).recordAccess(ReadWriteAttribute.AccessType.READ);
        if (this.arrayExpression == null)
        {
            this.arrayExpression = new NormalNodeUnion<RestrictedPrimaryExpressionNode>(null);
        }
        return this.arrayExpression;
    }
    
    /**
     * Changes the expression identifying the array.
     * @param arrayExpression The expression identifying the array.
     */
    public void setArrayExpression(RestrictedPrimaryExpressionNode arrayExpression)
    {
            setArrayExpression(arrayExpression, true);
            getManager().notifyChange(this);
    }
    
    private void setArrayExpression(RestrictedPrimaryExpressionNode arrayExpression, boolean checkPermissions)
    {
        if (checkPermissions)
        {
            getManager().assertMutatable(this);
            getAttribute(LocalAttribute.ARRAY_EXPRESSION).recordAccess(ReadWriteAttribute.AccessType.WRITE);
        }
        
        if (this.arrayExpression != null)
        {
            setAsChild(this.arrayExpression.getNodeValue(), false);
        }
        this.arrayExpression = new NormalNodeUnion<RestrictedPrimaryExpressionNode>(arrayExpression);
        setAsChild(arrayExpression, true);
    }
    
    /**
     * Changes the expression identifying the array.
     * @param arrayExpression The expression identifying the array.
     */
    public void setUnionForArrayExpression(NodeUnion<? extends RestrictedPrimaryExpressionNode> arrayExpression)
    {
            setUnionForArrayExpression(arrayExpression, true);
            getManager().notifyChange(this);
    }
    
    private void setUnionForArrayExpression(NodeUnion<? extends RestrictedPrimaryExpressionNode> arrayExpression, boolean checkPermissions)
    {
        if (checkPermissions)
        {
            getManager().assertMutatable(this);
            getAttribute(LocalAttribute.ARRAY_EXPRESSION).recordAccess(ReadWriteAttribute.AccessType.WRITE);
        }
        
        if (arrayExpression == null)
        {
            arrayExpression = new NormalNodeUnion<RestrictedPrimaryExpressionNode>(null);
        }
        if (this.arrayExpression != null)
        {
            setAsChild(this.arrayExpression.getNodeValue(), false);
        }
        this.arrayExpression = arrayExpression;
        setAsChild(arrayExpression.getNodeValue(), true);
    }
    
    /**
     * Gets the index into the array.  This property's value is assumed to be a normal node.
     * @return The index into the array.
     * @throws ClassCastException If this property's value is not a normal node.
     */
    public ExpressionNode getIndexExpression()
    {
        getAttribute(LocalAttribute.INDEX_EXPRESSION).recordAccess(ReadWriteAttribute.AccessType.READ);
        if (this.indexExpression == null)
        {
            return null;
        } else
        {
            return this.indexExpression.getNormalNode();
        }
    }
    
    /**
     * Gets the index into the array.
     * @return The index into the array.
     */
    public NodeUnion<? extends ExpressionNode> getUnionForIndexExpression()
    {
        getAttribute(LocalAttribute.INDEX_EXPRESSION).recordAccess(ReadWriteAttribute.AccessType.READ);
        if (this.indexExpression == null)
        {
            this.indexExpression = new NormalNodeUnion<ExpressionNode>(null);
        }
        return this.indexExpression;
    }
    
    /**
     * Changes the index into the array.
     * @param indexExpression The index into the array.
     */
    public void setIndexExpression(ExpressionNode indexExpression)
    {
            setIndexExpression(indexExpression, true);
            getManager().notifyChange(this);
    }
    
    private void setIndexExpression(ExpressionNode indexExpression, boolean checkPermissions)
    {
        if (checkPermissions)
        {
            getManager().assertMutatable(this);
            getAttribute(LocalAttribute.INDEX_EXPRESSION).recordAccess(ReadWriteAttribute.AccessType.WRITE);
        }
        
        if (this.indexExpression != null)
        {
            setAsChild(this.indexExpression.getNodeValue(), false);
        }
        this.indexExpression = new NormalNodeUnion<ExpressionNode>(indexExpression);
        setAsChild(indexExpression, true);
    }
    
    /**
     * Changes the index into the array.
     * @param indexExpression The index into the array.
     */
    public void setUnionForIndexExpression(NodeUnion<? extends ExpressionNode> indexExpression)
    {
            setUnionForIndexExpression(indexExpression, true);
            getManager().notifyChange(this);
    }
    
    private void setUnionForIndexExpression(NodeUnion<? extends ExpressionNode> indexExpression, boolean checkPermissions)
    {
        if (checkPermissions)
        {
            getManager().assertMutatable(this);
            getAttribute(LocalAttribute.INDEX_EXPRESSION).recordAccess(ReadWriteAttribute.AccessType.WRITE);
        }
        
        if (indexExpression == null)
        {
            indexExpression = new NormalNodeUnion<ExpressionNode>(null);
        }
        if (this.indexExpression != null)
        {
            setAsChild(this.indexExpression.getNodeValue(), false);
        }
        this.indexExpression = indexExpression;
        setAsChild(indexExpression.getNodeValue(), true);
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
        if (this.arrayExpression.getNodeValue() != null)
        {
            this.arrayExpression.getNodeValue().receive(visitor);
        }
        if (this.indexExpression.getNodeValue() != null)
        {
            this.indexExpression.getNodeValue().receive(visitor);
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
        if (this.arrayExpression.getNodeValue() != null)
        {
            this.arrayExpression.getNodeValue().receiveTyped(visitor);
        }
        if (this.indexExpression.getNodeValue() != null)
        {
            this.indexExpression.getNodeValue().receiveTyped(visitor);
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
     * Returns an iterator over the children of this node.
     * @see Node#getChildIterator()
     */
    @Override
    public Iterable<? extends Node> getChildIterable()
    {
        return Arrays.asList(new Node[]{getUnionForArrayExpression().getNodeValue(), getUnionForIndexExpression().getNodeValue()});
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
        sb.append(this.getUnionForArrayExpression().getNodeValue() == null? "null" : this.getUnionForArrayExpression().getNodeValue().getClass().getSimpleName());
        sb.append(',');
        sb.append("indexExpression=");
        sb.append(this.getUnionForIndexExpression().getNodeValue() == null? "null" : this.getUnionForIndexExpression().getNodeValue().getClass().getSimpleName());
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
     * Executes an operation on this node.
     * @param operation The operation to perform.
     * @param p1 The parameter to pass to the operation.
     * @param p2 The parameter to pass to the operation.
     * @return The result of the operation.
     */
    @Override
    public <P1,P2,R> R executeOperation(BsjNodeOperation2Arguments<P1,P2,R> operation, P1 p1, P2 p2)
    {
        return operation.executeArrayAccessNode(this, p1, p2);
    }
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public ArrayAccessNode deepCopy(BsjNodeFactory factory)
    {
        NodeUnion<? extends RestrictedPrimaryExpressionNode> arrayExpressionCopy;
        switch (getUnionForArrayExpression().getType())
        {
            case NORMAL:
                if (getUnionForArrayExpression().getNormalNode() == null)
                {
                    arrayExpressionCopy = factory.<RestrictedPrimaryExpressionNode>makeNormalNodeUnion(null);
                } else
                {
                    arrayExpressionCopy = factory.makeNormalNodeUnion(getUnionForArrayExpression().getNormalNode().deepCopy(factory));
                }
                break;
            case SPLICE:
                if (getUnionForArrayExpression().getSpliceNode() == null)
                {
                    arrayExpressionCopy = factory.<RestrictedPrimaryExpressionNode>makeSpliceNodeUnion(null);
                } else
                {
                    arrayExpressionCopy = factory.makeSpliceNodeUnion(getUnionForArrayExpression().getSpliceNode().deepCopy(factory));
                }
                break;
            default:
                throw new IllegalStateException("Unrecognized union component type: " + getUnionForArrayExpression().getType());
        }
        NodeUnion<? extends ExpressionNode> indexExpressionCopy;
        switch (getUnionForIndexExpression().getType())
        {
            case NORMAL:
                if (getUnionForIndexExpression().getNormalNode() == null)
                {
                    indexExpressionCopy = factory.<ExpressionNode>makeNormalNodeUnion(null);
                } else
                {
                    indexExpressionCopy = factory.makeNormalNodeUnion(getUnionForIndexExpression().getNormalNode().deepCopy(factory));
                }
                break;
            case SPLICE:
                if (getUnionForIndexExpression().getSpliceNode() == null)
                {
                    indexExpressionCopy = factory.<ExpressionNode>makeSpliceNodeUnion(null);
                } else
                {
                    indexExpressionCopy = factory.makeSpliceNodeUnion(getUnionForIndexExpression().getSpliceNode().deepCopy(factory));
                }
                break;
            default:
                throw new IllegalStateException("Unrecognized union component type: " + getUnionForIndexExpression().getType());
        }
        return factory.makeArrayAccessNodeWithUnions(
                arrayExpressionCopy,
                indexExpressionCopy,
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
        
        if (before.equals(this.getUnionForArrayExpression().getNodeValue()))
        {
            setArrayExpression((RestrictedPrimaryExpressionNode)after);
            return true;
        }
        if (before.equals(this.getUnionForIndexExpression().getNodeValue()))
        {
            setIndexExpression((ExpressionNode)after);
            return true;
        }
        return false;
    }
    
}
