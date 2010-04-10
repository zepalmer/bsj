package edu.jhu.cs.bsj.compiler.diagnostic.compiler;

import javax.annotation.Generated;
/**
 * A diagnostic indicating that a meta-annotation's element is initialized with an array initializer
 * when its type is not an array type.  This may be the case if too many array types are nested, such
 * as using the code <tt>{{"a","b"},{"c"}}</tt> to initialize a <tt>String[]</tt> (and not a
 * <tt>String[][]</tt>).
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface InvalidMetaAnnotationArrayInitializerDiagnostic extends BsjCompilerDiagnostic
{
    /** The code for this diagnostic. */
    public static final String CODE = "bsj.compiler.metaAnnotation.inappropriateArrayInitializer";
    
}
