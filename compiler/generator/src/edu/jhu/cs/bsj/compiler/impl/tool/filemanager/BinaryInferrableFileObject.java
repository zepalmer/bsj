package edu.jhu.cs.bsj.compiler.impl.tool.filemanager;

import javax.tools.JavaFileObject;

/**
 * This {@link JavaFileObject} extension contains a method which allows a caller to infer its binary name.  This is
 * useful for file objects whose binary inference routine is independent of the location in which the file object
 * resides.
 * @author Zachary Palmer
 */
public interface BinaryInferrableFileObject extends JavaFileObject
{
	/**
	 * Infers the binary name of this file object.
	 * @return The binary name of this file object.
	 */
	public String inferBinaryName();
}
