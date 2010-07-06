package edu.jhu.cs.bsj.compiler.impl.ast.node.list.knowledge.source;

import java.util.List;

import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.list.knowledge.SymbolicElement;
import edu.jhu.cs.bsj.compiler.ast.node.list.knowledge.source.GetBeforeOperationKnowledgeSource;

public class GetBeforeOperationKnowledgeSourceImpl<T extends Node> extends OperationKnowledgeSourceImpl<T> implements GetBeforeOperationKnowledgeSource<T>
{
	private SymbolicElement<T> anchor;
	private SymbolicElement<T> result;

	public GetBeforeOperationKnowledgeSourceImpl(List<StackTraceElement> stackTrace, SymbolicElement<T> anchor,
			SymbolicElement<T> result)
	{
		super(stackTrace);
		this.anchor = anchor;
		this.result = result;
	}

	public SymbolicElement<T> getAnchor()
	{
		return this.anchor;
	}
	
	public SymbolicElement<T> getResult()
	{
		return this.result;
	}
}
