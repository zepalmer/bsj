package edu.jhu.cs.bsj.compiler.impl.diagnostic.compiler;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.diagnostic.compiler.MetaAnnotationMethodType;
import edu.jhu.cs.bsj.compiler.diagnostic.compiler.MetaAnnotationPropertyMissingMethodDiagnostic;
import edu.jhu.cs.bsj.compiler.impl.utils.Pair;
import edu.jhu.cs.bsj.compiler.metaannotation.BsjMetaAnnotation;


/**
 * A diagnostic indicating that a property's getter or setter is missing.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class MetaAnnotationPropertyMissingMethodDiagnosticImpl extends InvalidMetaAnnotationPropertyDiagnosticImpl implements MetaAnnotationPropertyMissingMethodDiagnostic
{
    /** The type of method missing. */
    private MetaAnnotationMethodType methodType;
    
    public MetaAnnotationPropertyMissingMethodDiagnosticImpl(
            BsjSourceLocation source,
            Class<? extends BsjMetaAnnotation> metaAnnotationClass,
            String propertyName,
            MetaAnnotationMethodType methodType)
    {
        super(source, MetaAnnotationPropertyMissingMethodDiagnostic.CODE, Kind.ERROR, metaAnnotationClass, propertyName);
        this.methodType = methodType;
    }
    
    /**
     * {@inheritDoc}
     */
    public MetaAnnotationMethodType getMethodType()
    {
        return this.methodType;
    }
    
    @Override
    protected Pair<List<Object>,Map<String,Integer>> getMessageArgs(Locale locale)
    {
        Pair<List<Object>,Map<String,Integer>> args = super.getMessageArgs(locale);
        args.getFirst().add(this.methodType);
        args.getSecond().put("methodType", args.getFirst().size());
        args.getFirst().add(methodType.getCode());
        args.getSecond().put("methodTypeCode", args.getFirst().size());
        return args;
    }
    
}
