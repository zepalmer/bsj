package edu.jhu.cs.bsj.compiler.diagnostic.typechecker;

import java.util.List;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.node.NamedTypeDeclarationNode;
/**
 * Indicates that a type name could not be resolved because at least two different types applied.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface AmbiguousTypeNameDiagnostic extends NamespaceLookupFailureDiagnostic
{
    /**
     * Retrieves the type declarations which caused the ambiguity.
     * @return The type declarations which caused the ambiguity.
     */
    public List<NamedTypeDeclarationNode<?>> getExamples();
    
}
