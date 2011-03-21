package edu.jhu.cs.bsj.compiler.impl.tool.compiler.task.data;

import java.util.Map;

import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.impl.utils.BijectiveMap;

/**
 * Represents the information that some compiler tasks need to identify the canonical anchors of metaprograms.
 * @author Zachary Palmer
 */
public class CanonicalNodeInfo
{
    /**
     * A mapping from UIDs in the currently-processed tree to UIDs in the canonical space.
     */
    private BijectiveMap<Long, Long> canonicalMapping;
    
    /**
     * A mapping from UIDs to nodes for a compilation unit which is a supertree of the currently-processed tree.
     */
    private Map<Long, Node> uidLookupMap;

    public CanonicalNodeInfo(BijectiveMap<Long, Long> canonicalMapping, Map<Long, Node> uidLookupMap)
    {
        super();
        this.canonicalMapping = canonicalMapping;
        this.uidLookupMap = uidLookupMap;
    }

    public BijectiveMap<Long, Long> getCanonicalMapping()
    {
        return canonicalMapping;
    }

    public Map<Long, Node> getUidLookupMap()
    {
        return uidLookupMap;
    }
}
