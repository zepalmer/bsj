package edu.jhu.cs.bsj.tests.compiler.tool;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import edu.jhu.cs.bsj.compiler.BsjServiceRegistry;
import edu.jhu.cs.bsj.compiler.ast.AssignmentOperator;
import edu.jhu.cs.bsj.compiler.ast.BinaryOperator;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.tool.BsjToolkit;

public class OperatorPrecedenceTest
{
	@Test
	public void testBinaryOperatorMultiplicativeAndAdditive()
	{
		BsjToolkit toolkit = BsjServiceRegistry.newToolkitFactory().newToolkit();
		BsjNodeFactory factory = toolkit.getNodeFactory();
		Node node = factory.makeBinaryExpressionNode(factory.makeIntLiteralNode(5), factory.makeBinaryExpressionNode(
				factory.makeIntLiteralNode(5), factory.makeIntLiteralNode(5), BinaryOperator.MINUS),
				BinaryOperator.DIVIDE);
		assertEquals(node.executeOperation(toolkit.getSerializer(), null), "5 / (5 - 5)");
	}

	@Test
	public void testBinaryOperatorAdditiveAndShift()
	{
		BsjToolkit toolkit = BsjServiceRegistry.newToolkitFactory().newToolkit();
		BsjNodeFactory factory = toolkit.getNodeFactory();
		Node node = factory.makeBinaryExpressionNode(factory.makeIntLiteralNode(5), factory.makeBinaryExpressionNode(
				factory.makeIntLiteralNode(5), factory.makeIntLiteralNode(5), BinaryOperator.LEFT_SHIFT),
				BinaryOperator.PLUS);
		assertEquals(node.executeOperation(toolkit.getSerializer(), null), "5 + (5 << 5)");
	}

	@Test
	public void testBinaryOperatorShiftAndGreaterThan()
	{
		BsjToolkit toolkit = BsjServiceRegistry.newToolkitFactory().newToolkit();
		BsjNodeFactory factory = toolkit.getNodeFactory();
		Node node = factory.makeBinaryExpressionNode(factory.makeIntLiteralNode(5), factory.makeBinaryExpressionNode(
				factory.makeIntLiteralNode(5), factory.makeIntLiteralNode(5), BinaryOperator.GREATER_THAN),
				BinaryOperator.LEFT_SHIFT);
		assertEquals(node.executeOperation(toolkit.getSerializer(), null), "5 << (5 > 5)");
	}

	@Test
	public void testBinaryOperatorGreaterThanAndEqual()
	{
		BsjToolkit toolkit = BsjServiceRegistry.newToolkitFactory().newToolkit();
		BsjNodeFactory factory = toolkit.getNodeFactory();
		Node node = factory.makeBinaryExpressionNode(factory.makeIntLiteralNode(5), factory.makeBinaryExpressionNode(
				factory.makeIntLiteralNode(5), factory.makeIntLiteralNode(5), BinaryOperator.EQUAL),
				BinaryOperator.GREATER_THAN);
		assertEquals(node.executeOperation(toolkit.getSerializer(), null), "5 > (5 == 5)");
	}

	@Test
	public void testBinaryOperatorEqualAndLogicalAnd()
	{
		BsjToolkit toolkit = BsjServiceRegistry.newToolkitFactory().newToolkit();
		BsjNodeFactory factory = toolkit.getNodeFactory();
		Node node = factory.makeBinaryExpressionNode(factory.makeIntLiteralNode(5), factory.makeBinaryExpressionNode(
				factory.makeIntLiteralNode(5), factory.makeIntLiteralNode(5), BinaryOperator.LOGICAL_AND),
				BinaryOperator.EQUAL);
		assertEquals(node.executeOperation(toolkit.getSerializer(), null), "5 == (5 & 5)");
	}

	@Test
	public void testBinaryOperatorLogicalAndAndXor()
	{
		BsjToolkit toolkit = BsjServiceRegistry.newToolkitFactory().newToolkit();
		BsjNodeFactory factory = toolkit.getNodeFactory();
		Node node = factory.makeBinaryExpressionNode(factory.makeIntLiteralNode(5), factory.makeBinaryExpressionNode(
				factory.makeIntLiteralNode(5), factory.makeIntLiteralNode(5), BinaryOperator.XOR),
				BinaryOperator.LOGICAL_AND);
		assertEquals(node.executeOperation(toolkit.getSerializer(), null), "5 & (5 ^ 5)");
	}

