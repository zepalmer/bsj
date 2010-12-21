package edu.jhu.cs.bsj.eclipse.builder;

import java.io.File;
import java.util.Collections;
import java.util.Map;

import org.eclipse.core.resources.IProject;

import edu.jhu.cs.bsj.compiler.BsjServiceRegistry;
import edu.jhu.cs.bsj.compiler.tool.filemanager.BsjCompilerLocation;
import edu.jhu.cs.bsj.compiler.tool.filemanager.BsjFileManager;
import edu.jhu.cs.bsj.compiler.tool.filemanager.BsjFileManagerFactory;
import edu.jhu.cs.bsj.compiler.tool.filemanager.LocationManager;

public class BSJBuilderConfig {
	
	private IProject bsjProject;
	
	private String sourcePathStr = "src";
	private String genSourcePathStr = "local" + File.separator + "gensrc";
	private String classPathSrc = "local" + File.separator + "bin";
	
	public BSJBuilderConfig(IProject bsjProject) {
		this.bsjProject = bsjProject;
	}
	
	public String getSourcePathStr() {
		return sourcePathStr;
	}

	public String getGenSourcePathStr() {
		return genSourcePathStr;
	}

	public String getClassPathSrc() {
		return classPathSrc;
	}
	
	public BsjFileManager getFileManager() throws Exception {
		return getFileManager(Collections.<BsjCompilerLocation, LocationManager> emptyMap(), false);
	}
	
	protected BsjFileManager getFileManager(
			Map<? extends BsjCompilerLocation, ? extends LocationManager> overrides, 
			boolean unionOverrides) throws Exception {
		
		BsjFileManagerFactory fileManagerFactory = BsjServiceRegistry
				.newFileManagerFactory();

		String projectPath = bsjProject.getFullPath().toFile().getPath();
		projectPath.replaceAll("/", File.separator);
		fileManagerFactory.setLocationManager(BsjCompilerLocation.SOURCE_PATH,
				projectPath +  File.separator + sourcePathStr);
		
		File genSourcePath = new File(projectPath + File.separator + genSourcePathStr);
		if(!genSourcePath.exists())
			genSourcePath.mkdirs();
		fileManagerFactory.setLocationManager(BsjCompilerLocation.GENERATED_SOURCE_PATH,
				genSourcePath.getPath());		
		
		File classPath = new File(projectPath + File.separator + classPathSrc);
		if(!classPath.exists())
			classPath.mkdirs();
		fileManagerFactory.setLocationManager(BsjCompilerLocation.CLASS_OUTPUT,
				classPath.getPath());
		
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
