package edu.jhu.cs.bsj.compiler.impl.ast.node;

import java.util.List;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.node.DeclaredTypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.ParameterizedTypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.ParameterizedTypeSelectNode;

public class ParameterizedTypeSelectNodeImpl extends NodeImpl implements ParameterizedTypeSelectNode
{
    /** The parameterized type from which a type is selected. */
    private ParameterizedTypeNode base;

    /** The type which is selected from the base. */
    private DeclaredTypeNode select;

    /** General constructor. */
    public ParameterizedTypeSelectNodeImpl(
            ParameterizedTypeNode base,
            DeclaredTypeNode select)
    {
        super();
        this.base = base;
        this.select = select;
    }

    /**
     * Gets the parameterized type from which a type is selected.
     * @return The parameterized type from which a type is selected.
     */
    public ParameterizedTypeNode getBase()
    {
        return this.base;
    }

    /**
     * Changes the parameterized type from which a type is selected.
     * @param base The parameterized type from which a type is selected.
     */
    public void setBase(ParameterizedTypeNode base)
    {
        if (this.base instanceof NodeImpl)
        {
            ((NodeImpl)this.base).setParent(null);
        }
        this.base = base;
        if (this.base instanceof NodeImpl)
        {
            ((NodeImpl)this.base).setParent(this);
        }
    }

    /**
     * Gets the type which is selected from the base.
     * @return The type which is selected from the base.
     */
    public DeclaredTypeNode getSelect()
    {
        return this.select;
    }

    /**
     * Changes the type which is selected from the base.
     * @param select The type which is selected from the base.
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
        this.base.receive(visitor);
        this.select.receive(visitor);
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
        list.add(this.base);
        list.add(this.select);
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
        sb.append("base=");
        sb.append(this.base == null? "null" : this.base.getClass().getSimpleName());
        sb.append(',');
        sb.append("select=");
        sb.append(this.select == null? "null" : this.select.getClass().getSimpleName());
        sb.append('[');
        return sb.toString();
    }
}
