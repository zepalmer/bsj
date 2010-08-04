package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type;

import java.util.List;

import javax.lang.model.type.TypeMirror;
import javax.lang.model.type.TypeVariable;

import edu.jhu.cs.bsj.compiler.ast.node.ConstructorDeclarationNode;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.TypecheckerModelManager;

public class ConstructorExecutableTypeImpl extends AbstractInvokableExecutableTypeImpl<ConstructorDeclarationNode>
{
	public ConstructorExecutableTypeImpl(TypecheckerModelManager manager, ConstructorDeclarationNode backingNode)
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
	public List<? extends TypeMirror> getParameterTypes()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TypeMirror getReturnType()
	{
		return NoTypeImpl.makeVoid(getManager());
	}

	@Override
	public List<? extends TypeMirror> getThrownTypes()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<? extends TypeVariable> getTypeVariables()
	{
		// TODO Auto-generated method stub
		return null;
	}
}
