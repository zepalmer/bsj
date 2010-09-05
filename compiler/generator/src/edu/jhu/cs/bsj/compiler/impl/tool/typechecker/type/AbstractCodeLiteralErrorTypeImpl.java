package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type;

import java.util.Set;

import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.TypecheckerManager;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.api.BsjAmbiguousCodeLiteralErrorType;
import edu.jhu.cs.bsj.compiler.tool.parser.ParseRule;

public class AbstractCodeLiteralErrorTypeImpl extends ErrorTypeImpl implements BsjAmbiguousCodeLiteralErrorType
{
	private Set<ParseRule<?>> rules;
	
	public AbstractCodeLiteralErrorTypeImpl(TypecheckerManager manager, Set<ParseRule<?>> rules)
	{
		super(manager);
		this.rules = rules;
	}

	@Override
	public Set<ParseRule<?>> getParseRules()
	{
		return this.rules;
	}
}
