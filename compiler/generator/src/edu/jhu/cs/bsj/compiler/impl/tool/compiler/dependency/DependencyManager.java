package edu.jhu.cs.bsj.compiler.impl.tool.compiler.dependency;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

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
	/** A mapping from metaprogram profiles to the nodes containing them. */
	private Map<MetaprogramProfile<?>, BipartiteNode<MetaprogramNodeData, TargetNodeData, EdgeData, EdgeData>> profileToNodeMap;
	/** A mapping from target names to the nodes representing them. */
	private Map<String, BipartiteNode<TargetNodeData, MetaprogramNodeData, EdgeData, EdgeData>> nameToTargetNodeMap;
	/** A collection containing all of the metaprogram nodes representing metaprograms which have yet to be executed. */
	private Collection<BipartiteNode<MetaprogramNodeData, TargetNodeData, EdgeData, EdgeData>> waitingNodes;

	/** A cache of responses to cooperation queries. */
	private Map<Pair<Integer, Integer>, Boolean> cooperationCache;

	/**
	 * Creates a new dependency manager.
	 */
	public DependencyManager()
	{
		this.idMap = new HashMap<Integer, MetaprogramProfile<?>>();
		this.profileToNodeMap = new HashMap<MetaprogramProfile<?>, BipartiteNode<MetaprogramNodeData, TargetNodeData, EdgeData, EdgeData>>();
		this.nameToTargetNodeMap = new HashMap<String, BipartiteNode<TargetNodeData, MetaprogramNodeData, EdgeData, EdgeData>>();
		this.waitingNodes = new HashSet<BipartiteNode<MetaprogramNodeData, TargetNodeData, EdgeData, EdgeData>>();
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
		// Create a node for the profile
		BipartiteNode<MetaprogramNodeData, TargetNodeData, EdgeData, EdgeData> metaprogramNode = new BipartiteNode<MetaprogramNodeData, TargetNodeData, EdgeData, EdgeData>(
				new MetaprogramNodeData(profile));

		// For each target in the profile, add an edge from the target to this new node showing the target's dependency
		// on us.
		for (String targetName : profile.getTargetNames())
		{
			BipartiteNode<TargetNodeData, MetaprogramNodeData, EdgeData, EdgeData> targetNode = getTargetNode(targetName);
			targetNode.addChild(metaprogramNode, new EdgeData(false));
		}

		// For each dependency in the profile, add an edge from this new node to that target node showing our
		// dependency on that target
		for (String dependencyName : profile.getDependencyNames())
		{
			BipartiteNode<TargetNodeData, MetaprogramNodeData, EdgeData, EdgeData> targetNode = getTargetNode(dependencyName);
			targetNode.addParent(metaprogramNode, new EdgeData(false));
		}

		// Add this metaprogram node to the collection of waiting metaprograms
		this.waitingNodes.add(metaprogramNode);

		// Add this metaprogram node to the profile map
		this.profileToNodeMap.put(profile, metaprogramNode);

		// Add this metaprogram's profile to the ID map
		this.idMap.put(profile.getMetaprogram().getID(), profile);

		// TODO: cycle detection: did that create a cycle?
	}

	/**
	 * Retrieves the node representing the target of the specified name, creating it if necessary.
	 * 
	 * @param targetName The name of the target.
	 * @return The target node of that name.
	 */
	private BipartiteNode<TargetNodeData, MetaprogramNodeData, EdgeData, EdgeData> getTargetNode(String targetName)
	{
		// TODO: how do we check an empty target for compile-time errors? If a metaprogram explicitly depends on a
		// target that doesn't exist, that should be a problem (as it probably represents a typo
		BipartiteNode<TargetNodeData, MetaprogramNodeData, EdgeData, EdgeData> targetNode = this.nameToTargetNodeMap.get(targetName);
		if (targetNode == null)
		{
			// If the target does not exist, infer it
			targetNode = new BipartiteNode<TargetNodeData, MetaprogramNodeData, EdgeData, EdgeData>(new TargetNodeData(
					targetName));
			this.nameToTargetNodeMap.put(targetName, targetNode);
		}
		return targetNode;
	}

	/**
	 * Indicates to this dependency manager that the metaprogram for a profile has been executed.
	 * 
	 * @param profile The profile of the metaprogram which was executed.
	 */
	public void notifyExecuted(MetaprogramProfile<?> profile)
	{
		this.waitingNodes.remove(this.profileToNodeMap.get(profile));
	}

	/**
	 * Retrieves a metaprogram which should be executed. The returned metaprogram will not have any dependencies which
	 * are outstanding; it will be safe to execute immediately.
	 * 
	 * @return The next metaprogram to execute or <code>null</code> if no metaprograms remain.
	 */
	public MetaprogramProfile<?> getNextMetaprogram()
	{
		if (this.waitingNodes.size() == 0)
			return null;

		// TODO: this could be more efficient if we were a bit more clever
		// the tricky part is that the graph is not static

		// Pick a starting metaprogram
		BipartiteNode<MetaprogramNodeData, TargetNodeData, EdgeData, EdgeData> metaprogramNode = this.waitingNodes.iterator().next();
		boolean found;
		do
		{
			// Determine whether or not this metaprogram has any targets containing metaprograms which have not yet run
			found = false;
			for (BipartiteNode<MetaprogramNodeData, TargetNodeData, EdgeData, EdgeData> dependencyNode : metaprogramNode.getGrandchildren())
			{
				if (this.waitingNodes.contains(dependencyNode))
				{
					// This metaprogram hasn't run yet; it's the new candidate for execution
					// TODO: add the old one to a list; if we ever see it again, that's a cycle
					metaprogramNode = dependencyNode;
					found = true;
					break;
				}
			}
		} while (found);

		return metaprogramNode.getData().getProfile();
	}

	/**
	 * Retrieves a metaprogram by ID number.
	 * 
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

			BipartiteNode<MetaprogramNodeData, TargetNodeData, EdgeData, EdgeData> nodeA = this.profileToNodeMap.get(ma);
			BipartiteNode<MetaprogramNodeData, TargetNodeData, EdgeData, EdgeData> nodeB = this.profileToNodeMap.get(mb);

			value = checkPath(nodeA, nodeB) || checkPath(nodeB, nodeA);
			this.cooperationCache.put(key, value);
			this.cooperationCache.put(new Pair<Integer, Integer>(b, a), value);
		}
		return value;
	}

	/**
	 * Determines whether or not a path exists on the dependency graph from the first metaprogram to the second.
	 * 
	 * @param from The node for the first metaprogram.
	 * @param to The node for the second metaprogram.
	 * @return <code>true</code> if a path exists from the first metaprogram to the second; <code>false</code>
	 *         otherwise.
	 */
	private boolean checkPath(BipartiteNode<MetaprogramNodeData, TargetNodeData, EdgeData, EdgeData> from,
			BipartiteNode<MetaprogramNodeData, TargetNodeData, EdgeData, EdgeData> to)
	{
		if (from.getData().getProfile().getMetaprogram().getID() == to.getData().getProfile().getMetaprogram().getID())
			return true;

		for (BipartiteNode<MetaprogramNodeData, TargetNodeData, EdgeData, EdgeData> dependencyNode : from.getGrandchildren())
		{
			if (checkPath(dependencyNode, to))
			{
				return true;
			}
		}
		return false;
	}

	/**
	 * Causes this dependency manager to perform a sanity check for cycles in the dependency graph.
	 * 
	 * @throws IllegalStateException If a cycle exists in the dependency graph.
	 */
	public void assertNoCycles()
	{
		CycleDetector detector = new CycleDetector();
		Set<BipartiteNode<?, ?, ?, ?>> nodes = new HashSet<BipartiteNode<?, ?, ?, ?>>();
		nodes.addAll(this.profileToNodeMap.values());
		nodes.addAll(this.nameToTargetNodeMap.values());
		List<BipartiteNode<?, ?, ?, ?>> cycle = detector.detect(nodes);
		if (cycle != null)
		{
			StringBuilder sb = new StringBuilder();
			for (BipartiteNode<?, ?, ?, ?> node : cycle)
			{
				if (sb.length() > 0)
				{
					sb.append(", ");
				}
				sb.append(node.getData());
			}
			throw new IllegalStateException("Cycle detected in dependency graph: " + sb.toString());
		}
	}

	/**
	 * Causes this dependency manager to perform a search for injection conflicts in the dependency graph.
	 * 
	 * @throws IllegalStateException If an injection conflict is detected.
	 */
	public void assertNoInjectionConflict()
	{
		InjectionConflictDetector detector = new InjectionConflictDetector();
		for (BipartiteNode<MetaprogramNodeData, TargetNodeData, EdgeData, EdgeData> metaprogramNode : this.profileToNodeMap.values())
		{
			Pair<BipartiteNode<MetaprogramNodeData, TargetNodeData, EdgeData, EdgeData>, BipartiteNode<MetaprogramNodeData, TargetNodeData, EdgeData, EdgeData>> result = detector.findImmediateInjectionConflict(metaprogramNode);
			if (result != null)
			{
				throw new IllegalStateException("Metaprogram node " + metaprogramNode + " has inferred dependency on " +
						result.getSecond() + " based on injected metaprogram node " + result.getFirst());
			}
		}
	}

	/**
	 * This module serves as a mechanism for cycle detection.
	 * 
	 * @author Zachary Palmer
	 */
	private static class CycleDetector
	{
		/** A set of the nodes which have not yet been visited. */
		private Set<BipartiteNode<?, ?, ?, ?>> notVisited = new HashSet<BipartiteNode<?, ?, ?, ?>>();
		/** A set of the nodes which are currently being visited. */
		private Set<BipartiteNode<?, ?, ?, ?>> visiting = new HashSet<BipartiteNode<?, ?, ?, ?>>();
		/** A stack indicating the current nodes being visited. */
		private Stack<BipartiteNode<?, ?, ?, ?>> visitStack = new Stack<BipartiteNode<?, ?, ?, ?>>();

		/**
		 * Determines whether or not a cycle exists in this dependency manager's graph.
		 * 
		 * @param nodes A set of all nodes in the graph.
		 * @return <code>null</code> if no cycle exists or a list of nodes comprising a cycle if one does exist.
		 */
		public List<BipartiteNode<?, ?, ?, ?>> detect(Set<BipartiteNode<?, ?, ?, ?>> nodes)
		{
			this.notVisited.addAll(nodes);
			while (this.notVisited.size() > 0)
			{
				List<BipartiteNode<?, ?, ?, ?>> ret = visit(this.notVisited.iterator().next());
				if (ret != null)
				{
					return ret;
				}
			}
			return null;
		}

		/**
		 * Visits the specified node in turn.
		 * 
		 * @param node The node to visit.
		 * @return <code>null</code> if no cycle was detected or a list of nodes comprising a cycle if one was found.
		 */
		private <T, U, TE, UE> List<BipartiteNode<?, ?, ?, ?>> visit(BipartiteNode<T, U, TE, UE> node)
		{
			if (!this.notVisited.remove(node))
			{
				// Then this node has already been visited. This might happen if a node has multiple parents (like a
				// target with multiple metaprograms depending on -- pointing to -- it). If there were a cycle here, we
				// would've found it the first time.
				return null;
			}

			this.visitStack.push(node);
			if (!this.visiting.add(node))
			{
				// Okay, now we have a problem. We're already in the visiting list and we're being visited again; that
				// means that we've found a cycle starting and ending at this node. Return a list.
				return new ArrayList<BipartiteNode<?, ?, ?, ?>>(this.visitStack);
			}
			for (Pair<BipartiteNode<U, T, UE, TE>, ?> childEdge : node.getChildren())
			{
				List<BipartiteNode<?, ?, ?, ?>> ret = visit(childEdge.getFirst());
				if (ret != null)
				{
					return ret;
				}
			}
			this.visiting.remove(node);
			this.visitStack.remove(node);

			return null;
		}
	}

	/**
	 * This module serves as a mechanism for the detection of injection conflicts.
	 * 
	 * @author Zachary Palmer
	 */
	private static class InjectionConflictDetector
	{
		/**
		 * Determines whether or not the provided metaprogram suffers from an injection conflict with an immediately
		 * adjacent node.
		 * 
		 * @param node The node to check for an injection conflict.
		 * @return <code>null</code> if no injection conflict occurs. Otherwise, a pairing between the injected node
		 *         upon which the provided node directly depends and the node upon which the provided node must have an
		 *         explicit dependency.
		 */
		public Pair<BipartiteNode<MetaprogramNodeData, TargetNodeData, EdgeData, EdgeData>, BipartiteNode<MetaprogramNodeData, TargetNodeData, EdgeData, EdgeData>> findImmediateInjectionConflict(
				BipartiteNode<MetaprogramNodeData, TargetNodeData, EdgeData, EdgeData> node)
		{
			// Calculate all of the metaprograms which must run before this one
			Set<BipartiteNode<MetaprogramNodeData, TargetNodeData, EdgeData, EdgeData>> allDependencies = new HashSet<BipartiteNode<MetaprogramNodeData, TargetNodeData, EdgeData, EdgeData>>();
			Stack<BipartiteNode<MetaprogramNodeData, TargetNodeData, EdgeData, EdgeData>> explorationStack = new Stack<BipartiteNode<MetaprogramNodeData, TargetNodeData, EdgeData, EdgeData>>();
			explorationStack.add(node);
			while (explorationStack.size() > 0)
			{
				BipartiteNode<MetaprogramNodeData, TargetNodeData, EdgeData, EdgeData> current = explorationStack.pop();
				Set<BipartiteNode<MetaprogramNodeData, TargetNodeData, EdgeData, EdgeData>> explorationSet = current.getGrandchildren();
				for (BipartiteNode<MetaprogramNodeData, TargetNodeData, EdgeData, EdgeData> exploreTarget : explorationSet)
				{
					explorationStack.push(exploreTarget);
				}
				allDependencies.addAll(explorationSet);
			}

			// Get the first-level dependencies
			for (BipartiteNode<MetaprogramNodeData, TargetNodeData, EdgeData, EdgeData> dependency : node.getGrandchildren())
			{
				// For each dependency, find an inferred dependency edge and follow back to get an original metaprogram
				BipartiteNode<MetaprogramNodeData, TargetNodeData, EdgeData, EdgeData> original = findOriginalMetaprogram(dependency);
				if (original != null)
				{
					// If we don't a dependency on this node, scream
					if (!allDependencies.contains(original))
					{
						return new Pair<BipartiteNode<MetaprogramNodeData, TargetNodeData, EdgeData, EdgeData>, BipartiteNode<MetaprogramNodeData, TargetNodeData, EdgeData, EdgeData>>(
								dependency, original);
					}
				}
			}

			return null;
		}

		private BipartiteNode<MetaprogramNodeData, TargetNodeData, EdgeData, EdgeData> findOriginalMetaprogram(
				BipartiteNode<MetaprogramNodeData, TargetNodeData, EdgeData, EdgeData> start)
		{
			BipartiteNode<MetaprogramNodeData, TargetNodeData, EdgeData, EdgeData> node = start;
			boolean found;
			do
			{
				found = false;
				for (Pair<BipartiteNode<TargetNodeData, MetaprogramNodeData, EdgeData, EdgeData>, EdgeData> targetEdge : node.getChildren())
				{
					if (targetEdge.getSecond().isInferred())
					{
						// This edge is inferred, which means that the associated target is inferred.
						// TODO: some kind of runtime safety check to ensure that the target is inferred
						// As a result, we know that edges from it are inferred as well. Just get a metaprogram from
						// the target and run with it.
						found = true;
						node = targetEdge.getFirst().getChildren().iterator().next().getFirst();
					}
				}
			} while (found);

			if (node != start)
			{
				return node;
			} else
			{
				// We never found anything of consequence; none of the edges from the original were inferred.
				return null;
			}
		}
	}
}
