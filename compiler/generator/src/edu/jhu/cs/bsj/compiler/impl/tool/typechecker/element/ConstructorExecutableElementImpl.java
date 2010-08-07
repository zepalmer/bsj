package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.element;

import java.util.EnumSet;
import java.util.Set;

import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.Name;
import javax.lang.model.type.TypeMirror;

import edu.jhu.cs.bsj.compiler.ast.node.ConstructorDeclarationNode;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.TypecheckerModelManager;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.namespace.NamespaceUtilities;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.NoTypeImpl;

public class ConstructorExecutableElementImpl extends AbstractInvokableExecutableElementImpl<ConstructorDeclarationNode>
{
	public ConstructorExecutableElementImpl(TypecheckerModelManager manager, ConstructorDeclarationNode backingNode,
			Element enclosingElement)
	{
		super(manager, backingNode, enclosingElement);
	}

	@Override
	public TypeMirror getReturnType()
	{
		return NoTypeImpl.makeVoid(getManager());
	}

	@Override
	public TypeMirror asType()
	{
		// TODO Auto-generated method stub
		return null;
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
		return new NameImpl(NamespaceUtilities.CONSTRUCTOR_NAME);
	}

}
