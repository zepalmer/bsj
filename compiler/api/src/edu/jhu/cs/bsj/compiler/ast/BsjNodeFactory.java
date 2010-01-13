package edu.jhu.cs.bsj.compiler.ast;

import java.util.List;
import java.util.Set;

import edu.jhu.cs.bsj.compiler.ast.node.*;
import edu.jhu.cs.bsj.compiler.ast.node.meta.CodeLiteralNode;

/**
 * This interface is implemented by any object which can act as a factory for BSJ nodes.  It
 * is strongly advisable to ensure that all nodes in a given AST are produced from the same
 * factory, although the urgency of this restriction is implementation-dependent.
 *
* @author Zachary Palmer
 */
public interface BsjNodeFactory
{
    /**
     * Creates a AssertStatementNode.
     */
    public AssertStatementNode makeAssertStatementNode(
            ExpressionNode testExpression,
            ExpressionNode messageExpression);

    /**
     * Creates a ExpressionStatementNode.
     */
    public ExpressionStatementNode makeExpressionStatementNode(
            ExpressionNode expression);

    /**
     * Creates a InterfaceBodyNode.
     */
    public InterfaceBodyNode makeInterfaceBodyNode(
            ListNode<InterfaceMemberNode> members);

    /**
     * Creates a EnhancedForLoopNode.
     */
    public EnhancedForLoopNode makeEnhancedForLoopNode(
            VariableNode variable,
            ExpressionNode expression,
            StatementNode statement);

    /**
     * Creates a ClassDeclarationNode.
     */
    public ClassDeclarationNode makeClassDeclarationNode(
            TypeNode extendsClause,
            ListNode<TypeNode> implementsClause,
            ClassBodyNode body,
            ListNode<TypeParameterNode> typeParameters,
            IdentifierNode identifier,
            ModifiersNode modifiers);

    /**
     * Creates a ArrayAccessNode.
     */
    public ArrayAccessNode makeArrayAccessNode(
            ArrayIndexableNode arrayExpression,
            ExpressionNode indexExpression);

    /**
     * Creates a LongLiteralNode.
     */
    public LongLiteralNode makeLongLiteralNode(
            Long value);

    /**
     * Creates a QualifiedNameNode.
     */
    public QualifiedNameNode makeQualifiedNameNode(
            NameNode base,
            IdentifierNode identifier,
            NameCategory category);

    /**
     * Creates a CaseNode.
     */
    public CaseNode makeCaseNode(
            ExpressionNode expression,
            ListNode<StatementNode> statements);

    /**
     * Creates a VoidStatementNode.
     */
    public VoidStatementNode makeVoidStatementNode();

    /**
     * Creates a CodeLiteralNode.
     */
    public CodeLiteralNode makeCodeLiteralNode(
            Node value);

    /**
     * Creates a ImportOnDemandNode.
     */
    public ImportOnDemandNode makeImportOnDemandNode(
            NameNode name,
            boolean staticImport);

    /**
     * Creates a SuperclassConstructorInvocationNode.
     */
    public SuperclassConstructorInvocationNode makeSuperclassConstructorInvocationNode(
            PrimaryExpressionNode qualifyingExpression,
            ListNode<ExpressionNode> arguments,
            ListNode<TypeNode> typeArguments);

    /**
     * Creates a PrimitiveTypeNode.
     */
    public PrimitiveTypeNode makePrimitiveTypeNode(
            PrimitiveType primitiveType);

    /**
     * Creates a InitializerDeclarationNode.
     */
    public InitializerDeclarationNode makeInitializerDeclarationNode(
            boolean staticInitializer,
            BlockStatementNode body);

    /**
     * Creates a ModifiersNode.
     */
    public ModifiersNode makeModifiersNode(
            ListNode<AnnotationNode> annotations,
            Set<Modifier> flags);

    /**
     * Creates a EnumBodyNode.
     */
    public EnumBodyNode makeEnumBodyNode(
            ListNode<EnumConstantDeclarationNode> constants,
            ListNode<ClassMemberNode> members);

