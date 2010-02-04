package edu.jhu.cs.bsj.compiler.impl.tool.compiler;

import java.util.concurrent.atomic.AtomicInteger;

import edu.jhu.cs.bsj.compiler.ast.node.CompilationUnitNode;
import edu.jhu.cs.bsj.compiler.impl.tool.filemanager.BsjFileObject;

/**
 * This class tracks the compilation progress of a single compilation unit.
 * @author Zachary Palmer
 */
public class CompilationUnitTracker
{
	/** The next UID to assign to a tracker. */
	private static final AtomicInteger nextUID = new AtomicInteger(0);
	
	/**
	 * The UID for this tracker.
	 */
	private int uid = nextUID.getAndIncrement();
	
	/**
	 * The current status for this compilation unit.
	 */
	private CompilationUnitStatus status;
	
	/**
	 * The name of this compilation unit.
	 */
	private String name;
	
	/**
	 * The file which represents this compilation unit on the storage system.
	 */
	private BsjFileObject file;
	
	/**
	 * The AST for this compilation unit.
	 */
	private CompilationUnitNode ast;
	
	/**
	 * The number of outstanding metaprograms associated with this tracker.
	 */
	private int metaprogramsOutstanding;
	
	/**
	 * Creates a new compilation unit tracker in the {@link CompilationUnitStatus#JUST_STARTED} state.
	 * @param file The file containing the compilation unit to build.
	 */
	public CompilationUnitTracker(BsjFileObject file)
	{
		super();
		this.file = file;
		this.name = this.file.inferBinaryName();
		this.status = CompilationUnitStatus.JUST_STARTED;
		this.ast = null;
		this.metaprogramsOutstanding = 0;
	}

	public CompilationUnitStatus getStatus()
	{
		return status;
	}

	public void setStatus(CompilationUnitStatus status)
	{
		this.status = status;
	}

	public String getName()
	{
		return name;
	}
	
	public BsjFileObject getFile()
	{
		return file;
	}

	public int getUid()
	{
		return uid;
	}

	public CompilationUnitNode getAst()
	{
		return ast;
	}

	public void setAst(CompilationUnitNode ast)
	{
		this.ast = ast;
	}

	public int getMetaprogramsOutstanding()
	{
		return metaprogramsOutstanding;
	}

	public void setMetaprogramsOutstanding(int metaprogramsOutstanding)
	{
		this.metaprogramsOutstanding = metaprogramsOutstanding;
	}
}