package edu.jhu.cs.bsj.compiler.tool.filemanager;

import java.io.IOException;
import java.util.Map;

import edu.jhu.cs.bsj.compiler.tool.BsjToolkit;
import edu.jhu.cs.bsj.compiler.tool.BsjToolkitFactory;

/**
 * This interface is used to allow the factory construction of BSJ file managers. This factory is used specifically to
 * allow the easy creation of file managers which are mapped by specific locations. Each location can be matched with a
 * system-dependent path string, each component of which is either a regular directory or an archive file. The created
 * file manager can then be provided to a {@link BsjToolkitFactory} to construct a {@link BsjToolkit}.
 * <p/>
 * If any of the paths of this factory are not configured, they default to standard filesystem paths as follows.
 * <table>
 * <tr>
 * <th>Location</th>
 * <th>Mapping</th>
 * <tr>
 * <tr>
 * <td>{@link BsjCompilerLocation#SOURCE_PATH}</td>
 * <td>(cwd)</td>
 * </tr>
 * <tr>
 * <td>{@link BsjCompilerLocation#GENERATED_SOURCE_PATH}</td>
 * <td>(cwd)/bsjgensrc</td>
 * </tr>
 * <tr>
 * <td>{@link BsjCompilerLocation#METAPROGRAM_CLASSPATH}</td>
 * <td>(current JVM classpath)</td>
 * </tr>
 * <tr>
 * <td>{@link BsjCompilerLocation#METAPROGRAM_SYSTEM_CLASSPATH}</td>
 * <td>(current JVM system classpath)</td>
 * </tr>
 * <tr>
 * <td>{@link BsjCompilerLocation#OBJECT_PROGRAM_CLASSPATH}</td>
 * <td>(current JVM classpath)</td>
 * </tr>
 * <tr>
 * <td>{@link BsjCompilerLocation#OBJECT_PROGRAM_SYSTEM_CLASSPATH}</td>
 * <td>(current JVM system classpath)</td>
 * </tr>
 * <tr>
 * <td>{@link BsjCompilerLocation#CLASS_OUTPUT}</td>
 * <td>(cwd)</td>
 * </tr>
 * </table>
 * 
 * @see BsjFileManager
 * @author Zachary Palmer
 */
// TODO: add defaults for annotation processor paths and such
public interface BsjFileManagerFactory
{
	/**
	 * Indicates that the given {@link BsjCompilerLocation} is handled by the specified {@link LocationManager}. The
	 * constructed file manager will contain this mapping.
	 * 
	 * @param location The location to set.
	 * @param manager The manager to use.
	 * @throws IOException If pathname canonicalization fails.
	 */
	public void setLocationManager(BsjCompilerLocation location, LocationManager manager) throws IOException;

	/**
	 * Indicates that the given {@link BsjCompilerLocation} is handled by a location manager which uses the specified
	 * path string.
	 * 
	 * @param location The location to set.
	 * @param manager The manager to use.
	 * @throws IOException If pathname canonicalization fails.
	 */
	public void setLocationManager(BsjCompilerLocation location, String path) throws IOException;

	/**
	 * Configures this factory using all of the location manager mappings in the specified map. This call is equivalent
	 * to a series of calls to {@link #setLocationManager(BsjCompilerLocation, LocationManager)} with each pair in the
	 * mapping.
	 * 
	 * @throws IOException If pathname canonicalization fails.
	 */
	public void setLocationManagerMappingsByManager(Map<BsjCompilerLocation, LocationManager> mapping)
			throws IOException;

	/**
	 * Configures this factory using all of the path string mappings in the specified map. This call is equivalent to a
	 * series of calls to {@link #setLocationManager(BsjCompilerLocation, String)} with each pair in the mapping.
	 * 
	 * @throws IOException If pathname canonicalization fails.
	 */
	public void setLocationManagerMappingsByPath(Map<BsjCompilerLocation, String> mapping) throws IOException;

	/**
	 * Creates the configured file manager.
	 * 
	 * @return The resulting file manager.
	 */
	public BsjFileManager newFileManager();
}
