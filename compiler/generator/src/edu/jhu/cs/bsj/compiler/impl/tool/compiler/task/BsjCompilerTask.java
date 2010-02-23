package edu.jhu.cs.bsj.compiler.impl.tool.compiler.task;

import java.io.IOException;

import edu.jhu.cs.bsj.compiler.impl.tool.compiler.MetacompilationContext;

/**
 * This interface is implemented by all classes which act as tasks for a compilation unit in the BSJ compiler.
 * 
 * @author Zachary Palmer
 */
public interface BsjCompilerTask extends Comparable<BsjCompilerTask>
{
	/**
	 * Executes this task.  If errors occur, they are reported to the diagnostic listener on the metacompilation
	 * manager.
	 * 
	 * @param context The context in which this task should operate.
	 * @throws IOException If an I/O error occurs.
	 */
	public void execute(MetacompilationContext context) throws IOException;
	
	/**
	 * Retrieves the {@link TaskPriority} of this compiler task.
	 */
	public TaskPriority getPriority();
	
	/**
	 * Retrieves a value uniquely identifying this {@link BsjCompilerTask}.  This UID applies only to the specific class
	 * of compiler task the instance represents; two different class instances may have different UID namespaces.
	 */
	public int getUid();
}
