package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.namespace;

import java.util.HashMap;
import java.util.Map;

import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.namespace.map.NamespaceMap;
import edu.jhu.cs.bsj.compiler.impl.utils.function.Function;
import edu.jhu.cs.bsj.compiler.lang.element.BsjElement;

/**
 * This child namespace producer returns a namespace from a given mapping.  If the child node is not in the mapping, a
 * default namespace is returned instead.
 * @author Zachary Palmer
 *
 * @param <T>
 */
public class LazilyMappedChildNamespaceProducer<K, V extends BsjElement, T extends NamespaceMap<K, V>> implements ChildNamespaceProducer<K, V, T>
{
	/** The default namespace. */
	private T defaultNamespace;
	/** The namespace mapping. */
	private Map<Node, Function<Void, T>> namespaceMapping;
	/** The map containing retrieved values. */
	private Map<Node, T> evaluatedMapping;
	
	public LazilyMappedChildNamespaceProducer(T defaultNamespace, Map<Node, Function<Void,T>> namespaceMapping)
	{
		super();
		this.defaultNamespace = defaultNamespace;
		this.namespaceMapping = namespaceMapping;
		this.evaluatedMapping = new HashMap<Node, T>();
	}

	@Override
	public T getNamespaceFor(Node node)
	{
		T namespace;
		if (!this.evaluatedMapping.containsKey(node))
		{
			Function<Void,T> thunk = this.namespaceMapping.get(node);
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
