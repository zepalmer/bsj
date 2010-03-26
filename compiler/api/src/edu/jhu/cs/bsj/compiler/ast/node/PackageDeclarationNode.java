package edu.jhu.cs.bsj.compiler.ast.node;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
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
public interface PackageDeclarationNode extends Node
{
    /**
     * Gets the name of the package.
     * @return The name of the package.
     */
    public NameNode getName();
    
    /**
     * Changes the name of the package.
     * @param name The name of the package.
     */
    public void setName(NameNode name);
    
    /**
     * Gets the meta-annotations on the package declaration.
     * @return The meta-annotations on the package declaration.
     */
    public MetaAnnotationListNode getMetaAnnotations();
    
    /**
     * Changes the meta-annotations on the package declaration.
     * @param metaAnnotations The meta-annotations on the package declaration.
     */
    public void setMetaAnnotations(MetaAnnotationListNode metaAnnotations);
    
    /**
     * Gets the annotations on the package declaration.
     * @return The annotations on the package declaration.
     */
    public AnnotationListNode getAnnotations();
    
    /**
     * Changes the annotations on the package declaration.
     * @param annotations The annotations on the package declaration.
     */
    public void setAnnotations(AnnotationListNode annotations);
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public PackageDeclarationNode deepCopy(BsjNodeFactory factory);
}
