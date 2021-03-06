/*
 * WARNING: THIS FILE IS GENERATED.  Do not make any changes to this file
 * directly; it was generated from the BSJ source generator project.  If changes
 * are necessary, changes must be applied either to the source generator
 * application or to one of its data files.  The source generator's fully
 * qualified name is edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator.
 */

package edu.jhu.cs.bsj.compiler.ast.util;

import java.util.List;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.AccessModifier;
import edu.jhu.cs.bsj.compiler.ast.AssignmentOperator;
import edu.jhu.cs.bsj.compiler.ast.BinaryOperator;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.BsjRawCodeLiteralPayload;
import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.MetaprogramLocalMode;
import edu.jhu.cs.bsj.compiler.ast.MetaprogramPackageMode;
import edu.jhu.cs.bsj.compiler.ast.NodeUnion;
import edu.jhu.cs.bsj.compiler.ast.PrimitiveType;
import edu.jhu.cs.bsj.compiler.ast.UnaryOperator;
import edu.jhu.cs.bsj.compiler.ast.UnaryStatementOperator;
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
import edu.jhu.cs.bsj.compiler.ast.node.meta.SpliceNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.TypeDeclarationMetaprogramAnchorNode;

/**
 * This class allows simple decoration of all node construction methods on a node factory.
 *
 * @author Zachary Palmer
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public abstract class BsjNodeFactoryDecorator implements BsjNodeFactory
{
    /** The backing factory. */
    BsjNodeFactory factory;

    /**
     * Creates a new decorating factory.
     * @param factory The backing factory.
     */
    public BsjNodeFactoryDecorator(BsjNodeFactory factory)
    {
        this.factory = factory;
    }
    
    /**
     * The "before" decoration method.  This method is called before every node creation.
     */
    protected abstract void before();

    /**
     * The "after" decoration method.  This method is called after every node creation.
     * @param node The node that was just created.
     */
    protected abstract void after(Node node);
    
	/**
	 * Retrieves the starting source location used for new nodes.
	 * 
	 * @return The start location used for new nodes. <code>null</code> is a permissible value and indicates that no
	 *         information is available.
	 */
	public BsjSourceLocation getStartSourceLocation()
	{
		return this.factory.getStartSourceLocation();
	}

	/**
	 * Retrieves the ending source location used for new nodes.
	 * 
	 * @return The stop location used for new nodes. <code>null</code> is a permissible value and indicates that no
	 *         information is available.
	 */
	public BsjSourceLocation getStopSourceLocation()
	{
		return this.factory.getStopSourceLocation();
	}

    /**
     * Changes the starting source location used for new nodes.
     * @param startLocation The new start location to use for new nodes.  <code>null</code> is a permissible value and
     *                      indicates that no information is available.
     */
    @Override
    public void setStartSourceLocation(BsjSourceLocation startLocation)
    {
        this.factory.setStartSourceLocation(startLocation);
    }

    /**
     * Changes the ending source location used for new nodes.
     * @param stopLocation The new stop location to use for new nodes.  <code>null</code> is a permissible value and
     *                      indicates that no information is available.
     */
    @Override
    public void setStopSourceLocation(BsjSourceLocation stopLocation)
    {
        this.factory.setStopSourceLocation(stopLocation);
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public boolean getBinary()
    {
    	return this.factory.getBinary();
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public void setBinary(boolean binary)
    {
    	this.factory.setBinary(binary);
    }

	// MANUALLY SPECIFIED MAKE METHODS ///////////////////////////////////////
    // Since these methods call out to the other factory make methods, we don't decorate them.

	/**
	 * Creates a {@link SingleStaticImportNode}. The provided name is interpreted as the full name of the import; that
	 * is, the name "<tt>java.utils.Arrays.asList</tt>" would be used to create an import for that method by splitting
	 * the name between its type and final identifier. The default start and stop location are used.
	 */
	public SingleStaticImportNode makeSingleStaticImportNode(
    		QualifiedNameNode name)
    {
    	return this.factory.makeSingleStaticImportNode(name);
    }

	/**
	 * Creates a {@link SingleStaticImportNode}. The provided name is interpreted as the full name of the import; that
	 * is, the name "<tt>java.utils.Arrays.asList</tt>" would be used to create an import for that method by splitting
	 * the name between its type and final identifier. The specified start and stop locations are used.
	 */
	public SingleStaticImportNode makeSingleStaticImportNode(
    		QualifiedNameNode name,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
    	return this.factory.makeSingleStaticImportNode(name, startLocation, stopLocation);
    }

	/**
	 * {@inheritDoc}
	 */
	public NameNode parseNameNode(String name)
	{
		return this.factory.parseNameNode(name);
	}
	
	/**
	 * {@inheritDoc}
	 */
	public ArrayTypeNode wrapArrayLevels(TypeNode type, int levels)
	{
		return this.factory.wrapArrayLevels(type, levels);
	}
/**
 * {@inheritDoc}
 */
public <T extends Node> NodeUnion<T> makeNormalNodeUnion(T node)
{
    return factory.makeNormalNodeUnion(node);
}
/**
 * {@inheritDoc}
 */
public <T extends Node> NodeUnion<T> makeSpliceNodeUnion(SpliceNode node)
{
    return factory.makeSpliceNodeUnion(node);
}
    /**
     * Creates a AlternateConstructorInvocationNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public AlternateConstructorInvocationNode makeAlternateConstructorInvocationNodeWithUnions(
            NodeUnion<? extends ExpressionListNode> arguments,
            NodeUnion<? extends ReferenceTypeListNode> typeArguments)
    {
        this.before();
        AlternateConstructorInvocationNode node = factory.makeAlternateConstructorInvocationNodeWithUnions(arguments, typeArguments);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a AlternateConstructorInvocationNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public AlternateConstructorInvocationNode makeAlternateConstructorInvocationNode(
            ExpressionListNode arguments,
            ReferenceTypeListNode typeArguments)
    {
        this.before();
        AlternateConstructorInvocationNode node = factory.makeAlternateConstructorInvocationNode(arguments, typeArguments);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a AlternateConstructorInvocationNode.
     * The specified start and stop locations are used.
     */
    @Override
    public AlternateConstructorInvocationNode makeAlternateConstructorInvocationNodeWithUnions(
            NodeUnion<? extends ExpressionListNode> arguments,
            NodeUnion<? extends ReferenceTypeListNode> typeArguments,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        AlternateConstructorInvocationNode node = factory.makeAlternateConstructorInvocationNodeWithUnions(arguments, typeArguments, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a AlternateConstructorInvocationNode.
     * The specified start and stop locations are used.
     */
    @Override
    public AlternateConstructorInvocationNode makeAlternateConstructorInvocationNode(
            ExpressionListNode arguments,
            ReferenceTypeListNode typeArguments,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        AlternateConstructorInvocationNode node = factory.makeAlternateConstructorInvocationNode(arguments, typeArguments, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a AlternateConstructorInvocationNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public AlternateConstructorInvocationNode makeAlternateConstructorInvocationNode(
            ExpressionListNode arguments)
    {
        this.before();
        AlternateConstructorInvocationNode node = factory.makeAlternateConstructorInvocationNode(arguments);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a AlternateConstructorInvocationNode.
     * The specified start and stop locations are used.
     */
    @Override
    public AlternateConstructorInvocationNode makeAlternateConstructorInvocationNode(
            ExpressionListNode arguments,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        AlternateConstructorInvocationNode node = factory.makeAlternateConstructorInvocationNode(arguments, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a AnnotationAnnotationValueNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public AnnotationAnnotationValueNode makeAnnotationAnnotationValueNodeWithUnions(
            NodeUnion<? extends AnnotationNode> annotation)
    {
        this.before();
        AnnotationAnnotationValueNode node = factory.makeAnnotationAnnotationValueNodeWithUnions(annotation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a AnnotationAnnotationValueNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public AnnotationAnnotationValueNode makeAnnotationAnnotationValueNode(
            AnnotationNode annotation)
    {
        this.before();
        AnnotationAnnotationValueNode node = factory.makeAnnotationAnnotationValueNode(annotation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a AnnotationAnnotationValueNode.
     * The specified start and stop locations are used.
     */
    @Override
    public AnnotationAnnotationValueNode makeAnnotationAnnotationValueNodeWithUnions(
            NodeUnion<? extends AnnotationNode> annotation,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        AnnotationAnnotationValueNode node = factory.makeAnnotationAnnotationValueNodeWithUnions(annotation, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a AnnotationAnnotationValueNode.
     * The specified start and stop locations are used.
     */
    @Override
    public AnnotationAnnotationValueNode makeAnnotationAnnotationValueNode(
            AnnotationNode annotation,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        AnnotationAnnotationValueNode node = factory.makeAnnotationAnnotationValueNode(annotation, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a AnnotationArrayValueNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public AnnotationArrayValueNode makeAnnotationArrayValueNodeWithUnions(
            NodeUnion<? extends AnnotationValueListNode> values)
    {
        this.before();
        AnnotationArrayValueNode node = factory.makeAnnotationArrayValueNodeWithUnions(values);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a AnnotationArrayValueNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public AnnotationArrayValueNode makeAnnotationArrayValueNode(
            AnnotationValueListNode values)
    {
        this.before();
        AnnotationArrayValueNode node = factory.makeAnnotationArrayValueNode(values);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a AnnotationArrayValueNode.
     * The specified start and stop locations are used.
     */
    @Override
    public AnnotationArrayValueNode makeAnnotationArrayValueNodeWithUnions(
            NodeUnion<? extends AnnotationValueListNode> values,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        AnnotationArrayValueNode node = factory.makeAnnotationArrayValueNodeWithUnions(values, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a AnnotationArrayValueNode.
     * The specified start and stop locations are used.
     */
    @Override
    public AnnotationArrayValueNode makeAnnotationArrayValueNode(
            AnnotationValueListNode values,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        AnnotationArrayValueNode node = factory.makeAnnotationArrayValueNode(values, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a AnnotationBodyNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public AnnotationBodyNode makeAnnotationBodyNodeWithUnions(
            NodeUnion<? extends AnnotationMemberListNode> members)
    {
        this.before();
        AnnotationBodyNode node = factory.makeAnnotationBodyNodeWithUnions(members);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a AnnotationBodyNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public AnnotationBodyNode makeAnnotationBodyNode(
            AnnotationMemberListNode members)
    {
        this.before();
        AnnotationBodyNode node = factory.makeAnnotationBodyNode(members);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a AnnotationBodyNode.
     * The specified start and stop locations are used.
     */
    @Override
    public AnnotationBodyNode makeAnnotationBodyNodeWithUnions(
            NodeUnion<? extends AnnotationMemberListNode> members,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        AnnotationBodyNode node = factory.makeAnnotationBodyNodeWithUnions(members, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a AnnotationBodyNode.
     * The specified start and stop locations are used.
     */
    @Override
    public AnnotationBodyNode makeAnnotationBodyNode(
            AnnotationMemberListNode members,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        AnnotationBodyNode node = factory.makeAnnotationBodyNode(members, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a AnnotationDeclarationNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public AnnotationDeclarationNode makeAnnotationDeclarationNodeWithUnions(
            NodeUnion<? extends AnnotationModifiersNode> modifiers,
            NodeUnion<? extends AnnotationBodyNode> body,
            NodeUnion<? extends IdentifierNode> identifier,
            NodeUnion<? extends JavadocNode> javadoc)
    {
        this.before();
        AnnotationDeclarationNode node = factory.makeAnnotationDeclarationNodeWithUnions(modifiers, body, identifier, javadoc);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a AnnotationDeclarationNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public AnnotationDeclarationNode makeAnnotationDeclarationNode(
            AnnotationModifiersNode modifiers,
            AnnotationBodyNode body,
            IdentifierNode identifier,
            JavadocNode javadoc)
    {
        this.before();
        AnnotationDeclarationNode node = factory.makeAnnotationDeclarationNode(modifiers, body, identifier, javadoc);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a AnnotationDeclarationNode.
     * The specified start and stop locations are used.
     */
    @Override
    public AnnotationDeclarationNode makeAnnotationDeclarationNodeWithUnions(
            NodeUnion<? extends AnnotationModifiersNode> modifiers,
            NodeUnion<? extends AnnotationBodyNode> body,
            NodeUnion<? extends IdentifierNode> identifier,
            NodeUnion<? extends JavadocNode> javadoc,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        AnnotationDeclarationNode node = factory.makeAnnotationDeclarationNodeWithUnions(modifiers, body, identifier, javadoc, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a AnnotationDeclarationNode.
     * The specified start and stop locations are used.
     */
    @Override
    public AnnotationDeclarationNode makeAnnotationDeclarationNode(
            AnnotationModifiersNode modifiers,
            AnnotationBodyNode body,
            IdentifierNode identifier,
            JavadocNode javadoc,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        AnnotationDeclarationNode node = factory.makeAnnotationDeclarationNode(modifiers, body, identifier, javadoc, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a AnnotationElementListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public AnnotationElementListNode makeAnnotationElementListNodeWithUnions(
            List<NodeUnion<? extends AnnotationElementNode>> children)
    {
        this.before();
        AnnotationElementListNode node = factory.makeAnnotationElementListNodeWithUnions(children);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a AnnotationElementListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public AnnotationElementListNode makeAnnotationElementListNode(
            List<AnnotationElementNode> children)
    {
        this.before();
        AnnotationElementListNode node = factory.makeAnnotationElementListNode(children);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a AnnotationElementListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public AnnotationElementListNode makeAnnotationElementListNode(
            AnnotationElementNode... childrenElements)
    {
        this.before();
        AnnotationElementListNode node = factory.makeAnnotationElementListNode(childrenElements);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a AnnotationElementListNode.
     * The specified start and stop locations are used.
     */
    @Override
    public AnnotationElementListNode makeAnnotationElementListNodeWithUnions(
            List<NodeUnion<? extends AnnotationElementNode>> children,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        AnnotationElementListNode node = factory.makeAnnotationElementListNodeWithUnions(children, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a AnnotationElementListNode.
     * The specified start and stop locations are used.
     */
    @Override
    public AnnotationElementListNode makeAnnotationElementListNode(
            List<AnnotationElementNode> children,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        AnnotationElementListNode node = factory.makeAnnotationElementListNode(children, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a AnnotationElementListNode.
     * The specified start and stop locations are used.
     */
    @Override
    public AnnotationElementListNode makeAnnotationElementListNode(
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation,
            AnnotationElementNode... childrenElements)
    {
        this.before();
        AnnotationElementListNode node = factory.makeAnnotationElementListNode(startLocation, stopLocation, childrenElements);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a AnnotationElementNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public AnnotationElementNode makeAnnotationElementNodeWithUnions(
            NodeUnion<? extends IdentifierNode> identifier,
            NodeUnion<? extends AnnotationValueNode> value)
    {
        this.before();
        AnnotationElementNode node = factory.makeAnnotationElementNodeWithUnions(identifier, value);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a AnnotationElementNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public AnnotationElementNode makeAnnotationElementNode(
            IdentifierNode identifier,
            AnnotationValueNode value)
    {
        this.before();
        AnnotationElementNode node = factory.makeAnnotationElementNode(identifier, value);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a AnnotationElementNode.
     * The specified start and stop locations are used.
     */
    @Override
    public AnnotationElementNode makeAnnotationElementNodeWithUnions(
            NodeUnion<? extends IdentifierNode> identifier,
            NodeUnion<? extends AnnotationValueNode> value,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        AnnotationElementNode node = factory.makeAnnotationElementNodeWithUnions(identifier, value, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a AnnotationElementNode.
     * The specified start and stop locations are used.
     */
    @Override
    public AnnotationElementNode makeAnnotationElementNode(
            IdentifierNode identifier,
            AnnotationValueNode value,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        AnnotationElementNode node = factory.makeAnnotationElementNode(identifier, value, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a AnnotationExpressionValueNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public AnnotationExpressionValueNode makeAnnotationExpressionValueNodeWithUnions(
            NodeUnion<? extends NonAssignmentExpressionNode> expression)
    {
        this.before();
        AnnotationExpressionValueNode node = factory.makeAnnotationExpressionValueNodeWithUnions(expression);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a AnnotationExpressionValueNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public AnnotationExpressionValueNode makeAnnotationExpressionValueNode(
            NonAssignmentExpressionNode expression)
    {
        this.before();
        AnnotationExpressionValueNode node = factory.makeAnnotationExpressionValueNode(expression);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a AnnotationExpressionValueNode.
     * The specified start and stop locations are used.
     */
    @Override
    public AnnotationExpressionValueNode makeAnnotationExpressionValueNodeWithUnions(
            NodeUnion<? extends NonAssignmentExpressionNode> expression,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        AnnotationExpressionValueNode node = factory.makeAnnotationExpressionValueNodeWithUnions(expression, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a AnnotationExpressionValueNode.
     * The specified start and stop locations are used.
     */
    @Override
    public AnnotationExpressionValueNode makeAnnotationExpressionValueNode(
            NonAssignmentExpressionNode expression,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        AnnotationExpressionValueNode node = factory.makeAnnotationExpressionValueNode(expression, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a AnnotationListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public AnnotationListNode makeAnnotationListNodeWithUnions(
            List<NodeUnion<? extends AnnotationNode>> children)
    {
        this.before();
        AnnotationListNode node = factory.makeAnnotationListNodeWithUnions(children);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a AnnotationListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public AnnotationListNode makeAnnotationListNode(
            List<AnnotationNode> children)
    {
        this.before();
        AnnotationListNode node = factory.makeAnnotationListNode(children);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a AnnotationListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public AnnotationListNode makeAnnotationListNode(
            AnnotationNode... childrenElements)
    {
        this.before();
        AnnotationListNode node = factory.makeAnnotationListNode(childrenElements);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a AnnotationListNode.
     * The specified start and stop locations are used.
     */
    @Override
    public AnnotationListNode makeAnnotationListNodeWithUnions(
            List<NodeUnion<? extends AnnotationNode>> children,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        AnnotationListNode node = factory.makeAnnotationListNodeWithUnions(children, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a AnnotationListNode.
     * The specified start and stop locations are used.
     */
    @Override
    public AnnotationListNode makeAnnotationListNode(
            List<AnnotationNode> children,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        AnnotationListNode node = factory.makeAnnotationListNode(children, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a AnnotationListNode.
     * The specified start and stop locations are used.
     */
    @Override
    public AnnotationListNode makeAnnotationListNode(
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation,
            AnnotationNode... childrenElements)
    {
        this.before();
        AnnotationListNode node = factory.makeAnnotationListNode(startLocation, stopLocation, childrenElements);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a AnnotationMemberListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public AnnotationMemberListNode makeAnnotationMemberListNodeWithUnions(
            List<NodeUnion<? extends AnnotationMemberNode>> children)
    {
        this.before();
        AnnotationMemberListNode node = factory.makeAnnotationMemberListNodeWithUnions(children);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a AnnotationMemberListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public AnnotationMemberListNode makeAnnotationMemberListNode(
            List<AnnotationMemberNode> children)
    {
        this.before();
        AnnotationMemberListNode node = factory.makeAnnotationMemberListNode(children);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a AnnotationMemberListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public AnnotationMemberListNode makeAnnotationMemberListNode(
            AnnotationMemberNode... childrenElements)
    {
        this.before();
        AnnotationMemberListNode node = factory.makeAnnotationMemberListNode(childrenElements);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a AnnotationMemberListNode.
     * The specified start and stop locations are used.
     */
    @Override
    public AnnotationMemberListNode makeAnnotationMemberListNodeWithUnions(
            List<NodeUnion<? extends AnnotationMemberNode>> children,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        AnnotationMemberListNode node = factory.makeAnnotationMemberListNodeWithUnions(children, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a AnnotationMemberListNode.
     * The specified start and stop locations are used.
     */
    @Override
    public AnnotationMemberListNode makeAnnotationMemberListNode(
            List<AnnotationMemberNode> children,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        AnnotationMemberListNode node = factory.makeAnnotationMemberListNode(children, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a AnnotationMemberListNode.
     * The specified start and stop locations are used.
     */
    @Override
    public AnnotationMemberListNode makeAnnotationMemberListNode(
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation,
            AnnotationMemberNode... childrenElements)
    {
        this.before();
        AnnotationMemberListNode node = factory.makeAnnotationMemberListNode(startLocation, stopLocation, childrenElements);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a AnnotationMemberMetaprogramAnchorNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public AnnotationMemberMetaprogramAnchorNode makeAnnotationMemberMetaprogramAnchorNodeWithUnions(
            NodeUnion<? extends MetaprogramNode> metaprogram)
    {
        this.before();
        AnnotationMemberMetaprogramAnchorNode node = factory.makeAnnotationMemberMetaprogramAnchorNodeWithUnions(metaprogram);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a AnnotationMemberMetaprogramAnchorNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public AnnotationMemberMetaprogramAnchorNode makeAnnotationMemberMetaprogramAnchorNode(
            MetaprogramNode metaprogram)
    {
        this.before();
        AnnotationMemberMetaprogramAnchorNode node = factory.makeAnnotationMemberMetaprogramAnchorNode(metaprogram);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a AnnotationMemberMetaprogramAnchorNode.
     * The specified start and stop locations are used.
     */
    @Override
    public AnnotationMemberMetaprogramAnchorNode makeAnnotationMemberMetaprogramAnchorNodeWithUnions(
            NodeUnion<? extends MetaprogramNode> metaprogram,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        AnnotationMemberMetaprogramAnchorNode node = factory.makeAnnotationMemberMetaprogramAnchorNodeWithUnions(metaprogram, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a AnnotationMemberMetaprogramAnchorNode.
     * The specified start and stop locations are used.
     */
    @Override
    public AnnotationMemberMetaprogramAnchorNode makeAnnotationMemberMetaprogramAnchorNode(
            MetaprogramNode metaprogram,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        AnnotationMemberMetaprogramAnchorNode node = factory.makeAnnotationMemberMetaprogramAnchorNode(metaprogram, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a AnnotationMethodDeclarationNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public AnnotationMethodDeclarationNode makeAnnotationMethodDeclarationNodeWithUnions(
            NodeUnion<? extends AnnotationMethodModifiersNode> modifiers,
            NodeUnion<? extends TypeNode> type,
            NodeUnion<? extends IdentifierNode> identifier,
            NodeUnion<? extends AnnotationValueNode> defaultValue,
            NodeUnion<? extends JavadocNode> javadoc)
    {
        this.before();
        AnnotationMethodDeclarationNode node = factory.makeAnnotationMethodDeclarationNodeWithUnions(modifiers, type, identifier, defaultValue, javadoc);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a AnnotationMethodDeclarationNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public AnnotationMethodDeclarationNode makeAnnotationMethodDeclarationNode(
            AnnotationMethodModifiersNode modifiers,
            TypeNode type,
            IdentifierNode identifier,
            AnnotationValueNode defaultValue,
            JavadocNode javadoc)
    {
        this.before();
        AnnotationMethodDeclarationNode node = factory.makeAnnotationMethodDeclarationNode(modifiers, type, identifier, defaultValue, javadoc);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a AnnotationMethodDeclarationNode.
     * The specified start and stop locations are used.
     */
    @Override
    public AnnotationMethodDeclarationNode makeAnnotationMethodDeclarationNodeWithUnions(
            NodeUnion<? extends AnnotationMethodModifiersNode> modifiers,
            NodeUnion<? extends TypeNode> type,
            NodeUnion<? extends IdentifierNode> identifier,
            NodeUnion<? extends AnnotationValueNode> defaultValue,
            NodeUnion<? extends JavadocNode> javadoc,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        AnnotationMethodDeclarationNode node = factory.makeAnnotationMethodDeclarationNodeWithUnions(modifiers, type, identifier, defaultValue, javadoc, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a AnnotationMethodDeclarationNode.
     * The specified start and stop locations are used.
     */
    @Override
    public AnnotationMethodDeclarationNode makeAnnotationMethodDeclarationNode(
            AnnotationMethodModifiersNode modifiers,
            TypeNode type,
            IdentifierNode identifier,
            AnnotationValueNode defaultValue,
            JavadocNode javadoc,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        AnnotationMethodDeclarationNode node = factory.makeAnnotationMethodDeclarationNode(modifiers, type, identifier, defaultValue, javadoc, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a AnnotationMethodModifiersNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public AnnotationMethodModifiersNode makeAnnotationMethodModifiersNodeWithUnions(
            NodeUnion<? extends MetaAnnotationListNode> metaAnnotations,
            NodeUnion<? extends AnnotationListNode> annotations)
    {
        this.before();
        AnnotationMethodModifiersNode node = factory.makeAnnotationMethodModifiersNodeWithUnions(metaAnnotations, annotations);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a AnnotationMethodModifiersNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public AnnotationMethodModifiersNode makeAnnotationMethodModifiersNode(
            MetaAnnotationListNode metaAnnotations,
            AnnotationListNode annotations)
    {
        this.before();
        AnnotationMethodModifiersNode node = factory.makeAnnotationMethodModifiersNode(metaAnnotations, annotations);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a AnnotationMethodModifiersNode.
     * The specified start and stop locations are used.
     */
    @Override
    public AnnotationMethodModifiersNode makeAnnotationMethodModifiersNodeWithUnions(
            NodeUnion<? extends MetaAnnotationListNode> metaAnnotations,
            NodeUnion<? extends AnnotationListNode> annotations,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        AnnotationMethodModifiersNode node = factory.makeAnnotationMethodModifiersNodeWithUnions(metaAnnotations, annotations, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a AnnotationMethodModifiersNode.
     * The specified start and stop locations are used.
     */
    @Override
    public AnnotationMethodModifiersNode makeAnnotationMethodModifiersNode(
            MetaAnnotationListNode metaAnnotations,
            AnnotationListNode annotations,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        AnnotationMethodModifiersNode node = factory.makeAnnotationMethodModifiersNode(metaAnnotations, annotations, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a AnnotationModifiersNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public AnnotationModifiersNode makeAnnotationModifiersNodeWithUnions(
            AccessModifier access,
            boolean staticFlag,
            boolean strictfpFlag,
            NodeUnion<? extends MetaAnnotationListNode> metaAnnotations,
            NodeUnion<? extends AnnotationListNode> annotations)
    {
        this.before();
        AnnotationModifiersNode node = factory.makeAnnotationModifiersNodeWithUnions(access, staticFlag, strictfpFlag, metaAnnotations, annotations);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a AnnotationModifiersNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public AnnotationModifiersNode makeAnnotationModifiersNode(
            AccessModifier access,
            boolean staticFlag,
            boolean strictfpFlag,
            MetaAnnotationListNode metaAnnotations,
            AnnotationListNode annotations)
    {
        this.before();
        AnnotationModifiersNode node = factory.makeAnnotationModifiersNode(access, staticFlag, strictfpFlag, metaAnnotations, annotations);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a AnnotationModifiersNode.
     * The specified start and stop locations are used.
     */
    @Override
    public AnnotationModifiersNode makeAnnotationModifiersNodeWithUnions(
            AccessModifier access,
            boolean staticFlag,
            boolean strictfpFlag,
            NodeUnion<? extends MetaAnnotationListNode> metaAnnotations,
            NodeUnion<? extends AnnotationListNode> annotations,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        AnnotationModifiersNode node = factory.makeAnnotationModifiersNodeWithUnions(access, staticFlag, strictfpFlag, metaAnnotations, annotations, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a AnnotationModifiersNode.
     * The specified start and stop locations are used.
     */
    @Override
    public AnnotationModifiersNode makeAnnotationModifiersNode(
            AccessModifier access,
            boolean staticFlag,
            boolean strictfpFlag,
            MetaAnnotationListNode metaAnnotations,
            AnnotationListNode annotations,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        AnnotationModifiersNode node = factory.makeAnnotationModifiersNode(access, staticFlag, strictfpFlag, metaAnnotations, annotations, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a AnnotationModifiersNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public AnnotationModifiersNode makeAnnotationModifiersNode(
            AccessModifier access)
    {
        this.before();
        AnnotationModifiersNode node = factory.makeAnnotationModifiersNode(access);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a AnnotationModifiersNode.
     * The specified start and stop locations are used.
     */
    @Override
    public AnnotationModifiersNode makeAnnotationModifiersNode(
            AccessModifier access,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        AnnotationModifiersNode node = factory.makeAnnotationModifiersNode(access, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a AnnotationValueListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public AnnotationValueListNode makeAnnotationValueListNodeWithUnions(
            List<NodeUnion<? extends AnnotationValueNode>> children)
    {
        this.before();
        AnnotationValueListNode node = factory.makeAnnotationValueListNodeWithUnions(children);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a AnnotationValueListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public AnnotationValueListNode makeAnnotationValueListNode(
            List<AnnotationValueNode> children)
    {
        this.before();
        AnnotationValueListNode node = factory.makeAnnotationValueListNode(children);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a AnnotationValueListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public AnnotationValueListNode makeAnnotationValueListNode(
            AnnotationValueNode... childrenElements)
    {
        this.before();
        AnnotationValueListNode node = factory.makeAnnotationValueListNode(childrenElements);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a AnnotationValueListNode.
     * The specified start and stop locations are used.
     */
    @Override
    public AnnotationValueListNode makeAnnotationValueListNodeWithUnions(
            List<NodeUnion<? extends AnnotationValueNode>> children,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        AnnotationValueListNode node = factory.makeAnnotationValueListNodeWithUnions(children, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a AnnotationValueListNode.
     * The specified start and stop locations are used.
     */
    @Override
    public AnnotationValueListNode makeAnnotationValueListNode(
            List<AnnotationValueNode> children,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        AnnotationValueListNode node = factory.makeAnnotationValueListNode(children, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a AnnotationValueListNode.
     * The specified start and stop locations are used.
     */
    @Override
    public AnnotationValueListNode makeAnnotationValueListNode(
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation,
            AnnotationValueNode... childrenElements)
    {
        this.before();
        AnnotationValueListNode node = factory.makeAnnotationValueListNode(startLocation, stopLocation, childrenElements);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a AnonymousClassBodyNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public AnonymousClassBodyNode makeAnonymousClassBodyNodeWithUnions(
            NodeUnion<? extends AnonymousClassMemberListNode> members)
    {
        this.before();
        AnonymousClassBodyNode node = factory.makeAnonymousClassBodyNodeWithUnions(members);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a AnonymousClassBodyNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public AnonymousClassBodyNode makeAnonymousClassBodyNode(
            AnonymousClassMemberListNode members)
    {
        this.before();
        AnonymousClassBodyNode node = factory.makeAnonymousClassBodyNode(members);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a AnonymousClassBodyNode.
     * The specified start and stop locations are used.
     */
    @Override
    public AnonymousClassBodyNode makeAnonymousClassBodyNodeWithUnions(
            NodeUnion<? extends AnonymousClassMemberListNode> members,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        AnonymousClassBodyNode node = factory.makeAnonymousClassBodyNodeWithUnions(members, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a AnonymousClassBodyNode.
     * The specified start and stop locations are used.
     */
    @Override
    public AnonymousClassBodyNode makeAnonymousClassBodyNode(
            AnonymousClassMemberListNode members,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        AnonymousClassBodyNode node = factory.makeAnonymousClassBodyNode(members, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a AnonymousClassMemberListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public AnonymousClassMemberListNode makeAnonymousClassMemberListNodeWithUnions(
            List<NodeUnion<? extends AnonymousClassMemberNode>> children)
    {
        this.before();
        AnonymousClassMemberListNode node = factory.makeAnonymousClassMemberListNodeWithUnions(children);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a AnonymousClassMemberListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public AnonymousClassMemberListNode makeAnonymousClassMemberListNode(
            List<AnonymousClassMemberNode> children)
    {
        this.before();
        AnonymousClassMemberListNode node = factory.makeAnonymousClassMemberListNode(children);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a AnonymousClassMemberListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public AnonymousClassMemberListNode makeAnonymousClassMemberListNode(
            AnonymousClassMemberNode... childrenElements)
    {
        this.before();
        AnonymousClassMemberListNode node = factory.makeAnonymousClassMemberListNode(childrenElements);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a AnonymousClassMemberListNode.
     * The specified start and stop locations are used.
     */
    @Override
    public AnonymousClassMemberListNode makeAnonymousClassMemberListNodeWithUnions(
            List<NodeUnion<? extends AnonymousClassMemberNode>> children,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        AnonymousClassMemberListNode node = factory.makeAnonymousClassMemberListNodeWithUnions(children, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a AnonymousClassMemberListNode.
     * The specified start and stop locations are used.
     */
    @Override
    public AnonymousClassMemberListNode makeAnonymousClassMemberListNode(
            List<AnonymousClassMemberNode> children,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        AnonymousClassMemberListNode node = factory.makeAnonymousClassMemberListNode(children, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a AnonymousClassMemberListNode.
     * The specified start and stop locations are used.
     */
    @Override
    public AnonymousClassMemberListNode makeAnonymousClassMemberListNode(
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation,
            AnonymousClassMemberNode... childrenElements)
    {
        this.before();
        AnonymousClassMemberListNode node = factory.makeAnonymousClassMemberListNode(startLocation, stopLocation, childrenElements);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a AnonymousClassMemberMetaprogramAnchorNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public AnonymousClassMemberMetaprogramAnchorNode makeAnonymousClassMemberMetaprogramAnchorNodeWithUnions(
            NodeUnion<? extends MetaprogramNode> metaprogram)
    {
        this.before();
        AnonymousClassMemberMetaprogramAnchorNode node = factory.makeAnonymousClassMemberMetaprogramAnchorNodeWithUnions(metaprogram);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a AnonymousClassMemberMetaprogramAnchorNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public AnonymousClassMemberMetaprogramAnchorNode makeAnonymousClassMemberMetaprogramAnchorNode(
            MetaprogramNode metaprogram)
    {
        this.before();
        AnonymousClassMemberMetaprogramAnchorNode node = factory.makeAnonymousClassMemberMetaprogramAnchorNode(metaprogram);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a AnonymousClassMemberMetaprogramAnchorNode.
     * The specified start and stop locations are used.
     */
    @Override
    public AnonymousClassMemberMetaprogramAnchorNode makeAnonymousClassMemberMetaprogramAnchorNodeWithUnions(
            NodeUnion<? extends MetaprogramNode> metaprogram,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        AnonymousClassMemberMetaprogramAnchorNode node = factory.makeAnonymousClassMemberMetaprogramAnchorNodeWithUnions(metaprogram, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a AnonymousClassMemberMetaprogramAnchorNode.
     * The specified start and stop locations are used.
     */
    @Override
    public AnonymousClassMemberMetaprogramAnchorNode makeAnonymousClassMemberMetaprogramAnchorNode(
            MetaprogramNode metaprogram,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        AnonymousClassMemberMetaprogramAnchorNode node = factory.makeAnonymousClassMemberMetaprogramAnchorNode(metaprogram, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a ArrayAccessNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public ArrayAccessNode makeArrayAccessNodeWithUnions(
            NodeUnion<? extends RestrictedPrimaryExpressionNode> arrayExpression,
            NodeUnion<? extends ExpressionNode> indexExpression)
    {
        this.before();
        ArrayAccessNode node = factory.makeArrayAccessNodeWithUnions(arrayExpression, indexExpression);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a ArrayAccessNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public ArrayAccessNode makeArrayAccessNode(
            RestrictedPrimaryExpressionNode arrayExpression,
            ExpressionNode indexExpression)
    {
        this.before();
        ArrayAccessNode node = factory.makeArrayAccessNode(arrayExpression, indexExpression);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a ArrayAccessNode.
     * The specified start and stop locations are used.
     */
    @Override
    public ArrayAccessNode makeArrayAccessNodeWithUnions(
            NodeUnion<? extends RestrictedPrimaryExpressionNode> arrayExpression,
            NodeUnion<? extends ExpressionNode> indexExpression,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        ArrayAccessNode node = factory.makeArrayAccessNodeWithUnions(arrayExpression, indexExpression, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a ArrayAccessNode.
     * The specified start and stop locations are used.
     */
    @Override
    public ArrayAccessNode makeArrayAccessNode(
            RestrictedPrimaryExpressionNode arrayExpression,
            ExpressionNode indexExpression,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        ArrayAccessNode node = factory.makeArrayAccessNode(arrayExpression, indexExpression, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a ArrayInitializerCreationNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public ArrayInitializerCreationNode makeArrayInitializerCreationNodeWithUnions(
            NodeUnion<? extends ArrayInitializerNode> initializer,
            NodeUnion<? extends BaseTypeNode> baseType,
            int arrayLevels)
    {
        this.before();
        ArrayInitializerCreationNode node = factory.makeArrayInitializerCreationNodeWithUnions(initializer, baseType, arrayLevels);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a ArrayInitializerCreationNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public ArrayInitializerCreationNode makeArrayInitializerCreationNode(
            ArrayInitializerNode initializer,
            BaseTypeNode baseType,
            int arrayLevels)
    {
        this.before();
        ArrayInitializerCreationNode node = factory.makeArrayInitializerCreationNode(initializer, baseType, arrayLevels);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a ArrayInitializerCreationNode.
     * The specified start and stop locations are used.
     */
    @Override
    public ArrayInitializerCreationNode makeArrayInitializerCreationNodeWithUnions(
            NodeUnion<? extends ArrayInitializerNode> initializer,
            NodeUnion<? extends BaseTypeNode> baseType,
            int arrayLevels,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        ArrayInitializerCreationNode node = factory.makeArrayInitializerCreationNodeWithUnions(initializer, baseType, arrayLevels, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a ArrayInitializerCreationNode.
     * The specified start and stop locations are used.
     */
    @Override
    public ArrayInitializerCreationNode makeArrayInitializerCreationNode(
            ArrayInitializerNode initializer,
            BaseTypeNode baseType,
            int arrayLevels,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        ArrayInitializerCreationNode node = factory.makeArrayInitializerCreationNode(initializer, baseType, arrayLevels, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a ArrayInitializerNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public ArrayInitializerNode makeArrayInitializerNodeWithUnions(
            NodeUnion<? extends VariableInitializerListNode> initializers)
    {
        this.before();
        ArrayInitializerNode node = factory.makeArrayInitializerNodeWithUnions(initializers);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a ArrayInitializerNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public ArrayInitializerNode makeArrayInitializerNode(
            VariableInitializerListNode initializers)
    {
        this.before();
        ArrayInitializerNode node = factory.makeArrayInitializerNode(initializers);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a ArrayInitializerNode.
     * The specified start and stop locations are used.
     */
    @Override
    public ArrayInitializerNode makeArrayInitializerNodeWithUnions(
            NodeUnion<? extends VariableInitializerListNode> initializers,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        ArrayInitializerNode node = factory.makeArrayInitializerNodeWithUnions(initializers, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a ArrayInitializerNode.
     * The specified start and stop locations are used.
     */
    @Override
    public ArrayInitializerNode makeArrayInitializerNode(
            VariableInitializerListNode initializers,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        ArrayInitializerNode node = factory.makeArrayInitializerNode(initializers, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a ArrayInstantiatorCreationNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public ArrayInstantiatorCreationNode makeArrayInstantiatorCreationNodeWithUnions(
            NodeUnion<? extends ExpressionListNode> dimExpressions,
            NodeUnion<? extends BaseTypeNode> baseType,
            int arrayLevels)
    {
        this.before();
        ArrayInstantiatorCreationNode node = factory.makeArrayInstantiatorCreationNodeWithUnions(dimExpressions, baseType, arrayLevels);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a ArrayInstantiatorCreationNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public ArrayInstantiatorCreationNode makeArrayInstantiatorCreationNode(
            ExpressionListNode dimExpressions,
            BaseTypeNode baseType,
            int arrayLevels)
    {
        this.before();
        ArrayInstantiatorCreationNode node = factory.makeArrayInstantiatorCreationNode(dimExpressions, baseType, arrayLevels);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a ArrayInstantiatorCreationNode.
     * The specified start and stop locations are used.
     */
    @Override
    public ArrayInstantiatorCreationNode makeArrayInstantiatorCreationNodeWithUnions(
            NodeUnion<? extends ExpressionListNode> dimExpressions,
            NodeUnion<? extends BaseTypeNode> baseType,
            int arrayLevels,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        ArrayInstantiatorCreationNode node = factory.makeArrayInstantiatorCreationNodeWithUnions(dimExpressions, baseType, arrayLevels, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a ArrayInstantiatorCreationNode.
     * The specified start and stop locations are used.
     */
    @Override
    public ArrayInstantiatorCreationNode makeArrayInstantiatorCreationNode(
            ExpressionListNode dimExpressions,
            BaseTypeNode baseType,
            int arrayLevels,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        ArrayInstantiatorCreationNode node = factory.makeArrayInstantiatorCreationNode(dimExpressions, baseType, arrayLevels, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a ArrayTypeNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public ArrayTypeNode makeArrayTypeNodeWithUnions(
            NodeUnion<? extends TypeNode> type)
    {
        this.before();
        ArrayTypeNode node = factory.makeArrayTypeNodeWithUnions(type);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a ArrayTypeNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public ArrayTypeNode makeArrayTypeNode(
            TypeNode type)
    {
        this.before();
        ArrayTypeNode node = factory.makeArrayTypeNode(type);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a ArrayTypeNode.
     * The specified start and stop locations are used.
     */
    @Override
    public ArrayTypeNode makeArrayTypeNodeWithUnions(
            NodeUnion<? extends TypeNode> type,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        ArrayTypeNode node = factory.makeArrayTypeNodeWithUnions(type, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a ArrayTypeNode.
     * The specified start and stop locations are used.
     */
    @Override
    public ArrayTypeNode makeArrayTypeNode(
            TypeNode type,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        ArrayTypeNode node = factory.makeArrayTypeNode(type, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a AssertStatementNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public AssertStatementNode makeAssertStatementNodeWithUnions(
            NodeUnion<? extends ExpressionNode> testExpression,
            NodeUnion<? extends ExpressionNode> messageExpression,
            NodeUnion<? extends MetaAnnotationListNode> metaAnnotations)
    {
        this.before();
        AssertStatementNode node = factory.makeAssertStatementNodeWithUnions(testExpression, messageExpression, metaAnnotations);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a AssertStatementNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public AssertStatementNode makeAssertStatementNode(
            ExpressionNode testExpression,
            ExpressionNode messageExpression,
            MetaAnnotationListNode metaAnnotations)
    {
        this.before();
        AssertStatementNode node = factory.makeAssertStatementNode(testExpression, messageExpression, metaAnnotations);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a AssertStatementNode.
     * The specified start and stop locations are used.
     */
    @Override
    public AssertStatementNode makeAssertStatementNodeWithUnions(
            NodeUnion<? extends ExpressionNode> testExpression,
            NodeUnion<? extends ExpressionNode> messageExpression,
            NodeUnion<? extends MetaAnnotationListNode> metaAnnotations,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        AssertStatementNode node = factory.makeAssertStatementNodeWithUnions(testExpression, messageExpression, metaAnnotations, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a AssertStatementNode.
     * The specified start and stop locations are used.
     */
    @Override
    public AssertStatementNode makeAssertStatementNode(
            ExpressionNode testExpression,
            ExpressionNode messageExpression,
            MetaAnnotationListNode metaAnnotations,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        AssertStatementNode node = factory.makeAssertStatementNode(testExpression, messageExpression, metaAnnotations, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a AssertStatementNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public AssertStatementNode makeAssertStatementNode(
            ExpressionNode testExpression)
    {
        this.before();
        AssertStatementNode node = factory.makeAssertStatementNode(testExpression);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a AssertStatementNode.
     * The specified start and stop locations are used.
     */
    @Override
    public AssertStatementNode makeAssertStatementNode(
            ExpressionNode testExpression,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        AssertStatementNode node = factory.makeAssertStatementNode(testExpression, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a AssertStatementNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public AssertStatementNode makeAssertStatementNode(
            ExpressionNode testExpression,
            ExpressionNode messageExpression)
    {
        this.before();
        AssertStatementNode node = factory.makeAssertStatementNode(testExpression, messageExpression);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a AssertStatementNode.
     * The specified start and stop locations are used.
     */
    @Override
    public AssertStatementNode makeAssertStatementNode(
            ExpressionNode testExpression,
            ExpressionNode messageExpression,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        AssertStatementNode node = factory.makeAssertStatementNode(testExpression, messageExpression, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a AssignmentNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public AssignmentNode makeAssignmentNodeWithUnions(
            NodeUnion<? extends ExpressionNode> variable,
            AssignmentOperator operator,
            NodeUnion<? extends ExpressionNode> expression)
    {
        this.before();
        AssignmentNode node = factory.makeAssignmentNodeWithUnions(variable, operator, expression);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a AssignmentNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public AssignmentNode makeAssignmentNode(
            ExpressionNode variable,
            AssignmentOperator operator,
            ExpressionNode expression)
    {
        this.before();
        AssignmentNode node = factory.makeAssignmentNode(variable, operator, expression);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a AssignmentNode.
     * The specified start and stop locations are used.
     */
    @Override
    public AssignmentNode makeAssignmentNodeWithUnions(
            NodeUnion<? extends ExpressionNode> variable,
            AssignmentOperator operator,
            NodeUnion<? extends ExpressionNode> expression,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        AssignmentNode node = factory.makeAssignmentNodeWithUnions(variable, operator, expression, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a AssignmentNode.
     * The specified start and stop locations are used.
     */
    @Override
    public AssignmentNode makeAssignmentNode(
            ExpressionNode variable,
            AssignmentOperator operator,
            ExpressionNode expression,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        AssignmentNode node = factory.makeAssignmentNode(variable, operator, expression, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a BinaryExpressionNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public BinaryExpressionNode makeBinaryExpressionNodeWithUnions(
            NodeUnion<? extends ExpressionNode> leftOperand,
            NodeUnion<? extends ExpressionNode> rightOperand,
            BinaryOperator operator)
    {
        this.before();
        BinaryExpressionNode node = factory.makeBinaryExpressionNodeWithUnions(leftOperand, rightOperand, operator);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a BinaryExpressionNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public BinaryExpressionNode makeBinaryExpressionNode(
            ExpressionNode leftOperand,
            ExpressionNode rightOperand,
            BinaryOperator operator)
    {
        this.before();
        BinaryExpressionNode node = factory.makeBinaryExpressionNode(leftOperand, rightOperand, operator);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a BinaryExpressionNode.
     * The specified start and stop locations are used.
     */
    @Override
    public BinaryExpressionNode makeBinaryExpressionNodeWithUnions(
            NodeUnion<? extends ExpressionNode> leftOperand,
            NodeUnion<? extends ExpressionNode> rightOperand,
            BinaryOperator operator,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        BinaryExpressionNode node = factory.makeBinaryExpressionNodeWithUnions(leftOperand, rightOperand, operator, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a BinaryExpressionNode.
     * The specified start and stop locations are used.
     */
    @Override
    public BinaryExpressionNode makeBinaryExpressionNode(
            ExpressionNode leftOperand,
            ExpressionNode rightOperand,
            BinaryOperator operator,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        BinaryExpressionNode node = factory.makeBinaryExpressionNode(leftOperand, rightOperand, operator, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a BlockNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public BlockNode makeBlockNodeWithUnions(
            NodeUnion<? extends BlockStatementListNode> statements,
            NodeUnion<? extends MetaAnnotationListNode> metaAnnotations)
    {
        this.before();
        BlockNode node = factory.makeBlockNodeWithUnions(statements, metaAnnotations);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a BlockNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public BlockNode makeBlockNode(
            BlockStatementListNode statements,
            MetaAnnotationListNode metaAnnotations)
    {
        this.before();
        BlockNode node = factory.makeBlockNode(statements, metaAnnotations);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a BlockNode.
     * The specified start and stop locations are used.
     */
    @Override
    public BlockNode makeBlockNodeWithUnions(
            NodeUnion<? extends BlockStatementListNode> statements,
            NodeUnion<? extends MetaAnnotationListNode> metaAnnotations,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        BlockNode node = factory.makeBlockNodeWithUnions(statements, metaAnnotations, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a BlockNode.
     * The specified start and stop locations are used.
     */
    @Override
    public BlockNode makeBlockNode(
            BlockStatementListNode statements,
            MetaAnnotationListNode metaAnnotations,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        BlockNode node = factory.makeBlockNode(statements, metaAnnotations, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a BlockNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public BlockNode makeBlockNode(
            BlockStatementListNode statements)
    {
        this.before();
        BlockNode node = factory.makeBlockNode(statements);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a BlockNode.
     * The specified start and stop locations are used.
     */
    @Override
    public BlockNode makeBlockNode(
            BlockStatementListNode statements,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        BlockNode node = factory.makeBlockNode(statements, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a BlockStatementListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public BlockStatementListNode makeBlockStatementListNodeWithUnions(
            List<NodeUnion<? extends BlockStatementNode>> children)
    {
        this.before();
        BlockStatementListNode node = factory.makeBlockStatementListNodeWithUnions(children);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a BlockStatementListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public BlockStatementListNode makeBlockStatementListNode(
            List<BlockStatementNode> children)
    {
        this.before();
        BlockStatementListNode node = factory.makeBlockStatementListNode(children);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a BlockStatementListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public BlockStatementListNode makeBlockStatementListNode(
            BlockStatementNode... childrenElements)
    {
        this.before();
        BlockStatementListNode node = factory.makeBlockStatementListNode(childrenElements);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a BlockStatementListNode.
     * The specified start and stop locations are used.
     */
    @Override
    public BlockStatementListNode makeBlockStatementListNodeWithUnions(
            List<NodeUnion<? extends BlockStatementNode>> children,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        BlockStatementListNode node = factory.makeBlockStatementListNodeWithUnions(children, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a BlockStatementListNode.
     * The specified start and stop locations are used.
     */
    @Override
    public BlockStatementListNode makeBlockStatementListNode(
            List<BlockStatementNode> children,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        BlockStatementListNode node = factory.makeBlockStatementListNode(children, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a BlockStatementListNode.
     * The specified start and stop locations are used.
     */
    @Override
    public BlockStatementListNode makeBlockStatementListNode(
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation,
            BlockStatementNode... childrenElements)
    {
        this.before();
        BlockStatementListNode node = factory.makeBlockStatementListNode(startLocation, stopLocation, childrenElements);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a BlockStatementMetaprogramAnchorNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public BlockStatementMetaprogramAnchorNode makeBlockStatementMetaprogramAnchorNodeWithUnions(
            NodeUnion<? extends MetaprogramNode> metaprogram)
    {
        this.before();
        BlockStatementMetaprogramAnchorNode node = factory.makeBlockStatementMetaprogramAnchorNodeWithUnions(metaprogram);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a BlockStatementMetaprogramAnchorNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public BlockStatementMetaprogramAnchorNode makeBlockStatementMetaprogramAnchorNode(
            MetaprogramNode metaprogram)
    {
        this.before();
        BlockStatementMetaprogramAnchorNode node = factory.makeBlockStatementMetaprogramAnchorNode(metaprogram);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a BlockStatementMetaprogramAnchorNode.
     * The specified start and stop locations are used.
     */
    @Override
    public BlockStatementMetaprogramAnchorNode makeBlockStatementMetaprogramAnchorNodeWithUnions(
            NodeUnion<? extends MetaprogramNode> metaprogram,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        BlockStatementMetaprogramAnchorNode node = factory.makeBlockStatementMetaprogramAnchorNodeWithUnions(metaprogram, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a BlockStatementMetaprogramAnchorNode.
     * The specified start and stop locations are used.
     */
    @Override
    public BlockStatementMetaprogramAnchorNode makeBlockStatementMetaprogramAnchorNode(
            MetaprogramNode metaprogram,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        BlockStatementMetaprogramAnchorNode node = factory.makeBlockStatementMetaprogramAnchorNode(metaprogram, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a BooleanLiteralNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public BooleanLiteralNode makeBooleanLiteralNode(
            Boolean value)
    {
        this.before();
        BooleanLiteralNode node = factory.makeBooleanLiteralNode(value);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a BooleanLiteralNode.
     * The specified start and stop locations are used.
     */
    @Override
    public BooleanLiteralNode makeBooleanLiteralNode(
            Boolean value,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        BooleanLiteralNode node = factory.makeBooleanLiteralNode(value, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a BreakNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public BreakNode makeBreakNodeWithUnions(
            NodeUnion<? extends IdentifierNode> label,
            NodeUnion<? extends MetaAnnotationListNode> metaAnnotations)
    {
        this.before();
        BreakNode node = factory.makeBreakNodeWithUnions(label, metaAnnotations);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a BreakNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public BreakNode makeBreakNode(
            IdentifierNode label,
            MetaAnnotationListNode metaAnnotations)
    {
        this.before();
        BreakNode node = factory.makeBreakNode(label, metaAnnotations);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a BreakNode.
     * The specified start and stop locations are used.
     */
    @Override
    public BreakNode makeBreakNodeWithUnions(
            NodeUnion<? extends IdentifierNode> label,
            NodeUnion<? extends MetaAnnotationListNode> metaAnnotations,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        BreakNode node = factory.makeBreakNodeWithUnions(label, metaAnnotations, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a BreakNode.
     * The specified start and stop locations are used.
     */
    @Override
    public BreakNode makeBreakNode(
            IdentifierNode label,
            MetaAnnotationListNode metaAnnotations,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        BreakNode node = factory.makeBreakNode(label, metaAnnotations, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a BreakNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public BreakNode makeBreakNode()
    {
        this.before();
        BreakNode node = factory.makeBreakNode();
        this.after(node);
        return node;
    }
    
    /**
     * Creates a BreakNode.
     * The specified start and stop locations are used.
     */
    @Override
    public BreakNode makeBreakNode(
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        BreakNode node = factory.makeBreakNode(startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a BreakNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public BreakNode makeBreakNode(
            IdentifierNode label)
    {
        this.before();
        BreakNode node = factory.makeBreakNode(label);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a BreakNode.
     * The specified start and stop locations are used.
     */
    @Override
    public BreakNode makeBreakNode(
            IdentifierNode label,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        BreakNode node = factory.makeBreakNode(label, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a CaseListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public CaseListNode makeCaseListNodeWithUnions(
            List<NodeUnion<? extends CaseNode>> children)
    {
        this.before();
        CaseListNode node = factory.makeCaseListNodeWithUnions(children);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a CaseListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public CaseListNode makeCaseListNode(
            List<CaseNode> children)
    {
        this.before();
        CaseListNode node = factory.makeCaseListNode(children);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a CaseListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public CaseListNode makeCaseListNode(
            CaseNode... childrenElements)
    {
        this.before();
        CaseListNode node = factory.makeCaseListNode(childrenElements);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a CaseListNode.
     * The specified start and stop locations are used.
     */
    @Override
    public CaseListNode makeCaseListNodeWithUnions(
            List<NodeUnion<? extends CaseNode>> children,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        CaseListNode node = factory.makeCaseListNodeWithUnions(children, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a CaseListNode.
     * The specified start and stop locations are used.
     */
    @Override
    public CaseListNode makeCaseListNode(
            List<CaseNode> children,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        CaseListNode node = factory.makeCaseListNode(children, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a CaseListNode.
     * The specified start and stop locations are used.
     */
    @Override
    public CaseListNode makeCaseListNode(
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation,
            CaseNode... childrenElements)
    {
        this.before();
        CaseListNode node = factory.makeCaseListNode(startLocation, stopLocation, childrenElements);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a CaseNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public CaseNode makeCaseNodeWithUnions(
            NodeUnion<? extends ExpressionNode> expression,
            NodeUnion<? extends BlockStatementListNode> statements)
    {
        this.before();
        CaseNode node = factory.makeCaseNodeWithUnions(expression, statements);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a CaseNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public CaseNode makeCaseNode(
            ExpressionNode expression,
            BlockStatementListNode statements)
    {
        this.before();
        CaseNode node = factory.makeCaseNode(expression, statements);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a CaseNode.
     * The specified start and stop locations are used.
     */
    @Override
    public CaseNode makeCaseNodeWithUnions(
            NodeUnion<? extends ExpressionNode> expression,
            NodeUnion<? extends BlockStatementListNode> statements,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        CaseNode node = factory.makeCaseNodeWithUnions(expression, statements, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a CaseNode.
     * The specified start and stop locations are used.
     */
    @Override
    public CaseNode makeCaseNode(
            ExpressionNode expression,
            BlockStatementListNode statements,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        CaseNode node = factory.makeCaseNode(expression, statements, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a CatchListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public CatchListNode makeCatchListNodeWithUnions(
            List<NodeUnion<? extends CatchNode>> children)
    {
        this.before();
        CatchListNode node = factory.makeCatchListNodeWithUnions(children);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a CatchListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public CatchListNode makeCatchListNode(
            List<CatchNode> children)
    {
        this.before();
        CatchListNode node = factory.makeCatchListNode(children);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a CatchListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public CatchListNode makeCatchListNode(
            CatchNode... childrenElements)
    {
        this.before();
        CatchListNode node = factory.makeCatchListNode(childrenElements);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a CatchListNode.
     * The specified start and stop locations are used.
     */
    @Override
    public CatchListNode makeCatchListNodeWithUnions(
            List<NodeUnion<? extends CatchNode>> children,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        CatchListNode node = factory.makeCatchListNodeWithUnions(children, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a CatchListNode.
     * The specified start and stop locations are used.
     */
    @Override
    public CatchListNode makeCatchListNode(
            List<CatchNode> children,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        CatchListNode node = factory.makeCatchListNode(children, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a CatchListNode.
     * The specified start and stop locations are used.
     */
    @Override
    public CatchListNode makeCatchListNode(
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation,
            CatchNode... childrenElements)
    {
        this.before();
        CatchListNode node = factory.makeCatchListNode(startLocation, stopLocation, childrenElements);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a CatchNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public CatchNode makeCatchNodeWithUnions(
            NodeUnion<? extends BlockStatementListNode> body,
            NodeUnion<? extends VariableNode> parameter)
    {
        this.before();
        CatchNode node = factory.makeCatchNodeWithUnions(body, parameter);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a CatchNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public CatchNode makeCatchNode(
            BlockStatementListNode body,
            VariableNode parameter)
    {
        this.before();
        CatchNode node = factory.makeCatchNode(body, parameter);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a CatchNode.
     * The specified start and stop locations are used.
     */
    @Override
    public CatchNode makeCatchNodeWithUnions(
            NodeUnion<? extends BlockStatementListNode> body,
            NodeUnion<? extends VariableNode> parameter,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        CatchNode node = factory.makeCatchNodeWithUnions(body, parameter, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a CatchNode.
     * The specified start and stop locations are used.
     */
    @Override
    public CatchNode makeCatchNode(
            BlockStatementListNode body,
            VariableNode parameter,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        CatchNode node = factory.makeCatchNode(body, parameter, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a CharLiteralNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public CharLiteralNode makeCharLiteralNode(
            Character value)
    {
        this.before();
        CharLiteralNode node = factory.makeCharLiteralNode(value);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a CharLiteralNode.
     * The specified start and stop locations are used.
     */
    @Override
    public CharLiteralNode makeCharLiteralNode(
            Character value,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        CharLiteralNode node = factory.makeCharLiteralNode(value, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a ClassBodyNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public ClassBodyNode makeClassBodyNodeWithUnions(
            NodeUnion<? extends ClassMemberListNode> members)
    {
        this.before();
        ClassBodyNode node = factory.makeClassBodyNodeWithUnions(members);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a ClassBodyNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public ClassBodyNode makeClassBodyNode(
            ClassMemberListNode members)
    {
        this.before();
        ClassBodyNode node = factory.makeClassBodyNode(members);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a ClassBodyNode.
     * The specified start and stop locations are used.
     */
    @Override
    public ClassBodyNode makeClassBodyNodeWithUnions(
            NodeUnion<? extends ClassMemberListNode> members,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        ClassBodyNode node = factory.makeClassBodyNodeWithUnions(members, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a ClassBodyNode.
     * The specified start and stop locations are used.
     */
    @Override
    public ClassBodyNode makeClassBodyNode(
            ClassMemberListNode members,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        ClassBodyNode node = factory.makeClassBodyNode(members, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a ClassDeclarationNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public ClassDeclarationNode makeClassDeclarationNodeWithUnions(
            NodeUnion<? extends ClassModifiersNode> modifiers,
            NodeUnion<? extends DeclaredTypeNode> extendsClause,
            NodeUnion<? extends DeclaredTypeListNode> implementsClause,
            NodeUnion<? extends ClassBodyNode> body,
            NodeUnion<? extends TypeParameterListNode> typeParameters,
            NodeUnion<? extends IdentifierNode> identifier,
            NodeUnion<? extends JavadocNode> javadoc)
    {
        this.before();
        ClassDeclarationNode node = factory.makeClassDeclarationNodeWithUnions(modifiers, extendsClause, implementsClause, body, typeParameters, identifier, javadoc);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a ClassDeclarationNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public ClassDeclarationNode makeClassDeclarationNode(
            ClassModifiersNode modifiers,
            DeclaredTypeNode extendsClause,
            DeclaredTypeListNode implementsClause,
            ClassBodyNode body,
            TypeParameterListNode typeParameters,
            IdentifierNode identifier,
            JavadocNode javadoc)
    {
        this.before();
        ClassDeclarationNode node = factory.makeClassDeclarationNode(modifiers, extendsClause, implementsClause, body, typeParameters, identifier, javadoc);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a ClassDeclarationNode.
     * The specified start and stop locations are used.
     */
    @Override
    public ClassDeclarationNode makeClassDeclarationNodeWithUnions(
            NodeUnion<? extends ClassModifiersNode> modifiers,
            NodeUnion<? extends DeclaredTypeNode> extendsClause,
            NodeUnion<? extends DeclaredTypeListNode> implementsClause,
            NodeUnion<? extends ClassBodyNode> body,
            NodeUnion<? extends TypeParameterListNode> typeParameters,
            NodeUnion<? extends IdentifierNode> identifier,
            NodeUnion<? extends JavadocNode> javadoc,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        ClassDeclarationNode node = factory.makeClassDeclarationNodeWithUnions(modifiers, extendsClause, implementsClause, body, typeParameters, identifier, javadoc, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a ClassDeclarationNode.
     * The specified start and stop locations are used.
     */
    @Override
    public ClassDeclarationNode makeClassDeclarationNode(
            ClassModifiersNode modifiers,
            DeclaredTypeNode extendsClause,
            DeclaredTypeListNode implementsClause,
            ClassBodyNode body,
            TypeParameterListNode typeParameters,
            IdentifierNode identifier,
            JavadocNode javadoc,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        ClassDeclarationNode node = factory.makeClassDeclarationNode(modifiers, extendsClause, implementsClause, body, typeParameters, identifier, javadoc, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a ClassLiteralNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public ClassLiteralNode makeClassLiteralNodeWithUnions(
            NodeUnion<? extends LiteralizableTypeNode> value)
    {
        this.before();
        ClassLiteralNode node = factory.makeClassLiteralNodeWithUnions(value);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a ClassLiteralNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public ClassLiteralNode makeClassLiteralNode(
            LiteralizableTypeNode value)
    {
        this.before();
        ClassLiteralNode node = factory.makeClassLiteralNode(value);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a ClassLiteralNode.
     * The specified start and stop locations are used.
     */
    @Override
    public ClassLiteralNode makeClassLiteralNodeWithUnions(
            NodeUnion<? extends LiteralizableTypeNode> value,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        ClassLiteralNode node = factory.makeClassLiteralNodeWithUnions(value, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a ClassLiteralNode.
     * The specified start and stop locations are used.
     */
    @Override
    public ClassLiteralNode makeClassLiteralNode(
            LiteralizableTypeNode value,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        ClassLiteralNode node = factory.makeClassLiteralNode(value, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a ClassMemberListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public ClassMemberListNode makeClassMemberListNodeWithUnions(
            List<NodeUnion<? extends ClassMemberNode>> children)
    {
        this.before();
        ClassMemberListNode node = factory.makeClassMemberListNodeWithUnions(children);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a ClassMemberListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public ClassMemberListNode makeClassMemberListNode(
            List<ClassMemberNode> children)
    {
        this.before();
        ClassMemberListNode node = factory.makeClassMemberListNode(children);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a ClassMemberListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public ClassMemberListNode makeClassMemberListNode(
            ClassMemberNode... childrenElements)
    {
        this.before();
        ClassMemberListNode node = factory.makeClassMemberListNode(childrenElements);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a ClassMemberListNode.
     * The specified start and stop locations are used.
     */
    @Override
    public ClassMemberListNode makeClassMemberListNodeWithUnions(
            List<NodeUnion<? extends ClassMemberNode>> children,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        ClassMemberListNode node = factory.makeClassMemberListNodeWithUnions(children, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a ClassMemberListNode.
     * The specified start and stop locations are used.
     */
    @Override
    public ClassMemberListNode makeClassMemberListNode(
            List<ClassMemberNode> children,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        ClassMemberListNode node = factory.makeClassMemberListNode(children, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a ClassMemberListNode.
     * The specified start and stop locations are used.
     */
    @Override
    public ClassMemberListNode makeClassMemberListNode(
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation,
            ClassMemberNode... childrenElements)
    {
        this.before();
        ClassMemberListNode node = factory.makeClassMemberListNode(startLocation, stopLocation, childrenElements);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a ClassMemberMetaprogramAnchorNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public ClassMemberMetaprogramAnchorNode makeClassMemberMetaprogramAnchorNodeWithUnions(
            NodeUnion<? extends MetaprogramNode> metaprogram)
    {
        this.before();
        ClassMemberMetaprogramAnchorNode node = factory.makeClassMemberMetaprogramAnchorNodeWithUnions(metaprogram);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a ClassMemberMetaprogramAnchorNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public ClassMemberMetaprogramAnchorNode makeClassMemberMetaprogramAnchorNode(
            MetaprogramNode metaprogram)
    {
        this.before();
        ClassMemberMetaprogramAnchorNode node = factory.makeClassMemberMetaprogramAnchorNode(metaprogram);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a ClassMemberMetaprogramAnchorNode.
     * The specified start and stop locations are used.
     */
    @Override
    public ClassMemberMetaprogramAnchorNode makeClassMemberMetaprogramAnchorNodeWithUnions(
            NodeUnion<? extends MetaprogramNode> metaprogram,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        ClassMemberMetaprogramAnchorNode node = factory.makeClassMemberMetaprogramAnchorNodeWithUnions(metaprogram, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a ClassMemberMetaprogramAnchorNode.
     * The specified start and stop locations are used.
     */
    @Override
    public ClassMemberMetaprogramAnchorNode makeClassMemberMetaprogramAnchorNode(
            MetaprogramNode metaprogram,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        ClassMemberMetaprogramAnchorNode node = factory.makeClassMemberMetaprogramAnchorNode(metaprogram, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a ClassModifiersNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public ClassModifiersNode makeClassModifiersNodeWithUnions(
            AccessModifier access,
            boolean abstractFlag,
            boolean staticFlag,
            boolean finalFlag,
            boolean strictfpFlag,
            NodeUnion<? extends MetaAnnotationListNode> metaAnnotations,
            NodeUnion<? extends AnnotationListNode> annotations)
    {
        this.before();
        ClassModifiersNode node = factory.makeClassModifiersNodeWithUnions(access, abstractFlag, staticFlag, finalFlag, strictfpFlag, metaAnnotations, annotations);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a ClassModifiersNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public ClassModifiersNode makeClassModifiersNode(
            AccessModifier access,
            boolean abstractFlag,
            boolean staticFlag,
            boolean finalFlag,
            boolean strictfpFlag,
            MetaAnnotationListNode metaAnnotations,
            AnnotationListNode annotations)
    {
        this.before();
        ClassModifiersNode node = factory.makeClassModifiersNode(access, abstractFlag, staticFlag, finalFlag, strictfpFlag, metaAnnotations, annotations);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a ClassModifiersNode.
     * The specified start and stop locations are used.
     */
    @Override
    public ClassModifiersNode makeClassModifiersNodeWithUnions(
            AccessModifier access,
            boolean abstractFlag,
            boolean staticFlag,
            boolean finalFlag,
            boolean strictfpFlag,
            NodeUnion<? extends MetaAnnotationListNode> metaAnnotations,
            NodeUnion<? extends AnnotationListNode> annotations,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        ClassModifiersNode node = factory.makeClassModifiersNodeWithUnions(access, abstractFlag, staticFlag, finalFlag, strictfpFlag, metaAnnotations, annotations, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a ClassModifiersNode.
     * The specified start and stop locations are used.
     */
    @Override
    public ClassModifiersNode makeClassModifiersNode(
            AccessModifier access,
            boolean abstractFlag,
            boolean staticFlag,
            boolean finalFlag,
            boolean strictfpFlag,
            MetaAnnotationListNode metaAnnotations,
            AnnotationListNode annotations,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        ClassModifiersNode node = factory.makeClassModifiersNode(access, abstractFlag, staticFlag, finalFlag, strictfpFlag, metaAnnotations, annotations, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a ClassModifiersNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public ClassModifiersNode makeClassModifiersNode(
            AccessModifier access)
    {
        this.before();
        ClassModifiersNode node = factory.makeClassModifiersNode(access);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a ClassModifiersNode.
     * The specified start and stop locations are used.
     */
    @Override
    public ClassModifiersNode makeClassModifiersNode(
            AccessModifier access,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        ClassModifiersNode node = factory.makeClassModifiersNode(access, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a CodeLiteralNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public CodeLiteralNode makeCodeLiteralNodeWithUnions(
            NodeUnion<? extends Node> value)
    {
        this.before();
        CodeLiteralNode node = factory.makeCodeLiteralNodeWithUnions(value);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a CodeLiteralNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public CodeLiteralNode makeCodeLiteralNode(
            Node value)
    {
        this.before();
        CodeLiteralNode node = factory.makeCodeLiteralNode(value);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a CodeLiteralNode.
     * The specified start and stop locations are used.
     */
    @Override
    public CodeLiteralNode makeCodeLiteralNodeWithUnions(
            NodeUnion<? extends Node> value,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        CodeLiteralNode node = factory.makeCodeLiteralNodeWithUnions(value, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a CodeLiteralNode.
     * The specified start and stop locations are used.
     */
    @Override
    public CodeLiteralNode makeCodeLiteralNode(
            Node value,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        CodeLiteralNode node = factory.makeCodeLiteralNode(value, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a CompilationUnitNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public CompilationUnitNode makeCompilationUnitNodeWithUnions(
            String name,
            NodeUnion<? extends PackageDeclarationNode> packageDeclaration,
            NodeUnion<? extends MetaprogramImportListNode> metaimports,
            NodeUnion<? extends ImportListNode> imports,
            NodeUnion<? extends TypeDeclarationListNode> typeDecls)
    {
        this.before();
        CompilationUnitNode node = factory.makeCompilationUnitNodeWithUnions(name, packageDeclaration, metaimports, imports, typeDecls);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a CompilationUnitNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public CompilationUnitNode makeCompilationUnitNode(
            String name,
            PackageDeclarationNode packageDeclaration,
            MetaprogramImportListNode metaimports,
            ImportListNode imports,
            TypeDeclarationListNode typeDecls)
    {
        this.before();
        CompilationUnitNode node = factory.makeCompilationUnitNode(name, packageDeclaration, metaimports, imports, typeDecls);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a CompilationUnitNode.
     * The specified start and stop locations are used.
     */
    @Override
    public CompilationUnitNode makeCompilationUnitNodeWithUnions(
            String name,
            NodeUnion<? extends PackageDeclarationNode> packageDeclaration,
            NodeUnion<? extends MetaprogramImportListNode> metaimports,
            NodeUnion<? extends ImportListNode> imports,
            NodeUnion<? extends TypeDeclarationListNode> typeDecls,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        CompilationUnitNode node = factory.makeCompilationUnitNodeWithUnions(name, packageDeclaration, metaimports, imports, typeDecls, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a CompilationUnitNode.
     * The specified start and stop locations are used.
     */
    @Override
    public CompilationUnitNode makeCompilationUnitNode(
            String name,
            PackageDeclarationNode packageDeclaration,
            MetaprogramImportListNode metaimports,
            ImportListNode imports,
            TypeDeclarationListNode typeDecls,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        CompilationUnitNode node = factory.makeCompilationUnitNode(name, packageDeclaration, metaimports, imports, typeDecls, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a CompilationUnitNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public CompilationUnitNode makeCompilationUnitNode(
            String name,
            PackageDeclarationNode packageDeclaration,
            ImportListNode imports,
            TypeDeclarationListNode typeDecls)
    {
        this.before();
        CompilationUnitNode node = factory.makeCompilationUnitNode(name, packageDeclaration, imports, typeDecls);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a CompilationUnitNode.
     * The specified start and stop locations are used.
     */
    @Override
    public CompilationUnitNode makeCompilationUnitNode(
            String name,
            PackageDeclarationNode packageDeclaration,
            ImportListNode imports,
            TypeDeclarationListNode typeDecls,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        CompilationUnitNode node = factory.makeCompilationUnitNode(name, packageDeclaration, imports, typeDecls, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a ConditionalExpressionNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public ConditionalExpressionNode makeConditionalExpressionNodeWithUnions(
            NodeUnion<? extends ExpressionNode> condition,
            NodeUnion<? extends ExpressionNode> trueExpression,
            NodeUnion<? extends ExpressionNode> falseExpression)
    {
        this.before();
        ConditionalExpressionNode node = factory.makeConditionalExpressionNodeWithUnions(condition, trueExpression, falseExpression);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a ConditionalExpressionNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public ConditionalExpressionNode makeConditionalExpressionNode(
            ExpressionNode condition,
            ExpressionNode trueExpression,
            ExpressionNode falseExpression)
    {
        this.before();
        ConditionalExpressionNode node = factory.makeConditionalExpressionNode(condition, trueExpression, falseExpression);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a ConditionalExpressionNode.
     * The specified start and stop locations are used.
     */
    @Override
    public ConditionalExpressionNode makeConditionalExpressionNodeWithUnions(
            NodeUnion<? extends ExpressionNode> condition,
            NodeUnion<? extends ExpressionNode> trueExpression,
            NodeUnion<? extends ExpressionNode> falseExpression,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        ConditionalExpressionNode node = factory.makeConditionalExpressionNodeWithUnions(condition, trueExpression, falseExpression, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a ConditionalExpressionNode.
     * The specified start and stop locations are used.
     */
    @Override
    public ConditionalExpressionNode makeConditionalExpressionNode(
            ExpressionNode condition,
            ExpressionNode trueExpression,
            ExpressionNode falseExpression,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        ConditionalExpressionNode node = factory.makeConditionalExpressionNode(condition, trueExpression, falseExpression, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a ConstantDeclarationNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public ConstantDeclarationNode makeConstantDeclarationNodeWithUnions(
            NodeUnion<? extends ConstantModifiersNode> modifiers,
            NodeUnion<? extends TypeNode> type,
            NodeUnion<? extends VariableDeclaratorListNode> declarators,
            NodeUnion<? extends JavadocNode> javadoc)
    {
        this.before();
        ConstantDeclarationNode node = factory.makeConstantDeclarationNodeWithUnions(modifiers, type, declarators, javadoc);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a ConstantDeclarationNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public ConstantDeclarationNode makeConstantDeclarationNode(
            ConstantModifiersNode modifiers,
            TypeNode type,
            VariableDeclaratorListNode declarators,
            JavadocNode javadoc)
    {
        this.before();
        ConstantDeclarationNode node = factory.makeConstantDeclarationNode(modifiers, type, declarators, javadoc);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a ConstantDeclarationNode.
     * The specified start and stop locations are used.
     */
    @Override
    public ConstantDeclarationNode makeConstantDeclarationNodeWithUnions(
            NodeUnion<? extends ConstantModifiersNode> modifiers,
            NodeUnion<? extends TypeNode> type,
            NodeUnion<? extends VariableDeclaratorListNode> declarators,
            NodeUnion<? extends JavadocNode> javadoc,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        ConstantDeclarationNode node = factory.makeConstantDeclarationNodeWithUnions(modifiers, type, declarators, javadoc, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a ConstantDeclarationNode.
     * The specified start and stop locations are used.
     */
    @Override
    public ConstantDeclarationNode makeConstantDeclarationNode(
            ConstantModifiersNode modifiers,
            TypeNode type,
            VariableDeclaratorListNode declarators,
            JavadocNode javadoc,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        ConstantDeclarationNode node = factory.makeConstantDeclarationNode(modifiers, type, declarators, javadoc, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a ConstantModifiersNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public ConstantModifiersNode makeConstantModifiersNodeWithUnions(
            NodeUnion<? extends MetaAnnotationListNode> metaAnnotations,
            NodeUnion<? extends AnnotationListNode> annotations)
    {
        this.before();
        ConstantModifiersNode node = factory.makeConstantModifiersNodeWithUnions(metaAnnotations, annotations);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a ConstantModifiersNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public ConstantModifiersNode makeConstantModifiersNode(
            MetaAnnotationListNode metaAnnotations,
            AnnotationListNode annotations)
    {
        this.before();
        ConstantModifiersNode node = factory.makeConstantModifiersNode(metaAnnotations, annotations);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a ConstantModifiersNode.
     * The specified start and stop locations are used.
     */
    @Override
    public ConstantModifiersNode makeConstantModifiersNodeWithUnions(
            NodeUnion<? extends MetaAnnotationListNode> metaAnnotations,
            NodeUnion<? extends AnnotationListNode> annotations,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        ConstantModifiersNode node = factory.makeConstantModifiersNodeWithUnions(metaAnnotations, annotations, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a ConstantModifiersNode.
     * The specified start and stop locations are used.
     */
    @Override
    public ConstantModifiersNode makeConstantModifiersNode(
            MetaAnnotationListNode metaAnnotations,
            AnnotationListNode annotations,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        ConstantModifiersNode node = factory.makeConstantModifiersNode(metaAnnotations, annotations, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a ConstantModifiersNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public ConstantModifiersNode makeConstantModifiersNode(
    )
    {
        this.before();
        ConstantModifiersNode node = factory.makeConstantModifiersNode();
        this.after(node);
        return node;
    }
    
    /**
     * Creates a ConstantModifiersNode.
     * The specified start and stop locations are used.
     */
    @Override
    public ConstantModifiersNode makeConstantModifiersNode(
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        ConstantModifiersNode node = factory.makeConstantModifiersNode(startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a ConstructorBodyNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public ConstructorBodyNode makeConstructorBodyNodeWithUnions(
            NodeUnion<? extends ConstructorInvocationNode> constructorInvocation,
            NodeUnion<? extends BlockStatementListNode> statements)
    {
        this.before();
        ConstructorBodyNode node = factory.makeConstructorBodyNodeWithUnions(constructorInvocation, statements);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a ConstructorBodyNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public ConstructorBodyNode makeConstructorBodyNode(
            ConstructorInvocationNode constructorInvocation,
            BlockStatementListNode statements)
    {
        this.before();
        ConstructorBodyNode node = factory.makeConstructorBodyNode(constructorInvocation, statements);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a ConstructorBodyNode.
     * The specified start and stop locations are used.
     */
    @Override
    public ConstructorBodyNode makeConstructorBodyNodeWithUnions(
            NodeUnion<? extends ConstructorInvocationNode> constructorInvocation,
            NodeUnion<? extends BlockStatementListNode> statements,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        ConstructorBodyNode node = factory.makeConstructorBodyNodeWithUnions(constructorInvocation, statements, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a ConstructorBodyNode.
     * The specified start and stop locations are used.
     */
    @Override
    public ConstructorBodyNode makeConstructorBodyNode(
            ConstructorInvocationNode constructorInvocation,
            BlockStatementListNode statements,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        ConstructorBodyNode node = factory.makeConstructorBodyNode(constructorInvocation, statements, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a ConstructorDeclarationNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public ConstructorDeclarationNode makeConstructorDeclarationNodeWithUnions(
            NodeUnion<? extends IdentifierNode> identifier,
            NodeUnion<? extends ConstructorBodyNode> body,
            NodeUnion<? extends ConstructorModifiersNode> modifiers,
            NodeUnion<? extends VariableListNode> parameters,
            NodeUnion<? extends VariableNode> varargParameter,
            NodeUnion<? extends UnparameterizedTypeListNode> throwTypes,
            NodeUnion<? extends TypeParameterListNode> typeParameters,
            NodeUnion<? extends JavadocNode> javadoc)
    {
        this.before();
        ConstructorDeclarationNode node = factory.makeConstructorDeclarationNodeWithUnions(identifier, body, modifiers, parameters, varargParameter, throwTypes, typeParameters, javadoc);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a ConstructorDeclarationNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public ConstructorDeclarationNode makeConstructorDeclarationNode(
            IdentifierNode identifier,
            ConstructorBodyNode body,
            ConstructorModifiersNode modifiers,
            VariableListNode parameters,
            VariableNode varargParameter,
            UnparameterizedTypeListNode throwTypes,
            TypeParameterListNode typeParameters,
            JavadocNode javadoc)
    {
        this.before();
        ConstructorDeclarationNode node = factory.makeConstructorDeclarationNode(identifier, body, modifiers, parameters, varargParameter, throwTypes, typeParameters, javadoc);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a ConstructorDeclarationNode.
     * The specified start and stop locations are used.
     */
    @Override
    public ConstructorDeclarationNode makeConstructorDeclarationNodeWithUnions(
            NodeUnion<? extends IdentifierNode> identifier,
            NodeUnion<? extends ConstructorBodyNode> body,
            NodeUnion<? extends ConstructorModifiersNode> modifiers,
            NodeUnion<? extends VariableListNode> parameters,
            NodeUnion<? extends VariableNode> varargParameter,
            NodeUnion<? extends UnparameterizedTypeListNode> throwTypes,
            NodeUnion<? extends TypeParameterListNode> typeParameters,
            NodeUnion<? extends JavadocNode> javadoc,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        ConstructorDeclarationNode node = factory.makeConstructorDeclarationNodeWithUnions(identifier, body, modifiers, parameters, varargParameter, throwTypes, typeParameters, javadoc, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a ConstructorDeclarationNode.
     * The specified start and stop locations are used.
     */
    @Override
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
            BsjSourceLocation stopLocation)
    {
        this.before();
        ConstructorDeclarationNode node = factory.makeConstructorDeclarationNode(identifier, body, modifiers, parameters, varargParameter, throwTypes, typeParameters, javadoc, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a ConstructorDeclarationNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public ConstructorDeclarationNode makeConstructorDeclarationNode(
            IdentifierNode identifier,
            ConstructorBodyNode body,
            ConstructorModifiersNode modifiers,
            VariableListNode parameters,
            JavadocNode javadoc)
    {
        this.before();
        ConstructorDeclarationNode node = factory.makeConstructorDeclarationNode(identifier, body, modifiers, parameters, javadoc);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a ConstructorDeclarationNode.
     * The specified start and stop locations are used.
     */
    @Override
    public ConstructorDeclarationNode makeConstructorDeclarationNode(
            IdentifierNode identifier,
            ConstructorBodyNode body,
            ConstructorModifiersNode modifiers,
            VariableListNode parameters,
            JavadocNode javadoc,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        ConstructorDeclarationNode node = factory.makeConstructorDeclarationNode(identifier, body, modifiers, parameters, javadoc, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a ConstructorModifiersNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public ConstructorModifiersNode makeConstructorModifiersNodeWithUnions(
            AccessModifier access,
            NodeUnion<? extends MetaAnnotationListNode> metaAnnotations,
            NodeUnion<? extends AnnotationListNode> annotations)
    {
        this.before();
        ConstructorModifiersNode node = factory.makeConstructorModifiersNodeWithUnions(access, metaAnnotations, annotations);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a ConstructorModifiersNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public ConstructorModifiersNode makeConstructorModifiersNode(
            AccessModifier access,
            MetaAnnotationListNode metaAnnotations,
            AnnotationListNode annotations)
    {
        this.before();
        ConstructorModifiersNode node = factory.makeConstructorModifiersNode(access, metaAnnotations, annotations);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a ConstructorModifiersNode.
     * The specified start and stop locations are used.
     */
    @Override
    public ConstructorModifiersNode makeConstructorModifiersNodeWithUnions(
            AccessModifier access,
            NodeUnion<? extends MetaAnnotationListNode> metaAnnotations,
            NodeUnion<? extends AnnotationListNode> annotations,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        ConstructorModifiersNode node = factory.makeConstructorModifiersNodeWithUnions(access, metaAnnotations, annotations, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a ConstructorModifiersNode.
     * The specified start and stop locations are used.
     */
    @Override
    public ConstructorModifiersNode makeConstructorModifiersNode(
            AccessModifier access,
            MetaAnnotationListNode metaAnnotations,
            AnnotationListNode annotations,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        ConstructorModifiersNode node = factory.makeConstructorModifiersNode(access, metaAnnotations, annotations, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a ConstructorModifiersNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public ConstructorModifiersNode makeConstructorModifiersNode(
            AccessModifier access)
    {
        this.before();
        ConstructorModifiersNode node = factory.makeConstructorModifiersNode(access);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a ConstructorModifiersNode.
     * The specified start and stop locations are used.
     */
    @Override
    public ConstructorModifiersNode makeConstructorModifiersNode(
            AccessModifier access,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        ConstructorModifiersNode node = factory.makeConstructorModifiersNode(access, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a ContinueNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public ContinueNode makeContinueNodeWithUnions(
            NodeUnion<? extends IdentifierNode> label,
            NodeUnion<? extends MetaAnnotationListNode> metaAnnotations)
    {
        this.before();
        ContinueNode node = factory.makeContinueNodeWithUnions(label, metaAnnotations);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a ContinueNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public ContinueNode makeContinueNode(
            IdentifierNode label,
            MetaAnnotationListNode metaAnnotations)
    {
        this.before();
        ContinueNode node = factory.makeContinueNode(label, metaAnnotations);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a ContinueNode.
     * The specified start and stop locations are used.
     */
    @Override
    public ContinueNode makeContinueNodeWithUnions(
            NodeUnion<? extends IdentifierNode> label,
            NodeUnion<? extends MetaAnnotationListNode> metaAnnotations,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        ContinueNode node = factory.makeContinueNodeWithUnions(label, metaAnnotations, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a ContinueNode.
     * The specified start and stop locations are used.
     */
    @Override
    public ContinueNode makeContinueNode(
            IdentifierNode label,
            MetaAnnotationListNode metaAnnotations,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        ContinueNode node = factory.makeContinueNode(label, metaAnnotations, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a ContinueNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public ContinueNode makeContinueNode()
    {
        this.before();
        ContinueNode node = factory.makeContinueNode();
        this.after(node);
        return node;
    }
    
    /**
     * Creates a ContinueNode.
     * The specified start and stop locations are used.
     */
    @Override
    public ContinueNode makeContinueNode(
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        ContinueNode node = factory.makeContinueNode(startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a ContinueNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public ContinueNode makeContinueNode(
            IdentifierNode label)
    {
        this.before();
        ContinueNode node = factory.makeContinueNode(label);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a ContinueNode.
     * The specified start and stop locations are used.
     */
    @Override
    public ContinueNode makeContinueNode(
            IdentifierNode label,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        ContinueNode node = factory.makeContinueNode(label, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a DeclaredTypeListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public DeclaredTypeListNode makeDeclaredTypeListNodeWithUnions(
            List<NodeUnion<? extends DeclaredTypeNode>> children)
    {
        this.before();
        DeclaredTypeListNode node = factory.makeDeclaredTypeListNodeWithUnions(children);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a DeclaredTypeListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public DeclaredTypeListNode makeDeclaredTypeListNode(
            List<DeclaredTypeNode> children)
    {
        this.before();
        DeclaredTypeListNode node = factory.makeDeclaredTypeListNode(children);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a DeclaredTypeListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public DeclaredTypeListNode makeDeclaredTypeListNode(
            DeclaredTypeNode... childrenElements)
    {
        this.before();
        DeclaredTypeListNode node = factory.makeDeclaredTypeListNode(childrenElements);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a DeclaredTypeListNode.
     * The specified start and stop locations are used.
     */
    @Override
    public DeclaredTypeListNode makeDeclaredTypeListNodeWithUnions(
            List<NodeUnion<? extends DeclaredTypeNode>> children,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        DeclaredTypeListNode node = factory.makeDeclaredTypeListNodeWithUnions(children, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a DeclaredTypeListNode.
     * The specified start and stop locations are used.
     */
    @Override
    public DeclaredTypeListNode makeDeclaredTypeListNode(
            List<DeclaredTypeNode> children,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        DeclaredTypeListNode node = factory.makeDeclaredTypeListNode(children, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a DeclaredTypeListNode.
     * The specified start and stop locations are used.
     */
    @Override
    public DeclaredTypeListNode makeDeclaredTypeListNode(
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation,
            DeclaredTypeNode... childrenElements)
    {
        this.before();
        DeclaredTypeListNode node = factory.makeDeclaredTypeListNode(startLocation, stopLocation, childrenElements);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a DoWhileLoopNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public DoWhileLoopNode makeDoWhileLoopNodeWithUnions(
            NodeUnion<? extends ExpressionNode> condition,
            NodeUnion<? extends StatementNode> statement,
            NodeUnion<? extends MetaAnnotationListNode> metaAnnotations)
    {
        this.before();
        DoWhileLoopNode node = factory.makeDoWhileLoopNodeWithUnions(condition, statement, metaAnnotations);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a DoWhileLoopNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public DoWhileLoopNode makeDoWhileLoopNode(
            ExpressionNode condition,
            StatementNode statement,
            MetaAnnotationListNode metaAnnotations)
    {
        this.before();
        DoWhileLoopNode node = factory.makeDoWhileLoopNode(condition, statement, metaAnnotations);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a DoWhileLoopNode.
     * The specified start and stop locations are used.
     */
    @Override
    public DoWhileLoopNode makeDoWhileLoopNodeWithUnions(
            NodeUnion<? extends ExpressionNode> condition,
            NodeUnion<? extends StatementNode> statement,
            NodeUnion<? extends MetaAnnotationListNode> metaAnnotations,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        DoWhileLoopNode node = factory.makeDoWhileLoopNodeWithUnions(condition, statement, metaAnnotations, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a DoWhileLoopNode.
     * The specified start and stop locations are used.
     */
    @Override
    public DoWhileLoopNode makeDoWhileLoopNode(
            ExpressionNode condition,
            StatementNode statement,
            MetaAnnotationListNode metaAnnotations,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        DoWhileLoopNode node = factory.makeDoWhileLoopNode(condition, statement, metaAnnotations, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a DoWhileLoopNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public DoWhileLoopNode makeDoWhileLoopNode(
            ExpressionNode condition,
            StatementNode statement)
    {
        this.before();
        DoWhileLoopNode node = factory.makeDoWhileLoopNode(condition, statement);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a DoWhileLoopNode.
     * The specified start and stop locations are used.
     */
    @Override
    public DoWhileLoopNode makeDoWhileLoopNode(
            ExpressionNode condition,
            StatementNode statement,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        DoWhileLoopNode node = factory.makeDoWhileLoopNode(condition, statement, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a DoubleLiteralNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public DoubleLiteralNode makeDoubleLiteralNode(
            Double value)
    {
        this.before();
        DoubleLiteralNode node = factory.makeDoubleLiteralNode(value);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a DoubleLiteralNode.
     * The specified start and stop locations are used.
     */
    @Override
    public DoubleLiteralNode makeDoubleLiteralNode(
            Double value,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        DoubleLiteralNode node = factory.makeDoubleLiteralNode(value, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a EnhancedForLoopNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public EnhancedForLoopNode makeEnhancedForLoopNodeWithUnions(
            NodeUnion<? extends VariableNode> variable,
            NodeUnion<? extends ExpressionNode> expression,
            NodeUnion<? extends StatementNode> statement,
            NodeUnion<? extends MetaAnnotationListNode> metaAnnotations)
    {
        this.before();
        EnhancedForLoopNode node = factory.makeEnhancedForLoopNodeWithUnions(variable, expression, statement, metaAnnotations);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a EnhancedForLoopNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public EnhancedForLoopNode makeEnhancedForLoopNode(
            VariableNode variable,
            ExpressionNode expression,
            StatementNode statement,
            MetaAnnotationListNode metaAnnotations)
    {
        this.before();
        EnhancedForLoopNode node = factory.makeEnhancedForLoopNode(variable, expression, statement, metaAnnotations);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a EnhancedForLoopNode.
     * The specified start and stop locations are used.
     */
    @Override
    public EnhancedForLoopNode makeEnhancedForLoopNodeWithUnions(
            NodeUnion<? extends VariableNode> variable,
            NodeUnion<? extends ExpressionNode> expression,
            NodeUnion<? extends StatementNode> statement,
            NodeUnion<? extends MetaAnnotationListNode> metaAnnotations,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        EnhancedForLoopNode node = factory.makeEnhancedForLoopNodeWithUnions(variable, expression, statement, metaAnnotations, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a EnhancedForLoopNode.
     * The specified start and stop locations are used.
     */
    @Override
    public EnhancedForLoopNode makeEnhancedForLoopNode(
            VariableNode variable,
            ExpressionNode expression,
            StatementNode statement,
            MetaAnnotationListNode metaAnnotations,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        EnhancedForLoopNode node = factory.makeEnhancedForLoopNode(variable, expression, statement, metaAnnotations, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a EnhancedForLoopNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public EnhancedForLoopNode makeEnhancedForLoopNode(
            VariableNode variable,
            ExpressionNode expression,
            StatementNode statement)
    {
        this.before();
        EnhancedForLoopNode node = factory.makeEnhancedForLoopNode(variable, expression, statement);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a EnhancedForLoopNode.
     * The specified start and stop locations are used.
     */
    @Override
    public EnhancedForLoopNode makeEnhancedForLoopNode(
            VariableNode variable,
            ExpressionNode expression,
            StatementNode statement,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        EnhancedForLoopNode node = factory.makeEnhancedForLoopNode(variable, expression, statement, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a EnumBodyNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public EnumBodyNode makeEnumBodyNodeWithUnions(
            NodeUnion<? extends EnumConstantDeclarationListNode> constants,
            NodeUnion<? extends ClassMemberListNode> members)
    {
        this.before();
        EnumBodyNode node = factory.makeEnumBodyNodeWithUnions(constants, members);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a EnumBodyNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public EnumBodyNode makeEnumBodyNode(
            EnumConstantDeclarationListNode constants,
            ClassMemberListNode members)
    {
        this.before();
        EnumBodyNode node = factory.makeEnumBodyNode(constants, members);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a EnumBodyNode.
     * The specified start and stop locations are used.
     */
    @Override
    public EnumBodyNode makeEnumBodyNodeWithUnions(
            NodeUnion<? extends EnumConstantDeclarationListNode> constants,
            NodeUnion<? extends ClassMemberListNode> members,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        EnumBodyNode node = factory.makeEnumBodyNodeWithUnions(constants, members, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a EnumBodyNode.
     * The specified start and stop locations are used.
     */
    @Override
    public EnumBodyNode makeEnumBodyNode(
            EnumConstantDeclarationListNode constants,
            ClassMemberListNode members,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        EnumBodyNode node = factory.makeEnumBodyNode(constants, members, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a EnumConstantDeclarationListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public EnumConstantDeclarationListNode makeEnumConstantDeclarationListNodeWithUnions(
            List<NodeUnion<? extends EnumConstantDeclarationNode>> children)
    {
        this.before();
        EnumConstantDeclarationListNode node = factory.makeEnumConstantDeclarationListNodeWithUnions(children);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a EnumConstantDeclarationListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public EnumConstantDeclarationListNode makeEnumConstantDeclarationListNode(
            List<EnumConstantDeclarationNode> children)
    {
        this.before();
        EnumConstantDeclarationListNode node = factory.makeEnumConstantDeclarationListNode(children);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a EnumConstantDeclarationListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public EnumConstantDeclarationListNode makeEnumConstantDeclarationListNode(
            EnumConstantDeclarationNode... childrenElements)
    {
        this.before();
        EnumConstantDeclarationListNode node = factory.makeEnumConstantDeclarationListNode(childrenElements);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a EnumConstantDeclarationListNode.
     * The specified start and stop locations are used.
     */
    @Override
    public EnumConstantDeclarationListNode makeEnumConstantDeclarationListNodeWithUnions(
            List<NodeUnion<? extends EnumConstantDeclarationNode>> children,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        EnumConstantDeclarationListNode node = factory.makeEnumConstantDeclarationListNodeWithUnions(children, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a EnumConstantDeclarationListNode.
     * The specified start and stop locations are used.
     */
    @Override
    public EnumConstantDeclarationListNode makeEnumConstantDeclarationListNode(
            List<EnumConstantDeclarationNode> children,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        EnumConstantDeclarationListNode node = factory.makeEnumConstantDeclarationListNode(children, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a EnumConstantDeclarationListNode.
     * The specified start and stop locations are used.
     */
    @Override
    public EnumConstantDeclarationListNode makeEnumConstantDeclarationListNode(
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation,
            EnumConstantDeclarationNode... childrenElements)
    {
        this.before();
        EnumConstantDeclarationListNode node = factory.makeEnumConstantDeclarationListNode(startLocation, stopLocation, childrenElements);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a EnumConstantDeclarationNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public EnumConstantDeclarationNode makeEnumConstantDeclarationNodeWithUnions(
            NodeUnion<? extends EnumConstantModifiersNode> modifiers,
            NodeUnion<? extends IdentifierNode> identifier,
            NodeUnion<? extends ExpressionListNode> arguments,
            NodeUnion<? extends AnonymousClassBodyNode> body,
            NodeUnion<? extends JavadocNode> javadoc)
    {
        this.before();
        EnumConstantDeclarationNode node = factory.makeEnumConstantDeclarationNodeWithUnions(modifiers, identifier, arguments, body, javadoc);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a EnumConstantDeclarationNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public EnumConstantDeclarationNode makeEnumConstantDeclarationNode(
            EnumConstantModifiersNode modifiers,
            IdentifierNode identifier,
            ExpressionListNode arguments,
            AnonymousClassBodyNode body,
            JavadocNode javadoc)
    {
        this.before();
        EnumConstantDeclarationNode node = factory.makeEnumConstantDeclarationNode(modifiers, identifier, arguments, body, javadoc);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a EnumConstantDeclarationNode.
     * The specified start and stop locations are used.
     */
    @Override
    public EnumConstantDeclarationNode makeEnumConstantDeclarationNodeWithUnions(
            NodeUnion<? extends EnumConstantModifiersNode> modifiers,
            NodeUnion<? extends IdentifierNode> identifier,
            NodeUnion<? extends ExpressionListNode> arguments,
            NodeUnion<? extends AnonymousClassBodyNode> body,
            NodeUnion<? extends JavadocNode> javadoc,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        EnumConstantDeclarationNode node = factory.makeEnumConstantDeclarationNodeWithUnions(modifiers, identifier, arguments, body, javadoc, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a EnumConstantDeclarationNode.
     * The specified start and stop locations are used.
     */
    @Override
    public EnumConstantDeclarationNode makeEnumConstantDeclarationNode(
            EnumConstantModifiersNode modifiers,
            IdentifierNode identifier,
            ExpressionListNode arguments,
            AnonymousClassBodyNode body,
            JavadocNode javadoc,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        EnumConstantDeclarationNode node = factory.makeEnumConstantDeclarationNode(modifiers, identifier, arguments, body, javadoc, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a EnumConstantDeclarationNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public EnumConstantDeclarationNode makeEnumConstantDeclarationNode(
            EnumConstantModifiersNode modifiers,
            IdentifierNode identifier,
            ExpressionListNode arguments,
            JavadocNode javadoc)
    {
        this.before();
        EnumConstantDeclarationNode node = factory.makeEnumConstantDeclarationNode(modifiers, identifier, arguments, javadoc);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a EnumConstantDeclarationNode.
     * The specified start and stop locations are used.
     */
    @Override
    public EnumConstantDeclarationNode makeEnumConstantDeclarationNode(
            EnumConstantModifiersNode modifiers,
            IdentifierNode identifier,
            ExpressionListNode arguments,
            JavadocNode javadoc,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        EnumConstantDeclarationNode node = factory.makeEnumConstantDeclarationNode(modifiers, identifier, arguments, javadoc, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a EnumConstantModifiersNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public EnumConstantModifiersNode makeEnumConstantModifiersNodeWithUnions(
            NodeUnion<? extends MetaAnnotationListNode> metaAnnotations,
            NodeUnion<? extends AnnotationListNode> annotations)
    {
        this.before();
        EnumConstantModifiersNode node = factory.makeEnumConstantModifiersNodeWithUnions(metaAnnotations, annotations);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a EnumConstantModifiersNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public EnumConstantModifiersNode makeEnumConstantModifiersNode(
            MetaAnnotationListNode metaAnnotations,
            AnnotationListNode annotations)
    {
        this.before();
        EnumConstantModifiersNode node = factory.makeEnumConstantModifiersNode(metaAnnotations, annotations);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a EnumConstantModifiersNode.
     * The specified start and stop locations are used.
     */
    @Override
    public EnumConstantModifiersNode makeEnumConstantModifiersNodeWithUnions(
            NodeUnion<? extends MetaAnnotationListNode> metaAnnotations,
            NodeUnion<? extends AnnotationListNode> annotations,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        EnumConstantModifiersNode node = factory.makeEnumConstantModifiersNodeWithUnions(metaAnnotations, annotations, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a EnumConstantModifiersNode.
     * The specified start and stop locations are used.
     */
    @Override
    public EnumConstantModifiersNode makeEnumConstantModifiersNode(
            MetaAnnotationListNode metaAnnotations,
            AnnotationListNode annotations,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        EnumConstantModifiersNode node = factory.makeEnumConstantModifiersNode(metaAnnotations, annotations, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a EnumConstantModifiersNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public EnumConstantModifiersNode makeEnumConstantModifiersNode(
    )
    {
        this.before();
        EnumConstantModifiersNode node = factory.makeEnumConstantModifiersNode();
        this.after(node);
        return node;
    }
    
    /**
     * Creates a EnumConstantModifiersNode.
     * The specified start and stop locations are used.
     */
    @Override
    public EnumConstantModifiersNode makeEnumConstantModifiersNode(
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        EnumConstantModifiersNode node = factory.makeEnumConstantModifiersNode(startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a EnumDeclarationNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public EnumDeclarationNode makeEnumDeclarationNodeWithUnions(
            NodeUnion<? extends EnumModifiersNode> modifiers,
            NodeUnion<? extends DeclaredTypeListNode> implementsClause,
            NodeUnion<? extends EnumBodyNode> body,
            NodeUnion<? extends IdentifierNode> identifier,
            NodeUnion<? extends JavadocNode> javadoc)
    {
        this.before();
        EnumDeclarationNode node = factory.makeEnumDeclarationNodeWithUnions(modifiers, implementsClause, body, identifier, javadoc);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a EnumDeclarationNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public EnumDeclarationNode makeEnumDeclarationNode(
            EnumModifiersNode modifiers,
            DeclaredTypeListNode implementsClause,
            EnumBodyNode body,
            IdentifierNode identifier,
            JavadocNode javadoc)
    {
        this.before();
        EnumDeclarationNode node = factory.makeEnumDeclarationNode(modifiers, implementsClause, body, identifier, javadoc);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a EnumDeclarationNode.
     * The specified start and stop locations are used.
     */
    @Override
    public EnumDeclarationNode makeEnumDeclarationNodeWithUnions(
            NodeUnion<? extends EnumModifiersNode> modifiers,
            NodeUnion<? extends DeclaredTypeListNode> implementsClause,
            NodeUnion<? extends EnumBodyNode> body,
            NodeUnion<? extends IdentifierNode> identifier,
            NodeUnion<? extends JavadocNode> javadoc,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        EnumDeclarationNode node = factory.makeEnumDeclarationNodeWithUnions(modifiers, implementsClause, body, identifier, javadoc, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a EnumDeclarationNode.
     * The specified start and stop locations are used.
     */
    @Override
    public EnumDeclarationNode makeEnumDeclarationNode(
            EnumModifiersNode modifiers,
            DeclaredTypeListNode implementsClause,
            EnumBodyNode body,
            IdentifierNode identifier,
            JavadocNode javadoc,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        EnumDeclarationNode node = factory.makeEnumDeclarationNode(modifiers, implementsClause, body, identifier, javadoc, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a EnumModifiersNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public EnumModifiersNode makeEnumModifiersNodeWithUnions(
            AccessModifier access,
            boolean strictfpFlag,
            NodeUnion<? extends MetaAnnotationListNode> metaAnnotations,
            NodeUnion<? extends AnnotationListNode> annotations)
    {
        this.before();
        EnumModifiersNode node = factory.makeEnumModifiersNodeWithUnions(access, strictfpFlag, metaAnnotations, annotations);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a EnumModifiersNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public EnumModifiersNode makeEnumModifiersNode(
            AccessModifier access,
            boolean strictfpFlag,
            MetaAnnotationListNode metaAnnotations,
            AnnotationListNode annotations)
    {
        this.before();
        EnumModifiersNode node = factory.makeEnumModifiersNode(access, strictfpFlag, metaAnnotations, annotations);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a EnumModifiersNode.
     * The specified start and stop locations are used.
     */
    @Override
    public EnumModifiersNode makeEnumModifiersNodeWithUnions(
            AccessModifier access,
            boolean strictfpFlag,
            NodeUnion<? extends MetaAnnotationListNode> metaAnnotations,
            NodeUnion<? extends AnnotationListNode> annotations,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        EnumModifiersNode node = factory.makeEnumModifiersNodeWithUnions(access, strictfpFlag, metaAnnotations, annotations, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a EnumModifiersNode.
     * The specified start and stop locations are used.
     */
    @Override
    public EnumModifiersNode makeEnumModifiersNode(
            AccessModifier access,
            boolean strictfpFlag,
            MetaAnnotationListNode metaAnnotations,
            AnnotationListNode annotations,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        EnumModifiersNode node = factory.makeEnumModifiersNode(access, strictfpFlag, metaAnnotations, annotations, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a EnumModifiersNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public EnumModifiersNode makeEnumModifiersNode(
            AccessModifier access)
    {
        this.before();
        EnumModifiersNode node = factory.makeEnumModifiersNode(access);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a EnumModifiersNode.
     * The specified start and stop locations are used.
     */
    @Override
    public EnumModifiersNode makeEnumModifiersNode(
            AccessModifier access,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        EnumModifiersNode node = factory.makeEnumModifiersNode(access, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a ExpressionListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public ExpressionListNode makeExpressionListNodeWithUnions(
            List<NodeUnion<? extends ExpressionNode>> children)
    {
        this.before();
        ExpressionListNode node = factory.makeExpressionListNodeWithUnions(children);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a ExpressionListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public ExpressionListNode makeExpressionListNode(
            List<ExpressionNode> children)
    {
        this.before();
        ExpressionListNode node = factory.makeExpressionListNode(children);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a ExpressionListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public ExpressionListNode makeExpressionListNode(
            ExpressionNode... childrenElements)
    {
        this.before();
        ExpressionListNode node = factory.makeExpressionListNode(childrenElements);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a ExpressionListNode.
     * The specified start and stop locations are used.
     */
    @Override
    public ExpressionListNode makeExpressionListNodeWithUnions(
            List<NodeUnion<? extends ExpressionNode>> children,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        ExpressionListNode node = factory.makeExpressionListNodeWithUnions(children, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a ExpressionListNode.
     * The specified start and stop locations are used.
     */
    @Override
    public ExpressionListNode makeExpressionListNode(
            List<ExpressionNode> children,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        ExpressionListNode node = factory.makeExpressionListNode(children, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a ExpressionListNode.
     * The specified start and stop locations are used.
     */
    @Override
    public ExpressionListNode makeExpressionListNode(
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation,
            ExpressionNode... childrenElements)
    {
        this.before();
        ExpressionListNode node = factory.makeExpressionListNode(startLocation, stopLocation, childrenElements);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a ExpressionStatementNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public ExpressionStatementNode makeExpressionStatementNodeWithUnions(
            NodeUnion<? extends StatementExpressionNode> expression,
            NodeUnion<? extends MetaAnnotationListNode> metaAnnotations)
    {
        this.before();
        ExpressionStatementNode node = factory.makeExpressionStatementNodeWithUnions(expression, metaAnnotations);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a ExpressionStatementNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public ExpressionStatementNode makeExpressionStatementNode(
            StatementExpressionNode expression,
            MetaAnnotationListNode metaAnnotations)
    {
        this.before();
        ExpressionStatementNode node = factory.makeExpressionStatementNode(expression, metaAnnotations);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a ExpressionStatementNode.
     * The specified start and stop locations are used.
     */
    @Override
    public ExpressionStatementNode makeExpressionStatementNodeWithUnions(
            NodeUnion<? extends StatementExpressionNode> expression,
            NodeUnion<? extends MetaAnnotationListNode> metaAnnotations,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        ExpressionStatementNode node = factory.makeExpressionStatementNodeWithUnions(expression, metaAnnotations, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a ExpressionStatementNode.
     * The specified start and stop locations are used.
     */
    @Override
    public ExpressionStatementNode makeExpressionStatementNode(
            StatementExpressionNode expression,
            MetaAnnotationListNode metaAnnotations,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        ExpressionStatementNode node = factory.makeExpressionStatementNode(expression, metaAnnotations, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a ExpressionStatementNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public ExpressionStatementNode makeExpressionStatementNode(
            StatementExpressionNode expression)
    {
        this.before();
        ExpressionStatementNode node = factory.makeExpressionStatementNode(expression);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a ExpressionStatementNode.
     * The specified start and stop locations are used.
     */
    @Override
    public ExpressionStatementNode makeExpressionStatementNode(
            StatementExpressionNode expression,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        ExpressionStatementNode node = factory.makeExpressionStatementNode(expression, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a FieldDeclarationNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public FieldDeclarationNode makeFieldDeclarationNodeWithUnions(
            NodeUnion<? extends FieldModifiersNode> modifiers,
            NodeUnion<? extends TypeNode> type,
            NodeUnion<? extends VariableDeclaratorListNode> declarators,
            NodeUnion<? extends JavadocNode> javadoc)
    {
        this.before();
        FieldDeclarationNode node = factory.makeFieldDeclarationNodeWithUnions(modifiers, type, declarators, javadoc);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a FieldDeclarationNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public FieldDeclarationNode makeFieldDeclarationNode(
            FieldModifiersNode modifiers,
            TypeNode type,
            VariableDeclaratorListNode declarators,
            JavadocNode javadoc)
    {
        this.before();
        FieldDeclarationNode node = factory.makeFieldDeclarationNode(modifiers, type, declarators, javadoc);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a FieldDeclarationNode.
     * The specified start and stop locations are used.
     */
    @Override
    public FieldDeclarationNode makeFieldDeclarationNodeWithUnions(
            NodeUnion<? extends FieldModifiersNode> modifiers,
            NodeUnion<? extends TypeNode> type,
            NodeUnion<? extends VariableDeclaratorListNode> declarators,
            NodeUnion<? extends JavadocNode> javadoc,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        FieldDeclarationNode node = factory.makeFieldDeclarationNodeWithUnions(modifiers, type, declarators, javadoc, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a FieldDeclarationNode.
     * The specified start and stop locations are used.
     */
    @Override
    public FieldDeclarationNode makeFieldDeclarationNode(
            FieldModifiersNode modifiers,
            TypeNode type,
            VariableDeclaratorListNode declarators,
            JavadocNode javadoc,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        FieldDeclarationNode node = factory.makeFieldDeclarationNode(modifiers, type, declarators, javadoc, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a FieldModifiersNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public FieldModifiersNode makeFieldModifiersNodeWithUnions(
            AccessModifier access,
            boolean staticFlag,
            boolean finalFlag,
            boolean transientFlag,
            boolean volatileFlag,
            NodeUnion<? extends MetaAnnotationListNode> metaAnnotations,
            NodeUnion<? extends AnnotationListNode> annotations)
    {
        this.before();
        FieldModifiersNode node = factory.makeFieldModifiersNodeWithUnions(access, staticFlag, finalFlag, transientFlag, volatileFlag, metaAnnotations, annotations);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a FieldModifiersNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public FieldModifiersNode makeFieldModifiersNode(
            AccessModifier access,
            boolean staticFlag,
            boolean finalFlag,
            boolean transientFlag,
            boolean volatileFlag,
            MetaAnnotationListNode metaAnnotations,
            AnnotationListNode annotations)
    {
        this.before();
        FieldModifiersNode node = factory.makeFieldModifiersNode(access, staticFlag, finalFlag, transientFlag, volatileFlag, metaAnnotations, annotations);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a FieldModifiersNode.
     * The specified start and stop locations are used.
     */
    @Override
    public FieldModifiersNode makeFieldModifiersNodeWithUnions(
            AccessModifier access,
            boolean staticFlag,
            boolean finalFlag,
            boolean transientFlag,
            boolean volatileFlag,
            NodeUnion<? extends MetaAnnotationListNode> metaAnnotations,
            NodeUnion<? extends AnnotationListNode> annotations,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        FieldModifiersNode node = factory.makeFieldModifiersNodeWithUnions(access, staticFlag, finalFlag, transientFlag, volatileFlag, metaAnnotations, annotations, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a FieldModifiersNode.
     * The specified start and stop locations are used.
     */
    @Override
    public FieldModifiersNode makeFieldModifiersNode(
            AccessModifier access,
            boolean staticFlag,
            boolean finalFlag,
            boolean transientFlag,
            boolean volatileFlag,
            MetaAnnotationListNode metaAnnotations,
            AnnotationListNode annotations,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        FieldModifiersNode node = factory.makeFieldModifiersNode(access, staticFlag, finalFlag, transientFlag, volatileFlag, metaAnnotations, annotations, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a FieldModifiersNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public FieldModifiersNode makeFieldModifiersNode(
            AccessModifier access)
    {
        this.before();
        FieldModifiersNode node = factory.makeFieldModifiersNode(access);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a FieldModifiersNode.
     * The specified start and stop locations are used.
     */
    @Override
    public FieldModifiersNode makeFieldModifiersNode(
            AccessModifier access,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        FieldModifiersNode node = factory.makeFieldModifiersNode(access, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a FloatLiteralNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public FloatLiteralNode makeFloatLiteralNode(
            Float value)
    {
        this.before();
        FloatLiteralNode node = factory.makeFloatLiteralNode(value);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a FloatLiteralNode.
     * The specified start and stop locations are used.
     */
    @Override
    public FloatLiteralNode makeFloatLiteralNode(
            Float value,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        FloatLiteralNode node = factory.makeFloatLiteralNode(value, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a ForInitializerDeclarationNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public ForInitializerDeclarationNode makeForInitializerDeclarationNodeWithUnions(
            NodeUnion<? extends LocalVariableDeclarationNode> declaration)
    {
        this.before();
        ForInitializerDeclarationNode node = factory.makeForInitializerDeclarationNodeWithUnions(declaration);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a ForInitializerDeclarationNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public ForInitializerDeclarationNode makeForInitializerDeclarationNode(
            LocalVariableDeclarationNode declaration)
    {
        this.before();
        ForInitializerDeclarationNode node = factory.makeForInitializerDeclarationNode(declaration);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a ForInitializerDeclarationNode.
     * The specified start and stop locations are used.
     */
    @Override
    public ForInitializerDeclarationNode makeForInitializerDeclarationNodeWithUnions(
            NodeUnion<? extends LocalVariableDeclarationNode> declaration,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        ForInitializerDeclarationNode node = factory.makeForInitializerDeclarationNodeWithUnions(declaration, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a ForInitializerDeclarationNode.
     * The specified start and stop locations are used.
     */
    @Override
    public ForInitializerDeclarationNode makeForInitializerDeclarationNode(
            LocalVariableDeclarationNode declaration,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        ForInitializerDeclarationNode node = factory.makeForInitializerDeclarationNode(declaration, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a ForInitializerExpressionNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public ForInitializerExpressionNode makeForInitializerExpressionNodeWithUnions(
            NodeUnion<? extends StatementExpressionListNode> expressions)
    {
        this.before();
        ForInitializerExpressionNode node = factory.makeForInitializerExpressionNodeWithUnions(expressions);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a ForInitializerExpressionNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public ForInitializerExpressionNode makeForInitializerExpressionNode(
            StatementExpressionListNode expressions)
    {
        this.before();
        ForInitializerExpressionNode node = factory.makeForInitializerExpressionNode(expressions);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a ForInitializerExpressionNode.
     * The specified start and stop locations are used.
     */
    @Override
    public ForInitializerExpressionNode makeForInitializerExpressionNodeWithUnions(
            NodeUnion<? extends StatementExpressionListNode> expressions,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        ForInitializerExpressionNode node = factory.makeForInitializerExpressionNodeWithUnions(expressions, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a ForInitializerExpressionNode.
     * The specified start and stop locations are used.
     */
    @Override
    public ForInitializerExpressionNode makeForInitializerExpressionNode(
            StatementExpressionListNode expressions,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        ForInitializerExpressionNode node = factory.makeForInitializerExpressionNode(expressions, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a ForLoopNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public ForLoopNode makeForLoopNodeWithUnions(
            NodeUnion<? extends ForInitializerNode> initializer,
            NodeUnion<? extends ExpressionNode> condition,
            NodeUnion<? extends StatementExpressionListNode> update,
            NodeUnion<? extends StatementNode> statement,
            NodeUnion<? extends MetaAnnotationListNode> metaAnnotations)
    {
        this.before();
        ForLoopNode node = factory.makeForLoopNodeWithUnions(initializer, condition, update, statement, metaAnnotations);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a ForLoopNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public ForLoopNode makeForLoopNode(
            ForInitializerNode initializer,
            ExpressionNode condition,
            StatementExpressionListNode update,
            StatementNode statement,
            MetaAnnotationListNode metaAnnotations)
    {
        this.before();
        ForLoopNode node = factory.makeForLoopNode(initializer, condition, update, statement, metaAnnotations);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a ForLoopNode.
     * The specified start and stop locations are used.
     */
    @Override
    public ForLoopNode makeForLoopNodeWithUnions(
            NodeUnion<? extends ForInitializerNode> initializer,
            NodeUnion<? extends ExpressionNode> condition,
            NodeUnion<? extends StatementExpressionListNode> update,
            NodeUnion<? extends StatementNode> statement,
            NodeUnion<? extends MetaAnnotationListNode> metaAnnotations,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        ForLoopNode node = factory.makeForLoopNodeWithUnions(initializer, condition, update, statement, metaAnnotations, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a ForLoopNode.
     * The specified start and stop locations are used.
     */
    @Override
    public ForLoopNode makeForLoopNode(
            ForInitializerNode initializer,
            ExpressionNode condition,
            StatementExpressionListNode update,
            StatementNode statement,
            MetaAnnotationListNode metaAnnotations,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        ForLoopNode node = factory.makeForLoopNode(initializer, condition, update, statement, metaAnnotations, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a ForLoopNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public ForLoopNode makeForLoopNode(
            ForInitializerNode initializer,
            ExpressionNode condition,
            StatementExpressionListNode update,
            StatementNode statement)
    {
        this.before();
        ForLoopNode node = factory.makeForLoopNode(initializer, condition, update, statement);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a ForLoopNode.
     * The specified start and stop locations are used.
     */
    @Override
    public ForLoopNode makeForLoopNode(
            ForInitializerNode initializer,
            ExpressionNode condition,
            StatementExpressionListNode update,
            StatementNode statement,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        ForLoopNode node = factory.makeForLoopNode(initializer, condition, update, statement, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a IdentifierListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public IdentifierListNode makeIdentifierListNodeWithUnions(
            List<NodeUnion<? extends IdentifierNode>> children)
    {
        this.before();
        IdentifierListNode node = factory.makeIdentifierListNodeWithUnions(children);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a IdentifierListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public IdentifierListNode makeIdentifierListNode(
            List<IdentifierNode> children)
    {
        this.before();
        IdentifierListNode node = factory.makeIdentifierListNode(children);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a IdentifierListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public IdentifierListNode makeIdentifierListNode(
            IdentifierNode... childrenElements)
    {
        this.before();
        IdentifierListNode node = factory.makeIdentifierListNode(childrenElements);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a IdentifierListNode.
     * The specified start and stop locations are used.
     */
    @Override
    public IdentifierListNode makeIdentifierListNodeWithUnions(
            List<NodeUnion<? extends IdentifierNode>> children,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        IdentifierListNode node = factory.makeIdentifierListNodeWithUnions(children, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a IdentifierListNode.
     * The specified start and stop locations are used.
     */
    @Override
    public IdentifierListNode makeIdentifierListNode(
            List<IdentifierNode> children,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        IdentifierListNode node = factory.makeIdentifierListNode(children, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a IdentifierListNode.
     * The specified start and stop locations are used.
     */
    @Override
    public IdentifierListNode makeIdentifierListNode(
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation,
            IdentifierNode... childrenElements)
    {
        this.before();
        IdentifierListNode node = factory.makeIdentifierListNode(startLocation, stopLocation, childrenElements);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a IdentifierNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public IdentifierNode makeIdentifierNode(
            String identifier)
    {
        this.before();
        IdentifierNode node = factory.makeIdentifierNode(identifier);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a IdentifierNode.
     * The specified start and stop locations are used.
     */
    @Override
    public IdentifierNode makeIdentifierNode(
            String identifier,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        IdentifierNode node = factory.makeIdentifierNode(identifier, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a IfNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public IfNode makeIfNodeWithUnions(
            NodeUnion<? extends ExpressionNode> condition,
            NodeUnion<? extends StatementNode> thenStatement,
            NodeUnion<? extends StatementNode> elseStatement,
            NodeUnion<? extends MetaAnnotationListNode> metaAnnotations)
    {
        this.before();
        IfNode node = factory.makeIfNodeWithUnions(condition, thenStatement, elseStatement, metaAnnotations);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a IfNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public IfNode makeIfNode(
            ExpressionNode condition,
            StatementNode thenStatement,
            StatementNode elseStatement,
            MetaAnnotationListNode metaAnnotations)
    {
        this.before();
        IfNode node = factory.makeIfNode(condition, thenStatement, elseStatement, metaAnnotations);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a IfNode.
     * The specified start and stop locations are used.
     */
    @Override
    public IfNode makeIfNodeWithUnions(
            NodeUnion<? extends ExpressionNode> condition,
            NodeUnion<? extends StatementNode> thenStatement,
            NodeUnion<? extends StatementNode> elseStatement,
            NodeUnion<? extends MetaAnnotationListNode> metaAnnotations,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        IfNode node = factory.makeIfNodeWithUnions(condition, thenStatement, elseStatement, metaAnnotations, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a IfNode.
     * The specified start and stop locations are used.
     */
    @Override
    public IfNode makeIfNode(
            ExpressionNode condition,
            StatementNode thenStatement,
            StatementNode elseStatement,
            MetaAnnotationListNode metaAnnotations,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        IfNode node = factory.makeIfNode(condition, thenStatement, elseStatement, metaAnnotations, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a IfNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public IfNode makeIfNode(
            ExpressionNode condition,
            StatementNode thenStatement,
            StatementNode elseStatement)
    {
        this.before();
        IfNode node = factory.makeIfNode(condition, thenStatement, elseStatement);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a IfNode.
     * The specified start and stop locations are used.
     */
    @Override
    public IfNode makeIfNode(
            ExpressionNode condition,
            StatementNode thenStatement,
            StatementNode elseStatement,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        IfNode node = factory.makeIfNode(condition, thenStatement, elseStatement, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a IfNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public IfNode makeIfNode(
            ExpressionNode condition,
            StatementNode thenStatement)
    {
        this.before();
        IfNode node = factory.makeIfNode(condition, thenStatement);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a IfNode.
     * The specified start and stop locations are used.
     */
    @Override
    public IfNode makeIfNode(
            ExpressionNode condition,
            StatementNode thenStatement,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        IfNode node = factory.makeIfNode(condition, thenStatement, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a ImportListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public ImportListNode makeImportListNodeWithUnions(
            List<NodeUnion<? extends ImportNode>> children)
    {
        this.before();
        ImportListNode node = factory.makeImportListNodeWithUnions(children);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a ImportListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public ImportListNode makeImportListNode(
            List<ImportNode> children)
    {
        this.before();
        ImportListNode node = factory.makeImportListNode(children);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a ImportListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public ImportListNode makeImportListNode(
            ImportNode... childrenElements)
    {
        this.before();
        ImportListNode node = factory.makeImportListNode(childrenElements);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a ImportListNode.
     * The specified start and stop locations are used.
     */
    @Override
    public ImportListNode makeImportListNodeWithUnions(
            List<NodeUnion<? extends ImportNode>> children,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        ImportListNode node = factory.makeImportListNodeWithUnions(children, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a ImportListNode.
     * The specified start and stop locations are used.
     */
    @Override
    public ImportListNode makeImportListNode(
            List<ImportNode> children,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        ImportListNode node = factory.makeImportListNode(children, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a ImportListNode.
     * The specified start and stop locations are used.
     */
    @Override
    public ImportListNode makeImportListNode(
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation,
            ImportNode... childrenElements)
    {
        this.before();
        ImportListNode node = factory.makeImportListNode(startLocation, stopLocation, childrenElements);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a ImportOnDemandNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public ImportOnDemandNode makeImportOnDemandNodeWithUnions(
            NodeUnion<? extends NameNode> name)
    {
        this.before();
        ImportOnDemandNode node = factory.makeImportOnDemandNodeWithUnions(name);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a ImportOnDemandNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public ImportOnDemandNode makeImportOnDemandNode(
            NameNode name)
    {
        this.before();
        ImportOnDemandNode node = factory.makeImportOnDemandNode(name);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a ImportOnDemandNode.
     * The specified start and stop locations are used.
     */
    @Override
    public ImportOnDemandNode makeImportOnDemandNodeWithUnions(
            NodeUnion<? extends NameNode> name,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        ImportOnDemandNode node = factory.makeImportOnDemandNodeWithUnions(name, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a ImportOnDemandNode.
     * The specified start and stop locations are used.
     */
    @Override
    public ImportOnDemandNode makeImportOnDemandNode(
            NameNode name,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        ImportOnDemandNode node = factory.makeImportOnDemandNode(name, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a ImportSingleTypeNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public ImportSingleTypeNode makeImportSingleTypeNodeWithUnions(
            NodeUnion<? extends NameNode> name)
    {
        this.before();
        ImportSingleTypeNode node = factory.makeImportSingleTypeNodeWithUnions(name);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a ImportSingleTypeNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public ImportSingleTypeNode makeImportSingleTypeNode(
            NameNode name)
    {
        this.before();
        ImportSingleTypeNode node = factory.makeImportSingleTypeNode(name);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a ImportSingleTypeNode.
     * The specified start and stop locations are used.
     */
    @Override
    public ImportSingleTypeNode makeImportSingleTypeNodeWithUnions(
            NodeUnion<? extends NameNode> name,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        ImportSingleTypeNode node = factory.makeImportSingleTypeNodeWithUnions(name, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a ImportSingleTypeNode.
     * The specified start and stop locations are used.
     */
    @Override
    public ImportSingleTypeNode makeImportSingleTypeNode(
            NameNode name,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        ImportSingleTypeNode node = factory.makeImportSingleTypeNode(name, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a InitializerDeclarationNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public InitializerDeclarationNode makeInitializerDeclarationNodeWithUnions(
            boolean staticInitializer,
            NodeUnion<? extends BlockStatementListNode> body,
            NodeUnion<? extends MetaAnnotationListNode> metaAnnotations)
    {
        this.before();
        InitializerDeclarationNode node = factory.makeInitializerDeclarationNodeWithUnions(staticInitializer, body, metaAnnotations);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a InitializerDeclarationNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public InitializerDeclarationNode makeInitializerDeclarationNode(
            boolean staticInitializer,
            BlockStatementListNode body,
            MetaAnnotationListNode metaAnnotations)
    {
        this.before();
        InitializerDeclarationNode node = factory.makeInitializerDeclarationNode(staticInitializer, body, metaAnnotations);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a InitializerDeclarationNode.
     * The specified start and stop locations are used.
     */
    @Override
    public InitializerDeclarationNode makeInitializerDeclarationNodeWithUnions(
            boolean staticInitializer,
            NodeUnion<? extends BlockStatementListNode> body,
            NodeUnion<? extends MetaAnnotationListNode> metaAnnotations,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        InitializerDeclarationNode node = factory.makeInitializerDeclarationNodeWithUnions(staticInitializer, body, metaAnnotations, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a InitializerDeclarationNode.
     * The specified start and stop locations are used.
     */
    @Override
    public InitializerDeclarationNode makeInitializerDeclarationNode(
            boolean staticInitializer,
            BlockStatementListNode body,
            MetaAnnotationListNode metaAnnotations,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        InitializerDeclarationNode node = factory.makeInitializerDeclarationNode(staticInitializer, body, metaAnnotations, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a InitializerDeclarationNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public InitializerDeclarationNode makeInitializerDeclarationNode(
            boolean staticInitializer,
            BlockStatementListNode body)
    {
        this.before();
        InitializerDeclarationNode node = factory.makeInitializerDeclarationNode(staticInitializer, body);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a InitializerDeclarationNode.
     * The specified start and stop locations are used.
     */
    @Override
    public InitializerDeclarationNode makeInitializerDeclarationNode(
            boolean staticInitializer,
            BlockStatementListNode body,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        InitializerDeclarationNode node = factory.makeInitializerDeclarationNode(staticInitializer, body, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a InstanceOfNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public InstanceOfNode makeInstanceOfNodeWithUnions(
            NodeUnion<? extends ExpressionNode> expression,
            NodeUnion<? extends TypeNode> type)
    {
        this.before();
        InstanceOfNode node = factory.makeInstanceOfNodeWithUnions(expression, type);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a InstanceOfNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public InstanceOfNode makeInstanceOfNode(
            ExpressionNode expression,
            TypeNode type)
    {
        this.before();
        InstanceOfNode node = factory.makeInstanceOfNode(expression, type);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a InstanceOfNode.
     * The specified start and stop locations are used.
     */
    @Override
    public InstanceOfNode makeInstanceOfNodeWithUnions(
            NodeUnion<? extends ExpressionNode> expression,
            NodeUnion<? extends TypeNode> type,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        InstanceOfNode node = factory.makeInstanceOfNodeWithUnions(expression, type, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a InstanceOfNode.
     * The specified start and stop locations are used.
     */
    @Override
    public InstanceOfNode makeInstanceOfNode(
            ExpressionNode expression,
            TypeNode type,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        InstanceOfNode node = factory.makeInstanceOfNode(expression, type, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a IntLiteralNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public IntLiteralNode makeIntLiteralNode(
            Integer value)
    {
        this.before();
        IntLiteralNode node = factory.makeIntLiteralNode(value);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a IntLiteralNode.
     * The specified start and stop locations are used.
     */
    @Override
    public IntLiteralNode makeIntLiteralNode(
            Integer value,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        IntLiteralNode node = factory.makeIntLiteralNode(value, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a InterfaceBodyNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public InterfaceBodyNode makeInterfaceBodyNodeWithUnions(
            NodeUnion<? extends InterfaceMemberListNode> members)
    {
        this.before();
        InterfaceBodyNode node = factory.makeInterfaceBodyNodeWithUnions(members);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a InterfaceBodyNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public InterfaceBodyNode makeInterfaceBodyNode(
            InterfaceMemberListNode members)
    {
        this.before();
        InterfaceBodyNode node = factory.makeInterfaceBodyNode(members);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a InterfaceBodyNode.
     * The specified start and stop locations are used.
     */
    @Override
    public InterfaceBodyNode makeInterfaceBodyNodeWithUnions(
            NodeUnion<? extends InterfaceMemberListNode> members,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        InterfaceBodyNode node = factory.makeInterfaceBodyNodeWithUnions(members, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a InterfaceBodyNode.
     * The specified start and stop locations are used.
     */
    @Override
    public InterfaceBodyNode makeInterfaceBodyNode(
            InterfaceMemberListNode members,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        InterfaceBodyNode node = factory.makeInterfaceBodyNode(members, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a InterfaceDeclarationNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public InterfaceDeclarationNode makeInterfaceDeclarationNodeWithUnions(
            NodeUnion<? extends InterfaceModifiersNode> modifiers,
            NodeUnion<? extends DeclaredTypeListNode> extendsClause,
            NodeUnion<? extends InterfaceBodyNode> body,
            NodeUnion<? extends TypeParameterListNode> typeParameters,
            NodeUnion<? extends IdentifierNode> identifier,
            NodeUnion<? extends JavadocNode> javadoc)
    {
        this.before();
        InterfaceDeclarationNode node = factory.makeInterfaceDeclarationNodeWithUnions(modifiers, extendsClause, body, typeParameters, identifier, javadoc);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a InterfaceDeclarationNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public InterfaceDeclarationNode makeInterfaceDeclarationNode(
            InterfaceModifiersNode modifiers,
            DeclaredTypeListNode extendsClause,
            InterfaceBodyNode body,
            TypeParameterListNode typeParameters,
            IdentifierNode identifier,
            JavadocNode javadoc)
    {
        this.before();
        InterfaceDeclarationNode node = factory.makeInterfaceDeclarationNode(modifiers, extendsClause, body, typeParameters, identifier, javadoc);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a InterfaceDeclarationNode.
     * The specified start and stop locations are used.
     */
    @Override
    public InterfaceDeclarationNode makeInterfaceDeclarationNodeWithUnions(
            NodeUnion<? extends InterfaceModifiersNode> modifiers,
            NodeUnion<? extends DeclaredTypeListNode> extendsClause,
            NodeUnion<? extends InterfaceBodyNode> body,
            NodeUnion<? extends TypeParameterListNode> typeParameters,
            NodeUnion<? extends IdentifierNode> identifier,
            NodeUnion<? extends JavadocNode> javadoc,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        InterfaceDeclarationNode node = factory.makeInterfaceDeclarationNodeWithUnions(modifiers, extendsClause, body, typeParameters, identifier, javadoc, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a InterfaceDeclarationNode.
     * The specified start and stop locations are used.
     */
    @Override
    public InterfaceDeclarationNode makeInterfaceDeclarationNode(
            InterfaceModifiersNode modifiers,
            DeclaredTypeListNode extendsClause,
            InterfaceBodyNode body,
            TypeParameterListNode typeParameters,
            IdentifierNode identifier,
            JavadocNode javadoc,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        InterfaceDeclarationNode node = factory.makeInterfaceDeclarationNode(modifiers, extendsClause, body, typeParameters, identifier, javadoc, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a InterfaceMemberListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public InterfaceMemberListNode makeInterfaceMemberListNodeWithUnions(
            List<NodeUnion<? extends InterfaceMemberNode>> children)
    {
        this.before();
        InterfaceMemberListNode node = factory.makeInterfaceMemberListNodeWithUnions(children);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a InterfaceMemberListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public InterfaceMemberListNode makeInterfaceMemberListNode(
            List<InterfaceMemberNode> children)
    {
        this.before();
        InterfaceMemberListNode node = factory.makeInterfaceMemberListNode(children);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a InterfaceMemberListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public InterfaceMemberListNode makeInterfaceMemberListNode(
            InterfaceMemberNode... childrenElements)
    {
        this.before();
        InterfaceMemberListNode node = factory.makeInterfaceMemberListNode(childrenElements);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a InterfaceMemberListNode.
     * The specified start and stop locations are used.
     */
    @Override
    public InterfaceMemberListNode makeInterfaceMemberListNodeWithUnions(
            List<NodeUnion<? extends InterfaceMemberNode>> children,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        InterfaceMemberListNode node = factory.makeInterfaceMemberListNodeWithUnions(children, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a InterfaceMemberListNode.
     * The specified start and stop locations are used.
     */
    @Override
    public InterfaceMemberListNode makeInterfaceMemberListNode(
            List<InterfaceMemberNode> children,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        InterfaceMemberListNode node = factory.makeInterfaceMemberListNode(children, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a InterfaceMemberListNode.
     * The specified start and stop locations are used.
     */
    @Override
    public InterfaceMemberListNode makeInterfaceMemberListNode(
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation,
            InterfaceMemberNode... childrenElements)
    {
        this.before();
        InterfaceMemberListNode node = factory.makeInterfaceMemberListNode(startLocation, stopLocation, childrenElements);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a InterfaceMemberMetaprogramAnchorNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public InterfaceMemberMetaprogramAnchorNode makeInterfaceMemberMetaprogramAnchorNodeWithUnions(
            NodeUnion<? extends MetaprogramNode> metaprogram)
    {
        this.before();
        InterfaceMemberMetaprogramAnchorNode node = factory.makeInterfaceMemberMetaprogramAnchorNodeWithUnions(metaprogram);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a InterfaceMemberMetaprogramAnchorNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public InterfaceMemberMetaprogramAnchorNode makeInterfaceMemberMetaprogramAnchorNode(
            MetaprogramNode metaprogram)
    {
        this.before();
        InterfaceMemberMetaprogramAnchorNode node = factory.makeInterfaceMemberMetaprogramAnchorNode(metaprogram);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a InterfaceMemberMetaprogramAnchorNode.
     * The specified start and stop locations are used.
     */
    @Override
    public InterfaceMemberMetaprogramAnchorNode makeInterfaceMemberMetaprogramAnchorNodeWithUnions(
            NodeUnion<? extends MetaprogramNode> metaprogram,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        InterfaceMemberMetaprogramAnchorNode node = factory.makeInterfaceMemberMetaprogramAnchorNodeWithUnions(metaprogram, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a InterfaceMemberMetaprogramAnchorNode.
     * The specified start and stop locations are used.
     */
    @Override
    public InterfaceMemberMetaprogramAnchorNode makeInterfaceMemberMetaprogramAnchorNode(
            MetaprogramNode metaprogram,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        InterfaceMemberMetaprogramAnchorNode node = factory.makeInterfaceMemberMetaprogramAnchorNode(metaprogram, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a InterfaceModifiersNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public InterfaceModifiersNode makeInterfaceModifiersNodeWithUnions(
            AccessModifier access,
            boolean staticFlag,
            boolean strictfpFlag,
            NodeUnion<? extends MetaAnnotationListNode> metaAnnotations,
            NodeUnion<? extends AnnotationListNode> annotations)
    {
        this.before();
        InterfaceModifiersNode node = factory.makeInterfaceModifiersNodeWithUnions(access, staticFlag, strictfpFlag, metaAnnotations, annotations);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a InterfaceModifiersNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public InterfaceModifiersNode makeInterfaceModifiersNode(
            AccessModifier access,
            boolean staticFlag,
            boolean strictfpFlag,
            MetaAnnotationListNode metaAnnotations,
            AnnotationListNode annotations)
    {
        this.before();
        InterfaceModifiersNode node = factory.makeInterfaceModifiersNode(access, staticFlag, strictfpFlag, metaAnnotations, annotations);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a InterfaceModifiersNode.
     * The specified start and stop locations are used.
     */
    @Override
    public InterfaceModifiersNode makeInterfaceModifiersNodeWithUnions(
            AccessModifier access,
            boolean staticFlag,
            boolean strictfpFlag,
            NodeUnion<? extends MetaAnnotationListNode> metaAnnotations,
            NodeUnion<? extends AnnotationListNode> annotations,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        InterfaceModifiersNode node = factory.makeInterfaceModifiersNodeWithUnions(access, staticFlag, strictfpFlag, metaAnnotations, annotations, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a InterfaceModifiersNode.
     * The specified start and stop locations are used.
     */
    @Override
    public InterfaceModifiersNode makeInterfaceModifiersNode(
            AccessModifier access,
            boolean staticFlag,
            boolean strictfpFlag,
            MetaAnnotationListNode metaAnnotations,
            AnnotationListNode annotations,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        InterfaceModifiersNode node = factory.makeInterfaceModifiersNode(access, staticFlag, strictfpFlag, metaAnnotations, annotations, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a InterfaceModifiersNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public InterfaceModifiersNode makeInterfaceModifiersNode(
            AccessModifier access)
    {
        this.before();
        InterfaceModifiersNode node = factory.makeInterfaceModifiersNode(access);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a InterfaceModifiersNode.
     * The specified start and stop locations are used.
     */
    @Override
    public InterfaceModifiersNode makeInterfaceModifiersNode(
            AccessModifier access,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        InterfaceModifiersNode node = factory.makeInterfaceModifiersNode(access, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a JavadocNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public JavadocNode makeJavadocNode(
            String text)
    {
        this.before();
        JavadocNode node = factory.makeJavadocNode(text);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a JavadocNode.
     * The specified start and stop locations are used.
     */
    @Override
    public JavadocNode makeJavadocNode(
            String text,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        JavadocNode node = factory.makeJavadocNode(text, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a LabeledStatementNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public LabeledStatementNode makeLabeledStatementNodeWithUnions(
            NodeUnion<? extends IdentifierNode> label,
            NodeUnion<? extends StatementNode> statement,
            NodeUnion<? extends MetaAnnotationListNode> metaAnnotations)
    {
        this.before();
        LabeledStatementNode node = factory.makeLabeledStatementNodeWithUnions(label, statement, metaAnnotations);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a LabeledStatementNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public LabeledStatementNode makeLabeledStatementNode(
            IdentifierNode label,
            StatementNode statement,
            MetaAnnotationListNode metaAnnotations)
    {
        this.before();
        LabeledStatementNode node = factory.makeLabeledStatementNode(label, statement, metaAnnotations);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a LabeledStatementNode.
     * The specified start and stop locations are used.
     */
    @Override
    public LabeledStatementNode makeLabeledStatementNodeWithUnions(
            NodeUnion<? extends IdentifierNode> label,
            NodeUnion<? extends StatementNode> statement,
            NodeUnion<? extends MetaAnnotationListNode> metaAnnotations,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        LabeledStatementNode node = factory.makeLabeledStatementNodeWithUnions(label, statement, metaAnnotations, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a LabeledStatementNode.
     * The specified start and stop locations are used.
     */
    @Override
    public LabeledStatementNode makeLabeledStatementNode(
            IdentifierNode label,
            StatementNode statement,
            MetaAnnotationListNode metaAnnotations,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        LabeledStatementNode node = factory.makeLabeledStatementNode(label, statement, metaAnnotations, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a LabeledStatementNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public LabeledStatementNode makeLabeledStatementNode(
            IdentifierNode label,
            StatementNode statement)
    {
        this.before();
        LabeledStatementNode node = factory.makeLabeledStatementNode(label, statement);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a LabeledStatementNode.
     * The specified start and stop locations are used.
     */
    @Override
    public LabeledStatementNode makeLabeledStatementNode(
            IdentifierNode label,
            StatementNode statement,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        LabeledStatementNode node = factory.makeLabeledStatementNode(label, statement, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a LocalClassDeclarationNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public LocalClassDeclarationNode makeLocalClassDeclarationNodeWithUnions(
            NodeUnion<? extends LocalClassModifiersNode> modifiers,
            NodeUnion<? extends DeclaredTypeNode> extendsClause,
            NodeUnion<? extends DeclaredTypeListNode> implementsClause,
            NodeUnion<? extends ClassBodyNode> body,
            NodeUnion<? extends TypeParameterListNode> typeParameters,
            NodeUnion<? extends IdentifierNode> identifier,
            NodeUnion<? extends JavadocNode> javadoc)
    {
        this.before();
        LocalClassDeclarationNode node = factory.makeLocalClassDeclarationNodeWithUnions(modifiers, extendsClause, implementsClause, body, typeParameters, identifier, javadoc);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a LocalClassDeclarationNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public LocalClassDeclarationNode makeLocalClassDeclarationNode(
            LocalClassModifiersNode modifiers,
            DeclaredTypeNode extendsClause,
            DeclaredTypeListNode implementsClause,
            ClassBodyNode body,
            TypeParameterListNode typeParameters,
            IdentifierNode identifier,
            JavadocNode javadoc)
    {
        this.before();
        LocalClassDeclarationNode node = factory.makeLocalClassDeclarationNode(modifiers, extendsClause, implementsClause, body, typeParameters, identifier, javadoc);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a LocalClassDeclarationNode.
     * The specified start and stop locations are used.
     */
    @Override
    public LocalClassDeclarationNode makeLocalClassDeclarationNodeWithUnions(
            NodeUnion<? extends LocalClassModifiersNode> modifiers,
            NodeUnion<? extends DeclaredTypeNode> extendsClause,
            NodeUnion<? extends DeclaredTypeListNode> implementsClause,
            NodeUnion<? extends ClassBodyNode> body,
            NodeUnion<? extends TypeParameterListNode> typeParameters,
            NodeUnion<? extends IdentifierNode> identifier,
            NodeUnion<? extends JavadocNode> javadoc,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        LocalClassDeclarationNode node = factory.makeLocalClassDeclarationNodeWithUnions(modifiers, extendsClause, implementsClause, body, typeParameters, identifier, javadoc, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a LocalClassDeclarationNode.
     * The specified start and stop locations are used.
     */
    @Override
    public LocalClassDeclarationNode makeLocalClassDeclarationNode(
            LocalClassModifiersNode modifiers,
            DeclaredTypeNode extendsClause,
            DeclaredTypeListNode implementsClause,
            ClassBodyNode body,
            TypeParameterListNode typeParameters,
            IdentifierNode identifier,
            JavadocNode javadoc,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        LocalClassDeclarationNode node = factory.makeLocalClassDeclarationNode(modifiers, extendsClause, implementsClause, body, typeParameters, identifier, javadoc, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a LocalClassModifiersNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public LocalClassModifiersNode makeLocalClassModifiersNodeWithUnions(
            boolean abstractFlag,
            boolean finalFlag,
            boolean strictfpFlag,
            NodeUnion<? extends MetaAnnotationListNode> metaAnnotations,
            NodeUnion<? extends AnnotationListNode> annotations)
    {
        this.before();
        LocalClassModifiersNode node = factory.makeLocalClassModifiersNodeWithUnions(abstractFlag, finalFlag, strictfpFlag, metaAnnotations, annotations);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a LocalClassModifiersNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public LocalClassModifiersNode makeLocalClassModifiersNode(
            boolean abstractFlag,
            boolean finalFlag,
            boolean strictfpFlag,
            MetaAnnotationListNode metaAnnotations,
            AnnotationListNode annotations)
    {
        this.before();
        LocalClassModifiersNode node = factory.makeLocalClassModifiersNode(abstractFlag, finalFlag, strictfpFlag, metaAnnotations, annotations);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a LocalClassModifiersNode.
     * The specified start and stop locations are used.
     */
    @Override
    public LocalClassModifiersNode makeLocalClassModifiersNodeWithUnions(
            boolean abstractFlag,
            boolean finalFlag,
            boolean strictfpFlag,
            NodeUnion<? extends MetaAnnotationListNode> metaAnnotations,
            NodeUnion<? extends AnnotationListNode> annotations,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        LocalClassModifiersNode node = factory.makeLocalClassModifiersNodeWithUnions(abstractFlag, finalFlag, strictfpFlag, metaAnnotations, annotations, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a LocalClassModifiersNode.
     * The specified start and stop locations are used.
     */
    @Override
    public LocalClassModifiersNode makeLocalClassModifiersNode(
            boolean abstractFlag,
            boolean finalFlag,
            boolean strictfpFlag,
            MetaAnnotationListNode metaAnnotations,
            AnnotationListNode annotations,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        LocalClassModifiersNode node = factory.makeLocalClassModifiersNode(abstractFlag, finalFlag, strictfpFlag, metaAnnotations, annotations, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a LocalClassModifiersNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public LocalClassModifiersNode makeLocalClassModifiersNode(
    )
    {
        this.before();
        LocalClassModifiersNode node = factory.makeLocalClassModifiersNode();
        this.after(node);
        return node;
    }
    
    /**
     * Creates a LocalClassModifiersNode.
     * The specified start and stop locations are used.
     */
    @Override
    public LocalClassModifiersNode makeLocalClassModifiersNode(
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        LocalClassModifiersNode node = factory.makeLocalClassModifiersNode(startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a LocalVariableDeclarationNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public LocalVariableDeclarationNode makeLocalVariableDeclarationNodeWithUnions(
            NodeUnion<? extends VariableModifiersNode> modifiers,
            NodeUnion<? extends TypeNode> type,
            NodeUnion<? extends VariableDeclaratorListNode> declarators)
    {
        this.before();
        LocalVariableDeclarationNode node = factory.makeLocalVariableDeclarationNodeWithUnions(modifiers, type, declarators);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a LocalVariableDeclarationNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public LocalVariableDeclarationNode makeLocalVariableDeclarationNode(
            VariableModifiersNode modifiers,
            TypeNode type,
            VariableDeclaratorListNode declarators)
    {
        this.before();
        LocalVariableDeclarationNode node = factory.makeLocalVariableDeclarationNode(modifiers, type, declarators);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a LocalVariableDeclarationNode.
     * The specified start and stop locations are used.
     */
    @Override
    public LocalVariableDeclarationNode makeLocalVariableDeclarationNodeWithUnions(
            NodeUnion<? extends VariableModifiersNode> modifiers,
            NodeUnion<? extends TypeNode> type,
            NodeUnion<? extends VariableDeclaratorListNode> declarators,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        LocalVariableDeclarationNode node = factory.makeLocalVariableDeclarationNodeWithUnions(modifiers, type, declarators, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a LocalVariableDeclarationNode.
     * The specified start and stop locations are used.
     */
    @Override
    public LocalVariableDeclarationNode makeLocalVariableDeclarationNode(
            VariableModifiersNode modifiers,
            TypeNode type,
            VariableDeclaratorListNode declarators,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        LocalVariableDeclarationNode node = factory.makeLocalVariableDeclarationNode(modifiers, type, declarators, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a LocalVariableDeclarationNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public LocalVariableDeclarationNode makeLocalVariableDeclarationNode(
            TypeNode type,
            VariableDeclaratorListNode declarators)
    {
        this.before();
        LocalVariableDeclarationNode node = factory.makeLocalVariableDeclarationNode(type, declarators);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a LocalVariableDeclarationNode.
     * The specified start and stop locations are used.
     */
    @Override
    public LocalVariableDeclarationNode makeLocalVariableDeclarationNode(
            TypeNode type,
            VariableDeclaratorListNode declarators,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        LocalVariableDeclarationNode node = factory.makeLocalVariableDeclarationNode(type, declarators, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a LongLiteralNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public LongLiteralNode makeLongLiteralNode(
            Long value)
    {
        this.before();
        LongLiteralNode node = factory.makeLongLiteralNode(value);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a LongLiteralNode.
     * The specified start and stop locations are used.
     */
    @Override
    public LongLiteralNode makeLongLiteralNode(
            Long value,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        LongLiteralNode node = factory.makeLongLiteralNode(value, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a MetaAnnotationArrayValueNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public MetaAnnotationArrayValueNode makeMetaAnnotationArrayValueNodeWithUnions(
            NodeUnion<? extends MetaAnnotationValueListNode> values)
    {
        this.before();
        MetaAnnotationArrayValueNode node = factory.makeMetaAnnotationArrayValueNodeWithUnions(values);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a MetaAnnotationArrayValueNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public MetaAnnotationArrayValueNode makeMetaAnnotationArrayValueNode(
            MetaAnnotationValueListNode values)
    {
        this.before();
        MetaAnnotationArrayValueNode node = factory.makeMetaAnnotationArrayValueNode(values);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a MetaAnnotationArrayValueNode.
     * The specified start and stop locations are used.
     */
    @Override
    public MetaAnnotationArrayValueNode makeMetaAnnotationArrayValueNodeWithUnions(
            NodeUnion<? extends MetaAnnotationValueListNode> values,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        MetaAnnotationArrayValueNode node = factory.makeMetaAnnotationArrayValueNodeWithUnions(values, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a MetaAnnotationArrayValueNode.
     * The specified start and stop locations are used.
     */
    @Override
    public MetaAnnotationArrayValueNode makeMetaAnnotationArrayValueNode(
            MetaAnnotationValueListNode values,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        MetaAnnotationArrayValueNode node = factory.makeMetaAnnotationArrayValueNode(values, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a MetaAnnotationElementListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public MetaAnnotationElementListNode makeMetaAnnotationElementListNodeWithUnions(
            List<NodeUnion<? extends MetaAnnotationElementNode>> children)
    {
        this.before();
        MetaAnnotationElementListNode node = factory.makeMetaAnnotationElementListNodeWithUnions(children);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a MetaAnnotationElementListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public MetaAnnotationElementListNode makeMetaAnnotationElementListNode(
            List<MetaAnnotationElementNode> children)
    {
        this.before();
        MetaAnnotationElementListNode node = factory.makeMetaAnnotationElementListNode(children);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a MetaAnnotationElementListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public MetaAnnotationElementListNode makeMetaAnnotationElementListNode(
            MetaAnnotationElementNode... childrenElements)
    {
        this.before();
        MetaAnnotationElementListNode node = factory.makeMetaAnnotationElementListNode(childrenElements);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a MetaAnnotationElementListNode.
     * The specified start and stop locations are used.
     */
    @Override
    public MetaAnnotationElementListNode makeMetaAnnotationElementListNodeWithUnions(
            List<NodeUnion<? extends MetaAnnotationElementNode>> children,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        MetaAnnotationElementListNode node = factory.makeMetaAnnotationElementListNodeWithUnions(children, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a MetaAnnotationElementListNode.
     * The specified start and stop locations are used.
     */
    @Override
    public MetaAnnotationElementListNode makeMetaAnnotationElementListNode(
            List<MetaAnnotationElementNode> children,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        MetaAnnotationElementListNode node = factory.makeMetaAnnotationElementListNode(children, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a MetaAnnotationElementListNode.
     * The specified start and stop locations are used.
     */
    @Override
    public MetaAnnotationElementListNode makeMetaAnnotationElementListNode(
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation,
            MetaAnnotationElementNode... childrenElements)
    {
        this.before();
        MetaAnnotationElementListNode node = factory.makeMetaAnnotationElementListNode(startLocation, stopLocation, childrenElements);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a MetaAnnotationElementNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public MetaAnnotationElementNode makeMetaAnnotationElementNodeWithUnions(
            NodeUnion<? extends IdentifierNode> identifier,
            NodeUnion<? extends MetaAnnotationValueNode> value)
    {
        this.before();
        MetaAnnotationElementNode node = factory.makeMetaAnnotationElementNodeWithUnions(identifier, value);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a MetaAnnotationElementNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public MetaAnnotationElementNode makeMetaAnnotationElementNode(
            IdentifierNode identifier,
            MetaAnnotationValueNode value)
    {
        this.before();
        MetaAnnotationElementNode node = factory.makeMetaAnnotationElementNode(identifier, value);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a MetaAnnotationElementNode.
     * The specified start and stop locations are used.
     */
    @Override
    public MetaAnnotationElementNode makeMetaAnnotationElementNodeWithUnions(
            NodeUnion<? extends IdentifierNode> identifier,
            NodeUnion<? extends MetaAnnotationValueNode> value,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        MetaAnnotationElementNode node = factory.makeMetaAnnotationElementNodeWithUnions(identifier, value, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a MetaAnnotationElementNode.
     * The specified start and stop locations are used.
     */
    @Override
    public MetaAnnotationElementNode makeMetaAnnotationElementNode(
            IdentifierNode identifier,
            MetaAnnotationValueNode value,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        MetaAnnotationElementNode node = factory.makeMetaAnnotationElementNode(identifier, value, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a MetaAnnotationExpressionValueNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public MetaAnnotationExpressionValueNode makeMetaAnnotationExpressionValueNodeWithUnions(
            NodeUnion<? extends NonAssignmentExpressionNode> expression)
    {
        this.before();
        MetaAnnotationExpressionValueNode node = factory.makeMetaAnnotationExpressionValueNodeWithUnions(expression);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a MetaAnnotationExpressionValueNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public MetaAnnotationExpressionValueNode makeMetaAnnotationExpressionValueNode(
            NonAssignmentExpressionNode expression)
    {
        this.before();
        MetaAnnotationExpressionValueNode node = factory.makeMetaAnnotationExpressionValueNode(expression);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a MetaAnnotationExpressionValueNode.
     * The specified start and stop locations are used.
     */
    @Override
    public MetaAnnotationExpressionValueNode makeMetaAnnotationExpressionValueNodeWithUnions(
            NodeUnion<? extends NonAssignmentExpressionNode> expression,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        MetaAnnotationExpressionValueNode node = factory.makeMetaAnnotationExpressionValueNodeWithUnions(expression, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a MetaAnnotationExpressionValueNode.
     * The specified start and stop locations are used.
     */
    @Override
    public MetaAnnotationExpressionValueNode makeMetaAnnotationExpressionValueNode(
            NonAssignmentExpressionNode expression,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        MetaAnnotationExpressionValueNode node = factory.makeMetaAnnotationExpressionValueNode(expression, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a MetaAnnotationListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public MetaAnnotationListNode makeMetaAnnotationListNodeWithUnions(
            List<NodeUnion<? extends MetaAnnotationNode>> children)
    {
        this.before();
        MetaAnnotationListNode node = factory.makeMetaAnnotationListNodeWithUnions(children);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a MetaAnnotationListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public MetaAnnotationListNode makeMetaAnnotationListNode(
            List<MetaAnnotationNode> children)
    {
        this.before();
        MetaAnnotationListNode node = factory.makeMetaAnnotationListNode(children);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a MetaAnnotationListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public MetaAnnotationListNode makeMetaAnnotationListNode(
            MetaAnnotationNode... childrenElements)
    {
        this.before();
        MetaAnnotationListNode node = factory.makeMetaAnnotationListNode(childrenElements);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a MetaAnnotationListNode.
     * The specified start and stop locations are used.
     */
    @Override
    public MetaAnnotationListNode makeMetaAnnotationListNodeWithUnions(
            List<NodeUnion<? extends MetaAnnotationNode>> children,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        MetaAnnotationListNode node = factory.makeMetaAnnotationListNodeWithUnions(children, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a MetaAnnotationListNode.
     * The specified start and stop locations are used.
     */
    @Override
    public MetaAnnotationListNode makeMetaAnnotationListNode(
            List<MetaAnnotationNode> children,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        MetaAnnotationListNode node = factory.makeMetaAnnotationListNode(children, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a MetaAnnotationListNode.
     * The specified start and stop locations are used.
     */
    @Override
    public MetaAnnotationListNode makeMetaAnnotationListNode(
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation,
            MetaAnnotationNode... childrenElements)
    {
        this.before();
        MetaAnnotationListNode node = factory.makeMetaAnnotationListNode(startLocation, stopLocation, childrenElements);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a MetaAnnotationMetaAnnotationValueNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public MetaAnnotationMetaAnnotationValueNode makeMetaAnnotationMetaAnnotationValueNodeWithUnions(
            NodeUnion<? extends MetaAnnotationNode> annotation)
    {
        this.before();
        MetaAnnotationMetaAnnotationValueNode node = factory.makeMetaAnnotationMetaAnnotationValueNodeWithUnions(annotation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a MetaAnnotationMetaAnnotationValueNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public MetaAnnotationMetaAnnotationValueNode makeMetaAnnotationMetaAnnotationValueNode(
            MetaAnnotationNode annotation)
    {
        this.before();
        MetaAnnotationMetaAnnotationValueNode node = factory.makeMetaAnnotationMetaAnnotationValueNode(annotation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a MetaAnnotationMetaAnnotationValueNode.
     * The specified start and stop locations are used.
     */
    @Override
    public MetaAnnotationMetaAnnotationValueNode makeMetaAnnotationMetaAnnotationValueNodeWithUnions(
            NodeUnion<? extends MetaAnnotationNode> annotation,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        MetaAnnotationMetaAnnotationValueNode node = factory.makeMetaAnnotationMetaAnnotationValueNodeWithUnions(annotation, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a MetaAnnotationMetaAnnotationValueNode.
     * The specified start and stop locations are used.
     */
    @Override
    public MetaAnnotationMetaAnnotationValueNode makeMetaAnnotationMetaAnnotationValueNode(
            MetaAnnotationNode annotation,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        MetaAnnotationMetaAnnotationValueNode node = factory.makeMetaAnnotationMetaAnnotationValueNode(annotation, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a MetaAnnotationMetaprogramAnchorNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public MetaAnnotationMetaprogramAnchorNode makeMetaAnnotationMetaprogramAnchorNode(
    )
    {
        this.before();
        MetaAnnotationMetaprogramAnchorNode node = factory.makeMetaAnnotationMetaprogramAnchorNode();
        this.after(node);
        return node;
    }
    
    /**
     * Creates a MetaAnnotationMetaprogramAnchorNode.
     * The specified start and stop locations are used.
     */
    @Override
    public MetaAnnotationMetaprogramAnchorNode makeMetaAnnotationMetaprogramAnchorNode(
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        MetaAnnotationMetaprogramAnchorNode node = factory.makeMetaAnnotationMetaprogramAnchorNode(startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a MetaAnnotationValueListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public MetaAnnotationValueListNode makeMetaAnnotationValueListNodeWithUnions(
            List<NodeUnion<? extends MetaAnnotationValueNode>> children)
    {
        this.before();
        MetaAnnotationValueListNode node = factory.makeMetaAnnotationValueListNodeWithUnions(children);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a MetaAnnotationValueListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public MetaAnnotationValueListNode makeMetaAnnotationValueListNode(
            List<MetaAnnotationValueNode> children)
    {
        this.before();
        MetaAnnotationValueListNode node = factory.makeMetaAnnotationValueListNode(children);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a MetaAnnotationValueListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public MetaAnnotationValueListNode makeMetaAnnotationValueListNode(
            MetaAnnotationValueNode... childrenElements)
    {
        this.before();
        MetaAnnotationValueListNode node = factory.makeMetaAnnotationValueListNode(childrenElements);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a MetaAnnotationValueListNode.
     * The specified start and stop locations are used.
     */
    @Override
    public MetaAnnotationValueListNode makeMetaAnnotationValueListNodeWithUnions(
            List<NodeUnion<? extends MetaAnnotationValueNode>> children,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        MetaAnnotationValueListNode node = factory.makeMetaAnnotationValueListNodeWithUnions(children, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a MetaAnnotationValueListNode.
     * The specified start and stop locations are used.
     */
    @Override
    public MetaAnnotationValueListNode makeMetaAnnotationValueListNode(
            List<MetaAnnotationValueNode> children,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        MetaAnnotationValueListNode node = factory.makeMetaAnnotationValueListNode(children, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a MetaAnnotationValueListNode.
     * The specified start and stop locations are used.
     */
    @Override
    public MetaAnnotationValueListNode makeMetaAnnotationValueListNode(
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation,
            MetaAnnotationValueNode... childrenElements)
    {
        this.before();
        MetaAnnotationValueListNode node = factory.makeMetaAnnotationValueListNode(startLocation, stopLocation, childrenElements);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a MetaprogramDependencyDeclarationListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public MetaprogramDependencyDeclarationListNode makeMetaprogramDependencyDeclarationListNodeWithUnions(
            List<NodeUnion<? extends MetaprogramDependencyDeclarationNode>> children)
    {
        this.before();
        MetaprogramDependencyDeclarationListNode node = factory.makeMetaprogramDependencyDeclarationListNodeWithUnions(children);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a MetaprogramDependencyDeclarationListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public MetaprogramDependencyDeclarationListNode makeMetaprogramDependencyDeclarationListNode(
            List<MetaprogramDependencyDeclarationNode> children)
    {
        this.before();
        MetaprogramDependencyDeclarationListNode node = factory.makeMetaprogramDependencyDeclarationListNode(children);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a MetaprogramDependencyDeclarationListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public MetaprogramDependencyDeclarationListNode makeMetaprogramDependencyDeclarationListNode(
            MetaprogramDependencyDeclarationNode... childrenElements)
    {
        this.before();
        MetaprogramDependencyDeclarationListNode node = factory.makeMetaprogramDependencyDeclarationListNode(childrenElements);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a MetaprogramDependencyDeclarationListNode.
     * The specified start and stop locations are used.
     */
    @Override
    public MetaprogramDependencyDeclarationListNode makeMetaprogramDependencyDeclarationListNodeWithUnions(
            List<NodeUnion<? extends MetaprogramDependencyDeclarationNode>> children,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        MetaprogramDependencyDeclarationListNode node = factory.makeMetaprogramDependencyDeclarationListNodeWithUnions(children, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a MetaprogramDependencyDeclarationListNode.
     * The specified start and stop locations are used.
     */
    @Override
    public MetaprogramDependencyDeclarationListNode makeMetaprogramDependencyDeclarationListNode(
            List<MetaprogramDependencyDeclarationNode> children,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        MetaprogramDependencyDeclarationListNode node = factory.makeMetaprogramDependencyDeclarationListNode(children, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a MetaprogramDependencyDeclarationListNode.
     * The specified start and stop locations are used.
     */
    @Override
    public MetaprogramDependencyDeclarationListNode makeMetaprogramDependencyDeclarationListNode(
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation,
            MetaprogramDependencyDeclarationNode... childrenElements)
    {
        this.before();
        MetaprogramDependencyDeclarationListNode node = factory.makeMetaprogramDependencyDeclarationListNode(startLocation, stopLocation, childrenElements);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a MetaprogramDependencyDeclarationNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public MetaprogramDependencyDeclarationNode makeMetaprogramDependencyDeclarationNodeWithUnions(
            NodeUnion<? extends MetaprogramDependencyListNode> targets)
    {
        this.before();
        MetaprogramDependencyDeclarationNode node = factory.makeMetaprogramDependencyDeclarationNodeWithUnions(targets);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a MetaprogramDependencyDeclarationNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public MetaprogramDependencyDeclarationNode makeMetaprogramDependencyDeclarationNode(
            MetaprogramDependencyListNode targets)
    {
        this.before();
        MetaprogramDependencyDeclarationNode node = factory.makeMetaprogramDependencyDeclarationNode(targets);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a MetaprogramDependencyDeclarationNode.
     * The specified start and stop locations are used.
     */
    @Override
    public MetaprogramDependencyDeclarationNode makeMetaprogramDependencyDeclarationNodeWithUnions(
            NodeUnion<? extends MetaprogramDependencyListNode> targets,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        MetaprogramDependencyDeclarationNode node = factory.makeMetaprogramDependencyDeclarationNodeWithUnions(targets, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a MetaprogramDependencyDeclarationNode.
     * The specified start and stop locations are used.
     */
    @Override
    public MetaprogramDependencyDeclarationNode makeMetaprogramDependencyDeclarationNode(
            MetaprogramDependencyListNode targets,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        MetaprogramDependencyDeclarationNode node = factory.makeMetaprogramDependencyDeclarationNode(targets, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a MetaprogramDependencyListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public MetaprogramDependencyListNode makeMetaprogramDependencyListNodeWithUnions(
            List<NodeUnion<? extends MetaprogramDependencyNode>> children)
    {
        this.before();
        MetaprogramDependencyListNode node = factory.makeMetaprogramDependencyListNodeWithUnions(children);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a MetaprogramDependencyListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public MetaprogramDependencyListNode makeMetaprogramDependencyListNode(
            List<MetaprogramDependencyNode> children)
    {
        this.before();
        MetaprogramDependencyListNode node = factory.makeMetaprogramDependencyListNode(children);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a MetaprogramDependencyListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public MetaprogramDependencyListNode makeMetaprogramDependencyListNode(
            MetaprogramDependencyNode... childrenElements)
    {
        this.before();
        MetaprogramDependencyListNode node = factory.makeMetaprogramDependencyListNode(childrenElements);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a MetaprogramDependencyListNode.
     * The specified start and stop locations are used.
     */
    @Override
    public MetaprogramDependencyListNode makeMetaprogramDependencyListNodeWithUnions(
            List<NodeUnion<? extends MetaprogramDependencyNode>> children,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        MetaprogramDependencyListNode node = factory.makeMetaprogramDependencyListNodeWithUnions(children, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a MetaprogramDependencyListNode.
     * The specified start and stop locations are used.
     */
    @Override
    public MetaprogramDependencyListNode makeMetaprogramDependencyListNode(
            List<MetaprogramDependencyNode> children,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        MetaprogramDependencyListNode node = factory.makeMetaprogramDependencyListNode(children, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a MetaprogramDependencyListNode.
     * The specified start and stop locations are used.
     */
    @Override
    public MetaprogramDependencyListNode makeMetaprogramDependencyListNode(
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation,
            MetaprogramDependencyNode... childrenElements)
    {
        this.before();
        MetaprogramDependencyListNode node = factory.makeMetaprogramDependencyListNode(startLocation, stopLocation, childrenElements);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a MetaprogramDependencyNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public MetaprogramDependencyNode makeMetaprogramDependencyNodeWithUnions(
            NodeUnion<? extends NameNode> targetName,
            boolean weak)
    {
        this.before();
        MetaprogramDependencyNode node = factory.makeMetaprogramDependencyNodeWithUnions(targetName, weak);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a MetaprogramDependencyNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public MetaprogramDependencyNode makeMetaprogramDependencyNode(
            NameNode targetName,
            boolean weak)
    {
        this.before();
        MetaprogramDependencyNode node = factory.makeMetaprogramDependencyNode(targetName, weak);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a MetaprogramDependencyNode.
     * The specified start and stop locations are used.
     */
    @Override
    public MetaprogramDependencyNode makeMetaprogramDependencyNodeWithUnions(
            NodeUnion<? extends NameNode> targetName,
            boolean weak,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        MetaprogramDependencyNode node = factory.makeMetaprogramDependencyNodeWithUnions(targetName, weak, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a MetaprogramDependencyNode.
     * The specified start and stop locations are used.
     */
    @Override
    public MetaprogramDependencyNode makeMetaprogramDependencyNode(
            NameNode targetName,
            boolean weak,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        MetaprogramDependencyNode node = factory.makeMetaprogramDependencyNode(targetName, weak, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a MetaprogramDependencyNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public MetaprogramDependencyNode makeMetaprogramDependencyNode(
            NameNode targetName)
    {
        this.before();
        MetaprogramDependencyNode node = factory.makeMetaprogramDependencyNode(targetName);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a MetaprogramDependencyNode.
     * The specified start and stop locations are used.
     */
    @Override
    public MetaprogramDependencyNode makeMetaprogramDependencyNode(
            NameNode targetName,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        MetaprogramDependencyNode node = factory.makeMetaprogramDependencyNode(targetName, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a MetaprogramImportListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public MetaprogramImportListNode makeMetaprogramImportListNodeWithUnions(
            List<NodeUnion<? extends MetaprogramImportNode>> children)
    {
        this.before();
        MetaprogramImportListNode node = factory.makeMetaprogramImportListNodeWithUnions(children);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a MetaprogramImportListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public MetaprogramImportListNode makeMetaprogramImportListNode(
            List<MetaprogramImportNode> children)
    {
        this.before();
        MetaprogramImportListNode node = factory.makeMetaprogramImportListNode(children);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a MetaprogramImportListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public MetaprogramImportListNode makeMetaprogramImportListNode(
            MetaprogramImportNode... childrenElements)
    {
        this.before();
        MetaprogramImportListNode node = factory.makeMetaprogramImportListNode(childrenElements);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a MetaprogramImportListNode.
     * The specified start and stop locations are used.
     */
    @Override
    public MetaprogramImportListNode makeMetaprogramImportListNodeWithUnions(
            List<NodeUnion<? extends MetaprogramImportNode>> children,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        MetaprogramImportListNode node = factory.makeMetaprogramImportListNodeWithUnions(children, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a MetaprogramImportListNode.
     * The specified start and stop locations are used.
     */
    @Override
    public MetaprogramImportListNode makeMetaprogramImportListNode(
            List<MetaprogramImportNode> children,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        MetaprogramImportListNode node = factory.makeMetaprogramImportListNode(children, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a MetaprogramImportListNode.
     * The specified start and stop locations are used.
     */
    @Override
    public MetaprogramImportListNode makeMetaprogramImportListNode(
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation,
            MetaprogramImportNode... childrenElements)
    {
        this.before();
        MetaprogramImportListNode node = factory.makeMetaprogramImportListNode(startLocation, stopLocation, childrenElements);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a MetaprogramImportNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public MetaprogramImportNode makeMetaprogramImportNodeWithUnions(
            NodeUnion<? extends ImportNode> importNode)
    {
        this.before();
        MetaprogramImportNode node = factory.makeMetaprogramImportNodeWithUnions(importNode);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a MetaprogramImportNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public MetaprogramImportNode makeMetaprogramImportNode(
            ImportNode importNode)
    {
        this.before();
        MetaprogramImportNode node = factory.makeMetaprogramImportNode(importNode);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a MetaprogramImportNode.
     * The specified start and stop locations are used.
     */
    @Override
    public MetaprogramImportNode makeMetaprogramImportNodeWithUnions(
            NodeUnion<? extends ImportNode> importNode,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        MetaprogramImportNode node = factory.makeMetaprogramImportNodeWithUnions(importNode, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a MetaprogramImportNode.
     * The specified start and stop locations are used.
     */
    @Override
    public MetaprogramImportNode makeMetaprogramImportNode(
            ImportNode importNode,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        MetaprogramImportNode node = factory.makeMetaprogramImportNode(importNode, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a MetaprogramNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public MetaprogramNode makeMetaprogramNodeWithUnions(
            NodeUnion<? extends MetaprogramPreambleNode> preamble,
            NodeUnion<? extends BlockStatementListNode> body)
    {
        this.before();
        MetaprogramNode node = factory.makeMetaprogramNodeWithUnions(preamble, body);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a MetaprogramNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public MetaprogramNode makeMetaprogramNode(
            MetaprogramPreambleNode preamble,
            BlockStatementListNode body)
    {
        this.before();
        MetaprogramNode node = factory.makeMetaprogramNode(preamble, body);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a MetaprogramNode.
     * The specified start and stop locations are used.
     */
    @Override
    public MetaprogramNode makeMetaprogramNodeWithUnions(
            NodeUnion<? extends MetaprogramPreambleNode> preamble,
            NodeUnion<? extends BlockStatementListNode> body,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        MetaprogramNode node = factory.makeMetaprogramNodeWithUnions(preamble, body, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a MetaprogramNode.
     * The specified start and stop locations are used.
     */
    @Override
    public MetaprogramNode makeMetaprogramNode(
            MetaprogramPreambleNode preamble,
            BlockStatementListNode body,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        MetaprogramNode node = factory.makeMetaprogramNode(preamble, body, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a MetaprogramPreambleNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public MetaprogramPreambleNode makeMetaprogramPreambleNodeWithUnions(
            NodeUnion<? extends MetaprogramImportListNode> imports,
            MetaprogramLocalMode localMode,
            MetaprogramPackageMode packageMode,
            NodeUnion<? extends MetaprogramTargetListNode> targets,
            NodeUnion<? extends MetaprogramDependencyDeclarationListNode> dependencies)
    {
        this.before();
        MetaprogramPreambleNode node = factory.makeMetaprogramPreambleNodeWithUnions(imports, localMode, packageMode, targets, dependencies);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a MetaprogramPreambleNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public MetaprogramPreambleNode makeMetaprogramPreambleNode(
            MetaprogramImportListNode imports,
            MetaprogramLocalMode localMode,
            MetaprogramPackageMode packageMode,
            MetaprogramTargetListNode targets,
            MetaprogramDependencyDeclarationListNode dependencies)
    {
        this.before();
        MetaprogramPreambleNode node = factory.makeMetaprogramPreambleNode(imports, localMode, packageMode, targets, dependencies);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a MetaprogramPreambleNode.
     * The specified start and stop locations are used.
     */
    @Override
    public MetaprogramPreambleNode makeMetaprogramPreambleNodeWithUnions(
            NodeUnion<? extends MetaprogramImportListNode> imports,
            MetaprogramLocalMode localMode,
            MetaprogramPackageMode packageMode,
            NodeUnion<? extends MetaprogramTargetListNode> targets,
            NodeUnion<? extends MetaprogramDependencyDeclarationListNode> dependencies,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        MetaprogramPreambleNode node = factory.makeMetaprogramPreambleNodeWithUnions(imports, localMode, packageMode, targets, dependencies, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a MetaprogramPreambleNode.
     * The specified start and stop locations are used.
     */
    @Override
    public MetaprogramPreambleNode makeMetaprogramPreambleNode(
            MetaprogramImportListNode imports,
            MetaprogramLocalMode localMode,
            MetaprogramPackageMode packageMode,
            MetaprogramTargetListNode targets,
            MetaprogramDependencyDeclarationListNode dependencies,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        MetaprogramPreambleNode node = factory.makeMetaprogramPreambleNode(imports, localMode, packageMode, targets, dependencies, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a MetaprogramPreambleNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public MetaprogramPreambleNode makeMetaprogramPreambleNode(
            MetaprogramImportListNode imports,
            MetaprogramTargetListNode targets,
            MetaprogramDependencyDeclarationListNode dependencies)
    {
        this.before();
        MetaprogramPreambleNode node = factory.makeMetaprogramPreambleNode(imports, targets, dependencies);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a MetaprogramPreambleNode.
     * The specified start and stop locations are used.
     */
    @Override
    public MetaprogramPreambleNode makeMetaprogramPreambleNode(
            MetaprogramImportListNode imports,
            MetaprogramTargetListNode targets,
            MetaprogramDependencyDeclarationListNode dependencies,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        MetaprogramPreambleNode node = factory.makeMetaprogramPreambleNode(imports, targets, dependencies, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a MetaprogramTargetListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public MetaprogramTargetListNode makeMetaprogramTargetListNodeWithUnions(
            List<NodeUnion<? extends MetaprogramTargetNode>> children)
    {
        this.before();
        MetaprogramTargetListNode node = factory.makeMetaprogramTargetListNodeWithUnions(children);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a MetaprogramTargetListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public MetaprogramTargetListNode makeMetaprogramTargetListNode(
            List<MetaprogramTargetNode> children)
    {
        this.before();
        MetaprogramTargetListNode node = factory.makeMetaprogramTargetListNode(children);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a MetaprogramTargetListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public MetaprogramTargetListNode makeMetaprogramTargetListNode(
            MetaprogramTargetNode... childrenElements)
    {
        this.before();
        MetaprogramTargetListNode node = factory.makeMetaprogramTargetListNode(childrenElements);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a MetaprogramTargetListNode.
     * The specified start and stop locations are used.
     */
    @Override
    public MetaprogramTargetListNode makeMetaprogramTargetListNodeWithUnions(
            List<NodeUnion<? extends MetaprogramTargetNode>> children,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        MetaprogramTargetListNode node = factory.makeMetaprogramTargetListNodeWithUnions(children, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a MetaprogramTargetListNode.
     * The specified start and stop locations are used.
     */
    @Override
    public MetaprogramTargetListNode makeMetaprogramTargetListNode(
            List<MetaprogramTargetNode> children,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        MetaprogramTargetListNode node = factory.makeMetaprogramTargetListNode(children, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a MetaprogramTargetListNode.
     * The specified start and stop locations are used.
     */
    @Override
    public MetaprogramTargetListNode makeMetaprogramTargetListNode(
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation,
            MetaprogramTargetNode... childrenElements)
    {
        this.before();
        MetaprogramTargetListNode node = factory.makeMetaprogramTargetListNode(startLocation, stopLocation, childrenElements);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a MetaprogramTargetNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public MetaprogramTargetNode makeMetaprogramTargetNodeWithUnions(
            NodeUnion<? extends IdentifierListNode> targets)
    {
        this.before();
        MetaprogramTargetNode node = factory.makeMetaprogramTargetNodeWithUnions(targets);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a MetaprogramTargetNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public MetaprogramTargetNode makeMetaprogramTargetNode(
            IdentifierListNode targets)
    {
        this.before();
        MetaprogramTargetNode node = factory.makeMetaprogramTargetNode(targets);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a MetaprogramTargetNode.
     * The specified start and stop locations are used.
     */
    @Override
    public MetaprogramTargetNode makeMetaprogramTargetNodeWithUnions(
            NodeUnion<? extends IdentifierListNode> targets,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        MetaprogramTargetNode node = factory.makeMetaprogramTargetNodeWithUnions(targets, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a MetaprogramTargetNode.
     * The specified start and stop locations are used.
     */
    @Override
    public MetaprogramTargetNode makeMetaprogramTargetNode(
            IdentifierListNode targets,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        MetaprogramTargetNode node = factory.makeMetaprogramTargetNode(targets, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a MethodDeclarationNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public MethodDeclarationNode makeMethodDeclarationNodeWithUnions(
            NodeUnion<? extends BlockStatementListNode> body,
            NodeUnion<? extends MethodModifiersNode> modifiers,
            NodeUnion<? extends IdentifierNode> identifier,
            NodeUnion<? extends VariableListNode> parameters,
            NodeUnion<? extends VariableNode> varargParameter,
            NodeUnion<? extends TypeNode> returnType,
            NodeUnion<? extends UnparameterizedTypeListNode> throwTypes,
            NodeUnion<? extends TypeParameterListNode> typeParameters,
            NodeUnion<? extends JavadocNode> javadoc)
    {
        this.before();
        MethodDeclarationNode node = factory.makeMethodDeclarationNodeWithUnions(body, modifiers, identifier, parameters, varargParameter, returnType, throwTypes, typeParameters, javadoc);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a MethodDeclarationNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public MethodDeclarationNode makeMethodDeclarationNode(
            BlockStatementListNode body,
            MethodModifiersNode modifiers,
            IdentifierNode identifier,
            VariableListNode parameters,
            VariableNode varargParameter,
            TypeNode returnType,
            UnparameterizedTypeListNode throwTypes,
            TypeParameterListNode typeParameters,
            JavadocNode javadoc)
    {
        this.before();
        MethodDeclarationNode node = factory.makeMethodDeclarationNode(body, modifiers, identifier, parameters, varargParameter, returnType, throwTypes, typeParameters, javadoc);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a MethodDeclarationNode.
     * The specified start and stop locations are used.
     */
    @Override
    public MethodDeclarationNode makeMethodDeclarationNodeWithUnions(
            NodeUnion<? extends BlockStatementListNode> body,
            NodeUnion<? extends MethodModifiersNode> modifiers,
            NodeUnion<? extends IdentifierNode> identifier,
            NodeUnion<? extends VariableListNode> parameters,
            NodeUnion<? extends VariableNode> varargParameter,
            NodeUnion<? extends TypeNode> returnType,
            NodeUnion<? extends UnparameterizedTypeListNode> throwTypes,
            NodeUnion<? extends TypeParameterListNode> typeParameters,
            NodeUnion<? extends JavadocNode> javadoc,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        MethodDeclarationNode node = factory.makeMethodDeclarationNodeWithUnions(body, modifiers, identifier, parameters, varargParameter, returnType, throwTypes, typeParameters, javadoc, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a MethodDeclarationNode.
     * The specified start and stop locations are used.
     */
    @Override
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
            BsjSourceLocation stopLocation)
    {
        this.before();
        MethodDeclarationNode node = factory.makeMethodDeclarationNode(body, modifiers, identifier, parameters, varargParameter, returnType, throwTypes, typeParameters, javadoc, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a MethodDeclarationNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public MethodDeclarationNode makeMethodDeclarationNode(
            BlockStatementListNode body,
            MethodModifiersNode modifiers,
            IdentifierNode identifier,
            VariableListNode parameters,
            TypeNode returnType,
            JavadocNode javadoc)
    {
        this.before();
        MethodDeclarationNode node = factory.makeMethodDeclarationNode(body, modifiers, identifier, parameters, returnType, javadoc);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a MethodDeclarationNode.
     * The specified start and stop locations are used.
     */
    @Override
    public MethodDeclarationNode makeMethodDeclarationNode(
            BlockStatementListNode body,
            MethodModifiersNode modifiers,
            IdentifierNode identifier,
            VariableListNode parameters,
            TypeNode returnType,
            JavadocNode javadoc,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        MethodDeclarationNode node = factory.makeMethodDeclarationNode(body, modifiers, identifier, parameters, returnType, javadoc, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a MethodInvocationNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public MethodInvocationNode makeMethodInvocationNodeWithUnions(
            NodeUnion<? extends PrimaryExpressionNode> expression,
            NodeUnion<? extends IdentifierNode> identifier,
            NodeUnion<? extends ExpressionListNode> arguments,
            NodeUnion<? extends ReferenceTypeListNode> typeArguments)
    {
        this.before();
        MethodInvocationNode node = factory.makeMethodInvocationNodeWithUnions(expression, identifier, arguments, typeArguments);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a MethodInvocationNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public MethodInvocationNode makeMethodInvocationNode(
            PrimaryExpressionNode expression,
            IdentifierNode identifier,
            ExpressionListNode arguments,
            ReferenceTypeListNode typeArguments)
    {
        this.before();
        MethodInvocationNode node = factory.makeMethodInvocationNode(expression, identifier, arguments, typeArguments);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a MethodInvocationNode.
     * The specified start and stop locations are used.
     */
    @Override
    public MethodInvocationNode makeMethodInvocationNodeWithUnions(
            NodeUnion<? extends PrimaryExpressionNode> expression,
            NodeUnion<? extends IdentifierNode> identifier,
            NodeUnion<? extends ExpressionListNode> arguments,
            NodeUnion<? extends ReferenceTypeListNode> typeArguments,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        MethodInvocationNode node = factory.makeMethodInvocationNodeWithUnions(expression, identifier, arguments, typeArguments, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a MethodInvocationNode.
     * The specified start and stop locations are used.
     */
    @Override
    public MethodInvocationNode makeMethodInvocationNode(
            PrimaryExpressionNode expression,
            IdentifierNode identifier,
            ExpressionListNode arguments,
            ReferenceTypeListNode typeArguments,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        MethodInvocationNode node = factory.makeMethodInvocationNode(expression, identifier, arguments, typeArguments, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a MethodInvocationNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public MethodInvocationNode makeMethodInvocationNode(
            IdentifierNode identifier)
    {
        this.before();
        MethodInvocationNode node = factory.makeMethodInvocationNode(identifier);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a MethodInvocationNode.
     * The specified start and stop locations are used.
     */
    @Override
    public MethodInvocationNode makeMethodInvocationNode(
            IdentifierNode identifier,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        MethodInvocationNode node = factory.makeMethodInvocationNode(identifier, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a MethodInvocationNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public MethodInvocationNode makeMethodInvocationNode(
            PrimaryExpressionNode expression,
            IdentifierNode identifier)
    {
        this.before();
        MethodInvocationNode node = factory.makeMethodInvocationNode(expression, identifier);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a MethodInvocationNode.
     * The specified start and stop locations are used.
     */
    @Override
    public MethodInvocationNode makeMethodInvocationNode(
            PrimaryExpressionNode expression,
            IdentifierNode identifier,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        MethodInvocationNode node = factory.makeMethodInvocationNode(expression, identifier, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a MethodInvocationNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public MethodInvocationNode makeMethodInvocationNode(
            IdentifierNode identifier,
            ExpressionListNode arguments)
    {
        this.before();
        MethodInvocationNode node = factory.makeMethodInvocationNode(identifier, arguments);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a MethodInvocationNode.
     * The specified start and stop locations are used.
     */
    @Override
    public MethodInvocationNode makeMethodInvocationNode(
            IdentifierNode identifier,
            ExpressionListNode arguments,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        MethodInvocationNode node = factory.makeMethodInvocationNode(identifier, arguments, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a MethodInvocationNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public MethodInvocationNode makeMethodInvocationNode(
            PrimaryExpressionNode expression,
            IdentifierNode identifier,
            ExpressionListNode arguments)
    {
        this.before();
        MethodInvocationNode node = factory.makeMethodInvocationNode(expression, identifier, arguments);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a MethodInvocationNode.
     * The specified start and stop locations are used.
     */
    @Override
    public MethodInvocationNode makeMethodInvocationNode(
            PrimaryExpressionNode expression,
            IdentifierNode identifier,
            ExpressionListNode arguments,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        MethodInvocationNode node = factory.makeMethodInvocationNode(expression, identifier, arguments, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a MethodModifiersNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public MethodModifiersNode makeMethodModifiersNodeWithUnions(
            AccessModifier access,
            boolean abstractFlag,
            boolean staticFlag,
            boolean finalFlag,
            boolean synchronizedFlag,
            boolean nativeFlag,
            boolean strictfpFlag,
            NodeUnion<? extends MetaAnnotationListNode> metaAnnotations,
            NodeUnion<? extends AnnotationListNode> annotations)
    {
        this.before();
        MethodModifiersNode node = factory.makeMethodModifiersNodeWithUnions(access, abstractFlag, staticFlag, finalFlag, synchronizedFlag, nativeFlag, strictfpFlag, metaAnnotations, annotations);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a MethodModifiersNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public MethodModifiersNode makeMethodModifiersNode(
            AccessModifier access,
            boolean abstractFlag,
            boolean staticFlag,
            boolean finalFlag,
            boolean synchronizedFlag,
            boolean nativeFlag,
            boolean strictfpFlag,
            MetaAnnotationListNode metaAnnotations,
            AnnotationListNode annotations)
    {
        this.before();
        MethodModifiersNode node = factory.makeMethodModifiersNode(access, abstractFlag, staticFlag, finalFlag, synchronizedFlag, nativeFlag, strictfpFlag, metaAnnotations, annotations);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a MethodModifiersNode.
     * The specified start and stop locations are used.
     */
    @Override
    public MethodModifiersNode makeMethodModifiersNodeWithUnions(
            AccessModifier access,
            boolean abstractFlag,
            boolean staticFlag,
            boolean finalFlag,
            boolean synchronizedFlag,
            boolean nativeFlag,
            boolean strictfpFlag,
            NodeUnion<? extends MetaAnnotationListNode> metaAnnotations,
            NodeUnion<? extends AnnotationListNode> annotations,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        MethodModifiersNode node = factory.makeMethodModifiersNodeWithUnions(access, abstractFlag, staticFlag, finalFlag, synchronizedFlag, nativeFlag, strictfpFlag, metaAnnotations, annotations, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a MethodModifiersNode.
     * The specified start and stop locations are used.
     */
    @Override
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
            BsjSourceLocation stopLocation)
    {
        this.before();
        MethodModifiersNode node = factory.makeMethodModifiersNode(access, abstractFlag, staticFlag, finalFlag, synchronizedFlag, nativeFlag, strictfpFlag, metaAnnotations, annotations, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a MethodModifiersNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public MethodModifiersNode makeMethodModifiersNode(
            AccessModifier access)
    {
        this.before();
        MethodModifiersNode node = factory.makeMethodModifiersNode(access);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a MethodModifiersNode.
     * The specified start and stop locations are used.
     */
    @Override
    public MethodModifiersNode makeMethodModifiersNode(
            AccessModifier access,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        MethodModifiersNode node = factory.makeMethodModifiersNode(access, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a NoOperationNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public NoOperationNode makeNoOperationNodeWithUnions(
            NodeUnion<? extends MetaAnnotationListNode> metaAnnotations)
    {
        this.before();
        NoOperationNode node = factory.makeNoOperationNodeWithUnions(metaAnnotations);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a NoOperationNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public NoOperationNode makeNoOperationNode(
            MetaAnnotationListNode metaAnnotations)
    {
        this.before();
        NoOperationNode node = factory.makeNoOperationNode(metaAnnotations);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a NoOperationNode.
     * The specified start and stop locations are used.
     */
    @Override
    public NoOperationNode makeNoOperationNodeWithUnions(
            NodeUnion<? extends MetaAnnotationListNode> metaAnnotations,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        NoOperationNode node = factory.makeNoOperationNodeWithUnions(metaAnnotations, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a NoOperationNode.
     * The specified start and stop locations are used.
     */
    @Override
    public NoOperationNode makeNoOperationNode(
            MetaAnnotationListNode metaAnnotations,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        NoOperationNode node = factory.makeNoOperationNode(metaAnnotations, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a NoOperationNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public NoOperationNode makeNoOperationNode(
    )
    {
        this.before();
        NoOperationNode node = factory.makeNoOperationNode();
        this.after(node);
        return node;
    }
    
    /**
     * Creates a NoOperationNode.
     * The specified start and stop locations are used.
     */
    @Override
    public NoOperationNode makeNoOperationNode(
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        NoOperationNode node = factory.makeNoOperationNode(startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a NormalAnnotationNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public NormalAnnotationNode makeNormalAnnotationNodeWithUnions(
            NodeUnion<? extends AnnotationElementListNode> arguments,
            NodeUnion<? extends UnparameterizedTypeNode> annotationType)
    {
        this.before();
        NormalAnnotationNode node = factory.makeNormalAnnotationNodeWithUnions(arguments, annotationType);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a NormalAnnotationNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public NormalAnnotationNode makeNormalAnnotationNode(
            AnnotationElementListNode arguments,
            UnparameterizedTypeNode annotationType)
    {
        this.before();
        NormalAnnotationNode node = factory.makeNormalAnnotationNode(arguments, annotationType);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a NormalAnnotationNode.
     * The specified start and stop locations are used.
     */
    @Override
    public NormalAnnotationNode makeNormalAnnotationNodeWithUnions(
            NodeUnion<? extends AnnotationElementListNode> arguments,
            NodeUnion<? extends UnparameterizedTypeNode> annotationType,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        NormalAnnotationNode node = factory.makeNormalAnnotationNodeWithUnions(arguments, annotationType, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a NormalAnnotationNode.
     * The specified start and stop locations are used.
     */
    @Override
    public NormalAnnotationNode makeNormalAnnotationNode(
            AnnotationElementListNode arguments,
            UnparameterizedTypeNode annotationType,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        NormalAnnotationNode node = factory.makeNormalAnnotationNode(arguments, annotationType, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a NormalMetaAnnotationNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public NormalMetaAnnotationNode makeNormalMetaAnnotationNodeWithUnions(
            NodeUnion<? extends MetaAnnotationElementListNode> arguments,
            NodeUnion<? extends UnparameterizedTypeNode> annotationType,
            MetaAnnotationMetaprogramAnchorNode metaprogramAnchor)
    {
        this.before();
        NormalMetaAnnotationNode node = factory.makeNormalMetaAnnotationNodeWithUnions(arguments, annotationType, metaprogramAnchor);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a NormalMetaAnnotationNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public NormalMetaAnnotationNode makeNormalMetaAnnotationNode(
            MetaAnnotationElementListNode arguments,
            UnparameterizedTypeNode annotationType,
            MetaAnnotationMetaprogramAnchorNode metaprogramAnchor)
    {
        this.before();
        NormalMetaAnnotationNode node = factory.makeNormalMetaAnnotationNode(arguments, annotationType, metaprogramAnchor);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a NormalMetaAnnotationNode.
     * The specified start and stop locations are used.
     */
    @Override
    public NormalMetaAnnotationNode makeNormalMetaAnnotationNodeWithUnions(
            NodeUnion<? extends MetaAnnotationElementListNode> arguments,
            NodeUnion<? extends UnparameterizedTypeNode> annotationType,
            MetaAnnotationMetaprogramAnchorNode metaprogramAnchor,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        NormalMetaAnnotationNode node = factory.makeNormalMetaAnnotationNodeWithUnions(arguments, annotationType, metaprogramAnchor, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a NormalMetaAnnotationNode.
     * The specified start and stop locations are used.
     */
    @Override
    public NormalMetaAnnotationNode makeNormalMetaAnnotationNode(
            MetaAnnotationElementListNode arguments,
            UnparameterizedTypeNode annotationType,
            MetaAnnotationMetaprogramAnchorNode metaprogramAnchor,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        NormalMetaAnnotationNode node = factory.makeNormalMetaAnnotationNode(arguments, annotationType, metaprogramAnchor, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a NormalMetaAnnotationNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public NormalMetaAnnotationNode makeNormalMetaAnnotationNode(
            MetaAnnotationElementListNode arguments,
            UnparameterizedTypeNode annotationType)
    {
        this.before();
        NormalMetaAnnotationNode node = factory.makeNormalMetaAnnotationNode(arguments, annotationType);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a NormalMetaAnnotationNode.
     * The specified start and stop locations are used.
     */
    @Override
    public NormalMetaAnnotationNode makeNormalMetaAnnotationNode(
            MetaAnnotationElementListNode arguments,
            UnparameterizedTypeNode annotationType,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        NormalMetaAnnotationNode node = factory.makeNormalMetaAnnotationNode(arguments, annotationType, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a NullLiteralNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public NullLiteralNode makeNullLiteralNode(
    )
    {
        this.before();
        NullLiteralNode node = factory.makeNullLiteralNode();
        this.after(node);
        return node;
    }
    
    /**
     * Creates a NullLiteralNode.
     * The specified start and stop locations are used.
     */
    @Override
    public NullLiteralNode makeNullLiteralNode(
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        NullLiteralNode node = factory.makeNullLiteralNode(startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a PackageDeclarationNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public PackageDeclarationNode makePackageDeclarationNodeWithUnions(
            NodeUnion<? extends NameNode> name,
            NodeUnion<? extends MetaAnnotationListNode> metaAnnotations,
            NodeUnion<? extends AnnotationListNode> annotations)
    {
        this.before();
        PackageDeclarationNode node = factory.makePackageDeclarationNodeWithUnions(name, metaAnnotations, annotations);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a PackageDeclarationNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public PackageDeclarationNode makePackageDeclarationNode(
            NameNode name,
            MetaAnnotationListNode metaAnnotations,
            AnnotationListNode annotations)
    {
        this.before();
        PackageDeclarationNode node = factory.makePackageDeclarationNode(name, metaAnnotations, annotations);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a PackageDeclarationNode.
     * The specified start and stop locations are used.
     */
    @Override
    public PackageDeclarationNode makePackageDeclarationNodeWithUnions(
            NodeUnion<? extends NameNode> name,
            NodeUnion<? extends MetaAnnotationListNode> metaAnnotations,
            NodeUnion<? extends AnnotationListNode> annotations,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        PackageDeclarationNode node = factory.makePackageDeclarationNodeWithUnions(name, metaAnnotations, annotations, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a PackageDeclarationNode.
     * The specified start and stop locations are used.
     */
    @Override
    public PackageDeclarationNode makePackageDeclarationNode(
            NameNode name,
            MetaAnnotationListNode metaAnnotations,
            AnnotationListNode annotations,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        PackageDeclarationNode node = factory.makePackageDeclarationNode(name, metaAnnotations, annotations, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a PackageDeclarationNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public PackageDeclarationNode makePackageDeclarationNode(
            NameNode name)
    {
        this.before();
        PackageDeclarationNode node = factory.makePackageDeclarationNode(name);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a PackageDeclarationNode.
     * The specified start and stop locations are used.
     */
    @Override
    public PackageDeclarationNode makePackageDeclarationNode(
            NameNode name,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        PackageDeclarationNode node = factory.makePackageDeclarationNode(name, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a PackageNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public PackageNode makePackageNodeWithUnions(
            NodeUnion<? extends IdentifierNode> name)
    {
        this.before();
        PackageNode node = factory.makePackageNodeWithUnions(name);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a PackageNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public PackageNode makePackageNode(
            IdentifierNode name)
    {
        this.before();
        PackageNode node = factory.makePackageNode(name);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a PackageNode.
     * The specified start and stop locations are used.
     */
    @Override
    public PackageNode makePackageNodeWithUnions(
            NodeUnion<? extends IdentifierNode> name,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        PackageNode node = factory.makePackageNodeWithUnions(name, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a PackageNode.
     * The specified start and stop locations are used.
     */
    @Override
    public PackageNode makePackageNode(
            IdentifierNode name,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        PackageNode node = factory.makePackageNode(name, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a ParameterizedTypeNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public ParameterizedTypeNode makeParameterizedTypeNodeWithUnions(
            NodeUnion<? extends UnparameterizedTypeNode> baseType,
            NodeUnion<? extends TypeArgumentListNode> typeArguments)
    {
        this.before();
        ParameterizedTypeNode node = factory.makeParameterizedTypeNodeWithUnions(baseType, typeArguments);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a ParameterizedTypeNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public ParameterizedTypeNode makeParameterizedTypeNode(
            UnparameterizedTypeNode baseType,
            TypeArgumentListNode typeArguments)
    {
        this.before();
        ParameterizedTypeNode node = factory.makeParameterizedTypeNode(baseType, typeArguments);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a ParameterizedTypeNode.
     * The specified start and stop locations are used.
     */
    @Override
    public ParameterizedTypeNode makeParameterizedTypeNodeWithUnions(
            NodeUnion<? extends UnparameterizedTypeNode> baseType,
            NodeUnion<? extends TypeArgumentListNode> typeArguments,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        ParameterizedTypeNode node = factory.makeParameterizedTypeNodeWithUnions(baseType, typeArguments, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a ParameterizedTypeNode.
     * The specified start and stop locations are used.
     */
    @Override
    public ParameterizedTypeNode makeParameterizedTypeNode(
            UnparameterizedTypeNode baseType,
            TypeArgumentListNode typeArguments,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        ParameterizedTypeNode node = factory.makeParameterizedTypeNode(baseType, typeArguments, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a ParameterizedTypeSelectNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public ParameterizedTypeSelectNode makeParameterizedTypeSelectNodeWithUnions(
            NodeUnion<? extends ParameterizedTypeNode> base,
            NodeUnion<? extends DeclaredTypeNode> select)
    {
        this.before();
        ParameterizedTypeSelectNode node = factory.makeParameterizedTypeSelectNodeWithUnions(base, select);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a ParameterizedTypeSelectNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public ParameterizedTypeSelectNode makeParameterizedTypeSelectNode(
            ParameterizedTypeNode base,
            DeclaredTypeNode select)
    {
        this.before();
        ParameterizedTypeSelectNode node = factory.makeParameterizedTypeSelectNode(base, select);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a ParameterizedTypeSelectNode.
     * The specified start and stop locations are used.
     */
    @Override
    public ParameterizedTypeSelectNode makeParameterizedTypeSelectNodeWithUnions(
            NodeUnion<? extends ParameterizedTypeNode> base,
            NodeUnion<? extends DeclaredTypeNode> select,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        ParameterizedTypeSelectNode node = factory.makeParameterizedTypeSelectNodeWithUnions(base, select, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a ParameterizedTypeSelectNode.
     * The specified start and stop locations are used.
     */
    @Override
    public ParameterizedTypeSelectNode makeParameterizedTypeSelectNode(
            ParameterizedTypeNode base,
            DeclaredTypeNode select,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        ParameterizedTypeSelectNode node = factory.makeParameterizedTypeSelectNode(base, select, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a ParenthesizedExpressionNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public ParenthesizedExpressionNode makeParenthesizedExpressionNodeWithUnions(
            NodeUnion<? extends ExpressionNode> expression)
    {
        this.before();
        ParenthesizedExpressionNode node = factory.makeParenthesizedExpressionNodeWithUnions(expression);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a ParenthesizedExpressionNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public ParenthesizedExpressionNode makeParenthesizedExpressionNode(
            ExpressionNode expression)
    {
        this.before();
        ParenthesizedExpressionNode node = factory.makeParenthesizedExpressionNode(expression);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a ParenthesizedExpressionNode.
     * The specified start and stop locations are used.
     */
    @Override
    public ParenthesizedExpressionNode makeParenthesizedExpressionNodeWithUnions(
            NodeUnion<? extends ExpressionNode> expression,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        ParenthesizedExpressionNode node = factory.makeParenthesizedExpressionNodeWithUnions(expression, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a ParenthesizedExpressionNode.
     * The specified start and stop locations are used.
     */
    @Override
    public ParenthesizedExpressionNode makeParenthesizedExpressionNode(
            ExpressionNode expression,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        ParenthesizedExpressionNode node = factory.makeParenthesizedExpressionNode(expression, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a PrimitiveTypeNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public PrimitiveTypeNode makePrimitiveTypeNode(
            PrimitiveType primitiveType)
    {
        this.before();
        PrimitiveTypeNode node = factory.makePrimitiveTypeNode(primitiveType);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a PrimitiveTypeNode.
     * The specified start and stop locations are used.
     */
    @Override
    public PrimitiveTypeNode makePrimitiveTypeNode(
            PrimitiveType primitiveType,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        PrimitiveTypeNode node = factory.makePrimitiveTypeNode(primitiveType, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a QualifiedClassInstantiationNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public QualifiedClassInstantiationNode makeQualifiedClassInstantiationNodeWithUnions(
            NodeUnion<? extends ExpressionNode> enclosingExpression,
            NodeUnion<? extends IdentifierNode> identifier,
            NodeUnion<? extends TypeArgumentListNode> typeArguments,
            NodeUnion<? extends TypeArgumentListNode> constructorTypeArguments,
            NodeUnion<? extends ExpressionListNode> arguments,
            NodeUnion<? extends AnonymousClassBodyNode> body)
    {
        this.before();
        QualifiedClassInstantiationNode node = factory.makeQualifiedClassInstantiationNodeWithUnions(enclosingExpression, identifier, typeArguments, constructorTypeArguments, arguments, body);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a QualifiedClassInstantiationNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public QualifiedClassInstantiationNode makeQualifiedClassInstantiationNode(
            ExpressionNode enclosingExpression,
            IdentifierNode identifier,
            TypeArgumentListNode typeArguments,
            TypeArgumentListNode constructorTypeArguments,
            ExpressionListNode arguments,
            AnonymousClassBodyNode body)
    {
        this.before();
        QualifiedClassInstantiationNode node = factory.makeQualifiedClassInstantiationNode(enclosingExpression, identifier, typeArguments, constructorTypeArguments, arguments, body);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a QualifiedClassInstantiationNode.
     * The specified start and stop locations are used.
     */
    @Override
    public QualifiedClassInstantiationNode makeQualifiedClassInstantiationNodeWithUnions(
            NodeUnion<? extends ExpressionNode> enclosingExpression,
            NodeUnion<? extends IdentifierNode> identifier,
            NodeUnion<? extends TypeArgumentListNode> typeArguments,
            NodeUnion<? extends TypeArgumentListNode> constructorTypeArguments,
            NodeUnion<? extends ExpressionListNode> arguments,
            NodeUnion<? extends AnonymousClassBodyNode> body,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        QualifiedClassInstantiationNode node = factory.makeQualifiedClassInstantiationNodeWithUnions(enclosingExpression, identifier, typeArguments, constructorTypeArguments, arguments, body, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a QualifiedClassInstantiationNode.
     * The specified start and stop locations are used.
     */
    @Override
    public QualifiedClassInstantiationNode makeQualifiedClassInstantiationNode(
            ExpressionNode enclosingExpression,
            IdentifierNode identifier,
            TypeArgumentListNode typeArguments,
            TypeArgumentListNode constructorTypeArguments,
            ExpressionListNode arguments,
            AnonymousClassBodyNode body,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        QualifiedClassInstantiationNode node = factory.makeQualifiedClassInstantiationNode(enclosingExpression, identifier, typeArguments, constructorTypeArguments, arguments, body, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a QualifiedClassInstantiationNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public QualifiedClassInstantiationNode makeQualifiedClassInstantiationNode(
            ExpressionNode enclosingExpression,
            IdentifierNode identifier,
            TypeArgumentListNode typeArguments)
    {
        this.before();
        QualifiedClassInstantiationNode node = factory.makeQualifiedClassInstantiationNode(enclosingExpression, identifier, typeArguments);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a QualifiedClassInstantiationNode.
     * The specified start and stop locations are used.
     */
    @Override
    public QualifiedClassInstantiationNode makeQualifiedClassInstantiationNode(
            ExpressionNode enclosingExpression,
            IdentifierNode identifier,
            TypeArgumentListNode typeArguments,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        QualifiedClassInstantiationNode node = factory.makeQualifiedClassInstantiationNode(enclosingExpression, identifier, typeArguments, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a QualifiedNameNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public QualifiedNameNode makeQualifiedNameNodeWithUnions(
            NodeUnion<? extends NameNode> base,
            NodeUnion<? extends IdentifierNode> identifier)
    {
        this.before();
        QualifiedNameNode node = factory.makeQualifiedNameNodeWithUnions(base, identifier);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a QualifiedNameNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public QualifiedNameNode makeQualifiedNameNode(
            NameNode base,
            IdentifierNode identifier)
    {
        this.before();
        QualifiedNameNode node = factory.makeQualifiedNameNode(base, identifier);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a QualifiedNameNode.
     * The specified start and stop locations are used.
     */
    @Override
    public QualifiedNameNode makeQualifiedNameNodeWithUnions(
            NodeUnion<? extends NameNode> base,
            NodeUnion<? extends IdentifierNode> identifier,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        QualifiedNameNode node = factory.makeQualifiedNameNodeWithUnions(base, identifier, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a QualifiedNameNode.
     * The specified start and stop locations are used.
     */
    @Override
    public QualifiedNameNode makeQualifiedNameNode(
            NameNode base,
            IdentifierNode identifier,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        QualifiedNameNode node = factory.makeQualifiedNameNode(base, identifier, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a RawCodeLiteralNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public RawCodeLiteralNode makeRawCodeLiteralNode(
            BsjRawCodeLiteralPayload value)
    {
        this.before();
        RawCodeLiteralNode node = factory.makeRawCodeLiteralNode(value);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a RawCodeLiteralNode.
     * The specified start and stop locations are used.
     */
    @Override
    public RawCodeLiteralNode makeRawCodeLiteralNode(
            BsjRawCodeLiteralPayload value,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        RawCodeLiteralNode node = factory.makeRawCodeLiteralNode(value, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a ReferenceTypeListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public ReferenceTypeListNode makeReferenceTypeListNodeWithUnions(
            List<NodeUnion<? extends ReferenceTypeNode>> children)
    {
        this.before();
        ReferenceTypeListNode node = factory.makeReferenceTypeListNodeWithUnions(children);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a ReferenceTypeListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public ReferenceTypeListNode makeReferenceTypeListNode(
            List<ReferenceTypeNode> children)
    {
        this.before();
        ReferenceTypeListNode node = factory.makeReferenceTypeListNode(children);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a ReferenceTypeListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public ReferenceTypeListNode makeReferenceTypeListNode(
            ReferenceTypeNode... childrenElements)
    {
        this.before();
        ReferenceTypeListNode node = factory.makeReferenceTypeListNode(childrenElements);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a ReferenceTypeListNode.
     * The specified start and stop locations are used.
     */
    @Override
    public ReferenceTypeListNode makeReferenceTypeListNodeWithUnions(
            List<NodeUnion<? extends ReferenceTypeNode>> children,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        ReferenceTypeListNode node = factory.makeReferenceTypeListNodeWithUnions(children, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a ReferenceTypeListNode.
     * The specified start and stop locations are used.
     */
    @Override
    public ReferenceTypeListNode makeReferenceTypeListNode(
            List<ReferenceTypeNode> children,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        ReferenceTypeListNode node = factory.makeReferenceTypeListNode(children, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a ReferenceTypeListNode.
     * The specified start and stop locations are used.
     */
    @Override
    public ReferenceTypeListNode makeReferenceTypeListNode(
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation,
            ReferenceTypeNode... childrenElements)
    {
        this.before();
        ReferenceTypeListNode node = factory.makeReferenceTypeListNode(startLocation, stopLocation, childrenElements);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a ReturnNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public ReturnNode makeReturnNodeWithUnions(
            NodeUnion<? extends ExpressionNode> expression,
            NodeUnion<? extends MetaAnnotationListNode> metaAnnotations)
    {
        this.before();
        ReturnNode node = factory.makeReturnNodeWithUnions(expression, metaAnnotations);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a ReturnNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public ReturnNode makeReturnNode(
            ExpressionNode expression,
            MetaAnnotationListNode metaAnnotations)
    {
        this.before();
        ReturnNode node = factory.makeReturnNode(expression, metaAnnotations);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a ReturnNode.
     * The specified start and stop locations are used.
     */
    @Override
    public ReturnNode makeReturnNodeWithUnions(
            NodeUnion<? extends ExpressionNode> expression,
            NodeUnion<? extends MetaAnnotationListNode> metaAnnotations,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        ReturnNode node = factory.makeReturnNodeWithUnions(expression, metaAnnotations, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a ReturnNode.
     * The specified start and stop locations are used.
     */
    @Override
    public ReturnNode makeReturnNode(
            ExpressionNode expression,
            MetaAnnotationListNode metaAnnotations,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        ReturnNode node = factory.makeReturnNode(expression, metaAnnotations, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a ReturnNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public ReturnNode makeReturnNode(
            ExpressionNode expression)
    {
        this.before();
        ReturnNode node = factory.makeReturnNode(expression);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a ReturnNode.
     * The specified start and stop locations are used.
     */
    @Override
    public ReturnNode makeReturnNode(
            ExpressionNode expression,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        ReturnNode node = factory.makeReturnNode(expression, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a SimpleNameNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public SimpleNameNode makeSimpleNameNodeWithUnions(
            NodeUnion<? extends IdentifierNode> identifier)
    {
        this.before();
        SimpleNameNode node = factory.makeSimpleNameNodeWithUnions(identifier);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a SimpleNameNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public SimpleNameNode makeSimpleNameNode(
            IdentifierNode identifier)
    {
        this.before();
        SimpleNameNode node = factory.makeSimpleNameNode(identifier);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a SimpleNameNode.
     * The specified start and stop locations are used.
     */
    @Override
    public SimpleNameNode makeSimpleNameNodeWithUnions(
            NodeUnion<? extends IdentifierNode> identifier,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        SimpleNameNode node = factory.makeSimpleNameNodeWithUnions(identifier, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a SimpleNameNode.
     * The specified start and stop locations are used.
     */
    @Override
    public SimpleNameNode makeSimpleNameNode(
            IdentifierNode identifier,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        SimpleNameNode node = factory.makeSimpleNameNode(identifier, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a SingleElementAnnotationNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public SingleElementAnnotationNode makeSingleElementAnnotationNodeWithUnions(
            NodeUnion<? extends AnnotationValueNode> value,
            NodeUnion<? extends UnparameterizedTypeNode> annotationType)
    {
        this.before();
        SingleElementAnnotationNode node = factory.makeSingleElementAnnotationNodeWithUnions(value, annotationType);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a SingleElementAnnotationNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public SingleElementAnnotationNode makeSingleElementAnnotationNode(
            AnnotationValueNode value,
            UnparameterizedTypeNode annotationType)
    {
        this.before();
        SingleElementAnnotationNode node = factory.makeSingleElementAnnotationNode(value, annotationType);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a SingleElementAnnotationNode.
     * The specified start and stop locations are used.
     */
    @Override
    public SingleElementAnnotationNode makeSingleElementAnnotationNodeWithUnions(
            NodeUnion<? extends AnnotationValueNode> value,
            NodeUnion<? extends UnparameterizedTypeNode> annotationType,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        SingleElementAnnotationNode node = factory.makeSingleElementAnnotationNodeWithUnions(value, annotationType, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a SingleElementAnnotationNode.
     * The specified start and stop locations are used.
     */
    @Override
    public SingleElementAnnotationNode makeSingleElementAnnotationNode(
            AnnotationValueNode value,
            UnparameterizedTypeNode annotationType,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        SingleElementAnnotationNode node = factory.makeSingleElementAnnotationNode(value, annotationType, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a SingleElementMetaAnnotationNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public SingleElementMetaAnnotationNode makeSingleElementMetaAnnotationNodeWithUnions(
            NodeUnion<? extends MetaAnnotationValueNode> value,
            NodeUnion<? extends UnparameterizedTypeNode> annotationType,
            MetaAnnotationMetaprogramAnchorNode metaprogramAnchor)
    {
        this.before();
        SingleElementMetaAnnotationNode node = factory.makeSingleElementMetaAnnotationNodeWithUnions(value, annotationType, metaprogramAnchor);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a SingleElementMetaAnnotationNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public SingleElementMetaAnnotationNode makeSingleElementMetaAnnotationNode(
            MetaAnnotationValueNode value,
            UnparameterizedTypeNode annotationType,
            MetaAnnotationMetaprogramAnchorNode metaprogramAnchor)
    {
        this.before();
        SingleElementMetaAnnotationNode node = factory.makeSingleElementMetaAnnotationNode(value, annotationType, metaprogramAnchor);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a SingleElementMetaAnnotationNode.
     * The specified start and stop locations are used.
     */
    @Override
    public SingleElementMetaAnnotationNode makeSingleElementMetaAnnotationNodeWithUnions(
            NodeUnion<? extends MetaAnnotationValueNode> value,
            NodeUnion<? extends UnparameterizedTypeNode> annotationType,
            MetaAnnotationMetaprogramAnchorNode metaprogramAnchor,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        SingleElementMetaAnnotationNode node = factory.makeSingleElementMetaAnnotationNodeWithUnions(value, annotationType, metaprogramAnchor, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a SingleElementMetaAnnotationNode.
     * The specified start and stop locations are used.
     */
    @Override
    public SingleElementMetaAnnotationNode makeSingleElementMetaAnnotationNode(
            MetaAnnotationValueNode value,
            UnparameterizedTypeNode annotationType,
            MetaAnnotationMetaprogramAnchorNode metaprogramAnchor,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        SingleElementMetaAnnotationNode node = factory.makeSingleElementMetaAnnotationNode(value, annotationType, metaprogramAnchor, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a SingleElementMetaAnnotationNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public SingleElementMetaAnnotationNode makeSingleElementMetaAnnotationNode(
            MetaAnnotationValueNode value,
            UnparameterizedTypeNode annotationType)
    {
        this.before();
        SingleElementMetaAnnotationNode node = factory.makeSingleElementMetaAnnotationNode(value, annotationType);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a SingleElementMetaAnnotationNode.
     * The specified start and stop locations are used.
     */
    @Override
    public SingleElementMetaAnnotationNode makeSingleElementMetaAnnotationNode(
            MetaAnnotationValueNode value,
            UnparameterizedTypeNode annotationType,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        SingleElementMetaAnnotationNode node = factory.makeSingleElementMetaAnnotationNode(value, annotationType, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a SingleStaticImportNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public SingleStaticImportNode makeSingleStaticImportNodeWithUnions(
            NodeUnion<? extends NameNode> name,
            NodeUnion<? extends IdentifierNode> identifier)
    {
        this.before();
        SingleStaticImportNode node = factory.makeSingleStaticImportNodeWithUnions(name, identifier);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a SingleStaticImportNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public SingleStaticImportNode makeSingleStaticImportNode(
            NameNode name,
            IdentifierNode identifier)
    {
        this.before();
        SingleStaticImportNode node = factory.makeSingleStaticImportNode(name, identifier);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a SingleStaticImportNode.
     * The specified start and stop locations are used.
     */
    @Override
    public SingleStaticImportNode makeSingleStaticImportNodeWithUnions(
            NodeUnion<? extends NameNode> name,
            NodeUnion<? extends IdentifierNode> identifier,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        SingleStaticImportNode node = factory.makeSingleStaticImportNodeWithUnions(name, identifier, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a SingleStaticImportNode.
     * The specified start and stop locations are used.
     */
    @Override
    public SingleStaticImportNode makeSingleStaticImportNode(
            NameNode name,
            IdentifierNode identifier,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        SingleStaticImportNode node = factory.makeSingleStaticImportNode(name, identifier, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a SpliceNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public SpliceNode makeSpliceNode(
            ExpressionNode spliceExpression)
    {
        this.before();
        SpliceNode node = factory.makeSpliceNode(spliceExpression);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a SpliceNode.
     * The specified start and stop locations are used.
     */
    @Override
    public SpliceNode makeSpliceNode(
            ExpressionNode spliceExpression,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        SpliceNode node = factory.makeSpliceNode(spliceExpression, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a StatementExpressionListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public StatementExpressionListNode makeStatementExpressionListNodeWithUnions(
            List<NodeUnion<? extends StatementExpressionNode>> children)
    {
        this.before();
        StatementExpressionListNode node = factory.makeStatementExpressionListNodeWithUnions(children);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a StatementExpressionListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public StatementExpressionListNode makeStatementExpressionListNode(
            List<StatementExpressionNode> children)
    {
        this.before();
        StatementExpressionListNode node = factory.makeStatementExpressionListNode(children);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a StatementExpressionListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public StatementExpressionListNode makeStatementExpressionListNode(
            StatementExpressionNode... childrenElements)
    {
        this.before();
        StatementExpressionListNode node = factory.makeStatementExpressionListNode(childrenElements);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a StatementExpressionListNode.
     * The specified start and stop locations are used.
     */
    @Override
    public StatementExpressionListNode makeStatementExpressionListNodeWithUnions(
            List<NodeUnion<? extends StatementExpressionNode>> children,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        StatementExpressionListNode node = factory.makeStatementExpressionListNodeWithUnions(children, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a StatementExpressionListNode.
     * The specified start and stop locations are used.
     */
    @Override
    public StatementExpressionListNode makeStatementExpressionListNode(
            List<StatementExpressionNode> children,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        StatementExpressionListNode node = factory.makeStatementExpressionListNode(children, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a StatementExpressionListNode.
     * The specified start and stop locations are used.
     */
    @Override
    public StatementExpressionListNode makeStatementExpressionListNode(
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation,
            StatementExpressionNode... childrenElements)
    {
        this.before();
        StatementExpressionListNode node = factory.makeStatementExpressionListNode(startLocation, stopLocation, childrenElements);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a StaticImportOnDemandNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public StaticImportOnDemandNode makeStaticImportOnDemandNodeWithUnions(
            NodeUnion<? extends NameNode> name)
    {
        this.before();
        StaticImportOnDemandNode node = factory.makeStaticImportOnDemandNodeWithUnions(name);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a StaticImportOnDemandNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public StaticImportOnDemandNode makeStaticImportOnDemandNode(
            NameNode name)
    {
        this.before();
        StaticImportOnDemandNode node = factory.makeStaticImportOnDemandNode(name);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a StaticImportOnDemandNode.
     * The specified start and stop locations are used.
     */
    @Override
    public StaticImportOnDemandNode makeStaticImportOnDemandNodeWithUnions(
            NodeUnion<? extends NameNode> name,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        StaticImportOnDemandNode node = factory.makeStaticImportOnDemandNodeWithUnions(name, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a StaticImportOnDemandNode.
     * The specified start and stop locations are used.
     */
    @Override
    public StaticImportOnDemandNode makeStaticImportOnDemandNode(
            NameNode name,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        StaticImportOnDemandNode node = factory.makeStaticImportOnDemandNode(name, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a StringLiteralNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public StringLiteralNode makeStringLiteralNode(
            String value)
    {
        this.before();
        StringLiteralNode node = factory.makeStringLiteralNode(value);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a StringLiteralNode.
     * The specified start and stop locations are used.
     */
    @Override
    public StringLiteralNode makeStringLiteralNode(
            String value,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        StringLiteralNode node = factory.makeStringLiteralNode(value, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a SuperFieldAccessNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public SuperFieldAccessNode makeSuperFieldAccessNodeWithUnions(
            NodeUnion<? extends UnparameterizedTypeNode> type,
            NodeUnion<? extends IdentifierNode> identifier)
    {
        this.before();
        SuperFieldAccessNode node = factory.makeSuperFieldAccessNodeWithUnions(type, identifier);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a SuperFieldAccessNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public SuperFieldAccessNode makeSuperFieldAccessNode(
            UnparameterizedTypeNode type,
            IdentifierNode identifier)
    {
        this.before();
        SuperFieldAccessNode node = factory.makeSuperFieldAccessNode(type, identifier);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a SuperFieldAccessNode.
     * The specified start and stop locations are used.
     */
    @Override
    public SuperFieldAccessNode makeSuperFieldAccessNodeWithUnions(
            NodeUnion<? extends UnparameterizedTypeNode> type,
            NodeUnion<? extends IdentifierNode> identifier,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        SuperFieldAccessNode node = factory.makeSuperFieldAccessNodeWithUnions(type, identifier, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a SuperFieldAccessNode.
     * The specified start and stop locations are used.
     */
    @Override
    public SuperFieldAccessNode makeSuperFieldAccessNode(
            UnparameterizedTypeNode type,
            IdentifierNode identifier,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        SuperFieldAccessNode node = factory.makeSuperFieldAccessNode(type, identifier, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a SuperFieldAccessNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public SuperFieldAccessNode makeSuperFieldAccessNode(
            IdentifierNode identifier)
    {
        this.before();
        SuperFieldAccessNode node = factory.makeSuperFieldAccessNode(identifier);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a SuperFieldAccessNode.
     * The specified start and stop locations are used.
     */
    @Override
    public SuperFieldAccessNode makeSuperFieldAccessNode(
            IdentifierNode identifier,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        SuperFieldAccessNode node = factory.makeSuperFieldAccessNode(identifier, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a SuperMethodInvocationNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public SuperMethodInvocationNode makeSuperMethodInvocationNodeWithUnions(
            NodeUnion<? extends UnparameterizedTypeNode> type,
            NodeUnion<? extends IdentifierNode> identifier,
            NodeUnion<? extends ExpressionListNode> arguments,
            NodeUnion<? extends ReferenceTypeListNode> typeArguments)
    {
        this.before();
        SuperMethodInvocationNode node = factory.makeSuperMethodInvocationNodeWithUnions(type, identifier, arguments, typeArguments);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a SuperMethodInvocationNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public SuperMethodInvocationNode makeSuperMethodInvocationNode(
            UnparameterizedTypeNode type,
            IdentifierNode identifier,
            ExpressionListNode arguments,
            ReferenceTypeListNode typeArguments)
    {
        this.before();
        SuperMethodInvocationNode node = factory.makeSuperMethodInvocationNode(type, identifier, arguments, typeArguments);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a SuperMethodInvocationNode.
     * The specified start and stop locations are used.
     */
    @Override
    public SuperMethodInvocationNode makeSuperMethodInvocationNodeWithUnions(
            NodeUnion<? extends UnparameterizedTypeNode> type,
            NodeUnion<? extends IdentifierNode> identifier,
            NodeUnion<? extends ExpressionListNode> arguments,
            NodeUnion<? extends ReferenceTypeListNode> typeArguments,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        SuperMethodInvocationNode node = factory.makeSuperMethodInvocationNodeWithUnions(type, identifier, arguments, typeArguments, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a SuperMethodInvocationNode.
     * The specified start and stop locations are used.
     */
    @Override
    public SuperMethodInvocationNode makeSuperMethodInvocationNode(
            UnparameterizedTypeNode type,
            IdentifierNode identifier,
            ExpressionListNode arguments,
            ReferenceTypeListNode typeArguments,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        SuperMethodInvocationNode node = factory.makeSuperMethodInvocationNode(type, identifier, arguments, typeArguments, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a SuperMethodInvocationNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public SuperMethodInvocationNode makeSuperMethodInvocationNode(
            IdentifierNode identifier,
            ExpressionListNode arguments)
    {
        this.before();
        SuperMethodInvocationNode node = factory.makeSuperMethodInvocationNode(identifier, arguments);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a SuperMethodInvocationNode.
     * The specified start and stop locations are used.
     */
    @Override
    public SuperMethodInvocationNode makeSuperMethodInvocationNode(
            IdentifierNode identifier,
            ExpressionListNode arguments,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        SuperMethodInvocationNode node = factory.makeSuperMethodInvocationNode(identifier, arguments, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a SuperMethodInvocationNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public SuperMethodInvocationNode makeSuperMethodInvocationNode(
            IdentifierNode identifier,
            ExpressionListNode arguments,
            ReferenceTypeListNode typeArguments)
    {
        this.before();
        SuperMethodInvocationNode node = factory.makeSuperMethodInvocationNode(identifier, arguments, typeArguments);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a SuperMethodInvocationNode.
     * The specified start and stop locations are used.
     */
    @Override
    public SuperMethodInvocationNode makeSuperMethodInvocationNode(
            IdentifierNode identifier,
            ExpressionListNode arguments,
            ReferenceTypeListNode typeArguments,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        SuperMethodInvocationNode node = factory.makeSuperMethodInvocationNode(identifier, arguments, typeArguments, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a SuperclassConstructorInvocationNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public SuperclassConstructorInvocationNode makeSuperclassConstructorInvocationNodeWithUnions(
            NodeUnion<? extends PrimaryExpressionNode> qualifyingExpression,
            NodeUnion<? extends ExpressionListNode> arguments,
            NodeUnion<? extends ReferenceTypeListNode> typeArguments)
    {
        this.before();
        SuperclassConstructorInvocationNode node = factory.makeSuperclassConstructorInvocationNodeWithUnions(qualifyingExpression, arguments, typeArguments);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a SuperclassConstructorInvocationNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public SuperclassConstructorInvocationNode makeSuperclassConstructorInvocationNode(
            PrimaryExpressionNode qualifyingExpression,
            ExpressionListNode arguments,
            ReferenceTypeListNode typeArguments)
    {
        this.before();
        SuperclassConstructorInvocationNode node = factory.makeSuperclassConstructorInvocationNode(qualifyingExpression, arguments, typeArguments);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a SuperclassConstructorInvocationNode.
     * The specified start and stop locations are used.
     */
    @Override
    public SuperclassConstructorInvocationNode makeSuperclassConstructorInvocationNodeWithUnions(
            NodeUnion<? extends PrimaryExpressionNode> qualifyingExpression,
            NodeUnion<? extends ExpressionListNode> arguments,
            NodeUnion<? extends ReferenceTypeListNode> typeArguments,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        SuperclassConstructorInvocationNode node = factory.makeSuperclassConstructorInvocationNodeWithUnions(qualifyingExpression, arguments, typeArguments, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a SuperclassConstructorInvocationNode.
     * The specified start and stop locations are used.
     */
    @Override
    public SuperclassConstructorInvocationNode makeSuperclassConstructorInvocationNode(
            PrimaryExpressionNode qualifyingExpression,
            ExpressionListNode arguments,
            ReferenceTypeListNode typeArguments,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        SuperclassConstructorInvocationNode node = factory.makeSuperclassConstructorInvocationNode(qualifyingExpression, arguments, typeArguments, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a SuperclassConstructorInvocationNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public SuperclassConstructorInvocationNode makeSuperclassConstructorInvocationNode(
            ExpressionListNode arguments)
    {
        this.before();
        SuperclassConstructorInvocationNode node = factory.makeSuperclassConstructorInvocationNode(arguments);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a SuperclassConstructorInvocationNode.
     * The specified start and stop locations are used.
     */
    @Override
    public SuperclassConstructorInvocationNode makeSuperclassConstructorInvocationNode(
            ExpressionListNode arguments,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        SuperclassConstructorInvocationNode node = factory.makeSuperclassConstructorInvocationNode(arguments, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a SwitchNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public SwitchNode makeSwitchNodeWithUnions(
            NodeUnion<? extends ExpressionNode> expression,
            NodeUnion<? extends CaseListNode> cases,
            NodeUnion<? extends MetaAnnotationListNode> metaAnnotations)
    {
        this.before();
        SwitchNode node = factory.makeSwitchNodeWithUnions(expression, cases, metaAnnotations);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a SwitchNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public SwitchNode makeSwitchNode(
            ExpressionNode expression,
            CaseListNode cases,
            MetaAnnotationListNode metaAnnotations)
    {
        this.before();
        SwitchNode node = factory.makeSwitchNode(expression, cases, metaAnnotations);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a SwitchNode.
     * The specified start and stop locations are used.
     */
    @Override
    public SwitchNode makeSwitchNodeWithUnions(
            NodeUnion<? extends ExpressionNode> expression,
            NodeUnion<? extends CaseListNode> cases,
            NodeUnion<? extends MetaAnnotationListNode> metaAnnotations,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        SwitchNode node = factory.makeSwitchNodeWithUnions(expression, cases, metaAnnotations, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a SwitchNode.
     * The specified start and stop locations are used.
     */
    @Override
    public SwitchNode makeSwitchNode(
            ExpressionNode expression,
            CaseListNode cases,
            MetaAnnotationListNode metaAnnotations,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        SwitchNode node = factory.makeSwitchNode(expression, cases, metaAnnotations, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a SwitchNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public SwitchNode makeSwitchNode(
            ExpressionNode expression,
            CaseListNode cases)
    {
        this.before();
        SwitchNode node = factory.makeSwitchNode(expression, cases);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a SwitchNode.
     * The specified start and stop locations are used.
     */
    @Override
    public SwitchNode makeSwitchNode(
            ExpressionNode expression,
            CaseListNode cases,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        SwitchNode node = factory.makeSwitchNode(expression, cases, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a SynchronizedNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public SynchronizedNode makeSynchronizedNodeWithUnions(
            NodeUnion<? extends ExpressionNode> expression,
            NodeUnion<? extends BlockStatementListNode> body,
            NodeUnion<? extends MetaAnnotationListNode> metaAnnotations)
    {
        this.before();
        SynchronizedNode node = factory.makeSynchronizedNodeWithUnions(expression, body, metaAnnotations);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a SynchronizedNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public SynchronizedNode makeSynchronizedNode(
            ExpressionNode expression,
            BlockStatementListNode body,
            MetaAnnotationListNode metaAnnotations)
    {
        this.before();
        SynchronizedNode node = factory.makeSynchronizedNode(expression, body, metaAnnotations);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a SynchronizedNode.
     * The specified start and stop locations are used.
     */
    @Override
    public SynchronizedNode makeSynchronizedNodeWithUnions(
            NodeUnion<? extends ExpressionNode> expression,
            NodeUnion<? extends BlockStatementListNode> body,
            NodeUnion<? extends MetaAnnotationListNode> metaAnnotations,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        SynchronizedNode node = factory.makeSynchronizedNodeWithUnions(expression, body, metaAnnotations, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a SynchronizedNode.
     * The specified start and stop locations are used.
     */
    @Override
    public SynchronizedNode makeSynchronizedNode(
            ExpressionNode expression,
            BlockStatementListNode body,
            MetaAnnotationListNode metaAnnotations,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        SynchronizedNode node = factory.makeSynchronizedNode(expression, body, metaAnnotations, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a SynchronizedNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public SynchronizedNode makeSynchronizedNode(
            ExpressionNode expression,
            BlockStatementListNode body)
    {
        this.before();
        SynchronizedNode node = factory.makeSynchronizedNode(expression, body);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a SynchronizedNode.
     * The specified start and stop locations are used.
     */
    @Override
    public SynchronizedNode makeSynchronizedNode(
            ExpressionNode expression,
            BlockStatementListNode body,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        SynchronizedNode node = factory.makeSynchronizedNode(expression, body, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a ThisNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public ThisNode makeThisNodeWithUnions(
            NodeUnion<? extends UnparameterizedTypeNode> type)
    {
        this.before();
        ThisNode node = factory.makeThisNodeWithUnions(type);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a ThisNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public ThisNode makeThisNode(
            UnparameterizedTypeNode type)
    {
        this.before();
        ThisNode node = factory.makeThisNode(type);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a ThisNode.
     * The specified start and stop locations are used.
     */
    @Override
    public ThisNode makeThisNodeWithUnions(
            NodeUnion<? extends UnparameterizedTypeNode> type,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        ThisNode node = factory.makeThisNodeWithUnions(type, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a ThisNode.
     * The specified start and stop locations are used.
     */
    @Override
    public ThisNode makeThisNode(
            UnparameterizedTypeNode type,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        ThisNode node = factory.makeThisNode(type, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a ThisNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public ThisNode makeThisNode()
    {
        this.before();
        ThisNode node = factory.makeThisNode();
        this.after(node);
        return node;
    }
    
    /**
     * Creates a ThisNode.
     * The specified start and stop locations are used.
     */
    @Override
    public ThisNode makeThisNode(
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        ThisNode node = factory.makeThisNode(startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a ThrowNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public ThrowNode makeThrowNodeWithUnions(
            NodeUnion<? extends ExpressionNode> expression,
            NodeUnion<? extends MetaAnnotationListNode> metaAnnotations)
    {
        this.before();
        ThrowNode node = factory.makeThrowNodeWithUnions(expression, metaAnnotations);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a ThrowNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public ThrowNode makeThrowNode(
            ExpressionNode expression,
            MetaAnnotationListNode metaAnnotations)
    {
        this.before();
        ThrowNode node = factory.makeThrowNode(expression, metaAnnotations);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a ThrowNode.
     * The specified start and stop locations are used.
     */
    @Override
    public ThrowNode makeThrowNodeWithUnions(
            NodeUnion<? extends ExpressionNode> expression,
            NodeUnion<? extends MetaAnnotationListNode> metaAnnotations,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        ThrowNode node = factory.makeThrowNodeWithUnions(expression, metaAnnotations, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a ThrowNode.
     * The specified start and stop locations are used.
     */
    @Override
    public ThrowNode makeThrowNode(
            ExpressionNode expression,
            MetaAnnotationListNode metaAnnotations,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        ThrowNode node = factory.makeThrowNode(expression, metaAnnotations, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a ThrowNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public ThrowNode makeThrowNode(
            ExpressionNode expression)
    {
        this.before();
        ThrowNode node = factory.makeThrowNode(expression);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a ThrowNode.
     * The specified start and stop locations are used.
     */
    @Override
    public ThrowNode makeThrowNode(
            ExpressionNode expression,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        ThrowNode node = factory.makeThrowNode(expression, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a TryNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public TryNode makeTryNodeWithUnions(
            NodeUnion<? extends BlockStatementListNode> body,
            NodeUnion<? extends CatchListNode> catches,
            NodeUnion<? extends BlockStatementListNode> finallyBlock,
            NodeUnion<? extends MetaAnnotationListNode> metaAnnotations)
    {
        this.before();
        TryNode node = factory.makeTryNodeWithUnions(body, catches, finallyBlock, metaAnnotations);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a TryNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public TryNode makeTryNode(
            BlockStatementListNode body,
            CatchListNode catches,
            BlockStatementListNode finallyBlock,
            MetaAnnotationListNode metaAnnotations)
    {
        this.before();
        TryNode node = factory.makeTryNode(body, catches, finallyBlock, metaAnnotations);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a TryNode.
     * The specified start and stop locations are used.
     */
    @Override
    public TryNode makeTryNodeWithUnions(
            NodeUnion<? extends BlockStatementListNode> body,
            NodeUnion<? extends CatchListNode> catches,
            NodeUnion<? extends BlockStatementListNode> finallyBlock,
            NodeUnion<? extends MetaAnnotationListNode> metaAnnotations,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        TryNode node = factory.makeTryNodeWithUnions(body, catches, finallyBlock, metaAnnotations, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a TryNode.
     * The specified start and stop locations are used.
     */
    @Override
    public TryNode makeTryNode(
            BlockStatementListNode body,
            CatchListNode catches,
            BlockStatementListNode finallyBlock,
            MetaAnnotationListNode metaAnnotations,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        TryNode node = factory.makeTryNode(body, catches, finallyBlock, metaAnnotations, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a TryNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public TryNode makeTryNode(
            BlockStatementListNode body,
            BlockStatementListNode finallyBlock)
    {
        this.before();
        TryNode node = factory.makeTryNode(body, finallyBlock);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a TryNode.
     * The specified start and stop locations are used.
     */
    @Override
    public TryNode makeTryNode(
            BlockStatementListNode body,
            BlockStatementListNode finallyBlock,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        TryNode node = factory.makeTryNode(body, finallyBlock, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a TryNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public TryNode makeTryNode(
            BlockStatementListNode body,
            CatchListNode catches)
    {
        this.before();
        TryNode node = factory.makeTryNode(body, catches);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a TryNode.
     * The specified start and stop locations are used.
     */
    @Override
    public TryNode makeTryNode(
            BlockStatementListNode body,
            CatchListNode catches,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        TryNode node = factory.makeTryNode(body, catches, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a TryNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public TryNode makeTryNode(
            BlockStatementListNode body,
            CatchListNode catches,
            BlockStatementListNode finallyBlock)
    {
        this.before();
        TryNode node = factory.makeTryNode(body, catches, finallyBlock);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a TryNode.
     * The specified start and stop locations are used.
     */
    @Override
    public TryNode makeTryNode(
            BlockStatementListNode body,
            CatchListNode catches,
            BlockStatementListNode finallyBlock,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        TryNode node = factory.makeTryNode(body, catches, finallyBlock, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a TypeArgumentListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public TypeArgumentListNode makeTypeArgumentListNodeWithUnions(
            List<NodeUnion<? extends TypeArgumentNode>> children)
    {
        this.before();
        TypeArgumentListNode node = factory.makeTypeArgumentListNodeWithUnions(children);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a TypeArgumentListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public TypeArgumentListNode makeTypeArgumentListNode(
            List<TypeArgumentNode> children)
    {
        this.before();
        TypeArgumentListNode node = factory.makeTypeArgumentListNode(children);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a TypeArgumentListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public TypeArgumentListNode makeTypeArgumentListNode(
            TypeArgumentNode... childrenElements)
    {
        this.before();
        TypeArgumentListNode node = factory.makeTypeArgumentListNode(childrenElements);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a TypeArgumentListNode.
     * The specified start and stop locations are used.
     */
    @Override
    public TypeArgumentListNode makeTypeArgumentListNodeWithUnions(
            List<NodeUnion<? extends TypeArgumentNode>> children,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        TypeArgumentListNode node = factory.makeTypeArgumentListNodeWithUnions(children, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a TypeArgumentListNode.
     * The specified start and stop locations are used.
     */
    @Override
    public TypeArgumentListNode makeTypeArgumentListNode(
            List<TypeArgumentNode> children,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        TypeArgumentListNode node = factory.makeTypeArgumentListNode(children, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a TypeArgumentListNode.
     * The specified start and stop locations are used.
     */
    @Override
    public TypeArgumentListNode makeTypeArgumentListNode(
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation,
            TypeArgumentNode... childrenElements)
    {
        this.before();
        TypeArgumentListNode node = factory.makeTypeArgumentListNode(startLocation, stopLocation, childrenElements);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a TypeCastNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public TypeCastNode makeTypeCastNodeWithUnions(
            NodeUnion<? extends ExpressionNode> expression,
            NodeUnion<? extends TypeNode> type)
    {
        this.before();
        TypeCastNode node = factory.makeTypeCastNodeWithUnions(expression, type);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a TypeCastNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public TypeCastNode makeTypeCastNode(
            ExpressionNode expression,
            TypeNode type)
    {
        this.before();
        TypeCastNode node = factory.makeTypeCastNode(expression, type);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a TypeCastNode.
     * The specified start and stop locations are used.
     */
    @Override
    public TypeCastNode makeTypeCastNodeWithUnions(
            NodeUnion<? extends ExpressionNode> expression,
            NodeUnion<? extends TypeNode> type,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        TypeCastNode node = factory.makeTypeCastNodeWithUnions(expression, type, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a TypeCastNode.
     * The specified start and stop locations are used.
     */
    @Override
    public TypeCastNode makeTypeCastNode(
            ExpressionNode expression,
            TypeNode type,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        TypeCastNode node = factory.makeTypeCastNode(expression, type, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a TypeDeclarationListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public TypeDeclarationListNode makeTypeDeclarationListNodeWithUnions(
            List<NodeUnion<? extends TypeDeclarationNode>> children)
    {
        this.before();
        TypeDeclarationListNode node = factory.makeTypeDeclarationListNodeWithUnions(children);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a TypeDeclarationListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public TypeDeclarationListNode makeTypeDeclarationListNode(
            List<TypeDeclarationNode> children)
    {
        this.before();
        TypeDeclarationListNode node = factory.makeTypeDeclarationListNode(children);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a TypeDeclarationListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public TypeDeclarationListNode makeTypeDeclarationListNode(
            TypeDeclarationNode... childrenElements)
    {
        this.before();
        TypeDeclarationListNode node = factory.makeTypeDeclarationListNode(childrenElements);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a TypeDeclarationListNode.
     * The specified start and stop locations are used.
     */
    @Override
    public TypeDeclarationListNode makeTypeDeclarationListNodeWithUnions(
            List<NodeUnion<? extends TypeDeclarationNode>> children,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        TypeDeclarationListNode node = factory.makeTypeDeclarationListNodeWithUnions(children, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a TypeDeclarationListNode.
     * The specified start and stop locations are used.
     */
    @Override
    public TypeDeclarationListNode makeTypeDeclarationListNode(
            List<TypeDeclarationNode> children,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        TypeDeclarationListNode node = factory.makeTypeDeclarationListNode(children, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a TypeDeclarationListNode.
     * The specified start and stop locations are used.
     */
    @Override
    public TypeDeclarationListNode makeTypeDeclarationListNode(
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation,
            TypeDeclarationNode... childrenElements)
    {
        this.before();
        TypeDeclarationListNode node = factory.makeTypeDeclarationListNode(startLocation, stopLocation, childrenElements);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a TypeDeclarationMetaprogramAnchorNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public TypeDeclarationMetaprogramAnchorNode makeTypeDeclarationMetaprogramAnchorNodeWithUnions(
            NodeUnion<? extends MetaprogramNode> metaprogram)
    {
        this.before();
        TypeDeclarationMetaprogramAnchorNode node = factory.makeTypeDeclarationMetaprogramAnchorNodeWithUnions(metaprogram);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a TypeDeclarationMetaprogramAnchorNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public TypeDeclarationMetaprogramAnchorNode makeTypeDeclarationMetaprogramAnchorNode(
            MetaprogramNode metaprogram)
    {
        this.before();
        TypeDeclarationMetaprogramAnchorNode node = factory.makeTypeDeclarationMetaprogramAnchorNode(metaprogram);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a TypeDeclarationMetaprogramAnchorNode.
     * The specified start and stop locations are used.
     */
    @Override
    public TypeDeclarationMetaprogramAnchorNode makeTypeDeclarationMetaprogramAnchorNodeWithUnions(
            NodeUnion<? extends MetaprogramNode> metaprogram,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        TypeDeclarationMetaprogramAnchorNode node = factory.makeTypeDeclarationMetaprogramAnchorNodeWithUnions(metaprogram, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a TypeDeclarationMetaprogramAnchorNode.
     * The specified start and stop locations are used.
     */
    @Override
    public TypeDeclarationMetaprogramAnchorNode makeTypeDeclarationMetaprogramAnchorNode(
            MetaprogramNode metaprogram,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        TypeDeclarationMetaprogramAnchorNode node = factory.makeTypeDeclarationMetaprogramAnchorNode(metaprogram, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a TypeParameterListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public TypeParameterListNode makeTypeParameterListNodeWithUnions(
            List<NodeUnion<? extends TypeParameterNode>> children)
    {
        this.before();
        TypeParameterListNode node = factory.makeTypeParameterListNodeWithUnions(children);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a TypeParameterListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public TypeParameterListNode makeTypeParameterListNode(
            List<TypeParameterNode> children)
    {
        this.before();
        TypeParameterListNode node = factory.makeTypeParameterListNode(children);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a TypeParameterListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public TypeParameterListNode makeTypeParameterListNode(
            TypeParameterNode... childrenElements)
    {
        this.before();
        TypeParameterListNode node = factory.makeTypeParameterListNode(childrenElements);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a TypeParameterListNode.
     * The specified start and stop locations are used.
     */
    @Override
    public TypeParameterListNode makeTypeParameterListNodeWithUnions(
            List<NodeUnion<? extends TypeParameterNode>> children,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        TypeParameterListNode node = factory.makeTypeParameterListNodeWithUnions(children, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a TypeParameterListNode.
     * The specified start and stop locations are used.
     */
    @Override
    public TypeParameterListNode makeTypeParameterListNode(
            List<TypeParameterNode> children,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        TypeParameterListNode node = factory.makeTypeParameterListNode(children, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a TypeParameterListNode.
     * The specified start and stop locations are used.
     */
    @Override
    public TypeParameterListNode makeTypeParameterListNode(
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation,
            TypeParameterNode... childrenElements)
    {
        this.before();
        TypeParameterListNode node = factory.makeTypeParameterListNode(startLocation, stopLocation, childrenElements);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a TypeParameterNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public TypeParameterNode makeTypeParameterNodeWithUnions(
            NodeUnion<? extends IdentifierNode> identifier,
            NodeUnion<? extends DeclaredTypeListNode> bounds)
    {
        this.before();
        TypeParameterNode node = factory.makeTypeParameterNodeWithUnions(identifier, bounds);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a TypeParameterNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public TypeParameterNode makeTypeParameterNode(
            IdentifierNode identifier,
            DeclaredTypeListNode bounds)
    {
        this.before();
        TypeParameterNode node = factory.makeTypeParameterNode(identifier, bounds);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a TypeParameterNode.
     * The specified start and stop locations are used.
     */
    @Override
    public TypeParameterNode makeTypeParameterNodeWithUnions(
            NodeUnion<? extends IdentifierNode> identifier,
            NodeUnion<? extends DeclaredTypeListNode> bounds,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        TypeParameterNode node = factory.makeTypeParameterNodeWithUnions(identifier, bounds, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a TypeParameterNode.
     * The specified start and stop locations are used.
     */
    @Override
    public TypeParameterNode makeTypeParameterNode(
            IdentifierNode identifier,
            DeclaredTypeListNode bounds,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        TypeParameterNode node = factory.makeTypeParameterNode(identifier, bounds, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a UnaryExpressionNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public UnaryExpressionNode makeUnaryExpressionNodeWithUnions(
            NodeUnion<? extends ExpressionNode> expression,
            UnaryOperator operator)
    {
        this.before();
        UnaryExpressionNode node = factory.makeUnaryExpressionNodeWithUnions(expression, operator);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a UnaryExpressionNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public UnaryExpressionNode makeUnaryExpressionNode(
            ExpressionNode expression,
            UnaryOperator operator)
    {
        this.before();
        UnaryExpressionNode node = factory.makeUnaryExpressionNode(expression, operator);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a UnaryExpressionNode.
     * The specified start and stop locations are used.
     */
    @Override
    public UnaryExpressionNode makeUnaryExpressionNodeWithUnions(
            NodeUnion<? extends ExpressionNode> expression,
            UnaryOperator operator,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        UnaryExpressionNode node = factory.makeUnaryExpressionNodeWithUnions(expression, operator, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a UnaryExpressionNode.
     * The specified start and stop locations are used.
     */
    @Override
    public UnaryExpressionNode makeUnaryExpressionNode(
            ExpressionNode expression,
            UnaryOperator operator,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        UnaryExpressionNode node = factory.makeUnaryExpressionNode(expression, operator, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a UnaryStatementExpressionNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public UnaryStatementExpressionNode makeUnaryStatementExpressionNodeWithUnions(
            NodeUnion<? extends ExpressionNode> expression,
            UnaryStatementOperator operator)
    {
        this.before();
        UnaryStatementExpressionNode node = factory.makeUnaryStatementExpressionNodeWithUnions(expression, operator);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a UnaryStatementExpressionNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public UnaryStatementExpressionNode makeUnaryStatementExpressionNode(
            ExpressionNode expression,
            UnaryStatementOperator operator)
    {
        this.before();
        UnaryStatementExpressionNode node = factory.makeUnaryStatementExpressionNode(expression, operator);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a UnaryStatementExpressionNode.
     * The specified start and stop locations are used.
     */
    @Override
    public UnaryStatementExpressionNode makeUnaryStatementExpressionNodeWithUnions(
            NodeUnion<? extends ExpressionNode> expression,
            UnaryStatementOperator operator,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        UnaryStatementExpressionNode node = factory.makeUnaryStatementExpressionNodeWithUnions(expression, operator, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a UnaryStatementExpressionNode.
     * The specified start and stop locations are used.
     */
    @Override
    public UnaryStatementExpressionNode makeUnaryStatementExpressionNode(
            ExpressionNode expression,
            UnaryStatementOperator operator,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        UnaryStatementExpressionNode node = factory.makeUnaryStatementExpressionNode(expression, operator, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a UnparameterizedTypeListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public UnparameterizedTypeListNode makeUnparameterizedTypeListNodeWithUnions(
            List<NodeUnion<? extends UnparameterizedTypeNode>> children)
    {
        this.before();
        UnparameterizedTypeListNode node = factory.makeUnparameterizedTypeListNodeWithUnions(children);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a UnparameterizedTypeListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public UnparameterizedTypeListNode makeUnparameterizedTypeListNode(
            List<UnparameterizedTypeNode> children)
    {
        this.before();
        UnparameterizedTypeListNode node = factory.makeUnparameterizedTypeListNode(children);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a UnparameterizedTypeListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public UnparameterizedTypeListNode makeUnparameterizedTypeListNode(
            UnparameterizedTypeNode... childrenElements)
    {
        this.before();
        UnparameterizedTypeListNode node = factory.makeUnparameterizedTypeListNode(childrenElements);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a UnparameterizedTypeListNode.
     * The specified start and stop locations are used.
     */
    @Override
    public UnparameterizedTypeListNode makeUnparameterizedTypeListNodeWithUnions(
            List<NodeUnion<? extends UnparameterizedTypeNode>> children,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        UnparameterizedTypeListNode node = factory.makeUnparameterizedTypeListNodeWithUnions(children, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a UnparameterizedTypeListNode.
     * The specified start and stop locations are used.
     */
    @Override
    public UnparameterizedTypeListNode makeUnparameterizedTypeListNode(
            List<UnparameterizedTypeNode> children,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        UnparameterizedTypeListNode node = factory.makeUnparameterizedTypeListNode(children, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a UnparameterizedTypeListNode.
     * The specified start and stop locations are used.
     */
    @Override
    public UnparameterizedTypeListNode makeUnparameterizedTypeListNode(
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation,
            UnparameterizedTypeNode... childrenElements)
    {
        this.before();
        UnparameterizedTypeListNode node = factory.makeUnparameterizedTypeListNode(startLocation, stopLocation, childrenElements);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a UnparameterizedTypeNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public UnparameterizedTypeNode makeUnparameterizedTypeNodeWithUnions(
            NodeUnion<? extends NameNode> name)
    {
        this.before();
        UnparameterizedTypeNode node = factory.makeUnparameterizedTypeNodeWithUnions(name);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a UnparameterizedTypeNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public UnparameterizedTypeNode makeUnparameterizedTypeNode(
            NameNode name)
    {
        this.before();
        UnparameterizedTypeNode node = factory.makeUnparameterizedTypeNode(name);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a UnparameterizedTypeNode.
     * The specified start and stop locations are used.
     */
    @Override
    public UnparameterizedTypeNode makeUnparameterizedTypeNodeWithUnions(
            NodeUnion<? extends NameNode> name,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        UnparameterizedTypeNode node = factory.makeUnparameterizedTypeNodeWithUnions(name, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a UnparameterizedTypeNode.
     * The specified start and stop locations are used.
     */
    @Override
    public UnparameterizedTypeNode makeUnparameterizedTypeNode(
            NameNode name,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        UnparameterizedTypeNode node = factory.makeUnparameterizedTypeNode(name, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a UnqualifiedClassInstantiationNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public UnqualifiedClassInstantiationNode makeUnqualifiedClassInstantiationNodeWithUnions(
            NodeUnion<? extends DeclaredTypeNode> type,
            NodeUnion<? extends TypeArgumentListNode> constructorTypeArguments,
            NodeUnion<? extends ExpressionListNode> arguments,
            NodeUnion<? extends AnonymousClassBodyNode> body)
    {
        this.before();
        UnqualifiedClassInstantiationNode node = factory.makeUnqualifiedClassInstantiationNodeWithUnions(type, constructorTypeArguments, arguments, body);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a UnqualifiedClassInstantiationNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public UnqualifiedClassInstantiationNode makeUnqualifiedClassInstantiationNode(
            DeclaredTypeNode type,
            TypeArgumentListNode constructorTypeArguments,
            ExpressionListNode arguments,
            AnonymousClassBodyNode body)
    {
        this.before();
        UnqualifiedClassInstantiationNode node = factory.makeUnqualifiedClassInstantiationNode(type, constructorTypeArguments, arguments, body);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a UnqualifiedClassInstantiationNode.
     * The specified start and stop locations are used.
     */
    @Override
    public UnqualifiedClassInstantiationNode makeUnqualifiedClassInstantiationNodeWithUnions(
            NodeUnion<? extends DeclaredTypeNode> type,
            NodeUnion<? extends TypeArgumentListNode> constructorTypeArguments,
            NodeUnion<? extends ExpressionListNode> arguments,
            NodeUnion<? extends AnonymousClassBodyNode> body,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        UnqualifiedClassInstantiationNode node = factory.makeUnqualifiedClassInstantiationNodeWithUnions(type, constructorTypeArguments, arguments, body, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a UnqualifiedClassInstantiationNode.
     * The specified start and stop locations are used.
     */
    @Override
    public UnqualifiedClassInstantiationNode makeUnqualifiedClassInstantiationNode(
            DeclaredTypeNode type,
            TypeArgumentListNode constructorTypeArguments,
            ExpressionListNode arguments,
            AnonymousClassBodyNode body,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        UnqualifiedClassInstantiationNode node = factory.makeUnqualifiedClassInstantiationNode(type, constructorTypeArguments, arguments, body, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a UnqualifiedClassInstantiationNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public UnqualifiedClassInstantiationNode makeUnqualifiedClassInstantiationNode(
            DeclaredTypeNode type)
    {
        this.before();
        UnqualifiedClassInstantiationNode node = factory.makeUnqualifiedClassInstantiationNode(type);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a UnqualifiedClassInstantiationNode.
     * The specified start and stop locations are used.
     */
    @Override
    public UnqualifiedClassInstantiationNode makeUnqualifiedClassInstantiationNode(
            DeclaredTypeNode type,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        UnqualifiedClassInstantiationNode node = factory.makeUnqualifiedClassInstantiationNode(type, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a UnqualifiedClassInstantiationNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public UnqualifiedClassInstantiationNode makeUnqualifiedClassInstantiationNode(
            DeclaredTypeNode type,
            ExpressionListNode arguments)
    {
        this.before();
        UnqualifiedClassInstantiationNode node = factory.makeUnqualifiedClassInstantiationNode(type, arguments);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a UnqualifiedClassInstantiationNode.
     * The specified start and stop locations are used.
     */
    @Override
    public UnqualifiedClassInstantiationNode makeUnqualifiedClassInstantiationNode(
            DeclaredTypeNode type,
            ExpressionListNode arguments,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        UnqualifiedClassInstantiationNode node = factory.makeUnqualifiedClassInstantiationNode(type, arguments, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a VariableAccessNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public VariableAccessNode makeVariableAccessNodeWithUnions(
            NodeUnion<? extends PrimaryExpressionNode> expression,
            NodeUnion<? extends IdentifierNode> identifier)
    {
        this.before();
        VariableAccessNode node = factory.makeVariableAccessNodeWithUnions(expression, identifier);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a VariableAccessNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public VariableAccessNode makeVariableAccessNode(
            PrimaryExpressionNode expression,
            IdentifierNode identifier)
    {
        this.before();
        VariableAccessNode node = factory.makeVariableAccessNode(expression, identifier);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a VariableAccessNode.
     * The specified start and stop locations are used.
     */
    @Override
    public VariableAccessNode makeVariableAccessNodeWithUnions(
            NodeUnion<? extends PrimaryExpressionNode> expression,
            NodeUnion<? extends IdentifierNode> identifier,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        VariableAccessNode node = factory.makeVariableAccessNodeWithUnions(expression, identifier, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a VariableAccessNode.
     * The specified start and stop locations are used.
     */
    @Override
    public VariableAccessNode makeVariableAccessNode(
            PrimaryExpressionNode expression,
            IdentifierNode identifier,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        VariableAccessNode node = factory.makeVariableAccessNode(expression, identifier, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a VariableAccessNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public VariableAccessNode makeVariableAccessNode(
            IdentifierNode identifier)
    {
        this.before();
        VariableAccessNode node = factory.makeVariableAccessNode(identifier);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a VariableAccessNode.
     * The specified start and stop locations are used.
     */
    @Override
    public VariableAccessNode makeVariableAccessNode(
            IdentifierNode identifier,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        VariableAccessNode node = factory.makeVariableAccessNode(identifier, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a VariableDeclaratorListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public VariableDeclaratorListNode makeVariableDeclaratorListNodeWithUnions(
            List<NodeUnion<? extends VariableDeclaratorNode>> children)
    {
        this.before();
        VariableDeclaratorListNode node = factory.makeVariableDeclaratorListNodeWithUnions(children);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a VariableDeclaratorListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public VariableDeclaratorListNode makeVariableDeclaratorListNode(
            List<VariableDeclaratorNode> children)
    {
        this.before();
        VariableDeclaratorListNode node = factory.makeVariableDeclaratorListNode(children);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a VariableDeclaratorListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public VariableDeclaratorListNode makeVariableDeclaratorListNode(
            VariableDeclaratorNode... childrenElements)
    {
        this.before();
        VariableDeclaratorListNode node = factory.makeVariableDeclaratorListNode(childrenElements);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a VariableDeclaratorListNode.
     * The specified start and stop locations are used.
     */
    @Override
    public VariableDeclaratorListNode makeVariableDeclaratorListNodeWithUnions(
            List<NodeUnion<? extends VariableDeclaratorNode>> children,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        VariableDeclaratorListNode node = factory.makeVariableDeclaratorListNodeWithUnions(children, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a VariableDeclaratorListNode.
     * The specified start and stop locations are used.
     */
    @Override
    public VariableDeclaratorListNode makeVariableDeclaratorListNode(
            List<VariableDeclaratorNode> children,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        VariableDeclaratorListNode node = factory.makeVariableDeclaratorListNode(children, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a VariableDeclaratorListNode.
     * The specified start and stop locations are used.
     */
    @Override
    public VariableDeclaratorListNode makeVariableDeclaratorListNode(
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation,
            VariableDeclaratorNode... childrenElements)
    {
        this.before();
        VariableDeclaratorListNode node = factory.makeVariableDeclaratorListNode(startLocation, stopLocation, childrenElements);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a VariableDeclaratorNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public VariableDeclaratorNode makeVariableDeclaratorNodeWithUnions(
            NodeUnion<? extends IdentifierNode> identifier,
            int arrayLevels,
            NodeUnion<? extends VariableInitializerNode> initializer)
    {
        this.before();
        VariableDeclaratorNode node = factory.makeVariableDeclaratorNodeWithUnions(identifier, arrayLevels, initializer);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a VariableDeclaratorNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public VariableDeclaratorNode makeVariableDeclaratorNode(
            IdentifierNode identifier,
            int arrayLevels,
            VariableInitializerNode initializer)
    {
        this.before();
        VariableDeclaratorNode node = factory.makeVariableDeclaratorNode(identifier, arrayLevels, initializer);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a VariableDeclaratorNode.
     * The specified start and stop locations are used.
     */
    @Override
    public VariableDeclaratorNode makeVariableDeclaratorNodeWithUnions(
            NodeUnion<? extends IdentifierNode> identifier,
            int arrayLevels,
            NodeUnion<? extends VariableInitializerNode> initializer,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        VariableDeclaratorNode node = factory.makeVariableDeclaratorNodeWithUnions(identifier, arrayLevels, initializer, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a VariableDeclaratorNode.
     * The specified start and stop locations are used.
     */
    @Override
    public VariableDeclaratorNode makeVariableDeclaratorNode(
            IdentifierNode identifier,
            int arrayLevels,
            VariableInitializerNode initializer,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        VariableDeclaratorNode node = factory.makeVariableDeclaratorNode(identifier, arrayLevels, initializer, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a VariableDeclaratorNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public VariableDeclaratorNode makeVariableDeclaratorNode(
            IdentifierNode identifier,
            VariableInitializerNode initializer)
    {
        this.before();
        VariableDeclaratorNode node = factory.makeVariableDeclaratorNode(identifier, initializer);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a VariableDeclaratorNode.
     * The specified start and stop locations are used.
     */
    @Override
    public VariableDeclaratorNode makeVariableDeclaratorNode(
            IdentifierNode identifier,
            VariableInitializerNode initializer,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        VariableDeclaratorNode node = factory.makeVariableDeclaratorNode(identifier, initializer, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a VariableInitializerListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public VariableInitializerListNode makeVariableInitializerListNodeWithUnions(
            List<NodeUnion<? extends VariableInitializerNode>> children)
    {
        this.before();
        VariableInitializerListNode node = factory.makeVariableInitializerListNodeWithUnions(children);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a VariableInitializerListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public VariableInitializerListNode makeVariableInitializerListNode(
            List<VariableInitializerNode> children)
    {
        this.before();
        VariableInitializerListNode node = factory.makeVariableInitializerListNode(children);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a VariableInitializerListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public VariableInitializerListNode makeVariableInitializerListNode(
            VariableInitializerNode... childrenElements)
    {
        this.before();
        VariableInitializerListNode node = factory.makeVariableInitializerListNode(childrenElements);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a VariableInitializerListNode.
     * The specified start and stop locations are used.
     */
    @Override
    public VariableInitializerListNode makeVariableInitializerListNodeWithUnions(
            List<NodeUnion<? extends VariableInitializerNode>> children,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        VariableInitializerListNode node = factory.makeVariableInitializerListNodeWithUnions(children, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a VariableInitializerListNode.
     * The specified start and stop locations are used.
     */
    @Override
    public VariableInitializerListNode makeVariableInitializerListNode(
            List<VariableInitializerNode> children,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        VariableInitializerListNode node = factory.makeVariableInitializerListNode(children, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a VariableInitializerListNode.
     * The specified start and stop locations are used.
     */
    @Override
    public VariableInitializerListNode makeVariableInitializerListNode(
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation,
            VariableInitializerNode... childrenElements)
    {
        this.before();
        VariableInitializerListNode node = factory.makeVariableInitializerListNode(startLocation, stopLocation, childrenElements);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a VariableListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public VariableListNode makeVariableListNodeWithUnions(
            List<NodeUnion<? extends VariableNode>> children)
    {
        this.before();
        VariableListNode node = factory.makeVariableListNodeWithUnions(children);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a VariableListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public VariableListNode makeVariableListNode(
            List<VariableNode> children)
    {
        this.before();
        VariableListNode node = factory.makeVariableListNode(children);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a VariableListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public VariableListNode makeVariableListNode(
            VariableNode... childrenElements)
    {
        this.before();
        VariableListNode node = factory.makeVariableListNode(childrenElements);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a VariableListNode.
     * The specified start and stop locations are used.
     */
    @Override
    public VariableListNode makeVariableListNodeWithUnions(
            List<NodeUnion<? extends VariableNode>> children,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        VariableListNode node = factory.makeVariableListNodeWithUnions(children, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a VariableListNode.
     * The specified start and stop locations are used.
     */
    @Override
    public VariableListNode makeVariableListNode(
            List<VariableNode> children,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        VariableListNode node = factory.makeVariableListNode(children, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a VariableListNode.
     * The specified start and stop locations are used.
     */
    @Override
    public VariableListNode makeVariableListNode(
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation,
            VariableNode... childrenElements)
    {
        this.before();
        VariableListNode node = factory.makeVariableListNode(startLocation, stopLocation, childrenElements);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a VariableModifiersNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public VariableModifiersNode makeVariableModifiersNodeWithUnions(
            boolean finalFlag,
            NodeUnion<? extends MetaAnnotationListNode> metaAnnotations,
            NodeUnion<? extends AnnotationListNode> annotations)
    {
        this.before();
        VariableModifiersNode node = factory.makeVariableModifiersNodeWithUnions(finalFlag, metaAnnotations, annotations);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a VariableModifiersNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public VariableModifiersNode makeVariableModifiersNode(
            boolean finalFlag,
            MetaAnnotationListNode metaAnnotations,
            AnnotationListNode annotations)
    {
        this.before();
        VariableModifiersNode node = factory.makeVariableModifiersNode(finalFlag, metaAnnotations, annotations);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a VariableModifiersNode.
     * The specified start and stop locations are used.
     */
    @Override
    public VariableModifiersNode makeVariableModifiersNodeWithUnions(
            boolean finalFlag,
            NodeUnion<? extends MetaAnnotationListNode> metaAnnotations,
            NodeUnion<? extends AnnotationListNode> annotations,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        VariableModifiersNode node = factory.makeVariableModifiersNodeWithUnions(finalFlag, metaAnnotations, annotations, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a VariableModifiersNode.
     * The specified start and stop locations are used.
     */
    @Override
    public VariableModifiersNode makeVariableModifiersNode(
            boolean finalFlag,
            MetaAnnotationListNode metaAnnotations,
            AnnotationListNode annotations,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        VariableModifiersNode node = factory.makeVariableModifiersNode(finalFlag, metaAnnotations, annotations, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a VariableModifiersNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public VariableModifiersNode makeVariableModifiersNode()
    {
        this.before();
        VariableModifiersNode node = factory.makeVariableModifiersNode();
        this.after(node);
        return node;
    }
    
    /**
     * Creates a VariableModifiersNode.
     * The specified start and stop locations are used.
     */
    @Override
    public VariableModifiersNode makeVariableModifiersNode(
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        VariableModifiersNode node = factory.makeVariableModifiersNode(startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a VariableNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public VariableNode makeVariableNodeWithUnions(
            NodeUnion<? extends VariableModifiersNode> modifiers,
            NodeUnion<? extends TypeNode> type,
            NodeUnion<? extends IdentifierNode> identifier)
    {
        this.before();
        VariableNode node = factory.makeVariableNodeWithUnions(modifiers, type, identifier);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a VariableNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public VariableNode makeVariableNode(
            VariableModifiersNode modifiers,
            TypeNode type,
            IdentifierNode identifier)
    {
        this.before();
        VariableNode node = factory.makeVariableNode(modifiers, type, identifier);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a VariableNode.
     * The specified start and stop locations are used.
     */
    @Override
    public VariableNode makeVariableNodeWithUnions(
            NodeUnion<? extends VariableModifiersNode> modifiers,
            NodeUnion<? extends TypeNode> type,
            NodeUnion<? extends IdentifierNode> identifier,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        VariableNode node = factory.makeVariableNodeWithUnions(modifiers, type, identifier, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a VariableNode.
     * The specified start and stop locations are used.
     */
    @Override
    public VariableNode makeVariableNode(
            VariableModifiersNode modifiers,
            TypeNode type,
            IdentifierNode identifier,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        VariableNode node = factory.makeVariableNode(modifiers, type, identifier, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a VariableNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public VariableNode makeVariableNode(
            TypeNode type,
            IdentifierNode identifier)
    {
        this.before();
        VariableNode node = factory.makeVariableNode(type, identifier);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a VariableNode.
     * The specified start and stop locations are used.
     */
    @Override
    public VariableNode makeVariableNode(
            TypeNode type,
            IdentifierNode identifier,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        VariableNode node = factory.makeVariableNode(type, identifier, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a VoidTypeNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public VoidTypeNode makeVoidTypeNode(
    )
    {
        this.before();
        VoidTypeNode node = factory.makeVoidTypeNode();
        this.after(node);
        return node;
    }
    
    /**
     * Creates a VoidTypeNode.
     * The specified start and stop locations are used.
     */
    @Override
    public VoidTypeNode makeVoidTypeNode(
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        VoidTypeNode node = factory.makeVoidTypeNode(startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a WhileLoopNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public WhileLoopNode makeWhileLoopNodeWithUnions(
            NodeUnion<? extends ExpressionNode> condition,
            NodeUnion<? extends StatementNode> statement,
            NodeUnion<? extends MetaAnnotationListNode> metaAnnotations)
    {
        this.before();
        WhileLoopNode node = factory.makeWhileLoopNodeWithUnions(condition, statement, metaAnnotations);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a WhileLoopNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public WhileLoopNode makeWhileLoopNode(
            ExpressionNode condition,
            StatementNode statement,
            MetaAnnotationListNode metaAnnotations)
    {
        this.before();
        WhileLoopNode node = factory.makeWhileLoopNode(condition, statement, metaAnnotations);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a WhileLoopNode.
     * The specified start and stop locations are used.
     */
    @Override
    public WhileLoopNode makeWhileLoopNodeWithUnions(
            NodeUnion<? extends ExpressionNode> condition,
            NodeUnion<? extends StatementNode> statement,
            NodeUnion<? extends MetaAnnotationListNode> metaAnnotations,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        WhileLoopNode node = factory.makeWhileLoopNodeWithUnions(condition, statement, metaAnnotations, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a WhileLoopNode.
     * The specified start and stop locations are used.
     */
    @Override
    public WhileLoopNode makeWhileLoopNode(
            ExpressionNode condition,
            StatementNode statement,
            MetaAnnotationListNode metaAnnotations,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        WhileLoopNode node = factory.makeWhileLoopNode(condition, statement, metaAnnotations, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a WhileLoopNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public WhileLoopNode makeWhileLoopNode(
            ExpressionNode condition,
            StatementNode statement)
    {
        this.before();
        WhileLoopNode node = factory.makeWhileLoopNode(condition, statement);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a WhileLoopNode.
     * The specified start and stop locations are used.
     */
    @Override
    public WhileLoopNode makeWhileLoopNode(
            ExpressionNode condition,
            StatementNode statement,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        WhileLoopNode node = factory.makeWhileLoopNode(condition, statement, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a WildcardTypeNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public WildcardTypeNode makeWildcardTypeNodeWithUnions(
            NodeUnion<? extends ReferenceTypeNode> bound,
            boolean upperBound)
    {
        this.before();
        WildcardTypeNode node = factory.makeWildcardTypeNodeWithUnions(bound, upperBound);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a WildcardTypeNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public WildcardTypeNode makeWildcardTypeNode(
            ReferenceTypeNode bound,
            boolean upperBound)
    {
        this.before();
        WildcardTypeNode node = factory.makeWildcardTypeNode(bound, upperBound);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a WildcardTypeNode.
     * The specified start and stop locations are used.
     */
    @Override
    public WildcardTypeNode makeWildcardTypeNodeWithUnions(
            NodeUnion<? extends ReferenceTypeNode> bound,
            boolean upperBound,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        WildcardTypeNode node = factory.makeWildcardTypeNodeWithUnions(bound, upperBound, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
    /**
     * Creates a WildcardTypeNode.
     * The specified start and stop locations are used.
     */
    @Override
    public WildcardTypeNode makeWildcardTypeNode(
            ReferenceTypeNode bound,
            boolean upperBound,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        this.before();
        WildcardTypeNode node = factory.makeWildcardTypeNode(bound, upperBound, startLocation, stopLocation);
        this.after(node);
        return node;
    }
    
}
