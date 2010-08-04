package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.element;

import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;

import edu.jhu.cs.bsj.compiler.ast.node.AbstractMemberVariableDeclarationNode;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.TypecheckerModelManager;

public abstract class AbstractMemberVariableElementImpl<T extends AbstractMemberVariableDeclarationNode<?>> extends VariableDeclaratorOwnerElementImpl<T>
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


}
