package edu.jhu.cs.bsj.compiler.impl.tool.compiler.names;

import org.apache.log4j.Logger;

import edu.jhu.cs.bsj.compiler.ast.NameCategory;
import edu.jhu.cs.bsj.compiler.ast.node.AnnotationElementNode;
import edu.jhu.cs.bsj.compiler.ast.node.AnnotationMethodDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.AnnotationValueNode;
import edu.jhu.cs.bsj.compiler.ast.node.ImportOnDemandNode;
import edu.jhu.cs.bsj.compiler.ast.node.ImportSingleTypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.MethodInvocationByNameNode;
import edu.jhu.cs.bsj.compiler.ast.node.NameNode;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.PackageDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.SingleStaticImportNode;
import edu.jhu.cs.bsj.compiler.ast.node.StaticImportOnDemandNode;
import edu.jhu.cs.bsj.compiler.ast.node.TypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.VariableAccessByNameNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramDependencyNode;

/**
 * This class is intended to perform initial name categorization according to the rules in &#xA7;6.5.1 of the JLS v3.
 * 
 * @author Zachary Palmer
 */
public class InitialNameCategorizer
{
	/** A singleton for this object. */
	public static final InitialNameCategorizer SINGLETON = new InitialNameCategorizer();

	/** The logger for this object. */
	@SuppressWarnings("unused")
	private Logger LOGGER = Logger.getLogger(this.getClass());

	/**
	 * Assigns a category to the specified name node as per the rules in &#xA7;6.5.1 of the JLS v3.
	 * 
	 * @param node The node to categorize.
	 * @param category The category to assign to that node.
	 */
	public NameCategory categorize(NameNode node)
	{
		// ***** A name is syntactically classified as a PackageName in these contexts:
		// *** In a package declaration (§7.4)
		if (hasAncestry(node, PackageDeclarationNode.class))
		{
			return NameCategory.PACKAGE;
		}
		// *** To the left of a "." in a qualified package name
		if (hasParentName(node, NameCategory.PACKAGE))
		{
			return NameCategory.PACKAGE;
		}

		// ***** A name is syntactically classified as a TypeName in these contexts:
		// *** In a single-type-import declaration (§7.5.1)
		if (hasAncestry(node, ImportSingleTypeNode.class))
		{
			return NameCategory.TYPE;
		}
		// *** To the left of the "." in a single static import (§7.5.3) declaration
		if (hasAncestry(node, SingleStaticImportNode.class))
		{
			return NameCategory.TYPE;
		}
		// *** To the left of the "." in a static import-on-demand (§7.5.4) declaration
		if (hasAncestry(node, StaticImportOnDemandNode.class))
		{
			return NameCategory.TYPE;
		}
		// *** To the left of the "<" in a parameterized type (§4.5)
		// *** In an actual type argument list of a parameterized type
		// *** In an explicit actual type argument list in a generic method (§8.4.4) or constructor (§8.8.4) invocation
		// *** In an extends clause in a type variable declaration (§8.1.2)
		// *** In an extends clause of a wildcard type argument (§4.5.1)
		// *** In a super clause of a wildcard type argument (§4.5.1)
		// *** In an extends clause in a class declaration (§8.1.4)
		// *** In an implements clause in a class declaration (§8.1.5)
		// *** In an extends clause in an interface declaration (§9.1.3)
		// *** After the "@" sign in an annotation (§9.7)
		// *** As a Type (or the part of a Type that remains after all brackets are deleted) in any of the following
		// * In a field declaration (§8.3, §9.3)
		// * As the result type of a method (§8.4, §9.4)
		// * As the type of a formal parameter of a method or constructor (§8.4.1, §8.8.1, §9.4)
		// * As the type of an exception that can be thrown by a method or constructor (§8.4.6, §8.8.5, §9.4)
		// * As the type of a local variable (§14.4)
		// * As the type of an exception parameter in a catch clause of a try statement (§14.20)
		// * As the type in a class literal (§15.8.2)
		// * As the qualifying type of a qualified this expression (§15.8.4).
		// * As the class type which is to be instantiated in an unqualified class instance creation expression (§15.9)
		// * As the direct superclass or direct superinterface of an anonymous class (§15.9.5) which is to be
		// instantiated in an unqualified class instance creation expression (§15.9)
		// * As the element type of an array to be created in an array creation expression (§15.10)
		// * As the qualifying type of field access using the keyword super (§15.11.2)
		// * As the qualifying type of a method invocation using the keyword super (§15.12)
		// * As the type mentioned in the cast operator of a cast expression (§15.16)
		// * As the type that follows the instanceof relational operator (§15.20.2)
		// (All of the above pretty much amount to an exhaustive description of where type nodes can appear.)
		if (hasAncestry(node, TypeNode.class))
		{
			return NameCategory.TYPE;
		}

		// ***** A name is syntactically classified as an ExpressionName in these contexts:
		// *** As the qualifying expression in a qualified superclass constructor invocation (§8.8.7.1)
		// *** As the qualifying expression in a qualified class instance creation expression (§15.9)
		// *** As the array reference expression in an array access expression (§15.13)
		// *** As a PostfixExpression (§15.14)
		// *** As the left-hand operand of an assignment operator (§15.26)
		// (All of the above seem to indicate the locations in which a field can be accessed by name (directly or
		// indirectly.)
		if (hasAncestry(node, VariableAccessByNameNode.class))
		{
			return NameCategory.EXPRESSION;
		}

		// ***** A name is syntactically classified as a MethodName in these contexts:
		// *** Before the "(" in a method invocation expression (§15.12)
		if (hasAncestry(node, MethodInvocationByNameNode.class))
		{
			return NameCategory.METHOD;
		}
		// *** To the left of the "=" sign in an annotation’s element value pair (§9.7)
		// The parse rules of the JLS indicate that this is an identifier, not a name. Thus, N/A.

		// ***** A name is syntactically classified as a PackageOrTypeName in these contexts:
		// *** To the left of the "." in a qualified TypeName
		if (hasParentName(node, NameCategory.TYPE))
		{
			return NameCategory.PACKAGE_OR_TYPE;
		}
		// *** In a type-import-on-demand declaration (§7.5.2)
		if (hasAncestry(node, ImportOnDemandNode.class))
		{
			return NameCategory.PACKAGE_OR_TYPE;
		}
		// This rule is not explicitly listed in the JLS v3 but seems appropriate
		if (hasParentName(node, NameCategory.PACKAGE_OR_TYPE))
		{
			return NameCategory.PACKAGE_OR_TYPE;
		}

		// ***** A name is syntactically classified as an AmbiguousName in these contexts:
		// *** To the left of the "." in a qualified ExpressionName
		if (hasParentName(node, NameCategory.EXPRESSION))
		{
			return NameCategory.AMBIGUOUS;
		}
		// *** To the left of the "." in a qualified MethodName
		if (hasParentName(node, NameCategory.METHOD))
		{
			return NameCategory.AMBIGUOUS;
		}
		// *** To the left of the "." in a qualified AmbiguousName
		if (hasParentName(node, NameCategory.AMBIGUOUS))
		{
			return NameCategory.AMBIGUOUS;
		}
		// *** In the default value clause of an annotation type element declaration (§9.6)
		if (hasAncestrySequence(node, AnnotationValueNode.class, AnnotationMethodDeclarationNode.class))
		{
			return NameCategory.AMBIGUOUS;
		}
		// *** To the right of an "=" in an an element value pair (§9.7)
		if (hasAncestrySequence(node, AnnotationValueNode.class, AnnotationElementNode.class))
		{
			return NameCategory.AMBIGUOUS;
		}

		// ===== Begin BSJ naming rules =====

		// ***** A name is syntactically qualified as a MetaprogramTargetName in these contexts:
		// *** In a metaprogram dependency declaration.
		if (hasAncestry(node, MetaprogramDependencyNode.class))
		{
			return NameCategory.METAPROGRAM_TARGET;
		}

		// ***** A name is syntactically classified as a TypeName in these contexts:
		// *** To the left of a '.' in a MetaprogramTargetName.
		if (hasParentName(node, NameCategory.METAPROGRAM_TARGET))
		{
			return NameCategory.TYPE;
		}

		throw new IllegalStateException("Could not find a name categorization for " + node.getNameString()
				+ (node.getStartLocation() == null ? "" : " at " + node.getStartLocation()));
	}

