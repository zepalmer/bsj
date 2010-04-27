package edu.jhu.cs.bsj.compiler.impl.diagnostic.compiler;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.diagnostic.compiler.InvalidMetaAnnotationPropertyDiagnostic;
import edu.jhu.cs.bsj.compiler.impl.utils.Pair;
import edu.jhu.cs.bsj.compiler.metaannotation.BsjMetaAnnotation;


/**
 * A diagnostic which represents some problem with a meta-annotation's properties.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public abstract class InvalidMetaAnnotationPropertyDiagnosticImpl extends InvalidMetaAnnotationDefinitionDiagnosticImpl implements InvalidMetaAnnotationPropertyDiagnostic
{
    /** The name of the property with which there is a problem. */
    private String propertyName;
    
    public InvalidMetaAnnotationPropertyDiagnosticImpl(
            BsjSourceLocation source,
            String code,
            javax.tools.Diagnostic.Kind kind,
            Class<? extends BsjMetaAnnotation> metaAnnotationClass,
            String propertyName)
    {
        super(source, code, kind, metaAnnotationClass);
        this.propertyName = propertyName;
    }
    
    /**
     * {@inheritDoc}
     */
    public String getPropertyName()
    {
        return this.propertyName;
    }
    
    @Override
    protected Pair<List<Object>,Map<String,Integer>> getMessageArgs(Locale locale)
    {
        Pair<List<Object>,Map<String,Integer>> args = super.getMessageArgs(locale);
        args.getFirst().add(this.propertyName);
        args.getSecond().put("propertyName", args.getFirst().size());
        return args;
    }
    
}
