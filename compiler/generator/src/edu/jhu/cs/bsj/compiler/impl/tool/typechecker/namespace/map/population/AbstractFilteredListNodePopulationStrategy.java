package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.namespace.map.population;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import edu.jhu.cs.bsj.compiler.ast.NodeFilter;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.list.ListNode;
import edu.jhu.cs.bsj.compiler.impl.utils.CollectionUtilities;
import edu.jhu.cs.bsj.compiler.impl.utils.filter.ConjunctiveNodeFilter;
import edu.jhu.cs.bsj.compiler.impl.utils.function.Thunk;
import edu.jhu.cs.bsj.compiler.lang.element.BsjElement;

public abstract class AbstractFilteredListNodePopulationStrategy<K, V extends BsjElement> extends
        AbstractThunkBackedPopulationStrategy<K, V, ListNode<?>> implements PopulationStrategy<K, V>
{
    /** The filter which should be applied to the nodes which are populated. */
    private NodeFilter<Node> filter;

    /** A cache for filters by specific key. */
    private Map<K, NodeFilter<Node>> keyFilterCache = new HashMap<K, NodeFilter<Node>>();

    /**
     * General constructor.
     * 
     * @param listNodeThunk A thunk which is capable of obtaining the list of nodes to use in this population strategy.
     * @param keyFilterGenerator A routine which can produce an appropriate node filter from a key value.
     * @param filters The filters to apply to the population strategy.
     */
    public AbstractFilteredListNodePopulationStrategy(Thunk<ListNode<?>> listNodeThunk,
            Iterable<NodeFilter<Node>> filters)
    {
        super(listNodeThunk);
        this.filter = new ConjunctiveNodeFilter<Node>(filters);
    }

    private NodeFilter<Node> getFilterByKey(K key)
    {
        if (!this.keyFilterCache.containsKey(key))
        {
            this.keyFilterCache.put(
                    key,
                    new ConjunctiveNodeFilter<Node>(CollectionUtilities.<NodeFilter<Node>> listOf(this.filter,
                            getKeyFilter(key))));
        }
        return this.keyFilterCache.get(key);
    }
    
    @Override
    public Collection<PopulationRecord<K, V>> get(K key)
    {
        return getByFilter(getFilterByKey(key), key);
    }

    @Override
    public Collection<PopulationRecord<K, V>> getBySimpleName(String name)
    {
        Collection<PopulationRecord<K, V>> ret = new HashSet<PopulationRecord<K,V>>();
        for (K key : getKeysBySimpleName(name))
        {
            ret.addAll(this.get(key));
        }
        return ret;
    }

    @Override
    public Collection<PopulationRecord<K, V>> getAll()
    {
        return getByFilter(this.filter, null);
    }

    /**
     * Retrieves a population record using the specified node filter. Additionally filters population record retrieval
     * by the provided key as necessary.
     * 
     * @param filter The filter in question.
     * @param key The key to use or <code>null</code> for no key filtering.
     * @return The population records for nodes matching that filter.
     */
    private Collection<PopulationRecord<K, V>> getByFilter(NodeFilter<Node> filter, K key)
    {
        Set<? extends Node> nodes = think().filter(filter);
        List<PopulationRecord<K, V>> ret = new ArrayList<PopulationRecord<K, V>>(nodes.size());
        for (Node node : nodes)
        {
            ret.addAll(getPopulationRecordForNode(node, key));
        }
        return ret;
    }

    /**
     * Generates a node filter based on the provided namespace key.
     * 
     * @param key The namespace key to use.
     * @return The resulting filter.
     */
    protected abstract NodeFilter<Node> getKeyFilter(K key);

    /**
     * Obtains all keys which can be provided by this population strategy by simple name.
     * 
     * @param name The simple name to use.
     * @return All keys that this population strategy can provide that have that simple name.
     */
    protected abstract Collection<K> getKeysBySimpleName(String name);

    /**
     * Given a node, produces a collection of records describing how it fits into the namespace map.  All such records
     * should reflect nodes matching the provided key unless that provided key is <code>null</code>.  This information
     * is provided for routines that need to look at more than the provided node in order to obtain the necessary
     * record information.
     */
    protected abstract Collection<? extends PopulationRecord<K, V>> getPopulationRecordForNode(Node node, K key);
}
