package edu.jhu.cs.bsj.compiler.ast.util;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeOperation;
import edu.jhu.cs.bsj.compiler.ast.node.*;
import edu.jhu.cs.bsj.compiler.ast.node.meta.AnnotationMemberMetaprogramAnchorNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.AnonymousClassMemberMetaprogramAnchorNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.BlockStatementMetaprogramAnchorNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.ClassMemberMetaprogramAnchorNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.CodeLiteralNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.InterfaceMemberMetaprogramAnchorNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramDependsNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramImportListNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramImportNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramPreambleNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramTargetNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.TypeDeclarationMetaprogramAnchorNode;

/**
 * This implementation of the BSJ node operation implements every method with a call to a default operation method.  The
 * default operation method is left abstract for the overlying implementation.  This serves as a convenient mechanism
 * for handling most nodes with a default case but labeling some with special handling.  For instance, a node operation
 * which only recognizes a small subset of node types might use the default operation to raise a runtime exception.
 *
 * @author Zachary Palmer
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public abstract class BsjDefaultNodeOperation<P,R> implements BsjNodeOperation<P,R>
{
	/**
	 * The default operation which all default node operation implementations will call.
	 * @param node The node in question.
	 * @param p The parameter to the execution method.
	 */
	public abstract R executeDefault(Node node, P p);
    /**
     * Executes the default operation for this node.
     * @param node The node in question.
     * @param p The parameter to this node operation.
     */
    public R executeAlternateConstructorInvocationNode(AlternateConstructorInvocationNode node, P p)
    {
        return executeDefault(node, p);
    }

    /**
     * Executes the default operation for this node.
     * @param node The node in question.
     * @param p The parameter to this node operation.
     */
    public R executeAnnotationAnnotationValueNode(AnnotationAnnotationValueNode node, P p)
    {
        return executeDefault(node, p);
    }

    /**
     * Executes the default operation for this node.
     * @param node The node in question.
     * @param p The parameter to this node operation.
     */
    public R executeAnnotationArrayValueNode(AnnotationArrayValueNode node, P p)
    {
        return executeDefault(node, p);
    }

    /**
     * Executes the default operation for this node.
     * @param node The node in question.
     * @param p The parameter to this node operation.
     */
    public R executeAnnotationBodyNode(AnnotationBodyNode node, P p)
    {
        return executeDefault(node, p);
    }

    /**
     * Executes the default operation for this node.
     * @param node The node in question.
     * @param p The parameter to this node operation.
     */
    public R executeAnnotationDeclarationNode(AnnotationDeclarationNode node, P p)
    {
        return executeDefault(node, p);
    }

    /**
     * Executes the default operation for this node.
     * @param node The node in question.
     * @param p The parameter to this node operation.
     */
    public R executeAnnotationElementListNode(AnnotationElementListNode node, P p)
    {
        return executeDefault(node, p);
    }

    /**
     * Executes the default operation for this node.
     * @param node The node in question.
     * @param p The parameter to this node operation.
     */
    public R executeAnnotationElementNode(AnnotationElementNode node, P p)
    {
        return executeDefault(node, p);
    }

    /**
     * Executes the default operation for this node.
     * @param node The node in question.
     * @param p The parameter to this node operation.
     */
    public R executeAnnotationExpressionValueNode(AnnotationExpressionValueNode node, P p)
    {
        return executeDefault(node, p);
    }

    /**
     * Executes the default operation for this node.
     * @param node The node in question.
     * @param p The parameter to this node operation.
     */
    public R executeAnnotationListNode(AnnotationListNode node, P p)
    {
        return executeDefault(node, p);
    }

    /**
     * Executes the default operation for this node.
     * @param node The node in question.
     * @param p The parameter to this node operation.
     */
    public R executeAnnotationMemberListNode(AnnotationMemberListNode node, P p)
    {
        return executeDefault(node, p);
    }

    /**
     * Executes the default operation for this node.
     * @param node The node in question.
     * @param p The parameter to this node operation.
     */
    public R executeAnnotationMemberMetaprogramAnchorNode(AnnotationMemberMetaprogramAnchorNode node, P p)
    {
        return executeDefault(node, p);
    }

    /**
     * Executes the default operation for this node.
     * @param node The node in question.
     * @param p The parameter to this node operation.
     */
    public R executeAnnotationMethodDeclarationNode(AnnotationMethodDeclarationNode node, P p)
    {
        return executeDefault(node, p);
    }

    /**
     * Executes the default operation for this node.
     * @param node The node in question.
     * @param p The parameter to this node operation.
     */
    public R executeAnnotationMethodModifiersNode(AnnotationMethodModifiersNode node, P p)
    {
        return executeDefault(node, p);
    }

    /**
     * Executes the default operation for this node.
     * @param node The node in question.
     * @param p The parameter to this node operation.
     */
    public R executeAnnotationModifiersNode(AnnotationModifiersNode node, P p)
    {
        return executeDefault(node, p);
    }

    /**
     * Executes the default operation for this node.
     * @param node The node in question.
     * @param p The parameter to this node operation.
     */
    public R executeAnnotationValueListNode(AnnotationValueListNode node, P p)
    {
        return executeDefault(node, p);
    }

    /**
     * Executes the default operation for this node.
     * @param node The node in question.
     * @param p The parameter to this node operation.
     */
    public R executeAnonymousClassBodyNode(AnonymousClassBodyNode node, P p)
    {
        return executeDefault(node, p);
    }

    /**
     * Executes the default operation for this node.
     * @param node The node in question.
     * @param p The parameter to this node operation.
     */
    public R executeAnonymousClassMemberListNode(AnonymousClassMemberListNode node, P p)
    {
        return executeDefault(node, p);
    }

    /**
     * Executes the default operation for this node.
     * @param node The node in question.
     * @param p The parameter to this node operation.
     */
    public R executeAnonymousClassMemberMetaprogramAnchorNode(AnonymousClassMemberMetaprogramAnchorNode node, P p)
    {
        return executeDefault(node, p);
    }

    /**
     * Executes the default operation for this node.
     * @param node The node in question.
     * @param p The parameter to this node operation.
     */
    public R executeArrayAccessNode(ArrayAccessNode node, P p)
    {
        return executeDefault(node, p);
    }

    /**
     * Executes the default operation for this node.
     * @param node The node in question.
     * @param p The parameter to this node operation.
     */
    public R executeArrayInitializerCreationNode(ArrayInitializerCreationNode node, P p)
    {
        return executeDefault(node, p);
    }

    /**
     * Executes the default operation for this node.
     * @param node The node in question.
     * @param p The parameter to this node operation.
     */
    public R executeArrayInitializerNode(ArrayInitializerNode node, P p)
    {
        return executeDefault(node, p);
    }

    /**
     * Executes the default operation for this node.
     * @param node The node in question.
     * @param p The parameter to this node operation.
     */
    public R executeArrayInstantiatorCreationNode(ArrayInstantiatorCreationNode node, P p)
    {
        return executeDefault(node, p);
    }

    /**
     * Executes the default operation for this node.
     * @param node The node in question.
     * @param p The parameter to this node operation.
     */
    public R executeArrayTypeNode(ArrayTypeNode node, P p)
    {
        return executeDefault(node, p);
    }

    /**
     * Executes the default operation for this node.
     * @param node The node in question.
     * @param p The parameter to this node operation.
     */
    public R executeAssertStatementNode(AssertStatementNode node, P p)
    {
        return executeDefault(node, p);
    }

    /**
     * Executes the default operation for this node.
     * @param node The node in question.
     * @param p The parameter to this node operation.
     */
    public R executeAssignmentNode(AssignmentNode node, P p)
    {
        return executeDefault(node, p);
    }

    /**
     * Executes the default operation for this node.
     * @param node The node in question.
     * @param p The parameter to this node operation.
     */
    public R executeBinaryExpressionNode(BinaryExpressionNode node, P p)
    {
        return executeDefault(node, p);
    }

    /**
     * Executes the default operation for this node.
     * @param node The node in question.
     * @param p The parameter to this node operation.
     */
    public R executeBlockNode(BlockNode node, P p)
    {
        return executeDefault(node, p);
    }

    /**
     * Executes the default operation for this node.
     * @param node The node in question.
     * @param p The parameter to this node operation.
     */
    public R executeBlockStatementListNode(BlockStatementListNode node, P p)
    {
        return executeDefault(node, p);
    }

    /**
     * Executes the default operation for this node.
     * @param node The node in question.
     * @param p The parameter to this node operation.
     */
    public R executeBlockStatementMetaprogramAnchorNode(BlockStatementMetaprogramAnchorNode node, P p)
    {
        return executeDefault(node, p);
    }

    /**
     * Executes the default operation for this node.
     * @param node The node in question.
     * @param p The parameter to this node operation.
     */
    public R executeBooleanLiteralNode(BooleanLiteralNode node, P p)
    {
        return executeDefault(node, p);
    }

    /**
     * Executes the default operation for this node.
     * @param node The node in question.
     * @param p The parameter to this node operation.
     */
    public R executeBreakNode(BreakNode node, P p)
    {
        return executeDefault(node, p);
    }

    /**
     * Executes the default operation for this node.
     * @param node The node in question.
     * @param p The parameter to this node operation.
     */
    public R executeCaseListNode(CaseListNode node, P p)
    {
        return executeDefault(node, p);
    }

    /**
     * Executes the default operation for this node.
     * @param node The node in question.
     * @param p The parameter to this node operation.
     */
    public R executeCaseNode(CaseNode node, P p)
    {
        return executeDefault(node, p);
    }

    /**
     * Executes the default operation for this node.
     * @param node The node in question.
     * @param p The parameter to this node operation.
     */
    public R executeCatchListNode(CatchListNode node, P p)
    {
        return executeDefault(node, p);
    }

    /**
     * Executes the default operation for this node.
     * @param node The node in question.
     * @param p The parameter to this node operation.
     */
    public R executeCatchNode(CatchNode node, P p)
    {
        return executeDefault(node, p);
    }

    /**
     * Executes the default operation for this node.
     * @param node The node in question.
     * @param p The parameter to this node operation.
     */
    public R executeCharLiteralNode(CharLiteralNode node, P p)
    {
        return executeDefault(node, p);
    }

    /**
     * Executes the default operation for this node.
     * @param node The node in question.
     * @param p The parameter to this node operation.
     */
    public R executeClassBodyNode(ClassBodyNode node, P p)
    {
        return executeDefault(node, p);
    }

    /**
     * Executes the default operation for this node.
     * @param node The node in question.
     * @param p The parameter to this node operation.
     */
    public R executeClassDeclarationNode(ClassDeclarationNode node, P p)
    {
        return executeDefault(node, p);
    }

    /**
     * Executes the default operation for this node.
     * @param node The node in question.
     * @param p The parameter to this node operation.
     */
    public R executeClassLiteralNode(ClassLiteralNode node, P p)
    {
        return executeDefault(node, p);
    }

    /**
     * Executes the default operation for this node.
     * @param node The node in question.
     * @param p The parameter to this node operation.
     */
    public R executeClassMemberListNode(ClassMemberListNode node, P p)
    {
        return executeDefault(node, p);
    }

    /**
     * Executes the default operation for this node.
     * @param node The node in question.
     * @param p The parameter to this node operation.
     */
    public R executeClassMemberMetaprogramAnchorNode(ClassMemberMetaprogramAnchorNode node, P p)
    {
        return executeDefault(node, p);
    }

    /**
     * Executes the default operation for this node.
     * @param node The node in question.
     * @param p The parameter to this node operation.
     */
    public R executeClassModifiersNode(ClassModifiersNode node, P p)
    {
        return executeDefault(node, p);
    }

    /**
     * Executes the default operation for this node.
     * @param node The node in question.
     * @param p The parameter to this node operation.
     */
    public R executeCodeLiteralNode(CodeLiteralNode node, P p)
    {
        return executeDefault(node, p);
    }

    /**
     * Executes the default operation for this node.
     * @param node The node in question.
     * @param p The parameter to this node operation.
     */
    public R executeCompilationUnitNode(CompilationUnitNode node, P p)
    {
        return executeDefault(node, p);
    }

    /**
     * Executes the default operation for this node.
     * @param node The node in question.
     * @param p The parameter to this node operation.
     */
    public R executeConditionalExpressionNode(ConditionalExpressionNode node, P p)
    {
        return executeDefault(node, p);
    }

    /**
     * Executes the default operation for this node.
     * @param node The node in question.
     * @param p The parameter to this node operation.
     */
    public R executeConstructorBodyNode(ConstructorBodyNode node, P p)
    {
        return executeDefault(node, p);
    }

    /**
     * Executes the default operation for this node.
     * @param node The node in question.
     * @param p The parameter to this node operation.
     */
    public R executeConstructorDeclarationNode(ConstructorDeclarationNode node, P p)
    {
        return executeDefault(node, p);
    }

    /**
     * Executes the default operation for this node.
     * @param node The node in question.
     * @param p The parameter to this node operation.
     */
    public R executeConstructorModifiersNode(ConstructorModifiersNode node, P p)
    {
        return executeDefault(node, p);
    }

    /**
     * Executes the default operation for this node.
     * @param node The node in question.
     * @param p The parameter to this node operation.
     */
    public R executeContinueNode(ContinueNode node, P p)
    {
        return executeDefault(node, p);
    }

    /**
     * Executes the default operation for this node.
     * @param node The node in question.
     * @param p The parameter to this node operation.
     */
    public R executeDeclaredTypeListNode(DeclaredTypeListNode node, P p)
    {
        return executeDefault(node, p);
    }

    /**
     * Executes the default operation for this node.
     * @param node The node in question.
     * @param p The parameter to this node operation.
     */
    public R executeDoWhileLoopNode(DoWhileLoopNode node, P p)
    {
        return executeDefault(node, p);
    }

    /**
     * Executes the default operation for this node.
     * @param node The node in question.
     * @param p The parameter to this node operation.
     */
    public R executeDoubleLiteralNode(DoubleLiteralNode node, P p)
    {
        return executeDefault(node, p);
    }

    /**
     * Executes the default operation for this node.
     * @param node The node in question.
     * @param p The parameter to this node operation.
     */
    public R executeEnhancedForLoopNode(EnhancedForLoopNode node, P p)
    {
        return executeDefault(node, p);
    }

    /**
     * Executes the default operation for this node.
     * @param node The node in question.
     * @param p The parameter to this node operation.
     */
    public R executeEnumBodyNode(EnumBodyNode node, P p)
    {
        return executeDefault(node, p);
    }

    /**
     * Executes the default operation for this node.
     * @param node The node in question.
     * @param p The parameter to this node operation.
     */
    public R executeEnumConstantDeclarationListNode(EnumConstantDeclarationListNode node, P p)
    {
        return executeDefault(node, p);
    }

    /**
     * Executes the default operation for this node.
     * @param node The node in question.
     * @param p The parameter to this node operation.
     */
    public R executeEnumConstantDeclarationNode(EnumConstantDeclarationNode node, P p)
    {
        return executeDefault(node, p);
    }

    /**
     * Executes the default operation for this node.
     * @param node The node in question.
     * @param p The parameter to this node operation.
     */
    public R executeEnumDeclarationNode(EnumDeclarationNode node, P p)
    {
        return executeDefault(node, p);
    }

    /**
     * Executes the default operation for this node.
     * @param node The node in question.
     * @param p The parameter to this node operation.
     */
    public R executeEnumModifiersNode(EnumModifiersNode node, P p)
    {
        return executeDefault(node, p);
    }

    /**
     * Executes the default operation for this node.
     * @param node The node in question.
     * @param p The parameter to this node operation.
     */
    public R executeExpressionListNode(ExpressionListNode node, P p)
    {
        return executeDefault(node, p);
    }

    /**
     * Executes the default operation for this node.
     * @param node The node in question.
     * @param p The parameter to this node operation.
     */
    public R executeExpressionStatementNode(ExpressionStatementNode node, P p)
    {
        return executeDefault(node, p);
    }

    /**
     * Executes the default operation for this node.
     * @param node The node in question.
     * @param p The parameter to this node operation.
     */
    public R executeFieldAccessByExpressionNode(FieldAccessByExpressionNode node, P p)
    {
        return executeDefault(node, p);
    }

    /**
     * Executes the default operation for this node.
     * @param node The node in question.
     * @param p The parameter to this node operation.
     */
    public R executeFieldAccessByNameNode(FieldAccessByNameNode node, P p)
    {
        return executeDefault(node, p);
    }

    /**
     * Executes the default operation for this node.
     * @param node The node in question.
     * @param p The parameter to this node operation.
     */
    public R executeFieldDeclarationNode(FieldDeclarationNode node, P p)
    {
        return executeDefault(node, p);
    }

    /**
     * Executes the default operation for this node.
     * @param node The node in question.
     * @param p The parameter to this node operation.
     */
    public R executeFieldModifiersNode(FieldModifiersNode node, P p)
    {
        return executeDefault(node, p);
    }

    /**
     * Executes the default operation for this node.
     * @param node The node in question.
     * @param p The parameter to this node operation.
     */
    public R executeFloatLiteralNode(FloatLiteralNode node, P p)
    {
        return executeDefault(node, p);
    }

    /**
     * Executes the default operation for this node.
     * @param node The node in question.
     * @param p The parameter to this node operation.
     */
    public R executeForInitializerDeclarationNode(ForInitializerDeclarationNode node, P p)
    {
        return executeDefault(node, p);
    }

    /**
     * Executes the default operation for this node.
     * @param node The node in question.
     * @param p The parameter to this node operation.
     */
    public R executeForInitializerExpressionNode(ForInitializerExpressionNode node, P p)
    {
        return executeDefault(node, p);
    }

    /**
     * Executes the default operation for this node.
     * @param node The node in question.
     * @param p The parameter to this node operation.
     */
    public R executeForLoopNode(ForLoopNode node, P p)
    {
        return executeDefault(node, p);
    }

    /**
     * Executes the default operation for this node.
     * @param node The node in question.
     * @param p The parameter to this node operation.
     */
    public R executeIdentifierListNode(IdentifierListNode node, P p)
    {
        return executeDefault(node, p);
    }

    /**
     * Executes the default operation for this node.
     * @param node The node in question.
     * @param p The parameter to this node operation.
     */
    public R executeIdentifierNode(IdentifierNode node, P p)
    {
        return executeDefault(node, p);
    }

    /**
     * Executes the default operation for this node.
     * @param node The node in question.
     * @param p The parameter to this node operation.
     */
    public R executeIfNode(IfNode node, P p)
    {
        return executeDefault(node, p);
    }

    /**
     * Executes the default operation for this node.
     * @param node The node in question.
     * @param p The parameter to this node operation.
     */
    public R executeImportListNode(ImportListNode node, P p)
    {
        return executeDefault(node, p);
    }

    /**
     * Executes the default operation for this node.
     * @param node The node in question.
     * @param p The parameter to this node operation.
     */
    public R executeImportOnDemandNode(ImportOnDemandNode node, P p)
    {
        return executeDefault(node, p);
    }

    /**
     * Executes the default operation for this node.
     * @param node The node in question.
     * @param p The parameter to this node operation.
     */
    public R executeImportSingleTypeNode(ImportSingleTypeNode node, P p)
    {
        return executeDefault(node, p);
    }

    /**
     * Executes the default operation for this node.
     * @param node The node in question.
     * @param p The parameter to this node operation.
     */
    public R executeInitializerDeclarationNode(InitializerDeclarationNode node, P p)
    {
        return executeDefault(node, p);
    }

    /**
     * Executes the default operation for this node.
     * @param node The node in question.
     * @param p The parameter to this node operation.
     */
    public R executeInlineTypeDeclarationNode(InlineTypeDeclarationNode node, P p)
    {
        return executeDefault(node, p);
    }

    /**
     * Executes the default operation for this node.
     * @param node The node in question.
     * @param p The parameter to this node operation.
     */
    public R executeInstanceOfNode(InstanceOfNode node, P p)
    {
        return executeDefault(node, p);
    }

    /**
     * Executes the default operation for this node.
     * @param node The node in question.
     * @param p The parameter to this node operation.
     */
    public R executeIntLiteralNode(IntLiteralNode node, P p)
    {
        return executeDefault(node, p);
    }

    /**
     * Executes the default operation for this node.
     * @param node The node in question.
     * @param p The parameter to this node operation.
     */
    public R executeInterfaceBodyNode(InterfaceBodyNode node, P p)
    {
        return executeDefault(node, p);
    }

    /**
     * Executes the default operation for this node.
     * @param node The node in question.
     * @param p The parameter to this node operation.
     */
    public R executeInterfaceDeclarationNode(InterfaceDeclarationNode node, P p)
    {
        return executeDefault(node, p);
    }

    /**
     * Executes the default operation for this node.
     * @param node The node in question.
     * @param p The parameter to this node operation.
     */
    public R executeInterfaceMemberListNode(InterfaceMemberListNode node, P p)
    {
        return executeDefault(node, p);
    }

    /**
     * Executes the default operation for this node.
     * @param node The node in question.
     * @param p The parameter to this node operation.
     */
    public R executeInterfaceMemberMetaprogramAnchorNode(InterfaceMemberMetaprogramAnchorNode node, P p)
    {
        return executeDefault(node, p);
    }

    /**
     * Executes the default operation for this node.
     * @param node The node in question.
     * @param p The parameter to this node operation.
     */
    public R executeInterfaceModifiersNode(InterfaceModifiersNode node, P p)
    {
        return executeDefault(node, p);
    }

    /**
     * Executes the default operation for this node.
     * @param node The node in question.
     * @param p The parameter to this node operation.
     */
    public R executeJavadocNode(JavadocNode node, P p)
    {
        return executeDefault(node, p);
    }

    /**
     * Executes the default operation for this node.
     * @param node The node in question.
     * @param p The parameter to this node operation.
     */
    public R executeLabeledStatementNode(LabeledStatementNode node, P p)
    {
        return executeDefault(node, p);
    }

    /**
     * Executes the default operation for this node.
     * @param node The node in question.
     * @param p The parameter to this node operation.
     */
    public R executeLongLiteralNode(LongLiteralNode node, P p)
    {
        return executeDefault(node, p);
    }

    /**
     * Executes the default operation for this node.
     * @param node The node in question.
     * @param p The parameter to this node operation.
     */
    public R executeMetaprogramDependsNode(MetaprogramDependsNode node, P p)
    {
        return executeDefault(node, p);
    }

    /**
     * Executes the default operation for this node.
     * @param node The node in question.
     * @param p The parameter to this node operation.
     */
    public R executeMetaprogramImportListNode(MetaprogramImportListNode node, P p)
    {
        return executeDefault(node, p);
    }

    /**
     * Executes the default operation for this node.
     * @param node The node in question.
     * @param p The parameter to this node operation.
     */
    public R executeMetaprogramImportNode(MetaprogramImportNode node, P p)
    {
        return executeDefault(node, p);
    }

    /**
     * Executes the default operation for this node.
     * @param node The node in question.
     * @param p The parameter to this node operation.
     */
    public R executeMetaprogramNode(MetaprogramNode node, P p)
    {
        return executeDefault(node, p);
    }

    /**
     * Executes the default operation for this node.
     * @param node The node in question.
     * @param p The parameter to this node operation.
     */
    public R executeMetaprogramPreambleNode(MetaprogramPreambleNode node, P p)
    {
        return executeDefault(node, p);
    }

    /**
     * Executes the default operation for this node.
     * @param node The node in question.
     * @param p The parameter to this node operation.
     */
    public R executeMetaprogramTargetNode(MetaprogramTargetNode node, P p)
    {
        return executeDefault(node, p);
    }

    /**
     * Executes the default operation for this node.
     * @param node The node in question.
     * @param p The parameter to this node operation.
     */
    public R executeMethodDeclarationNode(MethodDeclarationNode node, P p)
    {
        return executeDefault(node, p);
    }

    /**
     * Executes the default operation for this node.
     * @param node The node in question.
     * @param p The parameter to this node operation.
     */
    public R executeMethodInvocationByExpressionNode(MethodInvocationByExpressionNode node, P p)
    {
        return executeDefault(node, p);
    }

    /**
     * Executes the default operation for this node.
     * @param node The node in question.
     * @param p The parameter to this node operation.
     */
    public R executeMethodInvocationByNameNode(MethodInvocationByNameNode node, P p)
    {
        return executeDefault(node, p);
    }

    /**
     * Executes the default operation for this node.
     * @param node The node in question.
     * @param p The parameter to this node operation.
     */
    public R executeMethodModifiersNode(MethodModifiersNode node, P p)
    {
        return executeDefault(node, p);
    }

    /**
     * Executes the default operation for this node.
     * @param node The node in question.
     * @param p The parameter to this node operation.
     */
    public R executeNameListNode(NameListNode node, P p)
    {
        return executeDefault(node, p);
    }

    /**
     * Executes the default operation for this node.
     * @param node The node in question.
     * @param p The parameter to this node operation.
     */
    public R executeNoOperationNode(NoOperationNode node, P p)
    {
        return executeDefault(node, p);
    }

    /**
     * Executes the default operation for this node.
     * @param node The node in question.
     * @param p The parameter to this node operation.
     */
    public R executeNormalAnnotationNode(NormalAnnotationNode node, P p)
    {
        return executeDefault(node, p);
    }

    /**
     * Executes the default operation for this node.
     * @param node The node in question.
     * @param p The parameter to this node operation.
     */
    public R executeNullLiteralNode(NullLiteralNode node, P p)
    {
        return executeDefault(node, p);
    }

    /**
     * Executes the default operation for this node.
     * @param node The node in question.
     * @param p The parameter to this node operation.
     */
    public R executePackageDeclarationNode(PackageDeclarationNode node, P p)
    {
        return executeDefault(node, p);
    }

    /**
     * Executes the default operation for this node.
     * @param node The node in question.
     * @param p The parameter to this node operation.
     */
    public R executeParameterizedTypeNode(ParameterizedTypeNode node, P p)
    {
        return executeDefault(node, p);
    }

    /**
     * Executes the default operation for this node.
     * @param node The node in question.
     * @param p The parameter to this node operation.
     */
    public R executeParameterizedTypeSelectNode(ParameterizedTypeSelectNode node, P p)
    {
        return executeDefault(node, p);
    }

    /**
     * Executes the default operation for this node.
     * @param node The node in question.
     * @param p The parameter to this node operation.
     */
    public R executeParenthesizedExpressionNode(ParenthesizedExpressionNode node, P p)
    {
        return executeDefault(node, p);
    }

    /**
     * Executes the default operation for this node.
     * @param node The node in question.
     * @param p The parameter to this node operation.
     */
    public R executePrimitiveTypeNode(PrimitiveTypeNode node, P p)
    {
        return executeDefault(node, p);
    }

    /**
     * Executes the default operation for this node.
     * @param node The node in question.
     * @param p The parameter to this node operation.
     */
    public R executeQualifiedClassInstantiationNode(QualifiedClassInstantiationNode node, P p)
    {
        return executeDefault(node, p);
    }

    /**
     * Executes the default operation for this node.
     * @param node The node in question.
     * @param p The parameter to this node operation.
     */
    public R executeQualifiedNameNode(QualifiedNameNode node, P p)
    {
        return executeDefault(node, p);
    }

    /**
     * Executes the default operation for this node.
     * @param node The node in question.
     * @param p The parameter to this node operation.
     */
    public R executeReturnNode(ReturnNode node, P p)
    {
        return executeDefault(node, p);
    }

    /**
     * Executes the default operation for this node.
     * @param node The node in question.
     * @param p The parameter to this node operation.
     */
    public R executeSimpleNameNode(SimpleNameNode node, P p)
    {
        return executeDefault(node, p);
    }

    /**
     * Executes the default operation for this node.
     * @param node The node in question.
     * @param p The parameter to this node operation.
     */
    public R executeSingleElementAnnotationNode(SingleElementAnnotationNode node, P p)
    {
        return executeDefault(node, p);
    }

    /**
     * Executes the default operation for this node.
     * @param node The node in question.
     * @param p The parameter to this node operation.
     */
    public R executeStatementExpressionListNode(StatementExpressionListNode node, P p)
    {
        return executeDefault(node, p);
    }

    /**
     * Executes the default operation for this node.
     * @param node The node in question.
     * @param p The parameter to this node operation.
     */
    public R executeStringLiteralNode(StringLiteralNode node, P p)
    {
        return executeDefault(node, p);
    }

    /**
     * Executes the default operation for this node.
     * @param node The node in question.
     * @param p The parameter to this node operation.
     */
    public R executeSuperFieldAccessNode(SuperFieldAccessNode node, P p)
    {
        return executeDefault(node, p);
    }

    /**
     * Executes the default operation for this node.
     * @param node The node in question.
     * @param p The parameter to this node operation.
     */
    public R executeSuperMethodInvocationNode(SuperMethodInvocationNode node, P p)
    {
        return executeDefault(node, p);
    }

    /**
     * Executes the default operation for this node.
     * @param node The node in question.
     * @param p The parameter to this node operation.
     */
    public R executeSuperclassConstructorInvocationNode(SuperclassConstructorInvocationNode node, P p)
    {
        return executeDefault(node, p);
    }

    /**
     * Executes the default operation for this node.
     * @param node The node in question.
     * @param p The parameter to this node operation.
     */
    public R executeSwitchNode(SwitchNode node, P p)
    {
        return executeDefault(node, p);
    }

    /**
     * Executes the default operation for this node.
     * @param node The node in question.
     * @param p The parameter to this node operation.
     */
    public R executeSynchronizedNode(SynchronizedNode node, P p)
    {
        return executeDefault(node, p);
    }

    /**
     * Executes the default operation for this node.
     * @param node The node in question.
     * @param p The parameter to this node operation.
     */
    public R executeThisNode(ThisNode node, P p)
    {
        return executeDefault(node, p);
    }

    /**
     * Executes the default operation for this node.
     * @param node The node in question.
     * @param p The parameter to this node operation.
     */
    public R executeThrowNode(ThrowNode node, P p)
    {
        return executeDefault(node, p);
    }

    /**
     * Executes the default operation for this node.
     * @param node The node in question.
     * @param p The parameter to this node operation.
     */
    public R executeTryNode(TryNode node, P p)
    {
        return executeDefault(node, p);
    }

    /**
     * Executes the default operation for this node.
     * @param node The node in question.
     * @param p The parameter to this node operation.
     */
    public R executeTypeArgumentListNode(TypeArgumentListNode node, P p)
    {
        return executeDefault(node, p);
    }

    /**
     * Executes the default operation for this node.
     * @param node The node in question.
     * @param p The parameter to this node operation.
     */
    public R executeTypeCastNode(TypeCastNode node, P p)
    {
        return executeDefault(node, p);
    }

    /**
     * Executes the default operation for this node.
     * @param node The node in question.
     * @param p The parameter to this node operation.
     */
    public R executeTypeDeclarationListNode(TypeDeclarationListNode node, P p)
    {
        return executeDefault(node, p);
    }

    /**
     * Executes the default operation for this node.
     * @param node The node in question.
     * @param p The parameter to this node operation.
     */
    public R executeTypeDeclarationMetaprogramAnchorNode(TypeDeclarationMetaprogramAnchorNode node, P p)
    {
        return executeDefault(node, p);
    }

    /**
     * Executes the default operation for this node.
     * @param node The node in question.
     * @param p The parameter to this node operation.
     */
    public R executeTypeListNode(TypeListNode node, P p)
    {
        return executeDefault(node, p);
    }

    /**
     * Executes the default operation for this node.
     * @param node The node in question.
     * @param p The parameter to this node operation.
     */
    public R executeTypeParameterListNode(TypeParameterListNode node, P p)
    {
        return executeDefault(node, p);
    }

    /**
     * Executes the default operation for this node.
     * @param node The node in question.
     * @param p The parameter to this node operation.
     */
    public R executeTypeParameterNode(TypeParameterNode node, P p)
    {
        return executeDefault(node, p);
    }

    /**
     * Executes the default operation for this node.
     * @param node The node in question.
     * @param p The parameter to this node operation.
     */
    public R executeUnaryExpressionNode(UnaryExpressionNode node, P p)
    {
        return executeDefault(node, p);
    }

    /**
     * Executes the default operation for this node.
     * @param node The node in question.
     * @param p The parameter to this node operation.
     */
    public R executeUnaryStatementExpressionNode(UnaryStatementExpressionNode node, P p)
    {
        return executeDefault(node, p);
    }

    /**
     * Executes the default operation for this node.
     * @param node The node in question.
     * @param p The parameter to this node operation.
     */
    public R executeUnparameterizedTypeListNode(UnparameterizedTypeListNode node, P p)
    {
        return executeDefault(node, p);
    }

    /**
     * Executes the default operation for this node.
     * @param node The node in question.
     * @param p The parameter to this node operation.
     */
    public R executeUnparameterizedTypeNode(UnparameterizedTypeNode node, P p)
    {
        return executeDefault(node, p);
    }

    /**
     * Executes the default operation for this node.
     * @param node The node in question.
     * @param p The parameter to this node operation.
     */
    public R executeUnqualifiedClassInstantiationNode(UnqualifiedClassInstantiationNode node, P p)
    {
        return executeDefault(node, p);
    }

    /**
     * Executes the default operation for this node.
     * @param node The node in question.
     * @param p The parameter to this node operation.
     */
    public R executeVariableDeclarationNode(VariableDeclarationNode node, P p)
    {
        return executeDefault(node, p);
    }

    /**
     * Executes the default operation for this node.
     * @param node The node in question.
     * @param p The parameter to this node operation.
     */
    public R executeVariableDeclaratorListNode(VariableDeclaratorListNode node, P p)
    {
        return executeDefault(node, p);
    }

    /**
     * Executes the default operation for this node.
     * @param node The node in question.
     * @param p The parameter to this node operation.
     */
    public R executeVariableDeclaratorNode(VariableDeclaratorNode node, P p)
    {
        return executeDefault(node, p);
    }

    /**
     * Executes the default operation for this node.
     * @param node The node in question.
     * @param p The parameter to this node operation.
     */
    public R executeVariableInitializerListNode(VariableInitializerListNode node, P p)
    {
        return executeDefault(node, p);
    }

    /**
     * Executes the default operation for this node.
     * @param node The node in question.
     * @param p The parameter to this node operation.
     */
    public R executeVariableListNode(VariableListNode node, P p)
    {
        return executeDefault(node, p);
    }

    /**
     * Executes the default operation for this node.
     * @param node The node in question.
     * @param p The parameter to this node operation.
     */
    public R executeVariableModifiersNode(VariableModifiersNode node, P p)
    {
        return executeDefault(node, p);
    }

    /**
     * Executes the default operation for this node.
     * @param node The node in question.
     * @param p The parameter to this node operation.
     */
    public R executeVariableNode(VariableNode node, P p)
    {
        return executeDefault(node, p);
    }

    /**
     * Executes the default operation for this node.
     * @param node The node in question.
     * @param p The parameter to this node operation.
     */
    public R executeVoidTypeNode(VoidTypeNode node, P p)
    {
        return executeDefault(node, p);
    }

    /**
     * Executes the default operation for this node.
     * @param node The node in question.
     * @param p The parameter to this node operation.
     */
    public R executeWhileLoopNode(WhileLoopNode node, P p)
    {
        return executeDefault(node, p);
    }

    /**
     * Executes the default operation for this node.
     * @param node The node in question.
     * @param p The parameter to this node operation.
     */
    public R executeWildcardTypeNode(WildcardTypeNode node, P p)
    {
        return executeDefault(node, p);
    }

}
