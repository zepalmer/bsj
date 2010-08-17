package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.element;

import java.util.EnumSet;
import java.util.Set;

import javax.lang.model.element.Modifier;

import edu.jhu.cs.bsj.compiler.ast.node.FieldDeclarationNode;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.TypecheckerManager;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.element.api.BsjElement;

public class FieldVariableElementImpl extends AbstractMemberVariableElementImpl<FieldDeclarationNode>
{
	public FieldVariableElementImpl(TypecheckerManager manager, FieldDeclarationNode backingNode,
			BsjElement enclosingElement, int index)
	{
		super(manager, backingNode, enclosingElement, index);
	}

	@Override
	public Set<Modifier> getModifiers()
	{
		EnumSet<Modifier> set = getAccessModifierSet(getOwner().getModifiers().getAccess());
		if (getOwner().getModifiers().getFinalFlag())
		{
			set.add(Modifier.FINAL);
		}
		if (getOwner().getModifiers().getStaticFlag())
		{
			set.add(Modifier.STATIC);
		}
		if (getOwner().getModifiers().getTransientFlag())
		{
			set.add(Modifier.TRANSIENT);
		}
		if (getOwner().getModifiers().getVolatileFlag())
		{
			set.add(Modifier.VOLATILE);
		}
		return set;
	}
}
