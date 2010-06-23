package edu.jhu.cs.bsj.stdlib.metaannotations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import edu.jhu.cs.bsj.compiler.ast.exception.MetaprogramExecutionFailureException;
import edu.jhu.cs.bsj.compiler.ast.node.BlockStatementListNode;
import edu.jhu.cs.bsj.compiler.ast.node.BlockStatementNode;
import edu.jhu.cs.bsj.compiler.ast.node.ExpressionListNode;
import edu.jhu.cs.bsj.compiler.ast.node.ExpressionNode;
import edu.jhu.cs.bsj.compiler.ast.node.FieldDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.JavadocNode;
import edu.jhu.cs.bsj.compiler.ast.node.ListNode;
import edu.jhu.cs.bsj.compiler.ast.node.MethodDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.IdentifierNode;
import edu.jhu.cs.bsj.compiler.ast.NameCategory;
import edu.jhu.cs.bsj.compiler.ast.node.MethodModifiersNode;
import edu.jhu.cs.bsj.compiler.ast.node.ClassMemberNode;
import edu.jhu.cs.bsj.compiler.ast.node.NamedTypeDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.PrimaryExpressionNode;
import edu.jhu.cs.bsj.compiler.ast.node.ReturnNode;
import edu.jhu.cs.bsj.compiler.ast.node.TypeParameterListNode;
import edu.jhu.cs.bsj.compiler.ast.node.NameNode;
import edu.jhu.cs.bsj.compiler.ast.node.UnparameterizedTypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.TypeBodyNode;
import edu.jhu.cs.bsj.compiler.ast.node.UnparameterizedTypeListNode;
import edu.jhu.cs.bsj.compiler.ast.node.VariableListNode;
import edu.jhu.cs.bsj.compiler.ast.node.VariableNode;
import edu.jhu.cs.bsj.compiler.ast.AccessModifier;
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
import edu.jhu.cs.bsj.compiler.impl.operations.TypeDeclarationLocatingNodeOperation;
import edu.jhu.cs.bsj.stdlib.diagnostic.impl.InvalidAnnotatedDeclarationDiagnosticImpl;
import edu.jhu.cs.bsj.stdlib.utils.FilterByMethodName;


/**
 * This meta-annotation metaprogram generates method forwards to fields and methods that have private access. 
 * 
 * @author Nathan Krasnopoler
 */
// TODO make multiple @@Forwarders not conflict, and make it so that each one can only take a single methodName and forwardedMethodName
public class Forwarder extends AbstractBsjMetaAnnotationMetaprogram {
	
	private String[] methodNames = null;
	private String[] forwardedMethodNames = null; 
	private MetaAnnotationMetaprogramAnchorNode anchor;
	private BsjNodeFactory factory;

	/**
	 * 
	 */
	public Forwarder() 	{
        super(Arrays.asList("forwarder"), new ArrayList<String>()/*, Arrays.asList("property")*/);
	}
	
	@BsjMetaAnnotationElementGetter
	public String[] getMethodNames()	{
		return this.methodNames;
	}

	@BsjMetaAnnotationElementSetter
	public void setMethodNames(String[] methodNames) {
		this.methodNames = methodNames;
	}
	

	@BsjMetaAnnotationElementGetter
	public String[] getForwardedMethodNames() {
		return forwardedMethodNames;
	}
	
	@BsjMetaAnnotationElementSetter
	public void setForwardedMethodNames(String[] forwardedMethodNames) {
		this.forwardedMethodNames = forwardedMethodNames;
	}
	
	@Override
	protected void execute(Context<MetaAnnotationMetaprogramAnchorNode> context) 	{
		// Prelude/preparation
			// get anchor and such
		// This is the factory that allows us to build new AST parts. 
		BsjNodeFactory factory = context.getFactory();
		this.anchor = context.getAnchor(); 
		this.factory = factory;
		ClassDeclarationNode classDeclaration = anchor.getNearestAncestorOfType(ClassDeclarationNode.class);
		
		// TODO Currently this assumes we are on a field, 
		
		// find out if we are anchored onto a field or a private method
//		if (true) 
//		{
			// We are on a field declaration

			// Get the FieldDeclarationNode that this metaannotation is anchored on. 
			FieldDeclarationNode fieldNode = anchor.getNearestAncestorOfType(FieldDeclarationNode.class);
			
			// Throw an error if none can be found
			if (fieldNode == null) {
				context.getDiagnosticListener().report(
						new InvalidAnnotatedDeclarationDiagnosticImpl(getClass(), null,
								Collections.<Class<? extends Node>> singletonList(FieldDeclarationNode.class)));
				throw new MetaprogramExecutionFailureException();
			}
			
			List<ClassMemberNode> classDeclarationList = classDeclaration.getBody().getMembers().getChildren();
			for (VariableDeclaratorNode variableDeclaration : fieldNode.getDeclarators().getChildren())	{
				int i = 0;
				for (String methodName : getMethodNames()) {
					String fieldName = variableDeclaration.getName().getIdentifier();
					String forwardedMethodName = getForwardedMethodName(fieldName, i);
					classDeclarationList.addAll(createForwardedMethod(variableDeclaration, methodName, forwardedMethodName));
					i++;
				}
			}
			// for each method in the argument list,
				// Let methodName be the method in the argument list
				// Let forwardedMethodName = fieldName + capitalizeFirstLetter(methodName)
				// make a new method declaration node called forwardedMethodName, make it public, 
					// and make it simply call methodName on fieldName. 
		// else
			// we are on a method
			// Let accessorName be the name of the method
			// for each method in the argument list,
				// Let methodName be the method in the argument list
				// Let forwardedMethodName = accessorName + capitalizeFirstLetter(methodName)
				// make a new method declaration node called forwardedMethodName, make it public, 
					// and make it simply call methodName on accessorName(). 
	}
	
