package edu.jhu.cs.bsj.compiler.impl.ast.node;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.node.DeclaredTypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.TypeSelectNode;
import edu.jhu.cs.bsj.compiler.ast.tags.BoundType;

public class TypeSelectNodeImpl extends TypeNodeImpl implements TypeSelectNode
{
    /** The base type from which to select. */
    private BoundType base;

    /** The selected type from the base type. */
    private DeclaredTypeNode select;

    /** General constructor. */
    public TypeSelectNodeImpl(
            BoundType base,
            DeclaredTypeNode select)
    {
        super();
        this.base = base;
        this.select = select;
    }

    /**
     * Gets the base type from which to select.
     * @return The base type from which to select.
     */
    public BoundType getBase()
    {
        return this.base;
    }

    /**
     * Changes the base type from which to select.
     * @param base The base type from which to select.
     */
    public void setBase(BoundType base)
    {
        this.base = base;
    }

    /**
     * Gets the selected type from the base type.
     * @return The selected type from the base type.
     */
    public DeclaredTypeNode getSelect()
    {
        return this.select;
    }

    /**
     * Changes the selected type from the base type.
     * @param select The selected type from the base type.
     */
    public void setSelect(DeclaredTypeNode select)
    {
        if (this.select instanceof NodeImpl)
        {
            ((NodeImpl)this.select).setParent(null);
        }
        this.select = select;
        if (this.select instanceof NodeImpl)
        {
            ((NodeImpl)this.select).setParent(this);
        }
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
        this.select.receive(visitor);
    }
}
