package edu.jhu.cs.bsj.compiler.impl.tool.filemanager;

import javax.tools.JavaFileManager;
import javax.tools.StandardLocation;

/**
 * An enumeration of BSJ compiler locations.  This set of locations mirrors the {@link StandardLocation} enumeration but
 * is kept separate to avoid confusion (as, for instance, {@link StandardLocation#SOURCE_PATH} and
 * {@link BsjCompilerLocation#SOURCE_PATH} do not represent the same location).
 */
public enum BsjCompilerLocation implements JavaFileManager.Location
{
	/**
	 * The location where BSJ source files are kept.
	 */
	SOURCE_PATH(false),
	/**
	 * The location where generated object program sources are stored.
	 */
	GENERATED_SOURCE_PATH(true),
	/**
	 * The location where bytecode files should be stored.
	 */
	CLASS_OUTPUT(true),
	/**
	 * The location containing the metaprogram classpath.
	 */
	METAPROGRAM_CLASSPATH(false),
	/**
	 * The location containing the object program classpath.
	 */
	OBJECT_PROGRAM_CLASSPATH(false),
	/**
	 * The location containing the metaprogram system classpath.
	 */
	METAPROGRAM_SYSTEM_CLASSPATH(false),
	/**
	 * The location containing the object program system classpath.
	 */
	OBJECT_PROGRAM_SYSTEM_CLASSPATH(false),
	// TODO: something for annotation processors (ANNOTATION_PROCESSOR_PATH and ANNOTATION_PROCESSOR_OUTPUT)
	;
	
	/** <code>true</code> if this is an output location; </code>false</code> otherwise. */
	private boolean outputLocation;
	
	private BsjCompilerLocation(boolean outputLocation)
	{
		this.outputLocation = outputLocation;
	}

	@Override
	public String getName()
	{
		return this.toString();
	}

	@Override
	public boolean isOutputLocation()
	{
		return this.outputLocation;
	}
}