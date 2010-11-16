package edu.jhu.cs.bsj.stdlib.metaannotations;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.tools.Diagnostic;
import javax.tools.DiagnosticListener;

import edu.jhu.cs.bsj.compiler.ast.AssignmentOperator;
import edu.jhu.cs.bsj.compiler.ast.BinaryOperator;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.MetaprogramLocalMode;
import edu.jhu.cs.bsj.compiler.ast.MetaprogramPackageMode;
import edu.jhu.cs.bsj.compiler.ast.UnaryStatementOperator;
import edu.jhu.cs.bsj.compiler.ast.node.AssignmentNode;
import edu.jhu.cs.bsj.compiler.ast.node.BinaryExpressionNode;
import edu.jhu.cs.bsj.compiler.ast.node.BlockStatementNode;
import edu.jhu.cs.bsj.compiler.ast.node.ClassDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.ExpressionNode;
import edu.jhu.cs.bsj.compiler.ast.node.IdentifierNode;
import edu.jhu.cs.bsj.compiler.ast.node.MethodDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.MethodInvocationNode;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.PrimaryExpressionNode;
import edu.jhu.cs.bsj.compiler.ast.node.TypeNameBindingNode;
import edu.jhu.cs.bsj.compiler.ast.node.UnaryExpressionNode;
import edu.jhu.cs.bsj.compiler.ast.node.UnaryStatementExpressionNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaAnnotationMetaprogramAnchorNode;
import edu.jhu.cs.bsj.compiler.ast.util.BsjTypedNodeNoOpVisitor;
import edu.jhu.cs.bsj.compiler.impl.utils.NotImplementedYetException;
import edu.jhu.cs.bsj.compiler.lang.type.BsjDeclaredType;
import edu.jhu.cs.bsj.compiler.lang.type.BsjErrorType;
import edu.jhu.cs.bsj.compiler.lang.type.BsjPrimitiveType;
import edu.jhu.cs.bsj.compiler.metaannotation.InvalidMetaAnnotationConfigurationException;
import edu.jhu.cs.bsj.compiler.metaprogram.AbstractBsjMetaAnnotationMetaprogram;
import edu.jhu.cs.bsj.compiler.metaprogram.Context;
import edu.jhu.cs.bsj.compiler.tool.typechecker.BsjTypechecker;
import edu.jhu.cs.bsj.compiler.tool.typechecker.TypecheckerResult;

public class BigIntegerOperatorOverloading extends AbstractBsjMetaAnnotationMetaprogram {

	BsjTypechecker typeChecker;

	public BigIntegerOperatorOverloading() {
		super(Collections.<String> emptyList(), Collections
				.<String> emptyList(), Collections.<String> emptyList(),
				MetaprogramLocalMode.MUTATE, MetaprogramPackageMode.READ_ONLY);
	}

	@Override
	public void complete() throws InvalidMetaAnnotationConfigurationException {

	}

	@Override
	protected void execute(
			Context<MetaAnnotationMetaprogramAnchorNode, MetaAnnotationMetaprogramAnchorNode> context) {
		BlockStatementNode statementNode = context.getAnchor()
				.getNearestAncestorOfType(BlockStatementNode.class);
		if (statementNode == null) {
			MethodDeclarationNode methodDeclNode = context.getAnchor()
					.getNearestAncestorOfType(MethodDeclarationNode.class);
			statementType(methodDeclNode, context);
		} else {
			statementType(statementNode, context);
		}

	}

