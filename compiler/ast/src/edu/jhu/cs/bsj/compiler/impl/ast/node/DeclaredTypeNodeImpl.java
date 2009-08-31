package edu.jhu.cs.bsj.compiler.impl.ast.node;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.node.DeclaredTypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.NameNode;

public class DeclaredTypeNodeImpl extends TypeNodeImpl implements DeclaredTypeNode
{
    /** The name of the type. */
    private NameNode name;

    /** General constructor. */
    public DeclaredTypeNodeImpl(
            NameNode name)
    {
        super();
        this.name = name;
    }

    /**
     * Gets the name of the type.
     * @return The name of the type.
     */
    public NameNode getName()
    {
        return this.name;
    }

    /**
     * Changes the name of the type.
     * @param name The name of the type.
     */
    public void setName(NameNode name)
    {
        if (this.name instanceof NodeImpl)
        {
            ((NodeImpl)this.name).setParent(null);
        }
        this.name = name;
        if (this.name instanceof NodeImpl)
        {
            ((NodeImpl)this.name).setParent(this);
        }
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
