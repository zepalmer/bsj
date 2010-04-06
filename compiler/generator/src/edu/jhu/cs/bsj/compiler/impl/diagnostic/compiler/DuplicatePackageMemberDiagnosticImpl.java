package edu.jhu.cs.bsj.compiler.impl.diagnostic.compiler;

import java.util.List;
import java.util.Locale;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.exception.DuplicatePackageMemberException;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.PackageNode;
import edu.jhu.cs.bsj.compiler.diagnostic.compiler.DuplicatePackageMemberDiagnostic;


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
    protected List<Object> getMessageArgs(Locale locale)
    {
        List<Object> args = super.getMessageArgs(locale);
        args.add(this.packageNode);
        args.add(this.duplicateMember);
        args.add(this.duplicateMemberName);
        return args;
    }
    
    public DuplicatePackageMemberDiagnosticImpl(BsjSourceLocation source, DuplicatePackageMemberException exception)
    {
        this(source, exception, exception.getPackageNode(), exception.getDuplicateMember(), exception.getDuplicateMemberName());
    }
    
}
