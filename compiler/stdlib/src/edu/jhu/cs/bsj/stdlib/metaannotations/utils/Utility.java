package edu.jhu.cs.bsj.stdlib.metaannotations.utils;

import java.util.ArrayList;
import java.util.List;

import edu.jhu.cs.bsj.compiler.ast.node.ClassDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.ClassMemberNode;
import edu.jhu.cs.bsj.compiler.ast.node.MethodDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.TypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.ClassMemberListNode;
import edu.jhu.cs.bsj.compiler.impl.utils.Pair;
import edu.jhu.cs.bsj.stdlib.utils.GetterFilter;
import edu.jhu.cs.bsj.compiler.ast.node.NameNode;



public class Utility {
	public static List<Pair<String, TypeNode>> getGetters(ClassMemberListNode members) {
		List<Pair<String, TypeNode>> getterDescriptions = new ArrayList<Pair<String, TypeNode>>();

//		Map<String, MethodDeclarationNode> methodMap = new HashMap<String, MethodDeclarationNode>();
		 for (ClassMemberNode member : members.filter(new GetterFilter()))
         {
             MethodDeclarationNode methodDecl = (MethodDeclarationNode) member;
             getterDescriptions.add(new Pair<String, TypeNode>(methodDecl.getIdentifier().getIdentifier(),
                   methodDecl.getReturnType()));
         }
		 
		 return getterDescriptions;
	}
	
	public static List<Pair<String, TypeNode>> fieldNamesFromGetters(List<Pair<String, TypeNode>> getters) {
		List<Pair<String, TypeNode>> fieldDescriptions = new ArrayList<Pair<String, TypeNode>>();

		for (Pair<String, TypeNode> pair : getters) {
			Pair<String, TypeNode> newPair = new Pair<String, TypeNode>(NameUtilities.lowerFirst(pair.getFirst()), pair.getSecond());
			fieldDescriptions.add(newPair);
		}
		
		return fieldDescriptions;
	}

}
