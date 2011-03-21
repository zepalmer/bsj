package edu.jhu.cs.bsj.compiler.impl.tool.compiler.dependency;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.Stack;

import javax.tools.DiagnosticListener;

import org.apache.log4j.Logger;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramAnchorNode;
import edu.jhu.cs.bsj.compiler.diagnostic.compiler.InjectionConfictDiagnostic;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.EditScript;
import edu.jhu.cs.bsj.compiler.impl.diagnostic.compiler.DependencyCycleDiagnosticImpl;
import edu.jhu.cs.bsj.compiler.impl.diagnostic.compiler.InjectionConfictDiagnosticImpl;
import edu.jhu.cs.bsj.compiler.impl.diagnostic.compiler.MetaprogramEmptyDependencyDiagnosticImpl;
import edu.jhu.cs.bsj.compiler.impl.tool.compiler.MetaprogramProfile;
import edu.jhu.cs.bsj.compiler.impl.utils.NotImplementedYetException;
import edu.jhu.cs.bsj.compiler.impl.utils.Pair;
import edu.jhu.cs.bsj.compiler.impl.utils.StringUtilities;
import edu.jhu.cs.bsj.compiler.impl.utils.function.Function;

/**
 * This class contains information relating to metaprogram dependencies. An instance relates to a specific compilation
 * pass.
 * 
 * @author Zachary Palmer
 */
public class DependencyManager
{
    /** A logger for this object. */
    private final Logger LOGGER = Logger.getLogger(getClass());

    /** A mapping from metaprogram IDs to the profiles of those metaprograms. */
    private Map<Integer, MetaprogramProfile<?, ?>> idMap;
    /** A mapping from canonical anchor nodes to the registered profiles of the associated metaprograms. */
    private Map<MetaprogramAnchorNode<?>, MetaprogramProfile<?, ?>> anchorMap;
    /** A mapping from metaprogram profiles to the nodes containing them. */
    private Map<MetaprogramProfile<?, ?>, BipartiteNode<MetaprogramNodeData, TargetNodeData, MetaprogramEdgeData, TargetEdgeData>> profileToNodeMap;
    /** A mapping from target names to the nodes representing them. */
    private Map<String, BipartiteNode<TargetNodeData, MetaprogramNodeData, TargetEdgeData, MetaprogramEdgeData>> nameToTargetNodeMap;
    /** A collection containing all of the metaprogram nodes representing metaprograms which have yet to be executed. */
    private Collection<BipartiteNode<MetaprogramNodeData, TargetNodeData, MetaprogramEdgeData, TargetEdgeData>> waitingNodes;
    /** A mapping from metaprogram profiles to the edit scripts that were produced when executing those metaprograms. */
    private Map<MetaprogramProfile<?, ?>, EditScript> profileToEditScriptMap;

    /** A cache of responses to ordering queries. */
    private Map<Pair<Integer, Integer>, Boolean> orderingCache;

    /** A random number generator used to select the order in which metaprograms are executed. */
    private Random random;

    /**
     * Creates a new dependency manager.
     */
    public DependencyManager()
    {
        this(null);
    }

    /**
     * Creates a new dependency manager.
     * 
     * @param r The random number generator used to select the order in which metaprograms run. If <code>null</code>,
     *            metaprograms are executed in an arbitrary order. This parameter is useful for debugging as a random
     *            number generator using the same seed on the same code will always produce the same execution order.
     */
    public DependencyManager(Random r)
    {
        this.idMap = new HashMap<Integer, MetaprogramProfile<?, ?>>();
        this.anchorMap = new HashMap<MetaprogramAnchorNode<?>, MetaprogramProfile<?, ?>>();
        this.profileToNodeMap = new HashMap<MetaprogramProfile<?, ?>, BipartiteNode<MetaprogramNodeData, TargetNodeData, MetaprogramEdgeData, TargetEdgeData>>();
        this.nameToTargetNodeMap = new HashMap<String, BipartiteNode<TargetNodeData, MetaprogramNodeData, TargetEdgeData, MetaprogramEdgeData>>();
        this.waitingNodes = new HashSet<BipartiteNode<MetaprogramNodeData, TargetNodeData, MetaprogramEdgeData, TargetEdgeData>>();
        this.orderingCache = new HashMap<Pair<Integer, Integer>, Boolean>();
        this.profileToEditScriptMap = new HashMap<MetaprogramProfile<?, ?>, EditScript>();
        this.random = r;
    }

    /**
     * Registers a metaprogram profile with this manager. Each profile which participates in a target must be registered
     * with this manager for the manager's dependency operations to function correctly. If this profile corresponds to
     * an anchor which has already been registered, this method instead ensures that that profile and this one are
     * equivalent. Otherwise, two loads occurred from metaprograms which generated semantically distinct meanings for
     * them.
     * 
     * @param profile The metaprogram profile to register.
     * @param parentProfile The profile of the metaprogram which generated this metaprogram or <code>null</code> if this
     *            is not the case.
     * @param diagnosticListener The diagnostic listener to which to report problems if they occur.
     */
    public void registerMetaprogramProfile(MetaprogramProfile<?, ?> profile, MetaprogramProfile<?, ?> parentProfile,
            DiagnosticListener<BsjSourceLocation> diagnosticListener)
    {
        MetaprogramProfile<?, ?> otherProfile = this.anchorMap.get(profile.getAnchor());
        if (otherProfile == null)
        {
            if (LOGGER.isTraceEnabled())
            {
                LOGGER.trace("Registering a received profile: " + profile);
            }
            actuallyRegisterMetaprogramProfile(profile, parentProfile, diagnosticListener);
        } else
        {
            if (LOGGER.isTraceEnabled())
            {
                LOGGER.trace("Received profile for registration: " + profile);
                LOGGER.trace("Confirming its equivalence with profile: " + otherProfile);
            }
            confirmEquivalentProfiles(profile, otherProfile);
        }
    }

