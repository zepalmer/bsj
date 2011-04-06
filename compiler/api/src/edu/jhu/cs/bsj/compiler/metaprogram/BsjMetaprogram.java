package edu.jhu.cs.bsj.compiler.metaprogram;

import java.util.List;

import edu.jhu.cs.bsj.compiler.ast.MetaprogramLocalMode;
import edu.jhu.cs.bsj.compiler.ast.MetaprogramPackageMode;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramAnchorNode;

/**
 * This interface is implemented by those classes which are intended to represent metaprograms in the BSJ compilation
 * system.
 * 
 * @param <T> The type of metaprogram anchor node used by this metaprogram.
 * @param <U> The type of node which may replace the metaprogram's anchor.
 * @param <V> The type of context that this metaprogram expects to receive when executing.
 * @author Zachary Palmer
 */
public interface BsjMetaprogram<T extends MetaprogramAnchorNode<U>, U extends Node, V extends Context<T,U>>
{
	/**
	 * Obtains a list of the targets in which this metaprogram participates. The metaprogram object is obligated to
	 * return the same list with the same contents throughout its lifetime. The targets should be simple names
	 * (containing only legal Java identifier characters).
	 * 
	 * @return The list of targets in which this metaprogram participates.
	 */
	public List<String> getTargets();

	/**
	 * Obtains a list of the targets on which this metaprogram depends. The metaprogram object is obligated to return
	 * the same list with the same contents throughout its lifetime. The targets should be qualified names (containing
	 * only legal Java identifier characters in groups separated by dots).
	 * 
	 * @return The list of targets on which this metaprogram depends.
	 */
	public List<String> getDependencies();

	/**
	 * Obtains a list of the targets on which this metaprogram depends. The metaprogram object is obligated to return
	 * the same list with the same contents throughout its lifetime. The targets should be qualified names (containing
	 * only legal Java identifier characters in groups separated by dots).
	 * 
	 * @return The list of targets on which this metaprogram depends.
	 */
	public List<String> getWeakDependencies();

	/**
	 * Obtains the local mode for this metaprogram. The metaprogram object is obligated to return the same mode
	 * throughout its lifetime.
	 * 
	 * @return The local mode for this metaprogram.
	 */
	public MetaprogramLocalMode getLocalMode();

	/**
	 * Obtains the package mode for this metaprogram. The metaprogram object is obligated to return the same mode
	 * throughout its lifetime.
	 * 
	 * @return The package mode for this metaprogram.
	 */
	public MetaprogramPackageMode getPackageMode();

	/**
	 * Executes this annotational metaprogram.
	 * 
	 * @param context The context in which to execute this metaprogram.
	 */
	public void execute(V context);
}
