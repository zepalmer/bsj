package edu.jhu.cs.bsj.compiler.impl.tool.filemanager;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import edu.jhu.cs.bsj.compiler.tool.filemanager.BsjCompilerLocation;
import edu.jhu.cs.bsj.compiler.tool.filemanager.BsjFileManager;
import edu.jhu.cs.bsj.compiler.tool.filemanager.BsjFileManagerFactory;
import edu.jhu.cs.bsj.compiler.tool.filemanager.LocationManager;

/**
 * A standard implementation of the BSJ file manager factory.
 * 
 * @author Zachary Palmer
 */
public class BsjFileManagerFactoryImpl implements BsjFileManagerFactory
{
	/** The current location mapping. */
	private Map<BsjCompilerLocation, LocationManager> locationMap;

	/**
	 * Creates a new, unconfigured factory.
	 * 
	 * @throws IOException If path name canonicalization fails.
	 */
	public BsjFileManagerFactoryImpl() throws IOException
	{
		locationMap = new HashMap<BsjCompilerLocation, LocationManager>();
		// populate defaults
		locationMap.put(BsjCompilerLocation.CLASS_OUTPUT, new RegularFileLocationManager(null, new File(".")));
		locationMap.put(BsjCompilerLocation.GENERATED_SOURCE_PATH, new RegularFileLocationManager(null, new File(
				"./bsjsrcgen")));
		locationMap.put(BsjCompilerLocation.METAPROGRAM_CLASSPATH, new UnionLocationManager(null,
				System.getProperty("java.class.path")));
		locationMap.put(BsjCompilerLocation.METAPROGRAM_SYSTEM_CLASSPATH, new UnionLocationManager(null,
				System.getProperty("sun.boot.class.path")));
		locationMap.put(BsjCompilerLocation.OBJECT_PROGRAM_CLASSPATH, new UnionLocationManager(null,
				System.getProperty("java.class.path")));
		locationMap.put(BsjCompilerLocation.OBJECT_PROGRAM_SYSTEM_CLASSPATH, new UnionLocationManager(null,
				System.getProperty("sun.boot.class.path")));
		locationMap.put(BsjCompilerLocation.SOURCE_PATH, new RegularFileLocationManager(null, new File(".")));
	}

	@Override
	public BsjFileManager newFileManager()
	{
		return new LocationMappedFileManager(new HashMap<BsjCompilerLocation, LocationManager>(this.locationMap));
	}

	@Override
	public void setLocationManager(BsjCompilerLocation location, LocationManager manager) throws IOException
	{
		if (location == BsjCompilerLocation.METAPROGRAM_CLASSPATH)
		{
			manager = new UnionLocationManager(null, Arrays.asList(manager, new UnionLocationManager(null,
					System.getProperty("java.class.path"))));
		}
		this.locationMap.put(location, manager);
	}

	@Override
	public void setLocationManager(BsjCompilerLocation location, String path) throws IOException
	{
		this.setLocationManager(location, new UnionLocationManager(null, path));
	}

	@Override
	public void setLocationManagerMappingsByManager(Map<BsjCompilerLocation, LocationManager> mapping)
			throws IOException
	{
		for (Map.Entry<BsjCompilerLocation, LocationManager> entry : mapping.entrySet())
		{
			setLocationManager(entry.getKey(), entry.getValue());
		}
	}

	@Override
	public void setLocationManagerMappingsByPath(Map<BsjCompilerLocation, String> mapping) throws IOException
	{
		for (Map.Entry<BsjCompilerLocation, String> entry : mapping.entrySet())
		{
			setLocationManager(entry.getKey(), entry.getValue());
		}
	}
}