    /**
     * Confirms that the provided profiles are equivalent. This method is executed when the same metaprogram anchor is
     * registered in two different profiles such as when two different metaprograms load the same resource. If these
     * profiles are equivalent, it is safe to ignore the registration (since the other metaprogram has already done so)
     * and continue executing. If they are not, the metaprograms both have different semantic impressions of the loaded
     * metaprogram, which is a form of conflict.
     * 
     * @param a The first profile.
     * @param b The second profile.
     */
    private void confirmEquivalentProfiles(MetaprogramProfile<?, ?> a, MetaprogramProfile<?, ?> b)
    {
        final boolean targetsMatch = a.getTargetNames().equals(b.getTargetNames());
        final boolean dependenciesMatch = a.getDependencies().equals(b.getDependencies());
        final boolean modesMatch = a.getLocalMode().equals(b.getLocalMode())
                && a.getPackageMode().equals(b.getPackageMode());
        if (targetsMatch && dependenciesMatch && modesMatch)
            return;
        // TODO: diagnostic
        throw new NotImplementedYetException(
                "Two metaprograms loaded the same compilation unit in different ways; not yet prepared to address this.");
    }

    /**
     * Actually performs the registration. This method should only be called if the profile's anchor is new. This method
     * performs the work necessary to add the node to the metaprogram execution graph.
     * 
     * @param profile The metaprogram profile to register.
     * @param parentProfile The profile of the metaprogram which generated this metaprogram or <code>null</code> if this
     *            is not the case.
     * @param diagnosticListener The diagnostic listener to which to report problems if they occur.
     */
    private void actuallyRegisterMetaprogramProfile(MetaprogramProfile<?, ?> profile,
            MetaprogramProfile<?, ?> parentProfile, DiagnosticListener<BsjSourceLocation> diagnosticListener)
    {
        // Create a node for the profile
        BipartiteNode<MetaprogramNodeData, TargetNodeData, MetaprogramEdgeData, TargetEdgeData> metaprogramNode = new BipartiteNode<MetaprogramNodeData, TargetNodeData, MetaprogramEdgeData, TargetEdgeData>(
                new MetaprogramNodeData(profile));

        // For each target in the profile, add an edge from the target to this new node showing the target's dependency
        // on us.
        for (String targetName : profile.getTargetNames())
        {
            BipartiteNode<TargetNodeData, MetaprogramNodeData, TargetEdgeData, MetaprogramEdgeData> targetNode = getTargetNode(targetName);
            targetNode.addChild(metaprogramNode, new TargetEdgeData(false));
        }

        // For each dependency in the profile, add an edge from this new node to that target node showing our
        // dependency on that target
        for (Dependency dependency : profile.getDependencies())
        {
            BipartiteNode<TargetNodeData, MetaprogramNodeData, TargetEdgeData, MetaprogramEdgeData> targetNode = getTargetNode(dependency.getName());
            targetNode.addParent(metaprogramNode, new MetaprogramEdgeData(false, dependency.isWeak()));
        }

        // Add this metaprogram node to the collection of waiting metaprograms
        this.waitingNodes.add(metaprogramNode);

        // Add this metaprogram node to the profile map
        this.profileToNodeMap.put(profile, metaprogramNode);

        // Add this metaprogram's profile to the ID map and the anchor map
        this.idMap.put(profile.getMetaprogram().getID(), profile);
        this.anchorMap.put(profile.getAnchor(), profile);

        // If this metaprogram was injected, create the appropriate inferred target and edges
        if (parentProfile != null)
        {
            inferDependency(profile, parentProfile);
        }

        // For debugging purposes, print out a description of the dependency graph
        if (LOGGER.isDebugEnabled())
        {
            debugLogDependencyGraph();
        }

        // Determine whether or not we just caused a cycle
        CycleDetector cycleDetector = new CycleDetector();
        Set<BipartiteNode<?, ?, ?, ?>> allNodes = new HashSet<BipartiteNode<?, ?, ?, ?>>();
        allNodes.addAll(this.profileToNodeMap.values());
        allNodes.addAll(this.nameToTargetNodeMap.values());
        List<BipartiteNode<?, ?, ?, ?>> cycle = cycleDetector.detect(allNodes, metaprogramNode);
        if (cycle != null)
        {
            List<BsjSourceLocation> metaprogramLocations = new ArrayList<BsjSourceLocation>();
            List<String> targetNames = new ArrayList<String>();
            for (BipartiteNode<?, ?, ?, ?> node : cycle)
            {
                if (node.getData() instanceof MetaprogramNodeData)
                {
                    metaprogramLocations.add(((MetaprogramNodeData) node.getData()).getProfile().getLocation());
                } else if (node.getData() instanceof TargetNodeData)
                {
                    targetNames.add(((TargetNodeData) node.getData()).getTarget());
                } else
                {
                    throw new IllegalStateException("Unrecognized bipartite dependency node data type: "
                            + node.getData().getClass());
                }
            }
            diagnosticListener.report(new DependencyCycleDiagnosticImpl(profile.getLocation(), targetNames,
                    metaprogramLocations));
            // If there's a cycle, it's no longer safe to proceed for fear of infinite loops. Let the caller handle our
            // reported error diagnostic.
            return;
        }

        // Determine whether or not we just caused an injection conflict
        checkForInjectionConflict(metaprogramNode, diagnosticListener);
    }

