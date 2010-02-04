package edu.jhu.cs.bsj.compiler.impl.ast.node;

import java.util.List;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeOperation;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.BsjTypedNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.node.AnnotationNode;
import edu.jhu.cs.bsj.compiler.ast.node.AnonymousClassBodyNode;
import edu.jhu.cs.bsj.compiler.ast.node.EnumConstantDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.ExpressionNode;
import edu.jhu.cs.bsj.compiler.ast.node.IdentifierNode;
import edu.jhu.cs.bsj.compiler.ast.node.JavadocNode;
import edu.jhu.cs.bsj.compiler.ast.node.ListNode;

@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class EnumConstantDeclarationNodeImpl extends NodeImpl implements EnumConstantDeclarationNode
{
    /** The annotations on this constant. */
    private ListNode<AnnotationNode> annotations;

    /** The name of this constant. */
    private IdentifierNode identifier;

    /** The arguments to the enum constructor. */
    private ListNode<ExpressionNode> arguments;

    /** The body used to anonymously subclass the constant. */
    private AnonymousClassBodyNode body;

    /** The associated javadoc comment for this node. */
    private JavadocNode javadoc;

    /** General constructor. */
    public EnumConstantDeclarationNodeImpl(
            ListNode<AnnotationNode> annotations,
            IdentifierNode identifier,
            ListNode<ExpressionNode> arguments,
            AnonymousClassBodyNode body,
            JavadocNode javadoc,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        super(startLocation, stopLocation);
        setAnnotations(annotations);
        setIdentifier(identifier);
        setArguments(arguments);
        setBody(body);
        setJavadoc(javadoc);
    }

    /**
     * Gets the annotations on this constant.
     * @return The annotations on this constant.
     */
    public ListNode<AnnotationNode> getAnnotations()
    {
        return this.annotations;
    }

    /**
     * Changes the annotations on this constant.
     * @param annotations The annotations on this constant.
     */
    public void setAnnotations(ListNode<AnnotationNode> annotations)
    {
        if (this.annotations instanceof NodeImpl)
        {
            ((NodeImpl)this.annotations).setParent(null);
        }
        this.annotations = annotations;
        if (this.annotations instanceof NodeImpl)
        {
            ((NodeImpl)this.annotations).setParent(this);
        }
    }

    /**
     * Gets the name of this constant.
     * @return The name of this constant.
     */
    public IdentifierNode getIdentifier()
    {
        return this.identifier;
    }

    /**
     * Changes the name of this constant.
     * @param identifier The name of this constant.
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
     * Gets the arguments to the enum constructor.
     * @return The arguments to the enum constructor.
     */
    public ListNode<ExpressionNode> getArguments()
    {
        return this.arguments;
    }

    /**
     * Changes the arguments to the enum constructor.
     * @param arguments The arguments to the enum constructor.
     */
    public void setArguments(ListNode<ExpressionNode> arguments)
    {
        if (this.arguments instanceof NodeImpl)
        {
            ((NodeImpl)this.arguments).setParent(null);
        }
        this.arguments = arguments;
        if (this.arguments instanceof NodeImpl)
        {
            ((NodeImpl)this.arguments).setParent(this);
        }
    }

    /**
     * Gets the body used to anonymously subclass the constant.
     * @return The body used to anonymously subclass the constant.
     */
    public AnonymousClassBodyNode getBody()
    {
        return this.body;
    }

    /**
     * Changes the body used to anonymously subclass the constant.
     * @param body The body used to anonymously subclass the constant.
     */
    public void setBody(AnonymousClassBodyNode body)
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
                getAnnotations().deepCopy(factory),
                getIdentifier().deepCopy(factory),
                getArguments().deepCopy(factory),
                getBody().deepCopy(factory),
                getJavadoc().deepCopy(factory));
    }
}
