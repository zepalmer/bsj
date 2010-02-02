package edu.jhu.cs.bsj.compiler.impl.tool.compiler;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.exception.BsjCompilerException;
import edu.jhu.cs.bsj.compiler.impl.tool.compiler.task.CheatStubTransitioner;
import edu.jhu.cs.bsj.compiler.impl.tool.compiler.task.CompilationUnitTransitioner;
import edu.jhu.cs.bsj.compiler.impl.tool.compiler.task.ParseCompilationUnitTransitioner;
import edu.jhu.cs.bsj.compiler.impl.tool.compiler.task.SourceSerializationTransitioner;
import edu.jhu.cs.bsj.compiler.impl.tool.filemanager.BsjFileManager;
import edu.jhu.cs.bsj.compiler.impl.tool.filemanager.BsjFileObject;

/**
 * This class represents the data structure which manages compilation units. It tracks the progress which has been made
 * on a given compilation unit and, indirectly, any data specifically associated with it (such as its AST). The manager
 * maintains work in the form of a priority queue and is not finished until all of the work units in the priority queue
 * have been exhausted. Once a compilation unit manager reports that its work is complete, all sources have been
 * meta-compiled; the resulting generated source must still be compiled to finish BSJ compilation.
 * 
 * @author Zachary Palmer
 */
public class CompilationUnitManager
{
	/**
	 * Contains the registry of stateless compilation unit transitioners keyed by the state they transition.
	 */
	private static final Map<CompilationUnitStatus, CompilationUnitTransitioner> transitionerMap;

	static
	{
		Map<CompilationUnitStatus, CompilationUnitTransitioner> map =
			new HashMap<CompilationUnitStatus, CompilationUnitTransitioner>();
		
		map.put(CompilationUnitStatus.JUST_STARTED, new ParseCompilationUnitTransitioner());
		map.put(CompilationUnitStatus.PARSED, new CheatStubTransitioner());
		map.put(CompilationUnitStatus.READY_TO_SERIALIZE, new SourceSerializationTransitioner());
		
		transitionerMap = Collections.unmodifiableMap(map);
	}

	/**
	 * Maps the names of compilation units to their respective trackers. The trackers contain the compilation unit-
	 * specific data and the individual compilation unit statuses.
	 */
	private Map<String, CompilationUnitTracker> trackerMap;
	/**
	 * Represents the work queue. Trackers are enqueued here as long as they are incomplete. Because of trackers'
	 * natural ordering and the fact that this is a priority queue, trackers with more immediate  concerns (such as
	 * parsing) can complete before trackers with later concerns (like source serialization).
	 */
	private PriorityQueue<CompilationUnitTracker> priorityQueue;
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
	 * 
	 * @param factory The node factory to use.
	 * @param fileManager The file management abstraction to use.
	 */
	public CompilationUnitManager(BsjNodeFactory factory, BsjFileManager fileManager)
	{
		this.trackerMap = new HashMap<String, CompilationUnitTracker>();
		this.priorityQueue = new PriorityQueue<CompilationUnitTracker>();
		this.factory = factory;
		this.fileManager = fileManager;
	}

	/**
	 * Adds a tracker to this manager.
	 * 
	 * @param tracker The tracker to add.
	 */
	public void addTracker(CompilationUnitTracker tracker)
	{
		this.priorityQueue.offer(tracker);
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
		this.addTracker(tracker);
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
	 * 
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

		CompilationUnitTracker tracker = this.priorityQueue.poll();
		CompilationUnitTransitioner transitioner = transitionerMap.get(tracker.getStatus());
		transitioner.execute(this, tracker);
		if (tracker.getStatus() != CompilationUnitStatus.COMPLETE)
		{
			this.priorityQueue.offer(tracker);
		}
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