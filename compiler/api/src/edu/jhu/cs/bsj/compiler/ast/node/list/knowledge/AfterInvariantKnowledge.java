package edu.jhu.cs.bsj.compiler.ast.node.list.knowledge;

import edu.jhu.cs.bsj.compiler.ast.node.Node;

/**
 * Indicates an invariant for a metaprogram that an element appear after another element.
 * @author Zachary Palmer
 *
 * @param <T> The type of data stored in the list to which this knowledge pertains.
 */
public interface AfterInvariantKnowledge<T extends Node> extends AfterKnowledge<T>, InvariantKnowledge<T>
{
}
