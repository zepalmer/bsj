package edu.jhu.cs.bsj.compiler.impl.tool.compiler.task;

import java.io.IOException;

import javax.tools.JavaFileObject.Kind;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceSerializer;
import edu.jhu.cs.bsj.compiler.exception.BsjCompilerException;
import edu.jhu.cs.bsj.compiler.impl.tool.compiler.MetacompilationManager;
import edu.jhu.cs.bsj.compiler.impl.tool.compiler.CompilationUnitStatus;
import edu.jhu.cs.bsj.compiler.impl.tool.compiler.CompilationUnitTracker;
import edu.jhu.cs.bsj.compiler.impl.tool.filemanager.BsjCompilerLocation;
import edu.jhu.cs.bsj.compiler.impl.tool.filemanager.BsjFileObject;
import edu.jhu.cs.bsj.compiler.impl.tool.serializer.BsjSourceSerializerImpl;

/**
 * The final step of BSJ meta-compilation. This task generates source code from the tracker's AST and stores it in the
 * BSJ generated source directory.
 * 
 * @author Zachary Palmer
 * 
 */
public class SourceSerializationTransitioner extends AbstractCompilationUnitTransitioner implements CompilationUnitTransitioner
{
	@Override
	public void execute(MetacompilationManager manager, CompilationUnitTracker tracker) throws IOException, BsjCompilerException
	{
		// TODO: is there a better way to fetch a source serializer? SPI? Toolkit?
		BsjSourceSerializer serializer = new BsjSourceSerializerImpl();
		String source = serializer.executeCompilationUnitNode(tracker.getAst(), null);
		BsjFileObject bsjFileObject = manager.getFileManager().getJavaFileForOutput(
				BsjCompilerLocation.GENERATED_SOURCE_PATH, tracker.getName(), Kind.SOURCE, null);
		bsjFileObject.setCharContent(source);
		
		tracker.setStatus(CompilationUnitStatus.COMPLETE);
	}

}
