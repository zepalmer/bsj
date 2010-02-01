package edu.jhu.cs.bsj.compiler.impl.tool.compiler.task;

import java.io.IOException;

import edu.jhu.cs.bsj.compiler.exception.BsjCompilerException;
import edu.jhu.cs.bsj.compiler.impl.tool.compiler.CompilationUnitManager;

/**
 * This interface is implemented by all classes which act as tasks for a compilation unit in the BSJ compiler.
 * 
 * @author Zachary Palmer
 */
public interface BsjCompilerTask
{
	/**
	 * Executes this task.
	 * 
	 * @param manager The manager which owns the specified tracker.
	 * @throws IOException If an I/O error occurs.
	 * @throws BsjCompilerException If a compilation error occurs.
	 */
	public void execute(CompilationUnitManager manager) throws IOException,
			BsjCompilerException;
}
