package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.element;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

import javax.lang.model.element.AnnotationMirror;
import javax.lang.model.element.Element;
import javax.lang.model.element.Modifier;

import edu.jhu.cs.bsj.compiler.ast.AccessModifier;
import edu.jhu.cs.bsj.compiler.ast.node.AnnotationNode;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.TypecheckerModelComponentImpl;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.TypecheckerModelManager;

public abstract class AbstractElementImpl<T extends Node> extends TypecheckerModelComponentImpl implements Element
{
	private T backingNode;
	private Element enclosingElement;

	protected T getBackingNode()
	{
		return this.backingNode;
	}

	public AbstractElementImpl(TypecheckerModelManager manager, T backingNode, Element enclosingElement)
	{
		super(manager);
		this.backingNode = backingNode;
		this.enclosingElement = enclosingElement;
	}

	protected EnumSet<Modifier> getAccessModifierSet(AccessModifier access)
	{
		Modifier modifier;
		switch (access)
		{
			case PACKAGE:
				return EnumSet.noneOf(Modifier.class);
			case PRIVATE:
				modifier = Modifier.PRIVATE;
				break;
			case PROTECTED:
				modifier = Modifier.PROTECTED;
				break;
			case PUBLIC:
				modifier = Modifier.PUBLIC;
				break;
			default:
				throw new IllegalStateException("Don't know how to convert access modifier "
						+ access);
		}
		return EnumSet.of(modifier);
	}
	
	@Override
	public Element getEnclosingElement()
	{
		return enclosingElement;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this.getClass() != obj.getClass())
			return false;
		AbstractElementImpl<?> other = (AbstractElementImpl<?>)obj;
		if (this.getBackingNode().getUid() != other.getBackingNode().getUid())
			return false;
		
		return true;
	}

	@Override
	public int hashCode()
	{
		return ~(int) this.getBackingNode().getUid();
	}

	@Override
	public <A extends Annotation> A getAnnotation(Class<A> annotationType)
	{
		// NOTE: this implementation does not support getAnnotation functionality in any form
		return null;
	}

	// *** Convenient utilities ***
	
	protected List<? extends AnnotationMirror> makeAnnotationMirrors(List<? extends AnnotationNode> annotations)
	{
		List<AnnotationMirror> ret = new ArrayList<AnnotationMirror>();
		for (AnnotationNode annotationNode : annotations)
		{
			ret.add(AnnotationMirrorImpl.makeForNode(getManager(), annotationNode));
		}
		return ret;
	}
}