    /**
     * Creates a TryNode.
     */
    public TryNode makeTryNode(
            BlockStatementNode block,
            ListNode<CatchNode> catches,
            BlockStatementNode finallyBlock);

    /**
     * Creates a ThisNode.
     */
    public ThisNode makeThisNode(
            RawTypeNode type);

    /**
     * Creates a EnumDeclarationNode.
     */
    public EnumDeclarationNode makeEnumDeclarationNode(
            ListNode<TypeNode> implementsClause,
            EnumBodyNode body,
            IdentifierNode identifier,
            ModifiersNode modifiers);

    /**
     * Creates a VoidTypeNode.
     */
    public VoidTypeNode makeVoidTypeNode();

    /**
     * Creates a VariableDeclarationNode.
     */
    public VariableDeclarationNode makeVariableDeclarationNode(
            ModifiersNode modifiers,
            ListNode<VariableDeclaratorNode> declarators);

    /**
     * Creates a AnnotationBodyNode.
     */
    public AnnotationBodyNode makeAnnotationBodyNode(
            ListNode<AnnotationMemberNode> members);

    /**
     * Creates a VariableDeclaratorNode.
     */
    public VariableDeclaratorNode makeVariableDeclaratorNode(
            TypeNode type,
            IdentifierNode name,
            VariableInitializerNode initializer);

    /**
     * Creates a FieldAccessNode.
     */
    public FieldAccessNode makeFieldAccessNode(
            PrimaryExpressionNode expression,
            IdentifierNode identifier);

    /**
     * Creates a SuperFieldAccessNode.
     */
    public SuperFieldAccessNode makeSuperFieldAccessNode(
            RawTypeNode type,
            IdentifierNode identifier);

    /**
     * Creates a ThrowNode.
     */
    public ThrowNode makeThrowNode(
            ExpressionNode expression);

    /**
     * Creates a NameExpressionNode.
     */
    public NameExpressionNode makeNameExpressionNode(
            NameNode name);

    /**
     * Creates a CatchNode.
     */
    public CatchNode makeCatchNode(
            BlockStatementNode block,
            VariableNode parameter);

    /**
     * Creates a VoidTypeDeclarationNode.
     */
    public VoidTypeDeclarationNode makeVoidTypeDeclarationNode();

    /**
     * Creates a NormalAnnotationNode.
     */
    public NormalAnnotationNode makeNormalAnnotationNode(
            ListNode<AnnotationElementNode> arguments,
            RawTypeNode annotationType);

    /**
     * Creates a DoWhileLoopNode.
     */
    public DoWhileLoopNode makeDoWhileLoopNode(
            ExpressionNode condition,
            StatementNode statement);

    /**
     * Creates a QualifiedClassInstantiationNode.
     */
    public QualifiedClassInstantiationNode makeQualifiedClassInstantiationNode(
            ExpressionNode enclosingExpression,
            IdentifierNode identifier,
            ListNode<TypeNode> typeArguments,
            ListNode<TypeNode> constructorTypeArguments,
            ListNode<ExpressionNode> arguments,
            AnonymousClassBodyNode body);

    /**
     * Creates a TypeCastNode.
     */
    public TypeCastNode makeTypeCastNode(
            ExpressionNode expression,
            TypeNode type);

    /**
     * Creates a LabeledStatementNode.
     */
    public LabeledStatementNode makeLabeledStatementNode(
            IdentifierNode label,
            StatementNode statement);

    /**
     * Creates a BlockStatementNode.
     */
    public BlockStatementNode makeBlockStatementNode(
            ListNode<StatementNode> statements);

    /**
     * Creates a ForInitializerExpressionNode.
     */
    public ForInitializerExpressionNode makeForInitializerExpressionNode(
            ListNode<ExpressionNode> expressions);

    /**
     * Creates a PackageDeclarationNode.
     */
    public PackageDeclarationNode makePackageDeclarationNode(
            NameNode name,
            ListNode<AnnotationNode> annotations);

