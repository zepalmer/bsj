package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.element;

import javax.lang.model.element.AnnotationValueVisitor;

import edu.jhu.cs.bsj.compiler.ast.node.AnnotationExpressionValueNode;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.TypecheckerManager;

public class AnnotationExpressionValueImpl extends AbstractAnnotationValueImpl<AnnotationExpressionValueNode>
{
	public AnnotationExpressionValueImpl(TypecheckerManager manager, AnnotationExpressionValueNode backingNode)
	{
		super(manager, backingNode);
	}

	@Override
	public <R, P> R accept(AnnotationValueVisitor<R, P> v, P p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getValue()
	{
		// TODO Auto-generated method stub
		return null;
	}

}
