package edu.jhu.cs.bsj.compiler.impl.tool.compiler.task;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.meta.ExplicitMetaprogramAnchorNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaAnnotationMetaprogramAnchorNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaAnnotationNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramAnchorNode;
import edu.jhu.cs.bsj.compiler.ast.util.BsjTypedNodeNoOpVisitor;
import edu.jhu.cs.bsj.compiler.impl.tool.compiler.MetacompilationContext;
import edu.jhu.cs.bsj.compiler.metaannotation.BsjMetaAnnotation;
import edu.jhu.cs.bsj.compiler.metaprogram.BsjMetaAnnotationMetaprogram;

public class ExtractMetaprogramsTask extends AbstractBsjCompilerTask
{
	/** The node whose top-level descendent metaprograms should be extracted. */
	private Node node;

	/**
	 * Creates a new task for metaprogram extraction.
	 * 
	 * @param node The node into which to descend.
	 */
	// TODO: take an argument listing the metaprogram targets on which the extracted metaprograms should implicitly
	// depend
	public ExtractMetaprogramsTask(Node node)
	{
		super(TaskPriority.EXTRACT);
		this.node = node;
	}

	@Override
	public void execute(MetacompilationContext context) throws IOException
	{
		MetaprogramAnchorLocator locator = new MetaprogramAnchorLocator();
		this.node.receiveTyped(locator);
		List<MetaprogramAnchorNode<?>> anchors = locator.getMetaprogramAnchors();

		// Handle each anchor in turn
		for (MetaprogramAnchorNode<?> anchor : anchors)
		{
			if (anchor instanceof ExplicitMetaprogramAnchorNode<?>)
			{
				ExplicitMetaprogramAnchorNode<?> explicitAnchor = (ExplicitMetaprogramAnchorNode<?>) anchor;
				if (explicitAnchor.getMetaprogram() != null)
				{
					if (LOGGER.isTraceEnabled())
					{
						LOGGER.trace("Found explicit metaprogram at " + explicitAnchor.getStartLocation());
					}
					context.registerTask(createCompileExplicitMetaprogramTask(explicitAnchor));
				}
			} else if (anchor instanceof MetaAnnotationMetaprogramAnchorNode)
			{
				// TODO: consider: maybe apply this logic to all anchors?
				// This would suggest that we make ExplicitMetaprogramAnchorNode.setMetaprogram inaccessible?
				if (context.addObservedAnchor(anchor))
				{
					MetaAnnotationMetaprogramAnchorNode metaAnnotationAnchor = (MetaAnnotationMetaprogramAnchorNode) anchor;
					MetaAnnotationNode metaAnnotation = metaAnnotationAnchor.getNearestAncestorOfType(MetaAnnotationNode.class);
					if (metaAnnotation != null)
					{
						BsjMetaAnnotation annotationObject = metaAnnotation.getMetaAnnotationObject();
						if (annotationObject instanceof BsjMetaAnnotationMetaprogram)
						{
							// register a task to build a metaprogram profile from this object
							BsjMetaAnnotationMetaprogram metaprogramObject = (BsjMetaAnnotationMetaprogram) annotationObject;
							context.registerTask(new PrepareMetaAnnotationMetaprorgamTask(metaAnnotationAnchor,
									metaprogramObject.getMetaprogram()));
							if (LOGGER.isTraceEnabled())
							{
								LOGGER.trace("Found meta-annotation metaprogram for "
										+ metaAnnotation.getAnnotationType().getName().getNameString() + " at "
										+ metaAnnotationAnchor.getStartLocation());
							}
						} else
						{
							// What is a meta-annotation with a non-metaprogram object doing with an anchor?
							throw new IllegalStateException(
									"Meta-annotation object for node at "
											+ metaAnnotation.getStartLocation()
											+ "has meta-annotation metaprogram anchor but non-metaprogram meta-annotation object");
						}
					}
				}
			} else
			{
				throw new IllegalStateException("Unrecognized metaprogram anchor type: " + anchor.getClass());
			}
		}
	}

	private static <R extends Node> CompileExplicitMetaprogramTask<R> createCompileExplicitMetaprogramTask(
			ExplicitMetaprogramAnchorNode<R> anchor)
	{
		return new CompileExplicitMetaprogramTask<R>(anchor);
	}

	/**
	 * Utilitiy class for finding metaprogram anchors within an AST.
	 * 
	 * @author Zachary Palmer
	 */
	static class MetaprogramAnchorLocator extends BsjTypedNodeNoOpVisitor
	{
		private List<MetaprogramAnchorNode<?>> metaprogramAnchors = new ArrayList<MetaprogramAnchorNode<?>>();

		private int metaprogramLevels = 0;

		@Override
		public void visitMetaprogramAnchorNodeStart(MetaprogramAnchorNode<?> node)
		{
			this.metaprogramLevels++;
		}

		@Override
		public void visitMetaprogramAnchorNodeStop(MetaprogramAnchorNode<?> node)
		{
			this.metaprogramLevels--;
			if (this.metaprogramLevels == 0)
			{
				this.metaprogramAnchors.add(node);
			}
		}

		public List<MetaprogramAnchorNode<?>> getMetaprogramAnchors()
		{
			return metaprogramAnchors;
		}
	}
}
