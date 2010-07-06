package edu.jhu.cs.bsj.compiler.impl.ast.node.list.knowledge.source;

import java.util.List;

import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.list.knowledge.SymbolicElement;
import edu.jhu.cs.bsj.compiler.ast.node.list.knowledge.source.RemoveOperationKnowledgeSource;

public class RemoveOperationKnowledgeSourceImpl<T extends Node> extends OperationKnowledgeSourceImpl<T> implements RemoveOperationKnowledgeSource<T>
{
	private SymbolicElement<T> element;
	
	public RemoveOperationKnowledgeSourceImpl(List<StackTraceElement> stackTrace, SymbolicElement<T> element)
	{
		super(stackTrace);
		this.element = element;
	}

	public SymbolicElement<T> getElement()
	{
		return this.element;
	}
}
