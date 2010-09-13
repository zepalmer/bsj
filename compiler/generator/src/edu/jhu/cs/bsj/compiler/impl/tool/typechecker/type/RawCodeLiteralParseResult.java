package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type;

import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.value.api.SelectionBag;

/**
 * Represents the result of parsing a code literal with each of the defined parse rules.
 * @author Zachary Palmer
 */
public class RawCodeLiteralParseResult
{
	// TODO: store diagnostic information for parses, both successful and failed
	
	/** The selection bag which was obtained by parsing the code literal. */
	private SelectionBag<Node> selectionBag;

	public RawCodeLiteralParseResult(SelectionBag<Node> selectionBag)
	{
		super();
		this.selectionBag = selectionBag;
	}

	public SelectionBag<Node> getSelectionBag()
	{
		return selectionBag;
	}
}
