package edu.jhu.cs.bsj.stdlib.diagnostic;

import java.util.List;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.node.TypeDeclarationNode;
/**
 * Indicates that the meta-annotation cannot be used in the enclosing type in which it is found.  The
 * <code>enclosingNode</code> field is a hint and may be <code>null</code> (especially if the
 * meta-annotation is attached to a code fragment and not a descendent of the root package).
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface InvalidEnclosingTypeDiagnostic extends InvalidMetaAnnotationUseDiagnostic
{
    /** The code for this diagnostic. */
    public static final String CODE = "bsj.stdlib.metaannotation.invalid.enclosing.type";
    
    /**
     * Retrieves the enclosing type declaration.
     * @return The enclosing type declaration.
     */
    public TypeDeclarationNode getNode();
    
    /**
     * Retrieves the legal types that could be annotated by the meta-annotation.
     * @return The legal types that could be annotated by the meta-annotation.
     */
    public List<Class<? extends TypeDeclarationNode>> getLegalTypes();
    
}
