package edu.jhu.cs.bsj.compiler.ast;

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
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.PackageDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.ParameterizedTypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.PrimitiveTypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.QualifiedNameNode;
import edu.jhu.cs.bsj.compiler.ast.node.StringLiteralNode;
import edu.jhu.cs.bsj.compiler.ast.node.SwitchNode;
import edu.jhu.cs.bsj.compiler.ast.node.ThrowNode;
import edu.jhu.cs.bsj.compiler.ast.node.TryNode;
import edu.jhu.cs.bsj.compiler.ast.node.TypeCastNode;
import edu.jhu.cs.bsj.compiler.ast.node.TypeParameterNode;
import edu.jhu.cs.bsj.compiler.ast.node.UnaryOperatorNode;
import edu.jhu.cs.bsj.compiler.ast.node.VariableDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.VariableNode;
import edu.jhu.cs.bsj.compiler.ast.node.WhileLoopNode;
import edu.jhu.cs.bsj.compiler.ast.node.WildcardTypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.CodeLiteralNode;

/**
 * This default implementation of the BsjNodeVisitor separates nodes based on type.  Each
 * type of node is routed to a different method to be handled; the default implementation of
 * each of the type-specific methods does nothing.
 *
 * @author Zachary Palmer
 */
public abstract class BsjTypedNodeVisitor implements BsjNodeVisitor
{
    /**
     * Starts visiting the specified node.
     * @param node The node to visit.
     */
    public void visitStart(Node node)
    {
        if (node instanceof BooleanLiteralNode)
        {
            visitBooleanLiteralNodeStart((BooleanLiteralNode)node);
        } else if (node instanceof FloatLiteralNode)
        {
            visitFloatLiteralNodeStart((FloatLiteralNode)node);
        } else if (node instanceof LongLiteralNode)
        {
            visitLongLiteralNodeStart((LongLiteralNode)node);
        } else if (node instanceof IntLiteralNode)
        {
            visitIntLiteralNodeStart((IntLiteralNode)node);
        } else if (node instanceof StringLiteralNode)
        {
            visitStringLiteralNodeStart((StringLiteralNode)node);
        } else if (node instanceof DoubleLiteralNode)
        {
            visitDoubleLiteralNodeStart((DoubleLiteralNode)node);
        } else if (node instanceof CharLiteralNode)
        {
            visitCharLiteralNodeStart((CharLiteralNode)node);
        } else if (node instanceof CodeLiteralNode)
        {
            visitCodeLiteralNodeStart((CodeLiteralNode)node);
        } else if (node instanceof QualifiedNameNode)
        {
            visitQualifiedNameNodeStart((QualifiedNameNode)node);
        } else if (node instanceof IdentifierNode)
        {
            visitIdentifierNodeStart((IdentifierNode)node);
        } else if (node instanceof PrimitiveTypeNode)
        {
            visitPrimitiveTypeNodeStart((PrimitiveTypeNode)node);
        } else if (node instanceof DeclaredTypeNode)
        {
            visitDeclaredTypeNodeStart((DeclaredTypeNode)node);
        } else if (node instanceof ParameterizedTypeNode)
        {
            visitParameterizedTypeNodeStart((ParameterizedTypeNode)node);
        } else if (node instanceof ArrayTypeNode)
        {
            visitArrayTypeNodeStart((ArrayTypeNode)node);
        } else if (node instanceof SwitchNode)
        {
            visitSwitchNodeStart((SwitchNode)node);
        } else if (node instanceof VariableDeclarationNode)
        {
            visitVariableDeclarationNodeStart((VariableDeclarationNode)node);
        } else if (node instanceof IfNode)
        {
            visitIfNodeStart((IfNode)node);
        } else if (node instanceof ContinueNode)
        {
            visitContinueNodeStart((ContinueNode)node);
        } else if (node instanceof ThrowNode)
        {
            visitThrowNodeStart((ThrowNode)node);
        } else if (node instanceof BreakNode)
        {
            visitBreakNodeStart((BreakNode)node);
        } else if (node instanceof ForLoopNode)
        {
            visitForLoopNodeStart((ForLoopNode)node);
        } else if (node instanceof WhileLoopNode)
        {
            visitWhileLoopNodeStart((WhileLoopNode)node);
        } else if (node instanceof BlockStatementNode)
        {
            visitBlockStatementNodeStart((BlockStatementNode)node);
        } else if (node instanceof LabeledStatementNode)
        {
            visitLabeledStatementNodeStart((LabeledStatementNode)node);
        } else if (node instanceof EnhancedForLoopNode)
        {
            visitEnhancedForLoopNodeStart((EnhancedForLoopNode)node);
        } else if (node instanceof ExpressionStatementNode)
        {
            visitExpressionStatementNodeStart((ExpressionStatementNode)node);
        } else if (node instanceof TryNode)
        {
            visitTryNodeStart((TryNode)node);
        } else if (node instanceof DoWhileLoopNode)
        {
            visitDoWhileLoopNodeStart((DoWhileLoopNode)node);
        } else if (node instanceof EnumDeclarationNode)
        {
            visitEnumDeclarationNodeStart((EnumDeclarationNode)node);
        } else if (node instanceof InterfaceDeclarationNode)
        {
            visitInterfaceDeclarationNodeStart((InterfaceDeclarationNode)node);
        } else if (node instanceof ClassDeclarationNode)
        {
            visitClassDeclarationNodeStart((ClassDeclarationNode)node);
        } else if (node instanceof AnnotationDeclarationNode)
        {
            visitAnnotationDeclarationNodeStart((AnnotationDeclarationNode)node);
        } else if (node instanceof BinaryOperatorNode)
        {
            visitBinaryOperatorNodeStart((BinaryOperatorNode)node);
        } else if (node instanceof MemberSelectNode)
        {
            visitMemberSelectNodeStart((MemberSelectNode)node);
        } else if (node instanceof ArrayInstantiatonNode)
        {
            visitArrayInstantiatonNodeStart((ArrayInstantiatonNode)node);
        } else if (node instanceof ConditionalExpressionNode)
        {
            visitConditionalExpressionNodeStart((ConditionalExpressionNode)node);
        } else if (node instanceof InstanceOfNode)
        {
            visitInstanceOfNodeStart((InstanceOfNode)node);
        } else if (node instanceof AssignmentNode)
        {
            visitAssignmentNodeStart((AssignmentNode)node);
        } else if (node instanceof ClassInstantiationNode)
        {
            visitClassInstantiationNodeStart((ClassInstantiationNode)node);
        } else if (node instanceof ArrayInitializerNode)
        {
            visitArrayInitializerNodeStart((ArrayInitializerNode)node);
        } else if (node instanceof UnaryOperatorNode)
        {
            visitUnaryOperatorNodeStart((UnaryOperatorNode)node);
        } else if (node instanceof ArrayAccessNode)
        {
            visitArrayAccessNodeStart((ArrayAccessNode)node);
        } else if (node instanceof CompoundAssignmentNode)
        {
            visitCompoundAssignmentNodeStart((CompoundAssignmentNode)node);
        } else if (node instanceof MethodInvocationNode)
        {
            visitMethodInvocationNodeStart((MethodInvocationNode)node);
        } else if (node instanceof TypeCastNode)
        {
            visitTypeCastNodeStart((TypeCastNode)node);
        } else if (node instanceof AnnotationNode)
        {
            visitAnnotationNodeStart((AnnotationNode)node);
        } else if (node instanceof EnumBodyNode)
        {
            visitEnumBodyNodeStart((EnumBodyNode)node);
        } else if (node instanceof MethodDeclarationNode)
        {
            visitMethodDeclarationNodeStart((MethodDeclarationNode)node);
        } else if (node instanceof TypeParameterNode)
        {
            visitTypeParameterNodeStart((TypeParameterNode)node);
        } else if (node instanceof ModifiersNode)
        {
            visitModifiersNodeStart((ModifiersNode)node);
        } else if (node instanceof InitializerDeclarationNode)
        {
            visitInitializerDeclarationNodeStart((InitializerDeclarationNode)node);
        } else if (node instanceof AnnotationBodyNode)
        {
            visitAnnotationBodyNodeStart((AnnotationBodyNode)node);
        } else if (node instanceof ClassBodyNode)
        {
            visitClassBodyNodeStart((ClassBodyNode)node);
        } else if (node instanceof WildcardTypeNode)
        {
            visitWildcardTypeNodeStart((WildcardTypeNode)node);
        } else if (node instanceof CatchNode)
        {
            visitCatchNodeStart((CatchNode)node);
        } else if (node instanceof CaseNode)
        {
            visitCaseNodeStart((CaseNode)node);
        } else if (node instanceof CompilationUnitNode)
        {
            visitCompilationUnitNodeStart((CompilationUnitNode)node);
        } else if (node instanceof ImportNode)
        {
            visitImportNodeStart((ImportNode)node);
        } else if (node instanceof VariableNode)
        {
            visitVariableNodeStart((VariableNode)node);
        } else if (node instanceof PackageDeclarationNode)
        {
            visitPackageDeclarationNodeStart((PackageDeclarationNode)node);
        } else if (node instanceof EnumConstantDeclarationNode)
        {
            visitEnumConstantDeclarationNodeStart((EnumConstantDeclarationNode)node);
        } else if (node instanceof ListNode<?>)
        {
            visitListNodeStart((ListNode<?>)node);
        } else if (node instanceof ConstructorDeclarationNode)
        {
            visitConstructorDeclarationNodeStart((ConstructorDeclarationNode)node);
        } else if (node instanceof FieldDeclarationNode)
        {
            visitFieldDeclarationNodeStart((FieldDeclarationNode)node);
        } else if (node instanceof InterfaceBodyNode)
        {
            visitInterfaceBodyNodeStart((InterfaceBodyNode)node);
        } else if (node instanceof AnnotationMethodDeclarationNode)
        {
            visitAnnotationMethodDeclarationNodeStart((AnnotationMethodDeclarationNode)node);
        } else
        {
            throw new IllegalStateException("Unrecognized node type " + node.getClass());
        }
    }

