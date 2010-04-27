package edu.jhu.cs.bsj.compiler.impl.diagnostic.compiler;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.diagnostic.compiler.InvalidMetaAnnotationDefinitionDiagnostic;
import edu.jhu.cs.bsj.compiler.impl.utils.Pair;
import edu.jhu.cs.bsj.compiler.metaannotation.BsjMetaAnnotation;


/**
 * A diagnostic which represents some problem in the definition of a meta-annotation.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public abstract class InvalidMetaAnnotationDefinitionDiagnosticImpl extends BsjCompilerDiagnosticImpl implements InvalidMetaAnnotationDefinitionDiagnostic
{
    /** The type of the meta-annotation. */
    private Class<? extends BsjMetaAnnotation> metaAnnotationClass;
    
    public InvalidMetaAnnotationDefinitionDiagnosticImpl(
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
    protected Pair<List<Object>,Map<String,Integer>> getMessageArgs(Locale locale)
    {
        Pair<List<Object>,Map<String,Integer>> args = super.getMessageArgs(locale);
        args.getFirst().add(this.metaAnnotationClass);
        args.getSecond().put("metaAnnotationClass", args.getFirst().size());
        return args;
    }
    
}
