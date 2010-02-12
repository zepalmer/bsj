package edu.jhu.cs.bsj.tests.compiler.tool;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import edu.jhu.cs.bsj.compiler.ast.AssignmentOperator;
import edu.jhu.cs.bsj.compiler.ast.BinaryOperator;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeFactoryImpl;
import edu.jhu.cs.bsj.compiler.impl.tool.serializer.BsjSourceSerializerImpl;


public class OperatorPrecedenceTest
{
    @Test
    public void testBinaryOperatorMultiplicativeAndAdditive()
    {
        BsjNodeFactoryImpl factory = new BsjNodeFactoryImpl();
        Node node = factory.makeBinaryExpressionNode(
                factory.makeIntLiteralNode(5),
                factory.makeBinaryExpressionNode(
                        factory.makeIntLiteralNode(5),
                        factory.makeIntLiteralNode(5), 
                        BinaryOperator.MINUS), 
                BinaryOperator.DIVIDE);
        assertEquals(
                node.executeOperation(new BsjSourceSerializerImpl(), null),
                "5 / (5 - 5)");        
    }
    
    @Test
    public void testBinaryOperatorAdditiveAndShift()
    {
        BsjNodeFactoryImpl factory = new BsjNodeFactoryImpl();
        Node node = factory.makeBinaryExpressionNode(
                factory.makeIntLiteralNode(5),
                factory.makeBinaryExpressionNode(
                        factory.makeIntLiteralNode(5),
                        factory.makeIntLiteralNode(5), 
                        BinaryOperator.LEFT_SHIFT), 
                BinaryOperator.PLUS);
        assertEquals(
                node.executeOperation(new BsjSourceSerializerImpl(), null),
                "5 + (5 << 5)");        
    }
    
    @Test
    public void testBinaryOperatorShiftAndGreaterThan()
    {
        BsjNodeFactoryImpl factory = new BsjNodeFactoryImpl();
        Node node = factory.makeBinaryExpressionNode(
                factory.makeIntLiteralNode(5),
                factory.makeBinaryExpressionNode(
                        factory.makeIntLiteralNode(5),
                        factory.makeIntLiteralNode(5), 
                        BinaryOperator.GREATER_THAN), 
                BinaryOperator.LEFT_SHIFT);
        assertEquals(
                node.executeOperation(new BsjSourceSerializerImpl(), null),
                "5 << (5 > 5)");        
    }
    
    @Test
    public void testBinaryOperatorGreaterThanAndEqual()
    {
        BsjNodeFactoryImpl factory = new BsjNodeFactoryImpl();
        Node node = factory.makeBinaryExpressionNode(
                factory.makeIntLiteralNode(5),
                factory.makeBinaryExpressionNode(
                        factory.makeIntLiteralNode(5),
                        factory.makeIntLiteralNode(5), 
                        BinaryOperator.EQUAL), 
                BinaryOperator.GREATER_THAN);
        assertEquals(
                node.executeOperation(new BsjSourceSerializerImpl(), null),
                "5 > (5 == 5)");        
    }
    
    @Test
    public void testBinaryOperatorEqualAndLogicalAnd()
    {
        BsjNodeFactoryImpl factory = new BsjNodeFactoryImpl();
        Node node = factory.makeBinaryExpressionNode(
                factory.makeIntLiteralNode(5),
                factory.makeBinaryExpressionNode(
                        factory.makeIntLiteralNode(5),
                        factory.makeIntLiteralNode(5), 
                        BinaryOperator.LOGICAL_AND), 
                BinaryOperator.EQUAL);
        assertEquals(
                node.executeOperation(new BsjSourceSerializerImpl(), null),
                "5 == (5 & 5)");        
    }    
    
    @Test
    public void testBinaryOperatorLogicalAndAndXor()
    {
        BsjNodeFactoryImpl factory = new BsjNodeFactoryImpl();
        Node node = factory.makeBinaryExpressionNode(
                factory.makeIntLiteralNode(5),
                factory.makeBinaryExpressionNode(
                        factory.makeIntLiteralNode(5),
                        factory.makeIntLiteralNode(5), 
                        BinaryOperator.XOR), 
                BinaryOperator.LOGICAL_AND);
        assertEquals(
                node.executeOperation(new BsjSourceSerializerImpl(), null),
                "5 & (5 ^ 5)");        
    }
    
