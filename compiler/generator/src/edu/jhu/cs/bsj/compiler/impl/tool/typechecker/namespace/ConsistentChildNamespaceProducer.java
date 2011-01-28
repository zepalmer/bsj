package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.namespace;

import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.namespace.map.NamespaceMap;
import edu.jhu.cs.bsj.compiler.lang.element.BsjElement;

/**
 * This child namespace producer always returns the same namespace regardless of which child is provided.
 * 
 * @author Zachary Palmer
 * 
 * @param <T>
 */
public class ConsistentChildNamespaceProducer<K, V extends BsjElement> implements
		ChildNamespaceProducer<K, V>
{
	/** The namespace returned by this producer. */
	private NamespaceMap<K,V> namespace;

	public ConsistentChildNamespaceProducer(NamespaceMap<K,V> namespace)
	{
		super();
		this.namespace = namespace;
	}

	@Override
	public NamespaceMap<K,V> getNamespaceFor(Node node)
	{
		return this.namespace;
	}
}
