package edu.jhu.cs.bsj.compiler.impl.tool.compiler.task;

import java.io.IOException;

import edu.jhu.cs.bsj.compiler.ast.node.CompilationUnitNode;
import edu.jhu.cs.bsj.compiler.impl.tool.classpath.bcel.BsjBinaryNodeLoader;
import edu.jhu.cs.bsj.compiler.impl.tool.compiler.MetacompilationContext;
import edu.jhu.cs.bsj.compiler.tool.filemanager.BsjFileObject;

public class LoadBinaryCompilationUnitTask extends AbstractCompilationUnitBuilderTask
{
	/**
	 * Creates a task for parsing the specified source file.
	 * 
	 * @param file The source file to parse.
	 */
	public LoadBinaryCompilationUnitTask(BsjFileObject file)
	{
		super(TaskPriority.LOAD_BINARY, file);
	}

	@Override
	protected CompilationUnitNode createCompilationUnit(MetacompilationContext context, BsjFileObject file)
			throws IOException
	{
		BsjBinaryNodeLoader loader = new BsjBinaryNodeLoader(context.getToolkit().getNodeFactory());
		CompilationUnitNode node = loader.loadNodesFromBinary(file);
		
		return node;
	}
}
