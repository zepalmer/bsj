package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.element;

import java.util.Collections;
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
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.QualifiedClassInstantiationNode;
import edu.jhu.cs.bsj.compiler.ast.node.UnqualifiedClassInstantiationNode;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.TypecheckerModelManager;

public class AnonymousClassTypeElementImpl extends AbstractElementImpl<AnonymousClassBodyNode> implements TypeElement
{
	public AnonymousClassTypeElementImpl(TypecheckerModelManager manager, AnonymousClassBodyNode backingNode,
			Element enclosingElement)
	{
		super(manager, backingNode, enclosingElement);
	}
	
	// TODO: once we have this, how do we determine if the resulting TypeMirror represents a class or an interface?
	private TypeMirror getTypeMirrorForSupertype()
	{
		Node parent = getBackingNode().getParent();
		if (parent instanceof QualifiedClassInstantiationNode)
		{
			// TODO
			return null;
		} else if (parent instanceof UnqualifiedClassInstantiationNode)
		{
			UnqualifiedClassInstantiationNode node = (UnqualifiedClassInstantiationNode)parent;
			return makeType(node.getType());
		} else
		{
			throw new IllegalStateException("Don't know how to handle supertype " + parent.getClass());
		}
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
		return Collections.emptyList();
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
	public List<? extends AnnotationMirror> getAnnotationMirrors()
	{
		return Collections.emptyList();
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
