package edu.jhu.cs.bsj.compiler.impl.diagnostic.compiler;

import java.util.List;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.diagnostic.compiler.MetaAnnotationMissingPropertyDiagnostic;
import edu.jhu.cs.bsj.compiler.metaannotation.BsjMetaAnnotation;
import edu.jhu.cs.bsj.compiler.metaannotation.BsjMetaAnnotationElementGetter;
import edu.jhu.cs.bsj.compiler.metaannotation.BsjMetaAnnotationElementSetter;


/**
 * A diagnostic indicating that a property was used on the invocation of a meta-annotation which did
 * not appear on the definition of the meta-annotation.  This may be because no getter or setter
 * methods exist for that property or because those getter or setter methods are not properly annotated
 * with {@link BsjMetaAnnotationElementGetter} and  {@link BsjMetaAnnotationElementSetter}.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class MetaAnnotationMissingPropertyDiagnosticImpl extends InvalidMetaAnnotationPropertyDiagnosticImpl implements MetaAnnotationMissingPropertyDiagnostic
{
    public MetaAnnotationMissingPropertyDiagnosticImpl(
            BsjSourceLocation source,
            Class<? extends BsjMetaAnnotation> metaAnnotationClass,
            String propertyName)
    {
        super(source, MetaAnnotationMissingPropertyDiagnostic.CODE, Kind.ERROR, metaAnnotationClass, propertyName);
    }
    
    @Override
    protected List<Object> getMessageArgs()
    {
        List<Object> args = super.getMessageArgs();
        return args;
    }
}
