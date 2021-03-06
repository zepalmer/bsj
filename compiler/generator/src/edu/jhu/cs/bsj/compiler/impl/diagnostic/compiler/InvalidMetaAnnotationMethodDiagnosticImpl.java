/*
 * WARNING: THIS FILE IS GENERATED.  Do not make any changes to this file
 * directly; it was generated from the BSJ source generator project.  If changes
 * are necessary, changes must be applied either to the source generator
 * application or to one of its data files.  The source generator's fully
 * qualified name is edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator.
 */

package edu.jhu.cs.bsj.compiler.impl.diagnostic.compiler;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.diagnostic.compiler.InvalidMetaAnnotationMethodDiagnostic;
import edu.jhu.cs.bsj.compiler.diagnostic.compiler.MetaAnnotationMethodType;
import edu.jhu.cs.bsj.compiler.impl.utils.Pair;
import edu.jhu.cs.bsj.compiler.metaannotation.BsjMetaAnnotation;


/**
 * A diagnostic which represents some problem in the definition of a meta-annotation type's getter or
 * setter methods.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public abstract class InvalidMetaAnnotationMethodDiagnosticImpl extends InvalidMetaAnnotationDefinitionDiagnosticImpl implements InvalidMetaAnnotationMethodDiagnostic
{
    /** The type of method with which there is a problem. */
    private MetaAnnotationMethodType methodType;
    
    /** The name of the method with which there is a problem. */
    private String methodName;
    
    public InvalidMetaAnnotationMethodDiagnosticImpl(
            BsjSourceLocation source,
            String code,
            javax.tools.Diagnostic.Kind kind,
            Class<? extends BsjMetaAnnotation> metaAnnotationClass,
            MetaAnnotationMethodType methodType,
            String methodName)
    {
        super(source, code, kind, metaAnnotationClass);
        this.methodType = methodType;
        this.methodName = methodName;
    }
    
    /**
     * {@inheritDoc}
     */
    public MetaAnnotationMethodType getMethodType()
    {
        return this.methodType;
    }
    
    /**
     * {@inheritDoc}
     */
    public String getMethodName()
    {
        return this.methodName;
    }
    
    @Override
    protected Pair<List<Object>,Map<String,Integer>> getMessageArgs(Locale locale)
    {
        Pair<List<Object>,Map<String,Integer>> args = super.getMessageArgs(locale);
        args.getFirst().add(this.methodType);
        args.getSecond().put("methodType", args.getFirst().size());
        args.getFirst().add(this.methodName);
        args.getSecond().put("methodName", args.getFirst().size());
        args.getFirst().add(methodType.getCode());
        args.getSecond().put("methodTypeCode", args.getFirst().size());
        return args;
    }
    
}
