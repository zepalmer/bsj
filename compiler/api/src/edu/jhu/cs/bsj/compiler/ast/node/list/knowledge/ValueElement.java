package edu.jhu.cs.bsj.compiler.ast.node.list.knowledge;

import edu.jhu.cs.bsj.compiler.ast.node.Node;

/**
 * This symbolic element represents a unit of data inside of a list.
 * @author Zachary Palmer
 * @param <T> The type of data contained in this element's list.
 */
public interface ValueElement<T extends Node> extends SymbolicElement<T>
{
}
