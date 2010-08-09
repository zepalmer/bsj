package edu.jhu.cs.bsj.compiler.impl.ast.node;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeOperation;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeOperation2Arguments;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.BsjTypedNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.node.ConstructorBodyNode;
import edu.jhu.cs.bsj.compiler.ast.node.ConstructorDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.ConstructorModifiersNode;
import edu.jhu.cs.bsj.compiler.ast.node.IdentifierNode;
import edu.jhu.cs.bsj.compiler.ast.node.JavadocNode;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.VariableNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.TypeParameterListNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.UnparameterizedTypeListNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.VariableListNode;
import edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeManager;
import edu.jhu.cs.bsj.compiler.impl.ast.attribute.ReadWriteAttribute;

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
    private VariableListNode parameters;
    
    /** The vararg parameter declared by this method. */
    private VariableNode varargParameter;
    
    /** The types of exceptions thrown by this constructor. */
    private UnparameterizedTypeListNode throwTypes;
    
    /** This constructor's applicable type parameters. */
    private TypeParameterListNode typeParameters;
    
    /** The associated javadoc comment for this node. */
    private JavadocNode javadoc;
    
    private Map<LocalAttribute,ReadWriteAttribute> localAttributes = new EnumMap<LocalAttribute,ReadWriteAttribute>(LocalAttribute.class);
    private ReadWriteAttribute getAttribute(LocalAttribute attributeName)
    {
        ReadWriteAttribute attribute = localAttributes.get(attributeName);
        if (attribute == null)
        {
            attribute = new ReadWriteAttribute(ConstructorDeclarationNodeImpl.this);
            localAttributes.put(attributeName, attribute);
        }
        return attribute;
    }
    private static enum LocalAttribute
    {
        /** Attribute identifier for the identifier property. */
        IDENTIFIER,
        /** Attribute identifier for the body property. */
        BODY,
        /** Attribute identifier for the modifiers property. */
        MODIFIERS,
        /** Attribute identifier for the parameters property. */
        PARAMETERS,
        /** Attribute identifier for the varargParameter property. */
        VARARG_PARAMETER,
        /** Attribute identifier for the throwTypes property. */
        THROW_TYPES,
        /** Attribute identifier for the typeParameters property. */
        TYPE_PARAMETERS,
        /** Attribute identifier for the javadoc property. */
        JAVADOC,
    }
    
    /** General constructor. */
    public ConstructorDeclarationNodeImpl(
            IdentifierNode identifier,
            ConstructorBodyNode body,
            ConstructorModifiersNode modifiers,
            VariableListNode parameters,
            VariableNode varargParameter,
            UnparameterizedTypeListNode throwTypes,
            TypeParameterListNode typeParameters,
            JavadocNode javadoc,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation,
            BsjNodeManager manager,
            boolean binary)
    {
        super(startLocation, stopLocation, manager, binary);
        setIdentifier(identifier, false);
        setBody(body, false);
        setModifiers(modifiers, false);
        setParameters(parameters, false);
        setVarargParameter(varargParameter, false);
        setThrowTypes(throwTypes, false);
        setTypeParameters(typeParameters, false);
        setJavadoc(javadoc, false);
    }
    
    /**
     * Gets the identifier for the name of this constructor.
     * @return The identifier for the name of this constructor.
     */
    public IdentifierNode getIdentifier()
    {
        getAttribute(LocalAttribute.IDENTIFIER).recordAccess(ReadWriteAttribute.AccessType.READ);
        return this.identifier;
    }
    
    /**
     * Changes the identifier for the name of this constructor.
     * @param identifier The identifier for the name of this constructor.
     */
    public void setIdentifier(IdentifierNode identifier)
    {
            setIdentifier(identifier, true);
    }
    
    private void setIdentifier(IdentifierNode identifier, boolean checkPermissions)
    {
        if (checkPermissions)
        {
            getManager().assertMutatable(this);
            getAttribute(LocalAttribute.IDENTIFIER).recordAccess(ReadWriteAttribute.AccessType.WRITE);
        }
        setAsChild(identifier, false);
        this.identifier = identifier;
        setAsChild(identifier, true);
    }
    
    /**
     * Gets the body of this constructor.
     * @return The body of this constructor.
     */
    public ConstructorBodyNode getBody()
    {
        getAttribute(LocalAttribute.BODY).recordAccess(ReadWriteAttribute.AccessType.READ);
        return this.body;
    }
    
    /**
     * Changes the body of this constructor.
     * @param body The body of this constructor.
     */
    public void setBody(ConstructorBodyNode body)
    {
            setBody(body, true);
    }
    
    private void setBody(ConstructorBodyNode body, boolean checkPermissions)
    {
        if (checkPermissions)
        {
            getManager().assertMutatable(this);
            getAttribute(LocalAttribute.BODY).recordAccess(ReadWriteAttribute.AccessType.WRITE);
        }
        setAsChild(body, false);
        this.body = body;
        setAsChild(body, true);
    }
    
    /**
     * Gets the modifiers for this constructor.
     * @return The modifiers for this constructor.
     */
    public ConstructorModifiersNode getModifiers()
    {
        getAttribute(LocalAttribute.MODIFIERS).recordAccess(ReadWriteAttribute.AccessType.READ);
        return this.modifiers;
    }
    
    /**
     * Changes the modifiers for this constructor.
     * @param modifiers The modifiers for this constructor.
     */
    public void setModifiers(ConstructorModifiersNode modifiers)
    {
            setModifiers(modifiers, true);
    }
    
    private void setModifiers(ConstructorModifiersNode modifiers, boolean checkPermissions)
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
     * Gets the parameters declared by this constructor.
     * @return The parameters declared by this constructor.
     */
    public VariableListNode getParameters()
    {
        getAttribute(LocalAttribute.PARAMETERS).recordAccess(ReadWriteAttribute.AccessType.READ);
        return this.parameters;
    }
    
    /**
     * Changes the parameters declared by this constructor.
     * @param parameters The parameters declared by this constructor.
     */
    public void setParameters(VariableListNode parameters)
    {
            setParameters(parameters, true);
    }
    
    private void setParameters(VariableListNode parameters, boolean checkPermissions)
    {
        if (checkPermissions)
        {
            getManager().assertMutatable(this);
            getAttribute(LocalAttribute.PARAMETERS).recordAccess(ReadWriteAttribute.AccessType.WRITE);
        }
        setAsChild(parameters, false);
        this.parameters = parameters;
        setAsChild(parameters, true);
    }
    
    /**
     * Gets the vararg parameter declared by this method.
     * @return The vararg parameter declared by this method.
     */
    public VariableNode getVarargParameter()
    {
        getAttribute(LocalAttribute.VARARG_PARAMETER).recordAccess(ReadWriteAttribute.AccessType.READ);
        return this.varargParameter;
    }
    
    /**
     * Changes the vararg parameter declared by this method.
     * @param varargParameter The vararg parameter declared by this method.
     */
    public void setVarargParameter(VariableNode varargParameter)
    {
            setVarargParameter(varargParameter, true);
    }
    
    private void setVarargParameter(VariableNode varargParameter, boolean checkPermissions)
    {
        if (checkPermissions)
        {
            getManager().assertMutatable(this);
            getAttribute(LocalAttribute.VARARG_PARAMETER).recordAccess(ReadWriteAttribute.AccessType.WRITE);
        }
        setAsChild(varargParameter, false);
        this.varargParameter = varargParameter;
        setAsChild(varargParameter, true);
    }
    
    /**
     * Gets the types of exceptions thrown by this constructor.
     * @return The types of exceptions thrown by this constructor.
     */
    public UnparameterizedTypeListNode getThrowTypes()
    {
        getAttribute(LocalAttribute.THROW_TYPES).recordAccess(ReadWriteAttribute.AccessType.READ);
        return this.throwTypes;
    }
    
    /**
     * Changes the types of exceptions thrown by this constructor.
     * @param throwTypes The types of exceptions thrown by this constructor.
     */
    public void setThrowTypes(UnparameterizedTypeListNode throwTypes)
    {
            setThrowTypes(throwTypes, true);
    }
    
    private void setThrowTypes(UnparameterizedTypeListNode throwTypes, boolean checkPermissions)
    {
        if (checkPermissions)
        {
            getManager().assertMutatable(this);
            getAttribute(LocalAttribute.THROW_TYPES).recordAccess(ReadWriteAttribute.AccessType.WRITE);
        }
        setAsChild(throwTypes, false);
        this.throwTypes = throwTypes;
        setAsChild(throwTypes, true);
    }
    
    /**
     * Gets this constructor's applicable type parameters.
     * @return This constructor's applicable type parameters.
     */
    public TypeParameterListNode getTypeParameters()
    {
        getAttribute(LocalAttribute.TYPE_PARAMETERS).recordAccess(ReadWriteAttribute.AccessType.READ);
        return this.typeParameters;
    }
    
    /**
     * Changes this constructor's applicable type parameters.
     * @param typeParameters This constructor's applicable type parameters.
     */
    public void setTypeParameters(TypeParameterListNode typeParameters)
    {
            setTypeParameters(typeParameters, true);
    }
    
    private void setTypeParameters(TypeParameterListNode typeParameters, boolean checkPermissions)
    {
        if (checkPermissions)
        {
            getManager().assertMutatable(this);
            getAttribute(LocalAttribute.TYPE_PARAMETERS).recordAccess(ReadWriteAttribute.AccessType.WRITE);
        }
        setAsChild(typeParameters, false);
        this.typeParameters = typeParameters;
        setAsChild(typeParameters, true);
    }
    
    /**
     * Gets the associated javadoc comment for this node.
     * @return The associated javadoc comment for this node.
     */
    public JavadocNode getJavadoc()
    {
        getAttribute(LocalAttribute.JAVADOC).recordAccess(ReadWriteAttribute.AccessType.READ);
        return this.javadoc;
    }
    
    /**
     * Changes the associated javadoc comment for this node.
     * @param javadoc The associated javadoc comment for this node.
     */
    public void setJavadoc(JavadocNode javadoc)
    {
            setJavadoc(javadoc, true);
    }
    
    private void setJavadoc(JavadocNode javadoc, boolean checkPermissions)
    {
        if (checkPermissions)
        {
            getManager().assertMutatable(this);
            getAttribute(LocalAttribute.JAVADOC).recordAccess(ReadWriteAttribute.AccessType.WRITE);
        }
        setAsChild(javadoc, false);
        this.javadoc = javadoc;
        setAsChild(javadoc, true);
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
        visitor.visitConstructorDeclarationNodeStart(this, true);
        visitor.visitNodeStart(this);
        visitor.visitAbstractInvokableDeclarationNodeStart(this);
        visitor.visitStartEnd(this);
        receiveTypedToChildren(visitor);
        visitor.visitStopBegin(this);
        visitor.visitAbstractInvokableDeclarationNodeStop(this);
        visitor.visitNodeStop(this);
        visitor.visitConstructorDeclarationNodeStop(this, true);
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
     * Returns an iterator over the children of this node.
     * @see Node#getChildIterator()
     */
    @Override
    public Iterable<? extends Node> getChildIterable()
    {
        return Arrays.asList(new Node[]{getIdentifier(), getBody(), getModifiers(), getParameters(), getVarargParameter(), getThrowTypes(), getTypeParameters(), getJavadoc()});
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
     * Executes an operation on this node.
     * @param operation The operation to perform.
     * @param p1 The parameter to pass to the operation.
     * @param p2 The parameter to pass to the operation.
     * @return The result of the operation.
     */
    @Override
    public <P1,P2,R> R executeOperation(BsjNodeOperation2Arguments<P1,P2,R> operation, P1 p1, P2 p2)
    {
        return operation.executeConstructorDeclarationNode(this, p1, p2);
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
                getIdentifier()==null?null:getIdentifier().deepCopy(factory),
                getBody()==null?null:getBody().deepCopy(factory),
                getModifiers()==null?null:getModifiers().deepCopy(factory),
                getParameters()==null?null:getParameters().deepCopy(factory),
                getVarargParameter()==null?null:getVarargParameter().deepCopy(factory),
                getThrowTypes()==null?null:getThrowTypes().deepCopy(factory),
                getTypeParameters()==null?null:getTypeParameters().deepCopy(factory),
                getJavadoc()==null?null:getJavadoc().deepCopy(factory),
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
        
        if (before.equals(this.getIdentifier()) && (after instanceof IdentifierNode))
        {
            setIdentifier((IdentifierNode)after);
            return true;
        }
        if (before.equals(this.getBody()) && (after instanceof ConstructorBodyNode))
        {
            setBody((ConstructorBodyNode)after);
            return true;
        }
        if (before.equals(this.getModifiers()) && (after instanceof ConstructorModifiersNode))
        {
            setModifiers((ConstructorModifiersNode)after);
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
