package edu.jhu.cs.bsj.compiler.ast.node.list.knowledge;

import edu.jhu.cs.bsj.compiler.ast.node.Node;

/**
 * Represents an invariant for a metaprogram that an element appear before another element.
 * @author Zachary Palmer
 *
 * @param <T> The type of data stored in the list to which this knowledge pertains.
 */
public interface BeforeInvariantKnowledge<T extends Node> extends BeforeKnowledge<T>, InvariantKnowledge<T>
{
}
