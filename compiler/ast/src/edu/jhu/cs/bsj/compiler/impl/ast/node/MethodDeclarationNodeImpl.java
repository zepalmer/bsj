package edu.jhu.cs.bsj.compiler.impl.ast.node;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.node.BlockStatementNode;
import edu.jhu.cs.bsj.compiler.ast.node.IdentifierNode;
import edu.jhu.cs.bsj.compiler.ast.node.ListNode;
import edu.jhu.cs.bsj.compiler.ast.node.MethodDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.ModifiersNode;
import edu.jhu.cs.bsj.compiler.ast.node.RawTypeNode;
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
    private IdentifierNode identifier;

    /** The parameters declared by this method. */
    private ListNode<VariableNode> parameters;

    /** The vararg parameter declared by this method. */
    private VariableNode varargParameter;

    /** The type of value returned. */
    private TypeNode returnType;

    /** The types of exceptions thrown by this method. */
    private ListNode<RawTypeNode> throwTypes;

    /** This method's applicable type parameters. */
    private ListNode<TypeParameterNode> typeParameters;

    /** General constructor. */
    public MethodDeclarationNodeImpl(
            BlockStatementNode body,
            ModifiersNode modifiers,
            IdentifierNode identifier,
            ListNode<VariableNode> parameters,
            VariableNode varargParameter,
            TypeNode returnType,
            ListNode<RawTypeNode> throwTypes,
            ListNode<TypeParameterNode> typeParameters)
    {
        super();
        this.body = body;
        this.modifiers = modifiers;
        this.identifier = identifier;
        this.parameters = parameters;
        this.varargParameter = varargParameter;
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
        if (this.body instanceof NodeImpl)
        {
            ((NodeImpl)this.body).setParent(null);
        }
        this.body = body;
        if (this.body instanceof NodeImpl)
        {
            ((NodeImpl)this.body).setParent(this);
        }
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
     * Gets this method's name.
     * @return This method's name.
     */
    public IdentifierNode getIdentifier()
    {
        return this.identifier;
    }

    /**
     * Changes this method's name.
     * @param identifier This method's name.
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
     * Gets the parameters declared by this method.
     * @return The parameters declared by this method.
     */
    public ListNode<VariableNode> getParameters()
    {
        return this.parameters;
    }

    /**
     * Changes the parameters declared by this method.
     * @param parameters The parameters declared by this method.
     */
    public void setParameters(ListNode<VariableNode> parameters)
    {
        if (this.parameters instanceof NodeImpl)
        {
            ((NodeImpl)this.parameters).setParent(null);
        }
        this.parameters = parameters;
        if (this.parameters instanceof NodeImpl)
        {
            ((NodeImpl)this.parameters).setParent(this);
        }
    }

    /**
     * Gets the vararg parameter declared by this method.
     * @return The vararg parameter declared by this method.
     */
    public VariableNode getVarargParameter()
    {
        return this.varargParameter;
    }

    /**
     * Changes the vararg parameter declared by this method.
     * @param varargParameter The vararg parameter declared by this method.
     */
    public void setVarargParameter(VariableNode varargParameter)
    {
        if (this.varargParameter instanceof NodeImpl)
        {
            ((NodeImpl)this.varargParameter).setParent(null);
        }
        this.varargParameter = varargParameter;
        if (this.varargParameter instanceof NodeImpl)
        {
            ((NodeImpl)this.varargParameter).setParent(this);
        }
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
        if (this.returnType instanceof NodeImpl)
        {
            ((NodeImpl)this.returnType).setParent(null);
        }
        this.returnType = returnType;
        if (this.returnType instanceof NodeImpl)
        {
            ((NodeImpl)this.returnType).setParent(this);
        }
    }

    /**
     * Gets the types of exceptions thrown by this method.
     * @return The types of exceptions thrown by this method.
     */
    public ListNode<RawTypeNode> getThrowTypes()
    {
        return this.throwTypes;
    }

    /**
     * Changes the types of exceptions thrown by this method.
     * @param throwTypes The types of exceptions thrown by this method.
     */
    public void setThrowTypes(ListNode<RawTypeNode> throwTypes)
    {
        if (this.throwTypes instanceof NodeImpl)
        {
            ((NodeImpl)this.throwTypes).setParent(null);
        }
        this.throwTypes = throwTypes;
        if (this.throwTypes instanceof NodeImpl)
        {
            ((NodeImpl)this.throwTypes).setParent(this);
        }
    }

    /**
     * Gets this method's applicable type parameters.
     * @return This method's applicable type parameters.
     */
    public ListNode<TypeParameterNode> getTypeParameters()
    {
        return this.typeParameters;
    }

    /**
     * Changes this method's applicable type parameters.
     * @param typeParameters This method's applicable type parameters.
     */
    public void setTypeParameters(ListNode<TypeParameterNode> typeParameters)
    {
        if (this.typeParameters instanceof NodeImpl)
        {
            ((NodeImpl)this.typeParameters).setParent(null);
        }
        this.typeParameters = typeParameters;
        if (this.typeParameters instanceof NodeImpl)
        {
            ((NodeImpl)this.typeParameters).setParent(this);
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
        this.body.receive(visitor);
        this.modifiers.receive(visitor);
        this.identifier.receive(visitor);
        this.parameters.receive(visitor);
        this.varargParameter.receive(visitor);
        this.returnType.receive(visitor);
        this.throwTypes.receive(visitor);
        this.typeParameters.receive(visitor);
    }
}
