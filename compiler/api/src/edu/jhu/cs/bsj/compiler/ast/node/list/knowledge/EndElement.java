package edu.jhu.cs.bsj.compiler.ast.node.list.knowledge;

import edu.jhu.cs.bsj.compiler.ast.node.Node;

/**
 * This symbolic element type represents the end element of a list.
 * @author Zachary Palmer
 * @param <T> The type of data contained in this element's list.
 */
public interface EndElement<T extends Node> extends SymbolicElement<T>
{
}
