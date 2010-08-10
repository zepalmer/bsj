package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.element;

import java.util.ArrayList;
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
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.PackageNode;
import edu.jhu.cs.bsj.compiler.ast.node.VariableDeclaratorNode;
import edu.jhu.cs.bsj.compiler.ast.node.VariableDeclaratorOwnerNode;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.TypecheckerModelManager;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.element.api.BsjElement;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.element.api.BsjTypeElement;

/**
 * A supertype for implementations of the {@link TypeElement} modeling interface for use in the BSJ type checker. This
 * abstract implementation models all type elements except for anonymous classes, which are modeled by
 * {@link AnonymousClassTypeElementImpl}.
 * 
 * @author Zachary Palmer
 */
public abstract class DeclaredTypeElementImpl<T extends NamedTypeDeclarationNode<?>> extends AbstractElementImpl<T>
		implements BsjTypeElement
{
	public DeclaredTypeElementImpl(TypecheckerModelManager manager, T backingNode, BsjElement enclosingElement)
	{
		super(manager, backingNode, enclosingElement);
	}
	
	public T getBackingNode()
	{
		return super.getBackingNode();
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
	public List<? extends AnnotationMirror> getAnnotationMirrors()
	{
		return makeAnnotationMirrors(getBackingNode().getModifiers().getAnnotations());
	}

	@Override
	public List<? extends Element> getEnclosedElements()
	{
		List<Element> ret = new ArrayList<Element>();
		for (Node node : getBackingNode().getBody().getMembers())
		{
			Element element;
			if (node instanceof VariableDeclaratorOwnerNode)
			{
				for (VariableDeclaratorNode declaratorNode : ((VariableDeclaratorOwnerNode)node).getDeclarators())
				{
					element = makeElement(declaratorNode);
					if (element != null)
					{
						ret.add(element);
					}
				}
			} else
			{
				element = makeElement(node);
				if (element != null)
				{
					ret.add(element);
				}
			}
		}
		return ret;
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