    /**
     * Stops visiting the specified node.
     * @param node The node to visit.
     */
    public void visitStop(Node node)
    {
        if (node instanceof BooleanLiteralNode)
        {
            visitBooleanLiteralNodeStop((BooleanLiteralNode)node);
        } else if (node instanceof FloatLiteralNode)
        {
            visitFloatLiteralNodeStop((FloatLiteralNode)node);
        } else if (node instanceof LongLiteralNode)
        {
            visitLongLiteralNodeStop((LongLiteralNode)node);
        } else if (node instanceof IntLiteralNode)
        {
            visitIntLiteralNodeStop((IntLiteralNode)node);
        } else if (node instanceof StringLiteralNode)
        {
            visitStringLiteralNodeStop((StringLiteralNode)node);
        } else if (node instanceof DoubleLiteralNode)
        {
            visitDoubleLiteralNodeStop((DoubleLiteralNode)node);
        } else if (node instanceof CharLiteralNode)
        {
            visitCharLiteralNodeStop((CharLiteralNode)node);
        } else if (node instanceof CodeLiteralNode)
        {
            visitCodeLiteralNodeStop((CodeLiteralNode)node);
        } else if (node instanceof QualifiedNameNode)
        {
            visitQualifiedNameNodeStop((QualifiedNameNode)node);
        } else if (node instanceof IdentifierNode)
        {
            visitIdentifierNodeStop((IdentifierNode)node);
        } else if (node instanceof PrimitiveTypeNode)
        {
            visitPrimitiveTypeNodeStop((PrimitiveTypeNode)node);
        } else if (node instanceof DeclaredTypeNode)
        {
            visitDeclaredTypeNodeStop((DeclaredTypeNode)node);
        } else if (node instanceof ParameterizedTypeNode)
        {
            visitParameterizedTypeNodeStop((ParameterizedTypeNode)node);
        } else if (node instanceof ArrayTypeNode)
        {
            visitArrayTypeNodeStop((ArrayTypeNode)node);
        } else if (node instanceof SwitchNode)
        {
            visitSwitchNodeStop((SwitchNode)node);
        } else if (node instanceof VariableDeclarationNode)
        {
            visitVariableDeclarationNodeStop((VariableDeclarationNode)node);
        } else if (node instanceof IfNode)
        {
            visitIfNodeStop((IfNode)node);
        } else if (node instanceof ContinueNode)
        {
            visitContinueNodeStop((ContinueNode)node);
        } else if (node instanceof ThrowNode)
        {
            visitThrowNodeStop((ThrowNode)node);
        } else if (node instanceof BreakNode)
        {
            visitBreakNodeStop((BreakNode)node);
        } else if (node instanceof ForLoopNode)
        {
            visitForLoopNodeStop((ForLoopNode)node);
        } else if (node instanceof WhileLoopNode)
        {
            visitWhileLoopNodeStop((WhileLoopNode)node);
        } else if (node instanceof BlockStatementNode)
        {
            visitBlockStatementNodeStop((BlockStatementNode)node);
        } else if (node instanceof LabeledStatementNode)
        {
            visitLabeledStatementNodeStop((LabeledStatementNode)node);
        } else if (node instanceof EnhancedForLoopNode)
        {
            visitEnhancedForLoopNodeStop((EnhancedForLoopNode)node);
        } else if (node instanceof ExpressionStatementNode)
        {
            visitExpressionStatementNodeStop((ExpressionStatementNode)node);
        } else if (node instanceof TryNode)
        {
            visitTryNodeStop((TryNode)node);
        } else if (node instanceof DoWhileLoopNode)
        {
            visitDoWhileLoopNodeStop((DoWhileLoopNode)node);
        } else if (node instanceof EnumDeclarationNode)
        {
            visitEnumDeclarationNodeStop((EnumDeclarationNode)node);
        } else if (node instanceof InterfaceDeclarationNode)
        {
            visitInterfaceDeclarationNodeStop((InterfaceDeclarationNode)node);
        } else if (node instanceof ClassDeclarationNode)
        {
            visitClassDeclarationNodeStop((ClassDeclarationNode)node);
        } else if (node instanceof AnnotationDeclarationNode)
        {
            visitAnnotationDeclarationNodeStop((AnnotationDeclarationNode)node);
        } else if (node instanceof BinaryOperatorNode)
        {
            visitBinaryOperatorNodeStop((BinaryOperatorNode)node);
        } else if (node instanceof MemberSelectNode)
        {
            visitMemberSelectNodeStop((MemberSelectNode)node);
        } else if (node instanceof ArrayInstantiatonNode)
        {
            visitArrayInstantiatonNodeStop((ArrayInstantiatonNode)node);
        } else if (node instanceof ConditionalExpressionNode)
        {
            visitConditionalExpressionNodeStop((ConditionalExpressionNode)node);
        } else if (node instanceof InstanceOfNode)
        {
            visitInstanceOfNodeStop((InstanceOfNode)node);
        } else if (node instanceof AssignmentNode)
        {
            visitAssignmentNodeStop((AssignmentNode)node);
        } else if (node instanceof ClassInstantiationNode)
        {
            visitClassInstantiationNodeStop((ClassInstantiationNode)node);
        } else if (node instanceof ArrayInitializerNode)
        {
            visitArrayInitializerNodeStop((ArrayInitializerNode)node);
        } else if (node instanceof UnaryOperatorNode)
        {
            visitUnaryOperatorNodeStop((UnaryOperatorNode)node);
        } else if (node instanceof ArrayAccessNode)
        {
            visitArrayAccessNodeStop((ArrayAccessNode)node);
        } else if (node instanceof CompoundAssignmentNode)
        {
            visitCompoundAssignmentNodeStop((CompoundAssignmentNode)node);
        } else if (node instanceof MethodInvocationNode)
        {
            visitMethodInvocationNodeStop((MethodInvocationNode)node);
        } else if (node instanceof TypeCastNode)
        {
            visitTypeCastNodeStop((TypeCastNode)node);
        } else if (node instanceof AnnotationNode)
        {
            visitAnnotationNodeStop((AnnotationNode)node);
        } else if (node instanceof EnumBodyNode)
        {
            visitEnumBodyNodeStop((EnumBodyNode)node);
        } else if (node instanceof MethodDeclarationNode)
        {
            visitMethodDeclarationNodeStop((MethodDeclarationNode)node);
        } else if (node instanceof TypeParameterNode)
        {
            visitTypeParameterNodeStop((TypeParameterNode)node);
        } else if (node instanceof ModifiersNode)
        {
            visitModifiersNodeStop((ModifiersNode)node);
        } else if (node instanceof InitializerDeclarationNode)
        {
            visitInitializerDeclarationNodeStop((InitializerDeclarationNode)node);
        } else if (node instanceof AnnotationBodyNode)
        {
            visitAnnotationBodyNodeStop((AnnotationBodyNode)node);
        } else if (node instanceof ClassBodyNode)
        {
            visitClassBodyNodeStop((ClassBodyNode)node);
        } else if (node instanceof WildcardTypeNode)
        {
            visitWildcardTypeNodeStop((WildcardTypeNode)node);
        } else if (node instanceof CatchNode)
        {
            visitCatchNodeStop((CatchNode)node);
        } else if (node instanceof CaseNode)
        {
            visitCaseNodeStop((CaseNode)node);
        } else if (node instanceof CompilationUnitNode)
        {
            visitCompilationUnitNodeStop((CompilationUnitNode)node);
        } else if (node instanceof ImportNode)
        {
            visitImportNodeStop((ImportNode)node);
        } else if (node instanceof VariableNode)
        {
            visitVariableNodeStop((VariableNode)node);
        } else if (node instanceof PackageDeclarationNode)
        {
            visitPackageDeclarationNodeStop((PackageDeclarationNode)node);
        } else if (node instanceof EnumConstantDeclarationNode)
        {
            visitEnumConstantDeclarationNodeStop((EnumConstantDeclarationNode)node);
        } else if (node instanceof ListNode<?>)
        {
            visitListNodeStop((ListNode<?>)node);
        } else if (node instanceof ConstructorDeclarationNode)
        {
            visitConstructorDeclarationNodeStop((ConstructorDeclarationNode)node);
        } else if (node instanceof FieldDeclarationNode)
        {
            visitFieldDeclarationNodeStop((FieldDeclarationNode)node);
        } else if (node instanceof InterfaceBodyNode)
        {
            visitInterfaceBodyNodeStop((InterfaceBodyNode)node);
        } else if (node instanceof AnnotationMethodDeclarationNode)
        {
            visitAnnotationMethodDeclarationNodeStop((AnnotationMethodDeclarationNode)node);
        } else
        {
            throw new IllegalStateException("Unrecognized node type " + node.getClass());
        }
    }

