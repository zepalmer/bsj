package edu.jhu.cs.bsj.compiler.impl.tool.compiler.task;

import java.io.IOException;
import java.io.Reader;

import edu.jhu.cs.bsj.compiler.ast.node.CompilationUnitNode;
import edu.jhu.cs.bsj.compiler.ast.node.PackageNode;
import edu.jhu.cs.bsj.compiler.impl.tool.compiler.MetacompilationContext;
import edu.jhu.cs.bsj.compiler.impl.utils.StringUtilities;
import edu.jhu.cs.bsj.compiler.tool.filemanager.BsjFileObject;
import edu.jhu.cs.bsj.compiler.tool.parser.BsjParser;

/**
 * Parses a compilation unit contained in a source file.
 * 
 * @author Zachary Palmer
 */
public class ParseCompilationUnitTask extends AbstractBsjCompilerTask
{
	/** The source file to parse. */
	private BsjFileObject file;

	/**
	 * Creates a task for parsing the specified source file.
	 * 
	 * @param file The source file to parse.
	 */
	public ParseCompilationUnitTask(BsjFileObject file)
	{
		super(TaskPriority.PARSE);
		this.file = file;
	}

	@Override
	public void execute(MetacompilationContext context) throws IOException
	{
		PackageNode rootPackage = context.getRootPackage();

		// Parse the file into a compilation unit
		Reader reader = file.openReader(true); // TODO: parameterize ignoring of encoding errors?
		BsjParser parser = context.getToolkit().getParser();
		String compilationUnitName = StringUtilities.getSuffix(file.inferBinaryName(), '.');
		CompilationUnitNode node = parser.parse(compilationUnitName, reader, context.getDiagnosticListener());

		// Find/create the package we're trying to use
		PackageNode packageNode = rootPackage;
		String compilationUnitBinaryName = this.file.inferBinaryName();
		if (compilationUnitBinaryName.contains("."))
		{
			String packageName = StringUtilities.removeSuffix(compilationUnitBinaryName, '.');
			packageNode = packageNode.getSubpackageByQualifiedName(packageName);
		}

		// Add the compilation unit and enqueue it for name analysis
		packageNode.addCompilationUnitNode(node);
		context.registerTask(new CategorizeNamesTask(node));
	}
}
