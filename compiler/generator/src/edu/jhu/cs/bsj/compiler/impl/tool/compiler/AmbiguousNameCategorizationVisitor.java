package edu.jhu.cs.bsj.compiler.impl.tool.compiler;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeOperation;
import edu.jhu.cs.bsj.compiler.ast.NameCategory;
import edu.jhu.cs.bsj.compiler.ast.node.AnnotationBodyNode;
import edu.jhu.cs.bsj.compiler.ast.node.AnonymousClassBodyNode;
import edu.jhu.cs.bsj.compiler.ast.node.BlockStatementListNode;
import edu.jhu.cs.bsj.compiler.ast.node.BlockStatementNode;
import edu.jhu.cs.bsj.compiler.ast.node.CatchNode;
import edu.jhu.cs.bsj.compiler.ast.node.ClassBodyNode;
import edu.jhu.cs.bsj.compiler.ast.node.ConstructorDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.EnhancedForLoopNode;
import edu.jhu.cs.bsj.compiler.ast.node.EnumBodyNode;
import edu.jhu.cs.bsj.compiler.ast.node.FieldDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.ForInitializerDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.ForLoopNode;
import edu.jhu.cs.bsj.compiler.ast.node.InterfaceBodyNode;
import edu.jhu.cs.bsj.compiler.ast.node.MethodDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.NameNode;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.QualifiedNameNode;
import edu.jhu.cs.bsj.compiler.ast.node.SimpleNameNode;
import edu.jhu.cs.bsj.compiler.ast.node.TypeBodyNode;
import edu.jhu.cs.bsj.compiler.ast.node.VariableDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.VariableDeclaratorListNode;
import edu.jhu.cs.bsj.compiler.ast.node.VariableDeclaratorNode;
import edu.jhu.cs.bsj.compiler.ast.node.VariableNode;
import edu.jhu.cs.bsj.compiler.ast.util.BsjDefaultNodeOperation;
import edu.jhu.cs.bsj.compiler.ast.util.BsjTypedNodeNoOpVisitor;

/**
 * This visitor disambiguates AST nodes which represent ambiguous names (as defined by &#xA7;6.5 of the JLS). After the
 * initial name categorization, this visitor is used to assign more specific categories to ambiguous names, implementing
 * the rules specified in JLS &#xA7;6.5.2. Disambiguation of other types of names is not handled by this class.
 * 
 * @author Zachary Palmer
 */
public class AmbiguousNameCategorizationVisitor extends BsjTypedNodeNoOpVisitor
{
	/** The logger for this object. */
	private Logger LOGGER = Logger.getLogger(this.getClass());

	@Override
	public void visitNameNodeStop(NameNode node)
	{
		// This method only deals with ambiguous names.
		if (node.getCategory() != NameCategory.AMBIGUOUS)
			return;

		if (LOGGER.isTraceEnabled())
		{
			LOGGER.trace("Disambiguating " + node.getNameString() + " at " + node.getStartLocation());
		}

		// We handle an ambiguous name based partially on whether or not it is qualified
		if (node instanceof SimpleNameNode)
		{
			disambiguateSimpleName((SimpleNameNode) node);
		} else if (node instanceof QualifiedNameNode)
		{
			disambiguateQualifiedName((QualifiedNameNode) node);
		} else
		{
			throw new IllegalStateException("Unknown type of NameNode: " + node.getClass().getName());
		}
	}

	/**
	 * Performs disambiguation for a simple name.
	 * 
	 * @param node The ambiguous simple name to handle.
	 */
	private void disambiguateSimpleName(SimpleNameNode node)
	{
		// ***** If the Identifier appears within the scope (§6.3) of a local variable declaration (§14.4) or parameter
		// declaration (§8.4.1, §8.8.1, §14.20) or field declaration (§8.3) with that name, then the AmbiguousName
		// is reclassified as an ExpressionName.
		if (inExpressionNameScope(node, node.getNameString()))
		{
			if (LOGGER.isTraceEnabled())
			{
				LOGGER.trace(node.getNameString()
						+ " is in the scope of a local variable, parameter, or field; therefore an ExpressionName");
			}
			node.assertCategory(NameCategory.EXPRESSION);
			return;
		}

		// TODO Other rules
	}

	/**
	 * Performs disambiguation for a qualified name.
	 * 
	 * @param node The ambiguous qualified name to handle.
	 */
	private void disambiguateQualifiedName(QualifiedNameNode node)
	{
		// TODO Qualified name rules
	}

