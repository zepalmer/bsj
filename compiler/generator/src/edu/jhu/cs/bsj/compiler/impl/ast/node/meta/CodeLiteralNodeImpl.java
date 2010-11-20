package edu.jhu.cs.bsj.compiler.impl.ast.node.meta;

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
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.meta.CodeLiteralNode;
import edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeManager;
import edu.jhu.cs.bsj.compiler.impl.ast.NormalNodeUnion;
import edu.jhu.cs.bsj.compiler.impl.ast.attribute.AttributeName;
import edu.jhu.cs.bsj.compiler.impl.ast.attribute.ReadWriteAttribute;
import edu.jhu.cs.bsj.compiler.impl.ast.node.NodeImpl;

@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class CodeLiteralNodeImpl extends NodeImpl implements CodeLiteralNode
{
    /** The node represented by this code literal. */
    private NodeUnion<? extends Node> value;
    
    private Map<LocalAttribute,ReadWriteAttribute> localAttributes = new EnumMap<LocalAttribute,ReadWriteAttribute>(LocalAttribute.class);
    private ReadWriteAttribute getAttribute(LocalAttribute attributeName)
    {
        ReadWriteAttribute attribute = localAttributes.get(attributeName);
        if (attribute == null)
        {
            attribute = new ReadWriteAttribute(CodeLiteralNodeImpl.this, attributeName);
            localAttributes.put(attributeName, attribute);
        }
        return attribute;
    }
    private static enum LocalAttribute implements AttributeName
    {
        /** Attribute identifier for the value property. */
        VALUE,
    }
    
    /** General constructor. */
    public CodeLiteralNodeImpl(
            NodeUnion<? extends Node> value,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation,
            BsjNodeManager manager,
            boolean binary)
    {
        super(startLocation, stopLocation, manager, binary);
        setUnionForValue(value, false);
    }
    
    /**
     * Gets the node represented by this code literal.  This property's value is assumed to be a normal node.
     * @return The node represented by this code literal.
     * @throws ClassCastException If this property's value is not a normal node.
     */
    public Node getValue()
    {
        getAttribute(LocalAttribute.VALUE).recordAccess(ReadWriteAttribute.AccessType.READ);
        if (this.value == null)
        {
            return null;
        } else
        {
            return this.value.getNormalNode();
        }
    }
    
    /**
     * Gets the node represented by this code literal.
     * @return The node represented by this code literal.
     */
    public NodeUnion<? extends Node> getUnionForValue()
    {
        getAttribute(LocalAttribute.VALUE).recordAccess(ReadWriteAttribute.AccessType.READ);
        if (this.value == null)
        {
            this.value = new NormalNodeUnion<Node>(null);
        }
        return this.value;
    }
    
    /**
     * Changes the node represented by this code literal.
     * @param value The node represented by this code literal.
     */
    public void setValue(Node value)
    {
            setValue(value, true);
            getManager().notifyChange(this);
    }
    
    private void setValue(Node value, boolean checkPermissions)
    {
        if (checkPermissions)
        {
            getManager().assertMutatable(this);
            getAttribute(LocalAttribute.VALUE).recordAccess(ReadWriteAttribute.AccessType.WRITE);
        }
        
        if (this.value != null)
        {
            setAsChild(this.value.getNodeValue(), false);
        }
        this.value = new NormalNodeUnion<Node>(value);
        setAsChild(value, true);
    }
    
    /**
     * Changes the node represented by this code literal.
     * @param value The node represented by this code literal.
     */
    public void setUnionForValue(NodeUnion<? extends Node> value)
    {
            setUnionForValue(value, true);
            getManager().notifyChange(this);
    }
    
    private void setUnionForValue(NodeUnion<? extends Node> value, boolean checkPermissions)
    {
        if (checkPermissions)
        {
            getManager().assertMutatable(this);
            getAttribute(LocalAttribute.VALUE).recordAccess(ReadWriteAttribute.AccessType.WRITE);
        }
        
        if (value == null)
        {
            value = new NormalNodeUnion<Node>(null);
        }
        if (this.value != null)
        {
            setAsChild(this.value.getNodeValue(), false);
        }
        this.value = value;
        setAsChild(value.getNodeValue(), true);
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
        if (this.value.getNodeValue() != null)
        {
            this.value.getNodeValue().receive(visitor);
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
        if (this.value.getNodeValue() != null)
        {
            this.value.getNodeValue().receiveTyped(visitor);
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
        visitor.visitCodeLiteralNodeStart(this, true);
        visitor.visitNodeStart(this);
        visitor.visitLiteralNodeStart(this);
        visitor.visitStartEnd(this);
        receiveTypedToChildren(visitor);
        visitor.visitStopBegin(this);
        visitor.visitLiteralNodeStop(this);
        visitor.visitNodeStop(this);
        visitor.visitCodeLiteralNodeStop(this, true);
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
        list.add(getUnionForValue());
        return list;
    }
    
    /**
     * Returns an iterator over the children of this node.
     * @see Node#getChildIterator()
     */
    @Override
    public Iterable<? extends Node> getChildIterable()
    {
        return Arrays.asList(new Node[]{getUnionForValue().getNodeValue()});
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
        sb.append("value=");
        sb.append(this.getUnionForValue().getNodeValue() == null? "null" : this.getUnionForValue().getNodeValue().getClass().getSimpleName());
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
        return operation.executeCodeLiteralNode(this, p);
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
        return operation.executeCodeLiteralNode(this, p1, p2);
    }
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public CodeLiteralNode deepCopy(BsjNodeFactory factory)
    {
        NodeUnion<? extends Node> valueCopy;
        switch (getUnionForValue().getType())
        {
            case NORMAL:
                if (getUnionForValue().getNormalNode() == null)
                {
                    valueCopy = factory.<Node>makeNormalNodeUnion(null);
                } else
                {
                    valueCopy = factory.makeNormalNodeUnion(getUnionForValue().getNormalNode().deepCopy(factory));
                }
                break;
            case SPLICE:
                if (getUnionForValue().getSpliceNode() == null)
                {
                    valueCopy = factory.<Node>makeSpliceNodeUnion(null);
                } else
                {
                    valueCopy = factory.makeSpliceNodeUnion(getUnionForValue().getSpliceNode().deepCopy(factory));
                }
                break;
            default:
                throw new IllegalStateException("Unrecognized union component type: " + getUnionForValue().getType());
        }
        return factory.makeCodeLiteralNodeWithUnions(
                valueCopy,
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
        
        if (before.equals(this.getUnionForValue().getNodeValue()))
        {
            setValue((Node)after);
            return true;
        }
        return false;
    }
    
}
