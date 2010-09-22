package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.namespace;

import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.namespace.map.NamespaceMap;
import edu.jhu.cs.bsj.compiler.lang.element.BsjElement;

/**
 * This interface is used to generalize the concept of producing a namespace for each environment child of a given node.
 * Most nodes will produce the same environment for all of their children, but some nodes do not.  For instance, the
 * parameter of a for-each loop is only bound in the loop's body, but the iterable expression is one of the environment
 * children of the loop.  In such cases, a child namespace producer is returned which distinguishes between children.
 * @param <T>
 * @author Zachary Palmer
 */
public interface ChildNamespaceProducer<K, V extends BsjElement, T extends NamespaceMap<K,V>>
{
	/**
	 * Retrieves the namespace map appropriate to the specified child for this producer.
	 */
	public T getNamespaceFor(Node node);
}
