package edu.jhu.cs.bsj.compiler.ast.util;

import java.util.List;
import java.util.Set;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.AssignmentOperator;
import edu.jhu.cs.bsj.compiler.ast.BinaryOperator;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.Modifier;
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
     * The decoration method.  This method is called after every node creation.
     * @param node The node that was just created.
     */
    protected abstract void decorate(Node node);

    /**
     * Creates a AssertStatementNode.
     */
    @Override
    public AssertStatementNode makeAssertStatementNode(
            ExpressionNode testExpression,
            ExpressionNode messageExpression)
    {
        AssertStatementNode node = factory.makeAssertStatementNode(testExpression, messageExpression);
        this.decorate(node);
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
        UnaryStatementExpressionNode node = factory.makeUnaryStatementExpressionNode(expression, operator);
        this.decorate(node);
        return node;
    }

    /**
     * Creates a ExpressionStatementNode.
     */
    @Override
    public ExpressionStatementNode makeExpressionStatementNode(
            StatementExpressionNode expression)
    {
        ExpressionStatementNode node = factory.makeExpressionStatementNode(expression);
        this.decorate(node);
        return node;
    }

    /**
     * Creates a InterfaceBodyNode.
     */
    @Override
    public InterfaceBodyNode makeInterfaceBodyNode(
            ListNode<InterfaceMemberNode> members)
    {
        InterfaceBodyNode node = factory.makeInterfaceBodyNode(members);
        this.decorate(node);
        return node;
    }

    /**
     * Creates a ClassDeclarationNode.
     */
    @Override
    public ClassDeclarationNode makeClassDeclarationNode(
            TypeNode extendsClause,
            ListNode<TypeNode> implementsClause,
            ClassBodyNode body,
            ListNode<TypeParameterNode> typeParameters,
            IdentifierNode identifier,
            ModifiersNode modifiers,
            JavadocNode javadoc)
    {
        ClassDeclarationNode node = factory.makeClassDeclarationNode(extendsClause, implementsClause, body, typeParameters, identifier, modifiers, javadoc);
        this.decorate(node);
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
        EnhancedForLoopNode node = factory.makeEnhancedForLoopNode(variable, expression, statement);
        this.decorate(node);
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
        ArrayAccessNode node = factory.makeArrayAccessNode(arrayExpression, indexExpression);
        this.decorate(node);
        return node;
    }

    /**
     * Creates a LongLiteralNode.
     */
    @Override
    public LongLiteralNode makeLongLiteralNode(
            Long value)
    {
        LongLiteralNode node = factory.makeLongLiteralNode(value);
        this.decorate(node);
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
        QualifiedNameNode node = factory.makeQualifiedNameNode(base, identifier, category);
        this.decorate(node);
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
        CaseNode node = factory.makeCaseNode(expression, statements);
        this.decorate(node);
        return node;
    }

    /**
     * Creates a VoidStatementNode.
     */
    @Override
    public VoidStatementNode makeVoidStatementNode()
    {
        VoidStatementNode node = factory.makeVoidStatementNode();
        this.decorate(node);
        return node;
    }

    /**
     * Creates a CodeLiteralNode.
     */
    @Override
    public CodeLiteralNode makeCodeLiteralNode(
            Node value)
    {
        CodeLiteralNode node = factory.makeCodeLiteralNode(value);
        this.decorate(node);
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
        ImportOnDemandNode node = factory.makeImportOnDemandNode(name, staticImport);
        this.decorate(node);
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
        SuperclassConstructorInvocationNode node = factory.makeSuperclassConstructorInvocationNode(qualifyingExpression, arguments, typeArguments);
        this.decorate(node);
        return node;
    }

    /**
     * Creates a PrimitiveTypeNode.
     */
    @Override
    public PrimitiveTypeNode makePrimitiveTypeNode(
            PrimitiveType primitiveType)
    {
        PrimitiveTypeNode node = factory.makePrimitiveTypeNode(primitiveType);
        this.decorate(node);
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
        InitializerDeclarationNode node = factory.makeInitializerDeclarationNode(staticInitializer, body);
        this.decorate(node);
        return node;
    }

    /**
     * Creates a ModifiersNode.
     */
    @Override
    public ModifiersNode makeModifiersNode(
            ListNode<AnnotationNode> annotations,
            Set<Modifier> flags)
    {
        ModifiersNode node = factory.makeModifiersNode(annotations, flags);
        this.decorate(node);
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
        EnumBodyNode node = factory.makeEnumBodyNode(constants, members);
        this.decorate(node);
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
        TryNode node = factory.makeTryNode(block, catches, finallyBlock);
        this.decorate(node);
        return node;
    }

    /**
     * Creates a ThisNode.
     */
    @Override
    public ThisNode makeThisNode(
            UnparameterizedTypeNode type)
    {
        ThisNode node = factory.makeThisNode(type);
        this.decorate(node);
        return node;
    }

    /**
     * Creates a EnumDeclarationNode.
     */
    @Override
    public EnumDeclarationNode makeEnumDeclarationNode(
            ListNode<TypeNode> implementsClause,
            EnumBodyNode body,
            IdentifierNode identifier,
            ModifiersNode modifiers,
            JavadocNode javadoc)
    {
        EnumDeclarationNode node = factory.makeEnumDeclarationNode(implementsClause, body, identifier, modifiers, javadoc);
        this.decorate(node);
        return node;
    }

    /**
     * Creates a VoidTypeNode.
     */
    @Override
    public VoidTypeNode makeVoidTypeNode()
    {
        VoidTypeNode node = factory.makeVoidTypeNode();
        this.decorate(node);
        return node;
    }

    /**
     * Creates a VariableDeclarationNode.
     */
    @Override
    public VariableDeclarationNode makeVariableDeclarationNode(
            ModifiersNode modifiers,
            ListNode<VariableDeclaratorNode> declarators)
    {
        VariableDeclarationNode node = factory.makeVariableDeclarationNode(modifiers, declarators);
        this.decorate(node);
        return node;
    }

    /**
     * Creates a AnnotationBodyNode.
     */
    @Override
    public AnnotationBodyNode makeAnnotationBodyNode(
            ListNode<AnnotationMemberNode> members)
    {
        AnnotationBodyNode node = factory.makeAnnotationBodyNode(members);
        this.decorate(node);
        return node;
    }

    /**
     * Creates a UnparameterizedTypeNode.
     */
    @Override
    public UnparameterizedTypeNode makeUnparameterizedTypeNode(
            NameNode name)
    {
        UnparameterizedTypeNode node = factory.makeUnparameterizedTypeNode(name);
        this.decorate(node);
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
        VariableDeclaratorNode node = factory.makeVariableDeclaratorNode(type, name, initializer);
        this.decorate(node);
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
        FieldAccessByExpressionNode node = factory.makeFieldAccessByExpressionNode(expression, identifier);
        this.decorate(node);
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
        SuperFieldAccessNode node = factory.makeSuperFieldAccessNode(type, identifier);
        this.decorate(node);
        return node;
    }

    /**
     * Creates a ThrowNode.
     */
    @Override
    public ThrowNode makeThrowNode(
            ExpressionNode expression)
    {
        ThrowNode node = factory.makeThrowNode(expression);
        this.decorate(node);
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
        CatchNode node = factory.makeCatchNode(block, parameter);
        this.decorate(node);
        return node;
    }

    /**
     * Creates a VoidTypeDeclarationNode.
     */
    @Override
    public VoidTypeDeclarationNode makeVoidTypeDeclarationNode()
    {
        VoidTypeDeclarationNode node = factory.makeVoidTypeDeclarationNode();
        this.decorate(node);
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
        NormalAnnotationNode node = factory.makeNormalAnnotationNode(arguments, annotationType);
        this.decorate(node);
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
        DoWhileLoopNode node = factory.makeDoWhileLoopNode(condition, statement);
        this.decorate(node);
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
        QualifiedClassInstantiationNode node = factory.makeQualifiedClassInstantiationNode(enclosingExpression, identifier, typeArguments, constructorTypeArguments, arguments, body);
        this.decorate(node);
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
        TypeCastNode node = factory.makeTypeCastNode(expression, type);
        this.decorate(node);
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
        LabeledStatementNode node = factory.makeLabeledStatementNode(label, statement);
        this.decorate(node);
        return node;
    }

    /**
     * Creates a BlockStatementNode.
     */
    @Override
    public BlockStatementNode makeBlockStatementNode(
            ListNode<StatementNode> statements)
    {
        BlockStatementNode node = factory.makeBlockStatementNode(statements);
        this.decorate(node);
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
        BinaryExpressionNode node = factory.makeBinaryExpressionNode(leftOperand, rightOperand, operator);
        this.decorate(node);
        return node;
    }

    /**
     * Creates a ForInitializerExpressionNode.
     */
    @Override
    public ForInitializerExpressionNode makeForInitializerExpressionNode(
            ListNode<StatementExpressionNode> expressions)
    {
        ForInitializerExpressionNode node = factory.makeForInitializerExpressionNode(expressions);
        this.decorate(node);
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
        PackageDeclarationNode node = factory.makePackageDeclarationNode(name, annotations);
        this.decorate(node);
        return node;
    }

    /**
     * Creates a AnnotationDeclarationNode.
     */
    @Override
    public AnnotationDeclarationNode makeAnnotationDeclarationNode(
            AnnotationBodyNode body,
            IdentifierNode identifier,
            ModifiersNode modifiers,
            JavadocNode javadoc)
    {
        AnnotationDeclarationNode node = factory.makeAnnotationDeclarationNode(body, identifier, modifiers, javadoc);
        this.decorate(node);
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
        CompilationUnitNode node = factory.makeCompilationUnitNode(packageDeclaration, imports, typeDecls);
        this.decorate(node);
        return node;
    }

    /**
     * Creates a ContinueNode.
     */
    @Override
    public ContinueNode makeContinueNode(
            IdentifierNode label)
    {
        ContinueNode node = factory.makeContinueNode(label);
        this.decorate(node);
        return node;
    }

    /**
     * Creates a StringLiteralNode.
     */
    @Override
    public StringLiteralNode makeStringLiteralNode(
            String value)
    {
        StringLiteralNode node = factory.makeStringLiteralNode(value);
        this.decorate(node);
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
        AnnotationElementNode node = factory.makeAnnotationElementNode(identifier, value);
        this.decorate(node);
        return node;
    }

    /**
     * Creates a DoubleLiteralNode.
     */
    @Override
    public DoubleLiteralNode makeDoubleLiteralNode(
            Double value)
    {
        DoubleLiteralNode node = factory.makeDoubleLiteralNode(value);
        this.decorate(node);
        return node;
    }

    /**
     * Creates a AnonymousClassBodyNode.
     */
    @Override
    public AnonymousClassBodyNode makeAnonymousClassBodyNode(
            ListNode<AnonymousClassMemberNode> members)
    {
        AnonymousClassBodyNode node = factory.makeAnonymousClassBodyNode(members);
        this.decorate(node);
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
        SynchronizedNode node = factory.makeSynchronizedNode(expression, block);
        this.decorate(node);
        return node;
    }

    /**
     * Creates a VariableNode.
     */
    @Override
    public VariableNode makeVariableNode(
            ModifiersNode modifiers,
            TypeNode type,
            IdentifierNode identifier)
    {
        VariableNode node = factory.makeVariableNode(modifiers, type, identifier);
        this.decorate(node);
        return node;
    }

    /**
     * Creates a CharLiteralNode.
     */
    @Override
    public CharLiteralNode makeCharLiteralNode(
            Character value)
    {
        CharLiteralNode node = factory.makeCharLiteralNode(value);
        this.decorate(node);
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
        WildcardTypeNode node = factory.makeWildcardTypeNode(bound, upperBound);
        this.decorate(node);
        return node;
    }

    /**
     * Creates a InlineTypeDeclarationNode.
     */
    @Override
    public InlineTypeDeclarationNode makeInlineTypeDeclarationNode(
            InlineTypeDeclarableNode declaration)
    {
        InlineTypeDeclarationNode node = factory.makeInlineTypeDeclarationNode(declaration);
        this.decorate(node);
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
        UnaryExpressionNode node = factory.makeUnaryExpressionNode(expression, operator);
        this.decorate(node);
        return node;
    }

    /**
     * Creates a BooleanLiteralNode.
     */
    @Override
    public BooleanLiteralNode makeBooleanLiteralNode(
            Boolean value)
    {
        BooleanLiteralNode node = factory.makeBooleanLiteralNode(value);
        this.decorate(node);
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
        SwitchNode node = factory.makeSwitchNode(expression, cases);
        this.decorate(node);
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
        AlternateConstructorInvocationNode node = factory.makeAlternateConstructorInvocationNode(arguments, typeArguments);
        this.decorate(node);
        return node;
    }

    /**
     * Creates a ConstructorDeclarationNode.
     */
    @Override
    public ConstructorDeclarationNode makeConstructorDeclarationNode(
            ConstructorBodyNode body,
            ModifiersNode modifiers,
            ListNode<VariableNode> parameters,
            VariableNode varargParameter,
            ListNode<UnparameterizedTypeNode> throwTypes,
            ListNode<TypeParameterNode> typeParameters,
            JavadocNode javadoc)
    {
        ConstructorDeclarationNode node = factory.makeConstructorDeclarationNode(body, modifiers, parameters, varargParameter, throwTypes, typeParameters, javadoc);
        this.decorate(node);
        return node;
    }

    /**
     * Creates a AnnotationAnnotationValueNode.
     */
    @Override
    public AnnotationAnnotationValueNode makeAnnotationAnnotationValueNode(
            AnnotationNode annotation)
    {
        AnnotationAnnotationValueNode node = factory.makeAnnotationAnnotationValueNode(annotation);
        this.decorate(node);
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
        ForLoopNode node = factory.makeForLoopNode(initializer, condition, update, statement);
        this.decorate(node);
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
        WhileLoopNode node = factory.makeWhileLoopNode(condition, statement);
        this.decorate(node);
        return node;
    }

    /**
     * Creates a ListNode.
     */
    @Override
    public <T extends Node> ListNode<T> makeListNode(
            List<T> children)
    {
        ListNode<T> node = factory.makeListNode(children);
        this.decorate(node);
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
        EnumConstantDeclarationNode node = factory.makeEnumConstantDeclarationNode(annotations, identifier, arguments, body, javadoc);
        this.decorate(node);
        return node;
    }

    /**
     * Creates a BreakNode.
     */
    @Override
    public BreakNode makeBreakNode(
            IdentifierNode label)
    {
        BreakNode node = factory.makeBreakNode(label);
        this.decorate(node);
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
        ParameterizedTypeSelectNode node = factory.makeParameterizedTypeSelectNode(base, select);
        this.decorate(node);
        return node;
    }

    /**
     * Creates a IdentifierNode.
     */
    @Override
    public IdentifierNode makeIdentifierNode(
            String identifier)
    {
        IdentifierNode node = factory.makeIdentifierNode(identifier);
        this.decorate(node);
        return node;
    }

    /**
     * Creates a ArrayTypeNode.
     */
    @Override
    public ArrayTypeNode makeArrayTypeNode(
            TypeNode type)
    {
        ArrayTypeNode node = factory.makeArrayTypeNode(type);
        this.decorate(node);
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
        ArrayInitializerCreationNode node = factory.makeArrayInitializerCreationNode(initializer, baseType, arrayLevels);
        this.decorate(node);
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
        TypeParameterNode node = factory.makeTypeParameterNode(identifier, bounds);
        this.decorate(node);
        return node;
    }

    /**
     * Creates a AnnotationMethodDeclarationNode.
     */
    @Override
    public AnnotationMethodDeclarationNode makeAnnotationMethodDeclarationNode(
            ModifiersNode modifiers,
            TypeNode type,
            IdentifierNode identifier,
            AnnotationValueNode defaultValue,
            JavadocNode javadoc)
    {
        AnnotationMethodDeclarationNode node = factory.makeAnnotationMethodDeclarationNode(modifiers, type, identifier, defaultValue, javadoc);
        this.decorate(node);
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
        ImportSingleTypeNode node = factory.makeImportSingleTypeNode(name, staticImport);
        this.decorate(node);
        return node;
    }

    /**
     * Creates a FieldDeclarationNode.
     */
    @Override
    public FieldDeclarationNode makeFieldDeclarationNode(
            ModifiersNode modifiers,
            ListNode<VariableDeclaratorNode> declarators,
            JavadocNode javadoc)
    {
        FieldDeclarationNode node = factory.makeFieldDeclarationNode(modifiers, declarators, javadoc);
        this.decorate(node);
        return node;
    }

    /**
     * Creates a AnnotationArrayValueNode.
     */
    @Override
    public AnnotationArrayValueNode makeAnnotationArrayValueNode(
            ListNode<AnnotationValueNode> values)
    {
        AnnotationArrayValueNode node = factory.makeAnnotationArrayValueNode(values);
        this.decorate(node);
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
        SingleElementAnnotationNode node = factory.makeSingleElementAnnotationNode(value, annotationType);
        this.decorate(node);
        return node;
    }

    /**
     * Creates a ClassLiteralNode.
     */
    @Override
    public ClassLiteralNode makeClassLiteralNode(
            LiteralizableTypeNode value)
    {
        ClassLiteralNode node = factory.makeClassLiteralNode(value);
        this.decorate(node);
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
        SuperMethodInvocationNode node = factory.makeSuperMethodInvocationNode(type, identifier, arguments, typeArguments);
        this.decorate(node);
        return node;
    }

    /**
     * Creates a ArrayInitializerNode.
     */
    @Override
    public ArrayInitializerNode makeArrayInitializerNode(
            ListNode<VariableInitializerNode> initializers)
    {
        ArrayInitializerNode node = factory.makeArrayInitializerNode(initializers);
        this.decorate(node);
        return node;
    }

    /**
     * Creates a AnnotationExpressionValueNode.
     */
    @Override
    public AnnotationExpressionValueNode makeAnnotationExpressionValueNode(
            NonAssignmentExpressionNode expression)
    {
        AnnotationExpressionValueNode node = factory.makeAnnotationExpressionValueNode(expression);
        this.decorate(node);
        return node;
    }

    /**
     * Creates a ReturnNode.
     */
    @Override
    public ReturnNode makeReturnNode(
            ExpressionNode expression)
    {
        ReturnNode node = factory.makeReturnNode(expression);
        this.decorate(node);
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
        AssignmentNode node = factory.makeAssignmentNode(variable, operator, expression);
        this.decorate(node);
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
        MethodInvocationByExpressionNode node = factory.makeMethodInvocationByExpressionNode(expression, identifier, arguments, typeArguments);
        this.decorate(node);
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
        InstanceOfNode node = factory.makeInstanceOfNode(expression, type);
        this.decorate(node);
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
        ConditionalExpressionNode node = factory.makeConditionalExpressionNode(condition, trueExpression, falseExpression);
        this.decorate(node);
        return node;
    }

    /**
     * Creates a ParenthesizedExpressionNode.
     */
    @Override
    public ParenthesizedExpressionNode makeParenthesizedExpressionNode(
            ExpressionNode expression)
    {
        ParenthesizedExpressionNode node = factory.makeParenthesizedExpressionNode(expression);
        this.decorate(node);
        return node;
    }

    /**
     * Creates a FloatLiteralNode.
     */
    @Override
    public FloatLiteralNode makeFloatLiteralNode(
            Float value)
    {
        FloatLiteralNode node = factory.makeFloatLiteralNode(value);
        this.decorate(node);
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
        MethodInvocationByNameNode node = factory.makeMethodInvocationByNameNode(name, arguments, typeArguments);
        this.decorate(node);
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
        ParameterizedTypeNode node = factory.makeParameterizedTypeNode(baseType, typeArguments);
        this.decorate(node);
        return node;
    }

    /**
     * Creates a InterfaceDeclarationNode.
     */
    @Override
    public InterfaceDeclarationNode makeInterfaceDeclarationNode(
            ListNode<TypeNode> extendsClause,
            InterfaceBodyNode body,
            ListNode<TypeParameterNode> typeParameters,
            IdentifierNode identifier,
            ModifiersNode modifiers,
            JavadocNode javadoc)
    {
        InterfaceDeclarationNode node = factory.makeInterfaceDeclarationNode(extendsClause, body, typeParameters, identifier, modifiers, javadoc);
        this.decorate(node);
        return node;
    }

    /**
     * Creates a ForInitializerDeclarationNode.
     */
    @Override
    public ForInitializerDeclarationNode makeForInitializerDeclarationNode(
            VariableDeclarationNode declaration)
    {
        ForInitializerDeclarationNode node = factory.makeForInitializerDeclarationNode(declaration);
        this.decorate(node);
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
        ConstructorBodyNode node = factory.makeConstructorBodyNode(constructorInvocation, statements);
        this.decorate(node);
        return node;
    }

    /**
     * Creates a FieldAccessByNameNode.
     */
    @Override
    public FieldAccessByNameNode makeFieldAccessByNameNode(
            NameNode name)
    {
        FieldAccessByNameNode node = factory.makeFieldAccessByNameNode(name);
        this.decorate(node);
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
        UnqualifiedClassInstantiationNode node = factory.makeUnqualifiedClassInstantiationNode(type, constructorTypeArguments, arguments, body);
        this.decorate(node);
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
        SimpleNameNode node = factory.makeSimpleNameNode(identifier, category);
        this.decorate(node);
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
        ArrayInstantiatorCreationNode node = factory.makeArrayInstantiatorCreationNode(dimExpressions, baseType, arrayLevels);
        this.decorate(node);
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
        IfNode node = factory.makeIfNode(condition, thenStatement, elseStatement);
        this.decorate(node);
        return node;
    }

    /**
     * Creates a ClassBodyNode.
     */
    @Override
    public ClassBodyNode makeClassBodyNode(
            ListNode<ClassMemberNode> members)
    {
        ClassBodyNode node = factory.makeClassBodyNode(members);
        this.decorate(node);
        return node;
    }

    /**
     * Creates a IntLiteralNode.
     */
    @Override
    public IntLiteralNode makeIntLiteralNode(
            Integer value)
    {
        IntLiteralNode node = factory.makeIntLiteralNode(value);
        this.decorate(node);
        return node;
    }

    /**
     * Creates a NullLiteralNode.
     */
    @Override
    public NullLiteralNode makeNullLiteralNode(
            Void value)
    {
        NullLiteralNode node = factory.makeNullLiteralNode(value);
        this.decorate(node);
        return node;
    }

    /**
     * Creates a JavadocNode.
     */
    @Override
    public JavadocNode makeJavadocNode(
            String text)
    {
        JavadocNode node = factory.makeJavadocNode(text);
        this.decorate(node);
        return node;
    }

    /**
     * Creates a MethodDeclarationNode.
     */
    @Override
    public MethodDeclarationNode makeMethodDeclarationNode(
            BlockStatementNode body,
            ModifiersNode modifiers,
            IdentifierNode identifier,
            ListNode<VariableNode> parameters,
            VariableNode varargParameter,
            TypeNode returnType,
            ListNode<UnparameterizedTypeNode> throwTypes,
            ListNode<TypeParameterNode> typeParameters,
            JavadocNode javadoc)
    {
        MethodDeclarationNode node = factory.makeMethodDeclarationNode(body, modifiers, identifier, parameters, varargParameter, returnType, throwTypes, typeParameters, javadoc);
        this.decorate(node);
        return node;
    }

}
