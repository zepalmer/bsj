package edu.jhu.cs.bsj.stdlib.diagnostic.impl;

import java.util.List;
import java.util.Locale;

import javax.annotation.Generated;
import javax.tools.Diagnostic.Kind;

import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.metaprogram.AbstractBsjMetaAnnotationMetaprogram;
import edu.jhu.cs.bsj.stdlib.diagnostic.InvalidAnnotatedDeclaration;


/**
 * Indicates that the meta-annotation cannot be used on the specified type of node.  The
 * <code>annotatedNode</code> field is a hint and may be <code>null</code>.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class InvalidAnnotatedDeclarationImpl extends InvalidMetaAnnotationUseDiagnosticImpl implements InvalidAnnotatedDeclaration
{
    /** The node that was annotated. */
    private Node annotatedNode;
    
    /** The legal types that could be annotated by the meta-annotation. */
    private List<Class<? extends Node>> legalTypes;
    
    public InvalidAnnotatedDeclarationImpl(
            Class<? extends AbstractBsjMetaAnnotationMetaprogram> metaAnnotationClass,
            Node annotatedNode,
            List<Class<? extends Node>> legalTypes)
    {
        super(InvalidAnnotatedDeclaration.CODE, Kind.ERROR, metaAnnotationClass);
        this.annotatedNode = annotatedNode;
        this.legalTypes = legalTypes;
    }
    
    /**
     * {@inheritDoc}
     */
    public Node getAnnotatedNode()
    {
        return this.annotatedNode;
    }
    
    /**
     * {@inheritDoc}
     */
    public List<Class<? extends Node>> getLegalTypes()
    {
        return this.legalTypes;
    }
    
    @Override
    protected List<Object> getMessageArgs(Locale locale)
    {
        List<Object> args = super.getMessageArgs(locale);
        args.add(this.annotatedNode);
        args.add(this.legalTypes);
        args.add(annotatedNode!=null?annotatedNode.getClass().getName():null);
        return args;
    }
    
}
