package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.element;

import javax.lang.model.element.AnnotationMirror;
import javax.lang.model.element.AnnotationValueVisitor;

import edu.jhu.cs.bsj.compiler.ast.node.AnnotationAnnotationValueNode;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.TypecheckerManager;

public class AnnotationAnnotationValueImpl extends AbstractAnnotationValueImpl<AnnotationAnnotationValueNode>
{
	public AnnotationAnnotationValueImpl(TypecheckerManager manager, AnnotationAnnotationValueNode backingNode)
	{
		super(manager, backingNode);
	}

	@Override
	public <R, P> R accept(AnnotationValueVisitor<R, P> v, P p)
	{
		return v.visitAnnotation(getValue(), p);
	}

	@Override
	public AnnotationMirror getValue()
	{
		return AnnotationMirrorImpl.makeForNode(getManager(), getBackingNode().getAnnotation());
	}
}
