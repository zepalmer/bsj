package edu.jhu.cs.bsj.compiler.impl.ast.node;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.PrimitiveType;
import edu.jhu.cs.bsj.compiler.ast.node.PrimitiveTypeNode;

public class PrimitiveTypeNodeImpl extends TypeNodeImpl implements PrimitiveTypeNode
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
     * Performs visitation for this node's children.
     * @param visitor The visitor to visit this node's children.
     */
    @Override
    protected void receiveToChildren(BsjNodeVisitor visitor)
    {
        
    }
}
