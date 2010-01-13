package edu.jhu.cs.bsj.compiler.impl.ast;

import java.util.List;
import java.util.Set;

import edu.jhu.cs.bsj.compiler.ast.AssignmentOperator;
import edu.jhu.cs.bsj.compiler.ast.BinaryOperator;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.Modifier;
import edu.jhu.cs.bsj.compiler.ast.NameCategory;
import edu.jhu.cs.bsj.compiler.ast.PrimitiveType;
import edu.jhu.cs.bsj.compiler.ast.UnaryOperator;
import edu.jhu.cs.bsj.compiler.ast.node.*;
import edu.jhu.cs.bsj.compiler.ast.node.meta.CodeLiteralNode;
import edu.jhu.cs.bsj.compiler.impl.ast.node.AlternateConstructorInvocationNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.AnnotationAnnotationValueNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.AnnotationArrayValueNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.AnnotationBodyNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.AnnotationDeclarationNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.AnnotationElementNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.AnnotationExpressionValueNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.AnnotationMethodDeclarationNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.AnonymousClassBodyNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.ArrayAccessNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.ArrayInitializerCreationNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.ArrayInitializerNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.ArrayInstantiatorCreationNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.ArrayTypeNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.AssertStatementNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.AssignmentNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.BinaryOperatorNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.BlockStatementNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.BooleanLiteralNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.BreakNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.CaseNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.CatchNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.CharLiteralNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.ClassBodyNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.ClassDeclarationNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.ClassLiteralNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.CompilationUnitNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.ConditionalExpressionNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.ConstructorBodyNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.ConstructorDeclarationNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.ContinueNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.DoWhileLoopNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.DoubleLiteralNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.EnhancedForLoopNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.EnumBodyNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.EnumConstantDeclarationNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.EnumDeclarationNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.ExpressionStatementNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.FieldAccessNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.FieldDeclarationNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.FloatLiteralNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.ForInitializerDeclarationNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.ForInitializerExpressionNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.ForLoopNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.IdentifierNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.IfNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.ImportOnDemandNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.ImportSingleTypeNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.InitializerDeclarationNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.InlineTypeDeclarationNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.InstanceOfNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.IntLiteralNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.InterfaceBodyNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.InterfaceDeclarationNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.LabeledStatementNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.ListNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.LongLiteralNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.MethodDeclarationNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.MethodInvocationByExpressionNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.MethodInvocationByNameNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.ModifiersNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.NameExpressionNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.NormalAnnotationNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.NullLiteralNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.PackageDeclarationNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.ParameterizedTypeNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.ParameterizedTypeSelectNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.ParenthesizedExpressionNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.PrimitiveTypeNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.QualifiedClassInstantiationNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.QualifiedNameNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.RawTypeNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.ReturnNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.SimpleNameNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.SingleElementAnnotationNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.StringLiteralNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.SuperFieldAccessNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.SuperMethodInvocationNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.SuperclassConstructorInvocationNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.SwitchNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.SynchronizedNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.ThisNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.ThrowNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.TryNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.TypeCastNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.TypeParameterNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.UnaryOperatorNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.UnqualifiedClassInstantiationNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.VariableDeclarationNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.VariableDeclaratorNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.VariableNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.VoidStatementNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.VoidTypeDeclarationNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.VoidTypeNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.WhileLoopNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.WildcardTypeNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.meta.CodeLiteralNodeImpl;

/**
 * This class acts as a BSJ node factory for the standard BSJ compiler.
 *
* @author Zachary Palmer
 */
public class BsjNodeFactoryImpl implements BsjNodeFactory
{
    /**
     * Creates a AssertStatementNode.
     */
    public AssertStatementNode makeAssertStatementNode(
            ExpressionNode testExpression,
            ExpressionNode messageExpression)
    {
        AssertStatementNode ret = new AssertStatementNodeImpl(testExpression, messageExpression);
        return ret;
    }

