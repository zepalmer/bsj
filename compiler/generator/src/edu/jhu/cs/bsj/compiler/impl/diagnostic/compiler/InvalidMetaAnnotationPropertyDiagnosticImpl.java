package edu.jhu.cs.bsj.compiler.impl.diagnostic.compiler;

import java.util.List;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.diagnostic.compiler.InvalidMetaAnnotationPropertyDiagnostic;


/**
 * A diagnostic which represents some problem with a meta-annotation's properties.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public abstract class InvalidMetaAnnotationPropertyDiagnosticImpl extends InvalidMetaAnnotationDiagnosticImpl implements InvalidMetaAnnotationPropertyDiagnostic
{
    /** The name of the property with which there is a problem. */
    private String propertyName;
    
    public InvalidMetaAnnotationPropertyDiagnosticImpl(
            BsjSourceLocation source,
            String code,
            javax.tools.Diagnostic.Kind kind,
            String propertyName)
    {
        super(source, code, kind);
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
    protected List<Object> getMessageArgs()
    {
        List<Object> args = super.getMessageArgs();
        args.add(this.propertyName);
        return args;
    }
}
