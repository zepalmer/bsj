package edu.jhu.cs.bsj.compiler.ast.node.list.knowledge;

import edu.jhu.cs.bsj.compiler.ast.node.Node;

/**
 * Represents knowledge which indicates an invariant of a metaprogram's execution.
 * @author Zachary Palmer
 *
 * @param <T> The type of data stored in the list to which this knowledge pertains.
 */
public interface InvariantKnowledge<T extends Node> extends SingleMetaprogramListKnowledge<T>
{
}
