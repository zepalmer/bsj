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
import edu.jhu.cs.bsj.compiler.ast.exception.DuplicatePackageMemberException;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.PackageNode;
import edu.jhu.cs.bsj.compiler.diagnostic.compiler.DuplicatePackageMemberDiagnostic;
import edu.jhu.cs.bsj.compiler.impl.utils.Pair;


/**
 * A diagnostic indicating that a metaprogram attempted to insert a member into a package node when
 * another member of the same type (compilation unit or package) and the same name already existed.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class DuplicatePackageMemberDiagnosticImpl extends MetaprogramDetectedErrorDiagnosticImpl<DuplicatePackageMemberException> implements DuplicatePackageMemberDiagnostic
{
    /** The package node containing the duplicate. */
    private PackageNode packageNode;
    
    /** The node representing the duplicate member. */
    private Node duplicateMember;
    
    /** The name of the member which was duplicated. */
    private String duplicateMemberName;
    
    public DuplicatePackageMemberDiagnosticImpl(
            BsjSourceLocation source,
            DuplicatePackageMemberException exception,
            PackageNode packageNode,
            Node duplicateMember,
            String duplicateMemberName)
    {
        super(source, DuplicatePackageMemberDiagnostic.CODE, Kind.ERROR, exception);
        this.packageNode = packageNode;
        this.duplicateMember = duplicateMember;
        this.duplicateMemberName = duplicateMemberName;
    }
    
    /**
     * {@inheritDoc}
     */
    public PackageNode getPackageNode()
    {
        return this.packageNode;
    }
    
    /**
     * {@inheritDoc}
     */
    public Node getDuplicateMember()
    {
        return this.duplicateMember;
    }
    
    /**
     * {@inheritDoc}
     */
    public String getDuplicateMemberName()
    {
        return this.duplicateMemberName;
    }
    
    @Override
    protected Pair<List<Object>,Map<String,Integer>> getMessageArgs(Locale locale)
    {
        Pair<List<Object>,Map<String,Integer>> args = super.getMessageArgs(locale);
        args.getFirst().add(this.packageNode);
        args.getSecond().put("packageNode", args.getFirst().size());
        args.getFirst().add(this.duplicateMember);
        args.getSecond().put("duplicateMember", args.getFirst().size());
        args.getFirst().add(this.duplicateMemberName);
        args.getSecond().put("duplicateMemberName", args.getFirst().size());
        return args;
    }
    
    public DuplicatePackageMemberDiagnosticImpl(BsjSourceLocation source, DuplicatePackageMemberException exception)
    {
        this(source, exception, exception.getPackageNode(), exception.getDuplicateMember(), exception.getDuplicateMemberName());
    }
    
}
