package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.parsemap;

import java.util.Map;

import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.meta.RawCodeLiteralNode;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.TypecheckerManager;
import edu.jhu.cs.bsj.compiler.tool.parser.BsjParser;

/**
 * An instance of this class represents a tool which can be used to evaluate the parse mapping for a specific AST node.
 * It relies on caching in some backing operations (such as the environment builder); as a result, it becomes invalid if
 * the underlying ASTs change.
 * 
 * @author Zachary Palmer
 */
public class ParseMapper
{
	/** The type-checking manager that this parse map manager should use to resolve node types. */
	private TypecheckerManager manager;
	/** The BSJ parser that this manager should use for parsing nodes. */
	private BsjParser parser;

	/** The calculation operation that is invoked to get results. */
	private ParseMapOperation parseMapOperation;

	/**
	 * Creates a new parse map manager.
	 */
	public ParseMapper(TypecheckerManager manager, BsjParser parser)
	{
		super();
		this.manager = manager;
		this.parser = parser;

		this.parseMapOperation = new ParseMapOperation(this.manager, this.parser);
	}

	public Map<RawCodeLiteralNode, ParseMapEntry> getParseMap(Node node)
	{
		// TODO: what is the correct default environment?
		return node.executeOperation(this.parseMapOperation, null);
	}
}
