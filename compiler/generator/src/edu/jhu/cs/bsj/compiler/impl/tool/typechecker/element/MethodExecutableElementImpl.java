package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.element;

import java.util.EnumSet;
import java.util.Set;

import javax.lang.model.element.ElementKind;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.Name;
import javax.lang.model.type.TypeMirror;

import edu.jhu.cs.bsj.compiler.ast.node.MethodDeclarationNode;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.TypecheckerManager;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.MethodExecutableTypeImpl;
import edu.jhu.cs.bsj.compiler.lang.element.BsjElement;
import edu.jhu.cs.bsj.compiler.lang.type.BsjExecutableType;

public class MethodExecutableElementImpl extends AbstractInvokableExecutableElementImpl<MethodDeclarationNode>
{
	public MethodExecutableElementImpl(TypecheckerManager manager, MethodDeclarationNode backingNode,
			BsjElement enclosingElement)
	{
		super(manager, backingNode, enclosingElement);
	}

	@Override
	public TypeMirror getReturnType()
	{
		return getTypeBuilder().makeType(getBackingNode().getReturnType());
	}

	@Override
	public BsjExecutableType asType()
	{
		return new MethodExecutableTypeImpl(getManager(), getBackingNode());
	}

	@Override
	public ElementKind getKind()
	{
		return ElementKind.METHOD;
	}

	@Override
	public Set<Modifier> getModifiers()
	{
		EnumSet<Modifier> set = getAccessModifierSet(getBackingNode().getModifiers().getAccess());
		if (getBackingNode().getModifiers().getAbstractFlag())
		{
			set.add(Modifier.ABSTRACT);
		}
		if (getBackingNode().getModifiers().getFinalFlag())
		{
			set.add(Modifier.FINAL);
		}
		if (getBackingNode().getModifiers().getNativeFlag())
		{
			set.add(Modifier.NATIVE);
		}
		if (getBackingNode().getModifiers().getStaticFlag())
		{
			set.add(Modifier.STATIC);
		}
		if (getBackingNode().getModifiers().getStrictfpFlag())
		{
			set.add(Modifier.STRICTFP);
		}
		if (getBackingNode().getModifiers().getSynchronizedFlag())
		{
			set.add(Modifier.SYNCHRONIZED);
		}
		return set;
	}

	@Override
	public Name getSimpleName()
	{
		return new NameImpl(getBackingNode().getIdentifier().getIdentifier());
	}

}
