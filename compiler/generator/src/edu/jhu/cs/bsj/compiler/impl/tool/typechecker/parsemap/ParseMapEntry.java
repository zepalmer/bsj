package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.parsemap;

import java.util.Set;

import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.parsemap.rule.ParseRuleExecution;

/**
 * Represents a single entry in a parse map.
 * @author Zachary Palmer
 * @param <T> The least upper bound on the type of the node produced by this parse map entry.
 */
public class ParseMapEntry<T extends Node>
{
	/** The set of rules which correspond to this parse map entry. */
	private Set<? extends ParseRuleExecution<T>> rules;
	/** The in-context type for this parse map entry. */
	private Class<T> inContextType;
	
	public ParseMapEntry(Set<? extends ParseRuleExecution<T>> rules, Class<T> inContextType)
	{
		super();
		this.rules = rules;
		this.inContextType = inContextType;
	}

	public Set<? extends ParseRuleExecution<T>> getRules()
	{
		return rules;
	}

	public Class<T> getInContextType()
	{
		return inContextType;
	}
}
