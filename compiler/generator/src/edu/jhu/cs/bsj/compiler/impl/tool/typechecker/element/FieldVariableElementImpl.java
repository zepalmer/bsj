package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.element;

import java.util.EnumSet;
import java.util.Set;

import javax.lang.model.element.Modifier;

import edu.jhu.cs.bsj.compiler.ast.node.FieldDeclarationNode;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.TypecheckerModelManager;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.element.api.BsjElement;

public class FieldVariableElementImpl extends AbstractMemberVariableElementImpl<FieldDeclarationNode>
{
	public FieldVariableElementImpl(TypecheckerModelManager manager, FieldDeclarationNode backingNode,
			BsjElement enclosingElement, int index)
	{
		super(manager, backingNode, enclosingElement, index);
	}

	@Override
	public Set<Modifier> getModifiers()
	{
		EnumSet<Modifier> set = getAccessModifierSet(getBackingNode().getModifiers().getAccess());
		if (getBackingNode().getModifiers().getFinalFlag())
		{
			set.add(Modifier.FINAL);
		}
		if (getBackingNode().getModifiers().getStaticFlag())
		{
			set.add(Modifier.STATIC);
		}
		if (getBackingNode().getModifiers().getTransientFlag())
		{
			set.add(Modifier.TRANSIENT);
		}
		if (getBackingNode().getModifiers().getVolatileFlag())
		{
			set.add(Modifier.VOLATILE);
		}
		return set;
	}
}
