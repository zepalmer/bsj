package edu.jhu.cs.bsj.compiler.impl.tool.compiler.task;

import java.io.IOException;
import java.io.Reader;

import edu.jhu.cs.bsj.compiler.ast.node.CompilationUnitNode;
import edu.jhu.cs.bsj.compiler.exception.BsjCompilerException;
import edu.jhu.cs.bsj.compiler.impl.tool.compiler.CompilationUnitManager;
import edu.jhu.cs.bsj.compiler.impl.tool.compiler.CompilationUnitStatus;
import edu.jhu.cs.bsj.compiler.impl.tool.compiler.CompilationUnitTracker;
import edu.jhu.cs.bsj.compiler.tool.parser.BsjParserImpl;

/**
 * Parses the compilation unit associated with the base tracker.
 * @author Zachary Palmer
 */
public class ParseCompilationUnitTransitioner extends AbstractCompilationUnitTransitioner
{
	@Override
	public void execute(CompilationUnitManager manager, CompilationUnitTracker tracker) throws IOException, BsjCompilerException
	{
		Reader reader = tracker.getFile().openReader(true); // TODO: parameterize ignoring of encoding errors?
		// TODO: get a standard BsjParser once that interface exists
		BsjParserImpl parser = new BsjParserImpl(manager.getFactory());
		CompilationUnitNode node = parser.parse(reader);
		
		tracker.setAst(node);
		tracker.setStatus(CompilationUnitStatus.PARSED);
	}
}
