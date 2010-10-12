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
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.ParameterizedTypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.UnparameterizedTypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.TypeArgumentListNode;
import edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeManager;
import edu.jhu.cs.bsj.compiler.impl.ast.NormalNodeUnion;
import edu.jhu.cs.bsj.compiler.impl.ast.attribute.ReadWriteAttribute;

@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class ParameterizedTypeNodeImpl extends NodeImpl implements ParameterizedTypeNode
{
    /** The base type being parameterized. */
    private NodeUnion<? extends UnparameterizedTypeNode> baseType;
    
    /** The type arguments for this node. */
    private NodeUnion<? extends TypeArgumentListNode> typeArguments;
    
    private Map<LocalAttribute,ReadWriteAttribute> localAttributes = new EnumMap<LocalAttribute,ReadWriteAttribute>(LocalAttribute.class);
    private ReadWriteAttribute getAttribute(LocalAttribute attributeName)
    {
        ReadWriteAttribute attribute = localAttributes.get(attributeName);
        if (attribute == null)
        {
            attribute = new ReadWriteAttribute(ParameterizedTypeNodeImpl.this);
            localAttributes.put(attributeName, attribute);
        }
        return attribute;
    }
    private static enum LocalAttribute
    {
        /** Attribute identifier for the baseType property. */
        BASE_TYPE,
        /** Attribute identifier for the typeArguments property. */
        TYPE_ARGUMENTS,
    }
    
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
        setUnionForBaseType(baseType, false);
        setUnionForTypeArguments(typeArguments, false);
    }
    
    /**
     * Gets the base type being parameterized.  This property's value is assumed to be a normal node.
     * @return The base type being parameterized.
     * @throws ClassCastException If this property's value is not a normal node.
     */
    public UnparameterizedTypeNode getBaseType()
    {
        getAttribute(LocalAttribute.BASE_TYPE).recordAccess(ReadWriteAttribute.AccessType.READ);
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
        getAttribute(LocalAttribute.BASE_TYPE).recordAccess(ReadWriteAttribute.AccessType.READ);
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
            setBaseType(baseType, true);
            getManager().notifyChange(this);
    }
    
    private void setBaseType(UnparameterizedTypeNode baseType, boolean checkPermissions)
    {
        if (checkPermissions)
        {
            getManager().assertMutatable(this);
            getAttribute(LocalAttribute.BASE_TYPE).recordAccess(ReadWriteAttribute.AccessType.WRITE);
        }
        
        if (this.baseType != null)
        {
            setAsChild(this.baseType.getNodeValue(), false);
        }
        this.baseType = new NormalNodeUnion<UnparameterizedTypeNode>(baseType);
        setAsChild(baseType, true);
    }
    
    /**
     * Changes the base type being parameterized.
     * @param baseType The base type being parameterized.
     */
    public void setUnionForBaseType(NodeUnion<? extends UnparameterizedTypeNode> baseType)
    {
            setUnionForBaseType(baseType, true);
            getManager().notifyChange(this);
    }
    
    private void setUnionForBaseType(NodeUnion<? extends UnparameterizedTypeNode> baseType, boolean checkPermissions)
    {
        if (checkPermissions)
        {
            getManager().assertMutatable(this);
            getAttribute(LocalAttribute.BASE_TYPE).recordAccess(ReadWriteAttribute.AccessType.WRITE);
        }
        
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
        getAttribute(LocalAttribute.TYPE_ARGUMENTS).recordAccess(ReadWriteAttribute.AccessType.READ);
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
        getAttribute(LocalAttribute.TYPE_ARGUMENTS).recordAccess(ReadWriteAttribute.AccessType.READ);
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
            setTypeArguments(typeArguments, true);
            getManager().notifyChange(this);
    }
    
    private void setTypeArguments(TypeArgumentListNode typeArguments, boolean checkPermissions)
    {
        if (checkPermissions)
        {
            getManager().assertMutatable(this);
            getAttribute(LocalAttribute.TYPE_ARGUMENTS).recordAccess(ReadWriteAttribute.AccessType.WRITE);
        }
        
        if (this.typeArguments != null)
        {
            setAsChild(this.typeArguments.getNodeValue(), false);
        }
        this.typeArguments = new NormalNodeUnion<TypeArgumentListNode>(typeArguments);
        setAsChild(typeArguments, true);
    }
    
    /**
     * Changes the type arguments for this node.
     * @param typeArguments The type arguments for this node.
     */
    public void setUnionForTypeArguments(NodeUnion<? extends TypeArgumentListNode> typeArguments)
    {
            setUnionForTypeArguments(typeArguments, true);
            getManager().notifyChange(this);
    }
    
    private void setUnionForTypeArguments(NodeUnion<? extends TypeArgumentListNode> typeArguments, boolean checkPermissions)
    {
        if (checkPermissions)
        {
            getManager().assertMutatable(this);
            getAttribute(LocalAttribute.TYPE_ARGUMENTS).recordAccess(ReadWriteAttribute.AccessType.WRITE);
        }
        
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
        if (this.baseType.getNodeValue() != null)
        {
            this.baseType.getNodeValue().receive(visitor);
        }
        if (this.typeArguments.getNodeValue() != null)
        {
            this.typeArguments.getNodeValue().receive(visitor);
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
        if (this.baseType.getNodeValue() != null)
        {
            this.baseType.getNodeValue().receiveTyped(visitor);
        }
        if (this.typeArguments.getNodeValue() != null)
        {
            this.typeArguments.getNodeValue().receiveTyped(visitor);
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
        list.add(getBaseType());
        list.add(getTypeArguments());
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
    public <P,R> R executeOperation(BsjNodeOperation<P,R> operation, P p)
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
    public <P1,P2,R> R executeOperation(BsjNodeOperation2Arguments<P1,P2,R> operation, P1 p1, P2 p2)
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
    
}
