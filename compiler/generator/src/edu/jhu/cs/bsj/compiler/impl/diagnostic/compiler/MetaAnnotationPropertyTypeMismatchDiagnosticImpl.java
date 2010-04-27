package edu.jhu.cs.bsj.compiler.impl.diagnostic.compiler;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.diagnostic.compiler.MetaAnnotationPropertyTypeMismatchDiagnostic;
import edu.jhu.cs.bsj.compiler.impl.utils.Pair;
import edu.jhu.cs.bsj.compiler.metaannotation.BsjMetaAnnotation;


/**
 * A diagnostic indicating that the return type of a property's getter is not assignable from the
 * argument of the property's setter.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class MetaAnnotationPropertyTypeMismatchDiagnosticImpl extends InvalidMetaAnnotationPropertyDiagnosticImpl implements MetaAnnotationPropertyTypeMismatchDiagnostic
{
    public MetaAnnotationPropertyTypeMismatchDiagnosticImpl(
            BsjSourceLocation source,
            Class<? extends BsjMetaAnnotation> metaAnnotationClass,
            String propertyName)
    {
        super(source, MetaAnnotationPropertyTypeMismatchDiagnostic.CODE, Kind.ERROR, metaAnnotationClass, propertyName);
    }
    
    @Override
    protected Pair<List<Object>,Map<String,Integer>> getMessageArgs(Locale locale)
    {
        Pair<List<Object>,Map<String,Integer>> args = super.getMessageArgs(locale);
        return args;
    }
    
}
