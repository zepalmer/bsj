package edu.jhu.cs.bsj.compiler.impl.diagnostic.compiler;

import java.util.List;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.diagnostic.compiler.InvalidMetaAnnotationDiagnostic;
import edu.jhu.cs.bsj.compiler.metaannotation.BsjMetaAnnotation;


/**
 * A diagnostic which represents some problem in the use of a meta-annotation.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public abstract class InvalidMetaAnnotationDiagnosticImpl extends BsjCompilerDiagnosticImpl implements InvalidMetaAnnotationDiagnostic
{
    /** The type of the meta-annotation. */
    private Class<? extends BsjMetaAnnotation> metaAnnotationClass;
    
    public InvalidMetaAnnotationDiagnosticImpl(
            BsjSourceLocation source,
            String code,
            javax.tools.Diagnostic.Kind kind,
            Class<? extends BsjMetaAnnotation> metaAnnotationClass)
    {
        super(source, code, kind);
        this.metaAnnotationClass = metaAnnotationClass;
    }
    
    /**
     * {@inheritDoc}
     */
    public Class<? extends BsjMetaAnnotation> getMetaAnnotationClass()
    {
        return this.metaAnnotationClass;
    }
    
    @Override
    protected List<Object> getMessageArgs()
    {
        List<Object> args = super.getMessageArgs();
        args.add(this.metaAnnotationClass);
        return args;
    }
}
