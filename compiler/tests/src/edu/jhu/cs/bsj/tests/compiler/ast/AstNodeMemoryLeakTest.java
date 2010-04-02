package edu.jhu.cs.bsj.tests.compiler.ast;

import org.junit.Assume;
import org.junit.Test;

import edu.jhu.cs.bsj.compiler.BsjServiceRegistry;
import edu.jhu.cs.bsj.compiler.ast.BinaryOperator;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.tests.AbstractTest;

public class AstNodeMemoryLeakTest extends AbstractTest
{
	@Test
	public void leakTest()
	{
		Assume.assumeTrue(Boolean.getBoolean("bsj.tests.run.slow"));
		BsjNodeFactory factory = BsjServiceRegistry.newToolkitFactory().newToolkit().getNodeFactory();

		long memory = Runtime.getRuntime().maxMemory();

		// If we create a node for every seven bytes of memory, we're guaranteed to force a GC (since the UID alone
		// requires eight)
		long max = memory / 21;
		for (long i = 0; i < max; i++)
		{
			factory.makeBinaryExpressionNode(factory.makeLongLiteralNode(i), factory.makeLongLiteralNode(i,
					new BsjSourceLocation("<unknown>", 1, 1), new BsjSourceLocation("<unknown>", 1, 1)),
					BinaryOperator.PLUS);
			if (i % 10000 == 9999 && LOGGER.isTraceEnabled())
			{
				LOGGER.trace((i+1) + "/" + max + " iterations completed.");
			}
		}
	}
}
