/*
 * WARNING: THIS FILE IS GENERATED.  Do not make any changes to this file
 * directly; it was generated from the BSJ source generator project.  If changes
 * are necessary, changes must be applied either to the source generator
 * application or to one of its data files.  The source generator's fully
 * qualified name is edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator.
 */

package edu.jhu.cs.bsj.compiler.ast.util;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjAbortableNodeOperation2Arguments;
import edu.jhu.cs.bsj.compiler.ast.node.*;
import edu.jhu.cs.bsj.compiler.ast.node.list.AnnotationElementListNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.AnnotationListNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.AnnotationMemberListNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.AnnotationValueListNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.AnonymousClassMemberListNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.BlockStatementListNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.CaseListNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.CatchListNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.ClassMemberListNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.DeclaredTypeListNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.EnumConstantDeclarationListNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.ExpressionListNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.IdentifierListNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.ImportListNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.InterfaceMemberListNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.ReferenceTypeListNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.StatementExpressionListNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.TypeArgumentListNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.TypeDeclarationListNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.TypeParameterListNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.UnparameterizedTypeListNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.VariableDeclaratorListNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.VariableInitializerListNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.VariableListNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.AnnotationMemberMetaprogramAnchorNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.AnonymousClassMemberMetaprogramAnchorNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.BlockStatementMetaprogramAnchorNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.ClassMemberMetaprogramAnchorNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.CodeLiteralNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.InterfaceMemberMetaprogramAnchorNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaAnnotationArrayValueNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaAnnotationElementListNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaAnnotationElementNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaAnnotationExpressionValueNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaAnnotationListNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaAnnotationMetaAnnotationValueNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaAnnotationMetaprogramAnchorNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaAnnotationValueListNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramDependencyDeclarationListNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramDependencyDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramDependencyListNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramDependencyNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramImportListNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramImportNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramPreambleNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramTargetListNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramTargetNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.NormalMetaAnnotationNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.RawCodeLiteralNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.SingleElementMetaAnnotationNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.SpliceNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.TypeDeclarationMetaprogramAnchorNode;

/**
 * This implementation of the BSJ node operation decorates every method of a backing
 * operation with a uniform before and after call.  This permits allows proxying, adjusting
 * or logging the parameters and results of calls, or adaptation of the backing operation
 * to a different set of data types.  Note that only the first call is proxied; if the
 * backing operation calls itself, those calls are not intercepted.
 *
 * @param <P1Orig> A data parameter type for the original backing operation.
 * @param <P2Orig> A data parameter type for the original backing operation.
 * @param <ROrig> The return type for the original backing operation.
 * @param <P1New> A data parameter type for the new decorated operation.
 * @param <P2New> A data parameter type for the new decorated operation.
 * @param <RNew> The return type for the decorated operation.
 *
 * @author Zachary Palmer
 */

