package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type;

import java.util.List;

import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.TypecheckerModelManager;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.element.api.BsjTypeParameterElement;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.api.BsjDeclaredType;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.api.BsjIntersectionType;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.api.BsjType;

public class ImplicitlyDeclaredTypeImpl extends AbstractDeclaredTypeImpl<BsjTypeParameterElement> implements BsjIntersectionType
{
	public ImplicitlyDeclaredTypeImpl(TypecheckerModelManager manager, BsjTypeParameterElement typeElement,
			List<? extends BsjType> typeArguments, BsjDeclaredType enclosingType)
	{
		super(manager, typeElement, typeArguments, enclosingType, true);
	}
}