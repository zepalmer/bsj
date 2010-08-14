package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.namespace;

import java.util.HashMap;
import java.util.Map;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeOperation;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeOperation2Arguments;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.util.BsjDefaultNodeOperation;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.element.api.BsjElement;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.namespace.map.NamespaceMap;

/**
 * Calculates a particular type of namespace for a specified AST node.  This operation caches its results; as a result,
 * it may begin to produce incorrect answers if the AST structurally changes after calculations have been performed.
 * @author Zachary Palmer
 */
public abstract class NamespaceCalculatingOperation<K, V extends BsjElement, T extends NamespaceMap<K, V>> extends BsjDefaultNodeOperation<Void, T>
{
	/** The operation which determines the environment parent for a node. */
	private BsjNodeOperation<Void,Node> parentLocator;
	/** The operation which applies modifications to a parent environment to produce a child environment. */
	private BsjNodeOperation2Arguments<T, Node, T> modifier;
	
	/** The cache for this operation. */
	private Map<Node,T> cache;

	public NamespaceCalculatingOperation(BsjNodeOperation2Arguments<T, Node, T> modifier)
	{
		super();
		this.modifier = modifier;
		
		this.parentLocator = new ParentEnvironmentNodeIdentifyingOperation();
		this.cache = new HashMap<Node,T>();
	}
	
	/**
	 * Creates a new, empty namespace.
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

				// Apply changes to its environment as necessary
				namespace = parentEnvironmentNode.executeOperation(this.modifier, parentNamespace, node);

				// Sanity check
				if (namespace == null)
				{
					throw new IllegalStateException("Parent namespace produced by node of type "
							+ parentEnvironmentNode.getClass() + " was null for child of type " + node.getClass());
				}

				// Lock the environment to ensure that it does not change
				namespace.lock();

				// Reduce the environment if possible
				if (namespace.definitelyReplacableBy(parentNamespace))
				{
					namespace = parentNamespace;
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
