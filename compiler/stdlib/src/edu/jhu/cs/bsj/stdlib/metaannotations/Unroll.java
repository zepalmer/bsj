package edu.jhu.cs.bsj.stdlib.metaannotations;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import edu.jhu.cs.bsj.compiler.ast.BinaryOperator;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.MetaprogramLocalMode;
import edu.jhu.cs.bsj.compiler.ast.MetaprogramPackageMode;
import edu.jhu.cs.bsj.compiler.ast.UnaryStatementOperator;
import edu.jhu.cs.bsj.compiler.ast.node.BinaryExpressionNode;
import edu.jhu.cs.bsj.compiler.ast.node.ExpressionNode;
import edu.jhu.cs.bsj.compiler.ast.node.ForInitializerDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.ForLoopNode;
import edu.jhu.cs.bsj.compiler.ast.node.IntLiteralNode;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.StatementExpressionNode;
import edu.jhu.cs.bsj.compiler.ast.node.StatementNode;
import edu.jhu.cs.bsj.compiler.ast.node.UnaryStatementExpressionNode;
import edu.jhu.cs.bsj.compiler.ast.node.VariableAccessNode;
import edu.jhu.cs.bsj.compiler.ast.node.VariableDeclaratorNode;
import edu.jhu.cs.bsj.compiler.ast.node.VariableInitializerNode;
import edu.jhu.cs.bsj.compiler.ast.node.VariableNameBindingNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.BlockStatementListNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.StatementExpressionListNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaAnnotationMetaprogramAnchorNode;
import edu.jhu.cs.bsj.compiler.ast.util.BsjTypedNodeNoOpVisitor;
import edu.jhu.cs.bsj.compiler.impl.utils.NotImplementedYetException;
import edu.jhu.cs.bsj.compiler.metaannotation.InvalidMetaAnnotationConfigurationException;
import edu.jhu.cs.bsj.compiler.metaprogram.AbstractBsjMetaAnnotationMetaprogram;
import edu.jhu.cs.bsj.compiler.metaprogram.Context;

public class Unroll extends AbstractBsjMetaAnnotationMetaprogram {

	public Unroll() {
		super(Collections.<String> emptyList(), Collections
				.<String> emptyList(), Collections.<String> emptyList(),
				MetaprogramLocalMode.MUTATE, MetaprogramPackageMode.READ_ONLY);
	}

	@Override
	public void complete() throws InvalidMetaAnnotationConfigurationException {

	}

	@Override
	protected void execute(Context<MetaAnnotationMetaprogramAnchorNode> context) {
		// TODO: what if we're not actually annotating the for loop?
		// TODO: check all of the following assumptions

		final BsjNodeFactory factory = context.getFactory();
		ForLoopNode forLoopNode = context.getAnchor().getNearestAncestorOfType(
				ForLoopNode.class);
		ForInitializerDeclarationNode initializerNode = (ForInitializerDeclarationNode) forLoopNode
				.getInitializer();
		StatementNode statementNode = forLoopNode.getStatement();
		BlockStatementListNode forLoopParent = (BlockStatementListNode) forLoopNode
				.getParent();
		StatementExpressionListNode updatesNode = forLoopNode.getUpdate();
		StatementExpressionNode updateNode = updatesNode.get(0);
		final VariableDeclaratorNode declarator = initializerNode
				.getDeclaration().getDeclarators().get(0);
		VariableInitializerNode init = declarator.getInitializer();

		// TODO: how better to get the constant expression?
		int iterator = Integer.parseInt(init.toSourceCode());
		Condition condition = createCondition(forLoopNode.getCondition(),
				declarator);
		Updater updater = createUpdater(updateNode, declarator);
		while (condition.evaluate(iterator)) {
			// Insert specialized loop body
			StatementNode copiedBody = statementNode.deepCopy(factory);
			final int finalIterator = iterator;
			forLoopNode.setStatement(copiedBody); // TODO - cheap! fix this!
			final Map<Node, Node> replacementMap = new HashMap<Node, Node>();
			copiedBody.receiveTyped(new BsjTypedNodeNoOpVisitor() {

				@Override
				public void visitVariableAccessNodeStop(
						VariableAccessNode node, boolean mostSpecific) {

					if (checkRefersTo(node, declarator)) {
						IntLiteralNode newLiteral = factory
								.makeIntLiteralNode(finalIterator);
						replacementMap.put(node, newLiteral);
					}
				}

			});
			forLoopNode.setStatement(statementNode);// TODO needs to be fixed
													// along with the one above
			for (Map.Entry<Node, Node> entry : replacementMap.entrySet()) {
				entry.getKey().getParent()
						.replace(entry.getKey(), entry.getValue());

			}
			forLoopParent.addBefore(forLoopNode, copiedBody);

			// Update iterator
			iterator = updater.update(iterator);

		}

		forLoopParent.remove(forLoopNode);
	}

