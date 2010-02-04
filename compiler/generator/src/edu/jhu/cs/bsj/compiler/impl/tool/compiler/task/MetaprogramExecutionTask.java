package edu.jhu.cs.bsj.compiler.impl.tool.compiler.task;

import java.io.IOException;

import edu.jhu.cs.bsj.compiler.exception.BsjCompilerException;
import edu.jhu.cs.bsj.compiler.impl.tool.compiler.CompilationUnitStatus;
import edu.jhu.cs.bsj.compiler.impl.tool.compiler.CompilationUnitTracker;
import edu.jhu.cs.bsj.compiler.impl.tool.compiler.MetacompilationManager;

/**
 * This metacompilation task attempts to execute a single metaprogram. If a metaprogram is available for execution, it
 * will be executed and this task will re-enqueue itself. Otherwise, this task will assert that all compilation units
 * are in the state {@link CompilationUnitStatus#METAPROGRAMS_EXECUTED} and then create a source serialization task for
 * each one of them.
 * 
 * @author Zachary Palmer
 */
public class MetaprogramExecutionTask extends AbstractBsjCompilerTask
{
	public MetaprogramExecutionTask()
	{
		super(TaskPriority.EXECUTE);
	}

	@Override
	public void execute(MetacompilationManager manager) throws IOException, BsjCompilerException
	{
		// TODO: check to see if a metaprogram exists to execute; if so, execute it
		finishMetaprogramExecutionPhase(manager);
	}

	private void finishMetaprogramExecutionPhase(MetacompilationManager manager)
	{
		for (CompilationUnitTracker tracker : manager.getAllTrackers())
		{
			if (tracker.getStatus() != CompilationUnitStatus.METAPROGRAMS_EXECUTED)
			{
				throw new IllegalStateException("No metaprograms left to run but tracker for " + tracker.getName()
						+ " is in status " + tracker.getStatus());
			}
			manager.addTask(new SourceSerializationTask(tracker));
		}
	}
}