    /**
     * Starts a visit for nodes of type BooleanLiteralNode.
     * @param node The node being visited.
     */
    public void visitBooleanLiteralNodeStart(BooleanLiteralNode node)
    {
    }

    /**
     * Starts a visit for nodes of type FloatLiteralNode.
     * @param node The node being visited.
     */
    public void visitFloatLiteralNodeStart(FloatLiteralNode node)
    {
    }

    /**
     * Starts a visit for nodes of type LongLiteralNode.
     * @param node The node being visited.
     */
    public void visitLongLiteralNodeStart(LongLiteralNode node)
    {
    }

    /**
     * Starts a visit for nodes of type IntLiteralNode.
     * @param node The node being visited.
     */
    public void visitIntLiteralNodeStart(IntLiteralNode node)
    {
    }

    /**
     * Starts a visit for nodes of type StringLiteralNode.
     * @param node The node being visited.
     */
    public void visitStringLiteralNodeStart(StringLiteralNode node)
    {
    }

    /**
     * Starts a visit for nodes of type DoubleLiteralNode.
     * @param node The node being visited.
     */
    public void visitDoubleLiteralNodeStart(DoubleLiteralNode node)
    {
    }

    /**
     * Starts a visit for nodes of type CharLiteralNode.
     * @param node The node being visited.
     */
    public void visitCharLiteralNodeStart(CharLiteralNode node)
    {
    }

