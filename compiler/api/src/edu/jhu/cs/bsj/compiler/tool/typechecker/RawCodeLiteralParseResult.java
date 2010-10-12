package edu.jhu.cs.bsj.compiler.tool.typechecker;

import edu.jhu.cs.bsj.compiler.ast.NodeUnion;
import edu.jhu.cs.bsj.compiler.lang.value.SelectionBag;

/**
 * Represents the result of a single raw code literal parse.
 * @author Zachary Palmer
 */
public interface RawCodeLiteralParseResult
{
	/**
	 * Retrieves the selection bag of values obtained from parsing the raw code literal.
	 * @return The selection bag produced from the code literal.
	 */
	public SelectionBag<NodeUnion<?>> getSelectionBag();
}