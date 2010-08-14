package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.namespace;

import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.element.api.BsjElement;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.namespace.map.NamespaceMap;

/**
 * This child namespace producer always returns the same namespace regardless of which child is provided.
 * 
 * @author Zachary Palmer
 * 
 * @param <T>
 */
public class ConsistentChildNamespaceProducer<K, V extends BsjElement, T extends NamespaceMap<K, V>> implements
		ChildNamespaceProducer<K, V, T>
{
	/** The namespace returned by this producer. */
	private T namespace;

	public ConsistentChildNamespaceProducer(T namespace)
	{
		super();
		this.namespace = namespace;
	}

	@Override
	public T getNamespaceFor(Node node)
	{
		return this.namespace;
	}
}
