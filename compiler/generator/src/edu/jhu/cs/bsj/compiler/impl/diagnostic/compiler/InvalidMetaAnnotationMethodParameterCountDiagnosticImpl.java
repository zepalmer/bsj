package edu.jhu.cs.bsj.compiler.impl.diagnostic.compiler;

import java.util.List;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.diagnostic.compiler.InvalidMetaAnnotationMethodParameterCountDiagnostic;
import edu.jhu.cs.bsj.compiler.diagnostic.compiler.MetaAnnotationMethodType;


/**
 * A diagnostic indicating that the number of parameters to a meta-annotation getter or setter method
 * is incorrect.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class InvalidMetaAnnotationMethodParameterCountDiagnosticImpl extends InvalidMetaAnnotationMethodDiagnosticImpl implements InvalidMetaAnnotationMethodParameterCountDiagnostic
{
    /** The number of parameters expected. */
    private int expectedCount;
    
    /** The number of parameters observed. */
    private int observedCount;
    
    public InvalidMetaAnnotationMethodParameterCountDiagnosticImpl(
            BsjSourceLocation source,
            MetaAnnotationMethodType methodType,
            String methodName,
            int expectedCount,
            int observedCount)
    {
        super(source, InvalidMetaAnnotationMethodParameterCountDiagnostic.CODE, Kind.ERROR, methodType, methodName);
        this.expectedCount = expectedCount;
        this.observedCount = observedCount;
    }
    
    /**
     * {@inheritDoc}
     */
    public int getExpectedCount()
    {
        return this.expectedCount;
    }
    
    /**
     * {@inheritDoc}
     */
    public int getObservedCount()
    {
        return this.observedCount;
    }
    
    @Override
    protected List<Object> getMessageArgs()
    {
        List<Object> args = super.getMessageArgs();
        args.add(this.expectedCount);
        args.add(this.observedCount);
        return args;
    }
}