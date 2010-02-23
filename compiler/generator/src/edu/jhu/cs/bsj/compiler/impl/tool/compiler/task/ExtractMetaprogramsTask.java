package edu.jhu.cs.bsj.compiler.impl.tool.compiler.task;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramAnchorNode;
import edu.jhu.cs.bsj.compiler.ast.util.BsjTypedNodeNoOpVisitor;
import edu.jhu.cs.bsj.compiler.impl.tool.compiler.MetacompilationContext;

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
			context.registerTask(new CompileMetaprogramTask(anchor));
		}
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
