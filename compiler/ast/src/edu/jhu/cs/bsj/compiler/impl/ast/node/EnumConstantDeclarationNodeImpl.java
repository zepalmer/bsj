package edu.jhu.cs.bsj.compiler.impl.ast.node;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.node.AnnotationNode;
import edu.jhu.cs.bsj.compiler.ast.node.ClassBodyNode;
import edu.jhu.cs.bsj.compiler.ast.node.EnumConstantDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.ExpressionNode;
import edu.jhu.cs.bsj.compiler.ast.node.IdentifierNode;
import edu.jhu.cs.bsj.compiler.ast.node.ListNode;

public class EnumConstantDeclarationNodeImpl extends NodeImpl implements EnumConstantDeclarationNode
{
    /** The annotations on this constant. */
    private ListNode<? extends AnnotationNode> annotations;

    /** The name of this constant. */
    private IdentifierNode identifier;

    /** The arguments to the enum constructor. */
    private ListNode<? extends ExpressionNode> arguments;

    /** The body used to anonymously subclass the constant. */
    private ClassBodyNode body;

    /** General constructor. */
    public EnumConstantDeclarationNodeImpl(
            ListNode<? extends AnnotationNode> annotations,
            IdentifierNode identifier,
            ListNode<? extends ExpressionNode> arguments,
            ClassBodyNode body)
    {
        super();
        this.annotations = annotations;
        this.identifier = identifier;
        this.arguments = arguments;
        this.body = body;
    }

    /**
     * Gets the annotations on this constant.
     * @return The annotations on this constant.
     */
    public ListNode<? extends AnnotationNode> getAnnotations()
    {
        return this.annotations;
    }

    /**
     * Changes the annotations on this constant.
     * @param annotations The annotations on this constant.
     */
    public void setAnnotations(ListNode<? extends AnnotationNode> annotations)
    {
        this.annotations = annotations;
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
        this.identifier = identifier;
    }

    /**
     * Gets the arguments to the enum constructor.
     * @return The arguments to the enum constructor.
     */
    public ListNode<? extends ExpressionNode> getArguments()
    {
        return this.arguments;
    }

    /**
     * Changes the arguments to the enum constructor.
     * @param arguments The arguments to the enum constructor.
     */
    public void setArguments(ListNode<? extends ExpressionNode> arguments)
    {
        this.arguments = arguments;
    }

    /**
     * Gets the body used to anonymously subclass the constant.
     * @return The body used to anonymously subclass the constant.
     */
    public ClassBodyNode getBody()
    {
        return this.body;
    }

    /**
     * Changes the body used to anonymously subclass the constant.
     * @param body The body used to anonymously subclass the constant.
     */
    public void setBody(ClassBodyNode body)
    {
        this.body = body;
    }

    /**
     * Performs visitation for this node's children.
     * @param visitor The visitor to visit this node's children.
     */
    @Override
    protected void receiveToChildren(BsjNodeVisitor visitor)
    {
        
    }
}
