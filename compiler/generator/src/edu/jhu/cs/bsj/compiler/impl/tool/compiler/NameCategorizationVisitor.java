package edu.jhu.cs.bsj.compiler.impl.tool.compiler;

import edu.jhu.cs.bsj.compiler.ast.NameCategory;
import edu.jhu.cs.bsj.compiler.ast.node.AnnotationNode;
import edu.jhu.cs.bsj.compiler.ast.node.ArrayCreationNode;
import edu.jhu.cs.bsj.compiler.ast.node.BaseTypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.CatchNode;
import edu.jhu.cs.bsj.compiler.ast.node.ClassDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.ClassLiteralNode;
import edu.jhu.cs.bsj.compiler.ast.node.ConstructorDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.DeclaredTypeListNode;
import edu.jhu.cs.bsj.compiler.ast.node.DeclaredTypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.FieldAccessByNameNode;
import edu.jhu.cs.bsj.compiler.ast.node.FieldDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.ImportSingleTypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.InstanceOfNode;
import edu.jhu.cs.bsj.compiler.ast.node.InterfaceDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.LiteralizableTypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.MethodDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.MethodInvocationNode;
import edu.jhu.cs.bsj.compiler.ast.node.NameNode;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.PackageDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.ParameterizedTypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.QualifiedClassInstantiationNode;
import edu.jhu.cs.bsj.compiler.ast.node.ReferenceTypeListNode;
import edu.jhu.cs.bsj.compiler.ast.node.ReferenceTypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.SingleStaticImportNode;
import edu.jhu.cs.bsj.compiler.ast.node.StaticImportOnDemandNode;
import edu.jhu.cs.bsj.compiler.ast.node.SuperFieldAccessNode;
import edu.jhu.cs.bsj.compiler.ast.node.SuperMethodInvocationNode;
import edu.jhu.cs.bsj.compiler.ast.node.SuperclassConstructorInvocationNode;
import edu.jhu.cs.bsj.compiler.ast.node.ThisNode;
import edu.jhu.cs.bsj.compiler.ast.node.TypeArgumentListNode;
import edu.jhu.cs.bsj.compiler.ast.node.TypeArgumentNode;
import edu.jhu.cs.bsj.compiler.ast.node.TypeCastNode;
import edu.jhu.cs.bsj.compiler.ast.node.TypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.TypeParameterNode;
import edu.jhu.cs.bsj.compiler.ast.node.UnparameterizedTypeListNode;
import edu.jhu.cs.bsj.compiler.ast.node.UnparameterizedTypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.UnqualifiedClassInstantiationNode;
import edu.jhu.cs.bsj.compiler.ast.node.VariableDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.VariableDeclaratorListNode;
import edu.jhu.cs.bsj.compiler.ast.node.VariableDeclaratorNode;
import edu.jhu.cs.bsj.compiler.ast.node.VariableListNode;
import edu.jhu.cs.bsj.compiler.ast.node.VariableNode;
import edu.jhu.cs.bsj.compiler.ast.node.WildcardTypeNode;
import edu.jhu.cs.bsj.compiler.ast.util.BsjTypedNodeNoOpVisitor;

/**
 * This visitor is used to categorize names in a parsed AST. Names are categorized into one of seven name categories:
 * the six specified in &#xA7;6 of the Java Language Specification and the metaprogram target name category specified in
 * the BSJ language specification. This visitor only categorizes names according to the rules in &#xA7;6.5.1 of the JLS;
 * the rules in &#xA7;6.5.2 are not handled here.
 * 
 * @author Zachary Palmer
 */
public class NameCategorizationVisitor extends BsjTypedNodeNoOpVisitor
{
	@Override
	public void visitNameNodeStart(NameNode node)
	{
		NameCategory category = selectCategory(node);
		// TODO: category assignment
	}

