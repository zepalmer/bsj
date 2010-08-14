package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.namespace;

import java.util.HashMap;
import java.util.Map;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeOperation;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.util.BsjDefaultNodeOperation;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.element.api.BsjElement;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.namespace.map.NamespaceMap;

/**
 * Calculates a particular type of namespace for a specified AST node. This operation caches its results; as a result,
 * it may begin to produce incorrect answers if the AST structurally changes after calculations have been performed.
 * 
 * @author Zachary Palmer
 */
public abstract class NamespaceCalculatingOperation<K, V extends BsjElement, T extends NamespaceMap<K, V>> extends
		BsjDefaultNodeOperation<Void, T>
{
	/** The operation which determines the environment parent for a node. */
	private BsjNodeOperation<Void, Node> parentLocator;
	/** The operation which applies modifications to a parent environment to produce a child environment. */
	private BsjNodeOperation<T, ChildNamespaceProducer<K, V, T>> modifier;

	/** The cache for this operation. */
	private Map<Node, T> cache;
	/** The cache from parent nodes to child namespace producers. */
	private Map<Node, ChildNamespaceProducer<K, V, T>> producerCache;

	public NamespaceCalculatingOperation(BsjNodeOperation<T, ChildNamespaceProducer<K, V, T>> modifier)
	{
		super();
		this.modifier = modifier;

		this.parentLocator = new ParentEnvironmentNodeIdentifyingOperation();
		this.cache = new HashMap<Node, T>();
		this.producerCache = new HashMap<Node, ChildNamespaceProducer<K, V, T>>();
	}

	/**
	 * Creates a new, empty namespace.
	 * 
	 * @return The new, empty namespace.
	 */
	protected abstract T createEmpty();

	@Override
	public T executeDefault(Node node, Void p)
	{
		T namespace = this.cache.get(node);
		if (namespace == null)
		{
			// *** Actually calculate the environment.

			// Find the node which dictates which environment this node will have
			Node parentEnvironmentNode = node.executeOperation(this.parentLocator, null);

			if (parentEnvironmentNode == null)
			{
				// There is no parent environment; create a dummy blank one.
				namespace = createEmpty();
			} else
			{
				// Find the parent environment
				T parentNamespace = parentEnvironmentNode.executeOperation(this, null);

				// Obtain the producer for this node - cached to prevent unnecessary replication
				ChildNamespaceProducer<K, V, T> producer = this.producerCache.get(parentEnvironmentNode);

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

				// Lock the namespace to ensure that it does not change
				namespace.lock();

				// Make sure that the namespace is really useful
				if (namespace.definitelyReplacableBy(parentNamespace))
				{
					namespace = parentNamespace;
					// Optimization - make sure we don't hang onto namespaces we don't need in the producers
					if (producer instanceof ConsistentChildNamespaceProducer<?, ?, ?>)
					{
						this.producerCache.put(parentEnvironmentNode, new ConsistentChildNamespaceProducer<K, V, T>(
								parentNamespace));
					}
				}
			}

			// Store the result
			this.cache.put(node, namespace);

			// Report ambiguities if any are found
			namespace.checkAmbiguities();
		}

		return namespace;
	}
}
