package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type;

import javax.lang.model.type.TypeMirror;

import edu.jhu.cs.bsj.compiler.ast.node.MethodDeclarationNode;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.TypecheckerModelManager;

public class MethodExecutableTypeImpl extends AbstractInvokableExecutableTypeImpl<MethodDeclarationNode>
{
	public MethodExecutableTypeImpl(TypecheckerModelManager manager, MethodDeclarationNode backingNode)
	{
		super(manager, backingNode);
	}

	@Override
	public String toString()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TypeMirror getReturnType()
	{
		return getTypeBuilder().makeType(getBackingNode().getReturnType());
	}
}
