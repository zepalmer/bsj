package edu.jhu.cs.bsj.compiler.diagnostic.typechecker;

import java.util.Collection;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.node.Node;
/**
 * Indicates that a symbol name could not be resolved because at least two different symbols of the
 * same symbol type applied.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface AmbiguousSymbolNameDiagnostic extends NamespaceLookupFailureDiagnostic
{
    /** The code for this diagnostic. */
    public static final String CODE = "bsj.typechecker.name.ambiguous";
    
    /**
     * Retrieves the declarations which caused the ambiguity.
     * @return The declarations which caused the ambiguity.
     */
    public Collection<? extends Node> getExamples();
    
}