    /**
     * Starts a visit for nodes of type CodeLiteralNode.
     * @param node The node being visited.
     */
    public void visitCodeLiteralNodeStart(CodeLiteralNode node)
    {
    }

    /**
     * Starts a visit for nodes of type QualifiedNameNode.
     * @param node The node being visited.
     */
    public void visitQualifiedNameNodeStart(QualifiedNameNode node)
    {
    }

    /**
     * Starts a visit for nodes of type IdentifierNode.
     * @param node The node being visited.
     */
    public void visitIdentifierNodeStart(IdentifierNode node)
    {
    }

    /**
     * Starts a visit for nodes of type PrimitiveTypeNode.
     * @param node The node being visited.
     */
    public void visitPrimitiveTypeNodeStart(PrimitiveTypeNode node)
    {
    }

    /**
     * Starts a visit for nodes of type DeclaredTypeNode.
     * @param node The node being visited.
     */
    public void visitDeclaredTypeNodeStart(DeclaredTypeNode node)
    {
    }

    /**
     * Starts a visit for nodes of type ParameterizedTypeNode.
     * @param node The node being visited.
     */
    public void visitParameterizedTypeNodeStart(ParameterizedTypeNode node)
    {
    }

    /**
     * Starts a visit for nodes of type ArrayTypeNode.
     * @param node The node being visited.
     */
    public void visitArrayTypeNodeStart(ArrayTypeNode node)
    {
    }

    /**
     * Starts a visit for nodes of type SwitchNode.
     * @param node The node being visited.
     */
    public void visitSwitchNodeStart(SwitchNode node)
    {
    }

    /**
     * Starts a visit for nodes of type VariableDeclarationNode.
     * @param node The node being visited.
     */
    public void visitVariableDeclarationNodeStart(VariableDeclarationNode node)
    {
    }

    /**
     * Starts a visit for nodes of type IfNode.
     * @param node The node being visited.
     */
    public void visitIfNodeStart(IfNode node)
    {
    }

    /**
     * Starts a visit for nodes of type ContinueNode.
     * @param node The node being visited.
     */
    public void visitContinueNodeStart(ContinueNode node)
    {
    }

