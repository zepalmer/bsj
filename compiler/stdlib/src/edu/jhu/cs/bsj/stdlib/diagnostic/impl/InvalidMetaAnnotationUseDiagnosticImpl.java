/*
 * WARNING: THIS FILE IS GENERATED.  Do not make any changes to this file
 * directly; it was generated from the BSJ source generator project.  If changes
 * are necessary, changes must be applied either to the source generator
 * application or to one of its data files.  The source generator's fully
 * qualified name is edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator.
 */

package edu.jhu.cs.bsj.stdlib.diagnostic.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.impl.utils.Pair;
import edu.jhu.cs.bsj.compiler.metaprogram.AbstractBsjMetaprogramMetaAnnotation;
import edu.jhu.cs.bsj.stdlib.diagnostic.InvalidMetaAnnotationUseDiagnostic;


/**
 * A diagnostic indicating that a meta-annotation is used incorrectly.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public abstract class InvalidMetaAnnotationUseDiagnosticImpl extends BsjUtilDiagnosticImpl implements InvalidMetaAnnotationUseDiagnostic
{
    /** The class of meta-annotation that was used incorrectly. */
    private Class<? extends AbstractBsjMetaprogramMetaAnnotation> metaAnnotationClass;
    
    public InvalidMetaAnnotationUseDiagnosticImpl(
            String code,
            javax.tools.Diagnostic.Kind kind,
            Class<? extends AbstractBsjMetaprogramMetaAnnotation> metaAnnotationClass)
    {
        super(code, kind);
        this.metaAnnotationClass = metaAnnotationClass;
    }
    
    /**
     * {@inheritDoc}
     */
    public Class<? extends AbstractBsjMetaprogramMetaAnnotation> getMetaAnnotationClass()
    {
        return this.metaAnnotationClass;
    }
    
    @Override
    protected Pair<List<Object>,Map<String,Integer>> getMessageArgs(Locale locale)
    {
        Pair<List<Object>,Map<String,Integer>> args = new Pair<List<Object>,Map<String,Integer>>(new ArrayList<Object>(), new HashMap<String,Integer>());
        args.getFirst().add(this.metaAnnotationClass);
        args.getSecond().put("metaAnnotationClass", args.getFirst().size());
        return args;
    }
    
}
