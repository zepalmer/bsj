package edu.jhu.cs.bsj.compiler.impl.diagnostic.compiler;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.diagnostic.compiler.InvalidMetaAnnotationMethodReturnTypeDiagnostic;
import edu.jhu.cs.bsj.compiler.diagnostic.compiler.MetaAnnotationMethodType;
import edu.jhu.cs.bsj.compiler.impl.utils.Pair;
import edu.jhu.cs.bsj.compiler.metaannotation.BsjMetaAnnotation;


/**
 * A diagnostic indicating that the return type of a meta-annotation getter or setter method is incorrect.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class InvalidMetaAnnotationMethodReturnTypeDiagnosticImpl extends InvalidMetaAnnotationMethodDiagnosticImpl implements InvalidMetaAnnotationMethodReturnTypeDiagnostic
{
    public InvalidMetaAnnotationMethodReturnTypeDiagnosticImpl(
            BsjSourceLocation source,
            Class<? extends BsjMetaAnnotation> metaAnnotationClass,
            MetaAnnotationMethodType methodType,
            String methodName)
    {
        super(source, InvalidMetaAnnotationMethodReturnTypeDiagnostic.CODE, Kind.ERROR, metaAnnotationClass, methodType, methodName);
    }
    
    @Override
    protected Pair<List<Object>,Map<String,Integer>> getMessageArgs(Locale locale)
    {
        Pair<List<Object>,Map<String,Integer>> args = super.getMessageArgs(locale);
        return args;
    }
    
}
