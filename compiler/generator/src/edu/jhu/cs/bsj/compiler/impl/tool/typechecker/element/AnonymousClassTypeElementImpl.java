package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.element;

import java.lang.annotation.Annotation;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;

import javax.lang.model.element.AnnotationMirror;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.ElementVisitor;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.Name;
import javax.lang.model.element.NestingKind;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.TypeParameterElement;
import javax.lang.model.type.TypeMirror;

import edu.jhu.cs.bsj.compiler.ast.node.AnonymousClassBodyNode;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.TypecheckerModelManager;

public class AnonymousClassTypeElementImpl extends AbstractElementImpl<AnonymousClassBodyNode> implements TypeElement
{
	public AnonymousClassTypeElementImpl(TypecheckerModelManager manager, AnonymousClassBodyNode backingNode,
			Element enclosingElement)
	{
		super(manager, backingNode, enclosingElement);
	}

	@Override
	public List<? extends TypeMirror> getInterfaces()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NestingKind getNestingKind()
	{
		return NestingKind.ANONYMOUS;
	}

	@Override
	public Name getQualifiedName()
	{
		return new NameImpl("");
	}

	@Override
	public TypeMirror getSuperclass()
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
	public <R, P> R accept(ElementVisitor<R, P> v, P p)
	{
		return v.visitType(this, p);
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
	public ElementKind getKind()
	{
		return ElementKind.CLASS;
	}

	@Override
	public Set<Modifier> getModifiers()
	{
		return EnumSet.of(Modifier.FINAL);
	}

	@Override
	public Name getSimpleName()
	{
		return new NameImpl("");
	}

}
