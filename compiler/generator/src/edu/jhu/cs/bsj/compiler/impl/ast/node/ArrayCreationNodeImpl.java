package edu.jhu.cs.bsj.compiler.impl.ast.node;

import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.BsjTypedNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.NodeUnion;
import edu.jhu.cs.bsj.compiler.ast.node.ArrayCreationNode;
import edu.jhu.cs.bsj.compiler.ast.node.BaseTypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeManager;
import edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactory;
import edu.jhu.cs.bsj.compiler.impl.ast.NormalNodeUnion;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.property.ArrayCreationNodeSetArrayLevelsPropertyEditScriptElementImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.property.ArrayCreationNodeSetBaseTypePropertyEditScriptElementImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.properties.ArrayCreationNodeProperties;

@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public abstract class ArrayCreationNodeImpl extends NodeImpl implements ArrayCreationNode
{
    /** The base type for this array. */
    private NodeUnion<? extends BaseTypeNode> baseType;
    
    /** The number of uninitialized levels for this array. */
    private int arrayLevels;
    
    /**
     * A set of those properties which have been populated from the backing node.
     * This field is <code>null</code> if <tt>backingNode</tt> is <code>null</code>.
     */
    private Set<ArrayCreationNodeProperties> populatedProperties;
    
    /** General constructor. */
    protected ArrayCreationNodeImpl(
            NodeUnion<? extends BaseTypeNode> baseType,
            int arrayLevels,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation,
            BsjNodeManager manager,
            boolean binary)
    {
        super(startLocation, stopLocation, manager, binary);
        this.populatedProperties = null;
        doSetBaseType(baseType);
        doSetArrayLevels(arrayLevels);
    }
    
    /** Proxy constructor. */
    protected ArrayCreationNodeImpl(BsjNodeManager manager, BsjNodeProxyFactory proxyFactory, ArrayCreationNode backingNode)
    {
        super(manager, proxyFactory, backingNode);
        this.populatedProperties = EnumSet.noneOf(ArrayCreationNodeProperties.class);
    }
    
    /** Retrieves this node's backing node (if one exists). */
    protected ArrayCreationNode getBackingNode()
    {
        return (ArrayCreationNode)super.getBackingNode();
    }
    
    /**
     * Ensures that the baseType value has been populated from proxy.
     * If this node is not backed by a proxy or if the value has already been
     * populated, this method does nothing.
     */
    private void checkBaseTypeWrapped()
    {
        if (this.populatedProperties == null || this.populatedProperties.contains(
                ArrayCreationNodeProperties.BASE_TYPE))
            return;
        this.populatedProperties.add(ArrayCreationNodeProperties.BASE_TYPE);
        NodeUnion<? extends BaseTypeNode> union = this.getBackingNode().getUnionForBaseType();
        switch (union.getType())
        {
            case NORMAL:
                union = this.getProxyFactory().makeNormalNodeUnion(
                        this.getProxyFactory().makeBaseTypeNode(union.getNormalNode()));
                break;
            case SPLICE:
                union = this.getProxyFactory().makeSpliceNodeUnion(
                        this.getProxyFactory().makeSpliceNode(union.getSpliceNode()));
                break;
            default:
                throw new IllegalStateException("Unrecognized union type: " + union.getType());
        }
        this.baseType = union;
    }
    
    /**
     * Ensures that the arrayLevels value has been populated from proxy.
     * If this node is not backed by a proxy or if the value has already been
     * populated, this method does nothing.
     */
    private void checkArrayLevelsWrapped()
    {
        if (this.populatedProperties == null || this.populatedProperties.contains(
                ArrayCreationNodeProperties.ARRAY_LEVELS))
            return;
        this.populatedProperties.add(ArrayCreationNodeProperties.ARRAY_LEVELS);
        this.arrayLevels = this.getBackingNode().getArrayLevels();
    }
    
    /**
     * Gets the base type for this array.  This property's value is assumed to be a normal node.
     * @return The base type for this array.
     * @throws ClassCastException If this property's value is not a normal node.
     */
    public BaseTypeNode getBaseType()
    {
        checkBaseTypeWrapped();
        if (this.baseType == null)
        {
            return null;
        } else
        {
            return this.baseType.getNormalNode();
        }
    }
    
    /**
     * Gets the base type for this array.
     * @return The base type for this array.
     */
    public NodeUnion<? extends BaseTypeNode> getUnionForBaseType()
    {
        checkBaseTypeWrapped();
        if (this.baseType == null)
        {
            this.baseType = new NormalNodeUnion<BaseTypeNode>(null);
        }
        return this.baseType;
    }
    
    /**
     * Changes the base type for this array.
     * @param baseType The base type for this array.
     */
    public void setBaseType(BaseTypeNode baseType)
    {
        checkBaseTypeWrapped();
        this.setUnionForBaseType(new NormalNodeUnion<BaseTypeNode>(baseType));
    }
    
    /**
     * Changes the base type for this array.
     * @param baseType The base type for this array.
     */
    public void setUnionForBaseType(NodeUnion<? extends BaseTypeNode> baseType)
    {
        checkBaseTypeWrapped();
        this.getManager().assertMutatable(this);
        this.doSetBaseType(baseType);
        if (this.getManager().isRecordingEdits())
            super.recordEdit(new ArrayCreationNodeSetBaseTypePropertyEditScriptElementImpl(this.getManager().getCurrentMetaprogramId(), this.getUid(), baseType.getNodeValue() == null ? null : baseType.getNodeValue().getUid()));
    }
    
    private void doSetBaseType(NodeUnion<? extends BaseTypeNode> baseType)
    {
        if (baseType == null)
        {
            baseType = new NormalNodeUnion<BaseTypeNode>(null);
        }
        if (this.baseType != null)
        {
            setAsChild(this.baseType.getNodeValue(), false);
        }
        this.baseType = baseType;
        setAsChild(baseType.getNodeValue(), true);
    }
    
    /**
     * Gets the number of uninitialized levels for this array.
     * @return The number of uninitialized levels for this array.
     */
    public int getArrayLevels()
    {
        checkArrayLevelsWrapped();
        return this.arrayLevels;
    }
    
    /**
     * Changes the number of uninitialized levels for this array.
     * @param arrayLevels The number of uninitialized levels for this array.
     */
    public void setArrayLevels(int arrayLevels)
    {
        checkArrayLevelsWrapped();
        this.getManager().assertMutatable(this);
        this.doSetArrayLevels(arrayLevels);
        if (this.getManager().isRecordingEdits())
            super.recordEdit(new ArrayCreationNodeSetArrayLevelsPropertyEditScriptElementImpl(this.getManager().getCurrentMetaprogramId(), this.getUid(), arrayLevels));
    }
    
    private void doSetArrayLevels(int arrayLevels)
    {
        this.arrayLevels = arrayLevels;
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
        if (this.getUnionForBaseType().getNodeValue() != null)
        {
            this.getUnionForBaseType().getNodeValue().receive(visitor);
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
        if (this.getUnionForBaseType().getNodeValue() != null)
        {
            this.getUnionForBaseType().getNodeValue().receiveTyped(visitor);
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
        visitor.visitArrayCreationNodeStart(this);
        visitor.visitNodeStart(this);
        visitor.visitPrimaryExpressionNodeStart(this);
        visitor.visitStartEnd(this);
        receiveTypedToChildren(visitor);
        visitor.visitStopBegin(this);
        visitor.visitPrimaryExpressionNodeStop(this);
        visitor.visitNodeStop(this);
        visitor.visitArrayCreationNodeStop(this);
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
        list.add(getUnionForBaseType());
        list.add(getArrayLevels());
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
        sb.append('#');
        sb.append(this.getUid());
        sb.append('[');
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
    
    
    
}
