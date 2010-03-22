package edu.jhu.cs.bsj.compiler.impl.ast.node;

import java.util.List;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeOperation;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.BsjTypedNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.node.IdentifierNode;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.TypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.VariableModifiersNode;
import edu.jhu.cs.bsj.compiler.ast.node.VariableNode;
import edu.jhu.cs.bsj.compiler.impl.ast.Attribute;
import edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeManager;

@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class VariableNodeImpl extends NodeImpl implements VariableNode
{
    /** The modifiers of this parameter. */
    private VariableModifiersNode modifiers;
    
    /** The type of the variable. */
    private TypeNode type;
    
    /** The name of the variable. */
    private IdentifierNode identifier;
    
    private static enum LocalAttribute implements edu.jhu.cs.bsj.compiler.impl.ast.Attribute
    {
        /** Attribute for the modifiers property. */
        MODIFIERS,
        /** Attribute for the type property. */
        TYPE,
        /** Attribute for the identifier property. */
        IDENTIFIER,
    }
    
    /** General constructor. */
    public VariableNodeImpl(
            VariableModifiersNode modifiers,
            TypeNode type,
            IdentifierNode identifier,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation,
            BsjNodeManager manager)
    {
        super(startLocation, stopLocation, manager);
        setModifiers(modifiers);
        setType(type);
        setIdentifier(identifier);
    }
    
    /**
     * Gets the modifiers of this parameter.
     * @return The modifiers of this parameter.
     */
    public VariableModifiersNode getModifiers()
    {
        recordAccess(LocalAttribute.MODIFIERS, Attribute.AccessType.READ);
        return this.modifiers;
    }
    
    /**
     * Changes the modifiers of this parameter.
     * @param modifiers The modifiers of this parameter.
     */
    public void setModifiers(VariableModifiersNode modifiers)
    {
        getManager().assertMutatable(this);
        recordAccess(LocalAttribute.MODIFIERS, Attribute.AccessType.STRONG_WRITE);
        if (this.modifiers instanceof NodeImpl)
        {
            ((NodeImpl)this.modifiers).setParent(null);
        }
        this.modifiers = modifiers;
        if (this.modifiers instanceof NodeImpl)
        {
            ((NodeImpl)this.modifiers).setParent(this);
        }
    }
    
    /**
     * Gets the type of the variable.
     * @return The type of the variable.
     */
    public TypeNode getType()
    {
        recordAccess(LocalAttribute.TYPE, Attribute.AccessType.READ);
        return this.type;
    }
    
    /**
     * Changes the type of the variable.
     * @param type The type of the variable.
     */
    public void setType(TypeNode type)
    {
        getManager().assertMutatable(this);
        recordAccess(LocalAttribute.TYPE, Attribute.AccessType.STRONG_WRITE);
        if (this.type instanceof NodeImpl)
        {
            ((NodeImpl)this.type).setParent(null);
        }
        this.type = type;
        if (this.type instanceof NodeImpl)
        {
            ((NodeImpl)this.type).setParent(this);
        }
    }
    
    /**
     * Gets the name of the variable.
     * @return The name of the variable.
     */
    public IdentifierNode getIdentifier()
    {
        recordAccess(LocalAttribute.IDENTIFIER, Attribute.AccessType.READ);
        return this.identifier;
    }
    
    /**
     * Changes the name of the variable.
     * @param identifier The name of the variable.
     */
    public void setIdentifier(IdentifierNode identifier)
    {
        getManager().assertMutatable(this);
        recordAccess(LocalAttribute.IDENTIFIER, Attribute.AccessType.STRONG_WRITE);
        if (this.identifier instanceof NodeImpl)
        {
            ((NodeImpl)this.identifier).setParent(null);
        }
        this.identifier = identifier;
        if (this.identifier instanceof NodeImpl)
        {
            ((NodeImpl)this.identifier).setParent(this);
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
        if (this.modifiers != null)
        {
            this.modifiers.receive(visitor);
        }
        if (this.type != null)
        {
            this.type.receive(visitor);
        }
        if (this.identifier != null)
        {
            this.identifier.receive(visitor);
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
        if (this.modifiers != null)
        {
            this.modifiers.receiveTyped(visitor);
        }
        if (this.type != null)
        {
            this.type.receiveTyped(visitor);
        }
        if (this.identifier != null)
        {
            this.identifier.receiveTyped(visitor);
        }
    }
    
    @Override
    public void receiveTyped(BsjTypedNodeVisitor visitor)
    {
        visitor.visitStartBegin(this);
        visitor.visitVariableNodeStart(this, true);
        visitor.visitNodeStart(this);
        visitor.visitStartEnd(this);
        receiveTypedToChildren(visitor);
        visitor.visitStopBegin(this);
        visitor.visitNodeStop(this);
        visitor.visitVariableNodeStop(this, true);
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
        list.add(getModifiers());
        list.add(getType());
        list.add(getIdentifier());
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
        sb.append("modifiers=");
        sb.append(this.getModifiers() == null? "null" : this.getModifiers().getClass().getSimpleName());
        sb.append(',');
        sb.append("type=");
        sb.append(this.getType() == null? "null" : this.getType().getClass().getSimpleName());
        sb.append(',');
        sb.append("identifier=");
        sb.append(this.getIdentifier() == null? "null" : this.getIdentifier().getClass().getSimpleName());
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
        return operation.executeVariableNode(this, p);
    }
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public VariableNode deepCopy(BsjNodeFactory factory)
    {
        return factory.makeVariableNode(
                getModifiers().deepCopy(factory),
                getType().deepCopy(factory),
                getIdentifier().deepCopy(factory),
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
        
        if (before.equals(this.getModifiers()) && (after instanceof VariableModifiersNode))
        {
            setModifiers((VariableModifiersNode)after);
            return true;
        }
        if (before.equals(this.getType()) && (after instanceof TypeNode))
        {
            setType((TypeNode)after);
            return true;
        }
        if (before.equals(this.getIdentifier()) && (after instanceof IdentifierNode))
        {
            setIdentifier((IdentifierNode)after);
            return true;
        }
        return false;
    }
    
}
