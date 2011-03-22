package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type;

import javax.lang.model.type.TypeKind;

import edu.jhu.cs.bsj.compiler.ast.node.PackageNode;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.TypecheckerManager;
import edu.jhu.cs.bsj.compiler.lang.type.BsjLazyTypeContainer;
import edu.jhu.cs.bsj.compiler.lang.type.BsjPackagePseudoType;
import edu.jhu.cs.bsj.compiler.lang.type.BsjTypeArgument;
import edu.jhu.cs.bsj.compiler.lang.type.util.AbortableBsjTypeVisitor;

public class PackagePseudoTypeImpl extends PseudoTypeImpl implements BsjPackagePseudoType
{
	private PackageNode packageNode;

	public PackagePseudoTypeImpl(TypecheckerManager manager, PackageNode packageNode)
	{
		super(manager, TypeKind.PACKAGE);
		this.packageNode = packageNode;
	}

	@Override
	public PackageNode getPackage()
	{
		return this.packageNode;
	}

	@Override
	public BsjTypeArgument boxConvert()
	{
		return null;
	}

	@Override
	public int hashCode()
	{
		return this.packageNode.hashCode();
	}

	@Override
	public boolean equals(Object obj)
	{
        while (obj instanceof BsjLazyTypeContainer<?>)
            obj = ((BsjLazyTypeContainer<?>)obj).evaluate();
		if (obj instanceof BsjPackagePseudoType)
		{
			BsjPackagePseudoType other = (BsjPackagePseudoType) obj;
			return this.packageNode.equals(other.getPackage());
		} else
		{
			return false;
		}
	}

	@Override
	public String toString()
	{
		if (this.packageNode.getName() == null)
		{
			return "<root package>";
		} else
		{
			return "<package " + this.packageNode.getFullyQualifiedName() + ">";
		}
	}

    
    @Override
    public BsjPackagePseudoType evaluate()
    {
        return this;
    }

    @Override
    public <P, R, X extends Exception> R receive(AbortableBsjTypeVisitor<P, R, X> visitor, P param) throws X
    {
        return visitor.visitBsjPackagePseudoType(this, param);
    }
}
