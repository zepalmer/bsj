package edu.jhu.cs.bsj.compiler.impl.ast.node.list.knowledge;

import edu.jhu.cs.bsj.compiler.ast.NodeUnion;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.list.knowledge.EndElement;

public class EndElementImpl<T extends Node> extends AbstractSymbolicElementImpl<T> implements EndElement<T>
{
	@Override
	public int hashCode()
	{
		return -2;
	}

	@Override
	public boolean equals(Object obj)
	{
		return getClass() == obj.getClass();
	}

	@Override
	public String toString()
	{
		return "◁";
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
