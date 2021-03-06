/*
 * WARNING: THIS FILE IS GENERATED.  Do not make any changes to this file
 * directly; it was generated from the BSJ source generator project.  If changes
 * are necessary, changes must be applied either to the source generator
 * application or to one of its data files.  The source generator's fully
 * qualified name is edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator.
 */

package edu.jhu.cs.bsj.stdlib.diagnostic;

import java.util.List;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.node.Node;
/**
 * Indicates that the meta-annotation cannot be used on the specified type of node.  The
 * <code>annotatedNode</code> field is a hint and may be <code>null</code>.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface InvalidAnnotatedDeclarationDiagnostic extends InvalidMetaAnnotationUseDiagnostic
{
    /** The code for this diagnostic. */
    public static final String CODE = "bsj.stdlib.metaannotation.invalid.declaration.type";
    
    /**
     * Retrieves the node that was annotated.
     * @return The node that was annotated.
     */
    public Node getAnnotatedNode();
    
    /**
     * Retrieves the legal types that could be annotated by the meta-annotation.
     * @return The legal types that could be annotated by the meta-annotation.
     */
    public List<Class<? extends Node>> getLegalTypes();
    
}
