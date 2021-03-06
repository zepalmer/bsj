/*
 * WARNING: THIS FILE IS GENERATED.  Do not make any changes to this file
 * directly; it was generated from the BSJ source generator project.  If changes
 * are necessary, changes must be applied either to the source generator
 * application or to one of its data files.  The source generator's fully
 * qualified name is edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator.
 */

package edu.jhu.cs.bsj.stdlib.diagnostic.impl;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.annotation.Generated;
import javax.tools.Diagnostic.Kind;

import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.impl.utils.Pair;
import edu.jhu.cs.bsj.compiler.metaprogram.AbstractBsjMetaprogramMetaAnnotation;
import edu.jhu.cs.bsj.stdlib.diagnostic.InvalidAnnotatedDeclarationDiagnostic;


/**
 * Indicates that the meta-annotation cannot be used on the specified type of node.  The
 * <code>annotatedNode</code> field is a hint and may be <code>null</code>.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class InvalidAnnotatedDeclarationDiagnosticImpl extends InvalidMetaAnnotationUseDiagnosticImpl implements InvalidAnnotatedDeclarationDiagnostic
{
    /** The node that was annotated. */
    private Node annotatedNode;
    
    /** The legal types that could be annotated by the meta-annotation. */
    private List<Class<? extends Node>> legalTypes;
    
    public InvalidAnnotatedDeclarationDiagnosticImpl(
            Class<? extends AbstractBsjMetaprogramMetaAnnotation> metaAnnotationClass,
            Node annotatedNode,
            List<Class<? extends Node>> legalTypes)
    {
        super(InvalidAnnotatedDeclarationDiagnostic.CODE, Kind.ERROR, metaAnnotationClass);
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
    protected Pair<List<Object>,Map<String,Integer>> getMessageArgs(Locale locale)
    {
        Pair<List<Object>,Map<String,Integer>> args = super.getMessageArgs(locale);
        args.getFirst().add(this.annotatedNode);
        args.getSecond().put("annotatedNode", args.getFirst().size());
        args.getFirst().add(this.legalTypes);
        args.getSecond().put("legalTypes", args.getFirst().size());
        args.getFirst().add(annotatedNode!=null?annotatedNode.getClass().getName():null);
        args.getSecond().put("annotatedNodeTypeName", args.getFirst().size());
        return args;
    }
    
}
