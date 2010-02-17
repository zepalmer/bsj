package edu.jhu.cs.bsj.compiler.impl.ast.node;

import java.util.List;

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

@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class ParameterizedTypeNodeImpl extends NodeImpl implements ParameterizedTypeNode
{
    /** The base type being parameterized. */
    private UnparameterizedTypeNode baseType;

    /** The type arguments for this node. */
    private TypeArgumentListNode typeArguments;

    /** General constructor. */
    public ParameterizedTypeNodeImpl(
            UnparameterizedTypeNode baseType,
            TypeArgumentListNode typeArguments,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        super(startLocation, stopLocation);
        setBaseType(baseType);
        setTypeArguments(typeArguments);
    }

    /**
     * Gets the base type being parameterized.
     * @return The base type being parameterized.
     */
    public UnparameterizedTypeNode getBaseType()
    {
        return this.baseType;
    }

    /**
     * Changes the base type being parameterized.
     * @param baseType The base type being parameterized.
     */
    public void setBaseType(UnparameterizedTypeNode baseType)
    {
        if (this.baseType instanceof NodeImpl)
        {
            ((NodeImpl)this.baseType).setParent(null);
        }
        this.baseType = baseType;
        if (this.baseType instanceof NodeImpl)
        {
            ((NodeImpl)this.baseType).setParent(this);
        }
    }

    /**
     * Gets the type arguments for this node.
     * @return The type arguments for this node.
     */
    public TypeArgumentListNode getTypeArguments()
    {
        return this.typeArguments;
    }

    /**
     * Changes the type arguments for this node.
     * @param typeArguments The type arguments for this node.
     */
    public void setTypeArguments(TypeArgumentListNode typeArguments)
    {
        if (this.typeArguments instanceof NodeImpl)
        {
            ((NodeImpl)this.typeArguments).setParent(null);
        }
        this.typeArguments = typeArguments;
        if (this.typeArguments instanceof NodeImpl)
        {
            ((NodeImpl)this.typeArguments).setParent(this);
        }
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
                getBaseType().deepCopy(factory),
                getTypeArguments().deepCopy(factory),
                getStartLocation() == null ? null : (BsjSourceLocation)(getStartLocation().clone()),
                getStopLocation() == null ? null : (BsjSourceLocation)(getStopLocation().clone()));
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