    /**
     * Writes trace logs which describe the dependency graph.
     */
    private void debugLogDependencyGraph()
    {
        LOGGER.debug("Dependency graph currently appears as follows:");
        Set<BipartiteNode<TargetNodeData, MetaprogramNodeData, TargetEdgeData, MetaprogramEdgeData>> targetsToVisit = new HashSet<BipartiteNode<TargetNodeData, MetaprogramNodeData, TargetEdgeData, MetaprogramEdgeData>>();
        for (Map.Entry<MetaprogramProfile<?, ?>, BipartiteNode<MetaprogramNodeData, TargetNodeData, MetaprogramEdgeData, TargetEdgeData>> entry : this.profileToNodeMap.entrySet())
        {
            MetaprogramProfile<?, ?> profile = entry.getKey();
            BipartiteNode<MetaprogramNodeData, TargetNodeData, MetaprogramEdgeData, TargetEdgeData> node = entry.getValue();
            Set<BipartiteNode<TargetNodeData, MetaprogramNodeData, TargetEdgeData, MetaprogramEdgeData>> targets = node.getChildren();
            Set<Pair<BipartiteNode<TargetNodeData, MetaprogramNodeData, TargetEdgeData, MetaprogramEdgeData>, MetaprogramEdgeData>> edges = node.getChildEdges();
            LOGGER.debug("Metaprogram " + profile.getMetaprogram().getID() + " at " + profile.getLocation() + " has "
                    + targets.size() + " target dependencies");
            for (Pair<BipartiteNode<TargetNodeData, MetaprogramNodeData, TargetEdgeData, MetaprogramEdgeData>, MetaprogramEdgeData> edge : edges)
            {
                List<String> tags = new LinkedList<String>();
                if (edge.getSecond().isInferred())
                    tags.add("inferred");
                if (edge.getSecond().isWeak())
                    tags.add("weak");
                final String suffix = (tags.size() > 0 ? (" (" + StringUtilities.join(tags, ", ") + ")") : "");
                LOGGER.debug("    " + edge.getFirst().getData().getTarget() + suffix);
            }
            targetsToVisit.addAll(targets);
        }
        for (BipartiteNode<TargetNodeData, MetaprogramNodeData, TargetEdgeData, MetaprogramEdgeData> target : targetsToVisit)
        {
            Set<Pair<BipartiteNode<MetaprogramNodeData, TargetNodeData, MetaprogramEdgeData, TargetEdgeData>, TargetEdgeData>> edges = target.getChildEdges();
            LOGGER.debug("Target " + target.getData().getTarget() + " contains " + edges.size() + " metaprograms");
            for (Pair<BipartiteNode<MetaprogramNodeData, TargetNodeData, MetaprogramEdgeData, TargetEdgeData>, TargetEdgeData> edge : edges)
            {
                BipartiteNode<MetaprogramNodeData, TargetNodeData, MetaprogramEdgeData, TargetEdgeData> program = edge.getFirst();
                List<String> tags = new LinkedList<String>();
                if (edge.getSecond().isInferred())
                    tags.add("inferred");
                final String suffix = (tags.size() > 0 ? (" (" + StringUtilities.join(tags, ", ") + ")") : "");
                LOGGER.debug("    " + program.getData().getProfile().getMetaprogram().getID() + " at "
                        + program.getData().getProfile().getLocation() + suffix);
            }
        }
    }

