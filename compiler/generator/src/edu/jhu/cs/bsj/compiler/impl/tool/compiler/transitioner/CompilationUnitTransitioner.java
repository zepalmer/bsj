package edu.jhu.cs.bsj.compiler.impl.tool.compiler.transitioner;

import java.io.IOException;

import edu.jhu.cs.bsj.compiler.exception.BsjCompilerException;
import edu.jhu.cs.bsj.compiler.impl.tool.compiler.MetacompilationManager;
import edu.jhu.cs.bsj.compiler.impl.tool.compiler.CompilationUnitTracker;

/**
 * This interface represents a module which attempts to transition a compilation unit tracker from one state to another.
 * 
 * @author Zachary Palmer
 */
public interface CompilationUnitTransitioner
{
	/**
	 * Executes this task.
	 * 
	 * @param manager The manager which owns the specified tracker.
	 * @param tracker The tracker on which to operate.
	 * @throws IOException If an I/O error occurs.
	 * @throws BsjCompilerException If a compilation error occurs.
	 */
	public void execute(MetacompilationManager manager, CompilationUnitTracker tracker) throws IOException,
			BsjCompilerException;
}
