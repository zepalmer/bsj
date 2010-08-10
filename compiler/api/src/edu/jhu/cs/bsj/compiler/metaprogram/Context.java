package edu.jhu.cs.bsj.compiler.metaprogram;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.node.CompilationUnitNode;
import edu.jhu.cs.bsj.compiler.ast.node.PackageNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramAnchorNode;
import edu.jhu.cs.bsj.compiler.diagnostic.user.BsjUserDiagnosticListener;

/**
 * Represents the execution context for a metaprogram. Instances of this interface are provided to metaprograms to allow
 * them access to their environments, allowing modification of AST nodes in their own compilation unit and other
 * relevant facilities.
 * 
 * @author Zachary Palmer
 * @param <T> The type of metaprogram anchor node held by this context.
 */
public interface Context<T extends MetaprogramAnchorNode<?>>
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
}
