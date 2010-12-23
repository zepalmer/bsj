package edu.jhu.cs.bsj.eclipse.builder;

import java.io.File;
import java.util.List;
import java.util.Map;

import javax.tools.DiagnosticListener;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
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
import edu.jhu.cs.bsj.eclipse.util.ResourceUtilities;

/**
 * Builds a bsj project
 */
public class BSJBuilder extends IncrementalProjectBuilder {
	
	public static final String BUILDER_ID = "edu.jhu.cs.bsj.eclipse.builder";
	
	@Override
	protected IProject[] build(int kind, @SuppressWarnings("rawtypes") Map args, IProgressMonitor monitor) 
	throws CoreException {
		BSJBuilderConfig bsjConfig = new BSJBuilderConfig(getProject());
		switch(kind) {
			case FULL_BUILD:
				fullBuild(bsjConfig, monitor); break;
			case INCREMENTAL_BUILD:
				incrementalBuild(bsjConfig, monitor); break;
			case CLEAN_BUILD:
				cleanBuild(bsjConfig, monitor); break;
			default:
				autoBuild(bsjConfig, monitor);
		}
		return null;
	}
	
	protected void fullBuild(BSJBuilderConfig bsjConfig, IProgressMonitor monitor) 
	throws CoreException {
		IFolder srcFolder = getProject().getFolder(bsjConfig.getSourcePathStr());
		BsjFileManager fmanager = bsjConfig.getFileManager();
		BSJSourceFileVisitor visitor = new BSJSourceFileVisitor(srcFolder, fmanager);
		srcFolder.accept(visitor);
		List<BsjFileObject> files = visitor.getSourceFiles();
		try {
			clean(bsjConfig, monitor);
			compile(files, bsjConfig, monitor);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	protected void incrementalBuild(BSJBuilderConfig bsjConfig, IProgressMonitor monitor) 
	throws CoreException {
		// TODO: part incremental builder
		fullBuild(bsjConfig, monitor);
	}
	
	protected void cleanBuild(BSJBuilderConfig bsjConfig, IProgressMonitor monitor) 
	throws CoreException {
		fullBuild(bsjConfig, monitor);
	}
	
	protected void autoBuild(BSJBuilderConfig bsjConfig, IProgressMonitor monitor) 
	throws CoreException {
		fullBuild(bsjConfig, monitor);
	}
	
	/**
	 * Compiles the given files managed by the file manager
	 */
	protected void compile(List<BsjFileObject> files, BSJBuilderConfig bsjConfig, IProgressMonitor monitor) 
	throws Exception {
		if(files.isEmpty()) {
			return;
		}
		
		try {
		
		BsjToolkitFactory toolkitFactory = BsjServiceRegistry.newToolkitFactory();
		toolkitFactory.setFileManager(bsjConfig.getFileManager());
		BsjToolkit toolkit = toolkitFactory.newToolkit();

		BsjCompiler compiler = toolkit.getCompiler();
		DiagnosticListener<BsjSourceLocation> diagnosticListener = null;
		
		compiler.compile(files, diagnosticListener);
		refreshGenSourceFolder(bsjConfig, monitor);
		refreshClassOutputFolder(bsjConfig, monitor);
		
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	protected void clean(IProgressMonitor monitor)
	throws CoreException {
		clean(new BSJBuilderConfig(getProject()), monitor);
	}
	
	protected void clean(BSJBuilderConfig bsjConfig, IProgressMonitor monitor)
	throws CoreException {
		// NOTE using eclipse workspace to delete generated files doesn't seem to work
		
		// delete generated java sources
		File genSrcPath = bsjConfig.getGenSourcePath().toFile();
		if(genSrcPath.exists()) {
			for(File child : genSrcPath.listFiles())
				deleteFile(child);
		}
		refreshGenSourceFolder(bsjConfig, monitor);
		
		// delete generated bsj classes
		File classOutPath = bsjConfig.getClassOutputPath().toFile();
		if(classOutPath.exists()) {
			for(File child : classOutPath.listFiles())
				deleteFile(child);
		}
		refreshClassOutputFolder(bsjConfig, monitor);
	}
	
	private final void deleteFile(File file) {
		ResourceUtilities.deleteFile(file);
	}
	
	protected void refreshGenSourceFolder(BSJBuilderConfig bsjConfig, IProgressMonitor monitor) 
	throws CoreException {
		getProject().getFolder(bsjConfig.getGenSourcePathStr())
			.refreshLocal(IResource.DEPTH_INFINITE, monitor);
	}
	
	protected void refreshClassOutputFolder(BSJBuilderConfig bsjConfig, IProgressMonitor monitor) 
	throws CoreException {
		getProject().getFolder(bsjConfig.getClassOutputPathStr())
			.refreshLocal(IResource.DEPTH_INFINITE, monitor);
	}
}
