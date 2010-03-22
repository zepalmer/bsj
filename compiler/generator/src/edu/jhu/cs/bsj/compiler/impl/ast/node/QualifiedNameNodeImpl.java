package edu.jhu.cs.bsj.compiler.impl.ast.node;

import java.util.List;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeOperation;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.BsjTypedNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.NameCategory;
import edu.jhu.cs.bsj.compiler.ast.node.IdentifierNode;
import edu.jhu.cs.bsj.compiler.ast.node.NameNode;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.QualifiedNameNode;
import edu.jhu.cs.bsj.compiler.impl.ast.Attribute;
import edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeManager;

@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class QualifiedNameNodeImpl extends NameNodeImpl implements QualifiedNameNode
{
    /** The name being qualified. */
    private NameNode base;
    
    private static enum LocalAttribute implements edu.jhu.cs.bsj.compiler.impl.ast.Attribute
    {
        /** Attribute for the base property. */
        BASE,
    }
    
    /** General constructor. */
    public QualifiedNameNodeImpl(
            NameNode base,
            IdentifierNode identifier,
            NameCategory category,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation,
            BsjNodeManager manager)
    {
        super(identifier, category, startLocation, stopLocation, manager);
        setBase(base);
    }
    
    /**
     * Gets the name being qualified.
     * @return The name being qualified.
     */
    public NameNode getBase()
    {
        recordAccess(LocalAttribute.BASE, Attribute.AccessType.READ);
        return this.base;
    }
    
    /**
     * Changes the name being qualified.
     * @param base The name being qualified.
     */
    public void setBase(NameNode base)
    {
        getManager().assertMutatable(this);
        recordAccess(LocalAttribute.BASE, Attribute.AccessType.STRONG_WRITE);
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
        if (this.base != null)
        {
            this.base.receive(visitor);
        }
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
        if (this.base != null)
        {
            this.base.receiveTyped(visitor);
        }
    }
    
    @Override
    public void receiveTyped(BsjTypedNodeVisitor visitor)
    {
        visitor.visitStartBegin(this);
        visitor.visitQualifiedNameNodeStart(this, true);
        visitor.visitNameNodeStart(this);
        visitor.visitNodeStart(this);
        visitor.visitStartEnd(this);
        receiveTypedToChildren(visitor);
        visitor.visitStopBegin(this);
        visitor.visitNodeStop(this);
        visitor.visitNameNodeStop(this);
        visitor.visitQualifiedNameNodeStop(this, true);
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
        list.add(getBase());
        return list;
    }
    
    /**
     * Obtains a human-readable description of this node.
     * @return A human-readable description of this node.
     */
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        if (base == null)
        {
            sb.append("[null]");
        } else
        {
            sb.append(this.base.toString());
        }
        sb.append('.');
        if (getIdentifier() == null)
        {
            sb.append("[null]");
        } else
        {
            sb.append(getIdentifier().getIdentifier());
            sb.append('[');
            sb.append(this.getCategory());
            sb.append(']');
        }
        return sb.toString();
    }
    
    /**
     * Executes an operation on this node.
     * @param operation The operation to perform.
     * @param p The parameter to pass to the operation.
     * @return The result of the operation.
     */
    @Override
    public <P,R> R executeOperation(BsjNodeOperation<P,R> operation, P p)
    {
        return operation.executeQualifiedNameNode(this, p);
    }
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public QualifiedNameNode deepCopy(BsjNodeFactory factory)
    {
        return factory.makeQualifiedNameNode(
                getBase().deepCopy(factory),
                getIdentifier().deepCopy(factory),
                getCategory(),
                getStartLocation() == null ? null : (BsjSourceLocation)(getStartLocation().clone()),
                getStopLocation() == null ? null : (BsjSourceLocation)(getStopLocation().clone()));
    }
    /**
     * Performs replacement for this node.
     * @param before The node to replace.
     * @param after The node to replace the <tt>before</tt> node.
     * @return <code>true</code> if the replacement was successful; <code>false</code> if the
     *         specified <tt>before</tt> node is not a child of this node.
     */
    public boolean replace(Node before, Node after)
    {
        if (before==null)
            throw new IllegalArgumentException("Cannot replace node with before value of null.");
        
        if (before.equals(this.getBase()) && (after instanceof NameNode))
        {
            setBase((NameNode)after);
            return true;
        }
        if (before.equals(this.getIdentifier()) && (after instanceof IdentifierNode))
        {
            setIdentifier((IdentifierNode)after);
            return true;
        }
        return false;
    }
    
	/**
	 * Retrieves a string representation of this name.
	 * @return The string representation of this name.
	 */
	public String getNameString()
	{
		return getBase().getNameString() + "." + getIdentifier().getIdentifier();
	}
	
	/**
	 * Asserts that this node should fall into the specified category.  This override of the {@link NameNodeImpl}
	 * implementation also enforces certain constraints, such as that everything to the left of a package name must
	 * always be a package name.
	 * @param category The category into which this node should fall.
	 * @throws IllegalStateException If this node cannot fall into that category because it has already been marked with
	 *                               another category.
	 */
	@Override
	public void assertCategory(NameCategory category)
	{
		super.assertCategory(category);
		switch (category)
		{
			case PACKAGE:
				if (getBase().getCategory() != NameCategory.PACKAGE)
				{
					getBase().assertCategory(NameCategory.PACKAGE);
				}
				break;
			case TYPE:
				if (getBase().getCategory() != NameCategory.PACKAGE || getBase().getCategory() != NameCategory.TYPE
						|| getBase().getCategory() != NameCategory.PACKAGE_OR_TYPE)
				{
					getBase().assertCategory(NameCategory.PACKAGE_OR_TYPE);
				}
				break;
		}
	}

}
