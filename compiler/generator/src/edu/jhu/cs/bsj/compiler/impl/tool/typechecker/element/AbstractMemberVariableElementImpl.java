package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.element;

import java.util.List;

import javax.lang.model.element.AnnotationMirror;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;

import edu.jhu.cs.bsj.compiler.ast.node.AbstractMemberVariableDeclarationNode;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.TypecheckerModelManager;

public abstract class AbstractMemberVariableElementImpl<T extends AbstractMemberVariableDeclarationNode<?>> extends
		VariableDeclaratorOwnerElementImpl<T>
{
	public AbstractMemberVariableElementImpl(TypecheckerModelManager manager, T backingNode, Element enclosingElement)
	{
		super(manager, backingNode, enclosingElement);
	}

	@Override
	public Object getConstantValue()
	{
		// TODO Auto-generated method stub
		return null;
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
}
