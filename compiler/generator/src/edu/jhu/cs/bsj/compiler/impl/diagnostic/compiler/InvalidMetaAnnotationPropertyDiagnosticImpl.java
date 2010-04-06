package edu.jhu.cs.bsj.compiler.impl.diagnostic.compiler;

import java.util.List;
import java.util.Locale;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.diagnostic.compiler.InvalidMetaAnnotationPropertyDiagnostic;
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
    protected List<Object> getMessageArgs(Locale locale)
    {
        List<Object> args = super.getMessageArgs(locale);
        args.add(this.propertyName);
        return args;
    }
    
}
