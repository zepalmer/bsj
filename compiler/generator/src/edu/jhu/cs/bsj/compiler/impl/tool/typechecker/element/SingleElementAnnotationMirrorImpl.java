package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.element;

import java.util.Collections;
import java.util.Map;

import javax.lang.model.element.AnnotationValue;
import javax.lang.model.element.ExecutableElement;

import edu.jhu.cs.bsj.compiler.ast.node.SingleElementAnnotationNode;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.TypecheckerManager;

public class SingleElementAnnotationMirrorImpl extends AnnotationMirrorImpl<SingleElementAnnotationNode>
{
	public SingleElementAnnotationMirrorImpl(TypecheckerManager manager, SingleElementAnnotationNode backingNode)
	{
		super(manager, backingNode);
	}

	@Override
	public Map<? extends ExecutableElement, ? extends AnnotationValue> getElementValues()
	{
		return Collections.singletonMap(getAnnotationExecutableElementForIdent("value"),
				AbstractAnnotationValueImpl.makeForNode(getManager(), getBackingNode().getValue()));
	}
}
