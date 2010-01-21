package edu.jhu.cs.bsj.compiler.impl.ast.node;

import java.util.List;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.BsjTypedNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.node.ArrayCreationNode;
import edu.jhu.cs.bsj.compiler.ast.node.BaseTypeNode;

@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public abstract class ArrayCreationNodeImpl extends NodeImpl implements ArrayCreationNode
{
    /** The base type for this array. */
    private BaseTypeNode baseType;

    /** The number of uninitialized levels for this array. */
    private int arrayLevels;

    /** General constructor. */
    protected ArrayCreationNodeImpl(
            BaseTypeNode baseType,
            int arrayLevels,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        super(startLocation, stopLocation);
        this.baseType = baseType;
        this.arrayLevels = arrayLevels;
    }

    /**
     * Gets the base type for this array.
     * @return The base type for this array.
     */
    public BaseTypeNode getBaseType()
    {
        return this.baseType;
    }

    /**
     * Changes the base type for this array.
     * @param baseType The base type for this array.
     */
    public void setBaseType(BaseTypeNode baseType)
    {
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
        return this.arrayLevels;
    }

    /**
     * Changes the number of uninitialized levels for this array.
     * @param arrayLevels The number of uninitialized levels for this array.
     */
    public void setArrayLevels(int arrayLevels)
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
        this.baseType.receive(visitor);
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
        this.baseType.receiveTyped(visitor);
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
        visitor.visitNodeStart(this);
        visitor.visitArrayCreationNodeStart(this);
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
        list.add(getStartLocation());
        list.add(getStopLocation());
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
        sb.append(this.baseType == null? "null" : this.baseType.getClass().getSimpleName());
        sb.append(',');
        sb.append("arrayLevels=");
        sb.append(String.valueOf(this.arrayLevels) + ":" + "int");
        sb.append(']');
        return sb.toString();
    }

}
