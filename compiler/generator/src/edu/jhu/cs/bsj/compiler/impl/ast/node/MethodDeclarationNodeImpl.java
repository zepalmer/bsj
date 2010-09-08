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
import edu.jhu.cs.bsj.compiler.ast.node.IdentifierNode;
import edu.jhu.cs.bsj.compiler.ast.node.JavadocNode;
import edu.jhu.cs.bsj.compiler.ast.node.MethodDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.MethodModifiersNode;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.TypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.VariableNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.BlockStatementListNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.TypeParameterListNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.UnparameterizedTypeListNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.VariableListNode;
import edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeManager;
import edu.jhu.cs.bsj.compiler.impl.ast.attribute.ReadWriteAttribute;

@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class MethodDeclarationNodeImpl extends NodeImpl implements MethodDeclarationNode
{
    /** The body of this method. */
    private BlockStatementListNode body;
    
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
    
    private Map<LocalAttribute,ReadWriteAttribute> localAttributes = new EnumMap<LocalAttribute,ReadWriteAttribute>(LocalAttribute.class);
    private ReadWriteAttribute getAttribute(LocalAttribute attributeName)
    {
        ReadWriteAttribute attribute = localAttributes.get(attributeName);
        if (attribute == null)
        {
            attribute = new ReadWriteAttribute(MethodDeclarationNodeImpl.this);
            localAttributes.put(attributeName, attribute);
        }
        return attribute;
    }
    private static enum LocalAttribute
    {
        /** Attribute identifier for the body property. */
        BODY,
        /** Attribute identifier for the modifiers property. */
        MODIFIERS,
        /** Attribute identifier for the identifier property. */
        IDENTIFIER,
        /** Attribute identifier for the parameters property. */
        PARAMETERS,
        /** Attribute identifier for the varargParameter property. */
        VARARG_PARAMETER,
        /** Attribute identifier for the returnType property. */
        RETURN_TYPE,
        /** Attribute identifier for the throwTypes property. */
        THROW_TYPES,
        /** Attribute identifier for the typeParameters property. */
        TYPE_PARAMETERS,
        /** Attribute identifier for the javadoc property. */
        JAVADOC,
    }
    
    /** General constructor. */
    public MethodDeclarationNodeImpl(
            BlockStatementListNode body,
            MethodModifiersNode modifiers,
            IdentifierNode identifier,
            VariableListNode parameters,
            VariableNode varargParameter,
            TypeNode returnType,
            UnparameterizedTypeListNode throwTypes,
            TypeParameterListNode typeParameters,
            JavadocNode javadoc,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation,
            BsjNodeManager manager,
            boolean binary)
    {
        super(startLocation, stopLocation, manager, binary);
        setBody(body, false);
        setModifiers(modifiers, false);
        setIdentifier(identifier, false);
        setParameters(parameters, false);
        setVarargParameter(varargParameter, false);
        setReturnType(returnType, false);
        setThrowTypes(throwTypes, false);
        setTypeParameters(typeParameters, false);
        setJavadoc(javadoc, false);
    }
    
    /**
     * Gets the body of this method.
     * @return The body of this method.
     */
    public BlockStatementListNode getBody()
    {
        getAttribute(LocalAttribute.BODY).recordAccess(ReadWriteAttribute.AccessType.READ);
        return this.body;
    }
    
    /**
     * Changes the body of this method.
     * @param body The body of this method.
     */
    public void setBody(BlockStatementListNode body)
    {
            setBody(body, true);
            getManager().notifyChange(this);
    }
    
    private void setBody(BlockStatementListNode body, boolean checkPermissions)
    {
        if (checkPermissions)
        {
            getManager().assertMutatable(this);
            getAttribute(LocalAttribute.BODY).recordAccess(ReadWriteAttribute.AccessType.WRITE);
        }
        setAsChild(this.body, false);
        this.body = body;
        setAsChild(body, true);
    }
    
    /**
     * Gets the modifiers for this method.
     * @return The modifiers for this method.
     */
    public MethodModifiersNode getModifiers()
    {
        getAttribute(LocalAttribute.MODIFIERS).recordAccess(ReadWriteAttribute.AccessType.READ);
        return this.modifiers;
    }
    
    /**
     * Changes the modifiers for this method.
     * @param modifiers The modifiers for this method.
     */
    public void setModifiers(MethodModifiersNode modifiers)
    {
            setModifiers(modifiers, true);
            getManager().notifyChange(this);
    }
    
    private void setModifiers(MethodModifiersNode modifiers, boolean checkPermissions)
    {
        if (checkPermissions)
        {
            getManager().assertMutatable(this);
            getAttribute(LocalAttribute.MODIFIERS).recordAccess(ReadWriteAttribute.AccessType.WRITE);
        }
        setAsChild(this.modifiers, false);
        this.modifiers = modifiers;
        setAsChild(modifiers, true);
    }
    
    /**
     * Gets this method's name.
     * @return This method's name.
     */
    public IdentifierNode getIdentifier()
    {
        getAttribute(LocalAttribute.IDENTIFIER).recordAccess(ReadWriteAttribute.AccessType.READ);
        return this.identifier;
    }
    
    /**
     * Changes this method's name.
     * @param identifier This method's name.
     */
    public void setIdentifier(IdentifierNode identifier)
    {
            setIdentifier(identifier, true);
            getManager().notifyChange(this);
    }
    
    private void setIdentifier(IdentifierNode identifier, boolean checkPermissions)
    {
        if (checkPermissions)
        {
            getManager().assertMutatable(this);
            getAttribute(LocalAttribute.IDENTIFIER).recordAccess(ReadWriteAttribute.AccessType.WRITE);
        }
        setAsChild(this.identifier, false);
        this.identifier = identifier;
        setAsChild(identifier, true);
    }
    
    /**
     * Gets the parameters declared by this method.
     * @return The parameters declared by this method.
     */
    public VariableListNode getParameters()
    {
        getAttribute(LocalAttribute.PARAMETERS).recordAccess(ReadWriteAttribute.AccessType.READ);
        return this.parameters;
    }
    
    /**
     * Changes the parameters declared by this method.
     * @param parameters The parameters declared by this method.
     */
    public void setParameters(VariableListNode parameters)
    {
            setParameters(parameters, true);
            getManager().notifyChange(this);
    }
    
    private void setParameters(VariableListNode parameters, boolean checkPermissions)
    {
        if (checkPermissions)
        {
            getManager().assertMutatable(this);
            getAttribute(LocalAttribute.PARAMETERS).recordAccess(ReadWriteAttribute.AccessType.WRITE);
        }
        setAsChild(this.parameters, false);
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
            getManager().notifyChange(this);
    }
    
    private void setVarargParameter(VariableNode varargParameter, boolean checkPermissions)
    {
        if (checkPermissions)
        {
            getManager().assertMutatable(this);
            getAttribute(LocalAttribute.VARARG_PARAMETER).recordAccess(ReadWriteAttribute.AccessType.WRITE);
        }
        setAsChild(this.varargParameter, false);
        this.varargParameter = varargParameter;
        setAsChild(varargParameter, true);
    }
    
    /**
     * Gets the type of value returned.
     * @return The type of value returned.
     */
    public TypeNode getReturnType()
    {
        getAttribute(LocalAttribute.RETURN_TYPE).recordAccess(ReadWriteAttribute.AccessType.READ);
        return this.returnType;
    }
    
    /**
     * Changes the type of value returned.
     * @param returnType The type of value returned.
     */
    public void setReturnType(TypeNode returnType)
    {
            setReturnType(returnType, true);
            getManager().notifyChange(this);
    }
    
    private void setReturnType(TypeNode returnType, boolean checkPermissions)
    {
        if (checkPermissions)
        {
            getManager().assertMutatable(this);
            getAttribute(LocalAttribute.RETURN_TYPE).recordAccess(ReadWriteAttribute.AccessType.WRITE);
        }
        setAsChild(this.returnType, false);
        this.returnType = returnType;
        setAsChild(returnType, true);
    }
    
    /**
     * Gets the types of exceptions thrown by this method.
     * @return The types of exceptions thrown by this method.
     */
    public UnparameterizedTypeListNode getThrowTypes()
    {
        getAttribute(LocalAttribute.THROW_TYPES).recordAccess(ReadWriteAttribute.AccessType.READ);
        return this.throwTypes;
    }
    
    /**
     * Changes the types of exceptions thrown by this method.
     * @param throwTypes The types of exceptions thrown by this method.
     */
    public void setThrowTypes(UnparameterizedTypeListNode throwTypes)
    {
            setThrowTypes(throwTypes, true);
            getManager().notifyChange(this);
    }
    
    private void setThrowTypes(UnparameterizedTypeListNode throwTypes, boolean checkPermissions)
    {
        if (checkPermissions)
        {
            getManager().assertMutatable(this);
            getAttribute(LocalAttribute.THROW_TYPES).recordAccess(ReadWriteAttribute.AccessType.WRITE);
        }
        setAsChild(this.throwTypes, false);
        this.throwTypes = throwTypes;
        setAsChild(throwTypes, true);
    }
    
    /**
     * Gets this method's applicable type parameters.
     * @return This method's applicable type parameters.
     */
    public TypeParameterListNode getTypeParameters()
    {
        getAttribute(LocalAttribute.TYPE_PARAMETERS).recordAccess(ReadWriteAttribute.AccessType.READ);
        return this.typeParameters;
    }
    
    /**
     * Changes this method's applicable type parameters.
     * @param typeParameters This method's applicable type parameters.
     */
    public void setTypeParameters(TypeParameterListNode typeParameters)
    {
            setTypeParameters(typeParameters, true);
            getManager().notifyChange(this);
    }
    
    private void setTypeParameters(TypeParameterListNode typeParameters, boolean checkPermissions)
    {
        if (checkPermissions)
        {
            getManager().assertMutatable(this);
            getAttribute(LocalAttribute.TYPE_PARAMETERS).recordAccess(ReadWriteAttribute.AccessType.WRITE);
        }
        setAsChild(this.typeParameters, false);
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
            getManager().notifyChange(this);
    }
    
    private void setJavadoc(JavadocNode javadoc, boolean checkPermissions)
    {
        if (checkPermissions)
        {
            getManager().assertMutatable(this);
            getAttribute(LocalAttribute.JAVADOC).recordAccess(ReadWriteAttribute.AccessType.WRITE);
        }
        setAsChild(this.javadoc, false);
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
        visitor.visitMethodDeclarationNodeStart(this, true);
        visitor.visitNodeStart(this);
        visitor.visitInterfaceMemberNodeStart(this);
        visitor.visitAnonymousClassMemberNodeStart(this);
        visitor.visitAbstractInvokableDeclarationNodeStart(this);
        visitor.visitInvokableNameBindingNodeStart(this);
        visitor.visitStartEnd(this);
        receiveTypedToChildren(visitor);
        visitor.visitStopBegin(this);
        visitor.visitInterfaceMemberNodeStop(this);
        visitor.visitAnonymousClassMemberNodeStop(this);
        visitor.visitAbstractInvokableDeclarationNodeStop(this);
        visitor.visitInvokableNameBindingNodeStop(this);
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
     * Returns an iterator over the children of this node.
     * @see Node#getChildIterator()
     */
    @Override
    public Iterable<? extends Node> getChildIterable()
    {
        return Arrays.asList(new Node[]{getBody(), getModifiers(), getIdentifier(), getParameters(), getVarargParameter(), getReturnType(), getThrowTypes(), getTypeParameters(), getJavadoc()});
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
     * Executes an operation on this node.
     * @param operation The operation to perform.
     * @param p1 The parameter to pass to the operation.
     * @param p2 The parameter to pass to the operation.
     * @return The result of the operation.
     */
    @Override
    public <P1,P2,R> R executeOperation(BsjNodeOperation2Arguments<P1,P2,R> operation, P1 p1, P2 p2)
    {
        return operation.executeMethodDeclarationNode(this, p1, p2);
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
                getBody()==null?null:getBody().deepCopy(factory),
                getModifiers()==null?null:getModifiers().deepCopy(factory),
                getIdentifier()==null?null:getIdentifier().deepCopy(factory),
                getParameters()==null?null:getParameters().deepCopy(factory),
                getVarargParameter()==null?null:getVarargParameter().deepCopy(factory),
                getReturnType()==null?null:getReturnType().deepCopy(factory),
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
        
        if (before.equals(this.getBody()) && (after instanceof BlockStatementListNode))
        {
            setBody((BlockStatementListNode)after);
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
