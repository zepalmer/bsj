package edu.jhu.cs.bsj.compiler.impl.ast.node.list.knowledge.source;

import java.util.Collections;
import java.util.List;

import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.list.knowledge.source.OperationKnowledgeSource;

public abstract class OperationKnowledgeSourceImpl<T extends Node> extends KnowledgeSourceImpl<T> implements OperationKnowledgeSource<T>
{
	private List<StackTraceElement> stackTrace;
	
	public OperationKnowledgeSourceImpl(List<StackTraceElement> stackTrace)
	{
		super();
		this.stackTrace = Collections.unmodifiableList(stackTrace);
	}

	public List<StackTraceElement> getStackTrace()
	{
		return this.stackTrace;
	}
}