    /**
     * Determines whether or not the specified node is either the conflicted or injected node in an injection conflict.
     * 
     * @param metaprogramNode The node to test.
     * @return <code>true</code> if any conflicts were found; <code>false</code> otherwise.
     */
    private boolean checkForInjectionConflict(
            BipartiteNode<MetaprogramNodeData, TargetNodeData, MetaprogramEdgeData, TargetEdgeData> metaprogramNode,
            DiagnosticListener<BsjSourceLocation> diagnosticListener)
    {
        if (LOGGER.isTraceEnabled())
        {
            LOGGER.trace("Checking for injection conflicts from " + metaprogramNode.getData().getProfile());
        }
        boolean found = false;

        InjectionConflictDetector injectionConflictDetector = new InjectionConflictDetector();
        Collection<InjectionConflict> conflicts;

        // Possibility 1: an injected program causes an injection conflict
        for (BipartiteNode<MetaprogramNodeData, TargetNodeData, MetaprogramEdgeData, TargetEdgeData> grandparent : metaprogramNode.getFilteredGrandparents(
                new TargetNodeParentInferenceStateFilteringFunction(false),
                new MetaprogramNodeParentInferenceStateFilteringFunction(false)))
        {
            conflicts = injectionConflictDetector.findImmediateInjectionConflict(grandparent);
            if (conflicts != null)
            {
                for (InjectionConflict conflict : conflicts)
                {
                    diagnosticListener.report(getInjectionConfictDiagnostic(grandparent, conflict));
                    found = true;
                }
            }
        }

        // Possibility 2: an injected program may suffer from an injection conflict just like a normal metaprogram
        conflicts = injectionConflictDetector.findImmediateInjectionConflict(metaprogramNode);
        if (conflicts != null)
        {
            for (InjectionConflict conflict : conflicts)
            {
                diagnosticListener.report(getInjectionConfictDiagnostic(metaprogramNode, conflict));
                found = true;
            }
        }
        
        return found;
    }

    /**
     * Creates an inferred dependency between two profiles.
     * 
     * @param profile The dependent profile.
     * @param parentProfile The profile it depends upon.
     */
    private void inferDependency(MetaprogramProfile<?, ?> profile, MetaprogramProfile<?, ?> parentProfile)
    {
        // Get parent profile's metaprogram node
        BipartiteNode<MetaprogramNodeData, TargetNodeData, MetaprogramEdgeData, TargetEdgeData> injector = this.profileToNodeMap.get(parentProfile);
        // Get inferred target for the parent profile's metaprogram
        BipartiteNode<TargetNodeData, MetaprogramNodeData, TargetEdgeData, MetaprogramEdgeData> target = getTargetNode(getInferredTargetName(parentProfile));
        // Create edges as appropriate
        injector.addParent(target, new TargetEdgeData(true));
        this.profileToNodeMap.get(profile).addChild(target, new MetaprogramEdgeData(true, false));
    }

    /**
     * Creates a diagnostic appropriate for an injection conflict pair.
     * 
     * @param conflict The conflict that occurred.
     * @param metaprogram The metaprogam experiencing the conflict.
     * @return The resulting diagnostic.
     */
    private InjectionConfictDiagnostic getInjectionConfictDiagnostic(
            BipartiteNode<MetaprogramNodeData, TargetNodeData, MetaprogramEdgeData, TargetEdgeData> metaprogram,
            InjectionConflict conflict)
    {
        Set<BsjSourceLocation> injectorLocations = new HashSet<BsjSourceLocation>();
        for (BipartiteNode<MetaprogramNodeData, TargetNodeData, MetaprogramEdgeData, TargetEdgeData> injector : conflict.getConflictingMetaprograms())
        {
            injectorLocations.add(injector.getData().getProfile().getLocation());
        }
        return new InjectionConfictDiagnosticImpl(metaprogram.getData().getProfile().getLocation(), injectorLocations,
                conflict.getInjectedMetaprogram().getData().getProfile().getLocation(),
                conflict.getConflictedMetaprogram().getData().getProfile().getLocation(),
                conflict.getTarget().getData().getTarget());
    }

    /**
     * Creates a name for an inferred dependency target on the specified metaprogram.
     * 
     * @param profile The profile of the metaprogram.
     * @return The name of the inferred target.
     */
    private String getInferredTargetName(MetaprogramProfile<?, ?> profile)
    {
        return "#" + profile.getMetaprogram().getID();
    }

    /**
     * Retrieves the node representing the target of the specified name, creating it if necessary.
     * 
     * @param targetName The name of the target.
     * @return The target node of that name.
     */
    private BipartiteNode<TargetNodeData, MetaprogramNodeData, TargetEdgeData, MetaprogramEdgeData> getTargetNode(
            String targetName)
    {
        BipartiteNode<TargetNodeData, MetaprogramNodeData, TargetEdgeData, MetaprogramEdgeData> targetNode = this.nameToTargetNodeMap.get(targetName);
        if (targetNode == null)
        {
            // If the target does not exist, infer it
            targetNode = new BipartiteNode<TargetNodeData, MetaprogramNodeData, TargetEdgeData, MetaprogramEdgeData>(
                    new TargetNodeData(targetName));
            this.nameToTargetNodeMap.put(targetName, targetNode);
        }
        return targetNode;
    }

    /**
     * Indicates to this dependency manager that the metaprogram for a profile has been executed.
     * 
     * @param profile The profile of the metaprogram which was executed.
     * @param editScript The edit script that was produced by the execution of the metaprogram.
     */
    public void notifyExecuted(MetaprogramProfile<?, ?> profile, EditScript editScript)
    {
        this.waitingNodes.remove(this.profileToNodeMap.get(profile));
        this.profileToEditScriptMap.put(profile, editScript);
    }

