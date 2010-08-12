package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.element;

import java.util.ArrayList;
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
import edu.jhu.cs.bsj.compiler.ast.node.ClassDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.InterfaceDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.QualifiedClassInstantiationNode;
import edu.jhu.cs.bsj.compiler.ast.node.UnqualifiedClassInstantiationNode;
import edu.jhu.cs.bsj.compiler.impl.NotImplementedYetException;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.TypecheckerModelManager;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.element.api.BsjElement;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.NoTypeImpl;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.api.BsjExplicitlyDeclaredType;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.api.BsjNamedReferenceType;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.api.BsjType;

public class AnonymousClassTypeElementImpl extends AbstractElementImpl<AnonymousClassBodyNode> implements TypeElement
{
	public AnonymousClassTypeElementImpl(TypecheckerModelManager manager, AnonymousClassBodyNode backingNode,
			BsjElement enclosingElement)
	{
		super(manager, backingNode, enclosingElement);
	}
	
	private BsjExplicitlyDeclaredType getSupertype()
	{
		Node parent = getBackingNode().getParent();
		if (parent instanceof QualifiedClassInstantiationNode)
		{
			// TODO
			throw new NotImplementedYetException();
		} else if (parent instanceof UnqualifiedClassInstantiationNode)
		{
			UnqualifiedClassInstantiationNode node = (UnqualifiedClassInstantiationNode)parent;
			BsjNamedReferenceType referenceType = makeType(node.getType());
			if (referenceType instanceof BsjExplicitlyDeclaredType)
			{
				return (BsjExplicitlyDeclaredType)referenceType;
			} else
			{
				// This means that the programmer attempted to instantiate a type variable, such as in new T()
				// TODO: report an appropriate diagnostic
				throw new NotImplementedYetException();
				// TODO: then return the type for java.lang.Object
			}
		} else
		{
			throw new IllegalStateException("Don't know how to handle supertype " + parent.getClass());
		}
	}
	
	@Override
	public List<? extends BsjType> getInterfaces()
	{
		BsjExplicitlyDeclaredType type = getSupertype();
		if (type.asElement().getDeclarationNode() instanceof InterfaceDeclarationNode)
		{
			return Collections.singletonList(type);
		} else
		{
			return Collections.emptyList();
		}
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
		BsjExplicitlyDeclaredType type = getSupertype();
		if (type.asElement().getDeclarationNode() instanceof ClassDeclarationNode)
		{
			return type;
		} else
		{
			return NoTypeImpl.makeNone(getManager());
		}
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
	public List<? extends Element> getEnclosedElements()
	{
		List<Element> ret = new ArrayList<Element>();
		for (Node node : getBackingNode().getMembers())
		{
			Element element = makeElement(node);
			if (element != null)
			{
				ret.add(element);
			}
		}
		return ret;
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
