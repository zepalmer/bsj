package edu.jhu.cs.bsj.compiler.impl.ast.node;

import java.util.List;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeOperation;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.BsjTypedNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.node.AnnotationListNode;
import edu.jhu.cs.bsj.compiler.ast.node.AnonymousClassBodyNode;
import edu.jhu.cs.bsj.compiler.ast.node.EnumConstantDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.ExpressionListNode;
import edu.jhu.cs.bsj.compiler.ast.node.IdentifierNode;
import edu.jhu.cs.bsj.compiler.ast.node.JavadocNode;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaAnnotationListNode;
import edu.jhu.cs.bsj.compiler.impl.ast.Attribute;
import edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeManager;

@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class EnumConstantDeclarationNodeImpl extends NodeImpl implements EnumConstantDeclarationNode
{
    /** The meta-annotations on this constant. */
    private MetaAnnotationListNode metaAnnotations;
    
    /** The annotations on this constant. */
    private AnnotationListNode annotations;
    
    /** The name of this constant. */
    private IdentifierNode identifier;
    
    /** The arguments to the enum constructor. */
    private ExpressionListNode arguments;
    
    /** The body used to anonymously subclass the constant. */
    private AnonymousClassBodyNode body;
    
    /** The associated javadoc comment for this node. */
    private JavadocNode javadoc;
    
    private static enum LocalAttribute implements edu.jhu.cs.bsj.compiler.impl.ast.Attribute
    {
        /** Attribute for the metaAnnotations property. */
        META_ANNOTATIONS,
        /** Attribute for the annotations property. */
        ANNOTATIONS,
        /** Attribute for the identifier property. */
        IDENTIFIER,
        /** Attribute for the arguments property. */
        ARGUMENTS,
        /** Attribute for the body property. */
        BODY,
        /** Attribute for the javadoc property. */
        JAVADOC,
    }
    
    /** General constructor. */
    public EnumConstantDeclarationNodeImpl(
            MetaAnnotationListNode metaAnnotations,
            AnnotationListNode annotations,
            IdentifierNode identifier,
            ExpressionListNode arguments,
            AnonymousClassBodyNode body,
            JavadocNode javadoc,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation,
            BsjNodeManager manager,
            boolean binary)
    {
        super(startLocation, stopLocation, manager, binary);
        setMetaAnnotations(metaAnnotations, false);
        setAnnotations(annotations, false);
        setIdentifier(identifier, false);
        setArguments(arguments, false);
        setBody(body, false);
        setJavadoc(javadoc, false);
    }
    
    /**
     * Gets the meta-annotations on this constant.
     * @return The meta-annotations on this constant.
     */
    public MetaAnnotationListNode getMetaAnnotations()
    {
        recordAccess(LocalAttribute.META_ANNOTATIONS, Attribute.AccessType.READ);
        return this.metaAnnotations;
    }
    
    /**
     * Changes the meta-annotations on this constant.
     * @param metaAnnotations The meta-annotations on this constant.
     */
    public void setMetaAnnotations(MetaAnnotationListNode metaAnnotations)
    {
            setMetaAnnotations(metaAnnotations, true);
    }
    
    private void setMetaAnnotations(MetaAnnotationListNode metaAnnotations, boolean checkPermissions)
    {
        if (checkPermissions)
        {
            getManager().assertMutatable(this);
            recordAccess(LocalAttribute.META_ANNOTATIONS, Attribute.AccessType.WRITE);
        }
        setAsChild(metaAnnotations, false);
        this.metaAnnotations = metaAnnotations;
        setAsChild(metaAnnotations, true);
    }
    
    /**
     * Gets the annotations on this constant.
     * @return The annotations on this constant.
     */
    public AnnotationListNode getAnnotations()
    {
        recordAccess(LocalAttribute.ANNOTATIONS, Attribute.AccessType.READ);
        return this.annotations;
    }
    
    /**
     * Changes the annotations on this constant.
     * @param annotations The annotations on this constant.
     */
    public void setAnnotations(AnnotationListNode annotations)
    {
            setAnnotations(annotations, true);
    }
    
    private void setAnnotations(AnnotationListNode annotations, boolean checkPermissions)
    {
        if (checkPermissions)
        {
            getManager().assertMutatable(this);
            recordAccess(LocalAttribute.ANNOTATIONS, Attribute.AccessType.WRITE);
        }
        setAsChild(annotations, false);
        this.annotations = annotations;
        setAsChild(annotations, true);
    }
    
    /**
     * Gets the name of this constant.
     * @return The name of this constant.
     */
    public IdentifierNode getIdentifier()
    {
        recordAccess(LocalAttribute.IDENTIFIER, Attribute.AccessType.READ);
        return this.identifier;
    }
    
    /**
     * Changes the name of this constant.
     * @param identifier The name of this constant.
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
            recordAccess(LocalAttribute.IDENTIFIER, Attribute.AccessType.WRITE);
        }
        setAsChild(identifier, false);
        this.identifier = identifier;
        setAsChild(identifier, true);
    }
    
    /**
     * Gets the arguments to the enum constructor.
     * @return The arguments to the enum constructor.
     */
    public ExpressionListNode getArguments()
    {
        recordAccess(LocalAttribute.ARGUMENTS, Attribute.AccessType.READ);
        return this.arguments;
    }
    
    /**
     * Changes the arguments to the enum constructor.
     * @param arguments The arguments to the enum constructor.
     */
    public void setArguments(ExpressionListNode arguments)
    {
            setArguments(arguments, true);
    }
    
    private void setArguments(ExpressionListNode arguments, boolean checkPermissions)
    {
        if (checkPermissions)
        {
            getManager().assertMutatable(this);
            recordAccess(LocalAttribute.ARGUMENTS, Attribute.AccessType.WRITE);
        }
        setAsChild(arguments, false);
        this.arguments = arguments;
        setAsChild(arguments, true);
    }
    
    /**
     * Gets the body used to anonymously subclass the constant.
     * @return The body used to anonymously subclass the constant.
     */
    public AnonymousClassBodyNode getBody()
    {
        recordAccess(LocalAttribute.BODY, Attribute.AccessType.READ);
        return this.body;
    }
    
    /**
     * Changes the body used to anonymously subclass the constant.
     * @param body The body used to anonymously subclass the constant.
     */
    public void setBody(AnonymousClassBodyNode body)
    {
            setBody(body, true);
    }
    
    private void setBody(AnonymousClassBodyNode body, boolean checkPermissions)
    {
        if (checkPermissions)
        {
            getManager().assertMutatable(this);
            recordAccess(LocalAttribute.BODY, Attribute.AccessType.WRITE);
        }
        setAsChild(body, false);
        this.body = body;
        setAsChild(body, true);
    }
    
    /**
     * Gets the associated javadoc comment for this node.
     * @return The associated javadoc comment for this node.
     */
    public JavadocNode getJavadoc()
    {
        recordAccess(LocalAttribute.JAVADOC, Attribute.AccessType.READ);
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
            recordAccess(LocalAttribute.JAVADOC, Attribute.AccessType.WRITE);
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
        if (this.metaAnnotations != null)
        {
            this.metaAnnotations.receive(visitor);
        }
        if (this.annotations != null)
        {
            this.annotations.receive(visitor);
        }
        if (this.identifier != null)
        {
            this.identifier.receive(visitor);
        }
        if (this.arguments != null)
        {
            this.arguments.receive(visitor);
        }
        if (this.body != null)
        {
            this.body.receive(visitor);
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
        if (this.metaAnnotations != null)
        {
            this.metaAnnotations.receiveTyped(visitor);
        }
        if (this.annotations != null)
        {
            this.annotations.receiveTyped(visitor);
        }
        if (this.identifier != null)
        {
            this.identifier.receiveTyped(visitor);
        }
        if (this.arguments != null)
        {
            this.arguments.receiveTyped(visitor);
        }
        if (this.body != null)
        {
            this.body.receiveTyped(visitor);
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
        visitor.visitEnumConstantDeclarationNodeStart(this, true);
        visitor.visitNodeStart(this);
        visitor.visitStartEnd(this);
        receiveTypedToChildren(visitor);
        visitor.visitStopBegin(this);
        visitor.visitNodeStop(this);
        visitor.visitEnumConstantDeclarationNodeStop(this, true);
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
        list.add(getMetaAnnotations());
        list.add(getAnnotations());
        list.add(getIdentifier());
        list.add(getArguments());
        list.add(getBody());
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
        sb.append("metaAnnotations=");
        sb.append(this.getMetaAnnotations() == null? "null" : this.getMetaAnnotations().getClass().getSimpleName());
        sb.append(',');
        sb.append("annotations=");
        sb.append(this.getAnnotations() == null? "null" : this.getAnnotations().getClass().getSimpleName());
        sb.append(',');
        sb.append("identifier=");
        sb.append(this.getIdentifier() == null? "null" : this.getIdentifier().getClass().getSimpleName());
        sb.append(',');
        sb.append("arguments=");
        sb.append(this.getArguments() == null? "null" : this.getArguments().getClass().getSimpleName());
        sb.append(',');
        sb.append("body=");
        sb.append(this.getBody() == null? "null" : this.getBody().getClass().getSimpleName());
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
        return operation.executeEnumConstantDeclarationNode(this, p);
    }
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public EnumConstantDeclarationNode deepCopy(BsjNodeFactory factory)
    {
        return factory.makeEnumConstantDeclarationNode(
                getMetaAnnotations()==null?null:getMetaAnnotations().deepCopy(factory),
                getAnnotations()==null?null:getAnnotations().deepCopy(factory),
                getIdentifier()==null?null:getIdentifier().deepCopy(factory),
                getArguments()==null?null:getArguments().deepCopy(factory),
                getBody()==null?null:getBody().deepCopy(factory),
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
        
        if (before.equals(this.getMetaAnnotations()) && (after instanceof MetaAnnotationListNode))
        {
            setMetaAnnotations((MetaAnnotationListNode)after);
            return true;
        }
        if (before.equals(this.getAnnotations()) && (after instanceof AnnotationListNode))
        {
            setAnnotations((AnnotationListNode)after);
            return true;
        }
        if (before.equals(this.getIdentifier()) && (after instanceof IdentifierNode))
        {
            setIdentifier((IdentifierNode)after);
            return true;
        }
        if (before.equals(this.getArguments()) && (after instanceof ExpressionListNode))
        {
            setArguments((ExpressionListNode)after);
            return true;
        }
        if (before.equals(this.getBody()) && (after instanceof AnonymousClassBodyNode))
        {
            setBody((AnonymousClassBodyNode)after);
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
