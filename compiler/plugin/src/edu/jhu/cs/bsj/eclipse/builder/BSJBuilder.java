package edu.jhu.cs.bsj.eclipse.builder;

import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.tools.Diagnostic;
import javax.tools.DiagnosticListener;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;

import edu.jhu.cs.bsj.compiler.BsjServiceRegistry;
import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.diagnostic.compiler.MetaprogramDetectedErrorDiagnostic;
import edu.jhu.cs.bsj.compiler.impl.diagnostic.RecordingDiagnosticProxyListener;
import edu.jhu.cs.bsj.compiler.tool.BsjCompiler;
import edu.jhu.cs.bsj.compiler.tool.BsjToolkit;
import edu.jhu.cs.bsj.compiler.tool.BsjToolkitFactory;
import edu.jhu.cs.bsj.compiler.tool.filemanager.BsjFileManager;
import edu.jhu.cs.bsj.compiler.tool.filemanager.BsjFileObject;

/**
 * Builds a bsj project
 */
public class BSJBuilder extends IncrementalProjectBuilder {
	
	public static final String BUILDER_ID = "edu.jhu.cs.bsj.eclipse.builder";
	
	public BSJBuilder() {
	}
	
	@Override
	protected IProject[] build(int kind, @SuppressWarnings("rawtypes") Map args, IProgressMonitor monitor) 
	throws CoreException {
		switch(kind) {
			case FULL_BUILD:
				fullBuild(monitor); break;
			case INCREMENTAL_BUILD:
				incrementalBuild(monitor); break;
			case CLEAN_BUILD:
				cleanBuild(monitor); break;
			default:
				autoBuild(monitor);
		}
		return null;
	}
	
	protected void fullBuild(final IProgressMonitor monitor) 
	throws CoreException {
		BSJBuilderConfig bconfig = new BSJBuilderConfig(getProject());
		IFolder srcFolder = getProject().getFolder(bconfig.getSourcePathStr());
		BsjFileManager fmanager;
		try {
			fmanager = bconfig.getFileManager();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		BSJSourceFileVisitor visitor = new BSJSourceFileVisitor(srcFolder, fmanager);
		srcFolder.accept(visitor);
		List<BsjFileObject> files = visitor.getSourceFiles();
		try {
			compile(fmanager, files);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	protected void incrementalBuild(final IProgressMonitor monitor) 
	throws CoreException {
		//TODO get incremental build to work
		fullBuild(monitor);
	}
	
	protected void cleanBuild(final IProgressMonitor monitor) 
	throws CoreException {
		//TODO get clean build to work
	}
	
	protected void autoBuild(final IProgressMonitor monitor) 
	throws CoreException {
		incrementalBuild(monitor);
	}
	
	/**
	 * Compiles the given files managed by the file manager
	 */
	protected List<Diagnostic<? extends BsjSourceLocation>> compile(
			BsjFileManager fileManager, List<BsjFileObject> files) throws Exception {
		
		BsjToolkitFactory toolkitFactory = BsjServiceRegistry.newToolkitFactory();
		toolkitFactory.setFileManager(fileManager);
		BsjToolkit toolkit = toolkitFactory.newToolkit();

		BsjCompiler compiler = toolkit.getCompiler();
		RecordingDiagnosticProxyListener<BsjSourceLocation> diagnosticListener = new RecordingDiagnosticProxyListener<BsjSourceLocation>(
				new DiagnosticListener<BsjSourceLocation>() {
					@Override
					public void report(Diagnostic<? extends BsjSourceLocation> diagnostic) {
						System.err.println(diagnostic.getMessage(null));
						if (diagnostic instanceof MetaprogramDetectedErrorDiagnostic<?>) {
							MetaprogramDetectedErrorDiagnostic<?> d = (MetaprogramDetectedErrorDiagnostic<?>) diagnostic;
							System.err.println("Exception is: ");
							d.getException().printStackTrace();
						}
					}
				});
		Random random;
		if (System.getProperty("bsj.tests.seed") == null) {
			random = null;
		} else {
			random = new Random(Integer.parseInt(System
					.getProperty("bsj.tests.seed")));
		}
		compiler.compile(files, diagnosticListener, random);

		return diagnosticListener.getDiagnostics();
	}
}
