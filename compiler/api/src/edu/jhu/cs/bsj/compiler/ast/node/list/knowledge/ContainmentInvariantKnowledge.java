package edu.jhu.cs.bsj.compiler.ast.node.list.knowledge;

import edu.jhu.cs.bsj.compiler.ast.node.Node;

/**
 * Represents knowledge indicating that a metaprogram has learned one of the contents of the list.
 * @author Zachary Palmer
 *
 * @param <T> The type of data stored in the list to which this knowledge pertains.
 */
public interface ContainmentInvariantKnowledge<T extends Node> extends ContainmentKnowledge<T>, InvariantKnowledge<T>
{
}
