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
import edu.jhu.cs.bsj.compiler.ast.node.ArrayInitializerCreationNode;
import edu.jhu.cs.bsj.compiler.ast.node.ArrayInitializerNode;
import edu.jhu.cs.bsj.compiler.ast.node.BaseTypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeManager;
import edu.jhu.cs.bsj.compiler.impl.ast.NormalNodeUnion;
import edu.jhu.cs.bsj.compiler.impl.ast.attribute.ReadWriteAttribute;

@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class ArrayInitializerCreationNodeImpl extends ArrayCreationNodeImpl implements ArrayInitializerCreationNode
{
    /** The initializer for this array. */
    private NodeUnion<? extends ArrayInitializerNode> initializer;
    
    private Map<LocalAttribute,ReadWriteAttribute> localAttributes = new EnumMap<LocalAttribute,ReadWriteAttribute>(LocalAttribute.class);
    private ReadWriteAttribute getAttribute(LocalAttribute attributeName)
    {
        ReadWriteAttribute attribute = localAttributes.get(attributeName);
        if (attribute == null)
        {
            attribute = new ReadWriteAttribute(ArrayInitializerCreationNodeImpl.this);
            localAttributes.put(attributeName, attribute);
        }
        return attribute;
    }
    private static enum LocalAttribute
    {
        /** Attribute identifier for the initializer property. */
        INITIALIZER,
    }
    
    /** General constructor. */
    public ArrayInitializerCreationNodeImpl(
            NodeUnion<? extends ArrayInitializerNode> initializer,
            NodeUnion<? extends BaseTypeNode> baseType,
            int arrayLevels,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation,
            BsjNodeManager manager,
            boolean binary)
    {
        super(baseType, arrayLevels, startLocation, stopLocation, manager, binary);
        setUnionForInitializer(initializer, false);
    }
    
    /**
     * Gets the initializer for this array.  This property's value is assumed to be a normal node.
     * @return The initializer for this array.
     * @throws ClassCastException If this property's value is not a normal node.
     */
    public ArrayInitializerNode getInitializer()
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
     * Gets the initializer for this array.
     * @return The initializer for this array.
     */
    public NodeUnion<? extends ArrayInitializerNode> getUnionForInitializer()
    {
        getAttribute(LocalAttribute.INITIALIZER).recordAccess(ReadWriteAttribute.AccessType.READ);
        if (this.initializer == null)
        {
            this.initializer = new NormalNodeUnion<ArrayInitializerNode>(null);
        }
        return this.initializer;
    }
    
    /**
     * Changes the initializer for this array.
     * @param initializer The initializer for this array.
     */
    public void setInitializer(ArrayInitializerNode initializer)
    {
            setInitializer(initializer, true);
            getManager().notifyChange(this);
    }
    
    private void setInitializer(ArrayInitializerNode initializer, boolean checkPermissions)
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
        this.initializer = new NormalNodeUnion<ArrayInitializerNode>(initializer);
        setAsChild(initializer, true);
    }
    
    /**
     * Changes the initializer for this array.
     * @param initializer The initializer for this array.
     */
    public void setUnionForInitializer(NodeUnion<? extends ArrayInitializerNode> initializer)
    {
            setUnionForInitializer(initializer, true);
            getManager().notifyChange(this);
    }
    
    private void setUnionForInitializer(NodeUnion<? extends ArrayInitializerNode> initializer, boolean checkPermissions)
    {
        if (checkPermissions)
        {
            getManager().assertMutatable(this);
            getAttribute(LocalAttribute.INITIALIZER).recordAccess(ReadWriteAttribute.AccessType.WRITE);
        }
        
        if (initializer == null)
        {
            throw new NullPointerException("Node union for property initializer cannot be null.");
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
        visitor.visitArrayInitializerCreationNodeStart(this, true);
        visitor.visitArrayCreationNodeStart(this);
        visitor.visitNodeStart(this);
        visitor.visitStartEnd(this);
        receiveTypedToChildren(visitor);
        visitor.visitStopBegin(this);
        visitor.visitNodeStop(this);
        visitor.visitArrayCreationNodeStop(this);
        visitor.visitArrayInitializerCreationNodeStop(this, true);
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
        list.add(getInitializer());
        return list;
    }
    
    /**
     * Returns an iterator over the children of this node.
     * @see Node#getChildIterator()
     */
    @Override
    public Iterable<? extends Node> getChildIterable()
    {
        return Arrays.asList(new Node[]{getUnionForInitializer().getNodeValue(), getUnionForBaseType().getNodeValue()});
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
        sb.append("initializer=");
        sb.append(this.getUnionForInitializer().getNodeValue() == null? "null" : this.getUnionForInitializer().getNodeValue().getClass().getSimpleName());
        sb.append(',');
        sb.append("baseType=");
        sb.append(this.getUnionForBaseType().getNodeValue() == null? "null" : this.getUnionForBaseType().getNodeValue().getClass().getSimpleName());
        sb.append(',');
        sb.append("arrayLevels=");
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
        return operation.executeArrayInitializerCreationNode(this, p);
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
        return operation.executeArrayInitializerCreationNode(this, p1, p2);
    }
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public ArrayInitializerCreationNode deepCopy(BsjNodeFactory factory)
    {
        NodeUnion<? extends ArrayInitializerNode> initializerCopy;
        switch (getUnionForInitializer().getType())
        {
            case NORMAL:
                if (getUnionForInitializer().getNormalNode() == null)
                {
                    initializerCopy = factory.<ArrayInitializerNode>makeNormalNodeUnion(null);
                } else
                {
                    initializerCopy = factory.makeNormalNodeUnion(getUnionForInitializer().getNormalNode().deepCopy(factory));
                }
                break;
            case SPLICE:
                if (getUnionForInitializer().getSpliceNode() == null)
                {
                    initializerCopy = factory.<ArrayInitializerNode>makeSpliceNodeUnion(null);
                } else
                {
                    initializerCopy = factory.makeSpliceNodeUnion(getUnionForInitializer().getSpliceNode().deepCopy(factory));
                }
                break;
            default:
                throw new IllegalStateException("Unrecognized union component type: " + getUnionForInitializer().getType());
        }
        NodeUnion<? extends BaseTypeNode> baseTypeCopy;
        switch (getUnionForBaseType().getType())
        {
            case NORMAL:
                if (getUnionForBaseType().getNormalNode() == null)
                {
                    baseTypeCopy = factory.<BaseTypeNode>makeNormalNodeUnion(null);
                } else
                {
                    baseTypeCopy = factory.makeNormalNodeUnion(getUnionForBaseType().getNormalNode().deepCopy(factory));
                }
                break;
            case SPLICE:
                if (getUnionForBaseType().getSpliceNode() == null)
                {
                    baseTypeCopy = factory.<BaseTypeNode>makeSpliceNodeUnion(null);
                } else
                {
                    baseTypeCopy = factory.makeSpliceNodeUnion(getUnionForBaseType().getSpliceNode().deepCopy(factory));
                }
                break;
            default:
                throw new IllegalStateException("Unrecognized union component type: " + getUnionForBaseType().getType());
        }
        return factory.makeArrayInitializerCreationNode(
                initializerCopy,
                baseTypeCopy,
                getArrayLevels(),
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
        
        if (before.equals(this.getInitializer()) && (after instanceof ArrayInitializerNode))
        {
            setInitializer((ArrayInitializerNode)after);
            return true;
        }
        if (before.equals(this.getBaseType()) && (after instanceof BaseTypeNode))
        {
            setBaseType((BaseTypeNode)after);
            return true;
        }
        return false;
    }
    
}
