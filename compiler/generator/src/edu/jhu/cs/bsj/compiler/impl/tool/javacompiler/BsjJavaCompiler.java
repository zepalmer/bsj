package edu.jhu.cs.bsj.compiler.impl.tool.javacompiler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.tools.JavaCompiler;
import javax.tools.JavaFileManager;
import javax.tools.JavaFileObject;
import javax.tools.StandardLocation;
import javax.tools.ToolProvider;
import javax.tools.JavaFileManager.Location;

import edu.jhu.cs.bsj.compiler.impl.tool.filemanager.LocationManager;
import edu.jhu.cs.bsj.compiler.impl.tool.filemanager.LocationMappedFileManager;

/**
 * TODO
 * @author Joseph Riley
 */
public class BsjJavaCompiler
{
	/**
	 * Handle to the actual java compiler.
	 */
	private JavaCompiler javaCompiler;
	
	/**
	 * The file manager for compilation.
	 */
	private JavaFileManager fileManager;
	
	/**
	 * The objects to be compiled.
	 */
	private List<JavaFileObject> fileObjects;

	/**
	 * Maps individual locations to their respective managers.
	 */
	private Map<Location, LocationManager> locationManagerMap;
	
	/**
	 * Constructor.
	 */
	public BsjJavaCompiler()
	{
		javaCompiler = ToolProvider.getSystemJavaCompiler();
		fileObjects = new ArrayList<JavaFileObject>();
		locationManagerMap = new HashMap<Location, LocationManager>();
	}
	
	/**
	 * Sets the LocationManager for the CLASS_PATH location.
	 * @param locationManager the LocationManager to use.
	 */
	public void setClasspath(LocationManager locationManager)
	{
		locationManagerMap.put(StandardLocation.CLASS_PATH, locationManager);
	}
	
	/**
	 * Sets the LocationManager for the SOURCE_PATH location.
	 * @param locationManager the LocationManager to use.
	 */
	public void setSourcepath(LocationManager locationManager)
	{
		locationManagerMap.put(StandardLocation.SOURCE_PATH, locationManager);
	}
	
	/**
	 * Sets the LocationManager for the CLASS_OUTPUT location.
	 * @param locationManager the LocationManager to use.
	 */
	public void setClassOutput(LocationManager locationManager)
	{
		locationManagerMap.put(StandardLocation.CLASS_OUTPUT, locationManager);
	}
	
	/**
	 * Sets the LocationManager for the SOURCE_OUTPUT location.
	 * @param locationManager the LocationManager to use.
	 */
	public void setSourceOutput(LocationManager locationManager)
	{
		locationManagerMap.put(StandardLocation.SOURCE_OUTPUT, locationManager);
	}
	
	/**
	 * Compiles the files in the fileObjects list using the fileManager
	 * and returns a ClassLoader.
	 * @return the ClassLoader for this compilation.
	 */
	public ClassLoader compile()
	{
		fileManager = new LocationMappedFileManager(locationManagerMap);
		javaCompiler.getTask(null, fileManager, null, null, null, fileObjects).call();
		return fileManager.getClassLoader(StandardLocation.CLASS_OUTPUT);
	}

	/**
	 * @return the fileObjects
	 */
	public List<JavaFileObject> getFileObjects()
	{
		return fileObjects;
	}

	/**
	 * @param fileObjects the fileObjects to set
	 */
	public void setFileObjects(List<JavaFileObject> fileObjects)
	{
		this.fileObjects = fileObjects;
	}

	/**
	 * @return the locationManagerMap
	 */
	public Map<Location, LocationManager> getLocationManagerMap()
	{
		return locationManagerMap;
	}

	/**
	 * @param locationManagerMap the locationManagerMap to set
	 */
	public void setLocationManagerMap(
			Map<Location, LocationManager> locationManagerMap)
	{
		this.locationManagerMap = locationManagerMap;
	}
}
