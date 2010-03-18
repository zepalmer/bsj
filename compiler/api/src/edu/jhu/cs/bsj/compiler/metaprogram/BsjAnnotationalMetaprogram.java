package edu.jhu.cs.bsj.compiler.metaprogram;

import java.util.List;

import edu.jhu.cs.bsj.compiler.ast.MetaprogramLocalMode;
import edu.jhu.cs.bsj.compiler.ast.MetaprogramPackageMode;

/**
 * This interface is implemented by classes in the metacompiler runtime which represent annotational metaprograms.
 * 
 * @author Zachary Palmer
 */
// TODO: finish
public interface BsjAnnotationalMetaprogram
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
	 * @param context The context in which to execute this metaprogram.
	 */
	// TODO: context should be parameterized with metaprogram annotation anchor type
	public void execute(Context<?> context);
}
