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
 * This meta-annotation metaprogram generates method forwards to fields and
 * methods that have private access. The metaannotation is anchored around a
 * field declaration, and takes two string arrays, the first is not optional,
 * and is the list of methods of the private field to forward. The second is a
 * list of the names of the forwarded methods. Forwarded methods are added to
 * the class the metaannotation is anchored on, while methods to forward are
 * methods of the field type.
 * 
 * @author Nathan Krasnopoler
 */
// TODO make multiple @@Forwarders not conflict, and make it so that each one
// can only take a single methodName and forwardedMethodName
public class Forwarder extends AbstractBsjMetaAnnotationMetaprogram {

	private String[] methodNames = null;
	private String[] forwardedMethodNames = null;
	private String fieldNameOverride = null;
	private MetaAnnotationMetaprogramAnchorNode anchor;
	private BsjNodeFactory factory;
	private boolean onFieldDeclaration = true;

	/**
	 * 
	 */
	public Forwarder() {
		super(Arrays.asList("forwarder"), new ArrayList<String>(), Arrays.asList("property"));
	}

	@BsjMetaAnnotationElementGetter
	public String[] getMethodNames() {
		return this.methodNames;
	}
	@BsjMetaAnnotationElementSetter
	public void setMethodNames(String[] methodNames) {
		this.methodNames = methodNames;
	}

	@BsjMetaAnnotationElementSetter
	public void setDepends(String[] depends) {
		if (depends != null) {
			changeInstanceDependencies(Arrays.asList(depends));
		}
	}
	
	@BsjMetaAnnotationElementGetter
	public String[] getDepends() {
		return (String[]) retrieveInstanceDependencies().toArray();
	}
	
	@BsjMetaAnnotationElementSetter
	public void setTargets(String[] targets) {
		if (targets != null) {
			changeInstanceTargets(Arrays.asList(targets));
		}
	}
	
	@BsjMetaAnnotationElementGetter
	public String[] getTargets() {
		return (String[]) retrieveInstanceTargets().toArray();
	}
	
	@BsjMetaAnnotationElementGetter
	public String[] getForwardedMethodNames() {
		return forwardedMethodNames;
	} // TODO add specify arbitrary targets

	
	@BsjMetaAnnotationElementSetter
	public void setForwardedMethodNames(String[] forwardedMethodNames) {
		this.forwardedMethodNames = forwardedMethodNames;
	}
	
	@BsjMetaAnnotationElementSetter
	public void setFieldNameOverride(String fieldNameOverride) {
		this.fieldNameOverride = fieldNameOverride;
	}

	@BsjMetaAnnotationElementGetter
	public String getFieldNameOverride() {
		return fieldNameOverride;
	}

	@Override
	protected void execute(Context<MetaAnnotationMetaprogramAnchorNode> context) {
		// Prelude/preparation
		// get anchor and such
		// This is the factory that allows us to build new AST parts.
		BsjNodeFactory factory = context.getFactory();
		this.anchor = context.getAnchor();
		this.factory = factory;
		ClassDeclarationNode classDeclaration = anchor
				.getNearestAncestorOfType(ClassDeclarationNode.class);


		// TODO Currently this assumes we are on a field,

		// find out if we are anchored onto a field or a private method
		// if (true)
		// {
		// We are on a field declaration

		// Get the FieldDeclarationNode that this metaannotation is anchored on.
		MethodDeclarationNode methodNode;
		FieldDeclarationNode fieldNode = anchor
				.getNearestAncestorOfType(FieldDeclarationNode.class);
		String fieldName;
		TypeNode fieldType;
		List<ClassMemberNode> classDeclarationList = classDeclaration.getBody().getMembers().getChildren();

		if (fieldNode == null) {
			methodNode = anchor.getNearestAncestorOfType(MethodDeclarationNode.class);
			onFieldDeclaration = false;
			
			// Throw an error if none can be found
			if (methodNode == null) {
				context.getDiagnosticListener().report(
					new InvalidAnnotatedDeclarationDiagnosticImpl(
							getClass(),
							null,
							Collections
							.<Class<? extends Node>> singletonList(FieldDeclarationNode.class)));
				throw new MetaprogramExecutionFailureException();				
			}
			fieldType = methodNode.getReturnType();
//			fieldName = trimName(methodNode.getIdentifier().getIdentifier());
			fieldName = methodNode.getIdentifier().getIdentifier();
			getAllMethods(fieldName, fieldType, classDeclarationList);
		} else {
			for (VariableDeclaratorNode variableDeclaration : fieldNode.getDeclarators().getChildren()) {
				fieldName = variableDeclaration.getName().getIdentifier();

				fieldType = variableDeclaration.getEffectiveType(factory);
				getAllMethods(fieldName, fieldType, classDeclarationList);
			} 
		}

		// for each method in the argument list,
		// Let methodName be the method in the argument list
		// Let forwardedMethodName = fieldName +
		// capitalizeFirstLetter(methodName)
		// make a new method declaration node called forwardedMethodName, make
		// it public,
		// and make it simply call methodName on fieldName.
		// else
		// we are on a method
		// Let accessorName be the name of the method
		// for each method in the argument list,
		// Let methodName be the method in the argument list
		// Let forwardedMethodName = accessorName +
		// capitalizeFirstLetter(methodName)
		// make a new method declaration node called forwardedMethodName, make
		// it public,
		// and make it simply call methodName on accessorName().
	}


	private String trimName(String identifier) {
		if (identifier.startsWith("get")) {
			return downCase(identifier.substring(3));
		} else {
			return identifier;
		}
	}


	private String downCase(String string) {
		// TODO Auto-generated method stub
		return Character.toLowerCase(string.charAt(0)) + string.substring(1);
	}

