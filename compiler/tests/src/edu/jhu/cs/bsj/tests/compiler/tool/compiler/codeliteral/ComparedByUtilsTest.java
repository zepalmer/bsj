package edu.jhu.cs.bsj.tests.compiler.tool.compiler.codeliteral;

import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.tools.Diagnostic;
import javax.tools.Diagnostic.Kind;

import org.junit.Test;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.diagnostic.compiler.MetaprogramExceptionDiagnostic;
import edu.jhu.cs.bsj.compiler.impl.tool.filemanager.InMemoryLocationManager;
import edu.jhu.cs.bsj.compiler.tool.filemanager.BsjCompilerLocation;
import edu.jhu.cs.bsj.compiler.tool.filemanager.BsjFileManager;
import edu.jhu.cs.bsj.tests.compiler.tool.compiler.AbstractBsjCompilerTest;

public class ComparedByUtilsTest extends AbstractBsjCompilerTest
{
    private static final File HIGHER_STAGE_DIR = new File(SPECIFIC_SOURCE_DIR.getPath() + File.separator
            + "codeliterals" + File.separator + "comparedByUtils-1");
    private static final File LOWER_STAGE_DIR = new File(SPECIFIC_SOURCE_DIR.getPath() + File.separator
            + "codeliterals" + File.separator + "comparedByUtils-2");

    @Test
    public void comparedByUtilsTest() throws Exception
    {
        performTest(HIGHER_STAGE_DIR, "foo/ComparedByUtils");
    }

    @Test
    public void useComparedByUtilsTest() throws Exception
    {
        // Compile the utils
        BsjFileManager bfm = getFileManager(HIGHER_STAGE_DIR,
                Collections.singletonMap(BsjCompilerLocation.CLASS_OUTPUT, new InMemoryLocationManager(null)), true);
        List<Diagnostic<? extends BsjSourceLocation>> diagnostics = performTest(bfm,
                Arrays.asList("foo/ComparedByUtils"));
        expectNoErrors(diagnostics);

        // Now compile the Person class using the utils
        bfm = getFileManager(
                LOWER_STAGE_DIR,
                Collections.singletonMap(BsjCompilerLocation.METAPROGRAM_CLASSPATH,
                        bfm.getLocationManager(BsjCompilerLocation.CLASS_OUTPUT)), false);
        diagnostics = performTest(bfm, Arrays.asList("Person"));
        expectNoErrors(diagnostics);

        // Ensure that the Person class compiled
        bfm.getClassLoader(BsjCompilerLocation.CLASS_OUTPUT).loadClass("Person");
    }

    protected void expectNoErrors(List<Diagnostic<? extends BsjSourceLocation>> diagnostics)
    {
        for (Diagnostic<? extends BsjSourceLocation> diagnostic : diagnostics)
        {
            if (diagnostic.getKind() == Kind.ERROR)
            {
                Throwable cause = (diagnostic instanceof MetaprogramExceptionDiagnostic) ? ((MetaprogramExceptionDiagnostic) diagnostic).getException()
                        : null;
                throw new IllegalStateException("Error during compilation: " + diagnostic.getMessage(null), cause);
            }
        }
    }
}
