package edu.jhu.cs.bsj.compiler.impl.ast.node.list.knowledge.closure;

import edu.jhu.cs.bsj.compiler.ast.node.list.knowledge.ClosureRule;

/**
 * This abstract class contains functionality common to the various closure rules in this system.
 * 
 * @author Zachary Palmer
 */
public abstract class AbstractClosureRule implements ClosureRule
{
	/** The description for this rule. */
	private final String description;

	protected AbstractClosureRule(String description)
	{
		this.description = description;
	}

	/**
	 * Retrieves the description of this closure rule.
	 * 
	 * @return A string describing this closure rule.
	 */
	public String getDescription()
	{
		return this.description;
	}
	
	public String toString()
	{
		return getDescription();
	}
}
