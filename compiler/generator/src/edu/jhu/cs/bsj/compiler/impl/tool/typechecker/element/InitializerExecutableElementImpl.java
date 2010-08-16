package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.element;

import java.util.Collections;
import java.util.List;
import java.util.Set;

import javax.lang.model.element.AnnotationMirror;
import javax.lang.model.element.AnnotationValue;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.Name;
import javax.lang.model.element.TypeParameterElement;
import javax.lang.model.type.TypeMirror;

import edu.jhu.cs.bsj.compiler.ast.node.InitializerDeclarationNode;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.TypecheckerManager;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.element.api.BsjElement;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.element.api.BsjVariableElement;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.namespace.NamespaceUtilities;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.NoTypeImpl;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.api.BsjType;

public class InitializerExecutableElementImpl extends AbstractExecutableElementImpl<InitializerDeclarationNode>
{
	public InitializerExecutableElementImpl(TypecheckerManager manager, InitializerDeclarationNode backingNode,
			BsjElement enclosingElement)
	{
		super(manager, backingNode, enclosingElement);
	}

	@Override
	public BsjType asType()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<? extends AnnotationMirror> getAnnotationMirrors()
	{
		return Collections.emptyList();
	}

	@Override
	public ElementKind getKind()
	{
		if (getBackingNode().getStaticInitializer())
		{
			return ElementKind.STATIC_INIT;
		} else
		{
			return ElementKind.INSTANCE_INIT;
		}
	}

	@Override
	public Set<Modifier> getModifiers()
	{
		return Collections.emptySet();
	}

	@Override
	public Name getSimpleName()
	{
		return new NameImpl(getBackingNode().getStaticInitializer() ? NamespaceUtilities.STATIC_INITIALIZER_NAME : "");
	}

	@Override
	public AnnotationValue getDefaultValue()
	{
		return null;
	}

	@Override
	public List<? extends BsjVariableElement> getParameters()
	{
		return Collections.emptyList();
	}

	@Override
	public TypeMirror getReturnType()
	{
		return NoTypeImpl.makeVoid(getManager());
	}

	@Override
	public List<? extends TypeMirror> getThrownTypes()
	{
		return Collections.emptyList();
	}

	@Override
	public List<? extends TypeParameterElement> getTypeParameters()
	{
		return Collections.emptyList();
	}

	@Override
	public boolean isVarArgs()
	{
		return false;
	}

}
