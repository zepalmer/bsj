package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.parsemap.rule;

import java.util.Set;

import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.api.BsjExplicitlyDeclaredType;

/**
 * This interface describes the behavior of a parse rule as specified in the BSJ Language Specification.  A parse rule
 * is an operation which is capable of receiving a sequence of tokens and producing an AST node.  Each parse rule is
 * associated with the set of AST node types that it may produce.
 * @author Zachary Palmer
 */
public interface ParseRuleExecutor
{
	/**
	 * Obtains the set of types that this parse rule produces.
	 * @return A set containing the types which may be produced by this parse rule.
	 */
	public Set<BsjExplicitlyDeclaredType> getTypes();
	
	/**
	 * Parses the provided sequence of tokens into an AST node.
	 * @param input The input tokens.
	 * @return The resulting AST node or <code>null</code> if the provided input is invalid for this parse rule.
	 */
	public Node parse(String input);
}
