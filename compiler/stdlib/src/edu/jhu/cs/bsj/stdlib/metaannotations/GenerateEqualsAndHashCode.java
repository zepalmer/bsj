package edu.jhu.cs.bsj.stdlib.metaannotations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.jhu.cs.bsj.compiler.ast.AccessModifier;
import edu.jhu.cs.bsj.compiler.ast.AssignmentOperator;
import edu.jhu.cs.bsj.compiler.ast.BinaryOperator;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.PrimitiveType;
import edu.jhu.cs.bsj.compiler.ast.UnaryOperator;
import edu.jhu.cs.bsj.compiler.ast.exception.MetaprogramExecutionFailureException;
import edu.jhu.cs.bsj.compiler.ast.node.ArrayTypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.BlockStatementNode;
import edu.jhu.cs.bsj.compiler.ast.node.ClassDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.ClassMemberListNode;
import edu.jhu.cs.bsj.compiler.ast.node.ClassMemberNode;
import edu.jhu.cs.bsj.compiler.ast.node.EnumDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.ExpressionNode;
import edu.jhu.cs.bsj.compiler.ast.node.MethodDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.NamedTypeDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.PrimaryExpressionNode;
import edu.jhu.cs.bsj.compiler.ast.node.PrimitiveTypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.TypeDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.TypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaAnnotationMetaprogramAnchorNode;
import edu.jhu.cs.bsj.compiler.impl.utils.Pair;
import edu.jhu.cs.bsj.compiler.metaannotation.BsjMetaAnnotationElementGetter;
import edu.jhu.cs.bsj.compiler.metaannotation.BsjMetaAnnotationElementSetter;
import edu.jhu.cs.bsj.compiler.metaannotation.InvalidMetaAnnotationConfigurationException;
import edu.jhu.cs.bsj.compiler.metaprogram.AbstractBsjMetaAnnotationMetaprogram;
import edu.jhu.cs.bsj.compiler.metaprogram.Context;
import edu.jhu.cs.bsj.stdlib.diagnostic.impl.InvalidEnclosingTypeDiagnosticImpl;
import edu.jhu.cs.bsj.stdlib.diagnostic.impl.MissingMethodDeclarationDiagnosticImpl;

/**
 * This meta-annotation metaprogram generates the equals and hashCode methods for a class. It generates these functions
 * based on the getters for properties which exist on that class; that is, all methods of the form <code>getFoo()</code>
 * where <code>Foo</code> is an arbitrary name are invoked by the generated methods.
 * <p/>
 * If the optional "properties" property is specified, the getters for properties of the indicated names are called
 * instead.
 * 
 * @author Zachary Palmer
 */
public class GenerateEqualsAndHashCode extends AbstractBsjMetaAnnotationMetaprogram
{
	/** The explicitly-specified list of properties. */
	private String[] properties = null;

	public GenerateEqualsAndHashCode()
	{
		super(Arrays.asList("equalsAndHashCode"), Arrays.asList("property"));
	}

	@BsjMetaAnnotationElementGetter
	public String[] getProperties()
	{
		return this.properties;
	}

	@BsjMetaAnnotationElementSetter
	public void setProperties(String[] properties)
	{
		this.properties = properties;
	}

