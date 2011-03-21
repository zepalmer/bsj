package edu.jhu.cs.bsj.compiler.impl.tool.compiler.task;

import java.io.IOException;

import edu.jhu.cs.bsj.compiler.ast.node.CompilationUnitNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaAnnotationListNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramImportListNode;
import edu.jhu.cs.bsj.compiler.ast.util.BsjTypedNodeNoOpVisitor;
import edu.jhu.cs.bsj.compiler.impl.tool.compiler.MetacompilationContext;

/**
 * This task removes meta-annotation nodes and other BSJ-specific content from the provided compilation unit to prepare
 * it for serialization.
 * 
 * @author Zachary Palmer
 */
public class StripBsjNodesTask extends AbstractBsjCompilerTask
{
	/** The compilation unit for which BSJ nodes should be stripped. */
	private CompilationUnitNode node;

	public StripBsjNodesTask(CompilationUnitNode node)
	{
		super(TaskPriority.STRIP_BSJ_NODES);
		this.node = node;
	}

	@Override
	public void execute(MetacompilationContext context) throws IOException
	{
		this.node.receiveTyped(new BsjTypedNodeNoOpVisitor()
		{
			@Override
			public void visitMetaAnnotationListNodeStop(MetaAnnotationListNode node, boolean mostSpecific)
			{
				node.clear();
			}

			@Override
			public void visitMetaprogramImportListNodeStop(MetaprogramImportListNode node, boolean mostSpecific)
			{
				node.clear();
			}
		});
	}
}
