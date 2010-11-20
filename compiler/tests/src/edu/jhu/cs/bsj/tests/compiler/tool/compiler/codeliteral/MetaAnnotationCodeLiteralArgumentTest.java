package edu.jhu.cs.bsj.tests.compiler.tool.compiler.codeliteral;

import java.io.File;

import org.junit.Test;

import edu.jhu.cs.bsj.tests.compiler.tool.compiler.AbstractBsjCompilerTest;

public class MetaAnnotationCodeLiteralArgumentTest extends AbstractBsjCompilerTest
{
    @Test
    public void testMetaAnnotationCodeLiteralArguments() throws Exception
    {
        performTest(new File(SPECIFIC_SOURCE_DIR.getPath() + File.separator + "codeliterals" + File.separator
                + "metaannotationArguments"), "MetaAnnotationCodeLiteralArgumentsClass");
    }
}