    /**
     * Creates a AnnotationDeclarationNode.
     */
    public AnnotationDeclarationNode makeAnnotationDeclarationNode(
            AnnotationBodyNode body,
            IdentifierNode identifier,
            ModifiersNode modifiers);

    /**
     * Creates a CompilationUnitNode.
     */
    public CompilationUnitNode makeCompilationUnitNode(
            PackageDeclarationNode packageDeclaration,
            ListNode<ImportNode> imports,
            ListNode<TypeDeclarationNode> typeDecls);

    /**
     * Creates a ContinueNode.
     */
    public ContinueNode makeContinueNode(
            IdentifierNode label);

    /**
     * Creates a StringLiteralNode.
     */
    public StringLiteralNode makeStringLiteralNode(
            String value);

    /**
     * Creates a AnnotationElementNode.
     */
    public AnnotationElementNode makeAnnotationElementNode(
            IdentifierNode identifier,
            AnnotationValueNode value);

    /**
     * Creates a DoubleLiteralNode.
     */
    public DoubleLiteralNode makeDoubleLiteralNode(
            Double value);

    /**
     * Creates a AnonymousClassBodyNode.
     */
    public AnonymousClassBodyNode makeAnonymousClassBodyNode(
            ListNode<AnonymousClassMemberNode> members);

    /**
     * Creates a UnaryOperatorNode.
     */
    public UnaryOperatorNode makeUnaryOperatorNode(
            ExpressionNode expression,
            UnaryOperator operator);

    /**
     * Creates a SynchronizedNode.
     */
    public SynchronizedNode makeSynchronizedNode(
            ExpressionNode expression,
            BlockStatementNode block);

    /**
     * Creates a VariableNode.
     */
    public VariableNode makeVariableNode(
            ModifiersNode modifiers,
            TypeNode type,
            IdentifierNode identifier);

    /**
     * Creates a CharLiteralNode.
     */
    public CharLiteralNode makeCharLiteralNode(
            Character value);

    /**
     * Creates a WildcardTypeNode.
     */
    public WildcardTypeNode makeWildcardTypeNode(
            TypeNode bound,
            boolean upperBound);

    /**
     * Creates a InlineTypeDeclarationNode.
     */
    public InlineTypeDeclarationNode makeInlineTypeDeclarationNode(
            InlineTypeDeclarableNode declaration);

    /**
     * Creates a BooleanLiteralNode.
     */
    public BooleanLiteralNode makeBooleanLiteralNode(
            Boolean value);

    /**
     * Creates a SwitchNode.
     */
    public SwitchNode makeSwitchNode(
            ExpressionNode expression,
            ListNode<CaseNode> cases);

    /**
     * Creates a AlternateConstructorInvocationNode.
     */
    public AlternateConstructorInvocationNode makeAlternateConstructorInvocationNode(
            ListNode<ExpressionNode> arguments,
            ListNode<TypeNode> typeArguments);

    /**
     * Creates a ConstructorDeclarationNode.
     */
    public ConstructorDeclarationNode makeConstructorDeclarationNode(
            ConstructorBodyNode body,
            ModifiersNode modifiers,
            ListNode<VariableNode> parameters,
            VariableNode varargParameter,
            ListNode<RawTypeNode> throwTypes,
            ListNode<TypeParameterNode> typeParameters);

    /**
     * Creates a AnnotationAnnotationValueNode.
     */
    public AnnotationAnnotationValueNode makeAnnotationAnnotationValueNode(
            AnnotationNode annotation);

    /**
     * Creates a ForLoopNode.
     */
    public ForLoopNode makeForLoopNode(
            ForInitializerNode initializer,
            ListNode<ExpressionStatementNode> update,
            ExpressionNode condition,
            StatementNode statement);

    /**
     * Creates a WhileLoopNode.
     */
    public WhileLoopNode makeWhileLoopNode(
            ExpressionNode condition,
            StatementNode statement);

    /**
     * Creates a ListNode.
     */
    public <T extends Node> ListNode<T> makeListNode(
            List<T> children);

