package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.element;

import javax.lang.model.element.AnnotationMirror;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;

import edu.jhu.cs.bsj.compiler.ast.node.AnnotationNode;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.NormalAnnotationNode;
import edu.jhu.cs.bsj.compiler.ast.node.SingleElementAnnotationNode;
import edu.jhu.cs.bsj.compiler.ast.util.BsjDefaultNodeOperation;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.TypecheckerManager;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.TypecheckerModelComponentImpl;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.element.api.BsjExecutableElement;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.api.BsjExplicitlyDeclaredType;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.api.BsjNamedReferenceType;
import edu.jhu.cs.bsj.compiler.impl.utils.NotImplementedYetException;

public abstract class AnnotationMirrorImpl<T extends AnnotationNode> extends TypecheckerModelComponentImpl implements
		AnnotationMirror
{
	private T backingNode;

	public AnnotationMirrorImpl(TypecheckerManager manager, T backingNode)
	{
		super(manager);
		this.backingNode = backingNode;
	}

	protected T getBackingNode()
	{
		return this.backingNode;
	}

	@Override
	public BsjExplicitlyDeclaredType getAnnotationType()
	{
		BsjNamedReferenceType type = getTypeBuilder().makeUnparameterizedType(this.backingNode.getAnnotationType());
		if (type instanceof BsjExplicitlyDeclaredType)
		{
			return (BsjExplicitlyDeclaredType)type;
		} else
		{
			// This means that the programmer has written something like @T
			// TODO: now what?
			throw new NotImplementedYetException();
		}
	}

	protected BsjExecutableElement getAnnotationExecutableElementForIdent(String ident)
	{
		for (Element element : this.getAnnotationType().asElement().getEnclosedElements())
		{
			if (element.getKind() == ElementKind.METHOD && element.getSimpleName().contentEquals(ident)
					&& element instanceof BsjExecutableElement)
			{
				return (BsjExecutableElement) element;
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

	public static AnnotationMirror makeForNode(final TypecheckerManager manager, AnnotationNode annotationNode)
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
