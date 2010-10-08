/*
 * WARNING: THIS FILE IS GENERATED.  Do not make any changes to this file
 * directly; it was generated from the BSJ source generator project.  If changes
 * are necessary, changes must be applied either to the source generator
 * application or to one of its data files.  The source generator's fully
 * qualified name is edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator.
 */

package edu.jhu.cs.bsj.compiler.ast.exception;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.PackageNode;
import edu.jhu.cs.bsj.compiler.diagnostic.BsjDiagnostic;
import edu.jhu.cs.bsj.compiler.diagnostic.compiler.DuplicatePackageMemberDiagnostic;

/**
 * An exception indicating that a metaprogram attempted to insert a member into a package node when
 * another member of the same type (compilation unit or package) and the same name already existed.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public abstract class DuplicatePackageMemberException extends MetaprogramDetectedErrorException
{
    private static final long serialVersionUID = 1L;
    
    /** The package node containing the duplicate. */
    private PackageNode packageNode;
    
    /** The node representing the duplicate member. */
    private Node duplicateMember;
    
    /** The name of the member which was duplicated. */
    private String duplicateMemberName;
    
    public DuplicatePackageMemberException(
            PackageNode packageNode,
            Node duplicateMember,
            String duplicateMemberName)
    {
        super();
        this.packageNode = packageNode;
        this.duplicateMember = duplicateMember;
        this.duplicateMemberName = duplicateMemberName;
    }
    
    /**
     * Retrieves the package node containing the duplicate.
     * @return The package node containing the duplicate.
     */
    public PackageNode getPackageNode()
    {
        return this.packageNode;
    }
    
    /**
     * Retrieves the node representing the duplicate member.
     * @return The node representing the duplicate member.
     */
    public Node getDuplicateMember()
    {
        return this.duplicateMember;
    }
    
    /**
     * Retrieves the name of the member which was duplicated.
     * @return The name of the member which was duplicated.
     */
    public String getDuplicateMemberName()
    {
        return this.duplicateMemberName;
    }
    
    /**
     * Creates a {@link BsjDiagnostic} corresponding to this exception type.
     * @param location The source location to report as the cause for the diagnostic.
     * @return A suitable diagnostic.
     */
    public abstract DuplicatePackageMemberDiagnostic getDiagnostic(BsjSourceLocation location);
}
