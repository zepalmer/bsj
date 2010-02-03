package edu.jhu.cs.bsj.compiler.ast.util;

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

/**
 * This class allows simple decoration of all node construction methods on a node factory.
 *
 * @author Zachary Palmer
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public abstract class BsjNodeFactoryDecorator implements BsjNodeFactory
{
    /** The backing factory. */
    BsjNodeFactory factory;

    /**
     * Creates a new decorating factory.
     * @param factory The backing factory.
     */
    public BsjNodeFactoryDecorator(BsjNodeFactory factory)
    {
        this.factory = factory;
    }
    
    /**
     * The "before" decoration method.  This method is called before every node creation.
     */
    protected abstract void before();

    /**
     * The "after" decoration method.  This method is called after every node creation.
     * @param node The node that was just created.
     */
    protected abstract void after(Node node);
    
	/**
	 * Retrieves the starting source location used for new nodes.
	 * 
	 * @return The start location used for new nodes. <code>null</code> is a permissible value and indicates that no
	 *         information is available.
	 */
	public BsjSourceLocation getStartSourceLocation()
	{
		return this.factory.getStartSourceLocation();
	}

	/**
	 * Retrieves the ending source location used for new nodes.
	 * 
	 * @return The stop location used for new nodes. <code>null</code> is a permissible value and indicates that no
	 *         information is available.
	 */
	public BsjSourceLocation getStopSourceLocation()
	{
		return this.factory.getStopSourceLocation();
	}

    /**
     * Changes the starting source location used for new nodes.
     * @param startLocation The new start location to use for new nodes.  <code>null</code> is a permissible value and
     *                      indicates that no information is available.
     */
    @Override
    public void setStartSourceLocation(BsjSourceLocation startLocation)
    {
        this.factory.setStartSourceLocation(startLocation);
    }

    /**
     * Changes the ending source location used for new nodes.
     * @param stopLocation The new stop location to use for new nodes.  <code>null</code> is a permissible value and
     *                      indicates that no information is available.
     */
    @Override
    public void setStopSourceLocation(BsjSourceLocation stopLocation)
    {
        this.factory.setStopSourceLocation(stopLocation);
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
        this.before();
        AssertStatementNode node = factory.makeAssertStatementNode(testExpression, messageExpression);
        this.after(node);
        return node;
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
        this.before();
        AssertStatementNode node = factory.makeAssertStatementNode(testExpression, messageExpression, startLocation, stopLocation);
        this.after(node);
        return node;
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
        this.before();
        UnaryStatementExpressionNode node = factory.makeUnaryStatementExpressionNode(expression, operator);
        this.after(node);
        return node;
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
        this.before();
        UnaryStatementExpressionNode node = factory.makeUnaryStatementExpressionNode(expression, operator, startLocation, stopLocation);
        this.after(node);
        return node;
    }

    /**
     * Creates a InterfaceBodyNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public InterfaceBodyNode makeInterfaceBodyNode(
            ListNode<InterfaceMemberNode> members)
    {
        this.before();
        InterfaceBodyNode node = factory.makeInterfaceBodyNode(members);
        this.after(node);
        return node;
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
        this.before();
        InterfaceBodyNode node = factory.makeInterfaceBodyNode(members, startLocation, stopLocation);
        this.after(node);
        return node;
    }

    /**
     * Creates a ExpressionStatementNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public ExpressionStatementNode makeExpressionStatementNode(
            StatementExpressionNode expression)
    {
        this.before();
        ExpressionStatementNode node = factory.makeExpressionStatementNode(expression);
        this.after(node);
        return node;
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
        this.before();
        ExpressionStatementNode node = factory.makeExpressionStatementNode(expression, startLocation, stopLocation);
        this.after(node);
        return node;
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
        this.before();
        ClassDeclarationNode node = factory.makeClassDeclarationNode(modifiers, extendsClause, implementsClause, body, typeParameters, identifier, javadoc);
        this.after(node);
        return node;
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
        this.before();
        ClassDeclarationNode node = factory.makeClassDeclarationNode(modifiers, extendsClause, implementsClause, body, typeParameters, identifier, javadoc, startLocation, stopLocation);
        this.after(node);
        return node;
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
        this.before();
        EnhancedForLoopNode node = factory.makeEnhancedForLoopNode(variable, expression, statement);
        this.after(node);
        return node;
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
        this.before();
        EnhancedForLoopNode node = factory.makeEnhancedForLoopNode(variable, expression, statement, startLocation, stopLocation);
        this.after(node);
        return node;
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
        this.before();
        ArrayAccessNode node = factory.makeArrayAccessNode(arrayExpression, indexExpression);
        this.after(node);
        return node;
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
        this.before();
        ArrayAccessNode node = factory.makeArrayAccessNode(arrayExpression, indexExpression, startLocation, stopLocation);
        this.after(node);
        return node;
    }

    /**
     * Creates a LongLiteralNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public LongLiteralNode makeLongLiteralNode(
            Long value)
    {
        this.before();
        LongLiteralNode node = factory.makeLongLiteralNode(value);
        this.after(node);
        return node;
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
        this.before();
        LongLiteralNode node = factory.makeLongLiteralNode(value, startLocation, stopLocation);
        this.after(node);
        return node;
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
        this.before();
        QualifiedNameNode node = factory.makeQualifiedNameNode(base, identifier, category);
        this.after(node);
        return node;
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
        this.before();
        QualifiedNameNode node = factory.makeQualifiedNameNode(base, identifier, category, startLocation, stopLocation);
        this.after(node);
        return node;
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
        this.before();
        CaseNode node = factory.makeCaseNode(expression, statements);
        this.after(node);
        return node;
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
        this.before();
        CaseNode node = factory.makeCaseNode(expression, statements, startLocation, stopLocation);
        this.after(node);
        return node;
    }

    /**
     * Creates a VoidStatementNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public VoidStatementNode makeVoidStatementNode(
)
    {
        this.before();
        VoidStatementNode node = factory.makeVoidStatementNode();
        this.after(node);
        return node;
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
        this.before();
        VoidStatementNode node = factory.makeVoidStatementNode(startLocation, stopLocation);
        this.after(node);
        return node;
    }

    /**
     * Creates a CodeLiteralNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public CodeLiteralNode makeCodeLiteralNode(
            Node value)
    {
        this.before();
        CodeLiteralNode node = factory.makeCodeLiteralNode(value);
        this.after(node);
        return node;
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
        this.before();
        CodeLiteralNode node = factory.makeCodeLiteralNode(value, startLocation, stopLocation);
        this.after(node);
        return node;
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
        this.before();
        ImportOnDemandNode node = factory.makeImportOnDemandNode(name, staticImport);
        this.after(node);
        return node;
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
        this.before();
        ImportOnDemandNode node = factory.makeImportOnDemandNode(name, staticImport, startLocation, stopLocation);
        this.after(node);
        return node;
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
        this.before();
        VariableModifiersNode node = factory.makeVariableModifiersNode(finalFlag, annotations);
        this.after(node);
        return node;
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
        this.before();
        VariableModifiersNode node = factory.makeVariableModifiersNode(finalFlag, annotations, startLocation, stopLocation);
        this.after(node);
        return node;
    }

    /**
     * Creates a BlockStatementMetaprogramAnchorNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public BlockStatementMetaprogramAnchorNode makeBlockStatementMetaprogramAnchorNode(
            MetaprogramNode metaprogram)
    {
        this.before();
        BlockStatementMetaprogramAnchorNode node = factory.makeBlockStatementMetaprogramAnchorNode(metaprogram);
        this.after(node);
        return node;
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
        this.before();
        BlockStatementMetaprogramAnchorNode node = factory.makeBlockStatementMetaprogramAnchorNode(replacement, metaprogram, startLocation, stopLocation);
        this.after(node);
        return node;
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
        this.before();
        InterfaceModifiersNode node = factory.makeInterfaceModifiersNode(access, staticFlag, strictfpFlag, annotations);
        this.after(node);
        return node;
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
        this.before();
        InterfaceModifiersNode node = factory.makeInterfaceModifiersNode(access, staticFlag, strictfpFlag, annotations, startLocation, stopLocation);
        this.after(node);
        return node;
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
        this.before();
        SuperclassConstructorInvocationNode node = factory.makeSuperclassConstructorInvocationNode(qualifyingExpression, arguments, typeArguments);
        this.after(node);
        return node;
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
        this.before();
        SuperclassConstructorInvocationNode node = factory.makeSuperclassConstructorInvocationNode(qualifyingExpression, arguments, typeArguments, startLocation, stopLocation);
        this.after(node);
        return node;
    }

    /**
     * Creates a PrimitiveTypeNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public PrimitiveTypeNode makePrimitiveTypeNode(
            PrimitiveType primitiveType)
    {
        this.before();
        PrimitiveTypeNode node = factory.makePrimitiveTypeNode(primitiveType);
        this.after(node);
        return node;
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
        this.before();
        PrimitiveTypeNode node = factory.makePrimitiveTypeNode(primitiveType, startLocation, stopLocation);
        this.after(node);
        return node;
    }

    /**
     * Creates a MetaprogramNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public MetaprogramNode makeMetaprogramNode(
            ListNode<BlockStatementNode> body)
    {
        this.before();
        MetaprogramNode node = factory.makeMetaprogramNode(body);
        this.after(node);
        return node;
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
        this.before();
        MetaprogramNode node = factory.makeMetaprogramNode(body, startLocation, stopLocation);
        this.after(node);
        return node;
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
        this.before();
        InitializerDeclarationNode node = factory.makeInitializerDeclarationNode(staticInitializer, body);
        this.after(node);
        return node;
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
        this.before();
        InitializerDeclarationNode node = factory.makeInitializerDeclarationNode(staticInitializer, body, startLocation, stopLocation);
        this.after(node);
        return node;
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
        this.before();
        EnumBodyNode node = factory.makeEnumBodyNode(constants, members);
        this.after(node);
        return node;
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
        this.before();
        EnumBodyNode node = factory.makeEnumBodyNode(constants, members, startLocation, stopLocation);
        this.after(node);
        return node;
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
        this.before();
        TryNode node = factory.makeTryNode(block, catches, finallyBlock);
        this.after(node);
        return node;
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
        this.before();
        TryNode node = factory.makeTryNode(block, catches, finallyBlock, startLocation, stopLocation);
        this.after(node);
        return node;
    }

    /**
     * Creates a ThisNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public ThisNode makeThisNode(
            UnparameterizedTypeNode type)
    {
        this.before();
        ThisNode node = factory.makeThisNode(type);
        this.after(node);
        return node;
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
        this.before();
        ThisNode node = factory.makeThisNode(type, startLocation, stopLocation);
        this.after(node);
        return node;
    }

    /**
     * Creates a TypeDeclarationMetaprogramAnchorNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public TypeDeclarationMetaprogramAnchorNode makeTypeDeclarationMetaprogramAnchorNode(
            MetaprogramNode metaprogram)
    {
        this.before();
        TypeDeclarationMetaprogramAnchorNode node = factory.makeTypeDeclarationMetaprogramAnchorNode(metaprogram);
        this.after(node);
        return node;
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
        this.before();
        TypeDeclarationMetaprogramAnchorNode node = factory.makeTypeDeclarationMetaprogramAnchorNode(replacement, metaprogram, startLocation, stopLocation);
        this.after(node);
        return node;
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
        this.before();
        EnumDeclarationNode node = factory.makeEnumDeclarationNode(modifiers, implementsClause, body, identifier, javadoc);
        this.after(node);
        return node;
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
        this.before();
        EnumDeclarationNode node = factory.makeEnumDeclarationNode(modifiers, implementsClause, body, identifier, javadoc, startLocation, stopLocation);
        this.after(node);
        return node;
    }

    /**
     * Creates a VoidTypeNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public VoidTypeNode makeVoidTypeNode(
)
    {
        this.before();
        VoidTypeNode node = factory.makeVoidTypeNode();
        this.after(node);
        return node;
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
        this.before();
        VoidTypeNode node = factory.makeVoidTypeNode(startLocation, stopLocation);
        this.after(node);
        return node;
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
        this.before();
        VariableDeclarationNode node = factory.makeVariableDeclarationNode(modifiers, declarators);
        this.after(node);
        return node;
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
        this.before();
        VariableDeclarationNode node = factory.makeVariableDeclarationNode(modifiers, declarators, startLocation, stopLocation);
        this.after(node);
        return node;
    }

    /**
     * Creates a AnnotationBodyNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public AnnotationBodyNode makeAnnotationBodyNode(
            ListNode<AnnotationMemberNode> members)
    {
        this.before();
        AnnotationBodyNode node = factory.makeAnnotationBodyNode(members);
        this.after(node);
        return node;
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
        this.before();
        AnnotationBodyNode node = factory.makeAnnotationBodyNode(members, startLocation, stopLocation);
        this.after(node);
        return node;
    }

    /**
     * Creates a UnparameterizedTypeNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public UnparameterizedTypeNode makeUnparameterizedTypeNode(
            NameNode name)
    {
        this.before();
        UnparameterizedTypeNode node = factory.makeUnparameterizedTypeNode(name);
        this.after(node);
        return node;
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
        this.before();
        UnparameterizedTypeNode node = factory.makeUnparameterizedTypeNode(name, startLocation, stopLocation);
        this.after(node);
        return node;
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
        this.before();
        VariableDeclaratorNode node = factory.makeVariableDeclaratorNode(type, name, initializer);
        this.after(node);
        return node;
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
        this.before();
        VariableDeclaratorNode node = factory.makeVariableDeclaratorNode(type, name, initializer, startLocation, stopLocation);
        this.after(node);
        return node;
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
        this.before();
        AnnotationModifiersNode node = factory.makeAnnotationModifiersNode(access, staticFlag, strictfpFlag, annotations);
        this.after(node);
        return node;
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
        this.before();
        AnnotationModifiersNode node = factory.makeAnnotationModifiersNode(access, staticFlag, strictfpFlag, annotations, startLocation, stopLocation);
        this.after(node);
        return node;
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
        this.before();
        FieldAccessByExpressionNode node = factory.makeFieldAccessByExpressionNode(expression, identifier);
        this.after(node);
        return node;
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
        this.before();
        FieldAccessByExpressionNode node = factory.makeFieldAccessByExpressionNode(expression, identifier, startLocation, stopLocation);
        this.after(node);
        return node;
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
        this.before();
        SuperFieldAccessNode node = factory.makeSuperFieldAccessNode(type, identifier);
        this.after(node);
        return node;
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
        this.before();
        SuperFieldAccessNode node = factory.makeSuperFieldAccessNode(type, identifier, startLocation, stopLocation);
        this.after(node);
        return node;
    }

    /**
     * Creates a ThrowNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public ThrowNode makeThrowNode(
            ExpressionNode expression)
    {
        this.before();
        ThrowNode node = factory.makeThrowNode(expression);
        this.after(node);
        return node;
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
        this.before();
        ThrowNode node = factory.makeThrowNode(expression, startLocation, stopLocation);
        this.after(node);
        return node;
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
        this.before();
        EnumModifiersNode node = factory.makeEnumModifiersNode(access, strictfpFlag, annotations);
        this.after(node);
        return node;
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
        this.before();
        EnumModifiersNode node = factory.makeEnumModifiersNode(access, strictfpFlag, annotations, startLocation, stopLocation);
        this.after(node);
        return node;
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
        this.before();
        CatchNode node = factory.makeCatchNode(block, parameter);
        this.after(node);
        return node;
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
        this.before();
        CatchNode node = factory.makeCatchNode(block, parameter, startLocation, stopLocation);
        this.after(node);
        return node;
    }

    /**
     * Creates a VoidTypeDeclarationNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public VoidTypeDeclarationNode makeVoidTypeDeclarationNode(
)
    {
        this.before();
        VoidTypeDeclarationNode node = factory.makeVoidTypeDeclarationNode();
        this.after(node);
        return node;
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
        this.before();
        VoidTypeDeclarationNode node = factory.makeVoidTypeDeclarationNode(startLocation, stopLocation);
        this.after(node);
        return node;
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
        this.before();
        NormalAnnotationNode node = factory.makeNormalAnnotationNode(arguments, annotationType);
        this.after(node);
        return node;
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
        this.before();
        NormalAnnotationNode node = factory.makeNormalAnnotationNode(arguments, annotationType, startLocation, stopLocation);
        this.after(node);
        return node;
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
        this.before();
        DoWhileLoopNode node = factory.makeDoWhileLoopNode(condition, statement);
        this.after(node);
        return node;
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
        this.before();
        DoWhileLoopNode node = factory.makeDoWhileLoopNode(condition, statement, startLocation, stopLocation);
        this.after(node);
        return node;
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
        this.before();
        QualifiedClassInstantiationNode node = factory.makeQualifiedClassInstantiationNode(enclosingExpression, identifier, typeArguments, constructorTypeArguments, arguments, body);
        this.after(node);
        return node;
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
        this.before();
        QualifiedClassInstantiationNode node = factory.makeQualifiedClassInstantiationNode(enclosingExpression, identifier, typeArguments, constructorTypeArguments, arguments, body, startLocation, stopLocation);
        this.after(node);
        return node;
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
        this.before();
        TypeCastNode node = factory.makeTypeCastNode(expression, type);
        this.after(node);
        return node;
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
        this.before();
        TypeCastNode node = factory.makeTypeCastNode(expression, type, startLocation, stopLocation);
        this.after(node);
        return node;
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
        this.before();
        LabeledStatementNode node = factory.makeLabeledStatementNode(label, statement);
        this.after(node);
        return node;
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
        this.before();
        LabeledStatementNode node = factory.makeLabeledStatementNode(label, statement, startLocation, stopLocation);
        this.after(node);
        return node;
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
        this.before();
        BinaryExpressionNode node = factory.makeBinaryExpressionNode(leftOperand, rightOperand, operator);
        this.after(node);
        return node;
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
        this.before();
        BinaryExpressionNode node = factory.makeBinaryExpressionNode(leftOperand, rightOperand, operator, startLocation, stopLocation);
        this.after(node);
        return node;
    }

    /**
     * Creates a ForInitializerExpressionNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public ForInitializerExpressionNode makeForInitializerExpressionNode(
            ListNode<StatementExpressionNode> expressions)
    {
        this.before();
        ForInitializerExpressionNode node = factory.makeForInitializerExpressionNode(expressions);
        this.after(node);
        return node;
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
        this.before();
        ForInitializerExpressionNode node = factory.makeForInitializerExpressionNode(expressions, startLocation, stopLocation);
        this.after(node);
        return node;
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
        this.before();
        PackageDeclarationNode node = factory.makePackageDeclarationNode(name, annotations);
        this.after(node);
        return node;
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
        this.before();
        PackageDeclarationNode node = factory.makePackageDeclarationNode(name, annotations, startLocation, stopLocation);
        this.after(node);
        return node;
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
        this.before();
        AnnotationDeclarationNode node = factory.makeAnnotationDeclarationNode(modifiers, body, identifier, javadoc);
        this.after(node);
        return node;
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
        this.before();
        AnnotationDeclarationNode node = factory.makeAnnotationDeclarationNode(modifiers, body, identifier, javadoc, startLocation, stopLocation);
        this.after(node);
        return node;
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
        this.before();
        CompilationUnitNode node = factory.makeCompilationUnitNode(packageDeclaration, imports, typeDecls);
        this.after(node);
        return node;
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
        this.before();
        CompilationUnitNode node = factory.makeCompilationUnitNode(packageDeclaration, imports, typeDecls, startLocation, stopLocation);
        this.after(node);
        return node;
    }

    /**
     * Creates a ContinueNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public ContinueNode makeContinueNode(
            IdentifierNode label)
    {
        this.before();
        ContinueNode node = factory.makeContinueNode(label);
        this.after(node);
        return node;
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
        this.before();
        ContinueNode node = factory.makeContinueNode(label, startLocation, stopLocation);
        this.after(node);
        return node;
    }

    /**
     * Creates a StringLiteralNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public StringLiteralNode makeStringLiteralNode(
            String value)
    {
        this.before();
        StringLiteralNode node = factory.makeStringLiteralNode(value);
        this.after(node);
        return node;
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
        this.before();
        StringLiteralNode node = factory.makeStringLiteralNode(value, startLocation, stopLocation);
        this.after(node);
        return node;
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
        this.before();
        AnnotationElementNode node = factory.makeAnnotationElementNode(identifier, value);
        this.after(node);
        return node;
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
        this.before();
        AnnotationElementNode node = factory.makeAnnotationElementNode(identifier, value, startLocation, stopLocation);
        this.after(node);
        return node;
    }

    /**
     * Creates a DoubleLiteralNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public DoubleLiteralNode makeDoubleLiteralNode(
            Double value)
    {
        this.before();
        DoubleLiteralNode node = factory.makeDoubleLiteralNode(value);
        this.after(node);
        return node;
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
        this.before();
        DoubleLiteralNode node = factory.makeDoubleLiteralNode(value, startLocation, stopLocation);
        this.after(node);
        return node;
    }

    /**
     * Creates a AnonymousClassBodyNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public AnonymousClassBodyNode makeAnonymousClassBodyNode(
            ListNode<AnonymousClassMemberNode> members)
    {
        this.before();
        AnonymousClassBodyNode node = factory.makeAnonymousClassBodyNode(members);
        this.after(node);
        return node;
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
        this.before();
        AnonymousClassBodyNode node = factory.makeAnonymousClassBodyNode(members, startLocation, stopLocation);
        this.after(node);
        return node;
    }

    /**
     * Creates a BlockNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public BlockNode makeBlockNode(
            ListNode<BlockStatementNode> statements)
    {
        this.before();
        BlockNode node = factory.makeBlockNode(statements);
        this.after(node);
        return node;
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
        this.before();
        BlockNode node = factory.makeBlockNode(statements, startLocation, stopLocation);
        this.after(node);
        return node;
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
        this.before();
        SynchronizedNode node = factory.makeSynchronizedNode(expression, block);
        this.after(node);
        return node;
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
        this.before();
        SynchronizedNode node = factory.makeSynchronizedNode(expression, block, startLocation, stopLocation);
        this.after(node);
        return node;
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
        this.before();
        VariableNode node = factory.makeVariableNode(modifiers, type, identifier);
        this.after(node);
        return node;
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
        this.before();
        VariableNode node = factory.makeVariableNode(modifiers, type, identifier, startLocation, stopLocation);
        this.after(node);
        return node;
    }

    /**
     * Creates a CharLiteralNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public CharLiteralNode makeCharLiteralNode(
            Character value)
    {
        this.before();
        CharLiteralNode node = factory.makeCharLiteralNode(value);
        this.after(node);
        return node;
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
        this.before();
        CharLiteralNode node = factory.makeCharLiteralNode(value, startLocation, stopLocation);
        this.after(node);
        return node;
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
        this.before();
        WildcardTypeNode node = factory.makeWildcardTypeNode(bound, upperBound);
        this.after(node);
        return node;
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
        this.before();
        WildcardTypeNode node = factory.makeWildcardTypeNode(bound, upperBound, startLocation, stopLocation);
        this.after(node);
        return node;
    }

    /**
     * Creates a InlineTypeDeclarationNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public InlineTypeDeclarationNode makeInlineTypeDeclarationNode(
            InlineTypeDeclarableNode declaration)
    {
        this.before();
        InlineTypeDeclarationNode node = factory.makeInlineTypeDeclarationNode(declaration);
        this.after(node);
        return node;
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
        this.before();
        InlineTypeDeclarationNode node = factory.makeInlineTypeDeclarationNode(declaration, startLocation, stopLocation);
        this.after(node);
        return node;
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
        this.before();
        UnaryExpressionNode node = factory.makeUnaryExpressionNode(expression, operator);
        this.after(node);
        return node;
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
        this.before();
        UnaryExpressionNode node = factory.makeUnaryExpressionNode(expression, operator, startLocation, stopLocation);
        this.after(node);
        return node;
    }

    /**
     * Creates a BooleanLiteralNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public BooleanLiteralNode makeBooleanLiteralNode(
            Boolean value)
    {
        this.before();
        BooleanLiteralNode node = factory.makeBooleanLiteralNode(value);
        this.after(node);
        return node;
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
        this.before();
        BooleanLiteralNode node = factory.makeBooleanLiteralNode(value, startLocation, stopLocation);
        this.after(node);
        return node;
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
        this.before();
        SwitchNode node = factory.makeSwitchNode(expression, cases);
        this.after(node);
        return node;
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
        this.before();
        SwitchNode node = factory.makeSwitchNode(expression, cases, startLocation, stopLocation);
        this.after(node);
        return node;
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
        this.before();
        AlternateConstructorInvocationNode node = factory.makeAlternateConstructorInvocationNode(arguments, typeArguments);
        this.after(node);
        return node;
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
        this.before();
        AlternateConstructorInvocationNode node = factory.makeAlternateConstructorInvocationNode(arguments, typeArguments, startLocation, stopLocation);
        this.after(node);
        return node;
    }

    /**
     * Creates a AnnotationMethodModifiersNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public AnnotationMethodModifiersNode makeAnnotationMethodModifiersNode(
            ListNode<AnnotationNode> annotations)
    {
        this.before();
        AnnotationMethodModifiersNode node = factory.makeAnnotationMethodModifiersNode(annotations);
        this.after(node);
        return node;
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
        this.before();
        AnnotationMethodModifiersNode node = factory.makeAnnotationMethodModifiersNode(annotations, startLocation, stopLocation);
        this.after(node);
        return node;
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
        this.before();
        ConstructorDeclarationNode node = factory.makeConstructorDeclarationNode(identifier, body, modifiers, parameters, varargParameter, throwTypes, typeParameters, javadoc);
        this.after(node);
        return node;
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
        this.before();
        ConstructorDeclarationNode node = factory.makeConstructorDeclarationNode(identifier, body, modifiers, parameters, varargParameter, throwTypes, typeParameters, javadoc, startLocation, stopLocation);
        this.after(node);
        return node;
    }

    /**
     * Creates a AnnotationAnnotationValueNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public AnnotationAnnotationValueNode makeAnnotationAnnotationValueNode(
            AnnotationNode annotation)
    {
        this.before();
        AnnotationAnnotationValueNode node = factory.makeAnnotationAnnotationValueNode(annotation);
        this.after(node);
        return node;
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
        this.before();
        AnnotationAnnotationValueNode node = factory.makeAnnotationAnnotationValueNode(annotation, startLocation, stopLocation);
        this.after(node);
        return node;
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
        this.before();
        ForLoopNode node = factory.makeForLoopNode(initializer, condition, update, statement);
        this.after(node);
        return node;
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
        this.before();
        ForLoopNode node = factory.makeForLoopNode(initializer, condition, update, statement, startLocation, stopLocation);
        this.after(node);
        return node;
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
        this.before();
        WhileLoopNode node = factory.makeWhileLoopNode(condition, statement);
        this.after(node);
        return node;
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
        this.before();
        WhileLoopNode node = factory.makeWhileLoopNode(condition, statement, startLocation, stopLocation);
        this.after(node);
        return node;
    }

    /**
     * Creates a ListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public <T extends Node> ListNode<T> makeListNode(
            List<T> children)
    {
        this.before();
        ListNode<T> node = factory.makeListNode(children);
        this.after(node);
        return node;
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
        this.before();
        ListNode<T> node = factory.makeListNode(children, startLocation, stopLocation);
        this.after(node);
        return node;
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
        this.before();
        EnumConstantDeclarationNode node = factory.makeEnumConstantDeclarationNode(annotations, identifier, arguments, body, javadoc);
        this.after(node);
        return node;
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
        this.before();
        EnumConstantDeclarationNode node = factory.makeEnumConstantDeclarationNode(annotations, identifier, arguments, body, javadoc, startLocation, stopLocation);
        this.after(node);
        return node;
    }

    /**
     * Creates a BreakNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public BreakNode makeBreakNode(
            IdentifierNode label)
    {
        this.before();
        BreakNode node = factory.makeBreakNode(label);
        this.after(node);
        return node;
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
        this.before();
        BreakNode node = factory.makeBreakNode(label, startLocation, stopLocation);
        this.after(node);
        return node;
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
        this.before();
        ConstructorModifiersNode node = factory.makeConstructorModifiersNode(access, annotations);
        this.after(node);
        return node;
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
        this.before();
        ConstructorModifiersNode node = factory.makeConstructorModifiersNode(access, annotations, startLocation, stopLocation);
        this.after(node);
        return node;
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
        this.before();
        ParameterizedTypeSelectNode node = factory.makeParameterizedTypeSelectNode(base, select);
        this.after(node);
        return node;
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
        this.before();
        ParameterizedTypeSelectNode node = factory.makeParameterizedTypeSelectNode(base, select, startLocation, stopLocation);
        this.after(node);
        return node;
    }

    /**
     * Creates a IdentifierNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public IdentifierNode makeIdentifierNode(
            String identifier)
    {
        this.before();
        IdentifierNode node = factory.makeIdentifierNode(identifier);
        this.after(node);
        return node;
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
        this.before();
        IdentifierNode node = factory.makeIdentifierNode(identifier, startLocation, stopLocation);
        this.after(node);
        return node;
    }

    /**
     * Creates a ArrayTypeNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public ArrayTypeNode makeArrayTypeNode(
            TypeNode type)
    {
        this.before();
        ArrayTypeNode node = factory.makeArrayTypeNode(type);
        this.after(node);
        return node;
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
        this.before();
        ArrayTypeNode node = factory.makeArrayTypeNode(type, startLocation, stopLocation);
        this.after(node);
        return node;
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
        this.before();
        ArrayInitializerCreationNode node = factory.makeArrayInitializerCreationNode(initializer, baseType, arrayLevels);
        this.after(node);
        return node;
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
        this.before();
        ArrayInitializerCreationNode node = factory.makeArrayInitializerCreationNode(initializer, baseType, arrayLevels, startLocation, stopLocation);
        this.after(node);
        return node;
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
        this.before();
        FieldModifiersNode node = factory.makeFieldModifiersNode(access, staticFlag, finalFlag, transientFlag, volatileFlag, annotations);
        this.after(node);
        return node;
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
        this.before();
        FieldModifiersNode node = factory.makeFieldModifiersNode(access, staticFlag, finalFlag, transientFlag, volatileFlag, annotations, startLocation, stopLocation);
        this.after(node);
        return node;
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
        this.before();
        TypeParameterNode node = factory.makeTypeParameterNode(identifier, bounds);
        this.after(node);
        return node;
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
        this.before();
        TypeParameterNode node = factory.makeTypeParameterNode(identifier, bounds, startLocation, stopLocation);
        this.after(node);
        return node;
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
        this.before();
        AnnotationMethodDeclarationNode node = factory.makeAnnotationMethodDeclarationNode(modifiers, type, identifier, defaultValue, javadoc);
        this.after(node);
        return node;
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
        this.before();
        AnnotationMethodDeclarationNode node = factory.makeAnnotationMethodDeclarationNode(modifiers, type, identifier, defaultValue, javadoc, startLocation, stopLocation);
        this.after(node);
        return node;
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
        this.before();
        ImportSingleTypeNode node = factory.makeImportSingleTypeNode(name, staticImport);
        this.after(node);
        return node;
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
        this.before();
        ImportSingleTypeNode node = factory.makeImportSingleTypeNode(name, staticImport, startLocation, stopLocation);
        this.after(node);
        return node;
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
        this.before();
        FieldDeclarationNode node = factory.makeFieldDeclarationNode(modifiers, declarators, javadoc);
        this.after(node);
        return node;
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
        this.before();
        FieldDeclarationNode node = factory.makeFieldDeclarationNode(modifiers, declarators, javadoc, startLocation, stopLocation);
        this.after(node);
        return node;
    }

    /**
     * Creates a AnnotationArrayValueNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public AnnotationArrayValueNode makeAnnotationArrayValueNode(
            ListNode<AnnotationValueNode> values)
    {
        this.before();
        AnnotationArrayValueNode node = factory.makeAnnotationArrayValueNode(values);
        this.after(node);
        return node;
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
        this.before();
        AnnotationArrayValueNode node = factory.makeAnnotationArrayValueNode(values, startLocation, stopLocation);
        this.after(node);
        return node;
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
        this.before();
        SingleElementAnnotationNode node = factory.makeSingleElementAnnotationNode(value, annotationType);
        this.after(node);
        return node;
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
        this.before();
        SingleElementAnnotationNode node = factory.makeSingleElementAnnotationNode(value, annotationType, startLocation, stopLocation);
        this.after(node);
        return node;
    }

    /**
     * Creates a ClassLiteralNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public ClassLiteralNode makeClassLiteralNode(
            LiteralizableTypeNode value)
    {
        this.before();
        ClassLiteralNode node = factory.makeClassLiteralNode(value);
        this.after(node);
        return node;
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
        this.before();
        ClassLiteralNode node = factory.makeClassLiteralNode(value, startLocation, stopLocation);
        this.after(node);
        return node;
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
        this.before();
        SuperMethodInvocationNode node = factory.makeSuperMethodInvocationNode(type, identifier, arguments, typeArguments);
        this.after(node);
        return node;
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
        this.before();
        SuperMethodInvocationNode node = factory.makeSuperMethodInvocationNode(type, identifier, arguments, typeArguments, startLocation, stopLocation);
        this.after(node);
        return node;
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
        this.before();
        ClassModifiersNode node = factory.makeClassModifiersNode(access, abstractFlag, staticFlag, finalFlag, strictfpFlag, annotations);
        this.after(node);
        return node;
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
        this.before();
        ClassModifiersNode node = factory.makeClassModifiersNode(access, abstractFlag, staticFlag, finalFlag, strictfpFlag, annotations, startLocation, stopLocation);
        this.after(node);
        return node;
    }

    /**
     * Creates a ArrayInitializerNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public ArrayInitializerNode makeArrayInitializerNode(
            ListNode<VariableInitializerNode> initializers)
    {
        this.before();
        ArrayInitializerNode node = factory.makeArrayInitializerNode(initializers);
        this.after(node);
        return node;
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
        this.before();
        ArrayInitializerNode node = factory.makeArrayInitializerNode(initializers, startLocation, stopLocation);
        this.after(node);
        return node;
    }

    /**
     * Creates a AnnotationExpressionValueNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public AnnotationExpressionValueNode makeAnnotationExpressionValueNode(
            NonAssignmentExpressionNode expression)
    {
        this.before();
        AnnotationExpressionValueNode node = factory.makeAnnotationExpressionValueNode(expression);
        this.after(node);
        return node;
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
        this.before();
        AnnotationExpressionValueNode node = factory.makeAnnotationExpressionValueNode(expression, startLocation, stopLocation);
        this.after(node);
        return node;
    }

    /**
     * Creates a ReturnNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public ReturnNode makeReturnNode(
            ExpressionNode expression)
    {
        this.before();
        ReturnNode node = factory.makeReturnNode(expression);
        this.after(node);
        return node;
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
        this.before();
        ReturnNode node = factory.makeReturnNode(expression, startLocation, stopLocation);
        this.after(node);
        return node;
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
        this.before();
        AssignmentNode node = factory.makeAssignmentNode(variable, operator, expression);
        this.after(node);
        return node;
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
        this.before();
        AssignmentNode node = factory.makeAssignmentNode(variable, operator, expression, startLocation, stopLocation);
        this.after(node);
        return node;
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
        this.before();
        MethodInvocationByExpressionNode node = factory.makeMethodInvocationByExpressionNode(expression, identifier, arguments, typeArguments);
        this.after(node);
        return node;
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
        this.before();
        MethodInvocationByExpressionNode node = factory.makeMethodInvocationByExpressionNode(expression, identifier, arguments, typeArguments, startLocation, stopLocation);
        this.after(node);
        return node;
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
        this.before();
        InstanceOfNode node = factory.makeInstanceOfNode(expression, type);
        this.after(node);
        return node;
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
        this.before();
        InstanceOfNode node = factory.makeInstanceOfNode(expression, type, startLocation, stopLocation);
        this.after(node);
        return node;
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
        this.before();
        ConditionalExpressionNode node = factory.makeConditionalExpressionNode(condition, trueExpression, falseExpression);
        this.after(node);
        return node;
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
        this.before();
        ConditionalExpressionNode node = factory.makeConditionalExpressionNode(condition, trueExpression, falseExpression, startLocation, stopLocation);
        this.after(node);
        return node;
    }

    /**
     * Creates a ParenthesizedExpressionNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public ParenthesizedExpressionNode makeParenthesizedExpressionNode(
            ExpressionNode expression)
    {
        this.before();
        ParenthesizedExpressionNode node = factory.makeParenthesizedExpressionNode(expression);
        this.after(node);
        return node;
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
        this.before();
        ParenthesizedExpressionNode node = factory.makeParenthesizedExpressionNode(expression, startLocation, stopLocation);
        this.after(node);
        return node;
    }

    /**
     * Creates a FloatLiteralNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public FloatLiteralNode makeFloatLiteralNode(
            Float value)
    {
        this.before();
        FloatLiteralNode node = factory.makeFloatLiteralNode(value);
        this.after(node);
        return node;
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
        this.before();
        FloatLiteralNode node = factory.makeFloatLiteralNode(value, startLocation, stopLocation);
        this.after(node);
        return node;
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
        this.before();
        MethodInvocationByNameNode node = factory.makeMethodInvocationByNameNode(name, arguments, typeArguments);
        this.after(node);
        return node;
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
        this.before();
        MethodInvocationByNameNode node = factory.makeMethodInvocationByNameNode(name, arguments, typeArguments, startLocation, stopLocation);
        this.after(node);
        return node;
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
        this.before();
        ParameterizedTypeNode node = factory.makeParameterizedTypeNode(baseType, typeArguments);
        this.after(node);
        return node;
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
        this.before();
        ParameterizedTypeNode node = factory.makeParameterizedTypeNode(baseType, typeArguments, startLocation, stopLocation);
        this.after(node);
        return node;
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
        this.before();
        InterfaceDeclarationNode node = factory.makeInterfaceDeclarationNode(modifiers, extendsClause, body, typeParameters, identifier, javadoc);
        this.after(node);
        return node;
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
        this.before();
        InterfaceDeclarationNode node = factory.makeInterfaceDeclarationNode(modifiers, extendsClause, body, typeParameters, identifier, javadoc, startLocation, stopLocation);
        this.after(node);
        return node;
    }

    /**
     * Creates a ForInitializerDeclarationNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public ForInitializerDeclarationNode makeForInitializerDeclarationNode(
            VariableDeclarationNode declaration)
    {
        this.before();
        ForInitializerDeclarationNode node = factory.makeForInitializerDeclarationNode(declaration);
        this.after(node);
        return node;
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
        this.before();
        ForInitializerDeclarationNode node = factory.makeForInitializerDeclarationNode(declaration, startLocation, stopLocation);
        this.after(node);
        return node;
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
        this.before();
        ConstructorBodyNode node = factory.makeConstructorBodyNode(constructorInvocation, statements);
        this.after(node);
        return node;
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
        this.before();
        ConstructorBodyNode node = factory.makeConstructorBodyNode(constructorInvocation, statements, startLocation, stopLocation);
        this.after(node);
        return node;
    }

    /**
     * Creates a FieldAccessByNameNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public FieldAccessByNameNode makeFieldAccessByNameNode(
            NameNode name)
    {
        this.before();
        FieldAccessByNameNode node = factory.makeFieldAccessByNameNode(name);
        this.after(node);
        return node;
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
        this.before();
        FieldAccessByNameNode node = factory.makeFieldAccessByNameNode(name, startLocation, stopLocation);
        this.after(node);
        return node;
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
        this.before();
        UnqualifiedClassInstantiationNode node = factory.makeUnqualifiedClassInstantiationNode(type, constructorTypeArguments, arguments, body);
        this.after(node);
        return node;
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
        this.before();
        UnqualifiedClassInstantiationNode node = factory.makeUnqualifiedClassInstantiationNode(type, constructorTypeArguments, arguments, body, startLocation, stopLocation);
        this.after(node);
        return node;
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
        this.before();
        SimpleNameNode node = factory.makeSimpleNameNode(identifier, category);
        this.after(node);
        return node;
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
        this.before();
        SimpleNameNode node = factory.makeSimpleNameNode(identifier, category, startLocation, stopLocation);
        this.after(node);
        return node;
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
        this.before();
        ArrayInstantiatorCreationNode node = factory.makeArrayInstantiatorCreationNode(dimExpressions, baseType, arrayLevels);
        this.after(node);
        return node;
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
        this.before();
        ArrayInstantiatorCreationNode node = factory.makeArrayInstantiatorCreationNode(dimExpressions, baseType, arrayLevels, startLocation, stopLocation);
        this.after(node);
        return node;
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
        this.before();
        MethodModifiersNode node = factory.makeMethodModifiersNode(access, abstractFlag, staticFlag, finalFlag, synchronizedFlag, nativeFlag, strictfpFlag, annotations);
        this.after(node);
        return node;
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
        this.before();
        MethodModifiersNode node = factory.makeMethodModifiersNode(access, abstractFlag, staticFlag, finalFlag, synchronizedFlag, nativeFlag, strictfpFlag, annotations, startLocation, stopLocation);
        this.after(node);
        return node;
    }

    /**
     * Creates a ClassBodyNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public ClassBodyNode makeClassBodyNode(
            ListNode<ClassMemberNode> members)
    {
        this.before();
        ClassBodyNode node = factory.makeClassBodyNode(members);
        this.after(node);
        return node;
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
        this.before();
        ClassBodyNode node = factory.makeClassBodyNode(members, startLocation, stopLocation);
        this.after(node);
        return node;
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
        this.before();
        IfNode node = factory.makeIfNode(condition, thenStatement, elseStatement);
        this.after(node);
        return node;
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
        this.before();
        IfNode node = factory.makeIfNode(condition, thenStatement, elseStatement, startLocation, stopLocation);
        this.after(node);
        return node;
    }

    /**
     * Creates a IntLiteralNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public IntLiteralNode makeIntLiteralNode(
            Integer value)
    {
        this.before();
        IntLiteralNode node = factory.makeIntLiteralNode(value);
        this.after(node);
        return node;
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
        this.before();
        IntLiteralNode node = factory.makeIntLiteralNode(value, startLocation, stopLocation);
        this.after(node);
        return node;
    }

    /**
     * Creates a NullLiteralNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public NullLiteralNode makeNullLiteralNode(
            Void value)
    {
        this.before();
        NullLiteralNode node = factory.makeNullLiteralNode(value);
        this.after(node);
        return node;
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
        this.before();
        NullLiteralNode node = factory.makeNullLiteralNode(value, startLocation, stopLocation);
        this.after(node);
        return node;
    }

    /**
     * Creates a JavadocNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public JavadocNode makeJavadocNode(
            String text)
    {
        this.before();
        JavadocNode node = factory.makeJavadocNode(text);
        this.after(node);
        return node;
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
        this.before();
        JavadocNode node = factory.makeJavadocNode(text, startLocation, stopLocation);
        this.after(node);
        return node;
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
        this.before();
        MethodDeclarationNode node = factory.makeMethodDeclarationNode(body, modifiers, identifier, parameters, varargParameter, returnType, throwTypes, typeParameters, javadoc);
        this.after(node);
        return node;
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
        this.before();
        MethodDeclarationNode node = factory.makeMethodDeclarationNode(body, modifiers, identifier, parameters, varargParameter, returnType, throwTypes, typeParameters, javadoc, startLocation, stopLocation);
        this.after(node);
        return node;
    }

}
