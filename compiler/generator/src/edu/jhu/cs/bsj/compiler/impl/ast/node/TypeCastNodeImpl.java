package edu.jhu.cs.bsj.compiler.impl.ast.node;

import java.util.Arrays;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjAbortableNodeOperation;
import edu.jhu.cs.bsj.compiler.ast.BsjAbortableNodeOperation2Arguments;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.BsjTypedNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.NodeUnion;
import edu.jhu.cs.bsj.compiler.ast.node.ExpressionNode;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.TypeCastNode;
import edu.jhu.cs.bsj.compiler.ast.node.TypeNode;
import edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeManager;
import edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactory;
import edu.jhu.cs.bsj.compiler.impl.ast.NormalNodeUnion;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.property.TypeCastNodeSetExpressionPropertyEditScriptElementImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.property.TypeCastNodeSetTypePropertyEditScriptElementImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.properties.TypeCastNodeProperties;

@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class TypeCastNodeImpl extends NodeImpl implements TypeCastNode
{
    /** The expression to cast. */
    private NodeUnion<? extends ExpressionNode> expression;
    
    /** The type to which to cast. */
    private NodeUnion<? extends TypeNode> type;
    
    /**
     * A set of those properties which have been populated from the backing node.
     * This field is <code>null</code> if <tt>backingNode</tt> is <code>null</code>.
     */
    private Set<TypeCastNodeProperties> populatedProperties;
    
    /** General constructor. */
    public TypeCastNodeImpl(
            NodeUnion<? extends ExpressionNode> expression,
            NodeUnion<? extends TypeNode> type,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation,
            BsjNodeManager manager,
            boolean binary)
    {
        super(startLocation, stopLocation, manager, binary);
        this.populatedProperties = null;
        doSetExpression(expression);
        doSetType(type);
    }
    
    /** Proxy constructor. */
    public TypeCastNodeImpl(BsjNodeManager manager, BsjNodeProxyFactory proxyFactory, TypeCastNode backingNode)
    {
        super(manager, proxyFactory, backingNode);
        this.populatedProperties = EnumSet.noneOf(TypeCastNodeProperties.class);
    }
    
    /** Retrieves this node's backing node (if one exists). */
    protected TypeCastNode getBackingNode()
    {
        return (TypeCastNode)super.getBackingNode();
    }
    
    /**
     * Ensures that the expression value has been populated from proxy.
     * If this node is not backed by a proxy or if the value has already been
     * populated, this method does nothing.
     */
    private void checkExpressionWrapped()
    {
        if (this.populatedProperties == null || this.populatedProperties.contains(
                TypeCastNodeProperties.EXPRESSION))
            return;
        this.populatedProperties.add(TypeCastNodeProperties.EXPRESSION);
        NodeUnion<? extends ExpressionNode> union = this.getBackingNode().getUnionForExpression();
        switch (union.getType())
        {
            case NORMAL:
                union = this.getProxyFactory().makeNormalNodeUnion(
                        this.getProxyFactory().makeExpressionNode(union.getNormalNode()));
                break;
            case SPLICE:
                union = this.getProxyFactory().makeSpliceNodeUnion(
                        this.getProxyFactory().makeSpliceNode(union.getSpliceNode()));
                break;
            default:
                throw new IllegalStateException("Unrecognized union type: " + union.getType());
        }
        this.expression = union;
    }
    
    /**
     * Ensures that the type value has been populated from proxy.
     * If this node is not backed by a proxy or if the value has already been
     * populated, this method does nothing.
     */
    private void checkTypeWrapped()
    {
        if (this.populatedProperties == null || this.populatedProperties.contains(
                TypeCastNodeProperties.TYPE))
            return;
        this.populatedProperties.add(TypeCastNodeProperties.TYPE);
        NodeUnion<? extends TypeNode> union = this.getBackingNode().getUnionForType();
        switch (union.getType())
        {
            case NORMAL:
                union = this.getProxyFactory().makeNormalNodeUnion(
                        this.getProxyFactory().makeTypeNode(union.getNormalNode()));
                break;
            case SPLICE:
                union = this.getProxyFactory().makeSpliceNodeUnion(
                        this.getProxyFactory().makeSpliceNode(union.getSpliceNode()));
                break;
            default:
                throw new IllegalStateException("Unrecognized union type: " + union.getType());
        }
        this.type = union;
    }
    
    /**
     * Gets the expression to cast.  This property's value is assumed to be a normal node.
     * @return The expression to cast.
     * @throws ClassCastException If this property's value is not a normal node.
     */
    public ExpressionNode getExpression()
    {
        checkExpressionWrapped();
        if (this.expression == null)
        {
            return null;
        } else
        {
            return this.expression.getNormalNode();
        }
    }
    
    /**
     * Gets the expression to cast.
     * @return The expression to cast.
     */
    public NodeUnion<? extends ExpressionNode> getUnionForExpression()
    {
        checkExpressionWrapped();
        if (this.expression == null)
        {
            this.expression = new NormalNodeUnion<ExpressionNode>(null);
        }
        return this.expression;
    }
    
    /**
     * Changes the expression to cast.
     * @param expression The expression to cast.
     */
    public void setExpression(ExpressionNode expression)
    {
        checkExpressionWrapped();
        this.setUnionForExpression(new NormalNodeUnion<ExpressionNode>(expression));
    }
    
    /**
     * Changes the expression to cast.
     * @param expression The expression to cast.
     */
    public void setUnionForExpression(NodeUnion<? extends ExpressionNode> expression)
    {
        checkExpressionWrapped();
        this.getManager().assertMutatable(this);
        this.doSetExpression(expression);
        if (this.getManager().isRecordingEdits())
            super.recordEdit(new TypeCastNodeSetExpressionPropertyEditScriptElementImpl(this.getManager().getCurrentMetaprogramId(), this.getUid(), expression.getNodeValue() == null ? null : expression.getNodeValue().getUid()));
    }
    
    private void doSetExpression(NodeUnion<? extends ExpressionNode> expression)
    {
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
     * Gets the type to which to cast.  This property's value is assumed to be a normal node.
     * @return The type to which to cast.
     * @throws ClassCastException If this property's value is not a normal node.
     */
    public TypeNode getType()
    {
        checkTypeWrapped();
        if (this.type == null)
        {
            return null;
        } else
        {
            return this.type.getNormalNode();
        }
    }
    
    /**
     * Gets the type to which to cast.
     * @return The type to which to cast.
     */
    public NodeUnion<? extends TypeNode> getUnionForType()
    {
        checkTypeWrapped();
        if (this.type == null)
        {
            this.type = new NormalNodeUnion<TypeNode>(null);
        }
        return this.type;
    }
    
    /**
     * Changes the type to which to cast.
     * @param type The type to which to cast.
     */
    public void setType(TypeNode type)
    {
        checkTypeWrapped();
        this.setUnionForType(new NormalNodeUnion<TypeNode>(type));
    }
    
    /**
     * Changes the type to which to cast.
     * @param type The type to which to cast.
     */
    public void setUnionForType(NodeUnion<? extends TypeNode> type)
    {
        checkTypeWrapped();
        this.getManager().assertMutatable(this);
        this.doSetType(type);
        if (this.getManager().isRecordingEdits())
            super.recordEdit(new TypeCastNodeSetTypePropertyEditScriptElementImpl(this.getManager().getCurrentMetaprogramId(), this.getUid(), type.getNodeValue() == null ? null : type.getNodeValue().getUid()));
    }
    
    private void doSetType(NodeUnion<? extends TypeNode> type)
    {
        if (type == null)
        {
            type = new NormalNodeUnion<TypeNode>(null);
        }
        if (this.type != null)
        {
            setAsChild(this.type.getNodeValue(), false);
        }
        this.type = type;
        setAsChild(type.getNodeValue(), true);
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
        if (this.getUnionForExpression().getNodeValue() != null)
        {
            this.getUnionForExpression().getNodeValue().receive(visitor);
        }
        if (this.getUnionForType().getNodeValue() != null)
        {
            this.getUnionForType().getNodeValue().receive(visitor);
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
        if (this.getUnionForExpression().getNodeValue() != null)
        {
            this.getUnionForExpression().getNodeValue().receiveTyped(visitor);
        }
        if (this.getUnionForType().getNodeValue() != null)
        {
            this.getUnionForType().getNodeValue().receiveTyped(visitor);
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
        visitor.visitTypeCastNodeStart(this, true);
        visitor.visitNodeStart(this);
        visitor.visitNonAssignmentExpressionNodeStart(this);
        visitor.visitStartEnd(this);
        receiveTypedToChildren(visitor);
        visitor.visitStopBegin(this);
        visitor.visitNonAssignmentExpressionNodeStop(this);
        visitor.visitNodeStop(this);
        visitor.visitTypeCastNodeStop(this, true);
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
        list.add(getUnionForExpression());
        list.add(getUnionForType());
        return list;
    }
    
    /**
     * Produces a mutable map of this node's children.  Modifying this map will have no
     * effect on this node.
     * @return A mapping of the node's children.
     */
    @Override
    public Map<String,Object> getChildMap()
    {
        Map<String,Object> map = super.getChildMap();
        map.put("expression", getUnionForExpression());
        map.put("type", getUnionForType());
        return map;
    }
    
    /**
     * Returns an iterator over the children of this node.
     * @see Node#getChildIterator()
     */
    @Override
    public Iterable<? extends Node> getChildIterable()
    {
        return Arrays.asList(new Node[]{getUnionForExpression().getNodeValue(), getUnionForType().getNodeValue()});
    }
    
    /**
     * Obtains a human-readable description of this node.
     * @return A human-readable description of this node.
     */
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getClass().getSimpleName());
        sb.append('#');
        sb.append(this.getUid());
        sb.append('[');
        sb.append("expression=");
        sb.append(this.getUnionForExpression().getNodeValue() == null? "null" : this.getUnionForExpression().getNodeValue().getClass().getSimpleName());
        sb.append(',');
        sb.append("type=");
        sb.append(this.getUnionForType().getNodeValue() == null? "null" : this.getUnionForType().getNodeValue().getClass().getSimpleName());
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
        return operation.executeTypeCastNode(this, p);
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
        return operation.executeTypeCastNode(this, p1, p2);
    }
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public TypeCastNode deepCopy(BsjNodeFactory factory)
    {
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
        NodeUnion<? extends TypeNode> typeCopy;
        switch (getUnionForType().getType())
        {
            case NORMAL:
                if (getUnionForType().getNormalNode() == null)
                {
                    typeCopy = factory.<TypeNode>makeNormalNodeUnion(null);
                } else
                {
                    typeCopy = factory.makeNormalNodeUnion(getUnionForType().getNormalNode().deepCopy(factory));
                }
                break;
            case SPLICE:
                if (getUnionForType().getSpliceNode() == null)
                {
                    typeCopy = factory.<TypeNode>makeSpliceNodeUnion(null);
                } else
                {
                    typeCopy = factory.makeSpliceNodeUnion(getUnionForType().getSpliceNode().deepCopy(factory));
                }
                break;
            default:
                throw new IllegalStateException("Unrecognized union component type: " + getUnionForType().getType());
        }
        return factory.makeTypeCastNodeWithUnions(
                expressionCopy,
                typeCopy,
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
        
        if (before.equals(this.getUnionForExpression().getNodeValue()))
        {
            setExpression((ExpressionNode)after);
            return true;
        }
        if (before.equals(this.getUnionForType().getNodeValue()))
        {
            setType((TypeNode)after);
            return true;
        }
        return false;
    }
    
}
