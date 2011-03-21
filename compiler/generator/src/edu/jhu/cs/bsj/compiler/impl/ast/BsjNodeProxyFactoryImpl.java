/*
 * WARNING: THIS FILE IS GENERATED.  Do not make any changes to this file
 * directly; it was generated from the BSJ source generator project.  If changes
 * are necessary, changes must be applied either to the source generator
 * application or to one of its data files.  The source generator's fully
 * qualified name is edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator.
 */

package edu.jhu.cs.bsj.compiler.impl.ast;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeOperation;
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
import edu.jhu.cs.bsj.compiler.impl.ast.node.*;
import edu.jhu.cs.bsj.compiler.impl.ast.node.list.AnnotationElementListNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.list.AnnotationListNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.list.AnnotationMemberListNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.list.AnnotationValueListNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.list.AnonymousClassMemberListNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.list.BlockStatementListNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.list.CaseListNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.list.CatchListNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.list.ClassMemberListNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.list.DeclaredTypeListNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.list.EnumConstantDeclarationListNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.list.ExpressionListNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.list.IdentifierListNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.list.ImportListNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.list.InterfaceMemberListNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.list.ReferenceTypeListNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.list.StatementExpressionListNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.list.TypeArgumentListNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.list.TypeDeclarationListNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.list.TypeParameterListNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.list.UnparameterizedTypeListNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.list.VariableDeclaratorListNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.list.VariableInitializerListNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.list.VariableListNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.meta.AnnotationMemberMetaprogramAnchorNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.meta.AnonymousClassMemberMetaprogramAnchorNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.meta.BlockStatementMetaprogramAnchorNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.meta.ClassMemberMetaprogramAnchorNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.meta.CodeLiteralNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.meta.InterfaceMemberMetaprogramAnchorNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.meta.MetaAnnotationArrayValueNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.meta.MetaAnnotationElementListNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.meta.MetaAnnotationElementNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.meta.MetaAnnotationExpressionValueNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.meta.MetaAnnotationListNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.meta.MetaAnnotationMetaAnnotationValueNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.meta.MetaAnnotationMetaprogramAnchorNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.meta.MetaAnnotationValueListNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.meta.MetaprogramDependencyDeclarationListNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.meta.MetaprogramDependencyDeclarationNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.meta.MetaprogramDependencyListNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.meta.MetaprogramDependencyNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.meta.MetaprogramImportListNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.meta.MetaprogramImportNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.meta.MetaprogramNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.meta.MetaprogramPreambleNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.meta.MetaprogramTargetListNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.meta.MetaprogramTargetNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.meta.NormalMetaAnnotationNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.meta.RawCodeLiteralNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.meta.SingleElementMetaAnnotationNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.meta.SpliceNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.meta.TypeDeclarationMetaprogramAnchorNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.utils.BijectiveMap;
import edu.jhu.cs.bsj.compiler.impl.utils.HashBijectiveMap;
import edu.jhu.cs.bsj.compiler.impl.utils.UnmodifiableBijectiveMap;

