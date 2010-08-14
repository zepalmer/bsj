package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.element;

import java.util.EnumSet;
import java.util.Set;

import javax.lang.model.element.Modifier;

import edu.jhu.cs.bsj.compiler.ast.node.ConstantDeclarationNode;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.TypecheckerModelManager;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.element.api.BsjElement;

public class ConstantVariableElementImpl extends AbstractMemberVariableElementImpl<ConstantDeclarationNode>
{
	public ConstantVariableElementImpl(TypecheckerModelManager manager, ConstantDeclarationNode backingNode,
			BsjElement enclosingElement, int index)
	{
		super(manager, backingNode, enclosingElement, index);
	}

	@Override
	public Set<Modifier> getModifiers()
	{
		return EnumSet.of(Modifier.PUBLIC, Modifier.STATIC, Modifier.FINAL);
	}
}
