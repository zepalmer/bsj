package edu.jhu.cs.bsj.compiler.impl.tool.compiler;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.AccessModifier;
import edu.jhu.cs.bsj.compiler.ast.AssignmentOperator;
import edu.jhu.cs.bsj.compiler.ast.BinaryOperator;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeOperation;
import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.MetaprogramLocalMode;
import edu.jhu.cs.bsj.compiler.ast.MetaprogramPackageMode;
import edu.jhu.cs.bsj.compiler.ast.NameCategory;
import edu.jhu.cs.bsj.compiler.ast.PrimitiveType;
import edu.jhu.cs.bsj.compiler.ast.UnaryOperator;
import edu.jhu.cs.bsj.compiler.ast.UnaryStatementOperator;
import edu.jhu.cs.bsj.compiler.ast.node.*;
import edu.jhu.cs.bsj.compiler.ast.node.meta.AnnotationMemberMetaprogramAnchorNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.AnonymousClassMemberMetaprogramAnchorNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.BlockStatementMetaprogramAnchorNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.ClassMemberMetaprogramAnchorNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.CodeLiteralNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.InterfaceMemberMetaprogramAnchorNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaAnnotationArrayValueNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaAnnotationElementListNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaAnnotationElementNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaAnnotationExpressionValueNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaAnnotationListNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaAnnotationMetaAnnotationValueNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaAnnotationMetaprogramAnchorNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaAnnotationNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaAnnotationValueListNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaAnnotationValueNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramDependencyDeclarationListNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramDependencyDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramDependencyListNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramDependencyNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramImportListNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramImportNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramPreambleNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramTargetListNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramTargetNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.NormalMetaAnnotationNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.SingleElementMetaAnnotationNode;
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
			return factory.makeNullLiteralNode();
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
			return factory.makeNullLiteralNode();
		} else
		{
			return factory.makeUnqualifiedClassInstantiationNode(
					factory.makeUnparameterizedTypeNode(factory.makeSimpleNameNode(
							factory.makeIdentifierNode("BsjSourceLocation"), NameCategory.TYPE)),
					factory.makeTypeArgumentListNode(),
					factory.makeExpressionListNode(
							factory.makeStringLiteralNode(location.getResourceName()),
							factory.makeIntLiteralNode(location.getLine()),
							factory.makeIntLiteralNode(location.getColumn())), null);
		}
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
        if (x == null)
        {
            return factory.makeNullLiteralNode();
        } else
        {
            return factory.makeFieldAccessByNameNode(factory.makeQualifiedNameNode(
                    factory.makeSimpleNameNode(
                            factory.makeIdentifierNode("PrimitiveType"),
                            NameCategory.EXPRESSION
                            ),
                    factory.makeIdentifierNode(x.name()),
                    NameCategory.EXPRESSION));
        }
    }
    
    protected ExpressionNode expressionizeUnaryStatementOperator(UnaryStatementOperator x)
    {
        if (x == null)
        {
            return factory.makeNullLiteralNode();
        } else
        {
            return factory.makeFieldAccessByNameNode(factory.makeQualifiedNameNode(
                    factory.makeSimpleNameNode(
                            factory.makeIdentifierNode("UnaryStatementOperator"),
                            NameCategory.EXPRESSION
                            ),
                    factory.makeIdentifierNode(x.name()),
                    NameCategory.EXPRESSION));
        }
    }
    
    protected ExpressionNode expressionizeAssignmentOperator(AssignmentOperator x)
    {
        if (x == null)
        {
            return factory.makeNullLiteralNode();
        } else
        {
            return factory.makeFieldAccessByNameNode(factory.makeQualifiedNameNode(
                    factory.makeSimpleNameNode(
                            factory.makeIdentifierNode("AssignmentOperator"),
                            NameCategory.EXPRESSION
                            ),
                    factory.makeIdentifierNode(x.name()),
                    NameCategory.EXPRESSION));
        }
    }
    
    protected ExpressionNode expressionizeBinaryOperator(BinaryOperator x)
    {
        if (x == null)
        {
            return factory.makeNullLiteralNode();
        } else
        {
            return factory.makeFieldAccessByNameNode(factory.makeQualifiedNameNode(
                    factory.makeSimpleNameNode(
                            factory.makeIdentifierNode("BinaryOperator"),
                            NameCategory.EXPRESSION
                            ),
                    factory.makeIdentifierNode(x.name()),
                    NameCategory.EXPRESSION));
        }
    }
    
    protected ExpressionNode expressionizeNameCategory(NameCategory x)
    {
        if (x == null)
        {
            return factory.makeNullLiteralNode();
        } else
        {
            return factory.makeFieldAccessByNameNode(factory.makeQualifiedNameNode(
                    factory.makeSimpleNameNode(
                            factory.makeIdentifierNode("NameCategory"),
                            NameCategory.EXPRESSION
                            ),
                    factory.makeIdentifierNode(x.name()),
                    NameCategory.EXPRESSION));
        }
    }
    
    protected ExpressionNode expressionizeUnaryOperator(UnaryOperator x)
    {
        if (x == null)
        {
            return factory.makeNullLiteralNode();
        } else
        {
            return factory.makeFieldAccessByNameNode(factory.makeQualifiedNameNode(
                    factory.makeSimpleNameNode(
                            factory.makeIdentifierNode("UnaryOperator"),
                            NameCategory.EXPRESSION
                            ),
                    factory.makeIdentifierNode(x.name()),
                    NameCategory.EXPRESSION));
        }
    }
    
    protected ExpressionNode expressionizeMetaprogramPackageMode(MetaprogramPackageMode x)
    {
        if (x == null)
        {
            return factory.makeNullLiteralNode();
        } else
        {
            return factory.makeFieldAccessByNameNode(factory.makeQualifiedNameNode(
                    factory.makeSimpleNameNode(
                            factory.makeIdentifierNode("MetaprogramPackageMode"),
                            NameCategory.EXPRESSION
                            ),
                    factory.makeIdentifierNode(x.name()),
                    NameCategory.EXPRESSION));
        }
    }
    
    protected ExpressionNode expressionizeMetaprogramLocalMode(MetaprogramLocalMode x)
    {
        if (x == null)
        {
            return factory.makeNullLiteralNode();
        } else
        {
            return factory.makeFieldAccessByNameNode(factory.makeQualifiedNameNode(
                    factory.makeSimpleNameNode(
                            factory.makeIdentifierNode("MetaprogramLocalMode"),
                            NameCategory.EXPRESSION
                            ),
                    factory.makeIdentifierNode(x.name()),
                    NameCategory.EXPRESSION));
        }
    }
    
    protected ExpressionNode expressionizeAccessModifier(AccessModifier x)
    {
        if (x == null)
        {
            return factory.makeNullLiteralNode();
        } else
        {
            return factory.makeFieldAccessByNameNode(factory.makeQualifiedNameNode(
                    factory.makeSimpleNameNode(
                            factory.makeIdentifierNode("AccessModifier"),
                            NameCategory.EXPRESSION
                            ),
                    factory.makeIdentifierNode(x.name()),
                    NameCategory.EXPRESSION));
        }
    }
    
    @Override
    public ExpressionNode executeAlternateConstructorInvocationNode(AlternateConstructorInvocationNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftArguments = 
                node.getArguments() != null ?
                        node.getArguments().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        ExpressionNode liftTypeArguments = 
                node.getTypeArguments() != null ?
                        node.getTypeArguments().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeAlternateConstructorInvocationNode"),
                        factory.makeExpressionListNode(
                                liftArguments,
                                liftTypeArguments,
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode(), factory.makeMetaAnnotationListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeAnnotationAnnotationValueNode(AnnotationAnnotationValueNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftAnnotation = 
                node.getAnnotation() != null ?
                        node.getAnnotation().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeAnnotationAnnotationValueNode"),
                        factory.makeExpressionListNode(
                                liftAnnotation,
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode(), factory.makeMetaAnnotationListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeAnnotationArrayValueNode(AnnotationArrayValueNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftValues = 
                node.getValues() != null ?
                        node.getValues().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeAnnotationArrayValueNode"),
                        factory.makeExpressionListNode(
                                liftValues,
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode(), factory.makeMetaAnnotationListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeAnnotationBodyNode(AnnotationBodyNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftMembers = 
                node.getMembers() != null ?
                        node.getMembers().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeAnnotationBodyNode"),
                        factory.makeExpressionListNode(
                                liftMembers,
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode(), factory.makeMetaAnnotationListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeAnnotationDeclarationNode(AnnotationDeclarationNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftModifiers = 
                node.getModifiers() != null ?
                        node.getModifiers().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        ExpressionNode liftBody = 
                node.getBody() != null ?
                        node.getBody().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        ExpressionNode liftIdentifier = 
                node.getIdentifier() != null ?
                        node.getIdentifier().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        ExpressionNode liftJavadoc = 
                node.getJavadoc() != null ?
                        node.getJavadoc().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeAnnotationDeclarationNode"),
                        factory.makeExpressionListNode(
                                liftModifiers,
                                liftBody,
                                liftIdentifier,
                                liftJavadoc,
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode(), factory.makeMetaAnnotationListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeAnnotationElementListNode(AnnotationElementListNode node, ExpressionNode factoryNode)
    {
        List<ExpressionNode> liftChildrenList = new ArrayList<ExpressionNode>();
        for (AnnotationElementNode listval : node.getChildren())
        {
            liftChildrenList.add(
                    listval != null ? 
        			        listval.executeOperation(this,factoryNode) :
                            null);
        }
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeAnnotationElementListNode"),
                        factory.makeExpressionListNode(
                                factory.makeMethodInvocationByNameNode(
                                        factory.makeQualifiedNameNode(
                                                factory.makeQualifiedNameNode(
                                                        factory.makeQualifiedNameNode(
                                                                factory.makeSimpleNameNode(
                                                                        factory.makeIdentifierNode("java"),
                                                                        NameCategory.PACKAGE),
                                                                factory.makeIdentifierNode("util"),
                                                                NameCategory.PACKAGE),
                                                        factory.makeIdentifierNode("Arrays"),
                                                        NameCategory.TYPE),
                                                factory.makeIdentifierNode("asList"),
                                                NameCategory.METHOD),
                                        factory.makeExpressionListNode(liftChildrenList),
                                        factory.makeReferenceTypeListNode(
                                                factory.makeUnparameterizedTypeNode(
                                                        factory.makeSimpleNameNode(
                                                                factory.makeIdentifierNode("AnnotationElementNode"),
                                                                NameCategory.TYPE)))),
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode(), factory.makeMetaAnnotationListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeAnnotationElementNode(AnnotationElementNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftIdentifier = 
                node.getIdentifier() != null ?
                        node.getIdentifier().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        ExpressionNode liftValue = 
                node.getValue() != null ?
                        node.getValue().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeAnnotationElementNode"),
                        factory.makeExpressionListNode(
                                liftIdentifier,
                                liftValue,
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode(), factory.makeMetaAnnotationListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeAnnotationExpressionValueNode(AnnotationExpressionValueNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftExpression = 
                node.getExpression() != null ?
                        node.getExpression().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeAnnotationExpressionValueNode"),
                        factory.makeExpressionListNode(
                                liftExpression,
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode(), factory.makeMetaAnnotationListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeAnnotationListNode(AnnotationListNode node, ExpressionNode factoryNode)
    {
        List<ExpressionNode> liftChildrenList = new ArrayList<ExpressionNode>();
        for (AnnotationNode listval : node.getChildren())
        {
            liftChildrenList.add(
                    listval != null ? 
        			        listval.executeOperation(this,factoryNode) :
                            null);
        }
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeAnnotationListNode"),
                        factory.makeExpressionListNode(
                                factory.makeMethodInvocationByNameNode(
                                        factory.makeQualifiedNameNode(
                                                factory.makeQualifiedNameNode(
                                                        factory.makeQualifiedNameNode(
                                                                factory.makeSimpleNameNode(
                                                                        factory.makeIdentifierNode("java"),
                                                                        NameCategory.PACKAGE),
                                                                factory.makeIdentifierNode("util"),
                                                                NameCategory.PACKAGE),
                                                        factory.makeIdentifierNode("Arrays"),
                                                        NameCategory.TYPE),
                                                factory.makeIdentifierNode("asList"),
                                                NameCategory.METHOD),
                                        factory.makeExpressionListNode(liftChildrenList),
                                        factory.makeReferenceTypeListNode(
                                                factory.makeUnparameterizedTypeNode(
                                                        factory.makeSimpleNameNode(
                                                                factory.makeIdentifierNode("AnnotationNode"),
                                                                NameCategory.TYPE)))),
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode(), factory.makeMetaAnnotationListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeAnnotationMemberListNode(AnnotationMemberListNode node, ExpressionNode factoryNode)
    {
        List<ExpressionNode> liftChildrenList = new ArrayList<ExpressionNode>();
        for (AnnotationMemberNode listval : node.getChildren())
        {
            liftChildrenList.add(
                    listval != null ? 
        			        listval.executeOperation(this,factoryNode) :
                            null);
        }
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeAnnotationMemberListNode"),
                        factory.makeExpressionListNode(
                                factory.makeMethodInvocationByNameNode(
                                        factory.makeQualifiedNameNode(
                                                factory.makeQualifiedNameNode(
                                                        factory.makeQualifiedNameNode(
                                                                factory.makeSimpleNameNode(
                                                                        factory.makeIdentifierNode("java"),
                                                                        NameCategory.PACKAGE),
                                                                factory.makeIdentifierNode("util"),
                                                                NameCategory.PACKAGE),
                                                        factory.makeIdentifierNode("Arrays"),
                                                        NameCategory.TYPE),
                                                factory.makeIdentifierNode("asList"),
                                                NameCategory.METHOD),
                                        factory.makeExpressionListNode(liftChildrenList),
                                        factory.makeReferenceTypeListNode(
                                                factory.makeUnparameterizedTypeNode(
                                                        factory.makeSimpleNameNode(
                                                                factory.makeIdentifierNode("AnnotationMemberNode"),
                                                                NameCategory.TYPE)))),
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode(), factory.makeMetaAnnotationListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeAnnotationMemberMetaprogramAnchorNode(AnnotationMemberMetaprogramAnchorNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftMetaprogram = 
                node.getMetaprogram() != null ?
                        node.getMetaprogram().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeAnnotationMemberMetaprogramAnchorNode"),
                        factory.makeExpressionListNode(
                                liftMetaprogram,
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode(), factory.makeMetaAnnotationListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeAnnotationMethodDeclarationNode(AnnotationMethodDeclarationNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftModifiers = 
                node.getModifiers() != null ?
                        node.getModifiers().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        ExpressionNode liftType = 
                node.getType() != null ?
                        node.getType().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        ExpressionNode liftIdentifier = 
                node.getIdentifier() != null ?
                        node.getIdentifier().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        ExpressionNode liftDefaultValue = 
                node.getDefaultValue() != null ?
                        node.getDefaultValue().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        ExpressionNode liftJavadoc = 
                node.getJavadoc() != null ?
                        node.getJavadoc().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeAnnotationMethodDeclarationNode"),
                        factory.makeExpressionListNode(
                                liftModifiers,
                                liftType,
                                liftIdentifier,
                                liftDefaultValue,
                                liftJavadoc,
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode(), factory.makeMetaAnnotationListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeAnnotationMethodModifiersNode(AnnotationMethodModifiersNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftMetaAnnotations = 
                node.getMetaAnnotations() != null ?
                        node.getMetaAnnotations().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        ExpressionNode liftAnnotations = 
                node.getAnnotations() != null ?
                        node.getAnnotations().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeAnnotationMethodModifiersNode"),
                        factory.makeExpressionListNode(
                                liftMetaAnnotations,
                                liftAnnotations,
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode(), factory.makeMetaAnnotationListNode());
        
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
        ExpressionNode liftMetaAnnotations = 
                node.getMetaAnnotations() != null ?
                        node.getMetaAnnotations().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        ExpressionNode liftAnnotations = 
                node.getAnnotations() != null ?
                        node.getAnnotations().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeAnnotationModifiersNode"),
                        factory.makeExpressionListNode(
                                expressionizeAccessModifier(liftAccessValue),
                                expressionizeBoolean(liftStaticFlagValue),
                                expressionizeBoolean(liftStrictfpFlagValue),
                                liftMetaAnnotations,
                                liftAnnotations,
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode(), factory.makeMetaAnnotationListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeAnnotationValueListNode(AnnotationValueListNode node, ExpressionNode factoryNode)
    {
        List<ExpressionNode> liftChildrenList = new ArrayList<ExpressionNode>();
        for (AnnotationValueNode listval : node.getChildren())
        {
            liftChildrenList.add(
                    listval != null ? 
        			        listval.executeOperation(this,factoryNode) :
                            null);
        }
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeAnnotationValueListNode"),
                        factory.makeExpressionListNode(
                                factory.makeMethodInvocationByNameNode(
                                        factory.makeQualifiedNameNode(
                                                factory.makeQualifiedNameNode(
                                                        factory.makeQualifiedNameNode(
                                                                factory.makeSimpleNameNode(
                                                                        factory.makeIdentifierNode("java"),
                                                                        NameCategory.PACKAGE),
                                                                factory.makeIdentifierNode("util"),
                                                                NameCategory.PACKAGE),
                                                        factory.makeIdentifierNode("Arrays"),
                                                        NameCategory.TYPE),
                                                factory.makeIdentifierNode("asList"),
                                                NameCategory.METHOD),
                                        factory.makeExpressionListNode(liftChildrenList),
                                        factory.makeReferenceTypeListNode(
                                                factory.makeUnparameterizedTypeNode(
                                                        factory.makeSimpleNameNode(
                                                                factory.makeIdentifierNode("AnnotationValueNode"),
                                                                NameCategory.TYPE)))),
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode(), factory.makeMetaAnnotationListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeAnonymousClassBodyNode(AnonymousClassBodyNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftMembers = 
                node.getMembers() != null ?
                        node.getMembers().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeAnonymousClassBodyNode"),
                        factory.makeExpressionListNode(
                                liftMembers,
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode(), factory.makeMetaAnnotationListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeAnonymousClassMemberListNode(AnonymousClassMemberListNode node, ExpressionNode factoryNode)
    {
        List<ExpressionNode> liftChildrenList = new ArrayList<ExpressionNode>();
        for (AnonymousClassMemberNode listval : node.getChildren())
        {
            liftChildrenList.add(
                    listval != null ? 
        			        listval.executeOperation(this,factoryNode) :
                            null);
        }
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeAnonymousClassMemberListNode"),
                        factory.makeExpressionListNode(
                                factory.makeMethodInvocationByNameNode(
                                        factory.makeQualifiedNameNode(
                                                factory.makeQualifiedNameNode(
                                                        factory.makeQualifiedNameNode(
                                                                factory.makeSimpleNameNode(
                                                                        factory.makeIdentifierNode("java"),
                                                                        NameCategory.PACKAGE),
                                                                factory.makeIdentifierNode("util"),
                                                                NameCategory.PACKAGE),
                                                        factory.makeIdentifierNode("Arrays"),
                                                        NameCategory.TYPE),
                                                factory.makeIdentifierNode("asList"),
                                                NameCategory.METHOD),
                                        factory.makeExpressionListNode(liftChildrenList),
                                        factory.makeReferenceTypeListNode(
                                                factory.makeUnparameterizedTypeNode(
                                                        factory.makeSimpleNameNode(
                                                                factory.makeIdentifierNode("AnonymousClassMemberNode"),
                                                                NameCategory.TYPE)))),
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode(), factory.makeMetaAnnotationListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeAnonymousClassMemberMetaprogramAnchorNode(AnonymousClassMemberMetaprogramAnchorNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftMetaprogram = 
                node.getMetaprogram() != null ?
                        node.getMetaprogram().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeAnonymousClassMemberMetaprogramAnchorNode"),
                        factory.makeExpressionListNode(
                                liftMetaprogram,
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode(), factory.makeMetaAnnotationListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeArrayAccessNode(ArrayAccessNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftArrayExpression = 
                node.getArrayExpression() != null ?
                        node.getArrayExpression().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        ExpressionNode liftIndexExpression = 
                node.getIndexExpression() != null ?
                        node.getIndexExpression().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeArrayAccessNode"),
                        factory.makeExpressionListNode(
                                liftArrayExpression,
                                liftIndexExpression,
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode(), factory.makeMetaAnnotationListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeArrayInitializerCreationNode(ArrayInitializerCreationNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftInitializer = 
                node.getInitializer() != null ?
                        node.getInitializer().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        ExpressionNode liftBaseType = 
                node.getBaseType() != null ?
                        node.getBaseType().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        int liftArrayLevelsValue = 
                node.getArrayLevels();
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeArrayInitializerCreationNode"),
                        factory.makeExpressionListNode(
                                liftInitializer,
                                liftBaseType,
                                expressionizeInt(liftArrayLevelsValue),
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode(), factory.makeMetaAnnotationListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeArrayInitializerNode(ArrayInitializerNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftInitializers = 
                node.getInitializers() != null ?
                        node.getInitializers().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeArrayInitializerNode"),
                        factory.makeExpressionListNode(
                                liftInitializers,
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode(), factory.makeMetaAnnotationListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeArrayInstantiatorCreationNode(ArrayInstantiatorCreationNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftDimExpressions = 
                node.getDimExpressions() != null ?
                        node.getDimExpressions().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        ExpressionNode liftBaseType = 
                node.getBaseType() != null ?
                        node.getBaseType().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        int liftArrayLevelsValue = 
                node.getArrayLevels();
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeArrayInstantiatorCreationNode"),
                        factory.makeExpressionListNode(
                                liftDimExpressions,
                                liftBaseType,
                                expressionizeInt(liftArrayLevelsValue),
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode(), factory.makeMetaAnnotationListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeArrayTypeNode(ArrayTypeNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftType = 
                node.getType() != null ?
                        node.getType().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeArrayTypeNode"),
                        factory.makeExpressionListNode(
                                liftType,
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode(), factory.makeMetaAnnotationListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeAssertStatementNode(AssertStatementNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftTestExpression = 
                node.getTestExpression() != null ?
                        node.getTestExpression().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        ExpressionNode liftMessageExpression = 
                node.getMessageExpression() != null ?
                        node.getMessageExpression().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeAssertStatementNode"),
                        factory.makeExpressionListNode(
                                liftTestExpression,
                                liftMessageExpression,
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode(), factory.makeMetaAnnotationListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeAssignmentNode(AssignmentNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftVariable = 
                node.getVariable() != null ?
                        node.getVariable().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        AssignmentOperator liftOperatorValue = 
                node.getOperator();
        ExpressionNode liftExpression = 
                node.getExpression() != null ?
                        node.getExpression().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        ExpressionNode liftMetaAnnotations = 
                node.getMetaAnnotations() != null ?
                        node.getMetaAnnotations().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeAssignmentNode"),
                        factory.makeExpressionListNode(
                                liftVariable,
                                expressionizeAssignmentOperator(liftOperatorValue),
                                liftExpression,
                                liftMetaAnnotations,
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode(), factory.makeMetaAnnotationListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeBinaryExpressionNode(BinaryExpressionNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftLeftOperand = 
                node.getLeftOperand() != null ?
                        node.getLeftOperand().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        ExpressionNode liftRightOperand = 
                node.getRightOperand() != null ?
                        node.getRightOperand().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        BinaryOperator liftOperatorValue = 
                node.getOperator();
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeBinaryExpressionNode"),
                        factory.makeExpressionListNode(
                                liftLeftOperand,
                                liftRightOperand,
                                expressionizeBinaryOperator(liftOperatorValue),
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode(), factory.makeMetaAnnotationListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeBlockNode(BlockNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftStatements = 
                node.getStatements() != null ?
                        node.getStatements().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeBlockNode"),
                        factory.makeExpressionListNode(
                                liftStatements,
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode(), factory.makeMetaAnnotationListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeBlockStatementListNode(BlockStatementListNode node, ExpressionNode factoryNode)
    {
        List<ExpressionNode> liftChildrenList = new ArrayList<ExpressionNode>();
        for (BlockStatementNode listval : node.getChildren())
        {
            liftChildrenList.add(
                    listval != null ? 
        			        listval.executeOperation(this,factoryNode) :
                            null);
        }
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeBlockStatementListNode"),
                        factory.makeExpressionListNode(
                                factory.makeMethodInvocationByNameNode(
                                        factory.makeQualifiedNameNode(
                                                factory.makeQualifiedNameNode(
                                                        factory.makeQualifiedNameNode(
                                                                factory.makeSimpleNameNode(
                                                                        factory.makeIdentifierNode("java"),
                                                                        NameCategory.PACKAGE),
                                                                factory.makeIdentifierNode("util"),
                                                                NameCategory.PACKAGE),
                                                        factory.makeIdentifierNode("Arrays"),
                                                        NameCategory.TYPE),
                                                factory.makeIdentifierNode("asList"),
                                                NameCategory.METHOD),
                                        factory.makeExpressionListNode(liftChildrenList),
                                        factory.makeReferenceTypeListNode(
                                                factory.makeUnparameterizedTypeNode(
                                                        factory.makeSimpleNameNode(
                                                                factory.makeIdentifierNode("BlockStatementNode"),
                                                                NameCategory.TYPE)))),
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode(), factory.makeMetaAnnotationListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeBlockStatementMetaprogramAnchorNode(BlockStatementMetaprogramAnchorNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftMetaprogram = 
                node.getMetaprogram() != null ?
                        node.getMetaprogram().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeBlockStatementMetaprogramAnchorNode"),
                        factory.makeExpressionListNode(
                                liftMetaprogram,
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode(), factory.makeMetaAnnotationListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeBooleanLiteralNode(BooleanLiteralNode node, ExpressionNode factoryNode)
    {
        Boolean liftValueValue = 
                node.getValue();
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeBooleanLiteralNode"),
                        factory.makeExpressionListNode(
                                expressionizeBoolean(liftValueValue),
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode(), factory.makeMetaAnnotationListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeBreakNode(BreakNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftLabel = 
                node.getLabel() != null ?
                        node.getLabel().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeBreakNode"),
                        factory.makeExpressionListNode(
                                liftLabel,
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode(), factory.makeMetaAnnotationListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeCaseListNode(CaseListNode node, ExpressionNode factoryNode)
    {
        List<ExpressionNode> liftChildrenList = new ArrayList<ExpressionNode>();
        for (CaseNode listval : node.getChildren())
        {
            liftChildrenList.add(
                    listval != null ? 
        			        listval.executeOperation(this,factoryNode) :
                            null);
        }
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeCaseListNode"),
                        factory.makeExpressionListNode(
                                factory.makeMethodInvocationByNameNode(
                                        factory.makeQualifiedNameNode(
                                                factory.makeQualifiedNameNode(
                                                        factory.makeQualifiedNameNode(
                                                                factory.makeSimpleNameNode(
                                                                        factory.makeIdentifierNode("java"),
                                                                        NameCategory.PACKAGE),
                                                                factory.makeIdentifierNode("util"),
                                                                NameCategory.PACKAGE),
                                                        factory.makeIdentifierNode("Arrays"),
                                                        NameCategory.TYPE),
                                                factory.makeIdentifierNode("asList"),
                                                NameCategory.METHOD),
                                        factory.makeExpressionListNode(liftChildrenList),
                                        factory.makeReferenceTypeListNode(
                                                factory.makeUnparameterizedTypeNode(
                                                        factory.makeSimpleNameNode(
                                                                factory.makeIdentifierNode("CaseNode"),
                                                                NameCategory.TYPE)))),
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode(), factory.makeMetaAnnotationListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeCaseNode(CaseNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftExpression = 
                node.getExpression() != null ?
                        node.getExpression().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        ExpressionNode liftStatements = 
                node.getStatements() != null ?
                        node.getStatements().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeCaseNode"),
                        factory.makeExpressionListNode(
                                liftExpression,
                                liftStatements,
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode(), factory.makeMetaAnnotationListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeCatchListNode(CatchListNode node, ExpressionNode factoryNode)
    {
        List<ExpressionNode> liftChildrenList = new ArrayList<ExpressionNode>();
        for (CatchNode listval : node.getChildren())
        {
            liftChildrenList.add(
                    listval != null ? 
        			        listval.executeOperation(this,factoryNode) :
                            null);
        }
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeCatchListNode"),
                        factory.makeExpressionListNode(
                                factory.makeMethodInvocationByNameNode(
                                        factory.makeQualifiedNameNode(
                                                factory.makeQualifiedNameNode(
                                                        factory.makeQualifiedNameNode(
                                                                factory.makeSimpleNameNode(
                                                                        factory.makeIdentifierNode("java"),
                                                                        NameCategory.PACKAGE),
                                                                factory.makeIdentifierNode("util"),
                                                                NameCategory.PACKAGE),
                                                        factory.makeIdentifierNode("Arrays"),
                                                        NameCategory.TYPE),
                                                factory.makeIdentifierNode("asList"),
                                                NameCategory.METHOD),
                                        factory.makeExpressionListNode(liftChildrenList),
                                        factory.makeReferenceTypeListNode(
                                                factory.makeUnparameterizedTypeNode(
                                                        factory.makeSimpleNameNode(
                                                                factory.makeIdentifierNode("CatchNode"),
                                                                NameCategory.TYPE)))),
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode(), factory.makeMetaAnnotationListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeCatchNode(CatchNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftBlock = 
                node.getBlock() != null ?
                        node.getBlock().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        ExpressionNode liftParameter = 
                node.getParameter() != null ?
                        node.getParameter().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeCatchNode"),
                        factory.makeExpressionListNode(
                                liftBlock,
                                liftParameter,
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode(), factory.makeMetaAnnotationListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeCharLiteralNode(CharLiteralNode node, ExpressionNode factoryNode)
    {
        Character liftValueValue = 
                node.getValue();
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeCharLiteralNode"),
                        factory.makeExpressionListNode(
                                expressionizeCharacter(liftValueValue),
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode(), factory.makeMetaAnnotationListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeClassBodyNode(ClassBodyNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftMembers = 
                node.getMembers() != null ?
                        node.getMembers().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeClassBodyNode"),
                        factory.makeExpressionListNode(
                                liftMembers,
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode(), factory.makeMetaAnnotationListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeClassDeclarationNode(ClassDeclarationNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftModifiers = 
                node.getModifiers() != null ?
                        node.getModifiers().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        ExpressionNode liftExtendsClause = 
                node.getExtendsClause() != null ?
                        node.getExtendsClause().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        ExpressionNode liftImplementsClause = 
                node.getImplementsClause() != null ?
                        node.getImplementsClause().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        ExpressionNode liftBody = 
                node.getBody() != null ?
                        node.getBody().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        ExpressionNode liftTypeParameters = 
                node.getTypeParameters() != null ?
                        node.getTypeParameters().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        ExpressionNode liftIdentifier = 
                node.getIdentifier() != null ?
                        node.getIdentifier().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        ExpressionNode liftJavadoc = 
                node.getJavadoc() != null ?
                        node.getJavadoc().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeClassDeclarationNode"),
                        factory.makeExpressionListNode(
                                liftModifiers,
                                liftExtendsClause,
                                liftImplementsClause,
                                liftBody,
                                liftTypeParameters,
                                liftIdentifier,
                                liftJavadoc,
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode(), factory.makeMetaAnnotationListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeClassLiteralNode(ClassLiteralNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftValue = 
                node.getValue() != null ?
                        node.getValue().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeClassLiteralNode"),
                        factory.makeExpressionListNode(
                                liftValue,
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode(), factory.makeMetaAnnotationListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeClassMemberListNode(ClassMemberListNode node, ExpressionNode factoryNode)
    {
        List<ExpressionNode> liftChildrenList = new ArrayList<ExpressionNode>();
        for (ClassMemberNode listval : node.getChildren())
        {
            liftChildrenList.add(
                    listval != null ? 
        			        listval.executeOperation(this,factoryNode) :
                            null);
        }
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeClassMemberListNode"),
                        factory.makeExpressionListNode(
                                factory.makeMethodInvocationByNameNode(
                                        factory.makeQualifiedNameNode(
                                                factory.makeQualifiedNameNode(
                                                        factory.makeQualifiedNameNode(
                                                                factory.makeSimpleNameNode(
                                                                        factory.makeIdentifierNode("java"),
                                                                        NameCategory.PACKAGE),
                                                                factory.makeIdentifierNode("util"),
                                                                NameCategory.PACKAGE),
                                                        factory.makeIdentifierNode("Arrays"),
                                                        NameCategory.TYPE),
                                                factory.makeIdentifierNode("asList"),
                                                NameCategory.METHOD),
                                        factory.makeExpressionListNode(liftChildrenList),
                                        factory.makeReferenceTypeListNode(
                                                factory.makeUnparameterizedTypeNode(
                                                        factory.makeSimpleNameNode(
                                                                factory.makeIdentifierNode("ClassMemberNode"),
                                                                NameCategory.TYPE)))),
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode(), factory.makeMetaAnnotationListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeClassMemberMetaprogramAnchorNode(ClassMemberMetaprogramAnchorNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftMetaprogram = 
                node.getMetaprogram() != null ?
                        node.getMetaprogram().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeClassMemberMetaprogramAnchorNode"),
                        factory.makeExpressionListNode(
                                liftMetaprogram,
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode(), factory.makeMetaAnnotationListNode());
        
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
        ExpressionNode liftMetaAnnotations = 
                node.getMetaAnnotations() != null ?
                        node.getMetaAnnotations().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        ExpressionNode liftAnnotations = 
                node.getAnnotations() != null ?
                        node.getAnnotations().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeClassModifiersNode"),
                        factory.makeExpressionListNode(
                                expressionizeAccessModifier(liftAccessValue),
                                expressionizeBoolean(liftAbstractFlagValue),
                                expressionizeBoolean(liftStaticFlagValue),
                                expressionizeBoolean(liftFinalFlagValue),
                                expressionizeBoolean(liftStrictfpFlagValue),
                                liftMetaAnnotations,
                                liftAnnotations,
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode(), factory.makeMetaAnnotationListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeCodeLiteralNode(CodeLiteralNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftValue = 
                node.getValue() != null ?
                        node.getValue().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeCodeLiteralNode"),
                        factory.makeExpressionListNode(
                                liftValue,
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode(), factory.makeMetaAnnotationListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeCompilationUnitNode(CompilationUnitNode node, ExpressionNode factoryNode)
    {
        String liftNameValue = 
                node.getName();
        ExpressionNode liftPackageDeclaration = 
                node.getPackageDeclaration() != null ?
                        node.getPackageDeclaration().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        ExpressionNode liftMetaimports = 
                node.getMetaimports() != null ?
                        node.getMetaimports().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        ExpressionNode liftImports = 
                node.getImports() != null ?
                        node.getImports().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        ExpressionNode liftTypeDecls = 
                node.getTypeDecls() != null ?
                        node.getTypeDecls().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeCompilationUnitNode"),
                        factory.makeExpressionListNode(
                                expressionizeString(liftNameValue),
                                liftPackageDeclaration,
                                liftMetaimports,
                                liftImports,
                                liftTypeDecls,
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode(), factory.makeMetaAnnotationListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeConditionalExpressionNode(ConditionalExpressionNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftCondition = 
                node.getCondition() != null ?
                        node.getCondition().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        ExpressionNode liftTrueExpression = 
                node.getTrueExpression() != null ?
                        node.getTrueExpression().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        ExpressionNode liftFalseExpression = 
                node.getFalseExpression() != null ?
                        node.getFalseExpression().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeConditionalExpressionNode"),
                        factory.makeExpressionListNode(
                                liftCondition,
                                liftTrueExpression,
                                liftFalseExpression,
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode(), factory.makeMetaAnnotationListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeConstructorBodyNode(ConstructorBodyNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftConstructorInvocation = 
                node.getConstructorInvocation() != null ?
                        node.getConstructorInvocation().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        ExpressionNode liftStatements = 
                node.getStatements() != null ?
                        node.getStatements().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeConstructorBodyNode"),
                        factory.makeExpressionListNode(
                                liftConstructorInvocation,
                                liftStatements,
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode(), factory.makeMetaAnnotationListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeConstructorDeclarationNode(ConstructorDeclarationNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftIdentifier = 
                node.getIdentifier() != null ?
                        node.getIdentifier().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        ExpressionNode liftBody = 
                node.getBody() != null ?
                        node.getBody().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        ExpressionNode liftModifiers = 
                node.getModifiers() != null ?
                        node.getModifiers().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        ExpressionNode liftParameters = 
                node.getParameters() != null ?
                        node.getParameters().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        ExpressionNode liftVarargParameter = 
                node.getVarargParameter() != null ?
                        node.getVarargParameter().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        ExpressionNode liftThrowTypes = 
                node.getThrowTypes() != null ?
                        node.getThrowTypes().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        ExpressionNode liftTypeParameters = 
                node.getTypeParameters() != null ?
                        node.getTypeParameters().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        ExpressionNode liftJavadoc = 
                node.getJavadoc() != null ?
                        node.getJavadoc().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeConstructorDeclarationNode"),
                        factory.makeExpressionListNode(
                                liftIdentifier,
                                liftBody,
                                liftModifiers,
                                liftParameters,
                                liftVarargParameter,
                                liftThrowTypes,
                                liftTypeParameters,
                                liftJavadoc,
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode(), factory.makeMetaAnnotationListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeConstructorModifiersNode(ConstructorModifiersNode node, ExpressionNode factoryNode)
    {
        AccessModifier liftAccessValue = 
                node.getAccess();
        ExpressionNode liftMetaAnnotations = 
                node.getMetaAnnotations() != null ?
                        node.getMetaAnnotations().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        ExpressionNode liftAnnotations = 
                node.getAnnotations() != null ?
                        node.getAnnotations().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeConstructorModifiersNode"),
                        factory.makeExpressionListNode(
                                expressionizeAccessModifier(liftAccessValue),
                                liftMetaAnnotations,
                                liftAnnotations,
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode(), factory.makeMetaAnnotationListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeContinueNode(ContinueNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftLabel = 
                node.getLabel() != null ?
                        node.getLabel().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeContinueNode"),
                        factory.makeExpressionListNode(
                                liftLabel,
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode(), factory.makeMetaAnnotationListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeDeclaredTypeListNode(DeclaredTypeListNode node, ExpressionNode factoryNode)
    {
        List<ExpressionNode> liftChildrenList = new ArrayList<ExpressionNode>();
        for (DeclaredTypeNode listval : node.getChildren())
        {
            liftChildrenList.add(
                    listval != null ? 
        			        listval.executeOperation(this,factoryNode) :
                            null);
        }
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeDeclaredTypeListNode"),
                        factory.makeExpressionListNode(
                                factory.makeMethodInvocationByNameNode(
                                        factory.makeQualifiedNameNode(
                                                factory.makeQualifiedNameNode(
                                                        factory.makeQualifiedNameNode(
                                                                factory.makeSimpleNameNode(
                                                                        factory.makeIdentifierNode("java"),
                                                                        NameCategory.PACKAGE),
                                                                factory.makeIdentifierNode("util"),
                                                                NameCategory.PACKAGE),
                                                        factory.makeIdentifierNode("Arrays"),
                                                        NameCategory.TYPE),
                                                factory.makeIdentifierNode("asList"),
                                                NameCategory.METHOD),
                                        factory.makeExpressionListNode(liftChildrenList),
                                        factory.makeReferenceTypeListNode(
                                                factory.makeUnparameterizedTypeNode(
                                                        factory.makeSimpleNameNode(
                                                                factory.makeIdentifierNode("DeclaredTypeNode"),
                                                                NameCategory.TYPE)))),
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode(), factory.makeMetaAnnotationListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeDoWhileLoopNode(DoWhileLoopNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftCondition = 
                node.getCondition() != null ?
                        node.getCondition().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        ExpressionNode liftStatement = 
                node.getStatement() != null ?
                        node.getStatement().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeDoWhileLoopNode"),
                        factory.makeExpressionListNode(
                                liftCondition,
                                liftStatement,
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode(), factory.makeMetaAnnotationListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeDoubleLiteralNode(DoubleLiteralNode node, ExpressionNode factoryNode)
    {
        Double liftValueValue = 
                node.getValue();
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeDoubleLiteralNode"),
                        factory.makeExpressionListNode(
                                expressionizeDouble(liftValueValue),
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode(), factory.makeMetaAnnotationListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeEnhancedForLoopNode(EnhancedForLoopNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftVariable = 
                node.getVariable() != null ?
                        node.getVariable().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        ExpressionNode liftExpression = 
                node.getExpression() != null ?
                        node.getExpression().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        ExpressionNode liftStatement = 
                node.getStatement() != null ?
                        node.getStatement().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeEnhancedForLoopNode"),
                        factory.makeExpressionListNode(
                                liftVariable,
                                liftExpression,
                                liftStatement,
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode(), factory.makeMetaAnnotationListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeEnumBodyNode(EnumBodyNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftConstants = 
                node.getConstants() != null ?
                        node.getConstants().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        ExpressionNode liftMembers = 
                node.getMembers() != null ?
                        node.getMembers().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeEnumBodyNode"),
                        factory.makeExpressionListNode(
                                liftConstants,
                                liftMembers,
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode(), factory.makeMetaAnnotationListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeEnumConstantDeclarationListNode(EnumConstantDeclarationListNode node, ExpressionNode factoryNode)
    {
        List<ExpressionNode> liftChildrenList = new ArrayList<ExpressionNode>();
        for (EnumConstantDeclarationNode listval : node.getChildren())
        {
            liftChildrenList.add(
                    listval != null ? 
        			        listval.executeOperation(this,factoryNode) :
                            null);
        }
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeEnumConstantDeclarationListNode"),
                        factory.makeExpressionListNode(
                                factory.makeMethodInvocationByNameNode(
                                        factory.makeQualifiedNameNode(
                                                factory.makeQualifiedNameNode(
                                                        factory.makeQualifiedNameNode(
                                                                factory.makeSimpleNameNode(
                                                                        factory.makeIdentifierNode("java"),
                                                                        NameCategory.PACKAGE),
                                                                factory.makeIdentifierNode("util"),
                                                                NameCategory.PACKAGE),
                                                        factory.makeIdentifierNode("Arrays"),
                                                        NameCategory.TYPE),
                                                factory.makeIdentifierNode("asList"),
                                                NameCategory.METHOD),
                                        factory.makeExpressionListNode(liftChildrenList),
                                        factory.makeReferenceTypeListNode(
                                                factory.makeUnparameterizedTypeNode(
                                                        factory.makeSimpleNameNode(
                                                                factory.makeIdentifierNode("EnumConstantDeclarationNode"),
                                                                NameCategory.TYPE)))),
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode(), factory.makeMetaAnnotationListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeEnumConstantDeclarationNode(EnumConstantDeclarationNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftMetaAnnotations = 
                node.getMetaAnnotations() != null ?
                        node.getMetaAnnotations().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        ExpressionNode liftAnnotations = 
                node.getAnnotations() != null ?
                        node.getAnnotations().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        ExpressionNode liftIdentifier = 
                node.getIdentifier() != null ?
                        node.getIdentifier().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        ExpressionNode liftArguments = 
                node.getArguments() != null ?
                        node.getArguments().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        ExpressionNode liftBody = 
                node.getBody() != null ?
                        node.getBody().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        ExpressionNode liftJavadoc = 
                node.getJavadoc() != null ?
                        node.getJavadoc().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeEnumConstantDeclarationNode"),
                        factory.makeExpressionListNode(
                                liftMetaAnnotations,
                                liftAnnotations,
                                liftIdentifier,
                                liftArguments,
                                liftBody,
                                liftJavadoc,
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode(), factory.makeMetaAnnotationListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeEnumDeclarationNode(EnumDeclarationNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftModifiers = 
                node.getModifiers() != null ?
                        node.getModifiers().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        ExpressionNode liftImplementsClause = 
                node.getImplementsClause() != null ?
                        node.getImplementsClause().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        ExpressionNode liftBody = 
                node.getBody() != null ?
                        node.getBody().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        ExpressionNode liftIdentifier = 
                node.getIdentifier() != null ?
                        node.getIdentifier().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        ExpressionNode liftJavadoc = 
                node.getJavadoc() != null ?
                        node.getJavadoc().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeEnumDeclarationNode"),
                        factory.makeExpressionListNode(
                                liftModifiers,
                                liftImplementsClause,
                                liftBody,
                                liftIdentifier,
                                liftJavadoc,
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode(), factory.makeMetaAnnotationListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeEnumModifiersNode(EnumModifiersNode node, ExpressionNode factoryNode)
    {
        AccessModifier liftAccessValue = 
                node.getAccess();
        boolean liftStrictfpFlagValue = 
                node.getStrictfpFlag();
        ExpressionNode liftMetaAnnotations = 
                node.getMetaAnnotations() != null ?
                        node.getMetaAnnotations().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        ExpressionNode liftAnnotations = 
                node.getAnnotations() != null ?
                        node.getAnnotations().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeEnumModifiersNode"),
                        factory.makeExpressionListNode(
                                expressionizeAccessModifier(liftAccessValue),
                                expressionizeBoolean(liftStrictfpFlagValue),
                                liftMetaAnnotations,
                                liftAnnotations,
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode(), factory.makeMetaAnnotationListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeExpressionListNode(ExpressionListNode node, ExpressionNode factoryNode)
    {
        List<ExpressionNode> liftChildrenList = new ArrayList<ExpressionNode>();
        for (ExpressionNode listval : node.getChildren())
        {
            liftChildrenList.add(
                    listval != null ? 
        			        listval.executeOperation(this,factoryNode) :
                            null);
        }
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeExpressionListNode"),
                        factory.makeExpressionListNode(
                                factory.makeMethodInvocationByNameNode(
                                        factory.makeQualifiedNameNode(
                                                factory.makeQualifiedNameNode(
                                                        factory.makeQualifiedNameNode(
                                                                factory.makeSimpleNameNode(
                                                                        factory.makeIdentifierNode("java"),
                                                                        NameCategory.PACKAGE),
                                                                factory.makeIdentifierNode("util"),
                                                                NameCategory.PACKAGE),
                                                        factory.makeIdentifierNode("Arrays"),
                                                        NameCategory.TYPE),
                                                factory.makeIdentifierNode("asList"),
                                                NameCategory.METHOD),
                                        factory.makeExpressionListNode(liftChildrenList),
                                        factory.makeReferenceTypeListNode(
                                                factory.makeUnparameterizedTypeNode(
                                                        factory.makeSimpleNameNode(
                                                                factory.makeIdentifierNode("ExpressionNode"),
                                                                NameCategory.TYPE)))),
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode(), factory.makeMetaAnnotationListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeExpressionStatementNode(ExpressionStatementNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftExpression = 
                node.getExpression() != null ?
                        node.getExpression().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeExpressionStatementNode"),
                        factory.makeExpressionListNode(
                                liftExpression,
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode(), factory.makeMetaAnnotationListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeFieldAccessByExpressionNode(FieldAccessByExpressionNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftExpression = 
                node.getExpression() != null ?
                        node.getExpression().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        ExpressionNode liftIdentifier = 
                node.getIdentifier() != null ?
                        node.getIdentifier().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeFieldAccessByExpressionNode"),
                        factory.makeExpressionListNode(
                                liftExpression,
                                liftIdentifier,
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode(), factory.makeMetaAnnotationListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeFieldAccessByNameNode(FieldAccessByNameNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftName = 
                node.getName() != null ?
                        node.getName().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeFieldAccessByNameNode"),
                        factory.makeExpressionListNode(
                                liftName,
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode(), factory.makeMetaAnnotationListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeFieldDeclarationNode(FieldDeclarationNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftModifiers = 
                node.getModifiers() != null ?
                        node.getModifiers().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        ExpressionNode liftDeclarators = 
                node.getDeclarators() != null ?
                        node.getDeclarators().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        ExpressionNode liftJavadoc = 
                node.getJavadoc() != null ?
                        node.getJavadoc().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeFieldDeclarationNode"),
                        factory.makeExpressionListNode(
                                liftModifiers,
                                liftDeclarators,
                                liftJavadoc,
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode(), factory.makeMetaAnnotationListNode());
        
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
        ExpressionNode liftMetaAnnotations = 
                node.getMetaAnnotations() != null ?
                        node.getMetaAnnotations().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        ExpressionNode liftAnnotations = 
                node.getAnnotations() != null ?
                        node.getAnnotations().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeFieldModifiersNode"),
                        factory.makeExpressionListNode(
                                expressionizeAccessModifier(liftAccessValue),
                                expressionizeBoolean(liftStaticFlagValue),
                                expressionizeBoolean(liftFinalFlagValue),
                                expressionizeBoolean(liftTransientFlagValue),
                                expressionizeBoolean(liftVolatileFlagValue),
                                liftMetaAnnotations,
                                liftAnnotations,
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode(), factory.makeMetaAnnotationListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeFloatLiteralNode(FloatLiteralNode node, ExpressionNode factoryNode)
    {
        Float liftValueValue = 
                node.getValue();
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeFloatLiteralNode"),
                        factory.makeExpressionListNode(
                                expressionizeFloat(liftValueValue),
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode(), factory.makeMetaAnnotationListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeForInitializerDeclarationNode(ForInitializerDeclarationNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftDeclaration = 
                node.getDeclaration() != null ?
                        node.getDeclaration().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeForInitializerDeclarationNode"),
                        factory.makeExpressionListNode(
                                liftDeclaration,
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode(), factory.makeMetaAnnotationListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeForInitializerExpressionNode(ForInitializerExpressionNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftExpressions = 
                node.getExpressions() != null ?
                        node.getExpressions().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeForInitializerExpressionNode"),
                        factory.makeExpressionListNode(
                                liftExpressions,
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode(), factory.makeMetaAnnotationListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeForLoopNode(ForLoopNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftInitializer = 
                node.getInitializer() != null ?
                        node.getInitializer().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        ExpressionNode liftCondition = 
                node.getCondition() != null ?
                        node.getCondition().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        ExpressionNode liftUpdate = 
                node.getUpdate() != null ?
                        node.getUpdate().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        ExpressionNode liftStatement = 
                node.getStatement() != null ?
                        node.getStatement().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeForLoopNode"),
                        factory.makeExpressionListNode(
                                liftInitializer,
                                liftCondition,
                                liftUpdate,
                                liftStatement,
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode(), factory.makeMetaAnnotationListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeIdentifierListNode(IdentifierListNode node, ExpressionNode factoryNode)
    {
        List<ExpressionNode> liftChildrenList = new ArrayList<ExpressionNode>();
        for (IdentifierNode listval : node.getChildren())
        {
            liftChildrenList.add(
                    listval != null ? 
        			        listval.executeOperation(this,factoryNode) :
                            null);
        }
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeIdentifierListNode"),
                        factory.makeExpressionListNode(
                                factory.makeMethodInvocationByNameNode(
                                        factory.makeQualifiedNameNode(
                                                factory.makeQualifiedNameNode(
                                                        factory.makeQualifiedNameNode(
                                                                factory.makeSimpleNameNode(
                                                                        factory.makeIdentifierNode("java"),
                                                                        NameCategory.PACKAGE),
                                                                factory.makeIdentifierNode("util"),
                                                                NameCategory.PACKAGE),
                                                        factory.makeIdentifierNode("Arrays"),
                                                        NameCategory.TYPE),
                                                factory.makeIdentifierNode("asList"),
                                                NameCategory.METHOD),
                                        factory.makeExpressionListNode(liftChildrenList),
                                        factory.makeReferenceTypeListNode(
                                                factory.makeUnparameterizedTypeNode(
                                                        factory.makeSimpleNameNode(
                                                                factory.makeIdentifierNode("IdentifierNode"),
                                                                NameCategory.TYPE)))),
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode(), factory.makeMetaAnnotationListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeIdentifierNode(IdentifierNode node, ExpressionNode factoryNode)
    {
        String liftIdentifierValue = 
                node.getIdentifier();
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeIdentifierNode"),
                        factory.makeExpressionListNode(
                                expressionizeString(liftIdentifierValue),
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode(), factory.makeMetaAnnotationListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeIfNode(IfNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftCondition = 
                node.getCondition() != null ?
                        node.getCondition().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        ExpressionNode liftThenStatement = 
                node.getThenStatement() != null ?
                        node.getThenStatement().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        ExpressionNode liftElseStatement = 
                node.getElseStatement() != null ?
                        node.getElseStatement().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeIfNode"),
                        factory.makeExpressionListNode(
                                liftCondition,
                                liftThenStatement,
                                liftElseStatement,
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode(), factory.makeMetaAnnotationListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeImportListNode(ImportListNode node, ExpressionNode factoryNode)
    {
        List<ExpressionNode> liftChildrenList = new ArrayList<ExpressionNode>();
        for (ImportNode listval : node.getChildren())
        {
            liftChildrenList.add(
                    listval != null ? 
        			        listval.executeOperation(this,factoryNode) :
                            null);
        }
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeImportListNode"),
                        factory.makeExpressionListNode(
                                factory.makeMethodInvocationByNameNode(
                                        factory.makeQualifiedNameNode(
                                                factory.makeQualifiedNameNode(
                                                        factory.makeQualifiedNameNode(
                                                                factory.makeSimpleNameNode(
                                                                        factory.makeIdentifierNode("java"),
                                                                        NameCategory.PACKAGE),
                                                                factory.makeIdentifierNode("util"),
                                                                NameCategory.PACKAGE),
                                                        factory.makeIdentifierNode("Arrays"),
                                                        NameCategory.TYPE),
                                                factory.makeIdentifierNode("asList"),
                                                NameCategory.METHOD),
                                        factory.makeExpressionListNode(liftChildrenList),
                                        factory.makeReferenceTypeListNode(
                                                factory.makeUnparameterizedTypeNode(
                                                        factory.makeSimpleNameNode(
                                                                factory.makeIdentifierNode("ImportNode"),
                                                                NameCategory.TYPE)))),
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode(), factory.makeMetaAnnotationListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeImportOnDemandNode(ImportOnDemandNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftName = 
                node.getName() != null ?
                        node.getName().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeImportOnDemandNode"),
                        factory.makeExpressionListNode(
                                liftName,
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode(), factory.makeMetaAnnotationListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeImportSingleTypeNode(ImportSingleTypeNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftName = 
                node.getName() != null ?
                        node.getName().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeImportSingleTypeNode"),
                        factory.makeExpressionListNode(
                                liftName,
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode(), factory.makeMetaAnnotationListNode());
        
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
                        factory.makeNullLiteralNode();
        ExpressionNode liftMetaAnnotations = 
                node.getMetaAnnotations() != null ?
                        node.getMetaAnnotations().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeInitializerDeclarationNode"),
                        factory.makeExpressionListNode(
                                expressionizeBoolean(liftStaticInitializerValue),
                                liftBody,
                                liftMetaAnnotations,
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode(), factory.makeMetaAnnotationListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeInlineTypeDeclarationNode(InlineTypeDeclarationNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftDeclaration = 
                node.getDeclaration() != null ?
                        node.getDeclaration().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeInlineTypeDeclarationNode"),
                        factory.makeExpressionListNode(
                                liftDeclaration,
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode(), factory.makeMetaAnnotationListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeInstanceOfNode(InstanceOfNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftExpression = 
                node.getExpression() != null ?
                        node.getExpression().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        ExpressionNode liftType = 
                node.getType() != null ?
                        node.getType().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeInstanceOfNode"),
                        factory.makeExpressionListNode(
                                liftExpression,
                                liftType,
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode(), factory.makeMetaAnnotationListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeIntLiteralNode(IntLiteralNode node, ExpressionNode factoryNode)
    {
        Integer liftValueValue = 
                node.getValue();
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeIntLiteralNode"),
                        factory.makeExpressionListNode(
                                expressionizeInteger(liftValueValue),
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode(), factory.makeMetaAnnotationListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeInterfaceBodyNode(InterfaceBodyNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftMembers = 
                node.getMembers() != null ?
                        node.getMembers().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeInterfaceBodyNode"),
                        factory.makeExpressionListNode(
                                liftMembers,
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode(), factory.makeMetaAnnotationListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeInterfaceDeclarationNode(InterfaceDeclarationNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftModifiers = 
                node.getModifiers() != null ?
                        node.getModifiers().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        ExpressionNode liftExtendsClause = 
                node.getExtendsClause() != null ?
                        node.getExtendsClause().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        ExpressionNode liftBody = 
                node.getBody() != null ?
                        node.getBody().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        ExpressionNode liftTypeParameters = 
                node.getTypeParameters() != null ?
                        node.getTypeParameters().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        ExpressionNode liftIdentifier = 
                node.getIdentifier() != null ?
                        node.getIdentifier().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        ExpressionNode liftJavadoc = 
                node.getJavadoc() != null ?
                        node.getJavadoc().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeInterfaceDeclarationNode"),
                        factory.makeExpressionListNode(
                                liftModifiers,
                                liftExtendsClause,
                                liftBody,
                                liftTypeParameters,
                                liftIdentifier,
                                liftJavadoc,
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode(), factory.makeMetaAnnotationListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeInterfaceMemberListNode(InterfaceMemberListNode node, ExpressionNode factoryNode)
    {
        List<ExpressionNode> liftChildrenList = new ArrayList<ExpressionNode>();
        for (InterfaceMemberNode listval : node.getChildren())
        {
            liftChildrenList.add(
                    listval != null ? 
        			        listval.executeOperation(this,factoryNode) :
                            null);
        }
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeInterfaceMemberListNode"),
                        factory.makeExpressionListNode(
                                factory.makeMethodInvocationByNameNode(
                                        factory.makeQualifiedNameNode(
                                                factory.makeQualifiedNameNode(
                                                        factory.makeQualifiedNameNode(
                                                                factory.makeSimpleNameNode(
                                                                        factory.makeIdentifierNode("java"),
                                                                        NameCategory.PACKAGE),
                                                                factory.makeIdentifierNode("util"),
                                                                NameCategory.PACKAGE),
                                                        factory.makeIdentifierNode("Arrays"),
                                                        NameCategory.TYPE),
                                                factory.makeIdentifierNode("asList"),
                                                NameCategory.METHOD),
                                        factory.makeExpressionListNode(liftChildrenList),
                                        factory.makeReferenceTypeListNode(
                                                factory.makeUnparameterizedTypeNode(
                                                        factory.makeSimpleNameNode(
                                                                factory.makeIdentifierNode("InterfaceMemberNode"),
                                                                NameCategory.TYPE)))),
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode(), factory.makeMetaAnnotationListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeInterfaceMemberMetaprogramAnchorNode(InterfaceMemberMetaprogramAnchorNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftMetaprogram = 
                node.getMetaprogram() != null ?
                        node.getMetaprogram().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeInterfaceMemberMetaprogramAnchorNode"),
                        factory.makeExpressionListNode(
                                liftMetaprogram,
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode(), factory.makeMetaAnnotationListNode());
        
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
        ExpressionNode liftMetaAnnotations = 
                node.getMetaAnnotations() != null ?
                        node.getMetaAnnotations().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        ExpressionNode liftAnnotations = 
                node.getAnnotations() != null ?
                        node.getAnnotations().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeInterfaceModifiersNode"),
                        factory.makeExpressionListNode(
                                expressionizeAccessModifier(liftAccessValue),
                                expressionizeBoolean(liftStaticFlagValue),
                                expressionizeBoolean(liftStrictfpFlagValue),
                                liftMetaAnnotations,
                                liftAnnotations,
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode(), factory.makeMetaAnnotationListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeJavadocNode(JavadocNode node, ExpressionNode factoryNode)
    {
        String liftTextValue = 
                node.getText();
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeJavadocNode"),
                        factory.makeExpressionListNode(
                                expressionizeString(liftTextValue),
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode(), factory.makeMetaAnnotationListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeLabeledStatementNode(LabeledStatementNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftLabel = 
                node.getLabel() != null ?
                        node.getLabel().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        ExpressionNode liftStatement = 
                node.getStatement() != null ?
                        node.getStatement().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeLabeledStatementNode"),
                        factory.makeExpressionListNode(
                                liftLabel,
                                liftStatement,
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode(), factory.makeMetaAnnotationListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeLongLiteralNode(LongLiteralNode node, ExpressionNode factoryNode)
    {
        Long liftValueValue = 
                node.getValue();
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeLongLiteralNode"),
                        factory.makeExpressionListNode(
                                expressionizeLong(liftValueValue),
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode(), factory.makeMetaAnnotationListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeMetaAnnotationArrayValueNode(MetaAnnotationArrayValueNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftValues = 
                node.getValues() != null ?
                        node.getValues().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeMetaAnnotationArrayValueNode"),
                        factory.makeExpressionListNode(
                                liftValues,
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode(), factory.makeMetaAnnotationListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeMetaAnnotationElementListNode(MetaAnnotationElementListNode node, ExpressionNode factoryNode)
    {
        List<ExpressionNode> liftChildrenList = new ArrayList<ExpressionNode>();
        for (MetaAnnotationElementNode listval : node.getChildren())
        {
            liftChildrenList.add(
                    listval != null ? 
        			        listval.executeOperation(this,factoryNode) :
                            null);
        }
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeMetaAnnotationElementListNode"),
                        factory.makeExpressionListNode(
                                factory.makeMethodInvocationByNameNode(
                                        factory.makeQualifiedNameNode(
                                                factory.makeQualifiedNameNode(
                                                        factory.makeQualifiedNameNode(
                                                                factory.makeSimpleNameNode(
                                                                        factory.makeIdentifierNode("java"),
                                                                        NameCategory.PACKAGE),
                                                                factory.makeIdentifierNode("util"),
                                                                NameCategory.PACKAGE),
                                                        factory.makeIdentifierNode("Arrays"),
                                                        NameCategory.TYPE),
                                                factory.makeIdentifierNode("asList"),
                                                NameCategory.METHOD),
                                        factory.makeExpressionListNode(liftChildrenList),
                                        factory.makeReferenceTypeListNode(
                                                factory.makeUnparameterizedTypeNode(
                                                        factory.makeSimpleNameNode(
                                                                factory.makeIdentifierNode("MetaAnnotationElementNode"),
                                                                NameCategory.TYPE)))),
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode(), factory.makeMetaAnnotationListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeMetaAnnotationElementNode(MetaAnnotationElementNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftIdentifier = 
                node.getIdentifier() != null ?
                        node.getIdentifier().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        ExpressionNode liftValue = 
                node.getValue() != null ?
                        node.getValue().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeMetaAnnotationElementNode"),
                        factory.makeExpressionListNode(
                                liftIdentifier,
                                liftValue,
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode(), factory.makeMetaAnnotationListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeMetaAnnotationExpressionValueNode(MetaAnnotationExpressionValueNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftExpression = 
                node.getExpression() != null ?
                        node.getExpression().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeMetaAnnotationExpressionValueNode"),
                        factory.makeExpressionListNode(
                                liftExpression,
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode(), factory.makeMetaAnnotationListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeMetaAnnotationListNode(MetaAnnotationListNode node, ExpressionNode factoryNode)
    {
        List<ExpressionNode> liftChildrenList = new ArrayList<ExpressionNode>();
        for (MetaAnnotationNode listval : node.getChildren())
        {
            liftChildrenList.add(
                    listval != null ? 
        			        listval.executeOperation(this,factoryNode) :
                            null);
        }
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeMetaAnnotationListNode"),
                        factory.makeExpressionListNode(
                                factory.makeMethodInvocationByNameNode(
                                        factory.makeQualifiedNameNode(
                                                factory.makeQualifiedNameNode(
                                                        factory.makeQualifiedNameNode(
                                                                factory.makeSimpleNameNode(
                                                                        factory.makeIdentifierNode("java"),
                                                                        NameCategory.PACKAGE),
                                                                factory.makeIdentifierNode("util"),
                                                                NameCategory.PACKAGE),
                                                        factory.makeIdentifierNode("Arrays"),
                                                        NameCategory.TYPE),
                                                factory.makeIdentifierNode("asList"),
                                                NameCategory.METHOD),
                                        factory.makeExpressionListNode(liftChildrenList),
                                        factory.makeReferenceTypeListNode(
                                                factory.makeUnparameterizedTypeNode(
                                                        factory.makeSimpleNameNode(
                                                                factory.makeIdentifierNode("MetaAnnotationNode"),
                                                                NameCategory.TYPE)))),
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode(), factory.makeMetaAnnotationListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeMetaAnnotationMetaAnnotationValueNode(MetaAnnotationMetaAnnotationValueNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftAnnotation = 
                node.getAnnotation() != null ?
                        node.getAnnotation().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeMetaAnnotationMetaAnnotationValueNode"),
                        factory.makeExpressionListNode(
                                liftAnnotation,
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode(), factory.makeMetaAnnotationListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeMetaAnnotationMetaprogramAnchorNode(MetaAnnotationMetaprogramAnchorNode node, ExpressionNode factoryNode)
    {
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeMetaAnnotationMetaprogramAnchorNode"),
                        factory.makeExpressionListNode(
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode(), factory.makeMetaAnnotationListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeMetaAnnotationValueListNode(MetaAnnotationValueListNode node, ExpressionNode factoryNode)
    {
        List<ExpressionNode> liftChildrenList = new ArrayList<ExpressionNode>();
        for (MetaAnnotationValueNode listval : node.getChildren())
        {
            liftChildrenList.add(
                    listval != null ? 
        			        listval.executeOperation(this,factoryNode) :
                            null);
        }
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeMetaAnnotationValueListNode"),
                        factory.makeExpressionListNode(
                                factory.makeMethodInvocationByNameNode(
                                        factory.makeQualifiedNameNode(
                                                factory.makeQualifiedNameNode(
                                                        factory.makeQualifiedNameNode(
                                                                factory.makeSimpleNameNode(
                                                                        factory.makeIdentifierNode("java"),
                                                                        NameCategory.PACKAGE),
                                                                factory.makeIdentifierNode("util"),
                                                                NameCategory.PACKAGE),
                                                        factory.makeIdentifierNode("Arrays"),
                                                        NameCategory.TYPE),
                                                factory.makeIdentifierNode("asList"),
                                                NameCategory.METHOD),
                                        factory.makeExpressionListNode(liftChildrenList),
                                        factory.makeReferenceTypeListNode(
                                                factory.makeUnparameterizedTypeNode(
                                                        factory.makeSimpleNameNode(
                                                                factory.makeIdentifierNode("MetaAnnotationValueNode"),
                                                                NameCategory.TYPE)))),
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode(), factory.makeMetaAnnotationListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeMetaprogramDependencyDeclarationListNode(MetaprogramDependencyDeclarationListNode node, ExpressionNode factoryNode)
    {
        List<ExpressionNode> liftChildrenList = new ArrayList<ExpressionNode>();
        for (MetaprogramDependencyDeclarationNode listval : node.getChildren())
        {
            liftChildrenList.add(
                    listval != null ? 
        			        listval.executeOperation(this,factoryNode) :
                            null);
        }
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeMetaprogramDependencyDeclarationListNode"),
                        factory.makeExpressionListNode(
                                factory.makeMethodInvocationByNameNode(
                                        factory.makeQualifiedNameNode(
                                                factory.makeQualifiedNameNode(
                                                        factory.makeQualifiedNameNode(
                                                                factory.makeSimpleNameNode(
                                                                        factory.makeIdentifierNode("java"),
                                                                        NameCategory.PACKAGE),
                                                                factory.makeIdentifierNode("util"),
                                                                NameCategory.PACKAGE),
                                                        factory.makeIdentifierNode("Arrays"),
                                                        NameCategory.TYPE),
                                                factory.makeIdentifierNode("asList"),
                                                NameCategory.METHOD),
                                        factory.makeExpressionListNode(liftChildrenList),
                                        factory.makeReferenceTypeListNode(
                                                factory.makeUnparameterizedTypeNode(
                                                        factory.makeSimpleNameNode(
                                                                factory.makeIdentifierNode("MetaprogramDependencyDeclarationNode"),
                                                                NameCategory.TYPE)))),
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode(), factory.makeMetaAnnotationListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeMetaprogramDependencyDeclarationNode(MetaprogramDependencyDeclarationNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftTargets = 
                node.getTargets() != null ?
                        node.getTargets().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeMetaprogramDependencyDeclarationNode"),
                        factory.makeExpressionListNode(
                                liftTargets,
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode(), factory.makeMetaAnnotationListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeMetaprogramDependencyListNode(MetaprogramDependencyListNode node, ExpressionNode factoryNode)
    {
        List<ExpressionNode> liftChildrenList = new ArrayList<ExpressionNode>();
        for (MetaprogramDependencyNode listval : node.getChildren())
        {
            liftChildrenList.add(
                    listval != null ? 
        			        listval.executeOperation(this,factoryNode) :
                            null);
        }
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeMetaprogramDependencyListNode"),
                        factory.makeExpressionListNode(
                                factory.makeMethodInvocationByNameNode(
                                        factory.makeQualifiedNameNode(
                                                factory.makeQualifiedNameNode(
                                                        factory.makeQualifiedNameNode(
                                                                factory.makeSimpleNameNode(
                                                                        factory.makeIdentifierNode("java"),
                                                                        NameCategory.PACKAGE),
                                                                factory.makeIdentifierNode("util"),
                                                                NameCategory.PACKAGE),
                                                        factory.makeIdentifierNode("Arrays"),
                                                        NameCategory.TYPE),
                                                factory.makeIdentifierNode("asList"),
                                                NameCategory.METHOD),
                                        factory.makeExpressionListNode(liftChildrenList),
                                        factory.makeReferenceTypeListNode(
                                                factory.makeUnparameterizedTypeNode(
                                                        factory.makeSimpleNameNode(
                                                                factory.makeIdentifierNode("MetaprogramDependencyNode"),
                                                                NameCategory.TYPE)))),
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode(), factory.makeMetaAnnotationListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeMetaprogramDependencyNode(MetaprogramDependencyNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftTargetName = 
                node.getTargetName() != null ?
                        node.getTargetName().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        boolean liftWeakValue = 
                node.getWeak();
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeMetaprogramDependencyNode"),
                        factory.makeExpressionListNode(
                                liftTargetName,
                                expressionizeBoolean(liftWeakValue),
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode(), factory.makeMetaAnnotationListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeMetaprogramImportListNode(MetaprogramImportListNode node, ExpressionNode factoryNode)
    {
        List<ExpressionNode> liftChildrenList = new ArrayList<ExpressionNode>();
        for (MetaprogramImportNode listval : node.getChildren())
        {
            liftChildrenList.add(
                    listval != null ? 
        			        listval.executeOperation(this,factoryNode) :
                            null);
        }
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeMetaprogramImportListNode"),
                        factory.makeExpressionListNode(
                                factory.makeMethodInvocationByNameNode(
                                        factory.makeQualifiedNameNode(
                                                factory.makeQualifiedNameNode(
                                                        factory.makeQualifiedNameNode(
                                                                factory.makeSimpleNameNode(
                                                                        factory.makeIdentifierNode("java"),
                                                                        NameCategory.PACKAGE),
                                                                factory.makeIdentifierNode("util"),
                                                                NameCategory.PACKAGE),
                                                        factory.makeIdentifierNode("Arrays"),
                                                        NameCategory.TYPE),
                                                factory.makeIdentifierNode("asList"),
                                                NameCategory.METHOD),
                                        factory.makeExpressionListNode(liftChildrenList),
                                        factory.makeReferenceTypeListNode(
                                                factory.makeUnparameterizedTypeNode(
                                                        factory.makeSimpleNameNode(
                                                                factory.makeIdentifierNode("MetaprogramImportNode"),
                                                                NameCategory.TYPE)))),
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode(), factory.makeMetaAnnotationListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeMetaprogramImportNode(MetaprogramImportNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftImportNode = 
                node.getImportNode() != null ?
                        node.getImportNode().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeMetaprogramImportNode"),
                        factory.makeExpressionListNode(
                                liftImportNode,
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode(), factory.makeMetaAnnotationListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeMetaprogramNode(MetaprogramNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftPreamble = 
                node.getPreamble() != null ?
                        node.getPreamble().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        ExpressionNode liftBody = 
                node.getBody() != null ?
                        node.getBody().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeMetaprogramNode"),
                        factory.makeExpressionListNode(
                                liftPreamble,
                                liftBody,
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode(), factory.makeMetaAnnotationListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeMetaprogramPreambleNode(MetaprogramPreambleNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftImports = 
                node.getImports() != null ?
                        node.getImports().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        MetaprogramLocalMode liftLocalModeValue = 
                node.getLocalMode();
        MetaprogramPackageMode liftPackageModeValue = 
                node.getPackageMode();
        ExpressionNode liftTargets = 
                node.getTargets() != null ?
                        node.getTargets().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        ExpressionNode liftDependencies = 
                node.getDependencies() != null ?
                        node.getDependencies().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeMetaprogramPreambleNode"),
                        factory.makeExpressionListNode(
                                liftImports,
                                expressionizeMetaprogramLocalMode(liftLocalModeValue),
                                expressionizeMetaprogramPackageMode(liftPackageModeValue),
                                liftTargets,
                                liftDependencies,
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode(), factory.makeMetaAnnotationListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeMetaprogramTargetListNode(MetaprogramTargetListNode node, ExpressionNode factoryNode)
    {
        List<ExpressionNode> liftChildrenList = new ArrayList<ExpressionNode>();
        for (MetaprogramTargetNode listval : node.getChildren())
        {
            liftChildrenList.add(
                    listval != null ? 
        			        listval.executeOperation(this,factoryNode) :
                            null);
        }
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeMetaprogramTargetListNode"),
                        factory.makeExpressionListNode(
                                factory.makeMethodInvocationByNameNode(
                                        factory.makeQualifiedNameNode(
                                                factory.makeQualifiedNameNode(
                                                        factory.makeQualifiedNameNode(
                                                                factory.makeSimpleNameNode(
                                                                        factory.makeIdentifierNode("java"),
                                                                        NameCategory.PACKAGE),
                                                                factory.makeIdentifierNode("util"),
                                                                NameCategory.PACKAGE),
                                                        factory.makeIdentifierNode("Arrays"),
                                                        NameCategory.TYPE),
                                                factory.makeIdentifierNode("asList"),
                                                NameCategory.METHOD),
                                        factory.makeExpressionListNode(liftChildrenList),
                                        factory.makeReferenceTypeListNode(
                                                factory.makeUnparameterizedTypeNode(
                                                        factory.makeSimpleNameNode(
                                                                factory.makeIdentifierNode("MetaprogramTargetNode"),
                                                                NameCategory.TYPE)))),
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode(), factory.makeMetaAnnotationListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeMetaprogramTargetNode(MetaprogramTargetNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftTargets = 
                node.getTargets() != null ?
                        node.getTargets().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeMetaprogramTargetNode"),
                        factory.makeExpressionListNode(
                                liftTargets,
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode(), factory.makeMetaAnnotationListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeMethodDeclarationNode(MethodDeclarationNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftBody = 
                node.getBody() != null ?
                        node.getBody().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        ExpressionNode liftModifiers = 
                node.getModifiers() != null ?
                        node.getModifiers().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        ExpressionNode liftIdentifier = 
                node.getIdentifier() != null ?
                        node.getIdentifier().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        ExpressionNode liftParameters = 
                node.getParameters() != null ?
                        node.getParameters().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        ExpressionNode liftVarargParameter = 
                node.getVarargParameter() != null ?
                        node.getVarargParameter().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        ExpressionNode liftReturnType = 
                node.getReturnType() != null ?
                        node.getReturnType().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        ExpressionNode liftThrowTypes = 
                node.getThrowTypes() != null ?
                        node.getThrowTypes().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        ExpressionNode liftTypeParameters = 
                node.getTypeParameters() != null ?
                        node.getTypeParameters().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        ExpressionNode liftJavadoc = 
                node.getJavadoc() != null ?
                        node.getJavadoc().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeMethodDeclarationNode"),
                        factory.makeExpressionListNode(
                                liftBody,
                                liftModifiers,
                                liftIdentifier,
                                liftParameters,
                                liftVarargParameter,
                                liftReturnType,
                                liftThrowTypes,
                                liftTypeParameters,
                                liftJavadoc,
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode(), factory.makeMetaAnnotationListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeMethodInvocationByExpressionNode(MethodInvocationByExpressionNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftExpression = 
                node.getExpression() != null ?
                        node.getExpression().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        ExpressionNode liftIdentifier = 
                node.getIdentifier() != null ?
                        node.getIdentifier().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        ExpressionNode liftArguments = 
                node.getArguments() != null ?
                        node.getArguments().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        ExpressionNode liftTypeArguments = 
                node.getTypeArguments() != null ?
                        node.getTypeArguments().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        ExpressionNode liftMetaAnnotations = 
                node.getMetaAnnotations() != null ?
                        node.getMetaAnnotations().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeMethodInvocationByExpressionNode"),
                        factory.makeExpressionListNode(
                                liftExpression,
                                liftIdentifier,
                                liftArguments,
                                liftTypeArguments,
                                liftMetaAnnotations,
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode(), factory.makeMetaAnnotationListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeMethodInvocationByNameNode(MethodInvocationByNameNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftName = 
                node.getName() != null ?
                        node.getName().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        ExpressionNode liftArguments = 
                node.getArguments() != null ?
                        node.getArguments().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        ExpressionNode liftTypeArguments = 
                node.getTypeArguments() != null ?
                        node.getTypeArguments().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        ExpressionNode liftMetaAnnotations = 
                node.getMetaAnnotations() != null ?
                        node.getMetaAnnotations().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeMethodInvocationByNameNode"),
                        factory.makeExpressionListNode(
                                liftName,
                                liftArguments,
                                liftTypeArguments,
                                liftMetaAnnotations,
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode(), factory.makeMetaAnnotationListNode());
        
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
        ExpressionNode liftMetaAnnotations = 
                node.getMetaAnnotations() != null ?
                        node.getMetaAnnotations().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        ExpressionNode liftAnnotations = 
                node.getAnnotations() != null ?
                        node.getAnnotations().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeMethodModifiersNode"),
                        factory.makeExpressionListNode(
                                expressionizeAccessModifier(liftAccessValue),
                                expressionizeBoolean(liftAbstractFlagValue),
                                expressionizeBoolean(liftStaticFlagValue),
                                expressionizeBoolean(liftFinalFlagValue),
                                expressionizeBoolean(liftSynchronizedFlagValue),
                                expressionizeBoolean(liftNativeFlagValue),
                                expressionizeBoolean(liftStrictfpFlagValue),
                                liftMetaAnnotations,
                                liftAnnotations,
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode(), factory.makeMetaAnnotationListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeNameListNode(NameListNode node, ExpressionNode factoryNode)
    {
        List<ExpressionNode> liftChildrenList = new ArrayList<ExpressionNode>();
        for (NameNode listval : node.getChildren())
        {
            liftChildrenList.add(
                    listval != null ? 
        			        listval.executeOperation(this,factoryNode) :
                            null);
        }
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeNameListNode"),
                        factory.makeExpressionListNode(
                                factory.makeMethodInvocationByNameNode(
                                        factory.makeQualifiedNameNode(
                                                factory.makeQualifiedNameNode(
                                                        factory.makeQualifiedNameNode(
                                                                factory.makeSimpleNameNode(
                                                                        factory.makeIdentifierNode("java"),
                                                                        NameCategory.PACKAGE),
                                                                factory.makeIdentifierNode("util"),
                                                                NameCategory.PACKAGE),
                                                        factory.makeIdentifierNode("Arrays"),
                                                        NameCategory.TYPE),
                                                factory.makeIdentifierNode("asList"),
                                                NameCategory.METHOD),
                                        factory.makeExpressionListNode(liftChildrenList),
                                        factory.makeReferenceTypeListNode(
                                                factory.makeUnparameterizedTypeNode(
                                                        factory.makeSimpleNameNode(
                                                                factory.makeIdentifierNode("NameNode"),
                                                                NameCategory.TYPE)))),
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode(), factory.makeMetaAnnotationListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeNoOperationNode(NoOperationNode node, ExpressionNode factoryNode)
    {
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeNoOperationNode"),
                        factory.makeExpressionListNode(
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode(), factory.makeMetaAnnotationListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeNormalAnnotationNode(NormalAnnotationNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftArguments = 
                node.getArguments() != null ?
                        node.getArguments().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        ExpressionNode liftAnnotationType = 
                node.getAnnotationType() != null ?
                        node.getAnnotationType().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeNormalAnnotationNode"),
                        factory.makeExpressionListNode(
                                liftArguments,
                                liftAnnotationType,
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode(), factory.makeMetaAnnotationListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeNormalMetaAnnotationNode(NormalMetaAnnotationNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftArguments = 
                node.getArguments() != null ?
                        node.getArguments().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        ExpressionNode liftAnnotationType = 
                node.getAnnotationType() != null ?
                        node.getAnnotationType().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeNormalMetaAnnotationNode"),
                        factory.makeExpressionListNode(
                                liftArguments,
                                liftAnnotationType,
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode(), factory.makeMetaAnnotationListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeNullLiteralNode(NullLiteralNode node, ExpressionNode factoryNode)
    {
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeNullLiteralNode"),
                        factory.makeExpressionListNode(
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode(), factory.makeMetaAnnotationListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executePackageDeclarationNode(PackageDeclarationNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftName = 
                node.getName() != null ?
                        node.getName().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        ExpressionNode liftMetaAnnotations = 
                node.getMetaAnnotations() != null ?
                        node.getMetaAnnotations().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        ExpressionNode liftAnnotations = 
                node.getAnnotations() != null ?
                        node.getAnnotations().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makePackageDeclarationNode"),
                        factory.makeExpressionListNode(
                                liftName,
                                liftMetaAnnotations,
                                liftAnnotations,
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode(), factory.makeMetaAnnotationListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executePackageNode(PackageNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftName = 
                node.getName() != null ?
                        node.getName().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makePackageNode"),
                        factory.makeExpressionListNode(
                                liftName,
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode(), factory.makeMetaAnnotationListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeParameterizedTypeNode(ParameterizedTypeNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftBaseType = 
                node.getBaseType() != null ?
                        node.getBaseType().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        ExpressionNode liftTypeArguments = 
                node.getTypeArguments() != null ?
                        node.getTypeArguments().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeParameterizedTypeNode"),
                        factory.makeExpressionListNode(
                                liftBaseType,
                                liftTypeArguments,
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode(), factory.makeMetaAnnotationListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeParameterizedTypeSelectNode(ParameterizedTypeSelectNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftBase = 
                node.getBase() != null ?
                        node.getBase().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        ExpressionNode liftSelect = 
                node.getSelect() != null ?
                        node.getSelect().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeParameterizedTypeSelectNode"),
                        factory.makeExpressionListNode(
                                liftBase,
                                liftSelect,
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode(), factory.makeMetaAnnotationListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeParenthesizedExpressionNode(ParenthesizedExpressionNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftExpression = 
                node.getExpression() != null ?
                        node.getExpression().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeParenthesizedExpressionNode"),
                        factory.makeExpressionListNode(
                                liftExpression,
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode(), factory.makeMetaAnnotationListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executePrimitiveTypeNode(PrimitiveTypeNode node, ExpressionNode factoryNode)
    {
        PrimitiveType liftPrimitiveTypeValue = 
                node.getPrimitiveType();
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makePrimitiveTypeNode"),
                        factory.makeExpressionListNode(
                                expressionizePrimitiveType(liftPrimitiveTypeValue),
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode(), factory.makeMetaAnnotationListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeQualifiedClassInstantiationNode(QualifiedClassInstantiationNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftEnclosingExpression = 
                node.getEnclosingExpression() != null ?
                        node.getEnclosingExpression().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        ExpressionNode liftIdentifier = 
                node.getIdentifier() != null ?
                        node.getIdentifier().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        ExpressionNode liftTypeArguments = 
                node.getTypeArguments() != null ?
                        node.getTypeArguments().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        ExpressionNode liftConstructorTypeArguments = 
                node.getConstructorTypeArguments() != null ?
                        node.getConstructorTypeArguments().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        ExpressionNode liftArguments = 
                node.getArguments() != null ?
                        node.getArguments().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        ExpressionNode liftBody = 
                node.getBody() != null ?
                        node.getBody().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        ExpressionNode liftMetaAnnotations = 
                node.getMetaAnnotations() != null ?
                        node.getMetaAnnotations().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeQualifiedClassInstantiationNode"),
                        factory.makeExpressionListNode(
                                liftEnclosingExpression,
                                liftIdentifier,
                                liftTypeArguments,
                                liftConstructorTypeArguments,
                                liftArguments,
                                liftBody,
                                liftMetaAnnotations,
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode(), factory.makeMetaAnnotationListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeQualifiedNameNode(QualifiedNameNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftBase = 
                node.getBase() != null ?
                        node.getBase().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        ExpressionNode liftIdentifier = 
                node.getIdentifier() != null ?
                        node.getIdentifier().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        NameCategory liftCategoryValue = 
                node.getCategory();
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeQualifiedNameNode"),
                        factory.makeExpressionListNode(
                                liftBase,
                                liftIdentifier,
                                expressionizeNameCategory(liftCategoryValue),
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode(), factory.makeMetaAnnotationListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeReferenceTypeListNode(ReferenceTypeListNode node, ExpressionNode factoryNode)
    {
        List<ExpressionNode> liftChildrenList = new ArrayList<ExpressionNode>();
        for (ReferenceTypeNode listval : node.getChildren())
        {
            liftChildrenList.add(
                    listval != null ? 
        			        listval.executeOperation(this,factoryNode) :
                            null);
        }
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeReferenceTypeListNode"),
                        factory.makeExpressionListNode(
                                factory.makeMethodInvocationByNameNode(
                                        factory.makeQualifiedNameNode(
                                                factory.makeQualifiedNameNode(
                                                        factory.makeQualifiedNameNode(
                                                                factory.makeSimpleNameNode(
                                                                        factory.makeIdentifierNode("java"),
                                                                        NameCategory.PACKAGE),
                                                                factory.makeIdentifierNode("util"),
                                                                NameCategory.PACKAGE),
                                                        factory.makeIdentifierNode("Arrays"),
                                                        NameCategory.TYPE),
                                                factory.makeIdentifierNode("asList"),
                                                NameCategory.METHOD),
                                        factory.makeExpressionListNode(liftChildrenList),
                                        factory.makeReferenceTypeListNode(
                                                factory.makeUnparameterizedTypeNode(
                                                        factory.makeSimpleNameNode(
                                                                factory.makeIdentifierNode("ReferenceTypeNode"),
                                                                NameCategory.TYPE)))),
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode(), factory.makeMetaAnnotationListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeReturnNode(ReturnNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftExpression = 
                node.getExpression() != null ?
                        node.getExpression().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeReturnNode"),
                        factory.makeExpressionListNode(
                                liftExpression,
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode(), factory.makeMetaAnnotationListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeSimpleNameNode(SimpleNameNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftIdentifier = 
                node.getIdentifier() != null ?
                        node.getIdentifier().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        NameCategory liftCategoryValue = 
                node.getCategory();
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeSimpleNameNode"),
                        factory.makeExpressionListNode(
                                liftIdentifier,
                                expressionizeNameCategory(liftCategoryValue),
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode(), factory.makeMetaAnnotationListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeSingleElementAnnotationNode(SingleElementAnnotationNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftValue = 
                node.getValue() != null ?
                        node.getValue().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        ExpressionNode liftAnnotationType = 
                node.getAnnotationType() != null ?
                        node.getAnnotationType().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeSingleElementAnnotationNode"),
                        factory.makeExpressionListNode(
                                liftValue,
                                liftAnnotationType,
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode(), factory.makeMetaAnnotationListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeSingleElementMetaAnnotationNode(SingleElementMetaAnnotationNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftValue = 
                node.getValue() != null ?
                        node.getValue().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        ExpressionNode liftAnnotationType = 
                node.getAnnotationType() != null ?
                        node.getAnnotationType().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeSingleElementMetaAnnotationNode"),
                        factory.makeExpressionListNode(
                                liftValue,
                                liftAnnotationType,
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode(), factory.makeMetaAnnotationListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeSingleStaticImportNode(SingleStaticImportNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftName = 
                node.getName() != null ?
                        node.getName().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        ExpressionNode liftIdentifier = 
                node.getIdentifier() != null ?
                        node.getIdentifier().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeSingleStaticImportNode"),
                        factory.makeExpressionListNode(
                                liftName,
                                liftIdentifier,
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode(), factory.makeMetaAnnotationListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeStatementExpressionListNode(StatementExpressionListNode node, ExpressionNode factoryNode)
    {
        List<ExpressionNode> liftChildrenList = new ArrayList<ExpressionNode>();
        for (StatementExpressionNode listval : node.getChildren())
        {
            liftChildrenList.add(
                    listval != null ? 
        			        listval.executeOperation(this,factoryNode) :
                            null);
        }
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeStatementExpressionListNode"),
                        factory.makeExpressionListNode(
                                factory.makeMethodInvocationByNameNode(
                                        factory.makeQualifiedNameNode(
                                                factory.makeQualifiedNameNode(
                                                        factory.makeQualifiedNameNode(
                                                                factory.makeSimpleNameNode(
                                                                        factory.makeIdentifierNode("java"),
                                                                        NameCategory.PACKAGE),
                                                                factory.makeIdentifierNode("util"),
                                                                NameCategory.PACKAGE),
                                                        factory.makeIdentifierNode("Arrays"),
                                                        NameCategory.TYPE),
                                                factory.makeIdentifierNode("asList"),
                                                NameCategory.METHOD),
                                        factory.makeExpressionListNode(liftChildrenList),
                                        factory.makeReferenceTypeListNode(
                                                factory.makeUnparameterizedTypeNode(
                                                        factory.makeSimpleNameNode(
                                                                factory.makeIdentifierNode("StatementExpressionNode"),
                                                                NameCategory.TYPE)))),
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode(), factory.makeMetaAnnotationListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeStaticImportOnDemandNode(StaticImportOnDemandNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftName = 
                node.getName() != null ?
                        node.getName().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeStaticImportOnDemandNode"),
                        factory.makeExpressionListNode(
                                liftName,
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode(), factory.makeMetaAnnotationListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeStringLiteralNode(StringLiteralNode node, ExpressionNode factoryNode)
    {
        String liftValueValue = 
                node.getValue();
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeStringLiteralNode"),
                        factory.makeExpressionListNode(
                                expressionizeString(liftValueValue),
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode(), factory.makeMetaAnnotationListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeSuperFieldAccessNode(SuperFieldAccessNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftType = 
                node.getType() != null ?
                        node.getType().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        ExpressionNode liftIdentifier = 
                node.getIdentifier() != null ?
                        node.getIdentifier().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeSuperFieldAccessNode"),
                        factory.makeExpressionListNode(
                                liftType,
                                liftIdentifier,
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode(), factory.makeMetaAnnotationListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeSuperMethodInvocationNode(SuperMethodInvocationNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftType = 
                node.getType() != null ?
                        node.getType().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        ExpressionNode liftIdentifier = 
                node.getIdentifier() != null ?
                        node.getIdentifier().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        ExpressionNode liftArguments = 
                node.getArguments() != null ?
                        node.getArguments().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        ExpressionNode liftTypeArguments = 
                node.getTypeArguments() != null ?
                        node.getTypeArguments().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        ExpressionNode liftMetaAnnotations = 
                node.getMetaAnnotations() != null ?
                        node.getMetaAnnotations().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeSuperMethodInvocationNode"),
                        factory.makeExpressionListNode(
                                liftType,
                                liftIdentifier,
                                liftArguments,
                                liftTypeArguments,
                                liftMetaAnnotations,
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode(), factory.makeMetaAnnotationListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeSuperclassConstructorInvocationNode(SuperclassConstructorInvocationNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftQualifyingExpression = 
                node.getQualifyingExpression() != null ?
                        node.getQualifyingExpression().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        ExpressionNode liftArguments = 
                node.getArguments() != null ?
                        node.getArguments().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        ExpressionNode liftTypeArguments = 
                node.getTypeArguments() != null ?
                        node.getTypeArguments().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeSuperclassConstructorInvocationNode"),
                        factory.makeExpressionListNode(
                                liftQualifyingExpression,
                                liftArguments,
                                liftTypeArguments,
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode(), factory.makeMetaAnnotationListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeSwitchNode(SwitchNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftExpression = 
                node.getExpression() != null ?
                        node.getExpression().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        ExpressionNode liftCases = 
                node.getCases() != null ?
                        node.getCases().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeSwitchNode"),
                        factory.makeExpressionListNode(
                                liftExpression,
                                liftCases,
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode(), factory.makeMetaAnnotationListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeSynchronizedNode(SynchronizedNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftExpression = 
                node.getExpression() != null ?
                        node.getExpression().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        ExpressionNode liftBlock = 
                node.getBlock() != null ?
                        node.getBlock().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeSynchronizedNode"),
                        factory.makeExpressionListNode(
                                liftExpression,
                                liftBlock,
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode(), factory.makeMetaAnnotationListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeThisNode(ThisNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftType = 
                node.getType() != null ?
                        node.getType().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeThisNode"),
                        factory.makeExpressionListNode(
                                liftType,
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode(), factory.makeMetaAnnotationListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeThrowNode(ThrowNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftExpression = 
                node.getExpression() != null ?
                        node.getExpression().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeThrowNode"),
                        factory.makeExpressionListNode(
                                liftExpression,
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode(), factory.makeMetaAnnotationListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeTryNode(TryNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftBlock = 
                node.getBlock() != null ?
                        node.getBlock().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        ExpressionNode liftCatches = 
                node.getCatches() != null ?
                        node.getCatches().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        ExpressionNode liftFinallyBlock = 
                node.getFinallyBlock() != null ?
                        node.getFinallyBlock().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeTryNode"),
                        factory.makeExpressionListNode(
                                liftBlock,
                                liftCatches,
                                liftFinallyBlock,
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode(), factory.makeMetaAnnotationListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeTypeArgumentListNode(TypeArgumentListNode node, ExpressionNode factoryNode)
    {
        List<ExpressionNode> liftChildrenList = new ArrayList<ExpressionNode>();
        for (TypeArgumentNode listval : node.getChildren())
        {
            liftChildrenList.add(
                    listval != null ? 
        			        listval.executeOperation(this,factoryNode) :
                            null);
        }
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeTypeArgumentListNode"),
                        factory.makeExpressionListNode(
                                factory.makeMethodInvocationByNameNode(
                                        factory.makeQualifiedNameNode(
                                                factory.makeQualifiedNameNode(
                                                        factory.makeQualifiedNameNode(
                                                                factory.makeSimpleNameNode(
                                                                        factory.makeIdentifierNode("java"),
                                                                        NameCategory.PACKAGE),
                                                                factory.makeIdentifierNode("util"),
                                                                NameCategory.PACKAGE),
                                                        factory.makeIdentifierNode("Arrays"),
                                                        NameCategory.TYPE),
                                                factory.makeIdentifierNode("asList"),
                                                NameCategory.METHOD),
                                        factory.makeExpressionListNode(liftChildrenList),
                                        factory.makeReferenceTypeListNode(
                                                factory.makeUnparameterizedTypeNode(
                                                        factory.makeSimpleNameNode(
                                                                factory.makeIdentifierNode("TypeArgumentNode"),
                                                                NameCategory.TYPE)))),
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode(), factory.makeMetaAnnotationListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeTypeCastNode(TypeCastNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftExpression = 
                node.getExpression() != null ?
                        node.getExpression().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        ExpressionNode liftType = 
                node.getType() != null ?
                        node.getType().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeTypeCastNode"),
                        factory.makeExpressionListNode(
                                liftExpression,
                                liftType,
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode(), factory.makeMetaAnnotationListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeTypeDeclarationListNode(TypeDeclarationListNode node, ExpressionNode factoryNode)
    {
        List<ExpressionNode> liftChildrenList = new ArrayList<ExpressionNode>();
        for (TypeDeclarationNode listval : node.getChildren())
        {
            liftChildrenList.add(
                    listval != null ? 
        			        listval.executeOperation(this,factoryNode) :
                            null);
        }
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeTypeDeclarationListNode"),
                        factory.makeExpressionListNode(
                                factory.makeMethodInvocationByNameNode(
                                        factory.makeQualifiedNameNode(
                                                factory.makeQualifiedNameNode(
                                                        factory.makeQualifiedNameNode(
                                                                factory.makeSimpleNameNode(
                                                                        factory.makeIdentifierNode("java"),
                                                                        NameCategory.PACKAGE),
                                                                factory.makeIdentifierNode("util"),
                                                                NameCategory.PACKAGE),
                                                        factory.makeIdentifierNode("Arrays"),
                                                        NameCategory.TYPE),
                                                factory.makeIdentifierNode("asList"),
                                                NameCategory.METHOD),
                                        factory.makeExpressionListNode(liftChildrenList),
                                        factory.makeReferenceTypeListNode(
                                                factory.makeUnparameterizedTypeNode(
                                                        factory.makeSimpleNameNode(
                                                                factory.makeIdentifierNode("TypeDeclarationNode"),
                                                                NameCategory.TYPE)))),
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode(), factory.makeMetaAnnotationListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeTypeDeclarationMetaprogramAnchorNode(TypeDeclarationMetaprogramAnchorNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftMetaprogram = 
                node.getMetaprogram() != null ?
                        node.getMetaprogram().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeTypeDeclarationMetaprogramAnchorNode"),
                        factory.makeExpressionListNode(
                                liftMetaprogram,
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode(), factory.makeMetaAnnotationListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeTypeParameterListNode(TypeParameterListNode node, ExpressionNode factoryNode)
    {
        List<ExpressionNode> liftChildrenList = new ArrayList<ExpressionNode>();
        for (TypeParameterNode listval : node.getChildren())
        {
            liftChildrenList.add(
                    listval != null ? 
        			        listval.executeOperation(this,factoryNode) :
                            null);
        }
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeTypeParameterListNode"),
                        factory.makeExpressionListNode(
                                factory.makeMethodInvocationByNameNode(
                                        factory.makeQualifiedNameNode(
                                                factory.makeQualifiedNameNode(
                                                        factory.makeQualifiedNameNode(
                                                                factory.makeSimpleNameNode(
                                                                        factory.makeIdentifierNode("java"),
                                                                        NameCategory.PACKAGE),
                                                                factory.makeIdentifierNode("util"),
                                                                NameCategory.PACKAGE),
                                                        factory.makeIdentifierNode("Arrays"),
                                                        NameCategory.TYPE),
                                                factory.makeIdentifierNode("asList"),
                                                NameCategory.METHOD),
                                        factory.makeExpressionListNode(liftChildrenList),
                                        factory.makeReferenceTypeListNode(
                                                factory.makeUnparameterizedTypeNode(
                                                        factory.makeSimpleNameNode(
                                                                factory.makeIdentifierNode("TypeParameterNode"),
                                                                NameCategory.TYPE)))),
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode(), factory.makeMetaAnnotationListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeTypeParameterNode(TypeParameterNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftIdentifier = 
                node.getIdentifier() != null ?
                        node.getIdentifier().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        ExpressionNode liftBounds = 
                node.getBounds() != null ?
                        node.getBounds().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeTypeParameterNode"),
                        factory.makeExpressionListNode(
                                liftIdentifier,
                                liftBounds,
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode(), factory.makeMetaAnnotationListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeUnaryExpressionNode(UnaryExpressionNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftExpression = 
                node.getExpression() != null ?
                        node.getExpression().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        UnaryOperator liftOperatorValue = 
                node.getOperator();
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeUnaryExpressionNode"),
                        factory.makeExpressionListNode(
                                liftExpression,
                                expressionizeUnaryOperator(liftOperatorValue),
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode(), factory.makeMetaAnnotationListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeUnaryStatementExpressionNode(UnaryStatementExpressionNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftExpression = 
                node.getExpression() != null ?
                        node.getExpression().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        UnaryStatementOperator liftOperatorValue = 
                node.getOperator();
        ExpressionNode liftMetaAnnotations = 
                node.getMetaAnnotations() != null ?
                        node.getMetaAnnotations().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeUnaryStatementExpressionNode"),
                        factory.makeExpressionListNode(
                                liftExpression,
                                expressionizeUnaryStatementOperator(liftOperatorValue),
                                liftMetaAnnotations,
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode(), factory.makeMetaAnnotationListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeUnparameterizedTypeListNode(UnparameterizedTypeListNode node, ExpressionNode factoryNode)
    {
        List<ExpressionNode> liftChildrenList = new ArrayList<ExpressionNode>();
        for (UnparameterizedTypeNode listval : node.getChildren())
        {
            liftChildrenList.add(
                    listval != null ? 
        			        listval.executeOperation(this,factoryNode) :
                            null);
        }
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeUnparameterizedTypeListNode"),
                        factory.makeExpressionListNode(
                                factory.makeMethodInvocationByNameNode(
                                        factory.makeQualifiedNameNode(
                                                factory.makeQualifiedNameNode(
                                                        factory.makeQualifiedNameNode(
                                                                factory.makeSimpleNameNode(
                                                                        factory.makeIdentifierNode("java"),
                                                                        NameCategory.PACKAGE),
                                                                factory.makeIdentifierNode("util"),
                                                                NameCategory.PACKAGE),
                                                        factory.makeIdentifierNode("Arrays"),
                                                        NameCategory.TYPE),
                                                factory.makeIdentifierNode("asList"),
                                                NameCategory.METHOD),
                                        factory.makeExpressionListNode(liftChildrenList),
                                        factory.makeReferenceTypeListNode(
                                                factory.makeUnparameterizedTypeNode(
                                                        factory.makeSimpleNameNode(
                                                                factory.makeIdentifierNode("UnparameterizedTypeNode"),
                                                                NameCategory.TYPE)))),
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode(), factory.makeMetaAnnotationListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeUnparameterizedTypeNode(UnparameterizedTypeNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftName = 
                node.getName() != null ?
                        node.getName().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeUnparameterizedTypeNode"),
                        factory.makeExpressionListNode(
                                liftName,
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode(), factory.makeMetaAnnotationListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeUnqualifiedClassInstantiationNode(UnqualifiedClassInstantiationNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftType = 
                node.getType() != null ?
                        node.getType().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        ExpressionNode liftConstructorTypeArguments = 
                node.getConstructorTypeArguments() != null ?
                        node.getConstructorTypeArguments().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        ExpressionNode liftArguments = 
                node.getArguments() != null ?
                        node.getArguments().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        ExpressionNode liftBody = 
                node.getBody() != null ?
                        node.getBody().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        ExpressionNode liftMetaAnnotations = 
                node.getMetaAnnotations() != null ?
                        node.getMetaAnnotations().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeUnqualifiedClassInstantiationNode"),
                        factory.makeExpressionListNode(
                                liftType,
                                liftConstructorTypeArguments,
                                liftArguments,
                                liftBody,
                                liftMetaAnnotations,
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode(), factory.makeMetaAnnotationListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeVariableDeclarationNode(VariableDeclarationNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftModifiers = 
                node.getModifiers() != null ?
                        node.getModifiers().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        ExpressionNode liftDeclarators = 
                node.getDeclarators() != null ?
                        node.getDeclarators().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeVariableDeclarationNode"),
                        factory.makeExpressionListNode(
                                liftModifiers,
                                liftDeclarators,
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode(), factory.makeMetaAnnotationListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeVariableDeclaratorListNode(VariableDeclaratorListNode node, ExpressionNode factoryNode)
    {
        List<ExpressionNode> liftChildrenList = new ArrayList<ExpressionNode>();
        for (VariableDeclaratorNode listval : node.getChildren())
        {
            liftChildrenList.add(
                    listval != null ? 
        			        listval.executeOperation(this,factoryNode) :
                            null);
        }
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeVariableDeclaratorListNode"),
                        factory.makeExpressionListNode(
                                factory.makeMethodInvocationByNameNode(
                                        factory.makeQualifiedNameNode(
                                                factory.makeQualifiedNameNode(
                                                        factory.makeQualifiedNameNode(
                                                                factory.makeSimpleNameNode(
                                                                        factory.makeIdentifierNode("java"),
                                                                        NameCategory.PACKAGE),
                                                                factory.makeIdentifierNode("util"),
                                                                NameCategory.PACKAGE),
                                                        factory.makeIdentifierNode("Arrays"),
                                                        NameCategory.TYPE),
                                                factory.makeIdentifierNode("asList"),
                                                NameCategory.METHOD),
                                        factory.makeExpressionListNode(liftChildrenList),
                                        factory.makeReferenceTypeListNode(
                                                factory.makeUnparameterizedTypeNode(
                                                        factory.makeSimpleNameNode(
                                                                factory.makeIdentifierNode("VariableDeclaratorNode"),
                                                                NameCategory.TYPE)))),
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode(), factory.makeMetaAnnotationListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeVariableDeclaratorNode(VariableDeclaratorNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftType = 
                node.getType() != null ?
                        node.getType().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        ExpressionNode liftName = 
                node.getName() != null ?
                        node.getName().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        ExpressionNode liftInitializer = 
                node.getInitializer() != null ?
                        node.getInitializer().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeVariableDeclaratorNode"),
                        factory.makeExpressionListNode(
                                liftType,
                                liftName,
                                liftInitializer,
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode(), factory.makeMetaAnnotationListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeVariableInitializerListNode(VariableInitializerListNode node, ExpressionNode factoryNode)
    {
        List<ExpressionNode> liftChildrenList = new ArrayList<ExpressionNode>();
        for (VariableInitializerNode listval : node.getChildren())
        {
            liftChildrenList.add(
                    listval != null ? 
        			        listval.executeOperation(this,factoryNode) :
                            null);
        }
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeVariableInitializerListNode"),
                        factory.makeExpressionListNode(
                                factory.makeMethodInvocationByNameNode(
                                        factory.makeQualifiedNameNode(
                                                factory.makeQualifiedNameNode(
                                                        factory.makeQualifiedNameNode(
                                                                factory.makeSimpleNameNode(
                                                                        factory.makeIdentifierNode("java"),
                                                                        NameCategory.PACKAGE),
                                                                factory.makeIdentifierNode("util"),
                                                                NameCategory.PACKAGE),
                                                        factory.makeIdentifierNode("Arrays"),
                                                        NameCategory.TYPE),
                                                factory.makeIdentifierNode("asList"),
                                                NameCategory.METHOD),
                                        factory.makeExpressionListNode(liftChildrenList),
                                        factory.makeReferenceTypeListNode(
                                                factory.makeUnparameterizedTypeNode(
                                                        factory.makeSimpleNameNode(
                                                                factory.makeIdentifierNode("VariableInitializerNode"),
                                                                NameCategory.TYPE)))),
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode(), factory.makeMetaAnnotationListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeVariableListNode(VariableListNode node, ExpressionNode factoryNode)
    {
        List<ExpressionNode> liftChildrenList = new ArrayList<ExpressionNode>();
        for (VariableNode listval : node.getChildren())
        {
            liftChildrenList.add(
                    listval != null ? 
        			        listval.executeOperation(this,factoryNode) :
                            null);
        }
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeVariableListNode"),
                        factory.makeExpressionListNode(
                                factory.makeMethodInvocationByNameNode(
                                        factory.makeQualifiedNameNode(
                                                factory.makeQualifiedNameNode(
                                                        factory.makeQualifiedNameNode(
                                                                factory.makeSimpleNameNode(
                                                                        factory.makeIdentifierNode("java"),
                                                                        NameCategory.PACKAGE),
                                                                factory.makeIdentifierNode("util"),
                                                                NameCategory.PACKAGE),
                                                        factory.makeIdentifierNode("Arrays"),
                                                        NameCategory.TYPE),
                                                factory.makeIdentifierNode("asList"),
                                                NameCategory.METHOD),
                                        factory.makeExpressionListNode(liftChildrenList),
                                        factory.makeReferenceTypeListNode(
                                                factory.makeUnparameterizedTypeNode(
                                                        factory.makeSimpleNameNode(
                                                                factory.makeIdentifierNode("VariableNode"),
                                                                NameCategory.TYPE)))),
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode(), factory.makeMetaAnnotationListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeVariableModifiersNode(VariableModifiersNode node, ExpressionNode factoryNode)
    {
        boolean liftFinalFlagValue = 
                node.getFinalFlag();
        ExpressionNode liftMetaAnnotations = 
                node.getMetaAnnotations() != null ?
                        node.getMetaAnnotations().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        ExpressionNode liftAnnotations = 
                node.getAnnotations() != null ?
                        node.getAnnotations().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeVariableModifiersNode"),
                        factory.makeExpressionListNode(
                                expressionizeBoolean(liftFinalFlagValue),
                                liftMetaAnnotations,
                                liftAnnotations,
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode(), factory.makeMetaAnnotationListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeVariableNode(VariableNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftModifiers = 
                node.getModifiers() != null ?
                        node.getModifiers().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        ExpressionNode liftType = 
                node.getType() != null ?
                        node.getType().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        ExpressionNode liftIdentifier = 
                node.getIdentifier() != null ?
                        node.getIdentifier().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeVariableNode"),
                        factory.makeExpressionListNode(
                                liftModifiers,
                                liftType,
                                liftIdentifier,
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode(), factory.makeMetaAnnotationListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeVoidTypeNode(VoidTypeNode node, ExpressionNode factoryNode)
    {
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeVoidTypeNode"),
                        factory.makeExpressionListNode(
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode(), factory.makeMetaAnnotationListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeWhileLoopNode(WhileLoopNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftCondition = 
                node.getCondition() != null ?
                        node.getCondition().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        ExpressionNode liftStatement = 
                node.getStatement() != null ?
                        node.getStatement().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeWhileLoopNode"),
                        factory.makeExpressionListNode(
                                liftCondition,
                                liftStatement,
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode(), factory.makeMetaAnnotationListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeWildcardTypeNode(WildcardTypeNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftBound = 
                node.getBound() != null ?
                        node.getBound().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        boolean liftUpperBoundValue = 
                node.getUpperBound();
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeWildcardTypeNode"),
                        factory.makeExpressionListNode(
                                liftBound,
                                expressionizeBoolean(liftUpperBoundValue),
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode(), factory.makeMetaAnnotationListNode());
        
        return ret;
    }
    
}