	private void getAllMethods(
			String fieldNameString, TypeNode fieldType,
			List<ClassMemberNode> classDeclarationList) {
		int i = 0;
		IdentifierNode fieldName = factory.makeIdentifierNode(fieldNameString);
		for (String methodName : getMethodNames()) {
			String forwardedMethodName = getForwardedMethodName(fieldName.getIdentifier(), i);
			classDeclarationList.addAll(createForwardedMethod(
					fieldType, fieldName, methodName, forwardedMethodName));
			i++;
		}
	}	
	
	private void getAllMethods(
			String fieldNameString, String forwardedMethodName, TypeNode fieldType,
			List<ClassMemberNode> classDeclarationList) {
		int i = 0;
		IdentifierNode fieldName = factory.makeIdentifierNode(fieldNameString);
		for (String methodName : getMethodNames()) {
//			String forwardedMethodName = getForwardedMethodName(fieldName.getIdentifier(), i);
			classDeclarationList.addAll(createForwardedMethod(
					fieldType, fieldName, methodName, forwardedMethodName));
			i++;
		}
	}

	public String getForwardedMethodName(String fieldName, int i) {
		String methodName = getMethodNames()[i];
		if (forwardedMethodNames != null && forwardedMethodNames.length < i && forwardedMethodNames[i] != null) {
			return forwardedMethodNames[i];
		} else {
			if (fieldNameOverride != null) {
				fieldName = fieldNameOverride;
			}
			return fieldName + upcaseFirstLetter(methodName);
		}
	}

	private static String upcaseFirstLetter(String name) {
		return Character.toUpperCase(name.charAt(0)) + name.substring(1);
	}

	@Override
	public void complete() throws InvalidMetaAnnotationConfigurationException {
	}

	private List<MethodDeclarationNode> createForwardedMethod(
			TypeNode variableType, IdentifierNode variableName, String methodName,
			String forwardedMethodName) {
		// Let fieldName be the name of the field
		List<MethodDeclarationNode> methodsToAdd = new ArrayList<MethodDeclarationNode>();
		int i = 0;

		for (MethodDeclarationNode methodToAdd : getMethodsToForward(
				variableType, methodName)) {
			// String forwardedMethodName = "";

			IdentifierNode forwardedMethodNameIdentifier = factory
					.makeIdentifierNode(forwardedMethodName);
			i++;
			VariableListNode parameters = methodToAdd.getParameters();

			/* return ~:fieldName:~.~:methodName:~(~:someArgs:~) */
			IdentifierNode fieldIdentifier = variableName.deepCopy(factory);
			PrimaryExpressionNode fieldExpression;
			if (onFieldDeclaration) {
				fieldExpression = makeFieldAccess(fieldIdentifier);	
			} else {
				 fieldExpression = makeMethodAccess(fieldIdentifier);	
			}
			List<ExpressionNode> listOfArguments = new ArrayList<ExpressionNode>();
			for (VariableNode parameter : parameters.getChildren()) {
				NameNode name = factory.makeSimpleNameNode(parameter
						.getIdentifier(), NameCategory.AMBIGUOUS);
				listOfArguments.add(factory.makeFieldAccessByNameNode(name));
			}
			ExpressionListNode someArgs = factory.makeExpressionListNode(listOfArguments);
			ReturnNode returnNode = factory.makeReturnNode(factory.makeMethodInvocationByExpressionNode(fieldExpression, factory.makeIdentifierNode(methodName), someArgs));
			List<BlockStatementNode> listOfStatements = new ArrayList<BlockStatementNode>();
			listOfStatements.add(returnNode);
			BlockStatementListNode body = factory
					.makeBlockStatementListNode(listOfStatements);

			MethodModifiersNode modifiers = factory
					.makeMethodModifiersNode(AccessModifier.PUBLIC);
			VariableNode varargParameter = methodToAdd.getVarargParameter();
			UnparameterizedTypeListNode throwTypes = methodToAdd
					.getThrowTypes();
			TypeParameterListNode typeParameters = methodToAdd
					.getTypeParameters();
			JavadocNode javadocNode = methodToAdd.getJavadoc();
			String javadocString;
			if (javadocNode == null) {
				javadocString = "";
			} else {
				javadocString = javadocNode.getText();
			}
			JavadocNode javadoc = factory.makeJavadocNode("forwarded: "
					+ javadocString);
			TypeNode returnType = methodToAdd.getReturnType();
			methodsToAdd.add(factory.makeMethodDeclarationNode(body, modifiers,
					forwardedMethodNameIdentifier, parameters, varargParameter,
					returnType, throwTypes, typeParameters, javadoc));
		}
		return methodsToAdd;
	}

	private List<MethodDeclarationNode> getMethodsToForward(
			TypeNode callerType, String methodName) {

		List<MethodDeclarationNode> returnValue = new ArrayList<MethodDeclarationNode>();

		NameNode name = getNameFromType(callerType);
		NamedTypeDeclarationNode<?> type = new TypeDeclarationLocatingNodeOperation(
				name).executeDefault(anchor, null);
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
			return ((UnparameterizedTypeNode) type).getName();
		} else {
			return null; // TODO throw an error
		}
	}
	
	private PrimaryExpressionNode makeFieldAccess(IdentifierNode fieldIdentifier) {
		return factory.makeFieldAccessByNameNode(factory.makeSimpleNameNode(fieldIdentifier, NameCategory.AMBIGUOUS));
	}	
	private PrimaryExpressionNode makeMethodAccess(IdentifierNode fieldIdentifier) {
		return factory.makeMethodInvocationByNameNode(factory.makeSimpleNameNode(fieldIdentifier, NameCategory.METHOD));
	}

}