	@Override
	protected void execute(Context<MetaAnnotationMetaprogramAnchorNode> context)
	{
		// Find our enclosing type declaration. It must be an enum or a class for this to work.
		TypeDeclarationNode enclosingTypeDeclaration = context.getAnchor().getNearestAncestorOfType(
				TypeDeclarationNode.class);
		ClassMemberListNode members;
		if (enclosingTypeDeclaration instanceof ClassDeclarationNode)
		{
			members = ((ClassDeclarationNode) enclosingTypeDeclaration).getBody().getMembers();
		} else if (enclosingTypeDeclaration instanceof EnumDeclarationNode)
		{
			members = ((EnumDeclarationNode) enclosingTypeDeclaration).getBody().getMembers();
		} else
		{
			List<Class<? extends TypeDeclarationNode>> typeDeclarationList = new ArrayList<Class<? extends TypeDeclarationNode>>();
			typeDeclarationList.add(ClassDeclarationNode.class);
			typeDeclarationList.add(EnumDeclarationNode.class);
			context.getDiagnosticListener().report(
					new InvalidEnclosingTypeDiagnosticImpl(getClass(), enclosingTypeDeclaration, typeDeclarationList));
			throw new MetaprogramExecutionFailureException();
		}

		// Establish the list of properties we will be using
		List<Pair<String, TypeNode>> getterDescriptions = new ArrayList<Pair<String, TypeNode>>();
		if (this.properties == null)
		{
			for (ClassMemberNode member : members)
			{
				if (member instanceof MethodDeclarationNode)
				{
					MethodDeclarationNode methodDecl = (MethodDeclarationNode) member;
					if (methodDecl.getIdentifier().getIdentifier().startsWith("get")
							&& methodDecl.getParameters().size() == 0
							&& (!(methodDecl.getReturnType() instanceof PrimitiveTypeNode) || (((PrimitiveTypeNode) (methodDecl.getReturnType())).getPrimitiveType() != PrimitiveType.VOID)))
					{
						getterDescriptions.add(new Pair<String, TypeNode>(methodDecl.getIdentifier().getIdentifier(),
								methodDecl.getReturnType()));
					}
				}
			}
		} else
		{
			Map<String, MethodDeclarationNode> methodMap = new HashMap<String, MethodDeclarationNode>();
			for (ClassMemberNode member : members)
			{
				if (member instanceof MethodDeclarationNode)
				{
					MethodDeclarationNode methodDecl = (MethodDeclarationNode) member;
					methodMap.put(methodDecl.getIdentifier().getIdentifier(), methodDecl);
				}
			}
			for (String propName : this.properties)
			{
				String getterName = "get" + Character.toUpperCase(propName.charAt(0)) + propName.substring(1);
				MethodDeclarationNode getterDeclaration = methodMap.get(getterName);
				if (getterDeclaration == null)
				{
					context.getDiagnosticListener().report(
							new MissingMethodDeclarationDiagnosticImpl(members, getterName));
					throw new MetaprogramExecutionFailureException();
				}
				getterDescriptions.add(new Pair<String, TypeNode>(getterName, getterDeclaration.getReturnType()));
			}
		}

		// Now generate equals and hashCode methods
		members.add(generateEquals(context, getterDescriptions));
		members.add(generateHashCode(context, getterDescriptions));
	}

