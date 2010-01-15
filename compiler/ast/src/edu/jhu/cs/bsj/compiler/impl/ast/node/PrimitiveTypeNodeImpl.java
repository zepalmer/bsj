package edu.jhu.cs.bsj.compiler.impl.ast.node;

import java.util.List;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.PrimitiveType;
import edu.jhu.cs.bsj.compiler.ast.node.PrimitiveTypeNode;

public class PrimitiveTypeNodeImpl extends NodeImpl implements PrimitiveTypeNode
{
    /** The primitive type being represented. */
    private PrimitiveType primitiveType;

    /** General constructor. */
    public PrimitiveTypeNodeImpl(
            PrimitiveType primitiveType)
    {
        super();
        this.primitiveType = primitiveType;
    }

    /**
     * Gets the primitive type being represented.
     * @return The primitive type being represented.
     */
    public PrimitiveType getPrimitiveType()
    {
        return this.primitiveType;
    }

    /**
     * Changes the primitive type being represented.
     * @param primitiveType The primitive type being represented.
     */
    public void setPrimitiveType(PrimitiveType primitiveType)
    {
        this.primitiveType = primitiveType;
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
        list.add(this.primitiveType);
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
        sb.append("primitiveType=");
        sb.append(String.valueOf(this.primitiveType) + ":" + this.primitiveType.getClass().getSimpleName());
        sb.append(']');
        return sb.toString();
    }
}
