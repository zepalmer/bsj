package edu.jhu.cs.bsj.compiler.impl.ast.node;

import java.util.Arrays;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjAbortableNodeOperation;
import edu.jhu.cs.bsj.compiler.ast.BsjAbortableNodeOperation2Arguments;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.BsjTypedNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.NodeUnion;
import edu.jhu.cs.bsj.compiler.ast.node.ArrayInitializerCreationNode;
import edu.jhu.cs.bsj.compiler.ast.node.ArrayInitializerNode;
import edu.jhu.cs.bsj.compiler.ast.node.BaseTypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeManager;
import edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactory;
import edu.jhu.cs.bsj.compiler.impl.ast.NormalNodeUnion;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.property.ArrayInitializerCreationNodeSetInitializerPropertyEditScriptElementImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.properties.ArrayInitializerCreationNodeProperties;

@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class ArrayInitializerCreationNodeImpl extends ArrayCreationNodeImpl implements ArrayInitializerCreationNode
{
    /** The initializer for this array. */
    private NodeUnion<? extends ArrayInitializerNode> initializer;
    
    /**
     * A set of those properties which have been populated from the backing node.
     * This field is <code>null</code> if <tt>backingNode</tt> is <code>null</code>.
     */
    private Set<ArrayInitializerCreationNodeProperties> populatedProperties;
    
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
        this.populatedProperties = null;
        doSetInitializer(initializer);
    }
    
    /** Proxy constructor. */
    public ArrayInitializerCreationNodeImpl(BsjNodeManager manager, BsjNodeProxyFactory proxyFactory, ArrayInitializerCreationNode backingNode)
    {
        super(manager, proxyFactory, backingNode);
        this.populatedProperties = EnumSet.noneOf(ArrayInitializerCreationNodeProperties.class);
    }
    
    /** Retrieves this node's backing node (if one exists). */
    protected ArrayInitializerCreationNode getBackingNode()
    {
        return (ArrayInitializerCreationNode)super.getBackingNode();
    }
    
    /**
     * Ensures that the initializer value has been populated from proxy.
     * If this node is not backed by a proxy or if the value has already been
     * populated, this method does nothing.
     */
    private void checkInitializerWrapped()
    {
        if (this.populatedProperties == null || this.populatedProperties.contains(
                ArrayInitializerCreationNodeProperties.INITIALIZER))
            return;
        this.populatedProperties.add(ArrayInitializerCreationNodeProperties.INITIALIZER);
        NodeUnion<? extends ArrayInitializerNode> union = this.getBackingNode().getUnionForInitializer();
        switch (union.getType())
        {
            case NORMAL:
                union = this.getProxyFactory().makeNormalNodeUnion(
                        this.getProxyFactory().makeArrayInitializerNode(union.getNormalNode()));
                break;
            case SPLICE:
                union = this.getProxyFactory().makeSpliceNodeUnion(
                        this.getProxyFactory().makeSpliceNode(union.getSpliceNode()));
                break;
            default:
                throw new IllegalStateException("Unrecognized union type: " + union.getType());
        }
        this.initializer = union;
    }
    
    /**
     * Gets the initializer for this array.  This property's value is assumed to be a normal node.
     * @return The initializer for this array.
     * @throws ClassCastException If this property's value is not a normal node.
     */
    public ArrayInitializerNode getInitializer()
    {
        checkInitializerWrapped();
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
        checkInitializerWrapped();
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
        checkInitializerWrapped();
        this.setUnionForInitializer(new NormalNodeUnion<ArrayInitializerNode>(initializer));
    }
    
    /**
     * Changes the initializer for this array.
     * @param initializer The initializer for this array.
     */
    public void setUnionForInitializer(NodeUnion<? extends ArrayInitializerNode> initializer)
    {
        checkInitializerWrapped();
        this.getManager().assertMutatable(this);
        this.doSetInitializer(initializer);
        if (this.getManager().isRecordingEdits())
            super.recordEdit(new ArrayInitializerCreationNodeSetInitializerPropertyEditScriptElementImpl(this.getManager().getCurrentMetaprogramId(), this.getUid(), initializer.getNodeValue() == null ? null : initializer.getNodeValue().getUid()));
    }
    
    private void doSetInitializer(NodeUnion<? extends ArrayInitializerNode> initializer)
    {
        if (initializer == null)
        {
            initializer = new NormalNodeUnion<ArrayInitializerNode>(null);
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
        if (this.getUnionForInitializer().getNodeValue() != null)
        {
            this.getUnionForInitializer().getNodeValue().receive(visitor);
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
        if (this.getUnionForInitializer().getNodeValue() != null)
        {
            this.getUnionForInitializer().getNodeValue().receiveTyped(visitor);
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
        list.add(getUnionForInitializer());
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
        sb.append('#');
        sb.append(this.getUid());
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
    public <P,R,X extends Exception> R executeOperation(BsjAbortableNodeOperation<P,R,X> operation, P p) throws X
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
    public <P1,P2,R,X extends Exception> R executeOperation(BsjAbortableNodeOperation2Arguments<P1,P2,R,X> operation, P1 p1, P2 p2) throws X
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
        return factory.makeArrayInitializerCreationNodeWithUnions(
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
        
        if (before.equals(this.getUnionForInitializer().getNodeValue()))
        {
            setInitializer((ArrayInitializerNode)after);
            return true;
        }
        if (before.equals(this.getUnionForBaseType().getNodeValue()))
        {
            setBaseType((BaseTypeNode)after);
            return true;
        }
        return false;
    }
    
}
