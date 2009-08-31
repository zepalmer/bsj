package edu.jhu.cs.bsj.compiler.impl.ast.node;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.node.DeclaredTypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.ListNode;
import edu.jhu.cs.bsj.compiler.ast.node.ParameterizedTypeNode;
import edu.jhu.cs.bsj.compiler.ast.tags.TypeArgument;

public class ParameterizedTypeNodeImpl extends TypeNodeImpl implements ParameterizedTypeNode
{
    /** The base type. */
    private DeclaredTypeNode type;

    /** The parameterized type arguments. */
    private ListNode<? extends TypeArgument> typeArguments;

    /** General constructor. */
    public ParameterizedTypeNodeImpl(
            DeclaredTypeNode type,
            ListNode<? extends TypeArgument> typeArguments)
    {
        super();
        this.type = type;
        this.typeArguments = typeArguments;
    }

    /**
     * Gets the base type.
     * @return The base type.
     */
    public DeclaredTypeNode getType()
    {
        return this.type;
    }

    /**
     * Changes the base type.
     * @param type The base type.
     */
    public void setType(DeclaredTypeNode type)
    {
        this.type = type;
    }

    /**
     * Gets the parameterized type arguments.
     * @return The parameterized type arguments.
     */
    public ListNode<? extends TypeArgument> getTypeArguments()
    {
        return this.typeArguments;
    }

    /**
     * Changes the parameterized type arguments.
     * @param typeArguments The parameterized type arguments.
     */
    public void setTypeArguments(ListNode<? extends TypeArgument> typeArguments)
    {
        this.typeArguments = typeArguments;
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
