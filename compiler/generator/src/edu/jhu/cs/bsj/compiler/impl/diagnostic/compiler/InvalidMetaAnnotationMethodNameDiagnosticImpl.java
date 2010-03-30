package edu.jhu.cs.bsj.compiler.impl.diagnostic.compiler;

import java.util.List;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.diagnostic.compiler.InvalidMetaAnnotationMethodNameDiagnostic;
import edu.jhu.cs.bsj.compiler.diagnostic.compiler.MetaAnnotationMethodNameErrorType;
import edu.jhu.cs.bsj.compiler.diagnostic.compiler.MetaAnnotationMethodType;


/**
 * A diagnostic indicating that the name of a meta-annotation getter or setter method is invalid.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class InvalidMetaAnnotationMethodNameDiagnosticImpl extends InvalidMetaAnnotationMethodDiagnosticImpl implements InvalidMetaAnnotationMethodNameDiagnostic
{
    /** The type of error that occurred. */
    private MetaAnnotationMethodNameErrorType methodNameError;
    
    public InvalidMetaAnnotationMethodNameDiagnosticImpl(
            BsjSourceLocation source,
            MetaAnnotationMethodType methodType,
            String methodName,
            MetaAnnotationMethodNameErrorType methodNameError)
    {
        super(source, InvalidMetaAnnotationMethodNameDiagnostic.CODE, Kind.ERROR, methodType, methodName);
        this.methodNameError = methodNameError;
    }
    
    /**
     * {@inheritDoc}
     */
    public MetaAnnotationMethodNameErrorType getMethodNameError()
    {
        return this.methodNameError;
    }
    
    @Override
    protected List<Object> getMessageArgs()
    {
        List<Object> args = super.getMessageArgs();
        args.add(this.methodNameError);
        return args;
    }
}
