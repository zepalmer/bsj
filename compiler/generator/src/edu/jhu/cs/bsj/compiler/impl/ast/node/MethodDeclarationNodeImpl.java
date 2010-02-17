package edu.jhu.cs.bsj.compiler.impl.ast.node;

import java.util.List;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeOperation;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.BsjTypedNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.node.BlockNode;
import edu.jhu.cs.bsj.compiler.ast.node.IdentifierNode;
import edu.jhu.cs.bsj.compiler.ast.node.JavadocNode;
import edu.jhu.cs.bsj.compiler.ast.node.MethodDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.MethodModifiersNode;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.TypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.TypeParameterListNode;
import edu.jhu.cs.bsj.compiler.ast.node.UnparameterizedTypeListNode;
import edu.jhu.cs.bsj.compiler.ast.node.VariableListNode;
import edu.jhu.cs.bsj.compiler.ast.node.VariableNode;

@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class MethodDeclarationNodeImpl extends NodeImpl implements MethodDeclarationNode
{
    /** The body of this method. */
    private BlockNode body;

    /** The modifiers for this method. */
    private MethodModifiersNode modifiers;

    /** This method's name. */
    private IdentifierNode identifier;

    /** The parameters declared by this method. */
    private VariableListNode parameters;

    /** The vararg parameter declared by this method. */
    private VariableNode varargParameter;

    /** The type of value returned. */
    private TypeNode returnType;

    /** The types of exceptions thrown by this method. */
    private UnparameterizedTypeListNode throwTypes;

    /** This method's applicable type parameters. */
    private TypeParameterListNode typeParameters;

    /** The associated javadoc comment for this node. */
    private JavadocNode javadoc;

    /** General constructor. */
    public MethodDeclarationNodeImpl(
            BlockNode body,
            MethodModifiersNode modifiers,
            IdentifierNode identifier,
            VariableListNode parameters,
            VariableNode varargParameter,
            TypeNode returnType,
            UnparameterizedTypeListNode throwTypes,
            TypeParameterListNode typeParameters,
            JavadocNode javadoc,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        super(startLocation, stopLocation);
        setBody(body);
        setModifiers(modifiers);
        setIdentifier(identifier);
        setParameters(parameters);
        setVarargParameter(varargParameter);
        setReturnType(returnType);
        setThrowTypes(throwTypes);
        setTypeParameters(typeParameters);
        setJavadoc(javadoc);
    }

    /**
     * Gets the body of this method.
     * @return The body of this method.
     */
    public BlockNode getBody()
    {
        return this.body;
    }

    /**
     * Changes the body of this method.
     * @param body The body of this method.
     */
    public void setBody(BlockNode body)
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
    public VariableListNode getParameters()
    {
        return this.parameters;
    }

    /**
     * Changes the parameters declared by this method.
     * @param parameters The parameters declared by this method.
     */
    public void setParameters(VariableListNode parameters)
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
    public UnparameterizedTypeListNode getThrowTypes()
    {
        return this.throwTypes;
    }

    /**
     * Changes the types of exceptions thrown by this method.
     * @param throwTypes The types of exceptions thrown by this method.
     */
    public void setThrowTypes(UnparameterizedTypeListNode throwTypes)
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
    public TypeParameterListNode getTypeParameters()
    {
        return this.typeParameters;
    }

    /**
     * Changes this method's applicable type parameters.
     * @param typeParameters This method's applicable type parameters.
     */
    public void setTypeParameters(TypeParameterListNode typeParameters)
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
        if (this.body != null)
        {
            this.body.receive(visitor);
        }
        if (this.modifiers != null)
        {
            this.modifiers.receive(visitor);
        }
        if (this.identifier != null)
        {
            this.identifier.receive(visitor);
        }
        if (this.parameters != null)
        {
            this.parameters.receive(visitor);
        }
        if (this.varargParameter != null)
        {
            this.varargParameter.receive(visitor);
        }
        if (this.returnType != null)
        {
            this.returnType.receive(visitor);
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
        if (this.body != null)
        {
            this.body.receiveTyped(visitor);
        }
        if (this.modifiers != null)
        {
            this.modifiers.receiveTyped(visitor);
        }
        if (this.identifier != null)
        {
            this.identifier.receiveTyped(visitor);
        }
        if (this.parameters != null)
        {
            this.parameters.receiveTyped(visitor);
        }
        if (this.varargParameter != null)
        {
            this.varargParameter.receiveTyped(visitor);
        }
        if (this.returnType != null)
        {
            this.returnType.receiveTyped(visitor);
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
        visitor.visitNodeStop(this);
        visitor.visitMethodDeclarationNodeStop(this, true);
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
        sb.append(this.getBody() == null? "null" : this.getBody().getClass().getSimpleName());
        sb.append(',');
        sb.append("modifiers=");
        sb.append(this.getModifiers() == null? "null" : this.getModifiers().getClass().getSimpleName());
        sb.append(',');
        sb.append("identifier=");
        sb.append(this.getIdentifier() == null? "null" : this.getIdentifier().getClass().getSimpleName());
        sb.append(',');
        sb.append("parameters=");
        sb.append(this.getParameters() == null? "null" : this.getParameters().getClass().getSimpleName());
        sb.append(',');
        sb.append("varargParameter=");
        sb.append(this.getVarargParameter() == null? "null" : this.getVarargParameter().getClass().getSimpleName());
        sb.append(',');
        sb.append("returnType=");
        sb.append(this.getReturnType() == null? "null" : this.getReturnType().getClass().getSimpleName());
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
        return operation.executeMethodDeclarationNode(this, p);
    }

    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public MethodDeclarationNode deepCopy(BsjNodeFactory factory)
    {
        return factory.makeMethodDeclarationNode(
                getBody().deepCopy(factory),
                getModifiers().deepCopy(factory),
                getIdentifier().deepCopy(factory),
                getParameters().deepCopy(factory),
                getVarargParameter().deepCopy(factory),
                getReturnType().deepCopy(factory),
                getThrowTypes().deepCopy(factory),
                getTypeParameters().deepCopy(factory),
                getJavadoc().deepCopy(factory),
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
        
        if (before.equals(this.getBody()) && (after instanceof BlockNode))
        {
            setBody((BlockNode)after);
            return true;
        }
        if (before.equals(this.getModifiers()) && (after instanceof MethodModifiersNode))
        {
            setModifiers((MethodModifiersNode)after);
            return true;
        }
        if (before.equals(this.getIdentifier()) && (after instanceof IdentifierNode))
        {
            setIdentifier((IdentifierNode)after);
            return true;
        }
        if (before.equals(this.getParameters()) && (after instanceof VariableListNode))
        {
            setParameters((VariableListNode)after);
            return true;
        }
        if (before.equals(this.getVarargParameter()) && (after instanceof VariableNode))
        {
            setVarargParameter((VariableNode)after);
            return true;
        }
        if (before.equals(this.getReturnType()) && (after instanceof TypeNode))
        {
            setReturnType((TypeNode)after);
            return true;
        }
        if (before.equals(this.getThrowTypes()) && (after instanceof UnparameterizedTypeListNode))
        {
            setThrowTypes((UnparameterizedTypeListNode)after);
            return true;
        }
        if (before.equals(this.getTypeParameters()) && (after instanceof TypeParameterListNode))
        {
            setTypeParameters((TypeParameterListNode)after);
            return true;
        }
        if (before.equals(this.getJavadoc()) && (after instanceof JavadocNode))
        {
            setJavadoc((JavadocNode)after);
            return true;
        }
        return false;
    }
    
}
