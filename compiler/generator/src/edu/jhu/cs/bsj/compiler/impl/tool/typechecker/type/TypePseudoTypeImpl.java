package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type;

import javax.lang.model.type.TypeKind;

import edu.jhu.cs.bsj.compiler.ast.node.NamedTypeDeclarationNode;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.TypecheckerManager;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.api.BsjTypeArgument;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.api.BsjTypePseudoType;

public class TypePseudoTypeImpl extends PseudoTypeImpl implements BsjTypePseudoType
{
	private NamedTypeDeclarationNode<?> declaration;

	public TypePseudoTypeImpl(TypecheckerManager manager, NamedTypeDeclarationNode<?> declaration)
	{
		super(manager, TypeKind.NONE);
		this.declaration = declaration;
	}

	@Override
	public BsjTypeArgument boxConvert()
	{
		return null;
	}

	@Override
	public NamedTypeDeclarationNode<?> getDeclaration()
	{
		return this.declaration;
	}

	@Override
	public int hashCode()
	{
		return this.declaration.hashCode();
	}

	@Override
	public boolean equals(Object obj)
	{
		if (obj instanceof BsjTypePseudoType)
		{
			BsjTypePseudoType other = (BsjTypePseudoType) obj;
			return this.declaration.equals(other.getDeclaration());
		} else
		{
			return false;
		}
	}

	@Override
	public String toString()
	{
		return "(pseudo:" + this.declaration.getFullyQualifiedName() + ")";
	}
}
