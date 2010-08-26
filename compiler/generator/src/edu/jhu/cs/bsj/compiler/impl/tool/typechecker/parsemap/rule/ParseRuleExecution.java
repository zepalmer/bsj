package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.parsemap.rule;

import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.meta.RawCodeLiteralNode;
import edu.jhu.cs.bsj.compiler.tool.parser.ParseRule;

/**
 * Represents the successful execution of a single parse rule on a single raw code literal. This object represents both
 * the parse rule in question as well as the node which was created by the execution of that parse rule.
 * 
 * @author Zachary Palmer
 * @param <T> The least upper bound on the type of the produced node.
 */
public class ParseRuleExecution<T extends Node>
{
	/** The code literal to which this rule applies. */
	private RawCodeLiteralNode node;
	/** The parse rule which was executed on the code literal's body. */
	private ParseRule<T> parseRule;
	/** The node which was produced from the parse. */
	private T result;

	public ParseRuleExecution(RawCodeLiteralNode node, ParseRule<T> parseRule, T result)
	{
		super();
		this.node = node;
		this.parseRule = parseRule;
		this.result = result;
	}

	public RawCodeLiteralNode getNode()
	{
		return node;
	}

	public ParseRule<T> getParseRule()
	{
		return parseRule;
	}

	public T getResult()
	{
		return result;
	}
}
