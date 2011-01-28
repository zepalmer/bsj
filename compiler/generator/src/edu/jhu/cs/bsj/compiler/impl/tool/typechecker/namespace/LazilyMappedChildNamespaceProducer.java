package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.namespace;

import java.util.HashMap;
import java.util.Map;

import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.namespace.map.NamespaceMap;
import edu.jhu.cs.bsj.compiler.impl.utils.function.Function;
import edu.jhu.cs.bsj.compiler.impl.utils.function.Thunk;
import edu.jhu.cs.bsj.compiler.lang.element.BsjElement;

/**
 * This child namespace producer returns a namespace from a given mapping.  If the child node is not in the mapping, a
 * default namespace is returned instead.
 * @author Zachary Palmer
 *
 * @param <T>
 */
public class LazilyMappedChildNamespaceProducer<K, V extends BsjElement> implements ChildNamespaceProducer<K, V>
{
	/** The default namespace. */
	private NamespaceMap<K,V> defaultNamespace;
	/** The namespace mapping. */
	private Map<Node, Thunk<NamespaceMap<K,V>>> namespaceMapping;
	/** The map containing retrieved values. */
	private Map<Node, NamespaceMap<K,V>> evaluatedMapping;
	
	public LazilyMappedChildNamespaceProducer(NamespaceMap<K,V> defaultNamespace, Map<Node, Thunk<NamespaceMap<K,V>>> namespaceMapping)
	{
		super();
		this.defaultNamespace = defaultNamespace;
		this.namespaceMapping = namespaceMapping;
		this.evaluatedMapping = new HashMap<Node, NamespaceMap<K,V>>();
	}

	@Override
	public NamespaceMap<K,V> getNamespaceFor(Node node)
	{
	    NamespaceMap<K,V> namespace;
		if (!this.evaluatedMapping.containsKey(node))
		{
			Function<Void,NamespaceMap<K,V>> thunk = this.namespaceMapping.get(node);
			if (thunk == null)
			{
				namespace = this.defaultNamespace;
			} else
			{
				namespace = thunk.execute(null);
			}
			this.evaluatedMapping.put(node, namespace);
		} else
		{
			namespace = this.evaluatedMapping.get(node);
		}
		return namespace;
	}
}
