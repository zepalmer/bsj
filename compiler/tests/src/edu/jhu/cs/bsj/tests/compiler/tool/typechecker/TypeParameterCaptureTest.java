package edu.jhu.cs.bsj.tests.compiler.tool.typechecker;

import java.io.File;
import java.io.StringReader;

import javax.tools.Diagnostic;
import javax.tools.DiagnosticListener;

import org.junit.Test;

import edu.jhu.cs.bsj.compiler.BsjServiceRegistry;
import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.node.CompilationUnitNode;
import edu.jhu.cs.bsj.compiler.ast.node.PackageNode;
import edu.jhu.cs.bsj.compiler.impl.diagnostic.RecordingDiagnosticProxyListener;
import edu.jhu.cs.bsj.compiler.tool.BsjToolkit;
import edu.jhu.cs.bsj.compiler.tool.BsjToolkitFactory;
import edu.jhu.cs.bsj.compiler.tool.filemanager.BsjCompilerLocation;
import edu.jhu.cs.bsj.compiler.tool.filemanager.BsjFileManager;
import edu.jhu.cs.bsj.compiler.tool.filemanager.BsjFileObject;
import edu.jhu.cs.bsj.compiler.tool.typechecker.BsjTypechecker;
import edu.jhu.cs.bsj.compiler.tool.typechecker.TypecheckerResult;
import edu.jhu.cs.bsj.tests.AbstractTest;

public class TypeParameterCaptureTest extends AbstractTest
{
    @Test
    public void testCaptureTypechecking() throws Exception
    {
        BsjFileManager fileManager = getFileManager(new File(SPECIFIC_SOURCE_DIR.getPath() + File.separator
                + "typechecking" + File.separator + "capture"));
        BsjToolkitFactory toolkitFactory = BsjServiceRegistry.newToolkitFactory();
        toolkitFactory.setFileManager(fileManager);
        BsjToolkit toolkit = toolkitFactory.newToolkit();
        
        BsjFileObject file = fileManager.getFileForInput(BsjCompilerLocation.SOURCE_PATH, "", "Capture.bsj");
        CharSequence c = file.getCharContent(true);
        RecordingDiagnosticProxyListener<BsjSourceLocation> listener = new RecordingDiagnosticProxyListener<BsjSourceLocation>(
                new DiagnosticListener<BsjSourceLocation>()
                {
                    @Override
                    public void report(Diagnostic<? extends BsjSourceLocation> diagnostic)
                    {
                        System.err.println(diagnostic.getMessage(null));
                    }
                });
        CompilationUnitNode compilationUnitNode = toolkit.getParser().parse("Capture", new StringReader(c.toString()), listener);
        PackageNode root = toolkit.getNodeFactory().makePackageNode(null);
        root.addCompilationUnit(compilationUnitNode);
        
        BsjTypechecker typechecker = toolkit.getTypecheckerFactory().makeTypechecker(root, listener);
        typechecker.typecheck(compilationUnitNode);
    }

}