    /**
     * Starts a visit for nodes of type ThrowNode.
     * @param node The node being visited.
     */
    public void visitThrowNodeStart(ThrowNode node)
    {
    }

    /**
     * Starts a visit for nodes of type BreakNode.
     * @param node The node being visited.
     */
    public void visitBreakNodeStart(BreakNode node)
    {
    }

    /**
     * Starts a visit for nodes of type ForLoopNode.
     * @param node The node being visited.
     */
    public void visitForLoopNodeStart(ForLoopNode node)
    {
    }

    /**
     * Starts a visit for nodes of type WhileLoopNode.
     * @param node The node being visited.
     */
    public void visitWhileLoopNodeStart(WhileLoopNode node)
    {
    }

    /**
     * Starts a visit for nodes of type BlockStatementNode.
     * @param node The node being visited.
     */
    public void visitBlockStatementNodeStart(BlockStatementNode node)
    {
    }

    /**
     * Starts a visit for nodes of type LabeledStatementNode.
     * @param node The node being visited.
     */
    public void visitLabeledStatementNodeStart(LabeledStatementNode node)
    {
    }

    /**
     * Starts a visit for nodes of type EnhancedForLoopNode.
     * @param node The node being visited.
     */
    public void visitEnhancedForLoopNodeStart(EnhancedForLoopNode node)
    {
    }

    /**
     * Starts a visit for nodes of type ExpressionStatementNode.
     * @param node The node being visited.
     */
    public void visitExpressionStatementNodeStart(ExpressionStatementNode node)
    {
    }

    /**
     * Starts a visit for nodes of type TryNode.
     * @param node The node being visited.
     */
    public void visitTryNodeStart(TryNode node)
    {
    }

    /**
     * Starts a visit for nodes of type DoWhileLoopNode.
     * @param node The node being visited.
     */
    public void visitDoWhileLoopNodeStart(DoWhileLoopNode node)
    {
    }

    /**
     * Starts a visit for nodes of type EnumDeclarationNode.
     * @param node The node being visited.
     */
    public void visitEnumDeclarationNodeStart(EnumDeclarationNode node)
    {
    }

    /**
     * Starts a visit for nodes of type InterfaceDeclarationNode.
     * @param node The node being visited.
     */
    public void visitInterfaceDeclarationNodeStart(InterfaceDeclarationNode node)
    {
    }

    /**
     * Starts a visit for nodes of type ClassDeclarationNode.
     * @param node The node being visited.
     */
    public void visitClassDeclarationNodeStart(ClassDeclarationNode node)
    {
    }

    /**
     * Starts a visit for nodes of type AnnotationDeclarationNode.
     * @param node The node being visited.
     */
    public void visitAnnotationDeclarationNodeStart(AnnotationDeclarationNode node)
    {
    }

    /**
     * Starts a visit for nodes of type BinaryOperatorNode.
     * @param node The node being visited.
     */
    public void visitBinaryOperatorNodeStart(BinaryOperatorNode node)
    {
    }

    /**
     * Starts a visit for nodes of type MemberSelectNode.
     * @param node The node being visited.
     */
    public void visitMemberSelectNodeStart(MemberSelectNode node)
    {
    }

    /**
     * Starts a visit for nodes of type ArrayInstantiatonNode.
     * @param node The node being visited.
     */
    public void visitArrayInstantiatonNodeStart(ArrayInstantiatonNode node)
    {
    }

    /**
     * Starts a visit for nodes of type ConditionalExpressionNode.
     * @param node The node being visited.
     */
    public void visitConditionalExpressionNodeStart(ConditionalExpressionNode node)
    {
    }

    /**
     * Starts a visit for nodes of type InstanceOfNode.
     * @param node The node being visited.
     */
    public void visitInstanceOfNodeStart(InstanceOfNode node)
    {
    }

    /**
     * Starts a visit for nodes of type AssignmentNode.
     * @param node The node being visited.
     */
    public void visitAssignmentNodeStart(AssignmentNode node)
    {
    }

    /**
     * Starts a visit for nodes of type ClassInstantiationNode.
     * @param node The node being visited.
     */
    public void visitClassInstantiationNodeStart(ClassInstantiationNode node)
    {
    }

    /**
     * Starts a visit for nodes of type ArrayInitializerNode.
     * @param node The node being visited.
     */
    public void visitArrayInitializerNodeStart(ArrayInitializerNode node)
    {
    }

    /**
     * Starts a visit for nodes of type UnaryOperatorNode.
     * @param node The node being visited.
     */
    public void visitUnaryOperatorNodeStart(UnaryOperatorNode node)
    {
    }

    /**
     * Starts a visit for nodes of type ArrayAccessNode.
     * @param node The node being visited.
     */
    public void visitArrayAccessNodeStart(ArrayAccessNode node)
    {
    }

    /**
     * Starts a visit for nodes of type CompoundAssignmentNode.
     * @param node The node being visited.
     */
    public void visitCompoundAssignmentNodeStart(CompoundAssignmentNode node)
    {
    }

    /**
     * Starts a visit for nodes of type MethodInvocationNode.
     * @param node The node being visited.
     */
    public void visitMethodInvocationNodeStart(MethodInvocationNode node)
    {
    }

    /**
     * Starts a visit for nodes of type TypeCastNode.
     * @param node The node being visited.
     */
    public void visitTypeCastNodeStart(TypeCastNode node)
    {
    }

    /**
     * Starts a visit for nodes of type AnnotationNode.
     * @param node The node being visited.
     */
    public void visitAnnotationNodeStart(AnnotationNode node)
    {
    }

