package edu.jhu.cs.bsj.stdlib.diagnostic.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.metaprogram.AbstractBsjMetaAnnotationMetaprogram;
import edu.jhu.cs.bsj.stdlib.diagnostic.InvalidMetaAnnotationUseDiagnostic;


/**
 * A diagnostic indicating that a meta-annotation is used incorrectly.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public abstract class InvalidMetaAnnotationUseDiagnosticImpl extends BsjUtilDiagnosticImpl implements InvalidMetaAnnotationUseDiagnostic
{
    /** The class of meta-annotation that was used incorrectly. */
    private Class<? extends AbstractBsjMetaAnnotationMetaprogram> metaAnnotationClass;
    
    public InvalidMetaAnnotationUseDiagnosticImpl(
            String code,
            javax.tools.Diagnostic.Kind kind,
            Class<? extends AbstractBsjMetaAnnotationMetaprogram> metaAnnotationClass)
    {
        super(code, kind);
        this.metaAnnotationClass = metaAnnotationClass;
    }
    
    /**
     * {@inheritDoc}
     */
    public Class<? extends AbstractBsjMetaAnnotationMetaprogram> getMetaAnnotationClass()
    {
        return this.metaAnnotationClass;
    }
    
    @Override
    protected List<Object> getMessageArgs(Locale locale)
    {
        List<Object> args = new ArrayList<Object>();
        args.add(this.metaAnnotationClass);
        return args;
    }
    
}