    /**
     * Creates a EnumConstantDeclarationNode.
     */
    public EnumConstantDeclarationNode makeEnumConstantDeclarationNode(
            ListNode<AnnotationNode> annotations,
            IdentifierNode identifier,
            ListNode<ExpressionNode> arguments,
            AnonymousClassBodyNode body);

    /**
     * Creates a BreakNode.
     */
    public BreakNode makeBreakNode(
            IdentifierNode label);

    /**
     * Creates a ParameterizedTypeSelectNode.
     */
    public ParameterizedTypeSelectNode makeParameterizedTypeSelectNode(
            ParameterizedTypeNode base,
            DeclaredTypeNode select);

    /**
     * Creates a IdentifierNode.
     */
    public IdentifierNode makeIdentifierNode(
            String identifier);

    /**
     * Creates a ArrayTypeNode.
     */
    public ArrayTypeNode makeArrayTypeNode(
            TypeNode type);

    /**
     * Creates a ArrayInitializerCreationNode.
     */
    public ArrayInitializerCreationNode makeArrayInitializerCreationNode(
            ArrayInitializerNode initializer,
            BaseTypeNode baseType,
            int arrayLevels);

    /**
     * Creates a TypeParameterNode.
     */
    public TypeParameterNode makeTypeParameterNode(
            IdentifierNode identifier,
            ListNode<DeclaredTypeNode> bounds);

    /**
     * Creates a AnnotationMethodDeclarationNode.
     */
    public AnnotationMethodDeclarationNode makeAnnotationMethodDeclarationNode(
            ModifiersNode modifiers,
            TypeNode type,
            IdentifierNode identifier,
            ExpressionNode defaultValue);

    /**
     * Creates a ImportSingleTypeNode.
     */
    public ImportSingleTypeNode makeImportSingleTypeNode(
            NameNode name,
            boolean staticImport);

    /**
     * Creates a FieldDeclarationNode.
     */
    public FieldDeclarationNode makeFieldDeclarationNode(
            ModifiersNode modifiers,
            ListNode<VariableDeclaratorNode> declarators);

    /**
     * Creates a AnnotationArrayValueNode.
     */
    public AnnotationArrayValueNode makeAnnotationArrayValueNode(
            ListNode<AnnotationValueNode> values);

    /**
     * Creates a SingleElementAnnotationNode.
     */
    public SingleElementAnnotationNode makeSingleElementAnnotationNode(
            AnnotationValueNode value,
            RawTypeNode annotationType);

    /**
     * Creates a ClassLiteralNode.
     */
    public ClassLiteralNode makeClassLiteralNode(
            TypeNode value);

    /**
     * Creates a SuperMethodInvocationNode.
     */
    public SuperMethodInvocationNode makeSuperMethodInvocationNode(
            RawTypeNode type,
            IdentifierNode identifier,
            ListNode<ExpressionNode> arguments,
            ListNode<TypeNode> typeArguments);

    /**
     * Creates a ArrayInitializerNode.
     */
    public ArrayInitializerNode makeArrayInitializerNode(
            ListNode<VariableInitializerNode> initializers);

    /**
     * Creates a AnnotationExpressionValueNode.
     */
    public AnnotationExpressionValueNode makeAnnotationExpressionValueNode(
            ExpressionNode expression);

    /**
     * Creates a ReturnNode.
     */
    public ReturnNode makeReturnNode(
            ExpressionNode expression);

    /**
     * Creates a AssignmentNode.
     */
    public AssignmentNode makeAssignmentNode(
            ExpressionNode variable,
            AssignmentOperator operator,
            ExpressionNode expression);

    /**
     * Creates a MethodInvocationByExpressionNode.
     */
    public MethodInvocationByExpressionNode makeMethodInvocationByExpressionNode(
            PrimaryExpressionNode expression,
            IdentifierNode identifier,
            ListNode<ExpressionNode> arguments,
            ListNode<TypeNode> typeArguments);

    /**
     * Creates a InstanceOfNode.
     */
    public InstanceOfNode makeInstanceOfNode(
            ExpressionNode expression,
            TypeNode type);

