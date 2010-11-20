package edu.jhu.cs.bsj.compiler.impl.ast.node;

import java.util.EnumMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.BsjTypedNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.NodeUnion;
import edu.jhu.cs.bsj.compiler.ast.node.ArrayCreationNode;
import edu.jhu.cs.bsj.compiler.ast.node.BaseTypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeManager;
import edu.jhu.cs.bsj.compiler.impl.ast.NormalNodeUnion;
import edu.jhu.cs.bsj.compiler.impl.ast.attribute.AttributeName;
import edu.jhu.cs.bsj.compiler.impl.ast.attribute.ReadWriteAttribute;

@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public abstract class ArrayCreationNodeImpl extends NodeImpl implements ArrayCreationNode
{
    /** The base type for this array. */
    private NodeUnion<? extends BaseTypeNode> baseType;
    
    /** The number of uninitialized levels for this array. */
    private int arrayLevels;
    
    private Map<LocalAttribute,ReadWriteAttribute> localAttributes = new EnumMap<LocalAttribute,ReadWriteAttribute>(LocalAttribute.class);
    private ReadWriteAttribute getAttribute(LocalAttribute attributeName)
    {
        ReadWriteAttribute attribute = localAttributes.get(attributeName);
        if (attribute == null)
        {
            attribute = new ReadWriteAttribute(ArrayCreationNodeImpl.this, attributeName);
            localAttributes.put(attributeName, attribute);
        }
        return attribute;
    }
    private static enum LocalAttribute implements AttributeName
    {
        /** Attribute identifier for the baseType property. */
        BASE_TYPE,
        /** Attribute identifier for the arrayLevels property. */
        ARRAY_LEVELS,
    }
    
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
        setUnionForBaseType(baseType, false);
        this.arrayLevels = arrayLevels;
    }
    
    /**
     * Gets the base type for this array.  This property's value is assumed to be a normal node.
     * @return The base type for this array.
     * @throws ClassCastException If this property's value is not a normal node.
     */
    public BaseTypeNode getBaseType()
    {
        getAttribute(LocalAttribute.BASE_TYPE).recordAccess(ReadWriteAttribute.AccessType.READ);
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
        getAttribute(LocalAttribute.BASE_TYPE).recordAccess(ReadWriteAttribute.AccessType.READ);
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
            setBaseType(baseType, true);
            getManager().notifyChange(this);
    }
    
    private void setBaseType(BaseTypeNode baseType, boolean checkPermissions)
    {
        if (checkPermissions)
        {
            getManager().assertMutatable(this);
            getAttribute(LocalAttribute.BASE_TYPE).recordAccess(ReadWriteAttribute.AccessType.WRITE);
        }
        
        if (this.baseType != null)
        {
            setAsChild(this.baseType.getNodeValue(), false);
        }
        this.baseType = new NormalNodeUnion<BaseTypeNode>(baseType);
        setAsChild(baseType, true);
    }
    
    /**
     * Changes the base type for this array.
     * @param baseType The base type for this array.
     */
    public void setUnionForBaseType(NodeUnion<? extends BaseTypeNode> baseType)
    {
            setUnionForBaseType(baseType, true);
            getManager().notifyChange(this);
    }
    
    private void setUnionForBaseType(NodeUnion<? extends BaseTypeNode> baseType, boolean checkPermissions)
    {
        if (checkPermissions)
        {
            getManager().assertMutatable(this);
            getAttribute(LocalAttribute.BASE_TYPE).recordAccess(ReadWriteAttribute.AccessType.WRITE);
        }
        
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
        getAttribute(LocalAttribute.ARRAY_LEVELS).recordAccess(ReadWriteAttribute.AccessType.READ);
        return this.arrayLevels;
    }
    
    /**
     * Changes the number of uninitialized levels for this array.
     * @param arrayLevels The number of uninitialized levels for this array.
     */
    public void setArrayLevels(int arrayLevels)
    {
            setArrayLevels(arrayLevels, true);
            getManager().notifyChange(this);
    }
    
    private void setArrayLevels(int arrayLevels, boolean checkPermissions)
    {
        if (checkPermissions)
        {
            getManager().assertMutatable(this);
            getAttribute(LocalAttribute.ARRAY_LEVELS).recordAccess(ReadWriteAttribute.AccessType.WRITE);
        }
        
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
        if (this.baseType.getNodeValue() != null)
        {
            this.baseType.getNodeValue().receive(visitor);
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
        if (this.baseType.getNodeValue() != null)
        {
            this.baseType.getNodeValue().receiveTyped(visitor);
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
