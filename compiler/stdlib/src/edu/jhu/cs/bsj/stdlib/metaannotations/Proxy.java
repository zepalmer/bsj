package edu.jhu.cs.bsj.stdlib.metaannotations;

import java.util.Collection;
import java.util.Collections;
import java.util.Random;

import edu.jhu.cs.bsj.compiler.ast.AccessModifier;
import edu.jhu.cs.bsj.compiler.ast.AssignmentOperator;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.MetaprogramLocalMode;
import edu.jhu.cs.bsj.compiler.ast.MetaprogramPackageMode;
import edu.jhu.cs.bsj.compiler.ast.node.BlockStatementNode;
import edu.jhu.cs.bsj.compiler.ast.node.ClassDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.ClassMemberNode;
import edu.jhu.cs.bsj.compiler.ast.node.ExpressionNode;
import edu.jhu.cs.bsj.compiler.ast.node.FieldDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.IdentifierNode;
import edu.jhu.cs.bsj.compiler.ast.node.InterfaceDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.InterfaceMemberNode;
import edu.jhu.cs.bsj.compiler.ast.node.JavadocNode;
import edu.jhu.cs.bsj.compiler.ast.node.MethodDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.MethodModifiersNode;
import edu.jhu.cs.bsj.compiler.ast.node.TypeNameBindingNode;
import edu.jhu.cs.bsj.compiler.ast.node.TypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.UnparameterizedTypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.VariableInitializerNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.BlockStatementListNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.ClassMemberListNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.DeclaredTypeListNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.InterfaceMemberListNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.VariableDeclaratorListNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.VariableListNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaAnnotationMetaprogramAnchorNode;
import edu.jhu.cs.bsj.compiler.impl.utils.NotImplementedYetException;
import edu.jhu.cs.bsj.compiler.metaannotation.BsjMetaAnnotationElementGetter;
import edu.jhu.cs.bsj.compiler.metaannotation.BsjMetaAnnotationElementSetter;
import edu.jhu.cs.bsj.compiler.metaannotation.InvalidMetaAnnotationConfigurationException;
import edu.jhu.cs.bsj.compiler.metaprogram.AbstractBsjMetaAnnotationMetaprogram;
import edu.jhu.cs.bsj.compiler.metaprogram.Context;

/*
 * Proxy Class enables the implementation of proxy design pattern in BSJ. It takes in the interface name to be proxied. 
 */

public class Proxy extends AbstractBsjMetaAnnotationMetaprogram {

	private String interfaceName;
	
	/**
	 * An auto generated string name for the proxy object
	 */
	private String proxyObject = "proxyObject_"+getRandomNumber();

	public Proxy() {
		super(Collections.<String> emptyList(), Collections
				.<String> emptyList(), Collections.<String> emptyList(),
				MetaprogramLocalMode.MUTATE,
				MetaprogramPackageMode.READ_ONLY);
	}

	/**
	 * @return a random number between 0 to 1000
	 */
	private String getRandomNumber() {
		
			Random rand =  new Random();
			return String.valueOf(rand.nextInt(1000));
	}

	
	/**
	 * this method creates the body of the proxied method
	 * @param factory
	 * @param methodDecl
	 * @param proxyField
	 * @return
	 */
	private BlockStatementListNode getBody(BsjNodeFactory factory,
			MethodDeclarationNode methodDecl, FieldDeclarationNode proxyField) {
		BlockStatementListNode blockNode = factory.makeBlockStatementListNode();
		blockNode.add(factory.makeExpressionStatementNode(factory
				.makeMethodInvocationNode(factory
						.makeVariableAccessNode(proxyField.getDeclarators()
								.iterator().next().getIdentifier()
								.deepCopy(factory)), methodDecl.getIdentifier()
						.deepCopy(factory))));
		return blockNode;
	}

	/**
	 * Creates the constructor for the proxy class
	 * @param classDeclNode
	 * @param factory
	 * @return
	 */
	private MethodDeclarationNode putConstructor(
			ClassDeclarationNode classDeclNode, BsjNodeFactory factory) {

		MethodModifiersNode modifiers = factory
				.makeMethodModifiersNode(AccessModifier.PUBLIC);
		BlockStatementListNode body = factory.makeBlockStatementListNode();
		BlockStatementNode expNode = factory
				.makeExpressionStatementNode(factory.makeAssignmentNode(
						factory.makeVariableAccessNode(
								factory.makeThisNode(),
								factory.makeIdentifierNode(proxyObject)),
						AssignmentOperator.ASSIGNMENT, (ExpressionNode) factory
								.makeVariableAccessNode(factory
										.makeIdentifierNode((proxyObject)))));
		body.add(expNode);
		TypeNode returnType = factory.makeUnparameterizedTypeNode(factory
				.parseNameNode(""));
		VariableListNode parameters = factory.makeVariableListNode();
		parameters.add(factory.makeVariableNode(factory
				.makeUnparameterizedTypeNode(factory.parseNameNode(this
						.getInterfaceName())), factory
				.makeIdentifierNode(proxyObject)));
		IdentifierNode identifier = factory.makeIdentifierNode(classDeclNode
				.getIdentifier().getIdentifier());
		JavadocNode javadoc = factory.makeJavadocNode("Proxy constructor");
		return factory.makeMethodDeclarationNode(body, modifiers, identifier,
				parameters, returnType, javadoc);

	}