	/**
	 * Determines whether or not the specified node is in the scope of a local variable, field, or parameter declaration
	 * with the specified name.
	 * 
	 * @param node The node to check.
	 * @param name The name in question.
	 * @return <code>true</code> if the given node is within the scope of an expression-named declaration of that name;
	 *         <code>false</code> otherwise.
	 */
	private boolean inExpressionNameScope(Node node, String name)
	{
		// First, we'll get the ancestry of the node
		List<Node> ancestry = new ArrayList<Node>();
		for (Node iNode = node; iNode != null; iNode = iNode.getParent())
		{
			ancestry.add(iNode);
		}

		// Now we look at each node in turn as we scale the hierarchy and deal with it. (Skip the node itself, as it is
		// not in scope of its own declarations.)
		for (int i = 1; i < ancestry.size(); i++)
		{
			Node ancestor = ancestry.get(i);
			BsjNodeOperation<List<Node>, Boolean> operation = new ExpressionNameScopeCheckingOperation(name);
			if (ancestor.executeOperation(operation, ancestry.subList(0, i))) // sublist does not include this ancestor
			{
				return true;
			}
		}

		// We didn't find an appropriately-scoped expression name declaration.
		return false;
	}

	/**
	 * A class used to organize the different types of local variable checks performed by expression name scoping. It
	 * accepts a list of the descendant chain which leads to the node for which we are doing the search and returns a
	 * boolean indicating whether or not the executed node has access to scope which matches the requested name and
	 * defines an expression name.
	 * 
	 * @author Zachary Palmer
	 */
	// TODO: change to a Node return type, returning the node which actually contains the definition?
	private static class ExpressionNameScopeCheckingOperation extends BsjDefaultNodeOperation<List<Node>, Boolean>
	{
		/** The name we are trying to match. */
		private String name;

		public ExpressionNameScopeCheckingOperation(String name)
		{
			super();
			this.name = name;
		}

		@Override
		public Boolean executeDefault(Node node, List<Node> p)
		{
			// By default, we have not found what we're seeking.
			return false;
		}

		/**
		 * Checks a variable declarator to see if the requested node is inside of the initializer.
		 */
		@Override
		public Boolean executeVariableDeclaratorNode(VariableDeclaratorNode node, List<Node> p)
		{
			Node prior = p.get(p.size() - 1);
			if (node.getInitializer().equals(prior))
			{
				// We're inside of a variable declarator's initializer. Does its name match ours?
				if (node.getName().getIdentifier().equals(name))
				{
					// We found it! (This is something insane, like "int x = (x=2)*2;".)
					return true;
				}
			}
			return false;
		}

		/**
		 * Checks a variable declarator list to see if the requested node is covered by a prior declarator.
		 */
		@Override
		public Boolean executeVariableDeclaratorListNode(VariableDeclaratorListNode node, List<Node> p)
		{
			// Is the prior node covered by a previous variable declarator in this list? (Such as "int x = 5, y = x;".)
			Node prior = p.get(p.size() - 1);
			node = (VariableDeclaratorListNode) prior.getParent();
			int index = node.indexOf(prior);
			while (index > 0)
			{
				index--;
				VariableDeclaratorNode otherDeclarator = node.get(index);
				if (otherDeclarator.getName().getIdentifier().equals(name))
				{
					// Found one
					return true;
				}
			}
			return false;
		}

		/**
		 * Checks a block statement list to see if any variable declarations before the requested node produce a scope
		 * with the given name.
		 */
		@Override
		public Boolean executeBlockStatementListNode(BlockStatementListNode node, List<Node> p)
		{
			// Find the prior node
			BlockStatementNode blockStatementNode = (BlockStatementNode) p.get(p.size() - 1);
			// Get its index in the list
			int index = node.indexOf(blockStatementNode);
			// Look at all of the nodes before it - are any of them local variable declarations?
			while (index > 0)
			{
				index--;
				if (node.get(index) instanceof VariableDeclarationNode)
				{
					// Does this local variable declaration cover the name?
					VariableDeclarationNode variableDeclarationNode = (VariableDeclarationNode) node.get(index);
					for (VariableDeclaratorNode variableDeclaratorNode : variableDeclarationNode.getDeclarators())
					{
						if (variableDeclaratorNode.getName().getIdentifier().equals(name))
						{
							// We found something in a parent block with the name we want.
							return true;
						}
					}
				}
			}
			return false;
		}

		/**
		 * Checks a for loop to see if any variable declarations it might have apply to the requested node with the
		 * given name.
		 */
		@Override
		public Boolean executeForLoopNode(ForLoopNode node, List<Node> p)
		{
			// This for loop isn't worth anything to us if it doesn't declare some variables
			if (!(node.getInitializer() instanceof ForInitializerDeclarationNode))
			{
				return false;
			}

			ForInitializerDeclarationNode initializer = (ForInitializerDeclarationNode) node.getInitializer();
			// How we proceed depends on how we got to the for loop.
			int index;
			if (p.get(p.size() - 1) instanceof ForInitializerDeclarationNode)
			{
				// If we're inside of an initializer, only the preceeding declarators are fair game.
				// We need to get the variable declarator from which we came (assuming we're at least that
				// deep). The order of the list, due to the AST type hierarchy, will be:
				// ..., VariableDeclaratorNode, VariableDeclaratorListNode, VariableDeclarationNode, ForInit
				if (p.size() >= 4)
				{
					index = initializer.getDeclaration().getDeclarators().indexOf(p.get(p.size() - 4));
				} else
				{
					// Apparently, this node is the declarator itself or something. None of the declarations
					// are in scope.
					index = 0;
				}
			} else
			{
				// We're in some other part of the for loop; all declarators are fair game
				index = initializer.getDeclaration().getDeclarators().size();
			}

			// Check each valid declarator to see if it's the one we want
			while (index > 0)
			{
				index--;
				VariableDeclaratorNode variableDeclaratorNode = initializer.getDeclaration().getDeclarators().get(index);
				if (variableDeclaratorNode.getName().getIdentifier().equals(name))
				{
					// We found a variable declaration in the for loop that covers our node
					return true;
				}
			}

			return false;
		}

