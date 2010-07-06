package edu.jhu.cs.bsj.compiler.impl.ast.node.list.knowledge;

import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.list.knowledge.SymbolicElement;

public abstract class AbstractSymbolicElementImpl<T extends Node> implements SymbolicElement<T>
{
	/**
	 * {@inheritDoc}
	 */
	public abstract String toString();
	
	/**
	 * {@inheritDoc}
	 */
	public abstract boolean equals(Object o);
	
	/**
	 * {@inheritDoc}
	 */
	public abstract int hashCode();
}