    @Test
    public void testBinaryOperatorXorAndLogicalOr()
    {
        BsjNodeFactoryImpl factory = new BsjNodeFactoryImpl();
        Node node = factory.makeBinaryExpressionNode(
                factory.makeIntLiteralNode(5),
                factory.makeBinaryExpressionNode(
                        factory.makeIntLiteralNode(5),
                        factory.makeIntLiteralNode(5), 
                        BinaryOperator.LOGICAL_OR), 
                BinaryOperator.XOR);
        assertEquals(
                node.executeOperation(new BsjSourceSerializerImpl(), null),
                "5 ^ (5 | 5)");        
    }
    
    @Test
    public void testBinaryOperatorLogicalOrAndConditionalAnd()
    {
        BsjNodeFactoryImpl factory = new BsjNodeFactoryImpl();
        Node node = factory.makeBinaryExpressionNode(
                factory.makeIntLiteralNode(5),
                factory.makeBinaryExpressionNode(
                        factory.makeIntLiteralNode(5),
                        factory.makeIntLiteralNode(5), 
                        BinaryOperator.CONDITIONAL_AND), 
                BinaryOperator.LOGICAL_OR);
        assertEquals(
                node.executeOperation(new BsjSourceSerializerImpl(), null),
                "5 | (5 && 5)");        
    }
    
    @Test
    public void testBinaryOperatorConditionalAndAndConditionalOr()
    {
        BsjNodeFactoryImpl factory = new BsjNodeFactoryImpl();
        Node node = factory.makeBinaryExpressionNode(
                factory.makeIntLiteralNode(5),
                factory.makeBinaryExpressionNode(
                        factory.makeIntLiteralNode(5),
                        factory.makeIntLiteralNode(5), 
                        BinaryOperator.CONDITIONAL_OR), 
                BinaryOperator.CONDITIONAL_AND);
        assertEquals(
                node.executeOperation(new BsjSourceSerializerImpl(), null),
                "5 && (5 || 5)");        
    }
    
    @Test
    public void testBinaryOperatorAndConditionalExpression()
    {
        BsjNodeFactoryImpl factory = new BsjNodeFactoryImpl();
        Node node = factory.makeBinaryExpressionNode(
                factory.makeIntLiteralNode(5),
                factory.makeConditionalExpressionNode(
                        factory.makeIntLiteralNode(5),
                        factory.makeIntLiteralNode(5), 
                        factory.makeIntLiteralNode(5)), 
                BinaryOperator.CONDITIONAL_AND);
        assertEquals(
                node.executeOperation(new BsjSourceSerializerImpl(), null),
                "5 && (5 ? 5 : 5)");        
    }
    
    @Test
    public void testBinaryOperatorAndAssignment()
    {
        BsjNodeFactoryImpl factory = new BsjNodeFactoryImpl();
        Node node = factory.makeBinaryExpressionNode(
                factory.makeIntLiteralNode(5),
                factory.makeAssignmentNode(
                        factory.makeIntLiteralNode(5),
                        AssignmentOperator.MODULUS_ASSIGNMENT, 
                        factory.makeIntLiteralNode(5)), 
                BinaryOperator.CONDITIONAL_AND);
        assertEquals(
                node.executeOperation(new BsjSourceSerializerImpl(), null),
                "5 && (5 %= 5)");        
    }
    
    @Test
    public void testConditionalExpressionAndAssignment()
    {
        BsjNodeFactoryImpl factory = new BsjNodeFactoryImpl();
        Node node = factory.makeConditionalExpressionNode(
                factory.makeAssignmentNode(
                        factory.makeIntLiteralNode(5),
                        AssignmentOperator.MODULUS_ASSIGNMENT, 
                        factory.makeIntLiteralNode(5)),
                        factory.makeAssignmentNode(
                                factory.makeIntLiteralNode(5),
                                AssignmentOperator.AND_ASSIGNMENT, 
                                factory.makeIntLiteralNode(5)), 
                                factory.makeAssignmentNode(
                                        factory.makeIntLiteralNode(5),
                                        AssignmentOperator.DIVIDE_ASSIGNMENT, 
                                        factory.makeIntLiteralNode(5))); 
        assertEquals(
                node.executeOperation(new BsjSourceSerializerImpl(), null),
                "(5 %= 5) ? (5 &= 5) : (5 /= 5)");        
    }
}
