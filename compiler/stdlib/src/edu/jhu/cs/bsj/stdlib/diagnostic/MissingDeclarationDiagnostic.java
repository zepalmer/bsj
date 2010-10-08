/*
 * WARNING: THIS FILE IS GENERATED.  Do not make any changes to this file
 * directly; it was generated from the BSJ source generator project.  If changes
 * are necessary, changes must be applied either to the source generator
 * application or to one of its data files.  The source generator's fully
 * qualified name is edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator.
 */

package edu.jhu.cs.bsj.stdlib.diagnostic;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.node.Node;
/**
 * A diagnostic indicating that an expected declaration is missing.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface MissingDeclarationDiagnostic extends BsjUtilDiagnostic
{
    /**
     * Retrieves the node from which the declaration is missing.
     * @return The node from which the declaration is missing.
     */
    public Node getNode();
    
    /**
     * Retrieves the name of the declaration which is missing.
     * @return The name of the declaration which is missing.
     */
    public String getName();
    
}
