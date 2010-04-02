package edu.jhu.cs.bsj.compiler.impl.tool.compiler.task;

import java.io.IOException;

import edu.jhu.cs.bsj.compiler.impl.tool.compiler.MetacompilationContext;

/**
 * This task is intended to function as a debugging mechanism, ensuring that the operation of the compiler was sane.
 * @author Zachary Palmer
 */
public class SanityCheckTask extends AbstractBsjCompilerTask
{
	// TODO: provide some environmental option allowing the sanity check to be disabled
	// Specifically, this test should not be necessary during normal operation of the compiler if everything has been
	// implemented well.  For development purposes, though, it's quite handy to track down problems.
	/**
	 * Performs a sanity check for the compiler.
	 */
	public SanityCheckTask()
	{
		super(TaskPriority.SANITY_CHECK);
	}

	@Override
	public void execute(MetacompilationContext context) throws IOException
	{
		context.getDependencyManager().assertNoCycles();
		context.getDependencyManager().assertNoInjectionConflict();
	}
}
