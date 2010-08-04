package edu.jhu.cs.bsj.compiler.impl.diagnostic.typechecker;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.diagnostic.typechecker.WrongPackageDiagnostic;
import edu.jhu.cs.bsj.compiler.impl.utils.Pair;


/**
 * A diagnostic indicating that a compilation unit does not contain a correct package declaration.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class WrongPackageDiagnosticImpl extends BsjTypeCheckerDiagnosticImpl implements WrongPackageDiagnostic
{
    /** The name of the expected package declaration. */
    private String expectedName;
    
    /** The name of the package declaration which was found. */
    private String actualName;
    
    public WrongPackageDiagnosticImpl(
            BsjSourceLocation source,
            String expectedName,
            String actualName)
    {
        super(source, WrongPackageDiagnostic.CODE, Kind.ERROR);
        this.expectedName = expectedName;
        this.actualName = actualName;
    }
    
    /**
     * {@inheritDoc}
     */
    public String getExpectedName()
    {
        return this.expectedName;
    }
    
    /**
     * {@inheritDoc}
     */
    public String getActualName()
    {
        return this.actualName;
    }
    
    @Override
    protected Pair<List<Object>,Map<String,Integer>> getMessageArgs(Locale locale)
    {
        Pair<List<Object>,Map<String,Integer>> args = super.getMessageArgs(locale);
        args.getFirst().add(this.expectedName);
        args.getSecond().put("expectedName", args.getFirst().size());
        args.getFirst().add(this.actualName);
        args.getSecond().put("actualName", args.getFirst().size());
        return args;
    }
    
}
