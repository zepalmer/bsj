/*
 * WARNING: THIS FILE IS GENERATED.  Do not make any changes to this file
 * directly; it was generated from the BSJ source generator project.  If changes
 * are necessary, changes must be applied either to the source generator
 * application or to one of its data files.  The source generator's fully
 * qualified name is edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator.
 */

package edu.jhu.cs.bsj.compiler.diagnostic.compiler;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.exception.DuplicatePackageMemberException;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.PackageNode;
/**
 * A diagnostic indicating that a metaprogram attempted to insert a member into a package node when
 * another member of the same type (compilation unit or package) and the same name already existed.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface DuplicatePackageMemberDiagnostic extends MetaprogramDetectedErrorDiagnostic<DuplicatePackageMemberException>
{
    /** The code for this diagnostic. */
    public static final String CODE = "bsj.compiler.metaprogram.failure.duplicate.packageMember";
    
    /**
     * Retrieves the package node containing the duplicate.
     * @return The package node containing the duplicate.
     */
    public PackageNode getPackageNode();
    
    /**
     * Retrieves the node representing the duplicate member.
     * @return The node representing the duplicate member.
     */
    public Node getDuplicateMember();
    
    /**
     * Retrieves the name of the member which was duplicated.
     * @return The name of the member which was duplicated.
     */
    public String getDuplicateMemberName();
    
}
