package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.element;

import java.util.List;

import javax.lang.model.element.AnnotationMirror;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.type.TypeMirror;

import edu.jhu.cs.bsj.compiler.ast.node.AbstractMemberVariableDeclarationNode;
import edu.jhu.cs.bsj.compiler.impl.NotImplementedYetException;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.TypecheckerModelManager;

public abstract class AbstractMemberVariableElementImpl<T extends AbstractMemberVariableDeclarationNode<?>> extends
		VariableDeclaratorOwnerElementImpl<T>
{
	public AbstractMemberVariableElementImpl(TypecheckerModelManager manager, T backingNode, Element enclosingElement,
			int index)
	{
		super(manager, backingNode, enclosingElement, index);
	}

	@Override
	public Object getConstantValue()
	{
		throw new NotImplementedYetException();
	}

	@Override
	public ElementKind getKind()
	{
		return ElementKind.FIELD;
	}

	@Override
	public List<? extends AnnotationMirror> getAnnotationMirrors()
	{
		return makeAnnotationMirrors(getBackingNode().getModifiers().getAnnotations());
	}

	@Override
	public TypeMirror asType()
	{
		return makeType(getBackingNode().getType());
	}
}