    /**
     * Starts a visit for nodes of type EnumBodyNode.
     * @param node The node being visited.
     */
    public void visitEnumBodyNodeStart(EnumBodyNode node)
    {
    }

    /**
     * Starts a visit for nodes of type MethodDeclarationNode.
     * @param node The node being visited.
     */
    public void visitMethodDeclarationNodeStart(MethodDeclarationNode node)
    {
    }

    /**
     * Starts a visit for nodes of type TypeParameterNode.
     * @param node The node being visited.
     */
    public void visitTypeParameterNodeStart(TypeParameterNode node)
    {
    }

    /**
     * Starts a visit for nodes of type ModifiersNode.
     * @param node The node being visited.
     */
    public void visitModifiersNodeStart(ModifiersNode node)
    {
    }

    /**
     * Starts a visit for nodes of type InitializerDeclarationNode.
     * @param node The node being visited.
     */
    public void visitInitializerDeclarationNodeStart(InitializerDeclarationNode node)
    {
    }

    /**
     * Starts a visit for nodes of type AnnotationBodyNode.
     * @param node The node being visited.
     */
    public void visitAnnotationBodyNodeStart(AnnotationBodyNode node)
    {
    }

    /**
     * Starts a visit for nodes of type ClassBodyNode.
     * @param node The node being visited.
     */
    public void visitClassBodyNodeStart(ClassBodyNode node)
    {
    }

    /**
     * Starts a visit for nodes of type WildcardTypeNode.
     * @param node The node being visited.
     */
    public void visitWildcardTypeNodeStart(WildcardTypeNode node)
    {
    }

    /**
     * Starts a visit for nodes of type CatchNode.
     * @param node The node being visited.
     */
    public void visitCatchNodeStart(CatchNode node)
    {
    }

    /**
     * Starts a visit for nodes of type CaseNode.
     * @param node The node being visited.
     */
    public void visitCaseNodeStart(CaseNode node)
    {
    }

    /**
     * Starts a visit for nodes of type CompilationUnitNode.
     * @param node The node being visited.
     */
    public void visitCompilationUnitNodeStart(CompilationUnitNode node)
    {
    }

    /**
     * Starts a visit for nodes of type ImportNode.
     * @param node The node being visited.
     */
    public void visitImportNodeStart(ImportNode node)
    {
    }

    /**
     * Starts a visit for nodes of type VariableNode.
     * @param node The node being visited.
     */
    public void visitVariableNodeStart(VariableNode node)
    {
    }

    /**
     * Starts a visit for nodes of type PackageDeclarationNode.
     * @param node The node being visited.
     */
    public void visitPackageDeclarationNodeStart(PackageDeclarationNode node)
    {
    }

    /**
     * Starts a visit for nodes of type EnumConstantDeclarationNode.
     * @param node The node being visited.
     */
    public void visitEnumConstantDeclarationNodeStart(EnumConstantDeclarationNode node)
    {
    }

    /**
     * Starts a visit for nodes of type ListNode.
     * @param node The node being visited.
     */
    public void visitListNodeStart(ListNode<?> node)
    {
    }

    /**
     * Starts a visit for nodes of type ConstructorDeclarationNode.
     * @param node The node being visited.
     */
    public void visitConstructorDeclarationNodeStart(ConstructorDeclarationNode node)
    {
    }

    /**
     * Starts a visit for nodes of type FieldDeclarationNode.
     * @param node The node being visited.
     */
    public void visitFieldDeclarationNodeStart(FieldDeclarationNode node)
    {
    }

    /**
     * Starts a visit for nodes of type InterfaceBodyNode.
     * @param node The node being visited.
     */
    public void visitInterfaceBodyNodeStart(InterfaceBodyNode node)
    {
    }

    /**
     * Starts a visit for nodes of type AnnotationMethodDeclarationNode.
     * @param node The node being visited.
     */
    public void visitAnnotationMethodDeclarationNodeStart(AnnotationMethodDeclarationNode node)
    {
    }

    /**
     * Stops a visit for nodes of type BooleanLiteralNode.
     * @param node The node being visited.
     */
    public void visitBooleanLiteralNodeStop(BooleanLiteralNode node)
    {
    }

    /**
     * Stops a visit for nodes of type FloatLiteralNode.
     * @param node The node being visited.
     */
    public void visitFloatLiteralNodeStop(FloatLiteralNode node)
    {
    }

    /**
     * Stops a visit for nodes of type LongLiteralNode.
     * @param node The node being visited.
     */
    public void visitLongLiteralNodeStop(LongLiteralNode node)
    {
    }

    /**
     * Stops a visit for nodes of type IntLiteralNode.
     * @param node The node being visited.
     */
    public void visitIntLiteralNodeStop(IntLiteralNode node)
    {
    }

    /**
     * Stops a visit for nodes of type StringLiteralNode.
     * @param node The node being visited.
     */
    public void visitStringLiteralNodeStop(StringLiteralNode node)
    {
    }

    /**
     * Stops a visit for nodes of type DoubleLiteralNode.
     * @param node The node being visited.
     */
    public void visitDoubleLiteralNodeStop(DoubleLiteralNode node)
    {
    }

    /**
     * Stops a visit for nodes of type CharLiteralNode.
     * @param node The node being visited.
     */
    public void visitCharLiteralNodeStop(CharLiteralNode node)
    {
    }

    /**
     * Stops a visit for nodes of type CodeLiteralNode.
     * @param node The node being visited.
     */
    public void visitCodeLiteralNodeStop(CodeLiteralNode node)
    {
    }

    /**
     * Stops a visit for nodes of type QualifiedNameNode.
     * @param node The node being visited.
     */
    public void visitQualifiedNameNodeStop(QualifiedNameNode node)
    {
    }

