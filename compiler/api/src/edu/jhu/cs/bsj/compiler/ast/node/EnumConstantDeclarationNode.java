package edu.jhu.cs.bsj.compiler.ast.node;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaAnnotationListNode;

/**
 * A node representing an enum constant.  While enum constants typically consist of a single name, many optional
 * extensions exist.  In the likely case that this constant is not an anonymous subclass, <tt>body</tt> is
 * <tt>null</tt>.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface EnumConstantDeclarationNode extends Node, MetaAnnotatableNode
{
    /**
     * Gets the meta-annotations on this constant.
     * @return The meta-annotations on this constant.
     */
    public MetaAnnotationListNode getMetaAnnotations();
    
    /**
     * Changes the meta-annotations on this constant.
     * @param metaAnnotations The meta-annotations on this constant.
     */
    public void setMetaAnnotations(MetaAnnotationListNode metaAnnotations);
    
    /**
     * Gets the annotations on this constant.
     * @return The annotations on this constant.
     */
    public AnnotationListNode getAnnotations();
    
    /**
     * Changes the annotations on this constant.
     * @param annotations The annotations on this constant.
     */
    public void setAnnotations(AnnotationListNode annotations);
    
    /**
     * Gets the name of this constant.
     * @return The name of this constant.
     */
    public IdentifierNode getIdentifier();
    
    /**
     * Changes the name of this constant.
     * @param identifier The name of this constant.
     */
    public void setIdentifier(IdentifierNode identifier);
    
    /**
     * Gets the arguments to the enum constructor.
     * @return The arguments to the enum constructor.
     */
    public ExpressionListNode getArguments();
    
    /**
     * Changes the arguments to the enum constructor.
     * @param arguments The arguments to the enum constructor.
     */
    public void setArguments(ExpressionListNode arguments);
    
    /**
     * Gets the body used to anonymously subclass the constant.
     * @return The body used to anonymously subclass the constant.
     */
    public AnonymousClassBodyNode getBody();
    
    /**
     * Changes the body used to anonymously subclass the constant.
     * @param body The body used to anonymously subclass the constant.
     */
    public void setBody(AnonymousClassBodyNode body);
    
    /**
     * Gets the associated javadoc comment for this node.
     * @return The associated javadoc comment for this node.
     */
    public JavadocNode getJavadoc();
    
    /**
     * Changes the associated javadoc comment for this node.
     * @param javadoc The associated javadoc comment for this node.
     */
    public void setJavadoc(JavadocNode javadoc);
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public EnumConstantDeclarationNode deepCopy(BsjNodeFactory factory);
}