    /**
     * Creates a ExpressionStatementNode.
     */
    public ExpressionStatementNode makeExpressionStatementNode(
            ExpressionNode expression)
    {
        ExpressionStatementNode ret = new ExpressionStatementNodeImpl(expression);
        return ret;
    }

    /**
     * Creates a InterfaceBodyNode.
     */
    public InterfaceBodyNode makeInterfaceBodyNode(
            ListNode<InterfaceMemberNode> members)
    {
        InterfaceBodyNode ret = new InterfaceBodyNodeImpl(members);
        return ret;
    }

    /**
     * Creates a EnhancedForLoopNode.
     */
    public EnhancedForLoopNode makeEnhancedForLoopNode(
            VariableNode variable,
            ExpressionNode expression,
            StatementNode statement)
    {
        EnhancedForLoopNode ret = new EnhancedForLoopNodeImpl(variable, expression, statement);
        return ret;
    }

    /**
     * Creates a ClassDeclarationNode.
     */
    public ClassDeclarationNode makeClassDeclarationNode(
            TypeNode extendsClause,
            ListNode<TypeNode> implementsClause,
            ClassBodyNode body,
            ListNode<TypeParameterNode> typeParameters,
            IdentifierNode identifier,
            ModifiersNode modifiers)
    {
        ClassDeclarationNode ret = new ClassDeclarationNodeImpl(extendsClause, implementsClause, body, typeParameters, identifier, modifiers);
        return ret;
    }

    /**
     * Creates a ArrayAccessNode.
     */
    public ArrayAccessNode makeArrayAccessNode(
            ArrayIndexableNode arrayExpression,
            ExpressionNode indexExpression)
    {
        ArrayAccessNode ret = new ArrayAccessNodeImpl(arrayExpression, indexExpression);
        return ret;
    }

    /**
     * Creates a LongLiteralNode.
     */
    public LongLiteralNode makeLongLiteralNode(
            Long value)
    {
        LongLiteralNode ret = new LongLiteralNodeImpl(value);
        return ret;
    }

    /**
     * Creates a QualifiedNameNode.
     */
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
    public VoidStatementNode makeVoidStatementNode()
    {
        VoidStatementNode ret = new VoidStatementNodeImpl();
        return ret;
    }

    /**
     * Creates a CodeLiteralNode.
     */
    public CodeLiteralNode makeCodeLiteralNode(
            Node value)
    {
        CodeLiteralNode ret = new CodeLiteralNodeImpl(value);
        return ret;
    }

    /**
     * Creates a ImportOnDemandNode.
     */
    public ImportOnDemandNode makeImportOnDemandNode(
            NameNode name,
            boolean staticImport)
    {
        ImportOnDemandNode ret = new ImportOnDemandNodeImpl(name, staticImport);
        return ret;
    }

    /**
     * Creates a SuperclassConstructorInvocationNode.
     */
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
    public PrimitiveTypeNode makePrimitiveTypeNode(
            PrimitiveType primitiveType)
    {
        PrimitiveTypeNode ret = new PrimitiveTypeNodeImpl(primitiveType);
        return ret;
    }

    /**
     * Creates a InitializerDeclarationNode.
     */
    public InitializerDeclarationNode makeInitializerDeclarationNode(
            boolean staticInitializer,
            BlockStatementNode body)
    {
        InitializerDeclarationNode ret = new InitializerDeclarationNodeImpl(staticInitializer, body);
        return ret;
    }

    /**
     * Creates a ModifiersNode.
     */
    public ModifiersNode makeModifiersNode(
            ListNode<AnnotationNode> annotations,
            Set<Modifier> flags)
    {
        ModifiersNode ret = new ModifiersNodeImpl(annotations, flags);
        return ret;
    }

    /**
     * Creates a EnumBodyNode.
     */
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
    public ThisNode makeThisNode(
            RawTypeNode type)
    {
        ThisNode ret = new ThisNodeImpl(type);
        return ret;
    }

