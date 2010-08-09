package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.element;

import javax.lang.model.element.AnnotationMirror;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.type.DeclaredType;

import edu.jhu.cs.bsj.compiler.ast.node.AnnotationNode;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.NormalAnnotationNode;
import edu.jhu.cs.bsj.compiler.ast.node.SingleElementAnnotationNode;
import edu.jhu.cs.bsj.compiler.ast.util.BsjDefaultNodeOperation;
import edu.jhu.cs.bsj.compiler.impl.NotImplementedYetException;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.TypecheckerModelComponentImpl;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.TypecheckerModelManager;

public abstract class AnnotationMirrorImpl<T extends AnnotationNode> extends TypecheckerModelComponentImpl implements
		AnnotationMirror
{
	private T backingNode;

	public AnnotationMirrorImpl(TypecheckerModelManager manager, T backingNode)
	{
		super(manager);
		this.backingNode = backingNode;
	}

	protected T getBackingNode()
	{
		return this.backingNode;
	}

	@Override
	public DeclaredType getAnnotationType()
	{
		return (DeclaredType) makeType(this.backingNode.getAnnotationType());
	}

	protected ExecutableElement getAnnotationExecutableElementForIdent(String ident)
	{
		for (Element element : this.getAnnotationType().asElement().getEnclosedElements())
		{
			if (element.getKind() == ElementKind.METHOD && element.getSimpleName().contentEquals(ident)
					&& element instanceof ExecutableElement)
			{
				return (ExecutableElement) element;
			}
		}
		// TODO: report an appropriate diagnostic here
		/*
		 * Reaching this point in the code represents a case in which the programmer has assigned a value to an
		 * annotation element which does not exist.  For instance, consider:
		 *     @Foo(x=5,y=6)
		 *     pubic @interface Foo {
		 *         public int x();
		 *     }
		 * In this case, the use of @Foo attempts to define an element value for element y when no such element exists.
		 */
		throw new NotImplementedYetException();
	}

	public static AnnotationMirror makeForNode(final TypecheckerModelManager manager, AnnotationNode annotationNode)
	{
		return annotationNode.executeOperation(new BsjDefaultNodeOperation<Void, AnnotationMirror>()
		{
			@Override
			public AnnotationMirror executeDefault(Node node, Void p)
			{
				throw new IllegalStateException("Don't know how to handle AnnotationNode of type " + node.getClass());
			}

			@Override
			public AnnotationMirror executeNormalAnnotationNode(NormalAnnotationNode node, Void p)
			{
				return new NormalAnnotationMirrorImpl(manager, node);
			}

			@Override
			public AnnotationMirror executeSingleElementAnnotationNode(SingleElementAnnotationNode node, Void p)
			{
				return new SingleElementAnnotationMirrorImpl(manager, node);
			}
		}, null);
	}
}