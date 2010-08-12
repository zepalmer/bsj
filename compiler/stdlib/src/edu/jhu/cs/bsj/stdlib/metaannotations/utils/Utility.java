package edu.jhu.cs.bsj.stdlib.metaannotations.utils;

import java.util.ArrayList;

import edu.jhu.cs.bsj.compiler.ast.node.Node;

import java.util.Collection;
import java.util.List;

import edu.jhu.cs.bsj.compiler.ast.node.ClassMemberNode;
import edu.jhu.cs.bsj.compiler.ast.node.MethodDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.TypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.ClassMemberListNode;
import edu.jhu.cs.bsj.compiler.impl.utils.Pair;
import edu.jhu.cs.bsj.stdlib.utils.GetterFilter;

public class Utility {
	public static List<Pair<String, TypeNode>> getGetters(
			ClassMemberListNode members) {
		List<Pair<String, TypeNode>> getterDescriptions = new ArrayList<Pair<String, TypeNode>>();

		// Map<String, MethodDeclarationNode> methodMap = new HashMap<String,
		// MethodDeclarationNode>();
		for (ClassMemberNode member : members.filter(new GetterFilter())) {
			MethodDeclarationNode methodDecl = (MethodDeclarationNode) member;
			getterDescriptions.add(new Pair<String, TypeNode>(methodDecl
					.getIdentifier().getIdentifier(), methodDecl
					.getReturnType()));
		}

		return getterDescriptions;
	}

	public static List<Pair<String, TypeNode>> fieldNamesFromGetters(
			List<Pair<String, TypeNode>> getters) {
		List<Pair<String, TypeNode>> fieldDescriptions = new ArrayList<Pair<String, TypeNode>>();

		for (Pair<String, TypeNode> pair : getters) {
			Pair<String, TypeNode> newPair = new Pair<String, TypeNode>(
					NameUtilities.lowerFirst(pair.getFirst()), pair.getSecond());
			fieldDescriptions.add(newPair);
		}

		return fieldDescriptions;
	}

	@SuppressWarnings("unchecked")
	public static <T> List<T> filterByClass(Collection list,
			java.lang.Class<T> type) {
		List<T> ret = new ArrayList<T>();

		for (Object obj : list) {
			if (type.isInstance(obj)) {
				ret.add((T) obj);
			}
		}
		return ret;
	}

	public static Node getAncestor(Node node, int levels) {
		for (int i = 0; i < levels; i++) {
			if (node == null) {
				return null;
			} else {
				node = node.getParent();
			}
		}
		return node;
	}
}
