package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.api;

import java.util.Collection;

import edu.jhu.cs.bsj.compiler.tool.parser.ParseRule;

/**
 * This error type is used to indicate the specific case in which an expression could not be typechecked because not
 * enough information is present to determine which code literal type is desired.
 * @author Zachary Palmer
 */
public interface BsjAmbiguousCodeLiteralErrorType extends BsjErrorType
{
	/**
	 * Retrieves a list of the parse rules which were valid for the ambiguous code literal.
	 */
	public Collection<? extends ParseRule<?>> getParseRules();
}
