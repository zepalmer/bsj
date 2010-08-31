package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type;

import edu.jhu.cs.bsj.compiler.ast.node.ConstructorDeclarationNode;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.TypecheckerManager;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.api.BsjType;

public class ConstructorExecutableTypeImpl extends AbstractInvokableExecutableTypeImpl<ConstructorDeclarationNode>
{
	public ConstructorExecutableTypeImpl(TypecheckerManager manager, ConstructorDeclarationNode backingNode)
	{
		super(manager, backingNode);
	}

	@Override
	public BsjType getReturnType()
	{
		return new VoidPseudoTypeImpl(getManager());
	}
}
