package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type;

import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.TypecheckerManager;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.api.BsjReferenceType;

public abstract class ReferenceTypeImpl extends TypeArgumentImpl implements BsjReferenceType
{
	public ReferenceTypeImpl(TypecheckerManager manager)
	{
		super(manager);
	}
}