	/**
	 * declares proxy field 
	 * @param factory
	 * @return
	 */
	private FieldDeclarationNode putproxyFiled(BsjNodeFactory factory) {
		UnparameterizedTypeNode fieldTypeNode = factory
				.makeUnparameterizedTypeNode(factory.parseNameNode(this
						.getInterfaceName()));
		VariableInitializerNode varNode = null;
		VariableDeclaratorListNode varListNode = factory
				.makeVariableDeclaratorListNode();
		varListNode.add(factory.makeVariableDeclaratorNode(
				factory.makeIdentifierNode(proxyObject), varNode));
		FieldDeclarationNode fieldNode = factory.makeFieldDeclarationNode(
				factory.makeFieldModifiersNode(AccessModifier.PRIVATE),
				fieldTypeNode, varListNode,
				factory.makeJavadocNode(" "));
		return fieldNode;

	}

	@BsjMetaAnnotationElementSetter
	public void setInterfaceName(String interfaceName) {
		this.interfaceName = interfaceName;
	}

	@BsjMetaAnnotationElementGetter
	public String getInterfaceName() {
		return interfaceName;
	}

	@Override
	public void complete() throws InvalidMetaAnnotationConfigurationException {
		if (interfaceName.contains(".")) {
			throw new InvalidMetaAnnotationConfigurationException(this);
		}
	}

	@Override
	protected void execute(
			Context<MetaAnnotationMetaprogramAnchorNode, MetaAnnotationMetaprogramAnchorNode> context) {


		BsjNodeFactory factory = context.getFactory();
		ClassDeclarationNode classDeclNode = context.getAnchor()
				.getNearestAncestorOfType(ClassDeclarationNode.class);
		ClassMemberListNode list = factory.makeClassMemberListNode();
		DeclaredTypeListNode implementsList = factory
				.makeDeclaredTypeListNode();
		implementsList.add((factory
				.makeUnparameterizedTypeNode(factory
						.parseNameNode(this.interfaceName))));
		classDeclNode.setImplementsClause(implementsList);
		FieldDeclarationNode proxyField = putproxyFiled(factory);
		list.add(proxyField);
		list.add(putConstructor(classDeclNode, factory));
		ClassMemberListNode classMemList = classDeclNode.getBody().getMembers();
		Collection<? extends TypeNameBindingNode> proxyIntefaceColl = context
				.getAnchor()
				.getTypeDeclarationsInScope(this.getInterfaceName());
		
		if (proxyIntefaceColl.size() != 1) {
			throw new NotImplementedYetException();
		}
	
		if(!(proxyIntefaceColl.iterator().next() instanceof InterfaceDeclarationNode)){
			throw new NotImplementedYetException();
		}
		InterfaceMemberListNode membersList = ((InterfaceDeclarationNode) proxyIntefaceColl
				.iterator().next()).getBody().getMembers();
		for (InterfaceMemberNode interfaceMemberNode : membersList) {
			for (ClassMemberNode clsMem : classMemList) {
				if (clsMem instanceof MethodDeclarationNode) {
					if (!(((MethodDeclarationNode) clsMem)
							.getIdentifier()
							.toSourceCode()
							.equals(((MethodDeclarationNode) interfaceMemberNode)
									.getIdentifier().toSourceCode())
							&& ((MethodDeclarationNode) clsMem)
									.getParameters()
									.toSourceCode()
									.equals(((MethodDeclarationNode) interfaceMemberNode)
											.getParameters().toSourceCode())
							&& ((MethodDeclarationNode) clsMem)
									.getReturnType()
									.toSourceCode()
									.equals(((MethodDeclarationNode) interfaceMemberNode)
											.getReturnType().toSourceCode()) && ((MethodDeclarationNode) clsMem)
							.getModifiers()
							.toSourceCode()
							.equals(((MethodDeclarationNode) interfaceMemberNode)
									.getModifiers().toSourceCode()))) {
						MethodDeclarationNode methodDecl = (MethodDeclarationNode) interfaceMemberNode;
						list.add(factory.makeMethodDeclarationNode(
								getBody(factory, methodDecl, proxyField),
								methodDecl.getModifiers().deepCopy(factory),
								methodDecl.getIdentifier().deepCopy(factory),
								methodDecl.getParameters().deepCopy(factory),
								methodDecl.getReturnType().deepCopy(factory),
								factory.makeJavadocNode("")));
					} else {
						list.add(clsMem.deepCopy(factory));
					}
					break;
				}
			}
		}

		classDeclNode.getBody().setMembers(list);

	
		
	}

	
}
