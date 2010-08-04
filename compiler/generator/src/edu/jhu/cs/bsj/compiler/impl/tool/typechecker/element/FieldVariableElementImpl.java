package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.element;

import java.util.EnumSet;
import java.util.List;
import java.util.Set;

import javax.lang.model.element.Element;
import javax.lang.model.element.Modifier;
import javax.lang.model.type.TypeMirror;

import edu.jhu.cs.bsj.compiler.ast.node.FieldDeclarationNode;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.TypecheckerModelManager;

public class FieldVariableElementImpl extends AbstractMemberVariableElementImpl<FieldDeclarationNode>
{
	public FieldVariableElementImpl(TypecheckerModelManager manager, FieldDeclarationNode backingNode,
			Element enclosingElement)
	{
		super(manager, backingNode, enclosingElement);
	}

	@Override
	public TypeMirror asType()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<? extends Element> getEnclosedElements()
	{
		// TODO Auto-generated method stub
		return null;
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
