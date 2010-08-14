package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.namespace;

import java.util.Map;

import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.element.api.BsjElement;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.namespace.map.NamespaceMap;

/**
 * This child namespace producer returns a namespace from a given mapping.  If the child node is not in the mapping, a
 * default namespace is returned instead.
 * @author Zachary Palmer
 *
 * @param <T>
 */
public class MappedChildNamespaceProducer<K, V extends BsjElement, T extends NamespaceMap<K, V>> implements ChildNamespaceProducer<K, V, T>
{
	/** The default namespace. */
	private T defaultNamespace;
	/** The namespace mapping. */
	private Map<Node, T> namespaceMapping;
	
	public MappedChildNamespaceProducer(T defaultNamespace, Map<Node, T> namespaceMapping)
	{
		super();
		this.defaultNamespace = defaultNamespace;
		this.namespaceMapping = namespaceMapping;
	}

	@Override
	public T getNamespaceFor(Node node)
	{
		T namespace = this.namespaceMapping.get(node);
		if (namespace == null)
		{
			return this.defaultNamespace;
		} else
		{
			return namespace;
		}
	}
}
