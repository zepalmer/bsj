package edu.jhu.cs.bsj.stdlib.metaannotations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import edu.jhu.cs.bsj.compiler.ast.exception.MetaprogramExecutionFailureException;
import edu.jhu.cs.bsj.compiler.ast.node.BlockStatementListNode;
import edu.jhu.cs.bsj.compiler.ast.node.ClassBodyNode;
import edu.jhu.cs.bsj.compiler.ast.node.ClassMemberListNode;
import edu.jhu.cs.bsj.compiler.ast.node.FieldDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.JavadocNode;
import edu.jhu.cs.bsj.compiler.ast.node.MethodDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.IdentifierNode;
import edu.jhu.cs.bsj.compiler.ast.node.MethodModifiersNode;
import edu.jhu.cs.bsj.compiler.ast.node.TypeParameterListNode;
import edu.jhu.cs.bsj.compiler.ast.node.UnparameterizedTypeListNode;
import edu.jhu.cs.bsj.compiler.ast.node.VariableListNode;
import edu.jhu.cs.bsj.compiler.ast.node.VariableNode;
//import edu.jhu.cs.bsj.compiler.ast.node.VariableDeclaratorListNode;

import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.TypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.VariableDeclaratorNode;
import edu.jhu.cs.bsj.compiler.ast.node.ClassDeclarationNode;
import java.util.Collections;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaAnnotationMetaprogramAnchorNode;
import edu.jhu.cs.bsj.compiler.metaannotation.BsjMetaAnnotationElementGetter;
import edu.jhu.cs.bsj.compiler.metaannotation.BsjMetaAnnotationElementSetter;
import edu.jhu.cs.bsj.compiler.metaannotation.InvalidMetaAnnotationConfigurationException;
import edu.jhu.cs.bsj.compiler.metaprogram.AbstractBsjMetaAnnotationMetaprogram;
import edu.jhu.cs.bsj.compiler.metaprogram.Context;
import edu.jhu.cs.bsj.stdlib.diagnostic.impl.InvalidAnnotatedDeclarationDiagnosticImpl;


/**
 * This meta-annotation metaprogram generates method forwards to fields and methods that have private access. 
 * 
 * @author Nathan Krasnopoler
 */

public class Forwarder extends AbstractBsjMetaAnnotationMetaprogram {
	
	private String[] methodNames = null;

	public Forwarder() 	{
		super(Collections.singletonList("forwarder"), Arrays.asList("property"));
	}
	
	@BsjMetaAnnotationElementGetter
	public String[] getMethodNames()	{
		return this.methodNames;
	}

	@BsjMetaAnnotationElementSetter
	public void setMethodNames(String[] methodNames) {
		this.methodNames = methodNames;
	}
	
	//TODO make this take a string array of arguments

	@Override
	protected void execute(Context<MetaAnnotationMetaprogramAnchorNode> context) 	{
		// Prelude/preparation
			// get anchor and such
		// This is the factory that allows us to build new AST parts. 
		BsjNodeFactory factory = context.getFactory();
		MetaAnnotationMetaprogramAnchorNode anchor = context.getAnchor(); 
		ClassDeclarationNode classDeclaration = anchor.getNearestAncestorOfType(ClassDeclarationNode.class);
		
		// TODO Currently this assumes we are on a field, 
		
		// find out if we are anchored onto a field or a private method
//		if (true) 
//		{
			// We are on a field declaration

			// Get the FieldDeclarationNode that this metaannotation is anchored on. 
			FieldDeclarationNode fieldNode = anchor.getNearestAncestorOfType(FieldDeclarationNode.class);
			
			// Throw an error if none can be found
			if (fieldNode == null)			{
				context.getDiagnosticListener().report(
						new InvalidAnnotatedDeclarationDiagnosticImpl(getClass(), null,
								Collections.<Class<? extends Node>> singletonList(FieldDeclarationNode.class)));
				throw new MetaprogramExecutionFailureException();
			}
			
			List<VariableDeclaratorNode> variableDeclarations = fieldNode.getDeclarators().getChildren();
			List<MethodDeclarationNode> methodsToAdd = new ArrayList<MethodDeclarationNode>();
			for (VariableDeclaratorNode variableDeclaration : variableDeclarations)	{
				for (String methodName : getMethodNames()) {
					methodsToAdd.addAll(createForwardedMethod(factory, variableDeclaration, methodName));
				}
			}
			classDeclaration.getBody().getMembers().getChildren().addAll(methodsToAdd);
			// for each method in the argument list,
				// Let methodName be the method in the argument list
				// Let forwardedMethodName = fieldName + capitalizeFirstLetter(methodName)
				// make a new method declaration node called forwardedMethodName, make it public, 
					// and make it simply call methodName on fieldName. 
//		} else {
//			
//		}
			
		// else
			// we are on a method
			// Let accessorName be the name of the method
			// for each method in the argument list,
				// Let methodName be the method in the argument list
				// Let forwardedMethodName = accessorName + capitalizeFirstLetter(methodName)
				// make a new method declaration node called forwardedMethodName, make it public, 
					// and make it simply call methodName on accessorName(). 
	

		// TODO Auto-generated method stub
		
	}
	
	private static String upcaseFirstLetter(String name) 	{
		return Character.toUpperCase(name.charAt(0)) + name.substring(1);
	}

	@Override
	public void complete() throws InvalidMetaAnnotationConfigurationException 	{
	}
	
	private List<MethodDeclarationNode> createForwardedMethod(BsjNodeFactory factory, VariableDeclaratorNode variableDeclaration, String methodName) {
		// Let fieldName be the name of the field
		List<MethodDeclarationNode> methodsToAdd = new ArrayList<MethodDeclarationNode>();
		String fieldName = variableDeclaration.getName().getIdentifier();
		IdentifierNode forwardedMethodName = factory.makeIdentifierNode(fieldName + upcaseFirstLetter(methodName));
		VariableListNode parameters = null;
		BlockStatementListNode body = null;
		MethodModifiersNode modifiers = null;
		VariableNode varargParameter = null;
		UnparameterizedTypeListNode throwTypes = null;
		TypeParameterListNode typeParameters = null;
		JavadocNode javadoc = null;
		for (TypeNode returnType : getMethodType(variableDeclaration.getEffectiveType(factory), methodName)) {
			methodsToAdd.add(factory.makeMethodDeclarationNode(body, modifiers, forwardedMethodName, parameters, varargParameter, returnType, throwTypes, typeParameters, javadoc));
		}
		return methodsToAdd;
	}
	
	private List<TypeNode> getMethodType(TypeNode callerType, String methodName) {
		return null;
	}
}
