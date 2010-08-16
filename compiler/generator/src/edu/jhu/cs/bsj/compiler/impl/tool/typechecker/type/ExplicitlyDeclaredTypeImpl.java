package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type;

import java.util.List;

import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.TypecheckerManager;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.element.api.BsjTypeElement;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.api.BsjDeclaredType;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.api.BsjExplicitlyDeclaredType;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.api.BsjType;

public class ExplicitlyDeclaredTypeImpl extends AbstractDeclaredTypeImpl<BsjTypeElement> implements BsjExplicitlyDeclaredType
{
	public ExplicitlyDeclaredTypeImpl(TypecheckerManager manager, BsjTypeElement typeElement,
			List<? extends BsjType> typeArguments, BsjDeclaredType enclosingType)
	{
		super(manager, typeElement, typeArguments, enclosingType, false);
	}

	@Override
	protected ExplicitlyDeclaredTypeImpl makeAnother(BsjTypeElement typeElement, List<? extends BsjType> typeArguments,
			BsjDeclaredType enclosingType)
	{
		return new ExplicitlyDeclaredTypeImpl(getManager(), typeElement, typeArguments, enclosingType);
	}
	
}
