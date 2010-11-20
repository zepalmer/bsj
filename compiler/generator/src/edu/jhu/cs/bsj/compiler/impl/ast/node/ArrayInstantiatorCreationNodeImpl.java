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
import edu.jhu.cs.bsj.compiler.ast.node.ArrayInstantiatorCreationNode;
import edu.jhu.cs.bsj.compiler.ast.node.BaseTypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.list.ExpressionListNode;
import edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeManager;
import edu.jhu.cs.bsj.compiler.impl.ast.NormalNodeUnion;
import edu.jhu.cs.bsj.compiler.impl.ast.attribute.AttributeName;
import edu.jhu.cs.bsj.compiler.impl.ast.attribute.ReadWriteAttribute;

@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class ArrayInstantiatorCreationNodeImpl extends ArrayCreationNodeImpl implements ArrayInstantiatorCreationNode
{
    /** The dimension expressions for this array. */
    private NodeUnion<? extends ExpressionListNode> dimExpressions;
    
    private Map<LocalAttribute,ReadWriteAttribute> localAttributes = new EnumMap<LocalAttribute,ReadWriteAttribute>(LocalAttribute.class);
    private ReadWriteAttribute getAttribute(LocalAttribute attributeName)
    {
        ReadWriteAttribute attribute = localAttributes.get(attributeName);
        if (attribute == null)
        {
            attribute = new ReadWriteAttribute(ArrayInstantiatorCreationNodeImpl.this, attributeName);
            localAttributes.put(attributeName, attribute);
        }
        return attribute;
    }
    private static enum LocalAttribute implements AttributeName
    {
        /** Attribute identifier for the dimExpressions property. */
        DIM_EXPRESSIONS,
    }
    
    /** General constructor. */
    public ArrayInstantiatorCreationNodeImpl(
            NodeUnion<? extends ExpressionListNode> dimExpressions,
            NodeUnion<? extends BaseTypeNode> baseType,
            int arrayLevels,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation,
            BsjNodeManager manager,
            boolean binary)
    {
        super(baseType, arrayLevels, startLocation, stopLocation, manager, binary);
        setUnionForDimExpressions(dimExpressions, false);
    }
    
    /**
     * Gets the dimension expressions for this array.  This property's value is assumed to be a normal node.
     * @return The dimension expressions for this array.
     * @throws ClassCastException If this property's value is not a normal node.
     */
    public ExpressionListNode getDimExpressions()
    {
        getAttribute(LocalAttribute.DIM_EXPRESSIONS).recordAccess(ReadWriteAttribute.AccessType.READ);
        if (this.dimExpressions == null)
        {
            return null;
        } else
        {
            return this.dimExpressions.getNormalNode();
        }
    }
    
    /**
     * Gets the dimension expressions for this array.
     * @return The dimension expressions for this array.
     */
    public NodeUnion<? extends ExpressionListNode> getUnionForDimExpressions()
    {
        getAttribute(LocalAttribute.DIM_EXPRESSIONS).recordAccess(ReadWriteAttribute.AccessType.READ);
        if (this.dimExpressions == null)
        {
            this.dimExpressions = new NormalNodeUnion<ExpressionListNode>(null);
        }
        return this.dimExpressions;
    }
    
    /**
     * Changes the dimension expressions for this array.
     * @param dimExpressions The dimension expressions for this array.
     */
    public void setDimExpressions(ExpressionListNode dimExpressions)
    {
            setDimExpressions(dimExpressions, true);
            getManager().notifyChange(this);
    }
    
    private void setDimExpressions(ExpressionListNode dimExpressions, boolean checkPermissions)
    {
        if (checkPermissions)
        {
            getManager().assertMutatable(this);
            getAttribute(LocalAttribute.DIM_EXPRESSIONS).recordAccess(ReadWriteAttribute.AccessType.WRITE);
        }
        
        if (this.dimExpressions != null)
        {
            setAsChild(this.dimExpressions.getNodeValue(), false);
        }
        this.dimExpressions = new NormalNodeUnion<ExpressionListNode>(dimExpressions);
        setAsChild(dimExpressions, true);
    }
    
    /**
     * Changes the dimension expressions for this array.
     * @param dimExpressions The dimension expressions for this array.
     */
    public void setUnionForDimExpressions(NodeUnion<? extends ExpressionListNode> dimExpressions)
    {
            setUnionForDimExpressions(dimExpressions, true);
            getManager().notifyChange(this);
    }
    
    private void setUnionForDimExpressions(NodeUnion<? extends ExpressionListNode> dimExpressions, boolean checkPermissions)
    {
        if (checkPermissions)
        {
            getManager().assertMutatable(this);
            getAttribute(LocalAttribute.DIM_EXPRESSIONS).recordAccess(ReadWriteAttribute.AccessType.WRITE);
        }
        
        if (dimExpressions == null)
        {
            dimExpressions = new NormalNodeUnion<ExpressionListNode>(null);
        }
        if (this.dimExpressions != null)
        {
            setAsChild(this.dimExpressions.getNodeValue(), false);
        }
        this.dimExpressions = dimExpressions;
        setAsChild(dimExpressions.getNodeValue(), true);
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
        if (this.dimExpressions.getNodeValue() != null)
        {
            this.dimExpressions.getNodeValue().receive(visitor);
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
        if (this.dimExpressions.getNodeValue() != null)
        {
            this.dimExpressions.getNodeValue().receiveTyped(visitor);
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
        list.add(getUnionForDimExpressions());
        return list;
    }
    
    /**
     * Returns an iterator over the children of this node.
     * @see Node#getChildIterator()
     */
    @Override
    public Iterable<? extends Node> getChildIterable()
    {
        return Arrays.asList(new Node[]{getUnionForDimExpressions().getNodeValue(), getUnionForBaseType().getNodeValue()});
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
        sb.append(this.getUnionForDimExpressions().getNodeValue() == null? "null" : this.getUnionForDimExpressions().getNodeValue().getClass().getSimpleName());
        sb.append(',');
        sb.append("baseType=");
        sb.append(this.getUnionForBaseType().getNodeValue() == null? "null" : this.getUnionForBaseType().getNodeValue().getClass().getSimpleName());
        sb.append(',');
        sb.append("arrayLevels=");
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
     * Executes an operation on this node.
     * @param operation The operation to perform.
     * @param p1 The parameter to pass to the operation.
     * @param p2 The parameter to pass to the operation.
     * @return The result of the operation.
     */
    @Override
    public <P1,P2,R> R executeOperation(BsjNodeOperation2Arguments<P1,P2,R> operation, P1 p1, P2 p2)
    {
        return operation.executeArrayInstantiatorCreationNode(this, p1, p2);
    }
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public ArrayInstantiatorCreationNode deepCopy(BsjNodeFactory factory)
    {
        NodeUnion<? extends ExpressionListNode> dimExpressionsCopy;
        switch (getUnionForDimExpressions().getType())
        {
            case NORMAL:
                if (getUnionForDimExpressions().getNormalNode() == null)
                {
                    dimExpressionsCopy = factory.<ExpressionListNode>makeNormalNodeUnion(null);
                } else
                {
                    dimExpressionsCopy = factory.makeNormalNodeUnion(getUnionForDimExpressions().getNormalNode().deepCopy(factory));
                }
                break;
            case SPLICE:
                if (getUnionForDimExpressions().getSpliceNode() == null)
                {
                    dimExpressionsCopy = factory.<ExpressionListNode>makeSpliceNodeUnion(null);
                } else
                {
                    dimExpressionsCopy = factory.makeSpliceNodeUnion(getUnionForDimExpressions().getSpliceNode().deepCopy(factory));
                }
                break;
            default:
                throw new IllegalStateException("Unrecognized union component type: " + getUnionForDimExpressions().getType());
        }
        NodeUnion<? extends BaseTypeNode> baseTypeCopy;
        switch (getUnionForBaseType().getType())
        {
            case NORMAL:
                if (getUnionForBaseType().getNormalNode() == null)
                {
                    baseTypeCopy = factory.<BaseTypeNode>makeNormalNodeUnion(null);
                } else
                {
                    baseTypeCopy = factory.makeNormalNodeUnion(getUnionForBaseType().getNormalNode().deepCopy(factory));
                }
                break;
            case SPLICE:
                if (getUnionForBaseType().getSpliceNode() == null)
                {
                    baseTypeCopy = factory.<BaseTypeNode>makeSpliceNodeUnion(null);
                } else
                {
                    baseTypeCopy = factory.makeSpliceNodeUnion(getUnionForBaseType().getSpliceNode().deepCopy(factory));
                }
                break;
            default:
                throw new IllegalStateException("Unrecognized union component type: " + getUnionForBaseType().getType());
        }
        return factory.makeArrayInstantiatorCreationNodeWithUnions(
                dimExpressionsCopy,
                baseTypeCopy,
                getArrayLevels(),
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
        
        if (before.equals(this.getUnionForDimExpressions().getNodeValue()))
        {
            setDimExpressions((ExpressionListNode)after);
            return true;
        }
        if (before.equals(this.getUnionForBaseType().getNodeValue()))
        {
            setBaseType((BaseTypeNode)after);
            return true;
        }
        return false;
    }
    
}
