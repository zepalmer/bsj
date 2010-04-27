package edu.jhu.cs.bsj.compiler.impl.diagnostic.compiler;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.diagnostic.compiler.MissingMetaAnnotationClassDiagnostic;
import edu.jhu.cs.bsj.compiler.impl.utils.Pair;
import edu.jhu.cs.bsj.compiler.metaannotation.BsjMetaAnnotation;


/**
 * A diagnostic indicating that a meta-annotation refers to a class which does not exist on the
 * metaprogram classpath at runtime.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class MissingMetaAnnotationClassDiagnosticImpl extends UninstantiableMetaAnnotationDiagnosticImpl implements MissingMetaAnnotationClassDiagnostic
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
    protected Pair<List<Object>,Map<String,Integer>> getMessageArgs(Locale locale)
    {
        Pair<List<Object>,Map<String,Integer>> args = super.getMessageArgs(locale);
        args.getFirst().add(this.className);
        args.getSecond().put("className", args.getFirst().size());
        return args;
    }
    
}
