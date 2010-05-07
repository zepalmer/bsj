package edu.jhu.cs.bsj.compiler.impl.tool.compiler.task;

import java.io.IOException;

import edu.jhu.cs.bsj.compiler.ast.node.CompilationUnitNode;
import edu.jhu.cs.bsj.compiler.ast.node.PackageNode;
import edu.jhu.cs.bsj.compiler.impl.tool.compiler.MetacompilationContext;
import edu.jhu.cs.bsj.compiler.impl.utils.StringUtilities;
import edu.jhu.cs.bsj.compiler.tool.filemanager.BsjFileObject;

/**
 * An abstract superclass for compilation tasks which extract compilation units from a file.
 * 
 * @author Zachary Palmer
 */
public abstract class AbstractCompilationUnitBuilderTask extends AbstractBsjCompilerTask
{
	/** The source file to parse. */
	private BsjFileObject file;
	/** The injection profile of this file. */
	private InjectionInfo info;

	public AbstractCompilationUnitBuilderTask(TaskPriority priority, BsjFileObject file, InjectionInfo info)
	{
		super(priority);
		this.file = file;
		this.info = info; 
	}

	@Override
	public void execute(MetacompilationContext context) throws IOException
	{
		PackageNode rootPackage = context.getRootPackage();
		
		// Suspend policy management and conflict detection for a moment to allow the compilation unit to be created
		// This might be necessary if we are within the scope of a metaprogram (such as with a call to PackageNode.load)
		context.getNodeManager().pushPermissionPolicyManager(null);
		context.getNodeManager().pushCurrentMetaprogramId(null);
		
		// Parse the file into a compilation unit
		CompilationUnitNode node = createCompilationUnit(context, this.file);
		
		// Find/create the package we're trying to use
		PackageNode packageNode = rootPackage;
		String compilationUnitBinaryName = this.file.inferBinaryName();
		if (compilationUnitBinaryName.contains("."))
		{
			String packageName = StringUtilities.removeSuffix(compilationUnitBinaryName, '.');
			packageNode = packageNode.getSubpackageByQualifiedName(packageName);
		}

		// Add the compilation unit
		packageNode.addCompilationUnit(node);

		// Reinstate policy management and conflict detection
		context.getNodeManager().popPermissionPolicyManager();
		context.getNodeManager().popCurrentMetaprogramId();

		// Enqueue the compilation unit for name categorization
		context.registerTask(new CategorizeNamesTask(node, this.info));
	}

	protected abstract CompilationUnitNode createCompilationUnit(MetacompilationContext context, BsjFileObject file)
			throws IOException;
}