package edu.jhu.cs.bsj.compiler.impl.ast.node;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.node.BlockStatementNode;
import edu.jhu.cs.bsj.compiler.ast.node.ConstructorDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.DeclaredTypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.ListNode;
import edu.jhu.cs.bsj.compiler.ast.node.ModifiersNode;
import edu.jhu.cs.bsj.compiler.ast.node.TypeParameterNode;
import edu.jhu.cs.bsj.compiler.ast.node.VariableNode;

public class ConstructorDeclarationNodeImpl extends NodeImpl implements ConstructorDeclarationNode
{
    /** The body of this constructor. */
    private BlockStatementNode body;

    /** The modifiers for this constructor. */
    private ModifiersNode modifiers;

    /** The parameters declared by this constructor. */
    private ListNode<? extends VariableNode> parameters;

    /** The types of exceptions thrown by this constructor. */
    private ListNode<? extends DeclaredTypeNode> throwTypes;

    /** This constructor's applicable type parameters. */
    private ListNode<? extends TypeParameterNode> typeParameters;

    /** General constructor. */
    public ConstructorDeclarationNodeImpl(
            BlockStatementNode body,
            ModifiersNode modifiers,
            ListNode<? extends VariableNode> parameters,
            ListNode<? extends DeclaredTypeNode> throwTypes,
            ListNode<? extends TypeParameterNode> typeParameters)
    {
        super();
        this.body = body;
        this.modifiers = modifiers;
        this.parameters = parameters;
        this.throwTypes = throwTypes;
        this.typeParameters = typeParameters;
    }

    /**
     * Gets the body of this constructor.
     * @return The body of this constructor.
     */
    public BlockStatementNode getBody()
    {
        return this.body;
    }

    /**
     * Changes the body of this constructor.
     * @param body The body of this constructor.
     */
    public void setBody(BlockStatementNode body)
    {
        this.body = body;
    }

    /**
     * Gets the modifiers for this constructor.
     * @return The modifiers for this constructor.
     */
    public ModifiersNode getModifiers()
    {
        return this.modifiers;
    }

    /**
     * Changes the modifiers for this constructor.
     * @param modifiers The modifiers for this constructor.
     */
    public void setModifiers(ModifiersNode modifiers)
    {
        this.modifiers = modifiers;
    }

    /**
     * Gets the parameters declared by this constructor.
     * @return The parameters declared by this constructor.
     */
    public ListNode<? extends VariableNode> getParameters()
    {
        return this.parameters;
    }

    /**
     * Changes the parameters declared by this constructor.
     * @param parameters The parameters declared by this constructor.
     */
    public void setParameters(ListNode<? extends VariableNode> parameters)
    {
        this.parameters = parameters;
    }

    /**
     * Gets the types of exceptions thrown by this constructor.
     * @return The types of exceptions thrown by this constructor.
     */
    public ListNode<? extends DeclaredTypeNode> getThrowTypes()
    {
        return this.throwTypes;
    }

    /**
     * Changes the types of exceptions thrown by this constructor.
     * @param throwTypes The types of exceptions thrown by this constructor.
     */
    public void setThrowTypes(ListNode<? extends DeclaredTypeNode> throwTypes)
    {
        this.throwTypes = throwTypes;
    }

    /**
     * Gets this constructor's applicable type parameters.
     * @return This constructor's applicable type parameters.
     */
    public ListNode<? extends TypeParameterNode> getTypeParameters()
    {
        return this.typeParameters;
    }

    /**
     * Changes this constructor's applicable type parameters.
     * @param typeParameters This constructor's applicable type parameters.
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
