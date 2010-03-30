package edu.jhu.cs.bsj.compiler.impl.diagnostic.compiler;

import java.util.List;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.diagnostic.compiler.InvalidMetaAnnotationMethodReturnTypeDiagnostic;
import edu.jhu.cs.bsj.compiler.diagnostic.compiler.MetaAnnotationMethodType;


/**
 * A diagnostic indicating that the return type of a meta-annotation getter or setter method is incorrect.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class InvalidMetaAnnotationMethodReturnTypeDiagnosticImpl extends InvalidMetaAnnotationMethodDiagnosticImpl implements InvalidMetaAnnotationMethodReturnTypeDiagnostic
{
    public InvalidMetaAnnotationMethodReturnTypeDiagnosticImpl(
            BsjSourceLocation source,
            MetaAnnotationMethodType methodType,
            String methodName)
    {
        super(source, InvalidMetaAnnotationMethodReturnTypeDiagnostic.CODE, Kind.ERROR, methodType, methodName);
    }
    
    @Override
    protected List<Object> getMessageArgs()
    {
        List<Object> args = super.getMessageArgs();
        return args;
    }
}
