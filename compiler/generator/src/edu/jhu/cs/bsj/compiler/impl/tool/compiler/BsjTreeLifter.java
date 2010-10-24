/*
 * WARNING: THIS FILE IS GENERATED.  Do not make any changes to this file
 * directly; it was generated from the BSJ source generator project.  If changes
 * are necessary, changes must be applied either to the source generator
 * application or to one of its data files.  The source generator's fully
 * qualified name is edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator.
 */

package edu.jhu.cs.bsj.compiler.impl.tool.compiler;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.AccessModifier;
import edu.jhu.cs.bsj.compiler.ast.AssignmentOperator;
import edu.jhu.cs.bsj.compiler.ast.BinaryOperator;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeOperation;
import edu.jhu.cs.bsj.compiler.ast.BsjRawCodeLiteralPayload;
import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.MetaprogramLocalMode;
import edu.jhu.cs.bsj.compiler.ast.MetaprogramPackageMode;
import edu.jhu.cs.bsj.compiler.ast.NameCategory;
import edu.jhu.cs.bsj.compiler.ast.NodeUnion;
import edu.jhu.cs.bsj.compiler.ast.PrimitiveType;
import edu.jhu.cs.bsj.compiler.ast.UnaryOperator;
import edu.jhu.cs.bsj.compiler.ast.UnaryStatementOperator;
import edu.jhu.cs.bsj.compiler.ast.node.*;
import edu.jhu.cs.bsj.compiler.ast.node.list.AnnotationElementListNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.AnnotationListNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.AnnotationMemberListNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.AnnotationValueListNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.AnonymousClassMemberListNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.BlockStatementListNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.CaseListNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.CatchListNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.ClassMemberListNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.DeclaredTypeListNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.EnumConstantDeclarationListNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.ExpressionListNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.IdentifierListNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.ImportListNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.InterfaceMemberListNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.ReferenceTypeListNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.StatementExpressionListNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.TypeArgumentListNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.TypeDeclarationListNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.TypeParameterListNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.UnparameterizedTypeListNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.VariableDeclaratorListNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.VariableInitializerListNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.VariableListNode;
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
import edu.jhu.cs.bsj.compiler.ast.node.meta.RawCodeLiteralNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.SingleElementMetaAnnotationNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.SpliceNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.TypeDeclarationMetaprogramAnchorNode;
import edu.jhu.cs.bsj.compiler.tool.parser.antlr.BsjRawCodeLiteralPayloadAntlrImpl;
import edu.jhu.cs.bsj.compiler.tool.parser.antlr.BsjTokenImpl;

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
 * TODO: rework example code
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
					factory.makeUnparameterizedTypeNode(factory.makeSimpleNameNode(factory.makeIdentifierNode("BsjSourceLocation"))),
					factory.makeTypeArgumentListNode(),
					factory.makeExpressionListNode(factory.makeStringLiteralNode(location.getResourceName()),
							factory.makeIntLiteralNode(location.getLine()),
							factory.makeIntLiteralNode(location.getColumn())), null);
		}
	}

	protected ExpressionNode expressionizeBsjRawCodeLiteralPayload(BsjRawCodeLiteralPayload payload)
	{
		if (payload == null)
		{
			return factory.makeNullLiteralNode();
		} else if (!(payload instanceof BsjRawCodeLiteralPayloadAntlrImpl))
		{
			throw new IllegalArgumentException("Invalid raw code literal payload type " + payload.getClass());
		} else
		{
			BsjRawCodeLiteralPayloadAntlrImpl payloadImpl = (BsjRawCodeLiteralPayloadAntlrImpl) payload;
			List<BsjTokenImpl> tokens = payloadImpl.getTokens();

			ExpressionListNode tokenInstantiationExpressionList;
			List<ExpressionNode> tokenInstantiationExpressions = new ArrayList<ExpressionNode>();

			for (BsjTokenImpl token : tokens)
			{
				tokenInstantiationExpressions.add(factory.makeUnqualifiedClassInstantiationNode(
						factory.makeUnparameterizedTypeNode(factory.parseNameNode("edu.jhu.cs.bsj.compiler.tool.parser.antlr.BsjTokenImpl")),
						factory.makeExpressionListNode(factory.makeIntLiteralNode(token.getChannel()),
								factory.makeIntLiteralNode(token.getCharPositionInLine()),
								factory.makeIntLiteralNode(token.getLine()),
								factory.makeStringLiteralNode(token.getText()),
								factory.makeIntLiteralNode(token.getTokenIndex()),
								factory.makeIntLiteralNode(token.getType()))));
			}
			tokenInstantiationExpressionList = factory.makeExpressionListNode(tokenInstantiationExpressions);

			return factory.makeUnqualifiedClassInstantiationNode(
					factory.makeUnparameterizedTypeNode(factory.makeSimpleNameNode(factory.makeIdentifierNode("BsjRawCodeLiteralPayload"))),
					factory.makeExpressionListNode(
							factory.makeStringLiteralNode(payloadImpl.getResourceName()),
							factory.makeMethodInvocationNode(
									factory.makeVariableAccessNode(factory.makeVariableAccessNode(
											factory.makeVariableAccessNode(factory.makeIdentifierNode("java")),
											factory.makeIdentifierNode("util")), factory.makeIdentifierNode("Arrays")),
									factory.makeIdentifierNode("asList"),
									tokenInstantiationExpressionList,
									factory.makeReferenceTypeListNode(factory.makeUnparameterizedTypeNode(factory.parseNameNode("edu.jhu.cs.bsj.compiler.tool.parser.antlr.BsjTokenImpl"))))));
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
            return factory.makeVariableAccessNode(
                    factory.makeVariableAccessNode(null,
                            factory.makeIdentifierNode("PrimitiveType")
                            ),
                    factory.makeIdentifierNode(x.name()));
        }
    }
    
    protected ExpressionNode expressionizeUnaryStatementOperator(UnaryStatementOperator x)
    {
        if (x == null)
        {
            return factory.makeNullLiteralNode();
        } else
        {
            return factory.makeVariableAccessNode(
                    factory.makeVariableAccessNode(null,
                            factory.makeIdentifierNode("UnaryStatementOperator")
                            ),
                    factory.makeIdentifierNode(x.name()));
        }
    }
    
    protected ExpressionNode expressionizeAssignmentOperator(AssignmentOperator x)
    {
        if (x == null)
        {
            return factory.makeNullLiteralNode();
        } else
        {
            return factory.makeVariableAccessNode(
                    factory.makeVariableAccessNode(null,
                            factory.makeIdentifierNode("AssignmentOperator")
                            ),
                    factory.makeIdentifierNode(x.name()));
        }
    }
    
    protected ExpressionNode expressionizeBinaryOperator(BinaryOperator x)
    {
        if (x == null)
        {
            return factory.makeNullLiteralNode();
        } else
        {
            return factory.makeVariableAccessNode(
                    factory.makeVariableAccessNode(null,
                            factory.makeIdentifierNode("BinaryOperator")
                            ),
                    factory.makeIdentifierNode(x.name()));
        }
    }
    
    protected ExpressionNode expressionizeNameCategory(NameCategory x)
    {
        if (x == null)
        {
            return factory.makeNullLiteralNode();
        } else
        {
            return factory.makeVariableAccessNode(
                    factory.makeVariableAccessNode(null,
                            factory.makeIdentifierNode("NameCategory")
                            ),
                    factory.makeIdentifierNode(x.name()));
        }
    }
    
    protected ExpressionNode expressionizeUnaryOperator(UnaryOperator x)
    {
        if (x == null)
        {
            return factory.makeNullLiteralNode();
        } else
        {
            return factory.makeVariableAccessNode(
                    factory.makeVariableAccessNode(null,
                            factory.makeIdentifierNode("UnaryOperator")
                            ),
                    factory.makeIdentifierNode(x.name()));
        }
    }
    
    protected ExpressionNode expressionizeMetaprogramPackageMode(MetaprogramPackageMode x)
    {
        if (x == null)
        {
            return factory.makeNullLiteralNode();
        } else
        {
            return factory.makeVariableAccessNode(
                    factory.makeVariableAccessNode(null,
                            factory.makeIdentifierNode("MetaprogramPackageMode")
                            ),
                    factory.makeIdentifierNode(x.name()));
        }
    }
    
    protected ExpressionNode expressionizeMetaprogramLocalMode(MetaprogramLocalMode x)
    {
        if (x == null)
        {
            return factory.makeNullLiteralNode();
        } else
        {
            return factory.makeVariableAccessNode(
                    factory.makeVariableAccessNode(null,
                            factory.makeIdentifierNode("MetaprogramLocalMode")
                            ),
                    factory.makeIdentifierNode(x.name()));
        }
    }
    
    protected ExpressionNode expressionizeAccessModifier(AccessModifier x)
    {
        if (x == null)
        {
            return factory.makeNullLiteralNode();
        } else
        {
            return factory.makeVariableAccessNode(
                    factory.makeVariableAccessNode(null,
                            factory.makeIdentifierNode("AccessModifier")
                            ),
                    factory.makeIdentifierNode(x.name()));
        }
    }
    
    @Override
    public ExpressionNode executeAlternateConstructorInvocationNode(AlternateConstructorInvocationNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftArguments = 
                node.getUnionForArguments().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForArguments().getSpliceNode(), factoryNode, "ExpressionListNode") :
                expressionizeNormalNodeUnion(node.getArguments(), factoryNode, "ExpressionListNode");
        ExpressionNode liftTypeArguments = 
                node.getUnionForTypeArguments().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForTypeArguments().getSpliceNode(), factoryNode, "ReferenceTypeListNode") :
                expressionizeNormalNodeUnion(node.getTypeArguments(), factoryNode, "ReferenceTypeListNode");
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeAlternateConstructorInvocationNodeWithUnions"),
                        factory.makeExpressionListNode(
                                liftArguments,
                                liftTypeArguments,
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeAnnotationAnnotationValueNode(AnnotationAnnotationValueNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftAnnotation = 
                node.getUnionForAnnotation().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForAnnotation().getSpliceNode(), factoryNode, "AnnotationNode") :
                expressionizeNormalNodeUnion(node.getAnnotation(), factoryNode, "AnnotationNode");
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeAnnotationAnnotationValueNodeWithUnions"),
                        factory.makeExpressionListNode(
                                liftAnnotation,
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeAnnotationArrayValueNode(AnnotationArrayValueNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftValues = 
                node.getUnionForValues().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForValues().getSpliceNode(), factoryNode, "AnnotationValueListNode") :
                expressionizeNormalNodeUnion(node.getValues(), factoryNode, "AnnotationValueListNode");
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeAnnotationArrayValueNodeWithUnions"),
                        factory.makeExpressionListNode(
                                liftValues,
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeAnnotationBodyNode(AnnotationBodyNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftMembers = 
                node.getUnionForMembers().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForMembers().getSpliceNode(), factoryNode, "AnnotationMemberListNode") :
                expressionizeNormalNodeUnion(node.getMembers(), factoryNode, "AnnotationMemberListNode");
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeAnnotationBodyNodeWithUnions"),
                        factory.makeExpressionListNode(
                                liftMembers,
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeAnnotationDeclarationNode(AnnotationDeclarationNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftModifiers = 
                node.getUnionForModifiers().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForModifiers().getSpliceNode(), factoryNode, "AnnotationModifiersNode") :
                expressionizeNormalNodeUnion(node.getModifiers(), factoryNode, "AnnotationModifiersNode");
        ExpressionNode liftBody = 
                node.getUnionForBody().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForBody().getSpliceNode(), factoryNode, "AnnotationBodyNode") :
                expressionizeNormalNodeUnion(node.getBody(), factoryNode, "AnnotationBodyNode");
        ExpressionNode liftIdentifier = 
                node.getUnionForIdentifier().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForIdentifier().getSpliceNode(), factoryNode, "IdentifierNode") :
                expressionizeNormalNodeUnion(node.getIdentifier(), factoryNode, "IdentifierNode");
        ExpressionNode liftJavadoc = 
                node.getUnionForJavadoc().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForJavadoc().getSpliceNode(), factoryNode, "JavadocNode") :
                expressionizeNormalNodeUnion(node.getJavadoc(), factoryNode, "JavadocNode");
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeAnnotationDeclarationNodeWithUnions"),
                        factory.makeExpressionListNode(
                                liftModifiers,
                                liftBody,
                                liftIdentifier,
                                liftJavadoc,
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeAnnotationElementListNode(AnnotationElementListNode node, ExpressionNode factoryNode)
    {
        List<ExpressionNode> liftChildrenList = new ArrayList<ExpressionNode>();
        for (NodeUnion<? extends AnnotationElementNode> listval : node.getUnionForChildren())
        {
            liftChildrenList.add(
                    listval != null ? 
                            (listval.getType() == NodeUnion.Type.SPLICE ? 
                                    expressionizeSpliceNodeUnion(listval.getSpliceNode(), factoryNode, "AnnotationElementNode") :
                            expressionizeNormalNodeUnion(listval.getNormalNode(), factoryNode, "AnnotationElementNode"))
                            : factory.makeNullLiteralNode());
        }
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeAnnotationElementListNodeWithUnions"),
                        factory.makeExpressionListNode(
                                factory.makeMethodInvocationNode(
                                        factory.makeVariableAccessNode(
                                                factory.makeVariableAccessNode(
                                                        factory.makeVariableAccessNode(
                                                                factory.makeVariableAccessNode(
                                                                        factory.makeVariableAccessNode(
                                                                                factory.makeVariableAccessNode(
                                                                                        factory.makeVariableAccessNode(
                                                                                                factory.makeVariableAccessNode(
                                                                                                        factory.makeIdentifierNode("edu")),
                                                                                                factory.makeIdentifierNode("jhu")),
                                                                                        factory.makeIdentifierNode("cs")),
                                                                                factory.makeIdentifierNode("bsj")),
                                                                        factory.makeIdentifierNode("compiler")),
                                                                factory.makeIdentifierNode("impl")),
                                                        factory.makeIdentifierNode("utils")),
                                                factory.makeIdentifierNode("CollectionUtilities")),
                                        factory.makeIdentifierNode("listOf"),
                                        factory.makeExpressionListNode(liftChildrenList),
                                        factory.makeReferenceTypeListNode(
                                                factory.makeParameterizedTypeNode(
                                                        factory.makeUnparameterizedTypeNode(
                                                                factory.makeSimpleNameNode(
                                                                        factory.makeIdentifierNode("NodeUnion"))),
                                                        factory.makeTypeArgumentListNode(
                                                                factory.makeWildcardTypeNode(
                                                                        factory.makeUnparameterizedTypeNode(
                                                                                factory.makeSimpleNameNode(
                                                                                        factory.makeIdentifierNode("AnnotationElementNode"))),
                                                                        true))))),
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeAnnotationElementNode(AnnotationElementNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftIdentifier = 
                node.getUnionForIdentifier().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForIdentifier().getSpliceNode(), factoryNode, "IdentifierNode") :
                expressionizeNormalNodeUnion(node.getIdentifier(), factoryNode, "IdentifierNode");
        ExpressionNode liftValue = 
                node.getUnionForValue().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForValue().getSpliceNode(), factoryNode, "AnnotationValueNode") :
                expressionizeNormalNodeUnion(node.getValue(), factoryNode, "AnnotationValueNode");
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeAnnotationElementNodeWithUnions"),
                        factory.makeExpressionListNode(
                                liftIdentifier,
                                liftValue,
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeAnnotationExpressionValueNode(AnnotationExpressionValueNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftExpression = 
                node.getUnionForExpression().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForExpression().getSpliceNode(), factoryNode, "NonAssignmentExpressionNode") :
                expressionizeNormalNodeUnion(node.getExpression(), factoryNode, "NonAssignmentExpressionNode");
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeAnnotationExpressionValueNodeWithUnions"),
                        factory.makeExpressionListNode(
                                liftExpression,
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeAnnotationListNode(AnnotationListNode node, ExpressionNode factoryNode)
    {
        List<ExpressionNode> liftChildrenList = new ArrayList<ExpressionNode>();
        for (NodeUnion<? extends AnnotationNode> listval : node.getUnionForChildren())
        {
            liftChildrenList.add(
                    listval != null ? 
                            (listval.getType() == NodeUnion.Type.SPLICE ? 
                                    expressionizeSpliceNodeUnion(listval.getSpliceNode(), factoryNode, "AnnotationNode") :
                            expressionizeNormalNodeUnion(listval.getNormalNode(), factoryNode, "AnnotationNode"))
                            : factory.makeNullLiteralNode());
        }
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeAnnotationListNodeWithUnions"),
                        factory.makeExpressionListNode(
                                factory.makeMethodInvocationNode(
                                        factory.makeVariableAccessNode(
                                                factory.makeVariableAccessNode(
                                                        factory.makeVariableAccessNode(
                                                                factory.makeVariableAccessNode(
                                                                        factory.makeVariableAccessNode(
                                                                                factory.makeVariableAccessNode(
                                                                                        factory.makeVariableAccessNode(
                                                                                                factory.makeVariableAccessNode(
                                                                                                        factory.makeIdentifierNode("edu")),
                                                                                                factory.makeIdentifierNode("jhu")),
                                                                                        factory.makeIdentifierNode("cs")),
                                                                                factory.makeIdentifierNode("bsj")),
                                                                        factory.makeIdentifierNode("compiler")),
                                                                factory.makeIdentifierNode("impl")),
                                                        factory.makeIdentifierNode("utils")),
                                                factory.makeIdentifierNode("CollectionUtilities")),
                                        factory.makeIdentifierNode("listOf"),
                                        factory.makeExpressionListNode(liftChildrenList),
                                        factory.makeReferenceTypeListNode(
                                                factory.makeParameterizedTypeNode(
                                                        factory.makeUnparameterizedTypeNode(
                                                                factory.makeSimpleNameNode(
                                                                        factory.makeIdentifierNode("NodeUnion"))),
                                                        factory.makeTypeArgumentListNode(
                                                                factory.makeWildcardTypeNode(
                                                                        factory.makeUnparameterizedTypeNode(
                                                                                factory.makeSimpleNameNode(
                                                                                        factory.makeIdentifierNode("AnnotationNode"))),
                                                                        true))))),
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeAnnotationMemberListNode(AnnotationMemberListNode node, ExpressionNode factoryNode)
    {
        List<ExpressionNode> liftChildrenList = new ArrayList<ExpressionNode>();
        for (NodeUnion<? extends AnnotationMemberNode> listval : node.getUnionForChildren())
        {
            liftChildrenList.add(
                    listval != null ? 
                            (listval.getType() == NodeUnion.Type.SPLICE ? 
                                    expressionizeSpliceNodeUnion(listval.getSpliceNode(), factoryNode, "AnnotationMemberNode") :
                            expressionizeNormalNodeUnion(listval.getNormalNode(), factoryNode, "AnnotationMemberNode"))
                            : factory.makeNullLiteralNode());
        }
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeAnnotationMemberListNodeWithUnions"),
                        factory.makeExpressionListNode(
                                factory.makeMethodInvocationNode(
                                        factory.makeVariableAccessNode(
                                                factory.makeVariableAccessNode(
                                                        factory.makeVariableAccessNode(
                                                                factory.makeVariableAccessNode(
                                                                        factory.makeVariableAccessNode(
                                                                                factory.makeVariableAccessNode(
                                                                                        factory.makeVariableAccessNode(
                                                                                                factory.makeVariableAccessNode(
                                                                                                        factory.makeIdentifierNode("edu")),
                                                                                                factory.makeIdentifierNode("jhu")),
                                                                                        factory.makeIdentifierNode("cs")),
                                                                                factory.makeIdentifierNode("bsj")),
                                                                        factory.makeIdentifierNode("compiler")),
                                                                factory.makeIdentifierNode("impl")),
                                                        factory.makeIdentifierNode("utils")),
                                                factory.makeIdentifierNode("CollectionUtilities")),
                                        factory.makeIdentifierNode("listOf"),
                                        factory.makeExpressionListNode(liftChildrenList),
                                        factory.makeReferenceTypeListNode(
                                                factory.makeParameterizedTypeNode(
                                                        factory.makeUnparameterizedTypeNode(
                                                                factory.makeSimpleNameNode(
                                                                        factory.makeIdentifierNode("NodeUnion"))),
                                                        factory.makeTypeArgumentListNode(
                                                                factory.makeWildcardTypeNode(
                                                                        factory.makeUnparameterizedTypeNode(
                                                                                factory.makeSimpleNameNode(
                                                                                        factory.makeIdentifierNode("AnnotationMemberNode"))),
                                                                        true))))),
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeAnnotationMemberMetaprogramAnchorNode(AnnotationMemberMetaprogramAnchorNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftMetaprogram = 
                node.getUnionForMetaprogram().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForMetaprogram().getSpliceNode(), factoryNode, "MetaprogramNode") :
                expressionizeNormalNodeUnion(node.getMetaprogram(), factoryNode, "MetaprogramNode");
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeAnnotationMemberMetaprogramAnchorNodeWithUnions"),
                        factory.makeExpressionListNode(
                                liftMetaprogram,
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeAnnotationMethodDeclarationNode(AnnotationMethodDeclarationNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftModifiers = 
                node.getUnionForModifiers().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForModifiers().getSpliceNode(), factoryNode, "AnnotationMethodModifiersNode") :
                expressionizeNormalNodeUnion(node.getModifiers(), factoryNode, "AnnotationMethodModifiersNode");
        ExpressionNode liftType = 
                node.getUnionForType().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForType().getSpliceNode(), factoryNode, "TypeNode") :
                expressionizeNormalNodeUnion(node.getType(), factoryNode, "TypeNode");
        ExpressionNode liftIdentifier = 
                node.getUnionForIdentifier().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForIdentifier().getSpliceNode(), factoryNode, "IdentifierNode") :
                expressionizeNormalNodeUnion(node.getIdentifier(), factoryNode, "IdentifierNode");
        ExpressionNode liftDefaultValue = 
                node.getUnionForDefaultValue().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForDefaultValue().getSpliceNode(), factoryNode, "AnnotationValueNode") :
                expressionizeNormalNodeUnion(node.getDefaultValue(), factoryNode, "AnnotationValueNode");
        ExpressionNode liftJavadoc = 
                node.getUnionForJavadoc().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForJavadoc().getSpliceNode(), factoryNode, "JavadocNode") :
                expressionizeNormalNodeUnion(node.getJavadoc(), factoryNode, "JavadocNode");
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeAnnotationMethodDeclarationNodeWithUnions"),
                        factory.makeExpressionListNode(
                                liftModifiers,
                                liftType,
                                liftIdentifier,
                                liftDefaultValue,
                                liftJavadoc,
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeAnnotationMethodModifiersNode(AnnotationMethodModifiersNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftMetaAnnotations = 
                node.getUnionForMetaAnnotations().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForMetaAnnotations().getSpliceNode(), factoryNode, "MetaAnnotationListNode") :
                expressionizeNormalNodeUnion(node.getMetaAnnotations(), factoryNode, "MetaAnnotationListNode");
        ExpressionNode liftAnnotations = 
                node.getUnionForAnnotations().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForAnnotations().getSpliceNode(), factoryNode, "AnnotationListNode") :
                expressionizeNormalNodeUnion(node.getAnnotations(), factoryNode, "AnnotationListNode");
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeAnnotationMethodModifiersNodeWithUnions"),
                        factory.makeExpressionListNode(
                                liftMetaAnnotations,
                                liftAnnotations,
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode());
        
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
                node.getUnionForMetaAnnotations().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForMetaAnnotations().getSpliceNode(), factoryNode, "MetaAnnotationListNode") :
                expressionizeNormalNodeUnion(node.getMetaAnnotations(), factoryNode, "MetaAnnotationListNode");
        ExpressionNode liftAnnotations = 
                node.getUnionForAnnotations().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForAnnotations().getSpliceNode(), factoryNode, "AnnotationListNode") :
                expressionizeNormalNodeUnion(node.getAnnotations(), factoryNode, "AnnotationListNode");
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeAnnotationModifiersNodeWithUnions"),
                        factory.makeExpressionListNode(
                                expressionizeAccessModifier(liftAccessValue),
                                expressionizeBoolean(liftStaticFlagValue),
                                expressionizeBoolean(liftStrictfpFlagValue),
                                liftMetaAnnotations,
                                liftAnnotations,
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeAnnotationValueListNode(AnnotationValueListNode node, ExpressionNode factoryNode)
    {
        List<ExpressionNode> liftChildrenList = new ArrayList<ExpressionNode>();
        for (NodeUnion<? extends AnnotationValueNode> listval : node.getUnionForChildren())
        {
            liftChildrenList.add(
                    listval != null ? 
                            (listval.getType() == NodeUnion.Type.SPLICE ? 
                                    expressionizeSpliceNodeUnion(listval.getSpliceNode(), factoryNode, "AnnotationValueNode") :
                            expressionizeNormalNodeUnion(listval.getNormalNode(), factoryNode, "AnnotationValueNode"))
                            : factory.makeNullLiteralNode());
        }
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeAnnotationValueListNodeWithUnions"),
                        factory.makeExpressionListNode(
                                factory.makeMethodInvocationNode(
                                        factory.makeVariableAccessNode(
                                                factory.makeVariableAccessNode(
                                                        factory.makeVariableAccessNode(
                                                                factory.makeVariableAccessNode(
                                                                        factory.makeVariableAccessNode(
                                                                                factory.makeVariableAccessNode(
                                                                                        factory.makeVariableAccessNode(
                                                                                                factory.makeVariableAccessNode(
                                                                                                        factory.makeIdentifierNode("edu")),
                                                                                                factory.makeIdentifierNode("jhu")),
                                                                                        factory.makeIdentifierNode("cs")),
                                                                                factory.makeIdentifierNode("bsj")),
                                                                        factory.makeIdentifierNode("compiler")),
                                                                factory.makeIdentifierNode("impl")),
                                                        factory.makeIdentifierNode("utils")),
                                                factory.makeIdentifierNode("CollectionUtilities")),
                                        factory.makeIdentifierNode("listOf"),
                                        factory.makeExpressionListNode(liftChildrenList),
                                        factory.makeReferenceTypeListNode(
                                                factory.makeParameterizedTypeNode(
                                                        factory.makeUnparameterizedTypeNode(
                                                                factory.makeSimpleNameNode(
                                                                        factory.makeIdentifierNode("NodeUnion"))),
                                                        factory.makeTypeArgumentListNode(
                                                                factory.makeWildcardTypeNode(
                                                                        factory.makeUnparameterizedTypeNode(
                                                                                factory.makeSimpleNameNode(
                                                                                        factory.makeIdentifierNode("AnnotationValueNode"))),
                                                                        true))))),
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeAnonymousClassBodyNode(AnonymousClassBodyNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftMembers = 
                node.getUnionForMembers().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForMembers().getSpliceNode(), factoryNode, "AnonymousClassMemberListNode") :
                expressionizeNormalNodeUnion(node.getMembers(), factoryNode, "AnonymousClassMemberListNode");
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeAnonymousClassBodyNodeWithUnions"),
                        factory.makeExpressionListNode(
                                liftMembers,
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeAnonymousClassMemberListNode(AnonymousClassMemberListNode node, ExpressionNode factoryNode)
    {
        List<ExpressionNode> liftChildrenList = new ArrayList<ExpressionNode>();
        for (NodeUnion<? extends AnonymousClassMemberNode> listval : node.getUnionForChildren())
        {
            liftChildrenList.add(
                    listval != null ? 
                            (listval.getType() == NodeUnion.Type.SPLICE ? 
                                    expressionizeSpliceNodeUnion(listval.getSpliceNode(), factoryNode, "AnonymousClassMemberNode") :
                            expressionizeNormalNodeUnion(listval.getNormalNode(), factoryNode, "AnonymousClassMemberNode"))
                            : factory.makeNullLiteralNode());
        }
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeAnonymousClassMemberListNodeWithUnions"),
                        factory.makeExpressionListNode(
                                factory.makeMethodInvocationNode(
                                        factory.makeVariableAccessNode(
                                                factory.makeVariableAccessNode(
                                                        factory.makeVariableAccessNode(
                                                                factory.makeVariableAccessNode(
                                                                        factory.makeVariableAccessNode(
                                                                                factory.makeVariableAccessNode(
                                                                                        factory.makeVariableAccessNode(
                                                                                                factory.makeVariableAccessNode(
                                                                                                        factory.makeIdentifierNode("edu")),
                                                                                                factory.makeIdentifierNode("jhu")),
                                                                                        factory.makeIdentifierNode("cs")),
                                                                                factory.makeIdentifierNode("bsj")),
                                                                        factory.makeIdentifierNode("compiler")),
                                                                factory.makeIdentifierNode("impl")),
                                                        factory.makeIdentifierNode("utils")),
                                                factory.makeIdentifierNode("CollectionUtilities")),
                                        factory.makeIdentifierNode("listOf"),
                                        factory.makeExpressionListNode(liftChildrenList),
                                        factory.makeReferenceTypeListNode(
                                                factory.makeParameterizedTypeNode(
                                                        factory.makeUnparameterizedTypeNode(
                                                                factory.makeSimpleNameNode(
                                                                        factory.makeIdentifierNode("NodeUnion"))),
                                                        factory.makeTypeArgumentListNode(
                                                                factory.makeWildcardTypeNode(
                                                                        factory.makeUnparameterizedTypeNode(
                                                                                factory.makeSimpleNameNode(
                                                                                        factory.makeIdentifierNode("AnonymousClassMemberNode"))),
                                                                        true))))),
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeAnonymousClassMemberMetaprogramAnchorNode(AnonymousClassMemberMetaprogramAnchorNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftMetaprogram = 
                node.getUnionForMetaprogram().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForMetaprogram().getSpliceNode(), factoryNode, "MetaprogramNode") :
                expressionizeNormalNodeUnion(node.getMetaprogram(), factoryNode, "MetaprogramNode");
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeAnonymousClassMemberMetaprogramAnchorNodeWithUnions"),
                        factory.makeExpressionListNode(
                                liftMetaprogram,
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeArrayAccessNode(ArrayAccessNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftArrayExpression = 
                node.getUnionForArrayExpression().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForArrayExpression().getSpliceNode(), factoryNode, "RestrictedPrimaryExpressionNode") :
                expressionizeNormalNodeUnion(node.getArrayExpression(), factoryNode, "RestrictedPrimaryExpressionNode");
        ExpressionNode liftIndexExpression = 
                node.getUnionForIndexExpression().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForIndexExpression().getSpliceNode(), factoryNode, "ExpressionNode") :
                expressionizeNormalNodeUnion(node.getIndexExpression(), factoryNode, "ExpressionNode");
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeArrayAccessNodeWithUnions"),
                        factory.makeExpressionListNode(
                                liftArrayExpression,
                                liftIndexExpression,
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeArrayInitializerCreationNode(ArrayInitializerCreationNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftInitializer = 
                node.getUnionForInitializer().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForInitializer().getSpliceNode(), factoryNode, "ArrayInitializerNode") :
                expressionizeNormalNodeUnion(node.getInitializer(), factoryNode, "ArrayInitializerNode");
        ExpressionNode liftBaseType = 
                node.getUnionForBaseType().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForBaseType().getSpliceNode(), factoryNode, "BaseTypeNode") :
                expressionizeNormalNodeUnion(node.getBaseType(), factoryNode, "BaseTypeNode");
        int liftArrayLevelsValue = 
                node.getArrayLevels();
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeArrayInitializerCreationNodeWithUnions"),
                        factory.makeExpressionListNode(
                                liftInitializer,
                                liftBaseType,
                                expressionizeInt(liftArrayLevelsValue),
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeArrayInitializerNode(ArrayInitializerNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftInitializers = 
                node.getUnionForInitializers().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForInitializers().getSpliceNode(), factoryNode, "VariableInitializerListNode") :
                expressionizeNormalNodeUnion(node.getInitializers(), factoryNode, "VariableInitializerListNode");
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeArrayInitializerNodeWithUnions"),
                        factory.makeExpressionListNode(
                                liftInitializers,
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeArrayInstantiatorCreationNode(ArrayInstantiatorCreationNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftDimExpressions = 
                node.getUnionForDimExpressions().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForDimExpressions().getSpliceNode(), factoryNode, "ExpressionListNode") :
                expressionizeNormalNodeUnion(node.getDimExpressions(), factoryNode, "ExpressionListNode");
        ExpressionNode liftBaseType = 
                node.getUnionForBaseType().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForBaseType().getSpliceNode(), factoryNode, "BaseTypeNode") :
                expressionizeNormalNodeUnion(node.getBaseType(), factoryNode, "BaseTypeNode");
        int liftArrayLevelsValue = 
                node.getArrayLevels();
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeArrayInstantiatorCreationNodeWithUnions"),
                        factory.makeExpressionListNode(
                                liftDimExpressions,
                                liftBaseType,
                                expressionizeInt(liftArrayLevelsValue),
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeArrayTypeNode(ArrayTypeNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftType = 
                node.getUnionForType().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForType().getSpliceNode(), factoryNode, "TypeNode") :
                expressionizeNormalNodeUnion(node.getType(), factoryNode, "TypeNode");
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeArrayTypeNodeWithUnions"),
                        factory.makeExpressionListNode(
                                liftType,
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeAssertStatementNode(AssertStatementNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftTestExpression = 
                node.getUnionForTestExpression().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForTestExpression().getSpliceNode(), factoryNode, "ExpressionNode") :
                expressionizeNormalNodeUnion(node.getTestExpression(), factoryNode, "ExpressionNode");
        ExpressionNode liftMessageExpression = 
                node.getUnionForMessageExpression().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForMessageExpression().getSpliceNode(), factoryNode, "ExpressionNode") :
                expressionizeNormalNodeUnion(node.getMessageExpression(), factoryNode, "ExpressionNode");
        ExpressionNode liftMetaAnnotations = 
                node.getUnionForMetaAnnotations().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForMetaAnnotations().getSpliceNode(), factoryNode, "MetaAnnotationListNode") :
                expressionizeNormalNodeUnion(node.getMetaAnnotations(), factoryNode, "MetaAnnotationListNode");
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeAssertStatementNodeWithUnions"),
                        factory.makeExpressionListNode(
                                liftTestExpression,
                                liftMessageExpression,
                                liftMetaAnnotations,
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeAssignmentNode(AssignmentNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftVariable = 
                node.getUnionForVariable().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForVariable().getSpliceNode(), factoryNode, "ExpressionNode") :
                expressionizeNormalNodeUnion(node.getVariable(), factoryNode, "ExpressionNode");
        AssignmentOperator liftOperatorValue = 
                node.getOperator();
        ExpressionNode liftExpression = 
                node.getUnionForExpression().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForExpression().getSpliceNode(), factoryNode, "ExpressionNode") :
                expressionizeNormalNodeUnion(node.getExpression(), factoryNode, "ExpressionNode");
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeAssignmentNodeWithUnions"),
                        factory.makeExpressionListNode(
                                liftVariable,
                                expressionizeAssignmentOperator(liftOperatorValue),
                                liftExpression,
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeBinaryExpressionNode(BinaryExpressionNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftLeftOperand = 
                node.getUnionForLeftOperand().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForLeftOperand().getSpliceNode(), factoryNode, "ExpressionNode") :
                expressionizeNormalNodeUnion(node.getLeftOperand(), factoryNode, "ExpressionNode");
        ExpressionNode liftRightOperand = 
                node.getUnionForRightOperand().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForRightOperand().getSpliceNode(), factoryNode, "ExpressionNode") :
                expressionizeNormalNodeUnion(node.getRightOperand(), factoryNode, "ExpressionNode");
        BinaryOperator liftOperatorValue = 
                node.getOperator();
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeBinaryExpressionNodeWithUnions"),
                        factory.makeExpressionListNode(
                                liftLeftOperand,
                                liftRightOperand,
                                expressionizeBinaryOperator(liftOperatorValue),
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeBlockNode(BlockNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftStatements = 
                node.getUnionForStatements().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForStatements().getSpliceNode(), factoryNode, "BlockStatementListNode") :
                expressionizeNormalNodeUnion(node.getStatements(), factoryNode, "BlockStatementListNode");
        ExpressionNode liftMetaAnnotations = 
                node.getUnionForMetaAnnotations().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForMetaAnnotations().getSpliceNode(), factoryNode, "MetaAnnotationListNode") :
                expressionizeNormalNodeUnion(node.getMetaAnnotations(), factoryNode, "MetaAnnotationListNode");
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeBlockNodeWithUnions"),
                        factory.makeExpressionListNode(
                                liftStatements,
                                liftMetaAnnotations,
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeBlockStatementListNode(BlockStatementListNode node, ExpressionNode factoryNode)
    {
        List<ExpressionNode> liftChildrenList = new ArrayList<ExpressionNode>();
        for (NodeUnion<? extends BlockStatementNode> listval : node.getUnionForChildren())
        {
            liftChildrenList.add(
                    listval != null ? 
                            (listval.getType() == NodeUnion.Type.SPLICE ? 
                                    expressionizeSpliceNodeUnion(listval.getSpliceNode(), factoryNode, "BlockStatementNode") :
                            expressionizeNormalNodeUnion(listval.getNormalNode(), factoryNode, "BlockStatementNode"))
                            : factory.makeNullLiteralNode());
        }
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeBlockStatementListNodeWithUnions"),
                        factory.makeExpressionListNode(
                                factory.makeMethodInvocationNode(
                                        factory.makeVariableAccessNode(
                                                factory.makeVariableAccessNode(
                                                        factory.makeVariableAccessNode(
                                                                factory.makeVariableAccessNode(
                                                                        factory.makeVariableAccessNode(
                                                                                factory.makeVariableAccessNode(
                                                                                        factory.makeVariableAccessNode(
                                                                                                factory.makeVariableAccessNode(
                                                                                                        factory.makeIdentifierNode("edu")),
                                                                                                factory.makeIdentifierNode("jhu")),
                                                                                        factory.makeIdentifierNode("cs")),
                                                                                factory.makeIdentifierNode("bsj")),
                                                                        factory.makeIdentifierNode("compiler")),
                                                                factory.makeIdentifierNode("impl")),
                                                        factory.makeIdentifierNode("utils")),
                                                factory.makeIdentifierNode("CollectionUtilities")),
                                        factory.makeIdentifierNode("listOf"),
                                        factory.makeExpressionListNode(liftChildrenList),
                                        factory.makeReferenceTypeListNode(
                                                factory.makeParameterizedTypeNode(
                                                        factory.makeUnparameterizedTypeNode(
                                                                factory.makeSimpleNameNode(
                                                                        factory.makeIdentifierNode("NodeUnion"))),
                                                        factory.makeTypeArgumentListNode(
                                                                factory.makeWildcardTypeNode(
                                                                        factory.makeUnparameterizedTypeNode(
                                                                                factory.makeSimpleNameNode(
                                                                                        factory.makeIdentifierNode("BlockStatementNode"))),
                                                                        true))))),
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeBlockStatementMetaprogramAnchorNode(BlockStatementMetaprogramAnchorNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftMetaprogram = 
                node.getUnionForMetaprogram().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForMetaprogram().getSpliceNode(), factoryNode, "MetaprogramNode") :
                expressionizeNormalNodeUnion(node.getMetaprogram(), factoryNode, "MetaprogramNode");
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeBlockStatementMetaprogramAnchorNodeWithUnions"),
                        factory.makeExpressionListNode(
                                liftMetaprogram,
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode());
        
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
                factory.makeMethodInvocationNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeBooleanLiteralNode"),
                        factory.makeExpressionListNode(
                                expressionizeBoolean(liftValueValue),
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeBreakNode(BreakNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftLabel = 
                node.getUnionForLabel().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForLabel().getSpliceNode(), factoryNode, "IdentifierNode") :
                expressionizeNormalNodeUnion(node.getLabel(), factoryNode, "IdentifierNode");
        ExpressionNode liftMetaAnnotations = 
                node.getUnionForMetaAnnotations().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForMetaAnnotations().getSpliceNode(), factoryNode, "MetaAnnotationListNode") :
                expressionizeNormalNodeUnion(node.getMetaAnnotations(), factoryNode, "MetaAnnotationListNode");
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeBreakNodeWithUnions"),
                        factory.makeExpressionListNode(
                                liftLabel,
                                liftMetaAnnotations,
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeCaseListNode(CaseListNode node, ExpressionNode factoryNode)
    {
        List<ExpressionNode> liftChildrenList = new ArrayList<ExpressionNode>();
        for (NodeUnion<? extends CaseNode> listval : node.getUnionForChildren())
        {
            liftChildrenList.add(
                    listval != null ? 
                            (listval.getType() == NodeUnion.Type.SPLICE ? 
                                    expressionizeSpliceNodeUnion(listval.getSpliceNode(), factoryNode, "CaseNode") :
                            expressionizeNormalNodeUnion(listval.getNormalNode(), factoryNode, "CaseNode"))
                            : factory.makeNullLiteralNode());
        }
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeCaseListNodeWithUnions"),
                        factory.makeExpressionListNode(
                                factory.makeMethodInvocationNode(
                                        factory.makeVariableAccessNode(
                                                factory.makeVariableAccessNode(
                                                        factory.makeVariableAccessNode(
                                                                factory.makeVariableAccessNode(
                                                                        factory.makeVariableAccessNode(
                                                                                factory.makeVariableAccessNode(
                                                                                        factory.makeVariableAccessNode(
                                                                                                factory.makeVariableAccessNode(
                                                                                                        factory.makeIdentifierNode("edu")),
                                                                                                factory.makeIdentifierNode("jhu")),
                                                                                        factory.makeIdentifierNode("cs")),
                                                                                factory.makeIdentifierNode("bsj")),
                                                                        factory.makeIdentifierNode("compiler")),
                                                                factory.makeIdentifierNode("impl")),
                                                        factory.makeIdentifierNode("utils")),
                                                factory.makeIdentifierNode("CollectionUtilities")),
                                        factory.makeIdentifierNode("listOf"),
                                        factory.makeExpressionListNode(liftChildrenList),
                                        factory.makeReferenceTypeListNode(
                                                factory.makeParameterizedTypeNode(
                                                        factory.makeUnparameterizedTypeNode(
                                                                factory.makeSimpleNameNode(
                                                                        factory.makeIdentifierNode("NodeUnion"))),
                                                        factory.makeTypeArgumentListNode(
                                                                factory.makeWildcardTypeNode(
                                                                        factory.makeUnparameterizedTypeNode(
                                                                                factory.makeSimpleNameNode(
                                                                                        factory.makeIdentifierNode("CaseNode"))),
                                                                        true))))),
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeCaseNode(CaseNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftExpression = 
                node.getUnionForExpression().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForExpression().getSpliceNode(), factoryNode, "ExpressionNode") :
                expressionizeNormalNodeUnion(node.getExpression(), factoryNode, "ExpressionNode");
        ExpressionNode liftStatements = 
                node.getUnionForStatements().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForStatements().getSpliceNode(), factoryNode, "BlockStatementListNode") :
                expressionizeNormalNodeUnion(node.getStatements(), factoryNode, "BlockStatementListNode");
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeCaseNodeWithUnions"),
                        factory.makeExpressionListNode(
                                liftExpression,
                                liftStatements,
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeCatchListNode(CatchListNode node, ExpressionNode factoryNode)
    {
        List<ExpressionNode> liftChildrenList = new ArrayList<ExpressionNode>();
        for (NodeUnion<? extends CatchNode> listval : node.getUnionForChildren())
        {
            liftChildrenList.add(
                    listval != null ? 
                            (listval.getType() == NodeUnion.Type.SPLICE ? 
                                    expressionizeSpliceNodeUnion(listval.getSpliceNode(), factoryNode, "CatchNode") :
                            expressionizeNormalNodeUnion(listval.getNormalNode(), factoryNode, "CatchNode"))
                            : factory.makeNullLiteralNode());
        }
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeCatchListNodeWithUnions"),
                        factory.makeExpressionListNode(
                                factory.makeMethodInvocationNode(
                                        factory.makeVariableAccessNode(
                                                factory.makeVariableAccessNode(
                                                        factory.makeVariableAccessNode(
                                                                factory.makeVariableAccessNode(
                                                                        factory.makeVariableAccessNode(
                                                                                factory.makeVariableAccessNode(
                                                                                        factory.makeVariableAccessNode(
                                                                                                factory.makeVariableAccessNode(
                                                                                                        factory.makeIdentifierNode("edu")),
                                                                                                factory.makeIdentifierNode("jhu")),
                                                                                        factory.makeIdentifierNode("cs")),
                                                                                factory.makeIdentifierNode("bsj")),
                                                                        factory.makeIdentifierNode("compiler")),
                                                                factory.makeIdentifierNode("impl")),
                                                        factory.makeIdentifierNode("utils")),
                                                factory.makeIdentifierNode("CollectionUtilities")),
                                        factory.makeIdentifierNode("listOf"),
                                        factory.makeExpressionListNode(liftChildrenList),
                                        factory.makeReferenceTypeListNode(
                                                factory.makeParameterizedTypeNode(
                                                        factory.makeUnparameterizedTypeNode(
                                                                factory.makeSimpleNameNode(
                                                                        factory.makeIdentifierNode("NodeUnion"))),
                                                        factory.makeTypeArgumentListNode(
                                                                factory.makeWildcardTypeNode(
                                                                        factory.makeUnparameterizedTypeNode(
                                                                                factory.makeSimpleNameNode(
                                                                                        factory.makeIdentifierNode("CatchNode"))),
                                                                        true))))),
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeCatchNode(CatchNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftBody = 
                node.getUnionForBody().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForBody().getSpliceNode(), factoryNode, "BlockStatementListNode") :
                expressionizeNormalNodeUnion(node.getBody(), factoryNode, "BlockStatementListNode");
        ExpressionNode liftParameter = 
                node.getUnionForParameter().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForParameter().getSpliceNode(), factoryNode, "VariableNode") :
                expressionizeNormalNodeUnion(node.getParameter(), factoryNode, "VariableNode");
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeCatchNodeWithUnions"),
                        factory.makeExpressionListNode(
                                liftBody,
                                liftParameter,
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode());
        
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
                factory.makeMethodInvocationNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeCharLiteralNode"),
                        factory.makeExpressionListNode(
                                expressionizeCharacter(liftValueValue),
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeClassBodyNode(ClassBodyNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftMembers = 
                node.getUnionForMembers().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForMembers().getSpliceNode(), factoryNode, "ClassMemberListNode") :
                expressionizeNormalNodeUnion(node.getMembers(), factoryNode, "ClassMemberListNode");
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeClassBodyNodeWithUnions"),
                        factory.makeExpressionListNode(
                                liftMembers,
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeClassDeclarationNode(ClassDeclarationNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftModifiers = 
                node.getUnionForModifiers().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForModifiers().getSpliceNode(), factoryNode, "ClassModifiersNode") :
                expressionizeNormalNodeUnion(node.getModifiers(), factoryNode, "ClassModifiersNode");
        ExpressionNode liftExtendsClause = 
                node.getUnionForExtendsClause().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForExtendsClause().getSpliceNode(), factoryNode, "DeclaredTypeNode") :
                expressionizeNormalNodeUnion(node.getExtendsClause(), factoryNode, "DeclaredTypeNode");
        ExpressionNode liftImplementsClause = 
                node.getUnionForImplementsClause().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForImplementsClause().getSpliceNode(), factoryNode, "DeclaredTypeListNode") :
                expressionizeNormalNodeUnion(node.getImplementsClause(), factoryNode, "DeclaredTypeListNode");
        ExpressionNode liftBody = 
                node.getUnionForBody().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForBody().getSpliceNode(), factoryNode, "ClassBodyNode") :
                expressionizeNormalNodeUnion(node.getBody(), factoryNode, "ClassBodyNode");
        ExpressionNode liftTypeParameters = 
                node.getUnionForTypeParameters().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForTypeParameters().getSpliceNode(), factoryNode, "TypeParameterListNode") :
                expressionizeNormalNodeUnion(node.getTypeParameters(), factoryNode, "TypeParameterListNode");
        ExpressionNode liftIdentifier = 
                node.getUnionForIdentifier().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForIdentifier().getSpliceNode(), factoryNode, "IdentifierNode") :
                expressionizeNormalNodeUnion(node.getIdentifier(), factoryNode, "IdentifierNode");
        ExpressionNode liftJavadoc = 
                node.getUnionForJavadoc().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForJavadoc().getSpliceNode(), factoryNode, "JavadocNode") :
                expressionizeNormalNodeUnion(node.getJavadoc(), factoryNode, "JavadocNode");
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeClassDeclarationNodeWithUnions"),
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
                        factory.makeReferenceTypeListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeClassLiteralNode(ClassLiteralNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftValue = 
                node.getUnionForValue().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForValue().getSpliceNode(), factoryNode, "LiteralizableTypeNode") :
                expressionizeNormalNodeUnion(node.getValue(), factoryNode, "LiteralizableTypeNode");
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeClassLiteralNodeWithUnions"),
                        factory.makeExpressionListNode(
                                liftValue,
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeClassMemberListNode(ClassMemberListNode node, ExpressionNode factoryNode)
    {
        List<ExpressionNode> liftChildrenList = new ArrayList<ExpressionNode>();
        for (NodeUnion<? extends ClassMemberNode> listval : node.getUnionForChildren())
        {
            liftChildrenList.add(
                    listval != null ? 
                            (listval.getType() == NodeUnion.Type.SPLICE ? 
                                    expressionizeSpliceNodeUnion(listval.getSpliceNode(), factoryNode, "ClassMemberNode") :
                            expressionizeNormalNodeUnion(listval.getNormalNode(), factoryNode, "ClassMemberNode"))
                            : factory.makeNullLiteralNode());
        }
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeClassMemberListNodeWithUnions"),
                        factory.makeExpressionListNode(
                                factory.makeMethodInvocationNode(
                                        factory.makeVariableAccessNode(
                                                factory.makeVariableAccessNode(
                                                        factory.makeVariableAccessNode(
                                                                factory.makeVariableAccessNode(
                                                                        factory.makeVariableAccessNode(
                                                                                factory.makeVariableAccessNode(
                                                                                        factory.makeVariableAccessNode(
                                                                                                factory.makeVariableAccessNode(
                                                                                                        factory.makeIdentifierNode("edu")),
                                                                                                factory.makeIdentifierNode("jhu")),
                                                                                        factory.makeIdentifierNode("cs")),
                                                                                factory.makeIdentifierNode("bsj")),
                                                                        factory.makeIdentifierNode("compiler")),
                                                                factory.makeIdentifierNode("impl")),
                                                        factory.makeIdentifierNode("utils")),
                                                factory.makeIdentifierNode("CollectionUtilities")),
                                        factory.makeIdentifierNode("listOf"),
                                        factory.makeExpressionListNode(liftChildrenList),
                                        factory.makeReferenceTypeListNode(
                                                factory.makeParameterizedTypeNode(
                                                        factory.makeUnparameterizedTypeNode(
                                                                factory.makeSimpleNameNode(
                                                                        factory.makeIdentifierNode("NodeUnion"))),
                                                        factory.makeTypeArgumentListNode(
                                                                factory.makeWildcardTypeNode(
                                                                        factory.makeUnparameterizedTypeNode(
                                                                                factory.makeSimpleNameNode(
                                                                                        factory.makeIdentifierNode("ClassMemberNode"))),
                                                                        true))))),
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeClassMemberMetaprogramAnchorNode(ClassMemberMetaprogramAnchorNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftMetaprogram = 
                node.getUnionForMetaprogram().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForMetaprogram().getSpliceNode(), factoryNode, "MetaprogramNode") :
                expressionizeNormalNodeUnion(node.getMetaprogram(), factoryNode, "MetaprogramNode");
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeClassMemberMetaprogramAnchorNodeWithUnions"),
                        factory.makeExpressionListNode(
                                liftMetaprogram,
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode());
        
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
                node.getUnionForMetaAnnotations().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForMetaAnnotations().getSpliceNode(), factoryNode, "MetaAnnotationListNode") :
                expressionizeNormalNodeUnion(node.getMetaAnnotations(), factoryNode, "MetaAnnotationListNode");
        ExpressionNode liftAnnotations = 
                node.getUnionForAnnotations().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForAnnotations().getSpliceNode(), factoryNode, "AnnotationListNode") :
                expressionizeNormalNodeUnion(node.getAnnotations(), factoryNode, "AnnotationListNode");
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeClassModifiersNodeWithUnions"),
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
                        factory.makeReferenceTypeListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeCodeLiteralNode(CodeLiteralNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftValue = 
                node.getUnionForValue().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForValue().getSpliceNode(), factoryNode, "Node") :
                expressionizeNormalNodeUnion(node.getValue(), factoryNode, "Node");
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeCodeLiteralNodeWithUnions"),
                        factory.makeExpressionListNode(
                                liftValue,
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeCompilationUnitNode(CompilationUnitNode node, ExpressionNode factoryNode)
    {
        String liftNameValue = 
                node.getName();
        ExpressionNode liftPackageDeclaration = 
                node.getUnionForPackageDeclaration().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForPackageDeclaration().getSpliceNode(), factoryNode, "PackageDeclarationNode") :
                expressionizeNormalNodeUnion(node.getPackageDeclaration(), factoryNode, "PackageDeclarationNode");
        ExpressionNode liftMetaimports = 
                node.getUnionForMetaimports().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForMetaimports().getSpliceNode(), factoryNode, "MetaprogramImportListNode") :
                expressionizeNormalNodeUnion(node.getMetaimports(), factoryNode, "MetaprogramImportListNode");
        ExpressionNode liftImports = 
                node.getUnionForImports().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForImports().getSpliceNode(), factoryNode, "ImportListNode") :
                expressionizeNormalNodeUnion(node.getImports(), factoryNode, "ImportListNode");
        ExpressionNode liftTypeDecls = 
                node.getUnionForTypeDecls().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForTypeDecls().getSpliceNode(), factoryNode, "TypeDeclarationListNode") :
                expressionizeNormalNodeUnion(node.getTypeDecls(), factoryNode, "TypeDeclarationListNode");
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeCompilationUnitNodeWithUnions"),
                        factory.makeExpressionListNode(
                                expressionizeString(liftNameValue),
                                liftPackageDeclaration,
                                liftMetaimports,
                                liftImports,
                                liftTypeDecls,
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeConditionalExpressionNode(ConditionalExpressionNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftCondition = 
                node.getUnionForCondition().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForCondition().getSpliceNode(), factoryNode, "ExpressionNode") :
                expressionizeNormalNodeUnion(node.getCondition(), factoryNode, "ExpressionNode");
        ExpressionNode liftTrueExpression = 
                node.getUnionForTrueExpression().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForTrueExpression().getSpliceNode(), factoryNode, "ExpressionNode") :
                expressionizeNormalNodeUnion(node.getTrueExpression(), factoryNode, "ExpressionNode");
        ExpressionNode liftFalseExpression = 
                node.getUnionForFalseExpression().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForFalseExpression().getSpliceNode(), factoryNode, "ExpressionNode") :
                expressionizeNormalNodeUnion(node.getFalseExpression(), factoryNode, "ExpressionNode");
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeConditionalExpressionNodeWithUnions"),
                        factory.makeExpressionListNode(
                                liftCondition,
                                liftTrueExpression,
                                liftFalseExpression,
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeConstantDeclarationNode(ConstantDeclarationNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftModifiers = 
                node.getUnionForModifiers().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForModifiers().getSpliceNode(), factoryNode, "ConstantModifiersNode") :
                expressionizeNormalNodeUnion(node.getModifiers(), factoryNode, "ConstantModifiersNode");
        ExpressionNode liftType = 
                node.getUnionForType().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForType().getSpliceNode(), factoryNode, "TypeNode") :
                expressionizeNormalNodeUnion(node.getType(), factoryNode, "TypeNode");
        ExpressionNode liftDeclarators = 
                node.getUnionForDeclarators().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForDeclarators().getSpliceNode(), factoryNode, "VariableDeclaratorListNode") :
                expressionizeNormalNodeUnion(node.getDeclarators(), factoryNode, "VariableDeclaratorListNode");
        ExpressionNode liftJavadoc = 
                node.getUnionForJavadoc().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForJavadoc().getSpliceNode(), factoryNode, "JavadocNode") :
                expressionizeNormalNodeUnion(node.getJavadoc(), factoryNode, "JavadocNode");
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeConstantDeclarationNodeWithUnions"),
                        factory.makeExpressionListNode(
                                liftModifiers,
                                liftType,
                                liftDeclarators,
                                liftJavadoc,
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeConstantModifiersNode(ConstantModifiersNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftMetaAnnotations = 
                node.getUnionForMetaAnnotations().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForMetaAnnotations().getSpliceNode(), factoryNode, "MetaAnnotationListNode") :
                expressionizeNormalNodeUnion(node.getMetaAnnotations(), factoryNode, "MetaAnnotationListNode");
        ExpressionNode liftAnnotations = 
                node.getUnionForAnnotations().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForAnnotations().getSpliceNode(), factoryNode, "AnnotationListNode") :
                expressionizeNormalNodeUnion(node.getAnnotations(), factoryNode, "AnnotationListNode");
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeConstantModifiersNodeWithUnions"),
                        factory.makeExpressionListNode(
                                liftMetaAnnotations,
                                liftAnnotations,
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeConstructorBodyNode(ConstructorBodyNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftConstructorInvocation = 
                node.getUnionForConstructorInvocation().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForConstructorInvocation().getSpliceNode(), factoryNode, "ConstructorInvocationNode") :
                expressionizeNormalNodeUnion(node.getConstructorInvocation(), factoryNode, "ConstructorInvocationNode");
        ExpressionNode liftStatements = 
                node.getUnionForStatements().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForStatements().getSpliceNode(), factoryNode, "BlockStatementListNode") :
                expressionizeNormalNodeUnion(node.getStatements(), factoryNode, "BlockStatementListNode");
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeConstructorBodyNodeWithUnions"),
                        factory.makeExpressionListNode(
                                liftConstructorInvocation,
                                liftStatements,
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeConstructorDeclarationNode(ConstructorDeclarationNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftIdentifier = 
                node.getUnionForIdentifier().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForIdentifier().getSpliceNode(), factoryNode, "IdentifierNode") :
                expressionizeNormalNodeUnion(node.getIdentifier(), factoryNode, "IdentifierNode");
        ExpressionNode liftBody = 
                node.getUnionForBody().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForBody().getSpliceNode(), factoryNode, "ConstructorBodyNode") :
                expressionizeNormalNodeUnion(node.getBody(), factoryNode, "ConstructorBodyNode");
        ExpressionNode liftModifiers = 
                node.getUnionForModifiers().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForModifiers().getSpliceNode(), factoryNode, "ConstructorModifiersNode") :
                expressionizeNormalNodeUnion(node.getModifiers(), factoryNode, "ConstructorModifiersNode");
        ExpressionNode liftParameters = 
                node.getUnionForParameters().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForParameters().getSpliceNode(), factoryNode, "VariableListNode") :
                expressionizeNormalNodeUnion(node.getParameters(), factoryNode, "VariableListNode");
        ExpressionNode liftVarargParameter = 
                node.getUnionForVarargParameter().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForVarargParameter().getSpliceNode(), factoryNode, "VariableNode") :
                expressionizeNormalNodeUnion(node.getVarargParameter(), factoryNode, "VariableNode");
        ExpressionNode liftThrowTypes = 
                node.getUnionForThrowTypes().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForThrowTypes().getSpliceNode(), factoryNode, "UnparameterizedTypeListNode") :
                expressionizeNormalNodeUnion(node.getThrowTypes(), factoryNode, "UnparameterizedTypeListNode");
        ExpressionNode liftTypeParameters = 
                node.getUnionForTypeParameters().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForTypeParameters().getSpliceNode(), factoryNode, "TypeParameterListNode") :
                expressionizeNormalNodeUnion(node.getTypeParameters(), factoryNode, "TypeParameterListNode");
        ExpressionNode liftJavadoc = 
                node.getUnionForJavadoc().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForJavadoc().getSpliceNode(), factoryNode, "JavadocNode") :
                expressionizeNormalNodeUnion(node.getJavadoc(), factoryNode, "JavadocNode");
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeConstructorDeclarationNodeWithUnions"),
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
                        factory.makeReferenceTypeListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeConstructorModifiersNode(ConstructorModifiersNode node, ExpressionNode factoryNode)
    {
        AccessModifier liftAccessValue = 
                node.getAccess();
        ExpressionNode liftMetaAnnotations = 
                node.getUnionForMetaAnnotations().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForMetaAnnotations().getSpliceNode(), factoryNode, "MetaAnnotationListNode") :
                expressionizeNormalNodeUnion(node.getMetaAnnotations(), factoryNode, "MetaAnnotationListNode");
        ExpressionNode liftAnnotations = 
                node.getUnionForAnnotations().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForAnnotations().getSpliceNode(), factoryNode, "AnnotationListNode") :
                expressionizeNormalNodeUnion(node.getAnnotations(), factoryNode, "AnnotationListNode");
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeConstructorModifiersNodeWithUnions"),
                        factory.makeExpressionListNode(
                                expressionizeAccessModifier(liftAccessValue),
                                liftMetaAnnotations,
                                liftAnnotations,
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeContinueNode(ContinueNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftLabel = 
                node.getUnionForLabel().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForLabel().getSpliceNode(), factoryNode, "IdentifierNode") :
                expressionizeNormalNodeUnion(node.getLabel(), factoryNode, "IdentifierNode");
        ExpressionNode liftMetaAnnotations = 
                node.getUnionForMetaAnnotations().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForMetaAnnotations().getSpliceNode(), factoryNode, "MetaAnnotationListNode") :
                expressionizeNormalNodeUnion(node.getMetaAnnotations(), factoryNode, "MetaAnnotationListNode");
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeContinueNodeWithUnions"),
                        factory.makeExpressionListNode(
                                liftLabel,
                                liftMetaAnnotations,
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeDeclaredTypeListNode(DeclaredTypeListNode node, ExpressionNode factoryNode)
    {
        List<ExpressionNode> liftChildrenList = new ArrayList<ExpressionNode>();
        for (NodeUnion<? extends DeclaredTypeNode> listval : node.getUnionForChildren())
        {
            liftChildrenList.add(
                    listval != null ? 
                            (listval.getType() == NodeUnion.Type.SPLICE ? 
                                    expressionizeSpliceNodeUnion(listval.getSpliceNode(), factoryNode, "DeclaredTypeNode") :
                            expressionizeNormalNodeUnion(listval.getNormalNode(), factoryNode, "DeclaredTypeNode"))
                            : factory.makeNullLiteralNode());
        }
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeDeclaredTypeListNodeWithUnions"),
                        factory.makeExpressionListNode(
                                factory.makeMethodInvocationNode(
                                        factory.makeVariableAccessNode(
                                                factory.makeVariableAccessNode(
                                                        factory.makeVariableAccessNode(
                                                                factory.makeVariableAccessNode(
                                                                        factory.makeVariableAccessNode(
                                                                                factory.makeVariableAccessNode(
                                                                                        factory.makeVariableAccessNode(
                                                                                                factory.makeVariableAccessNode(
                                                                                                        factory.makeIdentifierNode("edu")),
                                                                                                factory.makeIdentifierNode("jhu")),
                                                                                        factory.makeIdentifierNode("cs")),
                                                                                factory.makeIdentifierNode("bsj")),
                                                                        factory.makeIdentifierNode("compiler")),
                                                                factory.makeIdentifierNode("impl")),
                                                        factory.makeIdentifierNode("utils")),
                                                factory.makeIdentifierNode("CollectionUtilities")),
                                        factory.makeIdentifierNode("listOf"),
                                        factory.makeExpressionListNode(liftChildrenList),
                                        factory.makeReferenceTypeListNode(
                                                factory.makeParameterizedTypeNode(
                                                        factory.makeUnparameterizedTypeNode(
                                                                factory.makeSimpleNameNode(
                                                                        factory.makeIdentifierNode("NodeUnion"))),
                                                        factory.makeTypeArgumentListNode(
                                                                factory.makeWildcardTypeNode(
                                                                        factory.makeUnparameterizedTypeNode(
                                                                                factory.makeSimpleNameNode(
                                                                                        factory.makeIdentifierNode("DeclaredTypeNode"))),
                                                                        true))))),
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeDoWhileLoopNode(DoWhileLoopNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftCondition = 
                node.getUnionForCondition().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForCondition().getSpliceNode(), factoryNode, "ExpressionNode") :
                expressionizeNormalNodeUnion(node.getCondition(), factoryNode, "ExpressionNode");
        ExpressionNode liftStatement = 
                node.getUnionForStatement().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForStatement().getSpliceNode(), factoryNode, "StatementNode") :
                expressionizeNormalNodeUnion(node.getStatement(), factoryNode, "StatementNode");
        ExpressionNode liftMetaAnnotations = 
                node.getUnionForMetaAnnotations().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForMetaAnnotations().getSpliceNode(), factoryNode, "MetaAnnotationListNode") :
                expressionizeNormalNodeUnion(node.getMetaAnnotations(), factoryNode, "MetaAnnotationListNode");
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeDoWhileLoopNodeWithUnions"),
                        factory.makeExpressionListNode(
                                liftCondition,
                                liftStatement,
                                liftMetaAnnotations,
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode());
        
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
                factory.makeMethodInvocationNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeDoubleLiteralNode"),
                        factory.makeExpressionListNode(
                                expressionizeDouble(liftValueValue),
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeEnhancedForLoopNode(EnhancedForLoopNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftVariable = 
                node.getUnionForVariable().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForVariable().getSpliceNode(), factoryNode, "VariableNode") :
                expressionizeNormalNodeUnion(node.getVariable(), factoryNode, "VariableNode");
        ExpressionNode liftExpression = 
                node.getUnionForExpression().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForExpression().getSpliceNode(), factoryNode, "ExpressionNode") :
                expressionizeNormalNodeUnion(node.getExpression(), factoryNode, "ExpressionNode");
        ExpressionNode liftStatement = 
                node.getUnionForStatement().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForStatement().getSpliceNode(), factoryNode, "StatementNode") :
                expressionizeNormalNodeUnion(node.getStatement(), factoryNode, "StatementNode");
        ExpressionNode liftMetaAnnotations = 
                node.getUnionForMetaAnnotations().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForMetaAnnotations().getSpliceNode(), factoryNode, "MetaAnnotationListNode") :
                expressionizeNormalNodeUnion(node.getMetaAnnotations(), factoryNode, "MetaAnnotationListNode");
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeEnhancedForLoopNodeWithUnions"),
                        factory.makeExpressionListNode(
                                liftVariable,
                                liftExpression,
                                liftStatement,
                                liftMetaAnnotations,
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeEnumBodyNode(EnumBodyNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftConstants = 
                node.getUnionForConstants().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForConstants().getSpliceNode(), factoryNode, "EnumConstantDeclarationListNode") :
                expressionizeNormalNodeUnion(node.getConstants(), factoryNode, "EnumConstantDeclarationListNode");
        ExpressionNode liftMembers = 
                node.getUnionForMembers().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForMembers().getSpliceNode(), factoryNode, "ClassMemberListNode") :
                expressionizeNormalNodeUnion(node.getMembers(), factoryNode, "ClassMemberListNode");
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeEnumBodyNodeWithUnions"),
                        factory.makeExpressionListNode(
                                liftConstants,
                                liftMembers,
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeEnumConstantDeclarationListNode(EnumConstantDeclarationListNode node, ExpressionNode factoryNode)
    {
        List<ExpressionNode> liftChildrenList = new ArrayList<ExpressionNode>();
        for (NodeUnion<? extends EnumConstantDeclarationNode> listval : node.getUnionForChildren())
        {
            liftChildrenList.add(
                    listval != null ? 
                            (listval.getType() == NodeUnion.Type.SPLICE ? 
                                    expressionizeSpliceNodeUnion(listval.getSpliceNode(), factoryNode, "EnumConstantDeclarationNode") :
                            expressionizeNormalNodeUnion(listval.getNormalNode(), factoryNode, "EnumConstantDeclarationNode"))
                            : factory.makeNullLiteralNode());
        }
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeEnumConstantDeclarationListNodeWithUnions"),
                        factory.makeExpressionListNode(
                                factory.makeMethodInvocationNode(
                                        factory.makeVariableAccessNode(
                                                factory.makeVariableAccessNode(
                                                        factory.makeVariableAccessNode(
                                                                factory.makeVariableAccessNode(
                                                                        factory.makeVariableAccessNode(
                                                                                factory.makeVariableAccessNode(
                                                                                        factory.makeVariableAccessNode(
                                                                                                factory.makeVariableAccessNode(
                                                                                                        factory.makeIdentifierNode("edu")),
                                                                                                factory.makeIdentifierNode("jhu")),
                                                                                        factory.makeIdentifierNode("cs")),
                                                                                factory.makeIdentifierNode("bsj")),
                                                                        factory.makeIdentifierNode("compiler")),
                                                                factory.makeIdentifierNode("impl")),
                                                        factory.makeIdentifierNode("utils")),
                                                factory.makeIdentifierNode("CollectionUtilities")),
                                        factory.makeIdentifierNode("listOf"),
                                        factory.makeExpressionListNode(liftChildrenList),
                                        factory.makeReferenceTypeListNode(
                                                factory.makeParameterizedTypeNode(
                                                        factory.makeUnparameterizedTypeNode(
                                                                factory.makeSimpleNameNode(
                                                                        factory.makeIdentifierNode("NodeUnion"))),
                                                        factory.makeTypeArgumentListNode(
                                                                factory.makeWildcardTypeNode(
                                                                        factory.makeUnparameterizedTypeNode(
                                                                                factory.makeSimpleNameNode(
                                                                                        factory.makeIdentifierNode("EnumConstantDeclarationNode"))),
                                                                        true))))),
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeEnumConstantDeclarationNode(EnumConstantDeclarationNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftModifiers = 
                node.getUnionForModifiers().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForModifiers().getSpliceNode(), factoryNode, "EnumConstantModifiersNode") :
                expressionizeNormalNodeUnion(node.getModifiers(), factoryNode, "EnumConstantModifiersNode");
        ExpressionNode liftIdentifier = 
                node.getUnionForIdentifier().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForIdentifier().getSpliceNode(), factoryNode, "IdentifierNode") :
                expressionizeNormalNodeUnion(node.getIdentifier(), factoryNode, "IdentifierNode");
        ExpressionNode liftArguments = 
                node.getUnionForArguments().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForArguments().getSpliceNode(), factoryNode, "ExpressionListNode") :
                expressionizeNormalNodeUnion(node.getArguments(), factoryNode, "ExpressionListNode");
        ExpressionNode liftBody = 
                node.getUnionForBody().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForBody().getSpliceNode(), factoryNode, "AnonymousClassBodyNode") :
                expressionizeNormalNodeUnion(node.getBody(), factoryNode, "AnonymousClassBodyNode");
        ExpressionNode liftJavadoc = 
                node.getUnionForJavadoc().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForJavadoc().getSpliceNode(), factoryNode, "JavadocNode") :
                expressionizeNormalNodeUnion(node.getJavadoc(), factoryNode, "JavadocNode");
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeEnumConstantDeclarationNodeWithUnions"),
                        factory.makeExpressionListNode(
                                liftModifiers,
                                liftIdentifier,
                                liftArguments,
                                liftBody,
                                liftJavadoc,
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeEnumConstantModifiersNode(EnumConstantModifiersNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftMetaAnnotations = 
                node.getUnionForMetaAnnotations().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForMetaAnnotations().getSpliceNode(), factoryNode, "MetaAnnotationListNode") :
                expressionizeNormalNodeUnion(node.getMetaAnnotations(), factoryNode, "MetaAnnotationListNode");
        ExpressionNode liftAnnotations = 
                node.getUnionForAnnotations().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForAnnotations().getSpliceNode(), factoryNode, "AnnotationListNode") :
                expressionizeNormalNodeUnion(node.getAnnotations(), factoryNode, "AnnotationListNode");
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeEnumConstantModifiersNodeWithUnions"),
                        factory.makeExpressionListNode(
                                liftMetaAnnotations,
                                liftAnnotations,
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeEnumDeclarationNode(EnumDeclarationNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftModifiers = 
                node.getUnionForModifiers().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForModifiers().getSpliceNode(), factoryNode, "EnumModifiersNode") :
                expressionizeNormalNodeUnion(node.getModifiers(), factoryNode, "EnumModifiersNode");
        ExpressionNode liftImplementsClause = 
                node.getUnionForImplementsClause().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForImplementsClause().getSpliceNode(), factoryNode, "DeclaredTypeListNode") :
                expressionizeNormalNodeUnion(node.getImplementsClause(), factoryNode, "DeclaredTypeListNode");
        ExpressionNode liftBody = 
                node.getUnionForBody().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForBody().getSpliceNode(), factoryNode, "EnumBodyNode") :
                expressionizeNormalNodeUnion(node.getBody(), factoryNode, "EnumBodyNode");
        ExpressionNode liftIdentifier = 
                node.getUnionForIdentifier().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForIdentifier().getSpliceNode(), factoryNode, "IdentifierNode") :
                expressionizeNormalNodeUnion(node.getIdentifier(), factoryNode, "IdentifierNode");
        ExpressionNode liftJavadoc = 
                node.getUnionForJavadoc().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForJavadoc().getSpliceNode(), factoryNode, "JavadocNode") :
                expressionizeNormalNodeUnion(node.getJavadoc(), factoryNode, "JavadocNode");
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeEnumDeclarationNodeWithUnions"),
                        factory.makeExpressionListNode(
                                liftModifiers,
                                liftImplementsClause,
                                liftBody,
                                liftIdentifier,
                                liftJavadoc,
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode());
        
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
                node.getUnionForMetaAnnotations().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForMetaAnnotations().getSpliceNode(), factoryNode, "MetaAnnotationListNode") :
                expressionizeNormalNodeUnion(node.getMetaAnnotations(), factoryNode, "MetaAnnotationListNode");
        ExpressionNode liftAnnotations = 
                node.getUnionForAnnotations().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForAnnotations().getSpliceNode(), factoryNode, "AnnotationListNode") :
                expressionizeNormalNodeUnion(node.getAnnotations(), factoryNode, "AnnotationListNode");
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeEnumModifiersNodeWithUnions"),
                        factory.makeExpressionListNode(
                                expressionizeAccessModifier(liftAccessValue),
                                expressionizeBoolean(liftStrictfpFlagValue),
                                liftMetaAnnotations,
                                liftAnnotations,
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeExpressionListNode(ExpressionListNode node, ExpressionNode factoryNode)
    {
        List<ExpressionNode> liftChildrenList = new ArrayList<ExpressionNode>();
        for (NodeUnion<? extends ExpressionNode> listval : node.getUnionForChildren())
        {
            liftChildrenList.add(
                    listval != null ? 
                            (listval.getType() == NodeUnion.Type.SPLICE ? 
                                    expressionizeSpliceNodeUnion(listval.getSpliceNode(), factoryNode, "ExpressionNode") :
                            expressionizeNormalNodeUnion(listval.getNormalNode(), factoryNode, "ExpressionNode"))
                            : factory.makeNullLiteralNode());
        }
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeExpressionListNodeWithUnions"),
                        factory.makeExpressionListNode(
                                factory.makeMethodInvocationNode(
                                        factory.makeVariableAccessNode(
                                                factory.makeVariableAccessNode(
                                                        factory.makeVariableAccessNode(
                                                                factory.makeVariableAccessNode(
                                                                        factory.makeVariableAccessNode(
                                                                                factory.makeVariableAccessNode(
                                                                                        factory.makeVariableAccessNode(
                                                                                                factory.makeVariableAccessNode(
                                                                                                        factory.makeIdentifierNode("edu")),
                                                                                                factory.makeIdentifierNode("jhu")),
                                                                                        factory.makeIdentifierNode("cs")),
                                                                                factory.makeIdentifierNode("bsj")),
                                                                        factory.makeIdentifierNode("compiler")),
                                                                factory.makeIdentifierNode("impl")),
                                                        factory.makeIdentifierNode("utils")),
                                                factory.makeIdentifierNode("CollectionUtilities")),
                                        factory.makeIdentifierNode("listOf"),
                                        factory.makeExpressionListNode(liftChildrenList),
                                        factory.makeReferenceTypeListNode(
                                                factory.makeParameterizedTypeNode(
                                                        factory.makeUnparameterizedTypeNode(
                                                                factory.makeSimpleNameNode(
                                                                        factory.makeIdentifierNode("NodeUnion"))),
                                                        factory.makeTypeArgumentListNode(
                                                                factory.makeWildcardTypeNode(
                                                                        factory.makeUnparameterizedTypeNode(
                                                                                factory.makeSimpleNameNode(
                                                                                        factory.makeIdentifierNode("ExpressionNode"))),
                                                                        true))))),
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeExpressionStatementNode(ExpressionStatementNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftExpression = 
                node.getUnionForExpression().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForExpression().getSpliceNode(), factoryNode, "StatementExpressionNode") :
                expressionizeNormalNodeUnion(node.getExpression(), factoryNode, "StatementExpressionNode");
        ExpressionNode liftMetaAnnotations = 
                node.getUnionForMetaAnnotations().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForMetaAnnotations().getSpliceNode(), factoryNode, "MetaAnnotationListNode") :
                expressionizeNormalNodeUnion(node.getMetaAnnotations(), factoryNode, "MetaAnnotationListNode");
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeExpressionStatementNodeWithUnions"),
                        factory.makeExpressionListNode(
                                liftExpression,
                                liftMetaAnnotations,
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeFieldDeclarationNode(FieldDeclarationNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftModifiers = 
                node.getUnionForModifiers().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForModifiers().getSpliceNode(), factoryNode, "FieldModifiersNode") :
                expressionizeNormalNodeUnion(node.getModifiers(), factoryNode, "FieldModifiersNode");
        ExpressionNode liftType = 
                node.getUnionForType().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForType().getSpliceNode(), factoryNode, "TypeNode") :
                expressionizeNormalNodeUnion(node.getType(), factoryNode, "TypeNode");
        ExpressionNode liftDeclarators = 
                node.getUnionForDeclarators().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForDeclarators().getSpliceNode(), factoryNode, "VariableDeclaratorListNode") :
                expressionizeNormalNodeUnion(node.getDeclarators(), factoryNode, "VariableDeclaratorListNode");
        ExpressionNode liftJavadoc = 
                node.getUnionForJavadoc().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForJavadoc().getSpliceNode(), factoryNode, "JavadocNode") :
                expressionizeNormalNodeUnion(node.getJavadoc(), factoryNode, "JavadocNode");
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeFieldDeclarationNodeWithUnions"),
                        factory.makeExpressionListNode(
                                liftModifiers,
                                liftType,
                                liftDeclarators,
                                liftJavadoc,
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode());
        
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
                node.getUnionForMetaAnnotations().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForMetaAnnotations().getSpliceNode(), factoryNode, "MetaAnnotationListNode") :
                expressionizeNormalNodeUnion(node.getMetaAnnotations(), factoryNode, "MetaAnnotationListNode");
        ExpressionNode liftAnnotations = 
                node.getUnionForAnnotations().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForAnnotations().getSpliceNode(), factoryNode, "AnnotationListNode") :
                expressionizeNormalNodeUnion(node.getAnnotations(), factoryNode, "AnnotationListNode");
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeFieldModifiersNodeWithUnions"),
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
                        factory.makeReferenceTypeListNode());
        
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
                factory.makeMethodInvocationNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeFloatLiteralNode"),
                        factory.makeExpressionListNode(
                                expressionizeFloat(liftValueValue),
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeForInitializerDeclarationNode(ForInitializerDeclarationNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftDeclaration = 
                node.getUnionForDeclaration().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForDeclaration().getSpliceNode(), factoryNode, "LocalVariableDeclarationNode") :
                expressionizeNormalNodeUnion(node.getDeclaration(), factoryNode, "LocalVariableDeclarationNode");
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeForInitializerDeclarationNodeWithUnions"),
                        factory.makeExpressionListNode(
                                liftDeclaration,
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeForInitializerExpressionNode(ForInitializerExpressionNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftExpressions = 
                node.getUnionForExpressions().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForExpressions().getSpliceNode(), factoryNode, "StatementExpressionListNode") :
                expressionizeNormalNodeUnion(node.getExpressions(), factoryNode, "StatementExpressionListNode");
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeForInitializerExpressionNodeWithUnions"),
                        factory.makeExpressionListNode(
                                liftExpressions,
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeForLoopNode(ForLoopNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftInitializer = 
                node.getUnionForInitializer().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForInitializer().getSpliceNode(), factoryNode, "ForInitializerNode") :
                expressionizeNormalNodeUnion(node.getInitializer(), factoryNode, "ForInitializerNode");
        ExpressionNode liftCondition = 
                node.getUnionForCondition().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForCondition().getSpliceNode(), factoryNode, "ExpressionNode") :
                expressionizeNormalNodeUnion(node.getCondition(), factoryNode, "ExpressionNode");
        ExpressionNode liftUpdate = 
                node.getUnionForUpdate().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForUpdate().getSpliceNode(), factoryNode, "StatementExpressionListNode") :
                expressionizeNormalNodeUnion(node.getUpdate(), factoryNode, "StatementExpressionListNode");
        ExpressionNode liftStatement = 
                node.getUnionForStatement().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForStatement().getSpliceNode(), factoryNode, "StatementNode") :
                expressionizeNormalNodeUnion(node.getStatement(), factoryNode, "StatementNode");
        ExpressionNode liftMetaAnnotations = 
                node.getUnionForMetaAnnotations().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForMetaAnnotations().getSpliceNode(), factoryNode, "MetaAnnotationListNode") :
                expressionizeNormalNodeUnion(node.getMetaAnnotations(), factoryNode, "MetaAnnotationListNode");
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeForLoopNodeWithUnions"),
                        factory.makeExpressionListNode(
                                liftInitializer,
                                liftCondition,
                                liftUpdate,
                                liftStatement,
                                liftMetaAnnotations,
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeIdentifierListNode(IdentifierListNode node, ExpressionNode factoryNode)
    {
        List<ExpressionNode> liftChildrenList = new ArrayList<ExpressionNode>();
        for (NodeUnion<? extends IdentifierNode> listval : node.getUnionForChildren())
        {
            liftChildrenList.add(
                    listval != null ? 
                            (listval.getType() == NodeUnion.Type.SPLICE ? 
                                    expressionizeSpliceNodeUnion(listval.getSpliceNode(), factoryNode, "IdentifierNode") :
                            expressionizeNormalNodeUnion(listval.getNormalNode(), factoryNode, "IdentifierNode"))
                            : factory.makeNullLiteralNode());
        }
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeIdentifierListNodeWithUnions"),
                        factory.makeExpressionListNode(
                                factory.makeMethodInvocationNode(
                                        factory.makeVariableAccessNode(
                                                factory.makeVariableAccessNode(
                                                        factory.makeVariableAccessNode(
                                                                factory.makeVariableAccessNode(
                                                                        factory.makeVariableAccessNode(
                                                                                factory.makeVariableAccessNode(
                                                                                        factory.makeVariableAccessNode(
                                                                                                factory.makeVariableAccessNode(
                                                                                                        factory.makeIdentifierNode("edu")),
                                                                                                factory.makeIdentifierNode("jhu")),
                                                                                        factory.makeIdentifierNode("cs")),
                                                                                factory.makeIdentifierNode("bsj")),
                                                                        factory.makeIdentifierNode("compiler")),
                                                                factory.makeIdentifierNode("impl")),
                                                        factory.makeIdentifierNode("utils")),
                                                factory.makeIdentifierNode("CollectionUtilities")),
                                        factory.makeIdentifierNode("listOf"),
                                        factory.makeExpressionListNode(liftChildrenList),
                                        factory.makeReferenceTypeListNode(
                                                factory.makeParameterizedTypeNode(
                                                        factory.makeUnparameterizedTypeNode(
                                                                factory.makeSimpleNameNode(
                                                                        factory.makeIdentifierNode("NodeUnion"))),
                                                        factory.makeTypeArgumentListNode(
                                                                factory.makeWildcardTypeNode(
                                                                        factory.makeUnparameterizedTypeNode(
                                                                                factory.makeSimpleNameNode(
                                                                                        factory.makeIdentifierNode("IdentifierNode"))),
                                                                        true))))),
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode());
        
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
                factory.makeMethodInvocationNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeIdentifierNode"),
                        factory.makeExpressionListNode(
                                expressionizeString(liftIdentifierValue),
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeIfNode(IfNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftCondition = 
                node.getUnionForCondition().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForCondition().getSpliceNode(), factoryNode, "ExpressionNode") :
                expressionizeNormalNodeUnion(node.getCondition(), factoryNode, "ExpressionNode");
        ExpressionNode liftThenStatement = 
                node.getUnionForThenStatement().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForThenStatement().getSpliceNode(), factoryNode, "StatementNode") :
                expressionizeNormalNodeUnion(node.getThenStatement(), factoryNode, "StatementNode");
        ExpressionNode liftElseStatement = 
                node.getUnionForElseStatement().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForElseStatement().getSpliceNode(), factoryNode, "StatementNode") :
                expressionizeNormalNodeUnion(node.getElseStatement(), factoryNode, "StatementNode");
        ExpressionNode liftMetaAnnotations = 
                node.getUnionForMetaAnnotations().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForMetaAnnotations().getSpliceNode(), factoryNode, "MetaAnnotationListNode") :
                expressionizeNormalNodeUnion(node.getMetaAnnotations(), factoryNode, "MetaAnnotationListNode");
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeIfNodeWithUnions"),
                        factory.makeExpressionListNode(
                                liftCondition,
                                liftThenStatement,
                                liftElseStatement,
                                liftMetaAnnotations,
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeImportListNode(ImportListNode node, ExpressionNode factoryNode)
    {
        List<ExpressionNode> liftChildrenList = new ArrayList<ExpressionNode>();
        for (NodeUnion<? extends ImportNode> listval : node.getUnionForChildren())
        {
            liftChildrenList.add(
                    listval != null ? 
                            (listval.getType() == NodeUnion.Type.SPLICE ? 
                                    expressionizeSpliceNodeUnion(listval.getSpliceNode(), factoryNode, "ImportNode") :
                            expressionizeNormalNodeUnion(listval.getNormalNode(), factoryNode, "ImportNode"))
                            : factory.makeNullLiteralNode());
        }
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeImportListNodeWithUnions"),
                        factory.makeExpressionListNode(
                                factory.makeMethodInvocationNode(
                                        factory.makeVariableAccessNode(
                                                factory.makeVariableAccessNode(
                                                        factory.makeVariableAccessNode(
                                                                factory.makeVariableAccessNode(
                                                                        factory.makeVariableAccessNode(
                                                                                factory.makeVariableAccessNode(
                                                                                        factory.makeVariableAccessNode(
                                                                                                factory.makeVariableAccessNode(
                                                                                                        factory.makeIdentifierNode("edu")),
                                                                                                factory.makeIdentifierNode("jhu")),
                                                                                        factory.makeIdentifierNode("cs")),
                                                                                factory.makeIdentifierNode("bsj")),
                                                                        factory.makeIdentifierNode("compiler")),
                                                                factory.makeIdentifierNode("impl")),
                                                        factory.makeIdentifierNode("utils")),
                                                factory.makeIdentifierNode("CollectionUtilities")),
                                        factory.makeIdentifierNode("listOf"),
                                        factory.makeExpressionListNode(liftChildrenList),
                                        factory.makeReferenceTypeListNode(
                                                factory.makeParameterizedTypeNode(
                                                        factory.makeUnparameterizedTypeNode(
                                                                factory.makeSimpleNameNode(
                                                                        factory.makeIdentifierNode("NodeUnion"))),
                                                        factory.makeTypeArgumentListNode(
                                                                factory.makeWildcardTypeNode(
                                                                        factory.makeUnparameterizedTypeNode(
                                                                                factory.makeSimpleNameNode(
                                                                                        factory.makeIdentifierNode("ImportNode"))),
                                                                        true))))),
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeImportOnDemandNode(ImportOnDemandNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftName = 
                node.getUnionForName().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForName().getSpliceNode(), factoryNode, "NameNode") :
                expressionizeNormalNodeUnion(node.getName(), factoryNode, "NameNode");
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeImportOnDemandNodeWithUnions"),
                        factory.makeExpressionListNode(
                                liftName,
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeImportSingleTypeNode(ImportSingleTypeNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftName = 
                node.getUnionForName().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForName().getSpliceNode(), factoryNode, "NameNode") :
                expressionizeNormalNodeUnion(node.getName(), factoryNode, "NameNode");
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeImportSingleTypeNodeWithUnions"),
                        factory.makeExpressionListNode(
                                liftName,
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeInitializerDeclarationNode(InitializerDeclarationNode node, ExpressionNode factoryNode)
    {
        boolean liftStaticInitializerValue = 
                node.getStaticInitializer();
        ExpressionNode liftBody = 
                node.getUnionForBody().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForBody().getSpliceNode(), factoryNode, "BlockStatementListNode") :
                expressionizeNormalNodeUnion(node.getBody(), factoryNode, "BlockStatementListNode");
        ExpressionNode liftMetaAnnotations = 
                node.getUnionForMetaAnnotations().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForMetaAnnotations().getSpliceNode(), factoryNode, "MetaAnnotationListNode") :
                expressionizeNormalNodeUnion(node.getMetaAnnotations(), factoryNode, "MetaAnnotationListNode");
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeInitializerDeclarationNodeWithUnions"),
                        factory.makeExpressionListNode(
                                expressionizeBoolean(liftStaticInitializerValue),
                                liftBody,
                                liftMetaAnnotations,
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeInstanceOfNode(InstanceOfNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftExpression = 
                node.getUnionForExpression().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForExpression().getSpliceNode(), factoryNode, "ExpressionNode") :
                expressionizeNormalNodeUnion(node.getExpression(), factoryNode, "ExpressionNode");
        ExpressionNode liftType = 
                node.getUnionForType().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForType().getSpliceNode(), factoryNode, "TypeNode") :
                expressionizeNormalNodeUnion(node.getType(), factoryNode, "TypeNode");
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeInstanceOfNodeWithUnions"),
                        factory.makeExpressionListNode(
                                liftExpression,
                                liftType,
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode());
        
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
                factory.makeMethodInvocationNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeIntLiteralNode"),
                        factory.makeExpressionListNode(
                                expressionizeInteger(liftValueValue),
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeInterfaceBodyNode(InterfaceBodyNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftMembers = 
                node.getUnionForMembers().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForMembers().getSpliceNode(), factoryNode, "InterfaceMemberListNode") :
                expressionizeNormalNodeUnion(node.getMembers(), factoryNode, "InterfaceMemberListNode");
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeInterfaceBodyNodeWithUnions"),
                        factory.makeExpressionListNode(
                                liftMembers,
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeInterfaceDeclarationNode(InterfaceDeclarationNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftModifiers = 
                node.getUnionForModifiers().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForModifiers().getSpliceNode(), factoryNode, "InterfaceModifiersNode") :
                expressionizeNormalNodeUnion(node.getModifiers(), factoryNode, "InterfaceModifiersNode");
        ExpressionNode liftExtendsClause = 
                node.getUnionForExtendsClause().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForExtendsClause().getSpliceNode(), factoryNode, "DeclaredTypeListNode") :
                expressionizeNormalNodeUnion(node.getExtendsClause(), factoryNode, "DeclaredTypeListNode");
        ExpressionNode liftBody = 
                node.getUnionForBody().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForBody().getSpliceNode(), factoryNode, "InterfaceBodyNode") :
                expressionizeNormalNodeUnion(node.getBody(), factoryNode, "InterfaceBodyNode");
        ExpressionNode liftTypeParameters = 
                node.getUnionForTypeParameters().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForTypeParameters().getSpliceNode(), factoryNode, "TypeParameterListNode") :
                expressionizeNormalNodeUnion(node.getTypeParameters(), factoryNode, "TypeParameterListNode");
        ExpressionNode liftIdentifier = 
                node.getUnionForIdentifier().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForIdentifier().getSpliceNode(), factoryNode, "IdentifierNode") :
                expressionizeNormalNodeUnion(node.getIdentifier(), factoryNode, "IdentifierNode");
        ExpressionNode liftJavadoc = 
                node.getUnionForJavadoc().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForJavadoc().getSpliceNode(), factoryNode, "JavadocNode") :
                expressionizeNormalNodeUnion(node.getJavadoc(), factoryNode, "JavadocNode");
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeInterfaceDeclarationNodeWithUnions"),
                        factory.makeExpressionListNode(
                                liftModifiers,
                                liftExtendsClause,
                                liftBody,
                                liftTypeParameters,
                                liftIdentifier,
                                liftJavadoc,
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeInterfaceMemberListNode(InterfaceMemberListNode node, ExpressionNode factoryNode)
    {
        List<ExpressionNode> liftChildrenList = new ArrayList<ExpressionNode>();
        for (NodeUnion<? extends InterfaceMemberNode> listval : node.getUnionForChildren())
        {
            liftChildrenList.add(
                    listval != null ? 
                            (listval.getType() == NodeUnion.Type.SPLICE ? 
                                    expressionizeSpliceNodeUnion(listval.getSpliceNode(), factoryNode, "InterfaceMemberNode") :
                            expressionizeNormalNodeUnion(listval.getNormalNode(), factoryNode, "InterfaceMemberNode"))
                            : factory.makeNullLiteralNode());
        }
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeInterfaceMemberListNodeWithUnions"),
                        factory.makeExpressionListNode(
                                factory.makeMethodInvocationNode(
                                        factory.makeVariableAccessNode(
                                                factory.makeVariableAccessNode(
                                                        factory.makeVariableAccessNode(
                                                                factory.makeVariableAccessNode(
                                                                        factory.makeVariableAccessNode(
                                                                                factory.makeVariableAccessNode(
                                                                                        factory.makeVariableAccessNode(
                                                                                                factory.makeVariableAccessNode(
                                                                                                        factory.makeIdentifierNode("edu")),
                                                                                                factory.makeIdentifierNode("jhu")),
                                                                                        factory.makeIdentifierNode("cs")),
                                                                                factory.makeIdentifierNode("bsj")),
                                                                        factory.makeIdentifierNode("compiler")),
                                                                factory.makeIdentifierNode("impl")),
                                                        factory.makeIdentifierNode("utils")),
                                                factory.makeIdentifierNode("CollectionUtilities")),
                                        factory.makeIdentifierNode("listOf"),
                                        factory.makeExpressionListNode(liftChildrenList),
                                        factory.makeReferenceTypeListNode(
                                                factory.makeParameterizedTypeNode(
                                                        factory.makeUnparameterizedTypeNode(
                                                                factory.makeSimpleNameNode(
                                                                        factory.makeIdentifierNode("NodeUnion"))),
                                                        factory.makeTypeArgumentListNode(
                                                                factory.makeWildcardTypeNode(
                                                                        factory.makeUnparameterizedTypeNode(
                                                                                factory.makeSimpleNameNode(
                                                                                        factory.makeIdentifierNode("InterfaceMemberNode"))),
                                                                        true))))),
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeInterfaceMemberMetaprogramAnchorNode(InterfaceMemberMetaprogramAnchorNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftMetaprogram = 
                node.getUnionForMetaprogram().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForMetaprogram().getSpliceNode(), factoryNode, "MetaprogramNode") :
                expressionizeNormalNodeUnion(node.getMetaprogram(), factoryNode, "MetaprogramNode");
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeInterfaceMemberMetaprogramAnchorNodeWithUnions"),
                        factory.makeExpressionListNode(
                                liftMetaprogram,
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode());
        
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
                node.getUnionForMetaAnnotations().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForMetaAnnotations().getSpliceNode(), factoryNode, "MetaAnnotationListNode") :
                expressionizeNormalNodeUnion(node.getMetaAnnotations(), factoryNode, "MetaAnnotationListNode");
        ExpressionNode liftAnnotations = 
                node.getUnionForAnnotations().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForAnnotations().getSpliceNode(), factoryNode, "AnnotationListNode") :
                expressionizeNormalNodeUnion(node.getAnnotations(), factoryNode, "AnnotationListNode");
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeInterfaceModifiersNodeWithUnions"),
                        factory.makeExpressionListNode(
                                expressionizeAccessModifier(liftAccessValue),
                                expressionizeBoolean(liftStaticFlagValue),
                                expressionizeBoolean(liftStrictfpFlagValue),
                                liftMetaAnnotations,
                                liftAnnotations,
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode());
        
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
                factory.makeMethodInvocationNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeJavadocNode"),
                        factory.makeExpressionListNode(
                                expressionizeString(liftTextValue),
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeLabeledStatementNode(LabeledStatementNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftLabel = 
                node.getUnionForLabel().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForLabel().getSpliceNode(), factoryNode, "IdentifierNode") :
                expressionizeNormalNodeUnion(node.getLabel(), factoryNode, "IdentifierNode");
        ExpressionNode liftStatement = 
                node.getUnionForStatement().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForStatement().getSpliceNode(), factoryNode, "StatementNode") :
                expressionizeNormalNodeUnion(node.getStatement(), factoryNode, "StatementNode");
        ExpressionNode liftMetaAnnotations = 
                node.getUnionForMetaAnnotations().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForMetaAnnotations().getSpliceNode(), factoryNode, "MetaAnnotationListNode") :
                expressionizeNormalNodeUnion(node.getMetaAnnotations(), factoryNode, "MetaAnnotationListNode");
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeLabeledStatementNodeWithUnions"),
                        factory.makeExpressionListNode(
                                liftLabel,
                                liftStatement,
                                liftMetaAnnotations,
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeLocalClassDeclarationNode(LocalClassDeclarationNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftModifiers = 
                node.getUnionForModifiers().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForModifiers().getSpliceNode(), factoryNode, "LocalClassModifiersNode") :
                expressionizeNormalNodeUnion(node.getModifiers(), factoryNode, "LocalClassModifiersNode");
        ExpressionNode liftExtendsClause = 
                node.getUnionForExtendsClause().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForExtendsClause().getSpliceNode(), factoryNode, "DeclaredTypeNode") :
                expressionizeNormalNodeUnion(node.getExtendsClause(), factoryNode, "DeclaredTypeNode");
        ExpressionNode liftImplementsClause = 
                node.getUnionForImplementsClause().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForImplementsClause().getSpliceNode(), factoryNode, "DeclaredTypeListNode") :
                expressionizeNormalNodeUnion(node.getImplementsClause(), factoryNode, "DeclaredTypeListNode");
        ExpressionNode liftBody = 
                node.getUnionForBody().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForBody().getSpliceNode(), factoryNode, "ClassBodyNode") :
                expressionizeNormalNodeUnion(node.getBody(), factoryNode, "ClassBodyNode");
        ExpressionNode liftTypeParameters = 
                node.getUnionForTypeParameters().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForTypeParameters().getSpliceNode(), factoryNode, "TypeParameterListNode") :
                expressionizeNormalNodeUnion(node.getTypeParameters(), factoryNode, "TypeParameterListNode");
        ExpressionNode liftIdentifier = 
                node.getUnionForIdentifier().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForIdentifier().getSpliceNode(), factoryNode, "IdentifierNode") :
                expressionizeNormalNodeUnion(node.getIdentifier(), factoryNode, "IdentifierNode");
        ExpressionNode liftJavadoc = 
                node.getUnionForJavadoc().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForJavadoc().getSpliceNode(), factoryNode, "JavadocNode") :
                expressionizeNormalNodeUnion(node.getJavadoc(), factoryNode, "JavadocNode");
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeLocalClassDeclarationNodeWithUnions"),
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
                        factory.makeReferenceTypeListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeLocalClassModifiersNode(LocalClassModifiersNode node, ExpressionNode factoryNode)
    {
        boolean liftAbstractFlagValue = 
                node.getAbstractFlag();
        boolean liftFinalFlagValue = 
                node.getFinalFlag();
        boolean liftStrictfpFlagValue = 
                node.getStrictfpFlag();
        ExpressionNode liftMetaAnnotations = 
                node.getUnionForMetaAnnotations().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForMetaAnnotations().getSpliceNode(), factoryNode, "MetaAnnotationListNode") :
                expressionizeNormalNodeUnion(node.getMetaAnnotations(), factoryNode, "MetaAnnotationListNode");
        ExpressionNode liftAnnotations = 
                node.getUnionForAnnotations().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForAnnotations().getSpliceNode(), factoryNode, "AnnotationListNode") :
                expressionizeNormalNodeUnion(node.getAnnotations(), factoryNode, "AnnotationListNode");
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeLocalClassModifiersNodeWithUnions"),
                        factory.makeExpressionListNode(
                                expressionizeBoolean(liftAbstractFlagValue),
                                expressionizeBoolean(liftFinalFlagValue),
                                expressionizeBoolean(liftStrictfpFlagValue),
                                liftMetaAnnotations,
                                liftAnnotations,
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeLocalVariableDeclarationNode(LocalVariableDeclarationNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftModifiers = 
                node.getUnionForModifiers().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForModifiers().getSpliceNode(), factoryNode, "VariableModifiersNode") :
                expressionizeNormalNodeUnion(node.getModifiers(), factoryNode, "VariableModifiersNode");
        ExpressionNode liftType = 
                node.getUnionForType().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForType().getSpliceNode(), factoryNode, "TypeNode") :
                expressionizeNormalNodeUnion(node.getType(), factoryNode, "TypeNode");
        ExpressionNode liftDeclarators = 
                node.getUnionForDeclarators().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForDeclarators().getSpliceNode(), factoryNode, "VariableDeclaratorListNode") :
                expressionizeNormalNodeUnion(node.getDeclarators(), factoryNode, "VariableDeclaratorListNode");
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeLocalVariableDeclarationNodeWithUnions"),
                        factory.makeExpressionListNode(
                                liftModifiers,
                                liftType,
                                liftDeclarators,
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode());
        
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
                factory.makeMethodInvocationNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeLongLiteralNode"),
                        factory.makeExpressionListNode(
                                expressionizeLong(liftValueValue),
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeMetaAnnotationArrayValueNode(MetaAnnotationArrayValueNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftValues = 
                node.getUnionForValues().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForValues().getSpliceNode(), factoryNode, "MetaAnnotationValueListNode") :
                expressionizeNormalNodeUnion(node.getValues(), factoryNode, "MetaAnnotationValueListNode");
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeMetaAnnotationArrayValueNodeWithUnions"),
                        factory.makeExpressionListNode(
                                liftValues,
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeMetaAnnotationElementListNode(MetaAnnotationElementListNode node, ExpressionNode factoryNode)
    {
        List<ExpressionNode> liftChildrenList = new ArrayList<ExpressionNode>();
        for (NodeUnion<? extends MetaAnnotationElementNode> listval : node.getUnionForChildren())
        {
            liftChildrenList.add(
                    listval != null ? 
                            (listval.getType() == NodeUnion.Type.SPLICE ? 
                                    expressionizeSpliceNodeUnion(listval.getSpliceNode(), factoryNode, "MetaAnnotationElementNode") :
                            expressionizeNormalNodeUnion(listval.getNormalNode(), factoryNode, "MetaAnnotationElementNode"))
                            : factory.makeNullLiteralNode());
        }
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeMetaAnnotationElementListNodeWithUnions"),
                        factory.makeExpressionListNode(
                                factory.makeMethodInvocationNode(
                                        factory.makeVariableAccessNode(
                                                factory.makeVariableAccessNode(
                                                        factory.makeVariableAccessNode(
                                                                factory.makeVariableAccessNode(
                                                                        factory.makeVariableAccessNode(
                                                                                factory.makeVariableAccessNode(
                                                                                        factory.makeVariableAccessNode(
                                                                                                factory.makeVariableAccessNode(
                                                                                                        factory.makeIdentifierNode("edu")),
                                                                                                factory.makeIdentifierNode("jhu")),
                                                                                        factory.makeIdentifierNode("cs")),
                                                                                factory.makeIdentifierNode("bsj")),
                                                                        factory.makeIdentifierNode("compiler")),
                                                                factory.makeIdentifierNode("impl")),
                                                        factory.makeIdentifierNode("utils")),
                                                factory.makeIdentifierNode("CollectionUtilities")),
                                        factory.makeIdentifierNode("listOf"),
                                        factory.makeExpressionListNode(liftChildrenList),
                                        factory.makeReferenceTypeListNode(
                                                factory.makeParameterizedTypeNode(
                                                        factory.makeUnparameterizedTypeNode(
                                                                factory.makeSimpleNameNode(
                                                                        factory.makeIdentifierNode("NodeUnion"))),
                                                        factory.makeTypeArgumentListNode(
                                                                factory.makeWildcardTypeNode(
                                                                        factory.makeUnparameterizedTypeNode(
                                                                                factory.makeSimpleNameNode(
                                                                                        factory.makeIdentifierNode("MetaAnnotationElementNode"))),
                                                                        true))))),
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeMetaAnnotationElementNode(MetaAnnotationElementNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftIdentifier = 
                node.getUnionForIdentifier().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForIdentifier().getSpliceNode(), factoryNode, "IdentifierNode") :
                expressionizeNormalNodeUnion(node.getIdentifier(), factoryNode, "IdentifierNode");
        ExpressionNode liftValue = 
                node.getUnionForValue().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForValue().getSpliceNode(), factoryNode, "MetaAnnotationValueNode") :
                expressionizeNormalNodeUnion(node.getValue(), factoryNode, "MetaAnnotationValueNode");
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeMetaAnnotationElementNodeWithUnions"),
                        factory.makeExpressionListNode(
                                liftIdentifier,
                                liftValue,
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeMetaAnnotationExpressionValueNode(MetaAnnotationExpressionValueNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftExpression = 
                node.getUnionForExpression().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForExpression().getSpliceNode(), factoryNode, "NonAssignmentExpressionNode") :
                expressionizeNormalNodeUnion(node.getExpression(), factoryNode, "NonAssignmentExpressionNode");
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeMetaAnnotationExpressionValueNodeWithUnions"),
                        factory.makeExpressionListNode(
                                liftExpression,
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeMetaAnnotationListNode(MetaAnnotationListNode node, ExpressionNode factoryNode)
    {
        List<ExpressionNode> liftChildrenList = new ArrayList<ExpressionNode>();
        for (NodeUnion<? extends MetaAnnotationNode> listval : node.getUnionForChildren())
        {
            liftChildrenList.add(
                    listval != null ? 
                            (listval.getType() == NodeUnion.Type.SPLICE ? 
                                    expressionizeSpliceNodeUnion(listval.getSpliceNode(), factoryNode, "MetaAnnotationNode") :
                            expressionizeNormalNodeUnion(listval.getNormalNode(), factoryNode, "MetaAnnotationNode"))
                            : factory.makeNullLiteralNode());
        }
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeMetaAnnotationListNodeWithUnions"),
                        factory.makeExpressionListNode(
                                factory.makeMethodInvocationNode(
                                        factory.makeVariableAccessNode(
                                                factory.makeVariableAccessNode(
                                                        factory.makeVariableAccessNode(
                                                                factory.makeVariableAccessNode(
                                                                        factory.makeVariableAccessNode(
                                                                                factory.makeVariableAccessNode(
                                                                                        factory.makeVariableAccessNode(
                                                                                                factory.makeVariableAccessNode(
                                                                                                        factory.makeIdentifierNode("edu")),
                                                                                                factory.makeIdentifierNode("jhu")),
                                                                                        factory.makeIdentifierNode("cs")),
                                                                                factory.makeIdentifierNode("bsj")),
                                                                        factory.makeIdentifierNode("compiler")),
                                                                factory.makeIdentifierNode("impl")),
                                                        factory.makeIdentifierNode("utils")),
                                                factory.makeIdentifierNode("CollectionUtilities")),
                                        factory.makeIdentifierNode("listOf"),
                                        factory.makeExpressionListNode(liftChildrenList),
                                        factory.makeReferenceTypeListNode(
                                                factory.makeParameterizedTypeNode(
                                                        factory.makeUnparameterizedTypeNode(
                                                                factory.makeSimpleNameNode(
                                                                        factory.makeIdentifierNode("NodeUnion"))),
                                                        factory.makeTypeArgumentListNode(
                                                                factory.makeWildcardTypeNode(
                                                                        factory.makeUnparameterizedTypeNode(
                                                                                factory.makeSimpleNameNode(
                                                                                        factory.makeIdentifierNode("MetaAnnotationNode"))),
                                                                        true))))),
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeMetaAnnotationMetaAnnotationValueNode(MetaAnnotationMetaAnnotationValueNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftAnnotation = 
                node.getUnionForAnnotation().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForAnnotation().getSpliceNode(), factoryNode, "MetaAnnotationNode") :
                expressionizeNormalNodeUnion(node.getAnnotation(), factoryNode, "MetaAnnotationNode");
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeMetaAnnotationMetaAnnotationValueNodeWithUnions"),
                        factory.makeExpressionListNode(
                                liftAnnotation,
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode());
        
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
                factory.makeMethodInvocationNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeMetaAnnotationMetaprogramAnchorNode"),
                        factory.makeExpressionListNode(
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeMetaAnnotationValueListNode(MetaAnnotationValueListNode node, ExpressionNode factoryNode)
    {
        List<ExpressionNode> liftChildrenList = new ArrayList<ExpressionNode>();
        for (NodeUnion<? extends MetaAnnotationValueNode> listval : node.getUnionForChildren())
        {
            liftChildrenList.add(
                    listval != null ? 
                            (listval.getType() == NodeUnion.Type.SPLICE ? 
                                    expressionizeSpliceNodeUnion(listval.getSpliceNode(), factoryNode, "MetaAnnotationValueNode") :
                            expressionizeNormalNodeUnion(listval.getNormalNode(), factoryNode, "MetaAnnotationValueNode"))
                            : factory.makeNullLiteralNode());
        }
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeMetaAnnotationValueListNodeWithUnions"),
                        factory.makeExpressionListNode(
                                factory.makeMethodInvocationNode(
                                        factory.makeVariableAccessNode(
                                                factory.makeVariableAccessNode(
                                                        factory.makeVariableAccessNode(
                                                                factory.makeVariableAccessNode(
                                                                        factory.makeVariableAccessNode(
                                                                                factory.makeVariableAccessNode(
                                                                                        factory.makeVariableAccessNode(
                                                                                                factory.makeVariableAccessNode(
                                                                                                        factory.makeIdentifierNode("edu")),
                                                                                                factory.makeIdentifierNode("jhu")),
                                                                                        factory.makeIdentifierNode("cs")),
                                                                                factory.makeIdentifierNode("bsj")),
                                                                        factory.makeIdentifierNode("compiler")),
                                                                factory.makeIdentifierNode("impl")),
                                                        factory.makeIdentifierNode("utils")),
                                                factory.makeIdentifierNode("CollectionUtilities")),
                                        factory.makeIdentifierNode("listOf"),
                                        factory.makeExpressionListNode(liftChildrenList),
                                        factory.makeReferenceTypeListNode(
                                                factory.makeParameterizedTypeNode(
                                                        factory.makeUnparameterizedTypeNode(
                                                                factory.makeSimpleNameNode(
                                                                        factory.makeIdentifierNode("NodeUnion"))),
                                                        factory.makeTypeArgumentListNode(
                                                                factory.makeWildcardTypeNode(
                                                                        factory.makeUnparameterizedTypeNode(
                                                                                factory.makeSimpleNameNode(
                                                                                        factory.makeIdentifierNode("MetaAnnotationValueNode"))),
                                                                        true))))),
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeMetaprogramDependencyDeclarationListNode(MetaprogramDependencyDeclarationListNode node, ExpressionNode factoryNode)
    {
        List<ExpressionNode> liftChildrenList = new ArrayList<ExpressionNode>();
        for (NodeUnion<? extends MetaprogramDependencyDeclarationNode> listval : node.getUnionForChildren())
        {
            liftChildrenList.add(
                    listval != null ? 
                            (listval.getType() == NodeUnion.Type.SPLICE ? 
                                    expressionizeSpliceNodeUnion(listval.getSpliceNode(), factoryNode, "MetaprogramDependencyDeclarationNode") :
                            expressionizeNormalNodeUnion(listval.getNormalNode(), factoryNode, "MetaprogramDependencyDeclarationNode"))
                            : factory.makeNullLiteralNode());
        }
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeMetaprogramDependencyDeclarationListNodeWithUnions"),
                        factory.makeExpressionListNode(
                                factory.makeMethodInvocationNode(
                                        factory.makeVariableAccessNode(
                                                factory.makeVariableAccessNode(
                                                        factory.makeVariableAccessNode(
                                                                factory.makeVariableAccessNode(
                                                                        factory.makeVariableAccessNode(
                                                                                factory.makeVariableAccessNode(
                                                                                        factory.makeVariableAccessNode(
                                                                                                factory.makeVariableAccessNode(
                                                                                                        factory.makeIdentifierNode("edu")),
                                                                                                factory.makeIdentifierNode("jhu")),
                                                                                        factory.makeIdentifierNode("cs")),
                                                                                factory.makeIdentifierNode("bsj")),
                                                                        factory.makeIdentifierNode("compiler")),
                                                                factory.makeIdentifierNode("impl")),
                                                        factory.makeIdentifierNode("utils")),
                                                factory.makeIdentifierNode("CollectionUtilities")),
                                        factory.makeIdentifierNode("listOf"),
                                        factory.makeExpressionListNode(liftChildrenList),
                                        factory.makeReferenceTypeListNode(
                                                factory.makeParameterizedTypeNode(
                                                        factory.makeUnparameterizedTypeNode(
                                                                factory.makeSimpleNameNode(
                                                                        factory.makeIdentifierNode("NodeUnion"))),
                                                        factory.makeTypeArgumentListNode(
                                                                factory.makeWildcardTypeNode(
                                                                        factory.makeUnparameterizedTypeNode(
                                                                                factory.makeSimpleNameNode(
                                                                                        factory.makeIdentifierNode("MetaprogramDependencyDeclarationNode"))),
                                                                        true))))),
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeMetaprogramDependencyDeclarationNode(MetaprogramDependencyDeclarationNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftTargets = 
                node.getUnionForTargets().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForTargets().getSpliceNode(), factoryNode, "MetaprogramDependencyListNode") :
                expressionizeNormalNodeUnion(node.getTargets(), factoryNode, "MetaprogramDependencyListNode");
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeMetaprogramDependencyDeclarationNodeWithUnions"),
                        factory.makeExpressionListNode(
                                liftTargets,
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeMetaprogramDependencyListNode(MetaprogramDependencyListNode node, ExpressionNode factoryNode)
    {
        List<ExpressionNode> liftChildrenList = new ArrayList<ExpressionNode>();
        for (NodeUnion<? extends MetaprogramDependencyNode> listval : node.getUnionForChildren())
        {
            liftChildrenList.add(
                    listval != null ? 
                            (listval.getType() == NodeUnion.Type.SPLICE ? 
                                    expressionizeSpliceNodeUnion(listval.getSpliceNode(), factoryNode, "MetaprogramDependencyNode") :
                            expressionizeNormalNodeUnion(listval.getNormalNode(), factoryNode, "MetaprogramDependencyNode"))
                            : factory.makeNullLiteralNode());
        }
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeMetaprogramDependencyListNodeWithUnions"),
                        factory.makeExpressionListNode(
                                factory.makeMethodInvocationNode(
                                        factory.makeVariableAccessNode(
                                                factory.makeVariableAccessNode(
                                                        factory.makeVariableAccessNode(
                                                                factory.makeVariableAccessNode(
                                                                        factory.makeVariableAccessNode(
                                                                                factory.makeVariableAccessNode(
                                                                                        factory.makeVariableAccessNode(
                                                                                                factory.makeVariableAccessNode(
                                                                                                        factory.makeIdentifierNode("edu")),
                                                                                                factory.makeIdentifierNode("jhu")),
                                                                                        factory.makeIdentifierNode("cs")),
                                                                                factory.makeIdentifierNode("bsj")),
                                                                        factory.makeIdentifierNode("compiler")),
                                                                factory.makeIdentifierNode("impl")),
                                                        factory.makeIdentifierNode("utils")),
                                                factory.makeIdentifierNode("CollectionUtilities")),
                                        factory.makeIdentifierNode("listOf"),
                                        factory.makeExpressionListNode(liftChildrenList),
                                        factory.makeReferenceTypeListNode(
                                                factory.makeParameterizedTypeNode(
                                                        factory.makeUnparameterizedTypeNode(
                                                                factory.makeSimpleNameNode(
                                                                        factory.makeIdentifierNode("NodeUnion"))),
                                                        factory.makeTypeArgumentListNode(
                                                                factory.makeWildcardTypeNode(
                                                                        factory.makeUnparameterizedTypeNode(
                                                                                factory.makeSimpleNameNode(
                                                                                        factory.makeIdentifierNode("MetaprogramDependencyNode"))),
                                                                        true))))),
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeMetaprogramDependencyNode(MetaprogramDependencyNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftTargetName = 
                node.getUnionForTargetName().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForTargetName().getSpliceNode(), factoryNode, "NameNode") :
                expressionizeNormalNodeUnion(node.getTargetName(), factoryNode, "NameNode");
        boolean liftWeakValue = 
                node.getWeak();
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeMetaprogramDependencyNodeWithUnions"),
                        factory.makeExpressionListNode(
                                liftTargetName,
                                expressionizeBoolean(liftWeakValue),
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeMetaprogramImportListNode(MetaprogramImportListNode node, ExpressionNode factoryNode)
    {
        List<ExpressionNode> liftChildrenList = new ArrayList<ExpressionNode>();
        for (NodeUnion<? extends MetaprogramImportNode> listval : node.getUnionForChildren())
        {
            liftChildrenList.add(
                    listval != null ? 
                            (listval.getType() == NodeUnion.Type.SPLICE ? 
                                    expressionizeSpliceNodeUnion(listval.getSpliceNode(), factoryNode, "MetaprogramImportNode") :
                            expressionizeNormalNodeUnion(listval.getNormalNode(), factoryNode, "MetaprogramImportNode"))
                            : factory.makeNullLiteralNode());
        }
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeMetaprogramImportListNodeWithUnions"),
                        factory.makeExpressionListNode(
                                factory.makeMethodInvocationNode(
                                        factory.makeVariableAccessNode(
                                                factory.makeVariableAccessNode(
                                                        factory.makeVariableAccessNode(
                                                                factory.makeVariableAccessNode(
                                                                        factory.makeVariableAccessNode(
                                                                                factory.makeVariableAccessNode(
                                                                                        factory.makeVariableAccessNode(
                                                                                                factory.makeVariableAccessNode(
                                                                                                        factory.makeIdentifierNode("edu")),
                                                                                                factory.makeIdentifierNode("jhu")),
                                                                                        factory.makeIdentifierNode("cs")),
                                                                                factory.makeIdentifierNode("bsj")),
                                                                        factory.makeIdentifierNode("compiler")),
                                                                factory.makeIdentifierNode("impl")),
                                                        factory.makeIdentifierNode("utils")),
                                                factory.makeIdentifierNode("CollectionUtilities")),
                                        factory.makeIdentifierNode("listOf"),
                                        factory.makeExpressionListNode(liftChildrenList),
                                        factory.makeReferenceTypeListNode(
                                                factory.makeParameterizedTypeNode(
                                                        factory.makeUnparameterizedTypeNode(
                                                                factory.makeSimpleNameNode(
                                                                        factory.makeIdentifierNode("NodeUnion"))),
                                                        factory.makeTypeArgumentListNode(
                                                                factory.makeWildcardTypeNode(
                                                                        factory.makeUnparameterizedTypeNode(
                                                                                factory.makeSimpleNameNode(
                                                                                        factory.makeIdentifierNode("MetaprogramImportNode"))),
                                                                        true))))),
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeMetaprogramImportNode(MetaprogramImportNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftImportNode = 
                node.getUnionForImportNode().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForImportNode().getSpliceNode(), factoryNode, "ImportNode") :
                expressionizeNormalNodeUnion(node.getImportNode(), factoryNode, "ImportNode");
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeMetaprogramImportNodeWithUnions"),
                        factory.makeExpressionListNode(
                                liftImportNode,
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeMetaprogramNode(MetaprogramNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftPreamble = 
                node.getUnionForPreamble().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForPreamble().getSpliceNode(), factoryNode, "MetaprogramPreambleNode") :
                expressionizeNormalNodeUnion(node.getPreamble(), factoryNode, "MetaprogramPreambleNode");
        ExpressionNode liftBody = 
                node.getUnionForBody().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForBody().getSpliceNode(), factoryNode, "BlockStatementListNode") :
                expressionizeNormalNodeUnion(node.getBody(), factoryNode, "BlockStatementListNode");
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeMetaprogramNodeWithUnions"),
                        factory.makeExpressionListNode(
                                liftPreamble,
                                liftBody,
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeMetaprogramPreambleNode(MetaprogramPreambleNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftImports = 
                node.getUnionForImports().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForImports().getSpliceNode(), factoryNode, "MetaprogramImportListNode") :
                expressionizeNormalNodeUnion(node.getImports(), factoryNode, "MetaprogramImportListNode");
        MetaprogramLocalMode liftLocalModeValue = 
                node.getLocalMode();
        MetaprogramPackageMode liftPackageModeValue = 
                node.getPackageMode();
        ExpressionNode liftTargets = 
                node.getUnionForTargets().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForTargets().getSpliceNode(), factoryNode, "MetaprogramTargetListNode") :
                expressionizeNormalNodeUnion(node.getTargets(), factoryNode, "MetaprogramTargetListNode");
        ExpressionNode liftDependencies = 
                node.getUnionForDependencies().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForDependencies().getSpliceNode(), factoryNode, "MetaprogramDependencyDeclarationListNode") :
                expressionizeNormalNodeUnion(node.getDependencies(), factoryNode, "MetaprogramDependencyDeclarationListNode");
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeMetaprogramPreambleNodeWithUnions"),
                        factory.makeExpressionListNode(
                                liftImports,
                                expressionizeMetaprogramLocalMode(liftLocalModeValue),
                                expressionizeMetaprogramPackageMode(liftPackageModeValue),
                                liftTargets,
                                liftDependencies,
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeMetaprogramTargetListNode(MetaprogramTargetListNode node, ExpressionNode factoryNode)
    {
        List<ExpressionNode> liftChildrenList = new ArrayList<ExpressionNode>();
        for (NodeUnion<? extends MetaprogramTargetNode> listval : node.getUnionForChildren())
        {
            liftChildrenList.add(
                    listval != null ? 
                            (listval.getType() == NodeUnion.Type.SPLICE ? 
                                    expressionizeSpliceNodeUnion(listval.getSpliceNode(), factoryNode, "MetaprogramTargetNode") :
                            expressionizeNormalNodeUnion(listval.getNormalNode(), factoryNode, "MetaprogramTargetNode"))
                            : factory.makeNullLiteralNode());
        }
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeMetaprogramTargetListNodeWithUnions"),
                        factory.makeExpressionListNode(
                                factory.makeMethodInvocationNode(
                                        factory.makeVariableAccessNode(
                                                factory.makeVariableAccessNode(
                                                        factory.makeVariableAccessNode(
                                                                factory.makeVariableAccessNode(
                                                                        factory.makeVariableAccessNode(
                                                                                factory.makeVariableAccessNode(
                                                                                        factory.makeVariableAccessNode(
                                                                                                factory.makeVariableAccessNode(
                                                                                                        factory.makeIdentifierNode("edu")),
                                                                                                factory.makeIdentifierNode("jhu")),
                                                                                        factory.makeIdentifierNode("cs")),
                                                                                factory.makeIdentifierNode("bsj")),
                                                                        factory.makeIdentifierNode("compiler")),
                                                                factory.makeIdentifierNode("impl")),
                                                        factory.makeIdentifierNode("utils")),
                                                factory.makeIdentifierNode("CollectionUtilities")),
                                        factory.makeIdentifierNode("listOf"),
                                        factory.makeExpressionListNode(liftChildrenList),
                                        factory.makeReferenceTypeListNode(
                                                factory.makeParameterizedTypeNode(
                                                        factory.makeUnparameterizedTypeNode(
                                                                factory.makeSimpleNameNode(
                                                                        factory.makeIdentifierNode("NodeUnion"))),
                                                        factory.makeTypeArgumentListNode(
                                                                factory.makeWildcardTypeNode(
                                                                        factory.makeUnparameterizedTypeNode(
                                                                                factory.makeSimpleNameNode(
                                                                                        factory.makeIdentifierNode("MetaprogramTargetNode"))),
                                                                        true))))),
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeMetaprogramTargetNode(MetaprogramTargetNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftTargets = 
                node.getUnionForTargets().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForTargets().getSpliceNode(), factoryNode, "IdentifierListNode") :
                expressionizeNormalNodeUnion(node.getTargets(), factoryNode, "IdentifierListNode");
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeMetaprogramTargetNodeWithUnions"),
                        factory.makeExpressionListNode(
                                liftTargets,
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeMethodDeclarationNode(MethodDeclarationNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftBody = 
                node.getUnionForBody().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForBody().getSpliceNode(), factoryNode, "BlockStatementListNode") :
                expressionizeNormalNodeUnion(node.getBody(), factoryNode, "BlockStatementListNode");
        ExpressionNode liftModifiers = 
                node.getUnionForModifiers().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForModifiers().getSpliceNode(), factoryNode, "MethodModifiersNode") :
                expressionizeNormalNodeUnion(node.getModifiers(), factoryNode, "MethodModifiersNode");
        ExpressionNode liftIdentifier = 
                node.getUnionForIdentifier().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForIdentifier().getSpliceNode(), factoryNode, "IdentifierNode") :
                expressionizeNormalNodeUnion(node.getIdentifier(), factoryNode, "IdentifierNode");
        ExpressionNode liftParameters = 
                node.getUnionForParameters().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForParameters().getSpliceNode(), factoryNode, "VariableListNode") :
                expressionizeNormalNodeUnion(node.getParameters(), factoryNode, "VariableListNode");
        ExpressionNode liftVarargParameter = 
                node.getUnionForVarargParameter().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForVarargParameter().getSpliceNode(), factoryNode, "VariableNode") :
                expressionizeNormalNodeUnion(node.getVarargParameter(), factoryNode, "VariableNode");
        ExpressionNode liftReturnType = 
                node.getUnionForReturnType().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForReturnType().getSpliceNode(), factoryNode, "TypeNode") :
                expressionizeNormalNodeUnion(node.getReturnType(), factoryNode, "TypeNode");
        ExpressionNode liftThrowTypes = 
                node.getUnionForThrowTypes().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForThrowTypes().getSpliceNode(), factoryNode, "UnparameterizedTypeListNode") :
                expressionizeNormalNodeUnion(node.getThrowTypes(), factoryNode, "UnparameterizedTypeListNode");
        ExpressionNode liftTypeParameters = 
                node.getUnionForTypeParameters().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForTypeParameters().getSpliceNode(), factoryNode, "TypeParameterListNode") :
                expressionizeNormalNodeUnion(node.getTypeParameters(), factoryNode, "TypeParameterListNode");
        ExpressionNode liftJavadoc = 
                node.getUnionForJavadoc().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForJavadoc().getSpliceNode(), factoryNode, "JavadocNode") :
                expressionizeNormalNodeUnion(node.getJavadoc(), factoryNode, "JavadocNode");
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeMethodDeclarationNodeWithUnions"),
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
                        factory.makeReferenceTypeListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeMethodInvocationNode(MethodInvocationNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftExpression = 
                node.getUnionForExpression().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForExpression().getSpliceNode(), factoryNode, "PrimaryExpressionNode") :
                expressionizeNormalNodeUnion(node.getExpression(), factoryNode, "PrimaryExpressionNode");
        ExpressionNode liftIdentifier = 
                node.getUnionForIdentifier().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForIdentifier().getSpliceNode(), factoryNode, "IdentifierNode") :
                expressionizeNormalNodeUnion(node.getIdentifier(), factoryNode, "IdentifierNode");
        ExpressionNode liftArguments = 
                node.getUnionForArguments().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForArguments().getSpliceNode(), factoryNode, "ExpressionListNode") :
                expressionizeNormalNodeUnion(node.getArguments(), factoryNode, "ExpressionListNode");
        ExpressionNode liftTypeArguments = 
                node.getUnionForTypeArguments().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForTypeArguments().getSpliceNode(), factoryNode, "ReferenceTypeListNode") :
                expressionizeNormalNodeUnion(node.getTypeArguments(), factoryNode, "ReferenceTypeListNode");
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeMethodInvocationNodeWithUnions"),
                        factory.makeExpressionListNode(
                                liftExpression,
                                liftIdentifier,
                                liftArguments,
                                liftTypeArguments,
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode());
        
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
                node.getUnionForMetaAnnotations().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForMetaAnnotations().getSpliceNode(), factoryNode, "MetaAnnotationListNode") :
                expressionizeNormalNodeUnion(node.getMetaAnnotations(), factoryNode, "MetaAnnotationListNode");
        ExpressionNode liftAnnotations = 
                node.getUnionForAnnotations().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForAnnotations().getSpliceNode(), factoryNode, "AnnotationListNode") :
                expressionizeNormalNodeUnion(node.getAnnotations(), factoryNode, "AnnotationListNode");
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeMethodModifiersNodeWithUnions"),
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
                        factory.makeReferenceTypeListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeNoOperationNode(NoOperationNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftMetaAnnotations = 
                node.getUnionForMetaAnnotations().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForMetaAnnotations().getSpliceNode(), factoryNode, "MetaAnnotationListNode") :
                expressionizeNormalNodeUnion(node.getMetaAnnotations(), factoryNode, "MetaAnnotationListNode");
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeNoOperationNodeWithUnions"),
                        factory.makeExpressionListNode(
                                liftMetaAnnotations,
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeNormalAnnotationNode(NormalAnnotationNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftArguments = 
                node.getUnionForArguments().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForArguments().getSpliceNode(), factoryNode, "AnnotationElementListNode") :
                expressionizeNormalNodeUnion(node.getArguments(), factoryNode, "AnnotationElementListNode");
        ExpressionNode liftAnnotationType = 
                node.getUnionForAnnotationType().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForAnnotationType().getSpliceNode(), factoryNode, "UnparameterizedTypeNode") :
                expressionizeNormalNodeUnion(node.getAnnotationType(), factoryNode, "UnparameterizedTypeNode");
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeNormalAnnotationNodeWithUnions"),
                        factory.makeExpressionListNode(
                                liftArguments,
                                liftAnnotationType,
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeNormalMetaAnnotationNode(NormalMetaAnnotationNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftArguments = 
                node.getUnionForArguments().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForArguments().getSpliceNode(), factoryNode, "MetaAnnotationElementListNode") :
                expressionizeNormalNodeUnion(node.getArguments(), factoryNode, "MetaAnnotationElementListNode");
        ExpressionNode liftAnnotationType = 
                node.getUnionForAnnotationType().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForAnnotationType().getSpliceNode(), factoryNode, "UnparameterizedTypeNode") :
                expressionizeNormalNodeUnion(node.getAnnotationType(), factoryNode, "UnparameterizedTypeNode");
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeNormalMetaAnnotationNodeWithUnions"),
                        factory.makeExpressionListNode(
                                liftArguments,
                                liftAnnotationType,
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode());
        
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
                factory.makeMethodInvocationNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeNullLiteralNode"),
                        factory.makeExpressionListNode(
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executePackageDeclarationNode(PackageDeclarationNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftName = 
                node.getUnionForName().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForName().getSpliceNode(), factoryNode, "NameNode") :
                expressionizeNormalNodeUnion(node.getName(), factoryNode, "NameNode");
        ExpressionNode liftMetaAnnotations = 
                node.getUnionForMetaAnnotations().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForMetaAnnotations().getSpliceNode(), factoryNode, "MetaAnnotationListNode") :
                expressionizeNormalNodeUnion(node.getMetaAnnotations(), factoryNode, "MetaAnnotationListNode");
        ExpressionNode liftAnnotations = 
                node.getUnionForAnnotations().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForAnnotations().getSpliceNode(), factoryNode, "AnnotationListNode") :
                expressionizeNormalNodeUnion(node.getAnnotations(), factoryNode, "AnnotationListNode");
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makePackageDeclarationNodeWithUnions"),
                        factory.makeExpressionListNode(
                                liftName,
                                liftMetaAnnotations,
                                liftAnnotations,
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executePackageNode(PackageNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftName = 
                node.getUnionForName().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForName().getSpliceNode(), factoryNode, "IdentifierNode") :
                expressionizeNormalNodeUnion(node.getName(), factoryNode, "IdentifierNode");
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makePackageNodeWithUnions"),
                        factory.makeExpressionListNode(
                                liftName,
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeParameterizedTypeNode(ParameterizedTypeNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftBaseType = 
                node.getUnionForBaseType().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForBaseType().getSpliceNode(), factoryNode, "UnparameterizedTypeNode") :
                expressionizeNormalNodeUnion(node.getBaseType(), factoryNode, "UnparameterizedTypeNode");
        ExpressionNode liftTypeArguments = 
                node.getUnionForTypeArguments().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForTypeArguments().getSpliceNode(), factoryNode, "TypeArgumentListNode") :
                expressionizeNormalNodeUnion(node.getTypeArguments(), factoryNode, "TypeArgumentListNode");
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeParameterizedTypeNodeWithUnions"),
                        factory.makeExpressionListNode(
                                liftBaseType,
                                liftTypeArguments,
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeParameterizedTypeSelectNode(ParameterizedTypeSelectNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftBase = 
                node.getUnionForBase().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForBase().getSpliceNode(), factoryNode, "ParameterizedTypeNode") :
                expressionizeNormalNodeUnion(node.getBase(), factoryNode, "ParameterizedTypeNode");
        ExpressionNode liftSelect = 
                node.getUnionForSelect().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForSelect().getSpliceNode(), factoryNode, "DeclaredTypeNode") :
                expressionizeNormalNodeUnion(node.getSelect(), factoryNode, "DeclaredTypeNode");
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeParameterizedTypeSelectNodeWithUnions"),
                        factory.makeExpressionListNode(
                                liftBase,
                                liftSelect,
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeParenthesizedExpressionNode(ParenthesizedExpressionNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftExpression = 
                node.getUnionForExpression().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForExpression().getSpliceNode(), factoryNode, "ExpressionNode") :
                expressionizeNormalNodeUnion(node.getExpression(), factoryNode, "ExpressionNode");
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeParenthesizedExpressionNodeWithUnions"),
                        factory.makeExpressionListNode(
                                liftExpression,
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode());
        
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
                factory.makeMethodInvocationNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makePrimitiveTypeNode"),
                        factory.makeExpressionListNode(
                                expressionizePrimitiveType(liftPrimitiveTypeValue),
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeQualifiedClassInstantiationNode(QualifiedClassInstantiationNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftEnclosingExpression = 
                node.getUnionForEnclosingExpression().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForEnclosingExpression().getSpliceNode(), factoryNode, "ExpressionNode") :
                expressionizeNormalNodeUnion(node.getEnclosingExpression(), factoryNode, "ExpressionNode");
        ExpressionNode liftIdentifier = 
                node.getUnionForIdentifier().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForIdentifier().getSpliceNode(), factoryNode, "IdentifierNode") :
                expressionizeNormalNodeUnion(node.getIdentifier(), factoryNode, "IdentifierNode");
        ExpressionNode liftTypeArguments = 
                node.getUnionForTypeArguments().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForTypeArguments().getSpliceNode(), factoryNode, "TypeArgumentListNode") :
                expressionizeNormalNodeUnion(node.getTypeArguments(), factoryNode, "TypeArgumentListNode");
        ExpressionNode liftConstructorTypeArguments = 
                node.getUnionForConstructorTypeArguments().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForConstructorTypeArguments().getSpliceNode(), factoryNode, "TypeArgumentListNode") :
                expressionizeNormalNodeUnion(node.getConstructorTypeArguments(), factoryNode, "TypeArgumentListNode");
        ExpressionNode liftArguments = 
                node.getUnionForArguments().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForArguments().getSpliceNode(), factoryNode, "ExpressionListNode") :
                expressionizeNormalNodeUnion(node.getArguments(), factoryNode, "ExpressionListNode");
        ExpressionNode liftBody = 
                node.getUnionForBody().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForBody().getSpliceNode(), factoryNode, "AnonymousClassBodyNode") :
                expressionizeNormalNodeUnion(node.getBody(), factoryNode, "AnonymousClassBodyNode");
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeQualifiedClassInstantiationNodeWithUnions"),
                        factory.makeExpressionListNode(
                                liftEnclosingExpression,
                                liftIdentifier,
                                liftTypeArguments,
                                liftConstructorTypeArguments,
                                liftArguments,
                                liftBody,
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeQualifiedNameNode(QualifiedNameNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftBase = 
                node.getUnionForBase().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForBase().getSpliceNode(), factoryNode, "NameNode") :
                expressionizeNormalNodeUnion(node.getBase(), factoryNode, "NameNode");
        ExpressionNode liftIdentifier = 
                node.getUnionForIdentifier().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForIdentifier().getSpliceNode(), factoryNode, "IdentifierNode") :
                expressionizeNormalNodeUnion(node.getIdentifier(), factoryNode, "IdentifierNode");
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeQualifiedNameNodeWithUnions"),
                        factory.makeExpressionListNode(
                                liftBase,
                                liftIdentifier,
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeRawCodeLiteralNode(RawCodeLiteralNode node, ExpressionNode factoryNode)
    {
        BsjRawCodeLiteralPayload liftValueValue = 
                node.getValue();
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeRawCodeLiteralNode"),
                        factory.makeExpressionListNode(
                                expressionizeBsjRawCodeLiteralPayload(liftValueValue),
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeReferenceTypeListNode(ReferenceTypeListNode node, ExpressionNode factoryNode)
    {
        List<ExpressionNode> liftChildrenList = new ArrayList<ExpressionNode>();
        for (NodeUnion<? extends ReferenceTypeNode> listval : node.getUnionForChildren())
        {
            liftChildrenList.add(
                    listval != null ? 
                            (listval.getType() == NodeUnion.Type.SPLICE ? 
                                    expressionizeSpliceNodeUnion(listval.getSpliceNode(), factoryNode, "ReferenceTypeNode") :
                            expressionizeNormalNodeUnion(listval.getNormalNode(), factoryNode, "ReferenceTypeNode"))
                            : factory.makeNullLiteralNode());
        }
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeReferenceTypeListNodeWithUnions"),
                        factory.makeExpressionListNode(
                                factory.makeMethodInvocationNode(
                                        factory.makeVariableAccessNode(
                                                factory.makeVariableAccessNode(
                                                        factory.makeVariableAccessNode(
                                                                factory.makeVariableAccessNode(
                                                                        factory.makeVariableAccessNode(
                                                                                factory.makeVariableAccessNode(
                                                                                        factory.makeVariableAccessNode(
                                                                                                factory.makeVariableAccessNode(
                                                                                                        factory.makeIdentifierNode("edu")),
                                                                                                factory.makeIdentifierNode("jhu")),
                                                                                        factory.makeIdentifierNode("cs")),
                                                                                factory.makeIdentifierNode("bsj")),
                                                                        factory.makeIdentifierNode("compiler")),
                                                                factory.makeIdentifierNode("impl")),
                                                        factory.makeIdentifierNode("utils")),
                                                factory.makeIdentifierNode("CollectionUtilities")),
                                        factory.makeIdentifierNode("listOf"),
                                        factory.makeExpressionListNode(liftChildrenList),
                                        factory.makeReferenceTypeListNode(
                                                factory.makeParameterizedTypeNode(
                                                        factory.makeUnparameterizedTypeNode(
                                                                factory.makeSimpleNameNode(
                                                                        factory.makeIdentifierNode("NodeUnion"))),
                                                        factory.makeTypeArgumentListNode(
                                                                factory.makeWildcardTypeNode(
                                                                        factory.makeUnparameterizedTypeNode(
                                                                                factory.makeSimpleNameNode(
                                                                                        factory.makeIdentifierNode("ReferenceTypeNode"))),
                                                                        true))))),
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeReturnNode(ReturnNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftExpression = 
                node.getUnionForExpression().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForExpression().getSpliceNode(), factoryNode, "ExpressionNode") :
                expressionizeNormalNodeUnion(node.getExpression(), factoryNode, "ExpressionNode");
        ExpressionNode liftMetaAnnotations = 
                node.getUnionForMetaAnnotations().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForMetaAnnotations().getSpliceNode(), factoryNode, "MetaAnnotationListNode") :
                expressionizeNormalNodeUnion(node.getMetaAnnotations(), factoryNode, "MetaAnnotationListNode");
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeReturnNodeWithUnions"),
                        factory.makeExpressionListNode(
                                liftExpression,
                                liftMetaAnnotations,
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeSimpleNameNode(SimpleNameNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftIdentifier = 
                node.getUnionForIdentifier().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForIdentifier().getSpliceNode(), factoryNode, "IdentifierNode") :
                expressionizeNormalNodeUnion(node.getIdentifier(), factoryNode, "IdentifierNode");
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeSimpleNameNodeWithUnions"),
                        factory.makeExpressionListNode(
                                liftIdentifier,
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeSingleElementAnnotationNode(SingleElementAnnotationNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftValue = 
                node.getUnionForValue().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForValue().getSpliceNode(), factoryNode, "AnnotationValueNode") :
                expressionizeNormalNodeUnion(node.getValue(), factoryNode, "AnnotationValueNode");
        ExpressionNode liftAnnotationType = 
                node.getUnionForAnnotationType().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForAnnotationType().getSpliceNode(), factoryNode, "UnparameterizedTypeNode") :
                expressionizeNormalNodeUnion(node.getAnnotationType(), factoryNode, "UnparameterizedTypeNode");
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeSingleElementAnnotationNodeWithUnions"),
                        factory.makeExpressionListNode(
                                liftValue,
                                liftAnnotationType,
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeSingleElementMetaAnnotationNode(SingleElementMetaAnnotationNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftValue = 
                node.getUnionForValue().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForValue().getSpliceNode(), factoryNode, "MetaAnnotationValueNode") :
                expressionizeNormalNodeUnion(node.getValue(), factoryNode, "MetaAnnotationValueNode");
        ExpressionNode liftAnnotationType = 
                node.getUnionForAnnotationType().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForAnnotationType().getSpliceNode(), factoryNode, "UnparameterizedTypeNode") :
                expressionizeNormalNodeUnion(node.getAnnotationType(), factoryNode, "UnparameterizedTypeNode");
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeSingleElementMetaAnnotationNodeWithUnions"),
                        factory.makeExpressionListNode(
                                liftValue,
                                liftAnnotationType,
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeSingleStaticImportNode(SingleStaticImportNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftName = 
                node.getUnionForName().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForName().getSpliceNode(), factoryNode, "NameNode") :
                expressionizeNormalNodeUnion(node.getName(), factoryNode, "NameNode");
        ExpressionNode liftIdentifier = 
                node.getUnionForIdentifier().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForIdentifier().getSpliceNode(), factoryNode, "IdentifierNode") :
                expressionizeNormalNodeUnion(node.getIdentifier(), factoryNode, "IdentifierNode");
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeSingleStaticImportNodeWithUnions"),
                        factory.makeExpressionListNode(
                                liftName,
                                liftIdentifier,
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeSpliceNode(SpliceNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftSpliceExpression = 
                node.getSpliceExpression() != null ?
                        node.getSpliceExpression().executeOperation(this,factoryNode) :
                        factory.makeNullLiteralNode();
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeSpliceNode"),
                        factory.makeExpressionListNode(
                                liftSpliceExpression,
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeStatementExpressionListNode(StatementExpressionListNode node, ExpressionNode factoryNode)
    {
        List<ExpressionNode> liftChildrenList = new ArrayList<ExpressionNode>();
        for (NodeUnion<? extends StatementExpressionNode> listval : node.getUnionForChildren())
        {
            liftChildrenList.add(
                    listval != null ? 
                            (listval.getType() == NodeUnion.Type.SPLICE ? 
                                    expressionizeSpliceNodeUnion(listval.getSpliceNode(), factoryNode, "StatementExpressionNode") :
                            expressionizeNormalNodeUnion(listval.getNormalNode(), factoryNode, "StatementExpressionNode"))
                            : factory.makeNullLiteralNode());
        }
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeStatementExpressionListNodeWithUnions"),
                        factory.makeExpressionListNode(
                                factory.makeMethodInvocationNode(
                                        factory.makeVariableAccessNode(
                                                factory.makeVariableAccessNode(
                                                        factory.makeVariableAccessNode(
                                                                factory.makeVariableAccessNode(
                                                                        factory.makeVariableAccessNode(
                                                                                factory.makeVariableAccessNode(
                                                                                        factory.makeVariableAccessNode(
                                                                                                factory.makeVariableAccessNode(
                                                                                                        factory.makeIdentifierNode("edu")),
                                                                                                factory.makeIdentifierNode("jhu")),
                                                                                        factory.makeIdentifierNode("cs")),
                                                                                factory.makeIdentifierNode("bsj")),
                                                                        factory.makeIdentifierNode("compiler")),
                                                                factory.makeIdentifierNode("impl")),
                                                        factory.makeIdentifierNode("utils")),
                                                factory.makeIdentifierNode("CollectionUtilities")),
                                        factory.makeIdentifierNode("listOf"),
                                        factory.makeExpressionListNode(liftChildrenList),
                                        factory.makeReferenceTypeListNode(
                                                factory.makeParameterizedTypeNode(
                                                        factory.makeUnparameterizedTypeNode(
                                                                factory.makeSimpleNameNode(
                                                                        factory.makeIdentifierNode("NodeUnion"))),
                                                        factory.makeTypeArgumentListNode(
                                                                factory.makeWildcardTypeNode(
                                                                        factory.makeUnparameterizedTypeNode(
                                                                                factory.makeSimpleNameNode(
                                                                                        factory.makeIdentifierNode("StatementExpressionNode"))),
                                                                        true))))),
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeStaticImportOnDemandNode(StaticImportOnDemandNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftName = 
                node.getUnionForName().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForName().getSpliceNode(), factoryNode, "NameNode") :
                expressionizeNormalNodeUnion(node.getName(), factoryNode, "NameNode");
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeStaticImportOnDemandNodeWithUnions"),
                        factory.makeExpressionListNode(
                                liftName,
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode());
        
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
                factory.makeMethodInvocationNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeStringLiteralNode"),
                        factory.makeExpressionListNode(
                                expressionizeString(liftValueValue),
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeSuperFieldAccessNode(SuperFieldAccessNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftType = 
                node.getUnionForType().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForType().getSpliceNode(), factoryNode, "UnparameterizedTypeNode") :
                expressionizeNormalNodeUnion(node.getType(), factoryNode, "UnparameterizedTypeNode");
        ExpressionNode liftIdentifier = 
                node.getUnionForIdentifier().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForIdentifier().getSpliceNode(), factoryNode, "IdentifierNode") :
                expressionizeNormalNodeUnion(node.getIdentifier(), factoryNode, "IdentifierNode");
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeSuperFieldAccessNodeWithUnions"),
                        factory.makeExpressionListNode(
                                liftType,
                                liftIdentifier,
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeSuperMethodInvocationNode(SuperMethodInvocationNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftType = 
                node.getUnionForType().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForType().getSpliceNode(), factoryNode, "UnparameterizedTypeNode") :
                expressionizeNormalNodeUnion(node.getType(), factoryNode, "UnparameterizedTypeNode");
        ExpressionNode liftIdentifier = 
                node.getUnionForIdentifier().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForIdentifier().getSpliceNode(), factoryNode, "IdentifierNode") :
                expressionizeNormalNodeUnion(node.getIdentifier(), factoryNode, "IdentifierNode");
        ExpressionNode liftArguments = 
                node.getUnionForArguments().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForArguments().getSpliceNode(), factoryNode, "ExpressionListNode") :
                expressionizeNormalNodeUnion(node.getArguments(), factoryNode, "ExpressionListNode");
        ExpressionNode liftTypeArguments = 
                node.getUnionForTypeArguments().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForTypeArguments().getSpliceNode(), factoryNode, "ReferenceTypeListNode") :
                expressionizeNormalNodeUnion(node.getTypeArguments(), factoryNode, "ReferenceTypeListNode");
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeSuperMethodInvocationNodeWithUnions"),
                        factory.makeExpressionListNode(
                                liftType,
                                liftIdentifier,
                                liftArguments,
                                liftTypeArguments,
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeSuperclassConstructorInvocationNode(SuperclassConstructorInvocationNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftQualifyingExpression = 
                node.getUnionForQualifyingExpression().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForQualifyingExpression().getSpliceNode(), factoryNode, "PrimaryExpressionNode") :
                expressionizeNormalNodeUnion(node.getQualifyingExpression(), factoryNode, "PrimaryExpressionNode");
        ExpressionNode liftArguments = 
                node.getUnionForArguments().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForArguments().getSpliceNode(), factoryNode, "ExpressionListNode") :
                expressionizeNormalNodeUnion(node.getArguments(), factoryNode, "ExpressionListNode");
        ExpressionNode liftTypeArguments = 
                node.getUnionForTypeArguments().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForTypeArguments().getSpliceNode(), factoryNode, "ReferenceTypeListNode") :
                expressionizeNormalNodeUnion(node.getTypeArguments(), factoryNode, "ReferenceTypeListNode");
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeSuperclassConstructorInvocationNodeWithUnions"),
                        factory.makeExpressionListNode(
                                liftQualifyingExpression,
                                liftArguments,
                                liftTypeArguments,
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeSwitchNode(SwitchNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftExpression = 
                node.getUnionForExpression().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForExpression().getSpliceNode(), factoryNode, "ExpressionNode") :
                expressionizeNormalNodeUnion(node.getExpression(), factoryNode, "ExpressionNode");
        ExpressionNode liftCases = 
                node.getUnionForCases().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForCases().getSpliceNode(), factoryNode, "CaseListNode") :
                expressionizeNormalNodeUnion(node.getCases(), factoryNode, "CaseListNode");
        ExpressionNode liftMetaAnnotations = 
                node.getUnionForMetaAnnotations().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForMetaAnnotations().getSpliceNode(), factoryNode, "MetaAnnotationListNode") :
                expressionizeNormalNodeUnion(node.getMetaAnnotations(), factoryNode, "MetaAnnotationListNode");
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeSwitchNodeWithUnions"),
                        factory.makeExpressionListNode(
                                liftExpression,
                                liftCases,
                                liftMetaAnnotations,
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeSynchronizedNode(SynchronizedNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftExpression = 
                node.getUnionForExpression().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForExpression().getSpliceNode(), factoryNode, "ExpressionNode") :
                expressionizeNormalNodeUnion(node.getExpression(), factoryNode, "ExpressionNode");
        ExpressionNode liftBody = 
                node.getUnionForBody().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForBody().getSpliceNode(), factoryNode, "BlockStatementListNode") :
                expressionizeNormalNodeUnion(node.getBody(), factoryNode, "BlockStatementListNode");
        ExpressionNode liftMetaAnnotations = 
                node.getUnionForMetaAnnotations().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForMetaAnnotations().getSpliceNode(), factoryNode, "MetaAnnotationListNode") :
                expressionizeNormalNodeUnion(node.getMetaAnnotations(), factoryNode, "MetaAnnotationListNode");
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeSynchronizedNodeWithUnions"),
                        factory.makeExpressionListNode(
                                liftExpression,
                                liftBody,
                                liftMetaAnnotations,
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeThisNode(ThisNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftType = 
                node.getUnionForType().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForType().getSpliceNode(), factoryNode, "UnparameterizedTypeNode") :
                expressionizeNormalNodeUnion(node.getType(), factoryNode, "UnparameterizedTypeNode");
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeThisNodeWithUnions"),
                        factory.makeExpressionListNode(
                                liftType,
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeThrowNode(ThrowNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftExpression = 
                node.getUnionForExpression().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForExpression().getSpliceNode(), factoryNode, "ExpressionNode") :
                expressionizeNormalNodeUnion(node.getExpression(), factoryNode, "ExpressionNode");
        ExpressionNode liftMetaAnnotations = 
                node.getUnionForMetaAnnotations().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForMetaAnnotations().getSpliceNode(), factoryNode, "MetaAnnotationListNode") :
                expressionizeNormalNodeUnion(node.getMetaAnnotations(), factoryNode, "MetaAnnotationListNode");
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeThrowNodeWithUnions"),
                        factory.makeExpressionListNode(
                                liftExpression,
                                liftMetaAnnotations,
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeTryNode(TryNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftBody = 
                node.getUnionForBody().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForBody().getSpliceNode(), factoryNode, "BlockStatementListNode") :
                expressionizeNormalNodeUnion(node.getBody(), factoryNode, "BlockStatementListNode");
        ExpressionNode liftCatches = 
                node.getUnionForCatches().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForCatches().getSpliceNode(), factoryNode, "CatchListNode") :
                expressionizeNormalNodeUnion(node.getCatches(), factoryNode, "CatchListNode");
        ExpressionNode liftFinallyBlock = 
                node.getUnionForFinallyBlock().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForFinallyBlock().getSpliceNode(), factoryNode, "BlockStatementListNode") :
                expressionizeNormalNodeUnion(node.getFinallyBlock(), factoryNode, "BlockStatementListNode");
        ExpressionNode liftMetaAnnotations = 
                node.getUnionForMetaAnnotations().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForMetaAnnotations().getSpliceNode(), factoryNode, "MetaAnnotationListNode") :
                expressionizeNormalNodeUnion(node.getMetaAnnotations(), factoryNode, "MetaAnnotationListNode");
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeTryNodeWithUnions"),
                        factory.makeExpressionListNode(
                                liftBody,
                                liftCatches,
                                liftFinallyBlock,
                                liftMetaAnnotations,
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeTypeArgumentListNode(TypeArgumentListNode node, ExpressionNode factoryNode)
    {
        List<ExpressionNode> liftChildrenList = new ArrayList<ExpressionNode>();
        for (NodeUnion<? extends TypeArgumentNode> listval : node.getUnionForChildren())
        {
            liftChildrenList.add(
                    listval != null ? 
                            (listval.getType() == NodeUnion.Type.SPLICE ? 
                                    expressionizeSpliceNodeUnion(listval.getSpliceNode(), factoryNode, "TypeArgumentNode") :
                            expressionizeNormalNodeUnion(listval.getNormalNode(), factoryNode, "TypeArgumentNode"))
                            : factory.makeNullLiteralNode());
        }
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeTypeArgumentListNodeWithUnions"),
                        factory.makeExpressionListNode(
                                factory.makeMethodInvocationNode(
                                        factory.makeVariableAccessNode(
                                                factory.makeVariableAccessNode(
                                                        factory.makeVariableAccessNode(
                                                                factory.makeVariableAccessNode(
                                                                        factory.makeVariableAccessNode(
                                                                                factory.makeVariableAccessNode(
                                                                                        factory.makeVariableAccessNode(
                                                                                                factory.makeVariableAccessNode(
                                                                                                        factory.makeIdentifierNode("edu")),
                                                                                                factory.makeIdentifierNode("jhu")),
                                                                                        factory.makeIdentifierNode("cs")),
                                                                                factory.makeIdentifierNode("bsj")),
                                                                        factory.makeIdentifierNode("compiler")),
                                                                factory.makeIdentifierNode("impl")),
                                                        factory.makeIdentifierNode("utils")),
                                                factory.makeIdentifierNode("CollectionUtilities")),
                                        factory.makeIdentifierNode("listOf"),
                                        factory.makeExpressionListNode(liftChildrenList),
                                        factory.makeReferenceTypeListNode(
                                                factory.makeParameterizedTypeNode(
                                                        factory.makeUnparameterizedTypeNode(
                                                                factory.makeSimpleNameNode(
                                                                        factory.makeIdentifierNode("NodeUnion"))),
                                                        factory.makeTypeArgumentListNode(
                                                                factory.makeWildcardTypeNode(
                                                                        factory.makeUnparameterizedTypeNode(
                                                                                factory.makeSimpleNameNode(
                                                                                        factory.makeIdentifierNode("TypeArgumentNode"))),
                                                                        true))))),
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeTypeCastNode(TypeCastNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftExpression = 
                node.getUnionForExpression().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForExpression().getSpliceNode(), factoryNode, "ExpressionNode") :
                expressionizeNormalNodeUnion(node.getExpression(), factoryNode, "ExpressionNode");
        ExpressionNode liftType = 
                node.getUnionForType().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForType().getSpliceNode(), factoryNode, "TypeNode") :
                expressionizeNormalNodeUnion(node.getType(), factoryNode, "TypeNode");
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeTypeCastNodeWithUnions"),
                        factory.makeExpressionListNode(
                                liftExpression,
                                liftType,
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeTypeDeclarationListNode(TypeDeclarationListNode node, ExpressionNode factoryNode)
    {
        List<ExpressionNode> liftChildrenList = new ArrayList<ExpressionNode>();
        for (NodeUnion<? extends TypeDeclarationNode> listval : node.getUnionForChildren())
        {
            liftChildrenList.add(
                    listval != null ? 
                            (listval.getType() == NodeUnion.Type.SPLICE ? 
                                    expressionizeSpliceNodeUnion(listval.getSpliceNode(), factoryNode, "TypeDeclarationNode") :
                            expressionizeNormalNodeUnion(listval.getNormalNode(), factoryNode, "TypeDeclarationNode"))
                            : factory.makeNullLiteralNode());
        }
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeTypeDeclarationListNodeWithUnions"),
                        factory.makeExpressionListNode(
                                factory.makeMethodInvocationNode(
                                        factory.makeVariableAccessNode(
                                                factory.makeVariableAccessNode(
                                                        factory.makeVariableAccessNode(
                                                                factory.makeVariableAccessNode(
                                                                        factory.makeVariableAccessNode(
                                                                                factory.makeVariableAccessNode(
                                                                                        factory.makeVariableAccessNode(
                                                                                                factory.makeVariableAccessNode(
                                                                                                        factory.makeIdentifierNode("edu")),
                                                                                                factory.makeIdentifierNode("jhu")),
                                                                                        factory.makeIdentifierNode("cs")),
                                                                                factory.makeIdentifierNode("bsj")),
                                                                        factory.makeIdentifierNode("compiler")),
                                                                factory.makeIdentifierNode("impl")),
                                                        factory.makeIdentifierNode("utils")),
                                                factory.makeIdentifierNode("CollectionUtilities")),
                                        factory.makeIdentifierNode("listOf"),
                                        factory.makeExpressionListNode(liftChildrenList),
                                        factory.makeReferenceTypeListNode(
                                                factory.makeParameterizedTypeNode(
                                                        factory.makeUnparameterizedTypeNode(
                                                                factory.makeSimpleNameNode(
                                                                        factory.makeIdentifierNode("NodeUnion"))),
                                                        factory.makeTypeArgumentListNode(
                                                                factory.makeWildcardTypeNode(
                                                                        factory.makeUnparameterizedTypeNode(
                                                                                factory.makeSimpleNameNode(
                                                                                        factory.makeIdentifierNode("TypeDeclarationNode"))),
                                                                        true))))),
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeTypeDeclarationMetaprogramAnchorNode(TypeDeclarationMetaprogramAnchorNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftMetaprogram = 
                node.getUnionForMetaprogram().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForMetaprogram().getSpliceNode(), factoryNode, "MetaprogramNode") :
                expressionizeNormalNodeUnion(node.getMetaprogram(), factoryNode, "MetaprogramNode");
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeTypeDeclarationMetaprogramAnchorNodeWithUnions"),
                        factory.makeExpressionListNode(
                                liftMetaprogram,
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeTypeParameterListNode(TypeParameterListNode node, ExpressionNode factoryNode)
    {
        List<ExpressionNode> liftChildrenList = new ArrayList<ExpressionNode>();
        for (NodeUnion<? extends TypeParameterNode> listval : node.getUnionForChildren())
        {
            liftChildrenList.add(
                    listval != null ? 
                            (listval.getType() == NodeUnion.Type.SPLICE ? 
                                    expressionizeSpliceNodeUnion(listval.getSpliceNode(), factoryNode, "TypeParameterNode") :
                            expressionizeNormalNodeUnion(listval.getNormalNode(), factoryNode, "TypeParameterNode"))
                            : factory.makeNullLiteralNode());
        }
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeTypeParameterListNodeWithUnions"),
                        factory.makeExpressionListNode(
                                factory.makeMethodInvocationNode(
                                        factory.makeVariableAccessNode(
                                                factory.makeVariableAccessNode(
                                                        factory.makeVariableAccessNode(
                                                                factory.makeVariableAccessNode(
                                                                        factory.makeVariableAccessNode(
                                                                                factory.makeVariableAccessNode(
                                                                                        factory.makeVariableAccessNode(
                                                                                                factory.makeVariableAccessNode(
                                                                                                        factory.makeIdentifierNode("edu")),
                                                                                                factory.makeIdentifierNode("jhu")),
                                                                                        factory.makeIdentifierNode("cs")),
                                                                                factory.makeIdentifierNode("bsj")),
                                                                        factory.makeIdentifierNode("compiler")),
                                                                factory.makeIdentifierNode("impl")),
                                                        factory.makeIdentifierNode("utils")),
                                                factory.makeIdentifierNode("CollectionUtilities")),
                                        factory.makeIdentifierNode("listOf"),
                                        factory.makeExpressionListNode(liftChildrenList),
                                        factory.makeReferenceTypeListNode(
                                                factory.makeParameterizedTypeNode(
                                                        factory.makeUnparameterizedTypeNode(
                                                                factory.makeSimpleNameNode(
                                                                        factory.makeIdentifierNode("NodeUnion"))),
                                                        factory.makeTypeArgumentListNode(
                                                                factory.makeWildcardTypeNode(
                                                                        factory.makeUnparameterizedTypeNode(
                                                                                factory.makeSimpleNameNode(
                                                                                        factory.makeIdentifierNode("TypeParameterNode"))),
                                                                        true))))),
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeTypeParameterNode(TypeParameterNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftIdentifier = 
                node.getUnionForIdentifier().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForIdentifier().getSpliceNode(), factoryNode, "IdentifierNode") :
                expressionizeNormalNodeUnion(node.getIdentifier(), factoryNode, "IdentifierNode");
        ExpressionNode liftBounds = 
                node.getUnionForBounds().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForBounds().getSpliceNode(), factoryNode, "DeclaredTypeListNode") :
                expressionizeNormalNodeUnion(node.getBounds(), factoryNode, "DeclaredTypeListNode");
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeTypeParameterNodeWithUnions"),
                        factory.makeExpressionListNode(
                                liftIdentifier,
                                liftBounds,
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeUnaryExpressionNode(UnaryExpressionNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftExpression = 
                node.getUnionForExpression().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForExpression().getSpliceNode(), factoryNode, "ExpressionNode") :
                expressionizeNormalNodeUnion(node.getExpression(), factoryNode, "ExpressionNode");
        UnaryOperator liftOperatorValue = 
                node.getOperator();
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeUnaryExpressionNodeWithUnions"),
                        factory.makeExpressionListNode(
                                liftExpression,
                                expressionizeUnaryOperator(liftOperatorValue),
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeUnaryStatementExpressionNode(UnaryStatementExpressionNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftExpression = 
                node.getUnionForExpression().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForExpression().getSpliceNode(), factoryNode, "ExpressionNode") :
                expressionizeNormalNodeUnion(node.getExpression(), factoryNode, "ExpressionNode");
        UnaryStatementOperator liftOperatorValue = 
                node.getOperator();
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeUnaryStatementExpressionNodeWithUnions"),
                        factory.makeExpressionListNode(
                                liftExpression,
                                expressionizeUnaryStatementOperator(liftOperatorValue),
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeUnparameterizedTypeListNode(UnparameterizedTypeListNode node, ExpressionNode factoryNode)
    {
        List<ExpressionNode> liftChildrenList = new ArrayList<ExpressionNode>();
        for (NodeUnion<? extends UnparameterizedTypeNode> listval : node.getUnionForChildren())
        {
            liftChildrenList.add(
                    listval != null ? 
                            (listval.getType() == NodeUnion.Type.SPLICE ? 
                                    expressionizeSpliceNodeUnion(listval.getSpliceNode(), factoryNode, "UnparameterizedTypeNode") :
                            expressionizeNormalNodeUnion(listval.getNormalNode(), factoryNode, "UnparameterizedTypeNode"))
                            : factory.makeNullLiteralNode());
        }
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeUnparameterizedTypeListNodeWithUnions"),
                        factory.makeExpressionListNode(
                                factory.makeMethodInvocationNode(
                                        factory.makeVariableAccessNode(
                                                factory.makeVariableAccessNode(
                                                        factory.makeVariableAccessNode(
                                                                factory.makeVariableAccessNode(
                                                                        factory.makeVariableAccessNode(
                                                                                factory.makeVariableAccessNode(
                                                                                        factory.makeVariableAccessNode(
                                                                                                factory.makeVariableAccessNode(
                                                                                                        factory.makeIdentifierNode("edu")),
                                                                                                factory.makeIdentifierNode("jhu")),
                                                                                        factory.makeIdentifierNode("cs")),
                                                                                factory.makeIdentifierNode("bsj")),
                                                                        factory.makeIdentifierNode("compiler")),
                                                                factory.makeIdentifierNode("impl")),
                                                        factory.makeIdentifierNode("utils")),
                                                factory.makeIdentifierNode("CollectionUtilities")),
                                        factory.makeIdentifierNode("listOf"),
                                        factory.makeExpressionListNode(liftChildrenList),
                                        factory.makeReferenceTypeListNode(
                                                factory.makeParameterizedTypeNode(
                                                        factory.makeUnparameterizedTypeNode(
                                                                factory.makeSimpleNameNode(
                                                                        factory.makeIdentifierNode("NodeUnion"))),
                                                        factory.makeTypeArgumentListNode(
                                                                factory.makeWildcardTypeNode(
                                                                        factory.makeUnparameterizedTypeNode(
                                                                                factory.makeSimpleNameNode(
                                                                                        factory.makeIdentifierNode("UnparameterizedTypeNode"))),
                                                                        true))))),
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeUnparameterizedTypeNode(UnparameterizedTypeNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftName = 
                node.getUnionForName().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForName().getSpliceNode(), factoryNode, "NameNode") :
                expressionizeNormalNodeUnion(node.getName(), factoryNode, "NameNode");
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeUnparameterizedTypeNodeWithUnions"),
                        factory.makeExpressionListNode(
                                liftName,
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeUnqualifiedClassInstantiationNode(UnqualifiedClassInstantiationNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftType = 
                node.getUnionForType().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForType().getSpliceNode(), factoryNode, "DeclaredTypeNode") :
                expressionizeNormalNodeUnion(node.getType(), factoryNode, "DeclaredTypeNode");
        ExpressionNode liftConstructorTypeArguments = 
                node.getUnionForConstructorTypeArguments().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForConstructorTypeArguments().getSpliceNode(), factoryNode, "TypeArgumentListNode") :
                expressionizeNormalNodeUnion(node.getConstructorTypeArguments(), factoryNode, "TypeArgumentListNode");
        ExpressionNode liftArguments = 
                node.getUnionForArguments().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForArguments().getSpliceNode(), factoryNode, "ExpressionListNode") :
                expressionizeNormalNodeUnion(node.getArguments(), factoryNode, "ExpressionListNode");
        ExpressionNode liftBody = 
                node.getUnionForBody().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForBody().getSpliceNode(), factoryNode, "AnonymousClassBodyNode") :
                expressionizeNormalNodeUnion(node.getBody(), factoryNode, "AnonymousClassBodyNode");
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeUnqualifiedClassInstantiationNodeWithUnions"),
                        factory.makeExpressionListNode(
                                liftType,
                                liftConstructorTypeArguments,
                                liftArguments,
                                liftBody,
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeVariableAccessNode(VariableAccessNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftExpression = 
                node.getUnionForExpression().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForExpression().getSpliceNode(), factoryNode, "PrimaryExpressionNode") :
                expressionizeNormalNodeUnion(node.getExpression(), factoryNode, "PrimaryExpressionNode");
        ExpressionNode liftIdentifier = 
                node.getUnionForIdentifier().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForIdentifier().getSpliceNode(), factoryNode, "IdentifierNode") :
                expressionizeNormalNodeUnion(node.getIdentifier(), factoryNode, "IdentifierNode");
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeVariableAccessNodeWithUnions"),
                        factory.makeExpressionListNode(
                                liftExpression,
                                liftIdentifier,
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeVariableDeclaratorListNode(VariableDeclaratorListNode node, ExpressionNode factoryNode)
    {
        List<ExpressionNode> liftChildrenList = new ArrayList<ExpressionNode>();
        for (NodeUnion<? extends VariableDeclaratorNode> listval : node.getUnionForChildren())
        {
            liftChildrenList.add(
                    listval != null ? 
                            (listval.getType() == NodeUnion.Type.SPLICE ? 
                                    expressionizeSpliceNodeUnion(listval.getSpliceNode(), factoryNode, "VariableDeclaratorNode") :
                            expressionizeNormalNodeUnion(listval.getNormalNode(), factoryNode, "VariableDeclaratorNode"))
                            : factory.makeNullLiteralNode());
        }
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeVariableDeclaratorListNodeWithUnions"),
                        factory.makeExpressionListNode(
                                factory.makeMethodInvocationNode(
                                        factory.makeVariableAccessNode(
                                                factory.makeVariableAccessNode(
                                                        factory.makeVariableAccessNode(
                                                                factory.makeVariableAccessNode(
                                                                        factory.makeVariableAccessNode(
                                                                                factory.makeVariableAccessNode(
                                                                                        factory.makeVariableAccessNode(
                                                                                                factory.makeVariableAccessNode(
                                                                                                        factory.makeIdentifierNode("edu")),
                                                                                                factory.makeIdentifierNode("jhu")),
                                                                                        factory.makeIdentifierNode("cs")),
                                                                                factory.makeIdentifierNode("bsj")),
                                                                        factory.makeIdentifierNode("compiler")),
                                                                factory.makeIdentifierNode("impl")),
                                                        factory.makeIdentifierNode("utils")),
                                                factory.makeIdentifierNode("CollectionUtilities")),
                                        factory.makeIdentifierNode("listOf"),
                                        factory.makeExpressionListNode(liftChildrenList),
                                        factory.makeReferenceTypeListNode(
                                                factory.makeParameterizedTypeNode(
                                                        factory.makeUnparameterizedTypeNode(
                                                                factory.makeSimpleNameNode(
                                                                        factory.makeIdentifierNode("NodeUnion"))),
                                                        factory.makeTypeArgumentListNode(
                                                                factory.makeWildcardTypeNode(
                                                                        factory.makeUnparameterizedTypeNode(
                                                                                factory.makeSimpleNameNode(
                                                                                        factory.makeIdentifierNode("VariableDeclaratorNode"))),
                                                                        true))))),
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeVariableDeclaratorNode(VariableDeclaratorNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftIdentifier = 
                node.getUnionForIdentifier().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForIdentifier().getSpliceNode(), factoryNode, "IdentifierNode") :
                expressionizeNormalNodeUnion(node.getIdentifier(), factoryNode, "IdentifierNode");
        int liftArrayLevelsValue = 
                node.getArrayLevels();
        ExpressionNode liftInitializer = 
                node.getUnionForInitializer().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForInitializer().getSpliceNode(), factoryNode, "VariableInitializerNode") :
                expressionizeNormalNodeUnion(node.getInitializer(), factoryNode, "VariableInitializerNode");
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeVariableDeclaratorNodeWithUnions"),
                        factory.makeExpressionListNode(
                                liftIdentifier,
                                expressionizeInt(liftArrayLevelsValue),
                                liftInitializer,
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeVariableInitializerListNode(VariableInitializerListNode node, ExpressionNode factoryNode)
    {
        List<ExpressionNode> liftChildrenList = new ArrayList<ExpressionNode>();
        for (NodeUnion<? extends VariableInitializerNode> listval : node.getUnionForChildren())
        {
            liftChildrenList.add(
                    listval != null ? 
                            (listval.getType() == NodeUnion.Type.SPLICE ? 
                                    expressionizeSpliceNodeUnion(listval.getSpliceNode(), factoryNode, "VariableInitializerNode") :
                            expressionizeNormalNodeUnion(listval.getNormalNode(), factoryNode, "VariableInitializerNode"))
                            : factory.makeNullLiteralNode());
        }
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeVariableInitializerListNodeWithUnions"),
                        factory.makeExpressionListNode(
                                factory.makeMethodInvocationNode(
                                        factory.makeVariableAccessNode(
                                                factory.makeVariableAccessNode(
                                                        factory.makeVariableAccessNode(
                                                                factory.makeVariableAccessNode(
                                                                        factory.makeVariableAccessNode(
                                                                                factory.makeVariableAccessNode(
                                                                                        factory.makeVariableAccessNode(
                                                                                                factory.makeVariableAccessNode(
                                                                                                        factory.makeIdentifierNode("edu")),
                                                                                                factory.makeIdentifierNode("jhu")),
                                                                                        factory.makeIdentifierNode("cs")),
                                                                                factory.makeIdentifierNode("bsj")),
                                                                        factory.makeIdentifierNode("compiler")),
                                                                factory.makeIdentifierNode("impl")),
                                                        factory.makeIdentifierNode("utils")),
                                                factory.makeIdentifierNode("CollectionUtilities")),
                                        factory.makeIdentifierNode("listOf"),
                                        factory.makeExpressionListNode(liftChildrenList),
                                        factory.makeReferenceTypeListNode(
                                                factory.makeParameterizedTypeNode(
                                                        factory.makeUnparameterizedTypeNode(
                                                                factory.makeSimpleNameNode(
                                                                        factory.makeIdentifierNode("NodeUnion"))),
                                                        factory.makeTypeArgumentListNode(
                                                                factory.makeWildcardTypeNode(
                                                                        factory.makeUnparameterizedTypeNode(
                                                                                factory.makeSimpleNameNode(
                                                                                        factory.makeIdentifierNode("VariableInitializerNode"))),
                                                                        true))))),
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeVariableListNode(VariableListNode node, ExpressionNode factoryNode)
    {
        List<ExpressionNode> liftChildrenList = new ArrayList<ExpressionNode>();
        for (NodeUnion<? extends VariableNode> listval : node.getUnionForChildren())
        {
            liftChildrenList.add(
                    listval != null ? 
                            (listval.getType() == NodeUnion.Type.SPLICE ? 
                                    expressionizeSpliceNodeUnion(listval.getSpliceNode(), factoryNode, "VariableNode") :
                            expressionizeNormalNodeUnion(listval.getNormalNode(), factoryNode, "VariableNode"))
                            : factory.makeNullLiteralNode());
        }
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeVariableListNodeWithUnions"),
                        factory.makeExpressionListNode(
                                factory.makeMethodInvocationNode(
                                        factory.makeVariableAccessNode(
                                                factory.makeVariableAccessNode(
                                                        factory.makeVariableAccessNode(
                                                                factory.makeVariableAccessNode(
                                                                        factory.makeVariableAccessNode(
                                                                                factory.makeVariableAccessNode(
                                                                                        factory.makeVariableAccessNode(
                                                                                                factory.makeVariableAccessNode(
                                                                                                        factory.makeIdentifierNode("edu")),
                                                                                                factory.makeIdentifierNode("jhu")),
                                                                                        factory.makeIdentifierNode("cs")),
                                                                                factory.makeIdentifierNode("bsj")),
                                                                        factory.makeIdentifierNode("compiler")),
                                                                factory.makeIdentifierNode("impl")),
                                                        factory.makeIdentifierNode("utils")),
                                                factory.makeIdentifierNode("CollectionUtilities")),
                                        factory.makeIdentifierNode("listOf"),
                                        factory.makeExpressionListNode(liftChildrenList),
                                        factory.makeReferenceTypeListNode(
                                                factory.makeParameterizedTypeNode(
                                                        factory.makeUnparameterizedTypeNode(
                                                                factory.makeSimpleNameNode(
                                                                        factory.makeIdentifierNode("NodeUnion"))),
                                                        factory.makeTypeArgumentListNode(
                                                                factory.makeWildcardTypeNode(
                                                                        factory.makeUnparameterizedTypeNode(
                                                                                factory.makeSimpleNameNode(
                                                                                        factory.makeIdentifierNode("VariableNode"))),
                                                                        true))))),
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeVariableModifiersNode(VariableModifiersNode node, ExpressionNode factoryNode)
    {
        boolean liftFinalFlagValue = 
                node.getFinalFlag();
        ExpressionNode liftMetaAnnotations = 
                node.getUnionForMetaAnnotations().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForMetaAnnotations().getSpliceNode(), factoryNode, "MetaAnnotationListNode") :
                expressionizeNormalNodeUnion(node.getMetaAnnotations(), factoryNode, "MetaAnnotationListNode");
        ExpressionNode liftAnnotations = 
                node.getUnionForAnnotations().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForAnnotations().getSpliceNode(), factoryNode, "AnnotationListNode") :
                expressionizeNormalNodeUnion(node.getAnnotations(), factoryNode, "AnnotationListNode");
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeVariableModifiersNodeWithUnions"),
                        factory.makeExpressionListNode(
                                expressionizeBoolean(liftFinalFlagValue),
                                liftMetaAnnotations,
                                liftAnnotations,
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeVariableNode(VariableNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftModifiers = 
                node.getUnionForModifiers().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForModifiers().getSpliceNode(), factoryNode, "VariableModifiersNode") :
                expressionizeNormalNodeUnion(node.getModifiers(), factoryNode, "VariableModifiersNode");
        ExpressionNode liftType = 
                node.getUnionForType().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForType().getSpliceNode(), factoryNode, "TypeNode") :
                expressionizeNormalNodeUnion(node.getType(), factoryNode, "TypeNode");
        ExpressionNode liftIdentifier = 
                node.getUnionForIdentifier().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForIdentifier().getSpliceNode(), factoryNode, "IdentifierNode") :
                expressionizeNormalNodeUnion(node.getIdentifier(), factoryNode, "IdentifierNode");
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeVariableNodeWithUnions"),
                        factory.makeExpressionListNode(
                                liftModifiers,
                                liftType,
                                liftIdentifier,
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode());
        
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
                factory.makeMethodInvocationNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeVoidTypeNode"),
                        factory.makeExpressionListNode(
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeWhileLoopNode(WhileLoopNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftCondition = 
                node.getUnionForCondition().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForCondition().getSpliceNode(), factoryNode, "ExpressionNode") :
                expressionizeNormalNodeUnion(node.getCondition(), factoryNode, "ExpressionNode");
        ExpressionNode liftStatement = 
                node.getUnionForStatement().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForStatement().getSpliceNode(), factoryNode, "StatementNode") :
                expressionizeNormalNodeUnion(node.getStatement(), factoryNode, "StatementNode");
        ExpressionNode liftMetaAnnotations = 
                node.getUnionForMetaAnnotations().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForMetaAnnotations().getSpliceNode(), factoryNode, "MetaAnnotationListNode") :
                expressionizeNormalNodeUnion(node.getMetaAnnotations(), factoryNode, "MetaAnnotationListNode");
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeWhileLoopNodeWithUnions"),
                        factory.makeExpressionListNode(
                                liftCondition,
                                liftStatement,
                                liftMetaAnnotations,
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode());
        
        return ret;
    }
    
    @Override
    public ExpressionNode executeWildcardTypeNode(WildcardTypeNode node, ExpressionNode factoryNode)
    {
        ExpressionNode liftBound = 
                node.getUnionForBound().getType() == NodeUnion.Type.SPLICE ? 
                        expressionizeSpliceNodeUnion(node.getUnionForBound().getSpliceNode(), factoryNode, "ReferenceTypeNode") :
                expressionizeNormalNodeUnion(node.getBound(), factoryNode, "ReferenceTypeNode");
        boolean liftUpperBoundValue = 
                node.getUpperBound();
        BsjSourceLocation liftStartLocationValue = 
                node.getStartLocation();
        BsjSourceLocation liftStopLocationValue = 
                node.getStopLocation();
        
        ExpressionNode ret =
                factory.makeMethodInvocationNode(
                        factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                        factory.makeIdentifierNode("makeWildcardTypeNodeWithUnions"),
                        factory.makeExpressionListNode(
                                liftBound,
                                expressionizeBoolean(liftUpperBoundValue),
                                expressionizeBsjSourceLocation(liftStartLocationValue),
                                expressionizeBsjSourceLocation(liftStopLocationValue)),
                        factory.makeReferenceTypeListNode());
        
        return ret;
    }
    
    public ExpressionNode expressionizeNormalNodeUnion(Node node, ExpressionNode factoryNode, String typeParameterName)
    {
        return factory.makeMethodInvocationNode(
                factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                factory.makeIdentifierNode("makeNormalNodeUnion"),
                factory.makeExpressionListNode(
                        node == null ? factory.makeNullLiteralNode() : node.executeOperation(this, factoryNode)
                        ),
                factory.makeReferenceTypeListNode(factory.makeUnparameterizedTypeNode(
                        factory.makeSimpleNameNode(factory.makeIdentifierNode(typeParameterName)))));
    }
    
    public ExpressionNode expressionizeSpliceNodeUnion(SpliceNode node, ExpressionNode factoryNode, String typeParameterName)
    {
        return factory.makeMethodInvocationNode(
                factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),
                factory.makeIdentifierNode("makeNormalNodeUnion"),
                factory.makeExpressionListNode(
                        node.getSpliceExpression() == null ? factory.makeNullLiteralNode() : node.getSpliceExpression().deepCopy(factory)
                        ),
                factory.makeReferenceTypeListNode(factory.makeUnparameterizedTypeNode(
                        factory.makeSimpleNameNode(factory.makeIdentifierNode(typeParameterName)))));
    }
    
}
