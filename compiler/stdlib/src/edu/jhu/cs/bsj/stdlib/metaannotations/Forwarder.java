package edu.jhu.cs.bsj.stdlib.metaannotations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import edu.jhu.cs.bsj.compiler.BsjServiceRegistry;
import edu.jhu.cs.bsj.compiler.ast.AccessModifier;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.exception.MetaprogramExecutionFailureException;
import edu.jhu.cs.bsj.compiler.ast.node.BlockStatementNode;
import edu.jhu.cs.bsj.compiler.ast.node.ClassDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.ClassMemberNode;
import edu.jhu.cs.bsj.compiler.ast.node.ExpressionNode;
import edu.jhu.cs.bsj.compiler.ast.node.FieldDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.IdentifierNode;
import edu.jhu.cs.bsj.compiler.ast.node.JavadocNode;
import edu.jhu.cs.bsj.compiler.ast.node.MethodDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.MethodModifiersNode;
import edu.jhu.cs.bsj.compiler.ast.node.NameNode;
import edu.jhu.cs.bsj.compiler.ast.node.NamedTypeDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.PrimaryExpressionNode;
import edu.jhu.cs.bsj.compiler.ast.node.ReturnNode;
import edu.jhu.cs.bsj.compiler.ast.node.TypeBodyNode;
import edu.jhu.cs.bsj.compiler.ast.node.TypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.UnparameterizedTypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.VariableDeclaratorNode;
import edu.jhu.cs.bsj.compiler.ast.node.VariableNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.BlockStatementListNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.ExpressionListNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.ListNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.TypeParameterListNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.UnparameterizedTypeListNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.VariableListNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaAnnotationMetaprogramAnchorNode;
import edu.jhu.cs.bsj.compiler.impl.utils.NotImplementedYetException;
import edu.jhu.cs.bsj.compiler.metaannotation.BsjMetaAnnotationElementGetter;
import edu.jhu.cs.bsj.compiler.metaannotation.BsjMetaAnnotationElementSetter;
import edu.jhu.cs.bsj.compiler.metaannotation.InvalidMetaAnnotationConfigurationException;
import edu.jhu.cs.bsj.compiler.metaprogram.AbstractBsjMetaAnnotationMetaprogram;
import edu.jhu.cs.bsj.compiler.metaprogram.Context;
import edu.jhu.cs.bsj.compiler.tool.data.BsjThreadLocalData;
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

	private String[] methodName = null;
	private String[] forwardedMethodName = null;
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
	public String[] getMethodName() {
		return this.methodName;
	}
	@BsjMetaAnnotationElementSetter
	public void setMethodName(String[] methodName) {
		this.methodName = methodName;
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
	public String[] getForwardedMethodName() {
		return forwardedMethodName;
	} // TODO add specify arbitrary targets

	
	@BsjMetaAnnotationElementSetter
	public void setForwardedMethodName(String[] forwardedMethodName) {
		this.forwardedMethodName = forwardedMethodName;
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
	protected void execute(Context<MetaAnnotationMetaprogramAnchorNode,MetaAnnotationMetaprogramAnchorNode> context) {
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
			// TODO: consider: what if this meta-annotation is on neither a field nor a method but is contained within
			// a method?
			// ex.
			// public void foo() {
			//     @@Forwarder
			//     class Bar { }
			// }
			// this should produce an error but currently would execute the forwarder on foo()
			
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
			getAllMethods(fieldName, fieldType, fieldType, classDeclarationList);
		} else {
			for (VariableDeclaratorNode variableDeclaration : fieldNode.getDeclarators().getChildren()) {
				fieldName = variableDeclaration.getIdentifier().getIdentifier();
				if (variableDeclaration.getArrayLevels() > 0)
				{
					// since we're not able to handle array types as it is, this would be an error anyway
					// getEffectiveType won't cut it here because we need the type node to be connected
					throw new NotImplementedYetException("Can't handle more than 0 array levels on declarator");
				} else
				{
					fieldType = fieldNode.getType();
				}
				getAllMethods(fieldName, variableDeclaration, fieldType, classDeclarationList);
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





	private void getAllMethods(
			String fieldNameString, Node typeScopeNode, TypeNode fieldType,
			List<ClassMemberNode> classDeclarationList) {
		int i = 0;
		IdentifierNode fieldName = factory.makeIdentifierNode(fieldNameString);
		for (String methodName : getMethodName()) {
			String forwardedMethodName = getForwardedMethodName(fieldName.getIdentifier(), i);
			classDeclarationList.addAll(createForwardedMethod(
					typeScopeNode, fieldType, fieldName, methodName, forwardedMethodName));
			i++;
		}
	}	
	

	public String getForwardedMethodName(String fieldName, int i) {
		String methodName = getMethodName()[i];
		if (forwardedMethodName != null && forwardedMethodName.length < i && forwardedMethodName[i] != null) {
			return forwardedMethodName[i];
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
			Node typeScopeNode, TypeNode variableType, IdentifierNode variableName, String methodName,
			String forwardedMethodName) {
		// Let fieldName be the name of the field
		List<MethodDeclarationNode> methodsToAdd = new ArrayList<MethodDeclarationNode>();
		int i = 0;

		for (MethodDeclarationNode methodToAdd : getMethodsToForward(
				typeScopeNode, variableType, methodName)) {
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
				listOfArguments.add(factory.makeVariableAccessNode(null, parameter.getIdentifier().deepCopy(factory)));
			}
			ExpressionListNode someArgs = factory.makeExpressionListNode(listOfArguments);
			ReturnNode returnNode = factory.makeReturnNode(factory.makeMethodInvocationNode(fieldExpression, factory.makeIdentifierNode(methodName), someArgs));
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
			Node typeScopeNode, TypeNode callerType, String methodName) {

		List<MethodDeclarationNode> returnValue = new ArrayList<MethodDeclarationNode>();

		NameNode name = getNameFromType(callerType);
		Context<?,?> context = BsjServiceRegistry.getThreadLocalData().get(BsjThreadLocalData.Element.CONTEXT);
//		NamedTypeDeclarationNode<?> type = new TypeDeclarationLocatingNodeOperation(
//				name, context.getCompilationUnitLoader()).executeDefault(anchor, null);
		Collection<? extends Node> declarations = typeScopeNode.getDeclarationsInScope(name);
		if (declarations.size() != 1)
		{
			// then either the declaration isn't in scope or there is more than one declaration in scope
			// TODO: produce an appropriate diagnostic
			throw new NotImplementedYetException(declarations.size() + " declarations found for name " + name.getNameString() + " at position " + callerType.getStartLocation());
		}
		Node declaration = declarations.iterator().next();
		if (!(declaration instanceof NamedTypeDeclarationNode<?>))
		{
			// then the type we want is obscured by a type or method declaration
			// TODO: produce an appropriate diagnostic
			throw new NotImplementedYetException("got " + declaration.getClass().getCanonicalName());
		}
		NamedTypeDeclarationNode<?> type = (NamedTypeDeclarationNode<?>)declaration;
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
			throw new NotImplementedYetException();
		}
	}
	
	private PrimaryExpressionNode makeFieldAccess(IdentifierNode fieldIdentifier) {
		return factory.makeVariableAccessNode(null, fieldIdentifier.deepCopy(factory));
	}	
	private PrimaryExpressionNode makeMethodAccess(IdentifierNode fieldIdentifier) {
		return factory.makeMethodInvocationNode(fieldIdentifier.deepCopy(factory));
	}

}