    /**
     * Retrieves a metaprogram which should be executed. The returned metaprogram will not have any dependencies which
     * are outstanding; it will be safe to execute immediately.
     * 
     * @param diagnosticListener The diagnostic listener to which to report an error if an error occurs.
     * @return The next metaprogram to execute or <code>null</code> if no metaprograms remain.
     */
    public MetaprogramProfile<?, ?> getNextMetaprogram(DiagnosticListener<BsjSourceLocation> diagnosticListener)
    {
        if (this.waitingNodes.size() == 0)
            return null;

        // TODO: this could be more efficient if we were a bit more clever
        // the tricky part is that the graph is not static

        // Pick a starting metaprogram
        BipartiteNode<MetaprogramNodeData, TargetNodeData, MetaprogramEdgeData, TargetEdgeData> metaprogramNode;

        if (this.random == null)
        {
            metaprogramNode = this.waitingNodes.iterator().next();
        } else
        {
            int count = this.random.nextInt(this.waitingNodes.size());
            Iterator<BipartiteNode<MetaprogramNodeData, TargetNodeData, MetaprogramEdgeData, TargetEdgeData>> it = waitingNodes.iterator();
            metaprogramNode = it.next();
            for (int i = 0; i < count; i++)
            {
                metaprogramNode = it.next();
            }
        }

        boolean found;
        do
        {
            // Determine whether or not this metaprogram has any targets containing metaprograms which have not yet run
            found = false;
            for (Pair<BipartiteNode<TargetNodeData, MetaprogramNodeData, TargetEdgeData, MetaprogramEdgeData>, MetaprogramEdgeData> targetDependency : metaprogramNode.getChildEdges())
            {
                Collection<BipartiteNode<MetaprogramNodeData, TargetNodeData, MetaprogramEdgeData, TargetEdgeData>> dependencies = targetDependency.getFirst().getChildren();
                if (dependencies.size() == 0 && !targetDependency.getSecond().isWeak())
                {
                    // In this case, the metaprogram has declared a strong dependency and is ready to run but no
                    // metaprograms participate in its target. Complain.
                    diagnosticListener.report(new MetaprogramEmptyDependencyDiagnosticImpl(
                            metaprogramNode.getData().getProfile().getLocation(),
                            targetDependency.getFirst().getData().getTarget()));
                    // But don't bail out just in case there are others.
                }
                for (BipartiteNode<MetaprogramNodeData, TargetNodeData, MetaprogramEdgeData, TargetEdgeData> dependencyNode : dependencies)
                {
                    if (this.waitingNodes.contains(dependencyNode))
                    {
                        // This metaprogram hasn't run yet; it's the new candidate for execution
                        metaprogramNode = dependencyNode;
                        found = true;
                        break;
                    }
                }
            }
        } while (found);

        return metaprogramNode.getData().getProfile();
    }

    /**
     * Retrieves the edit scripts on which a given metaprogram is dependent. These edit scripts are returned in an order
     * which reflects a topological sort of the nodes of the metaprograms which produced them.
     * 
     * @param metaprogram The profile of the metaprogram for which the edit scripts are required.
     * @return A list of edit scripts which, if executed over the original tree, will produce an appropriate tree for
     *         the specified metaprogram to use during execution.
     */
    public List<EditScript> getMetaprogramEditScriptDependencies(MetaprogramProfile<?, ?> metaprogram)
    {
        Set<BipartiteNode<MetaprogramNodeData, TargetNodeData, MetaprogramEdgeData, TargetEdgeData>> visitedNodes = new HashSet<BipartiteNode<MetaprogramNodeData, TargetNodeData, MetaprogramEdgeData, TargetEdgeData>>();
        List<EditScript> ret = new LinkedList<EditScript>();
        BipartiteNode<MetaprogramNodeData, TargetNodeData, MetaprogramEdgeData, TargetEdgeData> ourNode = this.profileToNodeMap.get(metaprogram);
        for (BipartiteNode<MetaprogramNodeData, TargetNodeData, MetaprogramEdgeData, TargetEdgeData> dep : ourNode.getGrandchildren())
        {
            editScriptDependencyVisit(dep, visitedNodes, ret);
        }
        return ret;
    }

    /**
     * Retrieves all edit scripts from this graph. This method should only be invoked once execution of all metaprograms
     * is complete. The returned list of edit scripts will be in an order reflecting a topological sort of the
     * metaprograms in this graph, meaning that executing them in order over the initial tree will produce the final
     * tree.
     */
    public List<EditScript> getFinalEditScriptDependencies()
    {
        List<EditScript> ret = new LinkedList<EditScript>();
        Set<BipartiteNode<MetaprogramNodeData, TargetNodeData, MetaprogramEdgeData, TargetEdgeData>> visitedNodes = new HashSet<BipartiteNode<MetaprogramNodeData, TargetNodeData, MetaprogramEdgeData, TargetEdgeData>>();
        for (BipartiteNode<MetaprogramNodeData, TargetNodeData, MetaprogramEdgeData, TargetEdgeData> node : this.profileToNodeMap.values())
        {
            // We only need to start by visiting those nodes on which no other nodes depend
            if (node.getGrandparents().size() == 0)
            {
                editScriptDependencyVisit(node, visitedNodes, ret);
            }
        }
        return ret;
    }

