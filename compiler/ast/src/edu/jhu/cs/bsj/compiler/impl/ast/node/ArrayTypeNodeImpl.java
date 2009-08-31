package edu.jhu.cs.bsj.compiler.impl.ast.node;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.node.ArrayTypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.TypeNode;

public class ArrayTypeNodeImpl extends TypeNodeImpl implements ArrayTypeNode
{
    /** The element type of the array. */
    private TypeNode type;

    /** General constructor. */
    public ArrayTypeNodeImpl(
            TypeNode type)
    {
        super();
        this.type = type;
    }

    /**
     * Gets the element type of the array.
     * @return The element type of the array.
     */
    public TypeNode getType()
    {
        return this.type;
    }

    /**
     * Changes the element type of the array.
     * @param type The element type of the array.
     */
    public void setType(TypeNode type)
    {
        this.type = type;
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
