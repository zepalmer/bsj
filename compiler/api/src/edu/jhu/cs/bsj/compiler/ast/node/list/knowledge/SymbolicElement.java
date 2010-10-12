package edu.jhu.cs.bsj.compiler.ast.node.list.knowledge;

import edu.jhu.cs.bsj.compiler.ast.NodeUnion;
import edu.jhu.cs.bsj.compiler.ast.node.Node;

/**
 * This interface represents a symbolic element in a node list.  A symbolic element is either a real element (an
 * element which is actually contained in the list), a symbol representing the start of the list, or a symbol
 * representing the end of the list.
 * @author Zachary Palmer
 * @param <T> The type of data which is contained in the list for which this symbolic element is a member.
 */
public interface SymbolicElement<T extends Node>
{
	/**
	 * Retrieves the data contained in this symbolic element.  If no list data is actually contained by this
	 * element, <code>null</code> is returned.
	 * @return The data contained in this symbolic element.
	 */
	public NodeUnion<? extends T> getData();
	
	/**
	 * Determines whether or not this element is order-dependent.
	 * @return <code>true</code> if this element is order-dependent; <code>false</code> if it is not.
	 */
	public boolean isOrderDependent();
}
