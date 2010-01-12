package edu.jhu.cs.bsj.compiler.ast;

import java.util.List;
import java.util.Set;

import edu.jhu.cs.bsj.compiler.ast.node.*;
import edu.jhu.cs.bsj.compiler.ast.node.meta.CodeLiteralNode;
import edu.jhu.cs.bsj.compiler.ast.tags.AnnotationMember;
import edu.jhu.cs.bsj.compiler.ast.tags.AnonymousClassMember;
import edu.jhu.cs.bsj.compiler.ast.tags.BaseType;
import edu.jhu.cs.bsj.compiler.ast.tags.BoundType;
import edu.jhu.cs.bsj.compiler.ast.tags.ClassMember;
import edu.jhu.cs.bsj.compiler.ast.tags.InlineTypeDeclarable;
import edu.jhu.cs.bsj.compiler.ast.tags.InterfaceMember;
import edu.jhu.cs.bsj.compiler.ast.tags.TypeArgument;

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
            ListNode<? extends InterfaceMember> members);

    /**
     * Creates a MethodInvocationNode.
     */
    public MethodInvocationNode makeMethodInvocationNode(
            NameNode method,
            ListNode<? extends ExpressionNode> arguments,
            ListNode<? extends TypeNode> typeArguments);

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
            ListNode<? extends TypeNode> implementsClause,
            ClassBodyNode body,
            ListNode<? extends TypeParameterNode> typeParameters,
            IdentifierNode identifier,
            ModifiersNode modifiers);

    /**
     * Creates a ArrayAccessNode.
     */
    public ArrayAccessNode makeArrayAccessNode(
            ExpressionNode expression,
            ExpressionNode index);

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
     * Creates a VoidStatementNode.
     */
    public VoidStatementNode makeVoidStatementNode();

    /**
     * Creates a CaseNode.
     */
    public CaseNode makeCaseNode(
            ExpressionNode expression,
            ListNode<? extends StatementNode> statements);

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
            ExpressionNode qualifyingExpression,
            ListNode<? extends ExpressionNode> arguments,
            ListNode<? extends TypeNode> typeArguments);

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
            ListNode<? extends AnnotationNode> annotations,
            Set<Modifier> flags);

    /**
     * Creates a EnumBodyNode.
     */
    public EnumBodyNode makeEnumBodyNode(
            ListNode<? extends EnumConstantDeclarationNode> constants,
            ListNode<? extends ClassMember> members);

    /**
     * Creates a TryNode.
     */
    public TryNode makeTryNode(
            BlockStatementNode block,
            ListNode<? extends CatchNode> catches,
            BlockStatementNode finallyBlock);

    /**
     * Creates a ThisNode.
     */
    public ThisNode makeThisNode(
            NameNode type);

    /**
     * Creates a EnumDeclarationNode.
     */
    public EnumDeclarationNode makeEnumDeclarationNode(
            ListNode<? extends TypeNode> implementsClause,
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
            ListNode<? extends AnnotationMember> members);

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
     * Creates a ThrowNode.
     */
    public ThrowNode makeThrowNode(
            ExpressionNode expression);

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
            ListNode<? extends AnnotationElementNode> arguments,
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
            ListNode<? extends TypeNode> typeArguments,
            ListNode<? extends TypeNode> constructorTypeArguments,
            ListNode<? extends ExpressionNode> arguments,
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
            ListNode<? extends StatementNode> statements);

    /**
     * Creates a ForInitializerExpressionNode.
     */
    public ForInitializerExpressionNode makeForInitializerExpressionNode(
            ListNode<? extends ExpressionNode> expressions);

    /**
     * Creates a PackageDeclarationNode.
     */
    public PackageDeclarationNode makePackageDeclarationNode(
            NameNode name,
            ListNode<? extends AnnotationNode> annotations);

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
            ListNode<? extends ImportNode> imports,
            ListNode<? extends TypeDeclarationNode> typeDecls);

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
            ListNode<? extends AnonymousClassMember> members);

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
            InlineTypeDeclarable declaration);

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
            ListNode<? extends CaseNode> cases);

    /**
     * Creates a AlternateConstructorInvocationNode.
     */
    public AlternateConstructorInvocationNode makeAlternateConstructorInvocationNode(
            ListNode<? extends ExpressionNode> arguments,
            ListNode<? extends TypeNode> typeArguments);

    /**
     * Creates a ConstructorDeclarationNode.
     */
    public ConstructorDeclarationNode makeConstructorDeclarationNode(
            ConstructorBodyNode body,
            ModifiersNode modifiers,
            ListNode<? extends VariableNode> parameters,
            VariableNode varargParameter,
            ListNode<? extends RawTypeNode> throwTypes,
            ListNode<? extends TypeParameterNode> typeParameters);

    /**
     * Creates a AnnotationAnnotationValueNode.
     */
    public AnnotationAnnotationValueNode makeAnnotationAnnotationValueNode(
            AnnotationNode annotation);

    /**
     * Creates a WhileLoopNode.
     */
    public WhileLoopNode makeWhileLoopNode(
            ExpressionNode condition,
            StatementNode statement);

    /**
     * Creates a ForLoopNode.
     */
    public ForLoopNode makeForLoopNode(
            ForInitializerNode initializer,
            ListNode<? extends ExpressionStatementNode> update,
            ExpressionNode condition,
            StatementNode statement);

    /**
     * Creates a ListNode.
     */
    public <T extends Node> ListNode<T> makeListNode(
            List<? extends T> children);

    /**
     * Creates a EnumConstantDeclarationNode.
     */
    public EnumConstantDeclarationNode makeEnumConstantDeclarationNode(
            ListNode<? extends AnnotationNode> annotations,
            IdentifierNode identifier,
            ListNode<? extends ExpressionNode> arguments,
            AnonymousClassBodyNode body);

    /**
     * Creates a BreakNode.
     */
    public BreakNode makeBreakNode(
            IdentifierNode label);

    /**
     * Creates a ArrayTypeNode.
     */
    public ArrayTypeNode makeArrayTypeNode(
            TypeNode type);

    /**
     * Creates a IdentifierNode.
     */
    public IdentifierNode makeIdentifierNode(
            String identifier);

    /**
     * Creates a ArrayInitializerCreationNode.
     */
    public ArrayInitializerCreationNode makeArrayInitializerCreationNode(
            ArrayInitializerNode initializer,
            BaseType baseType,
            int arrayLevels);

    /**
     * Creates a TypeParameterNode.
     */
    public TypeParameterNode makeTypeParameterNode(
            IdentifierNode identifier,
            ListNode<? extends BoundType> bounds);

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
            ListNode<? extends AnnotationValueNode> values);

    /**
     * Creates a ClassLiteralNode.
     */
    public ClassLiteralNode makeClassLiteralNode(
            TypeNode value);

    /**
     * Creates a SingleElementAnnotationNode.
     */
    public SingleElementAnnotationNode makeSingleElementAnnotationNode(
            AnnotationValueNode value,
            RawTypeNode annotationType);

    /**
     * Creates a ArrayInitializerNode.
     */
    public ArrayInitializerNode makeArrayInitializerNode(
            ListNode<? extends VariableInitializerNode> initializers);

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
     * Creates a ParameterizedTypeNode.
     */
    public ParameterizedTypeNode makeParameterizedTypeNode(
            RawTypeNode rawType,
            ListNode<TypeArgument> typeArguments);

    /**
     * Creates a InterfaceDeclarationNode.
     */
    public InterfaceDeclarationNode makeInterfaceDeclarationNode(
            ListNode<? extends TypeNode> extendsClause,
            InterfaceBodyNode body,
            ListNode<? extends TypeParameterNode> typeParameters,
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
            ListNode<? extends StatementNode> statements);

    /**
     * Creates a UnqualifiedClassInstantiationNode.
     */
    public UnqualifiedClassInstantiationNode makeUnqualifiedClassInstantiationNode(
            DeclaredTypeNode type,
            ListNode<? extends TypeNode> constructorTypeArguments,
            ListNode<? extends ExpressionNode> arguments,
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
            ListNode<? extends ExpressionNode> dimExpressions,
            BaseType baseType,
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
            ListNode<? extends ClassMember> members);

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
            ListNode<? extends VariableNode> parameters,
            VariableNode varargParameter,
            TypeNode returnType,
            ListNode<? extends RawTypeNode> throwTypes,
            ListNode<? extends TypeParameterNode> typeParameters);

}