	private MethodDeclarationNode generateEquals(Context<MetaAnnotationMetaprogramAnchorNode> context,
			List<Pair<String, TypeNode>> getters)
	{
		// Determine whether or not a call to super.equals is appropriate.
		// This is the case if any of the type declarations above this one declare equals (except for java.lang.Object)
		boolean invokeSuper = false; // TODO

		BsjNodeFactory factory = context.getFactory();
		List<BlockStatementNode> statements = new ArrayList<BlockStatementNode>();

		// if (this == o) return true;
		statements.add(factory.makeIfNode(factory.makeBinaryExpressionNode(factory.makeThisNode(),
				factory.makeFieldAccessByNameNode(factory.parseNameNode("o")), BinaryOperator.EQUAL),
				factory.makeReturnNode(factory.makeBooleanLiteralNode(true))));

		// if (obj == null) return false;
		statements.add(factory.makeIfNode(factory.makeBinaryExpressionNode(
				factory.makeFieldAccessByNameNode(factory.parseNameNode("o")), factory.makeNullLiteralNode(),
				BinaryOperator.EQUAL), factory.makeReturnNode(factory.makeBooleanLiteralNode(false))));

		// if (getClass() != obj.getClass()) return false;
		statements.add(factory.makeIfNode(factory.makeBinaryExpressionNode(
				factory.makeMethodInvocationByNameNode(factory.parseNameNode("getClass")),
				factory.makeMethodInvocationByExpressionNode(
						factory.makeFieldAccessByNameNode(factory.parseNameNode("o")),
						factory.makeIdentifierNode("getClass")), BinaryOperator.NOT_EQUAL),
				factory.makeReturnNode(factory.makeBooleanLiteralNode(false))));

		// if (!super.equals(o)) return false;
		if (invokeSuper)
		{
			statements.add(factory.makeIfNode(factory.makeUnaryExpressionNode(factory.makeSuperMethodInvocationNode(
					factory.makeIdentifierNode("equals"),
					factory.makeExpressionListNode(factory.makeFieldAccessByNameNode(factory.parseNameNode("o")))),
					UnaryOperator.LOGICAL_COMPLEMENT), factory.makeReturnNode(factory.makeBooleanLiteralNode(false))));
		}

		// MyClass other = (MyClass) o;
		NamedTypeDeclarationNode<?> enclosingDeclaration = context.getAnchor().getNearestAncestorOfType(
				NamedTypeDeclarationNode.class);
		// TODO: what if we have a type parameter?
		statements.add(factory.makeVariableDeclarationNode(factory.makeVariableDeclaratorListNode(factory.makeVariableDeclaratorNode(
				factory.makeUnparameterizedTypeNode(factory.parseNameNode(enclosingDeclaration.getIdentifier().getIdentifier())),
				factory.makeIdentifierNode("other"),
				factory.makeTypeCastNode(
						factory.makeFieldAccessByNameNode(factory.parseNameNode("o")),
						factory.makeUnparameterizedTypeNode(factory.parseNameNode(enclosingDeclaration.getIdentifier().getIdentifier())))))));

		// For each property, do some kind of comparison on it
		for (Pair<String, TypeNode> getter : getters)
		{
			String getterName = getter.getFirst();
			TypeNode type = getter.getSecond();
			ExpressionNode comparisonExpressionNode;
			PrimaryExpressionNode thisGetterNode = factory.makeMethodInvocationByNameNode(factory.parseNameNode(getterName));
			PrimaryExpressionNode otherGetterNode = factory.makeMethodInvocationByExpressionNode(
					factory.makeFieldAccessByNameNode(factory.parseNameNode("other")),
					factory.makeIdentifierNode(getterName));
			if (type instanceof PrimitiveTypeNode)
			{
				// then compare using ==
				comparisonExpressionNode = factory.makeBinaryExpressionNode(thisGetterNode, otherGetterNode,
						BinaryOperator.EQUAL);
			} else if (type instanceof ArrayTypeNode)
			{
				// then compare using Arrays.equals
				comparisonExpressionNode = factory.makeMethodInvocationByNameNode(
						factory.parseNameNode("java.util.Arrays.equals"), factory.makeExpressionListNode(
								thisGetterNode, otherGetterNode));

			} else
			{
				// then compare using null check and .equals
				comparisonExpressionNode = factory.makeBinaryExpressionNode(factory.makeBinaryExpressionNode(
						factory.makeBinaryExpressionNode(thisGetterNode.deepCopy(factory),
								factory.makeNullLiteralNode(), BinaryOperator.EQUAL),
						factory.makeBinaryExpressionNode(otherGetterNode.deepCopy(factory),
								factory.makeNullLiteralNode(), BinaryOperator.EQUAL), BinaryOperator.CONDITIONAL_AND),
						factory.makeBinaryExpressionNode(factory.makeBinaryExpressionNode(
								thisGetterNode.deepCopy(factory), factory.makeNullLiteralNode(),
								BinaryOperator.NOT_EQUAL), factory.makeMethodInvocationByExpressionNode(thisGetterNode,
								factory.makeIdentifierNode("equals"), factory.makeExpressionListNode(otherGetterNode)),
								BinaryOperator.CONDITIONAL_AND), BinaryOperator.CONDITIONAL_OR);
			}
			// Now that we have our comparison mechanism, add the statement
			statements.add(factory.makeIfNode(comparisonExpressionNode,
					factory.makeReturnNode(factory.makeBooleanLiteralNode(true))));
		}

		// Add final return false
		statements.add(factory.makeReturnNode(factory.makeBooleanLiteralNode(false)));

		// Return method enclosing this list of statements
		return factory.makeMethodDeclarationNode(factory.makeBlockNode(factory.makeBlockStatementListNode(statements)),
				factory.makeMethodModifiersNode(AccessModifier.PUBLIC), factory.makeIdentifierNode("equals"),
				factory.makeVariableListNode(factory.makeVariableNode(
						factory.makeUnparameterizedTypeNode(factory.parseNameNode("java.lang.Object")),
						factory.makeIdentifierNode("o"))), factory.makePrimitiveTypeNode(PrimitiveType.BOOLEAN), null);
		// TODO: javadoc
	}

