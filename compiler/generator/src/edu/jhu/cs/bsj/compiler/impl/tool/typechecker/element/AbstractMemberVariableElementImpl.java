package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.element;

import java.util.List;

import javax.lang.model.element.AnnotationMirror;
import javax.lang.model.element.ElementKind;

import edu.jhu.cs.bsj.compiler.ast.node.AbstractMemberVariableDeclarationNode;
import edu.jhu.cs.bsj.compiler.impl.NotImplementedYetException;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.TypecheckerModelManager;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.element.api.BsjElement;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.api.BsjType;

public abstract class AbstractMemberVariableElementImpl<T extends AbstractMemberVariableDeclarationNode<?>> extends
		VariableDeclaratorOwnerElementImpl<T>
{
	public AbstractMemberVariableElementImpl(TypecheckerModelManager manager, T backingNode, BsjElement enclosingElement,
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
	public BsjType asType()
	{
		return makeType(getBackingNode().getType());
	}
}
