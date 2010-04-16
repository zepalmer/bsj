package edu.jhu.cs.bsj.compiler.impl.ast.node;

import static edu.jhu.cs.bsj.compiler.ast.NameCategory.AMBIGUOUS;
import static edu.jhu.cs.bsj.compiler.ast.NameCategory.EXPRESSION;
import static edu.jhu.cs.bsj.compiler.ast.NameCategory.PACKAGE;
import static edu.jhu.cs.bsj.compiler.ast.NameCategory.PACKAGE_OR_TYPE;
import static edu.jhu.cs.bsj.compiler.ast.NameCategory.TYPE;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.BsjTypedNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.NameCategory;
import edu.jhu.cs.bsj.compiler.ast.node.IdentifierNode;
import edu.jhu.cs.bsj.compiler.ast.node.NameNode;
import edu.jhu.cs.bsj.compiler.impl.ast.Attribute;
import edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeManager;
import edu.jhu.cs.bsj.compiler.impl.utils.Pair;
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public abstract class NameNodeImpl extends NodeImpl implements NameNode
{
    /** The identifier used in this name. */
    private IdentifierNode identifier;
    
    /** The category for this name. */
    private NameCategory category;
    
    private static enum LocalAttribute implements edu.jhu.cs.bsj.compiler.impl.ast.Attribute
    {
        /** Attribute for the identifier property. */
        IDENTIFIER,
        /** Attribute for the category property. */
        CATEGORY,
    }
    
    /** General constructor. */
    protected NameNodeImpl(
            IdentifierNode identifier,
            NameCategory category,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation,
            BsjNodeManager manager,
            boolean binary)
    {
        super(startLocation, stopLocation, manager, binary);
        setIdentifier(identifier, false);
        this.category = category;
    }
    
    /**
     * Gets the identifier used in this name.
     * @return The identifier used in this name.
     */
    public IdentifierNode getIdentifier()
    {
        recordAccess(LocalAttribute.IDENTIFIER, Attribute.AccessType.READ);
        return this.identifier;
    }
    
    /**
     * Changes the identifier used in this name.
     * @param identifier The identifier used in this name.
     */
    public void setIdentifier(IdentifierNode identifier)
    {
            setIdentifier(identifier, true);
    }
    
    private void setIdentifier(IdentifierNode identifier, boolean checkPermissions)
    {
        if (checkPermissions)
        {
            getManager().assertMutatable(this);
        }
        recordAccess(LocalAttribute.IDENTIFIER, Attribute.AccessType.WRITE);
        if (this.identifier instanceof NodeImpl)
        {
            ((NodeImpl)this.identifier).setParent(null);
        }
        this.identifier = identifier;
        if (this.identifier instanceof NodeImpl)
        {
            ((NodeImpl)this.identifier).setParent(this);
        }
    }
    
    /**
     * Gets the category for this name.
     * @return The category for this name.
     */
    public NameCategory getCategory()
    {
        recordAccess(LocalAttribute.CATEGORY, Attribute.AccessType.READ);
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
        if (this.identifier != null)
        {
            this.identifier.receive(visitor);
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
        if (this.identifier != null)
        {
            this.identifier.receiveTyped(visitor);
        }
    }
    
    @Override
    public void receiveTyped(BsjTypedNodeVisitor visitor)
    {
        visitor.visitStartBegin(this);
        visitor.visitNameNodeStart(this);
        visitor.visitNodeStart(this);
        visitor.visitStartEnd(this);
        receiveTypedToChildren(visitor);
        visitor.visitStopBegin(this);
        visitor.visitNodeStop(this);
        visitor.visitNameNodeStop(this);
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
        list.add(getIdentifier());
        list.add(getCategory());
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
        sb.append("identifier=");
        sb.append(this.getIdentifier() == null? "null" : this.getIdentifier().getClass().getSimpleName());
        sb.append(',');
        sb.append("category=");
        sb.append(String.valueOf(this.getCategory()) + ":" + (this.getCategory() != null ? this.getCategory().getClass().getSimpleName() : "null"));
        sb.append(',');
        sb.append("startLocation=");
        sb.append(String.valueOf(this.getStartLocation()) + ":" + (this.getStartLocation() != null ? this.getStartLocation().getClass().getSimpleName() : "null"));
        sb.append(',');
        sb.append("stopLocation=");
        sb.append(String.valueOf(this.getStopLocation()) + ":" + (this.getStopLocation() != null ? this.getStopLocation().getClass().getSimpleName() : "null"));
        sb.append(']');
        return sb.toString();
    }
    
    
	/**
	 * This data structure maps pairs of name categories to the appropriate transition when category assertions are
	 * made.  When a mapping is not present, the transition in question is illegal.
	 */
	private static Map<Pair<NameCategory,NameCategory>,NameCategory> categoryTransitionMap;
	// Initialize the category transition map
	private static void addMapping(Map<Pair<NameCategory,NameCategory>,NameCategory> map, NameCategory prev,
			NameCategory assertion, NameCategory result)
	{
		map.put(new Pair<NameCategory,NameCategory>(prev,assertion), result);
	}
	static {
		Map<Pair<NameCategory,NameCategory>,NameCategory> map =
			new HashMap<Pair<NameCategory,NameCategory>,NameCategory>();
		
		addMapping(map, AMBIGUOUS, PACKAGE, PACKAGE);
		addMapping(map, AMBIGUOUS, TYPE, TYPE);
		addMapping(map, AMBIGUOUS, EXPRESSION, EXPRESSION);
		addMapping(map, AMBIGUOUS, PACKAGE_OR_TYPE, PACKAGE_OR_TYPE);
		addMapping(map, PACKAGE_OR_TYPE, PACKAGE, PACKAGE);
		addMapping(map, PACKAGE_OR_TYPE, TYPE, TYPE);
		
		categoryTransitionMap = Collections.unmodifiableMap(map);
	}
	
	/**
	 * Asserts that this node should fall into the specified category.
	 * @param category The category into which this node should fall.
	 * @throws IllegalStateException If this node cannot fall into that category because it has already been marked with
	 *                               another category.
	 */
	public void assertCategory(NameCategory category)
	{
		if (this.category == category)
			return;
		
		if (this.category == null)
		{
			this.category = category;
			return;
		}
		
		NameCategory result = categoryTransitionMap.get(new Pair<NameCategory,NameCategory>(this.category, category));
		if (result == null)
		{
			result = categoryTransitionMap.get(new Pair<NameCategory,NameCategory>(category, this.category));
		}
		if (result == null)
		{
			throw new IllegalStateException("Illegal name category transition: " + this.category + " => " + category);
		} else
		{
			this.category = result;
		}
	}

}
