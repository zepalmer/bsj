package edu.jhu.cs.bsj.compiler.impl.diagnostic.compiler;

import java.util.List;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.diagnostic.compiler.InvalidMetaAnnotationArrayInitializerDiagnostic;


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
    protected List<Object> getMessageArgs()
    {
        List<Object> args = super.getMessageArgs();
        return args;
    }
}
