package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.element;

import javax.lang.model.element.AnnotationValue;

import edu.jhu.cs.bsj.compiler.ast.node.AnnotationAnnotationValueNode;
import edu.jhu.cs.bsj.compiler.ast.node.AnnotationArrayValueNode;
import edu.jhu.cs.bsj.compiler.ast.node.AnnotationExpressionValueNode;
import edu.jhu.cs.bsj.compiler.ast.node.AnnotationValueNode;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.util.BsjDefaultNodeOperation;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.TypecheckerModelComponentImpl;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.TypecheckerModelManager;

public abstract class AbstractAnnotationValueImpl<T extends AnnotationValueNode> extends TypecheckerModelComponentImpl
		implements AnnotationValue
{
	private T backingNode;

	public AbstractAnnotationValueImpl(TypecheckerModelManager manager, T backingNode)
	{
		super(manager);
		this.backingNode = backingNode;
	}

	protected T getBackingNode()
	{
		return this.backingNode;
	}

	public static AnnotationValue makeForNode(final TypecheckerModelManager manager, AnnotationValueNode annotationNode)
	{
		return annotationNode.executeOperation(new BsjDefaultNodeOperation<Void, AnnotationValue>()
		{
			@Override
			public AnnotationValue executeDefault(Node node, Void p)
			{
				throw new IllegalStateException("Don't know how to handle AnnotationValue of type " + node.getClass());
			}

			@Override
			public AnnotationValue executeAnnotationAnnotationValueNode(AnnotationAnnotationValueNode node, Void p)
			{
				return new AnnotationAnnotationValueImpl(manager, node);
			}

			@Override
			public AnnotationValue executeAnnotationArrayValueNode(AnnotationArrayValueNode node, Void p)
			{
				return new AnnotationArrayValueImpl(manager, node);
			}

			@Override
			public AnnotationValue executeAnnotationExpressionValueNode(AnnotationExpressionValueNode node, Void p)
			{
				return new AnnotationExpressionValueImpl(manager, node);
			}
		}, null);
	}
}