	private void statementType(
			Node statementNode,
			final Context<MetaAnnotationMetaprogramAnchorNode, MetaAnnotationMetaprogramAnchorNode> context) {
		final Map<ExpressionNode, ExpressionNode> replacementMap = new HashMap<ExpressionNode, ExpressionNode>();

		boolean anyChanges;
		do {
			anyChanges = false;
			statementNode.receiveTyped(new BsjTypedNodeNoOpVisitor() {
				/*
				 * The algo: Go down the entire tree and check if a node
				 * statement is type checked if it type checks convert it into
				 * the corresponding code else put the expression in a list to
				 * see if an expression type checks once the list is done finish
				 * the execution
				 */
				@Override
				public void visitBinaryExpressionNodeStop(
						BinaryExpressionNode node, boolean mostSpecific) {
					ExpressionNode rightExpNode = node.getRightOperand();
					ExpressionNode leftExpNode = node.getLeftOperand();
					BinaryOperator operator = node.getOperator();
					if (!validOperator(operator))
						return;
					if (typeCheckerSubTypes(leftExpNode, context,
							"java.math.BigInteger")
							|| typeCheckerSubTypes(rightExpNode, context,
									"java.math.BigInteger")) {
						ExpressionNode afterNode = convertNodes(node);
						if (afterNode != null)
							replacementMap.put(node, afterNode);
					}
				}

				private ExpressionNode convertNodes(BinaryExpressionNode node) {
					BinaryOperator operator = node.getOperator();
					ExpressionNode rightExpNode = node.getRightOperand();
					ExpressionNode leftExpNode = node.getLeftOperand();

					if (operator.equals(BinaryOperator.EQUAL)) {
						if (!typeChecker(leftExpNode, context)
								|| !typeChecker(rightExpNode, context))
							return null;
					}

					leftExpNode = getBigIntergerExpressionNode(leftExpNode,
							context);
					if (leftExpNode == null)
						return null;
					rightExpNode = getBigIntergerExpressionNode(rightExpNode,
							context);
					if (rightExpNode == null)
						return null;

					/*
					 * IdentifierNode identifierNode = context.getFactory()
					 * .makeIdentifierNode(DetermineOperator(operator));
					 * MethodInvocationNode afterNode = context .getFactory()
					 * .makeMethodInvocationNode( (PrimaryExpressionNode)
					 * leftExpNode .deepCopy(context.getFactory()),
					 * identifierNode, context.getFactory()
					 * .makeExpressionListNode( rightExpNode.deepCopy(context
					 * .getFactory())));
					 */

					ExpressionNode afterNode;
					String ops = DetermineOperator(operator);
					if (!ops.equals("")) {
						afterNode = makeArithMethodNode(context, leftExpNode,
								rightExpNode, ops);
					} else {
						afterNode = makeLogicalMethodNode(context, leftExpNode,
								rightExpNode, operator);
					}

					return afterNode;

				}

				@Override
				public void visitUnaryExpressionNodeStop(
						UnaryExpressionNode node, boolean mostSpecific) {
					// TODO: this is where the unary expressions come
					// for example for(BigInteger i;i<20;i++)
					// there would be operator overloading of the expression i++
					System.out.println("hello");
				}

				@Override
				public void visitUnaryStatementExpressionNodeStop(
						UnaryStatementExpressionNode node, boolean mostSpecific) {
					ExpressionNode expNode = node.getExpression();
					UnaryStatementOperator operator = node.getOperator();
					if (!validOperator(operator))
						return;
					if (typeChecker(expNode, context)) {
						ExpressionNode afterNode = convertUnaryStatementExpression(
								node, context);
						replacementMap.put(node, afterNode);
					}
				}

			});
			Iterator<ExpressionNode> keySet = replacementMap.keySet()
					.iterator();
			while (keySet.hasNext()) {
				ExpressionNode beforeNode = (ExpressionNode) keySet.next();
				ExpressionNode afterNode = replacementMap.get(beforeNode);
				beforeNode.getParent().replace(beforeNode, afterNode);
				anyChanges = true;
			}
			replacementMap.clear();
		} while (anyChanges);

	}

	protected ExpressionNode makeLogicalMethodNode(
			Context<MetaAnnotationMetaprogramAnchorNode, MetaAnnotationMetaprogramAnchorNode> context,
			ExpressionNode leftExpNode, ExpressionNode rightExpNode,
			BinaryOperator operator) {

		final BsjNodeFactory factory = context.getFactory();
		ExpressionNode rightOperand = makeCompareToNode(leftExpNode,
				rightExpNode, context);
		ExpressionNode leftOperand = null;

		ExpressionNode leftEqualsOperand = factory.makeLongLiteralNode(0L);
		ExpressionNode equalsNode = factory
				.makeParenthesizedExpressionNode(factory
						.makeBinaryExpressionNode(
								leftEqualsOperand.deepCopy(factory),
								rightOperand.deepCopy(factory),
								BinaryOperator.EQUAL));

		if (operator.equals(BinaryOperator.LESS_THAN)
				|| operator.equals(BinaryOperator.LESS_THAN_EQUAL)) {
			ExpressionNode lessThanNode = factory.makeLongLiteralNode(-1L);
			leftOperand = factory.makeParenthesizedExpressionNode(factory
					.makeBinaryExpressionNode(lessThanNode.deepCopy(factory),
							rightOperand.deepCopy(factory),
							BinaryOperator.EQUAL));

		} else if (operator.equals(BinaryOperator.GREATER_THAN)
				|| operator.equals(BinaryOperator.GREATER_THAN_EQUAL)) {
			ExpressionNode lessThanNode = factory.makeLongLiteralNode(1L);
			leftOperand = factory.makeParenthesizedExpressionNode(factory
					.makeBinaryExpressionNode(lessThanNode.deepCopy(factory),
							rightOperand.deepCopy(factory),
							BinaryOperator.EQUAL));

		} else if (operator.equals(BinaryOperator.EQUAL)) {
			return equalsNode.deepCopy(factory);
		}

		if (operator.equals(BinaryOperator.LESS_THAN_EQUAL)
				|| operator.equals(BinaryOperator.GREATER_THAN_EQUAL)) {
			if (leftOperand == null)
				return null;
			return factory.makeBinaryExpressionNode(leftOperand, equalsNode,
					BinaryOperator.CONDITIONAL_OR);
		}

		return leftOperand;

	}

