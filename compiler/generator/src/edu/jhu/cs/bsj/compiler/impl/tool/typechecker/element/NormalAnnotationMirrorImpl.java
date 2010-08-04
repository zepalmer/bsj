package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.element;

import java.util.HashMap;
import java.util.Map;

import javax.lang.model.element.AnnotationValue;
import javax.lang.model.element.ExecutableElement;

import edu.jhu.cs.bsj.compiler.ast.node.AnnotationElementNode;
import edu.jhu.cs.bsj.compiler.ast.node.NormalAnnotationNode;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.TypecheckerModelManager;

public class NormalAnnotationMirrorImpl extends AnnotationMirrorImpl<NormalAnnotationNode>
{
	public NormalAnnotationMirrorImpl(TypecheckerModelManager manager, NormalAnnotationNode backingNode)
	{
		super(manager, backingNode);
	}

	@Override
	public Map<? extends ExecutableElement, ? extends AnnotationValue> getElementValues()
	{
		Map<ExecutableElement, AnnotationValue> map = new HashMap<ExecutableElement, AnnotationValue>();
		for (AnnotationElementNode elementNode : getBackingNode().getArguments())
		{
			ExecutableElement element = getAnnotationExecutableElementForIdent(elementNode.getIdentifier().getIdentifier());
			map.put(element, AbstractAnnotationValueImpl.makeForNode(getManager(), elementNode.getValue()));
		}
		return map;
	}
}
