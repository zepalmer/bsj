package edu.jhu.cs.bsj.eclipse.builder;

import java.io.File;
import java.io.IOException;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;

import edu.jhu.cs.bsj.compiler.BsjServiceRegistry;
import edu.jhu.cs.bsj.compiler.tool.filemanager.BsjCompilerLocation;
import edu.jhu.cs.bsj.compiler.tool.filemanager.BsjFileManager;
import edu.jhu.cs.bsj.compiler.tool.filemanager.BsjFileManagerFactory;

/**
 * Configuration information for BSJ builder
 */
public class BSJBuilderConfig {
	
	private final String sourcePathStr = "src";
	private final String genSourcePathStr = "out" + File.separator + "gensrc";
	private final String classOutputPathStr = "out" + File.separator + "bin";
	
	private IProject bsjProject;
	private BsjFileManager bsjFileManager;
	
	public BSJBuilderConfig(IProject bsjProject) {
		this.bsjProject = bsjProject;
	}
	
	public IProject getBsjProject() {
		return bsjProject;
	}
	
	public String getProjectPathStr() {
		return bsjProject.getLocation().toFile().getPath();
	}
	
	public String getSourcePathStr() {
		return sourcePathStr;
	}

	public String getGenSourcePathStr() {
		return genSourcePathStr;
	}

	public String getClassOutputPathStr() {
		return classOutputPathStr;
	}
	
	public IPath getSourcePath() {
		return new Path(getProjectPathStr() + File.separator + getSourcePathStr());
	}
	
	public IPath getGenSourcePath() {
		return new Path(getProjectPathStr() + File.separator + getGenSourcePathStr());
	}
	
	public IPath getClassOutputPath() {
		return new Path(getProjectPathStr() + File.separator + getClassOutputPathStr());
	}
	
	public BsjFileManager getFileManager() {
		if(bsjFileManager==null) {
			try {
				bsjFileManager = createFileManager();
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
		return bsjFileManager;
	}
	
	private BsjFileManager createFileManager() throws IOException {
	    // TODO: change to permit user to provide JARs to BSJ compiler implementation - then use URLClassLoader here
		BsjFileManagerFactory fileManagerFactory = BsjServiceRegistry.getInstance()
				.newFileManagerFactory();
		String projectPath = bsjProject.getLocation().toFile().getPath();
		
		fileManagerFactory.setLocationManager(BsjCompilerLocation.SOURCE_PATH,
				projectPath +  File.separator + sourcePathStr);
		
		File genSourcePath = new File(projectPath + File.separator + genSourcePathStr);
		if(!genSourcePath.exists())
			genSourcePath.mkdirs();
		fileManagerFactory.setLocationManager(BsjCompilerLocation.GENERATED_SOURCE_PATH,
				genSourcePath.getPath());		
		
		File classOutputPath = new File(projectPath + File.separator + classOutputPathStr);
		if(!classOutputPath.exists())
			classOutputPath.mkdirs();
		fileManagerFactory.setLocationManager(BsjCompilerLocation.CLASS_OUTPUT,
				classOutputPath.getPath());
		
		fileManagerFactory.setLocationManager(BsjCompilerLocation.METAPROGRAM_SYSTEM_CLASSPATH,
				System.getProperty("sun.boot.class.path"));
		fileManagerFactory.setLocationManager(BsjCompilerLocation.METAPROGRAM_CLASSPATH,
				System.getProperty("java.class.path"));
		fileManagerFactory.setLocationManager(BsjCompilerLocation.OBJECT_PROGRAM_SYSTEM_CLASSPATH,
				System.getProperty("sun.boot.class.path"));
		fileManagerFactory.setLocationManager(BsjCompilerLocation.OBJECT_PROGRAM_CLASSPATH,
				System.getProperty("java.class.path"));
		
		return fileManagerFactory.newFileManager();
	}
	
}
