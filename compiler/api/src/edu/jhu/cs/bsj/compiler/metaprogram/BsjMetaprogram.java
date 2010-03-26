package edu.jhu.cs.bsj.compiler.metaprogram;

import java.util.List;

import edu.jhu.cs.bsj.compiler.ast.MetaprogramLocalMode;
import edu.jhu.cs.bsj.compiler.ast.MetaprogramPackageMode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramAnchorNode;

/**
 * This interface is implemented by those classes which are intended to represent metaprograms in the BSJ compilation
 * system. Meta-annotations which represent metaprograms use this interface to provide metaprograms to the BSJ compiler
 * upon request.
 * 
 * @param T The type of metaprogram anchor node used by this metaprogram.
 * @author Zachary Palmer
 */
public interface BsjMetaprogram<T extends MetaprogramAnchorNode<?>>
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
	public void execute(Context<T> context);
}
