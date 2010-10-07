package edu.jhu.cs.bsj.compiler.metaprogram;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.node.CompilationUnitNode;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.PackageNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramAnchorNode;
import edu.jhu.cs.bsj.compiler.diagnostic.user.BsjUserDiagnosticListener;
import edu.jhu.cs.bsj.compiler.tool.typechecker.BsjTypecheckerFactory;

/**
 * Represents the execution context for a metaprogram. Instances of this interface are provided to metaprograms to allow
 * them access to their environments, allowing modification of AST nodes in their own compilation unit and other
 * relevant facilities.
 * 
 * @author Zachary Palmer
 * @param <T> The type of metaprogram anchor node held by this context.
 * @param <U> The type of node which can be used to replace the anchor node held by this context.
 */
public interface Context<T extends MetaprogramAnchorNode<U>, U extends Node>
{
	/**
	 * Retrieves the anchor node for this metaprogram context. In a BSJ AST, all metaprograms exist within an anchor
	 * node (or have no parent). This method allows the metaprogram which received this context to find its own anchor,
	 * allowing it to use its location within the AST for semantic meaning.
	 * 
	 * @return The anchor node for this metaprogram context.
	 */
	public T getAnchor();

	/**
	 * Retrieves a factory to be used to create nodes in this context.
	 * 
	 * @return The node factory to use.
	 */
	public BsjNodeFactory getFactory();
	
	/**
	 * Retrieves a typechecker factory which can be used to create typecheckers for the metaprogram.
	 * @return A factory for typechecker creation.
	 */
	public BsjTypecheckerFactory getTypecheckerFactory();

	/**
	 * Retrieves the listener for user diagnostics. Metaprograms should create and provide diagnostic objects to this
	 * interface in order to report events to the compiler. The compiler will then report those same events in a
	 * translated form to its programmatic caller, resulting in (for example) these messages being reported to the
	 * compiler's CLI user.
	 * 
	 * @return The listener to which a metaprogram should report diagnostics.
	 */
	public BsjUserDiagnosticListener getDiagnosticListener();

	/**
	 * Retrieves the compilation unit loader which metaprograms should use to load compilation units into the AST. This
	 * module loads compilation unit resources from the file manager which is backing compilation. Metaprograms which
	 * wish to create entirely new compilation units should use
	 * {@link PackageNode#addCompilationUnit(CompilationUnitNode)} instead.
	 */
	public CompilationUnitLoader getCompilationUnitLoader();

	/**
	 * Retrieves the AST node which is currently slated to be used as a replacement for the anchor of this metaprogram
	 * when the metaprogram completes.
	 * 
	 * @return The current replacement node or <code>null</code> if no replacement will take place.
	 */
	public U getReplacement();

	/**
	 * Changes the AST node which is currently slated to be used as a replacement for the anchor of this metaprogram
	 * when the metaprogram completes. If the anchor should be left in its place, a <code>null</code> replacement should
	 * be specified.
	 * 
	 * @param replacement The new replacement node or <code>null</code> to skip replacement.
	 */
	public void setReplacement(U replacement);
}
