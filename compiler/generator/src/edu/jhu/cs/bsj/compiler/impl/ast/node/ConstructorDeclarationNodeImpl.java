package edu.jhu.cs.bsj.compiler.impl.ast.node;

import java.util.List;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeOperation;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.BsjTypedNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.node.ConstructorBodyNode;
import edu.jhu.cs.bsj.compiler.ast.node.ConstructorDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.ConstructorModifiersNode;
import edu.jhu.cs.bsj.compiler.ast.node.IdentifierNode;
import edu.jhu.cs.bsj.compiler.ast.node.JavadocNode;
import edu.jhu.cs.bsj.compiler.ast.node.ListNode;
import edu.jhu.cs.bsj.compiler.ast.node.TypeParameterNode;
import edu.jhu.cs.bsj.compiler.ast.node.UnparameterizedTypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.VariableNode;

@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class ConstructorDeclarationNodeImpl extends NodeImpl implements ConstructorDeclarationNode
{
    /** The identifier for the name of this constructor. */
    private IdentifierNode identifier;

    /** The body of this constructor. */
    private ConstructorBodyNode body;

    /** The modifiers for this constructor. */
    private ConstructorModifiersNode modifiers;

    /** The parameters declared by this constructor. */
    private ListNode<VariableNode> parameters;

    /** The vararg parameter declared by this method. */
    private VariableNode varargParameter;

    /** The types of exceptions thrown by this constructor. */
    private ListNode<UnparameterizedTypeNode> throwTypes;

    /** This constructor's applicable type parameters. */
    private ListNode<TypeParameterNode> typeParameters;

    /** The associated javadoc comment for this node. */
    private JavadocNode javadoc;

    /** General constructor. */
    public ConstructorDeclarationNodeImpl(
            IdentifierNode identifier,
            ConstructorBodyNode body,
            ConstructorModifiersNode modifiers,
            ListNode<VariableNode> parameters,
            VariableNode varargParameter,
            ListNode<UnparameterizedTypeNode> throwTypes,
            ListNode<TypeParameterNode> typeParameters,
            JavadocNode javadoc,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        super(startLocation, stopLocation);
        this.identifier = identifier;
        this.body = body;
        this.modifiers = modifiers;
        this.parameters = parameters;
        this.varargParameter = varargParameter;
        this.throwTypes = throwTypes;
        this.typeParameters = typeParameters;
        this.javadoc = javadoc;
    }

    /**
     * Gets the identifier for the name of this constructor.
     * @return The identifier for the name of this constructor.
     */
    public IdentifierNode getIdentifier()
    {
        return this.identifier;
    }

    /**
     * Changes the identifier for the name of this constructor.
     * @param identifier The identifier for the name of this constructor.
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
    public ConstructorModifiersNode getModifiers()
    {
        return this.modifiers;
    }

    /**
     * Changes the modifiers for this constructor.
     * @param modifiers The modifiers for this constructor.
     */
    public void setModifiers(ConstructorModifiersNode modifiers)
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
        if (this.identifier != null)
        {
            this.identifier.receive(visitor);
        }
        if (this.body != null)
        {
            this.body.receive(visitor);
        }
        if (this.modifiers != null)
        {
            this.modifiers.receive(visitor);
        }
        if (this.parameters != null)
        {
            this.parameters.receive(visitor);
        }
        if (this.varargParameter != null)
        {
            this.varargParameter.receive(visitor);
        }
        if (this.throwTypes != null)
        {
            this.throwTypes.receive(visitor);
        }
        if (this.typeParameters != null)
        {
            this.typeParameters.receive(visitor);
        }
        if (this.javadoc != null)
        {
            this.javadoc.receive(visitor);
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
        if (this.identifier != null)
        {
            this.identifier.receiveTyped(visitor);
        }
        if (this.body != null)
        {
            this.body.receiveTyped(visitor);
        }
        if (this.modifiers != null)
        {
            this.modifiers.receiveTyped(visitor);
        }
        if (this.parameters != null)
        {
            this.parameters.receiveTyped(visitor);
        }
        if (this.varargParameter != null)
        {
            this.varargParameter.receiveTyped(visitor);
        }
        if (this.throwTypes != null)
        {
            this.throwTypes.receiveTyped(visitor);
        }
        if (this.typeParameters != null)
        {
            this.typeParameters.receiveTyped(visitor);
        }
        if (this.javadoc != null)
        {
            this.javadoc.receiveTyped(visitor);
        }
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
        list.add(getIdentifier());
        list.add(getBody());
        list.add(getModifiers());
        list.add(getParameters());
        list.add(getVarargParameter());
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
        sb.append("identifier=");
        sb.append(this.getIdentifier() == null? "null" : this.getIdentifier().getClass().getSimpleName());
        sb.append(',');
        sb.append("body=");
        sb.append(this.getBody() == null? "null" : this.getBody().getClass().getSimpleName());
        sb.append(',');
        sb.append("modifiers=");
        sb.append(this.getModifiers() == null? "null" : this.getModifiers().getClass().getSimpleName());
        sb.append(',');
        sb.append("parameters=");
        sb.append(this.getParameters() == null? "null" : this.getParameters().getClass().getSimpleName());
        sb.append(',');
        sb.append("varargParameter=");
        sb.append(this.getVarargParameter() == null? "null" : this.getVarargParameter().getClass().getSimpleName());
        sb.append(',');
        sb.append("throwTypes=");
        sb.append(this.getThrowTypes() == null? "null" : this.getThrowTypes().getClass().getSimpleName());
        sb.append(',');
        sb.append("typeParameters=");
        sb.append(this.getTypeParameters() == null? "null" : this.getTypeParameters().getClass().getSimpleName());
        sb.append(',');
        sb.append("javadoc=");
        sb.append(this.getJavadoc() == null? "null" : this.getJavadoc().getClass().getSimpleName());
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
        return operation.executeConstructorDeclarationNode(this, p);
    }

    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public ConstructorDeclarationNode deepCopy(BsjNodeFactory factory)
    {
        return factory.makeConstructorDeclarationNode(
                getIdentifier().deepCopy(factory),
                getBody().deepCopy(factory),
                getModifiers().deepCopy(factory),
                getParameters().deepCopy(factory),
                getVarargParameter().deepCopy(factory),
                getThrowTypes().deepCopy(factory),
                getTypeParameters().deepCopy(factory),
                getJavadoc().deepCopy(factory));
    }
}
