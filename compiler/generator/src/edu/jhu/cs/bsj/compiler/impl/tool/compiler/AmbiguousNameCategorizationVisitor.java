package edu.jhu.cs.bsj.compiler.impl.tool.compiler;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import edu.jhu.cs.bsj.compiler.ast.NameCategory;
import edu.jhu.cs.bsj.compiler.ast.node.BlockStatementListNode;
import edu.jhu.cs.bsj.compiler.ast.node.BlockStatementNode;
import edu.jhu.cs.bsj.compiler.ast.node.CatchNode;
import edu.jhu.cs.bsj.compiler.ast.node.EnhancedForLoopNode;
import edu.jhu.cs.bsj.compiler.ast.node.ForInitializerDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.ForLoopNode;
import edu.jhu.cs.bsj.compiler.ast.node.NameNode;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.QualifiedNameNode;
import edu.jhu.cs.bsj.compiler.ast.node.SimpleNameNode;
import edu.jhu.cs.bsj.compiler.ast.node.VariableDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.VariableDeclaratorListNode;
import edu.jhu.cs.bsj.compiler.ast.node.VariableDeclaratorNode;
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
		if (inScopeOfLocalVariable(node, node.getNameString()) || inScopeOfParameter(node, node.getNameString())
				|| inScopeOfField(node, node.getNameString()))
		{
			if (LOGGER.isTraceEnabled())
			{
				LOGGER.trace(node.getNameString()
						+ " is in the scope of a local variable, parameter, or field; therefore an ExpressionName");
			}
			node.assertCategory(NameCategory.EXPRESSION);
			return;
		}

		// TODO Auto-generated method stub
	}

	/**
	 * Performs disambiguation for a qualified name.
	 * 
	 * @param node The ambiguous qualified name to handle.
	 */
	private void disambiguateQualifiedName(QualifiedNameNode node)
	{
		// TODO Auto-generated method stub
	}

	/**
	 * Determines whether or not the specified node is in the scope of a local variable with the provided name. In this
	 * method, the definition of "local variable" extends to catch block parameters and for loop variables.
	 * 
	 * @param node The node to check.
	 * @param name The name in question.
	 * @return <code>true</code> if the given node is within the scope of a local variable of that name;
	 *         <code>false</code> otherwise.
	 */
	private boolean inScopeOfLocalVariable(Node node, String name)
	{
		// First, let's see if we're inside of the initializer of a variable declarator. Variable declarators appear
		// only in local variables and fields.
		List<Node> list = new ArrayList<Node>();
		Node iNode = node; // used as an iterator
		while (iNode != null)
		{
			list.clear();
			VariableDeclaratorNode variableDeclaratorNode = iNode.getNearestAncestorOfType(
					VariableDeclaratorNode.class, list);
			if (variableDeclaratorNode != null
					&& variableDeclaratorNode.getInitializer().equals(list.get(list.size() - 1)))
			{
				// We're inside of a variable declarator. Does its name match ours?
				if (variableDeclaratorNode.getName().getIdentifier().equals(name))
				{
					// Yes. Is it inside of a local variable declaration?
					if (variableDeclaratorNode.getNearestAncestorOfType(VariableDeclarationNode.class) != null)
					{
						// We found it! (This is something insane, like "int x = (x=2)*2;".)
						return true;
					}
				}
				// Variable declarators show up inside of lists. Is one of the variable declarators to the left of this
				// one named what we want? (Such as "int x = 5, y = x;".)
				if (variableDeclaratorNode.getParent() instanceof VariableDeclaratorListNode)
				{
					VariableDeclaratorListNode variableDeclaratorListNode = (VariableDeclaratorListNode) variableDeclaratorNode.getParent();
					int index = variableDeclaratorListNode.indexOf(variableDeclaratorNode);
					while (index > 0)
					{
						index--;
						VariableDeclaratorNode otherDeclarator = variableDeclaratorListNode.get(index);
						if (otherDeclarator.getName().getIdentifier().equals(name))
						{
							// Found one
							return true;
						}
					}
				}
			}
			iNode = variableDeclaratorNode;
		}

		// So we're not in a variable initializer. Perhaps we're in a block of statements and that block has an
		// appropriate declarator?
		iNode = node;
		while (iNode != null)
		{
			list.clear();
			BlockStatementListNode blockStatementListNode = iNode.getNearestAncestorOfType(
					BlockStatementListNode.class, list);
			if (blockStatementListNode != null)
			{
				// Find our ancestor as the participant of the list
				BlockStatementNode blockStatementNode = (BlockStatementNode) list.get(list.size() - 1);
				// Get our ancestor's index
				int index = blockStatementListNode.indexOf(blockStatementNode);
				// Look at all of the nodes before us - are any of them local variable declarations?
				while (index > 0)
				{
					index--;
					if (blockStatementListNode.get(index) instanceof VariableDeclarationNode)
					{
						VariableDeclarationNode variableDeclarationNode = (VariableDeclarationNode) blockStatementListNode.get(index);
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
			}
			// If we didn't find a block statement list, this will end the loop. Otherwise, it searches the parents of
			// that block statement list (for nested blocks)
			iNode = blockStatementListNode;
		}

		// So it's not a traditional variable initializer at all. Perhaps it's in a basic for loop?
		iNode = node;
		while (iNode != null)
		{
			list.clear();
			ForLoopNode forLoopNode = iNode.getNearestAncestorOfType(ForLoopNode.class, list);
			// If this for-loop has a variable declaration as an initializer, it's worth examining
			if (forLoopNode != null && forLoopNode.getInitializer() instanceof ForInitializerDeclarationNode)
			{
				ForInitializerDeclarationNode initializer = (ForInitializerDeclarationNode) forLoopNode.getInitializer();
				// How we proceed depends on how we got to the for loop.
				int index;
				if (list.get(list.size() - 1) instanceof ForInitializerDeclarationNode)
				{
					// If we're inside of an initializer, only the preceeding declarators are fair game
					// We need to get the variable declarator from which we came (assuming we're at least that
					// deep). The order of the list, due to the AST type hierarchy, will be:
					// ..., VariableDeclaratorNode, VariableDeclaratorListNode, VariableDeclarationNode, ForInit
					if (list.size() >= 4)
					{
						index = initializer.getDeclaration().getDeclarators().indexOf(list.get(list.size() - 4));
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
			}
			iNode = forLoopNode;
		}
		
		// How about an enhanced for loop?
		iNode = node;
		while (iNode != null)
		{
			list.clear();
			EnhancedForLoopNode enhancedForLoopNode = iNode.getNearestAncestorOfType(EnhancedForLoopNode.class, list);
			if (enhancedForLoopNode != null)
			{
				// The enhanced for loop's variable's scope is only the statement of the loop
				if (list.get(list.size()-1).equals(enhancedForLoopNode.getStatement()))
				{
					// We're inside of the enhanced for loop's statement, so the parameter it contains is applied to us.
					if (enhancedForLoopNode.getVariable().getIdentifier().getIdentifier().equals(name))
					{
						// And it turns out that this is the node that matches our name!
						return true;
					}
				}
			}
			iNode = enhancedForLoopNode;
		}
		
		// How about a catch block?
		iNode = node;
		while (iNode != null)
		{
			list.clear();
			CatchNode catchNode = iNode.getNearestAncestorOfType(CatchNode.class, list);
			if (catchNode != null)
			{
				// The catch node's parameter applies only to the block of statements in the exception handler
				if (list.get(list.size()-1).equals(catchNode.getBlock()))
				{
					if (catchNode.getParameter().getIdentifier().getIdentifier().equals(name))
					{
						// The catch block's argument applies to this name
						return true;
					}
				}
			}
			iNode = catchNode;
		}

		// That's all the local variables we have - give up
		return false;
	}

	/**
	 * Determines whether or not the specified node is in the scope of a parameter with the provided name.
	 * 
	 * @param node The node to check.
	 * @param name The name in question.
	 * @return <code>true</code> if the given node is within the scope of a local variable of that name;
	 *         <code>false</code> otherwise.
	 */
	private boolean inScopeOfParameter(Node node, String name)
	{
		// TODO
		return false;
	}

	/**
	 * Determines whether or not the specified node is in the scope of a field with the provided name.
	 * 
	 * @param node The node to check.
	 * @param name The name in question.
	 * @return <code>true</code> if the given node is within the scope of a local variable of that name;
	 *         <code>false</code> otherwise.
	 */
	private boolean inScopeOfField(Node node, String name)
	{
		// TODO
		return false;
	}
}
