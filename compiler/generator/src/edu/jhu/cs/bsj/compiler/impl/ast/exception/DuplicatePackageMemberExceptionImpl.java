package edu.jhu.cs.bsj.compiler.impl.ast.exception;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.exception.DuplicatePackageMemberException;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.PackageNode;
import edu.jhu.cs.bsj.compiler.diagnostic.compiler.DuplicatePackageMemberDiagnostic;
import edu.jhu.cs.bsj.compiler.impl.diagnostic.compiler.DuplicatePackageMemberDiagnosticImpl;

/*
 * {@inheritDoc}
 */

@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class DuplicatePackageMemberExceptionImpl extends DuplicatePackageMemberException
{
    private static final long serialVersionUID = 1L;
    
    public DuplicatePackageMemberExceptionImpl(
            PackageNode packageNode,
            Node duplicateMember,
            String duplicateMemberName)
    {
        super(packageNode, duplicateMember, duplicateMemberName);
    }
    @Override
    public DuplicatePackageMemberDiagnostic getDiagnostic(BsjSourceLocation source)
    {
        return new DuplicatePackageMemberDiagnosticImpl(source, this);
    }
    
}
