package edu.jhu.cs.bsj.tests.compiler.tool.compiler;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import javax.tools.Diagnostic;
import javax.tools.DiagnosticListener;
import javax.tools.JavaFileObject;

import org.junit.Assert;
import org.junit.Test;

import edu.jhu.cs.bsj.compiler.ast.node.CompilationUnitNode;
import edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeFactoryImpl;
import edu.jhu.cs.bsj.compiler.impl.tool.compiler.NameCategorizationVisitor;
import edu.jhu.cs.bsj.compiler.tool.parser.BsjParserImpl;
import edu.jhu.cs.bsj.tests.AbstractPerFileTest;

/**
 * Performs a test of the example files by parsing them and attempting to categorize their names.
 * 
 * @author Zachary Palmer
 */
public class NameCategorizationTest extends AbstractPerFileTest
{
	@Test
	public void testNameCategorization()
	{
		log4jConfigure("trace", "edu.jhu.cs.bsj.compiler.impl.tool.filemanager/debug",
				"edu.jhu.cs.bsj.compiler.tool.parser.antlr/debug");
		findAndTestJavaFiles(EXAMPLES);
	}

	@Override
	protected boolean doFileTest(File file) throws Exception
	{
		// TODO: get from SPI
		BsjParserImpl parser = new BsjParserImpl(new BsjNodeFactoryImpl());
		CompilationUnitNode node = parser.parse(new InputStreamReader(new FileInputStream(file)),
				new DiagnosticListener<JavaFileObject>()
				{
					@Override
					public void report(Diagnostic<? extends JavaFileObject> diagnostic)
					{
						switch (diagnostic.getKind())
						{
							case NOTE:
							case OTHER:
								System.out.println(diagnostic.getMessage(null));
								break;
							default:
								System.err.println(diagnostic.getMessage(null));
								Assert.fail();
								break;
						}
					}
				});

		NameCategorizationVisitor visitor = new NameCategorizationVisitor();
		node.receiveTyped(visitor);

		return true;
	}
}
