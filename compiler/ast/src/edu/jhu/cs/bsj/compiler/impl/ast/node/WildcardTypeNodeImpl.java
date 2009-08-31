package edu.jhu.cs.bsj.compiler.impl.ast.node;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.node.TypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.WildcardTypeNode;

public class WildcardTypeNodeImpl extends NodeImpl implements WildcardTypeNode
{
    /** The wildcard's bound. */
    private TypeNode bound;

    /** Whether or not the wildcard's bound is an upper (<tt>extends</tt>) bound. */
    private boolean upperBound;

    /** General constructor. */
    public WildcardTypeNodeImpl(
            TypeNode bound,
            boolean upperBound)
    {
        super();
        this.bound = bound;
        this.upperBound = upperBound;
    }

    /**
     * Gets the wildcard's bound.
     * @return The wildcard's bound.
     */
    public TypeNode getBound()
    {
        return this.bound;
    }

    /**
     * Changes the wildcard's bound.
     * @param bound The wildcard's bound.
     */
    public void setBound(TypeNode bound)
    {
        if (this.bound instanceof NodeImpl)
        {
            ((NodeImpl)this.bound).setParent(null);
        }
        this.bound = bound;
        if (this.bound instanceof NodeImpl)
        {
            ((NodeImpl)this.bound).setParent(this);
        }
    }

    /**
     * Gets whether or not the wildcard's bound is an upper (<tt>extends</tt>) bound.
     * @return Whether or not the wildcard's bound is an upper (<tt>extends</tt>) bound.
     */
    public boolean getUpperBound()
    {
        return this.upperBound;
    }

    /**
     * Changes whether or not the wildcard's bound is an upper (<tt>extends</tt>) bound.
     * @param upperBound Whether or not the wildcard's bound is an upper (<tt>extends</tt>) bound.
     */
    public void setUpperBound(boolean upperBound)
    {
        this.upperBound = upperBound;
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
        this.bound.receive(visitor);
    }
}
