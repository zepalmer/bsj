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
import javax.tools.Diagnostic;
import javax.tools.Diagnostic.Kind;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.impl.utils.Pair;
import edu.jhu.cs.bsj.stdlib.diagnostic.UserRelayedDiagnostic;


/**
 * A diagnostic indicating that the reporting metaprogram received a compiler diagnostic from one of
 * the compiler utilities.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class UserRelayedDiagnosticImpl extends BsjUtilDiagnosticImpl implements UserRelayedDiagnostic
{
    /** The compiler diagnostic that this user diagnostic is relaying. */
    private Diagnostic<? extends BsjSourceLocation> diagnostic;
    
    public UserRelayedDiagnosticImpl(
            Diagnostic<? extends BsjSourceLocation> diagnostic)
    {
        super(UserRelayedDiagnostic.CODE, Kind.ERROR);
        this.diagnostic = diagnostic;
    }
    
    /**
     * {@inheritDoc}
     */
    public Diagnostic<? extends BsjSourceLocation> getDiagnostic()
    {
        return this.diagnostic;
    }
    
    @Override
    protected Pair<List<Object>,Map<String,Integer>> getMessageArgs(Locale locale)
    {
        Pair<List<Object>,Map<String,Integer>> args = new Pair<List<Object>,Map<String,Integer>>(new ArrayList<Object>(), new HashMap<String,Integer>());
        args.getFirst().add(this.diagnostic);
        args.getSecond().put("diagnostic", args.getFirst().size());
        return args;
    }
    
}
