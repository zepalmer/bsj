package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.parsemap;

import java.util.Set;

import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.parsemap.rule.ParseRule;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.api.BsjExplicitlyDeclaredType;

/**
 * Represents a single entry in a parse map.
 * @author Zachary Palmer
 */
public class ParseMapEntry
{
	/** The set of rules which correspond to this parse map entry. */
	private Set<? extends ParseRule> rules;
	/** The in-context type for this parse map entry. */
	private BsjExplicitlyDeclaredType inContextType;
	
	public ParseMapEntry(Set<? extends ParseRule> rules, BsjExplicitlyDeclaredType inContextType)
	{
		super();
		this.rules = rules;
		this.inContextType = inContextType;
	}

	public Set<? extends ParseRule> getRules()
	{
		return rules;
	}

	public BsjExplicitlyDeclaredType getInContextType()
	{
		return inContextType;
	}
}
