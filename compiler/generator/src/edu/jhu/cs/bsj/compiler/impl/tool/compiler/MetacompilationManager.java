package edu.jhu.cs.bsj.compiler.impl.tool.compiler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.WeakHashMap;

import javax.tools.DiagnosticListener;
import javax.tools.Diagnostic.Kind;

import org.apache.log4j.Logger;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.node.CompilationUnitNode;
import edu.jhu.cs.bsj.compiler.ast.node.PackageNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramAnchorNode;
import edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeManager;
import edu.jhu.cs.bsj.compiler.impl.diagnostic.CountingDiagnosticProxyListener;
import edu.jhu.cs.bsj.compiler.impl.tool.compiler.dependency.DependencyManager;
import edu.jhu.cs.bsj.compiler.impl.tool.compiler.task.AbstractCompilationUnitBuilderTask;
import edu.jhu.cs.bsj.compiler.impl.tool.compiler.task.BsjCompilerTask;
import edu.jhu.cs.bsj.compiler.impl.tool.compiler.task.ExecuteMetaprogramTask;
import edu.jhu.cs.bsj.compiler.impl.tool.compiler.task.LoadBinaryCompilationUnitTask;
import edu.jhu.cs.bsj.compiler.impl.tool.compiler.task.ParseCompilationUnitTask;
import edu.jhu.cs.bsj.compiler.impl.tool.compiler.task.SanityCheckTask;
import edu.jhu.cs.bsj.compiler.impl.tool.compiler.task.TaskPriority;
import edu.jhu.cs.bsj.compiler.tool.BsjToolkit;
import edu.jhu.cs.bsj.compiler.tool.filemanager.BsjFileObject;

/**
 * This class represents the data structure which manages metacompilation. It tracks the progress which has been made on
 * a given compilation unit and, indirectly, any data specifically associated with it (such as its AST). The manager
 * maintains work in the form of a priority queue and is not finished until all of the work units in the priority queue
 * have been exhausted. Once a compilation unit manager reports that its work is complete, all sources have been
 * meta-compiled; the resulting generated source must still be compiled to finish BSJ compilation.
 * 
 * @author Zachary Palmer
 */
