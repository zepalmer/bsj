package edu.jhu.cs.bsj.compiler.impl.tool.compiler.extraction;

import java.util.HashMap;
import java.util.Map;

import edu.jhu.cs.bsj.compiler.impl.metaprogram.Metaprogram;

/**
 * Represents a mechanism for storing the classes compiled for metaprograms.
 * 
 * @author Zachary Palmer
 */
public class ExplicitMetaprogramCompilationCache
{
    private Map<Long, Class<? extends Metaprogram<?, ?>>> explicitMetaprogramClassCache;

    public ExplicitMetaprogramCompilationCache()
    {
        this.explicitMetaprogramClassCache = new HashMap<Long, Class<? extends Metaprogram<?, ?>>>();
    }

    public void add(long canonicalAnchorUid, Class<? extends Metaprogram<?, ?>> clazz)
    {
        this.explicitMetaprogramClassCache.put(canonicalAnchorUid, clazz);
    }

    public Class<? extends Metaprogram<?, ?>> get(long canonicalAnchorUid)
    {
        return this.explicitMetaprogramClassCache.get(canonicalAnchorUid);
    }
}