	/**
	 * Determines whether or not the parent of the specified node is a name node of the given category.
	 * 
	 * @param node The node in question.
	 * @param category The category of the parent node.
	 * @return <code>true</code> if this is the case; <code>false</code> otherwise.
	 */
	private boolean hasParentName(NameNode node, NameCategory category)
	{
		return (node.getParent() instanceof NameNode && categorize((NameNode) node.getParent()) == category);
	}

	/**
	 * Determines whether or not the specified pattern appears in the types of the ancestors of the specified node.
	 * 
	 * @param node The node whose ancestry is to be checked.
	 * @param classes The expected type sequence for the ancestry.
	 * @return <code>true</code> if the node has that ancestry; <code>false</code> if it does not.
	 */
	private boolean hasAncestrySequence(Node node, Class<?>... classes)
	{
		int index = 0;
		while (node != null)
		{
			if (classes[index].isAssignableFrom(node.getClass()))
			{
				index++;
				if (index >= classes.length)
					return true;
			} else
			{
				index = 0;
			}
			node = node.getParent();
		}
		return false;
	}

	/**
	 * Determines whether or not the ancestry of the specified node is consistent with the provided expectation. The
	 * expectation is given as an array of classes. The first element in the array indicates a type to which the parent
	 * of the node must conform, the next element indicates a type which must be compatible with that node's parent, and
	 * so on.
	 * 
	 * @param node The node whose ancestry is to be checked.
	 * @param classes The expected types for the ancestry.
	 * @return <code>true</code> if the node has that ancestry; <code>false</code> if not.
	 */
	private boolean hasAncestry(Node node, Class<?>... classes)
	{
		for (Class<?> c : classes)
		{
			node = node.getParent();
			if (node == null)
				return false;
			if (!c.isAssignableFrom(node.getClass()))
				return false;
		}
		return true;
	}
}
