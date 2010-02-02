package edu.jhu.cs.bsj.compiler.impl.tool.compiler;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.exception.BsjCompilerException;
import edu.jhu.cs.bsj.compiler.impl.tool.compiler.task.BsjCompilerTask;
import edu.jhu.cs.bsj.compiler.impl.tool.compiler.task.ParseCompilationUnitTask;
import edu.jhu.cs.bsj.compiler.impl.tool.filemanager.BsjFileManager;
import edu.jhu.cs.bsj.compiler.impl.tool.filemanager.BsjFileObject;

/**
 * This class represents the data structure which manages metacompilation. It tracks the progress which has been made
 * on a given compilation unit and, indirectly, any data specifically associated with it (such as its AST). The manager
 * maintains work in the form of a priority queue and is not finished until all of the work units in the priority queue
 * have been exhausted. Once a compilation unit manager reports that its work is complete, all sources have been
 * meta-compiled; the resulting generated source must still be compiled to finish BSJ compilation.
 * 
 * @author Zachary Palmer
 */
public class MetacompilationManager
{
	/**
	 * Maps the names of compilation units to their respective trackers. The trackers contain the compilation unit-
	 * specific data and the individual compilation unit statuses.
	 */
	private Map<String, CompilationUnitTracker> trackerMap;
	/**
	 * Represents the work queue. Work to be performed is enqueued here. The queue is prioritized to allow preemption of
	 * more basic tasks (such as when the type checker or metacompiler brings in another source unit for parsing).
	 */
	private PriorityQueue<BsjCompilerTask> priorityQueue;
	/**
	 * The node factory which tasks should use.
	 */
	private BsjNodeFactory factory;
	/**
	 * The file management abstraction to use.
	 */
	private BsjFileManager fileManager;

	/**
	 * Creates a new compilation unit manager.
	 * @param factory The node factory to use.
	 * @param fileManager The file management abstraction to use.
	 */
	public MetacompilationManager(BsjNodeFactory factory, BsjFileManager fileManager)
	{
		this.trackerMap = new HashMap<String, CompilationUnitTracker>();
		this.priorityQueue = new PriorityQueue<BsjCompilerTask>();
		this.factory = factory;
		this.fileManager = fileManager;
	}
	
	/**
	 * Adds a task to this manager.
	 * @param task The task to add.
	 */
	public void addTask(BsjCompilerTask task)
	{
		this.priorityQueue.offer(task);
	}

	/**
	 * Adds a compilation unit target by name.
	 * 
	 * @param binaryName The binary name of the target to add.
	 */
	public void addTarget(String binaryName)
	{
		if (trackerMap.containsKey(binaryName))
		{
			// Already have that target.
			return;
		}
		// TODO: look up the file object on the filesystem and add it as a target below
	}

	/**
	 * Adds a compilation unit target.
	 * 
	 * @param file The file to compile.
	 */
	public void addTarget(BsjFileObject file)
	{
		String binaryName = file.inferBinaryName();
		if (trackerMap.containsKey(binaryName))
		{
			// Already have that target.
			return;
		}
		CompilationUnitTracker tracker = new CompilationUnitTracker(file);
		this.trackerMap.put(binaryName, tracker);
		this.addTask(new ParseCompilationUnitTask(tracker));
	}

	/**
	 * Determines whether or not work on this manager is finished.
	 * 
	 * @return <code>true</code> if work on this manager is finished; <code>false</code> if there is more work to do.
	 */
	public boolean isFinished()
	{
		if (this.priorityQueue.size() == 0)
		{
			// Sanity check - make sure everyone is in completed state
			for (CompilationUnitTracker tracker : this.trackerMap.values())
			{
				if (tracker.getStatus() != CompilationUnitStatus.COMPLETE)
				{
					throw new IllegalStateException("Internal error: ran out of work but not everyone is complete! ("
							+ tracker.getName() + " is in state " + tracker.getStatus() + ")");
				}
			}
			return true;
		} else
		{
			return false;
		}
	}
	
	/**
	 * Instructs this compilation unit manager to do more work.
	 * @throws IOException If an I/O error occurs.
	 * @throws BsjCompilerException If a compilation error occurs.
	 * @throws IllegalStateException If no more work exists to be done.
	 */
	public void doWork() throws IOException, BsjCompilerException, IllegalStateException
	{
		if (this.priorityQueue.size() == 0)
		{
			throw new IllegalStateException("No more work to do!");
		}
		
		BsjCompilerTask task = this.priorityQueue.poll();
		task.execute(this);
	}

	public BsjNodeFactory getFactory()
	{
		return factory;
	}

	public BsjFileManager getFileManager()
	{
		return fileManager;
	}
}