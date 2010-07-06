package edu.jhu.cs.bsj.compiler.ast.node.list.knowledge;

import edu.jhu.cs.bsj.compiler.ast.node.Node;

/**
 * Represents knowledge which indicates that a metaprogram has made some change to the list.
 * @author Zachary Palmer
 *
 * @param <T> The type of data stored in the list to which this knowledge pertains.
 */
public interface EffectKnowledge<T extends Node> extends SingleMetaprogramListKnowledge<T>
{
}
