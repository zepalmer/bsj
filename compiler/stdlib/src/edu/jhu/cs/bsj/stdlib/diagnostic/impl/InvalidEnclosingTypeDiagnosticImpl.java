package edu.jhu.cs.bsj.stdlib.diagnostic.impl;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.annotation.Generated;
import javax.tools.Diagnostic.Kind;

import edu.jhu.cs.bsj.compiler.ast.node.TypeDeclarationNode;
import edu.jhu.cs.bsj.compiler.impl.utils.Pair;
import edu.jhu.cs.bsj.compiler.metaprogram.AbstractBsjMetaAnnotationMetaprogram;
import edu.jhu.cs.bsj.stdlib.diagnostic.InvalidEnclosingTypeDiagnostic;


/**
 * Indicates that the meta-annotation cannot be used in the enclosing type in which it is found.  The
 * <code>enclosingNode</code> field is a hint and may be <code>null</code> (especially if the
 * meta-annotation is attached to a code fragment and not a descendent of the root package).
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class InvalidEnclosingTypeDiagnosticImpl extends InvalidMetaAnnotationUseDiagnosticImpl implements InvalidEnclosingTypeDiagnostic
{
    /** The enclosing type declaration. */
    private TypeDeclarationNode node;
    
    /** The legal types that could be annotated by the meta-annotation. */
    private List<Class<? extends TypeDeclarationNode>> legalTypes;
    
    public InvalidEnclosingTypeDiagnosticImpl(
            Class<? extends AbstractBsjMetaAnnotationMetaprogram> metaAnnotationClass,
            TypeDeclarationNode node,
            List<Class<? extends TypeDeclarationNode>> legalTypes)
    {
        super(InvalidEnclosingTypeDiagnostic.CODE, Kind.ERROR, metaAnnotationClass);
        this.node = node;
        this.legalTypes = legalTypes;
    }
    
    /**
     * {@inheritDoc}
     */
    public TypeDeclarationNode getNode()
    {
        return this.node;
    }
    
    /**
     * {@inheritDoc}
     */
    public List<Class<? extends TypeDeclarationNode>> getLegalTypes()
    {
        return this.legalTypes;
    }
    
    @Override
    protected Pair<List<Object>,Map<String,Integer>> getMessageArgs(Locale locale)
    {
        Pair<List<Object>,Map<String,Integer>> args = super.getMessageArgs(locale);
        args.getFirst().add(this.node);
        args.getSecond().put("node", args.getFirst().size());
        args.getFirst().add(this.legalTypes);
        args.getSecond().put("legalTypes", args.getFirst().size());
        args.getFirst().add(node!=null?node.getClass().getName():null);
        args.getSecond().put("enclosingTypeName", args.getFirst().size());
        return args;
    }
    
}
