/*
 * WARNING: THIS FILE IS GENERATED.  Do not make any changes to this file
 * directly; it was generated from the BSJ source generator project.  If changes
 * are necessary, changes must be applied either to the source generator
 * application or to one of its data files.  The source generator's fully
 * qualified name is edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator.
 */

package edu.jhu.cs.bsj.compiler.impl.diagnostic.compiler;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.diagnostic.compiler.InvalidMetaAnnotationArrayInitializerDiagnostic;
import edu.jhu.cs.bsj.compiler.impl.utils.Pair;


/**
 * A diagnostic indicating that a meta-annotation's element is initialized with an array initializer
 * when its type is not an array type.  This may be the case if too many array types are nested, such
 * as using the code <tt>{{"a","b"},{"c"}}</tt> to initialize a <tt>String[]</tt> (and not a
 * <tt>String[][]</tt>).
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class InvalidMetaAnnotationArrayInitializerDiagnosticImpl extends BsjCompilerDiagnosticImpl implements InvalidMetaAnnotationArrayInitializerDiagnostic
{
    public InvalidMetaAnnotationArrayInitializerDiagnosticImpl(
            BsjSourceLocation source)
    {
        super(source, InvalidMetaAnnotationArrayInitializerDiagnostic.CODE, Kind.ERROR);
    }
    
    @Override
    protected Pair<List<Object>,Map<String,Integer>> getMessageArgs(Locale locale)
    {
        Pair<List<Object>,Map<String,Integer>> args = super.getMessageArgs(locale);
        return args;
    }
    
}
