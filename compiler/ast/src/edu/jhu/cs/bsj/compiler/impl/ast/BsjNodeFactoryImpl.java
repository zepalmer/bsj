package edu.jhu.cs.bsj.compiler.impl.ast;

import java.util.List;
import java.util.Set;

import edu.jhu.cs.bsj.compiler.ast.BinaryOperator;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.Modifier;
import edu.jhu.cs.bsj.compiler.ast.PrimitiveType;
import edu.jhu.cs.bsj.compiler.ast.UnaryOperator;
import edu.jhu.cs.bsj.compiler.ast.node.AnnotationBodyNode;
import edu.jhu.cs.bsj.compiler.ast.node.AnnotationDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.AnnotationMethodDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.AnnotationNode;
import edu.jhu.cs.bsj.compiler.ast.node.ArrayAccessNode;
import edu.jhu.cs.bsj.compiler.ast.node.ArrayInitializerNode;
import edu.jhu.cs.bsj.compiler.ast.node.ArrayInstantiatonNode;
import edu.jhu.cs.bsj.compiler.ast.node.ArrayTypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.AssignmentNode;
import edu.jhu.cs.bsj.compiler.ast.node.BinaryOperatorNode;
import edu.jhu.cs.bsj.compiler.ast.node.BlockStatementNode;
import edu.jhu.cs.bsj.compiler.ast.node.BooleanLiteralNode;
import edu.jhu.cs.bsj.compiler.ast.node.BreakNode;
import edu.jhu.cs.bsj.compiler.ast.node.CaseNode;
import edu.jhu.cs.bsj.compiler.ast.node.CatchNode;
import edu.jhu.cs.bsj.compiler.ast.node.CharLiteralNode;
import edu.jhu.cs.bsj.compiler.ast.node.ClassBodyNode;
import edu.jhu.cs.bsj.compiler.ast.node.ClassDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.ClassInstantiationNode;
import edu.jhu.cs.bsj.compiler.ast.node.CompilationUnitNode;
import edu.jhu.cs.bsj.compiler.ast.node.CompoundAssignmentNode;
import edu.jhu.cs.bsj.compiler.ast.node.ConditionalExpressionNode;
import edu.jhu.cs.bsj.compiler.ast.node.ConstructorDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.ContinueNode;
import edu.jhu.cs.bsj.compiler.ast.node.DeclaredTypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.DoWhileLoopNode;
import edu.jhu.cs.bsj.compiler.ast.node.DoubleLiteralNode;
import edu.jhu.cs.bsj.compiler.ast.node.EnhancedForLoopNode;
import edu.jhu.cs.bsj.compiler.ast.node.EnumBodyNode;
import edu.jhu.cs.bsj.compiler.ast.node.EnumConstantDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.EnumDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.ExpressionNode;
import edu.jhu.cs.bsj.compiler.ast.node.ExpressionStatementNode;
import edu.jhu.cs.bsj.compiler.ast.node.FieldDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.FloatLiteralNode;
import edu.jhu.cs.bsj.compiler.ast.node.ForLoopNode;
import edu.jhu.cs.bsj.compiler.ast.node.IdentifierNode;
import edu.jhu.cs.bsj.compiler.ast.node.IfNode;
import edu.jhu.cs.bsj.compiler.ast.node.ImportNode;
import edu.jhu.cs.bsj.compiler.ast.node.InitializerDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.InstanceOfNode;
import edu.jhu.cs.bsj.compiler.ast.node.IntLiteralNode;
import edu.jhu.cs.bsj.compiler.ast.node.InterfaceBodyNode;
import edu.jhu.cs.bsj.compiler.ast.node.InterfaceDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.LabeledStatementNode;
import edu.jhu.cs.bsj.compiler.ast.node.ListNode;
import edu.jhu.cs.bsj.compiler.ast.node.LongLiteralNode;
import edu.jhu.cs.bsj.compiler.ast.node.MemberSelectNode;
import edu.jhu.cs.bsj.compiler.ast.node.MethodDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.MethodInvocationNode;
import edu.jhu.cs.bsj.compiler.ast.node.ModifiersNode;
import edu.jhu.cs.bsj.compiler.ast.node.NameNode;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.ParameterizedTypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.PrimitiveTypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.QualifiedNameNode;
import edu.jhu.cs.bsj.compiler.ast.node.StatementNode;
import edu.jhu.cs.bsj.compiler.ast.node.StringLiteralNode;
import edu.jhu.cs.bsj.compiler.ast.node.SwitchNode;
import edu.jhu.cs.bsj.compiler.ast.node.ThrowNode;
import edu.jhu.cs.bsj.compiler.ast.node.TryNode;
import edu.jhu.cs.bsj.compiler.ast.node.TypeCastNode;
import edu.jhu.cs.bsj.compiler.ast.node.TypeDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.TypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.TypeParameterNode;
import edu.jhu.cs.bsj.compiler.ast.node.UnaryOperatorNode;
import edu.jhu.cs.bsj.compiler.ast.node.VariableDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.VariableNode;
import edu.jhu.cs.bsj.compiler.ast.node.WhileLoopNode;
import edu.jhu.cs.bsj.compiler.ast.node.WildcardTypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.CodeLiteralNode;
import edu.jhu.cs.bsj.compiler.ast.tags.AnnotationMember;
import edu.jhu.cs.bsj.compiler.ast.tags.ClassMember;
import edu.jhu.cs.bsj.compiler.ast.tags.InterfaceMember;
import edu.jhu.cs.bsj.compiler.ast.tags.TypeArgument;
import edu.jhu.cs.bsj.compiler.impl.ast.node.AnnotationBodyNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.AnnotationDeclarationNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.AnnotationMethodDeclarationNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.AnnotationNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.ArrayAccessNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.ArrayInitializerNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.ArrayInstantiatonNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.ArrayTypeNodeImpl;
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
import edu.jhu.cs.bsj.compiler.impl.ast.node.ClassInstantiationNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.CompilationUnitNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.CompoundAssignmentNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.ConditionalExpressionNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.ConstructorDeclarationNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.ContinueNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.DeclaredTypeNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.DoWhileLoopNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.DoubleLiteralNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.EnhancedForLoopNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.EnumBodyNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.EnumConstantDeclarationNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.EnumDeclarationNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.ExpressionStatementNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.FieldDeclarationNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.FloatLiteralNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.ForLoopNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.IdentifierNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.IfNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.ImportNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.InitializerDeclarationNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.InstanceOfNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.IntLiteralNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.InterfaceBodyNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.InterfaceDeclarationNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.LabeledStatementNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.ListNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.LongLiteralNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.MemberSelectNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.MethodDeclarationNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.MethodInvocationNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.ModifiersNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.ParameterizedTypeNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.PrimitiveTypeNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.QualifiedNameNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.StringLiteralNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.SwitchNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.ThrowNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.TryNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.TypeCastNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.TypeParameterNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.UnaryOperatorNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.VariableDeclarationNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.VariableNodeImpl;
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
     * Creates a InterfaceBodyNode.
     */
    public InterfaceBodyNode makeInterfaceBodyNode(
            ListNode<? extends InterfaceMember> members)
    {
        InterfaceBodyNode ret = new InterfaceBodyNodeImpl(members);
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
     * Creates a MethodInvocationNode.
     */
    public MethodInvocationNode makeMethodInvocationNode(
            NameNode methodSelect,
            ListNode<? extends ExpressionNode> arguments,
            ListNode<? extends TypeNode> typeArguments)
    {
        MethodInvocationNode ret = new MethodInvocationNodeImpl(methodSelect, arguments, typeArguments);
        return ret;
    }

    /**
     * Creates a ClassDeclarationNode.
     */
    public ClassDeclarationNode makeClassDeclarationNode(
            TypeNode extendsClause,
            ListNode<? extends TypeNode> implementsClause,
            ClassBodyNode body,
            ListNode<? extends TypeParameterNode> typeParameters,
            IdentifierNode simpleName,
            ModifiersNode modifiers)
    {
        ClassDeclarationNode ret = new ClassDeclarationNodeImpl(extendsClause, implementsClause, body, typeParameters, simpleName, modifiers);
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
     * Creates a DeclaredTypeNode.
     */
    public DeclaredTypeNode makeDeclaredTypeNode(
            NameNode name)
    {
        DeclaredTypeNode ret = new DeclaredTypeNodeImpl(name);
        return ret;
    }

    /**
     * Creates a CompoundAssignmentNode.
     */
    public CompoundAssignmentNode makeCompoundAssignmentNode(
            ExpressionNode expression,
            NameNode variable)
    {
        CompoundAssignmentNode ret = new CompoundAssignmentNodeImpl(expression, variable);
        return ret;
    }

    /**
     * Creates a ArrayAccessNode.
     */
    public ArrayAccessNode makeArrayAccessNode(
            ExpressionNode expression,
            ExpressionNode index)
    {
        ArrayAccessNode ret = new ArrayAccessNodeImpl(expression, index);
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
     * Creates a LongLiteralNode.
     */
    public LongLiteralNode makeLongLiteralNode(
            Long value)
    {
        LongLiteralNode ret = new LongLiteralNodeImpl(value);
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
     * Creates a QualifiedNameNode.
     */
    public QualifiedNameNode makeQualifiedNameNode(
            NameNode name,
            IdentifierNode identifier)
    {
        QualifiedNameNode ret = new QualifiedNameNodeImpl(name, identifier);
        return ret;
    }

    /**
     * Creates a VariableNode.
     */
    public VariableNode makeVariableNode(
            TypeNode type,
            IdentifierNode name)
    {
        VariableNode ret = new VariableNodeImpl(type, name);
        return ret;
    }

    /**
     * Creates a ImportNode.
     */
    public ImportNode makeImportNode(
            NameNode qualifiedIdentifier,
            boolean staticImport)
    {
        ImportNode ret = new ImportNodeImpl(qualifiedIdentifier, staticImport);
        return ret;
    }

    /**
     * Creates a CaseNode.
     */
    public CaseNode makeCaseNode(
            ExpressionNode expression,
            ListNode<? extends StatementNode> statements)
    {
        CaseNode ret = new CaseNodeImpl(expression, statements);
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
            ListNode<? extends AnnotationNode> annotations,
            Set<Modifier> flags)
    {
        ModifiersNode ret = new ModifiersNodeImpl(annotations, flags);
        return ret;
    }

    /**
     * Creates a MemberSelectNode.
     */
    public MemberSelectNode makeMemberSelectNode(
            ExpressionNode expression,
            IdentifierNode identifier)
    {
        MemberSelectNode ret = new MemberSelectNodeImpl(expression, identifier);
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
     * Creates a EnumBodyNode.
     */
    public EnumBodyNode makeEnumBodyNode(
            ListNode<? extends EnumConstantDeclarationNode> constants,
            ListNode<? extends ClassMember> members)
    {
        EnumBodyNode ret = new EnumBodyNodeImpl(constants, members);
        return ret;
    }

    /**
     * Creates a SwitchNode.
     */
    public SwitchNode makeSwitchNode(
            ListNode<? extends CaseNode> cases,
            ExpressionNode expression)
    {
        SwitchNode ret = new SwitchNodeImpl(cases, expression);
        return ret;
    }

    /**
     * Creates a TryNode.
     */
    public TryNode makeTryNode(
            BlockStatementNode block,
            ListNode<? extends CatchNode> catches,
            BlockStatementNode finallyBlock)
    {
        TryNode ret = new TryNodeImpl(block, catches, finallyBlock);
        return ret;
    }

    /**
     * Creates a ConstructorDeclarationNode.
     */
    public ConstructorDeclarationNode makeConstructorDeclarationNode(
            BlockStatementNode body,
            ModifiersNode modifiers,
            ListNode<? extends VariableNode> parameters,
            ListNode<? extends DeclaredTypeNode> throwTypes,
            ListNode<? extends TypeParameterNode> typeParameters)
    {
        ConstructorDeclarationNode ret = new ConstructorDeclarationNodeImpl(body, modifiers, parameters, throwTypes, typeParameters);
        return ret;
    }

    /**
     * Creates a ForLoopNode.
     */
    public ForLoopNode makeForLoopNode(
            ListNode<? extends StatementNode> initializer,
            ListNode<? extends ExpressionStatementNode> update,
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
            List<? extends T> children)
    {
        ListNode<T> ret = new ListNodeImpl<T>(children);
        return ret;
    }

    /**
     * Creates a EnumConstantDeclarationNode.
     */
    public EnumConstantDeclarationNode makeEnumConstantDeclarationNode(
            ListNode<? extends AnnotationNode> annotations,
            IdentifierNode identifier,
            ListNode<? extends ExpressionNode> arguments,
            ClassBodyNode body)
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
     * Creates a EnumDeclarationNode.
     */
    public EnumDeclarationNode makeEnumDeclarationNode(
            ListNode<? extends TypeNode> implementsClause,
            EnumBodyNode body,
            IdentifierNode simpleName,
            ModifiersNode modifiers)
    {
        EnumDeclarationNode ret = new EnumDeclarationNodeImpl(implementsClause, body, simpleName, modifiers);
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
     * Creates a VariableDeclarationNode.
     */
    public VariableDeclarationNode makeVariableDeclarationNode(
            VariableNode variable,
            ExpressionNode initializer)
    {
        VariableDeclarationNode ret = new VariableDeclarationNodeImpl(variable, initializer);
        return ret;
    }

    /**
     * Creates a AnnotationBodyNode.
     */
    public AnnotationBodyNode makeAnnotationBodyNode(
            ListNode<? extends AnnotationMember> members)
    {
        AnnotationBodyNode ret = new AnnotationBodyNodeImpl(members);
        return ret;
    }

    /**
     * Creates a TypeParameterNode.
     */
    public TypeParameterNode makeTypeParameterNode(
            IdentifierNode name,
            ListNode<? extends TypeNode> bounds)
    {
        TypeParameterNode ret = new TypeParameterNodeImpl(name, bounds);
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
     * Creates a FieldDeclarationNode.
     */
    public FieldDeclarationNode makeFieldDeclarationNode(
            VariableNode variable,
            ExpressionNode initializer)
    {
        FieldDeclarationNode ret = new FieldDeclarationNodeImpl(variable, initializer);
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
     * Creates a ArrayInitializerNode.
     */
    public ArrayInitializerNode makeArrayInitializerNode(
            TypeNode type,
            ListNode<? extends ExpressionNode> initializers)
    {
        ArrayInitializerNode ret = new ArrayInitializerNodeImpl(type, initializers);
        return ret;
    }

    /**
     * Creates a ClassInstantiationNode.
     */
    public ClassInstantiationNode makeClassInstantiationNode(
            ListNode<? extends TypeNode> typeArguments,
            NameNode identifier,
            ListNode<? extends ExpressionNode> arguments,
            ClassDeclarationNode classBody,
            ExpressionNode enclosingExpression)
    {
        ClassInstantiationNode ret = new ClassInstantiationNodeImpl(typeArguments, identifier, arguments, classBody, enclosingExpression);
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
     * Creates a AssignmentNode.
     */
    public AssignmentNode makeAssignmentNode(
            ExpressionNode expression,
            ExpressionNode variable)
    {
        AssignmentNode ret = new AssignmentNodeImpl(expression, variable);
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
     * Creates a ArrayInstantiatonNode.
     */
    public ArrayInstantiatonNode makeArrayInstantiatonNode(
            TypeNode type,
            ListNode<? extends ExpressionNode> dimensions)
    {
        ArrayInstantiatonNode ret = new ArrayInstantiatonNodeImpl(type, dimensions);
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
     * Creates a AnnotationNode.
     */
    public AnnotationNode makeAnnotationNode(
            DeclaredTypeNode annotationType,
            ListNode<? extends ExpressionNode> arguments)
    {
        AnnotationNode ret = new AnnotationNodeImpl(annotationType, arguments);
        return ret;
    }

    /**
     * Creates a ParameterizedTypeNode.
     */
    public ParameterizedTypeNode makeParameterizedTypeNode(
            DeclaredTypeNode type,
            ListNode<? extends TypeArgument> typeArguments)
    {
        ParameterizedTypeNode ret = new ParameterizedTypeNodeImpl(type, typeArguments);
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
            ListNode<? extends StatementNode> statements)
    {
        BlockStatementNode ret = new BlockStatementNodeImpl(statements);
        return ret;
    }

    /**
     * Creates a InterfaceDeclarationNode.
     */
    public InterfaceDeclarationNode makeInterfaceDeclarationNode(
            ListNode<? extends TypeNode> extendsClause,
            InterfaceBodyNode body,
            ListNode<? extends TypeParameterNode> typeParameters,
            IdentifierNode simpleName,
            ModifiersNode modifiers)
    {
        InterfaceDeclarationNode ret = new InterfaceDeclarationNodeImpl(extendsClause, body, typeParameters, simpleName, modifiers);
        return ret;
    }

    /**
     * Creates a AnnotationDeclarationNode.
     */
    public AnnotationDeclarationNode makeAnnotationDeclarationNode(
            AnnotationBodyNode body,
            IdentifierNode simpleName,
            ModifiersNode modifiers)
    {
        AnnotationDeclarationNode ret = new AnnotationDeclarationNodeImpl(body, simpleName, modifiers);
        return ret;
    }

    /**
     * Creates a CompilationUnitNode.
     */
    public CompilationUnitNode makeCompilationUnitNode(
            ListNode<? extends ImportNode> imports,
            ListNode<? extends AnnotationNode> packageAnnotations,
            QualifiedNameNode packageName,
            ListNode<? extends TypeDeclarationNode> typeDecls)
    {
        CompilationUnitNode ret = new CompilationUnitNodeImpl(imports, packageAnnotations, packageName, typeDecls);
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
     * Creates a ClassBodyNode.
     */
    public ClassBodyNode makeClassBodyNode(
            ListNode<? extends ClassMember> members)
    {
        ClassBodyNode ret = new ClassBodyNodeImpl(members);
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
     * Creates a IntLiteralNode.
     */
    public IntLiteralNode makeIntLiteralNode(
            Integer value)
    {
        IntLiteralNode ret = new IntLiteralNodeImpl(value);
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
     * Creates a MethodDeclarationNode.
     */
    public MethodDeclarationNode makeMethodDeclarationNode(
            BlockStatementNode body,
            ModifiersNode modifiers,
            IdentifierNode name,
            ListNode<? extends VariableNode> parameters,
            TypeNode returnType,
            ListNode<? extends DeclaredTypeNode> throwTypes,
            ListNode<? extends TypeParameterNode> typeParameters)
    {
        MethodDeclarationNode ret = new MethodDeclarationNodeImpl(body, modifiers, name, parameters, returnType, throwTypes, typeParameters);
        return ret;
    }

}