    /**
     * Creates a ConditionalExpressionNode.
     */
    public ConditionalExpressionNode makeConditionalExpressionNode(
            ExpressionNode condition,
            ExpressionNode trueExpression,
            ExpressionNode falseExpression);

    /**
     * Creates a ParenthesizedExpressionNode.
     */
    public ParenthesizedExpressionNode makeParenthesizedExpressionNode(
            ExpressionNode expression);

    /**
     * Creates a FloatLiteralNode.
     */
    public FloatLiteralNode makeFloatLiteralNode(
            Float value);

    /**
     * Creates a BinaryOperatorNode.
     */
    public BinaryOperatorNode makeBinaryOperatorNode(
            ExpressionNode leftOperand,
            ExpressionNode rightOperand,
            BinaryOperator operator);

    /**
     * Creates a MethodInvocationByNameNode.
     */
    public MethodInvocationByNameNode makeMethodInvocationByNameNode(
            NameNode name,
            ListNode<ExpressionNode> arguments,
            ListNode<TypeNode> typeArguments);

    /**
     * Creates a ParameterizedTypeNode.
     */
    public ParameterizedTypeNode makeParameterizedTypeNode(
            RawTypeNode rawType,
            ListNode<TypeArgumentNode> typeArguments);

    /**
     * Creates a InterfaceDeclarationNode.
     */
    public InterfaceDeclarationNode makeInterfaceDeclarationNode(
            ListNode<TypeNode> extendsClause,
            InterfaceBodyNode body,
            ListNode<TypeParameterNode> typeParameters,
            IdentifierNode identifier,
            ModifiersNode modifiers);

    /**
     * Creates a ForInitializerDeclarationNode.
     */
    public ForInitializerDeclarationNode makeForInitializerDeclarationNode(
            VariableDeclarationNode declaration);

    /**
     * Creates a RawTypeNode.
     */
    public RawTypeNode makeRawTypeNode(
            NameNode name);

    /**
     * Creates a ConstructorBodyNode.
     */
    public ConstructorBodyNode makeConstructorBodyNode(
            ConstructorInvocationNode constructorInvocation,
            ListNode<StatementNode> statements);

    /**
     * Creates a UnqualifiedClassInstantiationNode.
     */
    public UnqualifiedClassInstantiationNode makeUnqualifiedClassInstantiationNode(
            DeclaredTypeNode type,
            ListNode<TypeNode> constructorTypeArguments,
            ListNode<ExpressionNode> arguments,
            AnonymousClassBodyNode body);

    /**
     * Creates a SimpleNameNode.
     */
    public SimpleNameNode makeSimpleNameNode(
            IdentifierNode identifier,
            NameCategory category);

    /**
     * Creates a ArrayInstantiatorCreationNode.
     */
    public ArrayInstantiatorCreationNode makeArrayInstantiatorCreationNode(
            ListNode<ExpressionNode> dimExpressions,
            BaseTypeNode baseType,
            int arrayLevels);

    /**
     * Creates a IfNode.
     */
    public IfNode makeIfNode(
            ExpressionNode condition,
            StatementNode thenStatement,
            StatementNode elseStatement);

    /**
     * Creates a ClassBodyNode.
     */
    public ClassBodyNode makeClassBodyNode(
            ListNode<ClassMemberNode> members);

    /**
     * Creates a IntLiteralNode.
     */
    public IntLiteralNode makeIntLiteralNode(
            Integer value);

    /**
     * Creates a NullLiteralNode.
     */
    public NullLiteralNode makeNullLiteralNode(
            Void value);

    /**
     * Creates a MethodDeclarationNode.
     */
    public MethodDeclarationNode makeMethodDeclarationNode(
            BlockStatementNode body,
            ModifiersNode modifiers,
            IdentifierNode identifier,
            ListNode<VariableNode> parameters,
            VariableNode varargParameter,
            TypeNode returnType,
            ListNode<RawTypeNode> throwTypes,
            ListNode<TypeParameterNode> typeParameters);

}