	private Condition createCondition(ExpressionNode expNode,
			VariableDeclaratorNode declaratorNode) {
		if (expNode instanceof BinaryExpressionNode) {
			BinaryExpressionNode binaryExpression = (BinaryExpressionNode) expNode;
			if (binaryExpression.getOperator().equals(BinaryOperator.LESS_THAN)) {
				if (binaryExpression.getLeftOperand() instanceof VariableAccessNode) {
					if (checkRefersTo(
							(VariableAccessNode) binaryExpression
									.getLeftOperand(),
							declaratorNode)) {
						if (binaryExpression.getRightOperand() instanceof IntLiteralNode) {
							final int bound = ((IntLiteralNode) binaryExpression
									.getRightOperand()).getValue();
							return new Condition() {

								@Override
								public boolean evaluate(int value) {
									return value < bound;
								}
							};

						} else {
							throw new NotImplementedYetException();
						}
					} else {
						throw new NotImplementedYetException();
					}
				} else {
					throw new NotImplementedYetException();
				}
			} else {
				throw new NotImplementedYetException();
			}
		} else {
			throw new NotImplementedYetException();
		}
	}

	private boolean checkRefersTo(VariableAccessNode accessNode,
			VariableDeclaratorNode declaratorNode) {
		if (accessNode.getExpression() != null) {
			return false;
		} else {
			if (accessNode.getIdentifier().getIdentifier()
					.equals(declaratorNode.getIdentifier().getIdentifier())) {
				Collection<? extends VariableNameBindingNode> bindings = accessNode
						.getVariableDeclarationsInScope(declaratorNode
								.getIdentifier().getIdentifier());
				if (bindings.size() == 1) {
					return bindings.iterator().next().equals(declaratorNode);
				} else {
					throw new NotImplementedYetException();
				}
			} else {
				return false;
			}
		}
	}

	private Updater createUpdater(StatementExpressionNode updateExp,
			VariableDeclaratorNode declaratorNode) {
		if (updateExp instanceof UnaryStatementExpressionNode) {
			UnaryStatementExpressionNode unaryExp = (UnaryStatementExpressionNode) updateExp;

			if (unaryExp.getOperator().equals(
					UnaryStatementOperator.POSTFIX_INCREMENT)) {
				if (unaryExp.getExpression() instanceof VariableAccessNode) {
					if (checkRefersTo(
							(VariableAccessNode) unaryExp.getExpression(),
							declaratorNode)) {
						return new Updater() {

							@Override
							public int update(int updateValue) {
								return updateValue + 1;
							}
						};

					} else {
						throw new NotImplementedYetException();
					}
				} else {
					throw new NotImplementedYetException();
				}

			} else {
				throw new NotImplementedYetException();
			}
		} else {
			throw new NotImplementedYetException();
		}
	}

	private static interface Condition {
		public boolean evaluate(int value);

	}

	private static interface Updater {
		public int update(int updateValue);
	}
}
