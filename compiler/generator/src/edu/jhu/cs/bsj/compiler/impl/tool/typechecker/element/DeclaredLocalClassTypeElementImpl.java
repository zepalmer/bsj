package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.element;

import java.util.EnumSet;
import java.util.Set;

import javax.lang.model.element.Modifier;

import edu.jhu.cs.bsj.compiler.ast.node.LocalClassDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.LocalClassModifiersNode;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.TypecheckerModelManager;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.element.api.BsjElement;

public class DeclaredLocalClassTypeElementImpl extends
		AbstractlyUnmodifiedClassTypeElementImpl<LocalClassDeclarationNode>
{
	public DeclaredLocalClassTypeElementImpl(TypecheckerModelManager manager, LocalClassDeclarationNode backingNode,
			BsjElement enclosingElement)
	{
		super(manager, backingNode, enclosingElement);
	}

	@Override
	public Set<Modifier> getModifiers()
	{
		EnumSet<Modifier> set = super.getAccessModifierSet();
		LocalClassModifiersNode modifiers = getBackingNode().getModifiers();
		if (modifiers.getAbstractFlag())
		{
			set.add(Modifier.ABSTRACT);
		}
		if (modifiers.getFinalFlag())
		{
			set.add(Modifier.FINAL);
		}
		if (modifiers.getStrictfpFlag())
		{
			set.add(Modifier.STRICTFP);
		}
		return set;
	}
}
