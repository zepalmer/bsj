package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type;

import java.util.ArrayList;
import java.util.List;

import javax.lang.model.type.TypeMirror;
import javax.lang.model.type.TypeVariable;

import edu.jhu.cs.bsj.compiler.ast.node.AbstractInvokableDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.TypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.VariableNode;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.TypecheckerModelManager;

public abstract class AbstractInvokableExecutableTypeImpl<T extends AbstractInvokableDeclarationNode<?>> extends
		AbstractExecutableTypeImpl<T>
{
	public AbstractInvokableExecutableTypeImpl(TypecheckerModelManager manager, T backingNode)
	{
		super(manager, backingNode);
	}

	@Override
	public List<? extends TypeMirror> getParameterTypes()
	{
		List<TypeMirror> list = new ArrayList<TypeMirror>();
		for (VariableNode var : getBackingNode().getParameters())
		{
			list.add(getTypeBuilder().makeType(var.getType()));
		}
		// TODO: consider - do we need a special representation for varargs?
		if (getBackingNode().getVarargParameter() != null)
		{
			VariableNode var = getBackingNode().getVarargParameter();
			// TODO: flag the array type to indicate that it is a vararg type?
			list.add(new ArrayTypeImpl(getManager(), getTypeBuilder().makeType(var.getType())));
		}
		return list;
	}

	@Override
	public List<? extends TypeMirror> getThrownTypes()
	{
		List<TypeMirror> list = new ArrayList<TypeMirror>();
		for (TypeNode type : getBackingNode().getThrowTypes())
		{
			list.add(getTypeBuilder().makeType(type));
		}
		return null;
	}

	@Override
	public List<? extends TypeVariable> getTypeVariables()
	{
		// TODO Auto-generated method stub
		return null;
	}
}
