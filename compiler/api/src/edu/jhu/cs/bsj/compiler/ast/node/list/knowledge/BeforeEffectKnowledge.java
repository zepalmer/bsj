package edu.jhu.cs.bsj.compiler.ast.node.list.knowledge;

import edu.jhu.cs.bsj.compiler.ast.node.Node;

/**
 * Indicates that a metaprogram has caused an element to appear before another.
 * @author Zachary Palmer
 *
 * @param <T> The type of data stored in the list to which this knowledge pertains.
 */
public interface BeforeEffectKnowledge<T extends Node> extends BeforeKnowledge<T>, EffectKnowledge<T>
{
}
