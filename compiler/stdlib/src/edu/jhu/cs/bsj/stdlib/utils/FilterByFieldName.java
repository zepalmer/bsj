package edu.jhu.cs.bsj.stdlib.utils;

import edu.jhu.cs.bsj.compiler.ast.NodeFilter;
import edu.jhu.cs.bsj.compiler.ast.node.FieldDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.Node;

public class FilterByFieldName implements NodeFilter<Node> {
private String fieldName;
	
	public FilterByFieldName(String s) {
		fieldName = s;
	}
	public boolean filter(Node member) {
		// TODO Auto-generated method stub        
		if (member instanceof FieldDeclarationNode)
        {
			FieldDeclarationNode methodDecl = (FieldDeclarationNode) member;
			String fieldName = methodDecl.getDeclarators().get(0).getIdentifier().getIdentifier(); 
            if (fieldName.equals(this.fieldName))
                    //&& (!(methodDecl.getReturnType() instanceof PrimitiveTypeNode) || (((PrimitiveTypeNode) (methodDecl.getReturnType())).getPrimitiveType() != PrimitiveType.VOID)))
            {
                return true;
            }
        }
        
        return false;
    }
}
