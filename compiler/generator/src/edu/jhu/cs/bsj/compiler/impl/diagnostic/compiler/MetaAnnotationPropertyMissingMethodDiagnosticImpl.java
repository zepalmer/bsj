package edu.jhu.cs.bsj.compiler.impl.diagnostic.compiler;

import java.util.List;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.diagnostic.compiler.MetaAnnotationMethodType;
import edu.jhu.cs.bsj.compiler.diagnostic.compiler.MetaAnnotationPropertyMissingMethodDiagnostic;


/**
 * A diagnostic indicating that a property's getter or setter is missing.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class MetaAnnotationPropertyMissingMethodDiagnosticImpl extends InvalidMetaAnnotationPropertyDiagnosticImpl implements MetaAnnotationPropertyMissingMethodDiagnostic
{
    /** The type of method missing. */
    private MetaAnnotationMethodType methodType;
    
    public MetaAnnotationPropertyMissingMethodDiagnosticImpl(
            BsjSourceLocation source,
            String propertyName,
            MetaAnnotationMethodType methodType)
    {
        super(source, MetaAnnotationPropertyMissingMethodDiagnostic.CODE, Kind.ERROR, propertyName);
        this.methodType = methodType;
    }
    
    /**
     * {@inheritDoc}
     */
    public MetaAnnotationMethodType getMethodType()
    {
        return this.methodType;
    }
    
    @Override
    protected List<Object> getMessageArgs()
    {
        List<Object> args = super.getMessageArgs();
        args.add(this.methodType);
        return args;
    }
}
