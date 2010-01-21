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
import edu.jhu.cs.bsj.compiler.ast.node.meta.CodeLiteralNode;

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
     * Creates a UnaryStatementExpressionNode.
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
     * Creates a InterfaceBodyNode.
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
     * Creates a ExpressionStatementNode.
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
     * Creates a ClassDeclarationNode.
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
     * Creates a EnhancedForLoopNode.
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
     * Creates a ArrayAccessNode.
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
     * Creates a LongLiteralNode.
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
     * Creates a QualifiedNameNode.
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
     * Creates a CaseNode.
     */
    @Override
    public CaseNode makeCaseNode(
            ExpressionNode expression,
            ListNode<StatementNode> statements)
    {
        this.before();
        CaseNode node = factory.makeCaseNode(expression, statements);
        this.after(node);
        return node;
    }

    /**
     * Creates a VoidStatementNode.
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
     * Creates a CodeLiteralNode.
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
     * Creates a ImportOnDemandNode.
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
     * Creates a VariableModifiersNode.
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
     * Creates a InterfaceModifiersNode.
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
     * Creates a SuperclassConstructorInvocationNode.
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
     * Creates a PrimitiveTypeNode.
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
     * Creates a InitializerDeclarationNode.
     */
    @Override
    public InitializerDeclarationNode makeInitializerDeclarationNode(
            boolean staticInitializer,
            BlockStatementNode body)
    {
        this.before();
        InitializerDeclarationNode node = factory.makeInitializerDeclarationNode(staticInitializer, body);
        this.after(node);
        return node;
    }

    /**
     * Creates a EnumBodyNode.
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
     * Creates a TryNode.
     */
    @Override
    public TryNode makeTryNode(
            BlockStatementNode block,
            ListNode<CatchNode> catches,
            BlockStatementNode finallyBlock)
    {
        this.before();
        TryNode node = factory.makeTryNode(block, catches, finallyBlock);
        this.after(node);
        return node;
    }

    /**
     * Creates a ThisNode.
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
     * Creates a EnumDeclarationNode.
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
     * Creates a VoidTypeNode.
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
     * Creates a VariableDeclarationNode.
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
     * Creates a AnnotationBodyNode.
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
     * Creates a UnparameterizedTypeNode.
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
     * Creates a VariableDeclaratorNode.
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
     * Creates a AnnotationModifiersNode.
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
     * Creates a FieldAccessByExpressionNode.
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
     * Creates a SuperFieldAccessNode.
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
     * Creates a ThrowNode.
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
     * Creates a EnumModifiersNode.
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
     * Creates a CatchNode.
     */
    @Override
    public CatchNode makeCatchNode(
            BlockStatementNode block,
            VariableNode parameter)
    {
        this.before();
        CatchNode node = factory.makeCatchNode(block, parameter);
        this.after(node);
        return node;
    }

    /**
     * Creates a VoidTypeDeclarationNode.
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
     * Creates a NormalAnnotationNode.
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
     * Creates a DoWhileLoopNode.
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
     * Creates a QualifiedClassInstantiationNode.
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
     * Creates a TypeCastNode.
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
     * Creates a LabeledStatementNode.
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
     * Creates a BlockStatementNode.
     */
    @Override
    public BlockStatementNode makeBlockStatementNode(
            ListNode<StatementNode> statements)
    {
        this.before();
        BlockStatementNode node = factory.makeBlockStatementNode(statements);
        this.after(node);
        return node;
    }

    /**
     * Creates a BinaryExpressionNode.
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
     * Creates a ForInitializerExpressionNode.
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
     * Creates a PackageDeclarationNode.
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
     * Creates a AnnotationDeclarationNode.
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
     * Creates a CompilationUnitNode.
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
     * Creates a ContinueNode.
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
     * Creates a StringLiteralNode.
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
     * Creates a AnnotationElementNode.
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
     * Creates a DoubleLiteralNode.
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
     * Creates a AnonymousClassBodyNode.
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
     * Creates a SynchronizedNode.
     */
    @Override
    public SynchronizedNode makeSynchronizedNode(
            ExpressionNode expression,
            BlockStatementNode block)
    {
        this.before();
        SynchronizedNode node = factory.makeSynchronizedNode(expression, block);
        this.after(node);
        return node;
    }

    /**
     * Creates a VariableNode.
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
     * Creates a CharLiteralNode.
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
     * Creates a WildcardTypeNode.
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
     * Creates a InlineTypeDeclarationNode.
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
     * Creates a UnaryExpressionNode.
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
     * Creates a BooleanLiteralNode.
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
     * Creates a SwitchNode.
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
     * Creates a AlternateConstructorInvocationNode.
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
     * Creates a AnnotationMethodModifiersNode.
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
     * Creates a ConstructorDeclarationNode.
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
     * Creates a AnnotationAnnotationValueNode.
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
     * Creates a ForLoopNode.
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
     * Creates a WhileLoopNode.
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
     * Creates a ListNode.
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
     * Creates a EnumConstantDeclarationNode.
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
     * Creates a BreakNode.
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
     * Creates a ConstructorModifiersNode.
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
     * Creates a ParameterizedTypeSelectNode.
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
     * Creates a IdentifierNode.
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
     * Creates a ArrayTypeNode.
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
     * Creates a ArrayInitializerCreationNode.
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
     * Creates a FieldModifiersNode.
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
     * Creates a TypeParameterNode.
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
     * Creates a AnnotationMethodDeclarationNode.
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
     * Creates a ImportSingleTypeNode.
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
     * Creates a FieldDeclarationNode.
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
     * Creates a AnnotationArrayValueNode.
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
     * Creates a SingleElementAnnotationNode.
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
     * Creates a ClassLiteralNode.
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
     * Creates a SuperMethodInvocationNode.
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
     * Creates a ClassModifiersNode.
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
     * Creates a ArrayInitializerNode.
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
     * Creates a AnnotationExpressionValueNode.
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
     * Creates a ReturnNode.
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
     * Creates a AssignmentNode.
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
     * Creates a MethodInvocationByExpressionNode.
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
     * Creates a InstanceOfNode.
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
     * Creates a ConditionalExpressionNode.
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
     * Creates a ParenthesizedExpressionNode.
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
     * Creates a FloatLiteralNode.
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
     * Creates a MethodInvocationByNameNode.
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
     * Creates a ParameterizedTypeNode.
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
     * Creates a InterfaceDeclarationNode.
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
     * Creates a ForInitializerDeclarationNode.
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
     * Creates a ConstructorBodyNode.
     */
    @Override
    public ConstructorBodyNode makeConstructorBodyNode(
            ConstructorInvocationNode constructorInvocation,
            ListNode<StatementNode> statements)
    {
        this.before();
        ConstructorBodyNode node = factory.makeConstructorBodyNode(constructorInvocation, statements);
        this.after(node);
        return node;
    }

    /**
     * Creates a FieldAccessByNameNode.
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
     * Creates a UnqualifiedClassInstantiationNode.
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
     * Creates a SimpleNameNode.
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
     * Creates a ArrayInstantiatorCreationNode.
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
     * Creates a MethodModifiersNode.
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
     * Creates a ClassBodyNode.
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
     * Creates a IfNode.
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
     * Creates a IntLiteralNode.
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
     * Creates a NullLiteralNode.
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
     * Creates a JavadocNode.
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
     * Creates a MethodDeclarationNode.
     */
    @Override
    public MethodDeclarationNode makeMethodDeclarationNode(
            BlockStatementNode body,
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

}
