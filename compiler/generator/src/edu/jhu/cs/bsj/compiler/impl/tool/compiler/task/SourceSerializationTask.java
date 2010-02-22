package edu.jhu.cs.bsj.compiler.impl.tool.compiler.task;

import java.io.IOException;

import javax.tools.JavaFileObject.Kind;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceSerializer;
import edu.jhu.cs.bsj.compiler.ast.node.CompilationUnitNode;
import edu.jhu.cs.bsj.compiler.ast.node.PackageNode;
import edu.jhu.cs.bsj.compiler.impl.tool.compiler.MetacompilationManager;
import edu.jhu.cs.bsj.compiler.impl.tool.filemanager.BsjCompilerLocation;
import edu.jhu.cs.bsj.compiler.impl.tool.filemanager.BsjFileObject;
import edu.jhu.cs.bsj.compiler.impl.tool.serializer.BsjSourceSerializerImpl;

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
	public void execute(MetacompilationManager manager) throws IOException
	{
		// TODO: don't try to serialize code for read-only compilation units
		// TODO: is there a better way to fetch a source serializer? SPI? Toolkit?
		BsjSourceSerializer serializer = new BsjSourceSerializerImpl();
		String source = serializer.executeCompilationUnitNode(compilationUnitNode, null);
		
		String className;
		if (compilationUnitNode.getParent() instanceof PackageNode)
		{
			className = ((PackageNode)compilationUnitNode.getParent()).getFullyQualifiedName();
			if (className == null)
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
		
		BsjFileObject bsjFileObject = manager.getFileManager().getJavaFileForOutput(
				BsjCompilerLocation.GENERATED_SOURCE_PATH, compilationUnitNode.getName(), Kind.SOURCE, null);
		bsjFileObject.setCharContent(source);
		
		if (LOGGER.isTraceEnabled())
		{
			LOGGER.trace("Serializing " + className + " as follows: \n" + source);
		}
	}

}
