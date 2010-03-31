package edu.jhu.cs.bsj.compiler.impl.diagnostic.compiler;

import java.util.List;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.diagnostic.compiler.MissingMetaAnnotationClassDiagnostic;
import edu.jhu.cs.bsj.compiler.metaannotation.BsjMetaAnnotation;


/**
 * A diagnostic indicating that a meta-annotation refers to a class which does not exist on the
 * metaprogram classpath at runtime.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class MissingMetaAnnotationClassDiagnosticImpl extends InvalidMetaAnnotationDefinitionDiagnosticImpl implements MissingMetaAnnotationClassDiagnostic
{
    /** A string naming the class that was not found. */
    private String className;
    
    public MissingMetaAnnotationClassDiagnosticImpl(
            BsjSourceLocation source,
            Class<? extends BsjMetaAnnotation> metaAnnotationClass,
            String className)
    {
        super(source, MissingMetaAnnotationClassDiagnostic.CODE, Kind.ERROR, metaAnnotationClass);
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
