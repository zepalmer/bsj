package edu.jhu.cs.bsj.compiler.impl.tool.compiler;

import java.io.IOException;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

import javax.tools.DiagnosticListener;
import javax.tools.JavaFileObject;

import org.apache.log4j.Logger;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.node.PackageNode;
import edu.jhu.cs.bsj.compiler.impl.tool.compiler.dependency.DependencyManager;
import edu.jhu.cs.bsj.compiler.impl.tool.compiler.task.BsjCompilerTask;
import edu.jhu.cs.bsj.compiler.impl.tool.compiler.task.ExecuteMetaprogramTask;
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
	 * The collection of binary names we have been asked to compile. This is used to prevent duplicate loads.
	 */
	private Set<String> observedBinaryNames;
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
	 * The root package used during this compilation process.
	 */
	private PackageNode rootPackage;

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
		this.observedBinaryNames = new HashSet<String>();
		this.priorityQueue = new PriorityQueue<BsjCompilerTask>();
		this.factory = factory;
		this.fileManager = fileManager;
		this.diagnosticListener = diagnosticListener;

		this.dependencyManager = new DependencyManager();
		this.priorityQueue.offer(new ExecuteMetaprogramTask());

		this.rootPackage = factory.makePackageNode(null);
	}

	/**
	 * Adds a task to this manager.
	 * 
	 * @param task The task to add.
	 */
	public void addTask(BsjCompilerTask task)
	{
		if (LOGGER.isTraceEnabled())
		{
			LOGGER.trace("Received compiler task " + task);
		}
		this.priorityQueue.offer(task);
	}

	/**
	 * Adds a compilation unit target.
	 * 
	 * @param file The file to load.
	 * @return <code>true</code> if the target of the specified name was added; <code>false</code> if it did not exist
	 *         or was previously loaded.
	 */
	public boolean addCompilationUnit(BsjFileObject file)
	{
		String binaryName = file.inferBinaryName();
		if (observedBinaryNames.contains(binaryName))
		{
			// Already have that target.
			return false;
		}

		// TODO: what if the file is a binary?

		observedBinaryNames.add(binaryName);
		
		ParseCompilationUnitTask parseCompilationUnitTask = new ParseCompilationUnitTask(file);
		this.addTask(parseCompilationUnitTask);
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
		return this.priorityQueue.size() == 0;
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

	public PackageNode getRootPackage()
	{
		return rootPackage;
	}
}