    private void editScriptDependencyVisit(
            BipartiteNode<MetaprogramNodeData, TargetNodeData, MetaprogramEdgeData, TargetEdgeData> node,
            Set<BipartiteNode<MetaprogramNodeData, TargetNodeData, MetaprogramEdgeData, TargetEdgeData>> visited,
            List<EditScript> editScripts)
    {
        if (visited.add(node))
        {
            for (BipartiteNode<MetaprogramNodeData, TargetNodeData, MetaprogramEdgeData, TargetEdgeData> dep : node.getGrandchildren())
            {
                editScriptDependencyVisit(dep, visited, editScripts);
            }
            editScripts.add(this.profileToEditScriptMap.get(node.getData().getProfile()));
        }
    }

    /**
     * Retrieves a metaprogram by ID number.
     * 
     * @param id The ID of the metaprogram to retrieve.
     * @return The profile of the metaprogram or <code>null</code> if that metaprogram does not exist.
     */
    public MetaprogramProfile<?, ?> getMetaprogramProfileByID(int id)
    {
        return this.idMap.get(id);
    }

    /**
     * Determines whether or not two metaprograms are ordered. Metaprograms are ordered if there exists a path on the
     * dependency graph which contains both of them.
     * 
     * @param a The ID of the first metaprogram.
     * @param b The ID of the second metaprogram.
     * @return <code>true</code> if these metaprograms are ordered; <code>false</code> if they do not.
     */
    public boolean checkOrdering(int a, int b)
    {
        Pair<Integer, Integer> key = new Pair<Integer, Integer>(a, b);
        Boolean value = this.orderingCache.get(key);
        if (value == null)
        {
            MetaprogramProfile<?, ?> ma = this.idMap.get(a);
            if (ma == null)
            {
                throw new IllegalArgumentException("Invalid metaprogram ID " + a
                        + " given as first metaprogram in path check (" + a + "," + b + ")!");
            }
            MetaprogramProfile<?, ?> mb = this.idMap.get(b);
            if (mb == null)
            {
                throw new IllegalArgumentException("Invalid metaprogram ID " + b
                        + " given as second metaprogram in path check (" + a + "," + b + ")!");
            }

            BipartiteNode<MetaprogramNodeData, TargetNodeData, MetaprogramEdgeData, TargetEdgeData> nodeA = this.profileToNodeMap.get(ma);
            BipartiteNode<MetaprogramNodeData, TargetNodeData, MetaprogramEdgeData, TargetEdgeData> nodeB = this.profileToNodeMap.get(mb);

            value = checkPath(nodeA, nodeB) || checkPath(nodeB, nodeA);
            this.orderingCache.put(key, value);
            this.orderingCache.put(new Pair<Integer, Integer>(b, a), value);
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
    private boolean checkPath(
            BipartiteNode<MetaprogramNodeData, TargetNodeData, MetaprogramEdgeData, TargetEdgeData> from,
            BipartiteNode<MetaprogramNodeData, TargetNodeData, MetaprogramEdgeData, TargetEdgeData> to)
    {
        if (from.getData().getProfile().getMetaprogram().getID() == to.getData().getProfile().getMetaprogram().getID())
            return true;

        for (BipartiteNode<MetaprogramNodeData, TargetNodeData, MetaprogramEdgeData, TargetEdgeData> dependencyNode : from.getGrandchildren())
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
        for (BipartiteNode<MetaprogramNodeData, TargetNodeData, MetaprogramEdgeData, TargetEdgeData> metaprogramNode : this.profileToNodeMap.values())
        {
            Collection<InjectionConflict> conflicts = detector.findImmediateInjectionConflict(metaprogramNode);
            if (conflicts != null)
            {
                throw new IllegalStateException("Compiler bug: failed to detect injection conflicts inline: "
                        + conflicts);
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
         * Determines whether or not a cycle exists in this dependency manager's graph which contains the specified
         * node.
         * 
         * @param nodes A set of all nodes in the graph.
         * @param node The node which must be contained in the cycle.
         * @return <code>null</code> if no cycle exists or a list of nodes comprising a cycle if one does exist.
         */
        public List<BipartiteNode<?, ?, ?, ?>> detect(Set<BipartiteNode<?, ?, ?, ?>> nodes,
                BipartiteNode<?, ?, ?, ?> node)
        {
            this.notVisited.addAll(nodes);
            List<BipartiteNode<?, ?, ?, ?>> ret = visit(node);
            return ret;
        }

        /**
         * Visits the specified node in turn.
         * 
         * @param node The node to visit.
         * @return <code>null</code> if no cycle was detected or a list of nodes comprising a cycle if one was found.
         */
        private <T, U, TE, UE> List<BipartiteNode<?, ?, ?, ?>> visit(BipartiteNode<T, U, TE, UE> node)
        {
            if (!this.visiting.add(node))
            {
                // Okay, now we have a problem. We're already in the visiting list and we're being visited again; that
                // means that we've found a cycle starting and ending at this node. Return a list.
                return new ArrayList<BipartiteNode<?, ?, ?, ?>>(this.visitStack);
            }

            if (!this.notVisited.remove(node))
            {
                // Then this node has already been visited. This might happen if a node has multiple parents (like a
                // target with multiple metaprograms depending on -- pointing to -- it). If there were a cycle here, we
                // would've found it the first time.
                this.visiting.remove(node);
                return null;
            }

            this.visitStack.push(node);
            for (Pair<BipartiteNode<U, T, UE, TE>, ?> childEdge : node.getChildEdges())
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
         * @return The set of detected conflicts or <code>null</code> if no injection conflict occurs.
         */
        public Collection<InjectionConflict> findImmediateInjectionConflict(
                BipartiteNode<MetaprogramNodeData, TargetNodeData, MetaprogramEdgeData, TargetEdgeData> node)
        {
            Collection<InjectionConflict> ret = null;
            // Calculate all of the metaprograms which are reachable from this one using explicit edges
            Set<BipartiteNode<MetaprogramNodeData, TargetNodeData, MetaprogramEdgeData, TargetEdgeData>> allDependencies = new HashSet<BipartiteNode<MetaprogramNodeData, TargetNodeData, MetaprogramEdgeData, TargetEdgeData>>();
            Stack<BipartiteNode<MetaprogramNodeData, TargetNodeData, MetaprogramEdgeData, TargetEdgeData>> explorationStack = new Stack<BipartiteNode<MetaprogramNodeData, TargetNodeData, MetaprogramEdgeData, TargetEdgeData>>();
            explorationStack.add(node);
            while (explorationStack.size() > 0)
            {
                BipartiteNode<MetaprogramNodeData, TargetNodeData, MetaprogramEdgeData, TargetEdgeData> current = explorationStack.pop();
                // We need to find all grandchildren of the current node which can be reached without using inferred
                // edges
                for (BipartiteNode<TargetNodeData, MetaprogramNodeData, TargetEdgeData, MetaprogramEdgeData> explicitChild : current.getFilteredChildren(new TargetNodeChildInferenceStateFilteringFunction(
                        false)))
                {
                    Set<BipartiteNode<MetaprogramNodeData, TargetNodeData, MetaprogramEdgeData, TargetEdgeData>> explicitGrandchildren = explicitChild.getFilteredChildren(new MetaprogramNodeChildInferenceStateFilteringFunction(
                            false));
                    for (BipartiteNode<MetaprogramNodeData, TargetNodeData, MetaprogramEdgeData, TargetEdgeData> grandchild : explicitGrandchildren)
                    {
                        explorationStack.push(grandchild);
                    }
                    allDependencies.addAll(explicitGrandchildren);
                }
            }

            // Get the first-level explicit dependencies
            for (BipartiteNode<TargetNodeData, MetaprogramNodeData, TargetEdgeData, MetaprogramEdgeData> targetDependency : node.getFilteredChildren(new TargetNodeChildInferenceStateFilteringFunction(
                    false)))
            {
                for (BipartiteNode<MetaprogramNodeData, TargetNodeData, MetaprogramEdgeData, TargetEdgeData> dependency : targetDependency.getFilteredChildren(new MetaprogramNodeChildInferenceStateFilteringFunction(
                        false)))
                {
                    // For each dependency, determine whether or not a conflict can be found
                    boolean hasInferredChildren = false;
                    boolean explicitDependencyExists = false;

                    // For each dependency, we check each of its injectors for a potentially legal route
                    for (Pair<BipartiteNode<TargetNodeData, MetaprogramNodeData, TargetEdgeData, MetaprogramEdgeData>, MetaprogramEdgeData> targetEdge : dependency.getChildEdges())
                    {
                        if (targetEdge.getSecond().isInferred())
                        {
                            // We have an inferred target
                            for (BipartiteNode<MetaprogramNodeData, TargetNodeData, MetaprogramEdgeData, TargetEdgeData> injector : targetEdge.getFirst().getChildren())
                            {
                                // Mark down that we need a dependency
                                hasInferredChildren = true;
                                // Determine whether or not we can reach the injector without using the implicit edge
                                // from the injectee to the injector's implicit target
                                if (checkInjectionPath(node, injector))
                                {
                                    explicitDependencyExists = true;
                                }
                            }
                        }
                    }

                    // If we saw an injection conflict, report it
                    if (hasInferredChildren && !explicitDependencyExists)
                    {
                        if (ret == null)
                        {
                            ret = new ArrayList<InjectionConflict>();
                        }
                        Set<BipartiteNode<MetaprogramNodeData, TargetNodeData, MetaprogramEdgeData, TargetEdgeData>> injectors = dependency.getFilteredGrandchildren(
                                new TargetNodeChildInferenceStateFilteringFunction(true),
                                new MetaprogramNodeChildInferenceStateFilteringFunction(true));
                        ret.add(new InjectionConflict(targetDependency, dependency, node, injectors));
                    }

                }
            }

            return ret;
        }

        /**
         * Determines whether or not a path exists on the dependency graph which satisfies the requirements of injection
         * conflict prevention from one node to another.
         * 
         * @param from The node for the first metaprogram.
         * @param to The node for the second metaprogram.
         * @return <code>true</code> if such a path exists; <code>false</code> if it does not.
         */
        private boolean checkInjectionPath(
                BipartiteNode<MetaprogramNodeData, TargetNodeData, MetaprogramEdgeData, TargetEdgeData> from,
                BipartiteNode<MetaprogramNodeData, TargetNodeData, MetaprogramEdgeData, TargetEdgeData> to)
        {
            if (checkExplicitPath(from, to))
                return true;

            // Otherwise, the source must be purely injected and every possible implicit edge must be recursed
            if (!from.getData().getProfile().isPurelyInjected())
                return false;

            for (BipartiteNode<MetaprogramNodeData, TargetNodeData, MetaprogramEdgeData, TargetEdgeData> dependency : from.getFilteredGrandchildren(
                    new TargetNodeChildInferenceStateFilteringFunction(true),
                    new MetaprogramNodeChildInferenceStateFilteringFunction(true)))
            {
                if (!checkInjectionPath(dependency, to))
                {
                    return false;
                }
            }
            return true;
        }

        /**
         * Determines whether or not a path exists on the dependency graph from the first metaprogram to the second
         * which only includes explicit edges.
         * 
         * @param from The node for the first metaprogram.
         * @param to The node for the second metaprogram.
         * @return <code>true</code> if a path exists from the first metaprogram to the second; <code>false</code>
         *         otherwise.
         */
        private boolean checkExplicitPath(
                BipartiteNode<MetaprogramNodeData, TargetNodeData, MetaprogramEdgeData, TargetEdgeData> from,
                BipartiteNode<MetaprogramNodeData, TargetNodeData, MetaprogramEdgeData, TargetEdgeData> to)
        {
            if (from.getData().getProfile().getMetaprogram().getID() == to.getData().getProfile().getMetaprogram().getID())
                return true;

            for (Pair<BipartiteNode<TargetNodeData, MetaprogramNodeData, TargetEdgeData, MetaprogramEdgeData>, MetaprogramEdgeData> targetNodeEdge : from.getChildEdges())
            {
                if (!targetNodeEdge.getSecond().isInferred())
                {
                    for (BipartiteNode<MetaprogramNodeData, TargetNodeData, MetaprogramEdgeData, TargetEdgeData> dependencyNode : targetNodeEdge.getFirst().getChildren())
                    {
                        if (checkExplicitPath(dependencyNode, to))
                        {
                            return true;
                        }
                    }
                }
            }
            return false;
        }
    }

    /**
     * A filtering function for nodes that retrieves the nodes on which they immediately depend using edges with a given
     * inference state.
     * 
     * @author Zachary Palmer
     * @param <D> The type data which is stored at nodes provided to this function.
     * @param <ND> The type of data which is stored at nodes adjacent to the nodes provided to this function.
     * @param <E> The type of edge data leaving the nodes provided to this function.
     * @param <NE> The type of edge data entering the nodes provided to this function.
     * @param <RE> The type of edge data over which the returned function operates.
     */
    private static class InferenceStateFilteringFunction<D, ND, E extends EdgeData, NE extends EdgeData, RE extends EdgeData>
            implements
            Function<BipartiteNode<? super D, ? super ND, ? super E, ? super NE>, Function<? super RE, Boolean>>
    {
        /** The desired inference state for nodes that pass the filter. */
        private boolean inferred;

        public InferenceStateFilteringFunction(boolean inferred)
        {
            super();
            this.inferred = inferred;
        }

        @Override
        public Function<RE, Boolean> execute(BipartiteNode<? super D, ? super ND, ? super E, ? super NE> argument)
        {
            return new Function<RE, Boolean>()
            {
                @Override
                public Boolean execute(RE argument)
                {
                    return argument.isInferred() == InferenceStateFilteringFunction.this.inferred;
                }
            };
        }
    }

    /**
     * A convenience type for an inference state filtering function that works on target nodes.
     */
    private static class TargetNodeParentInferenceStateFilteringFunction
            extends
            InferenceStateFilteringFunction<TargetNodeData, MetaprogramNodeData, TargetEdgeData, MetaprogramEdgeData, TargetEdgeData>
    {
        public TargetNodeParentInferenceStateFilteringFunction(boolean inferred)
        {
            super(inferred);
        }
    }

    /**
     * A convenience type for an inference state filtering function that works on target nodes.
     */
    private static class MetaprogramNodeParentInferenceStateFilteringFunction
            extends
            InferenceStateFilteringFunction<MetaprogramNodeData, TargetNodeData, MetaprogramEdgeData, TargetEdgeData, MetaprogramEdgeData>
    {
        public MetaprogramNodeParentInferenceStateFilteringFunction(boolean inferred)
        {
            super(inferred);
        }
    }

    /**
     * A convenience type for an inference state filtering function that works on target nodes.
     */
    private static class TargetNodeChildInferenceStateFilteringFunction
            extends
            InferenceStateFilteringFunction<TargetNodeData, MetaprogramNodeData, TargetEdgeData, MetaprogramEdgeData, MetaprogramEdgeData>
    {
        public TargetNodeChildInferenceStateFilteringFunction(boolean inferred)
        {
            super(inferred);
        }
    }

    /**
     * A convenience type for an inference state filtering function that works on target nodes.
     */
    private static class MetaprogramNodeChildInferenceStateFilteringFunction
            extends
            InferenceStateFilteringFunction<MetaprogramNodeData, TargetNodeData, MetaprogramEdgeData, TargetEdgeData, TargetEdgeData>
    {
        public MetaprogramNodeChildInferenceStateFilteringFunction(boolean inferred)
        {
            super(inferred);
        }
    }
}
