package edu.jhu.cs.bsj.compiler.impl.tool.compiler.task;

import java.io.IOException;
import java.util.Iterator;

import edu.jhu.cs.bsj.compiler.ast.node.CompilationUnitNode;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.impl.tool.compiler.CompilationUnitStatus;
import edu.jhu.cs.bsj.compiler.impl.tool.compiler.MetacompilationContext;
import edu.jhu.cs.bsj.compiler.impl.tool.compiler.MetaprogramProfile;

/**
 * This metacompilation task attempts to execute a single metaprogram. If a metaprogram is available for execution, it
 * will be executed and this task will re-enqueue itself. Otherwise, this task will assert that all compilation units
 * are in the state {@link CompilationUnitStatus#METAPROGRAMS_EXECUTED} and then create a source serialization task for
 * each one of them.
 * 
 * @author Zachary Palmer
 */
public class ExecuteMetaprogramTask extends AbstractBsjCompilerTask
{
	public ExecuteMetaprogramTask()
	{
		super(TaskPriority.EXECUTE);
	}

	@Override
	public void execute(MetacompilationContext context) throws IOException
	{
		MetaprogramProfile profile = context.getDependencyManager().getNextMetaprogram();
		if (profile==null)
		{
			finishMetaprogramExecutionPhase(context);
		} else
		{
			execute(profile, context);
		}
	}

	private void finishMetaprogramExecutionPhase(MetacompilationContext context)
	{
		Iterator<CompilationUnitNode> it = context.getRootPackage().getRecursiveCompilationUnitIterator();
		while (it.hasNext())
		{
			CompilationUnitNode node = it.next();
			// TODO: skip nodes which represent binary files
			context.registerTask(new SourceSerializationTask(node));
		}
	}
	
	private void execute(MetaprogramProfile profile, MetacompilationContext context)
	{
		// Run the metaprogram
		profile.getMetaprogram().execute();
		context.getDependencyManager().notifyExecuted(profile);
		
		// Have the metaprogram replace itself with its replacement node
		Node replacement = profile.getAnchor().getReplacement();
		profile.getAnchor().getParent().replace(profile.getAnchor(), replacement);

		// Schedule a task to walk over the replacement node and extract all of its descendent metaprograms
		context.registerTask(new ExtractMetaprogramsTask(replacement));
		
		// Re-enqueue this task so we can execute the next metaprogram when the time comes (which is probably right now)
		context.registerTask(this);
	}
}
