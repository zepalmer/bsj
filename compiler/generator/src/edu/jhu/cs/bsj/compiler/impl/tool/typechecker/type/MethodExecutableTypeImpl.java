package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type;

import edu.jhu.cs.bsj.compiler.ast.node.MethodDeclarationNode;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.TypecheckerModelManager;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.api.BsjType;

public class MethodExecutableTypeImpl extends AbstractInvokableExecutableTypeImpl<MethodDeclarationNode>
{
	public MethodExecutableTypeImpl(TypecheckerModelManager manager, MethodDeclarationNode backingNode)
	{
		super(manager, backingNode);
	}

	@Override
	public BsjType getReturnType()
	{
		return getTypeBuilder().makeType(getBackingNode().getReturnType());
	}
}
