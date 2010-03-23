package edu.jhu.cs.bsj.compiler.impl.ast.node;

import java.util.List;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.BsjTypedNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.node.ArrayCreationNode;
import edu.jhu.cs.bsj.compiler.ast.node.BaseTypeNode;
import edu.jhu.cs.bsj.compiler.impl.ast.Attribute;
import edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeManager;

@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public abstract class ArrayCreationNodeImpl extends NodeImpl implements ArrayCreationNode
{
    /** The base type for this array. */
    private BaseTypeNode baseType;
    
    /** The number of uninitialized levels for this array. */
    private int arrayLevels;
    
    private static enum LocalAttribute implements edu.jhu.cs.bsj.compiler.impl.ast.Attribute
    {
        /** Attribute for the baseType property. */
        BASE_TYPE,
        /** Attribute for the arrayLevels property. */
        ARRAY_LEVELS,
    }
    
    /** General constructor. */
    protected ArrayCreationNodeImpl(
            BaseTypeNode baseType,
            int arrayLevels,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation,
            BsjNodeManager manager,
            boolean binary)
    {
        super(startLocation, stopLocation, manager, binary);
        setBaseType(baseType, false);
        this.arrayLevels = arrayLevels;
    }
    
    /**
     * Gets the base type for this array.
     * @return The base type for this array.
     */
    public BaseTypeNode getBaseType()
    {
        recordAccess(LocalAttribute.BASE_TYPE, Attribute.AccessType.READ);
        return this.baseType;
    }
    
    /**
     * Changes the base type for this array.
     * @param baseType The base type for this array.
     */
    public void setBaseType(BaseTypeNode baseType)
    {
            setBaseType(baseType, true);
    }
    
    private void setBaseType(BaseTypeNode baseType, boolean checkPermissions)
    {
        if (checkPermissions)
        {
            getManager().assertMutatable(this);
        }
        recordAccess(LocalAttribute.BASE_TYPE, Attribute.AccessType.STRONG_WRITE);
        if (this.baseType instanceof NodeImpl)
        {
            ((NodeImpl)this.baseType).setParent(null);
        }
        this.baseType = baseType;
        if (this.baseType instanceof NodeImpl)
        {
            ((NodeImpl)this.baseType).setParent(this);
        }
    }
    
    /**
     * Gets the number of uninitialized levels for this array.
     * @return The number of uninitialized levels for this array.
     */
    public int getArrayLevels()
    {
        recordAccess(LocalAttribute.ARRAY_LEVELS, Attribute.AccessType.READ);
        return this.arrayLevels;
    }
    
    /**
     * Changes the number of uninitialized levels for this array.
     * @param arrayLevels The number of uninitialized levels for this array.
     */
    public void setArrayLevels(int arrayLevels)
    {
            setArrayLevels(arrayLevels, true);
    }
    
    private void setArrayLevels(int arrayLevels, boolean checkPermissions)
    {
        if (checkPermissions)
        {
            getManager().assertMutatable(this);
        }
        recordAccess(LocalAttribute.ARRAY_LEVELS, Attribute.AccessType.STRONG_WRITE);
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
        if (this.baseType != null)
        {
            this.baseType.receive(visitor);
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
        if (this.baseType != null)
        {
            this.baseType.receiveTyped(visitor);
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
        list.add(getBaseType());
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
    
    
}
