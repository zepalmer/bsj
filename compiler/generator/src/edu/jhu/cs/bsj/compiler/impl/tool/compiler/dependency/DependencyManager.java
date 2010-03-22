package edu.jhu.cs.bsj.compiler.impl.tool.compiler.dependency;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import edu.jhu.cs.bsj.compiler.impl.tool.compiler.MetaprogramProfile;
import edu.jhu.cs.bsj.compiler.impl.utils.Pair;

/**
 * This class contains information relating to metaprogram dependencies. An instance relates to a specific compilation
 * pass.
 * 
 * @author Zachary Palmer
 */
public class DependencyManager
{
	/** A mapping from metaprogram IDs to the profiles of those metaprograms. */
	private Map<Integer, MetaprogramProfile<?>> idMap;
	/** A mapping from fully qualified target names to the nodes which are included in the targets. */
	private Map<String, MetaprogramTarget> targetMap;
	/** A collection indicating the nodes containing metaprograms which have yet to be executed. */
	private Collection<MetaprogramProfile<?>> waitingMetaprograms;

	/** A cache of responses to cooperation queries. */
	private Map<Pair<Integer, Integer>, Boolean> cooperationCache;

	/**
	 * Creates a new dependency manager.
	 */
	public DependencyManager()
	{
		this.idMap = new HashMap<Integer, MetaprogramProfile<?>>();
		this.targetMap = new HashMap<String, MetaprogramTarget>();
		this.waitingMetaprograms = new HashSet<MetaprogramProfile<?>>();
		this.cooperationCache = new HashMap<Pair<Integer, Integer>, Boolean>();
	}

	/**
	 * Registers a metaprogram profile with this manager. Each profile which participates in a target must be registered
	 * with this manager for the manager's dependency operations to function correctly.
	 * 
	 * @param profile The metaprogram profile to register.
	 */
	public void registerMetaprogramProfile(MetaprogramProfile<?> profile)
	{
		for (String targetName : profile.getTargetNames())
		{
			MetaprogramTarget target = targetMap.get(targetName);
			if (target == null)
			{
				target = new MetaprogramTarget(targetName);
				targetMap.put(targetName, target);
			}
			target.getMembers().add(profile);
		}
		this.waitingMetaprograms.add(profile);
		this.idMap.put(profile.getMetaprogram().getID(), profile);
		// TODO: cycle detection
	}

	/**
	 * Retrieves the profiles which are participating in the specified target.
	 * 
	 * @param targetName The name of the fully-qualified target.
	 * @return The profiles of the metaprograms in that target.
	 */
	public Collection<MetaprogramProfile<?>> getTargetMembers(String targetName)
	{
		return this.targetMap.get(targetName).getMembers();
	}

	/**
	 * Indicates to this dependency manager that the metaprogram for a profile has been executed.
	 * 
	 * @param profile The profile of the metaprogram which was executed.
	 */
	public void notifyExecuted(MetaprogramProfile<?> profile)
	{
		this.waitingMetaprograms.remove(profile);
	}

	/**
	 * Retrieves a metaprogram which should be executed. The returned metaprogram will not have any dependencies which
	 * are outstanding; it will be safe to execute immediately.
	 * 
	 * @return The next metaprogram to execute or <code>null</code> if no metaprograms remain.
	 */
	public MetaprogramProfile<?> getNextMetaprogram()
	{
		if (this.waitingMetaprograms.size() == 0)
			return null;

		// TODO: this could be more efficient if we were a bit more clever
		// the tricky part is that the graph is not static
		MetaprogramProfile<?> profile = this.waitingMetaprograms.iterator().next();
		boolean found;
		do
		{
			found = false;
			outer: for (String targetName : profile.getDependencyNames())
			{
				MetaprogramTarget target = this.targetMap.get(targetName);
				if (target == null)
				{
					// TODO: what if there are no members in this target? target will be null... this is a compile
					// error?
					continue;
				}
				for (MetaprogramProfile<?> dependency : target.getMembers())
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
	
	/**
	 * Retrieves a metaprogram by ID number.
	 * @param id The ID of the metaprogram to retrieve.
	 * @return The profile of the metaprogram or <code>null</code> if that metaprogram does not exist.
	 */
	public MetaprogramProfile<?> getMetaprogramProfileByID(int id)
	{
		return this.idMap.get(id);
	}

	/**
	 * Determines whether or not two metaprograms cooperate. Metaprograms cooperate if there exists a path on the
	 * dependency graph which contains both of them.
	 * 
	 * @param a The ID of the first metaprogram.
	 * @param b The ID of the second metaprogram.
	 * @return <code>true</code> if these metaprograms cooperate; <code>false</code> if they do not.
	 */
	public boolean checkCooperation(int a, int b)
	{
		Pair<Integer, Integer> key = new Pair<Integer, Integer>(a, b);
		Boolean value = this.cooperationCache.get(key);
		if (value == null)
		{
			MetaprogramProfile<?> ma = this.idMap.get(a);
			if (ma == null)
			{
				throw new IllegalArgumentException("Invalid metaprogram ID " + a
						+ " given as first metaprogram in path check (" + a + "," + b + ")!");
			}
			MetaprogramProfile<?> mb = this.idMap.get(b);
			if (mb == null)
			{
				throw new IllegalArgumentException("Invalid metaprogram ID " + b
						+ " given as second metaprogram in path check (" + a + "," + b + ")!");
			}
			value = checkPath(ma, mb) || checkPath(mb, ma);
			this.cooperationCache.put(key, value);
			this.cooperationCache.put(new Pair<Integer, Integer>(b, a), value);
		}
		return value;
	}

	/**
	 * Determines whether or not a path exists on the dependency graph from the first metaprogram to the second.
	 * 
	 * @param from The profile of the first metaprogram.
	 * @param to The profile of the second metaprogram.
	 * @return <code>true</code> if a path exists from the first metaprogram to the second; <code>false</code>
	 *         otherwise.
	 */
	private boolean checkPath(MetaprogramProfile<?> from, MetaprogramProfile<?> to)
	{
		if (from.getMetaprogram().getID() == to.getMetaprogram().getID())
			return true;

		for (String dependencyName : from.getDependencyNames())
		{
			MetaprogramTarget target = this.targetMap.get(dependencyName);
			if (target == null)
			{
				// TODO: this means a metaprogram depends on an empty target - do we explode here?
			} else
			{
				for (MetaprogramProfile<?> dep : target.getMembers())
				{
					if (checkPath(dep, to))
					{
						return true;
					}
				}
			}
		}

		return false;
	}
}