public class MetacompilationManager implements MetacompilationContext
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
	 * The toolkit to use to satisfy tool requirements.
	 */
	private BsjToolkit toolkit;
	/**
	 * The node manager to use.
	 */
	private BsjNodeManager nodeManager;
	/**
	 * The listener to which we will report events.
	 */
	private CountingDiagnosticProxyListener<BsjSourceLocation> diagnosticListener;

	/**
	 * Represents the metaprogram dependency manager.
	 */
	private DependencyManager dependencyManager;
	/**
	 * The root package used during this compilation process.
	 */
	private PackageNode rootPackage;

	/**
	 * The list of source files that this metacompilation manager has serialized.
	 */
	private List<BsjFileObject> serializedFiles;
	/**
	 * The set of observed metaprogram anchor nodes stored as a presence map.
	 */
	private Map<MetaprogramAnchorNode<?>, Object> observedAnchors;

	/**
	 * Creates a new compilation unit manager.
	 * 
	 * @param toolkit The toolkit to use.
	 * @param nodeManager The node manager to use.
	 * @param diagnosticListener The listener to which diagnostics will be reported. Must not be <code>null</code>.
	 */
	public MetacompilationManager(BsjToolkit toolkit, BsjNodeManager nodeManager,
			DiagnosticListener<BsjSourceLocation> diagnosticListener)
	{
		this.observedBinaryNames = new HashSet<String>();
		this.priorityQueue = new PriorityQueue<BsjCompilerTask>();
		this.dependencyManager = new DependencyManager();

		this.toolkit = toolkit;
		this.nodeManager = nodeManager;
		this.diagnosticListener = new CountingDiagnosticProxyListener<BsjSourceLocation>(diagnosticListener);

		this.rootPackage = toolkit.getNodeFactory().makePackageNode(null);
		this.serializedFiles = new ArrayList<BsjFileObject>();
		this.observedAnchors = new WeakHashMap<MetaprogramAnchorNode<?>, Object>();

		// Add some initial tasks to the task queue
		this.priorityQueue.offer(new ExecuteMetaprogramTask());
		this.priorityQueue.offer(new SanityCheckTask());
	}

	/**
	 * Adds a task to this manager.
	 * 
	 * @param task The task to add.
	 */
	public void registerTask(BsjCompilerTask task)
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
			LOGGER.trace("Not loading " + file + ": already loaded.");
			// Already have that target.
			return false;
		}

		if (LOGGER.isTraceEnabled())
		{
			LOGGER.trace("Loading " + file);
		}

		observedBinaryNames.add(binaryName);

		// pick a task based on whether or not the file appears to be a binary
		AbstractCompilationUnitBuilderTask task;
		if (file.getName().endsWith(".class"))
		{
			task = new LoadBinaryCompilationUnitTask(file, getCurrentMetaprogram());
		} else
		{
			task = new ParseCompilationUnitTask(file, getCurrentMetaprogram());
		}
		this.registerTask(task);
		return true;
	}

	/**
	 * Adds a compilation unit target. This method does not schedule the file for parsing in the queue but rather
	 * performs the immediate parsing and metaprogram extraction of the named compilation unit.
	 * 
	 * @param file The file to load.
	 * @return The compilation unit which was loaded or <code>null</code> if the compilation unit does not exist.
	 */
	public CompilationUnitNode addCompilationUnitNow(BsjFileObject file)
	{
		String binaryName = file.inferBinaryName();
		if (observedBinaryNames.contains(binaryName))
		{
			// Already have that target. Let's go find it.
			LOGGER.trace("Not loading " + file + " immediately: already loaded.");
			String compilationUnitName;
			PackageNode packageNode = rootPackage;
			if (binaryName.indexOf('.') != -1)
			{
				String packageName;
				packageName = binaryName.substring(0, binaryName.lastIndexOf('.'));
				compilationUnitName = binaryName.substring(binaryName.lastIndexOf('.') + 1);
				packageNode = packageNode.getSubpackage(packageName);
			} else
			{
				compilationUnitName = binaryName;
			}
			return packageNode.getCompilationUnit(compilationUnitName);
		}

		if (LOGGER.isTraceEnabled())
		{
			LOGGER.trace("Loading " + file + " immediately.");
		}

		observedBinaryNames.add(binaryName);

		// Rather than blindly executing tasks, let's proxy out task addition so we can actively execute the ones we
		// want
		final PriorityQueue<BsjCompilerTask> queue = new PriorityQueue<BsjCompilerTask>();
		MetacompilationContext contextProxy = new MetacompilationContextProxy(this)
		{
			@Override
			public void registerTask(BsjCompilerTask task)
			{
				if (task.getPriority().getPriority() >= TaskPriority.EXECUTE.getPriority())
				{
					queue.offer(task);
				} else
				{
					MetacompilationManager.this.registerTask(task);
				}
			}
		};

		AbstractCompilationUnitBuilderTask task;
		if (file.getSimpleName().endsWith(".class"))
		{
			task = new LoadBinaryCompilationUnitTask(file, getCurrentMetaprogram());
		} else
		{
			task = new ParseCompilationUnitTask(file, getCurrentMetaprogram());
		}
		queue.offer(task);

		while (queue.size() > 0)
		{
			if (LOGGER.isTraceEnabled())
			{
				LOGGER.trace("Executing task " + task + " for immediate load of " + file);
			}
			try
			{
				queue.poll().execute(contextProxy);
			} catch (IOException e)
			{
				// TODO: now what?
				throw new IllegalStateException(e);
			}
		}

		String compilationUnitName;
		PackageNode packageNode = rootPackage;
		if (binaryName.indexOf('.') != -1)
		{
			String packageName;
			packageName = binaryName.substring(0, binaryName.lastIndexOf('.'));
			compilationUnitName = binaryName.substring(binaryName.lastIndexOf('.') + 1);
			packageNode = packageNode.getSubpackage(packageName);
		} else
		{
			compilationUnitName = binaryName;
		}
		return packageNode.getCompilationUnit(compilationUnitName);
	}

	/**
	 * Retrieves the profile of the currently running metaprogram.
	 * 
	 * @return The profile of the currently running metaprogram or <code>null</code> if no such metaprogram exists.
	 */
	private MetaprogramProfile<?> getCurrentMetaprogram()
	{
		Integer id = getNodeManager().getCurrentMetaprogramId();
		if (id != null)
		{
			return getDependencyManager().getMetaprogramProfileByID(id);
		} else
		{
			return null;
		}
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
		if (this.getDiagnosticListener().getCount(Kind.ERROR) > 0)
		{
			// TODO: more clever approach: continue executing unrelated tasks until we run out
			// Dump all remaining tasks from the queue
			this.priorityQueue.clear();
		}
	}

	/**
	 * Retrieves the number of errors which have occurred during metacompilation.
	 */
	public int getErrorCount()
	{
		return this.diagnosticListener.getCount(Kind.ERROR);
	}

	public BsjToolkit getToolkit()
	{
		return toolkit;
	}

	public BsjNodeManager getNodeManager()
	{
		return nodeManager;
	}

	public CountingDiagnosticProxyListener<BsjSourceLocation> getDiagnosticListener()
	{
		return diagnosticListener;
	}

	public PackageNode getRootPackage()
	{
		return rootPackage;
	}

	@Override
	public DependencyManager getDependencyManager()
	{
		return this.dependencyManager;
	}

	public List<BsjFileObject> getSerializedFiles()
	{
		return serializedFiles;
	}

	@Override
	public void addSerializedFile(BsjFileObject file)
	{
		this.serializedFiles.add(file);
	}

	@Override
	public boolean addObservedAnchor(MetaprogramAnchorNode<?> anchor)
	{
		if (this.observedAnchors.containsKey(anchor))
			return false;

		this.observedAnchors.put(anchor, null);
		return true;
	}
}