	/**
	 * Assigns a category to the specified name node.
	 * 
	 * @param node The node to categorize.
	 * @param category The category to assign to that node.
	 */
	private NameCategory selectCategory(NameNode node)
	{
		// ***** A name is syntactically classified as a PackageName in these contexts:
		// *** In a package declaration (§7.4)
		if (hasAncestry(node, PackageDeclarationNode.class))
		{
			return NameCategory.PACKAGE;
		}
		// *** To the left of a "." in a qualified package name
		if (node.getParent() instanceof NameNode && ((NameNode) node.getParent()).getCategory() == NameCategory.PACKAGE)
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
		if (hasAncestry(node, NameNode.class, SingleStaticImportNode.class))
		{
			return NameCategory.TYPE;
		}
		// *** To the left of the "." in a static import-on-demand (§7.5.4) declaration
		if (hasAncestry(node, NameNode.class, StaticImportOnDemandNode.class))
		{
			return NameCategory.TYPE;
		}
		// *** To the left of the "<" in a parameterized type (§4.5)
		if (hasAncestry(node, UnparameterizedTypeNode.class, ParameterizedTypeNode.class))
		{
			return NameCategory.TYPE;
		}
		// *** In an actual type argument list of a parameterized type
		if (hasAncestry(node, TypeArgumentNode.class, TypeArgumentListNode.class, ParameterizedTypeNode.class))
		{
			return NameCategory.TYPE;
		}
		// *** In an explicit actual type argument list in a generic method (§8.4.4) or constructor (§8.8.4) invocation
		if (hasAncestry(node, ReferenceTypeNode.class, ReferenceTypeListNode.class, MethodInvocationNode.class))
		{
			return NameCategory.TYPE;
		}
		// *** In an extends clause in a type variable declaration (§8.1.2)
		if (hasAncestry(node, DeclaredTypeNode.class, DeclaredTypeListNode.class, TypeParameterNode.class))
		{
			return NameCategory.TYPE;
		}
		// *** In an extends clause of a wildcard type argument (§4.5.1)
		// *** In a super clause of a wildcard type argument (§4.5.1)
		// (this check covers both of the above cases)
		if (hasAncestry(node, ReferenceTypeNode.class, WildcardTypeNode.class))
		{
			return NameCategory.TYPE;
		}
		// *** In an extends clause in a class declaration (§8.1.4)
		if (hasAncestry(node, DeclaredTypeNode.class, ClassDeclarationNode.class))
		{
			return NameCategory.TYPE;
		}
		// *** In an implements clause in a class declaration (§8.1.5)
		if (hasAncestry(node, DeclaredTypeNode.class, DeclaredTypeListNode.class, ClassDeclarationNode.class))
		{
			return NameCategory.TYPE;
		}
		// *** In an extends clause in an interface declaration (§9.1.3)
		if (hasAncestry(node, DeclaredTypeNode.class, DeclaredTypeListNode.class, InterfaceDeclarationNode.class))
		{
			return NameCategory.TYPE;
		}
		// *** After the "@" sign in an annotation (§9.7)
		if (hasAncestry(node, UnparameterizedTypeNode.class, AnnotationNode.class))
		{
			return NameCategory.TYPE;
		}
		// *** As a Type (or the part of a Type that remains after all brackets are deleted) in any of the following
		// contexts:
		// TODO: can we just replace all of this with hasAncestry(node, TypeNode.class) ?
		// * In a field declaration (§8.3, §9.3)
		if (hasAncestry(node, TypeNode.class, VariableDeclaratorNode.class, VariableDeclaratorListNode.class,
				FieldDeclarationNode.class))
		{
			return NameCategory.TYPE;
		}
		// * As the result type of a method (§8.4, §9.4)
		if (hasAncestry(node, TypeNode.class, MethodDeclarationNode.class))
		{
			return NameCategory.TYPE;
		}
		// * As the type of a formal parameter of a method or constructor (§8.4.1, §8.8.1, §9.4)
		if (hasAncestry(node, TypeNode.class, VariableNode.class, MethodDeclarationNode.class) ||
				hasAncestry(node, TypeNode.class, VariableNode.class, ConstructorDeclarationNode.class) ||
				hasAncestry(node, TypeNode.class, VariableNode.class, VariableListNode.class, MethodDeclarationNode.class) ||
				hasAncestry(node, TypeNode.class, VariableNode.class, VariableListNode.class, ConstructorDeclarationNode.class))
		{
			return NameCategory.TYPE;
		}
		// * As the type of an exception that can be thrown by a method or constructor (§8.4.6, §8.8.5, §9.4)
		if (hasAncestry(node, UnparameterizedTypeNode.class, UnparameterizedTypeListNode.class, MethodDeclarationNode.class) ||
				hasAncestry(node, UnparameterizedTypeNode.class, UnparameterizedTypeListNode.class, ConstructorDeclarationNode.class))
		{
			return NameCategory.TYPE;
		}
		// * As the type of a local variable (§14.4)
		if (hasAncestry(node, TypeNode.class, VariableDeclaratorNode.class, VariableDeclaratorListNode.class, VariableDeclarationNode.class))
		{
			return NameCategory.TYPE;
		}
		// * As the type of an exception parameter in a catch clause of a try statement (§14.20)
		if (hasAncestry(node, TypeNode.class, VariableNode.class, CatchNode.class))
		{
			return NameCategory.TYPE;
		}
		// * As the type in a class literal (§15.8.2)
		if (hasAncestry(node, LiteralizableTypeNode.class, ClassLiteralNode.class))
		{
			return NameCategory.TYPE;
		}
		// * As the qualifying type of a qualified this expression (§15.8.4).
		if (hasAncestry(node, UnparameterizedTypeNode.class, ThisNode.class))
		{
			return NameCategory.TYPE;
		}
		// * As the class type which is to be instantiated in an unqualified class instance creation expression (§15.9)
		// * As the direct superclass or direct superinterface of an anonymous class (§15.9.5) which is to be
		//   instantiated in an unqualified class instance creation expression (§15.9)
		// (this check covers both of the above cases)
		if (hasAncestry(node, DeclaredTypeNode.class, UnqualifiedClassInstantiationNode.class))
		{
			return NameCategory.TYPE;
		}
		// * As the element type of an array to be created in an array creation expression (§15.10)
		if (hasAncestry(node, BaseTypeNode.class, ArrayCreationNode.class))
		{
			return NameCategory.TYPE;
		}
		// * As the qualifying type of field access using the keyword super (§15.11.2)
		if (hasAncestry(node, UnparameterizedTypeNode.class, SuperFieldAccessNode.class))
		{
			return NameCategory.TYPE;
		}
		// * As the qualifying type of a method invocation using the keyword super (§15.12)
		if (hasAncestry(node, UnparameterizedTypeNode.class, SuperMethodInvocationNode.class))
		{
			return NameCategory.TYPE;
		}
		// * As the type mentioned in the cast operator of a cast expression (§15.16)
		if (hasAncestry(node, TypeNode.class, TypeCastNode.class))
		{
			return NameCategory.TYPE;
		}
		// * As the type that follows the instanceof relational operator (§15.20.2)
		if (hasAncestry(node, TypeNode.class, InstanceOfNode.class))
		{
			return NameCategory.TYPE;
		}
		
		// ***** A name is syntactically classified as an ExpressionName in these contexts:
		// TODO: wouldn't it be legal to just claim that all names with FieldAccessByNameNode as parents are expression
		// names?
		// *** As the qualifying expression in a qualified superclass constructor invocation (§8.8.7.1)
		if (hasAncestry(node, FieldAccessByNameNode.class, SuperclassConstructorInvocationNode.class))
		{
			return NameCategory.EXPRESSION;
		}
		// *** As the qualifying expression in a qualified class instance creation expression (§15.9)
		if (hasAncestry(node, FieldAccessByNameNode.class, QualifiedClassInstantiationNode.class))
		{
			return NameCategory.EXPRESSION;
		}
		// TODO: assign more categories

		throw new IllegalStateException("Could not find a name categorization for " + node.getNameString()
				+ (node.getStartLocation() == null ? "" : " at " + node.getStartLocation()));
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
			if (!c.isAssignableFrom(node.getClass()))
				return false;
		}
		return true;
	}
}
