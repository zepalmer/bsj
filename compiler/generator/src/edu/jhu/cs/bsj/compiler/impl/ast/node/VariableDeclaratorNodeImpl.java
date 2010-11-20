package edu.jhu.cs.bsj.compiler.impl.ast.node;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeOperation;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeOperation2Arguments;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.BsjTypedNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.NodeUnion;
import edu.jhu.cs.bsj.compiler.ast.node.IdentifierNode;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.TypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.VariableDeclaratorNode;
import edu.jhu.cs.bsj.compiler.ast.node.VariableDeclaratorOwnerNode;
import edu.jhu.cs.bsj.compiler.ast.node.VariableInitializerNode;
import edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeManager;
import edu.jhu.cs.bsj.compiler.impl.ast.NormalNodeUnion;
import edu.jhu.cs.bsj.compiler.impl.ast.attribute.AttributeName;
import edu.jhu.cs.bsj.compiler.impl.ast.attribute.ReadWriteAttribute;
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class VariableDeclaratorNodeImpl extends NodeImpl implements VariableDeclaratorNode
{
    /** The name of this variable. */
    private NodeUnion<? extends IdentifierNode> identifier;
    
    /** The number of additional array levels added to the type of this variable. */
    private int arrayLevels;
    
    /** The initializer to use. */
    private NodeUnion<? extends VariableInitializerNode> initializer;
    
    private Map<LocalAttribute,ReadWriteAttribute> localAttributes = new EnumMap<LocalAttribute,ReadWriteAttribute>(LocalAttribute.class);
    private ReadWriteAttribute getAttribute(LocalAttribute attributeName)
    {
        ReadWriteAttribute attribute = localAttributes.get(attributeName);
        if (attribute == null)
        {
            attribute = new ReadWriteAttribute(VariableDeclaratorNodeImpl.this, attributeName);
            localAttributes.put(attributeName, attribute);
        }
        return attribute;
    }
    private static enum LocalAttribute implements AttributeName
    {
        /** Attribute identifier for the identifier property. */
        IDENTIFIER,
        /** Attribute identifier for the arrayLevels property. */
        ARRAY_LEVELS,
        /** Attribute identifier for the initializer property. */
        INITIALIZER,
    }
    
    /** General constructor. */
    public VariableDeclaratorNodeImpl(
            NodeUnion<? extends IdentifierNode> identifier,
            int arrayLevels,
            NodeUnion<? extends VariableInitializerNode> initializer,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation,
            BsjNodeManager manager,
            boolean binary)
    {
        super(startLocation, stopLocation, manager, binary);
        setUnionForIdentifier(identifier, false);
        this.arrayLevels = arrayLevels;
        setUnionForInitializer(initializer, false);
    }
    
    /**
     * Gets the name of this variable.  This property's value is assumed to be a normal node.
     * @return The name of this variable.
     * @throws ClassCastException If this property's value is not a normal node.
     */
    public IdentifierNode getIdentifier()
    {
        getAttribute(LocalAttribute.IDENTIFIER).recordAccess(ReadWriteAttribute.AccessType.READ);
        if (this.identifier == null)
        {
            return null;
        } else
        {
            return this.identifier.getNormalNode();
        }
    }
    
    /**
     * Gets the name of this variable.
     * @return The name of this variable.
     */
    public NodeUnion<? extends IdentifierNode> getUnionForIdentifier()
    {
        getAttribute(LocalAttribute.IDENTIFIER).recordAccess(ReadWriteAttribute.AccessType.READ);
        if (this.identifier == null)
        {
            this.identifier = new NormalNodeUnion<IdentifierNode>(null);
        }
        return this.identifier;
    }
    
    /**
     * Changes the name of this variable.
     * @param identifier The name of this variable.
     */
    public void setIdentifier(IdentifierNode identifier)
    {
            setIdentifier(identifier, true);
            getManager().notifyChange(this);
    }
    
    private void setIdentifier(IdentifierNode identifier, boolean checkPermissions)
    {
        if (checkPermissions)
        {
            getManager().assertMutatable(this);
            getAttribute(LocalAttribute.IDENTIFIER).recordAccess(ReadWriteAttribute.AccessType.WRITE);
        }
        
        if (this.identifier != null)
        {
            setAsChild(this.identifier.getNodeValue(), false);
        }
        this.identifier = new NormalNodeUnion<IdentifierNode>(identifier);
        setAsChild(identifier, true);
    }
    
    /**
     * Changes the name of this variable.
     * @param identifier The name of this variable.
     */
    public void setUnionForIdentifier(NodeUnion<? extends IdentifierNode> identifier)
    {
            setUnionForIdentifier(identifier, true);
            getManager().notifyChange(this);
    }
    
    private void setUnionForIdentifier(NodeUnion<? extends IdentifierNode> identifier, boolean checkPermissions)
    {
        if (checkPermissions)
        {
            getManager().assertMutatable(this);
            getAttribute(LocalAttribute.IDENTIFIER).recordAccess(ReadWriteAttribute.AccessType.WRITE);
        }
        
        if (identifier == null)
        {
            identifier = new NormalNodeUnion<IdentifierNode>(null);
        }
        if (this.identifier != null)
        {
            setAsChild(this.identifier.getNodeValue(), false);
        }
        this.identifier = identifier;
        setAsChild(identifier.getNodeValue(), true);
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
            getManager().notifyChange(this);
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
     * Gets the initializer to use.  This property's value is assumed to be a normal node.
     * @return The initializer to use.
     * @throws ClassCastException If this property's value is not a normal node.
     */
    public VariableInitializerNode getInitializer()
    {
        getAttribute(LocalAttribute.INITIALIZER).recordAccess(ReadWriteAttribute.AccessType.READ);
        if (this.initializer == null)
        {
            return null;
        } else
        {
            return this.initializer.getNormalNode();
        }
    }
    
    /**
     * Gets the initializer to use.
     * @return The initializer to use.
     */
    public NodeUnion<? extends VariableInitializerNode> getUnionForInitializer()
    {
        getAttribute(LocalAttribute.INITIALIZER).recordAccess(ReadWriteAttribute.AccessType.READ);
        if (this.initializer == null)
        {
            this.initializer = new NormalNodeUnion<VariableInitializerNode>(null);
        }
        return this.initializer;
    }
    
    /**
     * Changes the initializer to use.
     * @param initializer The initializer to use.
     */
    public void setInitializer(VariableInitializerNode initializer)
    {
            setInitializer(initializer, true);
            getManager().notifyChange(this);
    }
    
    private void setInitializer(VariableInitializerNode initializer, boolean checkPermissions)
    {
        if (checkPermissions)
        {
            getManager().assertMutatable(this);
            getAttribute(LocalAttribute.INITIALIZER).recordAccess(ReadWriteAttribute.AccessType.WRITE);
        }
        
        if (this.initializer != null)
        {
            setAsChild(this.initializer.getNodeValue(), false);
        }
        this.initializer = new NormalNodeUnion<VariableInitializerNode>(initializer);
        setAsChild(initializer, true);
    }
    
    /**
     * Changes the initializer to use.
     * @param initializer The initializer to use.
     */
    public void setUnionForInitializer(NodeUnion<? extends VariableInitializerNode> initializer)
    {
            setUnionForInitializer(initializer, true);
            getManager().notifyChange(this);
    }
    
    private void setUnionForInitializer(NodeUnion<? extends VariableInitializerNode> initializer, boolean checkPermissions)
    {
        if (checkPermissions)
        {
            getManager().assertMutatable(this);
            getAttribute(LocalAttribute.INITIALIZER).recordAccess(ReadWriteAttribute.AccessType.WRITE);
        }
        
        if (initializer == null)
        {
            initializer = new NormalNodeUnion<VariableInitializerNode>(null);
        }
        if (this.initializer != null)
        {
            setAsChild(this.initializer.getNodeValue(), false);
        }
        this.initializer = initializer;
        setAsChild(initializer.getNodeValue(), true);
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
        if (this.identifier.getNodeValue() != null)
        {
            this.identifier.getNodeValue().receive(visitor);
        }
        if (this.initializer.getNodeValue() != null)
        {
            this.initializer.getNodeValue().receive(visitor);
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
        if (this.identifier.getNodeValue() != null)
        {
            this.identifier.getNodeValue().receiveTyped(visitor);
        }
        if (this.initializer.getNodeValue() != null)
        {
            this.initializer.getNodeValue().receiveTyped(visitor);
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
        visitor.visitVariableNameBindingNodeStart(this);
        visitor.visitStartEnd(this);
        receiveTypedToChildren(visitor);
        visitor.visitStopBegin(this);
        visitor.visitVariableNameBindingNodeStop(this);
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
        list.add(getArrayLevels());
        list.add(getUnionForInitializer());
        list.add(getUnionForIdentifier());
        return list;
    }
    
    /**
     * Returns an iterator over the children of this node.
     * @see Node#getChildIterator()
     */
    @Override
    public Iterable<? extends Node> getChildIterable()
    {
        return Arrays.asList(new Node[]{getUnionForIdentifier().getNodeValue(), getUnionForInitializer().getNodeValue()});
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
        sb.append(this.getUnionForIdentifier().getNodeValue() == null? "null" : this.getUnionForIdentifier().getNodeValue().getClass().getSimpleName());
        sb.append(',');
        sb.append("arrayLevels=");
        sb.append(',');
        sb.append("initializer=");
        sb.append(this.getUnionForInitializer().getNodeValue() == null? "null" : this.getUnionForInitializer().getNodeValue().getClass().getSimpleName());
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
     * Executes an operation on this node.
     * @param operation The operation to perform.
     * @param p1 The parameter to pass to the operation.
     * @param p2 The parameter to pass to the operation.
     * @return The result of the operation.
     */
    @Override
    public <P1,P2,R> R executeOperation(BsjNodeOperation2Arguments<P1,P2,R> operation, P1 p1, P2 p2)
    {
        return operation.executeVariableDeclaratorNode(this, p1, p2);
    }
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public VariableDeclaratorNode deepCopy(BsjNodeFactory factory)
    {
        NodeUnion<? extends IdentifierNode> identifierCopy;
        switch (getUnionForIdentifier().getType())
        {
            case NORMAL:
                if (getUnionForIdentifier().getNormalNode() == null)
                {
                    identifierCopy = factory.<IdentifierNode>makeNormalNodeUnion(null);
                } else
                {
                    identifierCopy = factory.makeNormalNodeUnion(getUnionForIdentifier().getNormalNode().deepCopy(factory));
                }
                break;
            case SPLICE:
                if (getUnionForIdentifier().getSpliceNode() == null)
                {
                    identifierCopy = factory.<IdentifierNode>makeSpliceNodeUnion(null);
                } else
                {
                    identifierCopy = factory.makeSpliceNodeUnion(getUnionForIdentifier().getSpliceNode().deepCopy(factory));
                }
                break;
            default:
                throw new IllegalStateException("Unrecognized union component type: " + getUnionForIdentifier().getType());
        }
        NodeUnion<? extends VariableInitializerNode> initializerCopy;
        switch (getUnionForInitializer().getType())
        {
            case NORMAL:
                if (getUnionForInitializer().getNormalNode() == null)
                {
                    initializerCopy = factory.<VariableInitializerNode>makeNormalNodeUnion(null);
                } else
                {
                    initializerCopy = factory.makeNormalNodeUnion(getUnionForInitializer().getNormalNode().deepCopy(factory));
                }
                break;
            case SPLICE:
                if (getUnionForInitializer().getSpliceNode() == null)
                {
                    initializerCopy = factory.<VariableInitializerNode>makeSpliceNodeUnion(null);
                } else
                {
                    initializerCopy = factory.makeSpliceNodeUnion(getUnionForInitializer().getSpliceNode().deepCopy(factory));
                }
                break;
            default:
                throw new IllegalStateException("Unrecognized union component type: " + getUnionForInitializer().getType());
        }
        return factory.makeVariableDeclaratorNodeWithUnions(
                identifierCopy,
                getArrayLevels(),
                initializerCopy,
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
        
        if (before.equals(this.getUnionForIdentifier().getNodeValue()))
        {
            setIdentifier((IdentifierNode)after);
            return true;
        }
        if (before.equals(this.getUnionForInitializer().getNodeValue()))
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