	private MethodDeclarationNode generateHashCode(Context<MetaAnnotationMetaprogramAnchorNode> context,
			List<Pair<String, TypeNode>> getters)
	{
		BsjNodeFactory factory = context.getFactory();
		List<BlockStatementNode> statements = new ArrayList<BlockStatementNode>();

		// final int prime = 31;
		statements.add(factory.makeVariableDeclarationNode(factory.makeVariableModifiersNode(true,
				factory.makeMetaAnnotationListNode(), factory.makeAnnotationListNode()),
				factory.makeVariableDeclaratorListNode(factory.makeVariableDeclaratorNode(
						factory.makePrimitiveTypeNode(PrimitiveType.INT), factory.makeIdentifierNode("prime"),
						factory.makeIntLiteralNode(31)))));

		// int result = 1;
		statements.add(factory.makeVariableDeclarationNode(factory.makeVariableDeclaratorListNode(factory.makeVariableDeclaratorNode(
				factory.makePrimitiveTypeNode(PrimitiveType.INT), factory.makeIdentifierNode("result"),
				factory.makeIntLiteralNode(1)))));

		// for each property, bring in some change to the hash
		for (Pair<String, TypeNode> getter : getters)
		{
			String getterName = getter.getFirst();
			TypeNode type = getter.getSecond();
			ExpressionNode hashValueNode;
			PrimaryExpressionNode getterCallNode = factory.makeMethodInvocationByNameNode(factory.parseNameNode(getterName));
			if (type instanceof PrimitiveTypeNode)
			{
				PrimitiveTypeNode primitiveTypeNode = (PrimitiveTypeNode) type;
				switch (primitiveTypeNode.getPrimitiveType())
				{
					case BOOLEAN:
						// x ? 1 : 0
						hashValueNode = factory.makeConditionalExpressionNode(getterCallNode,
								factory.makeIntLiteralNode(1), factory.makeIntLiteralNode(0));
						break;
					case DOUBLE:
					case FLOAT:
					case LONG:
						// (int)x
						hashValueNode = factory.makeTypeCastNode(getterCallNode,
								factory.makePrimitiveTypeNode(PrimitiveType.INT));
						break;
					default:
						// x
						hashValueNode = getterCallNode;
				}
			} else if (type instanceof ArrayTypeNode)
			{
				// then use Arrays.hashCode
				hashValueNode = factory.makeMethodInvocationByNameNode(
						factory.parseNameNode("java.util.Arrays.hashCode"),
						factory.makeExpressionListNode(getterCallNode));

			} else
			{
				// then compare using null check and .hashCode
				hashValueNode = factory.makeConditionalExpressionNode(factory.makeBinaryExpressionNode(
						getterCallNode.deepCopy(factory), factory.makeNullLiteralNode(), BinaryOperator.EQUAL),
						factory.makeIntLiteralNode(0), factory.makeMethodInvocationByExpressionNode(getterCallNode,
								factory.makeIdentifierNode("hashCode")));
			}
			// Now that we have our hash adjustment mechanism, add the statement
			statements.add(factory.makeExpressionStatementNode(factory.makeAssignmentNode(
					factory.makeFieldAccessByNameNode(factory.parseNameNode("result")), AssignmentOperator.ASSIGNMENT,
					factory.makeBinaryExpressionNode(
							factory.makeBinaryExpressionNode(
									factory.makeFieldAccessByNameNode(factory.parseNameNode("result")),
									factory.makeFieldAccessByNameNode(factory.parseNameNode("prime")),
									BinaryOperator.MULTIPLY), hashValueNode, BinaryOperator.PLUS))));
		}

		// Add final return
		statements.add(factory.makeReturnNode(factory.makeFieldAccessByNameNode(factory.parseNameNode("result"))));

		// Create hashCode method
		return factory.makeMethodDeclarationNode(factory.makeBlockNode(factory.makeBlockStatementListNode(statements)),
				factory.makeMethodModifiersNode(AccessModifier.PUBLIC), factory.makeIdentifierNode("hashCode"),
				factory.makeVariableListNode(), factory.makePrimitiveTypeNode(PrimitiveType.INT), null);
		// TODO: javadoc
	}

	@Override
	public void complete() throws InvalidMetaAnnotationConfigurationException
	{
	}
}
