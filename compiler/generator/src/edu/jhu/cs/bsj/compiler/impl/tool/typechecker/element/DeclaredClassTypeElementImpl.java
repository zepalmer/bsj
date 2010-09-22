package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.element;

import java.util.EnumSet;
import java.util.Set;

import javax.lang.model.element.Modifier;

import edu.jhu.cs.bsj.compiler.ast.node.ClassDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.ClassModifiersNode;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.TypecheckerManager;
import edu.jhu.cs.bsj.compiler.lang.element.BsjElement;

public class DeclaredClassTypeElementImpl extends AbstractlyUnmodifiedClassTypeElementImpl<ClassDeclarationNode>
{
	public DeclaredClassTypeElementImpl(TypecheckerManager manager, ClassDeclarationNode backingNode,
			BsjElement enclosingElement)
	{
		super(manager, backingNode, enclosingElement);
	}

	@Override
	public Set<Modifier> getModifiers()
	{
		EnumSet<Modifier> set = super.getAccessModifierSet();
		ClassModifiersNode modifiers = getBackingNode().getModifiers();
		if (modifiers.getAbstractFlag())
		{
			set.add(Modifier.ABSTRACT);
		}
		if (modifiers.getFinalFlag())
		{
			set.add(Modifier.FINAL);
		}
		if (modifiers.getStaticFlag())
		{
			set.add(Modifier.STATIC);
		}
		if (modifiers.getStrictfpFlag())
		{
			set.add(Modifier.STRICTFP);
		}
		return set;
	}
}