    /**
     * Creates a EnumDeclarationNode.
     */
    public EnumDeclarationNode makeEnumDeclarationNode(
            ListNode<TypeNode> implementsClause,
            EnumBodyNode body,
            IdentifierNode identifier,
            ModifiersNode modifiers)
    {
        EnumDeclarationNode ret = new EnumDeclarationNodeImpl(implementsClause, body, identifier, modifiers);
        return ret;
    }

    /**
     * Creates a VoidTypeNode.
     */
    public VoidTypeNode makeVoidTypeNode()
    {
        VoidTypeNode ret = new VoidTypeNodeImpl();
        return ret;
    }

    /**
     * Creates a VariableDeclarationNode.
     */
    public VariableDeclarationNode makeVariableDeclarationNode(
            ModifiersNode modifiers,
            ListNode<VariableDeclaratorNode> declarators)
    {
        VariableDeclarationNode ret = new VariableDeclarationNodeImpl(modifiers, declarators);
        return ret;
    }

    /**
     * Creates a AnnotationBodyNode.
     */
    public AnnotationBodyNode makeAnnotationBodyNode(
            ListNode<AnnotationMemberNode> members)
    {
        AnnotationBodyNode ret = new AnnotationBodyNodeImpl(members);
        return ret;
    }

    /**
     * Creates a VariableDeclaratorNode.
     */
    public VariableDeclaratorNode makeVariableDeclaratorNode(
            TypeNode type,
            IdentifierNode name,
            VariableInitializerNode initializer)
    {
        VariableDeclaratorNode ret = new VariableDeclaratorNodeImpl(type, name, initializer);
        return ret;
    }

    /**
     * Creates a FieldAccessNode.
     */
    public FieldAccessNode makeFieldAccessNode(
            PrimaryExpressionNode expression,
            IdentifierNode identifier)
    {
        FieldAccessNode ret = new FieldAccessNodeImpl(expression, identifier);
        return ret;
    }

    /**
     * Creates a SuperFieldAccessNode.
     */
    public SuperFieldAccessNode makeSuperFieldAccessNode(
            RawTypeNode type,
            IdentifierNode identifier)
    {
        SuperFieldAccessNode ret = new SuperFieldAccessNodeImpl(type, identifier);
        return ret;
    }

    /**
     * Creates a ThrowNode.
     */
    public ThrowNode makeThrowNode(
            ExpressionNode expression)
    {
        ThrowNode ret = new ThrowNodeImpl(expression);
        return ret;
    }

    /**
     * Creates a NameExpressionNode.
     */
    public NameExpressionNode makeNameExpressionNode(
            NameNode name)
    {
        NameExpressionNode ret = new NameExpressionNodeImpl(name);
        return ret;
    }

    /**
     * Creates a CatchNode.
     */
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
    public VoidTypeDeclarationNode makeVoidTypeDeclarationNode()
    {
        VoidTypeDeclarationNode ret = new VoidTypeDeclarationNodeImpl();
        return ret;
    }

    /**
     * Creates a NormalAnnotationNode.
     */
    public NormalAnnotationNode makeNormalAnnotationNode(
            ListNode<AnnotationElementNode> arguments,
            RawTypeNode annotationType)
    {
        NormalAnnotationNode ret = new NormalAnnotationNodeImpl(arguments, annotationType);
        return ret;
    }

    /**
     * Creates a DoWhileLoopNode.
     */
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
    public QualifiedClassInstantiationNode makeQualifiedClassInstantiationNode(
            ExpressionNode enclosingExpression,
            IdentifierNode identifier,
            ListNode<TypeNode> typeArguments,
            ListNode<TypeNode> constructorTypeArguments,
            ListNode<ExpressionNode> arguments,
            AnonymousClassBodyNode body)
    {
        QualifiedClassInstantiationNode ret = new QualifiedClassInstantiationNodeImpl(enclosingExpression, identifier, typeArguments, constructorTypeArguments, arguments, body);
        return ret;
    }

