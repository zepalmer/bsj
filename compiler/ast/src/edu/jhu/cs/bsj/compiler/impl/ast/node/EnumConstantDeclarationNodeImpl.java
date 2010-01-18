package edu.jhu.cs.bsj.compiler.impl.ast.node;

import java.util.List;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
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
            JavadocNode javadoc)
    {
        super();
        this.annotations = annotations;
        this.identifier = identifier;
        this.arguments = arguments;
        this.body = body;
        this.javadoc = javadoc;
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
        this.annotations.receive(visitor);
        this.identifier.receive(visitor);
        this.arguments.receive(visitor);
        this.body.receive(visitor);
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
        this.annotations.receiveTyped(visitor);
        this.identifier.receiveTyped(visitor);
        this.arguments.receiveTyped(visitor);
        this.body.receiveTyped(visitor);
        this.javadoc.receiveTyped(visitor);
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
        visitor.visitNodeStart(this);
        visitor.visitEnumConstantDeclarationNodeStart(this, true);
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
        list.add(this.annotations);
        list.add(this.identifier);
        list.add(this.arguments);
        list.add(this.body);
        list.add(this.javadoc);
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
        sb.append(this.annotations == null? "null" : this.annotations.getClass().getSimpleName());
        sb.append(',');
        sb.append("identifier=");
        sb.append(this.identifier == null? "null" : this.identifier.getClass().getSimpleName());
        sb.append(',');
        sb.append("arguments=");
        sb.append(this.arguments == null? "null" : this.arguments.getClass().getSimpleName());
        sb.append(',');
        sb.append("body=");
        sb.append(this.body == null? "null" : this.body.getClass().getSimpleName());
        sb.append(',');
        sb.append("javadoc=");
        sb.append(this.javadoc == null? "null" : this.javadoc.getClass().getSimpleName());
        sb.append(']');
        return sb.toString();
    }
}
