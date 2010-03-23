package edu.jhu.cs.bsj.compiler.impl.tool.compiler.task;

import java.io.IOException;
import java.io.Reader;

import edu.jhu.cs.bsj.compiler.ast.node.CompilationUnitNode;
import edu.jhu.cs.bsj.compiler.impl.tool.compiler.MetacompilationContext;
import edu.jhu.cs.bsj.compiler.impl.utils.StringUtilities;
import edu.jhu.cs.bsj.compiler.tool.filemanager.BsjFileObject;
import edu.jhu.cs.bsj.compiler.tool.parser.BsjParser;

/**
 * Parses a compilation unit contained in a source file.
 * 
 * @author Zachary Palmer
 */
public class ParseCompilationUnitTask extends AbstractCompilationUnitBuilderTask
{
	/**
	 * Creates a task for parsing the specified source file.
	 * 
	 * @param file The source file to parse.
	 */
	public ParseCompilationUnitTask(BsjFileObject file)
	{
		super(TaskPriority.PARSE, file);
	}

	@Override
	protected CompilationUnitNode createCompilationUnit(MetacompilationContext context, BsjFileObject file)
			throws IOException
	{
		Reader reader = file.openReader(true); // TODO: parameterize ignoring of encoding errors?
		BsjParser parser = context.getToolkit().getParser();
		String compilationUnitName = StringUtilities.getSuffix(file.inferBinaryName(), '.');
		return parser.parse(compilationUnitName, reader, context.getDiagnosticListener());
	}
}
