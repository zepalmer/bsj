package edu.jhu.cs.bsj.compiler.impl.ast.node;

import java.util.Arrays;
import java.util.Collection;
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
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.ParameterizedTypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.TypeNameBindingNode;
import edu.jhu.cs.bsj.compiler.ast.node.UnparameterizedTypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.TypeArgumentListNode;
import edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeManager;
import edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactory;
import edu.jhu.cs.bsj.compiler.impl.ast.NormalNodeUnion;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.property.ParameterizedTypeNodeSetBaseTypePropertyEditScriptElementImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.property.ParameterizedTypeNodeSetTypeArgumentsPropertyEditScriptElementImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.properties.ParameterizedTypeNodeProperties;

@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class ParameterizedTypeNodeImpl extends NodeImpl implements ParameterizedTypeNode
{
    /** The base type being parameterized. */
    private NodeUnion<? extends UnparameterizedTypeNode> baseType;
    
    /** The type arguments for this node. */
    private NodeUnion<? extends TypeArgumentListNode> typeArguments;
    
    /**
     * A set of those properties which have been populated from the backing node.
     * This field is <code>null</code> if <tt>backingNode</tt> is <code>null</code>.
     */
    private Set<ParameterizedTypeNodeProperties> populatedProperties;
    
    /** General constructor. */
    public ParameterizedTypeNodeImpl(
            NodeUnion<? extends UnparameterizedTypeNode> baseType,
            NodeUnion<? extends TypeArgumentListNode> typeArguments,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation,
            BsjNodeManager manager,
            boolean binary)
    {
        super(startLocation, stopLocation, manager, binary);
        this.populatedProperties = null;
        doSetBaseType(baseType);
        doSetTypeArguments(typeArguments);
    }
    
    /** Proxy constructor. */
    public ParameterizedTypeNodeImpl(BsjNodeManager manager, BsjNodeProxyFactory proxyFactory, ParameterizedTypeNode backingNode)
    {
        super(manager, proxyFactory, backingNode);
        this.populatedProperties = EnumSet.noneOf(ParameterizedTypeNodeProperties.class);
    }
    
    /** Retrieves this node's backing node (if one exists). */
    protected ParameterizedTypeNode getBackingNode()
    {
        return (ParameterizedTypeNode)super.getBackingNode();
    }
    
    /**
     * Ensures that the baseType value has been populated from proxy.
     * If this node is not backed by a proxy or if the value has already been
     * populated, this method does nothing.
     */
    private void checkBaseTypeWrapped()
    {
        if (this.populatedProperties == null || this.populatedProperties.contains(
                ParameterizedTypeNodeProperties.BASE_TYPE))
            return;
        this.populatedProperties.add(ParameterizedTypeNodeProperties.BASE_TYPE);
        NodeUnion<? extends UnparameterizedTypeNode> union = this.getBackingNode().getUnionForBaseType();
        switch (union.getType())
        {
            case NORMAL:
                union = this.getProxyFactory().makeNormalNodeUnion(
                        this.getProxyFactory().makeUnparameterizedTypeNode(union.getNormalNode()));
                break;
            case SPLICE:
                union = this.getProxyFactory().makeSpliceNodeUnion(
                        this.getProxyFactory().makeSpliceNode(union.getSpliceNode()));
                break;
            default:
                throw new IllegalStateException("Unrecognized union type: " + union.getType());
        }
        this.baseType = union;
    }
    
    /**
     * Ensures that the typeArguments value has been populated from proxy.
     * If this node is not backed by a proxy or if the value has already been
     * populated, this method does nothing.
     */
    private void checkTypeArgumentsWrapped()
    {
        if (this.populatedProperties == null || this.populatedProperties.contains(
                ParameterizedTypeNodeProperties.TYPE_ARGUMENTS))
            return;
        this.populatedProperties.add(ParameterizedTypeNodeProperties.TYPE_ARGUMENTS);
        NodeUnion<? extends TypeArgumentListNode> union = this.getBackingNode().getUnionForTypeArguments();
        switch (union.getType())
        {
            case NORMAL:
                union = this.getProxyFactory().makeNormalNodeUnion(
                        this.getProxyFactory().makeTypeArgumentListNode(union.getNormalNode()));
                break;
            case SPLICE:
                union = this.getProxyFactory().makeSpliceNodeUnion(
                        this.getProxyFactory().makeSpliceNode(union.getSpliceNode()));
                break;
            default:
                throw new IllegalStateException("Unrecognized union type: " + union.getType());
        }
        this.typeArguments = union;
    }
    
    /**
     * Gets the base type being parameterized.  This property's value is assumed to be a normal node.
     * @return The base type being parameterized.
     * @throws ClassCastException If this property's value is not a normal node.
     */
    public UnparameterizedTypeNode getBaseType()
    {
        checkBaseTypeWrapped();
        if (this.baseType == null)
        {
            return null;
        } else
        {
            return this.baseType.getNormalNode();
        }
    }
    
    /**
     * Gets the base type being parameterized.
     * @return The base type being parameterized.
     */
    public NodeUnion<? extends UnparameterizedTypeNode> getUnionForBaseType()
    {
        checkBaseTypeWrapped();
        if (this.baseType == null)
        {
            this.baseType = new NormalNodeUnion<UnparameterizedTypeNode>(null);
        }
        return this.baseType;
    }
    
    /**
     * Changes the base type being parameterized.
     * @param baseType The base type being parameterized.
     */
    public void setBaseType(UnparameterizedTypeNode baseType)
    {
        checkBaseTypeWrapped();
        this.setUnionForBaseType(new NormalNodeUnion<UnparameterizedTypeNode>(baseType));
    }
    
    /**
     * Changes the base type being parameterized.
     * @param baseType The base type being parameterized.
     */
    public void setUnionForBaseType(NodeUnion<? extends UnparameterizedTypeNode> baseType)
    {
        checkBaseTypeWrapped();
        this.getManager().assertMutatable(this);
        this.doSetBaseType(baseType);
        if (this.getManager().isRecordingEdits())
            super.recordEdit(new ParameterizedTypeNodeSetBaseTypePropertyEditScriptElementImpl(this.getManager().getCurrentMetaprogramId(), this.getUid(), baseType.getNodeValue() == null ? null : baseType.getNodeValue().getUid()));
    }
    
    private void doSetBaseType(NodeUnion<? extends UnparameterizedTypeNode> baseType)
    {
        if (baseType == null)
        {
            baseType = new NormalNodeUnion<UnparameterizedTypeNode>(null);
        }
        if (this.baseType != null)
        {
            setAsChild(this.baseType.getNodeValue(), false);
        }
        this.baseType = baseType;
        setAsChild(baseType.getNodeValue(), true);
    }
    
    /**
     * Gets the type arguments for this node.  This property's value is assumed to be a normal node.
     * @return The type arguments for this node.
     * @throws ClassCastException If this property's value is not a normal node.
     */
    public TypeArgumentListNode getTypeArguments()
    {
        checkTypeArgumentsWrapped();
        if (this.typeArguments == null)
        {
            return null;
        } else
        {
            return this.typeArguments.getNormalNode();
        }
    }
    
    /**
     * Gets the type arguments for this node.
     * @return The type arguments for this node.
     */
    public NodeUnion<? extends TypeArgumentListNode> getUnionForTypeArguments()
    {
        checkTypeArgumentsWrapped();
        if (this.typeArguments == null)
        {
            this.typeArguments = new NormalNodeUnion<TypeArgumentListNode>(null);
        }
        return this.typeArguments;
    }
    
    /**
     * Changes the type arguments for this node.
     * @param typeArguments The type arguments for this node.
     */
    public void setTypeArguments(TypeArgumentListNode typeArguments)
    {
        checkTypeArgumentsWrapped();
        this.setUnionForTypeArguments(new NormalNodeUnion<TypeArgumentListNode>(typeArguments));
    }
    
    /**
     * Changes the type arguments for this node.
     * @param typeArguments The type arguments for this node.
     */
    public void setUnionForTypeArguments(NodeUnion<? extends TypeArgumentListNode> typeArguments)
    {
        checkTypeArgumentsWrapped();
        this.getManager().assertMutatable(this);
        this.doSetTypeArguments(typeArguments);
        if (this.getManager().isRecordingEdits())
            super.recordEdit(new ParameterizedTypeNodeSetTypeArgumentsPropertyEditScriptElementImpl(this.getManager().getCurrentMetaprogramId(), this.getUid(), typeArguments.getNodeValue() == null ? null : typeArguments.getNodeValue().getUid()));
    }
    
    private void doSetTypeArguments(NodeUnion<? extends TypeArgumentListNode> typeArguments)
    {
        if (typeArguments == null)
        {
            typeArguments = new NormalNodeUnion<TypeArgumentListNode>(null);
        }
        if (this.typeArguments != null)
        {
            setAsChild(this.typeArguments.getNodeValue(), false);
        }
        this.typeArguments = typeArguments;
        setAsChild(typeArguments.getNodeValue(), true);
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
        if (this.getUnionForBaseType().getNodeValue() != null)
        {
            this.getUnionForBaseType().getNodeValue().receive(visitor);
        }
        if (this.getUnionForTypeArguments().getNodeValue() != null)
        {
            this.getUnionForTypeArguments().getNodeValue().receive(visitor);
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
        if (this.getUnionForBaseType().getNodeValue() != null)
        {
            this.getUnionForBaseType().getNodeValue().receiveTyped(visitor);
        }
        if (this.getUnionForTypeArguments().getNodeValue() != null)
        {
            this.getUnionForTypeArguments().getNodeValue().receiveTyped(visitor);
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
        visitor.visitParameterizedTypeNodeStart(this, true);
        visitor.visitNodeStart(this);
        visitor.visitDeclaredTypeNodeStart(this);
        visitor.visitStartEnd(this);
        receiveTypedToChildren(visitor);
        visitor.visitStopBegin(this);
        visitor.visitDeclaredTypeNodeStop(this);
        visitor.visitNodeStop(this);
        visitor.visitParameterizedTypeNodeStop(this, true);
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
        list.add(getUnionForBaseType());
        list.add(getUnionForTypeArguments());
        return list;
    }
    
    /**
     * Returns an iterator over the children of this node.
     * @see Node#getChildIterator()
     */
    @Override
    public Iterable<? extends Node> getChildIterable()
    {
        return Arrays.asList(new Node[]{getUnionForBaseType().getNodeValue(), getUnionForTypeArguments().getNodeValue()});
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
        sb.append("baseType=");
        sb.append(this.getUnionForBaseType().getNodeValue() == null? "null" : this.getUnionForBaseType().getNodeValue().getClass().getSimpleName());
        sb.append(',');
        sb.append("typeArguments=");
        sb.append(this.getUnionForTypeArguments().getNodeValue() == null? "null" : this.getUnionForTypeArguments().getNodeValue().getClass().getSimpleName());
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
        return operation.executeParameterizedTypeNode(this, p);
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
        return operation.executeParameterizedTypeNode(this, p1, p2);
    }
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public ParameterizedTypeNode deepCopy(BsjNodeFactory factory)
    {
        NodeUnion<? extends UnparameterizedTypeNode> baseTypeCopy;
        switch (getUnionForBaseType().getType())
        {
            case NORMAL:
                if (getUnionForBaseType().getNormalNode() == null)
                {
                    baseTypeCopy = factory.<UnparameterizedTypeNode>makeNormalNodeUnion(null);
                } else
                {
                    baseTypeCopy = factory.makeNormalNodeUnion(getUnionForBaseType().getNormalNode().deepCopy(factory));
                }
                break;
            case SPLICE:
                if (getUnionForBaseType().getSpliceNode() == null)
                {
                    baseTypeCopy = factory.<UnparameterizedTypeNode>makeSpliceNodeUnion(null);
                } else
                {
                    baseTypeCopy = factory.makeSpliceNodeUnion(getUnionForBaseType().getSpliceNode().deepCopy(factory));
                }
                break;
            default:
                throw new IllegalStateException("Unrecognized union component type: " + getUnionForBaseType().getType());
        }
        NodeUnion<? extends TypeArgumentListNode> typeArgumentsCopy;
        switch (getUnionForTypeArguments().getType())
        {
            case NORMAL:
                if (getUnionForTypeArguments().getNormalNode() == null)
                {
                    typeArgumentsCopy = factory.<TypeArgumentListNode>makeNormalNodeUnion(null);
                } else
                {
                    typeArgumentsCopy = factory.makeNormalNodeUnion(getUnionForTypeArguments().getNormalNode().deepCopy(factory));
                }
                break;
            case SPLICE:
                if (getUnionForTypeArguments().getSpliceNode() == null)
                {
                    typeArgumentsCopy = factory.<TypeArgumentListNode>makeSpliceNodeUnion(null);
                } else
                {
                    typeArgumentsCopy = factory.makeSpliceNodeUnion(getUnionForTypeArguments().getSpliceNode().deepCopy(factory));
                }
                break;
            default:
                throw new IllegalStateException("Unrecognized union component type: " + getUnionForTypeArguments().getType());
        }
        return factory.makeParameterizedTypeNodeWithUnions(
                baseTypeCopy,
                typeArgumentsCopy,
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
        
        if (before.equals(this.getUnionForBaseType().getNodeValue()))
        {
            setBaseType((UnparameterizedTypeNode)after);
            return true;
        }
        if (before.equals(this.getUnionForTypeArguments().getNodeValue()))
        {
            setTypeArguments((TypeArgumentListNode)after);
            return true;
        }
        return false;
    }
    
    @Override
    public Collection<? extends TypeNameBindingNode> getDeclarations()
    {
        return getBaseType().getDeclarations();
    }
}
