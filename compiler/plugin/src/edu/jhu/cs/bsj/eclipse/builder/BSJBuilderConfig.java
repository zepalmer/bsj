package edu.jhu.cs.bsj.eclipse.builder;

import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.resources.IProject;

import edu.jhu.cs.bsj.compiler.BsjServiceRegistry;
import edu.jhu.cs.bsj.compiler.impl.tool.filemanager.RegularFileLocationManager;
import edu.jhu.cs.bsj.compiler.impl.tool.filemanager.UnionLocationManager;
import edu.jhu.cs.bsj.compiler.tool.filemanager.BsjCompilerLocation;
import edu.jhu.cs.bsj.compiler.tool.filemanager.BsjFileManager;
import edu.jhu.cs.bsj.compiler.tool.filemanager.BsjFileManagerFactory;
import edu.jhu.cs.bsj.compiler.tool.filemanager.LocationManager;

public class BSJBuilderConfig {
	
	private IProject bsjProject;
	
	private String srcFolder = "src";
	private String genSrcFolder = "local";
	private String classFolder = "local";
	
	public BSJBuilderConfig(IProject bsjProject) {
		this.bsjProject = bsjProject;
	}
	
	public BsjFileManager getFileManager() throws Exception {
		return getFileManager(Collections.<BsjCompilerLocation, LocationManager> emptyMap(), false);
	}
	
	protected BsjFileManager getFileManager(
			Map<? extends BsjCompilerLocation, ? extends LocationManager> overrides, 
			boolean unionOverrides) throws Exception {
		
		BsjFileManagerFactory fileManagerFactory = BsjServiceRegistry
				.newFileManagerFactory();

		Map<BsjCompilerLocation, LocationManager> map = new HashMap<BsjCompilerLocation, LocationManager>();

		File test = new File("." + File.separator + "local");
		test.mkdir();

		File sourcePath = null;
		LocationManager sourceLocationManager = 
			new RegularFileLocationManager(null, sourcePath);
		File genSourcePath = null;
		LocationManager genSourceLocationManager = 
			new RegularFileLocationManager(null, genSourcePath);
		File classPath = null;
		LocationManager classLocationManager = 
			new RegularFileLocationManager(null, classPath);
		
		map.put(BsjCompilerLocation.SOURCE_PATH, sourceLocationManager);
		map.put(BsjCompilerLocation.GENERATED_SOURCE_PATH, genSourceLocationManager);
		map.put(BsjCompilerLocation.CLASS_OUTPUT, classLocationManager);

		map.put(BsjCompilerLocation.METAPROGRAM_SYSTEM_CLASSPATH,
				new UnionLocationManager(null, System
						.getProperty("sun.boot.class.path")));
		map.put(BsjCompilerLocation.METAPROGRAM_CLASSPATH,
				new UnionLocationManager(null, System
						.getProperty("java.class.path")));

		map.put(BsjCompilerLocation.OBJECT_PROGRAM_SYSTEM_CLASSPATH,
				new UnionLocationManager(null, System
						.getProperty("sun.boot.class.path")));
		map.put(BsjCompilerLocation.OBJECT_PROGRAM_CLASSPATH,
				new UnionLocationManager(null, System
						.getProperty("java.class.path")));

		if (unionOverrides) {
			map.putAll(overrides);
		} else {
			for (Map.Entry<? extends BsjCompilerLocation, ? extends LocationManager> entry : overrides
					.entrySet()) {
				LocationManager manager = new UnionLocationManager(
						null,
						Arrays.asList(map.get(entry.getKey()), entry.getValue()));
				map.put(entry.getKey(), manager);
			}
		}

		fileManagerFactory.setLocationManagerMappingsByManager(map);
		return fileManagerFactory.newFileManager();
	}
	
}
