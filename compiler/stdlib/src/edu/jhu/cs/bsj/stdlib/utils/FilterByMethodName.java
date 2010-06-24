package edu.jhu.cs.bsj.stdlib.utils;

import edu.jhu.cs.bsj.compiler.ast.NodeFilter;
import edu.jhu.cs.bsj.compiler.ast.node.MethodDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.Node;

public class FilterByMethodName implements NodeFilter<Node> {

	private String methodName;
	
	public FilterByMethodName(String s) {
		methodName = s;
	}
	public boolean filter(Node member) {
		// TODO Auto-generated method stub        
		if (member instanceof MethodDeclarationNode)
        {
            MethodDeclarationNode methodDecl = (MethodDeclarationNode) member;
            if (methodDecl.getIdentifier().getIdentifier().equals(methodName))
                    //&& (!(methodDecl.getReturnType() instanceof PrimitiveTypeNode) || (((PrimitiveTypeNode) (methodDecl.getReturnType())).getPrimitiveType() != PrimitiveType.VOID)))
            {
                return true;
            }
        }
        
        return false;
    }


}
