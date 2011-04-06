package edu.jhu.cs.bsj.stdlib.metaannotations.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.jhu.cs.bsj.compiler.ast.exception.MetaprogramExecutionFailureException;
import edu.jhu.cs.bsj.compiler.ast.node.ClassDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.ClassMemberNode;
import edu.jhu.cs.bsj.compiler.ast.node.DeclaredTypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.IdentifierNode;
import edu.jhu.cs.bsj.compiler.ast.node.MethodDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.NameNode;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.ParameterizedTypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.TypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.UnparameterizedTypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.ClassMemberListNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaAnnotationMetaprogramAnchorNode;
import edu.jhu.cs.bsj.compiler.impl.utils.NotImplementedYetException;
import edu.jhu.cs.bsj.compiler.impl.utils.Pair;
import edu.jhu.cs.bsj.compiler.metaprogram.AbstractBsjMetaprogramMetaAnnotation;
import edu.jhu.cs.bsj.compiler.metaprogram.Context;
import edu.jhu.cs.bsj.stdlib.diagnostic.impl.InvalidAnnotatedDeclarationDiagnosticImpl;
import edu.jhu.cs.bsj.stdlib.diagnostic.impl.MissingMethodDeclarationDiagnosticImpl;
import edu.jhu.cs.bsj.stdlib.utils.GetterFilter;
import edu.jhu.cs.bsj.stdlib.utils.TypeDeclUtils;

public class MetaannotationMetaprogramToolkit {
	private AbstractBsjMetaprogramMetaAnnotation program;
	private Context<MetaAnnotationMetaprogramAnchorNode,MetaAnnotationMetaprogramAnchorNode> context;
	public MetaannotationMetaprogramToolkit(
			AbstractBsjMetaprogramMetaAnnotation program,
			Context<MetaAnnotationMetaprogramAnchorNode,MetaAnnotationMetaprogramAnchorNode> context) {
		super();
		this.program = program;
		this.context = context;
	}
	
	public <T extends Node> T getDeclarationAncestorOfType(
			Class<T> type,
			Node node) {
		return getSpecificAncestorOfType(type, node, 4);
	}
	
	public <T extends Node> T getSpecificAncestorOfType(
			Class<T> type,
			Node node,
			int level) {
		node = Utility.getAncestor(node, level);
		if (type.isInstance(node)) {
			return type.cast(node);
		} else {
			this.context.getDiagnosticListener().report(new InvalidAnnotatedDeclarationDiagnosticImpl(
					this.program.getClass(), null, Collections
							.<Class<? extends Node>> singletonList(type)));
			throw new MetaprogramExecutionFailureException();
		}
	}
	
	public List<Pair<String, TypeNode>> getGettersFromNames(IdentifierNode[] properties) {
	    String[] names = new String[properties.length];
	    for (int i=0;i<properties.length;i++)
	    {
	        names[i] = properties[i].getIdentifier();
	    }
	    return getGettersFromNames(names);
	}

	public List<Pair<String, TypeNode>> getGettersFromNames(String[] properties) {
		ClassMemberListNode members = TypeDeclUtils.getClassMembers(context, program);
		Map<String, MethodDeclarationNode> methodMap = new HashMap<String, MethodDeclarationNode>();
		for (ClassMemberNode member : members.filter(new GetterFilter())) {
			MethodDeclarationNode methodDecl = (MethodDeclarationNode) member;
			methodMap.put(methodDecl.getIdentifier().getIdentifier(),
					methodDecl);
		}
		List<Pair<String, TypeNode>> getterDescriptions = new ArrayList<Pair<String, TypeNode>>();
		;
		for (String propName : properties) {
			String getterName = "get"
					+ Character.toUpperCase(propName.charAt(0))
					+ propName.substring(1);
			MethodDeclarationNode getterDeclaration = methodMap.get(getterName);
			if (getterDeclaration == null) {
				context.getDiagnosticListener().report(
						new MissingMethodDeclarationDiagnosticImpl(members,
								getterName));
				throw new MetaprogramExecutionFailureException();
			}
			getterDescriptions.add(new Pair<String, TypeNode>(getterName,
					getterDeclaration.getReturnType()));
		}
		return getterDescriptions;
	}
	
	public <T extends Node> NameNode getExtendsNameNode(ClassDeclarationNode declaration) {
		if (declaration instanceof ClassDeclarationNode) {
			ClassDeclarationNode classDecl = (ClassDeclarationNode) declaration;
			DeclaredTypeNode extender = classDecl.getExtendsClause();
			if (extender == null) {
				return null;
			}
			if (extender instanceof ParameterizedTypeNode) {
				ParameterizedTypeNode parameterizedVersion = (ParameterizedTypeNode) extender;
				// TODO flesh this out
                throw new NotImplementedYetException();
			} else if (extender instanceof UnparameterizedTypeNode) {
				UnparameterizedTypeNode unparameterizedVersion = (UnparameterizedTypeNode) extender;
				NameNode name = unparameterizedVersion.getName();
				return name;
				// if (name.getIdentifier().getIdentifier().equals("Object")) {
				// return true;
				// } else {
				// return false;
				// }
			} else {
				throw new NotImplementedYetException();
				// TODO flesh this out
			}
		}
		return null;
		}
		
		public <T extends Node> String getExtendsName(ClassDeclarationNode declaration) {
			NameNode name = getExtendsNameNode(declaration);
			if (name == null) {
				return "java.lang.Object";
			} else {
				return name.getIdentifier().getIdentifier();
			}
		}
	
	
}
