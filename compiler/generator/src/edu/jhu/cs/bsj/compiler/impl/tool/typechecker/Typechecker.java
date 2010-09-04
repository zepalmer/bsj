package edu.jhu.cs.bsj.compiler.impl.tool.typechecker;

import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.api.BsjNoType;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.api.BsjType;

/**
 * This module performs type checking as per the Java Language Specification v3. It also includes the modifications
 * indicated in the Backstage Java Language Specification, specifically with regard to code literals and parse mapping.
 * It relies on some underlying caching mechanisms (such as through the namespace builder) and so should not be reused
 * if the AST changes.
 * 
 * @author Zachary Palmer
 */
public class Typechecker
{
	/** The manager which is overseeing this typechecker. */
	private TypecheckerManager manager;

	/** The operation used to calculate type results. */
	private TypeEvaluationOperation typeEvaluationOperation;

	public Typechecker(TypecheckerManager manager)
	{
		super();
		this.manager = manager;

		this.typeEvaluationOperation = new TypeEvaluationOperation(this.manager);
	}

	/**
	 * Calculates the type for a provided AST node. Only expressions have normal Java types (such as {@link String} or
	 * <tt>int</tt>). If the AST node legitimately has no type, an appropriate pseudo-type (such as {@link BsjNoType})
	 * is returned. If the AST node has no type due to a type calculation failure, an error type is returned.
	 */
	public BsjType getType(Node node)
	{
		return getType(node, new TypecheckerEnvironment());
	}

	public BsjType getType(Node node, TypecheckerEnvironment env)
	{
		return node.executeOperation(this.typeEvaluationOperation, env);
	}
}