	public String getForwardedMethodName(String fieldName, int i) {
		String methodName = getMethodNames()[i];
		if (forwardedMethodNames != null && forwardedMethodNames[i] != null) {
			return forwardedMethodNames[i];
		} else {
			return fieldName + upcaseFirstLetter(methodName);
		}
	}
	
	private static String upcaseFirstLetter(String name) 	{
		return Character.toUpperCase(name.charAt(0)) + name.substring(1);
	}

	@Override
	public void complete() throws InvalidMetaAnnotationConfigurationException 	{
	}
	
	private List<MethodDeclarationNode> createForwardedMethod(VariableDeclaratorNode variableDeclaration, String methodName, String forwardedMethodName) {
		// Let fieldName be the name of the field
		List<MethodDeclarationNode> methodsToAdd = new ArrayList<MethodDeclarationNode>();
		int i = 0;

		for (MethodDeclarationNode methodToAdd : getMethodsToForward(variableDeclaration.getEffectiveType(factory), methodName)) {
			//String forwardedMethodName = "";
			
	
			IdentifierNode forwardedMethodNameIdentifier = factory.makeIdentifierNode(forwardedMethodName);
			i++;
			VariableListNode parameters = methodToAdd.getParameters();
			
			/* return ~:fieldName:~.~:methodName:~(~:someArgs:~) */
			NameCategory category = NameCategory.AMBIGUOUS;
			IdentifierNode fieldIdentifier = factory.makeIdentifierNode(variableDeclaration.getName().getIdentifier());
			PrimaryExpressionNode fieldExpression = factory.makeFieldAccessByNameNode(factory.makeSimpleNameNode(fieldIdentifier, category)); 
			List<ExpressionNode> listOfArguments = new ArrayList<ExpressionNode>();
			for (VariableNode parameter : parameters.getChildren()) {
				NameNode name = factory.makeSimpleNameNode(parameter.getIdentifier(), category);
				listOfArguments.add(factory.makeFieldAccessByNameNode(name));
			}
			ExpressionListNode someArgs = factory.makeExpressionListNode(listOfArguments); 
			ReturnNode returnNode = factory.makeReturnNode(
					factory.makeMethodInvocationByExpressionNode(fieldExpression, factory.makeIdentifierNode(methodName), someArgs));
			List<BlockStatementNode> listOfStatements = new ArrayList<BlockStatementNode>();
			listOfStatements.add(returnNode);
			BlockStatementListNode body = factory.makeBlockStatementListNode(listOfStatements);
			
			MethodModifiersNode modifiers = factory.makeMethodModifiersNode(AccessModifier.PUBLIC);
			VariableNode varargParameter = methodToAdd.getVarargParameter();
			UnparameterizedTypeListNode throwTypes = methodToAdd.getThrowTypes();
			TypeParameterListNode typeParameters = methodToAdd.getTypeParameters();
			JavadocNode javadocNode = methodToAdd.getJavadoc();
			String javadocString;
			if (javadocNode == null) {
				javadocString = "";
			} else {
				javadocString = javadocNode.getText();
			}
			JavadocNode javadoc = factory.makeJavadocNode("forwarded: " + javadocString);
			TypeNode returnType = methodToAdd.getReturnType();
			methodsToAdd.add(factory.makeMethodDeclarationNode(body, modifiers, forwardedMethodNameIdentifier, parameters, varargParameter, returnType, throwTypes, typeParameters, javadoc));
		}
		return methodsToAdd;
	}
	
	private List<MethodDeclarationNode> getMethodsToForward(TypeNode callerType, String methodName) {
		

		List<MethodDeclarationNode> returnValue = new ArrayList<MethodDeclarationNode>();

		NameNode name = getNameFromType(callerType);
		NamedTypeDeclarationNode<?> type = new TypeDeclarationLocatingNodeOperation(name).executeDefault(anchor, null);
		TypeBodyNode<?> typeBody = type.getBody();
		ListNode<? extends Node> listOfMembers = typeBody.getMembers();
		for (Node node : listOfMembers.filter(new FilterByMethodName(methodName))) {
			if (node instanceof MethodDeclarationNode) {
				MethodDeclarationNode methodNode = (MethodDeclarationNode) node;
				returnValue.add(methodNode);
			}
		}
		return returnValue;
	}
	
	private NameNode getNameFromType(TypeNode type) {
		if (type instanceof UnparameterizedTypeNode) {
			return ((UnparameterizedTypeNode)type).getName();
		} else {
			return null; // TODO throw an error
		}
	}


}