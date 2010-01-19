package edu.jhu.cs.bsj.compiler.impl.ast;

import java.util.List;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.AccessModifier;
import edu.jhu.cs.bsj.compiler.ast.AssignmentOperator;
import edu.jhu.cs.bsj.compiler.ast.BinaryOperator;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.NameCategory;
import edu.jhu.cs.bsj.compiler.ast.PrimitiveType;
import edu.jhu.cs.bsj.compiler.ast.UnaryOperator;
import edu.jhu.cs.bsj.compiler.ast.UnaryStatementOperator;
import edu.jhu.cs.bsj.compiler.ast.node.*;
import edu.jhu.cs.bsj.compiler.ast.node.meta.CodeLiteralNode;
import edu.jhu.cs.bsj.compiler.impl.ast.node.*;
import edu.jhu.cs.bsj.compiler.impl.ast.node.meta.CodeLiteralNodeImpl;

/**
 * This class acts as a BSJ node factory for the standard BSJ compiler.
 *
 * @author Zachary Palmer
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class BsjNodeFactoryImpl implements BsjNodeFactory
{
    /**
     * Creates a AssertStatementNode.
     */
    @Override
    public AssertStatementNode makeAssertStatementNode(
            ExpressionNode testExpression,
            ExpressionNode messageExpression)
    {
        AssertStatementNode ret = new AssertStatementNodeImpl(testExpression, messageExpression);
        return ret;
    }

    /**
     * Creates a UnaryStatementExpressionNode.
     */
    @Override
    public UnaryStatementExpressionNode makeUnaryStatementExpressionNode(
            ExpressionNode expression,
            UnaryStatementOperator operator)
    {
        UnaryStatementExpressionNode ret = new UnaryStatementExpressionNodeImpl(expression, operator);
        return ret;
    }

    /**
     * Creates a InterfaceBodyNode.
     */
    @Override
    public InterfaceBodyNode makeInterfaceBodyNode(
            ListNode<InterfaceMemberNode> members)
    {
        InterfaceBodyNode ret = new InterfaceBodyNodeImpl(members);
        return ret;
    }

    /**
     * Creates a ExpressionStatementNode.
     */
    @Override
    public ExpressionStatementNode makeExpressionStatementNode(
            StatementExpressionNode expression)
    {
        ExpressionStatementNode ret = new ExpressionStatementNodeImpl(expression);
        return ret;
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
        ClassDeclarationNode ret = new ClassDeclarationNodeImpl(modifiers, extendsClause, implementsClause, body, typeParameters, identifier, javadoc);
        return ret;
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
        EnhancedForLoopNode ret = new EnhancedForLoopNodeImpl(variable, expression, statement);
        return ret;
    }

    /**
     * Creates a ArrayAccessNode.
     */
    @Override
    public ArrayAccessNode makeArrayAccessNode(
            RestrictedPrimaryExpressionNode arrayExpression,
            ExpressionNode indexExpression)
    {
        ArrayAccessNode ret = new ArrayAccessNodeImpl(arrayExpression, indexExpression);
        return ret;
    }

    /**
     * Creates a LongLiteralNode.
     */
    @Override
    public LongLiteralNode makeLongLiteralNode(
            Long value)
    {
        LongLiteralNode ret = new LongLiteralNodeImpl(value);
        return ret;
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
        QualifiedNameNode ret = new QualifiedNameNodeImpl(base, identifier, category);
        return ret;
    }

    /**
     * Creates a CaseNode.
     */
    @Override
    public CaseNode makeCaseNode(
            ExpressionNode expression,
            ListNode<StatementNode> statements)
    {
        CaseNode ret = new CaseNodeImpl(expression, statements);
        return ret;
    }

    /**
     * Creates a VoidStatementNode.
     */
    @Override
    public VoidStatementNode makeVoidStatementNode()
    {
        VoidStatementNode ret = new VoidStatementNodeImpl();
        return ret;
    }

    /**
     * Creates a CodeLiteralNode.
     */
    @Override
    public CodeLiteralNode makeCodeLiteralNode(
            Node value)
    {
        CodeLiteralNode ret = new CodeLiteralNodeImpl(value);
        return ret;
    }

    /**
     * Creates a ImportOnDemandNode.
     */
    @Override
    public ImportOnDemandNode makeImportOnDemandNode(
            NameNode name,
            boolean staticImport)
    {
        ImportOnDemandNode ret = new ImportOnDemandNodeImpl(name, staticImport);
        return ret;
    }

    /**
     * Creates a VariableModifiersNode.
     */
    @Override
    public VariableModifiersNode makeVariableModifiersNode(
            boolean finalFlag,
            ListNode<AnnotationNode> annotations)
    {
        VariableModifiersNode ret = new VariableModifiersNodeImpl(finalFlag, annotations);
        return ret;
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
        InterfaceModifiersNode ret = new InterfaceModifiersNodeImpl(access, staticFlag, strictfpFlag, annotations);
        return ret;
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
        SuperclassConstructorInvocationNode ret = new SuperclassConstructorInvocationNodeImpl(qualifyingExpression, arguments, typeArguments);
        return ret;
    }

    /**
     * Creates a PrimitiveTypeNode.
     */
    @Override
    public PrimitiveTypeNode makePrimitiveTypeNode(
            PrimitiveType primitiveType)
    {
        PrimitiveTypeNode ret = new PrimitiveTypeNodeImpl(primitiveType);
        return ret;
    }

    /**
     * Creates a InitializerDeclarationNode.
     */
    @Override
    public InitializerDeclarationNode makeInitializerDeclarationNode(
            boolean staticInitializer,
            BlockStatementNode body)
    {
        InitializerDeclarationNode ret = new InitializerDeclarationNodeImpl(staticInitializer, body);
        return ret;
    }

    /**
     * Creates a EnumBodyNode.
     */
    @Override
    public EnumBodyNode makeEnumBodyNode(
            ListNode<EnumConstantDeclarationNode> constants,
            ListNode<ClassMemberNode> members)
    {
        EnumBodyNode ret = new EnumBodyNodeImpl(constants, members);
        return ret;
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
        TryNode ret = new TryNodeImpl(block, catches, finallyBlock);
        return ret;
    }

    /**
     * Creates a ThisNode.
     */
    @Override
    public ThisNode makeThisNode(
            UnparameterizedTypeNode type)
    {
        ThisNode ret = new ThisNodeImpl(type);
        return ret;
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
        EnumDeclarationNode ret = new EnumDeclarationNodeImpl(modifiers, implementsClause, body, identifier, javadoc);
        return ret;
    }

    /**
     * Creates a VoidTypeNode.
     */
    @Override
    public VoidTypeNode makeVoidTypeNode()
    {
        VoidTypeNode ret = new VoidTypeNodeImpl();
        return ret;
    }

    /**
     * Creates a VariableDeclarationNode.
     */
    @Override
    public VariableDeclarationNode makeVariableDeclarationNode(
            VariableModifiersNode modifiers,
            ListNode<VariableDeclaratorNode> declarators)
    {
        VariableDeclarationNode ret = new VariableDeclarationNodeImpl(modifiers, declarators);
        return ret;
    }

    /**
     * Creates a AnnotationBodyNode.
     */
    @Override
    public AnnotationBodyNode makeAnnotationBodyNode(
            ListNode<AnnotationMemberNode> members)
    {
        AnnotationBodyNode ret = new AnnotationBodyNodeImpl(members);
        return ret;
    }

    /**
     * Creates a UnparameterizedTypeNode.
     */
    @Override
    public UnparameterizedTypeNode makeUnparameterizedTypeNode(
            NameNode name)
    {
        UnparameterizedTypeNode ret = new UnparameterizedTypeNodeImpl(name);
        return ret;
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
        VariableDeclaratorNode ret = new VariableDeclaratorNodeImpl(type, name, initializer);
        return ret;
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
        AnnotationModifiersNode ret = new AnnotationModifiersNodeImpl(access, staticFlag, strictfpFlag, annotations);
        return ret;
    }

    /**
     * Creates a FieldAccessByExpressionNode.
     */
    @Override
    public FieldAccessByExpressionNode makeFieldAccessByExpressionNode(
            PrimaryExpressionNode expression,
            IdentifierNode identifier)
    {
        FieldAccessByExpressionNode ret = new FieldAccessByExpressionNodeImpl(expression, identifier);
        return ret;
    }

    /**
     * Creates a SuperFieldAccessNode.
     */
    @Override
    public SuperFieldAccessNode makeSuperFieldAccessNode(
            UnparameterizedTypeNode type,
            IdentifierNode identifier)
    {
        SuperFieldAccessNode ret = new SuperFieldAccessNodeImpl(type, identifier);
        return ret;
    }

    /**
     * Creates a ThrowNode.
     */
    @Override
    public ThrowNode makeThrowNode(
            ExpressionNode expression)
    {
        ThrowNode ret = new ThrowNodeImpl(expression);
        return ret;
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
        EnumModifiersNode ret = new EnumModifiersNodeImpl(access, strictfpFlag, annotations);
        return ret;
    }

    /**
     * Creates a CatchNode.
     */
    @Override
    public CatchNode makeCatchNode(
            BlockStatementNode block,
            VariableNode parameter)
    {
        CatchNode ret = new CatchNodeImpl(block, parameter);
        return ret;
    }

    /**
     * Creates a VoidTypeDeclarationNode.
     */
    @Override
    public VoidTypeDeclarationNode makeVoidTypeDeclarationNode()
    {
        VoidTypeDeclarationNode ret = new VoidTypeDeclarationNodeImpl();
        return ret;
    }

    /**
     * Creates a NormalAnnotationNode.
     */
    @Override
    public NormalAnnotationNode makeNormalAnnotationNode(
            ListNode<AnnotationElementNode> arguments,
            UnparameterizedTypeNode annotationType)
    {
        NormalAnnotationNode ret = new NormalAnnotationNodeImpl(arguments, annotationType);
        return ret;
    }

    /**
     * Creates a DoWhileLoopNode.
     */
    @Override
    public DoWhileLoopNode makeDoWhileLoopNode(
            ExpressionNode condition,
            StatementNode statement)
    {
        DoWhileLoopNode ret = new DoWhileLoopNodeImpl(condition, statement);
        return ret;
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
        QualifiedClassInstantiationNode ret = new QualifiedClassInstantiationNodeImpl(enclosingExpression, identifier, typeArguments, constructorTypeArguments, arguments, body);
        return ret;
    }

    /**
     * Creates a TypeCastNode.
     */
    @Override
    public TypeCastNode makeTypeCastNode(
            ExpressionNode expression,
            TypeNode type)
    {
        TypeCastNode ret = new TypeCastNodeImpl(expression, type);
        return ret;
    }

    /**
     * Creates a LabeledStatementNode.
     */
    @Override
    public LabeledStatementNode makeLabeledStatementNode(
            IdentifierNode label,
            StatementNode statement)
    {
        LabeledStatementNode ret = new LabeledStatementNodeImpl(label, statement);
        return ret;
    }

    /**
     * Creates a BlockStatementNode.
     */
    @Override
    public BlockStatementNode makeBlockStatementNode(
            ListNode<StatementNode> statements)
    {
        BlockStatementNode ret = new BlockStatementNodeImpl(statements);
        return ret;
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
        BinaryExpressionNode ret = new BinaryExpressionNodeImpl(leftOperand, rightOperand, operator);
        return ret;
    }

    /**
     * Creates a ForInitializerExpressionNode.
     */
    @Override
    public ForInitializerExpressionNode makeForInitializerExpressionNode(
            ListNode<StatementExpressionNode> expressions)
    {
        ForInitializerExpressionNode ret = new ForInitializerExpressionNodeImpl(expressions);
        return ret;
    }

    /**
     * Creates a PackageDeclarationNode.
     */
    @Override
    public PackageDeclarationNode makePackageDeclarationNode(
            NameNode name,
            ListNode<AnnotationNode> annotations)
    {
        PackageDeclarationNode ret = new PackageDeclarationNodeImpl(name, annotations);
        return ret;
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
        AnnotationDeclarationNode ret = new AnnotationDeclarationNodeImpl(modifiers, body, identifier, javadoc);
        return ret;
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
        CompilationUnitNode ret = new CompilationUnitNodeImpl(packageDeclaration, imports, typeDecls);
        return ret;
    }

    /**
     * Creates a ContinueNode.
     */
    @Override
    public ContinueNode makeContinueNode(
            IdentifierNode label)
    {
        ContinueNode ret = new ContinueNodeImpl(label);
        return ret;
    }

    /**
     * Creates a StringLiteralNode.
     */
    @Override
    public StringLiteralNode makeStringLiteralNode(
            String value)
    {
        StringLiteralNode ret = new StringLiteralNodeImpl(value);
        return ret;
    }

    /**
     * Creates a AnnotationElementNode.
     */
    @Override
    public AnnotationElementNode makeAnnotationElementNode(
            IdentifierNode identifier,
            AnnotationValueNode value)
    {
        AnnotationElementNode ret = new AnnotationElementNodeImpl(identifier, value);
        return ret;
    }

    /**
     * Creates a DoubleLiteralNode.
     */
    @Override
    public DoubleLiteralNode makeDoubleLiteralNode(
            Double value)
    {
        DoubleLiteralNode ret = new DoubleLiteralNodeImpl(value);
        return ret;
    }

    /**
     * Creates a AnonymousClassBodyNode.
     */
    @Override
    public AnonymousClassBodyNode makeAnonymousClassBodyNode(
            ListNode<AnonymousClassMemberNode> members)
    {
        AnonymousClassBodyNode ret = new AnonymousClassBodyNodeImpl(members);
        return ret;
    }

    /**
     * Creates a SynchronizedNode.
     */
    @Override
    public SynchronizedNode makeSynchronizedNode(
            ExpressionNode expression,
            BlockStatementNode block)
    {
        SynchronizedNode ret = new SynchronizedNodeImpl(expression, block);
        return ret;
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
        VariableNode ret = new VariableNodeImpl(modifiers, type, identifier);
        return ret;
    }

    /**
     * Creates a CharLiteralNode.
     */
    @Override
    public CharLiteralNode makeCharLiteralNode(
            Character value)
    {
        CharLiteralNode ret = new CharLiteralNodeImpl(value);
        return ret;
    }

    /**
     * Creates a WildcardTypeNode.
     */
    @Override
    public WildcardTypeNode makeWildcardTypeNode(
            ReferenceTypeNode bound,
            boolean upperBound)
    {
        WildcardTypeNode ret = new WildcardTypeNodeImpl(bound, upperBound);
        return ret;
    }

    /**
     * Creates a InlineTypeDeclarationNode.
     */
    @Override
    public InlineTypeDeclarationNode makeInlineTypeDeclarationNode(
            InlineTypeDeclarableNode declaration)
    {
        InlineTypeDeclarationNode ret = new InlineTypeDeclarationNodeImpl(declaration);
        return ret;
    }

    /**
     * Creates a UnaryExpressionNode.
     */
    @Override
    public UnaryExpressionNode makeUnaryExpressionNode(
            ExpressionNode expression,
            UnaryOperator operator)
    {
        UnaryExpressionNode ret = new UnaryExpressionNodeImpl(expression, operator);
        return ret;
    }

    /**
     * Creates a BooleanLiteralNode.
     */
    @Override
    public BooleanLiteralNode makeBooleanLiteralNode(
            Boolean value)
    {
        BooleanLiteralNode ret = new BooleanLiteralNodeImpl(value);
        return ret;
    }

    /**
     * Creates a SwitchNode.
     */
    @Override
    public SwitchNode makeSwitchNode(
            ExpressionNode expression,
            ListNode<CaseNode> cases)
    {
        SwitchNode ret = new SwitchNodeImpl(expression, cases);
        return ret;
    }

    /**
     * Creates a AlternateConstructorInvocationNode.
     */
    @Override
    public AlternateConstructorInvocationNode makeAlternateConstructorInvocationNode(
            ListNode<ExpressionNode> arguments,
            ListNode<TypeNode> typeArguments)
    {
        AlternateConstructorInvocationNode ret = new AlternateConstructorInvocationNodeImpl(arguments, typeArguments);
        return ret;
    }

    /**
     * Creates a AnnotationMethodModifiersNode.
     */
    @Override
    public AnnotationMethodModifiersNode makeAnnotationMethodModifiersNode(
            ListNode<AnnotationNode> annotations)
    {
        AnnotationMethodModifiersNode ret = new AnnotationMethodModifiersNodeImpl(annotations);
        return ret;
    }

    /**
     * Creates a ConstructorDeclarationNode.
     */
    @Override
    public ConstructorDeclarationNode makeConstructorDeclarationNode(
            ConstructorBodyNode body,
            ConstructorModifiersNode modifiers,
            ListNode<VariableNode> parameters,
            VariableNode varargParameter,
            ListNode<UnparameterizedTypeNode> throwTypes,
            ListNode<TypeParameterNode> typeParameters,
            JavadocNode javadoc)
    {
        ConstructorDeclarationNode ret = new ConstructorDeclarationNodeImpl(body, modifiers, parameters, varargParameter, throwTypes, typeParameters, javadoc);
        return ret;
    }

    /**
     * Creates a AnnotationAnnotationValueNode.
     */
    @Override
    public AnnotationAnnotationValueNode makeAnnotationAnnotationValueNode(
            AnnotationNode annotation)
    {
        AnnotationAnnotationValueNode ret = new AnnotationAnnotationValueNodeImpl(annotation);
        return ret;
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
        ForLoopNode ret = new ForLoopNodeImpl(initializer, condition, update, statement);
        return ret;
    }

    /**
     * Creates a WhileLoopNode.
     */
    @Override
    public WhileLoopNode makeWhileLoopNode(
            ExpressionNode condition,
            StatementNode statement)
    {
        WhileLoopNode ret = new WhileLoopNodeImpl(condition, statement);
        return ret;
    }

    /**
     * Creates a ListNode.
     */
    @Override
    public <T extends Node> ListNode<T> makeListNode(
            List<T> children)
    {
        ListNode<T> ret = new ListNodeImpl<T>(children);
        return ret;
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
        EnumConstantDeclarationNode ret = new EnumConstantDeclarationNodeImpl(annotations, identifier, arguments, body, javadoc);
        return ret;
    }

    /**
     * Creates a BreakNode.
     */
    @Override
    public BreakNode makeBreakNode(
            IdentifierNode label)
    {
        BreakNode ret = new BreakNodeImpl(label);
        return ret;
    }

    /**
     * Creates a ConstructorModifiersNode.
     */
    @Override
    public ConstructorModifiersNode makeConstructorModifiersNode(
            AccessModifier access,
            ListNode<AnnotationNode> annotations)
    {
        ConstructorModifiersNode ret = new ConstructorModifiersNodeImpl(access, annotations);
        return ret;
    }

    /**
     * Creates a ParameterizedTypeSelectNode.
     */
    @Override
    public ParameterizedTypeSelectNode makeParameterizedTypeSelectNode(
            ParameterizedTypeNode base,
            DeclaredTypeNode select)
    {
        ParameterizedTypeSelectNode ret = new ParameterizedTypeSelectNodeImpl(base, select);
        return ret;
    }

    /**
     * Creates a IdentifierNode.
     */
    @Override
    public IdentifierNode makeIdentifierNode(
            String identifier)
    {
        IdentifierNode ret = new IdentifierNodeImpl(identifier);
        return ret;
    }

    /**
     * Creates a ArrayTypeNode.
     */
    @Override
    public ArrayTypeNode makeArrayTypeNode(
            TypeNode type)
    {
        ArrayTypeNode ret = new ArrayTypeNodeImpl(type);
        return ret;
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
        ArrayInitializerCreationNode ret = new ArrayInitializerCreationNodeImpl(initializer, baseType, arrayLevels);
        return ret;
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
        FieldModifiersNode ret = new FieldModifiersNodeImpl(access, staticFlag, finalFlag, transientFlag, volatileFlag, annotations);
        return ret;
    }

    /**
     * Creates a TypeParameterNode.
     */
    @Override
    public TypeParameterNode makeTypeParameterNode(
            IdentifierNode identifier,
            ListNode<DeclaredTypeNode> bounds)
    {
        TypeParameterNode ret = new TypeParameterNodeImpl(identifier, bounds);
        return ret;
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
        AnnotationMethodDeclarationNode ret = new AnnotationMethodDeclarationNodeImpl(modifiers, type, identifier, defaultValue, javadoc);
        return ret;
    }

    /**
     * Creates a ImportSingleTypeNode.
     */
    @Override
    public ImportSingleTypeNode makeImportSingleTypeNode(
            NameNode name,
            boolean staticImport)
    {
        ImportSingleTypeNode ret = new ImportSingleTypeNodeImpl(name, staticImport);
        return ret;
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
        FieldDeclarationNode ret = new FieldDeclarationNodeImpl(modifiers, declarators, javadoc);
        return ret;
    }

    /**
     * Creates a AnnotationArrayValueNode.
     */
    @Override
    public AnnotationArrayValueNode makeAnnotationArrayValueNode(
            ListNode<AnnotationValueNode> values)
    {
        AnnotationArrayValueNode ret = new AnnotationArrayValueNodeImpl(values);
        return ret;
    }

    /**
     * Creates a SingleElementAnnotationNode.
     */
    @Override
    public SingleElementAnnotationNode makeSingleElementAnnotationNode(
            AnnotationValueNode value,
            UnparameterizedTypeNode annotationType)
    {
        SingleElementAnnotationNode ret = new SingleElementAnnotationNodeImpl(value, annotationType);
        return ret;
    }

    /**
     * Creates a ClassLiteralNode.
     */
    @Override
    public ClassLiteralNode makeClassLiteralNode(
            LiteralizableTypeNode value)
    {
        ClassLiteralNode ret = new ClassLiteralNodeImpl(value);
        return ret;
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
        SuperMethodInvocationNode ret = new SuperMethodInvocationNodeImpl(type, identifier, arguments, typeArguments);
        return ret;
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
        ClassModifiersNode ret = new ClassModifiersNodeImpl(access, abstractFlag, staticFlag, finalFlag, strictfpFlag, annotations);
        return ret;
    }

    /**
     * Creates a ArrayInitializerNode.
     */
    @Override
    public ArrayInitializerNode makeArrayInitializerNode(
            ListNode<VariableInitializerNode> initializers)
    {
        ArrayInitializerNode ret = new ArrayInitializerNodeImpl(initializers);
        return ret;
    }

    /**
     * Creates a AnnotationExpressionValueNode.
     */
    @Override
    public AnnotationExpressionValueNode makeAnnotationExpressionValueNode(
            NonAssignmentExpressionNode expression)
    {
        AnnotationExpressionValueNode ret = new AnnotationExpressionValueNodeImpl(expression);
        return ret;
    }

    /**
     * Creates a ReturnNode.
     */
    @Override
    public ReturnNode makeReturnNode(
            ExpressionNode expression)
    {
        ReturnNode ret = new ReturnNodeImpl(expression);
        return ret;
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
        AssignmentNode ret = new AssignmentNodeImpl(variable, operator, expression);
        return ret;
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
        MethodInvocationByExpressionNode ret = new MethodInvocationByExpressionNodeImpl(expression, identifier, arguments, typeArguments);
        return ret;
    }

    /**
     * Creates a InstanceOfNode.
     */
    @Override
    public InstanceOfNode makeInstanceOfNode(
            ExpressionNode expression,
            TypeNode type)
    {
        InstanceOfNode ret = new InstanceOfNodeImpl(expression, type);
        return ret;
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
        ConditionalExpressionNode ret = new ConditionalExpressionNodeImpl(condition, trueExpression, falseExpression);
        return ret;
    }

    /**
     * Creates a ParenthesizedExpressionNode.
     */
    @Override
    public ParenthesizedExpressionNode makeParenthesizedExpressionNode(
            ExpressionNode expression)
    {
        ParenthesizedExpressionNode ret = new ParenthesizedExpressionNodeImpl(expression);
        return ret;
    }

    /**
     * Creates a FloatLiteralNode.
     */
    @Override
    public FloatLiteralNode makeFloatLiteralNode(
            Float value)
    {
        FloatLiteralNode ret = new FloatLiteralNodeImpl(value);
        return ret;
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
        MethodInvocationByNameNode ret = new MethodInvocationByNameNodeImpl(name, arguments, typeArguments);
        return ret;
    }

    /**
     * Creates a ParameterizedTypeNode.
     */
    @Override
    public ParameterizedTypeNode makeParameterizedTypeNode(
            UnparameterizedTypeNode baseType,
            ListNode<TypeArgumentNode> typeArguments)
    {
        ParameterizedTypeNode ret = new ParameterizedTypeNodeImpl(baseType, typeArguments);
        return ret;
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
        InterfaceDeclarationNode ret = new InterfaceDeclarationNodeImpl(modifiers, extendsClause, body, typeParameters, identifier, javadoc);
        return ret;
    }

    /**
     * Creates a ForInitializerDeclarationNode.
     */
    @Override
    public ForInitializerDeclarationNode makeForInitializerDeclarationNode(
            VariableDeclarationNode declaration)
    {
        ForInitializerDeclarationNode ret = new ForInitializerDeclarationNodeImpl(declaration);
        return ret;
    }

    /**
     * Creates a ConstructorBodyNode.
     */
    @Override
    public ConstructorBodyNode makeConstructorBodyNode(
            ConstructorInvocationNode constructorInvocation,
            ListNode<StatementNode> statements)
    {
        ConstructorBodyNode ret = new ConstructorBodyNodeImpl(constructorInvocation, statements);
        return ret;
    }

    /**
     * Creates a FieldAccessByNameNode.
     */
    @Override
    public FieldAccessByNameNode makeFieldAccessByNameNode(
            NameNode name)
    {
        FieldAccessByNameNode ret = new FieldAccessByNameNodeImpl(name);
        return ret;
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
        UnqualifiedClassInstantiationNode ret = new UnqualifiedClassInstantiationNodeImpl(type, constructorTypeArguments, arguments, body);
        return ret;
    }

    /**
     * Creates a SimpleNameNode.
     */
    @Override
    public SimpleNameNode makeSimpleNameNode(
            IdentifierNode identifier,
            NameCategory category)
    {
        SimpleNameNode ret = new SimpleNameNodeImpl(identifier, category);
        return ret;
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
        ArrayInstantiatorCreationNode ret = new ArrayInstantiatorCreationNodeImpl(dimExpressions, baseType, arrayLevels);
        return ret;
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
        MethodModifiersNode ret = new MethodModifiersNodeImpl(access, abstractFlag, staticFlag, finalFlag, synchronizedFlag, nativeFlag, strictfpFlag, annotations);
        return ret;
    }

    /**
     * Creates a ClassBodyNode.
     */
    @Override
    public ClassBodyNode makeClassBodyNode(
            ListNode<ClassMemberNode> members)
    {
        ClassBodyNode ret = new ClassBodyNodeImpl(members);
        return ret;
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
        IfNode ret = new IfNodeImpl(condition, thenStatement, elseStatement);
        return ret;
    }

    /**
     * Creates a IntLiteralNode.
     */
    @Override
    public IntLiteralNode makeIntLiteralNode(
            Integer value)
    {
        IntLiteralNode ret = new IntLiteralNodeImpl(value);
        return ret;
    }

    /**
     * Creates a NullLiteralNode.
     */
    @Override
    public NullLiteralNode makeNullLiteralNode(
            Void value)
    {
        NullLiteralNode ret = new NullLiteralNodeImpl(value);
        return ret;
    }

    /**
     * Creates a JavadocNode.
     */
    @Override
    public JavadocNode makeJavadocNode(
            String text)
    {
        JavadocNode ret = new JavadocNodeImpl(text);
        return ret;
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
        MethodDeclarationNode ret = new MethodDeclarationNodeImpl(body, modifiers, identifier, parameters, varargParameter, returnType, throwTypes, typeParameters, javadoc);
        return ret;
    }

}
