package edu.jhu.cs.bsj.compiler.impl.ast.node;

import java.util.List;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.node.AnnotationMethodDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.AnnotationValueNode;
import edu.jhu.cs.bsj.compiler.ast.node.IdentifierNode;
import edu.jhu.cs.bsj.compiler.ast.node.ModifiersNode;
import edu.jhu.cs.bsj.compiler.ast.node.TypeNode;

public class AnnotationMethodDeclarationNodeImpl extends NodeImpl implements AnnotationMethodDeclarationNode
{
    /** The modifiers for this annotation method. */
    private ModifiersNode modifiers;

    /** The return type of this annotation method. */
    private TypeNode type;

    /** This annotation method's name. */
    private IdentifierNode identifier;

    /** The default value for this method. */
    private AnnotationValueNode defaultValue;

    /** General constructor. */
    public AnnotationMethodDeclarationNodeImpl(
            ModifiersNode modifiers,
            TypeNode type,
            IdentifierNode identifier,
            AnnotationValueNode defaultValue)
    {
        super();
        this.modifiers = modifiers;
        this.type = type;
        this.identifier = identifier;
        this.defaultValue = defaultValue;
    }

    /**
     * Gets the modifiers for this annotation method.
     * @return The modifiers for this annotation method.
     */
    public ModifiersNode getModifiers()
    {
        return this.modifiers;
    }

    /**
     * Changes the modifiers for this annotation method.
     * @param modifiers The modifiers for this annotation method.
     */
    public void setModifiers(ModifiersNode modifiers)
    {
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
     * Gets the return type of this annotation method.
     * @return The return type of this annotation method.
     */
    public TypeNode getType()
    {
        return this.type;
    }

    /**
     * Changes the return type of this annotation method.
     * @param type The return type of this annotation method.
     */
    public void setType(TypeNode type)
    {
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
     * Gets this annotation method's name.
     * @return This annotation method's name.
     */
    public IdentifierNode getIdentifier()
    {
        return this.identifier;
    }

    /**
     * Changes this annotation method's name.
     * @param identifier This annotation method's name.
     */
    public void setIdentifier(IdentifierNode identifier)
    {
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
     * Gets the default value for this method.
     * @return The default value for this method.
     */
    public AnnotationValueNode getDefaultValue()
    {
        return this.defaultValue;
    }

    /**
     * Changes the default value for this method.
     * @param defaultValue The default value for this method.
     */
    public void setDefaultValue(AnnotationValueNode defaultValue)
    {
        if (this.defaultValue instanceof NodeImpl)
        {
            ((NodeImpl)this.defaultValue).setParent(null);
        }
        this.defaultValue = defaultValue;
        if (this.defaultValue instanceof NodeImpl)
        {
            ((NodeImpl)this.defaultValue).setParent(this);
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
        this.modifiers.receive(visitor);
        this.type.receive(visitor);
        this.identifier.receive(visitor);
        this.defaultValue.receive(visitor);
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
        list.add(this.modifiers);
        list.add(this.type);
        list.add(this.identifier);
        list.add(this.defaultValue);
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
        sb.append(this.modifiers == null? "null" : this.modifiers.getClass().getSimpleName());
        sb.append(',');
        sb.append("type=");
        sb.append(this.type == null? "null" : this.type.getClass().getSimpleName());
        sb.append(',');
        sb.append("identifier=");
        sb.append(this.identifier == null? "null" : this.identifier.getClass().getSimpleName());
        sb.append(',');
        sb.append("defaultValue=");
        sb.append(this.defaultValue == null? "null" : this.defaultValue.getClass().getSimpleName());
        sb.append('[');
        return sb.toString();
    }
}
