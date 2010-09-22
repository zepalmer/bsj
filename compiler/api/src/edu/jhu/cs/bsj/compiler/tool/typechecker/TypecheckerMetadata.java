package edu.jhu.cs.bsj.compiler.tool.typechecker;

import java.util.Set;

import edu.jhu.cs.bsj.compiler.ast.node.meta.RawCodeLiteralNode;
import edu.jhu.cs.bsj.compiler.lang.type.BsjType;

/**
 * Represents metadata gathered during a typechecking operation.
 * @author Zachary Palmer
 */
public interface TypecheckerMetadata
{
	/**
	 * Retrieves the type in context for the specified code literal.
	 * 
	 * @param rawCodeLiteralNode The code literal in question.
	 * @return The type in context for this code literal or <code>null</code> if no contextual type was established.
	 */
	public BsjType getInContextType(RawCodeLiteralNode rawCodeLiteralNode);

	/**
	 * Retrieves the result of parsing a specified code literal.
	 * 
	 * @param rawCodeLiteralNode The code literal in question.
	 * @return The parse results for that code literal.
	 */
	public RawCodeLiteralParseResult getParseResult(RawCodeLiteralNode rawCodeLiteralNode);

	/**
	 * Retrieves the set of raw code literals which do not have any assigned context.  This may occur if, for instance,
	 * a code literal is typechecked by itself or when it is used as a method argument.
	 * @return The set of code literals which lack sufficient context to parse.
	 */
	public Set<RawCodeLiteralNode> getRawCodeLiteralsLackingContext();

}