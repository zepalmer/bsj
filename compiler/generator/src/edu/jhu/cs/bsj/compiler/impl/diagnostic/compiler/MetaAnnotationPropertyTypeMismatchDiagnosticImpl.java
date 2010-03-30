package edu.jhu.cs.bsj.compiler.impl.diagnostic.compiler;

import java.util.List;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.diagnostic.compiler.MetaAnnotationPropertyTypeMismatchDiagnostic;


/**
 * A diagnostic indicating that the return type of a property's getter is not assignable from the
 * argument of the property's setter.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class MetaAnnotationPropertyTypeMismatchDiagnosticImpl extends InvalidMetaAnnotationPropertyDiagnosticImpl implements MetaAnnotationPropertyTypeMismatchDiagnostic
{
    public MetaAnnotationPropertyTypeMismatchDiagnosticImpl(
            BsjSourceLocation source,
            String propertyName)
    {
        super(source, MetaAnnotationPropertyTypeMismatchDiagnostic.CODE, Kind.ERROR, propertyName);
    }
    
    @Override
    protected List<Object> getMessageArgs()
    {
        List<Object> args = super.getMessageArgs();
        return args;
    }
}
