package edu.jhu.cs.bsj.compiler.ast;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.node.*;
import edu.jhu.cs.bsj.compiler.ast.node.meta.BlockStatementMetaprogramAnchorNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.CodeLiteralNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.TypeDeclarationMetaprogramAnchorNode;

/**
 * This interface specifies an operation to be carried out on a node.  The purpose of this
 * mechanism is effectively to allow the addition of operations to the node hierarchy
 * requiring that the hierarchy itself be modified.  Note that while this interface is
 * similar to that of the visitor pattern (see {@link BsjNodeVisitor}), it does not function
 * the same way.  This mechanism does not abstract node traversal; the implementation is
 * required to do that itself if it wishes to walk the tree.
 *
 * @param <P> A parameter type for all methods to accept.  If no return type is desired, use
 * {@link java.lang.Void}.
 * @param <R> A return type for all methods to return.  If no return type is desired, use
 * {@link java.lang.Void}.
 *
 * @author Zachary Palmer
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface BsjNodeOperation<P,R>
{
    /**
     * Executes this operation against a AlternateConstructorInvocationNode.
     * @param node The AlternateConstructorInvocationNode in question.
     * @param p The parameter to use.
     * @return The result of the operation.
     */
    public R executeAlternateConstructorInvocationNode(AlternateConstructorInvocationNode node, P p);

    /**
     * Executes this operation against a AnnotationAnnotationValueNode.
     * @param node The AnnotationAnnotationValueNode in question.
     * @param p The parameter to use.
     * @return The result of the operation.
     */
    public R executeAnnotationAnnotationValueNode(AnnotationAnnotationValueNode node, P p);

    /**
     * Executes this operation against a AnnotationArrayValueNode.
     * @param node The AnnotationArrayValueNode in question.
     * @param p The parameter to use.
     * @return The result of the operation.
     */
    public R executeAnnotationArrayValueNode(AnnotationArrayValueNode node, P p);

    /**
     * Executes this operation against a AnnotationBodyNode.
     * @param node The AnnotationBodyNode in question.
     * @param p The parameter to use.
     * @return The result of the operation.
     */
    public R executeAnnotationBodyNode(AnnotationBodyNode node, P p);

    /**
     * Executes this operation against a AnnotationDeclarationNode.
     * @param node The AnnotationDeclarationNode in question.
     * @param p The parameter to use.
     * @return The result of the operation.
     */
    public R executeAnnotationDeclarationNode(AnnotationDeclarationNode node, P p);

    /**
     * Executes this operation against a AnnotationElementNode.
     * @param node The AnnotationElementNode in question.
     * @param p The parameter to use.
     * @return The result of the operation.
     */
    public R executeAnnotationElementNode(AnnotationElementNode node, P p);

    /**
     * Executes this operation against a AnnotationExpressionValueNode.
     * @param node The AnnotationExpressionValueNode in question.
     * @param p The parameter to use.
     * @return The result of the operation.
     */
    public R executeAnnotationExpressionValueNode(AnnotationExpressionValueNode node, P p);

    /**
     * Executes this operation against a AnnotationMethodDeclarationNode.
     * @param node The AnnotationMethodDeclarationNode in question.
     * @param p The parameter to use.
     * @return The result of the operation.
     */
    public R executeAnnotationMethodDeclarationNode(AnnotationMethodDeclarationNode node, P p);

    /**
     * Executes this operation against a AnnotationMethodModifiersNode.
     * @param node The AnnotationMethodModifiersNode in question.
     * @param p The parameter to use.
     * @return The result of the operation.
     */
    public R executeAnnotationMethodModifiersNode(AnnotationMethodModifiersNode node, P p);

    /**
     * Executes this operation against a AnnotationModifiersNode.
     * @param node The AnnotationModifiersNode in question.
     * @param p The parameter to use.
     * @return The result of the operation.
     */
    public R executeAnnotationModifiersNode(AnnotationModifiersNode node, P p);

    /**
     * Executes this operation against a AnonymousClassBodyNode.
     * @param node The AnonymousClassBodyNode in question.
     * @param p The parameter to use.
     * @return The result of the operation.
     */
    public R executeAnonymousClassBodyNode(AnonymousClassBodyNode node, P p);

    /**
     * Executes this operation against a ArrayAccessNode.
     * @param node The ArrayAccessNode in question.
     * @param p The parameter to use.
     * @return The result of the operation.
     */
    public R executeArrayAccessNode(ArrayAccessNode node, P p);

    /**
     * Executes this operation against a ArrayInitializerCreationNode.
     * @param node The ArrayInitializerCreationNode in question.
     * @param p The parameter to use.
     * @return The result of the operation.
     */
    public R executeArrayInitializerCreationNode(ArrayInitializerCreationNode node, P p);

    /**
     * Executes this operation against a ArrayInitializerNode.
     * @param node The ArrayInitializerNode in question.
     * @param p The parameter to use.
     * @return The result of the operation.
     */
    public R executeArrayInitializerNode(ArrayInitializerNode node, P p);

    /**
     * Executes this operation against a ArrayInstantiatorCreationNode.
     * @param node The ArrayInstantiatorCreationNode in question.
     * @param p The parameter to use.
     * @return The result of the operation.
     */
    public R executeArrayInstantiatorCreationNode(ArrayInstantiatorCreationNode node, P p);

    /**
     * Executes this operation against a ArrayTypeNode.
     * @param node The ArrayTypeNode in question.
     * @param p The parameter to use.
     * @return The result of the operation.
     */
    public R executeArrayTypeNode(ArrayTypeNode node, P p);

    /**
     * Executes this operation against a AssertStatementNode.
     * @param node The AssertStatementNode in question.
     * @param p The parameter to use.
     * @return The result of the operation.
     */
    public R executeAssertStatementNode(AssertStatementNode node, P p);

    /**
     * Executes this operation against a AssignmentNode.
     * @param node The AssignmentNode in question.
     * @param p The parameter to use.
     * @return The result of the operation.
     */
    public R executeAssignmentNode(AssignmentNode node, P p);

    /**
     * Executes this operation against a BinaryExpressionNode.
     * @param node The BinaryExpressionNode in question.
     * @param p The parameter to use.
     * @return The result of the operation.
     */
    public R executeBinaryExpressionNode(BinaryExpressionNode node, P p);

    /**
     * Executes this operation against a BlockNode.
     * @param node The BlockNode in question.
     * @param p The parameter to use.
     * @return The result of the operation.
     */
    public R executeBlockNode(BlockNode node, P p);

    /**
     * Executes this operation against a BlockStatementMetaprogramAnchorNode.
     * @param node The BlockStatementMetaprogramAnchorNode in question.
     * @param p The parameter to use.
     * @return The result of the operation.
     */
    public R executeBlockStatementMetaprogramAnchorNode(BlockStatementMetaprogramAnchorNode node, P p);

    /**
     * Executes this operation against a BooleanLiteralNode.
     * @param node The BooleanLiteralNode in question.
     * @param p The parameter to use.
     * @return The result of the operation.
     */
    public R executeBooleanLiteralNode(BooleanLiteralNode node, P p);

    /**
     * Executes this operation against a BreakNode.
     * @param node The BreakNode in question.
     * @param p The parameter to use.
     * @return The result of the operation.
     */
    public R executeBreakNode(BreakNode node, P p);

    /**
     * Executes this operation against a CaseNode.
     * @param node The CaseNode in question.
     * @param p The parameter to use.
     * @return The result of the operation.
     */
    public R executeCaseNode(CaseNode node, P p);

    /**
     * Executes this operation against a CatchNode.
     * @param node The CatchNode in question.
     * @param p The parameter to use.
     * @return The result of the operation.
     */
    public R executeCatchNode(CatchNode node, P p);

    /**
     * Executes this operation against a CharLiteralNode.
     * @param node The CharLiteralNode in question.
     * @param p The parameter to use.
     * @return The result of the operation.
     */
    public R executeCharLiteralNode(CharLiteralNode node, P p);

    /**
     * Executes this operation against a ClassBodyNode.
     * @param node The ClassBodyNode in question.
     * @param p The parameter to use.
     * @return The result of the operation.
     */
    public R executeClassBodyNode(ClassBodyNode node, P p);

    /**
     * Executes this operation against a ClassDeclarationNode.
     * @param node The ClassDeclarationNode in question.
     * @param p The parameter to use.
     * @return The result of the operation.
     */
    public R executeClassDeclarationNode(ClassDeclarationNode node, P p);

    /**
     * Executes this operation against a ClassLiteralNode.
     * @param node The ClassLiteralNode in question.
     * @param p The parameter to use.
     * @return The result of the operation.
     */
    public R executeClassLiteralNode(ClassLiteralNode node, P p);

    /**
     * Executes this operation against a ClassModifiersNode.
     * @param node The ClassModifiersNode in question.
     * @param p The parameter to use.
     * @return The result of the operation.
     */
    public R executeClassModifiersNode(ClassModifiersNode node, P p);

    /**
     * Executes this operation against a CodeLiteralNode.
     * @param node The CodeLiteralNode in question.
     * @param p The parameter to use.
     * @return The result of the operation.
     */
    public R executeCodeLiteralNode(CodeLiteralNode node, P p);

    /**
     * Executes this operation against a CompilationUnitNode.
     * @param node The CompilationUnitNode in question.
     * @param p The parameter to use.
     * @return The result of the operation.
     */
    public R executeCompilationUnitNode(CompilationUnitNode node, P p);

    /**
     * Executes this operation against a ConditionalExpressionNode.
     * @param node The ConditionalExpressionNode in question.
     * @param p The parameter to use.
     * @return The result of the operation.
     */
    public R executeConditionalExpressionNode(ConditionalExpressionNode node, P p);

    /**
     * Executes this operation against a ConstructorBodyNode.
     * @param node The ConstructorBodyNode in question.
     * @param p The parameter to use.
     * @return The result of the operation.
     */
    public R executeConstructorBodyNode(ConstructorBodyNode node, P p);

    /**
     * Executes this operation against a ConstructorDeclarationNode.
     * @param node The ConstructorDeclarationNode in question.
     * @param p The parameter to use.
     * @return The result of the operation.
     */
    public R executeConstructorDeclarationNode(ConstructorDeclarationNode node, P p);

    /**
     * Executes this operation against a ConstructorModifiersNode.
     * @param node The ConstructorModifiersNode in question.
     * @param p The parameter to use.
     * @return The result of the operation.
     */
    public R executeConstructorModifiersNode(ConstructorModifiersNode node, P p);

    /**
     * Executes this operation against a ContinueNode.
     * @param node The ContinueNode in question.
     * @param p The parameter to use.
     * @return The result of the operation.
     */
    public R executeContinueNode(ContinueNode node, P p);

    /**
     * Executes this operation against a DoWhileLoopNode.
     * @param node The DoWhileLoopNode in question.
     * @param p The parameter to use.
     * @return The result of the operation.
     */
    public R executeDoWhileLoopNode(DoWhileLoopNode node, P p);

    /**
     * Executes this operation against a DoubleLiteralNode.
     * @param node The DoubleLiteralNode in question.
     * @param p The parameter to use.
     * @return The result of the operation.
     */
    public R executeDoubleLiteralNode(DoubleLiteralNode node, P p);

    /**
     * Executes this operation against a EnhancedForLoopNode.
     * @param node The EnhancedForLoopNode in question.
     * @param p The parameter to use.
     * @return The result of the operation.
     */
    public R executeEnhancedForLoopNode(EnhancedForLoopNode node, P p);

    /**
     * Executes this operation against a EnumBodyNode.
     * @param node The EnumBodyNode in question.
     * @param p The parameter to use.
     * @return The result of the operation.
     */
    public R executeEnumBodyNode(EnumBodyNode node, P p);

    /**
     * Executes this operation against a EnumConstantDeclarationNode.
     * @param node The EnumConstantDeclarationNode in question.
     * @param p The parameter to use.
     * @return The result of the operation.
     */
    public R executeEnumConstantDeclarationNode(EnumConstantDeclarationNode node, P p);

    /**
     * Executes this operation against a EnumDeclarationNode.
     * @param node The EnumDeclarationNode in question.
     * @param p The parameter to use.
     * @return The result of the operation.
     */
    public R executeEnumDeclarationNode(EnumDeclarationNode node, P p);

    /**
     * Executes this operation against a EnumModifiersNode.
     * @param node The EnumModifiersNode in question.
     * @param p The parameter to use.
     * @return The result of the operation.
     */
    public R executeEnumModifiersNode(EnumModifiersNode node, P p);

    /**
     * Executes this operation against a ExpressionStatementNode.
     * @param node The ExpressionStatementNode in question.
     * @param p The parameter to use.
     * @return The result of the operation.
     */
    public R executeExpressionStatementNode(ExpressionStatementNode node, P p);

    /**
     * Executes this operation against a FieldAccessByExpressionNode.
     * @param node The FieldAccessByExpressionNode in question.
     * @param p The parameter to use.
     * @return The result of the operation.
     */
    public R executeFieldAccessByExpressionNode(FieldAccessByExpressionNode node, P p);

    /**
     * Executes this operation against a FieldAccessByNameNode.
     * @param node The FieldAccessByNameNode in question.
     * @param p The parameter to use.
     * @return The result of the operation.
     */
    public R executeFieldAccessByNameNode(FieldAccessByNameNode node, P p);

    /**
     * Executes this operation against a FieldDeclarationNode.
     * @param node The FieldDeclarationNode in question.
     * @param p The parameter to use.
     * @return The result of the operation.
     */
    public R executeFieldDeclarationNode(FieldDeclarationNode node, P p);

    /**
     * Executes this operation against a FieldModifiersNode.
     * @param node The FieldModifiersNode in question.
     * @param p The parameter to use.
     * @return The result of the operation.
     */
    public R executeFieldModifiersNode(FieldModifiersNode node, P p);

    /**
     * Executes this operation against a FloatLiteralNode.
     * @param node The FloatLiteralNode in question.
     * @param p The parameter to use.
     * @return The result of the operation.
     */
    public R executeFloatLiteralNode(FloatLiteralNode node, P p);

    /**
     * Executes this operation against a ForInitializerDeclarationNode.
     * @param node The ForInitializerDeclarationNode in question.
     * @param p The parameter to use.
     * @return The result of the operation.
     */
    public R executeForInitializerDeclarationNode(ForInitializerDeclarationNode node, P p);

    /**
     * Executes this operation against a ForInitializerExpressionNode.
     * @param node The ForInitializerExpressionNode in question.
     * @param p The parameter to use.
     * @return The result of the operation.
     */
    public R executeForInitializerExpressionNode(ForInitializerExpressionNode node, P p);

    /**
     * Executes this operation against a ForLoopNode.
     * @param node The ForLoopNode in question.
     * @param p The parameter to use.
     * @return The result of the operation.
     */
    public R executeForLoopNode(ForLoopNode node, P p);

    /**
     * Executes this operation against a IdentifierNode.
     * @param node The IdentifierNode in question.
     * @param p The parameter to use.
     * @return The result of the operation.
     */
    public R executeIdentifierNode(IdentifierNode node, P p);

    /**
     * Executes this operation against a IfNode.
     * @param node The IfNode in question.
     * @param p The parameter to use.
     * @return The result of the operation.
     */
    public R executeIfNode(IfNode node, P p);

    /**
     * Executes this operation against a ImportOnDemandNode.
     * @param node The ImportOnDemandNode in question.
     * @param p The parameter to use.
     * @return The result of the operation.
     */
    public R executeImportOnDemandNode(ImportOnDemandNode node, P p);

    /**
     * Executes this operation against a ImportSingleTypeNode.
     * @param node The ImportSingleTypeNode in question.
     * @param p The parameter to use.
     * @return The result of the operation.
     */
    public R executeImportSingleTypeNode(ImportSingleTypeNode node, P p);

    /**
     * Executes this operation against a InitializerDeclarationNode.
     * @param node The InitializerDeclarationNode in question.
     * @param p The parameter to use.
     * @return The result of the operation.
     */
    public R executeInitializerDeclarationNode(InitializerDeclarationNode node, P p);

    /**
     * Executes this operation against a InlineTypeDeclarationNode.
     * @param node The InlineTypeDeclarationNode in question.
     * @param p The parameter to use.
     * @return The result of the operation.
     */
    public R executeInlineTypeDeclarationNode(InlineTypeDeclarationNode node, P p);

    /**
     * Executes this operation against a InstanceOfNode.
     * @param node The InstanceOfNode in question.
     * @param p The parameter to use.
     * @return The result of the operation.
     */
    public R executeInstanceOfNode(InstanceOfNode node, P p);

    /**
     * Executes this operation against a IntLiteralNode.
     * @param node The IntLiteralNode in question.
     * @param p The parameter to use.
     * @return The result of the operation.
     */
    public R executeIntLiteralNode(IntLiteralNode node, P p);

    /**
     * Executes this operation against a InterfaceBodyNode.
     * @param node The InterfaceBodyNode in question.
     * @param p The parameter to use.
     * @return The result of the operation.
     */
    public R executeInterfaceBodyNode(InterfaceBodyNode node, P p);

    /**
     * Executes this operation against a InterfaceDeclarationNode.
     * @param node The InterfaceDeclarationNode in question.
     * @param p The parameter to use.
     * @return The result of the operation.
     */
    public R executeInterfaceDeclarationNode(InterfaceDeclarationNode node, P p);

    /**
     * Executes this operation against a InterfaceModifiersNode.
     * @param node The InterfaceModifiersNode in question.
     * @param p The parameter to use.
     * @return The result of the operation.
     */
    public R executeInterfaceModifiersNode(InterfaceModifiersNode node, P p);

    /**
     * Executes this operation against a JavadocNode.
     * @param node The JavadocNode in question.
     * @param p The parameter to use.
     * @return The result of the operation.
     */
    public R executeJavadocNode(JavadocNode node, P p);

    /**
     * Executes this operation against a LabeledStatementNode.
     * @param node The LabeledStatementNode in question.
     * @param p The parameter to use.
     * @return The result of the operation.
     */
    public R executeLabeledStatementNode(LabeledStatementNode node, P p);

    /**
     * Executes this operation against a ListNode.
     * @param node The ListNode in question.
     * @param p The parameter to use.
     * @return The result of the operation.
     */
    public <T extends Node> R executeListNode(ListNode<T> node, P p);

    /**
     * Executes this operation against a LongLiteralNode.
     * @param node The LongLiteralNode in question.
     * @param p The parameter to use.
     * @return The result of the operation.
     */
    public R executeLongLiteralNode(LongLiteralNode node, P p);

    /**
     * Executes this operation against a MetaprogramNode.
     * @param node The MetaprogramNode in question.
     * @param p The parameter to use.
     * @return The result of the operation.
     */
    public R executeMetaprogramNode(MetaprogramNode node, P p);

    /**
     * Executes this operation against a MethodDeclarationNode.
     * @param node The MethodDeclarationNode in question.
     * @param p The parameter to use.
     * @return The result of the operation.
     */
    public R executeMethodDeclarationNode(MethodDeclarationNode node, P p);

    /**
     * Executes this operation against a MethodInvocationByExpressionNode.
     * @param node The MethodInvocationByExpressionNode in question.
     * @param p The parameter to use.
     * @return The result of the operation.
     */
    public R executeMethodInvocationByExpressionNode(MethodInvocationByExpressionNode node, P p);

    /**
     * Executes this operation against a MethodInvocationByNameNode.
     * @param node The MethodInvocationByNameNode in question.
     * @param p The parameter to use.
     * @return The result of the operation.
     */
    public R executeMethodInvocationByNameNode(MethodInvocationByNameNode node, P p);

    /**
     * Executes this operation against a MethodModifiersNode.
     * @param node The MethodModifiersNode in question.
     * @param p The parameter to use.
     * @return The result of the operation.
     */
    public R executeMethodModifiersNode(MethodModifiersNode node, P p);

    /**
     * Executes this operation against a NormalAnnotationNode.
     * @param node The NormalAnnotationNode in question.
     * @param p The parameter to use.
     * @return The result of the operation.
     */
    public R executeNormalAnnotationNode(NormalAnnotationNode node, P p);

    /**
     * Executes this operation against a NullLiteralNode.
     * @param node The NullLiteralNode in question.
     * @param p The parameter to use.
     * @return The result of the operation.
     */
    public R executeNullLiteralNode(NullLiteralNode node, P p);

    /**
     * Executes this operation against a PackageDeclarationNode.
     * @param node The PackageDeclarationNode in question.
     * @param p The parameter to use.
     * @return The result of the operation.
     */
    public R executePackageDeclarationNode(PackageDeclarationNode node, P p);

    /**
     * Executes this operation against a ParameterizedTypeNode.
     * @param node The ParameterizedTypeNode in question.
     * @param p The parameter to use.
     * @return The result of the operation.
     */
    public R executeParameterizedTypeNode(ParameterizedTypeNode node, P p);

    /**
     * Executes this operation against a ParameterizedTypeSelectNode.
     * @param node The ParameterizedTypeSelectNode in question.
     * @param p The parameter to use.
     * @return The result of the operation.
     */
    public R executeParameterizedTypeSelectNode(ParameterizedTypeSelectNode node, P p);

    /**
     * Executes this operation against a ParenthesizedExpressionNode.
     * @param node The ParenthesizedExpressionNode in question.
     * @param p The parameter to use.
     * @return The result of the operation.
     */
    public R executeParenthesizedExpressionNode(ParenthesizedExpressionNode node, P p);

    /**
     * Executes this operation against a PrimitiveTypeNode.
     * @param node The PrimitiveTypeNode in question.
     * @param p The parameter to use.
     * @return The result of the operation.
     */
    public R executePrimitiveTypeNode(PrimitiveTypeNode node, P p);

    /**
     * Executes this operation against a QualifiedClassInstantiationNode.
     * @param node The QualifiedClassInstantiationNode in question.
     * @param p The parameter to use.
     * @return The result of the operation.
     */
    public R executeQualifiedClassInstantiationNode(QualifiedClassInstantiationNode node, P p);

    /**
     * Executes this operation against a QualifiedNameNode.
     * @param node The QualifiedNameNode in question.
     * @param p The parameter to use.
     * @return The result of the operation.
     */
    public R executeQualifiedNameNode(QualifiedNameNode node, P p);

    /**
     * Executes this operation against a ReturnNode.
     * @param node The ReturnNode in question.
     * @param p The parameter to use.
     * @return The result of the operation.
     */
    public R executeReturnNode(ReturnNode node, P p);

    /**
     * Executes this operation against a SimpleNameNode.
     * @param node The SimpleNameNode in question.
     * @param p The parameter to use.
     * @return The result of the operation.
     */
    public R executeSimpleNameNode(SimpleNameNode node, P p);

    /**
     * Executes this operation against a SingleElementAnnotationNode.
     * @param node The SingleElementAnnotationNode in question.
     * @param p The parameter to use.
     * @return The result of the operation.
     */
    public R executeSingleElementAnnotationNode(SingleElementAnnotationNode node, P p);

    /**
     * Executes this operation against a StringLiteralNode.
     * @param node The StringLiteralNode in question.
     * @param p The parameter to use.
     * @return The result of the operation.
     */
    public R executeStringLiteralNode(StringLiteralNode node, P p);

    /**
     * Executes this operation against a SuperFieldAccessNode.
     * @param node The SuperFieldAccessNode in question.
     * @param p The parameter to use.
     * @return The result of the operation.
     */
    public R executeSuperFieldAccessNode(SuperFieldAccessNode node, P p);

    /**
     * Executes this operation against a SuperMethodInvocationNode.
     * @param node The SuperMethodInvocationNode in question.
     * @param p The parameter to use.
     * @return The result of the operation.
     */
    public R executeSuperMethodInvocationNode(SuperMethodInvocationNode node, P p);

    /**
     * Executes this operation against a SuperclassConstructorInvocationNode.
     * @param node The SuperclassConstructorInvocationNode in question.
     * @param p The parameter to use.
     * @return The result of the operation.
     */
    public R executeSuperclassConstructorInvocationNode(SuperclassConstructorInvocationNode node, P p);

    /**
     * Executes this operation against a SwitchNode.
     * @param node The SwitchNode in question.
     * @param p The parameter to use.
     * @return The result of the operation.
     */
    public R executeSwitchNode(SwitchNode node, P p);

    /**
     * Executes this operation against a SynchronizedNode.
     * @param node The SynchronizedNode in question.
     * @param p The parameter to use.
     * @return The result of the operation.
     */
    public R executeSynchronizedNode(SynchronizedNode node, P p);

    /**
     * Executes this operation against a ThisNode.
     * @param node The ThisNode in question.
     * @param p The parameter to use.
     * @return The result of the operation.
     */
    public R executeThisNode(ThisNode node, P p);

    /**
     * Executes this operation against a ThrowNode.
     * @param node The ThrowNode in question.
     * @param p The parameter to use.
     * @return The result of the operation.
     */
    public R executeThrowNode(ThrowNode node, P p);

    /**
     * Executes this operation against a TryNode.
     * @param node The TryNode in question.
     * @param p The parameter to use.
     * @return The result of the operation.
     */
    public R executeTryNode(TryNode node, P p);

    /**
     * Executes this operation against a TypeCastNode.
     * @param node The TypeCastNode in question.
     * @param p The parameter to use.
     * @return The result of the operation.
     */
    public R executeTypeCastNode(TypeCastNode node, P p);

    /**
     * Executes this operation against a TypeDeclarationMetaprogramAnchorNode.
     * @param node The TypeDeclarationMetaprogramAnchorNode in question.
     * @param p The parameter to use.
     * @return The result of the operation.
     */
    public R executeTypeDeclarationMetaprogramAnchorNode(TypeDeclarationMetaprogramAnchorNode node, P p);

    /**
     * Executes this operation against a TypeParameterNode.
     * @param node The TypeParameterNode in question.
     * @param p The parameter to use.
     * @return The result of the operation.
     */
    public R executeTypeParameterNode(TypeParameterNode node, P p);

    /**
     * Executes this operation against a UnaryExpressionNode.
     * @param node The UnaryExpressionNode in question.
     * @param p The parameter to use.
     * @return The result of the operation.
     */
    public R executeUnaryExpressionNode(UnaryExpressionNode node, P p);

    /**
     * Executes this operation against a UnaryStatementExpressionNode.
     * @param node The UnaryStatementExpressionNode in question.
     * @param p The parameter to use.
     * @return The result of the operation.
     */
    public R executeUnaryStatementExpressionNode(UnaryStatementExpressionNode node, P p);

    /**
     * Executes this operation against a UnparameterizedTypeNode.
     * @param node The UnparameterizedTypeNode in question.
     * @param p The parameter to use.
     * @return The result of the operation.
     */
    public R executeUnparameterizedTypeNode(UnparameterizedTypeNode node, P p);

    /**
     * Executes this operation against a UnqualifiedClassInstantiationNode.
     * @param node The UnqualifiedClassInstantiationNode in question.
     * @param p The parameter to use.
     * @return The result of the operation.
     */
    public R executeUnqualifiedClassInstantiationNode(UnqualifiedClassInstantiationNode node, P p);

    /**
     * Executes this operation against a VariableDeclarationNode.
     * @param node The VariableDeclarationNode in question.
     * @param p The parameter to use.
     * @return The result of the operation.
     */
    public R executeVariableDeclarationNode(VariableDeclarationNode node, P p);

    /**
     * Executes this operation against a VariableDeclaratorNode.
     * @param node The VariableDeclaratorNode in question.
     * @param p The parameter to use.
     * @return The result of the operation.
     */
    public R executeVariableDeclaratorNode(VariableDeclaratorNode node, P p);

    /**
     * Executes this operation against a VariableModifiersNode.
     * @param node The VariableModifiersNode in question.
     * @param p The parameter to use.
     * @return The result of the operation.
     */
    public R executeVariableModifiersNode(VariableModifiersNode node, P p);

    /**
     * Executes this operation against a VariableNode.
     * @param node The VariableNode in question.
     * @param p The parameter to use.
     * @return The result of the operation.
     */
    public R executeVariableNode(VariableNode node, P p);

    /**
     * Executes this operation against a VoidStatementNode.
     * @param node The VoidStatementNode in question.
     * @param p The parameter to use.
     * @return The result of the operation.
     */
    public R executeVoidStatementNode(VoidStatementNode node, P p);

    /**
     * Executes this operation against a VoidTypeDeclarationNode.
     * @param node The VoidTypeDeclarationNode in question.
     * @param p The parameter to use.
     * @return The result of the operation.
     */
    public R executeVoidTypeDeclarationNode(VoidTypeDeclarationNode node, P p);

    /**
     * Executes this operation against a VoidTypeNode.
     * @param node The VoidTypeNode in question.
     * @param p The parameter to use.
     * @return The result of the operation.
     */
    public R executeVoidTypeNode(VoidTypeNode node, P p);

    /**
     * Executes this operation against a WhileLoopNode.
     * @param node The WhileLoopNode in question.
     * @param p The parameter to use.
     * @return The result of the operation.
     */
    public R executeWhileLoopNode(WhileLoopNode node, P p);

    /**
     * Executes this operation against a WildcardTypeNode.
     * @param node The WildcardTypeNode in question.
     * @param p The parameter to use.
     * @return The result of the operation.
     */
    public R executeWildcardTypeNode(WildcardTypeNode node, P p);

}
