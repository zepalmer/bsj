package edu.jhu.cs.bsj.stdlib.metaannotations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import edu.jhu.cs.bsj.compiler.ast.AccessModifier;
import edu.jhu.cs.bsj.compiler.ast.AssignmentOperator;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.exception.MetaprogramExecutionFailureException;
import edu.jhu.cs.bsj.compiler.ast.node.ClassDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.EnumDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.FieldDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.IdentifierNode;
import edu.jhu.cs.bsj.compiler.ast.node.InterfaceDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.MethodDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.TypeDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.VariableDeclaratorNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.AnonymousClassMemberListNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.ClassMemberListNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.InterfaceMemberListNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.ListNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaAnnotationMetaprogramAnchorNode;
import edu.jhu.cs.bsj.compiler.metaannotation.InvalidMetaAnnotationConfigurationException;
import edu.jhu.cs.bsj.compiler.metaprogram.Context;
import edu.jhu.cs.bsj.stdlib.diagnostic.impl.InvalidEnclosingTypeDiagnosticImpl;
import edu.jhu.cs.bsj.stdlib.metaannotations.utils.AbstractDeclarationMetaannotationMetaprogram;

/**
 * This BSJ meta-annotation class represents a metaprogram which creates a getter and a setter for the field that it
 * annotations as per the Java property idiom. It participates in the <tt>property</tt> target and has no dependencies.
 * It operates in default local and package modes.
 * 
 * @author Zachary Palmer
 */
public class Property extends AbstractDeclarationMetaannotationMetaprogram<FieldDeclarationNode> 
{
	public Property()
	{
		super(Collections.singletonList("property"), Collections.<String> emptyList(), FieldDeclarationNode.class);
	}

	// TODO: boolean properties for "getter" and "setter" for read-only or write-only properties

	protected void execute(Context<MetaAnnotationMetaprogramAnchorNode> context, FieldDeclarationNode fieldNode)
	{
		BsjNodeFactory factory = context.getFactory();

		// Try to find the list of members for this field declaration
		// TODO: we're not necessarily in a type declaration... not exactly.  Consider anonymous classes.
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
			List<Class<? extends TypeDeclarationNode>> legalEnclosingTypeDeclarationsList = new ArrayList<Class<? extends TypeDeclarationNode>>();
			legalEnclosingTypeDeclarationsList.add(InterfaceDeclarationNode.class);
			legalEnclosingTypeDeclarationsList.add(ClassDeclarationNode.class);
			legalEnclosingTypeDeclarationsList.add(EnumDeclarationNode.class);
			context.getDiagnosticListener().report(
					new InvalidEnclosingTypeDiagnosticImpl(getClass(), null, legalEnclosingTypeDeclarationsList));
			throw new MetaprogramExecutionFailureException();
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
		String varname = var.getIdentifier().getIdentifier();
		IdentifierNode getterName = factory.makeIdentifierNode("get" + Character.toUpperCase(varname.charAt(0))
				+ varname.substring(1));
		MethodDeclarationNode getterMethod = factory.makeMethodDeclarationNode(
				factory.makeBlockStatementListNode(factory.makeReturnNode(factory.makeVariableAccessNode(
						factory.makeThisNode(), factory.makeIdentifierNode(varname)))),
				factory.makeMethodModifiersNode(AccessModifier.PUBLIC), getterName, factory.makeVariableListNode(),
				var.getEffectiveType(factory), 
				factory.makeJavadocNode(
                        "Getter for " + varname + ".\n" +
                        "@return the value of " + varname + "."));

		return getterMethod;
	}

	private MethodDeclarationNode createSetter(BsjNodeFactory factory, VariableDeclaratorNode var)
	{
		String varname = var.getIdentifier().getIdentifier();
		IdentifierNode setterName = factory.makeIdentifierNode("set" + Character.toUpperCase(varname.charAt(0))
				+ varname.substring(1));
		MethodDeclarationNode setterMethod = factory.makeMethodDeclarationNode(
				factory.makeBlockStatementListNode(factory.makeExpressionStatementNode(factory.makeAssignmentNode(
						factory.makeVariableAccessNode(factory.makeThisNode(),
								factory.makeIdentifierNode(varname)), AssignmentOperator.ASSIGNMENT,
						factory.makeVariableAccessNode(null, factory.makeIdentifierNode(varname))))),
				factory.makeMethodModifiersNode(AccessModifier.PUBLIC), setterName,
				factory.makeVariableListNode(factory.makeVariableNode(factory.makeVariableModifiersNode(),
						var.getEffectiveType(factory), factory.makeIdentifierNode(varname))),
				factory.makeVoidTypeNode(), 
				factory.makeJavadocNode(
                        "Setter for " + varname + ".\n" +
                        "@param " + varname + " the " + varname + " value to set."));
		return setterMethod;
	}

	@Override
	public void complete() throws InvalidMetaAnnotationConfigurationException
	{
	}

}
