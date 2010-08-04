package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.element;

import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Set;

import javax.lang.model.element.AnnotationMirror;
import javax.lang.model.element.AnnotationValue;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.Name;
import javax.lang.model.element.TypeParameterElement;
import javax.lang.model.element.VariableElement;
import javax.lang.model.type.TypeMirror;

import edu.jhu.cs.bsj.compiler.ast.node.InitializerDeclarationNode;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.TypecheckerModelManager;

public class InitializerExecutableElementImpl extends AbstractExecutableElementImpl<InitializerDeclarationNode>
{
	public InitializerExecutableElementImpl(TypecheckerModelManager manager, InitializerDeclarationNode backingNode,
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
	public <A extends Annotation> A getAnnotation(Class<A> annotationType)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<? extends AnnotationMirror> getAnnotationMirrors()
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
	public Element getEnclosingElement()
	{
		// TODO Auto-generated method stub
		return null;
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Name getSimpleName()
	{
		return new NameImpl(getBackingNode().getStaticInitializer() ? "<clinit>" : "");
	}

	@Override
	public AnnotationValue getDefaultValue()
	{
		return null;
	}

	@Override
	public List<? extends VariableElement> getParameters()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TypeMirror getReturnType()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<? extends TypeMirror> getThrownTypes()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<? extends TypeParameterElement> getTypeParameters()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isVarArgs()
	{
		// TODO Auto-generated method stub
		return false;
	}

}
