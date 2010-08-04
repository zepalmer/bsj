package edu.jhu.cs.bsj.compiler.impl.operations;

import java.util.List;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.node.NameNode;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.util.BsjDefaultNodeOperation;

public class EnclosingNameNodeOperation extends BsjDefaultNodeOperation<Void, NameNode>
{
	/** The node factory to use when creating the name.  If <code>null</code>, no node is created. */
	private BsjNodeFactory factory;

	public EnclosingNameNodeOperation(BsjNodeFactory factory)
	{
		super();
		this.factory = factory;
	}

	@Override
	public NameNode executeDefault(Node node, Void p)
	{
		EnclosingNameOperation op = new EnclosingNameOperation();
		List<String> components = node.executeOperation(op, null);
		
		NameNode ret = null;
		for (String component : components)
		{
			if (ret == null)
			{
				ret = factory.makeSimpleNameNode(factory.makeIdentifierNode(component));
			} else
			{
				ret = factory.makeQualifiedNameNode(ret, factory.makeIdentifierNode(component));
			}
		}
		return ret;
	}
}
