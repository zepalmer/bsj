package edu.jhu.cs.bsj.compiler.ast.node;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;

/**
 * A node representing an annotation method declaration, as in:
 * <pre>
 *     <i>modifiers type identifier</i> () default <i>defaultValue</i>;
 * </pre>
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface AnnotationMethodDeclarationNode extends Node, AnnotationMemberNode, DeclarationNode
{
    /**
     * Gets the modifiers for this annotation method.
     * @return The modifiers for this annotation method.
     */
    public AnnotationMethodModifiersNode getModifiers();
    
    /**
     * Changes the modifiers for this annotation method.
     * @param modifiers The modifiers for this annotation method.
     */
    public void setModifiers(AnnotationMethodModifiersNode modifiers);
    
    /**
     * Gets the return type of this annotation method.
     * @return The return type of this annotation method.
     */
    public TypeNode getType();
    
    /**
     * Changes the return type of this annotation method.
     * @param type The return type of this annotation method.
     */
    public void setType(TypeNode type);
    
    /**
     * Gets this annotation method's name.
     * @return This annotation method's name.
     */
    public IdentifierNode getIdentifier();
    
    /**
     * Changes this annotation method's name.
     * @param identifier This annotation method's name.
     */
    public void setIdentifier(IdentifierNode identifier);
    
    /**
     * Gets the default value for this method.
     * @return The default value for this method.
     */
    public AnnotationValueNode getDefaultValue();
    
    /**
     * Changes the default value for this method.
     * @param defaultValue The default value for this method.
     */
    public void setDefaultValue(AnnotationValueNode defaultValue);
    
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
    public AnnotationMethodDeclarationNode deepCopy(BsjNodeFactory factory);
}
