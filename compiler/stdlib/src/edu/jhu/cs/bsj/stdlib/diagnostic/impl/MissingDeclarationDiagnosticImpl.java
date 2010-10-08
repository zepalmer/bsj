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

import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.impl.utils.Pair;
import edu.jhu.cs.bsj.stdlib.diagnostic.MissingDeclarationDiagnostic;


/**
 * A diagnostic indicating that an expected declaration is missing.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public abstract class MissingDeclarationDiagnosticImpl extends BsjUtilDiagnosticImpl implements MissingDeclarationDiagnostic
{
    /** The node from which the declaration is missing. */
    private Node node;
    
    /** The name of the declaration which is missing. */
    private String name;
    
    public MissingDeclarationDiagnosticImpl(
            String code,
            javax.tools.Diagnostic.Kind kind,
            Node node,
            String name)
    {
        super(code, kind);
        this.node = node;
        this.name = name;
    }
    
    /**
     * {@inheritDoc}
     */
    public Node getNode()
    {
        return this.node;
    }
    
    /**
     * {@inheritDoc}
     */
    public String getName()
    {
        return this.name;
    }
    
    @Override
    protected Pair<List<Object>,Map<String,Integer>> getMessageArgs(Locale locale)
    {
        Pair<List<Object>,Map<String,Integer>> args = new Pair<List<Object>,Map<String,Integer>>(new ArrayList<Object>(), new HashMap<String,Integer>());
        args.getFirst().add(this.node);
        args.getSecond().put("node", args.getFirst().size());
        args.getFirst().add(this.name);
        args.getSecond().put("name", args.getFirst().size());
        return args;
    }
    
}
