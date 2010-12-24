package edu.jhu.cs.bsj.compiler.impl.tool.typechecker;

import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.lang.BsjModelingFactory;
import edu.jhu.cs.bsj.compiler.lang.type.BsjNoType;
import edu.jhu.cs.bsj.compiler.lang.type.BsjType;
import edu.jhu.cs.bsj.compiler.tool.parser.BsjParser;
import edu.jhu.cs.bsj.compiler.tool.typechecker.BsjTypechecker;
import edu.jhu.cs.bsj.compiler.tool.typechecker.TypecheckerResult;
import edu.jhu.cs.bsj.compiler.tool.typechecker.TypecheckingException;

/**
 * This module performs type checking as per the Java Language Specification v3. It also includes the modifications
 * indicated in the Backstage Java Language Specification, specifically with regard to code literals and parse mapping.
 * It relies on some underlying caching mechanisms (such as through the namespace builder) and so should not be reused
 * if the AST changes.
 * 
 * @author Zachary Palmer
 */
public class TypecheckerImpl implements BsjTypechecker
{
	/** The manager which is overseeing this typechecker. */
	private TypecheckerManager manager;
	/** The parser which should be used when typechecking code literals. */
	private BsjParser parser;

	/** The operation used to calculate type results. */
	private TypeEvaluationOperation typeEvaluationOperation;
	
	public TypecheckerImpl(TypecheckerManager manager, BsjParser parser)
	{
		super();
		this.manager = manager;
		this.parser = parser;

		this.typeEvaluationOperation = new TypeEvaluationOperation(this.manager, this.parser);
	}

	/**
	 * Calculates the type for a provided AST node. Only expressions have normal Java types (such as {@link String} or
	 * <tt>int</tt>). If the AST node legitimately has no type, an appropriate pseudo-type (such as {@link BsjNoType})
	 * is returned. If the AST node has no type due to a type calculation failure, an error type is returned.
	 */
	@Override
	public BsjType getType(Node node) throws TypecheckingException
	{
		return typecheck(node, new TypecheckerEnvironment()).getType();
	}
	
	@Override
	public TypecheckerResult typecheck(Node node) throws TypecheckingException
	{
		return typecheck(node, new TypecheckerEnvironment());
	}

	@Override
	public TypecheckerResult typecheck(Node node, Node namespaceNode) throws TypecheckingException
	{
		return typecheck(node, new TypecheckerEnvironment().deriveWithNamespaceNode(namespaceNode));
	}
	
	private TypecheckerResult typecheck(Node node, TypecheckerEnvironment env) throws TypecheckingException
	{
		return node.executeOperation(this.typeEvaluationOperation, env);
	}

	@Override
	public BsjModelingFactory getModelingFactory()
	{
		return this.manager.getModelingFactory();
	}
}
