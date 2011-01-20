package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.element;

import java.util.EnumSet;
import java.util.Set;

import javax.lang.model.element.ElementKind;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.Name;
import javax.lang.model.type.TypeMirror;

import edu.jhu.cs.bsj.compiler.ast.node.ConstructorDeclarationNode;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.TypecheckerManager;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.ConstructorExecutableTypeImpl;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.VoidPseudoTypeImpl;
import edu.jhu.cs.bsj.compiler.lang.element.BsjElement;
import edu.jhu.cs.bsj.compiler.lang.type.BsjExecutableType;

public class ConstructorExecutableElementImpl extends AbstractInvokableExecutableElementImpl<ConstructorDeclarationNode>
{
	/** The fake method name assigned to constructors. */
    public static final String CONSTRUCTOR_NAME = "<init>";

    public ConstructorExecutableElementImpl(TypecheckerManager manager, ConstructorDeclarationNode backingNode,
			BsjElement enclosingElement)
	{
		super(manager, backingNode, enclosingElement);
	}

	@Override
	public TypeMirror getReturnType()
	{
		return new VoidPseudoTypeImpl(getManager());
	}

	@Override
	public BsjExecutableType asType()
	{
		return new ConstructorExecutableTypeImpl(getManager(), getBackingNode());
	}

	@Override
	public ElementKind getKind()
	{
		return ElementKind.CONSTRUCTOR;
	}

	@Override
	public Set<Modifier> getModifiers()
	{
		EnumSet<Modifier> set = getAccessModifierSet(getBackingNode().getModifiers().getAccess());
		return set;
	}

	@Override
	public Name getSimpleName()
	{
		return new NameImpl(ConstructorExecutableElementImpl.CONSTRUCTOR_NAME);
	}

}
