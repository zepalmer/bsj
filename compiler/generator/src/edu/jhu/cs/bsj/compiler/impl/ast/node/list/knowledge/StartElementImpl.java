package edu.jhu.cs.bsj.compiler.impl.ast.node.list.knowledge;

import edu.jhu.cs.bsj.compiler.ast.NodeUnion;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.list.knowledge.StartElement;

public class StartElementImpl<T extends Node> extends AbstractSymbolicElementImpl<T> implements StartElement<T>
{
	@Override
	public int hashCode()
	{
		return -1;
	}

	@Override
	public boolean equals(Object obj)
	{
		return getClass() == obj.getClass();
	}

	@Override
	public String toString()
	{
		return "▷";
	}
	
	@Override
	public NodeUnion<? extends T> getData()
	{
		return null;
	}

	@Override
	public boolean isOrderDependent()
	{
		return false;
	}
}
