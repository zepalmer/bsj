package edu.jhu.cs.bsj.compiler.impl.ast.delta;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.NodeUnion;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.list.ListNode;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.list.ShadowList;
import edu.jhu.cs.bsj.compiler.impl.ast.properties.NodeProperty;
import edu.jhu.cs.bsj.compiler.impl.tool.compiler.dependency.DependencyManager;
import edu.jhu.cs.bsj.compiler.impl.utils.BijectiveMap;
import edu.jhu.cs.bsj.compiler.impl.utils.HashBijectiveMap;
import edu.jhu.cs.bsj.compiler.impl.utils.Pair;
import edu.jhu.cs.bsj.compiler.impl.utils.UnmodifiableBijectiveMap;
import edu.jhu.cs.bsj.compiler.impl.utils.function.Function;
import edu.jhu.cs.bsj.compiler.metaprogram.CompilationUnitLoadingInfo;

/**
 * Represents the state of a patch operation in progress.
 * 
 * @author Zachary Palmer
 */
public class PatchState
{
    /** The dependency manager which can test ordering between metaprograms. */
    private DependencyManager dependencyManager;

    /** A node factory which can be used to instantiate nodes while patching. */
    private BsjNodeFactory nodeFactory;

    /** The compilation unit loading information to use when loading compilation units. */
    private CompilationUnitLoadingInfo compilationUnitLoadingInfo;

    /**
     * The mapping from node UIDs to the nodes that represent them. It should be observed that this does not assume that
     * the keys match the values' UIDs; a node with a different UID will typically represent that UID in the patch.
     */
    private BijectiveMap<Long, Node> nodeMap;

    /**
     * The population strategy for the node map.
     */
    private PopulationStrategy populationStrategy;

    /**
     * A set of UIDs which were instantiated by edit script operations (as opposed to the population strategy).
     */
    private Set<Long> createdUids;

    /**
     * The representative identification strategy for translating pre-existing nodes.
     */
    private Function<Long, Long> representativeIdentificationStrategy;

    /**
     * A mapping for recording writes from metaprograms. The key to this mapping is a pair between a node UID (treated
     * as an abstraction in the same way as <tt>nodeMap</tt>) and a {@link NodeProperty} value. The value of this
     * mapping is a set containing the IDs of all metaprograms which have manipulated the indicated node's property.
     */
    private Map<Pair<Long, NodeProperty>, Set<Integer>> propertyUpdateMap;

    /**
     * A mapping for tracking the shadow lists of list nodes throughout the patching operation.
     */
    private BijectiveMap<Long, ShadowList> shadowListMap;

    /**
     * A mapping describing introduced subpackage relationships. The key of the map is a pairing between the UID of the
     * package and the name of the subpackage.
     */
    private Map<Pair<Long, String>, SubpackageRelationship> subpackageRelationshipMap;

    /**
     * A mapping relating implicitly-created subpackages to each other. This mapping is used to merge cases in which the
     * same subpackages are implicitly created by different metaprograms. For instance, consider if metaprogram A gets a
     * package Foo from the root and adds a class A to it. Metaprogram B likewise adds class B to Foo. The change sets
     * would be, respectively, {#A.Foo += A} and {#B.Foo += B}, where #A.Foo is the UID that metaprogram A uses for Foo.
     * When applying these changes, we must remember that #A.Foo and #B.Foo really refer to the same node.
     */
    public Map<Long, Long> implicitPackageEquivalenceMap;

    /**
     * Creates a patch state.
     * 
     * @param dependencyManager The dependency manager to query for ordering of metaprograms.
     * @param nodeFactory The factory for creating new nodes during patch operations.
     * @param populationStrategy The strategy for population of nodes which are not present in the node map for this
     *            patch. This strategy should be able to perform population for any node in an edit script element which
     *            is not created by a previous edit script element.
     * @param representativeIdentificationStrategy The strategy for determining which ID a given node represents. This
     *            is used to determine
     */
    public PatchState(DependencyManager dependencyManager, BsjNodeFactory nodeFactory,
            PopulationStrategy populationStrategy, Function<Long, Long> representativeIdentificationStrategy)
    {
        this.dependencyManager = dependencyManager;
        this.nodeFactory = nodeFactory;
        this.nodeMap = new HashBijectiveMap<Long, Node>();
        this.createdUids = new HashSet<Long>();
        this.propertyUpdateMap = new HashMap<Pair<Long, NodeProperty>, Set<Integer>>();
        this.shadowListMap = new HashBijectiveMap<Long, ShadowList>();
        this.subpackageRelationshipMap = new HashMap<Pair<Long, String>, SubpackageRelationship>();
        this.implicitPackageEquivalenceMap = new HashMap<Long, Long>();
        this.populationStrategy = populationStrategy;
        this.representativeIdentificationStrategy = representativeIdentificationStrategy;
    }

    public DependencyManager getDependencyManager()
    {
        return this.dependencyManager;
    }

    public BsjNodeFactory getNodeFactory()
    {
        return this.nodeFactory;
    }

    public CompilationUnitLoadingInfo getCompilationUnitLoadingInfo()
    {
        return this.compilationUnitLoadingInfo;
    }

    /**
     * Retrieves the mapping between canonical UIDs and the nodes which are representing them. This mapping is read-only
     * and will not lazily populate; it should not be used by edit scripts.
     */
    public BijectiveMap<Long, Node> getNodeMap()
    {
        return new UnmodifiableBijectiveMap<Long, Node>(this.nodeMap);
    }

