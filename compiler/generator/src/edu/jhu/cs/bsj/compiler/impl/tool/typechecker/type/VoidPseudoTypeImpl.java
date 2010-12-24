package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type;

import javax.lang.model.type.TypeKind;

import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.TypecheckerManager;
import edu.jhu.cs.bsj.compiler.lang.type.BsjLazyTypeContainer;
import edu.jhu.cs.bsj.compiler.lang.type.BsjTypeArgument;
import edu.jhu.cs.bsj.compiler.lang.type.BsjVoidPseudoType;

public class VoidPseudoTypeImpl extends PseudoTypeImpl implements BsjVoidPseudoType
{
	public VoidPseudoTypeImpl(TypecheckerManager manager)
	{
		super(manager, TypeKind.VOID);
	}

	@Override
	public BsjTypeArgument boxConvert()
	{
		return getManager().getToolkit().getVoidWrapperType();
	}

	@Override
	public int hashCode()
	{
		return 1681749930;
	}

	@Override
	public boolean equals(Object obj)
	{
        while (obj instanceof BsjLazyTypeContainer<?>)
            obj = ((BsjLazyTypeContainer<?>)obj).evaluate();
		return obj instanceof BsjVoidPseudoType;
	}

	@Override
	public String toString()
	{
		return "void";
	}
    
    @Override
    public BsjVoidPseudoType evaluate()
    {
        return this;
    }
}
