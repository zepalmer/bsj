package edu.jhu.cs.bsj.compiler.impl.tool.compiler;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

import javax.tools.DiagnosticListener;
import javax.tools.JavaFileObject;

import org.apache.log4j.Logger;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.impl.tool.compiler.dependency.DependencyManager;
import edu.jhu.cs.bsj.compiler.impl.tool.compiler.task.BsjCompilerTask;
import edu.jhu.cs.bsj.compiler.impl.tool.compiler.task.MetaprogramExecutionTask;
import edu.jhu.cs.bsj.compiler.impl.tool.compiler.task.ParseCompilationUnitTask;
import edu.jhu.cs.bsj.compiler.impl.tool.filemanager.BsjFileManager;
import edu.jhu.cs.bsj.compiler.impl.tool.filemanager.BsjFileObject;

/**
 * This class represents the data structure which manages metacompilation. It tracks the progress which has been made on
 * a given compilation unit and, indirectly, any data specifically associated with it (such as its AST). The manager
 * maintains work in the form of a priority queue and is not finished until all of the work units in the priority queue
 * have been exhausted. Once a compilation unit manager reports that its work is complete, all sources have been
 * meta-compiled; the resulting generated source must still be compiled to finish BSJ compilation.
 * 
 * @author Zachary Palmer
 */
public class MetacompilationManager
{
	/** A logger for this metacompilation manager. */
	private final Logger LOGGER = Logger.getLogger(this.getClass());

	/**
	 * Maps the names of compilation units to their respective trackers. The trackers contain the compilation unit-
	 * specific data and the individual compilation unit statuses.
	 */
	private Map<String, CompilationUnitTracker> trackerMap;
	/**
	 * Represents the work queue. Work to be performed is enqueued here. The queue is prioritized to allow preemption of
	 * more basic tasks (such as when the type checker or metacompiler brings in another source unit for parsing).
	 */
	private Queue<BsjCompilerTask> priorityQueue;
	/**
	 * The node factory which tasks should use.
	 */
	private BsjNodeFactory factory;
	/**
	 * The file management abstraction to use.
	 */
	private BsjFileManager fileManager;
	/**
	 * The listener to which we will report events.
	 */
	private DiagnosticListener<? super JavaFileObject> diagnosticListener;

	/**
	 * Represents the metaprogram dependency manager.
	 */
	private DependencyManager dependencyManager;

	/**
	 * Creates a new compilation unit manager.
	 * 
	 * @param factory The node factory to use.
	 * @param fileManager The file management abstraction to use.
	 * @param diagnosticListener The listener to which diagnostics will be reported. Must not be <code>null</code>.
	 */
	public MetacompilationManager(BsjNodeFactory factory, BsjFileManager fileManager,
			DiagnosticListener<? super JavaFileObject> diagnosticListener)
	{
		this.trackerMap = new HashMap<String, CompilationUnitTracker>();
		this.priorityQueue = new PriorityQueue<BsjCompilerTask>();
		this.factory = factory;
		this.fileManager = fileManager;
		this.diagnosticListener = diagnosticListener;

		this.dependencyManager = new DependencyManager();
		this.priorityQueue.offer(new MetaprogramExecutionTask());
	}

	/**
	 * Adds a task to this manager.
	 * 
	 * @param task The task to add.
	 */
	public void addTask(BsjCompilerTask task)
	{
		this.priorityQueue.offer(task);
	}

	// TODO: remove.  This approach is not sane.
	/**
	 * Adds a compilation unit target by name.  This function determines the name of the source file which would contain
	 * that type by walking the contents of the source path and checking for files which could stand as the type.  For
	 * example, consider the type <code>com.example.Foo.Bar</code> and assume it is named according to standard
	 * conventions.  This method would search, in order for
	 * <ul>
	 * <li><code>com.bsj</code></li>
	 * <li><code>com.java</code></li>
	 * <li><code>com/example.bsj</code></li>
	 * <li><code>com/example.java</code></li>
	 * <li><code>com/example/Foo.bsj</code></li>
	 * </ul>
	 * At this point, it presumably would've found its source file.  If not, it would continue until it had exhausted
	 * its alternatives.  Note that this approach is compatible with the definition of shadowing in &#xA7;6.3.1 of
	 * the Java Language Specification v3 as well as the definition of contextually ambiguous name resolution in
	 * &#xA7;6.5.2 of the same document.  For instance, in the particularly convoluted case of a class named
	 * "<code>foo</code>" and another class named "<code>foo.Bar</code>", it would be impossible for another file 
	 * 
	 * 
	 * @param typeName The type name of the target to add.
	 * @return <code>true</code> if the target of the specified name was added; <code>false</code> if it did not exist
	 *         or was previously loaded.
	 */
	public boolean addTargetByTypeName(String typeName)
	{
		if (trackerMap.containsKey(typeName))
		{
			// Already have that target.
			return false;
		}
		// TODO: look up the file object on the filesystem and add it as a target below
		return false;
	}

	/**
	 * Adds a compilation unit target.
	 * 
	 * @param file The file to compile.
	 * @return <code>true</code> if the target of the specified name was added; <code>false</code> if it did not exist
	 *         or was previously loaded.
	 */
	public boolean addTarget(BsjFileObject file)
	{
		String binaryName = file.inferBinaryName();
		if (trackerMap.containsKey(binaryName))
		{
			// Already have that target.
			return false;
		}
		CompilationUnitTracker tracker = new CompilationUnitTracker(file);
		this.trackerMap.put(binaryName, tracker);
		this.addTask(new ParseCompilationUnitTask(tracker));
		return true;
	}

	/**
	 * Registers a metaprogram for execution.
	 * 
	 * @param profile The profile of the metaprogram which will be executed.
	 */
	public void registerMetaprogramProfile(MetaprogramProfile profile)
	{
		this.dependencyManager.registerMetaprogramProfile(profile);
	}

	/**
	 * Retrieves the next metaprogram to execute. The caller of this method must execute the metaprogram in the provided
	 * profile or else re-register it with this metacompilation manager.
	 * 
	 * @return The next metaprogram to execute or <code>null</code> if no metaprograms remain.
	 */
	public MetaprogramProfile getNextMetaprogramProfile()
	{
		return this.dependencyManager.getNextMetaprogram();
	}

	/**
	 * Indicates that the specified profile's metaprogram has been executed.
	 * 
	 * @param profile The profile of the metaprogram which was executed.
	 */
	public void notifyExecuted(MetaprogramProfile profile)
	{
		this.dependencyManager.notifyExecuted(profile);
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
	 * Retrieves a collection of all of the trackers that this compilation manager knows about.
	 * 
	 * @return A collection of all of the trackers that this compilation manager knows about.
	 */
	public Collection<CompilationUnitTracker> getAllTrackers()
	{
		return this.trackerMap.values();
	}

	/**
	 * Instructs this compilation unit manager to do more work.
	 * 
	 * @throws IOException If an I/O error occurs.
	 * @throws IllegalStateException If no more work exists to be done.
	 */
	public void doWork() throws IOException, IllegalStateException
	{
		if (this.priorityQueue.size() == 0)
		{
			throw new IllegalStateException("No more work to do!");
		}

		BsjCompilerTask task = this.priorityQueue.poll();
		if (LOGGER.isTraceEnabled())
		{
			LOGGER.trace("Executing next compilation task: " + task.toString());
		}
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

	public DiagnosticListener<? super JavaFileObject> getDiagnosticListener()
	{
		return diagnosticListener;
	}
}