	private ExpressionNode makeCompareToNode(
			ExpressionNode leftExpNode,
			ExpressionNode rightExpNode,
			Context<MetaAnnotationMetaprogramAnchorNode, MetaAnnotationMetaprogramAnchorNode> context) {

		final BsjNodeFactory factory = context.getFactory();
		ExpressionNode afterNode = factory.makeMethodInvocationNode(
				(PrimaryExpressionNode) leftExpNode.deepCopy(factory),
				factory.makeIdentifierNode("compareTo"),
				context.getFactory().makeExpressionListNode(
						rightExpNode.deepCopy(context.getFactory())));
		return afterNode;
	}

	protected ExpressionNode makeArithMethodNode(
			Context<MetaAnnotationMetaprogramAnchorNode, MetaAnnotationMetaprogramAnchorNode> context,
			ExpressionNode leftExpNode, ExpressionNode rightExpNode, String ops) {

		IdentifierNode identifierNode = context.getFactory()
				.makeIdentifierNode(ops);
		MethodInvocationNode afterNode = context.getFactory()
				.makeMethodInvocationNode(
						(PrimaryExpressionNode) leftExpNode.deepCopy(context
								.getFactory()),
						identifierNode,
						context.getFactory().makeExpressionListNode(
								rightExpNode.deepCopy(context.getFactory())));
		return afterNode;
	}

	private ExpressionNode convertUnaryStatementExpression(
			UnaryStatementExpressionNode typeNode,
			Context<MetaAnnotationMetaprogramAnchorNode, MetaAnnotationMetaprogramAnchorNode> context) {
		ExpressionNode expNode = null;
		UnaryStatementOperator operator = typeNode.getOperator();
		if (operator.equals(UnaryStatementOperator.POSTFIX_INCREMENT)
				|| operator.equals(UnaryStatementOperator.PREFIX_INCREMENT)) {
			expNode = getPlusOneExpression(typeNode, context);
			if (operator.equals(UnaryStatementOperator.PREFIX_INCREMENT)) {
				BsjNodeFactory factory = context.getFactory();
				return factory.makeMethodInvocationNode(factory
						.makeParenthesizedExpressionNode(expNode), factory
						.makeIdentifierNode("add"), factory
						.makeExpressionListNode(factory
								.makeLongLiteralNode(-1L)));
			}
		} else {
			throw new NotImplementedYetException();
		}

		return expNode;
	}

	private static PrimaryExpressionNode makeBigIntegerOne(
			BsjNodeFactory factory) {
		return factory.makeVariableAccessNode(factory.makeVariableAccessNode(
				factory.makeVariableAccessNode(factory
						.makeVariableAccessNode(factory
								.makeIdentifierNode("java")), factory
						.makeIdentifierNode("math")), factory
						.makeIdentifierNode("BigInteger")), factory
				.makeIdentifierNode("ONE"));

	}

	private AssignmentNode getPlusOneExpression(
			UnaryStatementExpressionNode unaryNode,
			Context<MetaAnnotationMetaprogramAnchorNode, MetaAnnotationMetaprogramAnchorNode> context) {
		final BsjNodeFactory factory = context.getFactory();
		PrimaryExpressionNode one = makeBigIntegerOne(factory);
		return factory.makeAssignmentNode(
				unaryNode.getExpression().deepCopy(factory),
				AssignmentOperator.ASSIGNMENT, factory
						.makeMethodInvocationNode(
								factory.makeParenthesizedExpressionNode(
										unaryNode.getExpression().deepCopy(
												factory)).deepCopy(factory),
								factory.makeIdentifierNode("add"),
								factory.makeExpressionListNode(one)));
	}

