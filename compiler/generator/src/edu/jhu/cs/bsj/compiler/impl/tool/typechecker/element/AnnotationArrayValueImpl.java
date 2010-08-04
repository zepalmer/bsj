package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.element;

import java.util.ArrayList;
import java.util.List;

import javax.lang.model.element.AnnotationValue;
import javax.lang.model.element.AnnotationValueVisitor;

import edu.jhu.cs.bsj.compiler.ast.node.AnnotationArrayValueNode;
import edu.jhu.cs.bsj.compiler.ast.node.AnnotationValueNode;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.TypecheckerModelManager;

public class AnnotationArrayValueImpl extends AbstractAnnotationValueImpl<AnnotationArrayValueNode>
{
	public AnnotationArrayValueImpl(TypecheckerModelManager manager, AnnotationArrayValueNode backingNode)
	{
		super(manager, backingNode);
	}

	@Override
	public <R, P> R accept(AnnotationValueVisitor<R, P> v, P p)
	{
		return v.visitArray(getValue(), p);
	}

	@Override
	public List<? extends AnnotationValue> getValue()
	{
		List<AnnotationValue> list = new ArrayList<AnnotationValue>();
		for (AnnotationValueNode valueNode : getBackingNode().getValues())
		{
			list.add(AbstractAnnotationValueImpl.makeForNode(getManager(), valueNode));
		}
		return list;
	}

}