		/**
		 * Checks an enhanced for loop to see if its parameter provides the scope we want.
		 */
		@Override
		public Boolean executeEnhancedForLoopNode(EnhancedForLoopNode node, List<Node> p)
		{
			// The enhanced for loop's variable's scope is only the statement of the loop
			if (p.get(p.size() - 1).equals(node.getStatement()))
			{
				// We're inside of the enhanced for loop's statement, so the parameter it contains is applied to us.
				if (node.getVariable().getIdentifier().getIdentifier().equals(name))
				{
					// And it turns out that this is the node that matches our name!
					return true;
				}
			}

			return false;
		}

		/**
		 * Checks a catch block to determine if its parameter provides the scope we want.
		 */
		@Override
		public Boolean executeCatchNode(CatchNode node, List<Node> p)
		{
			if (p.get(p.size() - 1).equals(node.getBlock()))
			{
				if (node.getParameter().getIdentifier().getIdentifier().equals(name))
				{
					// The catch block's argument applies to this name
					return true;
				}
			}
			return false;
		}

		/**
		 * Checks this type body for field declarations which provide the scope we want.
		 */
		@Override
		public Boolean executeAnnotationBodyNode(AnnotationBodyNode node, List<Node> p)
		{
			return checkTypeBodyNode(node, p);
		}

		/**
		 * Checks this type body for field declarations which provide the scope we want.
		 */
		@Override
		public Boolean executeAnonymousClassBodyNode(AnonymousClassBodyNode node, List<Node> p)
		{
			return checkTypeBodyNode(node, p);
		}

		/**
		 * Checks this type body for field declarations which provide the scope we want.
		 */
		@Override
		public Boolean executeClassBodyNode(ClassBodyNode node, List<Node> p)
		{
			return checkTypeBodyNode(node, p);
		}

		/**
		 * Checks this type body for field declarations which provide the scope we want.
		 */
		@Override
		public Boolean executeEnumBodyNode(EnumBodyNode node, List<Node> p)
		{
			return checkTypeBodyNode(node, p);
		}

		/**
		 * Checks this type body for field declarations which provide the scope we want.
		 */
		@Override
		public Boolean executeInterfaceBodyNode(InterfaceBodyNode node, List<Node> p)
		{
			return checkTypeBodyNode(node, p);
		}

		/**
		 * Checks this type body for field declarations which provide the scope we want.
		 */
		private Boolean checkTypeBodyNode(TypeBodyNode node, List<Node> p)
		{
			for (Node member : node.getMembers())
			{
				if (member instanceof FieldDeclarationNode)
				{
					FieldDeclarationNode fieldDeclarationNode = (FieldDeclarationNode) member;
					for (VariableDeclaratorNode declarator : fieldDeclarationNode.getDeclarators())
					{
						if (declarator.getName().getIdentifier().equals(name))
						{
							return true;
						}
					}
				}
			}
			return false;
		}

		/**
		 * Checks this method declaration's parameters to see if they provide the scope we want.
		 */
		@Override
		public Boolean executeMethodDeclarationNode(MethodDeclarationNode node, List<Node> p)
		{
			Node prior = p.get(p.size() - 1);
			// Only count those parameters if the request comes from inside of the body of the method
			if (node.getBody().equals(prior))
			{
				for (VariableNode var : node.getParameters())
				{
					if (var.getIdentifier().getIdentifier().equals(name))
					{
						return true;
					}
				}
				if (node.getVarargParameter() != null
						&& node.getVarargParameter().getIdentifier().getIdentifier().equals(name))
				{
					return true;
				}
			}
			return false;
		}

		@Override
		public Boolean executeConstructorDeclarationNode(ConstructorDeclarationNode node, List<Node> p)
		{
			Node prior = p.get(p.size() - 1);
			// Only count those parameters if the request comes from inside of the body of the method
			if (node.getBody().equals(prior))
			{
				for (VariableNode var : node.getParameters())
				{
					if (var.getIdentifier().getIdentifier().equals(name))
					{
						return true;
					}
				}
				if (node.getVarargParameter() != null
						&& node.getVarargParameter().getIdentifier().getIdentifier().equals(name))
				{
					return true;
				}
			}
			return false;
		}
	}
}
