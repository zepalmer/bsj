package edu.jhu.cs.bsj.stdlib.metaannotations;

import java.util.Collections;
import java.util.Iterator;

import edu.jhu.cs.bsj.compiler.ast.BinaryOperator;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.UnaryStatementOperator;
import edu.jhu.cs.bsj.compiler.ast.node.BinaryExpressionNode;
import edu.jhu.cs.bsj.compiler.ast.node.BlockNode;
import edu.jhu.cs.bsj.compiler.ast.node.BlockStatementNode;
import edu.jhu.cs.bsj.compiler.ast.node.ExpressionNode;
import edu.jhu.cs.bsj.compiler.ast.node.ExpressionStatementNode;
import edu.jhu.cs.bsj.compiler.ast.node.ForInitializerDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.ForLoopNode;
import edu.jhu.cs.bsj.compiler.ast.node.IdentifierNode;
import edu.jhu.cs.bsj.compiler.ast.node.MethodDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.MethodInvocationNode;
import edu.jhu.cs.bsj.compiler.ast.node.StatementExpressionNode;
import edu.jhu.cs.bsj.compiler.ast.node.UnaryStatementExpressionNode;
import edu.jhu.cs.bsj.compiler.ast.node.VariableInitializerNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.ExpressionListNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.StatementExpressionListNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaAnnotationMetaprogramAnchorNode;
import edu.jhu.cs.bsj.compiler.metaannotation.InvalidMetaAnnotationConfigurationException;
import edu.jhu.cs.bsj.compiler.metaprogram.AbstractBsjMetaAnnotationMetaprogram;
import edu.jhu.cs.bsj.compiler.metaprogram.Context;
import edu.jhu.cs.bsj.stdlib.utils.MethodDeclUtils;

public class Unroll extends AbstractBsjMetaAnnotationMetaprogram {

	public Unroll() {
		super(Collections.<String> emptyList(), Collections
				.<String> emptyList());
	}

	@Override
	public void complete() throws InvalidMetaAnnotationConfigurationException {

	}

	@Override
	protected void execute(Context<MetaAnnotationMetaprogramAnchorNode> context) {
		// TODO: what if we're not actually annotating the for loop?

		BsjNodeFactory factory = context.getFactory();
		ForLoopNode forLoopNode = context.getAnchor().getNearestAncestorOfType(
				ForLoopNode.class);
		ForInitializerDeclarationNode initializerNode = (ForInitializerDeclarationNode) forLoopNode
				.getInitializer();
		BlockStatementNode statementNode = (BlockStatementNode) forLoopNode
				.getStatement();
		StatementExpressionListNode updateNode = forLoopNode.getUpdate();
		StatementExpressionNode node = updateNode.get(0);
		BinaryExpressionNode expressionNode = (BinaryExpressionNode) forLoopNode
				.getCondition();
		VariableInitializerNode init = initializerNode.getDeclaration()
				.getDeclarators().get(0).getInitializer();
		IdentifierNode init1 = initializerNode.getDeclaration()
				.getDeclarators().get(0).getIdentifier();

		int initializer = Integer.parseInt(init.toSourceCode()); // TODO: how better to get the constant expression?
		if (expressionNode.getOperator().equals(BinaryOperator.LESS_THAN)) {
			if (node instanceof UnaryStatementExpressionNode) {
				if (((UnaryStatementExpressionNode) node).getOperator().equals(
						UnaryStatementOperator.POSTFIX_INCREMENT)) {

					int condition = Integer.parseInt(expressionNode
							.getRightOperand().toSourceCode());
					MethodDeclarationNode method = MethodDeclUtils
							.getNearestMethodDeclaration(context, this);
					while (initializer < condition) {
						ExpressionNode initExpNode = factory.makeIntLiteralNode(initializer);
						BlockNode newNode = (BlockNode) statementNode
								.deepCopy(factory);
						Iterator iter = newNode.getStatements().iterator();
						while (iter.hasNext()) {
							ExpressionStatementNode stmntNode = (ExpressionStatementNode) iter
									.next();
							ExpressionNode eNode = ((MethodInvocationNode) stmntNode
									.getExpression()).getArguments().get(0);
							if (eNode.toSourceCode().equals(
									init1.toSourceCode())) {
								((MethodInvocationNode) stmntNode
										.getExpression()).getArguments().set(0, initExpNode);
								BlockStatementNode finalStnmntNode = stmntNode.deepCopy(factory);
								method.getBody().add(finalStnmntNode);
							}
						}
						initializer++;
					}
				}
			}
		}

	}
}
