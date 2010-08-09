package edu.jhu.cs.bsj.compiler.ast.util;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeOperation;
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
import edu.jhu.cs.bsj.compiler.ast.node.meta.TypeDeclarationMetaprogramAnchorNode;

/**
 * This implementation of the BSJ node operation implements every method with a no-op.
 *
 * @author Zachary Palmer
 */

@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class BsjNodeNoOpOperation<P,R> implements BsjNodeOperation<P,R>
{
    /**
     * Performs no operation.
     * @param node Ignored.
     * @param p Ignored.
     * @return <code>null</code>, always.
     */
    public R executeAlternateConstructorInvocationNode(AlternateConstructorInvocationNode node, P p)
    {
        return null;
    }
    
    /**
     * Performs no operation.
     * @param node Ignored.
     * @param p Ignored.
     * @return <code>null</code>, always.
     */
    public R executeAnnotationAnnotationValueNode(AnnotationAnnotationValueNode node, P p)
    {
        return null;
    }
    
    /**
     * Performs no operation.
     * @param node Ignored.
     * @param p Ignored.
     * @return <code>null</code>, always.
     */
    public R executeAnnotationArrayValueNode(AnnotationArrayValueNode node, P p)
    {
        return null;
    }
    
    /**
     * Performs no operation.
     * @param node Ignored.
     * @param p Ignored.
     * @return <code>null</code>, always.
     */
    public R executeAnnotationBodyNode(AnnotationBodyNode node, P p)
    {
        return null;
    }
    
    /**
     * Performs no operation.
     * @param node Ignored.
     * @param p Ignored.
     * @return <code>null</code>, always.
     */
    public R executeAnnotationDeclarationNode(AnnotationDeclarationNode node, P p)
    {
        return null;
    }
    
    /**
     * Performs no operation.
     * @param node Ignored.
     * @param p Ignored.
     * @return <code>null</code>, always.
     */
    public R executeAnnotationElementListNode(AnnotationElementListNode node, P p)
    {
        return null;
    }
    
    /**
     * Performs no operation.
     * @param node Ignored.
     * @param p Ignored.
     * @return <code>null</code>, always.
     */
    public R executeAnnotationElementNode(AnnotationElementNode node, P p)
    {
        return null;
    }
    
    /**
     * Performs no operation.
     * @param node Ignored.
     * @param p Ignored.
     * @return <code>null</code>, always.
     */
    public R executeAnnotationExpressionValueNode(AnnotationExpressionValueNode node, P p)
    {
        return null;
    }
    
    /**
     * Performs no operation.
     * @param node Ignored.
     * @param p Ignored.
     * @return <code>null</code>, always.
     */
    public R executeAnnotationListNode(AnnotationListNode node, P p)
    {
        return null;
    }
    
    /**
     * Performs no operation.
     * @param node Ignored.
     * @param p Ignored.
     * @return <code>null</code>, always.
     */
    public R executeAnnotationMemberListNode(AnnotationMemberListNode node, P p)
    {
        return null;
    }
    
    /**
     * Performs no operation.
     * @param node Ignored.
     * @param p Ignored.
     * @return <code>null</code>, always.
     */
    public R executeAnnotationMemberMetaprogramAnchorNode(AnnotationMemberMetaprogramAnchorNode node, P p)
    {
        return null;
    }
    
    /**
     * Performs no operation.
     * @param node Ignored.
     * @param p Ignored.
     * @return <code>null</code>, always.
     */
    public R executeAnnotationMethodDeclarationNode(AnnotationMethodDeclarationNode node, P p)
    {
        return null;
    }
    
    /**
     * Performs no operation.
     * @param node Ignored.
     * @param p Ignored.
     * @return <code>null</code>, always.
     */
    public R executeAnnotationMethodModifiersNode(AnnotationMethodModifiersNode node, P p)
    {
        return null;
    }
    
    /**
     * Performs no operation.
     * @param node Ignored.
     * @param p Ignored.
     * @return <code>null</code>, always.
     */
    public R executeAnnotationModifiersNode(AnnotationModifiersNode node, P p)
    {
        return null;
    }
    
    /**
     * Performs no operation.
     * @param node Ignored.
     * @param p Ignored.
     * @return <code>null</code>, always.
     */
    public R executeAnnotationValueListNode(AnnotationValueListNode node, P p)
    {
        return null;
    }
    
    /**
     * Performs no operation.
     * @param node Ignored.
     * @param p Ignored.
     * @return <code>null</code>, always.
     */
    public R executeAnonymousClassBodyNode(AnonymousClassBodyNode node, P p)
    {
        return null;
    }
    
    /**
     * Performs no operation.
     * @param node Ignored.
     * @param p Ignored.
     * @return <code>null</code>, always.
     */
    public R executeAnonymousClassMemberListNode(AnonymousClassMemberListNode node, P p)
    {
        return null;
    }
    
    /**
     * Performs no operation.
     * @param node Ignored.
     * @param p Ignored.
     * @return <code>null</code>, always.
     */
    public R executeAnonymousClassMemberMetaprogramAnchorNode(AnonymousClassMemberMetaprogramAnchorNode node, P p)
    {
        return null;
    }
    
    /**
     * Performs no operation.
     * @param node Ignored.
     * @param p Ignored.
     * @return <code>null</code>, always.
     */
    public R executeArrayAccessNode(ArrayAccessNode node, P p)
    {
        return null;
    }
    
    /**
     * Performs no operation.
     * @param node Ignored.
     * @param p Ignored.
     * @return <code>null</code>, always.
     */
    public R executeArrayInitializerCreationNode(ArrayInitializerCreationNode node, P p)
    {
        return null;
    }
    
    /**
     * Performs no operation.
     * @param node Ignored.
     * @param p Ignored.
     * @return <code>null</code>, always.
     */
    public R executeArrayInitializerNode(ArrayInitializerNode node, P p)
    {
        return null;
    }
    
    /**
     * Performs no operation.
     * @param node Ignored.
     * @param p Ignored.
     * @return <code>null</code>, always.
     */
    public R executeArrayInstantiatorCreationNode(ArrayInstantiatorCreationNode node, P p)
    {
        return null;
    }
    
    /**
     * Performs no operation.
     * @param node Ignored.
     * @param p Ignored.
     * @return <code>null</code>, always.
     */
    public R executeArrayTypeNode(ArrayTypeNode node, P p)
    {
        return null;
    }
    
    /**
     * Performs no operation.
     * @param node Ignored.
     * @param p Ignored.
     * @return <code>null</code>, always.
     */
    public R executeAssertStatementNode(AssertStatementNode node, P p)
    {
        return null;
    }
    
    /**
     * Performs no operation.
     * @param node Ignored.
     * @param p Ignored.
     * @return <code>null</code>, always.
     */
    public R executeAssignmentNode(AssignmentNode node, P p)
    {
        return null;
    }
    
    /**
     * Performs no operation.
     * @param node Ignored.
     * @param p Ignored.
     * @return <code>null</code>, always.
     */
    public R executeBinaryExpressionNode(BinaryExpressionNode node, P p)
    {
        return null;
    }
    
    /**
     * Performs no operation.
     * @param node Ignored.
     * @param p Ignored.
     * @return <code>null</code>, always.
     */
    public R executeBlockNode(BlockNode node, P p)
    {
        return null;
    }
    
    /**
     * Performs no operation.
     * @param node Ignored.
     * @param p Ignored.
     * @return <code>null</code>, always.
     */
    public R executeBlockStatementListNode(BlockStatementListNode node, P p)
    {
        return null;
    }
    
    /**
     * Performs no operation.
     * @param node Ignored.
     * @param p Ignored.
     * @return <code>null</code>, always.
     */
    public R executeBlockStatementMetaprogramAnchorNode(BlockStatementMetaprogramAnchorNode node, P p)
    {
        return null;
    }
    
    /**
     * Performs no operation.
     * @param node Ignored.
     * @param p Ignored.
     * @return <code>null</code>, always.
     */
    public R executeBooleanLiteralNode(BooleanLiteralNode node, P p)
    {
        return null;
    }
    
    /**
     * Performs no operation.
     * @param node Ignored.
     * @param p Ignored.
     * @return <code>null</code>, always.
     */
    public R executeBreakNode(BreakNode node, P p)
    {
        return null;
    }
    
    /**
     * Performs no operation.
     * @param node Ignored.
     * @param p Ignored.
     * @return <code>null</code>, always.
     */
    public R executeCaseListNode(CaseListNode node, P p)
    {
        return null;
    }
    
    /**
     * Performs no operation.
     * @param node Ignored.
     * @param p Ignored.
     * @return <code>null</code>, always.
     */
    public R executeCaseNode(CaseNode node, P p)
    {
        return null;
    }
    
    /**
     * Performs no operation.
     * @param node Ignored.
     * @param p Ignored.
     * @return <code>null</code>, always.
     */
    public R executeCatchListNode(CatchListNode node, P p)
    {
        return null;
    }
    
    /**
     * Performs no operation.
     * @param node Ignored.
     * @param p Ignored.
     * @return <code>null</code>, always.
     */
    public R executeCatchNode(CatchNode node, P p)
    {
        return null;
    }
    
    /**
     * Performs no operation.
     * @param node Ignored.
     * @param p Ignored.
     * @return <code>null</code>, always.
     */
    public R executeCharLiteralNode(CharLiteralNode node, P p)
    {
        return null;
    }
    
    /**
     * Performs no operation.
     * @param node Ignored.
     * @param p Ignored.
     * @return <code>null</code>, always.
     */
    public R executeClassBodyNode(ClassBodyNode node, P p)
    {
        return null;
    }
    
    /**
     * Performs no operation.
     * @param node Ignored.
     * @param p Ignored.
     * @return <code>null</code>, always.
     */
    public R executeClassDeclarationNode(ClassDeclarationNode node, P p)
    {
        return null;
    }
    
    /**
     * Performs no operation.
     * @param node Ignored.
     * @param p Ignored.
     * @return <code>null</code>, always.
     */
    public R executeClassLiteralNode(ClassLiteralNode node, P p)
    {
        return null;
    }
    
    /**
     * Performs no operation.
     * @param node Ignored.
     * @param p Ignored.
     * @return <code>null</code>, always.
     */
    public R executeClassMemberListNode(ClassMemberListNode node, P p)
    {
        return null;
    }
    
    /**
     * Performs no operation.
     * @param node Ignored.
     * @param p Ignored.
     * @return <code>null</code>, always.
     */
    public R executeClassMemberMetaprogramAnchorNode(ClassMemberMetaprogramAnchorNode node, P p)
    {
        return null;
    }
    
    /**
     * Performs no operation.
     * @param node Ignored.
     * @param p Ignored.
     * @return <code>null</code>, always.
     */
    public R executeClassModifiersNode(ClassModifiersNode node, P p)
    {
        return null;
    }
    
    /**
     * Performs no operation.
     * @param node Ignored.
     * @param p Ignored.
     * @return <code>null</code>, always.
     */
    public R executeCodeLiteralNode(CodeLiteralNode node, P p)
    {
        return null;
    }
    
    /**
     * Performs no operation.
     * @param node Ignored.
     * @param p Ignored.
     * @return <code>null</code>, always.
     */
    public R executeCompilationUnitNode(CompilationUnitNode node, P p)
    {
        return null;
    }
    
    /**
     * Performs no operation.
     * @param node Ignored.
     * @param p Ignored.
     * @return <code>null</code>, always.
     */
    public R executeConditionalExpressionNode(ConditionalExpressionNode node, P p)
    {
        return null;
    }
    
    /**
     * Performs no operation.
     * @param node Ignored.
     * @param p Ignored.
     * @return <code>null</code>, always.
     */
    public R executeConstantDeclarationNode(ConstantDeclarationNode node, P p)
    {
        return null;
    }
    
    /**
     * Performs no operation.
     * @param node Ignored.
     * @param p Ignored.
     * @return <code>null</code>, always.
     */
    public R executeConstantModifiersNode(ConstantModifiersNode node, P p)
    {
        return null;
    }
    
    /**
     * Performs no operation.
     * @param node Ignored.
     * @param p Ignored.
     * @return <code>null</code>, always.
     */
    public R executeConstructorBodyNode(ConstructorBodyNode node, P p)
    {
        return null;
    }
    
    /**
     * Performs no operation.
     * @param node Ignored.
     * @param p Ignored.
     * @return <code>null</code>, always.
     */
    public R executeConstructorDeclarationNode(ConstructorDeclarationNode node, P p)
    {
        return null;
    }
    
    /**
     * Performs no operation.
     * @param node Ignored.
     * @param p Ignored.
     * @return <code>null</code>, always.
     */
    public R executeConstructorModifiersNode(ConstructorModifiersNode node, P p)
    {
        return null;
    }
    
    /**
     * Performs no operation.
     * @param node Ignored.
     * @param p Ignored.
     * @return <code>null</code>, always.
     */
    public R executeContinueNode(ContinueNode node, P p)
    {
        return null;
    }
    
    /**
     * Performs no operation.
     * @param node Ignored.
     * @param p Ignored.
     * @return <code>null</code>, always.
     */
    public R executeDeclaredTypeListNode(DeclaredTypeListNode node, P p)
    {
        return null;
    }
    
    /**
     * Performs no operation.
     * @param node Ignored.
     * @param p Ignored.
     * @return <code>null</code>, always.
     */
    public R executeDoWhileLoopNode(DoWhileLoopNode node, P p)
    {
        return null;
    }
    
    /**
     * Performs no operation.
     * @param node Ignored.
     * @param p Ignored.
     * @return <code>null</code>, always.
     */
    public R executeDoubleLiteralNode(DoubleLiteralNode node, P p)
    {
        return null;
    }
    
    /**
     * Performs no operation.
     * @param node Ignored.
     * @param p Ignored.
     * @return <code>null</code>, always.
     */
    public R executeEnhancedForLoopNode(EnhancedForLoopNode node, P p)
    {
        return null;
    }
    
    /**
     * Performs no operation.
     * @param node Ignored.
     * @param p Ignored.
     * @return <code>null</code>, always.
     */
    public R executeEnumBodyNode(EnumBodyNode node, P p)
    {
        return null;
    }
    
    /**
     * Performs no operation.
     * @param node Ignored.
     * @param p Ignored.
     * @return <code>null</code>, always.
     */
    public R executeEnumConstantDeclarationListNode(EnumConstantDeclarationListNode node, P p)
    {
        return null;
    }
    
    /**
     * Performs no operation.
     * @param node Ignored.
     * @param p Ignored.
     * @return <code>null</code>, always.
     */
    public R executeEnumConstantDeclarationNode(EnumConstantDeclarationNode node, P p)
    {
        return null;
    }
    
    /**
     * Performs no operation.
     * @param node Ignored.
     * @param p Ignored.
     * @return <code>null</code>, always.
     */
    public R executeEnumConstantModifiersNode(EnumConstantModifiersNode node, P p)
    {
        return null;
    }
    
    /**
     * Performs no operation.
     * @param node Ignored.
     * @param p Ignored.
     * @return <code>null</code>, always.
     */
    public R executeEnumDeclarationNode(EnumDeclarationNode node, P p)
    {
        return null;
    }
    
    /**
     * Performs no operation.
     * @param node Ignored.
     * @param p Ignored.
     * @return <code>null</code>, always.
     */
    public R executeEnumModifiersNode(EnumModifiersNode node, P p)
    {
        return null;
    }
    
    /**
     * Performs no operation.
     * @param node Ignored.
     * @param p Ignored.
     * @return <code>null</code>, always.
     */
    public R executeExpressionListNode(ExpressionListNode node, P p)
    {
        return null;
    }
    
    /**
     * Performs no operation.
     * @param node Ignored.
     * @param p Ignored.
     * @return <code>null</code>, always.
     */
    public R executeExpressionStatementNode(ExpressionStatementNode node, P p)
    {
        return null;
    }
    
    /**
     * Performs no operation.
     * @param node Ignored.
     * @param p Ignored.
     * @return <code>null</code>, always.
     */
    public R executeFieldDeclarationNode(FieldDeclarationNode node, P p)
    {
        return null;
    }
    
    /**
     * Performs no operation.
     * @param node Ignored.
     * @param p Ignored.
     * @return <code>null</code>, always.
     */
    public R executeFieldModifiersNode(FieldModifiersNode node, P p)
    {
        return null;
    }
    
    /**
     * Performs no operation.
     * @param node Ignored.
     * @param p Ignored.
     * @return <code>null</code>, always.
     */
    public R executeFloatLiteralNode(FloatLiteralNode node, P p)
    {
        return null;
    }
    
    /**
     * Performs no operation.
     * @param node Ignored.
     * @param p Ignored.
     * @return <code>null</code>, always.
     */
    public R executeForInitializerDeclarationNode(ForInitializerDeclarationNode node, P p)
    {
        return null;
    }
    
    /**
     * Performs no operation.
     * @param node Ignored.
     * @param p Ignored.
     * @return <code>null</code>, always.
     */
    public R executeForInitializerExpressionNode(ForInitializerExpressionNode node, P p)
    {
        return null;
    }
    
    /**
     * Performs no operation.
     * @param node Ignored.
     * @param p Ignored.
     * @return <code>null</code>, always.
     */
    public R executeForLoopNode(ForLoopNode node, P p)
    {
        return null;
    }
    
    /**
     * Performs no operation.
     * @param node Ignored.
     * @param p Ignored.
     * @return <code>null</code>, always.
     */
    public R executeIdentifierListNode(IdentifierListNode node, P p)
    {
        return null;
    }
    
    /**
     * Performs no operation.
     * @param node Ignored.
     * @param p Ignored.
     * @return <code>null</code>, always.
     */
    public R executeIdentifierNode(IdentifierNode node, P p)
    {
        return null;
    }
    
    /**
     * Performs no operation.
     * @param node Ignored.
     * @param p Ignored.
     * @return <code>null</code>, always.
     */
    public R executeIfNode(IfNode node, P p)
    {
        return null;
    }
    
    /**
     * Performs no operation.
     * @param node Ignored.
     * @param p Ignored.
     * @return <code>null</code>, always.
     */
    public R executeImportListNode(ImportListNode node, P p)
    {
        return null;
    }
    
    /**
     * Performs no operation.
     * @param node Ignored.
     * @param p Ignored.
     * @return <code>null</code>, always.
     */
    public R executeImportOnDemandNode(ImportOnDemandNode node, P p)
    {
        return null;
    }
    
    /**
     * Performs no operation.
     * @param node Ignored.
     * @param p Ignored.
     * @return <code>null</code>, always.
     */
    public R executeImportSingleTypeNode(ImportSingleTypeNode node, P p)
    {
        return null;
    }
    
    /**
     * Performs no operation.
     * @param node Ignored.
     * @param p Ignored.
     * @return <code>null</code>, always.
     */
    public R executeInitializerDeclarationNode(InitializerDeclarationNode node, P p)
    {
        return null;
    }
    
    /**
     * Performs no operation.
     * @param node Ignored.
     * @param p Ignored.
     * @return <code>null</code>, always.
     */
    public R executeInstanceOfNode(InstanceOfNode node, P p)
    {
        return null;
    }
    
    /**
     * Performs no operation.
     * @param node Ignored.
     * @param p Ignored.
     * @return <code>null</code>, always.
     */
    public R executeIntLiteralNode(IntLiteralNode node, P p)
    {
        return null;
    }
    
    /**
     * Performs no operation.
     * @param node Ignored.
     * @param p Ignored.
     * @return <code>null</code>, always.
     */
    public R executeInterfaceBodyNode(InterfaceBodyNode node, P p)
    {
        return null;
    }
    
    /**
     * Performs no operation.
     * @param node Ignored.
     * @param p Ignored.
     * @return <code>null</code>, always.
     */
    public R executeInterfaceDeclarationNode(InterfaceDeclarationNode node, P p)
    {
        return null;
    }
    
    /**
     * Performs no operation.
     * @param node Ignored.
     * @param p Ignored.
     * @return <code>null</code>, always.
     */
    public R executeInterfaceMemberListNode(InterfaceMemberListNode node, P p)
    {
        return null;
    }
    
    /**
     * Performs no operation.
     * @param node Ignored.
     * @param p Ignored.
     * @return <code>null</code>, always.
     */
    public R executeInterfaceMemberMetaprogramAnchorNode(InterfaceMemberMetaprogramAnchorNode node, P p)
    {
        return null;
    }
    
    /**
     * Performs no operation.
     * @param node Ignored.
     * @param p Ignored.
     * @return <code>null</code>, always.
     */
    public R executeInterfaceModifiersNode(InterfaceModifiersNode node, P p)
    {
        return null;
    }
    
    /**
     * Performs no operation.
     * @param node Ignored.
     * @param p Ignored.
     * @return <code>null</code>, always.
     */
    public R executeJavadocNode(JavadocNode node, P p)
    {
        return null;
    }
    
    /**
     * Performs no operation.
     * @param node Ignored.
     * @param p Ignored.
     * @return <code>null</code>, always.
     */
    public R executeLabeledStatementNode(LabeledStatementNode node, P p)
    {
        return null;
    }
    
    /**
     * Performs no operation.
     * @param node Ignored.
     * @param p Ignored.
     * @return <code>null</code>, always.
     */
    public R executeLocalClassDeclarationNode(LocalClassDeclarationNode node, P p)
    {
        return null;
    }
    
    /**
     * Performs no operation.
     * @param node Ignored.
     * @param p Ignored.
     * @return <code>null</code>, always.
     */
    public R executeLocalClassModifiersNode(LocalClassModifiersNode node, P p)
    {
        return null;
    }
    
    /**
     * Performs no operation.
     * @param node Ignored.
     * @param p Ignored.
     * @return <code>null</code>, always.
     */
    public R executeLocalVariableDeclarationNode(LocalVariableDeclarationNode node, P p)
    {
        return null;
    }
    
    /**
     * Performs no operation.
     * @param node Ignored.
     * @param p Ignored.
     * @return <code>null</code>, always.
     */
    public R executeLongLiteralNode(LongLiteralNode node, P p)
    {
        return null;
    }
    
    /**
     * Performs no operation.
     * @param node Ignored.
     * @param p Ignored.
     * @return <code>null</code>, always.
     */
    public R executeMetaAnnotationArrayValueNode(MetaAnnotationArrayValueNode node, P p)
    {
        return null;
    }
    
    /**
     * Performs no operation.
     * @param node Ignored.
     * @param p Ignored.
     * @return <code>null</code>, always.
     */
    public R executeMetaAnnotationElementListNode(MetaAnnotationElementListNode node, P p)
    {
        return null;
    }
    
    /**
     * Performs no operation.
     * @param node Ignored.
     * @param p Ignored.
     * @return <code>null</code>, always.
     */
    public R executeMetaAnnotationElementNode(MetaAnnotationElementNode node, P p)
    {
        return null;
    }
    
    /**
     * Performs no operation.
     * @param node Ignored.
     * @param p Ignored.
     * @return <code>null</code>, always.
     */
    public R executeMetaAnnotationExpressionValueNode(MetaAnnotationExpressionValueNode node, P p)
    {
        return null;
    }
    
    /**
     * Performs no operation.
     * @param node Ignored.
     * @param p Ignored.
     * @return <code>null</code>, always.
     */
    public R executeMetaAnnotationListNode(MetaAnnotationListNode node, P p)
    {
        return null;
    }
    
    /**
     * Performs no operation.
     * @param node Ignored.
     * @param p Ignored.
     * @return <code>null</code>, always.
     */
    public R executeMetaAnnotationMetaAnnotationValueNode(MetaAnnotationMetaAnnotationValueNode node, P p)
    {
        return null;
    }
    
    /**
     * Performs no operation.
     * @param node Ignored.
     * @param p Ignored.
     * @return <code>null</code>, always.
     */
    public R executeMetaAnnotationMetaprogramAnchorNode(MetaAnnotationMetaprogramAnchorNode node, P p)
    {
        return null;
    }
    
    /**
     * Performs no operation.
     * @param node Ignored.
     * @param p Ignored.
     * @return <code>null</code>, always.
     */
    public R executeMetaAnnotationValueListNode(MetaAnnotationValueListNode node, P p)
    {
        return null;
    }
    
    /**
     * Performs no operation.
     * @param node Ignored.
     * @param p Ignored.
     * @return <code>null</code>, always.
     */
    public R executeMetaprogramDependencyDeclarationListNode(MetaprogramDependencyDeclarationListNode node, P p)
    {
        return null;
    }
    
    /**
     * Performs no operation.
     * @param node Ignored.
     * @param p Ignored.
     * @return <code>null</code>, always.
     */
    public R executeMetaprogramDependencyDeclarationNode(MetaprogramDependencyDeclarationNode node, P p)
    {
        return null;
    }
    
    /**
     * Performs no operation.
     * @param node Ignored.
     * @param p Ignored.
     * @return <code>null</code>, always.
     */
    public R executeMetaprogramDependencyListNode(MetaprogramDependencyListNode node, P p)
    {
        return null;
    }
    
    /**
     * Performs no operation.
     * @param node Ignored.
     * @param p Ignored.
     * @return <code>null</code>, always.
     */
    public R executeMetaprogramDependencyNode(MetaprogramDependencyNode node, P p)
    {
        return null;
    }
    
    /**
     * Performs no operation.
     * @param node Ignored.
     * @param p Ignored.
     * @return <code>null</code>, always.
     */
    public R executeMetaprogramImportListNode(MetaprogramImportListNode node, P p)
    {
        return null;
    }
    
    /**
     * Performs no operation.
     * @param node Ignored.
     * @param p Ignored.
     * @return <code>null</code>, always.
     */
    public R executeMetaprogramImportNode(MetaprogramImportNode node, P p)
    {
        return null;
    }
    
    /**
     * Performs no operation.
     * @param node Ignored.
     * @param p Ignored.
     * @return <code>null</code>, always.
     */
    public R executeMetaprogramNode(MetaprogramNode node, P p)
    {
        return null;
    }
    
    /**
     * Performs no operation.
     * @param node Ignored.
     * @param p Ignored.
     * @return <code>null</code>, always.
     */
    public R executeMetaprogramPreambleNode(MetaprogramPreambleNode node, P p)
    {
        return null;
    }
    
    /**
     * Performs no operation.
     * @param node Ignored.
     * @param p Ignored.
     * @return <code>null</code>, always.
     */
    public R executeMetaprogramTargetListNode(MetaprogramTargetListNode node, P p)
    {
        return null;
    }
    
    /**
     * Performs no operation.
     * @param node Ignored.
     * @param p Ignored.
     * @return <code>null</code>, always.
     */
    public R executeMetaprogramTargetNode(MetaprogramTargetNode node, P p)
    {
        return null;
    }
    
    /**
     * Performs no operation.
     * @param node Ignored.
     * @param p Ignored.
     * @return <code>null</code>, always.
     */
    public R executeMethodDeclarationNode(MethodDeclarationNode node, P p)
    {
        return null;
    }
    
    /**
     * Performs no operation.
     * @param node Ignored.
     * @param p Ignored.
     * @return <code>null</code>, always.
     */
    public R executeMethodInvocationByExpressionNode(MethodInvocationByExpressionNode node, P p)
    {
        return null;
    }
    
    /**
     * Performs no operation.
     * @param node Ignored.
     * @param p Ignored.
     * @return <code>null</code>, always.
     */
    public R executeMethodInvocationByNameNode(MethodInvocationByNameNode node, P p)
    {
        return null;
    }
    
    /**
     * Performs no operation.
     * @param node Ignored.
     * @param p Ignored.
     * @return <code>null</code>, always.
     */
    public R executeMethodModifiersNode(MethodModifiersNode node, P p)
    {
        return null;
    }
    
    /**
     * Performs no operation.
     * @param node Ignored.
     * @param p Ignored.
     * @return <code>null</code>, always.
     */
    public R executeNoOperationNode(NoOperationNode node, P p)
    {
        return null;
    }
    
    /**
     * Performs no operation.
     * @param node Ignored.
     * @param p Ignored.
     * @return <code>null</code>, always.
     */
    public R executeNormalAnnotationNode(NormalAnnotationNode node, P p)
    {
        return null;
    }
    
    /**
     * Performs no operation.
     * @param node Ignored.
     * @param p Ignored.
     * @return <code>null</code>, always.
     */
    public R executeNormalMetaAnnotationNode(NormalMetaAnnotationNode node, P p)
    {
        return null;
    }
    
    /**
     * Performs no operation.
     * @param node Ignored.
     * @param p Ignored.
     * @return <code>null</code>, always.
     */
    public R executeNullLiteralNode(NullLiteralNode node, P p)
    {
        return null;
    }
    
    /**
     * Performs no operation.
     * @param node Ignored.
     * @param p Ignored.
     * @return <code>null</code>, always.
     */
    public R executePackageDeclarationNode(PackageDeclarationNode node, P p)
    {
        return null;
    }
    
    /**
     * Performs no operation.
     * @param node Ignored.
     * @param p Ignored.
     * @return <code>null</code>, always.
     */
    public R executePackageNode(PackageNode node, P p)
    {
        return null;
    }
    
    /**
     * Performs no operation.
     * @param node Ignored.
     * @param p Ignored.
     * @return <code>null</code>, always.
     */
    public R executeParameterizedTypeNode(ParameterizedTypeNode node, P p)
    {
        return null;
    }
    
    /**
     * Performs no operation.
     * @param node Ignored.
     * @param p Ignored.
     * @return <code>null</code>, always.
     */
    public R executeParameterizedTypeSelectNode(ParameterizedTypeSelectNode node, P p)
    {
        return null;
    }
    
    /**
     * Performs no operation.
     * @param node Ignored.
     * @param p Ignored.
     * @return <code>null</code>, always.
     */
    public R executeParenthesizedExpressionNode(ParenthesizedExpressionNode node, P p)
    {
        return null;
    }
    
    /**
     * Performs no operation.
     * @param node Ignored.
     * @param p Ignored.
     * @return <code>null</code>, always.
     */
    public R executePrimitiveTypeNode(PrimitiveTypeNode node, P p)
    {
        return null;
    }
    
    /**
     * Performs no operation.
     * @param node Ignored.
     * @param p Ignored.
     * @return <code>null</code>, always.
     */
    public R executeQualifiedClassInstantiationNode(QualifiedClassInstantiationNode node, P p)
    {
        return null;
    }
    
    /**
     * Performs no operation.
     * @param node Ignored.
     * @param p Ignored.
     * @return <code>null</code>, always.
     */
    public R executeQualifiedNameNode(QualifiedNameNode node, P p)
    {
        return null;
    }
    
    /**
     * Performs no operation.
     * @param node Ignored.
     * @param p Ignored.
     * @return <code>null</code>, always.
     */
    public R executeRawCodeLiteralNode(RawCodeLiteralNode node, P p)
    {
        return null;
    }
    
    /**
     * Performs no operation.
     * @param node Ignored.
     * @param p Ignored.
     * @return <code>null</code>, always.
     */
    public R executeReferenceTypeListNode(ReferenceTypeListNode node, P p)
    {
        return null;
    }
    
    /**
     * Performs no operation.
     * @param node Ignored.
     * @param p Ignored.
     * @return <code>null</code>, always.
     */
    public R executeReturnNode(ReturnNode node, P p)
    {
        return null;
    }
    
    /**
     * Performs no operation.
     * @param node Ignored.
     * @param p Ignored.
     * @return <code>null</code>, always.
     */
    public R executeSimpleNameNode(SimpleNameNode node, P p)
    {
        return null;
    }
    
    /**
     * Performs no operation.
     * @param node Ignored.
     * @param p Ignored.
     * @return <code>null</code>, always.
     */
    public R executeSingleElementAnnotationNode(SingleElementAnnotationNode node, P p)
    {
        return null;
    }
    
    /**
     * Performs no operation.
     * @param node Ignored.
     * @param p Ignored.
     * @return <code>null</code>, always.
     */
    public R executeSingleElementMetaAnnotationNode(SingleElementMetaAnnotationNode node, P p)
    {
        return null;
    }
    
    /**
     * Performs no operation.
     * @param node Ignored.
     * @param p Ignored.
     * @return <code>null</code>, always.
     */
    public R executeSingleStaticImportNode(SingleStaticImportNode node, P p)
    {
        return null;
    }
    
    /**
     * Performs no operation.
     * @param node Ignored.
     * @param p Ignored.
     * @return <code>null</code>, always.
     */
    public R executeStatementExpressionListNode(StatementExpressionListNode node, P p)
    {
        return null;
    }
    
    /**
     * Performs no operation.
     * @param node Ignored.
     * @param p Ignored.
     * @return <code>null</code>, always.
     */
    public R executeStaticImportOnDemandNode(StaticImportOnDemandNode node, P p)
    {
        return null;
    }
    
    /**
     * Performs no operation.
     * @param node Ignored.
     * @param p Ignored.
     * @return <code>null</code>, always.
     */
    public R executeStringLiteralNode(StringLiteralNode node, P p)
    {
        return null;
    }
    
    /**
     * Performs no operation.
     * @param node Ignored.
     * @param p Ignored.
     * @return <code>null</code>, always.
     */
    public R executeSuperFieldAccessNode(SuperFieldAccessNode node, P p)
    {
        return null;
    }
    
    /**
     * Performs no operation.
     * @param node Ignored.
     * @param p Ignored.
     * @return <code>null</code>, always.
     */
    public R executeSuperMethodInvocationNode(SuperMethodInvocationNode node, P p)
    {
        return null;
    }
    
    /**
     * Performs no operation.
     * @param node Ignored.
     * @param p Ignored.
     * @return <code>null</code>, always.
     */
    public R executeSuperclassConstructorInvocationNode(SuperclassConstructorInvocationNode node, P p)
    {
        return null;
    }
    
    /**
     * Performs no operation.
     * @param node Ignored.
     * @param p Ignored.
     * @return <code>null</code>, always.
     */
    public R executeSwitchNode(SwitchNode node, P p)
    {
        return null;
    }
    
    /**
     * Performs no operation.
     * @param node Ignored.
     * @param p Ignored.
     * @return <code>null</code>, always.
     */
    public R executeSynchronizedNode(SynchronizedNode node, P p)
    {
        return null;
    }
    
    /**
     * Performs no operation.
     * @param node Ignored.
     * @param p Ignored.
     * @return <code>null</code>, always.
     */
    public R executeThisNode(ThisNode node, P p)
    {
        return null;
    }
    
    /**
     * Performs no operation.
     * @param node Ignored.
     * @param p Ignored.
     * @return <code>null</code>, always.
     */
    public R executeThrowNode(ThrowNode node, P p)
    {
        return null;
    }
    
    /**
     * Performs no operation.
     * @param node Ignored.
     * @param p Ignored.
     * @return <code>null</code>, always.
     */
    public R executeTryNode(TryNode node, P p)
    {
        return null;
    }
    
    /**
     * Performs no operation.
     * @param node Ignored.
     * @param p Ignored.
     * @return <code>null</code>, always.
     */
    public R executeTypeArgumentListNode(TypeArgumentListNode node, P p)
    {
        return null;
    }
    
    /**
     * Performs no operation.
     * @param node Ignored.
     * @param p Ignored.
     * @return <code>null</code>, always.
     */
    public R executeTypeCastNode(TypeCastNode node, P p)
    {
        return null;
    }
    
    /**
     * Performs no operation.
     * @param node Ignored.
     * @param p Ignored.
     * @return <code>null</code>, always.
     */
    public R executeTypeDeclarationListNode(TypeDeclarationListNode node, P p)
    {
        return null;
    }
    
    /**
     * Performs no operation.
     * @param node Ignored.
     * @param p Ignored.
     * @return <code>null</code>, always.
     */
    public R executeTypeDeclarationMetaprogramAnchorNode(TypeDeclarationMetaprogramAnchorNode node, P p)
    {
        return null;
    }
    
    /**
     * Performs no operation.
     * @param node Ignored.
     * @param p Ignored.
     * @return <code>null</code>, always.
     */
    public R executeTypeParameterListNode(TypeParameterListNode node, P p)
    {
        return null;
    }
    
    /**
     * Performs no operation.
     * @param node Ignored.
     * @param p Ignored.
     * @return <code>null</code>, always.
     */
    public R executeTypeParameterNode(TypeParameterNode node, P p)
    {
        return null;
    }
    
    /**
     * Performs no operation.
     * @param node Ignored.
     * @param p Ignored.
     * @return <code>null</code>, always.
     */
    public R executeUnaryExpressionNode(UnaryExpressionNode node, P p)
    {
        return null;
    }
    
    /**
     * Performs no operation.
     * @param node Ignored.
     * @param p Ignored.
     * @return <code>null</code>, always.
     */
    public R executeUnaryStatementExpressionNode(UnaryStatementExpressionNode node, P p)
    {
        return null;
    }
    
    /**
     * Performs no operation.
     * @param node Ignored.
     * @param p Ignored.
     * @return <code>null</code>, always.
     */
    public R executeUnparameterizedTypeListNode(UnparameterizedTypeListNode node, P p)
    {
        return null;
    }
    
    /**
     * Performs no operation.
     * @param node Ignored.
     * @param p Ignored.
     * @return <code>null</code>, always.
     */
    public R executeUnparameterizedTypeNode(UnparameterizedTypeNode node, P p)
    {
        return null;
    }
    
    /**
     * Performs no operation.
     * @param node Ignored.
     * @param p Ignored.
     * @return <code>null</code>, always.
     */
    public R executeUnqualifiedClassInstantiationNode(UnqualifiedClassInstantiationNode node, P p)
    {
        return null;
    }
    
    /**
     * Performs no operation.
     * @param node Ignored.
     * @param p Ignored.
     * @return <code>null</code>, always.
     */
    public R executeVariableAccessByExpressionNode(VariableAccessByExpressionNode node, P p)
    {
        return null;
    }
    
    /**
     * Performs no operation.
     * @param node Ignored.
     * @param p Ignored.
     * @return <code>null</code>, always.
     */
    public R executeVariableAccessByNameNode(VariableAccessByNameNode node, P p)
    {
        return null;
    }
    
    /**
     * Performs no operation.
     * @param node Ignored.
     * @param p Ignored.
     * @return <code>null</code>, always.
     */
    public R executeVariableDeclaratorListNode(VariableDeclaratorListNode node, P p)
    {
        return null;
    }
    
    /**
     * Performs no operation.
     * @param node Ignored.
     * @param p Ignored.
     * @return <code>null</code>, always.
     */
    public R executeVariableDeclaratorNode(VariableDeclaratorNode node, P p)
    {
        return null;
    }
    
    /**
     * Performs no operation.
     * @param node Ignored.
     * @param p Ignored.
     * @return <code>null</code>, always.
     */
    public R executeVariableInitializerListNode(VariableInitializerListNode node, P p)
    {
        return null;
    }
    
    /**
     * Performs no operation.
     * @param node Ignored.
     * @param p Ignored.
     * @return <code>null</code>, always.
     */
    public R executeVariableListNode(VariableListNode node, P p)
    {
        return null;
    }
    
    /**
     * Performs no operation.
     * @param node Ignored.
     * @param p Ignored.
     * @return <code>null</code>, always.
     */
    public R executeVariableModifiersNode(VariableModifiersNode node, P p)
    {
        return null;
    }
    
    /**
     * Performs no operation.
     * @param node Ignored.
     * @param p Ignored.
     * @return <code>null</code>, always.
     */
    public R executeVariableNode(VariableNode node, P p)
    {
        return null;
    }
    
    /**
     * Performs no operation.
     * @param node Ignored.
     * @param p Ignored.
     * @return <code>null</code>, always.
     */
    public R executeVoidTypeNode(VoidTypeNode node, P p)
    {
        return null;
    }
    
    /**
     * Performs no operation.
     * @param node Ignored.
     * @param p Ignored.
     * @return <code>null</code>, always.
     */
    public R executeWhileLoopNode(WhileLoopNode node, P p)
    {
        return null;
    }
    
    /**
     * Performs no operation.
     * @param node Ignored.
     * @param p Ignored.
     * @return <code>null</code>, always.
     */
    public R executeWildcardTypeNode(WildcardTypeNode node, P p)
    {
        return null;
    }
    
}
