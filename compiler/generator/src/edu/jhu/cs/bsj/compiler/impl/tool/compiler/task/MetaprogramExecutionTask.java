package edu.jhu.cs.bsj.compiler.impl.tool.compiler.task;

import java.io.IOException;

import edu.jhu.cs.bsj.compiler.exception.BsjCompilerException;
import edu.jhu.cs.bsj.compiler.impl.tool.compiler.CompilationUnitStatus;
import edu.jhu.cs.bsj.compiler.impl.tool.compiler.CompilationUnitTracker;
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
public class MetaprogramExecutionTask extends AbstractBsjCompilerTask
{
	public MetaprogramExecutionTask()
	{
		super(TaskPriority.EXECUTE);
	}

	@Override
	public void execute(MetacompilationManager manager) throws IOException, BsjCompilerException
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
	
	private void execute(MetaprogramProfile profile, MetacompilationManager manager)
	{
		// Run the metaprogram
		profile.getMetaprogram().execute();
		
		// Have the metaprogram replace itself with its replacement node
		profile.getAnchor().getParent().replace(profile.getAnchor(), profile.getAnchor().getReplacement());
		
		// Transition the affected tracker
		// TODO: If the metaprogram introduces sub-metaprograms, what do we do?  Move back to extraction?
		// There's a good reason we'd want to do this: generating code that uses @Property, for example.
		profile.getTracker().setMetaprogramsOutstanding(profile.getTracker().getMetaprogramsOutstanding()-1);
		if (profile.getTracker().getMetaprogramsOutstanding()==0)
		{
			profile.getTracker().setStatus(CompilationUnitStatus.METAPROGRAMS_EXECUTED);
		}
		
		// Re-enqueue this task so we can execute the next metaprogram when the time comes (which is probably right now)
		manager.addTask(this);
	}
}
