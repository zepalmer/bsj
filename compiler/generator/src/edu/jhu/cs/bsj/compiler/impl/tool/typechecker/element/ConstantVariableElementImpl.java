package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.element;

import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;

import javax.lang.model.element.Element;
import javax.lang.model.element.Modifier;
import javax.lang.model.type.TypeMirror;

import edu.jhu.cs.bsj.compiler.ast.node.ConstantDeclarationNode;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.TypecheckerModelManager;

public class ConstantVariableElementImpl extends AbstractMemberVariableElementImpl<ConstantDeclarationNode>
{
	public ConstantVariableElementImpl(TypecheckerModelManager manager, ConstantDeclarationNode backingNode,
			Element enclosingElement, int index)
	{
		super(manager, backingNode, enclosingElement, index);
	}

	@Override
	public TypeMirror asType()
	{
		return makeType(getBackingNode().getType());
	}

	@Override
	public List<? extends Element> getEnclosedElements()
	{
		return Collections.emptyList();
	}

	@Override
	public Set<Modifier> getModifiers()
	{
		return EnumSet.of(Modifier.PUBLIC, Modifier.STATIC, Modifier.FINAL);
	}
}
