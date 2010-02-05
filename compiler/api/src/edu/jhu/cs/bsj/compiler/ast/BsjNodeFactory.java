package edu.jhu.cs.bsj.compiler.ast;

import java.util.List;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.node.*;
import edu.jhu.cs.bsj.compiler.ast.node.meta.BlockStatementMetaprogramAnchorNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.CodeLiteralNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.TypeDeclarationMetaprogramAnchorNode;

/**
 * This interface is implemented by any object which can act as a factory for BSJ nodes.  It
 * is strongly advisable to ensure that all nodes in a given AST are produced from the same
 * factory, although the urgency of this restriction is implementation-dependent.
 *
 * @author Zachary Palmer
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface BsjNodeFactory
{
	/**
	 * Retrieves the starting source location used for new nodes.
	 * 
	 * @return The start location used for new nodes. <code>null</code> is a permissible value and indicates that no
	 *         information is available.
	 */
	public BsjSourceLocation getStartSourceLocation();

	/**
	 * Retrieves the ending source location used for new nodes.
	 * 
	 * @return The stop location used for new nodes. <code>null</code> is a permissible value and indicates that no
	 *         information is available.
	 */
	public BsjSourceLocation getStopSourceLocation();

    /**
     * Changes the starting source location used for new nodes.
     * @param startLocation The new start location to use for new nodes.  <code>null</code> is a permissible value and
     *                      indicates that no information is available.
     */
    public void setStartSourceLocation(BsjSourceLocation startLocation);

    /**
     * Changes the ending source location used for new nodes.
     * @param stopLocation The new stop location to use for new nodes.  <code>null</code> is a permissible value and
     *                      indicates that no information is available.
     */
    public void setStopSourceLocation(BsjSourceLocation stopLocation);

    /**
     * Creates a AlternateConstructorInvocationNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public AlternateConstructorInvocationNode makeAlternateConstructorInvocationNode(
            ListNode<ExpressionNode> arguments,
            ListNode<TypeNode> typeArguments);

    /**
     * Creates a AlternateConstructorInvocationNode.
     * The specified start and stop locations are used.
     */
    public AlternateConstructorInvocationNode makeAlternateConstructorInvocationNode(
            ListNode<ExpressionNode> arguments,
            ListNode<TypeNode> typeArguments,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);

    /**
     * Creates a AnnotationAnnotationValueNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public AnnotationAnnotationValueNode makeAnnotationAnnotationValueNode(
            AnnotationNode annotation);

    /**
     * Creates a AnnotationAnnotationValueNode.
     * The specified start and stop locations are used.
     */
    public AnnotationAnnotationValueNode makeAnnotationAnnotationValueNode(
            AnnotationNode annotation,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);

    /**
     * Creates a AnnotationArrayValueNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public AnnotationArrayValueNode makeAnnotationArrayValueNode(
            ListNode<AnnotationValueNode> values);

    /**
     * Creates a AnnotationArrayValueNode.
     * The specified start and stop locations are used.
     */
    public AnnotationArrayValueNode makeAnnotationArrayValueNode(
            ListNode<AnnotationValueNode> values,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);

    /**
     * Creates a AnnotationBodyNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public AnnotationBodyNode makeAnnotationBodyNode(
            ListNode<AnnotationMemberNode> members);

    /**
     * Creates a AnnotationBodyNode.
     * The specified start and stop locations are used.
     */
    public AnnotationBodyNode makeAnnotationBodyNode(
            ListNode<AnnotationMemberNode> members,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);

    /**
     * Creates a AnnotationDeclarationNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public AnnotationDeclarationNode makeAnnotationDeclarationNode(
            AnnotationModifiersNode modifiers,
            AnnotationBodyNode body,
            IdentifierNode identifier,
            JavadocNode javadoc);

    /**
     * Creates a AnnotationDeclarationNode.
     * The specified start and stop locations are used.
     */
    public AnnotationDeclarationNode makeAnnotationDeclarationNode(
            AnnotationModifiersNode modifiers,
            AnnotationBodyNode body,
            IdentifierNode identifier,
            JavadocNode javadoc,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);

    /**
     * Creates a AnnotationElementNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public AnnotationElementNode makeAnnotationElementNode(
            IdentifierNode identifier,
            AnnotationValueNode value);

    /**
     * Creates a AnnotationElementNode.
     * The specified start and stop locations are used.
     */
    public AnnotationElementNode makeAnnotationElementNode(
            IdentifierNode identifier,
            AnnotationValueNode value,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);

    /**
     * Creates a AnnotationExpressionValueNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public AnnotationExpressionValueNode makeAnnotationExpressionValueNode(
            NonAssignmentExpressionNode expression);

    /**
     * Creates a AnnotationExpressionValueNode.
     * The specified start and stop locations are used.
     */
    public AnnotationExpressionValueNode makeAnnotationExpressionValueNode(
            NonAssignmentExpressionNode expression,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);

    /**
     * Creates a AnnotationMethodDeclarationNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public AnnotationMethodDeclarationNode makeAnnotationMethodDeclarationNode(
            AnnotationMethodModifiersNode modifiers,
            TypeNode type,
            IdentifierNode identifier,
            AnnotationValueNode defaultValue,
            JavadocNode javadoc);

    /**
     * Creates a AnnotationMethodDeclarationNode.
     * The specified start and stop locations are used.
     */
    public AnnotationMethodDeclarationNode makeAnnotationMethodDeclarationNode(
            AnnotationMethodModifiersNode modifiers,
            TypeNode type,
            IdentifierNode identifier,
            AnnotationValueNode defaultValue,
            JavadocNode javadoc,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);

    /**
     * Creates a AnnotationMethodModifiersNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public AnnotationMethodModifiersNode makeAnnotationMethodModifiersNode(
            ListNode<AnnotationNode> annotations);

    /**
     * Creates a AnnotationMethodModifiersNode.
     * The specified start and stop locations are used.
     */
    public AnnotationMethodModifiersNode makeAnnotationMethodModifiersNode(
            ListNode<AnnotationNode> annotations,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);

    /**
     * Creates a AnnotationModifiersNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public AnnotationModifiersNode makeAnnotationModifiersNode(
            AccessModifier access,
            boolean staticFlag,
            boolean strictfpFlag,
            ListNode<AnnotationNode> annotations);

    /**
     * Creates a AnnotationModifiersNode.
     * The specified start and stop locations are used.
     */
    public AnnotationModifiersNode makeAnnotationModifiersNode(
            AccessModifier access,
            boolean staticFlag,
            boolean strictfpFlag,
            ListNode<AnnotationNode> annotations,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);

    /**
     * Creates a AnonymousClassBodyNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public AnonymousClassBodyNode makeAnonymousClassBodyNode(
            ListNode<AnonymousClassMemberNode> members);

    /**
     * Creates a AnonymousClassBodyNode.
     * The specified start and stop locations are used.
     */
    public AnonymousClassBodyNode makeAnonymousClassBodyNode(
            ListNode<AnonymousClassMemberNode> members,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);

    /**
     * Creates a ArrayAccessNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public ArrayAccessNode makeArrayAccessNode(
            RestrictedPrimaryExpressionNode arrayExpression,
            ExpressionNode indexExpression);

    /**
     * Creates a ArrayAccessNode.
     * The specified start and stop locations are used.
     */
    public ArrayAccessNode makeArrayAccessNode(
            RestrictedPrimaryExpressionNode arrayExpression,
            ExpressionNode indexExpression,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);

    /**
     * Creates a ArrayInitializerCreationNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public ArrayInitializerCreationNode makeArrayInitializerCreationNode(
            ArrayInitializerNode initializer,
            BaseTypeNode baseType,
            int arrayLevels);

    /**
     * Creates a ArrayInitializerCreationNode.
     * The specified start and stop locations are used.
     */
    public ArrayInitializerCreationNode makeArrayInitializerCreationNode(
            ArrayInitializerNode initializer,
            BaseTypeNode baseType,
            int arrayLevels,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);

    /**
     * Creates a ArrayInitializerNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public ArrayInitializerNode makeArrayInitializerNode(
            ListNode<VariableInitializerNode> initializers);

    /**
     * Creates a ArrayInitializerNode.
     * The specified start and stop locations are used.
     */
    public ArrayInitializerNode makeArrayInitializerNode(
            ListNode<VariableInitializerNode> initializers,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);

    /**
     * Creates a ArrayInstantiatorCreationNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public ArrayInstantiatorCreationNode makeArrayInstantiatorCreationNode(
            ListNode<ExpressionNode> dimExpressions,
            BaseTypeNode baseType,
            int arrayLevels);

    /**
     * Creates a ArrayInstantiatorCreationNode.
     * The specified start and stop locations are used.
     */
    public ArrayInstantiatorCreationNode makeArrayInstantiatorCreationNode(
            ListNode<ExpressionNode> dimExpressions,
            BaseTypeNode baseType,
            int arrayLevels,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);

    /**
     * Creates a ArrayTypeNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public ArrayTypeNode makeArrayTypeNode(
            TypeNode type);

    /**
     * Creates a ArrayTypeNode.
     * The specified start and stop locations are used.
     */
    public ArrayTypeNode makeArrayTypeNode(
            TypeNode type,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);

    /**
     * Creates a AssertStatementNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public AssertStatementNode makeAssertStatementNode(
            ExpressionNode testExpression,
            ExpressionNode messageExpression);

    /**
     * Creates a AssertStatementNode.
     * The specified start and stop locations are used.
     */
    public AssertStatementNode makeAssertStatementNode(
            ExpressionNode testExpression,
            ExpressionNode messageExpression,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);

    /**
     * Creates a AssignmentNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public AssignmentNode makeAssignmentNode(
            ExpressionNode variable,
            AssignmentOperator operator,
            ExpressionNode expression);

    /**
     * Creates a AssignmentNode.
     * The specified start and stop locations are used.
     */
    public AssignmentNode makeAssignmentNode(
            ExpressionNode variable,
            AssignmentOperator operator,
            ExpressionNode expression,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);

    /**
     * Creates a BinaryExpressionNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public BinaryExpressionNode makeBinaryExpressionNode(
            ExpressionNode leftOperand,
            ExpressionNode rightOperand,
            BinaryOperator operator);

    /**
     * Creates a BinaryExpressionNode.
     * The specified start and stop locations are used.
     */
    public BinaryExpressionNode makeBinaryExpressionNode(
            ExpressionNode leftOperand,
            ExpressionNode rightOperand,
            BinaryOperator operator,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);

    /**
     * Creates a BlockNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public BlockNode makeBlockNode(
            ListNode<BlockStatementNode> statements);

    /**
     * Creates a BlockNode.
     * The specified start and stop locations are used.
     */
    public BlockNode makeBlockNode(
            ListNode<BlockStatementNode> statements,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);

    /**
     * Creates a BlockStatementMetaprogramAnchorNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public BlockStatementMetaprogramAnchorNode makeBlockStatementMetaprogramAnchorNode(
            MetaprogramNode metaprogram);

    /**
     * Creates a BlockStatementMetaprogramAnchorNode.
     * The specified start and stop locations are used.
     */
    public BlockStatementMetaprogramAnchorNode makeBlockStatementMetaprogramAnchorNode(
            BlockStatementNode replacement,
            MetaprogramNode metaprogram,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);

    /**
     * Creates a BooleanLiteralNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public BooleanLiteralNode makeBooleanLiteralNode(
            Boolean value);

    /**
     * Creates a BooleanLiteralNode.
     * The specified start and stop locations are used.
     */
    public BooleanLiteralNode makeBooleanLiteralNode(
            Boolean value,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);

    /**
     * Creates a BreakNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public BreakNode makeBreakNode(
            IdentifierNode label);

    /**
     * Creates a BreakNode.
     * The specified start and stop locations are used.
     */
    public BreakNode makeBreakNode(
            IdentifierNode label,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);

    /**
     * Creates a CaseNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public CaseNode makeCaseNode(
            ExpressionNode expression,
            ListNode<BlockStatementNode> statements);

    /**
     * Creates a CaseNode.
     * The specified start and stop locations are used.
     */
    public CaseNode makeCaseNode(
            ExpressionNode expression,
            ListNode<BlockStatementNode> statements,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);

    /**
     * Creates a CatchNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public CatchNode makeCatchNode(
            BlockNode block,
            VariableNode parameter);

    /**
     * Creates a CatchNode.
     * The specified start and stop locations are used.
     */
    public CatchNode makeCatchNode(
            BlockNode block,
            VariableNode parameter,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);

    /**
     * Creates a CharLiteralNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public CharLiteralNode makeCharLiteralNode(
            Character value);

    /**
     * Creates a CharLiteralNode.
     * The specified start and stop locations are used.
     */
    public CharLiteralNode makeCharLiteralNode(
            Character value,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);

    /**
     * Creates a ClassBodyNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public ClassBodyNode makeClassBodyNode(
            ListNode<ClassMemberNode> members);

    /**
     * Creates a ClassBodyNode.
     * The specified start and stop locations are used.
     */
    public ClassBodyNode makeClassBodyNode(
            ListNode<ClassMemberNode> members,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);

    /**
     * Creates a ClassDeclarationNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public ClassDeclarationNode makeClassDeclarationNode(
            ClassModifiersNode modifiers,
            TypeNode extendsClause,
            ListNode<TypeNode> implementsClause,
            ClassBodyNode body,
            ListNode<TypeParameterNode> typeParameters,
            IdentifierNode identifier,
            JavadocNode javadoc);

    /**
     * Creates a ClassDeclarationNode.
     * The specified start and stop locations are used.
     */
    public ClassDeclarationNode makeClassDeclarationNode(
            ClassModifiersNode modifiers,
            TypeNode extendsClause,
            ListNode<TypeNode> implementsClause,
            ClassBodyNode body,
            ListNode<TypeParameterNode> typeParameters,
            IdentifierNode identifier,
            JavadocNode javadoc,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);

    /**
     * Creates a ClassLiteralNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public ClassLiteralNode makeClassLiteralNode(
            LiteralizableTypeNode value);

    /**
     * Creates a ClassLiteralNode.
     * The specified start and stop locations are used.
     */
    public ClassLiteralNode makeClassLiteralNode(
            LiteralizableTypeNode value,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);

    /**
     * Creates a ClassModifiersNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public ClassModifiersNode makeClassModifiersNode(
            AccessModifier access,
            boolean abstractFlag,
            boolean staticFlag,
            boolean finalFlag,
            boolean strictfpFlag,
            ListNode<AnnotationNode> annotations);

    /**
     * Creates a ClassModifiersNode.
     * The specified start and stop locations are used.
     */
    public ClassModifiersNode makeClassModifiersNode(
            AccessModifier access,
            boolean abstractFlag,
            boolean staticFlag,
            boolean finalFlag,
            boolean strictfpFlag,
            ListNode<AnnotationNode> annotations,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);

    /**
     * Creates a CodeLiteralNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public CodeLiteralNode makeCodeLiteralNode(
            Node value);

    /**
     * Creates a CodeLiteralNode.
     * The specified start and stop locations are used.
     */
    public CodeLiteralNode makeCodeLiteralNode(
            Node value,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);

    /**
     * Creates a CompilationUnitNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public CompilationUnitNode makeCompilationUnitNode(
            PackageDeclarationNode packageDeclaration,
            ListNode<ImportNode> imports,
            ListNode<TypeDeclarationNode> typeDecls);

    /**
     * Creates a CompilationUnitNode.
     * The specified start and stop locations are used.
     */
    public CompilationUnitNode makeCompilationUnitNode(
            PackageDeclarationNode packageDeclaration,
            ListNode<ImportNode> imports,
            ListNode<TypeDeclarationNode> typeDecls,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);

    /**
     * Creates a ConditionalExpressionNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public ConditionalExpressionNode makeConditionalExpressionNode(
            ExpressionNode condition,
            ExpressionNode trueExpression,
            ExpressionNode falseExpression);

    /**
     * Creates a ConditionalExpressionNode.
     * The specified start and stop locations are used.
     */
    public ConditionalExpressionNode makeConditionalExpressionNode(
            ExpressionNode condition,
            ExpressionNode trueExpression,
            ExpressionNode falseExpression,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);

    /**
     * Creates a ConstructorBodyNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public ConstructorBodyNode makeConstructorBodyNode(
            ConstructorInvocationNode constructorInvocation,
            ListNode<BlockStatementNode> statements);

    /**
     * Creates a ConstructorBodyNode.
     * The specified start and stop locations are used.
     */
    public ConstructorBodyNode makeConstructorBodyNode(
            ConstructorInvocationNode constructorInvocation,
            ListNode<BlockStatementNode> statements,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);

    /**
     * Creates a ConstructorDeclarationNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public ConstructorDeclarationNode makeConstructorDeclarationNode(
            IdentifierNode identifier,
            ConstructorBodyNode body,
            ConstructorModifiersNode modifiers,
            ListNode<VariableNode> parameters,
            VariableNode varargParameter,
            ListNode<UnparameterizedTypeNode> throwTypes,
            ListNode<TypeParameterNode> typeParameters,
            JavadocNode javadoc);

    /**
     * Creates a ConstructorDeclarationNode.
     * The specified start and stop locations are used.
     */
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
            BsjSourceLocation stopLocation);

    /**
     * Creates a ConstructorModifiersNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public ConstructorModifiersNode makeConstructorModifiersNode(
            AccessModifier access,
            ListNode<AnnotationNode> annotations);

    /**
     * Creates a ConstructorModifiersNode.
     * The specified start and stop locations are used.
     */
    public ConstructorModifiersNode makeConstructorModifiersNode(
            AccessModifier access,
            ListNode<AnnotationNode> annotations,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);

    /**
     * Creates a ContinueNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public ContinueNode makeContinueNode(
            IdentifierNode label);

    /**
     * Creates a ContinueNode.
     * The specified start and stop locations are used.
     */
    public ContinueNode makeContinueNode(
            IdentifierNode label,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);

    /**
     * Creates a DoWhileLoopNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public DoWhileLoopNode makeDoWhileLoopNode(
            ExpressionNode condition,
            StatementNode statement);

    /**
     * Creates a DoWhileLoopNode.
     * The specified start and stop locations are used.
     */
    public DoWhileLoopNode makeDoWhileLoopNode(
            ExpressionNode condition,
            StatementNode statement,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);

    /**
     * Creates a DoubleLiteralNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public DoubleLiteralNode makeDoubleLiteralNode(
            Double value);

    /**
     * Creates a DoubleLiteralNode.
     * The specified start and stop locations are used.
     */
    public DoubleLiteralNode makeDoubleLiteralNode(
            Double value,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);

    /**
     * Creates a EnhancedForLoopNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public EnhancedForLoopNode makeEnhancedForLoopNode(
            VariableNode variable,
            ExpressionNode expression,
            StatementNode statement);

    /**
     * Creates a EnhancedForLoopNode.
     * The specified start and stop locations are used.
     */
    public EnhancedForLoopNode makeEnhancedForLoopNode(
            VariableNode variable,
            ExpressionNode expression,
            StatementNode statement,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);

    /**
     * Creates a EnumBodyNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public EnumBodyNode makeEnumBodyNode(
            ListNode<EnumConstantDeclarationNode> constants,
            ListNode<ClassMemberNode> members);

    /**
     * Creates a EnumBodyNode.
     * The specified start and stop locations are used.
     */
    public EnumBodyNode makeEnumBodyNode(
            ListNode<EnumConstantDeclarationNode> constants,
            ListNode<ClassMemberNode> members,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);

    /**
     * Creates a EnumConstantDeclarationNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public EnumConstantDeclarationNode makeEnumConstantDeclarationNode(
            ListNode<AnnotationNode> annotations,
            IdentifierNode identifier,
            ListNode<ExpressionNode> arguments,
            AnonymousClassBodyNode body,
            JavadocNode javadoc);

    /**
     * Creates a EnumConstantDeclarationNode.
     * The specified start and stop locations are used.
     */
    public EnumConstantDeclarationNode makeEnumConstantDeclarationNode(
            ListNode<AnnotationNode> annotations,
            IdentifierNode identifier,
            ListNode<ExpressionNode> arguments,
            AnonymousClassBodyNode body,
            JavadocNode javadoc,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);

    /**
     * Creates a EnumDeclarationNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public EnumDeclarationNode makeEnumDeclarationNode(
            EnumModifiersNode modifiers,
            ListNode<TypeNode> implementsClause,
            EnumBodyNode body,
            IdentifierNode identifier,
            JavadocNode javadoc);

    /**
     * Creates a EnumDeclarationNode.
     * The specified start and stop locations are used.
     */
    public EnumDeclarationNode makeEnumDeclarationNode(
            EnumModifiersNode modifiers,
            ListNode<TypeNode> implementsClause,
            EnumBodyNode body,
            IdentifierNode identifier,
            JavadocNode javadoc,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);

    /**
     * Creates a EnumModifiersNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public EnumModifiersNode makeEnumModifiersNode(
            AccessModifier access,
            boolean strictfpFlag,
            ListNode<AnnotationNode> annotations);

    /**
     * Creates a EnumModifiersNode.
     * The specified start and stop locations are used.
     */
    public EnumModifiersNode makeEnumModifiersNode(
            AccessModifier access,
            boolean strictfpFlag,
            ListNode<AnnotationNode> annotations,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);

    /**
     * Creates a ExpressionStatementNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public ExpressionStatementNode makeExpressionStatementNode(
            StatementExpressionNode expression);

    /**
     * Creates a ExpressionStatementNode.
     * The specified start and stop locations are used.
     */
    public ExpressionStatementNode makeExpressionStatementNode(
            StatementExpressionNode expression,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);

    /**
     * Creates a FieldAccessByExpressionNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public FieldAccessByExpressionNode makeFieldAccessByExpressionNode(
            PrimaryExpressionNode expression,
            IdentifierNode identifier);

    /**
     * Creates a FieldAccessByExpressionNode.
     * The specified start and stop locations are used.
     */
    public FieldAccessByExpressionNode makeFieldAccessByExpressionNode(
            PrimaryExpressionNode expression,
            IdentifierNode identifier,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);

    /**
     * Creates a FieldAccessByNameNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public FieldAccessByNameNode makeFieldAccessByNameNode(
            NameNode name);

    /**
     * Creates a FieldAccessByNameNode.
     * The specified start and stop locations are used.
     */
    public FieldAccessByNameNode makeFieldAccessByNameNode(
            NameNode name,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);

    /**
     * Creates a FieldDeclarationNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public FieldDeclarationNode makeFieldDeclarationNode(
            FieldModifiersNode modifiers,
            ListNode<VariableDeclaratorNode> declarators,
            JavadocNode javadoc);

    /**
     * Creates a FieldDeclarationNode.
     * The specified start and stop locations are used.
     */
    public FieldDeclarationNode makeFieldDeclarationNode(
            FieldModifiersNode modifiers,
            ListNode<VariableDeclaratorNode> declarators,
            JavadocNode javadoc,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);

    /**
     * Creates a FieldModifiersNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public FieldModifiersNode makeFieldModifiersNode(
            AccessModifier access,
            boolean staticFlag,
            boolean finalFlag,
            boolean transientFlag,
            boolean volatileFlag,
            ListNode<AnnotationNode> annotations);

    /**
     * Creates a FieldModifiersNode.
     * The specified start and stop locations are used.
     */
    public FieldModifiersNode makeFieldModifiersNode(
            AccessModifier access,
            boolean staticFlag,
            boolean finalFlag,
            boolean transientFlag,
            boolean volatileFlag,
            ListNode<AnnotationNode> annotations,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);

    /**
     * Creates a FloatLiteralNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public FloatLiteralNode makeFloatLiteralNode(
            Float value);

    /**
     * Creates a FloatLiteralNode.
     * The specified start and stop locations are used.
     */
    public FloatLiteralNode makeFloatLiteralNode(
            Float value,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);

    /**
     * Creates a ForInitializerDeclarationNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public ForInitializerDeclarationNode makeForInitializerDeclarationNode(
            VariableDeclarationNode declaration);

    /**
     * Creates a ForInitializerDeclarationNode.
     * The specified start and stop locations are used.
     */
    public ForInitializerDeclarationNode makeForInitializerDeclarationNode(
            VariableDeclarationNode declaration,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);

    /**
     * Creates a ForInitializerExpressionNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public ForInitializerExpressionNode makeForInitializerExpressionNode(
            ListNode<StatementExpressionNode> expressions);

    /**
     * Creates a ForInitializerExpressionNode.
     * The specified start and stop locations are used.
     */
    public ForInitializerExpressionNode makeForInitializerExpressionNode(
            ListNode<StatementExpressionNode> expressions,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);

    /**
     * Creates a ForLoopNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public ForLoopNode makeForLoopNode(
            ForInitializerNode initializer,
            ExpressionNode condition,
            ListNode<StatementExpressionNode> update,
            StatementNode statement);

    /**
     * Creates a ForLoopNode.
     * The specified start and stop locations are used.
     */
    public ForLoopNode makeForLoopNode(
            ForInitializerNode initializer,
            ExpressionNode condition,
            ListNode<StatementExpressionNode> update,
            StatementNode statement,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);

    /**
     * Creates a IdentifierNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public IdentifierNode makeIdentifierNode(
            String identifier);

    /**
     * Creates a IdentifierNode.
     * The specified start and stop locations are used.
     */
    public IdentifierNode makeIdentifierNode(
            String identifier,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);

    /**
     * Creates a IfNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public IfNode makeIfNode(
            ExpressionNode condition,
            StatementNode thenStatement,
            StatementNode elseStatement);

    /**
     * Creates a IfNode.
     * The specified start and stop locations are used.
     */
    public IfNode makeIfNode(
            ExpressionNode condition,
            StatementNode thenStatement,
            StatementNode elseStatement,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);

    /**
     * Creates a ImportOnDemandNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public ImportOnDemandNode makeImportOnDemandNode(
            NameNode name,
            boolean staticImport);

    /**
     * Creates a ImportOnDemandNode.
     * The specified start and stop locations are used.
     */
    public ImportOnDemandNode makeImportOnDemandNode(
            NameNode name,
            boolean staticImport,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);

    /**
     * Creates a ImportSingleTypeNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public ImportSingleTypeNode makeImportSingleTypeNode(
            NameNode name,
            boolean staticImport);

    /**
     * Creates a ImportSingleTypeNode.
     * The specified start and stop locations are used.
     */
    public ImportSingleTypeNode makeImportSingleTypeNode(
            NameNode name,
            boolean staticImport,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);

    /**
     * Creates a InitializerDeclarationNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public InitializerDeclarationNode makeInitializerDeclarationNode(
            boolean staticInitializer,
            BlockNode body);

    /**
     * Creates a InitializerDeclarationNode.
     * The specified start and stop locations are used.
     */
    public InitializerDeclarationNode makeInitializerDeclarationNode(
            boolean staticInitializer,
            BlockNode body,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);

    /**
     * Creates a InlineTypeDeclarationNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public InlineTypeDeclarationNode makeInlineTypeDeclarationNode(
            InlineTypeDeclarableNode declaration);

    /**
     * Creates a InlineTypeDeclarationNode.
     * The specified start and stop locations are used.
     */
    public InlineTypeDeclarationNode makeInlineTypeDeclarationNode(
            InlineTypeDeclarableNode declaration,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);

    /**
     * Creates a InstanceOfNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public InstanceOfNode makeInstanceOfNode(
            ExpressionNode expression,
            TypeNode type);

    /**
     * Creates a InstanceOfNode.
     * The specified start and stop locations are used.
     */
    public InstanceOfNode makeInstanceOfNode(
            ExpressionNode expression,
            TypeNode type,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);

    /**
     * Creates a IntLiteralNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public IntLiteralNode makeIntLiteralNode(
            Integer value);

    /**
     * Creates a IntLiteralNode.
     * The specified start and stop locations are used.
     */
    public IntLiteralNode makeIntLiteralNode(
            Integer value,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);

    /**
     * Creates a InterfaceBodyNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public InterfaceBodyNode makeInterfaceBodyNode(
            ListNode<InterfaceMemberNode> members);

    /**
     * Creates a InterfaceBodyNode.
     * The specified start and stop locations are used.
     */
    public InterfaceBodyNode makeInterfaceBodyNode(
            ListNode<InterfaceMemberNode> members,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);

    /**
     * Creates a InterfaceDeclarationNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public InterfaceDeclarationNode makeInterfaceDeclarationNode(
            InterfaceModifiersNode modifiers,
            ListNode<TypeNode> extendsClause,
            InterfaceBodyNode body,
            ListNode<TypeParameterNode> typeParameters,
            IdentifierNode identifier,
            JavadocNode javadoc);

    /**
     * Creates a InterfaceDeclarationNode.
     * The specified start and stop locations are used.
     */
    public InterfaceDeclarationNode makeInterfaceDeclarationNode(
            InterfaceModifiersNode modifiers,
            ListNode<TypeNode> extendsClause,
            InterfaceBodyNode body,
            ListNode<TypeParameterNode> typeParameters,
            IdentifierNode identifier,
            JavadocNode javadoc,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);

    /**
     * Creates a InterfaceModifiersNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public InterfaceModifiersNode makeInterfaceModifiersNode(
            AccessModifier access,
            boolean staticFlag,
            boolean strictfpFlag,
            ListNode<AnnotationNode> annotations);

    /**
     * Creates a InterfaceModifiersNode.
     * The specified start and stop locations are used.
     */
    public InterfaceModifiersNode makeInterfaceModifiersNode(
            AccessModifier access,
            boolean staticFlag,
            boolean strictfpFlag,
            ListNode<AnnotationNode> annotations,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);

    /**
     * Creates a JavadocNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public JavadocNode makeJavadocNode(
            String text);

    /**
     * Creates a JavadocNode.
     * The specified start and stop locations are used.
     */
    public JavadocNode makeJavadocNode(
            String text,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);

    /**
     * Creates a LabeledStatementNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public LabeledStatementNode makeLabeledStatementNode(
            IdentifierNode label,
            StatementNode statement);

    /**
     * Creates a LabeledStatementNode.
     * The specified start and stop locations are used.
     */
    public LabeledStatementNode makeLabeledStatementNode(
            IdentifierNode label,
            StatementNode statement,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);

    /**
     * Creates a ListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public <T extends Node> ListNode<T> makeListNode(
            List<T> children);

    /**
     * Creates a ListNode.
     * The specified start and stop locations are used.
     */
    public <T extends Node> ListNode<T> makeListNode(
            List<T> children,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);

    /**
     * Creates a LongLiteralNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public LongLiteralNode makeLongLiteralNode(
            Long value);

    /**
     * Creates a LongLiteralNode.
     * The specified start and stop locations are used.
     */
    public LongLiteralNode makeLongLiteralNode(
            Long value,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);

    /**
     * Creates a MetaprogramNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public MetaprogramNode makeMetaprogramNode(
            ListNode<BlockStatementNode> body);

    /**
     * Creates a MetaprogramNode.
     * The specified start and stop locations are used.
     */
    public MetaprogramNode makeMetaprogramNode(
            ListNode<BlockStatementNode> body,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);

    /**
     * Creates a MethodDeclarationNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public MethodDeclarationNode makeMethodDeclarationNode(
            BlockNode body,
            MethodModifiersNode modifiers,
            IdentifierNode identifier,
            ListNode<VariableNode> parameters,
            VariableNode varargParameter,
            TypeNode returnType,
            ListNode<UnparameterizedTypeNode> throwTypes,
            ListNode<TypeParameterNode> typeParameters,
            JavadocNode javadoc);

    /**
     * Creates a MethodDeclarationNode.
     * The specified start and stop locations are used.
     */
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
            BsjSourceLocation stopLocation);

    /**
     * Creates a MethodInvocationByExpressionNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public MethodInvocationByExpressionNode makeMethodInvocationByExpressionNode(
            PrimaryExpressionNode expression,
            IdentifierNode identifier,
            ListNode<ExpressionNode> arguments,
            ListNode<TypeNode> typeArguments);

    /**
     * Creates a MethodInvocationByExpressionNode.
     * The specified start and stop locations are used.
     */
    public MethodInvocationByExpressionNode makeMethodInvocationByExpressionNode(
            PrimaryExpressionNode expression,
            IdentifierNode identifier,
            ListNode<ExpressionNode> arguments,
            ListNode<TypeNode> typeArguments,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);

    /**
     * Creates a MethodInvocationByNameNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public MethodInvocationByNameNode makeMethodInvocationByNameNode(
            NameNode name,
            ListNode<ExpressionNode> arguments,
            ListNode<TypeNode> typeArguments);

    /**
     * Creates a MethodInvocationByNameNode.
     * The specified start and stop locations are used.
     */
    public MethodInvocationByNameNode makeMethodInvocationByNameNode(
            NameNode name,
            ListNode<ExpressionNode> arguments,
            ListNode<TypeNode> typeArguments,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);

    /**
     * Creates a MethodModifiersNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public MethodModifiersNode makeMethodModifiersNode(
            AccessModifier access,
            boolean abstractFlag,
            boolean staticFlag,
            boolean finalFlag,
            boolean synchronizedFlag,
            boolean nativeFlag,
            boolean strictfpFlag,
            ListNode<AnnotationNode> annotations);

    /**
     * Creates a MethodModifiersNode.
     * The specified start and stop locations are used.
     */
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
            BsjSourceLocation stopLocation);

    /**
     * Creates a NormalAnnotationNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public NormalAnnotationNode makeNormalAnnotationNode(
            ListNode<AnnotationElementNode> arguments,
            UnparameterizedTypeNode annotationType);

    /**
     * Creates a NormalAnnotationNode.
     * The specified start and stop locations are used.
     */
    public NormalAnnotationNode makeNormalAnnotationNode(
            ListNode<AnnotationElementNode> arguments,
            UnparameterizedTypeNode annotationType,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);

    /**
     * Creates a NullLiteralNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public NullLiteralNode makeNullLiteralNode(
            Void value);

    /**
     * Creates a NullLiteralNode.
     * The specified start and stop locations are used.
     */
    public NullLiteralNode makeNullLiteralNode(
            Void value,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);

    /**
     * Creates a PackageDeclarationNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public PackageDeclarationNode makePackageDeclarationNode(
            NameNode name,
            ListNode<AnnotationNode> annotations);

    /**
     * Creates a PackageDeclarationNode.
     * The specified start and stop locations are used.
     */
    public PackageDeclarationNode makePackageDeclarationNode(
            NameNode name,
            ListNode<AnnotationNode> annotations,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);

    /**
     * Creates a ParameterizedTypeNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public ParameterizedTypeNode makeParameterizedTypeNode(
            UnparameterizedTypeNode baseType,
            ListNode<TypeArgumentNode> typeArguments);

    /**
     * Creates a ParameterizedTypeNode.
     * The specified start and stop locations are used.
     */
    public ParameterizedTypeNode makeParameterizedTypeNode(
            UnparameterizedTypeNode baseType,
            ListNode<TypeArgumentNode> typeArguments,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);

    /**
     * Creates a ParameterizedTypeSelectNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public ParameterizedTypeSelectNode makeParameterizedTypeSelectNode(
            ParameterizedTypeNode base,
            DeclaredTypeNode select);

    /**
     * Creates a ParameterizedTypeSelectNode.
     * The specified start and stop locations are used.
     */
    public ParameterizedTypeSelectNode makeParameterizedTypeSelectNode(
            ParameterizedTypeNode base,
            DeclaredTypeNode select,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);

    /**
     * Creates a ParenthesizedExpressionNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public ParenthesizedExpressionNode makeParenthesizedExpressionNode(
            ExpressionNode expression);

    /**
     * Creates a ParenthesizedExpressionNode.
     * The specified start and stop locations are used.
     */
    public ParenthesizedExpressionNode makeParenthesizedExpressionNode(
            ExpressionNode expression,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);

    /**
     * Creates a PrimitiveTypeNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public PrimitiveTypeNode makePrimitiveTypeNode(
            PrimitiveType primitiveType);

    /**
     * Creates a PrimitiveTypeNode.
     * The specified start and stop locations are used.
     */
    public PrimitiveTypeNode makePrimitiveTypeNode(
            PrimitiveType primitiveType,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);

    /**
     * Creates a QualifiedClassInstantiationNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public QualifiedClassInstantiationNode makeQualifiedClassInstantiationNode(
            ExpressionNode enclosingExpression,
            IdentifierNode identifier,
            ListNode<TypeArgumentNode> typeArguments,
            ListNode<TypeArgumentNode> constructorTypeArguments,
            ListNode<ExpressionNode> arguments,
            AnonymousClassBodyNode body);

    /**
     * Creates a QualifiedClassInstantiationNode.
     * The specified start and stop locations are used.
     */
    public QualifiedClassInstantiationNode makeQualifiedClassInstantiationNode(
            ExpressionNode enclosingExpression,
            IdentifierNode identifier,
            ListNode<TypeArgumentNode> typeArguments,
            ListNode<TypeArgumentNode> constructorTypeArguments,
            ListNode<ExpressionNode> arguments,
            AnonymousClassBodyNode body,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);

    /**
     * Creates a QualifiedNameNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public QualifiedNameNode makeQualifiedNameNode(
            NameNode base,
            IdentifierNode identifier,
            NameCategory category);

    /**
     * Creates a QualifiedNameNode.
     * The specified start and stop locations are used.
     */
    public QualifiedNameNode makeQualifiedNameNode(
            NameNode base,
            IdentifierNode identifier,
            NameCategory category,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);

    /**
     * Creates a ReturnNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public ReturnNode makeReturnNode(
            ExpressionNode expression);

    /**
     * Creates a ReturnNode.
     * The specified start and stop locations are used.
     */
    public ReturnNode makeReturnNode(
            ExpressionNode expression,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);

    /**
     * Creates a SimpleNameNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public SimpleNameNode makeSimpleNameNode(
            IdentifierNode identifier,
            NameCategory category);

    /**
     * Creates a SimpleNameNode.
     * The specified start and stop locations are used.
     */
    public SimpleNameNode makeSimpleNameNode(
            IdentifierNode identifier,
            NameCategory category,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);

    /**
     * Creates a SingleElementAnnotationNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public SingleElementAnnotationNode makeSingleElementAnnotationNode(
            AnnotationValueNode value,
            UnparameterizedTypeNode annotationType);

    /**
     * Creates a SingleElementAnnotationNode.
     * The specified start and stop locations are used.
     */
    public SingleElementAnnotationNode makeSingleElementAnnotationNode(
            AnnotationValueNode value,
            UnparameterizedTypeNode annotationType,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);

    /**
     * Creates a StringLiteralNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public StringLiteralNode makeStringLiteralNode(
            String value);

    /**
     * Creates a StringLiteralNode.
     * The specified start and stop locations are used.
     */
    public StringLiteralNode makeStringLiteralNode(
            String value,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);

    /**
     * Creates a SuperFieldAccessNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public SuperFieldAccessNode makeSuperFieldAccessNode(
            UnparameterizedTypeNode type,
            IdentifierNode identifier);

    /**
     * Creates a SuperFieldAccessNode.
     * The specified start and stop locations are used.
     */
    public SuperFieldAccessNode makeSuperFieldAccessNode(
            UnparameterizedTypeNode type,
            IdentifierNode identifier,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);

    /**
     * Creates a SuperMethodInvocationNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public SuperMethodInvocationNode makeSuperMethodInvocationNode(
            UnparameterizedTypeNode type,
            IdentifierNode identifier,
            ListNode<ExpressionNode> arguments,
            ListNode<TypeNode> typeArguments);

    /**
     * Creates a SuperMethodInvocationNode.
     * The specified start and stop locations are used.
     */
    public SuperMethodInvocationNode makeSuperMethodInvocationNode(
            UnparameterizedTypeNode type,
            IdentifierNode identifier,
            ListNode<ExpressionNode> arguments,
            ListNode<TypeNode> typeArguments,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);

    /**
     * Creates a SuperclassConstructorInvocationNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public SuperclassConstructorInvocationNode makeSuperclassConstructorInvocationNode(
            PrimaryExpressionNode qualifyingExpression,
            ListNode<ExpressionNode> arguments,
            ListNode<TypeNode> typeArguments);

    /**
     * Creates a SuperclassConstructorInvocationNode.
     * The specified start and stop locations are used.
     */
    public SuperclassConstructorInvocationNode makeSuperclassConstructorInvocationNode(
            PrimaryExpressionNode qualifyingExpression,
            ListNode<ExpressionNode> arguments,
            ListNode<TypeNode> typeArguments,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);

    /**
     * Creates a SwitchNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public SwitchNode makeSwitchNode(
            ExpressionNode expression,
            ListNode<CaseNode> cases);

    /**
     * Creates a SwitchNode.
     * The specified start and stop locations are used.
     */
    public SwitchNode makeSwitchNode(
            ExpressionNode expression,
            ListNode<CaseNode> cases,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);

    /**
     * Creates a SynchronizedNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public SynchronizedNode makeSynchronizedNode(
            ExpressionNode expression,
            BlockNode block);

    /**
     * Creates a SynchronizedNode.
     * The specified start and stop locations are used.
     */
    public SynchronizedNode makeSynchronizedNode(
            ExpressionNode expression,
            BlockNode block,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);

    /**
     * Creates a ThisNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public ThisNode makeThisNode(
            UnparameterizedTypeNode type);

    /**
     * Creates a ThisNode.
     * The specified start and stop locations are used.
     */
    public ThisNode makeThisNode(
            UnparameterizedTypeNode type,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);

    /**
     * Creates a ThrowNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public ThrowNode makeThrowNode(
            ExpressionNode expression);

    /**
     * Creates a ThrowNode.
     * The specified start and stop locations are used.
     */
    public ThrowNode makeThrowNode(
            ExpressionNode expression,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);

    /**
     * Creates a TryNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public TryNode makeTryNode(
            BlockNode block,
            ListNode<CatchNode> catches,
            BlockNode finallyBlock);

    /**
     * Creates a TryNode.
     * The specified start and stop locations are used.
     */
    public TryNode makeTryNode(
            BlockNode block,
            ListNode<CatchNode> catches,
            BlockNode finallyBlock,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);

    /**
     * Creates a TypeCastNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public TypeCastNode makeTypeCastNode(
            ExpressionNode expression,
            TypeNode type);

    /**
     * Creates a TypeCastNode.
     * The specified start and stop locations are used.
     */
    public TypeCastNode makeTypeCastNode(
            ExpressionNode expression,
            TypeNode type,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);

    /**
     * Creates a TypeDeclarationMetaprogramAnchorNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public TypeDeclarationMetaprogramAnchorNode makeTypeDeclarationMetaprogramAnchorNode(
            MetaprogramNode metaprogram);

    /**
     * Creates a TypeDeclarationMetaprogramAnchorNode.
     * The specified start and stop locations are used.
     */
    public TypeDeclarationMetaprogramAnchorNode makeTypeDeclarationMetaprogramAnchorNode(
            TypeDeclarationNode replacement,
            MetaprogramNode metaprogram,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);

    /**
     * Creates a TypeParameterNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public TypeParameterNode makeTypeParameterNode(
            IdentifierNode identifier,
            ListNode<DeclaredTypeNode> bounds);

    /**
     * Creates a TypeParameterNode.
     * The specified start and stop locations are used.
     */
    public TypeParameterNode makeTypeParameterNode(
            IdentifierNode identifier,
            ListNode<DeclaredTypeNode> bounds,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);

    /**
     * Creates a UnaryExpressionNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public UnaryExpressionNode makeUnaryExpressionNode(
            ExpressionNode expression,
            UnaryOperator operator);

    /**
     * Creates a UnaryExpressionNode.
     * The specified start and stop locations are used.
     */
    public UnaryExpressionNode makeUnaryExpressionNode(
            ExpressionNode expression,
            UnaryOperator operator,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);

    /**
     * Creates a UnaryStatementExpressionNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public UnaryStatementExpressionNode makeUnaryStatementExpressionNode(
            ExpressionNode expression,
            UnaryStatementOperator operator);

    /**
     * Creates a UnaryStatementExpressionNode.
     * The specified start and stop locations are used.
     */
    public UnaryStatementExpressionNode makeUnaryStatementExpressionNode(
            ExpressionNode expression,
            UnaryStatementOperator operator,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);

    /**
     * Creates a UnparameterizedTypeNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public UnparameterizedTypeNode makeUnparameterizedTypeNode(
            NameNode name);

    /**
     * Creates a UnparameterizedTypeNode.
     * The specified start and stop locations are used.
     */
    public UnparameterizedTypeNode makeUnparameterizedTypeNode(
            NameNode name,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);

    /**
     * Creates a UnqualifiedClassInstantiationNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public UnqualifiedClassInstantiationNode makeUnqualifiedClassInstantiationNode(
            DeclaredTypeNode type,
            ListNode<TypeArgumentNode> constructorTypeArguments,
            ListNode<ExpressionNode> arguments,
            AnonymousClassBodyNode body);

    /**
     * Creates a UnqualifiedClassInstantiationNode.
     * The specified start and stop locations are used.
     */
    public UnqualifiedClassInstantiationNode makeUnqualifiedClassInstantiationNode(
            DeclaredTypeNode type,
            ListNode<TypeArgumentNode> constructorTypeArguments,
            ListNode<ExpressionNode> arguments,
            AnonymousClassBodyNode body,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);

    /**
     * Creates a VariableDeclarationNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public VariableDeclarationNode makeVariableDeclarationNode(
            VariableModifiersNode modifiers,
            ListNode<VariableDeclaratorNode> declarators);

    /**
     * Creates a VariableDeclarationNode.
     * The specified start and stop locations are used.
     */
    public VariableDeclarationNode makeVariableDeclarationNode(
            VariableModifiersNode modifiers,
            ListNode<VariableDeclaratorNode> declarators,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);

    /**
     * Creates a VariableDeclaratorNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public VariableDeclaratorNode makeVariableDeclaratorNode(
            TypeNode type,
            IdentifierNode name,
            VariableInitializerNode initializer);

    /**
     * Creates a VariableDeclaratorNode.
     * The specified start and stop locations are used.
     */
    public VariableDeclaratorNode makeVariableDeclaratorNode(
            TypeNode type,
            IdentifierNode name,
            VariableInitializerNode initializer,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);

    /**
     * Creates a VariableModifiersNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public VariableModifiersNode makeVariableModifiersNode(
            boolean finalFlag,
            ListNode<AnnotationNode> annotations);

    /**
     * Creates a VariableModifiersNode.
     * The specified start and stop locations are used.
     */
    public VariableModifiersNode makeVariableModifiersNode(
            boolean finalFlag,
            ListNode<AnnotationNode> annotations,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);

    /**
     * Creates a VariableNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public VariableNode makeVariableNode(
            VariableModifiersNode modifiers,
            TypeNode type,
            IdentifierNode identifier);

    /**
     * Creates a VariableNode.
     * The specified start and stop locations are used.
     */
    public VariableNode makeVariableNode(
            VariableModifiersNode modifiers,
            TypeNode type,
            IdentifierNode identifier,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);

    /**
     * Creates a VoidStatementNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public VoidStatementNode makeVoidStatementNode(
);

    /**
     * Creates a VoidStatementNode.
     * The specified start and stop locations are used.
     */
    public VoidStatementNode makeVoidStatementNode(
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);

    /**
     * Creates a VoidTypeDeclarationNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public VoidTypeDeclarationNode makeVoidTypeDeclarationNode(
);

    /**
     * Creates a VoidTypeDeclarationNode.
     * The specified start and stop locations are used.
     */
    public VoidTypeDeclarationNode makeVoidTypeDeclarationNode(
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);

    /**
     * Creates a VoidTypeNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public VoidTypeNode makeVoidTypeNode(
);

    /**
     * Creates a VoidTypeNode.
     * The specified start and stop locations are used.
     */
    public VoidTypeNode makeVoidTypeNode(
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);

    /**
     * Creates a WhileLoopNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public WhileLoopNode makeWhileLoopNode(
            ExpressionNode condition,
            StatementNode statement);

    /**
     * Creates a WhileLoopNode.
     * The specified start and stop locations are used.
     */
    public WhileLoopNode makeWhileLoopNode(
            ExpressionNode condition,
            StatementNode statement,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);

    /**
     * Creates a WildcardTypeNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public WildcardTypeNode makeWildcardTypeNode(
            ReferenceTypeNode bound,
            boolean upperBound);

    /**
     * Creates a WildcardTypeNode.
     * The specified start and stop locations are used.
     */
    public WildcardTypeNode makeWildcardTypeNode(
            ReferenceTypeNode bound,
            boolean upperBound,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);

}
