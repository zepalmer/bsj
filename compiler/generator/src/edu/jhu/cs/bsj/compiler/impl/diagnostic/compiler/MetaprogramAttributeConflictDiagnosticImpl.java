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
import edu.jhu.cs.bsj.compiler.ast.exception.MetaprogramAttributeConflictException;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramAnchorNode;
import edu.jhu.cs.bsj.compiler.diagnostic.compiler.MetaprogramAttributeConflictDiagnostic;
import edu.jhu.cs.bsj.compiler.impl.utils.Pair;


/**
 * Indicates that two metaprograms are in conflict because of the manner in which they accessed the same
 * attribute of a given node.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class MetaprogramAttributeConflictDiagnosticImpl extends MetaprogramConflictDiagnosticImpl<MetaprogramAttributeConflictException> implements MetaprogramAttributeConflictDiagnostic
{
    /** The name of the attribute in conflict. */
    private String attributeName;
    
    /** A description of the access performed by the first metaprogram. */
    private String firstAccess;
    
    /** A description of the access performed by the second metaprogram. */
    private String secondAccess;
    
    public MetaprogramAttributeConflictDiagnosticImpl(
            BsjSourceLocation source,
            MetaprogramAttributeConflictException exception,
            MetaprogramAnchorNode<?> firstAnchor,
            MetaprogramAnchorNode<?> secondAnchor,
            Node conflictNode,
            String attributeName,
            String firstAccess,
            String secondAccess)
    {
        super(source, MetaprogramAttributeConflictDiagnostic.CODE, Kind.ERROR, exception, firstAnchor, secondAnchor, conflictNode);
        this.attributeName = attributeName;
        this.firstAccess = firstAccess;
        this.secondAccess = secondAccess;
    }
    
    /**
     * {@inheritDoc}
     */
    public String getAttributeName()
    {
        return this.attributeName;
    }
    
    /**
     * {@inheritDoc}
     */
    public String getFirstAccess()
    {
        return this.firstAccess;
    }
    
    /**
     * {@inheritDoc}
     */
    public String getSecondAccess()
    {
        return this.secondAccess;
    }
    
    @Override
    protected Pair<List<Object>,Map<String,Integer>> getMessageArgs(Locale locale)
    {
        Pair<List<Object>,Map<String,Integer>> args = super.getMessageArgs(locale);
        args.getFirst().add(this.attributeName);
        args.getSecond().put("attributeName", args.getFirst().size());
        args.getFirst().add(this.firstAccess);
        args.getSecond().put("firstAccess", args.getFirst().size());
        args.getFirst().add(this.secondAccess);
        args.getSecond().put("secondAccess", args.getFirst().size());
        return args;
    }
    
    public MetaprogramAttributeConflictDiagnosticImpl(BsjSourceLocation source, MetaprogramAttributeConflictException exception)
    {
        this(source, exception, exception.getFirstAnchor(), exception.getSecondAnchor(), exception.getConflictNode(), exception.getAttributeName(), exception.getFirstAccess(), exception.getSecondAccess());
    }
    
}
