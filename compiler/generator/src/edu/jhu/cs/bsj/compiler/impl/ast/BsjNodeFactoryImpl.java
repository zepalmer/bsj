package edu.jhu.cs.bsj.compiler.impl.ast;

import java.util.List;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.AccessModifier;
import edu.jhu.cs.bsj.compiler.ast.AssignmentOperator;
import edu.jhu.cs.bsj.compiler.ast.BinaryOperator;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
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
import edu.jhu.cs.bsj.compiler.impl.ast.node.*;
import edu.jhu.cs.bsj.compiler.impl.ast.node.meta.BlockStatementMetaprogramAnchorNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.meta.CodeLiteralNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.meta.MetaprogramNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.meta.TypeDeclarationMetaprogramAnchorNodeImpl;

/**
 * This class acts as a BSJ node factory for the standard BSJ compiler.
 *
 * @author Zachary Palmer
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class BsjNodeFactoryImpl implements BsjNodeFactory
{
    /** The start location to use for new nodes. */
    private BsjSourceLocation startLocation;

    /** The stop location to use for new nodes. */
    private BsjSourceLocation stopLocation;

	/**
	 * Retrieves the starting source location used for new nodes.
	 * 
	 * @return The start location used for new nodes. <code>null</code> is a permissible value and indicates that no
	 *         information is available.
	 */
	public BsjSourceLocation getStartSourceLocation()
	{
		return this.startLocation;
	}

	/**
	 * Retrieves the ending source location used for new nodes.
	 * 
	 * @return The stop location used for new nodes. <code>null</code> is a permissible value and indicates that no
	 *         information is available.
	 */
	public BsjSourceLocation getStopSourceLocation()
	{
		return this.stopLocation;
	}

    /**
     * Changes the starting source location used for new nodes.
     * @param startLocation The new start location to use for new nodes.  <code>null</code> is a permissible value and
     *                      indicates that no information is available.
     */
    @Override
    public void setStartSourceLocation(BsjSourceLocation startLocation)
    {
        this.startLocation = startLocation;
    }

    /**
     * Changes the ending source location used for new nodes.
     * @param stopLocation The new stop location to use for new nodes.  <code>null</code> is a permissible value and
     *                      indicates that no information is available.
     */
    @Override
    public void setStopSourceLocation(BsjSourceLocation stopLocation)
    {
        this.stopLocation = stopLocation;
    }

    /**
     * Creates a AssertStatementNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public AssertStatementNode makeAssertStatementNode(
            ExpressionNode testExpression,
            ExpressionNode messageExpression)
    {
        AssertStatementNode ret = new AssertStatementNodeImpl(testExpression, messageExpression, startLocation, stopLocation);
        return ret;
    }

    /**
     * Creates a AssertStatementNode.
     * The specified start and stop locations are used.
     */
    @Override
    public AssertStatementNode makeAssertStatementNode(
            ExpressionNode testExpression,
            ExpressionNode messageExpression,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        AssertStatementNode ret = new AssertStatementNodeImpl(testExpression, messageExpression, startLocation, stopLocation);
        return ret;
    }

    /**
     * Creates a UnaryStatementExpressionNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public UnaryStatementExpressionNode makeUnaryStatementExpressionNode(
            ExpressionNode expression,
            UnaryStatementOperator operator)
    {
        UnaryStatementExpressionNode ret = new UnaryStatementExpressionNodeImpl(expression, operator, startLocation, stopLocation);
        return ret;
    }

    /**
     * Creates a UnaryStatementExpressionNode.
     * The specified start and stop locations are used.
     */
    @Override
    public UnaryStatementExpressionNode makeUnaryStatementExpressionNode(
            ExpressionNode expression,
            UnaryStatementOperator operator,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        UnaryStatementExpressionNode ret = new UnaryStatementExpressionNodeImpl(expression, operator, startLocation, stopLocation);
        return ret;
    }

    /**
     * Creates a InterfaceBodyNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public InterfaceBodyNode makeInterfaceBodyNode(
            ListNode<InterfaceMemberNode> members)
    {
        InterfaceBodyNode ret = new InterfaceBodyNodeImpl(members, startLocation, stopLocation);
        return ret;
    }

    /**
     * Creates a InterfaceBodyNode.
     * The specified start and stop locations are used.
     */
    @Override
    public InterfaceBodyNode makeInterfaceBodyNode(
            ListNode<InterfaceMemberNode> members,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        InterfaceBodyNode ret = new InterfaceBodyNodeImpl(members, startLocation, stopLocation);
        return ret;
    }

    /**
     * Creates a ExpressionStatementNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public ExpressionStatementNode makeExpressionStatementNode(
            StatementExpressionNode expression)
    {
        ExpressionStatementNode ret = new ExpressionStatementNodeImpl(expression, startLocation, stopLocation);
        return ret;
    }

    /**
     * Creates a ExpressionStatementNode.
     * The specified start and stop locations are used.
     */
    @Override
    public ExpressionStatementNode makeExpressionStatementNode(
            StatementExpressionNode expression,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        ExpressionStatementNode ret = new ExpressionStatementNodeImpl(expression, startLocation, stopLocation);
        return ret;
    }

    /**
     * Creates a ClassDeclarationNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public ClassDeclarationNode makeClassDeclarationNode(
            ClassModifiersNode modifiers,
            TypeNode extendsClause,
            ListNode<TypeNode> implementsClause,
            ClassBodyNode body,
            ListNode<TypeParameterNode> typeParameters,
            IdentifierNode identifier,
            JavadocNode javadoc)
    {
        ClassDeclarationNode ret = new ClassDeclarationNodeImpl(modifiers, extendsClause, implementsClause, body, typeParameters, identifier, javadoc, startLocation, stopLocation);
        return ret;
    }

    /**
     * Creates a ClassDeclarationNode.
     * The specified start and stop locations are used.
     */
    @Override
    public ClassDeclarationNode makeClassDeclarationNode(
            ClassModifiersNode modifiers,
            TypeNode extendsClause,
            ListNode<TypeNode> implementsClause,
            ClassBodyNode body,
            ListNode<TypeParameterNode> typeParameters,
            IdentifierNode identifier,
            JavadocNode javadoc,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        ClassDeclarationNode ret = new ClassDeclarationNodeImpl(modifiers, extendsClause, implementsClause, body, typeParameters, identifier, javadoc, startLocation, stopLocation);
        return ret;
    }

    /**
     * Creates a EnhancedForLoopNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public EnhancedForLoopNode makeEnhancedForLoopNode(
            VariableNode variable,
            ExpressionNode expression,
            StatementNode statement)
    {
        EnhancedForLoopNode ret = new EnhancedForLoopNodeImpl(variable, expression, statement, startLocation, stopLocation);
        return ret;
    }

    /**
     * Creates a EnhancedForLoopNode.
     * The specified start and stop locations are used.
     */
    @Override
    public EnhancedForLoopNode makeEnhancedForLoopNode(
            VariableNode variable,
            ExpressionNode expression,
            StatementNode statement,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        EnhancedForLoopNode ret = new EnhancedForLoopNodeImpl(variable, expression, statement, startLocation, stopLocation);
        return ret;
    }

    /**
     * Creates a ArrayAccessNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public ArrayAccessNode makeArrayAccessNode(
            RestrictedPrimaryExpressionNode arrayExpression,
            ExpressionNode indexExpression)
    {
        ArrayAccessNode ret = new ArrayAccessNodeImpl(arrayExpression, indexExpression, startLocation, stopLocation);
        return ret;
    }

    /**
     * Creates a ArrayAccessNode.
     * The specified start and stop locations are used.
     */
    @Override
    public ArrayAccessNode makeArrayAccessNode(
            RestrictedPrimaryExpressionNode arrayExpression,
            ExpressionNode indexExpression,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        ArrayAccessNode ret = new ArrayAccessNodeImpl(arrayExpression, indexExpression, startLocation, stopLocation);
        return ret;
    }

    /**
     * Creates a LongLiteralNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public LongLiteralNode makeLongLiteralNode(
            Long value)
    {
        LongLiteralNode ret = new LongLiteralNodeImpl(value, startLocation, stopLocation);
        return ret;
    }

    /**
     * Creates a LongLiteralNode.
     * The specified start and stop locations are used.
     */
    @Override
    public LongLiteralNode makeLongLiteralNode(
            Long value,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        LongLiteralNode ret = new LongLiteralNodeImpl(value, startLocation, stopLocation);
        return ret;
    }

    /**
     * Creates a QualifiedNameNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public QualifiedNameNode makeQualifiedNameNode(
            NameNode base,
            IdentifierNode identifier,
            NameCategory category)
    {
        QualifiedNameNode ret = new QualifiedNameNodeImpl(base, identifier, category, startLocation, stopLocation);
        return ret;
    }

    /**
     * Creates a QualifiedNameNode.
     * The specified start and stop locations are used.
     */
    @Override
    public QualifiedNameNode makeQualifiedNameNode(
            NameNode base,
            IdentifierNode identifier,
            NameCategory category,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        QualifiedNameNode ret = new QualifiedNameNodeImpl(base, identifier, category, startLocation, stopLocation);
        return ret;
    }

    /**
     * Creates a CaseNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public CaseNode makeCaseNode(
            ExpressionNode expression,
            ListNode<BlockStatementNode> statements)
    {
        CaseNode ret = new CaseNodeImpl(expression, statements, startLocation, stopLocation);
        return ret;
    }

    /**
     * Creates a CaseNode.
     * The specified start and stop locations are used.
     */
    @Override
    public CaseNode makeCaseNode(
            ExpressionNode expression,
            ListNode<BlockStatementNode> statements,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        CaseNode ret = new CaseNodeImpl(expression, statements, startLocation, stopLocation);
        return ret;
    }

    /**
     * Creates a VoidStatementNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public VoidStatementNode makeVoidStatementNode(
)
    {
        VoidStatementNode ret = new VoidStatementNodeImpl(startLocation, stopLocation);
        return ret;
    }

    /**
     * Creates a VoidStatementNode.
     * The specified start and stop locations are used.
     */
    @Override
    public VoidStatementNode makeVoidStatementNode(
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        VoidStatementNode ret = new VoidStatementNodeImpl(startLocation, stopLocation);
        return ret;
    }

    /**
     * Creates a CodeLiteralNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public CodeLiteralNode makeCodeLiteralNode(
            Node value)
    {
        CodeLiteralNode ret = new CodeLiteralNodeImpl(value, startLocation, stopLocation);
        return ret;
    }

    /**
     * Creates a CodeLiteralNode.
     * The specified start and stop locations are used.
     */
    @Override
    public CodeLiteralNode makeCodeLiteralNode(
            Node value,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        CodeLiteralNode ret = new CodeLiteralNodeImpl(value, startLocation, stopLocation);
        return ret;
    }

    /**
     * Creates a ImportOnDemandNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public ImportOnDemandNode makeImportOnDemandNode(
            NameNode name,
            boolean staticImport)
    {
        ImportOnDemandNode ret = new ImportOnDemandNodeImpl(name, staticImport, startLocation, stopLocation);
        return ret;
    }

    /**
     * Creates a ImportOnDemandNode.
     * The specified start and stop locations are used.
     */
    @Override
    public ImportOnDemandNode makeImportOnDemandNode(
            NameNode name,
            boolean staticImport,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        ImportOnDemandNode ret = new ImportOnDemandNodeImpl(name, staticImport, startLocation, stopLocation);
        return ret;
    }

    /**
     * Creates a VariableModifiersNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public VariableModifiersNode makeVariableModifiersNode(
            boolean finalFlag,
            ListNode<AnnotationNode> annotations)
    {
        VariableModifiersNode ret = new VariableModifiersNodeImpl(finalFlag, annotations, startLocation, stopLocation);
        return ret;
    }

    /**
     * Creates a VariableModifiersNode.
     * The specified start and stop locations are used.
     */
    @Override
    public VariableModifiersNode makeVariableModifiersNode(
            boolean finalFlag,
            ListNode<AnnotationNode> annotations,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        VariableModifiersNode ret = new VariableModifiersNodeImpl(finalFlag, annotations, startLocation, stopLocation);
        return ret;
    }

    /**
     * Creates a BlockStatementMetaprogramAnchorNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public BlockStatementMetaprogramAnchorNode makeBlockStatementMetaprogramAnchorNode(
            MetaprogramNode metaprogram)
    {
        BlockStatementMetaprogramAnchorNode ret = new BlockStatementMetaprogramAnchorNodeImpl(makeVoidStatementNode(), metaprogram, startLocation, stopLocation);
        return ret;
    }

    /**
     * Creates a BlockStatementMetaprogramAnchorNode.
     * The specified start and stop locations are used.
     */
    @Override
    public BlockStatementMetaprogramAnchorNode makeBlockStatementMetaprogramAnchorNode(
            BlockStatementNode replacement,
            MetaprogramNode metaprogram,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        BlockStatementMetaprogramAnchorNode ret = new BlockStatementMetaprogramAnchorNodeImpl(makeVoidStatementNode(), metaprogram, startLocation, stopLocation);
        return ret;
    }

    /**
     * Creates a InterfaceModifiersNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public InterfaceModifiersNode makeInterfaceModifiersNode(
            AccessModifier access,
            boolean staticFlag,
            boolean strictfpFlag,
            ListNode<AnnotationNode> annotations)
    {
        InterfaceModifiersNode ret = new InterfaceModifiersNodeImpl(access, staticFlag, strictfpFlag, annotations, startLocation, stopLocation);
        return ret;
    }

    /**
     * Creates a InterfaceModifiersNode.
     * The specified start and stop locations are used.
     */
    @Override
    public InterfaceModifiersNode makeInterfaceModifiersNode(
            AccessModifier access,
            boolean staticFlag,
            boolean strictfpFlag,
            ListNode<AnnotationNode> annotations,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        InterfaceModifiersNode ret = new InterfaceModifiersNodeImpl(access, staticFlag, strictfpFlag, annotations, startLocation, stopLocation);
        return ret;
    }

    /**
     * Creates a SuperclassConstructorInvocationNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public SuperclassConstructorInvocationNode makeSuperclassConstructorInvocationNode(
            PrimaryExpressionNode qualifyingExpression,
            ListNode<ExpressionNode> arguments,
            ListNode<TypeNode> typeArguments)
    {
        SuperclassConstructorInvocationNode ret = new SuperclassConstructorInvocationNodeImpl(qualifyingExpression, arguments, typeArguments, startLocation, stopLocation);
        return ret;
    }

    /**
     * Creates a SuperclassConstructorInvocationNode.
     * The specified start and stop locations are used.
     */
    @Override
    public SuperclassConstructorInvocationNode makeSuperclassConstructorInvocationNode(
            PrimaryExpressionNode qualifyingExpression,
            ListNode<ExpressionNode> arguments,
            ListNode<TypeNode> typeArguments,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        SuperclassConstructorInvocationNode ret = new SuperclassConstructorInvocationNodeImpl(qualifyingExpression, arguments, typeArguments, startLocation, stopLocation);
        return ret;
    }

    /**
     * Creates a PrimitiveTypeNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public PrimitiveTypeNode makePrimitiveTypeNode(
            PrimitiveType primitiveType)
    {
        PrimitiveTypeNode ret = new PrimitiveTypeNodeImpl(primitiveType, startLocation, stopLocation);
        return ret;
    }

    /**
     * Creates a PrimitiveTypeNode.
     * The specified start and stop locations are used.
     */
    @Override
    public PrimitiveTypeNode makePrimitiveTypeNode(
            PrimitiveType primitiveType,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        PrimitiveTypeNode ret = new PrimitiveTypeNodeImpl(primitiveType, startLocation, stopLocation);
        return ret;
    }

    /**
     * Creates a MetaprogramNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public MetaprogramNode makeMetaprogramNode(
            ListNode<BlockStatementNode> body)
    {
        MetaprogramNode ret = new MetaprogramNodeImpl(body, startLocation, stopLocation);
        return ret;
    }

    /**
     * Creates a MetaprogramNode.
     * The specified start and stop locations are used.
     */
    @Override
    public MetaprogramNode makeMetaprogramNode(
            ListNode<BlockStatementNode> body,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        MetaprogramNode ret = new MetaprogramNodeImpl(body, startLocation, stopLocation);
        return ret;
    }

    /**
     * Creates a InitializerDeclarationNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public InitializerDeclarationNode makeInitializerDeclarationNode(
            boolean staticInitializer,
            BlockNode body)
    {
        InitializerDeclarationNode ret = new InitializerDeclarationNodeImpl(staticInitializer, body, startLocation, stopLocation);
        return ret;
    }

    /**
     * Creates a InitializerDeclarationNode.
     * The specified start and stop locations are used.
     */
    @Override
    public InitializerDeclarationNode makeInitializerDeclarationNode(
            boolean staticInitializer,
            BlockNode body,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        InitializerDeclarationNode ret = new InitializerDeclarationNodeImpl(staticInitializer, body, startLocation, stopLocation);
        return ret;
    }

    /**
     * Creates a EnumBodyNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public EnumBodyNode makeEnumBodyNode(
            ListNode<EnumConstantDeclarationNode> constants,
            ListNode<ClassMemberNode> members)
    {
        EnumBodyNode ret = new EnumBodyNodeImpl(constants, members, startLocation, stopLocation);
        return ret;
    }

    /**
     * Creates a EnumBodyNode.
     * The specified start and stop locations are used.
     */
    @Override
    public EnumBodyNode makeEnumBodyNode(
            ListNode<EnumConstantDeclarationNode> constants,
            ListNode<ClassMemberNode> members,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        EnumBodyNode ret = new EnumBodyNodeImpl(constants, members, startLocation, stopLocation);
        return ret;
    }

    /**
     * Creates a TryNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public TryNode makeTryNode(
            BlockNode block,
            ListNode<CatchNode> catches,
            BlockNode finallyBlock)
    {
        TryNode ret = new TryNodeImpl(block, catches, finallyBlock, startLocation, stopLocation);
        return ret;
    }

    /**
     * Creates a TryNode.
     * The specified start and stop locations are used.
     */
    @Override
    public TryNode makeTryNode(
            BlockNode block,
            ListNode<CatchNode> catches,
            BlockNode finallyBlock,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        TryNode ret = new TryNodeImpl(block, catches, finallyBlock, startLocation, stopLocation);
        return ret;
    }

    /**
     * Creates a ThisNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public ThisNode makeThisNode(
            UnparameterizedTypeNode type)
    {
        ThisNode ret = new ThisNodeImpl(type, startLocation, stopLocation);
        return ret;
    }

    /**
     * Creates a ThisNode.
     * The specified start and stop locations are used.
     */
    @Override
    public ThisNode makeThisNode(
            UnparameterizedTypeNode type,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        ThisNode ret = new ThisNodeImpl(type, startLocation, stopLocation);
        return ret;
    }

    /**
     * Creates a TypeDeclarationMetaprogramAnchorNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public TypeDeclarationMetaprogramAnchorNode makeTypeDeclarationMetaprogramAnchorNode(
            MetaprogramNode metaprogram)
    {
        TypeDeclarationMetaprogramAnchorNode ret = new TypeDeclarationMetaprogramAnchorNodeImpl(makeVoidTypeDeclarationNode(), metaprogram, startLocation, stopLocation);
        return ret;
    }

    /**
     * Creates a TypeDeclarationMetaprogramAnchorNode.
     * The specified start and stop locations are used.
     */
    @Override
    public TypeDeclarationMetaprogramAnchorNode makeTypeDeclarationMetaprogramAnchorNode(
            TypeDeclarationNode replacement,
            MetaprogramNode metaprogram,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        TypeDeclarationMetaprogramAnchorNode ret = new TypeDeclarationMetaprogramAnchorNodeImpl(makeVoidTypeDeclarationNode(), metaprogram, startLocation, stopLocation);
        return ret;
    }

    /**
     * Creates a EnumDeclarationNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public EnumDeclarationNode makeEnumDeclarationNode(
            EnumModifiersNode modifiers,
            ListNode<TypeNode> implementsClause,
            EnumBodyNode body,
            IdentifierNode identifier,
            JavadocNode javadoc)
    {
        EnumDeclarationNode ret = new EnumDeclarationNodeImpl(modifiers, implementsClause, body, identifier, javadoc, startLocation, stopLocation);
        return ret;
    }

    /**
     * Creates a EnumDeclarationNode.
     * The specified start and stop locations are used.
     */
    @Override
    public EnumDeclarationNode makeEnumDeclarationNode(
            EnumModifiersNode modifiers,
            ListNode<TypeNode> implementsClause,
            EnumBodyNode body,
            IdentifierNode identifier,
            JavadocNode javadoc,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        EnumDeclarationNode ret = new EnumDeclarationNodeImpl(modifiers, implementsClause, body, identifier, javadoc, startLocation, stopLocation);
        return ret;
    }

    /**
     * Creates a VoidTypeNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public VoidTypeNode makeVoidTypeNode(
)
    {
        VoidTypeNode ret = new VoidTypeNodeImpl(startLocation, stopLocation);
        return ret;
    }

    /**
     * Creates a VoidTypeNode.
     * The specified start and stop locations are used.
     */
    @Override
    public VoidTypeNode makeVoidTypeNode(
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        VoidTypeNode ret = new VoidTypeNodeImpl(startLocation, stopLocation);
        return ret;
    }

    /**
     * Creates a VariableDeclarationNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public VariableDeclarationNode makeVariableDeclarationNode(
            VariableModifiersNode modifiers,
            ListNode<VariableDeclaratorNode> declarators)
    {
        VariableDeclarationNode ret = new VariableDeclarationNodeImpl(modifiers, declarators, startLocation, stopLocation);
        return ret;
    }

    /**
     * Creates a VariableDeclarationNode.
     * The specified start and stop locations are used.
     */
    @Override
    public VariableDeclarationNode makeVariableDeclarationNode(
            VariableModifiersNode modifiers,
            ListNode<VariableDeclaratorNode> declarators,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        VariableDeclarationNode ret = new VariableDeclarationNodeImpl(modifiers, declarators, startLocation, stopLocation);
        return ret;
    }

    /**
     * Creates a AnnotationBodyNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public AnnotationBodyNode makeAnnotationBodyNode(
            ListNode<AnnotationMemberNode> members)
    {
        AnnotationBodyNode ret = new AnnotationBodyNodeImpl(members, startLocation, stopLocation);
        return ret;
    }

    /**
     * Creates a AnnotationBodyNode.
     * The specified start and stop locations are used.
     */
    @Override
    public AnnotationBodyNode makeAnnotationBodyNode(
            ListNode<AnnotationMemberNode> members,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        AnnotationBodyNode ret = new AnnotationBodyNodeImpl(members, startLocation, stopLocation);
        return ret;
    }

    /**
     * Creates a UnparameterizedTypeNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public UnparameterizedTypeNode makeUnparameterizedTypeNode(
            NameNode name)
    {
        UnparameterizedTypeNode ret = new UnparameterizedTypeNodeImpl(name, startLocation, stopLocation);
        return ret;
    }

    /**
     * Creates a UnparameterizedTypeNode.
     * The specified start and stop locations are used.
     */
    @Override
    public UnparameterizedTypeNode makeUnparameterizedTypeNode(
            NameNode name,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        UnparameterizedTypeNode ret = new UnparameterizedTypeNodeImpl(name, startLocation, stopLocation);
        return ret;
    }

    /**
     * Creates a VariableDeclaratorNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public VariableDeclaratorNode makeVariableDeclaratorNode(
            TypeNode type,
            IdentifierNode name,
            VariableInitializerNode initializer)
    {
        VariableDeclaratorNode ret = new VariableDeclaratorNodeImpl(type, name, initializer, startLocation, stopLocation);
        return ret;
    }

    /**
     * Creates a VariableDeclaratorNode.
     * The specified start and stop locations are used.
     */
    @Override
    public VariableDeclaratorNode makeVariableDeclaratorNode(
            TypeNode type,
            IdentifierNode name,
            VariableInitializerNode initializer,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        VariableDeclaratorNode ret = new VariableDeclaratorNodeImpl(type, name, initializer, startLocation, stopLocation);
        return ret;
    }

    /**
     * Creates a AnnotationModifiersNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public AnnotationModifiersNode makeAnnotationModifiersNode(
            AccessModifier access,
            boolean staticFlag,
            boolean strictfpFlag,
            ListNode<AnnotationNode> annotations)
    {
        AnnotationModifiersNode ret = new AnnotationModifiersNodeImpl(access, staticFlag, strictfpFlag, annotations, startLocation, stopLocation);
        return ret;
    }

    /**
     * Creates a AnnotationModifiersNode.
     * The specified start and stop locations are used.
     */
    @Override
    public AnnotationModifiersNode makeAnnotationModifiersNode(
            AccessModifier access,
            boolean staticFlag,
            boolean strictfpFlag,
            ListNode<AnnotationNode> annotations,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        AnnotationModifiersNode ret = new AnnotationModifiersNodeImpl(access, staticFlag, strictfpFlag, annotations, startLocation, stopLocation);
        return ret;
    }

    /**
     * Creates a FieldAccessByExpressionNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public FieldAccessByExpressionNode makeFieldAccessByExpressionNode(
            PrimaryExpressionNode expression,
            IdentifierNode identifier)
    {
        FieldAccessByExpressionNode ret = new FieldAccessByExpressionNodeImpl(expression, identifier, startLocation, stopLocation);
        return ret;
    }

    /**
     * Creates a FieldAccessByExpressionNode.
     * The specified start and stop locations are used.
     */
    @Override
    public FieldAccessByExpressionNode makeFieldAccessByExpressionNode(
            PrimaryExpressionNode expression,
            IdentifierNode identifier,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        FieldAccessByExpressionNode ret = new FieldAccessByExpressionNodeImpl(expression, identifier, startLocation, stopLocation);
        return ret;
    }

    /**
     * Creates a SuperFieldAccessNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public SuperFieldAccessNode makeSuperFieldAccessNode(
            UnparameterizedTypeNode type,
            IdentifierNode identifier)
    {
        SuperFieldAccessNode ret = new SuperFieldAccessNodeImpl(type, identifier, startLocation, stopLocation);
        return ret;
    }

    /**
     * Creates a SuperFieldAccessNode.
     * The specified start and stop locations are used.
     */
    @Override
    public SuperFieldAccessNode makeSuperFieldAccessNode(
            UnparameterizedTypeNode type,
            IdentifierNode identifier,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        SuperFieldAccessNode ret = new SuperFieldAccessNodeImpl(type, identifier, startLocation, stopLocation);
        return ret;
    }

    /**
     * Creates a ThrowNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public ThrowNode makeThrowNode(
            ExpressionNode expression)
    {
        ThrowNode ret = new ThrowNodeImpl(expression, startLocation, stopLocation);
        return ret;
    }

    /**
     * Creates a ThrowNode.
     * The specified start and stop locations are used.
     */
    @Override
    public ThrowNode makeThrowNode(
            ExpressionNode expression,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        ThrowNode ret = new ThrowNodeImpl(expression, startLocation, stopLocation);
        return ret;
    }

    /**
     * Creates a EnumModifiersNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public EnumModifiersNode makeEnumModifiersNode(
            AccessModifier access,
            boolean strictfpFlag,
            ListNode<AnnotationNode> annotations)
    {
        EnumModifiersNode ret = new EnumModifiersNodeImpl(access, strictfpFlag, annotations, startLocation, stopLocation);
        return ret;
    }

    /**
     * Creates a EnumModifiersNode.
     * The specified start and stop locations are used.
     */
    @Override
    public EnumModifiersNode makeEnumModifiersNode(
            AccessModifier access,
            boolean strictfpFlag,
            ListNode<AnnotationNode> annotations,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        EnumModifiersNode ret = new EnumModifiersNodeImpl(access, strictfpFlag, annotations, startLocation, stopLocation);
        return ret;
    }

    /**
     * Creates a CatchNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public CatchNode makeCatchNode(
            BlockNode block,
            VariableNode parameter)
    {
        CatchNode ret = new CatchNodeImpl(block, parameter, startLocation, stopLocation);
        return ret;
    }

    /**
     * Creates a CatchNode.
     * The specified start and stop locations are used.
     */
    @Override
    public CatchNode makeCatchNode(
            BlockNode block,
            VariableNode parameter,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        CatchNode ret = new CatchNodeImpl(block, parameter, startLocation, stopLocation);
        return ret;
    }

    /**
     * Creates a VoidTypeDeclarationNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public VoidTypeDeclarationNode makeVoidTypeDeclarationNode(
)
    {
        VoidTypeDeclarationNode ret = new VoidTypeDeclarationNodeImpl(startLocation, stopLocation);
        return ret;
    }

    /**
     * Creates a VoidTypeDeclarationNode.
     * The specified start and stop locations are used.
     */
    @Override
    public VoidTypeDeclarationNode makeVoidTypeDeclarationNode(
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        VoidTypeDeclarationNode ret = new VoidTypeDeclarationNodeImpl(startLocation, stopLocation);
        return ret;
    }

    /**
     * Creates a NormalAnnotationNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public NormalAnnotationNode makeNormalAnnotationNode(
            ListNode<AnnotationElementNode> arguments,
            UnparameterizedTypeNode annotationType)
    {
        NormalAnnotationNode ret = new NormalAnnotationNodeImpl(arguments, annotationType, startLocation, stopLocation);
        return ret;
    }

    /**
     * Creates a NormalAnnotationNode.
     * The specified start and stop locations are used.
     */
    @Override
    public NormalAnnotationNode makeNormalAnnotationNode(
            ListNode<AnnotationElementNode> arguments,
            UnparameterizedTypeNode annotationType,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        NormalAnnotationNode ret = new NormalAnnotationNodeImpl(arguments, annotationType, startLocation, stopLocation);
        return ret;
    }

    /**
     * Creates a DoWhileLoopNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public DoWhileLoopNode makeDoWhileLoopNode(
            ExpressionNode condition,
            StatementNode statement)
    {
        DoWhileLoopNode ret = new DoWhileLoopNodeImpl(condition, statement, startLocation, stopLocation);
        return ret;
    }

    /**
     * Creates a DoWhileLoopNode.
     * The specified start and stop locations are used.
     */
    @Override
    public DoWhileLoopNode makeDoWhileLoopNode(
            ExpressionNode condition,
            StatementNode statement,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        DoWhileLoopNode ret = new DoWhileLoopNodeImpl(condition, statement, startLocation, stopLocation);
        return ret;
    }

    /**
     * Creates a QualifiedClassInstantiationNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public QualifiedClassInstantiationNode makeQualifiedClassInstantiationNode(
            ExpressionNode enclosingExpression,
            IdentifierNode identifier,
            ListNode<TypeArgumentNode> typeArguments,
            ListNode<TypeArgumentNode> constructorTypeArguments,
            ListNode<ExpressionNode> arguments,
            AnonymousClassBodyNode body)
    {
        QualifiedClassInstantiationNode ret = new QualifiedClassInstantiationNodeImpl(enclosingExpression, identifier, typeArguments, constructorTypeArguments, arguments, body, startLocation, stopLocation);
        return ret;
    }

    /**
     * Creates a QualifiedClassInstantiationNode.
     * The specified start and stop locations are used.
     */
    @Override
    public QualifiedClassInstantiationNode makeQualifiedClassInstantiationNode(
            ExpressionNode enclosingExpression,
            IdentifierNode identifier,
            ListNode<TypeArgumentNode> typeArguments,
            ListNode<TypeArgumentNode> constructorTypeArguments,
            ListNode<ExpressionNode> arguments,
            AnonymousClassBodyNode body,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        QualifiedClassInstantiationNode ret = new QualifiedClassInstantiationNodeImpl(enclosingExpression, identifier, typeArguments, constructorTypeArguments, arguments, body, startLocation, stopLocation);
        return ret;
    }

    /**
     * Creates a TypeCastNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public TypeCastNode makeTypeCastNode(
            ExpressionNode expression,
            TypeNode type)
    {
        TypeCastNode ret = new TypeCastNodeImpl(expression, type, startLocation, stopLocation);
        return ret;
    }

    /**
     * Creates a TypeCastNode.
     * The specified start and stop locations are used.
     */
    @Override
    public TypeCastNode makeTypeCastNode(
            ExpressionNode expression,
            TypeNode type,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        TypeCastNode ret = new TypeCastNodeImpl(expression, type, startLocation, stopLocation);
        return ret;
    }

    /**
     * Creates a LabeledStatementNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public LabeledStatementNode makeLabeledStatementNode(
            IdentifierNode label,
            StatementNode statement)
    {
        LabeledStatementNode ret = new LabeledStatementNodeImpl(label, statement, startLocation, stopLocation);
        return ret;
    }

    /**
     * Creates a LabeledStatementNode.
     * The specified start and stop locations are used.
     */
    @Override
    public LabeledStatementNode makeLabeledStatementNode(
            IdentifierNode label,
            StatementNode statement,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        LabeledStatementNode ret = new LabeledStatementNodeImpl(label, statement, startLocation, stopLocation);
        return ret;
    }

    /**
     * Creates a BinaryExpressionNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public BinaryExpressionNode makeBinaryExpressionNode(
            ExpressionNode leftOperand,
            ExpressionNode rightOperand,
            BinaryOperator operator)
    {
        BinaryExpressionNode ret = new BinaryExpressionNodeImpl(leftOperand, rightOperand, operator, startLocation, stopLocation);
        return ret;
    }

    /**
     * Creates a BinaryExpressionNode.
     * The specified start and stop locations are used.
     */
    @Override
    public BinaryExpressionNode makeBinaryExpressionNode(
            ExpressionNode leftOperand,
            ExpressionNode rightOperand,
            BinaryOperator operator,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        BinaryExpressionNode ret = new BinaryExpressionNodeImpl(leftOperand, rightOperand, operator, startLocation, stopLocation);
        return ret;
    }

    /**
     * Creates a ForInitializerExpressionNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public ForInitializerExpressionNode makeForInitializerExpressionNode(
            ListNode<StatementExpressionNode> expressions)
    {
        ForInitializerExpressionNode ret = new ForInitializerExpressionNodeImpl(expressions, startLocation, stopLocation);
        return ret;
    }

    /**
     * Creates a ForInitializerExpressionNode.
     * The specified start and stop locations are used.
     */
    @Override
    public ForInitializerExpressionNode makeForInitializerExpressionNode(
            ListNode<StatementExpressionNode> expressions,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        ForInitializerExpressionNode ret = new ForInitializerExpressionNodeImpl(expressions, startLocation, stopLocation);
        return ret;
    }

    /**
     * Creates a PackageDeclarationNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public PackageDeclarationNode makePackageDeclarationNode(
            NameNode name,
            ListNode<AnnotationNode> annotations)
    {
        PackageDeclarationNode ret = new PackageDeclarationNodeImpl(name, annotations, startLocation, stopLocation);
        return ret;
    }

    /**
     * Creates a PackageDeclarationNode.
     * The specified start and stop locations are used.
     */
    @Override
    public PackageDeclarationNode makePackageDeclarationNode(
            NameNode name,
            ListNode<AnnotationNode> annotations,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        PackageDeclarationNode ret = new PackageDeclarationNodeImpl(name, annotations, startLocation, stopLocation);
        return ret;
    }

    /**
     * Creates a AnnotationDeclarationNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public AnnotationDeclarationNode makeAnnotationDeclarationNode(
            AnnotationModifiersNode modifiers,
            AnnotationBodyNode body,
            IdentifierNode identifier,
            JavadocNode javadoc)
    {
        AnnotationDeclarationNode ret = new AnnotationDeclarationNodeImpl(modifiers, body, identifier, javadoc, startLocation, stopLocation);
        return ret;
    }

    /**
     * Creates a AnnotationDeclarationNode.
     * The specified start and stop locations are used.
     */
    @Override
    public AnnotationDeclarationNode makeAnnotationDeclarationNode(
            AnnotationModifiersNode modifiers,
            AnnotationBodyNode body,
            IdentifierNode identifier,
            JavadocNode javadoc,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        AnnotationDeclarationNode ret = new AnnotationDeclarationNodeImpl(modifiers, body, identifier, javadoc, startLocation, stopLocation);
        return ret;
    }

    /**
     * Creates a CompilationUnitNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public CompilationUnitNode makeCompilationUnitNode(
            PackageDeclarationNode packageDeclaration,
            ListNode<ImportNode> imports,
            ListNode<TypeDeclarationNode> typeDecls)
    {
        CompilationUnitNode ret = new CompilationUnitNodeImpl(packageDeclaration, imports, typeDecls, startLocation, stopLocation);
        return ret;
    }

    /**
     * Creates a CompilationUnitNode.
     * The specified start and stop locations are used.
     */
    @Override
    public CompilationUnitNode makeCompilationUnitNode(
            PackageDeclarationNode packageDeclaration,
            ListNode<ImportNode> imports,
            ListNode<TypeDeclarationNode> typeDecls,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        CompilationUnitNode ret = new CompilationUnitNodeImpl(packageDeclaration, imports, typeDecls, startLocation, stopLocation);
        return ret;
    }

    /**
     * Creates a ContinueNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public ContinueNode makeContinueNode(
            IdentifierNode label)
    {
        ContinueNode ret = new ContinueNodeImpl(label, startLocation, stopLocation);
        return ret;
    }

    /**
     * Creates a ContinueNode.
     * The specified start and stop locations are used.
     */
    @Override
    public ContinueNode makeContinueNode(
            IdentifierNode label,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        ContinueNode ret = new ContinueNodeImpl(label, startLocation, stopLocation);
        return ret;
    }

    /**
     * Creates a StringLiteralNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public StringLiteralNode makeStringLiteralNode(
            String value)
    {
        StringLiteralNode ret = new StringLiteralNodeImpl(value, startLocation, stopLocation);
        return ret;
    }

    /**
     * Creates a StringLiteralNode.
     * The specified start and stop locations are used.
     */
    @Override
    public StringLiteralNode makeStringLiteralNode(
            String value,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        StringLiteralNode ret = new StringLiteralNodeImpl(value, startLocation, stopLocation);
        return ret;
    }

    /**
     * Creates a AnnotationElementNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public AnnotationElementNode makeAnnotationElementNode(
            IdentifierNode identifier,
            AnnotationValueNode value)
    {
        AnnotationElementNode ret = new AnnotationElementNodeImpl(identifier, value, startLocation, stopLocation);
        return ret;
    }

    /**
     * Creates a AnnotationElementNode.
     * The specified start and stop locations are used.
     */
    @Override
    public AnnotationElementNode makeAnnotationElementNode(
            IdentifierNode identifier,
            AnnotationValueNode value,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        AnnotationElementNode ret = new AnnotationElementNodeImpl(identifier, value, startLocation, stopLocation);
        return ret;
    }

    /**
     * Creates a DoubleLiteralNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public DoubleLiteralNode makeDoubleLiteralNode(
            Double value)
    {
        DoubleLiteralNode ret = new DoubleLiteralNodeImpl(value, startLocation, stopLocation);
        return ret;
    }

    /**
     * Creates a DoubleLiteralNode.
     * The specified start and stop locations are used.
     */
    @Override
    public DoubleLiteralNode makeDoubleLiteralNode(
            Double value,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        DoubleLiteralNode ret = new DoubleLiteralNodeImpl(value, startLocation, stopLocation);
        return ret;
    }

    /**
     * Creates a AnonymousClassBodyNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public AnonymousClassBodyNode makeAnonymousClassBodyNode(
            ListNode<AnonymousClassMemberNode> members)
    {
        AnonymousClassBodyNode ret = new AnonymousClassBodyNodeImpl(members, startLocation, stopLocation);
        return ret;
    }

    /**
     * Creates a AnonymousClassBodyNode.
     * The specified start and stop locations are used.
     */
    @Override
    public AnonymousClassBodyNode makeAnonymousClassBodyNode(
            ListNode<AnonymousClassMemberNode> members,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        AnonymousClassBodyNode ret = new AnonymousClassBodyNodeImpl(members, startLocation, stopLocation);
        return ret;
    }

    /**
     * Creates a BlockNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public BlockNode makeBlockNode(
            ListNode<BlockStatementNode> statements)
    {
        BlockNode ret = new BlockNodeImpl(statements, startLocation, stopLocation);
        return ret;
    }

    /**
     * Creates a BlockNode.
     * The specified start and stop locations are used.
     */
    @Override
    public BlockNode makeBlockNode(
            ListNode<BlockStatementNode> statements,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        BlockNode ret = new BlockNodeImpl(statements, startLocation, stopLocation);
        return ret;
    }

    /**
     * Creates a SynchronizedNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public SynchronizedNode makeSynchronizedNode(
            ExpressionNode expression,
            BlockNode block)
    {
        SynchronizedNode ret = new SynchronizedNodeImpl(expression, block, startLocation, stopLocation);
        return ret;
    }

    /**
     * Creates a SynchronizedNode.
     * The specified start and stop locations are used.
     */
    @Override
    public SynchronizedNode makeSynchronizedNode(
            ExpressionNode expression,
            BlockNode block,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        SynchronizedNode ret = new SynchronizedNodeImpl(expression, block, startLocation, stopLocation);
        return ret;
    }

    /**
     * Creates a VariableNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public VariableNode makeVariableNode(
            VariableModifiersNode modifiers,
            TypeNode type,
            IdentifierNode identifier)
    {
        VariableNode ret = new VariableNodeImpl(modifiers, type, identifier, startLocation, stopLocation);
        return ret;
    }

    /**
     * Creates a VariableNode.
     * The specified start and stop locations are used.
     */
    @Override
    public VariableNode makeVariableNode(
            VariableModifiersNode modifiers,
            TypeNode type,
            IdentifierNode identifier,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        VariableNode ret = new VariableNodeImpl(modifiers, type, identifier, startLocation, stopLocation);
        return ret;
    }

    /**
     * Creates a CharLiteralNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public CharLiteralNode makeCharLiteralNode(
            Character value)
    {
        CharLiteralNode ret = new CharLiteralNodeImpl(value, startLocation, stopLocation);
        return ret;
    }

    /**
     * Creates a CharLiteralNode.
     * The specified start and stop locations are used.
     */
    @Override
    public CharLiteralNode makeCharLiteralNode(
            Character value,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        CharLiteralNode ret = new CharLiteralNodeImpl(value, startLocation, stopLocation);
        return ret;
    }

    /**
     * Creates a WildcardTypeNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public WildcardTypeNode makeWildcardTypeNode(
            ReferenceTypeNode bound,
            boolean upperBound)
    {
        WildcardTypeNode ret = new WildcardTypeNodeImpl(bound, upperBound, startLocation, stopLocation);
        return ret;
    }

    /**
     * Creates a WildcardTypeNode.
     * The specified start and stop locations are used.
     */
    @Override
    public WildcardTypeNode makeWildcardTypeNode(
            ReferenceTypeNode bound,
            boolean upperBound,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        WildcardTypeNode ret = new WildcardTypeNodeImpl(bound, upperBound, startLocation, stopLocation);
        return ret;
    }

    /**
     * Creates a InlineTypeDeclarationNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public InlineTypeDeclarationNode makeInlineTypeDeclarationNode(
            InlineTypeDeclarableNode declaration)
    {
        InlineTypeDeclarationNode ret = new InlineTypeDeclarationNodeImpl(declaration, startLocation, stopLocation);
        return ret;
    }

    /**
     * Creates a InlineTypeDeclarationNode.
     * The specified start and stop locations are used.
     */
    @Override
    public InlineTypeDeclarationNode makeInlineTypeDeclarationNode(
            InlineTypeDeclarableNode declaration,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        InlineTypeDeclarationNode ret = new InlineTypeDeclarationNodeImpl(declaration, startLocation, stopLocation);
        return ret;
    }

    /**
     * Creates a UnaryExpressionNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public UnaryExpressionNode makeUnaryExpressionNode(
            ExpressionNode expression,
            UnaryOperator operator)
    {
        UnaryExpressionNode ret = new UnaryExpressionNodeImpl(expression, operator, startLocation, stopLocation);
        return ret;
    }

    /**
     * Creates a UnaryExpressionNode.
     * The specified start and stop locations are used.
     */
    @Override
    public UnaryExpressionNode makeUnaryExpressionNode(
            ExpressionNode expression,
            UnaryOperator operator,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        UnaryExpressionNode ret = new UnaryExpressionNodeImpl(expression, operator, startLocation, stopLocation);
        return ret;
    }

    /**
     * Creates a BooleanLiteralNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public BooleanLiteralNode makeBooleanLiteralNode(
            Boolean value)
    {
        BooleanLiteralNode ret = new BooleanLiteralNodeImpl(value, startLocation, stopLocation);
        return ret;
    }

    /**
     * Creates a BooleanLiteralNode.
     * The specified start and stop locations are used.
     */
    @Override
    public BooleanLiteralNode makeBooleanLiteralNode(
            Boolean value,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        BooleanLiteralNode ret = new BooleanLiteralNodeImpl(value, startLocation, stopLocation);
        return ret;
    }

    /**
     * Creates a SwitchNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public SwitchNode makeSwitchNode(
            ExpressionNode expression,
            ListNode<CaseNode> cases)
    {
        SwitchNode ret = new SwitchNodeImpl(expression, cases, startLocation, stopLocation);
        return ret;
    }

    /**
     * Creates a SwitchNode.
     * The specified start and stop locations are used.
     */
    @Override
    public SwitchNode makeSwitchNode(
            ExpressionNode expression,
            ListNode<CaseNode> cases,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        SwitchNode ret = new SwitchNodeImpl(expression, cases, startLocation, stopLocation);
        return ret;
    }

    /**
     * Creates a AlternateConstructorInvocationNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public AlternateConstructorInvocationNode makeAlternateConstructorInvocationNode(
            ListNode<ExpressionNode> arguments,
            ListNode<TypeNode> typeArguments)
    {
        AlternateConstructorInvocationNode ret = new AlternateConstructorInvocationNodeImpl(arguments, typeArguments, startLocation, stopLocation);
        return ret;
    }

    /**
     * Creates a AlternateConstructorInvocationNode.
     * The specified start and stop locations are used.
     */
    @Override
    public AlternateConstructorInvocationNode makeAlternateConstructorInvocationNode(
            ListNode<ExpressionNode> arguments,
            ListNode<TypeNode> typeArguments,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        AlternateConstructorInvocationNode ret = new AlternateConstructorInvocationNodeImpl(arguments, typeArguments, startLocation, stopLocation);
        return ret;
    }

    /**
     * Creates a AnnotationMethodModifiersNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public AnnotationMethodModifiersNode makeAnnotationMethodModifiersNode(
            ListNode<AnnotationNode> annotations)
    {
        AnnotationMethodModifiersNode ret = new AnnotationMethodModifiersNodeImpl(annotations, startLocation, stopLocation);
        return ret;
    }

    /**
     * Creates a AnnotationMethodModifiersNode.
     * The specified start and stop locations are used.
     */
    @Override
    public AnnotationMethodModifiersNode makeAnnotationMethodModifiersNode(
            ListNode<AnnotationNode> annotations,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        AnnotationMethodModifiersNode ret = new AnnotationMethodModifiersNodeImpl(annotations, startLocation, stopLocation);
        return ret;
    }

    /**
     * Creates a ConstructorDeclarationNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public ConstructorDeclarationNode makeConstructorDeclarationNode(
            IdentifierNode identifier,
            ConstructorBodyNode body,
            ConstructorModifiersNode modifiers,
            ListNode<VariableNode> parameters,
            VariableNode varargParameter,
            ListNode<UnparameterizedTypeNode> throwTypes,
            ListNode<TypeParameterNode> typeParameters,
            JavadocNode javadoc)
    {
        ConstructorDeclarationNode ret = new ConstructorDeclarationNodeImpl(identifier, body, modifiers, parameters, varargParameter, throwTypes, typeParameters, javadoc, startLocation, stopLocation);
        return ret;
    }

    /**
     * Creates a ConstructorDeclarationNode.
     * The specified start and stop locations are used.
     */
    @Override
    public ConstructorDeclarationNode makeConstructorDeclarationNode(
            IdentifierNode identifier,
            ConstructorBodyNode body,
            ConstructorModifiersNode modifiers,
            ListNode<VariableNode> parameters,
            VariableNode varargParameter,
            ListNode<UnparameterizedTypeNode> throwTypes,
            ListNode<TypeParameterNode> typeParameters,
            JavadocNode javadoc,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        ConstructorDeclarationNode ret = new ConstructorDeclarationNodeImpl(identifier, body, modifiers, parameters, varargParameter, throwTypes, typeParameters, javadoc, startLocation, stopLocation);
        return ret;
    }

    /**
     * Creates a AnnotationAnnotationValueNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public AnnotationAnnotationValueNode makeAnnotationAnnotationValueNode(
            AnnotationNode annotation)
    {
        AnnotationAnnotationValueNode ret = new AnnotationAnnotationValueNodeImpl(annotation, startLocation, stopLocation);
        return ret;
    }

    /**
     * Creates a AnnotationAnnotationValueNode.
     * The specified start and stop locations are used.
     */
    @Override
    public AnnotationAnnotationValueNode makeAnnotationAnnotationValueNode(
            AnnotationNode annotation,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        AnnotationAnnotationValueNode ret = new AnnotationAnnotationValueNodeImpl(annotation, startLocation, stopLocation);
        return ret;
    }

    /**
     * Creates a ForLoopNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public ForLoopNode makeForLoopNode(
            ForInitializerNode initializer,
            ExpressionNode condition,
            ListNode<StatementExpressionNode> update,
            StatementNode statement)
    {
        ForLoopNode ret = new ForLoopNodeImpl(initializer, condition, update, statement, startLocation, stopLocation);
        return ret;
    }

    /**
     * Creates a ForLoopNode.
     * The specified start and stop locations are used.
     */
    @Override
    public ForLoopNode makeForLoopNode(
            ForInitializerNode initializer,
            ExpressionNode condition,
            ListNode<StatementExpressionNode> update,
            StatementNode statement,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        ForLoopNode ret = new ForLoopNodeImpl(initializer, condition, update, statement, startLocation, stopLocation);
        return ret;
    }

    /**
     * Creates a WhileLoopNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public WhileLoopNode makeWhileLoopNode(
            ExpressionNode condition,
            StatementNode statement)
    {
        WhileLoopNode ret = new WhileLoopNodeImpl(condition, statement, startLocation, stopLocation);
        return ret;
    }

    /**
     * Creates a WhileLoopNode.
     * The specified start and stop locations are used.
     */
    @Override
    public WhileLoopNode makeWhileLoopNode(
            ExpressionNode condition,
            StatementNode statement,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        WhileLoopNode ret = new WhileLoopNodeImpl(condition, statement, startLocation, stopLocation);
        return ret;
    }

    /**
     * Creates a ListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public <T extends Node> ListNode<T> makeListNode(
            List<T> children)
    {
        ListNode<T> ret = new ListNodeImpl<T>(children, startLocation, stopLocation);
        return ret;
    }

    /**
     * Creates a ListNode.
     * The specified start and stop locations are used.
     */
    @Override
    public <T extends Node> ListNode<T> makeListNode(
            List<T> children,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        ListNode<T> ret = new ListNodeImpl<T>(children, startLocation, stopLocation);
        return ret;
    }

    /**
     * Creates a EnumConstantDeclarationNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public EnumConstantDeclarationNode makeEnumConstantDeclarationNode(
            ListNode<AnnotationNode> annotations,
            IdentifierNode identifier,
            ListNode<ExpressionNode> arguments,
            AnonymousClassBodyNode body,
            JavadocNode javadoc)
    {
        EnumConstantDeclarationNode ret = new EnumConstantDeclarationNodeImpl(annotations, identifier, arguments, body, javadoc, startLocation, stopLocation);
        return ret;
    }

    /**
     * Creates a EnumConstantDeclarationNode.
     * The specified start and stop locations are used.
     */
    @Override
    public EnumConstantDeclarationNode makeEnumConstantDeclarationNode(
            ListNode<AnnotationNode> annotations,
            IdentifierNode identifier,
            ListNode<ExpressionNode> arguments,
            AnonymousClassBodyNode body,
            JavadocNode javadoc,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        EnumConstantDeclarationNode ret = new EnumConstantDeclarationNodeImpl(annotations, identifier, arguments, body, javadoc, startLocation, stopLocation);
        return ret;
    }

    /**
     * Creates a BreakNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public BreakNode makeBreakNode(
            IdentifierNode label)
    {
        BreakNode ret = new BreakNodeImpl(label, startLocation, stopLocation);
        return ret;
    }

    /**
     * Creates a BreakNode.
     * The specified start and stop locations are used.
     */
    @Override
    public BreakNode makeBreakNode(
            IdentifierNode label,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        BreakNode ret = new BreakNodeImpl(label, startLocation, stopLocation);
        return ret;
    }

    /**
     * Creates a ConstructorModifiersNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public ConstructorModifiersNode makeConstructorModifiersNode(
            AccessModifier access,
            ListNode<AnnotationNode> annotations)
    {
        ConstructorModifiersNode ret = new ConstructorModifiersNodeImpl(access, annotations, startLocation, stopLocation);
        return ret;
    }

    /**
     * Creates a ConstructorModifiersNode.
     * The specified start and stop locations are used.
     */
    @Override
    public ConstructorModifiersNode makeConstructorModifiersNode(
            AccessModifier access,
            ListNode<AnnotationNode> annotations,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        ConstructorModifiersNode ret = new ConstructorModifiersNodeImpl(access, annotations, startLocation, stopLocation);
        return ret;
    }

    /**
     * Creates a ParameterizedTypeSelectNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public ParameterizedTypeSelectNode makeParameterizedTypeSelectNode(
            ParameterizedTypeNode base,
            DeclaredTypeNode select)
    {
        ParameterizedTypeSelectNode ret = new ParameterizedTypeSelectNodeImpl(base, select, startLocation, stopLocation);
        return ret;
    }

    /**
     * Creates a ParameterizedTypeSelectNode.
     * The specified start and stop locations are used.
     */
    @Override
    public ParameterizedTypeSelectNode makeParameterizedTypeSelectNode(
            ParameterizedTypeNode base,
            DeclaredTypeNode select,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        ParameterizedTypeSelectNode ret = new ParameterizedTypeSelectNodeImpl(base, select, startLocation, stopLocation);
        return ret;
    }

    /**
     * Creates a IdentifierNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public IdentifierNode makeIdentifierNode(
            String identifier)
    {
        IdentifierNode ret = new IdentifierNodeImpl(identifier, startLocation, stopLocation);
        return ret;
    }

    /**
     * Creates a IdentifierNode.
     * The specified start and stop locations are used.
     */
    @Override
    public IdentifierNode makeIdentifierNode(
            String identifier,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        IdentifierNode ret = new IdentifierNodeImpl(identifier, startLocation, stopLocation);
        return ret;
    }

    /**
     * Creates a ArrayTypeNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public ArrayTypeNode makeArrayTypeNode(
            TypeNode type)
    {
        ArrayTypeNode ret = new ArrayTypeNodeImpl(type, startLocation, stopLocation);
        return ret;
    }

    /**
     * Creates a ArrayTypeNode.
     * The specified start and stop locations are used.
     */
    @Override
    public ArrayTypeNode makeArrayTypeNode(
            TypeNode type,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        ArrayTypeNode ret = new ArrayTypeNodeImpl(type, startLocation, stopLocation);
        return ret;
    }

    /**
     * Creates a ArrayInitializerCreationNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public ArrayInitializerCreationNode makeArrayInitializerCreationNode(
            ArrayInitializerNode initializer,
            BaseTypeNode baseType,
            int arrayLevels)
    {
        ArrayInitializerCreationNode ret = new ArrayInitializerCreationNodeImpl(initializer, baseType, arrayLevels, startLocation, stopLocation);
        return ret;
    }

    /**
     * Creates a ArrayInitializerCreationNode.
     * The specified start and stop locations are used.
     */
    @Override
    public ArrayInitializerCreationNode makeArrayInitializerCreationNode(
            ArrayInitializerNode initializer,
            BaseTypeNode baseType,
            int arrayLevels,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        ArrayInitializerCreationNode ret = new ArrayInitializerCreationNodeImpl(initializer, baseType, arrayLevels, startLocation, stopLocation);
        return ret;
    }

    /**
     * Creates a FieldModifiersNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public FieldModifiersNode makeFieldModifiersNode(
            AccessModifier access,
            boolean staticFlag,
            boolean finalFlag,
            boolean transientFlag,
            boolean volatileFlag,
            ListNode<AnnotationNode> annotations)
    {
        FieldModifiersNode ret = new FieldModifiersNodeImpl(access, staticFlag, finalFlag, transientFlag, volatileFlag, annotations, startLocation, stopLocation);
        return ret;
    }

    /**
     * Creates a FieldModifiersNode.
     * The specified start and stop locations are used.
     */
    @Override
    public FieldModifiersNode makeFieldModifiersNode(
            AccessModifier access,
            boolean staticFlag,
            boolean finalFlag,
            boolean transientFlag,
            boolean volatileFlag,
            ListNode<AnnotationNode> annotations,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        FieldModifiersNode ret = new FieldModifiersNodeImpl(access, staticFlag, finalFlag, transientFlag, volatileFlag, annotations, startLocation, stopLocation);
        return ret;
    }

    /**
     * Creates a TypeParameterNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public TypeParameterNode makeTypeParameterNode(
            IdentifierNode identifier,
            ListNode<DeclaredTypeNode> bounds)
    {
        TypeParameterNode ret = new TypeParameterNodeImpl(identifier, bounds, startLocation, stopLocation);
        return ret;
    }

    /**
     * Creates a TypeParameterNode.
     * The specified start and stop locations are used.
     */
    @Override
    public TypeParameterNode makeTypeParameterNode(
            IdentifierNode identifier,
            ListNode<DeclaredTypeNode> bounds,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        TypeParameterNode ret = new TypeParameterNodeImpl(identifier, bounds, startLocation, stopLocation);
        return ret;
    }

    /**
     * Creates a AnnotationMethodDeclarationNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public AnnotationMethodDeclarationNode makeAnnotationMethodDeclarationNode(
            AnnotationMethodModifiersNode modifiers,
            TypeNode type,
            IdentifierNode identifier,
            AnnotationValueNode defaultValue,
            JavadocNode javadoc)
    {
        AnnotationMethodDeclarationNode ret = new AnnotationMethodDeclarationNodeImpl(modifiers, type, identifier, defaultValue, javadoc, startLocation, stopLocation);
        return ret;
    }

    /**
     * Creates a AnnotationMethodDeclarationNode.
     * The specified start and stop locations are used.
     */
    @Override
    public AnnotationMethodDeclarationNode makeAnnotationMethodDeclarationNode(
            AnnotationMethodModifiersNode modifiers,
            TypeNode type,
            IdentifierNode identifier,
            AnnotationValueNode defaultValue,
            JavadocNode javadoc,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        AnnotationMethodDeclarationNode ret = new AnnotationMethodDeclarationNodeImpl(modifiers, type, identifier, defaultValue, javadoc, startLocation, stopLocation);
        return ret;
    }

    /**
     * Creates a ImportSingleTypeNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public ImportSingleTypeNode makeImportSingleTypeNode(
            NameNode name,
            boolean staticImport)
    {
        ImportSingleTypeNode ret = new ImportSingleTypeNodeImpl(name, staticImport, startLocation, stopLocation);
        return ret;
    }

    /**
     * Creates a ImportSingleTypeNode.
     * The specified start and stop locations are used.
     */
    @Override
    public ImportSingleTypeNode makeImportSingleTypeNode(
            NameNode name,
            boolean staticImport,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        ImportSingleTypeNode ret = new ImportSingleTypeNodeImpl(name, staticImport, startLocation, stopLocation);
        return ret;
    }

    /**
     * Creates a FieldDeclarationNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public FieldDeclarationNode makeFieldDeclarationNode(
            FieldModifiersNode modifiers,
            ListNode<VariableDeclaratorNode> declarators,
            JavadocNode javadoc)
    {
        FieldDeclarationNode ret = new FieldDeclarationNodeImpl(modifiers, declarators, javadoc, startLocation, stopLocation);
        return ret;
    }

    /**
     * Creates a FieldDeclarationNode.
     * The specified start and stop locations are used.
     */
    @Override
    public FieldDeclarationNode makeFieldDeclarationNode(
            FieldModifiersNode modifiers,
            ListNode<VariableDeclaratorNode> declarators,
            JavadocNode javadoc,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        FieldDeclarationNode ret = new FieldDeclarationNodeImpl(modifiers, declarators, javadoc, startLocation, stopLocation);
        return ret;
    }

    /**
     * Creates a AnnotationArrayValueNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public AnnotationArrayValueNode makeAnnotationArrayValueNode(
            ListNode<AnnotationValueNode> values)
    {
        AnnotationArrayValueNode ret = new AnnotationArrayValueNodeImpl(values, startLocation, stopLocation);
        return ret;
    }

    /**
     * Creates a AnnotationArrayValueNode.
     * The specified start and stop locations are used.
     */
    @Override
    public AnnotationArrayValueNode makeAnnotationArrayValueNode(
            ListNode<AnnotationValueNode> values,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        AnnotationArrayValueNode ret = new AnnotationArrayValueNodeImpl(values, startLocation, stopLocation);
        return ret;
    }

    /**
     * Creates a SingleElementAnnotationNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public SingleElementAnnotationNode makeSingleElementAnnotationNode(
            AnnotationValueNode value,
            UnparameterizedTypeNode annotationType)
    {
        SingleElementAnnotationNode ret = new SingleElementAnnotationNodeImpl(value, annotationType, startLocation, stopLocation);
        return ret;
    }

    /**
     * Creates a SingleElementAnnotationNode.
     * The specified start and stop locations are used.
     */
    @Override
    public SingleElementAnnotationNode makeSingleElementAnnotationNode(
            AnnotationValueNode value,
            UnparameterizedTypeNode annotationType,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        SingleElementAnnotationNode ret = new SingleElementAnnotationNodeImpl(value, annotationType, startLocation, stopLocation);
        return ret;
    }

    /**
     * Creates a ClassLiteralNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public ClassLiteralNode makeClassLiteralNode(
            LiteralizableTypeNode value)
    {
        ClassLiteralNode ret = new ClassLiteralNodeImpl(value, startLocation, stopLocation);
        return ret;
    }

    /**
     * Creates a ClassLiteralNode.
     * The specified start and stop locations are used.
     */
    @Override
    public ClassLiteralNode makeClassLiteralNode(
            LiteralizableTypeNode value,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        ClassLiteralNode ret = new ClassLiteralNodeImpl(value, startLocation, stopLocation);
        return ret;
    }

    /**
     * Creates a SuperMethodInvocationNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public SuperMethodInvocationNode makeSuperMethodInvocationNode(
            UnparameterizedTypeNode type,
            IdentifierNode identifier,
            ListNode<ExpressionNode> arguments,
            ListNode<TypeNode> typeArguments)
    {
        SuperMethodInvocationNode ret = new SuperMethodInvocationNodeImpl(type, identifier, arguments, typeArguments, startLocation, stopLocation);
        return ret;
    }

    /**
     * Creates a SuperMethodInvocationNode.
     * The specified start and stop locations are used.
     */
    @Override
    public SuperMethodInvocationNode makeSuperMethodInvocationNode(
            UnparameterizedTypeNode type,
            IdentifierNode identifier,
            ListNode<ExpressionNode> arguments,
            ListNode<TypeNode> typeArguments,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        SuperMethodInvocationNode ret = new SuperMethodInvocationNodeImpl(type, identifier, arguments, typeArguments, startLocation, stopLocation);
        return ret;
    }

    /**
     * Creates a ClassModifiersNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public ClassModifiersNode makeClassModifiersNode(
            AccessModifier access,
            boolean abstractFlag,
            boolean staticFlag,
            boolean finalFlag,
            boolean strictfpFlag,
            ListNode<AnnotationNode> annotations)
    {
        ClassModifiersNode ret = new ClassModifiersNodeImpl(access, abstractFlag, staticFlag, finalFlag, strictfpFlag, annotations, startLocation, stopLocation);
        return ret;
    }

    /**
     * Creates a ClassModifiersNode.
     * The specified start and stop locations are used.
     */
    @Override
    public ClassModifiersNode makeClassModifiersNode(
            AccessModifier access,
            boolean abstractFlag,
            boolean staticFlag,
            boolean finalFlag,
            boolean strictfpFlag,
            ListNode<AnnotationNode> annotations,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        ClassModifiersNode ret = new ClassModifiersNodeImpl(access, abstractFlag, staticFlag, finalFlag, strictfpFlag, annotations, startLocation, stopLocation);
        return ret;
    }

    /**
     * Creates a ArrayInitializerNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public ArrayInitializerNode makeArrayInitializerNode(
            ListNode<VariableInitializerNode> initializers)
    {
        ArrayInitializerNode ret = new ArrayInitializerNodeImpl(initializers, startLocation, stopLocation);
        return ret;
    }

    /**
     * Creates a ArrayInitializerNode.
     * The specified start and stop locations are used.
     */
    @Override
    public ArrayInitializerNode makeArrayInitializerNode(
            ListNode<VariableInitializerNode> initializers,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        ArrayInitializerNode ret = new ArrayInitializerNodeImpl(initializers, startLocation, stopLocation);
        return ret;
    }

    /**
     * Creates a AnnotationExpressionValueNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public AnnotationExpressionValueNode makeAnnotationExpressionValueNode(
            NonAssignmentExpressionNode expression)
    {
        AnnotationExpressionValueNode ret = new AnnotationExpressionValueNodeImpl(expression, startLocation, stopLocation);
        return ret;
    }

    /**
     * Creates a AnnotationExpressionValueNode.
     * The specified start and stop locations are used.
     */
    @Override
    public AnnotationExpressionValueNode makeAnnotationExpressionValueNode(
            NonAssignmentExpressionNode expression,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        AnnotationExpressionValueNode ret = new AnnotationExpressionValueNodeImpl(expression, startLocation, stopLocation);
        return ret;
    }

    /**
     * Creates a ReturnNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public ReturnNode makeReturnNode(
            ExpressionNode expression)
    {
        ReturnNode ret = new ReturnNodeImpl(expression, startLocation, stopLocation);
        return ret;
    }

    /**
     * Creates a ReturnNode.
     * The specified start and stop locations are used.
     */
    @Override
    public ReturnNode makeReturnNode(
            ExpressionNode expression,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        ReturnNode ret = new ReturnNodeImpl(expression, startLocation, stopLocation);
        return ret;
    }

    /**
     * Creates a AssignmentNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public AssignmentNode makeAssignmentNode(
            ExpressionNode variable,
            AssignmentOperator operator,
            ExpressionNode expression)
    {
        AssignmentNode ret = new AssignmentNodeImpl(variable, operator, expression, startLocation, stopLocation);
        return ret;
    }

    /**
     * Creates a AssignmentNode.
     * The specified start and stop locations are used.
     */
    @Override
    public AssignmentNode makeAssignmentNode(
            ExpressionNode variable,
            AssignmentOperator operator,
            ExpressionNode expression,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        AssignmentNode ret = new AssignmentNodeImpl(variable, operator, expression, startLocation, stopLocation);
        return ret;
    }

    /**
     * Creates a MethodInvocationByExpressionNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public MethodInvocationByExpressionNode makeMethodInvocationByExpressionNode(
            PrimaryExpressionNode expression,
            IdentifierNode identifier,
            ListNode<ExpressionNode> arguments,
            ListNode<TypeNode> typeArguments)
    {
        MethodInvocationByExpressionNode ret = new MethodInvocationByExpressionNodeImpl(expression, identifier, arguments, typeArguments, startLocation, stopLocation);
        return ret;
    }

    /**
     * Creates a MethodInvocationByExpressionNode.
     * The specified start and stop locations are used.
     */
    @Override
    public MethodInvocationByExpressionNode makeMethodInvocationByExpressionNode(
            PrimaryExpressionNode expression,
            IdentifierNode identifier,
            ListNode<ExpressionNode> arguments,
            ListNode<TypeNode> typeArguments,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        MethodInvocationByExpressionNode ret = new MethodInvocationByExpressionNodeImpl(expression, identifier, arguments, typeArguments, startLocation, stopLocation);
        return ret;
    }

    /**
     * Creates a InstanceOfNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public InstanceOfNode makeInstanceOfNode(
            ExpressionNode expression,
            TypeNode type)
    {
        InstanceOfNode ret = new InstanceOfNodeImpl(expression, type, startLocation, stopLocation);
        return ret;
    }

    /**
     * Creates a InstanceOfNode.
     * The specified start and stop locations are used.
     */
    @Override
    public InstanceOfNode makeInstanceOfNode(
            ExpressionNode expression,
            TypeNode type,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        InstanceOfNode ret = new InstanceOfNodeImpl(expression, type, startLocation, stopLocation);
        return ret;
    }

    /**
     * Creates a ConditionalExpressionNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public ConditionalExpressionNode makeConditionalExpressionNode(
            ExpressionNode condition,
            ExpressionNode trueExpression,
            ExpressionNode falseExpression)
    {
        ConditionalExpressionNode ret = new ConditionalExpressionNodeImpl(condition, trueExpression, falseExpression, startLocation, stopLocation);
        return ret;
    }

    /**
     * Creates a ConditionalExpressionNode.
     * The specified start and stop locations are used.
     */
    @Override
    public ConditionalExpressionNode makeConditionalExpressionNode(
            ExpressionNode condition,
            ExpressionNode trueExpression,
            ExpressionNode falseExpression,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        ConditionalExpressionNode ret = new ConditionalExpressionNodeImpl(condition, trueExpression, falseExpression, startLocation, stopLocation);
        return ret;
    }

    /**
     * Creates a ParenthesizedExpressionNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public ParenthesizedExpressionNode makeParenthesizedExpressionNode(
            ExpressionNode expression)
    {
        ParenthesizedExpressionNode ret = new ParenthesizedExpressionNodeImpl(expression, startLocation, stopLocation);
        return ret;
    }

    /**
     * Creates a ParenthesizedExpressionNode.
     * The specified start and stop locations are used.
     */
    @Override
    public ParenthesizedExpressionNode makeParenthesizedExpressionNode(
            ExpressionNode expression,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        ParenthesizedExpressionNode ret = new ParenthesizedExpressionNodeImpl(expression, startLocation, stopLocation);
        return ret;
    }

    /**
     * Creates a FloatLiteralNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public FloatLiteralNode makeFloatLiteralNode(
            Float value)
    {
        FloatLiteralNode ret = new FloatLiteralNodeImpl(value, startLocation, stopLocation);
        return ret;
    }

    /**
     * Creates a FloatLiteralNode.
     * The specified start and stop locations are used.
     */
    @Override
    public FloatLiteralNode makeFloatLiteralNode(
            Float value,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        FloatLiteralNode ret = new FloatLiteralNodeImpl(value, startLocation, stopLocation);
        return ret;
    }

    /**
     * Creates a MethodInvocationByNameNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public MethodInvocationByNameNode makeMethodInvocationByNameNode(
            NameNode name,
            ListNode<ExpressionNode> arguments,
            ListNode<TypeNode> typeArguments)
    {
        MethodInvocationByNameNode ret = new MethodInvocationByNameNodeImpl(name, arguments, typeArguments, startLocation, stopLocation);
        return ret;
    }

    /**
     * Creates a MethodInvocationByNameNode.
     * The specified start and stop locations are used.
     */
    @Override
    public MethodInvocationByNameNode makeMethodInvocationByNameNode(
            NameNode name,
            ListNode<ExpressionNode> arguments,
            ListNode<TypeNode> typeArguments,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        MethodInvocationByNameNode ret = new MethodInvocationByNameNodeImpl(name, arguments, typeArguments, startLocation, stopLocation);
        return ret;
    }

    /**
     * Creates a ParameterizedTypeNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public ParameterizedTypeNode makeParameterizedTypeNode(
            UnparameterizedTypeNode baseType,
            ListNode<TypeArgumentNode> typeArguments)
    {
        ParameterizedTypeNode ret = new ParameterizedTypeNodeImpl(baseType, typeArguments, startLocation, stopLocation);
        return ret;
    }

    /**
     * Creates a ParameterizedTypeNode.
     * The specified start and stop locations are used.
     */
    @Override
    public ParameterizedTypeNode makeParameterizedTypeNode(
            UnparameterizedTypeNode baseType,
            ListNode<TypeArgumentNode> typeArguments,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        ParameterizedTypeNode ret = new ParameterizedTypeNodeImpl(baseType, typeArguments, startLocation, stopLocation);
        return ret;
    }

    /**
     * Creates a InterfaceDeclarationNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public InterfaceDeclarationNode makeInterfaceDeclarationNode(
            InterfaceModifiersNode modifiers,
            ListNode<TypeNode> extendsClause,
            InterfaceBodyNode body,
            ListNode<TypeParameterNode> typeParameters,
            IdentifierNode identifier,
            JavadocNode javadoc)
    {
        InterfaceDeclarationNode ret = new InterfaceDeclarationNodeImpl(modifiers, extendsClause, body, typeParameters, identifier, javadoc, startLocation, stopLocation);
        return ret;
    }

    /**
     * Creates a InterfaceDeclarationNode.
     * The specified start and stop locations are used.
     */
    @Override
    public InterfaceDeclarationNode makeInterfaceDeclarationNode(
            InterfaceModifiersNode modifiers,
            ListNode<TypeNode> extendsClause,
            InterfaceBodyNode body,
            ListNode<TypeParameterNode> typeParameters,
            IdentifierNode identifier,
            JavadocNode javadoc,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        InterfaceDeclarationNode ret = new InterfaceDeclarationNodeImpl(modifiers, extendsClause, body, typeParameters, identifier, javadoc, startLocation, stopLocation);
        return ret;
    }

    /**
     * Creates a ForInitializerDeclarationNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public ForInitializerDeclarationNode makeForInitializerDeclarationNode(
            VariableDeclarationNode declaration)
    {
        ForInitializerDeclarationNode ret = new ForInitializerDeclarationNodeImpl(declaration, startLocation, stopLocation);
        return ret;
    }

    /**
     * Creates a ForInitializerDeclarationNode.
     * The specified start and stop locations are used.
     */
    @Override
    public ForInitializerDeclarationNode makeForInitializerDeclarationNode(
            VariableDeclarationNode declaration,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        ForInitializerDeclarationNode ret = new ForInitializerDeclarationNodeImpl(declaration, startLocation, stopLocation);
        return ret;
    }

    /**
     * Creates a ConstructorBodyNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public ConstructorBodyNode makeConstructorBodyNode(
            ConstructorInvocationNode constructorInvocation,
            ListNode<BlockStatementNode> statements)
    {
        ConstructorBodyNode ret = new ConstructorBodyNodeImpl(constructorInvocation, statements, startLocation, stopLocation);
        return ret;
    }

    /**
     * Creates a ConstructorBodyNode.
     * The specified start and stop locations are used.
     */
    @Override
    public ConstructorBodyNode makeConstructorBodyNode(
            ConstructorInvocationNode constructorInvocation,
            ListNode<BlockStatementNode> statements,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        ConstructorBodyNode ret = new ConstructorBodyNodeImpl(constructorInvocation, statements, startLocation, stopLocation);
        return ret;
    }

    /**
     * Creates a FieldAccessByNameNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public FieldAccessByNameNode makeFieldAccessByNameNode(
            NameNode name)
    {
        FieldAccessByNameNode ret = new FieldAccessByNameNodeImpl(name, startLocation, stopLocation);
        return ret;
    }

    /**
     * Creates a FieldAccessByNameNode.
     * The specified start and stop locations are used.
     */
    @Override
    public FieldAccessByNameNode makeFieldAccessByNameNode(
            NameNode name,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        FieldAccessByNameNode ret = new FieldAccessByNameNodeImpl(name, startLocation, stopLocation);
        return ret;
    }

    /**
     * Creates a UnqualifiedClassInstantiationNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public UnqualifiedClassInstantiationNode makeUnqualifiedClassInstantiationNode(
            DeclaredTypeNode type,
            ListNode<TypeArgumentNode> constructorTypeArguments,
            ListNode<ExpressionNode> arguments,
            AnonymousClassBodyNode body)
    {
        UnqualifiedClassInstantiationNode ret = new UnqualifiedClassInstantiationNodeImpl(type, constructorTypeArguments, arguments, body, startLocation, stopLocation);
        return ret;
    }

    /**
     * Creates a UnqualifiedClassInstantiationNode.
     * The specified start and stop locations are used.
     */
    @Override
    public UnqualifiedClassInstantiationNode makeUnqualifiedClassInstantiationNode(
            DeclaredTypeNode type,
            ListNode<TypeArgumentNode> constructorTypeArguments,
            ListNode<ExpressionNode> arguments,
            AnonymousClassBodyNode body,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        UnqualifiedClassInstantiationNode ret = new UnqualifiedClassInstantiationNodeImpl(type, constructorTypeArguments, arguments, body, startLocation, stopLocation);
        return ret;
    }

    /**
     * Creates a SimpleNameNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public SimpleNameNode makeSimpleNameNode(
            IdentifierNode identifier,
            NameCategory category)
    {
        SimpleNameNode ret = new SimpleNameNodeImpl(identifier, category, startLocation, stopLocation);
        return ret;
    }

    /**
     * Creates a SimpleNameNode.
     * The specified start and stop locations are used.
     */
    @Override
    public SimpleNameNode makeSimpleNameNode(
            IdentifierNode identifier,
            NameCategory category,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        SimpleNameNode ret = new SimpleNameNodeImpl(identifier, category, startLocation, stopLocation);
        return ret;
    }

    /**
     * Creates a ArrayInstantiatorCreationNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public ArrayInstantiatorCreationNode makeArrayInstantiatorCreationNode(
            ListNode<ExpressionNode> dimExpressions,
            BaseTypeNode baseType,
            int arrayLevels)
    {
        ArrayInstantiatorCreationNode ret = new ArrayInstantiatorCreationNodeImpl(dimExpressions, baseType, arrayLevels, startLocation, stopLocation);
        return ret;
    }

    /**
     * Creates a ArrayInstantiatorCreationNode.
     * The specified start and stop locations are used.
     */
    @Override
    public ArrayInstantiatorCreationNode makeArrayInstantiatorCreationNode(
            ListNode<ExpressionNode> dimExpressions,
            BaseTypeNode baseType,
            int arrayLevels,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        ArrayInstantiatorCreationNode ret = new ArrayInstantiatorCreationNodeImpl(dimExpressions, baseType, arrayLevels, startLocation, stopLocation);
        return ret;
    }

    /**
     * Creates a MethodModifiersNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public MethodModifiersNode makeMethodModifiersNode(
            AccessModifier access,
            boolean abstractFlag,
            boolean staticFlag,
            boolean finalFlag,
            boolean synchronizedFlag,
            boolean nativeFlag,
            boolean strictfpFlag,
            ListNode<AnnotationNode> annotations)
    {
        MethodModifiersNode ret = new MethodModifiersNodeImpl(access, abstractFlag, staticFlag, finalFlag, synchronizedFlag, nativeFlag, strictfpFlag, annotations, startLocation, stopLocation);
        return ret;
    }

    /**
     * Creates a MethodModifiersNode.
     * The specified start and stop locations are used.
     */
    @Override
    public MethodModifiersNode makeMethodModifiersNode(
            AccessModifier access,
            boolean abstractFlag,
            boolean staticFlag,
            boolean finalFlag,
            boolean synchronizedFlag,
            boolean nativeFlag,
            boolean strictfpFlag,
            ListNode<AnnotationNode> annotations,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        MethodModifiersNode ret = new MethodModifiersNodeImpl(access, abstractFlag, staticFlag, finalFlag, synchronizedFlag, nativeFlag, strictfpFlag, annotations, startLocation, stopLocation);
        return ret;
    }

    /**
     * Creates a ClassBodyNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public ClassBodyNode makeClassBodyNode(
            ListNode<ClassMemberNode> members)
    {
        ClassBodyNode ret = new ClassBodyNodeImpl(members, startLocation, stopLocation);
        return ret;
    }

    /**
     * Creates a ClassBodyNode.
     * The specified start and stop locations are used.
     */
    @Override
    public ClassBodyNode makeClassBodyNode(
            ListNode<ClassMemberNode> members,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        ClassBodyNode ret = new ClassBodyNodeImpl(members, startLocation, stopLocation);
        return ret;
    }

    /**
     * Creates a IfNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public IfNode makeIfNode(
            ExpressionNode condition,
            StatementNode thenStatement,
            StatementNode elseStatement)
    {
        IfNode ret = new IfNodeImpl(condition, thenStatement, elseStatement, startLocation, stopLocation);
        return ret;
    }

    /**
     * Creates a IfNode.
     * The specified start and stop locations are used.
     */
    @Override
    public IfNode makeIfNode(
            ExpressionNode condition,
            StatementNode thenStatement,
            StatementNode elseStatement,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        IfNode ret = new IfNodeImpl(condition, thenStatement, elseStatement, startLocation, stopLocation);
        return ret;
    }

    /**
     * Creates a IntLiteralNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public IntLiteralNode makeIntLiteralNode(
            Integer value)
    {
        IntLiteralNode ret = new IntLiteralNodeImpl(value, startLocation, stopLocation);
        return ret;
    }

    /**
     * Creates a IntLiteralNode.
     * The specified start and stop locations are used.
     */
    @Override
    public IntLiteralNode makeIntLiteralNode(
            Integer value,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        IntLiteralNode ret = new IntLiteralNodeImpl(value, startLocation, stopLocation);
        return ret;
    }

    /**
     * Creates a NullLiteralNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public NullLiteralNode makeNullLiteralNode(
            Void value)
    {
        NullLiteralNode ret = new NullLiteralNodeImpl(value, startLocation, stopLocation);
        return ret;
    }

    /**
     * Creates a NullLiteralNode.
     * The specified start and stop locations are used.
     */
    @Override
    public NullLiteralNode makeNullLiteralNode(
            Void value,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        NullLiteralNode ret = new NullLiteralNodeImpl(value, startLocation, stopLocation);
        return ret;
    }

    /**
     * Creates a JavadocNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public JavadocNode makeJavadocNode(
            String text)
    {
        JavadocNode ret = new JavadocNodeImpl(text, startLocation, stopLocation);
        return ret;
    }

    /**
     * Creates a JavadocNode.
     * The specified start and stop locations are used.
     */
    @Override
    public JavadocNode makeJavadocNode(
            String text,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        JavadocNode ret = new JavadocNodeImpl(text, startLocation, stopLocation);
        return ret;
    }

    /**
     * Creates a MethodDeclarationNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public MethodDeclarationNode makeMethodDeclarationNode(
            BlockNode body,
            MethodModifiersNode modifiers,
            IdentifierNode identifier,
            ListNode<VariableNode> parameters,
            VariableNode varargParameter,
            TypeNode returnType,
            ListNode<UnparameterizedTypeNode> throwTypes,
            ListNode<TypeParameterNode> typeParameters,
            JavadocNode javadoc)
    {
        MethodDeclarationNode ret = new MethodDeclarationNodeImpl(body, modifiers, identifier, parameters, varargParameter, returnType, throwTypes, typeParameters, javadoc, startLocation, stopLocation);
        return ret;
    }

    /**
     * Creates a MethodDeclarationNode.
     * The specified start and stop locations are used.
     */
    @Override
    public MethodDeclarationNode makeMethodDeclarationNode(
            BlockNode body,
            MethodModifiersNode modifiers,
            IdentifierNode identifier,
            ListNode<VariableNode> parameters,
            VariableNode varargParameter,
            TypeNode returnType,
            ListNode<UnparameterizedTypeNode> throwTypes,
            ListNode<TypeParameterNode> typeParameters,
            JavadocNode javadoc,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        MethodDeclarationNode ret = new MethodDeclarationNodeImpl(body, modifiers, identifier, parameters, varargParameter, returnType, throwTypes, typeParameters, javadoc, startLocation, stopLocation);
        return ret;
    }

}