    /**
     * Retrieves a node from the patch state node map.
     * 
     * @param uid The UID of the node to retrieve.
     * @return The node in the node map or <code>null</code> if no such node exists.
     */
    public Node getNode(Long uid)
    {
        if (uid == null)
        {
            return null;
        }
        Node ret;
        if (!this.nodeMap.containsKey(uid))
        {
            ret = this.populationStrategy.populate(uid);
            this.nodeMap.put(uid, ret);
        } else
        {
            ret = this.nodeMap.get(uid);
        }
        return ret;
    }

    /**
     * Adds a node to the patch state node map. This is usually called by create edit script elements.
     * 
     * @param id The ID that the new node represents.
     * @param node The node to add to the node map.
     */
    public void addNode(long id, Node node)
    {
        this.nodeMap.put(id, node);
        this.createdUids.add(id);
    }

    /**
     * Determines the patch namespace UID that the specified node represents.
     * 
     * @param node The node to test.
     * @return The UID represented by that node or <code>null</code> if no UID is represented by that node.
     */
    public Long getRepresentedUid(Node node)
    {
        return this.nodeMap.invert().get(node);
    }

    public BijectiveMap<Long, ShadowList> getShadowListMap()
    {
        return shadowListMap;
    }

    public Map<Pair<Long, String>, SubpackageRelationship> getSubpackageRelationshipMap()
    {
        return subpackageRelationshipMap;
    }

    public Map<Long, Long> getImplicitPackageEquivalenceMap()
    {
        return implicitPackageEquivalenceMap;
    }

    public ShadowList getShadowListFor(long uid)
    {
        ShadowList list = this.shadowListMap.get(uid);
        if (list == null)
        {
            ListNode<?> listNode = (ListNode<?>) this.getNode(uid);
            if (listNode == null)
            {
                throw new IllegalStateException("Attempted to get shadow list for UID " + uid + " which was not in map");
            }
            list = buildShadowList(uid, listNode);
            this.shadowListMap.put(uid, list);
        }
        return list;
    }

    private <T extends Node> ShadowList buildShadowList(long uid, ListNode<T> listNode)
    {
        ShadowList list;
        List<Long> uids = new ArrayList<Long>();
        for (NodeUnion<? extends T> union : listNode.getUnionForChildren())
        {
            final long elementUid;
            if (this.nodeMap.containsValue(union.getNodeValue()))
            {
                elementUid = this.nodeMap.invert().get(union.getNodeValue());
            } else
            {
                Long representativeUid = this.representativeIdentificationStrategy.execute(union.getNodeValue().getUid());
                if (representativeUid == null)
                {
                    throw new IllegalStateException("Representative identification strategy returned null for #"
                            + union.getNodeValue().getUid() + ", a member of list #" + uid);
                }
                elementUid = representativeUid;
            }
            uids.add(elementUid);
        }
        list = new ShadowList(this.dependencyManager, uids, listNode, new Function<Long, Node>()
        {
            @Override
            public Node execute(Long argument)
            {
                return PatchState.this.getNode(argument);
            }
        });
        return list;
    }

    public void addPropertyUpdate(long nodeId, NodeProperty property, int metaprogramId)
    {
        Pair<Long, NodeProperty> key = new Pair<Long, NodeProperty>(nodeId, property);
        Set<Integer> set = this.propertyUpdateMap.get(key);
        if (set == null)
        {
            set = new HashSet<Integer>();
            this.propertyUpdateMap.put(key, set);
        }
        set.add(metaprogramId);
    }

    public Set<Integer> getPropertyUpdatesFor(long nodeId, NodeProperty property)
    {
        Pair<Long, NodeProperty> key = new Pair<Long, NodeProperty>(nodeId, property);
        Set<Integer> set = this.propertyUpdateMap.get(key);
        if (set == null)
        {
            return Collections.emptySet();
        } else
        {
            return Collections.unmodifiableSet(set);
        }
    }

    public Set<Long> getCreatedUids()
    {
        return Collections.unmodifiableSet(createdUids);
    }

    /**
     * This interface describes the behavior of a population strategy which can provide preseeded nodes to this patch
     * state. Preseeded nodes are those which are not explicitly created by an edit script element.
     * 
     * @author Zachary Palmer
     */
    public static interface PopulationStrategy
    {
        /**
         * Obtains a node based on the provided UID. The given UID is in the namespace of the patch state, but the
         * returned node may have a UID in any namespace as long as this method consistently returns nodes with UIDs in
         * the same namespace.
         * 
         * @param uid The UID for which a node is desired.
         */
        public Node populate(long uid);
    }

    public static class SubpackageRelationship
    {
        public static enum Type
        {
            /** For subpackages which were explicitly added. */
            EXPLICIT,
            /** For subpackages which were implicitly created by a get operation. */
            IMPLICIT
        }

        private Long packageUid;
        private String subpackageName;
        private Type type;
        private Set<Integer> metaprogramIds;

        public SubpackageRelationship(Long packageUid, String subpackageName, Type type)
        {
            this.packageUid = packageUid;
            this.subpackageName = subpackageName;
            this.type = type;
            this.metaprogramIds = new HashSet<Integer>();
        }

        public Long getPackageUid()
        {
            return packageUid;
        }

        public String getSubpackageName()
        {
            return subpackageName;
        }

        public Type getType()
        {
            return type;
        }

        public Set<Integer> getMetaprogramIds()
        {
            return metaprogramIds;
        }

        public String toString()
        {
            return subpackageName + ":#" + packageUid + (type == Type.EXPLICIT ? "!" : "") + metaprogramIds.toString();
        }
    }
}
