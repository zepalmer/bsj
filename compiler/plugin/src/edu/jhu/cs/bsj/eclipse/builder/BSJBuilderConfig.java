package edu.jhu.cs.bsj.eclipse.builder;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

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
	
	private String sourcePathStr = "src";
	
	private String genSourcePathStr = "out" + File.separator + "gensrc";
	
	private String classOutputPathStr = "out" + File.separator + "bin";
	
	private String bsjJarUrlStr = "."; // TODO Set bsj jar url
	
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
	
	public URL getBsjJarUrl() {
		try {
			return new URL(bsjJarUrlStr);
		} catch (MalformedURLException e) {
			throw new RuntimeException(e);
		}
	}
	
	private BsjFileManager createFileManager() throws IOException {
		URL[] urls = new URL[] {getBsjJarUrl()};
		URLClassLoader jarClassLoader = new URLClassLoader(urls);
		
		BsjFileManagerFactory fileManagerFactory = BsjServiceRegistry.getInstance(jarClassLoader)
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
