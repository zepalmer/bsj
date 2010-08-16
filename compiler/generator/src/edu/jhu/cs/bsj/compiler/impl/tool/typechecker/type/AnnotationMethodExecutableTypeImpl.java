package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type;

import java.util.Collections;
import java.util.List;

import edu.jhu.cs.bsj.compiler.ast.node.AnnotationMethodDeclarationNode;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.TypecheckerModelManager;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.api.BsjType;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.api.BsjTypeVariable;

public class AnnotationMethodExecutableTypeImpl extends AbstractExecutableTypeImpl<AnnotationMethodDeclarationNode>
{
	public AnnotationMethodExecutableTypeImpl(TypecheckerModelManager manager,
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
}