    /**
     * Creates a TypeCastNode.
     */
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
    public BlockStatementNode makeBlockStatementNode(
            ListNode<StatementNode> statements)
    {
        BlockStatementNode ret = new BlockStatementNodeImpl(statements);
        return ret;
    }

    /**
     * Creates a ForInitializerExpressionNode.
     */
    public ForInitializerExpressionNode makeForInitializerExpressionNode(
            ListNode<ExpressionNode> expressions)
    {
        ForInitializerExpressionNode ret = new ForInitializerExpressionNodeImpl(expressions);
        return ret;
    }

    /**
     * Creates a PackageDeclarationNode.
     */
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
    public AnnotationDeclarationNode makeAnnotationDeclarationNode(
            AnnotationBodyNode body,
            IdentifierNode identifier,
            ModifiersNode modifiers)
    {
        AnnotationDeclarationNode ret = new AnnotationDeclarationNodeImpl(body, identifier, modifiers);
        return ret;
    }

    /**
     * Creates a CompilationUnitNode.
     */
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
    public ContinueNode makeContinueNode(
            IdentifierNode label)
    {
        ContinueNode ret = new ContinueNodeImpl(label);
        return ret;
    }

    /**
     * Creates a StringLiteralNode.
     */
    public StringLiteralNode makeStringLiteralNode(
            String value)
    {
        StringLiteralNode ret = new StringLiteralNodeImpl(value);
        return ret;
    }

    /**
     * Creates a AnnotationElementNode.
     */
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
    public DoubleLiteralNode makeDoubleLiteralNode(
            Double value)
    {
        DoubleLiteralNode ret = new DoubleLiteralNodeImpl(value);
        return ret;
    }

    /**
     * Creates a AnonymousClassBodyNode.
     */
    public AnonymousClassBodyNode makeAnonymousClassBodyNode(
            ListNode<AnonymousClassMemberNode> members)
    {
        AnonymousClassBodyNode ret = new AnonymousClassBodyNodeImpl(members);
        return ret;
    }

    /**
     * Creates a UnaryOperatorNode.
     */
    public UnaryOperatorNode makeUnaryOperatorNode(
            ExpressionNode expression,
            UnaryOperator operator)
    {
        UnaryOperatorNode ret = new UnaryOperatorNodeImpl(expression, operator);
        return ret;
    }

    /**
     * Creates a SynchronizedNode.
     */
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
    public VariableNode makeVariableNode(
            ModifiersNode modifiers,
            TypeNode type,
            IdentifierNode identifier)
    {
        VariableNode ret = new VariableNodeImpl(modifiers, type, identifier);
        return ret;
    }

    /**
     * Creates a CharLiteralNode.
     */
    public CharLiteralNode makeCharLiteralNode(
            Character value)
    {
        CharLiteralNode ret = new CharLiteralNodeImpl(value);
        return ret;
    }

    /**
     * Creates a WildcardTypeNode.
     */
    public WildcardTypeNode makeWildcardTypeNode(
            TypeNode bound,
            boolean upperBound)
    {
        WildcardTypeNode ret = new WildcardTypeNodeImpl(bound, upperBound);
        return ret;
    }

    /**
     * Creates a InlineTypeDeclarationNode.
     */
    public InlineTypeDeclarationNode makeInlineTypeDeclarationNode(
            InlineTypeDeclarableNode declaration)
    {
        InlineTypeDeclarationNode ret = new InlineTypeDeclarationNodeImpl(declaration);
        return ret;
    }

    /**
     * Creates a BooleanLiteralNode.
     */
    public BooleanLiteralNode makeBooleanLiteralNode(
            Boolean value)
    {
        BooleanLiteralNode ret = new BooleanLiteralNodeImpl(value);
        return ret;
    }

