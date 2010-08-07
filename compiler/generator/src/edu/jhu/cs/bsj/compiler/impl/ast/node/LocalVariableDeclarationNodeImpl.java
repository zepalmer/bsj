package edu.jhu.cs.bsj.compiler.impl.ast.node;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeOperation;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.BsjTypedNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.node.LocalVariableDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.TypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.VariableModifiersNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.VariableDeclaratorListNode;
import edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeManager;
import edu.jhu.cs.bsj.compiler.impl.ast.attribute.ReadWriteAttribute;

@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class LocalVariableDeclarationNodeImpl extends NodeImpl implements LocalVariableDeclarationNode
{
    /** The modifiers for this variable. */
    private VariableModifiersNode modifiers;
    
    /** The type of the declared variables. */
    private TypeNode type;
    
    /** The variable declarators for this node. */
    private VariableDeclaratorListNode declarators;
    
    private Map<LocalAttribute,ReadWriteAttribute> localAttributes = new EnumMap<LocalAttribute,ReadWriteAttribute>(LocalAttribute.class);
    private ReadWriteAttribute getAttribute(LocalAttribute attributeName)
    {
        ReadWriteAttribute attribute = localAttributes.get(attributeName);
        if (attribute == null)
        {
            attribute = new ReadWriteAttribute(LocalVariableDeclarationNodeImpl.this);
            localAttributes.put(attributeName, attribute);
        }
        return attribute;
    }
    private static enum LocalAttribute
    {
        /** Attribute identifier for the modifiers property. */
        MODIFIERS,
        /** Attribute identifier for the type property. */
        TYPE,
        /** Attribute identifier for the declarators property. */
        DECLARATORS,
    }
    
    /** General constructor. */
    public LocalVariableDeclarationNodeImpl(
            VariableModifiersNode modifiers,
            TypeNode type,
            VariableDeclaratorListNode declarators,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation,
            BsjNodeManager manager,
            boolean binary)
    {
        super(startLocation, stopLocation, manager, binary);
        setModifiers(modifiers, false);
        setType(type, false);
        setDeclarators(declarators, false);
    }
    
    /**
     * Gets the modifiers for this variable.
     * @return The modifiers for this variable.
     */
    public VariableModifiersNode getModifiers()
    {
        getAttribute(LocalAttribute.MODIFIERS).recordAccess(ReadWriteAttribute.AccessType.READ);
        return this.modifiers;
    }
    
    /**
     * Changes the modifiers for this variable.
     * @param modifiers The modifiers for this variable.
     */
    public void setModifiers(VariableModifiersNode modifiers)
    {
            setModifiers(modifiers, true);
    }
    
    private void setModifiers(VariableModifiersNode modifiers, boolean checkPermissions)
    {
        if (checkPermissions)
        {
            getManager().assertMutatable(this);
            getAttribute(LocalAttribute.MODIFIERS).recordAccess(ReadWriteAttribute.AccessType.WRITE);
        }
        setAsChild(modifiers, false);
        this.modifiers = modifiers;
        setAsChild(modifiers, true);
    }
    
    /**
     * Gets the type of the declared variables.
     * @return The type of the declared variables.
     */
    public TypeNode getType()
    {
        getAttribute(LocalAttribute.TYPE).recordAccess(ReadWriteAttribute.AccessType.READ);
        return this.type;
    }
    
    /**
     * Changes the type of the declared variables.
     * @param type The type of the declared variables.
     */
    public void setType(TypeNode type)
    {
            setType(type, true);
    }
    
    private void setType(TypeNode type, boolean checkPermissions)
    {
        if (checkPermissions)
        {
            getManager().assertMutatable(this);
            getAttribute(LocalAttribute.TYPE).recordAccess(ReadWriteAttribute.AccessType.WRITE);
        }
        setAsChild(type, false);
        this.type = type;
        setAsChild(type, true);
    }
    
    /**
     * Gets the variable declarators for this node.
     * @return The variable declarators for this node.
     */
    public VariableDeclaratorListNode getDeclarators()
    {
        getAttribute(LocalAttribute.DECLARATORS).recordAccess(ReadWriteAttribute.AccessType.READ);
        return this.declarators;
    }
    
    /**
     * Changes the variable declarators for this node.
     * @param declarators The variable declarators for this node.
     */
    public void setDeclarators(VariableDeclaratorListNode declarators)
    {
            setDeclarators(declarators, true);
    }
    
    private void setDeclarators(VariableDeclaratorListNode declarators, boolean checkPermissions)
    {
        if (checkPermissions)
        {
            getManager().assertMutatable(this);
            getAttribute(LocalAttribute.DECLARATORS).recordAccess(ReadWriteAttribute.AccessType.WRITE);
        }
        setAsChild(declarators, false);
        this.declarators = declarators;
        setAsChild(declarators, true);
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
        if (this.declarators != null)
        {
            this.declarators.receive(visitor);
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
        if (this.modifiers != null)
        {
            this.modifiers.receiveTyped(visitor);
        }
        if (this.type != null)
        {
            this.type.receiveTyped(visitor);
        }
        if (this.declarators != null)
        {
            this.declarators.receiveTyped(visitor);
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
        visitor.visitLocalVariableDeclarationNodeStart(this, true);
        visitor.visitNodeStart(this);
        visitor.visitBlockStatementNodeStart(this);
        visitor.visitVariableDeclaratorOwnerNodeStart(this);
        visitor.visitDeclarationNodeStart(this);
        visitor.visitModifiedNodeStart(this);
        visitor.visitStartEnd(this);
        receiveTypedToChildren(visitor);
        visitor.visitStopBegin(this);
        visitor.visitBlockStatementNodeStop(this);
        visitor.visitVariableDeclaratorOwnerNodeStop(this);
        visitor.visitDeclarationNodeStop(this);
        visitor.visitModifiedNodeStop(this);
        visitor.visitNodeStop(this);
        visitor.visitLocalVariableDeclarationNodeStop(this, true);
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
        list.add(getDeclarators());
        return list;
    }
    
    /**
     * Returns an iterator over the children of this node.
     * @see Node#getChildIterator()
     */
    @Override
    public Iterable<? extends Node> getChildIterable()
    {
        return Arrays.asList(new Node[]{getModifiers(), getType(), getDeclarators()});
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
        sb.append("declarators=");
        sb.append(this.getDeclarators() == null? "null" : this.getDeclarators().getClass().getSimpleName());
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
        return operation.executeLocalVariableDeclarationNode(this, p);
    }
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public LocalVariableDeclarationNode deepCopy(BsjNodeFactory factory)
    {
        return factory.makeLocalVariableDeclarationNode(
                getModifiers()==null?null:getModifiers().deepCopy(factory),
                getType()==null?null:getType().deepCopy(factory),
                getDeclarators()==null?null:getDeclarators().deepCopy(factory),
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
        if (before.equals(this.getDeclarators()) && (after instanceof VariableDeclaratorListNode))
        {
            setDeclarators((VariableDeclaratorListNode)after);
            return true;
        }
        return false;
    }
    
}
