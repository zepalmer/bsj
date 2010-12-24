package edu.jhu.cs.bsj.compiler.tool.typechecker;

import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.lang.BsjModelingFactory;
import edu.jhu.cs.bsj.compiler.lang.type.BsjNoType;
import edu.jhu.cs.bsj.compiler.lang.type.BsjType;

/**
 * Used to calculate the type of AST nodes. Only expressions have normal Java types (such as {@link String} or
 * <tt>int</tt>). If the AST node legitimately has no type, an appropriate pseudo-type (such as {@link BsjNoType}) is
 * returned. If the AST node has no type due to a type calculation failure, an error type is returned.  Some methods on
 * this class permit the retrieval of additional data, such as the parsing results for code literals.
 * <p/>
 * Implementations of this interface may cache results in order to improve performance.  As a result, a typechecker
 * becomes invalid if the underlying AST changes.  Implementations may provide fail-fast behavior, but calls should not
 * rely on this behavior in order to obtain consistent results.
 * 
 * @author Zachary Palmer
 * 
 */
public interface BsjTypechecker
{

	/**
	 * Calculates the type for a provided AST node.
	 * @param node The node to use.
	 * @return The resulting type.
	 * @throws TypecheckingException If no type could be established for the provided AST node.
	 */
	public BsjType getType(Node node) throws TypecheckingException;

	/**
	 * Calculates a typechecking result for the provided AST node.
	 * 
	 * @param node The node to use.
	 * @return The typechecking results for this node.
     * @throws TypecheckingException If no type could be established for the provided AST node.
	 */
	public TypecheckerResult typecheck(Node node) throws TypecheckingException;

	/**
	 * Calculates a typechecking result for the provided AST node.  This method is useful if the node which should be
	 * typechecked is not yet in the AST but should be typechecked as if it were.
	 * @param node The node to typecheck.
	 * @param namespaceNode The node to use to build namespaces during typechecking.
	 * @return The typechecking results for this node.
     * @throws TypecheckingException If no type could be established for the provided AST node.
	 */
	public TypecheckerResult typecheck(Node node, Node namespaceNode) throws TypecheckingException;

	/**
	 * Retrieves a modeling factory which can be used to create language modeling elements for this typechecker.
	 * @return This typechecker's modeling factory.
	 */
	public BsjModelingFactory getModelingFactory();
}