	@Test
	public void testBinaryOperatorXorAndLogicalOr()
	{
		BsjToolkit toolkit = BsjServiceRegistry.newToolkitFactory().newToolkit();
		BsjNodeFactory factory = toolkit.getNodeFactory();
		Node node = factory.makeBinaryExpressionNode(factory.makeIntLiteralNode(5), factory.makeBinaryExpressionNode(
				factory.makeIntLiteralNode(5), factory.makeIntLiteralNode(5), BinaryOperator.LOGICAL_OR),
				BinaryOperator.XOR);
		assertEquals(node.executeOperation(toolkit.getSerializer(), null), "5 ^ (5 | 5)");
	}

	@Test
	public void testBinaryOperatorLogicalOrAndConditionalAnd()
	{
		BsjToolkit toolkit = BsjServiceRegistry.newToolkitFactory().newToolkit();
		BsjNodeFactory factory = toolkit.getNodeFactory();
		Node node = factory.makeBinaryExpressionNode(factory.makeIntLiteralNode(5), factory.makeBinaryExpressionNode(
				factory.makeIntLiteralNode(5), factory.makeIntLiteralNode(5), BinaryOperator.CONDITIONAL_AND),
				BinaryOperator.LOGICAL_OR);
		assertEquals(node.executeOperation(toolkit.getSerializer(), null), "5 | (5 && 5)");
	}

	@Test
	public void testBinaryOperatorConditionalAndAndConditionalOr()
	{
		BsjToolkit toolkit = BsjServiceRegistry.newToolkitFactory().newToolkit();
		BsjNodeFactory factory = toolkit.getNodeFactory();
		Node node = factory.makeBinaryExpressionNode(factory.makeIntLiteralNode(5), factory.makeBinaryExpressionNode(
				factory.makeIntLiteralNode(5), factory.makeIntLiteralNode(5), BinaryOperator.CONDITIONAL_OR),
				BinaryOperator.CONDITIONAL_AND);
		assertEquals(node.executeOperation(toolkit.getSerializer(), null), "5 && (5 || 5)");
	}

	@Test
	public void testBinaryOperatorAndConditionalExpression()
	{
		BsjToolkit toolkit = BsjServiceRegistry.newToolkitFactory().newToolkit();
		BsjNodeFactory factory = toolkit.getNodeFactory();
		Node node = factory.makeBinaryExpressionNode(factory.makeIntLiteralNode(5),
				factory.makeConditionalExpressionNode(factory.makeIntLiteralNode(5), factory.makeIntLiteralNode(5),
						factory.makeIntLiteralNode(5)), BinaryOperator.CONDITIONAL_AND);
		assertEquals(node.executeOperation(toolkit.getSerializer(), null), "5 && (5 ? 5 : 5)");
	}

	@Test
	public void testBinaryOperatorAndAssignment()
	{
		BsjToolkit toolkit = BsjServiceRegistry.newToolkitFactory().newToolkit();
		BsjNodeFactory factory = toolkit.getNodeFactory();
		Node node = factory.makeBinaryExpressionNode(factory.makeIntLiteralNode(5), factory.makeAssignmentNode(
				factory.makeIntLiteralNode(5), AssignmentOperator.MODULUS_ASSIGNMENT, factory.makeIntLiteralNode(5)),
				BinaryOperator.CONDITIONAL_AND);
		assertEquals(node.executeOperation(toolkit.getSerializer(), null), "5 && (5 %= 5)");
	}

	@Test
	public void testConditionalExpressionAndAssignment()
	{
		BsjToolkit toolkit = BsjServiceRegistry.newToolkitFactory().newToolkit();
		BsjNodeFactory factory = toolkit.getNodeFactory();
		Node node = factory.makeConditionalExpressionNode(factory.makeAssignmentNode(factory.makeIntLiteralNode(5),
				AssignmentOperator.MODULUS_ASSIGNMENT, factory.makeIntLiteralNode(5)), factory.makeAssignmentNode(
				factory.makeIntLiteralNode(5), AssignmentOperator.AND_ASSIGNMENT, factory.makeIntLiteralNode(5)),
				factory.makeAssignmentNode(factory.makeIntLiteralNode(5), AssignmentOperator.DIVIDE_ASSIGNMENT,
						factory.makeIntLiteralNode(5)));
		assertEquals(node.executeOperation(toolkit.getSerializer(), null), "(5 %= 5) ? (5 &= 5) : (5 /= 5)");
	}

	@Test
	public void testIfThenElseGrouping()
	{
		BsjToolkit toolkit = BsjServiceRegistry.newToolkitFactory().newToolkit();
		BsjNodeFactory factory = toolkit.getNodeFactory();
		Node node = factory.makeIfNode(factory.makeBooleanLiteralNode(true), factory.makeIfNode(
				factory.makeBooleanLiteralNode(false), factory.makeNoOperationNode()), factory.makeNoOperationNode());
		String code = node.executeOperation(toolkit.getSerializer(), null);
		code = code.replaceAll("\\s+", " ");
		assertEquals(code, "if (true) { if (false) ;} else ;");
	}
}
