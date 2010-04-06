package edu.jhu.cs.bsj.compiler.impl.diagnostic.compiler;

import java.util.List;
import java.util.Locale;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.diagnostic.compiler.UninstantiableMetaAnnotationDiagnostic;
import edu.jhu.cs.bsj.compiler.metaannotation.BsjMetaAnnotation;


/**
 * A diagnostic indicating that a meta-annotation was used which is non-instantiable.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public abstract class UninstantiableMetaAnnotationDiagnosticImpl extends InvalidMetaAnnotationDefinitionDiagnosticImpl implements UninstantiableMetaAnnotationDiagnostic
{
    public UninstantiableMetaAnnotationDiagnosticImpl(
            BsjSourceLocation source,
            String code,
            javax.tools.Diagnostic.Kind kind,
            Class<? extends BsjMetaAnnotation> metaAnnotationClass)
    {
        super(source, code, kind, metaAnnotationClass);
    }
    
    @Override
    protected List<Object> getMessageArgs(Locale locale)
    {
        List<Object> args = super.getMessageArgs(locale);
        return args;
    }
    
}
