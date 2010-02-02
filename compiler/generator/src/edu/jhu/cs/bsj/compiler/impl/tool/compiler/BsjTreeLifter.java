package edu.jhu.cs.bsj.compiler.impl.tool.compiler;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.AccessModifier;
import edu.jhu.cs.bsj.compiler.ast.AssignmentOperator;
import edu.jhu.cs.bsj.compiler.ast.BinaryOperator;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeOperation;
import edu.jhu.cs.bsj.compiler.ast.NameCategory;
import edu.jhu.cs.bsj.compiler.ast.PrimitiveType;
import edu.jhu.cs.bsj.compiler.ast.UnaryOperator;
import edu.jhu.cs.bsj.compiler.ast.UnaryStatementOperator;
import edu.jhu.cs.bsj.compiler.ast.node.*;
import edu.jhu.cs.bsj.compiler.ast.node.meta.BlockStatementMetaprogramAnchorNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.CodeLiteralNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.TypeDeclarationMetaprogramAnchorNode;
import edu.jhu.cs.bsj.compiler.impl.utils.Pair;

@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class BsjTreeLifter implements BsjNodeOperation<Pair<ExpressionNode,List<BlockStatementNode>>,String>
{
	private int nextVariableId = 0;
	private String getUniqueName()
	{
		return "v" + (nextVariableId++);
	}
	
	protected ExpressionNode expressionizeString(String s)
	{
		return factory.makeStringLiteralNode(s);
	}
	
	protected ExpressionNode expressionizeCharacter(Character c)
	{
		return expressionizeChar(c);
	}
	
	protected ExpressionNode expressionizeInteger(Integer i)
	{
		return expressionizeInt(i);
	}
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
    public String executeAssertStatementNode(AssertStatementNode node, Pair<ExpressionNode,List<BlockStatementNode>> p)
    {
        ExpressionNode factoryNode = p.getFirst();
        List<BlockStatementNode> statements = p.getSecond();

        String liftTestExpressionVarName = 
                node.getTestExpression().executeOperation(this,p);
        String liftMessageExpressionVarName = 
                node.getMessageExpression().executeOperation(this,p);

        String myVarName = getUniqueName();
        statements.add(
                factory.makeVariableDeclarationNode(
                        factory.makeVariableModifiersNode(
                                false,
                                factory.makeListNode(Collections.<AnnotationNode>emptyList())),
                factory.makeListNode(
                        Collections.singletonList(
                                factory.makeVariableDeclaratorNode(
                                        factory.makeUnparameterizedTypeNode(
                                                factory.makeSimpleNameNode(
                                                        factory.makeIdentifierNode("AssertStatementNode"),
                                                        NameCategory.TYPE)),
                                        factory.makeIdentifierNode(myVarName),
                                        factory.makeMethodInvocationByExpressionNode(
                                                factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                                                factory.makeIdentifierNode("makeAssertStatementNode"),
                                                factory.makeListNode(
                                                        Arrays.<ExpressionNode>asList(
                                                                factory.makeFieldAccessByNameNode(factory.makeSimpleNameNode(factory.makeIdentifierNode(
                                                                        liftTestExpressionVarName),NameCategory.EXPRESSION)),
                                                                factory.makeFieldAccessByNameNode(factory.makeSimpleNameNode(factory.makeIdentifierNode(
                                                                        liftMessageExpressionVarName),NameCategory.EXPRESSION))
                                                                )),
                                                factory.makeListNode(Collections.<TypeNode>emptyList()))
            )))));

        return myVarName;
    }

    @Override
    public String executeUnaryStatementExpressionNode(UnaryStatementExpressionNode node, Pair<ExpressionNode,List<BlockStatementNode>> p)
    {
        ExpressionNode factoryNode = p.getFirst();
        List<BlockStatementNode> statements = p.getSecond();

        String liftExpressionVarName = 
                node.getExpression().executeOperation(this,p);
        UnaryStatementOperator liftOperatorValue = 
                node.getOperator();

        String myVarName = getUniqueName();
        statements.add(
                factory.makeVariableDeclarationNode(
                        factory.makeVariableModifiersNode(
                                false,
                                factory.makeListNode(Collections.<AnnotationNode>emptyList())),
                factory.makeListNode(
                        Collections.singletonList(
                                factory.makeVariableDeclaratorNode(
                                        factory.makeUnparameterizedTypeNode(
                                                factory.makeSimpleNameNode(
                                                        factory.makeIdentifierNode("UnaryStatementExpressionNode"),
                                                        NameCategory.TYPE)),
                                        factory.makeIdentifierNode(myVarName),
                                        factory.makeMethodInvocationByExpressionNode(
                                                factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                                                factory.makeIdentifierNode("makeUnaryStatementExpressionNode"),
                                                factory.makeListNode(
                                                        Arrays.<ExpressionNode>asList(
                                                                factory.makeFieldAccessByNameNode(factory.makeSimpleNameNode(factory.makeIdentifierNode(
                                                                        liftExpressionVarName),NameCategory.EXPRESSION)),
                                                                expressionizeUnaryStatementOperator(liftOperatorValue)
                                                                )),
                                                factory.makeListNode(Collections.<TypeNode>emptyList()))
            )))));

        return myVarName;
    }

    @Override
    public String executeInterfaceBodyNode(InterfaceBodyNode node, Pair<ExpressionNode,List<BlockStatementNode>> p)
    {
        ExpressionNode factoryNode = p.getFirst();
        List<BlockStatementNode> statements = p.getSecond();

        String liftMembersVarName = 
                node.getMembers().executeOperation(this,p);

        String myVarName = getUniqueName();
        statements.add(
                factory.makeVariableDeclarationNode(
                        factory.makeVariableModifiersNode(
                                false,
                                factory.makeListNode(Collections.<AnnotationNode>emptyList())),
                factory.makeListNode(
                        Collections.singletonList(
                                factory.makeVariableDeclaratorNode(
                                        factory.makeUnparameterizedTypeNode(
                                                factory.makeSimpleNameNode(
                                                        factory.makeIdentifierNode("InterfaceBodyNode"),
                                                        NameCategory.TYPE)),
                                        factory.makeIdentifierNode(myVarName),
                                        factory.makeMethodInvocationByExpressionNode(
                                                factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                                                factory.makeIdentifierNode("makeInterfaceBodyNode"),
                                                factory.makeListNode(
                                                        Arrays.<ExpressionNode>asList(
                                                                factory.makeFieldAccessByNameNode(factory.makeSimpleNameNode(factory.makeIdentifierNode(
                                                                        liftMembersVarName),NameCategory.EXPRESSION))
                                                                )),
                                                factory.makeListNode(Collections.<TypeNode>emptyList()))
            )))));

        return myVarName;
    }

    @Override
    public String executeExpressionStatementNode(ExpressionStatementNode node, Pair<ExpressionNode,List<BlockStatementNode>> p)
    {
        ExpressionNode factoryNode = p.getFirst();
        List<BlockStatementNode> statements = p.getSecond();

        String liftExpressionVarName = 
                node.getExpression().executeOperation(this,p);

        String myVarName = getUniqueName();
        statements.add(
                factory.makeVariableDeclarationNode(
                        factory.makeVariableModifiersNode(
                                false,
                                factory.makeListNode(Collections.<AnnotationNode>emptyList())),
                factory.makeListNode(
                        Collections.singletonList(
                                factory.makeVariableDeclaratorNode(
                                        factory.makeUnparameterizedTypeNode(
                                                factory.makeSimpleNameNode(
                                                        factory.makeIdentifierNode("ExpressionStatementNode"),
                                                        NameCategory.TYPE)),
                                        factory.makeIdentifierNode(myVarName),
                                        factory.makeMethodInvocationByExpressionNode(
                                                factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                                                factory.makeIdentifierNode("makeExpressionStatementNode"),
                                                factory.makeListNode(
                                                        Arrays.<ExpressionNode>asList(
                                                                factory.makeFieldAccessByNameNode(factory.makeSimpleNameNode(factory.makeIdentifierNode(
                                                                        liftExpressionVarName),NameCategory.EXPRESSION))
                                                                )),
                                                factory.makeListNode(Collections.<TypeNode>emptyList()))
            )))));

        return myVarName;
    }

    @Override
    public String executeClassDeclarationNode(ClassDeclarationNode node, Pair<ExpressionNode,List<BlockStatementNode>> p)
    {
        ExpressionNode factoryNode = p.getFirst();
        List<BlockStatementNode> statements = p.getSecond();

        String liftModifiersVarName = 
                node.getModifiers().executeOperation(this,p);
        String liftExtendsClauseVarName = 
                node.getExtendsClause().executeOperation(this,p);
        String liftImplementsClauseVarName = 
                node.getImplementsClause().executeOperation(this,p);
        String liftBodyVarName = 
                node.getBody().executeOperation(this,p);
        String liftTypeParametersVarName = 
                node.getTypeParameters().executeOperation(this,p);
        String liftIdentifierVarName = 
                node.getIdentifier().executeOperation(this,p);
        String liftJavadocVarName = 
                node.getJavadoc().executeOperation(this,p);

        String myVarName = getUniqueName();
        statements.add(
                factory.makeVariableDeclarationNode(
                        factory.makeVariableModifiersNode(
                                false,
                                factory.makeListNode(Collections.<AnnotationNode>emptyList())),
                factory.makeListNode(
                        Collections.singletonList(
                                factory.makeVariableDeclaratorNode(
                                        factory.makeUnparameterizedTypeNode(
                                                factory.makeSimpleNameNode(
                                                        factory.makeIdentifierNode("ClassDeclarationNode"),
                                                        NameCategory.TYPE)),
                                        factory.makeIdentifierNode(myVarName),
                                        factory.makeMethodInvocationByExpressionNode(
                                                factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                                                factory.makeIdentifierNode("makeClassDeclarationNode"),
                                                factory.makeListNode(
                                                        Arrays.<ExpressionNode>asList(
                                                                factory.makeFieldAccessByNameNode(factory.makeSimpleNameNode(factory.makeIdentifierNode(
                                                                        liftModifiersVarName),NameCategory.EXPRESSION)),
                                                                factory.makeFieldAccessByNameNode(factory.makeSimpleNameNode(factory.makeIdentifierNode(
                                                                        liftExtendsClauseVarName),NameCategory.EXPRESSION)),
                                                                factory.makeFieldAccessByNameNode(factory.makeSimpleNameNode(factory.makeIdentifierNode(
                                                                        liftImplementsClauseVarName),NameCategory.EXPRESSION)),
                                                                factory.makeFieldAccessByNameNode(factory.makeSimpleNameNode(factory.makeIdentifierNode(
                                                                        liftBodyVarName),NameCategory.EXPRESSION)),
                                                                factory.makeFieldAccessByNameNode(factory.makeSimpleNameNode(factory.makeIdentifierNode(
                                                                        liftTypeParametersVarName),NameCategory.EXPRESSION)),
                                                                factory.makeFieldAccessByNameNode(factory.makeSimpleNameNode(factory.makeIdentifierNode(
                                                                        liftIdentifierVarName),NameCategory.EXPRESSION)),
                                                                factory.makeFieldAccessByNameNode(factory.makeSimpleNameNode(factory.makeIdentifierNode(
                                                                        liftJavadocVarName),NameCategory.EXPRESSION))
                                                                )),
                                                factory.makeListNode(Collections.<TypeNode>emptyList()))
            )))));

        return myVarName;
    }

    @Override
    public String executeEnhancedForLoopNode(EnhancedForLoopNode node, Pair<ExpressionNode,List<BlockStatementNode>> p)
    {
        ExpressionNode factoryNode = p.getFirst();
        List<BlockStatementNode> statements = p.getSecond();

        String liftVariableVarName = 
                node.getVariable().executeOperation(this,p);
        String liftExpressionVarName = 
                node.getExpression().executeOperation(this,p);
        String liftStatementVarName = 
                node.getStatement().executeOperation(this,p);

        String myVarName = getUniqueName();
        statements.add(
                factory.makeVariableDeclarationNode(
                        factory.makeVariableModifiersNode(
                                false,
                                factory.makeListNode(Collections.<AnnotationNode>emptyList())),
                factory.makeListNode(
                        Collections.singletonList(
                                factory.makeVariableDeclaratorNode(
                                        factory.makeUnparameterizedTypeNode(
                                                factory.makeSimpleNameNode(
                                                        factory.makeIdentifierNode("EnhancedForLoopNode"),
                                                        NameCategory.TYPE)),
                                        factory.makeIdentifierNode(myVarName),
                                        factory.makeMethodInvocationByExpressionNode(
                                                factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                                                factory.makeIdentifierNode("makeEnhancedForLoopNode"),
                                                factory.makeListNode(
                                                        Arrays.<ExpressionNode>asList(
                                                                factory.makeFieldAccessByNameNode(factory.makeSimpleNameNode(factory.makeIdentifierNode(
                                                                        liftVariableVarName),NameCategory.EXPRESSION)),
                                                                factory.makeFieldAccessByNameNode(factory.makeSimpleNameNode(factory.makeIdentifierNode(
                                                                        liftExpressionVarName),NameCategory.EXPRESSION)),
                                                                factory.makeFieldAccessByNameNode(factory.makeSimpleNameNode(factory.makeIdentifierNode(
                                                                        liftStatementVarName),NameCategory.EXPRESSION))
                                                                )),
                                                factory.makeListNode(Collections.<TypeNode>emptyList()))
            )))));

        return myVarName;
    }

    @Override
    public String executeArrayAccessNode(ArrayAccessNode node, Pair<ExpressionNode,List<BlockStatementNode>> p)
    {
        ExpressionNode factoryNode = p.getFirst();
        List<BlockStatementNode> statements = p.getSecond();

        String liftArrayExpressionVarName = 
                node.getArrayExpression().executeOperation(this,p);
        String liftIndexExpressionVarName = 
                node.getIndexExpression().executeOperation(this,p);

        String myVarName = getUniqueName();
        statements.add(
                factory.makeVariableDeclarationNode(
                        factory.makeVariableModifiersNode(
                                false,
                                factory.makeListNode(Collections.<AnnotationNode>emptyList())),
                factory.makeListNode(
                        Collections.singletonList(
                                factory.makeVariableDeclaratorNode(
                                        factory.makeUnparameterizedTypeNode(
                                                factory.makeSimpleNameNode(
                                                        factory.makeIdentifierNode("ArrayAccessNode"),
                                                        NameCategory.TYPE)),
                                        factory.makeIdentifierNode(myVarName),
                                        factory.makeMethodInvocationByExpressionNode(
                                                factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                                                factory.makeIdentifierNode("makeArrayAccessNode"),
                                                factory.makeListNode(
                                                        Arrays.<ExpressionNode>asList(
                                                                factory.makeFieldAccessByNameNode(factory.makeSimpleNameNode(factory.makeIdentifierNode(
                                                                        liftArrayExpressionVarName),NameCategory.EXPRESSION)),
                                                                factory.makeFieldAccessByNameNode(factory.makeSimpleNameNode(factory.makeIdentifierNode(
                                                                        liftIndexExpressionVarName),NameCategory.EXPRESSION))
                                                                )),
                                                factory.makeListNode(Collections.<TypeNode>emptyList()))
            )))));

        return myVarName;
    }

    @Override
    public String executeLongLiteralNode(LongLiteralNode node, Pair<ExpressionNode,List<BlockStatementNode>> p)
    {
        ExpressionNode factoryNode = p.getFirst();
        List<BlockStatementNode> statements = p.getSecond();

        Long liftValueValue = 
                node.getValue();

        String myVarName = getUniqueName();
        statements.add(
                factory.makeVariableDeclarationNode(
                        factory.makeVariableModifiersNode(
                                false,
                                factory.makeListNode(Collections.<AnnotationNode>emptyList())),
                factory.makeListNode(
                        Collections.singletonList(
                                factory.makeVariableDeclaratorNode(
                                        factory.makeUnparameterizedTypeNode(
                                                factory.makeSimpleNameNode(
                                                        factory.makeIdentifierNode("LongLiteralNode"),
                                                        NameCategory.TYPE)),
                                        factory.makeIdentifierNode(myVarName),
                                        factory.makeMethodInvocationByExpressionNode(
                                                factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                                                factory.makeIdentifierNode("makeLongLiteralNode"),
                                                factory.makeListNode(
                                                        Arrays.<ExpressionNode>asList(
                                                                expressionizeLong(liftValueValue)
                                                                )),
                                                factory.makeListNode(Collections.<TypeNode>emptyList()))
            )))));

        return myVarName;
    }

    @Override
    public String executeQualifiedNameNode(QualifiedNameNode node, Pair<ExpressionNode,List<BlockStatementNode>> p)
    {
        ExpressionNode factoryNode = p.getFirst();
        List<BlockStatementNode> statements = p.getSecond();

        String liftBaseVarName = 
                node.getBase().executeOperation(this,p);
        String liftIdentifierVarName = 
                node.getIdentifier().executeOperation(this,p);
        NameCategory liftCategoryValue = 
                node.getCategory();

        String myVarName = getUniqueName();
        statements.add(
                factory.makeVariableDeclarationNode(
                        factory.makeVariableModifiersNode(
                                false,
                                factory.makeListNode(Collections.<AnnotationNode>emptyList())),
                factory.makeListNode(
                        Collections.singletonList(
                                factory.makeVariableDeclaratorNode(
                                        factory.makeUnparameterizedTypeNode(
                                                factory.makeSimpleNameNode(
                                                        factory.makeIdentifierNode("QualifiedNameNode"),
                                                        NameCategory.TYPE)),
                                        factory.makeIdentifierNode(myVarName),
                                        factory.makeMethodInvocationByExpressionNode(
                                                factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                                                factory.makeIdentifierNode("makeQualifiedNameNode"),
                                                factory.makeListNode(
                                                        Arrays.<ExpressionNode>asList(
                                                                factory.makeFieldAccessByNameNode(factory.makeSimpleNameNode(factory.makeIdentifierNode(
                                                                        liftBaseVarName),NameCategory.EXPRESSION)),
                                                                factory.makeFieldAccessByNameNode(factory.makeSimpleNameNode(factory.makeIdentifierNode(
                                                                        liftIdentifierVarName),NameCategory.EXPRESSION)),
                                                                expressionizeNameCategory(liftCategoryValue)
                                                                )),
                                                factory.makeListNode(Collections.<TypeNode>emptyList()))
            )))));

        return myVarName;
    }

    @Override
    public String executeCaseNode(CaseNode node, Pair<ExpressionNode,List<BlockStatementNode>> p)
    {
        ExpressionNode factoryNode = p.getFirst();
        List<BlockStatementNode> statements = p.getSecond();

        String liftExpressionVarName = 
                node.getExpression().executeOperation(this,p);
        String liftStatementsVarName = 
                node.getStatements().executeOperation(this,p);

        String myVarName = getUniqueName();
        statements.add(
                factory.makeVariableDeclarationNode(
                        factory.makeVariableModifiersNode(
                                false,
                                factory.makeListNode(Collections.<AnnotationNode>emptyList())),
                factory.makeListNode(
                        Collections.singletonList(
                                factory.makeVariableDeclaratorNode(
                                        factory.makeUnparameterizedTypeNode(
                                                factory.makeSimpleNameNode(
                                                        factory.makeIdentifierNode("CaseNode"),
                                                        NameCategory.TYPE)),
                                        factory.makeIdentifierNode(myVarName),
                                        factory.makeMethodInvocationByExpressionNode(
                                                factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                                                factory.makeIdentifierNode("makeCaseNode"),
                                                factory.makeListNode(
                                                        Arrays.<ExpressionNode>asList(
                                                                factory.makeFieldAccessByNameNode(factory.makeSimpleNameNode(factory.makeIdentifierNode(
                                                                        liftExpressionVarName),NameCategory.EXPRESSION)),
                                                                factory.makeFieldAccessByNameNode(factory.makeSimpleNameNode(factory.makeIdentifierNode(
                                                                        liftStatementsVarName),NameCategory.EXPRESSION))
                                                                )),
                                                factory.makeListNode(Collections.<TypeNode>emptyList()))
            )))));

        return myVarName;
    }

    @Override
    public String executeVoidStatementNode(VoidStatementNode node, Pair<ExpressionNode,List<BlockStatementNode>> p)
    {
        ExpressionNode factoryNode = p.getFirst();
        List<BlockStatementNode> statements = p.getSecond();


        String myVarName = getUniqueName();
        statements.add(
                factory.makeVariableDeclarationNode(
                        factory.makeVariableModifiersNode(
                                false,
                                factory.makeListNode(Collections.<AnnotationNode>emptyList())),
                factory.makeListNode(
                        Collections.singletonList(
                                factory.makeVariableDeclaratorNode(
                                        factory.makeUnparameterizedTypeNode(
                                                factory.makeSimpleNameNode(
                                                        factory.makeIdentifierNode("VoidStatementNode"),
                                                        NameCategory.TYPE)),
                                        factory.makeIdentifierNode(myVarName),
                                        factory.makeMethodInvocationByExpressionNode(
                                                factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                                                factory.makeIdentifierNode("makeVoidStatementNode"),
                                                factory.makeListNode(
                                                        Arrays.<ExpressionNode>asList(
                                                                )),
                                                factory.makeListNode(Collections.<TypeNode>emptyList()))
            )))));

        return myVarName;
    }

    @Override
    public String executeCodeLiteralNode(CodeLiteralNode node, Pair<ExpressionNode,List<BlockStatementNode>> p)
    {
        ExpressionNode factoryNode = p.getFirst();
        List<BlockStatementNode> statements = p.getSecond();

        String liftValueVarName = 
                node.getValue().executeOperation(this,p);

        String myVarName = getUniqueName();
        statements.add(
                factory.makeVariableDeclarationNode(
                        factory.makeVariableModifiersNode(
                                false,
                                factory.makeListNode(Collections.<AnnotationNode>emptyList())),
                factory.makeListNode(
                        Collections.singletonList(
                                factory.makeVariableDeclaratorNode(
                                        factory.makeUnparameterizedTypeNode(
                                                factory.makeSimpleNameNode(
                                                        factory.makeIdentifierNode("CodeLiteralNode"),
                                                        NameCategory.TYPE)),
                                        factory.makeIdentifierNode(myVarName),
                                        factory.makeMethodInvocationByExpressionNode(
                                                factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                                                factory.makeIdentifierNode("makeCodeLiteralNode"),
                                                factory.makeListNode(
                                                        Arrays.<ExpressionNode>asList(
                                                                factory.makeFieldAccessByNameNode(factory.makeSimpleNameNode(factory.makeIdentifierNode(
                                                                        liftValueVarName),NameCategory.EXPRESSION))
                                                                )),
                                                factory.makeListNode(Collections.<TypeNode>emptyList()))
            )))));

        return myVarName;
    }

    @Override
    public String executeImportOnDemandNode(ImportOnDemandNode node, Pair<ExpressionNode,List<BlockStatementNode>> p)
    {
        ExpressionNode factoryNode = p.getFirst();
        List<BlockStatementNode> statements = p.getSecond();

        String liftNameVarName = 
                node.getName().executeOperation(this,p);
        boolean liftStaticImportValue = 
                node.getStaticImport();

        String myVarName = getUniqueName();
        statements.add(
                factory.makeVariableDeclarationNode(
                        factory.makeVariableModifiersNode(
                                false,
                                factory.makeListNode(Collections.<AnnotationNode>emptyList())),
                factory.makeListNode(
                        Collections.singletonList(
                                factory.makeVariableDeclaratorNode(
                                        factory.makeUnparameterizedTypeNode(
                                                factory.makeSimpleNameNode(
                                                        factory.makeIdentifierNode("ImportOnDemandNode"),
                                                        NameCategory.TYPE)),
                                        factory.makeIdentifierNode(myVarName),
                                        factory.makeMethodInvocationByExpressionNode(
                                                factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                                                factory.makeIdentifierNode("makeImportOnDemandNode"),
                                                factory.makeListNode(
                                                        Arrays.<ExpressionNode>asList(
                                                                factory.makeFieldAccessByNameNode(factory.makeSimpleNameNode(factory.makeIdentifierNode(
                                                                        liftNameVarName),NameCategory.EXPRESSION)),
                                                                expressionizeBoolean(liftStaticImportValue)
                                                                )),
                                                factory.makeListNode(Collections.<TypeNode>emptyList()))
            )))));

        return myVarName;
    }

    @Override
    public String executeVariableModifiersNode(VariableModifiersNode node, Pair<ExpressionNode,List<BlockStatementNode>> p)
    {
        ExpressionNode factoryNode = p.getFirst();
        List<BlockStatementNode> statements = p.getSecond();

        boolean liftFinalFlagValue = 
                node.getFinalFlag();
        String liftAnnotationsVarName = 
                node.getAnnotations().executeOperation(this,p);

        String myVarName = getUniqueName();
        statements.add(
                factory.makeVariableDeclarationNode(
                        factory.makeVariableModifiersNode(
                                false,
                                factory.makeListNode(Collections.<AnnotationNode>emptyList())),
                factory.makeListNode(
                        Collections.singletonList(
                                factory.makeVariableDeclaratorNode(
                                        factory.makeUnparameterizedTypeNode(
                                                factory.makeSimpleNameNode(
                                                        factory.makeIdentifierNode("VariableModifiersNode"),
                                                        NameCategory.TYPE)),
                                        factory.makeIdentifierNode(myVarName),
                                        factory.makeMethodInvocationByExpressionNode(
                                                factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                                                factory.makeIdentifierNode("makeVariableModifiersNode"),
                                                factory.makeListNode(
                                                        Arrays.<ExpressionNode>asList(
                                                                expressionizeBoolean(liftFinalFlagValue),
                                                                factory.makeFieldAccessByNameNode(factory.makeSimpleNameNode(factory.makeIdentifierNode(
                                                                        liftAnnotationsVarName),NameCategory.EXPRESSION))
                                                                )),
                                                factory.makeListNode(Collections.<TypeNode>emptyList()))
            )))));

        return myVarName;
    }

    @Override
    public String executeBlockStatementMetaprogramAnchorNode(BlockStatementMetaprogramAnchorNode node, Pair<ExpressionNode,List<BlockStatementNode>> p)
    {
        ExpressionNode factoryNode = p.getFirst();
        List<BlockStatementNode> statements = p.getSecond();

        String liftMetaprogramVarName = 
                node.getMetaprogram().executeOperation(this,p);

        String myVarName = getUniqueName();
        statements.add(
                factory.makeVariableDeclarationNode(
                        factory.makeVariableModifiersNode(
                                false,
                                factory.makeListNode(Collections.<AnnotationNode>emptyList())),
                factory.makeListNode(
                        Collections.singletonList(
                                factory.makeVariableDeclaratorNode(
                                        factory.makeUnparameterizedTypeNode(
                                                factory.makeSimpleNameNode(
                                                        factory.makeIdentifierNode("BlockStatementMetaprogramAnchorNode"),
                                                        NameCategory.TYPE)),
                                        factory.makeIdentifierNode(myVarName),
                                        factory.makeMethodInvocationByExpressionNode(
                                                factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                                                factory.makeIdentifierNode("makeBlockStatementMetaprogramAnchorNode"),
                                                factory.makeListNode(
                                                        Arrays.<ExpressionNode>asList(
                                                                factory.makeFieldAccessByNameNode(factory.makeSimpleNameNode(factory.makeIdentifierNode(
                                                                        liftMetaprogramVarName),NameCategory.EXPRESSION))
                                                                )),
                                                factory.makeListNode(Collections.<TypeNode>emptyList()))
            )))));

        return myVarName;
    }

    @Override
    public String executeInterfaceModifiersNode(InterfaceModifiersNode node, Pair<ExpressionNode,List<BlockStatementNode>> p)
    {
        ExpressionNode factoryNode = p.getFirst();
        List<BlockStatementNode> statements = p.getSecond();

        AccessModifier liftAccessValue = 
                node.getAccess();
        boolean liftStaticFlagValue = 
                node.getStaticFlag();
        boolean liftStrictfpFlagValue = 
                node.getStrictfpFlag();
        String liftAnnotationsVarName = 
                node.getAnnotations().executeOperation(this,p);

        String myVarName = getUniqueName();
        statements.add(
                factory.makeVariableDeclarationNode(
                        factory.makeVariableModifiersNode(
                                false,
                                factory.makeListNode(Collections.<AnnotationNode>emptyList())),
                factory.makeListNode(
                        Collections.singletonList(
                                factory.makeVariableDeclaratorNode(
                                        factory.makeUnparameterizedTypeNode(
                                                factory.makeSimpleNameNode(
                                                        factory.makeIdentifierNode("InterfaceModifiersNode"),
                                                        NameCategory.TYPE)),
                                        factory.makeIdentifierNode(myVarName),
                                        factory.makeMethodInvocationByExpressionNode(
                                                factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                                                factory.makeIdentifierNode("makeInterfaceModifiersNode"),
                                                factory.makeListNode(
                                                        Arrays.<ExpressionNode>asList(
                                                                expressionizeAccessModifier(liftAccessValue),
                                                                expressionizeBoolean(liftStaticFlagValue),
                                                                expressionizeBoolean(liftStrictfpFlagValue),
                                                                factory.makeFieldAccessByNameNode(factory.makeSimpleNameNode(factory.makeIdentifierNode(
                                                                        liftAnnotationsVarName),NameCategory.EXPRESSION))
                                                                )),
                                                factory.makeListNode(Collections.<TypeNode>emptyList()))
            )))));

        return myVarName;
    }

    @Override
    public String executeSuperclassConstructorInvocationNode(SuperclassConstructorInvocationNode node, Pair<ExpressionNode,List<BlockStatementNode>> p)
    {
        ExpressionNode factoryNode = p.getFirst();
        List<BlockStatementNode> statements = p.getSecond();

        String liftQualifyingExpressionVarName = 
                node.getQualifyingExpression().executeOperation(this,p);
        String liftArgumentsVarName = 
                node.getArguments().executeOperation(this,p);
        String liftTypeArgumentsVarName = 
                node.getTypeArguments().executeOperation(this,p);

        String myVarName = getUniqueName();
        statements.add(
                factory.makeVariableDeclarationNode(
                        factory.makeVariableModifiersNode(
                                false,
                                factory.makeListNode(Collections.<AnnotationNode>emptyList())),
                factory.makeListNode(
                        Collections.singletonList(
                                factory.makeVariableDeclaratorNode(
                                        factory.makeUnparameterizedTypeNode(
                                                factory.makeSimpleNameNode(
                                                        factory.makeIdentifierNode("SuperclassConstructorInvocationNode"),
                                                        NameCategory.TYPE)),
                                        factory.makeIdentifierNode(myVarName),
                                        factory.makeMethodInvocationByExpressionNode(
                                                factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                                                factory.makeIdentifierNode("makeSuperclassConstructorInvocationNode"),
                                                factory.makeListNode(
                                                        Arrays.<ExpressionNode>asList(
                                                                factory.makeFieldAccessByNameNode(factory.makeSimpleNameNode(factory.makeIdentifierNode(
                                                                        liftQualifyingExpressionVarName),NameCategory.EXPRESSION)),
                                                                factory.makeFieldAccessByNameNode(factory.makeSimpleNameNode(factory.makeIdentifierNode(
                                                                        liftArgumentsVarName),NameCategory.EXPRESSION)),
                                                                factory.makeFieldAccessByNameNode(factory.makeSimpleNameNode(factory.makeIdentifierNode(
                                                                        liftTypeArgumentsVarName),NameCategory.EXPRESSION))
                                                                )),
                                                factory.makeListNode(Collections.<TypeNode>emptyList()))
            )))));

        return myVarName;
    }

    @Override
    public String executePrimitiveTypeNode(PrimitiveTypeNode node, Pair<ExpressionNode,List<BlockStatementNode>> p)
    {
        ExpressionNode factoryNode = p.getFirst();
        List<BlockStatementNode> statements = p.getSecond();

        PrimitiveType liftPrimitiveTypeValue = 
                node.getPrimitiveType();

        String myVarName = getUniqueName();
        statements.add(
                factory.makeVariableDeclarationNode(
                        factory.makeVariableModifiersNode(
                                false,
                                factory.makeListNode(Collections.<AnnotationNode>emptyList())),
                factory.makeListNode(
                        Collections.singletonList(
                                factory.makeVariableDeclaratorNode(
                                        factory.makeUnparameterizedTypeNode(
                                                factory.makeSimpleNameNode(
                                                        factory.makeIdentifierNode("PrimitiveTypeNode"),
                                                        NameCategory.TYPE)),
                                        factory.makeIdentifierNode(myVarName),
                                        factory.makeMethodInvocationByExpressionNode(
                                                factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                                                factory.makeIdentifierNode("makePrimitiveTypeNode"),
                                                factory.makeListNode(
                                                        Arrays.<ExpressionNode>asList(
                                                                expressionizePrimitiveType(liftPrimitiveTypeValue)
                                                                )),
                                                factory.makeListNode(Collections.<TypeNode>emptyList()))
            )))));

        return myVarName;
    }

    @Override
    public String executeMetaprogramNode(MetaprogramNode node, Pair<ExpressionNode,List<BlockStatementNode>> p)
    {
        ExpressionNode factoryNode = p.getFirst();
        List<BlockStatementNode> statements = p.getSecond();

        String liftBodyVarName = 
                node.getBody().executeOperation(this,p);

        String myVarName = getUniqueName();
        statements.add(
                factory.makeVariableDeclarationNode(
                        factory.makeVariableModifiersNode(
                                false,
                                factory.makeListNode(Collections.<AnnotationNode>emptyList())),
                factory.makeListNode(
                        Collections.singletonList(
                                factory.makeVariableDeclaratorNode(
                                        factory.makeUnparameterizedTypeNode(
                                                factory.makeSimpleNameNode(
                                                        factory.makeIdentifierNode("MetaprogramNode"),
                                                        NameCategory.TYPE)),
                                        factory.makeIdentifierNode(myVarName),
                                        factory.makeMethodInvocationByExpressionNode(
                                                factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                                                factory.makeIdentifierNode("makeMetaprogramNode"),
                                                factory.makeListNode(
                                                        Arrays.<ExpressionNode>asList(
                                                                factory.makeFieldAccessByNameNode(factory.makeSimpleNameNode(factory.makeIdentifierNode(
                                                                        liftBodyVarName),NameCategory.EXPRESSION))
                                                                )),
                                                factory.makeListNode(Collections.<TypeNode>emptyList()))
            )))));

        return myVarName;
    }

    @Override
    public String executeInitializerDeclarationNode(InitializerDeclarationNode node, Pair<ExpressionNode,List<BlockStatementNode>> p)
    {
        ExpressionNode factoryNode = p.getFirst();
        List<BlockStatementNode> statements = p.getSecond();

        boolean liftStaticInitializerValue = 
                node.getStaticInitializer();
        String liftBodyVarName = 
                node.getBody().executeOperation(this,p);

        String myVarName = getUniqueName();
        statements.add(
                factory.makeVariableDeclarationNode(
                        factory.makeVariableModifiersNode(
                                false,
                                factory.makeListNode(Collections.<AnnotationNode>emptyList())),
                factory.makeListNode(
                        Collections.singletonList(
                                factory.makeVariableDeclaratorNode(
                                        factory.makeUnparameterizedTypeNode(
                                                factory.makeSimpleNameNode(
                                                        factory.makeIdentifierNode("InitializerDeclarationNode"),
                                                        NameCategory.TYPE)),
                                        factory.makeIdentifierNode(myVarName),
                                        factory.makeMethodInvocationByExpressionNode(
                                                factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                                                factory.makeIdentifierNode("makeInitializerDeclarationNode"),
                                                factory.makeListNode(
                                                        Arrays.<ExpressionNode>asList(
                                                                expressionizeBoolean(liftStaticInitializerValue),
                                                                factory.makeFieldAccessByNameNode(factory.makeSimpleNameNode(factory.makeIdentifierNode(
                                                                        liftBodyVarName),NameCategory.EXPRESSION))
                                                                )),
                                                factory.makeListNode(Collections.<TypeNode>emptyList()))
            )))));

        return myVarName;
    }

    @Override
    public String executeEnumBodyNode(EnumBodyNode node, Pair<ExpressionNode,List<BlockStatementNode>> p)
    {
        ExpressionNode factoryNode = p.getFirst();
        List<BlockStatementNode> statements = p.getSecond();

        String liftConstantsVarName = 
                node.getConstants().executeOperation(this,p);
        String liftMembersVarName = 
                node.getMembers().executeOperation(this,p);

        String myVarName = getUniqueName();
        statements.add(
                factory.makeVariableDeclarationNode(
                        factory.makeVariableModifiersNode(
                                false,
                                factory.makeListNode(Collections.<AnnotationNode>emptyList())),
                factory.makeListNode(
                        Collections.singletonList(
                                factory.makeVariableDeclaratorNode(
                                        factory.makeUnparameterizedTypeNode(
                                                factory.makeSimpleNameNode(
                                                        factory.makeIdentifierNode("EnumBodyNode"),
                                                        NameCategory.TYPE)),
                                        factory.makeIdentifierNode(myVarName),
                                        factory.makeMethodInvocationByExpressionNode(
                                                factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                                                factory.makeIdentifierNode("makeEnumBodyNode"),
                                                factory.makeListNode(
                                                        Arrays.<ExpressionNode>asList(
                                                                factory.makeFieldAccessByNameNode(factory.makeSimpleNameNode(factory.makeIdentifierNode(
                                                                        liftConstantsVarName),NameCategory.EXPRESSION)),
                                                                factory.makeFieldAccessByNameNode(factory.makeSimpleNameNode(factory.makeIdentifierNode(
                                                                        liftMembersVarName),NameCategory.EXPRESSION))
                                                                )),
                                                factory.makeListNode(Collections.<TypeNode>emptyList()))
            )))));

        return myVarName;
    }

    @Override
    public String executeTryNode(TryNode node, Pair<ExpressionNode,List<BlockStatementNode>> p)
    {
        ExpressionNode factoryNode = p.getFirst();
        List<BlockStatementNode> statements = p.getSecond();

        String liftBlockVarName = 
                node.getBlock().executeOperation(this,p);
        String liftCatchesVarName = 
                node.getCatches().executeOperation(this,p);
        String liftFinallyBlockVarName = 
                node.getFinallyBlock().executeOperation(this,p);

        String myVarName = getUniqueName();
        statements.add(
                factory.makeVariableDeclarationNode(
                        factory.makeVariableModifiersNode(
                                false,
                                factory.makeListNode(Collections.<AnnotationNode>emptyList())),
                factory.makeListNode(
                        Collections.singletonList(
                                factory.makeVariableDeclaratorNode(
                                        factory.makeUnparameterizedTypeNode(
                                                factory.makeSimpleNameNode(
                                                        factory.makeIdentifierNode("TryNode"),
                                                        NameCategory.TYPE)),
                                        factory.makeIdentifierNode(myVarName),
                                        factory.makeMethodInvocationByExpressionNode(
                                                factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                                                factory.makeIdentifierNode("makeTryNode"),
                                                factory.makeListNode(
                                                        Arrays.<ExpressionNode>asList(
                                                                factory.makeFieldAccessByNameNode(factory.makeSimpleNameNode(factory.makeIdentifierNode(
                                                                        liftBlockVarName),NameCategory.EXPRESSION)),
                                                                factory.makeFieldAccessByNameNode(factory.makeSimpleNameNode(factory.makeIdentifierNode(
                                                                        liftCatchesVarName),NameCategory.EXPRESSION)),
                                                                factory.makeFieldAccessByNameNode(factory.makeSimpleNameNode(factory.makeIdentifierNode(
                                                                        liftFinallyBlockVarName),NameCategory.EXPRESSION))
                                                                )),
                                                factory.makeListNode(Collections.<TypeNode>emptyList()))
            )))));

        return myVarName;
    }

    @Override
    public String executeThisNode(ThisNode node, Pair<ExpressionNode,List<BlockStatementNode>> p)
    {
        ExpressionNode factoryNode = p.getFirst();
        List<BlockStatementNode> statements = p.getSecond();

        String liftTypeVarName = 
                node.getType().executeOperation(this,p);

        String myVarName = getUniqueName();
        statements.add(
                factory.makeVariableDeclarationNode(
                        factory.makeVariableModifiersNode(
                                false,
                                factory.makeListNode(Collections.<AnnotationNode>emptyList())),
                factory.makeListNode(
                        Collections.singletonList(
                                factory.makeVariableDeclaratorNode(
                                        factory.makeUnparameterizedTypeNode(
                                                factory.makeSimpleNameNode(
                                                        factory.makeIdentifierNode("ThisNode"),
                                                        NameCategory.TYPE)),
                                        factory.makeIdentifierNode(myVarName),
                                        factory.makeMethodInvocationByExpressionNode(
                                                factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                                                factory.makeIdentifierNode("makeThisNode"),
                                                factory.makeListNode(
                                                        Arrays.<ExpressionNode>asList(
                                                                factory.makeFieldAccessByNameNode(factory.makeSimpleNameNode(factory.makeIdentifierNode(
                                                                        liftTypeVarName),NameCategory.EXPRESSION))
                                                                )),
                                                factory.makeListNode(Collections.<TypeNode>emptyList()))
            )))));

        return myVarName;
    }

    @Override
    public String executeTypeDeclarationMetaprogramAnchorNode(TypeDeclarationMetaprogramAnchorNode node, Pair<ExpressionNode,List<BlockStatementNode>> p)
    {
        ExpressionNode factoryNode = p.getFirst();
        List<BlockStatementNode> statements = p.getSecond();

        String liftMetaprogramVarName = 
                node.getMetaprogram().executeOperation(this,p);

        String myVarName = getUniqueName();
        statements.add(
                factory.makeVariableDeclarationNode(
                        factory.makeVariableModifiersNode(
                                false,
                                factory.makeListNode(Collections.<AnnotationNode>emptyList())),
                factory.makeListNode(
                        Collections.singletonList(
                                factory.makeVariableDeclaratorNode(
                                        factory.makeUnparameterizedTypeNode(
                                                factory.makeSimpleNameNode(
                                                        factory.makeIdentifierNode("TypeDeclarationMetaprogramAnchorNode"),
                                                        NameCategory.TYPE)),
                                        factory.makeIdentifierNode(myVarName),
                                        factory.makeMethodInvocationByExpressionNode(
                                                factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                                                factory.makeIdentifierNode("makeTypeDeclarationMetaprogramAnchorNode"),
                                                factory.makeListNode(
                                                        Arrays.<ExpressionNode>asList(
                                                                factory.makeFieldAccessByNameNode(factory.makeSimpleNameNode(factory.makeIdentifierNode(
                                                                        liftMetaprogramVarName),NameCategory.EXPRESSION))
                                                                )),
                                                factory.makeListNode(Collections.<TypeNode>emptyList()))
            )))));

        return myVarName;
    }

    @Override
    public String executeEnumDeclarationNode(EnumDeclarationNode node, Pair<ExpressionNode,List<BlockStatementNode>> p)
    {
        ExpressionNode factoryNode = p.getFirst();
        List<BlockStatementNode> statements = p.getSecond();

        String liftModifiersVarName = 
                node.getModifiers().executeOperation(this,p);
        String liftImplementsClauseVarName = 
                node.getImplementsClause().executeOperation(this,p);
        String liftBodyVarName = 
                node.getBody().executeOperation(this,p);
        String liftIdentifierVarName = 
                node.getIdentifier().executeOperation(this,p);
        String liftJavadocVarName = 
                node.getJavadoc().executeOperation(this,p);

        String myVarName = getUniqueName();
        statements.add(
                factory.makeVariableDeclarationNode(
                        factory.makeVariableModifiersNode(
                                false,
                                factory.makeListNode(Collections.<AnnotationNode>emptyList())),
                factory.makeListNode(
                        Collections.singletonList(
                                factory.makeVariableDeclaratorNode(
                                        factory.makeUnparameterizedTypeNode(
                                                factory.makeSimpleNameNode(
                                                        factory.makeIdentifierNode("EnumDeclarationNode"),
                                                        NameCategory.TYPE)),
                                        factory.makeIdentifierNode(myVarName),
                                        factory.makeMethodInvocationByExpressionNode(
                                                factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                                                factory.makeIdentifierNode("makeEnumDeclarationNode"),
                                                factory.makeListNode(
                                                        Arrays.<ExpressionNode>asList(
                                                                factory.makeFieldAccessByNameNode(factory.makeSimpleNameNode(factory.makeIdentifierNode(
                                                                        liftModifiersVarName),NameCategory.EXPRESSION)),
                                                                factory.makeFieldAccessByNameNode(factory.makeSimpleNameNode(factory.makeIdentifierNode(
                                                                        liftImplementsClauseVarName),NameCategory.EXPRESSION)),
                                                                factory.makeFieldAccessByNameNode(factory.makeSimpleNameNode(factory.makeIdentifierNode(
                                                                        liftBodyVarName),NameCategory.EXPRESSION)),
                                                                factory.makeFieldAccessByNameNode(factory.makeSimpleNameNode(factory.makeIdentifierNode(
                                                                        liftIdentifierVarName),NameCategory.EXPRESSION)),
                                                                factory.makeFieldAccessByNameNode(factory.makeSimpleNameNode(factory.makeIdentifierNode(
                                                                        liftJavadocVarName),NameCategory.EXPRESSION))
                                                                )),
                                                factory.makeListNode(Collections.<TypeNode>emptyList()))
            )))));

        return myVarName;
    }

    @Override
    public String executeVoidTypeNode(VoidTypeNode node, Pair<ExpressionNode,List<BlockStatementNode>> p)
    {
        ExpressionNode factoryNode = p.getFirst();
        List<BlockStatementNode> statements = p.getSecond();


        String myVarName = getUniqueName();
        statements.add(
                factory.makeVariableDeclarationNode(
                        factory.makeVariableModifiersNode(
                                false,
                                factory.makeListNode(Collections.<AnnotationNode>emptyList())),
                factory.makeListNode(
                        Collections.singletonList(
                                factory.makeVariableDeclaratorNode(
                                        factory.makeUnparameterizedTypeNode(
                                                factory.makeSimpleNameNode(
                                                        factory.makeIdentifierNode("VoidTypeNode"),
                                                        NameCategory.TYPE)),
                                        factory.makeIdentifierNode(myVarName),
                                        factory.makeMethodInvocationByExpressionNode(
                                                factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                                                factory.makeIdentifierNode("makeVoidTypeNode"),
                                                factory.makeListNode(
                                                        Arrays.<ExpressionNode>asList(
                                                                )),
                                                factory.makeListNode(Collections.<TypeNode>emptyList()))
            )))));

        return myVarName;
    }

    @Override
    public String executeVariableDeclarationNode(VariableDeclarationNode node, Pair<ExpressionNode,List<BlockStatementNode>> p)
    {
        ExpressionNode factoryNode = p.getFirst();
        List<BlockStatementNode> statements = p.getSecond();

        String liftModifiersVarName = 
                node.getModifiers().executeOperation(this,p);
        String liftDeclaratorsVarName = 
                node.getDeclarators().executeOperation(this,p);

        String myVarName = getUniqueName();
        statements.add(
                factory.makeVariableDeclarationNode(
                        factory.makeVariableModifiersNode(
                                false,
                                factory.makeListNode(Collections.<AnnotationNode>emptyList())),
                factory.makeListNode(
                        Collections.singletonList(
                                factory.makeVariableDeclaratorNode(
                                        factory.makeUnparameterizedTypeNode(
                                                factory.makeSimpleNameNode(
                                                        factory.makeIdentifierNode("VariableDeclarationNode"),
                                                        NameCategory.TYPE)),
                                        factory.makeIdentifierNode(myVarName),
                                        factory.makeMethodInvocationByExpressionNode(
                                                factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                                                factory.makeIdentifierNode("makeVariableDeclarationNode"),
                                                factory.makeListNode(
                                                        Arrays.<ExpressionNode>asList(
                                                                factory.makeFieldAccessByNameNode(factory.makeSimpleNameNode(factory.makeIdentifierNode(
                                                                        liftModifiersVarName),NameCategory.EXPRESSION)),
                                                                factory.makeFieldAccessByNameNode(factory.makeSimpleNameNode(factory.makeIdentifierNode(
                                                                        liftDeclaratorsVarName),NameCategory.EXPRESSION))
                                                                )),
                                                factory.makeListNode(Collections.<TypeNode>emptyList()))
            )))));

        return myVarName;
    }

    @Override
    public String executeAnnotationBodyNode(AnnotationBodyNode node, Pair<ExpressionNode,List<BlockStatementNode>> p)
    {
        ExpressionNode factoryNode = p.getFirst();
        List<BlockStatementNode> statements = p.getSecond();

        String liftMembersVarName = 
                node.getMembers().executeOperation(this,p);

        String myVarName = getUniqueName();
        statements.add(
                factory.makeVariableDeclarationNode(
                        factory.makeVariableModifiersNode(
                                false,
                                factory.makeListNode(Collections.<AnnotationNode>emptyList())),
                factory.makeListNode(
                        Collections.singletonList(
                                factory.makeVariableDeclaratorNode(
                                        factory.makeUnparameterizedTypeNode(
                                                factory.makeSimpleNameNode(
                                                        factory.makeIdentifierNode("AnnotationBodyNode"),
                                                        NameCategory.TYPE)),
                                        factory.makeIdentifierNode(myVarName),
                                        factory.makeMethodInvocationByExpressionNode(
                                                factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                                                factory.makeIdentifierNode("makeAnnotationBodyNode"),
                                                factory.makeListNode(
                                                        Arrays.<ExpressionNode>asList(
                                                                factory.makeFieldAccessByNameNode(factory.makeSimpleNameNode(factory.makeIdentifierNode(
                                                                        liftMembersVarName),NameCategory.EXPRESSION))
                                                                )),
                                                factory.makeListNode(Collections.<TypeNode>emptyList()))
            )))));

        return myVarName;
    }

    @Override
    public String executeUnparameterizedTypeNode(UnparameterizedTypeNode node, Pair<ExpressionNode,List<BlockStatementNode>> p)
    {
        ExpressionNode factoryNode = p.getFirst();
        List<BlockStatementNode> statements = p.getSecond();

        String liftNameVarName = 
                node.getName().executeOperation(this,p);

        String myVarName = getUniqueName();
        statements.add(
                factory.makeVariableDeclarationNode(
                        factory.makeVariableModifiersNode(
                                false,
                                factory.makeListNode(Collections.<AnnotationNode>emptyList())),
                factory.makeListNode(
                        Collections.singletonList(
                                factory.makeVariableDeclaratorNode(
                                        factory.makeUnparameterizedTypeNode(
                                                factory.makeSimpleNameNode(
                                                        factory.makeIdentifierNode("UnparameterizedTypeNode"),
                                                        NameCategory.TYPE)),
                                        factory.makeIdentifierNode(myVarName),
                                        factory.makeMethodInvocationByExpressionNode(
                                                factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                                                factory.makeIdentifierNode("makeUnparameterizedTypeNode"),
                                                factory.makeListNode(
                                                        Arrays.<ExpressionNode>asList(
                                                                factory.makeFieldAccessByNameNode(factory.makeSimpleNameNode(factory.makeIdentifierNode(
                                                                        liftNameVarName),NameCategory.EXPRESSION))
                                                                )),
                                                factory.makeListNode(Collections.<TypeNode>emptyList()))
            )))));

        return myVarName;
    }

    @Override
    public String executeVariableDeclaratorNode(VariableDeclaratorNode node, Pair<ExpressionNode,List<BlockStatementNode>> p)
    {
        ExpressionNode factoryNode = p.getFirst();
        List<BlockStatementNode> statements = p.getSecond();

        String liftTypeVarName = 
                node.getType().executeOperation(this,p);
        String liftNameVarName = 
                node.getName().executeOperation(this,p);
        String liftInitializerVarName = 
                node.getInitializer().executeOperation(this,p);

        String myVarName = getUniqueName();
        statements.add(
                factory.makeVariableDeclarationNode(
                        factory.makeVariableModifiersNode(
                                false,
                                factory.makeListNode(Collections.<AnnotationNode>emptyList())),
                factory.makeListNode(
                        Collections.singletonList(
                                factory.makeVariableDeclaratorNode(
                                        factory.makeUnparameterizedTypeNode(
                                                factory.makeSimpleNameNode(
                                                        factory.makeIdentifierNode("VariableDeclaratorNode"),
                                                        NameCategory.TYPE)),
                                        factory.makeIdentifierNode(myVarName),
                                        factory.makeMethodInvocationByExpressionNode(
                                                factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                                                factory.makeIdentifierNode("makeVariableDeclaratorNode"),
                                                factory.makeListNode(
                                                        Arrays.<ExpressionNode>asList(
                                                                factory.makeFieldAccessByNameNode(factory.makeSimpleNameNode(factory.makeIdentifierNode(
                                                                        liftTypeVarName),NameCategory.EXPRESSION)),
                                                                factory.makeFieldAccessByNameNode(factory.makeSimpleNameNode(factory.makeIdentifierNode(
                                                                        liftNameVarName),NameCategory.EXPRESSION)),
                                                                factory.makeFieldAccessByNameNode(factory.makeSimpleNameNode(factory.makeIdentifierNode(
                                                                        liftInitializerVarName),NameCategory.EXPRESSION))
                                                                )),
                                                factory.makeListNode(Collections.<TypeNode>emptyList()))
            )))));

        return myVarName;
    }

    @Override
    public String executeAnnotationModifiersNode(AnnotationModifiersNode node, Pair<ExpressionNode,List<BlockStatementNode>> p)
    {
        ExpressionNode factoryNode = p.getFirst();
        List<BlockStatementNode> statements = p.getSecond();

        AccessModifier liftAccessValue = 
                node.getAccess();
        boolean liftStaticFlagValue = 
                node.getStaticFlag();
        boolean liftStrictfpFlagValue = 
                node.getStrictfpFlag();
        String liftAnnotationsVarName = 
                node.getAnnotations().executeOperation(this,p);

        String myVarName = getUniqueName();
        statements.add(
                factory.makeVariableDeclarationNode(
                        factory.makeVariableModifiersNode(
                                false,
                                factory.makeListNode(Collections.<AnnotationNode>emptyList())),
                factory.makeListNode(
                        Collections.singletonList(
                                factory.makeVariableDeclaratorNode(
                                        factory.makeUnparameterizedTypeNode(
                                                factory.makeSimpleNameNode(
                                                        factory.makeIdentifierNode("AnnotationModifiersNode"),
                                                        NameCategory.TYPE)),
                                        factory.makeIdentifierNode(myVarName),
                                        factory.makeMethodInvocationByExpressionNode(
                                                factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                                                factory.makeIdentifierNode("makeAnnotationModifiersNode"),
                                                factory.makeListNode(
                                                        Arrays.<ExpressionNode>asList(
                                                                expressionizeAccessModifier(liftAccessValue),
                                                                expressionizeBoolean(liftStaticFlagValue),
                                                                expressionizeBoolean(liftStrictfpFlagValue),
                                                                factory.makeFieldAccessByNameNode(factory.makeSimpleNameNode(factory.makeIdentifierNode(
                                                                        liftAnnotationsVarName),NameCategory.EXPRESSION))
                                                                )),
                                                factory.makeListNode(Collections.<TypeNode>emptyList()))
            )))));

        return myVarName;
    }

    @Override
    public String executeFieldAccessByExpressionNode(FieldAccessByExpressionNode node, Pair<ExpressionNode,List<BlockStatementNode>> p)
    {
        ExpressionNode factoryNode = p.getFirst();
        List<BlockStatementNode> statements = p.getSecond();

        String liftExpressionVarName = 
                node.getExpression().executeOperation(this,p);
        String liftIdentifierVarName = 
                node.getIdentifier().executeOperation(this,p);

        String myVarName = getUniqueName();
        statements.add(
                factory.makeVariableDeclarationNode(
                        factory.makeVariableModifiersNode(
                                false,
                                factory.makeListNode(Collections.<AnnotationNode>emptyList())),
                factory.makeListNode(
                        Collections.singletonList(
                                factory.makeVariableDeclaratorNode(
                                        factory.makeUnparameterizedTypeNode(
                                                factory.makeSimpleNameNode(
                                                        factory.makeIdentifierNode("FieldAccessByExpressionNode"),
                                                        NameCategory.TYPE)),
                                        factory.makeIdentifierNode(myVarName),
                                        factory.makeMethodInvocationByExpressionNode(
                                                factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                                                factory.makeIdentifierNode("makeFieldAccessByExpressionNode"),
                                                factory.makeListNode(
                                                        Arrays.<ExpressionNode>asList(
                                                                factory.makeFieldAccessByNameNode(factory.makeSimpleNameNode(factory.makeIdentifierNode(
                                                                        liftExpressionVarName),NameCategory.EXPRESSION)),
                                                                factory.makeFieldAccessByNameNode(factory.makeSimpleNameNode(factory.makeIdentifierNode(
                                                                        liftIdentifierVarName),NameCategory.EXPRESSION))
                                                                )),
                                                factory.makeListNode(Collections.<TypeNode>emptyList()))
            )))));

        return myVarName;
    }

    @Override
    public String executeSuperFieldAccessNode(SuperFieldAccessNode node, Pair<ExpressionNode,List<BlockStatementNode>> p)
    {
        ExpressionNode factoryNode = p.getFirst();
        List<BlockStatementNode> statements = p.getSecond();

        String liftTypeVarName = 
                node.getType().executeOperation(this,p);
        String liftIdentifierVarName = 
                node.getIdentifier().executeOperation(this,p);

        String myVarName = getUniqueName();
        statements.add(
                factory.makeVariableDeclarationNode(
                        factory.makeVariableModifiersNode(
                                false,
                                factory.makeListNode(Collections.<AnnotationNode>emptyList())),
                factory.makeListNode(
                        Collections.singletonList(
                                factory.makeVariableDeclaratorNode(
                                        factory.makeUnparameterizedTypeNode(
                                                factory.makeSimpleNameNode(
                                                        factory.makeIdentifierNode("SuperFieldAccessNode"),
                                                        NameCategory.TYPE)),
                                        factory.makeIdentifierNode(myVarName),
                                        factory.makeMethodInvocationByExpressionNode(
                                                factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                                                factory.makeIdentifierNode("makeSuperFieldAccessNode"),
                                                factory.makeListNode(
                                                        Arrays.<ExpressionNode>asList(
                                                                factory.makeFieldAccessByNameNode(factory.makeSimpleNameNode(factory.makeIdentifierNode(
                                                                        liftTypeVarName),NameCategory.EXPRESSION)),
                                                                factory.makeFieldAccessByNameNode(factory.makeSimpleNameNode(factory.makeIdentifierNode(
                                                                        liftIdentifierVarName),NameCategory.EXPRESSION))
                                                                )),
                                                factory.makeListNode(Collections.<TypeNode>emptyList()))
            )))));

        return myVarName;
    }

    @Override
    public String executeThrowNode(ThrowNode node, Pair<ExpressionNode,List<BlockStatementNode>> p)
    {
        ExpressionNode factoryNode = p.getFirst();
        List<BlockStatementNode> statements = p.getSecond();

        String liftExpressionVarName = 
                node.getExpression().executeOperation(this,p);

        String myVarName = getUniqueName();
        statements.add(
                factory.makeVariableDeclarationNode(
                        factory.makeVariableModifiersNode(
                                false,
                                factory.makeListNode(Collections.<AnnotationNode>emptyList())),
                factory.makeListNode(
                        Collections.singletonList(
                                factory.makeVariableDeclaratorNode(
                                        factory.makeUnparameterizedTypeNode(
                                                factory.makeSimpleNameNode(
                                                        factory.makeIdentifierNode("ThrowNode"),
                                                        NameCategory.TYPE)),
                                        factory.makeIdentifierNode(myVarName),
                                        factory.makeMethodInvocationByExpressionNode(
                                                factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                                                factory.makeIdentifierNode("makeThrowNode"),
                                                factory.makeListNode(
                                                        Arrays.<ExpressionNode>asList(
                                                                factory.makeFieldAccessByNameNode(factory.makeSimpleNameNode(factory.makeIdentifierNode(
                                                                        liftExpressionVarName),NameCategory.EXPRESSION))
                                                                )),
                                                factory.makeListNode(Collections.<TypeNode>emptyList()))
            )))));

        return myVarName;
    }

    @Override
    public String executeEnumModifiersNode(EnumModifiersNode node, Pair<ExpressionNode,List<BlockStatementNode>> p)
    {
        ExpressionNode factoryNode = p.getFirst();
        List<BlockStatementNode> statements = p.getSecond();

        AccessModifier liftAccessValue = 
                node.getAccess();
        boolean liftStrictfpFlagValue = 
                node.getStrictfpFlag();
        String liftAnnotationsVarName = 
                node.getAnnotations().executeOperation(this,p);

        String myVarName = getUniqueName();
        statements.add(
                factory.makeVariableDeclarationNode(
                        factory.makeVariableModifiersNode(
                                false,
                                factory.makeListNode(Collections.<AnnotationNode>emptyList())),
                factory.makeListNode(
                        Collections.singletonList(
                                factory.makeVariableDeclaratorNode(
                                        factory.makeUnparameterizedTypeNode(
                                                factory.makeSimpleNameNode(
                                                        factory.makeIdentifierNode("EnumModifiersNode"),
                                                        NameCategory.TYPE)),
                                        factory.makeIdentifierNode(myVarName),
                                        factory.makeMethodInvocationByExpressionNode(
                                                factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                                                factory.makeIdentifierNode("makeEnumModifiersNode"),
                                                factory.makeListNode(
                                                        Arrays.<ExpressionNode>asList(
                                                                expressionizeAccessModifier(liftAccessValue),
                                                                expressionizeBoolean(liftStrictfpFlagValue),
                                                                factory.makeFieldAccessByNameNode(factory.makeSimpleNameNode(factory.makeIdentifierNode(
                                                                        liftAnnotationsVarName),NameCategory.EXPRESSION))
                                                                )),
                                                factory.makeListNode(Collections.<TypeNode>emptyList()))
            )))));

        return myVarName;
    }

    @Override
    public String executeCatchNode(CatchNode node, Pair<ExpressionNode,List<BlockStatementNode>> p)
    {
        ExpressionNode factoryNode = p.getFirst();
        List<BlockStatementNode> statements = p.getSecond();

        String liftBlockVarName = 
                node.getBlock().executeOperation(this,p);
        String liftParameterVarName = 
                node.getParameter().executeOperation(this,p);

        String myVarName = getUniqueName();
        statements.add(
                factory.makeVariableDeclarationNode(
                        factory.makeVariableModifiersNode(
                                false,
                                factory.makeListNode(Collections.<AnnotationNode>emptyList())),
                factory.makeListNode(
                        Collections.singletonList(
                                factory.makeVariableDeclaratorNode(
                                        factory.makeUnparameterizedTypeNode(
                                                factory.makeSimpleNameNode(
                                                        factory.makeIdentifierNode("CatchNode"),
                                                        NameCategory.TYPE)),
                                        factory.makeIdentifierNode(myVarName),
                                        factory.makeMethodInvocationByExpressionNode(
                                                factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                                                factory.makeIdentifierNode("makeCatchNode"),
                                                factory.makeListNode(
                                                        Arrays.<ExpressionNode>asList(
                                                                factory.makeFieldAccessByNameNode(factory.makeSimpleNameNode(factory.makeIdentifierNode(
                                                                        liftBlockVarName),NameCategory.EXPRESSION)),
                                                                factory.makeFieldAccessByNameNode(factory.makeSimpleNameNode(factory.makeIdentifierNode(
                                                                        liftParameterVarName),NameCategory.EXPRESSION))
                                                                )),
                                                factory.makeListNode(Collections.<TypeNode>emptyList()))
            )))));

        return myVarName;
    }

    @Override
    public String executeVoidTypeDeclarationNode(VoidTypeDeclarationNode node, Pair<ExpressionNode,List<BlockStatementNode>> p)
    {
        ExpressionNode factoryNode = p.getFirst();
        List<BlockStatementNode> statements = p.getSecond();


        String myVarName = getUniqueName();
        statements.add(
                factory.makeVariableDeclarationNode(
                        factory.makeVariableModifiersNode(
                                false,
                                factory.makeListNode(Collections.<AnnotationNode>emptyList())),
                factory.makeListNode(
                        Collections.singletonList(
                                factory.makeVariableDeclaratorNode(
                                        factory.makeUnparameterizedTypeNode(
                                                factory.makeSimpleNameNode(
                                                        factory.makeIdentifierNode("VoidTypeDeclarationNode"),
                                                        NameCategory.TYPE)),
                                        factory.makeIdentifierNode(myVarName),
                                        factory.makeMethodInvocationByExpressionNode(
                                                factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                                                factory.makeIdentifierNode("makeVoidTypeDeclarationNode"),
                                                factory.makeListNode(
                                                        Arrays.<ExpressionNode>asList(
                                                                )),
                                                factory.makeListNode(Collections.<TypeNode>emptyList()))
            )))));

        return myVarName;
    }

    @Override
    public String executeNormalAnnotationNode(NormalAnnotationNode node, Pair<ExpressionNode,List<BlockStatementNode>> p)
    {
        ExpressionNode factoryNode = p.getFirst();
        List<BlockStatementNode> statements = p.getSecond();

        String liftArgumentsVarName = 
                node.getArguments().executeOperation(this,p);
        String liftAnnotationTypeVarName = 
                node.getAnnotationType().executeOperation(this,p);

        String myVarName = getUniqueName();
        statements.add(
                factory.makeVariableDeclarationNode(
                        factory.makeVariableModifiersNode(
                                false,
                                factory.makeListNode(Collections.<AnnotationNode>emptyList())),
                factory.makeListNode(
                        Collections.singletonList(
                                factory.makeVariableDeclaratorNode(
                                        factory.makeUnparameterizedTypeNode(
                                                factory.makeSimpleNameNode(
                                                        factory.makeIdentifierNode("NormalAnnotationNode"),
                                                        NameCategory.TYPE)),
                                        factory.makeIdentifierNode(myVarName),
                                        factory.makeMethodInvocationByExpressionNode(
                                                factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                                                factory.makeIdentifierNode("makeNormalAnnotationNode"),
                                                factory.makeListNode(
                                                        Arrays.<ExpressionNode>asList(
                                                                factory.makeFieldAccessByNameNode(factory.makeSimpleNameNode(factory.makeIdentifierNode(
                                                                        liftArgumentsVarName),NameCategory.EXPRESSION)),
                                                                factory.makeFieldAccessByNameNode(factory.makeSimpleNameNode(factory.makeIdentifierNode(
                                                                        liftAnnotationTypeVarName),NameCategory.EXPRESSION))
                                                                )),
                                                factory.makeListNode(Collections.<TypeNode>emptyList()))
            )))));

        return myVarName;
    }

    @Override
    public String executeDoWhileLoopNode(DoWhileLoopNode node, Pair<ExpressionNode,List<BlockStatementNode>> p)
    {
        ExpressionNode factoryNode = p.getFirst();
        List<BlockStatementNode> statements = p.getSecond();

        String liftConditionVarName = 
                node.getCondition().executeOperation(this,p);
        String liftStatementVarName = 
                node.getStatement().executeOperation(this,p);

        String myVarName = getUniqueName();
        statements.add(
                factory.makeVariableDeclarationNode(
                        factory.makeVariableModifiersNode(
                                false,
                                factory.makeListNode(Collections.<AnnotationNode>emptyList())),
                factory.makeListNode(
                        Collections.singletonList(
                                factory.makeVariableDeclaratorNode(
                                        factory.makeUnparameterizedTypeNode(
                                                factory.makeSimpleNameNode(
                                                        factory.makeIdentifierNode("DoWhileLoopNode"),
                                                        NameCategory.TYPE)),
                                        factory.makeIdentifierNode(myVarName),
                                        factory.makeMethodInvocationByExpressionNode(
                                                factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                                                factory.makeIdentifierNode("makeDoWhileLoopNode"),
                                                factory.makeListNode(
                                                        Arrays.<ExpressionNode>asList(
                                                                factory.makeFieldAccessByNameNode(factory.makeSimpleNameNode(factory.makeIdentifierNode(
                                                                        liftConditionVarName),NameCategory.EXPRESSION)),
                                                                factory.makeFieldAccessByNameNode(factory.makeSimpleNameNode(factory.makeIdentifierNode(
                                                                        liftStatementVarName),NameCategory.EXPRESSION))
                                                                )),
                                                factory.makeListNode(Collections.<TypeNode>emptyList()))
            )))));

        return myVarName;
    }

    @Override
    public String executeQualifiedClassInstantiationNode(QualifiedClassInstantiationNode node, Pair<ExpressionNode,List<BlockStatementNode>> p)
    {
        ExpressionNode factoryNode = p.getFirst();
        List<BlockStatementNode> statements = p.getSecond();

        String liftEnclosingExpressionVarName = 
                node.getEnclosingExpression().executeOperation(this,p);
        String liftIdentifierVarName = 
                node.getIdentifier().executeOperation(this,p);
        String liftTypeArgumentsVarName = 
                node.getTypeArguments().executeOperation(this,p);
        String liftConstructorTypeArgumentsVarName = 
                node.getConstructorTypeArguments().executeOperation(this,p);
        String liftArgumentsVarName = 
                node.getArguments().executeOperation(this,p);
        String liftBodyVarName = 
                node.getBody().executeOperation(this,p);

        String myVarName = getUniqueName();
        statements.add(
                factory.makeVariableDeclarationNode(
                        factory.makeVariableModifiersNode(
                                false,
                                factory.makeListNode(Collections.<AnnotationNode>emptyList())),
                factory.makeListNode(
                        Collections.singletonList(
                                factory.makeVariableDeclaratorNode(
                                        factory.makeUnparameterizedTypeNode(
                                                factory.makeSimpleNameNode(
                                                        factory.makeIdentifierNode("QualifiedClassInstantiationNode"),
                                                        NameCategory.TYPE)),
                                        factory.makeIdentifierNode(myVarName),
                                        factory.makeMethodInvocationByExpressionNode(
                                                factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                                                factory.makeIdentifierNode("makeQualifiedClassInstantiationNode"),
                                                factory.makeListNode(
                                                        Arrays.<ExpressionNode>asList(
                                                                factory.makeFieldAccessByNameNode(factory.makeSimpleNameNode(factory.makeIdentifierNode(
                                                                        liftEnclosingExpressionVarName),NameCategory.EXPRESSION)),
                                                                factory.makeFieldAccessByNameNode(factory.makeSimpleNameNode(factory.makeIdentifierNode(
                                                                        liftIdentifierVarName),NameCategory.EXPRESSION)),
                                                                factory.makeFieldAccessByNameNode(factory.makeSimpleNameNode(factory.makeIdentifierNode(
                                                                        liftTypeArgumentsVarName),NameCategory.EXPRESSION)),
                                                                factory.makeFieldAccessByNameNode(factory.makeSimpleNameNode(factory.makeIdentifierNode(
                                                                        liftConstructorTypeArgumentsVarName),NameCategory.EXPRESSION)),
                                                                factory.makeFieldAccessByNameNode(factory.makeSimpleNameNode(factory.makeIdentifierNode(
                                                                        liftArgumentsVarName),NameCategory.EXPRESSION)),
                                                                factory.makeFieldAccessByNameNode(factory.makeSimpleNameNode(factory.makeIdentifierNode(
                                                                        liftBodyVarName),NameCategory.EXPRESSION))
                                                                )),
                                                factory.makeListNode(Collections.<TypeNode>emptyList()))
            )))));

        return myVarName;
    }

    @Override
    public String executeTypeCastNode(TypeCastNode node, Pair<ExpressionNode,List<BlockStatementNode>> p)
    {
        ExpressionNode factoryNode = p.getFirst();
        List<BlockStatementNode> statements = p.getSecond();

        String liftExpressionVarName = 
                node.getExpression().executeOperation(this,p);
        String liftTypeVarName = 
                node.getType().executeOperation(this,p);

        String myVarName = getUniqueName();
        statements.add(
                factory.makeVariableDeclarationNode(
                        factory.makeVariableModifiersNode(
                                false,
                                factory.makeListNode(Collections.<AnnotationNode>emptyList())),
                factory.makeListNode(
                        Collections.singletonList(
                                factory.makeVariableDeclaratorNode(
                                        factory.makeUnparameterizedTypeNode(
                                                factory.makeSimpleNameNode(
                                                        factory.makeIdentifierNode("TypeCastNode"),
                                                        NameCategory.TYPE)),
                                        factory.makeIdentifierNode(myVarName),
                                        factory.makeMethodInvocationByExpressionNode(
                                                factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                                                factory.makeIdentifierNode("makeTypeCastNode"),
                                                factory.makeListNode(
                                                        Arrays.<ExpressionNode>asList(
                                                                factory.makeFieldAccessByNameNode(factory.makeSimpleNameNode(factory.makeIdentifierNode(
                                                                        liftExpressionVarName),NameCategory.EXPRESSION)),
                                                                factory.makeFieldAccessByNameNode(factory.makeSimpleNameNode(factory.makeIdentifierNode(
                                                                        liftTypeVarName),NameCategory.EXPRESSION))
                                                                )),
                                                factory.makeListNode(Collections.<TypeNode>emptyList()))
            )))));

        return myVarName;
    }

    @Override
    public String executeLabeledStatementNode(LabeledStatementNode node, Pair<ExpressionNode,List<BlockStatementNode>> p)
    {
        ExpressionNode factoryNode = p.getFirst();
        List<BlockStatementNode> statements = p.getSecond();

        String liftLabelVarName = 
                node.getLabel().executeOperation(this,p);
        String liftStatementVarName = 
                node.getStatement().executeOperation(this,p);

        String myVarName = getUniqueName();
        statements.add(
                factory.makeVariableDeclarationNode(
                        factory.makeVariableModifiersNode(
                                false,
                                factory.makeListNode(Collections.<AnnotationNode>emptyList())),
                factory.makeListNode(
                        Collections.singletonList(
                                factory.makeVariableDeclaratorNode(
                                        factory.makeUnparameterizedTypeNode(
                                                factory.makeSimpleNameNode(
                                                        factory.makeIdentifierNode("LabeledStatementNode"),
                                                        NameCategory.TYPE)),
                                        factory.makeIdentifierNode(myVarName),
                                        factory.makeMethodInvocationByExpressionNode(
                                                factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                                                factory.makeIdentifierNode("makeLabeledStatementNode"),
                                                factory.makeListNode(
                                                        Arrays.<ExpressionNode>asList(
                                                                factory.makeFieldAccessByNameNode(factory.makeSimpleNameNode(factory.makeIdentifierNode(
                                                                        liftLabelVarName),NameCategory.EXPRESSION)),
                                                                factory.makeFieldAccessByNameNode(factory.makeSimpleNameNode(factory.makeIdentifierNode(
                                                                        liftStatementVarName),NameCategory.EXPRESSION))
                                                                )),
                                                factory.makeListNode(Collections.<TypeNode>emptyList()))
            )))));

        return myVarName;
    }

    @Override
    public String executeBinaryExpressionNode(BinaryExpressionNode node, Pair<ExpressionNode,List<BlockStatementNode>> p)
    {
        ExpressionNode factoryNode = p.getFirst();
        List<BlockStatementNode> statements = p.getSecond();

        String liftLeftOperandVarName = 
                node.getLeftOperand().executeOperation(this,p);
        String liftRightOperandVarName = 
                node.getRightOperand().executeOperation(this,p);
        BinaryOperator liftOperatorValue = 
                node.getOperator();

        String myVarName = getUniqueName();
        statements.add(
                factory.makeVariableDeclarationNode(
                        factory.makeVariableModifiersNode(
                                false,
                                factory.makeListNode(Collections.<AnnotationNode>emptyList())),
                factory.makeListNode(
                        Collections.singletonList(
                                factory.makeVariableDeclaratorNode(
                                        factory.makeUnparameterizedTypeNode(
                                                factory.makeSimpleNameNode(
                                                        factory.makeIdentifierNode("BinaryExpressionNode"),
                                                        NameCategory.TYPE)),
                                        factory.makeIdentifierNode(myVarName),
                                        factory.makeMethodInvocationByExpressionNode(
                                                factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                                                factory.makeIdentifierNode("makeBinaryExpressionNode"),
                                                factory.makeListNode(
                                                        Arrays.<ExpressionNode>asList(
                                                                factory.makeFieldAccessByNameNode(factory.makeSimpleNameNode(factory.makeIdentifierNode(
                                                                        liftLeftOperandVarName),NameCategory.EXPRESSION)),
                                                                factory.makeFieldAccessByNameNode(factory.makeSimpleNameNode(factory.makeIdentifierNode(
                                                                        liftRightOperandVarName),NameCategory.EXPRESSION)),
                                                                expressionizeBinaryOperator(liftOperatorValue)
                                                                )),
                                                factory.makeListNode(Collections.<TypeNode>emptyList()))
            )))));

        return myVarName;
    }

    @Override
    public String executeForInitializerExpressionNode(ForInitializerExpressionNode node, Pair<ExpressionNode,List<BlockStatementNode>> p)
    {
        ExpressionNode factoryNode = p.getFirst();
        List<BlockStatementNode> statements = p.getSecond();

        String liftExpressionsVarName = 
                node.getExpressions().executeOperation(this,p);

        String myVarName = getUniqueName();
        statements.add(
                factory.makeVariableDeclarationNode(
                        factory.makeVariableModifiersNode(
                                false,
                                factory.makeListNode(Collections.<AnnotationNode>emptyList())),
                factory.makeListNode(
                        Collections.singletonList(
                                factory.makeVariableDeclaratorNode(
                                        factory.makeUnparameterizedTypeNode(
                                                factory.makeSimpleNameNode(
                                                        factory.makeIdentifierNode("ForInitializerExpressionNode"),
                                                        NameCategory.TYPE)),
                                        factory.makeIdentifierNode(myVarName),
                                        factory.makeMethodInvocationByExpressionNode(
                                                factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                                                factory.makeIdentifierNode("makeForInitializerExpressionNode"),
                                                factory.makeListNode(
                                                        Arrays.<ExpressionNode>asList(
                                                                factory.makeFieldAccessByNameNode(factory.makeSimpleNameNode(factory.makeIdentifierNode(
                                                                        liftExpressionsVarName),NameCategory.EXPRESSION))
                                                                )),
                                                factory.makeListNode(Collections.<TypeNode>emptyList()))
            )))));

        return myVarName;
    }

    @Override
    public String executePackageDeclarationNode(PackageDeclarationNode node, Pair<ExpressionNode,List<BlockStatementNode>> p)
    {
        ExpressionNode factoryNode = p.getFirst();
        List<BlockStatementNode> statements = p.getSecond();

        String liftNameVarName = 
                node.getName().executeOperation(this,p);
        String liftAnnotationsVarName = 
                node.getAnnotations().executeOperation(this,p);

        String myVarName = getUniqueName();
        statements.add(
                factory.makeVariableDeclarationNode(
                        factory.makeVariableModifiersNode(
                                false,
                                factory.makeListNode(Collections.<AnnotationNode>emptyList())),
                factory.makeListNode(
                        Collections.singletonList(
                                factory.makeVariableDeclaratorNode(
                                        factory.makeUnparameterizedTypeNode(
                                                factory.makeSimpleNameNode(
                                                        factory.makeIdentifierNode("PackageDeclarationNode"),
                                                        NameCategory.TYPE)),
                                        factory.makeIdentifierNode(myVarName),
                                        factory.makeMethodInvocationByExpressionNode(
                                                factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                                                factory.makeIdentifierNode("makePackageDeclarationNode"),
                                                factory.makeListNode(
                                                        Arrays.<ExpressionNode>asList(
                                                                factory.makeFieldAccessByNameNode(factory.makeSimpleNameNode(factory.makeIdentifierNode(
                                                                        liftNameVarName),NameCategory.EXPRESSION)),
                                                                factory.makeFieldAccessByNameNode(factory.makeSimpleNameNode(factory.makeIdentifierNode(
                                                                        liftAnnotationsVarName),NameCategory.EXPRESSION))
                                                                )),
                                                factory.makeListNode(Collections.<TypeNode>emptyList()))
            )))));

        return myVarName;
    }

    @Override
    public String executeAnnotationDeclarationNode(AnnotationDeclarationNode node, Pair<ExpressionNode,List<BlockStatementNode>> p)
    {
        ExpressionNode factoryNode = p.getFirst();
        List<BlockStatementNode> statements = p.getSecond();

        String liftModifiersVarName = 
                node.getModifiers().executeOperation(this,p);
        String liftBodyVarName = 
                node.getBody().executeOperation(this,p);
        String liftIdentifierVarName = 
                node.getIdentifier().executeOperation(this,p);
        String liftJavadocVarName = 
                node.getJavadoc().executeOperation(this,p);

        String myVarName = getUniqueName();
        statements.add(
                factory.makeVariableDeclarationNode(
                        factory.makeVariableModifiersNode(
                                false,
                                factory.makeListNode(Collections.<AnnotationNode>emptyList())),
                factory.makeListNode(
                        Collections.singletonList(
                                factory.makeVariableDeclaratorNode(
                                        factory.makeUnparameterizedTypeNode(
                                                factory.makeSimpleNameNode(
                                                        factory.makeIdentifierNode("AnnotationDeclarationNode"),
                                                        NameCategory.TYPE)),
                                        factory.makeIdentifierNode(myVarName),
                                        factory.makeMethodInvocationByExpressionNode(
                                                factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                                                factory.makeIdentifierNode("makeAnnotationDeclarationNode"),
                                                factory.makeListNode(
                                                        Arrays.<ExpressionNode>asList(
                                                                factory.makeFieldAccessByNameNode(factory.makeSimpleNameNode(factory.makeIdentifierNode(
                                                                        liftModifiersVarName),NameCategory.EXPRESSION)),
                                                                factory.makeFieldAccessByNameNode(factory.makeSimpleNameNode(factory.makeIdentifierNode(
                                                                        liftBodyVarName),NameCategory.EXPRESSION)),
                                                                factory.makeFieldAccessByNameNode(factory.makeSimpleNameNode(factory.makeIdentifierNode(
                                                                        liftIdentifierVarName),NameCategory.EXPRESSION)),
                                                                factory.makeFieldAccessByNameNode(factory.makeSimpleNameNode(factory.makeIdentifierNode(
                                                                        liftJavadocVarName),NameCategory.EXPRESSION))
                                                                )),
                                                factory.makeListNode(Collections.<TypeNode>emptyList()))
            )))));

        return myVarName;
    }

    @Override
    public String executeCompilationUnitNode(CompilationUnitNode node, Pair<ExpressionNode,List<BlockStatementNode>> p)
    {
        ExpressionNode factoryNode = p.getFirst();
        List<BlockStatementNode> statements = p.getSecond();

        String liftPackageDeclarationVarName = 
                node.getPackageDeclaration().executeOperation(this,p);
        String liftImportsVarName = 
                node.getImports().executeOperation(this,p);
        String liftTypeDeclsVarName = 
                node.getTypeDecls().executeOperation(this,p);

        String myVarName = getUniqueName();
        statements.add(
                factory.makeVariableDeclarationNode(
                        factory.makeVariableModifiersNode(
                                false,
                                factory.makeListNode(Collections.<AnnotationNode>emptyList())),
                factory.makeListNode(
                        Collections.singletonList(
                                factory.makeVariableDeclaratorNode(
                                        factory.makeUnparameterizedTypeNode(
                                                factory.makeSimpleNameNode(
                                                        factory.makeIdentifierNode("CompilationUnitNode"),
                                                        NameCategory.TYPE)),
                                        factory.makeIdentifierNode(myVarName),
                                        factory.makeMethodInvocationByExpressionNode(
                                                factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                                                factory.makeIdentifierNode("makeCompilationUnitNode"),
                                                factory.makeListNode(
                                                        Arrays.<ExpressionNode>asList(
                                                                factory.makeFieldAccessByNameNode(factory.makeSimpleNameNode(factory.makeIdentifierNode(
                                                                        liftPackageDeclarationVarName),NameCategory.EXPRESSION)),
                                                                factory.makeFieldAccessByNameNode(factory.makeSimpleNameNode(factory.makeIdentifierNode(
                                                                        liftImportsVarName),NameCategory.EXPRESSION)),
                                                                factory.makeFieldAccessByNameNode(factory.makeSimpleNameNode(factory.makeIdentifierNode(
                                                                        liftTypeDeclsVarName),NameCategory.EXPRESSION))
                                                                )),
                                                factory.makeListNode(Collections.<TypeNode>emptyList()))
            )))));

        return myVarName;
    }

    @Override
    public String executeContinueNode(ContinueNode node, Pair<ExpressionNode,List<BlockStatementNode>> p)
    {
        ExpressionNode factoryNode = p.getFirst();
        List<BlockStatementNode> statements = p.getSecond();

        String liftLabelVarName = 
                node.getLabel().executeOperation(this,p);

        String myVarName = getUniqueName();
        statements.add(
                factory.makeVariableDeclarationNode(
                        factory.makeVariableModifiersNode(
                                false,
                                factory.makeListNode(Collections.<AnnotationNode>emptyList())),
                factory.makeListNode(
                        Collections.singletonList(
                                factory.makeVariableDeclaratorNode(
                                        factory.makeUnparameterizedTypeNode(
                                                factory.makeSimpleNameNode(
                                                        factory.makeIdentifierNode("ContinueNode"),
                                                        NameCategory.TYPE)),
                                        factory.makeIdentifierNode(myVarName),
                                        factory.makeMethodInvocationByExpressionNode(
                                                factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                                                factory.makeIdentifierNode("makeContinueNode"),
                                                factory.makeListNode(
                                                        Arrays.<ExpressionNode>asList(
                                                                factory.makeFieldAccessByNameNode(factory.makeSimpleNameNode(factory.makeIdentifierNode(
                                                                        liftLabelVarName),NameCategory.EXPRESSION))
                                                                )),
                                                factory.makeListNode(Collections.<TypeNode>emptyList()))
            )))));

        return myVarName;
    }

    @Override
    public String executeStringLiteralNode(StringLiteralNode node, Pair<ExpressionNode,List<BlockStatementNode>> p)
    {
        ExpressionNode factoryNode = p.getFirst();
        List<BlockStatementNode> statements = p.getSecond();

        String liftValueValue = 
                node.getValue();

        String myVarName = getUniqueName();
        statements.add(
                factory.makeVariableDeclarationNode(
                        factory.makeVariableModifiersNode(
                                false,
                                factory.makeListNode(Collections.<AnnotationNode>emptyList())),
                factory.makeListNode(
                        Collections.singletonList(
                                factory.makeVariableDeclaratorNode(
                                        factory.makeUnparameterizedTypeNode(
                                                factory.makeSimpleNameNode(
                                                        factory.makeIdentifierNode("StringLiteralNode"),
                                                        NameCategory.TYPE)),
                                        factory.makeIdentifierNode(myVarName),
                                        factory.makeMethodInvocationByExpressionNode(
                                                factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                                                factory.makeIdentifierNode("makeStringLiteralNode"),
                                                factory.makeListNode(
                                                        Arrays.<ExpressionNode>asList(
                                                                expressionizeString(liftValueValue)
                                                                )),
                                                factory.makeListNode(Collections.<TypeNode>emptyList()))
            )))));

        return myVarName;
    }

    @Override
    public String executeAnnotationElementNode(AnnotationElementNode node, Pair<ExpressionNode,List<BlockStatementNode>> p)
    {
        ExpressionNode factoryNode = p.getFirst();
        List<BlockStatementNode> statements = p.getSecond();

        String liftIdentifierVarName = 
                node.getIdentifier().executeOperation(this,p);
        String liftValueVarName = 
                node.getValue().executeOperation(this,p);

        String myVarName = getUniqueName();
        statements.add(
                factory.makeVariableDeclarationNode(
                        factory.makeVariableModifiersNode(
                                false,
                                factory.makeListNode(Collections.<AnnotationNode>emptyList())),
                factory.makeListNode(
                        Collections.singletonList(
                                factory.makeVariableDeclaratorNode(
                                        factory.makeUnparameterizedTypeNode(
                                                factory.makeSimpleNameNode(
                                                        factory.makeIdentifierNode("AnnotationElementNode"),
                                                        NameCategory.TYPE)),
                                        factory.makeIdentifierNode(myVarName),
                                        factory.makeMethodInvocationByExpressionNode(
                                                factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                                                factory.makeIdentifierNode("makeAnnotationElementNode"),
                                                factory.makeListNode(
                                                        Arrays.<ExpressionNode>asList(
                                                                factory.makeFieldAccessByNameNode(factory.makeSimpleNameNode(factory.makeIdentifierNode(
                                                                        liftIdentifierVarName),NameCategory.EXPRESSION)),
                                                                factory.makeFieldAccessByNameNode(factory.makeSimpleNameNode(factory.makeIdentifierNode(
                                                                        liftValueVarName),NameCategory.EXPRESSION))
                                                                )),
                                                factory.makeListNode(Collections.<TypeNode>emptyList()))
            )))));

        return myVarName;
    }

    @Override
    public String executeDoubleLiteralNode(DoubleLiteralNode node, Pair<ExpressionNode,List<BlockStatementNode>> p)
    {
        ExpressionNode factoryNode = p.getFirst();
        List<BlockStatementNode> statements = p.getSecond();

        Double liftValueValue = 
                node.getValue();

        String myVarName = getUniqueName();
        statements.add(
                factory.makeVariableDeclarationNode(
                        factory.makeVariableModifiersNode(
                                false,
                                factory.makeListNode(Collections.<AnnotationNode>emptyList())),
                factory.makeListNode(
                        Collections.singletonList(
                                factory.makeVariableDeclaratorNode(
                                        factory.makeUnparameterizedTypeNode(
                                                factory.makeSimpleNameNode(
                                                        factory.makeIdentifierNode("DoubleLiteralNode"),
                                                        NameCategory.TYPE)),
                                        factory.makeIdentifierNode(myVarName),
                                        factory.makeMethodInvocationByExpressionNode(
                                                factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                                                factory.makeIdentifierNode("makeDoubleLiteralNode"),
                                                factory.makeListNode(
                                                        Arrays.<ExpressionNode>asList(
                                                                expressionizeDouble(liftValueValue)
                                                                )),
                                                factory.makeListNode(Collections.<TypeNode>emptyList()))
            )))));

        return myVarName;
    }

    @Override
    public String executeAnonymousClassBodyNode(AnonymousClassBodyNode node, Pair<ExpressionNode,List<BlockStatementNode>> p)
    {
        ExpressionNode factoryNode = p.getFirst();
        List<BlockStatementNode> statements = p.getSecond();

        String liftMembersVarName = 
                node.getMembers().executeOperation(this,p);

        String myVarName = getUniqueName();
        statements.add(
                factory.makeVariableDeclarationNode(
                        factory.makeVariableModifiersNode(
                                false,
                                factory.makeListNode(Collections.<AnnotationNode>emptyList())),
                factory.makeListNode(
                        Collections.singletonList(
                                factory.makeVariableDeclaratorNode(
                                        factory.makeUnparameterizedTypeNode(
                                                factory.makeSimpleNameNode(
                                                        factory.makeIdentifierNode("AnonymousClassBodyNode"),
                                                        NameCategory.TYPE)),
                                        factory.makeIdentifierNode(myVarName),
                                        factory.makeMethodInvocationByExpressionNode(
                                                factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                                                factory.makeIdentifierNode("makeAnonymousClassBodyNode"),
                                                factory.makeListNode(
                                                        Arrays.<ExpressionNode>asList(
                                                                factory.makeFieldAccessByNameNode(factory.makeSimpleNameNode(factory.makeIdentifierNode(
                                                                        liftMembersVarName),NameCategory.EXPRESSION))
                                                                )),
                                                factory.makeListNode(Collections.<TypeNode>emptyList()))
            )))));

        return myVarName;
    }

    @Override
    public String executeBlockNode(BlockNode node, Pair<ExpressionNode,List<BlockStatementNode>> p)
    {
        ExpressionNode factoryNode = p.getFirst();
        List<BlockStatementNode> statements = p.getSecond();

        String liftStatementsVarName = 
                node.getStatements().executeOperation(this,p);

        String myVarName = getUniqueName();
        statements.add(
                factory.makeVariableDeclarationNode(
                        factory.makeVariableModifiersNode(
                                false,
                                factory.makeListNode(Collections.<AnnotationNode>emptyList())),
                factory.makeListNode(
                        Collections.singletonList(
                                factory.makeVariableDeclaratorNode(
                                        factory.makeUnparameterizedTypeNode(
                                                factory.makeSimpleNameNode(
                                                        factory.makeIdentifierNode("BlockNode"),
                                                        NameCategory.TYPE)),
                                        factory.makeIdentifierNode(myVarName),
                                        factory.makeMethodInvocationByExpressionNode(
                                                factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                                                factory.makeIdentifierNode("makeBlockNode"),
                                                factory.makeListNode(
                                                        Arrays.<ExpressionNode>asList(
                                                                factory.makeFieldAccessByNameNode(factory.makeSimpleNameNode(factory.makeIdentifierNode(
                                                                        liftStatementsVarName),NameCategory.EXPRESSION))
                                                                )),
                                                factory.makeListNode(Collections.<TypeNode>emptyList()))
            )))));

        return myVarName;
    }

    @Override
    public String executeSynchronizedNode(SynchronizedNode node, Pair<ExpressionNode,List<BlockStatementNode>> p)
    {
        ExpressionNode factoryNode = p.getFirst();
        List<BlockStatementNode> statements = p.getSecond();

        String liftExpressionVarName = 
                node.getExpression().executeOperation(this,p);
        String liftBlockVarName = 
                node.getBlock().executeOperation(this,p);

        String myVarName = getUniqueName();
        statements.add(
                factory.makeVariableDeclarationNode(
                        factory.makeVariableModifiersNode(
                                false,
                                factory.makeListNode(Collections.<AnnotationNode>emptyList())),
                factory.makeListNode(
                        Collections.singletonList(
                                factory.makeVariableDeclaratorNode(
                                        factory.makeUnparameterizedTypeNode(
                                                factory.makeSimpleNameNode(
                                                        factory.makeIdentifierNode("SynchronizedNode"),
                                                        NameCategory.TYPE)),
                                        factory.makeIdentifierNode(myVarName),
                                        factory.makeMethodInvocationByExpressionNode(
                                                factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                                                factory.makeIdentifierNode("makeSynchronizedNode"),
                                                factory.makeListNode(
                                                        Arrays.<ExpressionNode>asList(
                                                                factory.makeFieldAccessByNameNode(factory.makeSimpleNameNode(factory.makeIdentifierNode(
                                                                        liftExpressionVarName),NameCategory.EXPRESSION)),
                                                                factory.makeFieldAccessByNameNode(factory.makeSimpleNameNode(factory.makeIdentifierNode(
                                                                        liftBlockVarName),NameCategory.EXPRESSION))
                                                                )),
                                                factory.makeListNode(Collections.<TypeNode>emptyList()))
            )))));

        return myVarName;
    }

    @Override
    public String executeVariableNode(VariableNode node, Pair<ExpressionNode,List<BlockStatementNode>> p)
    {
        ExpressionNode factoryNode = p.getFirst();
        List<BlockStatementNode> statements = p.getSecond();

        String liftModifiersVarName = 
                node.getModifiers().executeOperation(this,p);
        String liftTypeVarName = 
                node.getType().executeOperation(this,p);
        String liftIdentifierVarName = 
                node.getIdentifier().executeOperation(this,p);

        String myVarName = getUniqueName();
        statements.add(
                factory.makeVariableDeclarationNode(
                        factory.makeVariableModifiersNode(
                                false,
                                factory.makeListNode(Collections.<AnnotationNode>emptyList())),
                factory.makeListNode(
                        Collections.singletonList(
                                factory.makeVariableDeclaratorNode(
                                        factory.makeUnparameterizedTypeNode(
                                                factory.makeSimpleNameNode(
                                                        factory.makeIdentifierNode("VariableNode"),
                                                        NameCategory.TYPE)),
                                        factory.makeIdentifierNode(myVarName),
                                        factory.makeMethodInvocationByExpressionNode(
                                                factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                                                factory.makeIdentifierNode("makeVariableNode"),
                                                factory.makeListNode(
                                                        Arrays.<ExpressionNode>asList(
                                                                factory.makeFieldAccessByNameNode(factory.makeSimpleNameNode(factory.makeIdentifierNode(
                                                                        liftModifiersVarName),NameCategory.EXPRESSION)),
                                                                factory.makeFieldAccessByNameNode(factory.makeSimpleNameNode(factory.makeIdentifierNode(
                                                                        liftTypeVarName),NameCategory.EXPRESSION)),
                                                                factory.makeFieldAccessByNameNode(factory.makeSimpleNameNode(factory.makeIdentifierNode(
                                                                        liftIdentifierVarName),NameCategory.EXPRESSION))
                                                                )),
                                                factory.makeListNode(Collections.<TypeNode>emptyList()))
            )))));

        return myVarName;
    }

    @Override
    public String executeCharLiteralNode(CharLiteralNode node, Pair<ExpressionNode,List<BlockStatementNode>> p)
    {
        ExpressionNode factoryNode = p.getFirst();
        List<BlockStatementNode> statements = p.getSecond();

        Character liftValueValue = 
                node.getValue();

        String myVarName = getUniqueName();
        statements.add(
                factory.makeVariableDeclarationNode(
                        factory.makeVariableModifiersNode(
                                false,
                                factory.makeListNode(Collections.<AnnotationNode>emptyList())),
                factory.makeListNode(
                        Collections.singletonList(
                                factory.makeVariableDeclaratorNode(
                                        factory.makeUnparameterizedTypeNode(
                                                factory.makeSimpleNameNode(
                                                        factory.makeIdentifierNode("CharLiteralNode"),
                                                        NameCategory.TYPE)),
                                        factory.makeIdentifierNode(myVarName),
                                        factory.makeMethodInvocationByExpressionNode(
                                                factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                                                factory.makeIdentifierNode("makeCharLiteralNode"),
                                                factory.makeListNode(
                                                        Arrays.<ExpressionNode>asList(
                                                                expressionizeCharacter(liftValueValue)
                                                                )),
                                                factory.makeListNode(Collections.<TypeNode>emptyList()))
            )))));

        return myVarName;
    }

    @Override
    public String executeWildcardTypeNode(WildcardTypeNode node, Pair<ExpressionNode,List<BlockStatementNode>> p)
    {
        ExpressionNode factoryNode = p.getFirst();
        List<BlockStatementNode> statements = p.getSecond();

        String liftBoundVarName = 
                node.getBound().executeOperation(this,p);
        boolean liftUpperBoundValue = 
                node.getUpperBound();

        String myVarName = getUniqueName();
        statements.add(
                factory.makeVariableDeclarationNode(
                        factory.makeVariableModifiersNode(
                                false,
                                factory.makeListNode(Collections.<AnnotationNode>emptyList())),
                factory.makeListNode(
                        Collections.singletonList(
                                factory.makeVariableDeclaratorNode(
                                        factory.makeUnparameterizedTypeNode(
                                                factory.makeSimpleNameNode(
                                                        factory.makeIdentifierNode("WildcardTypeNode"),
                                                        NameCategory.TYPE)),
                                        factory.makeIdentifierNode(myVarName),
                                        factory.makeMethodInvocationByExpressionNode(
                                                factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                                                factory.makeIdentifierNode("makeWildcardTypeNode"),
                                                factory.makeListNode(
                                                        Arrays.<ExpressionNode>asList(
                                                                factory.makeFieldAccessByNameNode(factory.makeSimpleNameNode(factory.makeIdentifierNode(
                                                                        liftBoundVarName),NameCategory.EXPRESSION)),
                                                                expressionizeBoolean(liftUpperBoundValue)
                                                                )),
                                                factory.makeListNode(Collections.<TypeNode>emptyList()))
            )))));

        return myVarName;
    }

    @Override
    public String executeInlineTypeDeclarationNode(InlineTypeDeclarationNode node, Pair<ExpressionNode,List<BlockStatementNode>> p)
    {
        ExpressionNode factoryNode = p.getFirst();
        List<BlockStatementNode> statements = p.getSecond();

        String liftDeclarationVarName = 
                node.getDeclaration().executeOperation(this,p);

        String myVarName = getUniqueName();
        statements.add(
                factory.makeVariableDeclarationNode(
                        factory.makeVariableModifiersNode(
                                false,
                                factory.makeListNode(Collections.<AnnotationNode>emptyList())),
                factory.makeListNode(
                        Collections.singletonList(
                                factory.makeVariableDeclaratorNode(
                                        factory.makeUnparameterizedTypeNode(
                                                factory.makeSimpleNameNode(
                                                        factory.makeIdentifierNode("InlineTypeDeclarationNode"),
                                                        NameCategory.TYPE)),
                                        factory.makeIdentifierNode(myVarName),
                                        factory.makeMethodInvocationByExpressionNode(
                                                factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                                                factory.makeIdentifierNode("makeInlineTypeDeclarationNode"),
                                                factory.makeListNode(
                                                        Arrays.<ExpressionNode>asList(
                                                                factory.makeFieldAccessByNameNode(factory.makeSimpleNameNode(factory.makeIdentifierNode(
                                                                        liftDeclarationVarName),NameCategory.EXPRESSION))
                                                                )),
                                                factory.makeListNode(Collections.<TypeNode>emptyList()))
            )))));

        return myVarName;
    }

    @Override
    public String executeUnaryExpressionNode(UnaryExpressionNode node, Pair<ExpressionNode,List<BlockStatementNode>> p)
    {
        ExpressionNode factoryNode = p.getFirst();
        List<BlockStatementNode> statements = p.getSecond();

        String liftExpressionVarName = 
                node.getExpression().executeOperation(this,p);
        UnaryOperator liftOperatorValue = 
                node.getOperator();

        String myVarName = getUniqueName();
        statements.add(
                factory.makeVariableDeclarationNode(
                        factory.makeVariableModifiersNode(
                                false,
                                factory.makeListNode(Collections.<AnnotationNode>emptyList())),
                factory.makeListNode(
                        Collections.singletonList(
                                factory.makeVariableDeclaratorNode(
                                        factory.makeUnparameterizedTypeNode(
                                                factory.makeSimpleNameNode(
                                                        factory.makeIdentifierNode("UnaryExpressionNode"),
                                                        NameCategory.TYPE)),
                                        factory.makeIdentifierNode(myVarName),
                                        factory.makeMethodInvocationByExpressionNode(
                                                factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                                                factory.makeIdentifierNode("makeUnaryExpressionNode"),
                                                factory.makeListNode(
                                                        Arrays.<ExpressionNode>asList(
                                                                factory.makeFieldAccessByNameNode(factory.makeSimpleNameNode(factory.makeIdentifierNode(
                                                                        liftExpressionVarName),NameCategory.EXPRESSION)),
                                                                expressionizeUnaryOperator(liftOperatorValue)
                                                                )),
                                                factory.makeListNode(Collections.<TypeNode>emptyList()))
            )))));

        return myVarName;
    }

    @Override
    public String executeBooleanLiteralNode(BooleanLiteralNode node, Pair<ExpressionNode,List<BlockStatementNode>> p)
    {
        ExpressionNode factoryNode = p.getFirst();
        List<BlockStatementNode> statements = p.getSecond();

        Boolean liftValueValue = 
                node.getValue();

        String myVarName = getUniqueName();
        statements.add(
                factory.makeVariableDeclarationNode(
                        factory.makeVariableModifiersNode(
                                false,
                                factory.makeListNode(Collections.<AnnotationNode>emptyList())),
                factory.makeListNode(
                        Collections.singletonList(
                                factory.makeVariableDeclaratorNode(
                                        factory.makeUnparameterizedTypeNode(
                                                factory.makeSimpleNameNode(
                                                        factory.makeIdentifierNode("BooleanLiteralNode"),
                                                        NameCategory.TYPE)),
                                        factory.makeIdentifierNode(myVarName),
                                        factory.makeMethodInvocationByExpressionNode(
                                                factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                                                factory.makeIdentifierNode("makeBooleanLiteralNode"),
                                                factory.makeListNode(
                                                        Arrays.<ExpressionNode>asList(
                                                                expressionizeBoolean(liftValueValue)
                                                                )),
                                                factory.makeListNode(Collections.<TypeNode>emptyList()))
            )))));

        return myVarName;
    }

    @Override
    public String executeSwitchNode(SwitchNode node, Pair<ExpressionNode,List<BlockStatementNode>> p)
    {
        ExpressionNode factoryNode = p.getFirst();
        List<BlockStatementNode> statements = p.getSecond();

        String liftExpressionVarName = 
                node.getExpression().executeOperation(this,p);
        String liftCasesVarName = 
                node.getCases().executeOperation(this,p);

        String myVarName = getUniqueName();
        statements.add(
                factory.makeVariableDeclarationNode(
                        factory.makeVariableModifiersNode(
                                false,
                                factory.makeListNode(Collections.<AnnotationNode>emptyList())),
                factory.makeListNode(
                        Collections.singletonList(
                                factory.makeVariableDeclaratorNode(
                                        factory.makeUnparameterizedTypeNode(
                                                factory.makeSimpleNameNode(
                                                        factory.makeIdentifierNode("SwitchNode"),
                                                        NameCategory.TYPE)),
                                        factory.makeIdentifierNode(myVarName),
                                        factory.makeMethodInvocationByExpressionNode(
                                                factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                                                factory.makeIdentifierNode("makeSwitchNode"),
                                                factory.makeListNode(
                                                        Arrays.<ExpressionNode>asList(
                                                                factory.makeFieldAccessByNameNode(factory.makeSimpleNameNode(factory.makeIdentifierNode(
                                                                        liftExpressionVarName),NameCategory.EXPRESSION)),
                                                                factory.makeFieldAccessByNameNode(factory.makeSimpleNameNode(factory.makeIdentifierNode(
                                                                        liftCasesVarName),NameCategory.EXPRESSION))
                                                                )),
                                                factory.makeListNode(Collections.<TypeNode>emptyList()))
            )))));

        return myVarName;
    }

    @Override
    public String executeAlternateConstructorInvocationNode(AlternateConstructorInvocationNode node, Pair<ExpressionNode,List<BlockStatementNode>> p)
    {
        ExpressionNode factoryNode = p.getFirst();
        List<BlockStatementNode> statements = p.getSecond();

        String liftArgumentsVarName = 
                node.getArguments().executeOperation(this,p);
        String liftTypeArgumentsVarName = 
                node.getTypeArguments().executeOperation(this,p);

        String myVarName = getUniqueName();
        statements.add(
                factory.makeVariableDeclarationNode(
                        factory.makeVariableModifiersNode(
                                false,
                                factory.makeListNode(Collections.<AnnotationNode>emptyList())),
                factory.makeListNode(
                        Collections.singletonList(
                                factory.makeVariableDeclaratorNode(
                                        factory.makeUnparameterizedTypeNode(
                                                factory.makeSimpleNameNode(
                                                        factory.makeIdentifierNode("AlternateConstructorInvocationNode"),
                                                        NameCategory.TYPE)),
                                        factory.makeIdentifierNode(myVarName),
                                        factory.makeMethodInvocationByExpressionNode(
                                                factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                                                factory.makeIdentifierNode("makeAlternateConstructorInvocationNode"),
                                                factory.makeListNode(
                                                        Arrays.<ExpressionNode>asList(
                                                                factory.makeFieldAccessByNameNode(factory.makeSimpleNameNode(factory.makeIdentifierNode(
                                                                        liftArgumentsVarName),NameCategory.EXPRESSION)),
                                                                factory.makeFieldAccessByNameNode(factory.makeSimpleNameNode(factory.makeIdentifierNode(
                                                                        liftTypeArgumentsVarName),NameCategory.EXPRESSION))
                                                                )),
                                                factory.makeListNode(Collections.<TypeNode>emptyList()))
            )))));

        return myVarName;
    }

    @Override
    public String executeAnnotationMethodModifiersNode(AnnotationMethodModifiersNode node, Pair<ExpressionNode,List<BlockStatementNode>> p)
    {
        ExpressionNode factoryNode = p.getFirst();
        List<BlockStatementNode> statements = p.getSecond();

        String liftAnnotationsVarName = 
                node.getAnnotations().executeOperation(this,p);

        String myVarName = getUniqueName();
        statements.add(
                factory.makeVariableDeclarationNode(
                        factory.makeVariableModifiersNode(
                                false,
                                factory.makeListNode(Collections.<AnnotationNode>emptyList())),
                factory.makeListNode(
                        Collections.singletonList(
                                factory.makeVariableDeclaratorNode(
                                        factory.makeUnparameterizedTypeNode(
                                                factory.makeSimpleNameNode(
                                                        factory.makeIdentifierNode("AnnotationMethodModifiersNode"),
                                                        NameCategory.TYPE)),
                                        factory.makeIdentifierNode(myVarName),
                                        factory.makeMethodInvocationByExpressionNode(
                                                factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                                                factory.makeIdentifierNode("makeAnnotationMethodModifiersNode"),
                                                factory.makeListNode(
                                                        Arrays.<ExpressionNode>asList(
                                                                factory.makeFieldAccessByNameNode(factory.makeSimpleNameNode(factory.makeIdentifierNode(
                                                                        liftAnnotationsVarName),NameCategory.EXPRESSION))
                                                                )),
                                                factory.makeListNode(Collections.<TypeNode>emptyList()))
            )))));

        return myVarName;
    }

    @Override
    public String executeConstructorDeclarationNode(ConstructorDeclarationNode node, Pair<ExpressionNode,List<BlockStatementNode>> p)
    {
        ExpressionNode factoryNode = p.getFirst();
        List<BlockStatementNode> statements = p.getSecond();

        String liftIdentifierVarName = 
                node.getIdentifier().executeOperation(this,p);
        String liftBodyVarName = 
                node.getBody().executeOperation(this,p);
        String liftModifiersVarName = 
                node.getModifiers().executeOperation(this,p);
        String liftParametersVarName = 
                node.getParameters().executeOperation(this,p);
        String liftVarargParameterVarName = 
                node.getVarargParameter().executeOperation(this,p);
        String liftThrowTypesVarName = 
                node.getThrowTypes().executeOperation(this,p);
        String liftTypeParametersVarName = 
                node.getTypeParameters().executeOperation(this,p);
        String liftJavadocVarName = 
                node.getJavadoc().executeOperation(this,p);

        String myVarName = getUniqueName();
        statements.add(
                factory.makeVariableDeclarationNode(
                        factory.makeVariableModifiersNode(
                                false,
                                factory.makeListNode(Collections.<AnnotationNode>emptyList())),
                factory.makeListNode(
                        Collections.singletonList(
                                factory.makeVariableDeclaratorNode(
                                        factory.makeUnparameterizedTypeNode(
                                                factory.makeSimpleNameNode(
                                                        factory.makeIdentifierNode("ConstructorDeclarationNode"),
                                                        NameCategory.TYPE)),
                                        factory.makeIdentifierNode(myVarName),
                                        factory.makeMethodInvocationByExpressionNode(
                                                factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                                                factory.makeIdentifierNode("makeConstructorDeclarationNode"),
                                                factory.makeListNode(
                                                        Arrays.<ExpressionNode>asList(
                                                                factory.makeFieldAccessByNameNode(factory.makeSimpleNameNode(factory.makeIdentifierNode(
                                                                        liftIdentifierVarName),NameCategory.EXPRESSION)),
                                                                factory.makeFieldAccessByNameNode(factory.makeSimpleNameNode(factory.makeIdentifierNode(
                                                                        liftBodyVarName),NameCategory.EXPRESSION)),
                                                                factory.makeFieldAccessByNameNode(factory.makeSimpleNameNode(factory.makeIdentifierNode(
                                                                        liftModifiersVarName),NameCategory.EXPRESSION)),
                                                                factory.makeFieldAccessByNameNode(factory.makeSimpleNameNode(factory.makeIdentifierNode(
                                                                        liftParametersVarName),NameCategory.EXPRESSION)),
                                                                factory.makeFieldAccessByNameNode(factory.makeSimpleNameNode(factory.makeIdentifierNode(
                                                                        liftVarargParameterVarName),NameCategory.EXPRESSION)),
                                                                factory.makeFieldAccessByNameNode(factory.makeSimpleNameNode(factory.makeIdentifierNode(
                                                                        liftThrowTypesVarName),NameCategory.EXPRESSION)),
                                                                factory.makeFieldAccessByNameNode(factory.makeSimpleNameNode(factory.makeIdentifierNode(
                                                                        liftTypeParametersVarName),NameCategory.EXPRESSION)),
                                                                factory.makeFieldAccessByNameNode(factory.makeSimpleNameNode(factory.makeIdentifierNode(
                                                                        liftJavadocVarName),NameCategory.EXPRESSION))
                                                                )),
                                                factory.makeListNode(Collections.<TypeNode>emptyList()))
            )))));

        return myVarName;
    }

    @Override
    public String executeAnnotationAnnotationValueNode(AnnotationAnnotationValueNode node, Pair<ExpressionNode,List<BlockStatementNode>> p)
    {
        ExpressionNode factoryNode = p.getFirst();
        List<BlockStatementNode> statements = p.getSecond();

        String liftAnnotationVarName = 
                node.getAnnotation().executeOperation(this,p);

        String myVarName = getUniqueName();
        statements.add(
                factory.makeVariableDeclarationNode(
                        factory.makeVariableModifiersNode(
                                false,
                                factory.makeListNode(Collections.<AnnotationNode>emptyList())),
                factory.makeListNode(
                        Collections.singletonList(
                                factory.makeVariableDeclaratorNode(
                                        factory.makeUnparameterizedTypeNode(
                                                factory.makeSimpleNameNode(
                                                        factory.makeIdentifierNode("AnnotationAnnotationValueNode"),
                                                        NameCategory.TYPE)),
                                        factory.makeIdentifierNode(myVarName),
                                        factory.makeMethodInvocationByExpressionNode(
                                                factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                                                factory.makeIdentifierNode("makeAnnotationAnnotationValueNode"),
                                                factory.makeListNode(
                                                        Arrays.<ExpressionNode>asList(
                                                                factory.makeFieldAccessByNameNode(factory.makeSimpleNameNode(factory.makeIdentifierNode(
                                                                        liftAnnotationVarName),NameCategory.EXPRESSION))
                                                                )),
                                                factory.makeListNode(Collections.<TypeNode>emptyList()))
            )))));

        return myVarName;
    }

    @Override
    public String executeForLoopNode(ForLoopNode node, Pair<ExpressionNode,List<BlockStatementNode>> p)
    {
        ExpressionNode factoryNode = p.getFirst();
        List<BlockStatementNode> statements = p.getSecond();

        String liftInitializerVarName = 
                node.getInitializer().executeOperation(this,p);
        String liftConditionVarName = 
                node.getCondition().executeOperation(this,p);
        String liftUpdateVarName = 
                node.getUpdate().executeOperation(this,p);
        String liftStatementVarName = 
                node.getStatement().executeOperation(this,p);

        String myVarName = getUniqueName();
        statements.add(
                factory.makeVariableDeclarationNode(
                        factory.makeVariableModifiersNode(
                                false,
                                factory.makeListNode(Collections.<AnnotationNode>emptyList())),
                factory.makeListNode(
                        Collections.singletonList(
                                factory.makeVariableDeclaratorNode(
                                        factory.makeUnparameterizedTypeNode(
                                                factory.makeSimpleNameNode(
                                                        factory.makeIdentifierNode("ForLoopNode"),
                                                        NameCategory.TYPE)),
                                        factory.makeIdentifierNode(myVarName),
                                        factory.makeMethodInvocationByExpressionNode(
                                                factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                                                factory.makeIdentifierNode("makeForLoopNode"),
                                                factory.makeListNode(
                                                        Arrays.<ExpressionNode>asList(
                                                                factory.makeFieldAccessByNameNode(factory.makeSimpleNameNode(factory.makeIdentifierNode(
                                                                        liftInitializerVarName),NameCategory.EXPRESSION)),
                                                                factory.makeFieldAccessByNameNode(factory.makeSimpleNameNode(factory.makeIdentifierNode(
                                                                        liftConditionVarName),NameCategory.EXPRESSION)),
                                                                factory.makeFieldAccessByNameNode(factory.makeSimpleNameNode(factory.makeIdentifierNode(
                                                                        liftUpdateVarName),NameCategory.EXPRESSION)),
                                                                factory.makeFieldAccessByNameNode(factory.makeSimpleNameNode(factory.makeIdentifierNode(
                                                                        liftStatementVarName),NameCategory.EXPRESSION))
                                                                )),
                                                factory.makeListNode(Collections.<TypeNode>emptyList()))
            )))));

        return myVarName;
    }

    @Override
    public String executeWhileLoopNode(WhileLoopNode node, Pair<ExpressionNode,List<BlockStatementNode>> p)
    {
        ExpressionNode factoryNode = p.getFirst();
        List<BlockStatementNode> statements = p.getSecond();

        String liftConditionVarName = 
                node.getCondition().executeOperation(this,p);
        String liftStatementVarName = 
                node.getStatement().executeOperation(this,p);

        String myVarName = getUniqueName();
        statements.add(
                factory.makeVariableDeclarationNode(
                        factory.makeVariableModifiersNode(
                                false,
                                factory.makeListNode(Collections.<AnnotationNode>emptyList())),
                factory.makeListNode(
                        Collections.singletonList(
                                factory.makeVariableDeclaratorNode(
                                        factory.makeUnparameterizedTypeNode(
                                                factory.makeSimpleNameNode(
                                                        factory.makeIdentifierNode("WhileLoopNode"),
                                                        NameCategory.TYPE)),
                                        factory.makeIdentifierNode(myVarName),
                                        factory.makeMethodInvocationByExpressionNode(
                                                factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                                                factory.makeIdentifierNode("makeWhileLoopNode"),
                                                factory.makeListNode(
                                                        Arrays.<ExpressionNode>asList(
                                                                factory.makeFieldAccessByNameNode(factory.makeSimpleNameNode(factory.makeIdentifierNode(
                                                                        liftConditionVarName),NameCategory.EXPRESSION)),
                                                                factory.makeFieldAccessByNameNode(factory.makeSimpleNameNode(factory.makeIdentifierNode(
                                                                        liftStatementVarName),NameCategory.EXPRESSION))
                                                                )),
                                                factory.makeListNode(Collections.<TypeNode>emptyList()))
            )))));

        return myVarName;
    }

    @Override
    public <T extends Node> String executeListNode(ListNode<T> node, Pair<ExpressionNode,List<BlockStatementNode>> p)
    {
        ExpressionNode factoryNode = p.getFirst();
        List<BlockStatementNode> statements = p.getSecond();

        // TODO: children

        String myVarName = getUniqueName();
        statements.add(
                factory.makeVariableDeclarationNode(
                        factory.makeVariableModifiersNode(
                                false,
                                factory.makeListNode(Collections.<AnnotationNode>emptyList())),
                factory.makeListNode(
                        Collections.singletonList(
                                factory.makeVariableDeclaratorNode(
                                        factory.makeUnparameterizedTypeNode(
                                                factory.makeSimpleNameNode(
                                                        factory.makeIdentifierNode("ListNode<T extends Node>"),
                                                        NameCategory.TYPE)),
                                        factory.makeIdentifierNode(myVarName),
                                        factory.makeMethodInvocationByExpressionNode(
                                                factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                                                factory.makeIdentifierNode("makeListNode<T extends Node>"),
                                                factory.makeListNode(
                                                        Arrays.<ExpressionNode>asList(
                                                                /* TODO */ null
                                                                )),
                                                factory.makeListNode(Collections.<TypeNode>emptyList()))
            )))));

        return myVarName;
    }

    @Override
    public String executeEnumConstantDeclarationNode(EnumConstantDeclarationNode node, Pair<ExpressionNode,List<BlockStatementNode>> p)
    {
        ExpressionNode factoryNode = p.getFirst();
        List<BlockStatementNode> statements = p.getSecond();

        String liftAnnotationsVarName = 
                node.getAnnotations().executeOperation(this,p);
        String liftIdentifierVarName = 
                node.getIdentifier().executeOperation(this,p);
        String liftArgumentsVarName = 
                node.getArguments().executeOperation(this,p);
        String liftBodyVarName = 
                node.getBody().executeOperation(this,p);
        String liftJavadocVarName = 
                node.getJavadoc().executeOperation(this,p);

        String myVarName = getUniqueName();
        statements.add(
                factory.makeVariableDeclarationNode(
                        factory.makeVariableModifiersNode(
                                false,
                                factory.makeListNode(Collections.<AnnotationNode>emptyList())),
                factory.makeListNode(
                        Collections.singletonList(
                                factory.makeVariableDeclaratorNode(
                                        factory.makeUnparameterizedTypeNode(
                                                factory.makeSimpleNameNode(
                                                        factory.makeIdentifierNode("EnumConstantDeclarationNode"),
                                                        NameCategory.TYPE)),
                                        factory.makeIdentifierNode(myVarName),
                                        factory.makeMethodInvocationByExpressionNode(
                                                factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                                                factory.makeIdentifierNode("makeEnumConstantDeclarationNode"),
                                                factory.makeListNode(
                                                        Arrays.<ExpressionNode>asList(
                                                                factory.makeFieldAccessByNameNode(factory.makeSimpleNameNode(factory.makeIdentifierNode(
                                                                        liftAnnotationsVarName),NameCategory.EXPRESSION)),
                                                                factory.makeFieldAccessByNameNode(factory.makeSimpleNameNode(factory.makeIdentifierNode(
                                                                        liftIdentifierVarName),NameCategory.EXPRESSION)),
                                                                factory.makeFieldAccessByNameNode(factory.makeSimpleNameNode(factory.makeIdentifierNode(
                                                                        liftArgumentsVarName),NameCategory.EXPRESSION)),
                                                                factory.makeFieldAccessByNameNode(factory.makeSimpleNameNode(factory.makeIdentifierNode(
                                                                        liftBodyVarName),NameCategory.EXPRESSION)),
                                                                factory.makeFieldAccessByNameNode(factory.makeSimpleNameNode(factory.makeIdentifierNode(
                                                                        liftJavadocVarName),NameCategory.EXPRESSION))
                                                                )),
                                                factory.makeListNode(Collections.<TypeNode>emptyList()))
            )))));

        return myVarName;
    }

    @Override
    public String executeBreakNode(BreakNode node, Pair<ExpressionNode,List<BlockStatementNode>> p)
    {
        ExpressionNode factoryNode = p.getFirst();
        List<BlockStatementNode> statements = p.getSecond();

        String liftLabelVarName = 
                node.getLabel().executeOperation(this,p);

        String myVarName = getUniqueName();
        statements.add(
                factory.makeVariableDeclarationNode(
                        factory.makeVariableModifiersNode(
                                false,
                                factory.makeListNode(Collections.<AnnotationNode>emptyList())),
                factory.makeListNode(
                        Collections.singletonList(
                                factory.makeVariableDeclaratorNode(
                                        factory.makeUnparameterizedTypeNode(
                                                factory.makeSimpleNameNode(
                                                        factory.makeIdentifierNode("BreakNode"),
                                                        NameCategory.TYPE)),
                                        factory.makeIdentifierNode(myVarName),
                                        factory.makeMethodInvocationByExpressionNode(
                                                factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                                                factory.makeIdentifierNode("makeBreakNode"),
                                                factory.makeListNode(
                                                        Arrays.<ExpressionNode>asList(
                                                                factory.makeFieldAccessByNameNode(factory.makeSimpleNameNode(factory.makeIdentifierNode(
                                                                        liftLabelVarName),NameCategory.EXPRESSION))
                                                                )),
                                                factory.makeListNode(Collections.<TypeNode>emptyList()))
            )))));

        return myVarName;
    }

    @Override
    public String executeConstructorModifiersNode(ConstructorModifiersNode node, Pair<ExpressionNode,List<BlockStatementNode>> p)
    {
        ExpressionNode factoryNode = p.getFirst();
        List<BlockStatementNode> statements = p.getSecond();

        AccessModifier liftAccessValue = 
                node.getAccess();
        String liftAnnotationsVarName = 
                node.getAnnotations().executeOperation(this,p);

        String myVarName = getUniqueName();
        statements.add(
                factory.makeVariableDeclarationNode(
                        factory.makeVariableModifiersNode(
                                false,
                                factory.makeListNode(Collections.<AnnotationNode>emptyList())),
                factory.makeListNode(
                        Collections.singletonList(
                                factory.makeVariableDeclaratorNode(
                                        factory.makeUnparameterizedTypeNode(
                                                factory.makeSimpleNameNode(
                                                        factory.makeIdentifierNode("ConstructorModifiersNode"),
                                                        NameCategory.TYPE)),
                                        factory.makeIdentifierNode(myVarName),
                                        factory.makeMethodInvocationByExpressionNode(
                                                factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                                                factory.makeIdentifierNode("makeConstructorModifiersNode"),
                                                factory.makeListNode(
                                                        Arrays.<ExpressionNode>asList(
                                                                expressionizeAccessModifier(liftAccessValue),
                                                                factory.makeFieldAccessByNameNode(factory.makeSimpleNameNode(factory.makeIdentifierNode(
                                                                        liftAnnotationsVarName),NameCategory.EXPRESSION))
                                                                )),
                                                factory.makeListNode(Collections.<TypeNode>emptyList()))
            )))));

        return myVarName;
    }

    @Override
    public String executeParameterizedTypeSelectNode(ParameterizedTypeSelectNode node, Pair<ExpressionNode,List<BlockStatementNode>> p)
    {
        ExpressionNode factoryNode = p.getFirst();
        List<BlockStatementNode> statements = p.getSecond();

        String liftBaseVarName = 
                node.getBase().executeOperation(this,p);
        String liftSelectVarName = 
                node.getSelect().executeOperation(this,p);

        String myVarName = getUniqueName();
        statements.add(
                factory.makeVariableDeclarationNode(
                        factory.makeVariableModifiersNode(
                                false,
                                factory.makeListNode(Collections.<AnnotationNode>emptyList())),
                factory.makeListNode(
                        Collections.singletonList(
                                factory.makeVariableDeclaratorNode(
                                        factory.makeUnparameterizedTypeNode(
                                                factory.makeSimpleNameNode(
                                                        factory.makeIdentifierNode("ParameterizedTypeSelectNode"),
                                                        NameCategory.TYPE)),
                                        factory.makeIdentifierNode(myVarName),
                                        factory.makeMethodInvocationByExpressionNode(
                                                factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                                                factory.makeIdentifierNode("makeParameterizedTypeSelectNode"),
                                                factory.makeListNode(
                                                        Arrays.<ExpressionNode>asList(
                                                                factory.makeFieldAccessByNameNode(factory.makeSimpleNameNode(factory.makeIdentifierNode(
                                                                        liftBaseVarName),NameCategory.EXPRESSION)),
                                                                factory.makeFieldAccessByNameNode(factory.makeSimpleNameNode(factory.makeIdentifierNode(
                                                                        liftSelectVarName),NameCategory.EXPRESSION))
                                                                )),
                                                factory.makeListNode(Collections.<TypeNode>emptyList()))
            )))));

        return myVarName;
    }

    @Override
    public String executeIdentifierNode(IdentifierNode node, Pair<ExpressionNode,List<BlockStatementNode>> p)
    {
        ExpressionNode factoryNode = p.getFirst();
        List<BlockStatementNode> statements = p.getSecond();

        String liftIdentifierValue = 
                node.getIdentifier();

        String myVarName = getUniqueName();
        statements.add(
                factory.makeVariableDeclarationNode(
                        factory.makeVariableModifiersNode(
                                false,
                                factory.makeListNode(Collections.<AnnotationNode>emptyList())),
                factory.makeListNode(
                        Collections.singletonList(
                                factory.makeVariableDeclaratorNode(
                                        factory.makeUnparameterizedTypeNode(
                                                factory.makeSimpleNameNode(
                                                        factory.makeIdentifierNode("IdentifierNode"),
                                                        NameCategory.TYPE)),
                                        factory.makeIdentifierNode(myVarName),
                                        factory.makeMethodInvocationByExpressionNode(
                                                factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                                                factory.makeIdentifierNode("makeIdentifierNode"),
                                                factory.makeListNode(
                                                        Arrays.<ExpressionNode>asList(
                                                                expressionizeString(liftIdentifierValue)
                                                                )),
                                                factory.makeListNode(Collections.<TypeNode>emptyList()))
            )))));

        return myVarName;
    }

    @Override
    public String executeArrayTypeNode(ArrayTypeNode node, Pair<ExpressionNode,List<BlockStatementNode>> p)
    {
        ExpressionNode factoryNode = p.getFirst();
        List<BlockStatementNode> statements = p.getSecond();

        String liftTypeVarName = 
                node.getType().executeOperation(this,p);

        String myVarName = getUniqueName();
        statements.add(
                factory.makeVariableDeclarationNode(
                        factory.makeVariableModifiersNode(
                                false,
                                factory.makeListNode(Collections.<AnnotationNode>emptyList())),
                factory.makeListNode(
                        Collections.singletonList(
                                factory.makeVariableDeclaratorNode(
                                        factory.makeUnparameterizedTypeNode(
                                                factory.makeSimpleNameNode(
                                                        factory.makeIdentifierNode("ArrayTypeNode"),
                                                        NameCategory.TYPE)),
                                        factory.makeIdentifierNode(myVarName),
                                        factory.makeMethodInvocationByExpressionNode(
                                                factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                                                factory.makeIdentifierNode("makeArrayTypeNode"),
                                                factory.makeListNode(
                                                        Arrays.<ExpressionNode>asList(
                                                                factory.makeFieldAccessByNameNode(factory.makeSimpleNameNode(factory.makeIdentifierNode(
                                                                        liftTypeVarName),NameCategory.EXPRESSION))
                                                                )),
                                                factory.makeListNode(Collections.<TypeNode>emptyList()))
            )))));

        return myVarName;
    }

    @Override
    public String executeArrayInitializerCreationNode(ArrayInitializerCreationNode node, Pair<ExpressionNode,List<BlockStatementNode>> p)
    {
        ExpressionNode factoryNode = p.getFirst();
        List<BlockStatementNode> statements = p.getSecond();

        String liftInitializerVarName = 
                node.getInitializer().executeOperation(this,p);
        String liftBaseTypeVarName = 
                node.getBaseType().executeOperation(this,p);
        int liftArrayLevelsValue = 
                node.getArrayLevels();

        String myVarName = getUniqueName();
        statements.add(
                factory.makeVariableDeclarationNode(
                        factory.makeVariableModifiersNode(
                                false,
                                factory.makeListNode(Collections.<AnnotationNode>emptyList())),
                factory.makeListNode(
                        Collections.singletonList(
                                factory.makeVariableDeclaratorNode(
                                        factory.makeUnparameterizedTypeNode(
                                                factory.makeSimpleNameNode(
                                                        factory.makeIdentifierNode("ArrayInitializerCreationNode"),
                                                        NameCategory.TYPE)),
                                        factory.makeIdentifierNode(myVarName),
                                        factory.makeMethodInvocationByExpressionNode(
                                                factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                                                factory.makeIdentifierNode("makeArrayInitializerCreationNode"),
                                                factory.makeListNode(
                                                        Arrays.<ExpressionNode>asList(
                                                                factory.makeFieldAccessByNameNode(factory.makeSimpleNameNode(factory.makeIdentifierNode(
                                                                        liftInitializerVarName),NameCategory.EXPRESSION)),
                                                                factory.makeFieldAccessByNameNode(factory.makeSimpleNameNode(factory.makeIdentifierNode(
                                                                        liftBaseTypeVarName),NameCategory.EXPRESSION)),
                                                                expressionizeInt(liftArrayLevelsValue)
                                                                )),
                                                factory.makeListNode(Collections.<TypeNode>emptyList()))
            )))));

        return myVarName;
    }

    @Override
    public String executeFieldModifiersNode(FieldModifiersNode node, Pair<ExpressionNode,List<BlockStatementNode>> p)
    {
        ExpressionNode factoryNode = p.getFirst();
        List<BlockStatementNode> statements = p.getSecond();

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
        String liftAnnotationsVarName = 
                node.getAnnotations().executeOperation(this,p);

        String myVarName = getUniqueName();
        statements.add(
                factory.makeVariableDeclarationNode(
                        factory.makeVariableModifiersNode(
                                false,
                                factory.makeListNode(Collections.<AnnotationNode>emptyList())),
                factory.makeListNode(
                        Collections.singletonList(
                                factory.makeVariableDeclaratorNode(
                                        factory.makeUnparameterizedTypeNode(
                                                factory.makeSimpleNameNode(
                                                        factory.makeIdentifierNode("FieldModifiersNode"),
                                                        NameCategory.TYPE)),
                                        factory.makeIdentifierNode(myVarName),
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
                                                                factory.makeFieldAccessByNameNode(factory.makeSimpleNameNode(factory.makeIdentifierNode(
                                                                        liftAnnotationsVarName),NameCategory.EXPRESSION))
                                                                )),
                                                factory.makeListNode(Collections.<TypeNode>emptyList()))
            )))));

        return myVarName;
    }

    @Override
    public String executeTypeParameterNode(TypeParameterNode node, Pair<ExpressionNode,List<BlockStatementNode>> p)
    {
        ExpressionNode factoryNode = p.getFirst();
        List<BlockStatementNode> statements = p.getSecond();

        String liftIdentifierVarName = 
                node.getIdentifier().executeOperation(this,p);
        String liftBoundsVarName = 
                node.getBounds().executeOperation(this,p);

        String myVarName = getUniqueName();
        statements.add(
                factory.makeVariableDeclarationNode(
                        factory.makeVariableModifiersNode(
                                false,
                                factory.makeListNode(Collections.<AnnotationNode>emptyList())),
                factory.makeListNode(
                        Collections.singletonList(
                                factory.makeVariableDeclaratorNode(
                                        factory.makeUnparameterizedTypeNode(
                                                factory.makeSimpleNameNode(
                                                        factory.makeIdentifierNode("TypeParameterNode"),
                                                        NameCategory.TYPE)),
                                        factory.makeIdentifierNode(myVarName),
                                        factory.makeMethodInvocationByExpressionNode(
                                                factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                                                factory.makeIdentifierNode("makeTypeParameterNode"),
                                                factory.makeListNode(
                                                        Arrays.<ExpressionNode>asList(
                                                                factory.makeFieldAccessByNameNode(factory.makeSimpleNameNode(factory.makeIdentifierNode(
                                                                        liftIdentifierVarName),NameCategory.EXPRESSION)),
                                                                factory.makeFieldAccessByNameNode(factory.makeSimpleNameNode(factory.makeIdentifierNode(
                                                                        liftBoundsVarName),NameCategory.EXPRESSION))
                                                                )),
                                                factory.makeListNode(Collections.<TypeNode>emptyList()))
            )))));

        return myVarName;
    }

    @Override
    public String executeAnnotationMethodDeclarationNode(AnnotationMethodDeclarationNode node, Pair<ExpressionNode,List<BlockStatementNode>> p)
    {
        ExpressionNode factoryNode = p.getFirst();
        List<BlockStatementNode> statements = p.getSecond();

        String liftModifiersVarName = 
                node.getModifiers().executeOperation(this,p);
        String liftTypeVarName = 
                node.getType().executeOperation(this,p);
        String liftIdentifierVarName = 
                node.getIdentifier().executeOperation(this,p);
        String liftDefaultValueVarName = 
                node.getDefaultValue().executeOperation(this,p);
        String liftJavadocVarName = 
                node.getJavadoc().executeOperation(this,p);

        String myVarName = getUniqueName();
        statements.add(
                factory.makeVariableDeclarationNode(
                        factory.makeVariableModifiersNode(
                                false,
                                factory.makeListNode(Collections.<AnnotationNode>emptyList())),
                factory.makeListNode(
                        Collections.singletonList(
                                factory.makeVariableDeclaratorNode(
                                        factory.makeUnparameterizedTypeNode(
                                                factory.makeSimpleNameNode(
                                                        factory.makeIdentifierNode("AnnotationMethodDeclarationNode"),
                                                        NameCategory.TYPE)),
                                        factory.makeIdentifierNode(myVarName),
                                        factory.makeMethodInvocationByExpressionNode(
                                                factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                                                factory.makeIdentifierNode("makeAnnotationMethodDeclarationNode"),
                                                factory.makeListNode(
                                                        Arrays.<ExpressionNode>asList(
                                                                factory.makeFieldAccessByNameNode(factory.makeSimpleNameNode(factory.makeIdentifierNode(
                                                                        liftModifiersVarName),NameCategory.EXPRESSION)),
                                                                factory.makeFieldAccessByNameNode(factory.makeSimpleNameNode(factory.makeIdentifierNode(
                                                                        liftTypeVarName),NameCategory.EXPRESSION)),
                                                                factory.makeFieldAccessByNameNode(factory.makeSimpleNameNode(factory.makeIdentifierNode(
                                                                        liftIdentifierVarName),NameCategory.EXPRESSION)),
                                                                factory.makeFieldAccessByNameNode(factory.makeSimpleNameNode(factory.makeIdentifierNode(
                                                                        liftDefaultValueVarName),NameCategory.EXPRESSION)),
                                                                factory.makeFieldAccessByNameNode(factory.makeSimpleNameNode(factory.makeIdentifierNode(
                                                                        liftJavadocVarName),NameCategory.EXPRESSION))
                                                                )),
                                                factory.makeListNode(Collections.<TypeNode>emptyList()))
            )))));

        return myVarName;
    }

    @Override
    public String executeImportSingleTypeNode(ImportSingleTypeNode node, Pair<ExpressionNode,List<BlockStatementNode>> p)
    {
        ExpressionNode factoryNode = p.getFirst();
        List<BlockStatementNode> statements = p.getSecond();

        String liftNameVarName = 
                node.getName().executeOperation(this,p);
        boolean liftStaticImportValue = 
                node.getStaticImport();

        String myVarName = getUniqueName();
        statements.add(
                factory.makeVariableDeclarationNode(
                        factory.makeVariableModifiersNode(
                                false,
                                factory.makeListNode(Collections.<AnnotationNode>emptyList())),
                factory.makeListNode(
                        Collections.singletonList(
                                factory.makeVariableDeclaratorNode(
                                        factory.makeUnparameterizedTypeNode(
                                                factory.makeSimpleNameNode(
                                                        factory.makeIdentifierNode("ImportSingleTypeNode"),
                                                        NameCategory.TYPE)),
                                        factory.makeIdentifierNode(myVarName),
                                        factory.makeMethodInvocationByExpressionNode(
                                                factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                                                factory.makeIdentifierNode("makeImportSingleTypeNode"),
                                                factory.makeListNode(
                                                        Arrays.<ExpressionNode>asList(
                                                                factory.makeFieldAccessByNameNode(factory.makeSimpleNameNode(factory.makeIdentifierNode(
                                                                        liftNameVarName),NameCategory.EXPRESSION)),
                                                                expressionizeBoolean(liftStaticImportValue)
                                                                )),
                                                factory.makeListNode(Collections.<TypeNode>emptyList()))
            )))));

        return myVarName;
    }

    @Override
    public String executeFieldDeclarationNode(FieldDeclarationNode node, Pair<ExpressionNode,List<BlockStatementNode>> p)
    {
        ExpressionNode factoryNode = p.getFirst();
        List<BlockStatementNode> statements = p.getSecond();

        String liftModifiersVarName = 
                node.getModifiers().executeOperation(this,p);
        String liftDeclaratorsVarName = 
                node.getDeclarators().executeOperation(this,p);
        String liftJavadocVarName = 
                node.getJavadoc().executeOperation(this,p);

        String myVarName = getUniqueName();
        statements.add(
                factory.makeVariableDeclarationNode(
                        factory.makeVariableModifiersNode(
                                false,
                                factory.makeListNode(Collections.<AnnotationNode>emptyList())),
                factory.makeListNode(
                        Collections.singletonList(
                                factory.makeVariableDeclaratorNode(
                                        factory.makeUnparameterizedTypeNode(
                                                factory.makeSimpleNameNode(
                                                        factory.makeIdentifierNode("FieldDeclarationNode"),
                                                        NameCategory.TYPE)),
                                        factory.makeIdentifierNode(myVarName),
                                        factory.makeMethodInvocationByExpressionNode(
                                                factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                                                factory.makeIdentifierNode("makeFieldDeclarationNode"),
                                                factory.makeListNode(
                                                        Arrays.<ExpressionNode>asList(
                                                                factory.makeFieldAccessByNameNode(factory.makeSimpleNameNode(factory.makeIdentifierNode(
                                                                        liftModifiersVarName),NameCategory.EXPRESSION)),
                                                                factory.makeFieldAccessByNameNode(factory.makeSimpleNameNode(factory.makeIdentifierNode(
                                                                        liftDeclaratorsVarName),NameCategory.EXPRESSION)),
                                                                factory.makeFieldAccessByNameNode(factory.makeSimpleNameNode(factory.makeIdentifierNode(
                                                                        liftJavadocVarName),NameCategory.EXPRESSION))
                                                                )),
                                                factory.makeListNode(Collections.<TypeNode>emptyList()))
            )))));

        return myVarName;
    }

    @Override
    public String executeAnnotationArrayValueNode(AnnotationArrayValueNode node, Pair<ExpressionNode,List<BlockStatementNode>> p)
    {
        ExpressionNode factoryNode = p.getFirst();
        List<BlockStatementNode> statements = p.getSecond();

        String liftValuesVarName = 
                node.getValues().executeOperation(this,p);

        String myVarName = getUniqueName();
        statements.add(
                factory.makeVariableDeclarationNode(
                        factory.makeVariableModifiersNode(
                                false,
                                factory.makeListNode(Collections.<AnnotationNode>emptyList())),
                factory.makeListNode(
                        Collections.singletonList(
                                factory.makeVariableDeclaratorNode(
                                        factory.makeUnparameterizedTypeNode(
                                                factory.makeSimpleNameNode(
                                                        factory.makeIdentifierNode("AnnotationArrayValueNode"),
                                                        NameCategory.TYPE)),
                                        factory.makeIdentifierNode(myVarName),
                                        factory.makeMethodInvocationByExpressionNode(
                                                factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                                                factory.makeIdentifierNode("makeAnnotationArrayValueNode"),
                                                factory.makeListNode(
                                                        Arrays.<ExpressionNode>asList(
                                                                factory.makeFieldAccessByNameNode(factory.makeSimpleNameNode(factory.makeIdentifierNode(
                                                                        liftValuesVarName),NameCategory.EXPRESSION))
                                                                )),
                                                factory.makeListNode(Collections.<TypeNode>emptyList()))
            )))));

        return myVarName;
    }

    @Override
    public String executeSingleElementAnnotationNode(SingleElementAnnotationNode node, Pair<ExpressionNode,List<BlockStatementNode>> p)
    {
        ExpressionNode factoryNode = p.getFirst();
        List<BlockStatementNode> statements = p.getSecond();

        String liftValueVarName = 
                node.getValue().executeOperation(this,p);
        String liftAnnotationTypeVarName = 
                node.getAnnotationType().executeOperation(this,p);

        String myVarName = getUniqueName();
        statements.add(
                factory.makeVariableDeclarationNode(
                        factory.makeVariableModifiersNode(
                                false,
                                factory.makeListNode(Collections.<AnnotationNode>emptyList())),
                factory.makeListNode(
                        Collections.singletonList(
                                factory.makeVariableDeclaratorNode(
                                        factory.makeUnparameterizedTypeNode(
                                                factory.makeSimpleNameNode(
                                                        factory.makeIdentifierNode("SingleElementAnnotationNode"),
                                                        NameCategory.TYPE)),
                                        factory.makeIdentifierNode(myVarName),
                                        factory.makeMethodInvocationByExpressionNode(
                                                factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                                                factory.makeIdentifierNode("makeSingleElementAnnotationNode"),
                                                factory.makeListNode(
                                                        Arrays.<ExpressionNode>asList(
                                                                factory.makeFieldAccessByNameNode(factory.makeSimpleNameNode(factory.makeIdentifierNode(
                                                                        liftValueVarName),NameCategory.EXPRESSION)),
                                                                factory.makeFieldAccessByNameNode(factory.makeSimpleNameNode(factory.makeIdentifierNode(
                                                                        liftAnnotationTypeVarName),NameCategory.EXPRESSION))
                                                                )),
                                                factory.makeListNode(Collections.<TypeNode>emptyList()))
            )))));

        return myVarName;
    }

    @Override
    public String executeClassLiteralNode(ClassLiteralNode node, Pair<ExpressionNode,List<BlockStatementNode>> p)
    {
        ExpressionNode factoryNode = p.getFirst();
        List<BlockStatementNode> statements = p.getSecond();

        String liftValueVarName = 
                node.getValue().executeOperation(this,p);

        String myVarName = getUniqueName();
        statements.add(
                factory.makeVariableDeclarationNode(
                        factory.makeVariableModifiersNode(
                                false,
                                factory.makeListNode(Collections.<AnnotationNode>emptyList())),
                factory.makeListNode(
                        Collections.singletonList(
                                factory.makeVariableDeclaratorNode(
                                        factory.makeUnparameterizedTypeNode(
                                                factory.makeSimpleNameNode(
                                                        factory.makeIdentifierNode("ClassLiteralNode"),
                                                        NameCategory.TYPE)),
                                        factory.makeIdentifierNode(myVarName),
                                        factory.makeMethodInvocationByExpressionNode(
                                                factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                                                factory.makeIdentifierNode("makeClassLiteralNode"),
                                                factory.makeListNode(
                                                        Arrays.<ExpressionNode>asList(
                                                                factory.makeFieldAccessByNameNode(factory.makeSimpleNameNode(factory.makeIdentifierNode(
                                                                        liftValueVarName),NameCategory.EXPRESSION))
                                                                )),
                                                factory.makeListNode(Collections.<TypeNode>emptyList()))
            )))));

        return myVarName;
    }

    @Override
    public String executeSuperMethodInvocationNode(SuperMethodInvocationNode node, Pair<ExpressionNode,List<BlockStatementNode>> p)
    {
        ExpressionNode factoryNode = p.getFirst();
        List<BlockStatementNode> statements = p.getSecond();

        String liftTypeVarName = 
                node.getType().executeOperation(this,p);
        String liftIdentifierVarName = 
                node.getIdentifier().executeOperation(this,p);
        String liftArgumentsVarName = 
                node.getArguments().executeOperation(this,p);
        String liftTypeArgumentsVarName = 
                node.getTypeArguments().executeOperation(this,p);

        String myVarName = getUniqueName();
        statements.add(
                factory.makeVariableDeclarationNode(
                        factory.makeVariableModifiersNode(
                                false,
                                factory.makeListNode(Collections.<AnnotationNode>emptyList())),
                factory.makeListNode(
                        Collections.singletonList(
                                factory.makeVariableDeclaratorNode(
                                        factory.makeUnparameterizedTypeNode(
                                                factory.makeSimpleNameNode(
                                                        factory.makeIdentifierNode("SuperMethodInvocationNode"),
                                                        NameCategory.TYPE)),
                                        factory.makeIdentifierNode(myVarName),
                                        factory.makeMethodInvocationByExpressionNode(
                                                factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                                                factory.makeIdentifierNode("makeSuperMethodInvocationNode"),
                                                factory.makeListNode(
                                                        Arrays.<ExpressionNode>asList(
                                                                factory.makeFieldAccessByNameNode(factory.makeSimpleNameNode(factory.makeIdentifierNode(
                                                                        liftTypeVarName),NameCategory.EXPRESSION)),
                                                                factory.makeFieldAccessByNameNode(factory.makeSimpleNameNode(factory.makeIdentifierNode(
                                                                        liftIdentifierVarName),NameCategory.EXPRESSION)),
                                                                factory.makeFieldAccessByNameNode(factory.makeSimpleNameNode(factory.makeIdentifierNode(
                                                                        liftArgumentsVarName),NameCategory.EXPRESSION)),
                                                                factory.makeFieldAccessByNameNode(factory.makeSimpleNameNode(factory.makeIdentifierNode(
                                                                        liftTypeArgumentsVarName),NameCategory.EXPRESSION))
                                                                )),
                                                factory.makeListNode(Collections.<TypeNode>emptyList()))
            )))));

        return myVarName;
    }

    @Override
    public String executeClassModifiersNode(ClassModifiersNode node, Pair<ExpressionNode,List<BlockStatementNode>> p)
    {
        ExpressionNode factoryNode = p.getFirst();
        List<BlockStatementNode> statements = p.getSecond();

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
        String liftAnnotationsVarName = 
                node.getAnnotations().executeOperation(this,p);

        String myVarName = getUniqueName();
        statements.add(
                factory.makeVariableDeclarationNode(
                        factory.makeVariableModifiersNode(
                                false,
                                factory.makeListNode(Collections.<AnnotationNode>emptyList())),
                factory.makeListNode(
                        Collections.singletonList(
                                factory.makeVariableDeclaratorNode(
                                        factory.makeUnparameterizedTypeNode(
                                                factory.makeSimpleNameNode(
                                                        factory.makeIdentifierNode("ClassModifiersNode"),
                                                        NameCategory.TYPE)),
                                        factory.makeIdentifierNode(myVarName),
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
                                                                factory.makeFieldAccessByNameNode(factory.makeSimpleNameNode(factory.makeIdentifierNode(
                                                                        liftAnnotationsVarName),NameCategory.EXPRESSION))
                                                                )),
                                                factory.makeListNode(Collections.<TypeNode>emptyList()))
            )))));

        return myVarName;
    }

    @Override
    public String executeArrayInitializerNode(ArrayInitializerNode node, Pair<ExpressionNode,List<BlockStatementNode>> p)
    {
        ExpressionNode factoryNode = p.getFirst();
        List<BlockStatementNode> statements = p.getSecond();

        String liftInitializersVarName = 
                node.getInitializers().executeOperation(this,p);

        String myVarName = getUniqueName();
        statements.add(
                factory.makeVariableDeclarationNode(
                        factory.makeVariableModifiersNode(
                                false,
                                factory.makeListNode(Collections.<AnnotationNode>emptyList())),
                factory.makeListNode(
                        Collections.singletonList(
                                factory.makeVariableDeclaratorNode(
                                        factory.makeUnparameterizedTypeNode(
                                                factory.makeSimpleNameNode(
                                                        factory.makeIdentifierNode("ArrayInitializerNode"),
                                                        NameCategory.TYPE)),
                                        factory.makeIdentifierNode(myVarName),
                                        factory.makeMethodInvocationByExpressionNode(
                                                factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                                                factory.makeIdentifierNode("makeArrayInitializerNode"),
                                                factory.makeListNode(
                                                        Arrays.<ExpressionNode>asList(
                                                                factory.makeFieldAccessByNameNode(factory.makeSimpleNameNode(factory.makeIdentifierNode(
                                                                        liftInitializersVarName),NameCategory.EXPRESSION))
                                                                )),
                                                factory.makeListNode(Collections.<TypeNode>emptyList()))
            )))));

        return myVarName;
    }

    @Override
    public String executeAnnotationExpressionValueNode(AnnotationExpressionValueNode node, Pair<ExpressionNode,List<BlockStatementNode>> p)
    {
        ExpressionNode factoryNode = p.getFirst();
        List<BlockStatementNode> statements = p.getSecond();

        String liftExpressionVarName = 
                node.getExpression().executeOperation(this,p);

        String myVarName = getUniqueName();
        statements.add(
                factory.makeVariableDeclarationNode(
                        factory.makeVariableModifiersNode(
                                false,
                                factory.makeListNode(Collections.<AnnotationNode>emptyList())),
                factory.makeListNode(
                        Collections.singletonList(
                                factory.makeVariableDeclaratorNode(
                                        factory.makeUnparameterizedTypeNode(
                                                factory.makeSimpleNameNode(
                                                        factory.makeIdentifierNode("AnnotationExpressionValueNode"),
                                                        NameCategory.TYPE)),
                                        factory.makeIdentifierNode(myVarName),
                                        factory.makeMethodInvocationByExpressionNode(
                                                factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                                                factory.makeIdentifierNode("makeAnnotationExpressionValueNode"),
                                                factory.makeListNode(
                                                        Arrays.<ExpressionNode>asList(
                                                                factory.makeFieldAccessByNameNode(factory.makeSimpleNameNode(factory.makeIdentifierNode(
                                                                        liftExpressionVarName),NameCategory.EXPRESSION))
                                                                )),
                                                factory.makeListNode(Collections.<TypeNode>emptyList()))
            )))));

        return myVarName;
    }

    @Override
    public String executeReturnNode(ReturnNode node, Pair<ExpressionNode,List<BlockStatementNode>> p)
    {
        ExpressionNode factoryNode = p.getFirst();
        List<BlockStatementNode> statements = p.getSecond();

        String liftExpressionVarName = 
                node.getExpression().executeOperation(this,p);

        String myVarName = getUniqueName();
        statements.add(
                factory.makeVariableDeclarationNode(
                        factory.makeVariableModifiersNode(
                                false,
                                factory.makeListNode(Collections.<AnnotationNode>emptyList())),
                factory.makeListNode(
                        Collections.singletonList(
                                factory.makeVariableDeclaratorNode(
                                        factory.makeUnparameterizedTypeNode(
                                                factory.makeSimpleNameNode(
                                                        factory.makeIdentifierNode("ReturnNode"),
                                                        NameCategory.TYPE)),
                                        factory.makeIdentifierNode(myVarName),
                                        factory.makeMethodInvocationByExpressionNode(
                                                factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                                                factory.makeIdentifierNode("makeReturnNode"),
                                                factory.makeListNode(
                                                        Arrays.<ExpressionNode>asList(
                                                                factory.makeFieldAccessByNameNode(factory.makeSimpleNameNode(factory.makeIdentifierNode(
                                                                        liftExpressionVarName),NameCategory.EXPRESSION))
                                                                )),
                                                factory.makeListNode(Collections.<TypeNode>emptyList()))
            )))));

        return myVarName;
    }

    @Override
    public String executeAssignmentNode(AssignmentNode node, Pair<ExpressionNode,List<BlockStatementNode>> p)
    {
        ExpressionNode factoryNode = p.getFirst();
        List<BlockStatementNode> statements = p.getSecond();

        String liftVariableVarName = 
                node.getVariable().executeOperation(this,p);
        AssignmentOperator liftOperatorValue = 
                node.getOperator();
        String liftExpressionVarName = 
                node.getExpression().executeOperation(this,p);

        String myVarName = getUniqueName();
        statements.add(
                factory.makeVariableDeclarationNode(
                        factory.makeVariableModifiersNode(
                                false,
                                factory.makeListNode(Collections.<AnnotationNode>emptyList())),
                factory.makeListNode(
                        Collections.singletonList(
                                factory.makeVariableDeclaratorNode(
                                        factory.makeUnparameterizedTypeNode(
                                                factory.makeSimpleNameNode(
                                                        factory.makeIdentifierNode("AssignmentNode"),
                                                        NameCategory.TYPE)),
                                        factory.makeIdentifierNode(myVarName),
                                        factory.makeMethodInvocationByExpressionNode(
                                                factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                                                factory.makeIdentifierNode("makeAssignmentNode"),
                                                factory.makeListNode(
                                                        Arrays.<ExpressionNode>asList(
                                                                factory.makeFieldAccessByNameNode(factory.makeSimpleNameNode(factory.makeIdentifierNode(
                                                                        liftVariableVarName),NameCategory.EXPRESSION)),
                                                                expressionizeAssignmentOperator(liftOperatorValue),
                                                                factory.makeFieldAccessByNameNode(factory.makeSimpleNameNode(factory.makeIdentifierNode(
                                                                        liftExpressionVarName),NameCategory.EXPRESSION))
                                                                )),
                                                factory.makeListNode(Collections.<TypeNode>emptyList()))
            )))));

        return myVarName;
    }

    @Override
    public String executeMethodInvocationByExpressionNode(MethodInvocationByExpressionNode node, Pair<ExpressionNode,List<BlockStatementNode>> p)
    {
        ExpressionNode factoryNode = p.getFirst();
        List<BlockStatementNode> statements = p.getSecond();

        String liftExpressionVarName = 
                node.getExpression().executeOperation(this,p);
        String liftIdentifierVarName = 
                node.getIdentifier().executeOperation(this,p);
        String liftArgumentsVarName = 
                node.getArguments().executeOperation(this,p);
        String liftTypeArgumentsVarName = 
                node.getTypeArguments().executeOperation(this,p);

        String myVarName = getUniqueName();
        statements.add(
                factory.makeVariableDeclarationNode(
                        factory.makeVariableModifiersNode(
                                false,
                                factory.makeListNode(Collections.<AnnotationNode>emptyList())),
                factory.makeListNode(
                        Collections.singletonList(
                                factory.makeVariableDeclaratorNode(
                                        factory.makeUnparameterizedTypeNode(
                                                factory.makeSimpleNameNode(
                                                        factory.makeIdentifierNode("MethodInvocationByExpressionNode"),
                                                        NameCategory.TYPE)),
                                        factory.makeIdentifierNode(myVarName),
                                        factory.makeMethodInvocationByExpressionNode(
                                                factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                                                factory.makeIdentifierNode("makeMethodInvocationByExpressionNode"),
                                                factory.makeListNode(
                                                        Arrays.<ExpressionNode>asList(
                                                                factory.makeFieldAccessByNameNode(factory.makeSimpleNameNode(factory.makeIdentifierNode(
                                                                        liftExpressionVarName),NameCategory.EXPRESSION)),
                                                                factory.makeFieldAccessByNameNode(factory.makeSimpleNameNode(factory.makeIdentifierNode(
                                                                        liftIdentifierVarName),NameCategory.EXPRESSION)),
                                                                factory.makeFieldAccessByNameNode(factory.makeSimpleNameNode(factory.makeIdentifierNode(
                                                                        liftArgumentsVarName),NameCategory.EXPRESSION)),
                                                                factory.makeFieldAccessByNameNode(factory.makeSimpleNameNode(factory.makeIdentifierNode(
                                                                        liftTypeArgumentsVarName),NameCategory.EXPRESSION))
                                                                )),
                                                factory.makeListNode(Collections.<TypeNode>emptyList()))
            )))));

        return myVarName;
    }

    @Override
    public String executeInstanceOfNode(InstanceOfNode node, Pair<ExpressionNode,List<BlockStatementNode>> p)
    {
        ExpressionNode factoryNode = p.getFirst();
        List<BlockStatementNode> statements = p.getSecond();

        String liftExpressionVarName = 
                node.getExpression().executeOperation(this,p);
        String liftTypeVarName = 
                node.getType().executeOperation(this,p);

        String myVarName = getUniqueName();
        statements.add(
                factory.makeVariableDeclarationNode(
                        factory.makeVariableModifiersNode(
                                false,
                                factory.makeListNode(Collections.<AnnotationNode>emptyList())),
                factory.makeListNode(
                        Collections.singletonList(
                                factory.makeVariableDeclaratorNode(
                                        factory.makeUnparameterizedTypeNode(
                                                factory.makeSimpleNameNode(
                                                        factory.makeIdentifierNode("InstanceOfNode"),
                                                        NameCategory.TYPE)),
                                        factory.makeIdentifierNode(myVarName),
                                        factory.makeMethodInvocationByExpressionNode(
                                                factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                                                factory.makeIdentifierNode("makeInstanceOfNode"),
                                                factory.makeListNode(
                                                        Arrays.<ExpressionNode>asList(
                                                                factory.makeFieldAccessByNameNode(factory.makeSimpleNameNode(factory.makeIdentifierNode(
                                                                        liftExpressionVarName),NameCategory.EXPRESSION)),
                                                                factory.makeFieldAccessByNameNode(factory.makeSimpleNameNode(factory.makeIdentifierNode(
                                                                        liftTypeVarName),NameCategory.EXPRESSION))
                                                                )),
                                                factory.makeListNode(Collections.<TypeNode>emptyList()))
            )))));

        return myVarName;
    }

    @Override
    public String executeConditionalExpressionNode(ConditionalExpressionNode node, Pair<ExpressionNode,List<BlockStatementNode>> p)
    {
        ExpressionNode factoryNode = p.getFirst();
        List<BlockStatementNode> statements = p.getSecond();

        String liftConditionVarName = 
                node.getCondition().executeOperation(this,p);
        String liftTrueExpressionVarName = 
                node.getTrueExpression().executeOperation(this,p);
        String liftFalseExpressionVarName = 
                node.getFalseExpression().executeOperation(this,p);

        String myVarName = getUniqueName();
        statements.add(
                factory.makeVariableDeclarationNode(
                        factory.makeVariableModifiersNode(
                                false,
                                factory.makeListNode(Collections.<AnnotationNode>emptyList())),
                factory.makeListNode(
                        Collections.singletonList(
                                factory.makeVariableDeclaratorNode(
                                        factory.makeUnparameterizedTypeNode(
                                                factory.makeSimpleNameNode(
                                                        factory.makeIdentifierNode("ConditionalExpressionNode"),
                                                        NameCategory.TYPE)),
                                        factory.makeIdentifierNode(myVarName),
                                        factory.makeMethodInvocationByExpressionNode(
                                                factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                                                factory.makeIdentifierNode("makeConditionalExpressionNode"),
                                                factory.makeListNode(
                                                        Arrays.<ExpressionNode>asList(
                                                                factory.makeFieldAccessByNameNode(factory.makeSimpleNameNode(factory.makeIdentifierNode(
                                                                        liftConditionVarName),NameCategory.EXPRESSION)),
                                                                factory.makeFieldAccessByNameNode(factory.makeSimpleNameNode(factory.makeIdentifierNode(
                                                                        liftTrueExpressionVarName),NameCategory.EXPRESSION)),
                                                                factory.makeFieldAccessByNameNode(factory.makeSimpleNameNode(factory.makeIdentifierNode(
                                                                        liftFalseExpressionVarName),NameCategory.EXPRESSION))
                                                                )),
                                                factory.makeListNode(Collections.<TypeNode>emptyList()))
            )))));

        return myVarName;
    }

    @Override
    public String executeParenthesizedExpressionNode(ParenthesizedExpressionNode node, Pair<ExpressionNode,List<BlockStatementNode>> p)
    {
        ExpressionNode factoryNode = p.getFirst();
        List<BlockStatementNode> statements = p.getSecond();

        String liftExpressionVarName = 
                node.getExpression().executeOperation(this,p);

        String myVarName = getUniqueName();
        statements.add(
                factory.makeVariableDeclarationNode(
                        factory.makeVariableModifiersNode(
                                false,
                                factory.makeListNode(Collections.<AnnotationNode>emptyList())),
                factory.makeListNode(
                        Collections.singletonList(
                                factory.makeVariableDeclaratorNode(
                                        factory.makeUnparameterizedTypeNode(
                                                factory.makeSimpleNameNode(
                                                        factory.makeIdentifierNode("ParenthesizedExpressionNode"),
                                                        NameCategory.TYPE)),
                                        factory.makeIdentifierNode(myVarName),
                                        factory.makeMethodInvocationByExpressionNode(
                                                factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                                                factory.makeIdentifierNode("makeParenthesizedExpressionNode"),
                                                factory.makeListNode(
                                                        Arrays.<ExpressionNode>asList(
                                                                factory.makeFieldAccessByNameNode(factory.makeSimpleNameNode(factory.makeIdentifierNode(
                                                                        liftExpressionVarName),NameCategory.EXPRESSION))
                                                                )),
                                                factory.makeListNode(Collections.<TypeNode>emptyList()))
            )))));

        return myVarName;
    }

    @Override
    public String executeFloatLiteralNode(FloatLiteralNode node, Pair<ExpressionNode,List<BlockStatementNode>> p)
    {
        ExpressionNode factoryNode = p.getFirst();
        List<BlockStatementNode> statements = p.getSecond();

        Float liftValueValue = 
                node.getValue();

        String myVarName = getUniqueName();
        statements.add(
                factory.makeVariableDeclarationNode(
                        factory.makeVariableModifiersNode(
                                false,
                                factory.makeListNode(Collections.<AnnotationNode>emptyList())),
                factory.makeListNode(
                        Collections.singletonList(
                                factory.makeVariableDeclaratorNode(
                                        factory.makeUnparameterizedTypeNode(
                                                factory.makeSimpleNameNode(
                                                        factory.makeIdentifierNode("FloatLiteralNode"),
                                                        NameCategory.TYPE)),
                                        factory.makeIdentifierNode(myVarName),
                                        factory.makeMethodInvocationByExpressionNode(
                                                factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                                                factory.makeIdentifierNode("makeFloatLiteralNode"),
                                                factory.makeListNode(
                                                        Arrays.<ExpressionNode>asList(
                                                                expressionizeFloat(liftValueValue)
                                                                )),
                                                factory.makeListNode(Collections.<TypeNode>emptyList()))
            )))));

        return myVarName;
    }

    @Override
    public String executeMethodInvocationByNameNode(MethodInvocationByNameNode node, Pair<ExpressionNode,List<BlockStatementNode>> p)
    {
        ExpressionNode factoryNode = p.getFirst();
        List<BlockStatementNode> statements = p.getSecond();

        String liftNameVarName = 
                node.getName().executeOperation(this,p);
        String liftArgumentsVarName = 
                node.getArguments().executeOperation(this,p);
        String liftTypeArgumentsVarName = 
                node.getTypeArguments().executeOperation(this,p);

        String myVarName = getUniqueName();
        statements.add(
                factory.makeVariableDeclarationNode(
                        factory.makeVariableModifiersNode(
                                false,
                                factory.makeListNode(Collections.<AnnotationNode>emptyList())),
                factory.makeListNode(
                        Collections.singletonList(
                                factory.makeVariableDeclaratorNode(
                                        factory.makeUnparameterizedTypeNode(
                                                factory.makeSimpleNameNode(
                                                        factory.makeIdentifierNode("MethodInvocationByNameNode"),
                                                        NameCategory.TYPE)),
                                        factory.makeIdentifierNode(myVarName),
                                        factory.makeMethodInvocationByExpressionNode(
                                                factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                                                factory.makeIdentifierNode("makeMethodInvocationByNameNode"),
                                                factory.makeListNode(
                                                        Arrays.<ExpressionNode>asList(
                                                                factory.makeFieldAccessByNameNode(factory.makeSimpleNameNode(factory.makeIdentifierNode(
                                                                        liftNameVarName),NameCategory.EXPRESSION)),
                                                                factory.makeFieldAccessByNameNode(factory.makeSimpleNameNode(factory.makeIdentifierNode(
                                                                        liftArgumentsVarName),NameCategory.EXPRESSION)),
                                                                factory.makeFieldAccessByNameNode(factory.makeSimpleNameNode(factory.makeIdentifierNode(
                                                                        liftTypeArgumentsVarName),NameCategory.EXPRESSION))
                                                                )),
                                                factory.makeListNode(Collections.<TypeNode>emptyList()))
            )))));

        return myVarName;
    }

    @Override
    public String executeParameterizedTypeNode(ParameterizedTypeNode node, Pair<ExpressionNode,List<BlockStatementNode>> p)
    {
        ExpressionNode factoryNode = p.getFirst();
        List<BlockStatementNode> statements = p.getSecond();

        String liftBaseTypeVarName = 
                node.getBaseType().executeOperation(this,p);
        String liftTypeArgumentsVarName = 
                node.getTypeArguments().executeOperation(this,p);

        String myVarName = getUniqueName();
        statements.add(
                factory.makeVariableDeclarationNode(
                        factory.makeVariableModifiersNode(
                                false,
                                factory.makeListNode(Collections.<AnnotationNode>emptyList())),
                factory.makeListNode(
                        Collections.singletonList(
                                factory.makeVariableDeclaratorNode(
                                        factory.makeUnparameterizedTypeNode(
                                                factory.makeSimpleNameNode(
                                                        factory.makeIdentifierNode("ParameterizedTypeNode"),
                                                        NameCategory.TYPE)),
                                        factory.makeIdentifierNode(myVarName),
                                        factory.makeMethodInvocationByExpressionNode(
                                                factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                                                factory.makeIdentifierNode("makeParameterizedTypeNode"),
                                                factory.makeListNode(
                                                        Arrays.<ExpressionNode>asList(
                                                                factory.makeFieldAccessByNameNode(factory.makeSimpleNameNode(factory.makeIdentifierNode(
                                                                        liftBaseTypeVarName),NameCategory.EXPRESSION)),
                                                                factory.makeFieldAccessByNameNode(factory.makeSimpleNameNode(factory.makeIdentifierNode(
                                                                        liftTypeArgumentsVarName),NameCategory.EXPRESSION))
                                                                )),
                                                factory.makeListNode(Collections.<TypeNode>emptyList()))
            )))));

        return myVarName;
    }

    @Override
    public String executeInterfaceDeclarationNode(InterfaceDeclarationNode node, Pair<ExpressionNode,List<BlockStatementNode>> p)
    {
        ExpressionNode factoryNode = p.getFirst();
        List<BlockStatementNode> statements = p.getSecond();

        String liftModifiersVarName = 
                node.getModifiers().executeOperation(this,p);
        String liftExtendsClauseVarName = 
                node.getExtendsClause().executeOperation(this,p);
        String liftBodyVarName = 
                node.getBody().executeOperation(this,p);
        String liftTypeParametersVarName = 
                node.getTypeParameters().executeOperation(this,p);
        String liftIdentifierVarName = 
                node.getIdentifier().executeOperation(this,p);
        String liftJavadocVarName = 
                node.getJavadoc().executeOperation(this,p);

        String myVarName = getUniqueName();
        statements.add(
                factory.makeVariableDeclarationNode(
                        factory.makeVariableModifiersNode(
                                false,
                                factory.makeListNode(Collections.<AnnotationNode>emptyList())),
                factory.makeListNode(
                        Collections.singletonList(
                                factory.makeVariableDeclaratorNode(
                                        factory.makeUnparameterizedTypeNode(
                                                factory.makeSimpleNameNode(
                                                        factory.makeIdentifierNode("InterfaceDeclarationNode"),
                                                        NameCategory.TYPE)),
                                        factory.makeIdentifierNode(myVarName),
                                        factory.makeMethodInvocationByExpressionNode(
                                                factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                                                factory.makeIdentifierNode("makeInterfaceDeclarationNode"),
                                                factory.makeListNode(
                                                        Arrays.<ExpressionNode>asList(
                                                                factory.makeFieldAccessByNameNode(factory.makeSimpleNameNode(factory.makeIdentifierNode(
                                                                        liftModifiersVarName),NameCategory.EXPRESSION)),
                                                                factory.makeFieldAccessByNameNode(factory.makeSimpleNameNode(factory.makeIdentifierNode(
                                                                        liftExtendsClauseVarName),NameCategory.EXPRESSION)),
                                                                factory.makeFieldAccessByNameNode(factory.makeSimpleNameNode(factory.makeIdentifierNode(
                                                                        liftBodyVarName),NameCategory.EXPRESSION)),
                                                                factory.makeFieldAccessByNameNode(factory.makeSimpleNameNode(factory.makeIdentifierNode(
                                                                        liftTypeParametersVarName),NameCategory.EXPRESSION)),
                                                                factory.makeFieldAccessByNameNode(factory.makeSimpleNameNode(factory.makeIdentifierNode(
                                                                        liftIdentifierVarName),NameCategory.EXPRESSION)),
                                                                factory.makeFieldAccessByNameNode(factory.makeSimpleNameNode(factory.makeIdentifierNode(
                                                                        liftJavadocVarName),NameCategory.EXPRESSION))
                                                                )),
                                                factory.makeListNode(Collections.<TypeNode>emptyList()))
            )))));

        return myVarName;
    }

    @Override
    public String executeForInitializerDeclarationNode(ForInitializerDeclarationNode node, Pair<ExpressionNode,List<BlockStatementNode>> p)
    {
        ExpressionNode factoryNode = p.getFirst();
        List<BlockStatementNode> statements = p.getSecond();

        String liftDeclarationVarName = 
                node.getDeclaration().executeOperation(this,p);

        String myVarName = getUniqueName();
        statements.add(
                factory.makeVariableDeclarationNode(
                        factory.makeVariableModifiersNode(
                                false,
                                factory.makeListNode(Collections.<AnnotationNode>emptyList())),
                factory.makeListNode(
                        Collections.singletonList(
                                factory.makeVariableDeclaratorNode(
                                        factory.makeUnparameterizedTypeNode(
                                                factory.makeSimpleNameNode(
                                                        factory.makeIdentifierNode("ForInitializerDeclarationNode"),
                                                        NameCategory.TYPE)),
                                        factory.makeIdentifierNode(myVarName),
                                        factory.makeMethodInvocationByExpressionNode(
                                                factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                                                factory.makeIdentifierNode("makeForInitializerDeclarationNode"),
                                                factory.makeListNode(
                                                        Arrays.<ExpressionNode>asList(
                                                                factory.makeFieldAccessByNameNode(factory.makeSimpleNameNode(factory.makeIdentifierNode(
                                                                        liftDeclarationVarName),NameCategory.EXPRESSION))
                                                                )),
                                                factory.makeListNode(Collections.<TypeNode>emptyList()))
            )))));

        return myVarName;
    }

    @Override
    public String executeConstructorBodyNode(ConstructorBodyNode node, Pair<ExpressionNode,List<BlockStatementNode>> p)
    {
        ExpressionNode factoryNode = p.getFirst();
        List<BlockStatementNode> statements = p.getSecond();

        String liftConstructorInvocationVarName = 
                node.getConstructorInvocation().executeOperation(this,p);
        String liftStatementsVarName = 
                node.getStatements().executeOperation(this,p);

        String myVarName = getUniqueName();
        statements.add(
                factory.makeVariableDeclarationNode(
                        factory.makeVariableModifiersNode(
                                false,
                                factory.makeListNode(Collections.<AnnotationNode>emptyList())),
                factory.makeListNode(
                        Collections.singletonList(
                                factory.makeVariableDeclaratorNode(
                                        factory.makeUnparameterizedTypeNode(
                                                factory.makeSimpleNameNode(
                                                        factory.makeIdentifierNode("ConstructorBodyNode"),
                                                        NameCategory.TYPE)),
                                        factory.makeIdentifierNode(myVarName),
                                        factory.makeMethodInvocationByExpressionNode(
                                                factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                                                factory.makeIdentifierNode("makeConstructorBodyNode"),
                                                factory.makeListNode(
                                                        Arrays.<ExpressionNode>asList(
                                                                factory.makeFieldAccessByNameNode(factory.makeSimpleNameNode(factory.makeIdentifierNode(
                                                                        liftConstructorInvocationVarName),NameCategory.EXPRESSION)),
                                                                factory.makeFieldAccessByNameNode(factory.makeSimpleNameNode(factory.makeIdentifierNode(
                                                                        liftStatementsVarName),NameCategory.EXPRESSION))
                                                                )),
                                                factory.makeListNode(Collections.<TypeNode>emptyList()))
            )))));

        return myVarName;
    }

    @Override
    public String executeFieldAccessByNameNode(FieldAccessByNameNode node, Pair<ExpressionNode,List<BlockStatementNode>> p)
    {
        ExpressionNode factoryNode = p.getFirst();
        List<BlockStatementNode> statements = p.getSecond();

        String liftNameVarName = 
                node.getName().executeOperation(this,p);

        String myVarName = getUniqueName();
        statements.add(
                factory.makeVariableDeclarationNode(
                        factory.makeVariableModifiersNode(
                                false,
                                factory.makeListNode(Collections.<AnnotationNode>emptyList())),
                factory.makeListNode(
                        Collections.singletonList(
                                factory.makeVariableDeclaratorNode(
                                        factory.makeUnparameterizedTypeNode(
                                                factory.makeSimpleNameNode(
                                                        factory.makeIdentifierNode("FieldAccessByNameNode"),
                                                        NameCategory.TYPE)),
                                        factory.makeIdentifierNode(myVarName),
                                        factory.makeMethodInvocationByExpressionNode(
                                                factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                                                factory.makeIdentifierNode("makeFieldAccessByNameNode"),
                                                factory.makeListNode(
                                                        Arrays.<ExpressionNode>asList(
                                                                factory.makeFieldAccessByNameNode(factory.makeSimpleNameNode(factory.makeIdentifierNode(
                                                                        liftNameVarName),NameCategory.EXPRESSION))
                                                                )),
                                                factory.makeListNode(Collections.<TypeNode>emptyList()))
            )))));

        return myVarName;
    }

    @Override
    public String executeUnqualifiedClassInstantiationNode(UnqualifiedClassInstantiationNode node, Pair<ExpressionNode,List<BlockStatementNode>> p)
    {
        ExpressionNode factoryNode = p.getFirst();
        List<BlockStatementNode> statements = p.getSecond();

        String liftTypeVarName = 
                node.getType().executeOperation(this,p);
        String liftConstructorTypeArgumentsVarName = 
                node.getConstructorTypeArguments().executeOperation(this,p);
        String liftArgumentsVarName = 
                node.getArguments().executeOperation(this,p);
        String liftBodyVarName = 
                node.getBody().executeOperation(this,p);

        String myVarName = getUniqueName();
        statements.add(
                factory.makeVariableDeclarationNode(
                        factory.makeVariableModifiersNode(
                                false,
                                factory.makeListNode(Collections.<AnnotationNode>emptyList())),
                factory.makeListNode(
                        Collections.singletonList(
                                factory.makeVariableDeclaratorNode(
                                        factory.makeUnparameterizedTypeNode(
                                                factory.makeSimpleNameNode(
                                                        factory.makeIdentifierNode("UnqualifiedClassInstantiationNode"),
                                                        NameCategory.TYPE)),
                                        factory.makeIdentifierNode(myVarName),
                                        factory.makeMethodInvocationByExpressionNode(
                                                factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                                                factory.makeIdentifierNode("makeUnqualifiedClassInstantiationNode"),
                                                factory.makeListNode(
                                                        Arrays.<ExpressionNode>asList(
                                                                factory.makeFieldAccessByNameNode(factory.makeSimpleNameNode(factory.makeIdentifierNode(
                                                                        liftTypeVarName),NameCategory.EXPRESSION)),
                                                                factory.makeFieldAccessByNameNode(factory.makeSimpleNameNode(factory.makeIdentifierNode(
                                                                        liftConstructorTypeArgumentsVarName),NameCategory.EXPRESSION)),
                                                                factory.makeFieldAccessByNameNode(factory.makeSimpleNameNode(factory.makeIdentifierNode(
                                                                        liftArgumentsVarName),NameCategory.EXPRESSION)),
                                                                factory.makeFieldAccessByNameNode(factory.makeSimpleNameNode(factory.makeIdentifierNode(
                                                                        liftBodyVarName),NameCategory.EXPRESSION))
                                                                )),
                                                factory.makeListNode(Collections.<TypeNode>emptyList()))
            )))));

        return myVarName;
    }

    @Override
    public String executeSimpleNameNode(SimpleNameNode node, Pair<ExpressionNode,List<BlockStatementNode>> p)
    {
        ExpressionNode factoryNode = p.getFirst();
        List<BlockStatementNode> statements = p.getSecond();

        String liftIdentifierVarName = 
                node.getIdentifier().executeOperation(this,p);
        NameCategory liftCategoryValue = 
                node.getCategory();

        String myVarName = getUniqueName();
        statements.add(
                factory.makeVariableDeclarationNode(
                        factory.makeVariableModifiersNode(
                                false,
                                factory.makeListNode(Collections.<AnnotationNode>emptyList())),
                factory.makeListNode(
                        Collections.singletonList(
                                factory.makeVariableDeclaratorNode(
                                        factory.makeUnparameterizedTypeNode(
                                                factory.makeSimpleNameNode(
                                                        factory.makeIdentifierNode("SimpleNameNode"),
                                                        NameCategory.TYPE)),
                                        factory.makeIdentifierNode(myVarName),
                                        factory.makeMethodInvocationByExpressionNode(
                                                factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                                                factory.makeIdentifierNode("makeSimpleNameNode"),
                                                factory.makeListNode(
                                                        Arrays.<ExpressionNode>asList(
                                                                factory.makeFieldAccessByNameNode(factory.makeSimpleNameNode(factory.makeIdentifierNode(
                                                                        liftIdentifierVarName),NameCategory.EXPRESSION)),
                                                                expressionizeNameCategory(liftCategoryValue)
                                                                )),
                                                factory.makeListNode(Collections.<TypeNode>emptyList()))
            )))));

        return myVarName;
    }

    @Override
    public String executeArrayInstantiatorCreationNode(ArrayInstantiatorCreationNode node, Pair<ExpressionNode,List<BlockStatementNode>> p)
    {
        ExpressionNode factoryNode = p.getFirst();
        List<BlockStatementNode> statements = p.getSecond();

        String liftDimExpressionsVarName = 
                node.getDimExpressions().executeOperation(this,p);
        String liftBaseTypeVarName = 
                node.getBaseType().executeOperation(this,p);
        int liftArrayLevelsValue = 
                node.getArrayLevels();

        String myVarName = getUniqueName();
        statements.add(
                factory.makeVariableDeclarationNode(
                        factory.makeVariableModifiersNode(
                                false,
                                factory.makeListNode(Collections.<AnnotationNode>emptyList())),
                factory.makeListNode(
                        Collections.singletonList(
                                factory.makeVariableDeclaratorNode(
                                        factory.makeUnparameterizedTypeNode(
                                                factory.makeSimpleNameNode(
                                                        factory.makeIdentifierNode("ArrayInstantiatorCreationNode"),
                                                        NameCategory.TYPE)),
                                        factory.makeIdentifierNode(myVarName),
                                        factory.makeMethodInvocationByExpressionNode(
                                                factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                                                factory.makeIdentifierNode("makeArrayInstantiatorCreationNode"),
                                                factory.makeListNode(
                                                        Arrays.<ExpressionNode>asList(
                                                                factory.makeFieldAccessByNameNode(factory.makeSimpleNameNode(factory.makeIdentifierNode(
                                                                        liftDimExpressionsVarName),NameCategory.EXPRESSION)),
                                                                factory.makeFieldAccessByNameNode(factory.makeSimpleNameNode(factory.makeIdentifierNode(
                                                                        liftBaseTypeVarName),NameCategory.EXPRESSION)),
                                                                expressionizeInt(liftArrayLevelsValue)
                                                                )),
                                                factory.makeListNode(Collections.<TypeNode>emptyList()))
            )))));

        return myVarName;
    }

    @Override
    public String executeMethodModifiersNode(MethodModifiersNode node, Pair<ExpressionNode,List<BlockStatementNode>> p)
    {
        ExpressionNode factoryNode = p.getFirst();
        List<BlockStatementNode> statements = p.getSecond();

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
        String liftAnnotationsVarName = 
                node.getAnnotations().executeOperation(this,p);

        String myVarName = getUniqueName();
        statements.add(
                factory.makeVariableDeclarationNode(
                        factory.makeVariableModifiersNode(
                                false,
                                factory.makeListNode(Collections.<AnnotationNode>emptyList())),
                factory.makeListNode(
                        Collections.singletonList(
                                factory.makeVariableDeclaratorNode(
                                        factory.makeUnparameterizedTypeNode(
                                                factory.makeSimpleNameNode(
                                                        factory.makeIdentifierNode("MethodModifiersNode"),
                                                        NameCategory.TYPE)),
                                        factory.makeIdentifierNode(myVarName),
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
                                                                factory.makeFieldAccessByNameNode(factory.makeSimpleNameNode(factory.makeIdentifierNode(
                                                                        liftAnnotationsVarName),NameCategory.EXPRESSION))
                                                                )),
                                                factory.makeListNode(Collections.<TypeNode>emptyList()))
            )))));

        return myVarName;
    }

    @Override
    public String executeClassBodyNode(ClassBodyNode node, Pair<ExpressionNode,List<BlockStatementNode>> p)
    {
        ExpressionNode factoryNode = p.getFirst();
        List<BlockStatementNode> statements = p.getSecond();

        String liftMembersVarName = 
                node.getMembers().executeOperation(this,p);

        String myVarName = getUniqueName();
        statements.add(
                factory.makeVariableDeclarationNode(
                        factory.makeVariableModifiersNode(
                                false,
                                factory.makeListNode(Collections.<AnnotationNode>emptyList())),
                factory.makeListNode(
                        Collections.singletonList(
                                factory.makeVariableDeclaratorNode(
                                        factory.makeUnparameterizedTypeNode(
                                                factory.makeSimpleNameNode(
                                                        factory.makeIdentifierNode("ClassBodyNode"),
                                                        NameCategory.TYPE)),
                                        factory.makeIdentifierNode(myVarName),
                                        factory.makeMethodInvocationByExpressionNode(
                                                factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                                                factory.makeIdentifierNode("makeClassBodyNode"),
                                                factory.makeListNode(
                                                        Arrays.<ExpressionNode>asList(
                                                                factory.makeFieldAccessByNameNode(factory.makeSimpleNameNode(factory.makeIdentifierNode(
                                                                        liftMembersVarName),NameCategory.EXPRESSION))
                                                                )),
                                                factory.makeListNode(Collections.<TypeNode>emptyList()))
            )))));

        return myVarName;
    }

    @Override
    public String executeIfNode(IfNode node, Pair<ExpressionNode,List<BlockStatementNode>> p)
    {
        ExpressionNode factoryNode = p.getFirst();
        List<BlockStatementNode> statements = p.getSecond();

        String liftConditionVarName = 
                node.getCondition().executeOperation(this,p);
        String liftThenStatementVarName = 
                node.getThenStatement().executeOperation(this,p);
        String liftElseStatementVarName = 
                node.getElseStatement().executeOperation(this,p);

        String myVarName = getUniqueName();
        statements.add(
                factory.makeVariableDeclarationNode(
                        factory.makeVariableModifiersNode(
                                false,
                                factory.makeListNode(Collections.<AnnotationNode>emptyList())),
                factory.makeListNode(
                        Collections.singletonList(
                                factory.makeVariableDeclaratorNode(
                                        factory.makeUnparameterizedTypeNode(
                                                factory.makeSimpleNameNode(
                                                        factory.makeIdentifierNode("IfNode"),
                                                        NameCategory.TYPE)),
                                        factory.makeIdentifierNode(myVarName),
                                        factory.makeMethodInvocationByExpressionNode(
                                                factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                                                factory.makeIdentifierNode("makeIfNode"),
                                                factory.makeListNode(
                                                        Arrays.<ExpressionNode>asList(
                                                                factory.makeFieldAccessByNameNode(factory.makeSimpleNameNode(factory.makeIdentifierNode(
                                                                        liftConditionVarName),NameCategory.EXPRESSION)),
                                                                factory.makeFieldAccessByNameNode(factory.makeSimpleNameNode(factory.makeIdentifierNode(
                                                                        liftThenStatementVarName),NameCategory.EXPRESSION)),
                                                                factory.makeFieldAccessByNameNode(factory.makeSimpleNameNode(factory.makeIdentifierNode(
                                                                        liftElseStatementVarName),NameCategory.EXPRESSION))
                                                                )),
                                                factory.makeListNode(Collections.<TypeNode>emptyList()))
            )))));

        return myVarName;
    }

    @Override
    public String executeIntLiteralNode(IntLiteralNode node, Pair<ExpressionNode,List<BlockStatementNode>> p)
    {
        ExpressionNode factoryNode = p.getFirst();
        List<BlockStatementNode> statements = p.getSecond();

        Integer liftValueValue = 
                node.getValue();

        String myVarName = getUniqueName();
        statements.add(
                factory.makeVariableDeclarationNode(
                        factory.makeVariableModifiersNode(
                                false,
                                factory.makeListNode(Collections.<AnnotationNode>emptyList())),
                factory.makeListNode(
                        Collections.singletonList(
                                factory.makeVariableDeclaratorNode(
                                        factory.makeUnparameterizedTypeNode(
                                                factory.makeSimpleNameNode(
                                                        factory.makeIdentifierNode("IntLiteralNode"),
                                                        NameCategory.TYPE)),
                                        factory.makeIdentifierNode(myVarName),
                                        factory.makeMethodInvocationByExpressionNode(
                                                factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                                                factory.makeIdentifierNode("makeIntLiteralNode"),
                                                factory.makeListNode(
                                                        Arrays.<ExpressionNode>asList(
                                                                expressionizeInteger(liftValueValue)
                                                                )),
                                                factory.makeListNode(Collections.<TypeNode>emptyList()))
            )))));

        return myVarName;
    }

    @Override
    public String executeNullLiteralNode(NullLiteralNode node, Pair<ExpressionNode,List<BlockStatementNode>> p)
    {
        ExpressionNode factoryNode = p.getFirst();
        List<BlockStatementNode> statements = p.getSecond();


        String myVarName = getUniqueName();
        statements.add(
                factory.makeVariableDeclarationNode(
                        factory.makeVariableModifiersNode(
                                false,
                                factory.makeListNode(Collections.<AnnotationNode>emptyList())),
                factory.makeListNode(
                        Collections.singletonList(
                                factory.makeVariableDeclaratorNode(
                                        factory.makeUnparameterizedTypeNode(
                                                factory.makeSimpleNameNode(
                                                        factory.makeIdentifierNode("NullLiteralNode"),
                                                        NameCategory.TYPE)),
                                        factory.makeIdentifierNode(myVarName),
                                        factory.makeMethodInvocationByExpressionNode(
                                                factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                                                factory.makeIdentifierNode("makeNullLiteralNode"),
                                                factory.makeListNode(
                                                        Arrays.<ExpressionNode>asList(
                                                                factory.makeNullLiteralNode(null)
                                                                )),
                                                factory.makeListNode(Collections.<TypeNode>emptyList()))
            )))));

        return myVarName;
    }

    @Override
    public String executeJavadocNode(JavadocNode node, Pair<ExpressionNode,List<BlockStatementNode>> p)
    {
        ExpressionNode factoryNode = p.getFirst();
        List<BlockStatementNode> statements = p.getSecond();

        String liftTextValue = 
                node.getText();

        String myVarName = getUniqueName();
        statements.add(
                factory.makeVariableDeclarationNode(
                        factory.makeVariableModifiersNode(
                                false,
                                factory.makeListNode(Collections.<AnnotationNode>emptyList())),
                factory.makeListNode(
                        Collections.singletonList(
                                factory.makeVariableDeclaratorNode(
                                        factory.makeUnparameterizedTypeNode(
                                                factory.makeSimpleNameNode(
                                                        factory.makeIdentifierNode("JavadocNode"),
                                                        NameCategory.TYPE)),
                                        factory.makeIdentifierNode(myVarName),
                                        factory.makeMethodInvocationByExpressionNode(
                                                factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                                                factory.makeIdentifierNode("makeJavadocNode"),
                                                factory.makeListNode(
                                                        Arrays.<ExpressionNode>asList(
                                                                expressionizeString(liftTextValue)
                                                                )),
                                                factory.makeListNode(Collections.<TypeNode>emptyList()))
            )))));

        return myVarName;
    }

    @Override
    public String executeMethodDeclarationNode(MethodDeclarationNode node, Pair<ExpressionNode,List<BlockStatementNode>> p)
    {
        ExpressionNode factoryNode = p.getFirst();
        List<BlockStatementNode> statements = p.getSecond();

        String liftBodyVarName = 
                node.getBody().executeOperation(this,p);
        String liftModifiersVarName = 
                node.getModifiers().executeOperation(this,p);
        String liftIdentifierVarName = 
                node.getIdentifier().executeOperation(this,p);
        String liftParametersVarName = 
                node.getParameters().executeOperation(this,p);
        String liftVarargParameterVarName = 
                node.getVarargParameter().executeOperation(this,p);
        String liftReturnTypeVarName = 
                node.getReturnType().executeOperation(this,p);
        String liftThrowTypesVarName = 
                node.getThrowTypes().executeOperation(this,p);
        String liftTypeParametersVarName = 
                node.getTypeParameters().executeOperation(this,p);
        String liftJavadocVarName = 
                node.getJavadoc().executeOperation(this,p);

        String myVarName = getUniqueName();
        statements.add(
                factory.makeVariableDeclarationNode(
                        factory.makeVariableModifiersNode(
                                false,
                                factory.makeListNode(Collections.<AnnotationNode>emptyList())),
                factory.makeListNode(
                        Collections.singletonList(
                                factory.makeVariableDeclaratorNode(
                                        factory.makeUnparameterizedTypeNode(
                                                factory.makeSimpleNameNode(
                                                        factory.makeIdentifierNode("MethodDeclarationNode"),
                                                        NameCategory.TYPE)),
                                        factory.makeIdentifierNode(myVarName),
                                        factory.makeMethodInvocationByExpressionNode(
                                                factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                                                factory.makeIdentifierNode("makeMethodDeclarationNode"),
                                                factory.makeListNode(
                                                        Arrays.<ExpressionNode>asList(
                                                                factory.makeFieldAccessByNameNode(factory.makeSimpleNameNode(factory.makeIdentifierNode(
                                                                        liftBodyVarName),NameCategory.EXPRESSION)),
                                                                factory.makeFieldAccessByNameNode(factory.makeSimpleNameNode(factory.makeIdentifierNode(
                                                                        liftModifiersVarName),NameCategory.EXPRESSION)),
                                                                factory.makeFieldAccessByNameNode(factory.makeSimpleNameNode(factory.makeIdentifierNode(
                                                                        liftIdentifierVarName),NameCategory.EXPRESSION)),
                                                                factory.makeFieldAccessByNameNode(factory.makeSimpleNameNode(factory.makeIdentifierNode(
                                                                        liftParametersVarName),NameCategory.EXPRESSION)),
                                                                factory.makeFieldAccessByNameNode(factory.makeSimpleNameNode(factory.makeIdentifierNode(
                                                                        liftVarargParameterVarName),NameCategory.EXPRESSION)),
                                                                factory.makeFieldAccessByNameNode(factory.makeSimpleNameNode(factory.makeIdentifierNode(
                                                                        liftReturnTypeVarName),NameCategory.EXPRESSION)),
                                                                factory.makeFieldAccessByNameNode(factory.makeSimpleNameNode(factory.makeIdentifierNode(
                                                                        liftThrowTypesVarName),NameCategory.EXPRESSION)),
                                                                factory.makeFieldAccessByNameNode(factory.makeSimpleNameNode(factory.makeIdentifierNode(
                                                                        liftTypeParametersVarName),NameCategory.EXPRESSION)),
                                                                factory.makeFieldAccessByNameNode(factory.makeSimpleNameNode(factory.makeIdentifierNode(
                                                                        liftJavadocVarName),NameCategory.EXPRESSION))
                                                                )),
                                                factory.makeListNode(Collections.<TypeNode>emptyList()))
            )))));

        return myVarName;
    }

}
