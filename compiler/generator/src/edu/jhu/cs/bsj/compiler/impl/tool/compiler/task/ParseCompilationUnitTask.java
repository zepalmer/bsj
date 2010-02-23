package edu.jhu.cs.bsj.compiler.impl.tool.compiler.task;

import java.io.IOException;
import java.io.Reader;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.node.CompilationUnitNode;
import edu.jhu.cs.bsj.compiler.ast.node.PackageNode;
import edu.jhu.cs.bsj.compiler.impl.tool.compiler.MetacompilationContext;
import edu.jhu.cs.bsj.compiler.impl.tool.filemanager.BsjFileObject;
import edu.jhu.cs.bsj.compiler.impl.utils.StringUtilities;
import edu.jhu.cs.bsj.compiler.tool.parser.BsjParserImpl;

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
		BsjNodeFactory factory = context.getFactory();
		PackageNode rootPackage = context.getRootPackage();

		// Parse the file into a compilation unit
		Reader reader = file.openReader(true); // TODO: parameterize ignoring of encoding errors?
		// TODO: get a standard BsjParser once that interface exists
		BsjParserImpl parser = new BsjParserImpl(context.getFactory());
		String compilationUnitName = StringUtilities.getSuffix(file.inferBinaryName(), '.');
		CompilationUnitNode node = parser.parse(compilationUnitName, reader, context.getDiagnosticListener());

		// Find/create the package we're trying to use
		String packageName = StringUtilities.removeSuffix(this.file.inferBinaryName(), '.');
		PackageNode packageNode = rootPackage;
		for (String componentName : packageName.split("\\."))
		{
			if (packageNode.getSubpackage(componentName) == null)
			{
				packageNode.addPackageNode(factory.makePackageNode(factory.makeIdentifierNode(componentName)));
			}
			packageNode = packageNode.getSubpackage(componentName);
		}

		// Add the compilation unit and enqueue it for extraction
		packageNode.addCompilationUnitNode(node);
		context.registerTask(new ExtractMetaprogramsTask(node));
	}
}
