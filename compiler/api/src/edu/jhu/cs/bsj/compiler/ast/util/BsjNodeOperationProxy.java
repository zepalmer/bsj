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
 * This implementation of the BSJ node operation decorates every method of a backing
 * operation with a uniform before and after call.  This permits allows proxying, adjusting
 * or logging the parameters and results of calls, or adaptation of the backing operation
 * to a different set of data types.  Note that only the first call is proxied; if the
 * backing operation calls itself, those calls are not intercepted.
 *
 * @param <POrig> The data parameter type for the original backing operation.
 * @param <ROrig> The return type for the original backing operation.
 * @param <PNew> The data parameter type for the new decorated operation.
 * @param <RNew> The return type for the decorated operation.
 *
 * @author Zachary Palmer
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public abstract class BsjNodeOperationProxy<POrig,ROrig,PNew,RNew> implements BsjNodeOperation<PNew,RNew>
{
    /** The backing operation to proxy. */
    private BsjNodeOperation<POrig,ROrig> backingOp;

    /**
     * Creates a new node operation proxy.
     * @param backingOp The backing operation to proxy.
     */
    public BsjNodeOperationProxy(BsjNodeOperation<POrig,ROrig> backingOp)
    {
        this.backingOp = backingOp;
    }

    /**
     * Called before every call to the backing operation.
     * @param p The incoming parameter data (compatible with the proxy interface).
     * @return The resulting parameter data (compatible with the backing interface).
     */
    protected abstract POrig before(PNew p);

    /**
     * Called after every call to the backing operation.
     * @param p The incoming return data (compatible with the backing interface).
     * @return The resulting return data (compatible with the return interface).
     */
    protected abstract RNew after(ROrig r);

    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeAlternateConstructorInvocationNode(AlternateConstructorInvocationNode node, PNew p)
    {
        POrig porig = before(p);
        ROrig rorig = this.backingOp.executeAlternateConstructorInvocationNode(node, porig);
        return after(rorig);
    }

    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeAnnotationAnnotationValueNode(AnnotationAnnotationValueNode node, PNew p)
    {
        POrig porig = before(p);
        ROrig rorig = this.backingOp.executeAnnotationAnnotationValueNode(node, porig);
        return after(rorig);
    }

    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeAnnotationArrayValueNode(AnnotationArrayValueNode node, PNew p)
    {
        POrig porig = before(p);
        ROrig rorig = this.backingOp.executeAnnotationArrayValueNode(node, porig);
        return after(rorig);
    }

    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeAnnotationBodyNode(AnnotationBodyNode node, PNew p)
    {
        POrig porig = before(p);
        ROrig rorig = this.backingOp.executeAnnotationBodyNode(node, porig);
        return after(rorig);
    }

    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeAnnotationDeclarationNode(AnnotationDeclarationNode node, PNew p)
    {
        POrig porig = before(p);
        ROrig rorig = this.backingOp.executeAnnotationDeclarationNode(node, porig);
        return after(rorig);
    }

    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeAnnotationElementListNode(AnnotationElementListNode node, PNew p)
    {
        POrig porig = before(p);
        ROrig rorig = this.backingOp.executeAnnotationElementListNode(node, porig);
        return after(rorig);
    }

    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeAnnotationElementNode(AnnotationElementNode node, PNew p)
    {
        POrig porig = before(p);
        ROrig rorig = this.backingOp.executeAnnotationElementNode(node, porig);
        return after(rorig);
    }

    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeAnnotationExpressionValueNode(AnnotationExpressionValueNode node, PNew p)
    {
        POrig porig = before(p);
        ROrig rorig = this.backingOp.executeAnnotationExpressionValueNode(node, porig);
        return after(rorig);
    }

    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeAnnotationListNode(AnnotationListNode node, PNew p)
    {
        POrig porig = before(p);
        ROrig rorig = this.backingOp.executeAnnotationListNode(node, porig);
        return after(rorig);
    }

    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeAnnotationMemberListNode(AnnotationMemberListNode node, PNew p)
    {
        POrig porig = before(p);
        ROrig rorig = this.backingOp.executeAnnotationMemberListNode(node, porig);
        return after(rorig);
    }

    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeAnnotationMemberMetaprogramAnchorNode(AnnotationMemberMetaprogramAnchorNode node, PNew p)
    {
        POrig porig = before(p);
        ROrig rorig = this.backingOp.executeAnnotationMemberMetaprogramAnchorNode(node, porig);
        return after(rorig);
    }

    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeAnnotationMethodDeclarationNode(AnnotationMethodDeclarationNode node, PNew p)
    {
        POrig porig = before(p);
        ROrig rorig = this.backingOp.executeAnnotationMethodDeclarationNode(node, porig);
        return after(rorig);
    }

    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeAnnotationMethodModifiersNode(AnnotationMethodModifiersNode node, PNew p)
    {
        POrig porig = before(p);
        ROrig rorig = this.backingOp.executeAnnotationMethodModifiersNode(node, porig);
        return after(rorig);
    }

    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeAnnotationModifiersNode(AnnotationModifiersNode node, PNew p)
    {
        POrig porig = before(p);
        ROrig rorig = this.backingOp.executeAnnotationModifiersNode(node, porig);
        return after(rorig);
    }

    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeAnnotationValueListNode(AnnotationValueListNode node, PNew p)
    {
        POrig porig = before(p);
        ROrig rorig = this.backingOp.executeAnnotationValueListNode(node, porig);
        return after(rorig);
    }

    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeAnonymousClassBodyNode(AnonymousClassBodyNode node, PNew p)
    {
        POrig porig = before(p);
        ROrig rorig = this.backingOp.executeAnonymousClassBodyNode(node, porig);
        return after(rorig);
    }

    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeAnonymousClassMemberListNode(AnonymousClassMemberListNode node, PNew p)
    {
        POrig porig = before(p);
        ROrig rorig = this.backingOp.executeAnonymousClassMemberListNode(node, porig);
        return after(rorig);
    }

    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeAnonymousClassMemberMetaprogramAnchorNode(AnonymousClassMemberMetaprogramAnchorNode node, PNew p)
    {
        POrig porig = before(p);
        ROrig rorig = this.backingOp.executeAnonymousClassMemberMetaprogramAnchorNode(node, porig);
        return after(rorig);
    }

    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeArrayAccessNode(ArrayAccessNode node, PNew p)
    {
        POrig porig = before(p);
        ROrig rorig = this.backingOp.executeArrayAccessNode(node, porig);
        return after(rorig);
    }

    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeArrayInitializerCreationNode(ArrayInitializerCreationNode node, PNew p)
    {
        POrig porig = before(p);
        ROrig rorig = this.backingOp.executeArrayInitializerCreationNode(node, porig);
        return after(rorig);
    }

    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeArrayInitializerNode(ArrayInitializerNode node, PNew p)
    {
        POrig porig = before(p);
        ROrig rorig = this.backingOp.executeArrayInitializerNode(node, porig);
        return after(rorig);
    }

    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeArrayInstantiatorCreationNode(ArrayInstantiatorCreationNode node, PNew p)
    {
        POrig porig = before(p);
        ROrig rorig = this.backingOp.executeArrayInstantiatorCreationNode(node, porig);
        return after(rorig);
    }

    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeArrayTypeNode(ArrayTypeNode node, PNew p)
    {
        POrig porig = before(p);
        ROrig rorig = this.backingOp.executeArrayTypeNode(node, porig);
        return after(rorig);
    }

    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeAssertStatementNode(AssertStatementNode node, PNew p)
    {
        POrig porig = before(p);
        ROrig rorig = this.backingOp.executeAssertStatementNode(node, porig);
        return after(rorig);
    }

    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeAssignmentNode(AssignmentNode node, PNew p)
    {
        POrig porig = before(p);
        ROrig rorig = this.backingOp.executeAssignmentNode(node, porig);
        return after(rorig);
    }

    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeBinaryExpressionNode(BinaryExpressionNode node, PNew p)
    {
        POrig porig = before(p);
        ROrig rorig = this.backingOp.executeBinaryExpressionNode(node, porig);
        return after(rorig);
    }

    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeBlockNode(BlockNode node, PNew p)
    {
        POrig porig = before(p);
        ROrig rorig = this.backingOp.executeBlockNode(node, porig);
        return after(rorig);
    }

    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeBlockStatementListNode(BlockStatementListNode node, PNew p)
    {
        POrig porig = before(p);
        ROrig rorig = this.backingOp.executeBlockStatementListNode(node, porig);
        return after(rorig);
    }

    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeBlockStatementMetaprogramAnchorNode(BlockStatementMetaprogramAnchorNode node, PNew p)
    {
        POrig porig = before(p);
        ROrig rorig = this.backingOp.executeBlockStatementMetaprogramAnchorNode(node, porig);
        return after(rorig);
    }

    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeBooleanLiteralNode(BooleanLiteralNode node, PNew p)
    {
        POrig porig = before(p);
        ROrig rorig = this.backingOp.executeBooleanLiteralNode(node, porig);
        return after(rorig);
    }

    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeBreakNode(BreakNode node, PNew p)
    {
        POrig porig = before(p);
        ROrig rorig = this.backingOp.executeBreakNode(node, porig);
        return after(rorig);
    }

    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeCaseListNode(CaseListNode node, PNew p)
    {
        POrig porig = before(p);
        ROrig rorig = this.backingOp.executeCaseListNode(node, porig);
        return after(rorig);
    }

    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeCaseNode(CaseNode node, PNew p)
    {
        POrig porig = before(p);
        ROrig rorig = this.backingOp.executeCaseNode(node, porig);
        return after(rorig);
    }

    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeCatchListNode(CatchListNode node, PNew p)
    {
        POrig porig = before(p);
        ROrig rorig = this.backingOp.executeCatchListNode(node, porig);
        return after(rorig);
    }

    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeCatchNode(CatchNode node, PNew p)
    {
        POrig porig = before(p);
        ROrig rorig = this.backingOp.executeCatchNode(node, porig);
        return after(rorig);
    }

    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeCharLiteralNode(CharLiteralNode node, PNew p)
    {
        POrig porig = before(p);
        ROrig rorig = this.backingOp.executeCharLiteralNode(node, porig);
        return after(rorig);
    }

    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeClassBodyNode(ClassBodyNode node, PNew p)
    {
        POrig porig = before(p);
        ROrig rorig = this.backingOp.executeClassBodyNode(node, porig);
        return after(rorig);
    }

    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeClassDeclarationNode(ClassDeclarationNode node, PNew p)
    {
        POrig porig = before(p);
        ROrig rorig = this.backingOp.executeClassDeclarationNode(node, porig);
        return after(rorig);
    }

    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeClassLiteralNode(ClassLiteralNode node, PNew p)
    {
        POrig porig = before(p);
        ROrig rorig = this.backingOp.executeClassLiteralNode(node, porig);
        return after(rorig);
    }

    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeClassMemberListNode(ClassMemberListNode node, PNew p)
    {
        POrig porig = before(p);
        ROrig rorig = this.backingOp.executeClassMemberListNode(node, porig);
        return after(rorig);
    }

    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeClassMemberMetaprogramAnchorNode(ClassMemberMetaprogramAnchorNode node, PNew p)
    {
        POrig porig = before(p);
        ROrig rorig = this.backingOp.executeClassMemberMetaprogramAnchorNode(node, porig);
        return after(rorig);
    }

    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeClassModifiersNode(ClassModifiersNode node, PNew p)
    {
        POrig porig = before(p);
        ROrig rorig = this.backingOp.executeClassModifiersNode(node, porig);
        return after(rorig);
    }

    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeCodeLiteralNode(CodeLiteralNode node, PNew p)
    {
        POrig porig = before(p);
        ROrig rorig = this.backingOp.executeCodeLiteralNode(node, porig);
        return after(rorig);
    }

    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeCompilationUnitNode(CompilationUnitNode node, PNew p)
    {
        POrig porig = before(p);
        ROrig rorig = this.backingOp.executeCompilationUnitNode(node, porig);
        return after(rorig);
    }

    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeConditionalExpressionNode(ConditionalExpressionNode node, PNew p)
    {
        POrig porig = before(p);
        ROrig rorig = this.backingOp.executeConditionalExpressionNode(node, porig);
        return after(rorig);
    }

    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeConstructorBodyNode(ConstructorBodyNode node, PNew p)
    {
        POrig porig = before(p);
        ROrig rorig = this.backingOp.executeConstructorBodyNode(node, porig);
        return after(rorig);
    }

    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeConstructorDeclarationNode(ConstructorDeclarationNode node, PNew p)
    {
        POrig porig = before(p);
        ROrig rorig = this.backingOp.executeConstructorDeclarationNode(node, porig);
        return after(rorig);
    }

    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeConstructorModifiersNode(ConstructorModifiersNode node, PNew p)
    {
        POrig porig = before(p);
        ROrig rorig = this.backingOp.executeConstructorModifiersNode(node, porig);
        return after(rorig);
    }

    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeContinueNode(ContinueNode node, PNew p)
    {
        POrig porig = before(p);
        ROrig rorig = this.backingOp.executeContinueNode(node, porig);
        return after(rorig);
    }

    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeDeclaredTypeListNode(DeclaredTypeListNode node, PNew p)
    {
        POrig porig = before(p);
        ROrig rorig = this.backingOp.executeDeclaredTypeListNode(node, porig);
        return after(rorig);
    }

    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeDoWhileLoopNode(DoWhileLoopNode node, PNew p)
    {
        POrig porig = before(p);
        ROrig rorig = this.backingOp.executeDoWhileLoopNode(node, porig);
        return after(rorig);
    }

    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeDoubleLiteralNode(DoubleLiteralNode node, PNew p)
    {
        POrig porig = before(p);
        ROrig rorig = this.backingOp.executeDoubleLiteralNode(node, porig);
        return after(rorig);
    }

    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeEnhancedForLoopNode(EnhancedForLoopNode node, PNew p)
    {
        POrig porig = before(p);
        ROrig rorig = this.backingOp.executeEnhancedForLoopNode(node, porig);
        return after(rorig);
    }

    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeEnumBodyNode(EnumBodyNode node, PNew p)
    {
        POrig porig = before(p);
        ROrig rorig = this.backingOp.executeEnumBodyNode(node, porig);
        return after(rorig);
    }

    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeEnumConstantDeclarationListNode(EnumConstantDeclarationListNode node, PNew p)
    {
        POrig porig = before(p);
        ROrig rorig = this.backingOp.executeEnumConstantDeclarationListNode(node, porig);
        return after(rorig);
    }

    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeEnumConstantDeclarationNode(EnumConstantDeclarationNode node, PNew p)
    {
        POrig porig = before(p);
        ROrig rorig = this.backingOp.executeEnumConstantDeclarationNode(node, porig);
        return after(rorig);
    }

    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeEnumDeclarationNode(EnumDeclarationNode node, PNew p)
    {
        POrig porig = before(p);
        ROrig rorig = this.backingOp.executeEnumDeclarationNode(node, porig);
        return after(rorig);
    }

    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeEnumModifiersNode(EnumModifiersNode node, PNew p)
    {
        POrig porig = before(p);
        ROrig rorig = this.backingOp.executeEnumModifiersNode(node, porig);
        return after(rorig);
    }

    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeExpressionListNode(ExpressionListNode node, PNew p)
    {
        POrig porig = before(p);
        ROrig rorig = this.backingOp.executeExpressionListNode(node, porig);
        return after(rorig);
    }

    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeExpressionStatementNode(ExpressionStatementNode node, PNew p)
    {
        POrig porig = before(p);
        ROrig rorig = this.backingOp.executeExpressionStatementNode(node, porig);
        return after(rorig);
    }

    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeFieldAccessByExpressionNode(FieldAccessByExpressionNode node, PNew p)
    {
        POrig porig = before(p);
        ROrig rorig = this.backingOp.executeFieldAccessByExpressionNode(node, porig);
        return after(rorig);
    }

    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeFieldAccessByNameNode(FieldAccessByNameNode node, PNew p)
    {
        POrig porig = before(p);
        ROrig rorig = this.backingOp.executeFieldAccessByNameNode(node, porig);
        return after(rorig);
    }

    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeFieldDeclarationNode(FieldDeclarationNode node, PNew p)
    {
        POrig porig = before(p);
        ROrig rorig = this.backingOp.executeFieldDeclarationNode(node, porig);
        return after(rorig);
    }

    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeFieldModifiersNode(FieldModifiersNode node, PNew p)
    {
        POrig porig = before(p);
        ROrig rorig = this.backingOp.executeFieldModifiersNode(node, porig);
        return after(rorig);
    }

    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeFloatLiteralNode(FloatLiteralNode node, PNew p)
    {
        POrig porig = before(p);
        ROrig rorig = this.backingOp.executeFloatLiteralNode(node, porig);
        return after(rorig);
    }

    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeForInitializerDeclarationNode(ForInitializerDeclarationNode node, PNew p)
    {
        POrig porig = before(p);
        ROrig rorig = this.backingOp.executeForInitializerDeclarationNode(node, porig);
        return after(rorig);
    }

    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeForInitializerExpressionNode(ForInitializerExpressionNode node, PNew p)
    {
        POrig porig = before(p);
        ROrig rorig = this.backingOp.executeForInitializerExpressionNode(node, porig);
        return after(rorig);
    }

    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeForLoopNode(ForLoopNode node, PNew p)
    {
        POrig porig = before(p);
        ROrig rorig = this.backingOp.executeForLoopNode(node, porig);
        return after(rorig);
    }

    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeIdentifierListNode(IdentifierListNode node, PNew p)
    {
        POrig porig = before(p);
        ROrig rorig = this.backingOp.executeIdentifierListNode(node, porig);
        return after(rorig);
    }

    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeIdentifierNode(IdentifierNode node, PNew p)
    {
        POrig porig = before(p);
        ROrig rorig = this.backingOp.executeIdentifierNode(node, porig);
        return after(rorig);
    }

    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeIfNode(IfNode node, PNew p)
    {
        POrig porig = before(p);
        ROrig rorig = this.backingOp.executeIfNode(node, porig);
        return after(rorig);
    }

    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeImportListNode(ImportListNode node, PNew p)
    {
        POrig porig = before(p);
        ROrig rorig = this.backingOp.executeImportListNode(node, porig);
        return after(rorig);
    }

    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeImportOnDemandNode(ImportOnDemandNode node, PNew p)
    {
        POrig porig = before(p);
        ROrig rorig = this.backingOp.executeImportOnDemandNode(node, porig);
        return after(rorig);
    }

    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeImportSingleTypeNode(ImportSingleTypeNode node, PNew p)
    {
        POrig porig = before(p);
        ROrig rorig = this.backingOp.executeImportSingleTypeNode(node, porig);
        return after(rorig);
    }

    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeInitializerDeclarationNode(InitializerDeclarationNode node, PNew p)
    {
        POrig porig = before(p);
        ROrig rorig = this.backingOp.executeInitializerDeclarationNode(node, porig);
        return after(rorig);
    }

    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeInlineTypeDeclarationNode(InlineTypeDeclarationNode node, PNew p)
    {
        POrig porig = before(p);
        ROrig rorig = this.backingOp.executeInlineTypeDeclarationNode(node, porig);
        return after(rorig);
    }

    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeInstanceOfNode(InstanceOfNode node, PNew p)
    {
        POrig porig = before(p);
        ROrig rorig = this.backingOp.executeInstanceOfNode(node, porig);
        return after(rorig);
    }

    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeIntLiteralNode(IntLiteralNode node, PNew p)
    {
        POrig porig = before(p);
        ROrig rorig = this.backingOp.executeIntLiteralNode(node, porig);
        return after(rorig);
    }

    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeInterfaceBodyNode(InterfaceBodyNode node, PNew p)
    {
        POrig porig = before(p);
        ROrig rorig = this.backingOp.executeInterfaceBodyNode(node, porig);
        return after(rorig);
    }

    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeInterfaceDeclarationNode(InterfaceDeclarationNode node, PNew p)
    {
        POrig porig = before(p);
        ROrig rorig = this.backingOp.executeInterfaceDeclarationNode(node, porig);
        return after(rorig);
    }

    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeInterfaceMemberListNode(InterfaceMemberListNode node, PNew p)
    {
        POrig porig = before(p);
        ROrig rorig = this.backingOp.executeInterfaceMemberListNode(node, porig);
        return after(rorig);
    }

    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeInterfaceMemberMetaprogramAnchorNode(InterfaceMemberMetaprogramAnchorNode node, PNew p)
    {
        POrig porig = before(p);
        ROrig rorig = this.backingOp.executeInterfaceMemberMetaprogramAnchorNode(node, porig);
        return after(rorig);
    }

    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeInterfaceModifiersNode(InterfaceModifiersNode node, PNew p)
    {
        POrig porig = before(p);
        ROrig rorig = this.backingOp.executeInterfaceModifiersNode(node, porig);
        return after(rorig);
    }

    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeJavadocNode(JavadocNode node, PNew p)
    {
        POrig porig = before(p);
        ROrig rorig = this.backingOp.executeJavadocNode(node, porig);
        return after(rorig);
    }

    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeLabeledStatementNode(LabeledStatementNode node, PNew p)
    {
        POrig porig = before(p);
        ROrig rorig = this.backingOp.executeLabeledStatementNode(node, porig);
        return after(rorig);
    }

    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeLongLiteralNode(LongLiteralNode node, PNew p)
    {
        POrig porig = before(p);
        ROrig rorig = this.backingOp.executeLongLiteralNode(node, porig);
        return after(rorig);
    }

    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeMetaprogramDependsNode(MetaprogramDependsNode node, PNew p)
    {
        POrig porig = before(p);
        ROrig rorig = this.backingOp.executeMetaprogramDependsNode(node, porig);
        return after(rorig);
    }

    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeMetaprogramImportListNode(MetaprogramImportListNode node, PNew p)
    {
        POrig porig = before(p);
        ROrig rorig = this.backingOp.executeMetaprogramImportListNode(node, porig);
        return after(rorig);
    }

    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeMetaprogramImportNode(MetaprogramImportNode node, PNew p)
    {
        POrig porig = before(p);
        ROrig rorig = this.backingOp.executeMetaprogramImportNode(node, porig);
        return after(rorig);
    }

    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeMetaprogramNode(MetaprogramNode node, PNew p)
    {
        POrig porig = before(p);
        ROrig rorig = this.backingOp.executeMetaprogramNode(node, porig);
        return after(rorig);
    }

    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeMetaprogramPreambleNode(MetaprogramPreambleNode node, PNew p)
    {
        POrig porig = before(p);
        ROrig rorig = this.backingOp.executeMetaprogramPreambleNode(node, porig);
        return after(rorig);
    }

    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeMetaprogramTargetNode(MetaprogramTargetNode node, PNew p)
    {
        POrig porig = before(p);
        ROrig rorig = this.backingOp.executeMetaprogramTargetNode(node, porig);
        return after(rorig);
    }

    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeMethodDeclarationNode(MethodDeclarationNode node, PNew p)
    {
        POrig porig = before(p);
        ROrig rorig = this.backingOp.executeMethodDeclarationNode(node, porig);
        return after(rorig);
    }

    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeMethodInvocationByExpressionNode(MethodInvocationByExpressionNode node, PNew p)
    {
        POrig porig = before(p);
        ROrig rorig = this.backingOp.executeMethodInvocationByExpressionNode(node, porig);
        return after(rorig);
    }

    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeMethodInvocationByNameNode(MethodInvocationByNameNode node, PNew p)
    {
        POrig porig = before(p);
        ROrig rorig = this.backingOp.executeMethodInvocationByNameNode(node, porig);
        return after(rorig);
    }

    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeMethodModifiersNode(MethodModifiersNode node, PNew p)
    {
        POrig porig = before(p);
        ROrig rorig = this.backingOp.executeMethodModifiersNode(node, porig);
        return after(rorig);
    }

    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeNameListNode(NameListNode node, PNew p)
    {
        POrig porig = before(p);
        ROrig rorig = this.backingOp.executeNameListNode(node, porig);
        return after(rorig);
    }

    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeNoOperationNode(NoOperationNode node, PNew p)
    {
        POrig porig = before(p);
        ROrig rorig = this.backingOp.executeNoOperationNode(node, porig);
        return after(rorig);
    }

    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeNormalAnnotationNode(NormalAnnotationNode node, PNew p)
    {
        POrig porig = before(p);
        ROrig rorig = this.backingOp.executeNormalAnnotationNode(node, porig);
        return after(rorig);
    }

    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeNullLiteralNode(NullLiteralNode node, PNew p)
    {
        POrig porig = before(p);
        ROrig rorig = this.backingOp.executeNullLiteralNode(node, porig);
        return after(rorig);
    }

    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executePackageDeclarationNode(PackageDeclarationNode node, PNew p)
    {
        POrig porig = before(p);
        ROrig rorig = this.backingOp.executePackageDeclarationNode(node, porig);
        return after(rorig);
    }

    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeParameterizedTypeNode(ParameterizedTypeNode node, PNew p)
    {
        POrig porig = before(p);
        ROrig rorig = this.backingOp.executeParameterizedTypeNode(node, porig);
        return after(rorig);
    }

    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeParameterizedTypeSelectNode(ParameterizedTypeSelectNode node, PNew p)
    {
        POrig porig = before(p);
        ROrig rorig = this.backingOp.executeParameterizedTypeSelectNode(node, porig);
        return after(rorig);
    }

    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeParenthesizedExpressionNode(ParenthesizedExpressionNode node, PNew p)
    {
        POrig porig = before(p);
        ROrig rorig = this.backingOp.executeParenthesizedExpressionNode(node, porig);
        return after(rorig);
    }

    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executePrimitiveTypeNode(PrimitiveTypeNode node, PNew p)
    {
        POrig porig = before(p);
        ROrig rorig = this.backingOp.executePrimitiveTypeNode(node, porig);
        return after(rorig);
    }

    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeQualifiedClassInstantiationNode(QualifiedClassInstantiationNode node, PNew p)
    {
        POrig porig = before(p);
        ROrig rorig = this.backingOp.executeQualifiedClassInstantiationNode(node, porig);
        return after(rorig);
    }

    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeQualifiedNameNode(QualifiedNameNode node, PNew p)
    {
        POrig porig = before(p);
        ROrig rorig = this.backingOp.executeQualifiedNameNode(node, porig);
        return after(rorig);
    }

    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeReturnNode(ReturnNode node, PNew p)
    {
        POrig porig = before(p);
        ROrig rorig = this.backingOp.executeReturnNode(node, porig);
        return after(rorig);
    }

    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeSimpleNameNode(SimpleNameNode node, PNew p)
    {
        POrig porig = before(p);
        ROrig rorig = this.backingOp.executeSimpleNameNode(node, porig);
        return after(rorig);
    }

    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeSingleElementAnnotationNode(SingleElementAnnotationNode node, PNew p)
    {
        POrig porig = before(p);
        ROrig rorig = this.backingOp.executeSingleElementAnnotationNode(node, porig);
        return after(rorig);
    }

    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeStatementExpressionListNode(StatementExpressionListNode node, PNew p)
    {
        POrig porig = before(p);
        ROrig rorig = this.backingOp.executeStatementExpressionListNode(node, porig);
        return after(rorig);
    }

    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeStringLiteralNode(StringLiteralNode node, PNew p)
    {
        POrig porig = before(p);
        ROrig rorig = this.backingOp.executeStringLiteralNode(node, porig);
        return after(rorig);
    }

    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeSuperFieldAccessNode(SuperFieldAccessNode node, PNew p)
    {
        POrig porig = before(p);
        ROrig rorig = this.backingOp.executeSuperFieldAccessNode(node, porig);
        return after(rorig);
    }

    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeSuperMethodInvocationNode(SuperMethodInvocationNode node, PNew p)
    {
        POrig porig = before(p);
        ROrig rorig = this.backingOp.executeSuperMethodInvocationNode(node, porig);
        return after(rorig);
    }

    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeSuperclassConstructorInvocationNode(SuperclassConstructorInvocationNode node, PNew p)
    {
        POrig porig = before(p);
        ROrig rorig = this.backingOp.executeSuperclassConstructorInvocationNode(node, porig);
        return after(rorig);
    }

    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeSwitchNode(SwitchNode node, PNew p)
    {
        POrig porig = before(p);
        ROrig rorig = this.backingOp.executeSwitchNode(node, porig);
        return after(rorig);
    }

    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeSynchronizedNode(SynchronizedNode node, PNew p)
    {
        POrig porig = before(p);
        ROrig rorig = this.backingOp.executeSynchronizedNode(node, porig);
        return after(rorig);
    }

    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeThisNode(ThisNode node, PNew p)
    {
        POrig porig = before(p);
        ROrig rorig = this.backingOp.executeThisNode(node, porig);
        return after(rorig);
    }

    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeThrowNode(ThrowNode node, PNew p)
    {
        POrig porig = before(p);
        ROrig rorig = this.backingOp.executeThrowNode(node, porig);
        return after(rorig);
    }

    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeTryNode(TryNode node, PNew p)
    {
        POrig porig = before(p);
        ROrig rorig = this.backingOp.executeTryNode(node, porig);
        return after(rorig);
    }

    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeTypeArgumentListNode(TypeArgumentListNode node, PNew p)
    {
        POrig porig = before(p);
        ROrig rorig = this.backingOp.executeTypeArgumentListNode(node, porig);
        return after(rorig);
    }

    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeTypeCastNode(TypeCastNode node, PNew p)
    {
        POrig porig = before(p);
        ROrig rorig = this.backingOp.executeTypeCastNode(node, porig);
        return after(rorig);
    }

    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeTypeDeclarationListNode(TypeDeclarationListNode node, PNew p)
    {
        POrig porig = before(p);
        ROrig rorig = this.backingOp.executeTypeDeclarationListNode(node, porig);
        return after(rorig);
    }

    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeTypeDeclarationMetaprogramAnchorNode(TypeDeclarationMetaprogramAnchorNode node, PNew p)
    {
        POrig porig = before(p);
        ROrig rorig = this.backingOp.executeTypeDeclarationMetaprogramAnchorNode(node, porig);
        return after(rorig);
    }

    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeTypeListNode(TypeListNode node, PNew p)
    {
        POrig porig = before(p);
        ROrig rorig = this.backingOp.executeTypeListNode(node, porig);
        return after(rorig);
    }

    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeTypeParameterListNode(TypeParameterListNode node, PNew p)
    {
        POrig porig = before(p);
        ROrig rorig = this.backingOp.executeTypeParameterListNode(node, porig);
        return after(rorig);
    }

    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeTypeParameterNode(TypeParameterNode node, PNew p)
    {
        POrig porig = before(p);
        ROrig rorig = this.backingOp.executeTypeParameterNode(node, porig);
        return after(rorig);
    }

    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeUnaryExpressionNode(UnaryExpressionNode node, PNew p)
    {
        POrig porig = before(p);
        ROrig rorig = this.backingOp.executeUnaryExpressionNode(node, porig);
        return after(rorig);
    }

    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeUnaryStatementExpressionNode(UnaryStatementExpressionNode node, PNew p)
    {
        POrig porig = before(p);
        ROrig rorig = this.backingOp.executeUnaryStatementExpressionNode(node, porig);
        return after(rorig);
    }

    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeUnparameterizedTypeListNode(UnparameterizedTypeListNode node, PNew p)
    {
        POrig porig = before(p);
        ROrig rorig = this.backingOp.executeUnparameterizedTypeListNode(node, porig);
        return after(rorig);
    }

    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeUnparameterizedTypeNode(UnparameterizedTypeNode node, PNew p)
    {
        POrig porig = before(p);
        ROrig rorig = this.backingOp.executeUnparameterizedTypeNode(node, porig);
        return after(rorig);
    }

    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeUnqualifiedClassInstantiationNode(UnqualifiedClassInstantiationNode node, PNew p)
    {
        POrig porig = before(p);
        ROrig rorig = this.backingOp.executeUnqualifiedClassInstantiationNode(node, porig);
        return after(rorig);
    }

    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeVariableDeclarationNode(VariableDeclarationNode node, PNew p)
    {
        POrig porig = before(p);
        ROrig rorig = this.backingOp.executeVariableDeclarationNode(node, porig);
        return after(rorig);
    }

    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeVariableDeclaratorListNode(VariableDeclaratorListNode node, PNew p)
    {
        POrig porig = before(p);
        ROrig rorig = this.backingOp.executeVariableDeclaratorListNode(node, porig);
        return after(rorig);
    }

    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeVariableDeclaratorNode(VariableDeclaratorNode node, PNew p)
    {
        POrig porig = before(p);
        ROrig rorig = this.backingOp.executeVariableDeclaratorNode(node, porig);
        return after(rorig);
    }

    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeVariableInitializerListNode(VariableInitializerListNode node, PNew p)
    {
        POrig porig = before(p);
        ROrig rorig = this.backingOp.executeVariableInitializerListNode(node, porig);
        return after(rorig);
    }

    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeVariableListNode(VariableListNode node, PNew p)
    {
        POrig porig = before(p);
        ROrig rorig = this.backingOp.executeVariableListNode(node, porig);
        return after(rorig);
    }

    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeVariableModifiersNode(VariableModifiersNode node, PNew p)
    {
        POrig porig = before(p);
        ROrig rorig = this.backingOp.executeVariableModifiersNode(node, porig);
        return after(rorig);
    }

    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeVariableNode(VariableNode node, PNew p)
    {
        POrig porig = before(p);
        ROrig rorig = this.backingOp.executeVariableNode(node, porig);
        return after(rorig);
    }

    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeVoidTypeNode(VoidTypeNode node, PNew p)
    {
        POrig porig = before(p);
        ROrig rorig = this.backingOp.executeVoidTypeNode(node, porig);
        return after(rorig);
    }

    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeWhileLoopNode(WhileLoopNode node, PNew p)
    {
        POrig porig = before(p);
        ROrig rorig = this.backingOp.executeWhileLoopNode(node, porig);
        return after(rorig);
    }

    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeWildcardTypeNode(WildcardTypeNode node, PNew p)
    {
        POrig porig = before(p);
        ROrig rorig = this.backingOp.executeWildcardTypeNode(node, porig);
        return after(rorig);
    }

}
