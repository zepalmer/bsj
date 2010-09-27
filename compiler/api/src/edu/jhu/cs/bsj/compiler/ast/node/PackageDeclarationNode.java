package edu.jhu.cs.bsj.compiler.ast.node;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.NodeUnion;
import edu.jhu.cs.bsj.compiler.ast.node.list.AnnotationListNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaAnnotationListNode;

/**
 * A node representing a package declaration, as in
 * <pre>
 *     package <i>packageName</i>;
 * </pre>
 * or
 * <pre>
 *     <i>annotations</i>
 *     package <i>packageName</i>;
 * </pre>
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface PackageDeclarationNode extends Node, MetaAnnotatableNode, DeclarationNode
{
    /**
     * Gets the name of the package.
     * @return The name of the package.
     * @throws ClassCastException If the value of this property is a special node.
     */
    public NameNode getName() throws ClassCastException;
    
    /**
     * Gets the union object for the name of the package.
     * @return A union object representing The name of the package.
     */
    public NodeUnion<? extends NameNode> getUnionForName();
    
    /**
     * Changes the name of the package.
     * @param name The name of the package.
     */
    public void setName(NameNode name);
    
    /**
     * Changes the name of the package.
     * @param name The name of the package.
     * @throws NullPointerException If the provided value is <code>null</code>.
     *                              Node union values may have <code>null</code>
     *                              contents but are never <code>null</code>
     *                              themselves.
     */
    public void setUnionForName(NodeUnion<? extends NameNode> name) throws NullPointerException;
    
    /**
     * Gets the meta-annotations on the package declaration.
     * @return The meta-annotations on the package declaration.
     * @throws ClassCastException If the value of this property is a special node.
     */
    public MetaAnnotationListNode getMetaAnnotations() throws ClassCastException;
    
    /**
     * Gets the union object for the meta-annotations on the package declaration.
     * @return A union object representing The meta-annotations on the package declaration.
     */
    public NodeUnion<? extends MetaAnnotationListNode> getUnionForMetaAnnotations();
    
    /**
     * Changes the meta-annotations on the package declaration.
     * @param metaAnnotations The meta-annotations on the package declaration.
     */
    public void setMetaAnnotations(MetaAnnotationListNode metaAnnotations);
    
    /**
     * Changes the meta-annotations on the package declaration.
     * @param metaAnnotations The meta-annotations on the package declaration.
     * @throws NullPointerException If the provided value is <code>null</code>.
     *                              Node union values may have <code>null</code>
     *                              contents but are never <code>null</code>
     *                              themselves.
     */
    public void setUnionForMetaAnnotations(NodeUnion<? extends MetaAnnotationListNode> metaAnnotations) throws NullPointerException;
    
    /**
     * Gets the annotations on the package declaration.
     * @return The annotations on the package declaration.
     * @throws ClassCastException If the value of this property is a special node.
     */
    public AnnotationListNode getAnnotations() throws ClassCastException;
    
    /**
     * Gets the union object for the annotations on the package declaration.
     * @return A union object representing The annotations on the package declaration.
     */
    public NodeUnion<? extends AnnotationListNode> getUnionForAnnotations();
    
    /**
     * Changes the annotations on the package declaration.
     * @param annotations The annotations on the package declaration.
     */
    public void setAnnotations(AnnotationListNode annotations);
    
    /**
     * Changes the annotations on the package declaration.
     * @param annotations The annotations on the package declaration.
     * @throws NullPointerException If the provided value is <code>null</code>.
     *                              Node union values may have <code>null</code>
     *                              contents but are never <code>null</code>
     *                              themselves.
     */
    public void setUnionForAnnotations(NodeUnion<? extends AnnotationListNode> annotations) throws NullPointerException;
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public PackageDeclarationNode deepCopy(BsjNodeFactory factory);
    
}
