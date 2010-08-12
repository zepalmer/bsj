package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type;

import javax.lang.model.type.TypeKind;
import javax.lang.model.type.TypeVisitor;

import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.TypecheckerModelComponentImpl;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.TypecheckerModelManager;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.api.BsjType;

public abstract class TypeMirrorImpl extends TypecheckerModelComponentImpl implements BsjType
{
	public TypeMirrorImpl(TypecheckerModelManager manager)
	{
		super(manager);
	}

	@Override
	public abstract <R, P> R accept(TypeVisitor<R, P> v, P p);

	@Override
	public abstract TypeKind getKind();

	@Override
	public abstract int hashCode();
	
	@Override
	public abstract boolean equals(Object obj);

	@Override
	public abstract String toString();
}
