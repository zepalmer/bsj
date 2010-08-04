package edu.jhu.cs.bsj.compiler.impl.ast.node;

import java.util.EnumMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeOperation;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.BsjTypedNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.node.IdentifierNode;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.TypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.VariableDeclaratorNode;
import edu.jhu.cs.bsj.compiler.ast.node.VariableDeclaratorOwnerNode;
import edu.jhu.cs.bsj.compiler.ast.node.VariableInitializerNode;
import edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeManager;
import edu.jhu.cs.bsj.compiler.impl.ast.attribute.ReadWriteAttribute;
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class VariableDeclaratorNodeImpl extends NodeImpl implements VariableDeclaratorNode
{
    /** The name of this variable. */
    private IdentifierNode name;
    
    /** The number of additional array levels added to the type of this variable. */
    private int arrayLevels;
    
    /** The initializer to use. */
    private VariableInitializerNode initializer;
    
    private Map<LocalAttribute,ReadWriteAttribute> localAttributes = new EnumMap<LocalAttribute,ReadWriteAttribute>(LocalAttribute.class);
    private ReadWriteAttribute getAttribute(LocalAttribute attributeName)
    {
        ReadWriteAttribute attribute = localAttributes.get(attributeName);
        if (attribute == null)
        {
            attribute = new ReadWriteAttribute(VariableDeclaratorNodeImpl.this);
            localAttributes.put(attributeName, attribute);
        }
        return attribute;
    }
    private static enum LocalAttribute
    {
        /** Attribute identifier for the name property. */
        NAME,
        /** Attribute identifier for the arrayLevels property. */
        ARRAY_LEVELS,
        /** Attribute identifier for the initializer property. */
        INITIALIZER,
    }
    
    /** General constructor. */
    public VariableDeclaratorNodeImpl(
            IdentifierNode name,
            int arrayLevels,
            VariableInitializerNode initializer,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation,
            BsjNodeManager manager,
            boolean binary)
    {
        super(startLocation, stopLocation, manager, binary);
        setName(name, false);
        this.arrayLevels = arrayLevels;
        setInitializer(initializer, false);
    }
    
    /**
     * Gets the name of this variable.
     * @return The name of this variable.
     */
    public IdentifierNode getName()
    {
        getAttribute(LocalAttribute.NAME).recordAccess(ReadWriteAttribute.AccessType.READ);
        return this.name;
    }
    
    /**
     * Changes the name of this variable.
     * @param name The name of this variable.
     */
    public void setName(IdentifierNode name)
    {
            setName(name, true);
    }
    
    private void setName(IdentifierNode name, boolean checkPermissions)
    {
        if (checkPermissions)
        {
            getManager().assertMutatable(this);
            getAttribute(LocalAttribute.NAME).recordAccess(ReadWriteAttribute.AccessType.WRITE);
        }
        setAsChild(name, false);
        this.name = name;
        setAsChild(name, true);
    }
    
    /**
     * Gets the number of additional array levels added to the type of this variable.
     * @return The number of additional array levels added to the type of this variable.
     */
    public int getArrayLevels()
    {
        getAttribute(LocalAttribute.ARRAY_LEVELS).recordAccess(ReadWriteAttribute.AccessType.READ);
        return this.arrayLevels;
    }
    
    /**
     * Changes the number of additional array levels added to the type of this variable.
     * @param arrayLevels The number of additional array levels added to the type of this variable.
     */
    public void setArrayLevels(int arrayLevels)
    {
            setArrayLevels(arrayLevels, true);
    }
    
    private void setArrayLevels(int arrayLevels, boolean checkPermissions)
    {
        if (checkPermissions)
        {
            getManager().assertMutatable(this);
            getAttribute(LocalAttribute.ARRAY_LEVELS).recordAccess(ReadWriteAttribute.AccessType.WRITE);
        }
        this.arrayLevels = arrayLevels;
    }
    
    /**
     * Gets the initializer to use.
     * @return The initializer to use.
     */
    public VariableInitializerNode getInitializer()
    {
        getAttribute(LocalAttribute.INITIALIZER).recordAccess(ReadWriteAttribute.AccessType.READ);
        return this.initializer;
    }
    
    /**
     * Changes the initializer to use.
     * @param initializer The initializer to use.
     */
    public void setInitializer(VariableInitializerNode initializer)
    {
            setInitializer(initializer, true);
    }
    
    private void setInitializer(VariableInitializerNode initializer, boolean checkPermissions)
    {
        if (checkPermissions)
        {
            getManager().assertMutatable(this);
            getAttribute(LocalAttribute.INITIALIZER).recordAccess(ReadWriteAttribute.AccessType.WRITE);
        }
        setAsChild(initializer, false);
        this.initializer = initializer;
        setAsChild(initializer, true);
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
        if (this.name != null)
        {
            this.name.receive(visitor);
        }
        if (this.initializer != null)
        {
            this.initializer.receive(visitor);
        }
        Iterator<? extends Node> extras = getHiddenVisitorChildren();
        if (extras != null)
        {
            while (extras.hasNext())
            {
                extras.next().receive(visitor);
            }
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
        if (this.name != null)
        {
            this.name.receiveTyped(visitor);
        }
        if (this.initializer != null)
        {
            this.initializer.receiveTyped(visitor);
        }
        Iterator<? extends Node> extras = getHiddenVisitorChildren();
        if (extras != null)
        {
            while (extras.hasNext())
            {
                extras.next().receiveTyped(visitor);
            }
        }
    }
    
    @Override
    public void receiveTyped(BsjTypedNodeVisitor visitor)
    {
        visitor.visitStartBegin(this);
        visitor.visitVariableDeclaratorNodeStart(this, true);
        visitor.visitNodeStart(this);
        visitor.visitStartEnd(this);
        receiveTypedToChildren(visitor);
        visitor.visitStopBegin(this);
        visitor.visitNodeStop(this);
        visitor.visitVariableDeclaratorNodeStop(this, true);
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
        list.add(getName());
        list.add(getArrayLevels());
        list.add(getInitializer());
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
        sb.append("name=");
        sb.append(this.getName() == null? "null" : this.getName().getClass().getSimpleName());
        sb.append(',');
        sb.append("arrayLevels=");
        sb.append(String.valueOf(this.getArrayLevels()) + ":" + ("int"));
        sb.append(',');
        sb.append("initializer=");
        sb.append(this.getInitializer() == null? "null" : this.getInitializer().getClass().getSimpleName());
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
     * Executes an operation on this node.
     * @param operation The operation to perform.
     * @param p The parameter to pass to the operation.
     * @return The result of the operation.
     */
    @Override
    public <P,R> R executeOperation(BsjNodeOperation<P,R> operation, P p)
    {
        return operation.executeVariableDeclaratorNode(this, p);
    }
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public VariableDeclaratorNode deepCopy(BsjNodeFactory factory)
    {
        return factory.makeVariableDeclaratorNode(
                getName()==null?null:getName().deepCopy(factory),
                getArrayLevels(),
                getInitializer()==null?null:getInitializer().deepCopy(factory),
                getStartLocation(),
                getStopLocation());
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
        
        if (before.equals(this.getName()) && (after instanceof IdentifierNode))
        {
            setName((IdentifierNode)after);
            return true;
        }
        if (before.equals(this.getInitializer()) && (after instanceof VariableInitializerNode))
        {
            setInitializer((VariableInitializerNode)after);
            return true;
        }
        return false;
    }
    
	
	/**
	 * {@inheritDoc}
	 */
	public TypeNode getEffectiveType(BsjNodeFactory factory)
	{
		VariableDeclaratorOwnerNode owner = this.getNearestAncestorOfType(VariableDeclaratorOwnerNode.class);
		if (owner == null)
		{
			return null;
		}
		TypeNode t = owner.getType().deepCopy(factory);
		for (int i=0;i<this.getArrayLevels();i++)
		{
			t = factory.makeArrayTypeNode(t);
		}
		return t;
	}

}
