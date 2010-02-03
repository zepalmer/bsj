package edu.jhu.cs.bsj.compiler.impl.tool.compiler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.AccessModifier;
import edu.jhu.cs.bsj.compiler.ast.AssignmentOperator;
import edu.jhu.cs.bsj.compiler.ast.BinaryOperator;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeOperation;
import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.NameCategory;
import edu.jhu.cs.bsj.compiler.ast.PrimitiveType;
import edu.jhu.cs.bsj.compiler.ast.UnaryOperator;
import edu.jhu.cs.bsj.compiler.ast.UnaryStatementOperator;
import edu.jhu.cs.bsj.compiler.ast.node.*;
import edu.jhu.cs.bsj.compiler.ast.node.meta.BlockStatementMetaprogramAnchorNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.CodeLiteralNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.TypeDeclarationMetaprogramAnchorNode;

/**
 * This class is designed to "lift" a BSJ AST, transitioning it into a higher, more abstract stage of programming. The
 * parameters for all methods are the AST to process and a pairing. The pairing contains an expression describing how
 * the node factory is to be accessed and a list of block statements. The list of block statements is typically empty to
 * start; the lifter adds statements which would cause the input AST to be produced in the metaprogram. The return value
 * of every method is the name of the variable that the lifter used to describe the resulting AST.
 * <p/>
 * For example, consider the case in which one wishes to obtain an AST which indicates how one would construct an AST
 * indicating the integer literal 5. The input AST can be created very simply:
 * 
 * <pre>
 * IntLiteralNode input = factory.makeIntLiteralNode(5);
 * </pre>
 * 
 * Now suppose one wanted to generate an AST which would represent the above code; that is, produce an AST representing
 * the code that makes an AST. In that case, this lifter is very convenient. The following code would be sufficient:
 * 
 * <pre>
 * List&lt;BlockStatementNode&gt; list = new ArrayList&lt;BlockStatementNode&gt;();
 * IntLiteralNode input = factory.makeIntLiteralNode(5);
 * BsjTreeLifter lifter = new BsjTreeLifter();
 * String varName = input.executeOperation(lifter, new Pair&lt;ExpressionNode, List&lt;BlockStatementNode&gt;&gt;(factoryExpression,
 * 		list));
 * </pre>
 * 
 * At the end of that call, <code>varName</code> would contain the name of a local variable which would have the
 * resulting AST node in the list of statements if that list were compiled and transformed into a method.
 * <p/>
 * Motivating use cases for this operation include code literals and initial metacompilation (where the original source
 * file is treated as something similar to a giant code literal).
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class BsjTreeLifter implements BsjNodeOperation<ExpressionNode,ExpressionNode>
{
	protected ExpressionNode expressionizeString(String s)
	{
		if (s == null)
		{
			return factory.makeNullLiteralNode(null);
		} else
		{
			return factory.makeStringLiteralNode(s);
		}
	}

	protected ExpressionNode expressionizeCharacter(Character c)
	{
		return expressionizeChar(c);
	}

	protected ExpressionNode expressionizeInteger(Integer i)
	{
		return expressionizeInt(i);
	}

	protected ExpressionNode expressionizeBsjSourceLocation(BsjSourceLocation location)
	{
		if (location == null)
		{
			return factory.makeNullLiteralNode(null);
		} else
		{
			return factory.makeUnqualifiedClassInstantiationNode(
					factory.makeUnparameterizedTypeNode(factory.makeSimpleNameNode(
							factory.makeIdentifierNode("BsjSourceLocation"), NameCategory.TYPE)),
					factory.makeListNode(Collections.<TypeArgumentNode> emptyList()),
					factory.makeListNode(Arrays.<ExpressionNode> asList(
							factory.makeStringLiteralNode(location.getResourceName()),
							factory.makeIntLiteralNode(location.getLine()),
							factory.makeIntLiteralNode(location.getColumn()))), null);
		}
	}

	/**
	 * The stack of type parameterizations for the ListNode handler. If this stack is empty, the invoker of
	 * executeListNode is calling it directly (that is, it is not being called from this lifter directly).
	 */
	private Stack<String> argsForListNodeStack = new Stack<String>();
    private BsjNodeFactory factory;
    
    public BsjTreeLifter(BsjNodeFactory factory)
    {
        this.factory = factory;
    }
    
    protected ExpressionNode expressionizeChar(char x)
    {
        return factory.makeCharLiteralNode(x);
    }
    
    protected ExpressionNode expressionizeInt(int x)
    {
        return factory.makeIntLiteralNode(x);
    }
    
    protected ExpressionNode expressionizeBoolean(boolean x)
    {
        return factory.makeBooleanLiteralNode(x);
    }
    
    protected ExpressionNode expressionizeDouble(double x)
    {
        return factory.makeDoubleLiteralNode(x);
    }
    
    protected ExpressionNode expressionizeLong(long x)
    {
        return factory.makeLongLiteralNode(x);
    }
    
    protected ExpressionNode expressionizeFloat(float x)
    {
        return factory.makeFloatLiteralNode(x);
    }
    
    protected ExpressionNode expressionizePrimitiveType(PrimitiveType x)
    {
        return factory.makeFieldAccessByNameNode(factory.makeQualifiedNameNode(
                factory.makeSimpleNameNode(
                        factory.makeIdentifierNode("PrimitiveType"),
                        NameCategory.EXPRESSION
                        ),
                factory.makeIdentifierNode(x.name()),
                NameCategory.EXPRESSION));
    }
    
    protected ExpressionNode expressionizeUnaryStatementOperator(UnaryStatementOperator x)
    {
        return factory.makeFieldAccessByNameNode(factory.makeQualifiedNameNode(
                factory.makeSimpleNameNode(
                        factory.makeIdentifierNode("UnaryStatementOperator"),
                        NameCategory.EXPRESSION
                        ),
                factory.makeIdentifierNode(x.name()),
                NameCategory.EXPRESSION));
    }
    
    protected ExpressionNode expressionizeAssignmentOperator(AssignmentOperator x)
    {
        return factory.makeFieldAccessByNameNode(factory.makeQualifiedNameNode(
                factory.makeSimpleNameNode(
                        factory.makeIdentifierNode("AssignmentOperator"),
                        NameCategory.EXPRESSION
                        ),
                factory.makeIdentifierNode(x.name()),
                NameCategory.EXPRESSION));
    }
    
    protected ExpressionNode expressionizeBinaryOperator(BinaryOperator x)
    {
        return factory.makeFieldAccessByNameNode(factory.makeQualifiedNameNode(
                factory.makeSimpleNameNode(
                        factory.makeIdentifierNode("BinaryOperator"),
                        NameCategory.EXPRESSION
                        ),
                factory.makeIdentifierNode(x.name()),
                NameCategory.EXPRESSION));
    }
    
    protected ExpressionNode expressionizeNameCategory(NameCategory x)
    {
        return factory.makeFieldAccessByNameNode(factory.makeQualifiedNameNode(
                factory.makeSimpleNameNode(
                        factory.makeIdentifierNode("NameCategory"),
                        NameCategory.EXPRESSION
                        ),
                factory.makeIdentifierNode(x.name()),
                NameCategory.EXPRESSION));
    }
    
    protected ExpressionNode expressionizeUnaryOperator(UnaryOperator x)
    {
        return factory.makeFieldAccessByNameNode(factory.makeQualifiedNameNode(
                factory.makeSimpleNameNode(
                        factory.makeIdentifierNode("UnaryOperator"),
                        NameCategory.EXPRESSION
                        ),
                factory.makeIdentifierNode(x.name()),
                NameCategory.EXPRESSION));
    }
    
    protected ExpressionNode expressionizeAccessModifier(AccessModifier x)
    {
        return factory.makeFieldAccessByNameNode(factory.makeQualifiedNameNode(
                factory.makeSimpleNameNode(
                        factory.makeIdentifierNode("AccessModifier"),
                        NameCategory.EXPRESSION
                        ),
                factory.makeIdentifierNode(x.name()),
                NameCategory.EXPRESSION));
    }
    
    @Override
    public ExpressionNode executeAssertStatementNode(AssertStatementNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftTestExpression = 
                node.getTestExpression() != null ?
                        node.getTestExpression().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode(null);
        ExpressionNode liftMessageExpression = 
                node.getMessageExpression() != null ?
                        node.getMessageExpression().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode(null);
        ExpressionNode liftStartLocationMetaClone = 
                expressionizeBsjSourceLocation(node.getStartLocation());
        ExpressionNode liftStopLocationMetaClone = 
                expressionizeBsjSourceLocation(node.getStopLocation());
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeAssertStatementNode"),
                        factory.makeListNode(
                                Arrays.<ExpressionNode>asList(
                                        liftTestExpression,
                                        liftMessageExpression,
                                        liftStartLocationMetaClone,
                                        liftStopLocationMetaClone)),
                        factory.makeListNode(Collections.<TypeNode>emptyList()));
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeUnaryStatementExpressionNode(UnaryStatementExpressionNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftExpression = 
                node.getExpression() != null ?
                        node.getExpression().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode(null);
        UnaryStatementOperator liftOperatorValue = 
                node.getOperator();
        ExpressionNode liftStartLocationMetaClone = 
                expressionizeBsjSourceLocation(node.getStartLocation());
        ExpressionNode liftStopLocationMetaClone = 
                expressionizeBsjSourceLocation(node.getStopLocation());
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeUnaryStatementExpressionNode"),
                        factory.makeListNode(
                                Arrays.<ExpressionNode>asList(
                                        liftExpression,
                                        expressionizeUnaryStatementOperator(liftOperatorValue),
                                        liftStartLocationMetaClone,
                                        liftStopLocationMetaClone)),
                        factory.makeListNode(Collections.<TypeNode>emptyList()));
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeInterfaceBodyNode(InterfaceBodyNode node, ExpressionNode factoryNode)
    {
        argsForListNodeStack.push("InterfaceMemberNode");
        ExpressionNode liftMembers = 
                node.getMembers() != null ?
                        node.getMembers().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode(null);
        argsForListNodeStack.pop();
        ExpressionNode liftStartLocationMetaClone = 
                expressionizeBsjSourceLocation(node.getStartLocation());
        ExpressionNode liftStopLocationMetaClone = 
                expressionizeBsjSourceLocation(node.getStopLocation());
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeInterfaceBodyNode"),
                        factory.makeListNode(
                                Arrays.<ExpressionNode>asList(
                                        liftMembers,
                                        liftStartLocationMetaClone,
                                        liftStopLocationMetaClone)),
                        factory.makeListNode(Collections.<TypeNode>emptyList()));
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeExpressionStatementNode(ExpressionStatementNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftExpression = 
                node.getExpression() != null ?
                        node.getExpression().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode(null);
        ExpressionNode liftStartLocationMetaClone = 
                expressionizeBsjSourceLocation(node.getStartLocation());
        ExpressionNode liftStopLocationMetaClone = 
                expressionizeBsjSourceLocation(node.getStopLocation());
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeExpressionStatementNode"),
                        factory.makeListNode(
                                Arrays.<ExpressionNode>asList(
                                        liftExpression,
                                        liftStartLocationMetaClone,
                                        liftStopLocationMetaClone)),
                        factory.makeListNode(Collections.<TypeNode>emptyList()));
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeClassDeclarationNode(ClassDeclarationNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftModifiers = 
                node.getModifiers() != null ?
                        node.getModifiers().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode(null);
        ExpressionNode liftExtendsClause = 
                node.getExtendsClause() != null ?
                        node.getExtendsClause().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode(null);
        argsForListNodeStack.push("TypeNode");
        ExpressionNode liftImplementsClause = 
                node.getImplementsClause() != null ?
                        node.getImplementsClause().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode(null);
        argsForListNodeStack.pop();
        ExpressionNode liftBody = 
                node.getBody() != null ?
                        node.getBody().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode(null);
        argsForListNodeStack.push("TypeParameterNode");
        ExpressionNode liftTypeParameters = 
                node.getTypeParameters() != null ?
                        node.getTypeParameters().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode(null);
        argsForListNodeStack.pop();
        ExpressionNode liftIdentifier = 
                node.getIdentifier() != null ?
                        node.getIdentifier().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode(null);
        ExpressionNode liftJavadoc = 
                node.getJavadoc() != null ?
                        node.getJavadoc().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode(null);
        ExpressionNode liftStartLocationMetaClone = 
                expressionizeBsjSourceLocation(node.getStartLocation());
        ExpressionNode liftStopLocationMetaClone = 
                expressionizeBsjSourceLocation(node.getStopLocation());
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeClassDeclarationNode"),
                        factory.makeListNode(
                                Arrays.<ExpressionNode>asList(
                                        liftModifiers,
                                        liftExtendsClause,
                                        liftImplementsClause,
                                        liftBody,
                                        liftTypeParameters,
                                        liftIdentifier,
                                        liftJavadoc,
                                        liftStartLocationMetaClone,
                                        liftStopLocationMetaClone)),
                        factory.makeListNode(Collections.<TypeNode>emptyList()));
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeEnhancedForLoopNode(EnhancedForLoopNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftVariable = 
                node.getVariable() != null ?
                        node.getVariable().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode(null);
        ExpressionNode liftExpression = 
                node.getExpression() != null ?
                        node.getExpression().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode(null);
        ExpressionNode liftStatement = 
                node.getStatement() != null ?
                        node.getStatement().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode(null);
        ExpressionNode liftStartLocationMetaClone = 
                expressionizeBsjSourceLocation(node.getStartLocation());
        ExpressionNode liftStopLocationMetaClone = 
                expressionizeBsjSourceLocation(node.getStopLocation());
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeEnhancedForLoopNode"),
                        factory.makeListNode(
                                Arrays.<ExpressionNode>asList(
                                        liftVariable,
                                        liftExpression,
                                        liftStatement,
                                        liftStartLocationMetaClone,
                                        liftStopLocationMetaClone)),
                        factory.makeListNode(Collections.<TypeNode>emptyList()));
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeArrayAccessNode(ArrayAccessNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftArrayExpression = 
                node.getArrayExpression() != null ?
                        node.getArrayExpression().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode(null);
        ExpressionNode liftIndexExpression = 
                node.getIndexExpression() != null ?
                        node.getIndexExpression().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode(null);
        ExpressionNode liftStartLocationMetaClone = 
                expressionizeBsjSourceLocation(node.getStartLocation());
        ExpressionNode liftStopLocationMetaClone = 
                expressionizeBsjSourceLocation(node.getStopLocation());
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeArrayAccessNode"),
                        factory.makeListNode(
                                Arrays.<ExpressionNode>asList(
                                        liftArrayExpression,
                                        liftIndexExpression,
                                        liftStartLocationMetaClone,
                                        liftStopLocationMetaClone)),
                        factory.makeListNode(Collections.<TypeNode>emptyList()));
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeLongLiteralNode(LongLiteralNode node, ExpressionNode factoryNode)
    {
        Long liftValueValue = 
                node.getValue();
        ExpressionNode liftStartLocationMetaClone = 
                expressionizeBsjSourceLocation(node.getStartLocation());
        ExpressionNode liftStopLocationMetaClone = 
                expressionizeBsjSourceLocation(node.getStopLocation());
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeLongLiteralNode"),
                        factory.makeListNode(
                                Arrays.<ExpressionNode>asList(
                                        expressionizeLong(liftValueValue),
                                        liftStartLocationMetaClone,
                                        liftStopLocationMetaClone)),
                        factory.makeListNode(Collections.<TypeNode>emptyList()));
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeQualifiedNameNode(QualifiedNameNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftBase = 
                node.getBase() != null ?
                        node.getBase().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode(null);
        ExpressionNode liftIdentifier = 
                node.getIdentifier() != null ?
                        node.getIdentifier().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode(null);
        NameCategory liftCategoryValue = 
                node.getCategory();
        ExpressionNode liftStartLocationMetaClone = 
                expressionizeBsjSourceLocation(node.getStartLocation());
        ExpressionNode liftStopLocationMetaClone = 
                expressionizeBsjSourceLocation(node.getStopLocation());
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeQualifiedNameNode"),
                        factory.makeListNode(
                                Arrays.<ExpressionNode>asList(
                                        liftBase,
                                        liftIdentifier,
                                        expressionizeNameCategory(liftCategoryValue),
                                        liftStartLocationMetaClone,
                                        liftStopLocationMetaClone)),
                        factory.makeListNode(Collections.<TypeNode>emptyList()));
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeCaseNode(CaseNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftExpression = 
                node.getExpression() != null ?
                        node.getExpression().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode(null);
        argsForListNodeStack.push("BlockStatementNode");
        ExpressionNode liftStatements = 
                node.getStatements() != null ?
                        node.getStatements().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode(null);
        argsForListNodeStack.pop();
        ExpressionNode liftStartLocationMetaClone = 
                expressionizeBsjSourceLocation(node.getStartLocation());
        ExpressionNode liftStopLocationMetaClone = 
                expressionizeBsjSourceLocation(node.getStopLocation());
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeCaseNode"),
                        factory.makeListNode(
                                Arrays.<ExpressionNode>asList(
                                        liftExpression,
                                        liftStatements,
                                        liftStartLocationMetaClone,
                                        liftStopLocationMetaClone)),
                        factory.makeListNode(Collections.<TypeNode>emptyList()));
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeVoidStatementNode(VoidStatementNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftStartLocationMetaClone = 
                expressionizeBsjSourceLocation(node.getStartLocation());
        ExpressionNode liftStopLocationMetaClone = 
                expressionizeBsjSourceLocation(node.getStopLocation());
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeVoidStatementNode"),
                        factory.makeListNode(
                                Arrays.<ExpressionNode>asList(
                                        liftStartLocationMetaClone,
                                        liftStopLocationMetaClone)),
                        factory.makeListNode(Collections.<TypeNode>emptyList()));
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeCodeLiteralNode(CodeLiteralNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftValue = 
                node.getValue() != null ?
                        node.getValue().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode(null);
        ExpressionNode liftStartLocationMetaClone = 
                expressionizeBsjSourceLocation(node.getStartLocation());
        ExpressionNode liftStopLocationMetaClone = 
                expressionizeBsjSourceLocation(node.getStopLocation());
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeCodeLiteralNode"),
                        factory.makeListNode(
                                Arrays.<ExpressionNode>asList(
                                        liftValue,
                                        liftStartLocationMetaClone,
                                        liftStopLocationMetaClone)),
                        factory.makeListNode(Collections.<TypeNode>emptyList()));
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeImportOnDemandNode(ImportOnDemandNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftName = 
                node.getName() != null ?
                        node.getName().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode(null);
        boolean liftStaticImportValue = 
                node.getStaticImport();
        ExpressionNode liftStartLocationMetaClone = 
                expressionizeBsjSourceLocation(node.getStartLocation());
        ExpressionNode liftStopLocationMetaClone = 
                expressionizeBsjSourceLocation(node.getStopLocation());
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeImportOnDemandNode"),
                        factory.makeListNode(
                                Arrays.<ExpressionNode>asList(
                                        liftName,
                                        expressionizeBoolean(liftStaticImportValue),
                                        liftStartLocationMetaClone,
                                        liftStopLocationMetaClone)),
                        factory.makeListNode(Collections.<TypeNode>emptyList()));
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeVariableModifiersNode(VariableModifiersNode node, ExpressionNode factoryNode)
    {
        boolean liftFinalFlagValue = 
                node.getFinalFlag();
        argsForListNodeStack.push("AnnotationNode");
        ExpressionNode liftAnnotations = 
                node.getAnnotations() != null ?
                        node.getAnnotations().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode(null);
        argsForListNodeStack.pop();
        ExpressionNode liftStartLocationMetaClone = 
                expressionizeBsjSourceLocation(node.getStartLocation());
        ExpressionNode liftStopLocationMetaClone = 
                expressionizeBsjSourceLocation(node.getStopLocation());
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeVariableModifiersNode"),
                        factory.makeListNode(
                                Arrays.<ExpressionNode>asList(
                                        expressionizeBoolean(liftFinalFlagValue),
                                        liftAnnotations,
                                        liftStartLocationMetaClone,
                                        liftStopLocationMetaClone)),
                        factory.makeListNode(Collections.<TypeNode>emptyList()));
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeBlockStatementMetaprogramAnchorNode(BlockStatementMetaprogramAnchorNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftMetaprogram = 
                node.getMetaprogram() != null ?
                        node.getMetaprogram().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode(null);
        ExpressionNode liftStartLocationMetaClone = 
                expressionizeBsjSourceLocation(node.getStartLocation());
        ExpressionNode liftStopLocationMetaClone = 
                expressionizeBsjSourceLocation(node.getStopLocation());
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeBlockStatementMetaprogramAnchorNode"),
                        factory.makeListNode(
                                Arrays.<ExpressionNode>asList(
                                        liftMetaprogram,
                                        liftStartLocationMetaClone,
                                        liftStopLocationMetaClone)),
                        factory.makeListNode(Collections.<TypeNode>emptyList()));
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeInterfaceModifiersNode(InterfaceModifiersNode node, ExpressionNode factoryNode)
    {
        AccessModifier liftAccessValue = 
                node.getAccess();
        boolean liftStaticFlagValue = 
                node.getStaticFlag();
        boolean liftStrictfpFlagValue = 
                node.getStrictfpFlag();
        argsForListNodeStack.push("AnnotationNode");
        ExpressionNode liftAnnotations = 
                node.getAnnotations() != null ?
                        node.getAnnotations().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode(null);
        argsForListNodeStack.pop();
        ExpressionNode liftStartLocationMetaClone = 
                expressionizeBsjSourceLocation(node.getStartLocation());
        ExpressionNode liftStopLocationMetaClone = 
                expressionizeBsjSourceLocation(node.getStopLocation());
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeInterfaceModifiersNode"),
                        factory.makeListNode(
                                Arrays.<ExpressionNode>asList(
                                        expressionizeAccessModifier(liftAccessValue),
                                        expressionizeBoolean(liftStaticFlagValue),
                                        expressionizeBoolean(liftStrictfpFlagValue),
                                        liftAnnotations,
                                        liftStartLocationMetaClone,
                                        liftStopLocationMetaClone)),
                        factory.makeListNode(Collections.<TypeNode>emptyList()));
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeSuperclassConstructorInvocationNode(SuperclassConstructorInvocationNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftQualifyingExpression = 
                node.getQualifyingExpression() != null ?
                        node.getQualifyingExpression().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode(null);
        argsForListNodeStack.push("ExpressionNode");
        ExpressionNode liftArguments = 
                node.getArguments() != null ?
                        node.getArguments().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode(null);
        argsForListNodeStack.pop();
        argsForListNodeStack.push("TypeNode");
        ExpressionNode liftTypeArguments = 
                node.getTypeArguments() != null ?
                        node.getTypeArguments().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode(null);
        argsForListNodeStack.pop();
        ExpressionNode liftStartLocationMetaClone = 
                expressionizeBsjSourceLocation(node.getStartLocation());
        ExpressionNode liftStopLocationMetaClone = 
                expressionizeBsjSourceLocation(node.getStopLocation());
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeSuperclassConstructorInvocationNode"),
                        factory.makeListNode(
                                Arrays.<ExpressionNode>asList(
                                        liftQualifyingExpression,
                                        liftArguments,
                                        liftTypeArguments,
                                        liftStartLocationMetaClone,
                                        liftStopLocationMetaClone)),
                        factory.makeListNode(Collections.<TypeNode>emptyList()));
        
        return ret;
    }
    
    @Override
    public ExpressionNode executePrimitiveTypeNode(PrimitiveTypeNode node, ExpressionNode factoryNode)
    {
        PrimitiveType liftPrimitiveTypeValue = 
                node.getPrimitiveType();
        ExpressionNode liftStartLocationMetaClone = 
                expressionizeBsjSourceLocation(node.getStartLocation());
        ExpressionNode liftStopLocationMetaClone = 
                expressionizeBsjSourceLocation(node.getStopLocation());
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makePrimitiveTypeNode"),
                        factory.makeListNode(
                                Arrays.<ExpressionNode>asList(
                                        expressionizePrimitiveType(liftPrimitiveTypeValue),
                                        liftStartLocationMetaClone,
                                        liftStopLocationMetaClone)),
                        factory.makeListNode(Collections.<TypeNode>emptyList()));
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeMetaprogramNode(MetaprogramNode node, ExpressionNode factoryNode)
    {
        argsForListNodeStack.push("BlockStatementNode");
        ExpressionNode liftBody = 
                node.getBody() != null ?
                        node.getBody().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode(null);
        argsForListNodeStack.pop();
        ExpressionNode liftStartLocationMetaClone = 
                expressionizeBsjSourceLocation(node.getStartLocation());
        ExpressionNode liftStopLocationMetaClone = 
                expressionizeBsjSourceLocation(node.getStopLocation());
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeMetaprogramNode"),
                        factory.makeListNode(
                                Arrays.<ExpressionNode>asList(
                                        liftBody,
                                        liftStartLocationMetaClone,
                                        liftStopLocationMetaClone)),
                        factory.makeListNode(Collections.<TypeNode>emptyList()));
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeInitializerDeclarationNode(InitializerDeclarationNode node, ExpressionNode factoryNode)
    {
        boolean liftStaticInitializerValue = 
                node.getStaticInitializer();
        ExpressionNode liftBody = 
                node.getBody() != null ?
                        node.getBody().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode(null);
        ExpressionNode liftStartLocationMetaClone = 
                expressionizeBsjSourceLocation(node.getStartLocation());
        ExpressionNode liftStopLocationMetaClone = 
                expressionizeBsjSourceLocation(node.getStopLocation());
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeInitializerDeclarationNode"),
                        factory.makeListNode(
                                Arrays.<ExpressionNode>asList(
                                        expressionizeBoolean(liftStaticInitializerValue),
                                        liftBody,
                                        liftStartLocationMetaClone,
                                        liftStopLocationMetaClone)),
                        factory.makeListNode(Collections.<TypeNode>emptyList()));
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeEnumBodyNode(EnumBodyNode node, ExpressionNode factoryNode)
    {
        argsForListNodeStack.push("EnumConstantDeclarationNode");
        ExpressionNode liftConstants = 
                node.getConstants() != null ?
                        node.getConstants().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode(null);
        argsForListNodeStack.pop();
        argsForListNodeStack.push("ClassMemberNode");
        ExpressionNode liftMembers = 
                node.getMembers() != null ?
                        node.getMembers().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode(null);
        argsForListNodeStack.pop();
        ExpressionNode liftStartLocationMetaClone = 
                expressionizeBsjSourceLocation(node.getStartLocation());
        ExpressionNode liftStopLocationMetaClone = 
                expressionizeBsjSourceLocation(node.getStopLocation());
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeEnumBodyNode"),
                        factory.makeListNode(
                                Arrays.<ExpressionNode>asList(
                                        liftConstants,
                                        liftMembers,
                                        liftStartLocationMetaClone,
                                        liftStopLocationMetaClone)),
                        factory.makeListNode(Collections.<TypeNode>emptyList()));
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeTryNode(TryNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftBlock = 
                node.getBlock() != null ?
                        node.getBlock().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode(null);
        argsForListNodeStack.push("CatchNode");
        ExpressionNode liftCatches = 
                node.getCatches() != null ?
                        node.getCatches().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode(null);
        argsForListNodeStack.pop();
        ExpressionNode liftFinallyBlock = 
                node.getFinallyBlock() != null ?
                        node.getFinallyBlock().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode(null);
        ExpressionNode liftStartLocationMetaClone = 
                expressionizeBsjSourceLocation(node.getStartLocation());
        ExpressionNode liftStopLocationMetaClone = 
                expressionizeBsjSourceLocation(node.getStopLocation());
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeTryNode"),
                        factory.makeListNode(
                                Arrays.<ExpressionNode>asList(
                                        liftBlock,
                                        liftCatches,
                                        liftFinallyBlock,
                                        liftStartLocationMetaClone,
                                        liftStopLocationMetaClone)),
                        factory.makeListNode(Collections.<TypeNode>emptyList()));
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeThisNode(ThisNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftType = 
                node.getType() != null ?
                        node.getType().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode(null);
        ExpressionNode liftStartLocationMetaClone = 
                expressionizeBsjSourceLocation(node.getStartLocation());
        ExpressionNode liftStopLocationMetaClone = 
                expressionizeBsjSourceLocation(node.getStopLocation());
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeThisNode"),
                        factory.makeListNode(
                                Arrays.<ExpressionNode>asList(
                                        liftType,
                                        liftStartLocationMetaClone,
                                        liftStopLocationMetaClone)),
                        factory.makeListNode(Collections.<TypeNode>emptyList()));
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeTypeDeclarationMetaprogramAnchorNode(TypeDeclarationMetaprogramAnchorNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftMetaprogram = 
                node.getMetaprogram() != null ?
                        node.getMetaprogram().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode(null);
        ExpressionNode liftStartLocationMetaClone = 
                expressionizeBsjSourceLocation(node.getStartLocation());
        ExpressionNode liftStopLocationMetaClone = 
                expressionizeBsjSourceLocation(node.getStopLocation());
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeTypeDeclarationMetaprogramAnchorNode"),
                        factory.makeListNode(
                                Arrays.<ExpressionNode>asList(
                                        liftMetaprogram,
                                        liftStartLocationMetaClone,
                                        liftStopLocationMetaClone)),
                        factory.makeListNode(Collections.<TypeNode>emptyList()));
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeEnumDeclarationNode(EnumDeclarationNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftModifiers = 
                node.getModifiers() != null ?
                        node.getModifiers().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode(null);
        argsForListNodeStack.push("TypeNode");
        ExpressionNode liftImplementsClause = 
                node.getImplementsClause() != null ?
                        node.getImplementsClause().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode(null);
        argsForListNodeStack.pop();
        ExpressionNode liftBody = 
                node.getBody() != null ?
                        node.getBody().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode(null);
        ExpressionNode liftIdentifier = 
                node.getIdentifier() != null ?
                        node.getIdentifier().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode(null);
        ExpressionNode liftJavadoc = 
                node.getJavadoc() != null ?
                        node.getJavadoc().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode(null);
        ExpressionNode liftStartLocationMetaClone = 
                expressionizeBsjSourceLocation(node.getStartLocation());
        ExpressionNode liftStopLocationMetaClone = 
                expressionizeBsjSourceLocation(node.getStopLocation());
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeEnumDeclarationNode"),
                        factory.makeListNode(
                                Arrays.<ExpressionNode>asList(
                                        liftModifiers,
                                        liftImplementsClause,
                                        liftBody,
                                        liftIdentifier,
                                        liftJavadoc,
                                        liftStartLocationMetaClone,
                                        liftStopLocationMetaClone)),
                        factory.makeListNode(Collections.<TypeNode>emptyList()));
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeVoidTypeNode(VoidTypeNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftStartLocationMetaClone = 
                expressionizeBsjSourceLocation(node.getStartLocation());
        ExpressionNode liftStopLocationMetaClone = 
                expressionizeBsjSourceLocation(node.getStopLocation());
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeVoidTypeNode"),
                        factory.makeListNode(
                                Arrays.<ExpressionNode>asList(
                                        liftStartLocationMetaClone,
                                        liftStopLocationMetaClone)),
                        factory.makeListNode(Collections.<TypeNode>emptyList()));
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeVariableDeclarationNode(VariableDeclarationNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftModifiers = 
                node.getModifiers() != null ?
                        node.getModifiers().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode(null);
        argsForListNodeStack.push("VariableDeclaratorNode");
        ExpressionNode liftDeclarators = 
                node.getDeclarators() != null ?
                        node.getDeclarators().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode(null);
        argsForListNodeStack.pop();
        ExpressionNode liftStartLocationMetaClone = 
                expressionizeBsjSourceLocation(node.getStartLocation());
        ExpressionNode liftStopLocationMetaClone = 
                expressionizeBsjSourceLocation(node.getStopLocation());
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeVariableDeclarationNode"),
                        factory.makeListNode(
                                Arrays.<ExpressionNode>asList(
                                        liftModifiers,
                                        liftDeclarators,
                                        liftStartLocationMetaClone,
                                        liftStopLocationMetaClone)),
                        factory.makeListNode(Collections.<TypeNode>emptyList()));
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeAnnotationBodyNode(AnnotationBodyNode node, ExpressionNode factoryNode)
    {
        argsForListNodeStack.push("AnnotationMemberNode");
        ExpressionNode liftMembers = 
                node.getMembers() != null ?
                        node.getMembers().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode(null);
        argsForListNodeStack.pop();
        ExpressionNode liftStartLocationMetaClone = 
                expressionizeBsjSourceLocation(node.getStartLocation());
        ExpressionNode liftStopLocationMetaClone = 
                expressionizeBsjSourceLocation(node.getStopLocation());
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeAnnotationBodyNode"),
                        factory.makeListNode(
                                Arrays.<ExpressionNode>asList(
                                        liftMembers,
                                        liftStartLocationMetaClone,
                                        liftStopLocationMetaClone)),
                        factory.makeListNode(Collections.<TypeNode>emptyList()));
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeUnparameterizedTypeNode(UnparameterizedTypeNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftName = 
                node.getName() != null ?
                        node.getName().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode(null);
        ExpressionNode liftStartLocationMetaClone = 
                expressionizeBsjSourceLocation(node.getStartLocation());
        ExpressionNode liftStopLocationMetaClone = 
                expressionizeBsjSourceLocation(node.getStopLocation());
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeUnparameterizedTypeNode"),
                        factory.makeListNode(
                                Arrays.<ExpressionNode>asList(
                                        liftName,
                                        liftStartLocationMetaClone,
                                        liftStopLocationMetaClone)),
                        factory.makeListNode(Collections.<TypeNode>emptyList()));
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeVariableDeclaratorNode(VariableDeclaratorNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftType = 
                node.getType() != null ?
                        node.getType().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode(null);
        ExpressionNode liftName = 
                node.getName() != null ?
                        node.getName().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode(null);
        ExpressionNode liftInitializer = 
                node.getInitializer() != null ?
                        node.getInitializer().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode(null);
        ExpressionNode liftStartLocationMetaClone = 
                expressionizeBsjSourceLocation(node.getStartLocation());
        ExpressionNode liftStopLocationMetaClone = 
                expressionizeBsjSourceLocation(node.getStopLocation());
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeVariableDeclaratorNode"),
                        factory.makeListNode(
                                Arrays.<ExpressionNode>asList(
                                        liftType,
                                        liftName,
                                        liftInitializer,
                                        liftStartLocationMetaClone,
                                        liftStopLocationMetaClone)),
                        factory.makeListNode(Collections.<TypeNode>emptyList()));
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeAnnotationModifiersNode(AnnotationModifiersNode node, ExpressionNode factoryNode)
    {
        AccessModifier liftAccessValue = 
                node.getAccess();
        boolean liftStaticFlagValue = 
                node.getStaticFlag();
        boolean liftStrictfpFlagValue = 
                node.getStrictfpFlag();
        argsForListNodeStack.push("AnnotationNode");
        ExpressionNode liftAnnotations = 
                node.getAnnotations() != null ?
                        node.getAnnotations().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode(null);
        argsForListNodeStack.pop();
        ExpressionNode liftStartLocationMetaClone = 
                expressionizeBsjSourceLocation(node.getStartLocation());
        ExpressionNode liftStopLocationMetaClone = 
                expressionizeBsjSourceLocation(node.getStopLocation());
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeAnnotationModifiersNode"),
                        factory.makeListNode(
                                Arrays.<ExpressionNode>asList(
                                        expressionizeAccessModifier(liftAccessValue),
                                        expressionizeBoolean(liftStaticFlagValue),
                                        expressionizeBoolean(liftStrictfpFlagValue),
                                        liftAnnotations,
                                        liftStartLocationMetaClone,
                                        liftStopLocationMetaClone)),
                        factory.makeListNode(Collections.<TypeNode>emptyList()));
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeFieldAccessByExpressionNode(FieldAccessByExpressionNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftExpression = 
                node.getExpression() != null ?
                        node.getExpression().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode(null);
        ExpressionNode liftIdentifier = 
                node.getIdentifier() != null ?
                        node.getIdentifier().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode(null);
        ExpressionNode liftStartLocationMetaClone = 
                expressionizeBsjSourceLocation(node.getStartLocation());
        ExpressionNode liftStopLocationMetaClone = 
                expressionizeBsjSourceLocation(node.getStopLocation());
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeFieldAccessByExpressionNode"),
                        factory.makeListNode(
                                Arrays.<ExpressionNode>asList(
                                        liftExpression,
                                        liftIdentifier,
                                        liftStartLocationMetaClone,
                                        liftStopLocationMetaClone)),
                        factory.makeListNode(Collections.<TypeNode>emptyList()));
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeSuperFieldAccessNode(SuperFieldAccessNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftType = 
                node.getType() != null ?
                        node.getType().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode(null);
        ExpressionNode liftIdentifier = 
                node.getIdentifier() != null ?
                        node.getIdentifier().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode(null);
        ExpressionNode liftStartLocationMetaClone = 
                expressionizeBsjSourceLocation(node.getStartLocation());
        ExpressionNode liftStopLocationMetaClone = 
                expressionizeBsjSourceLocation(node.getStopLocation());
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeSuperFieldAccessNode"),
                        factory.makeListNode(
                                Arrays.<ExpressionNode>asList(
                                        liftType,
                                        liftIdentifier,
                                        liftStartLocationMetaClone,
                                        liftStopLocationMetaClone)),
                        factory.makeListNode(Collections.<TypeNode>emptyList()));
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeThrowNode(ThrowNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftExpression = 
                node.getExpression() != null ?
                        node.getExpression().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode(null);
        ExpressionNode liftStartLocationMetaClone = 
                expressionizeBsjSourceLocation(node.getStartLocation());
        ExpressionNode liftStopLocationMetaClone = 
                expressionizeBsjSourceLocation(node.getStopLocation());
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeThrowNode"),
                        factory.makeListNode(
                                Arrays.<ExpressionNode>asList(
                                        liftExpression,
                                        liftStartLocationMetaClone,
                                        liftStopLocationMetaClone)),
                        factory.makeListNode(Collections.<TypeNode>emptyList()));
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeEnumModifiersNode(EnumModifiersNode node, ExpressionNode factoryNode)
    {
        AccessModifier liftAccessValue = 
                node.getAccess();
        boolean liftStrictfpFlagValue = 
                node.getStrictfpFlag();
        argsForListNodeStack.push("AnnotationNode");
        ExpressionNode liftAnnotations = 
                node.getAnnotations() != null ?
                        node.getAnnotations().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode(null);
        argsForListNodeStack.pop();
        ExpressionNode liftStartLocationMetaClone = 
                expressionizeBsjSourceLocation(node.getStartLocation());
        ExpressionNode liftStopLocationMetaClone = 
                expressionizeBsjSourceLocation(node.getStopLocation());
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeEnumModifiersNode"),
                        factory.makeListNode(
                                Arrays.<ExpressionNode>asList(
                                        expressionizeAccessModifier(liftAccessValue),
                                        expressionizeBoolean(liftStrictfpFlagValue),
                                        liftAnnotations,
                                        liftStartLocationMetaClone,
                                        liftStopLocationMetaClone)),
                        factory.makeListNode(Collections.<TypeNode>emptyList()));
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeCatchNode(CatchNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftBlock = 
                node.getBlock() != null ?
                        node.getBlock().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode(null);
        ExpressionNode liftParameter = 
                node.getParameter() != null ?
                        node.getParameter().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode(null);
        ExpressionNode liftStartLocationMetaClone = 
                expressionizeBsjSourceLocation(node.getStartLocation());
        ExpressionNode liftStopLocationMetaClone = 
                expressionizeBsjSourceLocation(node.getStopLocation());
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeCatchNode"),
                        factory.makeListNode(
                                Arrays.<ExpressionNode>asList(
                                        liftBlock,
                                        liftParameter,
                                        liftStartLocationMetaClone,
                                        liftStopLocationMetaClone)),
                        factory.makeListNode(Collections.<TypeNode>emptyList()));
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeVoidTypeDeclarationNode(VoidTypeDeclarationNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftStartLocationMetaClone = 
                expressionizeBsjSourceLocation(node.getStartLocation());
        ExpressionNode liftStopLocationMetaClone = 
                expressionizeBsjSourceLocation(node.getStopLocation());
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeVoidTypeDeclarationNode"),
                        factory.makeListNode(
                                Arrays.<ExpressionNode>asList(
                                        liftStartLocationMetaClone,
                                        liftStopLocationMetaClone)),
                        factory.makeListNode(Collections.<TypeNode>emptyList()));
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeNormalAnnotationNode(NormalAnnotationNode node, ExpressionNode factoryNode)
    {
        argsForListNodeStack.push("AnnotationElementNode");
        ExpressionNode liftArguments = 
                node.getArguments() != null ?
                        node.getArguments().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode(null);
        argsForListNodeStack.pop();
        ExpressionNode liftAnnotationType = 
                node.getAnnotationType() != null ?
                        node.getAnnotationType().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode(null);
        ExpressionNode liftStartLocationMetaClone = 
                expressionizeBsjSourceLocation(node.getStartLocation());
        ExpressionNode liftStopLocationMetaClone = 
                expressionizeBsjSourceLocation(node.getStopLocation());
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeNormalAnnotationNode"),
                        factory.makeListNode(
                                Arrays.<ExpressionNode>asList(
                                        liftArguments,
                                        liftAnnotationType,
                                        liftStartLocationMetaClone,
                                        liftStopLocationMetaClone)),
                        factory.makeListNode(Collections.<TypeNode>emptyList()));
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeDoWhileLoopNode(DoWhileLoopNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftCondition = 
                node.getCondition() != null ?
                        node.getCondition().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode(null);
        ExpressionNode liftStatement = 
                node.getStatement() != null ?
                        node.getStatement().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode(null);
        ExpressionNode liftStartLocationMetaClone = 
                expressionizeBsjSourceLocation(node.getStartLocation());
        ExpressionNode liftStopLocationMetaClone = 
                expressionizeBsjSourceLocation(node.getStopLocation());
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeDoWhileLoopNode"),
                        factory.makeListNode(
                                Arrays.<ExpressionNode>asList(
                                        liftCondition,
                                        liftStatement,
                                        liftStartLocationMetaClone,
                                        liftStopLocationMetaClone)),
                        factory.makeListNode(Collections.<TypeNode>emptyList()));
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeQualifiedClassInstantiationNode(QualifiedClassInstantiationNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftEnclosingExpression = 
                node.getEnclosingExpression() != null ?
                        node.getEnclosingExpression().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode(null);
        ExpressionNode liftIdentifier = 
                node.getIdentifier() != null ?
                        node.getIdentifier().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode(null);
        argsForListNodeStack.push("TypeArgumentNode");
        ExpressionNode liftTypeArguments = 
                node.getTypeArguments() != null ?
                        node.getTypeArguments().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode(null);
        argsForListNodeStack.pop();
        argsForListNodeStack.push("TypeArgumentNode");
        ExpressionNode liftConstructorTypeArguments = 
                node.getConstructorTypeArguments() != null ?
                        node.getConstructorTypeArguments().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode(null);
        argsForListNodeStack.pop();
        argsForListNodeStack.push("ExpressionNode");
        ExpressionNode liftArguments = 
                node.getArguments() != null ?
                        node.getArguments().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode(null);
        argsForListNodeStack.pop();
        ExpressionNode liftBody = 
                node.getBody() != null ?
                        node.getBody().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode(null);
        ExpressionNode liftStartLocationMetaClone = 
                expressionizeBsjSourceLocation(node.getStartLocation());
        ExpressionNode liftStopLocationMetaClone = 
                expressionizeBsjSourceLocation(node.getStopLocation());
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeQualifiedClassInstantiationNode"),
                        factory.makeListNode(
                                Arrays.<ExpressionNode>asList(
                                        liftEnclosingExpression,
                                        liftIdentifier,
                                        liftTypeArguments,
                                        liftConstructorTypeArguments,
                                        liftArguments,
                                        liftBody,
                                        liftStartLocationMetaClone,
                                        liftStopLocationMetaClone)),
                        factory.makeListNode(Collections.<TypeNode>emptyList()));
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeTypeCastNode(TypeCastNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftExpression = 
                node.getExpression() != null ?
                        node.getExpression().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode(null);
        ExpressionNode liftType = 
                node.getType() != null ?
                        node.getType().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode(null);
        ExpressionNode liftStartLocationMetaClone = 
                expressionizeBsjSourceLocation(node.getStartLocation());
        ExpressionNode liftStopLocationMetaClone = 
                expressionizeBsjSourceLocation(node.getStopLocation());
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeTypeCastNode"),
                        factory.makeListNode(
                                Arrays.<ExpressionNode>asList(
                                        liftExpression,
                                        liftType,
                                        liftStartLocationMetaClone,
                                        liftStopLocationMetaClone)),
                        factory.makeListNode(Collections.<TypeNode>emptyList()));
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeLabeledStatementNode(LabeledStatementNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftLabel = 
                node.getLabel() != null ?
                        node.getLabel().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode(null);
        ExpressionNode liftStatement = 
                node.getStatement() != null ?
                        node.getStatement().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode(null);
        ExpressionNode liftStartLocationMetaClone = 
                expressionizeBsjSourceLocation(node.getStartLocation());
        ExpressionNode liftStopLocationMetaClone = 
                expressionizeBsjSourceLocation(node.getStopLocation());
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeLabeledStatementNode"),
                        factory.makeListNode(
                                Arrays.<ExpressionNode>asList(
                                        liftLabel,
                                        liftStatement,
                                        liftStartLocationMetaClone,
                                        liftStopLocationMetaClone)),
                        factory.makeListNode(Collections.<TypeNode>emptyList()));
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeBinaryExpressionNode(BinaryExpressionNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftLeftOperand = 
                node.getLeftOperand() != null ?
                        node.getLeftOperand().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode(null);
        ExpressionNode liftRightOperand = 
                node.getRightOperand() != null ?
                        node.getRightOperand().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode(null);
        BinaryOperator liftOperatorValue = 
                node.getOperator();
        ExpressionNode liftStartLocationMetaClone = 
                expressionizeBsjSourceLocation(node.getStartLocation());
        ExpressionNode liftStopLocationMetaClone = 
                expressionizeBsjSourceLocation(node.getStopLocation());
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeBinaryExpressionNode"),
                        factory.makeListNode(
                                Arrays.<ExpressionNode>asList(
                                        liftLeftOperand,
                                        liftRightOperand,
                                        expressionizeBinaryOperator(liftOperatorValue),
                                        liftStartLocationMetaClone,
                                        liftStopLocationMetaClone)),
                        factory.makeListNode(Collections.<TypeNode>emptyList()));
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeForInitializerExpressionNode(ForInitializerExpressionNode node, ExpressionNode factoryNode)
    {
        argsForListNodeStack.push("StatementExpressionNode");
        ExpressionNode liftExpressions = 
                node.getExpressions() != null ?
                        node.getExpressions().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode(null);
        argsForListNodeStack.pop();
        ExpressionNode liftStartLocationMetaClone = 
                expressionizeBsjSourceLocation(node.getStartLocation());
        ExpressionNode liftStopLocationMetaClone = 
                expressionizeBsjSourceLocation(node.getStopLocation());
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeForInitializerExpressionNode"),
                        factory.makeListNode(
                                Arrays.<ExpressionNode>asList(
                                        liftExpressions,
                                        liftStartLocationMetaClone,
                                        liftStopLocationMetaClone)),
                        factory.makeListNode(Collections.<TypeNode>emptyList()));
        
        return ret;
    }
    
    @Override
    public ExpressionNode executePackageDeclarationNode(PackageDeclarationNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftName = 
                node.getName() != null ?
                        node.getName().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode(null);
        argsForListNodeStack.push("AnnotationNode");
        ExpressionNode liftAnnotations = 
                node.getAnnotations() != null ?
                        node.getAnnotations().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode(null);
        argsForListNodeStack.pop();
        ExpressionNode liftStartLocationMetaClone = 
                expressionizeBsjSourceLocation(node.getStartLocation());
        ExpressionNode liftStopLocationMetaClone = 
                expressionizeBsjSourceLocation(node.getStopLocation());
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makePackageDeclarationNode"),
                        factory.makeListNode(
                                Arrays.<ExpressionNode>asList(
                                        liftName,
                                        liftAnnotations,
                                        liftStartLocationMetaClone,
                                        liftStopLocationMetaClone)),
                        factory.makeListNode(Collections.<TypeNode>emptyList()));
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeAnnotationDeclarationNode(AnnotationDeclarationNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftModifiers = 
                node.getModifiers() != null ?
                        node.getModifiers().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode(null);
        ExpressionNode liftBody = 
                node.getBody() != null ?
                        node.getBody().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode(null);
        ExpressionNode liftIdentifier = 
                node.getIdentifier() != null ?
                        node.getIdentifier().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode(null);
        ExpressionNode liftJavadoc = 
                node.getJavadoc() != null ?
                        node.getJavadoc().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode(null);
        ExpressionNode liftStartLocationMetaClone = 
                expressionizeBsjSourceLocation(node.getStartLocation());
        ExpressionNode liftStopLocationMetaClone = 
                expressionizeBsjSourceLocation(node.getStopLocation());
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeAnnotationDeclarationNode"),
                        factory.makeListNode(
                                Arrays.<ExpressionNode>asList(
                                        liftModifiers,
                                        liftBody,
                                        liftIdentifier,
                                        liftJavadoc,
                                        liftStartLocationMetaClone,
                                        liftStopLocationMetaClone)),
                        factory.makeListNode(Collections.<TypeNode>emptyList()));
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeCompilationUnitNode(CompilationUnitNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftPackageDeclaration = 
                node.getPackageDeclaration() != null ?
                        node.getPackageDeclaration().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode(null);
        argsForListNodeStack.push("ImportNode");
        ExpressionNode liftImports = 
                node.getImports() != null ?
                        node.getImports().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode(null);
        argsForListNodeStack.pop();
        argsForListNodeStack.push("TypeDeclarationNode");
        ExpressionNode liftTypeDecls = 
                node.getTypeDecls() != null ?
                        node.getTypeDecls().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode(null);
        argsForListNodeStack.pop();
        ExpressionNode liftStartLocationMetaClone = 
                expressionizeBsjSourceLocation(node.getStartLocation());
        ExpressionNode liftStopLocationMetaClone = 
                expressionizeBsjSourceLocation(node.getStopLocation());
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeCompilationUnitNode"),
                        factory.makeListNode(
                                Arrays.<ExpressionNode>asList(
                                        liftPackageDeclaration,
                                        liftImports,
                                        liftTypeDecls,
                                        liftStartLocationMetaClone,
                                        liftStopLocationMetaClone)),
                        factory.makeListNode(Collections.<TypeNode>emptyList()));
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeContinueNode(ContinueNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftLabel = 
                node.getLabel() != null ?
                        node.getLabel().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode(null);
        ExpressionNode liftStartLocationMetaClone = 
                expressionizeBsjSourceLocation(node.getStartLocation());
        ExpressionNode liftStopLocationMetaClone = 
                expressionizeBsjSourceLocation(node.getStopLocation());
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeContinueNode"),
                        factory.makeListNode(
                                Arrays.<ExpressionNode>asList(
                                        liftLabel,
                                        liftStartLocationMetaClone,
                                        liftStopLocationMetaClone)),
                        factory.makeListNode(Collections.<TypeNode>emptyList()));
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeStringLiteralNode(StringLiteralNode node, ExpressionNode factoryNode)
    {
        String liftValueValue = 
                node.getValue();
        ExpressionNode liftStartLocationMetaClone = 
                expressionizeBsjSourceLocation(node.getStartLocation());
        ExpressionNode liftStopLocationMetaClone = 
                expressionizeBsjSourceLocation(node.getStopLocation());
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeStringLiteralNode"),
                        factory.makeListNode(
                                Arrays.<ExpressionNode>asList(
                                        expressionizeString(liftValueValue),
                                        liftStartLocationMetaClone,
                                        liftStopLocationMetaClone)),
                        factory.makeListNode(Collections.<TypeNode>emptyList()));
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeAnnotationElementNode(AnnotationElementNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftIdentifier = 
                node.getIdentifier() != null ?
                        node.getIdentifier().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode(null);
        ExpressionNode liftValue = 
                node.getValue() != null ?
                        node.getValue().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode(null);
        ExpressionNode liftStartLocationMetaClone = 
                expressionizeBsjSourceLocation(node.getStartLocation());
        ExpressionNode liftStopLocationMetaClone = 
                expressionizeBsjSourceLocation(node.getStopLocation());
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeAnnotationElementNode"),
                        factory.makeListNode(
                                Arrays.<ExpressionNode>asList(
                                        liftIdentifier,
                                        liftValue,
                                        liftStartLocationMetaClone,
                                        liftStopLocationMetaClone)),
                        factory.makeListNode(Collections.<TypeNode>emptyList()));
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeDoubleLiteralNode(DoubleLiteralNode node, ExpressionNode factoryNode)
    {
        Double liftValueValue = 
                node.getValue();
        ExpressionNode liftStartLocationMetaClone = 
                expressionizeBsjSourceLocation(node.getStartLocation());
        ExpressionNode liftStopLocationMetaClone = 
                expressionizeBsjSourceLocation(node.getStopLocation());
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeDoubleLiteralNode"),
                        factory.makeListNode(
                                Arrays.<ExpressionNode>asList(
                                        expressionizeDouble(liftValueValue),
                                        liftStartLocationMetaClone,
                                        liftStopLocationMetaClone)),
                        factory.makeListNode(Collections.<TypeNode>emptyList()));
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeAnonymousClassBodyNode(AnonymousClassBodyNode node, ExpressionNode factoryNode)
    {
        argsForListNodeStack.push("AnonymousClassMemberNode");
        ExpressionNode liftMembers = 
                node.getMembers() != null ?
                        node.getMembers().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode(null);
        argsForListNodeStack.pop();
        ExpressionNode liftStartLocationMetaClone = 
                expressionizeBsjSourceLocation(node.getStartLocation());
        ExpressionNode liftStopLocationMetaClone = 
                expressionizeBsjSourceLocation(node.getStopLocation());
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeAnonymousClassBodyNode"),
                        factory.makeListNode(
                                Arrays.<ExpressionNode>asList(
                                        liftMembers,
                                        liftStartLocationMetaClone,
                                        liftStopLocationMetaClone)),
                        factory.makeListNode(Collections.<TypeNode>emptyList()));
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeBlockNode(BlockNode node, ExpressionNode factoryNode)
    {
        argsForListNodeStack.push("BlockStatementNode");
        ExpressionNode liftStatements = 
                node.getStatements() != null ?
                        node.getStatements().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode(null);
        argsForListNodeStack.pop();
        ExpressionNode liftStartLocationMetaClone = 
                expressionizeBsjSourceLocation(node.getStartLocation());
        ExpressionNode liftStopLocationMetaClone = 
                expressionizeBsjSourceLocation(node.getStopLocation());
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeBlockNode"),
                        factory.makeListNode(
                                Arrays.<ExpressionNode>asList(
                                        liftStatements,
                                        liftStartLocationMetaClone,
                                        liftStopLocationMetaClone)),
                        factory.makeListNode(Collections.<TypeNode>emptyList()));
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeSynchronizedNode(SynchronizedNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftExpression = 
                node.getExpression() != null ?
                        node.getExpression().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode(null);
        ExpressionNode liftBlock = 
                node.getBlock() != null ?
                        node.getBlock().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode(null);
        ExpressionNode liftStartLocationMetaClone = 
                expressionizeBsjSourceLocation(node.getStartLocation());
        ExpressionNode liftStopLocationMetaClone = 
                expressionizeBsjSourceLocation(node.getStopLocation());
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeSynchronizedNode"),
                        factory.makeListNode(
                                Arrays.<ExpressionNode>asList(
                                        liftExpression,
                                        liftBlock,
                                        liftStartLocationMetaClone,
                                        liftStopLocationMetaClone)),
                        factory.makeListNode(Collections.<TypeNode>emptyList()));
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeVariableNode(VariableNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftModifiers = 
                node.getModifiers() != null ?
                        node.getModifiers().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode(null);
        ExpressionNode liftType = 
                node.getType() != null ?
                        node.getType().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode(null);
        ExpressionNode liftIdentifier = 
                node.getIdentifier() != null ?
                        node.getIdentifier().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode(null);
        ExpressionNode liftStartLocationMetaClone = 
                expressionizeBsjSourceLocation(node.getStartLocation());
        ExpressionNode liftStopLocationMetaClone = 
                expressionizeBsjSourceLocation(node.getStopLocation());
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeVariableNode"),
                        factory.makeListNode(
                                Arrays.<ExpressionNode>asList(
                                        liftModifiers,
                                        liftType,
                                        liftIdentifier,
                                        liftStartLocationMetaClone,
                                        liftStopLocationMetaClone)),
                        factory.makeListNode(Collections.<TypeNode>emptyList()));
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeCharLiteralNode(CharLiteralNode node, ExpressionNode factoryNode)
    {
        Character liftValueValue = 
                node.getValue();
        ExpressionNode liftStartLocationMetaClone = 
                expressionizeBsjSourceLocation(node.getStartLocation());
        ExpressionNode liftStopLocationMetaClone = 
                expressionizeBsjSourceLocation(node.getStopLocation());
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeCharLiteralNode"),
                        factory.makeListNode(
                                Arrays.<ExpressionNode>asList(
                                        expressionizeCharacter(liftValueValue),
                                        liftStartLocationMetaClone,
                                        liftStopLocationMetaClone)),
                        factory.makeListNode(Collections.<TypeNode>emptyList()));
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeWildcardTypeNode(WildcardTypeNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftBound = 
                node.getBound() != null ?
                        node.getBound().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode(null);
        boolean liftUpperBoundValue = 
                node.getUpperBound();
        ExpressionNode liftStartLocationMetaClone = 
                expressionizeBsjSourceLocation(node.getStartLocation());
        ExpressionNode liftStopLocationMetaClone = 
                expressionizeBsjSourceLocation(node.getStopLocation());
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeWildcardTypeNode"),
                        factory.makeListNode(
                                Arrays.<ExpressionNode>asList(
                                        liftBound,
                                        expressionizeBoolean(liftUpperBoundValue),
                                        liftStartLocationMetaClone,
                                        liftStopLocationMetaClone)),
                        factory.makeListNode(Collections.<TypeNode>emptyList()));
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeInlineTypeDeclarationNode(InlineTypeDeclarationNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftDeclaration = 
                node.getDeclaration() != null ?
                        node.getDeclaration().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode(null);
        ExpressionNode liftStartLocationMetaClone = 
                expressionizeBsjSourceLocation(node.getStartLocation());
        ExpressionNode liftStopLocationMetaClone = 
                expressionizeBsjSourceLocation(node.getStopLocation());
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeInlineTypeDeclarationNode"),
                        factory.makeListNode(
                                Arrays.<ExpressionNode>asList(
                                        liftDeclaration,
                                        liftStartLocationMetaClone,
                                        liftStopLocationMetaClone)),
                        factory.makeListNode(Collections.<TypeNode>emptyList()));
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeUnaryExpressionNode(UnaryExpressionNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftExpression = 
                node.getExpression() != null ?
                        node.getExpression().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode(null);
        UnaryOperator liftOperatorValue = 
                node.getOperator();
        ExpressionNode liftStartLocationMetaClone = 
                expressionizeBsjSourceLocation(node.getStartLocation());
        ExpressionNode liftStopLocationMetaClone = 
                expressionizeBsjSourceLocation(node.getStopLocation());
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeUnaryExpressionNode"),
                        factory.makeListNode(
                                Arrays.<ExpressionNode>asList(
                                        liftExpression,
                                        expressionizeUnaryOperator(liftOperatorValue),
                                        liftStartLocationMetaClone,
                                        liftStopLocationMetaClone)),
                        factory.makeListNode(Collections.<TypeNode>emptyList()));
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeBooleanLiteralNode(BooleanLiteralNode node, ExpressionNode factoryNode)
    {
        Boolean liftValueValue = 
                node.getValue();
        ExpressionNode liftStartLocationMetaClone = 
                expressionizeBsjSourceLocation(node.getStartLocation());
        ExpressionNode liftStopLocationMetaClone = 
                expressionizeBsjSourceLocation(node.getStopLocation());
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeBooleanLiteralNode"),
                        factory.makeListNode(
                                Arrays.<ExpressionNode>asList(
                                        expressionizeBoolean(liftValueValue),
                                        liftStartLocationMetaClone,
                                        liftStopLocationMetaClone)),
                        factory.makeListNode(Collections.<TypeNode>emptyList()));
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeSwitchNode(SwitchNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftExpression = 
                node.getExpression() != null ?
                        node.getExpression().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode(null);
        argsForListNodeStack.push("CaseNode");
        ExpressionNode liftCases = 
                node.getCases() != null ?
                        node.getCases().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode(null);
        argsForListNodeStack.pop();
        ExpressionNode liftStartLocationMetaClone = 
                expressionizeBsjSourceLocation(node.getStartLocation());
        ExpressionNode liftStopLocationMetaClone = 
                expressionizeBsjSourceLocation(node.getStopLocation());
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeSwitchNode"),
                        factory.makeListNode(
                                Arrays.<ExpressionNode>asList(
                                        liftExpression,
                                        liftCases,
                                        liftStartLocationMetaClone,
                                        liftStopLocationMetaClone)),
                        factory.makeListNode(Collections.<TypeNode>emptyList()));
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeAlternateConstructorInvocationNode(AlternateConstructorInvocationNode node, ExpressionNode factoryNode)
    {
        argsForListNodeStack.push("ExpressionNode");
        ExpressionNode liftArguments = 
                node.getArguments() != null ?
                        node.getArguments().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode(null);
        argsForListNodeStack.pop();
        argsForListNodeStack.push("TypeNode");
        ExpressionNode liftTypeArguments = 
                node.getTypeArguments() != null ?
                        node.getTypeArguments().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode(null);
        argsForListNodeStack.pop();
        ExpressionNode liftStartLocationMetaClone = 
                expressionizeBsjSourceLocation(node.getStartLocation());
        ExpressionNode liftStopLocationMetaClone = 
                expressionizeBsjSourceLocation(node.getStopLocation());
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeAlternateConstructorInvocationNode"),
                        factory.makeListNode(
                                Arrays.<ExpressionNode>asList(
                                        liftArguments,
                                        liftTypeArguments,
                                        liftStartLocationMetaClone,
                                        liftStopLocationMetaClone)),
                        factory.makeListNode(Collections.<TypeNode>emptyList()));
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeAnnotationMethodModifiersNode(AnnotationMethodModifiersNode node, ExpressionNode factoryNode)
    {
        argsForListNodeStack.push("AnnotationNode");
        ExpressionNode liftAnnotations = 
                node.getAnnotations() != null ?
                        node.getAnnotations().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode(null);
        argsForListNodeStack.pop();
        ExpressionNode liftStartLocationMetaClone = 
                expressionizeBsjSourceLocation(node.getStartLocation());
        ExpressionNode liftStopLocationMetaClone = 
                expressionizeBsjSourceLocation(node.getStopLocation());
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeAnnotationMethodModifiersNode"),
                        factory.makeListNode(
                                Arrays.<ExpressionNode>asList(
                                        liftAnnotations,
                                        liftStartLocationMetaClone,
                                        liftStopLocationMetaClone)),
                        factory.makeListNode(Collections.<TypeNode>emptyList()));
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeConstructorDeclarationNode(ConstructorDeclarationNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftIdentifier = 
                node.getIdentifier() != null ?
                        node.getIdentifier().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode(null);
        ExpressionNode liftBody = 
                node.getBody() != null ?
                        node.getBody().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode(null);
        ExpressionNode liftModifiers = 
                node.getModifiers() != null ?
                        node.getModifiers().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode(null);
        argsForListNodeStack.push("VariableNode");
        ExpressionNode liftParameters = 
                node.getParameters() != null ?
                        node.getParameters().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode(null);
        argsForListNodeStack.pop();
        ExpressionNode liftVarargParameter = 
                node.getVarargParameter() != null ?
                        node.getVarargParameter().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode(null);
        argsForListNodeStack.push("UnparameterizedTypeNode");
        ExpressionNode liftThrowTypes = 
                node.getThrowTypes() != null ?
                        node.getThrowTypes().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode(null);
        argsForListNodeStack.pop();
        argsForListNodeStack.push("TypeParameterNode");
        ExpressionNode liftTypeParameters = 
                node.getTypeParameters() != null ?
                        node.getTypeParameters().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode(null);
        argsForListNodeStack.pop();
        ExpressionNode liftJavadoc = 
                node.getJavadoc() != null ?
                        node.getJavadoc().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode(null);
        ExpressionNode liftStartLocationMetaClone = 
                expressionizeBsjSourceLocation(node.getStartLocation());
        ExpressionNode liftStopLocationMetaClone = 
                expressionizeBsjSourceLocation(node.getStopLocation());
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeConstructorDeclarationNode"),
                        factory.makeListNode(
                                Arrays.<ExpressionNode>asList(
                                        liftIdentifier,
                                        liftBody,
                                        liftModifiers,
                                        liftParameters,
                                        liftVarargParameter,
                                        liftThrowTypes,
                                        liftTypeParameters,
                                        liftJavadoc,
                                        liftStartLocationMetaClone,
                                        liftStopLocationMetaClone)),
                        factory.makeListNode(Collections.<TypeNode>emptyList()));
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeAnnotationAnnotationValueNode(AnnotationAnnotationValueNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftAnnotation = 
                node.getAnnotation() != null ?
                        node.getAnnotation().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode(null);
        ExpressionNode liftStartLocationMetaClone = 
                expressionizeBsjSourceLocation(node.getStartLocation());
        ExpressionNode liftStopLocationMetaClone = 
                expressionizeBsjSourceLocation(node.getStopLocation());
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeAnnotationAnnotationValueNode"),
                        factory.makeListNode(
                                Arrays.<ExpressionNode>asList(
                                        liftAnnotation,
                                        liftStartLocationMetaClone,
                                        liftStopLocationMetaClone)),
                        factory.makeListNode(Collections.<TypeNode>emptyList()));
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeForLoopNode(ForLoopNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftInitializer = 
                node.getInitializer() != null ?
                        node.getInitializer().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode(null);
        ExpressionNode liftCondition = 
                node.getCondition() != null ?
                        node.getCondition().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode(null);
        argsForListNodeStack.push("StatementExpressionNode");
        ExpressionNode liftUpdate = 
                node.getUpdate() != null ?
                        node.getUpdate().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode(null);
        argsForListNodeStack.pop();
        ExpressionNode liftStatement = 
                node.getStatement() != null ?
                        node.getStatement().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode(null);
        ExpressionNode liftStartLocationMetaClone = 
                expressionizeBsjSourceLocation(node.getStartLocation());
        ExpressionNode liftStopLocationMetaClone = 
                expressionizeBsjSourceLocation(node.getStopLocation());
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeForLoopNode"),
                        factory.makeListNode(
                                Arrays.<ExpressionNode>asList(
                                        liftInitializer,
                                        liftCondition,
                                        liftUpdate,
                                        liftStatement,
                                        liftStartLocationMetaClone,
                                        liftStopLocationMetaClone)),
                        factory.makeListNode(Collections.<TypeNode>emptyList()));
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeWhileLoopNode(WhileLoopNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftCondition = 
                node.getCondition() != null ?
                        node.getCondition().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode(null);
        ExpressionNode liftStatement = 
                node.getStatement() != null ?
                        node.getStatement().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode(null);
        ExpressionNode liftStartLocationMetaClone = 
                expressionizeBsjSourceLocation(node.getStartLocation());
        ExpressionNode liftStopLocationMetaClone = 
                expressionizeBsjSourceLocation(node.getStopLocation());
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeWhileLoopNode"),
                        factory.makeListNode(
                                Arrays.<ExpressionNode>asList(
                                        liftCondition,
                                        liftStatement,
                                        liftStartLocationMetaClone,
                                        liftStopLocationMetaClone)),
                        factory.makeListNode(Collections.<TypeNode>emptyList()));
        
        return ret;
    }
    
    @Override
    public <T extends Node> ExpressionNode executeListNode(ListNode<T> node, ExpressionNode factoryNode)
    {
        String typeName;
        if (argsForListNodeStack.size() == 0)
        {
            typeName = "T";
        } else
        {
            typeName = argsForListNodeStack.peek();
        }
        return executeListNode(node, factoryNode, typeName);
    }
    
    protected <T extends Node> ExpressionNode executeListNode(ListNode<T> node, ExpressionNode factoryNode, String argName)
    {
        List<ExpressionNode> liftChildrenList = new ArrayList<ExpressionNode>();
        for (T listval : node.getChildren())
        {
            liftChildrenList.add(
                    listval != null ? 
        			        listval.executeOperation(this,factoryNode) :
                            null);
        }
        ExpressionNode liftStartLocationMetaClone = 
                expressionizeBsjSourceLocation(node.getStartLocation());
        ExpressionNode liftStopLocationMetaClone = 
                expressionizeBsjSourceLocation(node.getStopLocation());
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeListNode"),
                        factory.makeListNode(
                                Arrays.<ExpressionNode>asList(
                                        factory.makeMethodInvocationByNameNode(
                                                factory.makeQualifiedNameNode(
                                                        factory.makeSimpleNameNode(
                                                                factory.makeIdentifierNode("Arrays"),
                                                                NameCategory.TYPE),
                                                        factory.makeIdentifierNode("asList"),
                                                        NameCategory.METHOD),
                                                factory.makeListNode(liftChildrenList),
                                                factory.makeListNode(Collections.<TypeNode>singletonList(
                                                        factory.makeUnparameterizedTypeNode(
                                                                factory.makeSimpleNameNode(
                                                                        factory.makeIdentifierNode(argName),
                                                                        NameCategory.TYPE))))),
                                        liftStartLocationMetaClone,
                                        liftStopLocationMetaClone)),
                        factory.makeListNode(Collections.<TypeNode>emptyList()));
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeEnumConstantDeclarationNode(EnumConstantDeclarationNode node, ExpressionNode factoryNode)
    {
        argsForListNodeStack.push("AnnotationNode");
        ExpressionNode liftAnnotations = 
                node.getAnnotations() != null ?
                        node.getAnnotations().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode(null);
        argsForListNodeStack.pop();
        ExpressionNode liftIdentifier = 
                node.getIdentifier() != null ?
                        node.getIdentifier().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode(null);
        argsForListNodeStack.push("ExpressionNode");
        ExpressionNode liftArguments = 
                node.getArguments() != null ?
                        node.getArguments().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode(null);
        argsForListNodeStack.pop();
        ExpressionNode liftBody = 
                node.getBody() != null ?
                        node.getBody().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode(null);
        ExpressionNode liftJavadoc = 
                node.getJavadoc() != null ?
                        node.getJavadoc().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode(null);
        ExpressionNode liftStartLocationMetaClone = 
                expressionizeBsjSourceLocation(node.getStartLocation());
        ExpressionNode liftStopLocationMetaClone = 
                expressionizeBsjSourceLocation(node.getStopLocation());
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeEnumConstantDeclarationNode"),
                        factory.makeListNode(
                                Arrays.<ExpressionNode>asList(
                                        liftAnnotations,
                                        liftIdentifier,
                                        liftArguments,
                                        liftBody,
                                        liftJavadoc,
                                        liftStartLocationMetaClone,
                                        liftStopLocationMetaClone)),
                        factory.makeListNode(Collections.<TypeNode>emptyList()));
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeBreakNode(BreakNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftLabel = 
                node.getLabel() != null ?
                        node.getLabel().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode(null);
        ExpressionNode liftStartLocationMetaClone = 
                expressionizeBsjSourceLocation(node.getStartLocation());
        ExpressionNode liftStopLocationMetaClone = 
                expressionizeBsjSourceLocation(node.getStopLocation());
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeBreakNode"),
                        factory.makeListNode(
                                Arrays.<ExpressionNode>asList(
                                        liftLabel,
                                        liftStartLocationMetaClone,
                                        liftStopLocationMetaClone)),
                        factory.makeListNode(Collections.<TypeNode>emptyList()));
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeConstructorModifiersNode(ConstructorModifiersNode node, ExpressionNode factoryNode)
    {
        AccessModifier liftAccessValue = 
                node.getAccess();
        argsForListNodeStack.push("AnnotationNode");
        ExpressionNode liftAnnotations = 
                node.getAnnotations() != null ?
                        node.getAnnotations().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode(null);
        argsForListNodeStack.pop();
        ExpressionNode liftStartLocationMetaClone = 
                expressionizeBsjSourceLocation(node.getStartLocation());
        ExpressionNode liftStopLocationMetaClone = 
                expressionizeBsjSourceLocation(node.getStopLocation());
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeConstructorModifiersNode"),
                        factory.makeListNode(
                                Arrays.<ExpressionNode>asList(
                                        expressionizeAccessModifier(liftAccessValue),
                                        liftAnnotations,
                                        liftStartLocationMetaClone,
                                        liftStopLocationMetaClone)),
                        factory.makeListNode(Collections.<TypeNode>emptyList()));
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeParameterizedTypeSelectNode(ParameterizedTypeSelectNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftBase = 
                node.getBase() != null ?
                        node.getBase().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode(null);
        ExpressionNode liftSelect = 
                node.getSelect() != null ?
                        node.getSelect().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode(null);
        ExpressionNode liftStartLocationMetaClone = 
                expressionizeBsjSourceLocation(node.getStartLocation());
        ExpressionNode liftStopLocationMetaClone = 
                expressionizeBsjSourceLocation(node.getStopLocation());
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeParameterizedTypeSelectNode"),
                        factory.makeListNode(
                                Arrays.<ExpressionNode>asList(
                                        liftBase,
                                        liftSelect,
                                        liftStartLocationMetaClone,
                                        liftStopLocationMetaClone)),
                        factory.makeListNode(Collections.<TypeNode>emptyList()));
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeIdentifierNode(IdentifierNode node, ExpressionNode factoryNode)
    {
        String liftIdentifierValue = 
                node.getIdentifier();
        ExpressionNode liftStartLocationMetaClone = 
                expressionizeBsjSourceLocation(node.getStartLocation());
        ExpressionNode liftStopLocationMetaClone = 
                expressionizeBsjSourceLocation(node.getStopLocation());
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeIdentifierNode"),
                        factory.makeListNode(
                                Arrays.<ExpressionNode>asList(
                                        expressionizeString(liftIdentifierValue),
                                        liftStartLocationMetaClone,
                                        liftStopLocationMetaClone)),
                        factory.makeListNode(Collections.<TypeNode>emptyList()));
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeArrayTypeNode(ArrayTypeNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftType = 
                node.getType() != null ?
                        node.getType().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode(null);
        ExpressionNode liftStartLocationMetaClone = 
                expressionizeBsjSourceLocation(node.getStartLocation());
        ExpressionNode liftStopLocationMetaClone = 
                expressionizeBsjSourceLocation(node.getStopLocation());
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeArrayTypeNode"),
                        factory.makeListNode(
                                Arrays.<ExpressionNode>asList(
                                        liftType,
                                        liftStartLocationMetaClone,
                                        liftStopLocationMetaClone)),
                        factory.makeListNode(Collections.<TypeNode>emptyList()));
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeArrayInitializerCreationNode(ArrayInitializerCreationNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftInitializer = 
                node.getInitializer() != null ?
                        node.getInitializer().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode(null);
        ExpressionNode liftBaseType = 
                node.getBaseType() != null ?
                        node.getBaseType().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode(null);
        int liftArrayLevelsValue = 
                node.getArrayLevels();
        ExpressionNode liftStartLocationMetaClone = 
                expressionizeBsjSourceLocation(node.getStartLocation());
        ExpressionNode liftStopLocationMetaClone = 
                expressionizeBsjSourceLocation(node.getStopLocation());
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeArrayInitializerCreationNode"),
                        factory.makeListNode(
                                Arrays.<ExpressionNode>asList(
                                        liftInitializer,
                                        liftBaseType,
                                        expressionizeInt(liftArrayLevelsValue),
                                        liftStartLocationMetaClone,
                                        liftStopLocationMetaClone)),
                        factory.makeListNode(Collections.<TypeNode>emptyList()));
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeFieldModifiersNode(FieldModifiersNode node, ExpressionNode factoryNode)
    {
        AccessModifier liftAccessValue = 
                node.getAccess();
        boolean liftStaticFlagValue = 
                node.getStaticFlag();
        boolean liftFinalFlagValue = 
                node.getFinalFlag();
        boolean liftTransientFlagValue = 
                node.getTransientFlag();
        boolean liftVolatileFlagValue = 
                node.getVolatileFlag();
        argsForListNodeStack.push("AnnotationNode");
        ExpressionNode liftAnnotations = 
                node.getAnnotations() != null ?
                        node.getAnnotations().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode(null);
        argsForListNodeStack.pop();
        ExpressionNode liftStartLocationMetaClone = 
                expressionizeBsjSourceLocation(node.getStartLocation());
        ExpressionNode liftStopLocationMetaClone = 
                expressionizeBsjSourceLocation(node.getStopLocation());
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeFieldModifiersNode"),
                        factory.makeListNode(
                                Arrays.<ExpressionNode>asList(
                                        expressionizeAccessModifier(liftAccessValue),
                                        expressionizeBoolean(liftStaticFlagValue),
                                        expressionizeBoolean(liftFinalFlagValue),
                                        expressionizeBoolean(liftTransientFlagValue),
                                        expressionizeBoolean(liftVolatileFlagValue),
                                        liftAnnotations,
                                        liftStartLocationMetaClone,
                                        liftStopLocationMetaClone)),
                        factory.makeListNode(Collections.<TypeNode>emptyList()));
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeTypeParameterNode(TypeParameterNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftIdentifier = 
                node.getIdentifier() != null ?
                        node.getIdentifier().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode(null);
        argsForListNodeStack.push("DeclaredTypeNode");
        ExpressionNode liftBounds = 
                node.getBounds() != null ?
                        node.getBounds().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode(null);
        argsForListNodeStack.pop();
        ExpressionNode liftStartLocationMetaClone = 
                expressionizeBsjSourceLocation(node.getStartLocation());
        ExpressionNode liftStopLocationMetaClone = 
                expressionizeBsjSourceLocation(node.getStopLocation());
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeTypeParameterNode"),
                        factory.makeListNode(
                                Arrays.<ExpressionNode>asList(
                                        liftIdentifier,
                                        liftBounds,
                                        liftStartLocationMetaClone,
                                        liftStopLocationMetaClone)),
                        factory.makeListNode(Collections.<TypeNode>emptyList()));
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeAnnotationMethodDeclarationNode(AnnotationMethodDeclarationNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftModifiers = 
                node.getModifiers() != null ?
                        node.getModifiers().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode(null);
        ExpressionNode liftType = 
                node.getType() != null ?
                        node.getType().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode(null);
        ExpressionNode liftIdentifier = 
                node.getIdentifier() != null ?
                        node.getIdentifier().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode(null);
        ExpressionNode liftDefaultValue = 
                node.getDefaultValue() != null ?
                        node.getDefaultValue().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode(null);
        ExpressionNode liftJavadoc = 
                node.getJavadoc() != null ?
                        node.getJavadoc().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode(null);
        ExpressionNode liftStartLocationMetaClone = 
                expressionizeBsjSourceLocation(node.getStartLocation());
        ExpressionNode liftStopLocationMetaClone = 
                expressionizeBsjSourceLocation(node.getStopLocation());
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeAnnotationMethodDeclarationNode"),
                        factory.makeListNode(
                                Arrays.<ExpressionNode>asList(
                                        liftModifiers,
                                        liftType,
                                        liftIdentifier,
                                        liftDefaultValue,
                                        liftJavadoc,
                                        liftStartLocationMetaClone,
                                        liftStopLocationMetaClone)),
                        factory.makeListNode(Collections.<TypeNode>emptyList()));
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeImportSingleTypeNode(ImportSingleTypeNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftName = 
                node.getName() != null ?
                        node.getName().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode(null);
        boolean liftStaticImportValue = 
                node.getStaticImport();
        ExpressionNode liftStartLocationMetaClone = 
                expressionizeBsjSourceLocation(node.getStartLocation());
        ExpressionNode liftStopLocationMetaClone = 
                expressionizeBsjSourceLocation(node.getStopLocation());
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeImportSingleTypeNode"),
                        factory.makeListNode(
                                Arrays.<ExpressionNode>asList(
                                        liftName,
                                        expressionizeBoolean(liftStaticImportValue),
                                        liftStartLocationMetaClone,
                                        liftStopLocationMetaClone)),
                        factory.makeListNode(Collections.<TypeNode>emptyList()));
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeFieldDeclarationNode(FieldDeclarationNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftModifiers = 
                node.getModifiers() != null ?
                        node.getModifiers().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode(null);
        argsForListNodeStack.push("VariableDeclaratorNode");
        ExpressionNode liftDeclarators = 
                node.getDeclarators() != null ?
                        node.getDeclarators().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode(null);
        argsForListNodeStack.pop();
        ExpressionNode liftJavadoc = 
                node.getJavadoc() != null ?
                        node.getJavadoc().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode(null);
        ExpressionNode liftStartLocationMetaClone = 
                expressionizeBsjSourceLocation(node.getStartLocation());
        ExpressionNode liftStopLocationMetaClone = 
                expressionizeBsjSourceLocation(node.getStopLocation());
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeFieldDeclarationNode"),
                        factory.makeListNode(
                                Arrays.<ExpressionNode>asList(
                                        liftModifiers,
                                        liftDeclarators,
                                        liftJavadoc,
                                        liftStartLocationMetaClone,
                                        liftStopLocationMetaClone)),
                        factory.makeListNode(Collections.<TypeNode>emptyList()));
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeAnnotationArrayValueNode(AnnotationArrayValueNode node, ExpressionNode factoryNode)
    {
        argsForListNodeStack.push("AnnotationValueNode");
        ExpressionNode liftValues = 
                node.getValues() != null ?
                        node.getValues().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode(null);
        argsForListNodeStack.pop();
        ExpressionNode liftStartLocationMetaClone = 
                expressionizeBsjSourceLocation(node.getStartLocation());
        ExpressionNode liftStopLocationMetaClone = 
                expressionizeBsjSourceLocation(node.getStopLocation());
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeAnnotationArrayValueNode"),
                        factory.makeListNode(
                                Arrays.<ExpressionNode>asList(
                                        liftValues,
                                        liftStartLocationMetaClone,
                                        liftStopLocationMetaClone)),
                        factory.makeListNode(Collections.<TypeNode>emptyList()));
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeSingleElementAnnotationNode(SingleElementAnnotationNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftValue = 
                node.getValue() != null ?
                        node.getValue().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode(null);
        ExpressionNode liftAnnotationType = 
                node.getAnnotationType() != null ?
                        node.getAnnotationType().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode(null);
        ExpressionNode liftStartLocationMetaClone = 
                expressionizeBsjSourceLocation(node.getStartLocation());
        ExpressionNode liftStopLocationMetaClone = 
                expressionizeBsjSourceLocation(node.getStopLocation());
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeSingleElementAnnotationNode"),
                        factory.makeListNode(
                                Arrays.<ExpressionNode>asList(
                                        liftValue,
                                        liftAnnotationType,
                                        liftStartLocationMetaClone,
                                        liftStopLocationMetaClone)),
                        factory.makeListNode(Collections.<TypeNode>emptyList()));
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeClassLiteralNode(ClassLiteralNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftValue = 
                node.getValue() != null ?
                        node.getValue().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode(null);
        ExpressionNode liftStartLocationMetaClone = 
                expressionizeBsjSourceLocation(node.getStartLocation());
        ExpressionNode liftStopLocationMetaClone = 
                expressionizeBsjSourceLocation(node.getStopLocation());
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeClassLiteralNode"),
                        factory.makeListNode(
                                Arrays.<ExpressionNode>asList(
                                        liftValue,
                                        liftStartLocationMetaClone,
                                        liftStopLocationMetaClone)),
                        factory.makeListNode(Collections.<TypeNode>emptyList()));
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeSuperMethodInvocationNode(SuperMethodInvocationNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftType = 
                node.getType() != null ?
                        node.getType().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode(null);
        ExpressionNode liftIdentifier = 
                node.getIdentifier() != null ?
                        node.getIdentifier().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode(null);
        argsForListNodeStack.push("ExpressionNode");
        ExpressionNode liftArguments = 
                node.getArguments() != null ?
                        node.getArguments().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode(null);
        argsForListNodeStack.pop();
        argsForListNodeStack.push("TypeNode");
        ExpressionNode liftTypeArguments = 
                node.getTypeArguments() != null ?
                        node.getTypeArguments().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode(null);
        argsForListNodeStack.pop();
        ExpressionNode liftStartLocationMetaClone = 
                expressionizeBsjSourceLocation(node.getStartLocation());
        ExpressionNode liftStopLocationMetaClone = 
                expressionizeBsjSourceLocation(node.getStopLocation());
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeSuperMethodInvocationNode"),
                        factory.makeListNode(
                                Arrays.<ExpressionNode>asList(
                                        liftType,
                                        liftIdentifier,
                                        liftArguments,
                                        liftTypeArguments,
                                        liftStartLocationMetaClone,
                                        liftStopLocationMetaClone)),
                        factory.makeListNode(Collections.<TypeNode>emptyList()));
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeClassModifiersNode(ClassModifiersNode node, ExpressionNode factoryNode)
    {
        AccessModifier liftAccessValue = 
                node.getAccess();
        boolean liftAbstractFlagValue = 
                node.getAbstractFlag();
        boolean liftStaticFlagValue = 
                node.getStaticFlag();
        boolean liftFinalFlagValue = 
                node.getFinalFlag();
        boolean liftStrictfpFlagValue = 
                node.getStrictfpFlag();
        argsForListNodeStack.push("AnnotationNode");
        ExpressionNode liftAnnotations = 
                node.getAnnotations() != null ?
                        node.getAnnotations().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode(null);
        argsForListNodeStack.pop();
        ExpressionNode liftStartLocationMetaClone = 
                expressionizeBsjSourceLocation(node.getStartLocation());
        ExpressionNode liftStopLocationMetaClone = 
                expressionizeBsjSourceLocation(node.getStopLocation());
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeClassModifiersNode"),
                        factory.makeListNode(
                                Arrays.<ExpressionNode>asList(
                                        expressionizeAccessModifier(liftAccessValue),
                                        expressionizeBoolean(liftAbstractFlagValue),
                                        expressionizeBoolean(liftStaticFlagValue),
                                        expressionizeBoolean(liftFinalFlagValue),
                                        expressionizeBoolean(liftStrictfpFlagValue),
                                        liftAnnotations,
                                        liftStartLocationMetaClone,
                                        liftStopLocationMetaClone)),
                        factory.makeListNode(Collections.<TypeNode>emptyList()));
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeArrayInitializerNode(ArrayInitializerNode node, ExpressionNode factoryNode)
    {
        argsForListNodeStack.push("VariableInitializerNode");
        ExpressionNode liftInitializers = 
                node.getInitializers() != null ?
                        node.getInitializers().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode(null);
        argsForListNodeStack.pop();
        ExpressionNode liftStartLocationMetaClone = 
                expressionizeBsjSourceLocation(node.getStartLocation());
        ExpressionNode liftStopLocationMetaClone = 
                expressionizeBsjSourceLocation(node.getStopLocation());
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeArrayInitializerNode"),
                        factory.makeListNode(
                                Arrays.<ExpressionNode>asList(
                                        liftInitializers,
                                        liftStartLocationMetaClone,
                                        liftStopLocationMetaClone)),
                        factory.makeListNode(Collections.<TypeNode>emptyList()));
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeAnnotationExpressionValueNode(AnnotationExpressionValueNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftExpression = 
                node.getExpression() != null ?
                        node.getExpression().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode(null);
        ExpressionNode liftStartLocationMetaClone = 
                expressionizeBsjSourceLocation(node.getStartLocation());
        ExpressionNode liftStopLocationMetaClone = 
                expressionizeBsjSourceLocation(node.getStopLocation());
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeAnnotationExpressionValueNode"),
                        factory.makeListNode(
                                Arrays.<ExpressionNode>asList(
                                        liftExpression,
                                        liftStartLocationMetaClone,
                                        liftStopLocationMetaClone)),
                        factory.makeListNode(Collections.<TypeNode>emptyList()));
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeReturnNode(ReturnNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftExpression = 
                node.getExpression() != null ?
                        node.getExpression().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode(null);
        ExpressionNode liftStartLocationMetaClone = 
                expressionizeBsjSourceLocation(node.getStartLocation());
        ExpressionNode liftStopLocationMetaClone = 
                expressionizeBsjSourceLocation(node.getStopLocation());
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeReturnNode"),
                        factory.makeListNode(
                                Arrays.<ExpressionNode>asList(
                                        liftExpression,
                                        liftStartLocationMetaClone,
                                        liftStopLocationMetaClone)),
                        factory.makeListNode(Collections.<TypeNode>emptyList()));
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeAssignmentNode(AssignmentNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftVariable = 
                node.getVariable() != null ?
                        node.getVariable().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode(null);
        AssignmentOperator liftOperatorValue = 
                node.getOperator();
        ExpressionNode liftExpression = 
                node.getExpression() != null ?
                        node.getExpression().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode(null);
        ExpressionNode liftStartLocationMetaClone = 
                expressionizeBsjSourceLocation(node.getStartLocation());
        ExpressionNode liftStopLocationMetaClone = 
                expressionizeBsjSourceLocation(node.getStopLocation());
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeAssignmentNode"),
                        factory.makeListNode(
                                Arrays.<ExpressionNode>asList(
                                        liftVariable,
                                        expressionizeAssignmentOperator(liftOperatorValue),
                                        liftExpression,
                                        liftStartLocationMetaClone,
                                        liftStopLocationMetaClone)),
                        factory.makeListNode(Collections.<TypeNode>emptyList()));
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeMethodInvocationByExpressionNode(MethodInvocationByExpressionNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftExpression = 
                node.getExpression() != null ?
                        node.getExpression().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode(null);
        ExpressionNode liftIdentifier = 
                node.getIdentifier() != null ?
                        node.getIdentifier().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode(null);
        argsForListNodeStack.push("ExpressionNode");
        ExpressionNode liftArguments = 
                node.getArguments() != null ?
                        node.getArguments().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode(null);
        argsForListNodeStack.pop();
        argsForListNodeStack.push("TypeNode");
        ExpressionNode liftTypeArguments = 
                node.getTypeArguments() != null ?
                        node.getTypeArguments().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode(null);
        argsForListNodeStack.pop();
        ExpressionNode liftStartLocationMetaClone = 
                expressionizeBsjSourceLocation(node.getStartLocation());
        ExpressionNode liftStopLocationMetaClone = 
                expressionizeBsjSourceLocation(node.getStopLocation());
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeMethodInvocationByExpressionNode"),
                        factory.makeListNode(
                                Arrays.<ExpressionNode>asList(
                                        liftExpression,
                                        liftIdentifier,
                                        liftArguments,
                                        liftTypeArguments,
                                        liftStartLocationMetaClone,
                                        liftStopLocationMetaClone)),
                        factory.makeListNode(Collections.<TypeNode>emptyList()));
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeInstanceOfNode(InstanceOfNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftExpression = 
                node.getExpression() != null ?
                        node.getExpression().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode(null);
        ExpressionNode liftType = 
                node.getType() != null ?
                        node.getType().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode(null);
        ExpressionNode liftStartLocationMetaClone = 
                expressionizeBsjSourceLocation(node.getStartLocation());
        ExpressionNode liftStopLocationMetaClone = 
                expressionizeBsjSourceLocation(node.getStopLocation());
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeInstanceOfNode"),
                        factory.makeListNode(
                                Arrays.<ExpressionNode>asList(
                                        liftExpression,
                                        liftType,
                                        liftStartLocationMetaClone,
                                        liftStopLocationMetaClone)),
                        factory.makeListNode(Collections.<TypeNode>emptyList()));
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeConditionalExpressionNode(ConditionalExpressionNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftCondition = 
                node.getCondition() != null ?
                        node.getCondition().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode(null);
        ExpressionNode liftTrueExpression = 
                node.getTrueExpression() != null ?
                        node.getTrueExpression().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode(null);
        ExpressionNode liftFalseExpression = 
                node.getFalseExpression() != null ?
                        node.getFalseExpression().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode(null);
        ExpressionNode liftStartLocationMetaClone = 
                expressionizeBsjSourceLocation(node.getStartLocation());
        ExpressionNode liftStopLocationMetaClone = 
                expressionizeBsjSourceLocation(node.getStopLocation());
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeConditionalExpressionNode"),
                        factory.makeListNode(
                                Arrays.<ExpressionNode>asList(
                                        liftCondition,
                                        liftTrueExpression,
                                        liftFalseExpression,
                                        liftStartLocationMetaClone,
                                        liftStopLocationMetaClone)),
                        factory.makeListNode(Collections.<TypeNode>emptyList()));
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeParenthesizedExpressionNode(ParenthesizedExpressionNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftExpression = 
                node.getExpression() != null ?
                        node.getExpression().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode(null);
        ExpressionNode liftStartLocationMetaClone = 
                expressionizeBsjSourceLocation(node.getStartLocation());
        ExpressionNode liftStopLocationMetaClone = 
                expressionizeBsjSourceLocation(node.getStopLocation());
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeParenthesizedExpressionNode"),
                        factory.makeListNode(
                                Arrays.<ExpressionNode>asList(
                                        liftExpression,
                                        liftStartLocationMetaClone,
                                        liftStopLocationMetaClone)),
                        factory.makeListNode(Collections.<TypeNode>emptyList()));
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeFloatLiteralNode(FloatLiteralNode node, ExpressionNode factoryNode)
    {
        Float liftValueValue = 
                node.getValue();
        ExpressionNode liftStartLocationMetaClone = 
                expressionizeBsjSourceLocation(node.getStartLocation());
        ExpressionNode liftStopLocationMetaClone = 
                expressionizeBsjSourceLocation(node.getStopLocation());
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeFloatLiteralNode"),
                        factory.makeListNode(
                                Arrays.<ExpressionNode>asList(
                                        expressionizeFloat(liftValueValue),
                                        liftStartLocationMetaClone,
                                        liftStopLocationMetaClone)),
                        factory.makeListNode(Collections.<TypeNode>emptyList()));
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeMethodInvocationByNameNode(MethodInvocationByNameNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftName = 
                node.getName() != null ?
                        node.getName().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode(null);
        argsForListNodeStack.push("ExpressionNode");
        ExpressionNode liftArguments = 
                node.getArguments() != null ?
                        node.getArguments().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode(null);
        argsForListNodeStack.pop();
        argsForListNodeStack.push("TypeNode");
        ExpressionNode liftTypeArguments = 
                node.getTypeArguments() != null ?
                        node.getTypeArguments().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode(null);
        argsForListNodeStack.pop();
        ExpressionNode liftStartLocationMetaClone = 
                expressionizeBsjSourceLocation(node.getStartLocation());
        ExpressionNode liftStopLocationMetaClone = 
                expressionizeBsjSourceLocation(node.getStopLocation());
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeMethodInvocationByNameNode"),
                        factory.makeListNode(
                                Arrays.<ExpressionNode>asList(
                                        liftName,
                                        liftArguments,
                                        liftTypeArguments,
                                        liftStartLocationMetaClone,
                                        liftStopLocationMetaClone)),
                        factory.makeListNode(Collections.<TypeNode>emptyList()));
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeParameterizedTypeNode(ParameterizedTypeNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftBaseType = 
                node.getBaseType() != null ?
                        node.getBaseType().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode(null);
        argsForListNodeStack.push("TypeArgumentNode");
        ExpressionNode liftTypeArguments = 
                node.getTypeArguments() != null ?
                        node.getTypeArguments().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode(null);
        argsForListNodeStack.pop();
        ExpressionNode liftStartLocationMetaClone = 
                expressionizeBsjSourceLocation(node.getStartLocation());
        ExpressionNode liftStopLocationMetaClone = 
                expressionizeBsjSourceLocation(node.getStopLocation());
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeParameterizedTypeNode"),
                        factory.makeListNode(
                                Arrays.<ExpressionNode>asList(
                                        liftBaseType,
                                        liftTypeArguments,
                                        liftStartLocationMetaClone,
                                        liftStopLocationMetaClone)),
                        factory.makeListNode(Collections.<TypeNode>emptyList()));
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeInterfaceDeclarationNode(InterfaceDeclarationNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftModifiers = 
                node.getModifiers() != null ?
                        node.getModifiers().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode(null);
        argsForListNodeStack.push("TypeNode");
        ExpressionNode liftExtendsClause = 
                node.getExtendsClause() != null ?
                        node.getExtendsClause().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode(null);
        argsForListNodeStack.pop();
        ExpressionNode liftBody = 
                node.getBody() != null ?
                        node.getBody().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode(null);
        argsForListNodeStack.push("TypeParameterNode");
        ExpressionNode liftTypeParameters = 
                node.getTypeParameters() != null ?
                        node.getTypeParameters().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode(null);
        argsForListNodeStack.pop();
        ExpressionNode liftIdentifier = 
                node.getIdentifier() != null ?
                        node.getIdentifier().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode(null);
        ExpressionNode liftJavadoc = 
                node.getJavadoc() != null ?
                        node.getJavadoc().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode(null);
        ExpressionNode liftStartLocationMetaClone = 
                expressionizeBsjSourceLocation(node.getStartLocation());
        ExpressionNode liftStopLocationMetaClone = 
                expressionizeBsjSourceLocation(node.getStopLocation());
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeInterfaceDeclarationNode"),
                        factory.makeListNode(
                                Arrays.<ExpressionNode>asList(
                                        liftModifiers,
                                        liftExtendsClause,
                                        liftBody,
                                        liftTypeParameters,
                                        liftIdentifier,
                                        liftJavadoc,
                                        liftStartLocationMetaClone,
                                        liftStopLocationMetaClone)),
                        factory.makeListNode(Collections.<TypeNode>emptyList()));
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeForInitializerDeclarationNode(ForInitializerDeclarationNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftDeclaration = 
                node.getDeclaration() != null ?
                        node.getDeclaration().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode(null);
        ExpressionNode liftStartLocationMetaClone = 
                expressionizeBsjSourceLocation(node.getStartLocation());
        ExpressionNode liftStopLocationMetaClone = 
                expressionizeBsjSourceLocation(node.getStopLocation());
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeForInitializerDeclarationNode"),
                        factory.makeListNode(
                                Arrays.<ExpressionNode>asList(
                                        liftDeclaration,
                                        liftStartLocationMetaClone,
                                        liftStopLocationMetaClone)),
                        factory.makeListNode(Collections.<TypeNode>emptyList()));
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeConstructorBodyNode(ConstructorBodyNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftConstructorInvocation = 
                node.getConstructorInvocation() != null ?
                        node.getConstructorInvocation().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode(null);
        argsForListNodeStack.push("BlockStatementNode");
        ExpressionNode liftStatements = 
                node.getStatements() != null ?
                        node.getStatements().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode(null);
        argsForListNodeStack.pop();
        ExpressionNode liftStartLocationMetaClone = 
                expressionizeBsjSourceLocation(node.getStartLocation());
        ExpressionNode liftStopLocationMetaClone = 
                expressionizeBsjSourceLocation(node.getStopLocation());
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeConstructorBodyNode"),
                        factory.makeListNode(
                                Arrays.<ExpressionNode>asList(
                                        liftConstructorInvocation,
                                        liftStatements,
                                        liftStartLocationMetaClone,
                                        liftStopLocationMetaClone)),
                        factory.makeListNode(Collections.<TypeNode>emptyList()));
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeFieldAccessByNameNode(FieldAccessByNameNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftName = 
                node.getName() != null ?
                        node.getName().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode(null);
        ExpressionNode liftStartLocationMetaClone = 
                expressionizeBsjSourceLocation(node.getStartLocation());
        ExpressionNode liftStopLocationMetaClone = 
                expressionizeBsjSourceLocation(node.getStopLocation());
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeFieldAccessByNameNode"),
                        factory.makeListNode(
                                Arrays.<ExpressionNode>asList(
                                        liftName,
                                        liftStartLocationMetaClone,
                                        liftStopLocationMetaClone)),
                        factory.makeListNode(Collections.<TypeNode>emptyList()));
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeUnqualifiedClassInstantiationNode(UnqualifiedClassInstantiationNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftType = 
                node.getType() != null ?
                        node.getType().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode(null);
        argsForListNodeStack.push("TypeArgumentNode");
        ExpressionNode liftConstructorTypeArguments = 
                node.getConstructorTypeArguments() != null ?
                        node.getConstructorTypeArguments().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode(null);
        argsForListNodeStack.pop();
        argsForListNodeStack.push("ExpressionNode");
        ExpressionNode liftArguments = 
                node.getArguments() != null ?
                        node.getArguments().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode(null);
        argsForListNodeStack.pop();
        ExpressionNode liftBody = 
                node.getBody() != null ?
                        node.getBody().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode(null);
        ExpressionNode liftStartLocationMetaClone = 
                expressionizeBsjSourceLocation(node.getStartLocation());
        ExpressionNode liftStopLocationMetaClone = 
                expressionizeBsjSourceLocation(node.getStopLocation());
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeUnqualifiedClassInstantiationNode"),
                        factory.makeListNode(
                                Arrays.<ExpressionNode>asList(
                                        liftType,
                                        liftConstructorTypeArguments,
                                        liftArguments,
                                        liftBody,
                                        liftStartLocationMetaClone,
                                        liftStopLocationMetaClone)),
                        factory.makeListNode(Collections.<TypeNode>emptyList()));
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeSimpleNameNode(SimpleNameNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftIdentifier = 
                node.getIdentifier() != null ?
                        node.getIdentifier().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode(null);
        NameCategory liftCategoryValue = 
                node.getCategory();
        ExpressionNode liftStartLocationMetaClone = 
                expressionizeBsjSourceLocation(node.getStartLocation());
        ExpressionNode liftStopLocationMetaClone = 
                expressionizeBsjSourceLocation(node.getStopLocation());
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeSimpleNameNode"),
                        factory.makeListNode(
                                Arrays.<ExpressionNode>asList(
                                        liftIdentifier,
                                        expressionizeNameCategory(liftCategoryValue),
                                        liftStartLocationMetaClone,
                                        liftStopLocationMetaClone)),
                        factory.makeListNode(Collections.<TypeNode>emptyList()));
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeArrayInstantiatorCreationNode(ArrayInstantiatorCreationNode node, ExpressionNode factoryNode)
    {
        argsForListNodeStack.push("ExpressionNode");
        ExpressionNode liftDimExpressions = 
                node.getDimExpressions() != null ?
                        node.getDimExpressions().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode(null);
        argsForListNodeStack.pop();
        ExpressionNode liftBaseType = 
                node.getBaseType() != null ?
                        node.getBaseType().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode(null);
        int liftArrayLevelsValue = 
                node.getArrayLevels();
        ExpressionNode liftStartLocationMetaClone = 
                expressionizeBsjSourceLocation(node.getStartLocation());
        ExpressionNode liftStopLocationMetaClone = 
                expressionizeBsjSourceLocation(node.getStopLocation());
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeArrayInstantiatorCreationNode"),
                        factory.makeListNode(
                                Arrays.<ExpressionNode>asList(
                                        liftDimExpressions,
                                        liftBaseType,
                                        expressionizeInt(liftArrayLevelsValue),
                                        liftStartLocationMetaClone,
                                        liftStopLocationMetaClone)),
                        factory.makeListNode(Collections.<TypeNode>emptyList()));
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeMethodModifiersNode(MethodModifiersNode node, ExpressionNode factoryNode)
    {
        AccessModifier liftAccessValue = 
                node.getAccess();
        boolean liftAbstractFlagValue = 
                node.getAbstractFlag();
        boolean liftStaticFlagValue = 
                node.getStaticFlag();
        boolean liftFinalFlagValue = 
                node.getFinalFlag();
        boolean liftSynchronizedFlagValue = 
                node.getSynchronizedFlag();
        boolean liftNativeFlagValue = 
                node.getNativeFlag();
        boolean liftStrictfpFlagValue = 
                node.getStrictfpFlag();
        argsForListNodeStack.push("AnnotationNode");
        ExpressionNode liftAnnotations = 
                node.getAnnotations() != null ?
                        node.getAnnotations().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode(null);
        argsForListNodeStack.pop();
        ExpressionNode liftStartLocationMetaClone = 
                expressionizeBsjSourceLocation(node.getStartLocation());
        ExpressionNode liftStopLocationMetaClone = 
                expressionizeBsjSourceLocation(node.getStopLocation());
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeMethodModifiersNode"),
                        factory.makeListNode(
                                Arrays.<ExpressionNode>asList(
                                        expressionizeAccessModifier(liftAccessValue),
                                        expressionizeBoolean(liftAbstractFlagValue),
                                        expressionizeBoolean(liftStaticFlagValue),
                                        expressionizeBoolean(liftFinalFlagValue),
                                        expressionizeBoolean(liftSynchronizedFlagValue),
                                        expressionizeBoolean(liftNativeFlagValue),
                                        expressionizeBoolean(liftStrictfpFlagValue),
                                        liftAnnotations,
                                        liftStartLocationMetaClone,
                                        liftStopLocationMetaClone)),
                        factory.makeListNode(Collections.<TypeNode>emptyList()));
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeClassBodyNode(ClassBodyNode node, ExpressionNode factoryNode)
    {
        argsForListNodeStack.push("ClassMemberNode");
        ExpressionNode liftMembers = 
                node.getMembers() != null ?
                        node.getMembers().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode(null);
        argsForListNodeStack.pop();
        ExpressionNode liftStartLocationMetaClone = 
                expressionizeBsjSourceLocation(node.getStartLocation());
        ExpressionNode liftStopLocationMetaClone = 
                expressionizeBsjSourceLocation(node.getStopLocation());
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeClassBodyNode"),
                        factory.makeListNode(
                                Arrays.<ExpressionNode>asList(
                                        liftMembers,
                                        liftStartLocationMetaClone,
                                        liftStopLocationMetaClone)),
                        factory.makeListNode(Collections.<TypeNode>emptyList()));
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeIfNode(IfNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftCondition = 
                node.getCondition() != null ?
                        node.getCondition().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode(null);
        ExpressionNode liftThenStatement = 
                node.getThenStatement() != null ?
                        node.getThenStatement().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode(null);
        ExpressionNode liftElseStatement = 
                node.getElseStatement() != null ?
                        node.getElseStatement().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode(null);
        ExpressionNode liftStartLocationMetaClone = 
                expressionizeBsjSourceLocation(node.getStartLocation());
        ExpressionNode liftStopLocationMetaClone = 
                expressionizeBsjSourceLocation(node.getStopLocation());
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeIfNode"),
                        factory.makeListNode(
                                Arrays.<ExpressionNode>asList(
                                        liftCondition,
                                        liftThenStatement,
                                        liftElseStatement,
                                        liftStartLocationMetaClone,
                                        liftStopLocationMetaClone)),
                        factory.makeListNode(Collections.<TypeNode>emptyList()));
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeIntLiteralNode(IntLiteralNode node, ExpressionNode factoryNode)
    {
        Integer liftValueValue = 
                node.getValue();
        ExpressionNode liftStartLocationMetaClone = 
                expressionizeBsjSourceLocation(node.getStartLocation());
        ExpressionNode liftStopLocationMetaClone = 
                expressionizeBsjSourceLocation(node.getStopLocation());
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeIntLiteralNode"),
                        factory.makeListNode(
                                Arrays.<ExpressionNode>asList(
                                        expressionizeInteger(liftValueValue),
                                        liftStartLocationMetaClone,
                                        liftStopLocationMetaClone)),
                        factory.makeListNode(Collections.<TypeNode>emptyList()));
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeNullLiteralNode(NullLiteralNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftStartLocationMetaClone = 
                expressionizeBsjSourceLocation(node.getStartLocation());
        ExpressionNode liftStopLocationMetaClone = 
                expressionizeBsjSourceLocation(node.getStopLocation());
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeNullLiteralNode"),
                        factory.makeListNode(
                                Arrays.<ExpressionNode>asList(
                                        factory.makeNullLiteralNode(null),
                                        liftStartLocationMetaClone,
                                        liftStopLocationMetaClone)),
                        factory.makeListNode(Collections.<TypeNode>emptyList()));
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeJavadocNode(JavadocNode node, ExpressionNode factoryNode)
    {
        String liftTextValue = 
                node.getText();
        ExpressionNode liftStartLocationMetaClone = 
                expressionizeBsjSourceLocation(node.getStartLocation());
        ExpressionNode liftStopLocationMetaClone = 
                expressionizeBsjSourceLocation(node.getStopLocation());
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeJavadocNode"),
                        factory.makeListNode(
                                Arrays.<ExpressionNode>asList(
                                        expressionizeString(liftTextValue),
                                        liftStartLocationMetaClone,
                                        liftStopLocationMetaClone)),
                        factory.makeListNode(Collections.<TypeNode>emptyList()));
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeMethodDeclarationNode(MethodDeclarationNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftBody = 
                node.getBody() != null ?
                        node.getBody().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode(null);
        ExpressionNode liftModifiers = 
                node.getModifiers() != null ?
                        node.getModifiers().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode(null);
        ExpressionNode liftIdentifier = 
                node.getIdentifier() != null ?
                        node.getIdentifier().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode(null);
        argsForListNodeStack.push("VariableNode");
        ExpressionNode liftParameters = 
                node.getParameters() != null ?
                        node.getParameters().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode(null);
        argsForListNodeStack.pop();
        ExpressionNode liftVarargParameter = 
                node.getVarargParameter() != null ?
                        node.getVarargParameter().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode(null);
        ExpressionNode liftReturnType = 
                node.getReturnType() != null ?
                        node.getReturnType().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode(null);
        argsForListNodeStack.push("UnparameterizedTypeNode");
        ExpressionNode liftThrowTypes = 
                node.getThrowTypes() != null ?
                        node.getThrowTypes().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode(null);
        argsForListNodeStack.pop();
        argsForListNodeStack.push("TypeParameterNode");
        ExpressionNode liftTypeParameters = 
                node.getTypeParameters() != null ?
                        node.getTypeParameters().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode(null);
        argsForListNodeStack.pop();
        ExpressionNode liftJavadoc = 
                node.getJavadoc() != null ?
                        node.getJavadoc().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode(null);
        ExpressionNode liftStartLocationMetaClone = 
                expressionizeBsjSourceLocation(node.getStartLocation());
        ExpressionNode liftStopLocationMetaClone = 
                expressionizeBsjSourceLocation(node.getStopLocation());
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeMethodDeclarationNode"),
                        factory.makeListNode(
                                Arrays.<ExpressionNode>asList(
                                        liftBody,
                                        liftModifiers,
                                        liftIdentifier,
                                        liftParameters,
                                        liftVarargParameter,
                                        liftReturnType,
                                        liftThrowTypes,
                                        liftTypeParameters,
                                        liftJavadoc,
                                        liftStartLocationMetaClone,
                                        liftStopLocationMetaClone)),
                        factory.makeListNode(Collections.<TypeNode>emptyList()));
        
        return ret;
    }
    
}
