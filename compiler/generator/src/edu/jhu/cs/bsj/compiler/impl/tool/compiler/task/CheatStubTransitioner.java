package edu.jhu.cs.bsj.compiler.impl.tool.compiler.task;

import java.io.IOException;

import edu.jhu.cs.bsj.compiler.exception.BsjCompilerException;
import edu.jhu.cs.bsj.compiler.impl.tool.compiler.CompilationUnitManager;
import edu.jhu.cs.bsj.compiler.impl.tool.compiler.CompilationUnitStatus;
import edu.jhu.cs.bsj.compiler.impl.tool.compiler.CompilationUnitTracker;

/**
 * This stub task is used to pretend that the a compilation unit tracker has finished all of its work. It is used for
 * testing purposes only and should be deleted before BSJ is released.
 * 
 * @author Zachary Palmer
 */
// TODO: delete this class!
public class CheatStubTransitioner extends AbstractCompilationUnitTransitioner
{
	@Override
	public void execute(CompilationUnitManager manager, CompilationUnitTracker tracker) throws IOException,
			BsjCompilerException
	{
		tracker.setStatus(CompilationUnitStatus.READY_TO_SERIALIZE);
	}
}