    /**
     * Creates a SwitchNode.
     */
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
    public AlternateConstructorInvocationNode makeAlternateConstructorInvocationNode(
            ListNode<ExpressionNode> arguments,
            ListNode<TypeNode> typeArguments)
    {
        AlternateConstructorInvocationNode ret = new AlternateConstructorInvocationNodeImpl(arguments, typeArguments);
        return ret;
    }

    /**
     * Creates a ConstructorDeclarationNode.
     */
    public ConstructorDeclarationNode makeConstructorDeclarationNode(
            ConstructorBodyNode body,
            ModifiersNode modifiers,
            ListNode<VariableNode> parameters,
            VariableNode varargParameter,
            ListNode<RawTypeNode> throwTypes,
            ListNode<TypeParameterNode> typeParameters)
    {
        ConstructorDeclarationNode ret = new ConstructorDeclarationNodeImpl(body, modifiers, parameters, varargParameter, throwTypes, typeParameters);
        return ret;
    }

    /**
     * Creates a AnnotationAnnotationValueNode.
     */
    public AnnotationAnnotationValueNode makeAnnotationAnnotationValueNode(
            AnnotationNode annotation)
    {
        AnnotationAnnotationValueNode ret = new AnnotationAnnotationValueNodeImpl(annotation);
        return ret;
    }

    /**
     * Creates a ForLoopNode.
     */
    public ForLoopNode makeForLoopNode(
            ForInitializerNode initializer,
            ListNode<ExpressionStatementNode> update,
            ExpressionNode condition,
            StatementNode statement)
    {
        ForLoopNode ret = new ForLoopNodeImpl(initializer, update, condition, statement);
        return ret;
    }

    /**
     * Creates a WhileLoopNode.
     */
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
    public <T extends Node> ListNode<T> makeListNode(
            List<T> children)
    {
        ListNode<T> ret = new ListNodeImpl<T>(children);
        return ret;
    }

    /**
     * Creates a EnumConstantDeclarationNode.
     */
    public EnumConstantDeclarationNode makeEnumConstantDeclarationNode(
            ListNode<AnnotationNode> annotations,
            IdentifierNode identifier,
            ListNode<ExpressionNode> arguments,
            AnonymousClassBodyNode body)
    {
        EnumConstantDeclarationNode ret = new EnumConstantDeclarationNodeImpl(annotations, identifier, arguments, body);
        return ret;
    }

    /**
     * Creates a BreakNode.
     */
    public BreakNode makeBreakNode(
            IdentifierNode label)
    {
        BreakNode ret = new BreakNodeImpl(label);
        return ret;
    }

    /**
     * Creates a ParameterizedTypeSelectNode.
     */
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
    public IdentifierNode makeIdentifierNode(
            String identifier)
    {
        IdentifierNode ret = new IdentifierNodeImpl(identifier);
        return ret;
    }

    /**
     * Creates a ArrayTypeNode.
     */
    public ArrayTypeNode makeArrayTypeNode(
            TypeNode type)
    {
        ArrayTypeNode ret = new ArrayTypeNodeImpl(type);
        return ret;
    }

    /**
     * Creates a ArrayInitializerCreationNode.
     */
    public ArrayInitializerCreationNode makeArrayInitializerCreationNode(
            ArrayInitializerNode initializer,
            BaseTypeNode baseType,
            int arrayLevels)
    {
        ArrayInitializerCreationNode ret = new ArrayInitializerCreationNodeImpl(initializer, baseType, arrayLevels);
        return ret;
    }

    /**
     * Creates a TypeParameterNode.
     */
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
    public AnnotationMethodDeclarationNode makeAnnotationMethodDeclarationNode(
            ModifiersNode modifiers,
            TypeNode type,
            IdentifierNode identifier,
            ExpressionNode defaultValue)
    {
        AnnotationMethodDeclarationNode ret = new AnnotationMethodDeclarationNodeImpl(modifiers, type, identifier, defaultValue);
        return ret;
    }

