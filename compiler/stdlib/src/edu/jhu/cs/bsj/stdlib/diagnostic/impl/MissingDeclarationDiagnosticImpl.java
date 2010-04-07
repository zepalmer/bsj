package edu.jhu.cs.bsj.stdlib.diagnostic.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.node.Node;
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
    protected List<Object> getMessageArgs(Locale locale)
    {
        List<Object> args = new ArrayList<Object>();
        args.add(this.node);
        args.add(this.name);
        return args;
    }
    
}
