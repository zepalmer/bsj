package edu.jhu.cs.bsj.compiler.ast.node.list.knowledge;

import edu.jhu.cs.bsj.compiler.ast.node.Node;

/**
 * Represents knowledge which represents that a metaprogram has either added an element to the list or removed an
 * element from it.
 * @author Zachary Palmer
 *
 * @param <T> The type of data stored in the list to which this knowledge pertains.
 */
public interface ContainmentEffectKnowledge<T extends Node> extends ContainmentKnowledge<T>, EffectKnowledge<T>
{
}
