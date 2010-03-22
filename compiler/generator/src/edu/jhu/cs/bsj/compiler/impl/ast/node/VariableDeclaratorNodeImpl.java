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
import edu.jhu.cs.bsj.compiler.ast.node.VariableDeclaratorNode;
import edu.jhu.cs.bsj.compiler.ast.node.VariableInitializerNode;
import edu.jhu.cs.bsj.compiler.impl.ast.Attribute;
import edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeManager;

@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class VariableDeclaratorNodeImpl extends NodeImpl implements VariableDeclaratorNode
{
    /** The type of this variable. */
    private TypeNode type;
    
    /** The name of this variable. */
    private IdentifierNode name;
    
    /** The initializer to use. */
    private VariableInitializerNode initializer;
    
    private static enum LocalAttribute implements edu.jhu.cs.bsj.compiler.impl.ast.Attribute
    {
        /** Attribute for the type property. */
        TYPE,
        /** Attribute for the name property. */
        NAME,
        /** Attribute for the initializer property. */
        INITIALIZER,
    }
    
    /** General constructor. */
    public VariableDeclaratorNodeImpl(
            TypeNode type,
            IdentifierNode name,
            VariableInitializerNode initializer,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation,
            BsjNodeManager manager)
    {
        super(startLocation, stopLocation, manager);
        setType(type);
        setName(name);
        setInitializer(initializer);
    }
    
    /**
     * Gets the type of this variable.
     * @return The type of this variable.
     */
    public TypeNode getType()
    {
        recordAccess(LocalAttribute.TYPE, Attribute.AccessType.READ);
        return this.type;
    }
    
    /**
     * Changes the type of this variable.
     * @param type The type of this variable.
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
     * Gets the name of this variable.
     * @return The name of this variable.
     */
    public IdentifierNode getName()
    {
        recordAccess(LocalAttribute.NAME, Attribute.AccessType.READ);
        return this.name;
    }
    
    /**
     * Changes the name of this variable.
     * @param name The name of this variable.
     */
    public void setName(IdentifierNode name)
    {
        getManager().assertMutatable(this);
        recordAccess(LocalAttribute.NAME, Attribute.AccessType.STRONG_WRITE);
        if (this.name instanceof NodeImpl)
        {
            ((NodeImpl)this.name).setParent(null);
        }
        this.name = name;
        if (this.name instanceof NodeImpl)
        {
            ((NodeImpl)this.name).setParent(this);
        }
    }
    
    /**
     * Gets the initializer to use.
     * @return The initializer to use.
     */
    public VariableInitializerNode getInitializer()
    {
        recordAccess(LocalAttribute.INITIALIZER, Attribute.AccessType.READ);
        return this.initializer;
    }
    
    /**
     * Changes the initializer to use.
     * @param initializer The initializer to use.
     */
    public void setInitializer(VariableInitializerNode initializer)
    {
        getManager().assertMutatable(this);
        recordAccess(LocalAttribute.INITIALIZER, Attribute.AccessType.STRONG_WRITE);
        if (this.initializer instanceof NodeImpl)
        {
            ((NodeImpl)this.initializer).setParent(null);
        }
        this.initializer = initializer;
        if (this.initializer instanceof NodeImpl)
        {
            ((NodeImpl)this.initializer).setParent(this);
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
        if (this.type != null)
        {
            this.type.receive(visitor);
        }
        if (this.name != null)
        {
            this.name.receive(visitor);
        }
        if (this.initializer != null)
        {
            this.initializer.receive(visitor);
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
        if (this.type != null)
        {
            this.type.receiveTyped(visitor);
        }
        if (this.name != null)
        {
            this.name.receiveTyped(visitor);
        }
        if (this.initializer != null)
        {
            this.initializer.receiveTyped(visitor);
        }
    }
    
    @Override
    public void receiveTyped(BsjTypedNodeVisitor visitor)
    {
        visitor.visitStartBegin(this);
        visitor.visitVariableDeclaratorNodeStart(this, true);
        visitor.visitNodeStart(this);
        visitor.visitStatementNodeStart(this);
        visitor.visitStartEnd(this);
        receiveTypedToChildren(visitor);
        visitor.visitStopBegin(this);
        visitor.visitStatementNodeStop(this);
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
        list.add(getType());
        list.add(getName());
        list.add(getInitializer());
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
        sb.append("type=");
        sb.append(this.getType() == null? "null" : this.getType().getClass().getSimpleName());
        sb.append(',');
        sb.append("name=");
        sb.append(this.getName() == null? "null" : this.getName().getClass().getSimpleName());
        sb.append(',');
        sb.append("initializer=");
        sb.append(this.getInitializer() == null? "null" : this.getInitializer().getClass().getSimpleName());
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
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public VariableDeclaratorNode deepCopy(BsjNodeFactory factory)
    {
        return factory.makeVariableDeclaratorNode(
                getType().deepCopy(factory),
                getName().deepCopy(factory),
                getInitializer().deepCopy(factory),
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
        
        if (before.equals(this.getType()) && (after instanceof TypeNode))
        {
            setType((TypeNode)after);
            return true;
        }
        if (before.equals(this.getName()) && (after instanceof IdentifierNode))
        {
            setName((IdentifierNode)after);
            return true;
        }
        if (before.equals(this.getInitializer()) && (after instanceof VariableInitializerNode))
        {
            setInitializer((VariableInitializerNode)after);
            return true;
        }
        return false;
    }
    
}
