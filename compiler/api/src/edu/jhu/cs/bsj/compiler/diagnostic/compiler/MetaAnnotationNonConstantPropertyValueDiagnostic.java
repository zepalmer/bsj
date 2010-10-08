/*
 * WARNING: THIS FILE IS GENERATED.  Do not make any changes to this file
 * directly; it was generated from the BSJ source generator project.  If changes
 * are necessary, changes must be applied either to the source generator
 * application or to one of its data files.  The source generator's fully
 * qualified name is edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator.
 */

package edu.jhu.cs.bsj.compiler.diagnostic.compiler;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.node.Node;
/**
 * A diagnostic indicating that the value provided for a property on a meta-annotation is not a
 * constant expression.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface MetaAnnotationNonConstantPropertyValueDiagnostic extends InvalidMetaAnnotationPropertyDiagnostic
{
    /** The code for this diagnostic. */
    public static final String CODE = "bsj.compiler.metaAnnotation.property.nonconstant";
    
    /**
     * Retrieves the node representing the top of the problematic value.
     * @return The node representing the top of the problematic value.
     */
    public Node getValue();
    
    /**
     * Retrieves the node representing the non-constant portion of the expression.
     * @return The node representing the non-constant portion of the expression.
     */
    public Node getNode();
    
}
