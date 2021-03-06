/*
 * WARNING: THIS FILE IS GENERATED.  Do not make any changes to this file
 * directly; it was generated from the BSJ source generator project.  If changes
 * are necessary, changes must be applied either to the source generator
 * application or to one of its data files.  The source generator's fully
 * qualified name is edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator.
 */

package edu.jhu.cs.bsj.compiler.impl.ast;

import java.util.ArrayList;
import java.util.Arrays;
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
import edu.jhu.cs.bsj.compiler.impl.ast.delta.EditScriptUtilities;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.create.*;
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

/**
 * This class acts as a BSJ node factory for the standard BSJ compiler.
 * 
 * @author Zachary Palmer
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class BsjNodeFactoryImpl implements BsjNodeFactory
{
	/** The start location to use for new nodes. */
	private BsjSourceLocation startLocation;

	/** The stop location to use for new nodes. */
	private BsjSourceLocation stopLocation;

	/** The node manager to provide to all nodes. */
	private BsjNodeManager manager;

	/** Whether or not to mark created nodes as binary nodes. */
	private boolean binary;

	/**
	 * Creates a new node factory.
	 * 
	 * @param packageNodeCallback The callback module to provide to package nodes to allow them to incite operations
	 *            such as the loading of other compilation units.
	 * @param manager The node manager to provide to all nodes to allow them to obtain and report information to a
	 *            global authority.
	 */
	public BsjNodeFactoryImpl(BsjNodeManager manager)
	{
		this.manager = manager;
		this.binary = false;
	}

	/**
	 * Retrieves the starting source location used for new nodes.
	 * 
	 * @return The start location used for new nodes. <code>null</code> is a permissible value and indicates that no
	 *         information is available.
	 */
	public BsjSourceLocation getStartSourceLocation()
	{
		return this.startLocation;
	}

	/**
	 * Retrieves the ending source location used for new nodes.
	 * 
	 * @return The stop location used for new nodes. <code>null</code> is a permissible value and indicates that no
	 *         information is available.
	 */
	public BsjSourceLocation getStopSourceLocation()
	{
		return this.stopLocation;
	}

	/**
	 * Changes the starting source location used for new nodes.
	 * 
	 * @param startLocation The new start location to use for new nodes. <code>null</code> is a permissible value and
	 *            indicates that no information is available.
	 */
	@Override
	public void setStartSourceLocation(BsjSourceLocation startLocation)
	{
		this.startLocation = startLocation;
	}

	/**
	 * Changes the ending source location used for new nodes.
	 * 
	 * @param stopLocation The new stop location to use for new nodes. <code>null</code> is a permissible value and
	 *            indicates that no information is available.
	 */
	@Override
	public void setStopSourceLocation(BsjSourceLocation stopLocation)
	{
		this.stopLocation = stopLocation;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean getBinary()
	{
		return this.binary;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setBinary(boolean binary)
	{
		this.binary = binary;
	}

	// MANUALLY SPECIFIED MAKE METHODS ///////////////////////////////////////

	/**
	 * {@inheritDoc}
	 */
	public SingleStaticImportNode makeSingleStaticImportNode(QualifiedNameNode name)
	{
		return makeSingleStaticImportNode(name.getBase().deepCopy(this), name.getIdentifier().deepCopy(this));
	}

	/**
	 * {@inheritDoc}
	 */
	public SingleStaticImportNode makeSingleStaticImportNode(QualifiedNameNode name, BsjSourceLocation startLocation,
			BsjSourceLocation stopLocation)
	{
		return makeSingleStaticImportNode(name.getBase().deepCopy(this), name.getIdentifier().deepCopy(this),
				startLocation, stopLocation);
	}

	/**
	 * {@inheritDoc}
	 */
	public NameNode parseNameNode(String name)
	{
		String[] components = name.split("\\.");
		NameNode node = null;
		for (String component : components)
		{
			if (node == null)
			{
				node = makeSimpleNameNode(makeIdentifierNode(component));
			} else
			{
				node = makeQualifiedNameNode(node, makeIdentifierNode(component));
			}
		}
		return node;
	}

	/**
	 * {@inheritDoc}
	 */
	public ArrayTypeNode wrapArrayLevels(TypeNode type, int levels)
	{
		if (levels <= 0)
		{
			throw new IllegalArgumentException("Invalid level count: " + levels);
		}
		ArrayTypeNode ret = makeArrayTypeNode(type);
		for (int i = 1; i < levels; i++)
		{
			ret = makeArrayTypeNode(ret);
		}
		return ret;
	}

	// MAKE METHOD SUPPORT ROUTINES //////////////////////////////////////////

	/**
	 * Wraps a list of nodes in normal unions.
	 * 
	 * @param list The list of nodes.
	 * @return The resulting union list.
	 */
	private <T extends Node> List<NodeUnion<? extends T>> unionWrapList(List<? extends T> nodes)
	{
		List<NodeUnion<? extends T>> list = new ArrayList<NodeUnion<? extends T>>(nodes.size());
		for (T node : nodes)
		{
			list.add(makeNormalNodeUnion(node));
		}
		return list;
	}

	// END MANUALLY WRITTEN CODE /////////////////////////////////////////////
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
    /**
     * Creates a AlternateConstructorInvocationNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public AlternateConstructorInvocationNode makeAlternateConstructorInvocationNodeWithUnions(
            NodeUnion<? extends ExpressionListNode> arguments,
            NodeUnion<? extends ReferenceTypeListNode> typeArguments)
    {
        AlternateConstructorInvocationNode ret = new AlternateConstructorInvocationNodeImpl(arguments, typeArguments, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateAlternateConstructorInvocationNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), arguments == null ? null : (arguments.getNodeValue() == null ? null : arguments.getNodeValue().getUid()), typeArguments == null ? null : (typeArguments.getNodeValue() == null ? null : typeArguments.getNodeValue().getUid()), startLocation, stopLocation));
        }
        return ret;
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
        AlternateConstructorInvocationNode ret = new AlternateConstructorInvocationNodeImpl(this.<ExpressionListNode>makeNormalNodeUnion(arguments), this.<ReferenceTypeListNode>makeNormalNodeUnion(typeArguments), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateAlternateConstructorInvocationNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), arguments == null ? null : arguments.getUid(), typeArguments == null ? null : typeArguments.getUid(), startLocation, stopLocation));
        }
        return ret;
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
        AlternateConstructorInvocationNode ret = new AlternateConstructorInvocationNodeImpl(arguments, typeArguments, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateAlternateConstructorInvocationNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), arguments == null ? null : (arguments.getNodeValue() == null ? null : arguments.getNodeValue().getUid()), typeArguments == null ? null : (typeArguments.getNodeValue() == null ? null : typeArguments.getNodeValue().getUid()), startLocation, stopLocation));
        }
        return ret;
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
        AlternateConstructorInvocationNode ret = new AlternateConstructorInvocationNodeImpl(this.<ExpressionListNode>makeNormalNodeUnion(arguments), this.<ReferenceTypeListNode>makeNormalNodeUnion(typeArguments), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateAlternateConstructorInvocationNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), arguments == null ? null : arguments.getUid(), typeArguments == null ? null : typeArguments.getUid(), startLocation, stopLocation));
        }
        return ret;
    }
    
    /**
     * Creates a AlternateConstructorInvocationNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public AlternateConstructorInvocationNode makeAlternateConstructorInvocationNode(
            ExpressionListNode arguments)
    {
        AlternateConstructorInvocationNode ret = new AlternateConstructorInvocationNodeImpl(this.<ExpressionListNode>makeNormalNodeUnion(arguments), this.<ReferenceTypeListNode>makeNormalNodeUnion(makeReferenceTypeListNode()), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateAlternateConstructorInvocationNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), arguments == null ? null : arguments.getUid(), ret.getTypeArguments() == null ? null : ret.getTypeArguments().getUid(), startLocation, stopLocation));
        }
        return ret;
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
        AlternateConstructorInvocationNode ret = new AlternateConstructorInvocationNodeImpl(this.<ExpressionListNode>makeNormalNodeUnion(arguments), this.<ReferenceTypeListNode>makeNormalNodeUnion(makeReferenceTypeListNode()), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateAlternateConstructorInvocationNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), arguments == null ? null : arguments.getUid(), ret.getTypeArguments() == null ? null : ret.getTypeArguments().getUid(), startLocation, stopLocation));
        }
        return ret;
    }
    
    /**
     * Creates a AnnotationAnnotationValueNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public AnnotationAnnotationValueNode makeAnnotationAnnotationValueNodeWithUnions(
            NodeUnion<? extends AnnotationNode> annotation)
    {
        AnnotationAnnotationValueNode ret = new AnnotationAnnotationValueNodeImpl(annotation, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateAnnotationAnnotationValueNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), annotation == null ? null : (annotation.getNodeValue() == null ? null : annotation.getNodeValue().getUid()), startLocation, stopLocation));
        }
        return ret;
    }
    
    /**
     * Creates a AnnotationAnnotationValueNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public AnnotationAnnotationValueNode makeAnnotationAnnotationValueNode(
            AnnotationNode annotation)
    {
        AnnotationAnnotationValueNode ret = new AnnotationAnnotationValueNodeImpl(this.<AnnotationNode>makeNormalNodeUnion(annotation), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateAnnotationAnnotationValueNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), annotation == null ? null : annotation.getUid(), startLocation, stopLocation));
        }
        return ret;
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
        AnnotationAnnotationValueNode ret = new AnnotationAnnotationValueNodeImpl(annotation, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateAnnotationAnnotationValueNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), annotation == null ? null : (annotation.getNodeValue() == null ? null : annotation.getNodeValue().getUid()), startLocation, stopLocation));
        }
        return ret;
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
        AnnotationAnnotationValueNode ret = new AnnotationAnnotationValueNodeImpl(this.<AnnotationNode>makeNormalNodeUnion(annotation), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateAnnotationAnnotationValueNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), annotation == null ? null : annotation.getUid(), startLocation, stopLocation));
        }
        return ret;
    }
    
    /**
     * Creates a AnnotationArrayValueNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public AnnotationArrayValueNode makeAnnotationArrayValueNodeWithUnions(
            NodeUnion<? extends AnnotationValueListNode> values)
    {
        AnnotationArrayValueNode ret = new AnnotationArrayValueNodeImpl(values, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateAnnotationArrayValueNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), values == null ? null : (values.getNodeValue() == null ? null : values.getNodeValue().getUid()), startLocation, stopLocation));
        }
        return ret;
    }
    
    /**
     * Creates a AnnotationArrayValueNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public AnnotationArrayValueNode makeAnnotationArrayValueNode(
            AnnotationValueListNode values)
    {
        AnnotationArrayValueNode ret = new AnnotationArrayValueNodeImpl(this.<AnnotationValueListNode>makeNormalNodeUnion(values), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateAnnotationArrayValueNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), values == null ? null : values.getUid(), startLocation, stopLocation));
        }
        return ret;
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
        AnnotationArrayValueNode ret = new AnnotationArrayValueNodeImpl(values, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateAnnotationArrayValueNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), values == null ? null : (values.getNodeValue() == null ? null : values.getNodeValue().getUid()), startLocation, stopLocation));
        }
        return ret;
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
        AnnotationArrayValueNode ret = new AnnotationArrayValueNodeImpl(this.<AnnotationValueListNode>makeNormalNodeUnion(values), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateAnnotationArrayValueNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), values == null ? null : values.getUid(), startLocation, stopLocation));
        }
        return ret;
    }
    
    /**
     * Creates a AnnotationBodyNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public AnnotationBodyNode makeAnnotationBodyNodeWithUnions(
            NodeUnion<? extends AnnotationMemberListNode> members)
    {
        AnnotationBodyNode ret = new AnnotationBodyNodeImpl(members, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateAnnotationBodyNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), members == null ? null : (members.getNodeValue() == null ? null : members.getNodeValue().getUid()), startLocation, stopLocation));
        }
        return ret;
    }
    
    /**
     * Creates a AnnotationBodyNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public AnnotationBodyNode makeAnnotationBodyNode(
            AnnotationMemberListNode members)
    {
        AnnotationBodyNode ret = new AnnotationBodyNodeImpl(this.<AnnotationMemberListNode>makeNormalNodeUnion(members), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateAnnotationBodyNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), members == null ? null : members.getUid(), startLocation, stopLocation));
        }
        return ret;
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
        AnnotationBodyNode ret = new AnnotationBodyNodeImpl(members, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateAnnotationBodyNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), members == null ? null : (members.getNodeValue() == null ? null : members.getNodeValue().getUid()), startLocation, stopLocation));
        }
        return ret;
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
        AnnotationBodyNode ret = new AnnotationBodyNodeImpl(this.<AnnotationMemberListNode>makeNormalNodeUnion(members), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateAnnotationBodyNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), members == null ? null : members.getUid(), startLocation, stopLocation));
        }
        return ret;
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
        AnnotationDeclarationNode ret = new AnnotationDeclarationNodeImpl(modifiers, body, identifier, javadoc, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateAnnotationDeclarationNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), modifiers == null ? null : (modifiers.getNodeValue() == null ? null : modifiers.getNodeValue().getUid()), body == null ? null : (body.getNodeValue() == null ? null : body.getNodeValue().getUid()), identifier == null ? null : (identifier.getNodeValue() == null ? null : identifier.getNodeValue().getUid()), javadoc == null ? null : (javadoc.getNodeValue() == null ? null : javadoc.getNodeValue().getUid()), startLocation, stopLocation));
        }
        return ret;
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
        AnnotationDeclarationNode ret = new AnnotationDeclarationNodeImpl(this.<AnnotationModifiersNode>makeNormalNodeUnion(modifiers), this.<AnnotationBodyNode>makeNormalNodeUnion(body), this.<IdentifierNode>makeNormalNodeUnion(identifier), this.<JavadocNode>makeNormalNodeUnion(javadoc), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateAnnotationDeclarationNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), modifiers == null ? null : modifiers.getUid(), body == null ? null : body.getUid(), identifier == null ? null : identifier.getUid(), javadoc == null ? null : javadoc.getUid(), startLocation, stopLocation));
        }
        return ret;
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
        AnnotationDeclarationNode ret = new AnnotationDeclarationNodeImpl(modifiers, body, identifier, javadoc, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateAnnotationDeclarationNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), modifiers == null ? null : (modifiers.getNodeValue() == null ? null : modifiers.getNodeValue().getUid()), body == null ? null : (body.getNodeValue() == null ? null : body.getNodeValue().getUid()), identifier == null ? null : (identifier.getNodeValue() == null ? null : identifier.getNodeValue().getUid()), javadoc == null ? null : (javadoc.getNodeValue() == null ? null : javadoc.getNodeValue().getUid()), startLocation, stopLocation));
        }
        return ret;
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
        AnnotationDeclarationNode ret = new AnnotationDeclarationNodeImpl(this.<AnnotationModifiersNode>makeNormalNodeUnion(modifiers), this.<AnnotationBodyNode>makeNormalNodeUnion(body), this.<IdentifierNode>makeNormalNodeUnion(identifier), this.<JavadocNode>makeNormalNodeUnion(javadoc), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateAnnotationDeclarationNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), modifiers == null ? null : modifiers.getUid(), body == null ? null : body.getUid(), identifier == null ? null : identifier.getUid(), javadoc == null ? null : javadoc.getUid(), startLocation, stopLocation));
        }
        return ret;
    }
    
    /**
     * Creates a AnnotationElementListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public AnnotationElementListNode makeAnnotationElementListNodeWithUnions(
            List<NodeUnion<? extends AnnotationElementNode>> children)
    {
        AnnotationElementListNode ret = new AnnotationElementListNodeImpl(children, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateAnnotationElementListNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), EditScriptUtilities.getNodeUnionUids(children), startLocation, stopLocation));
        }
        return ret;
    }
    
    /**
     * Creates a AnnotationElementListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public AnnotationElementListNode makeAnnotationElementListNode(
            List<AnnotationElementNode> children)
    {
        AnnotationElementListNode ret = new AnnotationElementListNodeImpl(unionWrapList(children), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateAnnotationElementListNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), EditScriptUtilities.getNodeUids(children), startLocation, stopLocation));
        }
        return ret;
    }
    
    /**
     * Creates a AnnotationElementListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public AnnotationElementListNode makeAnnotationElementListNode(
            AnnotationElementNode... childrenElements)
    {
        List<AnnotationElementNode> children = Arrays.asList(childrenElements);
        return makeAnnotationElementListNode(children, startLocation, stopLocation);
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
        AnnotationElementListNode ret = new AnnotationElementListNodeImpl(children, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateAnnotationElementListNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), EditScriptUtilities.getNodeUnionUids(children), startLocation, stopLocation));
        }
        return ret;
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
        AnnotationElementListNode ret = new AnnotationElementListNodeImpl(unionWrapList(children), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateAnnotationElementListNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), EditScriptUtilities.getNodeUids(children), startLocation, stopLocation));
        }
        return ret;
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
        List<AnnotationElementNode> children = Arrays.asList(childrenElements);
        return makeAnnotationElementListNode(children, startLocation, stopLocation);
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
        AnnotationElementNode ret = new AnnotationElementNodeImpl(identifier, value, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateAnnotationElementNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), identifier == null ? null : (identifier.getNodeValue() == null ? null : identifier.getNodeValue().getUid()), value == null ? null : (value.getNodeValue() == null ? null : value.getNodeValue().getUid()), startLocation, stopLocation));
        }
        return ret;
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
        AnnotationElementNode ret = new AnnotationElementNodeImpl(this.<IdentifierNode>makeNormalNodeUnion(identifier), this.<AnnotationValueNode>makeNormalNodeUnion(value), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateAnnotationElementNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), identifier == null ? null : identifier.getUid(), value == null ? null : value.getUid(), startLocation, stopLocation));
        }
        return ret;
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
        AnnotationElementNode ret = new AnnotationElementNodeImpl(identifier, value, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateAnnotationElementNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), identifier == null ? null : (identifier.getNodeValue() == null ? null : identifier.getNodeValue().getUid()), value == null ? null : (value.getNodeValue() == null ? null : value.getNodeValue().getUid()), startLocation, stopLocation));
        }
        return ret;
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
        AnnotationElementNode ret = new AnnotationElementNodeImpl(this.<IdentifierNode>makeNormalNodeUnion(identifier), this.<AnnotationValueNode>makeNormalNodeUnion(value), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateAnnotationElementNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), identifier == null ? null : identifier.getUid(), value == null ? null : value.getUid(), startLocation, stopLocation));
        }
        return ret;
    }
    
    /**
     * Creates a AnnotationExpressionValueNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public AnnotationExpressionValueNode makeAnnotationExpressionValueNodeWithUnions(
            NodeUnion<? extends NonAssignmentExpressionNode> expression)
    {
        AnnotationExpressionValueNode ret = new AnnotationExpressionValueNodeImpl(expression, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateAnnotationExpressionValueNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), expression == null ? null : (expression.getNodeValue() == null ? null : expression.getNodeValue().getUid()), startLocation, stopLocation));
        }
        return ret;
    }
    
    /**
     * Creates a AnnotationExpressionValueNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public AnnotationExpressionValueNode makeAnnotationExpressionValueNode(
            NonAssignmentExpressionNode expression)
    {
        AnnotationExpressionValueNode ret = new AnnotationExpressionValueNodeImpl(this.<NonAssignmentExpressionNode>makeNormalNodeUnion(expression), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateAnnotationExpressionValueNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), expression == null ? null : expression.getUid(), startLocation, stopLocation));
        }
        return ret;
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
        AnnotationExpressionValueNode ret = new AnnotationExpressionValueNodeImpl(expression, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateAnnotationExpressionValueNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), expression == null ? null : (expression.getNodeValue() == null ? null : expression.getNodeValue().getUid()), startLocation, stopLocation));
        }
        return ret;
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
        AnnotationExpressionValueNode ret = new AnnotationExpressionValueNodeImpl(this.<NonAssignmentExpressionNode>makeNormalNodeUnion(expression), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateAnnotationExpressionValueNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), expression == null ? null : expression.getUid(), startLocation, stopLocation));
        }
        return ret;
    }
    
    /**
     * Creates a AnnotationListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public AnnotationListNode makeAnnotationListNodeWithUnions(
            List<NodeUnion<? extends AnnotationNode>> children)
    {
        AnnotationListNode ret = new AnnotationListNodeImpl(children, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateAnnotationListNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), EditScriptUtilities.getNodeUnionUids(children), startLocation, stopLocation));
        }
        return ret;
    }
    
    /**
     * Creates a AnnotationListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public AnnotationListNode makeAnnotationListNode(
            List<AnnotationNode> children)
    {
        AnnotationListNode ret = new AnnotationListNodeImpl(unionWrapList(children), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateAnnotationListNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), EditScriptUtilities.getNodeUids(children), startLocation, stopLocation));
        }
        return ret;
    }
    
    /**
     * Creates a AnnotationListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public AnnotationListNode makeAnnotationListNode(
            AnnotationNode... childrenElements)
    {
        List<AnnotationNode> children = Arrays.asList(childrenElements);
        return makeAnnotationListNode(children, startLocation, stopLocation);
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
        AnnotationListNode ret = new AnnotationListNodeImpl(children, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateAnnotationListNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), EditScriptUtilities.getNodeUnionUids(children), startLocation, stopLocation));
        }
        return ret;
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
        AnnotationListNode ret = new AnnotationListNodeImpl(unionWrapList(children), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateAnnotationListNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), EditScriptUtilities.getNodeUids(children), startLocation, stopLocation));
        }
        return ret;
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
        List<AnnotationNode> children = Arrays.asList(childrenElements);
        return makeAnnotationListNode(children, startLocation, stopLocation);
    }
    
    /**
     * Creates a AnnotationMemberListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public AnnotationMemberListNode makeAnnotationMemberListNodeWithUnions(
            List<NodeUnion<? extends AnnotationMemberNode>> children)
    {
        AnnotationMemberListNode ret = new AnnotationMemberListNodeImpl(children, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateAnnotationMemberListNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), EditScriptUtilities.getNodeUnionUids(children), startLocation, stopLocation));
        }
        return ret;
    }
    
    /**
     * Creates a AnnotationMemberListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public AnnotationMemberListNode makeAnnotationMemberListNode(
            List<AnnotationMemberNode> children)
    {
        AnnotationMemberListNode ret = new AnnotationMemberListNodeImpl(unionWrapList(children), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateAnnotationMemberListNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), EditScriptUtilities.getNodeUids(children), startLocation, stopLocation));
        }
        return ret;
    }
    
    /**
     * Creates a AnnotationMemberListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public AnnotationMemberListNode makeAnnotationMemberListNode(
            AnnotationMemberNode... childrenElements)
    {
        List<AnnotationMemberNode> children = Arrays.asList(childrenElements);
        return makeAnnotationMemberListNode(children, startLocation, stopLocation);
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
        AnnotationMemberListNode ret = new AnnotationMemberListNodeImpl(children, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateAnnotationMemberListNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), EditScriptUtilities.getNodeUnionUids(children), startLocation, stopLocation));
        }
        return ret;
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
        AnnotationMemberListNode ret = new AnnotationMemberListNodeImpl(unionWrapList(children), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateAnnotationMemberListNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), EditScriptUtilities.getNodeUids(children), startLocation, stopLocation));
        }
        return ret;
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
        List<AnnotationMemberNode> children = Arrays.asList(childrenElements);
        return makeAnnotationMemberListNode(children, startLocation, stopLocation);
    }
    
    /**
     * Creates a AnnotationMemberMetaprogramAnchorNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public AnnotationMemberMetaprogramAnchorNode makeAnnotationMemberMetaprogramAnchorNodeWithUnions(
            NodeUnion<? extends MetaprogramNode> metaprogram)
    {
        AnnotationMemberMetaprogramAnchorNode ret = new AnnotationMemberMetaprogramAnchorNodeImpl(metaprogram, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateAnnotationMemberMetaprogramAnchorNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), metaprogram == null ? null : (metaprogram.getNodeValue() == null ? null : metaprogram.getNodeValue().getUid()), startLocation, stopLocation));
        }
        return ret;
    }
    
    /**
     * Creates a AnnotationMemberMetaprogramAnchorNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public AnnotationMemberMetaprogramAnchorNode makeAnnotationMemberMetaprogramAnchorNode(
            MetaprogramNode metaprogram)
    {
        AnnotationMemberMetaprogramAnchorNode ret = new AnnotationMemberMetaprogramAnchorNodeImpl(this.<MetaprogramNode>makeNormalNodeUnion(metaprogram), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateAnnotationMemberMetaprogramAnchorNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), metaprogram == null ? null : metaprogram.getUid(), startLocation, stopLocation));
        }
        return ret;
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
        AnnotationMemberMetaprogramAnchorNode ret = new AnnotationMemberMetaprogramAnchorNodeImpl(metaprogram, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateAnnotationMemberMetaprogramAnchorNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), metaprogram == null ? null : (metaprogram.getNodeValue() == null ? null : metaprogram.getNodeValue().getUid()), startLocation, stopLocation));
        }
        return ret;
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
        AnnotationMemberMetaprogramAnchorNode ret = new AnnotationMemberMetaprogramAnchorNodeImpl(this.<MetaprogramNode>makeNormalNodeUnion(metaprogram), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateAnnotationMemberMetaprogramAnchorNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), metaprogram == null ? null : metaprogram.getUid(), startLocation, stopLocation));
        }
        return ret;
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
        AnnotationMethodDeclarationNode ret = new AnnotationMethodDeclarationNodeImpl(modifiers, type, identifier, defaultValue, javadoc, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateAnnotationMethodDeclarationNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), modifiers == null ? null : (modifiers.getNodeValue() == null ? null : modifiers.getNodeValue().getUid()), type == null ? null : (type.getNodeValue() == null ? null : type.getNodeValue().getUid()), identifier == null ? null : (identifier.getNodeValue() == null ? null : identifier.getNodeValue().getUid()), defaultValue == null ? null : (defaultValue.getNodeValue() == null ? null : defaultValue.getNodeValue().getUid()), javadoc == null ? null : (javadoc.getNodeValue() == null ? null : javadoc.getNodeValue().getUid()), startLocation, stopLocation));
        }
        return ret;
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
        AnnotationMethodDeclarationNode ret = new AnnotationMethodDeclarationNodeImpl(this.<AnnotationMethodModifiersNode>makeNormalNodeUnion(modifiers), this.<TypeNode>makeNormalNodeUnion(type), this.<IdentifierNode>makeNormalNodeUnion(identifier), this.<AnnotationValueNode>makeNormalNodeUnion(defaultValue), this.<JavadocNode>makeNormalNodeUnion(javadoc), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateAnnotationMethodDeclarationNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), modifiers == null ? null : modifiers.getUid(), type == null ? null : type.getUid(), identifier == null ? null : identifier.getUid(), defaultValue == null ? null : defaultValue.getUid(), javadoc == null ? null : javadoc.getUid(), startLocation, stopLocation));
        }
        return ret;
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
        AnnotationMethodDeclarationNode ret = new AnnotationMethodDeclarationNodeImpl(modifiers, type, identifier, defaultValue, javadoc, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateAnnotationMethodDeclarationNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), modifiers == null ? null : (modifiers.getNodeValue() == null ? null : modifiers.getNodeValue().getUid()), type == null ? null : (type.getNodeValue() == null ? null : type.getNodeValue().getUid()), identifier == null ? null : (identifier.getNodeValue() == null ? null : identifier.getNodeValue().getUid()), defaultValue == null ? null : (defaultValue.getNodeValue() == null ? null : defaultValue.getNodeValue().getUid()), javadoc == null ? null : (javadoc.getNodeValue() == null ? null : javadoc.getNodeValue().getUid()), startLocation, stopLocation));
        }
        return ret;
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
        AnnotationMethodDeclarationNode ret = new AnnotationMethodDeclarationNodeImpl(this.<AnnotationMethodModifiersNode>makeNormalNodeUnion(modifiers), this.<TypeNode>makeNormalNodeUnion(type), this.<IdentifierNode>makeNormalNodeUnion(identifier), this.<AnnotationValueNode>makeNormalNodeUnion(defaultValue), this.<JavadocNode>makeNormalNodeUnion(javadoc), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateAnnotationMethodDeclarationNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), modifiers == null ? null : modifiers.getUid(), type == null ? null : type.getUid(), identifier == null ? null : identifier.getUid(), defaultValue == null ? null : defaultValue.getUid(), javadoc == null ? null : javadoc.getUid(), startLocation, stopLocation));
        }
        return ret;
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
        AnnotationMethodModifiersNode ret = new AnnotationMethodModifiersNodeImpl(metaAnnotations, annotations, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateAnnotationMethodModifiersNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), metaAnnotations == null ? null : (metaAnnotations.getNodeValue() == null ? null : metaAnnotations.getNodeValue().getUid()), annotations == null ? null : (annotations.getNodeValue() == null ? null : annotations.getNodeValue().getUid()), startLocation, stopLocation));
        }
        return ret;
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
        AnnotationMethodModifiersNode ret = new AnnotationMethodModifiersNodeImpl(this.<MetaAnnotationListNode>makeNormalNodeUnion(metaAnnotations), this.<AnnotationListNode>makeNormalNodeUnion(annotations), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateAnnotationMethodModifiersNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), metaAnnotations == null ? null : metaAnnotations.getUid(), annotations == null ? null : annotations.getUid(), startLocation, stopLocation));
        }
        return ret;
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
        AnnotationMethodModifiersNode ret = new AnnotationMethodModifiersNodeImpl(metaAnnotations, annotations, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateAnnotationMethodModifiersNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), metaAnnotations == null ? null : (metaAnnotations.getNodeValue() == null ? null : metaAnnotations.getNodeValue().getUid()), annotations == null ? null : (annotations.getNodeValue() == null ? null : annotations.getNodeValue().getUid()), startLocation, stopLocation));
        }
        return ret;
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
        AnnotationMethodModifiersNode ret = new AnnotationMethodModifiersNodeImpl(this.<MetaAnnotationListNode>makeNormalNodeUnion(metaAnnotations), this.<AnnotationListNode>makeNormalNodeUnion(annotations), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateAnnotationMethodModifiersNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), metaAnnotations == null ? null : metaAnnotations.getUid(), annotations == null ? null : annotations.getUid(), startLocation, stopLocation));
        }
        return ret;
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
        AnnotationModifiersNode ret = new AnnotationModifiersNodeImpl(access, staticFlag, strictfpFlag, metaAnnotations, annotations, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateAnnotationModifiersNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), access, staticFlag, strictfpFlag, metaAnnotations == null ? null : (metaAnnotations.getNodeValue() == null ? null : metaAnnotations.getNodeValue().getUid()), annotations == null ? null : (annotations.getNodeValue() == null ? null : annotations.getNodeValue().getUid()), startLocation, stopLocation));
        }
        return ret;
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
        AnnotationModifiersNode ret = new AnnotationModifiersNodeImpl(access, staticFlag, strictfpFlag, this.<MetaAnnotationListNode>makeNormalNodeUnion(metaAnnotations), this.<AnnotationListNode>makeNormalNodeUnion(annotations), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateAnnotationModifiersNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), access, staticFlag, strictfpFlag, metaAnnotations == null ? null : metaAnnotations.getUid(), annotations == null ? null : annotations.getUid(), startLocation, stopLocation));
        }
        return ret;
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
        AnnotationModifiersNode ret = new AnnotationModifiersNodeImpl(access, staticFlag, strictfpFlag, metaAnnotations, annotations, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateAnnotationModifiersNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), access, staticFlag, strictfpFlag, metaAnnotations == null ? null : (metaAnnotations.getNodeValue() == null ? null : metaAnnotations.getNodeValue().getUid()), annotations == null ? null : (annotations.getNodeValue() == null ? null : annotations.getNodeValue().getUid()), startLocation, stopLocation));
        }
        return ret;
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
        AnnotationModifiersNode ret = new AnnotationModifiersNodeImpl(access, staticFlag, strictfpFlag, this.<MetaAnnotationListNode>makeNormalNodeUnion(metaAnnotations), this.<AnnotationListNode>makeNormalNodeUnion(annotations), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateAnnotationModifiersNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), access, staticFlag, strictfpFlag, metaAnnotations == null ? null : metaAnnotations.getUid(), annotations == null ? null : annotations.getUid(), startLocation, stopLocation));
        }
        return ret;
    }
    
    /**
     * Creates a AnnotationModifiersNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public AnnotationModifiersNode makeAnnotationModifiersNode(
            AccessModifier access)
    {
        AnnotationModifiersNode ret = new AnnotationModifiersNodeImpl(access, false, false, this.<MetaAnnotationListNode>makeNormalNodeUnion(makeMetaAnnotationListNode()), this.<AnnotationListNode>makeNormalNodeUnion(makeAnnotationListNode()), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateAnnotationModifiersNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), access, ret.getStaticFlag(), ret.getStrictfpFlag(), ret.getMetaAnnotations() == null ? null : ret.getMetaAnnotations().getUid(), ret.getAnnotations() == null ? null : ret.getAnnotations().getUid(), startLocation, stopLocation));
        }
        return ret;
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
        AnnotationModifiersNode ret = new AnnotationModifiersNodeImpl(access, false, false, this.<MetaAnnotationListNode>makeNormalNodeUnion(makeMetaAnnotationListNode()), this.<AnnotationListNode>makeNormalNodeUnion(makeAnnotationListNode()), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateAnnotationModifiersNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), access, ret.getStaticFlag(), ret.getStrictfpFlag(), ret.getMetaAnnotations() == null ? null : ret.getMetaAnnotations().getUid(), ret.getAnnotations() == null ? null : ret.getAnnotations().getUid(), startLocation, stopLocation));
        }
        return ret;
    }
    
    /**
     * Creates a AnnotationValueListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public AnnotationValueListNode makeAnnotationValueListNodeWithUnions(
            List<NodeUnion<? extends AnnotationValueNode>> children)
    {
        AnnotationValueListNode ret = new AnnotationValueListNodeImpl(children, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateAnnotationValueListNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), EditScriptUtilities.getNodeUnionUids(children), startLocation, stopLocation));
        }
        return ret;
    }
    
    /**
     * Creates a AnnotationValueListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public AnnotationValueListNode makeAnnotationValueListNode(
            List<AnnotationValueNode> children)
    {
        AnnotationValueListNode ret = new AnnotationValueListNodeImpl(unionWrapList(children), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateAnnotationValueListNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), EditScriptUtilities.getNodeUids(children), startLocation, stopLocation));
        }
        return ret;
    }
    
    /**
     * Creates a AnnotationValueListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public AnnotationValueListNode makeAnnotationValueListNode(
            AnnotationValueNode... childrenElements)
    {
        List<AnnotationValueNode> children = Arrays.asList(childrenElements);
        return makeAnnotationValueListNode(children, startLocation, stopLocation);
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
        AnnotationValueListNode ret = new AnnotationValueListNodeImpl(children, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateAnnotationValueListNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), EditScriptUtilities.getNodeUnionUids(children), startLocation, stopLocation));
        }
        return ret;
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
        AnnotationValueListNode ret = new AnnotationValueListNodeImpl(unionWrapList(children), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateAnnotationValueListNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), EditScriptUtilities.getNodeUids(children), startLocation, stopLocation));
        }
        return ret;
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
        List<AnnotationValueNode> children = Arrays.asList(childrenElements);
        return makeAnnotationValueListNode(children, startLocation, stopLocation);
    }
    
    /**
     * Creates a AnonymousClassBodyNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public AnonymousClassBodyNode makeAnonymousClassBodyNodeWithUnions(
            NodeUnion<? extends AnonymousClassMemberListNode> members)
    {
        AnonymousClassBodyNode ret = new AnonymousClassBodyNodeImpl(members, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateAnonymousClassBodyNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), members == null ? null : (members.getNodeValue() == null ? null : members.getNodeValue().getUid()), startLocation, stopLocation));
        }
        return ret;
    }
    
    /**
     * Creates a AnonymousClassBodyNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public AnonymousClassBodyNode makeAnonymousClassBodyNode(
            AnonymousClassMemberListNode members)
    {
        AnonymousClassBodyNode ret = new AnonymousClassBodyNodeImpl(this.<AnonymousClassMemberListNode>makeNormalNodeUnion(members), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateAnonymousClassBodyNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), members == null ? null : members.getUid(), startLocation, stopLocation));
        }
        return ret;
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
        AnonymousClassBodyNode ret = new AnonymousClassBodyNodeImpl(members, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateAnonymousClassBodyNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), members == null ? null : (members.getNodeValue() == null ? null : members.getNodeValue().getUid()), startLocation, stopLocation));
        }
        return ret;
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
        AnonymousClassBodyNode ret = new AnonymousClassBodyNodeImpl(this.<AnonymousClassMemberListNode>makeNormalNodeUnion(members), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateAnonymousClassBodyNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), members == null ? null : members.getUid(), startLocation, stopLocation));
        }
        return ret;
    }
    
    /**
     * Creates a AnonymousClassMemberListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public AnonymousClassMemberListNode makeAnonymousClassMemberListNodeWithUnions(
            List<NodeUnion<? extends AnonymousClassMemberNode>> children)
    {
        AnonymousClassMemberListNode ret = new AnonymousClassMemberListNodeImpl(children, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateAnonymousClassMemberListNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), EditScriptUtilities.getNodeUnionUids(children), startLocation, stopLocation));
        }
        return ret;
    }
    
    /**
     * Creates a AnonymousClassMemberListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public AnonymousClassMemberListNode makeAnonymousClassMemberListNode(
            List<AnonymousClassMemberNode> children)
    {
        AnonymousClassMemberListNode ret = new AnonymousClassMemberListNodeImpl(unionWrapList(children), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateAnonymousClassMemberListNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), EditScriptUtilities.getNodeUids(children), startLocation, stopLocation));
        }
        return ret;
    }
    
    /**
     * Creates a AnonymousClassMemberListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public AnonymousClassMemberListNode makeAnonymousClassMemberListNode(
            AnonymousClassMemberNode... childrenElements)
    {
        List<AnonymousClassMemberNode> children = Arrays.asList(childrenElements);
        return makeAnonymousClassMemberListNode(children, startLocation, stopLocation);
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
        AnonymousClassMemberListNode ret = new AnonymousClassMemberListNodeImpl(children, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateAnonymousClassMemberListNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), EditScriptUtilities.getNodeUnionUids(children), startLocation, stopLocation));
        }
        return ret;
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
        AnonymousClassMemberListNode ret = new AnonymousClassMemberListNodeImpl(unionWrapList(children), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateAnonymousClassMemberListNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), EditScriptUtilities.getNodeUids(children), startLocation, stopLocation));
        }
        return ret;
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
        List<AnonymousClassMemberNode> children = Arrays.asList(childrenElements);
        return makeAnonymousClassMemberListNode(children, startLocation, stopLocation);
    }
    
    /**
     * Creates a AnonymousClassMemberMetaprogramAnchorNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public AnonymousClassMemberMetaprogramAnchorNode makeAnonymousClassMemberMetaprogramAnchorNodeWithUnions(
            NodeUnion<? extends MetaprogramNode> metaprogram)
    {
        AnonymousClassMemberMetaprogramAnchorNode ret = new AnonymousClassMemberMetaprogramAnchorNodeImpl(metaprogram, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateAnonymousClassMemberMetaprogramAnchorNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), metaprogram == null ? null : (metaprogram.getNodeValue() == null ? null : metaprogram.getNodeValue().getUid()), startLocation, stopLocation));
        }
        return ret;
    }
    
    /**
     * Creates a AnonymousClassMemberMetaprogramAnchorNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public AnonymousClassMemberMetaprogramAnchorNode makeAnonymousClassMemberMetaprogramAnchorNode(
            MetaprogramNode metaprogram)
    {
        AnonymousClassMemberMetaprogramAnchorNode ret = new AnonymousClassMemberMetaprogramAnchorNodeImpl(this.<MetaprogramNode>makeNormalNodeUnion(metaprogram), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateAnonymousClassMemberMetaprogramAnchorNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), metaprogram == null ? null : metaprogram.getUid(), startLocation, stopLocation));
        }
        return ret;
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
        AnonymousClassMemberMetaprogramAnchorNode ret = new AnonymousClassMemberMetaprogramAnchorNodeImpl(metaprogram, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateAnonymousClassMemberMetaprogramAnchorNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), metaprogram == null ? null : (metaprogram.getNodeValue() == null ? null : metaprogram.getNodeValue().getUid()), startLocation, stopLocation));
        }
        return ret;
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
        AnonymousClassMemberMetaprogramAnchorNode ret = new AnonymousClassMemberMetaprogramAnchorNodeImpl(this.<MetaprogramNode>makeNormalNodeUnion(metaprogram), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateAnonymousClassMemberMetaprogramAnchorNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), metaprogram == null ? null : metaprogram.getUid(), startLocation, stopLocation));
        }
        return ret;
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
        ArrayAccessNode ret = new ArrayAccessNodeImpl(arrayExpression, indexExpression, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateArrayAccessNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), arrayExpression == null ? null : (arrayExpression.getNodeValue() == null ? null : arrayExpression.getNodeValue().getUid()), indexExpression == null ? null : (indexExpression.getNodeValue() == null ? null : indexExpression.getNodeValue().getUid()), startLocation, stopLocation));
        }
        return ret;
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
        ArrayAccessNode ret = new ArrayAccessNodeImpl(this.<RestrictedPrimaryExpressionNode>makeNormalNodeUnion(arrayExpression), this.<ExpressionNode>makeNormalNodeUnion(indexExpression), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateArrayAccessNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), arrayExpression == null ? null : arrayExpression.getUid(), indexExpression == null ? null : indexExpression.getUid(), startLocation, stopLocation));
        }
        return ret;
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
        ArrayAccessNode ret = new ArrayAccessNodeImpl(arrayExpression, indexExpression, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateArrayAccessNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), arrayExpression == null ? null : (arrayExpression.getNodeValue() == null ? null : arrayExpression.getNodeValue().getUid()), indexExpression == null ? null : (indexExpression.getNodeValue() == null ? null : indexExpression.getNodeValue().getUid()), startLocation, stopLocation));
        }
        return ret;
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
        ArrayAccessNode ret = new ArrayAccessNodeImpl(this.<RestrictedPrimaryExpressionNode>makeNormalNodeUnion(arrayExpression), this.<ExpressionNode>makeNormalNodeUnion(indexExpression), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateArrayAccessNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), arrayExpression == null ? null : arrayExpression.getUid(), indexExpression == null ? null : indexExpression.getUid(), startLocation, stopLocation));
        }
        return ret;
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
        ArrayInitializerCreationNode ret = new ArrayInitializerCreationNodeImpl(initializer, baseType, arrayLevels, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateArrayInitializerCreationNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), initializer == null ? null : (initializer.getNodeValue() == null ? null : initializer.getNodeValue().getUid()), baseType == null ? null : (baseType.getNodeValue() == null ? null : baseType.getNodeValue().getUid()), arrayLevels, startLocation, stopLocation));
        }
        return ret;
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
        ArrayInitializerCreationNode ret = new ArrayInitializerCreationNodeImpl(this.<ArrayInitializerNode>makeNormalNodeUnion(initializer), this.<BaseTypeNode>makeNormalNodeUnion(baseType), arrayLevels, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateArrayInitializerCreationNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), initializer == null ? null : initializer.getUid(), baseType == null ? null : baseType.getUid(), arrayLevels, startLocation, stopLocation));
        }
        return ret;
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
        ArrayInitializerCreationNode ret = new ArrayInitializerCreationNodeImpl(initializer, baseType, arrayLevels, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateArrayInitializerCreationNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), initializer == null ? null : (initializer.getNodeValue() == null ? null : initializer.getNodeValue().getUid()), baseType == null ? null : (baseType.getNodeValue() == null ? null : baseType.getNodeValue().getUid()), arrayLevels, startLocation, stopLocation));
        }
        return ret;
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
        ArrayInitializerCreationNode ret = new ArrayInitializerCreationNodeImpl(this.<ArrayInitializerNode>makeNormalNodeUnion(initializer), this.<BaseTypeNode>makeNormalNodeUnion(baseType), arrayLevels, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateArrayInitializerCreationNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), initializer == null ? null : initializer.getUid(), baseType == null ? null : baseType.getUid(), arrayLevels, startLocation, stopLocation));
        }
        return ret;
    }
    
    /**
     * Creates a ArrayInitializerNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public ArrayInitializerNode makeArrayInitializerNodeWithUnions(
            NodeUnion<? extends VariableInitializerListNode> initializers)
    {
        ArrayInitializerNode ret = new ArrayInitializerNodeImpl(initializers, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateArrayInitializerNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), initializers == null ? null : (initializers.getNodeValue() == null ? null : initializers.getNodeValue().getUid()), startLocation, stopLocation));
        }
        return ret;
    }
    
    /**
     * Creates a ArrayInitializerNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public ArrayInitializerNode makeArrayInitializerNode(
            VariableInitializerListNode initializers)
    {
        ArrayInitializerNode ret = new ArrayInitializerNodeImpl(this.<VariableInitializerListNode>makeNormalNodeUnion(initializers), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateArrayInitializerNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), initializers == null ? null : initializers.getUid(), startLocation, stopLocation));
        }
        return ret;
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
        ArrayInitializerNode ret = new ArrayInitializerNodeImpl(initializers, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateArrayInitializerNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), initializers == null ? null : (initializers.getNodeValue() == null ? null : initializers.getNodeValue().getUid()), startLocation, stopLocation));
        }
        return ret;
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
        ArrayInitializerNode ret = new ArrayInitializerNodeImpl(this.<VariableInitializerListNode>makeNormalNodeUnion(initializers), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateArrayInitializerNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), initializers == null ? null : initializers.getUid(), startLocation, stopLocation));
        }
        return ret;
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
        ArrayInstantiatorCreationNode ret = new ArrayInstantiatorCreationNodeImpl(dimExpressions, baseType, arrayLevels, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateArrayInstantiatorCreationNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), dimExpressions == null ? null : (dimExpressions.getNodeValue() == null ? null : dimExpressions.getNodeValue().getUid()), baseType == null ? null : (baseType.getNodeValue() == null ? null : baseType.getNodeValue().getUid()), arrayLevels, startLocation, stopLocation));
        }
        return ret;
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
        ArrayInstantiatorCreationNode ret = new ArrayInstantiatorCreationNodeImpl(this.<ExpressionListNode>makeNormalNodeUnion(dimExpressions), this.<BaseTypeNode>makeNormalNodeUnion(baseType), arrayLevels, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateArrayInstantiatorCreationNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), dimExpressions == null ? null : dimExpressions.getUid(), baseType == null ? null : baseType.getUid(), arrayLevels, startLocation, stopLocation));
        }
        return ret;
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
        ArrayInstantiatorCreationNode ret = new ArrayInstantiatorCreationNodeImpl(dimExpressions, baseType, arrayLevels, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateArrayInstantiatorCreationNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), dimExpressions == null ? null : (dimExpressions.getNodeValue() == null ? null : dimExpressions.getNodeValue().getUid()), baseType == null ? null : (baseType.getNodeValue() == null ? null : baseType.getNodeValue().getUid()), arrayLevels, startLocation, stopLocation));
        }
        return ret;
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
        ArrayInstantiatorCreationNode ret = new ArrayInstantiatorCreationNodeImpl(this.<ExpressionListNode>makeNormalNodeUnion(dimExpressions), this.<BaseTypeNode>makeNormalNodeUnion(baseType), arrayLevels, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateArrayInstantiatorCreationNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), dimExpressions == null ? null : dimExpressions.getUid(), baseType == null ? null : baseType.getUid(), arrayLevels, startLocation, stopLocation));
        }
        return ret;
    }
    
    /**
     * Creates a ArrayTypeNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public ArrayTypeNode makeArrayTypeNodeWithUnions(
            NodeUnion<? extends TypeNode> type)
    {
        ArrayTypeNode ret = new ArrayTypeNodeImpl(type, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateArrayTypeNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), type == null ? null : (type.getNodeValue() == null ? null : type.getNodeValue().getUid()), startLocation, stopLocation));
        }
        return ret;
    }
    
    /**
     * Creates a ArrayTypeNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public ArrayTypeNode makeArrayTypeNode(
            TypeNode type)
    {
        ArrayTypeNode ret = new ArrayTypeNodeImpl(this.<TypeNode>makeNormalNodeUnion(type), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateArrayTypeNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), type == null ? null : type.getUid(), startLocation, stopLocation));
        }
        return ret;
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
        ArrayTypeNode ret = new ArrayTypeNodeImpl(type, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateArrayTypeNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), type == null ? null : (type.getNodeValue() == null ? null : type.getNodeValue().getUid()), startLocation, stopLocation));
        }
        return ret;
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
        ArrayTypeNode ret = new ArrayTypeNodeImpl(this.<TypeNode>makeNormalNodeUnion(type), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateArrayTypeNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), type == null ? null : type.getUid(), startLocation, stopLocation));
        }
        return ret;
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
        AssertStatementNode ret = new AssertStatementNodeImpl(testExpression, messageExpression, metaAnnotations, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateAssertStatementNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), testExpression == null ? null : (testExpression.getNodeValue() == null ? null : testExpression.getNodeValue().getUid()), messageExpression == null ? null : (messageExpression.getNodeValue() == null ? null : messageExpression.getNodeValue().getUid()), metaAnnotations == null ? null : (metaAnnotations.getNodeValue() == null ? null : metaAnnotations.getNodeValue().getUid()), startLocation, stopLocation));
        }
        return ret;
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
        AssertStatementNode ret = new AssertStatementNodeImpl(this.<ExpressionNode>makeNormalNodeUnion(testExpression), this.<ExpressionNode>makeNormalNodeUnion(messageExpression), this.<MetaAnnotationListNode>makeNormalNodeUnion(metaAnnotations), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateAssertStatementNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), testExpression == null ? null : testExpression.getUid(), messageExpression == null ? null : messageExpression.getUid(), metaAnnotations == null ? null : metaAnnotations.getUid(), startLocation, stopLocation));
        }
        return ret;
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
        AssertStatementNode ret = new AssertStatementNodeImpl(testExpression, messageExpression, metaAnnotations, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateAssertStatementNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), testExpression == null ? null : (testExpression.getNodeValue() == null ? null : testExpression.getNodeValue().getUid()), messageExpression == null ? null : (messageExpression.getNodeValue() == null ? null : messageExpression.getNodeValue().getUid()), metaAnnotations == null ? null : (metaAnnotations.getNodeValue() == null ? null : metaAnnotations.getNodeValue().getUid()), startLocation, stopLocation));
        }
        return ret;
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
        AssertStatementNode ret = new AssertStatementNodeImpl(this.<ExpressionNode>makeNormalNodeUnion(testExpression), this.<ExpressionNode>makeNormalNodeUnion(messageExpression), this.<MetaAnnotationListNode>makeNormalNodeUnion(metaAnnotations), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateAssertStatementNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), testExpression == null ? null : testExpression.getUid(), messageExpression == null ? null : messageExpression.getUid(), metaAnnotations == null ? null : metaAnnotations.getUid(), startLocation, stopLocation));
        }
        return ret;
    }
    
    /**
     * Creates a AssertStatementNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public AssertStatementNode makeAssertStatementNode(
            ExpressionNode testExpression)
    {
        AssertStatementNode ret = new AssertStatementNodeImpl(this.<ExpressionNode>makeNormalNodeUnion(testExpression), this.<ExpressionNode>makeNormalNodeUnion(null), this.<MetaAnnotationListNode>makeNormalNodeUnion(makeMetaAnnotationListNode()), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateAssertStatementNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), testExpression == null ? null : testExpression.getUid(), ret.getMessageExpression() == null ? null : ret.getMessageExpression().getUid(), ret.getMetaAnnotations() == null ? null : ret.getMetaAnnotations().getUid(), startLocation, stopLocation));
        }
        return ret;
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
        AssertStatementNode ret = new AssertStatementNodeImpl(this.<ExpressionNode>makeNormalNodeUnion(testExpression), this.<ExpressionNode>makeNormalNodeUnion(null), this.<MetaAnnotationListNode>makeNormalNodeUnion(makeMetaAnnotationListNode()), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateAssertStatementNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), testExpression == null ? null : testExpression.getUid(), ret.getMessageExpression() == null ? null : ret.getMessageExpression().getUid(), ret.getMetaAnnotations() == null ? null : ret.getMetaAnnotations().getUid(), startLocation, stopLocation));
        }
        return ret;
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
        AssertStatementNode ret = new AssertStatementNodeImpl(this.<ExpressionNode>makeNormalNodeUnion(testExpression), this.<ExpressionNode>makeNormalNodeUnion(messageExpression), this.<MetaAnnotationListNode>makeNormalNodeUnion(makeMetaAnnotationListNode()), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateAssertStatementNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), testExpression == null ? null : testExpression.getUid(), messageExpression == null ? null : messageExpression.getUid(), ret.getMetaAnnotations() == null ? null : ret.getMetaAnnotations().getUid(), startLocation, stopLocation));
        }
        return ret;
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
        AssertStatementNode ret = new AssertStatementNodeImpl(this.<ExpressionNode>makeNormalNodeUnion(testExpression), this.<ExpressionNode>makeNormalNodeUnion(messageExpression), this.<MetaAnnotationListNode>makeNormalNodeUnion(makeMetaAnnotationListNode()), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateAssertStatementNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), testExpression == null ? null : testExpression.getUid(), messageExpression == null ? null : messageExpression.getUid(), ret.getMetaAnnotations() == null ? null : ret.getMetaAnnotations().getUid(), startLocation, stopLocation));
        }
        return ret;
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
        AssignmentNode ret = new AssignmentNodeImpl(variable, operator, expression, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateAssignmentNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), variable == null ? null : (variable.getNodeValue() == null ? null : variable.getNodeValue().getUid()), operator, expression == null ? null : (expression.getNodeValue() == null ? null : expression.getNodeValue().getUid()), startLocation, stopLocation));
        }
        return ret;
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
        AssignmentNode ret = new AssignmentNodeImpl(this.<ExpressionNode>makeNormalNodeUnion(variable), operator, this.<ExpressionNode>makeNormalNodeUnion(expression), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateAssignmentNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), variable == null ? null : variable.getUid(), operator, expression == null ? null : expression.getUid(), startLocation, stopLocation));
        }
        return ret;
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
        AssignmentNode ret = new AssignmentNodeImpl(variable, operator, expression, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateAssignmentNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), variable == null ? null : (variable.getNodeValue() == null ? null : variable.getNodeValue().getUid()), operator, expression == null ? null : (expression.getNodeValue() == null ? null : expression.getNodeValue().getUid()), startLocation, stopLocation));
        }
        return ret;
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
        AssignmentNode ret = new AssignmentNodeImpl(this.<ExpressionNode>makeNormalNodeUnion(variable), operator, this.<ExpressionNode>makeNormalNodeUnion(expression), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateAssignmentNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), variable == null ? null : variable.getUid(), operator, expression == null ? null : expression.getUid(), startLocation, stopLocation));
        }
        return ret;
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
        BinaryExpressionNode ret = new BinaryExpressionNodeImpl(leftOperand, rightOperand, operator, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateBinaryExpressionNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), leftOperand == null ? null : (leftOperand.getNodeValue() == null ? null : leftOperand.getNodeValue().getUid()), rightOperand == null ? null : (rightOperand.getNodeValue() == null ? null : rightOperand.getNodeValue().getUid()), operator, startLocation, stopLocation));
        }
        return ret;
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
        BinaryExpressionNode ret = new BinaryExpressionNodeImpl(this.<ExpressionNode>makeNormalNodeUnion(leftOperand), this.<ExpressionNode>makeNormalNodeUnion(rightOperand), operator, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateBinaryExpressionNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), leftOperand == null ? null : leftOperand.getUid(), rightOperand == null ? null : rightOperand.getUid(), operator, startLocation, stopLocation));
        }
        return ret;
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
        BinaryExpressionNode ret = new BinaryExpressionNodeImpl(leftOperand, rightOperand, operator, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateBinaryExpressionNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), leftOperand == null ? null : (leftOperand.getNodeValue() == null ? null : leftOperand.getNodeValue().getUid()), rightOperand == null ? null : (rightOperand.getNodeValue() == null ? null : rightOperand.getNodeValue().getUid()), operator, startLocation, stopLocation));
        }
        return ret;
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
        BinaryExpressionNode ret = new BinaryExpressionNodeImpl(this.<ExpressionNode>makeNormalNodeUnion(leftOperand), this.<ExpressionNode>makeNormalNodeUnion(rightOperand), operator, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateBinaryExpressionNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), leftOperand == null ? null : leftOperand.getUid(), rightOperand == null ? null : rightOperand.getUid(), operator, startLocation, stopLocation));
        }
        return ret;
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
        BlockNode ret = new BlockNodeImpl(statements, metaAnnotations, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateBlockNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), statements == null ? null : (statements.getNodeValue() == null ? null : statements.getNodeValue().getUid()), metaAnnotations == null ? null : (metaAnnotations.getNodeValue() == null ? null : metaAnnotations.getNodeValue().getUid()), startLocation, stopLocation));
        }
        return ret;
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
        BlockNode ret = new BlockNodeImpl(this.<BlockStatementListNode>makeNormalNodeUnion(statements), this.<MetaAnnotationListNode>makeNormalNodeUnion(metaAnnotations), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateBlockNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), statements == null ? null : statements.getUid(), metaAnnotations == null ? null : metaAnnotations.getUid(), startLocation, stopLocation));
        }
        return ret;
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
        BlockNode ret = new BlockNodeImpl(statements, metaAnnotations, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateBlockNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), statements == null ? null : (statements.getNodeValue() == null ? null : statements.getNodeValue().getUid()), metaAnnotations == null ? null : (metaAnnotations.getNodeValue() == null ? null : metaAnnotations.getNodeValue().getUid()), startLocation, stopLocation));
        }
        return ret;
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
        BlockNode ret = new BlockNodeImpl(this.<BlockStatementListNode>makeNormalNodeUnion(statements), this.<MetaAnnotationListNode>makeNormalNodeUnion(metaAnnotations), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateBlockNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), statements == null ? null : statements.getUid(), metaAnnotations == null ? null : metaAnnotations.getUid(), startLocation, stopLocation));
        }
        return ret;
    }
    
    /**
     * Creates a BlockNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public BlockNode makeBlockNode(
            BlockStatementListNode statements)
    {
        BlockNode ret = new BlockNodeImpl(this.<BlockStatementListNode>makeNormalNodeUnion(statements), this.<MetaAnnotationListNode>makeNormalNodeUnion(makeMetaAnnotationListNode()), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateBlockNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), statements == null ? null : statements.getUid(), ret.getMetaAnnotations() == null ? null : ret.getMetaAnnotations().getUid(), startLocation, stopLocation));
        }
        return ret;
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
        BlockNode ret = new BlockNodeImpl(this.<BlockStatementListNode>makeNormalNodeUnion(statements), this.<MetaAnnotationListNode>makeNormalNodeUnion(makeMetaAnnotationListNode()), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateBlockNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), statements == null ? null : statements.getUid(), ret.getMetaAnnotations() == null ? null : ret.getMetaAnnotations().getUid(), startLocation, stopLocation));
        }
        return ret;
    }
    
    /**
     * Creates a BlockStatementListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public BlockStatementListNode makeBlockStatementListNodeWithUnions(
            List<NodeUnion<? extends BlockStatementNode>> children)
    {
        BlockStatementListNode ret = new BlockStatementListNodeImpl(children, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateBlockStatementListNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), EditScriptUtilities.getNodeUnionUids(children), startLocation, stopLocation));
        }
        return ret;
    }
    
    /**
     * Creates a BlockStatementListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public BlockStatementListNode makeBlockStatementListNode(
            List<BlockStatementNode> children)
    {
        BlockStatementListNode ret = new BlockStatementListNodeImpl(unionWrapList(children), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateBlockStatementListNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), EditScriptUtilities.getNodeUids(children), startLocation, stopLocation));
        }
        return ret;
    }
    
    /**
     * Creates a BlockStatementListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public BlockStatementListNode makeBlockStatementListNode(
            BlockStatementNode... childrenElements)
    {
        List<BlockStatementNode> children = Arrays.asList(childrenElements);
        return makeBlockStatementListNode(children, startLocation, stopLocation);
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
        BlockStatementListNode ret = new BlockStatementListNodeImpl(children, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateBlockStatementListNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), EditScriptUtilities.getNodeUnionUids(children), startLocation, stopLocation));
        }
        return ret;
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
        BlockStatementListNode ret = new BlockStatementListNodeImpl(unionWrapList(children), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateBlockStatementListNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), EditScriptUtilities.getNodeUids(children), startLocation, stopLocation));
        }
        return ret;
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
        List<BlockStatementNode> children = Arrays.asList(childrenElements);
        return makeBlockStatementListNode(children, startLocation, stopLocation);
    }
    
    /**
     * Creates a BlockStatementMetaprogramAnchorNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public BlockStatementMetaprogramAnchorNode makeBlockStatementMetaprogramAnchorNodeWithUnions(
            NodeUnion<? extends MetaprogramNode> metaprogram)
    {
        BlockStatementMetaprogramAnchorNode ret = new BlockStatementMetaprogramAnchorNodeImpl(metaprogram, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateBlockStatementMetaprogramAnchorNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), metaprogram == null ? null : (metaprogram.getNodeValue() == null ? null : metaprogram.getNodeValue().getUid()), startLocation, stopLocation));
        }
        return ret;
    }
    
    /**
     * Creates a BlockStatementMetaprogramAnchorNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public BlockStatementMetaprogramAnchorNode makeBlockStatementMetaprogramAnchorNode(
            MetaprogramNode metaprogram)
    {
        BlockStatementMetaprogramAnchorNode ret = new BlockStatementMetaprogramAnchorNodeImpl(this.<MetaprogramNode>makeNormalNodeUnion(metaprogram), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateBlockStatementMetaprogramAnchorNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), metaprogram == null ? null : metaprogram.getUid(), startLocation, stopLocation));
        }
        return ret;
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
        BlockStatementMetaprogramAnchorNode ret = new BlockStatementMetaprogramAnchorNodeImpl(metaprogram, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateBlockStatementMetaprogramAnchorNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), metaprogram == null ? null : (metaprogram.getNodeValue() == null ? null : metaprogram.getNodeValue().getUid()), startLocation, stopLocation));
        }
        return ret;
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
        BlockStatementMetaprogramAnchorNode ret = new BlockStatementMetaprogramAnchorNodeImpl(this.<MetaprogramNode>makeNormalNodeUnion(metaprogram), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateBlockStatementMetaprogramAnchorNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), metaprogram == null ? null : metaprogram.getUid(), startLocation, stopLocation));
        }
        return ret;
    }
    
    /**
     * Creates a BooleanLiteralNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public BooleanLiteralNode makeBooleanLiteralNode(
            Boolean value)
    {
        BooleanLiteralNode ret = new BooleanLiteralNodeImpl(value, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateBooleanLiteralNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), value, startLocation, stopLocation));
        }
        return ret;
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
        BooleanLiteralNode ret = new BooleanLiteralNodeImpl(value, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateBooleanLiteralNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), value, startLocation, stopLocation));
        }
        return ret;
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
        BreakNode ret = new BreakNodeImpl(label, metaAnnotations, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateBreakNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), label == null ? null : (label.getNodeValue() == null ? null : label.getNodeValue().getUid()), metaAnnotations == null ? null : (metaAnnotations.getNodeValue() == null ? null : metaAnnotations.getNodeValue().getUid()), startLocation, stopLocation));
        }
        return ret;
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
        BreakNode ret = new BreakNodeImpl(this.<IdentifierNode>makeNormalNodeUnion(label), this.<MetaAnnotationListNode>makeNormalNodeUnion(metaAnnotations), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateBreakNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), label == null ? null : label.getUid(), metaAnnotations == null ? null : metaAnnotations.getUid(), startLocation, stopLocation));
        }
        return ret;
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
        BreakNode ret = new BreakNodeImpl(label, metaAnnotations, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateBreakNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), label == null ? null : (label.getNodeValue() == null ? null : label.getNodeValue().getUid()), metaAnnotations == null ? null : (metaAnnotations.getNodeValue() == null ? null : metaAnnotations.getNodeValue().getUid()), startLocation, stopLocation));
        }
        return ret;
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
        BreakNode ret = new BreakNodeImpl(this.<IdentifierNode>makeNormalNodeUnion(label), this.<MetaAnnotationListNode>makeNormalNodeUnion(metaAnnotations), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateBreakNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), label == null ? null : label.getUid(), metaAnnotations == null ? null : metaAnnotations.getUid(), startLocation, stopLocation));
        }
        return ret;
    }
    
    /**
     * Creates a BreakNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public BreakNode makeBreakNode()
    {
        BreakNode ret = new BreakNodeImpl(this.<IdentifierNode>makeNormalNodeUnion(null), this.<MetaAnnotationListNode>makeNormalNodeUnion(makeMetaAnnotationListNode()), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateBreakNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), ret.getLabel() == null ? null : ret.getLabel().getUid(), ret.getMetaAnnotations() == null ? null : ret.getMetaAnnotations().getUid(), startLocation, stopLocation));
        }
        return ret;
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
        BreakNode ret = new BreakNodeImpl(this.<IdentifierNode>makeNormalNodeUnion(null), this.<MetaAnnotationListNode>makeNormalNodeUnion(makeMetaAnnotationListNode()), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateBreakNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), ret.getLabel() == null ? null : ret.getLabel().getUid(), ret.getMetaAnnotations() == null ? null : ret.getMetaAnnotations().getUid(), startLocation, stopLocation));
        }
        return ret;
    }
    
    /**
     * Creates a BreakNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public BreakNode makeBreakNode(
            IdentifierNode label)
    {
        BreakNode ret = new BreakNodeImpl(this.<IdentifierNode>makeNormalNodeUnion(label), this.<MetaAnnotationListNode>makeNormalNodeUnion(makeMetaAnnotationListNode()), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateBreakNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), label == null ? null : label.getUid(), ret.getMetaAnnotations() == null ? null : ret.getMetaAnnotations().getUid(), startLocation, stopLocation));
        }
        return ret;
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
        BreakNode ret = new BreakNodeImpl(this.<IdentifierNode>makeNormalNodeUnion(label), this.<MetaAnnotationListNode>makeNormalNodeUnion(makeMetaAnnotationListNode()), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateBreakNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), label == null ? null : label.getUid(), ret.getMetaAnnotations() == null ? null : ret.getMetaAnnotations().getUid(), startLocation, stopLocation));
        }
        return ret;
    }
    
    /**
     * Creates a CaseListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public CaseListNode makeCaseListNodeWithUnions(
            List<NodeUnion<? extends CaseNode>> children)
    {
        CaseListNode ret = new CaseListNodeImpl(children, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateCaseListNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), EditScriptUtilities.getNodeUnionUids(children), startLocation, stopLocation));
        }
        return ret;
    }
    
    /**
     * Creates a CaseListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public CaseListNode makeCaseListNode(
            List<CaseNode> children)
    {
        CaseListNode ret = new CaseListNodeImpl(unionWrapList(children), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateCaseListNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), EditScriptUtilities.getNodeUids(children), startLocation, stopLocation));
        }
        return ret;
    }
    
    /**
     * Creates a CaseListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public CaseListNode makeCaseListNode(
            CaseNode... childrenElements)
    {
        List<CaseNode> children = Arrays.asList(childrenElements);
        return makeCaseListNode(children, startLocation, stopLocation);
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
        CaseListNode ret = new CaseListNodeImpl(children, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateCaseListNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), EditScriptUtilities.getNodeUnionUids(children), startLocation, stopLocation));
        }
        return ret;
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
        CaseListNode ret = new CaseListNodeImpl(unionWrapList(children), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateCaseListNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), EditScriptUtilities.getNodeUids(children), startLocation, stopLocation));
        }
        return ret;
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
        List<CaseNode> children = Arrays.asList(childrenElements);
        return makeCaseListNode(children, startLocation, stopLocation);
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
        CaseNode ret = new CaseNodeImpl(expression, statements, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateCaseNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), expression == null ? null : (expression.getNodeValue() == null ? null : expression.getNodeValue().getUid()), statements == null ? null : (statements.getNodeValue() == null ? null : statements.getNodeValue().getUid()), startLocation, stopLocation));
        }
        return ret;
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
        CaseNode ret = new CaseNodeImpl(this.<ExpressionNode>makeNormalNodeUnion(expression), this.<BlockStatementListNode>makeNormalNodeUnion(statements), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateCaseNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), expression == null ? null : expression.getUid(), statements == null ? null : statements.getUid(), startLocation, stopLocation));
        }
        return ret;
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
        CaseNode ret = new CaseNodeImpl(expression, statements, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateCaseNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), expression == null ? null : (expression.getNodeValue() == null ? null : expression.getNodeValue().getUid()), statements == null ? null : (statements.getNodeValue() == null ? null : statements.getNodeValue().getUid()), startLocation, stopLocation));
        }
        return ret;
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
        CaseNode ret = new CaseNodeImpl(this.<ExpressionNode>makeNormalNodeUnion(expression), this.<BlockStatementListNode>makeNormalNodeUnion(statements), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateCaseNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), expression == null ? null : expression.getUid(), statements == null ? null : statements.getUid(), startLocation, stopLocation));
        }
        return ret;
    }
    
    /**
     * Creates a CatchListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public CatchListNode makeCatchListNodeWithUnions(
            List<NodeUnion<? extends CatchNode>> children)
    {
        CatchListNode ret = new CatchListNodeImpl(children, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateCatchListNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), EditScriptUtilities.getNodeUnionUids(children), startLocation, stopLocation));
        }
        return ret;
    }
    
    /**
     * Creates a CatchListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public CatchListNode makeCatchListNode(
            List<CatchNode> children)
    {
        CatchListNode ret = new CatchListNodeImpl(unionWrapList(children), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateCatchListNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), EditScriptUtilities.getNodeUids(children), startLocation, stopLocation));
        }
        return ret;
    }
    
    /**
     * Creates a CatchListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public CatchListNode makeCatchListNode(
            CatchNode... childrenElements)
    {
        List<CatchNode> children = Arrays.asList(childrenElements);
        return makeCatchListNode(children, startLocation, stopLocation);
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
        CatchListNode ret = new CatchListNodeImpl(children, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateCatchListNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), EditScriptUtilities.getNodeUnionUids(children), startLocation, stopLocation));
        }
        return ret;
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
        CatchListNode ret = new CatchListNodeImpl(unionWrapList(children), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateCatchListNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), EditScriptUtilities.getNodeUids(children), startLocation, stopLocation));
        }
        return ret;
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
        List<CatchNode> children = Arrays.asList(childrenElements);
        return makeCatchListNode(children, startLocation, stopLocation);
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
        CatchNode ret = new CatchNodeImpl(body, parameter, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateCatchNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), body == null ? null : (body.getNodeValue() == null ? null : body.getNodeValue().getUid()), parameter == null ? null : (parameter.getNodeValue() == null ? null : parameter.getNodeValue().getUid()), startLocation, stopLocation));
        }
        return ret;
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
        CatchNode ret = new CatchNodeImpl(this.<BlockStatementListNode>makeNormalNodeUnion(body), this.<VariableNode>makeNormalNodeUnion(parameter), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateCatchNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), body == null ? null : body.getUid(), parameter == null ? null : parameter.getUid(), startLocation, stopLocation));
        }
        return ret;
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
        CatchNode ret = new CatchNodeImpl(body, parameter, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateCatchNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), body == null ? null : (body.getNodeValue() == null ? null : body.getNodeValue().getUid()), parameter == null ? null : (parameter.getNodeValue() == null ? null : parameter.getNodeValue().getUid()), startLocation, stopLocation));
        }
        return ret;
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
        CatchNode ret = new CatchNodeImpl(this.<BlockStatementListNode>makeNormalNodeUnion(body), this.<VariableNode>makeNormalNodeUnion(parameter), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateCatchNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), body == null ? null : body.getUid(), parameter == null ? null : parameter.getUid(), startLocation, stopLocation));
        }
        return ret;
    }
    
    /**
     * Creates a CharLiteralNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public CharLiteralNode makeCharLiteralNode(
            Character value)
    {
        CharLiteralNode ret = new CharLiteralNodeImpl(value, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateCharLiteralNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), value, startLocation, stopLocation));
        }
        return ret;
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
        CharLiteralNode ret = new CharLiteralNodeImpl(value, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateCharLiteralNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), value, startLocation, stopLocation));
        }
        return ret;
    }
    
    /**
     * Creates a ClassBodyNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public ClassBodyNode makeClassBodyNodeWithUnions(
            NodeUnion<? extends ClassMemberListNode> members)
    {
        ClassBodyNode ret = new ClassBodyNodeImpl(members, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateClassBodyNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), members == null ? null : (members.getNodeValue() == null ? null : members.getNodeValue().getUid()), startLocation, stopLocation));
        }
        return ret;
    }
    
    /**
     * Creates a ClassBodyNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public ClassBodyNode makeClassBodyNode(
            ClassMemberListNode members)
    {
        ClassBodyNode ret = new ClassBodyNodeImpl(this.<ClassMemberListNode>makeNormalNodeUnion(members), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateClassBodyNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), members == null ? null : members.getUid(), startLocation, stopLocation));
        }
        return ret;
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
        ClassBodyNode ret = new ClassBodyNodeImpl(members, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateClassBodyNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), members == null ? null : (members.getNodeValue() == null ? null : members.getNodeValue().getUid()), startLocation, stopLocation));
        }
        return ret;
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
        ClassBodyNode ret = new ClassBodyNodeImpl(this.<ClassMemberListNode>makeNormalNodeUnion(members), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateClassBodyNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), members == null ? null : members.getUid(), startLocation, stopLocation));
        }
        return ret;
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
        ClassDeclarationNode ret = new ClassDeclarationNodeImpl(modifiers, extendsClause, implementsClause, body, typeParameters, identifier, javadoc, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateClassDeclarationNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), modifiers == null ? null : (modifiers.getNodeValue() == null ? null : modifiers.getNodeValue().getUid()), extendsClause == null ? null : (extendsClause.getNodeValue() == null ? null : extendsClause.getNodeValue().getUid()), implementsClause == null ? null : (implementsClause.getNodeValue() == null ? null : implementsClause.getNodeValue().getUid()), body == null ? null : (body.getNodeValue() == null ? null : body.getNodeValue().getUid()), typeParameters == null ? null : (typeParameters.getNodeValue() == null ? null : typeParameters.getNodeValue().getUid()), identifier == null ? null : (identifier.getNodeValue() == null ? null : identifier.getNodeValue().getUid()), javadoc == null ? null : (javadoc.getNodeValue() == null ? null : javadoc.getNodeValue().getUid()), startLocation, stopLocation));
        }
        return ret;
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
        ClassDeclarationNode ret = new ClassDeclarationNodeImpl(this.<ClassModifiersNode>makeNormalNodeUnion(modifiers), this.<DeclaredTypeNode>makeNormalNodeUnion(extendsClause), this.<DeclaredTypeListNode>makeNormalNodeUnion(implementsClause), this.<ClassBodyNode>makeNormalNodeUnion(body), this.<TypeParameterListNode>makeNormalNodeUnion(typeParameters), this.<IdentifierNode>makeNormalNodeUnion(identifier), this.<JavadocNode>makeNormalNodeUnion(javadoc), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateClassDeclarationNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), modifiers == null ? null : modifiers.getUid(), extendsClause == null ? null : extendsClause.getUid(), implementsClause == null ? null : implementsClause.getUid(), body == null ? null : body.getUid(), typeParameters == null ? null : typeParameters.getUid(), identifier == null ? null : identifier.getUid(), javadoc == null ? null : javadoc.getUid(), startLocation, stopLocation));
        }
        return ret;
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
        ClassDeclarationNode ret = new ClassDeclarationNodeImpl(modifiers, extendsClause, implementsClause, body, typeParameters, identifier, javadoc, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateClassDeclarationNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), modifiers == null ? null : (modifiers.getNodeValue() == null ? null : modifiers.getNodeValue().getUid()), extendsClause == null ? null : (extendsClause.getNodeValue() == null ? null : extendsClause.getNodeValue().getUid()), implementsClause == null ? null : (implementsClause.getNodeValue() == null ? null : implementsClause.getNodeValue().getUid()), body == null ? null : (body.getNodeValue() == null ? null : body.getNodeValue().getUid()), typeParameters == null ? null : (typeParameters.getNodeValue() == null ? null : typeParameters.getNodeValue().getUid()), identifier == null ? null : (identifier.getNodeValue() == null ? null : identifier.getNodeValue().getUid()), javadoc == null ? null : (javadoc.getNodeValue() == null ? null : javadoc.getNodeValue().getUid()), startLocation, stopLocation));
        }
        return ret;
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
        ClassDeclarationNode ret = new ClassDeclarationNodeImpl(this.<ClassModifiersNode>makeNormalNodeUnion(modifiers), this.<DeclaredTypeNode>makeNormalNodeUnion(extendsClause), this.<DeclaredTypeListNode>makeNormalNodeUnion(implementsClause), this.<ClassBodyNode>makeNormalNodeUnion(body), this.<TypeParameterListNode>makeNormalNodeUnion(typeParameters), this.<IdentifierNode>makeNormalNodeUnion(identifier), this.<JavadocNode>makeNormalNodeUnion(javadoc), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateClassDeclarationNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), modifiers == null ? null : modifiers.getUid(), extendsClause == null ? null : extendsClause.getUid(), implementsClause == null ? null : implementsClause.getUid(), body == null ? null : body.getUid(), typeParameters == null ? null : typeParameters.getUid(), identifier == null ? null : identifier.getUid(), javadoc == null ? null : javadoc.getUid(), startLocation, stopLocation));
        }
        return ret;
    }
    
    /**
     * Creates a ClassLiteralNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public ClassLiteralNode makeClassLiteralNodeWithUnions(
            NodeUnion<? extends LiteralizableTypeNode> value)
    {
        ClassLiteralNode ret = new ClassLiteralNodeImpl(value, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateClassLiteralNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), value == null ? null : (value.getNodeValue() == null ? null : value.getNodeValue().getUid()), startLocation, stopLocation));
        }
        return ret;
    }
    
    /**
     * Creates a ClassLiteralNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public ClassLiteralNode makeClassLiteralNode(
            LiteralizableTypeNode value)
    {
        ClassLiteralNode ret = new ClassLiteralNodeImpl(this.<LiteralizableTypeNode>makeNormalNodeUnion(value), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateClassLiteralNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), value == null ? null : value.getUid(), startLocation, stopLocation));
        }
        return ret;
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
        ClassLiteralNode ret = new ClassLiteralNodeImpl(value, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateClassLiteralNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), value == null ? null : (value.getNodeValue() == null ? null : value.getNodeValue().getUid()), startLocation, stopLocation));
        }
        return ret;
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
        ClassLiteralNode ret = new ClassLiteralNodeImpl(this.<LiteralizableTypeNode>makeNormalNodeUnion(value), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateClassLiteralNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), value == null ? null : value.getUid(), startLocation, stopLocation));
        }
        return ret;
    }
    
    /**
     * Creates a ClassMemberListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public ClassMemberListNode makeClassMemberListNodeWithUnions(
            List<NodeUnion<? extends ClassMemberNode>> children)
    {
        ClassMemberListNode ret = new ClassMemberListNodeImpl(children, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateClassMemberListNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), EditScriptUtilities.getNodeUnionUids(children), startLocation, stopLocation));
        }
        return ret;
    }
    
    /**
     * Creates a ClassMemberListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public ClassMemberListNode makeClassMemberListNode(
            List<ClassMemberNode> children)
    {
        ClassMemberListNode ret = new ClassMemberListNodeImpl(unionWrapList(children), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateClassMemberListNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), EditScriptUtilities.getNodeUids(children), startLocation, stopLocation));
        }
        return ret;
    }
    
    /**
     * Creates a ClassMemberListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public ClassMemberListNode makeClassMemberListNode(
            ClassMemberNode... childrenElements)
    {
        List<ClassMemberNode> children = Arrays.asList(childrenElements);
        return makeClassMemberListNode(children, startLocation, stopLocation);
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
        ClassMemberListNode ret = new ClassMemberListNodeImpl(children, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateClassMemberListNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), EditScriptUtilities.getNodeUnionUids(children), startLocation, stopLocation));
        }
        return ret;
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
        ClassMemberListNode ret = new ClassMemberListNodeImpl(unionWrapList(children), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateClassMemberListNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), EditScriptUtilities.getNodeUids(children), startLocation, stopLocation));
        }
        return ret;
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
        List<ClassMemberNode> children = Arrays.asList(childrenElements);
        return makeClassMemberListNode(children, startLocation, stopLocation);
    }
    
    /**
     * Creates a ClassMemberMetaprogramAnchorNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public ClassMemberMetaprogramAnchorNode makeClassMemberMetaprogramAnchorNodeWithUnions(
            NodeUnion<? extends MetaprogramNode> metaprogram)
    {
        ClassMemberMetaprogramAnchorNode ret = new ClassMemberMetaprogramAnchorNodeImpl(metaprogram, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateClassMemberMetaprogramAnchorNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), metaprogram == null ? null : (metaprogram.getNodeValue() == null ? null : metaprogram.getNodeValue().getUid()), startLocation, stopLocation));
        }
        return ret;
    }
    
    /**
     * Creates a ClassMemberMetaprogramAnchorNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public ClassMemberMetaprogramAnchorNode makeClassMemberMetaprogramAnchorNode(
            MetaprogramNode metaprogram)
    {
        ClassMemberMetaprogramAnchorNode ret = new ClassMemberMetaprogramAnchorNodeImpl(this.<MetaprogramNode>makeNormalNodeUnion(metaprogram), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateClassMemberMetaprogramAnchorNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), metaprogram == null ? null : metaprogram.getUid(), startLocation, stopLocation));
        }
        return ret;
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
        ClassMemberMetaprogramAnchorNode ret = new ClassMemberMetaprogramAnchorNodeImpl(metaprogram, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateClassMemberMetaprogramAnchorNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), metaprogram == null ? null : (metaprogram.getNodeValue() == null ? null : metaprogram.getNodeValue().getUid()), startLocation, stopLocation));
        }
        return ret;
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
        ClassMemberMetaprogramAnchorNode ret = new ClassMemberMetaprogramAnchorNodeImpl(this.<MetaprogramNode>makeNormalNodeUnion(metaprogram), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateClassMemberMetaprogramAnchorNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), metaprogram == null ? null : metaprogram.getUid(), startLocation, stopLocation));
        }
        return ret;
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
        ClassModifiersNode ret = new ClassModifiersNodeImpl(access, abstractFlag, staticFlag, finalFlag, strictfpFlag, metaAnnotations, annotations, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateClassModifiersNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), access, abstractFlag, staticFlag, finalFlag, strictfpFlag, metaAnnotations == null ? null : (metaAnnotations.getNodeValue() == null ? null : metaAnnotations.getNodeValue().getUid()), annotations == null ? null : (annotations.getNodeValue() == null ? null : annotations.getNodeValue().getUid()), startLocation, stopLocation));
        }
        return ret;
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
        ClassModifiersNode ret = new ClassModifiersNodeImpl(access, abstractFlag, staticFlag, finalFlag, strictfpFlag, this.<MetaAnnotationListNode>makeNormalNodeUnion(metaAnnotations), this.<AnnotationListNode>makeNormalNodeUnion(annotations), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateClassModifiersNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), access, abstractFlag, staticFlag, finalFlag, strictfpFlag, metaAnnotations == null ? null : metaAnnotations.getUid(), annotations == null ? null : annotations.getUid(), startLocation, stopLocation));
        }
        return ret;
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
        ClassModifiersNode ret = new ClassModifiersNodeImpl(access, abstractFlag, staticFlag, finalFlag, strictfpFlag, metaAnnotations, annotations, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateClassModifiersNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), access, abstractFlag, staticFlag, finalFlag, strictfpFlag, metaAnnotations == null ? null : (metaAnnotations.getNodeValue() == null ? null : metaAnnotations.getNodeValue().getUid()), annotations == null ? null : (annotations.getNodeValue() == null ? null : annotations.getNodeValue().getUid()), startLocation, stopLocation));
        }
        return ret;
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
        ClassModifiersNode ret = new ClassModifiersNodeImpl(access, abstractFlag, staticFlag, finalFlag, strictfpFlag, this.<MetaAnnotationListNode>makeNormalNodeUnion(metaAnnotations), this.<AnnotationListNode>makeNormalNodeUnion(annotations), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateClassModifiersNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), access, abstractFlag, staticFlag, finalFlag, strictfpFlag, metaAnnotations == null ? null : metaAnnotations.getUid(), annotations == null ? null : annotations.getUid(), startLocation, stopLocation));
        }
        return ret;
    }
    
    /**
     * Creates a ClassModifiersNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public ClassModifiersNode makeClassModifiersNode(
            AccessModifier access)
    {
        ClassModifiersNode ret = new ClassModifiersNodeImpl(access, false, false, false, false, this.<MetaAnnotationListNode>makeNormalNodeUnion(makeMetaAnnotationListNode()), this.<AnnotationListNode>makeNormalNodeUnion(makeAnnotationListNode()), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateClassModifiersNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), access, ret.getAbstractFlag(), ret.getStaticFlag(), ret.getFinalFlag(), ret.getStrictfpFlag(), ret.getMetaAnnotations() == null ? null : ret.getMetaAnnotations().getUid(), ret.getAnnotations() == null ? null : ret.getAnnotations().getUid(), startLocation, stopLocation));
        }
        return ret;
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
        ClassModifiersNode ret = new ClassModifiersNodeImpl(access, false, false, false, false, this.<MetaAnnotationListNode>makeNormalNodeUnion(makeMetaAnnotationListNode()), this.<AnnotationListNode>makeNormalNodeUnion(makeAnnotationListNode()), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateClassModifiersNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), access, ret.getAbstractFlag(), ret.getStaticFlag(), ret.getFinalFlag(), ret.getStrictfpFlag(), ret.getMetaAnnotations() == null ? null : ret.getMetaAnnotations().getUid(), ret.getAnnotations() == null ? null : ret.getAnnotations().getUid(), startLocation, stopLocation));
        }
        return ret;
    }
    
    /**
     * Creates a CodeLiteralNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public CodeLiteralNode makeCodeLiteralNodeWithUnions(
            NodeUnion<? extends Node> value)
    {
        CodeLiteralNode ret = new CodeLiteralNodeImpl(value, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateCodeLiteralNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), value == null ? null : (value.getNodeValue() == null ? null : value.getNodeValue().getUid()), startLocation, stopLocation));
        }
        return ret;
    }
    
    /**
     * Creates a CodeLiteralNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public CodeLiteralNode makeCodeLiteralNode(
            Node value)
    {
        CodeLiteralNode ret = new CodeLiteralNodeImpl(this.<Node>makeNormalNodeUnion(value), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateCodeLiteralNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), value == null ? null : value.getUid(), startLocation, stopLocation));
        }
        return ret;
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
        CodeLiteralNode ret = new CodeLiteralNodeImpl(value, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateCodeLiteralNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), value == null ? null : (value.getNodeValue() == null ? null : value.getNodeValue().getUid()), startLocation, stopLocation));
        }
        return ret;
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
        CodeLiteralNode ret = new CodeLiteralNodeImpl(this.<Node>makeNormalNodeUnion(value), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateCodeLiteralNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), value == null ? null : value.getUid(), startLocation, stopLocation));
        }
        return ret;
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
        CompilationUnitNode ret = new CompilationUnitNodeImpl(name, packageDeclaration, metaimports, imports, typeDecls, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateCompilationUnitNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), name, packageDeclaration == null ? null : (packageDeclaration.getNodeValue() == null ? null : packageDeclaration.getNodeValue().getUid()), metaimports == null ? null : (metaimports.getNodeValue() == null ? null : metaimports.getNodeValue().getUid()), imports == null ? null : (imports.getNodeValue() == null ? null : imports.getNodeValue().getUid()), typeDecls == null ? null : (typeDecls.getNodeValue() == null ? null : typeDecls.getNodeValue().getUid()), startLocation, stopLocation));
        }
        return ret;
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
        CompilationUnitNode ret = new CompilationUnitNodeImpl(name, this.<PackageDeclarationNode>makeNormalNodeUnion(packageDeclaration), this.<MetaprogramImportListNode>makeNormalNodeUnion(metaimports), this.<ImportListNode>makeNormalNodeUnion(imports), this.<TypeDeclarationListNode>makeNormalNodeUnion(typeDecls), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateCompilationUnitNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), name, packageDeclaration == null ? null : packageDeclaration.getUid(), metaimports == null ? null : metaimports.getUid(), imports == null ? null : imports.getUid(), typeDecls == null ? null : typeDecls.getUid(), startLocation, stopLocation));
        }
        return ret;
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
        CompilationUnitNode ret = new CompilationUnitNodeImpl(name, packageDeclaration, metaimports, imports, typeDecls, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateCompilationUnitNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), name, packageDeclaration == null ? null : (packageDeclaration.getNodeValue() == null ? null : packageDeclaration.getNodeValue().getUid()), metaimports == null ? null : (metaimports.getNodeValue() == null ? null : metaimports.getNodeValue().getUid()), imports == null ? null : (imports.getNodeValue() == null ? null : imports.getNodeValue().getUid()), typeDecls == null ? null : (typeDecls.getNodeValue() == null ? null : typeDecls.getNodeValue().getUid()), startLocation, stopLocation));
        }
        return ret;
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
        CompilationUnitNode ret = new CompilationUnitNodeImpl(name, this.<PackageDeclarationNode>makeNormalNodeUnion(packageDeclaration), this.<MetaprogramImportListNode>makeNormalNodeUnion(metaimports), this.<ImportListNode>makeNormalNodeUnion(imports), this.<TypeDeclarationListNode>makeNormalNodeUnion(typeDecls), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateCompilationUnitNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), name, packageDeclaration == null ? null : packageDeclaration.getUid(), metaimports == null ? null : metaimports.getUid(), imports == null ? null : imports.getUid(), typeDecls == null ? null : typeDecls.getUid(), startLocation, stopLocation));
        }
        return ret;
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
        CompilationUnitNode ret = new CompilationUnitNodeImpl(name, this.<PackageDeclarationNode>makeNormalNodeUnion(packageDeclaration), this.<MetaprogramImportListNode>makeNormalNodeUnion(makeMetaprogramImportListNode()), this.<ImportListNode>makeNormalNodeUnion(imports), this.<TypeDeclarationListNode>makeNormalNodeUnion(typeDecls), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateCompilationUnitNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), name, packageDeclaration == null ? null : packageDeclaration.getUid(), ret.getMetaimports() == null ? null : ret.getMetaimports().getUid(), imports == null ? null : imports.getUid(), typeDecls == null ? null : typeDecls.getUid(), startLocation, stopLocation));
        }
        return ret;
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
        CompilationUnitNode ret = new CompilationUnitNodeImpl(name, this.<PackageDeclarationNode>makeNormalNodeUnion(packageDeclaration), this.<MetaprogramImportListNode>makeNormalNodeUnion(makeMetaprogramImportListNode()), this.<ImportListNode>makeNormalNodeUnion(imports), this.<TypeDeclarationListNode>makeNormalNodeUnion(typeDecls), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateCompilationUnitNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), name, packageDeclaration == null ? null : packageDeclaration.getUid(), ret.getMetaimports() == null ? null : ret.getMetaimports().getUid(), imports == null ? null : imports.getUid(), typeDecls == null ? null : typeDecls.getUid(), startLocation, stopLocation));
        }
        return ret;
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
        ConditionalExpressionNode ret = new ConditionalExpressionNodeImpl(condition, trueExpression, falseExpression, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateConditionalExpressionNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), condition == null ? null : (condition.getNodeValue() == null ? null : condition.getNodeValue().getUid()), trueExpression == null ? null : (trueExpression.getNodeValue() == null ? null : trueExpression.getNodeValue().getUid()), falseExpression == null ? null : (falseExpression.getNodeValue() == null ? null : falseExpression.getNodeValue().getUid()), startLocation, stopLocation));
        }
        return ret;
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
        ConditionalExpressionNode ret = new ConditionalExpressionNodeImpl(this.<ExpressionNode>makeNormalNodeUnion(condition), this.<ExpressionNode>makeNormalNodeUnion(trueExpression), this.<ExpressionNode>makeNormalNodeUnion(falseExpression), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateConditionalExpressionNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), condition == null ? null : condition.getUid(), trueExpression == null ? null : trueExpression.getUid(), falseExpression == null ? null : falseExpression.getUid(), startLocation, stopLocation));
        }
        return ret;
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
        ConditionalExpressionNode ret = new ConditionalExpressionNodeImpl(condition, trueExpression, falseExpression, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateConditionalExpressionNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), condition == null ? null : (condition.getNodeValue() == null ? null : condition.getNodeValue().getUid()), trueExpression == null ? null : (trueExpression.getNodeValue() == null ? null : trueExpression.getNodeValue().getUid()), falseExpression == null ? null : (falseExpression.getNodeValue() == null ? null : falseExpression.getNodeValue().getUid()), startLocation, stopLocation));
        }
        return ret;
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
        ConditionalExpressionNode ret = new ConditionalExpressionNodeImpl(this.<ExpressionNode>makeNormalNodeUnion(condition), this.<ExpressionNode>makeNormalNodeUnion(trueExpression), this.<ExpressionNode>makeNormalNodeUnion(falseExpression), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateConditionalExpressionNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), condition == null ? null : condition.getUid(), trueExpression == null ? null : trueExpression.getUid(), falseExpression == null ? null : falseExpression.getUid(), startLocation, stopLocation));
        }
        return ret;
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
        ConstantDeclarationNode ret = new ConstantDeclarationNodeImpl(modifiers, type, declarators, javadoc, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateConstantDeclarationNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), modifiers == null ? null : (modifiers.getNodeValue() == null ? null : modifiers.getNodeValue().getUid()), type == null ? null : (type.getNodeValue() == null ? null : type.getNodeValue().getUid()), declarators == null ? null : (declarators.getNodeValue() == null ? null : declarators.getNodeValue().getUid()), javadoc == null ? null : (javadoc.getNodeValue() == null ? null : javadoc.getNodeValue().getUid()), startLocation, stopLocation));
        }
        return ret;
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
        ConstantDeclarationNode ret = new ConstantDeclarationNodeImpl(this.<ConstantModifiersNode>makeNormalNodeUnion(modifiers), this.<TypeNode>makeNormalNodeUnion(type), this.<VariableDeclaratorListNode>makeNormalNodeUnion(declarators), this.<JavadocNode>makeNormalNodeUnion(javadoc), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateConstantDeclarationNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), modifiers == null ? null : modifiers.getUid(), type == null ? null : type.getUid(), declarators == null ? null : declarators.getUid(), javadoc == null ? null : javadoc.getUid(), startLocation, stopLocation));
        }
        return ret;
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
        ConstantDeclarationNode ret = new ConstantDeclarationNodeImpl(modifiers, type, declarators, javadoc, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateConstantDeclarationNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), modifiers == null ? null : (modifiers.getNodeValue() == null ? null : modifiers.getNodeValue().getUid()), type == null ? null : (type.getNodeValue() == null ? null : type.getNodeValue().getUid()), declarators == null ? null : (declarators.getNodeValue() == null ? null : declarators.getNodeValue().getUid()), javadoc == null ? null : (javadoc.getNodeValue() == null ? null : javadoc.getNodeValue().getUid()), startLocation, stopLocation));
        }
        return ret;
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
        ConstantDeclarationNode ret = new ConstantDeclarationNodeImpl(this.<ConstantModifiersNode>makeNormalNodeUnion(modifiers), this.<TypeNode>makeNormalNodeUnion(type), this.<VariableDeclaratorListNode>makeNormalNodeUnion(declarators), this.<JavadocNode>makeNormalNodeUnion(javadoc), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateConstantDeclarationNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), modifiers == null ? null : modifiers.getUid(), type == null ? null : type.getUid(), declarators == null ? null : declarators.getUid(), javadoc == null ? null : javadoc.getUid(), startLocation, stopLocation));
        }
        return ret;
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
        ConstantModifiersNode ret = new ConstantModifiersNodeImpl(metaAnnotations, annotations, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateConstantModifiersNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), metaAnnotations == null ? null : (metaAnnotations.getNodeValue() == null ? null : metaAnnotations.getNodeValue().getUid()), annotations == null ? null : (annotations.getNodeValue() == null ? null : annotations.getNodeValue().getUid()), startLocation, stopLocation));
        }
        return ret;
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
        ConstantModifiersNode ret = new ConstantModifiersNodeImpl(this.<MetaAnnotationListNode>makeNormalNodeUnion(metaAnnotations), this.<AnnotationListNode>makeNormalNodeUnion(annotations), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateConstantModifiersNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), metaAnnotations == null ? null : metaAnnotations.getUid(), annotations == null ? null : annotations.getUid(), startLocation, stopLocation));
        }
        return ret;
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
        ConstantModifiersNode ret = new ConstantModifiersNodeImpl(metaAnnotations, annotations, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateConstantModifiersNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), metaAnnotations == null ? null : (metaAnnotations.getNodeValue() == null ? null : metaAnnotations.getNodeValue().getUid()), annotations == null ? null : (annotations.getNodeValue() == null ? null : annotations.getNodeValue().getUid()), startLocation, stopLocation));
        }
        return ret;
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
        ConstantModifiersNode ret = new ConstantModifiersNodeImpl(this.<MetaAnnotationListNode>makeNormalNodeUnion(metaAnnotations), this.<AnnotationListNode>makeNormalNodeUnion(annotations), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateConstantModifiersNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), metaAnnotations == null ? null : metaAnnotations.getUid(), annotations == null ? null : annotations.getUid(), startLocation, stopLocation));
        }
        return ret;
    }
    
    /**
     * Creates a ConstantModifiersNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public ConstantModifiersNode makeConstantModifiersNode(
    )
    {
        ConstantModifiersNode ret = new ConstantModifiersNodeImpl(this.<MetaAnnotationListNode>makeNormalNodeUnion(makeMetaAnnotationListNode()), this.<AnnotationListNode>makeNormalNodeUnion(makeAnnotationListNode()), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateConstantModifiersNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), ret.getMetaAnnotations() == null ? null : ret.getMetaAnnotations().getUid(), ret.getAnnotations() == null ? null : ret.getAnnotations().getUid(), startLocation, stopLocation));
        }
        return ret;
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
        ConstantModifiersNode ret = new ConstantModifiersNodeImpl(this.<MetaAnnotationListNode>makeNormalNodeUnion(makeMetaAnnotationListNode()), this.<AnnotationListNode>makeNormalNodeUnion(makeAnnotationListNode()), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateConstantModifiersNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), ret.getMetaAnnotations() == null ? null : ret.getMetaAnnotations().getUid(), ret.getAnnotations() == null ? null : ret.getAnnotations().getUid(), startLocation, stopLocation));
        }
        return ret;
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
        ConstructorBodyNode ret = new ConstructorBodyNodeImpl(constructorInvocation, statements, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateConstructorBodyNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), constructorInvocation == null ? null : (constructorInvocation.getNodeValue() == null ? null : constructorInvocation.getNodeValue().getUid()), statements == null ? null : (statements.getNodeValue() == null ? null : statements.getNodeValue().getUid()), startLocation, stopLocation));
        }
        return ret;
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
        ConstructorBodyNode ret = new ConstructorBodyNodeImpl(this.<ConstructorInvocationNode>makeNormalNodeUnion(constructorInvocation), this.<BlockStatementListNode>makeNormalNodeUnion(statements), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateConstructorBodyNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), constructorInvocation == null ? null : constructorInvocation.getUid(), statements == null ? null : statements.getUid(), startLocation, stopLocation));
        }
        return ret;
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
        ConstructorBodyNode ret = new ConstructorBodyNodeImpl(constructorInvocation, statements, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateConstructorBodyNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), constructorInvocation == null ? null : (constructorInvocation.getNodeValue() == null ? null : constructorInvocation.getNodeValue().getUid()), statements == null ? null : (statements.getNodeValue() == null ? null : statements.getNodeValue().getUid()), startLocation, stopLocation));
        }
        return ret;
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
        ConstructorBodyNode ret = new ConstructorBodyNodeImpl(this.<ConstructorInvocationNode>makeNormalNodeUnion(constructorInvocation), this.<BlockStatementListNode>makeNormalNodeUnion(statements), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateConstructorBodyNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), constructorInvocation == null ? null : constructorInvocation.getUid(), statements == null ? null : statements.getUid(), startLocation, stopLocation));
        }
        return ret;
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
        ConstructorDeclarationNode ret = new ConstructorDeclarationNodeImpl(identifier, body, modifiers, parameters, varargParameter, throwTypes, typeParameters, javadoc, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateConstructorDeclarationNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), identifier == null ? null : (identifier.getNodeValue() == null ? null : identifier.getNodeValue().getUid()), body == null ? null : (body.getNodeValue() == null ? null : body.getNodeValue().getUid()), modifiers == null ? null : (modifiers.getNodeValue() == null ? null : modifiers.getNodeValue().getUid()), parameters == null ? null : (parameters.getNodeValue() == null ? null : parameters.getNodeValue().getUid()), varargParameter == null ? null : (varargParameter.getNodeValue() == null ? null : varargParameter.getNodeValue().getUid()), throwTypes == null ? null : (throwTypes.getNodeValue() == null ? null : throwTypes.getNodeValue().getUid()), typeParameters == null ? null : (typeParameters.getNodeValue() == null ? null : typeParameters.getNodeValue().getUid()), javadoc == null ? null : (javadoc.getNodeValue() == null ? null : javadoc.getNodeValue().getUid()), startLocation, stopLocation));
        }
        return ret;
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
        ConstructorDeclarationNode ret = new ConstructorDeclarationNodeImpl(this.<IdentifierNode>makeNormalNodeUnion(identifier), this.<ConstructorBodyNode>makeNormalNodeUnion(body), this.<ConstructorModifiersNode>makeNormalNodeUnion(modifiers), this.<VariableListNode>makeNormalNodeUnion(parameters), this.<VariableNode>makeNormalNodeUnion(varargParameter), this.<UnparameterizedTypeListNode>makeNormalNodeUnion(throwTypes), this.<TypeParameterListNode>makeNormalNodeUnion(typeParameters), this.<JavadocNode>makeNormalNodeUnion(javadoc), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateConstructorDeclarationNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), identifier == null ? null : identifier.getUid(), body == null ? null : body.getUid(), modifiers == null ? null : modifiers.getUid(), parameters == null ? null : parameters.getUid(), varargParameter == null ? null : varargParameter.getUid(), throwTypes == null ? null : throwTypes.getUid(), typeParameters == null ? null : typeParameters.getUid(), javadoc == null ? null : javadoc.getUid(), startLocation, stopLocation));
        }
        return ret;
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
        ConstructorDeclarationNode ret = new ConstructorDeclarationNodeImpl(identifier, body, modifiers, parameters, varargParameter, throwTypes, typeParameters, javadoc, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateConstructorDeclarationNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), identifier == null ? null : (identifier.getNodeValue() == null ? null : identifier.getNodeValue().getUid()), body == null ? null : (body.getNodeValue() == null ? null : body.getNodeValue().getUid()), modifiers == null ? null : (modifiers.getNodeValue() == null ? null : modifiers.getNodeValue().getUid()), parameters == null ? null : (parameters.getNodeValue() == null ? null : parameters.getNodeValue().getUid()), varargParameter == null ? null : (varargParameter.getNodeValue() == null ? null : varargParameter.getNodeValue().getUid()), throwTypes == null ? null : (throwTypes.getNodeValue() == null ? null : throwTypes.getNodeValue().getUid()), typeParameters == null ? null : (typeParameters.getNodeValue() == null ? null : typeParameters.getNodeValue().getUid()), javadoc == null ? null : (javadoc.getNodeValue() == null ? null : javadoc.getNodeValue().getUid()), startLocation, stopLocation));
        }
        return ret;
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
        ConstructorDeclarationNode ret = new ConstructorDeclarationNodeImpl(this.<IdentifierNode>makeNormalNodeUnion(identifier), this.<ConstructorBodyNode>makeNormalNodeUnion(body), this.<ConstructorModifiersNode>makeNormalNodeUnion(modifiers), this.<VariableListNode>makeNormalNodeUnion(parameters), this.<VariableNode>makeNormalNodeUnion(varargParameter), this.<UnparameterizedTypeListNode>makeNormalNodeUnion(throwTypes), this.<TypeParameterListNode>makeNormalNodeUnion(typeParameters), this.<JavadocNode>makeNormalNodeUnion(javadoc), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateConstructorDeclarationNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), identifier == null ? null : identifier.getUid(), body == null ? null : body.getUid(), modifiers == null ? null : modifiers.getUid(), parameters == null ? null : parameters.getUid(), varargParameter == null ? null : varargParameter.getUid(), throwTypes == null ? null : throwTypes.getUid(), typeParameters == null ? null : typeParameters.getUid(), javadoc == null ? null : javadoc.getUid(), startLocation, stopLocation));
        }
        return ret;
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
        ConstructorDeclarationNode ret = new ConstructorDeclarationNodeImpl(this.<IdentifierNode>makeNormalNodeUnion(identifier), this.<ConstructorBodyNode>makeNormalNodeUnion(body), this.<ConstructorModifiersNode>makeNormalNodeUnion(modifiers), this.<VariableListNode>makeNormalNodeUnion(parameters), this.<VariableNode>makeNormalNodeUnion(null), this.<UnparameterizedTypeListNode>makeNormalNodeUnion(makeUnparameterizedTypeListNode()), this.<TypeParameterListNode>makeNormalNodeUnion(makeTypeParameterListNode()), this.<JavadocNode>makeNormalNodeUnion(javadoc), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateConstructorDeclarationNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), identifier == null ? null : identifier.getUid(), body == null ? null : body.getUid(), modifiers == null ? null : modifiers.getUid(), parameters == null ? null : parameters.getUid(), ret.getVarargParameter() == null ? null : ret.getVarargParameter().getUid(), ret.getThrowTypes() == null ? null : ret.getThrowTypes().getUid(), ret.getTypeParameters() == null ? null : ret.getTypeParameters().getUid(), javadoc == null ? null : javadoc.getUid(), startLocation, stopLocation));
        }
        return ret;
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
        ConstructorDeclarationNode ret = new ConstructorDeclarationNodeImpl(this.<IdentifierNode>makeNormalNodeUnion(identifier), this.<ConstructorBodyNode>makeNormalNodeUnion(body), this.<ConstructorModifiersNode>makeNormalNodeUnion(modifiers), this.<VariableListNode>makeNormalNodeUnion(parameters), this.<VariableNode>makeNormalNodeUnion(null), this.<UnparameterizedTypeListNode>makeNormalNodeUnion(makeUnparameterizedTypeListNode()), this.<TypeParameterListNode>makeNormalNodeUnion(makeTypeParameterListNode()), this.<JavadocNode>makeNormalNodeUnion(javadoc), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateConstructorDeclarationNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), identifier == null ? null : identifier.getUid(), body == null ? null : body.getUid(), modifiers == null ? null : modifiers.getUid(), parameters == null ? null : parameters.getUid(), ret.getVarargParameter() == null ? null : ret.getVarargParameter().getUid(), ret.getThrowTypes() == null ? null : ret.getThrowTypes().getUid(), ret.getTypeParameters() == null ? null : ret.getTypeParameters().getUid(), javadoc == null ? null : javadoc.getUid(), startLocation, stopLocation));
        }
        return ret;
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
        ConstructorModifiersNode ret = new ConstructorModifiersNodeImpl(access, metaAnnotations, annotations, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateConstructorModifiersNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), access, metaAnnotations == null ? null : (metaAnnotations.getNodeValue() == null ? null : metaAnnotations.getNodeValue().getUid()), annotations == null ? null : (annotations.getNodeValue() == null ? null : annotations.getNodeValue().getUid()), startLocation, stopLocation));
        }
        return ret;
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
        ConstructorModifiersNode ret = new ConstructorModifiersNodeImpl(access, this.<MetaAnnotationListNode>makeNormalNodeUnion(metaAnnotations), this.<AnnotationListNode>makeNormalNodeUnion(annotations), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateConstructorModifiersNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), access, metaAnnotations == null ? null : metaAnnotations.getUid(), annotations == null ? null : annotations.getUid(), startLocation, stopLocation));
        }
        return ret;
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
        ConstructorModifiersNode ret = new ConstructorModifiersNodeImpl(access, metaAnnotations, annotations, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateConstructorModifiersNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), access, metaAnnotations == null ? null : (metaAnnotations.getNodeValue() == null ? null : metaAnnotations.getNodeValue().getUid()), annotations == null ? null : (annotations.getNodeValue() == null ? null : annotations.getNodeValue().getUid()), startLocation, stopLocation));
        }
        return ret;
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
        ConstructorModifiersNode ret = new ConstructorModifiersNodeImpl(access, this.<MetaAnnotationListNode>makeNormalNodeUnion(metaAnnotations), this.<AnnotationListNode>makeNormalNodeUnion(annotations), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateConstructorModifiersNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), access, metaAnnotations == null ? null : metaAnnotations.getUid(), annotations == null ? null : annotations.getUid(), startLocation, stopLocation));
        }
        return ret;
    }
    
    /**
     * Creates a ConstructorModifiersNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public ConstructorModifiersNode makeConstructorModifiersNode(
            AccessModifier access)
    {
        ConstructorModifiersNode ret = new ConstructorModifiersNodeImpl(access, this.<MetaAnnotationListNode>makeNormalNodeUnion(makeMetaAnnotationListNode()), this.<AnnotationListNode>makeNormalNodeUnion(makeAnnotationListNode()), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateConstructorModifiersNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), access, ret.getMetaAnnotations() == null ? null : ret.getMetaAnnotations().getUid(), ret.getAnnotations() == null ? null : ret.getAnnotations().getUid(), startLocation, stopLocation));
        }
        return ret;
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
        ConstructorModifiersNode ret = new ConstructorModifiersNodeImpl(access, this.<MetaAnnotationListNode>makeNormalNodeUnion(makeMetaAnnotationListNode()), this.<AnnotationListNode>makeNormalNodeUnion(makeAnnotationListNode()), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateConstructorModifiersNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), access, ret.getMetaAnnotations() == null ? null : ret.getMetaAnnotations().getUid(), ret.getAnnotations() == null ? null : ret.getAnnotations().getUid(), startLocation, stopLocation));
        }
        return ret;
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
        ContinueNode ret = new ContinueNodeImpl(label, metaAnnotations, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateContinueNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), label == null ? null : (label.getNodeValue() == null ? null : label.getNodeValue().getUid()), metaAnnotations == null ? null : (metaAnnotations.getNodeValue() == null ? null : metaAnnotations.getNodeValue().getUid()), startLocation, stopLocation));
        }
        return ret;
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
        ContinueNode ret = new ContinueNodeImpl(this.<IdentifierNode>makeNormalNodeUnion(label), this.<MetaAnnotationListNode>makeNormalNodeUnion(metaAnnotations), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateContinueNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), label == null ? null : label.getUid(), metaAnnotations == null ? null : metaAnnotations.getUid(), startLocation, stopLocation));
        }
        return ret;
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
        ContinueNode ret = new ContinueNodeImpl(label, metaAnnotations, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateContinueNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), label == null ? null : (label.getNodeValue() == null ? null : label.getNodeValue().getUid()), metaAnnotations == null ? null : (metaAnnotations.getNodeValue() == null ? null : metaAnnotations.getNodeValue().getUid()), startLocation, stopLocation));
        }
        return ret;
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
        ContinueNode ret = new ContinueNodeImpl(this.<IdentifierNode>makeNormalNodeUnion(label), this.<MetaAnnotationListNode>makeNormalNodeUnion(metaAnnotations), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateContinueNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), label == null ? null : label.getUid(), metaAnnotations == null ? null : metaAnnotations.getUid(), startLocation, stopLocation));
        }
        return ret;
    }
    
    /**
     * Creates a ContinueNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public ContinueNode makeContinueNode()
    {
        ContinueNode ret = new ContinueNodeImpl(this.<IdentifierNode>makeNormalNodeUnion(null), this.<MetaAnnotationListNode>makeNormalNodeUnion(makeMetaAnnotationListNode()), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateContinueNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), ret.getLabel() == null ? null : ret.getLabel().getUid(), ret.getMetaAnnotations() == null ? null : ret.getMetaAnnotations().getUid(), startLocation, stopLocation));
        }
        return ret;
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
        ContinueNode ret = new ContinueNodeImpl(this.<IdentifierNode>makeNormalNodeUnion(null), this.<MetaAnnotationListNode>makeNormalNodeUnion(makeMetaAnnotationListNode()), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateContinueNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), ret.getLabel() == null ? null : ret.getLabel().getUid(), ret.getMetaAnnotations() == null ? null : ret.getMetaAnnotations().getUid(), startLocation, stopLocation));
        }
        return ret;
    }
    
    /**
     * Creates a ContinueNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public ContinueNode makeContinueNode(
            IdentifierNode label)
    {
        ContinueNode ret = new ContinueNodeImpl(this.<IdentifierNode>makeNormalNodeUnion(label), this.<MetaAnnotationListNode>makeNormalNodeUnion(makeMetaAnnotationListNode()), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateContinueNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), label == null ? null : label.getUid(), ret.getMetaAnnotations() == null ? null : ret.getMetaAnnotations().getUid(), startLocation, stopLocation));
        }
        return ret;
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
        ContinueNode ret = new ContinueNodeImpl(this.<IdentifierNode>makeNormalNodeUnion(label), this.<MetaAnnotationListNode>makeNormalNodeUnion(makeMetaAnnotationListNode()), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateContinueNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), label == null ? null : label.getUid(), ret.getMetaAnnotations() == null ? null : ret.getMetaAnnotations().getUid(), startLocation, stopLocation));
        }
        return ret;
    }
    
    /**
     * Creates a DeclaredTypeListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public DeclaredTypeListNode makeDeclaredTypeListNodeWithUnions(
            List<NodeUnion<? extends DeclaredTypeNode>> children)
    {
        DeclaredTypeListNode ret = new DeclaredTypeListNodeImpl(children, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateDeclaredTypeListNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), EditScriptUtilities.getNodeUnionUids(children), startLocation, stopLocation));
        }
        return ret;
    }
    
    /**
     * Creates a DeclaredTypeListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public DeclaredTypeListNode makeDeclaredTypeListNode(
            List<DeclaredTypeNode> children)
    {
        DeclaredTypeListNode ret = new DeclaredTypeListNodeImpl(unionWrapList(children), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateDeclaredTypeListNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), EditScriptUtilities.getNodeUids(children), startLocation, stopLocation));
        }
        return ret;
    }
    
    /**
     * Creates a DeclaredTypeListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public DeclaredTypeListNode makeDeclaredTypeListNode(
            DeclaredTypeNode... childrenElements)
    {
        List<DeclaredTypeNode> children = Arrays.asList(childrenElements);
        return makeDeclaredTypeListNode(children, startLocation, stopLocation);
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
        DeclaredTypeListNode ret = new DeclaredTypeListNodeImpl(children, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateDeclaredTypeListNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), EditScriptUtilities.getNodeUnionUids(children), startLocation, stopLocation));
        }
        return ret;
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
        DeclaredTypeListNode ret = new DeclaredTypeListNodeImpl(unionWrapList(children), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateDeclaredTypeListNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), EditScriptUtilities.getNodeUids(children), startLocation, stopLocation));
        }
        return ret;
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
        List<DeclaredTypeNode> children = Arrays.asList(childrenElements);
        return makeDeclaredTypeListNode(children, startLocation, stopLocation);
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
        DoWhileLoopNode ret = new DoWhileLoopNodeImpl(condition, statement, metaAnnotations, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateDoWhileLoopNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), condition == null ? null : (condition.getNodeValue() == null ? null : condition.getNodeValue().getUid()), statement == null ? null : (statement.getNodeValue() == null ? null : statement.getNodeValue().getUid()), metaAnnotations == null ? null : (metaAnnotations.getNodeValue() == null ? null : metaAnnotations.getNodeValue().getUid()), startLocation, stopLocation));
        }
        return ret;
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
        DoWhileLoopNode ret = new DoWhileLoopNodeImpl(this.<ExpressionNode>makeNormalNodeUnion(condition), this.<StatementNode>makeNormalNodeUnion(statement), this.<MetaAnnotationListNode>makeNormalNodeUnion(metaAnnotations), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateDoWhileLoopNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), condition == null ? null : condition.getUid(), statement == null ? null : statement.getUid(), metaAnnotations == null ? null : metaAnnotations.getUid(), startLocation, stopLocation));
        }
        return ret;
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
        DoWhileLoopNode ret = new DoWhileLoopNodeImpl(condition, statement, metaAnnotations, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateDoWhileLoopNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), condition == null ? null : (condition.getNodeValue() == null ? null : condition.getNodeValue().getUid()), statement == null ? null : (statement.getNodeValue() == null ? null : statement.getNodeValue().getUid()), metaAnnotations == null ? null : (metaAnnotations.getNodeValue() == null ? null : metaAnnotations.getNodeValue().getUid()), startLocation, stopLocation));
        }
        return ret;
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
        DoWhileLoopNode ret = new DoWhileLoopNodeImpl(this.<ExpressionNode>makeNormalNodeUnion(condition), this.<StatementNode>makeNormalNodeUnion(statement), this.<MetaAnnotationListNode>makeNormalNodeUnion(metaAnnotations), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateDoWhileLoopNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), condition == null ? null : condition.getUid(), statement == null ? null : statement.getUid(), metaAnnotations == null ? null : metaAnnotations.getUid(), startLocation, stopLocation));
        }
        return ret;
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
        DoWhileLoopNode ret = new DoWhileLoopNodeImpl(this.<ExpressionNode>makeNormalNodeUnion(condition), this.<StatementNode>makeNormalNodeUnion(statement), this.<MetaAnnotationListNode>makeNormalNodeUnion(makeMetaAnnotationListNode()), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateDoWhileLoopNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), condition == null ? null : condition.getUid(), statement == null ? null : statement.getUid(), ret.getMetaAnnotations() == null ? null : ret.getMetaAnnotations().getUid(), startLocation, stopLocation));
        }
        return ret;
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
        DoWhileLoopNode ret = new DoWhileLoopNodeImpl(this.<ExpressionNode>makeNormalNodeUnion(condition), this.<StatementNode>makeNormalNodeUnion(statement), this.<MetaAnnotationListNode>makeNormalNodeUnion(makeMetaAnnotationListNode()), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateDoWhileLoopNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), condition == null ? null : condition.getUid(), statement == null ? null : statement.getUid(), ret.getMetaAnnotations() == null ? null : ret.getMetaAnnotations().getUid(), startLocation, stopLocation));
        }
        return ret;
    }
    
    /**
     * Creates a DoubleLiteralNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public DoubleLiteralNode makeDoubleLiteralNode(
            Double value)
    {
        DoubleLiteralNode ret = new DoubleLiteralNodeImpl(value, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateDoubleLiteralNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), value, startLocation, stopLocation));
        }
        return ret;
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
        DoubleLiteralNode ret = new DoubleLiteralNodeImpl(value, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateDoubleLiteralNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), value, startLocation, stopLocation));
        }
        return ret;
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
        EnhancedForLoopNode ret = new EnhancedForLoopNodeImpl(variable, expression, statement, metaAnnotations, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateEnhancedForLoopNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), variable == null ? null : (variable.getNodeValue() == null ? null : variable.getNodeValue().getUid()), expression == null ? null : (expression.getNodeValue() == null ? null : expression.getNodeValue().getUid()), statement == null ? null : (statement.getNodeValue() == null ? null : statement.getNodeValue().getUid()), metaAnnotations == null ? null : (metaAnnotations.getNodeValue() == null ? null : metaAnnotations.getNodeValue().getUid()), startLocation, stopLocation));
        }
        return ret;
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
        EnhancedForLoopNode ret = new EnhancedForLoopNodeImpl(this.<VariableNode>makeNormalNodeUnion(variable), this.<ExpressionNode>makeNormalNodeUnion(expression), this.<StatementNode>makeNormalNodeUnion(statement), this.<MetaAnnotationListNode>makeNormalNodeUnion(metaAnnotations), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateEnhancedForLoopNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), variable == null ? null : variable.getUid(), expression == null ? null : expression.getUid(), statement == null ? null : statement.getUid(), metaAnnotations == null ? null : metaAnnotations.getUid(), startLocation, stopLocation));
        }
        return ret;
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
        EnhancedForLoopNode ret = new EnhancedForLoopNodeImpl(variable, expression, statement, metaAnnotations, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateEnhancedForLoopNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), variable == null ? null : (variable.getNodeValue() == null ? null : variable.getNodeValue().getUid()), expression == null ? null : (expression.getNodeValue() == null ? null : expression.getNodeValue().getUid()), statement == null ? null : (statement.getNodeValue() == null ? null : statement.getNodeValue().getUid()), metaAnnotations == null ? null : (metaAnnotations.getNodeValue() == null ? null : metaAnnotations.getNodeValue().getUid()), startLocation, stopLocation));
        }
        return ret;
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
        EnhancedForLoopNode ret = new EnhancedForLoopNodeImpl(this.<VariableNode>makeNormalNodeUnion(variable), this.<ExpressionNode>makeNormalNodeUnion(expression), this.<StatementNode>makeNormalNodeUnion(statement), this.<MetaAnnotationListNode>makeNormalNodeUnion(metaAnnotations), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateEnhancedForLoopNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), variable == null ? null : variable.getUid(), expression == null ? null : expression.getUid(), statement == null ? null : statement.getUid(), metaAnnotations == null ? null : metaAnnotations.getUid(), startLocation, stopLocation));
        }
        return ret;
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
        EnhancedForLoopNode ret = new EnhancedForLoopNodeImpl(this.<VariableNode>makeNormalNodeUnion(variable), this.<ExpressionNode>makeNormalNodeUnion(expression), this.<StatementNode>makeNormalNodeUnion(statement), this.<MetaAnnotationListNode>makeNormalNodeUnion(makeMetaAnnotationListNode()), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateEnhancedForLoopNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), variable == null ? null : variable.getUid(), expression == null ? null : expression.getUid(), statement == null ? null : statement.getUid(), ret.getMetaAnnotations() == null ? null : ret.getMetaAnnotations().getUid(), startLocation, stopLocation));
        }
        return ret;
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
        EnhancedForLoopNode ret = new EnhancedForLoopNodeImpl(this.<VariableNode>makeNormalNodeUnion(variable), this.<ExpressionNode>makeNormalNodeUnion(expression), this.<StatementNode>makeNormalNodeUnion(statement), this.<MetaAnnotationListNode>makeNormalNodeUnion(makeMetaAnnotationListNode()), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateEnhancedForLoopNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), variable == null ? null : variable.getUid(), expression == null ? null : expression.getUid(), statement == null ? null : statement.getUid(), ret.getMetaAnnotations() == null ? null : ret.getMetaAnnotations().getUid(), startLocation, stopLocation));
        }
        return ret;
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
        EnumBodyNode ret = new EnumBodyNodeImpl(constants, members, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateEnumBodyNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), constants == null ? null : (constants.getNodeValue() == null ? null : constants.getNodeValue().getUid()), members == null ? null : (members.getNodeValue() == null ? null : members.getNodeValue().getUid()), startLocation, stopLocation));
        }
        return ret;
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
        EnumBodyNode ret = new EnumBodyNodeImpl(this.<EnumConstantDeclarationListNode>makeNormalNodeUnion(constants), this.<ClassMemberListNode>makeNormalNodeUnion(members), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateEnumBodyNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), constants == null ? null : constants.getUid(), members == null ? null : members.getUid(), startLocation, stopLocation));
        }
        return ret;
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
        EnumBodyNode ret = new EnumBodyNodeImpl(constants, members, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateEnumBodyNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), constants == null ? null : (constants.getNodeValue() == null ? null : constants.getNodeValue().getUid()), members == null ? null : (members.getNodeValue() == null ? null : members.getNodeValue().getUid()), startLocation, stopLocation));
        }
        return ret;
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
        EnumBodyNode ret = new EnumBodyNodeImpl(this.<EnumConstantDeclarationListNode>makeNormalNodeUnion(constants), this.<ClassMemberListNode>makeNormalNodeUnion(members), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateEnumBodyNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), constants == null ? null : constants.getUid(), members == null ? null : members.getUid(), startLocation, stopLocation));
        }
        return ret;
    }
    
    /**
     * Creates a EnumConstantDeclarationListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public EnumConstantDeclarationListNode makeEnumConstantDeclarationListNodeWithUnions(
            List<NodeUnion<? extends EnumConstantDeclarationNode>> children)
    {
        EnumConstantDeclarationListNode ret = new EnumConstantDeclarationListNodeImpl(children, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateEnumConstantDeclarationListNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), EditScriptUtilities.getNodeUnionUids(children), startLocation, stopLocation));
        }
        return ret;
    }
    
    /**
     * Creates a EnumConstantDeclarationListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public EnumConstantDeclarationListNode makeEnumConstantDeclarationListNode(
            List<EnumConstantDeclarationNode> children)
    {
        EnumConstantDeclarationListNode ret = new EnumConstantDeclarationListNodeImpl(unionWrapList(children), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateEnumConstantDeclarationListNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), EditScriptUtilities.getNodeUids(children), startLocation, stopLocation));
        }
        return ret;
    }
    
    /**
     * Creates a EnumConstantDeclarationListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public EnumConstantDeclarationListNode makeEnumConstantDeclarationListNode(
            EnumConstantDeclarationNode... childrenElements)
    {
        List<EnumConstantDeclarationNode> children = Arrays.asList(childrenElements);
        return makeEnumConstantDeclarationListNode(children, startLocation, stopLocation);
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
        EnumConstantDeclarationListNode ret = new EnumConstantDeclarationListNodeImpl(children, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateEnumConstantDeclarationListNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), EditScriptUtilities.getNodeUnionUids(children), startLocation, stopLocation));
        }
        return ret;
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
        EnumConstantDeclarationListNode ret = new EnumConstantDeclarationListNodeImpl(unionWrapList(children), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateEnumConstantDeclarationListNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), EditScriptUtilities.getNodeUids(children), startLocation, stopLocation));
        }
        return ret;
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
        List<EnumConstantDeclarationNode> children = Arrays.asList(childrenElements);
        return makeEnumConstantDeclarationListNode(children, startLocation, stopLocation);
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
        EnumConstantDeclarationNode ret = new EnumConstantDeclarationNodeImpl(modifiers, identifier, arguments, body, javadoc, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateEnumConstantDeclarationNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), modifiers == null ? null : (modifiers.getNodeValue() == null ? null : modifiers.getNodeValue().getUid()), identifier == null ? null : (identifier.getNodeValue() == null ? null : identifier.getNodeValue().getUid()), arguments == null ? null : (arguments.getNodeValue() == null ? null : arguments.getNodeValue().getUid()), body == null ? null : (body.getNodeValue() == null ? null : body.getNodeValue().getUid()), javadoc == null ? null : (javadoc.getNodeValue() == null ? null : javadoc.getNodeValue().getUid()), startLocation, stopLocation));
        }
        return ret;
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
        EnumConstantDeclarationNode ret = new EnumConstantDeclarationNodeImpl(this.<EnumConstantModifiersNode>makeNormalNodeUnion(modifiers), this.<IdentifierNode>makeNormalNodeUnion(identifier), this.<ExpressionListNode>makeNormalNodeUnion(arguments), this.<AnonymousClassBodyNode>makeNormalNodeUnion(body), this.<JavadocNode>makeNormalNodeUnion(javadoc), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateEnumConstantDeclarationNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), modifiers == null ? null : modifiers.getUid(), identifier == null ? null : identifier.getUid(), arguments == null ? null : arguments.getUid(), body == null ? null : body.getUid(), javadoc == null ? null : javadoc.getUid(), startLocation, stopLocation));
        }
        return ret;
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
        EnumConstantDeclarationNode ret = new EnumConstantDeclarationNodeImpl(modifiers, identifier, arguments, body, javadoc, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateEnumConstantDeclarationNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), modifiers == null ? null : (modifiers.getNodeValue() == null ? null : modifiers.getNodeValue().getUid()), identifier == null ? null : (identifier.getNodeValue() == null ? null : identifier.getNodeValue().getUid()), arguments == null ? null : (arguments.getNodeValue() == null ? null : arguments.getNodeValue().getUid()), body == null ? null : (body.getNodeValue() == null ? null : body.getNodeValue().getUid()), javadoc == null ? null : (javadoc.getNodeValue() == null ? null : javadoc.getNodeValue().getUid()), startLocation, stopLocation));
        }
        return ret;
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
        EnumConstantDeclarationNode ret = new EnumConstantDeclarationNodeImpl(this.<EnumConstantModifiersNode>makeNormalNodeUnion(modifiers), this.<IdentifierNode>makeNormalNodeUnion(identifier), this.<ExpressionListNode>makeNormalNodeUnion(arguments), this.<AnonymousClassBodyNode>makeNormalNodeUnion(body), this.<JavadocNode>makeNormalNodeUnion(javadoc), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateEnumConstantDeclarationNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), modifiers == null ? null : modifiers.getUid(), identifier == null ? null : identifier.getUid(), arguments == null ? null : arguments.getUid(), body == null ? null : body.getUid(), javadoc == null ? null : javadoc.getUid(), startLocation, stopLocation));
        }
        return ret;
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
        EnumConstantDeclarationNode ret = new EnumConstantDeclarationNodeImpl(this.<EnumConstantModifiersNode>makeNormalNodeUnion(modifiers), this.<IdentifierNode>makeNormalNodeUnion(identifier), this.<ExpressionListNode>makeNormalNodeUnion(arguments), this.<AnonymousClassBodyNode>makeNormalNodeUnion(null), this.<JavadocNode>makeNormalNodeUnion(javadoc), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateEnumConstantDeclarationNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), modifiers == null ? null : modifiers.getUid(), identifier == null ? null : identifier.getUid(), arguments == null ? null : arguments.getUid(), ret.getBody() == null ? null : ret.getBody().getUid(), javadoc == null ? null : javadoc.getUid(), startLocation, stopLocation));
        }
        return ret;
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
        EnumConstantDeclarationNode ret = new EnumConstantDeclarationNodeImpl(this.<EnumConstantModifiersNode>makeNormalNodeUnion(modifiers), this.<IdentifierNode>makeNormalNodeUnion(identifier), this.<ExpressionListNode>makeNormalNodeUnion(arguments), this.<AnonymousClassBodyNode>makeNormalNodeUnion(null), this.<JavadocNode>makeNormalNodeUnion(javadoc), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateEnumConstantDeclarationNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), modifiers == null ? null : modifiers.getUid(), identifier == null ? null : identifier.getUid(), arguments == null ? null : arguments.getUid(), ret.getBody() == null ? null : ret.getBody().getUid(), javadoc == null ? null : javadoc.getUid(), startLocation, stopLocation));
        }
        return ret;
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
        EnumConstantModifiersNode ret = new EnumConstantModifiersNodeImpl(metaAnnotations, annotations, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateEnumConstantModifiersNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), metaAnnotations == null ? null : (metaAnnotations.getNodeValue() == null ? null : metaAnnotations.getNodeValue().getUid()), annotations == null ? null : (annotations.getNodeValue() == null ? null : annotations.getNodeValue().getUid()), startLocation, stopLocation));
        }
        return ret;
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
        EnumConstantModifiersNode ret = new EnumConstantModifiersNodeImpl(this.<MetaAnnotationListNode>makeNormalNodeUnion(metaAnnotations), this.<AnnotationListNode>makeNormalNodeUnion(annotations), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateEnumConstantModifiersNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), metaAnnotations == null ? null : metaAnnotations.getUid(), annotations == null ? null : annotations.getUid(), startLocation, stopLocation));
        }
        return ret;
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
        EnumConstantModifiersNode ret = new EnumConstantModifiersNodeImpl(metaAnnotations, annotations, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateEnumConstantModifiersNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), metaAnnotations == null ? null : (metaAnnotations.getNodeValue() == null ? null : metaAnnotations.getNodeValue().getUid()), annotations == null ? null : (annotations.getNodeValue() == null ? null : annotations.getNodeValue().getUid()), startLocation, stopLocation));
        }
        return ret;
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
        EnumConstantModifiersNode ret = new EnumConstantModifiersNodeImpl(this.<MetaAnnotationListNode>makeNormalNodeUnion(metaAnnotations), this.<AnnotationListNode>makeNormalNodeUnion(annotations), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateEnumConstantModifiersNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), metaAnnotations == null ? null : metaAnnotations.getUid(), annotations == null ? null : annotations.getUid(), startLocation, stopLocation));
        }
        return ret;
    }
    
    /**
     * Creates a EnumConstantModifiersNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public EnumConstantModifiersNode makeEnumConstantModifiersNode(
    )
    {
        EnumConstantModifiersNode ret = new EnumConstantModifiersNodeImpl(this.<MetaAnnotationListNode>makeNormalNodeUnion(makeMetaAnnotationListNode()), this.<AnnotationListNode>makeNormalNodeUnion(makeAnnotationListNode()), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateEnumConstantModifiersNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), ret.getMetaAnnotations() == null ? null : ret.getMetaAnnotations().getUid(), ret.getAnnotations() == null ? null : ret.getAnnotations().getUid(), startLocation, stopLocation));
        }
        return ret;
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
        EnumConstantModifiersNode ret = new EnumConstantModifiersNodeImpl(this.<MetaAnnotationListNode>makeNormalNodeUnion(makeMetaAnnotationListNode()), this.<AnnotationListNode>makeNormalNodeUnion(makeAnnotationListNode()), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateEnumConstantModifiersNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), ret.getMetaAnnotations() == null ? null : ret.getMetaAnnotations().getUid(), ret.getAnnotations() == null ? null : ret.getAnnotations().getUid(), startLocation, stopLocation));
        }
        return ret;
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
        EnumDeclarationNode ret = new EnumDeclarationNodeImpl(modifiers, implementsClause, body, identifier, javadoc, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateEnumDeclarationNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), modifiers == null ? null : (modifiers.getNodeValue() == null ? null : modifiers.getNodeValue().getUid()), implementsClause == null ? null : (implementsClause.getNodeValue() == null ? null : implementsClause.getNodeValue().getUid()), body == null ? null : (body.getNodeValue() == null ? null : body.getNodeValue().getUid()), identifier == null ? null : (identifier.getNodeValue() == null ? null : identifier.getNodeValue().getUid()), javadoc == null ? null : (javadoc.getNodeValue() == null ? null : javadoc.getNodeValue().getUid()), startLocation, stopLocation));
        }
        return ret;
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
        EnumDeclarationNode ret = new EnumDeclarationNodeImpl(this.<EnumModifiersNode>makeNormalNodeUnion(modifiers), this.<DeclaredTypeListNode>makeNormalNodeUnion(implementsClause), this.<EnumBodyNode>makeNormalNodeUnion(body), this.<IdentifierNode>makeNormalNodeUnion(identifier), this.<JavadocNode>makeNormalNodeUnion(javadoc), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateEnumDeclarationNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), modifiers == null ? null : modifiers.getUid(), implementsClause == null ? null : implementsClause.getUid(), body == null ? null : body.getUid(), identifier == null ? null : identifier.getUid(), javadoc == null ? null : javadoc.getUid(), startLocation, stopLocation));
        }
        return ret;
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
        EnumDeclarationNode ret = new EnumDeclarationNodeImpl(modifiers, implementsClause, body, identifier, javadoc, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateEnumDeclarationNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), modifiers == null ? null : (modifiers.getNodeValue() == null ? null : modifiers.getNodeValue().getUid()), implementsClause == null ? null : (implementsClause.getNodeValue() == null ? null : implementsClause.getNodeValue().getUid()), body == null ? null : (body.getNodeValue() == null ? null : body.getNodeValue().getUid()), identifier == null ? null : (identifier.getNodeValue() == null ? null : identifier.getNodeValue().getUid()), javadoc == null ? null : (javadoc.getNodeValue() == null ? null : javadoc.getNodeValue().getUid()), startLocation, stopLocation));
        }
        return ret;
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
        EnumDeclarationNode ret = new EnumDeclarationNodeImpl(this.<EnumModifiersNode>makeNormalNodeUnion(modifiers), this.<DeclaredTypeListNode>makeNormalNodeUnion(implementsClause), this.<EnumBodyNode>makeNormalNodeUnion(body), this.<IdentifierNode>makeNormalNodeUnion(identifier), this.<JavadocNode>makeNormalNodeUnion(javadoc), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateEnumDeclarationNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), modifiers == null ? null : modifiers.getUid(), implementsClause == null ? null : implementsClause.getUid(), body == null ? null : body.getUid(), identifier == null ? null : identifier.getUid(), javadoc == null ? null : javadoc.getUid(), startLocation, stopLocation));
        }
        return ret;
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
        EnumModifiersNode ret = new EnumModifiersNodeImpl(access, strictfpFlag, metaAnnotations, annotations, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateEnumModifiersNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), access, strictfpFlag, metaAnnotations == null ? null : (metaAnnotations.getNodeValue() == null ? null : metaAnnotations.getNodeValue().getUid()), annotations == null ? null : (annotations.getNodeValue() == null ? null : annotations.getNodeValue().getUid()), startLocation, stopLocation));
        }
        return ret;
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
        EnumModifiersNode ret = new EnumModifiersNodeImpl(access, strictfpFlag, this.<MetaAnnotationListNode>makeNormalNodeUnion(metaAnnotations), this.<AnnotationListNode>makeNormalNodeUnion(annotations), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateEnumModifiersNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), access, strictfpFlag, metaAnnotations == null ? null : metaAnnotations.getUid(), annotations == null ? null : annotations.getUid(), startLocation, stopLocation));
        }
        return ret;
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
        EnumModifiersNode ret = new EnumModifiersNodeImpl(access, strictfpFlag, metaAnnotations, annotations, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateEnumModifiersNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), access, strictfpFlag, metaAnnotations == null ? null : (metaAnnotations.getNodeValue() == null ? null : metaAnnotations.getNodeValue().getUid()), annotations == null ? null : (annotations.getNodeValue() == null ? null : annotations.getNodeValue().getUid()), startLocation, stopLocation));
        }
        return ret;
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
        EnumModifiersNode ret = new EnumModifiersNodeImpl(access, strictfpFlag, this.<MetaAnnotationListNode>makeNormalNodeUnion(metaAnnotations), this.<AnnotationListNode>makeNormalNodeUnion(annotations), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateEnumModifiersNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), access, strictfpFlag, metaAnnotations == null ? null : metaAnnotations.getUid(), annotations == null ? null : annotations.getUid(), startLocation, stopLocation));
        }
        return ret;
    }
    
    /**
     * Creates a EnumModifiersNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public EnumModifiersNode makeEnumModifiersNode(
            AccessModifier access)
    {
        EnumModifiersNode ret = new EnumModifiersNodeImpl(access, false, this.<MetaAnnotationListNode>makeNormalNodeUnion(makeMetaAnnotationListNode()), this.<AnnotationListNode>makeNormalNodeUnion(makeAnnotationListNode()), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateEnumModifiersNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), access, ret.getStrictfpFlag(), ret.getMetaAnnotations() == null ? null : ret.getMetaAnnotations().getUid(), ret.getAnnotations() == null ? null : ret.getAnnotations().getUid(), startLocation, stopLocation));
        }
        return ret;
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
        EnumModifiersNode ret = new EnumModifiersNodeImpl(access, false, this.<MetaAnnotationListNode>makeNormalNodeUnion(makeMetaAnnotationListNode()), this.<AnnotationListNode>makeNormalNodeUnion(makeAnnotationListNode()), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateEnumModifiersNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), access, ret.getStrictfpFlag(), ret.getMetaAnnotations() == null ? null : ret.getMetaAnnotations().getUid(), ret.getAnnotations() == null ? null : ret.getAnnotations().getUid(), startLocation, stopLocation));
        }
        return ret;
    }
    
    /**
     * Creates a ExpressionListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public ExpressionListNode makeExpressionListNodeWithUnions(
            List<NodeUnion<? extends ExpressionNode>> children)
    {
        ExpressionListNode ret = new ExpressionListNodeImpl(children, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateExpressionListNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), EditScriptUtilities.getNodeUnionUids(children), startLocation, stopLocation));
        }
        return ret;
    }
    
    /**
     * Creates a ExpressionListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public ExpressionListNode makeExpressionListNode(
            List<ExpressionNode> children)
    {
        ExpressionListNode ret = new ExpressionListNodeImpl(unionWrapList(children), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateExpressionListNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), EditScriptUtilities.getNodeUids(children), startLocation, stopLocation));
        }
        return ret;
    }
    
    /**
     * Creates a ExpressionListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public ExpressionListNode makeExpressionListNode(
            ExpressionNode... childrenElements)
    {
        List<ExpressionNode> children = Arrays.asList(childrenElements);
        return makeExpressionListNode(children, startLocation, stopLocation);
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
        ExpressionListNode ret = new ExpressionListNodeImpl(children, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateExpressionListNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), EditScriptUtilities.getNodeUnionUids(children), startLocation, stopLocation));
        }
        return ret;
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
        ExpressionListNode ret = new ExpressionListNodeImpl(unionWrapList(children), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateExpressionListNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), EditScriptUtilities.getNodeUids(children), startLocation, stopLocation));
        }
        return ret;
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
        List<ExpressionNode> children = Arrays.asList(childrenElements);
        return makeExpressionListNode(children, startLocation, stopLocation);
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
        ExpressionStatementNode ret = new ExpressionStatementNodeImpl(expression, metaAnnotations, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateExpressionStatementNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), expression == null ? null : (expression.getNodeValue() == null ? null : expression.getNodeValue().getUid()), metaAnnotations == null ? null : (metaAnnotations.getNodeValue() == null ? null : metaAnnotations.getNodeValue().getUid()), startLocation, stopLocation));
        }
        return ret;
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
        ExpressionStatementNode ret = new ExpressionStatementNodeImpl(this.<StatementExpressionNode>makeNormalNodeUnion(expression), this.<MetaAnnotationListNode>makeNormalNodeUnion(metaAnnotations), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateExpressionStatementNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), expression == null ? null : expression.getUid(), metaAnnotations == null ? null : metaAnnotations.getUid(), startLocation, stopLocation));
        }
        return ret;
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
        ExpressionStatementNode ret = new ExpressionStatementNodeImpl(expression, metaAnnotations, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateExpressionStatementNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), expression == null ? null : (expression.getNodeValue() == null ? null : expression.getNodeValue().getUid()), metaAnnotations == null ? null : (metaAnnotations.getNodeValue() == null ? null : metaAnnotations.getNodeValue().getUid()), startLocation, stopLocation));
        }
        return ret;
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
        ExpressionStatementNode ret = new ExpressionStatementNodeImpl(this.<StatementExpressionNode>makeNormalNodeUnion(expression), this.<MetaAnnotationListNode>makeNormalNodeUnion(metaAnnotations), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateExpressionStatementNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), expression == null ? null : expression.getUid(), metaAnnotations == null ? null : metaAnnotations.getUid(), startLocation, stopLocation));
        }
        return ret;
    }
    
    /**
     * Creates a ExpressionStatementNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public ExpressionStatementNode makeExpressionStatementNode(
            StatementExpressionNode expression)
    {
        ExpressionStatementNode ret = new ExpressionStatementNodeImpl(this.<StatementExpressionNode>makeNormalNodeUnion(expression), this.<MetaAnnotationListNode>makeNormalNodeUnion(makeMetaAnnotationListNode()), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateExpressionStatementNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), expression == null ? null : expression.getUid(), ret.getMetaAnnotations() == null ? null : ret.getMetaAnnotations().getUid(), startLocation, stopLocation));
        }
        return ret;
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
        ExpressionStatementNode ret = new ExpressionStatementNodeImpl(this.<StatementExpressionNode>makeNormalNodeUnion(expression), this.<MetaAnnotationListNode>makeNormalNodeUnion(makeMetaAnnotationListNode()), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateExpressionStatementNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), expression == null ? null : expression.getUid(), ret.getMetaAnnotations() == null ? null : ret.getMetaAnnotations().getUid(), startLocation, stopLocation));
        }
        return ret;
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
        FieldDeclarationNode ret = new FieldDeclarationNodeImpl(modifiers, type, declarators, javadoc, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateFieldDeclarationNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), modifiers == null ? null : (modifiers.getNodeValue() == null ? null : modifiers.getNodeValue().getUid()), type == null ? null : (type.getNodeValue() == null ? null : type.getNodeValue().getUid()), declarators == null ? null : (declarators.getNodeValue() == null ? null : declarators.getNodeValue().getUid()), javadoc == null ? null : (javadoc.getNodeValue() == null ? null : javadoc.getNodeValue().getUid()), startLocation, stopLocation));
        }
        return ret;
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
        FieldDeclarationNode ret = new FieldDeclarationNodeImpl(this.<FieldModifiersNode>makeNormalNodeUnion(modifiers), this.<TypeNode>makeNormalNodeUnion(type), this.<VariableDeclaratorListNode>makeNormalNodeUnion(declarators), this.<JavadocNode>makeNormalNodeUnion(javadoc), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateFieldDeclarationNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), modifiers == null ? null : modifiers.getUid(), type == null ? null : type.getUid(), declarators == null ? null : declarators.getUid(), javadoc == null ? null : javadoc.getUid(), startLocation, stopLocation));
        }
        return ret;
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
        FieldDeclarationNode ret = new FieldDeclarationNodeImpl(modifiers, type, declarators, javadoc, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateFieldDeclarationNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), modifiers == null ? null : (modifiers.getNodeValue() == null ? null : modifiers.getNodeValue().getUid()), type == null ? null : (type.getNodeValue() == null ? null : type.getNodeValue().getUid()), declarators == null ? null : (declarators.getNodeValue() == null ? null : declarators.getNodeValue().getUid()), javadoc == null ? null : (javadoc.getNodeValue() == null ? null : javadoc.getNodeValue().getUid()), startLocation, stopLocation));
        }
        return ret;
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
        FieldDeclarationNode ret = new FieldDeclarationNodeImpl(this.<FieldModifiersNode>makeNormalNodeUnion(modifiers), this.<TypeNode>makeNormalNodeUnion(type), this.<VariableDeclaratorListNode>makeNormalNodeUnion(declarators), this.<JavadocNode>makeNormalNodeUnion(javadoc), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateFieldDeclarationNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), modifiers == null ? null : modifiers.getUid(), type == null ? null : type.getUid(), declarators == null ? null : declarators.getUid(), javadoc == null ? null : javadoc.getUid(), startLocation, stopLocation));
        }
        return ret;
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
        FieldModifiersNode ret = new FieldModifiersNodeImpl(access, staticFlag, finalFlag, transientFlag, volatileFlag, metaAnnotations, annotations, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateFieldModifiersNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), access, staticFlag, finalFlag, transientFlag, volatileFlag, metaAnnotations == null ? null : (metaAnnotations.getNodeValue() == null ? null : metaAnnotations.getNodeValue().getUid()), annotations == null ? null : (annotations.getNodeValue() == null ? null : annotations.getNodeValue().getUid()), startLocation, stopLocation));
        }
        return ret;
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
        FieldModifiersNode ret = new FieldModifiersNodeImpl(access, staticFlag, finalFlag, transientFlag, volatileFlag, this.<MetaAnnotationListNode>makeNormalNodeUnion(metaAnnotations), this.<AnnotationListNode>makeNormalNodeUnion(annotations), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateFieldModifiersNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), access, staticFlag, finalFlag, transientFlag, volatileFlag, metaAnnotations == null ? null : metaAnnotations.getUid(), annotations == null ? null : annotations.getUid(), startLocation, stopLocation));
        }
        return ret;
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
        FieldModifiersNode ret = new FieldModifiersNodeImpl(access, staticFlag, finalFlag, transientFlag, volatileFlag, metaAnnotations, annotations, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateFieldModifiersNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), access, staticFlag, finalFlag, transientFlag, volatileFlag, metaAnnotations == null ? null : (metaAnnotations.getNodeValue() == null ? null : metaAnnotations.getNodeValue().getUid()), annotations == null ? null : (annotations.getNodeValue() == null ? null : annotations.getNodeValue().getUid()), startLocation, stopLocation));
        }
        return ret;
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
        FieldModifiersNode ret = new FieldModifiersNodeImpl(access, staticFlag, finalFlag, transientFlag, volatileFlag, this.<MetaAnnotationListNode>makeNormalNodeUnion(metaAnnotations), this.<AnnotationListNode>makeNormalNodeUnion(annotations), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateFieldModifiersNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), access, staticFlag, finalFlag, transientFlag, volatileFlag, metaAnnotations == null ? null : metaAnnotations.getUid(), annotations == null ? null : annotations.getUid(), startLocation, stopLocation));
        }
        return ret;
    }
    
    /**
     * Creates a FieldModifiersNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public FieldModifiersNode makeFieldModifiersNode(
            AccessModifier access)
    {
        FieldModifiersNode ret = new FieldModifiersNodeImpl(access, false, false, false, false, this.<MetaAnnotationListNode>makeNormalNodeUnion(makeMetaAnnotationListNode()), this.<AnnotationListNode>makeNormalNodeUnion(makeAnnotationListNode()), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateFieldModifiersNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), access, ret.getStaticFlag(), ret.getFinalFlag(), ret.getTransientFlag(), ret.getVolatileFlag(), ret.getMetaAnnotations() == null ? null : ret.getMetaAnnotations().getUid(), ret.getAnnotations() == null ? null : ret.getAnnotations().getUid(), startLocation, stopLocation));
        }
        return ret;
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
        FieldModifiersNode ret = new FieldModifiersNodeImpl(access, false, false, false, false, this.<MetaAnnotationListNode>makeNormalNodeUnion(makeMetaAnnotationListNode()), this.<AnnotationListNode>makeNormalNodeUnion(makeAnnotationListNode()), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateFieldModifiersNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), access, ret.getStaticFlag(), ret.getFinalFlag(), ret.getTransientFlag(), ret.getVolatileFlag(), ret.getMetaAnnotations() == null ? null : ret.getMetaAnnotations().getUid(), ret.getAnnotations() == null ? null : ret.getAnnotations().getUid(), startLocation, stopLocation));
        }
        return ret;
    }
    
    /**
     * Creates a FloatLiteralNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public FloatLiteralNode makeFloatLiteralNode(
            Float value)
    {
        FloatLiteralNode ret = new FloatLiteralNodeImpl(value, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateFloatLiteralNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), value, startLocation, stopLocation));
        }
        return ret;
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
        FloatLiteralNode ret = new FloatLiteralNodeImpl(value, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateFloatLiteralNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), value, startLocation, stopLocation));
        }
        return ret;
    }
    
    /**
     * Creates a ForInitializerDeclarationNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public ForInitializerDeclarationNode makeForInitializerDeclarationNodeWithUnions(
            NodeUnion<? extends LocalVariableDeclarationNode> declaration)
    {
        ForInitializerDeclarationNode ret = new ForInitializerDeclarationNodeImpl(declaration, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateForInitializerDeclarationNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), declaration == null ? null : (declaration.getNodeValue() == null ? null : declaration.getNodeValue().getUid()), startLocation, stopLocation));
        }
        return ret;
    }
    
    /**
     * Creates a ForInitializerDeclarationNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public ForInitializerDeclarationNode makeForInitializerDeclarationNode(
            LocalVariableDeclarationNode declaration)
    {
        ForInitializerDeclarationNode ret = new ForInitializerDeclarationNodeImpl(this.<LocalVariableDeclarationNode>makeNormalNodeUnion(declaration), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateForInitializerDeclarationNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), declaration == null ? null : declaration.getUid(), startLocation, stopLocation));
        }
        return ret;
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
        ForInitializerDeclarationNode ret = new ForInitializerDeclarationNodeImpl(declaration, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateForInitializerDeclarationNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), declaration == null ? null : (declaration.getNodeValue() == null ? null : declaration.getNodeValue().getUid()), startLocation, stopLocation));
        }
        return ret;
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
        ForInitializerDeclarationNode ret = new ForInitializerDeclarationNodeImpl(this.<LocalVariableDeclarationNode>makeNormalNodeUnion(declaration), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateForInitializerDeclarationNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), declaration == null ? null : declaration.getUid(), startLocation, stopLocation));
        }
        return ret;
    }
    
    /**
     * Creates a ForInitializerExpressionNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public ForInitializerExpressionNode makeForInitializerExpressionNodeWithUnions(
            NodeUnion<? extends StatementExpressionListNode> expressions)
    {
        ForInitializerExpressionNode ret = new ForInitializerExpressionNodeImpl(expressions, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateForInitializerExpressionNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), expressions == null ? null : (expressions.getNodeValue() == null ? null : expressions.getNodeValue().getUid()), startLocation, stopLocation));
        }
        return ret;
    }
    
    /**
     * Creates a ForInitializerExpressionNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public ForInitializerExpressionNode makeForInitializerExpressionNode(
            StatementExpressionListNode expressions)
    {
        ForInitializerExpressionNode ret = new ForInitializerExpressionNodeImpl(this.<StatementExpressionListNode>makeNormalNodeUnion(expressions), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateForInitializerExpressionNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), expressions == null ? null : expressions.getUid(), startLocation, stopLocation));
        }
        return ret;
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
        ForInitializerExpressionNode ret = new ForInitializerExpressionNodeImpl(expressions, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateForInitializerExpressionNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), expressions == null ? null : (expressions.getNodeValue() == null ? null : expressions.getNodeValue().getUid()), startLocation, stopLocation));
        }
        return ret;
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
        ForInitializerExpressionNode ret = new ForInitializerExpressionNodeImpl(this.<StatementExpressionListNode>makeNormalNodeUnion(expressions), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateForInitializerExpressionNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), expressions == null ? null : expressions.getUid(), startLocation, stopLocation));
        }
        return ret;
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
        ForLoopNode ret = new ForLoopNodeImpl(initializer, condition, update, statement, metaAnnotations, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateForLoopNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), initializer == null ? null : (initializer.getNodeValue() == null ? null : initializer.getNodeValue().getUid()), condition == null ? null : (condition.getNodeValue() == null ? null : condition.getNodeValue().getUid()), update == null ? null : (update.getNodeValue() == null ? null : update.getNodeValue().getUid()), statement == null ? null : (statement.getNodeValue() == null ? null : statement.getNodeValue().getUid()), metaAnnotations == null ? null : (metaAnnotations.getNodeValue() == null ? null : metaAnnotations.getNodeValue().getUid()), startLocation, stopLocation));
        }
        return ret;
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
        ForLoopNode ret = new ForLoopNodeImpl(this.<ForInitializerNode>makeNormalNodeUnion(initializer), this.<ExpressionNode>makeNormalNodeUnion(condition), this.<StatementExpressionListNode>makeNormalNodeUnion(update), this.<StatementNode>makeNormalNodeUnion(statement), this.<MetaAnnotationListNode>makeNormalNodeUnion(metaAnnotations), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateForLoopNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), initializer == null ? null : initializer.getUid(), condition == null ? null : condition.getUid(), update == null ? null : update.getUid(), statement == null ? null : statement.getUid(), metaAnnotations == null ? null : metaAnnotations.getUid(), startLocation, stopLocation));
        }
        return ret;
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
        ForLoopNode ret = new ForLoopNodeImpl(initializer, condition, update, statement, metaAnnotations, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateForLoopNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), initializer == null ? null : (initializer.getNodeValue() == null ? null : initializer.getNodeValue().getUid()), condition == null ? null : (condition.getNodeValue() == null ? null : condition.getNodeValue().getUid()), update == null ? null : (update.getNodeValue() == null ? null : update.getNodeValue().getUid()), statement == null ? null : (statement.getNodeValue() == null ? null : statement.getNodeValue().getUid()), metaAnnotations == null ? null : (metaAnnotations.getNodeValue() == null ? null : metaAnnotations.getNodeValue().getUid()), startLocation, stopLocation));
        }
        return ret;
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
        ForLoopNode ret = new ForLoopNodeImpl(this.<ForInitializerNode>makeNormalNodeUnion(initializer), this.<ExpressionNode>makeNormalNodeUnion(condition), this.<StatementExpressionListNode>makeNormalNodeUnion(update), this.<StatementNode>makeNormalNodeUnion(statement), this.<MetaAnnotationListNode>makeNormalNodeUnion(metaAnnotations), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateForLoopNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), initializer == null ? null : initializer.getUid(), condition == null ? null : condition.getUid(), update == null ? null : update.getUid(), statement == null ? null : statement.getUid(), metaAnnotations == null ? null : metaAnnotations.getUid(), startLocation, stopLocation));
        }
        return ret;
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
        ForLoopNode ret = new ForLoopNodeImpl(this.<ForInitializerNode>makeNormalNodeUnion(initializer), this.<ExpressionNode>makeNormalNodeUnion(condition), this.<StatementExpressionListNode>makeNormalNodeUnion(update), this.<StatementNode>makeNormalNodeUnion(statement), this.<MetaAnnotationListNode>makeNormalNodeUnion(makeMetaAnnotationListNode()), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateForLoopNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), initializer == null ? null : initializer.getUid(), condition == null ? null : condition.getUid(), update == null ? null : update.getUid(), statement == null ? null : statement.getUid(), ret.getMetaAnnotations() == null ? null : ret.getMetaAnnotations().getUid(), startLocation, stopLocation));
        }
        return ret;
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
        ForLoopNode ret = new ForLoopNodeImpl(this.<ForInitializerNode>makeNormalNodeUnion(initializer), this.<ExpressionNode>makeNormalNodeUnion(condition), this.<StatementExpressionListNode>makeNormalNodeUnion(update), this.<StatementNode>makeNormalNodeUnion(statement), this.<MetaAnnotationListNode>makeNormalNodeUnion(makeMetaAnnotationListNode()), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateForLoopNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), initializer == null ? null : initializer.getUid(), condition == null ? null : condition.getUid(), update == null ? null : update.getUid(), statement == null ? null : statement.getUid(), ret.getMetaAnnotations() == null ? null : ret.getMetaAnnotations().getUid(), startLocation, stopLocation));
        }
        return ret;
    }
    
    /**
     * Creates a IdentifierListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public IdentifierListNode makeIdentifierListNodeWithUnions(
            List<NodeUnion<? extends IdentifierNode>> children)
    {
        IdentifierListNode ret = new IdentifierListNodeImpl(children, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateIdentifierListNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), EditScriptUtilities.getNodeUnionUids(children), startLocation, stopLocation));
        }
        return ret;
    }
    
    /**
     * Creates a IdentifierListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public IdentifierListNode makeIdentifierListNode(
            List<IdentifierNode> children)
    {
        IdentifierListNode ret = new IdentifierListNodeImpl(unionWrapList(children), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateIdentifierListNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), EditScriptUtilities.getNodeUids(children), startLocation, stopLocation));
        }
        return ret;
    }
    
    /**
     * Creates a IdentifierListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public IdentifierListNode makeIdentifierListNode(
            IdentifierNode... childrenElements)
    {
        List<IdentifierNode> children = Arrays.asList(childrenElements);
        return makeIdentifierListNode(children, startLocation, stopLocation);
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
        IdentifierListNode ret = new IdentifierListNodeImpl(children, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateIdentifierListNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), EditScriptUtilities.getNodeUnionUids(children), startLocation, stopLocation));
        }
        return ret;
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
        IdentifierListNode ret = new IdentifierListNodeImpl(unionWrapList(children), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateIdentifierListNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), EditScriptUtilities.getNodeUids(children), startLocation, stopLocation));
        }
        return ret;
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
        List<IdentifierNode> children = Arrays.asList(childrenElements);
        return makeIdentifierListNode(children, startLocation, stopLocation);
    }
    
    /**
     * Creates a IdentifierNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public IdentifierNode makeIdentifierNode(
            String identifier)
    {
        IdentifierNode ret = new IdentifierNodeImpl(identifier, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateIdentifierNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), identifier, startLocation, stopLocation));
        }
        return ret;
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
        IdentifierNode ret = new IdentifierNodeImpl(identifier, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateIdentifierNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), identifier, startLocation, stopLocation));
        }
        return ret;
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
        IfNode ret = new IfNodeImpl(condition, thenStatement, elseStatement, metaAnnotations, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateIfNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), condition == null ? null : (condition.getNodeValue() == null ? null : condition.getNodeValue().getUid()), thenStatement == null ? null : (thenStatement.getNodeValue() == null ? null : thenStatement.getNodeValue().getUid()), elseStatement == null ? null : (elseStatement.getNodeValue() == null ? null : elseStatement.getNodeValue().getUid()), metaAnnotations == null ? null : (metaAnnotations.getNodeValue() == null ? null : metaAnnotations.getNodeValue().getUid()), startLocation, stopLocation));
        }
        return ret;
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
        IfNode ret = new IfNodeImpl(this.<ExpressionNode>makeNormalNodeUnion(condition), this.<StatementNode>makeNormalNodeUnion(thenStatement), this.<StatementNode>makeNormalNodeUnion(elseStatement), this.<MetaAnnotationListNode>makeNormalNodeUnion(metaAnnotations), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateIfNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), condition == null ? null : condition.getUid(), thenStatement == null ? null : thenStatement.getUid(), elseStatement == null ? null : elseStatement.getUid(), metaAnnotations == null ? null : metaAnnotations.getUid(), startLocation, stopLocation));
        }
        return ret;
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
        IfNode ret = new IfNodeImpl(condition, thenStatement, elseStatement, metaAnnotations, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateIfNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), condition == null ? null : (condition.getNodeValue() == null ? null : condition.getNodeValue().getUid()), thenStatement == null ? null : (thenStatement.getNodeValue() == null ? null : thenStatement.getNodeValue().getUid()), elseStatement == null ? null : (elseStatement.getNodeValue() == null ? null : elseStatement.getNodeValue().getUid()), metaAnnotations == null ? null : (metaAnnotations.getNodeValue() == null ? null : metaAnnotations.getNodeValue().getUid()), startLocation, stopLocation));
        }
        return ret;
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
        IfNode ret = new IfNodeImpl(this.<ExpressionNode>makeNormalNodeUnion(condition), this.<StatementNode>makeNormalNodeUnion(thenStatement), this.<StatementNode>makeNormalNodeUnion(elseStatement), this.<MetaAnnotationListNode>makeNormalNodeUnion(metaAnnotations), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateIfNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), condition == null ? null : condition.getUid(), thenStatement == null ? null : thenStatement.getUid(), elseStatement == null ? null : elseStatement.getUid(), metaAnnotations == null ? null : metaAnnotations.getUid(), startLocation, stopLocation));
        }
        return ret;
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
        IfNode ret = new IfNodeImpl(this.<ExpressionNode>makeNormalNodeUnion(condition), this.<StatementNode>makeNormalNodeUnion(thenStatement), this.<StatementNode>makeNormalNodeUnion(elseStatement), this.<MetaAnnotationListNode>makeNormalNodeUnion(makeMetaAnnotationListNode()), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateIfNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), condition == null ? null : condition.getUid(), thenStatement == null ? null : thenStatement.getUid(), elseStatement == null ? null : elseStatement.getUid(), ret.getMetaAnnotations() == null ? null : ret.getMetaAnnotations().getUid(), startLocation, stopLocation));
        }
        return ret;
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
        IfNode ret = new IfNodeImpl(this.<ExpressionNode>makeNormalNodeUnion(condition), this.<StatementNode>makeNormalNodeUnion(thenStatement), this.<StatementNode>makeNormalNodeUnion(elseStatement), this.<MetaAnnotationListNode>makeNormalNodeUnion(makeMetaAnnotationListNode()), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateIfNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), condition == null ? null : condition.getUid(), thenStatement == null ? null : thenStatement.getUid(), elseStatement == null ? null : elseStatement.getUid(), ret.getMetaAnnotations() == null ? null : ret.getMetaAnnotations().getUid(), startLocation, stopLocation));
        }
        return ret;
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
        IfNode ret = new IfNodeImpl(this.<ExpressionNode>makeNormalNodeUnion(condition), this.<StatementNode>makeNormalNodeUnion(thenStatement), this.<StatementNode>makeNormalNodeUnion(null), this.<MetaAnnotationListNode>makeNormalNodeUnion(makeMetaAnnotationListNode()), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateIfNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), condition == null ? null : condition.getUid(), thenStatement == null ? null : thenStatement.getUid(), ret.getElseStatement() == null ? null : ret.getElseStatement().getUid(), ret.getMetaAnnotations() == null ? null : ret.getMetaAnnotations().getUid(), startLocation, stopLocation));
        }
        return ret;
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
        IfNode ret = new IfNodeImpl(this.<ExpressionNode>makeNormalNodeUnion(condition), this.<StatementNode>makeNormalNodeUnion(thenStatement), this.<StatementNode>makeNormalNodeUnion(null), this.<MetaAnnotationListNode>makeNormalNodeUnion(makeMetaAnnotationListNode()), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateIfNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), condition == null ? null : condition.getUid(), thenStatement == null ? null : thenStatement.getUid(), ret.getElseStatement() == null ? null : ret.getElseStatement().getUid(), ret.getMetaAnnotations() == null ? null : ret.getMetaAnnotations().getUid(), startLocation, stopLocation));
        }
        return ret;
    }
    
    /**
     * Creates a ImportListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public ImportListNode makeImportListNodeWithUnions(
            List<NodeUnion<? extends ImportNode>> children)
    {
        ImportListNode ret = new ImportListNodeImpl(children, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateImportListNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), EditScriptUtilities.getNodeUnionUids(children), startLocation, stopLocation));
        }
        return ret;
    }
    
    /**
     * Creates a ImportListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public ImportListNode makeImportListNode(
            List<ImportNode> children)
    {
        ImportListNode ret = new ImportListNodeImpl(unionWrapList(children), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateImportListNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), EditScriptUtilities.getNodeUids(children), startLocation, stopLocation));
        }
        return ret;
    }
    
    /**
     * Creates a ImportListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public ImportListNode makeImportListNode(
            ImportNode... childrenElements)
    {
        List<ImportNode> children = Arrays.asList(childrenElements);
        return makeImportListNode(children, startLocation, stopLocation);
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
        ImportListNode ret = new ImportListNodeImpl(children, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateImportListNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), EditScriptUtilities.getNodeUnionUids(children), startLocation, stopLocation));
        }
        return ret;
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
        ImportListNode ret = new ImportListNodeImpl(unionWrapList(children), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateImportListNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), EditScriptUtilities.getNodeUids(children), startLocation, stopLocation));
        }
        return ret;
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
        List<ImportNode> children = Arrays.asList(childrenElements);
        return makeImportListNode(children, startLocation, stopLocation);
    }
    
    /**
     * Creates a ImportOnDemandNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public ImportOnDemandNode makeImportOnDemandNodeWithUnions(
            NodeUnion<? extends NameNode> name)
    {
        ImportOnDemandNode ret = new ImportOnDemandNodeImpl(name, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateImportOnDemandNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), name == null ? null : (name.getNodeValue() == null ? null : name.getNodeValue().getUid()), startLocation, stopLocation));
        }
        return ret;
    }
    
    /**
     * Creates a ImportOnDemandNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public ImportOnDemandNode makeImportOnDemandNode(
            NameNode name)
    {
        ImportOnDemandNode ret = new ImportOnDemandNodeImpl(this.<NameNode>makeNormalNodeUnion(name), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateImportOnDemandNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), name == null ? null : name.getUid(), startLocation, stopLocation));
        }
        return ret;
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
        ImportOnDemandNode ret = new ImportOnDemandNodeImpl(name, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateImportOnDemandNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), name == null ? null : (name.getNodeValue() == null ? null : name.getNodeValue().getUid()), startLocation, stopLocation));
        }
        return ret;
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
        ImportOnDemandNode ret = new ImportOnDemandNodeImpl(this.<NameNode>makeNormalNodeUnion(name), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateImportOnDemandNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), name == null ? null : name.getUid(), startLocation, stopLocation));
        }
        return ret;
    }
    
    /**
     * Creates a ImportSingleTypeNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public ImportSingleTypeNode makeImportSingleTypeNodeWithUnions(
            NodeUnion<? extends NameNode> name)
    {
        ImportSingleTypeNode ret = new ImportSingleTypeNodeImpl(name, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateImportSingleTypeNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), name == null ? null : (name.getNodeValue() == null ? null : name.getNodeValue().getUid()), startLocation, stopLocation));
        }
        return ret;
    }
    
    /**
     * Creates a ImportSingleTypeNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public ImportSingleTypeNode makeImportSingleTypeNode(
            NameNode name)
    {
        ImportSingleTypeNode ret = new ImportSingleTypeNodeImpl(this.<NameNode>makeNormalNodeUnion(name), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateImportSingleTypeNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), name == null ? null : name.getUid(), startLocation, stopLocation));
        }
        return ret;
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
        ImportSingleTypeNode ret = new ImportSingleTypeNodeImpl(name, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateImportSingleTypeNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), name == null ? null : (name.getNodeValue() == null ? null : name.getNodeValue().getUid()), startLocation, stopLocation));
        }
        return ret;
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
        ImportSingleTypeNode ret = new ImportSingleTypeNodeImpl(this.<NameNode>makeNormalNodeUnion(name), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateImportSingleTypeNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), name == null ? null : name.getUid(), startLocation, stopLocation));
        }
        return ret;
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
        InitializerDeclarationNode ret = new InitializerDeclarationNodeImpl(staticInitializer, body, metaAnnotations, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateInitializerDeclarationNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), staticInitializer, body == null ? null : (body.getNodeValue() == null ? null : body.getNodeValue().getUid()), metaAnnotations == null ? null : (metaAnnotations.getNodeValue() == null ? null : metaAnnotations.getNodeValue().getUid()), startLocation, stopLocation));
        }
        return ret;
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
        InitializerDeclarationNode ret = new InitializerDeclarationNodeImpl(staticInitializer, this.<BlockStatementListNode>makeNormalNodeUnion(body), this.<MetaAnnotationListNode>makeNormalNodeUnion(metaAnnotations), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateInitializerDeclarationNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), staticInitializer, body == null ? null : body.getUid(), metaAnnotations == null ? null : metaAnnotations.getUid(), startLocation, stopLocation));
        }
        return ret;
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
        InitializerDeclarationNode ret = new InitializerDeclarationNodeImpl(staticInitializer, body, metaAnnotations, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateInitializerDeclarationNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), staticInitializer, body == null ? null : (body.getNodeValue() == null ? null : body.getNodeValue().getUid()), metaAnnotations == null ? null : (metaAnnotations.getNodeValue() == null ? null : metaAnnotations.getNodeValue().getUid()), startLocation, stopLocation));
        }
        return ret;
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
        InitializerDeclarationNode ret = new InitializerDeclarationNodeImpl(staticInitializer, this.<BlockStatementListNode>makeNormalNodeUnion(body), this.<MetaAnnotationListNode>makeNormalNodeUnion(metaAnnotations), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateInitializerDeclarationNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), staticInitializer, body == null ? null : body.getUid(), metaAnnotations == null ? null : metaAnnotations.getUid(), startLocation, stopLocation));
        }
        return ret;
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
        InitializerDeclarationNode ret = new InitializerDeclarationNodeImpl(staticInitializer, this.<BlockStatementListNode>makeNormalNodeUnion(body), this.<MetaAnnotationListNode>makeNormalNodeUnion(makeMetaAnnotationListNode()), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateInitializerDeclarationNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), staticInitializer, body == null ? null : body.getUid(), ret.getMetaAnnotations() == null ? null : ret.getMetaAnnotations().getUid(), startLocation, stopLocation));
        }
        return ret;
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
        InitializerDeclarationNode ret = new InitializerDeclarationNodeImpl(staticInitializer, this.<BlockStatementListNode>makeNormalNodeUnion(body), this.<MetaAnnotationListNode>makeNormalNodeUnion(makeMetaAnnotationListNode()), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateInitializerDeclarationNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), staticInitializer, body == null ? null : body.getUid(), ret.getMetaAnnotations() == null ? null : ret.getMetaAnnotations().getUid(), startLocation, stopLocation));
        }
        return ret;
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
        InstanceOfNode ret = new InstanceOfNodeImpl(expression, type, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateInstanceOfNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), expression == null ? null : (expression.getNodeValue() == null ? null : expression.getNodeValue().getUid()), type == null ? null : (type.getNodeValue() == null ? null : type.getNodeValue().getUid()), startLocation, stopLocation));
        }
        return ret;
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
        InstanceOfNode ret = new InstanceOfNodeImpl(this.<ExpressionNode>makeNormalNodeUnion(expression), this.<TypeNode>makeNormalNodeUnion(type), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateInstanceOfNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), expression == null ? null : expression.getUid(), type == null ? null : type.getUid(), startLocation, stopLocation));
        }
        return ret;
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
        InstanceOfNode ret = new InstanceOfNodeImpl(expression, type, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateInstanceOfNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), expression == null ? null : (expression.getNodeValue() == null ? null : expression.getNodeValue().getUid()), type == null ? null : (type.getNodeValue() == null ? null : type.getNodeValue().getUid()), startLocation, stopLocation));
        }
        return ret;
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
        InstanceOfNode ret = new InstanceOfNodeImpl(this.<ExpressionNode>makeNormalNodeUnion(expression), this.<TypeNode>makeNormalNodeUnion(type), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateInstanceOfNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), expression == null ? null : expression.getUid(), type == null ? null : type.getUid(), startLocation, stopLocation));
        }
        return ret;
    }
    
    /**
     * Creates a IntLiteralNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public IntLiteralNode makeIntLiteralNode(
            Integer value)
    {
        IntLiteralNode ret = new IntLiteralNodeImpl(value, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateIntLiteralNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), value, startLocation, stopLocation));
        }
        return ret;
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
        IntLiteralNode ret = new IntLiteralNodeImpl(value, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateIntLiteralNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), value, startLocation, stopLocation));
        }
        return ret;
    }
    
    /**
     * Creates a InterfaceBodyNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public InterfaceBodyNode makeInterfaceBodyNodeWithUnions(
            NodeUnion<? extends InterfaceMemberListNode> members)
    {
        InterfaceBodyNode ret = new InterfaceBodyNodeImpl(members, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateInterfaceBodyNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), members == null ? null : (members.getNodeValue() == null ? null : members.getNodeValue().getUid()), startLocation, stopLocation));
        }
        return ret;
    }
    
    /**
     * Creates a InterfaceBodyNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public InterfaceBodyNode makeInterfaceBodyNode(
            InterfaceMemberListNode members)
    {
        InterfaceBodyNode ret = new InterfaceBodyNodeImpl(this.<InterfaceMemberListNode>makeNormalNodeUnion(members), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateInterfaceBodyNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), members == null ? null : members.getUid(), startLocation, stopLocation));
        }
        return ret;
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
        InterfaceBodyNode ret = new InterfaceBodyNodeImpl(members, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateInterfaceBodyNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), members == null ? null : (members.getNodeValue() == null ? null : members.getNodeValue().getUid()), startLocation, stopLocation));
        }
        return ret;
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
        InterfaceBodyNode ret = new InterfaceBodyNodeImpl(this.<InterfaceMemberListNode>makeNormalNodeUnion(members), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateInterfaceBodyNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), members == null ? null : members.getUid(), startLocation, stopLocation));
        }
        return ret;
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
        InterfaceDeclarationNode ret = new InterfaceDeclarationNodeImpl(modifiers, extendsClause, body, typeParameters, identifier, javadoc, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateInterfaceDeclarationNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), modifiers == null ? null : (modifiers.getNodeValue() == null ? null : modifiers.getNodeValue().getUid()), extendsClause == null ? null : (extendsClause.getNodeValue() == null ? null : extendsClause.getNodeValue().getUid()), body == null ? null : (body.getNodeValue() == null ? null : body.getNodeValue().getUid()), typeParameters == null ? null : (typeParameters.getNodeValue() == null ? null : typeParameters.getNodeValue().getUid()), identifier == null ? null : (identifier.getNodeValue() == null ? null : identifier.getNodeValue().getUid()), javadoc == null ? null : (javadoc.getNodeValue() == null ? null : javadoc.getNodeValue().getUid()), startLocation, stopLocation));
        }
        return ret;
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
        InterfaceDeclarationNode ret = new InterfaceDeclarationNodeImpl(this.<InterfaceModifiersNode>makeNormalNodeUnion(modifiers), this.<DeclaredTypeListNode>makeNormalNodeUnion(extendsClause), this.<InterfaceBodyNode>makeNormalNodeUnion(body), this.<TypeParameterListNode>makeNormalNodeUnion(typeParameters), this.<IdentifierNode>makeNormalNodeUnion(identifier), this.<JavadocNode>makeNormalNodeUnion(javadoc), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateInterfaceDeclarationNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), modifiers == null ? null : modifiers.getUid(), extendsClause == null ? null : extendsClause.getUid(), body == null ? null : body.getUid(), typeParameters == null ? null : typeParameters.getUid(), identifier == null ? null : identifier.getUid(), javadoc == null ? null : javadoc.getUid(), startLocation, stopLocation));
        }
        return ret;
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
        InterfaceDeclarationNode ret = new InterfaceDeclarationNodeImpl(modifiers, extendsClause, body, typeParameters, identifier, javadoc, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateInterfaceDeclarationNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), modifiers == null ? null : (modifiers.getNodeValue() == null ? null : modifiers.getNodeValue().getUid()), extendsClause == null ? null : (extendsClause.getNodeValue() == null ? null : extendsClause.getNodeValue().getUid()), body == null ? null : (body.getNodeValue() == null ? null : body.getNodeValue().getUid()), typeParameters == null ? null : (typeParameters.getNodeValue() == null ? null : typeParameters.getNodeValue().getUid()), identifier == null ? null : (identifier.getNodeValue() == null ? null : identifier.getNodeValue().getUid()), javadoc == null ? null : (javadoc.getNodeValue() == null ? null : javadoc.getNodeValue().getUid()), startLocation, stopLocation));
        }
        return ret;
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
        InterfaceDeclarationNode ret = new InterfaceDeclarationNodeImpl(this.<InterfaceModifiersNode>makeNormalNodeUnion(modifiers), this.<DeclaredTypeListNode>makeNormalNodeUnion(extendsClause), this.<InterfaceBodyNode>makeNormalNodeUnion(body), this.<TypeParameterListNode>makeNormalNodeUnion(typeParameters), this.<IdentifierNode>makeNormalNodeUnion(identifier), this.<JavadocNode>makeNormalNodeUnion(javadoc), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateInterfaceDeclarationNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), modifiers == null ? null : modifiers.getUid(), extendsClause == null ? null : extendsClause.getUid(), body == null ? null : body.getUid(), typeParameters == null ? null : typeParameters.getUid(), identifier == null ? null : identifier.getUid(), javadoc == null ? null : javadoc.getUid(), startLocation, stopLocation));
        }
        return ret;
    }
    
    /**
     * Creates a InterfaceMemberListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public InterfaceMemberListNode makeInterfaceMemberListNodeWithUnions(
            List<NodeUnion<? extends InterfaceMemberNode>> children)
    {
        InterfaceMemberListNode ret = new InterfaceMemberListNodeImpl(children, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateInterfaceMemberListNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), EditScriptUtilities.getNodeUnionUids(children), startLocation, stopLocation));
        }
        return ret;
    }
    
    /**
     * Creates a InterfaceMemberListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public InterfaceMemberListNode makeInterfaceMemberListNode(
            List<InterfaceMemberNode> children)
    {
        InterfaceMemberListNode ret = new InterfaceMemberListNodeImpl(unionWrapList(children), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateInterfaceMemberListNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), EditScriptUtilities.getNodeUids(children), startLocation, stopLocation));
        }
        return ret;
    }
    
    /**
     * Creates a InterfaceMemberListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public InterfaceMemberListNode makeInterfaceMemberListNode(
            InterfaceMemberNode... childrenElements)
    {
        List<InterfaceMemberNode> children = Arrays.asList(childrenElements);
        return makeInterfaceMemberListNode(children, startLocation, stopLocation);
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
        InterfaceMemberListNode ret = new InterfaceMemberListNodeImpl(children, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateInterfaceMemberListNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), EditScriptUtilities.getNodeUnionUids(children), startLocation, stopLocation));
        }
        return ret;
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
        InterfaceMemberListNode ret = new InterfaceMemberListNodeImpl(unionWrapList(children), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateInterfaceMemberListNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), EditScriptUtilities.getNodeUids(children), startLocation, stopLocation));
        }
        return ret;
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
        List<InterfaceMemberNode> children = Arrays.asList(childrenElements);
        return makeInterfaceMemberListNode(children, startLocation, stopLocation);
    }
    
    /**
     * Creates a InterfaceMemberMetaprogramAnchorNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public InterfaceMemberMetaprogramAnchorNode makeInterfaceMemberMetaprogramAnchorNodeWithUnions(
            NodeUnion<? extends MetaprogramNode> metaprogram)
    {
        InterfaceMemberMetaprogramAnchorNode ret = new InterfaceMemberMetaprogramAnchorNodeImpl(metaprogram, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateInterfaceMemberMetaprogramAnchorNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), metaprogram == null ? null : (metaprogram.getNodeValue() == null ? null : metaprogram.getNodeValue().getUid()), startLocation, stopLocation));
        }
        return ret;
    }
    
    /**
     * Creates a InterfaceMemberMetaprogramAnchorNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public InterfaceMemberMetaprogramAnchorNode makeInterfaceMemberMetaprogramAnchorNode(
            MetaprogramNode metaprogram)
    {
        InterfaceMemberMetaprogramAnchorNode ret = new InterfaceMemberMetaprogramAnchorNodeImpl(this.<MetaprogramNode>makeNormalNodeUnion(metaprogram), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateInterfaceMemberMetaprogramAnchorNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), metaprogram == null ? null : metaprogram.getUid(), startLocation, stopLocation));
        }
        return ret;
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
        InterfaceMemberMetaprogramAnchorNode ret = new InterfaceMemberMetaprogramAnchorNodeImpl(metaprogram, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateInterfaceMemberMetaprogramAnchorNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), metaprogram == null ? null : (metaprogram.getNodeValue() == null ? null : metaprogram.getNodeValue().getUid()), startLocation, stopLocation));
        }
        return ret;
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
        InterfaceMemberMetaprogramAnchorNode ret = new InterfaceMemberMetaprogramAnchorNodeImpl(this.<MetaprogramNode>makeNormalNodeUnion(metaprogram), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateInterfaceMemberMetaprogramAnchorNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), metaprogram == null ? null : metaprogram.getUid(), startLocation, stopLocation));
        }
        return ret;
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
        InterfaceModifiersNode ret = new InterfaceModifiersNodeImpl(access, staticFlag, strictfpFlag, metaAnnotations, annotations, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateInterfaceModifiersNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), access, staticFlag, strictfpFlag, metaAnnotations == null ? null : (metaAnnotations.getNodeValue() == null ? null : metaAnnotations.getNodeValue().getUid()), annotations == null ? null : (annotations.getNodeValue() == null ? null : annotations.getNodeValue().getUid()), startLocation, stopLocation));
        }
        return ret;
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
        InterfaceModifiersNode ret = new InterfaceModifiersNodeImpl(access, staticFlag, strictfpFlag, this.<MetaAnnotationListNode>makeNormalNodeUnion(metaAnnotations), this.<AnnotationListNode>makeNormalNodeUnion(annotations), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateInterfaceModifiersNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), access, staticFlag, strictfpFlag, metaAnnotations == null ? null : metaAnnotations.getUid(), annotations == null ? null : annotations.getUid(), startLocation, stopLocation));
        }
        return ret;
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
        InterfaceModifiersNode ret = new InterfaceModifiersNodeImpl(access, staticFlag, strictfpFlag, metaAnnotations, annotations, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateInterfaceModifiersNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), access, staticFlag, strictfpFlag, metaAnnotations == null ? null : (metaAnnotations.getNodeValue() == null ? null : metaAnnotations.getNodeValue().getUid()), annotations == null ? null : (annotations.getNodeValue() == null ? null : annotations.getNodeValue().getUid()), startLocation, stopLocation));
        }
        return ret;
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
        InterfaceModifiersNode ret = new InterfaceModifiersNodeImpl(access, staticFlag, strictfpFlag, this.<MetaAnnotationListNode>makeNormalNodeUnion(metaAnnotations), this.<AnnotationListNode>makeNormalNodeUnion(annotations), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateInterfaceModifiersNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), access, staticFlag, strictfpFlag, metaAnnotations == null ? null : metaAnnotations.getUid(), annotations == null ? null : annotations.getUid(), startLocation, stopLocation));
        }
        return ret;
    }
    
    /**
     * Creates a InterfaceModifiersNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public InterfaceModifiersNode makeInterfaceModifiersNode(
            AccessModifier access)
    {
        InterfaceModifiersNode ret = new InterfaceModifiersNodeImpl(access, false, false, this.<MetaAnnotationListNode>makeNormalNodeUnion(makeMetaAnnotationListNode()), this.<AnnotationListNode>makeNormalNodeUnion(makeAnnotationListNode()), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateInterfaceModifiersNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), access, ret.getStaticFlag(), ret.getStrictfpFlag(), ret.getMetaAnnotations() == null ? null : ret.getMetaAnnotations().getUid(), ret.getAnnotations() == null ? null : ret.getAnnotations().getUid(), startLocation, stopLocation));
        }
        return ret;
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
        InterfaceModifiersNode ret = new InterfaceModifiersNodeImpl(access, false, false, this.<MetaAnnotationListNode>makeNormalNodeUnion(makeMetaAnnotationListNode()), this.<AnnotationListNode>makeNormalNodeUnion(makeAnnotationListNode()), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateInterfaceModifiersNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), access, ret.getStaticFlag(), ret.getStrictfpFlag(), ret.getMetaAnnotations() == null ? null : ret.getMetaAnnotations().getUid(), ret.getAnnotations() == null ? null : ret.getAnnotations().getUid(), startLocation, stopLocation));
        }
        return ret;
    }
    
    /**
     * Creates a JavadocNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public JavadocNode makeJavadocNode(
            String text)
    {
        JavadocNode ret = new JavadocNodeImpl(text, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateJavadocNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), text, startLocation, stopLocation));
        }
        return ret;
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
        JavadocNode ret = new JavadocNodeImpl(text, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateJavadocNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), text, startLocation, stopLocation));
        }
        return ret;
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
        LabeledStatementNode ret = new LabeledStatementNodeImpl(label, statement, metaAnnotations, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateLabeledStatementNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), label == null ? null : (label.getNodeValue() == null ? null : label.getNodeValue().getUid()), statement == null ? null : (statement.getNodeValue() == null ? null : statement.getNodeValue().getUid()), metaAnnotations == null ? null : (metaAnnotations.getNodeValue() == null ? null : metaAnnotations.getNodeValue().getUid()), startLocation, stopLocation));
        }
        return ret;
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
        LabeledStatementNode ret = new LabeledStatementNodeImpl(this.<IdentifierNode>makeNormalNodeUnion(label), this.<StatementNode>makeNormalNodeUnion(statement), this.<MetaAnnotationListNode>makeNormalNodeUnion(metaAnnotations), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateLabeledStatementNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), label == null ? null : label.getUid(), statement == null ? null : statement.getUid(), metaAnnotations == null ? null : metaAnnotations.getUid(), startLocation, stopLocation));
        }
        return ret;
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
        LabeledStatementNode ret = new LabeledStatementNodeImpl(label, statement, metaAnnotations, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateLabeledStatementNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), label == null ? null : (label.getNodeValue() == null ? null : label.getNodeValue().getUid()), statement == null ? null : (statement.getNodeValue() == null ? null : statement.getNodeValue().getUid()), metaAnnotations == null ? null : (metaAnnotations.getNodeValue() == null ? null : metaAnnotations.getNodeValue().getUid()), startLocation, stopLocation));
        }
        return ret;
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
        LabeledStatementNode ret = new LabeledStatementNodeImpl(this.<IdentifierNode>makeNormalNodeUnion(label), this.<StatementNode>makeNormalNodeUnion(statement), this.<MetaAnnotationListNode>makeNormalNodeUnion(metaAnnotations), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateLabeledStatementNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), label == null ? null : label.getUid(), statement == null ? null : statement.getUid(), metaAnnotations == null ? null : metaAnnotations.getUid(), startLocation, stopLocation));
        }
        return ret;
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
        LabeledStatementNode ret = new LabeledStatementNodeImpl(this.<IdentifierNode>makeNormalNodeUnion(label), this.<StatementNode>makeNormalNodeUnion(statement), this.<MetaAnnotationListNode>makeNormalNodeUnion(makeMetaAnnotationListNode()), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateLabeledStatementNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), label == null ? null : label.getUid(), statement == null ? null : statement.getUid(), ret.getMetaAnnotations() == null ? null : ret.getMetaAnnotations().getUid(), startLocation, stopLocation));
        }
        return ret;
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
        LabeledStatementNode ret = new LabeledStatementNodeImpl(this.<IdentifierNode>makeNormalNodeUnion(label), this.<StatementNode>makeNormalNodeUnion(statement), this.<MetaAnnotationListNode>makeNormalNodeUnion(makeMetaAnnotationListNode()), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateLabeledStatementNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), label == null ? null : label.getUid(), statement == null ? null : statement.getUid(), ret.getMetaAnnotations() == null ? null : ret.getMetaAnnotations().getUid(), startLocation, stopLocation));
        }
        return ret;
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
        LocalClassDeclarationNode ret = new LocalClassDeclarationNodeImpl(modifiers, extendsClause, implementsClause, body, typeParameters, identifier, javadoc, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateLocalClassDeclarationNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), modifiers == null ? null : (modifiers.getNodeValue() == null ? null : modifiers.getNodeValue().getUid()), extendsClause == null ? null : (extendsClause.getNodeValue() == null ? null : extendsClause.getNodeValue().getUid()), implementsClause == null ? null : (implementsClause.getNodeValue() == null ? null : implementsClause.getNodeValue().getUid()), body == null ? null : (body.getNodeValue() == null ? null : body.getNodeValue().getUid()), typeParameters == null ? null : (typeParameters.getNodeValue() == null ? null : typeParameters.getNodeValue().getUid()), identifier == null ? null : (identifier.getNodeValue() == null ? null : identifier.getNodeValue().getUid()), javadoc == null ? null : (javadoc.getNodeValue() == null ? null : javadoc.getNodeValue().getUid()), startLocation, stopLocation));
        }
        return ret;
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
        LocalClassDeclarationNode ret = new LocalClassDeclarationNodeImpl(this.<LocalClassModifiersNode>makeNormalNodeUnion(modifiers), this.<DeclaredTypeNode>makeNormalNodeUnion(extendsClause), this.<DeclaredTypeListNode>makeNormalNodeUnion(implementsClause), this.<ClassBodyNode>makeNormalNodeUnion(body), this.<TypeParameterListNode>makeNormalNodeUnion(typeParameters), this.<IdentifierNode>makeNormalNodeUnion(identifier), this.<JavadocNode>makeNormalNodeUnion(javadoc), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateLocalClassDeclarationNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), modifiers == null ? null : modifiers.getUid(), extendsClause == null ? null : extendsClause.getUid(), implementsClause == null ? null : implementsClause.getUid(), body == null ? null : body.getUid(), typeParameters == null ? null : typeParameters.getUid(), identifier == null ? null : identifier.getUid(), javadoc == null ? null : javadoc.getUid(), startLocation, stopLocation));
        }
        return ret;
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
        LocalClassDeclarationNode ret = new LocalClassDeclarationNodeImpl(modifiers, extendsClause, implementsClause, body, typeParameters, identifier, javadoc, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateLocalClassDeclarationNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), modifiers == null ? null : (modifiers.getNodeValue() == null ? null : modifiers.getNodeValue().getUid()), extendsClause == null ? null : (extendsClause.getNodeValue() == null ? null : extendsClause.getNodeValue().getUid()), implementsClause == null ? null : (implementsClause.getNodeValue() == null ? null : implementsClause.getNodeValue().getUid()), body == null ? null : (body.getNodeValue() == null ? null : body.getNodeValue().getUid()), typeParameters == null ? null : (typeParameters.getNodeValue() == null ? null : typeParameters.getNodeValue().getUid()), identifier == null ? null : (identifier.getNodeValue() == null ? null : identifier.getNodeValue().getUid()), javadoc == null ? null : (javadoc.getNodeValue() == null ? null : javadoc.getNodeValue().getUid()), startLocation, stopLocation));
        }
        return ret;
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
        LocalClassDeclarationNode ret = new LocalClassDeclarationNodeImpl(this.<LocalClassModifiersNode>makeNormalNodeUnion(modifiers), this.<DeclaredTypeNode>makeNormalNodeUnion(extendsClause), this.<DeclaredTypeListNode>makeNormalNodeUnion(implementsClause), this.<ClassBodyNode>makeNormalNodeUnion(body), this.<TypeParameterListNode>makeNormalNodeUnion(typeParameters), this.<IdentifierNode>makeNormalNodeUnion(identifier), this.<JavadocNode>makeNormalNodeUnion(javadoc), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateLocalClassDeclarationNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), modifiers == null ? null : modifiers.getUid(), extendsClause == null ? null : extendsClause.getUid(), implementsClause == null ? null : implementsClause.getUid(), body == null ? null : body.getUid(), typeParameters == null ? null : typeParameters.getUid(), identifier == null ? null : identifier.getUid(), javadoc == null ? null : javadoc.getUid(), startLocation, stopLocation));
        }
        return ret;
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
        LocalClassModifiersNode ret = new LocalClassModifiersNodeImpl(abstractFlag, finalFlag, strictfpFlag, metaAnnotations, annotations, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateLocalClassModifiersNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), abstractFlag, finalFlag, strictfpFlag, metaAnnotations == null ? null : (metaAnnotations.getNodeValue() == null ? null : metaAnnotations.getNodeValue().getUid()), annotations == null ? null : (annotations.getNodeValue() == null ? null : annotations.getNodeValue().getUid()), startLocation, stopLocation));
        }
        return ret;
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
        LocalClassModifiersNode ret = new LocalClassModifiersNodeImpl(abstractFlag, finalFlag, strictfpFlag, this.<MetaAnnotationListNode>makeNormalNodeUnion(metaAnnotations), this.<AnnotationListNode>makeNormalNodeUnion(annotations), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateLocalClassModifiersNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), abstractFlag, finalFlag, strictfpFlag, metaAnnotations == null ? null : metaAnnotations.getUid(), annotations == null ? null : annotations.getUid(), startLocation, stopLocation));
        }
        return ret;
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
        LocalClassModifiersNode ret = new LocalClassModifiersNodeImpl(abstractFlag, finalFlag, strictfpFlag, metaAnnotations, annotations, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateLocalClassModifiersNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), abstractFlag, finalFlag, strictfpFlag, metaAnnotations == null ? null : (metaAnnotations.getNodeValue() == null ? null : metaAnnotations.getNodeValue().getUid()), annotations == null ? null : (annotations.getNodeValue() == null ? null : annotations.getNodeValue().getUid()), startLocation, stopLocation));
        }
        return ret;
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
        LocalClassModifiersNode ret = new LocalClassModifiersNodeImpl(abstractFlag, finalFlag, strictfpFlag, this.<MetaAnnotationListNode>makeNormalNodeUnion(metaAnnotations), this.<AnnotationListNode>makeNormalNodeUnion(annotations), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateLocalClassModifiersNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), abstractFlag, finalFlag, strictfpFlag, metaAnnotations == null ? null : metaAnnotations.getUid(), annotations == null ? null : annotations.getUid(), startLocation, stopLocation));
        }
        return ret;
    }
    
    /**
     * Creates a LocalClassModifiersNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public LocalClassModifiersNode makeLocalClassModifiersNode(
    )
    {
        LocalClassModifiersNode ret = new LocalClassModifiersNodeImpl(false, false, false, this.<MetaAnnotationListNode>makeNormalNodeUnion(makeMetaAnnotationListNode()), this.<AnnotationListNode>makeNormalNodeUnion(makeAnnotationListNode()), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateLocalClassModifiersNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), ret.getAbstractFlag(), ret.getFinalFlag(), ret.getStrictfpFlag(), ret.getMetaAnnotations() == null ? null : ret.getMetaAnnotations().getUid(), ret.getAnnotations() == null ? null : ret.getAnnotations().getUid(), startLocation, stopLocation));
        }
        return ret;
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
        LocalClassModifiersNode ret = new LocalClassModifiersNodeImpl(false, false, false, this.<MetaAnnotationListNode>makeNormalNodeUnion(makeMetaAnnotationListNode()), this.<AnnotationListNode>makeNormalNodeUnion(makeAnnotationListNode()), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateLocalClassModifiersNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), ret.getAbstractFlag(), ret.getFinalFlag(), ret.getStrictfpFlag(), ret.getMetaAnnotations() == null ? null : ret.getMetaAnnotations().getUid(), ret.getAnnotations() == null ? null : ret.getAnnotations().getUid(), startLocation, stopLocation));
        }
        return ret;
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
        LocalVariableDeclarationNode ret = new LocalVariableDeclarationNodeImpl(modifiers, type, declarators, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateLocalVariableDeclarationNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), modifiers == null ? null : (modifiers.getNodeValue() == null ? null : modifiers.getNodeValue().getUid()), type == null ? null : (type.getNodeValue() == null ? null : type.getNodeValue().getUid()), declarators == null ? null : (declarators.getNodeValue() == null ? null : declarators.getNodeValue().getUid()), startLocation, stopLocation));
        }
        return ret;
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
        LocalVariableDeclarationNode ret = new LocalVariableDeclarationNodeImpl(this.<VariableModifiersNode>makeNormalNodeUnion(modifiers), this.<TypeNode>makeNormalNodeUnion(type), this.<VariableDeclaratorListNode>makeNormalNodeUnion(declarators), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateLocalVariableDeclarationNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), modifiers == null ? null : modifiers.getUid(), type == null ? null : type.getUid(), declarators == null ? null : declarators.getUid(), startLocation, stopLocation));
        }
        return ret;
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
        LocalVariableDeclarationNode ret = new LocalVariableDeclarationNodeImpl(modifiers, type, declarators, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateLocalVariableDeclarationNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), modifiers == null ? null : (modifiers.getNodeValue() == null ? null : modifiers.getNodeValue().getUid()), type == null ? null : (type.getNodeValue() == null ? null : type.getNodeValue().getUid()), declarators == null ? null : (declarators.getNodeValue() == null ? null : declarators.getNodeValue().getUid()), startLocation, stopLocation));
        }
        return ret;
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
        LocalVariableDeclarationNode ret = new LocalVariableDeclarationNodeImpl(this.<VariableModifiersNode>makeNormalNodeUnion(modifiers), this.<TypeNode>makeNormalNodeUnion(type), this.<VariableDeclaratorListNode>makeNormalNodeUnion(declarators), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateLocalVariableDeclarationNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), modifiers == null ? null : modifiers.getUid(), type == null ? null : type.getUid(), declarators == null ? null : declarators.getUid(), startLocation, stopLocation));
        }
        return ret;
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
        LocalVariableDeclarationNode ret = new LocalVariableDeclarationNodeImpl(this.<VariableModifiersNode>makeNormalNodeUnion(makeVariableModifiersNode()), this.<TypeNode>makeNormalNodeUnion(type), this.<VariableDeclaratorListNode>makeNormalNodeUnion(declarators), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateLocalVariableDeclarationNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), ret.getModifiers() == null ? null : ret.getModifiers().getUid(), type == null ? null : type.getUid(), declarators == null ? null : declarators.getUid(), startLocation, stopLocation));
        }
        return ret;
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
        LocalVariableDeclarationNode ret = new LocalVariableDeclarationNodeImpl(this.<VariableModifiersNode>makeNormalNodeUnion(makeVariableModifiersNode()), this.<TypeNode>makeNormalNodeUnion(type), this.<VariableDeclaratorListNode>makeNormalNodeUnion(declarators), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateLocalVariableDeclarationNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), ret.getModifiers() == null ? null : ret.getModifiers().getUid(), type == null ? null : type.getUid(), declarators == null ? null : declarators.getUid(), startLocation, stopLocation));
        }
        return ret;
    }
    
    /**
     * Creates a LongLiteralNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public LongLiteralNode makeLongLiteralNode(
            Long value)
    {
        LongLiteralNode ret = new LongLiteralNodeImpl(value, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateLongLiteralNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), value, startLocation, stopLocation));
        }
        return ret;
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
        LongLiteralNode ret = new LongLiteralNodeImpl(value, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateLongLiteralNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), value, startLocation, stopLocation));
        }
        return ret;
    }
    
    /**
     * Creates a MetaAnnotationArrayValueNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public MetaAnnotationArrayValueNode makeMetaAnnotationArrayValueNodeWithUnions(
            NodeUnion<? extends MetaAnnotationValueListNode> values)
    {
        MetaAnnotationArrayValueNode ret = new MetaAnnotationArrayValueNodeImpl(values, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateMetaAnnotationArrayValueNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), values == null ? null : (values.getNodeValue() == null ? null : values.getNodeValue().getUid()), startLocation, stopLocation));
        }
        return ret;
    }
    
    /**
     * Creates a MetaAnnotationArrayValueNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public MetaAnnotationArrayValueNode makeMetaAnnotationArrayValueNode(
            MetaAnnotationValueListNode values)
    {
        MetaAnnotationArrayValueNode ret = new MetaAnnotationArrayValueNodeImpl(this.<MetaAnnotationValueListNode>makeNormalNodeUnion(values), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateMetaAnnotationArrayValueNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), values == null ? null : values.getUid(), startLocation, stopLocation));
        }
        return ret;
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
        MetaAnnotationArrayValueNode ret = new MetaAnnotationArrayValueNodeImpl(values, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateMetaAnnotationArrayValueNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), values == null ? null : (values.getNodeValue() == null ? null : values.getNodeValue().getUid()), startLocation, stopLocation));
        }
        return ret;
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
        MetaAnnotationArrayValueNode ret = new MetaAnnotationArrayValueNodeImpl(this.<MetaAnnotationValueListNode>makeNormalNodeUnion(values), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateMetaAnnotationArrayValueNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), values == null ? null : values.getUid(), startLocation, stopLocation));
        }
        return ret;
    }
    
    /**
     * Creates a MetaAnnotationElementListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public MetaAnnotationElementListNode makeMetaAnnotationElementListNodeWithUnions(
            List<NodeUnion<? extends MetaAnnotationElementNode>> children)
    {
        MetaAnnotationElementListNode ret = new MetaAnnotationElementListNodeImpl(children, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateMetaAnnotationElementListNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), EditScriptUtilities.getNodeUnionUids(children), startLocation, stopLocation));
        }
        return ret;
    }
    
    /**
     * Creates a MetaAnnotationElementListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public MetaAnnotationElementListNode makeMetaAnnotationElementListNode(
            List<MetaAnnotationElementNode> children)
    {
        MetaAnnotationElementListNode ret = new MetaAnnotationElementListNodeImpl(unionWrapList(children), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateMetaAnnotationElementListNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), EditScriptUtilities.getNodeUids(children), startLocation, stopLocation));
        }
        return ret;
    }
    
    /**
     * Creates a MetaAnnotationElementListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public MetaAnnotationElementListNode makeMetaAnnotationElementListNode(
            MetaAnnotationElementNode... childrenElements)
    {
        List<MetaAnnotationElementNode> children = Arrays.asList(childrenElements);
        return makeMetaAnnotationElementListNode(children, startLocation, stopLocation);
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
        MetaAnnotationElementListNode ret = new MetaAnnotationElementListNodeImpl(children, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateMetaAnnotationElementListNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), EditScriptUtilities.getNodeUnionUids(children), startLocation, stopLocation));
        }
        return ret;
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
        MetaAnnotationElementListNode ret = new MetaAnnotationElementListNodeImpl(unionWrapList(children), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateMetaAnnotationElementListNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), EditScriptUtilities.getNodeUids(children), startLocation, stopLocation));
        }
        return ret;
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
        List<MetaAnnotationElementNode> children = Arrays.asList(childrenElements);
        return makeMetaAnnotationElementListNode(children, startLocation, stopLocation);
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
        MetaAnnotationElementNode ret = new MetaAnnotationElementNodeImpl(identifier, value, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateMetaAnnotationElementNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), identifier == null ? null : (identifier.getNodeValue() == null ? null : identifier.getNodeValue().getUid()), value == null ? null : (value.getNodeValue() == null ? null : value.getNodeValue().getUid()), startLocation, stopLocation));
        }
        return ret;
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
        MetaAnnotationElementNode ret = new MetaAnnotationElementNodeImpl(this.<IdentifierNode>makeNormalNodeUnion(identifier), this.<MetaAnnotationValueNode>makeNormalNodeUnion(value), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateMetaAnnotationElementNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), identifier == null ? null : identifier.getUid(), value == null ? null : value.getUid(), startLocation, stopLocation));
        }
        return ret;
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
        MetaAnnotationElementNode ret = new MetaAnnotationElementNodeImpl(identifier, value, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateMetaAnnotationElementNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), identifier == null ? null : (identifier.getNodeValue() == null ? null : identifier.getNodeValue().getUid()), value == null ? null : (value.getNodeValue() == null ? null : value.getNodeValue().getUid()), startLocation, stopLocation));
        }
        return ret;
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
        MetaAnnotationElementNode ret = new MetaAnnotationElementNodeImpl(this.<IdentifierNode>makeNormalNodeUnion(identifier), this.<MetaAnnotationValueNode>makeNormalNodeUnion(value), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateMetaAnnotationElementNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), identifier == null ? null : identifier.getUid(), value == null ? null : value.getUid(), startLocation, stopLocation));
        }
        return ret;
    }
    
    /**
     * Creates a MetaAnnotationExpressionValueNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public MetaAnnotationExpressionValueNode makeMetaAnnotationExpressionValueNodeWithUnions(
            NodeUnion<? extends NonAssignmentExpressionNode> expression)
    {
        MetaAnnotationExpressionValueNode ret = new MetaAnnotationExpressionValueNodeImpl(expression, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateMetaAnnotationExpressionValueNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), expression == null ? null : (expression.getNodeValue() == null ? null : expression.getNodeValue().getUid()), startLocation, stopLocation));
        }
        return ret;
    }
    
    /**
     * Creates a MetaAnnotationExpressionValueNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public MetaAnnotationExpressionValueNode makeMetaAnnotationExpressionValueNode(
            NonAssignmentExpressionNode expression)
    {
        MetaAnnotationExpressionValueNode ret = new MetaAnnotationExpressionValueNodeImpl(this.<NonAssignmentExpressionNode>makeNormalNodeUnion(expression), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateMetaAnnotationExpressionValueNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), expression == null ? null : expression.getUid(), startLocation, stopLocation));
        }
        return ret;
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
        MetaAnnotationExpressionValueNode ret = new MetaAnnotationExpressionValueNodeImpl(expression, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateMetaAnnotationExpressionValueNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), expression == null ? null : (expression.getNodeValue() == null ? null : expression.getNodeValue().getUid()), startLocation, stopLocation));
        }
        return ret;
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
        MetaAnnotationExpressionValueNode ret = new MetaAnnotationExpressionValueNodeImpl(this.<NonAssignmentExpressionNode>makeNormalNodeUnion(expression), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateMetaAnnotationExpressionValueNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), expression == null ? null : expression.getUid(), startLocation, stopLocation));
        }
        return ret;
    }
    
    /**
     * Creates a MetaAnnotationListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public MetaAnnotationListNode makeMetaAnnotationListNodeWithUnions(
            List<NodeUnion<? extends MetaAnnotationNode>> children)
    {
        MetaAnnotationListNode ret = new MetaAnnotationListNodeImpl(children, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateMetaAnnotationListNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), EditScriptUtilities.getNodeUnionUids(children), startLocation, stopLocation));
        }
        return ret;
    }
    
    /**
     * Creates a MetaAnnotationListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public MetaAnnotationListNode makeMetaAnnotationListNode(
            List<MetaAnnotationNode> children)
    {
        MetaAnnotationListNode ret = new MetaAnnotationListNodeImpl(unionWrapList(children), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateMetaAnnotationListNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), EditScriptUtilities.getNodeUids(children), startLocation, stopLocation));
        }
        return ret;
    }
    
    /**
     * Creates a MetaAnnotationListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public MetaAnnotationListNode makeMetaAnnotationListNode(
            MetaAnnotationNode... childrenElements)
    {
        List<MetaAnnotationNode> children = Arrays.asList(childrenElements);
        return makeMetaAnnotationListNode(children, startLocation, stopLocation);
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
        MetaAnnotationListNode ret = new MetaAnnotationListNodeImpl(children, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateMetaAnnotationListNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), EditScriptUtilities.getNodeUnionUids(children), startLocation, stopLocation));
        }
        return ret;
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
        MetaAnnotationListNode ret = new MetaAnnotationListNodeImpl(unionWrapList(children), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateMetaAnnotationListNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), EditScriptUtilities.getNodeUids(children), startLocation, stopLocation));
        }
        return ret;
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
        List<MetaAnnotationNode> children = Arrays.asList(childrenElements);
        return makeMetaAnnotationListNode(children, startLocation, stopLocation);
    }
    
    /**
     * Creates a MetaAnnotationMetaAnnotationValueNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public MetaAnnotationMetaAnnotationValueNode makeMetaAnnotationMetaAnnotationValueNodeWithUnions(
            NodeUnion<? extends MetaAnnotationNode> annotation)
    {
        MetaAnnotationMetaAnnotationValueNode ret = new MetaAnnotationMetaAnnotationValueNodeImpl(annotation, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateMetaAnnotationMetaAnnotationValueNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), annotation == null ? null : (annotation.getNodeValue() == null ? null : annotation.getNodeValue().getUid()), startLocation, stopLocation));
        }
        return ret;
    }
    
    /**
     * Creates a MetaAnnotationMetaAnnotationValueNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public MetaAnnotationMetaAnnotationValueNode makeMetaAnnotationMetaAnnotationValueNode(
            MetaAnnotationNode annotation)
    {
        MetaAnnotationMetaAnnotationValueNode ret = new MetaAnnotationMetaAnnotationValueNodeImpl(this.<MetaAnnotationNode>makeNormalNodeUnion(annotation), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateMetaAnnotationMetaAnnotationValueNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), annotation == null ? null : annotation.getUid(), startLocation, stopLocation));
        }
        return ret;
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
        MetaAnnotationMetaAnnotationValueNode ret = new MetaAnnotationMetaAnnotationValueNodeImpl(annotation, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateMetaAnnotationMetaAnnotationValueNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), annotation == null ? null : (annotation.getNodeValue() == null ? null : annotation.getNodeValue().getUid()), startLocation, stopLocation));
        }
        return ret;
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
        MetaAnnotationMetaAnnotationValueNode ret = new MetaAnnotationMetaAnnotationValueNodeImpl(this.<MetaAnnotationNode>makeNormalNodeUnion(annotation), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateMetaAnnotationMetaAnnotationValueNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), annotation == null ? null : annotation.getUid(), startLocation, stopLocation));
        }
        return ret;
    }
    
    /**
     * Creates a MetaAnnotationMetaprogramAnchorNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public MetaAnnotationMetaprogramAnchorNode makeMetaAnnotationMetaprogramAnchorNode(
    )
    {
        MetaAnnotationMetaprogramAnchorNode ret = new MetaAnnotationMetaprogramAnchorNodeImpl(startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateMetaAnnotationMetaprogramAnchorNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), startLocation, stopLocation));
        }
        return ret;
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
        MetaAnnotationMetaprogramAnchorNode ret = new MetaAnnotationMetaprogramAnchorNodeImpl(startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateMetaAnnotationMetaprogramAnchorNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), startLocation, stopLocation));
        }
        return ret;
    }
    
    /**
     * Creates a MetaAnnotationValueListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public MetaAnnotationValueListNode makeMetaAnnotationValueListNodeWithUnions(
            List<NodeUnion<? extends MetaAnnotationValueNode>> children)
    {
        MetaAnnotationValueListNode ret = new MetaAnnotationValueListNodeImpl(children, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateMetaAnnotationValueListNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), EditScriptUtilities.getNodeUnionUids(children), startLocation, stopLocation));
        }
        return ret;
    }
    
    /**
     * Creates a MetaAnnotationValueListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public MetaAnnotationValueListNode makeMetaAnnotationValueListNode(
            List<MetaAnnotationValueNode> children)
    {
        MetaAnnotationValueListNode ret = new MetaAnnotationValueListNodeImpl(unionWrapList(children), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateMetaAnnotationValueListNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), EditScriptUtilities.getNodeUids(children), startLocation, stopLocation));
        }
        return ret;
    }
    
    /**
     * Creates a MetaAnnotationValueListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public MetaAnnotationValueListNode makeMetaAnnotationValueListNode(
            MetaAnnotationValueNode... childrenElements)
    {
        List<MetaAnnotationValueNode> children = Arrays.asList(childrenElements);
        return makeMetaAnnotationValueListNode(children, startLocation, stopLocation);
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
        MetaAnnotationValueListNode ret = new MetaAnnotationValueListNodeImpl(children, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateMetaAnnotationValueListNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), EditScriptUtilities.getNodeUnionUids(children), startLocation, stopLocation));
        }
        return ret;
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
        MetaAnnotationValueListNode ret = new MetaAnnotationValueListNodeImpl(unionWrapList(children), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateMetaAnnotationValueListNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), EditScriptUtilities.getNodeUids(children), startLocation, stopLocation));
        }
        return ret;
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
        List<MetaAnnotationValueNode> children = Arrays.asList(childrenElements);
        return makeMetaAnnotationValueListNode(children, startLocation, stopLocation);
    }
    
    /**
     * Creates a MetaprogramDependencyDeclarationListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public MetaprogramDependencyDeclarationListNode makeMetaprogramDependencyDeclarationListNodeWithUnions(
            List<NodeUnion<? extends MetaprogramDependencyDeclarationNode>> children)
    {
        MetaprogramDependencyDeclarationListNode ret = new MetaprogramDependencyDeclarationListNodeImpl(children, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateMetaprogramDependencyDeclarationListNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), EditScriptUtilities.getNodeUnionUids(children), startLocation, stopLocation));
        }
        return ret;
    }
    
    /**
     * Creates a MetaprogramDependencyDeclarationListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public MetaprogramDependencyDeclarationListNode makeMetaprogramDependencyDeclarationListNode(
            List<MetaprogramDependencyDeclarationNode> children)
    {
        MetaprogramDependencyDeclarationListNode ret = new MetaprogramDependencyDeclarationListNodeImpl(unionWrapList(children), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateMetaprogramDependencyDeclarationListNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), EditScriptUtilities.getNodeUids(children), startLocation, stopLocation));
        }
        return ret;
    }
    
    /**
     * Creates a MetaprogramDependencyDeclarationListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public MetaprogramDependencyDeclarationListNode makeMetaprogramDependencyDeclarationListNode(
            MetaprogramDependencyDeclarationNode... childrenElements)
    {
        List<MetaprogramDependencyDeclarationNode> children = Arrays.asList(childrenElements);
        return makeMetaprogramDependencyDeclarationListNode(children, startLocation, stopLocation);
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
        MetaprogramDependencyDeclarationListNode ret = new MetaprogramDependencyDeclarationListNodeImpl(children, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateMetaprogramDependencyDeclarationListNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), EditScriptUtilities.getNodeUnionUids(children), startLocation, stopLocation));
        }
        return ret;
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
        MetaprogramDependencyDeclarationListNode ret = new MetaprogramDependencyDeclarationListNodeImpl(unionWrapList(children), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateMetaprogramDependencyDeclarationListNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), EditScriptUtilities.getNodeUids(children), startLocation, stopLocation));
        }
        return ret;
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
        List<MetaprogramDependencyDeclarationNode> children = Arrays.asList(childrenElements);
        return makeMetaprogramDependencyDeclarationListNode(children, startLocation, stopLocation);
    }
    
    /**
     * Creates a MetaprogramDependencyDeclarationNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public MetaprogramDependencyDeclarationNode makeMetaprogramDependencyDeclarationNodeWithUnions(
            NodeUnion<? extends MetaprogramDependencyListNode> targets)
    {
        MetaprogramDependencyDeclarationNode ret = new MetaprogramDependencyDeclarationNodeImpl(targets, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateMetaprogramDependencyDeclarationNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), targets == null ? null : (targets.getNodeValue() == null ? null : targets.getNodeValue().getUid()), startLocation, stopLocation));
        }
        return ret;
    }
    
    /**
     * Creates a MetaprogramDependencyDeclarationNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public MetaprogramDependencyDeclarationNode makeMetaprogramDependencyDeclarationNode(
            MetaprogramDependencyListNode targets)
    {
        MetaprogramDependencyDeclarationNode ret = new MetaprogramDependencyDeclarationNodeImpl(this.<MetaprogramDependencyListNode>makeNormalNodeUnion(targets), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateMetaprogramDependencyDeclarationNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), targets == null ? null : targets.getUid(), startLocation, stopLocation));
        }
        return ret;
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
        MetaprogramDependencyDeclarationNode ret = new MetaprogramDependencyDeclarationNodeImpl(targets, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateMetaprogramDependencyDeclarationNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), targets == null ? null : (targets.getNodeValue() == null ? null : targets.getNodeValue().getUid()), startLocation, stopLocation));
        }
        return ret;
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
        MetaprogramDependencyDeclarationNode ret = new MetaprogramDependencyDeclarationNodeImpl(this.<MetaprogramDependencyListNode>makeNormalNodeUnion(targets), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateMetaprogramDependencyDeclarationNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), targets == null ? null : targets.getUid(), startLocation, stopLocation));
        }
        return ret;
    }
    
    /**
     * Creates a MetaprogramDependencyListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public MetaprogramDependencyListNode makeMetaprogramDependencyListNodeWithUnions(
            List<NodeUnion<? extends MetaprogramDependencyNode>> children)
    {
        MetaprogramDependencyListNode ret = new MetaprogramDependencyListNodeImpl(children, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateMetaprogramDependencyListNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), EditScriptUtilities.getNodeUnionUids(children), startLocation, stopLocation));
        }
        return ret;
    }
    
    /**
     * Creates a MetaprogramDependencyListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public MetaprogramDependencyListNode makeMetaprogramDependencyListNode(
            List<MetaprogramDependencyNode> children)
    {
        MetaprogramDependencyListNode ret = new MetaprogramDependencyListNodeImpl(unionWrapList(children), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateMetaprogramDependencyListNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), EditScriptUtilities.getNodeUids(children), startLocation, stopLocation));
        }
        return ret;
    }
    
    /**
     * Creates a MetaprogramDependencyListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public MetaprogramDependencyListNode makeMetaprogramDependencyListNode(
            MetaprogramDependencyNode... childrenElements)
    {
        List<MetaprogramDependencyNode> children = Arrays.asList(childrenElements);
        return makeMetaprogramDependencyListNode(children, startLocation, stopLocation);
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
        MetaprogramDependencyListNode ret = new MetaprogramDependencyListNodeImpl(children, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateMetaprogramDependencyListNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), EditScriptUtilities.getNodeUnionUids(children), startLocation, stopLocation));
        }
        return ret;
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
        MetaprogramDependencyListNode ret = new MetaprogramDependencyListNodeImpl(unionWrapList(children), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateMetaprogramDependencyListNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), EditScriptUtilities.getNodeUids(children), startLocation, stopLocation));
        }
        return ret;
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
        List<MetaprogramDependencyNode> children = Arrays.asList(childrenElements);
        return makeMetaprogramDependencyListNode(children, startLocation, stopLocation);
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
        MetaprogramDependencyNode ret = new MetaprogramDependencyNodeImpl(targetName, weak, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateMetaprogramDependencyNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), targetName == null ? null : (targetName.getNodeValue() == null ? null : targetName.getNodeValue().getUid()), weak, startLocation, stopLocation));
        }
        return ret;
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
        MetaprogramDependencyNode ret = new MetaprogramDependencyNodeImpl(this.<NameNode>makeNormalNodeUnion(targetName), weak, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateMetaprogramDependencyNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), targetName == null ? null : targetName.getUid(), weak, startLocation, stopLocation));
        }
        return ret;
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
        MetaprogramDependencyNode ret = new MetaprogramDependencyNodeImpl(targetName, weak, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateMetaprogramDependencyNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), targetName == null ? null : (targetName.getNodeValue() == null ? null : targetName.getNodeValue().getUid()), weak, startLocation, stopLocation));
        }
        return ret;
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
        MetaprogramDependencyNode ret = new MetaprogramDependencyNodeImpl(this.<NameNode>makeNormalNodeUnion(targetName), weak, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateMetaprogramDependencyNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), targetName == null ? null : targetName.getUid(), weak, startLocation, stopLocation));
        }
        return ret;
    }
    
    /**
     * Creates a MetaprogramDependencyNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public MetaprogramDependencyNode makeMetaprogramDependencyNode(
            NameNode targetName)
    {
        MetaprogramDependencyNode ret = new MetaprogramDependencyNodeImpl(this.<NameNode>makeNormalNodeUnion(targetName), false, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateMetaprogramDependencyNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), targetName == null ? null : targetName.getUid(), ret.getWeak(), startLocation, stopLocation));
        }
        return ret;
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
        MetaprogramDependencyNode ret = new MetaprogramDependencyNodeImpl(this.<NameNode>makeNormalNodeUnion(targetName), false, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateMetaprogramDependencyNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), targetName == null ? null : targetName.getUid(), ret.getWeak(), startLocation, stopLocation));
        }
        return ret;
    }
    
    /**
     * Creates a MetaprogramImportListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public MetaprogramImportListNode makeMetaprogramImportListNodeWithUnions(
            List<NodeUnion<? extends MetaprogramImportNode>> children)
    {
        MetaprogramImportListNode ret = new MetaprogramImportListNodeImpl(children, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateMetaprogramImportListNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), EditScriptUtilities.getNodeUnionUids(children), startLocation, stopLocation));
        }
        return ret;
    }
    
    /**
     * Creates a MetaprogramImportListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public MetaprogramImportListNode makeMetaprogramImportListNode(
            List<MetaprogramImportNode> children)
    {
        MetaprogramImportListNode ret = new MetaprogramImportListNodeImpl(unionWrapList(children), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateMetaprogramImportListNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), EditScriptUtilities.getNodeUids(children), startLocation, stopLocation));
        }
        return ret;
    }
    
    /**
     * Creates a MetaprogramImportListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public MetaprogramImportListNode makeMetaprogramImportListNode(
            MetaprogramImportNode... childrenElements)
    {
        List<MetaprogramImportNode> children = Arrays.asList(childrenElements);
        return makeMetaprogramImportListNode(children, startLocation, stopLocation);
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
        MetaprogramImportListNode ret = new MetaprogramImportListNodeImpl(children, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateMetaprogramImportListNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), EditScriptUtilities.getNodeUnionUids(children), startLocation, stopLocation));
        }
        return ret;
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
        MetaprogramImportListNode ret = new MetaprogramImportListNodeImpl(unionWrapList(children), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateMetaprogramImportListNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), EditScriptUtilities.getNodeUids(children), startLocation, stopLocation));
        }
        return ret;
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
        List<MetaprogramImportNode> children = Arrays.asList(childrenElements);
        return makeMetaprogramImportListNode(children, startLocation, stopLocation);
    }
    
    /**
     * Creates a MetaprogramImportNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public MetaprogramImportNode makeMetaprogramImportNodeWithUnions(
            NodeUnion<? extends ImportNode> importNode)
    {
        MetaprogramImportNode ret = new MetaprogramImportNodeImpl(importNode, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateMetaprogramImportNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), importNode == null ? null : (importNode.getNodeValue() == null ? null : importNode.getNodeValue().getUid()), startLocation, stopLocation));
        }
        return ret;
    }
    
    /**
     * Creates a MetaprogramImportNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public MetaprogramImportNode makeMetaprogramImportNode(
            ImportNode importNode)
    {
        MetaprogramImportNode ret = new MetaprogramImportNodeImpl(this.<ImportNode>makeNormalNodeUnion(importNode), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateMetaprogramImportNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), importNode == null ? null : importNode.getUid(), startLocation, stopLocation));
        }
        return ret;
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
        MetaprogramImportNode ret = new MetaprogramImportNodeImpl(importNode, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateMetaprogramImportNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), importNode == null ? null : (importNode.getNodeValue() == null ? null : importNode.getNodeValue().getUid()), startLocation, stopLocation));
        }
        return ret;
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
        MetaprogramImportNode ret = new MetaprogramImportNodeImpl(this.<ImportNode>makeNormalNodeUnion(importNode), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateMetaprogramImportNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), importNode == null ? null : importNode.getUid(), startLocation, stopLocation));
        }
        return ret;
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
        MetaprogramNode ret = new MetaprogramNodeImpl(preamble, body, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateMetaprogramNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), preamble == null ? null : (preamble.getNodeValue() == null ? null : preamble.getNodeValue().getUid()), body == null ? null : (body.getNodeValue() == null ? null : body.getNodeValue().getUid()), startLocation, stopLocation));
        }
        return ret;
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
        MetaprogramNode ret = new MetaprogramNodeImpl(this.<MetaprogramPreambleNode>makeNormalNodeUnion(preamble), this.<BlockStatementListNode>makeNormalNodeUnion(body), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateMetaprogramNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), preamble == null ? null : preamble.getUid(), body == null ? null : body.getUid(), startLocation, stopLocation));
        }
        return ret;
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
        MetaprogramNode ret = new MetaprogramNodeImpl(preamble, body, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateMetaprogramNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), preamble == null ? null : (preamble.getNodeValue() == null ? null : preamble.getNodeValue().getUid()), body == null ? null : (body.getNodeValue() == null ? null : body.getNodeValue().getUid()), startLocation, stopLocation));
        }
        return ret;
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
        MetaprogramNode ret = new MetaprogramNodeImpl(this.<MetaprogramPreambleNode>makeNormalNodeUnion(preamble), this.<BlockStatementListNode>makeNormalNodeUnion(body), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateMetaprogramNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), preamble == null ? null : preamble.getUid(), body == null ? null : body.getUid(), startLocation, stopLocation));
        }
        return ret;
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
        MetaprogramPreambleNode ret = new MetaprogramPreambleNodeImpl(imports, localMode, packageMode, targets, dependencies, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateMetaprogramPreambleNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), imports == null ? null : (imports.getNodeValue() == null ? null : imports.getNodeValue().getUid()), localMode, packageMode, targets == null ? null : (targets.getNodeValue() == null ? null : targets.getNodeValue().getUid()), dependencies == null ? null : (dependencies.getNodeValue() == null ? null : dependencies.getNodeValue().getUid()), startLocation, stopLocation));
        }
        return ret;
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
        MetaprogramPreambleNode ret = new MetaprogramPreambleNodeImpl(this.<MetaprogramImportListNode>makeNormalNodeUnion(imports), localMode, packageMode, this.<MetaprogramTargetListNode>makeNormalNodeUnion(targets), this.<MetaprogramDependencyDeclarationListNode>makeNormalNodeUnion(dependencies), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateMetaprogramPreambleNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), imports == null ? null : imports.getUid(), localMode, packageMode, targets == null ? null : targets.getUid(), dependencies == null ? null : dependencies.getUid(), startLocation, stopLocation));
        }
        return ret;
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
        MetaprogramPreambleNode ret = new MetaprogramPreambleNodeImpl(imports, localMode, packageMode, targets, dependencies, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateMetaprogramPreambleNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), imports == null ? null : (imports.getNodeValue() == null ? null : imports.getNodeValue().getUid()), localMode, packageMode, targets == null ? null : (targets.getNodeValue() == null ? null : targets.getNodeValue().getUid()), dependencies == null ? null : (dependencies.getNodeValue() == null ? null : dependencies.getNodeValue().getUid()), startLocation, stopLocation));
        }
        return ret;
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
        MetaprogramPreambleNode ret = new MetaprogramPreambleNodeImpl(this.<MetaprogramImportListNode>makeNormalNodeUnion(imports), localMode, packageMode, this.<MetaprogramTargetListNode>makeNormalNodeUnion(targets), this.<MetaprogramDependencyDeclarationListNode>makeNormalNodeUnion(dependencies), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateMetaprogramPreambleNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), imports == null ? null : imports.getUid(), localMode, packageMode, targets == null ? null : targets.getUid(), dependencies == null ? null : dependencies.getUid(), startLocation, stopLocation));
        }
        return ret;
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
        MetaprogramPreambleNode ret = new MetaprogramPreambleNodeImpl(this.<MetaprogramImportListNode>makeNormalNodeUnion(imports), MetaprogramLocalMode.INSERT, MetaprogramPackageMode.READ_ONLY, this.<MetaprogramTargetListNode>makeNormalNodeUnion(targets), this.<MetaprogramDependencyDeclarationListNode>makeNormalNodeUnion(dependencies), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateMetaprogramPreambleNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), imports == null ? null : imports.getUid(), ret.getLocalMode(), ret.getPackageMode(), targets == null ? null : targets.getUid(), dependencies == null ? null : dependencies.getUid(), startLocation, stopLocation));
        }
        return ret;
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
        MetaprogramPreambleNode ret = new MetaprogramPreambleNodeImpl(this.<MetaprogramImportListNode>makeNormalNodeUnion(imports), MetaprogramLocalMode.INSERT, MetaprogramPackageMode.READ_ONLY, this.<MetaprogramTargetListNode>makeNormalNodeUnion(targets), this.<MetaprogramDependencyDeclarationListNode>makeNormalNodeUnion(dependencies), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateMetaprogramPreambleNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), imports == null ? null : imports.getUid(), ret.getLocalMode(), ret.getPackageMode(), targets == null ? null : targets.getUid(), dependencies == null ? null : dependencies.getUid(), startLocation, stopLocation));
        }
        return ret;
    }
    
    /**
     * Creates a MetaprogramTargetListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public MetaprogramTargetListNode makeMetaprogramTargetListNodeWithUnions(
            List<NodeUnion<? extends MetaprogramTargetNode>> children)
    {
        MetaprogramTargetListNode ret = new MetaprogramTargetListNodeImpl(children, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateMetaprogramTargetListNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), EditScriptUtilities.getNodeUnionUids(children), startLocation, stopLocation));
        }
        return ret;
    }
    
    /**
     * Creates a MetaprogramTargetListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public MetaprogramTargetListNode makeMetaprogramTargetListNode(
            List<MetaprogramTargetNode> children)
    {
        MetaprogramTargetListNode ret = new MetaprogramTargetListNodeImpl(unionWrapList(children), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateMetaprogramTargetListNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), EditScriptUtilities.getNodeUids(children), startLocation, stopLocation));
        }
        return ret;
    }
    
    /**
     * Creates a MetaprogramTargetListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public MetaprogramTargetListNode makeMetaprogramTargetListNode(
            MetaprogramTargetNode... childrenElements)
    {
        List<MetaprogramTargetNode> children = Arrays.asList(childrenElements);
        return makeMetaprogramTargetListNode(children, startLocation, stopLocation);
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
        MetaprogramTargetListNode ret = new MetaprogramTargetListNodeImpl(children, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateMetaprogramTargetListNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), EditScriptUtilities.getNodeUnionUids(children), startLocation, stopLocation));
        }
        return ret;
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
        MetaprogramTargetListNode ret = new MetaprogramTargetListNodeImpl(unionWrapList(children), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateMetaprogramTargetListNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), EditScriptUtilities.getNodeUids(children), startLocation, stopLocation));
        }
        return ret;
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
        List<MetaprogramTargetNode> children = Arrays.asList(childrenElements);
        return makeMetaprogramTargetListNode(children, startLocation, stopLocation);
    }
    
    /**
     * Creates a MetaprogramTargetNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public MetaprogramTargetNode makeMetaprogramTargetNodeWithUnions(
            NodeUnion<? extends IdentifierListNode> targets)
    {
        MetaprogramTargetNode ret = new MetaprogramTargetNodeImpl(targets, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateMetaprogramTargetNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), targets == null ? null : (targets.getNodeValue() == null ? null : targets.getNodeValue().getUid()), startLocation, stopLocation));
        }
        return ret;
    }
    
    /**
     * Creates a MetaprogramTargetNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public MetaprogramTargetNode makeMetaprogramTargetNode(
            IdentifierListNode targets)
    {
        MetaprogramTargetNode ret = new MetaprogramTargetNodeImpl(this.<IdentifierListNode>makeNormalNodeUnion(targets), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateMetaprogramTargetNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), targets == null ? null : targets.getUid(), startLocation, stopLocation));
        }
        return ret;
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
        MetaprogramTargetNode ret = new MetaprogramTargetNodeImpl(targets, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateMetaprogramTargetNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), targets == null ? null : (targets.getNodeValue() == null ? null : targets.getNodeValue().getUid()), startLocation, stopLocation));
        }
        return ret;
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
        MetaprogramTargetNode ret = new MetaprogramTargetNodeImpl(this.<IdentifierListNode>makeNormalNodeUnion(targets), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateMetaprogramTargetNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), targets == null ? null : targets.getUid(), startLocation, stopLocation));
        }
        return ret;
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
        MethodDeclarationNode ret = new MethodDeclarationNodeImpl(body, modifiers, identifier, parameters, varargParameter, returnType, throwTypes, typeParameters, javadoc, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateMethodDeclarationNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), body == null ? null : (body.getNodeValue() == null ? null : body.getNodeValue().getUid()), modifiers == null ? null : (modifiers.getNodeValue() == null ? null : modifiers.getNodeValue().getUid()), identifier == null ? null : (identifier.getNodeValue() == null ? null : identifier.getNodeValue().getUid()), parameters == null ? null : (parameters.getNodeValue() == null ? null : parameters.getNodeValue().getUid()), varargParameter == null ? null : (varargParameter.getNodeValue() == null ? null : varargParameter.getNodeValue().getUid()), returnType == null ? null : (returnType.getNodeValue() == null ? null : returnType.getNodeValue().getUid()), throwTypes == null ? null : (throwTypes.getNodeValue() == null ? null : throwTypes.getNodeValue().getUid()), typeParameters == null ? null : (typeParameters.getNodeValue() == null ? null : typeParameters.getNodeValue().getUid()), javadoc == null ? null : (javadoc.getNodeValue() == null ? null : javadoc.getNodeValue().getUid()), startLocation, stopLocation));
        }
        return ret;
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
        MethodDeclarationNode ret = new MethodDeclarationNodeImpl(this.<BlockStatementListNode>makeNormalNodeUnion(body), this.<MethodModifiersNode>makeNormalNodeUnion(modifiers), this.<IdentifierNode>makeNormalNodeUnion(identifier), this.<VariableListNode>makeNormalNodeUnion(parameters), this.<VariableNode>makeNormalNodeUnion(varargParameter), this.<TypeNode>makeNormalNodeUnion(returnType), this.<UnparameterizedTypeListNode>makeNormalNodeUnion(throwTypes), this.<TypeParameterListNode>makeNormalNodeUnion(typeParameters), this.<JavadocNode>makeNormalNodeUnion(javadoc), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateMethodDeclarationNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), body == null ? null : body.getUid(), modifiers == null ? null : modifiers.getUid(), identifier == null ? null : identifier.getUid(), parameters == null ? null : parameters.getUid(), varargParameter == null ? null : varargParameter.getUid(), returnType == null ? null : returnType.getUid(), throwTypes == null ? null : throwTypes.getUid(), typeParameters == null ? null : typeParameters.getUid(), javadoc == null ? null : javadoc.getUid(), startLocation, stopLocation));
        }
        return ret;
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
        MethodDeclarationNode ret = new MethodDeclarationNodeImpl(body, modifiers, identifier, parameters, varargParameter, returnType, throwTypes, typeParameters, javadoc, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateMethodDeclarationNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), body == null ? null : (body.getNodeValue() == null ? null : body.getNodeValue().getUid()), modifiers == null ? null : (modifiers.getNodeValue() == null ? null : modifiers.getNodeValue().getUid()), identifier == null ? null : (identifier.getNodeValue() == null ? null : identifier.getNodeValue().getUid()), parameters == null ? null : (parameters.getNodeValue() == null ? null : parameters.getNodeValue().getUid()), varargParameter == null ? null : (varargParameter.getNodeValue() == null ? null : varargParameter.getNodeValue().getUid()), returnType == null ? null : (returnType.getNodeValue() == null ? null : returnType.getNodeValue().getUid()), throwTypes == null ? null : (throwTypes.getNodeValue() == null ? null : throwTypes.getNodeValue().getUid()), typeParameters == null ? null : (typeParameters.getNodeValue() == null ? null : typeParameters.getNodeValue().getUid()), javadoc == null ? null : (javadoc.getNodeValue() == null ? null : javadoc.getNodeValue().getUid()), startLocation, stopLocation));
        }
        return ret;
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
        MethodDeclarationNode ret = new MethodDeclarationNodeImpl(this.<BlockStatementListNode>makeNormalNodeUnion(body), this.<MethodModifiersNode>makeNormalNodeUnion(modifiers), this.<IdentifierNode>makeNormalNodeUnion(identifier), this.<VariableListNode>makeNormalNodeUnion(parameters), this.<VariableNode>makeNormalNodeUnion(varargParameter), this.<TypeNode>makeNormalNodeUnion(returnType), this.<UnparameterizedTypeListNode>makeNormalNodeUnion(throwTypes), this.<TypeParameterListNode>makeNormalNodeUnion(typeParameters), this.<JavadocNode>makeNormalNodeUnion(javadoc), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateMethodDeclarationNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), body == null ? null : body.getUid(), modifiers == null ? null : modifiers.getUid(), identifier == null ? null : identifier.getUid(), parameters == null ? null : parameters.getUid(), varargParameter == null ? null : varargParameter.getUid(), returnType == null ? null : returnType.getUid(), throwTypes == null ? null : throwTypes.getUid(), typeParameters == null ? null : typeParameters.getUid(), javadoc == null ? null : javadoc.getUid(), startLocation, stopLocation));
        }
        return ret;
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
        MethodDeclarationNode ret = new MethodDeclarationNodeImpl(this.<BlockStatementListNode>makeNormalNodeUnion(body), this.<MethodModifiersNode>makeNormalNodeUnion(modifiers), this.<IdentifierNode>makeNormalNodeUnion(identifier), this.<VariableListNode>makeNormalNodeUnion(parameters), this.<VariableNode>makeNormalNodeUnion(null), this.<TypeNode>makeNormalNodeUnion(returnType), this.<UnparameterizedTypeListNode>makeNormalNodeUnion(makeUnparameterizedTypeListNode()), this.<TypeParameterListNode>makeNormalNodeUnion(makeTypeParameterListNode()), this.<JavadocNode>makeNormalNodeUnion(javadoc), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateMethodDeclarationNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), body == null ? null : body.getUid(), modifiers == null ? null : modifiers.getUid(), identifier == null ? null : identifier.getUid(), parameters == null ? null : parameters.getUid(), ret.getVarargParameter() == null ? null : ret.getVarargParameter().getUid(), returnType == null ? null : returnType.getUid(), ret.getThrowTypes() == null ? null : ret.getThrowTypes().getUid(), ret.getTypeParameters() == null ? null : ret.getTypeParameters().getUid(), javadoc == null ? null : javadoc.getUid(), startLocation, stopLocation));
        }
        return ret;
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
        MethodDeclarationNode ret = new MethodDeclarationNodeImpl(this.<BlockStatementListNode>makeNormalNodeUnion(body), this.<MethodModifiersNode>makeNormalNodeUnion(modifiers), this.<IdentifierNode>makeNormalNodeUnion(identifier), this.<VariableListNode>makeNormalNodeUnion(parameters), this.<VariableNode>makeNormalNodeUnion(null), this.<TypeNode>makeNormalNodeUnion(returnType), this.<UnparameterizedTypeListNode>makeNormalNodeUnion(makeUnparameterizedTypeListNode()), this.<TypeParameterListNode>makeNormalNodeUnion(makeTypeParameterListNode()), this.<JavadocNode>makeNormalNodeUnion(javadoc), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateMethodDeclarationNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), body == null ? null : body.getUid(), modifiers == null ? null : modifiers.getUid(), identifier == null ? null : identifier.getUid(), parameters == null ? null : parameters.getUid(), ret.getVarargParameter() == null ? null : ret.getVarargParameter().getUid(), returnType == null ? null : returnType.getUid(), ret.getThrowTypes() == null ? null : ret.getThrowTypes().getUid(), ret.getTypeParameters() == null ? null : ret.getTypeParameters().getUid(), javadoc == null ? null : javadoc.getUid(), startLocation, stopLocation));
        }
        return ret;
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
        MethodInvocationNode ret = new MethodInvocationNodeImpl(expression, identifier, arguments, typeArguments, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateMethodInvocationNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), expression == null ? null : (expression.getNodeValue() == null ? null : expression.getNodeValue().getUid()), identifier == null ? null : (identifier.getNodeValue() == null ? null : identifier.getNodeValue().getUid()), arguments == null ? null : (arguments.getNodeValue() == null ? null : arguments.getNodeValue().getUid()), typeArguments == null ? null : (typeArguments.getNodeValue() == null ? null : typeArguments.getNodeValue().getUid()), startLocation, stopLocation));
        }
        return ret;
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
        MethodInvocationNode ret = new MethodInvocationNodeImpl(this.<PrimaryExpressionNode>makeNormalNodeUnion(expression), this.<IdentifierNode>makeNormalNodeUnion(identifier), this.<ExpressionListNode>makeNormalNodeUnion(arguments), this.<ReferenceTypeListNode>makeNormalNodeUnion(typeArguments), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateMethodInvocationNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), expression == null ? null : expression.getUid(), identifier == null ? null : identifier.getUid(), arguments == null ? null : arguments.getUid(), typeArguments == null ? null : typeArguments.getUid(), startLocation, stopLocation));
        }
        return ret;
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
        MethodInvocationNode ret = new MethodInvocationNodeImpl(expression, identifier, arguments, typeArguments, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateMethodInvocationNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), expression == null ? null : (expression.getNodeValue() == null ? null : expression.getNodeValue().getUid()), identifier == null ? null : (identifier.getNodeValue() == null ? null : identifier.getNodeValue().getUid()), arguments == null ? null : (arguments.getNodeValue() == null ? null : arguments.getNodeValue().getUid()), typeArguments == null ? null : (typeArguments.getNodeValue() == null ? null : typeArguments.getNodeValue().getUid()), startLocation, stopLocation));
        }
        return ret;
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
        MethodInvocationNode ret = new MethodInvocationNodeImpl(this.<PrimaryExpressionNode>makeNormalNodeUnion(expression), this.<IdentifierNode>makeNormalNodeUnion(identifier), this.<ExpressionListNode>makeNormalNodeUnion(arguments), this.<ReferenceTypeListNode>makeNormalNodeUnion(typeArguments), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateMethodInvocationNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), expression == null ? null : expression.getUid(), identifier == null ? null : identifier.getUid(), arguments == null ? null : arguments.getUid(), typeArguments == null ? null : typeArguments.getUid(), startLocation, stopLocation));
        }
        return ret;
    }
    
    /**
     * Creates a MethodInvocationNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public MethodInvocationNode makeMethodInvocationNode(
            IdentifierNode identifier)
    {
        MethodInvocationNode ret = new MethodInvocationNodeImpl(this.<PrimaryExpressionNode>makeNormalNodeUnion(null), this.<IdentifierNode>makeNormalNodeUnion(identifier), this.<ExpressionListNode>makeNormalNodeUnion(makeExpressionListNode()), this.<ReferenceTypeListNode>makeNormalNodeUnion(makeReferenceTypeListNode()), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateMethodInvocationNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), ret.getExpression() == null ? null : ret.getExpression().getUid(), identifier == null ? null : identifier.getUid(), ret.getArguments() == null ? null : ret.getArguments().getUid(), ret.getTypeArguments() == null ? null : ret.getTypeArguments().getUid(), startLocation, stopLocation));
        }
        return ret;
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
        MethodInvocationNode ret = new MethodInvocationNodeImpl(this.<PrimaryExpressionNode>makeNormalNodeUnion(null), this.<IdentifierNode>makeNormalNodeUnion(identifier), this.<ExpressionListNode>makeNormalNodeUnion(makeExpressionListNode()), this.<ReferenceTypeListNode>makeNormalNodeUnion(makeReferenceTypeListNode()), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateMethodInvocationNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), ret.getExpression() == null ? null : ret.getExpression().getUid(), identifier == null ? null : identifier.getUid(), ret.getArguments() == null ? null : ret.getArguments().getUid(), ret.getTypeArguments() == null ? null : ret.getTypeArguments().getUid(), startLocation, stopLocation));
        }
        return ret;
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
        MethodInvocationNode ret = new MethodInvocationNodeImpl(this.<PrimaryExpressionNode>makeNormalNodeUnion(expression), this.<IdentifierNode>makeNormalNodeUnion(identifier), this.<ExpressionListNode>makeNormalNodeUnion(makeExpressionListNode()), this.<ReferenceTypeListNode>makeNormalNodeUnion(makeReferenceTypeListNode()), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateMethodInvocationNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), expression == null ? null : expression.getUid(), identifier == null ? null : identifier.getUid(), ret.getArguments() == null ? null : ret.getArguments().getUid(), ret.getTypeArguments() == null ? null : ret.getTypeArguments().getUid(), startLocation, stopLocation));
        }
        return ret;
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
        MethodInvocationNode ret = new MethodInvocationNodeImpl(this.<PrimaryExpressionNode>makeNormalNodeUnion(expression), this.<IdentifierNode>makeNormalNodeUnion(identifier), this.<ExpressionListNode>makeNormalNodeUnion(makeExpressionListNode()), this.<ReferenceTypeListNode>makeNormalNodeUnion(makeReferenceTypeListNode()), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateMethodInvocationNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), expression == null ? null : expression.getUid(), identifier == null ? null : identifier.getUid(), ret.getArguments() == null ? null : ret.getArguments().getUid(), ret.getTypeArguments() == null ? null : ret.getTypeArguments().getUid(), startLocation, stopLocation));
        }
        return ret;
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
        MethodInvocationNode ret = new MethodInvocationNodeImpl(this.<PrimaryExpressionNode>makeNormalNodeUnion(null), this.<IdentifierNode>makeNormalNodeUnion(identifier), this.<ExpressionListNode>makeNormalNodeUnion(arguments), this.<ReferenceTypeListNode>makeNormalNodeUnion(makeReferenceTypeListNode()), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateMethodInvocationNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), ret.getExpression() == null ? null : ret.getExpression().getUid(), identifier == null ? null : identifier.getUid(), arguments == null ? null : arguments.getUid(), ret.getTypeArguments() == null ? null : ret.getTypeArguments().getUid(), startLocation, stopLocation));
        }
        return ret;
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
        MethodInvocationNode ret = new MethodInvocationNodeImpl(this.<PrimaryExpressionNode>makeNormalNodeUnion(null), this.<IdentifierNode>makeNormalNodeUnion(identifier), this.<ExpressionListNode>makeNormalNodeUnion(arguments), this.<ReferenceTypeListNode>makeNormalNodeUnion(makeReferenceTypeListNode()), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateMethodInvocationNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), ret.getExpression() == null ? null : ret.getExpression().getUid(), identifier == null ? null : identifier.getUid(), arguments == null ? null : arguments.getUid(), ret.getTypeArguments() == null ? null : ret.getTypeArguments().getUid(), startLocation, stopLocation));
        }
        return ret;
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
        MethodInvocationNode ret = new MethodInvocationNodeImpl(this.<PrimaryExpressionNode>makeNormalNodeUnion(expression), this.<IdentifierNode>makeNormalNodeUnion(identifier), this.<ExpressionListNode>makeNormalNodeUnion(arguments), this.<ReferenceTypeListNode>makeNormalNodeUnion(makeReferenceTypeListNode()), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateMethodInvocationNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), expression == null ? null : expression.getUid(), identifier == null ? null : identifier.getUid(), arguments == null ? null : arguments.getUid(), ret.getTypeArguments() == null ? null : ret.getTypeArguments().getUid(), startLocation, stopLocation));
        }
        return ret;
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
        MethodInvocationNode ret = new MethodInvocationNodeImpl(this.<PrimaryExpressionNode>makeNormalNodeUnion(expression), this.<IdentifierNode>makeNormalNodeUnion(identifier), this.<ExpressionListNode>makeNormalNodeUnion(arguments), this.<ReferenceTypeListNode>makeNormalNodeUnion(makeReferenceTypeListNode()), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateMethodInvocationNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), expression == null ? null : expression.getUid(), identifier == null ? null : identifier.getUid(), arguments == null ? null : arguments.getUid(), ret.getTypeArguments() == null ? null : ret.getTypeArguments().getUid(), startLocation, stopLocation));
        }
        return ret;
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
        MethodModifiersNode ret = new MethodModifiersNodeImpl(access, abstractFlag, staticFlag, finalFlag, synchronizedFlag, nativeFlag, strictfpFlag, metaAnnotations, annotations, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateMethodModifiersNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), access, abstractFlag, staticFlag, finalFlag, synchronizedFlag, nativeFlag, strictfpFlag, metaAnnotations == null ? null : (metaAnnotations.getNodeValue() == null ? null : metaAnnotations.getNodeValue().getUid()), annotations == null ? null : (annotations.getNodeValue() == null ? null : annotations.getNodeValue().getUid()), startLocation, stopLocation));
        }
        return ret;
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
        MethodModifiersNode ret = new MethodModifiersNodeImpl(access, abstractFlag, staticFlag, finalFlag, synchronizedFlag, nativeFlag, strictfpFlag, this.<MetaAnnotationListNode>makeNormalNodeUnion(metaAnnotations), this.<AnnotationListNode>makeNormalNodeUnion(annotations), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateMethodModifiersNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), access, abstractFlag, staticFlag, finalFlag, synchronizedFlag, nativeFlag, strictfpFlag, metaAnnotations == null ? null : metaAnnotations.getUid(), annotations == null ? null : annotations.getUid(), startLocation, stopLocation));
        }
        return ret;
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
        MethodModifiersNode ret = new MethodModifiersNodeImpl(access, abstractFlag, staticFlag, finalFlag, synchronizedFlag, nativeFlag, strictfpFlag, metaAnnotations, annotations, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateMethodModifiersNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), access, abstractFlag, staticFlag, finalFlag, synchronizedFlag, nativeFlag, strictfpFlag, metaAnnotations == null ? null : (metaAnnotations.getNodeValue() == null ? null : metaAnnotations.getNodeValue().getUid()), annotations == null ? null : (annotations.getNodeValue() == null ? null : annotations.getNodeValue().getUid()), startLocation, stopLocation));
        }
        return ret;
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
        MethodModifiersNode ret = new MethodModifiersNodeImpl(access, abstractFlag, staticFlag, finalFlag, synchronizedFlag, nativeFlag, strictfpFlag, this.<MetaAnnotationListNode>makeNormalNodeUnion(metaAnnotations), this.<AnnotationListNode>makeNormalNodeUnion(annotations), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateMethodModifiersNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), access, abstractFlag, staticFlag, finalFlag, synchronizedFlag, nativeFlag, strictfpFlag, metaAnnotations == null ? null : metaAnnotations.getUid(), annotations == null ? null : annotations.getUid(), startLocation, stopLocation));
        }
        return ret;
    }
    
    /**
     * Creates a MethodModifiersNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public MethodModifiersNode makeMethodModifiersNode(
            AccessModifier access)
    {
        MethodModifiersNode ret = new MethodModifiersNodeImpl(access, false, false, false, false, false, false, this.<MetaAnnotationListNode>makeNormalNodeUnion(makeMetaAnnotationListNode()), this.<AnnotationListNode>makeNormalNodeUnion(makeAnnotationListNode()), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateMethodModifiersNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), access, ret.getAbstractFlag(), ret.getStaticFlag(), ret.getFinalFlag(), ret.getSynchronizedFlag(), ret.getNativeFlag(), ret.getStrictfpFlag(), ret.getMetaAnnotations() == null ? null : ret.getMetaAnnotations().getUid(), ret.getAnnotations() == null ? null : ret.getAnnotations().getUid(), startLocation, stopLocation));
        }
        return ret;
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
        MethodModifiersNode ret = new MethodModifiersNodeImpl(access, false, false, false, false, false, false, this.<MetaAnnotationListNode>makeNormalNodeUnion(makeMetaAnnotationListNode()), this.<AnnotationListNode>makeNormalNodeUnion(makeAnnotationListNode()), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateMethodModifiersNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), access, ret.getAbstractFlag(), ret.getStaticFlag(), ret.getFinalFlag(), ret.getSynchronizedFlag(), ret.getNativeFlag(), ret.getStrictfpFlag(), ret.getMetaAnnotations() == null ? null : ret.getMetaAnnotations().getUid(), ret.getAnnotations() == null ? null : ret.getAnnotations().getUid(), startLocation, stopLocation));
        }
        return ret;
    }
    
    /**
     * Creates a NoOperationNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public NoOperationNode makeNoOperationNodeWithUnions(
            NodeUnion<? extends MetaAnnotationListNode> metaAnnotations)
    {
        NoOperationNode ret = new NoOperationNodeImpl(metaAnnotations, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateNoOperationNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), metaAnnotations == null ? null : (metaAnnotations.getNodeValue() == null ? null : metaAnnotations.getNodeValue().getUid()), startLocation, stopLocation));
        }
        return ret;
    }
    
    /**
     * Creates a NoOperationNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public NoOperationNode makeNoOperationNode(
            MetaAnnotationListNode metaAnnotations)
    {
        NoOperationNode ret = new NoOperationNodeImpl(this.<MetaAnnotationListNode>makeNormalNodeUnion(metaAnnotations), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateNoOperationNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), metaAnnotations == null ? null : metaAnnotations.getUid(), startLocation, stopLocation));
        }
        return ret;
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
        NoOperationNode ret = new NoOperationNodeImpl(metaAnnotations, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateNoOperationNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), metaAnnotations == null ? null : (metaAnnotations.getNodeValue() == null ? null : metaAnnotations.getNodeValue().getUid()), startLocation, stopLocation));
        }
        return ret;
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
        NoOperationNode ret = new NoOperationNodeImpl(this.<MetaAnnotationListNode>makeNormalNodeUnion(metaAnnotations), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateNoOperationNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), metaAnnotations == null ? null : metaAnnotations.getUid(), startLocation, stopLocation));
        }
        return ret;
    }
    
    /**
     * Creates a NoOperationNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public NoOperationNode makeNoOperationNode(
    )
    {
        NoOperationNode ret = new NoOperationNodeImpl(this.<MetaAnnotationListNode>makeNormalNodeUnion(makeMetaAnnotationListNode()), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateNoOperationNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), ret.getMetaAnnotations() == null ? null : ret.getMetaAnnotations().getUid(), startLocation, stopLocation));
        }
        return ret;
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
        NoOperationNode ret = new NoOperationNodeImpl(this.<MetaAnnotationListNode>makeNormalNodeUnion(makeMetaAnnotationListNode()), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateNoOperationNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), ret.getMetaAnnotations() == null ? null : ret.getMetaAnnotations().getUid(), startLocation, stopLocation));
        }
        return ret;
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
        NormalAnnotationNode ret = new NormalAnnotationNodeImpl(arguments, annotationType, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateNormalAnnotationNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), arguments == null ? null : (arguments.getNodeValue() == null ? null : arguments.getNodeValue().getUid()), annotationType == null ? null : (annotationType.getNodeValue() == null ? null : annotationType.getNodeValue().getUid()), startLocation, stopLocation));
        }
        return ret;
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
        NormalAnnotationNode ret = new NormalAnnotationNodeImpl(this.<AnnotationElementListNode>makeNormalNodeUnion(arguments), this.<UnparameterizedTypeNode>makeNormalNodeUnion(annotationType), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateNormalAnnotationNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), arguments == null ? null : arguments.getUid(), annotationType == null ? null : annotationType.getUid(), startLocation, stopLocation));
        }
        return ret;
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
        NormalAnnotationNode ret = new NormalAnnotationNodeImpl(arguments, annotationType, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateNormalAnnotationNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), arguments == null ? null : (arguments.getNodeValue() == null ? null : arguments.getNodeValue().getUid()), annotationType == null ? null : (annotationType.getNodeValue() == null ? null : annotationType.getNodeValue().getUid()), startLocation, stopLocation));
        }
        return ret;
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
        NormalAnnotationNode ret = new NormalAnnotationNodeImpl(this.<AnnotationElementListNode>makeNormalNodeUnion(arguments), this.<UnparameterizedTypeNode>makeNormalNodeUnion(annotationType), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateNormalAnnotationNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), arguments == null ? null : arguments.getUid(), annotationType == null ? null : annotationType.getUid(), startLocation, stopLocation));
        }
        return ret;
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
        NormalMetaAnnotationNode ret = new NormalMetaAnnotationNodeImpl(arguments, annotationType, metaprogramAnchor, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateNormalMetaAnnotationNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), arguments == null ? null : (arguments.getNodeValue() == null ? null : arguments.getNodeValue().getUid()), annotationType == null ? null : (annotationType.getNodeValue() == null ? null : annotationType.getNodeValue().getUid()), metaprogramAnchor == null ? null : metaprogramAnchor.getUid(), startLocation, stopLocation));
        }
        return ret;
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
        NormalMetaAnnotationNode ret = new NormalMetaAnnotationNodeImpl(this.<MetaAnnotationElementListNode>makeNormalNodeUnion(arguments), this.<UnparameterizedTypeNode>makeNormalNodeUnion(annotationType), metaprogramAnchor, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateNormalMetaAnnotationNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), arguments == null ? null : arguments.getUid(), annotationType == null ? null : annotationType.getUid(), metaprogramAnchor == null ? null : metaprogramAnchor.getUid(), startLocation, stopLocation));
        }
        return ret;
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
        NormalMetaAnnotationNode ret = new NormalMetaAnnotationNodeImpl(arguments, annotationType, metaprogramAnchor, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateNormalMetaAnnotationNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), arguments == null ? null : (arguments.getNodeValue() == null ? null : arguments.getNodeValue().getUid()), annotationType == null ? null : (annotationType.getNodeValue() == null ? null : annotationType.getNodeValue().getUid()), metaprogramAnchor == null ? null : metaprogramAnchor.getUid(), startLocation, stopLocation));
        }
        return ret;
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
        NormalMetaAnnotationNode ret = new NormalMetaAnnotationNodeImpl(this.<MetaAnnotationElementListNode>makeNormalNodeUnion(arguments), this.<UnparameterizedTypeNode>makeNormalNodeUnion(annotationType), metaprogramAnchor, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateNormalMetaAnnotationNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), arguments == null ? null : arguments.getUid(), annotationType == null ? null : annotationType.getUid(), metaprogramAnchor == null ? null : metaprogramAnchor.getUid(), startLocation, stopLocation));
        }
        return ret;
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
        NormalMetaAnnotationNode ret = new NormalMetaAnnotationNodeImpl(this.<MetaAnnotationElementListNode>makeNormalNodeUnion(arguments), this.<UnparameterizedTypeNode>makeNormalNodeUnion(annotationType), makeMetaAnnotationMetaprogramAnchorNode(), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateNormalMetaAnnotationNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), arguments == null ? null : arguments.getUid(), annotationType == null ? null : annotationType.getUid(), ret.getMetaprogramAnchor() == null ? null : ret.getMetaprogramAnchor().getUid(), startLocation, stopLocation));
        }
        return ret;
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
        NormalMetaAnnotationNode ret = new NormalMetaAnnotationNodeImpl(this.<MetaAnnotationElementListNode>makeNormalNodeUnion(arguments), this.<UnparameterizedTypeNode>makeNormalNodeUnion(annotationType), makeMetaAnnotationMetaprogramAnchorNode(), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateNormalMetaAnnotationNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), arguments == null ? null : arguments.getUid(), annotationType == null ? null : annotationType.getUid(), ret.getMetaprogramAnchor() == null ? null : ret.getMetaprogramAnchor().getUid(), startLocation, stopLocation));
        }
        return ret;
    }
    
    /**
     * Creates a NullLiteralNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public NullLiteralNode makeNullLiteralNode(
    )
    {
        NullLiteralNode ret = new NullLiteralNodeImpl(null, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateNullLiteralNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), startLocation, stopLocation));
        }
        return ret;
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
        NullLiteralNode ret = new NullLiteralNodeImpl(null, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateNullLiteralNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), startLocation, stopLocation));
        }
        return ret;
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
        PackageDeclarationNode ret = new PackageDeclarationNodeImpl(name, metaAnnotations, annotations, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreatePackageDeclarationNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), name == null ? null : (name.getNodeValue() == null ? null : name.getNodeValue().getUid()), metaAnnotations == null ? null : (metaAnnotations.getNodeValue() == null ? null : metaAnnotations.getNodeValue().getUid()), annotations == null ? null : (annotations.getNodeValue() == null ? null : annotations.getNodeValue().getUid()), startLocation, stopLocation));
        }
        return ret;
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
        PackageDeclarationNode ret = new PackageDeclarationNodeImpl(this.<NameNode>makeNormalNodeUnion(name), this.<MetaAnnotationListNode>makeNormalNodeUnion(metaAnnotations), this.<AnnotationListNode>makeNormalNodeUnion(annotations), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreatePackageDeclarationNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), name == null ? null : name.getUid(), metaAnnotations == null ? null : metaAnnotations.getUid(), annotations == null ? null : annotations.getUid(), startLocation, stopLocation));
        }
        return ret;
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
        PackageDeclarationNode ret = new PackageDeclarationNodeImpl(name, metaAnnotations, annotations, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreatePackageDeclarationNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), name == null ? null : (name.getNodeValue() == null ? null : name.getNodeValue().getUid()), metaAnnotations == null ? null : (metaAnnotations.getNodeValue() == null ? null : metaAnnotations.getNodeValue().getUid()), annotations == null ? null : (annotations.getNodeValue() == null ? null : annotations.getNodeValue().getUid()), startLocation, stopLocation));
        }
        return ret;
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
        PackageDeclarationNode ret = new PackageDeclarationNodeImpl(this.<NameNode>makeNormalNodeUnion(name), this.<MetaAnnotationListNode>makeNormalNodeUnion(metaAnnotations), this.<AnnotationListNode>makeNormalNodeUnion(annotations), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreatePackageDeclarationNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), name == null ? null : name.getUid(), metaAnnotations == null ? null : metaAnnotations.getUid(), annotations == null ? null : annotations.getUid(), startLocation, stopLocation));
        }
        return ret;
    }
    
    /**
     * Creates a PackageDeclarationNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public PackageDeclarationNode makePackageDeclarationNode(
            NameNode name)
    {
        PackageDeclarationNode ret = new PackageDeclarationNodeImpl(this.<NameNode>makeNormalNodeUnion(name), this.<MetaAnnotationListNode>makeNormalNodeUnion(makeMetaAnnotationListNode()), this.<AnnotationListNode>makeNormalNodeUnion(makeAnnotationListNode()), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreatePackageDeclarationNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), name == null ? null : name.getUid(), ret.getMetaAnnotations() == null ? null : ret.getMetaAnnotations().getUid(), ret.getAnnotations() == null ? null : ret.getAnnotations().getUid(), startLocation, stopLocation));
        }
        return ret;
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
        PackageDeclarationNode ret = new PackageDeclarationNodeImpl(this.<NameNode>makeNormalNodeUnion(name), this.<MetaAnnotationListNode>makeNormalNodeUnion(makeMetaAnnotationListNode()), this.<AnnotationListNode>makeNormalNodeUnion(makeAnnotationListNode()), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreatePackageDeclarationNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), name == null ? null : name.getUid(), ret.getMetaAnnotations() == null ? null : ret.getMetaAnnotations().getUid(), ret.getAnnotations() == null ? null : ret.getAnnotations().getUid(), startLocation, stopLocation));
        }
        return ret;
    }
    
    /**
     * Creates a PackageNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public PackageNode makePackageNodeWithUnions(
            NodeUnion<? extends IdentifierNode> name)
    {
        PackageNode ret = new PackageNodeImpl(name, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreatePackageNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), name == null ? null : (name.getNodeValue() == null ? null : name.getNodeValue().getUid()), startLocation, stopLocation));
        }
        return ret;
    }
    
    /**
     * Creates a PackageNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public PackageNode makePackageNode(
            IdentifierNode name)
    {
        PackageNode ret = new PackageNodeImpl(this.<IdentifierNode>makeNormalNodeUnion(name), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreatePackageNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), name == null ? null : name.getUid(), startLocation, stopLocation));
        }
        return ret;
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
        PackageNode ret = new PackageNodeImpl(name, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreatePackageNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), name == null ? null : (name.getNodeValue() == null ? null : name.getNodeValue().getUid()), startLocation, stopLocation));
        }
        return ret;
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
        PackageNode ret = new PackageNodeImpl(this.<IdentifierNode>makeNormalNodeUnion(name), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreatePackageNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), name == null ? null : name.getUid(), startLocation, stopLocation));
        }
        return ret;
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
        ParameterizedTypeNode ret = new ParameterizedTypeNodeImpl(baseType, typeArguments, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateParameterizedTypeNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), baseType == null ? null : (baseType.getNodeValue() == null ? null : baseType.getNodeValue().getUid()), typeArguments == null ? null : (typeArguments.getNodeValue() == null ? null : typeArguments.getNodeValue().getUid()), startLocation, stopLocation));
        }
        return ret;
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
        ParameterizedTypeNode ret = new ParameterizedTypeNodeImpl(this.<UnparameterizedTypeNode>makeNormalNodeUnion(baseType), this.<TypeArgumentListNode>makeNormalNodeUnion(typeArguments), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateParameterizedTypeNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), baseType == null ? null : baseType.getUid(), typeArguments == null ? null : typeArguments.getUid(), startLocation, stopLocation));
        }
        return ret;
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
        ParameterizedTypeNode ret = new ParameterizedTypeNodeImpl(baseType, typeArguments, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateParameterizedTypeNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), baseType == null ? null : (baseType.getNodeValue() == null ? null : baseType.getNodeValue().getUid()), typeArguments == null ? null : (typeArguments.getNodeValue() == null ? null : typeArguments.getNodeValue().getUid()), startLocation, stopLocation));
        }
        return ret;
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
        ParameterizedTypeNode ret = new ParameterizedTypeNodeImpl(this.<UnparameterizedTypeNode>makeNormalNodeUnion(baseType), this.<TypeArgumentListNode>makeNormalNodeUnion(typeArguments), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateParameterizedTypeNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), baseType == null ? null : baseType.getUid(), typeArguments == null ? null : typeArguments.getUid(), startLocation, stopLocation));
        }
        return ret;
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
        ParameterizedTypeSelectNode ret = new ParameterizedTypeSelectNodeImpl(base, select, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateParameterizedTypeSelectNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), base == null ? null : (base.getNodeValue() == null ? null : base.getNodeValue().getUid()), select == null ? null : (select.getNodeValue() == null ? null : select.getNodeValue().getUid()), startLocation, stopLocation));
        }
        return ret;
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
        ParameterizedTypeSelectNode ret = new ParameterizedTypeSelectNodeImpl(this.<ParameterizedTypeNode>makeNormalNodeUnion(base), this.<DeclaredTypeNode>makeNormalNodeUnion(select), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateParameterizedTypeSelectNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), base == null ? null : base.getUid(), select == null ? null : select.getUid(), startLocation, stopLocation));
        }
        return ret;
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
        ParameterizedTypeSelectNode ret = new ParameterizedTypeSelectNodeImpl(base, select, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateParameterizedTypeSelectNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), base == null ? null : (base.getNodeValue() == null ? null : base.getNodeValue().getUid()), select == null ? null : (select.getNodeValue() == null ? null : select.getNodeValue().getUid()), startLocation, stopLocation));
        }
        return ret;
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
        ParameterizedTypeSelectNode ret = new ParameterizedTypeSelectNodeImpl(this.<ParameterizedTypeNode>makeNormalNodeUnion(base), this.<DeclaredTypeNode>makeNormalNodeUnion(select), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateParameterizedTypeSelectNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), base == null ? null : base.getUid(), select == null ? null : select.getUid(), startLocation, stopLocation));
        }
        return ret;
    }
    
    /**
     * Creates a ParenthesizedExpressionNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public ParenthesizedExpressionNode makeParenthesizedExpressionNodeWithUnions(
            NodeUnion<? extends ExpressionNode> expression)
    {
        ParenthesizedExpressionNode ret = new ParenthesizedExpressionNodeImpl(expression, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateParenthesizedExpressionNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), expression == null ? null : (expression.getNodeValue() == null ? null : expression.getNodeValue().getUid()), startLocation, stopLocation));
        }
        return ret;
    }
    
    /**
     * Creates a ParenthesizedExpressionNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public ParenthesizedExpressionNode makeParenthesizedExpressionNode(
            ExpressionNode expression)
    {
        ParenthesizedExpressionNode ret = new ParenthesizedExpressionNodeImpl(this.<ExpressionNode>makeNormalNodeUnion(expression), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateParenthesizedExpressionNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), expression == null ? null : expression.getUid(), startLocation, stopLocation));
        }
        return ret;
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
        ParenthesizedExpressionNode ret = new ParenthesizedExpressionNodeImpl(expression, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateParenthesizedExpressionNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), expression == null ? null : (expression.getNodeValue() == null ? null : expression.getNodeValue().getUid()), startLocation, stopLocation));
        }
        return ret;
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
        ParenthesizedExpressionNode ret = new ParenthesizedExpressionNodeImpl(this.<ExpressionNode>makeNormalNodeUnion(expression), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateParenthesizedExpressionNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), expression == null ? null : expression.getUid(), startLocation, stopLocation));
        }
        return ret;
    }
    
    /**
     * Creates a PrimitiveTypeNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public PrimitiveTypeNode makePrimitiveTypeNode(
            PrimitiveType primitiveType)
    {
        PrimitiveTypeNode ret = new PrimitiveTypeNodeImpl(primitiveType, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreatePrimitiveTypeNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), primitiveType, startLocation, stopLocation));
        }
        return ret;
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
        PrimitiveTypeNode ret = new PrimitiveTypeNodeImpl(primitiveType, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreatePrimitiveTypeNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), primitiveType, startLocation, stopLocation));
        }
        return ret;
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
        QualifiedClassInstantiationNode ret = new QualifiedClassInstantiationNodeImpl(enclosingExpression, identifier, typeArguments, constructorTypeArguments, arguments, body, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateQualifiedClassInstantiationNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), enclosingExpression == null ? null : (enclosingExpression.getNodeValue() == null ? null : enclosingExpression.getNodeValue().getUid()), identifier == null ? null : (identifier.getNodeValue() == null ? null : identifier.getNodeValue().getUid()), typeArguments == null ? null : (typeArguments.getNodeValue() == null ? null : typeArguments.getNodeValue().getUid()), constructorTypeArguments == null ? null : (constructorTypeArguments.getNodeValue() == null ? null : constructorTypeArguments.getNodeValue().getUid()), arguments == null ? null : (arguments.getNodeValue() == null ? null : arguments.getNodeValue().getUid()), body == null ? null : (body.getNodeValue() == null ? null : body.getNodeValue().getUid()), startLocation, stopLocation));
        }
        return ret;
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
        QualifiedClassInstantiationNode ret = new QualifiedClassInstantiationNodeImpl(this.<ExpressionNode>makeNormalNodeUnion(enclosingExpression), this.<IdentifierNode>makeNormalNodeUnion(identifier), this.<TypeArgumentListNode>makeNormalNodeUnion(typeArguments), this.<TypeArgumentListNode>makeNormalNodeUnion(constructorTypeArguments), this.<ExpressionListNode>makeNormalNodeUnion(arguments), this.<AnonymousClassBodyNode>makeNormalNodeUnion(body), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateQualifiedClassInstantiationNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), enclosingExpression == null ? null : enclosingExpression.getUid(), identifier == null ? null : identifier.getUid(), typeArguments == null ? null : typeArguments.getUid(), constructorTypeArguments == null ? null : constructorTypeArguments.getUid(), arguments == null ? null : arguments.getUid(), body == null ? null : body.getUid(), startLocation, stopLocation));
        }
        return ret;
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
        QualifiedClassInstantiationNode ret = new QualifiedClassInstantiationNodeImpl(enclosingExpression, identifier, typeArguments, constructorTypeArguments, arguments, body, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateQualifiedClassInstantiationNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), enclosingExpression == null ? null : (enclosingExpression.getNodeValue() == null ? null : enclosingExpression.getNodeValue().getUid()), identifier == null ? null : (identifier.getNodeValue() == null ? null : identifier.getNodeValue().getUid()), typeArguments == null ? null : (typeArguments.getNodeValue() == null ? null : typeArguments.getNodeValue().getUid()), constructorTypeArguments == null ? null : (constructorTypeArguments.getNodeValue() == null ? null : constructorTypeArguments.getNodeValue().getUid()), arguments == null ? null : (arguments.getNodeValue() == null ? null : arguments.getNodeValue().getUid()), body == null ? null : (body.getNodeValue() == null ? null : body.getNodeValue().getUid()), startLocation, stopLocation));
        }
        return ret;
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
        QualifiedClassInstantiationNode ret = new QualifiedClassInstantiationNodeImpl(this.<ExpressionNode>makeNormalNodeUnion(enclosingExpression), this.<IdentifierNode>makeNormalNodeUnion(identifier), this.<TypeArgumentListNode>makeNormalNodeUnion(typeArguments), this.<TypeArgumentListNode>makeNormalNodeUnion(constructorTypeArguments), this.<ExpressionListNode>makeNormalNodeUnion(arguments), this.<AnonymousClassBodyNode>makeNormalNodeUnion(body), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateQualifiedClassInstantiationNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), enclosingExpression == null ? null : enclosingExpression.getUid(), identifier == null ? null : identifier.getUid(), typeArguments == null ? null : typeArguments.getUid(), constructorTypeArguments == null ? null : constructorTypeArguments.getUid(), arguments == null ? null : arguments.getUid(), body == null ? null : body.getUid(), startLocation, stopLocation));
        }
        return ret;
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
        QualifiedClassInstantiationNode ret = new QualifiedClassInstantiationNodeImpl(this.<ExpressionNode>makeNormalNodeUnion(enclosingExpression), this.<IdentifierNode>makeNormalNodeUnion(identifier), this.<TypeArgumentListNode>makeNormalNodeUnion(typeArguments), this.<TypeArgumentListNode>makeNormalNodeUnion(makeTypeArgumentListNode()), this.<ExpressionListNode>makeNormalNodeUnion(makeExpressionListNode()), this.<AnonymousClassBodyNode>makeNormalNodeUnion(null), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateQualifiedClassInstantiationNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), enclosingExpression == null ? null : enclosingExpression.getUid(), identifier == null ? null : identifier.getUid(), typeArguments == null ? null : typeArguments.getUid(), ret.getConstructorTypeArguments() == null ? null : ret.getConstructorTypeArguments().getUid(), ret.getArguments() == null ? null : ret.getArguments().getUid(), ret.getBody() == null ? null : ret.getBody().getUid(), startLocation, stopLocation));
        }
        return ret;
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
        QualifiedClassInstantiationNode ret = new QualifiedClassInstantiationNodeImpl(this.<ExpressionNode>makeNormalNodeUnion(enclosingExpression), this.<IdentifierNode>makeNormalNodeUnion(identifier), this.<TypeArgumentListNode>makeNormalNodeUnion(typeArguments), this.<TypeArgumentListNode>makeNormalNodeUnion(makeTypeArgumentListNode()), this.<ExpressionListNode>makeNormalNodeUnion(makeExpressionListNode()), this.<AnonymousClassBodyNode>makeNormalNodeUnion(null), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateQualifiedClassInstantiationNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), enclosingExpression == null ? null : enclosingExpression.getUid(), identifier == null ? null : identifier.getUid(), typeArguments == null ? null : typeArguments.getUid(), ret.getConstructorTypeArguments() == null ? null : ret.getConstructorTypeArguments().getUid(), ret.getArguments() == null ? null : ret.getArguments().getUid(), ret.getBody() == null ? null : ret.getBody().getUid(), startLocation, stopLocation));
        }
        return ret;
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
        QualifiedNameNode ret = new QualifiedNameNodeImpl(base, identifier, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateQualifiedNameNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), base == null ? null : (base.getNodeValue() == null ? null : base.getNodeValue().getUid()), identifier == null ? null : (identifier.getNodeValue() == null ? null : identifier.getNodeValue().getUid()), startLocation, stopLocation));
        }
        return ret;
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
        QualifiedNameNode ret = new QualifiedNameNodeImpl(this.<NameNode>makeNormalNodeUnion(base), this.<IdentifierNode>makeNormalNodeUnion(identifier), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateQualifiedNameNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), base == null ? null : base.getUid(), identifier == null ? null : identifier.getUid(), startLocation, stopLocation));
        }
        return ret;
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
        QualifiedNameNode ret = new QualifiedNameNodeImpl(base, identifier, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateQualifiedNameNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), base == null ? null : (base.getNodeValue() == null ? null : base.getNodeValue().getUid()), identifier == null ? null : (identifier.getNodeValue() == null ? null : identifier.getNodeValue().getUid()), startLocation, stopLocation));
        }
        return ret;
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
        QualifiedNameNode ret = new QualifiedNameNodeImpl(this.<NameNode>makeNormalNodeUnion(base), this.<IdentifierNode>makeNormalNodeUnion(identifier), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateQualifiedNameNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), base == null ? null : base.getUid(), identifier == null ? null : identifier.getUid(), startLocation, stopLocation));
        }
        return ret;
    }
    
    /**
     * Creates a RawCodeLiteralNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public RawCodeLiteralNode makeRawCodeLiteralNode(
            BsjRawCodeLiteralPayload value)
    {
        RawCodeLiteralNode ret = new RawCodeLiteralNodeImpl(value, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateRawCodeLiteralNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), value, startLocation, stopLocation));
        }
        return ret;
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
        RawCodeLiteralNode ret = new RawCodeLiteralNodeImpl(value, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateRawCodeLiteralNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), value, startLocation, stopLocation));
        }
        return ret;
    }
    
    /**
     * Creates a ReferenceTypeListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public ReferenceTypeListNode makeReferenceTypeListNodeWithUnions(
            List<NodeUnion<? extends ReferenceTypeNode>> children)
    {
        ReferenceTypeListNode ret = new ReferenceTypeListNodeImpl(children, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateReferenceTypeListNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), EditScriptUtilities.getNodeUnionUids(children), startLocation, stopLocation));
        }
        return ret;
    }
    
    /**
     * Creates a ReferenceTypeListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public ReferenceTypeListNode makeReferenceTypeListNode(
            List<ReferenceTypeNode> children)
    {
        ReferenceTypeListNode ret = new ReferenceTypeListNodeImpl(unionWrapList(children), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateReferenceTypeListNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), EditScriptUtilities.getNodeUids(children), startLocation, stopLocation));
        }
        return ret;
    }
    
    /**
     * Creates a ReferenceTypeListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public ReferenceTypeListNode makeReferenceTypeListNode(
            ReferenceTypeNode... childrenElements)
    {
        List<ReferenceTypeNode> children = Arrays.asList(childrenElements);
        return makeReferenceTypeListNode(children, startLocation, stopLocation);
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
        ReferenceTypeListNode ret = new ReferenceTypeListNodeImpl(children, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateReferenceTypeListNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), EditScriptUtilities.getNodeUnionUids(children), startLocation, stopLocation));
        }
        return ret;
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
        ReferenceTypeListNode ret = new ReferenceTypeListNodeImpl(unionWrapList(children), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateReferenceTypeListNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), EditScriptUtilities.getNodeUids(children), startLocation, stopLocation));
        }
        return ret;
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
        List<ReferenceTypeNode> children = Arrays.asList(childrenElements);
        return makeReferenceTypeListNode(children, startLocation, stopLocation);
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
        ReturnNode ret = new ReturnNodeImpl(expression, metaAnnotations, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateReturnNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), expression == null ? null : (expression.getNodeValue() == null ? null : expression.getNodeValue().getUid()), metaAnnotations == null ? null : (metaAnnotations.getNodeValue() == null ? null : metaAnnotations.getNodeValue().getUid()), startLocation, stopLocation));
        }
        return ret;
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
        ReturnNode ret = new ReturnNodeImpl(this.<ExpressionNode>makeNormalNodeUnion(expression), this.<MetaAnnotationListNode>makeNormalNodeUnion(metaAnnotations), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateReturnNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), expression == null ? null : expression.getUid(), metaAnnotations == null ? null : metaAnnotations.getUid(), startLocation, stopLocation));
        }
        return ret;
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
        ReturnNode ret = new ReturnNodeImpl(expression, metaAnnotations, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateReturnNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), expression == null ? null : (expression.getNodeValue() == null ? null : expression.getNodeValue().getUid()), metaAnnotations == null ? null : (metaAnnotations.getNodeValue() == null ? null : metaAnnotations.getNodeValue().getUid()), startLocation, stopLocation));
        }
        return ret;
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
        ReturnNode ret = new ReturnNodeImpl(this.<ExpressionNode>makeNormalNodeUnion(expression), this.<MetaAnnotationListNode>makeNormalNodeUnion(metaAnnotations), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateReturnNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), expression == null ? null : expression.getUid(), metaAnnotations == null ? null : metaAnnotations.getUid(), startLocation, stopLocation));
        }
        return ret;
    }
    
    /**
     * Creates a ReturnNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public ReturnNode makeReturnNode(
            ExpressionNode expression)
    {
        ReturnNode ret = new ReturnNodeImpl(this.<ExpressionNode>makeNormalNodeUnion(expression), this.<MetaAnnotationListNode>makeNormalNodeUnion(makeMetaAnnotationListNode()), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateReturnNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), expression == null ? null : expression.getUid(), ret.getMetaAnnotations() == null ? null : ret.getMetaAnnotations().getUid(), startLocation, stopLocation));
        }
        return ret;
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
        ReturnNode ret = new ReturnNodeImpl(this.<ExpressionNode>makeNormalNodeUnion(expression), this.<MetaAnnotationListNode>makeNormalNodeUnion(makeMetaAnnotationListNode()), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateReturnNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), expression == null ? null : expression.getUid(), ret.getMetaAnnotations() == null ? null : ret.getMetaAnnotations().getUid(), startLocation, stopLocation));
        }
        return ret;
    }
    
    /**
     * Creates a SimpleNameNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public SimpleNameNode makeSimpleNameNodeWithUnions(
            NodeUnion<? extends IdentifierNode> identifier)
    {
        SimpleNameNode ret = new SimpleNameNodeImpl(identifier, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateSimpleNameNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), identifier == null ? null : (identifier.getNodeValue() == null ? null : identifier.getNodeValue().getUid()), startLocation, stopLocation));
        }
        return ret;
    }
    
    /**
     * Creates a SimpleNameNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public SimpleNameNode makeSimpleNameNode(
            IdentifierNode identifier)
    {
        SimpleNameNode ret = new SimpleNameNodeImpl(this.<IdentifierNode>makeNormalNodeUnion(identifier), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateSimpleNameNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), identifier == null ? null : identifier.getUid(), startLocation, stopLocation));
        }
        return ret;
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
        SimpleNameNode ret = new SimpleNameNodeImpl(identifier, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateSimpleNameNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), identifier == null ? null : (identifier.getNodeValue() == null ? null : identifier.getNodeValue().getUid()), startLocation, stopLocation));
        }
        return ret;
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
        SimpleNameNode ret = new SimpleNameNodeImpl(this.<IdentifierNode>makeNormalNodeUnion(identifier), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateSimpleNameNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), identifier == null ? null : identifier.getUid(), startLocation, stopLocation));
        }
        return ret;
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
        SingleElementAnnotationNode ret = new SingleElementAnnotationNodeImpl(value, annotationType, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateSingleElementAnnotationNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), value == null ? null : (value.getNodeValue() == null ? null : value.getNodeValue().getUid()), annotationType == null ? null : (annotationType.getNodeValue() == null ? null : annotationType.getNodeValue().getUid()), startLocation, stopLocation));
        }
        return ret;
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
        SingleElementAnnotationNode ret = new SingleElementAnnotationNodeImpl(this.<AnnotationValueNode>makeNormalNodeUnion(value), this.<UnparameterizedTypeNode>makeNormalNodeUnion(annotationType), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateSingleElementAnnotationNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), value == null ? null : value.getUid(), annotationType == null ? null : annotationType.getUid(), startLocation, stopLocation));
        }
        return ret;
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
        SingleElementAnnotationNode ret = new SingleElementAnnotationNodeImpl(value, annotationType, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateSingleElementAnnotationNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), value == null ? null : (value.getNodeValue() == null ? null : value.getNodeValue().getUid()), annotationType == null ? null : (annotationType.getNodeValue() == null ? null : annotationType.getNodeValue().getUid()), startLocation, stopLocation));
        }
        return ret;
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
        SingleElementAnnotationNode ret = new SingleElementAnnotationNodeImpl(this.<AnnotationValueNode>makeNormalNodeUnion(value), this.<UnparameterizedTypeNode>makeNormalNodeUnion(annotationType), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateSingleElementAnnotationNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), value == null ? null : value.getUid(), annotationType == null ? null : annotationType.getUid(), startLocation, stopLocation));
        }
        return ret;
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
        SingleElementMetaAnnotationNode ret = new SingleElementMetaAnnotationNodeImpl(value, annotationType, metaprogramAnchor, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateSingleElementMetaAnnotationNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), value == null ? null : (value.getNodeValue() == null ? null : value.getNodeValue().getUid()), annotationType == null ? null : (annotationType.getNodeValue() == null ? null : annotationType.getNodeValue().getUid()), metaprogramAnchor == null ? null : metaprogramAnchor.getUid(), startLocation, stopLocation));
        }
        return ret;
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
        SingleElementMetaAnnotationNode ret = new SingleElementMetaAnnotationNodeImpl(this.<MetaAnnotationValueNode>makeNormalNodeUnion(value), this.<UnparameterizedTypeNode>makeNormalNodeUnion(annotationType), metaprogramAnchor, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateSingleElementMetaAnnotationNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), value == null ? null : value.getUid(), annotationType == null ? null : annotationType.getUid(), metaprogramAnchor == null ? null : metaprogramAnchor.getUid(), startLocation, stopLocation));
        }
        return ret;
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
        SingleElementMetaAnnotationNode ret = new SingleElementMetaAnnotationNodeImpl(value, annotationType, metaprogramAnchor, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateSingleElementMetaAnnotationNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), value == null ? null : (value.getNodeValue() == null ? null : value.getNodeValue().getUid()), annotationType == null ? null : (annotationType.getNodeValue() == null ? null : annotationType.getNodeValue().getUid()), metaprogramAnchor == null ? null : metaprogramAnchor.getUid(), startLocation, stopLocation));
        }
        return ret;
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
        SingleElementMetaAnnotationNode ret = new SingleElementMetaAnnotationNodeImpl(this.<MetaAnnotationValueNode>makeNormalNodeUnion(value), this.<UnparameterizedTypeNode>makeNormalNodeUnion(annotationType), metaprogramAnchor, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateSingleElementMetaAnnotationNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), value == null ? null : value.getUid(), annotationType == null ? null : annotationType.getUid(), metaprogramAnchor == null ? null : metaprogramAnchor.getUid(), startLocation, stopLocation));
        }
        return ret;
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
        SingleElementMetaAnnotationNode ret = new SingleElementMetaAnnotationNodeImpl(this.<MetaAnnotationValueNode>makeNormalNodeUnion(value), this.<UnparameterizedTypeNode>makeNormalNodeUnion(annotationType), makeMetaAnnotationMetaprogramAnchorNode(), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateSingleElementMetaAnnotationNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), value == null ? null : value.getUid(), annotationType == null ? null : annotationType.getUid(), ret.getMetaprogramAnchor() == null ? null : ret.getMetaprogramAnchor().getUid(), startLocation, stopLocation));
        }
        return ret;
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
        SingleElementMetaAnnotationNode ret = new SingleElementMetaAnnotationNodeImpl(this.<MetaAnnotationValueNode>makeNormalNodeUnion(value), this.<UnparameterizedTypeNode>makeNormalNodeUnion(annotationType), makeMetaAnnotationMetaprogramAnchorNode(), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateSingleElementMetaAnnotationNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), value == null ? null : value.getUid(), annotationType == null ? null : annotationType.getUid(), ret.getMetaprogramAnchor() == null ? null : ret.getMetaprogramAnchor().getUid(), startLocation, stopLocation));
        }
        return ret;
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
        SingleStaticImportNode ret = new SingleStaticImportNodeImpl(name, identifier, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateSingleStaticImportNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), name == null ? null : (name.getNodeValue() == null ? null : name.getNodeValue().getUid()), identifier == null ? null : (identifier.getNodeValue() == null ? null : identifier.getNodeValue().getUid()), startLocation, stopLocation));
        }
        return ret;
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
        SingleStaticImportNode ret = new SingleStaticImportNodeImpl(this.<NameNode>makeNormalNodeUnion(name), this.<IdentifierNode>makeNormalNodeUnion(identifier), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateSingleStaticImportNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), name == null ? null : name.getUid(), identifier == null ? null : identifier.getUid(), startLocation, stopLocation));
        }
        return ret;
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
        SingleStaticImportNode ret = new SingleStaticImportNodeImpl(name, identifier, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateSingleStaticImportNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), name == null ? null : (name.getNodeValue() == null ? null : name.getNodeValue().getUid()), identifier == null ? null : (identifier.getNodeValue() == null ? null : identifier.getNodeValue().getUid()), startLocation, stopLocation));
        }
        return ret;
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
        SingleStaticImportNode ret = new SingleStaticImportNodeImpl(this.<NameNode>makeNormalNodeUnion(name), this.<IdentifierNode>makeNormalNodeUnion(identifier), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateSingleStaticImportNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), name == null ? null : name.getUid(), identifier == null ? null : identifier.getUid(), startLocation, stopLocation));
        }
        return ret;
    }
    
    /**
     * Creates a SpliceNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public SpliceNode makeSpliceNode(
            ExpressionNode spliceExpression)
    {
        SpliceNode ret = new SpliceNodeImpl(spliceExpression, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateSpliceNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), spliceExpression == null ? null : spliceExpression.getUid(), startLocation, stopLocation));
        }
        return ret;
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
        SpliceNode ret = new SpliceNodeImpl(spliceExpression, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateSpliceNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), spliceExpression == null ? null : spliceExpression.getUid(), startLocation, stopLocation));
        }
        return ret;
    }
    
    /**
     * Creates a StatementExpressionListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public StatementExpressionListNode makeStatementExpressionListNodeWithUnions(
            List<NodeUnion<? extends StatementExpressionNode>> children)
    {
        StatementExpressionListNode ret = new StatementExpressionListNodeImpl(children, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateStatementExpressionListNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), EditScriptUtilities.getNodeUnionUids(children), startLocation, stopLocation));
        }
        return ret;
    }
    
    /**
     * Creates a StatementExpressionListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public StatementExpressionListNode makeStatementExpressionListNode(
            List<StatementExpressionNode> children)
    {
        StatementExpressionListNode ret = new StatementExpressionListNodeImpl(unionWrapList(children), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateStatementExpressionListNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), EditScriptUtilities.getNodeUids(children), startLocation, stopLocation));
        }
        return ret;
    }
    
    /**
     * Creates a StatementExpressionListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public StatementExpressionListNode makeStatementExpressionListNode(
            StatementExpressionNode... childrenElements)
    {
        List<StatementExpressionNode> children = Arrays.asList(childrenElements);
        return makeStatementExpressionListNode(children, startLocation, stopLocation);
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
        StatementExpressionListNode ret = new StatementExpressionListNodeImpl(children, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateStatementExpressionListNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), EditScriptUtilities.getNodeUnionUids(children), startLocation, stopLocation));
        }
        return ret;
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
        StatementExpressionListNode ret = new StatementExpressionListNodeImpl(unionWrapList(children), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateStatementExpressionListNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), EditScriptUtilities.getNodeUids(children), startLocation, stopLocation));
        }
        return ret;
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
        List<StatementExpressionNode> children = Arrays.asList(childrenElements);
        return makeStatementExpressionListNode(children, startLocation, stopLocation);
    }
    
    /**
     * Creates a StaticImportOnDemandNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public StaticImportOnDemandNode makeStaticImportOnDemandNodeWithUnions(
            NodeUnion<? extends NameNode> name)
    {
        StaticImportOnDemandNode ret = new StaticImportOnDemandNodeImpl(name, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateStaticImportOnDemandNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), name == null ? null : (name.getNodeValue() == null ? null : name.getNodeValue().getUid()), startLocation, stopLocation));
        }
        return ret;
    }
    
    /**
     * Creates a StaticImportOnDemandNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public StaticImportOnDemandNode makeStaticImportOnDemandNode(
            NameNode name)
    {
        StaticImportOnDemandNode ret = new StaticImportOnDemandNodeImpl(this.<NameNode>makeNormalNodeUnion(name), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateStaticImportOnDemandNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), name == null ? null : name.getUid(), startLocation, stopLocation));
        }
        return ret;
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
        StaticImportOnDemandNode ret = new StaticImportOnDemandNodeImpl(name, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateStaticImportOnDemandNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), name == null ? null : (name.getNodeValue() == null ? null : name.getNodeValue().getUid()), startLocation, stopLocation));
        }
        return ret;
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
        StaticImportOnDemandNode ret = new StaticImportOnDemandNodeImpl(this.<NameNode>makeNormalNodeUnion(name), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateStaticImportOnDemandNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), name == null ? null : name.getUid(), startLocation, stopLocation));
        }
        return ret;
    }
    
    /**
     * Creates a StringLiteralNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public StringLiteralNode makeStringLiteralNode(
            String value)
    {
        StringLiteralNode ret = new StringLiteralNodeImpl(value, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateStringLiteralNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), value, startLocation, stopLocation));
        }
        return ret;
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
        StringLiteralNode ret = new StringLiteralNodeImpl(value, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateStringLiteralNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), value, startLocation, stopLocation));
        }
        return ret;
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
        SuperFieldAccessNode ret = new SuperFieldAccessNodeImpl(type, identifier, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateSuperFieldAccessNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), type == null ? null : (type.getNodeValue() == null ? null : type.getNodeValue().getUid()), identifier == null ? null : (identifier.getNodeValue() == null ? null : identifier.getNodeValue().getUid()), startLocation, stopLocation));
        }
        return ret;
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
        SuperFieldAccessNode ret = new SuperFieldAccessNodeImpl(this.<UnparameterizedTypeNode>makeNormalNodeUnion(type), this.<IdentifierNode>makeNormalNodeUnion(identifier), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateSuperFieldAccessNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), type == null ? null : type.getUid(), identifier == null ? null : identifier.getUid(), startLocation, stopLocation));
        }
        return ret;
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
        SuperFieldAccessNode ret = new SuperFieldAccessNodeImpl(type, identifier, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateSuperFieldAccessNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), type == null ? null : (type.getNodeValue() == null ? null : type.getNodeValue().getUid()), identifier == null ? null : (identifier.getNodeValue() == null ? null : identifier.getNodeValue().getUid()), startLocation, stopLocation));
        }
        return ret;
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
        SuperFieldAccessNode ret = new SuperFieldAccessNodeImpl(this.<UnparameterizedTypeNode>makeNormalNodeUnion(type), this.<IdentifierNode>makeNormalNodeUnion(identifier), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateSuperFieldAccessNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), type == null ? null : type.getUid(), identifier == null ? null : identifier.getUid(), startLocation, stopLocation));
        }
        return ret;
    }
    
    /**
     * Creates a SuperFieldAccessNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public SuperFieldAccessNode makeSuperFieldAccessNode(
            IdentifierNode identifier)
    {
        SuperFieldAccessNode ret = new SuperFieldAccessNodeImpl(this.<UnparameterizedTypeNode>makeNormalNodeUnion(null), this.<IdentifierNode>makeNormalNodeUnion(identifier), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateSuperFieldAccessNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), ret.getType() == null ? null : ret.getType().getUid(), identifier == null ? null : identifier.getUid(), startLocation, stopLocation));
        }
        return ret;
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
        SuperFieldAccessNode ret = new SuperFieldAccessNodeImpl(this.<UnparameterizedTypeNode>makeNormalNodeUnion(null), this.<IdentifierNode>makeNormalNodeUnion(identifier), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateSuperFieldAccessNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), ret.getType() == null ? null : ret.getType().getUid(), identifier == null ? null : identifier.getUid(), startLocation, stopLocation));
        }
        return ret;
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
        SuperMethodInvocationNode ret = new SuperMethodInvocationNodeImpl(type, identifier, arguments, typeArguments, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateSuperMethodInvocationNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), type == null ? null : (type.getNodeValue() == null ? null : type.getNodeValue().getUid()), identifier == null ? null : (identifier.getNodeValue() == null ? null : identifier.getNodeValue().getUid()), arguments == null ? null : (arguments.getNodeValue() == null ? null : arguments.getNodeValue().getUid()), typeArguments == null ? null : (typeArguments.getNodeValue() == null ? null : typeArguments.getNodeValue().getUid()), startLocation, stopLocation));
        }
        return ret;
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
        SuperMethodInvocationNode ret = new SuperMethodInvocationNodeImpl(this.<UnparameterizedTypeNode>makeNormalNodeUnion(type), this.<IdentifierNode>makeNormalNodeUnion(identifier), this.<ExpressionListNode>makeNormalNodeUnion(arguments), this.<ReferenceTypeListNode>makeNormalNodeUnion(typeArguments), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateSuperMethodInvocationNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), type == null ? null : type.getUid(), identifier == null ? null : identifier.getUid(), arguments == null ? null : arguments.getUid(), typeArguments == null ? null : typeArguments.getUid(), startLocation, stopLocation));
        }
        return ret;
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
        SuperMethodInvocationNode ret = new SuperMethodInvocationNodeImpl(type, identifier, arguments, typeArguments, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateSuperMethodInvocationNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), type == null ? null : (type.getNodeValue() == null ? null : type.getNodeValue().getUid()), identifier == null ? null : (identifier.getNodeValue() == null ? null : identifier.getNodeValue().getUid()), arguments == null ? null : (arguments.getNodeValue() == null ? null : arguments.getNodeValue().getUid()), typeArguments == null ? null : (typeArguments.getNodeValue() == null ? null : typeArguments.getNodeValue().getUid()), startLocation, stopLocation));
        }
        return ret;
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
        SuperMethodInvocationNode ret = new SuperMethodInvocationNodeImpl(this.<UnparameterizedTypeNode>makeNormalNodeUnion(type), this.<IdentifierNode>makeNormalNodeUnion(identifier), this.<ExpressionListNode>makeNormalNodeUnion(arguments), this.<ReferenceTypeListNode>makeNormalNodeUnion(typeArguments), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateSuperMethodInvocationNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), type == null ? null : type.getUid(), identifier == null ? null : identifier.getUid(), arguments == null ? null : arguments.getUid(), typeArguments == null ? null : typeArguments.getUid(), startLocation, stopLocation));
        }
        return ret;
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
        SuperMethodInvocationNode ret = new SuperMethodInvocationNodeImpl(this.<UnparameterizedTypeNode>makeNormalNodeUnion(null), this.<IdentifierNode>makeNormalNodeUnion(identifier), this.<ExpressionListNode>makeNormalNodeUnion(arguments), this.<ReferenceTypeListNode>makeNormalNodeUnion(makeReferenceTypeListNode()), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateSuperMethodInvocationNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), ret.getType() == null ? null : ret.getType().getUid(), identifier == null ? null : identifier.getUid(), arguments == null ? null : arguments.getUid(), ret.getTypeArguments() == null ? null : ret.getTypeArguments().getUid(), startLocation, stopLocation));
        }
        return ret;
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
        SuperMethodInvocationNode ret = new SuperMethodInvocationNodeImpl(this.<UnparameterizedTypeNode>makeNormalNodeUnion(null), this.<IdentifierNode>makeNormalNodeUnion(identifier), this.<ExpressionListNode>makeNormalNodeUnion(arguments), this.<ReferenceTypeListNode>makeNormalNodeUnion(makeReferenceTypeListNode()), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateSuperMethodInvocationNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), ret.getType() == null ? null : ret.getType().getUid(), identifier == null ? null : identifier.getUid(), arguments == null ? null : arguments.getUid(), ret.getTypeArguments() == null ? null : ret.getTypeArguments().getUid(), startLocation, stopLocation));
        }
        return ret;
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
        SuperMethodInvocationNode ret = new SuperMethodInvocationNodeImpl(this.<UnparameterizedTypeNode>makeNormalNodeUnion(null), this.<IdentifierNode>makeNormalNodeUnion(identifier), this.<ExpressionListNode>makeNormalNodeUnion(arguments), this.<ReferenceTypeListNode>makeNormalNodeUnion(typeArguments), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateSuperMethodInvocationNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), ret.getType() == null ? null : ret.getType().getUid(), identifier == null ? null : identifier.getUid(), arguments == null ? null : arguments.getUid(), typeArguments == null ? null : typeArguments.getUid(), startLocation, stopLocation));
        }
        return ret;
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
        SuperMethodInvocationNode ret = new SuperMethodInvocationNodeImpl(this.<UnparameterizedTypeNode>makeNormalNodeUnion(null), this.<IdentifierNode>makeNormalNodeUnion(identifier), this.<ExpressionListNode>makeNormalNodeUnion(arguments), this.<ReferenceTypeListNode>makeNormalNodeUnion(typeArguments), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateSuperMethodInvocationNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), ret.getType() == null ? null : ret.getType().getUid(), identifier == null ? null : identifier.getUid(), arguments == null ? null : arguments.getUid(), typeArguments == null ? null : typeArguments.getUid(), startLocation, stopLocation));
        }
        return ret;
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
        SuperclassConstructorInvocationNode ret = new SuperclassConstructorInvocationNodeImpl(qualifyingExpression, arguments, typeArguments, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateSuperclassConstructorInvocationNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), qualifyingExpression == null ? null : (qualifyingExpression.getNodeValue() == null ? null : qualifyingExpression.getNodeValue().getUid()), arguments == null ? null : (arguments.getNodeValue() == null ? null : arguments.getNodeValue().getUid()), typeArguments == null ? null : (typeArguments.getNodeValue() == null ? null : typeArguments.getNodeValue().getUid()), startLocation, stopLocation));
        }
        return ret;
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
        SuperclassConstructorInvocationNode ret = new SuperclassConstructorInvocationNodeImpl(this.<PrimaryExpressionNode>makeNormalNodeUnion(qualifyingExpression), this.<ExpressionListNode>makeNormalNodeUnion(arguments), this.<ReferenceTypeListNode>makeNormalNodeUnion(typeArguments), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateSuperclassConstructorInvocationNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), qualifyingExpression == null ? null : qualifyingExpression.getUid(), arguments == null ? null : arguments.getUid(), typeArguments == null ? null : typeArguments.getUid(), startLocation, stopLocation));
        }
        return ret;
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
        SuperclassConstructorInvocationNode ret = new SuperclassConstructorInvocationNodeImpl(qualifyingExpression, arguments, typeArguments, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateSuperclassConstructorInvocationNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), qualifyingExpression == null ? null : (qualifyingExpression.getNodeValue() == null ? null : qualifyingExpression.getNodeValue().getUid()), arguments == null ? null : (arguments.getNodeValue() == null ? null : arguments.getNodeValue().getUid()), typeArguments == null ? null : (typeArguments.getNodeValue() == null ? null : typeArguments.getNodeValue().getUid()), startLocation, stopLocation));
        }
        return ret;
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
        SuperclassConstructorInvocationNode ret = new SuperclassConstructorInvocationNodeImpl(this.<PrimaryExpressionNode>makeNormalNodeUnion(qualifyingExpression), this.<ExpressionListNode>makeNormalNodeUnion(arguments), this.<ReferenceTypeListNode>makeNormalNodeUnion(typeArguments), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateSuperclassConstructorInvocationNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), qualifyingExpression == null ? null : qualifyingExpression.getUid(), arguments == null ? null : arguments.getUid(), typeArguments == null ? null : typeArguments.getUid(), startLocation, stopLocation));
        }
        return ret;
    }
    
    /**
     * Creates a SuperclassConstructorInvocationNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public SuperclassConstructorInvocationNode makeSuperclassConstructorInvocationNode(
            ExpressionListNode arguments)
    {
        SuperclassConstructorInvocationNode ret = new SuperclassConstructorInvocationNodeImpl(this.<PrimaryExpressionNode>makeNormalNodeUnion(null), this.<ExpressionListNode>makeNormalNodeUnion(arguments), this.<ReferenceTypeListNode>makeNormalNodeUnion(makeReferenceTypeListNode()), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateSuperclassConstructorInvocationNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), ret.getQualifyingExpression() == null ? null : ret.getQualifyingExpression().getUid(), arguments == null ? null : arguments.getUid(), ret.getTypeArguments() == null ? null : ret.getTypeArguments().getUid(), startLocation, stopLocation));
        }
        return ret;
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
        SuperclassConstructorInvocationNode ret = new SuperclassConstructorInvocationNodeImpl(this.<PrimaryExpressionNode>makeNormalNodeUnion(null), this.<ExpressionListNode>makeNormalNodeUnion(arguments), this.<ReferenceTypeListNode>makeNormalNodeUnion(makeReferenceTypeListNode()), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateSuperclassConstructorInvocationNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), ret.getQualifyingExpression() == null ? null : ret.getQualifyingExpression().getUid(), arguments == null ? null : arguments.getUid(), ret.getTypeArguments() == null ? null : ret.getTypeArguments().getUid(), startLocation, stopLocation));
        }
        return ret;
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
        SwitchNode ret = new SwitchNodeImpl(expression, cases, metaAnnotations, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateSwitchNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), expression == null ? null : (expression.getNodeValue() == null ? null : expression.getNodeValue().getUid()), cases == null ? null : (cases.getNodeValue() == null ? null : cases.getNodeValue().getUid()), metaAnnotations == null ? null : (metaAnnotations.getNodeValue() == null ? null : metaAnnotations.getNodeValue().getUid()), startLocation, stopLocation));
        }
        return ret;
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
        SwitchNode ret = new SwitchNodeImpl(this.<ExpressionNode>makeNormalNodeUnion(expression), this.<CaseListNode>makeNormalNodeUnion(cases), this.<MetaAnnotationListNode>makeNormalNodeUnion(metaAnnotations), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateSwitchNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), expression == null ? null : expression.getUid(), cases == null ? null : cases.getUid(), metaAnnotations == null ? null : metaAnnotations.getUid(), startLocation, stopLocation));
        }
        return ret;
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
        SwitchNode ret = new SwitchNodeImpl(expression, cases, metaAnnotations, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateSwitchNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), expression == null ? null : (expression.getNodeValue() == null ? null : expression.getNodeValue().getUid()), cases == null ? null : (cases.getNodeValue() == null ? null : cases.getNodeValue().getUid()), metaAnnotations == null ? null : (metaAnnotations.getNodeValue() == null ? null : metaAnnotations.getNodeValue().getUid()), startLocation, stopLocation));
        }
        return ret;
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
        SwitchNode ret = new SwitchNodeImpl(this.<ExpressionNode>makeNormalNodeUnion(expression), this.<CaseListNode>makeNormalNodeUnion(cases), this.<MetaAnnotationListNode>makeNormalNodeUnion(metaAnnotations), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateSwitchNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), expression == null ? null : expression.getUid(), cases == null ? null : cases.getUid(), metaAnnotations == null ? null : metaAnnotations.getUid(), startLocation, stopLocation));
        }
        return ret;
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
        SwitchNode ret = new SwitchNodeImpl(this.<ExpressionNode>makeNormalNodeUnion(expression), this.<CaseListNode>makeNormalNodeUnion(cases), this.<MetaAnnotationListNode>makeNormalNodeUnion(makeMetaAnnotationListNode()), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateSwitchNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), expression == null ? null : expression.getUid(), cases == null ? null : cases.getUid(), ret.getMetaAnnotations() == null ? null : ret.getMetaAnnotations().getUid(), startLocation, stopLocation));
        }
        return ret;
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
        SwitchNode ret = new SwitchNodeImpl(this.<ExpressionNode>makeNormalNodeUnion(expression), this.<CaseListNode>makeNormalNodeUnion(cases), this.<MetaAnnotationListNode>makeNormalNodeUnion(makeMetaAnnotationListNode()), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateSwitchNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), expression == null ? null : expression.getUid(), cases == null ? null : cases.getUid(), ret.getMetaAnnotations() == null ? null : ret.getMetaAnnotations().getUid(), startLocation, stopLocation));
        }
        return ret;
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
        SynchronizedNode ret = new SynchronizedNodeImpl(expression, body, metaAnnotations, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateSynchronizedNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), expression == null ? null : (expression.getNodeValue() == null ? null : expression.getNodeValue().getUid()), body == null ? null : (body.getNodeValue() == null ? null : body.getNodeValue().getUid()), metaAnnotations == null ? null : (metaAnnotations.getNodeValue() == null ? null : metaAnnotations.getNodeValue().getUid()), startLocation, stopLocation));
        }
        return ret;
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
        SynchronizedNode ret = new SynchronizedNodeImpl(this.<ExpressionNode>makeNormalNodeUnion(expression), this.<BlockStatementListNode>makeNormalNodeUnion(body), this.<MetaAnnotationListNode>makeNormalNodeUnion(metaAnnotations), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateSynchronizedNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), expression == null ? null : expression.getUid(), body == null ? null : body.getUid(), metaAnnotations == null ? null : metaAnnotations.getUid(), startLocation, stopLocation));
        }
        return ret;
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
        SynchronizedNode ret = new SynchronizedNodeImpl(expression, body, metaAnnotations, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateSynchronizedNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), expression == null ? null : (expression.getNodeValue() == null ? null : expression.getNodeValue().getUid()), body == null ? null : (body.getNodeValue() == null ? null : body.getNodeValue().getUid()), metaAnnotations == null ? null : (metaAnnotations.getNodeValue() == null ? null : metaAnnotations.getNodeValue().getUid()), startLocation, stopLocation));
        }
        return ret;
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
        SynchronizedNode ret = new SynchronizedNodeImpl(this.<ExpressionNode>makeNormalNodeUnion(expression), this.<BlockStatementListNode>makeNormalNodeUnion(body), this.<MetaAnnotationListNode>makeNormalNodeUnion(metaAnnotations), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateSynchronizedNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), expression == null ? null : expression.getUid(), body == null ? null : body.getUid(), metaAnnotations == null ? null : metaAnnotations.getUid(), startLocation, stopLocation));
        }
        return ret;
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
        SynchronizedNode ret = new SynchronizedNodeImpl(this.<ExpressionNode>makeNormalNodeUnion(expression), this.<BlockStatementListNode>makeNormalNodeUnion(body), this.<MetaAnnotationListNode>makeNormalNodeUnion(makeMetaAnnotationListNode()), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateSynchronizedNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), expression == null ? null : expression.getUid(), body == null ? null : body.getUid(), ret.getMetaAnnotations() == null ? null : ret.getMetaAnnotations().getUid(), startLocation, stopLocation));
        }
        return ret;
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
        SynchronizedNode ret = new SynchronizedNodeImpl(this.<ExpressionNode>makeNormalNodeUnion(expression), this.<BlockStatementListNode>makeNormalNodeUnion(body), this.<MetaAnnotationListNode>makeNormalNodeUnion(makeMetaAnnotationListNode()), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateSynchronizedNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), expression == null ? null : expression.getUid(), body == null ? null : body.getUid(), ret.getMetaAnnotations() == null ? null : ret.getMetaAnnotations().getUid(), startLocation, stopLocation));
        }
        return ret;
    }
    
    /**
     * Creates a ThisNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public ThisNode makeThisNodeWithUnions(
            NodeUnion<? extends UnparameterizedTypeNode> type)
    {
        ThisNode ret = new ThisNodeImpl(type, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateThisNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), type == null ? null : (type.getNodeValue() == null ? null : type.getNodeValue().getUid()), startLocation, stopLocation));
        }
        return ret;
    }
    
    /**
     * Creates a ThisNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public ThisNode makeThisNode(
            UnparameterizedTypeNode type)
    {
        ThisNode ret = new ThisNodeImpl(this.<UnparameterizedTypeNode>makeNormalNodeUnion(type), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateThisNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), type == null ? null : type.getUid(), startLocation, stopLocation));
        }
        return ret;
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
        ThisNode ret = new ThisNodeImpl(type, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateThisNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), type == null ? null : (type.getNodeValue() == null ? null : type.getNodeValue().getUid()), startLocation, stopLocation));
        }
        return ret;
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
        ThisNode ret = new ThisNodeImpl(this.<UnparameterizedTypeNode>makeNormalNodeUnion(type), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateThisNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), type == null ? null : type.getUid(), startLocation, stopLocation));
        }
        return ret;
    }
    
    /**
     * Creates a ThisNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public ThisNode makeThisNode()
    {
        ThisNode ret = new ThisNodeImpl(this.<UnparameterizedTypeNode>makeNormalNodeUnion(null), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateThisNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), ret.getType() == null ? null : ret.getType().getUid(), startLocation, stopLocation));
        }
        return ret;
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
        ThisNode ret = new ThisNodeImpl(this.<UnparameterizedTypeNode>makeNormalNodeUnion(null), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateThisNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), ret.getType() == null ? null : ret.getType().getUid(), startLocation, stopLocation));
        }
        return ret;
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
        ThrowNode ret = new ThrowNodeImpl(expression, metaAnnotations, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateThrowNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), expression == null ? null : (expression.getNodeValue() == null ? null : expression.getNodeValue().getUid()), metaAnnotations == null ? null : (metaAnnotations.getNodeValue() == null ? null : metaAnnotations.getNodeValue().getUid()), startLocation, stopLocation));
        }
        return ret;
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
        ThrowNode ret = new ThrowNodeImpl(this.<ExpressionNode>makeNormalNodeUnion(expression), this.<MetaAnnotationListNode>makeNormalNodeUnion(metaAnnotations), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateThrowNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), expression == null ? null : expression.getUid(), metaAnnotations == null ? null : metaAnnotations.getUid(), startLocation, stopLocation));
        }
        return ret;
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
        ThrowNode ret = new ThrowNodeImpl(expression, metaAnnotations, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateThrowNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), expression == null ? null : (expression.getNodeValue() == null ? null : expression.getNodeValue().getUid()), metaAnnotations == null ? null : (metaAnnotations.getNodeValue() == null ? null : metaAnnotations.getNodeValue().getUid()), startLocation, stopLocation));
        }
        return ret;
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
        ThrowNode ret = new ThrowNodeImpl(this.<ExpressionNode>makeNormalNodeUnion(expression), this.<MetaAnnotationListNode>makeNormalNodeUnion(metaAnnotations), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateThrowNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), expression == null ? null : expression.getUid(), metaAnnotations == null ? null : metaAnnotations.getUid(), startLocation, stopLocation));
        }
        return ret;
    }
    
    /**
     * Creates a ThrowNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public ThrowNode makeThrowNode(
            ExpressionNode expression)
    {
        ThrowNode ret = new ThrowNodeImpl(this.<ExpressionNode>makeNormalNodeUnion(expression), this.<MetaAnnotationListNode>makeNormalNodeUnion(makeMetaAnnotationListNode()), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateThrowNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), expression == null ? null : expression.getUid(), ret.getMetaAnnotations() == null ? null : ret.getMetaAnnotations().getUid(), startLocation, stopLocation));
        }
        return ret;
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
        ThrowNode ret = new ThrowNodeImpl(this.<ExpressionNode>makeNormalNodeUnion(expression), this.<MetaAnnotationListNode>makeNormalNodeUnion(makeMetaAnnotationListNode()), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateThrowNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), expression == null ? null : expression.getUid(), ret.getMetaAnnotations() == null ? null : ret.getMetaAnnotations().getUid(), startLocation, stopLocation));
        }
        return ret;
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
        TryNode ret = new TryNodeImpl(body, catches, finallyBlock, metaAnnotations, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateTryNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), body == null ? null : (body.getNodeValue() == null ? null : body.getNodeValue().getUid()), catches == null ? null : (catches.getNodeValue() == null ? null : catches.getNodeValue().getUid()), finallyBlock == null ? null : (finallyBlock.getNodeValue() == null ? null : finallyBlock.getNodeValue().getUid()), metaAnnotations == null ? null : (metaAnnotations.getNodeValue() == null ? null : metaAnnotations.getNodeValue().getUid()), startLocation, stopLocation));
        }
        return ret;
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
        TryNode ret = new TryNodeImpl(this.<BlockStatementListNode>makeNormalNodeUnion(body), this.<CatchListNode>makeNormalNodeUnion(catches), this.<BlockStatementListNode>makeNormalNodeUnion(finallyBlock), this.<MetaAnnotationListNode>makeNormalNodeUnion(metaAnnotations), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateTryNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), body == null ? null : body.getUid(), catches == null ? null : catches.getUid(), finallyBlock == null ? null : finallyBlock.getUid(), metaAnnotations == null ? null : metaAnnotations.getUid(), startLocation, stopLocation));
        }
        return ret;
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
        TryNode ret = new TryNodeImpl(body, catches, finallyBlock, metaAnnotations, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateTryNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), body == null ? null : (body.getNodeValue() == null ? null : body.getNodeValue().getUid()), catches == null ? null : (catches.getNodeValue() == null ? null : catches.getNodeValue().getUid()), finallyBlock == null ? null : (finallyBlock.getNodeValue() == null ? null : finallyBlock.getNodeValue().getUid()), metaAnnotations == null ? null : (metaAnnotations.getNodeValue() == null ? null : metaAnnotations.getNodeValue().getUid()), startLocation, stopLocation));
        }
        return ret;
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
        TryNode ret = new TryNodeImpl(this.<BlockStatementListNode>makeNormalNodeUnion(body), this.<CatchListNode>makeNormalNodeUnion(catches), this.<BlockStatementListNode>makeNormalNodeUnion(finallyBlock), this.<MetaAnnotationListNode>makeNormalNodeUnion(metaAnnotations), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateTryNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), body == null ? null : body.getUid(), catches == null ? null : catches.getUid(), finallyBlock == null ? null : finallyBlock.getUid(), metaAnnotations == null ? null : metaAnnotations.getUid(), startLocation, stopLocation));
        }
        return ret;
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
        TryNode ret = new TryNodeImpl(this.<BlockStatementListNode>makeNormalNodeUnion(body), this.<CatchListNode>makeNormalNodeUnion(makeCatchListNode()), this.<BlockStatementListNode>makeNormalNodeUnion(finallyBlock), this.<MetaAnnotationListNode>makeNormalNodeUnion(makeMetaAnnotationListNode()), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateTryNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), body == null ? null : body.getUid(), ret.getCatches() == null ? null : ret.getCatches().getUid(), finallyBlock == null ? null : finallyBlock.getUid(), ret.getMetaAnnotations() == null ? null : ret.getMetaAnnotations().getUid(), startLocation, stopLocation));
        }
        return ret;
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
        TryNode ret = new TryNodeImpl(this.<BlockStatementListNode>makeNormalNodeUnion(body), this.<CatchListNode>makeNormalNodeUnion(makeCatchListNode()), this.<BlockStatementListNode>makeNormalNodeUnion(finallyBlock), this.<MetaAnnotationListNode>makeNormalNodeUnion(makeMetaAnnotationListNode()), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateTryNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), body == null ? null : body.getUid(), ret.getCatches() == null ? null : ret.getCatches().getUid(), finallyBlock == null ? null : finallyBlock.getUid(), ret.getMetaAnnotations() == null ? null : ret.getMetaAnnotations().getUid(), startLocation, stopLocation));
        }
        return ret;
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
        TryNode ret = new TryNodeImpl(this.<BlockStatementListNode>makeNormalNodeUnion(body), this.<CatchListNode>makeNormalNodeUnion(catches), this.<BlockStatementListNode>makeNormalNodeUnion(makeBlockStatementListNode()), this.<MetaAnnotationListNode>makeNormalNodeUnion(makeMetaAnnotationListNode()), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateTryNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), body == null ? null : body.getUid(), catches == null ? null : catches.getUid(), ret.getFinallyBlock() == null ? null : ret.getFinallyBlock().getUid(), ret.getMetaAnnotations() == null ? null : ret.getMetaAnnotations().getUid(), startLocation, stopLocation));
        }
        return ret;
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
        TryNode ret = new TryNodeImpl(this.<BlockStatementListNode>makeNormalNodeUnion(body), this.<CatchListNode>makeNormalNodeUnion(catches), this.<BlockStatementListNode>makeNormalNodeUnion(makeBlockStatementListNode()), this.<MetaAnnotationListNode>makeNormalNodeUnion(makeMetaAnnotationListNode()), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateTryNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), body == null ? null : body.getUid(), catches == null ? null : catches.getUid(), ret.getFinallyBlock() == null ? null : ret.getFinallyBlock().getUid(), ret.getMetaAnnotations() == null ? null : ret.getMetaAnnotations().getUid(), startLocation, stopLocation));
        }
        return ret;
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
        TryNode ret = new TryNodeImpl(this.<BlockStatementListNode>makeNormalNodeUnion(body), this.<CatchListNode>makeNormalNodeUnion(catches), this.<BlockStatementListNode>makeNormalNodeUnion(finallyBlock), this.<MetaAnnotationListNode>makeNormalNodeUnion(makeMetaAnnotationListNode()), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateTryNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), body == null ? null : body.getUid(), catches == null ? null : catches.getUid(), finallyBlock == null ? null : finallyBlock.getUid(), ret.getMetaAnnotations() == null ? null : ret.getMetaAnnotations().getUid(), startLocation, stopLocation));
        }
        return ret;
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
        TryNode ret = new TryNodeImpl(this.<BlockStatementListNode>makeNormalNodeUnion(body), this.<CatchListNode>makeNormalNodeUnion(catches), this.<BlockStatementListNode>makeNormalNodeUnion(finallyBlock), this.<MetaAnnotationListNode>makeNormalNodeUnion(makeMetaAnnotationListNode()), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateTryNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), body == null ? null : body.getUid(), catches == null ? null : catches.getUid(), finallyBlock == null ? null : finallyBlock.getUid(), ret.getMetaAnnotations() == null ? null : ret.getMetaAnnotations().getUid(), startLocation, stopLocation));
        }
        return ret;
    }
    
    /**
     * Creates a TypeArgumentListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public TypeArgumentListNode makeTypeArgumentListNodeWithUnions(
            List<NodeUnion<? extends TypeArgumentNode>> children)
    {
        TypeArgumentListNode ret = new TypeArgumentListNodeImpl(children, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateTypeArgumentListNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), EditScriptUtilities.getNodeUnionUids(children), startLocation, stopLocation));
        }
        return ret;
    }
    
    /**
     * Creates a TypeArgumentListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public TypeArgumentListNode makeTypeArgumentListNode(
            List<TypeArgumentNode> children)
    {
        TypeArgumentListNode ret = new TypeArgumentListNodeImpl(unionWrapList(children), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateTypeArgumentListNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), EditScriptUtilities.getNodeUids(children), startLocation, stopLocation));
        }
        return ret;
    }
    
    /**
     * Creates a TypeArgumentListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public TypeArgumentListNode makeTypeArgumentListNode(
            TypeArgumentNode... childrenElements)
    {
        List<TypeArgumentNode> children = Arrays.asList(childrenElements);
        return makeTypeArgumentListNode(children, startLocation, stopLocation);
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
        TypeArgumentListNode ret = new TypeArgumentListNodeImpl(children, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateTypeArgumentListNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), EditScriptUtilities.getNodeUnionUids(children), startLocation, stopLocation));
        }
        return ret;
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
        TypeArgumentListNode ret = new TypeArgumentListNodeImpl(unionWrapList(children), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateTypeArgumentListNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), EditScriptUtilities.getNodeUids(children), startLocation, stopLocation));
        }
        return ret;
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
        List<TypeArgumentNode> children = Arrays.asList(childrenElements);
        return makeTypeArgumentListNode(children, startLocation, stopLocation);
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
        TypeCastNode ret = new TypeCastNodeImpl(expression, type, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateTypeCastNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), expression == null ? null : (expression.getNodeValue() == null ? null : expression.getNodeValue().getUid()), type == null ? null : (type.getNodeValue() == null ? null : type.getNodeValue().getUid()), startLocation, stopLocation));
        }
        return ret;
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
        TypeCastNode ret = new TypeCastNodeImpl(this.<ExpressionNode>makeNormalNodeUnion(expression), this.<TypeNode>makeNormalNodeUnion(type), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateTypeCastNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), expression == null ? null : expression.getUid(), type == null ? null : type.getUid(), startLocation, stopLocation));
        }
        return ret;
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
        TypeCastNode ret = new TypeCastNodeImpl(expression, type, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateTypeCastNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), expression == null ? null : (expression.getNodeValue() == null ? null : expression.getNodeValue().getUid()), type == null ? null : (type.getNodeValue() == null ? null : type.getNodeValue().getUid()), startLocation, stopLocation));
        }
        return ret;
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
        TypeCastNode ret = new TypeCastNodeImpl(this.<ExpressionNode>makeNormalNodeUnion(expression), this.<TypeNode>makeNormalNodeUnion(type), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateTypeCastNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), expression == null ? null : expression.getUid(), type == null ? null : type.getUid(), startLocation, stopLocation));
        }
        return ret;
    }
    
    /**
     * Creates a TypeDeclarationListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public TypeDeclarationListNode makeTypeDeclarationListNodeWithUnions(
            List<NodeUnion<? extends TypeDeclarationNode>> children)
    {
        TypeDeclarationListNode ret = new TypeDeclarationListNodeImpl(children, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateTypeDeclarationListNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), EditScriptUtilities.getNodeUnionUids(children), startLocation, stopLocation));
        }
        return ret;
    }
    
    /**
     * Creates a TypeDeclarationListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public TypeDeclarationListNode makeTypeDeclarationListNode(
            List<TypeDeclarationNode> children)
    {
        TypeDeclarationListNode ret = new TypeDeclarationListNodeImpl(unionWrapList(children), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateTypeDeclarationListNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), EditScriptUtilities.getNodeUids(children), startLocation, stopLocation));
        }
        return ret;
    }
    
    /**
     * Creates a TypeDeclarationListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public TypeDeclarationListNode makeTypeDeclarationListNode(
            TypeDeclarationNode... childrenElements)
    {
        List<TypeDeclarationNode> children = Arrays.asList(childrenElements);
        return makeTypeDeclarationListNode(children, startLocation, stopLocation);
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
        TypeDeclarationListNode ret = new TypeDeclarationListNodeImpl(children, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateTypeDeclarationListNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), EditScriptUtilities.getNodeUnionUids(children), startLocation, stopLocation));
        }
        return ret;
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
        TypeDeclarationListNode ret = new TypeDeclarationListNodeImpl(unionWrapList(children), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateTypeDeclarationListNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), EditScriptUtilities.getNodeUids(children), startLocation, stopLocation));
        }
        return ret;
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
        List<TypeDeclarationNode> children = Arrays.asList(childrenElements);
        return makeTypeDeclarationListNode(children, startLocation, stopLocation);
    }
    
    /**
     * Creates a TypeDeclarationMetaprogramAnchorNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public TypeDeclarationMetaprogramAnchorNode makeTypeDeclarationMetaprogramAnchorNodeWithUnions(
            NodeUnion<? extends MetaprogramNode> metaprogram)
    {
        TypeDeclarationMetaprogramAnchorNode ret = new TypeDeclarationMetaprogramAnchorNodeImpl(metaprogram, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateTypeDeclarationMetaprogramAnchorNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), metaprogram == null ? null : (metaprogram.getNodeValue() == null ? null : metaprogram.getNodeValue().getUid()), startLocation, stopLocation));
        }
        return ret;
    }
    
    /**
     * Creates a TypeDeclarationMetaprogramAnchorNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public TypeDeclarationMetaprogramAnchorNode makeTypeDeclarationMetaprogramAnchorNode(
            MetaprogramNode metaprogram)
    {
        TypeDeclarationMetaprogramAnchorNode ret = new TypeDeclarationMetaprogramAnchorNodeImpl(this.<MetaprogramNode>makeNormalNodeUnion(metaprogram), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateTypeDeclarationMetaprogramAnchorNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), metaprogram == null ? null : metaprogram.getUid(), startLocation, stopLocation));
        }
        return ret;
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
        TypeDeclarationMetaprogramAnchorNode ret = new TypeDeclarationMetaprogramAnchorNodeImpl(metaprogram, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateTypeDeclarationMetaprogramAnchorNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), metaprogram == null ? null : (metaprogram.getNodeValue() == null ? null : metaprogram.getNodeValue().getUid()), startLocation, stopLocation));
        }
        return ret;
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
        TypeDeclarationMetaprogramAnchorNode ret = new TypeDeclarationMetaprogramAnchorNodeImpl(this.<MetaprogramNode>makeNormalNodeUnion(metaprogram), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateTypeDeclarationMetaprogramAnchorNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), metaprogram == null ? null : metaprogram.getUid(), startLocation, stopLocation));
        }
        return ret;
    }
    
    /**
     * Creates a TypeParameterListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public TypeParameterListNode makeTypeParameterListNodeWithUnions(
            List<NodeUnion<? extends TypeParameterNode>> children)
    {
        TypeParameterListNode ret = new TypeParameterListNodeImpl(children, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateTypeParameterListNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), EditScriptUtilities.getNodeUnionUids(children), startLocation, stopLocation));
        }
        return ret;
    }
    
    /**
     * Creates a TypeParameterListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public TypeParameterListNode makeTypeParameterListNode(
            List<TypeParameterNode> children)
    {
        TypeParameterListNode ret = new TypeParameterListNodeImpl(unionWrapList(children), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateTypeParameterListNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), EditScriptUtilities.getNodeUids(children), startLocation, stopLocation));
        }
        return ret;
    }
    
    /**
     * Creates a TypeParameterListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public TypeParameterListNode makeTypeParameterListNode(
            TypeParameterNode... childrenElements)
    {
        List<TypeParameterNode> children = Arrays.asList(childrenElements);
        return makeTypeParameterListNode(children, startLocation, stopLocation);
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
        TypeParameterListNode ret = new TypeParameterListNodeImpl(children, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateTypeParameterListNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), EditScriptUtilities.getNodeUnionUids(children), startLocation, stopLocation));
        }
        return ret;
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
        TypeParameterListNode ret = new TypeParameterListNodeImpl(unionWrapList(children), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateTypeParameterListNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), EditScriptUtilities.getNodeUids(children), startLocation, stopLocation));
        }
        return ret;
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
        List<TypeParameterNode> children = Arrays.asList(childrenElements);
        return makeTypeParameterListNode(children, startLocation, stopLocation);
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
        TypeParameterNode ret = new TypeParameterNodeImpl(identifier, bounds, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateTypeParameterNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), identifier == null ? null : (identifier.getNodeValue() == null ? null : identifier.getNodeValue().getUid()), bounds == null ? null : (bounds.getNodeValue() == null ? null : bounds.getNodeValue().getUid()), startLocation, stopLocation));
        }
        return ret;
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
        TypeParameterNode ret = new TypeParameterNodeImpl(this.<IdentifierNode>makeNormalNodeUnion(identifier), this.<DeclaredTypeListNode>makeNormalNodeUnion(bounds), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateTypeParameterNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), identifier == null ? null : identifier.getUid(), bounds == null ? null : bounds.getUid(), startLocation, stopLocation));
        }
        return ret;
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
        TypeParameterNode ret = new TypeParameterNodeImpl(identifier, bounds, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateTypeParameterNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), identifier == null ? null : (identifier.getNodeValue() == null ? null : identifier.getNodeValue().getUid()), bounds == null ? null : (bounds.getNodeValue() == null ? null : bounds.getNodeValue().getUid()), startLocation, stopLocation));
        }
        return ret;
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
        TypeParameterNode ret = new TypeParameterNodeImpl(this.<IdentifierNode>makeNormalNodeUnion(identifier), this.<DeclaredTypeListNode>makeNormalNodeUnion(bounds), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateTypeParameterNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), identifier == null ? null : identifier.getUid(), bounds == null ? null : bounds.getUid(), startLocation, stopLocation));
        }
        return ret;
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
        UnaryExpressionNode ret = new UnaryExpressionNodeImpl(expression, operator, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateUnaryExpressionNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), expression == null ? null : (expression.getNodeValue() == null ? null : expression.getNodeValue().getUid()), operator, startLocation, stopLocation));
        }
        return ret;
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
        UnaryExpressionNode ret = new UnaryExpressionNodeImpl(this.<ExpressionNode>makeNormalNodeUnion(expression), operator, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateUnaryExpressionNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), expression == null ? null : expression.getUid(), operator, startLocation, stopLocation));
        }
        return ret;
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
        UnaryExpressionNode ret = new UnaryExpressionNodeImpl(expression, operator, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateUnaryExpressionNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), expression == null ? null : (expression.getNodeValue() == null ? null : expression.getNodeValue().getUid()), operator, startLocation, stopLocation));
        }
        return ret;
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
        UnaryExpressionNode ret = new UnaryExpressionNodeImpl(this.<ExpressionNode>makeNormalNodeUnion(expression), operator, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateUnaryExpressionNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), expression == null ? null : expression.getUid(), operator, startLocation, stopLocation));
        }
        return ret;
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
        UnaryStatementExpressionNode ret = new UnaryStatementExpressionNodeImpl(expression, operator, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateUnaryStatementExpressionNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), expression == null ? null : (expression.getNodeValue() == null ? null : expression.getNodeValue().getUid()), operator, startLocation, stopLocation));
        }
        return ret;
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
        UnaryStatementExpressionNode ret = new UnaryStatementExpressionNodeImpl(this.<ExpressionNode>makeNormalNodeUnion(expression), operator, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateUnaryStatementExpressionNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), expression == null ? null : expression.getUid(), operator, startLocation, stopLocation));
        }
        return ret;
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
        UnaryStatementExpressionNode ret = new UnaryStatementExpressionNodeImpl(expression, operator, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateUnaryStatementExpressionNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), expression == null ? null : (expression.getNodeValue() == null ? null : expression.getNodeValue().getUid()), operator, startLocation, stopLocation));
        }
        return ret;
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
        UnaryStatementExpressionNode ret = new UnaryStatementExpressionNodeImpl(this.<ExpressionNode>makeNormalNodeUnion(expression), operator, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateUnaryStatementExpressionNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), expression == null ? null : expression.getUid(), operator, startLocation, stopLocation));
        }
        return ret;
    }
    
    /**
     * Creates a UnparameterizedTypeListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public UnparameterizedTypeListNode makeUnparameterizedTypeListNodeWithUnions(
            List<NodeUnion<? extends UnparameterizedTypeNode>> children)
    {
        UnparameterizedTypeListNode ret = new UnparameterizedTypeListNodeImpl(children, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateUnparameterizedTypeListNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), EditScriptUtilities.getNodeUnionUids(children), startLocation, stopLocation));
        }
        return ret;
    }
    
    /**
     * Creates a UnparameterizedTypeListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public UnparameterizedTypeListNode makeUnparameterizedTypeListNode(
            List<UnparameterizedTypeNode> children)
    {
        UnparameterizedTypeListNode ret = new UnparameterizedTypeListNodeImpl(unionWrapList(children), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateUnparameterizedTypeListNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), EditScriptUtilities.getNodeUids(children), startLocation, stopLocation));
        }
        return ret;
    }
    
    /**
     * Creates a UnparameterizedTypeListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public UnparameterizedTypeListNode makeUnparameterizedTypeListNode(
            UnparameterizedTypeNode... childrenElements)
    {
        List<UnparameterizedTypeNode> children = Arrays.asList(childrenElements);
        return makeUnparameterizedTypeListNode(children, startLocation, stopLocation);
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
        UnparameterizedTypeListNode ret = new UnparameterizedTypeListNodeImpl(children, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateUnparameterizedTypeListNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), EditScriptUtilities.getNodeUnionUids(children), startLocation, stopLocation));
        }
        return ret;
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
        UnparameterizedTypeListNode ret = new UnparameterizedTypeListNodeImpl(unionWrapList(children), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateUnparameterizedTypeListNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), EditScriptUtilities.getNodeUids(children), startLocation, stopLocation));
        }
        return ret;
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
        List<UnparameterizedTypeNode> children = Arrays.asList(childrenElements);
        return makeUnparameterizedTypeListNode(children, startLocation, stopLocation);
    }
    
    /**
     * Creates a UnparameterizedTypeNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public UnparameterizedTypeNode makeUnparameterizedTypeNodeWithUnions(
            NodeUnion<? extends NameNode> name)
    {
        UnparameterizedTypeNode ret = new UnparameterizedTypeNodeImpl(name, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateUnparameterizedTypeNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), name == null ? null : (name.getNodeValue() == null ? null : name.getNodeValue().getUid()), startLocation, stopLocation));
        }
        return ret;
    }
    
    /**
     * Creates a UnparameterizedTypeNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public UnparameterizedTypeNode makeUnparameterizedTypeNode(
            NameNode name)
    {
        UnparameterizedTypeNode ret = new UnparameterizedTypeNodeImpl(this.<NameNode>makeNormalNodeUnion(name), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateUnparameterizedTypeNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), name == null ? null : name.getUid(), startLocation, stopLocation));
        }
        return ret;
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
        UnparameterizedTypeNode ret = new UnparameterizedTypeNodeImpl(name, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateUnparameterizedTypeNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), name == null ? null : (name.getNodeValue() == null ? null : name.getNodeValue().getUid()), startLocation, stopLocation));
        }
        return ret;
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
        UnparameterizedTypeNode ret = new UnparameterizedTypeNodeImpl(this.<NameNode>makeNormalNodeUnion(name), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateUnparameterizedTypeNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), name == null ? null : name.getUid(), startLocation, stopLocation));
        }
        return ret;
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
        UnqualifiedClassInstantiationNode ret = new UnqualifiedClassInstantiationNodeImpl(type, constructorTypeArguments, arguments, body, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateUnqualifiedClassInstantiationNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), type == null ? null : (type.getNodeValue() == null ? null : type.getNodeValue().getUid()), constructorTypeArguments == null ? null : (constructorTypeArguments.getNodeValue() == null ? null : constructorTypeArguments.getNodeValue().getUid()), arguments == null ? null : (arguments.getNodeValue() == null ? null : arguments.getNodeValue().getUid()), body == null ? null : (body.getNodeValue() == null ? null : body.getNodeValue().getUid()), startLocation, stopLocation));
        }
        return ret;
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
        UnqualifiedClassInstantiationNode ret = new UnqualifiedClassInstantiationNodeImpl(this.<DeclaredTypeNode>makeNormalNodeUnion(type), this.<TypeArgumentListNode>makeNormalNodeUnion(constructorTypeArguments), this.<ExpressionListNode>makeNormalNodeUnion(arguments), this.<AnonymousClassBodyNode>makeNormalNodeUnion(body), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateUnqualifiedClassInstantiationNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), type == null ? null : type.getUid(), constructorTypeArguments == null ? null : constructorTypeArguments.getUid(), arguments == null ? null : arguments.getUid(), body == null ? null : body.getUid(), startLocation, stopLocation));
        }
        return ret;
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
        UnqualifiedClassInstantiationNode ret = new UnqualifiedClassInstantiationNodeImpl(type, constructorTypeArguments, arguments, body, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateUnqualifiedClassInstantiationNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), type == null ? null : (type.getNodeValue() == null ? null : type.getNodeValue().getUid()), constructorTypeArguments == null ? null : (constructorTypeArguments.getNodeValue() == null ? null : constructorTypeArguments.getNodeValue().getUid()), arguments == null ? null : (arguments.getNodeValue() == null ? null : arguments.getNodeValue().getUid()), body == null ? null : (body.getNodeValue() == null ? null : body.getNodeValue().getUid()), startLocation, stopLocation));
        }
        return ret;
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
        UnqualifiedClassInstantiationNode ret = new UnqualifiedClassInstantiationNodeImpl(this.<DeclaredTypeNode>makeNormalNodeUnion(type), this.<TypeArgumentListNode>makeNormalNodeUnion(constructorTypeArguments), this.<ExpressionListNode>makeNormalNodeUnion(arguments), this.<AnonymousClassBodyNode>makeNormalNodeUnion(body), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateUnqualifiedClassInstantiationNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), type == null ? null : type.getUid(), constructorTypeArguments == null ? null : constructorTypeArguments.getUid(), arguments == null ? null : arguments.getUid(), body == null ? null : body.getUid(), startLocation, stopLocation));
        }
        return ret;
    }
    
    /**
     * Creates a UnqualifiedClassInstantiationNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public UnqualifiedClassInstantiationNode makeUnqualifiedClassInstantiationNode(
            DeclaredTypeNode type)
    {
        UnqualifiedClassInstantiationNode ret = new UnqualifiedClassInstantiationNodeImpl(this.<DeclaredTypeNode>makeNormalNodeUnion(type), this.<TypeArgumentListNode>makeNormalNodeUnion(makeTypeArgumentListNode()), this.<ExpressionListNode>makeNormalNodeUnion(makeExpressionListNode()), this.<AnonymousClassBodyNode>makeNormalNodeUnion(null), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateUnqualifiedClassInstantiationNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), type == null ? null : type.getUid(), ret.getConstructorTypeArguments() == null ? null : ret.getConstructorTypeArguments().getUid(), ret.getArguments() == null ? null : ret.getArguments().getUid(), ret.getBody() == null ? null : ret.getBody().getUid(), startLocation, stopLocation));
        }
        return ret;
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
        UnqualifiedClassInstantiationNode ret = new UnqualifiedClassInstantiationNodeImpl(this.<DeclaredTypeNode>makeNormalNodeUnion(type), this.<TypeArgumentListNode>makeNormalNodeUnion(makeTypeArgumentListNode()), this.<ExpressionListNode>makeNormalNodeUnion(makeExpressionListNode()), this.<AnonymousClassBodyNode>makeNormalNodeUnion(null), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateUnqualifiedClassInstantiationNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), type == null ? null : type.getUid(), ret.getConstructorTypeArguments() == null ? null : ret.getConstructorTypeArguments().getUid(), ret.getArguments() == null ? null : ret.getArguments().getUid(), ret.getBody() == null ? null : ret.getBody().getUid(), startLocation, stopLocation));
        }
        return ret;
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
        UnqualifiedClassInstantiationNode ret = new UnqualifiedClassInstantiationNodeImpl(this.<DeclaredTypeNode>makeNormalNodeUnion(type), this.<TypeArgumentListNode>makeNormalNodeUnion(makeTypeArgumentListNode()), this.<ExpressionListNode>makeNormalNodeUnion(arguments), this.<AnonymousClassBodyNode>makeNormalNodeUnion(null), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateUnqualifiedClassInstantiationNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), type == null ? null : type.getUid(), ret.getConstructorTypeArguments() == null ? null : ret.getConstructorTypeArguments().getUid(), arguments == null ? null : arguments.getUid(), ret.getBody() == null ? null : ret.getBody().getUid(), startLocation, stopLocation));
        }
        return ret;
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
        UnqualifiedClassInstantiationNode ret = new UnqualifiedClassInstantiationNodeImpl(this.<DeclaredTypeNode>makeNormalNodeUnion(type), this.<TypeArgumentListNode>makeNormalNodeUnion(makeTypeArgumentListNode()), this.<ExpressionListNode>makeNormalNodeUnion(arguments), this.<AnonymousClassBodyNode>makeNormalNodeUnion(null), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateUnqualifiedClassInstantiationNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), type == null ? null : type.getUid(), ret.getConstructorTypeArguments() == null ? null : ret.getConstructorTypeArguments().getUid(), arguments == null ? null : arguments.getUid(), ret.getBody() == null ? null : ret.getBody().getUid(), startLocation, stopLocation));
        }
        return ret;
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
        VariableAccessNode ret = new VariableAccessNodeImpl(expression, identifier, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateVariableAccessNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), expression == null ? null : (expression.getNodeValue() == null ? null : expression.getNodeValue().getUid()), identifier == null ? null : (identifier.getNodeValue() == null ? null : identifier.getNodeValue().getUid()), startLocation, stopLocation));
        }
        return ret;
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
        VariableAccessNode ret = new VariableAccessNodeImpl(this.<PrimaryExpressionNode>makeNormalNodeUnion(expression), this.<IdentifierNode>makeNormalNodeUnion(identifier), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateVariableAccessNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), expression == null ? null : expression.getUid(), identifier == null ? null : identifier.getUid(), startLocation, stopLocation));
        }
        return ret;
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
        VariableAccessNode ret = new VariableAccessNodeImpl(expression, identifier, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateVariableAccessNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), expression == null ? null : (expression.getNodeValue() == null ? null : expression.getNodeValue().getUid()), identifier == null ? null : (identifier.getNodeValue() == null ? null : identifier.getNodeValue().getUid()), startLocation, stopLocation));
        }
        return ret;
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
        VariableAccessNode ret = new VariableAccessNodeImpl(this.<PrimaryExpressionNode>makeNormalNodeUnion(expression), this.<IdentifierNode>makeNormalNodeUnion(identifier), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateVariableAccessNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), expression == null ? null : expression.getUid(), identifier == null ? null : identifier.getUid(), startLocation, stopLocation));
        }
        return ret;
    }
    
    /**
     * Creates a VariableAccessNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public VariableAccessNode makeVariableAccessNode(
            IdentifierNode identifier)
    {
        VariableAccessNode ret = new VariableAccessNodeImpl(this.<PrimaryExpressionNode>makeNormalNodeUnion(null), this.<IdentifierNode>makeNormalNodeUnion(identifier), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateVariableAccessNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), ret.getExpression() == null ? null : ret.getExpression().getUid(), identifier == null ? null : identifier.getUid(), startLocation, stopLocation));
        }
        return ret;
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
        VariableAccessNode ret = new VariableAccessNodeImpl(this.<PrimaryExpressionNode>makeNormalNodeUnion(null), this.<IdentifierNode>makeNormalNodeUnion(identifier), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateVariableAccessNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), ret.getExpression() == null ? null : ret.getExpression().getUid(), identifier == null ? null : identifier.getUid(), startLocation, stopLocation));
        }
        return ret;
    }
    
    /**
     * Creates a VariableDeclaratorListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public VariableDeclaratorListNode makeVariableDeclaratorListNodeWithUnions(
            List<NodeUnion<? extends VariableDeclaratorNode>> children)
    {
        VariableDeclaratorListNode ret = new VariableDeclaratorListNodeImpl(children, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateVariableDeclaratorListNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), EditScriptUtilities.getNodeUnionUids(children), startLocation, stopLocation));
        }
        return ret;
    }
    
    /**
     * Creates a VariableDeclaratorListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public VariableDeclaratorListNode makeVariableDeclaratorListNode(
            List<VariableDeclaratorNode> children)
    {
        VariableDeclaratorListNode ret = new VariableDeclaratorListNodeImpl(unionWrapList(children), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateVariableDeclaratorListNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), EditScriptUtilities.getNodeUids(children), startLocation, stopLocation));
        }
        return ret;
    }
    
    /**
     * Creates a VariableDeclaratorListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public VariableDeclaratorListNode makeVariableDeclaratorListNode(
            VariableDeclaratorNode... childrenElements)
    {
        List<VariableDeclaratorNode> children = Arrays.asList(childrenElements);
        return makeVariableDeclaratorListNode(children, startLocation, stopLocation);
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
        VariableDeclaratorListNode ret = new VariableDeclaratorListNodeImpl(children, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateVariableDeclaratorListNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), EditScriptUtilities.getNodeUnionUids(children), startLocation, stopLocation));
        }
        return ret;
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
        VariableDeclaratorListNode ret = new VariableDeclaratorListNodeImpl(unionWrapList(children), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateVariableDeclaratorListNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), EditScriptUtilities.getNodeUids(children), startLocation, stopLocation));
        }
        return ret;
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
        List<VariableDeclaratorNode> children = Arrays.asList(childrenElements);
        return makeVariableDeclaratorListNode(children, startLocation, stopLocation);
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
        VariableDeclaratorNode ret = new VariableDeclaratorNodeImpl(identifier, arrayLevels, initializer, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateVariableDeclaratorNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), identifier == null ? null : (identifier.getNodeValue() == null ? null : identifier.getNodeValue().getUid()), arrayLevels, initializer == null ? null : (initializer.getNodeValue() == null ? null : initializer.getNodeValue().getUid()), startLocation, stopLocation));
        }
        return ret;
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
        VariableDeclaratorNode ret = new VariableDeclaratorNodeImpl(this.<IdentifierNode>makeNormalNodeUnion(identifier), arrayLevels, this.<VariableInitializerNode>makeNormalNodeUnion(initializer), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateVariableDeclaratorNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), identifier == null ? null : identifier.getUid(), arrayLevels, initializer == null ? null : initializer.getUid(), startLocation, stopLocation));
        }
        return ret;
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
        VariableDeclaratorNode ret = new VariableDeclaratorNodeImpl(identifier, arrayLevels, initializer, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateVariableDeclaratorNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), identifier == null ? null : (identifier.getNodeValue() == null ? null : identifier.getNodeValue().getUid()), arrayLevels, initializer == null ? null : (initializer.getNodeValue() == null ? null : initializer.getNodeValue().getUid()), startLocation, stopLocation));
        }
        return ret;
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
        VariableDeclaratorNode ret = new VariableDeclaratorNodeImpl(this.<IdentifierNode>makeNormalNodeUnion(identifier), arrayLevels, this.<VariableInitializerNode>makeNormalNodeUnion(initializer), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateVariableDeclaratorNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), identifier == null ? null : identifier.getUid(), arrayLevels, initializer == null ? null : initializer.getUid(), startLocation, stopLocation));
        }
        return ret;
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
        VariableDeclaratorNode ret = new VariableDeclaratorNodeImpl(this.<IdentifierNode>makeNormalNodeUnion(identifier), 0, this.<VariableInitializerNode>makeNormalNodeUnion(initializer), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateVariableDeclaratorNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), identifier == null ? null : identifier.getUid(), ret.getArrayLevels(), initializer == null ? null : initializer.getUid(), startLocation, stopLocation));
        }
        return ret;
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
        VariableDeclaratorNode ret = new VariableDeclaratorNodeImpl(this.<IdentifierNode>makeNormalNodeUnion(identifier), 0, this.<VariableInitializerNode>makeNormalNodeUnion(initializer), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateVariableDeclaratorNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), identifier == null ? null : identifier.getUid(), ret.getArrayLevels(), initializer == null ? null : initializer.getUid(), startLocation, stopLocation));
        }
        return ret;
    }
    
    /**
     * Creates a VariableInitializerListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public VariableInitializerListNode makeVariableInitializerListNodeWithUnions(
            List<NodeUnion<? extends VariableInitializerNode>> children)
    {
        VariableInitializerListNode ret = new VariableInitializerListNodeImpl(children, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateVariableInitializerListNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), EditScriptUtilities.getNodeUnionUids(children), startLocation, stopLocation));
        }
        return ret;
    }
    
    /**
     * Creates a VariableInitializerListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public VariableInitializerListNode makeVariableInitializerListNode(
            List<VariableInitializerNode> children)
    {
        VariableInitializerListNode ret = new VariableInitializerListNodeImpl(unionWrapList(children), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateVariableInitializerListNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), EditScriptUtilities.getNodeUids(children), startLocation, stopLocation));
        }
        return ret;
    }
    
    /**
     * Creates a VariableInitializerListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public VariableInitializerListNode makeVariableInitializerListNode(
            VariableInitializerNode... childrenElements)
    {
        List<VariableInitializerNode> children = Arrays.asList(childrenElements);
        return makeVariableInitializerListNode(children, startLocation, stopLocation);
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
        VariableInitializerListNode ret = new VariableInitializerListNodeImpl(children, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateVariableInitializerListNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), EditScriptUtilities.getNodeUnionUids(children), startLocation, stopLocation));
        }
        return ret;
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
        VariableInitializerListNode ret = new VariableInitializerListNodeImpl(unionWrapList(children), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateVariableInitializerListNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), EditScriptUtilities.getNodeUids(children), startLocation, stopLocation));
        }
        return ret;
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
        List<VariableInitializerNode> children = Arrays.asList(childrenElements);
        return makeVariableInitializerListNode(children, startLocation, stopLocation);
    }
    
    /**
     * Creates a VariableListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public VariableListNode makeVariableListNodeWithUnions(
            List<NodeUnion<? extends VariableNode>> children)
    {
        VariableListNode ret = new VariableListNodeImpl(children, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateVariableListNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), EditScriptUtilities.getNodeUnionUids(children), startLocation, stopLocation));
        }
        return ret;
    }
    
    /**
     * Creates a VariableListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public VariableListNode makeVariableListNode(
            List<VariableNode> children)
    {
        VariableListNode ret = new VariableListNodeImpl(unionWrapList(children), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateVariableListNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), EditScriptUtilities.getNodeUids(children), startLocation, stopLocation));
        }
        return ret;
    }
    
    /**
     * Creates a VariableListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public VariableListNode makeVariableListNode(
            VariableNode... childrenElements)
    {
        List<VariableNode> children = Arrays.asList(childrenElements);
        return makeVariableListNode(children, startLocation, stopLocation);
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
        VariableListNode ret = new VariableListNodeImpl(children, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateVariableListNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), EditScriptUtilities.getNodeUnionUids(children), startLocation, stopLocation));
        }
        return ret;
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
        VariableListNode ret = new VariableListNodeImpl(unionWrapList(children), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateVariableListNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), EditScriptUtilities.getNodeUids(children), startLocation, stopLocation));
        }
        return ret;
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
        List<VariableNode> children = Arrays.asList(childrenElements);
        return makeVariableListNode(children, startLocation, stopLocation);
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
        VariableModifiersNode ret = new VariableModifiersNodeImpl(finalFlag, metaAnnotations, annotations, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateVariableModifiersNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), finalFlag, metaAnnotations == null ? null : (metaAnnotations.getNodeValue() == null ? null : metaAnnotations.getNodeValue().getUid()), annotations == null ? null : (annotations.getNodeValue() == null ? null : annotations.getNodeValue().getUid()), startLocation, stopLocation));
        }
        return ret;
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
        VariableModifiersNode ret = new VariableModifiersNodeImpl(finalFlag, this.<MetaAnnotationListNode>makeNormalNodeUnion(metaAnnotations), this.<AnnotationListNode>makeNormalNodeUnion(annotations), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateVariableModifiersNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), finalFlag, metaAnnotations == null ? null : metaAnnotations.getUid(), annotations == null ? null : annotations.getUid(), startLocation, stopLocation));
        }
        return ret;
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
        VariableModifiersNode ret = new VariableModifiersNodeImpl(finalFlag, metaAnnotations, annotations, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateVariableModifiersNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), finalFlag, metaAnnotations == null ? null : (metaAnnotations.getNodeValue() == null ? null : metaAnnotations.getNodeValue().getUid()), annotations == null ? null : (annotations.getNodeValue() == null ? null : annotations.getNodeValue().getUid()), startLocation, stopLocation));
        }
        return ret;
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
        VariableModifiersNode ret = new VariableModifiersNodeImpl(finalFlag, this.<MetaAnnotationListNode>makeNormalNodeUnion(metaAnnotations), this.<AnnotationListNode>makeNormalNodeUnion(annotations), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateVariableModifiersNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), finalFlag, metaAnnotations == null ? null : metaAnnotations.getUid(), annotations == null ? null : annotations.getUid(), startLocation, stopLocation));
        }
        return ret;
    }
    
    /**
     * Creates a VariableModifiersNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public VariableModifiersNode makeVariableModifiersNode()
    {
        VariableModifiersNode ret = new VariableModifiersNodeImpl(false, this.<MetaAnnotationListNode>makeNormalNodeUnion(makeMetaAnnotationListNode()), this.<AnnotationListNode>makeNormalNodeUnion(makeAnnotationListNode()), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateVariableModifiersNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), ret.getFinalFlag(), ret.getMetaAnnotations() == null ? null : ret.getMetaAnnotations().getUid(), ret.getAnnotations() == null ? null : ret.getAnnotations().getUid(), startLocation, stopLocation));
        }
        return ret;
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
        VariableModifiersNode ret = new VariableModifiersNodeImpl(false, this.<MetaAnnotationListNode>makeNormalNodeUnion(makeMetaAnnotationListNode()), this.<AnnotationListNode>makeNormalNodeUnion(makeAnnotationListNode()), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateVariableModifiersNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), ret.getFinalFlag(), ret.getMetaAnnotations() == null ? null : ret.getMetaAnnotations().getUid(), ret.getAnnotations() == null ? null : ret.getAnnotations().getUid(), startLocation, stopLocation));
        }
        return ret;
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
        VariableNode ret = new VariableNodeImpl(modifiers, type, identifier, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateVariableNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), modifiers == null ? null : (modifiers.getNodeValue() == null ? null : modifiers.getNodeValue().getUid()), type == null ? null : (type.getNodeValue() == null ? null : type.getNodeValue().getUid()), identifier == null ? null : (identifier.getNodeValue() == null ? null : identifier.getNodeValue().getUid()), startLocation, stopLocation));
        }
        return ret;
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
        VariableNode ret = new VariableNodeImpl(this.<VariableModifiersNode>makeNormalNodeUnion(modifiers), this.<TypeNode>makeNormalNodeUnion(type), this.<IdentifierNode>makeNormalNodeUnion(identifier), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateVariableNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), modifiers == null ? null : modifiers.getUid(), type == null ? null : type.getUid(), identifier == null ? null : identifier.getUid(), startLocation, stopLocation));
        }
        return ret;
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
        VariableNode ret = new VariableNodeImpl(modifiers, type, identifier, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateVariableNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), modifiers == null ? null : (modifiers.getNodeValue() == null ? null : modifiers.getNodeValue().getUid()), type == null ? null : (type.getNodeValue() == null ? null : type.getNodeValue().getUid()), identifier == null ? null : (identifier.getNodeValue() == null ? null : identifier.getNodeValue().getUid()), startLocation, stopLocation));
        }
        return ret;
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
        VariableNode ret = new VariableNodeImpl(this.<VariableModifiersNode>makeNormalNodeUnion(modifiers), this.<TypeNode>makeNormalNodeUnion(type), this.<IdentifierNode>makeNormalNodeUnion(identifier), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateVariableNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), modifiers == null ? null : modifiers.getUid(), type == null ? null : type.getUid(), identifier == null ? null : identifier.getUid(), startLocation, stopLocation));
        }
        return ret;
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
        VariableNode ret = new VariableNodeImpl(this.<VariableModifiersNode>makeNormalNodeUnion(makeVariableModifiersNode()), this.<TypeNode>makeNormalNodeUnion(type), this.<IdentifierNode>makeNormalNodeUnion(identifier), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateVariableNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), ret.getModifiers() == null ? null : ret.getModifiers().getUid(), type == null ? null : type.getUid(), identifier == null ? null : identifier.getUid(), startLocation, stopLocation));
        }
        return ret;
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
        VariableNode ret = new VariableNodeImpl(this.<VariableModifiersNode>makeNormalNodeUnion(makeVariableModifiersNode()), this.<TypeNode>makeNormalNodeUnion(type), this.<IdentifierNode>makeNormalNodeUnion(identifier), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateVariableNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), ret.getModifiers() == null ? null : ret.getModifiers().getUid(), type == null ? null : type.getUid(), identifier == null ? null : identifier.getUid(), startLocation, stopLocation));
        }
        return ret;
    }
    
    /**
     * Creates a VoidTypeNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public VoidTypeNode makeVoidTypeNode(
    )
    {
        VoidTypeNode ret = new VoidTypeNodeImpl(startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateVoidTypeNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), startLocation, stopLocation));
        }
        return ret;
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
        VoidTypeNode ret = new VoidTypeNodeImpl(startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateVoidTypeNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), startLocation, stopLocation));
        }
        return ret;
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
        WhileLoopNode ret = new WhileLoopNodeImpl(condition, statement, metaAnnotations, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateWhileLoopNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), condition == null ? null : (condition.getNodeValue() == null ? null : condition.getNodeValue().getUid()), statement == null ? null : (statement.getNodeValue() == null ? null : statement.getNodeValue().getUid()), metaAnnotations == null ? null : (metaAnnotations.getNodeValue() == null ? null : metaAnnotations.getNodeValue().getUid()), startLocation, stopLocation));
        }
        return ret;
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
        WhileLoopNode ret = new WhileLoopNodeImpl(this.<ExpressionNode>makeNormalNodeUnion(condition), this.<StatementNode>makeNormalNodeUnion(statement), this.<MetaAnnotationListNode>makeNormalNodeUnion(metaAnnotations), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateWhileLoopNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), condition == null ? null : condition.getUid(), statement == null ? null : statement.getUid(), metaAnnotations == null ? null : metaAnnotations.getUid(), startLocation, stopLocation));
        }
        return ret;
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
        WhileLoopNode ret = new WhileLoopNodeImpl(condition, statement, metaAnnotations, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateWhileLoopNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), condition == null ? null : (condition.getNodeValue() == null ? null : condition.getNodeValue().getUid()), statement == null ? null : (statement.getNodeValue() == null ? null : statement.getNodeValue().getUid()), metaAnnotations == null ? null : (metaAnnotations.getNodeValue() == null ? null : metaAnnotations.getNodeValue().getUid()), startLocation, stopLocation));
        }
        return ret;
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
        WhileLoopNode ret = new WhileLoopNodeImpl(this.<ExpressionNode>makeNormalNodeUnion(condition), this.<StatementNode>makeNormalNodeUnion(statement), this.<MetaAnnotationListNode>makeNormalNodeUnion(metaAnnotations), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateWhileLoopNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), condition == null ? null : condition.getUid(), statement == null ? null : statement.getUid(), metaAnnotations == null ? null : metaAnnotations.getUid(), startLocation, stopLocation));
        }
        return ret;
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
        WhileLoopNode ret = new WhileLoopNodeImpl(this.<ExpressionNode>makeNormalNodeUnion(condition), this.<StatementNode>makeNormalNodeUnion(statement), this.<MetaAnnotationListNode>makeNormalNodeUnion(makeMetaAnnotationListNode()), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateWhileLoopNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), condition == null ? null : condition.getUid(), statement == null ? null : statement.getUid(), ret.getMetaAnnotations() == null ? null : ret.getMetaAnnotations().getUid(), startLocation, stopLocation));
        }
        return ret;
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
        WhileLoopNode ret = new WhileLoopNodeImpl(this.<ExpressionNode>makeNormalNodeUnion(condition), this.<StatementNode>makeNormalNodeUnion(statement), this.<MetaAnnotationListNode>makeNormalNodeUnion(makeMetaAnnotationListNode()), startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateWhileLoopNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), condition == null ? null : condition.getUid(), statement == null ? null : statement.getUid(), ret.getMetaAnnotations() == null ? null : ret.getMetaAnnotations().getUid(), startLocation, stopLocation));
        }
        return ret;
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
        WildcardTypeNode ret = new WildcardTypeNodeImpl(bound, upperBound, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateWildcardTypeNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), bound == null ? null : (bound.getNodeValue() == null ? null : bound.getNodeValue().getUid()), upperBound, startLocation, stopLocation));
        }
        return ret;
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
        WildcardTypeNode ret = new WildcardTypeNodeImpl(this.<ReferenceTypeNode>makeNormalNodeUnion(bound), upperBound, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateWildcardTypeNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), bound == null ? null : bound.getUid(), upperBound, startLocation, stopLocation));
        }
        return ret;
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
        WildcardTypeNode ret = new WildcardTypeNodeImpl(bound, upperBound, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateWildcardTypeNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), bound == null ? null : (bound.getNodeValue() == null ? null : bound.getNodeValue().getUid()), upperBound, startLocation, stopLocation));
        }
        return ret;
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
        WildcardTypeNode ret = new WildcardTypeNodeImpl(this.<ReferenceTypeNode>makeNormalNodeUnion(bound), upperBound, startLocation, stopLocation, manager, binary);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new CreateWildcardTypeNodeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(), ret.getUid(), bound == null ? null : bound.getUid(), upperBound, startLocation, stopLocation));
        }
        return ret;
    }
    
}
