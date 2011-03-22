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
import edu.jhu.cs.bsj.compiler.lang.type.BsjType;
import edu.jhu.cs.bsj.compiler.lang.type.BsjTypeArgument;
import edu.jhu.cs.bsj.compiler.lang.type.BsjTypeVariable;

public abstract class AbstractInvokableExecutableTypeImpl<T extends AbstractInvokableDeclarationNode<?>> extends
		AbstractExecutableTypeImpl<T>
{
	private List<BsjType> parameterTypes;
	private List<String> parameterNames;
	private List<BsjType> thrownTypes;
	private List<BsjTypeVariable> typeVariables;

	public AbstractInvokableExecutableTypeImpl(TypecheckerManager manager, T backingNode)
	{
		this(manager, backingNode, Collections.<BsjTypeVariable, BsjTypeArgument> emptyMap());
	}

	public AbstractInvokableExecutableTypeImpl(TypecheckerManager manager, T backingNode,
			Map<BsjTypeVariable, BsjTypeArgument> substitutionMap)
	{
		super(manager, backingNode);
		this.parameterTypes = new ArrayList<BsjType>();
		this.parameterNames = new ArrayList<String>();
		this.thrownTypes = new ArrayList<BsjType>();
		this.typeVariables = new ArrayList<BsjTypeVariable>();

		// Eagerly compute the lists so we don't have to retain any reference to the replacement map.
		for (VariableNode var : getBackingNode().getParameters())
		{
			BsjType param = getTypeBuilder().makeType(var.getType());
			parameterTypes.add(param);
			parameterNames.add(var.getIdentifier().getIdentifier());
		}
		// TODO: consider - do we need a special representation for varargs?
		if (getBackingNode().getVarargParameter() != null)
		{
			VariableNode var = getBackingNode().getVarargParameter();
			// TODO: flag the array type to indicate that it is a vararg type?
			BsjType varargsParam = new ArrayTypeImpl(getManager(), getTypeBuilder().makeType(var.getType()));
			parameterTypes.add(varargsParam);
			parameterNames.add(var.getIdentifier().getIdentifier());
		}

		for (TypeNode type : getBackingNode().getThrowTypes())
		{
			thrownTypes.add(getTypeBuilder().makeType(type));
		}

		for (TypeParameterNode typeParameterNode : getBackingNode().getTypeParameters())
		{
			BsjTypeVariable var = getTypeBuilder().makeTypeVariable(typeParameterNode);
				typeVariables.add(var);
		}
		
		substitute(substitutionMap);
	}
	
	public AbstractInvokableExecutableTypeImpl(TypecheckerManager manager, T backingNode, List<BsjType> parameterTypes,
			List<BsjType> thrownTypes, List<BsjTypeVariable> typeVariables,Map<BsjTypeVariable, BsjTypeArgument> substitutionMap)
	{
		super(manager, backingNode);
		this.parameterTypes = parameterTypes;
		this.thrownTypes = thrownTypes;
		this.typeVariables = typeVariables;
		substitute(substitutionMap);
	}
	
	private void substitute(Map<BsjTypeVariable, BsjTypeArgument> substitutionMap)
	{
		// Substitute for parameters
		ListIterator<BsjType> typeIt = this.parameterTypes.listIterator();
		while (typeIt.hasNext())
		{
			typeIt.set(typeIt.next().performTypeSubstitution(substitutionMap));
		}
		
		// Remove the replaced type variables from the standing type variables of this invokable type
		boolean removal = false;
		ListIterator<BsjTypeVariable> typeVarIt = this.typeVariables.listIterator();
		while (typeVarIt.hasNext())
		{
			BsjTypeVariable var = typeVarIt.next();
			BsjType repl = var.performTypeSubstitution(substitutionMap);
			if (repl instanceof BsjTypeVariable)
			{
				typeVarIt.set((BsjTypeVariable)repl);
			} else
			{
				typeVarIt.remove();
				removal = true;
			}
		}

		// Sanity check
		if (removal && this.typeVariables.size() > 0)
		{
			// We partially instantiated the type of this invokable without fully instantiating it.
			throw new IllegalStateException("Replacement of variables did not replace " + this.typeVariables
					+ " with map " + substitutionMap);
		}
	}

	@Override
	public List<? extends BsjType> getParameterTypes()
	{
		return this.parameterTypes;
	}

	@Override
    public List<String> getParameterNames()
    {
        return this.parameterNames;
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
