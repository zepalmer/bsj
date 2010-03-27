package edu.jhu.cs.bsj.compiler.impl.tool.compiler.task;

import java.io.IOException;

import edu.jhu.cs.bsj.compiler.ast.node.CompilationUnitNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaAnnotationListNode;
import edu.jhu.cs.bsj.compiler.ast.util.BsjTypedNodeNoOpVisitor;
import edu.jhu.cs.bsj.compiler.impl.tool.compiler.MetacompilationContext;

/**
 * This task removes meta-annotation nodes from the provided compilation unit to prepare it for serialization.
 * @author Zachary Palmer
 */
public class StripMetaAnnotationsTask extends AbstractBsjCompilerTask
{
	/** The compilation unit for which meta-annotations should be stripped. */
	private CompilationUnitNode node;

	public StripMetaAnnotationsTask(CompilationUnitNode node)
	{
		super(TaskPriority.STRIP_METAANNOTATIONS);
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
		});
		
		// Now serialize
		context.registerTask(new SourceSerializationTask(node));
	}	
}