/**
 * This class acts as a BSJ proxy node factory for the standard BSJ compiler.
 * 
 * @author Zachary Palmer
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class BsjNodeProxyFactoryImpl implements edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactory
{
    /** The node manager to provide to all nodes. */
    private BsjNodeManager manager;

    /** A cache of generated proxy nodes (to ensure that no more than one proxy is created for each node). */
    private BijectiveMap<Long, Node> proxyCache = new HashBijectiveMap<Long, Node>();
    /** A mapping from the IDs of nodes generated by this proxy to the IDs of nodes that they wrapped. */
    private BijectiveMap<Long, Long> proxyIdMap = new HashBijectiveMap<Long, Long>();

    /**
     * Creates a new node factory.
     * 
     * @param manager The node manager to provide to all nodes to allow them to obtain and report information to a
     *            global authority.
     */
    public BsjNodeProxyFactoryImpl(BsjNodeManager manager)
    {
        this.manager = manager;
    }
    
    /**
     * Retrieves a mapping from the IDs of nodes generated by this proxy to the IDs of nodes that they wrapped.
     * 
     * @return A mapping from proxy node UIDs to the UIDs of the nodes they wrap.
     */
    @Override
    public BijectiveMap<Long, Long> getProxyIdMapping()
    {
        return new UnmodifiableBijectiveMap<Long,Long>(this.proxyIdMap);
    }

    // END MANUALLY WRITTEN CODE /////////////////////////////////////////////
    private class ProxyWrappingOperation implements BsjNodeOperation<Void,Node>
    {
        @Override
        public AlternateConstructorInvocationNode executeAlternateConstructorInvocationNode(AlternateConstructorInvocationNode node, Void p)
        {
            if (node == null)
                return null;
            return new AlternateConstructorInvocationNodeImpl(edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this.manager, edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this, node);
        }
        
        @Override
        public AnnotationAnnotationValueNode executeAnnotationAnnotationValueNode(AnnotationAnnotationValueNode node, Void p)
        {
            if (node == null)
                return null;
            return new AnnotationAnnotationValueNodeImpl(edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this.manager, edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this, node);
        }
        
        @Override
        public AnnotationArrayValueNode executeAnnotationArrayValueNode(AnnotationArrayValueNode node, Void p)
        {
            if (node == null)
                return null;
            return new AnnotationArrayValueNodeImpl(edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this.manager, edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this, node);
        }
        
        @Override
        public AnnotationBodyNode executeAnnotationBodyNode(AnnotationBodyNode node, Void p)
        {
            if (node == null)
                return null;
            return new AnnotationBodyNodeImpl(edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this.manager, edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this, node);
        }
        
        @Override
        public AnnotationDeclarationNode executeAnnotationDeclarationNode(AnnotationDeclarationNode node, Void p)
        {
            if (node == null)
                return null;
            return new AnnotationDeclarationNodeImpl(edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this.manager, edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this, node);
        }
        
        @Override
        public AnnotationElementListNode executeAnnotationElementListNode(AnnotationElementListNode node, Void p)
        {
            if (node == null)
                return null;
            return new AnnotationElementListNodeImpl(edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this.manager, edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this, node);
        }
        
        @Override
        public AnnotationElementNode executeAnnotationElementNode(AnnotationElementNode node, Void p)
        {
            if (node == null)
                return null;
            return new AnnotationElementNodeImpl(edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this.manager, edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this, node);
        }
        
        @Override
        public AnnotationExpressionValueNode executeAnnotationExpressionValueNode(AnnotationExpressionValueNode node, Void p)
        {
            if (node == null)
                return null;
            return new AnnotationExpressionValueNodeImpl(edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this.manager, edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this, node);
        }
        
        @Override
        public AnnotationListNode executeAnnotationListNode(AnnotationListNode node, Void p)
        {
            if (node == null)
                return null;
            return new AnnotationListNodeImpl(edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this.manager, edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this, node);
        }
        
        @Override
        public AnnotationMemberListNode executeAnnotationMemberListNode(AnnotationMemberListNode node, Void p)
        {
            if (node == null)
                return null;
            return new AnnotationMemberListNodeImpl(edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this.manager, edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this, node);
        }
        
        @Override
        public AnnotationMemberMetaprogramAnchorNode executeAnnotationMemberMetaprogramAnchorNode(AnnotationMemberMetaprogramAnchorNode node, Void p)
        {
            if (node == null)
                return null;
            return new AnnotationMemberMetaprogramAnchorNodeImpl(edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this.manager, edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this, node);
        }
        
        @Override
        public AnnotationMethodDeclarationNode executeAnnotationMethodDeclarationNode(AnnotationMethodDeclarationNode node, Void p)
        {
            if (node == null)
                return null;
            return new AnnotationMethodDeclarationNodeImpl(edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this.manager, edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this, node);
        }
        
        @Override
        public AnnotationMethodModifiersNode executeAnnotationMethodModifiersNode(AnnotationMethodModifiersNode node, Void p)
        {
            if (node == null)
                return null;
            return new AnnotationMethodModifiersNodeImpl(edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this.manager, edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this, node);
        }
        
        @Override
        public AnnotationModifiersNode executeAnnotationModifiersNode(AnnotationModifiersNode node, Void p)
        {
            if (node == null)
                return null;
            return new AnnotationModifiersNodeImpl(edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this.manager, edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this, node);
        }
        
        @Override
        public AnnotationValueListNode executeAnnotationValueListNode(AnnotationValueListNode node, Void p)
        {
            if (node == null)
                return null;
            return new AnnotationValueListNodeImpl(edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this.manager, edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this, node);
        }
        
        @Override
        public AnonymousClassBodyNode executeAnonymousClassBodyNode(AnonymousClassBodyNode node, Void p)
        {
            if (node == null)
                return null;
            return new AnonymousClassBodyNodeImpl(edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this.manager, edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this, node);
        }
        
        @Override
        public AnonymousClassMemberListNode executeAnonymousClassMemberListNode(AnonymousClassMemberListNode node, Void p)
        {
            if (node == null)
                return null;
            return new AnonymousClassMemberListNodeImpl(edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this.manager, edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this, node);
        }
        
        @Override
        public AnonymousClassMemberMetaprogramAnchorNode executeAnonymousClassMemberMetaprogramAnchorNode(AnonymousClassMemberMetaprogramAnchorNode node, Void p)
        {
            if (node == null)
                return null;
            return new AnonymousClassMemberMetaprogramAnchorNodeImpl(edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this.manager, edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this, node);
        }
        
        @Override
        public ArrayAccessNode executeArrayAccessNode(ArrayAccessNode node, Void p)
        {
            if (node == null)
                return null;
            return new ArrayAccessNodeImpl(edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this.manager, edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this, node);
        }
        
        @Override
        public ArrayInitializerCreationNode executeArrayInitializerCreationNode(ArrayInitializerCreationNode node, Void p)
        {
            if (node == null)
                return null;
            return new ArrayInitializerCreationNodeImpl(edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this.manager, edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this, node);
        }
        
        @Override
        public ArrayInitializerNode executeArrayInitializerNode(ArrayInitializerNode node, Void p)
        {
            if (node == null)
                return null;
            return new ArrayInitializerNodeImpl(edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this.manager, edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this, node);
        }
        
        @Override
        public ArrayInstantiatorCreationNode executeArrayInstantiatorCreationNode(ArrayInstantiatorCreationNode node, Void p)
        {
            if (node == null)
                return null;
            return new ArrayInstantiatorCreationNodeImpl(edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this.manager, edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this, node);
        }
        
        @Override
        public ArrayTypeNode executeArrayTypeNode(ArrayTypeNode node, Void p)
        {
            if (node == null)
                return null;
            return new ArrayTypeNodeImpl(edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this.manager, edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this, node);
        }
        
        @Override
        public AssertStatementNode executeAssertStatementNode(AssertStatementNode node, Void p)
        {
            if (node == null)
                return null;
            return new AssertStatementNodeImpl(edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this.manager, edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this, node);
        }
        
        @Override
        public AssignmentNode executeAssignmentNode(AssignmentNode node, Void p)
        {
            if (node == null)
                return null;
            return new AssignmentNodeImpl(edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this.manager, edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this, node);
        }
        
        @Override
        public BinaryExpressionNode executeBinaryExpressionNode(BinaryExpressionNode node, Void p)
        {
            if (node == null)
                return null;
            return new BinaryExpressionNodeImpl(edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this.manager, edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this, node);
        }
        
        @Override
        public BlockNode executeBlockNode(BlockNode node, Void p)
        {
            if (node == null)
                return null;
            return new BlockNodeImpl(edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this.manager, edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this, node);
        }
        
        @Override
        public BlockStatementListNode executeBlockStatementListNode(BlockStatementListNode node, Void p)
        {
            if (node == null)
                return null;
            return new BlockStatementListNodeImpl(edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this.manager, edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this, node);
        }
        
        @Override
        public BlockStatementMetaprogramAnchorNode executeBlockStatementMetaprogramAnchorNode(BlockStatementMetaprogramAnchorNode node, Void p)
        {
            if (node == null)
                return null;
            return new BlockStatementMetaprogramAnchorNodeImpl(edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this.manager, edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this, node);
        }
        
        @Override
        public BooleanLiteralNode executeBooleanLiteralNode(BooleanLiteralNode node, Void p)
        {
            if (node == null)
                return null;
            return new BooleanLiteralNodeImpl(edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this.manager, edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this, node);
        }
        
        @Override
        public BreakNode executeBreakNode(BreakNode node, Void p)
        {
            if (node == null)
                return null;
            return new BreakNodeImpl(edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this.manager, edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this, node);
        }
        
        @Override
        public CaseListNode executeCaseListNode(CaseListNode node, Void p)
        {
            if (node == null)
                return null;
            return new CaseListNodeImpl(edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this.manager, edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this, node);
        }
        
        @Override
        public CaseNode executeCaseNode(CaseNode node, Void p)
        {
            if (node == null)
                return null;
            return new CaseNodeImpl(edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this.manager, edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this, node);
        }
        
        @Override
        public CatchListNode executeCatchListNode(CatchListNode node, Void p)
        {
            if (node == null)
                return null;
            return new CatchListNodeImpl(edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this.manager, edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this, node);
        }
        
        @Override
        public CatchNode executeCatchNode(CatchNode node, Void p)
        {
            if (node == null)
                return null;
            return new CatchNodeImpl(edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this.manager, edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this, node);
        }
        
        @Override
        public CharLiteralNode executeCharLiteralNode(CharLiteralNode node, Void p)
        {
            if (node == null)
                return null;
            return new CharLiteralNodeImpl(edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this.manager, edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this, node);
        }
        
        @Override
        public ClassBodyNode executeClassBodyNode(ClassBodyNode node, Void p)
        {
            if (node == null)
                return null;
            return new ClassBodyNodeImpl(edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this.manager, edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this, node);
        }
        
        @Override
        public ClassDeclarationNode executeClassDeclarationNode(ClassDeclarationNode node, Void p)
        {
            if (node == null)
                return null;
            return new ClassDeclarationNodeImpl(edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this.manager, edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this, node);
        }
        
        @Override
        public ClassLiteralNode executeClassLiteralNode(ClassLiteralNode node, Void p)
        {
            if (node == null)
                return null;
            return new ClassLiteralNodeImpl(edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this.manager, edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this, node);
        }
        
        @Override
        public ClassMemberListNode executeClassMemberListNode(ClassMemberListNode node, Void p)
        {
            if (node == null)
                return null;
            return new ClassMemberListNodeImpl(edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this.manager, edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this, node);
        }
        
        @Override
        public ClassMemberMetaprogramAnchorNode executeClassMemberMetaprogramAnchorNode(ClassMemberMetaprogramAnchorNode node, Void p)
        {
            if (node == null)
                return null;
            return new ClassMemberMetaprogramAnchorNodeImpl(edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this.manager, edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this, node);
        }
        
        @Override
        public ClassModifiersNode executeClassModifiersNode(ClassModifiersNode node, Void p)
        {
            if (node == null)
                return null;
            return new ClassModifiersNodeImpl(edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this.manager, edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this, node);
        }
        
        @Override
        public CodeLiteralNode executeCodeLiteralNode(CodeLiteralNode node, Void p)
        {
            if (node == null)
                return null;
            return new CodeLiteralNodeImpl(edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this.manager, edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this, node);
        }
        
        @Override
        public CompilationUnitNode executeCompilationUnitNode(CompilationUnitNode node, Void p)
        {
            if (node == null)
                return null;
            return new CompilationUnitNodeImpl(edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this.manager, edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this, node);
        }
        
        @Override
        public ConditionalExpressionNode executeConditionalExpressionNode(ConditionalExpressionNode node, Void p)
        {
            if (node == null)
                return null;
            return new ConditionalExpressionNodeImpl(edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this.manager, edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this, node);
        }
        
        @Override
        public ConstantDeclarationNode executeConstantDeclarationNode(ConstantDeclarationNode node, Void p)
        {
            if (node == null)
                return null;
            return new ConstantDeclarationNodeImpl(edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this.manager, edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this, node);
        }
        
        @Override
        public ConstantModifiersNode executeConstantModifiersNode(ConstantModifiersNode node, Void p)
        {
            if (node == null)
                return null;
            return new ConstantModifiersNodeImpl(edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this.manager, edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this, node);
        }
        
        @Override
        public ConstructorBodyNode executeConstructorBodyNode(ConstructorBodyNode node, Void p)
        {
            if (node == null)
                return null;
            return new ConstructorBodyNodeImpl(edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this.manager, edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this, node);
        }
        
        @Override
        public ConstructorDeclarationNode executeConstructorDeclarationNode(ConstructorDeclarationNode node, Void p)
        {
            if (node == null)
                return null;
            return new ConstructorDeclarationNodeImpl(edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this.manager, edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this, node);
        }
        
        @Override
        public ConstructorModifiersNode executeConstructorModifiersNode(ConstructorModifiersNode node, Void p)
        {
            if (node == null)
                return null;
            return new ConstructorModifiersNodeImpl(edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this.manager, edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this, node);
        }
        
        @Override
        public ContinueNode executeContinueNode(ContinueNode node, Void p)
        {
            if (node == null)
                return null;
            return new ContinueNodeImpl(edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this.manager, edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this, node);
        }
        
        @Override
        public DeclaredTypeListNode executeDeclaredTypeListNode(DeclaredTypeListNode node, Void p)
        {
            if (node == null)
                return null;
            return new DeclaredTypeListNodeImpl(edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this.manager, edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this, node);
        }
        
        @Override
        public DoWhileLoopNode executeDoWhileLoopNode(DoWhileLoopNode node, Void p)
        {
            if (node == null)
                return null;
            return new DoWhileLoopNodeImpl(edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this.manager, edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this, node);
        }
        
        @Override
        public DoubleLiteralNode executeDoubleLiteralNode(DoubleLiteralNode node, Void p)
        {
            if (node == null)
                return null;
            return new DoubleLiteralNodeImpl(edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this.manager, edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this, node);
        }
        
        @Override
        public EnhancedForLoopNode executeEnhancedForLoopNode(EnhancedForLoopNode node, Void p)
        {
            if (node == null)
                return null;
            return new EnhancedForLoopNodeImpl(edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this.manager, edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this, node);
        }
        
        @Override
        public EnumBodyNode executeEnumBodyNode(EnumBodyNode node, Void p)
        {
            if (node == null)
                return null;
            return new EnumBodyNodeImpl(edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this.manager, edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this, node);
        }
        
        @Override
        public EnumConstantDeclarationListNode executeEnumConstantDeclarationListNode(EnumConstantDeclarationListNode node, Void p)
        {
            if (node == null)
                return null;
            return new EnumConstantDeclarationListNodeImpl(edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this.manager, edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this, node);
        }
        
        @Override
        public EnumConstantDeclarationNode executeEnumConstantDeclarationNode(EnumConstantDeclarationNode node, Void p)
        {
            if (node == null)
                return null;
            return new EnumConstantDeclarationNodeImpl(edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this.manager, edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this, node);
        }
        
        @Override
        public EnumConstantModifiersNode executeEnumConstantModifiersNode(EnumConstantModifiersNode node, Void p)
        {
            if (node == null)
                return null;
            return new EnumConstantModifiersNodeImpl(edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this.manager, edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this, node);
        }
        
        @Override
        public EnumDeclarationNode executeEnumDeclarationNode(EnumDeclarationNode node, Void p)
        {
            if (node == null)
                return null;
            return new EnumDeclarationNodeImpl(edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this.manager, edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this, node);
        }
        
        @Override
        public EnumModifiersNode executeEnumModifiersNode(EnumModifiersNode node, Void p)
        {
            if (node == null)
                return null;
            return new EnumModifiersNodeImpl(edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this.manager, edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this, node);
        }
        
        @Override
        public ExpressionListNode executeExpressionListNode(ExpressionListNode node, Void p)
        {
            if (node == null)
                return null;
            return new ExpressionListNodeImpl(edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this.manager, edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this, node);
        }
        
        @Override
        public ExpressionStatementNode executeExpressionStatementNode(ExpressionStatementNode node, Void p)
        {
            if (node == null)
                return null;
            return new ExpressionStatementNodeImpl(edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this.manager, edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this, node);
        }
        
        @Override
        public FieldDeclarationNode executeFieldDeclarationNode(FieldDeclarationNode node, Void p)
        {
            if (node == null)
                return null;
            return new FieldDeclarationNodeImpl(edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this.manager, edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this, node);
        }
        
        @Override
        public FieldModifiersNode executeFieldModifiersNode(FieldModifiersNode node, Void p)
        {
            if (node == null)
                return null;
            return new FieldModifiersNodeImpl(edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this.manager, edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this, node);
        }
        
        @Override
        public FloatLiteralNode executeFloatLiteralNode(FloatLiteralNode node, Void p)
        {
            if (node == null)
                return null;
            return new FloatLiteralNodeImpl(edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this.manager, edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this, node);
        }
        
        @Override
        public ForInitializerDeclarationNode executeForInitializerDeclarationNode(ForInitializerDeclarationNode node, Void p)
        {
            if (node == null)
                return null;
            return new ForInitializerDeclarationNodeImpl(edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this.manager, edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this, node);
        }
        
        @Override
        public ForInitializerExpressionNode executeForInitializerExpressionNode(ForInitializerExpressionNode node, Void p)
        {
            if (node == null)
                return null;
            return new ForInitializerExpressionNodeImpl(edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this.manager, edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this, node);
        }
        
        @Override
        public ForLoopNode executeForLoopNode(ForLoopNode node, Void p)
        {
            if (node == null)
                return null;
            return new ForLoopNodeImpl(edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this.manager, edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this, node);
        }
        
        @Override
        public IdentifierListNode executeIdentifierListNode(IdentifierListNode node, Void p)
        {
            if (node == null)
                return null;
            return new IdentifierListNodeImpl(edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this.manager, edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this, node);
        }
        
        @Override
        public IdentifierNode executeIdentifierNode(IdentifierNode node, Void p)
        {
            if (node == null)
                return null;
            return new IdentifierNodeImpl(edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this.manager, edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this, node);
        }
        
        @Override
        public IfNode executeIfNode(IfNode node, Void p)
        {
            if (node == null)
                return null;
            return new IfNodeImpl(edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this.manager, edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this, node);
        }
        
        @Override
        public ImportListNode executeImportListNode(ImportListNode node, Void p)
        {
            if (node == null)
                return null;
            return new ImportListNodeImpl(edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this.manager, edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this, node);
        }
        
        @Override
        public ImportOnDemandNode executeImportOnDemandNode(ImportOnDemandNode node, Void p)
        {
            if (node == null)
                return null;
            return new ImportOnDemandNodeImpl(edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this.manager, edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this, node);
        }
        
        @Override
        public ImportSingleTypeNode executeImportSingleTypeNode(ImportSingleTypeNode node, Void p)
        {
            if (node == null)
                return null;
            return new ImportSingleTypeNodeImpl(edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this.manager, edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this, node);
        }
        
        @Override
        public InitializerDeclarationNode executeInitializerDeclarationNode(InitializerDeclarationNode node, Void p)
        {
            if (node == null)
                return null;
            return new InitializerDeclarationNodeImpl(edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this.manager, edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this, node);
        }
        
        @Override
        public InstanceOfNode executeInstanceOfNode(InstanceOfNode node, Void p)
        {
            if (node == null)
                return null;
            return new InstanceOfNodeImpl(edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this.manager, edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this, node);
        }
        
        @Override
        public IntLiteralNode executeIntLiteralNode(IntLiteralNode node, Void p)
        {
            if (node == null)
                return null;
            return new IntLiteralNodeImpl(edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this.manager, edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this, node);
        }
        
        @Override
        public InterfaceBodyNode executeInterfaceBodyNode(InterfaceBodyNode node, Void p)
        {
            if (node == null)
                return null;
            return new InterfaceBodyNodeImpl(edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this.manager, edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this, node);
        }
        
        @Override
        public InterfaceDeclarationNode executeInterfaceDeclarationNode(InterfaceDeclarationNode node, Void p)
        {
            if (node == null)
                return null;
            return new InterfaceDeclarationNodeImpl(edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this.manager, edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this, node);
        }
        
        @Override
        public InterfaceMemberListNode executeInterfaceMemberListNode(InterfaceMemberListNode node, Void p)
        {
            if (node == null)
                return null;
            return new InterfaceMemberListNodeImpl(edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this.manager, edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this, node);
        }
        
        @Override
        public InterfaceMemberMetaprogramAnchorNode executeInterfaceMemberMetaprogramAnchorNode(InterfaceMemberMetaprogramAnchorNode node, Void p)
        {
            if (node == null)
                return null;
            return new InterfaceMemberMetaprogramAnchorNodeImpl(edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this.manager, edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this, node);
        }
        
        @Override
        public InterfaceModifiersNode executeInterfaceModifiersNode(InterfaceModifiersNode node, Void p)
        {
            if (node == null)
                return null;
            return new InterfaceModifiersNodeImpl(edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this.manager, edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this, node);
        }
        
        @Override
        public JavadocNode executeJavadocNode(JavadocNode node, Void p)
        {
            if (node == null)
                return null;
            return new JavadocNodeImpl(edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this.manager, edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this, node);
        }
        
        @Override
        public LabeledStatementNode executeLabeledStatementNode(LabeledStatementNode node, Void p)
        {
            if (node == null)
                return null;
            return new LabeledStatementNodeImpl(edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this.manager, edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this, node);
        }
        
        @Override
        public LocalClassDeclarationNode executeLocalClassDeclarationNode(LocalClassDeclarationNode node, Void p)
        {
            if (node == null)
                return null;
            return new LocalClassDeclarationNodeImpl(edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this.manager, edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this, node);
        }
        
        @Override
        public LocalClassModifiersNode executeLocalClassModifiersNode(LocalClassModifiersNode node, Void p)
        {
            if (node == null)
                return null;
            return new LocalClassModifiersNodeImpl(edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this.manager, edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this, node);
        }
        
        @Override
        public LocalVariableDeclarationNode executeLocalVariableDeclarationNode(LocalVariableDeclarationNode node, Void p)
        {
            if (node == null)
                return null;
            return new LocalVariableDeclarationNodeImpl(edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this.manager, edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this, node);
        }
        
        @Override
        public LongLiteralNode executeLongLiteralNode(LongLiteralNode node, Void p)
        {
            if (node == null)
                return null;
            return new LongLiteralNodeImpl(edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this.manager, edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this, node);
        }
        
        @Override
        public MetaAnnotationArrayValueNode executeMetaAnnotationArrayValueNode(MetaAnnotationArrayValueNode node, Void p)
        {
            if (node == null)
                return null;
            return new MetaAnnotationArrayValueNodeImpl(edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this.manager, edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this, node);
        }
        
        @Override
        public MetaAnnotationElementListNode executeMetaAnnotationElementListNode(MetaAnnotationElementListNode node, Void p)
        {
            if (node == null)
                return null;
            return new MetaAnnotationElementListNodeImpl(edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this.manager, edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this, node);
        }
        
        @Override
        public MetaAnnotationElementNode executeMetaAnnotationElementNode(MetaAnnotationElementNode node, Void p)
        {
            if (node == null)
                return null;
            return new MetaAnnotationElementNodeImpl(edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this.manager, edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this, node);
        }
        
        @Override
        public MetaAnnotationExpressionValueNode executeMetaAnnotationExpressionValueNode(MetaAnnotationExpressionValueNode node, Void p)
        {
            if (node == null)
                return null;
            return new MetaAnnotationExpressionValueNodeImpl(edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this.manager, edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this, node);
        }
        
        @Override
        public MetaAnnotationListNode executeMetaAnnotationListNode(MetaAnnotationListNode node, Void p)
        {
            if (node == null)
                return null;
            return new MetaAnnotationListNodeImpl(edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this.manager, edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this, node);
        }
        
        @Override
        public MetaAnnotationMetaAnnotationValueNode executeMetaAnnotationMetaAnnotationValueNode(MetaAnnotationMetaAnnotationValueNode node, Void p)
        {
            if (node == null)
                return null;
            return new MetaAnnotationMetaAnnotationValueNodeImpl(edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this.manager, edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this, node);
        }
        
        @Override
        public MetaAnnotationMetaprogramAnchorNode executeMetaAnnotationMetaprogramAnchorNode(MetaAnnotationMetaprogramAnchorNode node, Void p)
        {
            if (node == null)
                return null;
            return new MetaAnnotationMetaprogramAnchorNodeImpl(edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this.manager, edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this, node);
        }
        
        @Override
        public MetaAnnotationValueListNode executeMetaAnnotationValueListNode(MetaAnnotationValueListNode node, Void p)
        {
            if (node == null)
                return null;
            return new MetaAnnotationValueListNodeImpl(edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this.manager, edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this, node);
        }
        
        @Override
        public MetaprogramDependencyDeclarationListNode executeMetaprogramDependencyDeclarationListNode(MetaprogramDependencyDeclarationListNode node, Void p)
        {
            if (node == null)
                return null;
            return new MetaprogramDependencyDeclarationListNodeImpl(edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this.manager, edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this, node);
        }
        
        @Override
        public MetaprogramDependencyDeclarationNode executeMetaprogramDependencyDeclarationNode(MetaprogramDependencyDeclarationNode node, Void p)
        {
            if (node == null)
                return null;
            return new MetaprogramDependencyDeclarationNodeImpl(edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this.manager, edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this, node);
        }
        
        @Override
        public MetaprogramDependencyListNode executeMetaprogramDependencyListNode(MetaprogramDependencyListNode node, Void p)
        {
            if (node == null)
                return null;
            return new MetaprogramDependencyListNodeImpl(edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this.manager, edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this, node);
        }
        
        @Override
        public MetaprogramDependencyNode executeMetaprogramDependencyNode(MetaprogramDependencyNode node, Void p)
        {
            if (node == null)
                return null;
            return new MetaprogramDependencyNodeImpl(edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this.manager, edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this, node);
        }
        
        @Override
        public MetaprogramImportListNode executeMetaprogramImportListNode(MetaprogramImportListNode node, Void p)
        {
            if (node == null)
                return null;
            return new MetaprogramImportListNodeImpl(edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this.manager, edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this, node);
        }
        
        @Override
        public MetaprogramImportNode executeMetaprogramImportNode(MetaprogramImportNode node, Void p)
        {
            if (node == null)
                return null;
            return new MetaprogramImportNodeImpl(edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this.manager, edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this, node);
        }
        
        @Override
        public MetaprogramNode executeMetaprogramNode(MetaprogramNode node, Void p)
        {
            if (node == null)
                return null;
            return new MetaprogramNodeImpl(edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this.manager, edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this, node);
        }
        
        @Override
        public MetaprogramPreambleNode executeMetaprogramPreambleNode(MetaprogramPreambleNode node, Void p)
        {
            if (node == null)
                return null;
            return new MetaprogramPreambleNodeImpl(edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this.manager, edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this, node);
        }
        
        @Override
        public MetaprogramTargetListNode executeMetaprogramTargetListNode(MetaprogramTargetListNode node, Void p)
        {
            if (node == null)
                return null;
            return new MetaprogramTargetListNodeImpl(edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this.manager, edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this, node);
        }
        
        @Override
        public MetaprogramTargetNode executeMetaprogramTargetNode(MetaprogramTargetNode node, Void p)
        {
            if (node == null)
                return null;
            return new MetaprogramTargetNodeImpl(edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this.manager, edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this, node);
        }
        
        @Override
        public MethodDeclarationNode executeMethodDeclarationNode(MethodDeclarationNode node, Void p)
        {
            if (node == null)
                return null;
            return new MethodDeclarationNodeImpl(edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this.manager, edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this, node);
        }
        
        @Override
        public MethodInvocationNode executeMethodInvocationNode(MethodInvocationNode node, Void p)
        {
            if (node == null)
                return null;
            return new MethodInvocationNodeImpl(edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this.manager, edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this, node);
        }
        
        @Override
        public MethodModifiersNode executeMethodModifiersNode(MethodModifiersNode node, Void p)
        {
            if (node == null)
                return null;
            return new MethodModifiersNodeImpl(edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this.manager, edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this, node);
        }
        
        @Override
        public NoOperationNode executeNoOperationNode(NoOperationNode node, Void p)
        {
            if (node == null)
                return null;
            return new NoOperationNodeImpl(edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this.manager, edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this, node);
        }
        
        @Override
        public NormalAnnotationNode executeNormalAnnotationNode(NormalAnnotationNode node, Void p)
        {
            if (node == null)
                return null;
            return new NormalAnnotationNodeImpl(edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this.manager, edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this, node);
        }
        
        @Override
        public NormalMetaAnnotationNode executeNormalMetaAnnotationNode(NormalMetaAnnotationNode node, Void p)
        {
            if (node == null)
                return null;
            return new NormalMetaAnnotationNodeImpl(edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this.manager, edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this, node);
        }
        
        @Override
        public NullLiteralNode executeNullLiteralNode(NullLiteralNode node, Void p)
        {
            if (node == null)
                return null;
            return new NullLiteralNodeImpl(edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this.manager, edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this, node);
        }
        
        @Override
        public PackageDeclarationNode executePackageDeclarationNode(PackageDeclarationNode node, Void p)
        {
            if (node == null)
                return null;
            return new PackageDeclarationNodeImpl(edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this.manager, edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this, node);
        }
        
        @Override
        public PackageNode executePackageNode(PackageNode node, Void p)
        {
            if (node == null)
                return null;
            return new PackageNodeImpl(edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this.manager, edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this, node);
        }
        
        @Override
        public ParameterizedTypeNode executeParameterizedTypeNode(ParameterizedTypeNode node, Void p)
        {
            if (node == null)
                return null;
            return new ParameterizedTypeNodeImpl(edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this.manager, edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this, node);
        }
        
        @Override
        public ParameterizedTypeSelectNode executeParameterizedTypeSelectNode(ParameterizedTypeSelectNode node, Void p)
        {
            if (node == null)
                return null;
            return new ParameterizedTypeSelectNodeImpl(edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this.manager, edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this, node);
        }
        
        @Override
        public ParenthesizedExpressionNode executeParenthesizedExpressionNode(ParenthesizedExpressionNode node, Void p)
        {
            if (node == null)
                return null;
            return new ParenthesizedExpressionNodeImpl(edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this.manager, edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this, node);
        }
        
        @Override
        public PrimitiveTypeNode executePrimitiveTypeNode(PrimitiveTypeNode node, Void p)
        {
            if (node == null)
                return null;
            return new PrimitiveTypeNodeImpl(edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this.manager, edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this, node);
        }
        
        @Override
        public QualifiedClassInstantiationNode executeQualifiedClassInstantiationNode(QualifiedClassInstantiationNode node, Void p)
        {
            if (node == null)
                return null;
            return new QualifiedClassInstantiationNodeImpl(edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this.manager, edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this, node);
        }
        
        @Override
        public QualifiedNameNode executeQualifiedNameNode(QualifiedNameNode node, Void p)
        {
            if (node == null)
                return null;
            return new QualifiedNameNodeImpl(edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this.manager, edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this, node);
        }
        
        @Override
        public RawCodeLiteralNode executeRawCodeLiteralNode(RawCodeLiteralNode node, Void p)
        {
            if (node == null)
                return null;
            return new RawCodeLiteralNodeImpl(edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this.manager, edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this, node);
        }
        
        @Override
        public ReferenceTypeListNode executeReferenceTypeListNode(ReferenceTypeListNode node, Void p)
        {
            if (node == null)
                return null;
            return new ReferenceTypeListNodeImpl(edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this.manager, edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this, node);
        }
        
        @Override
        public ReturnNode executeReturnNode(ReturnNode node, Void p)
        {
            if (node == null)
                return null;
            return new ReturnNodeImpl(edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this.manager, edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this, node);
        }
        
        @Override
        public SimpleNameNode executeSimpleNameNode(SimpleNameNode node, Void p)
        {
            if (node == null)
                return null;
            return new SimpleNameNodeImpl(edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this.manager, edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this, node);
        }
        
        @Override
        public SingleElementAnnotationNode executeSingleElementAnnotationNode(SingleElementAnnotationNode node, Void p)
        {
            if (node == null)
                return null;
            return new SingleElementAnnotationNodeImpl(edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this.manager, edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this, node);
        }
        
        @Override
        public SingleElementMetaAnnotationNode executeSingleElementMetaAnnotationNode(SingleElementMetaAnnotationNode node, Void p)
        {
            if (node == null)
                return null;
            return new SingleElementMetaAnnotationNodeImpl(edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this.manager, edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this, node);
        }
        
        @Override
        public SingleStaticImportNode executeSingleStaticImportNode(SingleStaticImportNode node, Void p)
        {
            if (node == null)
                return null;
            return new SingleStaticImportNodeImpl(edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this.manager, edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this, node);
        }
        
        @Override
        public SpliceNode executeSpliceNode(SpliceNode node, Void p)
        {
            if (node == null)
                return null;
            return new SpliceNodeImpl(edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this.manager, edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this, node);
        }
        
        @Override
        public StatementExpressionListNode executeStatementExpressionListNode(StatementExpressionListNode node, Void p)
        {
            if (node == null)
                return null;
            return new StatementExpressionListNodeImpl(edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this.manager, edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this, node);
        }
        
        @Override
        public StaticImportOnDemandNode executeStaticImportOnDemandNode(StaticImportOnDemandNode node, Void p)
        {
            if (node == null)
                return null;
            return new StaticImportOnDemandNodeImpl(edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this.manager, edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this, node);
        }
        
        @Override
        public StringLiteralNode executeStringLiteralNode(StringLiteralNode node, Void p)
        {
            if (node == null)
                return null;
            return new StringLiteralNodeImpl(edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this.manager, edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this, node);
        }
        
        @Override
        public SuperFieldAccessNode executeSuperFieldAccessNode(SuperFieldAccessNode node, Void p)
        {
            if (node == null)
                return null;
            return new SuperFieldAccessNodeImpl(edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this.manager, edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this, node);
        }
        
        @Override
        public SuperMethodInvocationNode executeSuperMethodInvocationNode(SuperMethodInvocationNode node, Void p)
        {
            if (node == null)
                return null;
            return new SuperMethodInvocationNodeImpl(edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this.manager, edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this, node);
        }
        
        @Override
        public SuperclassConstructorInvocationNode executeSuperclassConstructorInvocationNode(SuperclassConstructorInvocationNode node, Void p)
        {
            if (node == null)
                return null;
            return new SuperclassConstructorInvocationNodeImpl(edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this.manager, edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this, node);
        }
        
        @Override
        public SwitchNode executeSwitchNode(SwitchNode node, Void p)
        {
            if (node == null)
                return null;
            return new SwitchNodeImpl(edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this.manager, edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this, node);
        }
        
        @Override
        public SynchronizedNode executeSynchronizedNode(SynchronizedNode node, Void p)
        {
            if (node == null)
                return null;
            return new SynchronizedNodeImpl(edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this.manager, edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this, node);
        }
        
        @Override
        public ThisNode executeThisNode(ThisNode node, Void p)
        {
            if (node == null)
                return null;
            return new ThisNodeImpl(edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this.manager, edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this, node);
        }
        
        @Override
        public ThrowNode executeThrowNode(ThrowNode node, Void p)
        {
            if (node == null)
                return null;
            return new ThrowNodeImpl(edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this.manager, edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this, node);
        }
        
        @Override
        public TryNode executeTryNode(TryNode node, Void p)
        {
            if (node == null)
                return null;
            return new TryNodeImpl(edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this.manager, edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this, node);
        }
        
        @Override
        public TypeArgumentListNode executeTypeArgumentListNode(TypeArgumentListNode node, Void p)
        {
            if (node == null)
                return null;
            return new TypeArgumentListNodeImpl(edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this.manager, edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this, node);
        }
        
        @Override
        public TypeCastNode executeTypeCastNode(TypeCastNode node, Void p)
        {
            if (node == null)
                return null;
            return new TypeCastNodeImpl(edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this.manager, edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this, node);
        }
        
        @Override
        public TypeDeclarationListNode executeTypeDeclarationListNode(TypeDeclarationListNode node, Void p)
        {
            if (node == null)
                return null;
            return new TypeDeclarationListNodeImpl(edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this.manager, edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this, node);
        }
        
        @Override
        public TypeDeclarationMetaprogramAnchorNode executeTypeDeclarationMetaprogramAnchorNode(TypeDeclarationMetaprogramAnchorNode node, Void p)
        {
            if (node == null)
                return null;
            return new TypeDeclarationMetaprogramAnchorNodeImpl(edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this.manager, edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this, node);
        }
        
        @Override
        public TypeParameterListNode executeTypeParameterListNode(TypeParameterListNode node, Void p)
        {
            if (node == null)
                return null;
            return new TypeParameterListNodeImpl(edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this.manager, edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this, node);
        }
        
        @Override
        public TypeParameterNode executeTypeParameterNode(TypeParameterNode node, Void p)
        {
            if (node == null)
                return null;
            return new TypeParameterNodeImpl(edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this.manager, edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this, node);
        }
        
        @Override
        public UnaryExpressionNode executeUnaryExpressionNode(UnaryExpressionNode node, Void p)
        {
            if (node == null)
                return null;
            return new UnaryExpressionNodeImpl(edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this.manager, edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this, node);
        }
        
        @Override
        public UnaryStatementExpressionNode executeUnaryStatementExpressionNode(UnaryStatementExpressionNode node, Void p)
        {
            if (node == null)
                return null;
            return new UnaryStatementExpressionNodeImpl(edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this.manager, edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this, node);
        }
        
        @Override
        public UnparameterizedTypeListNode executeUnparameterizedTypeListNode(UnparameterizedTypeListNode node, Void p)
        {
            if (node == null)
                return null;
            return new UnparameterizedTypeListNodeImpl(edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this.manager, edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this, node);
        }
        
        @Override
        public UnparameterizedTypeNode executeUnparameterizedTypeNode(UnparameterizedTypeNode node, Void p)
        {
            if (node == null)
                return null;
            return new UnparameterizedTypeNodeImpl(edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this.manager, edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this, node);
        }
        
        @Override
        public UnqualifiedClassInstantiationNode executeUnqualifiedClassInstantiationNode(UnqualifiedClassInstantiationNode node, Void p)
        {
            if (node == null)
                return null;
            return new UnqualifiedClassInstantiationNodeImpl(edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this.manager, edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this, node);
        }
        
        @Override
        public VariableAccessNode executeVariableAccessNode(VariableAccessNode node, Void p)
        {
            if (node == null)
                return null;
            return new VariableAccessNodeImpl(edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this.manager, edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this, node);
        }
        
        @Override
        public VariableDeclaratorListNode executeVariableDeclaratorListNode(VariableDeclaratorListNode node, Void p)
        {
            if (node == null)
                return null;
            return new VariableDeclaratorListNodeImpl(edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this.manager, edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this, node);
        }
        
        @Override
        public VariableDeclaratorNode executeVariableDeclaratorNode(VariableDeclaratorNode node, Void p)
        {
            if (node == null)
                return null;
            return new VariableDeclaratorNodeImpl(edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this.manager, edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this, node);
        }
        
        @Override
        public VariableInitializerListNode executeVariableInitializerListNode(VariableInitializerListNode node, Void p)
        {
            if (node == null)
                return null;
            return new VariableInitializerListNodeImpl(edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this.manager, edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this, node);
        }
        
        @Override
        public VariableListNode executeVariableListNode(VariableListNode node, Void p)
        {
            if (node == null)
                return null;
            return new VariableListNodeImpl(edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this.manager, edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this, node);
        }
        
        @Override
        public VariableModifiersNode executeVariableModifiersNode(VariableModifiersNode node, Void p)
        {
            if (node == null)
                return null;
            return new VariableModifiersNodeImpl(edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this.manager, edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this, node);
        }
        
        @Override
        public VariableNode executeVariableNode(VariableNode node, Void p)
        {
            if (node == null)
                return null;
            return new VariableNodeImpl(edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this.manager, edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this, node);
        }
        
        @Override
        public VoidTypeNode executeVoidTypeNode(VoidTypeNode node, Void p)
        {
            if (node == null)
                return null;
            return new VoidTypeNodeImpl(edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this.manager, edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this, node);
        }
        
        @Override
        public WhileLoopNode executeWhileLoopNode(WhileLoopNode node, Void p)
        {
            if (node == null)
                return null;
            return new WhileLoopNodeImpl(edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this.manager, edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this, node);
        }
        
        @Override
        public WildcardTypeNode executeWildcardTypeNode(WildcardTypeNode node, Void p)
        {
            if (node == null)
                return null;
            return new WildcardTypeNodeImpl(edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this.manager, edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl.this, node);
        }
        
    }
    
    private final ProxyWrappingOperation WRAPPER = new ProxyWrappingOperation();
    /**
     * {@inheritDoc}
     */
    public <T extends Node> NodeUnion<T> makeNormalNodeUnion(T node)
    {
        return new NormalNodeUnion<T>(node);
    }
    
    /**
     * {@inheritDoc}
     */
    public <T extends Node> NodeUnion<T> makeSpliceNodeUnion(SpliceNode node)
    {
        return new SpliceNodeUnion<T>(node);
    }
    
    // this suppression is safe as long as the type parameter value is never implementation-specific
    @SuppressWarnings("unchecked")
    public <T extends ModifiersNode> AbstractInvokableDeclarationNode<T> makeAbstractInvokableDeclarationNode(AbstractInvokableDeclarationNode<T> node)
    {
        if (node == null)
            return null;
        final AbstractInvokableDeclarationNode<T> ret;
        if (this.proxyCache.containsKey(node.getUid()))
        {
            ret = (AbstractInvokableDeclarationNode<T>)this.proxyCache.get(node.getUid());
        } else
        {
            ret = (AbstractInvokableDeclarationNode<T>)(node.executeOperation(WRAPPER, null));
            this.proxyCache.put(node.getUid(), ret);
            this.proxyIdMap.put(ret.getUid(), node.getUid());
        }
        return ret;
    }
    
    // this suppression is safe as long as the type parameter value is never implementation-specific
    @SuppressWarnings("unchecked")
    public <T extends ModifiersNode> AbstractMemberVariableDeclarationNode<T> makeAbstractMemberVariableDeclarationNode(AbstractMemberVariableDeclarationNode<T> node)
    {
        if (node == null)
            return null;
        final AbstractMemberVariableDeclarationNode<T> ret;
        if (this.proxyCache.containsKey(node.getUid()))
        {
            ret = (AbstractMemberVariableDeclarationNode<T>)this.proxyCache.get(node.getUid());
        } else
        {
            ret = (AbstractMemberVariableDeclarationNode<T>)(node.executeOperation(WRAPPER, null));
            this.proxyCache.put(node.getUid(), ret);
            this.proxyIdMap.put(ret.getUid(), node.getUid());
        }
        return ret;
    }
    
    // this suppression is safe as long as the type parameter value is never implementation-specific
    @SuppressWarnings("unchecked")
    public <T extends ModifiersNode> AbstractlyUnmodifiedClassDeclarationNode<T> makeAbstractlyUnmodifiedClassDeclarationNode(AbstractlyUnmodifiedClassDeclarationNode<T> node)
    {
        if (node == null)
            return null;
        final AbstractlyUnmodifiedClassDeclarationNode<T> ret;
        if (this.proxyCache.containsKey(node.getUid()))
        {
            ret = (AbstractlyUnmodifiedClassDeclarationNode<T>)this.proxyCache.get(node.getUid());
        } else
        {
            ret = (AbstractlyUnmodifiedClassDeclarationNode<T>)(node.executeOperation(WRAPPER, null));
            this.proxyCache.put(node.getUid(), ret);
            this.proxyIdMap.put(ret.getUid(), node.getUid());
        }
        return ret;
    }
    
    public AccessibleTypeModifiersNode makeAccessibleTypeModifiersNode(AccessibleTypeModifiersNode node)
    {
        if (node == null)
            return null;
        final AccessibleTypeModifiersNode ret;
        if (this.proxyCache.containsKey(node.getUid()))
        {
            ret = (AccessibleTypeModifiersNode)this.proxyCache.get(node.getUid());
        } else
        {
            ret = (AccessibleTypeModifiersNode)(node.executeOperation(WRAPPER, null));
            this.proxyCache.put(node.getUid(), ret);
            this.proxyIdMap.put(ret.getUid(), node.getUid());
        }
        return ret;
    }
    
    public AlternateConstructorInvocationNode makeAlternateConstructorInvocationNode(AlternateConstructorInvocationNode node)
    {
        if (node == null)
            return null;
        final AlternateConstructorInvocationNode ret;
        if (this.proxyCache.containsKey(node.getUid()))
        {
            ret = (AlternateConstructorInvocationNode)this.proxyCache.get(node.getUid());
        } else
        {
            ret = (AlternateConstructorInvocationNode)(node.executeOperation(WRAPPER, null));
            this.proxyCache.put(node.getUid(), ret);
            this.proxyIdMap.put(ret.getUid(), node.getUid());
        }
        return ret;
    }
    
    public AnnotationAnnotationValueNode makeAnnotationAnnotationValueNode(AnnotationAnnotationValueNode node)
    {
        if (node == null)
            return null;
        final AnnotationAnnotationValueNode ret;
        if (this.proxyCache.containsKey(node.getUid()))
        {
            ret = (AnnotationAnnotationValueNode)this.proxyCache.get(node.getUid());
        } else
        {
            ret = (AnnotationAnnotationValueNode)(node.executeOperation(WRAPPER, null));
            this.proxyCache.put(node.getUid(), ret);
            this.proxyIdMap.put(ret.getUid(), node.getUid());
        }
        return ret;
    }
    
    public AnnotationArrayValueNode makeAnnotationArrayValueNode(AnnotationArrayValueNode node)
    {
        if (node == null)
            return null;
        final AnnotationArrayValueNode ret;
        if (this.proxyCache.containsKey(node.getUid()))
        {
            ret = (AnnotationArrayValueNode)this.proxyCache.get(node.getUid());
        } else
        {
            ret = (AnnotationArrayValueNode)(node.executeOperation(WRAPPER, null));
            this.proxyCache.put(node.getUid(), ret);
            this.proxyIdMap.put(ret.getUid(), node.getUid());
        }
        return ret;
    }
    
    public AnnotationBodyNode makeAnnotationBodyNode(AnnotationBodyNode node)
    {
        if (node == null)
            return null;
        final AnnotationBodyNode ret;
        if (this.proxyCache.containsKey(node.getUid()))
        {
            ret = (AnnotationBodyNode)this.proxyCache.get(node.getUid());
        } else
        {
            ret = (AnnotationBodyNode)(node.executeOperation(WRAPPER, null));
            this.proxyCache.put(node.getUid(), ret);
            this.proxyIdMap.put(ret.getUid(), node.getUid());
        }
        return ret;
    }
    
    public AnnotationDeclarationNode makeAnnotationDeclarationNode(AnnotationDeclarationNode node)
    {
        if (node == null)
            return null;
        final AnnotationDeclarationNode ret;
        if (this.proxyCache.containsKey(node.getUid()))
        {
            ret = (AnnotationDeclarationNode)this.proxyCache.get(node.getUid());
        } else
        {
            ret = (AnnotationDeclarationNode)(node.executeOperation(WRAPPER, null));
            this.proxyCache.put(node.getUid(), ret);
            this.proxyIdMap.put(ret.getUid(), node.getUid());
        }
        return ret;
    }
    
    public AnnotationElementListNode makeAnnotationElementListNode(AnnotationElementListNode node)
    {
        if (node == null)
            return null;
        final AnnotationElementListNode ret;
        if (this.proxyCache.containsKey(node.getUid()))
        {
            ret = (AnnotationElementListNode)this.proxyCache.get(node.getUid());
        } else
        {
            ret = (AnnotationElementListNode)(node.executeOperation(WRAPPER, null));
            this.proxyCache.put(node.getUid(), ret);
            this.proxyIdMap.put(ret.getUid(), node.getUid());
        }
        return ret;
    }
    
    public AnnotationElementNode makeAnnotationElementNode(AnnotationElementNode node)
    {
        if (node == null)
            return null;
        final AnnotationElementNode ret;
        if (this.proxyCache.containsKey(node.getUid()))
        {
            ret = (AnnotationElementNode)this.proxyCache.get(node.getUid());
        } else
        {
            ret = (AnnotationElementNode)(node.executeOperation(WRAPPER, null));
            this.proxyCache.put(node.getUid(), ret);
            this.proxyIdMap.put(ret.getUid(), node.getUid());
        }
        return ret;
    }
    
    public AnnotationExpressionValueNode makeAnnotationExpressionValueNode(AnnotationExpressionValueNode node)
    {
        if (node == null)
            return null;
        final AnnotationExpressionValueNode ret;
        if (this.proxyCache.containsKey(node.getUid()))
        {
            ret = (AnnotationExpressionValueNode)this.proxyCache.get(node.getUid());
        } else
        {
            ret = (AnnotationExpressionValueNode)(node.executeOperation(WRAPPER, null));
            this.proxyCache.put(node.getUid(), ret);
            this.proxyIdMap.put(ret.getUid(), node.getUid());
        }
        return ret;
    }
    
    public AnnotationListNode makeAnnotationListNode(AnnotationListNode node)
    {
        if (node == null)
            return null;
        final AnnotationListNode ret;
        if (this.proxyCache.containsKey(node.getUid()))
        {
            ret = (AnnotationListNode)this.proxyCache.get(node.getUid());
        } else
        {
            ret = (AnnotationListNode)(node.executeOperation(WRAPPER, null));
            this.proxyCache.put(node.getUid(), ret);
            this.proxyIdMap.put(ret.getUid(), node.getUid());
        }
        return ret;
    }
    
    public AnnotationMemberListNode makeAnnotationMemberListNode(AnnotationMemberListNode node)
    {
        if (node == null)
            return null;
        final AnnotationMemberListNode ret;
        if (this.proxyCache.containsKey(node.getUid()))
        {
            ret = (AnnotationMemberListNode)this.proxyCache.get(node.getUid());
        } else
        {
            ret = (AnnotationMemberListNode)(node.executeOperation(WRAPPER, null));
            this.proxyCache.put(node.getUid(), ret);
            this.proxyIdMap.put(ret.getUid(), node.getUid());
        }
        return ret;
    }
    
    public AnnotationMemberMetaprogramAnchorNode makeAnnotationMemberMetaprogramAnchorNode(AnnotationMemberMetaprogramAnchorNode node)
    {
        if (node == null)
            return null;
        final AnnotationMemberMetaprogramAnchorNode ret;
        if (this.proxyCache.containsKey(node.getUid()))
        {
            ret = (AnnotationMemberMetaprogramAnchorNode)this.proxyCache.get(node.getUid());
        } else
        {
            ret = (AnnotationMemberMetaprogramAnchorNode)(node.executeOperation(WRAPPER, null));
            this.proxyCache.put(node.getUid(), ret);
            this.proxyIdMap.put(ret.getUid(), node.getUid());
        }
        return ret;
    }
    
    public AnnotationMemberNode makeAnnotationMemberNode(AnnotationMemberNode node)
    {
        if (node == null)
            return null;
        final AnnotationMemberNode ret;
        if (this.proxyCache.containsKey(node.getUid()))
        {
            ret = (AnnotationMemberNode)this.proxyCache.get(node.getUid());
        } else
        {
            ret = (AnnotationMemberNode)(node.executeOperation(WRAPPER, null));
            this.proxyCache.put(node.getUid(), ret);
            this.proxyIdMap.put(ret.getUid(), node.getUid());
        }
        return ret;
    }
    
    public AnnotationMethodDeclarationNode makeAnnotationMethodDeclarationNode(AnnotationMethodDeclarationNode node)
    {
        if (node == null)
            return null;
        final AnnotationMethodDeclarationNode ret;
        if (this.proxyCache.containsKey(node.getUid()))
        {
            ret = (AnnotationMethodDeclarationNode)this.proxyCache.get(node.getUid());
        } else
        {
            ret = (AnnotationMethodDeclarationNode)(node.executeOperation(WRAPPER, null));
            this.proxyCache.put(node.getUid(), ret);
            this.proxyIdMap.put(ret.getUid(), node.getUid());
        }
        return ret;
    }
    
    public AnnotationMethodModifiersNode makeAnnotationMethodModifiersNode(AnnotationMethodModifiersNode node)
    {
        if (node == null)
            return null;
        final AnnotationMethodModifiersNode ret;
        if (this.proxyCache.containsKey(node.getUid()))
        {
            ret = (AnnotationMethodModifiersNode)this.proxyCache.get(node.getUid());
        } else
        {
            ret = (AnnotationMethodModifiersNode)(node.executeOperation(WRAPPER, null));
            this.proxyCache.put(node.getUid(), ret);
            this.proxyIdMap.put(ret.getUid(), node.getUid());
        }
        return ret;
    }
    
    public AnnotationModifiersNode makeAnnotationModifiersNode(AnnotationModifiersNode node)
    {
        if (node == null)
            return null;
        final AnnotationModifiersNode ret;
        if (this.proxyCache.containsKey(node.getUid()))
        {
            ret = (AnnotationModifiersNode)this.proxyCache.get(node.getUid());
        } else
        {
            ret = (AnnotationModifiersNode)(node.executeOperation(WRAPPER, null));
            this.proxyCache.put(node.getUid(), ret);
            this.proxyIdMap.put(ret.getUid(), node.getUid());
        }
        return ret;
    }
    
    public AnnotationNode makeAnnotationNode(AnnotationNode node)
    {
        if (node == null)
            return null;
        final AnnotationNode ret;
        if (this.proxyCache.containsKey(node.getUid()))
        {
            ret = (AnnotationNode)this.proxyCache.get(node.getUid());
        } else
        {
            ret = (AnnotationNode)(node.executeOperation(WRAPPER, null));
            this.proxyCache.put(node.getUid(), ret);
            this.proxyIdMap.put(ret.getUid(), node.getUid());
        }
        return ret;
    }
    
    public AnnotationValueListNode makeAnnotationValueListNode(AnnotationValueListNode node)
    {
        if (node == null)
            return null;
        final AnnotationValueListNode ret;
        if (this.proxyCache.containsKey(node.getUid()))
        {
            ret = (AnnotationValueListNode)this.proxyCache.get(node.getUid());
        } else
        {
            ret = (AnnotationValueListNode)(node.executeOperation(WRAPPER, null));
            this.proxyCache.put(node.getUid(), ret);
            this.proxyIdMap.put(ret.getUid(), node.getUid());
        }
        return ret;
    }
    
    public AnnotationValueNode makeAnnotationValueNode(AnnotationValueNode node)
    {
        if (node == null)
            return null;
        final AnnotationValueNode ret;
        if (this.proxyCache.containsKey(node.getUid()))
        {
            ret = (AnnotationValueNode)this.proxyCache.get(node.getUid());
        } else
        {
            ret = (AnnotationValueNode)(node.executeOperation(WRAPPER, null));
            this.proxyCache.put(node.getUid(), ret);
            this.proxyIdMap.put(ret.getUid(), node.getUid());
        }
        return ret;
    }
    
    public AnonymousClassBodyNode makeAnonymousClassBodyNode(AnonymousClassBodyNode node)
    {
        if (node == null)
            return null;
        final AnonymousClassBodyNode ret;
        if (this.proxyCache.containsKey(node.getUid()))
        {
            ret = (AnonymousClassBodyNode)this.proxyCache.get(node.getUid());
        } else
        {
            ret = (AnonymousClassBodyNode)(node.executeOperation(WRAPPER, null));
            this.proxyCache.put(node.getUid(), ret);
            this.proxyIdMap.put(ret.getUid(), node.getUid());
        }
        return ret;
    }
    
    public AnonymousClassMemberListNode makeAnonymousClassMemberListNode(AnonymousClassMemberListNode node)
    {
        if (node == null)
            return null;
        final AnonymousClassMemberListNode ret;
        if (this.proxyCache.containsKey(node.getUid()))
        {
            ret = (AnonymousClassMemberListNode)this.proxyCache.get(node.getUid());
        } else
        {
            ret = (AnonymousClassMemberListNode)(node.executeOperation(WRAPPER, null));
            this.proxyCache.put(node.getUid(), ret);
            this.proxyIdMap.put(ret.getUid(), node.getUid());
        }
        return ret;
    }
    
    public AnonymousClassMemberMetaprogramAnchorNode makeAnonymousClassMemberMetaprogramAnchorNode(AnonymousClassMemberMetaprogramAnchorNode node)
    {
        if (node == null)
            return null;
        final AnonymousClassMemberMetaprogramAnchorNode ret;
        if (this.proxyCache.containsKey(node.getUid()))
        {
            ret = (AnonymousClassMemberMetaprogramAnchorNode)this.proxyCache.get(node.getUid());
        } else
        {
            ret = (AnonymousClassMemberMetaprogramAnchorNode)(node.executeOperation(WRAPPER, null));
            this.proxyCache.put(node.getUid(), ret);
            this.proxyIdMap.put(ret.getUid(), node.getUid());
        }
        return ret;
    }
    
    public AnonymousClassMemberNode makeAnonymousClassMemberNode(AnonymousClassMemberNode node)
    {
        if (node == null)
            return null;
        final AnonymousClassMemberNode ret;
        if (this.proxyCache.containsKey(node.getUid()))
        {
            ret = (AnonymousClassMemberNode)this.proxyCache.get(node.getUid());
        } else
        {
            ret = (AnonymousClassMemberNode)(node.executeOperation(WRAPPER, null));
            this.proxyCache.put(node.getUid(), ret);
            this.proxyIdMap.put(ret.getUid(), node.getUid());
        }
        return ret;
    }
    
    public ArrayAccessNode makeArrayAccessNode(ArrayAccessNode node)
    {
        if (node == null)
            return null;
        final ArrayAccessNode ret;
        if (this.proxyCache.containsKey(node.getUid()))
        {
            ret = (ArrayAccessNode)this.proxyCache.get(node.getUid());
        } else
        {
            ret = (ArrayAccessNode)(node.executeOperation(WRAPPER, null));
            this.proxyCache.put(node.getUid(), ret);
            this.proxyIdMap.put(ret.getUid(), node.getUid());
        }
        return ret;
    }
    
    public ArrayCreationNode makeArrayCreationNode(ArrayCreationNode node)
    {
        if (node == null)
            return null;
        final ArrayCreationNode ret;
        if (this.proxyCache.containsKey(node.getUid()))
        {
            ret = (ArrayCreationNode)this.proxyCache.get(node.getUid());
        } else
        {
            ret = (ArrayCreationNode)(node.executeOperation(WRAPPER, null));
            this.proxyCache.put(node.getUid(), ret);
            this.proxyIdMap.put(ret.getUid(), node.getUid());
        }
        return ret;
    }
    
    public ArrayInitializerCreationNode makeArrayInitializerCreationNode(ArrayInitializerCreationNode node)
    {
        if (node == null)
            return null;
        final ArrayInitializerCreationNode ret;
        if (this.proxyCache.containsKey(node.getUid()))
        {
            ret = (ArrayInitializerCreationNode)this.proxyCache.get(node.getUid());
        } else
        {
            ret = (ArrayInitializerCreationNode)(node.executeOperation(WRAPPER, null));
            this.proxyCache.put(node.getUid(), ret);
            this.proxyIdMap.put(ret.getUid(), node.getUid());
        }
        return ret;
    }
    
    public ArrayInitializerNode makeArrayInitializerNode(ArrayInitializerNode node)
    {
        if (node == null)
            return null;
        final ArrayInitializerNode ret;
        if (this.proxyCache.containsKey(node.getUid()))
        {
            ret = (ArrayInitializerNode)this.proxyCache.get(node.getUid());
        } else
        {
            ret = (ArrayInitializerNode)(node.executeOperation(WRAPPER, null));
            this.proxyCache.put(node.getUid(), ret);
            this.proxyIdMap.put(ret.getUid(), node.getUid());
        }
        return ret;
    }
    
    public ArrayInstantiatorCreationNode makeArrayInstantiatorCreationNode(ArrayInstantiatorCreationNode node)
    {
        if (node == null)
            return null;
        final ArrayInstantiatorCreationNode ret;
        if (this.proxyCache.containsKey(node.getUid()))
        {
            ret = (ArrayInstantiatorCreationNode)this.proxyCache.get(node.getUid());
        } else
        {
            ret = (ArrayInstantiatorCreationNode)(node.executeOperation(WRAPPER, null));
            this.proxyCache.put(node.getUid(), ret);
            this.proxyIdMap.put(ret.getUid(), node.getUid());
        }
        return ret;
    }
    
    public ArrayTypeNode makeArrayTypeNode(ArrayTypeNode node)
    {
        if (node == null)
            return null;
        final ArrayTypeNode ret;
        if (this.proxyCache.containsKey(node.getUid()))
        {
            ret = (ArrayTypeNode)this.proxyCache.get(node.getUid());
        } else
        {
            ret = (ArrayTypeNode)(node.executeOperation(WRAPPER, null));
            this.proxyCache.put(node.getUid(), ret);
            this.proxyIdMap.put(ret.getUid(), node.getUid());
        }
        return ret;
    }
    
    public AssertStatementNode makeAssertStatementNode(AssertStatementNode node)
    {
        if (node == null)
            return null;
        final AssertStatementNode ret;
        if (this.proxyCache.containsKey(node.getUid()))
        {
            ret = (AssertStatementNode)this.proxyCache.get(node.getUid());
        } else
        {
            ret = (AssertStatementNode)(node.executeOperation(WRAPPER, null));
            this.proxyCache.put(node.getUid(), ret);
            this.proxyIdMap.put(ret.getUid(), node.getUid());
        }
        return ret;
    }
    
    public AssignmentNode makeAssignmentNode(AssignmentNode node)
    {
        if (node == null)
            return null;
        final AssignmentNode ret;
        if (this.proxyCache.containsKey(node.getUid()))
        {
            ret = (AssignmentNode)this.proxyCache.get(node.getUid());
        } else
        {
            ret = (AssignmentNode)(node.executeOperation(WRAPPER, null));
            this.proxyCache.put(node.getUid(), ret);
            this.proxyIdMap.put(ret.getUid(), node.getUid());
        }
        return ret;
    }
    
    public BaseTypeNode makeBaseTypeNode(BaseTypeNode node)
    {
        if (node == null)
            return null;
        final BaseTypeNode ret;
        if (this.proxyCache.containsKey(node.getUid()))
        {
            ret = (BaseTypeNode)this.proxyCache.get(node.getUid());
        } else
        {
            ret = (BaseTypeNode)(node.executeOperation(WRAPPER, null));
            this.proxyCache.put(node.getUid(), ret);
            this.proxyIdMap.put(ret.getUid(), node.getUid());
        }
        return ret;
    }
    
    public BinaryExpressionNode makeBinaryExpressionNode(BinaryExpressionNode node)
    {
        if (node == null)
            return null;
        final BinaryExpressionNode ret;
        if (this.proxyCache.containsKey(node.getUid()))
        {
            ret = (BinaryExpressionNode)this.proxyCache.get(node.getUid());
        } else
        {
            ret = (BinaryExpressionNode)(node.executeOperation(WRAPPER, null));
            this.proxyCache.put(node.getUid(), ret);
            this.proxyIdMap.put(ret.getUid(), node.getUid());
        }
        return ret;
    }
    
    public BlockNode makeBlockNode(BlockNode node)
    {
        if (node == null)
            return null;
        final BlockNode ret;
        if (this.proxyCache.containsKey(node.getUid()))
        {
            ret = (BlockNode)this.proxyCache.get(node.getUid());
        } else
        {
            ret = (BlockNode)(node.executeOperation(WRAPPER, null));
            this.proxyCache.put(node.getUid(), ret);
            this.proxyIdMap.put(ret.getUid(), node.getUid());
        }
        return ret;
    }
    
    public BlockStatementListNode makeBlockStatementListNode(BlockStatementListNode node)
    {
        if (node == null)
            return null;
        final BlockStatementListNode ret;
        if (this.proxyCache.containsKey(node.getUid()))
        {
            ret = (BlockStatementListNode)this.proxyCache.get(node.getUid());
        } else
        {
            ret = (BlockStatementListNode)(node.executeOperation(WRAPPER, null));
            this.proxyCache.put(node.getUid(), ret);
            this.proxyIdMap.put(ret.getUid(), node.getUid());
        }
        return ret;
    }
    
    public BlockStatementMetaprogramAnchorNode makeBlockStatementMetaprogramAnchorNode(BlockStatementMetaprogramAnchorNode node)
    {
        if (node == null)
            return null;
        final BlockStatementMetaprogramAnchorNode ret;
        if (this.proxyCache.containsKey(node.getUid()))
        {
            ret = (BlockStatementMetaprogramAnchorNode)this.proxyCache.get(node.getUid());
        } else
        {
            ret = (BlockStatementMetaprogramAnchorNode)(node.executeOperation(WRAPPER, null));
            this.proxyCache.put(node.getUid(), ret);
            this.proxyIdMap.put(ret.getUid(), node.getUid());
        }
        return ret;
    }
    
    public BlockStatementNode makeBlockStatementNode(BlockStatementNode node)
    {
        if (node == null)
            return null;
        final BlockStatementNode ret;
        if (this.proxyCache.containsKey(node.getUid()))
        {
            ret = (BlockStatementNode)this.proxyCache.get(node.getUid());
        } else
        {
            ret = (BlockStatementNode)(node.executeOperation(WRAPPER, null));
            this.proxyCache.put(node.getUid(), ret);
            this.proxyIdMap.put(ret.getUid(), node.getUid());
        }
        return ret;
    }
    
    public BooleanLiteralNode makeBooleanLiteralNode(BooleanLiteralNode node)
    {
        if (node == null)
            return null;
        final BooleanLiteralNode ret;
        if (this.proxyCache.containsKey(node.getUid()))
        {
            ret = (BooleanLiteralNode)this.proxyCache.get(node.getUid());
        } else
        {
            ret = (BooleanLiteralNode)(node.executeOperation(WRAPPER, null));
            this.proxyCache.put(node.getUid(), ret);
            this.proxyIdMap.put(ret.getUid(), node.getUid());
        }
        return ret;
    }
    
    public BreakNode makeBreakNode(BreakNode node)
    {
        if (node == null)
            return null;
        final BreakNode ret;
        if (this.proxyCache.containsKey(node.getUid()))
        {
            ret = (BreakNode)this.proxyCache.get(node.getUid());
        } else
        {
            ret = (BreakNode)(node.executeOperation(WRAPPER, null));
            this.proxyCache.put(node.getUid(), ret);
            this.proxyIdMap.put(ret.getUid(), node.getUid());
        }
        return ret;
    }
    
    public CaseListNode makeCaseListNode(CaseListNode node)
    {
        if (node == null)
            return null;
        final CaseListNode ret;
        if (this.proxyCache.containsKey(node.getUid()))
        {
            ret = (CaseListNode)this.proxyCache.get(node.getUid());
        } else
        {
            ret = (CaseListNode)(node.executeOperation(WRAPPER, null));
            this.proxyCache.put(node.getUid(), ret);
            this.proxyIdMap.put(ret.getUid(), node.getUid());
        }
        return ret;
    }
    
    public CaseNode makeCaseNode(CaseNode node)
    {
        if (node == null)
            return null;
        final CaseNode ret;
        if (this.proxyCache.containsKey(node.getUid()))
        {
            ret = (CaseNode)this.proxyCache.get(node.getUid());
        } else
        {
            ret = (CaseNode)(node.executeOperation(WRAPPER, null));
            this.proxyCache.put(node.getUid(), ret);
            this.proxyIdMap.put(ret.getUid(), node.getUid());
        }
        return ret;
    }
    
    public CatchListNode makeCatchListNode(CatchListNode node)
    {
        if (node == null)
            return null;
        final CatchListNode ret;
        if (this.proxyCache.containsKey(node.getUid()))
        {
            ret = (CatchListNode)this.proxyCache.get(node.getUid());
        } else
        {
            ret = (CatchListNode)(node.executeOperation(WRAPPER, null));
            this.proxyCache.put(node.getUid(), ret);
            this.proxyIdMap.put(ret.getUid(), node.getUid());
        }
        return ret;
    }
    
    public CatchNode makeCatchNode(CatchNode node)
    {
        if (node == null)
            return null;
        final CatchNode ret;
        if (this.proxyCache.containsKey(node.getUid()))
        {
            ret = (CatchNode)this.proxyCache.get(node.getUid());
        } else
        {
            ret = (CatchNode)(node.executeOperation(WRAPPER, null));
            this.proxyCache.put(node.getUid(), ret);
            this.proxyIdMap.put(ret.getUid(), node.getUid());
        }
        return ret;
    }
    
    public CharLiteralNode makeCharLiteralNode(CharLiteralNode node)
    {
        if (node == null)
            return null;
        final CharLiteralNode ret;
        if (this.proxyCache.containsKey(node.getUid()))
        {
            ret = (CharLiteralNode)this.proxyCache.get(node.getUid());
        } else
        {
            ret = (CharLiteralNode)(node.executeOperation(WRAPPER, null));
            this.proxyCache.put(node.getUid(), ret);
            this.proxyIdMap.put(ret.getUid(), node.getUid());
        }
        return ret;
    }
    
    public ClassBodyNode makeClassBodyNode(ClassBodyNode node)
    {
        if (node == null)
            return null;
        final ClassBodyNode ret;
        if (this.proxyCache.containsKey(node.getUid()))
        {
            ret = (ClassBodyNode)this.proxyCache.get(node.getUid());
        } else
        {
            ret = (ClassBodyNode)(node.executeOperation(WRAPPER, null));
            this.proxyCache.put(node.getUid(), ret);
            this.proxyIdMap.put(ret.getUid(), node.getUid());
        }
        return ret;
    }
    
    public ClassDeclarationNode makeClassDeclarationNode(ClassDeclarationNode node)
    {
        if (node == null)
            return null;
        final ClassDeclarationNode ret;
        if (this.proxyCache.containsKey(node.getUid()))
        {
            ret = (ClassDeclarationNode)this.proxyCache.get(node.getUid());
        } else
        {
            ret = (ClassDeclarationNode)(node.executeOperation(WRAPPER, null));
            this.proxyCache.put(node.getUid(), ret);
            this.proxyIdMap.put(ret.getUid(), node.getUid());
        }
        return ret;
    }
    
    public ClassInstantiationNode makeClassInstantiationNode(ClassInstantiationNode node)
    {
        if (node == null)
            return null;
        final ClassInstantiationNode ret;
        if (this.proxyCache.containsKey(node.getUid()))
        {
            ret = (ClassInstantiationNode)this.proxyCache.get(node.getUid());
        } else
        {
            ret = (ClassInstantiationNode)(node.executeOperation(WRAPPER, null));
            this.proxyCache.put(node.getUid(), ret);
            this.proxyIdMap.put(ret.getUid(), node.getUid());
        }
        return ret;
    }
    
    public ClassLiteralNode makeClassLiteralNode(ClassLiteralNode node)
    {
        if (node == null)
            return null;
        final ClassLiteralNode ret;
        if (this.proxyCache.containsKey(node.getUid()))
        {
            ret = (ClassLiteralNode)this.proxyCache.get(node.getUid());
        } else
        {
            ret = (ClassLiteralNode)(node.executeOperation(WRAPPER, null));
            this.proxyCache.put(node.getUid(), ret);
            this.proxyIdMap.put(ret.getUid(), node.getUid());
        }
        return ret;
    }
    
    public ClassMemberListNode makeClassMemberListNode(ClassMemberListNode node)
    {
        if (node == null)
            return null;
        final ClassMemberListNode ret;
        if (this.proxyCache.containsKey(node.getUid()))
        {
            ret = (ClassMemberListNode)this.proxyCache.get(node.getUid());
        } else
        {
            ret = (ClassMemberListNode)(node.executeOperation(WRAPPER, null));
            this.proxyCache.put(node.getUid(), ret);
            this.proxyIdMap.put(ret.getUid(), node.getUid());
        }
        return ret;
    }
    
    public ClassMemberMetaprogramAnchorNode makeClassMemberMetaprogramAnchorNode(ClassMemberMetaprogramAnchorNode node)
    {
        if (node == null)
            return null;
        final ClassMemberMetaprogramAnchorNode ret;
        if (this.proxyCache.containsKey(node.getUid()))
        {
            ret = (ClassMemberMetaprogramAnchorNode)this.proxyCache.get(node.getUid());
        } else
        {
            ret = (ClassMemberMetaprogramAnchorNode)(node.executeOperation(WRAPPER, null));
            this.proxyCache.put(node.getUid(), ret);
            this.proxyIdMap.put(ret.getUid(), node.getUid());
        }
        return ret;
    }
    
    public ClassMemberNode makeClassMemberNode(ClassMemberNode node)
    {
        if (node == null)
            return null;
        final ClassMemberNode ret;
        if (this.proxyCache.containsKey(node.getUid()))
        {
            ret = (ClassMemberNode)this.proxyCache.get(node.getUid());
        } else
        {
            ret = (ClassMemberNode)(node.executeOperation(WRAPPER, null));
            this.proxyCache.put(node.getUid(), ret);
            this.proxyIdMap.put(ret.getUid(), node.getUid());
        }
        return ret;
    }
    
    public ClassModifiersNode makeClassModifiersNode(ClassModifiersNode node)
    {
        if (node == null)
            return null;
        final ClassModifiersNode ret;
        if (this.proxyCache.containsKey(node.getUid()))
        {
            ret = (ClassModifiersNode)this.proxyCache.get(node.getUid());
        } else
        {
            ret = (ClassModifiersNode)(node.executeOperation(WRAPPER, null));
            this.proxyCache.put(node.getUid(), ret);
            this.proxyIdMap.put(ret.getUid(), node.getUid());
        }
        return ret;
    }
    
    public CodeLiteralNode makeCodeLiteralNode(CodeLiteralNode node)
    {
        if (node == null)
            return null;
        final CodeLiteralNode ret;
        if (this.proxyCache.containsKey(node.getUid()))
        {
            ret = (CodeLiteralNode)this.proxyCache.get(node.getUid());
        } else
        {
            ret = (CodeLiteralNode)(node.executeOperation(WRAPPER, null));
            this.proxyCache.put(node.getUid(), ret);
            this.proxyIdMap.put(ret.getUid(), node.getUid());
        }
        return ret;
    }
    
    public CompilationUnitNode makeCompilationUnitNode(CompilationUnitNode node)
    {
        if (node == null)
            return null;
        final CompilationUnitNode ret;
        if (this.proxyCache.containsKey(node.getUid()))
        {
            ret = (CompilationUnitNode)this.proxyCache.get(node.getUid());
        } else
        {
            ret = (CompilationUnitNode)(node.executeOperation(WRAPPER, null));
            this.proxyCache.put(node.getUid(), ret);
            this.proxyIdMap.put(ret.getUid(), node.getUid());
        }
        return ret;
    }
    
    public ConditionalExpressionNode makeConditionalExpressionNode(ConditionalExpressionNode node)
    {
        if (node == null)
            return null;
        final ConditionalExpressionNode ret;
        if (this.proxyCache.containsKey(node.getUid()))
        {
            ret = (ConditionalExpressionNode)this.proxyCache.get(node.getUid());
        } else
        {
            ret = (ConditionalExpressionNode)(node.executeOperation(WRAPPER, null));
            this.proxyCache.put(node.getUid(), ret);
            this.proxyIdMap.put(ret.getUid(), node.getUid());
        }
        return ret;
    }
    
    public ConstantDeclarationNode makeConstantDeclarationNode(ConstantDeclarationNode node)
    {
        if (node == null)
            return null;
        final ConstantDeclarationNode ret;
        if (this.proxyCache.containsKey(node.getUid()))
        {
            ret = (ConstantDeclarationNode)this.proxyCache.get(node.getUid());
        } else
        {
            ret = (ConstantDeclarationNode)(node.executeOperation(WRAPPER, null));
            this.proxyCache.put(node.getUid(), ret);
            this.proxyIdMap.put(ret.getUid(), node.getUid());
        }
        return ret;
    }
    
    public ConstantModifiersNode makeConstantModifiersNode(ConstantModifiersNode node)
    {
        if (node == null)
            return null;
        final ConstantModifiersNode ret;
        if (this.proxyCache.containsKey(node.getUid()))
        {
            ret = (ConstantModifiersNode)this.proxyCache.get(node.getUid());
        } else
        {
            ret = (ConstantModifiersNode)(node.executeOperation(WRAPPER, null));
            this.proxyCache.put(node.getUid(), ret);
            this.proxyIdMap.put(ret.getUid(), node.getUid());
        }
        return ret;
    }
    
    public ConstructorBodyNode makeConstructorBodyNode(ConstructorBodyNode node)
    {
        if (node == null)
            return null;
        final ConstructorBodyNode ret;
        if (this.proxyCache.containsKey(node.getUid()))
        {
            ret = (ConstructorBodyNode)this.proxyCache.get(node.getUid());
        } else
        {
            ret = (ConstructorBodyNode)(node.executeOperation(WRAPPER, null));
            this.proxyCache.put(node.getUid(), ret);
            this.proxyIdMap.put(ret.getUid(), node.getUid());
        }
        return ret;
    }
    
    public ConstructorDeclarationNode makeConstructorDeclarationNode(ConstructorDeclarationNode node)
    {
        if (node == null)
            return null;
        final ConstructorDeclarationNode ret;
        if (this.proxyCache.containsKey(node.getUid()))
        {
            ret = (ConstructorDeclarationNode)this.proxyCache.get(node.getUid());
        } else
        {
            ret = (ConstructorDeclarationNode)(node.executeOperation(WRAPPER, null));
            this.proxyCache.put(node.getUid(), ret);
            this.proxyIdMap.put(ret.getUid(), node.getUid());
        }
        return ret;
    }
    
    public ConstructorInvocationNode makeConstructorInvocationNode(ConstructorInvocationNode node)
    {
        if (node == null)
            return null;
        final ConstructorInvocationNode ret;
        if (this.proxyCache.containsKey(node.getUid()))
        {
            ret = (ConstructorInvocationNode)this.proxyCache.get(node.getUid());
        } else
        {
            ret = (ConstructorInvocationNode)(node.executeOperation(WRAPPER, null));
            this.proxyCache.put(node.getUid(), ret);
            this.proxyIdMap.put(ret.getUid(), node.getUid());
        }
        return ret;
    }
    
    public ConstructorModifiersNode makeConstructorModifiersNode(ConstructorModifiersNode node)
    {
        if (node == null)
            return null;
        final ConstructorModifiersNode ret;
        if (this.proxyCache.containsKey(node.getUid()))
        {
            ret = (ConstructorModifiersNode)this.proxyCache.get(node.getUid());
        } else
        {
            ret = (ConstructorModifiersNode)(node.executeOperation(WRAPPER, null));
            this.proxyCache.put(node.getUid(), ret);
            this.proxyIdMap.put(ret.getUid(), node.getUid());
        }
        return ret;
    }
    
    public ContinueNode makeContinueNode(ContinueNode node)
    {
        if (node == null)
            return null;
        final ContinueNode ret;
        if (this.proxyCache.containsKey(node.getUid()))
        {
            ret = (ContinueNode)this.proxyCache.get(node.getUid());
        } else
        {
            ret = (ContinueNode)(node.executeOperation(WRAPPER, null));
            this.proxyCache.put(node.getUid(), ret);
            this.proxyIdMap.put(ret.getUid(), node.getUid());
        }
        return ret;
    }
    
    public DeclarationNode makeDeclarationNode(DeclarationNode node)
    {
        if (node == null)
            return null;
        final DeclarationNode ret;
        if (this.proxyCache.containsKey(node.getUid()))
        {
            ret = (DeclarationNode)this.proxyCache.get(node.getUid());
        } else
        {
            ret = (DeclarationNode)(node.executeOperation(WRAPPER, null));
            this.proxyCache.put(node.getUid(), ret);
            this.proxyIdMap.put(ret.getUid(), node.getUid());
        }
        return ret;
    }
    
    public DeclaredTypeListNode makeDeclaredTypeListNode(DeclaredTypeListNode node)
    {
        if (node == null)
            return null;
        final DeclaredTypeListNode ret;
        if (this.proxyCache.containsKey(node.getUid()))
        {
            ret = (DeclaredTypeListNode)this.proxyCache.get(node.getUid());
        } else
        {
            ret = (DeclaredTypeListNode)(node.executeOperation(WRAPPER, null));
            this.proxyCache.put(node.getUid(), ret);
            this.proxyIdMap.put(ret.getUid(), node.getUid());
        }
        return ret;
    }
    
    public DeclaredTypeNode makeDeclaredTypeNode(DeclaredTypeNode node)
    {
        if (node == null)
            return null;
        final DeclaredTypeNode ret;
        if (this.proxyCache.containsKey(node.getUid()))
        {
            ret = (DeclaredTypeNode)this.proxyCache.get(node.getUid());
        } else
        {
            ret = (DeclaredTypeNode)(node.executeOperation(WRAPPER, null));
            this.proxyCache.put(node.getUid(), ret);
            this.proxyIdMap.put(ret.getUid(), node.getUid());
        }
        return ret;
    }
    
    public DoWhileLoopNode makeDoWhileLoopNode(DoWhileLoopNode node)
    {
        if (node == null)
            return null;
        final DoWhileLoopNode ret;
        if (this.proxyCache.containsKey(node.getUid()))
        {
            ret = (DoWhileLoopNode)this.proxyCache.get(node.getUid());
        } else
        {
            ret = (DoWhileLoopNode)(node.executeOperation(WRAPPER, null));
            this.proxyCache.put(node.getUid(), ret);
            this.proxyIdMap.put(ret.getUid(), node.getUid());
        }
        return ret;
    }
    
    public DoubleLiteralNode makeDoubleLiteralNode(DoubleLiteralNode node)
    {
        if (node == null)
            return null;
        final DoubleLiteralNode ret;
        if (this.proxyCache.containsKey(node.getUid()))
        {
            ret = (DoubleLiteralNode)this.proxyCache.get(node.getUid());
        } else
        {
            ret = (DoubleLiteralNode)(node.executeOperation(WRAPPER, null));
            this.proxyCache.put(node.getUid(), ret);
            this.proxyIdMap.put(ret.getUid(), node.getUid());
        }
        return ret;
    }
    
    public EnhancedForLoopNode makeEnhancedForLoopNode(EnhancedForLoopNode node)
    {
        if (node == null)
            return null;
        final EnhancedForLoopNode ret;
        if (this.proxyCache.containsKey(node.getUid()))
        {
            ret = (EnhancedForLoopNode)this.proxyCache.get(node.getUid());
        } else
        {
            ret = (EnhancedForLoopNode)(node.executeOperation(WRAPPER, null));
            this.proxyCache.put(node.getUid(), ret);
            this.proxyIdMap.put(ret.getUid(), node.getUid());
        }
        return ret;
    }
    
    public EnumBodyNode makeEnumBodyNode(EnumBodyNode node)
    {
        if (node == null)
            return null;
        final EnumBodyNode ret;
        if (this.proxyCache.containsKey(node.getUid()))
        {
            ret = (EnumBodyNode)this.proxyCache.get(node.getUid());
        } else
        {
            ret = (EnumBodyNode)(node.executeOperation(WRAPPER, null));
            this.proxyCache.put(node.getUid(), ret);
            this.proxyIdMap.put(ret.getUid(), node.getUid());
        }
        return ret;
    }
    
    public EnumConstantDeclarationListNode makeEnumConstantDeclarationListNode(EnumConstantDeclarationListNode node)
    {
        if (node == null)
            return null;
        final EnumConstantDeclarationListNode ret;
        if (this.proxyCache.containsKey(node.getUid()))
        {
            ret = (EnumConstantDeclarationListNode)this.proxyCache.get(node.getUid());
        } else
        {
            ret = (EnumConstantDeclarationListNode)(node.executeOperation(WRAPPER, null));
            this.proxyCache.put(node.getUid(), ret);
            this.proxyIdMap.put(ret.getUid(), node.getUid());
        }
        return ret;
    }
    
    public EnumConstantDeclarationNode makeEnumConstantDeclarationNode(EnumConstantDeclarationNode node)
    {
        if (node == null)
            return null;
        final EnumConstantDeclarationNode ret;
        if (this.proxyCache.containsKey(node.getUid()))
        {
            ret = (EnumConstantDeclarationNode)this.proxyCache.get(node.getUid());
        } else
        {
            ret = (EnumConstantDeclarationNode)(node.executeOperation(WRAPPER, null));
            this.proxyCache.put(node.getUid(), ret);
            this.proxyIdMap.put(ret.getUid(), node.getUid());
        }
        return ret;
    }
    
    public EnumConstantModifiersNode makeEnumConstantModifiersNode(EnumConstantModifiersNode node)
    {
        if (node == null)
            return null;
        final EnumConstantModifiersNode ret;
        if (this.proxyCache.containsKey(node.getUid()))
        {
            ret = (EnumConstantModifiersNode)this.proxyCache.get(node.getUid());
        } else
        {
            ret = (EnumConstantModifiersNode)(node.executeOperation(WRAPPER, null));
            this.proxyCache.put(node.getUid(), ret);
            this.proxyIdMap.put(ret.getUid(), node.getUid());
        }
        return ret;
    }
    
    public EnumDeclarationNode makeEnumDeclarationNode(EnumDeclarationNode node)
    {
        if (node == null)
            return null;
        final EnumDeclarationNode ret;
        if (this.proxyCache.containsKey(node.getUid()))
        {
            ret = (EnumDeclarationNode)this.proxyCache.get(node.getUid());
        } else
        {
            ret = (EnumDeclarationNode)(node.executeOperation(WRAPPER, null));
            this.proxyCache.put(node.getUid(), ret);
            this.proxyIdMap.put(ret.getUid(), node.getUid());
        }
        return ret;
    }
    
    public EnumModifiersNode makeEnumModifiersNode(EnumModifiersNode node)
    {
        if (node == null)
            return null;
        final EnumModifiersNode ret;
        if (this.proxyCache.containsKey(node.getUid()))
        {
            ret = (EnumModifiersNode)this.proxyCache.get(node.getUid());
        } else
        {
            ret = (EnumModifiersNode)(node.executeOperation(WRAPPER, null));
            this.proxyCache.put(node.getUid(), ret);
            this.proxyIdMap.put(ret.getUid(), node.getUid());
        }
        return ret;
    }
    
    // this suppression is safe as long as the type parameter value is never implementation-specific
    @SuppressWarnings("unchecked")
    public <T extends Node> ExplicitMetaprogramAnchorNode<T> makeExplicitMetaprogramAnchorNode(ExplicitMetaprogramAnchorNode<T> node)
    {
        if (node == null)
            return null;
        final ExplicitMetaprogramAnchorNode<T> ret;
        if (this.proxyCache.containsKey(node.getUid()))
        {
            ret = (ExplicitMetaprogramAnchorNode<T>)this.proxyCache.get(node.getUid());
        } else
        {
            ret = (ExplicitMetaprogramAnchorNode<T>)(node.executeOperation(WRAPPER, null));
            this.proxyCache.put(node.getUid(), ret);
            this.proxyIdMap.put(ret.getUid(), node.getUid());
        }
        return ret;
    }
    
    public ExpressionListNode makeExpressionListNode(ExpressionListNode node)
    {
        if (node == null)
            return null;
        final ExpressionListNode ret;
        if (this.proxyCache.containsKey(node.getUid()))
        {
            ret = (ExpressionListNode)this.proxyCache.get(node.getUid());
        } else
        {
            ret = (ExpressionListNode)(node.executeOperation(WRAPPER, null));
            this.proxyCache.put(node.getUid(), ret);
            this.proxyIdMap.put(ret.getUid(), node.getUid());
        }
        return ret;
    }
    
    public ExpressionNode makeExpressionNode(ExpressionNode node)
    {
        if (node == null)
            return null;
        final ExpressionNode ret;
        if (this.proxyCache.containsKey(node.getUid()))
        {
            ret = (ExpressionNode)this.proxyCache.get(node.getUid());
        } else
        {
            ret = (ExpressionNode)(node.executeOperation(WRAPPER, null));
            this.proxyCache.put(node.getUid(), ret);
            this.proxyIdMap.put(ret.getUid(), node.getUid());
        }
        return ret;
    }
    
    public ExpressionStatementNode makeExpressionStatementNode(ExpressionStatementNode node)
    {
        if (node == null)
            return null;
        final ExpressionStatementNode ret;
        if (this.proxyCache.containsKey(node.getUid()))
        {
            ret = (ExpressionStatementNode)this.proxyCache.get(node.getUid());
        } else
        {
            ret = (ExpressionStatementNode)(node.executeOperation(WRAPPER, null));
            this.proxyCache.put(node.getUid(), ret);
            this.proxyIdMap.put(ret.getUid(), node.getUid());
        }
        return ret;
    }
    
    public FieldDeclarationNode makeFieldDeclarationNode(FieldDeclarationNode node)
    {
        if (node == null)
            return null;
        final FieldDeclarationNode ret;
        if (this.proxyCache.containsKey(node.getUid()))
        {
            ret = (FieldDeclarationNode)this.proxyCache.get(node.getUid());
        } else
        {
            ret = (FieldDeclarationNode)(node.executeOperation(WRAPPER, null));
            this.proxyCache.put(node.getUid(), ret);
            this.proxyIdMap.put(ret.getUid(), node.getUid());
        }
        return ret;
    }
    
    public FieldModifiersNode makeFieldModifiersNode(FieldModifiersNode node)
    {
        if (node == null)
            return null;
        final FieldModifiersNode ret;
        if (this.proxyCache.containsKey(node.getUid()))
        {
            ret = (FieldModifiersNode)this.proxyCache.get(node.getUid());
        } else
        {
            ret = (FieldModifiersNode)(node.executeOperation(WRAPPER, null));
            this.proxyCache.put(node.getUid(), ret);
            this.proxyIdMap.put(ret.getUid(), node.getUid());
        }
        return ret;
    }
    
    public FloatLiteralNode makeFloatLiteralNode(FloatLiteralNode node)
    {
        if (node == null)
            return null;
        final FloatLiteralNode ret;
        if (this.proxyCache.containsKey(node.getUid()))
        {
            ret = (FloatLiteralNode)this.proxyCache.get(node.getUid());
        } else
        {
            ret = (FloatLiteralNode)(node.executeOperation(WRAPPER, null));
            this.proxyCache.put(node.getUid(), ret);
            this.proxyIdMap.put(ret.getUid(), node.getUid());
        }
        return ret;
    }
    
    public ForInitializerDeclarationNode makeForInitializerDeclarationNode(ForInitializerDeclarationNode node)
    {
        if (node == null)
            return null;
        final ForInitializerDeclarationNode ret;
        if (this.proxyCache.containsKey(node.getUid()))
        {
            ret = (ForInitializerDeclarationNode)this.proxyCache.get(node.getUid());
        } else
        {
            ret = (ForInitializerDeclarationNode)(node.executeOperation(WRAPPER, null));
            this.proxyCache.put(node.getUid(), ret);
            this.proxyIdMap.put(ret.getUid(), node.getUid());
        }
        return ret;
    }
    
    public ForInitializerExpressionNode makeForInitializerExpressionNode(ForInitializerExpressionNode node)
    {
        if (node == null)
            return null;
        final ForInitializerExpressionNode ret;
        if (this.proxyCache.containsKey(node.getUid()))
        {
            ret = (ForInitializerExpressionNode)this.proxyCache.get(node.getUid());
        } else
        {
            ret = (ForInitializerExpressionNode)(node.executeOperation(WRAPPER, null));
            this.proxyCache.put(node.getUid(), ret);
            this.proxyIdMap.put(ret.getUid(), node.getUid());
        }
        return ret;
    }
    
    public ForInitializerNode makeForInitializerNode(ForInitializerNode node)
    {
        if (node == null)
            return null;
        final ForInitializerNode ret;
        if (this.proxyCache.containsKey(node.getUid()))
        {
            ret = (ForInitializerNode)this.proxyCache.get(node.getUid());
        } else
        {
            ret = (ForInitializerNode)(node.executeOperation(WRAPPER, null));
            this.proxyCache.put(node.getUid(), ret);
            this.proxyIdMap.put(ret.getUid(), node.getUid());
        }
        return ret;
    }
    
    public ForLoopNode makeForLoopNode(ForLoopNode node)
    {
        if (node == null)
            return null;
        final ForLoopNode ret;
        if (this.proxyCache.containsKey(node.getUid()))
        {
            ret = (ForLoopNode)this.proxyCache.get(node.getUid());
        } else
        {
            ret = (ForLoopNode)(node.executeOperation(WRAPPER, null));
            this.proxyCache.put(node.getUid(), ret);
            this.proxyIdMap.put(ret.getUid(), node.getUid());
        }
        return ret;
    }
    
    public IdentifierListNode makeIdentifierListNode(IdentifierListNode node)
    {
        if (node == null)
            return null;
        final IdentifierListNode ret;
        if (this.proxyCache.containsKey(node.getUid()))
        {
            ret = (IdentifierListNode)this.proxyCache.get(node.getUid());
        } else
        {
            ret = (IdentifierListNode)(node.executeOperation(WRAPPER, null));
            this.proxyCache.put(node.getUid(), ret);
            this.proxyIdMap.put(ret.getUid(), node.getUid());
        }
        return ret;
    }
    
    public IdentifierNode makeIdentifierNode(IdentifierNode node)
    {
        if (node == null)
            return null;
        final IdentifierNode ret;
        if (this.proxyCache.containsKey(node.getUid()))
        {
            ret = (IdentifierNode)this.proxyCache.get(node.getUid());
        } else
        {
            ret = (IdentifierNode)(node.executeOperation(WRAPPER, null));
            this.proxyCache.put(node.getUid(), ret);
            this.proxyIdMap.put(ret.getUid(), node.getUid());
        }
        return ret;
    }
    
    public IfNode makeIfNode(IfNode node)
    {
        if (node == null)
            return null;
        final IfNode ret;
        if (this.proxyCache.containsKey(node.getUid()))
        {
            ret = (IfNode)this.proxyCache.get(node.getUid());
        } else
        {
            ret = (IfNode)(node.executeOperation(WRAPPER, null));
            this.proxyCache.put(node.getUid(), ret);
            this.proxyIdMap.put(ret.getUid(), node.getUid());
        }
        return ret;
    }
    
    public ImportListNode makeImportListNode(ImportListNode node)
    {
        if (node == null)
            return null;
        final ImportListNode ret;
        if (this.proxyCache.containsKey(node.getUid()))
        {
            ret = (ImportListNode)this.proxyCache.get(node.getUid());
        } else
        {
            ret = (ImportListNode)(node.executeOperation(WRAPPER, null));
            this.proxyCache.put(node.getUid(), ret);
            this.proxyIdMap.put(ret.getUid(), node.getUid());
        }
        return ret;
    }
    
    public ImportNode makeImportNode(ImportNode node)
    {
        if (node == null)
            return null;
        final ImportNode ret;
        if (this.proxyCache.containsKey(node.getUid()))
        {
            ret = (ImportNode)this.proxyCache.get(node.getUid());
        } else
        {
            ret = (ImportNode)(node.executeOperation(WRAPPER, null));
            this.proxyCache.put(node.getUid(), ret);
            this.proxyIdMap.put(ret.getUid(), node.getUid());
        }
        return ret;
    }
    
    public ImportOnDemandNode makeImportOnDemandNode(ImportOnDemandNode node)
    {
        if (node == null)
            return null;
        final ImportOnDemandNode ret;
        if (this.proxyCache.containsKey(node.getUid()))
        {
            ret = (ImportOnDemandNode)this.proxyCache.get(node.getUid());
        } else
        {
            ret = (ImportOnDemandNode)(node.executeOperation(WRAPPER, null));
            this.proxyCache.put(node.getUid(), ret);
            this.proxyIdMap.put(ret.getUid(), node.getUid());
        }
        return ret;
    }
    
    public ImportSingleTypeNode makeImportSingleTypeNode(ImportSingleTypeNode node)
    {
        if (node == null)
            return null;
        final ImportSingleTypeNode ret;
        if (this.proxyCache.containsKey(node.getUid()))
        {
            ret = (ImportSingleTypeNode)this.proxyCache.get(node.getUid());
        } else
        {
            ret = (ImportSingleTypeNode)(node.executeOperation(WRAPPER, null));
            this.proxyCache.put(node.getUid(), ret);
            this.proxyIdMap.put(ret.getUid(), node.getUid());
        }
        return ret;
    }
    
    public InitializerDeclarationNode makeInitializerDeclarationNode(InitializerDeclarationNode node)
    {
        if (node == null)
            return null;
        final InitializerDeclarationNode ret;
        if (this.proxyCache.containsKey(node.getUid()))
        {
            ret = (InitializerDeclarationNode)this.proxyCache.get(node.getUid());
        } else
        {
            ret = (InitializerDeclarationNode)(node.executeOperation(WRAPPER, null));
            this.proxyCache.put(node.getUid(), ret);
            this.proxyIdMap.put(ret.getUid(), node.getUid());
        }
        return ret;
    }
    
    public InstanceOfNode makeInstanceOfNode(InstanceOfNode node)
    {
        if (node == null)
            return null;
        final InstanceOfNode ret;
        if (this.proxyCache.containsKey(node.getUid()))
        {
            ret = (InstanceOfNode)this.proxyCache.get(node.getUid());
        } else
        {
            ret = (InstanceOfNode)(node.executeOperation(WRAPPER, null));
            this.proxyCache.put(node.getUid(), ret);
            this.proxyIdMap.put(ret.getUid(), node.getUid());
        }
        return ret;
    }
    
    public IntLiteralNode makeIntLiteralNode(IntLiteralNode node)
    {
        if (node == null)
            return null;
        final IntLiteralNode ret;
        if (this.proxyCache.containsKey(node.getUid()))
        {
            ret = (IntLiteralNode)this.proxyCache.get(node.getUid());
        } else
        {
            ret = (IntLiteralNode)(node.executeOperation(WRAPPER, null));
            this.proxyCache.put(node.getUid(), ret);
            this.proxyIdMap.put(ret.getUid(), node.getUid());
        }
        return ret;
    }
    
    public InterfaceBodyNode makeInterfaceBodyNode(InterfaceBodyNode node)
    {
        if (node == null)
            return null;
        final InterfaceBodyNode ret;
        if (this.proxyCache.containsKey(node.getUid()))
        {
            ret = (InterfaceBodyNode)this.proxyCache.get(node.getUid());
        } else
        {
            ret = (InterfaceBodyNode)(node.executeOperation(WRAPPER, null));
            this.proxyCache.put(node.getUid(), ret);
            this.proxyIdMap.put(ret.getUid(), node.getUid());
        }
        return ret;
    }
    
    public InterfaceDeclarationNode makeInterfaceDeclarationNode(InterfaceDeclarationNode node)
    {
        if (node == null)
            return null;
        final InterfaceDeclarationNode ret;
        if (this.proxyCache.containsKey(node.getUid()))
        {
            ret = (InterfaceDeclarationNode)this.proxyCache.get(node.getUid());
        } else
        {
            ret = (InterfaceDeclarationNode)(node.executeOperation(WRAPPER, null));
            this.proxyCache.put(node.getUid(), ret);
            this.proxyIdMap.put(ret.getUid(), node.getUid());
        }
        return ret;
    }
    
    public InterfaceMemberListNode makeInterfaceMemberListNode(InterfaceMemberListNode node)
    {
        if (node == null)
            return null;
        final InterfaceMemberListNode ret;
        if (this.proxyCache.containsKey(node.getUid()))
        {
            ret = (InterfaceMemberListNode)this.proxyCache.get(node.getUid());
        } else
        {
            ret = (InterfaceMemberListNode)(node.executeOperation(WRAPPER, null));
            this.proxyCache.put(node.getUid(), ret);
            this.proxyIdMap.put(ret.getUid(), node.getUid());
        }
        return ret;
    }
    
    public InterfaceMemberMetaprogramAnchorNode makeInterfaceMemberMetaprogramAnchorNode(InterfaceMemberMetaprogramAnchorNode node)
    {
        if (node == null)
            return null;
        final InterfaceMemberMetaprogramAnchorNode ret;
        if (this.proxyCache.containsKey(node.getUid()))
        {
            ret = (InterfaceMemberMetaprogramAnchorNode)this.proxyCache.get(node.getUid());
        } else
        {
            ret = (InterfaceMemberMetaprogramAnchorNode)(node.executeOperation(WRAPPER, null));
            this.proxyCache.put(node.getUid(), ret);
            this.proxyIdMap.put(ret.getUid(), node.getUid());
        }
        return ret;
    }
    
    public InterfaceMemberNode makeInterfaceMemberNode(InterfaceMemberNode node)
    {
        if (node == null)
            return null;
        final InterfaceMemberNode ret;
        if (this.proxyCache.containsKey(node.getUid()))
        {
            ret = (InterfaceMemberNode)this.proxyCache.get(node.getUid());
        } else
        {
            ret = (InterfaceMemberNode)(node.executeOperation(WRAPPER, null));
            this.proxyCache.put(node.getUid(), ret);
            this.proxyIdMap.put(ret.getUid(), node.getUid());
        }
        return ret;
    }
    
    public InterfaceModifiersNode makeInterfaceModifiersNode(InterfaceModifiersNode node)
    {
        if (node == null)
            return null;
        final InterfaceModifiersNode ret;
        if (this.proxyCache.containsKey(node.getUid()))
        {
            ret = (InterfaceModifiersNode)this.proxyCache.get(node.getUid());
        } else
        {
            ret = (InterfaceModifiersNode)(node.executeOperation(WRAPPER, null));
            this.proxyCache.put(node.getUid(), ret);
            this.proxyIdMap.put(ret.getUid(), node.getUid());
        }
        return ret;
    }
    
    public InvokableNameBindingNode makeInvokableNameBindingNode(InvokableNameBindingNode node)
    {
        if (node == null)
            return null;
        final InvokableNameBindingNode ret;
        if (this.proxyCache.containsKey(node.getUid()))
        {
            ret = (InvokableNameBindingNode)this.proxyCache.get(node.getUid());
        } else
        {
            ret = (InvokableNameBindingNode)(node.executeOperation(WRAPPER, null));
            this.proxyCache.put(node.getUid(), ret);
            this.proxyIdMap.put(ret.getUid(), node.getUid());
        }
        return ret;
    }
    
    public JavadocNode makeJavadocNode(JavadocNode node)
    {
        if (node == null)
            return null;
        final JavadocNode ret;
        if (this.proxyCache.containsKey(node.getUid()))
        {
            ret = (JavadocNode)this.proxyCache.get(node.getUid());
        } else
        {
            ret = (JavadocNode)(node.executeOperation(WRAPPER, null));
            this.proxyCache.put(node.getUid(), ret);
            this.proxyIdMap.put(ret.getUid(), node.getUid());
        }
        return ret;
    }
    
    public LabeledStatementNode makeLabeledStatementNode(LabeledStatementNode node)
    {
        if (node == null)
            return null;
        final LabeledStatementNode ret;
        if (this.proxyCache.containsKey(node.getUid()))
        {
            ret = (LabeledStatementNode)this.proxyCache.get(node.getUid());
        } else
        {
            ret = (LabeledStatementNode)(node.executeOperation(WRAPPER, null));
            this.proxyCache.put(node.getUid(), ret);
            this.proxyIdMap.put(ret.getUid(), node.getUid());
        }
        return ret;
    }
    
    // this suppression is safe as long as the type parameter value is never implementation-specific
    @SuppressWarnings("unchecked")
    public <T extends Node> ListNode<T> makeListNode(ListNode<T> node)
    {
        if (node == null)
            return null;
        final ListNode<T> ret;
        if (this.proxyCache.containsKey(node.getUid()))
        {
            ret = (ListNode<T>)this.proxyCache.get(node.getUid());
        } else
        {
            ret = (ListNode<T>)(node.executeOperation(WRAPPER, null));
            this.proxyCache.put(node.getUid(), ret);
            this.proxyIdMap.put(ret.getUid(), node.getUid());
        }
        return ret;
    }
    
    // this suppression is safe as long as the type parameter value is never implementation-specific
    @SuppressWarnings("unchecked")
    public <T> LiteralNode<T> makeLiteralNode(LiteralNode<T> node)
    {
        if (node == null)
            return null;
        final LiteralNode<T> ret;
        if (this.proxyCache.containsKey(node.getUid()))
        {
            ret = (LiteralNode<T>)this.proxyCache.get(node.getUid());
        } else
        {
            ret = (LiteralNode<T>)(node.executeOperation(WRAPPER, null));
            this.proxyCache.put(node.getUid(), ret);
            this.proxyIdMap.put(ret.getUid(), node.getUid());
        }
        return ret;
    }
    
    public LiteralizableTypeNode makeLiteralizableTypeNode(LiteralizableTypeNode node)
    {
        if (node == null)
            return null;
        final LiteralizableTypeNode ret;
        if (this.proxyCache.containsKey(node.getUid()))
        {
            ret = (LiteralizableTypeNode)this.proxyCache.get(node.getUid());
        } else
        {
            ret = (LiteralizableTypeNode)(node.executeOperation(WRAPPER, null));
            this.proxyCache.put(node.getUid(), ret);
            this.proxyIdMap.put(ret.getUid(), node.getUid());
        }
        return ret;
    }
    
    public LocalClassDeclarationNode makeLocalClassDeclarationNode(LocalClassDeclarationNode node)
    {
        if (node == null)
            return null;
        final LocalClassDeclarationNode ret;
        if (this.proxyCache.containsKey(node.getUid()))
        {
            ret = (LocalClassDeclarationNode)this.proxyCache.get(node.getUid());
        } else
        {
            ret = (LocalClassDeclarationNode)(node.executeOperation(WRAPPER, null));
            this.proxyCache.put(node.getUid(), ret);
            this.proxyIdMap.put(ret.getUid(), node.getUid());
        }
        return ret;
    }
    
    public LocalClassModifiersNode makeLocalClassModifiersNode(LocalClassModifiersNode node)
    {
        if (node == null)
            return null;
        final LocalClassModifiersNode ret;
        if (this.proxyCache.containsKey(node.getUid()))
        {
            ret = (LocalClassModifiersNode)this.proxyCache.get(node.getUid());
        } else
        {
            ret = (LocalClassModifiersNode)(node.executeOperation(WRAPPER, null));
            this.proxyCache.put(node.getUid(), ret);
            this.proxyIdMap.put(ret.getUid(), node.getUid());
        }
        return ret;
    }
    
    public LocalVariableDeclarationNode makeLocalVariableDeclarationNode(LocalVariableDeclarationNode node)
    {
        if (node == null)
            return null;
        final LocalVariableDeclarationNode ret;
        if (this.proxyCache.containsKey(node.getUid()))
        {
            ret = (LocalVariableDeclarationNode)this.proxyCache.get(node.getUid());
        } else
        {
            ret = (LocalVariableDeclarationNode)(node.executeOperation(WRAPPER, null));
            this.proxyCache.put(node.getUid(), ret);
            this.proxyIdMap.put(ret.getUid(), node.getUid());
        }
        return ret;
    }
    
    public LongLiteralNode makeLongLiteralNode(LongLiteralNode node)
    {
        if (node == null)
            return null;
        final LongLiteralNode ret;
        if (this.proxyCache.containsKey(node.getUid()))
        {
            ret = (LongLiteralNode)this.proxyCache.get(node.getUid());
        } else
        {
            ret = (LongLiteralNode)(node.executeOperation(WRAPPER, null));
            this.proxyCache.put(node.getUid(), ret);
            this.proxyIdMap.put(ret.getUid(), node.getUid());
        }
        return ret;
    }
    
    public MetaAnnotatableNode makeMetaAnnotatableNode(MetaAnnotatableNode node)
    {
        if (node == null)
            return null;
        final MetaAnnotatableNode ret;
        if (this.proxyCache.containsKey(node.getUid()))
        {
            ret = (MetaAnnotatableNode)this.proxyCache.get(node.getUid());
        } else
        {
            ret = (MetaAnnotatableNode)(node.executeOperation(WRAPPER, null));
            this.proxyCache.put(node.getUid(), ret);
            this.proxyIdMap.put(ret.getUid(), node.getUid());
        }
        return ret;
    }
    
    public MetaAnnotationArrayValueNode makeMetaAnnotationArrayValueNode(MetaAnnotationArrayValueNode node)
    {
        if (node == null)
            return null;
        final MetaAnnotationArrayValueNode ret;
        if (this.proxyCache.containsKey(node.getUid()))
        {
            ret = (MetaAnnotationArrayValueNode)this.proxyCache.get(node.getUid());
        } else
        {
            ret = (MetaAnnotationArrayValueNode)(node.executeOperation(WRAPPER, null));
            this.proxyCache.put(node.getUid(), ret);
            this.proxyIdMap.put(ret.getUid(), node.getUid());
        }
        return ret;
    }
    
    public MetaAnnotationElementListNode makeMetaAnnotationElementListNode(MetaAnnotationElementListNode node)
    {
        if (node == null)
            return null;
        final MetaAnnotationElementListNode ret;
        if (this.proxyCache.containsKey(node.getUid()))
        {
            ret = (MetaAnnotationElementListNode)this.proxyCache.get(node.getUid());
        } else
        {
            ret = (MetaAnnotationElementListNode)(node.executeOperation(WRAPPER, null));
            this.proxyCache.put(node.getUid(), ret);
            this.proxyIdMap.put(ret.getUid(), node.getUid());
        }
        return ret;
    }
    
    public MetaAnnotationElementNode makeMetaAnnotationElementNode(MetaAnnotationElementNode node)
    {
        if (node == null)
            return null;
        final MetaAnnotationElementNode ret;
        if (this.proxyCache.containsKey(node.getUid()))
        {
            ret = (MetaAnnotationElementNode)this.proxyCache.get(node.getUid());
        } else
        {
            ret = (MetaAnnotationElementNode)(node.executeOperation(WRAPPER, null));
            this.proxyCache.put(node.getUid(), ret);
            this.proxyIdMap.put(ret.getUid(), node.getUid());
        }
        return ret;
    }
    
    public MetaAnnotationExpressionValueNode makeMetaAnnotationExpressionValueNode(MetaAnnotationExpressionValueNode node)
    {
        if (node == null)
            return null;
        final MetaAnnotationExpressionValueNode ret;
        if (this.proxyCache.containsKey(node.getUid()))
        {
            ret = (MetaAnnotationExpressionValueNode)this.proxyCache.get(node.getUid());
        } else
        {
            ret = (MetaAnnotationExpressionValueNode)(node.executeOperation(WRAPPER, null));
            this.proxyCache.put(node.getUid(), ret);
            this.proxyIdMap.put(ret.getUid(), node.getUid());
        }
        return ret;
    }
    
    public MetaAnnotationListNode makeMetaAnnotationListNode(MetaAnnotationListNode node)
    {
        if (node == null)
            return null;
        final MetaAnnotationListNode ret;
        if (this.proxyCache.containsKey(node.getUid()))
        {
            ret = (MetaAnnotationListNode)this.proxyCache.get(node.getUid());
        } else
        {
            ret = (MetaAnnotationListNode)(node.executeOperation(WRAPPER, null));
            this.proxyCache.put(node.getUid(), ret);
            this.proxyIdMap.put(ret.getUid(), node.getUid());
        }
        return ret;
    }
    
    public MetaAnnotationMetaAnnotationValueNode makeMetaAnnotationMetaAnnotationValueNode(MetaAnnotationMetaAnnotationValueNode node)
    {
        if (node == null)
            return null;
        final MetaAnnotationMetaAnnotationValueNode ret;
        if (this.proxyCache.containsKey(node.getUid()))
        {
            ret = (MetaAnnotationMetaAnnotationValueNode)this.proxyCache.get(node.getUid());
        } else
        {
            ret = (MetaAnnotationMetaAnnotationValueNode)(node.executeOperation(WRAPPER, null));
            this.proxyCache.put(node.getUid(), ret);
            this.proxyIdMap.put(ret.getUid(), node.getUid());
        }
        return ret;
    }
    
    public MetaAnnotationMetaprogramAnchorNode makeMetaAnnotationMetaprogramAnchorNode(MetaAnnotationMetaprogramAnchorNode node)
    {
        if (node == null)
            return null;
        final MetaAnnotationMetaprogramAnchorNode ret;
        if (this.proxyCache.containsKey(node.getUid()))
        {
            ret = (MetaAnnotationMetaprogramAnchorNode)this.proxyCache.get(node.getUid());
        } else
        {
            ret = (MetaAnnotationMetaprogramAnchorNode)(node.executeOperation(WRAPPER, null));
            this.proxyCache.put(node.getUid(), ret);
            this.proxyIdMap.put(ret.getUid(), node.getUid());
        }
        return ret;
    }
    
    public MetaAnnotationNode makeMetaAnnotationNode(MetaAnnotationNode node)
    {
        if (node == null)
            return null;
        final MetaAnnotationNode ret;
        if (this.proxyCache.containsKey(node.getUid()))
        {
            ret = (MetaAnnotationNode)this.proxyCache.get(node.getUid());
        } else
        {
            ret = (MetaAnnotationNode)(node.executeOperation(WRAPPER, null));
            this.proxyCache.put(node.getUid(), ret);
            this.proxyIdMap.put(ret.getUid(), node.getUid());
        }
        return ret;
    }
    
    public MetaAnnotationValueListNode makeMetaAnnotationValueListNode(MetaAnnotationValueListNode node)
    {
        if (node == null)
            return null;
        final MetaAnnotationValueListNode ret;
        if (this.proxyCache.containsKey(node.getUid()))
        {
            ret = (MetaAnnotationValueListNode)this.proxyCache.get(node.getUid());
        } else
        {
            ret = (MetaAnnotationValueListNode)(node.executeOperation(WRAPPER, null));
            this.proxyCache.put(node.getUid(), ret);
            this.proxyIdMap.put(ret.getUid(), node.getUid());
        }
        return ret;
    }
    
    public MetaAnnotationValueNode makeMetaAnnotationValueNode(MetaAnnotationValueNode node)
    {
        if (node == null)
            return null;
        final MetaAnnotationValueNode ret;
        if (this.proxyCache.containsKey(node.getUid()))
        {
            ret = (MetaAnnotationValueNode)this.proxyCache.get(node.getUid());
        } else
        {
            ret = (MetaAnnotationValueNode)(node.executeOperation(WRAPPER, null));
            this.proxyCache.put(node.getUid(), ret);
            this.proxyIdMap.put(ret.getUid(), node.getUid());
        }
        return ret;
    }
    
    // this suppression is safe as long as the type parameter value is never implementation-specific
    @SuppressWarnings("unchecked")
    public <T extends Node> MetaprogramAnchorNode<T> makeMetaprogramAnchorNode(MetaprogramAnchorNode<T> node)
    {
        if (node == null)
            return null;
        final MetaprogramAnchorNode<T> ret;
        if (this.proxyCache.containsKey(node.getUid()))
        {
            ret = (MetaprogramAnchorNode<T>)this.proxyCache.get(node.getUid());
        } else
        {
            ret = (MetaprogramAnchorNode<T>)(node.executeOperation(WRAPPER, null));
            this.proxyCache.put(node.getUid(), ret);
            this.proxyIdMap.put(ret.getUid(), node.getUid());
        }
        return ret;
    }
    
    public MetaprogramDependencyDeclarationListNode makeMetaprogramDependencyDeclarationListNode(MetaprogramDependencyDeclarationListNode node)
    {
        if (node == null)
            return null;
        final MetaprogramDependencyDeclarationListNode ret;
        if (this.proxyCache.containsKey(node.getUid()))
        {
            ret = (MetaprogramDependencyDeclarationListNode)this.proxyCache.get(node.getUid());
        } else
        {
            ret = (MetaprogramDependencyDeclarationListNode)(node.executeOperation(WRAPPER, null));
            this.proxyCache.put(node.getUid(), ret);
            this.proxyIdMap.put(ret.getUid(), node.getUid());
        }
        return ret;
    }
    
    public MetaprogramDependencyDeclarationNode makeMetaprogramDependencyDeclarationNode(MetaprogramDependencyDeclarationNode node)
    {
        if (node == null)
            return null;
        final MetaprogramDependencyDeclarationNode ret;
        if (this.proxyCache.containsKey(node.getUid()))
        {
            ret = (MetaprogramDependencyDeclarationNode)this.proxyCache.get(node.getUid());
        } else
        {
            ret = (MetaprogramDependencyDeclarationNode)(node.executeOperation(WRAPPER, null));
            this.proxyCache.put(node.getUid(), ret);
            this.proxyIdMap.put(ret.getUid(), node.getUid());
        }
        return ret;
    }
    
    public MetaprogramDependencyListNode makeMetaprogramDependencyListNode(MetaprogramDependencyListNode node)
    {
        if (node == null)
            return null;
        final MetaprogramDependencyListNode ret;
        if (this.proxyCache.containsKey(node.getUid()))
        {
            ret = (MetaprogramDependencyListNode)this.proxyCache.get(node.getUid());
        } else
        {
            ret = (MetaprogramDependencyListNode)(node.executeOperation(WRAPPER, null));
            this.proxyCache.put(node.getUid(), ret);
            this.proxyIdMap.put(ret.getUid(), node.getUid());
        }
        return ret;
    }
    
    public MetaprogramDependencyNode makeMetaprogramDependencyNode(MetaprogramDependencyNode node)
    {
        if (node == null)
            return null;
        final MetaprogramDependencyNode ret;
        if (this.proxyCache.containsKey(node.getUid()))
        {
            ret = (MetaprogramDependencyNode)this.proxyCache.get(node.getUid());
        } else
        {
            ret = (MetaprogramDependencyNode)(node.executeOperation(WRAPPER, null));
            this.proxyCache.put(node.getUid(), ret);
            this.proxyIdMap.put(ret.getUid(), node.getUid());
        }
        return ret;
    }
    
    public MetaprogramImportListNode makeMetaprogramImportListNode(MetaprogramImportListNode node)
    {
        if (node == null)
            return null;
        final MetaprogramImportListNode ret;
        if (this.proxyCache.containsKey(node.getUid()))
        {
            ret = (MetaprogramImportListNode)this.proxyCache.get(node.getUid());
        } else
        {
            ret = (MetaprogramImportListNode)(node.executeOperation(WRAPPER, null));
            this.proxyCache.put(node.getUid(), ret);
            this.proxyIdMap.put(ret.getUid(), node.getUid());
        }
        return ret;
    }
    
    public MetaprogramImportNode makeMetaprogramImportNode(MetaprogramImportNode node)
    {
        if (node == null)
            return null;
        final MetaprogramImportNode ret;
        if (this.proxyCache.containsKey(node.getUid()))
        {
            ret = (MetaprogramImportNode)this.proxyCache.get(node.getUid());
        } else
        {
            ret = (MetaprogramImportNode)(node.executeOperation(WRAPPER, null));
            this.proxyCache.put(node.getUid(), ret);
            this.proxyIdMap.put(ret.getUid(), node.getUid());
        }
        return ret;
    }
    
    public MetaprogramNode makeMetaprogramNode(MetaprogramNode node)
    {
        if (node == null)
            return null;
        final MetaprogramNode ret;
        if (this.proxyCache.containsKey(node.getUid()))
        {
            ret = (MetaprogramNode)this.proxyCache.get(node.getUid());
        } else
        {
            ret = (MetaprogramNode)(node.executeOperation(WRAPPER, null));
            this.proxyCache.put(node.getUid(), ret);
            this.proxyIdMap.put(ret.getUid(), node.getUid());
        }
        return ret;
    }
    
    public MetaprogramPreambleNode makeMetaprogramPreambleNode(MetaprogramPreambleNode node)
    {
        if (node == null)
            return null;
        final MetaprogramPreambleNode ret;
        if (this.proxyCache.containsKey(node.getUid()))
        {
            ret = (MetaprogramPreambleNode)this.proxyCache.get(node.getUid());
        } else
        {
            ret = (MetaprogramPreambleNode)(node.executeOperation(WRAPPER, null));
            this.proxyCache.put(node.getUid(), ret);
            this.proxyIdMap.put(ret.getUid(), node.getUid());
        }
        return ret;
    }
    
    public MetaprogramTargetListNode makeMetaprogramTargetListNode(MetaprogramTargetListNode node)
    {
        if (node == null)
            return null;
        final MetaprogramTargetListNode ret;
        if (this.proxyCache.containsKey(node.getUid()))
        {
            ret = (MetaprogramTargetListNode)this.proxyCache.get(node.getUid());
        } else
        {
            ret = (MetaprogramTargetListNode)(node.executeOperation(WRAPPER, null));
            this.proxyCache.put(node.getUid(), ret);
            this.proxyIdMap.put(ret.getUid(), node.getUid());
        }
        return ret;
    }
    
    public MetaprogramTargetNode makeMetaprogramTargetNode(MetaprogramTargetNode node)
    {
        if (node == null)
            return null;
        final MetaprogramTargetNode ret;
        if (this.proxyCache.containsKey(node.getUid()))
        {
            ret = (MetaprogramTargetNode)this.proxyCache.get(node.getUid());
        } else
        {
            ret = (MetaprogramTargetNode)(node.executeOperation(WRAPPER, null));
            this.proxyCache.put(node.getUid(), ret);
            this.proxyIdMap.put(ret.getUid(), node.getUid());
        }
        return ret;
    }
    
    public MethodDeclarationNode makeMethodDeclarationNode(MethodDeclarationNode node)
    {
        if (node == null)
            return null;
        final MethodDeclarationNode ret;
        if (this.proxyCache.containsKey(node.getUid()))
        {
            ret = (MethodDeclarationNode)this.proxyCache.get(node.getUid());
        } else
        {
            ret = (MethodDeclarationNode)(node.executeOperation(WRAPPER, null));
            this.proxyCache.put(node.getUid(), ret);
            this.proxyIdMap.put(ret.getUid(), node.getUid());
        }
        return ret;
    }
    
    public MethodInvocationNode makeMethodInvocationNode(MethodInvocationNode node)
    {
        if (node == null)
            return null;
        final MethodInvocationNode ret;
        if (this.proxyCache.containsKey(node.getUid()))
        {
            ret = (MethodInvocationNode)this.proxyCache.get(node.getUid());
        } else
        {
            ret = (MethodInvocationNode)(node.executeOperation(WRAPPER, null));
            this.proxyCache.put(node.getUid(), ret);
            this.proxyIdMap.put(ret.getUid(), node.getUid());
        }
        return ret;
    }
    
    public MethodModifiersNode makeMethodModifiersNode(MethodModifiersNode node)
    {
        if (node == null)
            return null;
        final MethodModifiersNode ret;
        if (this.proxyCache.containsKey(node.getUid()))
        {
            ret = (MethodModifiersNode)this.proxyCache.get(node.getUid());
        } else
        {
            ret = (MethodModifiersNode)(node.executeOperation(WRAPPER, null));
            this.proxyCache.put(node.getUid(), ret);
            this.proxyIdMap.put(ret.getUid(), node.getUid());
        }
        return ret;
    }
    
    // this suppression is safe as long as the type parameter value is never implementation-specific
    @SuppressWarnings("unchecked")
    public <T extends ModifiersNode> ModifiedNode<T> makeModifiedNode(ModifiedNode<T> node)
    {
        if (node == null)
            return null;
        final ModifiedNode<T> ret;
        if (this.proxyCache.containsKey(node.getUid()))
        {
            ret = (ModifiedNode<T>)this.proxyCache.get(node.getUid());
        } else
        {
            ret = (ModifiedNode<T>)(node.executeOperation(WRAPPER, null));
            this.proxyCache.put(node.getUid(), ret);
            this.proxyIdMap.put(ret.getUid(), node.getUid());
        }
        return ret;
    }
    
    public ModifiersNode makeModifiersNode(ModifiersNode node)
    {
        if (node == null)
            return null;
        final ModifiersNode ret;
        if (this.proxyCache.containsKey(node.getUid()))
        {
            ret = (ModifiersNode)this.proxyCache.get(node.getUid());
        } else
        {
            ret = (ModifiersNode)(node.executeOperation(WRAPPER, null));
            this.proxyCache.put(node.getUid(), ret);
            this.proxyIdMap.put(ret.getUid(), node.getUid());
        }
        return ret;
    }
    
    public NameNode makeNameNode(NameNode node)
    {
        if (node == null)
            return null;
        final NameNode ret;
        if (this.proxyCache.containsKey(node.getUid()))
        {
            ret = (NameNode)this.proxyCache.get(node.getUid());
        } else
        {
            ret = (NameNode)(node.executeOperation(WRAPPER, null));
            this.proxyCache.put(node.getUid(), ret);
            this.proxyIdMap.put(ret.getUid(), node.getUid());
        }
        return ret;
    }
    
    // this suppression is safe as long as the type parameter value is never implementation-specific
    @SuppressWarnings("unchecked")
    public <T extends Node> NamedTypeDeclarationNode<T> makeNamedTypeDeclarationNode(NamedTypeDeclarationNode<T> node)
    {
        if (node == null)
            return null;
        final NamedTypeDeclarationNode<T> ret;
        if (this.proxyCache.containsKey(node.getUid()))
        {
            ret = (NamedTypeDeclarationNode<T>)this.proxyCache.get(node.getUid());
        } else
        {
            ret = (NamedTypeDeclarationNode<T>)(node.executeOperation(WRAPPER, null));
            this.proxyCache.put(node.getUid(), ret);
            this.proxyIdMap.put(ret.getUid(), node.getUid());
        }
        return ret;
    }
    
    public NoOperationNode makeNoOperationNode(NoOperationNode node)
    {
        if (node == null)
            return null;
        final NoOperationNode ret;
        if (this.proxyCache.containsKey(node.getUid()))
        {
            ret = (NoOperationNode)this.proxyCache.get(node.getUid());
        } else
        {
            ret = (NoOperationNode)(node.executeOperation(WRAPPER, null));
            this.proxyCache.put(node.getUid(), ret);
            this.proxyIdMap.put(ret.getUid(), node.getUid());
        }
        return ret;
    }
    
    public Node makeNode(Node node)
    {
        if (node == null)
            return null;
        final Node ret;
        if (this.proxyCache.containsKey(node.getUid()))
        {
            ret = (Node)this.proxyCache.get(node.getUid());
        } else
        {
            ret = (Node)(node.executeOperation(WRAPPER, null));
            this.proxyCache.put(node.getUid(), ret);
            this.proxyIdMap.put(ret.getUid(), node.getUid());
        }
        return ret;
    }
    
    public NonAssignmentExpressionNode makeNonAssignmentExpressionNode(NonAssignmentExpressionNode node)
    {
        if (node == null)
            return null;
        final NonAssignmentExpressionNode ret;
        if (this.proxyCache.containsKey(node.getUid()))
        {
            ret = (NonAssignmentExpressionNode)this.proxyCache.get(node.getUid());
        } else
        {
            ret = (NonAssignmentExpressionNode)(node.executeOperation(WRAPPER, null));
            this.proxyCache.put(node.getUid(), ret);
            this.proxyIdMap.put(ret.getUid(), node.getUid());
        }
        return ret;
    }
    
    public NormalAnnotationNode makeNormalAnnotationNode(NormalAnnotationNode node)
    {
        if (node == null)
            return null;
        final NormalAnnotationNode ret;
        if (this.proxyCache.containsKey(node.getUid()))
        {
            ret = (NormalAnnotationNode)this.proxyCache.get(node.getUid());
        } else
        {
            ret = (NormalAnnotationNode)(node.executeOperation(WRAPPER, null));
            this.proxyCache.put(node.getUid(), ret);
            this.proxyIdMap.put(ret.getUid(), node.getUid());
        }
        return ret;
    }
    
    public NormalMetaAnnotationNode makeNormalMetaAnnotationNode(NormalMetaAnnotationNode node)
    {
        if (node == null)
            return null;
        final NormalMetaAnnotationNode ret;
        if (this.proxyCache.containsKey(node.getUid()))
        {
            ret = (NormalMetaAnnotationNode)this.proxyCache.get(node.getUid());
        } else
        {
            ret = (NormalMetaAnnotationNode)(node.executeOperation(WRAPPER, null));
            this.proxyCache.put(node.getUid(), ret);
            this.proxyIdMap.put(ret.getUid(), node.getUid());
        }
        return ret;
    }
    
    public NullLiteralNode makeNullLiteralNode(NullLiteralNode node)
    {
        if (node == null)
            return null;
        final NullLiteralNode ret;
        if (this.proxyCache.containsKey(node.getUid()))
        {
            ret = (NullLiteralNode)this.proxyCache.get(node.getUid());
        } else
        {
            ret = (NullLiteralNode)(node.executeOperation(WRAPPER, null));
            this.proxyCache.put(node.getUid(), ret);
            this.proxyIdMap.put(ret.getUid(), node.getUid());
        }
        return ret;
    }
    
    public PackageDeclarationNode makePackageDeclarationNode(PackageDeclarationNode node)
    {
        if (node == null)
            return null;
        final PackageDeclarationNode ret;
        if (this.proxyCache.containsKey(node.getUid()))
        {
            ret = (PackageDeclarationNode)this.proxyCache.get(node.getUid());
        } else
        {
            ret = (PackageDeclarationNode)(node.executeOperation(WRAPPER, null));
            this.proxyCache.put(node.getUid(), ret);
            this.proxyIdMap.put(ret.getUid(), node.getUid());
        }
        return ret;
    }
    
    public PackageNode makePackageNode(PackageNode node)
    {
        if (node == null)
            return null;
        final PackageNode ret;
        if (this.proxyCache.containsKey(node.getUid()))
        {
            ret = (PackageNode)this.proxyCache.get(node.getUid());
        } else
        {
            ret = (PackageNode)(node.executeOperation(WRAPPER, null));
            this.proxyCache.put(node.getUid(), ret);
            this.proxyIdMap.put(ret.getUid(), node.getUid());
        }
        return ret;
    }
    
    public ParameterizableTypeDeclarationNode makeParameterizableTypeDeclarationNode(ParameterizableTypeDeclarationNode node)
    {
        if (node == null)
            return null;
        final ParameterizableTypeDeclarationNode ret;
        if (this.proxyCache.containsKey(node.getUid()))
        {
            ret = (ParameterizableTypeDeclarationNode)this.proxyCache.get(node.getUid());
        } else
        {
            ret = (ParameterizableTypeDeclarationNode)(node.executeOperation(WRAPPER, null));
            this.proxyCache.put(node.getUid(), ret);
            this.proxyIdMap.put(ret.getUid(), node.getUid());
        }
        return ret;
    }
    
    public ParameterizedTypeNode makeParameterizedTypeNode(ParameterizedTypeNode node)
    {
        if (node == null)
            return null;
        final ParameterizedTypeNode ret;
        if (this.proxyCache.containsKey(node.getUid()))
        {
            ret = (ParameterizedTypeNode)this.proxyCache.get(node.getUid());
        } else
        {
            ret = (ParameterizedTypeNode)(node.executeOperation(WRAPPER, null));
            this.proxyCache.put(node.getUid(), ret);
            this.proxyIdMap.put(ret.getUid(), node.getUid());
        }
        return ret;
    }
    
    public ParameterizedTypeSelectNode makeParameterizedTypeSelectNode(ParameterizedTypeSelectNode node)
    {
        if (node == null)
            return null;
        final ParameterizedTypeSelectNode ret;
        if (this.proxyCache.containsKey(node.getUid()))
        {
            ret = (ParameterizedTypeSelectNode)this.proxyCache.get(node.getUid());
        } else
        {
            ret = (ParameterizedTypeSelectNode)(node.executeOperation(WRAPPER, null));
            this.proxyCache.put(node.getUid(), ret);
            this.proxyIdMap.put(ret.getUid(), node.getUid());
        }
        return ret;
    }
    
    public ParenthesizedExpressionNode makeParenthesizedExpressionNode(ParenthesizedExpressionNode node)
    {
        if (node == null)
            return null;
        final ParenthesizedExpressionNode ret;
        if (this.proxyCache.containsKey(node.getUid()))
        {
            ret = (ParenthesizedExpressionNode)this.proxyCache.get(node.getUid());
        } else
        {
            ret = (ParenthesizedExpressionNode)(node.executeOperation(WRAPPER, null));
            this.proxyCache.put(node.getUid(), ret);
            this.proxyIdMap.put(ret.getUid(), node.getUid());
        }
        return ret;
    }
    
    public PrimaryExpressionNode makePrimaryExpressionNode(PrimaryExpressionNode node)
    {
        if (node == null)
            return null;
        final PrimaryExpressionNode ret;
        if (this.proxyCache.containsKey(node.getUid()))
        {
            ret = (PrimaryExpressionNode)this.proxyCache.get(node.getUid());
        } else
        {
            ret = (PrimaryExpressionNode)(node.executeOperation(WRAPPER, null));
            this.proxyCache.put(node.getUid(), ret);
            this.proxyIdMap.put(ret.getUid(), node.getUid());
        }
        return ret;
    }
    
    public PrimitiveTypeNode makePrimitiveTypeNode(PrimitiveTypeNode node)
    {
        if (node == null)
            return null;
        final PrimitiveTypeNode ret;
        if (this.proxyCache.containsKey(node.getUid()))
        {
            ret = (PrimitiveTypeNode)this.proxyCache.get(node.getUid());
        } else
        {
            ret = (PrimitiveTypeNode)(node.executeOperation(WRAPPER, null));
            this.proxyCache.put(node.getUid(), ret);
            this.proxyIdMap.put(ret.getUid(), node.getUid());
        }
        return ret;
    }
    
    public QualifiedClassInstantiationNode makeQualifiedClassInstantiationNode(QualifiedClassInstantiationNode node)
    {
        if (node == null)
            return null;
        final QualifiedClassInstantiationNode ret;
        if (this.proxyCache.containsKey(node.getUid()))
        {
            ret = (QualifiedClassInstantiationNode)this.proxyCache.get(node.getUid());
        } else
        {
            ret = (QualifiedClassInstantiationNode)(node.executeOperation(WRAPPER, null));
            this.proxyCache.put(node.getUid(), ret);
            this.proxyIdMap.put(ret.getUid(), node.getUid());
        }
        return ret;
    }
    
    public QualifiedNameNode makeQualifiedNameNode(QualifiedNameNode node)
    {
        if (node == null)
            return null;
        final QualifiedNameNode ret;
        if (this.proxyCache.containsKey(node.getUid()))
        {
            ret = (QualifiedNameNode)this.proxyCache.get(node.getUid());
        } else
        {
            ret = (QualifiedNameNode)(node.executeOperation(WRAPPER, null));
            this.proxyCache.put(node.getUid(), ret);
            this.proxyIdMap.put(ret.getUid(), node.getUid());
        }
        return ret;
    }
    
    public RawCodeLiteralNode makeRawCodeLiteralNode(RawCodeLiteralNode node)
    {
        if (node == null)
            return null;
        final RawCodeLiteralNode ret;
        if (this.proxyCache.containsKey(node.getUid()))
        {
            ret = (RawCodeLiteralNode)this.proxyCache.get(node.getUid());
        } else
        {
            ret = (RawCodeLiteralNode)(node.executeOperation(WRAPPER, null));
            this.proxyCache.put(node.getUid(), ret);
            this.proxyIdMap.put(ret.getUid(), node.getUid());
        }
        return ret;
    }
    
    public ReferenceTypeListNode makeReferenceTypeListNode(ReferenceTypeListNode node)
    {
        if (node == null)
            return null;
        final ReferenceTypeListNode ret;
        if (this.proxyCache.containsKey(node.getUid()))
        {
            ret = (ReferenceTypeListNode)this.proxyCache.get(node.getUid());
        } else
        {
            ret = (ReferenceTypeListNode)(node.executeOperation(WRAPPER, null));
            this.proxyCache.put(node.getUid(), ret);
            this.proxyIdMap.put(ret.getUid(), node.getUid());
        }
        return ret;
    }
    
    public ReferenceTypeNode makeReferenceTypeNode(ReferenceTypeNode node)
    {
        if (node == null)
            return null;
        final ReferenceTypeNode ret;
        if (this.proxyCache.containsKey(node.getUid()))
        {
            ret = (ReferenceTypeNode)this.proxyCache.get(node.getUid());
        } else
        {
            ret = (ReferenceTypeNode)(node.executeOperation(WRAPPER, null));
            this.proxyCache.put(node.getUid(), ret);
            this.proxyIdMap.put(ret.getUid(), node.getUid());
        }
        return ret;
    }
    
    public RestrictedPrimaryExpressionNode makeRestrictedPrimaryExpressionNode(RestrictedPrimaryExpressionNode node)
    {
        if (node == null)
            return null;
        final RestrictedPrimaryExpressionNode ret;
        if (this.proxyCache.containsKey(node.getUid()))
        {
            ret = (RestrictedPrimaryExpressionNode)this.proxyCache.get(node.getUid());
        } else
        {
            ret = (RestrictedPrimaryExpressionNode)(node.executeOperation(WRAPPER, null));
            this.proxyCache.put(node.getUid(), ret);
            this.proxyIdMap.put(ret.getUid(), node.getUid());
        }
        return ret;
    }
    
    public ReturnNode makeReturnNode(ReturnNode node)
    {
        if (node == null)
            return null;
        final ReturnNode ret;
        if (this.proxyCache.containsKey(node.getUid()))
        {
            ret = (ReturnNode)this.proxyCache.get(node.getUid());
        } else
        {
            ret = (ReturnNode)(node.executeOperation(WRAPPER, null));
            this.proxyCache.put(node.getUid(), ret);
            this.proxyIdMap.put(ret.getUid(), node.getUid());
        }
        return ret;
    }
    
    public SimpleNameNode makeSimpleNameNode(SimpleNameNode node)
    {
        if (node == null)
            return null;
        final SimpleNameNode ret;
        if (this.proxyCache.containsKey(node.getUid()))
        {
            ret = (SimpleNameNode)this.proxyCache.get(node.getUid());
        } else
        {
            ret = (SimpleNameNode)(node.executeOperation(WRAPPER, null));
            this.proxyCache.put(node.getUid(), ret);
            this.proxyIdMap.put(ret.getUid(), node.getUid());
        }
        return ret;
    }
    
    public SingleElementAnnotationNode makeSingleElementAnnotationNode(SingleElementAnnotationNode node)
    {
        if (node == null)
            return null;
        final SingleElementAnnotationNode ret;
        if (this.proxyCache.containsKey(node.getUid()))
        {
            ret = (SingleElementAnnotationNode)this.proxyCache.get(node.getUid());
        } else
        {
            ret = (SingleElementAnnotationNode)(node.executeOperation(WRAPPER, null));
            this.proxyCache.put(node.getUid(), ret);
            this.proxyIdMap.put(ret.getUid(), node.getUid());
        }
        return ret;
    }
    
    public SingleElementMetaAnnotationNode makeSingleElementMetaAnnotationNode(SingleElementMetaAnnotationNode node)
    {
        if (node == null)
            return null;
        final SingleElementMetaAnnotationNode ret;
        if (this.proxyCache.containsKey(node.getUid()))
        {
            ret = (SingleElementMetaAnnotationNode)this.proxyCache.get(node.getUid());
        } else
        {
            ret = (SingleElementMetaAnnotationNode)(node.executeOperation(WRAPPER, null));
            this.proxyCache.put(node.getUid(), ret);
            this.proxyIdMap.put(ret.getUid(), node.getUid());
        }
        return ret;
    }
    
    public SingleStaticImportNode makeSingleStaticImportNode(SingleStaticImportNode node)
    {
        if (node == null)
            return null;
        final SingleStaticImportNode ret;
        if (this.proxyCache.containsKey(node.getUid()))
        {
            ret = (SingleStaticImportNode)this.proxyCache.get(node.getUid());
        } else
        {
            ret = (SingleStaticImportNode)(node.executeOperation(WRAPPER, null));
            this.proxyCache.put(node.getUid(), ret);
            this.proxyIdMap.put(ret.getUid(), node.getUid());
        }
        return ret;
    }
    
    public SpliceNode makeSpliceNode(SpliceNode node)
    {
        if (node == null)
            return null;
        final SpliceNode ret;
        if (this.proxyCache.containsKey(node.getUid()))
        {
            ret = (SpliceNode)this.proxyCache.get(node.getUid());
        } else
        {
            ret = (SpliceNode)(node.executeOperation(WRAPPER, null));
            this.proxyCache.put(node.getUid(), ret);
            this.proxyIdMap.put(ret.getUid(), node.getUid());
        }
        return ret;
    }
    
    public StatementExpressionListNode makeStatementExpressionListNode(StatementExpressionListNode node)
    {
        if (node == null)
            return null;
        final StatementExpressionListNode ret;
        if (this.proxyCache.containsKey(node.getUid()))
        {
            ret = (StatementExpressionListNode)this.proxyCache.get(node.getUid());
        } else
        {
            ret = (StatementExpressionListNode)(node.executeOperation(WRAPPER, null));
            this.proxyCache.put(node.getUid(), ret);
            this.proxyIdMap.put(ret.getUid(), node.getUid());
        }
        return ret;
    }
    
    public StatementExpressionNode makeStatementExpressionNode(StatementExpressionNode node)
    {
        if (node == null)
            return null;
        final StatementExpressionNode ret;
        if (this.proxyCache.containsKey(node.getUid()))
        {
            ret = (StatementExpressionNode)this.proxyCache.get(node.getUid());
        } else
        {
            ret = (StatementExpressionNode)(node.executeOperation(WRAPPER, null));
            this.proxyCache.put(node.getUid(), ret);
            this.proxyIdMap.put(ret.getUid(), node.getUid());
        }
        return ret;
    }
    
    public StatementNode makeStatementNode(StatementNode node)
    {
        if (node == null)
            return null;
        final StatementNode ret;
        if (this.proxyCache.containsKey(node.getUid()))
        {
            ret = (StatementNode)this.proxyCache.get(node.getUid());
        } else
        {
            ret = (StatementNode)(node.executeOperation(WRAPPER, null));
            this.proxyCache.put(node.getUid(), ret);
            this.proxyIdMap.put(ret.getUid(), node.getUid());
        }
        return ret;
    }
    
    public StaticImportOnDemandNode makeStaticImportOnDemandNode(StaticImportOnDemandNode node)
    {
        if (node == null)
            return null;
        final StaticImportOnDemandNode ret;
        if (this.proxyCache.containsKey(node.getUid()))
        {
            ret = (StaticImportOnDemandNode)this.proxyCache.get(node.getUid());
        } else
        {
            ret = (StaticImportOnDemandNode)(node.executeOperation(WRAPPER, null));
            this.proxyCache.put(node.getUid(), ret);
            this.proxyIdMap.put(ret.getUid(), node.getUid());
        }
        return ret;
    }
    
    public StringLiteralNode makeStringLiteralNode(StringLiteralNode node)
    {
        if (node == null)
            return null;
        final StringLiteralNode ret;
        if (this.proxyCache.containsKey(node.getUid()))
        {
            ret = (StringLiteralNode)this.proxyCache.get(node.getUid());
        } else
        {
            ret = (StringLiteralNode)(node.executeOperation(WRAPPER, null));
            this.proxyCache.put(node.getUid(), ret);
            this.proxyIdMap.put(ret.getUid(), node.getUid());
        }
        return ret;
    }
    
    public SuperFieldAccessNode makeSuperFieldAccessNode(SuperFieldAccessNode node)
    {
        if (node == null)
            return null;
        final SuperFieldAccessNode ret;
        if (this.proxyCache.containsKey(node.getUid()))
        {
            ret = (SuperFieldAccessNode)this.proxyCache.get(node.getUid());
        } else
        {
            ret = (SuperFieldAccessNode)(node.executeOperation(WRAPPER, null));
            this.proxyCache.put(node.getUid(), ret);
            this.proxyIdMap.put(ret.getUid(), node.getUid());
        }
        return ret;
    }
    
    public SuperMethodInvocationNode makeSuperMethodInvocationNode(SuperMethodInvocationNode node)
    {
        if (node == null)
            return null;
        final SuperMethodInvocationNode ret;
        if (this.proxyCache.containsKey(node.getUid()))
        {
            ret = (SuperMethodInvocationNode)this.proxyCache.get(node.getUid());
        } else
        {
            ret = (SuperMethodInvocationNode)(node.executeOperation(WRAPPER, null));
            this.proxyCache.put(node.getUid(), ret);
            this.proxyIdMap.put(ret.getUid(), node.getUid());
        }
        return ret;
    }
    
    public SuperclassConstructorInvocationNode makeSuperclassConstructorInvocationNode(SuperclassConstructorInvocationNode node)
    {
        if (node == null)
            return null;
        final SuperclassConstructorInvocationNode ret;
        if (this.proxyCache.containsKey(node.getUid()))
        {
            ret = (SuperclassConstructorInvocationNode)this.proxyCache.get(node.getUid());
        } else
        {
            ret = (SuperclassConstructorInvocationNode)(node.executeOperation(WRAPPER, null));
            this.proxyCache.put(node.getUid(), ret);
            this.proxyIdMap.put(ret.getUid(), node.getUid());
        }
        return ret;
    }
    
    public SwitchNode makeSwitchNode(SwitchNode node)
    {
        if (node == null)
            return null;
        final SwitchNode ret;
        if (this.proxyCache.containsKey(node.getUid()))
        {
            ret = (SwitchNode)this.proxyCache.get(node.getUid());
        } else
        {
            ret = (SwitchNode)(node.executeOperation(WRAPPER, null));
            this.proxyCache.put(node.getUid(), ret);
            this.proxyIdMap.put(ret.getUid(), node.getUid());
        }
        return ret;
    }
    
    public SynchronizedNode makeSynchronizedNode(SynchronizedNode node)
    {
        if (node == null)
            return null;
        final SynchronizedNode ret;
        if (this.proxyCache.containsKey(node.getUid()))
        {
            ret = (SynchronizedNode)this.proxyCache.get(node.getUid());
        } else
        {
            ret = (SynchronizedNode)(node.executeOperation(WRAPPER, null));
            this.proxyCache.put(node.getUid(), ret);
            this.proxyIdMap.put(ret.getUid(), node.getUid());
        }
        return ret;
    }
    
    public ThisNode makeThisNode(ThisNode node)
    {
        if (node == null)
            return null;
        final ThisNode ret;
        if (this.proxyCache.containsKey(node.getUid()))
        {
            ret = (ThisNode)this.proxyCache.get(node.getUid());
        } else
        {
            ret = (ThisNode)(node.executeOperation(WRAPPER, null));
            this.proxyCache.put(node.getUid(), ret);
            this.proxyIdMap.put(ret.getUid(), node.getUid());
        }
        return ret;
    }
    
    public ThrowNode makeThrowNode(ThrowNode node)
    {
        if (node == null)
            return null;
        final ThrowNode ret;
        if (this.proxyCache.containsKey(node.getUid()))
        {
            ret = (ThrowNode)this.proxyCache.get(node.getUid());
        } else
        {
            ret = (ThrowNode)(node.executeOperation(WRAPPER, null));
            this.proxyCache.put(node.getUid(), ret);
            this.proxyIdMap.put(ret.getUid(), node.getUid());
        }
        return ret;
    }
    
    public TryNode makeTryNode(TryNode node)
    {
        if (node == null)
            return null;
        final TryNode ret;
        if (this.proxyCache.containsKey(node.getUid()))
        {
            ret = (TryNode)this.proxyCache.get(node.getUid());
        } else
        {
            ret = (TryNode)(node.executeOperation(WRAPPER, null));
            this.proxyCache.put(node.getUid(), ret);
            this.proxyIdMap.put(ret.getUid(), node.getUid());
        }
        return ret;
    }
    
    public TypeArgumentListNode makeTypeArgumentListNode(TypeArgumentListNode node)
    {
        if (node == null)
            return null;
        final TypeArgumentListNode ret;
        if (this.proxyCache.containsKey(node.getUid()))
        {
            ret = (TypeArgumentListNode)this.proxyCache.get(node.getUid());
        } else
        {
            ret = (TypeArgumentListNode)(node.executeOperation(WRAPPER, null));
            this.proxyCache.put(node.getUid(), ret);
            this.proxyIdMap.put(ret.getUid(), node.getUid());
        }
        return ret;
    }
    
    public TypeArgumentNode makeTypeArgumentNode(TypeArgumentNode node)
    {
        if (node == null)
            return null;
        final TypeArgumentNode ret;
        if (this.proxyCache.containsKey(node.getUid()))
        {
            ret = (TypeArgumentNode)this.proxyCache.get(node.getUid());
        } else
        {
            ret = (TypeArgumentNode)(node.executeOperation(WRAPPER, null));
            this.proxyCache.put(node.getUid(), ret);
            this.proxyIdMap.put(ret.getUid(), node.getUid());
        }
        return ret;
    }
    
    // this suppression is safe as long as the type parameter value is never implementation-specific
    @SuppressWarnings("unchecked")
    public <T extends Node> TypeBodyNode<T> makeTypeBodyNode(TypeBodyNode<T> node)
    {
        if (node == null)
            return null;
        final TypeBodyNode<T> ret;
        if (this.proxyCache.containsKey(node.getUid()))
        {
            ret = (TypeBodyNode<T>)this.proxyCache.get(node.getUid());
        } else
        {
            ret = (TypeBodyNode<T>)(node.executeOperation(WRAPPER, null));
            this.proxyCache.put(node.getUid(), ret);
            this.proxyIdMap.put(ret.getUid(), node.getUid());
        }
        return ret;
    }
    
    public TypeCastNode makeTypeCastNode(TypeCastNode node)
    {
        if (node == null)
            return null;
        final TypeCastNode ret;
        if (this.proxyCache.containsKey(node.getUid()))
        {
            ret = (TypeCastNode)this.proxyCache.get(node.getUid());
        } else
        {
            ret = (TypeCastNode)(node.executeOperation(WRAPPER, null));
            this.proxyCache.put(node.getUid(), ret);
            this.proxyIdMap.put(ret.getUid(), node.getUid());
        }
        return ret;
    }
    
    public TypeDeclarationListNode makeTypeDeclarationListNode(TypeDeclarationListNode node)
    {
        if (node == null)
            return null;
        final TypeDeclarationListNode ret;
        if (this.proxyCache.containsKey(node.getUid()))
        {
            ret = (TypeDeclarationListNode)this.proxyCache.get(node.getUid());
        } else
        {
            ret = (TypeDeclarationListNode)(node.executeOperation(WRAPPER, null));
            this.proxyCache.put(node.getUid(), ret);
            this.proxyIdMap.put(ret.getUid(), node.getUid());
        }
        return ret;
    }
    
    public TypeDeclarationMetaprogramAnchorNode makeTypeDeclarationMetaprogramAnchorNode(TypeDeclarationMetaprogramAnchorNode node)
    {
        if (node == null)
            return null;
        final TypeDeclarationMetaprogramAnchorNode ret;
        if (this.proxyCache.containsKey(node.getUid()))
        {
            ret = (TypeDeclarationMetaprogramAnchorNode)this.proxyCache.get(node.getUid());
        } else
        {
            ret = (TypeDeclarationMetaprogramAnchorNode)(node.executeOperation(WRAPPER, null));
            this.proxyCache.put(node.getUid(), ret);
            this.proxyIdMap.put(ret.getUid(), node.getUid());
        }
        return ret;
    }
    
    public TypeDeclarationNode makeTypeDeclarationNode(TypeDeclarationNode node)
    {
        if (node == null)
            return null;
        final TypeDeclarationNode ret;
        if (this.proxyCache.containsKey(node.getUid()))
        {
            ret = (TypeDeclarationNode)this.proxyCache.get(node.getUid());
        } else
        {
            ret = (TypeDeclarationNode)(node.executeOperation(WRAPPER, null));
            this.proxyCache.put(node.getUid(), ret);
            this.proxyIdMap.put(ret.getUid(), node.getUid());
        }
        return ret;
    }
    
    public TypeNameBindingNode makeTypeNameBindingNode(TypeNameBindingNode node)
    {
        if (node == null)
            return null;
        final TypeNameBindingNode ret;
        if (this.proxyCache.containsKey(node.getUid()))
        {
            ret = (TypeNameBindingNode)this.proxyCache.get(node.getUid());
        } else
        {
            ret = (TypeNameBindingNode)(node.executeOperation(WRAPPER, null));
            this.proxyCache.put(node.getUid(), ret);
            this.proxyIdMap.put(ret.getUid(), node.getUid());
        }
        return ret;
    }
    
    public TypeNode makeTypeNode(TypeNode node)
    {
        if (node == null)
            return null;
        final TypeNode ret;
        if (this.proxyCache.containsKey(node.getUid()))
        {
            ret = (TypeNode)this.proxyCache.get(node.getUid());
        } else
        {
            ret = (TypeNode)(node.executeOperation(WRAPPER, null));
            this.proxyCache.put(node.getUid(), ret);
            this.proxyIdMap.put(ret.getUid(), node.getUid());
        }
        return ret;
    }
    
    public TypeParameterListNode makeTypeParameterListNode(TypeParameterListNode node)
    {
        if (node == null)
            return null;
        final TypeParameterListNode ret;
        if (this.proxyCache.containsKey(node.getUid()))
        {
            ret = (TypeParameterListNode)this.proxyCache.get(node.getUid());
        } else
        {
            ret = (TypeParameterListNode)(node.executeOperation(WRAPPER, null));
            this.proxyCache.put(node.getUid(), ret);
            this.proxyIdMap.put(ret.getUid(), node.getUid());
        }
        return ret;
    }
    
    public TypeParameterNode makeTypeParameterNode(TypeParameterNode node)
    {
        if (node == null)
            return null;
        final TypeParameterNode ret;
        if (this.proxyCache.containsKey(node.getUid()))
        {
            ret = (TypeParameterNode)this.proxyCache.get(node.getUid());
        } else
        {
            ret = (TypeParameterNode)(node.executeOperation(WRAPPER, null));
            this.proxyCache.put(node.getUid(), ret);
            this.proxyIdMap.put(ret.getUid(), node.getUid());
        }
        return ret;
    }
    
    public UnaryExpressionNode makeUnaryExpressionNode(UnaryExpressionNode node)
    {
        if (node == null)
            return null;
        final UnaryExpressionNode ret;
        if (this.proxyCache.containsKey(node.getUid()))
        {
            ret = (UnaryExpressionNode)this.proxyCache.get(node.getUid());
        } else
        {
            ret = (UnaryExpressionNode)(node.executeOperation(WRAPPER, null));
            this.proxyCache.put(node.getUid(), ret);
            this.proxyIdMap.put(ret.getUid(), node.getUid());
        }
        return ret;
    }
    
    public UnaryStatementExpressionNode makeUnaryStatementExpressionNode(UnaryStatementExpressionNode node)
    {
        if (node == null)
            return null;
        final UnaryStatementExpressionNode ret;
        if (this.proxyCache.containsKey(node.getUid()))
        {
            ret = (UnaryStatementExpressionNode)this.proxyCache.get(node.getUid());
        } else
        {
            ret = (UnaryStatementExpressionNode)(node.executeOperation(WRAPPER, null));
            this.proxyCache.put(node.getUid(), ret);
            this.proxyIdMap.put(ret.getUid(), node.getUid());
        }
        return ret;
    }
    
    public UnparameterizedTypeListNode makeUnparameterizedTypeListNode(UnparameterizedTypeListNode node)
    {
        if (node == null)
            return null;
        final UnparameterizedTypeListNode ret;
        if (this.proxyCache.containsKey(node.getUid()))
        {
            ret = (UnparameterizedTypeListNode)this.proxyCache.get(node.getUid());
        } else
        {
            ret = (UnparameterizedTypeListNode)(node.executeOperation(WRAPPER, null));
            this.proxyCache.put(node.getUid(), ret);
            this.proxyIdMap.put(ret.getUid(), node.getUid());
        }
        return ret;
    }
    
    public UnparameterizedTypeNode makeUnparameterizedTypeNode(UnparameterizedTypeNode node)
    {
        if (node == null)
            return null;
        final UnparameterizedTypeNode ret;
        if (this.proxyCache.containsKey(node.getUid()))
        {
            ret = (UnparameterizedTypeNode)this.proxyCache.get(node.getUid());
        } else
        {
            ret = (UnparameterizedTypeNode)(node.executeOperation(WRAPPER, null));
            this.proxyCache.put(node.getUid(), ret);
            this.proxyIdMap.put(ret.getUid(), node.getUid());
        }
        return ret;
    }
    
    public UnqualifiedClassInstantiationNode makeUnqualifiedClassInstantiationNode(UnqualifiedClassInstantiationNode node)
    {
        if (node == null)
            return null;
        final UnqualifiedClassInstantiationNode ret;
        if (this.proxyCache.containsKey(node.getUid()))
        {
            ret = (UnqualifiedClassInstantiationNode)this.proxyCache.get(node.getUid());
        } else
        {
            ret = (UnqualifiedClassInstantiationNode)(node.executeOperation(WRAPPER, null));
            this.proxyCache.put(node.getUid(), ret);
            this.proxyIdMap.put(ret.getUid(), node.getUid());
        }
        return ret;
    }
    
    public VariableAccessNode makeVariableAccessNode(VariableAccessNode node)
    {
        if (node == null)
            return null;
        final VariableAccessNode ret;
        if (this.proxyCache.containsKey(node.getUid()))
        {
            ret = (VariableAccessNode)this.proxyCache.get(node.getUid());
        } else
        {
            ret = (VariableAccessNode)(node.executeOperation(WRAPPER, null));
            this.proxyCache.put(node.getUid(), ret);
            this.proxyIdMap.put(ret.getUid(), node.getUid());
        }
        return ret;
    }
    
    public VariableDeclaratorListNode makeVariableDeclaratorListNode(VariableDeclaratorListNode node)
    {
        if (node == null)
            return null;
        final VariableDeclaratorListNode ret;
        if (this.proxyCache.containsKey(node.getUid()))
        {
            ret = (VariableDeclaratorListNode)this.proxyCache.get(node.getUid());
        } else
        {
            ret = (VariableDeclaratorListNode)(node.executeOperation(WRAPPER, null));
            this.proxyCache.put(node.getUid(), ret);
            this.proxyIdMap.put(ret.getUid(), node.getUid());
        }
        return ret;
    }
    
    public VariableDeclaratorNode makeVariableDeclaratorNode(VariableDeclaratorNode node)
    {
        if (node == null)
            return null;
        final VariableDeclaratorNode ret;
        if (this.proxyCache.containsKey(node.getUid()))
        {
            ret = (VariableDeclaratorNode)this.proxyCache.get(node.getUid());
        } else
        {
            ret = (VariableDeclaratorNode)(node.executeOperation(WRAPPER, null));
            this.proxyCache.put(node.getUid(), ret);
            this.proxyIdMap.put(ret.getUid(), node.getUid());
        }
        return ret;
    }
    
    public VariableDeclaratorOwnerNode makeVariableDeclaratorOwnerNode(VariableDeclaratorOwnerNode node)
    {
        if (node == null)
            return null;
        final VariableDeclaratorOwnerNode ret;
        if (this.proxyCache.containsKey(node.getUid()))
        {
            ret = (VariableDeclaratorOwnerNode)this.proxyCache.get(node.getUid());
        } else
        {
            ret = (VariableDeclaratorOwnerNode)(node.executeOperation(WRAPPER, null));
            this.proxyCache.put(node.getUid(), ret);
            this.proxyIdMap.put(ret.getUid(), node.getUid());
        }
        return ret;
    }
    
    public VariableInitializerListNode makeVariableInitializerListNode(VariableInitializerListNode node)
    {
        if (node == null)
            return null;
        final VariableInitializerListNode ret;
        if (this.proxyCache.containsKey(node.getUid()))
        {
            ret = (VariableInitializerListNode)this.proxyCache.get(node.getUid());
        } else
        {
            ret = (VariableInitializerListNode)(node.executeOperation(WRAPPER, null));
            this.proxyCache.put(node.getUid(), ret);
            this.proxyIdMap.put(ret.getUid(), node.getUid());
        }
        return ret;
    }
    
    public VariableInitializerNode makeVariableInitializerNode(VariableInitializerNode node)
    {
        if (node == null)
            return null;
        final VariableInitializerNode ret;
        if (this.proxyCache.containsKey(node.getUid()))
        {
            ret = (VariableInitializerNode)this.proxyCache.get(node.getUid());
        } else
        {
            ret = (VariableInitializerNode)(node.executeOperation(WRAPPER, null));
            this.proxyCache.put(node.getUid(), ret);
            this.proxyIdMap.put(ret.getUid(), node.getUid());
        }
        return ret;
    }
    
    public VariableListNode makeVariableListNode(VariableListNode node)
    {
        if (node == null)
            return null;
        final VariableListNode ret;
        if (this.proxyCache.containsKey(node.getUid()))
        {
            ret = (VariableListNode)this.proxyCache.get(node.getUid());
        } else
        {
            ret = (VariableListNode)(node.executeOperation(WRAPPER, null));
            this.proxyCache.put(node.getUid(), ret);
            this.proxyIdMap.put(ret.getUid(), node.getUid());
        }
        return ret;
    }
    
    public VariableModifiersNode makeVariableModifiersNode(VariableModifiersNode node)
    {
        if (node == null)
            return null;
        final VariableModifiersNode ret;
        if (this.proxyCache.containsKey(node.getUid()))
        {
            ret = (VariableModifiersNode)this.proxyCache.get(node.getUid());
        } else
        {
            ret = (VariableModifiersNode)(node.executeOperation(WRAPPER, null));
            this.proxyCache.put(node.getUid(), ret);
            this.proxyIdMap.put(ret.getUid(), node.getUid());
        }
        return ret;
    }
    
    public VariableNameBindingNode makeVariableNameBindingNode(VariableNameBindingNode node)
    {
        if (node == null)
            return null;
        final VariableNameBindingNode ret;
        if (this.proxyCache.containsKey(node.getUid()))
        {
            ret = (VariableNameBindingNode)this.proxyCache.get(node.getUid());
        } else
        {
            ret = (VariableNameBindingNode)(node.executeOperation(WRAPPER, null));
            this.proxyCache.put(node.getUid(), ret);
            this.proxyIdMap.put(ret.getUid(), node.getUid());
        }
        return ret;
    }
    
    public VariableNode makeVariableNode(VariableNode node)
    {
        if (node == null)
            return null;
        final VariableNode ret;
        if (this.proxyCache.containsKey(node.getUid()))
        {
            ret = (VariableNode)this.proxyCache.get(node.getUid());
        } else
        {
            ret = (VariableNode)(node.executeOperation(WRAPPER, null));
            this.proxyCache.put(node.getUid(), ret);
            this.proxyIdMap.put(ret.getUid(), node.getUid());
        }
        return ret;
    }
    
    public VoidTypeNode makeVoidTypeNode(VoidTypeNode node)
    {
        if (node == null)
            return null;
        final VoidTypeNode ret;
        if (this.proxyCache.containsKey(node.getUid()))
        {
            ret = (VoidTypeNode)this.proxyCache.get(node.getUid());
        } else
        {
            ret = (VoidTypeNode)(node.executeOperation(WRAPPER, null));
            this.proxyCache.put(node.getUid(), ret);
            this.proxyIdMap.put(ret.getUid(), node.getUid());
        }
        return ret;
    }
    
    public WhileLoopNode makeWhileLoopNode(WhileLoopNode node)
    {
        if (node == null)
            return null;
        final WhileLoopNode ret;
        if (this.proxyCache.containsKey(node.getUid()))
        {
            ret = (WhileLoopNode)this.proxyCache.get(node.getUid());
        } else
        {
            ret = (WhileLoopNode)(node.executeOperation(WRAPPER, null));
            this.proxyCache.put(node.getUid(), ret);
            this.proxyIdMap.put(ret.getUid(), node.getUid());
        }
        return ret;
    }
    
    public WildcardTypeNode makeWildcardTypeNode(WildcardTypeNode node)
    {
        if (node == null)
            return null;
        final WildcardTypeNode ret;
        if (this.proxyCache.containsKey(node.getUid()))
        {
            ret = (WildcardTypeNode)this.proxyCache.get(node.getUid());
        } else
        {
            ret = (WildcardTypeNode)(node.executeOperation(WRAPPER, null));
            this.proxyCache.put(node.getUid(), ret);
            this.proxyIdMap.put(ret.getUid(), node.getUid());
        }
        return ret;
    }
    
}
