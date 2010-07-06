package edu.jhu.cs.bsj.compiler.ast.node.list.knowledge;

import edu.jhu.cs.bsj.compiler.ast.node.Node;

/**
 * Represents knowledge which relates to an element appearing before another element in the list.
 * @author Zachary Palmer
 *
 * @param <T> The type of data stored in the list to which this knowledge pertains.
 */
public interface AfterKnowledge<T extends Node> extends BinaryRelativeKnowledge<T>
{
}
