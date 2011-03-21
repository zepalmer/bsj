package edu.jhu.cs.bsj.compiler.impl.ast.delta;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * The state of an edit script namespace translation.
 * @author Zachary Palmer
 */
public class TranslationState
{
    /** The mapping from node UIDs in the source namespace to node UIDs in the target namespace. */
    private Map<Long,Long> uidMap;
    /** The collection of UIDs which represent nodes which were instantiated by the edit script. */
    private Set<Long> instantiations;
    
    public TranslationState(Map<Long, Long> uidMap)
    {
        super();
        this.uidMap = uidMap;
        this.instantiations = new HashSet<Long>();
    }

    public Map<Long, Long> getUidMap()
    {
        return uidMap;
    }

    public Set<Long> getInstantiations()
    {
        return instantiations;
    }

}