    /**
     * Stops a visit for nodes of type IdentifierNode.
     * @param node The node being visited.
     */
    public void visitIdentifierNodeStop(IdentifierNode node)
    {
    }

    /**
     * Stops a visit for nodes of type PrimitiveTypeNode.
     * @param node The node being visited.
     */
    public void visitPrimitiveTypeNodeStop(PrimitiveTypeNode node)
    {
    }

    /**
     * Stops a visit for nodes of type DeclaredTypeNode.
     * @param node The node being visited.
     */
    public void visitDeclaredTypeNodeStop(DeclaredTypeNode node)
    {
    }

    /**
     * Stops a visit for nodes of type ParameterizedTypeNode.
     * @param node The node being visited.
     */
    public void visitParameterizedTypeNodeStop(ParameterizedTypeNode node)
    {
    }

    /**
     * Stops a visit for nodes of type ArrayTypeNode.
     * @param node The node being visited.
     */
    public void visitArrayTypeNodeStop(ArrayTypeNode node)
    {
    }

    /**
     * Stops a visit for nodes of type SwitchNode.
     * @param node The node being visited.
     */
    public void visitSwitchNodeStop(SwitchNode node)
    {
    }

    /**
     * Stops a visit for nodes of type VariableDeclarationNode.
     * @param node The node being visited.
     */
    public void visitVariableDeclarationNodeStop(VariableDeclarationNode node)
    {
    }

    /**
     * Stops a visit for nodes of type IfNode.
     * @param node The node being visited.
     */
    public void visitIfNodeStop(IfNode node)
    {
    }

    /**
     * Stops a visit for nodes of type ContinueNode.
     * @param node The node being visited.
     */
    public void visitContinueNodeStop(ContinueNode node)
    {
    }

    /**
     * Stops a visit for nodes of type ThrowNode.
     * @param node The node being visited.
     */
    public void visitThrowNodeStop(ThrowNode node)
    {
    }

    /**
     * Stops a visit for nodes of type BreakNode.
     * @param node The node being visited.
     */
    public void visitBreakNodeStop(BreakNode node)
    {
    }

    /**
     * Stops a visit for nodes of type ForLoopNode.
     * @param node The node being visited.
     */
    public void visitForLoopNodeStop(ForLoopNode node)
    {
    }

    /**
     * Stops a visit for nodes of type WhileLoopNode.
     * @param node The node being visited.
     */
    public void visitWhileLoopNodeStop(WhileLoopNode node)
    {
    }

    /**
     * Stops a visit for nodes of type BlockStatementNode.
     * @param node The node being visited.
     */
    public void visitBlockStatementNodeStop(BlockStatementNode node)
    {
    }

    /**
     * Stops a visit for nodes of type LabeledStatementNode.
     * @param node The node being visited.
     */
    public void visitLabeledStatementNodeStop(LabeledStatementNode node)
    {
    }

    /**
     * Stops a visit for nodes of type EnhancedForLoopNode.
     * @param node The node being visited.
     */
    public void visitEnhancedForLoopNodeStop(EnhancedForLoopNode node)
    {
    }

    /**
     * Stops a visit for nodes of type ExpressionStatementNode.
     * @param node The node being visited.
     */
    public void visitExpressionStatementNodeStop(ExpressionStatementNode node)
    {
    }

    /**
     * Stops a visit for nodes of type TryNode.
     * @param node The node being visited.
     */
    public void visitTryNodeStop(TryNode node)
    {
    }

    /**
     * Stops a visit for nodes of type DoWhileLoopNode.
     * @param node The node being visited.
     */
    public void visitDoWhileLoopNodeStop(DoWhileLoopNode node)
    {
    }

    /**
     * Stops a visit for nodes of type EnumDeclarationNode.
     * @param node The node being visited.
     */
    public void visitEnumDeclarationNodeStop(EnumDeclarationNode node)
    {
    }

    /**
     * Stops a visit for nodes of type InterfaceDeclarationNode.
     * @param node The node being visited.
     */
    public void visitInterfaceDeclarationNodeStop(InterfaceDeclarationNode node)
    {
    }

    /**
     * Stops a visit for nodes of type ClassDeclarationNode.
     * @param node The node being visited.
     */
    public void visitClassDeclarationNodeStop(ClassDeclarationNode node)
    {
    }

    /**
     * Stops a visit for nodes of type AnnotationDeclarationNode.
     * @param node The node being visited.
     */
    public void visitAnnotationDeclarationNodeStop(AnnotationDeclarationNode node)
    {
    }

    /**
     * Stops a visit for nodes of type BinaryOperatorNode.
     * @param node The node being visited.
     */
    public void visitBinaryOperatorNodeStop(BinaryOperatorNode node)
    {
    }

    /**
     * Stops a visit for nodes of type MemberSelectNode.
     * @param node The node being visited.
     */
    public void visitMemberSelectNodeStop(MemberSelectNode node)
    {
    }

    /**
     * Stops a visit for nodes of type ArrayInstantiatonNode.
     * @param node The node being visited.
     */
    public void visitArrayInstantiatonNodeStop(ArrayInstantiatonNode node)
    {
    }

    /**
     * Stops a visit for nodes of type ConditionalExpressionNode.
     * @param node The node being visited.
     */
    public void visitConditionalExpressionNodeStop(ConditionalExpressionNode node)
    {
    }

    /**
     * Stops a visit for nodes of type InstanceOfNode.
     * @param node The node being visited.
     */
    public void visitInstanceOfNodeStop(InstanceOfNode node)
    {
    }

    /**
     * Stops a visit for nodes of type AssignmentNode.
     * @param node The node being visited.
     */
    public void visitAssignmentNodeStop(AssignmentNode node)
    {
    }

