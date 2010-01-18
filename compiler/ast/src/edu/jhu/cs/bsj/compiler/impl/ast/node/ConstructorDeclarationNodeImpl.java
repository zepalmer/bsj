package edu.jhu.cs.bsj.compiler.impl.ast.node;

import java.util.List;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.BsjTypedNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.node.ConstructorBodyNode;
import edu.jhu.cs.bsj.compiler.ast.node.ConstructorDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.ListNode;
import edu.jhu.cs.bsj.compiler.ast.node.ModifiersNode;
import edu.jhu.cs.bsj.compiler.ast.node.TypeParameterNode;
import edu.jhu.cs.bsj.compiler.ast.node.UnparameterizedTypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.VariableNode;

@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class ConstructorDeclarationNodeImpl extends NodeImpl implements ConstructorDeclarationNode
{
    /** The body of this constructor. */
    private ConstructorBodyNode body;

    /** The modifiers for this constructor. */
    private ModifiersNode modifiers;

    /** The parameters declared by this constructor. */
    private ListNode<VariableNode> parameters;

    /** The vararg parameter declared by this method. */
    private VariableNode varargParameter;

    /** The types of exceptions thrown by this constructor. */
    private ListNode<UnparameterizedTypeNode> throwTypes;

    /** This constructor's applicable type parameters. */
    private ListNode<TypeParameterNode> typeParameters;

    /** General constructor. */
    public ConstructorDeclarationNodeImpl(
            ConstructorBodyNode body,
            ModifiersNode modifiers,
            ListNode<VariableNode> parameters,
            VariableNode varargParameter,
            ListNode<UnparameterizedTypeNode> throwTypes,
            ListNode<TypeParameterNode> typeParameters)
    {
        super();
        this.body = body;
        this.modifiers = modifiers;
        this.parameters = parameters;
        this.varargParameter = varargParameter;
        this.throwTypes = throwTypes;
        this.typeParameters = typeParameters;
    }

    /**
     * Gets the body of this constructor.
     * @return The body of this constructor.
     */
    public ConstructorBodyNode getBody()
    {
        return this.body;
    }

    /**
     * Changes the body of this constructor.
     * @param body The body of this constructor.
     */
    public void setBody(ConstructorBodyNode body)
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
     * Gets the parameters declared by this constructor.
     * @return The parameters declared by this constructor.
     */
    public ListNode<VariableNode> getParameters()
    {
        return this.parameters;
    }

    /**
     * Changes the parameters declared by this constructor.
     * @param parameters The parameters declared by this constructor.
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
     * Gets the types of exceptions thrown by this constructor.
     * @return The types of exceptions thrown by this constructor.
     */
    public ListNode<UnparameterizedTypeNode> getThrowTypes()
    {
        return this.throwTypes;
    }

    /**
     * Changes the types of exceptions thrown by this constructor.
     * @param throwTypes The types of exceptions thrown by this constructor.
     */
    public void setThrowTypes(ListNode<UnparameterizedTypeNode> throwTypes)
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
     * Gets this constructor's applicable type parameters.
     * @return This constructor's applicable type parameters.
     */
    public ListNode<TypeParameterNode> getTypeParameters()
    {
        return this.typeParameters;
    }

    /**
     * Changes this constructor's applicable type parameters.
     * @param typeParameters This constructor's applicable type parameters.
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
        this.parameters.receive(visitor);
        this.varargParameter.receive(visitor);
        this.throwTypes.receive(visitor);
        this.typeParameters.receive(visitor);
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
        this.body.receiveTyped(visitor);
        this.modifiers.receiveTyped(visitor);
        this.parameters.receiveTyped(visitor);
        this.varargParameter.receiveTyped(visitor);
        this.throwTypes.receiveTyped(visitor);
        this.typeParameters.receiveTyped(visitor);
    }

    @Override
    public void receiveTyped(BsjTypedNodeVisitor visitor)
    {
        visitor.visitStartBegin(this);
        visitor.visitConstructorDeclarationNodeStart(this, true);
        visitor.visitNodeStart(this);
        visitor.visitClassMemberNodeStart(this);
        visitor.visitStartEnd(this);
        receiveTypedToChildren(visitor);
        visitor.visitStopBegin(this);
        visitor.visitClassMemberNodeStop(this);
        visitor.visitNodeStart(this);
        visitor.visitConstructorDeclarationNodeStart(this, true);
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
        list.add(this.body);
        list.add(this.modifiers);
        list.add(this.parameters);
        list.add(this.varargParameter);
        list.add(this.throwTypes);
        list.add(this.typeParameters);
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
        sb.append("body=");
        sb.append(this.body == null? "null" : this.body.getClass().getSimpleName());
        sb.append(',');
        sb.append("modifiers=");
        sb.append(this.modifiers == null? "null" : this.modifiers.getClass().getSimpleName());
        sb.append(',');
        sb.append("parameters=");
        sb.append(this.parameters == null? "null" : this.parameters.getClass().getSimpleName());
        sb.append(',');
        sb.append("varargParameter=");
        sb.append(this.varargParameter == null? "null" : this.varargParameter.getClass().getSimpleName());
        sb.append(',');
        sb.append("throwTypes=");
        sb.append(this.throwTypes == null? "null" : this.throwTypes.getClass().getSimpleName());
        sb.append(',');
        sb.append("typeParameters=");
        sb.append(this.typeParameters == null? "null" : this.typeParameters.getClass().getSimpleName());
        sb.append(']');
        return sb.toString();
    }
}
