package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import edu.jhu.cs.bsj.compiler.ast.node.AbstractInvokableDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.TypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.TypeParameterNode;
import edu.jhu.cs.bsj.compiler.ast.node.VariableNode;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.TypecheckerManager;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.api.BsjType;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.api.BsjTypeArgument;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.api.BsjTypeVariable;

public abstract class AbstractInvokableExecutableTypeImpl<T extends AbstractInvokableDeclarationNode<?>> extends
		AbstractExecutableTypeImpl<T>
{
	private List<BsjType> parameterTypes;
	private List<BsjType> thrownTypes;
	private List<BsjTypeVariable> typeVariables;

	public AbstractInvokableExecutableTypeImpl(TypecheckerManager manager, T backingNode)
	{
		this(manager, backingNode, Collections.<BsjTypeVariable, BsjTypeArgument> emptyMap());
	}

	public AbstractInvokableExecutableTypeImpl(TypecheckerManager manager, T backingNode,
			Map<BsjTypeVariable, BsjTypeArgument> replacementMap)
	{
		super(manager, backingNode);
		this.parameterTypes = new ArrayList<BsjType>();
		this.thrownTypes = new ArrayList<BsjType>();
		this.typeVariables = new ArrayList<BsjTypeVariable>();

		// Eagerly compute the lists so we don't have to retain any reference to the replacement map.
		for (VariableNode var : getBackingNode().getParameters())
		{
			parameterTypes.add(getTypeBuilder().makeType(var.getType()));
		}
		// TODO: consider - do we need a special representation for varargs?
		if (getBackingNode().getVarargParameter() != null)
		{
			VariableNode var = getBackingNode().getVarargParameter();
			// TODO: flag the array type to indicate that it is a vararg type?
			parameterTypes.add(new ArrayTypeImpl(getManager(), getTypeBuilder().makeType(var.getType())));
		}

		for (TypeNode type : getBackingNode().getThrowTypes())
		{
			thrownTypes.add(getTypeBuilder().makeType(type));
		}

		for (TypeParameterNode typeParameterNode : getBackingNode().getTypeParameters())
		{
			typeVariables.add(getTypeBuilder().makeTypeVariable(typeParameterNode));
		}

		// Perform replacement as necessary
		ListIterator<BsjType> iterator = this.parameterTypes.listIterator();
		while (iterator.hasNext())
		{
			BsjType type = iterator.next();
			if (replacementMap.containsKey(type))
			{
				iterator.set(replacementMap.get(type));
			}
		}

		// Remove the replaced type variables from the standing type variables of this invokable type
		boolean removal = false;
		ListIterator<BsjTypeVariable> varIterator = this.typeVariables.listIterator();
		while (varIterator.hasNext())
		{
			if (replacementMap.containsKey(varIterator.next()))
			{
				removal = true;
				varIterator.remove();
			}
		}

		// Sanity check
		if (removal && this.typeVariables.size() > 0)
		{
			// We partially instantiated the type of this invokable without fully instantiating it.
			throw new IllegalStateException("Replacement of variables did not replace " + this.typeVariables
					+ " with map " + replacementMap);
		}
	}

	@Override
	public List<? extends BsjType> getParameterTypes()
	{
		return this.parameterTypes;
	}

	@Override
	public List<? extends BsjType> getThrownTypes()
	{
		return this.thrownTypes;
	}

	@Override
	public List<? extends BsjTypeVariable> getTypeVariables()
	{
		return this.typeVariables;
	}
}