    /**
     * Creates a ImportSingleTypeNode.
     */
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
    public FieldDeclarationNode makeFieldDeclarationNode(
            ModifiersNode modifiers,
            ListNode<VariableDeclaratorNode> declarators)
    {
        FieldDeclarationNode ret = new FieldDeclarationNodeImpl(modifiers, declarators);
        return ret;
    }

    /**
     * Creates a AnnotationArrayValueNode.
     */
    public AnnotationArrayValueNode makeAnnotationArrayValueNode(
            ListNode<AnnotationValueNode> values)
    {
        AnnotationArrayValueNode ret = new AnnotationArrayValueNodeImpl(values);
        return ret;
    }

    /**
     * Creates a SingleElementAnnotationNode.
     */
    public SingleElementAnnotationNode makeSingleElementAnnotationNode(
            AnnotationValueNode value,
            RawTypeNode annotationType)
    {
        SingleElementAnnotationNode ret = new SingleElementAnnotationNodeImpl(value, annotationType);
        return ret;
    }

    /**
     * Creates a ClassLiteralNode.
     */
    public ClassLiteralNode makeClassLiteralNode(
            TypeNode value)
    {
        ClassLiteralNode ret = new ClassLiteralNodeImpl(value);
        return ret;
    }

    /**
     * Creates a SuperMethodInvocationNode.
     */
    public SuperMethodInvocationNode makeSuperMethodInvocationNode(
            RawTypeNode type,
            IdentifierNode identifier,
            ListNode<ExpressionNode> arguments,
            ListNode<TypeNode> typeArguments)
    {
        SuperMethodInvocationNode ret = new SuperMethodInvocationNodeImpl(type, identifier, arguments, typeArguments);
        return ret;
    }

    /**
     * Creates a ArrayInitializerNode.
     */
    public ArrayInitializerNode makeArrayInitializerNode(
            ListNode<VariableInitializerNode> initializers)
    {
        ArrayInitializerNode ret = new ArrayInitializerNodeImpl(initializers);
        return ret;
    }

    /**
     * Creates a AnnotationExpressionValueNode.
     */
    public AnnotationExpressionValueNode makeAnnotationExpressionValueNode(
            ExpressionNode expression)
    {
        AnnotationExpressionValueNode ret = new AnnotationExpressionValueNodeImpl(expression);
        return ret;
    }

    /**
     * Creates a ReturnNode.
     */
    public ReturnNode makeReturnNode(
            ExpressionNode expression)
    {
        ReturnNode ret = new ReturnNodeImpl(expression);
        return ret;
    }

    /**
     * Creates a AssignmentNode.
     */
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
    public ParenthesizedExpressionNode makeParenthesizedExpressionNode(
            ExpressionNode expression)
    {
        ParenthesizedExpressionNode ret = new ParenthesizedExpressionNodeImpl(expression);
        return ret;
    }

    /**
     * Creates a FloatLiteralNode.
     */
    public FloatLiteralNode makeFloatLiteralNode(
            Float value)
    {
        FloatLiteralNode ret = new FloatLiteralNodeImpl(value);
        return ret;
    }

    /**
     * Creates a BinaryOperatorNode.
     */
    public BinaryOperatorNode makeBinaryOperatorNode(
            ExpressionNode leftOperand,
            ExpressionNode rightOperand,
            BinaryOperator operator)
    {
        BinaryOperatorNode ret = new BinaryOperatorNodeImpl(leftOperand, rightOperand, operator);
        return ret;
    }

    /**
     * Creates a MethodInvocationByNameNode.
     */
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
    public ParameterizedTypeNode makeParameterizedTypeNode(
            RawTypeNode rawType,
            ListNode<TypeArgumentNode> typeArguments)
    {
        ParameterizedTypeNode ret = new ParameterizedTypeNodeImpl(rawType, typeArguments);
        return ret;
    }

