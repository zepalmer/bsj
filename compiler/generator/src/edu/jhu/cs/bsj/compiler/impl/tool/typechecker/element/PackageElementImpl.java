package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.element;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.lang.model.element.AnnotationMirror;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.ElementVisitor;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.Name;
import javax.lang.model.element.PackageElement;

import edu.jhu.cs.bsj.compiler.ast.node.CompilationUnitNode;
import edu.jhu.cs.bsj.compiler.ast.node.NamedTypeDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.PackageNode;
import edu.jhu.cs.bsj.compiler.ast.node.TypeDeclarationNode;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.TypecheckerManager;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.element.api.BsjElement;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.NoTypeImpl;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.api.BsjType;

public class PackageElementImpl extends AbstractElementImpl<PackageNode> implements PackageElement
{
	public PackageElementImpl(TypecheckerManager manager, PackageNode backingNode)
	{
		super(manager, backingNode, null);
	}

	@Override
	public Name getQualifiedName()
	{
		if (this.isUnnamed())
		{
			return new NameImpl("");
		} else
		{
			return new NameImpl(this.getBackingNode().getFullyQualifiedName());
		}
	}

	@Override
	public boolean isUnnamed()
	{
		return this.getBackingNode().getName() == null;
	}

	@Override
	public <R, P> R accept(ElementVisitor<R, P> v, P p)
	{
		return v.visitPackage(this, p);
	}

	@Override
	public BsjType asType()
	{
		return NoTypeImpl.makePackage(getManager());
	}

	@Override
	public List<? extends AnnotationMirror> getAnnotationMirrors()
	{
		return Collections.emptyList();
	}

	@Override
	public List<? extends Element> getEnclosedElements()
	{
		List<Element> list = new ArrayList<Element>();
		Iterator<CompilationUnitNode> iterator = getBackingNode().getCompilationUnitIterator();
		while (iterator.hasNext())
		{
			CompilationUnitNode compilationUnitNode = iterator.next();
			for (TypeDeclarationNode typeDeclarationNode : compilationUnitNode.getTypeDecls())
			{
				if (typeDeclarationNode instanceof NamedTypeDeclarationNode<?>)
				{
					list.add(makeElement(typeDeclarationNode));
				}
			}
		}
		return list;
	}

	@Override
	public BsjElement getEnclosingElement()
	{
		return null;
	}

	@Override
	public ElementKind getKind()
	{
		return ElementKind.PACKAGE;
	}

	@Override
	public Set<Modifier> getModifiers()
	{
		return Collections.emptySet();
	}

	@Override
	public Name getSimpleName()
	{
		if (this.isUnnamed())
		{
			return new NameImpl("");
		} else
		{
			return new NameImpl(this.getBackingNode().getName().getIdentifier());
		}
	}
}
