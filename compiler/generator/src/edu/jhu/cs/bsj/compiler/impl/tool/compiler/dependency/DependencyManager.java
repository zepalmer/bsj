package edu.jhu.cs.bsj.compiler.impl.tool.compiler.dependency;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import edu.jhu.cs.bsj.compiler.impl.tool.compiler.MetaprogramProfile;


/**
 * This class contains information relating to metaprogram dependencies.  An instance relates to a specific compilation
 * pass.
 * @author Zachary Palmer
 */
public class DependencyManager
{
	/** A mapping from fully qualified target names to the nodes which are included in the targets. */
	private Map<String,MetaprogramTarget> targetMap;
	/** A collection indicating the nodes containing metaprograms which have yet to be executed. */
	private Collection<MetaprogramProfile> waitingMetaprograms;
	
	/**
	 * Creates a new dependency manager.
	 */
	public DependencyManager()
	{
		this.targetMap = new HashMap<String, MetaprogramTarget>();
		this.waitingMetaprograms = new HashSet<MetaprogramProfile>();
	}
	
	/**
	 * Registers a metaprogram profile with this manager.  Each profile which participates in a target must be
	 * registered with this manager for the manager's dependency operations to function correctly.
	 * @param profile The metaprogram profile to register.
	 */
	public void registerMetaprogramProfile(MetaprogramProfile profile)
	{
		for (String targetName : profile.getTargetNames())
		{
			MetaprogramTarget target = targetMap.get(targetName);
			if (target==null)
			{
				target = new MetaprogramTarget(targetName);
				targetMap.put(targetName, target);
			}
			target.getMembers().add(profile);
		}
		this.waitingMetaprograms.add(profile);
		// TODO: cycle detection
	}
	
	/**
	 * Retrieves the profiles which are participating in the specified target.
	 * @param targetName The name of the fully-qualified target.
	 * @return The profiles of the metaprograms in that target.
	 */
	public Collection<MetaprogramProfile> getTargetMembers(String targetName)
	{
		return this.targetMap.get(targetName).getMembers();
	}
	
	/**
	 * Indicates to this dependency manager that the metaprogram for a profile has been executed.
	 * @param profile The profile of the metaprogram which was executed.
	 */
	public void notifyExecuted(MetaprogramProfile profile)
	{
		this.waitingMetaprograms.remove(profile);
	}
	
	/**
	 * Retrieves a metaprogram which should be executed.  The returned metaprogram will not have any dependencies which
	 * are outstanding; it will be safe to execute immediately.
	 * @return The next metaprogram to execute or <code>null</code> if no metaprograms remain.
	 */
	public MetaprogramProfile getNextMetaprogram()
	{
		if (this.waitingMetaprograms.size() == 0)
			return null;
		
		// TODO: this could be more efficient if we were a bit more clever
		// the tricky part is that the graph is not static
		MetaprogramProfile profile = this.waitingMetaprograms.iterator().next();
		boolean found;
		do
		{
			found = false;
			outer:
			for (String targetName : profile.getDependencyNames())
			{
				MetaprogramTarget target = this.targetMap.get(targetName);
				if (target == null)
				{
					// TODO: what if there are no members in this target?  target will be null... this is a compile error?
					continue;
				}
				for (MetaprogramProfile dependency : target.getMembers())
				{
					if (this.waitingMetaprograms.contains(dependency))
					{
						found = true;
						profile = dependency;
						break outer;
					}
				}
			}
		} while (found);
		
		return profile;
	}
}
