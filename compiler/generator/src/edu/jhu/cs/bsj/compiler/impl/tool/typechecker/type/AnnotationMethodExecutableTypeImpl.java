package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import edu.jhu.cs.bsj.compiler.ast.node.AnnotationMethodDeclarationNode;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.TypecheckerManager;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.api.BsjExecutableType;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.api.BsjType;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.api.BsjTypeArgument;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.api.BsjTypeVariable;

public class AnnotationMethodExecutableTypeImpl extends AbstractExecutableTypeImpl<AnnotationMethodDeclarationNode>
{
	public AnnotationMethodExecutableTypeImpl(TypecheckerManager manager,
			AnnotationMethodDeclarationNode backingNode)
	{
		super(manager, backingNode);
	}

	@Override
	public List<? extends BsjType> getParameterTypes()
	{
		return Collections.emptyList();
	}

	@Override
	public BsjType getReturnType()
	{
		return getTypeBuilder().makeType(getBackingNode().getType());
	}

	@Override
	public List<? extends BsjType> getThrownTypes()
	{
		return Collections.emptyList();
	}

	@Override
	public List<? extends BsjTypeVariable> getTypeVariables()
	{
		return Collections.emptyList();
	}

	@Override
	public BsjExecutableType performTypeSubstitution(Map<BsjTypeVariable, BsjTypeArgument> substitutionMap)
	{
		// Annotation methods cannot legally use type parameters in their return types.
		return this;
	}

	@Override
	public boolean isVarargs()
	{
		return false;
	}

}
