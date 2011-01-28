package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.namespace;

import java.util.Map;
import java.util.WeakHashMap;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeOperation;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.util.BsjDefaultNodeOperation;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.namespace.map.EmptyNamespaceMap;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.namespace.map.NamespaceMap;
import edu.jhu.cs.bsj.compiler.lang.element.BsjElement;

/**
 * Calculates a particular type of namespace for a specified AST node. This operation caches its results; as a result,
 * it may begin to produce incorrect answers if the AST structurally changes after calculations have been performed.
 * 
 * @author Zachary Palmer
 */
public class NamespaceCalculatingOperation<K, V extends BsjElement> extends
		BsjDefaultNodeOperation<Void, NamespaceMap<K,V>>
{
	/** The operation which determines the environment parent for a node. */
	private BsjNodeOperation<Void, Node> parentLocator;
	/** The operation which applies modifications to a parent environment to produce a child environment. */
	private BsjNodeOperation<NamespaceMap<K,V>, ChildNamespaceProducer<K, V>> modifier;

	/** The cache for this operation. */
	private Map<Node, NamespaceMap<K,V>> cache;
	/** The cache from parent nodes to child namespace producers. */
	private Map<Node, ChildNamespaceProducer<K, V>> producerCache;

	public NamespaceCalculatingOperation(BsjNodeOperation<NamespaceMap<K,V>, ChildNamespaceProducer<K, V>> modifier)
	{
		super();
		this.modifier = modifier;

		this.parentLocator = new ParentEnvironmentNodeIdentifyingOperation();
		this.cache = new WeakHashMap<Node, NamespaceMap<K,V>>();
		this.producerCache = new WeakHashMap<Node, ChildNamespaceProducer<K, V>>();
	}

	@Override
	public NamespaceMap<K,V> executeDefault(Node node, Void p)
	{
	    NamespaceMap<K,V> namespace = this.cache.get(node);
		if (namespace == null)
		{
			// *** Actually calculate the environment.

			// Find the node which dictates which environment this node will have
			Node parentEnvironmentNode = node.executeOperation(this.parentLocator, null);

			if (parentEnvironmentNode == null)
			{
				// There is no parent environment; create a dummy blank one.
				namespace = EmptyNamespaceMap.instance();
			} else
			{
				// Find the parent environment
			    NamespaceMap<K,V> parentNamespace = parentEnvironmentNode.executeOperation(this, null);

				// Obtain the producer for this node - cached to prevent unnecessary replication
				ChildNamespaceProducer<K, V> producer = this.producerCache.get(parentEnvironmentNode);

				// If it wasn't in the cache, build it from the modifier
				if (producer == null)
				{
					// Apply changes to its environment as necessary
					producer = parentEnvironmentNode.executeOperation(this.modifier, parentNamespace);

					// Store this producer for later use
					this.producerCache.put(parentEnvironmentNode, producer);
				}

				// Get the appropriate namespace from the producer
				namespace = producer.getNamespaceFor(node);

				// Sanity check
				if (namespace == null)
				{
					throw new IllegalStateException("Parent namespace produced by node of type "
							+ parentEnvironmentNode.getClass() + " was null for child of type " + node.getClass());
				}
			}

			// Store the result
			this.cache.put(node, namespace);
		}

		return namespace;
	}
}
