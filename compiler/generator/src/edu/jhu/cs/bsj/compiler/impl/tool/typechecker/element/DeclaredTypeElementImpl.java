package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.element;

import java.lang.annotation.Annotation;
import java.util.EnumSet;
import java.util.List;

import javax.lang.model.element.AnnotationMirror;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementVisitor;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.Name;
import javax.lang.model.element.NestingKind;
import javax.lang.model.element.TypeElement;
import javax.lang.model.type.TypeMirror;

import edu.jhu.cs.bsj.compiler.ast.node.AccessibleTypeModifiersNode;
import edu.jhu.cs.bsj.compiler.ast.node.CompilationUnitNode;
import edu.jhu.cs.bsj.compiler.ast.node.LocalClassDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.NamedTypeDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.PackageNode;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.TypecheckerModelManager;

/**
 * A supertype for implementations of the {@link TypeElement} modeling interface for use in the BSJ type checker. This
 * abstract implementation models all type elements except for anonymous classes, which are modeled by
 * {@link AnonymousClassTypeElementImpl}.
 * 
 * @author Zachary Palmer
 */
public abstract class DeclaredTypeElementImpl<T extends NamedTypeDeclarationNode<?>> extends AbstractElementImpl<T>
		implements TypeElement
{
	public DeclaredTypeElementImpl(TypecheckerModelManager manager, T backingNode, Element enclosingElement)
	{
		super(manager, backingNode, enclosingElement);
	}

	@Override
	public NestingKind getNestingKind()
	{
		if (getBackingNode() instanceof LocalClassDeclarationNode)
		{
			return NestingKind.LOCAL;
		} else if (this.getBackingNode().getParent() != null
				&& this.getBackingNode().getParent().getParent() instanceof CompilationUnitNode)
		{
			return NestingKind.TOP_LEVEL;
		} else
		{
			return NestingKind.MEMBER;
		}
	}

	@Override
	public Name getQualifiedName()
	{
		if (getBackingNode() instanceof LocalClassDeclarationNode)
		{
			return null;
		}

		StringBuffer sb = new StringBuffer();
		sb.insert(0, getSimpleName());
		NamedTypeDeclarationNode<?> node = getBackingNode();
		PackageNode packageNode = null;
		while (node != null)
		{
			NamedTypeDeclarationNode<?> next = node.getNearestAncestorOfType(NamedTypeDeclarationNode.class);
			if (next == null)
			{
				packageNode = node.getNearestAncestorOfType(PackageNode.class);
			} else
			{
				sb.insert(0, '.');
				sb.insert(0, next.getIdentifier().getIdentifier());
			}
			node = next;
		}
		while (packageNode.getName() != null)
		{
			sb.insert(0, '.');
			sb.insert(0, packageNode.getName().getIdentifier());
			packageNode = (PackageNode) (packageNode.getParent());
		}
		return new NameImpl(sb.toString());
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
	public Name getSimpleName()
	{
		return new NameImpl(this.getBackingNode().getIdentifier().getIdentifier());
	}

	protected EnumSet<Modifier> getAccessModifierSet()
	{
		if (this.getBackingNode().getModifiers() instanceof AccessibleTypeModifiersNode)
		{
			AccessibleTypeModifiersNode modifiers = (AccessibleTypeModifiersNode) this.getBackingNode().getModifiers();
			return getAccessModifierSet(modifiers.getAccess());
		} else
		{
			return EnumSet.noneOf(Modifier.class);
		}
	}
}
