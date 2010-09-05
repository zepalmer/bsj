package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.parsemap;

import java.util.Set;

import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.parsemap.rule.ParseRuleExecution;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.api.BsjType;

/**
 * Represents a single entry in a parse map.
 * @author Zachary Palmer
 * @param <T> The least upper bound on the type of the node produced by this parse map entry.
 */
public class ParseMapEntry
{
	/** The set of rules which correspond to this parse map entry. */
	private Set<ParseRuleExecution<?>> rules;
	/** The in-context type for this parse map entry. */
	private BsjType inContextType;
	
	public ParseMapEntry(Set<ParseRuleExecution<?>> rules, BsjType inContextType)
	{
		super();
		this.rules = rules;
		this.inContextType = inContextType;
	}

	public Set<ParseRuleExecution<?>> getRules()
	{
		return rules;
	}

	public BsjType getInContextType()
	{
		return inContextType;
	}
}
