package edu.jhu.cs.bsj.compiler.utils.generator;

import java.io.File;

/**
 * Enumerates the categories of supplement files for the source generator.
 * @author Zachary Palmer
 */
public enum SupplementCategory
{
	/** The general category (no subdirectory). */
	GENERAL(null),
	/** The node category. */
	NODE("nodes"),
	;
	
	/** The name of the subdirectory in which this supplement is found. */
	private String subdir;

	private SupplementCategory(String subdir)
	{
		this.subdir = subdir;
	}

	public String getSubdir()
	{
		return subdir;
	}
	
	/**
	 * Retrieves a path string which can be appended to a directory name to obtain a new directory name representing
	 * this category's directory.
	 * @return The subdirectory prepended by a file separator or the empty string if no subdirectory is to be used.
	 */
	public String getSubdirSuffix()
	{
		return this.subdir == null ? "" : File.separator + this.subdir;
	}
}
