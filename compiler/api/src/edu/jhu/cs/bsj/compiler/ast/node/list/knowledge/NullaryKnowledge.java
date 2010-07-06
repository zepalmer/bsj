package edu.jhu.cs.bsj.compiler.ast.node.list.knowledge;

import edu.jhu.cs.bsj.compiler.ast.node.Node;

/**
 * Represents a unit of knowledge which requires no list element inputs.
 * @author Zachary Palmer
 * @param <T> The type of data stored in the list to which this knowledge pertains.
 */
public interface NullaryKnowledge<T extends Node> extends SingleMetaprogramListKnowledge<T>
{
}
