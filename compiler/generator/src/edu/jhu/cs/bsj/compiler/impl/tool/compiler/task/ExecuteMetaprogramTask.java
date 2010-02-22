package edu.jhu.cs.bsj.compiler.impl.tool.compiler.task;

import java.io.IOException;
import java.util.Iterator;

import edu.jhu.cs.bsj.compiler.ast.node.CompilationUnitNode;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.impl.tool.compiler.CompilationUnitStatus;
import edu.jhu.cs.bsj.compiler.impl.tool.compiler.MetacompilationManager;
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
	public void execute(MetacompilationManager manager) throws IOException
	{
		MetaprogramProfile profile = manager.getNextMetaprogramProfile();
		if (profile==null)
		{
			finishMetaprogramExecutionPhase(manager);
		} else
		{
			execute(profile, manager);
		}
	}

	private void finishMetaprogramExecutionPhase(MetacompilationManager manager)
	{
		Iterator<CompilationUnitNode> it = manager.getRootPackage().getRecursiveCompilationUnitIterator();
		while (it.hasNext())
		{
			CompilationUnitNode node = it.next();
			// TODO: skip nodes which represent binary files
			manager.addTask(new SourceSerializationTask(node));
		}
	}
	
	private void execute(MetaprogramProfile profile, MetacompilationManager manager)
	{
		// Run the metaprogram
		profile.getMetaprogram().execute();
		manager.notifyExecuted(profile);
		
		// Have the metaprogram replace itself with its replacement node
		Node replacement = profile.getAnchor().getReplacement();
		profile.getAnchor().getParent().replace(profile.getAnchor(), replacement);

		// Schedule a task to walk over the replacement node and extract all of its descendent metaprograms
		manager.addTask(new ExtractMetaprogramsTask(replacement));
		
		// Re-enqueue this task so we can execute the next metaprogram when the time comes (which is probably right now)
		manager.addTask(this);
	}
}
