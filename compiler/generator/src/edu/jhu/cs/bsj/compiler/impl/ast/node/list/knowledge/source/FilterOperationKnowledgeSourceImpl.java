package edu.jhu.cs.bsj.compiler.impl.ast.node.list.knowledge.source;

import java.util.List;

import edu.jhu.cs.bsj.compiler.ast.NodeUnionFilter;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.list.knowledge.source.FilterOperationKnowledgeSource;

public class FilterOperationKnowledgeSourceImpl<T extends Node> extends OperationKnowledgeSourceImpl<T> implements FilterOperationKnowledgeSource<T>
{
	private NodeUnionFilter<? super T> filter;
	
	public FilterOperationKnowledgeSourceImpl(List<StackTraceElement> stackTrace, NodeUnionFilter<? super T> filter)
	{
		super(stackTrace);
		this.filter = filter;
	}

	public NodeUnionFilter<? super T> getFilter()
	{
		return this.filter;
	}
}
