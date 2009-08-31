package edu.jhu.cs.bsj.compiler.impl.ast.node;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.node.BlockStatementNode;
import edu.jhu.cs.bsj.compiler.ast.node.DeclaredTypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.IdentifierNode;
import edu.jhu.cs.bsj.compiler.ast.node.ListNode;
import edu.jhu.cs.bsj.compiler.ast.node.MethodDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.ModifiersNode;
import edu.jhu.cs.bsj.compiler.ast.node.TypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.TypeParameterNode;
import edu.jhu.cs.bsj.compiler.ast.node.VariableNode;

public class MethodDeclarationNodeImpl extends NodeImpl implements MethodDeclarationNode
{
    /** The body of this method. */
    private BlockStatementNode body;

    /** The modifiers for this method. */
    private ModifiersNode modifiers;

    /** This method's name. */
    private IdentifierNode name;

    /** The parameters declared by this method. */
    private ListNode<? extends VariableNode> parameters;

    /** The type of value returned. */
    private TypeNode returnType;

    /** The types of exceptions thrown by this method. */
    private ListNode<? extends DeclaredTypeNode> throwTypes;

    /** This method's applicable type parameters. */
    private ListNode<? extends TypeParameterNode> typeParameters;

    /** General constructor. */
    public MethodDeclarationNodeImpl(
            BlockStatementNode body,
            ModifiersNode modifiers,
            IdentifierNode name,
            ListNode<? extends VariableNode> parameters,
            TypeNode returnType,
            ListNode<? extends DeclaredTypeNode> throwTypes,
            ListNode<? extends TypeParameterNode> typeParameters)
    {
        super();
        this.body = body;
        this.modifiers = modifiers;
        this.name = name;
        this.parameters = parameters;
        this.returnType = returnType;
        this.throwTypes = throwTypes;
        this.typeParameters = typeParameters;
    }

    /**
     * Gets the body of this method.
     * @return The body of this method.
     */
    public BlockStatementNode getBody()
    {
        return this.body;
    }

    /**
     * Changes the body of this method.
     * @param body The body of this method.
     */
    public void setBody(BlockStatementNode body)
    {
        this.body = body;
    }

    /**
     * Gets the modifiers for this method.
     * @return The modifiers for this method.
     */
    public ModifiersNode getModifiers()
    {
        return this.modifiers;
    }

    /**
     * Changes the modifiers for this method.
     * @param modifiers The modifiers for this method.
     */
    public void setModifiers(ModifiersNode modifiers)
    {
        this.modifiers = modifiers;
    }

    /**
     * Gets this method's name.
     * @return This method's name.
     */
    public IdentifierNode getName()
    {
        return this.name;
    }

    /**
     * Changes this method's name.
     * @param name This method's name.
     */
    public void setName(IdentifierNode name)
    {
        this.name = name;
    }

    /**
     * Gets the parameters declared by this method.
     * @return The parameters declared by this method.
     */
    public ListNode<? extends VariableNode> getParameters()
    {
        return this.parameters;
    }

    /**
     * Changes the parameters declared by this method.
     * @param parameters The parameters declared by this method.
     */
    public void setParameters(ListNode<? extends VariableNode> parameters)
    {
        this.parameters = parameters;
    }

    /**
     * Gets the type of value returned.
     * @return The type of value returned.
     */
    public TypeNode getReturnType()
    {
        return this.returnType;
    }

    /**
     * Changes the type of value returned.
     * @param returnType The type of value returned.
     */
    public void setReturnType(TypeNode returnType)
    {
        this.returnType = returnType;
    }

    /**
     * Gets the types of exceptions thrown by this method.
     * @return The types of exceptions thrown by this method.
     */
    public ListNode<? extends DeclaredTypeNode> getThrowTypes()
    {
        return this.throwTypes;
    }

    /**
     * Changes the types of exceptions thrown by this method.
     * @param throwTypes The types of exceptions thrown by this method.
     */
    public void setThrowTypes(ListNode<? extends DeclaredTypeNode> throwTypes)
    {
        this.throwTypes = throwTypes;
    }

    /**
     * Gets this method's applicable type parameters.
     * @return This method's applicable type parameters.
     */
    public ListNode<? extends TypeParameterNode> getTypeParameters()
    {
        return this.typeParameters;
    }

    /**
     * Changes this method's applicable type parameters.
     * @param typeParameters This method's applicable type parameters.
     */
    public void setTypeParameters(ListNode<? extends TypeParameterNode> typeParameters)
    {
        this.typeParameters = typeParameters;
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
