package edu.jhu.cs.bsj.compiler.impl.ast.node.list.knowledge.source;

import java.util.List;

import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.list.knowledge.SymbolicElement;
import edu.jhu.cs.bsj.compiler.ast.node.list.knowledge.source.AddAfterOperationKnowledgeSource;

public class AddAfterOperationKnowledgeSourceImpl<T extends Node> extends OperationKnowledgeSourceImpl<T> implements AddAfterOperationKnowledgeSource<T>
{
	private SymbolicElement<T> anchor;
	private SymbolicElement<T> addition;
	
	public AddAfterOperationKnowledgeSourceImpl(List<StackTraceElement> stackTrace, SymbolicElement<T> anchor,
			SymbolicElement<T> addition)
	{
		super(stackTrace);
		this.anchor = anchor;
		this.addition = addition;
	}

	public SymbolicElement<T> getAnchor()
	{
		return this.anchor;
	}
	
	public SymbolicElement<T> getAddition()
	{
		return this.addition;
	}
}
