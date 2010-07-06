package edu.jhu.cs.bsj.compiler.ast.node.list.knowledge;

/**
 * Represents a list algebra closure rule.
 * @author Zachary Palmer
 */
public interface ClosureRule
{
	/**
	 * Retrieves a textual representation of this closure rule.  This representation will be an approximation of the
	 * language specifcation notation using Unicode characters.
	 * @return A textual representation of this closure rule.
	 */
	public String getDescription();
}
