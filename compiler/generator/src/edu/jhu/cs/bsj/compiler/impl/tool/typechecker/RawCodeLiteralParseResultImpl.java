package edu.jhu.cs.bsj.compiler.impl.tool.typechecker;

import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.lang.value.SelectionBag;
import edu.jhu.cs.bsj.compiler.tool.typechecker.RawCodeLiteralParseResult;

/**
 * Represents the result of parsing a code literal with each of the defined parse rules.
 * @author Zachary Palmer
 */
public class RawCodeLiteralParseResultImpl implements RawCodeLiteralParseResult
{
	// TODO: store diagnostic information for parses, both successful and failed
	
	/** The selection bag which was obtained by parsing the code literal. */
	private SelectionBag<Node> selectionBag;

	public RawCodeLiteralParseResultImpl(SelectionBag<Node> selectionBag)
	{
		super();
		this.selectionBag = selectionBag;
	}

	@Override
	public SelectionBag<Node> getSelectionBag()
	{
		return selectionBag;
	}
}
