/*
 * WARNING: THIS FILE IS GENERATED.  Do not make any changes to this file
 * directly; it was generated from the BSJ source generator project.  If changes
 * are necessary, changes must be applied either to the source generator
 * application or to one of its data files.  The source generator's fully
 * qualified name is edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator.
 */

package edu.jhu.cs.bsj.compiler.impl.ast;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.NodeUnion;
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
import edu.jhu.cs.bsj.compiler.ast.node.list.ListNode;
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
import edu.jhu.cs.bsj.compiler.ast.node.meta.ExplicitMetaprogramAnchorNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.InterfaceMemberMetaprogramAnchorNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaAnnotationArrayValueNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaAnnotationElementListNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaAnnotationElementNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaAnnotationExpressionValueNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaAnnotationListNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaAnnotationMetaAnnotationValueNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaAnnotationMetaprogramAnchorNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaAnnotationNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaAnnotationValueListNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaAnnotationValueNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramAnchorNode;
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
import edu.jhu.cs.bsj.compiler.impl.utils.BijectiveMap;

/**
 * This interface acts as a BSJ proxy node factory for the standard BSJ compiler.  This interface should not be exposed
 * to the public compiler API as type safety depends on it being used in a constrained way.
 * 
 * @author Zachary Palmer
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface BsjNodeProxyFactory
{
    /**
     * Retrieves a mapping from the IDs of nodes generated by this proxy to the IDs of nodes that they wrapped.
     */
    public BijectiveMap<Long,Long> getProxyIdMapping();
    /**
     * Creates a {@link NodeUnion} value containing a normal node.
     * @param node The node to use.
     * @return The resulting node union.
     */
    public <T extends Node> NodeUnion<T> makeNormalNodeUnion(T node);
    
    /**
     * Creates a {@link NodeUnion} value containing a splice node.
     * @param node The node to use.
     * @return The resulting node union.
     */
    public <T extends Node> NodeUnion<T> makeSpliceNodeUnion(SpliceNode node);
    
    /**
     * Creates a proxy for a AbstractInvokableDeclarationNode.
     * @param node The node to use.
     * @return The resulting proxy node.
     */
    public <T extends ModifiersNode> AbstractInvokableDeclarationNode<T> makeAbstractInvokableDeclarationNode(AbstractInvokableDeclarationNode<T> node);
    
    /**
     * Creates a proxy for a AbstractMemberVariableDeclarationNode.
     * @param node The node to use.
     * @return The resulting proxy node.
     */
    public <T extends ModifiersNode> AbstractMemberVariableDeclarationNode<T> makeAbstractMemberVariableDeclarationNode(AbstractMemberVariableDeclarationNode<T> node);
    
    /**
     * Creates a proxy for a AbstractlyUnmodifiedClassDeclarationNode.
     * @param node The node to use.
     * @return The resulting proxy node.
     */
    public <T extends ModifiersNode> AbstractlyUnmodifiedClassDeclarationNode<T> makeAbstractlyUnmodifiedClassDeclarationNode(AbstractlyUnmodifiedClassDeclarationNode<T> node);
    
    /**
     * Creates a proxy for a AccessibleTypeModifiersNode.
     * @param node The node to use.
     * @return The resulting proxy node.
     */
    public AccessibleTypeModifiersNode makeAccessibleTypeModifiersNode(AccessibleTypeModifiersNode node);
    
    /**
     * Creates a proxy for a AlternateConstructorInvocationNode.
     * @param node The node to use.
     * @return The resulting proxy node.
     */
    public AlternateConstructorInvocationNode makeAlternateConstructorInvocationNode(AlternateConstructorInvocationNode node);
    
    /**
     * Creates a proxy for a AnnotationAnnotationValueNode.
     * @param node The node to use.
     * @return The resulting proxy node.
     */
    public AnnotationAnnotationValueNode makeAnnotationAnnotationValueNode(AnnotationAnnotationValueNode node);
    
    /**
     * Creates a proxy for a AnnotationArrayValueNode.
     * @param node The node to use.
     * @return The resulting proxy node.
     */
    public AnnotationArrayValueNode makeAnnotationArrayValueNode(AnnotationArrayValueNode node);
    
    /**
     * Creates a proxy for a AnnotationBodyNode.
     * @param node The node to use.
     * @return The resulting proxy node.
     */
    public AnnotationBodyNode makeAnnotationBodyNode(AnnotationBodyNode node);
    
    /**
     * Creates a proxy for a AnnotationDeclarationNode.
     * @param node The node to use.
     * @return The resulting proxy node.
     */
    public AnnotationDeclarationNode makeAnnotationDeclarationNode(AnnotationDeclarationNode node);
    
    /**
     * Creates a proxy for a AnnotationElementListNode.
     * @param node The node to use.
     * @return The resulting proxy node.
     */
    public AnnotationElementListNode makeAnnotationElementListNode(AnnotationElementListNode node);
    
    /**
     * Creates a proxy for a AnnotationElementNode.
     * @param node The node to use.
     * @return The resulting proxy node.
     */
    public AnnotationElementNode makeAnnotationElementNode(AnnotationElementNode node);
    
    /**
     * Creates a proxy for a AnnotationExpressionValueNode.
     * @param node The node to use.
     * @return The resulting proxy node.
     */
    public AnnotationExpressionValueNode makeAnnotationExpressionValueNode(AnnotationExpressionValueNode node);
    
    /**
     * Creates a proxy for a AnnotationListNode.
     * @param node The node to use.
     * @return The resulting proxy node.
     */
    public AnnotationListNode makeAnnotationListNode(AnnotationListNode node);
    
    /**
     * Creates a proxy for a AnnotationMemberListNode.
     * @param node The node to use.
     * @return The resulting proxy node.
     */
    public AnnotationMemberListNode makeAnnotationMemberListNode(AnnotationMemberListNode node);
    
    /**
     * Creates a proxy for a AnnotationMemberMetaprogramAnchorNode.
     * @param node The node to use.
     * @return The resulting proxy node.
     */
    public AnnotationMemberMetaprogramAnchorNode makeAnnotationMemberMetaprogramAnchorNode(AnnotationMemberMetaprogramAnchorNode node);
    
    /**
     * Creates a proxy for a AnnotationMemberNode.
     * @param node The node to use.
     * @return The resulting proxy node.
     */
    public AnnotationMemberNode makeAnnotationMemberNode(AnnotationMemberNode node);
    
    /**
     * Creates a proxy for a AnnotationMethodDeclarationNode.
     * @param node The node to use.
     * @return The resulting proxy node.
     */
    public AnnotationMethodDeclarationNode makeAnnotationMethodDeclarationNode(AnnotationMethodDeclarationNode node);
    
    /**
     * Creates a proxy for a AnnotationMethodModifiersNode.
     * @param node The node to use.
     * @return The resulting proxy node.
     */
    public AnnotationMethodModifiersNode makeAnnotationMethodModifiersNode(AnnotationMethodModifiersNode node);
    
    /**
     * Creates a proxy for a AnnotationModifiersNode.
     * @param node The node to use.
     * @return The resulting proxy node.
     */
    public AnnotationModifiersNode makeAnnotationModifiersNode(AnnotationModifiersNode node);
    
    /**
     * Creates a proxy for a AnnotationNode.
     * @param node The node to use.
     * @return The resulting proxy node.
     */
    public AnnotationNode makeAnnotationNode(AnnotationNode node);
    
    /**
     * Creates a proxy for a AnnotationValueListNode.
     * @param node The node to use.
     * @return The resulting proxy node.
     */
    public AnnotationValueListNode makeAnnotationValueListNode(AnnotationValueListNode node);
    
    /**
     * Creates a proxy for a AnnotationValueNode.
     * @param node The node to use.
     * @return The resulting proxy node.
     */
    public AnnotationValueNode makeAnnotationValueNode(AnnotationValueNode node);
    
    /**
     * Creates a proxy for a AnonymousClassBodyNode.
     * @param node The node to use.
     * @return The resulting proxy node.
     */
    public AnonymousClassBodyNode makeAnonymousClassBodyNode(AnonymousClassBodyNode node);
    
    /**
     * Creates a proxy for a AnonymousClassMemberListNode.
     * @param node The node to use.
     * @return The resulting proxy node.
     */
    public AnonymousClassMemberListNode makeAnonymousClassMemberListNode(AnonymousClassMemberListNode node);
    
    /**
     * Creates a proxy for a AnonymousClassMemberMetaprogramAnchorNode.
     * @param node The node to use.
     * @return The resulting proxy node.
     */
    public AnonymousClassMemberMetaprogramAnchorNode makeAnonymousClassMemberMetaprogramAnchorNode(AnonymousClassMemberMetaprogramAnchorNode node);
    
    /**
     * Creates a proxy for a AnonymousClassMemberNode.
     * @param node The node to use.
     * @return The resulting proxy node.
     */
    public AnonymousClassMemberNode makeAnonymousClassMemberNode(AnonymousClassMemberNode node);
    
    /**
     * Creates a proxy for a ArrayAccessNode.
     * @param node The node to use.
     * @return The resulting proxy node.
     */
    public ArrayAccessNode makeArrayAccessNode(ArrayAccessNode node);
    
    /**
     * Creates a proxy for a ArrayCreationNode.
     * @param node The node to use.
     * @return The resulting proxy node.
     */
    public ArrayCreationNode makeArrayCreationNode(ArrayCreationNode node);
    
    /**
     * Creates a proxy for a ArrayInitializerCreationNode.
     * @param node The node to use.
     * @return The resulting proxy node.
     */
    public ArrayInitializerCreationNode makeArrayInitializerCreationNode(ArrayInitializerCreationNode node);
    
    /**
     * Creates a proxy for a ArrayInitializerNode.
     * @param node The node to use.
     * @return The resulting proxy node.
     */
    public ArrayInitializerNode makeArrayInitializerNode(ArrayInitializerNode node);
    
    /**
     * Creates a proxy for a ArrayInstantiatorCreationNode.
     * @param node The node to use.
     * @return The resulting proxy node.
     */
    public ArrayInstantiatorCreationNode makeArrayInstantiatorCreationNode(ArrayInstantiatorCreationNode node);
    
    /**
     * Creates a proxy for a ArrayTypeNode.
     * @param node The node to use.
     * @return The resulting proxy node.
     */
    public ArrayTypeNode makeArrayTypeNode(ArrayTypeNode node);
    
    /**
     * Creates a proxy for a AssertStatementNode.
     * @param node The node to use.
     * @return The resulting proxy node.
     */
    public AssertStatementNode makeAssertStatementNode(AssertStatementNode node);
    
    /**
     * Creates a proxy for a AssignmentNode.
     * @param node The node to use.
     * @return The resulting proxy node.
     */
    public AssignmentNode makeAssignmentNode(AssignmentNode node);
    
    /**
     * Creates a proxy for a BaseTypeNode.
     * @param node The node to use.
     * @return The resulting proxy node.
     */
    public BaseTypeNode makeBaseTypeNode(BaseTypeNode node);
    
    /**
     * Creates a proxy for a BinaryExpressionNode.
     * @param node The node to use.
     * @return The resulting proxy node.
     */
    public BinaryExpressionNode makeBinaryExpressionNode(BinaryExpressionNode node);
    
    /**
     * Creates a proxy for a BlockNode.
     * @param node The node to use.
     * @return The resulting proxy node.
     */
    public BlockNode makeBlockNode(BlockNode node);
    
    /**
     * Creates a proxy for a BlockStatementListNode.
     * @param node The node to use.
     * @return The resulting proxy node.
     */
    public BlockStatementListNode makeBlockStatementListNode(BlockStatementListNode node);
    
    /**
     * Creates a proxy for a BlockStatementMetaprogramAnchorNode.
     * @param node The node to use.
     * @return The resulting proxy node.
     */
    public BlockStatementMetaprogramAnchorNode makeBlockStatementMetaprogramAnchorNode(BlockStatementMetaprogramAnchorNode node);
    
    /**
     * Creates a proxy for a BlockStatementNode.
     * @param node The node to use.
     * @return The resulting proxy node.
     */
    public BlockStatementNode makeBlockStatementNode(BlockStatementNode node);
    
    /**
     * Creates a proxy for a BooleanLiteralNode.
     * @param node The node to use.
     * @return The resulting proxy node.
     */
    public BooleanLiteralNode makeBooleanLiteralNode(BooleanLiteralNode node);
    
    /**
     * Creates a proxy for a BreakNode.
     * @param node The node to use.
     * @return The resulting proxy node.
     */
    public BreakNode makeBreakNode(BreakNode node);
    
    /**
     * Creates a proxy for a CaseListNode.
     * @param node The node to use.
     * @return The resulting proxy node.
     */
    public CaseListNode makeCaseListNode(CaseListNode node);
    
    /**
     * Creates a proxy for a CaseNode.
     * @param node The node to use.
     * @return The resulting proxy node.
     */
    public CaseNode makeCaseNode(CaseNode node);
    
    /**
     * Creates a proxy for a CatchListNode.
     * @param node The node to use.
     * @return The resulting proxy node.
     */
    public CatchListNode makeCatchListNode(CatchListNode node);
    
    /**
     * Creates a proxy for a CatchNode.
     * @param node The node to use.
     * @return The resulting proxy node.
     */
    public CatchNode makeCatchNode(CatchNode node);
    
    /**
     * Creates a proxy for a CharLiteralNode.
     * @param node The node to use.
     * @return The resulting proxy node.
     */
    public CharLiteralNode makeCharLiteralNode(CharLiteralNode node);
    
    /**
     * Creates a proxy for a ClassBodyNode.
     * @param node The node to use.
     * @return The resulting proxy node.
     */
    public ClassBodyNode makeClassBodyNode(ClassBodyNode node);
    
    /**
     * Creates a proxy for a ClassDeclarationNode.
     * @param node The node to use.
     * @return The resulting proxy node.
     */
    public ClassDeclarationNode makeClassDeclarationNode(ClassDeclarationNode node);
    
    /**
     * Creates a proxy for a ClassInstantiationNode.
     * @param node The node to use.
     * @return The resulting proxy node.
     */
    public ClassInstantiationNode makeClassInstantiationNode(ClassInstantiationNode node);
    
    /**
     * Creates a proxy for a ClassLiteralNode.
     * @param node The node to use.
     * @return The resulting proxy node.
     */
    public ClassLiteralNode makeClassLiteralNode(ClassLiteralNode node);
    
    /**
     * Creates a proxy for a ClassMemberListNode.
     * @param node The node to use.
     * @return The resulting proxy node.
     */
    public ClassMemberListNode makeClassMemberListNode(ClassMemberListNode node);
    
    /**
     * Creates a proxy for a ClassMemberMetaprogramAnchorNode.
     * @param node The node to use.
     * @return The resulting proxy node.
     */
    public ClassMemberMetaprogramAnchorNode makeClassMemberMetaprogramAnchorNode(ClassMemberMetaprogramAnchorNode node);
    
    /**
     * Creates a proxy for a ClassMemberNode.
     * @param node The node to use.
     * @return The resulting proxy node.
     */
    public ClassMemberNode makeClassMemberNode(ClassMemberNode node);
    
    /**
     * Creates a proxy for a ClassModifiersNode.
     * @param node The node to use.
     * @return The resulting proxy node.
     */
    public ClassModifiersNode makeClassModifiersNode(ClassModifiersNode node);
    
    /**
     * Creates a proxy for a CodeLiteralNode.
     * @param node The node to use.
     * @return The resulting proxy node.
     */
    public CodeLiteralNode makeCodeLiteralNode(CodeLiteralNode node);
    
    /**
     * Creates a proxy for a CompilationUnitNode.
     * @param node The node to use.
     * @return The resulting proxy node.
     */
    public CompilationUnitNode makeCompilationUnitNode(CompilationUnitNode node);
    
    /**
     * Creates a proxy for a ConditionalExpressionNode.
     * @param node The node to use.
     * @return The resulting proxy node.
     */
    public ConditionalExpressionNode makeConditionalExpressionNode(ConditionalExpressionNode node);
    
    /**
     * Creates a proxy for a ConstantDeclarationNode.
     * @param node The node to use.
     * @return The resulting proxy node.
     */
    public ConstantDeclarationNode makeConstantDeclarationNode(ConstantDeclarationNode node);
    
    /**
     * Creates a proxy for a ConstantModifiersNode.
     * @param node The node to use.
     * @return The resulting proxy node.
     */
    public ConstantModifiersNode makeConstantModifiersNode(ConstantModifiersNode node);
    
    /**
     * Creates a proxy for a ConstructorBodyNode.
     * @param node The node to use.
     * @return The resulting proxy node.
     */
    public ConstructorBodyNode makeConstructorBodyNode(ConstructorBodyNode node);
    
    /**
     * Creates a proxy for a ConstructorDeclarationNode.
     * @param node The node to use.
     * @return The resulting proxy node.
     */
    public ConstructorDeclarationNode makeConstructorDeclarationNode(ConstructorDeclarationNode node);
    
    /**
     * Creates a proxy for a ConstructorInvocationNode.
     * @param node The node to use.
     * @return The resulting proxy node.
     */
    public ConstructorInvocationNode makeConstructorInvocationNode(ConstructorInvocationNode node);
    
    /**
     * Creates a proxy for a ConstructorModifiersNode.
     * @param node The node to use.
     * @return The resulting proxy node.
     */
    public ConstructorModifiersNode makeConstructorModifiersNode(ConstructorModifiersNode node);
    
    /**
     * Creates a proxy for a ContinueNode.
     * @param node The node to use.
     * @return The resulting proxy node.
     */
    public ContinueNode makeContinueNode(ContinueNode node);
    
    /**
     * Creates a proxy for a DeclarationNode.
     * @param node The node to use.
     * @return The resulting proxy node.
     */
    public DeclarationNode makeDeclarationNode(DeclarationNode node);
    
    /**
     * Creates a proxy for a DeclaredTypeListNode.
     * @param node The node to use.
     * @return The resulting proxy node.
     */
    public DeclaredTypeListNode makeDeclaredTypeListNode(DeclaredTypeListNode node);
    
    /**
     * Creates a proxy for a DeclaredTypeNode.
     * @param node The node to use.
     * @return The resulting proxy node.
     */
    public DeclaredTypeNode makeDeclaredTypeNode(DeclaredTypeNode node);
    
    /**
     * Creates a proxy for a DoWhileLoopNode.
     * @param node The node to use.
     * @return The resulting proxy node.
     */
    public DoWhileLoopNode makeDoWhileLoopNode(DoWhileLoopNode node);
    
    /**
     * Creates a proxy for a DoubleLiteralNode.
     * @param node The node to use.
     * @return The resulting proxy node.
     */
    public DoubleLiteralNode makeDoubleLiteralNode(DoubleLiteralNode node);
    
    /**
     * Creates a proxy for a EnhancedForLoopNode.
     * @param node The node to use.
     * @return The resulting proxy node.
     */
    public EnhancedForLoopNode makeEnhancedForLoopNode(EnhancedForLoopNode node);
    
    /**
     * Creates a proxy for a EnumBodyNode.
     * @param node The node to use.
     * @return The resulting proxy node.
     */
    public EnumBodyNode makeEnumBodyNode(EnumBodyNode node);
    
    /**
     * Creates a proxy for a EnumConstantDeclarationListNode.
     * @param node The node to use.
     * @return The resulting proxy node.
     */
    public EnumConstantDeclarationListNode makeEnumConstantDeclarationListNode(EnumConstantDeclarationListNode node);
    
    /**
     * Creates a proxy for a EnumConstantDeclarationNode.
     * @param node The node to use.
     * @return The resulting proxy node.
     */
    public EnumConstantDeclarationNode makeEnumConstantDeclarationNode(EnumConstantDeclarationNode node);
    
    /**
     * Creates a proxy for a EnumConstantModifiersNode.
     * @param node The node to use.
     * @return The resulting proxy node.
     */
    public EnumConstantModifiersNode makeEnumConstantModifiersNode(EnumConstantModifiersNode node);
    
    /**
     * Creates a proxy for a EnumDeclarationNode.
     * @param node The node to use.
     * @return The resulting proxy node.
     */
    public EnumDeclarationNode makeEnumDeclarationNode(EnumDeclarationNode node);
    
    /**
     * Creates a proxy for a EnumModifiersNode.
     * @param node The node to use.
     * @return The resulting proxy node.
     */
    public EnumModifiersNode makeEnumModifiersNode(EnumModifiersNode node);
    
    /**
     * Creates a proxy for a ExplicitMetaprogramAnchorNode.
     * @param node The node to use.
     * @return The resulting proxy node.
     */
    public <T extends Node> ExplicitMetaprogramAnchorNode<T> makeExplicitMetaprogramAnchorNode(ExplicitMetaprogramAnchorNode<T> node);
    
    /**
     * Creates a proxy for a ExpressionListNode.
     * @param node The node to use.
     * @return The resulting proxy node.
     */
    public ExpressionListNode makeExpressionListNode(ExpressionListNode node);
    
    /**
     * Creates a proxy for a ExpressionNode.
     * @param node The node to use.
     * @return The resulting proxy node.
     */
    public ExpressionNode makeExpressionNode(ExpressionNode node);
    
    /**
     * Creates a proxy for a ExpressionStatementNode.
     * @param node The node to use.
     * @return The resulting proxy node.
     */
    public ExpressionStatementNode makeExpressionStatementNode(ExpressionStatementNode node);
    
    /**
     * Creates a proxy for a FieldDeclarationNode.
     * @param node The node to use.
     * @return The resulting proxy node.
     */
    public FieldDeclarationNode makeFieldDeclarationNode(FieldDeclarationNode node);
    
    /**
     * Creates a proxy for a FieldModifiersNode.
     * @param node The node to use.
     * @return The resulting proxy node.
     */
    public FieldModifiersNode makeFieldModifiersNode(FieldModifiersNode node);
    
    /**
     * Creates a proxy for a FloatLiteralNode.
     * @param node The node to use.
     * @return The resulting proxy node.
     */
    public FloatLiteralNode makeFloatLiteralNode(FloatLiteralNode node);
    
    /**
     * Creates a proxy for a ForInitializerDeclarationNode.
     * @param node The node to use.
     * @return The resulting proxy node.
     */
    public ForInitializerDeclarationNode makeForInitializerDeclarationNode(ForInitializerDeclarationNode node);
    
    /**
     * Creates a proxy for a ForInitializerExpressionNode.
     * @param node The node to use.
     * @return The resulting proxy node.
     */
    public ForInitializerExpressionNode makeForInitializerExpressionNode(ForInitializerExpressionNode node);
    
    /**
     * Creates a proxy for a ForInitializerNode.
     * @param node The node to use.
     * @return The resulting proxy node.
     */
    public ForInitializerNode makeForInitializerNode(ForInitializerNode node);
    
    /**
     * Creates a proxy for a ForLoopNode.
     * @param node The node to use.
     * @return The resulting proxy node.
     */
    public ForLoopNode makeForLoopNode(ForLoopNode node);
    
    /**
     * Creates a proxy for a IdentifierListNode.
     * @param node The node to use.
     * @return The resulting proxy node.
     */
    public IdentifierListNode makeIdentifierListNode(IdentifierListNode node);
    
    /**
     * Creates a proxy for a IdentifierNode.
     * @param node The node to use.
     * @return The resulting proxy node.
     */
    public IdentifierNode makeIdentifierNode(IdentifierNode node);
    
    /**
     * Creates a proxy for a IfNode.
     * @param node The node to use.
     * @return The resulting proxy node.
     */
    public IfNode makeIfNode(IfNode node);
    
    /**
     * Creates a proxy for a ImportListNode.
     * @param node The node to use.
     * @return The resulting proxy node.
     */
    public ImportListNode makeImportListNode(ImportListNode node);
    
    /**
     * Creates a proxy for a ImportNode.
     * @param node The node to use.
     * @return The resulting proxy node.
     */
    public ImportNode makeImportNode(ImportNode node);
    
    /**
     * Creates a proxy for a ImportOnDemandNode.
     * @param node The node to use.
     * @return The resulting proxy node.
     */
    public ImportOnDemandNode makeImportOnDemandNode(ImportOnDemandNode node);
    
    /**
     * Creates a proxy for a ImportSingleTypeNode.
     * @param node The node to use.
     * @return The resulting proxy node.
     */
    public ImportSingleTypeNode makeImportSingleTypeNode(ImportSingleTypeNode node);
    
    /**
     * Creates a proxy for a InitializerDeclarationNode.
     * @param node The node to use.
     * @return The resulting proxy node.
     */
    public InitializerDeclarationNode makeInitializerDeclarationNode(InitializerDeclarationNode node);
    
    /**
     * Creates a proxy for a InstanceOfNode.
     * @param node The node to use.
     * @return The resulting proxy node.
     */
    public InstanceOfNode makeInstanceOfNode(InstanceOfNode node);
    
    /**
     * Creates a proxy for a IntLiteralNode.
     * @param node The node to use.
     * @return The resulting proxy node.
     */
    public IntLiteralNode makeIntLiteralNode(IntLiteralNode node);
    
    /**
     * Creates a proxy for a InterfaceBodyNode.
     * @param node The node to use.
     * @return The resulting proxy node.
     */
    public InterfaceBodyNode makeInterfaceBodyNode(InterfaceBodyNode node);
    
    /**
     * Creates a proxy for a InterfaceDeclarationNode.
     * @param node The node to use.
     * @return The resulting proxy node.
     */
    public InterfaceDeclarationNode makeInterfaceDeclarationNode(InterfaceDeclarationNode node);
    
    /**
     * Creates a proxy for a InterfaceMemberListNode.
     * @param node The node to use.
     * @return The resulting proxy node.
     */
    public InterfaceMemberListNode makeInterfaceMemberListNode(InterfaceMemberListNode node);
    
    /**
     * Creates a proxy for a InterfaceMemberMetaprogramAnchorNode.
     * @param node The node to use.
     * @return The resulting proxy node.
     */
    public InterfaceMemberMetaprogramAnchorNode makeInterfaceMemberMetaprogramAnchorNode(InterfaceMemberMetaprogramAnchorNode node);
    
    /**
     * Creates a proxy for a InterfaceMemberNode.
     * @param node The node to use.
     * @return The resulting proxy node.
     */
    public InterfaceMemberNode makeInterfaceMemberNode(InterfaceMemberNode node);
    
    /**
     * Creates a proxy for a InterfaceModifiersNode.
     * @param node The node to use.
     * @return The resulting proxy node.
     */
    public InterfaceModifiersNode makeInterfaceModifiersNode(InterfaceModifiersNode node);
    
    /**
     * Creates a proxy for a InvokableNameBindingNode.
     * @param node The node to use.
     * @return The resulting proxy node.
     */
    public InvokableNameBindingNode makeInvokableNameBindingNode(InvokableNameBindingNode node);
    
    /**
     * Creates a proxy for a JavadocNode.
     * @param node The node to use.
     * @return The resulting proxy node.
     */
    public JavadocNode makeJavadocNode(JavadocNode node);
    
    /**
     * Creates a proxy for a LabeledStatementNode.
     * @param node The node to use.
     * @return The resulting proxy node.
     */
    public LabeledStatementNode makeLabeledStatementNode(LabeledStatementNode node);
    
    /**
     * Creates a proxy for a ListNode.
     * @param node The node to use.
     * @return The resulting proxy node.
     */
    public <T extends Node> ListNode<T> makeListNode(ListNode<T> node);
    
    /**
     * Creates a proxy for a LiteralNode.
     * @param node The node to use.
     * @return The resulting proxy node.
     */
    public <T> LiteralNode<T> makeLiteralNode(LiteralNode<T> node);
    
    /**
     * Creates a proxy for a LiteralizableTypeNode.
     * @param node The node to use.
     * @return The resulting proxy node.
     */
    public LiteralizableTypeNode makeLiteralizableTypeNode(LiteralizableTypeNode node);
    
    /**
     * Creates a proxy for a LocalClassDeclarationNode.
     * @param node The node to use.
     * @return The resulting proxy node.
     */
    public LocalClassDeclarationNode makeLocalClassDeclarationNode(LocalClassDeclarationNode node);
    
    /**
     * Creates a proxy for a LocalClassModifiersNode.
     * @param node The node to use.
     * @return The resulting proxy node.
     */
    public LocalClassModifiersNode makeLocalClassModifiersNode(LocalClassModifiersNode node);
    
    /**
     * Creates a proxy for a LocalVariableDeclarationNode.
     * @param node The node to use.
     * @return The resulting proxy node.
     */
    public LocalVariableDeclarationNode makeLocalVariableDeclarationNode(LocalVariableDeclarationNode node);
    
    /**
     * Creates a proxy for a LongLiteralNode.
     * @param node The node to use.
     * @return The resulting proxy node.
     */
    public LongLiteralNode makeLongLiteralNode(LongLiteralNode node);
    
    /**
     * Creates a proxy for a MetaAnnotatableNode.
     * @param node The node to use.
     * @return The resulting proxy node.
     */
    public MetaAnnotatableNode makeMetaAnnotatableNode(MetaAnnotatableNode node);
    
    /**
     * Creates a proxy for a MetaAnnotationArrayValueNode.
     * @param node The node to use.
     * @return The resulting proxy node.
     */
    public MetaAnnotationArrayValueNode makeMetaAnnotationArrayValueNode(MetaAnnotationArrayValueNode node);
    
    /**
     * Creates a proxy for a MetaAnnotationElementListNode.
     * @param node The node to use.
     * @return The resulting proxy node.
     */
    public MetaAnnotationElementListNode makeMetaAnnotationElementListNode(MetaAnnotationElementListNode node);
    
    /**
     * Creates a proxy for a MetaAnnotationElementNode.
     * @param node The node to use.
     * @return The resulting proxy node.
     */
    public MetaAnnotationElementNode makeMetaAnnotationElementNode(MetaAnnotationElementNode node);
    
    /**
     * Creates a proxy for a MetaAnnotationExpressionValueNode.
     * @param node The node to use.
     * @return The resulting proxy node.
     */
    public MetaAnnotationExpressionValueNode makeMetaAnnotationExpressionValueNode(MetaAnnotationExpressionValueNode node);
    
    /**
     * Creates a proxy for a MetaAnnotationListNode.
     * @param node The node to use.
     * @return The resulting proxy node.
     */
    public MetaAnnotationListNode makeMetaAnnotationListNode(MetaAnnotationListNode node);
    
    /**
     * Creates a proxy for a MetaAnnotationMetaAnnotationValueNode.
     * @param node The node to use.
     * @return The resulting proxy node.
     */
    public MetaAnnotationMetaAnnotationValueNode makeMetaAnnotationMetaAnnotationValueNode(MetaAnnotationMetaAnnotationValueNode node);
    
    /**
     * Creates a proxy for a MetaAnnotationMetaprogramAnchorNode.
     * @param node The node to use.
     * @return The resulting proxy node.
     */
    public MetaAnnotationMetaprogramAnchorNode makeMetaAnnotationMetaprogramAnchorNode(MetaAnnotationMetaprogramAnchorNode node);
    
    /**
     * Creates a proxy for a MetaAnnotationNode.
     * @param node The node to use.
     * @return The resulting proxy node.
     */
    public MetaAnnotationNode makeMetaAnnotationNode(MetaAnnotationNode node);
    
    /**
     * Creates a proxy for a MetaAnnotationValueListNode.
     * @param node The node to use.
     * @return The resulting proxy node.
     */
    public MetaAnnotationValueListNode makeMetaAnnotationValueListNode(MetaAnnotationValueListNode node);
    
    /**
     * Creates a proxy for a MetaAnnotationValueNode.
     * @param node The node to use.
     * @return The resulting proxy node.
     */
    public MetaAnnotationValueNode makeMetaAnnotationValueNode(MetaAnnotationValueNode node);
    
    /**
     * Creates a proxy for a MetaprogramAnchorNode.
     * @param node The node to use.
     * @return The resulting proxy node.
     */
    public <T extends Node> MetaprogramAnchorNode<T> makeMetaprogramAnchorNode(MetaprogramAnchorNode<T> node);
    
    /**
     * Creates a proxy for a MetaprogramDependencyDeclarationListNode.
     * @param node The node to use.
     * @return The resulting proxy node.
     */
    public MetaprogramDependencyDeclarationListNode makeMetaprogramDependencyDeclarationListNode(MetaprogramDependencyDeclarationListNode node);
    
    /**
     * Creates a proxy for a MetaprogramDependencyDeclarationNode.
     * @param node The node to use.
     * @return The resulting proxy node.
     */
    public MetaprogramDependencyDeclarationNode makeMetaprogramDependencyDeclarationNode(MetaprogramDependencyDeclarationNode node);
    
    /**
     * Creates a proxy for a MetaprogramDependencyListNode.
     * @param node The node to use.
     * @return The resulting proxy node.
     */
    public MetaprogramDependencyListNode makeMetaprogramDependencyListNode(MetaprogramDependencyListNode node);
    
    /**
     * Creates a proxy for a MetaprogramDependencyNode.
     * @param node The node to use.
     * @return The resulting proxy node.
     */
    public MetaprogramDependencyNode makeMetaprogramDependencyNode(MetaprogramDependencyNode node);
    
    /**
     * Creates a proxy for a MetaprogramImportListNode.
     * @param node The node to use.
     * @return The resulting proxy node.
     */
    public MetaprogramImportListNode makeMetaprogramImportListNode(MetaprogramImportListNode node);
    
    /**
     * Creates a proxy for a MetaprogramImportNode.
     * @param node The node to use.
     * @return The resulting proxy node.
     */
    public MetaprogramImportNode makeMetaprogramImportNode(MetaprogramImportNode node);
    
    /**
     * Creates a proxy for a MetaprogramNode.
     * @param node The node to use.
     * @return The resulting proxy node.
     */
    public MetaprogramNode makeMetaprogramNode(MetaprogramNode node);
    
    /**
     * Creates a proxy for a MetaprogramPreambleNode.
     * @param node The node to use.
     * @return The resulting proxy node.
     */
    public MetaprogramPreambleNode makeMetaprogramPreambleNode(MetaprogramPreambleNode node);
    
    /**
     * Creates a proxy for a MetaprogramTargetListNode.
     * @param node The node to use.
     * @return The resulting proxy node.
     */
    public MetaprogramTargetListNode makeMetaprogramTargetListNode(MetaprogramTargetListNode node);
    
    /**
     * Creates a proxy for a MetaprogramTargetNode.
     * @param node The node to use.
     * @return The resulting proxy node.
     */
    public MetaprogramTargetNode makeMetaprogramTargetNode(MetaprogramTargetNode node);
    
    /**
     * Creates a proxy for a MethodDeclarationNode.
     * @param node The node to use.
     * @return The resulting proxy node.
     */
    public MethodDeclarationNode makeMethodDeclarationNode(MethodDeclarationNode node);
    
    /**
     * Creates a proxy for a MethodInvocationNode.
     * @param node The node to use.
     * @return The resulting proxy node.
     */
    public MethodInvocationNode makeMethodInvocationNode(MethodInvocationNode node);
    
    /**
     * Creates a proxy for a MethodModifiersNode.
     * @param node The node to use.
     * @return The resulting proxy node.
     */
    public MethodModifiersNode makeMethodModifiersNode(MethodModifiersNode node);
    
    /**
     * Creates a proxy for a ModifiedNode.
     * @param node The node to use.
     * @return The resulting proxy node.
     */
    public <T extends ModifiersNode> ModifiedNode<T> makeModifiedNode(ModifiedNode<T> node);
    
    /**
     * Creates a proxy for a ModifiersNode.
     * @param node The node to use.
     * @return The resulting proxy node.
     */
    public ModifiersNode makeModifiersNode(ModifiersNode node);
    
    /**
     * Creates a proxy for a NameNode.
     * @param node The node to use.
     * @return The resulting proxy node.
     */
    public NameNode makeNameNode(NameNode node);
    
    /**
     * Creates a proxy for a NamedTypeDeclarationNode.
     * @param node The node to use.
     * @return The resulting proxy node.
     */
    public <T extends Node> NamedTypeDeclarationNode<T> makeNamedTypeDeclarationNode(NamedTypeDeclarationNode<T> node);
    
    /**
     * Creates a proxy for a NoOperationNode.
     * @param node The node to use.
     * @return The resulting proxy node.
     */
    public NoOperationNode makeNoOperationNode(NoOperationNode node);
    
    /**
     * Creates a proxy for a Node.
     * @param node The node to use.
     * @return The resulting proxy node.
     */
    public Node makeNode(Node node);
    
    /**
     * Creates a proxy for a NonAssignmentExpressionNode.
     * @param node The node to use.
     * @return The resulting proxy node.
     */
    public NonAssignmentExpressionNode makeNonAssignmentExpressionNode(NonAssignmentExpressionNode node);
    
    /**
     * Creates a proxy for a NormalAnnotationNode.
     * @param node The node to use.
     * @return The resulting proxy node.
     */
    public NormalAnnotationNode makeNormalAnnotationNode(NormalAnnotationNode node);
    
    /**
     * Creates a proxy for a NormalMetaAnnotationNode.
     * @param node The node to use.
     * @return The resulting proxy node.
     */
    public NormalMetaAnnotationNode makeNormalMetaAnnotationNode(NormalMetaAnnotationNode node);
    
    /**
     * Creates a proxy for a NullLiteralNode.
     * @param node The node to use.
     * @return The resulting proxy node.
     */
    public NullLiteralNode makeNullLiteralNode(NullLiteralNode node);
    
    /**
     * Creates a proxy for a PackageDeclarationNode.
     * @param node The node to use.
     * @return The resulting proxy node.
     */
    public PackageDeclarationNode makePackageDeclarationNode(PackageDeclarationNode node);
    
    /**
     * Creates a proxy for a PackageNode.
     * @param node The node to use.
     * @return The resulting proxy node.
     */
    public PackageNode makePackageNode(PackageNode node);
    
    /**
     * Creates a proxy for a ParameterizableTypeDeclarationNode.
     * @param node The node to use.
     * @return The resulting proxy node.
     */
    public ParameterizableTypeDeclarationNode makeParameterizableTypeDeclarationNode(ParameterizableTypeDeclarationNode node);
    
    /**
     * Creates a proxy for a ParameterizedTypeNode.
     * @param node The node to use.
     * @return The resulting proxy node.
     */
    public ParameterizedTypeNode makeParameterizedTypeNode(ParameterizedTypeNode node);
    
    /**
     * Creates a proxy for a ParameterizedTypeSelectNode.
     * @param node The node to use.
     * @return The resulting proxy node.
     */
    public ParameterizedTypeSelectNode makeParameterizedTypeSelectNode(ParameterizedTypeSelectNode node);
    
    /**
     * Creates a proxy for a ParenthesizedExpressionNode.
     * @param node The node to use.
     * @return The resulting proxy node.
     */
    public ParenthesizedExpressionNode makeParenthesizedExpressionNode(ParenthesizedExpressionNode node);
    
    /**
     * Creates a proxy for a PrimaryExpressionNode.
     * @param node The node to use.
     * @return The resulting proxy node.
     */
    public PrimaryExpressionNode makePrimaryExpressionNode(PrimaryExpressionNode node);
    
    /**
     * Creates a proxy for a PrimitiveTypeNode.
     * @param node The node to use.
     * @return The resulting proxy node.
     */
    public PrimitiveTypeNode makePrimitiveTypeNode(PrimitiveTypeNode node);
    
    /**
     * Creates a proxy for a QualifiedClassInstantiationNode.
     * @param node The node to use.
     * @return The resulting proxy node.
     */
    public QualifiedClassInstantiationNode makeQualifiedClassInstantiationNode(QualifiedClassInstantiationNode node);
    
    /**
     * Creates a proxy for a QualifiedNameNode.
     * @param node The node to use.
     * @return The resulting proxy node.
     */
    public QualifiedNameNode makeQualifiedNameNode(QualifiedNameNode node);
    
    /**
     * Creates a proxy for a RawCodeLiteralNode.
     * @param node The node to use.
     * @return The resulting proxy node.
     */
    public RawCodeLiteralNode makeRawCodeLiteralNode(RawCodeLiteralNode node);
    
    /**
     * Creates a proxy for a ReferenceTypeListNode.
     * @param node The node to use.
     * @return The resulting proxy node.
     */
    public ReferenceTypeListNode makeReferenceTypeListNode(ReferenceTypeListNode node);
    
    /**
     * Creates a proxy for a ReferenceTypeNode.
     * @param node The node to use.
     * @return The resulting proxy node.
     */
    public ReferenceTypeNode makeReferenceTypeNode(ReferenceTypeNode node);
    
    /**
     * Creates a proxy for a RestrictedPrimaryExpressionNode.
     * @param node The node to use.
     * @return The resulting proxy node.
     */
    public RestrictedPrimaryExpressionNode makeRestrictedPrimaryExpressionNode(RestrictedPrimaryExpressionNode node);
    
    /**
     * Creates a proxy for a ReturnNode.
     * @param node The node to use.
     * @return The resulting proxy node.
     */
    public ReturnNode makeReturnNode(ReturnNode node);
    
    /**
     * Creates a proxy for a SimpleNameNode.
     * @param node The node to use.
     * @return The resulting proxy node.
     */
    public SimpleNameNode makeSimpleNameNode(SimpleNameNode node);
    
    /**
     * Creates a proxy for a SingleElementAnnotationNode.
     * @param node The node to use.
     * @return The resulting proxy node.
     */
    public SingleElementAnnotationNode makeSingleElementAnnotationNode(SingleElementAnnotationNode node);
    
    /**
     * Creates a proxy for a SingleElementMetaAnnotationNode.
     * @param node The node to use.
     * @return The resulting proxy node.
     */
    public SingleElementMetaAnnotationNode makeSingleElementMetaAnnotationNode(SingleElementMetaAnnotationNode node);
    
    /**
     * Creates a proxy for a SingleStaticImportNode.
     * @param node The node to use.
     * @return The resulting proxy node.
     */
    public SingleStaticImportNode makeSingleStaticImportNode(SingleStaticImportNode node);
    
    /**
     * Creates a proxy for a SpliceNode.
     * @param node The node to use.
     * @return The resulting proxy node.
     */
    public SpliceNode makeSpliceNode(SpliceNode node);
    
    /**
     * Creates a proxy for a StatementExpressionListNode.
     * @param node The node to use.
     * @return The resulting proxy node.
     */
    public StatementExpressionListNode makeStatementExpressionListNode(StatementExpressionListNode node);
    
    /**
     * Creates a proxy for a StatementExpressionNode.
     * @param node The node to use.
     * @return The resulting proxy node.
     */
    public StatementExpressionNode makeStatementExpressionNode(StatementExpressionNode node);
    
    /**
     * Creates a proxy for a StatementNode.
     * @param node The node to use.
     * @return The resulting proxy node.
     */
    public StatementNode makeStatementNode(StatementNode node);
    
    /**
     * Creates a proxy for a StaticImportOnDemandNode.
     * @param node The node to use.
     * @return The resulting proxy node.
     */
    public StaticImportOnDemandNode makeStaticImportOnDemandNode(StaticImportOnDemandNode node);
    
    /**
     * Creates a proxy for a StringLiteralNode.
     * @param node The node to use.
     * @return The resulting proxy node.
     */
    public StringLiteralNode makeStringLiteralNode(StringLiteralNode node);
    
    /**
     * Creates a proxy for a SuperFieldAccessNode.
     * @param node The node to use.
     * @return The resulting proxy node.
     */
    public SuperFieldAccessNode makeSuperFieldAccessNode(SuperFieldAccessNode node);
    
    /**
     * Creates a proxy for a SuperMethodInvocationNode.
     * @param node The node to use.
     * @return The resulting proxy node.
     */
    public SuperMethodInvocationNode makeSuperMethodInvocationNode(SuperMethodInvocationNode node);
    
    /**
     * Creates a proxy for a SuperclassConstructorInvocationNode.
     * @param node The node to use.
     * @return The resulting proxy node.
     */
    public SuperclassConstructorInvocationNode makeSuperclassConstructorInvocationNode(SuperclassConstructorInvocationNode node);
    
    /**
     * Creates a proxy for a SwitchNode.
     * @param node The node to use.
     * @return The resulting proxy node.
     */
    public SwitchNode makeSwitchNode(SwitchNode node);
    
    /**
     * Creates a proxy for a SynchronizedNode.
     * @param node The node to use.
     * @return The resulting proxy node.
     */
    public SynchronizedNode makeSynchronizedNode(SynchronizedNode node);
    
    /**
     * Creates a proxy for a ThisNode.
     * @param node The node to use.
     * @return The resulting proxy node.
     */
    public ThisNode makeThisNode(ThisNode node);
    
    /**
     * Creates a proxy for a ThrowNode.
     * @param node The node to use.
     * @return The resulting proxy node.
     */
    public ThrowNode makeThrowNode(ThrowNode node);
    
    /**
     * Creates a proxy for a TryNode.
     * @param node The node to use.
     * @return The resulting proxy node.
     */
    public TryNode makeTryNode(TryNode node);
    
    /**
     * Creates a proxy for a TypeArgumentListNode.
     * @param node The node to use.
     * @return The resulting proxy node.
     */
    public TypeArgumentListNode makeTypeArgumentListNode(TypeArgumentListNode node);
    
    /**
     * Creates a proxy for a TypeArgumentNode.
     * @param node The node to use.
     * @return The resulting proxy node.
     */
    public TypeArgumentNode makeTypeArgumentNode(TypeArgumentNode node);
    
    /**
     * Creates a proxy for a TypeBodyNode.
     * @param node The node to use.
     * @return The resulting proxy node.
     */
    public <T extends Node> TypeBodyNode<T> makeTypeBodyNode(TypeBodyNode<T> node);
    
    /**
     * Creates a proxy for a TypeCastNode.
     * @param node The node to use.
     * @return The resulting proxy node.
     */
    public TypeCastNode makeTypeCastNode(TypeCastNode node);
    
    /**
     * Creates a proxy for a TypeDeclarationListNode.
     * @param node The node to use.
     * @return The resulting proxy node.
     */
    public TypeDeclarationListNode makeTypeDeclarationListNode(TypeDeclarationListNode node);
    
    /**
     * Creates a proxy for a TypeDeclarationMetaprogramAnchorNode.
     * @param node The node to use.
     * @return The resulting proxy node.
     */
    public TypeDeclarationMetaprogramAnchorNode makeTypeDeclarationMetaprogramAnchorNode(TypeDeclarationMetaprogramAnchorNode node);
    
    /**
     * Creates a proxy for a TypeDeclarationNode.
     * @param node The node to use.
     * @return The resulting proxy node.
     */
    public TypeDeclarationNode makeTypeDeclarationNode(TypeDeclarationNode node);
    
    /**
     * Creates a proxy for a TypeNameBindingNode.
     * @param node The node to use.
     * @return The resulting proxy node.
     */
    public TypeNameBindingNode makeTypeNameBindingNode(TypeNameBindingNode node);
    
    /**
     * Creates a proxy for a TypeNode.
     * @param node The node to use.
     * @return The resulting proxy node.
     */
    public TypeNode makeTypeNode(TypeNode node);
    
    /**
     * Creates a proxy for a TypeParameterListNode.
     * @param node The node to use.
     * @return The resulting proxy node.
     */
    public TypeParameterListNode makeTypeParameterListNode(TypeParameterListNode node);
    
    /**
     * Creates a proxy for a TypeParameterNode.
     * @param node The node to use.
     * @return The resulting proxy node.
     */
    public TypeParameterNode makeTypeParameterNode(TypeParameterNode node);
    
    /**
     * Creates a proxy for a UnaryExpressionNode.
     * @param node The node to use.
     * @return The resulting proxy node.
     */
    public UnaryExpressionNode makeUnaryExpressionNode(UnaryExpressionNode node);
    
    /**
     * Creates a proxy for a UnaryStatementExpressionNode.
     * @param node The node to use.
     * @return The resulting proxy node.
     */
    public UnaryStatementExpressionNode makeUnaryStatementExpressionNode(UnaryStatementExpressionNode node);
    
    /**
     * Creates a proxy for a UnparameterizedTypeListNode.
     * @param node The node to use.
     * @return The resulting proxy node.
     */
    public UnparameterizedTypeListNode makeUnparameterizedTypeListNode(UnparameterizedTypeListNode node);
    
    /**
     * Creates a proxy for a UnparameterizedTypeNode.
     * @param node The node to use.
     * @return The resulting proxy node.
     */
    public UnparameterizedTypeNode makeUnparameterizedTypeNode(UnparameterizedTypeNode node);
    
    /**
     * Creates a proxy for a UnqualifiedClassInstantiationNode.
     * @param node The node to use.
     * @return The resulting proxy node.
     */
    public UnqualifiedClassInstantiationNode makeUnqualifiedClassInstantiationNode(UnqualifiedClassInstantiationNode node);
    
    /**
     * Creates a proxy for a VariableAccessNode.
     * @param node The node to use.
     * @return The resulting proxy node.
     */
    public VariableAccessNode makeVariableAccessNode(VariableAccessNode node);
    
    /**
     * Creates a proxy for a VariableDeclaratorListNode.
     * @param node The node to use.
     * @return The resulting proxy node.
     */
    public VariableDeclaratorListNode makeVariableDeclaratorListNode(VariableDeclaratorListNode node);
    
    /**
     * Creates a proxy for a VariableDeclaratorNode.
     * @param node The node to use.
     * @return The resulting proxy node.
     */
    public VariableDeclaratorNode makeVariableDeclaratorNode(VariableDeclaratorNode node);
    
    /**
     * Creates a proxy for a VariableDeclaratorOwnerNode.
     * @param node The node to use.
     * @return The resulting proxy node.
     */
    public VariableDeclaratorOwnerNode makeVariableDeclaratorOwnerNode(VariableDeclaratorOwnerNode node);
    
    /**
     * Creates a proxy for a VariableInitializerListNode.
     * @param node The node to use.
     * @return The resulting proxy node.
     */
    public VariableInitializerListNode makeVariableInitializerListNode(VariableInitializerListNode node);
    
    /**
     * Creates a proxy for a VariableInitializerNode.
     * @param node The node to use.
     * @return The resulting proxy node.
     */
    public VariableInitializerNode makeVariableInitializerNode(VariableInitializerNode node);
    
    /**
     * Creates a proxy for a VariableListNode.
     * @param node The node to use.
     * @return The resulting proxy node.
     */
    public VariableListNode makeVariableListNode(VariableListNode node);
    
    /**
     * Creates a proxy for a VariableModifiersNode.
     * @param node The node to use.
     * @return The resulting proxy node.
     */
    public VariableModifiersNode makeVariableModifiersNode(VariableModifiersNode node);
    
    /**
     * Creates a proxy for a VariableNameBindingNode.
     * @param node The node to use.
     * @return The resulting proxy node.
     */
    public VariableNameBindingNode makeVariableNameBindingNode(VariableNameBindingNode node);
    
    /**
     * Creates a proxy for a VariableNode.
     * @param node The node to use.
     * @return The resulting proxy node.
     */
    public VariableNode makeVariableNode(VariableNode node);
    
    /**
     * Creates a proxy for a VoidTypeNode.
     * @param node The node to use.
     * @return The resulting proxy node.
     */
    public VoidTypeNode makeVoidTypeNode(VoidTypeNode node);
    
    /**
     * Creates a proxy for a WhileLoopNode.
     * @param node The node to use.
     * @return The resulting proxy node.
     */
    public WhileLoopNode makeWhileLoopNode(WhileLoopNode node);
    
    /**
     * Creates a proxy for a WildcardTypeNode.
     * @param node The node to use.
     * @return The resulting proxy node.
     */
    public WildcardTypeNode makeWildcardTypeNode(WildcardTypeNode node);
    
}
