package edu.jhu.cs.bsj.compiler.tool.filemanager;

import java.io.IOException;

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
	
	/**
	 * Determines whether or not this file object is writable.
	 * @return <code>true</code> if it is possible that writing to this file could succeed; <code>false</code> if an
	 * attempt to write to this file would always fail.
	 */
	public boolean isWritable();
	
	/**
	 * Sets the contents of this file.
	 * @param charSequence The character sequence to store in this file.
	 * @throws IOException If an I/O error occurs.
	 */
	public void setCharContent(CharSequence charSequence) throws IOException;
}
