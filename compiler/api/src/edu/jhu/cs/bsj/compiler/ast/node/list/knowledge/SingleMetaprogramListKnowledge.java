package edu.jhu.cs.bsj.compiler.ast.node.list.knowledge;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.NodeList;
import edu.jhu.cs.bsj.compiler.ast.node.Node;

/**
 * Represents a piece of conflict detection knowledge obtained by a {@link NodeList} during the execution of
 * metaprograms.
 * @author Zachary Palmer
 * @param <T> The type of element for the list which contains this knowledge.
 */
public interface SingleMetaprogramListKnowledge<T extends Node> extends ListKnowledge<T>
{
	/**
	 * The metaprogram which obtained this knowledge.
	 * @return A unique ID number which describes the metaprogram which learned this knowledge.
	 */
	public int getMetaprogramId();
	
	/**
	 * The source location of the metaprorgram which obtained this knowledge.
	 * @return The {@link BsjSourceLocation} which obtained this knowledge.
	 */
	public BsjSourceLocation getMetaprogramLocation();
}
