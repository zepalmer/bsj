package edu.jhu.cs.bsj.tests.compiler.tool.typechecker;

import java.io.File;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.tools.Diagnostic;
import javax.tools.DiagnosticListener;

import junit.framework.Assert;
import edu.jhu.cs.bsj.compiler.BsjServiceRegistry;
import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.node.CompilationUnitNode;
import edu.jhu.cs.bsj.compiler.ast.node.PackageNode;
import edu.jhu.cs.bsj.compiler.impl.diagnostic.RecordingDiagnosticProxyListener;
import edu.jhu.cs.bsj.compiler.impl.utils.StringUtilities;
import edu.jhu.cs.bsj.compiler.tool.BsjToolkit;
import edu.jhu.cs.bsj.compiler.tool.BsjToolkitFactory;
import edu.jhu.cs.bsj.compiler.tool.filemanager.BsjFileManager;
import edu.jhu.cs.bsj.compiler.tool.filemanager.BsjFileObject;
import edu.jhu.cs.bsj.compiler.tool.typechecker.BsjTypechecker;
import edu.jhu.cs.bsj.tests.AbstractTest;

public abstract class AbstractTypecheckerTest extends AbstractTest
{
    private static final File TYPECHECKER_TEST_PATH = new File(EXAMPLES.getPath() + File.separator
            + "typechecker-tests");

    protected PackageNode performTest(String name) throws Exception
    {
        return performTest(name, null);
    }

    /**
     * Performs a test of the BSJ typechecker. This method accepts the name of a typechecker test directory as well as
     * the names of several source files. It parses those files and executes the typechecker on them. This method
     * expects the test to succeed.
     * 
     * @param name The name of the test directory.
     * @param types The fully-qualified names of the types to load. If <code>null</code>, all source files in the test
     *            directory are loaded.
     * @return The root package (for further analysis).
     */
    protected PackageNode performTest(String name, List<String> types) throws Exception
    {
        File testPath = getTestPath(name);
        BsjFileManager fileManager = getFileManager(testPath);
        BsjToolkitFactory toolkitFactory = BsjServiceRegistry.getInstance().newToolkitFactory();
        toolkitFactory.setFileManager(fileManager);
        BsjToolkit toolkit = toolkitFactory.newToolkit();

        List<String> filenames;
        if (types == null)
        {
            filenames = searchForSources(testPath);
        } else
        {
            filenames = new ArrayList<String>();
            for (String type : types)
            {
                filenames.add(type.replaceAll("\\.", "/") + ".bsj");
            }
        }

        RecordingDiagnosticProxyListener<BsjSourceLocation> listener = new RecordingDiagnosticProxyListener<BsjSourceLocation>(
                new DiagnosticListener<BsjSourceLocation>()
                {
                    @Override
                    public void report(Diagnostic<? extends BsjSourceLocation> diagnostic)
                    {
                        System.err.println(diagnostic.getMessage(null));
                    }
                });

        PackageNode root = toolkit.getNodeFactory().makePackageNode(null);
        List<BsjFileObject> files = getFilesFromPaths(fileManager, filenames);
        for (BsjFileObject file : files)
        {
            CharSequence c = file.getCharContent(true);
            CompilationUnitNode compilationUnitNode = toolkit.getParser().parse(
                    StringUtilities.removeSuffix(file.getSimpleName(), '.'), new StringReader(c.toString()), listener);
            PackageNode p = root;
            if (file.inferBinaryName().indexOf('.') != -1)
            {
                String packageName = StringUtilities.removeSuffix(file.inferBinaryName(), '.');
                p = p.getSubpackage(packageName);
            }
            p.addCompilationUnit(compilationUnitNode);
        }
        
        Assert.assertEquals(0, listener.getCount(Diagnostic.Kind.ERROR));

        BsjTypechecker typechecker = toolkit.getTypecheckerFactory().makeTypechecker(root, listener);
        Iterator<CompilationUnitNode> it = root.getCompilationUnitIterator();
        while (it.hasNext())
        {
            typechecker.typecheck(it.next());
        }

        Assert.assertEquals(0, listener.getCount(Diagnostic.Kind.ERROR));
        
        return root;
    }

    /**
     * Obtains the {@link File} representing the directory containing source files for a given test name.
     * 
     * @param testName The name of the test.
     * @return The test's source directory.
     */
    protected File getTestPath(String testName)
    {
        final String testPath = testName.replaceAll("/", File.separator);
        File sourcePath = new File(TYPECHECKER_TEST_PATH.getPath() + File.separator + testPath);
        return sourcePath;
    }

}