    /**
     * Creates a InterfaceDeclarationNode.
     */
    public InterfaceDeclarationNode makeInterfaceDeclarationNode(
            ListNode<TypeNode> extendsClause,
            InterfaceBodyNode body,
            ListNode<TypeParameterNode> typeParameters,
            IdentifierNode identifier,
            ModifiersNode modifiers)
    {
        InterfaceDeclarationNode ret = new InterfaceDeclarationNodeImpl(extendsClause, body, typeParameters, identifier, modifiers);
        return ret;
    }

    /**
     * Creates a ForInitializerDeclarationNode.
     */
    public ForInitializerDeclarationNode makeForInitializerDeclarationNode(
            VariableDeclarationNode declaration)
    {
        ForInitializerDeclarationNode ret = new ForInitializerDeclarationNodeImpl(declaration);
        return ret;
    }

    /**
     * Creates a RawTypeNode.
     */
    public RawTypeNode makeRawTypeNode(
            NameNode name)
    {
        RawTypeNode ret = new RawTypeNodeImpl(name);
        return ret;
    }

    /**
     * Creates a ConstructorBodyNode.
     */
    public ConstructorBodyNode makeConstructorBodyNode(
            ConstructorInvocationNode constructorInvocation,
            ListNode<StatementNode> statements)
    {
        ConstructorBodyNode ret = new ConstructorBodyNodeImpl(constructorInvocation, statements);
        return ret;
    }

    /**
     * Creates a UnqualifiedClassInstantiationNode.
     */
    public UnqualifiedClassInstantiationNode makeUnqualifiedClassInstantiationNode(
            DeclaredTypeNode type,
            ListNode<TypeNode> constructorTypeArguments,
            ListNode<ExpressionNode> arguments,
            AnonymousClassBodyNode body)
    {
        UnqualifiedClassInstantiationNode ret = new UnqualifiedClassInstantiationNodeImpl(type, constructorTypeArguments, arguments, body);
        return ret;
    }

    /**
     * Creates a SimpleNameNode.
     */
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
    public ArrayInstantiatorCreationNode makeArrayInstantiatorCreationNode(
            ListNode<ExpressionNode> dimExpressions,
            BaseTypeNode baseType,
            int arrayLevels)
    {
        ArrayInstantiatorCreationNode ret = new ArrayInstantiatorCreationNodeImpl(dimExpressions, baseType, arrayLevels);
        return ret;
    }

    /**
     * Creates a IfNode.
     */
    public IfNode makeIfNode(
            ExpressionNode condition,
            StatementNode thenStatement,
            StatementNode elseStatement)
    {
        IfNode ret = new IfNodeImpl(condition, thenStatement, elseStatement);
        return ret;
    }

    /**
     * Creates a ClassBodyNode.
     */
    public ClassBodyNode makeClassBodyNode(
            ListNode<ClassMemberNode> members)
    {
        ClassBodyNode ret = new ClassBodyNodeImpl(members);
        return ret;
    }

    /**
     * Creates a IntLiteralNode.
     */
    public IntLiteralNode makeIntLiteralNode(
            Integer value)
    {
        IntLiteralNode ret = new IntLiteralNodeImpl(value);
        return ret;
    }

    /**
     * Creates a NullLiteralNode.
     */
    public NullLiteralNode makeNullLiteralNode(
            Void value)
    {
        NullLiteralNode ret = new NullLiteralNodeImpl(value);
        return ret;
    }

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
            ListNode<TypeParameterNode> typeParameters)
    {
        MethodDeclarationNode ret = new MethodDeclarationNodeImpl(body, modifiers, identifier, parameters, varargParameter, returnType, throwTypes, typeParameters);
        return ret;
    }

}
