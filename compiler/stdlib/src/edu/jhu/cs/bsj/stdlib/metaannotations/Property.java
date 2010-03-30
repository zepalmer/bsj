package edu.jhu.cs.bsj.stdlib.metaannotations;

import java.util.Collections;

import edu.jhu.cs.bsj.compiler.ast.AccessModifier;
import edu.jhu.cs.bsj.compiler.ast.AssignmentOperator;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.NameCategory;
import edu.jhu.cs.bsj.compiler.ast.node.AnonymousClassMemberListNode;
import edu.jhu.cs.bsj.compiler.ast.node.ClassMemberListNode;
import edu.jhu.cs.bsj.compiler.ast.node.FieldDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.IdentifierNode;
import edu.jhu.cs.bsj.compiler.ast.node.InterfaceMemberListNode;
import edu.jhu.cs.bsj.compiler.ast.node.ListNode;
import edu.jhu.cs.bsj.compiler.ast.node.MethodDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.VariableDeclaratorNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaAnnotationMetaprogramAnchorNode;
import edu.jhu.cs.bsj.compiler.metaannotation.InvalidMetaAnnotationConfigurationException;
import edu.jhu.cs.bsj.compiler.metaprogram.AbstractBsjMetaAnnotationMetaprogram;
import edu.jhu.cs.bsj.compiler.metaprogram.Context;

/**
 * This BSJ meta-annotation class represents a metaprogram which creates a getter and a setter for the field that it
 * annotations as per the Java property idiom. It participates in the <tt>property</tt> target and has no dependencies.
 * It operates in default local and package modes.
 * 
 * @author Zachary Palmer
 */
public class Property extends AbstractBsjMetaAnnotationMetaprogram
{
	public Property()
	{
		super(Collections.singletonList("property"), Collections.<String> emptyList());
	}

	// TODO: boolean properties for "getter" and "setter" for read-only or write-only properties

	@Override
	protected void execute(Context<MetaAnnotationMetaprogramAnchorNode> context)
	{
		BsjNodeFactory factory = context.getFactory();

		FieldDeclarationNode fieldNode = context.getAnchor().getNearestAncestorOfType(FieldDeclarationNode.class);
		if (fieldNode == null)
		{
			// TODO: better error handling
			throw new IllegalArgumentException("Property annotation used without field declaration at "
					+ context.getAnchor().getStartLocation());
		}

		// Try to find the list of members for this field declaration
		ListNode<? super MethodDeclarationNode> list;
		list = fieldNode.getNearestAncestorOfType(ClassMemberListNode.class);
		if (list == null)
		{
			list = fieldNode.getNearestAncestorOfType(InterfaceMemberListNode.class);
		}
		if (list == null)
		{
			list = fieldNode.getNearestAncestorOfType(AnonymousClassMemberListNode.class);
		}
		if (list == null)
		{
			// TODO: better error handling
			throw new IllegalArgumentException("No class, interface, or anonymous class as a parent of the field "
					+ "annotated with @@Property at " + context.getAnchor().getStartLocation());
		}

		// Create a getter and a setter for each field
		for (VariableDeclaratorNode var : fieldNode.getDeclarators())
		{
			list.add(createGetter(factory, var));
			list.add(createSetter(factory, var));
		}
	}

	private MethodDeclarationNode createGetter(BsjNodeFactory factory, VariableDeclaratorNode var)
	{
		String varname = var.getName().getIdentifier();
		IdentifierNode getterName = factory.makeIdentifierNode("get" + Character.toUpperCase(varname.charAt(0))
				+ varname.substring(1));
		MethodDeclarationNode getterMethod = factory.makeMethodDeclarationNode(
				factory.makeBlockNode(factory.makeBlockStatementListNode(factory.makeReturnNode(factory.makeFieldAccessByExpressionNode(
						factory.makeThisNode(), factory.makeIdentifierNode(varname))))),
				factory.makeMethodModifiersNode(AccessModifier.PUBLIC), getterName, factory.makeVariableListNode(),
				var.getType().deepCopy(factory), null); // TODO: add Javadoc

		return getterMethod;
	}

	private MethodDeclarationNode createSetter(BsjNodeFactory factory, VariableDeclaratorNode var)
	{
		String varname = var.getName().getIdentifier();
		IdentifierNode setterName = factory.makeIdentifierNode("set" + Character.toUpperCase(varname.charAt(0))
				+ varname.substring(1));
		MethodDeclarationNode setterMethod = factory.makeMethodDeclarationNode(
				factory.makeBlockNode(factory.makeBlockStatementListNode(factory.makeExpressionStatementNode(factory.makeAssignmentNode(
						factory.makeFieldAccessByExpressionNode(factory.makeThisNode(),
								factory.makeIdentifierNode(varname)), AssignmentOperator.ASSIGNMENT,
						factory.makeFieldAccessByNameNode(factory.makeSimpleNameNode(
								factory.makeIdentifierNode(varname), NameCategory.EXPRESSION)))))),
				factory.makeMethodModifiersNode(AccessModifier.PUBLIC), setterName,
				factory.makeVariableListNode(factory.makeVariableNode(factory.makeVariableModifiersNode(),
						var.getType().deepCopy(factory), factory.makeIdentifierNode(varname))),
				factory.makeVoidTypeNode(), null); // TODO: add Javadoc
		return setterMethod;
	}

	@Override
	public void complete() throws InvalidMetaAnnotationConfigurationException
	{
	}
}
