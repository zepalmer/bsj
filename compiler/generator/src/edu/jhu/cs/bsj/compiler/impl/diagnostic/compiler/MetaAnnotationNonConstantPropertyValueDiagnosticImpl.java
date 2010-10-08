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
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.diagnostic.compiler.MetaAnnotationNonConstantPropertyValueDiagnostic;
import edu.jhu.cs.bsj.compiler.impl.utils.Pair;
import edu.jhu.cs.bsj.compiler.metaannotation.BsjMetaAnnotation;


/**
 * A diagnostic indicating that the value provided for a property on a meta-annotation is not a
 * constant expression.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class MetaAnnotationNonConstantPropertyValueDiagnosticImpl extends InvalidMetaAnnotationPropertyDiagnosticImpl implements MetaAnnotationNonConstantPropertyValueDiagnostic
{
    /** The node representing the top of the problematic value. */
    private Node value;
    
    /** The node representing the non-constant portion of the expression. */
    private Node node;
    
    public MetaAnnotationNonConstantPropertyValueDiagnosticImpl(
            BsjSourceLocation source,
            Class<? extends BsjMetaAnnotation> metaAnnotationClass,
            String propertyName,
            Node value,
            Node node)
    {
        super(source, MetaAnnotationNonConstantPropertyValueDiagnostic.CODE, Kind.ERROR, metaAnnotationClass, propertyName);
        this.value = value;
        this.node = node;
    }
    
    /**
     * {@inheritDoc}
     */
    public Node getValue()
    {
        return this.value;
    }
    
    /**
     * {@inheritDoc}
     */
    public Node getNode()
    {
        return this.node;
    }
    
    @Override
    protected Pair<List<Object>,Map<String,Integer>> getMessageArgs(Locale locale)
    {
        Pair<List<Object>,Map<String,Integer>> args = super.getMessageArgs(locale);
        args.getFirst().add(this.value);
        args.getSecond().put("value", args.getFirst().size());
        args.getFirst().add(this.node);
        args.getSecond().put("node", args.getFirst().size());
        return args;
    }
    
}
