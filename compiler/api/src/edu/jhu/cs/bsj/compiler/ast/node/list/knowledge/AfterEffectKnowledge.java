package edu.jhu.cs.bsj.compiler.ast.node.list.knowledge;

import edu.jhu.cs.bsj.compiler.ast.node.Node;

/**
 * Represents knowledge which indicates that a metaprogram has caused an element to appear after another element in a
 * node list.
 * @author Zachary Palmer
 *
 * @param <T> The type of data stored in the list to which this knowledge pertains.
 */
public interface AfterEffectKnowledge<T extends Node> extends AfterKnowledge<T>, EffectKnowledge<T>
{
}
