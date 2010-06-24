package edu.jhu.cs.bsj.compiler.impl.ast.node;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeOperation;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.BsjTypedNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.ParameterizedTypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.TypeArgumentListNode;
import edu.jhu.cs.bsj.compiler.ast.node.UnparameterizedTypeNode;
import edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeManager;
import edu.jhu.cs.bsj.compiler.impl.ast.attribute.ReadWriteAttribute;

@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class ParameterizedTypeNodeImpl extends NodeImpl implements ParameterizedTypeNode
{
    /** The base type being parameterized. */
    private UnparameterizedTypeNode baseType;
    
    /** The type arguments for this node. */
    private TypeArgumentListNode typeArguments;
    
    private Map<LocalAttribute,ReadWriteAttribute> localAttributes = new HashMap<LocalAttribute,ReadWriteAttribute>();
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
            UnparameterizedTypeNode baseType,
            TypeArgumentListNode typeArguments,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation,
            BsjNodeManager manager,
            boolean binary)
    {
        super(startLocation, stopLocation, manager, binary);
        setBaseType(baseType, false);
        setTypeArguments(typeArguments, false);
    }
    
    /**
     * Gets the base type being parameterized.
     * @return The base type being parameterized.
     */
    public UnparameterizedTypeNode getBaseType()
    {
        getAttribute(LocalAttribute.BASE_TYPE).recordAccess(ReadWriteAttribute.AccessType.READ);
        return this.baseType;
    }
    
    /**
     * Changes the base type being parameterized.
     * @param baseType The base type being parameterized.
     */
    public void setBaseType(UnparameterizedTypeNode baseType)
    {
            setBaseType(baseType, true);
    }
    
    private void setBaseType(UnparameterizedTypeNode baseType, boolean checkPermissions)
    {
        if (checkPermissions)
        {
            getManager().assertMutatable(this);
            getAttribute(LocalAttribute.BASE_TYPE).recordAccess(ReadWriteAttribute.AccessType.WRITE);
        }
        setAsChild(baseType, false);
        this.baseType = baseType;
        setAsChild(baseType, true);
    }
    
    /**
     * Gets the type arguments for this node.
     * @return The type arguments for this node.
     */
    public TypeArgumentListNode getTypeArguments()
    {
        getAttribute(LocalAttribute.TYPE_ARGUMENTS).recordAccess(ReadWriteAttribute.AccessType.READ);
        return this.typeArguments;
    }
    
    /**
     * Changes the type arguments for this node.
     * @param typeArguments The type arguments for this node.
     */
    public void setTypeArguments(TypeArgumentListNode typeArguments)
    {
            setTypeArguments(typeArguments, true);
    }
    
    private void setTypeArguments(TypeArgumentListNode typeArguments, boolean checkPermissions)
    {
        if (checkPermissions)
        {
            getManager().assertMutatable(this);
            getAttribute(LocalAttribute.TYPE_ARGUMENTS).recordAccess(ReadWriteAttribute.AccessType.WRITE);
        }
        setAsChild(typeArguments, false);
        this.typeArguments = typeArguments;
        setAsChild(typeArguments, true);
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
        if (this.baseType != null)
        {
            this.baseType.receive(visitor);
        }
        if (this.typeArguments != null)
        {
            this.typeArguments.receive(visitor);
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
        if (this.baseType != null)
        {
            this.baseType.receiveTyped(visitor);
        }
        if (this.typeArguments != null)
        {
            this.typeArguments.receiveTyped(visitor);
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
     * Obtains a human-readable description of this node.
     * @return A human-readable description of this node.
     */
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getClass().getSimpleName());
        sb.append('[');
        sb.append("baseType=");
        sb.append(this.getBaseType() == null? "null" : this.getBaseType().getClass().getSimpleName());
        sb.append(',');
        sb.append("typeArguments=");
        sb.append(this.getTypeArguments() == null? "null" : this.getTypeArguments().getClass().getSimpleName());
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
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public ParameterizedTypeNode deepCopy(BsjNodeFactory factory)
    {
        return factory.makeParameterizedTypeNode(
                getBaseType()==null?null:getBaseType().deepCopy(factory),
                getTypeArguments()==null?null:getTypeArguments().deepCopy(factory),
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
        
        if (before.equals(this.getBaseType()) && (after instanceof UnparameterizedTypeNode))
        {
            setBaseType((UnparameterizedTypeNode)after);
            return true;
        }
        if (before.equals(this.getTypeArguments()) && (after instanceof TypeArgumentListNode))
        {
            setTypeArguments((TypeArgumentListNode)after);
            return true;
        }
        return false;
    }
    
}