    /**
     * Stops a visit for nodes of type ClassInstantiationNode.
     * @param node The node being visited.
     */
    public void visitClassInstantiationNodeStop(ClassInstantiationNode node)
    {
    }

    /**
     * Stops a visit for nodes of type ArrayInitializerNode.
     * @param node The node being visited.
     */
    public void visitArrayInitializerNodeStop(ArrayInitializerNode node)
    {
    }

    /**
     * Stops a visit for nodes of type UnaryOperatorNode.
     * @param node The node being visited.
     */
    public void visitUnaryOperatorNodeStop(UnaryOperatorNode node)
    {
    }

    /**
     * Stops a visit for nodes of type ArrayAccessNode.
     * @param node The node being visited.
     */
    public void visitArrayAccessNodeStop(ArrayAccessNode node)
    {
    }

    /**
     * Stops a visit for nodes of type CompoundAssignmentNode.
     * @param node The node being visited.
     */
    public void visitCompoundAssignmentNodeStop(CompoundAssignmentNode node)
    {
    }

    /**
     * Stops a visit for nodes of type MethodInvocationNode.
     * @param node The node being visited.
     */
    public void visitMethodInvocationNodeStop(MethodInvocationNode node)
    {
    }

    /**
     * Stops a visit for nodes of type TypeCastNode.
     * @param node The node being visited.
     */
    public void visitTypeCastNodeStop(TypeCastNode node)
    {
    }

    /**
     * Stops a visit for nodes of type AnnotationNode.
     * @param node The node being visited.
     */
    public void visitAnnotationNodeStop(AnnotationNode node)
    {
    }

    /**
     * Stops a visit for nodes of type EnumBodyNode.
     * @param node The node being visited.
     */
    public void visitEnumBodyNodeStop(EnumBodyNode node)
    {
    }

    /**
     * Stops a visit for nodes of type MethodDeclarationNode.
     * @param node The node being visited.
     */
    public void visitMethodDeclarationNodeStop(MethodDeclarationNode node)
    {
    }

    /**
     * Stops a visit for nodes of type TypeParameterNode.
     * @param node The node being visited.
     */
    public void visitTypeParameterNodeStop(TypeParameterNode node)
    {
    }

    /**
     * Stops a visit for nodes of type ModifiersNode.
     * @param node The node being visited.
     */
    public void visitModifiersNodeStop(ModifiersNode node)
    {
    }

    /**
     * Stops a visit for nodes of type InitializerDeclarationNode.
     * @param node The node being visited.
     */
    public void visitInitializerDeclarationNodeStop(InitializerDeclarationNode node)
    {
    }

    /**
     * Stops a visit for nodes of type AnnotationBodyNode.
     * @param node The node being visited.
     */
    public void visitAnnotationBodyNodeStop(AnnotationBodyNode node)
    {
    }

    /**
     * Stops a visit for nodes of type ClassBodyNode.
     * @param node The node being visited.
     */
    public void visitClassBodyNodeStop(ClassBodyNode node)
    {
    }

    /**
     * Stops a visit for nodes of type WildcardTypeNode.
     * @param node The node being visited.
     */
    public void visitWildcardTypeNodeStop(WildcardTypeNode node)
    {
    }

    /**
     * Stops a visit for nodes of type CatchNode.
     * @param node The node being visited.
     */
    public void visitCatchNodeStop(CatchNode node)
    {
    }

    /**
     * Stops a visit for nodes of type CaseNode.
     * @param node The node being visited.
     */
    public void visitCaseNodeStop(CaseNode node)
    {
    }

    /**
     * Stops a visit for nodes of type CompilationUnitNode.
     * @param node The node being visited.
     */
    public void visitCompilationUnitNodeStop(CompilationUnitNode node)
    {
    }

    /**
     * Stops a visit for nodes of type ImportNode.
     * @param node The node being visited.
     */
    public void visitImportNodeStop(ImportNode node)
    {
    }

    /**
     * Stops a visit for nodes of type VariableNode.
     * @param node The node being visited.
     */
    public void visitVariableNodeStop(VariableNode node)
    {
    }

    /**
     * Stops a visit for nodes of type PackageDeclarationNode.
     * @param node The node being visited.
     */
    public void visitPackageDeclarationNodeStop(PackageDeclarationNode node)
    {
    }

    /**
     * Stops a visit for nodes of type EnumConstantDeclarationNode.
     * @param node The node being visited.
     */
    public void visitEnumConstantDeclarationNodeStop(EnumConstantDeclarationNode node)
    {
    }

    /**
     * Stops a visit for nodes of type ListNode.
     * @param node The node being visited.
     */
    public void visitListNodeStop(ListNode<?> node)
    {
    }

    /**
     * Stops a visit for nodes of type ConstructorDeclarationNode.
     * @param node The node being visited.
     */
    public void visitConstructorDeclarationNodeStop(ConstructorDeclarationNode node)
    {
    }

    /**
     * Stops a visit for nodes of type FieldDeclarationNode.
     * @param node The node being visited.
     */
    public void visitFieldDeclarationNodeStop(FieldDeclarationNode node)
    {
    }

    /**
     * Stops a visit for nodes of type InterfaceBodyNode.
     * @param node The node being visited.
     */
    public void visitInterfaceBodyNodeStop(InterfaceBodyNode node)
    {
    }

    /**
     * Stops a visit for nodes of type AnnotationMethodDeclarationNode.
     * @param node The node being visited.
     */
    public void visitAnnotationMethodDeclarationNodeStop(AnnotationMethodDeclarationNode node)
    {
    }

}
