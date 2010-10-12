package edu.jhu.cs.bsj.compiler.impl.ast.node.list.knowledge;

import edu.jhu.cs.bsj.compiler.ast.NodeUnion;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.list.knowledge.ValueElement;

public class ValueElementImpl<T extends Node> extends AbstractSymbolicElementImpl<T> implements ValueElement<T>
{
	/** The data which is stored in this element. */
	private NodeUnion<? extends T> data;
	/** Whether or not the element is order-dependent. */
	private boolean orderDependent;
	
	public ValueElementImpl(NodeUnion<? extends T> data, boolean orderDependent)
	{
		super();
		this.data = data;
		this.orderDependent = orderDependent;
	}

	@Override
	public int hashCode()
	{
		final long nodeUid = this.data.getNodeValue().getUid();
		return ((int) nodeUid) ^ (int) (nodeUid >> 32);
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (getClass() != obj.getClass())
			return false;
		ValueElementImpl<?> other = (ValueElementImpl<?>) obj;
		return this.data.equals(other.data);
	}

	@Override
	public String toString()
	{
		return String.valueOf(this.data.getNodeValue().getUid());
	}

	@Override
	public NodeUnion<? extends T> getData()
	{
		return this.data;
	}

	@Override
	public boolean isOrderDependent()
	{
		return this.orderDependent;
	}
}
