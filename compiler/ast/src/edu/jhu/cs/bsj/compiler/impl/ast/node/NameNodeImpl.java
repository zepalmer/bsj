package edu.jhu.cs.bsj.compiler.impl.ast.node;

import java.util.List;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.NameCategory;
import edu.jhu.cs.bsj.compiler.ast.node.NameNode;
public abstract class NameNodeImpl extends NodeImpl implements NameNode
{
    /** The category for this name. */
    private NameCategory category;

    /** General constructor. */
    protected NameNodeImpl(
            NameCategory category)
    {
        super();
        this.category = category;
    }

    /**
     * Gets the category for this name.
     * @return The category for this name.
     */
    public NameCategory getCategory()
    {
        return this.category;
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
        list.add(this.category);
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
        sb.append("category=");
        sb.append(String.valueOf(this.category) + ":" + this.category.getClass().getSimpleName());
        sb.append(']');
        return sb.toString();
    }
	/**
	 * Asserts that this node should fall into the specified category.
	 * @param category The category into which this node should fall.
	 * @throws IllegalStateException If this node cannot fall into that category because it has already been marked with
	 *                               another category.
	 */
	public void assertCategory(NameCategory category)
	{
		// TODO: make this cleaner and more descriptive
		if (this.category == category)
			return;
		if (this.category == NameCategory.AMBIGUOUS)
		{
			if (category != NameCategory.METHOD)
			{
				this.category = category;
				return;
			}
		}
		if (this.category == NameCategory.PACKAGE_OR_TYPE)
		{
			if (category == NameCategory.PACKAGE || category == NameCategory.TYPE)
			{
				this.category = category;
				return;
			}
		}
		throw new IllegalStateException("Illegal name category transition: " + this.category + " => " + category);
	}

}
