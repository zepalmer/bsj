package edu.jhu.cs.bsj.compiler.impl.ast;

import java.util.List;
import java.util.Set;

import edu.jhu.cs.bsj.compiler.ast.BinaryOperator;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.Identifier;
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
        return new InterfaceBodyNodeImpl(members);
    }

    /**
     * Creates a ExpressionStatementNode.
     */
    public ExpressionStatementNode makeExpressionStatementNode(
            ExpressionNode expression)
    {
        return new ExpressionStatementNodeImpl(expression);
    }

    /**
     * Creates a MethodInvocationNode.
     */
    public MethodInvocationNode makeMethodInvocationNode(
            NameNode methodSelect,
            ListNode<? extends ExpressionNode> arguments,
            ListNode<? extends TypeNode> typeArguments)
    {
        return new MethodInvocationNodeImpl(methodSelect, arguments, typeArguments);
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
        return new ClassDeclarationNodeImpl(extendsClause, implementsClause, body, typeParameters, simpleName, modifiers);
    }

    /**
     * Creates a EnhancedForLoopNode.
     */
    public EnhancedForLoopNode makeEnhancedForLoopNode(
            VariableNode variable,
            ExpressionNode expression,
            StatementNode statement)
    {
        return new EnhancedForLoopNodeImpl(variable, expression, statement);
    }

    /**
     * Creates a DeclaredTypeNode.
     */
    public DeclaredTypeNode makeDeclaredTypeNode(
            NameNode name)
    {
        return new DeclaredTypeNodeImpl(name);
    }

    /**
     * Creates a CompoundAssignmentNode.
     */
    public CompoundAssignmentNode makeCompoundAssignmentNode(
            ExpressionNode expression,
            NameNode variable)
    {
        return new CompoundAssignmentNodeImpl(expression, variable);
    }

    /**
     * Creates a ArrayAccessNode.
     */
    public ArrayAccessNode makeArrayAccessNode(
            ExpressionNode expression,
            ExpressionNode index)
    {
        return new ArrayAccessNodeImpl(expression, index);
    }

    /**
     * Creates a DoubleLiteralNode.
     */
    public DoubleLiteralNode makeDoubleLiteralNode(
            Double value)
    {
        return new DoubleLiteralNodeImpl(value);
    }

    /**
     * Creates a LongLiteralNode.
     */
    public LongLiteralNode makeLongLiteralNode(
            Long value)
    {
        return new LongLiteralNodeImpl(value);
    }

    /**
     * Creates a UnaryOperatorNode.
     */
    public UnaryOperatorNode makeUnaryOperatorNode(
            ExpressionNode expression,
            UnaryOperator operator)
    {
        return new UnaryOperatorNodeImpl(expression, operator);
    }

    /**
     * Creates a VariableNode.
     */
    public VariableNode makeVariableNode(
            TypeNode type,
            IdentifierNode name)
    {
        return new VariableNodeImpl(type, name);
    }

    /**
     * Creates a ImportNode.
     */
    public ImportNode makeImportNode(
            NameNode qualifiedIdentifier,
            boolean staticImport)
    {
        return new ImportNodeImpl(qualifiedIdentifier, staticImport);
    }

    /**
     * Creates a CaseNode.
     */
    public CaseNode makeCaseNode(
            ExpressionNode expression,
            ListNode<? extends StatementNode> statements)
    {
        return new CaseNodeImpl(expression, statements);
    }

    /**
     * Creates a CodeLiteralNode.
     */
    public CodeLiteralNode makeCodeLiteralNode(
            Node value)
    {
        return new CodeLiteralNodeImpl(value);
    }

    /**
     * Creates a CharLiteralNode.
     */
    public CharLiteralNode makeCharLiteralNode(
            Character value)
    {
        return new CharLiteralNodeImpl(value);
    }

    /**
     * Creates a WildcardTypeNode.
     */
    public WildcardTypeNode makeWildcardTypeNode(
            TypeNode bound,
            boolean upperBound)
    {
        return new WildcardTypeNodeImpl(bound, upperBound);
    }

    /**
     * Creates a PrimitiveTypeNode.
     */
    public PrimitiveTypeNode makePrimitiveTypeNode(
            PrimitiveType primitiveType)
    {
        return new PrimitiveTypeNodeImpl(primitiveType);
    }

    /**
     * Creates a InitializerDeclarationNode.
     */
    public InitializerDeclarationNode makeInitializerDeclarationNode(
            boolean staticInitializer,
            BlockStatementNode body)
    {
        return new InitializerDeclarationNodeImpl(staticInitializer, body);
    }

    /**
     * Creates a ModifiersNode.
     */
    public ModifiersNode makeModifiersNode(
            ListNode<? extends AnnotationNode> annotations,
            Set<Modifier> flags)
    {
        return new ModifiersNodeImpl(annotations, flags);
    }

    /**
     * Creates a MemberSelectNode.
     */
    public MemberSelectNode makeMemberSelectNode(
            NameNode expression,
            IdentifierNode identifier)
    {
        return new MemberSelectNodeImpl(expression, identifier);
    }

    /**
     * Creates a BooleanLiteralNode.
     */
    public BooleanLiteralNode makeBooleanLiteralNode(
            Boolean value)
    {
        return new BooleanLiteralNodeImpl(value);
    }

    /**
     * Creates a EnumBodyNode.
     */
    public EnumBodyNode makeEnumBodyNode(
            ListNode<? extends EnumConstantDeclarationNode> constants,
            ListNode<? extends ClassMember> members)
    {
        return new EnumBodyNodeImpl(constants, members);
    }

    /**
     * Creates a SwitchNode.
     */
    public SwitchNode makeSwitchNode(
            ListNode<? extends CaseNode> cases,
            ExpressionNode expression)
    {
        return new SwitchNodeImpl(cases, expression);
    }

    /**
     * Creates a TryNode.
     */
    public TryNode makeTryNode(
            BlockStatementNode block,
            ListNode<? extends CatchNode> catches,
            BlockStatementNode finallyBlock)
    {
        return new TryNodeImpl(block, catches, finallyBlock);
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
        return new ConstructorDeclarationNodeImpl(body, modifiers, parameters, throwTypes, typeParameters);
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
        return new ForLoopNodeImpl(initializer, update, condition, statement);
    }

    /**
     * Creates a WhileLoopNode.
     */
    public WhileLoopNode makeWhileLoopNode(
            ExpressionNode condition,
            StatementNode statement)
    {
        return new WhileLoopNodeImpl(condition, statement);
    }

    /**
     * Creates a ListNode.
     */
    public <T extends Node> ListNode<T> makeListNode(
            List<? extends T> children)
    {
        return new ListNodeImpl<T>(children);
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
        return new EnumConstantDeclarationNodeImpl(annotations, identifier, arguments, body);
    }

    /**
     * Creates a BreakNode.
     */
    public BreakNode makeBreakNode(
            IdentifierNode label)
    {
        return new BreakNodeImpl(label);
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
        return new EnumDeclarationNodeImpl(implementsClause, body, simpleName, modifiers);
    }

    /**
     * Creates a IdentifierNode.
     */
    public IdentifierNode makeIdentifierNode(
            Identifier identifier)
    {
        return new IdentifierNodeImpl(identifier);
    }

    /**
     * Creates a ArrayTypeNode.
     */
    public ArrayTypeNode makeArrayTypeNode(
            TypeNode type)
    {
        return new ArrayTypeNodeImpl(type);
    }

    /**
     * Creates a VariableDeclarationNode.
     */
    public VariableDeclarationNode makeVariableDeclarationNode(
            VariableNode variable,
            ExpressionNode initializer)
    {
        return new VariableDeclarationNodeImpl(variable, initializer);
    }

    /**
     * Creates a AnnotationBodyNode.
     */
    public AnnotationBodyNode makeAnnotationBodyNode(
            ListNode<? extends AnnotationMember> members)
    {
        return new AnnotationBodyNodeImpl(members);
    }

    /**
     * Creates a TypeParameterNode.
     */
    public TypeParameterNode makeTypeParameterNode(
            IdentifierNode name,
            ListNode<? extends TypeNode> bounds)
    {
        return new TypeParameterNodeImpl(name, bounds);
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
        return new AnnotationMethodDeclarationNodeImpl(modifiers, type, identifier, defaultValue);
    }

    /**
     * Creates a FieldDeclarationNode.
     */
    public FieldDeclarationNode makeFieldDeclarationNode(
            VariableNode variable,
            ExpressionNode initializer)
    {
        return new FieldDeclarationNodeImpl(variable, initializer);
    }

    /**
     * Creates a ThrowNode.
     */
    public ThrowNode makeThrowNode(
            ExpressionNode expression)
    {
        return new ThrowNodeImpl(expression);
    }

    /**
     * Creates a ArrayInitializerNode.
     */
    public ArrayInitializerNode makeArrayInitializerNode(
            TypeNode type,
            ListNode<? extends ExpressionNode> initializers)
    {
        return new ArrayInitializerNodeImpl(type, initializers);
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
        return new ClassInstantiationNodeImpl(typeArguments, identifier, arguments, classBody, enclosingExpression);
    }

    /**
     * Creates a CatchNode.
     */
    public CatchNode makeCatchNode(
            BlockStatementNode block,
            VariableNode parameter)
    {
        return new CatchNodeImpl(block, parameter);
    }

    /**
     * Creates a AssignmentNode.
     */
    public AssignmentNode makeAssignmentNode(
            ExpressionNode expression,
            ExpressionNode variable)
    {
        return new AssignmentNodeImpl(expression, variable);
    }

    /**
     * Creates a InstanceOfNode.
     */
    public InstanceOfNode makeInstanceOfNode(
            ExpressionNode expression,
            TypeNode type)
    {
        return new InstanceOfNodeImpl(expression, type);
    }

    /**
     * Creates a ConditionalExpressionNode.
     */
    public ConditionalExpressionNode makeConditionalExpressionNode(
            ExpressionNode condition,
            ExpressionNode trueExpression,
            ExpressionNode falseExpression)
    {
        return new ConditionalExpressionNodeImpl(condition, trueExpression, falseExpression);
    }

    /**
     * Creates a ArrayInstantiatonNode.
     */
    public ArrayInstantiatonNode makeArrayInstantiatonNode(
            TypeNode type,
            ListNode<? extends ExpressionNode> dimensions)
    {
        return new ArrayInstantiatonNodeImpl(type, dimensions);
    }

    /**
     * Creates a FloatLiteralNode.
     */
    public FloatLiteralNode makeFloatLiteralNode(
            Float value)
    {
        return new FloatLiteralNodeImpl(value);
    }

    /**
     * Creates a BinaryOperatorNode.
     */
    public BinaryOperatorNode makeBinaryOperatorNode(
            ExpressionNode leftOperand,
            ExpressionNode rightOperand,
            BinaryOperator operator)
    {
        return new BinaryOperatorNodeImpl(leftOperand, rightOperand, operator);
    }

    /**
     * Creates a DoWhileLoopNode.
     */
    public DoWhileLoopNode makeDoWhileLoopNode(
            ExpressionNode condition,
            StatementNode statement)
    {
        return new DoWhileLoopNodeImpl(condition, statement);
    }

    /**
     * Creates a AnnotationNode.
     */
    public AnnotationNode makeAnnotationNode(
            DeclaredTypeNode annotationType,
            ListNode<? extends ExpressionNode> arguments)
    {
        return new AnnotationNodeImpl(annotationType, arguments);
    }

    /**
     * Creates a ParameterizedTypeNode.
     */
    public ParameterizedTypeNode makeParameterizedTypeNode(
            DeclaredTypeNode type,
            ListNode<? extends TypeArgument> typeArguments)
    {
        return new ParameterizedTypeNodeImpl(type, typeArguments);
    }

    /**
     * Creates a TypeCastNode.
     */
    public TypeCastNode makeTypeCastNode(
            ExpressionNode expression,
            TypeNode type)
    {
        return new TypeCastNodeImpl(expression, type);
    }

    /**
     * Creates a LabeledStatementNode.
     */
    public LabeledStatementNode makeLabeledStatementNode(
            IdentifierNode label,
            StatementNode statement)
    {
        return new LabeledStatementNodeImpl(label, statement);
    }

    /**
     * Creates a BlockStatementNode.
     */
    public BlockStatementNode makeBlockStatementNode(
            ListNode<? extends StatementNode> statements)
    {
        return new BlockStatementNodeImpl(statements);
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
        return new InterfaceDeclarationNodeImpl(extendsClause, body, typeParameters, simpleName, modifiers);
    }

    /**
     * Creates a AnnotationDeclarationNode.
     */
    public AnnotationDeclarationNode makeAnnotationDeclarationNode(
            AnnotationBodyNode body,
            IdentifierNode simpleName,
            ModifiersNode modifiers)
    {
        return new AnnotationDeclarationNodeImpl(body, simpleName, modifiers);
    }

    /**
     * Creates a CompilationUnitNode.
     */
    public CompilationUnitNode makeCompilationUnitNode(
            ListNode<? extends ImportNode> imports,
            ListNode<? extends AnnotationNode> packageAnnotations,
            ExpressionNode packageName,
            ListNode<? extends TypeDeclarationNode> typeDecls)
    {
        return new CompilationUnitNodeImpl(imports, packageAnnotations, packageName, typeDecls);
    }

    /**
     * Creates a ContinueNode.
     */
    public ContinueNode makeContinueNode(
            IdentifierNode label)
    {
        return new ContinueNodeImpl(label);
    }

    /**
     * Creates a ClassBodyNode.
     */
    public ClassBodyNode makeClassBodyNode(
            ListNode<? extends ClassMember> members)
    {
        return new ClassBodyNodeImpl(members);
    }

    /**
     * Creates a IfNode.
     */
    public IfNode makeIfNode(
            ExpressionNode condition,
            StatementNode thenStatement,
            StatementNode elseStatement)
    {
        return new IfNodeImpl(condition, thenStatement, elseStatement);
    }

    /**
     * Creates a IntLiteralNode.
     */
    public IntLiteralNode makeIntLiteralNode(
            Integer value)
    {
        return new IntLiteralNodeImpl(value);
    }

    /**
     * Creates a StringLiteralNode.
     */
    public StringLiteralNode makeStringLiteralNode(
            String value)
    {
        return new StringLiteralNodeImpl(value);
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
        return new MethodDeclarationNodeImpl(body, modifiers, name, parameters, returnType, throwTypes, typeParameters);
    }

}
