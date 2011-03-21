package edu.jhu.cs.bsj.tests.compiler.tool.compiler.metaannotation;

import org.junit.Test;

import edu.jhu.cs.bsj.tests.compiler.tool.compiler.AbstractBsjCompilerTest;


/**
 * Tests some sources that make use of meta-annotation Operator overload metaprograms.
 * @author Uday Garikipati
 */
public class MetaAnnotationBigIntegerOperatorOverloadingMetaProgramTest  extends AbstractBsjCompilerTest {
	
	@Test
	public void testBasicOperatorOverloading() throws Exception
	{
	    performTest("BigIntegerOperatorOverloading");
	}
	
	@Test
	public void testAckermannFunction() throws Exception
	{
	    performTest("Ackermann");
	}
}
