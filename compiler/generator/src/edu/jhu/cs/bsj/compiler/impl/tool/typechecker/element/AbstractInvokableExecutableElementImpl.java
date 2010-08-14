package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.element;

import java.util.ArrayList;
import java.util.List;

import javax.lang.model.element.AnnotationMirror;
import javax.lang.model.element.AnnotationValue;
import javax.lang.model.element.TypeParameterElement;
import javax.lang.model.type.TypeMirror;

import edu.jhu.cs.bsj.compiler.ast.node.AbstractInvokableDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.TypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.TypeParameterNode;
import edu.jhu.cs.bsj.compiler.ast.node.VariableNode;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.TypecheckerModelManager;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.element.api.BsjElement;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.element.api.BsjVariableElement;

public abstract class AbstractInvokableExecutableElementImpl<T extends AbstractInvokableDeclarationNode<?>> extends
		AbstractExecutableElementImpl<T>
{
	public AbstractInvokableExecutableElementImpl(TypecheckerModelManager manager, T backingNode,
			BsjElement enclosingElement)
	{
		super(manager, backingNode, enclosingElement);
	}

	@Override
	public AnnotationValue getDefaultValue()
	{
		return null;
	}

	@Override
	public List<? extends BsjVariableElement> getParameters()
	{
		List<BsjVariableElement> list = new ArrayList<BsjVariableElement>();
		for (VariableNode var : getBackingNode().getParameters())
		{
			list.add(new ActualVariableElementImpl(getManager(), var, this, false));
		}
		if (getBackingNode().getVarargParameter() != null)
		{
			list.add(new ActualVariableElementImpl(getManager(), getBackingNode().getVarargParameter(), this, true));
		}
		return list;
	}

	@Override
	public List<? extends TypeMirror> getThrownTypes()
	{
		List<TypeMirror> list = new ArrayList<TypeMirror>();
		for (TypeNode type : getBackingNode().getThrowTypes())
		{
			list.add(getTypeBuilder().makeType(type));
		}
		return list;
	}

	@Override
	public boolean isVarArgs()
	{
		return (getBackingNode().getVarargParameter() != null);
	}

	@Override
	public List<? extends TypeParameterElement> getTypeParameters()
	{
		List<TypeParameterElement> list = new ArrayList<TypeParameterElement>();
		for (TypeParameterNode typeParameter : getBackingNode().getTypeParameters())
		{
			list.add(new TypeParameterElementImpl(getManager(), typeParameter, this));
		}
		return list;
	}

	@Override
	public List<? extends AnnotationMirror> getAnnotationMirrors()
	{
		return makeAnnotationMirrors(getBackingNode().getModifiers().getAnnotations());
	}
	
}
