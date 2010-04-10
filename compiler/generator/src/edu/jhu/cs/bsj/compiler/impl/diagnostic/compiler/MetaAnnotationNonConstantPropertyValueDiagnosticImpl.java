package edu.jhu.cs.bsj.compiler.impl.diagnostic.compiler;

import java.util.List;
import java.util.Locale;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.diagnostic.compiler.MetaAnnotationNonConstantPropertyValueDiagnostic;
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
    protected List<Object> getMessageArgs(Locale locale)
    {
        List<Object> args = super.getMessageArgs(locale);
        args.add(this.value);
        args.add(this.node);
        return args;
    }
    
}
