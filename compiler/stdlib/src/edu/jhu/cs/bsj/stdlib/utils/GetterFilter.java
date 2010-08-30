package edu.jhu.cs.bsj.stdlib.utils;

import edu.jhu.cs.bsj.compiler.ast.NodeFilter;
import edu.jhu.cs.bsj.compiler.ast.node.ClassMemberNode;
import edu.jhu.cs.bsj.compiler.ast.node.MethodDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.VoidTypeNode;

/**
 * NodeFilter which yields all getter methods.
 * 
 * @author Joseph Riley
 */
public class GetterFilter implements NodeFilter<ClassMemberNode>
{

    @Override
    public boolean filter(ClassMemberNode member)
    {
        if (member instanceof MethodDeclarationNode)
        {
            MethodDeclarationNode methodDecl = (MethodDeclarationNode) member;
            if (methodDecl.getIdentifier().getIdentifier().startsWith("get")
                    && methodDecl.getParameters().size() == 0
                    && (!(methodDecl.getReturnType() instanceof VoidTypeNode)))
            {
                return true;
            }
        }
        
        return false;
    }

}
