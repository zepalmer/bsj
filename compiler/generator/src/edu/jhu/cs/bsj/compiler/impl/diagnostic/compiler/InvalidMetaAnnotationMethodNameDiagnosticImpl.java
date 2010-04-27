package edu.jhu.cs.bsj.compiler.impl.diagnostic.compiler;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.diagnostic.compiler.InvalidMetaAnnotationMethodNameDiagnostic;
import edu.jhu.cs.bsj.compiler.diagnostic.compiler.MetaAnnotationMethodNameErrorType;
import edu.jhu.cs.bsj.compiler.diagnostic.compiler.MetaAnnotationMethodType;
import edu.jhu.cs.bsj.compiler.impl.utils.Pair;
import edu.jhu.cs.bsj.compiler.metaannotation.BsjMetaAnnotation;


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
            Class<? extends BsjMetaAnnotation> metaAnnotationClass,
            MetaAnnotationMethodType methodType,
            String methodName,
            MetaAnnotationMethodNameErrorType methodNameError)
    {
        super(source, InvalidMetaAnnotationMethodNameDiagnostic.CODE, Kind.ERROR, metaAnnotationClass, methodType, methodName);
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
    protected Pair<List<Object>,Map<String,Integer>> getMessageArgs(Locale locale)
    {
        Pair<List<Object>,Map<String,Integer>> args = super.getMessageArgs(locale);
        args.getFirst().add(this.methodNameError);
        args.getSecond().put("methodNameError", args.getFirst().size());
        return args;
    }
    
}
