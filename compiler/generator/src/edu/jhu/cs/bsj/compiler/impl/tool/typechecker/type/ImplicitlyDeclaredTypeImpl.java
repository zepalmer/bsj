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
		// TODO: is it possible for an implicitly declared type to have an enclosing type?  does that make sense?
		super(manager, typeElement, typeArguments, enclosingType, true);
	}

	@Override
	protected ImplicitlyDeclaredTypeImpl makeAnother(BsjTypeParameterElement typeElement, List<? extends BsjType> typeArguments,
			BsjDeclaredType enclosingType)
	{
		return new ImplicitlyDeclaredTypeImpl(getManager(), typeElement, typeArguments, enclosingType);
	}


}
