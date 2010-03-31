package edu.jhu.cs.bsj.compiler.impl.diagnostic.compiler;

import java.util.List;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.diagnostic.compiler.MetaAnnotationClassTypeMismatchDiagnostic;
import edu.jhu.cs.bsj.compiler.metaannotation.BsjMetaAnnotation;


/**
 * A diagnostic indicating that a meta-annotation refers to a class which does not implement the
 * {@link BsjMetaAnnotation} interface.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class MetaAnnotationClassTypeMismatchDiagnosticImpl extends InvalidMetaAnnotationDefinitionDiagnosticImpl implements MetaAnnotationClassTypeMismatchDiagnostic
{
    /** A string naming the class that was used. */
    private String className;
    
    public MetaAnnotationClassTypeMismatchDiagnosticImpl(
            BsjSourceLocation source,
            Class<? extends BsjMetaAnnotation> metaAnnotationClass,
            String className)
    {
        super(source, MetaAnnotationClassTypeMismatchDiagnostic.CODE, Kind.ERROR, metaAnnotationClass);
        this.className = className;
    }
    
    /**
     * {@inheritDoc}
     */
    public String getClassName()
    {
        return this.className;
    }
    
    @Override
    protected List<Object> getMessageArgs()
    {
        List<Object> args = super.getMessageArgs();
        args.add(this.className);
        return args;
    }
}
