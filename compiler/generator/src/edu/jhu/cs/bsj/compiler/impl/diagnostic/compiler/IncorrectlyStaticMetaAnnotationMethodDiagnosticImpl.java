package edu.jhu.cs.bsj.compiler.impl.diagnostic.compiler;

import java.util.List;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.diagnostic.compiler.IncorrectlyStaticMetaAnnotationMethodDiagnostic;
import edu.jhu.cs.bsj.compiler.diagnostic.compiler.MetaAnnotationMethodType;


/**
 * A diagnostic indicating that the specified method was static when it should not be.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class IncorrectlyStaticMetaAnnotationMethodDiagnosticImpl extends InvalidMetaAnnotationMethodDiagnosticImpl implements IncorrectlyStaticMetaAnnotationMethodDiagnostic
{
    public IncorrectlyStaticMetaAnnotationMethodDiagnosticImpl(
            BsjSourceLocation source,
            MetaAnnotationMethodType methodType,
            String methodName)
    {
        super(source, IncorrectlyStaticMetaAnnotationMethodDiagnostic.CODE, Kind.ERROR, methodType, methodName);
    }
    
    @Override
    protected List<Object> getMessageArgs()
    {
        List<Object> args = super.getMessageArgs();
        return args;
    }
}
