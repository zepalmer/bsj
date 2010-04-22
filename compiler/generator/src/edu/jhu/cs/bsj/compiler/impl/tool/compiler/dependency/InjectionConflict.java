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
	private BipartiteNode<TargetNodeData, MetaprogramNodeData, TargetEdgeData, MetaprogramEdgeData> target;
	/**
	 * The metaprogram over which the conflict occurred.
	 */
	private BipartiteNode<MetaprogramNodeData, TargetNodeData, MetaprogramEdgeData, TargetEdgeData> injectedMetaprogram;
	/**
	 * The original metaprogram which is in conflict.
	 */
	private BipartiteNode<MetaprogramNodeData, TargetNodeData, MetaprogramEdgeData, TargetEdgeData> conflictedMetaprogram;
	/**
	 * The candidates for removing the conflict.
	 */
	private Collection<BipartiteNode<MetaprogramNodeData, TargetNodeData, MetaprogramEdgeData, TargetEdgeData>> conflictingMetaprograms;
	
	public InjectionConflict(BipartiteNode<TargetNodeData, MetaprogramNodeData, TargetEdgeData, MetaprogramEdgeData> target,
			BipartiteNode<MetaprogramNodeData, TargetNodeData, MetaprogramEdgeData, TargetEdgeData> injectedMetaprogram,
			BipartiteNode<MetaprogramNodeData, TargetNodeData, MetaprogramEdgeData, TargetEdgeData> conflictedMetaprogram,
			Collection<BipartiteNode<MetaprogramNodeData, TargetNodeData, MetaprogramEdgeData, TargetEdgeData>> conflictingMetaprograms)
	{
		super();
		this.target = target;
		this.injectedMetaprogram = injectedMetaprogram;
		this.conflictedMetaprogram = conflictedMetaprogram;
		this.conflictingMetaprograms = conflictingMetaprograms;
	}

	public BipartiteNode<TargetNodeData, MetaprogramNodeData, TargetEdgeData, MetaprogramEdgeData> getTarget()
	{
		return target;
	}

	public BipartiteNode<MetaprogramNodeData, TargetNodeData, MetaprogramEdgeData, TargetEdgeData> getInjectedMetaprogram()
	{
		return injectedMetaprogram;
	}

	public BipartiteNode<MetaprogramNodeData, TargetNodeData, MetaprogramEdgeData, TargetEdgeData> getConflictedMetaprogram()
	{
		return conflictedMetaprogram;
	}

	public Collection<BipartiteNode<MetaprogramNodeData, TargetNodeData, MetaprogramEdgeData, TargetEdgeData>> getConflictingMetaprograms()
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
