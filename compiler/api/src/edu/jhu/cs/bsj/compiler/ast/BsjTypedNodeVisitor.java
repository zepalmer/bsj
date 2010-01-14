package edu.jhu.cs.bsj.compiler.ast;

import edu.jhu.cs.bsj.compiler.ast.node.AlternateConstructorInvocationNode;
import edu.jhu.cs.bsj.compiler.ast.node.AnnotationAnnotationValueNode;
import edu.jhu.cs.bsj.compiler.ast.node.AnnotationArrayValueNode;
import edu.jhu.cs.bsj.compiler.ast.node.AnnotationBodyNode;
import edu.jhu.cs.bsj.compiler.ast.node.AnnotationDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.AnnotationElementNode;
import edu.jhu.cs.bsj.compiler.ast.node.AnnotationExpressionValueNode;
import edu.jhu.cs.bsj.compiler.ast.node.AnnotationMethodDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.AnonymousClassBodyNode;
import edu.jhu.cs.bsj.compiler.ast.node.ArrayAccessNode;
import edu.jhu.cs.bsj.compiler.ast.node.ArrayInitializerCreationNode;
import edu.jhu.cs.bsj.compiler.ast.node.ArrayInitializerNode;
import edu.jhu.cs.bsj.compiler.ast.node.ArrayInstantiatorCreationNode;
import edu.jhu.cs.bsj.compiler.ast.node.ArrayTypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.AssertStatementNode;
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
import edu.jhu.cs.bsj.compiler.ast.node.ClassLiteralNode;
import edu.jhu.cs.bsj.compiler.ast.node.CompilationUnitNode;
import edu.jhu.cs.bsj.compiler.ast.node.ConditionalExpressionNode;
import edu.jhu.cs.bsj.compiler.ast.node.ConstructorBodyNode;
import edu.jhu.cs.bsj.compiler.ast.node.ConstructorDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.ContinueNode;
import edu.jhu.cs.bsj.compiler.ast.node.DoWhileLoopNode;
import edu.jhu.cs.bsj.compiler.ast.node.DoubleLiteralNode;
import edu.jhu.cs.bsj.compiler.ast.node.EnhancedForLoopNode;
import edu.jhu.cs.bsj.compiler.ast.node.EnumBodyNode;
import edu.jhu.cs.bsj.compiler.ast.node.EnumConstantDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.EnumDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.ExpressionStatementNode;
import edu.jhu.cs.bsj.compiler.ast.node.FieldAccessByExpressionNode;
import edu.jhu.cs.bsj.compiler.ast.node.FieldAccessByNameNode;
import edu.jhu.cs.bsj.compiler.ast.node.FieldDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.FloatLiteralNode;
import edu.jhu.cs.bsj.compiler.ast.node.ForInitializerDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.ForInitializerExpressionNode;
import edu.jhu.cs.bsj.compiler.ast.node.ForLoopNode;
import edu.jhu.cs.bsj.compiler.ast.node.IdentifierNode;
import edu.jhu.cs.bsj.compiler.ast.node.IfNode;
import edu.jhu.cs.bsj.compiler.ast.node.ImportOnDemandNode;
import edu.jhu.cs.bsj.compiler.ast.node.ImportSingleTypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.InitializerDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.InlineTypeDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.InstanceOfNode;
import edu.jhu.cs.bsj.compiler.ast.node.IntLiteralNode;
import edu.jhu.cs.bsj.compiler.ast.node.InterfaceBodyNode;
import edu.jhu.cs.bsj.compiler.ast.node.InterfaceDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.LabeledStatementNode;
import edu.jhu.cs.bsj.compiler.ast.node.ListNode;
import edu.jhu.cs.bsj.compiler.ast.node.LongLiteralNode;
import edu.jhu.cs.bsj.compiler.ast.node.MethodDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.MethodInvocationByExpressionNode;
import edu.jhu.cs.bsj.compiler.ast.node.MethodInvocationByNameNode;
import edu.jhu.cs.bsj.compiler.ast.node.ModifiersNode;
import edu.jhu.cs.bsj.compiler.ast.node.NameExpressionNode;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.NormalAnnotationNode;
import edu.jhu.cs.bsj.compiler.ast.node.NullLiteralNode;
import edu.jhu.cs.bsj.compiler.ast.node.PackageDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.ParameterizedTypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.ParameterizedTypeSelectNode;
import edu.jhu.cs.bsj.compiler.ast.node.ParenthesizedExpressionNode;
import edu.jhu.cs.bsj.compiler.ast.node.PrimitiveTypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.QualifiedClassInstantiationNode;
import edu.jhu.cs.bsj.compiler.ast.node.QualifiedNameNode;
import edu.jhu.cs.bsj.compiler.ast.node.RawTypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.ReturnNode;
import edu.jhu.cs.bsj.compiler.ast.node.SimpleNameNode;
import edu.jhu.cs.bsj.compiler.ast.node.SingleElementAnnotationNode;
import edu.jhu.cs.bsj.compiler.ast.node.StringLiteralNode;
import edu.jhu.cs.bsj.compiler.ast.node.SuperFieldAccessNode;
import edu.jhu.cs.bsj.compiler.ast.node.SuperMethodInvocationNode;
import edu.jhu.cs.bsj.compiler.ast.node.SuperclassConstructorInvocationNode;
import edu.jhu.cs.bsj.compiler.ast.node.SwitchNode;
import edu.jhu.cs.bsj.compiler.ast.node.SynchronizedNode;
import edu.jhu.cs.bsj.compiler.ast.node.ThisNode;
import edu.jhu.cs.bsj.compiler.ast.node.ThrowNode;
import edu.jhu.cs.bsj.compiler.ast.node.TryNode;
import edu.jhu.cs.bsj.compiler.ast.node.TypeCastNode;
import edu.jhu.cs.bsj.compiler.ast.node.TypeParameterNode;
import edu.jhu.cs.bsj.compiler.ast.node.UnaryOperatorNode;
import edu.jhu.cs.bsj.compiler.ast.node.UnqualifiedClassInstantiationNode;
import edu.jhu.cs.bsj.compiler.ast.node.VariableDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.VariableDeclaratorNode;
import edu.jhu.cs.bsj.compiler.ast.node.VariableNode;
import edu.jhu.cs.bsj.compiler.ast.node.VoidStatementNode;
import edu.jhu.cs.bsj.compiler.ast.node.VoidTypeDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.VoidTypeNode;
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
        if (node instanceof QualifiedNameNode)
        {
            visitQualifiedNameNodeStart((QualifiedNameNode)node);
        } else if (node instanceof SimpleNameNode)
        {
            visitSimpleNameNodeStart((SimpleNameNode)node);
        } else if (node instanceof ArrayInitializerCreationNode)
        {
            visitArrayInitializerCreationNodeStart((ArrayInitializerCreationNode)node);
        } else if (node instanceof ArrayInstantiatorCreationNode)
        {
            visitArrayInstantiatorCreationNodeStart((ArrayInstantiatorCreationNode)node);
        } else if (node instanceof SuperclassConstructorInvocationNode)
        {
            visitSuperclassConstructorInvocationNodeStart((SuperclassConstructorInvocationNode)node);
        } else if (node instanceof AlternateConstructorInvocationNode)
        {
            visitAlternateConstructorInvocationNodeStart((AlternateConstructorInvocationNode)node);
        } else if (node instanceof SingleElementAnnotationNode)
        {
            visitSingleElementAnnotationNodeStart((SingleElementAnnotationNode)node);
        } else if (node instanceof NormalAnnotationNode)
        {
            visitNormalAnnotationNodeStart((NormalAnnotationNode)node);
        } else if (node instanceof UnqualifiedClassInstantiationNode)
        {
            visitUnqualifiedClassInstantiationNodeStart((UnqualifiedClassInstantiationNode)node);
        } else if (node instanceof QualifiedClassInstantiationNode)
        {
            visitQualifiedClassInstantiationNodeStart((QualifiedClassInstantiationNode)node);
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
        } else if (node instanceof BooleanLiteralNode)
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
        } else if (node instanceof NullLiteralNode)
        {
            visitNullLiteralNodeStart((NullLiteralNode)node);
        } else if (node instanceof StringLiteralNode)
        {
            visitStringLiteralNodeStart((StringLiteralNode)node);
        } else if (node instanceof ClassLiteralNode)
        {
            visitClassLiteralNodeStart((ClassLiteralNode)node);
        } else if (node instanceof DoubleLiteralNode)
        {
            visitDoubleLiteralNodeStart((DoubleLiteralNode)node);
        } else if (node instanceof CharLiteralNode)
        {
            visitCharLiteralNodeStart((CharLiteralNode)node);
        } else if (node instanceof CodeLiteralNode)
        {
            visitCodeLiteralNodeStart((CodeLiteralNode)node);
        } else if (node instanceof MethodInvocationByExpressionNode)
        {
            visitMethodInvocationByExpressionNodeStart((MethodInvocationByExpressionNode)node);
        } else if (node instanceof MethodInvocationByNameNode)
        {
            visitMethodInvocationByNameNodeStart((MethodInvocationByNameNode)node);
        } else if (node instanceof MethodDeclarationNode)
        {
            visitMethodDeclarationNodeStart((MethodDeclarationNode)node);
        } else if (node instanceof ClassBodyNode)
        {
            visitClassBodyNodeStart((ClassBodyNode)node);
        } else if (node instanceof IfNode)
        {
            visitIfNodeStart((IfNode)node);
        } else if (node instanceof ConstructorBodyNode)
        {
            visitConstructorBodyNodeStart((ConstructorBodyNode)node);
        } else if (node instanceof FieldAccessByNameNode)
        {
            visitFieldAccessByNameNodeStart((FieldAccessByNameNode)node);
        } else if (node instanceof RawTypeNode)
        {
            visitRawTypeNodeStart((RawTypeNode)node);
        } else if (node instanceof ForInitializerDeclarationNode)
        {
            visitForInitializerDeclarationNodeStart((ForInitializerDeclarationNode)node);
        } else if (node instanceof ParameterizedTypeNode)
        {
            visitParameterizedTypeNodeStart((ParameterizedTypeNode)node);
        } else if (node instanceof BinaryOperatorNode)
        {
            visitBinaryOperatorNodeStart((BinaryOperatorNode)node);
        } else if (node instanceof ParenthesizedExpressionNode)
        {
            visitParenthesizedExpressionNodeStart((ParenthesizedExpressionNode)node);
        } else if (node instanceof ConditionalExpressionNode)
        {
            visitConditionalExpressionNodeStart((ConditionalExpressionNode)node);
        } else if (node instanceof InstanceOfNode)
        {
            visitInstanceOfNodeStart((InstanceOfNode)node);
        } else if (node instanceof AssignmentNode)
        {
            visitAssignmentNodeStart((AssignmentNode)node);
        } else if (node instanceof ReturnNode)
        {
            visitReturnNodeStart((ReturnNode)node);
        } else if (node instanceof AnnotationExpressionValueNode)
        {
            visitAnnotationExpressionValueNodeStart((AnnotationExpressionValueNode)node);
        } else if (node instanceof ArrayInitializerNode)
        {
            visitArrayInitializerNodeStart((ArrayInitializerNode)node);
        } else if (node instanceof SuperMethodInvocationNode)
        {
            visitSuperMethodInvocationNodeStart((SuperMethodInvocationNode)node);
        } else if (node instanceof AnnotationArrayValueNode)
        {
            visitAnnotationArrayValueNodeStart((AnnotationArrayValueNode)node);
        } else if (node instanceof ImportSingleTypeNode)
        {
            visitImportSingleTypeNodeStart((ImportSingleTypeNode)node);
        } else if (node instanceof FieldDeclarationNode)
        {
            visitFieldDeclarationNodeStart((FieldDeclarationNode)node);
        } else if (node instanceof AnnotationMethodDeclarationNode)
        {
            visitAnnotationMethodDeclarationNodeStart((AnnotationMethodDeclarationNode)node);
        } else if (node instanceof TypeParameterNode)
        {
            visitTypeParameterNodeStart((TypeParameterNode)node);
        } else if (node instanceof ArrayTypeNode)
        {
            visitArrayTypeNodeStart((ArrayTypeNode)node);
        } else if (node instanceof IdentifierNode)
        {
            visitIdentifierNodeStart((IdentifierNode)node);
        } else if (node instanceof ParameterizedTypeSelectNode)
        {
            visitParameterizedTypeSelectNodeStart((ParameterizedTypeSelectNode)node);
        } else if (node instanceof BreakNode)
        {
            visitBreakNodeStart((BreakNode)node);
        } else if (node instanceof ListNode<?>)
        {
            visitListNodeStart((ListNode<?>)node);
        } else if (node instanceof EnumConstantDeclarationNode)
        {
            visitEnumConstantDeclarationNodeStart((EnumConstantDeclarationNode)node);
        } else if (node instanceof WhileLoopNode)
        {
            visitWhileLoopNodeStart((WhileLoopNode)node);
        } else if (node instanceof ForLoopNode)
        {
            visitForLoopNodeStart((ForLoopNode)node);
        } else if (node instanceof AnnotationAnnotationValueNode)
        {
            visitAnnotationAnnotationValueNodeStart((AnnotationAnnotationValueNode)node);
        } else if (node instanceof ConstructorDeclarationNode)
        {
            visitConstructorDeclarationNodeStart((ConstructorDeclarationNode)node);
        } else if (node instanceof SwitchNode)
        {
            visitSwitchNodeStart((SwitchNode)node);
        } else if (node instanceof InlineTypeDeclarationNode)
        {
            visitInlineTypeDeclarationNodeStart((InlineTypeDeclarationNode)node);
        } else if (node instanceof WildcardTypeNode)
        {
            visitWildcardTypeNodeStart((WildcardTypeNode)node);
        } else if (node instanceof VariableNode)
        {
            visitVariableNodeStart((VariableNode)node);
        } else if (node instanceof SynchronizedNode)
        {
            visitSynchronizedNodeStart((SynchronizedNode)node);
        } else if (node instanceof UnaryOperatorNode)
        {
            visitUnaryOperatorNodeStart((UnaryOperatorNode)node);
        } else if (node instanceof AnonymousClassBodyNode)
        {
            visitAnonymousClassBodyNodeStart((AnonymousClassBodyNode)node);
        } else if (node instanceof AnnotationElementNode)
        {
            visitAnnotationElementNodeStart((AnnotationElementNode)node);
        } else if (node instanceof ContinueNode)
        {
            visitContinueNodeStart((ContinueNode)node);
        } else if (node instanceof CompilationUnitNode)
        {
            visitCompilationUnitNodeStart((CompilationUnitNode)node);
        } else if (node instanceof PackageDeclarationNode)
        {
            visitPackageDeclarationNodeStart((PackageDeclarationNode)node);
        } else if (node instanceof ForInitializerExpressionNode)
        {
            visitForInitializerExpressionNodeStart((ForInitializerExpressionNode)node);
        } else if (node instanceof BlockStatementNode)
        {
            visitBlockStatementNodeStart((BlockStatementNode)node);
        } else if (node instanceof LabeledStatementNode)
        {
            visitLabeledStatementNodeStart((LabeledStatementNode)node);
        } else if (node instanceof TypeCastNode)
        {
            visitTypeCastNodeStart((TypeCastNode)node);
        } else if (node instanceof DoWhileLoopNode)
        {
            visitDoWhileLoopNodeStart((DoWhileLoopNode)node);
        } else if (node instanceof VoidTypeDeclarationNode)
        {
            visitVoidTypeDeclarationNodeStart((VoidTypeDeclarationNode)node);
        } else if (node instanceof CatchNode)
        {
            visitCatchNodeStart((CatchNode)node);
        } else if (node instanceof NameExpressionNode)
        {
            visitNameExpressionNodeStart((NameExpressionNode)node);
        } else if (node instanceof ThrowNode)
        {
            visitThrowNodeStart((ThrowNode)node);
        } else if (node instanceof SuperFieldAccessNode)
        {
            visitSuperFieldAccessNodeStart((SuperFieldAccessNode)node);
        } else if (node instanceof FieldAccessByExpressionNode)
        {
            visitFieldAccessByExpressionNodeStart((FieldAccessByExpressionNode)node);
        } else if (node instanceof VariableDeclaratorNode)
        {
            visitVariableDeclaratorNodeStart((VariableDeclaratorNode)node);
        } else if (node instanceof AnnotationBodyNode)
        {
            visitAnnotationBodyNodeStart((AnnotationBodyNode)node);
        } else if (node instanceof VariableDeclarationNode)
        {
            visitVariableDeclarationNodeStart((VariableDeclarationNode)node);
        } else if (node instanceof VoidTypeNode)
        {
            visitVoidTypeNodeStart((VoidTypeNode)node);
        } else if (node instanceof ThisNode)
        {
            visitThisNodeStart((ThisNode)node);
        } else if (node instanceof TryNode)
        {
            visitTryNodeStart((TryNode)node);
        } else if (node instanceof EnumBodyNode)
        {
            visitEnumBodyNodeStart((EnumBodyNode)node);
        } else if (node instanceof ModifiersNode)
        {
            visitModifiersNodeStart((ModifiersNode)node);
        } else if (node instanceof InitializerDeclarationNode)
        {
            visitInitializerDeclarationNodeStart((InitializerDeclarationNode)node);
        } else if (node instanceof PrimitiveTypeNode)
        {
            visitPrimitiveTypeNodeStart((PrimitiveTypeNode)node);
        } else if (node instanceof ImportOnDemandNode)
        {
            visitImportOnDemandNodeStart((ImportOnDemandNode)node);
        } else if (node instanceof CaseNode)
        {
            visitCaseNodeStart((CaseNode)node);
        } else if (node instanceof VoidStatementNode)
        {
            visitVoidStatementNodeStart((VoidStatementNode)node);
        } else if (node instanceof ArrayAccessNode)
        {
            visitArrayAccessNodeStart((ArrayAccessNode)node);
        } else if (node instanceof EnhancedForLoopNode)
        {
            visitEnhancedForLoopNodeStart((EnhancedForLoopNode)node);
        } else if (node instanceof InterfaceBodyNode)
        {
            visitInterfaceBodyNodeStart((InterfaceBodyNode)node);
        } else if (node instanceof ExpressionStatementNode)
        {
            visitExpressionStatementNodeStart((ExpressionStatementNode)node);
        } else if (node instanceof AssertStatementNode)
        {
            visitAssertStatementNodeStart((AssertStatementNode)node);
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
        if (node instanceof QualifiedNameNode)
        {
            visitQualifiedNameNodeStop((QualifiedNameNode)node);
        } else if (node instanceof SimpleNameNode)
        {
            visitSimpleNameNodeStop((SimpleNameNode)node);
        } else if (node instanceof ArrayInitializerCreationNode)
        {
            visitArrayInitializerCreationNodeStop((ArrayInitializerCreationNode)node);
        } else if (node instanceof ArrayInstantiatorCreationNode)
        {
            visitArrayInstantiatorCreationNodeStop((ArrayInstantiatorCreationNode)node);
        } else if (node instanceof SuperclassConstructorInvocationNode)
        {
            visitSuperclassConstructorInvocationNodeStop((SuperclassConstructorInvocationNode)node);
        } else if (node instanceof AlternateConstructorInvocationNode)
        {
            visitAlternateConstructorInvocationNodeStop((AlternateConstructorInvocationNode)node);
        } else if (node instanceof SingleElementAnnotationNode)
        {
            visitSingleElementAnnotationNodeStop((SingleElementAnnotationNode)node);
        } else if (node instanceof NormalAnnotationNode)
        {
            visitNormalAnnotationNodeStop((NormalAnnotationNode)node);
        } else if (node instanceof UnqualifiedClassInstantiationNode)
        {
            visitUnqualifiedClassInstantiationNodeStop((UnqualifiedClassInstantiationNode)node);
        } else if (node instanceof QualifiedClassInstantiationNode)
        {
            visitQualifiedClassInstantiationNodeStop((QualifiedClassInstantiationNode)node);
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
        } else if (node instanceof BooleanLiteralNode)
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
        } else if (node instanceof NullLiteralNode)
        {
            visitNullLiteralNodeStop((NullLiteralNode)node);
        } else if (node instanceof StringLiteralNode)
        {
            visitStringLiteralNodeStop((StringLiteralNode)node);
        } else if (node instanceof ClassLiteralNode)
        {
            visitClassLiteralNodeStop((ClassLiteralNode)node);
        } else if (node instanceof DoubleLiteralNode)
        {
            visitDoubleLiteralNodeStop((DoubleLiteralNode)node);
        } else if (node instanceof CharLiteralNode)
        {
            visitCharLiteralNodeStop((CharLiteralNode)node);
        } else if (node instanceof CodeLiteralNode)
        {
            visitCodeLiteralNodeStop((CodeLiteralNode)node);
        } else if (node instanceof MethodInvocationByExpressionNode)
        {
            visitMethodInvocationByExpressionNodeStop((MethodInvocationByExpressionNode)node);
        } else if (node instanceof MethodInvocationByNameNode)
        {
            visitMethodInvocationByNameNodeStop((MethodInvocationByNameNode)node);
        } else if (node instanceof MethodDeclarationNode)
        {
            visitMethodDeclarationNodeStop((MethodDeclarationNode)node);
        } else if (node instanceof ClassBodyNode)
        {
            visitClassBodyNodeStop((ClassBodyNode)node);
        } else if (node instanceof IfNode)
        {
            visitIfNodeStop((IfNode)node);
        } else if (node instanceof ConstructorBodyNode)
        {
            visitConstructorBodyNodeStop((ConstructorBodyNode)node);
        } else if (node instanceof FieldAccessByNameNode)
        {
            visitFieldAccessByNameNodeStop((FieldAccessByNameNode)node);
        } else if (node instanceof RawTypeNode)
        {
            visitRawTypeNodeStop((RawTypeNode)node);
        } else if (node instanceof ForInitializerDeclarationNode)
        {
            visitForInitializerDeclarationNodeStop((ForInitializerDeclarationNode)node);
        } else if (node instanceof ParameterizedTypeNode)
        {
            visitParameterizedTypeNodeStop((ParameterizedTypeNode)node);
        } else if (node instanceof BinaryOperatorNode)
        {
            visitBinaryOperatorNodeStop((BinaryOperatorNode)node);
        } else if (node instanceof ParenthesizedExpressionNode)
        {
            visitParenthesizedExpressionNodeStop((ParenthesizedExpressionNode)node);
        } else if (node instanceof ConditionalExpressionNode)
        {
            visitConditionalExpressionNodeStop((ConditionalExpressionNode)node);
        } else if (node instanceof InstanceOfNode)
        {
            visitInstanceOfNodeStop((InstanceOfNode)node);
        } else if (node instanceof AssignmentNode)
        {
            visitAssignmentNodeStop((AssignmentNode)node);
        } else if (node instanceof ReturnNode)
        {
            visitReturnNodeStop((ReturnNode)node);
        } else if (node instanceof AnnotationExpressionValueNode)
        {
            visitAnnotationExpressionValueNodeStop((AnnotationExpressionValueNode)node);
        } else if (node instanceof ArrayInitializerNode)
        {
            visitArrayInitializerNodeStop((ArrayInitializerNode)node);
        } else if (node instanceof SuperMethodInvocationNode)
        {
            visitSuperMethodInvocationNodeStop((SuperMethodInvocationNode)node);
        } else if (node instanceof AnnotationArrayValueNode)
        {
            visitAnnotationArrayValueNodeStop((AnnotationArrayValueNode)node);
        } else if (node instanceof ImportSingleTypeNode)
        {
            visitImportSingleTypeNodeStop((ImportSingleTypeNode)node);
        } else if (node instanceof FieldDeclarationNode)
        {
            visitFieldDeclarationNodeStop((FieldDeclarationNode)node);
        } else if (node instanceof AnnotationMethodDeclarationNode)
        {
            visitAnnotationMethodDeclarationNodeStop((AnnotationMethodDeclarationNode)node);
        } else if (node instanceof TypeParameterNode)
        {
            visitTypeParameterNodeStop((TypeParameterNode)node);
        } else if (node instanceof ArrayTypeNode)
        {
            visitArrayTypeNodeStop((ArrayTypeNode)node);
        } else if (node instanceof IdentifierNode)
        {
            visitIdentifierNodeStop((IdentifierNode)node);
        } else if (node instanceof ParameterizedTypeSelectNode)
        {
            visitParameterizedTypeSelectNodeStop((ParameterizedTypeSelectNode)node);
        } else if (node instanceof BreakNode)
        {
            visitBreakNodeStop((BreakNode)node);
        } else if (node instanceof ListNode<?>)
        {
            visitListNodeStop((ListNode<?>)node);
        } else if (node instanceof EnumConstantDeclarationNode)
        {
            visitEnumConstantDeclarationNodeStop((EnumConstantDeclarationNode)node);
        } else if (node instanceof WhileLoopNode)
        {
            visitWhileLoopNodeStop((WhileLoopNode)node);
        } else if (node instanceof ForLoopNode)
        {
            visitForLoopNodeStop((ForLoopNode)node);
        } else if (node instanceof AnnotationAnnotationValueNode)
        {
            visitAnnotationAnnotationValueNodeStop((AnnotationAnnotationValueNode)node);
        } else if (node instanceof ConstructorDeclarationNode)
        {
            visitConstructorDeclarationNodeStop((ConstructorDeclarationNode)node);
        } else if (node instanceof SwitchNode)
        {
            visitSwitchNodeStop((SwitchNode)node);
        } else if (node instanceof InlineTypeDeclarationNode)
        {
            visitInlineTypeDeclarationNodeStop((InlineTypeDeclarationNode)node);
        } else if (node instanceof WildcardTypeNode)
        {
            visitWildcardTypeNodeStop((WildcardTypeNode)node);
        } else if (node instanceof VariableNode)
        {
            visitVariableNodeStop((VariableNode)node);
        } else if (node instanceof SynchronizedNode)
        {
            visitSynchronizedNodeStop((SynchronizedNode)node);
        } else if (node instanceof UnaryOperatorNode)
        {
            visitUnaryOperatorNodeStop((UnaryOperatorNode)node);
        } else if (node instanceof AnonymousClassBodyNode)
        {
            visitAnonymousClassBodyNodeStop((AnonymousClassBodyNode)node);
        } else if (node instanceof AnnotationElementNode)
        {
            visitAnnotationElementNodeStop((AnnotationElementNode)node);
        } else if (node instanceof ContinueNode)
        {
            visitContinueNodeStop((ContinueNode)node);
        } else if (node instanceof CompilationUnitNode)
        {
            visitCompilationUnitNodeStop((CompilationUnitNode)node);
        } else if (node instanceof PackageDeclarationNode)
        {
            visitPackageDeclarationNodeStop((PackageDeclarationNode)node);
        } else if (node instanceof ForInitializerExpressionNode)
        {
            visitForInitializerExpressionNodeStop((ForInitializerExpressionNode)node);
        } else if (node instanceof BlockStatementNode)
        {
            visitBlockStatementNodeStop((BlockStatementNode)node);
        } else if (node instanceof LabeledStatementNode)
        {
            visitLabeledStatementNodeStop((LabeledStatementNode)node);
        } else if (node instanceof TypeCastNode)
        {
            visitTypeCastNodeStop((TypeCastNode)node);
        } else if (node instanceof DoWhileLoopNode)
        {
            visitDoWhileLoopNodeStop((DoWhileLoopNode)node);
        } else if (node instanceof VoidTypeDeclarationNode)
        {
            visitVoidTypeDeclarationNodeStop((VoidTypeDeclarationNode)node);
        } else if (node instanceof CatchNode)
        {
            visitCatchNodeStop((CatchNode)node);
        } else if (node instanceof NameExpressionNode)
        {
            visitNameExpressionNodeStop((NameExpressionNode)node);
        } else if (node instanceof ThrowNode)
        {
            visitThrowNodeStop((ThrowNode)node);
        } else if (node instanceof SuperFieldAccessNode)
        {
            visitSuperFieldAccessNodeStop((SuperFieldAccessNode)node);
        } else if (node instanceof FieldAccessByExpressionNode)
        {
            visitFieldAccessByExpressionNodeStop((FieldAccessByExpressionNode)node);
        } else if (node instanceof VariableDeclaratorNode)
        {
            visitVariableDeclaratorNodeStop((VariableDeclaratorNode)node);
        } else if (node instanceof AnnotationBodyNode)
        {
            visitAnnotationBodyNodeStop((AnnotationBodyNode)node);
        } else if (node instanceof VariableDeclarationNode)
        {
            visitVariableDeclarationNodeStop((VariableDeclarationNode)node);
        } else if (node instanceof VoidTypeNode)
        {
            visitVoidTypeNodeStop((VoidTypeNode)node);
        } else if (node instanceof ThisNode)
        {
            visitThisNodeStop((ThisNode)node);
        } else if (node instanceof TryNode)
        {
            visitTryNodeStop((TryNode)node);
        } else if (node instanceof EnumBodyNode)
        {
            visitEnumBodyNodeStop((EnumBodyNode)node);
        } else if (node instanceof ModifiersNode)
        {
            visitModifiersNodeStop((ModifiersNode)node);
        } else if (node instanceof InitializerDeclarationNode)
        {
            visitInitializerDeclarationNodeStop((InitializerDeclarationNode)node);
        } else if (node instanceof PrimitiveTypeNode)
        {
            visitPrimitiveTypeNodeStop((PrimitiveTypeNode)node);
        } else if (node instanceof ImportOnDemandNode)
        {
            visitImportOnDemandNodeStop((ImportOnDemandNode)node);
        } else if (node instanceof CaseNode)
        {
            visitCaseNodeStop((CaseNode)node);
        } else if (node instanceof VoidStatementNode)
        {
            visitVoidStatementNodeStop((VoidStatementNode)node);
        } else if (node instanceof ArrayAccessNode)
        {
            visitArrayAccessNodeStop((ArrayAccessNode)node);
        } else if (node instanceof EnhancedForLoopNode)
        {
            visitEnhancedForLoopNodeStop((EnhancedForLoopNode)node);
        } else if (node instanceof InterfaceBodyNode)
        {
            visitInterfaceBodyNodeStop((InterfaceBodyNode)node);
        } else if (node instanceof ExpressionStatementNode)
        {
            visitExpressionStatementNodeStop((ExpressionStatementNode)node);
        } else if (node instanceof AssertStatementNode)
        {
            visitAssertStatementNodeStop((AssertStatementNode)node);
        } else
        {
            throw new IllegalStateException("Unrecognized node type " + node.getClass());
        }
    }

    /**
     * Starts a visit for nodes of type QualifiedNameNode.
     * @param node The node being visited.
     */
    public void visitQualifiedNameNodeStart(QualifiedNameNode node)
    {
    }

    /**
     * Starts a visit for nodes of type SimpleNameNode.
     * @param node The node being visited.
     */
    public void visitSimpleNameNodeStart(SimpleNameNode node)
    {
    }

    /**
     * Starts a visit for nodes of type ArrayInitializerCreationNode.
     * @param node The node being visited.
     */
    public void visitArrayInitializerCreationNodeStart(ArrayInitializerCreationNode node)
    {
    }

    /**
     * Starts a visit for nodes of type ArrayInstantiatorCreationNode.
     * @param node The node being visited.
     */
    public void visitArrayInstantiatorCreationNodeStart(ArrayInstantiatorCreationNode node)
    {
    }

    /**
     * Starts a visit for nodes of type SuperclassConstructorInvocationNode.
     * @param node The node being visited.
     */
    public void visitSuperclassConstructorInvocationNodeStart(SuperclassConstructorInvocationNode node)
    {
    }

    /**
     * Starts a visit for nodes of type AlternateConstructorInvocationNode.
     * @param node The node being visited.
     */
    public void visitAlternateConstructorInvocationNodeStart(AlternateConstructorInvocationNode node)
    {
    }

    /**
     * Starts a visit for nodes of type SingleElementAnnotationNode.
     * @param node The node being visited.
     */
    public void visitSingleElementAnnotationNodeStart(SingleElementAnnotationNode node)
    {
    }

    /**
     * Starts a visit for nodes of type NormalAnnotationNode.
     * @param node The node being visited.
     */
    public void visitNormalAnnotationNodeStart(NormalAnnotationNode node)
    {
    }

    /**
     * Starts a visit for nodes of type UnqualifiedClassInstantiationNode.
     * @param node The node being visited.
     */
    public void visitUnqualifiedClassInstantiationNodeStart(UnqualifiedClassInstantiationNode node)
    {
    }

    /**
     * Starts a visit for nodes of type QualifiedClassInstantiationNode.
     * @param node The node being visited.
     */
    public void visitQualifiedClassInstantiationNodeStart(QualifiedClassInstantiationNode node)
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
     * Starts a visit for nodes of type NullLiteralNode.
     * @param node The node being visited.
     */
    public void visitNullLiteralNodeStart(NullLiteralNode node)
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
     * Starts a visit for nodes of type ClassLiteralNode.
     * @param node The node being visited.
     */
    public void visitClassLiteralNodeStart(ClassLiteralNode node)
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
     * Starts a visit for nodes of type MethodInvocationByExpressionNode.
     * @param node The node being visited.
     */
    public void visitMethodInvocationByExpressionNodeStart(MethodInvocationByExpressionNode node)
    {
    }

    /**
     * Starts a visit for nodes of type MethodInvocationByNameNode.
     * @param node The node being visited.
     */
    public void visitMethodInvocationByNameNodeStart(MethodInvocationByNameNode node)
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
     * Starts a visit for nodes of type ClassBodyNode.
     * @param node The node being visited.
     */
    public void visitClassBodyNodeStart(ClassBodyNode node)
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
     * Starts a visit for nodes of type ConstructorBodyNode.
     * @param node The node being visited.
     */
    public void visitConstructorBodyNodeStart(ConstructorBodyNode node)
    {
    }

    /**
     * Starts a visit for nodes of type FieldAccessByNameNode.
     * @param node The node being visited.
     */
    public void visitFieldAccessByNameNodeStart(FieldAccessByNameNode node)
    {
    }

    /**
     * Starts a visit for nodes of type RawTypeNode.
     * @param node The node being visited.
     */
    public void visitRawTypeNodeStart(RawTypeNode node)
    {
    }

    /**
     * Starts a visit for nodes of type ForInitializerDeclarationNode.
     * @param node The node being visited.
     */
    public void visitForInitializerDeclarationNodeStart(ForInitializerDeclarationNode node)
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
     * Starts a visit for nodes of type BinaryOperatorNode.
     * @param node The node being visited.
     */
    public void visitBinaryOperatorNodeStart(BinaryOperatorNode node)
    {
    }

    /**
     * Starts a visit for nodes of type ParenthesizedExpressionNode.
     * @param node The node being visited.
     */
    public void visitParenthesizedExpressionNodeStart(ParenthesizedExpressionNode node)
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
     * Starts a visit for nodes of type ReturnNode.
     * @param node The node being visited.
     */
    public void visitReturnNodeStart(ReturnNode node)
    {
    }

    /**
     * Starts a visit for nodes of type AnnotationExpressionValueNode.
     * @param node The node being visited.
     */
    public void visitAnnotationExpressionValueNodeStart(AnnotationExpressionValueNode node)
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
     * Starts a visit for nodes of type SuperMethodInvocationNode.
     * @param node The node being visited.
     */
    public void visitSuperMethodInvocationNodeStart(SuperMethodInvocationNode node)
    {
    }

    /**
     * Starts a visit for nodes of type AnnotationArrayValueNode.
     * @param node The node being visited.
     */
    public void visitAnnotationArrayValueNodeStart(AnnotationArrayValueNode node)
    {
    }

    /**
     * Starts a visit for nodes of type ImportSingleTypeNode.
     * @param node The node being visited.
     */
    public void visitImportSingleTypeNodeStart(ImportSingleTypeNode node)
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
     * Starts a visit for nodes of type AnnotationMethodDeclarationNode.
     * @param node The node being visited.
     */
    public void visitAnnotationMethodDeclarationNodeStart(AnnotationMethodDeclarationNode node)
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
     * Starts a visit for nodes of type ArrayTypeNode.
     * @param node The node being visited.
     */
    public void visitArrayTypeNodeStart(ArrayTypeNode node)
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
     * Starts a visit for nodes of type ParameterizedTypeSelectNode.
     * @param node The node being visited.
     */
    public void visitParameterizedTypeSelectNodeStart(ParameterizedTypeSelectNode node)
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
     * Starts a visit for nodes of type ListNode.
     * @param node The node being visited.
     */
    public void visitListNodeStart(ListNode<?> node)
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
     * Starts a visit for nodes of type WhileLoopNode.
     * @param node The node being visited.
     */
    public void visitWhileLoopNodeStart(WhileLoopNode node)
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
     * Starts a visit for nodes of type AnnotationAnnotationValueNode.
     * @param node The node being visited.
     */
    public void visitAnnotationAnnotationValueNodeStart(AnnotationAnnotationValueNode node)
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
     * Starts a visit for nodes of type SwitchNode.
     * @param node The node being visited.
     */
    public void visitSwitchNodeStart(SwitchNode node)
    {
    }

    /**
     * Starts a visit for nodes of type InlineTypeDeclarationNode.
     * @param node The node being visited.
     */
    public void visitInlineTypeDeclarationNodeStart(InlineTypeDeclarationNode node)
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
     * Starts a visit for nodes of type VariableNode.
     * @param node The node being visited.
     */
    public void visitVariableNodeStart(VariableNode node)
    {
    }

    /**
     * Starts a visit for nodes of type SynchronizedNode.
     * @param node The node being visited.
     */
    public void visitSynchronizedNodeStart(SynchronizedNode node)
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
     * Starts a visit for nodes of type AnonymousClassBodyNode.
     * @param node The node being visited.
     */
    public void visitAnonymousClassBodyNodeStart(AnonymousClassBodyNode node)
    {
    }

    /**
     * Starts a visit for nodes of type AnnotationElementNode.
     * @param node The node being visited.
     */
    public void visitAnnotationElementNodeStart(AnnotationElementNode node)
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
     * Starts a visit for nodes of type CompilationUnitNode.
     * @param node The node being visited.
     */
    public void visitCompilationUnitNodeStart(CompilationUnitNode node)
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
     * Starts a visit for nodes of type ForInitializerExpressionNode.
     * @param node The node being visited.
     */
    public void visitForInitializerExpressionNodeStart(ForInitializerExpressionNode node)
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
     * Starts a visit for nodes of type TypeCastNode.
     * @param node The node being visited.
     */
    public void visitTypeCastNodeStart(TypeCastNode node)
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
     * Starts a visit for nodes of type VoidTypeDeclarationNode.
     * @param node The node being visited.
     */
    public void visitVoidTypeDeclarationNodeStart(VoidTypeDeclarationNode node)
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
     * Starts a visit for nodes of type NameExpressionNode.
     * @param node The node being visited.
     */
    public void visitNameExpressionNodeStart(NameExpressionNode node)
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
     * Starts a visit for nodes of type SuperFieldAccessNode.
     * @param node The node being visited.
     */
    public void visitSuperFieldAccessNodeStart(SuperFieldAccessNode node)
    {
    }

    /**
     * Starts a visit for nodes of type FieldAccessByExpressionNode.
     * @param node The node being visited.
     */
    public void visitFieldAccessByExpressionNodeStart(FieldAccessByExpressionNode node)
    {
    }

    /**
     * Starts a visit for nodes of type VariableDeclaratorNode.
     * @param node The node being visited.
     */
    public void visitVariableDeclaratorNodeStart(VariableDeclaratorNode node)
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
     * Starts a visit for nodes of type VariableDeclarationNode.
     * @param node The node being visited.
     */
    public void visitVariableDeclarationNodeStart(VariableDeclarationNode node)
    {
    }

    /**
     * Starts a visit for nodes of type VoidTypeNode.
     * @param node The node being visited.
     */
    public void visitVoidTypeNodeStart(VoidTypeNode node)
    {
    }

    /**
     * Starts a visit for nodes of type ThisNode.
     * @param node The node being visited.
     */
    public void visitThisNodeStart(ThisNode node)
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
     * Starts a visit for nodes of type EnumBodyNode.
     * @param node The node being visited.
     */
    public void visitEnumBodyNodeStart(EnumBodyNode node)
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
     * Starts a visit for nodes of type PrimitiveTypeNode.
     * @param node The node being visited.
     */
    public void visitPrimitiveTypeNodeStart(PrimitiveTypeNode node)
    {
    }

    /**
     * Starts a visit for nodes of type ImportOnDemandNode.
     * @param node The node being visited.
     */
    public void visitImportOnDemandNodeStart(ImportOnDemandNode node)
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
     * Starts a visit for nodes of type VoidStatementNode.
     * @param node The node being visited.
     */
    public void visitVoidStatementNodeStart(VoidStatementNode node)
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
     * Starts a visit for nodes of type EnhancedForLoopNode.
     * @param node The node being visited.
     */
    public void visitEnhancedForLoopNodeStart(EnhancedForLoopNode node)
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
     * Starts a visit for nodes of type ExpressionStatementNode.
     * @param node The node being visited.
     */
    public void visitExpressionStatementNodeStart(ExpressionStatementNode node)
    {
    }

    /**
     * Starts a visit for nodes of type AssertStatementNode.
     * @param node The node being visited.
     */
    public void visitAssertStatementNodeStart(AssertStatementNode node)
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
     * Stops a visit for nodes of type SimpleNameNode.
     * @param node The node being visited.
     */
    public void visitSimpleNameNodeStop(SimpleNameNode node)
    {
    }

    /**
     * Stops a visit for nodes of type ArrayInitializerCreationNode.
     * @param node The node being visited.
     */
    public void visitArrayInitializerCreationNodeStop(ArrayInitializerCreationNode node)
    {
    }

    /**
     * Stops a visit for nodes of type ArrayInstantiatorCreationNode.
     * @param node The node being visited.
     */
    public void visitArrayInstantiatorCreationNodeStop(ArrayInstantiatorCreationNode node)
    {
    }

    /**
     * Stops a visit for nodes of type SuperclassConstructorInvocationNode.
     * @param node The node being visited.
     */
    public void visitSuperclassConstructorInvocationNodeStop(SuperclassConstructorInvocationNode node)
    {
    }

    /**
     * Stops a visit for nodes of type AlternateConstructorInvocationNode.
     * @param node The node being visited.
     */
    public void visitAlternateConstructorInvocationNodeStop(AlternateConstructorInvocationNode node)
    {
    }

    /**
     * Stops a visit for nodes of type SingleElementAnnotationNode.
     * @param node The node being visited.
     */
    public void visitSingleElementAnnotationNodeStop(SingleElementAnnotationNode node)
    {
    }

    /**
     * Stops a visit for nodes of type NormalAnnotationNode.
     * @param node The node being visited.
     */
    public void visitNormalAnnotationNodeStop(NormalAnnotationNode node)
    {
    }

    /**
     * Stops a visit for nodes of type UnqualifiedClassInstantiationNode.
     * @param node The node being visited.
     */
    public void visitUnqualifiedClassInstantiationNodeStop(UnqualifiedClassInstantiationNode node)
    {
    }

    /**
     * Stops a visit for nodes of type QualifiedClassInstantiationNode.
     * @param node The node being visited.
     */
    public void visitQualifiedClassInstantiationNodeStop(QualifiedClassInstantiationNode node)
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
     * Stops a visit for nodes of type NullLiteralNode.
     * @param node The node being visited.
     */
    public void visitNullLiteralNodeStop(NullLiteralNode node)
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
     * Stops a visit for nodes of type ClassLiteralNode.
     * @param node The node being visited.
     */
    public void visitClassLiteralNodeStop(ClassLiteralNode node)
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
     * Stops a visit for nodes of type MethodInvocationByExpressionNode.
     * @param node The node being visited.
     */
    public void visitMethodInvocationByExpressionNodeStop(MethodInvocationByExpressionNode node)
    {
    }

    /**
     * Stops a visit for nodes of type MethodInvocationByNameNode.
     * @param node The node being visited.
     */
    public void visitMethodInvocationByNameNodeStop(MethodInvocationByNameNode node)
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
     * Stops a visit for nodes of type ClassBodyNode.
     * @param node The node being visited.
     */
    public void visitClassBodyNodeStop(ClassBodyNode node)
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
     * Stops a visit for nodes of type ConstructorBodyNode.
     * @param node The node being visited.
     */
    public void visitConstructorBodyNodeStop(ConstructorBodyNode node)
    {
    }

    /**
     * Stops a visit for nodes of type FieldAccessByNameNode.
     * @param node The node being visited.
     */
    public void visitFieldAccessByNameNodeStop(FieldAccessByNameNode node)
    {
    }

    /**
     * Stops a visit for nodes of type RawTypeNode.
     * @param node The node being visited.
     */
    public void visitRawTypeNodeStop(RawTypeNode node)
    {
    }

    /**
     * Stops a visit for nodes of type ForInitializerDeclarationNode.
     * @param node The node being visited.
     */
    public void visitForInitializerDeclarationNodeStop(ForInitializerDeclarationNode node)
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
     * Stops a visit for nodes of type BinaryOperatorNode.
     * @param node The node being visited.
     */
    public void visitBinaryOperatorNodeStop(BinaryOperatorNode node)
    {
    }

    /**
     * Stops a visit for nodes of type ParenthesizedExpressionNode.
     * @param node The node being visited.
     */
    public void visitParenthesizedExpressionNodeStop(ParenthesizedExpressionNode node)
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
     * Stops a visit for nodes of type ReturnNode.
     * @param node The node being visited.
     */
    public void visitReturnNodeStop(ReturnNode node)
    {
    }

    /**
     * Stops a visit for nodes of type AnnotationExpressionValueNode.
     * @param node The node being visited.
     */
    public void visitAnnotationExpressionValueNodeStop(AnnotationExpressionValueNode node)
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
     * Stops a visit for nodes of type SuperMethodInvocationNode.
     * @param node The node being visited.
     */
    public void visitSuperMethodInvocationNodeStop(SuperMethodInvocationNode node)
    {
    }

    /**
     * Stops a visit for nodes of type AnnotationArrayValueNode.
     * @param node The node being visited.
     */
    public void visitAnnotationArrayValueNodeStop(AnnotationArrayValueNode node)
    {
    }

    /**
     * Stops a visit for nodes of type ImportSingleTypeNode.
     * @param node The node being visited.
     */
    public void visitImportSingleTypeNodeStop(ImportSingleTypeNode node)
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
     * Stops a visit for nodes of type AnnotationMethodDeclarationNode.
     * @param node The node being visited.
     */
    public void visitAnnotationMethodDeclarationNodeStop(AnnotationMethodDeclarationNode node)
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
     * Stops a visit for nodes of type ArrayTypeNode.
     * @param node The node being visited.
     */
    public void visitArrayTypeNodeStop(ArrayTypeNode node)
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
     * Stops a visit for nodes of type ParameterizedTypeSelectNode.
     * @param node The node being visited.
     */
    public void visitParameterizedTypeSelectNodeStop(ParameterizedTypeSelectNode node)
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
     * Stops a visit for nodes of type ListNode.
     * @param node The node being visited.
     */
    public void visitListNodeStop(ListNode<?> node)
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
     * Stops a visit for nodes of type WhileLoopNode.
     * @param node The node being visited.
     */
    public void visitWhileLoopNodeStop(WhileLoopNode node)
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
     * Stops a visit for nodes of type AnnotationAnnotationValueNode.
     * @param node The node being visited.
     */
    public void visitAnnotationAnnotationValueNodeStop(AnnotationAnnotationValueNode node)
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
     * Stops a visit for nodes of type SwitchNode.
     * @param node The node being visited.
     */
    public void visitSwitchNodeStop(SwitchNode node)
    {
    }

    /**
     * Stops a visit for nodes of type InlineTypeDeclarationNode.
     * @param node The node being visited.
     */
    public void visitInlineTypeDeclarationNodeStop(InlineTypeDeclarationNode node)
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
     * Stops a visit for nodes of type VariableNode.
     * @param node The node being visited.
     */
    public void visitVariableNodeStop(VariableNode node)
    {
    }

    /**
     * Stops a visit for nodes of type SynchronizedNode.
     * @param node The node being visited.
     */
    public void visitSynchronizedNodeStop(SynchronizedNode node)
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
     * Stops a visit for nodes of type AnonymousClassBodyNode.
     * @param node The node being visited.
     */
    public void visitAnonymousClassBodyNodeStop(AnonymousClassBodyNode node)
    {
    }

    /**
     * Stops a visit for nodes of type AnnotationElementNode.
     * @param node The node being visited.
     */
    public void visitAnnotationElementNodeStop(AnnotationElementNode node)
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
     * Stops a visit for nodes of type CompilationUnitNode.
     * @param node The node being visited.
     */
    public void visitCompilationUnitNodeStop(CompilationUnitNode node)
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
     * Stops a visit for nodes of type ForInitializerExpressionNode.
     * @param node The node being visited.
     */
    public void visitForInitializerExpressionNodeStop(ForInitializerExpressionNode node)
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
     * Stops a visit for nodes of type TypeCastNode.
     * @param node The node being visited.
     */
    public void visitTypeCastNodeStop(TypeCastNode node)
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
     * Stops a visit for nodes of type VoidTypeDeclarationNode.
     * @param node The node being visited.
     */
    public void visitVoidTypeDeclarationNodeStop(VoidTypeDeclarationNode node)
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
     * Stops a visit for nodes of type NameExpressionNode.
     * @param node The node being visited.
     */
    public void visitNameExpressionNodeStop(NameExpressionNode node)
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
     * Stops a visit for nodes of type SuperFieldAccessNode.
     * @param node The node being visited.
     */
    public void visitSuperFieldAccessNodeStop(SuperFieldAccessNode node)
    {
    }

    /**
     * Stops a visit for nodes of type FieldAccessByExpressionNode.
     * @param node The node being visited.
     */
    public void visitFieldAccessByExpressionNodeStop(FieldAccessByExpressionNode node)
    {
    }

    /**
     * Stops a visit for nodes of type VariableDeclaratorNode.
     * @param node The node being visited.
     */
    public void visitVariableDeclaratorNodeStop(VariableDeclaratorNode node)
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
     * Stops a visit for nodes of type VariableDeclarationNode.
     * @param node The node being visited.
     */
    public void visitVariableDeclarationNodeStop(VariableDeclarationNode node)
    {
    }

    /**
     * Stops a visit for nodes of type VoidTypeNode.
     * @param node The node being visited.
     */
    public void visitVoidTypeNodeStop(VoidTypeNode node)
    {
    }

    /**
     * Stops a visit for nodes of type ThisNode.
     * @param node The node being visited.
     */
    public void visitThisNodeStop(ThisNode node)
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
     * Stops a visit for nodes of type EnumBodyNode.
     * @param node The node being visited.
     */
    public void visitEnumBodyNodeStop(EnumBodyNode node)
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
     * Stops a visit for nodes of type PrimitiveTypeNode.
     * @param node The node being visited.
     */
    public void visitPrimitiveTypeNodeStop(PrimitiveTypeNode node)
    {
    }

    /**
     * Stops a visit for nodes of type ImportOnDemandNode.
     * @param node The node being visited.
     */
    public void visitImportOnDemandNodeStop(ImportOnDemandNode node)
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
     * Stops a visit for nodes of type VoidStatementNode.
     * @param node The node being visited.
     */
    public void visitVoidStatementNodeStop(VoidStatementNode node)
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
     * Stops a visit for nodes of type EnhancedForLoopNode.
     * @param node The node being visited.
     */
    public void visitEnhancedForLoopNodeStop(EnhancedForLoopNode node)
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
     * Stops a visit for nodes of type ExpressionStatementNode.
     * @param node The node being visited.
     */
    public void visitExpressionStatementNodeStop(ExpressionStatementNode node)
    {
    }

    /**
     * Stops a visit for nodes of type AssertStatementNode.
     * @param node The node being visited.
     */
    public void visitAssertStatementNodeStop(AssertStatementNode node)
    {
    }

}
