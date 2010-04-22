package edu.jhu.cs.bsj.compiler.impl.tool.compiler.dependency;

/**
 * This is the type of data associated with an edge leaving a target node.
 * @author Zachary Palmer
 */
public class TargetEdgeData extends EdgeData
{
	public TargetEdgeData(boolean inferred)
	{
		super(inferred);
	}

	@Override
	public String toString()
	{
		return "TargetEdgeData [inferred=" + isInferred() + "]";
	}
}
