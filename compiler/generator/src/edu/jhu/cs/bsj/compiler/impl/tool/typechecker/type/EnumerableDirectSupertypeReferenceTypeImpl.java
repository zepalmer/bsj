package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type;

import java.util.Collection;

import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.TypecheckerManager;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.api.BsjType;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.api.BsjTypeVariable;

/**
 * An implementation of a type mirror which is capable of enumerating its direct supertypes as a means by which the
 * supertype relation can be defined.
 * @author Zachary Palmer
 */
public abstract class EnumerableDirectSupertypeReferenceTypeImpl extends ReferenceTypeImpl
{
	public EnumerableDirectSupertypeReferenceTypeImpl(TypecheckerManager manager)
	{
		super(manager);
	}

	@Override
	public boolean isSubtypeOf(BsjType type)
	{
		if (type instanceof BsjTypeVariable)
		{
			return type.isSupertypeOf(this);
		}
		
		if (this.equals(type))
			return true;
		
		for (BsjType supertype : getDirectSupertypes())
		{
			if (supertype.isSubtypeOf(type))
				return true;
		}

		return false;
	}
	
	protected abstract Collection<? extends BsjType> getDirectSupertypes();
}
