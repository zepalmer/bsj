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
import edu.jhu.cs.bsj.compiler.ast.node.NameNode;
import edu.jhu.cs.bsj.compiler.ast.util.BsjTypedNodeNoOpVisitor;
import edu.jhu.cs.bsj.compiler.impl.tool.compiler.names.InitialNameCategorizationVisitor;
import edu.jhu.cs.bsj.compiler.impl.utils.StringUtilities;
import edu.jhu.cs.bsj.compiler.tool.BsjToolkit;
import edu.jhu.cs.bsj.compiler.tool.parser.BsjParser;
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
		findAndTestJavaFiles(EXAMPLES);
	}

	@Override
	protected boolean doFileTest(File file) throws Exception
	{
		BsjToolkit toolkit = getToolkit(null);
		BsjParser parser = toolkit.getParser();
		CompilationUnitNode node = parser.parse(StringUtilities.removeSuffix(file.getName(), '.'),
				new InputStreamReader(new FileInputStream(file)), new DiagnosticListener<JavaFileObject>()
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

		// Perform initial categorization
		InitialNameCategorizationVisitor initialNameCategorizationVisitor = new InitialNameCategorizationVisitor();
		node.receiveTyped(initialNameCategorizationVisitor);
		// Confirm that every name got a category
		node.receiveTyped(new BsjTypedNodeNoOpVisitor()
		{
			@Override
			public void visitNameNodeStart(NameNode node)
			{
				if (node.getCategory() == null)
				{
					throw new IllegalStateException("Did not assign a category to name" + node.toString() + " at "
							+ node.getStartLocation());
				}
			}
		});

		// TODO: ****** Can we actually do this unit test?
		// The problem is that much of the following categorization depends on a compilation environment to function
		// correctly. Our best bet seems to run compilation while trapping the output of log4j and then have the
		// unit test make assertions about the log4j output.

		// Identify packages and types
		// PackageOrTypeNameCategorizationVisitor packageOrTypeNameCategorizationVisitor = new
		// PackageOrTypeNameCategorizationVisitor(null);
		// node.receiveTyped(packageOrTypeNameCategorizationVisitor);
		// TODO: confirm that there are no PackageOrTypeNames left

		// Disambiguate
		// AmbiguousNameCategorizationVisitor ambiguousNameCategorizationVisitor = new
		// AmbiguousNameCategorizationVisitor();
		// node.receiveTyped(ambiguousNameCategorizationVisitor);
		// TODO: confirm that either the visit failed to completely disambiguate or that no names are ambiguous

		// TODO: rest of categorization

		return true;
	}
}
