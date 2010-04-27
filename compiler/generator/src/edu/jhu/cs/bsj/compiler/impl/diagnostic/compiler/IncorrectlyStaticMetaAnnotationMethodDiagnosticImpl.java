package edu.jhu.cs.bsj.compiler.impl.diagnostic.compiler;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.diagnostic.compiler.IncorrectlyStaticMetaAnnotationMethodDiagnostic;
import edu.jhu.cs.bsj.compiler.diagnostic.compiler.MetaAnnotationMethodType;
import edu.jhu.cs.bsj.compiler.impl.utils.Pair;
import edu.jhu.cs.bsj.compiler.metaannotation.BsjMetaAnnotation;


/**
 * A diagnostic indicating that the specified method was static when it should not be.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class IncorrectlyStaticMetaAnnotationMethodDiagnosticImpl extends InvalidMetaAnnotationMethodDiagnosticImpl implements IncorrectlyStaticMetaAnnotationMethodDiagnostic
{
    public IncorrectlyStaticMetaAnnotationMethodDiagnosticImpl(
            BsjSourceLocation source,
            Class<? extends BsjMetaAnnotation> metaAnnotationClass,
            MetaAnnotationMethodType methodType,
            String methodName)
    {
        super(source, IncorrectlyStaticMetaAnnotationMethodDiagnostic.CODE, Kind.ERROR, metaAnnotationClass, methodType, methodName);
    }
    
    @Override
    protected Pair<List<Object>,Map<String,Integer>> getMessageArgs(Locale locale)
    {
        Pair<List<Object>,Map<String,Integer>> args = super.getMessageArgs(locale);
        return args;
    }
    
}
