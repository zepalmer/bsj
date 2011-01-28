package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.namespace;

import java.util.Collection;

import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.namespace.map.NamespaceMap;
import edu.jhu.cs.bsj.compiler.impl.utils.StringUtilities;
import edu.jhu.cs.bsj.compiler.lang.element.BsjElement;

/**
 * Used as a repository for common utility functions pertaining to namespaces.
 * @author Zachary Palmer
 */
public class NamespaceUtilities
{
    private NamespaceUtilities()
    {
    }
    
    public static final <K,V extends BsjElement> String namespaceToString(NamespaceMap<K,V> map)
    {
        StringBuilder sb = new StringBuilder("{");
        boolean first = true;
        for (K key : map.getPopulatedKeys())
        {
            Collection<V> values = map.getValues(key);
            if (values.size() == 0)
                continue;
            if (!first)
                sb.append(",");
            sb.append(String.valueOf(key));
            sb.append("=");
            if (values.size() > 1)
            {
                sb.append("{");
                sb.append(StringUtilities.join(values, ","));
                sb.append("}");
            } else
            {
                sb.append(values.iterator().next().toString());
            }
            first = false;
        }
        sb.append("}");
        if (!map.isFullyPopulated())
            sb.append("+?");
        return sb.toString();
    }
}
