package edu.jhu.cs.bsj.eclipse.builder;

import java.io.File;
import java.util.List;
import java.util.Map;

import javax.tools.DiagnosticListener;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;

import edu.jhu.cs.bsj.compiler.BsjServiceRegistry;
import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
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
		System.out.println("A build of type "+kind+" is initiated.");
		
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
		// TODO: part incremental builder
		fullBuild(monitor);
	}
	
	protected void cleanBuild(final IProgressMonitor monitor) 
	throws CoreException {
		fullBuild(monitor);
	}
	
	protected void autoBuild(final IProgressMonitor monitor) 
	throws CoreException {
		incrementalBuild(monitor);
	}
	
	/**
	 * Compiles the given files managed by the file manager
	 */
	protected void compile(BsjFileManager fileManager, List<BsjFileObject> files) 
	throws Exception {	
		try {
		BsjToolkitFactory toolkitFactory = BsjServiceRegistry.newToolkitFactory();
		toolkitFactory.setFileManager(fileManager);
		BsjToolkit toolkit = toolkitFactory.newToolkit();

		BsjCompiler compiler = toolkit.getCompiler();
		DiagnosticListener<BsjSourceLocation> diagnosticListener = null;
		
		compiler.compile(files, diagnosticListener);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	protected void clean(final IProgressMonitor monitor) 
	throws CoreException {
		System.out.println("A clean is initiated.");
		
		BSJBuilderConfig bconfig = new BSJBuilderConfig(getProject());
		String projectPath = getProject().getLocation().toFile().getPath();
		
		// NOTE using eclipse workspace to delete generated files doesn't work
		
		// delete generated java sources
		File genSrcPath = new File(projectPath + File.separator + bconfig.getGenSourcePathStr());
		if(genSrcPath.exists()) {
			for(File child : genSrcPath.listFiles())
				deleteFile(child);
		}
		
		// delete generated bsj classes
		File classOutPath = new File(projectPath + File.separator + bconfig.getClassOutputPathSrc());
		if(classOutPath.exists()) {
			for(File child : classOutPath.listFiles())
				deleteFile(child);
		}
	}
	
	private void deleteFile(File file) {
		if(file.isDirectory())
			for(File child : file.listFiles())
				deleteFile(child);
		file.delete();
	}
}