@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public abstract class BsjAbortableNodeOperationProxy2Arguments<P1Orig,P2Orig,ROrig,P1New,P2New,RNew,X extends Exception> implements BsjAbortableNodeOperation2Arguments<P1New,P2New,RNew,X>
{
    /** The backing operation to proxy. */
    private BsjAbortableNodeOperation2Arguments<P1Orig,P2Orig,ROrig,X> backingOp;
    
    /**
     * Creates a new node operation proxy.
     * @param backingOp The backing operation to proxy.
     */
    public BsjAbortableNodeOperationProxy2Arguments(BsjAbortableNodeOperation2Arguments<P1Orig,P2Orig,ROrig,X> backingOp)
    {
        this.backingOp = backingOp;
    }
    
    /**
     * Called before every call to the backing operation.
     * @param p The incoming parameter data (compatible with the proxy interface).
     * @return The resulting parameter data (compatible with the backing interface).
     */
    protected abstract P1Orig before1(P1New p1) throws X;
    
    /**
     * Called before every call to the backing operation.
     * @param p The incoming parameter data (compatible with the proxy interface).
     * @return The resulting parameter data (compatible with the backing interface).
     */
    protected abstract P2Orig before2(P2New p2) throws X;
    
    /**
     * Called after every call to the backing operation.
     * @param r The incoming return data (compatible with the backing interface).
     * @return The resulting return data (compatible with the return interface).
     */
    protected abstract RNew after(ROrig r) throws X;
    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeAlternateConstructorInvocationNode(AlternateConstructorInvocationNode node, P1New p1, P2New p2) throws X
    {
        P1Orig p1orig = before1(p1);
        P2Orig p2orig = before2(p2);
        ROrig rorig = this.backingOp.executeAlternateConstructorInvocationNode(node, p1orig, p2orig);
        return after(rorig);
    }
    
    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeAnnotationAnnotationValueNode(AnnotationAnnotationValueNode node, P1New p1, P2New p2) throws X
    {
        P1Orig p1orig = before1(p1);
        P2Orig p2orig = before2(p2);
        ROrig rorig = this.backingOp.executeAnnotationAnnotationValueNode(node, p1orig, p2orig);
        return after(rorig);
    }
    
    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeAnnotationArrayValueNode(AnnotationArrayValueNode node, P1New p1, P2New p2) throws X
    {
        P1Orig p1orig = before1(p1);
        P2Orig p2orig = before2(p2);
        ROrig rorig = this.backingOp.executeAnnotationArrayValueNode(node, p1orig, p2orig);
        return after(rorig);
    }
    
    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeAnnotationBodyNode(AnnotationBodyNode node, P1New p1, P2New p2) throws X
    {
        P1Orig p1orig = before1(p1);
        P2Orig p2orig = before2(p2);
        ROrig rorig = this.backingOp.executeAnnotationBodyNode(node, p1orig, p2orig);
        return after(rorig);
    }
    
    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeAnnotationDeclarationNode(AnnotationDeclarationNode node, P1New p1, P2New p2) throws X
    {
        P1Orig p1orig = before1(p1);
        P2Orig p2orig = before2(p2);
        ROrig rorig = this.backingOp.executeAnnotationDeclarationNode(node, p1orig, p2orig);
        return after(rorig);
    }
    
    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeAnnotationElementListNode(AnnotationElementListNode node, P1New p1, P2New p2) throws X
    {
        P1Orig p1orig = before1(p1);
        P2Orig p2orig = before2(p2);
        ROrig rorig = this.backingOp.executeAnnotationElementListNode(node, p1orig, p2orig);
        return after(rorig);
    }
    
    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeAnnotationElementNode(AnnotationElementNode node, P1New p1, P2New p2) throws X
    {
        P1Orig p1orig = before1(p1);
        P2Orig p2orig = before2(p2);
        ROrig rorig = this.backingOp.executeAnnotationElementNode(node, p1orig, p2orig);
        return after(rorig);
    }
    
    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeAnnotationExpressionValueNode(AnnotationExpressionValueNode node, P1New p1, P2New p2) throws X
    {
        P1Orig p1orig = before1(p1);
        P2Orig p2orig = before2(p2);
        ROrig rorig = this.backingOp.executeAnnotationExpressionValueNode(node, p1orig, p2orig);
        return after(rorig);
    }
    
    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeAnnotationListNode(AnnotationListNode node, P1New p1, P2New p2) throws X
    {
        P1Orig p1orig = before1(p1);
        P2Orig p2orig = before2(p2);
        ROrig rorig = this.backingOp.executeAnnotationListNode(node, p1orig, p2orig);
        return after(rorig);
    }
    
    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeAnnotationMemberListNode(AnnotationMemberListNode node, P1New p1, P2New p2) throws X
    {
        P1Orig p1orig = before1(p1);
        P2Orig p2orig = before2(p2);
        ROrig rorig = this.backingOp.executeAnnotationMemberListNode(node, p1orig, p2orig);
        return after(rorig);
    }
    
    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeAnnotationMemberMetaprogramAnchorNode(AnnotationMemberMetaprogramAnchorNode node, P1New p1, P2New p2) throws X
    {
        P1Orig p1orig = before1(p1);
        P2Orig p2orig = before2(p2);
        ROrig rorig = this.backingOp.executeAnnotationMemberMetaprogramAnchorNode(node, p1orig, p2orig);
        return after(rorig);
    }
    
    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeAnnotationMethodDeclarationNode(AnnotationMethodDeclarationNode node, P1New p1, P2New p2) throws X
    {
        P1Orig p1orig = before1(p1);
        P2Orig p2orig = before2(p2);
        ROrig rorig = this.backingOp.executeAnnotationMethodDeclarationNode(node, p1orig, p2orig);
        return after(rorig);
    }
    
    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeAnnotationMethodModifiersNode(AnnotationMethodModifiersNode node, P1New p1, P2New p2) throws X
    {
        P1Orig p1orig = before1(p1);
        P2Orig p2orig = before2(p2);
        ROrig rorig = this.backingOp.executeAnnotationMethodModifiersNode(node, p1orig, p2orig);
        return after(rorig);
    }
    
    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeAnnotationModifiersNode(AnnotationModifiersNode node, P1New p1, P2New p2) throws X
    {
        P1Orig p1orig = before1(p1);
        P2Orig p2orig = before2(p2);
        ROrig rorig = this.backingOp.executeAnnotationModifiersNode(node, p1orig, p2orig);
        return after(rorig);
    }
    
    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeAnnotationValueListNode(AnnotationValueListNode node, P1New p1, P2New p2) throws X
    {
        P1Orig p1orig = before1(p1);
        P2Orig p2orig = before2(p2);
        ROrig rorig = this.backingOp.executeAnnotationValueListNode(node, p1orig, p2orig);
        return after(rorig);
    }
    
    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeAnonymousClassBodyNode(AnonymousClassBodyNode node, P1New p1, P2New p2) throws X
    {
        P1Orig p1orig = before1(p1);
        P2Orig p2orig = before2(p2);
        ROrig rorig = this.backingOp.executeAnonymousClassBodyNode(node, p1orig, p2orig);
        return after(rorig);
    }
    
    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeAnonymousClassMemberListNode(AnonymousClassMemberListNode node, P1New p1, P2New p2) throws X
    {
        P1Orig p1orig = before1(p1);
        P2Orig p2orig = before2(p2);
        ROrig rorig = this.backingOp.executeAnonymousClassMemberListNode(node, p1orig, p2orig);
        return after(rorig);
    }
    
    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeAnonymousClassMemberMetaprogramAnchorNode(AnonymousClassMemberMetaprogramAnchorNode node, P1New p1, P2New p2) throws X
    {
        P1Orig p1orig = before1(p1);
        P2Orig p2orig = before2(p2);
        ROrig rorig = this.backingOp.executeAnonymousClassMemberMetaprogramAnchorNode(node, p1orig, p2orig);
        return after(rorig);
    }
    
    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeArrayAccessNode(ArrayAccessNode node, P1New p1, P2New p2) throws X
    {
        P1Orig p1orig = before1(p1);
        P2Orig p2orig = before2(p2);
        ROrig rorig = this.backingOp.executeArrayAccessNode(node, p1orig, p2orig);
        return after(rorig);
    }
    
    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeArrayInitializerCreationNode(ArrayInitializerCreationNode node, P1New p1, P2New p2) throws X
    {
        P1Orig p1orig = before1(p1);
        P2Orig p2orig = before2(p2);
        ROrig rorig = this.backingOp.executeArrayInitializerCreationNode(node, p1orig, p2orig);
        return after(rorig);
    }
    
    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeArrayInitializerNode(ArrayInitializerNode node, P1New p1, P2New p2) throws X
    {
        P1Orig p1orig = before1(p1);
        P2Orig p2orig = before2(p2);
        ROrig rorig = this.backingOp.executeArrayInitializerNode(node, p1orig, p2orig);
        return after(rorig);
    }
    
    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeArrayInstantiatorCreationNode(ArrayInstantiatorCreationNode node, P1New p1, P2New p2) throws X
    {
        P1Orig p1orig = before1(p1);
        P2Orig p2orig = before2(p2);
        ROrig rorig = this.backingOp.executeArrayInstantiatorCreationNode(node, p1orig, p2orig);
        return after(rorig);
    }
    
    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeArrayTypeNode(ArrayTypeNode node, P1New p1, P2New p2) throws X
    {
        P1Orig p1orig = before1(p1);
        P2Orig p2orig = before2(p2);
        ROrig rorig = this.backingOp.executeArrayTypeNode(node, p1orig, p2orig);
        return after(rorig);
    }
    
    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeAssertStatementNode(AssertStatementNode node, P1New p1, P2New p2) throws X
    {
        P1Orig p1orig = before1(p1);
        P2Orig p2orig = before2(p2);
        ROrig rorig = this.backingOp.executeAssertStatementNode(node, p1orig, p2orig);
        return after(rorig);
    }
    
    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeAssignmentNode(AssignmentNode node, P1New p1, P2New p2) throws X
    {
        P1Orig p1orig = before1(p1);
        P2Orig p2orig = before2(p2);
        ROrig rorig = this.backingOp.executeAssignmentNode(node, p1orig, p2orig);
        return after(rorig);
    }
    
    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeBinaryExpressionNode(BinaryExpressionNode node, P1New p1, P2New p2) throws X
    {
        P1Orig p1orig = before1(p1);
        P2Orig p2orig = before2(p2);
        ROrig rorig = this.backingOp.executeBinaryExpressionNode(node, p1orig, p2orig);
        return after(rorig);
    }
    
    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeBlockNode(BlockNode node, P1New p1, P2New p2) throws X
    {
        P1Orig p1orig = before1(p1);
        P2Orig p2orig = before2(p2);
        ROrig rorig = this.backingOp.executeBlockNode(node, p1orig, p2orig);
        return after(rorig);
    }
    
    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeBlockStatementListNode(BlockStatementListNode node, P1New p1, P2New p2) throws X
    {
        P1Orig p1orig = before1(p1);
        P2Orig p2orig = before2(p2);
        ROrig rorig = this.backingOp.executeBlockStatementListNode(node, p1orig, p2orig);
        return after(rorig);
    }
    
    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeBlockStatementMetaprogramAnchorNode(BlockStatementMetaprogramAnchorNode node, P1New p1, P2New p2) throws X
    {
        P1Orig p1orig = before1(p1);
        P2Orig p2orig = before2(p2);
        ROrig rorig = this.backingOp.executeBlockStatementMetaprogramAnchorNode(node, p1orig, p2orig);
        return after(rorig);
    }
    
    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeBooleanLiteralNode(BooleanLiteralNode node, P1New p1, P2New p2) throws X
    {
        P1Orig p1orig = before1(p1);
        P2Orig p2orig = before2(p2);
        ROrig rorig = this.backingOp.executeBooleanLiteralNode(node, p1orig, p2orig);
        return after(rorig);
    }
    
    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeBreakNode(BreakNode node, P1New p1, P2New p2) throws X
    {
        P1Orig p1orig = before1(p1);
        P2Orig p2orig = before2(p2);
        ROrig rorig = this.backingOp.executeBreakNode(node, p1orig, p2orig);
        return after(rorig);
    }
    
    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeCaseListNode(CaseListNode node, P1New p1, P2New p2) throws X
    {
        P1Orig p1orig = before1(p1);
        P2Orig p2orig = before2(p2);
        ROrig rorig = this.backingOp.executeCaseListNode(node, p1orig, p2orig);
        return after(rorig);
    }
    
    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeCaseNode(CaseNode node, P1New p1, P2New p2) throws X
    {
        P1Orig p1orig = before1(p1);
        P2Orig p2orig = before2(p2);
        ROrig rorig = this.backingOp.executeCaseNode(node, p1orig, p2orig);
        return after(rorig);
    }
    
    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeCatchListNode(CatchListNode node, P1New p1, P2New p2) throws X
    {
        P1Orig p1orig = before1(p1);
        P2Orig p2orig = before2(p2);
        ROrig rorig = this.backingOp.executeCatchListNode(node, p1orig, p2orig);
        return after(rorig);
    }
    
    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeCatchNode(CatchNode node, P1New p1, P2New p2) throws X
    {
        P1Orig p1orig = before1(p1);
        P2Orig p2orig = before2(p2);
        ROrig rorig = this.backingOp.executeCatchNode(node, p1orig, p2orig);
        return after(rorig);
    }
    
    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeCharLiteralNode(CharLiteralNode node, P1New p1, P2New p2) throws X
    {
        P1Orig p1orig = before1(p1);
        P2Orig p2orig = before2(p2);
        ROrig rorig = this.backingOp.executeCharLiteralNode(node, p1orig, p2orig);
        return after(rorig);
    }
    
    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeClassBodyNode(ClassBodyNode node, P1New p1, P2New p2) throws X
    {
        P1Orig p1orig = before1(p1);
        P2Orig p2orig = before2(p2);
        ROrig rorig = this.backingOp.executeClassBodyNode(node, p1orig, p2orig);
        return after(rorig);
    }
    
    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeClassDeclarationNode(ClassDeclarationNode node, P1New p1, P2New p2) throws X
    {
        P1Orig p1orig = before1(p1);
        P2Orig p2orig = before2(p2);
        ROrig rorig = this.backingOp.executeClassDeclarationNode(node, p1orig, p2orig);
        return after(rorig);
    }
    
    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeClassLiteralNode(ClassLiteralNode node, P1New p1, P2New p2) throws X
    {
        P1Orig p1orig = before1(p1);
        P2Orig p2orig = before2(p2);
        ROrig rorig = this.backingOp.executeClassLiteralNode(node, p1orig, p2orig);
        return after(rorig);
    }
    
    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeClassMemberListNode(ClassMemberListNode node, P1New p1, P2New p2) throws X
    {
        P1Orig p1orig = before1(p1);
        P2Orig p2orig = before2(p2);
        ROrig rorig = this.backingOp.executeClassMemberListNode(node, p1orig, p2orig);
        return after(rorig);
    }
    
    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeClassMemberMetaprogramAnchorNode(ClassMemberMetaprogramAnchorNode node, P1New p1, P2New p2) throws X
    {
        P1Orig p1orig = before1(p1);
        P2Orig p2orig = before2(p2);
        ROrig rorig = this.backingOp.executeClassMemberMetaprogramAnchorNode(node, p1orig, p2orig);
        return after(rorig);
    }
    
    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeClassModifiersNode(ClassModifiersNode node, P1New p1, P2New p2) throws X
    {
        P1Orig p1orig = before1(p1);
        P2Orig p2orig = before2(p2);
        ROrig rorig = this.backingOp.executeClassModifiersNode(node, p1orig, p2orig);
        return after(rorig);
    }
    
    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeCodeLiteralNode(CodeLiteralNode node, P1New p1, P2New p2) throws X
    {
        P1Orig p1orig = before1(p1);
        P2Orig p2orig = before2(p2);
        ROrig rorig = this.backingOp.executeCodeLiteralNode(node, p1orig, p2orig);
        return after(rorig);
    }
    
    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeCompilationUnitNode(CompilationUnitNode node, P1New p1, P2New p2) throws X
    {
        P1Orig p1orig = before1(p1);
        P2Orig p2orig = before2(p2);
        ROrig rorig = this.backingOp.executeCompilationUnitNode(node, p1orig, p2orig);
        return after(rorig);
    }
    
    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeConditionalExpressionNode(ConditionalExpressionNode node, P1New p1, P2New p2) throws X
    {
        P1Orig p1orig = before1(p1);
        P2Orig p2orig = before2(p2);
        ROrig rorig = this.backingOp.executeConditionalExpressionNode(node, p1orig, p2orig);
        return after(rorig);
    }
    
    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeConstantDeclarationNode(ConstantDeclarationNode node, P1New p1, P2New p2) throws X
    {
        P1Orig p1orig = before1(p1);
        P2Orig p2orig = before2(p2);
        ROrig rorig = this.backingOp.executeConstantDeclarationNode(node, p1orig, p2orig);
        return after(rorig);
    }
    
    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeConstantModifiersNode(ConstantModifiersNode node, P1New p1, P2New p2) throws X
    {
        P1Orig p1orig = before1(p1);
        P2Orig p2orig = before2(p2);
        ROrig rorig = this.backingOp.executeConstantModifiersNode(node, p1orig, p2orig);
        return after(rorig);
    }
    
    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeConstructorBodyNode(ConstructorBodyNode node, P1New p1, P2New p2) throws X
    {
        P1Orig p1orig = before1(p1);
        P2Orig p2orig = before2(p2);
        ROrig rorig = this.backingOp.executeConstructorBodyNode(node, p1orig, p2orig);
        return after(rorig);
    }
    
    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeConstructorDeclarationNode(ConstructorDeclarationNode node, P1New p1, P2New p2) throws X
    {
        P1Orig p1orig = before1(p1);
        P2Orig p2orig = before2(p2);
        ROrig rorig = this.backingOp.executeConstructorDeclarationNode(node, p1orig, p2orig);
        return after(rorig);
    }
    
    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeConstructorModifiersNode(ConstructorModifiersNode node, P1New p1, P2New p2) throws X
    {
        P1Orig p1orig = before1(p1);
        P2Orig p2orig = before2(p2);
        ROrig rorig = this.backingOp.executeConstructorModifiersNode(node, p1orig, p2orig);
        return after(rorig);
    }
    
    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeContinueNode(ContinueNode node, P1New p1, P2New p2) throws X
    {
        P1Orig p1orig = before1(p1);
        P2Orig p2orig = before2(p2);
        ROrig rorig = this.backingOp.executeContinueNode(node, p1orig, p2orig);
        return after(rorig);
    }
    
    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeDeclaredTypeListNode(DeclaredTypeListNode node, P1New p1, P2New p2) throws X
    {
        P1Orig p1orig = before1(p1);
        P2Orig p2orig = before2(p2);
        ROrig rorig = this.backingOp.executeDeclaredTypeListNode(node, p1orig, p2orig);
        return after(rorig);
    }
    
    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeDoWhileLoopNode(DoWhileLoopNode node, P1New p1, P2New p2) throws X
    {
        P1Orig p1orig = before1(p1);
        P2Orig p2orig = before2(p2);
        ROrig rorig = this.backingOp.executeDoWhileLoopNode(node, p1orig, p2orig);
        return after(rorig);
    }
    
    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeDoubleLiteralNode(DoubleLiteralNode node, P1New p1, P2New p2) throws X
    {
        P1Orig p1orig = before1(p1);
        P2Orig p2orig = before2(p2);
        ROrig rorig = this.backingOp.executeDoubleLiteralNode(node, p1orig, p2orig);
        return after(rorig);
    }
    
    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeEnhancedForLoopNode(EnhancedForLoopNode node, P1New p1, P2New p2) throws X
    {
        P1Orig p1orig = before1(p1);
        P2Orig p2orig = before2(p2);
        ROrig rorig = this.backingOp.executeEnhancedForLoopNode(node, p1orig, p2orig);
        return after(rorig);
    }
    
    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeEnumBodyNode(EnumBodyNode node, P1New p1, P2New p2) throws X
    {
        P1Orig p1orig = before1(p1);
        P2Orig p2orig = before2(p2);
        ROrig rorig = this.backingOp.executeEnumBodyNode(node, p1orig, p2orig);
        return after(rorig);
    }
    
    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeEnumConstantDeclarationListNode(EnumConstantDeclarationListNode node, P1New p1, P2New p2) throws X
    {
        P1Orig p1orig = before1(p1);
        P2Orig p2orig = before2(p2);
        ROrig rorig = this.backingOp.executeEnumConstantDeclarationListNode(node, p1orig, p2orig);
        return after(rorig);
    }
    
    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeEnumConstantDeclarationNode(EnumConstantDeclarationNode node, P1New p1, P2New p2) throws X
    {
        P1Orig p1orig = before1(p1);
        P2Orig p2orig = before2(p2);
        ROrig rorig = this.backingOp.executeEnumConstantDeclarationNode(node, p1orig, p2orig);
        return after(rorig);
    }
    
    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeEnumConstantModifiersNode(EnumConstantModifiersNode node, P1New p1, P2New p2) throws X
    {
        P1Orig p1orig = before1(p1);
        P2Orig p2orig = before2(p2);
        ROrig rorig = this.backingOp.executeEnumConstantModifiersNode(node, p1orig, p2orig);
        return after(rorig);
    }
    
    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeEnumDeclarationNode(EnumDeclarationNode node, P1New p1, P2New p2) throws X
    {
        P1Orig p1orig = before1(p1);
        P2Orig p2orig = before2(p2);
        ROrig rorig = this.backingOp.executeEnumDeclarationNode(node, p1orig, p2orig);
        return after(rorig);
    }
    
    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeEnumModifiersNode(EnumModifiersNode node, P1New p1, P2New p2) throws X
    {
        P1Orig p1orig = before1(p1);
        P2Orig p2orig = before2(p2);
        ROrig rorig = this.backingOp.executeEnumModifiersNode(node, p1orig, p2orig);
        return after(rorig);
    }
    
    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeExpressionListNode(ExpressionListNode node, P1New p1, P2New p2) throws X
    {
        P1Orig p1orig = before1(p1);
        P2Orig p2orig = before2(p2);
        ROrig rorig = this.backingOp.executeExpressionListNode(node, p1orig, p2orig);
        return after(rorig);
    }
    
    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeExpressionStatementNode(ExpressionStatementNode node, P1New p1, P2New p2) throws X
    {
        P1Orig p1orig = before1(p1);
        P2Orig p2orig = before2(p2);
        ROrig rorig = this.backingOp.executeExpressionStatementNode(node, p1orig, p2orig);
        return after(rorig);
    }
    
    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeFieldDeclarationNode(FieldDeclarationNode node, P1New p1, P2New p2) throws X
    {
        P1Orig p1orig = before1(p1);
        P2Orig p2orig = before2(p2);
        ROrig rorig = this.backingOp.executeFieldDeclarationNode(node, p1orig, p2orig);
        return after(rorig);
    }
    
    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeFieldModifiersNode(FieldModifiersNode node, P1New p1, P2New p2) throws X
    {
        P1Orig p1orig = before1(p1);
        P2Orig p2orig = before2(p2);
        ROrig rorig = this.backingOp.executeFieldModifiersNode(node, p1orig, p2orig);
        return after(rorig);
    }
    
    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeFloatLiteralNode(FloatLiteralNode node, P1New p1, P2New p2) throws X
    {
        P1Orig p1orig = before1(p1);
        P2Orig p2orig = before2(p2);
        ROrig rorig = this.backingOp.executeFloatLiteralNode(node, p1orig, p2orig);
        return after(rorig);
    }
    
    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeForInitializerDeclarationNode(ForInitializerDeclarationNode node, P1New p1, P2New p2) throws X
    {
        P1Orig p1orig = before1(p1);
        P2Orig p2orig = before2(p2);
        ROrig rorig = this.backingOp.executeForInitializerDeclarationNode(node, p1orig, p2orig);
        return after(rorig);
    }
    
    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeForInitializerExpressionNode(ForInitializerExpressionNode node, P1New p1, P2New p2) throws X
    {
        P1Orig p1orig = before1(p1);
        P2Orig p2orig = before2(p2);
        ROrig rorig = this.backingOp.executeForInitializerExpressionNode(node, p1orig, p2orig);
        return after(rorig);
    }
    
    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeForLoopNode(ForLoopNode node, P1New p1, P2New p2) throws X
    {
        P1Orig p1orig = before1(p1);
        P2Orig p2orig = before2(p2);
        ROrig rorig = this.backingOp.executeForLoopNode(node, p1orig, p2orig);
        return after(rorig);
    }
    
    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeIdentifierListNode(IdentifierListNode node, P1New p1, P2New p2) throws X
    {
        P1Orig p1orig = before1(p1);
        P2Orig p2orig = before2(p2);
        ROrig rorig = this.backingOp.executeIdentifierListNode(node, p1orig, p2orig);
        return after(rorig);
    }
    
    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeIdentifierNode(IdentifierNode node, P1New p1, P2New p2) throws X
    {
        P1Orig p1orig = before1(p1);
        P2Orig p2orig = before2(p2);
        ROrig rorig = this.backingOp.executeIdentifierNode(node, p1orig, p2orig);
        return after(rorig);
    }
    
    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeIfNode(IfNode node, P1New p1, P2New p2) throws X
    {
        P1Orig p1orig = before1(p1);
        P2Orig p2orig = before2(p2);
        ROrig rorig = this.backingOp.executeIfNode(node, p1orig, p2orig);
        return after(rorig);
    }
    
    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeImportListNode(ImportListNode node, P1New p1, P2New p2) throws X
    {
        P1Orig p1orig = before1(p1);
        P2Orig p2orig = before2(p2);
        ROrig rorig = this.backingOp.executeImportListNode(node, p1orig, p2orig);
        return after(rorig);
    }
    
    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeImportOnDemandNode(ImportOnDemandNode node, P1New p1, P2New p2) throws X
    {
        P1Orig p1orig = before1(p1);
        P2Orig p2orig = before2(p2);
        ROrig rorig = this.backingOp.executeImportOnDemandNode(node, p1orig, p2orig);
        return after(rorig);
    }
    
    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeImportSingleTypeNode(ImportSingleTypeNode node, P1New p1, P2New p2) throws X
    {
        P1Orig p1orig = before1(p1);
        P2Orig p2orig = before2(p2);
        ROrig rorig = this.backingOp.executeImportSingleTypeNode(node, p1orig, p2orig);
        return after(rorig);
    }
    
    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeInitializerDeclarationNode(InitializerDeclarationNode node, P1New p1, P2New p2) throws X
    {
        P1Orig p1orig = before1(p1);
        P2Orig p2orig = before2(p2);
        ROrig rorig = this.backingOp.executeInitializerDeclarationNode(node, p1orig, p2orig);
        return after(rorig);
    }
    
    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeInstanceOfNode(InstanceOfNode node, P1New p1, P2New p2) throws X
    {
        P1Orig p1orig = before1(p1);
        P2Orig p2orig = before2(p2);
        ROrig rorig = this.backingOp.executeInstanceOfNode(node, p1orig, p2orig);
        return after(rorig);
    }
    
    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeIntLiteralNode(IntLiteralNode node, P1New p1, P2New p2) throws X
    {
        P1Orig p1orig = before1(p1);
        P2Orig p2orig = before2(p2);
        ROrig rorig = this.backingOp.executeIntLiteralNode(node, p1orig, p2orig);
        return after(rorig);
    }
    
    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeInterfaceBodyNode(InterfaceBodyNode node, P1New p1, P2New p2) throws X
    {
        P1Orig p1orig = before1(p1);
        P2Orig p2orig = before2(p2);
        ROrig rorig = this.backingOp.executeInterfaceBodyNode(node, p1orig, p2orig);
        return after(rorig);
    }
    
    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeInterfaceDeclarationNode(InterfaceDeclarationNode node, P1New p1, P2New p2) throws X
    {
        P1Orig p1orig = before1(p1);
        P2Orig p2orig = before2(p2);
        ROrig rorig = this.backingOp.executeInterfaceDeclarationNode(node, p1orig, p2orig);
        return after(rorig);
    }
    
    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeInterfaceMemberListNode(InterfaceMemberListNode node, P1New p1, P2New p2) throws X
    {
        P1Orig p1orig = before1(p1);
        P2Orig p2orig = before2(p2);
        ROrig rorig = this.backingOp.executeInterfaceMemberListNode(node, p1orig, p2orig);
        return after(rorig);
    }
    
    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeInterfaceMemberMetaprogramAnchorNode(InterfaceMemberMetaprogramAnchorNode node, P1New p1, P2New p2) throws X
    {
        P1Orig p1orig = before1(p1);
        P2Orig p2orig = before2(p2);
        ROrig rorig = this.backingOp.executeInterfaceMemberMetaprogramAnchorNode(node, p1orig, p2orig);
        return after(rorig);
    }
    
    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeInterfaceModifiersNode(InterfaceModifiersNode node, P1New p1, P2New p2) throws X
    {
        P1Orig p1orig = before1(p1);
        P2Orig p2orig = before2(p2);
        ROrig rorig = this.backingOp.executeInterfaceModifiersNode(node, p1orig, p2orig);
        return after(rorig);
    }
    
    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeJavadocNode(JavadocNode node, P1New p1, P2New p2) throws X
    {
        P1Orig p1orig = before1(p1);
        P2Orig p2orig = before2(p2);
        ROrig rorig = this.backingOp.executeJavadocNode(node, p1orig, p2orig);
        return after(rorig);
    }
    
    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeLabeledStatementNode(LabeledStatementNode node, P1New p1, P2New p2) throws X
    {
        P1Orig p1orig = before1(p1);
        P2Orig p2orig = before2(p2);
        ROrig rorig = this.backingOp.executeLabeledStatementNode(node, p1orig, p2orig);
        return after(rorig);
    }
    
    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeLocalClassDeclarationNode(LocalClassDeclarationNode node, P1New p1, P2New p2) throws X
    {
        P1Orig p1orig = before1(p1);
        P2Orig p2orig = before2(p2);
        ROrig rorig = this.backingOp.executeLocalClassDeclarationNode(node, p1orig, p2orig);
        return after(rorig);
    }
    
    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeLocalClassModifiersNode(LocalClassModifiersNode node, P1New p1, P2New p2) throws X
    {
        P1Orig p1orig = before1(p1);
        P2Orig p2orig = before2(p2);
        ROrig rorig = this.backingOp.executeLocalClassModifiersNode(node, p1orig, p2orig);
        return after(rorig);
    }
    
    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeLocalVariableDeclarationNode(LocalVariableDeclarationNode node, P1New p1, P2New p2) throws X
    {
        P1Orig p1orig = before1(p1);
        P2Orig p2orig = before2(p2);
        ROrig rorig = this.backingOp.executeLocalVariableDeclarationNode(node, p1orig, p2orig);
        return after(rorig);
    }
    
    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeLongLiteralNode(LongLiteralNode node, P1New p1, P2New p2) throws X
    {
        P1Orig p1orig = before1(p1);
        P2Orig p2orig = before2(p2);
        ROrig rorig = this.backingOp.executeLongLiteralNode(node, p1orig, p2orig);
        return after(rorig);
    }
    
    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeMetaAnnotationArrayValueNode(MetaAnnotationArrayValueNode node, P1New p1, P2New p2) throws X
    {
        P1Orig p1orig = before1(p1);
        P2Orig p2orig = before2(p2);
        ROrig rorig = this.backingOp.executeMetaAnnotationArrayValueNode(node, p1orig, p2orig);
        return after(rorig);
    }
    
    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeMetaAnnotationElementListNode(MetaAnnotationElementListNode node, P1New p1, P2New p2) throws X
    {
        P1Orig p1orig = before1(p1);
        P2Orig p2orig = before2(p2);
        ROrig rorig = this.backingOp.executeMetaAnnotationElementListNode(node, p1orig, p2orig);
        return after(rorig);
    }
    
    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeMetaAnnotationElementNode(MetaAnnotationElementNode node, P1New p1, P2New p2) throws X
    {
        P1Orig p1orig = before1(p1);
        P2Orig p2orig = before2(p2);
        ROrig rorig = this.backingOp.executeMetaAnnotationElementNode(node, p1orig, p2orig);
        return after(rorig);
    }
    
    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeMetaAnnotationExpressionValueNode(MetaAnnotationExpressionValueNode node, P1New p1, P2New p2) throws X
    {
        P1Orig p1orig = before1(p1);
        P2Orig p2orig = before2(p2);
        ROrig rorig = this.backingOp.executeMetaAnnotationExpressionValueNode(node, p1orig, p2orig);
        return after(rorig);
    }
    
    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeMetaAnnotationListNode(MetaAnnotationListNode node, P1New p1, P2New p2) throws X
    {
        P1Orig p1orig = before1(p1);
        P2Orig p2orig = before2(p2);
        ROrig rorig = this.backingOp.executeMetaAnnotationListNode(node, p1orig, p2orig);
        return after(rorig);
    }
    
    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeMetaAnnotationMetaAnnotationValueNode(MetaAnnotationMetaAnnotationValueNode node, P1New p1, P2New p2) throws X
    {
        P1Orig p1orig = before1(p1);
        P2Orig p2orig = before2(p2);
        ROrig rorig = this.backingOp.executeMetaAnnotationMetaAnnotationValueNode(node, p1orig, p2orig);
        return after(rorig);
    }
    
    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeMetaAnnotationMetaprogramAnchorNode(MetaAnnotationMetaprogramAnchorNode node, P1New p1, P2New p2) throws X
    {
        P1Orig p1orig = before1(p1);
        P2Orig p2orig = before2(p2);
        ROrig rorig = this.backingOp.executeMetaAnnotationMetaprogramAnchorNode(node, p1orig, p2orig);
        return after(rorig);
    }
    
    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeMetaAnnotationValueListNode(MetaAnnotationValueListNode node, P1New p1, P2New p2) throws X
    {
        P1Orig p1orig = before1(p1);
        P2Orig p2orig = before2(p2);
        ROrig rorig = this.backingOp.executeMetaAnnotationValueListNode(node, p1orig, p2orig);
        return after(rorig);
    }
    
    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeMetaprogramDependencyDeclarationListNode(MetaprogramDependencyDeclarationListNode node, P1New p1, P2New p2) throws X
    {
        P1Orig p1orig = before1(p1);
        P2Orig p2orig = before2(p2);
        ROrig rorig = this.backingOp.executeMetaprogramDependencyDeclarationListNode(node, p1orig, p2orig);
        return after(rorig);
    }
    
    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeMetaprogramDependencyDeclarationNode(MetaprogramDependencyDeclarationNode node, P1New p1, P2New p2) throws X
    {
        P1Orig p1orig = before1(p1);
        P2Orig p2orig = before2(p2);
        ROrig rorig = this.backingOp.executeMetaprogramDependencyDeclarationNode(node, p1orig, p2orig);
        return after(rorig);
    }
    
    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeMetaprogramDependencyListNode(MetaprogramDependencyListNode node, P1New p1, P2New p2) throws X
    {
        P1Orig p1orig = before1(p1);
        P2Orig p2orig = before2(p2);
        ROrig rorig = this.backingOp.executeMetaprogramDependencyListNode(node, p1orig, p2orig);
        return after(rorig);
    }
    
    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeMetaprogramDependencyNode(MetaprogramDependencyNode node, P1New p1, P2New p2) throws X
    {
        P1Orig p1orig = before1(p1);
        P2Orig p2orig = before2(p2);
        ROrig rorig = this.backingOp.executeMetaprogramDependencyNode(node, p1orig, p2orig);
        return after(rorig);
    }
    
    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeMetaprogramImportListNode(MetaprogramImportListNode node, P1New p1, P2New p2) throws X
    {
        P1Orig p1orig = before1(p1);
        P2Orig p2orig = before2(p2);
        ROrig rorig = this.backingOp.executeMetaprogramImportListNode(node, p1orig, p2orig);
        return after(rorig);
    }
    
    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeMetaprogramImportNode(MetaprogramImportNode node, P1New p1, P2New p2) throws X
    {
        P1Orig p1orig = before1(p1);
        P2Orig p2orig = before2(p2);
        ROrig rorig = this.backingOp.executeMetaprogramImportNode(node, p1orig, p2orig);
        return after(rorig);
    }
    
    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeMetaprogramNode(MetaprogramNode node, P1New p1, P2New p2) throws X
    {
        P1Orig p1orig = before1(p1);
        P2Orig p2orig = before2(p2);
        ROrig rorig = this.backingOp.executeMetaprogramNode(node, p1orig, p2orig);
        return after(rorig);
    }
    
    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeMetaprogramPreambleNode(MetaprogramPreambleNode node, P1New p1, P2New p2) throws X
    {
        P1Orig p1orig = before1(p1);
        P2Orig p2orig = before2(p2);
        ROrig rorig = this.backingOp.executeMetaprogramPreambleNode(node, p1orig, p2orig);
        return after(rorig);
    }
    
    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeMetaprogramTargetListNode(MetaprogramTargetListNode node, P1New p1, P2New p2) throws X
    {
        P1Orig p1orig = before1(p1);
        P2Orig p2orig = before2(p2);
        ROrig rorig = this.backingOp.executeMetaprogramTargetListNode(node, p1orig, p2orig);
        return after(rorig);
    }
    
    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeMetaprogramTargetNode(MetaprogramTargetNode node, P1New p1, P2New p2) throws X
    {
        P1Orig p1orig = before1(p1);
        P2Orig p2orig = before2(p2);
        ROrig rorig = this.backingOp.executeMetaprogramTargetNode(node, p1orig, p2orig);
        return after(rorig);
    }
    
    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeMethodDeclarationNode(MethodDeclarationNode node, P1New p1, P2New p2) throws X
    {
        P1Orig p1orig = before1(p1);
        P2Orig p2orig = before2(p2);
        ROrig rorig = this.backingOp.executeMethodDeclarationNode(node, p1orig, p2orig);
        return after(rorig);
    }
    
    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeMethodInvocationNode(MethodInvocationNode node, P1New p1, P2New p2) throws X
    {
        P1Orig p1orig = before1(p1);
        P2Orig p2orig = before2(p2);
        ROrig rorig = this.backingOp.executeMethodInvocationNode(node, p1orig, p2orig);
        return after(rorig);
    }
    
    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeMethodModifiersNode(MethodModifiersNode node, P1New p1, P2New p2) throws X
    {
        P1Orig p1orig = before1(p1);
        P2Orig p2orig = before2(p2);
        ROrig rorig = this.backingOp.executeMethodModifiersNode(node, p1orig, p2orig);
        return after(rorig);
    }
    
    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeNoOperationNode(NoOperationNode node, P1New p1, P2New p2) throws X
    {
        P1Orig p1orig = before1(p1);
        P2Orig p2orig = before2(p2);
        ROrig rorig = this.backingOp.executeNoOperationNode(node, p1orig, p2orig);
        return after(rorig);
    }
    
    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeNormalAnnotationNode(NormalAnnotationNode node, P1New p1, P2New p2) throws X
    {
        P1Orig p1orig = before1(p1);
        P2Orig p2orig = before2(p2);
        ROrig rorig = this.backingOp.executeNormalAnnotationNode(node, p1orig, p2orig);
        return after(rorig);
    }
    
    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeNormalMetaAnnotationNode(NormalMetaAnnotationNode node, P1New p1, P2New p2) throws X
    {
        P1Orig p1orig = before1(p1);
        P2Orig p2orig = before2(p2);
        ROrig rorig = this.backingOp.executeNormalMetaAnnotationNode(node, p1orig, p2orig);
        return after(rorig);
    }
    
    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeNullLiteralNode(NullLiteralNode node, P1New p1, P2New p2) throws X
    {
        P1Orig p1orig = before1(p1);
        P2Orig p2orig = before2(p2);
        ROrig rorig = this.backingOp.executeNullLiteralNode(node, p1orig, p2orig);
        return after(rorig);
    }
    
    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executePackageDeclarationNode(PackageDeclarationNode node, P1New p1, P2New p2) throws X
    {
        P1Orig p1orig = before1(p1);
        P2Orig p2orig = before2(p2);
        ROrig rorig = this.backingOp.executePackageDeclarationNode(node, p1orig, p2orig);
        return after(rorig);
    }
    
    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executePackageNode(PackageNode node, P1New p1, P2New p2) throws X
    {
        P1Orig p1orig = before1(p1);
        P2Orig p2orig = before2(p2);
        ROrig rorig = this.backingOp.executePackageNode(node, p1orig, p2orig);
        return after(rorig);
    }
    
    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeParameterizedTypeNode(ParameterizedTypeNode node, P1New p1, P2New p2) throws X
    {
        P1Orig p1orig = before1(p1);
        P2Orig p2orig = before2(p2);
        ROrig rorig = this.backingOp.executeParameterizedTypeNode(node, p1orig, p2orig);
        return after(rorig);
    }
    
    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeParameterizedTypeSelectNode(ParameterizedTypeSelectNode node, P1New p1, P2New p2) throws X
    {
        P1Orig p1orig = before1(p1);
        P2Orig p2orig = before2(p2);
        ROrig rorig = this.backingOp.executeParameterizedTypeSelectNode(node, p1orig, p2orig);
        return after(rorig);
    }
    
    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeParenthesizedExpressionNode(ParenthesizedExpressionNode node, P1New p1, P2New p2) throws X
    {
        P1Orig p1orig = before1(p1);
        P2Orig p2orig = before2(p2);
        ROrig rorig = this.backingOp.executeParenthesizedExpressionNode(node, p1orig, p2orig);
        return after(rorig);
    }
    
    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executePrimitiveTypeNode(PrimitiveTypeNode node, P1New p1, P2New p2) throws X
    {
        P1Orig p1orig = before1(p1);
        P2Orig p2orig = before2(p2);
        ROrig rorig = this.backingOp.executePrimitiveTypeNode(node, p1orig, p2orig);
        return after(rorig);
    }
    
    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeQualifiedClassInstantiationNode(QualifiedClassInstantiationNode node, P1New p1, P2New p2) throws X
    {
        P1Orig p1orig = before1(p1);
        P2Orig p2orig = before2(p2);
        ROrig rorig = this.backingOp.executeQualifiedClassInstantiationNode(node, p1orig, p2orig);
        return after(rorig);
    }
    
    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeQualifiedNameNode(QualifiedNameNode node, P1New p1, P2New p2) throws X
    {
        P1Orig p1orig = before1(p1);
        P2Orig p2orig = before2(p2);
        ROrig rorig = this.backingOp.executeQualifiedNameNode(node, p1orig, p2orig);
        return after(rorig);
    }
    
    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeRawCodeLiteralNode(RawCodeLiteralNode node, P1New p1, P2New p2) throws X
    {
        P1Orig p1orig = before1(p1);
        P2Orig p2orig = before2(p2);
        ROrig rorig = this.backingOp.executeRawCodeLiteralNode(node, p1orig, p2orig);
        return after(rorig);
    }
    
    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeReferenceTypeListNode(ReferenceTypeListNode node, P1New p1, P2New p2) throws X
    {
        P1Orig p1orig = before1(p1);
        P2Orig p2orig = before2(p2);
        ROrig rorig = this.backingOp.executeReferenceTypeListNode(node, p1orig, p2orig);
        return after(rorig);
    }
    
    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeReturnNode(ReturnNode node, P1New p1, P2New p2) throws X
    {
        P1Orig p1orig = before1(p1);
        P2Orig p2orig = before2(p2);
        ROrig rorig = this.backingOp.executeReturnNode(node, p1orig, p2orig);
        return after(rorig);
    }
    
    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeSimpleNameNode(SimpleNameNode node, P1New p1, P2New p2) throws X
    {
        P1Orig p1orig = before1(p1);
        P2Orig p2orig = before2(p2);
        ROrig rorig = this.backingOp.executeSimpleNameNode(node, p1orig, p2orig);
        return after(rorig);
    }
    
    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeSingleElementAnnotationNode(SingleElementAnnotationNode node, P1New p1, P2New p2) throws X
    {
        P1Orig p1orig = before1(p1);
        P2Orig p2orig = before2(p2);
        ROrig rorig = this.backingOp.executeSingleElementAnnotationNode(node, p1orig, p2orig);
        return after(rorig);
    }
    
    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeSingleElementMetaAnnotationNode(SingleElementMetaAnnotationNode node, P1New p1, P2New p2) throws X
    {
        P1Orig p1orig = before1(p1);
        P2Orig p2orig = before2(p2);
        ROrig rorig = this.backingOp.executeSingleElementMetaAnnotationNode(node, p1orig, p2orig);
        return after(rorig);
    }
    
    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeSingleStaticImportNode(SingleStaticImportNode node, P1New p1, P2New p2) throws X
    {
        P1Orig p1orig = before1(p1);
        P2Orig p2orig = before2(p2);
        ROrig rorig = this.backingOp.executeSingleStaticImportNode(node, p1orig, p2orig);
        return after(rorig);
    }
    
    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeSpliceNode(SpliceNode node, P1New p1, P2New p2) throws X
    {
        P1Orig p1orig = before1(p1);
        P2Orig p2orig = before2(p2);
        ROrig rorig = this.backingOp.executeSpliceNode(node, p1orig, p2orig);
        return after(rorig);
    }
    
    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeStatementExpressionListNode(StatementExpressionListNode node, P1New p1, P2New p2) throws X
    {
        P1Orig p1orig = before1(p1);
        P2Orig p2orig = before2(p2);
        ROrig rorig = this.backingOp.executeStatementExpressionListNode(node, p1orig, p2orig);
        return after(rorig);
    }
    
    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeStaticImportOnDemandNode(StaticImportOnDemandNode node, P1New p1, P2New p2) throws X
    {
        P1Orig p1orig = before1(p1);
        P2Orig p2orig = before2(p2);
        ROrig rorig = this.backingOp.executeStaticImportOnDemandNode(node, p1orig, p2orig);
        return after(rorig);
    }
    
    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeStringLiteralNode(StringLiteralNode node, P1New p1, P2New p2) throws X
    {
        P1Orig p1orig = before1(p1);
        P2Orig p2orig = before2(p2);
        ROrig rorig = this.backingOp.executeStringLiteralNode(node, p1orig, p2orig);
        return after(rorig);
    }
    
    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeSuperFieldAccessNode(SuperFieldAccessNode node, P1New p1, P2New p2) throws X
    {
        P1Orig p1orig = before1(p1);
        P2Orig p2orig = before2(p2);
        ROrig rorig = this.backingOp.executeSuperFieldAccessNode(node, p1orig, p2orig);
        return after(rorig);
    }
    
    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeSuperMethodInvocationNode(SuperMethodInvocationNode node, P1New p1, P2New p2) throws X
    {
        P1Orig p1orig = before1(p1);
        P2Orig p2orig = before2(p2);
        ROrig rorig = this.backingOp.executeSuperMethodInvocationNode(node, p1orig, p2orig);
        return after(rorig);
    }
    
    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeSuperclassConstructorInvocationNode(SuperclassConstructorInvocationNode node, P1New p1, P2New p2) throws X
    {
        P1Orig p1orig = before1(p1);
        P2Orig p2orig = before2(p2);
        ROrig rorig = this.backingOp.executeSuperclassConstructorInvocationNode(node, p1orig, p2orig);
        return after(rorig);
    }
    
    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeSwitchNode(SwitchNode node, P1New p1, P2New p2) throws X
    {
        P1Orig p1orig = before1(p1);
        P2Orig p2orig = before2(p2);
        ROrig rorig = this.backingOp.executeSwitchNode(node, p1orig, p2orig);
        return after(rorig);
    }
    
    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeSynchronizedNode(SynchronizedNode node, P1New p1, P2New p2) throws X
    {
        P1Orig p1orig = before1(p1);
        P2Orig p2orig = before2(p2);
        ROrig rorig = this.backingOp.executeSynchronizedNode(node, p1orig, p2orig);
        return after(rorig);
    }
    
    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeThisNode(ThisNode node, P1New p1, P2New p2) throws X
    {
        P1Orig p1orig = before1(p1);
        P2Orig p2orig = before2(p2);
        ROrig rorig = this.backingOp.executeThisNode(node, p1orig, p2orig);
        return after(rorig);
    }
    
    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeThrowNode(ThrowNode node, P1New p1, P2New p2) throws X
    {
        P1Orig p1orig = before1(p1);
        P2Orig p2orig = before2(p2);
        ROrig rorig = this.backingOp.executeThrowNode(node, p1orig, p2orig);
        return after(rorig);
    }
    
    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeTryNode(TryNode node, P1New p1, P2New p2) throws X
    {
        P1Orig p1orig = before1(p1);
        P2Orig p2orig = before2(p2);
        ROrig rorig = this.backingOp.executeTryNode(node, p1orig, p2orig);
        return after(rorig);
    }
    
    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeTypeArgumentListNode(TypeArgumentListNode node, P1New p1, P2New p2) throws X
    {
        P1Orig p1orig = before1(p1);
        P2Orig p2orig = before2(p2);
        ROrig rorig = this.backingOp.executeTypeArgumentListNode(node, p1orig, p2orig);
        return after(rorig);
    }
    
    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeTypeCastNode(TypeCastNode node, P1New p1, P2New p2) throws X
    {
        P1Orig p1orig = before1(p1);
        P2Orig p2orig = before2(p2);
        ROrig rorig = this.backingOp.executeTypeCastNode(node, p1orig, p2orig);
        return after(rorig);
    }
    
    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeTypeDeclarationListNode(TypeDeclarationListNode node, P1New p1, P2New p2) throws X
    {
        P1Orig p1orig = before1(p1);
        P2Orig p2orig = before2(p2);
        ROrig rorig = this.backingOp.executeTypeDeclarationListNode(node, p1orig, p2orig);
        return after(rorig);
    }
    
    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeTypeDeclarationMetaprogramAnchorNode(TypeDeclarationMetaprogramAnchorNode node, P1New p1, P2New p2) throws X
    {
        P1Orig p1orig = before1(p1);
        P2Orig p2orig = before2(p2);
        ROrig rorig = this.backingOp.executeTypeDeclarationMetaprogramAnchorNode(node, p1orig, p2orig);
        return after(rorig);
    }
    
    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeTypeParameterListNode(TypeParameterListNode node, P1New p1, P2New p2) throws X
    {
        P1Orig p1orig = before1(p1);
        P2Orig p2orig = before2(p2);
        ROrig rorig = this.backingOp.executeTypeParameterListNode(node, p1orig, p2orig);
        return after(rorig);
    }
    
    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeTypeParameterNode(TypeParameterNode node, P1New p1, P2New p2) throws X
    {
        P1Orig p1orig = before1(p1);
        P2Orig p2orig = before2(p2);
        ROrig rorig = this.backingOp.executeTypeParameterNode(node, p1orig, p2orig);
        return after(rorig);
    }
    
    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeUnaryExpressionNode(UnaryExpressionNode node, P1New p1, P2New p2) throws X
    {
        P1Orig p1orig = before1(p1);
        P2Orig p2orig = before2(p2);
        ROrig rorig = this.backingOp.executeUnaryExpressionNode(node, p1orig, p2orig);
        return after(rorig);
    }
    
    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeUnaryStatementExpressionNode(UnaryStatementExpressionNode node, P1New p1, P2New p2) throws X
    {
        P1Orig p1orig = before1(p1);
        P2Orig p2orig = before2(p2);
        ROrig rorig = this.backingOp.executeUnaryStatementExpressionNode(node, p1orig, p2orig);
        return after(rorig);
    }
    
    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeUnparameterizedTypeListNode(UnparameterizedTypeListNode node, P1New p1, P2New p2) throws X
    {
        P1Orig p1orig = before1(p1);
        P2Orig p2orig = before2(p2);
        ROrig rorig = this.backingOp.executeUnparameterizedTypeListNode(node, p1orig, p2orig);
        return after(rorig);
    }
    
    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeUnparameterizedTypeNode(UnparameterizedTypeNode node, P1New p1, P2New p2) throws X
    {
        P1Orig p1orig = before1(p1);
        P2Orig p2orig = before2(p2);
        ROrig rorig = this.backingOp.executeUnparameterizedTypeNode(node, p1orig, p2orig);
        return after(rorig);
    }
    
    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeUnqualifiedClassInstantiationNode(UnqualifiedClassInstantiationNode node, P1New p1, P2New p2) throws X
    {
        P1Orig p1orig = before1(p1);
        P2Orig p2orig = before2(p2);
        ROrig rorig = this.backingOp.executeUnqualifiedClassInstantiationNode(node, p1orig, p2orig);
        return after(rorig);
    }
    
    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeVariableAccessNode(VariableAccessNode node, P1New p1, P2New p2) throws X
    {
        P1Orig p1orig = before1(p1);
        P2Orig p2orig = before2(p2);
        ROrig rorig = this.backingOp.executeVariableAccessNode(node, p1orig, p2orig);
        return after(rorig);
    }
    
    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeVariableDeclaratorListNode(VariableDeclaratorListNode node, P1New p1, P2New p2) throws X
    {
        P1Orig p1orig = before1(p1);
        P2Orig p2orig = before2(p2);
        ROrig rorig = this.backingOp.executeVariableDeclaratorListNode(node, p1orig, p2orig);
        return after(rorig);
    }
    
    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeVariableDeclaratorNode(VariableDeclaratorNode node, P1New p1, P2New p2) throws X
    {
        P1Orig p1orig = before1(p1);
        P2Orig p2orig = before2(p2);
        ROrig rorig = this.backingOp.executeVariableDeclaratorNode(node, p1orig, p2orig);
        return after(rorig);
    }
    
    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeVariableInitializerListNode(VariableInitializerListNode node, P1New p1, P2New p2) throws X
    {
        P1Orig p1orig = before1(p1);
        P2Orig p2orig = before2(p2);
        ROrig rorig = this.backingOp.executeVariableInitializerListNode(node, p1orig, p2orig);
        return after(rorig);
    }
    
    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeVariableListNode(VariableListNode node, P1New p1, P2New p2) throws X
    {
        P1Orig p1orig = before1(p1);
        P2Orig p2orig = before2(p2);
        ROrig rorig = this.backingOp.executeVariableListNode(node, p1orig, p2orig);
        return after(rorig);
    }
    
    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeVariableModifiersNode(VariableModifiersNode node, P1New p1, P2New p2) throws X
    {
        P1Orig p1orig = before1(p1);
        P2Orig p2orig = before2(p2);
        ROrig rorig = this.backingOp.executeVariableModifiersNode(node, p1orig, p2orig);
        return after(rorig);
    }
    
    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeVariableNode(VariableNode node, P1New p1, P2New p2) throws X
    {
        P1Orig p1orig = before1(p1);
        P2Orig p2orig = before2(p2);
        ROrig rorig = this.backingOp.executeVariableNode(node, p1orig, p2orig);
        return after(rorig);
    }
    
    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeVoidTypeNode(VoidTypeNode node, P1New p1, P2New p2) throws X
    {
        P1Orig p1orig = before1(p1);
        P2Orig p2orig = before2(p2);
        ROrig rorig = this.backingOp.executeVoidTypeNode(node, p1orig, p2orig);
        return after(rorig);
    }
    
    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeWhileLoopNode(WhileLoopNode node, P1New p1, P2New p2) throws X
    {
        P1Orig p1orig = before1(p1);
        P2Orig p2orig = before2(p2);
        ROrig rorig = this.backingOp.executeWhileLoopNode(node, p1orig, p2orig);
        return after(rorig);
    }
    
    /**
     * Decorates this operation, turning it over to the backing operation.
     * @param node The node to affect.
     * @param p The value to pass through the proxy filter and into the backing operation.
     * @return The result of this operation (after being passed through the proxy filter).
     */
    public RNew executeWildcardTypeNode(WildcardTypeNode node, P1New p1, P2New p2) throws X
    {
        P1Orig p1orig = before1(p1);
        P2Orig p2orig = before2(p2);
        ROrig rorig = this.backingOp.executeWildcardTypeNode(node, p1orig, p2orig);
        return after(rorig);
    }
    
}
