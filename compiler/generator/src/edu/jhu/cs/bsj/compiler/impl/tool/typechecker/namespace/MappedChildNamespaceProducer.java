package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.namespace;

import java.util.Map;

import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.namespace.map.NamespaceMap;
import edu.jhu.cs.bsj.compiler.lang.element.BsjElement;

/**
 * This child namespace producer returns a namespace from a given mapping.  If the child node is not in the mapping, a
 * default namespace is returned instead.
 * @author Zachary Palmer
 *
 * @param <T>
 */
public class MappedChildNamespaceProducer<K, V extends BsjElement> implements ChildNamespaceProducer<K, V>
{
	/** The default namespace. */
	private NamespaceMap<K, V> defaultNamespace;
	/** The namespace mapping. */
	private Map<Node, NamespaceMap<K, V>> namespaceMapping;
	
	public MappedChildNamespaceProducer(NamespaceMap<K, V> defaultNamespace, Map<Node, NamespaceMap<K, V>> namespaceMapping)
	{
		super();
		this.defaultNamespace = defaultNamespace;
		this.namespaceMapping = namespaceMapping;
	}

	@Override
	public NamespaceMap<K, V> getNamespaceFor(Node node)
	{
	    NamespaceMap<K, V> namespace = this.namespaceMapping.get(node);
		if (namespace == null)
		{
			return this.defaultNamespace;
		} else
		{
			return namespace;
		}
	}
}
