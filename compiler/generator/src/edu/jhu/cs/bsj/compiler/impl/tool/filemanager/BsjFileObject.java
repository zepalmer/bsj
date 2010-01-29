package edu.jhu.cs.bsj.compiler.impl.tool.filemanager;

import javax.tools.JavaFileObject;

/**
 * This {@link JavaFileObject} extension includes functionality which makes it compatible with the BSJ
 * {@link LocationManager}-style file management system.
 * @author Zachary Palmer
 */
public interface BsjFileObject extends JavaFileObject
{
	/**
	 * Infers the binary name of this file object.  This must be possible to execute without any additional context;
	 * if the file object requires information from its location, it should hold a reference to that location or to the
	 * relevant info.
	 * @return The binary name of this file object.
	 */
	public String inferBinaryName();
	
	/**
	 * Determines whether or not this file object exists.
	 * @return <code>true</code> if the file object exists; <code>false</code> if it does not.
	 */
	public boolean exists();
}
