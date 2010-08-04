package edu.jhu.cs.bsj.compiler.ast;

import java.util.List;

import javax.annotation.Generated;

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
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaAnnotationNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaAnnotationValueListNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaAnnotationValueNode;
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
 * This interface is implemented by any object which can act as a factory for BSJ nodes. It is strongly advisable to
 * ensure that all nodes in a given AST are produced from the same factory, although the urgency of this restriction is
 * implementation-dependent.
 * 
 * @author Zachary Palmer
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface BsjNodeFactory
{
	/**
	 * Retrieves the starting source location used for new nodes.
	 * 
	 * @return The start location used for new nodes. <code>null</code> is a permissible value and indicates that no
	 *         information is available.
	 */
	public BsjSourceLocation getStartSourceLocation();

	/**
	 * Retrieves the ending source location used for new nodes.
	 * 
	 * @return The stop location used for new nodes. <code>null</code> is a permissible value and indicates that no
	 *         information is available.
	 */
	public BsjSourceLocation getStopSourceLocation();

	/**
	 * Changes the starting source location used for new nodes.
	 * 
	 * @param startLocation The new start location to use for new nodes. <code>null</code> is a permissible value and
	 *            indicates that no information is available.
	 */
	public void setStartSourceLocation(BsjSourceLocation startLocation);

	/**
	 * Changes the ending source location used for new nodes.
	 * 
	 * @param stopLocation The new stop location to use for new nodes. <code>null</code> is a permissible value and
	 *            indicates that no information is available.
	 */
	public void setStopSourceLocation(BsjSourceLocation stopLocation);

	/**
	 * Determines whether or not the nodes generated by this factory are marked as "binary" nodes. Nodes are marked as
	 * such to indicate that they originated from precompiled binary files. Binary nodes may not have some information
	 * associated with them; for instance, the bodies of methods on binary nodes are <code>null</code>. This method
	 * typically should not be called except by the BSJ compiler.
	 * 
	 * @return <code>true</code> if the nodes generated by this factory are binary nodes; <code>false</code> otherwise.
	 */
	public boolean getBinary();

	/**
	 * Changes whether or not the nodes generated by this factory are marked as "binary" nodes. This method typically
	 * should not be called except by the BSJ compiler.
	 * 
	 * @param binary <code>true</code> if the nodes generated by this factory are binary nodes; <code>false</code> otherwise.
	 * @see #getBinary()
	 */
	public void setBinary(boolean binary);

	// MANUALLY SPECIFIED MAKE METHODS ///////////////////////////////////////

	/**
	 * Creates a {@link SingleStaticImportNode}. The provided name is interpreted as the full name of the import; that
	 * is, the name "<tt>java.utils.Arrays.asList</tt>" would be used to create an import for that method by splitting
	 * the name between its type and final identifier. The default start and stop location are used.
	 */
	public SingleStaticImportNode makeSingleStaticImportNode(QualifiedNameNode name);

	/**
	 * Creates a {@link SingleStaticImportNode}. The provided name is interpreted as the full name of the import; that
	 * is, the name "<tt>java.utils.Arrays.asList</tt>" would be used to create an import for that method by splitting
	 * the name between its type and final identifier. The specified start and stop locations are used.
	 */
	public SingleStaticImportNode makeSingleStaticImportNode(QualifiedNameNode name, BsjSourceLocation startLocation,
			BsjSourceLocation stopLocation);
	
	/**
	 * Creates a {@link NameNode} based on the specified name string.
	 * @param name The name argument from which to create a node.
	 * @return The name node which was created.
	 * @throws IllegalArgumentException If the provided string was not a valid name.
	 */
	public NameNode parseNameNode(String name);
	
	/**
	 * Creates an {@link ArrayTypeNode} based on the specified type and the given number of array levels.
	 * @param type The base type to use.
	 * @param levels The number of levels of depth to apply.  Must be at least 1.
	 * @return The resulting array type.
	 * @throws IllegalArgumentException If the provided level count is non-positive.
	 */
	public ArrayTypeNode wrapArrayLevels(TypeNode type, int levels);
    /**
     * Creates a AlternateConstructorInvocationNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public AlternateConstructorInvocationNode makeAlternateConstructorInvocationNode(
            ExpressionListNode arguments,
            ReferenceTypeListNode typeArguments);
    
    /**
     * Creates a AlternateConstructorInvocationNode.
     * The specified start and stop locations are used.
     */
    public AlternateConstructorInvocationNode makeAlternateConstructorInvocationNode(
            ExpressionListNode arguments,
            ReferenceTypeListNode typeArguments,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);
    
    /**
     * Creates a AlternateConstructorInvocationNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public AlternateConstructorInvocationNode makeAlternateConstructorInvocationNode(
            ExpressionListNode arguments);
    
    /**
     * Creates a AlternateConstructorInvocationNode.
     * The specified start and stop locations are used.
     */
    public AlternateConstructorInvocationNode makeAlternateConstructorInvocationNode(
            ExpressionListNode arguments,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);
    
    /**
     * Creates a AnnotationAnnotationValueNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public AnnotationAnnotationValueNode makeAnnotationAnnotationValueNode(
            AnnotationNode annotation);
    
    /**
     * Creates a AnnotationAnnotationValueNode.
     * The specified start and stop locations are used.
     */
    public AnnotationAnnotationValueNode makeAnnotationAnnotationValueNode(
            AnnotationNode annotation,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);
    
    /**
     * Creates a AnnotationArrayValueNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public AnnotationArrayValueNode makeAnnotationArrayValueNode(
            AnnotationValueListNode values);
    
    /**
     * Creates a AnnotationArrayValueNode.
     * The specified start and stop locations are used.
     */
    public AnnotationArrayValueNode makeAnnotationArrayValueNode(
            AnnotationValueListNode values,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);
    
    /**
     * Creates a AnnotationBodyNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public AnnotationBodyNode makeAnnotationBodyNode(
            AnnotationMemberListNode members);
    
    /**
     * Creates a AnnotationBodyNode.
     * The specified start and stop locations are used.
     */
    public AnnotationBodyNode makeAnnotationBodyNode(
            AnnotationMemberListNode members,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);
    
    /**
     * Creates a AnnotationDeclarationNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public AnnotationDeclarationNode makeAnnotationDeclarationNode(
            AnnotationModifiersNode modifiers,
            AnnotationBodyNode body,
            IdentifierNode identifier,
            JavadocNode javadoc);
    
    /**
     * Creates a AnnotationDeclarationNode.
     * The specified start and stop locations are used.
     */
    public AnnotationDeclarationNode makeAnnotationDeclarationNode(
            AnnotationModifiersNode modifiers,
            AnnotationBodyNode body,
            IdentifierNode identifier,
            JavadocNode javadoc,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);
    
    /**
     * Creates a AnnotationElementListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public AnnotationElementListNode makeAnnotationElementListNode(
            List<AnnotationElementNode> children);
    
    /**
     * Creates a AnnotationElementListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public AnnotationElementListNode makeAnnotationElementListNode(
            AnnotationElementNode... childrenElements);
    
    /**
     * Creates a AnnotationElementListNode.
     * The specified start and stop locations are used.
     */
    public AnnotationElementListNode makeAnnotationElementListNode(
            List<AnnotationElementNode> children,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);
    
    /**
     * Creates a AnnotationElementListNode.
     * The specified start and stop locations are used.
     */
    public AnnotationElementListNode makeAnnotationElementListNode(
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation,
            AnnotationElementNode... childrenElements);
    
    /**
     * Creates a AnnotationElementNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public AnnotationElementNode makeAnnotationElementNode(
            IdentifierNode identifier,
            AnnotationValueNode value);
    
    /**
     * Creates a AnnotationElementNode.
     * The specified start and stop locations are used.
     */
    public AnnotationElementNode makeAnnotationElementNode(
            IdentifierNode identifier,
            AnnotationValueNode value,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);
    
    /**
     * Creates a AnnotationExpressionValueNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public AnnotationExpressionValueNode makeAnnotationExpressionValueNode(
            NonAssignmentExpressionNode expression);
    
    /**
     * Creates a AnnotationExpressionValueNode.
     * The specified start and stop locations are used.
     */
    public AnnotationExpressionValueNode makeAnnotationExpressionValueNode(
            NonAssignmentExpressionNode expression,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);
    
    /**
     * Creates a AnnotationListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public AnnotationListNode makeAnnotationListNode(
            List<AnnotationNode> children);
    
    /**
     * Creates a AnnotationListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public AnnotationListNode makeAnnotationListNode(
            AnnotationNode... childrenElements);
    
    /**
     * Creates a AnnotationListNode.
     * The specified start and stop locations are used.
     */
    public AnnotationListNode makeAnnotationListNode(
            List<AnnotationNode> children,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);
    
    /**
     * Creates a AnnotationListNode.
     * The specified start and stop locations are used.
     */
    public AnnotationListNode makeAnnotationListNode(
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation,
            AnnotationNode... childrenElements);
    
    /**
     * Creates a AnnotationMemberListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public AnnotationMemberListNode makeAnnotationMemberListNode(
            List<AnnotationMemberNode> children);
    
    /**
     * Creates a AnnotationMemberListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public AnnotationMemberListNode makeAnnotationMemberListNode(
            AnnotationMemberNode... childrenElements);
    
    /**
     * Creates a AnnotationMemberListNode.
     * The specified start and stop locations are used.
     */
    public AnnotationMemberListNode makeAnnotationMemberListNode(
            List<AnnotationMemberNode> children,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);
    
    /**
     * Creates a AnnotationMemberListNode.
     * The specified start and stop locations are used.
     */
    public AnnotationMemberListNode makeAnnotationMemberListNode(
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation,
            AnnotationMemberNode... childrenElements);
    
    /**
     * Creates a AnnotationMemberMetaprogramAnchorNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public AnnotationMemberMetaprogramAnchorNode makeAnnotationMemberMetaprogramAnchorNode(
            MetaprogramNode metaprogram);
    
    /**
     * Creates a AnnotationMemberMetaprogramAnchorNode.
     * The specified start and stop locations are used.
     */
    public AnnotationMemberMetaprogramAnchorNode makeAnnotationMemberMetaprogramAnchorNode(
            MetaprogramNode metaprogram,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);
    
    /**
     * Creates a AnnotationMethodDeclarationNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public AnnotationMethodDeclarationNode makeAnnotationMethodDeclarationNode(
            AnnotationMethodModifiersNode modifiers,
            TypeNode type,
            IdentifierNode identifier,
            AnnotationValueNode defaultValue,
            JavadocNode javadoc);
    
    /**
     * Creates a AnnotationMethodDeclarationNode.
     * The specified start and stop locations are used.
     */
    public AnnotationMethodDeclarationNode makeAnnotationMethodDeclarationNode(
            AnnotationMethodModifiersNode modifiers,
            TypeNode type,
            IdentifierNode identifier,
            AnnotationValueNode defaultValue,
            JavadocNode javadoc,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);
    
    /**
     * Creates a AnnotationMethodModifiersNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public AnnotationMethodModifiersNode makeAnnotationMethodModifiersNode(
            MetaAnnotationListNode metaAnnotations,
            AnnotationListNode annotations);
    
    /**
     * Creates a AnnotationMethodModifiersNode.
     * The specified start and stop locations are used.
     */
    public AnnotationMethodModifiersNode makeAnnotationMethodModifiersNode(
            MetaAnnotationListNode metaAnnotations,
            AnnotationListNode annotations,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);
    
    /**
     * Creates a AnnotationModifiersNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public AnnotationModifiersNode makeAnnotationModifiersNode(
            AccessModifier access,
            boolean staticFlag,
            boolean strictfpFlag,
            MetaAnnotationListNode metaAnnotations,
            AnnotationListNode annotations);
    
    /**
     * Creates a AnnotationModifiersNode.
     * The specified start and stop locations are used.
     */
    public AnnotationModifiersNode makeAnnotationModifiersNode(
            AccessModifier access,
            boolean staticFlag,
            boolean strictfpFlag,
            MetaAnnotationListNode metaAnnotations,
            AnnotationListNode annotations,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);
    
    /**
     * Creates a AnnotationModifiersNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public AnnotationModifiersNode makeAnnotationModifiersNode(
            AccessModifier access);
    
    /**
     * Creates a AnnotationModifiersNode.
     * The specified start and stop locations are used.
     */
    public AnnotationModifiersNode makeAnnotationModifiersNode(
            AccessModifier access,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);
    
    /**
     * Creates a AnnotationValueListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public AnnotationValueListNode makeAnnotationValueListNode(
            List<AnnotationValueNode> children);
    
    /**
     * Creates a AnnotationValueListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public AnnotationValueListNode makeAnnotationValueListNode(
            AnnotationValueNode... childrenElements);
    
    /**
     * Creates a AnnotationValueListNode.
     * The specified start and stop locations are used.
     */
    public AnnotationValueListNode makeAnnotationValueListNode(
            List<AnnotationValueNode> children,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);
    
    /**
     * Creates a AnnotationValueListNode.
     * The specified start and stop locations are used.
     */
    public AnnotationValueListNode makeAnnotationValueListNode(
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation,
            AnnotationValueNode... childrenElements);
    
    /**
     * Creates a AnonymousClassBodyNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public AnonymousClassBodyNode makeAnonymousClassBodyNode(
            AnonymousClassMemberListNode members);
    
    /**
     * Creates a AnonymousClassBodyNode.
     * The specified start and stop locations are used.
     */
    public AnonymousClassBodyNode makeAnonymousClassBodyNode(
            AnonymousClassMemberListNode members,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);
    
    /**
     * Creates a AnonymousClassMemberListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public AnonymousClassMemberListNode makeAnonymousClassMemberListNode(
            List<AnonymousClassMemberNode> children);
    
    /**
     * Creates a AnonymousClassMemberListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public AnonymousClassMemberListNode makeAnonymousClassMemberListNode(
            AnonymousClassMemberNode... childrenElements);
    
    /**
     * Creates a AnonymousClassMemberListNode.
     * The specified start and stop locations are used.
     */
    public AnonymousClassMemberListNode makeAnonymousClassMemberListNode(
            List<AnonymousClassMemberNode> children,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);
    
    /**
     * Creates a AnonymousClassMemberListNode.
     * The specified start and stop locations are used.
     */
    public AnonymousClassMemberListNode makeAnonymousClassMemberListNode(
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation,
            AnonymousClassMemberNode... childrenElements);
    
    /**
     * Creates a AnonymousClassMemberMetaprogramAnchorNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public AnonymousClassMemberMetaprogramAnchorNode makeAnonymousClassMemberMetaprogramAnchorNode(
            MetaprogramNode metaprogram);
    
    /**
     * Creates a AnonymousClassMemberMetaprogramAnchorNode.
     * The specified start and stop locations are used.
     */
    public AnonymousClassMemberMetaprogramAnchorNode makeAnonymousClassMemberMetaprogramAnchorNode(
            MetaprogramNode metaprogram,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);
    
    /**
     * Creates a ArrayAccessNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public ArrayAccessNode makeArrayAccessNode(
            RestrictedPrimaryExpressionNode arrayExpression,
            ExpressionNode indexExpression);
    
    /**
     * Creates a ArrayAccessNode.
     * The specified start and stop locations are used.
     */
    public ArrayAccessNode makeArrayAccessNode(
            RestrictedPrimaryExpressionNode arrayExpression,
            ExpressionNode indexExpression,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);
    
    /**
     * Creates a ArrayInitializerCreationNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public ArrayInitializerCreationNode makeArrayInitializerCreationNode(
            ArrayInitializerNode initializer,
            BaseTypeNode baseType,
            int arrayLevels);
    
    /**
     * Creates a ArrayInitializerCreationNode.
     * The specified start and stop locations are used.
     */
    public ArrayInitializerCreationNode makeArrayInitializerCreationNode(
            ArrayInitializerNode initializer,
            BaseTypeNode baseType,
            int arrayLevels,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);
    
    /**
     * Creates a ArrayInitializerNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public ArrayInitializerNode makeArrayInitializerNode(
            VariableInitializerListNode initializers);
    
    /**
     * Creates a ArrayInitializerNode.
     * The specified start and stop locations are used.
     */
    public ArrayInitializerNode makeArrayInitializerNode(
            VariableInitializerListNode initializers,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);
    
    /**
     * Creates a ArrayInstantiatorCreationNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public ArrayInstantiatorCreationNode makeArrayInstantiatorCreationNode(
            ExpressionListNode dimExpressions,
            BaseTypeNode baseType,
            int arrayLevels);
    
    /**
     * Creates a ArrayInstantiatorCreationNode.
     * The specified start and stop locations are used.
     */
    public ArrayInstantiatorCreationNode makeArrayInstantiatorCreationNode(
            ExpressionListNode dimExpressions,
            BaseTypeNode baseType,
            int arrayLevels,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);
    
    /**
     * Creates a ArrayTypeNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public ArrayTypeNode makeArrayTypeNode(
            TypeNode type);
    
    /**
     * Creates a ArrayTypeNode.
     * The specified start and stop locations are used.
     */
    public ArrayTypeNode makeArrayTypeNode(
            TypeNode type,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);
    
    /**
     * Creates a AssertStatementNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public AssertStatementNode makeAssertStatementNode(
            ExpressionNode testExpression,
            ExpressionNode messageExpression,
            MetaAnnotationListNode metaAnnotations);
    
    /**
     * Creates a AssertStatementNode.
     * The specified start and stop locations are used.
     */
    public AssertStatementNode makeAssertStatementNode(
            ExpressionNode testExpression,
            ExpressionNode messageExpression,
            MetaAnnotationListNode metaAnnotations,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);
    
    /**
     * Creates a AssertStatementNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public AssertStatementNode makeAssertStatementNode(
            ExpressionNode testExpression);
    
    /**
     * Creates a AssertStatementNode.
     * The specified start and stop locations are used.
     */
    public AssertStatementNode makeAssertStatementNode(
            ExpressionNode testExpression,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);
    
    /**
     * Creates a AssertStatementNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public AssertStatementNode makeAssertStatementNode(
            ExpressionNode testExpression,
            ExpressionNode messageExpression);
    
    /**
     * Creates a AssertStatementNode.
     * The specified start and stop locations are used.
     */
    public AssertStatementNode makeAssertStatementNode(
            ExpressionNode testExpression,
            ExpressionNode messageExpression,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);
    
    /**
     * Creates a AssignmentNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public AssignmentNode makeAssignmentNode(
            ExpressionNode variable,
            AssignmentOperator operator,
            ExpressionNode expression);
    
    /**
     * Creates a AssignmentNode.
     * The specified start and stop locations are used.
     */
    public AssignmentNode makeAssignmentNode(
            ExpressionNode variable,
            AssignmentOperator operator,
            ExpressionNode expression,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);
    
    /**
     * Creates a BinaryExpressionNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public BinaryExpressionNode makeBinaryExpressionNode(
            ExpressionNode leftOperand,
            ExpressionNode rightOperand,
            BinaryOperator operator);
    
    /**
     * Creates a BinaryExpressionNode.
     * The specified start and stop locations are used.
     */
    public BinaryExpressionNode makeBinaryExpressionNode(
            ExpressionNode leftOperand,
            ExpressionNode rightOperand,
            BinaryOperator operator,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);
    
    /**
     * Creates a BlockNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public BlockNode makeBlockNode(
            BlockStatementListNode statements,
            MetaAnnotationListNode metaAnnotations);
    
    /**
     * Creates a BlockNode.
     * The specified start and stop locations are used.
     */
    public BlockNode makeBlockNode(
            BlockStatementListNode statements,
            MetaAnnotationListNode metaAnnotations,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);
    
    /**
     * Creates a BlockNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public BlockNode makeBlockNode(
            BlockStatementListNode statements);
    
    /**
     * Creates a BlockNode.
     * The specified start and stop locations are used.
     */
    public BlockNode makeBlockNode(
            BlockStatementListNode statements,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);
    
    /**
     * Creates a BlockStatementListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public BlockStatementListNode makeBlockStatementListNode(
            List<BlockStatementNode> children);
    
    /**
     * Creates a BlockStatementListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public BlockStatementListNode makeBlockStatementListNode(
            BlockStatementNode... childrenElements);
    
    /**
     * Creates a BlockStatementListNode.
     * The specified start and stop locations are used.
     */
    public BlockStatementListNode makeBlockStatementListNode(
            List<BlockStatementNode> children,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);
    
    /**
     * Creates a BlockStatementListNode.
     * The specified start and stop locations are used.
     */
    public BlockStatementListNode makeBlockStatementListNode(
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation,
            BlockStatementNode... childrenElements);
    
    /**
     * Creates a BlockStatementMetaprogramAnchorNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public BlockStatementMetaprogramAnchorNode makeBlockStatementMetaprogramAnchorNode(
            MetaprogramNode metaprogram);
    
    /**
     * Creates a BlockStatementMetaprogramAnchorNode.
     * The specified start and stop locations are used.
     */
    public BlockStatementMetaprogramAnchorNode makeBlockStatementMetaprogramAnchorNode(
            MetaprogramNode metaprogram,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);
    
    /**
     * Creates a BooleanLiteralNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public BooleanLiteralNode makeBooleanLiteralNode(
            Boolean value);
    
    /**
     * Creates a BooleanLiteralNode.
     * The specified start and stop locations are used.
     */
    public BooleanLiteralNode makeBooleanLiteralNode(
            Boolean value,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);
    
    /**
     * Creates a BreakNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public BreakNode makeBreakNode(
            IdentifierNode label,
            MetaAnnotationListNode metaAnnotations);
    
    /**
     * Creates a BreakNode.
     * The specified start and stop locations are used.
     */
    public BreakNode makeBreakNode(
            IdentifierNode label,
            MetaAnnotationListNode metaAnnotations,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);
    
    /**
     * Creates a BreakNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public BreakNode makeBreakNode();
    
    /**
     * Creates a BreakNode.
     * The specified start and stop locations are used.
     */
    public BreakNode makeBreakNode(
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);
    
    /**
     * Creates a BreakNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public BreakNode makeBreakNode(
            IdentifierNode label);
    
    /**
     * Creates a BreakNode.
     * The specified start and stop locations are used.
     */
    public BreakNode makeBreakNode(
            IdentifierNode label,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);
    
    /**
     * Creates a CaseListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public CaseListNode makeCaseListNode(
            List<CaseNode> children);
    
    /**
     * Creates a CaseListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public CaseListNode makeCaseListNode(
            CaseNode... childrenElements);
    
    /**
     * Creates a CaseListNode.
     * The specified start and stop locations are used.
     */
    public CaseListNode makeCaseListNode(
            List<CaseNode> children,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);
    
    /**
     * Creates a CaseListNode.
     * The specified start and stop locations are used.
     */
    public CaseListNode makeCaseListNode(
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation,
            CaseNode... childrenElements);
    
    /**
     * Creates a CaseNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public CaseNode makeCaseNode(
            ExpressionNode expression,
            BlockStatementListNode statements);
    
    /**
     * Creates a CaseNode.
     * The specified start and stop locations are used.
     */
    public CaseNode makeCaseNode(
            ExpressionNode expression,
            BlockStatementListNode statements,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);
    
    /**
     * Creates a CatchListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public CatchListNode makeCatchListNode(
            List<CatchNode> children);
    
    /**
     * Creates a CatchListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public CatchListNode makeCatchListNode(
            CatchNode... childrenElements);
    
    /**
     * Creates a CatchListNode.
     * The specified start and stop locations are used.
     */
    public CatchListNode makeCatchListNode(
            List<CatchNode> children,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);
    
    /**
     * Creates a CatchListNode.
     * The specified start and stop locations are used.
     */
    public CatchListNode makeCatchListNode(
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation,
            CatchNode... childrenElements);
    
    /**
     * Creates a CatchNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public CatchNode makeCatchNode(
            BlockStatementListNode body,
            VariableNode parameter);
    
    /**
     * Creates a CatchNode.
     * The specified start and stop locations are used.
     */
    public CatchNode makeCatchNode(
            BlockStatementListNode body,
            VariableNode parameter,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);
    
    /**
     * Creates a CharLiteralNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public CharLiteralNode makeCharLiteralNode(
            Character value);
    
    /**
     * Creates a CharLiteralNode.
     * The specified start and stop locations are used.
     */
    public CharLiteralNode makeCharLiteralNode(
            Character value,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);
    
    /**
     * Creates a ClassBodyNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public ClassBodyNode makeClassBodyNode(
            ClassMemberListNode members);
    
    /**
     * Creates a ClassBodyNode.
     * The specified start and stop locations are used.
     */
    public ClassBodyNode makeClassBodyNode(
            ClassMemberListNode members,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);
    
    /**
     * Creates a ClassDeclarationNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public ClassDeclarationNode makeClassDeclarationNode(
            ClassModifiersNode modifiers,
            DeclaredTypeNode extendsClause,
            DeclaredTypeListNode implementsClause,
            ClassBodyNode body,
            TypeParameterListNode typeParameters,
            IdentifierNode identifier,
            JavadocNode javadoc);
    
    /**
     * Creates a ClassDeclarationNode.
     * The specified start and stop locations are used.
     */
    public ClassDeclarationNode makeClassDeclarationNode(
            ClassModifiersNode modifiers,
            DeclaredTypeNode extendsClause,
            DeclaredTypeListNode implementsClause,
            ClassBodyNode body,
            TypeParameterListNode typeParameters,
            IdentifierNode identifier,
            JavadocNode javadoc,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);
    
    /**
     * Creates a ClassLiteralNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public ClassLiteralNode makeClassLiteralNode(
            LiteralizableTypeNode value);
    
    /**
     * Creates a ClassLiteralNode.
     * The specified start and stop locations are used.
     */
    public ClassLiteralNode makeClassLiteralNode(
            LiteralizableTypeNode value,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);
    
    /**
     * Creates a ClassMemberListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public ClassMemberListNode makeClassMemberListNode(
            List<ClassMemberNode> children);
    
    /**
     * Creates a ClassMemberListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public ClassMemberListNode makeClassMemberListNode(
            ClassMemberNode... childrenElements);
    
    /**
     * Creates a ClassMemberListNode.
     * The specified start and stop locations are used.
     */
    public ClassMemberListNode makeClassMemberListNode(
            List<ClassMemberNode> children,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);
    
    /**
     * Creates a ClassMemberListNode.
     * The specified start and stop locations are used.
     */
    public ClassMemberListNode makeClassMemberListNode(
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation,
            ClassMemberNode... childrenElements);
    
    /**
     * Creates a ClassMemberMetaprogramAnchorNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public ClassMemberMetaprogramAnchorNode makeClassMemberMetaprogramAnchorNode(
            MetaprogramNode metaprogram);
    
    /**
     * Creates a ClassMemberMetaprogramAnchorNode.
     * The specified start and stop locations are used.
     */
    public ClassMemberMetaprogramAnchorNode makeClassMemberMetaprogramAnchorNode(
            MetaprogramNode metaprogram,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);
    
    /**
     * Creates a ClassModifiersNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public ClassModifiersNode makeClassModifiersNode(
            AccessModifier access,
            boolean abstractFlag,
            boolean staticFlag,
            boolean finalFlag,
            boolean strictfpFlag,
            MetaAnnotationListNode metaAnnotations,
            AnnotationListNode annotations);
    
    /**
     * Creates a ClassModifiersNode.
     * The specified start and stop locations are used.
     */
    public ClassModifiersNode makeClassModifiersNode(
            AccessModifier access,
            boolean abstractFlag,
            boolean staticFlag,
            boolean finalFlag,
            boolean strictfpFlag,
            MetaAnnotationListNode metaAnnotations,
            AnnotationListNode annotations,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);
    
    /**
     * Creates a ClassModifiersNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public ClassModifiersNode makeClassModifiersNode(
            AccessModifier access);
    
    /**
     * Creates a ClassModifiersNode.
     * The specified start and stop locations are used.
     */
    public ClassModifiersNode makeClassModifiersNode(
            AccessModifier access,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);
    
    /**
     * Creates a CodeLiteralNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public CodeLiteralNode makeCodeLiteralNode(
            Node value);
    
    /**
     * Creates a CodeLiteralNode.
     * The specified start and stop locations are used.
     */
    public CodeLiteralNode makeCodeLiteralNode(
            Node value,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);
    
    /**
     * Creates a CompilationUnitNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public CompilationUnitNode makeCompilationUnitNode(
            String name,
            PackageDeclarationNode packageDeclaration,
            MetaprogramImportListNode metaimports,
            ImportListNode imports,
            TypeDeclarationListNode typeDecls);
    
    /**
     * Creates a CompilationUnitNode.
     * The specified start and stop locations are used.
     */
    public CompilationUnitNode makeCompilationUnitNode(
            String name,
            PackageDeclarationNode packageDeclaration,
            MetaprogramImportListNode metaimports,
            ImportListNode imports,
            TypeDeclarationListNode typeDecls,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);
    
    /**
     * Creates a CompilationUnitNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public CompilationUnitNode makeCompilationUnitNode(
            String name,
            PackageDeclarationNode packageDeclaration,
            ImportListNode imports,
            TypeDeclarationListNode typeDecls);
    
    /**
     * Creates a CompilationUnitNode.
     * The specified start and stop locations are used.
     */
    public CompilationUnitNode makeCompilationUnitNode(
            String name,
            PackageDeclarationNode packageDeclaration,
            ImportListNode imports,
            TypeDeclarationListNode typeDecls,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);
    
    /**
     * Creates a ConditionalExpressionNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public ConditionalExpressionNode makeConditionalExpressionNode(
            ExpressionNode condition,
            ExpressionNode trueExpression,
            ExpressionNode falseExpression);
    
    /**
     * Creates a ConditionalExpressionNode.
     * The specified start and stop locations are used.
     */
    public ConditionalExpressionNode makeConditionalExpressionNode(
            ExpressionNode condition,
            ExpressionNode trueExpression,
            ExpressionNode falseExpression,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);
    
    /**
     * Creates a ConstantDeclarationNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public ConstantDeclarationNode makeConstantDeclarationNode(
            ConstantModifiersNode modifiers,
            TypeNode type,
            VariableDeclaratorListNode declarators,
            JavadocNode javadoc);
    
    /**
     * Creates a ConstantDeclarationNode.
     * The specified start and stop locations are used.
     */
    public ConstantDeclarationNode makeConstantDeclarationNode(
            ConstantModifiersNode modifiers,
            TypeNode type,
            VariableDeclaratorListNode declarators,
            JavadocNode javadoc,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);
    
    /**
     * Creates a ConstantModifiersNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public ConstantModifiersNode makeConstantModifiersNode(
            MetaAnnotationListNode metaAnnotations,
            AnnotationListNode annotations);
    
    /**
     * Creates a ConstantModifiersNode.
     * The specified start and stop locations are used.
     */
    public ConstantModifiersNode makeConstantModifiersNode(
            MetaAnnotationListNode metaAnnotations,
            AnnotationListNode annotations,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);
    
    /**
     * Creates a ConstantModifiersNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public ConstantModifiersNode makeConstantModifiersNode(
    );
    
    /**
     * Creates a ConstantModifiersNode.
     * The specified start and stop locations are used.
     */
    public ConstantModifiersNode makeConstantModifiersNode(
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);
    
    /**
     * Creates a ConstructorBodyNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public ConstructorBodyNode makeConstructorBodyNode(
            ConstructorInvocationNode constructorInvocation,
            BlockStatementListNode statements);
    
    /**
     * Creates a ConstructorBodyNode.
     * The specified start and stop locations are used.
     */
    public ConstructorBodyNode makeConstructorBodyNode(
            ConstructorInvocationNode constructorInvocation,
            BlockStatementListNode statements,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);
    
    /**
     * Creates a ConstructorDeclarationNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public ConstructorDeclarationNode makeConstructorDeclarationNode(
            IdentifierNode identifier,
            ConstructorBodyNode body,
            ConstructorModifiersNode modifiers,
            VariableListNode parameters,
            VariableNode varargParameter,
            UnparameterizedTypeListNode throwTypes,
            TypeParameterListNode typeParameters,
            JavadocNode javadoc);
    
    /**
     * Creates a ConstructorDeclarationNode.
     * The specified start and stop locations are used.
     */
    public ConstructorDeclarationNode makeConstructorDeclarationNode(
            IdentifierNode identifier,
            ConstructorBodyNode body,
            ConstructorModifiersNode modifiers,
            VariableListNode parameters,
            VariableNode varargParameter,
            UnparameterizedTypeListNode throwTypes,
            TypeParameterListNode typeParameters,
            JavadocNode javadoc,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);
    
    /**
     * Creates a ConstructorDeclarationNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public ConstructorDeclarationNode makeConstructorDeclarationNode(
            IdentifierNode identifier,
            ConstructorBodyNode body,
            ConstructorModifiersNode modifiers,
            VariableListNode parameters,
            JavadocNode javadoc);
    
    /**
     * Creates a ConstructorDeclarationNode.
     * The specified start and stop locations are used.
     */
    public ConstructorDeclarationNode makeConstructorDeclarationNode(
            IdentifierNode identifier,
            ConstructorBodyNode body,
            ConstructorModifiersNode modifiers,
            VariableListNode parameters,
            JavadocNode javadoc,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);
    
    /**
     * Creates a ConstructorModifiersNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public ConstructorModifiersNode makeConstructorModifiersNode(
            AccessModifier access,
            MetaAnnotationListNode metaAnnotations,
            AnnotationListNode annotations);
    
    /**
     * Creates a ConstructorModifiersNode.
     * The specified start and stop locations are used.
     */
    public ConstructorModifiersNode makeConstructorModifiersNode(
            AccessModifier access,
            MetaAnnotationListNode metaAnnotations,
            AnnotationListNode annotations,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);
    
    /**
     * Creates a ConstructorModifiersNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public ConstructorModifiersNode makeConstructorModifiersNode(
            AccessModifier access);
    
    /**
     * Creates a ConstructorModifiersNode.
     * The specified start and stop locations are used.
     */
    public ConstructorModifiersNode makeConstructorModifiersNode(
            AccessModifier access,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);
    
    /**
     * Creates a ContinueNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public ContinueNode makeContinueNode(
            IdentifierNode label,
            MetaAnnotationListNode metaAnnotations);
    
    /**
     * Creates a ContinueNode.
     * The specified start and stop locations are used.
     */
    public ContinueNode makeContinueNode(
            IdentifierNode label,
            MetaAnnotationListNode metaAnnotations,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);
    
    /**
     * Creates a ContinueNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public ContinueNode makeContinueNode();
    
    /**
     * Creates a ContinueNode.
     * The specified start and stop locations are used.
     */
    public ContinueNode makeContinueNode(
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);
    
    /**
     * Creates a ContinueNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public ContinueNode makeContinueNode(
            IdentifierNode label);
    
    /**
     * Creates a ContinueNode.
     * The specified start and stop locations are used.
     */
    public ContinueNode makeContinueNode(
            IdentifierNode label,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);
    
    /**
     * Creates a DeclaredTypeListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public DeclaredTypeListNode makeDeclaredTypeListNode(
            List<DeclaredTypeNode> children);
    
    /**
     * Creates a DeclaredTypeListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public DeclaredTypeListNode makeDeclaredTypeListNode(
            DeclaredTypeNode... childrenElements);
    
    /**
     * Creates a DeclaredTypeListNode.
     * The specified start and stop locations are used.
     */
    public DeclaredTypeListNode makeDeclaredTypeListNode(
            List<DeclaredTypeNode> children,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);
    
    /**
     * Creates a DeclaredTypeListNode.
     * The specified start and stop locations are used.
     */
    public DeclaredTypeListNode makeDeclaredTypeListNode(
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation,
            DeclaredTypeNode... childrenElements);
    
    /**
     * Creates a DoWhileLoopNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public DoWhileLoopNode makeDoWhileLoopNode(
            ExpressionNode condition,
            StatementNode statement,
            MetaAnnotationListNode metaAnnotations);
    
    /**
     * Creates a DoWhileLoopNode.
     * The specified start and stop locations are used.
     */
    public DoWhileLoopNode makeDoWhileLoopNode(
            ExpressionNode condition,
            StatementNode statement,
            MetaAnnotationListNode metaAnnotations,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);
    
    /**
     * Creates a DoWhileLoopNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public DoWhileLoopNode makeDoWhileLoopNode(
            ExpressionNode condition,
            StatementNode statement);
    
    /**
     * Creates a DoWhileLoopNode.
     * The specified start and stop locations are used.
     */
    public DoWhileLoopNode makeDoWhileLoopNode(
            ExpressionNode condition,
            StatementNode statement,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);
    
    /**
     * Creates a DoubleLiteralNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public DoubleLiteralNode makeDoubleLiteralNode(
            Double value);
    
    /**
     * Creates a DoubleLiteralNode.
     * The specified start and stop locations are used.
     */
    public DoubleLiteralNode makeDoubleLiteralNode(
            Double value,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);
    
    /**
     * Creates a EnhancedForLoopNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public EnhancedForLoopNode makeEnhancedForLoopNode(
            VariableNode variable,
            ExpressionNode expression,
            StatementNode statement,
            MetaAnnotationListNode metaAnnotations);
    
    /**
     * Creates a EnhancedForLoopNode.
     * The specified start and stop locations are used.
     */
    public EnhancedForLoopNode makeEnhancedForLoopNode(
            VariableNode variable,
            ExpressionNode expression,
            StatementNode statement,
            MetaAnnotationListNode metaAnnotations,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);
    
    /**
     * Creates a EnhancedForLoopNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public EnhancedForLoopNode makeEnhancedForLoopNode(
            VariableNode variable,
            ExpressionNode expression,
            StatementNode statement);
    
    /**
     * Creates a EnhancedForLoopNode.
     * The specified start and stop locations are used.
     */
    public EnhancedForLoopNode makeEnhancedForLoopNode(
            VariableNode variable,
            ExpressionNode expression,
            StatementNode statement,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);
    
    /**
     * Creates a EnumBodyNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public EnumBodyNode makeEnumBodyNode(
            EnumConstantDeclarationListNode constants,
            ClassMemberListNode members);
    
    /**
     * Creates a EnumBodyNode.
     * The specified start and stop locations are used.
     */
    public EnumBodyNode makeEnumBodyNode(
            EnumConstantDeclarationListNode constants,
            ClassMemberListNode members,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);
    
    /**
     * Creates a EnumConstantDeclarationListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public EnumConstantDeclarationListNode makeEnumConstantDeclarationListNode(
            List<EnumConstantDeclarationNode> children);
    
    /**
     * Creates a EnumConstantDeclarationListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public EnumConstantDeclarationListNode makeEnumConstantDeclarationListNode(
            EnumConstantDeclarationNode... childrenElements);
    
    /**
     * Creates a EnumConstantDeclarationListNode.
     * The specified start and stop locations are used.
     */
    public EnumConstantDeclarationListNode makeEnumConstantDeclarationListNode(
            List<EnumConstantDeclarationNode> children,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);
    
    /**
     * Creates a EnumConstantDeclarationListNode.
     * The specified start and stop locations are used.
     */
    public EnumConstantDeclarationListNode makeEnumConstantDeclarationListNode(
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation,
            EnumConstantDeclarationNode... childrenElements);
    
    /**
     * Creates a EnumConstantDeclarationNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public EnumConstantDeclarationNode makeEnumConstantDeclarationNode(
            EnumConstantModifiersNode modifiers,
            IdentifierNode identifier,
            ExpressionListNode arguments,
            AnonymousClassBodyNode body,
            JavadocNode javadoc);
    
    /**
     * Creates a EnumConstantDeclarationNode.
     * The specified start and stop locations are used.
     */
    public EnumConstantDeclarationNode makeEnumConstantDeclarationNode(
            EnumConstantModifiersNode modifiers,
            IdentifierNode identifier,
            ExpressionListNode arguments,
            AnonymousClassBodyNode body,
            JavadocNode javadoc,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);
    
    /**
     * Creates a EnumConstantDeclarationNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public EnumConstantDeclarationNode makeEnumConstantDeclarationNode(
            EnumConstantModifiersNode modifiers,
            IdentifierNode identifier,
            ExpressionListNode arguments,
            JavadocNode javadoc);
    
    /**
     * Creates a EnumConstantDeclarationNode.
     * The specified start and stop locations are used.
     */
    public EnumConstantDeclarationNode makeEnumConstantDeclarationNode(
            EnumConstantModifiersNode modifiers,
            IdentifierNode identifier,
            ExpressionListNode arguments,
            JavadocNode javadoc,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);
    
    /**
     * Creates a EnumConstantModifiersNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public EnumConstantModifiersNode makeEnumConstantModifiersNode(
            MetaAnnotationListNode metaAnnotations,
            AnnotationListNode annotations);
    
    /**
     * Creates a EnumConstantModifiersNode.
     * The specified start and stop locations are used.
     */
    public EnumConstantModifiersNode makeEnumConstantModifiersNode(
            MetaAnnotationListNode metaAnnotations,
            AnnotationListNode annotations,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);
    
    /**
     * Creates a EnumConstantModifiersNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public EnumConstantModifiersNode makeEnumConstantModifiersNode(
    );
    
    /**
     * Creates a EnumConstantModifiersNode.
     * The specified start and stop locations are used.
     */
    public EnumConstantModifiersNode makeEnumConstantModifiersNode(
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);
    
    /**
     * Creates a EnumDeclarationNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public EnumDeclarationNode makeEnumDeclarationNode(
            EnumModifiersNode modifiers,
            DeclaredTypeListNode implementsClause,
            EnumBodyNode body,
            IdentifierNode identifier,
            JavadocNode javadoc);
    
    /**
     * Creates a EnumDeclarationNode.
     * The specified start and stop locations are used.
     */
    public EnumDeclarationNode makeEnumDeclarationNode(
            EnumModifiersNode modifiers,
            DeclaredTypeListNode implementsClause,
            EnumBodyNode body,
            IdentifierNode identifier,
            JavadocNode javadoc,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);
    
    /**
     * Creates a EnumModifiersNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public EnumModifiersNode makeEnumModifiersNode(
            AccessModifier access,
            boolean strictfpFlag,
            MetaAnnotationListNode metaAnnotations,
            AnnotationListNode annotations);
    
    /**
     * Creates a EnumModifiersNode.
     * The specified start and stop locations are used.
     */
    public EnumModifiersNode makeEnumModifiersNode(
            AccessModifier access,
            boolean strictfpFlag,
            MetaAnnotationListNode metaAnnotations,
            AnnotationListNode annotations,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);
    
    /**
     * Creates a EnumModifiersNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public EnumModifiersNode makeEnumModifiersNode(
            AccessModifier access);
    
    /**
     * Creates a EnumModifiersNode.
     * The specified start and stop locations are used.
     */
    public EnumModifiersNode makeEnumModifiersNode(
            AccessModifier access,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);
    
    /**
     * Creates a ExpressionListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public ExpressionListNode makeExpressionListNode(
            List<ExpressionNode> children);
    
    /**
     * Creates a ExpressionListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public ExpressionListNode makeExpressionListNode(
            ExpressionNode... childrenElements);
    
    /**
     * Creates a ExpressionListNode.
     * The specified start and stop locations are used.
     */
    public ExpressionListNode makeExpressionListNode(
            List<ExpressionNode> children,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);
    
    /**
     * Creates a ExpressionListNode.
     * The specified start and stop locations are used.
     */
    public ExpressionListNode makeExpressionListNode(
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation,
            ExpressionNode... childrenElements);
    
    /**
     * Creates a ExpressionStatementNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public ExpressionStatementNode makeExpressionStatementNode(
            StatementExpressionNode expression,
            MetaAnnotationListNode metaAnnotations);
    
    /**
     * Creates a ExpressionStatementNode.
     * The specified start and stop locations are used.
     */
    public ExpressionStatementNode makeExpressionStatementNode(
            StatementExpressionNode expression,
            MetaAnnotationListNode metaAnnotations,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);
    
    /**
     * Creates a ExpressionStatementNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public ExpressionStatementNode makeExpressionStatementNode(
            StatementExpressionNode expression);
    
    /**
     * Creates a ExpressionStatementNode.
     * The specified start and stop locations are used.
     */
    public ExpressionStatementNode makeExpressionStatementNode(
            StatementExpressionNode expression,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);
    
    /**
     * Creates a FieldDeclarationNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public FieldDeclarationNode makeFieldDeclarationNode(
            FieldModifiersNode modifiers,
            TypeNode type,
            VariableDeclaratorListNode declarators,
            JavadocNode javadoc);
    
    /**
     * Creates a FieldDeclarationNode.
     * The specified start and stop locations are used.
     */
    public FieldDeclarationNode makeFieldDeclarationNode(
            FieldModifiersNode modifiers,
            TypeNode type,
            VariableDeclaratorListNode declarators,
            JavadocNode javadoc,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);
    
    /**
     * Creates a FieldModifiersNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public FieldModifiersNode makeFieldModifiersNode(
            AccessModifier access,
            boolean staticFlag,
            boolean finalFlag,
            boolean transientFlag,
            boolean volatileFlag,
            MetaAnnotationListNode metaAnnotations,
            AnnotationListNode annotations);
    
    /**
     * Creates a FieldModifiersNode.
     * The specified start and stop locations are used.
     */
    public FieldModifiersNode makeFieldModifiersNode(
            AccessModifier access,
            boolean staticFlag,
            boolean finalFlag,
            boolean transientFlag,
            boolean volatileFlag,
            MetaAnnotationListNode metaAnnotations,
            AnnotationListNode annotations,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);
    
    /**
     * Creates a FieldModifiersNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public FieldModifiersNode makeFieldModifiersNode(
            AccessModifier access);
    
    /**
     * Creates a FieldModifiersNode.
     * The specified start and stop locations are used.
     */
    public FieldModifiersNode makeFieldModifiersNode(
            AccessModifier access,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);
    
    /**
     * Creates a FloatLiteralNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public FloatLiteralNode makeFloatLiteralNode(
            Float value);
    
    /**
     * Creates a FloatLiteralNode.
     * The specified start and stop locations are used.
     */
    public FloatLiteralNode makeFloatLiteralNode(
            Float value,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);
    
    /**
     * Creates a ForInitializerDeclarationNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public ForInitializerDeclarationNode makeForInitializerDeclarationNode(
            LocalVariableDeclarationNode declaration);
    
    /**
     * Creates a ForInitializerDeclarationNode.
     * The specified start and stop locations are used.
     */
    public ForInitializerDeclarationNode makeForInitializerDeclarationNode(
            LocalVariableDeclarationNode declaration,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);
    
    /**
     * Creates a ForInitializerExpressionNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public ForInitializerExpressionNode makeForInitializerExpressionNode(
            StatementExpressionListNode expressions);
    
    /**
     * Creates a ForInitializerExpressionNode.
     * The specified start and stop locations are used.
     */
    public ForInitializerExpressionNode makeForInitializerExpressionNode(
            StatementExpressionListNode expressions,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);
    
    /**
     * Creates a ForLoopNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public ForLoopNode makeForLoopNode(
            ForInitializerNode initializer,
            ExpressionNode condition,
            StatementExpressionListNode update,
            StatementNode statement,
            MetaAnnotationListNode metaAnnotations);
    
    /**
     * Creates a ForLoopNode.
     * The specified start and stop locations are used.
     */
    public ForLoopNode makeForLoopNode(
            ForInitializerNode initializer,
            ExpressionNode condition,
            StatementExpressionListNode update,
            StatementNode statement,
            MetaAnnotationListNode metaAnnotations,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);
    
    /**
     * Creates a ForLoopNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public ForLoopNode makeForLoopNode(
            ForInitializerNode initializer,
            ExpressionNode condition,
            StatementExpressionListNode update,
            StatementNode statement);
    
    /**
     * Creates a ForLoopNode.
     * The specified start and stop locations are used.
     */
    public ForLoopNode makeForLoopNode(
            ForInitializerNode initializer,
            ExpressionNode condition,
            StatementExpressionListNode update,
            StatementNode statement,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);
    
    /**
     * Creates a IdentifierListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public IdentifierListNode makeIdentifierListNode(
            List<IdentifierNode> children);
    
    /**
     * Creates a IdentifierListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public IdentifierListNode makeIdentifierListNode(
            IdentifierNode... childrenElements);
    
    /**
     * Creates a IdentifierListNode.
     * The specified start and stop locations are used.
     */
    public IdentifierListNode makeIdentifierListNode(
            List<IdentifierNode> children,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);
    
    /**
     * Creates a IdentifierListNode.
     * The specified start and stop locations are used.
     */
    public IdentifierListNode makeIdentifierListNode(
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation,
            IdentifierNode... childrenElements);
    
    /**
     * Creates a IdentifierNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public IdentifierNode makeIdentifierNode(
            String identifier);
    
    /**
     * Creates a IdentifierNode.
     * The specified start and stop locations are used.
     */
    public IdentifierNode makeIdentifierNode(
            String identifier,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);
    
    /**
     * Creates a IfNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public IfNode makeIfNode(
            ExpressionNode condition,
            StatementNode thenStatement,
            StatementNode elseStatement,
            MetaAnnotationListNode metaAnnotations);
    
    /**
     * Creates a IfNode.
     * The specified start and stop locations are used.
     */
    public IfNode makeIfNode(
            ExpressionNode condition,
            StatementNode thenStatement,
            StatementNode elseStatement,
            MetaAnnotationListNode metaAnnotations,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);
    
    /**
     * Creates a IfNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public IfNode makeIfNode(
            ExpressionNode condition,
            StatementNode thenStatement,
            StatementNode elseStatement);
    
    /**
     * Creates a IfNode.
     * The specified start and stop locations are used.
     */
    public IfNode makeIfNode(
            ExpressionNode condition,
            StatementNode thenStatement,
            StatementNode elseStatement,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);
    
    /**
     * Creates a IfNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public IfNode makeIfNode(
            ExpressionNode condition,
            StatementNode thenStatement);
    
    /**
     * Creates a IfNode.
     * The specified start and stop locations are used.
     */
    public IfNode makeIfNode(
            ExpressionNode condition,
            StatementNode thenStatement,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);
    
    /**
     * Creates a ImportListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public ImportListNode makeImportListNode(
            List<ImportNode> children);
    
    /**
     * Creates a ImportListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public ImportListNode makeImportListNode(
            ImportNode... childrenElements);
    
    /**
     * Creates a ImportListNode.
     * The specified start and stop locations are used.
     */
    public ImportListNode makeImportListNode(
            List<ImportNode> children,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);
    
    /**
     * Creates a ImportListNode.
     * The specified start and stop locations are used.
     */
    public ImportListNode makeImportListNode(
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation,
            ImportNode... childrenElements);
    
    /**
     * Creates a ImportOnDemandNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public ImportOnDemandNode makeImportOnDemandNode(
            NameNode name);
    
    /**
     * Creates a ImportOnDemandNode.
     * The specified start and stop locations are used.
     */
    public ImportOnDemandNode makeImportOnDemandNode(
            NameNode name,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);
    
    /**
     * Creates a ImportSingleTypeNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public ImportSingleTypeNode makeImportSingleTypeNode(
            NameNode name);
    
    /**
     * Creates a ImportSingleTypeNode.
     * The specified start and stop locations are used.
     */
    public ImportSingleTypeNode makeImportSingleTypeNode(
            NameNode name,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);
    
    /**
     * Creates a InitializerDeclarationNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public InitializerDeclarationNode makeInitializerDeclarationNode(
            boolean staticInitializer,
            BlockStatementListNode body,
            MetaAnnotationListNode metaAnnotations);
    
    /**
     * Creates a InitializerDeclarationNode.
     * The specified start and stop locations are used.
     */
    public InitializerDeclarationNode makeInitializerDeclarationNode(
            boolean staticInitializer,
            BlockStatementListNode body,
            MetaAnnotationListNode metaAnnotations,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);
    
    /**
     * Creates a InitializerDeclarationNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public InitializerDeclarationNode makeInitializerDeclarationNode(
            boolean staticInitializer,
            BlockStatementListNode body);
    
    /**
     * Creates a InitializerDeclarationNode.
     * The specified start and stop locations are used.
     */
    public InitializerDeclarationNode makeInitializerDeclarationNode(
            boolean staticInitializer,
            BlockStatementListNode body,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);
    
    /**
     * Creates a InstanceOfNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public InstanceOfNode makeInstanceOfNode(
            ExpressionNode expression,
            TypeNode type);
    
    /**
     * Creates a InstanceOfNode.
     * The specified start and stop locations are used.
     */
    public InstanceOfNode makeInstanceOfNode(
            ExpressionNode expression,
            TypeNode type,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);
    
    /**
     * Creates a IntLiteralNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public IntLiteralNode makeIntLiteralNode(
            Integer value);
    
    /**
     * Creates a IntLiteralNode.
     * The specified start and stop locations are used.
     */
    public IntLiteralNode makeIntLiteralNode(
            Integer value,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);
    
    /**
     * Creates a InterfaceBodyNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public InterfaceBodyNode makeInterfaceBodyNode(
            InterfaceMemberListNode members);
    
    /**
     * Creates a InterfaceBodyNode.
     * The specified start and stop locations are used.
     */
    public InterfaceBodyNode makeInterfaceBodyNode(
            InterfaceMemberListNode members,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);
    
    /**
     * Creates a InterfaceDeclarationNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public InterfaceDeclarationNode makeInterfaceDeclarationNode(
            InterfaceModifiersNode modifiers,
            DeclaredTypeListNode extendsClause,
            InterfaceBodyNode body,
            TypeParameterListNode typeParameters,
            IdentifierNode identifier,
            JavadocNode javadoc);
    
    /**
     * Creates a InterfaceDeclarationNode.
     * The specified start and stop locations are used.
     */
    public InterfaceDeclarationNode makeInterfaceDeclarationNode(
            InterfaceModifiersNode modifiers,
            DeclaredTypeListNode extendsClause,
            InterfaceBodyNode body,
            TypeParameterListNode typeParameters,
            IdentifierNode identifier,
            JavadocNode javadoc,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);
    
    /**
     * Creates a InterfaceMemberListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public InterfaceMemberListNode makeInterfaceMemberListNode(
            List<InterfaceMemberNode> children);
    
    /**
     * Creates a InterfaceMemberListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public InterfaceMemberListNode makeInterfaceMemberListNode(
            InterfaceMemberNode... childrenElements);
    
    /**
     * Creates a InterfaceMemberListNode.
     * The specified start and stop locations are used.
     */
    public InterfaceMemberListNode makeInterfaceMemberListNode(
            List<InterfaceMemberNode> children,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);
    
    /**
     * Creates a InterfaceMemberListNode.
     * The specified start and stop locations are used.
     */
    public InterfaceMemberListNode makeInterfaceMemberListNode(
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation,
            InterfaceMemberNode... childrenElements);
    
    /**
     * Creates a InterfaceMemberMetaprogramAnchorNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public InterfaceMemberMetaprogramAnchorNode makeInterfaceMemberMetaprogramAnchorNode(
            MetaprogramNode metaprogram);
    
    /**
     * Creates a InterfaceMemberMetaprogramAnchorNode.
     * The specified start and stop locations are used.
     */
    public InterfaceMemberMetaprogramAnchorNode makeInterfaceMemberMetaprogramAnchorNode(
            MetaprogramNode metaprogram,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);
    
    /**
     * Creates a InterfaceModifiersNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public InterfaceModifiersNode makeInterfaceModifiersNode(
            AccessModifier access,
            boolean staticFlag,
            boolean strictfpFlag,
            MetaAnnotationListNode metaAnnotations,
            AnnotationListNode annotations);
    
    /**
     * Creates a InterfaceModifiersNode.
     * The specified start and stop locations are used.
     */
    public InterfaceModifiersNode makeInterfaceModifiersNode(
            AccessModifier access,
            boolean staticFlag,
            boolean strictfpFlag,
            MetaAnnotationListNode metaAnnotations,
            AnnotationListNode annotations,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);
    
    /**
     * Creates a InterfaceModifiersNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public InterfaceModifiersNode makeInterfaceModifiersNode(
            AccessModifier access);
    
    /**
     * Creates a InterfaceModifiersNode.
     * The specified start and stop locations are used.
     */
    public InterfaceModifiersNode makeInterfaceModifiersNode(
            AccessModifier access,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);
    
    /**
     * Creates a JavadocNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public JavadocNode makeJavadocNode(
            String text);
    
    /**
     * Creates a JavadocNode.
     * The specified start and stop locations are used.
     */
    public JavadocNode makeJavadocNode(
            String text,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);
    
    /**
     * Creates a LabeledStatementNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public LabeledStatementNode makeLabeledStatementNode(
            IdentifierNode label,
            StatementNode statement,
            MetaAnnotationListNode metaAnnotations);
    
    /**
     * Creates a LabeledStatementNode.
     * The specified start and stop locations are used.
     */
    public LabeledStatementNode makeLabeledStatementNode(
            IdentifierNode label,
            StatementNode statement,
            MetaAnnotationListNode metaAnnotations,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);
    
    /**
     * Creates a LabeledStatementNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public LabeledStatementNode makeLabeledStatementNode(
            IdentifierNode label,
            StatementNode statement);
    
    /**
     * Creates a LabeledStatementNode.
     * The specified start and stop locations are used.
     */
    public LabeledStatementNode makeLabeledStatementNode(
            IdentifierNode label,
            StatementNode statement,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);
    
    /**
     * Creates a LocalClassDeclarationNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public LocalClassDeclarationNode makeLocalClassDeclarationNode(
            LocalClassModifiersNode modifiers,
            DeclaredTypeNode extendsClause,
            DeclaredTypeListNode implementsClause,
            ClassBodyNode body,
            TypeParameterListNode typeParameters,
            IdentifierNode identifier,
            JavadocNode javadoc);
    
    /**
     * Creates a LocalClassDeclarationNode.
     * The specified start and stop locations are used.
     */
    public LocalClassDeclarationNode makeLocalClassDeclarationNode(
            LocalClassModifiersNode modifiers,
            DeclaredTypeNode extendsClause,
            DeclaredTypeListNode implementsClause,
            ClassBodyNode body,
            TypeParameterListNode typeParameters,
            IdentifierNode identifier,
            JavadocNode javadoc,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);
    
    /**
     * Creates a LocalClassModifiersNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public LocalClassModifiersNode makeLocalClassModifiersNode(
            boolean abstractFlag,
            boolean finalFlag,
            boolean strictfpFlag,
            MetaAnnotationListNode metaAnnotations,
            AnnotationListNode annotations);
    
    /**
     * Creates a LocalClassModifiersNode.
     * The specified start and stop locations are used.
     */
    public LocalClassModifiersNode makeLocalClassModifiersNode(
            boolean abstractFlag,
            boolean finalFlag,
            boolean strictfpFlag,
            MetaAnnotationListNode metaAnnotations,
            AnnotationListNode annotations,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);
    
    /**
     * Creates a LocalClassModifiersNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public LocalClassModifiersNode makeLocalClassModifiersNode(
    );
    
    /**
     * Creates a LocalClassModifiersNode.
     * The specified start and stop locations are used.
     */
    public LocalClassModifiersNode makeLocalClassModifiersNode(
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);
    
    /**
     * Creates a LocalVariableDeclarationNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public LocalVariableDeclarationNode makeLocalVariableDeclarationNode(
            VariableModifiersNode modifiers,
            TypeNode type,
            VariableDeclaratorListNode declarators);
    
    /**
     * Creates a LocalVariableDeclarationNode.
     * The specified start and stop locations are used.
     */
    public LocalVariableDeclarationNode makeLocalVariableDeclarationNode(
            VariableModifiersNode modifiers,
            TypeNode type,
            VariableDeclaratorListNode declarators,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);
    
    /**
     * Creates a LocalVariableDeclarationNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public LocalVariableDeclarationNode makeLocalVariableDeclarationNode(
            TypeNode type,
            VariableDeclaratorListNode declarators);
    
    /**
     * Creates a LocalVariableDeclarationNode.
     * The specified start and stop locations are used.
     */
    public LocalVariableDeclarationNode makeLocalVariableDeclarationNode(
            TypeNode type,
            VariableDeclaratorListNode declarators,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);
    
    /**
     * Creates a LongLiteralNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public LongLiteralNode makeLongLiteralNode(
            Long value);
    
    /**
     * Creates a LongLiteralNode.
     * The specified start and stop locations are used.
     */
    public LongLiteralNode makeLongLiteralNode(
            Long value,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);
    
    /**
     * Creates a MetaAnnotationArrayValueNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public MetaAnnotationArrayValueNode makeMetaAnnotationArrayValueNode(
            MetaAnnotationValueListNode values);
    
    /**
     * Creates a MetaAnnotationArrayValueNode.
     * The specified start and stop locations are used.
     */
    public MetaAnnotationArrayValueNode makeMetaAnnotationArrayValueNode(
            MetaAnnotationValueListNode values,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);
    
    /**
     * Creates a MetaAnnotationElementListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public MetaAnnotationElementListNode makeMetaAnnotationElementListNode(
            List<MetaAnnotationElementNode> children);
    
    /**
     * Creates a MetaAnnotationElementListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public MetaAnnotationElementListNode makeMetaAnnotationElementListNode(
            MetaAnnotationElementNode... childrenElements);
    
    /**
     * Creates a MetaAnnotationElementListNode.
     * The specified start and stop locations are used.
     */
    public MetaAnnotationElementListNode makeMetaAnnotationElementListNode(
            List<MetaAnnotationElementNode> children,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);
    
    /**
     * Creates a MetaAnnotationElementListNode.
     * The specified start and stop locations are used.
     */
    public MetaAnnotationElementListNode makeMetaAnnotationElementListNode(
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation,
            MetaAnnotationElementNode... childrenElements);
    
    /**
     * Creates a MetaAnnotationElementNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public MetaAnnotationElementNode makeMetaAnnotationElementNode(
            IdentifierNode identifier,
            MetaAnnotationValueNode value);
    
    /**
     * Creates a MetaAnnotationElementNode.
     * The specified start and stop locations are used.
     */
    public MetaAnnotationElementNode makeMetaAnnotationElementNode(
            IdentifierNode identifier,
            MetaAnnotationValueNode value,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);
    
    /**
     * Creates a MetaAnnotationExpressionValueNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public MetaAnnotationExpressionValueNode makeMetaAnnotationExpressionValueNode(
            NonAssignmentExpressionNode expression);
    
    /**
     * Creates a MetaAnnotationExpressionValueNode.
     * The specified start and stop locations are used.
     */
    public MetaAnnotationExpressionValueNode makeMetaAnnotationExpressionValueNode(
            NonAssignmentExpressionNode expression,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);
    
    /**
     * Creates a MetaAnnotationListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public MetaAnnotationListNode makeMetaAnnotationListNode(
            List<MetaAnnotationNode> children);
    
    /**
     * Creates a MetaAnnotationListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public MetaAnnotationListNode makeMetaAnnotationListNode(
            MetaAnnotationNode... childrenElements);
    
    /**
     * Creates a MetaAnnotationListNode.
     * The specified start and stop locations are used.
     */
    public MetaAnnotationListNode makeMetaAnnotationListNode(
            List<MetaAnnotationNode> children,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);
    
    /**
     * Creates a MetaAnnotationListNode.
     * The specified start and stop locations are used.
     */
    public MetaAnnotationListNode makeMetaAnnotationListNode(
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation,
            MetaAnnotationNode... childrenElements);
    
    /**
     * Creates a MetaAnnotationMetaAnnotationValueNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public MetaAnnotationMetaAnnotationValueNode makeMetaAnnotationMetaAnnotationValueNode(
            MetaAnnotationNode annotation);
    
    /**
     * Creates a MetaAnnotationMetaAnnotationValueNode.
     * The specified start and stop locations are used.
     */
    public MetaAnnotationMetaAnnotationValueNode makeMetaAnnotationMetaAnnotationValueNode(
            MetaAnnotationNode annotation,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);
    
    /**
     * Creates a MetaAnnotationMetaprogramAnchorNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public MetaAnnotationMetaprogramAnchorNode makeMetaAnnotationMetaprogramAnchorNode(
    );
    
    /**
     * Creates a MetaAnnotationMetaprogramAnchorNode.
     * The specified start and stop locations are used.
     */
    public MetaAnnotationMetaprogramAnchorNode makeMetaAnnotationMetaprogramAnchorNode(
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);
    
    /**
     * Creates a MetaAnnotationValueListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public MetaAnnotationValueListNode makeMetaAnnotationValueListNode(
            List<MetaAnnotationValueNode> children);
    
    /**
     * Creates a MetaAnnotationValueListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public MetaAnnotationValueListNode makeMetaAnnotationValueListNode(
            MetaAnnotationValueNode... childrenElements);
    
    /**
     * Creates a MetaAnnotationValueListNode.
     * The specified start and stop locations are used.
     */
    public MetaAnnotationValueListNode makeMetaAnnotationValueListNode(
            List<MetaAnnotationValueNode> children,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);
    
    /**
     * Creates a MetaAnnotationValueListNode.
     * The specified start and stop locations are used.
     */
    public MetaAnnotationValueListNode makeMetaAnnotationValueListNode(
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation,
            MetaAnnotationValueNode... childrenElements);
    
    /**
     * Creates a MetaprogramDependencyDeclarationListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public MetaprogramDependencyDeclarationListNode makeMetaprogramDependencyDeclarationListNode(
            List<MetaprogramDependencyDeclarationNode> children);
    
    /**
     * Creates a MetaprogramDependencyDeclarationListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public MetaprogramDependencyDeclarationListNode makeMetaprogramDependencyDeclarationListNode(
            MetaprogramDependencyDeclarationNode... childrenElements);
    
    /**
     * Creates a MetaprogramDependencyDeclarationListNode.
     * The specified start and stop locations are used.
     */
    public MetaprogramDependencyDeclarationListNode makeMetaprogramDependencyDeclarationListNode(
            List<MetaprogramDependencyDeclarationNode> children,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);
    
    /**
     * Creates a MetaprogramDependencyDeclarationListNode.
     * The specified start and stop locations are used.
     */
    public MetaprogramDependencyDeclarationListNode makeMetaprogramDependencyDeclarationListNode(
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation,
            MetaprogramDependencyDeclarationNode... childrenElements);
    
    /**
     * Creates a MetaprogramDependencyDeclarationNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public MetaprogramDependencyDeclarationNode makeMetaprogramDependencyDeclarationNode(
            MetaprogramDependencyListNode targets);
    
    /**
     * Creates a MetaprogramDependencyDeclarationNode.
     * The specified start and stop locations are used.
     */
    public MetaprogramDependencyDeclarationNode makeMetaprogramDependencyDeclarationNode(
            MetaprogramDependencyListNode targets,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);
    
    /**
     * Creates a MetaprogramDependencyListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public MetaprogramDependencyListNode makeMetaprogramDependencyListNode(
            List<MetaprogramDependencyNode> children);
    
    /**
     * Creates a MetaprogramDependencyListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public MetaprogramDependencyListNode makeMetaprogramDependencyListNode(
            MetaprogramDependencyNode... childrenElements);
    
    /**
     * Creates a MetaprogramDependencyListNode.
     * The specified start and stop locations are used.
     */
    public MetaprogramDependencyListNode makeMetaprogramDependencyListNode(
            List<MetaprogramDependencyNode> children,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);
    
    /**
     * Creates a MetaprogramDependencyListNode.
     * The specified start and stop locations are used.
     */
    public MetaprogramDependencyListNode makeMetaprogramDependencyListNode(
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation,
            MetaprogramDependencyNode... childrenElements);
    
    /**
     * Creates a MetaprogramDependencyNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public MetaprogramDependencyNode makeMetaprogramDependencyNode(
            NameNode targetName,
            boolean weak);
    
    /**
     * Creates a MetaprogramDependencyNode.
     * The specified start and stop locations are used.
     */
    public MetaprogramDependencyNode makeMetaprogramDependencyNode(
            NameNode targetName,
            boolean weak,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);
    
    /**
     * Creates a MetaprogramDependencyNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public MetaprogramDependencyNode makeMetaprogramDependencyNode(
            NameNode targetName);
    
    /**
     * Creates a MetaprogramDependencyNode.
     * The specified start and stop locations are used.
     */
    public MetaprogramDependencyNode makeMetaprogramDependencyNode(
            NameNode targetName,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);
    
    /**
     * Creates a MetaprogramImportListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public MetaprogramImportListNode makeMetaprogramImportListNode(
            List<MetaprogramImportNode> children);
    
    /**
     * Creates a MetaprogramImportListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public MetaprogramImportListNode makeMetaprogramImportListNode(
            MetaprogramImportNode... childrenElements);
    
    /**
     * Creates a MetaprogramImportListNode.
     * The specified start and stop locations are used.
     */
    public MetaprogramImportListNode makeMetaprogramImportListNode(
            List<MetaprogramImportNode> children,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);
    
    /**
     * Creates a MetaprogramImportListNode.
     * The specified start and stop locations are used.
     */
    public MetaprogramImportListNode makeMetaprogramImportListNode(
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation,
            MetaprogramImportNode... childrenElements);
    
    /**
     * Creates a MetaprogramImportNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public MetaprogramImportNode makeMetaprogramImportNode(
            ImportNode importNode);
    
    /**
     * Creates a MetaprogramImportNode.
     * The specified start and stop locations are used.
     */
    public MetaprogramImportNode makeMetaprogramImportNode(
            ImportNode importNode,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);
    
    /**
     * Creates a MetaprogramNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public MetaprogramNode makeMetaprogramNode(
            MetaprogramPreambleNode preamble,
            BlockStatementListNode body);
    
    /**
     * Creates a MetaprogramNode.
     * The specified start and stop locations are used.
     */
    public MetaprogramNode makeMetaprogramNode(
            MetaprogramPreambleNode preamble,
            BlockStatementListNode body,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);
    
    /**
     * Creates a MetaprogramPreambleNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public MetaprogramPreambleNode makeMetaprogramPreambleNode(
            MetaprogramImportListNode imports,
            MetaprogramLocalMode localMode,
            MetaprogramPackageMode packageMode,
            MetaprogramTargetListNode targets,
            MetaprogramDependencyDeclarationListNode dependencies);
    
    /**
     * Creates a MetaprogramPreambleNode.
     * The specified start and stop locations are used.
     */
    public MetaprogramPreambleNode makeMetaprogramPreambleNode(
            MetaprogramImportListNode imports,
            MetaprogramLocalMode localMode,
            MetaprogramPackageMode packageMode,
            MetaprogramTargetListNode targets,
            MetaprogramDependencyDeclarationListNode dependencies,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);
    
    /**
     * Creates a MetaprogramPreambleNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public MetaprogramPreambleNode makeMetaprogramPreambleNode(
            MetaprogramImportListNode imports,
            MetaprogramTargetListNode targets,
            MetaprogramDependencyDeclarationListNode dependencies);
    
    /**
     * Creates a MetaprogramPreambleNode.
     * The specified start and stop locations are used.
     */
    public MetaprogramPreambleNode makeMetaprogramPreambleNode(
            MetaprogramImportListNode imports,
            MetaprogramTargetListNode targets,
            MetaprogramDependencyDeclarationListNode dependencies,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);
    
    /**
     * Creates a MetaprogramTargetListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public MetaprogramTargetListNode makeMetaprogramTargetListNode(
            List<MetaprogramTargetNode> children);
    
    /**
     * Creates a MetaprogramTargetListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public MetaprogramTargetListNode makeMetaprogramTargetListNode(
            MetaprogramTargetNode... childrenElements);
    
    /**
     * Creates a MetaprogramTargetListNode.
     * The specified start and stop locations are used.
     */
    public MetaprogramTargetListNode makeMetaprogramTargetListNode(
            List<MetaprogramTargetNode> children,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);
    
    /**
     * Creates a MetaprogramTargetListNode.
     * The specified start and stop locations are used.
     */
    public MetaprogramTargetListNode makeMetaprogramTargetListNode(
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation,
            MetaprogramTargetNode... childrenElements);
    
    /**
     * Creates a MetaprogramTargetNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public MetaprogramTargetNode makeMetaprogramTargetNode(
            IdentifierListNode targets);
    
    /**
     * Creates a MetaprogramTargetNode.
     * The specified start and stop locations are used.
     */
    public MetaprogramTargetNode makeMetaprogramTargetNode(
            IdentifierListNode targets,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);
    
    /**
     * Creates a MethodDeclarationNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public MethodDeclarationNode makeMethodDeclarationNode(
            BlockStatementListNode body,
            MethodModifiersNode modifiers,
            IdentifierNode identifier,
            VariableListNode parameters,
            VariableNode varargParameter,
            TypeNode returnType,
            UnparameterizedTypeListNode throwTypes,
            TypeParameterListNode typeParameters,
            JavadocNode javadoc);
    
    /**
     * Creates a MethodDeclarationNode.
     * The specified start and stop locations are used.
     */
    public MethodDeclarationNode makeMethodDeclarationNode(
            BlockStatementListNode body,
            MethodModifiersNode modifiers,
            IdentifierNode identifier,
            VariableListNode parameters,
            VariableNode varargParameter,
            TypeNode returnType,
            UnparameterizedTypeListNode throwTypes,
            TypeParameterListNode typeParameters,
            JavadocNode javadoc,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);
    
    /**
     * Creates a MethodDeclarationNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public MethodDeclarationNode makeMethodDeclarationNode(
            BlockStatementListNode body,
            MethodModifiersNode modifiers,
            IdentifierNode identifier,
            VariableListNode parameters,
            TypeNode returnType,
            JavadocNode javadoc);
    
    /**
     * Creates a MethodDeclarationNode.
     * The specified start and stop locations are used.
     */
    public MethodDeclarationNode makeMethodDeclarationNode(
            BlockStatementListNode body,
            MethodModifiersNode modifiers,
            IdentifierNode identifier,
            VariableListNode parameters,
            TypeNode returnType,
            JavadocNode javadoc,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);
    
    /**
     * Creates a MethodInvocationByExpressionNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public MethodInvocationByExpressionNode makeMethodInvocationByExpressionNode(
            PrimaryExpressionNode expression,
            IdentifierNode identifier,
            ExpressionListNode arguments,
            ReferenceTypeListNode typeArguments);
    
    /**
     * Creates a MethodInvocationByExpressionNode.
     * The specified start and stop locations are used.
     */
    public MethodInvocationByExpressionNode makeMethodInvocationByExpressionNode(
            PrimaryExpressionNode expression,
            IdentifierNode identifier,
            ExpressionListNode arguments,
            ReferenceTypeListNode typeArguments,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);
    
    /**
     * Creates a MethodInvocationByExpressionNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public MethodInvocationByExpressionNode makeMethodInvocationByExpressionNode(
            PrimaryExpressionNode expression,
            IdentifierNode identifier);
    
    /**
     * Creates a MethodInvocationByExpressionNode.
     * The specified start and stop locations are used.
     */
    public MethodInvocationByExpressionNode makeMethodInvocationByExpressionNode(
            PrimaryExpressionNode expression,
            IdentifierNode identifier,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);
    
    /**
     * Creates a MethodInvocationByExpressionNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public MethodInvocationByExpressionNode makeMethodInvocationByExpressionNode(
            PrimaryExpressionNode expression,
            IdentifierNode identifier,
            ExpressionListNode arguments);
    
    /**
     * Creates a MethodInvocationByExpressionNode.
     * The specified start and stop locations are used.
     */
    public MethodInvocationByExpressionNode makeMethodInvocationByExpressionNode(
            PrimaryExpressionNode expression,
            IdentifierNode identifier,
            ExpressionListNode arguments,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);
    
    /**
     * Creates a MethodInvocationByNameNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public MethodInvocationByNameNode makeMethodInvocationByNameNode(
            NameNode name,
            ExpressionListNode arguments,
            ReferenceTypeListNode typeArguments);
    
    /**
     * Creates a MethodInvocationByNameNode.
     * The specified start and stop locations are used.
     */
    public MethodInvocationByNameNode makeMethodInvocationByNameNode(
            NameNode name,
            ExpressionListNode arguments,
            ReferenceTypeListNode typeArguments,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);
    
    /**
     * Creates a MethodInvocationByNameNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public MethodInvocationByNameNode makeMethodInvocationByNameNode(
            NameNode name);
    
    /**
     * Creates a MethodInvocationByNameNode.
     * The specified start and stop locations are used.
     */
    public MethodInvocationByNameNode makeMethodInvocationByNameNode(
            NameNode name,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);
    
    /**
     * Creates a MethodInvocationByNameNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public MethodInvocationByNameNode makeMethodInvocationByNameNode(
            NameNode name,
            ExpressionListNode arguments);
    
    /**
     * Creates a MethodInvocationByNameNode.
     * The specified start and stop locations are used.
     */
    public MethodInvocationByNameNode makeMethodInvocationByNameNode(
            NameNode name,
            ExpressionListNode arguments,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);
    
    /**
     * Creates a MethodModifiersNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public MethodModifiersNode makeMethodModifiersNode(
            AccessModifier access,
            boolean abstractFlag,
            boolean staticFlag,
            boolean finalFlag,
            boolean synchronizedFlag,
            boolean nativeFlag,
            boolean strictfpFlag,
            MetaAnnotationListNode metaAnnotations,
            AnnotationListNode annotations);
    
    /**
     * Creates a MethodModifiersNode.
     * The specified start and stop locations are used.
     */
    public MethodModifiersNode makeMethodModifiersNode(
            AccessModifier access,
            boolean abstractFlag,
            boolean staticFlag,
            boolean finalFlag,
            boolean synchronizedFlag,
            boolean nativeFlag,
            boolean strictfpFlag,
            MetaAnnotationListNode metaAnnotations,
            AnnotationListNode annotations,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);
    
    /**
     * Creates a MethodModifiersNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public MethodModifiersNode makeMethodModifiersNode(
            AccessModifier access);
    
    /**
     * Creates a MethodModifiersNode.
     * The specified start and stop locations are used.
     */
    public MethodModifiersNode makeMethodModifiersNode(
            AccessModifier access,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);
    
    /**
     * Creates a NoOperationNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public NoOperationNode makeNoOperationNode(
            MetaAnnotationListNode metaAnnotations);
    
    /**
     * Creates a NoOperationNode.
     * The specified start and stop locations are used.
     */
    public NoOperationNode makeNoOperationNode(
            MetaAnnotationListNode metaAnnotations,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);
    
    /**
     * Creates a NoOperationNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public NoOperationNode makeNoOperationNode(
    );
    
    /**
     * Creates a NoOperationNode.
     * The specified start and stop locations are used.
     */
    public NoOperationNode makeNoOperationNode(
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);
    
    /**
     * Creates a NormalAnnotationNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public NormalAnnotationNode makeNormalAnnotationNode(
            AnnotationElementListNode arguments,
            UnparameterizedTypeNode annotationType);
    
    /**
     * Creates a NormalAnnotationNode.
     * The specified start and stop locations are used.
     */
    public NormalAnnotationNode makeNormalAnnotationNode(
            AnnotationElementListNode arguments,
            UnparameterizedTypeNode annotationType,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);
    
    /**
     * Creates a NormalMetaAnnotationNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public NormalMetaAnnotationNode makeNormalMetaAnnotationNode(
            MetaAnnotationElementListNode arguments,
            UnparameterizedTypeNode annotationType);
    
    /**
     * Creates a NormalMetaAnnotationNode.
     * The specified start and stop locations are used.
     */
    public NormalMetaAnnotationNode makeNormalMetaAnnotationNode(
            MetaAnnotationElementListNode arguments,
            UnparameterizedTypeNode annotationType,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);
    
    /**
     * Creates a NullLiteralNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public NullLiteralNode makeNullLiteralNode(
    );
    
    /**
     * Creates a NullLiteralNode.
     * The specified start and stop locations are used.
     */
    public NullLiteralNode makeNullLiteralNode(
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);
    
    /**
     * Creates a PackageDeclarationNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public PackageDeclarationNode makePackageDeclarationNode(
            NameNode name,
            MetaAnnotationListNode metaAnnotations,
            AnnotationListNode annotations);
    
    /**
     * Creates a PackageDeclarationNode.
     * The specified start and stop locations are used.
     */
    public PackageDeclarationNode makePackageDeclarationNode(
            NameNode name,
            MetaAnnotationListNode metaAnnotations,
            AnnotationListNode annotations,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);
    
    /**
     * Creates a PackageDeclarationNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public PackageDeclarationNode makePackageDeclarationNode(
            NameNode name);
    
    /**
     * Creates a PackageDeclarationNode.
     * The specified start and stop locations are used.
     */
    public PackageDeclarationNode makePackageDeclarationNode(
            NameNode name,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);
    
    /**
     * Creates a PackageNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public PackageNode makePackageNode(
            IdentifierNode name);
    
    /**
     * Creates a PackageNode.
     * The specified start and stop locations are used.
     */
    public PackageNode makePackageNode(
            IdentifierNode name,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);
    
    /**
     * Creates a ParameterizedTypeNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public ParameterizedTypeNode makeParameterizedTypeNode(
            UnparameterizedTypeNode baseType,
            TypeArgumentListNode typeArguments);
    
    /**
     * Creates a ParameterizedTypeNode.
     * The specified start and stop locations are used.
     */
    public ParameterizedTypeNode makeParameterizedTypeNode(
            UnparameterizedTypeNode baseType,
            TypeArgumentListNode typeArguments,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);
    
    /**
     * Creates a ParameterizedTypeSelectNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public ParameterizedTypeSelectNode makeParameterizedTypeSelectNode(
            ParameterizedTypeNode base,
            DeclaredTypeNode select);
    
    /**
     * Creates a ParameterizedTypeSelectNode.
     * The specified start and stop locations are used.
     */
    public ParameterizedTypeSelectNode makeParameterizedTypeSelectNode(
            ParameterizedTypeNode base,
            DeclaredTypeNode select,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);
    
    /**
     * Creates a ParenthesizedExpressionNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public ParenthesizedExpressionNode makeParenthesizedExpressionNode(
            ExpressionNode expression);
    
    /**
     * Creates a ParenthesizedExpressionNode.
     * The specified start and stop locations are used.
     */
    public ParenthesizedExpressionNode makeParenthesizedExpressionNode(
            ExpressionNode expression,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);
    
    /**
     * Creates a PrimitiveTypeNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public PrimitiveTypeNode makePrimitiveTypeNode(
            PrimitiveType primitiveType);
    
    /**
     * Creates a PrimitiveTypeNode.
     * The specified start and stop locations are used.
     */
    public PrimitiveTypeNode makePrimitiveTypeNode(
            PrimitiveType primitiveType,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);
    
    /**
     * Creates a QualifiedClassInstantiationNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public QualifiedClassInstantiationNode makeQualifiedClassInstantiationNode(
            ExpressionNode enclosingExpression,
            IdentifierNode identifier,
            TypeArgumentListNode typeArguments,
            TypeArgumentListNode constructorTypeArguments,
            ExpressionListNode arguments,
            AnonymousClassBodyNode body);
    
    /**
     * Creates a QualifiedClassInstantiationNode.
     * The specified start and stop locations are used.
     */
    public QualifiedClassInstantiationNode makeQualifiedClassInstantiationNode(
            ExpressionNode enclosingExpression,
            IdentifierNode identifier,
            TypeArgumentListNode typeArguments,
            TypeArgumentListNode constructorTypeArguments,
            ExpressionListNode arguments,
            AnonymousClassBodyNode body,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);
    
    /**
     * Creates a QualifiedClassInstantiationNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public QualifiedClassInstantiationNode makeQualifiedClassInstantiationNode(
            ExpressionNode enclosingExpression,
            IdentifierNode identifier,
            TypeArgumentListNode typeArguments);
    
    /**
     * Creates a QualifiedClassInstantiationNode.
     * The specified start and stop locations are used.
     */
    public QualifiedClassInstantiationNode makeQualifiedClassInstantiationNode(
            ExpressionNode enclosingExpression,
            IdentifierNode identifier,
            TypeArgumentListNode typeArguments,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);
    
    /**
     * Creates a QualifiedNameNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public QualifiedNameNode makeQualifiedNameNode(
            NameNode base,
            IdentifierNode identifier);
    
    /**
     * Creates a QualifiedNameNode.
     * The specified start and stop locations are used.
     */
    public QualifiedNameNode makeQualifiedNameNode(
            NameNode base,
            IdentifierNode identifier,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);
    
    /**
     * Creates a RawCodeLiteralNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public RawCodeLiteralNode makeRawCodeLiteralNode(
            String value);
    
    /**
     * Creates a RawCodeLiteralNode.
     * The specified start and stop locations are used.
     */
    public RawCodeLiteralNode makeRawCodeLiteralNode(
            String value,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);
    
    /**
     * Creates a ReferenceTypeListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public ReferenceTypeListNode makeReferenceTypeListNode(
            List<ReferenceTypeNode> children);
    
    /**
     * Creates a ReferenceTypeListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public ReferenceTypeListNode makeReferenceTypeListNode(
            ReferenceTypeNode... childrenElements);
    
    /**
     * Creates a ReferenceTypeListNode.
     * The specified start and stop locations are used.
     */
    public ReferenceTypeListNode makeReferenceTypeListNode(
            List<ReferenceTypeNode> children,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);
    
    /**
     * Creates a ReferenceTypeListNode.
     * The specified start and stop locations are used.
     */
    public ReferenceTypeListNode makeReferenceTypeListNode(
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation,
            ReferenceTypeNode... childrenElements);
    
    /**
     * Creates a ReturnNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public ReturnNode makeReturnNode(
            ExpressionNode expression,
            MetaAnnotationListNode metaAnnotations);
    
    /**
     * Creates a ReturnNode.
     * The specified start and stop locations are used.
     */
    public ReturnNode makeReturnNode(
            ExpressionNode expression,
            MetaAnnotationListNode metaAnnotations,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);
    
    /**
     * Creates a ReturnNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public ReturnNode makeReturnNode(
            ExpressionNode expression);
    
    /**
     * Creates a ReturnNode.
     * The specified start and stop locations are used.
     */
    public ReturnNode makeReturnNode(
            ExpressionNode expression,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);
    
    /**
     * Creates a SimpleNameNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public SimpleNameNode makeSimpleNameNode(
            IdentifierNode identifier);
    
    /**
     * Creates a SimpleNameNode.
     * The specified start and stop locations are used.
     */
    public SimpleNameNode makeSimpleNameNode(
            IdentifierNode identifier,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);
    
    /**
     * Creates a SingleElementAnnotationNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public SingleElementAnnotationNode makeSingleElementAnnotationNode(
            AnnotationValueNode value,
            UnparameterizedTypeNode annotationType);
    
    /**
     * Creates a SingleElementAnnotationNode.
     * The specified start and stop locations are used.
     */
    public SingleElementAnnotationNode makeSingleElementAnnotationNode(
            AnnotationValueNode value,
            UnparameterizedTypeNode annotationType,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);
    
    /**
     * Creates a SingleElementMetaAnnotationNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public SingleElementMetaAnnotationNode makeSingleElementMetaAnnotationNode(
            MetaAnnotationValueNode value,
            UnparameterizedTypeNode annotationType);
    
    /**
     * Creates a SingleElementMetaAnnotationNode.
     * The specified start and stop locations are used.
     */
    public SingleElementMetaAnnotationNode makeSingleElementMetaAnnotationNode(
            MetaAnnotationValueNode value,
            UnparameterizedTypeNode annotationType,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);
    
    /**
     * Creates a SingleStaticImportNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public SingleStaticImportNode makeSingleStaticImportNode(
            NameNode name,
            IdentifierNode identifier);
    
    /**
     * Creates a SingleStaticImportNode.
     * The specified start and stop locations are used.
     */
    public SingleStaticImportNode makeSingleStaticImportNode(
            NameNode name,
            IdentifierNode identifier,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);
    
    /**
     * Creates a StatementExpressionListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public StatementExpressionListNode makeStatementExpressionListNode(
            List<StatementExpressionNode> children);
    
    /**
     * Creates a StatementExpressionListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public StatementExpressionListNode makeStatementExpressionListNode(
            StatementExpressionNode... childrenElements);
    
    /**
     * Creates a StatementExpressionListNode.
     * The specified start and stop locations are used.
     */
    public StatementExpressionListNode makeStatementExpressionListNode(
            List<StatementExpressionNode> children,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);
    
    /**
     * Creates a StatementExpressionListNode.
     * The specified start and stop locations are used.
     */
    public StatementExpressionListNode makeStatementExpressionListNode(
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation,
            StatementExpressionNode... childrenElements);
    
    /**
     * Creates a StaticImportOnDemandNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public StaticImportOnDemandNode makeStaticImportOnDemandNode(
            NameNode name);
    
    /**
     * Creates a StaticImportOnDemandNode.
     * The specified start and stop locations are used.
     */
    public StaticImportOnDemandNode makeStaticImportOnDemandNode(
            NameNode name,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);
    
    /**
     * Creates a StringLiteralNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public StringLiteralNode makeStringLiteralNode(
            String value);
    
    /**
     * Creates a StringLiteralNode.
     * The specified start and stop locations are used.
     */
    public StringLiteralNode makeStringLiteralNode(
            String value,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);
    
    /**
     * Creates a SuperFieldAccessNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public SuperFieldAccessNode makeSuperFieldAccessNode(
            UnparameterizedTypeNode type,
            IdentifierNode identifier);
    
    /**
     * Creates a SuperFieldAccessNode.
     * The specified start and stop locations are used.
     */
    public SuperFieldAccessNode makeSuperFieldAccessNode(
            UnparameterizedTypeNode type,
            IdentifierNode identifier,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);
    
    /**
     * Creates a SuperFieldAccessNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public SuperFieldAccessNode makeSuperFieldAccessNode(
            IdentifierNode identifier);
    
    /**
     * Creates a SuperFieldAccessNode.
     * The specified start and stop locations are used.
     */
    public SuperFieldAccessNode makeSuperFieldAccessNode(
            IdentifierNode identifier,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);
    
    /**
     * Creates a SuperMethodInvocationNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public SuperMethodInvocationNode makeSuperMethodInvocationNode(
            UnparameterizedTypeNode type,
            IdentifierNode identifier,
            ExpressionListNode arguments,
            ReferenceTypeListNode typeArguments);
    
    /**
     * Creates a SuperMethodInvocationNode.
     * The specified start and stop locations are used.
     */
    public SuperMethodInvocationNode makeSuperMethodInvocationNode(
            UnparameterizedTypeNode type,
            IdentifierNode identifier,
            ExpressionListNode arguments,
            ReferenceTypeListNode typeArguments,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);
    
    /**
     * Creates a SuperMethodInvocationNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public SuperMethodInvocationNode makeSuperMethodInvocationNode(
            IdentifierNode identifier,
            ExpressionListNode arguments);
    
    /**
     * Creates a SuperMethodInvocationNode.
     * The specified start and stop locations are used.
     */
    public SuperMethodInvocationNode makeSuperMethodInvocationNode(
            IdentifierNode identifier,
            ExpressionListNode arguments,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);
    
    /**
     * Creates a SuperMethodInvocationNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public SuperMethodInvocationNode makeSuperMethodInvocationNode(
            IdentifierNode identifier,
            ExpressionListNode arguments,
            ReferenceTypeListNode typeArguments);
    
    /**
     * Creates a SuperMethodInvocationNode.
     * The specified start and stop locations are used.
     */
    public SuperMethodInvocationNode makeSuperMethodInvocationNode(
            IdentifierNode identifier,
            ExpressionListNode arguments,
            ReferenceTypeListNode typeArguments,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);
    
    /**
     * Creates a SuperclassConstructorInvocationNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public SuperclassConstructorInvocationNode makeSuperclassConstructorInvocationNode(
            PrimaryExpressionNode qualifyingExpression,
            ExpressionListNode arguments,
            ReferenceTypeListNode typeArguments);
    
    /**
     * Creates a SuperclassConstructorInvocationNode.
     * The specified start and stop locations are used.
     */
    public SuperclassConstructorInvocationNode makeSuperclassConstructorInvocationNode(
            PrimaryExpressionNode qualifyingExpression,
            ExpressionListNode arguments,
            ReferenceTypeListNode typeArguments,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);
    
    /**
     * Creates a SuperclassConstructorInvocationNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public SuperclassConstructorInvocationNode makeSuperclassConstructorInvocationNode(
            ExpressionListNode arguments);
    
    /**
     * Creates a SuperclassConstructorInvocationNode.
     * The specified start and stop locations are used.
     */
    public SuperclassConstructorInvocationNode makeSuperclassConstructorInvocationNode(
            ExpressionListNode arguments,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);
    
    /**
     * Creates a SwitchNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public SwitchNode makeSwitchNode(
            ExpressionNode expression,
            CaseListNode cases,
            MetaAnnotationListNode metaAnnotations);
    
    /**
     * Creates a SwitchNode.
     * The specified start and stop locations are used.
     */
    public SwitchNode makeSwitchNode(
            ExpressionNode expression,
            CaseListNode cases,
            MetaAnnotationListNode metaAnnotations,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);
    
    /**
     * Creates a SwitchNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public SwitchNode makeSwitchNode(
            ExpressionNode expression,
            CaseListNode cases);
    
    /**
     * Creates a SwitchNode.
     * The specified start and stop locations are used.
     */
    public SwitchNode makeSwitchNode(
            ExpressionNode expression,
            CaseListNode cases,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);
    
    /**
     * Creates a SynchronizedNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public SynchronizedNode makeSynchronizedNode(
            ExpressionNode expression,
            BlockStatementListNode body,
            MetaAnnotationListNode metaAnnotations);
    
    /**
     * Creates a SynchronizedNode.
     * The specified start and stop locations are used.
     */
    public SynchronizedNode makeSynchronizedNode(
            ExpressionNode expression,
            BlockStatementListNode body,
            MetaAnnotationListNode metaAnnotations,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);
    
    /**
     * Creates a SynchronizedNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public SynchronizedNode makeSynchronizedNode(
            ExpressionNode expression,
            BlockStatementListNode body);
    
    /**
     * Creates a SynchronizedNode.
     * The specified start and stop locations are used.
     */
    public SynchronizedNode makeSynchronizedNode(
            ExpressionNode expression,
            BlockStatementListNode body,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);
    
    /**
     * Creates a ThisNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public ThisNode makeThisNode(
            UnparameterizedTypeNode type);
    
    /**
     * Creates a ThisNode.
     * The specified start and stop locations are used.
     */
    public ThisNode makeThisNode(
            UnparameterizedTypeNode type,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);
    
    /**
     * Creates a ThisNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public ThisNode makeThisNode();
    
    /**
     * Creates a ThisNode.
     * The specified start and stop locations are used.
     */
    public ThisNode makeThisNode(
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);
    
    /**
     * Creates a ThrowNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public ThrowNode makeThrowNode(
            ExpressionNode expression,
            MetaAnnotationListNode metaAnnotations);
    
    /**
     * Creates a ThrowNode.
     * The specified start and stop locations are used.
     */
    public ThrowNode makeThrowNode(
            ExpressionNode expression,
            MetaAnnotationListNode metaAnnotations,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);
    
    /**
     * Creates a ThrowNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public ThrowNode makeThrowNode(
            ExpressionNode expression);
    
    /**
     * Creates a ThrowNode.
     * The specified start and stop locations are used.
     */
    public ThrowNode makeThrowNode(
            ExpressionNode expression,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);
    
    /**
     * Creates a TryNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public TryNode makeTryNode(
            BlockStatementListNode body,
            CatchListNode catches,
            BlockStatementListNode finallyBlock,
            MetaAnnotationListNode metaAnnotations);
    
    /**
     * Creates a TryNode.
     * The specified start and stop locations are used.
     */
    public TryNode makeTryNode(
            BlockStatementListNode body,
            CatchListNode catches,
            BlockStatementListNode finallyBlock,
            MetaAnnotationListNode metaAnnotations,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);
    
    /**
     * Creates a TryNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public TryNode makeTryNode(
            BlockStatementListNode body,
            BlockStatementListNode finallyBlock);
    
    /**
     * Creates a TryNode.
     * The specified start and stop locations are used.
     */
    public TryNode makeTryNode(
            BlockStatementListNode body,
            BlockStatementListNode finallyBlock,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);
    
    /**
     * Creates a TryNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public TryNode makeTryNode(
            BlockStatementListNode body,
            CatchListNode catches);
    
    /**
     * Creates a TryNode.
     * The specified start and stop locations are used.
     */
    public TryNode makeTryNode(
            BlockStatementListNode body,
            CatchListNode catches,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);
    
    /**
     * Creates a TryNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public TryNode makeTryNode(
            BlockStatementListNode body,
            CatchListNode catches,
            BlockStatementListNode finallyBlock);
    
    /**
     * Creates a TryNode.
     * The specified start and stop locations are used.
     */
    public TryNode makeTryNode(
            BlockStatementListNode body,
            CatchListNode catches,
            BlockStatementListNode finallyBlock,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);
    
    /**
     * Creates a TypeArgumentListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public TypeArgumentListNode makeTypeArgumentListNode(
            List<TypeArgumentNode> children);
    
    /**
     * Creates a TypeArgumentListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public TypeArgumentListNode makeTypeArgumentListNode(
            TypeArgumentNode... childrenElements);
    
    /**
     * Creates a TypeArgumentListNode.
     * The specified start and stop locations are used.
     */
    public TypeArgumentListNode makeTypeArgumentListNode(
            List<TypeArgumentNode> children,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);
    
    /**
     * Creates a TypeArgumentListNode.
     * The specified start and stop locations are used.
     */
    public TypeArgumentListNode makeTypeArgumentListNode(
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation,
            TypeArgumentNode... childrenElements);
    
    /**
     * Creates a TypeCastNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public TypeCastNode makeTypeCastNode(
            ExpressionNode expression,
            TypeNode type);
    
    /**
     * Creates a TypeCastNode.
     * The specified start and stop locations are used.
     */
    public TypeCastNode makeTypeCastNode(
            ExpressionNode expression,
            TypeNode type,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);
    
    /**
     * Creates a TypeDeclarationListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public TypeDeclarationListNode makeTypeDeclarationListNode(
            List<TypeDeclarationNode> children);
    
    /**
     * Creates a TypeDeclarationListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public TypeDeclarationListNode makeTypeDeclarationListNode(
            TypeDeclarationNode... childrenElements);
    
    /**
     * Creates a TypeDeclarationListNode.
     * The specified start and stop locations are used.
     */
    public TypeDeclarationListNode makeTypeDeclarationListNode(
            List<TypeDeclarationNode> children,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);
    
    /**
     * Creates a TypeDeclarationListNode.
     * The specified start and stop locations are used.
     */
    public TypeDeclarationListNode makeTypeDeclarationListNode(
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation,
            TypeDeclarationNode... childrenElements);
    
    /**
     * Creates a TypeDeclarationMetaprogramAnchorNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public TypeDeclarationMetaprogramAnchorNode makeTypeDeclarationMetaprogramAnchorNode(
            MetaprogramNode metaprogram);
    
    /**
     * Creates a TypeDeclarationMetaprogramAnchorNode.
     * The specified start and stop locations are used.
     */
    public TypeDeclarationMetaprogramAnchorNode makeTypeDeclarationMetaprogramAnchorNode(
            MetaprogramNode metaprogram,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);
    
    /**
     * Creates a TypeParameterListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public TypeParameterListNode makeTypeParameterListNode(
            List<TypeParameterNode> children);
    
    /**
     * Creates a TypeParameterListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public TypeParameterListNode makeTypeParameterListNode(
            TypeParameterNode... childrenElements);
    
    /**
     * Creates a TypeParameterListNode.
     * The specified start and stop locations are used.
     */
    public TypeParameterListNode makeTypeParameterListNode(
            List<TypeParameterNode> children,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);
    
    /**
     * Creates a TypeParameterListNode.
     * The specified start and stop locations are used.
     */
    public TypeParameterListNode makeTypeParameterListNode(
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation,
            TypeParameterNode... childrenElements);
    
    /**
     * Creates a TypeParameterNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public TypeParameterNode makeTypeParameterNode(
            IdentifierNode identifier,
            DeclaredTypeListNode bounds);
    
    /**
     * Creates a TypeParameterNode.
     * The specified start and stop locations are used.
     */
    public TypeParameterNode makeTypeParameterNode(
            IdentifierNode identifier,
            DeclaredTypeListNode bounds,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);
    
    /**
     * Creates a UnaryExpressionNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public UnaryExpressionNode makeUnaryExpressionNode(
            ExpressionNode expression,
            UnaryOperator operator);
    
    /**
     * Creates a UnaryExpressionNode.
     * The specified start and stop locations are used.
     */
    public UnaryExpressionNode makeUnaryExpressionNode(
            ExpressionNode expression,
            UnaryOperator operator,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);
    
    /**
     * Creates a UnaryStatementExpressionNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public UnaryStatementExpressionNode makeUnaryStatementExpressionNode(
            ExpressionNode expression,
            UnaryStatementOperator operator);
    
    /**
     * Creates a UnaryStatementExpressionNode.
     * The specified start and stop locations are used.
     */
    public UnaryStatementExpressionNode makeUnaryStatementExpressionNode(
            ExpressionNode expression,
            UnaryStatementOperator operator,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);
    
    /**
     * Creates a UnparameterizedTypeListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public UnparameterizedTypeListNode makeUnparameterizedTypeListNode(
            List<UnparameterizedTypeNode> children);
    
    /**
     * Creates a UnparameterizedTypeListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public UnparameterizedTypeListNode makeUnparameterizedTypeListNode(
            UnparameterizedTypeNode... childrenElements);
    
    /**
     * Creates a UnparameterizedTypeListNode.
     * The specified start and stop locations are used.
     */
    public UnparameterizedTypeListNode makeUnparameterizedTypeListNode(
            List<UnparameterizedTypeNode> children,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);
    
    /**
     * Creates a UnparameterizedTypeListNode.
     * The specified start and stop locations are used.
     */
    public UnparameterizedTypeListNode makeUnparameterizedTypeListNode(
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation,
            UnparameterizedTypeNode... childrenElements);
    
    /**
     * Creates a UnparameterizedTypeNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public UnparameterizedTypeNode makeUnparameterizedTypeNode(
            NameNode name);
    
    /**
     * Creates a UnparameterizedTypeNode.
     * The specified start and stop locations are used.
     */
    public UnparameterizedTypeNode makeUnparameterizedTypeNode(
            NameNode name,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);
    
    /**
     * Creates a UnqualifiedClassInstantiationNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public UnqualifiedClassInstantiationNode makeUnqualifiedClassInstantiationNode(
            DeclaredTypeNode type,
            TypeArgumentListNode constructorTypeArguments,
            ExpressionListNode arguments,
            AnonymousClassBodyNode body);
    
    /**
     * Creates a UnqualifiedClassInstantiationNode.
     * The specified start and stop locations are used.
     */
    public UnqualifiedClassInstantiationNode makeUnqualifiedClassInstantiationNode(
            DeclaredTypeNode type,
            TypeArgumentListNode constructorTypeArguments,
            ExpressionListNode arguments,
            AnonymousClassBodyNode body,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);
    
    /**
     * Creates a UnqualifiedClassInstantiationNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public UnqualifiedClassInstantiationNode makeUnqualifiedClassInstantiationNode(
            DeclaredTypeNode type);
    
    /**
     * Creates a UnqualifiedClassInstantiationNode.
     * The specified start and stop locations are used.
     */
    public UnqualifiedClassInstantiationNode makeUnqualifiedClassInstantiationNode(
            DeclaredTypeNode type,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);
    
    /**
     * Creates a UnqualifiedClassInstantiationNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public UnqualifiedClassInstantiationNode makeUnqualifiedClassInstantiationNode(
            DeclaredTypeNode type,
            ExpressionListNode arguments);
    
    /**
     * Creates a UnqualifiedClassInstantiationNode.
     * The specified start and stop locations are used.
     */
    public UnqualifiedClassInstantiationNode makeUnqualifiedClassInstantiationNode(
            DeclaredTypeNode type,
            ExpressionListNode arguments,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);
    
    /**
     * Creates a VariableAccessByExpressionNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public VariableAccessByExpressionNode makeVariableAccessByExpressionNode(
            PrimaryExpressionNode expression,
            IdentifierNode identifier);
    
    /**
     * Creates a VariableAccessByExpressionNode.
     * The specified start and stop locations are used.
     */
    public VariableAccessByExpressionNode makeVariableAccessByExpressionNode(
            PrimaryExpressionNode expression,
            IdentifierNode identifier,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);
    
    /**
     * Creates a VariableAccessByNameNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public VariableAccessByNameNode makeVariableAccessByNameNode(
            NameNode name);
    
    /**
     * Creates a VariableAccessByNameNode.
     * The specified start and stop locations are used.
     */
    public VariableAccessByNameNode makeVariableAccessByNameNode(
            NameNode name,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);
    
    /**
     * Creates a VariableDeclaratorListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public VariableDeclaratorListNode makeVariableDeclaratorListNode(
            List<VariableDeclaratorNode> children);
    
    /**
     * Creates a VariableDeclaratorListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public VariableDeclaratorListNode makeVariableDeclaratorListNode(
            VariableDeclaratorNode... childrenElements);
    
    /**
     * Creates a VariableDeclaratorListNode.
     * The specified start and stop locations are used.
     */
    public VariableDeclaratorListNode makeVariableDeclaratorListNode(
            List<VariableDeclaratorNode> children,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);
    
    /**
     * Creates a VariableDeclaratorListNode.
     * The specified start and stop locations are used.
     */
    public VariableDeclaratorListNode makeVariableDeclaratorListNode(
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation,
            VariableDeclaratorNode... childrenElements);
    
    /**
     * Creates a VariableDeclaratorNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public VariableDeclaratorNode makeVariableDeclaratorNode(
            IdentifierNode name,
            int arrayLevels,
            VariableInitializerNode initializer);
    
    /**
     * Creates a VariableDeclaratorNode.
     * The specified start and stop locations are used.
     */
    public VariableDeclaratorNode makeVariableDeclaratorNode(
            IdentifierNode name,
            int arrayLevels,
            VariableInitializerNode initializer,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);
    
    /**
     * Creates a VariableDeclaratorNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public VariableDeclaratorNode makeVariableDeclaratorNode(
            IdentifierNode name,
            VariableInitializerNode initializer);
    
    /**
     * Creates a VariableDeclaratorNode.
     * The specified start and stop locations are used.
     */
    public VariableDeclaratorNode makeVariableDeclaratorNode(
            IdentifierNode name,
            VariableInitializerNode initializer,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);
    
    /**
     * Creates a VariableInitializerListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public VariableInitializerListNode makeVariableInitializerListNode(
            List<VariableInitializerNode> children);
    
    /**
     * Creates a VariableInitializerListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public VariableInitializerListNode makeVariableInitializerListNode(
            VariableInitializerNode... childrenElements);
    
    /**
     * Creates a VariableInitializerListNode.
     * The specified start and stop locations are used.
     */
    public VariableInitializerListNode makeVariableInitializerListNode(
            List<VariableInitializerNode> children,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);
    
    /**
     * Creates a VariableInitializerListNode.
     * The specified start and stop locations are used.
     */
    public VariableInitializerListNode makeVariableInitializerListNode(
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation,
            VariableInitializerNode... childrenElements);
    
    /**
     * Creates a VariableListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public VariableListNode makeVariableListNode(
            List<VariableNode> children);
    
    /**
     * Creates a VariableListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public VariableListNode makeVariableListNode(
            VariableNode... childrenElements);
    
    /**
     * Creates a VariableListNode.
     * The specified start and stop locations are used.
     */
    public VariableListNode makeVariableListNode(
            List<VariableNode> children,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);
    
    /**
     * Creates a VariableListNode.
     * The specified start and stop locations are used.
     */
    public VariableListNode makeVariableListNode(
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation,
            VariableNode... childrenElements);
    
    /**
     * Creates a VariableModifiersNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public VariableModifiersNode makeVariableModifiersNode(
            boolean finalFlag,
            MetaAnnotationListNode metaAnnotations,
            AnnotationListNode annotations);
    
    /**
     * Creates a VariableModifiersNode.
     * The specified start and stop locations are used.
     */
    public VariableModifiersNode makeVariableModifiersNode(
            boolean finalFlag,
            MetaAnnotationListNode metaAnnotations,
            AnnotationListNode annotations,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);
    
    /**
     * Creates a VariableModifiersNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public VariableModifiersNode makeVariableModifiersNode();
    
    /**
     * Creates a VariableModifiersNode.
     * The specified start and stop locations are used.
     */
    public VariableModifiersNode makeVariableModifiersNode(
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);
    
    /**
     * Creates a VariableNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public VariableNode makeVariableNode(
            VariableModifiersNode modifiers,
            TypeNode type,
            IdentifierNode identifier);
    
    /**
     * Creates a VariableNode.
     * The specified start and stop locations are used.
     */
    public VariableNode makeVariableNode(
            VariableModifiersNode modifiers,
            TypeNode type,
            IdentifierNode identifier,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);
    
    /**
     * Creates a VariableNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public VariableNode makeVariableNode(
            TypeNode type,
            IdentifierNode identifier);
    
    /**
     * Creates a VariableNode.
     * The specified start and stop locations are used.
     */
    public VariableNode makeVariableNode(
            TypeNode type,
            IdentifierNode identifier,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);
    
    /**
     * Creates a VoidTypeNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public VoidTypeNode makeVoidTypeNode(
    );
    
    /**
     * Creates a VoidTypeNode.
     * The specified start and stop locations are used.
     */
    public VoidTypeNode makeVoidTypeNode(
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);
    
    /**
     * Creates a WhileLoopNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public WhileLoopNode makeWhileLoopNode(
            ExpressionNode condition,
            StatementNode statement,
            MetaAnnotationListNode metaAnnotations);
    
    /**
     * Creates a WhileLoopNode.
     * The specified start and stop locations are used.
     */
    public WhileLoopNode makeWhileLoopNode(
            ExpressionNode condition,
            StatementNode statement,
            MetaAnnotationListNode metaAnnotations,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);
    
    /**
     * Creates a WhileLoopNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public WhileLoopNode makeWhileLoopNode(
            ExpressionNode condition,
            StatementNode statement);
    
    /**
     * Creates a WhileLoopNode.
     * The specified start and stop locations are used.
     */
    public WhileLoopNode makeWhileLoopNode(
            ExpressionNode condition,
            StatementNode statement,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);
    
    /**
     * Creates a WildcardTypeNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    public WildcardTypeNode makeWildcardTypeNode(
            ReferenceTypeNode bound,
            boolean upperBound);
    
    /**
     * Creates a WildcardTypeNode.
     * The specified start and stop locations are used.
     */
    public WildcardTypeNode makeWildcardTypeNode(
            ReferenceTypeNode bound,
            boolean upperBound,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation);
    
}
