package edu.jhu.cs.bsj.compiler.impl.tool.compiler.dependency;

import java.util.Collection;

/**
 * This data structure represents an injection conflict.
 * @author Zachary Palmer
 */
public class InjectionConflict
{
	/**
	 * The target which caused the conflict.
	 */
	private BipartiteNode<TargetNodeData, MetaprogramNodeData, EdgeData, EdgeData> target;
	/**
	 * The metaprogram over which the conflict occurred.
	 */
	private BipartiteNode<MetaprogramNodeData, TargetNodeData, EdgeData, EdgeData> injectedMetaprogram;
	/**
	 * The original metaprogram which is in conflict.
	 */
	private BipartiteNode<MetaprogramNodeData, TargetNodeData, EdgeData, EdgeData> conflictedMetaprogram;
	/**
	 * The candidates for removing the conflict.
	 */
	private Collection<BipartiteNode<MetaprogramNodeData, TargetNodeData, EdgeData, EdgeData>> conflictingMetaprograms;
	
	public InjectionConflict(BipartiteNode<TargetNodeData, MetaprogramNodeData, EdgeData, EdgeData> target,
			BipartiteNode<MetaprogramNodeData, TargetNodeData, EdgeData, EdgeData> injectedMetaprogram,
			BipartiteNode<MetaprogramNodeData, TargetNodeData, EdgeData, EdgeData> conflictedMetaprogram,
			Collection<BipartiteNode<MetaprogramNodeData, TargetNodeData, EdgeData, EdgeData>> conflictingMetaprograms)
	{
		super();
		this.target = target;
		this.injectedMetaprogram = injectedMetaprogram;
		this.conflictedMetaprogram = conflictedMetaprogram;
		this.conflictingMetaprograms = conflictingMetaprograms;
	}

	public BipartiteNode<TargetNodeData, MetaprogramNodeData, EdgeData, EdgeData> getTarget()
	{
		return target;
	}

	public BipartiteNode<MetaprogramNodeData, TargetNodeData, EdgeData, EdgeData> getInjectedMetaprogram()
	{
		return injectedMetaprogram;
	}

	public BipartiteNode<MetaprogramNodeData, TargetNodeData, EdgeData, EdgeData> getConflictedMetaprogram()
	{
		return conflictedMetaprogram;
	}

	public Collection<BipartiteNode<MetaprogramNodeData, TargetNodeData, EdgeData, EdgeData>> getConflictingMetaprograms()
	{
		return conflictingMetaprograms;
	}

	@Override
	public String toString()
	{
		return "InjectionConflict [conflictedMetaprogram=" + conflictedMetaprogram + ", conflictingMetaprograms="
				+ conflictingMetaprograms + ", injectedMetaprogram=" + injectedMetaprogram + ", target=" + target + "]";
	}
}
