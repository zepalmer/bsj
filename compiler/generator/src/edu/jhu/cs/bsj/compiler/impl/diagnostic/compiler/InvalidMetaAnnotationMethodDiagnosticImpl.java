package edu.jhu.cs.bsj.compiler.impl.diagnostic.compiler;

import java.util.List;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.diagnostic.compiler.InvalidMetaAnnotationMethodDiagnostic;
import edu.jhu.cs.bsj.compiler.diagnostic.compiler.MetaAnnotationMethodType;


/**
 * A diagnostic which represents some problem in the definition of a meta-annotation type's getter or
 * setter methods.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public abstract class InvalidMetaAnnotationMethodDiagnosticImpl extends InvalidMetaAnnotationDiagnosticImpl implements InvalidMetaAnnotationMethodDiagnostic
{
    /** The type of method with which there is a problem. */
    private MetaAnnotationMethodType methodType;
    
    /** The name of the method with which there is a problem. */
    private String methodName;
    
    public InvalidMetaAnnotationMethodDiagnosticImpl(
            BsjSourceLocation source,
            String code,
            javax.tools.Diagnostic.Kind kind,
            MetaAnnotationMethodType methodType,
            String methodName)
    {
        super(source, code, kind);
        this.methodType = methodType;
        this.methodName = methodName;
    }
    
    /**
     * {@inheritDoc}
     */
    public MetaAnnotationMethodType getMethodType()
    {
        return this.methodType;
    }
    
    /**
     * {@inheritDoc}
     */
    public String getMethodName()
    {
        return this.methodName;
    }
    
    @Override
    protected List<Object> getMessageArgs()
    {
        List<Object> args = super.getMessageArgs();
        args.add(this.methodType);
        args.add(this.methodName);
        return args;
    }
}
