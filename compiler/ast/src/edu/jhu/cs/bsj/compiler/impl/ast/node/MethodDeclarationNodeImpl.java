package edu.jhu.cs.bsj.compiler.impl.ast.node;

import java.util.List;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.BsjTypedNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.node.BlockStatementNode;
import edu.jhu.cs.bsj.compiler.ast.node.IdentifierNode;
import edu.jhu.cs.bsj.compiler.ast.node.JavadocNode;
import edu.jhu.cs.bsj.compiler.ast.node.ListNode;
import edu.jhu.cs.bsj.compiler.ast.node.MethodDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.MethodModifiersNode;
import edu.jhu.cs.bsj.compiler.ast.node.TypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.TypeParameterNode;
import edu.jhu.cs.bsj.compiler.ast.node.UnparameterizedTypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.VariableNode;

@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class MethodDeclarationNodeImpl extends NodeImpl implements MethodDeclarationNode
{
    /** The body of this method. */
    private BlockStatementNode body;

    /** The modifiers for this method. */
    private MethodModifiersNode modifiers;

    /** This method's name. */
    private IdentifierNode identifier;

    /** The parameters declared by this method. */
    private ListNode<VariableNode> parameters;

    /** The vararg parameter declared by this method. */
    private VariableNode varargParameter;

    /** The type of value returned. */
    private TypeNode returnType;

    /** The types of exceptions thrown by this method. */
    private ListNode<UnparameterizedTypeNode> throwTypes;

    /** This method's applicable type parameters. */
    private ListNode<TypeParameterNode> typeParameters;

    /** The associated javadoc comment for this node. */
    private JavadocNode javadoc;

    /** General constructor. */
    public MethodDeclarationNodeImpl(
            BlockStatementNode body,
            MethodModifiersNode modifiers,
            IdentifierNode identifier,
            ListNode<VariableNode> parameters,
            VariableNode varargParameter,
            TypeNode returnType,
            ListNode<UnparameterizedTypeNode> throwTypes,
            ListNode<TypeParameterNode> typeParameters,
            JavadocNode javadoc)
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
        this.javadoc = javadoc;
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
    public MethodModifiersNode getModifiers()
    {
        return this.modifiers;
    }

    /**
     * Changes the modifiers for this method.
     * @param modifiers The modifiers for this method.
     */
    public void setModifiers(MethodModifiersNode modifiers)
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
    public ListNode<UnparameterizedTypeNode> getThrowTypes()
    {
        return this.throwTypes;
    }

    /**
     * Changes the types of exceptions thrown by this method.
     * @param throwTypes The types of exceptions thrown by this method.
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
     * Gets the associated javadoc comment for this node.
     * @return The associated javadoc comment for this node.
     */
    public JavadocNode getJavadoc()
    {
        return this.javadoc;
    }

    /**
     * Changes the associated javadoc comment for this node.
     * @param javadoc The associated javadoc comment for this node.
     */
    public void setJavadoc(JavadocNode javadoc)
    {
        if (this.javadoc instanceof NodeImpl)
        {
            ((NodeImpl)this.javadoc).setParent(null);
        }
        this.javadoc = javadoc;
        if (this.javadoc instanceof NodeImpl)
        {
            ((NodeImpl)this.javadoc).setParent(this);
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
        this.javadoc.receive(visitor);
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
        this.identifier.receiveTyped(visitor);
        this.parameters.receiveTyped(visitor);
        this.varargParameter.receiveTyped(visitor);
        this.returnType.receiveTyped(visitor);
        this.throwTypes.receiveTyped(visitor);
        this.typeParameters.receiveTyped(visitor);
        this.javadoc.receiveTyped(visitor);
    }

    @Override
    public void receiveTyped(BsjTypedNodeVisitor visitor)
    {
        visitor.visitStartBegin(this);
        visitor.visitMethodDeclarationNodeStart(this, true);
        visitor.visitNodeStart(this);
        visitor.visitClassMemberNodeStart(this);
        visitor.visitInterfaceMemberNodeStart(this);
        visitor.visitAnonymousClassMemberNodeStart(this);
        visitor.visitStartEnd(this);
        receiveTypedToChildren(visitor);
        visitor.visitStopBegin(this);
        visitor.visitClassMemberNodeStop(this);
        visitor.visitInterfaceMemberNodeStop(this);
        visitor.visitAnonymousClassMemberNodeStop(this);
        visitor.visitNodeStart(this);
        visitor.visitMethodDeclarationNodeStart(this, true);
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
        list.add(getBody());
        list.add(getModifiers());
        list.add(getIdentifier());
        list.add(getParameters());
        list.add(getVarargParameter());
        list.add(getReturnType());
        list.add(getThrowTypes());
        list.add(getTypeParameters());
        list.add(getJavadoc());
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
        sb.append("identifier=");
        sb.append(this.identifier == null? "null" : this.identifier.getClass().getSimpleName());
        sb.append(',');
        sb.append("parameters=");
        sb.append(this.parameters == null? "null" : this.parameters.getClass().getSimpleName());
        sb.append(',');
        sb.append("varargParameter=");
        sb.append(this.varargParameter == null? "null" : this.varargParameter.getClass().getSimpleName());
        sb.append(',');
        sb.append("returnType=");
        sb.append(this.returnType == null? "null" : this.returnType.getClass().getSimpleName());
        sb.append(',');
        sb.append("throwTypes=");
        sb.append(this.throwTypes == null? "null" : this.throwTypes.getClass().getSimpleName());
        sb.append(',');
        sb.append("typeParameters=");
        sb.append(this.typeParameters == null? "null" : this.typeParameters.getClass().getSimpleName());
        sb.append(',');
        sb.append("javadoc=");
        sb.append(this.javadoc == null? "null" : this.javadoc.getClass().getSimpleName());
        sb.append(']');
        return sb.toString();
    }
}