	/*
	 * given a expression node we would like to know if it is a valid sub type
	 * of Big Integer the current implementation accepts for long as a sub type
	 * of big integer
	 */
	private boolean typeCheckerSubTypes(
			ExpressionNode typeCheckerNode,
			Context<MetaAnnotationMetaprogramAnchorNode, MetaAnnotationMetaprogramAnchorNode> context,
			String javaType) {
		BsjTypechecker typeChecker = getTypeChecker(context, typeCheckerNode);
		TypecheckerResult result = typeChecker.typecheck(typeCheckerNode);
		if (result.getType() instanceof BsjDeclaredType) {
			BsjDeclaredType declType = (BsjDeclaredType) result.getType();
			if (declType instanceof BsjErrorType)
				return false;
			TypeNameBindingNode declNode = declType.asElement()
					.getDeclarationNode();
			if (declNode instanceof ClassDeclarationNode) {
				ClassDeclarationNode classDeclNode = (ClassDeclarationNode) declNode;
				if (classDeclNode.getFullyQualifiedName().equals(javaType)) {
					return true;
				}
			}
		} else if (result.getType() instanceof BsjPrimitiveType) {
			switch (((BsjPrimitiveType) result.getType()).getPrimitiveType()) {
			case LONG:
			case INT:
			case SHORT:
			case CHAR:
			case BYTE:
				return true;
			}
		}
		return false;
	}

	/*
	 * this method converts a node to java.math.biginteger, it asks a node if
	 * its
	 */
	public ExpressionNode getBigIntergerExpressionNode(
			ExpressionNode nodeCanBeBigInteger,
			Context<MetaAnnotationMetaprogramAnchorNode, MetaAnnotationMetaprogramAnchorNode> context) {
		/*
		 * check if the expression node is a long
		 */
		final BsjNodeFactory factory = context.getFactory();
		if (typeCheckerSubTypes(nodeCanBeBigInteger, context, "java.lang.Long")) {
			return factory.makeMethodInvocationNode(factory
					.makeVariableAccessNode(factory.makeVariableAccessNode(
							factory.makeVariableAccessNode(factory
									.makeIdentifierNode("java")), factory
									.makeIdentifierNode("math")), factory
							.makeIdentifierNode("BigInteger")), factory
					.makeIdentifierNode("valueOf"), factory
					.makeExpressionListNode(nodeCanBeBigInteger
							.deepCopy(factory)));

		} else if (typeCheckerSubTypes(nodeCanBeBigInteger, context,
				"java.math.BigInteger")) {
			return nodeCanBeBigInteger.deepCopy(factory);
		}
		return null;

	}

	/*
	 * given a expression it is type checked for Big Integer
	 */
	private boolean typeChecker(
			Node typeCheckerNode,
			Context<MetaAnnotationMetaprogramAnchorNode, MetaAnnotationMetaprogramAnchorNode> context) {
		BsjTypechecker typeChecker = getTypeChecker(context, typeCheckerNode);
		TypecheckerResult result = typeChecker.typecheck(typeCheckerNode);
		if (result.getType() instanceof BsjDeclaredType) {
			BsjDeclaredType declType = (BsjDeclaredType) result.getType();
			if (declType instanceof BsjErrorType)
				return false;
			TypeNameBindingNode declNode = declType.asElement()
					.getDeclarationNode();
			if (declNode instanceof ClassDeclarationNode) {
				ClassDeclarationNode classDeclNode = (ClassDeclarationNode) declNode;
				if (classDeclNode.getFullyQualifiedName().equals(
						"java.math.BigInteger")) {
					return true;
				}
			}
		}
		return false;
	}

	private BsjTypechecker getTypeChecker(
			Context<MetaAnnotationMetaprogramAnchorNode, MetaAnnotationMetaprogramAnchorNode> context,
			Node typeCheckerNode) {
		if (typeChecker != null) {
			return typeChecker;
		} else {
			return context.getTypecheckerFactory().makeTypechecker(
					typeCheckerNode.getRootPackage(),
					new DiagnosticListener<BsjSourceLocation>() {

						@Override
						public void report(
								Diagnostic<? extends BsjSourceLocation> diagnostic) {

						}
					});
		}
	}

	private boolean validOperator(Enum<?> operEnum) {
		if (operEnum.equals(BinaryOperator.PLUS)
				|| operEnum.equals(UnaryStatementOperator.POSTFIX_INCREMENT)) {
			return true;
		} else if (operEnum.equals(BinaryOperator.GREATER_THAN_EQUAL)
				|| operEnum.equals(BinaryOperator.GREATER_THAN)
				|| operEnum.equals(BinaryOperator.LESS_THAN)
				|| operEnum.equals(BinaryOperator.LESS_THAN_EQUAL)
				|| operEnum.equals(BinaryOperator.EQUAL)) {
			return true;
		} else {
			return false;
		}

	}

	private String DetermineOperator(BinaryOperator operEnum) {

		if (operEnum.equals(BinaryOperator.PLUS)) {
			return "add";
		} else if (operEnum.equals(BinaryOperator.MINUS)) {
			return "sub";
		} else {
			return "";
		}
	}

}
