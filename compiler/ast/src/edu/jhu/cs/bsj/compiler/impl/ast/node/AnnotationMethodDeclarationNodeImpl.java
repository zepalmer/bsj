package edu.jhu.cs.bsj.compiler.impl.ast.node;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.node.AnnotationMethodDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.ExpressionNode;
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
    private ExpressionNode defaultValue;

    /** General constructor. */
    public AnnotationMethodDeclarationNodeImpl(
            ModifiersNode modifiers,
            TypeNode type,
            IdentifierNode identifier,
            ExpressionNode defaultValue)
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
        this.modifiers = modifiers;
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
        this.type = type;
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
        this.identifier = identifier;
    }

    /**
     * Gets the default value for this method.
     * @return The default value for this method.
     */
    public ExpressionNode getDefaultValue()
    {
        return this.defaultValue;
    }

    /**
     * Changes the default value for this method.
     * @param defaultValue The default value for this method.
     */
    public void setDefaultValue(ExpressionNode defaultValue)
    {
        this.defaultValue = defaultValue;
    }

    /**
     * Performs visitation for this node's children.
     * @param visitor The visitor to visit this node's children.
     */
    @Override
    protected void receiveToChildren(BsjNodeVisitor visitor)
    {
        
    }
}
