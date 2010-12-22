package edu.jhu.cs.bsj.eclipse.util;

import java.io.File;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;

public abstract class ResourceUtilities {
	/**
	 * Deletes a JavaAPI File (including all its children)
	 * @param file a file
	 */
	public static void deleteFile(File file) {
		if(file.isDirectory())
			for(File child : file.listFiles())
				deleteFile(child);
		file.delete();
	}
	
	/**
	 * Creates a folder, creating its parent if necessary
	 * @param folder folder to create
	 * @throws CoreException if any error occurred
	 */
	public static void createFolder(IFolder folder, IProgressMonitor monitor)
	throws CoreException  {
		IContainer parent = folder.getParent();
		if (parent instanceof IFolder) {
			createFolder((IFolder) parent, monitor);
		}
		if (!folder.exists()) {
			folder.create(false, true, monitor);
		}
	}
}
