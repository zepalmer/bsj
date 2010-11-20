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
import edu.jhu.cs.bsj.compiler.ast.node.AnonymousClassBodyNode;
import edu.jhu.cs.bsj.compiler.ast.node.DeclaredTypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.UnqualifiedClassInstantiationNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.ExpressionListNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.TypeArgumentListNode;
import edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeManager;
import edu.jhu.cs.bsj.compiler.impl.ast.NormalNodeUnion;
import edu.jhu.cs.bsj.compiler.impl.ast.attribute.AttributeName;
import edu.jhu.cs.bsj.compiler.impl.ast.attribute.ReadWriteAttribute;

@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class UnqualifiedClassInstantiationNodeImpl extends ClassInstantiationNodeImpl implements UnqualifiedClassInstantiationNode
{
    /** The type being instantiated. */
    private NodeUnion<? extends DeclaredTypeNode> type;
    
    private Map<LocalAttribute,ReadWriteAttribute> localAttributes = new EnumMap<LocalAttribute,ReadWriteAttribute>(LocalAttribute.class);
    private ReadWriteAttribute getAttribute(LocalAttribute attributeName)
    {
        ReadWriteAttribute attribute = localAttributes.get(attributeName);
        if (attribute == null)
        {
            attribute = new ReadWriteAttribute(UnqualifiedClassInstantiationNodeImpl.this, attributeName);
            localAttributes.put(attributeName, attribute);
        }
        return attribute;
    }
    private static enum LocalAttribute implements AttributeName
    {
        /** Attribute identifier for the type property. */
        TYPE,
    }
    
    /** General constructor. */
    public UnqualifiedClassInstantiationNodeImpl(
            NodeUnion<? extends DeclaredTypeNode> type,
            NodeUnion<? extends TypeArgumentListNode> constructorTypeArguments,
            NodeUnion<? extends ExpressionListNode> arguments,
            NodeUnion<? extends AnonymousClassBodyNode> body,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation,
            BsjNodeManager manager,
            boolean binary)
    {
        super(constructorTypeArguments, arguments, body, startLocation, stopLocation, manager, binary);
        setUnionForType(type, false);
    }
    
    /**
     * Gets the type being instantiated.  This property's value is assumed to be a normal node.
     * @return The type being instantiated.
     * @throws ClassCastException If this property's value is not a normal node.
     */
    public DeclaredTypeNode getType()
    {
        getAttribute(LocalAttribute.TYPE).recordAccess(ReadWriteAttribute.AccessType.READ);
        if (this.type == null)
        {
            return null;
        } else
        {
            return this.type.getNormalNode();
        }
    }
    
    /**
     * Gets the type being instantiated.
     * @return The type being instantiated.
     */
    public NodeUnion<? extends DeclaredTypeNode> getUnionForType()
    {
        getAttribute(LocalAttribute.TYPE).recordAccess(ReadWriteAttribute.AccessType.READ);
        if (this.type == null)
        {
            this.type = new NormalNodeUnion<DeclaredTypeNode>(null);
        }
        return this.type;
    }
    
    /**
     * Changes the type being instantiated.
     * @param type The type being instantiated.
     */
    public void setType(DeclaredTypeNode type)
    {
            setType(type, true);
            getManager().notifyChange(this);
    }
    
    private void setType(DeclaredTypeNode type, boolean checkPermissions)
    {
        if (checkPermissions)
        {
            getManager().assertMutatable(this);
            getAttribute(LocalAttribute.TYPE).recordAccess(ReadWriteAttribute.AccessType.WRITE);
        }
        
        if (this.type != null)
        {
            setAsChild(this.type.getNodeValue(), false);
        }
        this.type = new NormalNodeUnion<DeclaredTypeNode>(type);
        setAsChild(type, true);
    }
    
    /**
     * Changes the type being instantiated.
     * @param type The type being instantiated.
     */
    public void setUnionForType(NodeUnion<? extends DeclaredTypeNode> type)
    {
            setUnionForType(type, true);
            getManager().notifyChange(this);
    }
    
    private void setUnionForType(NodeUnion<? extends DeclaredTypeNode> type, boolean checkPermissions)
    {
        if (checkPermissions)
        {
            getManager().assertMutatable(this);
            getAttribute(LocalAttribute.TYPE).recordAccess(ReadWriteAttribute.AccessType.WRITE);
        }
        
        if (type == null)
        {
            type = new NormalNodeUnion<DeclaredTypeNode>(null);
        }
        if (this.type != null)
        {
            setAsChild(this.type.getNodeValue(), false);
        }
        this.type = type;
        setAsChild(type.getNodeValue(), true);
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
        if (this.type.getNodeValue() != null)
        {
            this.type.getNodeValue().receive(visitor);
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
        if (this.type.getNodeValue() != null)
        {
            this.type.getNodeValue().receiveTyped(visitor);
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
        visitor.visitUnqualifiedClassInstantiationNodeStart(this, true);
        visitor.visitClassInstantiationNodeStart(this);
        visitor.visitNodeStart(this);
        visitor.visitStartEnd(this);
        receiveTypedToChildren(visitor);
        visitor.visitStopBegin(this);
        visitor.visitNodeStop(this);
        visitor.visitClassInstantiationNodeStop(this);
        visitor.visitUnqualifiedClassInstantiationNodeStop(this, true);
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
        list.add(getUnionForType());
        return list;
    }
    
    /**
     * Returns an iterator over the children of this node.
     * @see Node#getChildIterator()
     */
    @Override
    public Iterable<? extends Node> getChildIterable()
    {
        return Arrays.asList(new Node[]{getUnionForType().getNodeValue(), getUnionForConstructorTypeArguments().getNodeValue(), getUnionForArguments().getNodeValue(), getUnionForBody().getNodeValue()});
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
        sb.append("type=");
        sb.append(this.getUnionForType().getNodeValue() == null? "null" : this.getUnionForType().getNodeValue().getClass().getSimpleName());
        sb.append(',');
        sb.append("constructorTypeArguments=");
        sb.append(this.getUnionForConstructorTypeArguments().getNodeValue() == null? "null" : this.getUnionForConstructorTypeArguments().getNodeValue().getClass().getSimpleName());
        sb.append(',');
        sb.append("arguments=");
        sb.append(this.getUnionForArguments().getNodeValue() == null? "null" : this.getUnionForArguments().getNodeValue().getClass().getSimpleName());
        sb.append(',');
        sb.append("body=");
        sb.append(this.getUnionForBody().getNodeValue() == null? "null" : this.getUnionForBody().getNodeValue().getClass().getSimpleName());
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
        return operation.executeUnqualifiedClassInstantiationNode(this, p);
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
        return operation.executeUnqualifiedClassInstantiationNode(this, p1, p2);
    }
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public UnqualifiedClassInstantiationNode deepCopy(BsjNodeFactory factory)
    {
        NodeUnion<? extends DeclaredTypeNode> typeCopy;
        switch (getUnionForType().getType())
        {
            case NORMAL:
                if (getUnionForType().getNormalNode() == null)
                {
                    typeCopy = factory.<DeclaredTypeNode>makeNormalNodeUnion(null);
                } else
                {
                    typeCopy = factory.makeNormalNodeUnion(getUnionForType().getNormalNode().deepCopy(factory));
                }
                break;
            case SPLICE:
                if (getUnionForType().getSpliceNode() == null)
                {
                    typeCopy = factory.<DeclaredTypeNode>makeSpliceNodeUnion(null);
                } else
                {
                    typeCopy = factory.makeSpliceNodeUnion(getUnionForType().getSpliceNode().deepCopy(factory));
                }
                break;
            default:
                throw new IllegalStateException("Unrecognized union component type: " + getUnionForType().getType());
        }
        NodeUnion<? extends TypeArgumentListNode> constructorTypeArgumentsCopy;
        switch (getUnionForConstructorTypeArguments().getType())
        {
            case NORMAL:
                if (getUnionForConstructorTypeArguments().getNormalNode() == null)
                {
                    constructorTypeArgumentsCopy = factory.<TypeArgumentListNode>makeNormalNodeUnion(null);
                } else
                {
                    constructorTypeArgumentsCopy = factory.makeNormalNodeUnion(getUnionForConstructorTypeArguments().getNormalNode().deepCopy(factory));
                }
                break;
            case SPLICE:
                if (getUnionForConstructorTypeArguments().getSpliceNode() == null)
                {
                    constructorTypeArgumentsCopy = factory.<TypeArgumentListNode>makeSpliceNodeUnion(null);
                } else
                {
                    constructorTypeArgumentsCopy = factory.makeSpliceNodeUnion(getUnionForConstructorTypeArguments().getSpliceNode().deepCopy(factory));
                }
                break;
            default:
                throw new IllegalStateException("Unrecognized union component type: " + getUnionForConstructorTypeArguments().getType());
        }
        NodeUnion<? extends ExpressionListNode> argumentsCopy;
        switch (getUnionForArguments().getType())
        {
            case NORMAL:
                if (getUnionForArguments().getNormalNode() == null)
                {
                    argumentsCopy = factory.<ExpressionListNode>makeNormalNodeUnion(null);
                } else
                {
                    argumentsCopy = factory.makeNormalNodeUnion(getUnionForArguments().getNormalNode().deepCopy(factory));
                }
                break;
            case SPLICE:
                if (getUnionForArguments().getSpliceNode() == null)
                {
                    argumentsCopy = factory.<ExpressionListNode>makeSpliceNodeUnion(null);
                } else
                {
                    argumentsCopy = factory.makeSpliceNodeUnion(getUnionForArguments().getSpliceNode().deepCopy(factory));
                }
                break;
            default:
                throw new IllegalStateException("Unrecognized union component type: " + getUnionForArguments().getType());
        }
        NodeUnion<? extends AnonymousClassBodyNode> bodyCopy;
        switch (getUnionForBody().getType())
        {
            case NORMAL:
                if (getUnionForBody().getNormalNode() == null)
                {
                    bodyCopy = factory.<AnonymousClassBodyNode>makeNormalNodeUnion(null);
                } else
                {
                    bodyCopy = factory.makeNormalNodeUnion(getUnionForBody().getNormalNode().deepCopy(factory));
                }
                break;
            case SPLICE:
                if (getUnionForBody().getSpliceNode() == null)
                {
                    bodyCopy = factory.<AnonymousClassBodyNode>makeSpliceNodeUnion(null);
                } else
                {
                    bodyCopy = factory.makeSpliceNodeUnion(getUnionForBody().getSpliceNode().deepCopy(factory));
                }
                break;
            default:
                throw new IllegalStateException("Unrecognized union component type: " + getUnionForBody().getType());
        }
        return factory.makeUnqualifiedClassInstantiationNodeWithUnions(
                typeCopy,
                constructorTypeArgumentsCopy,
                argumentsCopy,
                bodyCopy,
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
        
        if (before.equals(this.getUnionForType().getNodeValue()))
        {
            setType((DeclaredTypeNode)after);
            return true;
        }
        if (before.equals(this.getUnionForConstructorTypeArguments().getNodeValue()))
        {
            setConstructorTypeArguments((TypeArgumentListNode)after);
            return true;
        }
        if (before.equals(this.getUnionForArguments().getNodeValue()))
        {
            setArguments((ExpressionListNode)after);
            return true;
        }
        if (before.equals(this.getUnionForBody().getNodeValue()))
        {
            setBody((AnonymousClassBodyNode)after);
            return true;
        }
        return false;
    }
    
}
