package edu.jhu.cs.bsj.compiler.impl.tool.compiler.task;

import java.io.IOException;

import javax.tools.JavaFileObject.Kind;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceSerializer;
import edu.jhu.cs.bsj.compiler.ast.node.CompilationUnitNode;
import edu.jhu.cs.bsj.compiler.ast.node.PackageNode;
import edu.jhu.cs.bsj.compiler.impl.tool.compiler.MetacompilationContext;
import edu.jhu.cs.bsj.compiler.tool.filemanager.BsjCompilerLocation;
import edu.jhu.cs.bsj.compiler.tool.filemanager.BsjFileObject;

/**
 * The final step of BSJ meta-compilation. This task generates source code from the package hierarchy.
 * 
 * @author Zachary Palmer
 * 
 */
public class SourceSerializationTask extends AbstractBsjCompilerTask
{
	/** The compilation unit to serialize. */
	private CompilationUnitNode compilationUnitNode;

	public SourceSerializationTask(CompilationUnitNode compilationUnitNode)
	{
		super(TaskPriority.SERIALIZE);
		this.compilationUnitNode = compilationUnitNode;
	}

	@Override
	public void execute(MetacompilationContext context) throws IOException
	{
		// don't try to serialize code for read-only compilation units
		if (this.compilationUnitNode.isBinary())
		{
			return;
		}

		BsjSourceSerializer serializer = context.getToolkit().getSerializer();
		String source = serializer.executeCompilationUnitNode(compilationUnitNode, null);

		String className;
		if (compilationUnitNode.getParent() instanceof PackageNode)
		{
			className = ((PackageNode) compilationUnitNode.getParent()).getFullyQualifiedName();
			if (className == null || className.length() == 0)
			{
				className = compilationUnitNode.getName();
			} else
			{
				className += "." + compilationUnitNode.getName();
			}
		} else
		{
			className = compilationUnitNode.getName();
		}

		BsjFileObject bsjFileObject = context.getToolkit().getFileManager().getJavaFileForOutput(
				BsjCompilerLocation.GENERATED_SOURCE_PATH, className, Kind.SOURCE, null);
		bsjFileObject.setCharContent(source);
		context.addSerializedFile(bsjFileObject);

		if (LOGGER.isTraceEnabled())
		{
			LOGGER.trace("Serializing " + className + " as follows: \n" + source);
		}

	}

}
