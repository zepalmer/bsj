package edu.jhu.cs.bsj.compiler.impl.diagnostic.compiler;

import java.util.List;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.diagnostic.compiler.AbstractMetaAnnotationDiagnostic;
import edu.jhu.cs.bsj.compiler.metaannotation.BsjMetaAnnotation;


/**
 * A diagnostic indicating that a meta-annotation was used which is non-instantiable due to being an
 * abstract class.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class AbstractMetaAnnotationDiagnosticImpl extends UninstantiableMetaAnnotationDiagnosticImpl implements AbstractMetaAnnotationDiagnostic
{
    public AbstractMetaAnnotationDiagnosticImpl(
            BsjSourceLocation source,
            Class<? extends BsjMetaAnnotation> metaAnnotationClass)
    {
        super(source, AbstractMetaAnnotationDiagnostic.CODE, Kind.ERROR, metaAnnotationClass);
    }
    
    @Override
    protected List<Object> getMessageArgs()
    {
        List<Object> args = super.getMessageArgs();
        return args;
    }
}
